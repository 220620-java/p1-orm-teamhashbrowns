package hashbrowns.p1.orm.data;

public interface PostgresDao {

	public String insertSQL(String sql);
	
	public String selectSQL(String sql);
	
	public Object updateSQL(String sql);
	
	public Object deleteSQL(String sql);
	
}
