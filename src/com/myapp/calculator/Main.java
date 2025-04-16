package com.myapp.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/) : ");
            char oper = sc.next().charAt(0);

            // static 메서드로 쓸때
//            int result = Calculator.calculator(num1, num2, oper);
            int result = cal.calculator(num1, num2, oper);
            System.out.println("결과: " + result);
            ArrayList<Integer> results = cal.getResults();
            System.out.println("현재까지의 연산 결과 : " + results);
            System.out.print("1. 첫번째 연산 결과 삭제 2. 연산 결과 직접 수정 3. 다음 계산 (exit 입력 시엔 종료) : ");
            sc.nextLine();
            String select = sc.nextLine();
            System.out.println(select);
            switch (select) {
                case "1":
                    cal.removeResult();
                    break;
                case "2":
                    System.out.print("숫자들을 띄워쓰기해서 입력해주세요");
                    String[] s = sc.nextLine().split(" ");
                    results.clear();
                    for (String str : s) {
                        int a = Integer.parseInt(str);
                        results.add(a);
                    }
                    // set은 수정하는데 쓰이지만 i번째 인덱스가 없을시 예외발생
//                    for (int i=0; i<s.length; i++) {
//                        results.set(i, Integer.parseInt(s[i]));
//                    }
                    cal.setResults(results);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("default");
                    break;
            }
        }
//            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
//            sc.nextLine();
//            String check = sc.nextLine();
//            if(check.equals("exit")) {
//                return;
//            }
    }
}
