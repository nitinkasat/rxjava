package com.rxjava.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rx.Observable;

public class RxJavaTest {

	@Test
	public void testMapOperator() {
		List<String> items = new ArrayList<>();
		items.add("item#1");
		items.add("item#-2");
		items.add("item#3");
		items.add("item#4");
		Observable.from(items).map(item -> item.split("#")[1])
				.filter(item -> item != null && !item.toString().isEmpty()).map(item -> Integer.valueOf(item))
				.filter(item -> item < 0)
				.subscribe(id -> System.out.println(id), item -> System.err.println("Error for value:-" + item));
	}

}
