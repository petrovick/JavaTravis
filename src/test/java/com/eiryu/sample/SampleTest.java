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

}
