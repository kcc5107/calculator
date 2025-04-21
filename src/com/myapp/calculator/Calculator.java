package com.myapp.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator<D> {
    private List<Double> results = new ArrayList<>();

    // static 메서드로 써보려했으나 results가 인스턴스 필드이기때문에 results 또한 static 필드로 바꿔줘야하는 문제가 발생
    public <T extends Number, S> double calculate(T num1, T num2, S oper) {
        double result = 0;
        boolean isChecked = false;

        try {
        OperatorType op = OperatorType.checkOperator((Character) oper);
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
//                        System.out.println("나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.");
                        isChecked = true;
                        throw new ArithmeticException();
                    }
                    result = num1.doubleValue() / num2.doubleValue();
                    break;
//                default:
//                    System.out.println("잘못된 사칙연산 기호입니다.");
//                    isChecked = true;
//                    break;
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
        }
        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

}
