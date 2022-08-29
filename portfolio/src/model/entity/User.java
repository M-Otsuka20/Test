package model.entity;

public class User {
	String id;
	String password;
	String name;
	String mail;

	//ユーザー情報のコンストラクタ(新規登録時に使用)
	public User(String id, String password, String name, String mail) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.mail = mail;

	}

	//ログイン情報のコンストラクタを作るために用意
	public User() {
		super();
	}

	//ログイン情報のコンストラクタを作るために用意
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	//各項目getterとsetter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setuserId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
