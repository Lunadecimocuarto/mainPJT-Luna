package site.gamsung.service.auction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import site.gamsung.service.auction.AuctionProductService;

@Service("AuctionProductService")
public class AuctionProductServiceImpl implements AuctionProductService{

	@Autowired(required = false)
	@Qualifier("AuctionProductDAO")
	private AuctionProductService auctionProductService;
	
	public AuctionProductServiceImpl(){
		// TODO Auto-generated constructor stub
	}

}