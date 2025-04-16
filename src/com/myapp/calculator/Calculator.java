package com.myapp.calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> results = new ArrayList<>();

    public int calculator(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.");
                    break;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 사칙연산 기호입니다.");
                break;
        }
        // static 메서드로 써보려했으나 results가 인스턴스 필드이기때문에 static 필드로 바꿔줘야하는 문제발생
        results.add(result);
        return result;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

}
