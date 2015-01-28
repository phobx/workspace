package players.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import players.dao.PlayersDao;
import players.dto.Player;
import players.dto.Team;

public class PlayersDaoHibernateImpl extends HibernateDaoSupport implements PlayersDao {

	public static final String ENTITY_PLAYER = "Player";
	public static final String ENTITY_TEAM = "Team";

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAllPlayers() {
		DetachedCriteria dc = DetachedCriteria.forEntityName(ENTITY_PLAYER);
		List<Player> res = (List<Player>) getHibernateTemplate().findByCriteria(dc);
		return res;
	}

	@Override
	public Player getAveragePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getById(int id) {
		return (Player) getHibernateTemplate().get(ENTITY_PLAYER, id);
	}

	@Override
	public int getMaxWeight() {
		DetachedCriteria cr = DetachedCriteria.forEntityName(ENTITY_PLAYER);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("weight"));
		cr.setProjection(projList);
		List<?> res = getHibernateTemplate().findByCriteria(cr);
		return (Integer) res.get(0);
	}

	@Override
	public int getMinWeight() {
		DetachedCriteria cr = DetachedCriteria.forEntityName(ENTITY_PLAYER);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.min("weight"));
		cr.setProjection(projList);
		List<?> res = getHibernateTemplate().findByCriteria(cr);
		return (Integer) res.get(0);
	}

	@Override
	public Team getTeamByName(String name) {
		DetachedCriteria cr = DetachedCriteria.forEntityName(ENTITY_TEAM);
		cr.add(Restrictions.eq("name", name));
		List<?> res = getHibernateTemplate().findByCriteria(cr);
		Team t = (Team) res.get(0);
		return t;
	}

	@Override
	public Team getTeamById(int id) {
		return null;
	}

	@Override
	public void updatePlayer(Player player) {
		System.out.println("Before: " + player.getId());
		getHibernateTemplate().saveOrUpdate(ENTITY_PLAYER, player);
		System.out.println("After: " + player.getId());
	}

	@Override
	public void updateTeam(Team team) {
		System.out.println("Before: " + team.getId());
		getHibernateTemplate().saveOrUpdate(ENTITY_TEAM, team);
		System.out.println("After: " + team.getId());
	}

}
