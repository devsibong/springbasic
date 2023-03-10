package springpractice.sample.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import springpractice.sample.dto.TodoDTO;
import springpractice.sample.service.TodoService;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	
	@RequestMapping("/list")
	public void list(Model model) {
		log.info("todo list............");
		
		model.addAttribute("dtoList", todoService.getAll());
	}
	
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public void register() {
//		log.info("todo register.......");
//	}
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("todo register GET........");
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		log.info("todo register POST........");
		
		
		if(bindingResult.hasErrors()) {
			log.info("has errors........");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/todo/register";
		}
		
		log.info(todoDTO);
		
		todoService.register(todoDTO);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Long tno, Model model) {
		TodoDTO todoDTO = todoService.getOne(tno);
		log.info(todoDTO);
		
		model.addAttribute("dto", todoDTO);
	}
	
	@PostMapping("/remove")
	public String remove(Long tno, RedirectAttributes redirectAttributes) {
		log.info("remove-------------");
		log.info("tno: " + tno);
		
		todoService.remove(tno);
		
		return "redirect:/todo/list";
	}
}
