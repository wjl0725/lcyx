package filter;

public class test {
	public static void main(String[] args) {
		String a="123\\456\\789\\0";
		a= a.replaceAll("\\","#");
		String[] b=a.split("#");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
