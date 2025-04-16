package com.myapp.calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> results = new ArrayList<>();

    // static 메서드로 써보려했으나 results가 인스턴스 필드이기때문에 static 필드로 바꿔줘야하는 문제발생
    public int calculator(int num1, int num2, char oper) {
        int result = 0;
        boolean isChecked = false;

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
                    isChecked = true;
                    break;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 사칙연산 기호입니다.");
                isChecked = true;
                break;
        }
        // 잘못된 연산일시 연산결과에 저장x
        if (!isChecked) {
            results.add(result);
        }
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
