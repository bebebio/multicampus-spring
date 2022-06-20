package dao;

import java.util.List;

import vo.ProductVo;

public interface IProductDao {
	
	public int insert(ProductVo productVo) throws Exception;
	
	public int update(ProductVo productVo) throws Exception;
	
	public int delete(ProductVo productVo) throws Exception;
	
	public ProductVo selectOne(ProductVo productVo) throws Exception;
	
	public List<ProductVo> selectList(ProductVo productVo) throws Exception;
	
	public int selectTotalCount(ProductVo productVo) throws Exception;
	
}
