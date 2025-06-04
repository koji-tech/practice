// 自作の関数型インタフェースも実現できるが頻出するものはpackageに。
// import java.util.function.*;

// ラムダ式には単一メソッドのインタフェース(＝関数型インタフェース)しか対応しない
interface Truth{
	int age(int y);
}

public class Lambda {
	public static void main(String[] args) {
		Truth your = x -> 18;
		System.out.println("your age is " + your.age(27));
	}
}