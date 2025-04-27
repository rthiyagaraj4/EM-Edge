<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%!
private String decodeLocal(String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}

	//Duration Type
	if(objVal.trim().equalsIgnoreCase("N"))		
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		return	returntext;
	}

	if(objVal.trim().equalsIgnoreCase("C"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Closest.label","am_labels");
		return	returntext;
	}

	if(objVal.trim().equalsIgnoreCase("P"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		return	returntext;
	}
	//start_time_round_p
	if(objVal.trim().equalsIgnoreCase("TM"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.10thminute.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("FM"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.5thminute.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("QH"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QuarterHour.label","or_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("H"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Hourly.label","am_labels");
		return	returntext;
		
	}

	if(objVal.trim().equalsIgnoreCase("M"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels");
		return	returntext;
	}
	else
	return "";
}

private int isAfterTime(String fromObj,String toObj)
{
	int retVal = 0;
	fromObj = fromObj.trim();
	toObj = toObj.trim();

	if(fromObj.indexOf(":") != -1 && toObj.indexOf(":") != -1 )
	{
		String tempobj1[] = fromObj.split(":");
		String tempobj2[] = toObj.split(":");
		int temp1 = Integer.parseInt(tempobj1[0]);
		int temp2 = Integer.parseInt(tempobj2[0]);
		int temp3 = Integer.parseInt(tempobj1[1]);
		int temp4 = Integer.parseInt(tempobj2[1]);	

		if(temp1 > temp2)
		{
			retVal = -1;		
		}
		else if(temp1 < temp2)
		{
			retVal = 1;
		}
		else if(temp1 == temp2)
		{
			if(temp3 > temp4 )
			{
				retVal = -1;		
			}
			else if(temp3 < temp4)
			{
				retVal = 1;
			}
			else
				retVal = 0;
		}
	}
	return retVal;
}

%>
<html>
<head>
<script>

function numDotOnly()
{
	 if(((event.keyCode>=48)&&(event.keyCode<=57))||(event.keyCode==46))
	 {
		event.keyCode=event.keyCode;
	 }
	 
	 else
	 {
	   event.keyCode=0;
	  
	 }
}

</script>


<%
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language='javascript' src='../../eOR/js/ScheduleFrquency.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='window.parent.chkDefIntl()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="scheduleFreqencyAddMod" id="scheduleFreqencyAddMod" action="" method="post" >

<%
/* Mandatory checks start */
	String bean_id	= "OrScheduleFreq" ;
	String bean_name= "eOR.ScheduleFrequencyCompBean";

	OrderEntryBean beanEntry				= (OrderEntryBean)getBeanObject( "orderentrybean", "eOR.OrderEntryBean", request ) ;
	

	String bean_id1= request.getParameter("bean_id");
	String bean_name1= request.getParameter("bean_name");
	String catalog_code= request.getParameter("catalog_code");
	String mode		=  "1" ;
	String uom_code		=  "" ;
	String strDose = "";
	String Interval_value			= "";
	
	boolean isSchdApplicable = true;
	HashMap schdMap = null;


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	String qtyDisabled		    =  ""; //Disable in modify mode

/* Mandatory checks end */

	/* Initialize Function specific start */	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		beanEntry				= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;
		beanEntry.setLanguageId(localeName);
		 qtyDisabled		=  "disabled";
	}

	ScheduleFrequencyCompBean bean = (ScheduleFrequencyCompBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

	/******Caller Bean name and id*******/
	String bean_id_P			= request.getParameter("bean_id");
	String bean_name_P			= request.getParameter("bean_name");	
	
	/**************/
try
{

	/*Parameters Passed*/
	String freq_code			=bean.checkForNull( request.getParameter("freq_code"));
	String freq_code_temp			=bean.checkForNull( request.getParameter("freq_code"));
	String facility_id			=bean.checkForNull( request.getParameter("facility_id"));
	String durationType_P		= bean.checkForNull(request.getParameter("interval_durn_type"));
	String pr_duration		= bean.checkForNull(request.getParameter("pr_duration"));
	
	if(pr_duration == null || pr_duration.equals("") || pr_duration.equals("null"))
		pr_duration = "1";
	
	String pr_duration_type		= bean.checkForNull(request.getParameter("pr_duration_type")); 	
	/*Added by Uma on 11/26/2009 for IN003477*/
	String schd_from		= bean.checkForNull(request.getParameter("schd_from"));
	
	if(schd_from.equalsIgnoreCase("header"))
	{
		 durationType_P		= bean.checkForNull(request.getParameter("hdr_interval_durn_type"));
		 pr_duration_type	= bean.checkForNull(request.getParameter("hdr_pr_duration_type")); 	
		 freq_code			= bean.checkForNull( request.getParameter("hdr_freq_code"));
		  pr_duration			=request.getParameter("hdr_duration_value")==null?"1":request.getParameter("hdr_duration_value");
		 if(pr_duration == null || pr_duration.equals(""))
			pr_duration = "1";
		 
	}
	/*Ends Here for IN003477*/

	String code					= bean.checkForNull(request.getParameter("code"));
	String row_value			=bean.checkForNull( request.getParameter("row_value"));
	String module_id			= bean.checkForNull(request.getParameter("module_id"));
	String order_category		= bean.checkForNull(request.getParameter("order_category"));
	String visit_adm_date		= bean.checkForNull(request.getParameter("visit_adm_date")); 	
	String future_order_date	= bean.checkForNull(request.getParameter("future_order_date"));	
 	String past_order_date		= bean.checkForNull(request.getParameter("past_order_date"));
	
	int	   indxTime				= 0;
    String start_day_param		= "";
    String start_day_param_request= "";
    String start_time_param		= "";  
    String start_time_param_request	= "";  

	//Taking values for start day and time
	String start_time_day_param	= bean.checkForNull(request.getParameter("start_time_day_param"));
		
	if(start_time_day_param!=null && !start_time_day_param.trim().equals(""))
	{
	    indxTime				= start_time_day_param.indexOf(" ");
	    start_day_param			= start_time_day_param.substring(0,indxTime);
	    start_day_param_request	= start_time_day_param.substring(0,indxTime);
	    start_time_param		= start_time_day_param.substring(indxTime+1);			
	    start_time_param_request= start_time_day_param.substring(indxTime+1);			
	}
	//For Ph
	String max_qty				= bean.checkForNull(request.getParameter("max_qty"));
	String chk_max				= bean.checkForNull(request.getParameter("chk_max"));
	String unit_qty				= bean.checkForNull(request.getParameter("unit_qty"));
	String chk_unit				= bean.checkForNull(request.getParameter("chk_unit"));
	String split_dose_yn		= bean.checkForNull(request.getParameter("split_dose_yn"));
	String split_qty			= bean.checkForNull(request.getParameter("split_qty"));
	String uom_desc				= bean.checkForNull(request.getParameter("uom_desc"));
   	String fract_value_yn				= bean.checkForNull(request.getParameter("fract_value_yn"));
   	String sliding_scale_yn				= bean.checkForNull(request.getParameter("sliding_scale_yn"));
	
	 mode						= bean.checkForNull(request.getParameter( "mode" ),"1");

	/******Today date and time form database or bean*********/
	String start_day_assign     = "";
	String start_time_assign	= "";

	/*******Fields to Diable the diable / hide and show depending on module and the mode passed*******/
	String freqLegendStyle		= "";
	String daysDisabled         =  ""; //Show when duration type is Week
	String timeDisabled         =  ""; //Disable in modify mode	
	String StartTimeEnabled		=  ""; // Disable in modify mode
	String startTimeStyle	    =  ""; // To show table for start time --Not shown in modify mode
	String startTimeDayStyle   	= "display:none"; //Show only in case where admin_day_time is D;
	String daysTabStyle			 = ""; //To Show the DAYS TABLE
	String qtyTabStyle			 = "display:none" ;	//To Show the  QTY TABLE


	/********GET TODAYS DAY,TIME AND DAY NO IN SM_DAY_OF_WEEK ************/
	HashMap today_date_time	  = bean.getDay();
	String  today			  = (String)today_date_time.get("day_no");
	String  todayTime		  = (String)today_date_time.get("day_time");
	String  todayDate		  = (String)today_date_time.get("day_date");
      todayDate=com.ehis.util.DateUtils.convertDate(todayDate,"DMY","en",localeName);

	//Values passed either form database or by bean
	String dt					 = ""; //time
	String dq					 = "";//qty
	//int repeat					 = 0;

	// Cahnges Made by Sridhar Reddy for SRR20056-CRF-0274
	ArrayList<Integer> durationList = new ArrayList<Integer>();
	ArrayList day_list	= new ArrayList();
	ArrayList day_names	= new ArrayList();
	ArrayList time_list	= new ArrayList();
	ArrayList dose_list	= new ArrayList();
	ArrayList temp_list	= new ArrayList();
	ArrayList final_list	= new ArrayList();
	HashMap hdr_data =  new 	HashMap();
	String fract_allow_yn	 = "";
	// End SRR20056-CRF-0274

	if(mode!=null && mode.trim().equals("2"))
	{
		 daysDisabled       =  "disabled";
		 timeDisabled       =  "disabled";
		 qtyDisabled		=  "disabled";
		 startTimeStyle		=  "display:none";
		 StartTimeEnabled   =  "disabled";
	}

	if(module_id!=null && module_id.trim().equalsIgnoreCase("PH"))
	{
		startTimeStyle		=  "display:none";
		dq					=	split_qty ;
		if(split_dose_yn!=null && split_dose_yn.trim().equalsIgnoreCase("N"))
		{
			qtyDisabled		=  "disabled";
		}
	}

	if(order_category!=null && order_category.trim().equalsIgnoreCase("PH")&&(mode!=null) && mode.trim().equals("2"))
	{
		sliding_scale_yn=(String)bean.getSlidingScaleYN(code,row_value);
	}

	if(!uom_desc.equals(""))
	{
		uom_desc = (String)bean.getUomDesc(uom_desc);
	}	
	/*********BEAN OF CALLER FUNCTION IS INSTANTIATED AND VALUES FOR FREQ LOADED ****/
	
	Object beanCaller			 =  getBeanObject(bean_id_P,bean_name_P,request);
	SceduleFreqeuncyInterface rec= (SceduleFreqeuncyInterface)beanCaller ;
	ArrayList str = new ArrayList();

	if(schd_from.equalsIgnoreCase("header"))
	{
		str = bean.load(freq_code,facility_id);
	}
	else
	{
		str =rec.getScheduleFrequencyStr(code,row_value);
	}

	String freqLegend			= "";	
    StringBuffer timeLegend=new StringBuffer();
	//String admin_day_or_time	= "";

	/***To Show time Table ********/

	//StringBuffer hrsHtml= new  StringBuffer();
	/***To Show Qtye Table ********/
	//StringBuffer qtyHtml=new StringBuffer();
    StringBuffer daysHtml=new StringBuffer();
	//String daysHtmlUpdate		= "";
	String chkDaysUpdate		= "|"; //To Concanete the Days Checked values passed from bean or DataCase and used by javascript on laod to chech the  chkeck boxes	
	//String daysSelected			= "";
	//Values retrieved form am_frequency depending on freq code passed
	String freqLegend_P			 = "";
	String repeatValue_P	     = "0";
	String start_time_round_p	 = "";
	String start_time_assign_p	 = "";

	//int counter					 = 0;
	if(module_id!=null && module_id.trim().equalsIgnoreCase("PH") ||( module_id.trim().equalsIgnoreCase("OR") &&  order_category!=null && order_category.trim().equals("PH")))
		qtyTabStyle = "";


	/**Queried from dataBase and build HTML TO shows days check Box onstructed**/
	HashMap	  days					= (HashMap)bean.getComboOptions("day");
	ArrayList daysArray				= (ArrayList)days.get("value");
	ArrayList daysInsertArray		= (ArrayList)days.get("Description");

	Iterator  iterateDays			= daysArray.iterator() ;
	Iterator  iteratedaysInsert		= daysInsertArray.iterator() ;
	daysHtml.append("");

	int i =0;

	while(iterateDays.hasNext() && iteratedaysInsert.hasNext() )
	{
		i++;
		//String day		   =	(String)
		iterateDays.next() ;
		//String daySMInsert = (String)
		iteratedaysInsert.next() ;
	}
	//To get no of Repeats,start time assign/round and freq Legend ....for a particulay freq_code
	 ArrayList  freqValues	= null ;

	 freqValues				= bean.getFreqValues(freq_code);


	 if(freqValues.size()>0)
	{
		 String durn_desc			= (String)freqValues.get(4);
		 String for_text			= (String)freqValues.get(5);
		 Interval_value			= (String)freqValues.get(6);
		 String durn_desc_type			= (String)freqValues.get(7);
		 durationType_P			= (String)freqValues.get(1)==null?"":(String)freqValues.get(1);
		
		 repeatValue_P			= (String)freqValues.get(0)==null?"0":(String)freqValues.get(0);	 
		
		freqLegend_P			=  repeatValue_P+" "+(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RepeatsPer.label","am_labels")+durn_desc+" "+for_text+" "+(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Every.label","common_labels")+" "+Interval_value+" "+durn_desc_type;
		
		 freqLegend				    = freqLegend_P;
		 
		 start_time_round_p	= (String)freqValues.get(2);
		 start_time_assign_p	= (String)freqValues.get(3);
	}
   
   	 //In case of hours and Minutes take only minutes show only mintues part
	if(durationType_P!=null && (durationType_P.trim().equalsIgnoreCase("H") || durationType_P.trim().equalsIgnoreCase("M")) )
	{
		todayTime = todayTime.trim() ;
	}
%>
	<input type="hidden" name="repeat" id="repeat"	value="<%=repeatValue_P%>">
<%
	 ArrayList rs          = null ;
	 ArrayList dateList = null;
	 ArrayList dayList = null;
	 HashMap dataMap = null;
	 if(str == null || str.size() <= 0 )
	 rs = bean.load(freq_code,facility_id);	//Get the Values for TIME AND DAYS feilds form am_frequncy if bean does not pass the values
	 else
	 rs = str ;	 //VALUES RETRIEVED FORM CALLING  FUNCTION	--BEAN

	// int k= 0;
	 String TimeRoundedto=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TimeRoundedto.label","or_labels")+" ";
  
	if(rs != null && rs.size() > 0)
	{// records fetched  --from dataBase/Or during subsequent modification

		hdr_data = (HashMap)rs.get(0);
		day_list	= (ArrayList)rs.get(1);
		day_names	= (ArrayList)rs.get(2);
		time_list	= (ArrayList)rs.get(3);
		dose_list	= (ArrayList)rs.get(4);
		if(dose_list.size() > 0)
		{	 
			for(int k=0;k<Integer.parseInt(repeatValue_P);k++)
			{		
				strDose = (String)dose_list.get(k);
				
				if(strDose.equals(""))
					dose_list.add(k,split_qty);
			}	
		 }
	start_day_assign  = bean.checkForNull((String)hdr_data.get("start_date_time"));
	hdr_data.put("durationType",durationType_P);
/*	hdr_data.put();
	hdr_data.put();*/

	if(start_day_assign.equals(""))
	{
		hdr_data.put("start_date_time",start_day_param);
		start_day_assign = start_day_param;
	}

	//This is just to remove the last character "|" concanted
	chkDaysUpdate = chkDaysUpdate.substring(0,chkDaysUpdate.length()-1);
	timeLegend.append(TimeRoundedto+decodeLocal(start_time_assign_p,pageContext)+ " "+decodeLocal(start_time_round_p,pageContext));
	
  }
  else
  {//NO RECORDS FETCHED	FORM DATABASE -- FOR FIRST TIME CLIENT VISIT

		if(durationType_P!=null && !durationType_P.equalsIgnoreCase("W"))
		{
			daysTabStyle		 = "display:none";
			freqLegendStyle		 ="";
			startTimeDayStyle = "";
		}
		else
		{
			startTimeDayStyle = "";
		}	   
		timeLegend.append(TimeRoundedto+decodeLocal(start_time_assign_p,pageContext)+ " "+decodeLocal(start_time_round_p,pageContext));
	
		/**Builds Time's Html***/
		for(int m= 1; m <= Integer.parseInt(repeatValue_P); m++)
		{
			if(bean_name1.equals("eOR.OrderEntryBean"))
			{
				dt="";
				if(beanEntry.getTempvalue("time"+m+catalog_code+freq_code)!=null)
					dt=beanEntry.getTempvalue("time"+m+catalog_code+freq_code);
			}	         
		}
  }	//End of Else

if(fract_value_yn.equals("Y"))
{
	fract_allow_yn = "return allowValidFreqNumber(this,event,8,4);";
}
else
{
	fract_allow_yn = "return allowValidFreqNumber(this,event,4,0);";
}

if(durationType_P.equals("W"))
{
	durationList.clear(); 
	for(int z = 1;z<=7;z++) 
		durationList.add(z);
}
else if(durationType_P.equals("L"))
{
	durationList.clear(); 
	for(int y = 1;y<=30;y++) 
		durationList.add(y);
}

hdr_data = (HashMap)rs.get(0);
day_list	= (ArrayList)rs.get(1);
day_names	= (ArrayList)rs.get(2);
time_list	= (ArrayList)rs.get(3);
dose_list	= (ArrayList)rs.get(4);

if((schd_from.equalsIgnoreCase("header"))&&(freq_code_temp.equals(freq_code)))
{
	ArrayList scdstr = rec.getScheduleFrequencyStr(code,row_value);
    if(scdstr!=null)
	{
		temp_list	= (ArrayList)scdstr.get(4);
		for(int dl=0;dl<dose_list.size();dl++)
		{
			dose_list.get(dl);
			
			if((temp_list.size())>(dl))
			{ 
				final_list.add(dl,temp_list.get(dl));			
			}
			else
			{
				final_list.add(dl,dose_list.get(dl));
			}
		}
		dose_list = final_list;
	}
}

 if(uom_desc.equals(""))
{
	uom_code = hdr_data.get("uom_code") == null ? "":(String)hdr_data.get("uom_code");		
	if(!uom_code.equals(""))
	{
		uom_desc = (String)bean.getUomDesc(uom_code);
	}
}

if(start_day_param.equals(""))
	start_day_param = start_day_param;

if(start_time_param.equals(""))
	start_time_param = start_time_param;

if(pr_duration == null || pr_duration.equals(""))
{
	pr_duration = "1";	
}

HashMap paramMap = new HashMap();
paramMap.put("start_day_param",start_day_param);
paramMap.put("duration",pr_duration);
paramMap.put("duration_type",pr_duration_type);
paramMap.put("durationType",durationType_P);
paramMap.put("repeat",repeatValue_P);
paramMap.put("Interval_value",Interval_value.equals("")?"1":Interval_value);
paramMap.put("start_time_param",start_time_param);
paramMap.put("start_time_param",start_time_param);
if(day_list.size()==0)
{
	Connection con = null;
	try 
	{  
		con	= ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		
		String sqlQuery = "SELECT a.admin_day_or_time, a.admin_day,TO_CHAR (admin_time, 'HH24:MI') admin_time     FROM am_frequency_admin_day_time a WHERE a.freq_code = ? AND admin_facility_id =nvl((select  admin_facility_id from am_frequency_admin_day_time where   freq_code = a.freq_code and admin_facility_id = ? and rownum=1),'*A') ORDER BY to_number(ADMIN_DAY), admin_time ";
		if(time_list.size()==0){		
		pstmt =	con.prepareStatement(sqlQuery);
		pstmt.setString(1,freq_code);
		pstmt.setString(2,facility_id);
		rs1 = pstmt.executeQuery();
	
		while(rs1.next())
		{
			time_list.add(rs1.getString("admin_time"));
			day_list.add("1");
			durationList.add(1);
			dose_list.add(1);
		
		}

		if(rs1 != null)rs1.close();
		if(pstmt != null)pstmt.close();
	}
 }
 catch(Exception ex)
 {
	ex.printStackTrace(); 
 }
 finally
 {
	if(con!=null)
			ConnectionManager.returnConnection(con,request);
 }

}
ArrayList paramList = new ArrayList();
paramList.add(paramMap);
paramList.add(day_list);		

if(day_list.size() > 0)
{
	HashMap dates_map = (HashMap)beanEntry.getScheduleDates(paramMap,day_list,time_list);
	if(dates_map!= null && dates_map.size() > 0)
	{
		rec.setScheduleDates(dates_map);
		schdMap =(HashMap) rec.getScheduleDates();
	}
}

if(sliding_scale_yn.equalsIgnoreCase("Y")) 
{
	uom_desc = "";

}
%>
<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" class="grid">
	<tr>
		<td colspan="7" class="gridHeader"  style="<%=freqLegendStyle%>">
			<%=freqLegend%> - (<%=timeLegend.toString()%>)
		</td>			
	</tr>
	<tr>
		<td colspan="2" class="gridData"  style="<%=freqLegendStyle%>">
			<B><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></B>
		</td>
		<%
		/*String freqTiming = "";
		String currDate=com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);	
		if(time_list!=null && time_list.size()>0 )		
			freqTiming=(String)time_list.get(0);
		String freq_time_calc=currDate+" "+freqTiming;
		String freq_date="";
		ArrayList dateList1=new ArrayList();
	
		if(schdMap!= null && schdMap.size() > 0)
		{			
			for(int x=1; x<=Integer.parseInt(repeatValue_P); x++)
			{			
				dataMap = (HashMap)schdMap.get(x);
				dateList = (ArrayList)dataMap.get("DATES");
				if(dateList!=null && dateList.size() > 0)
				{
					for(int y=0; y < dateList.size(); y++)	
					{
						dateList1.add(dateList.get(y));
					}
				}
			}
		}		
		Object dateArr[]=dateList1.toArray();
		String minSchdate="";
		if(dateArr.length>0)
		{
		 minSchdate=(String)dateArr[0];
			for(int z=0; z < dateArr.length; z++)	
			{	if(!minSchdate.equalsIgnoreCase((String)dateArr[z]))
				{
					if(com.ehis.util.DateUtils.isAfter(minSchdate,(String)dateArr[z],"DMY", localeName))
						minSchdate=(String)dateArr[z];
				}
			}
		}
	
		if(!(minSchdate.equals("") && start_day_param_request.equals("")))
		{
			freq_date=minSchdate;
			if(com.ehis.util.DateUtils.isAfter(currDate,start_day_param_request,"DMY", localeName)  && com.ehis.util.DateUtils.isAfter(freq_date,start_day_param_request,"DMY", localeName))
			{
				if(!freq_date.equalsIgnoreCase(start_day_param_request))
				{
					start_day_param=freq_date;
					start_time_param="00:00";
				}
			}
		}*/			 
		
		%>
		<td colspan="5" class="gridData"  style="<%=freqLegendStyle%>">
			<%=start_day_param%>&nbsp;<%=start_time_param%>
		</td>			
	</tr>
	<tr>	
<%
		if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
		{
%>
			<td width="5%" class="gridHeader"  style="<%=freqLegendStyle%>">&nbsp;&nbsp;</td>
<%
		}
%>
		<td width="5%" class="gridHeader"  style="<%=freqLegendStyle%>"><fmt:message key="eOR.Repeat.label" bundle="${or_labels}"/></td>
		<td width="5%" class="gridHeader"  style="<%=freqLegendStyle%>"><%
		if(!durationType_P.equals("D"))
		{
%>
			<fmt:message key="Common.day.label" bundle="${common_labels}"/>
<%
		}
%>
		</td>
		<td width="10%" class="gridHeader"  style="<%=freqLegendStyle%>"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td width="15%" class="gridHeader"  style="<%=freqLegendStyle%>"><fmt:message key="eOR.UOM.label" bundle="${or_labels}"/></td>
		<td width="10%" class="gridHeader"  style="<%=freqLegendStyle%>"><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>	
		<td width="55%" class="gridHeader"  style="<%=freqLegendStyle%>"><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></td>	
	</tr>
<%
	if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
	{
%>
	<tr>
		<td width="5%" class=""  style="<%=freqLegendStyle%>">&nbsp;&nbsp;</td>
		<td>
			<input type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PasteDetails.label","or_labels")%>" onclick="pasteSchdDetails()">
		</td>
	</tr>
	<tr>
<%
		if(mode.equalsIgnoreCase("1"))
		{
		%>
			<td width="5%" class=""  style="<%=freqLegendStyle%>"><b><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></b></td>
		<%
		}
		%>
	</tr>
	<%	
	}	
	//ArrayList dateList = null;
	//ArrayList dayList = null;
	//HashMap dataMap = null;
	if(schdMap!= null && schdMap.size() > 0)
	{			
		for(int x=1; x<=Integer.parseInt(repeatValue_P); x++)
		{			
			dataMap = (HashMap)schdMap.get(x);
			dateList = (ArrayList)dataMap.get("DATES");
			dayList = (ArrayList)dataMap.get("DAYS");			
%>
			<tr>
<%
			if(mode.equalsIgnoreCase("1") && !(sliding_scale_yn.equalsIgnoreCase("Y")))
			{
%>
				<td width="5%" class="gridData"><input type="checkbox" name="chk<%=x%>" id="chk<%=x%>"></td>
<%
			}
%>
			<td width="5%" class="gridData"><label name="Repeat<%=x%>" ><%=x%><input type="hidden" name="repeat<%=x%>" id="repeat<%=x%>" value="<%=x%>"></td>
			<td width="5%" class="gridData">
<%
			if(durationType_P.equals("D"))
			{
%>
				<input type="hidden" name="admin_day<%=x%>" id="admin_day<%=x%>" value="0">
<%
			}
			else 
			{
%>
				<select name="admin_day<%=x%>" id="admin_day<%=x%>" <%=daysDisabled%> onchange = "changeScheduleDates(this,'<%=x%>');">
<%
				for(int dayNum : durationList) 
				{
%>
					<option value="<%=dayNum%>" 
<%
					if(Integer.parseInt(((String)day_list.get(x-1))) == dayNum )
					{
%>
					selected
<%
					}
%>					><%=dayNum%></option>		
<%
				}
%>
				</select>
<%
			}
%>
			</td>
			<%
			if(sliding_scale_yn.equalsIgnoreCase("Y")) 
			{
				String dose_qty_list = (String)dose_list.get(x-1).toString();
				if(!(dose_qty_list.equals("")))
				{
				   if(dose_qty_list.indexOf(".")== 0)
					dose_qty_list = "0"+dose_qty_list;
				}
%>
				<td width="10%" class="gridData">Sliding Scale
					<input type="hidden" name="qty<%=x%>" id="qty<%=x%>" value='<%=dose_qty_list%>'>
			    </td>		
<%	
			}
			else
			{
				String dose_qty_list = (String)dose_list.get(x-1).toString();
				if(!(dose_qty_list.equals("")))
				{
				   if(dose_qty_list.indexOf(".")== 0)
					dose_qty_list = "0"+dose_qty_list;
				}
%>	 <td width="10%" class="gridData"><input type="text" size="8" maxlength='7' class="NUMBER" onBlur='parent.OrIsValidDecimal(this);parent.chkQty(this,"<%=fract_value_yn%>");formatNumber(this)' onKeyPress='<%=fract_allow_yn%>' name="qty<%=x%>" value='<%=dose_qty_list%>'  <%=qtyDisabled%> onPaste='return checkNumbers(this);'></td><!---OnPaste is inserted in the field,which is used to avoid the values to be pasted,//Issue No:27384 by Maheshwaran.K as on 21/06/2011-->
<%				
			}
%>
			<td width="15%" class="gridData"><label name="uom<%=x%>"><%=uom_desc%></td>
			<td width="10%" class="gridData"><input type="text" size="5" <%=timeDisabled%> onBlur="parent.timeChk(this);parent.defaultStartTime();changeScheduleDates(admin_day<%=x%>,'<%=x%>');
<%
			if(bean_name1.equals("eOR.OrderEntryBean"))
			{
%>
				storetime('<%=x%>',this,'<%=catalog_code%>','<%=freq_code%>');<%}%>"  maxlength="5" name="time<%=x%>"  value="<%=(String)time_list.get(x-1)%>"></td>
				<td width="55%" class="gridData" id="dispalySchedule<%=x%>">
<%
						
					if(dateList != null && dateList.size() > 5)
					{
%>
						<a href="#" onclick="showScheduleDates('<%=bean_id_P%>','<%=bean_name_P%>','<%=x%>')">Schedule</a>
			
<%	
					}
					else
					{ 
						String dateSytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #000000;font-weight:normal;	text-align:left;	padding-left:10px;padding-right:10px;vertical-align:middle;'";
						String daySytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #990000;font-weight:bold;	text-align:center;padding-left:10px;padding-right:10px;vertical-align:middle;'";
						StringBuffer dispalySchd = new StringBuffer();
						StringBuffer weekName = new StringBuffer();

						for(int n =0;n<dateList.size();n++)
						{ 
							dispalySchd.append("<td "+dateSytle+">"+dateList.get(n)+"</td>");	
							weekName.append("<td "+daySytle+">"+dayList.get(n)+"</td>");					
						} 
%>
						<table class='gridComponentHolder'>
						<tr>
							<%=dispalySchd.toString()%>
						</tr>
						<tr>
							<%=weekName.toString()%>
						</tr>
						</table>
<%		
					}						
%>
				</td>	
			</tr>	
			
<%	
	
		}	
	}
	else
	{
	
		isSchdApplicable = false;
%>

	<tr><td colspan="5">
		<fmt:message key="eOR.NOSCHEDULE.label" bundle="${or_labels}"/>
	</td></tr>
<%
	}

%>

</table>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>"><!-- Added by Ambiga.M on 2/4/2010 for 18855 -->
<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
<input type="hidden" name="durationType" id="durationType"	value="<%=durationType_P%>">
<input type="hidden" name="chkDaysUpdate" id="chkDaysUpdate"	value="<%=chkDaysUpdate%>">
<input type="hidden" name="start_time_round_p" id="start_time_round_p" value="<%=start_time_round_p%>">
<input type="hidden" name="start_time_assign_p" id="start_time_assign_p" value="<%=start_time_assign_p%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="code" id="code" value="<%=request.getParameter("code")%>">
<INPUT TYPE="hidden" name="bean_id_caller" id="bean_id_caller" value="<%=bean_id_P%>">
<INPUT TYPE="hidden" name="bean_name_caller" id="bean_name_caller" value="<%=bean_name_P%>">
<INPUT TYPE="hidden" name="freq_code" id="freq_code" value="<%=freq_code%>">
<INPUT TYPE="hidden" name="freqLegend" id="freqLegend" value="<%=freqLegend%>">
<INPUT TYPE="hidden" name="Interval_value" id="Interval_value" value="<%=Interval_value%>">
<!-- For PH Only -->
<INPUT TYPE="hidden" name="max_qty" id="max_qty" value="<%=max_qty%>">
<INPUT TYPE="hidden" name="chk_max" id="chk_max" value="<%=chk_max%>">
<INPUT TYPE="hidden" name="unit_qty" id="unit_qty" value="<%=unit_qty%>">
<INPUT TYPE="hidden" name="chk_unit" id="chk_unit" value="<%=chk_unit%>">
<INPUT TYPE="hidden" name="split_dose_yn" id="split_dose_yn" value="<%=split_dose_yn%>">
<INPUT TYPE="hidden" name="split_qty" id="split_qty" value="<%=split_qty%>">
 <!-- For Order Entry Only -->
<INPUT TYPE="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
<INPUT TYPE="hidden" name="future_order_date" id="future_order_date" value="<%=future_order_date%>">
<INPUT TYPE="hidden" name="past_order_date" id="past_order_date" value="<%=past_order_date%>">
<!-- Start Time Param passed by order entry function -->
<INPUT TYPE="hidden" name="start_day_param" id="start_day_param" value="<%=start_day_param%>">
<INPUT TYPE="hidden" name="start_time_param" id="start_time_param" value="<%=start_time_param%>">
<INPUT TYPE="hidden" name="start_day_param_request" id="start_day_param_request" value="<%=start_day_param_request%>">
<INPUT TYPE="hidden" name="start_time_param_request" id="start_time_param_request" value="<%=start_time_param_request%>">
<INPUT TYPE="hidden" name="today" id="today" value="<%=today%>">
<INPUT TYPE="hidden" name="todayTime" id="todayTime" value="<%=todayTime%>">
<INPUT TYPE="hidden" name="todayDate" id="todayDate" value="<%=todayDate%>">
<INPUT TYPE="hidden" name="module_id" id="module_id" value="<%=module_id%>">
<INPUT TYPE="hidden" name="row_value" id="row_value" value="<%=request.getParameter("row_value")%>">
<INPUT TYPE="hidden" name="loadFlag" id="loadFlag"  value="YES">
<INPUT TYPE="hidden" name="dummmyDate" id="dummmyDate"  value="">
<input type="hidden" name="start_day_assign" id="start_day_assign" value="<%=start_day_param%>">
<input type="hidden" name="start_time_assign" id="start_time_assign" value="<%=start_time_assign%>">
<input type="hidden" name="pr_duration" id="pr_duration" value="<%=pr_duration%>">
<input type="hidden" name="pr_duration_type" id="pr_duration_type" value="<%=pr_duration_type%>">
<input type="hidden" name="isSchdApplicable" id="isSchdApplicable" value="<%=isSchdApplicable%>">
<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
<%
if(bean_name1.equals("eOR.OrderEntryBean"))
{
%>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">
<%
}
}
catch(Exception e)
{
	 e.printStackTrace();
}
%>
</form>
<%
 	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>





