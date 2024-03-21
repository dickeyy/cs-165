import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * QueueTestProgram tests IQueue instances for correctness by comparing their behavior
 * to ArrayBlockingQueue as a reference implementation.
 * <p>
 * This program is an example of generative testing: it generates test scenarios ad infinitum.
 * <p>
 * created by cspfrederick Fall17
 */
public class QueueTestProgram {
    public static final int queue_max_size = 10;

    public static void printFailedTests(int test_count,
                                        IntFunction<Queue<Integer>> referenceSupplier,
                                        IntFunction<IQueue<Integer>> testSubjectSupplier) {
        System.out.printf("Testing queues with a maximum capacity of %d.\n", queue_max_size);
        List<Map<String, Object>> failed = runTests(test_count, 5,
                referenceSupplier, testSubjectSupplier);
        if (failed.isEmpty()) {
            System.out.println(String.format("No bugs found after: %,d test cases!", test_count));
            return;
        }

        for (Map<String, Object> fail : failed) {
            Exception ex = (Exception) fail.get("exception");
            System.out.println();
            System.out.println(ex.getClass().getSimpleName());
            System.out.println(ex.getMessage());

            @SuppressWarnings("unchecked")
            List<List<Object>> shrunk = (List<List<Object>>) fail.get("shrunk");
            List<String> methodCalls = shrunk.stream().map(list -> {
                String args_list = list.subList(1, list.size()).toString();
                return String.format("%s(%s)", list.get(0),
                        args_list.substring(1, args_list.length() - 1));
            }).collect(Collectors.toList());

            System.out.println("Method calls that expose bug: " + methodCalls);
        }
    }

    public static Map<String, Object> runTest(long seed,
                                              IntFunction<Queue<Integer>> referenceSupplier,
                                              IntFunction<IQueue<Integer>> testSubjectSupplier) {
        Map<String, Object> thePlan = Plan.plan(seed, queue_max_size);

        List<List<Object>> theScript = Script.script(thePlan);

        Map<String, Object> result = Eval.eval(theScript,
                referenceSupplier.apply(queue_max_size), testSubjectSupplier.apply(queue_max_size));

        thePlan.putAll(result);
        thePlan.put("script", theScript);
        return thePlan;
    }


    public static <E> List<E> listOfFirst(int n, Queue<E> q) {
        List<E> ret = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ret.add(q.poll());
        return ret;
    }

    public static List<Map<String, Object>> runTests(int test_count, int returned_failures_count,
                                                     IntFunction<Queue<Integer>> referenceSupplier,
                                                     IntFunction<IQueue<Integer>> testSubjectSupplier) {
        PriorityQueue<Map<String, Object>> failing =
                new PriorityQueue<>(10 /*capacity hint*/,
                        Comparator.comparingInt(m -> {
                            @SuppressWarnings("unchecked")
                            List<List<Object>> script = (List<List<Object>>) m.get("shrunk");
                            int script_weight = script.size();

                            for (List<Object> action : script)
                                if ("fill-to".equals(action.get(0)))
                                    script_weight += 15 + (Integer) action.get(1); // avoid meta-actions if possible
                            return script_weight;
                        }));

        Random seedGenerator = new SecureRandom();
        for (int i = 0; i <= test_count; i++) {
            if (i % (test_count / 10) == 0)
                System.out.println("Tested: " + i);

            long seed = seedGenerator.nextLong();
            Map<String, Object> r = runTest(seed, referenceSupplier, testSubjectSupplier);

            if (r.containsKey("exception")) {
                @SuppressWarnings("unchecked")
                List<List<Object>> script = (List<List<Object>>) r.get("script");

                List<List<Object>> shrunk = Shrink.shrink(script,
                        () -> referenceSupplier.apply(queue_max_size),
                        () -> testSubjectSupplier.apply(queue_max_size));

                Map<String, Object> shrunk_r = Eval.eval(shrunk,
                        referenceSupplier.apply(queue_max_size),
                        testSubjectSupplier.apply(queue_max_size));

                r.put("shrunk", shrunk);
                r.putAll(shrunk_r);
                failing.add(r);

                if (failing.size() > returned_failures_count * 30) break;
            }
        }

        int failed_size = Math.min(returned_failures_count, failing.size());
        List<Map<String, Object>> failed = listOfFirst(failed_size, failing);
        return failed;
    }
}

