package Semicolon.africa.courseapidata.course.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){

        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse (String id){

//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        // Assuming that topics is a collection of Topic objects
        Course foundCourse = null;
        for (Course course : getAllCourses(id)) {
            if (course.getId().equals(id)) {
                foundCourse = course;
                break;
            }
        }

        return Optional.ofNullable(foundCourse);
    }

    public void addCourse (Course course) {

        courseRepository.save(course);
    }

    public Course updateCourse(String id, Course topic) {
//       for(int i = 0; i < topics.size(); i++){
//          Topic t = topics.get(i);
//         if(t.getId().equals(id)){
//               topics.set(i , topic);
//                return;
//            }
//        }
        return courseRepository.save(topic);
    }

    public void deleteCourse(String id) {


//        topics.removeIf(t -> t.getId().equals(id));
         courseRepository.deleteById(id);
    }
}
