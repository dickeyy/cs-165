/*
 * This class is used for testing ArrayQueue using an Object other than Integers and Strings
 */
public class TrainCar {
	
	String type;
	String color;
	int id;
	
	public TrainCar(String type, String color, int id) {
		this.type = type;
		this.color = color;
		this.id = id;
	}

	public boolean equals(Object o) {
		if (!(o instanceof TrainCar)) {
			return false;
		}
		TrainCar c = (TrainCar) o;
		
		return this.type.equals(c.type) && this.id == c.id;
	}
	
	public String toString() {
		return color + " " + type + ": " + id;
	}
	 public int hashCode() {
        return super.hashCode();
    }
	
	public static void main(String[] args) {
		
	}

	
}
