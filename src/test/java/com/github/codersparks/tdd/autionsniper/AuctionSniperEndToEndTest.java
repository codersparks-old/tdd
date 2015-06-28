package com.github.codersparks.tdd.autionsniper;

import org.junit.After;
import org.junit.Test;

public class AuctionSniperEndToEndTest {

	private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
	private final ApplicationRunner application = new ApplicationRunner();
	
	@Test
	public void test() {
		auction.startSellingItem();
		application.startBiddingIn(auction);
		auction.hasReceivedJoinRequestFromSniper();
		auction.announceClosed();
		application.showsSniperHasLostAuction();
	}
	
	// Additional cleanup
	@After
	public void stopAuction() {
		auction.stop();
	}
	
	@After
	public void stopApplication() {
		application.stop();
	}

}
