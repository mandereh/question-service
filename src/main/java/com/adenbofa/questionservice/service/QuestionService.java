package com.adenbofa.questionservice.service;

import com.adenbofa.questionservice.dao.QuestionDao;
import com.adenbofa.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question){

        try {
            return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
            return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> updateQuestion(Question question){
        try{
            return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        questionDao.deleteById(id);
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
