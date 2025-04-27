/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class  ScheduleFrequencyCompBean  extends OrAdapter implements	Serializable
{
	protected String                      freq_code;
	protected String                      admin_facility_id;
	protected String                      admin_day_or_time;
	protected String                      admin_day;
	protected String		              admin_time;
	//private String patient_id          		= null ;
	//private String encounter_id        		= null ;
	
	public String tempChk	=	"";

/*********************Constructor *************************/

 public ScheduleFrequencyCompBean()
{
			 admin_facility_id						= ""    ;
			 admin_day_or_time						= ""    ;
			 admin_day								= ""    ;
			 admin_time								= ""    ;
			try {
				doCommon();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

/*********************Validate *************************/

public HashMap validate() throws Exception {
	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );
	return map;
}

/**********************SET METHODS*************************/

  public void  setFreq_code(String  freq_code) {this.freq_code=  freq_code; } ;
  public void  setAdmin_facility_id(String  admin_facility_id) {this.admin_facility_id=  admin_facility_id; } ;
  public void  setAdmin_day_or_time(String  admin_day_or_time) {this.admin_day_or_time=  admin_day_or_time; } ;
  public void  setAdmin_day(String  admin_day) {this.admin_day=  admin_day; } ;
  public void  setAdmin_time(String admin_time) {this.admin_time=  admin_time; } ;

/**********************GET METHODS*************************/

  public String getFreq_code() { return this.freq_code ; } ;
  public String getAdmin_facility_id() { return this.admin_facility_id ; } ;
  public String getAdmin_day_or_time() { return this.admin_day_or_time ; } ;
  public String getAdmin_day() { return this.admin_day ; } ;
  public String getAdmin_time() { return this.admin_time ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

/* public void setAll( Hashtable recordSet ) {

}
*/

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
			 admin_facility_id						= ""    ;
			 admin_day_or_time						= ""    ;
			 admin_day								= ""    ;
			 admin_time								= ""    ;
}

/*********************************************************/
public Object getComboOptions(String option) {
Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet rs = null;


try{
		connection					  = getConnection();
	//	String SCHEDULE_FREQUENCY_DAY = "SELECT initcap(substr(DAY_OF_WEEK,1,3)) Disp_day_of_week,day_no day_of_week  FROM sm_day_of_week";

		String SQL_OR_SCHEDULE_FREQ_DAY = OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_FREQ_DAY");
		Object str					    = "";
		if(option.trim().equalsIgnoreCase("day")){
		str = Populate.getAsHashArray(SQL_OR_SCHEDULE_FREQ_DAY,connection,"Disp_day_of_week","day_of_week");
		}

		return str;

}catch(Exception e){
		e.printStackTrace();
		return null;
}finally{

		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
			e.printStackTrace();
		 }
	}
}
/*********************************************************************/
public ArrayList getFreqValues(String  freq_code){
Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet rs = null;
try{
	connection = getConnection();
	ArrayList  retVales = new ArrayList();
 	//String SQL_OR_SCHEDULE_FREQ_FREQLEGEND = "SELECT  freq_code, freq_desc, repeat_value, interval_durn_type, repeat_value || ' '|| 'Repeats Per ' || b.Durn_desc || ' ' ||b.for_text || ' Every  ' || Interval_value || ' ' || c.durn_Desc  Frequency_Legend, START_TIME_ROUND, START_TIME_ASSIGN FROM   am_frequency a,  am_duration_type b, am_duration_type c WHERE  interval_durn_type IN ('H','D','W','M') AND  Scheduled_yn ='Y' AND  eff_status ='E' AND a.repeat_durn_type =b.durn_type AND a.interval_durn_type = c.durn_type and  freq_code = ?";
	String SQL_OR_SCHEDULE_FREQ_FREQLEGEND =OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_FREQ_FREQLEGEND");

	pstmt = connection.prepareStatement(SQL_OR_SCHEDULE_FREQ_FREQLEGEND);
	pstmt.setString(1,freq_code.trim());
	pstmt.setString(2,language_id);
	pstmt.setString(3,language_id);

	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
	retVales.add(0,checkForNull(rs.getString("REPEAT_VALUE")));
	retVales.add(1,checkForNull(rs.getString("INTERVAL_DURN_TYPE")));
	//retVales.add(2,checkForNull(rs.getString("FREQUENCY_LEGEND")));
	retVales.add(2,checkForNull(rs.getString("START_TIME_ROUND")));
	retVales.add(3,checkForNull(rs.getString("START_TIME_ASSIGN")));
	retVales.add(4,checkForNull(rs.getString("durn_desc")));
	retVales.add(5,checkForNull(rs.getString("for_text")));
	retVales.add(6,checkForNull(rs.getString("Interval_value")));
	retVales.add(7,checkForNull(rs.getString("durn_desc_type")));
	}

 	return retVales;

}catch(Exception e){

		e.printStackTrace();
		//tempChk +="e=" +e.getMessage();
          tempChk = tempChk+"e=" +e.getMessage();
		return null;
}finally{

		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
  }

}

