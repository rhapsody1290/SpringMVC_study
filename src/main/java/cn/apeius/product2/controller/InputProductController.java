package cn.apeius.product2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements Controller {

	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}
}
