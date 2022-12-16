package springpractice.sample;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {
	
	private final SampleDAO sampleDAO;
}
