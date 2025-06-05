public class AnonymousClass {
	public static void main(String[] args) {
		interface Impossible {
			void done();
		}
		// 実装込みのローカルクラスを省略しての宣言
		Impossible task = new Impossible() {
			// アノテーション自体には機能はないが注釈を入れるようなもの
			@Override
			public void done() {
				System.out.println("task was completed");
			}
		};

		task.done();
	}
}
