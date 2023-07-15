package com.Restaurant.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Restaurant.serviceImpl.BillServiceImpl;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

@Slf4j
public class RestaurantUtils {
	private static final Logger log = LoggerFactory.getLogger(RestaurantUtils.class);

	private RestaurantUtils() {

	}

	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
		return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
	}

	public static String getUUID() {
		Date date = new Date();
		long time = date.getTime();
		return "BILL-" + time;
	}

	public static JSONArray getJsonArrayFromString(String data) throws JSONException {

		JSONArray jsonArray = new JSONArray(data);
		return jsonArray;
	}

	public static Map<String, Object> getMapFromJson(String data) {
		if (!Strings.isNullOrEmpty(data))
			return new Gson().fromJson(data, new TypeToken<Map<String, Object>>() {

			}.getType());
		return new HashMap<>();
	}

	public static Boolean isFileExist(String path) {
		log.info("Inside isFileExist {}", path);
		try {
			File file = new File(path);
			return (file != null && file.exists()) ? Boolean.TRUE : Boolean.FALSE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
