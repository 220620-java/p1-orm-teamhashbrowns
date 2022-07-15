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
import java.util.List;
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
			Field[] fields = object.getClass().getDeclaredFields();
			Map<String, Object> row = new HashMap<String, Object>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columns = metaData.getColumnCount();	
			//
			
			while (resultSet.next()) {
				for (int i = 1; i <= columns; i++) {row.put(metaData.getColumnLabel(i), resultSet.getObject(i));}
				
				//
				row.entrySet().stream().forEach(e -> {

					for (Field field : fields) {
						field.setAccessible(true);
						try {
							if (field.getName().equals(e.getKey()) 
									&& !field.isAnnotationPresent(ignore.class) 
									&& field.getType().getSimpleName().equals("String")) {
								
								field.set(object, e.getValue().toString());
								
							} else if (field.getName().equals(e.getKey()) 
									&& !field.isAnnotationPresent(ignore.class) 
									&& field.getType().getSimpleName().equals("int")) {
								
								field.setInt(object, (int) e.getValue());
								
							} else if (field.getName().equals(e.getKey()) 
									&& !field.isAnnotationPresent(ignore.class) 
									&& field.getType().getSimpleName().equals("double")) {
								
								field.setDouble(object, (double) e.getValue());
								
							} else if (field.getName().equals(e.getKey()) 
									&& !field.isAnnotationPresent(ignore.class) 
									&& field.getType().getSimpleName().equals("boolean")) {
								
								field.setBoolean(object, (boolean) e.getValue());		
								
							} 			
						} catch (Exception e1) {
							e1.printStackTrace();
							
						} } });

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return object;
	}

	@Override
	public Object updateSQL(String sql, Object object) {
		try (Connection conn = connUtil.getConnection()) {


			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			System.out.println(sql);


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
