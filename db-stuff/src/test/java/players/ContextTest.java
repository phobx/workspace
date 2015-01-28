package players;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import players.services.PlayersService;

public class ContextTest extends TestCase {

	public void testContextCreation() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("hibernate-app-ctx.xml");
		PlayersService playersService = (PlayersService) ctx.getBean("playersService");
		assertNotNull("Service should not be null", playersService);
		ctx.close();
	}

}
