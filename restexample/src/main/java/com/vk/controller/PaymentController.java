package com.vk.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.vk.model.BaseResponse;
import com.vk.model.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private final String sharedKey = "SHARED_KEY";
	
	private final String SUCCESS_MSG = "Success";
	private final int SUCCESS_STATUS = 100;
	private final String FAILURE_MSG = "Error";
	private final int AUTH_FAIL = 102;
	
	@RequestMapping(value="/pay", method=RequestMethod.POST)
	public BaseResponse pay(@RequestParam(value ="key") String key, @RequestBody PaymentRequest paymentRequest){
		
		BaseResponse response = new BaseResponse();
		  if (sharedKey.equalsIgnoreCase(key)) {
		   int userId = paymentRequest.getUserId();
		   String itemId = paymentRequest.getItemId();
		   double discount = paymentRequest.getDiscount();
		   // Process the request
		   // ....
		   // Return success response to the client.
		   response.setStatusMessage(SUCCESS_MSG);
		   response.setStatusCode(SUCCESS_STATUS);
		  } else {
		   response.setStatusMessage(FAILURE_MSG);
		   response.setStatusCode(AUTH_FAIL);
		  }
		  return response;
		
	}
	

}