class Plan {
    public static long keyed(long seed, String s) {
        return new Random(seed).longs().skip(Math.abs(s.hashCode()) % 128).findFirst().getAsLong();
    }

    public static int waypointCount(long seed) {
        double d = new Random(keyed(seed, "number of waypoints")).nextGaussian();
        return (int) Math.ceil(3 * d * d);
    }

    public static int runLength(long seed) {
        double d = new Random(keyed(seed, "length of run from a waypoint")).nextGaussian();
        d = Math.abs(d + 1) * 20 + 5;
        if (d > 40) d *= 3;
        return (int) d;
    }

    public static double around(double baseline, double gaus) {
        return Math.abs(baseline + gaus * baseline / 4);
    }

    public static List<String> actionsByPosition =
            Arrays.asList("add", "offer", "poll", "remove",
                    "peek", "element", "isEmpty", "size", "clear", "contains");

    public static List<Double> cumulativeProbabilitySums(long seed) {
        List<Double> probs = new ArrayList<>();
        Random r = new Random(keyed(seed, "cumulative probability sums"));

        probs.add(around(14, r.nextGaussian())); // add
        probs.add(around(14, r.nextGaussian())); // offer
        probs.add(around(14, r.nextGaussian())); // poll
        probs.add(around(14, r.nextGaussian())); // remove
        probs.add(around(14, r.nextGaussian())); // peek
        probs.add(around(14, r.nextGaussian())); // element
        probs.add(around(5, r.nextGaussian())); // isEmpty
        probs.add(around(5, r.nextGaussian())); // size
        probs.add(around(1, r.nextGaussian())); // clear
        probs.add(around(4, r.nextGaussian())); // contains

        // make relative [0, 1)
        double sum = probs.stream().reduce(0.0, Double::sum);
        double cumulative = 0;
        for (int i = 0; i < probs.size(); i++) {
            double d = probs.get(i) / sum;
            cumulative += d;
            probs.set(i, cumulative);
        }
        probs.set(probs.size() - 1, 1.0);
        return probs;
    }

    public static double clamp(double d, double min, double max) {
        return Math.min(max, Math.max(min, d));
    }

    public static int fillTarget(int max_size, double gaus) {
        double d = Math.round(around(max_size, gaus));
        if (d >= max_size) d -= max_size;
        return (int) clamp(d, 0, max_size);
    }

    public static List<Integer> waypoints(long seed, int waypointCount, int max_size) {
        List<Integer> pts = new ArrayList<>();
        Random r = new Random(keyed(seed, "waypoint fill targets"));
        for (int i = 0; i < waypointCount; i++) {
            pts.add(fillTarget(max_size, r.nextGaussian()));
        }
        return pts;
    }

    public static Map<String, Object> plan(long seed, int max_size) {
        Map<String, Object> plan = new TreeMap<>();
        plan.put("seed", seed);
        plan.put("maxSize", max_size);
        int waypointCount = waypointCount(seed);
        plan.put("waypoint-count", waypointCount);
        plan.put("run-length", runLength(seed));
        plan.put("action-probabilities", cumulativeProbabilitySums(seed));
        plan.put("fill-targets", waypoints(seed, waypointCount, max_size));
        plan.put("run-seeds", new Random(keyed(seed, "seeds for each run"))
                .longs(waypointCount)
                .boxed().collect(Collectors.toCollection(ArrayList<Long>::new)));
        return plan;
    }
}

class Script {
    public static int positionInSort(List<Double> sorted, double d) {
        for (int i = 0; i < sorted.size(); i++)
            if (d < sorted.get(i))
                return i;
        return sorted.size();
    }

    public static int nextElement(double gaus) {
        double d = Math.abs(gaus + 1.25) * 10 + 1;
        return (int) d;
    }

