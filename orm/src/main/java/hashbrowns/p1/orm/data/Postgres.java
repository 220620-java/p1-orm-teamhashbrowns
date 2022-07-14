package hashbrowns.p1.orm.data;

public class Postgres implements PostgresDao {

	@Override
	public String insertSQL(String sql) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return null;
	}

	@Override
	public String selectSQL(String sql) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return null;
	}

	@Override
	public Object updateSQL(String sql) {
		System.out.println(sql);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteSQL(String sql) {
		System.out.println(sql);
		// TODO Auto-generated method stub
		return null;
	}

}
