package com.tokuhausu.changeseats_lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tokuhausu.changeseats_lib.human.Human;
import com.tokuhausu.changeseats_lib.library.Library;

public class ChangeLib {
		public static LinkedHashMap<String,List<Human>> Chagnge(HashMap<String,List<Human>> member,List<Integer> seat,List<Integer> special_seat,HashMap<String,List<Human>> special_person){
			/*仕様
			 * @parameter
			 * ArrayList member : メンバーの番号とグループ
			 * *Human
			 *
			 * ArrayList seat : 席番号一覧
			 * *Integer 席番号
			 *
			 *
			 * ArrayList special_seat
			 * *特別席(前の席)の番号
			 *
			 * ArrayList special_person
			 * *特別席に座る人の通し番号
			 */

			//席と席に座る人の人数比較
			if(seat.size() >= member.size()){
				//定員オーバー
			}
			if(special_seat.size() >= special_person.size()){
				//定員オーバー
			}

			//特別席の人を消す
			for(Entry<String,List<Human>> entry:member.entrySet()){
				List<Human> list = entry.getValue();
				for(Entry<String,List<Human>> entry2:special_person.entrySet()){
					for(Human human:entry2.getValue()){
						list.remove(human);
					}
				}
			}

			LinkedHashMap<String,List<Human>> result = new LinkedHashMap<String,List<Human>>();

			//特別席を抽選
			for(Entry<String,List<Human>> entry:special_person.entrySet()){
				Collections.shuffle(entry.getValue());
				result.put("SpHu_"+entry.getKey(),entry.getValue() );
			}

			//通常席を抽選
			for(Entry<String,List<Human>> entry:member.entrySet()){
				result.put(entry.getKey(), entry.getValue());
				Collections.shuffle(result.get(entry.getKey()));
			}

			return result;
		}
		public static void setSeat(int number_of_people,LinkedHashMap<String,List<Human>> member,HashMap<String,List<Integer>> seats,List<Integer> special_seat){
			/*仕様
			 * @parameter
			 * int number_of_people
			 * *人数
			 *
			 * LinkedHashMap<String,List<Human>> member
			 * *Changeの戻り値
			 *
			 *
			 * HashMap<String,List<Integer>> seats
			 * *String : グループ
			 * *List<Human> : 席番号
			 *
			 * ArrayList special_seat
			 * *特別席の番号
			 */

			if(number_of_people == Library.SizeSum(member)){
				//人数が不正
			}
			//特別席から抽選
			for(Entry<String,List<Human>> entry:member.entrySet()){
				if(entry.getKey().contains("SPHu_")){
					
				}
			}
		}
}
