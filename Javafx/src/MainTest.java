
public class MainTest {
	public static void main(String[] args) {
		byte b = 114;
		char a = (char)b;
		System.out.println(a);
	}

	private void method01() {
		char a = ' ';
		char b = '*';
		System.out.println((byte)a);
		System.out.println((byte)b);
		char c = 'x';
		char d = '/';
		System.out.println((byte)c);
		System.out.println((byte)d);
	}
}
