

import org.junit.Assert;
import org.junit.Test;

public class B {
	    @Test
	    public void B1() {
			System.out.println("B1");
	    }
		@Test
		public void B2() {
			System.out.println("B2");
		}
		@Test	
		public void B3() {
			Assert.assertTrue("verify url",false);
			System.out.println("B3");
}
}
