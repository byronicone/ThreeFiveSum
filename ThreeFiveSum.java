package com.github.byronicone;


public class ThreeFiveSum {

    public static void main(String[] args) {

        Calculator all[] = new Calculator[]{()->bruteForce(),
                ()->checkMultiples(),
                ()->greedyMultiples(),
                };

        System.out.println("Question: what is the sum of all numbers divisible by 3 or 5 that are less than 1000?\n");

        for(Calculator c: all){
            Answer a = calculate(c);
            System.out.println(a);
            System.out.println("---");
        }


    }

    private static Answer calculate(Calculator c){
        long startTime = System.nanoTime();
        int result = c.runCalculation();
        long runTime = System.nanoTime() - startTime;
        return new Answer(result, runTime);
    }

    private static int bruteForce(){
        System.out.println("Using brute force method");
        int sum = 0;
        /*This method is brute force, involving division, not the most efficient
        however it is very intuitive.*/
        for(int i = 0; i < 1000; i++){
            //is it divisible by 3 or 5?
            //we can tell by checking against the remainder of division (modulus)
            if(i % 3 == 0 || i % 5 == 0){
                sum+=i;
            }
        }

        return sum;
    }

    private static int checkMultiples(){
        System.out.println("Using sum of multiples method");
        int sumThrees = 0;
        int sumFives = 0;
        int sumFifteens = 0;  //the least common multiple - any of these should not be counted twice

        for(int i = 3; i <= 999; i+=3){
            sumThrees+=i;
        }

        for(int j = 5; j <= 995; j+=5){
            sumFives+=j;
        }

        for(int k = 15; k <= 990; k+=15){
            sumFifteens+=k;
        }

        int sum = sumThrees + sumFives - sumFifteens;
        return sum;
    }

    private static int greedyMultiples(){
        System.out.println("Using greedy multiples method");
        int sumThrees = 0;
        int sumFives = 0;
        int sumFifteens = 0;  //the least common multiple - any of these should not be counted twice

        for(int i = 6; i <= 999; i+=6){
            sumThrees+=i+(i-3);
        }

        for(int j = 10; j <= 995; j+=10){
            sumFives+=j+(j-5);
        }

        for(int k = 30; k <= 990; k+=30){
            sumFifteens+=k+(k-15);
        }

        int sum = sumThrees + 999 + sumFives + 995 - sumFifteens;
        return sum;
    }

}
