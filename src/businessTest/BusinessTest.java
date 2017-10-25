package businessTest;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import business.Business;

public class BusinessTest {
	@Test
	public void testNewFunction() {
		assertEquals(2, Business.sum(1, 1));
	}

}
