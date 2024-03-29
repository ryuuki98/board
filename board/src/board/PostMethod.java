package board;

public interface PostMethod {
	public void posting(User user);
	public void readPost();
	public void modifyPost(User user);
	public void deletePost(User user);
}
