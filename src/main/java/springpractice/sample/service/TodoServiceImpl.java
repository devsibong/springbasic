package springpractice.sample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import springpractice.sample.domain.TodoVO;
import springpractice.sample.dto.TodoDTO;
import springpractice.sample.mapper.TodoMapper;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	private final TodoMapper todoMapper;
	
	private final ModelMapper modelMapper;
	
	@Override
	public void register(TodoDTO todoDTO) {
		log.info(modelMapper);
		
		//ModelMapper를 이용해 DTO를 VO로 변환
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		
		log.info(todoVO);
		
		//변환된 VO를 TodoMapper를 통해 insert처리함
		todoMapper.insert(todoVO);
	}
	
	@Override
	public List<TodoDTO> getAll() {
		//List<TodoVO>를 List<TodoDTO>로 변환
		//각 TodoVO는 map()을 통해 TodoDTO로 바꾸고, collect()로 묶어줌
		List<TodoDTO> dtoList = todoMapper.selectAll().stream()
				.map(vo -> modelMapper.map(vo, TodoDTO.class))
				.collect(Collectors.toList());
		
		return dtoList;
	}
	
	@Override
	public TodoDTO getOne(Long tno) {
		TodoVO todoVO = todoMapper.selectOne(tno);
		
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		
		return todoDTO;
	}
	
	@Override
	public void remove(Long tno) {
		todoMapper.delete(tno);
	}
}
