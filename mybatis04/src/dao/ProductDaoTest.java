package dao;

import vo.ProductVo;

public class ProductDaoTest {
	
	public static void main(String[] args) {
		try {
			IProductDao dao = new ProductDao();
			
			ProductVo vo = new ProductVo();
			vo.setCode(7777);
			vo.setName("�̸�");
			vo.setPrice(1000);
			vo.setPicture("�׸�");
			vo.setDescription("����");
			
			System.out.println("- insert : " + dao.insertProduct(vo));
			System.out.println("  -> " + dao.selectProductByCode(vo));
			
			vo.setPrice(2000);
			System.out.println("- update : " + dao.updateProduct(vo));
			System.out.println("  -> " + dao.selectProductByCode(vo));
			
			System.out.println("- delete : " + dao.deleteProduct(vo));
			
			dao.selectProduct(vo).forEach(Product -> {
				System.out.println(Product);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
