package hashbrowns.p1.orm.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hashbrowns.p1.orm.utils.ConnectDB;

public class Postgres implements PostgresDao {

	private ConnectDB connUtil = ConnectDB.getConnectionDB();

	@Override
	public void insertSQL(String sql) {

		try (Connection conn = connUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public String selectSQL(String sql) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return null;
	}

	@Override
	public void updateSQL(String sql) {

		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteSQL(String sql) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
