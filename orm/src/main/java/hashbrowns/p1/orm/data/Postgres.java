package hashbrowns.p1.orm.data;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import hashbrowns.p1.orm.annotations.id;
import hashbrowns.p1.orm.annotations.ignore;
import hashbrowns.p1.orm.utils.ConnectDB;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class Postgres implements PostgresDao {

	private ConnectDB connUtil = ConnectDB.getConnectionDB();

	@Override
	public Object insertSQL(String sql, Object object) {

		try (Connection conn = connUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return object;

	}

	@Override
	public Object selectSQL(String sql, Object object) {
		try (Connection conn = connUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				Class<?> clazz = object.getClass();
				Field[] fields = clazz.getDeclaredFields();
				Stream<Field> strArray = Arrays.stream(fields);

				strArray.forEach(field -> {

					field.setAccessible(true);
					try {

						if (!field.isAnnotationPresent(ignore.class) & !field.isAnnotationPresent(id.class)) {

							Map<String, String> map = new HashMap<>();
							map.put(field.getName(), resultSet.getString(field.getName()));

							for (String i : map.keySet()) {
								System.out.println(i + " - " + map.get(i));
								field.set(object, map.get(i));
							}
						}
					} catch (Exception e) {
						// e.printStackTrace();
					}

				});

			} else {
				System.out.println("null object");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return object;
	}

	@Override
	public Object updateSQL(String sql, Object object) {

		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;

	}

	@Override
	public Object deleteSQL(String sql, Object object) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}

}
