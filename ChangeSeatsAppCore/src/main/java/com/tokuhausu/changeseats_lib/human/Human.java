package com.tokuhausu.changeseats_lib.human;

public class Human {
	private String group;
	private int number_group;
	private int number_serial;

	public Human(String group,int number_group,int number_serial){
		this.group = group;
		this.number_group = number_group;
		this.number_serial = number_serial;
	}
	@Override
	public String toString(){
		//return "group="+group+",number_sirial="+number_serial+",number_group="+number_group;
		return ""+number_serial;
	}
	public String getGroup(){
		return this.group;
	}
	public int getGroupNumber(){
		return this.number_group;
	}
	public int getSerialNumber(){
		return this.number_serial;
	}
}
