package tk.patrickweb.model;

public class Acess {

	private Integer id;

	private String name;

	private Integer level;

	public Acess() {
		super();
	}
	
	public Acess(Integer id) {
		super();
		this.id = id;
	}

	public Acess(String name, Integer level) {
		super();
		this.name = name;
		this.level = level;
	}

	public Acess(Integer id, String name, Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
