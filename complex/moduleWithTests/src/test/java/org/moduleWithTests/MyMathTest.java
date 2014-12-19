package org.moduleWithTests;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyMathTest extends TestCase {

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	protected void setUp() throws Exception {
		log.info("Setting up");
	};
	
	@Override
	protected void tearDown() throws Exception {
		log.info("Tearing down the stuff... Completely... Forever... Now...");
	}
	
	public void testAdd() {
		MyMath m = new MyMath();
		int a = 2;
		int b = 1;
		assertEquals("Fuck, adding is not working at all!!!", 3, m.add(a, b));
	}
	
	public void testNeverWorking(){
		MyMath m = new MyMath();
		assertNotNull("It should not be null!!!", m);
		int a = 2;
		int b = 1;
		assertEquals("Fuck, adding is not working at all!!!", 3, m.add(a, b));
	}
	
	public void testSub (){
		MyMath m = new MyMath();
		assertEquals("SUB is not working!!", 4, m.sub(10, 2));
		assertEquals("SUB is not working!!", 0, m.sub(2, 2));
	}
}
