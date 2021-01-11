package services;

import dto.StoryDTO;
import dto.StoryDetailDTO;

import java.util.List;

public interface StoryService {
    List<StoryDTO> allStories();
    StoryDetailDTO findStoryById(Long id);
}
