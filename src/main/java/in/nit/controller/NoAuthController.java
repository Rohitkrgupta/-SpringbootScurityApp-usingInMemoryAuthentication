package in.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAuth")
public class NoAuthController {
	
	@GetMapping("/hello")
	public String hello()
	{
	   return "Hello my friend...you are not secure";	
	}

}
