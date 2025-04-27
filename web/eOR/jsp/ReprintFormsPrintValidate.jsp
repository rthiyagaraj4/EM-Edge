<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");

    Hashtable allValues = (Hashtable)XMLobj.parseXMLString( request ) ;
    allValues = (Hashtable)allValues.get( "SEARCH" ) ;
	String report_type="";
	String login_facility_id="";
	if(allValues.containsKey("report_type"))
	{
		report_type = ((String)allValues.get("report_type"));
	}
	//System.out.println("===========ReprintFormsPrintValidate===================="+report_type);
	//HashMap map = new HashMap() ;
	Hashtable tabDataPrint 	= new Hashtable();
	//OnLinePrinting online_print = new OnLinePrinting(request,response);
	OnLinePrinting online_print = new OnLinePrinting();
	//System.out.println("Before On Line Printing" + online_print);
	// one parameter is to print the order form , another paramater is to print the consent forms
	if (!report_type.equalsIgnoreCase("L")) {
		//Hashtable tabDataPrint 	= new Hashtable();
		int tot_recs	= 0;
		for (int i = 0; i < Integer.parseInt(checkForNull((String)allValues.get("total_recs"),"0"));i++) {
			String checked = checkForNull((String)allValues.get("chk"+i));
			if (checked.equalsIgnoreCase("Y")) {

				tabDataPrint.put("ord_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
				tabDataPrint.put("order_id"+tot_recs,checkForNull((String)allValues.get("ord_id"+i)));
				tabDataPrint.put("order_category"+tot_recs,checkForNull((String)allValues.get("ord_cat"+i)));
				//System.out.println("order_category"+tot_recs+":="+checkForNull((String)allValues.get("ord_cat"+i)));
				tabDataPrint.put("patient_class"+tot_recs,checkForNull((String)allValues.get("pat_class"+i)));
				tabDataPrint.put("pat_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
				tabDataPrint.put("patient_id"+tot_recs,checkForNull((String)allValues.get("pat_id"+i)));
				tabDataPrint.put("encounter_id"+tot_recs,checkForNull((String)allValues.get("encounter_id"+i)));
				tabDataPrint.put("order_date_time"+tot_recs,checkForNull((String)allValues.get("order_date_time"+i)));
				tabDataPrint.put("catalog_code"+tot_recs,checkForNull((String)allValues.get("catalog_code"+i)));
				tabDataPrint.put("priority"+tot_recs,checkForNull((String)allValues.get("priority"+i)));
				tabDataPrint.put("ord_typ_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
				tabDataPrint.put("order_type_code"+tot_recs,checkForNull((String)allValues.get("order_type"+i)));
				tabDataPrint.put("ord_typ_desc"+tot_recs,checkForNull((String)allValues.get("order_type_desc"+i)));
				tabDataPrint.put("ord_pract_id"+tot_recs,checkForNull((String)allValues.get("ord_pract_id"+i)));
				tabDataPrint.put("order_status"+tot_recs,checkForNull((String)allValues.get("order_status"+i)));
				tabDataPrint.put("order_line_num"+tot_recs,checkForNull((String)allValues.get("order_line_num"+i)));
				tabDataPrint.put("cont_order_ind"+tot_recs,checkForNull((String)allValues.get("cont_order_ind"+i)));
				tabDataPrint.put("facility_id"+tot_recs,checkForNull((String)allValues.get("facility_id"+i)));
				tabDataPrint.put("location_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
				tabDataPrint.put("source_type"+tot_recs,checkForNull((String)allValues.get("location_type"+i)));
				tabDataPrint.put("location_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
				tabDataPrint.put("source_code"+tot_recs,checkForNull((String)allValues.get("location_code"+i)));
				tabDataPrint.put("report_srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));
				tabDataPrint.put("srl_no"+tot_recs,checkForNull((String)allValues.get("report_srl_no"+i)));

				tabDataPrint.put("chk"+tot_recs,checkForNull((String)allValues.get("chk"+i)));
				tot_recs++;
			}
		}
		tabDataPrint.put("facility_id",login_facility_id);
		tabDataPrint.put("source_type",checkForNull((String)allValues.get("source_type1")));
		tabDataPrint.put("total_recs",""+tot_recs);
		tabDataPrint.put("total_records",""+tot_recs);
		//System.out.println("REPRINT:tot_recs:"+tot_recs);
	}
	if (report_type.equalsIgnoreCase("C")) {
		online_print.callConsentFormOnlineRePrint(tabDataPrint,request,response);
		//online_print.callConsentFormOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("O")) {
		//allValues.put("order_entry","OrderEntry");
		tabDataPrint.put("order_entry","ExistingOrder");
		online_print.callOnlineRePrint(tabDataPrint,request,response);
		//online_print.callOnlinePrint(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("R")) {
		Hashtable repDataPrint 	= new Hashtable();
		for (int i = 0; i < Integer.parseInt(checkForNull((String)tabDataPrint.get("total_records"),"0"));i++) {
			repDataPrint.clear();
			repDataPrint.put("facility_id",checkForNull((String)tabDataPrint.get("facility_id"+i)));//IN070426
			repDataPrint.put("source_type",checkForNull((String)tabDataPrint.get("source_type1")));
			repDataPrint.put("ord_typ_code",checkForNull((String)tabDataPrint.get("ord_typ_code"+i)));
			repDataPrint.put("patient_class",checkForNull((String)tabDataPrint.get("patient_class"+i)));
			repDataPrint.put("priority",checkForNull((String)tabDataPrint.get("priority"+i)));
			repDataPrint.put("ord_id",checkForNull((String)tabDataPrint.get("ord_id"+i)));
			repDataPrint.put("location_code",checkForNull((String)tabDataPrint.get("location_code"+i)));
			repDataPrint.put("report_srl_no",checkForNull((String)tabDataPrint.get("report_srl_no"+i)));
			repDataPrint.put("location_type",checkForNull((String)tabDataPrint.get("location_type"+i)));//IN070426
			online_print.reprintResultEntryReport(repDataPrint,request,response); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		}
		//online_print.printResultEntryReport(allValues); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} else if (report_type.equalsIgnoreCase("L")) {
		//Hashtable tabDataPrint 	= new Hashtable();

		tabDataPrint.put( "total_recs" ,"1");
		tabDataPrint.put("facility_id",login_facility_id);
		tabDataPrint.put("collection_list","");
		tabDataPrint.put("printLocationType",checkForNull((String)allValues.get("source_type1")));
		tabDataPrint.put("printLocation",checkForNull((String)allValues.get("location_code")));

		tabDataPrint.put("date_from",checkForNull((String)allValues.get("date_from")));
		tabDataPrint.put("date_to",checkForNull((String)allValues.get("date_to")));
		tabDataPrint.put("priority","A");
		tabDataPrint.put("location_type",checkForNull((String)allValues.get("location_type")));
		tabDataPrint.put("locn",checkForNull((String)allValues.get("locn2")));
		tabDataPrint.put("locn1",checkForNull((String)allValues.get("locn1")));
		tabDataPrint.put("order_type",checkForNull((String)allValues.get("order_type")));
		tabDataPrint.put("order_type1",checkForNull((String)allValues.get("order_type")));
		tabDataPrint.put("option","R");
		tabDataPrint.put("select_specific_order","A");
		tabDataPrint.put("patientId",checkForNull((String)allValues.get("patient_id")));
		tabDataPrint.put("order_id",checkForNull((String)allValues.get("order_id")));
		tabDataPrint.put("encounter_id",checkForNull((String)allValues.get("encntr_id")));
		online_print.callSpecimenCollectOnLinePrint(tabDataPrint,request,response);
	}else if (report_type.equalsIgnoreCase("X"))
	{
		online_print.callReferralFormOnlinePrint(tabDataPrint,request,response);
	}
	else if (report_type.equalsIgnoreCase("S"))
	{
		online_print.callRefusalFormOnlinePrint(tabDataPrint,request,response);
	}
	//System.out.println("==============================="+map);
   
%>
<%!

String checkForNull( String inputString, String defaultValue ) {
	return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
}
String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
}
%>
