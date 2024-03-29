package board;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager implements UserMethod{

	private ArrayList<User> userlist = Board.getUserlist();
	
	@Override
	public void join() {
		User user = createUser();
		if (user == null) {
			System.out.println("중복 아이디 입니다.");
			return;
		}
		userlist.add(user);
		System.out.println(String.format("%s님 가입이 완료 되었습니다.", user.getId()));
	}

	private User createUser() {
		User user = null;
		String id = inputString("id");
		if (!isDuplicatedId(id)) {
			String password = inputString("password");
			user = new User(id, password);
			return user;
		}
		return null;
	}

	private boolean isDuplicatedId(String id) {
		for (int i = 0; i < userlist.size(); i++) {
			if (id.equals(userlist.get(i).getId())) {
				return true;
			}
		}
		return false;
	}

	private String inputString(String message) {
		System.out.println(message + " : ");
		
		return new Scanner(System.in).next();
	}

	@Override
	public void deleteUser() {
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public void modifyUser() {
		// TODO Auto-generated method stub
		
	}
	
}