/**************************LOAD**********************************/
public ArrayList load(String freq_code,String facility_id){



//String sql ="select ADMIN_DAY_OR_TIME,ADMIN_DAY,to_char(ADMIN_TIME,'HH24:MI')ADMIN_TIME from AM_FREQUENCY_ADMIN_DAY_TIME where freq_code=? and admin_facility_id=? order by ADMIN_TIME" ;

Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet rs = null;
ArrayList str = new ArrayList();

try
{
		String sql = OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_FREQ_ADMIN_DAY_TIME");

		connection	 = getConnection();

		pstmt		 = connection.prepareStatement(sql);
		pstmt.setString(1,freq_code.trim());
		pstmt.setString(2,facility_id.trim());
//		pstmt.setString(3,facility_id.trim());

		rs			 = pstmt.executeQuery();
		ArrayList day_list	= new ArrayList();
		ArrayList day_names	= new ArrayList();
		ArrayList time_list	= new ArrayList();
		ArrayList dose_list	= new ArrayList();
		HashMap currRec =  new 	HashMap();
		//String tempTime = "";
		//String durationType = "";
 		while(rs!=null && rs.next())
		{					
			day_list.add(rs.getString("admin_day") == null ?"0": rs.getString("admin_day"));
			day_names.add("");
			time_list.add(checkForNull(rs.getString("admin_time")));
			dose_list.add("");						
		}
		str.add(currRec);
		str.add(day_list);
		str.add(day_names);
		str.add(time_list);
		str.add(dose_list);
 		return str;

}catch(Exception e){
		e.printStackTrace();

		return null;
}finally{

		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
			e.printStackTrace();
		 }
}


}

/*******************Method to get sm _day *************/
 public HashMap getDay(){
	 Connection connection =null ;
	 PreparedStatement pstmt = null ;
	 ResultSet rs = null;
try
{
		String sql1 = OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY");
		String sql2 = OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME");
		HashMap  dayTime   = new HashMap()	 ;

		connection	 = getConnection();

		pstmt		 = connection.prepareStatement(sql1);

		rs			 = pstmt.executeQuery();


		while(rs.next()){
			 dayTime.put("day_no",	rs.getString("day_no"));
 		}

		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
		 }catch(Exception e){
			e.printStackTrace();
		 }
		pstmt		= connection.prepareStatement(sql2);

		rs			 = pstmt.executeQuery();

		while(rs.next()){
			 dayTime.put("day_date", rs.getString("sys_date"));
 			 dayTime.put("day_time", rs.getString("sys_time"));
		}

		return dayTime;

}catch(Exception e){
		e.printStackTrace();
		return null;
}finally{

		try
		 {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){
			e.printStackTrace();
		 }
}


 }



 /***************Method to paint internally and pass the value as Hashtable*******************/
