package com.Restaurant.JWT;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Restaurant.DAO.UserDAO;

import java.util.ArrayList;


@Service
public class CustomerUsersDetailsService implements UserDetailsService
{private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CustomerUsersDetailsService.class);
@Autowired
	UserDAO userDao;


private com.Restaurant.POJO.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}", username);
		userDetail = userDao.findByEmailId(username);
		if(!Objects.isNull(userDetail)) {
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
			
		}else {
		throw new UsernameNotFoundException("User not found.");
		}
	}
public com.Restaurant.POJO.User getUserDetail(){
	return userDetail;
}
	
}
