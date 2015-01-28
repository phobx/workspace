package players;

import java.util.Calendar;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import players.dto.Player;
import players.dto.Team;
import players.services.PlayersService;

public class TeamsTest extends TestCase {

	private ClassPathXmlApplicationContext ctx;
	private PlayersService playersService;

	protected void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("hibernate-app-ctx.xml", "test-datasource-ctx.xml");
		playersService = (PlayersService) ctx.getBean("playersService");
	}

	protected void tearDown() throws Exception {
		ctx.close();
	}

	public void testGetTeamByName() {
		Team t = playersService.getTeamByName("Льдинка-2003-1");
		Set<Player> players = t.getPlayers();
		assertNotNull("Team should not be null", t);
		assertTrue("There should be players in the team", players.size() > 0);
		for (Player p : players) {
			System.out.println(p);
		}
	}

	public void testGetTeamById() {
		Team t = playersService.getTeamById(1);
		assertNotNull("Team should not be null", t);
	}

	public void testPlayerCreate() {
		Player p = new Player();
		p.setBirthDate(Calendar.getInstance());
		p.setFirstName("Vasyl");
		p.setLastName("Pupko");
		p.setHeight(48);
		p.setWeight(4);
		playersService.updatePlayer(p);
	}

	public void testTeamCreate() {
		Player p = new Player();
		p.setBirthDate(Calendar.getInstance());
		p.setFirstName("One");
		p.setLastName("First");
		p.setHeight(48);
		p.setWeight(4);
		playersService.updatePlayer(p);

		Player p2 = new Player();
		p2.setBirthDate(Calendar.getInstance());
		p2.setFirstName("Two");
		p2.setLastName("Second");
		p2.setHeight(48);
		p2.setWeight(4);
		playersService.updatePlayer(p2);

		Team t = new Team();
		t.setName("Dream Team 2");
		t.setLeagueId(1);
		t.getPlayers().add(p);
		t.getPlayers().add(p2);

		playersService.updateTeam(t);

		Team t2 = playersService.getTeamByName("Dream Team 2");
		for (Player tp : t2.getPlayers()) {
			System.out.println(tp);
		}
	}

	public void testTeamCreate2() {
		Player p = new Player();
		p.setBirthDate(Calendar.getInstance());
		p.setFirstName("One1");
		p.setLastName("First");
		p.setHeight(48);
		p.setWeight(4);

		Player p2 = new Player();
		p2.setBirthDate(Calendar.getInstance());
		p2.setFirstName("Two1");
		p2.setLastName("Second");
		p2.setHeight(48);
		p2.setWeight(4);

		Team t = new Team();
		t.setName("Dream Team 3");
		t.setLeagueId(1);
		t.getPlayers().add(p);
		t.getPlayers().add(p2);

		playersService.updateTeam(t);

		Team t2 = playersService.getTeamByName("Dream Team 3");
		for (Player tp : t2.getPlayers()) {
			System.out.println(tp);
		}
	}
}
