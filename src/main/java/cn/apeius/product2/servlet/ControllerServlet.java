package cn.apeius.product2.servlet;
import cn.apeius.product.domain.Product;
import cn.apeius.product.form.ProductForm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1579L;

    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {
        /*
        1、URI的形式为：/应用名/资源名，例如/app10a/product_input
        2、一个Servlet可以对应多个action，本应用中访问/product_input.action和/product_save.action会进入ControllerServlet
        3、这个Servlet命名为ControllerServlet，是遵循了一个约定：所有Servlet类的名称都带有Servlet后缀
		*/
        //1、获取action名
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1); 
        //2、根据action进行数据处理
        if (action.equals("product_input.action")) {
            //不需要调用service类执行业务逻辑
        } else if (action.equals("product_save.action")) {
            //创建表单对象
            ProductForm productForm = new ProductForm();
            //填充对象属性
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(
                    request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            
            //创建模型
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
            	product.setPrice(Float.parseFloat(
            			productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            
            //调用service层的方法，保存产品，此处略
            
            //将产品模型保存在session，以便后续页面使用
            request.setAttribute("product", product);
        }

        //3、根据处理结果，跳转页面
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
        } else if (action.equals("product_save.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher rd = 
                    request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
