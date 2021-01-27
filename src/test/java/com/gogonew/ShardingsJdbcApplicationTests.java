package com.gogonew;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@SpringBootTest
class ShardingsJdbcApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void t1(){
		new T1().start();
	}

	@Test
	public void t2(){
		new Thread(new T2()).start();
	}

	@Test
	public void t3() throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new T3());
		new Thread(futureTask).start();
		boolean done = futureTask.isDone();
		long l1 = System.currentTimeMillis();
		String s = futureTask.get();//这个方法会阻塞，直到任务完成时会返回
		boolean done1 = futureTask.isDone();
		long l2 = System.currentTimeMillis();
		System.out.println("任务返回结果 = "+done+"   "+done1+"    time = "+(l2-l1)+"   "+s);
	}

	@Test
	public void t4() throws InterruptedException {
		final List<Integer> intList = new ArrayList<>();
		long start = System.currentTimeMillis();
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			Thread t = new Thread(() -> intList.add(random.nextInt()),"t4Thread");
			t.start();
			t.join();
		}
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(intList.size());
	}

	@Test
	public void t5() throws InterruptedException {
		final List<Integer> intList = new ArrayList<>();
		Random random = new Random();
		final ExecutorService executorService = Executors.newSingleThreadExecutor();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			executorService.execute(() -> intList.add(random.nextInt()));
		}
		executorService.shutdown();
		executorService.awaitTermination(1,TimeUnit.DAYS);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(intList.size());

	}

}

class T1 extends Thread {
	@Override
	public void run() {
		System.out.println("T1");
	}
}

class T2 implements Runnable {
	@Override
	public void run() {
		System.out.println("T2");
	}
}

class T3 implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "t3";
	}
}
