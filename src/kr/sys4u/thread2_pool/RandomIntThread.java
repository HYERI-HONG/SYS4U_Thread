package kr.sys4u.thread2_pool;

import java.util.concurrent.Callable;

public class RandomIntThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		return (int) (Math.random() * 100);
		
	}
}
