package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostManager implements PostMethod {
	private ArrayList<HashMap<String, Post>> board = Board.getBoard();
	private ArrayList<User> userlist = Board.getUserlist();

	@Override
	public void posting(User user) {
		int number = board.size();
		String id = user.getId();
		String title = inputString("title");
		String text = inputString("text");
		
		Post post = new Post(number,id,title,text);
		HashMap<String, Post> posting = new HashMap<String, Post>();
		posting.put(user.getId(), post);
		board.add(posting);
		System.out.println("글이 게시 되었습니다.");
		System.out.println(post);
	}

	private String inputString(String message) {
		System.out.println(message + " : ");
		return new Scanner(System.in).nextLine();
	}

	@Override
	public void readPost() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyPost(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePost(User user) {
		// TODO Auto-generated method stub

	}

}
