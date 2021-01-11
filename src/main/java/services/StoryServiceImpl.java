package services;

import domain.Story;
import dto.StoryDTO;
import dto.StoryDetailDTO;
import repository.StoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    private final ModelMapper modelMapper;

    public StoryServiceImpl(StoryRepository storyRepository, ModelMapper modelMapper) {
        this.storyRepository = storyRepository;
        this.modelMapper = modelMapper;
    }

    public List<StoryDTO> allStories () {
        List<Story> allStories = storyRepository.findAll();
        return allStories.stream()
                .map(story -> this.modelMapper.map(story, StoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StoryDetailDTO findStoryById(Long id) {
       Story story = this.storyRepository.findById(id).orElse(null);

       StoryDetailDTO storyDetailDTO = this.modelMapper.map(story, StoryDetailDTO.class);

        return storyDetailDTO;
    }

}
