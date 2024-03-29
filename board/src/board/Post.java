package board;

public class Post {
	
	private int number;
	
	private int pageNumber;
	private String id;
	private String title;
	private String text;
	
	public Post(int number, String id, String title, String text) {
		this.number = number;
		this.id = id;
		this.title = title;
		this.text = text;
		this.pageNumber = number/5;
	}
	
	@Override
	public String toString() {
		String data = String.format("[%d] %s \n", this.number, this.title);
		data += String.format("작성자 : %s \n", this.id);
		data += String.format("%s ", this.text);
		return data;
	}
}
