package scenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：<br>
 * 3个线程交替打印a,b,c
 * @ClassName ThreadsPrintNumsAlternately
 * @Author liucan
 * @Date 2019/11/4 下午4:31
 * @Version 1.0
 **/
public class ThreadsPrintNumsAlternately {
	private int index = 1;
	Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();

	public void printA() {
		lock.lock();
		try {
			if (index != 1) {
				c1.await();
			}
			if (index == 1) {
				System.out.println("A");
				Thread.sleep(500);
			}
			index = 2;
			c2.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void printB() {
		lock.lock();
		try {
			if (index != 2) {
				c2.await();
			}
			if (index == 2) {
				System.out.println("B");
				Thread.sleep(500);
			}
			index = 3;
			c3.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void printC() {
		lock.lock();
		try {
			if (index != 3) {
				c3.await();
			}
			if (index == 3) {
				System.out.println("C");
				Thread.sleep(500);
			}
			index = 1;
			c1.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print() {
		Runnable r1 = () -> {
			while (true) {
				printA();
			}
		};

		Runnable r2 = () -> {
			while (true) {
				printB();
			}

		};

		Runnable r3 = () -> {
			while (true) {
				printC();
			}

		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}

	public static void main(String[] args) throws IOException {
		ThreadsPrintNumsAlternately a = new ThreadsPrintNumsAlternately();
//		a.print();
		BufferedReader reader = Files.newBufferedReader(Paths.get("/home/liucan/桌面/项目细节.txt"));
		String str = null;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
	}
}
