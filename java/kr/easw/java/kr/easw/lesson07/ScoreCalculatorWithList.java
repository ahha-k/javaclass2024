package kr.easw.lesson07;

import java.util.ArrayList;//얘가 없어서 추가했음.. array사용하는대
import java.util.List; //list도
import java.util.Scanner;
/**
 * 이전 2개의 예제에서 소개된 List 컬렉션과 제너릭스를 이용해 평균 점수 계산기를 만들어보세요.
 * 
 * 종료하고 싶으면 exit를 작성해야한다/
 *
 * **반드시** CalculatorImpl 클래스만 수정하여 문제를 풀어야 합니다.
 *
 * 해당 문제는 다음과 같은 제한 사항이 있습니다 :
 * - CalculatorImpl 클래스는 Calculator 인터페이스를 구현해야 합니다.
 * - CalculatorImpl 클래스는 List를 반드시 사용해야 합니다.
 * - 구동시 오류가 발생하지 않아야 합니다.
 * - 입력된 점수가 없을 경우, RuntimeException을 발생시켜야 합니다.
 */
public class ScoreCalculatorWithList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new CalculatorImpl();

        while (true) {
            System.out.println("Enter the subject and score.");
            System.out.print("> ");
            String subject = scanner.next();
            if (subject.equals("exit")) {//exit을 말해야만!!!! 종료
                break;
            }
            int score = scanner.nextInt();
            calculator.addScore(subject, score);
        }
        System.out.printf("Subject Counts: %d; Average: %.2f; ", calculator.getSubjectCount(), calculator.getAverage());
    }

    interface Calculator {
        void addScore(String subject, int score);

        double getAverage();

        int getSubjectCount();
    }

    static class CalculatorImpl implements Calculator {
    	private final List<Score> scores = new ArrayList<>();
//------------여기서 코드 작성하라고 하신 부분 고치기-------------------------------
    	//----위에는 안건들였음 수정하지 말아라 XXXX-------------------------------
        
    	@Override
        public void addScore(String subject, int score) {
    		scores.add(new Score(subject, score));//점수를 더하는 함수니까 add 사용
        }

        @Override
        public double getAverage() {
            int sum = 0;
            for (Score score : scores) {
                sum += score.getScore();//더하고 더한 거 나눠야됨
            }
            return (double) sum / scores.size();//나누는 건 받은 크기로
        }

        @Override
        public int getSubjectCount() {
        	return scores.size();
        }
    }

    //------------------------------------------------------------------------
    static class Score {
        private final String subject;
        private final int score;

        public Score(String subject, int score) {
            this.subject = subject;
            this.score = score;
        }

        public String getSubject() {
            return subject;
        }

        public int getScore() {
            return score;
        }
    }
}
