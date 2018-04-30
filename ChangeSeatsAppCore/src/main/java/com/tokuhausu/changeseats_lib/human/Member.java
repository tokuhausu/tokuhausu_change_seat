package com.tokuhausu.changeseats_lib.human;

import java.util.LinkedHashMap;
import java.util.List;

public class Member {
	private LinkedHashMap<String,List<Human>> normal;
	private LinkedHashMap<String,List<Human>> special;

	public Member(LinkedHashMap<String,List<Human>> normal,LinkedHashMap<String,List<Human>> special){
		this.normal = normal;
		this.special = special;
	}
	public LinkedHashMap<String,List<Human>> getMember(){
		return this.normal;
	}
	public LinkedHashMap<String,List<Human>> getSpecial(){
		return this.special;
	}
	@Override
	public String toString(){
		return normal.toString()+"\n"+special.toString();
	}
}