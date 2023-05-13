package Semicolon.africa.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){

        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){

//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        // Assuming that topics is a collection of Topic objects
        Topic foundTopic = null;
        for (Topic topic : getAllTopics()) {
            if (topic.getId().equals(id)) {
                foundTopic = topic;
                break;
            }
        }

        return Optional.ofNullable(foundTopic);
    }

    public void addTopic(Topic topic) {

        topicRepository.save(topic);
    }

    public Topic updateTopic(String id, Topic topic) {
//       for(int i = 0; i < topics.size(); i++){
//          Topic t = topics.get(i);
//         if(t.getId().equals(id)){
//               topics.set(i , topic);
//                return;
//            }
//        }
        return topicRepository.save(topic);
    }

    public void deleteTopic(String id) {


//        topics.removeIf(t -> t.getId().equals(id));
         topicRepository.deleteById(id);
    }
}
