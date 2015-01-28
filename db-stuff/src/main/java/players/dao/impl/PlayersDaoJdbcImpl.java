package players.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import players.dao.PlayersDao;
import players.dto.Player;
import players.dto.Team;

@Deprecated
public class PlayersDaoJdbcImpl extends JdbcDaoSupport implements PlayersDao {

	@Override
	public List<Player> getAllPlayers() {
		List<Player> res = new ArrayList<>();
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement("select id, first_name, last_name, height, weight from tnt_players");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Player p = new Player();
				p.setId(rs.getInt("id"));
				p.setFirstName(rs.getString("first_name"));
				p.setLastName(rs.getString("last_name"));
				p.setHeight(rs.getInt("height"));
				p.setWeight(rs.getInt("weight"));
				res.add(p);
			}
			return res;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Player getAveragePlayer() {
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement("select avg(height) as height, avg(weight) as weight from tnt_players");
			ResultSet rs = ps.executeQuery();
			rs.next();
			Player p = new Player();
			p.setHeight(rs.getInt("height"));
			p.setWeight(rs.getInt("weight"));
			return p;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Player getById(int id) {
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement("select id, first_name, last_name, height, weight from tnt_players where id=" + id);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Player p = new Player();
			p.setId(rs.getInt("id"));
			p.setFirstName(rs.getString("first_name"));
			p.setLastName(rs.getString("last_name"));
			p.setHeight(rs.getInt("height"));
			p.setWeight(rs.getInt("weight"));

			return p;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int getMaxWeight() {
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT MAX(weight) FROM tnt_players;");
			ResultSet set = statement.executeQuery();
			set.next();
			int maxWeight = set.getInt("MAX(weight)");
			return maxWeight;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int getMinWeight() {
		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement("select MIN(weight) as weight from tnt_players");
			ResultSet result = st.executeQuery();
			result.next();
			int minWeight = result.getInt("weight");
			return minWeight;

		} catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public Team getTeamByName(String name) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Team getTeamById(int id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void updatePlayer(Player player) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub

	}
}
