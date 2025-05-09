package L22.YinYang;

public class AnonClass {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run() {
				while (true) {
					System.out.println("Yin");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread(){
			public void run() {
				while (true) {
					System.out.println("Yang");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		t2.start();
	}
}
