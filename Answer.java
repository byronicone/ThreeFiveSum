package com.github.byronicone;

public class Answer {

    private int answer;
    private long runTime;

    public Answer(int answer, long runTime){
        this.answer=answer;
        this.runTime=runTime;
    }

    public void setAnswer(int answer){
        this.answer=answer;
    }

    public void setRunTime(long runTime){
        this.runTime = runTime;
    }

    public String toString(){
        return "Answer: " + answer + "\nComputation took " + runTime + "nanoseconds.";
    }
}
