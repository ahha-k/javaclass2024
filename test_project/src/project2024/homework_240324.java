package project2024;
import java.util.Scanner;
public class homework_240324 {
    public static void main(String[] args) {
        double score = getAverageScore(new Scanner(System.in));
        System.out.printf("당신의 점수는 %.2f점 입니다.%n", score);
        System.out.printf("당신은 %s 등급 입니다.", estimateGrade(score));
    }
    private static double getAverageScore(Scanner scanner) {
        int loop = 0;
        int score = 0;
        while (true) {
            System.out.print("점수를 입력하세요 (0 입력 시 종료): ");
            int input = scanner.nextInt();
            
            if (input == 0) {
                break;//사용자가 0을 입력할 경우 break 해야 한다는 조건1
            }// 아래 주어졌던 부분에 넣을 시 나누는 숫자가 하나 더 늘어나 0점도 포함이 되어서 위로 올렸습니다
            score += input;
            loop++;
        }
        return ((double)score) /((double)loop);
    }
    private static String estimateGrade(double averageScore) {
        if (averageScore >= 90) {
            return "A";
        } else if (averageScore >= 80) {
            return "B";
        } else if (averageScore >= 70) {
            return "C";
        } else {
            return "D";
        }
    }
}