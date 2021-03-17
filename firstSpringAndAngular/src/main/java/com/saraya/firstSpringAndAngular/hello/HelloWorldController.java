package com.saraya.firstSpringAndAngular.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.firstSpringAndAngular.bean.HelloWorldBean;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("U get some error");
		return new HelloWorldBean("Hello World from the Bean how are you");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanWithPathVariable(@PathVariable String name) {
		//throw new RuntimeException("U get some error");
		return new HelloWorldBean(String.format("Hello World from %s", name));
	}
}
