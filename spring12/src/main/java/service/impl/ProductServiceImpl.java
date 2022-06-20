package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IProductDao;
import service.IProductService;
import vo.ProductListVo;
import vo.ProductVo;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao productDao;
	
	@Override
	public boolean insertProduct(ProductVo productVo) throws Exception {
		return productDao.insert(productVo) > 0 ? true : false;
	}

	@Override
	public boolean updateProduct(ProductVo productVo) throws Exception {
		return productDao.update(productVo) > 0 ? true : false;
	}

	@Override
	public boolean deleteProduct(ProductVo productVo) throws Exception {
		return productDao.delete(productVo) > 0 ? true : false;
	}

	@Override
	public ProductVo selectProduct(ProductVo productVo) throws Exception {
		return productDao.selectOne(productVo);
	}

	@Override
	public ProductListVo selectProductList(ProductVo vo) throws Exception {
		List<ProductVo> productList = productDao.selectList(vo);
		int pageTotalCount = productDao.selectTotalCount(vo);
		
		int pageIndex = vo.getPageIndex();
		int pageSize = vo.getPageSize();
		
		// 페이지 처리
		int pageFirst = 1;
		int pageBegin = (pageIndex - 1) / pageSize * pageSize  + 1;
		int pageEnd = ((pageIndex - 1) / pageSize + 1) * pageSize;
		int pageLast = (productDao.selectTotalCount(vo) - 1) / pageSize + 1;
		pageEnd = pageEnd > pageLast ? pageLast : pageEnd;
		
		ProductListVo productListVo = new ProductListVo();
		productListVo.setPageIndex(pageIndex);
		productListVo.setPageFirst(pageFirst);
		productListVo.setPageBegin(pageBegin);
		productListVo.setPageEnd(pageEnd);
		productListVo.setPageLast(pageLast);
		productListVo.setPageTotalCount(pageTotalCount);
		productListVo.setProductList(productList);
		
		return productListVo;
	}

}
