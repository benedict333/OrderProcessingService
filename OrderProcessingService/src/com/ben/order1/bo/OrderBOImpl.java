package com.ben.order1.bo;

import java.sql.SQLException;

import com.ben.order1.bo.exception.BOException;
import com.ben.order1.dao.OrderDAO;
import com.ben.order1.dto.Order;

public class OrderBOImpl implements OrderBO {

	private OrderDAO dao;
	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			if(result==0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("canceled");
			int result = dao.update(order);
			if(result==0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		
		
		try {
			int result = dao.delete(id);
			if(result==0) {
				return false;
			}
			
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
