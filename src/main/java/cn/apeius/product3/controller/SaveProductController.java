package cn.apeius.product3.controller;

import cn.apeius.product3.domain.Product;
import cn.apeius.product3.form.ProductForm;
import cn.apeius.product3.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {

    public String handleRequest(HttpServletRequest request,
            HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        //填充表单属性
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        //校验表单
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if (errors.isEmpty()) {
            //创建领域对象Product
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            //没有校验错误，执行action方法
            //保存产品信息到数据库的代码

            //将product存入request域中，便于后面页面显示
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
            // store errors and form in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }

}
