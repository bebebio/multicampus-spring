package dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements IBoardDao {
	
	private SqlSessionFactory sessionFactory;
	
	public BoardDao() {
		this("config/configuration.xml");
	}
	
	public BoardDao(String config) {
		try (InputStream is = Resources.getResourceAsStream(config)) {
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertBoard(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).insertBoard(params);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).selectBoardList(params);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int selectBoardTotalCount() throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).selectBoardTotalCount();
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	


}
