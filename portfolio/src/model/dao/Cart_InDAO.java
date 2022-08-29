package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Cosme;

public class Cart_InDAO {

	//データベースURL
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/portfolio?useSSL=false";
	//ユーザー名
	private final String DB_USER = "root";
	//パスワード
	private final String DB_PASS = "root";

	//カートに入れる
	public Cosme Cart_In(Cosme cosme) {

		Cosme item = null;
		ArrayList<Cosme> list_kari = null;

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.jdbc.Driver");

			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {

				// INSERT文を準備
				String sql =  "SELECT * FROM cosmedata WHERE code=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cosme.getCode());

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					String code = rs.getString("code");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					String category = rs.getString("category");
					int stock = rs.getInt("stock");
					String maker = rs.getString("maker");
					String makercode = rs.getString("makercode");
					item = new Cosme(code, name, price, category, stock, maker, makercode);

					// SELECTを実行し、カートに入れる(カートの中にコスメデータをコピー)
					pstmt.executeUpdate();

					System.out.println("カートの中" + item.getName());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return item;

	}

}
