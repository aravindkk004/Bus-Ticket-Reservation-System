package reservationSystem;

public class Bus {
	private int busNo;
	private boolean ac;
	private int capacity;
	
	Bus(int no, boolean ac, int cap){
		this.busNo = no;
		this.ac = ac;
		this.capacity = cap;
	}
	
	public int getCapacity(){  //accessor method
		return capacity;
	}
	public void setCapacity(int cap) {    //mutator
		capacity = cap;
	}
	public int getBusNo() {
		return busNo;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean Ac) {
		ac = Ac;
	}
	
	public void displayBusInfo() {
		System.out.println("-------------------------------------------");
		System.out.println("|      "+busNo+"      |   "+ac+"   |       "+capacity+"      |");
		System.out.println("-------------------------------------------");
	}
}
