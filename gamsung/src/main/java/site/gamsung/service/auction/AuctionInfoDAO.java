package site.gamsung.service.auction;

import java.util.List;
import java.util.Map;

import site.gamsung.service.domain.AuctionInfo;
import site.gamsung.service.domain.AuctionProduct;
import site.gamsung.service.domain.User;

public interface AuctionInfoDAO {
	
	public void addBidConcern(AuctionInfo auctionInfo);
	
	public int getBidConcern(AuctionInfo auctionInfo);
	
	public void deleteBidConcern(AuctionInfo auctionInfo);
	
	public List<AuctionInfo> listBidConcern(Map<String, Object> map);
	
	public List<AuctionProduct> listAuctionProductByRole(Map<String, Object> map);
	
	public List<AuctionInfo> auctionHistory(Map<String, Object> map);
	
	public AuctionInfo auctionStatusTotalCount(User user);
	
	public List<AuctionInfo> getYearAuctionStatistics();
	
	public List<AuctionInfo> getMonthAuctionStatistics(String year);
	
	public AuctionInfo getDayAuctionStatistics();
	
	public int getUserAuctionGradeInfo(String userId);	
	
	public void updateUserAuctionGrade(User user);
	
	public AuctionInfo getBidderRanking(AuctionInfo auctionInfo);
	
	public boolean isSecessionUserAuctionCondition(String userId);
}
