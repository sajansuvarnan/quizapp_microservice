package com.telusko.question_service.dao;

import com.telusko.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT id FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true )
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);

//    @Query(value = "SELECT q.* FROM question q join quiz_question qq on q.id = qq.questions_id WHERE qq.quiz_id=:id", nativeQuery = true)
//    List<Question> findQuestion(int id);
}
