/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Hùng
 */
public class Answer {

    private int idQuestion;
    private String option;
    private int answer;
    private int idAnswer;

    public Answer() {
    }

    public Answer(int idQuestion, String option, int answer, int idAnswer) {
        this.idQuestion = idQuestion;
        this.option = option;
        this.answer = answer;
        this.idAnswer = idAnswer;
    }


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

}
