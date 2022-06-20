package dao;

import java.util.List;

import vo.ProductVo;

public interface IProductDao {
	
	/** ��ǰ���� ��� */
	public int insertProduct(ProductVo vo) throws Exception;
	
	/** ��ǰ���� ���� */
	public int updateProduct(ProductVo vo) throws Exception;
	
	/** ��ǰ���� ���� */
	public int deleteProduct(ProductVo vo) throws Exception;
	
	/** �ڵ�� ��ǰ���� ��ȸ */
	public ProductVo selectProductByCode(ProductVo vo) throws Exception;
	
	/** ��ǰ���� ��ȸ */
	public List<ProductVo> selectProduct(ProductVo vo) throws Exception;
	
}
