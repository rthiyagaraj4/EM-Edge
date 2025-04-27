/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
09/06/2020	IN072715     Haribabu	     								 MMS-DM-CRF-0165
06/05/2021	TFS-15598       Prabha         06/05/2021	Manickavasagam     MOHE-CRF-0074
--------------------------------------------------------------------------------------------------------------------
*/ 

package ePH.Common ;
import eCommon.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;
import java.sql.ResultSetMetaData;
import java.sql.Clob;
public abstract class PhAdapter extends CommonAdapter implements Serializable {
	boolean localEJB = true;
	
	String out_log = "";
	String err_log = "";

	public PhAdapter() {
		super( CommonRepository.getCommonKeyValue( "ID_PH" )  ) ;
	}

	public void setLocalEJB(boolean localEJB){
		this.localEJB = localEJB;
	}

	public boolean getLocalEJB(){
		return localEJB;
	}

	public String getTooltipStringFrFreq(ArrayList freqCharctValues,String tt_r_ps){
	//public String getTooltipStringFrFreq(HashMap freqCharctValues){
		HashMap freq_char_list	 = new HashMap();
		ArrayList day_list	= new ArrayList();
		ArrayList day_names	= new ArrayList();
		ArrayList time_list	= new ArrayList();
		ArrayList dose_list	= new ArrayList();

		String tootTipTable	= "";
		String class_value  = "  class=TIP";
		String tempDose = "";
		if(freqCharctValues != null && freqCharctValues.size() > 0){
			freq_char_list	= (HashMap)freqCharctValues.get(0);
			day_list		= (ArrayList)freqCharctValues.get(1);
			day_names		= (ArrayList)freqCharctValues.get(2);
			time_list		= (ArrayList)freqCharctValues.get(3);
			dose_list		= (ArrayList)freqCharctValues.get(4);

		/*	freq_char_list	= (HashMap)freqCharctValues.get("freq_char_list");
			day_list		= (ArrayList)freqCharctValues.get("day_list");
			day_names		= (ArrayList)freqCharctValues.get("day_names");
			time_list		= (ArrayList)freqCharctValues.get("time_list");
			dose_list		= (ArrayList)freqCharctValues.get("dose_list");*/
		}
		if(tt_r_ps.equals("toolTip")){
				tootTipTable = tootTipTable+"<tr>";
				if(!freq_char_list.get("durationType").equals("D")&&!freq_char_list.get("durationType").equals("H")){
					tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Day No."+"&nbsp;</td>";
						if(!freq_char_list.get("durationType").equals("L")){
							tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Day Name"+"&nbsp;</td>";
						}
				}
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Time"+"&nbsp;</td>";
//				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"<fmt:message key='Common.time.label' bundle='${common_labels}'/>"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Dosage"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"</tr>";

				for(int i=0;i<day_list.size();i++){
					tootTipTable	= tootTipTable+"<tr>";
					if(!freq_char_list.get("durationType").equals("D")&&!freq_char_list.get("durationType").equals("H")){
						tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+day_list.get(i)+"&nbsp;</td>";
							if(!freq_char_list.get("durationType").equals("L")){
								tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+day_names.get(i)+"&nbsp;</td>";
							}
					}
					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+time_list.get(i)+"&nbsp;</td>";
					tempDose = (String)dose_list.get(i);
					//if(Float.parseFloat(tempDose) < 1)
						//tempDose = Float.parseFloat(tempDose)+"";
					if(!(tempDose.equals("")))
						  {						 
						    if(tempDose.indexOf(".")== 0)
							  tempDose = "0"+tempDose;

						  }

					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+tempDose+"&nbsp;</td>";
					tootTipTable	= tootTipTable+"</tr>";
				}
		}else if(tt_r_ps.startsWith("prvwString") || tt_r_ps.startsWith("SSprvwString")){
				for(int i=0;i<day_list.size();i++){
					if(!freq_char_list.get("durationType").equals("D")&&!freq_char_list.get("durationType").equals("H")){
						tootTipTable = tootTipTable + "Day "+day_list.get(i);
						tootTipTable = tootTipTable + " - ";
							if(!freq_char_list.get("durationType").equals("L")){
								tootTipTable = tootTipTable + day_names.get(i);
								tootTipTable = tootTipTable + " - ";
							}
					}
					tempDose = (String)dose_list.get(i);
					/*if(Float.parseFloat(tempDose) < 1)
						tempDose = Float.parseFloat(tempDose)+"";*/
						if(!(tempDose.equals("")))
						  {						 
						    if(tempDose.indexOf(".")== 0)
							  tempDose = "0"+tempDose;

						  }


					tootTipTable = tootTipTable + time_list.get(i);
					tootTipTable = tootTipTable + " - ";
					if (tt_r_ps.startsWith("prvwString")) {
						tootTipTable = tootTipTable + tempDose;
						tootTipTable = tootTipTable + " "+tt_r_ps.substring(10,tt_r_ps.length());
					} else
						tootTipTable = tootTipTable + " Sliding Scale";
					tootTipTable = tootTipTable + "; ";
				}
		}else if(tt_r_ps.equals("Sliding")){
				tootTipTable = tootTipTable+"<tr>";
				if(!freq_char_list.get("durationType").equals("D")&&!freq_char_list.get("durationType").equals("H")){
					tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Day No."+"&nbsp;</td>";
						if(!freq_char_list.get("durationType").equals("L")){
							tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Day Name"+"&nbsp;</td>";
						}
				}
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Time"+"&nbsp;</td>";
//				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"<fmt:message key='Common.time.label' bundle='${common_labels}'/>"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"<td "+class_value+">&nbsp;"+"Dosage"+"&nbsp;</td>";
				tootTipTable = tootTipTable+"</tr>";

				for(int i=0;i<day_list.size();i++){
					tootTipTable	= tootTipTable+"<tr>";
					if(!freq_char_list.get("durationType").equals("D")&&!freq_char_list.get("durationType").equals("H")){
						tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+day_list.get(i)+"&nbsp;</td>";
							if(!freq_char_list.get("durationType").equals("L")){
								tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+day_names.get(i)+"&nbsp;</td>";
							}
					}
					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;"+time_list.get(i)+"&nbsp;</td>";
					//tempDose = (String)dose_list.get(i);
					//if(Float.parseFloat(tempDose) < 1)
					//	tempDose = Float.parseFloat(tempDose)+"";
					tootTipTable	= tootTipTable+"<td "+class_value+">&nbsp;Sliding Scale&nbsp;</td>";
					tootTipTable	= tootTipTable+"</tr>";
				}
		}
		return tootTipTable;
	}
	
