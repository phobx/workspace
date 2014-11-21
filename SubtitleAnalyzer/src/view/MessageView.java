package view;

public class MessageView implements View {

	private String message;

	public MessageView(String message) {
		this.message = message;
	}

	public void show() {
		System.out.println(message);
	}

}
