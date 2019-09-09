package ir.omidashouri.omidpetclinic;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(SpringRunner.class) : for Junit 4
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OmidPetClinicApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Test Junit 5");
	}

}
