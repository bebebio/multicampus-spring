package dao;

import java.io.InputStream;
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
	
	/** 게시글 등록 */
	@Override
	public int insertBoard(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).insertBoard(params);
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 게시글 수정 */
	@Override
	public int updateBoard(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).updateBoard(params);
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 게시글 삭제 */
	@Override
	public int deleteBoard(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).deleteBoard(params);
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 게시글 상세 조회 */
	@Override
	public Map<String, Object> selectBoard(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).selectBoard(params);
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 게시글 목록 조회 */
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).selectBoardList(params);
		} catch(Exception e) {
			throw e;
		}
	}
	
	/** 게시글 제목으로 조회 */
	@Override
	public List<Map<String, Object>> selectBoardByTitle(Map<String, Object> params) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IBoardDao.class).selectBoardByTitle(params);
		} catch(Exception e) {
			throw e;
		}
	}

}
