package dataBase;

import java.util.ArrayList;

public class Make {
	private String makeName;
	private ArrayList<Model> models = null;
	private double highestPrice;
	private double lowestPrice;
	private int highestTorque;
	private int highesthPower;
	private int lowestTouque;
	private int lowesthPower;
	private float highestDisplacement;
	private float lowestDisplacement;
	
	public Make(String name){
		this.makeName = name;
		models = new ArrayList<Model>();
	}
	public String getMakeName() {
		return makeName;
	}
	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	public ArrayList<Model> getModels() {
		return models;
	}
	public void setModels(ArrayList<Model> models) {
		this.models = models;
	}
	public void addModel(Model model){
		models.add(model);
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public int getHighestTorque() {
		return highestTorque;
	}
	public void setHighestTorque(int highestTorque) {
		this.highestTorque = highestTorque;
	}
	public int getHighesthPower() {
		return highesthPower;
	}
	public void setHighesthPower(int highesthPower) {
		this.highesthPower = highesthPower;
	}
	public int getLowestTouque() {
		return lowestTouque;
	}
	public void setLowestTouque(int lowestTouque) {
		this.lowestTouque = lowestTouque;
	}
	public int getLowesthPower() {
		return lowesthPower;
	}
	public void setLowesthPower(int lowesthPower) {
		this.lowesthPower = lowesthPower;
	}
	public float getHighestDisplacement() {
		return highestDisplacement;
	}
	public void setHighestDisplacement(float highestDisplacement) {
		this.highestDisplacement = highestDisplacement;
	}
	public float getLowestDisplacement() {
		return lowestDisplacement;
	}
	public void setLowestDisplacement(float lowestDisplacement) {
		this.lowestDisplacement = lowestDisplacement;
	}
	public void largestPrice(){
		double price=0;
		for(Model model:this.getModels()){
			if(model.getPrice()>price){
				price = model.getPrice();
			}
		}
	this.setHighestPrice(price);
	}
	public void lowestPrice(){
		double price=this.getModels().get(0).getPrice();
		for(Model model:this.getModels()){
			if(model.getPrice()<price){
				price = model.getPrice();
			}
		}
		this.setLowestPrice(price);
	}
	public void highestTorque(){
		int torque=0;
		for(Model model:this.getModels()){
			if(model.getTorque()>torque){
				torque = model.getTorque();
			}
		}
		this.setHighestTorque(torque);
	}
	public void lowestTorque(){
		int torque=this.getModels().get(0).getTorque();
		for(Model model:this.getModels()){
			if(model.getTorque()<torque){
				torque = model.getTorque();
			}
		}
		this.setLowestTouque(torque);
	}
	public void highestHpower(){
		int hPower=0;
		for(Model model:this.getModels()){
			if(model.gethPower()>hPower){
				hPower = model.gethPower();
			}
		}
		this.setHighesthPower(hPower);
	}
	public void lowestHpower(){
		int hPower=this.getModels().get(0).gethPower();
		for(Model model:this.getModels()){
			if(model.gethPower()<hPower){
				hPower = model.gethPower();
			}
		}
		this.setLowesthPower(hPower);
	}
	public void highestDisplacement(){
		float displacement=0;
		for(Model model:this.getModels()){
			if(model.getDisplacement()>displacement){
				displacement = model.getDisplacement();
			}
		}
		this.setHighestDisplacement(displacement);
	}
	public void lowestDisplacement(){
		float displacement=this.getModels().get(0).getDisplacement();
		for(Model model:this.getModels()){
			if(model.getDisplacement()<displacement){
				displacement = model.getDisplacement();
			}
		}
		this.setLowestDisplacement(displacement);
	}
	
	public ArrayList<Model> getCorrectPriceModelList(int lp,int hp){
		ArrayList<Model> model = new ArrayList<Model>();
		if(hp==0){
			return this.getModels();
		}
		for(Model m:this.getModels()){
			if(m.getPrice()>=lp&&m.getPrice()<=hp){
				model.add(m);
			}
		}
		return model;
	}
	public void printHighlow(){
		System.out.println("HPrice"+this.getHighestPrice()+"\n"+"LPrice"+this.getLowestPrice()+"\n"+"HTorque"+this.getHighestTorque()+"\n"+"LTorque"+this.getLowestTouque()+"\n"+"Hpower"+this.getHighesthPower()+"\n"+"Lpower"+this.getLowesthPower()+"\n"+"HDisplacement"+this.getHighestDisplacement()+"\n"+"LDispalcement"+this.getLowesthPower());
	}
}
