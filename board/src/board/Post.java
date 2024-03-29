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
		this.pageNumber = number == 0 ? 0 : number/5;
	}
	
	public int getNumber() {
		return number;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
	
	public void setNumber(int number) {
		this.number = number;
		this.pageNumber = number == 0 ? 0 : number/5;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		String data = String.format("[%d] %s \n", this.number, this.title);
		data += String.format("작성자 : %s \n", this.id);
		data += String.format("%s ", this.text);
		return data;
	}
}
