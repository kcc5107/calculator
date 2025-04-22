package com.myapp.calculator.calculator;

public class Calculator {

    // static 메서드로 써보려했으나 results가 인스턴스 필드이기때문에 results 또한 static 필드로 바꿔줘야하는 문제가 발생(세터 못씀)
    // -> 연산 결과를 제어하는 클래스 분리 후 static으로 변경
    public static <T extends Number> double calculate(T num1, T num2, char oper) throws IllegalArgumentException, ArithmeticException {
        double result = 0;

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
                    throw new ArithmeticException();
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
        }
        System.out.println("연산 결과 : " + result);
        return result;
    }
}