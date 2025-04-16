package com.myapp.calculator;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int num2 = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요(+,-,*,/) : ");
        char oper = sc.next().charAt(0);

        int result = 0;
        switch(oper) {
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
                if(num2==0) {
                    System.out.println("나눗셈 연산에서 두 번째 숫자에 0이 입력될 수 없습니다.");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 사칙연산 기호입니다.");
                return;
        }
        System.out.println("결과: " + result);
    }
}
