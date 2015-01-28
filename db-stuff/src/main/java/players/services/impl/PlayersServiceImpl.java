package players.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import players.dao.PlayersDao;
import players.dto.Player;
import players.dto.Team;
import players.services.PlayersService;

@Transactional
public class PlayersServiceImpl implements PlayersService {

	private PlayersDao playersDao;

	public void setPlayersDao(PlayersDao playersDao) {
		this.playersDao = playersDao;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playersDao.getAllPlayers();
	}

	@Override
	public Player getAveragePlayer() {
		return playersDao.getAveragePlayer();
	}

	@Override
	public Player getById(int id) {
		return playersDao.getById(id);
	}

	@Override
	public int getMaxWeight() {
		return playersDao.getMaxWeight();
	}

	@Override
	public int getMinWeight() {
		return playersDao.getMinWeight();
	}

	@Override
	public Team getTeamByName(String name) {
		return playersDao.getTeamByName(name);
	}

	@Override
	public Team getTeamById(int id) {
		return playersDao.getTeamById(id);
	}

	@Override
	public void updatePlayer(Player player) {
		playersDao.updatePlayer(player);
		// throw new RuntimeException("No way!");
	}

	@Override
	public void updateTeam(Team team) {
		playersDao.updateTeam(team);
	}
}
