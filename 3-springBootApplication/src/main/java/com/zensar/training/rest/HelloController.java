package com.zensar.training.rest;

    import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class HelloController {
		@RequestMapping("/greet")
		public  String sayHello() {
			return "Welcome to REST API";
		}
	}

