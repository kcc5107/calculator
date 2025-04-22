package com.myapp.calculator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("입력이 잘못되었습니다.");
                sc.nextLine();
                continue;
            }
            // 게터 메서드 사용
                List<Double> results = cal.getResults();
                System.out.println("현재까지의 연산 결과 : " + results);

            // 3번이나 exit 외에 입력시 무한루프
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("""
                        
                        1.새 계산  2.첫번째 연산 결과 삭제  3.연산 결과 오름차순 정렬  4.제일 작은 연산 결과 삭제 \s
                        5.연산 결과 직접수정  6.입력한 값보다 큰 연산 결과들 출력  [exit를 입력하면 종료합니다.] \s""");
                System.out.print("원하는 기능의 번호 입력 : ");
                String select = sc.nextLine();
                switch (select) {
                    case "1":
                        isTrue = false;
                        break;
                    case "2":
                        cal.removeFirstResult();
                        break;
                    case "exit":
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    case "3":
                        System.out.println("오름차순 정렬 : " + cal.sortedResults());
                        break;
                    case "4":
                        cal.removeMinResult();
                        break;
                    case "5":
                        System.out.print("숫자들을 띄워쓰기해서 입력해주세요 : ");
                        // 세터 메서드 사용
                        String inputStr = sc.nextLine();
                        cal.setResultsInput(inputStr);
                        // set은 수정하는데 쓰이지만 i번째 인덱스가 없을시 예외발생
//                    for (int i=0; i<s.length; i++) {
//                        results.set(i, Integer.parseInt(s[i]));
//                    }
                        break;
                    case "6":
                        System.out.print("숫자를 입력 : ");
                        try {
                            double num3 = sc.nextDouble();
                            System.out.println(num3 + "보다 큰 연산 결과 : " + cal.getGreaterResults(num3));
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                        }
                        sc.nextLine();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
