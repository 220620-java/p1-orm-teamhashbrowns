package hashbrowns.p1.orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Orm {

	public static void main(String[] args) {

		Object cook = new TestModel();

		insertObject("p1.cooks", cook);
		selectById("p1.cooks", 3, cook);
	}

	public static void insertObject(String table, Object object) {
		//
		StringJoiner comma1 = new StringJoiner(",");
		StringJoiner comma2 = new StringJoiner(",");

		// StringBuilder fieldsStr = new StringBuilder();
		// StringBuilder inpStr = new StringBuilder();

		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Stream<Field> fieldArray = Arrays.stream(fields);

		// long total = Arrays.stream(fields).count();
		//

		fieldArray.forEach(field -> {
			comma1.add(field.getName());
			comma2.add("?");
			// inpStr.append(" ?, ");
			// fieldsStr.append(field.getName());
			// fieldsStr.append(", ");
		});

		// fieldsStr.setLength(fieldsStr.length() - 2);

		String sql = "insert into " + table + "(" + comma1.toString() + ") values ( " + comma2.toString() + " )";

		System.out.println(sql);

	}

	public static void selectById(String table, int id, Object object) {
		
		Class<?> clazz = object.getClass();
		StringJoiner equal = new StringJoiner(" = ");

		String sql = "select * from " + table + " where id=" + id;

		System.out.println(sql);
		

	}



}
