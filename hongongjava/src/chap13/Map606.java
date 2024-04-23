package chap13;
import java.util.*;
public class Map606 {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore=0, totalScore = 0;
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> set : entrySet)
		{
			totalScore += set.getValue();
			if(maxScore<set.getValue()) 
			{
				maxScore = set.getValue();
				name = set.getKey();
			}
		}
		//entrySet.forEach((key,value)->{maxScore=maxScore<value?value:maxScore;});
		System.out.println("평균점수 : " + totalScore/entrySet.size());
		System.out.println("최고점수 : " + maxScore);
		System.out.println("최고점수를 받은 아이디 : " + name);
	}

}
