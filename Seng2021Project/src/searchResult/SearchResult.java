package searchResult;


import java.util.ArrayList;
import java.util.List;

import dataBase.Model;


public class SearchResult {
	
	private static List<Model> modelList= new ArrayList<Model>();
	private static int index = 0;
	private static int length = 0;
	
		   
	public List<Model> getSearchData() {
		return modelList;
	}
	
	public static void setSearchData(List<Model> modelList) {
		SearchResult.modelList = modelList;
		length = SearchResult.modelList.size();
		SearchResult.index = 0;
	}
	
   
   public static int hiddenButton(){
	   int value = 0;
	   if(index<10) value += 1;
	   
	   if(length<index+10) value+=2;
	   return value;
   }




/**
   ** Count the index back x position
   */
   public static void previous(){
	   if(index>=10) index = index-10; 
   }
   
   /**
   ** Count the index forward x position
   */
   public static void next(){
	   if((modelList.size()-(index+10))>0){
		   index = index+10;
		   
	   }
   }
	   
   /**
   * Return the SearchData from index and x position forward
   */
   public static List<Model> getData() {
	   if(modelList.size() == 0) return modelList;
	   if(modelList.size()-(index+10)>=0){
		   return modelList.subList(index, index+10);
	   }
	   else return modelList.subList(index, modelList.size());
   }
	   


 }

