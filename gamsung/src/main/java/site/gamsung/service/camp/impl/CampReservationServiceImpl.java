package site.gamsung.service.camp.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import site.gamsung.service.camp.CampReservationService;
import site.gamsung.service.common.Search;
import site.gamsung.service.camp.CampReservationDAO;
import site.gamsung.service.domain.Camp;
import site.gamsung.service.domain.CampReservation;
import site.gamsung.service.domain.MainSite;
import site.gamsung.service.domain.Payment;
import site.gamsung.service.domain.ReservationStatistics;
import site.gamsung.service.payment.PaymentDAO;
import site.gamsung.util.user.SendMessage;

@Service("campReservationServiceImpl")
public class CampReservationServiceImpl implements CampReservationService {

	@Autowired
	@Qualifier("campReservationDAOImpl")
	private CampReservationDAO campReservationDAO;
	
	@Autowired
	@Qualifier("paymentDAOImpl")
	private PaymentDAO paymentDAO;
		
	public void setCampReservationDAO(CampReservationDAO campReservationDAO) {
		this.campReservationDAO = campReservationDAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public CampReservationServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public List<MainSite> listPossibleReservation(Map<String, Object> map){
		return campReservationDAO.listPossibleReservation(map);
	}

	@Override
	public void addReservation(CampReservation campReservation){
		
		//insert payment(결제 정보) - insert payment(결제 정보) - 포인트, 현금, 카드 여러 형태 처리.
		campReservationDAO.addReservation(campReservation);
		campReservationDAO.updateMainSiteReservation(campReservation);
		
		Camp camp = new Camp();
		camp.setCampNo(10000);
		
		campReservationDAO.updateCampReservationCount(camp.getCampNo());
		
	}

	@Override
	public Map<String, Object> listReservation(Search search, int campNo){
		
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("search", search);
		requestMap.put("campNo", campNo);
		
		List<CampReservation> list = campReservationDAO.listReservation(requestMap);
		int totalCount = campReservationDAO.getTotalCount(requestMap);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("list", list);
		responseMap.put("totalCount", totalCount);
		
		return responseMap;
	}

	@Override
	public Map<String, Object> listMyReservation(Search search, String id){
		
		Map<String, Object> requestMap = new HashMap<String, Object>();
		requestMap.put("search", search);
		requestMap.put("id", id);
		
		List<CampReservation> list = campReservationDAO.listReservation(requestMap);
		int totalCount = campReservationDAO.getTotalCount(requestMap);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("list", list);
		responseMap.put("totalCount", totalCount);
		
		return responseMap;
	}

	@Override
	public ReservationStatistics getReservationStatistics(){
		return campReservationDAO.getReservationStatistics();
	}

	@Override
	public Map<String, Object> listCampReservationStatisticsByDay(Search search){
		
		List<ReservationStatistics> listCampReservationByDay = campReservationDAO.campReservationStatisticsByDay(search);
		int totalCampReservationCountByDay = campReservationDAO.getTotalCampReservationCountByDay(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listCampReservationByDay", listCampReservationByDay);
		map.put("totalCampReservationCountByDay", totalCampReservationCountByDay);
		
		return map;
	}
	
	@Override
	public Map<String, Object> listCampReservationStatisticsByWeek(Search search){
		
		List<ReservationStatistics> listCampReservationByWeek = campReservationDAO.campReservationStatisticsByWeek(search);
		int totalCampReservationCountByWeek = campReservationDAO.getTotalCampReservationCountByWeek(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listCampReservationByWeek", listCampReservationByWeek);
		map.put("totalCampReservationCountByWeek", totalCampReservationCountByWeek);
		
		return map;
	}
	
	@Override
	public Map<String, Object> listCampReservationStatisticsByMonth(Search search){
		
		List<ReservationStatistics> listCampReservationByMonth = campReservationDAO.campReservationStatisticsByMonth(search);
		int totalCampReservationCountByMonth = campReservationDAO.getTotalCampReservationCountByMonth(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listCampReservationByMonth", listCampReservationByMonth);
		map.put("totalCampReservationCountByMonth", totalCampReservationCountByMonth);
		
		return map;
	}

	@Override
	public CampReservation getReservation(String reservationNo){
		return campReservationDAO.getReservation(reservationNo);
	}

	@Override
	public void updateReservation(CampReservation campReservation){
		
		//추가 결제 발생 시 insert payment(결제 정보) - 포인트, 현금, 카드 여러 형태 처리.
		
		CampReservation currentCampReservation = campReservationDAO.getReservation(campReservation.getReservationNo());
				
		if(currentCampReservation.getReservationStartDate() != campReservation.getReservationStartDate()
				|| currentCampReservation.getReservationEndDate() != campReservation.getReservationEndDate()
					|| currentCampReservation.getReservationUserName() != campReservation.getReservationUserName()) {
			
			if(currentCampReservation.getMainSite().getMainSiteNo() != campReservation.getMainSite().getMainSiteNo()) {
				currentCampReservation.setReservationUserName(null);
				currentCampReservation.setReservationStartDate(null);
				currentCampReservation.setReservationEndDate(null);
				campReservationDAO.updateMainSiteReservation(currentCampReservation);
				campReservationDAO.updateMainSiteReservation(campReservation);
			}else {
				campReservationDAO.updateMainSiteReservation(campReservation);
			}
		}
		campReservationDAO.updateReservation(campReservation);
		
	}

	@Override
	public void cancleReservationApply(CampReservation campReservation){
		
		campReservationDAO.updateReservation(campReservation);
		//get payment(예약번호) - 리스트로 받고 리스트 크기로 반복문 돌려서 결제취소 정보 입력.
		//insert payment(결제취소정보) - 예약 등록 번호별 결제 유형에 맞게 처리.
	
	}

	@Override
	public void cancleReservationDo(Payment payment){
	
		//예약취소 UI에서 결제 취소 진행 후 최종 확인 시 실행.
		
		CampReservation campReservation = campReservationDAO.getReservation(payment.getPaymentReferenceNum());
		campReservation.setReservationStatus(6);
		
		campReservationDAO.updateReservation(campReservation);
		
		campReservation.setReservationUserName(null);
		campReservation.setReservationStartDate(null);
		campReservation.setReservationEndDate(null);
		
		campReservationDAO.updateMainSiteReservation(campReservation);
		
	}

	@Override
	@Scheduled(cron="0 0 18 * * *")
	public void sendMessage() {
		
		List<CampReservation> list = campReservationDAO.sendMessageInfo();
		SendMessage sendmessage = new SendMessage();
		
		for (int i = 0; i < list.size(); i++) {
			
			String text = "안녕하세요.\n"+
						  "감성캠핑 사이트 입니다.\n"+
						  list.get(i).getReservationUserName()+"님은\n"+
						  list.get(i).getUser().getCampName()+"캠핑장에\n"+
						  list.get(i).getReservationStartDate()+" 부터 "+
						  list.get(i).getReservationEndDate()+" 까지 예약되어 있습니다.\n"+
						  "이용에 참고 하시기 바랍니다.";
			
			sendmessage.sendMessage(list.get(i).getReservationUserPhone(), text);
		}		
	}

	@Override
	@Scheduled(cron="0 0 16 * * *")
	public void reservationCompleteUse() {
		
		CampReservation campReservation = new CampReservation();
		campReservation.setReservationStatus(7);
		campReservationDAO.updateReservation(campReservation);
		
	}

	@Override
	@Scheduled(cron = "30 0 0 1 * *")
	public void resetCount() {
		
		campReservationDAO.resetCount();
		
	}
	
}
