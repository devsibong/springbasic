package springpractice.sample.service;

import java.util.List;

import springpractice.sample.dto.TodoDTO;

public interface TodoService {
	void register(TodoDTO todoDTO);
	
	List<TodoDTO> getAll();
}
