package com.myapp.calculator;

public enum OperatorType {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private char oper;

    OperatorType(char oper) {
        this.oper = oper;
    }

    static OperatorType checkOperator(char oper) {
        for (OperatorType op : OperatorType.values()) {
            if (op.oper == oper) {
                return op;
            }
        }
        // 강제로 예외를 던지기
        throw new IllegalArgumentException();
    }
}
