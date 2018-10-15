package tk.patrickweb.model;

public class Record {
	
	private Integer id;
	
	private String date;
	
	private String note;
	
	private User user;

	public Record() {
		super();
	}

	public Record(Integer id, String date, String note, User user) {
		super();
		this.id = id;
		this.date = date;
		this.note = note;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
