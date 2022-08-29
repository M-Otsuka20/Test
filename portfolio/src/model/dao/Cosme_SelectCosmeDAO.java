package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Cosme;

public class Cosme_SelectCosmeDAO {

	//データベースURL
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/portfolio?useSSL=false";
	//ユーザー名
	private final String DB_USER = "root";
	//パスワード
	private final String DB_PASS = "root";

	//商品コードからコスメの商品情報を検索
	public Cosme findCosme(Cosme cosme) {

		Cosme pick_cosme = new Cosme();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {
				String sql = "SELECT * FROM cosmedata WHERE code=?";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, cosme.getMakercode());

				System.out.println("コスメDAO＝" + cosme.getMakercode());

				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					String code = rs.getString("code");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					String category = rs.getString("category");
					int stock = rs.getInt("stock");
					String maker = rs.getString("maker");
					String makercode = rs.getString("makercode");

					pick_cosme = new Cosme(code, name, price, category, stock, maker, makercode);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // 見つかったユーザーまたはnullを返す
		return pick_cosme;
	}
}