    public static void addScriptRun(long seed, int fill_target, List<List<Object>> script, Map<String, Object> plan) {
        int run_length = (Integer) plan.get("run-length");
        @SuppressWarnings("unchecked")
        List<Double> probs = (List<Double>) plan.get("action-probabilities");
        script.add(Arrays.asList("fill-to", fill_target));

        Random r = new Random(seed);
        for (int i = 0; i < run_length; i++) {
            String action = Plan.actionsByPosition.get(positionInSort(probs, r.nextDouble()));

            if (action.equals("add") || action.equals("offer") || action.equals("contains"))
                script.add(Arrays.asList(action, nextElement(r.nextGaussian())));
            else
                script.add(Collections.singletonList(action));
        }
    }

    @SuppressWarnings("unchecked")
    public static List<List<Object>> script(Map<String, Object> plan) {
        List<List<Object>> script = new ArrayList<>();
        int points = (Integer) plan.get("waypoint-count");

        for (int pt = 0; pt < points; pt++) {
            long seed = ((List<Long>) plan.get("run-seeds")).get(pt);
            int fill_target = ((List<Integer>) plan.get("fill-targets")).get(pt);
            addScriptRun(seed, fill_target, script, plan);
        }
        return script;
    }
}

class Eval {
    public static Object catchExceptionsToString(Supplier<Object> fn) {
        try {
            return fn.get();
        } catch (Exception e) {
            return e.getClass().getSimpleName();
        }
    }

    public static String formatException(Object ref, Object sub, String action, Object... args) {
        String exceptionFormat = "%s.%s(%s) => %%s, but..\n%s.%s(%s) => %%s";
        String args_str = Arrays.toString(args);
        args_str = args_str.substring(1, args_str.length() - 1);
        return String.format(exceptionFormat,
                ref.getClass().getSimpleName(), action, args_str,
                sub.getClass().getSimpleName(), action, args_str);
    }

    public static void evalAdd(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer arg = (Integer) action.get(1);
        Object r = catchExceptionsToString(() -> ref.add(arg));
        Object s = catchExceptionsToString(() -> {
            sub.add(arg);
            return true;
        });
        if (!r.equals(s))
            throw new RuntimeException(String.format(formatException(ref, sub, "add", arg), r, s));
    }

    public static void evalRemove(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Object r = catchExceptionsToString(ref::remove);
        Object s = catchExceptionsToString(sub::remove);
        if (!r.equals(s))
            throw new RuntimeException(String.format(formatException(ref, sub, "remove"), r, s));
    }

    public static void evalElement(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Object r = catchExceptionsToString(ref::element);
        Object s = catchExceptionsToString(sub::element);
        if (!r.equals(s))
            throw new RuntimeException(String.format(formatException(ref, sub, "element"), r, s));
    }

    public static void evalOffer(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer arg = (Integer) action.get(1);
        Object r = catchExceptionsToString(() -> ref.offer(arg));
        Object s = catchExceptionsToString(() -> sub.offer(arg));
        if (!r.equals(s))
            throw new RuntimeException(String.format(formatException(ref, sub, "offer", arg), r, s));
    }

    public static void evalPoll(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer r = ref.poll();
        Integer s = sub.poll();
        if (r != s) // purposeful
            if (r == null || !r.equals(s))
                throw new RuntimeException(String.format(formatException(ref, sub, "poll"), r, s));
    }

    public static void evalPeek(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer r = ref.peek();
        Integer s = sub.peek();
        if (r != s) // purposeful
            if (r == null || !r.equals(s))
                throw new RuntimeException(String.format(formatException(ref, sub, "peek"), r, s));
    }

    public static void evalContains(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer arg = (Integer) action.get(1);
        boolean r = ref.contains(arg);
        boolean s = sub.contains(arg);
        if (r != s)
            throw new RuntimeException(String.format(formatException(ref, sub, "contains", arg), r, s));
    }

    public static void evalEmpty(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        boolean r = ref.isEmpty();
        boolean s = sub.isEmpty();
        if (r != s)
            throw new RuntimeException(String.format(formatException(ref, sub, "isEmpty"), r, s));
    }

    public static void evalSize(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        int r = ref.size();
        int s = sub.size();
        if (r != s)
            throw new RuntimeException(String.format(formatException(ref, sub, "size"), r, s));
    }

