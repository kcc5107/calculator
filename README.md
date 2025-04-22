# 계산기 프로그램

숫자 2개와 사칙연산 기호를 스캐너로 입력받아 간단한 계산을 해주는 콘솔 프로그램입니다.

## 사용 기술
`Java`, `Enum`, `제네릭`, `Lambda & Stream` 등

## 기능 설명
- 간단한 사칙연산 계산
- 계산 결과 리스트에 저장
- 잘못된 입력값으로 오작동시 재입력하도록 설정
- 연산 결과중 첫 번째로 저장된 값 삭제
- 연산 결과 오름차순으로 정렬하여 저장
- 연산 결과중 가장 작은 값 삭제
- 연산 결과 리스트를 직접 수정
- 입력한 값보다 큰 연산 결과를 출력
- exit입력으로 프로그램 종료

## 파일 디렉토리 구조
```
src/
├── Main.java
├── calculator/
│   ├── Calculator.java
│   ├── CalculatorResult.java
│   └── OperatorType.java
```

## 트러블슈팅
https://github.com/kcc5107/TIL/blob/main/2025-04-16.md
https://github.com/kcc5107/TIL/blob/main/2025-04-17.md
https://github.com/kcc5107/TIL/blob/main/2025-04-21.md
https://github.com/kcc5107/TIL/blob/main/2025-04-22.md