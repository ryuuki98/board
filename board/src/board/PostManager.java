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

		Post post = new Post(number, id, title, text);
		HashMap<String, Post> posting = new HashMap<String, Post>();
		posting.put(user.getId(), post);
		board.add(posting);
		System.out.println("글이 게시 되었습니다.");
	}

	private String inputString(String message) {
		System.out.println(message + " : ");
		return new Scanner(System.in).nextLine();
	}

	@Override
	public void readPost() {
		int currentPageNumber = 0;
		while (true) {
			System.out.println("현재 페이지 : " + currentPageNumber);
			printPage(currentPageNumber);
			System.out.println("이전페이지 : a , 다음페이지 : d , 종료 : q");
			String input = inputString("index");

			if (input.equals("a") && currentPageNumber > 0) {
				currentPageNumber--;
			} else if (input.equals("d") && currentPageNumber < board.size() / 5) {
				currentPageNumber++;
			} else if (input.equals("q")) {
				break;
			} else {
				try {
					int index = Integer.parseInt(input);
					HashMap<String, Post> posting = board.get(index);
					for (Post post : posting.values()) {
						System.out.println(post);
					}
				} catch (Exception e) {
					System.out.println("입력을 다시 확인해주세요.");
				}
			}
		}
	}

	private void printPage(int currentPageNumber) {
		for (int i = 0; i < board.size(); i++) {
			HashMap<String, Post> posting = board.get(i);
			for (Post post : posting.values()) {
				if (post.getPageNumber() == currentPageNumber) {
					System.out.println(i + ") " + post.getTitle());
				}
			}
		}
	}

	@Override
	public void modifyPost(User user) {
		printUserPostAll(user);

		int index = Board.inputNumber("index");
		HashMap<String, Post> posting = board.get(index);
		Post post = posting.get(user.getId());
		post.setText(inputString("text"));
		System.out.println(post);
		System.out.println("수정이 완료 되었습니다.");
	}

	private void printUserPostAll(User user) {
		for (int i = 0; i < board.size(); i++) {
			HashMap<String, Post> posting = board.get(i);
			Post post = posting.get(user.getId());
			if (post != null) {
				System.out.println(i + ") " + post.getTitle());
			}
		}
	}

	@Override
	public void deletePost(User user) {
		printUserPostAll(user);
		int index = Board.inputNumber("index");
		board.remove(index);
		updateNumber();
		System.out.println("삭제가 완료 되었습니다.");
	}

	private void updateNumber() {
		for (int i = 0; i < board.size(); i++) {
			for (Post post : board.get(i).values())
				post.setNumber(i);
		}
	}

}
