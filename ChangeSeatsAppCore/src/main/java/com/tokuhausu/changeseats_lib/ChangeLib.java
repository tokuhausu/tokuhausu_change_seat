package com.tokuhausu.changeseats_lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import org.apache.commons.collections4.ListUtils;

import com.tokuhausu.changeseats_lib.human.Human;
import com.tokuhausu.changeseats_lib.human.Member;
import com.tokuhausu.changeseats_lib.library.Library;

public class ChangeLib {
		public static Member Chagnge(HashMap<String,List<Human>> member,List<Integer> seat,List<Integer> special_seat,HashMap<String,List<Human>> special_person){
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

			LinkedHashMap<String,List<Human>> result_1 = new LinkedHashMap<String,List<Human>>();
			LinkedHashMap<String,List<Human>> result_2 = new LinkedHashMap<String,List<Human>>();

			//特別席を抽選
			for(Entry<String,List<Human>> entry:special_person.entrySet()){
				Collections.shuffle(entry.getValue());
				result_1.put(entry.getKey(),entry.getValue() );
			}

			//通常席を抽選
			for(Entry<String,List<Human>> entry:member.entrySet()){
				result_2.put(entry.getKey(), entry.getValue());
				Collections.shuffle(result_2.get(entry.getKey()));
			}

			return new Member(result_2,result_1);
		}
		public static List<Human> setSeat(int number_of_people,Member member,HashMap<String,List<Integer>> seats,List<Integer> special_seat){
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

			List<Human> result = new ArrayList<>();
			IntStream.range(0, number_of_people).forEach(i -> result.add(null));
			if(number_of_people != Library.SizeSum(member)){
				//人数が不正
				System.out.println("人数が不正です");
				return null;
			}
			for(List<Integer> list : seats.values()){
				Collections.shuffle(list);
			}
			Collections.shuffle(special_seat);
			System.out.println(seats);
			//特別席から割り振り
			for(Entry<String,List<Human>> entry:member.getSpecial().entrySet()){
				for(Human human:entry.getValue()){
						ListUtils.intersection(seats.get(entry.getKey()), special_seat).stream().limit(1).forEach(i -> {
						result.set(i-1, human);
						seats.get(human.getGroup()).remove(new Integer(i));
					});
				}
			}
			//通常席に割り振り
			for(Entry<String,List<Human>> entry:member.getMember().entrySet()){
				for(Human human:entry.getValue()){
					result.set(seats.get(entry.getKey()).get(0)-1, human);
					seats.get(human.getGroup()).remove(new Integer(seats.get(entry.getKey()).get(0)));
				}
			}
			return result;
		}

}
