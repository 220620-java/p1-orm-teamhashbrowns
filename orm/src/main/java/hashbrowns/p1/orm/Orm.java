package hashbrowns.p1.orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Orm {

	public static void main(String[] args) {
		
		Object cook = new TestModel();

		insertObject("Cooks", cook);

	}

	public static void insertObject(String table, Object object) {
		//
		StringBuilder fieldsStr = new StringBuilder();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Stream<Field> strArray = Arrays.stream(fields);
		//
		
		strArray.forEach(field -> {
			fieldsStr.append(field.getName());
			fieldsStr.append(", ");
		});
		fieldsStr.setLength(fieldsStr.length() - 2);

		String sql = "insert into " + table + "(" + fieldsStr + ") values ( )";
		
		System.out.println(sql);

	}

}
