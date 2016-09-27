package com.mkyong.common.controller;

import com.mkyong.common.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class SignUpController {

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addCustomer(
            @Valid Customer customer,
            BindingResult result) {
        System.out.println("进入addCustomer");
        /*for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				System.out.println(fieldError.getField() + ":"
						+ fieldError.getCode());

			}

			if (object instanceof ObjectError) {
				ObjectError objectError = (ObjectError) object;

			}
		}*/

        if (result.hasErrors()) {
            return "SignUpForm";
        } else {
            return "Done";
        }

    }

    @RequestMapping(value = "displayCustomerForm", method = RequestMethod.GET)
    public String displayCustomerForm(ModelMap model) {
        System.out.println("进入displayCustomerForm");
        Customer customer = new Customer();
        customer.setName("");
        customer.setAge(2333);
        model.addAttribute("customer", customer);
        return "SignUpForm";
    }

}