package L22.YinYang;

public class IRunnable implements Runnable {
	String msg;
	public IRunnable(String msg) {this.msg = msg;}
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
		Thread t1 = new Thread(new IRunnable("Yin"));
		t1.start();
		Thread t2 = new Thread(new IRunnable("Yang"));
		t2.start();
	}
}
