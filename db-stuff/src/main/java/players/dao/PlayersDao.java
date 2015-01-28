package players.dao;

import java.util.List;

import players.dto.Player;
import players.dto.Team;

public interface PlayersDao {

	public List<Player> getAllPlayers();

	public Player getAveragePlayer();

	public Player getById(int id);

	public int getMaxWeight();

	public int getMinWeight();

	public Team getTeamByName(String name);

	public Team getTeamById(int id);

	public void updatePlayer(Player player);

	public void updateTeam(Team team);
}
