package com.linkedin.learning.springdesignpatterns;

import com.linkedin.learning.springdesignpatterns.creational.prototype.ProtoFalse;
import com.linkedin.learning.springdesignpatterns.creational.prototype.ProtoTrue;
import com.linkedin.learning.springdesignpatterns.creational.singleton.SingA;
import com.linkedin.learning.springdesignpatterns.creational.singleton.SingB;
import com.linkedin.learning.springdesignpatterns.operational.repository.PresidentRepository;

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
	
	@Autowired
	private ProtoFalse protoFalse1;

	@Autowired
	private ProtoFalse protoFalse2;

	@Autowired
	private ProtoTrue protoTrue1;

	@Autowired
	private ProtoTrue protoTrue2;
	
	@Autowired
	private PresidentRepository presidentRepository;
	
	@Test
	public void testPrototypes() {
		Assertions.assertSame(protoFalse1, protoFalse2);
		Assertions.assertNotSame(protoTrue1, protoTrue2);
	}

	@Test
	public void testSingleton() {
		Assertions.assertNotNull(singB1, "The autowired instance is null");
		Assertions.assertSame(singB1, singB2);

		SingA singA1 = SingA.getInstance();
		SingA singA2 = SingA.getInstance();

		Assertions.assertNotNull(singA1, "The manually created single instance is null");
		Assertions.assertSame(singA1, singA2);
	}
	
	@Test
	public void testRepository() {
		System.out.println(presidentRepository.findById(1L));
		System.out.println(presidentRepository.findById(4L));
	}

}
