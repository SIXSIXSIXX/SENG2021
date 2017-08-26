package dataBase;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Makes {
	private static ArrayList<Make> makes = null;
	private static List<String> bodyType  = new ArrayList<String>();
	private static List<String> makeNameList  = new ArrayList<String>();	
	public Makes(){
		makes = new ArrayList<Make>();
		
	}
	
	public static void findbodyType(){
		for(Make make: makes){
			for(Model m : make.getModels()){
				if(!bodyType.contains(m.getBodyType())){
					bodyType.add(m.getBodyType());
				}				
			}
		}
	}
	
	public static void getAllElement() throws SAXException, IOException{
		if (makes == null) {
			
			XMLReader p = XMLReaderFactory.createXMLReader();
			SAXParserCar car = new SAXParserCar(new Makes());
			p.setContentHandler(car);
			p.parse("/Users/corgiii/Documents/JS/Seng2021Project/cars.xml");
			findbodyType();
			findMakeNameList();
			//writeThePotoToFile();
		}
		
	}
	
	private static void writeThePotoToFile() throws IOException {
		int count = 0;
		for(Make m: makes){
			for(Model mod : m.getModels()){
				api.PhotoApi.getPhoto(String.valueOf(mod.getStyleId()));
				count++;
			}
		}
		System.out.println(count);
		
	}

	public static List<String> getBodyType() {
		return bodyType;
	}

	public static List<String> getMakeNameList() throws SAXException, IOException {
		System.out.println("safasfsad");
		getAllElement();
		List<String> b = new ArrayList<String>();
		for(String a: makeNameList){
			a.toString();
			a = a.replaceAll(" "," ");
			b.add(a);
		}
		makeNameList = b;
		return makeNameList;
	}

	public static void findMakeNameList(){
		for(Make make: makes){
			makeNameList.add(make.getMakeName());
		}
	}
	
	public void addMake(Make make){
		makes.add(make);
	}
	public static ArrayList<Make> getMakes() {
		return makes;
	}
	public void setMakes(ArrayList<Make> makes) {
		Makes.makes = makes;
	}
	
	
	
	public static ArrayList<Model> XIAJIBASearch(String make,String model,String transmission,String bodyType,String driven,int lowestP,int highestP){
		ArrayList<Model> models = new ArrayList<Model>();
		if(make.equals("")){
			if(make.equals("")&&bodyType.equals("")&&driven.equals("")&&!transmission.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getTransmissionType().equals(transmission)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
		}
		else if(make.equals("")&&transmission.equals("")&&driven.equals("")&&!bodyType.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
		}
		else if(make.equals("")&&transmission.equals("")&&bodyType.equals("")&&!driven.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
		}
		else if(make.equals("")&&transmission.equals("")&&bodyType.equals("")&&driven.equals("")){
			for(Make m:makes){
				models.addAll(m.getCorrectPriceModelList(lowestP, highestP));
			}
		}
		else if(driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getTransmissionType().equals(transmission)&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
		}
		else if(!driven.equals("")&&!transmission.equals("")&&bodyType.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getTransmissionType().equals(transmission)&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
		}
		else if(!driven.equals("")&&transmission.equals("")&&!bodyType.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getBodyType().equals(bodyType)&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
			
		}
		else if(!driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
			for(Make m:makes){
				for(Model mo:m.getModels()){
					if(mo.getTransmissionType().equals(transmission)&&mo.getBodyType().equals(bodyType)&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
						models.add(mo);
					}
				}
			}
			
		}
		}
		else if(!make.equals("")){
			if(!model.equals("")){
				if(driven.equals("")&&!transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getTransmissionType().equals(transmission)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
			
		
				else if(driven.equals("")&&transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}	
				}
				else if(driven.equals("")&&transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&!transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getDrivenWheels().equals(driven)&&mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getDrivenWheels().equals(driven)&&mo.getModelName().toLowerCase().contains(model.toLowerCase())&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
			}
			else if(model.equals("")){
				if(driven.equals("")&&!transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
			
		
				else if(driven.equals("")&&transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									;
								}
							}
						}
					}	
				}
				else if(driven.equals("")&&transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&!transmission.equals("")&&bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getDrivenWheels().equals(driven)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getDrivenWheels().equals(driven)&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
				else if(!driven.equals("")&&!transmission.equals("")&&!bodyType.equals("")){
					for(Make m:makes){
						if(m.getMakeName().contains(make)){
							for(Model mo: m.getModels()){
								if(mo.getTransmissionType().equals(transmission)&&mo.getDrivenWheels().equals(driven)&&mo.getBodyType().equals(bodyType)&&mo.modelinPrice(lowestP, highestP)){
									models.add(mo);
									
								}
							}
						}
					}
				}
			}
			}
		return models;
	}
	public static ArrayList<Model> XIAJIBARecommend(ArrayList<Model> models,double P,double fe,double hpower,double t){
		 P = P/100;
		 fe = fe/100;
		 hpower = hpower/100;
		 t = t /100;
		 double lp = lowestPriceInArray(models);
		 double hp = highestPriceInArray(models);
		 double diffp = hp-lp;
		 double ldis = lowestDisInArray(models);
		 double hdis = highestDisInArray(models);
		 double  diffdis =hdis-ldis;
		 int lhp = lowesthpInArray(models);
		 int hhp = highesthpInArray(models);
		 int diffhp = hhp-lhp;
		 int lt = lowesttInArray(models);
		 int ht = highesttInArray(models);
		 int difft = ht -lt;
		 for(int k =0;k<models.size();k++){
			 if(models.get(k).getDisplacement()==0||models.get(k).getTorque()==0||models.get(k).gethPower()==0){
				 models.remove(models.get(k));
				 k--;
			 }
		 }
		 for(Model model:models){
			 double rate = (double)((1-(model.getPrice()-lp)/diffp)) * P+(double)((1-(model.getDisplacement()-ldis)/diffdis))*fe+ (double)((model.gethPower()-lhp))/diffhp*hpower+(double)((model.getTorque()-lt))/difft*t;
			 model.setRate(Math.round(rate*10000)/100.0d);  
			
		 }
		 for(int i = 0;i<models.size();i++){
			 for(int j =1;j<models.size()-i;j++){
				 if(models.get(j-1).getRate()<models.get(j).getRate()){
					 Model temp = models.get(j-1);
					 models.set(j-1, models.get(j));
					 models.set(j, temp);
				 }
			 }
		 }

		 
		 for(int i = models.size()-1; i>100 ; i--){
			 models.remove(i);
		 }


		 return models;
	}
	public static double lowestPriceInArray(ArrayList<Model> models){
		double current=models.get(0).getPrice();
		for(Model model:models){
			if(model.getPrice()<current){
				current = model.getPrice();
			}
		}
		return current;
	}
	
	public static double highestPriceInArray(ArrayList<Model> models){
		double current=models.get(0).getPrice();
		for(Model model:models){
			if(model.getPrice()>current){
				current = model.getPrice();
			}
		}
		return current;
	}
	
	public static double lowestDisInArray(ArrayList<Model> models){
		double current=models.get(0).getDisplacement();
		for(Model model:models){
			if(model.getDisplacement()<current){
				current = model.getDisplacement();
			}
		}
		return current;
	}
	
	public static double highestDisInArray(ArrayList<Model> models){
		double current=models.get(0).getDisplacement();
		for(Model model:models){
			if(model.getDisplacement()>current){
				current = model.getDisplacement();
			}
		}
		return current;
	}
	
	public static int lowesthpInArray(ArrayList<Model> models){
		int current=models.get(0).gethPower();
		for(Model model:models){
			if(model.gethPower()<current){
				current = model.gethPower();
			}
		}
		return current;
	}
	
	public static int highesthpInArray(ArrayList<Model> models){
		int current=models.get(0).gethPower();
		for(Model model:models){
			if(model.gethPower()>current){
				current = model.gethPower();
			}
		}
		return current;
	}
	
	public static int lowesttInArray(ArrayList<Model> models){
		int current=models.get(0).getTorque();
		for(Model model:models){
			if(model.getTorque()<current){
				current = model.getTorque();
			}
		}
		return current;
	}
	public static int highesttInArray(ArrayList<Model> models){
		int current=models.get(0).getTorque();
		for(Model model:models){
			if(model.getTorque()>current){
				current = model.getTorque();
			}
		}
		return current;
	}
	
	public static Model getModel(int id){
		for(Make make:makes){
			for(Model model:make.getModels()){
				if(model.getStyleId()==id){
					return model;
				}
			}
		}
		return null;
	}
	
	
	public static ArrayList<String> getModelList(String makeName){
		ArrayList<String> models = new ArrayList<String>();
		for(Make make:makes){
			if(make.getMakeName().equals(makeName)){
				for(Model model:make.getModels()){
					if(models.contains(model.getModelName())){
						continue;
				}
					models.add(model.getModelName());
			}
				break;
			}
		}
		return models;
	}
	
	public static String[] getIDByModels(String[] makes,String[] models){
		int i = 0;
		int flag = 0;
		String[] result = new String[1];
		for(String currMake: makes){
			flag = 0;
			for(Make make: Makes.makes){
				if(!make.getMakeName().equals(currMake)) continue;
				for(Model model: make.getModels()){
					if(!model.getModelName().equals(models[i])) continue;
					result[i]=String.valueOf(model.getStyleId());
					flag = 1;
					break;
				}
				if(flag ==1 ) break;
			}
			i++;
		}
		return result;
	}
}
