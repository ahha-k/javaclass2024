package project2024;
import java.util.Random;
// 생각한게 맞다면 입력받는 값은 없고 랜덤으로 구구단을 출력받아서 정답입니다, 오답입니다만 나오는 코드인 것 같다.
public class Homework_240324_Q2 {
    private static int[][] fixedMultiplicationTable = new int[][]{
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
        new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18},
        new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27},
        new int[]{4, 8, 12, 16, 20, 24, 28, 32, 36},
        new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45},
        new int[]{6, 12, 18, 24, 30, 36, 42, 48, 54},
        new int[]{7, 14, 21, 28, 35, 42, 49, 56, 63},
        new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72},
        new int[]{9, 18, 27, 36, 45, 54, 63, 72, 81}
};

private static final int CHECK_COUNT = 9;
private static final Random random = new Random();
private static int matchCounter = 0;

public static void main(String[] args) {
    loopMultiplicationTable(random.nextInt(9) + 1);
    if (matchCounter == CHECK_COUNT) {
        System.out.println("정답입니다.");
    } else {
        System.out.println("오답입니다.");
    }
}

/**
 * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
 * first 파라미터를 행으로 두고, 1부터 9까지 반복하여 matchMultiplicationTable 메서드를 호출해야 합니다.
 *
 * @param first 구구단의 행
 */
private static void loopMultiplicationTable(int first) {
    for (int row = 1; row <= 9; row++) {
        int result = checkMultiplicationTable(first, row);
        matchMultiplicationTable(first, row, result);
    }
}


private static int checkMultiplicationTable(int first, int second) {
    return first * second; // 고친 부분
}

// 해당 메서드는 고칠 부분 X : 주어진 값과 일치 한다면 1증가
private static void matchMultiplicationTable(int first, int second, int result) {
    if (fixedMultiplicationTable[first - 1][second - 1] == result) {
        matchCounter++;
    }
}
}
