<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try
{
	// Dynamic Jsp to populate the List Boxes in Order Entry
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//String cat_desc="";
	String func_mode 		= request.getParameter( "func_mode" ) ;
	//String localeName=(String)session.getAttribute("LOCALE");
	ArrayList durationTypes = new ArrayList();
	ArrayList durationAppl = new ArrayList();
	ArrayList durationDesc = new ArrayList();	
	if ( func_mode == null || func_mode.equals( "" ) )
		return ;
	String or_bean_id 			= request.getParameter( "bean_id" ) ;
	String or_bean_name 		= request.getParameter( "bean_name" ) ;
	String patient_id = "";
	String encounter_id = "";

	if(or_bean_name.equalsIgnoreCase("ePH.DirectDispensingBean"))
	{
	     patient_id 		= request.getParameter( "patient_id" ) ;
		 encounter_id 		= request.getParameter( "encounter_id" ) ;
	}
	else
	{
		patient_id=(String)session.getValue("Schdpatient_id");
		encounter_id=(String)session.getValue("Schdencounter_id");
	}
	System.out.println("in schedule Frequency Validate 23 querystring"+request.getQueryString());
	//if(or_bean_name.equalsIgnoreCase("ePH.DirectDispensingBean"))
	//{
		or_bean_name = "eOR.OrderEntryBean";
		or_bean_id = "@orderentrybean"+patient_id+encounter_id;
	//}
	System.out.println("or_bean_name="+or_bean_name);
	System.out.println("or_bean_id="+or_bean_id);
	if ( or_bean_id == null || or_bean_id.equals( "" ) || or_bean_name == null || or_bean_name.equals(""))
		return ;

	OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;

	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;
   
	
	 if(func_mode.equalsIgnoreCase("REMOVE_SCHEDULE"))	// To remove the Schedule Frequency
	{
		
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		// get the bean
		ArrayList arr_hash_map	 = (ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value); // It will return hashmap
		System.out.println("arr_hash_map 61"+arr_hash_map);
		if(arr_hash_map!= null && arr_hash_map.size() >0)
		{
			// Removing the values from the Bean
			orderEntryRecordBean.removeOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value);
		}
	}
	else if(func_mode.equalsIgnoreCase("REMOVE_FREQUENCY"))	// To remove the Schedule Frequency
	{
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String durn_type		 = orbean.checkForNull(request.getParameter( "durn_type" ),"") ;
		String[] record 		 = null;
		out.println( "clearSchdDurationType('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		ArrayList PlaceOrderDuration=orbean.getPlaceOrderFrequency(catalog_code,"header",durn_type,"","","");
		
		for( int i=0 ; i< PlaceOrderDuration.size() ; i++ ) 
		{
				record 		= (String[])PlaceOrderDuration.get(i);
				out.println( "addSchdDurationTypeList('document.scheduleFreqencyAddModHeader',\""+record[0]+" \",\""+record[1]+"\",\""+row_value+"\") ; " ) ;
		}
		record				= null; // Nullifying the objects
		PlaceOrderDuration		= null; // Nullifying the objects
	}
	else if(func_mode.equalsIgnoreCase("SCHDDURATIONVALUES"))
	{
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		String hdr_duration_type		 = orbean.checkForNull(request.getParameter( "hdr_duration_type" ),"") ;
		//String[] record 		 = null;
		out.println( "clearSchdDurationList('document','document.scheduleFreqencyAddModHeader',\"" +row_value+"\") ; " ) ;
		//ArrayList PlaceOrderDuration=orbean.getPlaceOrderDuration();
	
		durationTypes.add("M");
		durationTypes.add("H");
		durationTypes.add("D");
		durationTypes.add("W");
		durationTypes.add("L");
		durationTypes.add("Y");
		
		for(int d=durationTypes.indexOf(hdr_duration_type);d<durationTypes.size();d++)
		{
			durationAppl.add(durationTypes.get(d));
			durationDesc.add(orbean.decodeLocal((String)durationTypes.get(d)));
		}
				
		for(int dt=0;dt<durationAppl.size();dt++) 
		{
				String durationcode = (String)durationAppl.get(dt);
				String durationdesc = (String)durationDesc.get(dt);
				out.println( "addSchdDurationList('document.scheduleFreqencyAddModHeader',\""+durationcode+" \",\""+durationdesc+"\",\""+row_value+"\") ; " ) ;
		}
	}
	/*else if(func_mode.equalsIgnoreCase("START_DATE"))	// To get the start date of the Schedule Frequency
	{
		System.out.println("116 here it enters");
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		
		String catalog_code		 = orbean.checkForNull(request.getParameter( "catalog_code" ),"") ;
		String row_value		 = orbean.checkForNull(request.getParameter( "row_value" ),"") ;
		System.out.println("116 here catalog_code"+catalog_code+"row_value"+row_value);
		// get the bean
		ArrayList arr_hash_map	 = (ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+row_value); // It will return hashmap
		System.out.println("arr_hash_map 61"+arr_hash_map);
		String start_date_param = "";
		if(arr_hash_map!= null && arr_hash_map.size() >0)
		{
			HashMap paramMap =(HashMap)arr_hash_map.get(0);
			start_date_param  =(String)paramMap.get("start_date_time");
			out.println( "changeStartDate(\""+start_date_param+" \") ; " ) ;
		}
	}*/
	/*Ends Here*/

	// set it back persistence  (When clinical comments is used ,it is used to set it)
	putObjectInBean(or_bean_id,orbean,request);
}catch(Exception e){
	System.out.println("@@@ Exception in OrderEntryValidate.jsp="+e);
	e.printStackTrace();
}
%>
