package com.cts.fse.car.rental.constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cts.fse.car.rental.dto.BookingRequestDTO;
import com.cts.fse.car.rental.dto.FunctionResponseDTO;

public class CarRentalUtils {
	
	@SuppressWarnings("deprecation")
	public static FunctionResponseDTO validateSearchInp(BookingRequestDTO bookingRequestDTO) {
		  boolean resp =true;
		  StringBuffer stringBuffer = new StringBuffer();
		try {
			Date fromDate = new SimpleDateFormat("MM/dd/yyyy").parse(bookingRequestDTO.getFromDate());
			Date toDate = new SimpleDateFormat("MM/dd/yyyy").parse(bookingRequestDTO.getToDate());
			String nowDate =  new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			Date nowDateFmt = new SimpleDateFormat("MM/dd/yyyy").parse(nowDate);
			if( toDate.before(fromDate)) {
				stringBuffer.append(" From date greater than To Date. ");
				resp = false;
			}
			if(fromDate.before(nowDateFmt)){
				stringBuffer.append(" From date older then today. ");
				resp = false;
			}
			//System.out.println(" resp message from util "+ stringBuffer.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new FunctionResponseDTO(stringBuffer.toString(),resp);
	}

}