	public void outLog(String outlog) {

		if (out_log.equals("") ) {
			Connection connection = null ;
			Statement statement = null;
			ResultSet resultSet = null;

			try {
				connection = getConnection() ;
				statement  = connection.createStatement();
				resultSet  = statement.executeQuery("select out_log,err_log from ph_param");

				if(resultSet!=null && resultSet.next())
				{
					out_log = resultSet.getString("out_log");
					err_log = resultSet.getString("err_log");
				}
			}catch ( Exception e ) {
				e.printStackTrace() ;
				out_log = "N";
				err_log = "N";
			}
			finally {
				try{
					closeResultSet( resultSet );
					closeStatement( statement ) ;
					closeConnection( connection ); 
				}catch(Exception es ){
					es.printStackTrace() ;
				}
			}
		} 
		if(out_log.equals("Y")) System.out.println(outlog);
	}

	public void errLog(String errlog) {

		if ( err_log.equals("")) {
			Connection connection = null ;
			Statement statement = null;
			ResultSet resultSet = null;

			try {
				connection = getConnection() ;
				statement  = connection.createStatement();
				resultSet  = statement.executeQuery("select out_log,err_log from ph_param");

				if(resultSet!=null && resultSet.next())
				{
					out_log = resultSet.getString("out_log");
					err_log = resultSet.getString("err_log");
				}
			}catch ( Exception e ) {
				e.printStackTrace() ;
				out_log = "N";
				err_log = "N";
			}
			finally {
				try{
					closeResultSet( resultSet );
					closeStatement( statement ) ;
					closeConnection( connection ); 
				}catch(Exception es ){
					es.printStackTrace() ;
				}
			}
		} 

		if(err_log.equals("Y")) System.err.println(errlog);
	}

