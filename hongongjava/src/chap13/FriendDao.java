package chap13;

import java.util.ArrayList;
import java.util.List;

public class FriendDao {

	List<Friend> fri = new ArrayList<Friend>();
	
	FriendDao()
	{
		fri.add(new Friend("권준오","010-1111-2222","경산"));
		fri.add(new Friend("김도겸","010-2222-3333","범어동"));
		fri.add(new Friend("김진형","010-3333-4444","수성구"));
		fri.add(new Friend("배동규","010-5252-4356","송현동"));
		fri.add(new Friend("최석원","010-2567-6798","중앙로"));
	}
	List<Friend> getFriendList(){return fri;}
	
	
	
}