public Hashtable setScheduleFrequencyDefault(Hashtable hash){
 	 Hashtable hash_table  		= new Hashtable();
    try{
		String locale = properties.getProperty("LOCALE");
    	String code       			= checkForNull((String)hash.get("code"));
     	String row_value       		= checkForNull((String)hash.get("row_value"));
    	String facility_id       	= checkForNull((String)hash.get("facility_id"));
    	String start_time_day_param = checkForNull((String)hash.get("start_time_day_param"));
     	//String module_id       		= checkForNull((String)hash.get("module_id"));
	   	//String split_dose_yn		= checkForNull((String)hash.get("split_dose_yn"));
 		String split_qty			= checkForNull((String)hash.get("split_qty"));
 		String freq_code			= checkForNull((String)hash.get("freq_code"));
 		String raise_error			= "";

   		//int	   indxTime				= 0;
    	//String start_day_param		= "";  	String start_time_param		= "";
    	//String admin_day_or_time_temp 	= "";
    	//String dt					= "";
    	String dq					= "";

    	//String freqLegend_P			= "";
 		String durationType_P		= "";
 		String repeatValue_P		= "";
 		//String start_time_round_p	= "";	String start_time_assign_p	= "";
 		//String start_time_assign 	= "";
 		//String start_day_assign 	= "";

 		String chk_time_dt			= "";

 		//String  today				= "", todayTime = "", todayDate = "";
 		String day		   			= "", daySMInsert = "";
		String admin_day			=  ""; //Added by Uma on 6/18/2009

 		//int counter					= 0;
     	ArrayList rs          		= null ;
    	ArrayList freqValues		= null ;
    	//HashMap recCurr 			= null;

		HashMap hdr_data = null;
		ArrayList day_list = null;
		ArrayList day_names =null;
		ArrayList time_list = null;
		ArrayList dose_list =null;

		int	   indxTime				= 0;
		String start_day_param		= "";
		String start_time_param		= "";

    	if(!start_time_day_param.trim().equals("")){
 		    indxTime				= start_time_day_param.indexOf(" ");
 			start_day_param			= start_time_day_param.substring(0,indxTime);
 			start_time_param		= start_time_day_param.substring(indxTime+1);
 		}
		//OrderEntryBean ob = new OrderEntryBean();
		ArrayList<String> weekList = getDayOfWeek(com.ehis.util.DateUtils.convertDate(start_day_param, "DMY",locale, "en"));

    	//HashMap today_date_time	 	= bean.getDay();
    	 // HashMap today_date_time	= getDay();
			/*if(today_date_time!=null)
			{
 				today					= (String)today_date_time.get("day_no");
 				todayTime				= (String)today_date_time.get("day_time");
 				todayDate				= (String)today_date_time.get("day_date");
			}*/
 		//To get no of Repeats,start time assign/round and freq Legend ....for a particulay freq_code

 		 //freqValues				= bean.getFreqValues(freq_code);
 		 freqValues					= getFreqValues(freq_code);

		if((freqValues!=null) && (freqValues.size()>0))
		{
			
 		 //freqLegend_P				= (String)freqValues.get(2);
 		 //freqLegend					= freqLegend_P;
 		 durationType_P				= (String)freqValues.get(1);
		 repeatValue_P				= (String)freqValues.get(0);
 		 //start_time_round_p			= (String)freqValues.get(3);
 		 //start_time_assign_p		= (String)freqValues.get(4);
	 	}

 		 //HashMap	  days			= (HashMap)bean.getComboOptions("day");
 		 HashMap	  days			= (HashMap)getComboOptions("day");
		 ArrayList daysArray		= (ArrayList)days.get("value");
 		 ArrayList daysInsertArray	= (ArrayList)days.get("Description");
 		 Iterator  iterateDays		= daysArray.iterator() ;

 		 Iterator  iteratedaysInsert= daysInsertArray.iterator() ;


 	 	 hash_table.put("repeat", repeatValue_P);
 	 	 hash_table.put("durationType", durationType_P);
 		int i=0;
 	     while(iterateDays.hasNext() && iteratedaysInsert.hasNext() ){
 	 		 i++;
 	 		 day		   		= (String)iterateDays.next() ;
 	 		 daySMInsert	   	= (String)iteratedaysInsert.next() ;
 	 		 hash_table.put("daySM"+daySMInsert, daySMInsert);
 	 		 hash_table.put("dayDisplay"+i, day);
     	}

 		hash_table.put("day_value",String.valueOf(i));
 		//rs 		= bean.load(freq_code,facility_id);
 		rs 		= load(freq_code,facility_id);
		if (rs != null && rs.size() > 0)
		{
			hdr_data = (HashMap)rs.get(0);
			day_list = (ArrayList)rs.get(1);
			day_names = (ArrayList)rs.get(2);

			if (durationType_P.equals("W"))
			{			
				if (day_names != null)
				{
					if (day_list != null && day_list.size() != 0)
					{
						day_names.clear();
						for(Object dayNum : day_list)
						{

							int index = Integer.parseInt(dayNum.toString()); 						

							if (index != 0)
							{
								day_names.add(weekList.get(index-1));
							}
						}
					}								
				}
			}else{						
					if (day_list != null && day_list.size() != 0)
					{
						day_names.clear();
						for(Object dayNum : day_list)
						{							
							day_names.add("");	
							System.err.println("dayNum "+dayNum);
						}		
					}
				
			}

			time_list = (ArrayList)rs.get(3);
			dose_list = (ArrayList)rs.get(4);
			hdr_data.put("repeat",repeatValue_P);
			hdr_data.put("durationType",durationType_P);
			hdr_data.put("start_date_time",start_time_day_param);
			dose_list.clear();
			 for(int k= 1; k <= Integer.parseInt(repeatValue_P); k++)
			{
				dose_list.add(split_qty);
			}
			
			rs.clear();
			rs.add(hdr_data);
			rs.add(day_list);
			rs.add(day_names);
			rs.add(time_list);
			rs.add(dose_list);
		}
		
 	 	
		/*int k= 0;
 		if(rs.size() > 0){
 			 for(int j = 0 ; j < rs.size(); j++){
 				 recCurr = (HashMap)rs.get(j);
 				//For Particular freq code & facility admin_day_or_time could be either D or H only
 			 	admin_day_or_time = (String)recCurr.get("admin_day_or_time");
 			 	start_day_assign  = checkForNull((String)recCurr.get("start_day_assign"));
  			 	start_time_assign = checkForNull((String)recCurr.get("start_time_assign"));

 			 	//admin_day_or_time_temp = "";
 			 	if(admin_day_or_time.trim().equalsIgnoreCase("H") || admin_day_or_time.trim().equalsIgnoreCase("D"))	
				{//if duration_type is hrs or days
					admin_day = checkForNull((String)recCurr.get("admin_day"));//Added by Uma on 6/18/2009
 					dt  = (String)recCurr.get("admin_time");
 					dq  = checkForNull((String)recCurr.get("admin_qty"));

				if(dt!=null && !dt.equals(""))
					chk_time_dt = dt;
 				//For PH when default qty is passed
 				if(dq.trim().equals("")){
 			  		if(split_dose_yn.trim().equalsIgnoreCase("N") || split_dose_yn.trim().equalsIgnoreCase("Y"))
 						dq	=	split_qty ;
 					}

 				}else {//if duration type is other than hrs
 				//get which days are checked
 				dt = (String)recCurr.get("admin_time");
 				if(dt!=null && !dt.equals(""))
					chk_time_dt = dt;
 					if(dt == null || dt.trim().equalsIgnoreCase("")){
 					  // chkDaysUpdate += (String)recCurr.get("admin_day") + "|";
 						dt = "";
 		    		}
 	     		}
 	     		k++;
 	     		//Builds Time's Html and Qty Hmtl
 	     		//if(k <= Integer.parseInt(repeatValue_P)){Commented by Uma on 6/18/2009
 	     			hash_table.put("displayHrs"+k,String.valueOf(k));
 	     			hash_table.put("time"+k, dt);
 	     			hash_table.put("qty"+k, dq);
					hash_table.put("admin_day"+k,admin_day);//Added by Uma on 6/18/2009

 	    		//} // End of k //Commented by Uma on 6/18/2009
 	  } // End of for rs
 	  if(Integer.parseInt(repeatValue_P.trim()) > counter){
 			for(int n = counter ; n < Integer.parseInt(repeatValue_P.trim()) ; n++){
 				n = counter++;
 				hash_table.put("displayHrs"+(++k), String.valueOf(k));
 				hash_table.put("time"+k, "");
 				hash_table.put("qty"+k, "");
 				hash_table.put("admin_day"+k, "");//Added by Uma on 6/18/2009
 			}  //eND OF fOR lOOP
 	   }	 //eND OF IF COUNTER < RePEAT

	}*/
	if(rs == null || rs.size() < 0)
	{//NO RECORDS FETCHED	FORM DATABASE -- FOR FIRST TIME CLIENT VISIT

 		 /**Builds Time's Html***/
		 if(!repeatValue_P.equals(""))
		{
			 rs = new ArrayList();
			hdr_data = new HashMap();
			day_list = new ArrayList();
			day_names = new ArrayList();
			time_list = new ArrayList();
			dose_list =new ArrayList();
			hdr_data.put("repeat",repeatValue_P);
			hdr_data.put("durationType",durationType_P);
			hdr_data.put("start_date_time",start_time_day_param);
			hdr_data.put("row_value", row_value);
			
			 for(int m= 1; m <= Integer.parseInt(repeatValue_P); m++)
			{
				time_list.add("");
				dose_list.add(dq);
				day_list.add(admin_day);				
				chk_time_dt = "";
			}
		}

		 if(chk_time_dt==null  || chk_time_dt.equals(""))
			raise_error = "Schedule Cannot be Blank";
			hdr_data.put("start_date_time",start_time_day_param);

	/*	   hash_table.put("start_time_assign", start_time_assign);
		   hash_table.put("start_day_assign", start_day_assign);
		   hash_table.put("code", code);*/

		   rs.add(hdr_data);
		   rs.add(day_list);
		   rs.add(day_names);
		   rs.add(time_list);
		   rs.add(dose_list);

       } // End of size


      
       hash_table.put(code, rs);
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}  
	
	return hash_table;
} // End of ScheduleFrequencyDefault
 /************** End ***************/

 public ArrayList<String> getDayOfWeek(String sDate) 
	{
		String[] Days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		ArrayList<String> dayList = new ArrayList<String>();	
		java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = new java.util.Date();
		try 
		{
			if (sDate != null && !sDate.equals(""))
			{			
			  df.setLenient(false);
			  d = df.parse(sDate);
			  //java.util.Calendar c=java.util.Calendar.getInstance();		 
			  int x = d.getDay();
			  int y = Days.length;
			   for (int i = x;i<y ;i++ )
			   {
					dayList.add(Days[i]);
					if (i==Days.length-1)
					{
						for (int j = 0;j<x ;j++ )
						{
							dayList.add(Days[j]);
						}					
					}
			   }	   		
		   }
		} catch(java.text.ParseException e) {
			e.printStackTrace();
		  return null;
		}
		return dayList; 
	}
 /************** End ***************/



