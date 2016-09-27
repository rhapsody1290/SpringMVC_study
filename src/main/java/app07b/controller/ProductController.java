package app07b.controller;

import javax.validation.Valid;

import com.sun.deploy.net.proxy.ProxyUnavailableException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app07b.domain.Product;

@Controller
public class ProductController {

    private static final Log logger = LogFactory
            .getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct(Model model) {
        System.out.println("product_input");
        Product product = new Product();
        model.addAttribute("product", product);
        System.out.println(product);
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(@Valid @ModelAttribute Product product,
            BindingResult bindingResult, Model model) {
        System.out.println("product_save");
        System.out.println(product);
        System.out.println(model.asMap().get("product"));
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", object:"
                    + fieldError.getObjectName() + ", field:"
                    + fieldError.getField());
            return "ProductForm";
        }

        // save product here

        //model.addAttribute("product", product);
        return "ProductDetails";
    }

}
