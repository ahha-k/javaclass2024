package class240328;
import java.util.Random;

public class RollTheDice {
    private static int[] frequency = new int[6];
    private static Random RANDOM = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 600; i++) {
            if (RANDOM.nextDouble() < 0.1) {
                fillArray(RANDOM.nextDouble() * 720);
            } else {
                fillArray(RANDOM.nextDouble() * 360);
            }
        }
    }
    /**
     * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
     * 주어진 값을 60으로 나눈 후, 나온 값의 수만큼 해당 인덱스에 존재하는 배열 값을 1 증가시켜야 합니다.
     * > /60 => 의 결과값만큼 +1
     * 또한, 어떠한 경우에서도 주어진 기능을 구현했을 떄, 오류가 발생해서는 안됩니다.
     * <p>
     * 입력값은 일반적으로는 360을 넘지 않으나, 낮은 확률로 360을 넘습니다.
     * 이러한 경우, extendArray 메서드를 구현하여 이를 이용해 배열을 재선언해야 합니다.
     * >> 재선언을 위헤서 frequency = 위 배열이라고 작성을 했고 index + 1을 통해서 확장
     * < ? 근데 확장을 시켰을 때 다른 숫자가 나올 확률은 잘 이해가 되지 않음.
     *
     * 또한, 입력값이 double임으로 60으로 나눈 이후 int로 캐스팅이 필요합니다.// (int)를 추가해라.
     */
    
    private static void fillArray(double result) {
        int index = (int) (result / 60); // 입력값을 60으로 나눈 후 int로 캐스팅 <조건 확인
        if (index >= frequency.length) {
            frequency = extendArray(index + 1); // 인덱스가 배열 길이보다 크면 배열을 확장하기 위함 > 인덱스에서 +1을 해야 제대로 된 길이를 알 수 있으니까
        }
        frequency[index]++; // 배열값을 1 증가시키라고 하심
    }
    // https://www.delftstack.com/ko/howto/java/increase-array-size-in-java/ <= 해당 주소를 참고했음
    /**
     * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
     * 주어진 값의 크기만큼 배열을 생성한 후, 기존 배열에 있던 데이터를 복사해 반환해야 합니다.'
     * 배열 생성을 위해서는 int[] 이름 = new int~ 의 방식을 사용해야한다. < 필수 체크하라고 하셨던 부분 같음.
     */
    private static int[] extendArray(int next) {
        int[] newArray = new int[next+1]; // 새 배열을 생성하는 방법은 new int ~ 의 방법을 쓰는 것. -> 크기를 하나 증가시켜야 하니까 인덱스에 +1
        for (int i = 0; i < frequency.length; i++) {//하나하나 복사해서 붙여넣는 함수.
            newArray[i] = frequency[i];
        }
        return newArray;
    }
}