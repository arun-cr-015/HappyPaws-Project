package com.virtusa.project.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.virtusa.project.dto.PaymentDto;
import com.virtusa.project.model.Cart;

@Service
public class PaymentService {
	Logger logger = LogManager.getLogger(PaymentService.class);
	@Autowired
	private CartService cartService;

	public PaymentDto payment(long id) {
		Cart cart = cartService.getCartByUser(id);
		String orderId = null;

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_vJKtyvgehORRYu", "SM1WBsekQBPBDajCXtmi0qK4");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", cart.getTotal() * 100); 
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			Order orderlocal = razorpay.orders.create(orderRequest);
			orderId = orderlocal.get("id");
			PaymentDto pay = new PaymentDto();
			pay.setPaymentId(orderId);
			logger.info("Payment Done RazorPay Order Id: {}",orderId);
			return pay;

		} catch (RazorpayException e) {
			
			logger.info(e.getMessage());
			return null;
		}
	}
}
