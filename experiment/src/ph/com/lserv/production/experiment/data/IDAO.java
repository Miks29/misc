package ph.com.lserv.production.experiment.data;

import java.util.List;

public interface IDAO <T> {
	public List<T> getAllData();

	public int createData(T object);

	public int updateData(T object);

	public int deleteData(T object);

	public T getDataById(int id);
	
}
