package io.kedari.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<>( Arrays.asList(
						new Topic("spring","Spring Framework","spring framework description"),
						new Topic("java","Core Java","Core Java description"),
						new Topic("javaScript","Java Script","Java Script description")
			));
			
	
	public List<Topic> getAllTopisc(){
		return topics;
	}
	
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	public void addTopic(Topic topic) {
		topics.add(topic);
	}


	public void updateTopic(String id, Topic topic) {

		for(int i=0;i<topics.size();i++){
			Topic t = topics.get(i);
			
			if(t.getId().equals(id)){
				topics.set(i, topic);
			}
		}
		
	}


	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
