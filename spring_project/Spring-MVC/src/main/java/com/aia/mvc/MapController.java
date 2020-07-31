package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

	@RequestMapping("/map")
	public String hello(Model model) {
		
		
		return "map/map";
	}
	
}
