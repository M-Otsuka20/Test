package test;

import model.dao.User_LoginDAO;
import model.entity.User;

public class UserLoginDAOTest {

	public static void main(String[] args) {
		testfindByLogin1();//成功パターンテスト
		//testfindByLogin2();//失敗パターンテスト

	}

	public static void testfindByLogin1() {
		//ユーザー情報初期化
		User useraccount = new User("miyu","19970520");
		//DAO呼出指示(UserLoginDAOのfindByLoginメソッド)
		User_LoginDAO dao = new User_LoginDAO();
		User result = dao.findByLogin(useraccount);
		//resultに格納されたデータが空ではない、かつID,PASSWORDが登録と一致した場合true
		//そうでない場合はelse以下
		if (result != null &&
				result.getId().equals("miyu") &&
				result.getPassword().equals("19970520") &&
				result.getName().equals("みゆう") &&
				result.getMail().equals("otsuka@gmail.com")) {
			System.out.println("testFindByLogin1;成功しました");

			System.out.println("testfindByLogin1:成功パターンOK");
			System.out.println(useraccount.getId() + "/" + useraccount.getPassword());
			System.out.println(useraccount.getName() + "/" + useraccount.getMail());

		} else {

			System.out.println("testfindByLogin1:成功パターンNG");
			System.out.println(useraccount.getId() + "/" + useraccount.getPassword());
			System.out.println(useraccount.getName() + "/" + useraccount.getMail());
		}

	}

}
