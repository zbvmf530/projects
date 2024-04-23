package chap13;
import java.util.*;
public class MapExam595 {

	public static void main(String[] args) 
	{
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		System.out.println("총 Entry 수: "+map.size());
		
		
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) 
		{
			String key = keyIterator.next();
			System.out.print(key+"(key) : "+map.get(key)+"(value)\t");
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry 수: "+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
		
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+"\t");
		}
		System.out.println();
		map.clear();
		System.out.println("총 Entry 수: "+map.size());
	}
}
