package hashbrowns.p1.orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Orm {

	public static void main(String[] args) throws Exception {

		Object cook = new TestModel();

		
		insertObject("p1.cooks", cook);
		selectById("p1.cooks", cook);
	}
	
	//return sql but sysout for testing
	public static void insertObject(String table, Object object) throws Exception, IllegalAccessException {
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

		String sql = "insert into " + table + "(" + comma1.toString() + ") values ( '" + comma2.toString() + "' )";

		System.out.println(sql);

	}

	public static void selectById(String table, Object object) throws Exception, SecurityException {
		//
		Class<?> clazz = object.getClass();
		Field idField = clazz.getDeclaredField("id");
		//Field[] fields = clazz.getDeclaredFields();
		idField.setAccessible(true);
		//
    
        
		String sql = "select * from " + table + " where id = " + idField.get(object).toString();

		System.out.println(sql);
		

	}



}