/*********************METHOD TO Insert*************************/

public HashMap insert(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "Update failure.." );
	return map ;
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "Update failure.." );
	return map;
}

/*********************METHOD TO Delete*************************/

public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
}

/*********************DoCommon*************************/

private void doCommon() throws Exception {
}

public String getSlidingScaleYN(String order_id,String order_line_num) throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String sliding_scale_yn= "N";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_SLIDING_SCALE_YN"));
			pstmt.setString(1,order_id.trim()); // pass the order_id
			pstmt.setString(2,order_line_num.trim()); // pass the order_line_num
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					sliding_scale_yn = checkForNull(resultSet.getString("sliding_scale_yn"),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
	 	} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return sliding_scale_yn;
 } // End of getSlidingScaleYN


public String getUomDesc(String uom_code) throws Exception 
{
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String UomDesc= "";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement("select PH_GET_UOM_DISPLAY(?,?,?) uom_desc from dual");
			pstmt.setString(1,login_facility_id.trim()); // pass the order_id
			pstmt.setString(2,uom_code.trim()); // pass the order_line_num
			pstmt.setString(3,language_id.trim()); // pass the p_language_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					UomDesc = checkForNull(resultSet.getString("uom_desc"),"")  ;
				}
			}	// if there is no record, then also it should return as 'N'
	 	} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return UomDesc;
 } // End of getUomDesc

 public String getSoftStopYN(String catalog_code) throws Exception 
{
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String softStopYN= "";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement("select soft_stop_yn  from or_order_catalog where order_catalog_code = ?");
			pstmt.setString(1,catalog_code.trim()); // pass the catalog_code
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					softStopYN = checkForNull(resultSet.getString("soft_stop_yn"),"")  ;
				}
			}	// if there is no record, then also it should return as 'N'
	 	} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
	 	} 
		finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return softStopYN;
 } // End of getUomDesc

 public ArrayList getPlaceOrderFrequency(String catalog_code,String schd_from,String durn_type,String category,String order_type,String def_freq) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		if(durn_type==null)
		{
			durn_type = "";
		}
		String sql = "";
		if(catalog_code == null || catalog_code.equals("null")) 
			catalog_code = "";

		ArrayList PlaceOrderFrequency = new ArrayList() ;
		int setcount = 0;
		try{
				connection	= getConnection();
				sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_FREQUENCY");
				if(!catalog_code.equals(""))
				{
					sql = sql.replace("##FILTER2##"," exists (SELECT 1 FROM OR_FREQ_CATALOG_SCOPE b,or_frequency_scope c WHERE b.freq_code = a.freq_code and b.freq_code = c.freq_code and c.freq_scope_yn = 'Y' AND  order_catalog_code =?) AND ");
				}
				else
				{
					if(!category.equals(""))
					{
						sql = sql.replace("##FILTER2##"," exists (select 1 from or_frequency_scope where freq_code = a.freq_Code and order_category='"+category+"' AND FREQ_SCOPE_YN = 'Y') and ");
					}
					else
					{
						sql = sql.replace("##FILTER2##"," ");
					}
				}
				
				if(schd_from.equalsIgnoreCase("header")&&!durn_type.equals(""))
				{
					sql = sql.replace("##FILTER##"," and interval_durn_type =? and freq_nature not in('O','P') ");
				}
				else
				{
					sql = sql.replace("##FILTER##"," ");
				}

				pstmt		= connection.prepareStatement(sql);

				pstmt.setString(++setcount, language_id);
				if(!catalog_code.equals(""))
				{
					pstmt.setString(++setcount, checkForNull(catalog_code.trim(),""));
				}
				if(schd_from.equalsIgnoreCase("header")&&!durn_type.equals(""))
				{
					pstmt.setString(++setcount, checkForNull(durn_type.trim(),""));
				}

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[3];
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"") + "~~" + checkForNull(resultSet.getString( "interval_durn_type" ),"") + "~~" + checkForNull(resultSet.getString( "interval_value" ),"") + "~~" + checkForNull(resultSet.getString( "repeat_value" ),"") +  "~~" + checkForNull(resultSet.getString( "repeat_durn_type" ),"") + "~~" + checkForNull(resultSet.getString( "scheduled_yn" ),"")+ "~~" + checkForNull(resultSet.getString( "freq_nature" ),"");
						record[1] = checkForNull(resultSet.getString( "freq_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "freq_code" ),"");
						PlaceOrderFrequency.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return PlaceOrderFrequency;
	}	 // End of the getPlaceOrderFrequency

	/*Added by Uma on 12/1/2009 for CRF IN03477*/
	public String decodeLocal(String objVal)
	{
				String locale = properties.getProperty("LOCALE");
				locale = (locale == null || locale.equals(""))?"en":locale;

				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
				String returntext="";
				if(objVal.trim().equalsIgnoreCase(""))
				{
					return	"";
				}

				//Duration Type
				if(objVal.trim().equalsIgnoreCase("M"))		
				{
					returntext=common_labels.getString("Common.Minute(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("H"))
				{
					returntext=common_labels.getString("Common.Hour(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("D"))
				{
					returntext=or_labels.getString("eOR.Day(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("W"))
				{
					returntext=or_labels.getString("eOR.Week(s).label");
					return	returntext;
					
				}
				if(objVal.trim().equalsIgnoreCase("L"))
				{
					returntext=or_labels.getString("eOR.Month(s).label");
					return	returntext;
					
				}
				if(objVal.trim().equalsIgnoreCase("Y"))
				{
					returntext=or_labels.getString("eOR.Year(s).label");
					return	returntext;
					
				}
				else
				return "";
	}
	/*CRF IN003477 Ends Here*/

	// To Populate the Duration in the Place Order Tab
	public ArrayList getPlaceOrderDuration() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderDuration = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_DURATION"));
				pstmt.setString(1, language_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_desc" ),"")  ;
						PlaceOrderDuration.add(record) ;
					}
				}
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return PlaceOrderDuration;
	}	 // End of the getPlaceOrderDuration





}//ENd of the class
