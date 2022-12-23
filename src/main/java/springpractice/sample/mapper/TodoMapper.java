package springpractice.sample.mapper;

import java.util.List;

import springpractice.sample.domain.TodoVO;

public interface TodoMapper {

		String getTime();
		
		void insert(TodoVO todoVO);
		
		List<TodoVO> selectAll();
		
		TodoVO selectOne(Long tno);
		
		void delete(Long tno);
}
