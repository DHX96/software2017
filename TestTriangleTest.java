package cn.tjuscs.st;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTriangleTest {

	TestTriangle t = new TestTriangle();
	
	@Test
	public void test_not_a_triangle() {
		assertEquals(-1,t.getkind(1,2,3));
	}
	@Test
	public void test_equilateral() {
		assertEquals(1,t.getkind(2,2,2));
	}
	@Test
	public void test_isosceles() {
		assertEquals(2,t.getkind(2,2,3));
	}
	@Test
	public void test_scalene() {
		assertEquals(3,t.getkind(2,3,4));
	}
	
	
}
