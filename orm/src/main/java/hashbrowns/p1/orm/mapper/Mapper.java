package hashbrowns.p1.orm.mapper;

public interface Mapper {

	public Object insertQuery(String table, Object object);

	public Object selectByIdQuery(String table, Object object) throws Exception;

	public void updateQuery(String table, Object object) throws Exception;

	public Object deleteQuery(String table, Object object) throws Exception;
}
