package dataBase;

public class Model {
	private int styleId;
	private String modelName;
	private String TransmissionType;
	private String bodyType; 
	private String drivenWheels;
	private int numDoors;
	private String eName;
	private String eType;
	private int hPower;
	private int torque;
	private double price;
	private float displacement;
	private double rate;
	private String make;
	public Model(){
		
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getTransmissionType() {
		return TransmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		TransmissionType = transmissionType;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getDrivenWheels() {
		return drivenWheels;
	}
	public void setDrivenWheels(String drivenWheels) {
		this.drivenWheels = drivenWheels;
	}
	public int getNumDoors() {
		return numDoors;
	}
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteType() {
		return eType;
	}
	public void seteType(String eType) {
		this.eType = eType;
	}
	public int gethPower() {
		return hPower;
	}
	public void sethPower(int hPower) {
		this.hPower = hPower;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStyleId() {
		return styleId;
	}
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public void printData(){
		System.out.println("styleID"+this.styleId);
		System.out.println("modelName"+this.modelName);
		System.out.println("body"+this.bodyType);
		System.out.println("displacement"+this.displacement);
		System.out.println("driven"+this.drivenWheels);
		System.out.println("eName"+this.eName);
		System.out.println("eType"+this.eType);
		System.out.println("hPower"+this.hPower);
		System.out.println("numDoors"+this.numDoors);
		System.out.println("torque"+this.torque);
		System.out.println("TransmissionType"+this.TransmissionType);
		System.out.println("price"+this.price);

		
	}
	public float getDisplacement() {
		return displacement;
	}
	public void setDisplacement(float displacement) {
		this.displacement = displacement;
	}
	public boolean modelinPrice(int lp, int hp){
		if(hp==0){
			return true;
		}
		else{
			if(this.getPrice()>=lp&&this.getPrice()<=hp){
				return true;
			}
		}
		return false;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
}
