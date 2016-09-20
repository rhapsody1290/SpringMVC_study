package cn.apeius.product5.service;


import cn.apeius.product5.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
