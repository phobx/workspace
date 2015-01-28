import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import players.dto.Player;
import players.services.PlayersService;

public class HibernateLauncher {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("hibernate-app-ctx.xml");
		PlayersService playersService = (PlayersService) ctx.getBean("playersService");
		List<Player> players = playersService.getAllPlayers();
		for (Player p : players) {
			System.out.println(p);
		}
		/*
		 * Player averagePlayer = playersService.getAveragePlayer();
		 * System.out.println("Average weight: " + averagePlayer.getWeight() +
		 * ". Average height: " + averagePlayer.getHeight());
		 */

		System.out.println("Max weight of players is " + playersService.getMaxWeight());
		System.out.println("Min weight of players is " + playersService.getMinWeight());

		int randomId = new Random().nextInt(players.size()) + 1;
		Player randomPlayer = playersService.getById(randomId);
		System.out.println("Random player : " + randomPlayer);
		System.out.println("Done");

		// Max weight of players
		/*
		 * PlayersService playersService2 = (PlayersService)
		 * ctx.getBean("playersService"); System.out.println();
		 * System.out.println
		 * ("=============================================================");
		 * System.out.println("Max weight of players is " +
		 * playersService2.getMaxWeight());
		 */

	}
}
