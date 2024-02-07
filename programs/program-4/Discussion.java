public class Discussion {
    public int rec(int[] list) {
        return rec3(list, 0);
    }

    public int rec3(int[] list, int start) {
        if (start == list.length - 1) {
            return list[start];
        } else {
            return Math.max(list[start], rec3(list, start + 1));
        }
    }

    public static void main(String[] args) {
        int[] list = { 1, 3, 5, 7, 9 };
        Discussion d = new Discussion();
        System.out.println(d.rec(list));
    }
}
