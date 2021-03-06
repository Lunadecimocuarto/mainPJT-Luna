package site.gamsung.service.camp.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import site.gamsung.service.camp.CampReservationDAO;
import site.gamsung.service.common.Search;
import site.gamsung.service.domain.CampReservation;
import site.gamsung.service.domain.MainSite;
import site.gamsung.service.domain.ReservationStatistics;

@Repository("campReservationDAOImpl")
public class CampReservationDAOImpl implements CampReservationDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public CampReservationDAOImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public List<MainSite> listPossibleReservation(Map<String, Object> map){
		return sqlSession.selectList("CampReservationMapper.listPossibleReservation", map);
	}

	@Override
	public int addReservation(CampReservation campReservation){
		return sqlSession.insert("CampReservationMapper.addReservation", campReservation);
	}
	
	@Override
	public int updateMainSiteReservation(CampReservation campReservation){
		return sqlSession.update("CampReservationMapper.updateMainSiteReservation", campReservation);
	}

	@Override
	public int updateCampReservationCount(int campNo){
		return sqlSession.update("CampReservationMapper.updateCampReservationCount", campNo);
	}

	@Override
	public boolean isSecessionUserReservationCondition(String id){
		
		List<CampReservation> list= sqlSession.selectList("CampReservationMapper.getReservationStatus", id);
		
		//리턴 값이 있으면 회원 탈퇴 불가 : flag false. 리턴 값이 없으면 회원 탈퇴 가능 : flag true.
		if(list.size() != 0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<CampReservation> listReservation(Map<String, Object> map){
		return sqlSession.selectList("CampReservationMapper.listReservation", map);
	}

	@Override
	public int getTotalCount(Map<String, Object> map){
		return sqlSession.selectOne("CampReservationMapper.getTotalCount", map);
	}

	@Override
	public ReservationStatistics getReservationStatistics() {
		return sqlSession.selectOne("CampReservationMapper.totalReservationStatistics");
	}

	@Override
	public List<ReservationStatistics> campReservationStatisticsByDay(Search search){
		return sqlSession.selectList("CampReservationMapper.campReservationStatisticsByDay", search);
	}

	@Override
	public List<ReservationStatistics> campReservationStatisticsByWeek(Search search) {
		return sqlSession.selectList("CampReservationMapper.campReservationStatisticsByWeek", search);
	}

	@Override
	public List<ReservationStatistics> campReservationStatisticsByMonth(Search search) {
		return sqlSession.selectList("CampReservationMapper.campReservationStatisticsByMonth", search);
	}

	@Override
	public int getTotalCampReservationCountByDay(Search search) {
		return sqlSession.selectOne("CampReservationMapper.getTotalCampReservationCountByDay", search);
	}

	@Override
	public int getTotalCampReservationCountByWeek(Search search) {
		return sqlSession.selectOne("CampReservationMapper.getTotalCampReservationCountByWeek", search);
	}

	@Override
	public int getTotalCampReservationCountByMonth(Search search) {
		return sqlSession.selectOne("CampReservationMapper.getTotalCampReservationCountByMonth", search);
	}

	@Override
	public CampReservation getReservation(String reservationNo) {
		return sqlSession.selectOne("CampReservationMapper.getReservation", reservationNo);
	}

	@Override
	public int updateReservation(CampReservation campReservation) {
		return sqlSession.update("CampReservationMapper.updateReservation", campReservation);
	}

	@Override
	public List<CampReservation> sendMessageInfo() {
		return sqlSession.selectList("CampReservationMapper.sendMessageInfo");
	}

	@Override
	public void resetCount() {
		sqlSession.update("CampReservationMapper.resetCount");		
	}
	
}

