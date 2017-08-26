package dataBase;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class SAXParserCar extends DefaultHandler{
	private Makes makes =null;
	private Model model = null;
	private StringBuilder content = new StringBuilder();
	private String current=null;
	private Make make = null;
	public SAXParserCar(Makes makes){
		this.makes = makes;
	}
	
	public ArrayList<Make> getList(){
		return makes.getMakes();
				
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("make")){
			make = new Make(attributes.getValue("makeName"));
			current = make.getMakeName();
			this.makes.addMake(make);
		}
		else if(qName.equals("model")){
			this.model = new Model();
			this.model.setMake(current);
		}
		else{
			content = new StringBuilder();
		}
}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "styleId":
			model.setStyleId(Integer.parseInt(content.toString()));
		case "modelName":
			model.setModelName(content.toString());
			break;
		case "transmissionType":
			model.setTransmissionType(content.toString());
			break;
		case "body":
			model.setBodyType(content.toString());
			break;
		case "drivenWheels":
			model.setDrivenWheels(content.toString());
			break;
		case "numOfDoor":
			if(content.toString().equals("None")){
				model.setNumDoors(0);
			}
			else
			model.setNumDoors(Integer.parseInt(content.toString()));
			break;
		case "engineName":
			model.seteName(content.toString());
			break;
		case "engineType":
			model.seteType(content.toString());
			break;
		case "horsePower":
			if(content.toString().equals("None")){
				model.sethPower(0);
			}
			else
			model.sethPower(Integer.parseInt(content.toString()));
			break;							
		case "torque":
			if(content.toString().equals("None")){
				model.setTorque(0);
			}
			else
			model.setTorque(Integer.parseInt(content.toString()));
			break;
		case "basePrice":
			if(content.toString().equals("None")){
				model.setPrice(0);
			}
			else
			model.setPrice(Double.parseDouble(content.toString()));
			break;
		case "model":
			int flag =0;
			for(Make m:makes.getMakes()){
				if(m.getMakeName().equals(current)){
					for(Model mo:m.getModels()){
						if(mo.getModelName().equals(model.getModelName())&&mo.geteName().equals(model.geteName())){
							flag = 1;
							break;
						}
					}
					if(flag==0){
						m.addModel(model);
					}
					break;
				}
			}
			break;
		//add more case here
		case "displacement":
			if(content.toString().equals("None")){
				model.setDisplacement(0);
			}
			else{
				model.setDisplacement(Float.parseFloat(content.toString()));
			}
			break;
		}
		//content = new StringBuilder();
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		content.append(new String(ch,start,length));


	}


}
