package com.acilia.ttschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acilia.ttschool.constant.AttributeValueViewConstant;
import com.acilia.ttschool.constant.ViewConstant;

@Controller
@RequestMapping("/libro")
public class LibrosController {
	
	@GetMapping()
	public String listar(Model model) {
		model.addAttribute("titulo", AttributeValueViewConstant.TITLE_BOOK_LIST);
		return ViewConstant.BOOK_LIST_VIEW;
	}

}