	public String getUomDisplay(String facility_id, String uom_code) {

		String uomDisplay = uom_code;
		Connection connection = null ;
		//CallableStatement callableStatement =  null;		
		Statement statement = null;
		PreparedStatement pstmt = null; // COMMON-ICN-0184
		ResultSet resultSet = null;
		try {
			connection		= getConnection() ;
			//statement = connection.createStatement();
			pstmt = connection.prepareStatement("select PH_GET_UOM_DISPLAY(?,?,?) UOM_DISPLAY from dual"); //  COMMON-ICN-0183
			//resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+facility_id+"','"+uom_code+"','"+language_id+"') UOM_DISPLAY from dual");
			pstmt.setString(1, facility_id); // COMMON-ICN-0184
			pstmt.setString(2, uom_code); // COMMON-ICN-0184
			pstmt.setString(3, language_id); // COMMON-ICN-0184
			resultSet=pstmt.executeQuery();
	
			if(resultSet!=null && resultSet.next())
			{
				uomDisplay = resultSet.getString("UOM_DISPLAY");
			}

			
		}catch ( Exception e ) {
			e.printStackTrace() ;
			uomDisplay = uom_code;
		}
		finally {
			try{
				closeResultSet( resultSet );
				//closeStatement( callableStatement ) ;
				closeStatement( statement ) ;
				closeConnection( connection ); 
			}catch(Exception es ){
				es.printStackTrace() ;
			}
		}
		return uomDisplay==null?"":uomDisplay;
	}
/*
	public HashMap getScheduleDates(HashMap hash ,ArrayList arrList)
	{
		String durationType = (String)hash.get("durationType");
		String start_day_param = (String)hash.get("start_day_param");
		String pr_duration_type = (String)hash.get("duration_type");
		int duration = Integer.parseInt((hash.get("duration")==null?"0":(String)hash.get("duration")));
		int repeat = Integer.parseInt((hash.get("repeat")==null?"0":(String)hash.get("repeat")));
		int totalDuration = 0;
		String currentDate = "";
		String dayName = "";

		ArrayList dateList = null;
		ArrayList dayList = null;
		HashMap schdMap = new HashMap();
		HashMap repeatMap = null;
		if ((durationType.toUpperCase()).equals("L"))
		{ 
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 12;
			else
				totalDuration = duration;		
		}else if ((durationType.toUpperCase()).equals("W"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 52;
			else if((pr_duration_type.toUpperCase()).equals("L"))
				totalDuration = duration * 4;
			else 
				totalDuration = duration;
		}else if ((durationType.toUpperCase()).equals("D"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 365;
			else if((pr_duration_type.toUpperCase()).equals("L"))
				totalDuration = duration * 30;	
			else if((pr_duration_type.toUpperCase()).equals("W"))
				totalDuration = duration * 7;	
			else 
				totalDuration = duration;	
		}

		for (int j = 0;j < repeat ; j++)
		{		
			dateList = new ArrayList();
			dayList = new ArrayList();
			repeatMap = new HashMap();
			String str = (String)arrList.get(j);
			int val = Integer.parseInt(str);

			if ((durationType.toUpperCase()).equals("D"))
				currentDate = DateUtils.plusDate(start_day_param, "DMY", "en", val, "d");
			else
				currentDate = DateUtils.plusDate(start_day_param, "DMY", "en", val - 1, "d");

			dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
			dateList.add(currentDate);
			dayList.add(dayName);
			for (int i = 0;i<totalDuration - 1 ;i++ )
			{
				if ((durationType.toUpperCase()).equals("L"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 30, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
					
				}else if ((durationType.toUpperCase()).equals("W"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 7, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");				
				}else if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 1, "d");		
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");				
				}

				dateList.add(currentDate);
				dayList.add(dayName);
			}
			repeatMap.put("DATES",dateList);
			repeatMap.put("DAYS",dayList);
			schdMap.put(j+1,repeatMap);
		}
		return schdMap;
	}
	*/
	/*public HashMap getScheduleDates(HashMap hash ,ArrayList arrList)
	{
		String durationType = hash.get("durationType")==null?"":(String)hash.get("durationType");
		String start_day_param = hash.get("start_day_param")==null?"":(String)hash.get("start_day_param");
		String pr_duration_type = hash.get("duration_type")==null?"":(String)hash.get("duration_type");
		int duration = Integer.parseInt((hash.get("duration")==null?"0":(String)hash.get("duration")));
		int repeat = Integer.parseInt((hash.get("repeat")==null?"0":(String)hash.get("repeat")));
		int Interval_value = Integer.parseInt((hash.get("Interval_value")==null?"1":(String)hash.get("Interval_value")));
		int totalDuration = 0;
		String currentDate = "";
		String endDate = "";
		String dayName = "";

		ArrayList dateList = null;
		ArrayList dayList = null;
		HashMap schdMap = new HashMap();
		HashMap repeatMap = null;
		if ((durationType.toUpperCase()).equals("L"))
		{ 
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", 30*duration*12, "d");
				totalDuration = (duration - Interval_value) * 12;
			}else{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", 30*duration, "d");
				totalDuration = (duration - Interval_value);		
			}
		}else if ((durationType.toUpperCase()).equals("W"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", 7*duration*52, "d");
				totalDuration = (duration - Interval_value) * 52;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", 7*duration*4, "d");
				totalDuration = (duration - Interval_value) * 4;
			}else 
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", 7*duration, "d");
				totalDuration = (duration - Interval_value);
			}
		}else if ((durationType.toUpperCase()).equals("D"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", duration*365, "d");
				totalDuration = (duration - Interval_value) * 365;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", duration*30, "d");
				totalDuration = (duration - Interval_value) * 30;	
			}else if((pr_duration_type.toUpperCase()).equals("W"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", duration*7, "d");
				totalDuration = (duration - Interval_value) * 7;	
			}else 
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", "en", duration, "d");
				totalDuration = (duration - Interval_value);	
			}
		}

		for (int j = 0;j < repeat ; j++)
		{		
			int val = 0;
			dateList = new ArrayList();
			dayList = new ArrayList();
			repeatMap = new HashMap();
			String str = arrList.get(j)==null?"":(String)arrList.get(j);
			if (!str.equals(""))
			{
				val = Integer.parseInt(str);
			}
			if ((durationType.toUpperCase()).equals("D"))
				currentDate = DateUtils.plusDate(start_day_param, "DMY", "en", val-1, "d");
			else
				currentDate = DateUtils.plusDate(start_day_param, "DMY", "en", val-1, "d");

			dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
			dateList.add(currentDate);
			dayList.add(dayName);			
			for (int i = 0;i<totalDuration;i++ )
			{
				if ((durationType.toUpperCase()).equals("L"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 30*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
					
				}else if ((durationType.toUpperCase()).equals("W"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 7*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");				
				}else if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 1*Interval_value, "d");		
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");				
				}
				if (DateUtils.isBefore(currentDate, endDate, "DMY", "en"))
				{
					dateList.add(currentDate);
					dayList.add(dayName);
				}				
			}
			repeatMap.put("DATES",dateList);
			repeatMap.put("DAYS",dayList);
			schdMap.put(j+1,repeatMap);
		}
		return schdMap;
	}*/
	public HashMap getScheduleDates(HashMap hash ,ArrayList arrList)
	{		
		String durationType			= hash.get("durationType")==null?"":(String)hash.get("durationType");
		String start_day_param		= hash.get("start_day_param")==null?"":(String)hash.get("start_day_param");
		String pr_duration_type		= hash.get("duration_type")==null?"":(String)hash.get("duration_type");
		int duration				= Integer.parseInt((hash.get("duration")==null?"0":(String)hash.get("duration")));
		int repeat					= Integer.parseInt((hash.get("repeat")==null?"0":(String)hash.get("repeat")));
		int Interval_value			= Integer.parseInt((hash.get("Interval_value")==null?"1":(String)hash.get("Interval_value")));
		int totalDuration			= 0;		
		String currentDate			= "";
		String endDate				= "";
		String dayName				= "";
		ArrayList dateList			= null;
		ArrayList dayList			= null;
		HashMap schdMap				= new HashMap();
		HashMap repeatMap			= null;
		String locale				= properties.getProperty("LOCALE");
		

		

		if ((durationType.toUpperCase()).equals("L"))
		{ 
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, 365*duration, "d");
				totalDuration =(duration * 12)/Interval_value;
			}else{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, 30*duration, "d");
				totalDuration =(duration)/Interval_value;		
			}
		}else if ((durationType.toUpperCase()).equals("W"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, 365*duration, "d");
				totalDuration =(duration * 52)/Interval_value;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, 30*duration, "d");
				totalDuration =(duration * 4)/Interval_value;
			}else 
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY",locale, 7*duration, "d");
				totalDuration =(duration)/Interval_value;
			}
		}else if ((durationType.toUpperCase()).equals("D"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, duration*365, "d");
				totalDuration =(duration * 365)/Interval_value;
			}else if((pr_duration_type.toUpperCase()).equals("L"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, duration*30, "d");
				totalDuration =(duration * 30)/Interval_value;	
			}else if((pr_duration_type.toUpperCase()).equals("W"))
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, duration*7, "d");
				totalDuration =(duration * 7)/Interval_value;	
			}else 
			{
				endDate = DateUtils.plusDate(start_day_param, "DMY", locale, duration, "d");
				totalDuration =(duration)/Interval_value;	
			}
		}
		
		for (int j = 0;j < repeat ; j++)
		{		
			int val = 0;
			dateList = new ArrayList();
			dayList = new ArrayList();
			repeatMap = new HashMap();
			String str = arrList.get(j)==null?"":(String)arrList.get(j);
			if (!str.equals(""))
			{
				val = Integer.parseInt(str);
			}			
			if ((durationType.toUpperCase()).equals("D"))
				currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, val-1, "d");
			else
				currentDate = DateUtils.plusDate(start_day_param, "DMY", locale, val-1, "d");

			dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY",locale);			
			dateList.add(currentDate);
			dayList.add(dayName);			
			for (int i = 0;i<totalDuration;i++ )
			{
				if ((durationType.toUpperCase()).equals("L"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY",locale, 30*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);
					
				}else if ((durationType.toUpperCase()).equals("W"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 7*Interval_value, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", locale);				
				}else if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 1*Interval_value, "d");		
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY",locale);				
				}
				if (DateUtils.isBefore(currentDate, endDate, "DMY", locale))
				{
					dateList.add(currentDate);
					dayList.add(dayName);
				}				
			}
			repeatMap.put("DATES",dateList);
			repeatMap.put("DAYS",dayList);
			schdMap.put(j+1,repeatMap);
		}
		return schdMap;
	}

	// Method is used in NPBRequest form to replace the mnenominc details
	public String getMnemonicDetails(String pat_id, String encntr_id, String facility_id, String editor_type, String editor_template, HashMap orderDetails) throws Exception {

		Connection connection 				= null;
		PreparedStatement pstmt_template	= null;
		ResultSet resultSet_template 		= null;
 		String admission_date				= "", anaesthesia 		= "", anaesthetist_code		= "";
		String attending_practitioner		= "", bed_num			= "", blood_grp				= "";
		String current_location				= "", date_of_birth		= "", encounter_id			= "";
		String facility_name				= "", gender			= "", mar_status_code		= "";
		String name_prefix					= "", nationality_code	= "", ordering_location		= "";
		String ordering_practitioner		= "", order_category	= "", order_date			= "";
		String  order_type		= "", patient_class			= "";
		String patient_id					= "", patient_name		= "", perform_surgeon		= "";
		String pref_surg_date				= "", priority			= "", reason_refusal		= "";
		String region_code					= "", regn_date			= "", relgn_code			= "";
		String res_area_code				= "", res_town_code		= "", rh_factor				= "";
		String room_num						= "", service_code		= "", speciality			= "";
		String  residentail_address			= "",  age					= "";//catalog_description="",  Removed for IN063877
		String  sex							= "";
		String  catalog_long_desc			= "", catalog_short_desc = "", catalog_explantory_text= "";
		//String SOURCE_TYPE="", location_description="";  Removed for IN063877
		String national_id_no="", act_patient_class;
		char  variance_identity;
		String variance_code				= "", variance_desc		= "";
		int			start_val				= 0;
		int			first_end_val			= 0,  end_val			= 0, var_count				= 0;

		//StringTokenizer stCatalog			= null; Removed for IN063877
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
 
		try {
			if(editor_template!=null && !editor_template.equals("") && editor_type.equals("E")) {
				connection	= getConnection() ;
				pstmt_template = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NPB_REQ_FORM_PATIENT_TEMPLATE_SELECT") ) ;
				pstmt_template.setString( 1, language_id);
				pstmt_template.setString( 2, language_id);
				pstmt_template.setString( 3, language_id);
				pstmt_template.setString( 4, language_id);
				pstmt_template.setString( 5, pat_id);
				resultSet_template = pstmt_template.executeQuery() ;
				if(resultSet_template!=null && resultSet_template.next()){ //one record
					patient_id			= checkForNull(resultSet_template.getString( "patient_id" ))  ;
					regn_date			= checkForNull(resultSet_template.getString( "regn_date"))  ;
					patient_name		= checkForNull(resultSet_template.getString( "patient_name" ))  ;
					gender				= checkForNull(resultSet_template.getString( "gender" ))  ;
					sex					= checkForNull(resultSet_template.getString( "sex" ))  ;							
					date_of_birth		= checkForNull(resultSet_template.getString( "date_of_birth" ))  ;
					mar_status_code		= checkForNull(resultSet_template.getString( "mar_status_code" ))  ;
					nationality_code	= checkForNull(resultSet_template.getString( "nationality_code" ))  ;
					res_area_code		= checkForNull(resultSet_template.getString( "res_area_code" ))  ;
					res_town_code		= checkForNull(resultSet_template.getString( "res_town_code" ))  ;
					relgn_code			= checkForNull(resultSet_template.getString( "relgn_code" ))  ;
					name_prefix			= checkForNull(resultSet_template.getString( "name_prefix" ))  ;
					region_code			= checkForNull(resultSet_template.getString( "region_code" ))  ;
					blood_grp			= checkForNull(resultSet_template.getString( "blood_grp" ))  ;
					rh_factor			= checkForNull(resultSet_template.getString( "rh_factor" ))  ;
					residentail_address	= checkForNull(resultSet_template.getString( "residentail_address" ))  ;
					age					= checkForNull(resultSet_template.getString( "age" ))  ;
					national_id_no		= checkForNull(resultSet_template.getString( "national_id_no" ))  ;							
				}
				// close the statements
				closeResultSet( resultSet_template ) ;
				closeStatement( pstmt_template ) ;

				// For the Encounter Info Details
				pstmt_template = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NPB_REQ_FORM_ENCOUNTER_TEMPLATE_SELECT") ) ;
				
				pstmt_template.setString( 1, language_id);
				pstmt_template.setString( 2, facility_id);
				pstmt_template.setString( 3, language_id);
				pstmt_template.setString( 4, facility_id);
				pstmt_template.setString( 5, language_id);
				pstmt_template.setString( 6, language_id);
				pstmt_template.setString( 7, language_id);
				pstmt_template.setString( 8, language_id);
				pstmt_template.setString( 9, language_id);
				pstmt_template.setString( 10, facility_id);
				pstmt_template.setString( 11, encntr_id);
				resultSet_template = pstmt_template.executeQuery() ;
				if(resultSet_template!=null && resultSet_template.next()){ //one record
					encounter_id		= checkForNull(resultSet_template.getString( "encounter_id" )) ;
					current_location	= checkForNull(resultSet_template.getString( "current_location" ))  ;
					attending_practitioner= checkForNull(resultSet_template.getString( "attending_practitioner" ))  ;
					speciality			= checkForNull(resultSet_template.getString( "speciality" ))  ;
					admission_date		= checkForNull(resultSet_template.getString( "admission_date" ))  ;
					patient_class		= checkForNull(resultSet_template.getString( "patient_class" ))  ;
					room_num			= checkForNull(resultSet_template.getString( "room_num") )  ;
					bed_num				= checkForNull(resultSet_template.getString( "bed_num" ))  ;
					service_code		= checkForNull(resultSet_template.getString( "service_code" ))  ;
				}
				// close the statements
				closeResultSet( resultSet_template ) ;
				closeStatement( pstmt_template ) ;

				pstmt_template = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT10")) ; 
				pstmt_template.setString( 1, facility_id);
				pstmt_template.setString( 2, getLanguageId());
				resultSet_template = pstmt_template.executeQuery() ;
				if(resultSet_template!=null && resultSet_template.next()){
					facility_name		= checkForNull(resultSet_template.getString( "FACILITY_NAME" )) ;
				}
				closeResultSet( resultSet_template ) ;
				closeStatement( pstmt_template ) ;
				//IN033502 Ends 

				// Check if any Dynamic Variance are there, Now the max set is 20 dyanmic Lookups
				for(int i=0;i<=20;i++) { // For Loop will be for 20 times, to check any dynamic Lookup is there
					//~START`VCode|AnyDescriptionEntered~END`
					if(editor_template.indexOf("~START`")!=-1 && editor_template.indexOf("~END`")!=-1){
						start_val			= editor_template.indexOf("~START`");   // Will give the starting 
						variance_identity   = editor_template.charAt(start_val+7);  // Will give the Variance(V)/... 
						first_end_val		= editor_template.indexOf("|");
						variance_code		= editor_template.substring(start_val+8, first_end_val); //After variance till | 
						end_val				= editor_template.indexOf("~END`");
						variance_desc		= editor_template.substring(first_end_val+1, end_val); //~END is 4
						var_count				= 0;
						if(variance_identity=='V'){ // variance 
							 // Call a Function, returns true or false
							pstmt_template = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NPB_REQ_FORM_AGE_GROUP_SELECT") ) ;
							pstmt_template.setString( 1, variance_code);  //age_group_code
							pstmt_template.setString( 2, sex);			  //gender
							pstmt_template.setString( 3, sex);			  //gender
							pstmt_template.setString( 4, date_of_birth);
							resultSet_template = pstmt_template.executeQuery() ;
							if(resultSet_template!=null && resultSet_template.next()){ //one record
							  var_count		   = resultSet_template.getInt(1);
							}
							 if(var_count>0)
								editor_template	= editor_template.substring(0,start_val)+variance_desc+editor_template.substring(end_val+5);	
							 else
								editor_template	= editor_template.substring(0,start_val)+editor_template.substring(end_val+5);	
						} // End of variance_identity=="V"
						// close the statements
						closeResultSet( resultSet_template ) ;
						closeStatement( pstmt_template ) ;
					} // End of if
				}  // End of for 
				// First check with the Personal Info
			
				if(editor_template.indexOf("~PATIENT_ID`")!=-1){
					editor_template	= editor_template.replaceAll("~PATIENT_ID`",patient_id);				
				} 
				if(editor_template.indexOf("~REGN_DATE`")!=-1){
					editor_template	= editor_template.replaceAll("~REGN_DATE`",regn_date);				
				} 
				if(editor_template.indexOf("~PATIENT_NAME`")!=-1){
					editor_template	= editor_template.replaceAll("~PATIENT_NAME`",patient_name);			
				} 
				if(editor_template.indexOf("~GENDER`")!=-1){
					editor_template	= editor_template.replaceAll("~GENDER`",gender);			
				}
				if(editor_template.indexOf("~DATE_OF_BIRTH`")!=-1){
					editor_template	= editor_template.replaceAll("~DATE_OF_BIRTH`",date_of_birth);		
				}
				if(editor_template.indexOf("~MAR_STATUS_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~MAR_STATUS_CODE`",mar_status_code);	
				} 
				if(editor_template.indexOf("~NATIONALITY_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~NATIONALITY_CODE`",nationality_code);	
				} 
				if(editor_template.indexOf("~FACILITY_NAME`")!=-1){
					editor_template	= editor_template.replaceAll("~FACILITY_NAME`",facility_name);	
				}
				if(editor_template.indexOf("~RES_AREA_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~RES_AREA_CODE`",res_area_code);	
				} 
				if(editor_template.indexOf("~RES_TOWN_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~RES_TOWN_CODE`",res_town_code);	
				}
				if(editor_template.indexOf("~RELGN_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~RELGN_CODE`",relgn_code);	
				}
				if(editor_template.indexOf("~RESIDENTAIL_ADDRESS`")!=-1){
					editor_template	= editor_template.replaceAll("~RESIDENTAIL_ADDRESS`",residentail_address);	  
				}
				if(editor_template.indexOf("~NAME_PREFIX`")!=-1){
					editor_template	= editor_template.replaceAll("~NAME_PREFIX`",name_prefix);	
				}
				if(editor_template.indexOf("~REGION_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~REGION_CODE`",region_code);	
				}
				if(editor_template.indexOf("~BLOOD_GRP`")!=-1){
					editor_template	= editor_template.replaceAll("~BLOOD_GRP`",blood_grp);	
				}
				if(editor_template.indexOf("~RH_FACTOR`")!=-1){
					editor_template	= editor_template.replaceAll("~RH_FACTOR`",rh_factor);	 
				}
				if(editor_template.indexOf("~AGE`")!=-1){
					editor_template	= editor_template.replaceAll("~AGE`",age);	 
				}
				if(editor_template.indexOf("~PATIENT_NRIC`")!=-1){
					editor_template	= editor_template.replaceAll("~PATIENT_NRIC`",national_id_no);	 
				}
				// Personal Info Ends
				// Encounter Info Starts
				if(editor_template.indexOf("~ENCOUNTER_ID`")!=-1){  
					editor_template	= editor_template.replaceAll("~ENCOUNTER_ID`",encounter_id);	 
				}
				if(editor_template.indexOf("~CURRENT_LOCATION`")!=-1){
					editor_template	= editor_template.replaceAll("~CURRENT_LOCATION`",current_location);	
				} 
				/*if(editor_template.indexOf("~PRACTITIONER(L)`")!=-1){
					editor_template	= editor_template.replaceAll("~PRACTITIONER(L)`","PRACTITIONER(L)");	
				}*/
				if(editor_template.indexOf("~SPECIALITY`")!=-1){
					editor_template	= editor_template.replaceAll("~SPECIALITY`",speciality);	
				}
				if(editor_template.indexOf("~ADMISSION_DATE`")!=-1){
					editor_template	= editor_template.replaceAll("~ADMISSION_DATE`",admission_date);	
				} 
				if(editor_template.indexOf("~PATIENT_CLASS`")!=-1){
					editor_template	= editor_template.replaceAll("~PATIENT_CLASS`",patient_class);	
				} 
				if(editor_template.indexOf("~ROOM_NUM`")!=-1){
					editor_template	= editor_template.replaceAll("~ROOM_NUM`",room_num);	
				}
				if(editor_template.indexOf("~BED_NUM`")!=-1){
					editor_template	= editor_template.replaceAll("~BED_NUM`",bed_num);	
				}
				if(editor_template.indexOf("~ATTENDING_PRACTITIONER`")!=-1){
					editor_template	= editor_template.replaceAll("~ATTENDING_PRACTITIONER`",attending_practitioner);	
				}
				if(editor_template.indexOf("~SERVICE_CODE`")!=-1){
					editor_template	= editor_template.replaceAll("~SERVICE_CODE`",service_code);	
				}
				//End of Encounter Info
				// Order Informations
				/*	if(editor_template.indexOf("~ORDER_ID`")!=-1){				
					editor_template	= editor_template.replaceAll("~ORDER_ID`",order_id);	  
				}*/
				if(orderDetails!=null){
					order_date = orderDetails.get("ORDER_DATE")==null?"":(String)orderDetails.get("ORDER_DATE");
					priority = orderDetails.get("PRIORITY")==null?"":(String)orderDetails.get("PRIORITY");
					ordering_location = orderDetails.get("ORDERING_LOCATION")==null?"":(String)orderDetails.get("ORDERING_LOCATION");
					ordering_practitioner = orderDetails.get("ORDERING_PRACTITIONER")==null?"":(String)orderDetails.get("ORDERING_PRACTITIONER");
					order_type = orderDetails.get("ORDER_TYPE")==null?"":(String)orderDetails.get("ORDER_TYPE");
					order_category = orderDetails.get("ORDER_CATEGORY")==null?"":(String)orderDetails.get("ORDER_CATEGORY");
					act_patient_class = orderDetails.get("ACT_PATIENT_CLASS")==null?"":(String)orderDetails.get("ACT_PATIENT_CLASS");

					pstmt_template = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_SELECT_NPB_ORDERINFDTL") ) ;
					pstmt_template.setString( 1, act_patient_class);
					pstmt_template.setString( 2, facility_id);
					pstmt_template.setString( 3, ordering_location);
					pstmt_template.setString( 4, language_id);
					pstmt_template.setString( 5, facility_id);
					pstmt_template.setString( 6, ordering_location);
					pstmt_template.setString( 7, login_by_id);
					pstmt_template.setString( 8, ordering_practitioner);
					pstmt_template.setString( 9, language_id);
					pstmt_template.setString( 10, order_type);
					pstmt_template.setString( 11, language_id);
					pstmt_template.setString( 12, order_category);
					pstmt_template.setString( 13, language_id);
					resultSet_template = pstmt_template.executeQuery() ;
					if(resultSet_template!=null && resultSet_template.next()){ //one record
						ordering_location	= checkForNull(resultSet_template.getString( "location_description" ))  ;
						ordering_practitioner= checkForNull(resultSet_template.getString( "ordering_practitioner" ))  ;
						order_type			= checkForNull(resultSet_template.getString( "order_type" ))  ;
						order_category		= checkForNull(resultSet_template.getString( "order_category" ))  ;
					}
				}
				// close the statements
				closeResultSet( resultSet_template ) ;
				closeStatement( pstmt_template ) ;

				if(priority.equals("R") || priority.equals(""))
					priority=common_labels.getString("Common.routine.label");
				else if(priority.equals("U"))
					priority=common_labels.getString("Common.urgent.label");
				else if(priority.equals("S"))
					priority=common_labels.getString("Common.Stat.label");

				if(editor_template.indexOf("~ORDER_DATE`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDER_DATE`",order_date);	  
				}
				if(editor_template.indexOf("~PRIORITY`")!=-1){
					editor_template	= editor_template.replaceAll("~PRIORITY`",priority);	  
				} 
				if(editor_template.indexOf("~ORDERING_LOCATION`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDERING_LOCATION`",ordering_location);
				}
				if(editor_template.indexOf("~ORDERING_PRACTITIONER`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDERING_PRACTITIONER`",ordering_practitioner);
				}
				if(editor_template.indexOf("~ORDER_TYPE`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDER_TYPE`",order_type);
				}
				if(editor_template.indexOf("~ORDER_CATEGORY`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDER_CATEGORY`",order_category);
				}
				if(editor_template.indexOf("~ANAESTHESIA`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ANAESTHESIA`",anaesthesia);
				}
				if(editor_template.indexOf("~PREF_SURG_DATE`")!=-1){				 
					editor_template	= editor_template.replaceAll("~PREF_SURG_DATE`",pref_surg_date);
				}
				if(editor_template.indexOf("~PERFORM_SURGEON`")!=-1){				 
					editor_template	= editor_template.replaceAll("~PERFORM_SURGEON`",perform_surgeon);
				}
				if(editor_template.indexOf("~ANAESTHETIST_CODE`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ANAESTHETIST_CODE`",anaesthetist_code);
				}
				if(editor_template.indexOf("~REASON_REFUSAL`")!=-1){				 
					editor_template	= editor_template.replaceAll("~REASON_REFUSAL`",reason_refusal);
				}
				if(editor_template.indexOf("~ORDERABLE`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDERABLE`",catalog_short_desc);
				}
				if(editor_template.indexOf("~ORDERABLE_LONG`")!=-1){				 
					editor_template	= editor_template.replaceAll("~ORDERABLE_LONG`",catalog_long_desc);
				}
				if(editor_template.indexOf("~EXPLANTORY_TEXT`")!=-1){				 
					editor_template	= editor_template.replaceAll("~EXPLANTORY_TEXT`",catalog_explantory_text);
				}
				// End of Order Info
				if(editor_template.indexOf("~")!=-1 && editor_template.indexOf("`")!=-1){
					editor_template	= editor_template.substring(0,editor_template.indexOf("~")) + "N/A"+editor_template.substring(editor_template.indexOf("`")+1);
				}
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
		} 
		finally {
			closeResultSet( resultSet_template ) ;
			closeStatement( pstmt_template ) ;
			closeConnection(connection) ;
		}
		return editor_template;
	}
	// To get the record on the basis of primary key.
	// Added by gangadharan Friday, February 22, 2013

	public HashMap fetchRecord(String sql) throws Exception {
		return fetchRecord( sql, (ArrayList) null);
	}

	public HashMap fetchRecord(String sql, String stParameter) throws Exception {
		ArrayList alParameters	=	new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecord( sql,  alParameters);
	}
	public HashMap fetchRecord(String sql, String[] stParameters) throws Exception {
		ArrayList alParameters	=	new ArrayList(stParameters.length);
		for (int i=0;i< stParameters.length;i++ ) {
			alParameters.add(stParameters[i]);	
		}
		return fetchRecord( sql,  alParameters);
	}

	public HashMap fetchRecord(String sql, ArrayList alParameters) throws Exception {
		
		HashMap hmRecord					=	new HashMap();
		Connection connection				= null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) 
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long)
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());

			resultSet = preparedStatement.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();

		if(resultSet!=null && resultSet.next()){
			
			for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ ){
				int iColumnType=	resultSetMetaData.getColumnType(i);
				switch (iColumnType){

				case Types.CLOB:
					Clob clobData= resultSet.getClob(resultSetMetaData.getColumnName(i));
					StringBuffer sbClobData	= new StringBuffer();
					if(clobData!=null)
						sbClobData.append(clobData.getSubString(1,(int)clobData.length()));
					hmRecord.put(resultSetMetaData.getColumnName(i),sbClobData.toString());
					break;
	
				default:
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				}
			}
		}
		} 
		catch (Exception exception )	{
			System.err.println("Error @ fetch Record..");
			System.err.println("Parameter rcd: SQL:"+sql);
			System.err.println("Bind Values rcd:        "+alParameters);
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}

		}
		return hmRecord;
	}

	public ArrayList fetchRecords(String sql) throws Exception {
		return fetchRecords( sql,  new ArrayList(0));
	}

	public ArrayList fetchRecords(String sql, String stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecords( sql,  alParameters);
	}
	public ArrayList fetchRecords(String sql, String []stParameter) throws Exception {
		ArrayList alParameters = new ArrayList(stParameter.length);
		for (int i=0;i<stParameter.length;i++) {
			alParameters.add(stParameter[i]);
		}
		return fetchRecords( sql,  alParameters);
	}
	public ArrayList fetchRecords(String sql, ArrayList alParameters) throws Exception {
		ArrayList alRecords					=	new ArrayList();
		HashMap hmRecord					=	null;
		Connection connection				= null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) {
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long){
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());
					}
			}

			resultSet = preparedStatement.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();
			int i	=1	;
			while(resultSet!=null && resultSet.next())
			{
				hmRecord=new HashMap();
				for (i=1; i<=resultSetMetaData.getColumnCount(); i++ )
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				alRecords.add(hmRecord);
			}
		} 
		catch (Exception exception )	{
			System.err.println("Error @ fetchRecords");
			System.err.println("Parameter rcd: SQL:"+sql);
			System.err.println("Bind Values rcd:   "+alParameters);
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return alRecords;
	}

	public ArrayList getListOptionArrayList(String sql) {
		return getListOptionArrayList(sql,new ArrayList(0));
	}

	public ArrayList getListOptionArrayList(String sql,String parameter) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter);
	}

	public ArrayList getListOptionArrayList(String sql,String []stParameters) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter);
	}
	public ArrayList getListOptionArrayList(String sql,String []stParameters,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (stParameters.length);
		for (int i=0; i<stParameters.length; i++ )
			alParameter.add(stParameters[i]);

		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}
	public ArrayList getListOptionArrayList(String sql,String parameter,boolean isSelectRequired) {
		ArrayList alParameter=new ArrayList (1);
		alParameter.add(parameter);
		return getListOptionArrayList(sql, alParameter,isSelectRequired);
	}
	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters, boolean isSelectRequired) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			// String select_option = "";Removed for IN063877
			ArrayList alOptionValues = new ArrayList();

			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";

			if(isSelectRequired)
				alOptionValues.add(select_option_legend);
			try {
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql);
				if (alParameters!=null) {
					for (int index=0;index<alParameters.size();index++) {
						preparedStatement.setString(index+1,alParameters.get(index).toString());
					}
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
				}
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
				}
			}
			return alOptionValues;
	}
	public ArrayList getListOptionArrayList(String sql,ArrayList alParameters) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			//String select_option= ""; Removed for IN063877
			ArrayList alOptionValues = new ArrayList();
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alOptionValues.add(select_option_legend);
			try {
				connection=getConnection();
				preparedStatement=connection.prepareStatement(sql);
				if (alParameters!=null) {
					for (int index=0;index<alParameters.size();index++) {
						preparedStatement.setString(index+1,alParameters.get(index).toString());
					}
				}
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(2)});
					
				}
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
				}
			}
			
			return alOptionValues;
	}

	public String getListOptionTag(ArrayList arrayListValue ) {
		if (arrayListValue == null) {
			return null;
		}
		StringBuffer tagValue = new StringBuffer();
		for (int count=0;count<arrayListValue.size();count++ ) {
			Object obj	=	arrayListValue.get(count);
			if (obj instanceof String[]) {
				tagValue.append("<option value=\"");
				tagValue.append(((String[])obj)[0]);
				tagValue.append("\">");
				tagValue.append(((String[])obj)[1]);
				tagValue.append("</option>\n");
			}
			else{
				tagValue.append(arrayListValue.get(count).toString());
				tagValue.append('\n');
			}
		}
		return tagValue.toString();
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}

	public String getStaticListOptionTag(String stStaticList, String defaultValue, boolean isSelectRequired) {
		StringBuffer tagValue = new StringBuffer();
		StringTokenizer stListItems=new StringTokenizer(stStaticList,";");
		if(isSelectRequired)
			tagValue.append(eST.Common.StRepository.getStKeyValue("DEFAULT_LIST_OPTION").toString());

		while (stListItems.hasMoreTokens()) {
			StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),",");
			String value	=	stListValueText.nextToken();
			String selected =    defaultValue.equalsIgnoreCase(value)?"selected":"";
			tagValue.append("<option value=\""+value+"\" "+selected+">"+stListValueText.nextToken()+"</option>\n");
		}
		return tagValue.toString();
	}
	

	public String getStaticListOptionTag(String stStaticList) {
		return getStaticListOptionTag(stStaticList, "");
	}
	public String getListOptionTag(ArrayList arrayListValue,String defaultValue) {
		if (arrayListValue == null) {
			return null;
		}
		boolean foundDefault = false;
		StringBuffer tagValue = new StringBuffer();
		Object tempObject = null;
		OptionValues tempOptionValues = null;
	
		for (int count=0;count<arrayListValue.size();count++ ) {
			tempObject = arrayListValue.get(count);
			if ((tempObject instanceof String[])) {
				String [] tempStringArray = (String []) tempObject;
				tagValue.append("<option value=\"");
				tagValue.append(tempStringArray[0]);
				tagValue.append("\"");
				if (tempStringArray[0].equals(defaultValue)) {
					tagValue.append(" selected ");
				}
				tagValue.append(">");
				tagValue.append(tempStringArray[1]);
				tagValue.append("</option>\n");
			}
			else if ((!foundDefault) && (tempObject instanceof OptionValues)) {
				tempOptionValues = (OptionValues) tempObject;
				if (tempOptionValues.equals(defaultValue)) {
					foundDefault = true;
					tempOptionValues.setDefault(foundDefault);
				}
				tagValue.append(tempOptionValues.toString());
			}
			else {
				tagValue.append(tempObject.toString());
			}	
			tagValue.append('\n');
		}
		tempObject = null;
		tempOptionValues = null;
		return tagValue.toString();
	}

	public String getListValues(String sql, java.util.ArrayList sqlParam, String selectedValue) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(sql, sqlParam);
		optionValues = getListOptionTag(alOptionValues, selectedValue);
		alOptionValues = null;
		return optionValues;
	}
	//Added for IN:072715 START
	public String getOverrideListValues(String sql, java.util.ArrayList sqlParam, String selectedValue) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(sql, sqlParam);
		alOptionValues.add(new String[]{"OTHR","Others"});
		//String others_option_legend="<option value=\"OTHR\">Others &nbsp;&nbsp;&nbsp;&nbsp;</option>";
		//alOptionValues.add(others_option_legend);
		optionValues = getListOptionTag(alOptionValues, selectedValue); 
		alOptionValues = null;
		return optionValues;
	}
	//Added for IN:072715 END
	
	//Added for MOHE-CRF-0074 -Start

	public String getRegionCode(){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String region_code = "";
		
		try
		{
			connection =getConnection();
		
		pstmt = connection.prepareStatement("SELECT REGION_CODE FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ? AND STATUS ='E'");
		pstmt.setString(1, login_facility_id);
		resultSet = pstmt.executeQuery() ;
		if(resultSet!=null && resultSet.next())
		{ 
			region_code = resultSet.getString("REGION_CODE")==null?"":resultSet.getString("REGION_CODE");
	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
	   return region_code;	
	}
	
	public ArrayList getRegionCheck(String p_user_name, String region_code){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String region_check = ""; //Commented for COMMON-ICN-0060
		ArrayList result=new ArrayList();
		try
		{
			connection =getConnection();
		
		pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID, B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_LANG_VW B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS = 'E' AND APPL_USER_ID = ? AND B.REGION_CODE = ? AND B.LANGUAGE_ID = ? ORDER BY FACILITY_NAME");
		pstmt.setString(1, p_user_name);
		pstmt.setString(2, region_code);
		pstmt.setString(3, language_id);
		resultSet = pstmt.executeQuery() ;
		while(resultSet!=null && resultSet.next())
		{ 
			result.add(resultSet.getString("FACILITY_ID")==null?"":resultSet.getString("FACILITY_ID"));
			result.add(resultSet.getString("FACILITY_NAME")==null?"":resultSet.getString("FACILITY_NAME"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
			result.add(e.toString());
		}
	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
	   return result;	
	}
	

public ArrayList getRegionCheckNew(String region_code){
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	//String region_check = "";  //Commented for COMMON-ICN-0060
	ArrayList result=new ArrayList();
	try
	{
		connection =getConnection();
	
	pstmt = connection.prepareStatement("SELECT FACILITY_ID ,FACILITY_NAME  FROM  SM_FACILITY_PARAM_LANG_VW  WHERE STATUS ='E' AND REGION_CODE=? AND LANGUAGE_ID= ? order by FACILITY_NAME");
	pstmt.setString(1, region_code);
	pstmt.setString(2, language_id);
	resultSet = pstmt.executeQuery() ;
	while(resultSet!=null && resultSet.next())
	{ 
		result.add(resultSet.getString("FACILITY_ID")==null?"":resultSet.getString("FACILITY_ID"));
		result.add(resultSet.getString("FACILITY_NAME")==null?"":resultSet.getString("FACILITY_NAME"));
	}
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
		result.add(e.toString());
	}
    finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){
			es.printStackTrace() ;
		}
	}
   return result;	
}

	//Added for MOHE-CRF-0074 -End

	public HashMap getBarcodedetails(String barcodeData)throws Exception{//Adding start for MOHE-CRF-0167 and MMS-DM-CRF-0174

	            int    index =0;
				String GTIN ="";
				String batch_id ="";
				String exp_date ="";
				String otherdata ="";
				String batchData ="";
				HashMap batchDetails = new HashMap();
				if(barcodeData.contains("[GS]")){
                     barcodeData =barcodeData.replace("[GS]","_");
				}
           try{
				if (index + 2 < barcodeData.length() && barcodeData.substring(index, index + 2).equals("01")) {
							 GTIN = barcodeData.substring(index+2,16);
							 otherdata = barcodeData.substring(GTIN.length()+2,barcodeData.length());
							 System.out.println("GTIN@1910==="+GTIN+"other_data=="+otherdata);
				}if(otherdata.length()>0){
					if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
                       if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("10")) {
								if(otherdata.length()>22)
									 batchData = otherdata.substring(index+2,22);
								else
									 batchData = otherdata.substring(index+2,otherdata.length());
								int gsIndex = batchData.indexOf("_");
								   if(gsIndex == -1){
									  gsIndex = batchData.length();
								     }
							     batch_id = otherdata.substring(index + 2,gsIndex+2);
								 System.err.println("otherdata@@@===="+otherdata+"batch_id@@==="+batch_id);
								  if((gsIndex+3) < otherdata.length()){
							     
									 otherdata = otherdata.substring(gsIndex+3,otherdata.length());
								 }
					       }if (index + 2 < otherdata.length() && otherdata.substring(index, index + 2).equals("17")) {
								  exp_date = otherdata.substring(index+2,10);
								  otherdata = otherdata.substring(exp_date.length()+2,otherdata.length());
						   }
					}
					
				}
			   batchDetails.put("GTIN",GTIN);
			   batchDetails.put("BATCH_ID",batch_id);
			   batchDetails.put("EXPIRY_DATE",exp_date);
	   }
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		  }

		 return batchDetails;
  }
}
