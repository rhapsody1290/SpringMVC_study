package cn.apeius.product4.controller;

import cn.apeius.product4.domain.Product;
import cn.apeius.product4.form.ProductForm;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        //填充表单属性
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        //创建领域对象Product
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(Float.parseFloat(productForm.getPrice()));

        //没有校验错误，执行action方法
        //保存产品信息到数据库的代码

        return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product", product);
    }

}
