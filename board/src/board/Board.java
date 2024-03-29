package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
	private final int JOIN = 1;
	private final int DELETE_USER = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int UPDATE_PASSWORD = 5;

	private final int POSTING = 1;
	private final int READ_POST = 2;
	private final int MODIFY_POST = 3;
	private final int DELETE_POST = 4;

	private final int USER = 1;
	private final int POST = 2;

	private static int log = -1;

	private static UserManager userManager;
	private static PostManager postManager;

	private static ArrayList<User> userlist;

	private static ArrayList<HashMap<String, Post>> board;

	public Board() {
		board = new ArrayList<HashMap<String, Post>>();
		userlist = new ArrayList<User>();
		userManager = new UserManager();
		postManager = new PostManager();
	}

	public static ArrayList<User> getUserlist() {
		return userlist;
	}
	public static PostManager getPostManager() {
		return postManager;
	}

	public static ArrayList<HashMap<String, Post>> getBoard() {
		return board;
	}

	public static int getLog() {
		return log;
	}

	public static void setLog(int log) {
		Board.log = log;
	}

	public void run() {
		while (true) {
			printMenu();
			int select = inputNumber("menu");
			runMenu(select);
		}
	}

	private void runMenu(int select) {
		if (select == USER) {
			printUserSubmenu();
			int option = inputNumber("menu");
			runUserSubmenu(option);
		} else if (select == POST && isLogin()) {
			printPostSubmenu();
			int option = inputNumber("menu");
			runPostSubmenu(option);
		}
	}

	private boolean isLogin() {
		if (log == -1) {
			System.out.println("로그인 후 이용하세요");
			return false;
		}
		return true;
	}

	private void runPostSubmenu(int option) {
		User user = userlist.get(log);
		if (option == POSTING) {
			postManager.posting(user);
		} else if (option == READ_POST) {
			postManager.readPost();
		} else if (option == MODIFY_POST) {
			postManager.modifyPost(user);
		} else if (option == DELETE_POST) {
			postManager.deletePost(user);
		}
	}

	private void runUserSubmenu(int option) {
		if (option == JOIN && isLogout()) {
			userManager.join();
		} else if (option == DELETE_USER && isLogin()) {
			userManager.deleteUser();
		} else if (option == LOGIN && isLogout()) {
			userManager.login();
		} else if (option == LOGOUT && isLogin()) {
			userManager.logout();
		} else if (option == UPDATE_PASSWORD && isLogin()) {
			userManager.updatePassword();
		}
	}

	private boolean isLogout() {
		if (log != -1) {
			System.out.println("로그아웃 후 이용하세요");
			return false;
		}
		return true;
	}

	public static int inputNumber(String message) {
		int number = 0;
		System.out.println(message + " : ");
		try {
			String numberString = new Scanner(System.in).next();
			number = Integer.parseInt(numberString);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
			return inputNumber(message);
		}
		return number;
	}

	private void printMenu() {
		System.out.println("===========================");
		System.out.println("현재 로그인 : " + (log == -1 ? "none" : userlist.get(log).getId()));
		System.out.println("===========================");
		System.out.println("유저게시판");
		System.out.println("===========================");
		System.out.println("1.회원 메뉴");
		System.out.println("2.게시글 메뉴");
		System.out.println("===========================");

	}

	private void printPostSubmenu() {
		System.out.println("1.글쓰기");
		System.out.println("2.조회");
		System.out.println("3.수정");
		System.out.println("4.글 삭제");
	}

	private void printUserSubmenu() {
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.회원정보 변경");
	}

}
