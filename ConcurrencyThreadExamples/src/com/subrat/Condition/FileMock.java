package com.subrat.Condition;

public class FileMock {
	private String[] content;
	private int index;
	
	public FileMock(int length, int size){
		
		content= new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer= new StringBuilder(length);
			for(int j=0;j<length;j++){
				int indices= (int) (Math.random()*255);
				buffer.append((char)indices);
			}
			content[i]=buffer.toString();
			
		}
		index=0;
		}
	
	public boolean hasMoreLines(){
		return index<content.length;
	}
	
	public String getLine(){
		
		if(this.hasMoreLines()){
			System.out.println("Mock: "+(content.length-index));
			return content[index+1];
		}
		return null;
	}
}
