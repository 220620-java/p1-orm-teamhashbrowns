package hashbrowns.p1.orm.data;

public interface PostgresDao {

	public void insertSQL(String sql);
	
	public String selectSQL(String sql);
	
	public void updateSQL(String sql);
	
	public void deleteSQL(String sql);
	
}
