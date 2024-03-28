package class240328;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGameWithoutTails {

    private static final int BOARD_SIZE = 10;
    // 0 - 빈 타일
    // 1 - 스네이크 블럭
    // 2 - 아이템
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    private static final Random RANDOM = new Random();

    private static int score = 0;

    private static SnakeLocation location = new SnakeLocation(0, 0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("[우측 (r) | 좌측 (l) | 위 (u) | 아래 (d) | 종료 (0) ] : ");
            if (!nextDirection(scanner.next())) {
                System.out.println("게임 오버!");
                System.out.printf("점수: %d\n", score);
                break;
            }
            if (!hasItemOnBoard())
                placeRandomItem();
        }
    }
    /**
     * 해당 메서드는 다음과 같은 역할을 가져야 합니다 
     * 사용자의 입력을 받고, 다음 위치로 옮기거나 게임을 종료해야 합니다. -> 0,0에서 움직이는 거라고 생각하면 편할 것 같다.
     * <p>
     * 허용되는 입력은 다음과 같습니다 :
     * - 우측(r) | 좌측 (l) | 위 (u) | 아래 (d) | 종료 (0)
     * 우측이면 x 좌표를 1 올려야하고, 좌측이면 x 좌표를 1 빼야 한다고 이해했음.
     * 그리고 위면 y 좌표를 1 올리고, 아래면 y 좌표를 1 뺴야 한다. 0을 입력 시 해당 좌표 값을 반환하고
     * 게임을 나오는 코드를 구성해야한다.  >> newX, newY 라는 새로운 좌표를 입력받아야한다.
     * <p>
     * 
     * 다음 좌표는 location 변수에 계속해서 업데이트되어야 합니다.
     * 만약 다음 좌표에 아이템이 존재한다면, 점수를 1 증가하고 다음 좌표의 값을 0으로 되돌려야 합니다.
     * > 아이템이니까 score을 +1하고 해당 좌표를 0으로 돌리기 -> 아이템은 2니까 해당 값 체크
     *
     * 만약 값이 최대 값 (BOARD_SIZE)이상이 되거나 최소 값(0) 아래로 내려간다면 같은 좌표로 설정하여 이동하지 않도록 해야합니다.
     * -> 보드 사이즈-> 10을 넘으면 같은 좌표로? : 0으로 만들라는 뜻?
     *
     * 만약 사용자의 입력이 종료(0)였다면, false 값을 반환하여 게임을 종료해야 합니다.
     * case가 0일때 게임을 종료할 수 있게.
     */
    private static boolean nextDirection(String keyword) {
        int newX = location.x; //location 여기에서 받아와햐하니까.
        int newY = location.y;
        switch (keyword) {
            case "r":
            	newY++;//오른쪽 > 오류가 나서 x랑 y를 바꿨다. 행렬이니까 바뀐다.
                break;
            case "l":
            	newY--;//왼쪽
                break;
            case "u":
            	newX--;//아래
                break;
            case "d":
            	newX++;//위로 이동
                break;
            case "0":
                return false;//0이 입력됐으니까 종료
        }
        
        if (newX < 0) {
            newX = 0;//원래의 코드와 동일하게 하라고 했으니까.
        }
        if (newX >= BOARD_SIZE) {
            newX = BOARD_SIZE-1;
        }
        if (newY < 0) {
            newY = 0;//0으로 돌아오게 
        }
        if (newY >= BOARD_SIZE) {
            newY = BOARD_SIZE-1; //인덱스가 자바는 최대보다 크기까 -1 해야한다.
        }

        location = new SnakeLocation(newX, newY);
        if (board[newX][newY] == 2) {//2에 해당하면 아이템이라고 했음
            score++; // 점수 증가
            board[newX][newY] = 0; //다음 좌표의 값을 0으로 되돌려야 합니다.< 의 조건만족
            // 0 - 빈 타일
            // 1 - 스네이크 블럭
            // 2 - 아이템 < 위 조건 다시 가져왔음.
        }
        return true; // 게임 진행
    }
    
    
    /////여기서부턴 조교님 > 수정사항을 확인해라
    private static void printBoard() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (location.getX() == x && location.getY() == y) {
                    System.out.print("◼ ");
                    continue;
                }
                switch (board[x][y]) {
                    case 0:
                        System.out.print("・ ");
                        break;
                    case 1:
                        System.out.print("◼");
                        break;
                    case 2:
                        System.out.print("* ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private static void placeRandomItem() {
        // for문의 조건으로 랜덤을 넣을 경우, 계속 비교하여 최종 결과값이 바뀌므로 변수로 선언합니다.
        int toPlace = (int) (RANDOM.nextDouble() * 10);
        for (int i = 0; i < toPlace; i++) {
            int retry = 0;
            while (retry < 5) {
                SnakeLocation locate = new SnakeLocation((int) (RANDOM.nextDouble() * (BOARD_SIZE - 1)), (int) (RANDOM.nextDouble() * (BOARD_SIZE - 1)));
                if (board[locate.getX()][locate.getY()] != 0) {
                    retry++;
                    continue;
                }
                board[locate.getX()][locate.getY()] = 2;
                break;
            }
        }
    }

    private static boolean hasItemOnBoard() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class SnakeLocation {
        private final int x;
        private final int y;

        public SnakeLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public SnakeLocation adjust(int x, int y) {
            return new SnakeLocation(this.x + x, this.y + y);
        }
    }
}