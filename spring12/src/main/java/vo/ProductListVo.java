package vo;

import java.util.List;

public class ProductListVo extends CommonVo {
	
	private List<ProductVo> productList;

	public List<ProductVo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductListVo [productList=" + productList + "]";
	}
	
}
