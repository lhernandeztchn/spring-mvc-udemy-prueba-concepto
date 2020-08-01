package com.udemy.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {

	public static LocalDate ToLocalDate(String fecha, String formato) throws Exception {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return LocalDate.parse(fecha, formatter);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public static LocalTime ToLocalTime(String hora, String formato)throws Exception {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
			return LocalTime.parse(hora, dtf);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static LocalDateTime ToLocalDateTime(String fecha, String formato) throws Exception {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return LocalDateTime.parse(fecha, formatter);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	public static String DateFormat(String fecha) {
		fecha=fecha.replaceAll("\\-", " ").trim();
		return fecha.replaceAll("\\s+","");
	}
}