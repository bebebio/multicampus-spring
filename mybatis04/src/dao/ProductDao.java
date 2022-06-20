package dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.ProductVo;

public class ProductDao implements IProductDao {

	private SqlSessionFactory sessionFactory;
	
	public ProductDao() {
		String configPath = "config/configuration.xml";
		try (InputStream is = Resources.getResourceAsStream(configPath)) {
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertProduct(ProductVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IProductDao.class).insertProduct(vo);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int updateProduct(ProductVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IProductDao.class).updateProduct(vo);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public int deleteProduct(ProductVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IProductDao.class).deleteProduct(vo);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public ProductVo selectProductByCode(ProductVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IProductDao.class).selectProductByCode(vo);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public List<ProductVo> selectProduct(ProductVo vo) throws Exception {
		try (SqlSession session = sessionFactory.openSession()) {
			return session.getMapper(IProductDao.class).selectProduct(vo);
		} catch(Exception e) {
			throw e;
		}
	}

}
