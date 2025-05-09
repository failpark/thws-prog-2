package L22.YinYang;

public class LocalClass {
	public static void main(String[] args) {
		class LocoThread extends Thread {
			String msg;
			public LocoThread(String msg){this.msg = msg;}
			public void run() {
				while(true) {
					System.out.println(msg);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		Thread t1 = new LocoThread("Yin");
		t1.start();
		Thread t2 = new LocoThread("Yang");
		t2.start();
	}
}
