package com.ben.order1.bo;

import com.ben.order1.bo.exception.BOException;
import com.ben.order1.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id)throws BOException;
	boolean deleteOrder(int id)throws BOException;
	}

