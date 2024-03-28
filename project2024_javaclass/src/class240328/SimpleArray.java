package class240328;
import java.util.Arrays;

public class SimpleArray {
    private static int[] arrays = new int[10];
    private static int[] answer = new int[]{0, 1, 4, 16, 25, 49, 64, 81, 121, 144};
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            fillArray(i);
        }
        boolean isMatched = true;
        for (int i = 0; i < 10; i++) {
            if (arrays[i] != answer[i]) {
                System.out.printf("값이 일차하지 않습니다. (인덱스 %d)\n", i);
                isMatched = false;
            }
        }
        if (isMatched) {
            System.out.println("정답입니다.");
        } else {
            System.out.println("오답입니다.");
        }
    }
    /**
     * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
     * 주어진 인덱스를 이용하여 array 변수에 다음 수식을 적용하여 추가해야 합니다.
     * <p>
     * (index x 7 / 5) ^ 2
     * <p>
     * * ^2는 제곱의 의미로 사용되었습니다.
     */
    private static void fillArray(int index) {
        arrays[index] = (int) Math.pow((index * 7 / 5), 2);
    }// array 변수에 아래 수식을 집어넣은 것. 
    //값이 일치하는 지 아닌지에 대한 답이 나오는 것. 제곱을 하기 위해서는 Math.pow 함수를 사용해야 한다.
    // 따라서 뒤에 int 를 사용해서 숫자로 바꿔주고 Math.pow라는 제곱 함수에 위 공식을 대입한 것.
}