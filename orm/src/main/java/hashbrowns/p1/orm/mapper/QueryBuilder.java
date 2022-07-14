package hashbrowns.p1.orm.mapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;
import hashbrowns.p1.orm.annotations.id;
import hashbrowns.p1.orm.annotations.ignore;
import hashbrowns.p1.orm.data.Postgres;

public class QueryBuilder implements Mapper {
	//
	private static Logger logger = Logger.getLogger();
	static Postgres postgres = new Postgres();
	
	
	
	@Override
	public Object insertQuery(String table, Object object) {
		//
		StringJoiner comma1 = new StringJoiner(", ");
		StringJoiner comma2 = new StringJoiner("', '");
		
		//
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Stream<Field> strArray = Arrays.stream(fields);

		//
		strArray.forEach(field -> {
			
			field.setAccessible(true);
			try {
				if (!field.get(object).equals(null) & !field.isAnnotationPresent(ignore.class) & !field.isAnnotationPresent(id.class)) {

					comma1.add(field.getName());
					comma2.add(field.get(object).toString());
					
				} else if(field.isAnnotationPresent(id.class)) {

				}
			} catch (Exception e) {
				logger.log("Nulled fields are being excluded from the statement", LoggingLevel.INFO);
			}
		});

		//
		String query = "INSERT INTO " + table + "(" + comma1.toString() + ") VALUES ('" + comma2.toString() + "')";

		postgres.insertSQL(query, object);
		return object;
	}

	
	
	@Override
	public Object selectByIdQuery(String table, Object object) throws Exception {
		//
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String id = null;
		String idValue = null;
		
		//
		for (Field field : fields) {
			if (field.isAnnotationPresent(id.class)) {
				field.setAccessible(true);
				id = field.getName().toString();
				idValue = field.get(object).toString();
				
			}
		}

		//
		String query = "SELECT * FROM " + table + " WHERE " + id + " = '" + idValue +"'";

		postgres.selectSQL(query, object);
		return object;
	}

	
	
	@Override
	public Object updateQuery(String table, Object object) throws Exception {
		//
		StringBuilder fieldStr = new StringBuilder();
		
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		//
		String id = null;
		String idValue = null;

		//
		for (Field field : fields) {
			
			field.setAccessible(true);
			
				if (!field.get(object).equals(null) & !field.isAnnotationPresent(id.class)
						& !field.isAnnotationPresent(ignore.class)) {
					
					fieldStr.append(field.getName());
					fieldStr.append("='");
					fieldStr.append(field.get(object));
					fieldStr.append("', ");
					
				}else if (field.isAnnotationPresent(id.class)) {
					
					field.setAccessible(true);
					id = field.getName().toString();
					idValue = field.get(object).toString();
					
				}

		};
		
		fieldStr.setLength(fieldStr.length() - 2);

		//
		String query = "UPDATE " + table + " SET " + fieldStr.toString() + " where "+id+"='"
				+ idValue + "'";

		
		postgres.updateSQL(query, object);
		return object;
	}

	
	
	@Override
	public Object deleteQuery(String table, Object object) throws Exception {
		//
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String id = null;
		String idValue = null;

		//
		for (Field field : fields) {
			if (field.isAnnotationPresent(id.class)) {
				
				field.setAccessible(true);
				id = field.getName().toString();
				idValue = field.get(object).toString();
				
			}
		}
		
		//
		String sql = "DELETE FROM "+table+" WHERE "+id+"='"+idValue+"';";
		
		postgres.deleteSQL(sql, object);
		return object;
	}

}
