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
		String id = inputString("id");
		User user = findUserById(id);
		if (user == null) {
			System.out.println("아이디가 없습니다.");
			return;
		}
		String password = inputString("password");
		if (isValid(user,password)) {
			int log = userlist.indexOf(user);
			Board.setLog(log);
			System.out.println("로그인이 완료되었습니다.");
		}
	}

	private boolean isValid(User user, String password) {
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	private User findUserById(String id) {
		User user = null;
		for (int i = 0; i < userlist.size(); i++) {
			if (id.equals(userlist.get(i).getId())) {
				user = userlist.get(i);
				return user;
			}
		}
		return null;
	}

	@Override
	public void logout() {
		Board.setLog(-1);
		System.out.println("로그아웃이 완료 되었습니다.");
	}

	public void modifyUser() {
		
	}
	
}
