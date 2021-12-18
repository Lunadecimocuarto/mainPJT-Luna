package site.gamsung.service.domain;

import java.sql.Timestamp;
import java.util.List;

public class AuctionProduct {
	private String auctionProductNo;
	private String auctionProductName;
	private String auctionProductDatail;
	private User user;
	private int startBidPrice;
	private int hopefulBidPrice;
	private int bidUnit;
	private String auctionStartTime;
	private String auctionEndTime;
	private int bidableGrade;
	private String allhashtag;
	private String hashtag1;
	private String hashtag2;
	private String hashtag3;
	private String productImg1;
	private String productImg2;
	private String productImg3;
	private String productImg4;
	private String productImg5;
	private int productViewCount;
	private Timestamp productRegDate;
	private String auctionStatus;
	private boolean isConfirm;
	private boolean isTempSave;
	private boolean isDelete;
	
	
	public String getAuctionProductName() {
		return auctionProductName;
	}
	public void setAuctionProductName(String auctionProductName) {
		this.auctionProductName = auctionProductName;
	}
	public String getAuctionProductDatail() {
		return auctionProductDatail;
	}
	public void setAuctionProductDatail(String auctionProductDatail) {
		this.auctionProductDatail = auctionProductDatail;
	}
	
	public String getAuctionProductNo() {
		return auctionProductNo;
	}
	public void setAuctionProductNo(String auctionProductNo) {
		this.auctionProductNo = auctionProductNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStartBidPrice() {
		return startBidPrice;
	}
	public void setStartBidPrice(int startBidPrice) {
		this.startBidPrice = startBidPrice;
	}
	public int getHopefulBidPrice() {
		return hopefulBidPrice;
	}
	public void setHopefulBidPrice(int hopefulBidPrice) {
		this.hopefulBidPrice = hopefulBidPrice;
	}
	public int getBidUnit() {
		return bidUnit;
	}
	public void setBidUnit(int bidUnit) {
		this.bidUnit = bidUnit;
	}
	public String getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(String auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public String getAuctionEndTime() {
		return auctionEndTime;
	}
	public void setAuctionEndTime(String auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	public int getBidableGrade() {
		return bidableGrade;
	}
	public void setBidableGrade(int bidableGrade) {
		this.bidableGrade = bidableGrade;
	}
	
	public String getAllhashtag() {
		return allhashtag;
	}
	public void setAllhashtag(String allhashtag) {
		this.allhashtag = allhashtag;
	}
	
	public String getHashtag1() {
		return hashtag1;
	}
	public void setHashtag1(String hashtag1) {
		this.hashtag1 = hashtag1;
	}
	public String getHashtag2() {
		return hashtag2;
	}
	public void setHashtag2(String hashtag2) {
		this.hashtag2 = hashtag2;
	}
	public String getHashtag3() {
		return hashtag3;
	}
	public void setHashtag3(String hashtag3) {
		this.hashtag3 = hashtag3;
	}
	public String getProductImg1() {
		return productImg1;
	}
	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}
	public String getProductImg2() {
		return productImg2;
	}
	public void setProductImg2(String productImg2) {
		this.productImg2 = productImg2;
	}
	public String getProductImg3() {
		return productImg3;
	}
	public void setProductImg3(String productImg3) {
		this.productImg3 = productImg3;
	}
	public String getProductImg4() {
		return productImg4;
	}
	public void setProductImg4(String productImg4) {
		this.productImg4 = productImg4;
	}
	public String getProductImg5() {
		return productImg5;
	}
	public void setProductImg5(String productImg5) {
		this.productImg5 = productImg5;
	}
	public int getProductViewCount() {
		return productViewCount;
	}
	public void setProductViewCount(int productViewCount) {
		this.productViewCount = productViewCount;
	}
	public Timestamp getProductRegDate() {
		return productRegDate;
	}
	public void setProductRegDate(Timestamp productRegDate) {
		this.productRegDate = productRegDate;
	}
	public boolean isConfirm() {
		return isConfirm;
	}
	public void setConfirm(boolean isConfirm) {
		this.isConfirm = isConfirm;
	}
	public String getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	public boolean isTempSave() {
		return isTempSave;
	}
	public void setTempSave(boolean isTempSave) {
		this.isTempSave = isTempSave;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "AuctionProduct [auctionProductNo=" + auctionProductNo + ", auctionProductName=" + auctionProductName
				+ ", auctionProductDatail=" + auctionProductDatail + ", user=" + user + ", startBidPrice="
				+ startBidPrice + ", hopefulBidPrice=" + hopefulBidPrice + ", bidUnit=" + bidUnit
				+ ", auctionStartTime=" + auctionStartTime + ", auctionEndTime=" + auctionEndTime + ", bidableGrade="
				+ bidableGrade + ", allhashtag=" + allhashtag + ", hashtag1=" + hashtag1 + ", hashtag2=" + hashtag2
				+ ", hashtag3=" + hashtag3 + ", productImg1=" + productImg1 + ", productImg2=" + productImg2
				+ ", productImg3=" + productImg3 + ", productImg4=" + productImg4 + ", productImg5=" + productImg5
				+ ", productViewCount=" + productViewCount + ", productRegDate=" + productRegDate + ", auctionStatus="
				+ auctionStatus + ", isConfirm=" + isConfirm + ", isTempSave=" + isTempSave + ", isDelete=" + isDelete
				+ "]";
	}
	
}