package qdu.petcare.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackIndexController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}