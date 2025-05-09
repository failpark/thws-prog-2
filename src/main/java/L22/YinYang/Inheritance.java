package L22.YinYang;

public class Inheritance extends Thread {
	String msg;
	public Inheritance(String msg) {this.msg = msg;}
	public void run() {
		while (true) {
			System.out.println(this.msg);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		Inheritance t1 = new Inheritance("Yin");
		t1.start();
		Inheritance t2 = new Inheritance("Yang");
		t2.start();
	}
}
