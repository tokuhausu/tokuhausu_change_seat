package com.tokuhausu.changeseats_lib.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Library {
	public static int SizeSum(LinkedHashMap<?,?> param){
		int result = 0;
		for(List<Object> list:((LinkedHashMap<?,List<Object>>)param).values()){
			result = result+ list.size();
		}
		return result;
	}
	public static List<Integer> contains(List<Integer> listA,List<Integer> listB){
         // listAの要素をHashMapに詰める
         Map<Integer,Integer> mapT = new HashMap<>();
         for (Integer obje : listA) {
              mapT.put(obje,obje);
         }

         // listBの要素がHashMapに含まれていればlistC2に要素を追加
         List<Integer> listC2 = new ArrayList<Integer>();
         for (Integer obje : listB) {
              if(mapT.containsKey(obje)) {
                   listC2.add(obje);
              }
         }
         return listC2;
	}

}
