package jxau.spms.abstraction.dao;

import java.util.List;
import java.util.Map;
/**
 *  Dao层封装
 * @author anping
 *
 */
public interface Dao {
	public <T>  void add(String mapperId,T t);
	public <T> void batchAdd(String mapperId,List<T> t);
	public <T> T selectOne(String mapperId,Map<String,Object> params);
	public <T> List<T> select(String mapperId,Map<String,Object> params);
	public <T> void delete(String mapperId,T t);
	public <T> void update(String mapperId,T t);
	public <T> void batchDelete(String mapperId,List<T> t);
	public <T> void batchUpdate(String mapperId,List<T> t);
	public <T> void batchAdd(String mapperId,Map<String,Object> params);
	public <T> void batchDelete(String mapperId,Map<String,Object> params);
}
