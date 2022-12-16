package springpractice.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import springpractice.sample.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
	
	
	@RequestMapping("/list")
	public void list() {
		log.info("todo list............");
	}
	
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public void register() {
//		log.info("todo register.......");
//	}
	
	@GetMapping("/register")
	public void registerGET() {
		log.info("todo register GET........");
	}
	
	@PostMapping("/register")
	public void registerPOST(TodoDTO todoDTO) {
		log.info("todo register POST........");
		log.info(todoDTO);
	}
}
