package com.tokuhausu.changeseats_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.tokuhausu.changeseats_lib.human.Human;
import com.tokuhausu.changeseats_lib.human.Member;

public class Main {
	public static void main(String[] args){
		String[] groups = {"boy","girl"};
		Human[] boys = {new Human("boy",1,1),new Human("boy",2,2),new Human("boy",3,3)};
		Human[] girls = {new Human("girl",1,4),new Human("girl",2,5),new Human("girl",3,6)};
		HashMap<String,List<Human>> member = new HashMap<String,List<Human>>();
		List<Human> p_1 = new ArrayList<>();
		List<Human> p_2 = new ArrayList<>();
		p_1.addAll(Arrays.asList(boys));
		p_2.addAll(Arrays.asList(girls));
		member.put(groups[0], p_1);
		member.put(groups[1], p_2);

		List<Integer> param_1 = new ArrayList<>();
		List<Integer> param_2 = new ArrayList<>();
		HashMap<String,List<Human>> param_3 = new HashMap<>();

		Integer[] seats =  {1,2,3,4,5,6};

		param_1.addAll(Arrays.asList(seats));
		param_2.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
		param_3.put("boy",Arrays.asList(new Human[]{boys[2]}));
		param_3.put("girl",Arrays.asList(new Human[]{girls[1]}));


		Member result = ChangeLib.Chagnge(member,param_1,param_2,param_3);
		System.out.println(result);
		HashMap<String,List<Integer>> seats_group = new HashMap<>();
		List<Integer> p_3 = new ArrayList<>();
		List<Integer> p_4 = new ArrayList<>();
		p_3.addAll(Arrays.asList(new Integer[]{1,4,6}));
		p_4.addAll(Arrays.asList(new Integer[]{2,3,5}));
		seats_group.put("boy", p_3);
		seats_group.put("girl", p_4);
		List<Human> Value= ChangeLib.setSeat(boys.length+girls.length, result, seats_group, param_2);
		System.out.println(Value);
	}
}
