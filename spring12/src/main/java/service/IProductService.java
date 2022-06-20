package service;

import vo.ProductListVo;
import vo.ProductVo;

public interface IProductService {
	
	public boolean insertProduct(ProductVo productVo) throws Exception;
	
	public boolean updateProduct(ProductVo productVo) throws Exception;
	
	public boolean deleteProduct(ProductVo productVo) throws Exception;
	
	public ProductVo selectProduct(ProductVo productVo) throws Exception;
	
	public ProductListVo selectProductList(ProductVo vo) throws Exception;
	
}
