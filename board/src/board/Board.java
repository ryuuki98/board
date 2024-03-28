package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
	private int log;

	private UserManager userManager;

	private ArrayList<HashMap<String, Text>> board;

	public Board() {
		board = new ArrayList<HashMap<String, Text>>();
		userManager = new UserManager();
	}

	public void run() {
		while (true) {
			printMenu();
			int select = inputNumber("menu");
		}
	}

	private int inputNumber(String message) {
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
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.글쓰기");
		System.out.println("6.조회");
		System.out.println("7.수정");
		System.out.println("8.글 삭제");
	}

}
