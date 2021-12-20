package com.linkedin.learning.springdesignpatterns;

import com.linkedin.learning.springdesignpatterns.creational.singleton.SingA;
import com.linkedin.learning.springdesignpatterns.creational.singleton.SingB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDesignPatternsApplicationTests {

	@Autowired
	private SingB singB1;

	@Autowired
	private SingB singB2;

	@Test
	public void testSingleton() {
		Assertions.assertNotNull(singB1, "The autowired instance is null");
		Assertions.assertSame(singB1, singB2);

		SingA singA1 = SingA.getInstance();
		SingA singA2 = SingA.getInstance();

		Assertions.assertNotNull(singA1, "The manually created single instance is null");
		Assertions.assertSame(singA1, singA2);
	}

}
