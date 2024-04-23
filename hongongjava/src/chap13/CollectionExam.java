package chap13;

import java.util.*;

public class CollectionExam {

	List<Board> tList = new Vector<Board>();
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		
//		list.add("Java");
//		list.add("JDBC");
//		list.add("Servlet/JSP");
//		list.add(2,"Database");
//		list.add("iBATIS");
//		
//		int size=list.size();
//		System.out.println("총 객체 수: "+size);
//		System.out.println();
//		
//		String skill=list.get(2);
//		System.out.println("2: "+skill);
//		System.out.println();
//
//		for(int i=0;i<list.size();i++){System.out.print(i + ": " + list.get(i) + " ");}
//		System.out.println();
//		System.out.println();
//		
//		list.remove(2);
//		list.remove(2);
//		list.remove("iBATIS");
//		
//		list = list.reversed();
//		for(String ele:list){System.out.print(list.indexOf(ele)+": " + ele + " ");}
		
//		CollectionExam test = new CollectionExam();
//		subThread st = new subThread();
//		Thread subThread = st;
//		
//		
//		test.tList = new Vector<Board>();
//		test.tList.add(new Board("제목1", "내용1", "글쓴이1"));
//		test.tList.add(new Board("제목2", "내용2", "글쓴이2"));
//		test.tList.add(new Board("제목3", "내용3", "글쓴이3"));
//		st.setList(test.tList);
//		
//		List<Board> list = new Vector<Board>();
//		
//	
//		try 
//		{
//			int rn = (int)(Math.random()*3);
//			list.add(test.tList.get(rn));
//			System.out.print("메인 리스트: ");
//			for(int i=0;i<list.size();i++)
//			{System.out.print(list.get(i)+"\t");}
//			Thread.sleep(1000);
//		}catch(InterruptedException e) {}
//	
//		st.start();
//		System.out.println();
//		for(int i=0;i<list.size();i++)
//		{System.out.print(list.get(i)+"\t");}
////		list.add(new Board("제목1", "내용1", "글쓴이1"));
////		list.add(new Board("제목2", "내용2", "글쓴이2"));
////		list.add(new Board("제목3", "내용3", "글쓴이3"));
////		list.add(new Board("제목4", "내용4", "글쓴이4"));
////		list.add(new Board("제목5", "내용5", "글쓴이5"));
////		
////		list.remove(2);
////		list.remove(3);
////		
//		for(int i=0; i<list.size();i++)
//		{System.out.println(list.get(i).subject+"\t"+list.get(i).content+"\t"+list.get(i).writer+"\t");}
		
//		BoardDao dao= new BoardDao();
//		List<Board> list = dao.getBoardList();
//		for(Board board : list) {System.out.println(board.subject+"-"+board.content);}
		
//		FriendDao dao= new FriendDao();
//		List<Friend> list = dao.getFriendList();
//		for(Friend friend : list) {System.out.println(friend);}
		
//		Set<String> set = new HashSet<String>();
//		
//		set.add("Java");
//		set.add("JDBC");
//		set.add("Servlet/JSP");
//		set.add("Java");
//		set.add("iBATIS");
//		
//		System.out.println("총 객체 수: "+set.size());
//		
//		Iterator<String> iterator = set.iterator();
//		while(iterator.hasNext()){System.out.print(iterator.next()+"\t");}
//		System.out.println();
//		set.remove("JDBC");
//		set.remove("iBATIS");
//		System.out.println("총 객체 수: "+set.size());
//		
//		for(String ele : set) {System.out.print(ele+"\t");}
	
//		Set<Member> set = new HashSet<Member>();
//		
//		set.add(new Member("홍길동",30));
//		set.add(new Member("홍길동",35));
//		set.add(new Member("성춘향",25));
//		set.add(new Member("성춘향",30));
//		
//		System.out.println("총 객체 수 : "+set.size());
//		
//		// set 출력
//		// Iterator 이용
//		Iterator<Member> iterator = set.iterator();
//		while(iterator.hasNext()) {System.out.print(iterator.next()+"\t");}
//		System.out.println();
//		// 향상 for문 이용
//		for(Member ele : set) {System.out.print(ele + "\t");}
		
		
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {System.out.println(iterator.next());}
	}
	

}