    public static void evalFillTo(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        Integer target = (Integer) action.get(1);
        int diff = target - ref.size();
        if (diff >= 0) {
            for (int i = 0; i < diff; i++)
                evalOffer(Arrays.asList("offer", i), ref, sub);
        } else {
            for (int i = 0; i < Math.abs(diff); i++)
                evalPoll(Arrays.asList("poll", i), ref, sub);
        }
        if (ref.size() != target)
            throw new Error("Failed to execute fillTo correctly on reference. Test code needs debugging.");
        evalSize(Collections.singletonList("size"), ref, sub);
    }

    public static void evalAction(List<Object> action, Queue<Integer> ref, IQueue<Integer> sub) {
        String symbol = (String) action.get(0);
        switch (symbol) {
            case "fill-to":
                evalFillTo(action, ref, sub);
                break;
            case "add":
                evalAdd(action, ref, sub);
                break;
            case "offer":
                evalOffer(action, ref, sub);
                break;
            case "poll":
                evalPoll(action, ref, sub);
                break;
            case "remove":
                evalRemove(action, ref, sub);
                break;
            case "peek":
                evalPeek(action, ref, sub);
                break;
            case "element":
                evalElement(action, ref, sub);
                break;
            case "isEmpty":
                evalEmpty(action, ref, sub);
                break;
            case "size":
                evalSize(action, ref, sub);
                break;
            case "clear":
                ref.clear();
                sub.clear();
                break;
            case "contains":
                evalContains(action, ref, sub);
                break;
        }
    }

    public static Map<String, Object> eval(List<List<Object>> script,
                                           Queue<Integer> reference, IQueue<Integer> subject) {
        for (int i = 0; i < script.size(); i++) {
            try {
                evalAction(script.get(i), reference, subject);
            } catch (Exception e) {
                Map<String, Object> result = new TreeMap<>();
                result.put("exception", e);
                result.put("exception-simple-name", e.getClass().getSimpleName());
                result.put("exception-script-index", i);
                return result;
            }
        }
        return new TreeMap<>();
    }
}

class Shrink {
    public static List<List<Object>> shrinkCutFront(List<List<Object>> script,
                                                    Function<List<List<Object>>, Boolean> eval_failed) {
        List<List<Object>> scriptCut = script.subList(1, script.size());
        while (eval_failed.apply(scriptCut)) {
            script = scriptCut;
            scriptCut = script.subList(1, script.size());
        }
        return script;
    }

    public static <E> List<E> removedPos(List<E> list, int i) {
        ArrayList<E> ret = list.stream().limit(i).collect(Collectors.toCollection(ArrayList::new));
        ret.addAll(list.subList(i + 1, list.size()));
        return ret;
    }

    private static List<List<Object>> shrinkCutPosHelper(List<List<Object>> script,
                                                         Function<List<List<Object>>, Boolean> eval_failed) {
        for (int i = 0; i < script.size(); i++) {
            List<List<Object>> scriptCut = removedPos(script, i);
            if (eval_failed.apply(scriptCut)) {
                return scriptCut;
            }
        }
        return null;
    }

    public static List<List<Object>> shrinkCutPos(List<List<Object>> script,
                                                  Function<List<List<Object>>, Boolean> eval_failed) {
        List<List<Object>> scriptCut = shrinkCutPosHelper(script, eval_failed);
        while (script.size() > 2 && scriptCut != null) {
            script = scriptCut;
            scriptCut = shrinkCutPosHelper(script, eval_failed);
        }
        return script;
    }

    public static List<List<Object>> shrinkTrim(List<List<Object>> script,
                                                Function<List<List<Object>>, Map<String, Object>> eval) {
        Map<String, Object> r = eval.apply(script);
        return script.stream().limit((Integer) r.get("exception-script-index") + 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<List<Object>> shrink(List<List<Object>> script,
                                            Supplier<Queue<Integer>> referenceSupplier,
                                            Supplier<IQueue<Integer>> testSubjectSupplier) {
        Function<List<List<Object>>, Map<String, Object>> eval = (s) -> Eval.eval(s,
                referenceSupplier.get(),
                testSubjectSupplier.get());
        Function<List<List<Object>>, Boolean> eval_failed = eval.andThen(m -> m.containsKey("exception"));

        script = shrinkTrim(script, eval);
        script = shrinkCutFront(script, eval_failed);
        script = shrinkCutPos(script, eval_failed);

        return script;
    }
}
