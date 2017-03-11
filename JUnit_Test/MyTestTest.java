package cn.tjuscs.st;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class MyTestTest {
	
	MyTest t=new MyTest();

	@Test
	public void testAdd() {
		t.add(1,4);
        assertEquals(5, t.getresult());
	}
	
	@Test
	public void testSubstract() {
		t.substract(6,4);
        assertEquals(5, t.getresult());
	}
	
}
