package hashbrowns.p1.orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class QueryBuilder {

	public static void main(String[] args) throws Exception {

		Object cook = new TestModel();

		insertObject("p1.cooks", cook);
		selectById("p1.cooks", cook);
		updateById("p1.cooks", cook);
	}

	
	public static String insertObject(String table, Object object) throws Exception, IllegalAccessException {
		//
		StringJoiner comma1 = new StringJoiner(", ");
		StringJoiner comma2 = new StringJoiner("', '");

		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			comma1.add(field.getName());
			comma2.add(field.get(object).toString());
		}

		String query = "insert into " + table + "(" + comma1.toString() + ") values ( '" + comma2.toString() + "' )";

		return query;

	}

	
	public static String selectById(String table, Object object) throws Exception, SecurityException {
		//
		Class<?> clazz = object.getClass();
		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);
		//

		//this might just be a int param for id rather then the current objects?
		String query = "select * from " + table + " where id = " + idField.get(object).toString();

		return query;

	}

	
	public static String updateById(String table, Object object) throws Exception {
		//
		StringBuilder fieldStr = new StringBuilder();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		//
		
		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);

		for (Field field : fields) {
			field.setAccessible(true);

			if (!field.getName().toString().equals("id")) {
				fieldStr.append(field.getName());
				fieldStr.append("='");
				fieldStr.append(field.get(object));
				fieldStr.append("', ");
			}
		}

		fieldStr.setLength(fieldStr.length() - 2);

		String query = "UPDATE " + table + " SET " + fieldStr.toString() + " where id ='"
				+ idField.get(object).toString() + "'";

		return query;
	}

}
