//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.adenbofa.questionservice.controller;


import java.util.List;

import com.adenbofa.questionservice.model.Question;
import com.adenbofa.questionservice.model.QuestionWrapper;
import com.adenbofa.questionservice.model.Response;
import com.adenbofa.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"question"})
public class QuestionController {
    @Autowired
    QuestionService questionService;

    public QuestionController() {
    }

    @GetMapping({"/allQuestions"})
    public ResponseEntity<List<Question>> getAllQuestions() {
        return this.questionService.getAllQuestions();
    }

    @GetMapping({"/category/{category}"})
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return this.questionService.getQuestionsByCategory(category);
    }

    @PostMapping({"/add"})
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return this.questionService.addQuestion(question);
    }

    @PutMapping({"/update"})
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return this.questionService.updateQuestion(question);
    }

    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        this.questionService.deleteQuestion(id);
        return new ResponseEntity("delete success", HttpStatus.OK);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
