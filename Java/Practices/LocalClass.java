public class LocalClass {
	public static void main(String[] args) {
		// class > method > classの構造を持つ。インデント多いなぁ。
		// ローカルスコープのためメソッド内のみ利用可
		class Local {
			public void hoge() {
				System.out.println("hogehoge.");
			}
		}

		// オブジェクトを宣言、関数を呼び出す。
		Local cls = new Local();
		cls.hoge(); // >>>hogehoge.
	}
}
