package board;

import java.util.ArrayList;
import java.util.HashMap;

public class PostManager implements PostMethod {
	private ArrayList<HashMap<String, Post>> board = Board.getBoard();
	private ArrayList<User> userlist = Board.getUserlist();

	@Override
	public void posting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readPost() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyPost() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePost() {
		// TODO Auto-generated method stub

	}

}
