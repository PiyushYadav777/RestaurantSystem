package com.Restaurant.serviceImpl;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Restaurant.DAO.BillDao;
import com.Restaurant.DAO.CategoryDao;
import com.Restaurant.DAO.ProductDao;
import com.Restaurant.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	BillDao billDao;
	
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		Map<String,Object> map = new HashMap<>();
		map.put("category", categoryDao.count());
		map.put("product", productDao.count());
		map.put("bill", billDao.count());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}



