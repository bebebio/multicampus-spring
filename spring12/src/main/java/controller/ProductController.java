package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.IProductService;
import vo.ProductListVo;
import vo.ProductVo;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/insertProduct.do")
	public String insertProduct(ProductVo productVo) throws Exception {
		productService.insertProduct(productVo);
		return "product";
	}
	
	@RequestMapping("/selectProductList.do")
	public String selectProductList(ProductVo productVo, Model model) throws Exception {
		ProductListVo productListVo = productService.selectProductList(productVo);
		model.addAttribute("productListVo", productListVo);
		return "/product/productList";
	}
	
	@RequestMapping("/selectProduct.do")
	public String selectProduct(ProductVo productVo, Model model) throws Exception {
		ProductVo retProductVo = productService.selectProduct(productVo);
		model.addAttribute("productVo", retProductVo);
		return "/product/product";
	}
	
}
