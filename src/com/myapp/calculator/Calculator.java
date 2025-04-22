package com.myapp.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private List<Double> results = new ArrayList<>();

    // static 메서드로 써보려했으나 results가 인스턴스 필드이기때문에 results 또한 static 필드로 바꿔줘야하는 문제가 발생
    <T extends Number> double calculate(T num1, T num2, char oper) {
        double result = 0;
        boolean isChecked = false;

        try {
        OperatorType op = OperatorType.checkOperator(oper);
            switch (op) {
                case ADD:
                    result = num1.doubleValue() + num2.doubleValue();
                    break;
                case SUBTRACT:
                    result = num1.doubleValue() - num2.doubleValue();
                    break;
                case MULTIPLY:
                    result = num1.doubleValue() * num2.doubleValue();
                    break;
                case DIVIDE:
                    if (num2.doubleValue() == 0) {
                        isChecked = true;
                        throw new ArithmeticException();
                    }
                    result = num1.doubleValue() / num2.doubleValue();
                    break;
            }
        } catch (IllegalArgumentException e) {
            isChecked = true;
            System.out.println("잘못된 사칙연산 기호입니다.");
        } catch (ArithmeticException e) {
            System.out.println("나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.");
        }
        // 잘못된 연산일시 연산결과에 저장x
        if (!isChecked) {
            System.out.println("결과: " + result);
            results.add(result);
            return result;
        }
        throw new ArithmeticException();
    };

    List<Double> getResults() {
        return results;
    }

    void setResultsInput(String inputStr) {
        String[] str = inputStr.split(" ");
        List<Double> tempList = new ArrayList<>();
        // 문자열안에 숫자가 아닐경우 예외처리
        try {
            for (String s : str) {
                double num = Double.parseDouble(s);
                tempList.add(num);
            }
            results.clear();
            results.addAll(tempList);
            setResults(results);
        } catch (NumberFormatException e) {
            System.out.println("숫자들이 제대로 입력되지않았습니다.");
        }
    }

    void setResults(List<Double> results) {
        this.results = results;
        System.out.println("수정한 결과 : " + results);
    }

    void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
        System.out.println("삭제한 결과 : " + results);
    }

    List<Double> getGreaterResults(double number) {
        return results.stream().filter(num -> num > number).collect(Collectors.toList());
    }

    List<Double> sortedResults() {
        return results.stream().sorted().collect(Collectors.toList());
    }

    void removeMinResult() {
        double min = sortedResults().get(0);
        results.remove(min);
        System.out.println("삭제한 결과 : " + results);
    }
}
