package com.eiryu.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SampleTest {

	@Test
	public void testSum() {
		int result = Sample.sum(1, 3);
		assertThat(result, is(4));
	}
	
	@Test
	public void testSum2() {
		int result = Sample.sum(-1, 3);
		assertThat(result, is(2));
	}
	

	@Test
	public void testSum3() {
		Sample s = new Sample();
		int result = s.sum(2, 2);
		assertThat(result, is(4));
	}
}
