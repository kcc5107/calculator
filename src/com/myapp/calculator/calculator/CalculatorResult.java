package com.myapp.calculator.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorResult {
    private List<Double> results = new ArrayList<>();

    // 게터 메서드
    public List<Double> getResults() {
        return results;
    }

    // 연산 결과값 추가
    public void addResult(double result) {
        results.add(result);
    }

    // 입력받은 숫자들로 연산 결과 필드를 수정 (세터 활용)
    public void setResultsInput(String inputStr) {
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

    // 세터 메서드
    private void setResults(List<Double> results) {
        this.results = results;
        System.out.println("\n수정한 결과 : " + results);
    }

    // 첫 번째 연산 결과 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            double tempNum = results.get(0);
            results.remove(0);
            System.out.println("\n첫 번째 연산 결과 " + tempNum + " 삭제한 결과 : " + results);
        }
    }

    // 입력받은 값보다 큰 연산 결과 출력
    public List<Double> getGreaterResults(double number) {
        return results.stream().filter(num -> num > number).collect(Collectors.toList());
    }

    // 연산 결과 오름차순 정렬 (메서드에서만 사용)
    private List<Double> sortedResults() {
        return results.stream().sorted().collect(Collectors.toList());
    }

    // 오름차순 정렬한 것을 저장 (덮어쓰기)
    public List<Double> sortedResultsSave() {
        List<Double> collect = sortedResults();
        results.clear();
        results.addAll(collect);
        return results;
    }

    // 가장 작은 연산 결과값을 삭제 (정렬 메서드 재활용)
    public void removeMinResult() {
        double min = sortedResults().get(0);
        results.remove(min);
        System.out.println("\n가장 작은 연산 결과 " + min + " 삭제한 결과 : " + results);
    }
}
