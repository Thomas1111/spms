package jxau.spms.abstraction.dao;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Component("dao")
public class EntityDao implements Dao {

	private SqlSession session;

	@Resource(name = "sqlSession")
	public void setSession(SqlSession session) {
		this.session = session;
	}

	private SqlSessionFactory sqlSessionFactory;

	@Resource(name = "sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public <T> void add(String mapperId, T t) {
		session.insert(mapperId, t);
	}


	@Override
	public <T> T selectOne(String mapperId, Map<String, Object> params) {
		return session.selectOne(mapperId, params);
	}

	@Override
	public <T> List<T> select(String mapperId, Map<String, Object> params) {
		return session.selectList(mapperId, params);
	}

	@Override
	public <T> void batchAdd(String mapperId, List<T> t) {
		SqlSession	session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);

		session.insert(mapperId, t);
		session.commit();
	}

	@Override
	public <T> void delete(String mapperId, T t) {
		session.delete(mapperId, t);
	}

	@Override
	public <T> void update(String mapperId, T t) {

		session.update(mapperId, t);
	}

	@Override
	public <T> void batchDelete(String mapperId, List<T> t) {
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, true);

		session.delete(mapperId, t);
		session.commit();
	}

	@Override
	public <T> void batchUpdate(String mapperId, List<T> t) {
	   SqlSession	session = sqlSessionFactory.openSession(ExecutorType.BATCH, true);
   
		for (T a : t) {
			session.update(mapperId, a);
		}
		session.commit();
	}

	@Override
	public <T> void batchAdd(String mapperId, Map<String, Object> params) {
		// TODO Auto-generated method stub

		session.insert(mapperId, params);
	}

	@Override
	public <T> void batchDelete(String mapperId, Map<String, Object> params) {
		// TODO Auto-generated method stub
		session.delete(mapperId, params);
	}

}
