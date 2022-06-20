package dao;

import java.util.List;

import vo.ProductVo;

public interface IProductDao {
	
	/** 상품정보 등록 */
	public int insertProduct(ProductVo vo) throws Exception;
	
	/** 상품정보 수정 */
	public int updateProduct(ProductVo vo) throws Exception;
	
	/** 상품정보 삭제 */
	public int deleteProduct(ProductVo vo) throws Exception;
	
	/** 코드로 상품정보 조회 */
	public ProductVo selectProductByCode(ProductVo vo) throws Exception;
	
	/** 상품정보 조회 */
	public List<ProductVo> selectProduct(ProductVo vo) throws Exception;
	
}
