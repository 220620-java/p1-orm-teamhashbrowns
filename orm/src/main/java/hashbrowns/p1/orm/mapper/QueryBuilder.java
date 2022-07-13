package hashbrowns.p1.orm.mapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class QueryBuilder {

	public Object insertObject(String table, Object object) {
		//
		StringJoiner comma1 = new StringJoiner(", ");
		StringJoiner comma2 = new StringJoiner("', '");

		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Stream<Field> strArray = Arrays.stream(fields);

		strArray.forEach(field -> {

			field.setAccessible(true);

			try {
				if (!field.get(object).equals(null)) {
					comma1.add(field.getName());
					comma2.add(field.get(object).toString());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//its ok
			}
		});

		/*
		 * for (Field field : fields) { field.setAccessible(true);
		 * comma1.add(field.getName()); comma2.add(field.get(object).toString()); }
		 */

		String query = "insert into " + table + "(" + comma1.toString() + ") values ( '" + comma2.toString() + "' )";

		return query;

	}

	public Object selectById(String table, Object object) throws Exception {
		//
		Class<?> clazz = object.getClass();
		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);
		//

		// this might just be a int param for id rather then the current objects?
		String query = "select * from " + table + " where id = " + idField.get(object).toString();

		return query;

	}

	public Object update(String table, Object object) throws Exception {
		//
		StringBuilder fieldStr = new StringBuilder();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		//

		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);

		Stream<Field> strArray = Arrays.stream(fields);

		strArray.forEach(field -> {
			
			try {
				field.setAccessible(true);
				if (!field.get(object).equals(null)) {
					fieldStr.append(field.getName());
					fieldStr.append("='");
					fieldStr.append(field.get(object));
					fieldStr.append("', ");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//its ok
			}
		});

		/*
		 * for (Field field : fields) { field.setAccessible(true);
		 * 
		 * if (!field.getName().toString().equals("id")) {
		 * fieldStr.append(field.getName()); fieldStr.append("='");
		 * fieldStr.append(field.get(object)); fieldStr.append("', "); } }
		 */

		fieldStr.setLength(fieldStr.length() - 2);

		String query = "UPDATE " + table + " SET " + fieldStr.toString() + " where id ='"
				+ idField.get(object).toString() + "'";

		return query;
	}

}
