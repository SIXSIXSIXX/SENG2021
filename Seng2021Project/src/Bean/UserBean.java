package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName = "";
	private String password= "";
	private String phone= "";
	private String address= "";
	private String type = "";
	private List<String> pendingRequest = new ArrayList<String>();
	private List<String> acceptedRequest = new ArrayList<String>();
	private List<String> rejectedRequest = new ArrayList<String>();
	private List<String> avaiableCars = new ArrayList<String>();
	private String currentList = "pending";
	public UserBean(){
		
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<String> getPendingRequest() {
		return pendingRequest;
	}

	public void setPendingRequest(String str) {
		this.pendingRequest.add(str);
	}
	
	public void setPendingRequestList(List<String> list) {
		this.pendingRequest = list;
	}
	
	
	public void setAcceptedRequestList(List<String> list) {
		this.acceptedRequest = list;
	}
	
	
	public void setRejectRequestList(List<String> list) {
		this.rejectedRequest = list;
	}
	
	
	public void removePendingRequest(String str){
		this.pendingRequest.remove(str);
	}
	public List<String> getAcceptedRequest() {
		return acceptedRequest;
	}

	public void setAcceptedRequest(String str) {
		this.acceptedRequest.add(str);
	}
	public void removeAcceptedRequest(String str){
		this.removeAcceptedRequest(str);
	}
	public List<String> getRejectedRequest() {
		return rejectedRequest;
	}

	public void setRejectedRequest(String str) {
		this.rejectedRequest.add(str);
	}
	public void removeRejectedRequest(String str){
		this.rejectedRequest.remove(str);
	}

	public List<String> getAvaiableCars() {
		return avaiableCars;
	}


	public void setAvaiableCars(String str) {
		this.avaiableCars.add(str);
	}
	public void removeAvaiableCars(String str){
		this.avaiableCars.remove(str);
	}
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCurrentList() {
		return currentList;
	}


	public void setCurrentList(String currentList) {
		this.currentList = currentList;
	}

	public List<String> getDisplayList(){
		if(this.currentList=="pending") return this.pendingRequest;
		else if(this.currentList=="accepted") return this.acceptedRequest;
		else return this.rejectedRequest;

	}
}
