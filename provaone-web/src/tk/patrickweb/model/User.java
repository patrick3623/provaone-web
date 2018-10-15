package tk.patrickweb.model;

public class User {

	private Integer id;

	private String name;

	private String email;

	private String password;

	private Acess acess;

	public User() {
		super();
	}

	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public User(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(Integer id, String name, String email, String password, Acess acess) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.acess = acess;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Acess getAcess() {
		return acess;
	}

	public void setAcess(Acess acess) {
		this.acess = acess;
	}

}
