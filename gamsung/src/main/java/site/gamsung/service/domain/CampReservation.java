package site.gamsung.service.domain;

import java.sql.Date;

public class CampReservation {

	private Camp camp;
	private User user;
	private MainSite mainSite;
	private int reservationNo;
	private int reservationStatus;
	private boolean deleteFlag;
	private Date reservationRegDate;
	private String reservationUserName;
	private Date reservationStartDate;
	private Date reservationEndDate;
	private int useNum;
	private String reservationUserPhone;
	private String reservationRegCarNum;
	private String reservationRequest;
	private int totalPaymentPrice;
	private int totalReservationRegCar;
				
	public CampReservation() {
		
	}

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public User getBusinessUser() {
		return user;
	}

	public void setBusinessUser(User user) {
		this.user = user;
	}

	public MainSite getMainUnit() {
		return mainSite;
	}

	public void setMainSite(MainSite mainSite) {
		this.mainSite = mainSite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getReservationRegDate() {
		return reservationRegDate;
	}

	public void setReservationRegDate(Date reservationRegDate) {
		this.reservationRegDate = reservationRegDate;
	}

	public String getReservationUserName() {
		return reservationUserName;
	}

	public void setReservationUserName(String reservationUserName) {
		this.reservationUserName = reservationUserName;
	}

	public Date getReservationStartDate() {
		return reservationStartDate;
	}

	public void setReservationStartDate(Date reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	public Date getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(Date reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	public int getUseNum() {
		return useNum;
	}

	public void setUseNum(int useNum) {
		this.useNum = useNum;
	}

	public String getReservationUserPhone() {
		return reservationUserPhone;
	}

	public void setReservationUserPhone(String reservationUserPhone) {
		this.reservationUserPhone = reservationUserPhone;
	}

	public String getReservationRegCarNum() {
		return reservationRegCarNum;
	}

	public void setReservationRegCarNum(String reservationRegCarNum) {
		this.reservationRegCarNum = reservationRegCarNum;
	}

	public String getReservationRequest() {
		return reservationRequest;
	}

	public void setReservationRequest(String reservationRequest) {
		this.reservationRequest = reservationRequest;
	}

	public int getTotalPaymentPrice() {
		return totalPaymentPrice;
	}

	public void setTotalPaymentPrice(int totalPaymentPrice) {
		this.totalPaymentPrice = totalPaymentPrice;
	}

	public int getTotalReservationRegCar() {
		return totalReservationRegCar;
	}

	public void setTotalReservationRegCar(int totalReservationRegCar) {
		this.totalReservationRegCar = totalReservationRegCar;
	}

	public String toString() {
		return "\n CampReservation -> "
			+ "[camp] : " + camp
			+ ",[businessUser] : " + user
			+ ",[mainUnit] : " + mainSite
			+ ",[user] : " + user				
			+ ",[reservationNo] : " + reservationNo
			+ ",[reservationStatus] : " + reservationStatus 
			+ ",[deleteFlag] : " + deleteFlag 
			+ ",[reservationRegDate] : " + reservationRegDate 
			+ ",[reservationUserName] : " + reservationUserName 
			+ ",[reservationStartDate] : " + reservationStartDate 
			+ ",[reservationEndDate] : " + reservationEndDate 
			+ ",[useNum] : " + useNum 
			+ ",[reservationUserPhone] : " + reservationUserPhone
			+ ",[reservationRegCarNum] :" + reservationRegCarNum
			+ ",[reservationRequest] : " + reservationRequest
			+ ",[totalPaymentPrice] : " + totalPaymentPrice
			+ ",[totalReservationRegCar] : " + totalReservationRegCar;
	}	
}