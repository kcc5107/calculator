package com.myapp.calculator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            // 추후 예외처리?
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요 : ");
            double num2 = sc.nextDouble();
            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/) : ");
            char oper = sc.next().charAt(0);
            sc.nextLine();

            // static 메서드로 쓸때
//            int result = Calculator.calculator(num1, num2, oper);
            // 연산 메서드 호출
            double result = cal.calculate(num1, num2, oper);
            // 게터 메서드 사용
            List<Double> results = cal.getResults();
            System.out.println("현재까지의 연산 결과 : " + results);

            // 3번이나 exit 외에 입력시 무한루프
            boolean isTrue = true;
            while (isTrue) {
                System.out.print("1. 첫번째 연산 결과 삭제 2. 연산 결과 직접 수정 3. 다음 계산 (exit 입력 시엔 종료) \n" +
                        "4. 입력받은 값보다 큰 연산 결과 출력 : ");
                String select = sc.nextLine();
                switch (select) {
                    case "1":
                        // 첫 번째 연산결과 삭제
                        cal.removeResult();
                        System.out.println("삭제한 결과 : " + results);
                        break;
                    case "2":
                        System.out.print("숫자들을 띄워쓰기해서 입력해주세요 : ");
                        // 세터 메서드 사용
                        String[] s = sc.nextLine().split(" ");
                        results.clear();
                        for (String str : s) {
                            double a = Double.parseDouble(str);
                            results.add(a);
                        }
                        System.out.println("수정한 결과 : " + results);
                        // set은 수정하는데 쓰이지만 i번째 인덱스가 없을시 예외발생
//                    for (int i=0; i<s.length; i++) {
//                        results.set(i, Integer.parseInt(s[i]));
//                    }
                        cal.setResults(results);
                        break;
                    case "exit":
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    case "3":
                        isTrue = false;
                        break;
                    case "4":
                        System.out.print("숫자를 입력 : ");
                        double num3 = sc.nextDouble();
                        sc.nextLine();
                        System.out.println(num3 + "보다 큰 연산 결과 : " + cal.getGreaterResults(num3));
                        break;
                    default:
                        break;
                }
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
