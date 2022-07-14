package hashbrowns.p1.orm.data;

public interface PostgresDao {

	public Object insertSQL(String sql, Object object);
	
	public Object selectSQL(String sql, Object object);
	
	public Object updateSQL(String sql, Object object);
	
	public Object deleteSQL(String sql, Object object);
	
}
