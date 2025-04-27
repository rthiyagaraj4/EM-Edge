
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
?				  100        ?				?				?					created
17/03/2015	  IN054500		Vijayakumar K										Specimen result report is not printing 
																				for Order Tracking. Note: Specimen Result Report is printing form existing orders.
03/06/2015	  IN054720		Vijayakumar K	03/06/2015							ML-BRU-SCF-1580 [IN:054720]
--------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
09/06/2017	IN063816		Krishna Gowtham J	09/06/2017		Ramesh G		GHL-CRF-0445.1				
27/06/2017  	IN064614		Vijayakumar K		27/06/2017		Ramesh G		CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																							Registration of order,required patient 																							Id,patient name,age,sex,register date and name 																					of study.
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
try
{
	Hashtable allValues = (Hashtable)XMLobj.parseXMLString( request ) ;
    allValues = (Hashtable)allValues.get( "SEARCH" ) ;

	String bean_id = (String)allValues.get("bean_id");
		    request.setCharacterEncoding("UTF-8");

	String localeName=request.getParameter("localeName");

	String bean_name = "eOR.ExistingOrder";
 	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request   ) ;

	bean.setLanguageId(localeName);
	boolean isviewLineDtls= bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961	
	//HashMap map = new HashMap() ;
	//OnLinePrinting online_print = new OnLinePrinting(request,response);
	OnLinePrinting online_print = new OnLinePrinting();
 	//String login_facility_id="";
	String total_records = (String)allValues.get("total_recs");
	String view_by = (String) allValues.get("view_by"); //IN054720
	//IN063816 starts
	String call_from_barcode_btn	= (String) allValues.get("call_from_barcode_btn");
	String facility_id				= "";
	String order_id					= "";
	String order_line_num			= "";
	String patient_id				= "";
	String order_catalog_code		= "";
	//String module_id				= "OR"; commented for IN061961 checkstyle
	String language_id				= "";
	String location_code			= "";
	String location_type			= "";
	//IN063816 ends
 	//int int_total_records = Integer.parseInt(total_records);//IN065942
	Hashtable resultHash	= new Hashtable();
	Hashtable orderHash		= new Hashtable();
	Hashtable print_barcode_values		= new Hashtable();//IN064614

	//int result_count		= 0;
	int order_count			= 0;

	String l_func_task = "";//IN065942

	//IN065942, starts
	l_func_task = (String)allValues.get("FUNC_TASK")==null?"":(String)allValues.get("FUNC_TASK");

	if("Y".equals(call_from_barcode_btn))
		l_func_task = "BARCODE_REPRINT";
	//IN065942, ends

	//IN063816 start
	//if(!"Y".equals(call_from_barcode_btn))//IN065942
	if("".equals(l_func_task))//IN065942
	{
	//IN063816 ends
		int int_total_records = Integer.parseInt(total_records);//IN065942
		for(int i=0; i<int_total_records; i++){
			String chk_val = ((String)allValues.get("chk"+i));
			if(chk_val==null) chk_val = "";
			//System.out.println("int_total_records="+int_total_records+",chk_val="+chk_val);
			if( chk_val.equalsIgnoreCase("Y")){
				String order_status = (String)allValues.get("ord_status"+i);
				String result_yn	= bean.getResultYN(order_status);
				if (result_yn!=null && result_yn.equals("Y")) {
					//System.out.println("1"+checkForNull((String)allValues.get("facility_id"+i),""));
					resultHash.put("ord_typ_code",((String)allValues.get("ord_typ_code"+i)));
					resultHash.put("ord_typ_desc",((String)allValues.get("ord_typ_desc"+i)));
					resultHash.put("patient_class",((String)allValues.get("patient_class"+i)));
					resultHash.put("priority",((String)allValues.get("priority"+i)));
					resultHash.put("ord_id",((String)allValues.get("ord_id"+i)));
					resultHash.put("source_type",((String)allValues.get("source_type"+i)));
					resultHash.put("location_code",((String)allValues.get("location_code"+i)));
					resultHash.put("report_srl_no","1");
					resultHash.put("facility_id",((String)allValues.get("facility_id")));
					resultHash.put("order_entry","ExistingOrder");
					resultHash.put("mode",((String)allValues.get("mode")));
					//resultHash.put("total_recs",""+result_count);
					//result_count++;
					//map = (HashMap)
					online_print.printResultEntryReport(resultHash, request, response);
					//System.out.println("====map> ssster the methoid:result:" +map);
					//String tmp_vals = (String)map.get("traceVal");

				} 
				else {
					
					orderHash.put("chk"+order_count,((String)allValues.get("chk"+i)));
					//orderHash.put("facility_id"+order_count,((String)allValues.get("facility_id"+i)));
					orderHash.put("ord_typ_code"+order_count,((String)allValues.get("ord_typ_code"+i)));
					orderHash.put("ord_typ_desc"+order_count,((String)allValues.get("ord_typ_desc"+i)));
					orderHash.put("patient_class"+order_count,((String)allValues.get("patient_class"+i)));
					orderHash.put("priority"+order_count,((String)allValues.get("priority"+i)));
					orderHash.put("ord_id"+order_count,((String)allValues.get("ord_id"+i)));
					orderHash.put("source_type"+order_count,((String)allValues.get("source_type"+i)));
					orderHash.put("location_code"+order_count,((String)allValues.get("location_code"+i)));
					orderHash.put("order_category"+order_count,((String)allValues.get("order_category"+i)));
					orderHash.put("cont_order_ind"+order_count,((String)allValues.get("cont_order_ind"+i)));//IN054500
					orderHash.put("order_line_num"+order_count,((String)allValues.get("order_line_num"+i)));//IN061961
					orderHash.put("order_catalog_code"+order_count,((String)allValues.get("order_catalog_code"+i)));//IN061961
					orderHash.put("view_by"+order_count,view_by);//IN061961
					//IN054720 starts
					if((view_by.trim().equals("L")))
						orderHash.put("performing_facility_id"+order_count,((String)allValues.get("performing_facility_id"+i)));
					else
						orderHash.put("performing_facility_id"+order_count,((String)allValues.get("performing_facility_id_hdr"+i)));
					//IN054720 ends
					
					order_count++;
				}
			}
		}
		orderHash.put("order_entry","ExistingOrder");
		orderHash.put("facility_id",checkForNull((String)allValues.get("facility_id")));
		orderHash.put("mode",checkForNull((String)allValues.get("mode")));
		orderHash.put("isviewLineDtls",isviewLineDtls);//IN061961
		orderHash.put("total_recs",""+order_count);
		//map = (HashMap)online_print.callOnlinePrint(allValues);
		//online_print.callOnlinePrint(allValues, request, response);
		online_print.callOnlinePrint(orderHash, request, response);
	//IN063816 starts
	}
	//else //IN065942
	else if("BARCODE_REPRINT".equals(l_func_task))//IN065942
	{
		int barcode_count_records = 0;//IN064614
		int int_total_records = Integer.parseInt(total_records);//IN065942
		for(int i=0; i<int_total_records; i++)
		{
			String chk_val = ((String)allValues.get("chk_barcode"+i));
			if(chk_val==null) chk_val = "";
			if( chk_val.equalsIgnoreCase("Y"))
			{
				facility_id 		= (String)allValues.get("performing_facility_id"+i);
				order_id			= (String)allValues.get("ord_id"+i);
				order_line_num 		= (String)allValues.get("order_line_num"+i);
				patient_id 			= (String)allValues.get("patient_id");
				order_catalog_code	= (String)allValues.get("order_catalog_code"+i);
				language_id			= (String)allValues.get("locale");
				location_code		= (String)allValues.get("location_code"+i);
				location_type			= (String)allValues.get("source_type"+i);
				//IN064614	
				print_barcode_values.put("order_catalog_code"+barcode_count_records,order_catalog_code);	
				print_barcode_values.put("order_id_"+barcode_count_records,order_id);
				print_barcode_values.put("order_line_num"+barcode_count_records,order_line_num);	 // order_line_num
				print_barcode_values.put("patient_id"+barcode_count_records,patient_id);	 // patient_id
				print_barcode_values.put("barcode_reqd_yn"+barcode_count_records,chk_val);	 // barcode_reqd_yn
				print_barcode_values.put("facility_id"+barcode_count_records,facility_id);	 // login_facility_id
				print_barcode_values.put("module_id"+barcode_count_records,"OR");	 // Module id
				print_barcode_values.put("location_type"+barcode_count_records,location_type);	 // location type
				print_barcode_values.put("location_code"+barcode_count_records,location_code);	 // location code
				
				barcode_count_records++;
				
			}
			
		}
		if(barcode_count_records>0)
		{
			print_barcode_values.put("barcode_count_records",String.valueOf(barcode_count_records));
			bean.onlinePrintingForBarcode(print_barcode_values, request, response);
		}//IN064614
	}//IN063816 ends
	else if("PRINT_REG_ORDER_LABEL".equals(l_func_task))//IN065942, starts
	{
		Hashtable print_reg_order_lbls = new Hashtable();
		int tot_rec = Integer.parseInt((String)allValues.get("p_no_of_rec"));

		if(tot_rec != 0)
		{
			for(int i=0; i<tot_rec; i++)
			{
				print_reg_order_lbls.put("order_id"+i,(String)allValues.get("p_order_id"+i));
				print_reg_order_lbls.put("order_line_no"+i,(String)allValues.get("p_order_line_no"+i));			
			}
			
			print_reg_order_lbls.put("pract_type",(String)allValues.get("p_pract_type"));
			print_reg_order_lbls.put("prn_lab_cnt",String.valueOf(tot_rec));
			print_reg_order_lbls.put("facility_id",(String)allValues.get("p_facility_id"));
			print_reg_order_lbls.put("module_id","OR");

			online_print.printRegOrdLabel(print_reg_order_lbls, request, response);
		}
	}//IN065942, ends

	//putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
e.printStackTrace();
}
%>
<%!
String checkForNull( String inputString, String defaultValue ) {
	return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
}
String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
}
%>
