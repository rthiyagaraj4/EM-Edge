<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
02/11/2011    IN29355        Menaka      Manage Specimen>New List
										 System not allow to record new list if orders were placed from Place Order function
23/02/2012	  IN030589		Menaka		 System should check & prompt for unbilled lab orders at Manage specimen. 
03/02/2012	  IN:030168    VIJAY R		 introduced new filter parameter 'ordering practitiner' in manage specimens page, search functionality.
12/7/2012	  IN33889		DineshT		Modified the selectAll functionality to add the records to the bean				 
10/04/2013  IN039158    Nijitha S		From manage specimen function, whenever the Ordering facility is Select, Collection barcode label cant be printed and not appear in printing job queue.			
04/06/2013	  IN035837		 Karthi L 		Requirement for managing future order and specimen number generation.[Bru-HIMS-CRF-320]	 
13/06/2013	  IN040758		Nijitha S  CRF-CA-Bru-HIMS-CRF-320/02- Record Collection->Future Order can be recorded
25/06/2013	  IN041127		 Karthi L	 Wrong message prompt is displayed
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------
29/08/2014	  	IN049737	   	Chowminya	 						MMS-CRF-194.1 Unbilled services will be regrouped into a new order
28/05/2015		IN052230		Karthi L							Order Management-Missing specimens-Dispatch Slip
06/10/2015		IN055737		Karthi L							IN055737 HSA-CRF-0250.1 - Dispatch Slip
20/10/2015		IN058099		Karthi L							HSA-CRF-0250.1/02- System does not Select All when a record is Unselected and Selected again using scanner..
22/08/2016		IN060590		Karthi L							HAAD Colour coding for Identification of Infectious disease in Patient BANNER[AAKH-CRF-0083.1].
02/01/2017		IN061888		Karthi L							To record collection all at 1 go
26/07/2017	IN064835		Vijayakumar K									ML-MMOH-CRF-0578.1 [IN:064835]
24/11/2017		IN063974		Prakash C								SS-CRF-0059[IN:063974]
22/02/2018		IN066671		Prakash C									SS-CRF-0059.1
 11/10/2023                 36727             Krishna Pranay   12/10/2023 Ramesh Goli           NMC-JD-CRF-0190
---------------------------------------------------------------------------------------------------------------
--> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
 	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	.haad_disease
		{
			width:12px;
			height:5px;
			border:1px solid #000;
		}
	.photo {

			 opacity: 0.5;
			filter: alpha(opacity=30);
	}
	</style>
</head>
 
<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!

    private boolean compareDate(String from_date,String to_date) {
    try{
        java.text.SimpleDateFormat formatter
             = new java.text.SimpleDateFormat ("dd/MM/yyyy kk:mm");

         // Parse the previous string back into a Date.
         java.text.ParsePosition pos = new java.text.ParsePosition(0);
         java.util.Date from = formatter.parse(from_date, pos);
         java.util.Date to = formatter.parse(to_date, pos);
         int result = from.compareTo(to);
         if (result > 0) { 
            return false;
         } else {
            return true;
         }
    } catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
    return true;
    }
%>

<%
	Connection con = null; //AAKH-CRF-0083.1 - IN060590
	try{
	/* Mandatory checks start */
				String bean_id = "Or_SpecimenOrder" ;
				String bean_name = "eOR.SpecimenOrder";
	/* Mandatory checks end */
		SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name , request ) ;
		bean.setLanguageId(localeName);
		String labchk="";
		//String lab_chking="";
		String mode	   = "1";
		request.setCharacterEncoding("UTF-8");
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		String lb_module="";
		//String lb_module = bean.getLbInstall("RL"); //Lab is installed or not changed on 7/16/2007 for lb_module logic change
		
		String session_id= bean.getSessionId();
		String slClassValue = "";
		String loc_dlts="";
		String order_detail="";
		String patient_details="";
		String location="";
		String priority_desc="";
		String HAAD_Data = ""; //AAKH-CRF-0083.1 - IN060590
		boolean isSiteSpecific  = false; //AAKH-CRF-0083.1 - IN060590
		boolean allowRedirectMulRecord=false;//36727
		String isAllowRedirectMulRecord="N";//36727
		String color_code_display = ""; //AAKH-CRF-0083.1 - IN060590;
		String login_facility_id = (String) session.getValue("facility_id");
		String select_all_spec_rec_collect_yn = bean.getCheckAllSpecRecCollection(login_facility_id);
	
		int count = 0;

		
		ArrayList searchData=new ArrayList();

		con = ConnectionManager.getConnection(); //AAKH-CRF-0083.1 - IN060590
		
		isSiteSpecific = CommonBean.isSiteSpecific(con, "OR","HAAD_DISEASE");	 //AAKH-CRF-0083.1 - IN060590
		//36727 start
		allowRedirectMulRecord = CommonBean.isSiteSpecific(con, "OR","ALLOW_MUL_REDIRECT_RECORD");	 
		if(allowRedirectMulRecord)
		{
			isAllowRedirectMulRecord="Y";
		}
                   //36727 end
		String date_from = request.getParameter( "date_from" ) ;
		String date_to = request.getParameter( "date_to" ) ;
		String priority = request.getParameter( "priority");
		String location_type = request.getParameter( "location_type");
		String locn = request.getParameter( "locn");
		String locn1 = request.getParameter( "locn1");
		String order_type = request.getParameter( "order_type");
		String order_type1 = request.getParameter( "order_type1");
		// [IN:030168] Start
		String practitioner_id = request.getParameter( "ordering_pract");
		// [IN:030168] End
		String option = request.getParameter( "option");
		option = (option == null) ? "" : option.trim();
		String select_td_style="";
		if(option.equals("S"))
		select_td_style="display:;visibility:hidden";
		else{
		select_td_style="display:;visibility:hidden";
		}
		String collection_list = request.getParameter( "collection_list");
		String select_specific_order = request.getParameter( "select_specific_order");
		String patientId = request.getParameter( "patientId");
		String order_id = request.getParameter( "order_id");
		String encounter_id = request.getParameter( "encounter_id");
		String curr_sys_date = 	 "";
		ArrayList sysdate = (ArrayList)bean.getSysDateTime();
		if (sysdate.size() == 3)
		curr_sys_date =  (String)sysdate.get(2);
		if ( !localeName.equals("en") )
{ 

		if (curr_sys_date.equals(" ") || curr_sys_date.equals("null")) curr_sys_date="";
		curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);// thai date validations 15/02/2007
}

		String function_id = request.getParameter( "function_id" ) ;
		String p_function_from = request.getParameter( "p_function_from" ) ;
		String ordered_location = request.getParameter( "ordered_location" ) ;
		String ordered_location_val = request.getParameter( "ordered_location_val" ) ;
		

		String ordering_facility = bean.checkForNull(request.getParameter("ordering_facility"),"");
		String performing_facility = bean.checkForNull(request.getParameter("performing_facility"),"");
		String status = bean.checkForNull(request.getParameter("status"),"");

		
		String print_locn_type	= (bean.checkForNull(request.getParameter("prn_loctype")));
		
		String print_locn		= (bean.checkForNull(request.getParameter("prn_loc")));
		String auto_collect		= (bean.checkForNull(request.getParameter("auto_collect")));
		String specimen_no		= (bean.checkForNull(request.getParameter("specimen_no")));
		String option_id = (bean.checkForNull(request.getParameter("option_id"))); // ML-MMOH-CRF-0540 [IN061888]
		String practitioner_type = (String)session.getValue("practitioner_type");
		
		String cont_order_ind = "", order_catalog_code = "", performing_facility_id = "";
		String  ordering_facility_id="";//IN039158
		String multiSelect =  (bean.checkForNull(request.getParameter("multiSelect"))); //IN052230
		String total_query_records  = "0";
		String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
		String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
		int start	 = Integer.parseInt(from);
		int end		 = Integer.parseInt(to);

		if(date_from==null||date_from.equals("")||date_from.equals("null")){					date_from="";		}
		if(date_to==null ||date_to.equals("")||date_to.equals("null")){						date_to="";			}
		if(priority==null ||priority.equals("")||priority.equals("null")){					priority="";			}
		if(location_type==null ||location_type.equals("")||location_type.equals("null")){			location_type="";	}
		if(locn==null||locn.equals("")||locn.equals("null")){							locn="";				}
		if(locn1==null||locn1.equals("")||locn1.equals("null")){							locn1="";				}
		if(order_type==null||order_type.equals("")||order_type.equals("null")){				order_type="";			}
		if(order_type1==null||order_type1.equals("")||order_type1.equals("null")){				order_type1="";			}
		//[IN:030168] Start
		if(practitioner_id==null||practitioner_id.equals("")||practitioner_id.equals("null")){				practitioner_id="";			}
		//[IN:030168] End
		if(option==null||option.equals("")||option.equals("null")){						option="";				}
		if(collection_list==null||collection_list.equals("")||collection_list.equals("null")){		collection_list="";	}
		if(select_specific_order==null||select_specific_order.equals("")||select_specific_order.equals("null")){		select_specific_order="";			}
		if(patientId==null||patientId.equals("")||patientId.equals("null")){					patientId="";		}
		if(order_id==null||order_id.equals("")||order_id.equals("null")){					order_id="";				}
		if(encounter_id==null||encounter_id.equals("")||encounter_id.equals("null")){			encounter_id="";		}
		if(curr_sys_date==null||curr_sys_date.equals("")||curr_sys_date.equals("null")){			curr_sys_date="";		}

		if(print_locn_type==null||print_locn_type.equals("")||print_locn_type.equals("null")){			print_locn_type="";		}
		if(print_locn==null||print_locn.equals("")||print_locn.equals("null"))			 {			print_locn="";		}
		if(auto_collect==null||auto_collect.equals("")||auto_collect.equals("null"))			 {			auto_collect="";		}
		if(ordered_location==null||ordered_location.equals("")||ordered_location.equals("null"))			 {			ordered_location="";		}
		if(ordered_location_val==null||ordered_location_val.equals("")||ordered_location_val.equals("null"))			 {			ordered_location_val="";		}


		String temp_ord_cat="";

		String start_date_time = "";
		String or_collection_due = "";
		String order_stage = "";
		String collect     = "";
		String applicability = "";
		String split_yn = "N";//IN049737
		// IN052230 - Start
		HashMap dispatchMap = null; 
		HashMap cloneMap = null;
		int rds_start = 0; 
		rds_start = start; 
		int chk_counter = 0;
		int selectedRecords = 0;
		int clone_map_count = 0;
		
		String isBarCodeSearchConfigEnabled = ""; //IN055737 HSA-CRF-0250.1 
		isBarCodeSearchConfigEnabled = bean.getBarcodeSearchConfigValue(); //IN055737 HSA-CRF-0250.1 	
		
		if(multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && option.equals("S") && "N".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) {
			bean.removeAllPatientDispSlipSelected();
			bean.removeAllClonedPatientDispSlipRecords(); //IN055694
		} 
		// IN052230 - End
		// IN055737 HSA-CRF-0250.1 - Start 
		if(option.equals("S") && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && "Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled)) {
			bean.removeAllClonedPatientDispSlipRecords(); 
		} 
		//IN055737 HSA-CRF-0250.1 - End
		//date_from="20/03/2008 10:44";
// [IN:030168] Start
//  searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end);//,practitioner_id); 
//searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id); // commented for IN052230
//	searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id, multiSelect); // modified for IN052230 //commented for IN055737 HSA-CRF-0250.1 - Start
	searchData=(ArrayList)bean.getSearchDetails(practitioner_type,date_from,date_to,priority,location_type,locn,locn1,order_type,order_type1,option,patientId,order_id,encounter_id,specimen_no,ordering_facility,performing_facility,status,ordered_location,ordered_location_val,start,end,practitioner_id, multiSelect, isBarCodeSearchConfigEnabled); //modified for IN055737 HSA-CRF-0250.1 
// [IN:030168] End
/* Initialize Function specific end */
	 
	// commented for IN052230 - Start
	/*String select_style="";
	if(option.equals("S")){
		select_style="display:none";}
	else{
		select_style="display:inline;visibility:visible";
	}*/
	
	String select_style = "display:;visibility:visible"; 
	if(multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") && option.equals("S") && "N".equalsIgnoreCase(isBarCodeSearchConfigEnabled) ) { // IN055737 HSA-CRF-0250.1 
			bean.setClonedPatientDispSlipRecords(bean.getPatientDispSlipSelected());
	}
	if(option.equals("S")) {
		cloneMap = bean.getClonedPatientDispSlipRecords();
		if(cloneMap != null) {
			clone_map_count = cloneMap.size();
		}
	}
	// IN055737 HSA-CRF-0250.1 - Start 
	if("Y".equalsIgnoreCase(isBarCodeSearchConfigEnabled) && option.equals("S") && "".equals(specimen_no) && multiSelect.equalsIgnoreCase("LOAD_ON_FIRST") ) {
		bean.removeAllPatientDispSlipSelected();
	}
	// IN055737 HSA-CRF-0250.1 - End
	
	multiSelect = "";	
	dispatchMap = bean.getPatientDispSlipSelected();
	if(dispatchMap != null){
		selectedRecords = dispatchMap.size();
	}
	
	//IN052230 - End
%>
<form name='specimen_reporting_dtl' id='specimen_reporting_dtl' action="../../eOR/jsp/SpecimenCollectionListAndLabelsSearchResult.jsp" method="post">
<div id="divHeadSep" style="position: ">
<table cellpadding=3 cellspacing=0 border='1' width="100%" height="" id="tableresult" class="grid">
<tr id="heading">
		<!-- AAKH-CRF-0083.1 [IN060590] -->
		<%if(isSiteSpecific) { %>
			<td class=columnheader width = '90px' wrap><fmt:message key="eOR.diseasecode.label" bundle="${or_labels}"/></td>
		<% } %>
		<!-- AAKH-CRF-0083.1 [IN060590] -->
		<td class=columnheader width='' nowrap><fmt:message key="eOR.PatientOrderDetail.label" bundle="${or_labels}"/></td>
	<!--IN063974 start-->	
	<%	if(option.equals("N")||option.equals("C"))
	  {%>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.PatientPhoto.label" bundle="${or_labels}"/></td>
	<%}%><!--IN063974 start-->
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap id='select_td'  style="<%=select_style%>" >
		<% if (option.equals("D") || option.equals("N") || option.equals("S")) {%>
			<a  class="gridLink" id='hdr'  ><font color='white'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a><input type=checkbox  name='check_all' id='check_all'  <%if(option.equals("S")){%>title='Select/Unselect action will affect records available in all pages' <%}%>onClick='clickAll(this);<%if(!option.equals("S")){%>selectAllForLocnUpdate()<%}%>'  disabled ></td><!--IN33889 IN41127-->
		<% } else if (option.equals("C") && select_all_spec_rec_collect_yn.equals("Y") && !"".equals(patientId) && !"".equals(option_id)) { %> <!-- ML-MMOH-CRF-0540 [IN061888] -->
				<a  class="gridLink" id='hdr'  ><font color='white'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a><input type=checkbox  name='check_all' id='check_all'  title='Select/Unselect action will affect records available in current page only' onClick='checkAllRecCollection(this);' > </td>  <!-- ML-MMOH-CRF-0540 [IN061888] -->	
		<%} else {%><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><%}%>
</tr>
<%for(int i=0;i<searchData.size();i++){
	ArrayList specimen_result=(ArrayList)searchData.get(i);
	if(i==0 && searchData.size() > 0 && count == 0){
		if(option.equals("D")){
			//if(specimen_result.size()>=38)//IN039158
			if(specimen_result.size()>=39)//IN039158
			total_query_records = bean.checkForNull((String)specimen_result.get(38),"0");}//IN039158
		else
		{   //if(specimen_result.size()>=37)//IN039158
			if(specimen_result.size()>=38)//IN039158
			
                       total_query_records = bean.checkForNull((String)specimen_result.get(37),"0");}//IN039158
			
	if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
			<tr align="right">
				<% if(isSiteSpecific){ %>
					<td colspan="6">		
		<!--IN063974 starts-->			
				<% }else if(option.equals("N")||option.equals("C")){ %>
					<td colspan="6">
		<!--IN063974 starts-->
				<% }else{ %>
					<td colspan="5">
				<% } %>
					<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from" value= "<%=start%>" /> 
					<jsp:param name ="to" value= "<%=end%>" />	
					<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
					<jsp:param name ="check_box_name" value= "select" />					 
					<jsp:param name ="form_name" value= "specimen_reporting_dtl" />
					<jsp:param name ="option" value= "<%=option%>" />  
					</jsp:include>
				</td>
		    </tr>
			<%}
		}

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";

		if((String)specimen_result.get(0)==null)specimen_result.set(0,"");
		if((String)specimen_result.get(1)==null)specimen_result.set(1,"");
		if((String)specimen_result.get(2)==null)specimen_result.set(2,"");
		if((String)specimen_result.get(3)==null)specimen_result.set(3,"");
		if((String)specimen_result.get(4)==null)specimen_result.set(4,"");
		if((String)specimen_result.get(5)==null)specimen_result.set(5,"");
		if((String)specimen_result.get(6)==null)specimen_result.set(6,"");
		if((String)specimen_result.get(7)==null)specimen_result.set(7,"");
		if((String)specimen_result.get(8)==null)specimen_result.set(8,"");
		if((String)specimen_result.get(9)==null)specimen_result.set(9,"");
		if((String)specimen_result.get(10)==null)specimen_result.set(10,"");
		if((String)specimen_result.get(11)==null)specimen_result.set(11,"");
		if((String)specimen_result.get(12)==null)specimen_result.set(12,"");
		if((String)specimen_result.get(13)==null)specimen_result.set(13,"");
		if((String)specimen_result.get(14)==null)specimen_result.set(14,"");
		if((String)specimen_result.get(15)==null)specimen_result.set(15,"");
		if((String)specimen_result.get(16)==null)specimen_result.set(16,"");
		if((String)specimen_result.get(17)==null)specimen_result.set(17,"");
		if((String)specimen_result.get(18)==null)specimen_result.set(18,"");
		if((String)specimen_result.get(19)==null)specimen_result.set(19,"");
		if((String)specimen_result.get(20)==null)specimen_result.set(20,"");
		if((String)specimen_result.get(21)==null)specimen_result.set(21,"");
		if((String)specimen_result.get(22)==null)specimen_result.set(22,"");
		if((String)specimen_result.get(23)==null)specimen_result.set(23,"");
		if((String)specimen_result.get(24)==null)specimen_result.set(24,"");
		if((String)specimen_result.get(25)==null)specimen_result.set(25,"");
		if((String)specimen_result.get(26)==null)specimen_result.set(26,"");
		if((String)specimen_result.get(27)==null)specimen_result.set(27,"");
		if((String)specimen_result.get(28)==null)specimen_result.set(28,"");
		if((String)specimen_result.get(29)==null)specimen_result.set(29,"");
		if((String)specimen_result.get(30)==null)specimen_result.set(30,"");
		if((String)specimen_result.get(31)==null)specimen_result.set(31,"");
		if((String)specimen_result.get(32)==null)specimen_result.set(32,"");
		if((String)specimen_result.get(33)==null)specimen_result.set(33,"");
		if((String)specimen_result.get(34)==null)specimen_result.set(34,"");
		if((String)specimen_result.get(35)==null)specimen_result.set(35,"");
		if((String)specimen_result.get(36)==null)specimen_result.set(36,"");//IN039158

		if(option.equals("D"))
		{
			//if((String)specimen_result.get(36)==null)specimen_result.set(36,"");
			if((String)specimen_result.get(37)==null)specimen_result.set(37,"");
		}

		if(((String)specimen_result.get(4)).compareTo("R")==0){
					priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(((String)specimen_result.get(4)).compareTo("U")==0)
				{
					
					priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(((String)specimen_result.get(4)).compareTo("S")==0)
				{
				
				priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

				}
				
				String sex1;
				sex1="";
				if (((String)specimen_result.get(26)).equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(((String)specimen_result.get(26)).equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(((String)specimen_result.get(14)).equalsIgnoreCase("C"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}//Modification Starts for issue IN29355 by Menaka
			else if(((String)specimen_result.get(14)).equalsIgnoreCase("E"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			}//Modification Ends for issue IN29355 by Menaka
		patient_details=((String)specimen_result.get(32))+","+sex1+"/"+((String)specimen_result.get(13))+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+((String)specimen_result.get(9))+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+((String)specimen_result.get(10))+","+location+"/"+((String)specimen_result.get(7))+",";
		loc_dlts=location+"/"+((String)specimen_result.get(7));
		if(((String)specimen_result.get(31))==null)
		order_detail=((String)specimen_result.get(12));
		else
		order_detail=((String)specimen_result.get(12))+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+":-"+(String)specimen_result.get(31);

		start_date_time = (String)specimen_result.get(28);
		/* Thai date validations start 15/02/2007*/
		if(start_date_time.equals(" ") || start_date_time.equals("null")) start_date_time="";
		if ( !localeName.equals("en") )
{ 

			start_date_time = com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName);
}
			String order_date_time=(String)specimen_result.get(11);
			if(order_date_time.equals(" ") || order_date_time.equals("null")) order_date_time="";
			if ( !localeName.equals("en") )
{ 

			order_date_time = com.ehis.util.DateUtils.convertDate(order_date_time,"DMYHM","en",localeName);
}
			/*String specimen_collect_date_time="";
			if(option.equals("D")){
			specimen_collect_date_time=(String)specimen_result.get(31);
			if(specimen_collect_date_time.equals(" ") || specimen_collect_date_time.equals("null")) specimen_collect_date_time="";
			specimen_collect_date_time = com.ehis.util.DateUtils.convertDate(specimen_collect_date_time,"DMYHM","en",localeName);
			}*/
		/* Thai date validations end 15/02/2007*/
			
		/* Thai date validations end 15/02/2007*/
		
		or_collection_due = (String)specimen_result.get(30);

		StringTokenizer stoken = new StringTokenizer(or_collection_due,"!");

		int counter = 0;
		while (stoken.hasMoreTokens()) 
		{
		  if (counter == 0) 
		  {
		      order_stage = stoken.nextToken();
              counter++;
		  } 
		  else if (counter == 1) 
		  {
		      collect = stoken.nextToken();
		      counter++;
		  } 
		  else if (counter == 2) 
		  {
		      applicability = stoken.nextToken();
		      counter++;
		  }//IN049737 - Start
		  else if (counter == 3) 
		  {
			  split_yn = stoken.nextToken();
		      counter++;
		  }//IN049737 - End
		}		

		String chkColor = slClassValue;

		if(!option.equals("S")){
			if (order_stage.equals("FUTURE")) {
			  chkColor = "QRY7";
			} else if (order_stage.equals("DUE")) {
			  chkColor = "QRY2";
			} else if (order_stage.equals("OVERDUE")) {
			  chkColor = "QRY3";
			}
			else if (order_stage.equals("NOTPAID")) {//[IN030589]
			  chkColor = "QRY5";//[IN030589]
			}//[IN030589]
		}
	%>
<%
		String rec_coll_individual_check_yn = "Y"; // ML-MMOH-CRF-0540 [IN061888]
		//IN040758 Starts
		String isDisabled = "";
		if(collect.equals("N") || (!option.equals("N") && order_stage.equals("FUTURE")))
		{
			isDisabled = "disabled";
			rec_coll_individual_check_yn = "N";  // ML-MMOH-CRF-0540 [IN061888]
		}
		else if(option.equals("S")){ //IN052230 - Start
			isDisabled = "enabled";
		} //IN052230 - End
		//IN040758 Ends
		if (!applicability.equals("X")) 
		{
			if(!(temp_ord_cat.equals(loc_dlts)))
			{
				temp_ord_cat = loc_dlts;
			%>
				<tr>
					<td class='columnheader' colspan='100%' > <font size=1><%=temp_ord_cat%></font></td>
				</tr>
			<%
			}
		cont_order_ind			= (String)specimen_result.get(33);
		performing_facility_id			= (String)specimen_result.get(34);
		order_catalog_code			= (String)specimen_result.get(35);	
		ordering_facility_id = (String)specimen_result.get(36);	//IN039158
		//SpecimenDetails = (ArrayList)bean.getSpecimenDetails((String)specimen_result.get(8));
		// if(SpecimenDetails!=null && SpecimenDetails.size() > 0)
	      //{
		labchk = bean.checkForNull(bean.getmoduleRL(order_catalog_code,(String)specimen_result.get(0),(String)specimen_result.get(17),(String) session.getValue( "facility_id")),"");
		  //}//added on 7/16/2007 for lb_module instal check by uma

	 // Get the cont_order_id & performing_facility_id & order_catalog_code for the order_id
	 //if(lb_module.equals("Y"))changed on 7/16/2007 for lb_instal_yn
	 //if(labchk.equalsIgnoreCase("IBARL"))//added on 7/16/2007 for lb_module by uma 
	 //{
		 ///cont_order_id = ""; order_catalog_code = ""; performing_facility_id = "";
	     // SpecimenDetails = (ArrayList)bean.getSpecimenDetails((String)specimen_result.get(8)); // order_id
	      //if(SpecimenDetails!=null && SpecimenDetails.size() > 0)
	      //{
	      	 	      	  	
	      //}
	// }
		String displaying="";
		displaying=patient_details;
		String specimenDetail = (String)specimen_result.get(12);
		if(order_detail.indexOf("!~!")!=-1)
		{
			order_detail = order_detail.replace("!~!",",");
			specimenDetail  = specimenDetail.replace("!~!",",");
		}
		
		if(isSiteSpecific) {
			HAAD_Data =eMR.MRHaadcolorConfigBean.getHAADPlinecontext(con,(String)specimen_result.get(9),(String) session.getValue("facility_id")); //AAKH-CRF-0083.1 - IN060590
			if(HAAD_Data != null){
				
				String[] result = null;
				StringTokenizer token = new StringTokenizer(HAAD_Data, "|");
				StringBuilder colorCodeBuilder = new StringBuilder();
				colorCodeBuilder.append("<td class="+slClassValue+" ><table><tr>");
				while(token.hasMoreTokens()){
					colorCodeBuilder.append("<td><div class='haad_disease' style = 'background:");
					result = token.nextToken().split("~");
					for(int k=0;k<result.length-1;k++){
						if("".equals(result[1]) || result[1] == null)
							result[1] = "#FFFFFF";
						colorCodeBuilder.append(result[1]);
						colorCodeBuilder.append("' title ='"+result[0] +"'> </div></td>");
					}
				}
				colorCodeBuilder.append("</tr>  </table></td>");
				color_code_display = colorCodeBuilder.toString();
			}
			if("".equals(color_code_display) || color_code_display == null) {
				color_code_display = "<td width='' wrap class='"+ slClassValue+ "'</td> ";
			}
		}
		%>
		<tr>
			<%if(isSiteSpecific) { %>
				<%=color_code_display%>  
			<% } %> 
			<td width='' wrap class='<%=slClassValue%>' id='ord_detail<%=count%>'> <font size=1><%=displaying%></font></td>
			<!--IN066671 starts-->
			<%if(option.equals("N")||option.equals("C"))
			{%>		
				<td 	width=''  nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;<img align='middle' width='20' height='20'  src="../../eCommon/images/PI_Photo.gif" class='patphotoimg' title='Click to view photo' onclick='showPhoto(<%=count%>)'></td>	
			<%}%> 
			<!--IN066671 ends-->
			<td width='' nowrap class='<%=slClassValue%>'><font size=1><%=(String)specimen_result.get(8)%></font></td>
			<td width='' nowrap class='<%=slClassValue%>' ><font size=1 ><a class="gridLink" href='#' onClick="callMenuFunctions('View','<%=(String)specimen_result.get(1)%>','<%=(String)specimen_result.get(8)%>','<%=(String)specimen_result.get(26)%>','<%=(String)specimen_result.get(9)%>','<%=(String)specimen_result.get(6)%>','<%=(String)specimen_result.get(10)%>')"><%=order_detail%></a></font></td>
			<td width='' nowrap class='<%=slClassValue%>' id = 'start_date<%=count%>' ><font size=1 ><%=start_date_time%></font></td>
            <td width='' nowrap class='<%=chkColor%>' id='status<%=i%>' style="<%=select_style%>"><font size=1><input type=checkbox name='select<%=count%>' id='select<%=count%>'value="E"  <%if(dispatchMap.containsKey((String)specimen_result.get(31))) { chk_counter++; %>Checked<%}%> onClick='clickLine(this,<%=count%>)' <%=isDisabled%>><a class="gridLink" id='lins<%=count%>'></a></font></td><!-- IN040758, IN052230 -->
          
            <input type="hidden" name="specimen_date_time<%=count%>" id="specimen_date_time<%=count%>" value="<%=curr_sys_date%>">
			<input type="hidden" name="specimen_remarks<%=count%>" id="specimen_remarks<%=count%>" value="">
			<input type="hidden" name="collected_by<%=count%>" id="collected_by<%=count%>" value="">
			<input type="hidden" name="dispatch_mode<%=count%>" id="dispatch_mode<%=count%>" value="">
			<Input type='hidden' name='seq_no<%=count%>' id='seq_no<%=count%>' value="-1">
			<input type="hidden" name="order_id<%=count%>" id="order_id<%=count%>" value="<%=(String)specimen_result.get(8)%>">
			<input type="hidden" name="source_type<%=count%>" id="source_type<%=count%>" value="<%=(String)specimen_result.get(14)%>">
			<input type="hidden" name="source_code<%=count%>" id="source_code<%=count%>" value="<%=(String)specimen_result.get(15)%>">
			<input type="hidden" name="order_type_code<%=count%>" id="order_type_code<%=count%>" value="<%=(String)specimen_result.get(17)%>">
			<input type="hidden" name="specimen_no<%=count%>" id="specimen_no<%=count%>" value="<%=(String)specimen_result.get(31)%>">  <!-- Ramesh -->
			<input type="hidden" name="lab_chking<%=count%>" id="lab_chking<%=count%>" value="<%=labchk%>">
			<input type="hidden" name="specimen_type<%=count%>" id="specimen_type<%=count%>" value="<%=(String)specimen_result.get(24)%>">
			<input type="hidden" name="order_date_time<%=count%>" id="order_date_time<%=count%>" value="<%=order_date_time%>">
			<input type="hidden" name="priority<%=count%>" id="priority<%=count%>" value="<%=(String)specimen_result.get(16)%>">
			<input type="hidden" name="coll_label_gen_rule<%=count%>" id="coll_label_gen_rule<%=count%>" value="<%=(String)specimen_result.get(23)%>">
			<input type="hidden" name="specimen_collect_yn<%=count%>" id="specimen_collect_yn<%=count%>" value="<%=(String)specimen_result.get(25)%>">
			<input type="hidden" name="order_category<%=count%>" id="order_category<%=count%>" value="<%=(String)specimen_result.get(0)%>">
			<input type="hidden" name="patient_class<%=count%>" id="patient_class<%=count%>" value="<%=(String)specimen_result.get(27)%>">
			<input type="hidden" name="start_date_time<%=count%>" id="start_date_time<%=count%>" value="<%=start_date_time%>"> <!-- added for CRF 320 -->
			<input type="hidden" name="old_start_date_time<%=count%>" id="old_start_date_time<%=count%>" value="<%=start_date_time%>"> <!-- added for CRF 320 -->
			<input type="hidden" name="specimen_collect_date_time<%=count%>" id="specimen_collect_date_time<%=count%>" value="<%=(option.equals("D"))?(String)specimen_result.get(37):""%>"><!--IN039158-->

			<input type="hidden" name="cont_order_ind<%=count%>" id="cont_order_ind<%=count%>" value="<%=cont_order_ind%>">
			<input type="hidden" name="order_catalog_code<%=count%>" id="order_catalog_code<%=count%>" value="<%=order_catalog_code%>">
			<input type="hidden" name="performing_facility_id<%=count%>" id="performing_facility_id<%=count%>" value="<%=performing_facility_id%>">
			
			<input type="hidden" name="ordering_facility_id<%=count%>" id="ordering_facility_id<%=count%>" value="<%=ordering_facility_id%>"><!--IN039158-->
			<input type="hidden" name="interval_test_yn<%=count%>" id="interval_test_yn<%=count%>" value="">
			<input type='hidden' name = 'catalogDesc<%=count%>' value = '<%=specimenDetail%>'/>
			<input type="hidden" name="patient_id<%=count%>" id="patient_id<%=count%>" value="<%=(String)specimen_result.get(9)%>"><!-- IN049737 -->
			<input type="hidden" name="encounter_id<%=count%>" id="encounter_id<%=count%>" value="<%=(String)specimen_result.get(10)%>"><!-- IN049737 -->
			<input type="hidden" name="split_yn<%=count%>" id="split_yn<%=count%>" value="<%=split_yn%>"><!-- IN049737 -->
			<!-- IN052230 - Start -->
			<input type="hidden" name="rds_order_id<%=rds_start%>" id="rds_order_id<%=rds_start%>" value="<%=(String)specimen_result.get(8)%>">
			<input type="hidden" name="rds_patient_id<%=rds_start%>" id="rds_patient_id<%=rds_start%>" value="<%=(String)specimen_result.get(9)%>">
			<input type="hidden" name="rds_specimen_no<%=rds_start%>" id="rds_specimen_no<%=rds_start%>" value="<%=(String)specimen_result.get(31)%>">
			<input type="hidden" name="rds_encounter_id<%=rds_start%>" id="rds_encounter_id<%=rds_start%>" value="<%=(String)specimen_result.get(10)%>">
			<!-- IN052230 - End -->
			<input type="hidden" name="rec_coll_individual_check_yn<%=count%>" id="rec_coll_individual_check_yn<%=count%>" value="<%=rec_coll_individual_check_yn%>">
			
		</tr>

	<%	count++;
		rds_start++; // IN052230
		}
	}
	//IN052230 - Start
	//if(option.equals("S")) {// - commented for IN055737 HSA-CRF-0250.1
	if(option.equals("S") && isBarCodeSearchConfigEnabled.equals("N"))  { //added for IN055737 HSA-CRF-0250.1
		if(selectedRecords !=0 && clone_map_count == selectedRecords){
	%>
			<script>
				document.getElementById("check_all").checked = true
				document.getElementById("check_all").disabled = false
			</script>
	<%	
		}else {
	%>
			<script>
				document.getElementById("check_all").disabled = false
			</script>
	<%	
		}
	//} //IN052230 - End
	} else if(option.equals("S") && isBarCodeSearchConfigEnabled.equals("Y"))  { //added for IN055737 HSA-CRF-0250.1
		if(selectedRecords !=0 && clone_map_count == selectedRecords){
	%>	
			<script>
				parent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.focus();
				document.getElementById("check_all").checked = true
				document.getElementById("check_all").disabled = false
			</script>
	<%
		} else {
	%>	
			<script>
				parent.SpecimenOrderSearch.document.specimen_order_search.specimen_no.focus();
				document.getElementById("check_all").checked = false
				document.getElementById("check_all").disabled = false
			</script>
	<%
		}
	}
	//added for IN055737 HSA-CRF-0250.1 - End
	if(count == 0)
	{ 
	%>
	<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		parent.SpecimenOrderSearch.document.specimen_order_search.search_btn.disabled=false;
		//parent.SpecimenOrderHeader.location.href = "../../eCommon/html/blank.html"
		parent.SpecimenOrderResult.location.href = "../../eCommon/html/blank.html"
		parent.SpecimenOrderBtn.location.href = "../../eCommon/html/blank.html"
	</script>
	<%	
	}	
	%>
</table>
</div>
<input type="hidden" name="total_recs" id="total_recs" value='<%=count%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="option_list" id="option_list" value="">
<input type="hidden" name="specimen_hdr_date_time" id="specimen_hdr_date_time" value="">
<input type="hidden" name="specimen_hdr_collected_by" id="specimen_hdr_collected_by" value="">
<input type="hidden" name="specimen_hdr_specimen_remarks" id="specimen_hdr_specimen_remarks" value="">
<input type="hidden" name="specimen_hdr_dispatch_mode" id="specimen_hdr_dispatch_mode" value="">
<input type="hidden" name="lb_module" id="lb_module" value="<%=lb_module%>">
<input type="hidden" name="session_id" id="session_id" value="<%=session_id%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">

<Input type="hidden" name="collection_list" id="collection_list" value="<%=collection_list%>">
<Input type="hidden" name="print_locn_type" id="print_locn_type" value="<%=print_locn_type%>">
<Input type="hidden" name="print_locn" id="print_locn" value="<%=print_locn%>">
<Input type="hidden" name="date_from" id="date_from" value="<%=date_from%>">
<Input type="hidden" name="date_to" id="date_to" value="<%=date_to%>">
<Input type="hidden" name="priority" id="priority" value="<%=priority%>">
<Input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<Input type="hidden" name="locn" id="locn" value="<%=locn%>">
<Input type="hidden" name="locn1" id="locn1" value="<%=locn1%>">
<Input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
<Input type="hidden" name="order_type1" id="order_type1" value="<%=order_type1%>">
<Input type="hidden" name="option" id="option" value="<%=option%>">
<Input type="hidden" name="select_specific_order" id="select_specific_order" value="<%=select_specific_order%>">
<Input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<Input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
<Input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<Input type="hidden" name="auto_collect" id="auto_collect" value="<%=auto_collect%>">
<Input type="hidden" name="specimen_no" id="specimen_no" value="<%=specimen_no%>"> 
<Input type="hidden" name="ordering_facility" id="ordering_facility" value="<%=ordering_facility%>"> 
<Input type="hidden" name="performing_facility" id="performing_facility" value="<%=performing_facility%>"> 
<Input type="hidden" name="status" id="status" value="<%=status%>"> 
<input type="hidden" name="specimen_new_list_date_time" id="specimen_new_list_date_time" value="">
<input type="hidden" name="specimen_new_list_collected_by" id="specimen_new_list_collected_by" value="">
<input type="hidden" name="specimen_new_list_specimen_remarks" id="specimen_new_list_specimen_remarks" value="">
<input type="hidden" name="specimen_new_list_seq_no" id="specimen_new_list_seq_no" value="">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>"><!-- IN049737 -->
<input type="hidden" name="selectedRecords" id="selectedRecords" value="<%=selectedRecords%>"><!-- IN052230 -->
<input type="hidden" name="clonedMapcount" id="clonedMapcount" value="<%=clone_map_count%>"><!-- IN052230 -->
<input type="hidden" name="isSpecBarCodeSearchYN" id="isSpecBarCodeSearchYN" value="<%=isBarCodeSearchConfigEnabled%>"><!-- IN055737 - / IN058099 -->
<Input type="hidden" name="option_id" id="option_id" value="<%=option_id%>"><!-- IN063354 -->
<input type="hidden"id="allowRedirectMulRecord" name="allowRedirectMulRecord" id="allowRedirectMulRecord" value="<%=allowRedirectMulRecord%>"><!-- 36727-->
<input type="hidden"id="isAllowRedirectMulRecord" name="isAllowRedirectMulRecord" id="isAllowRedirectMulRecord" value="<%=isAllowRedirectMulRecord%>"><!-- 36727-->

<input type="hidden" name="chk_counter" id="chk_counter" value="<%=chk_counter%>">
  <%--<Script>alert("date_from="+"<%=date_from%>"+",date_to="+"<%=date_to%>")</Script>
<Script>alert("priority="+"<%=priority%>"+",location_type="+"<%=location_type%>")</Script>
<Script>alert("locn="+"<%=locn%>"+",locn1="+"<%=locn1%>")</Script>
<Script>alert("order_type="+"<%=order_type%>"+",order_type1="+"<%=order_type1%>")</Script>
<Script>alert("option="+"<%=option%>"+",select_specific_order="+"<%=select_specific_order%>")</Script>
<Script>alert("patientId="+"<%=patientId%>"+",order_id="+"<%=order_id%>")</Script>
<Script>alert("collection_list="+"<%=collection_list%>"+",encounter_id="+"<%=encounter_id%>")</Script>
<Script>alert("print_locn_type="+"<%=print_locn_type%>"+",print_locn="+"<%=print_locn%>")</Script>--%>
<Input type="hidden" name="p_function_from" id="p_function_from" value="<%=p_function_from%>">
<input type='hidden' name='totalChecked' id='totalChecked' value = '0'/>
<Input type="hidden" name="called_from" id="called_from" value=""><!-- IN049737 -->

<!-- For Next & previous -->
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
<input type="hidden" name="specimen_date_time" id="specimen_date_time" value="">
<input type="hidden" name="specimen_remarks" id="specimen_remarks" value="">
<input type="hidden" name="collected_by" id="collected_by" value="">
<input type="hidden" name="dispatch_mode" id="dispatch_mode" value="">
<!-- [IN:030168] Start -->
<input type="hidden" name="ordering_pract" id="ordering_pract" value="<%=practitioner_id%>">
<input type='hidden' name='selectedOrders' id='selectedOrders' value=''/>

<!-- [IN:030168] End -->
<input type='hidden' name='reRoutePrinterId' id='reRoutePrinterId' value=''/><!-- IN064835 -->
 <!-- For Next & previous -->
<script>
			//if(parent.SpecimenOrderHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
</script>
</form>
<script>ondetail();
	</script>
</body>
<script> parent.SpecimenOrderSearch.document.specimen_order_search.search_btn.disabled=false;</script>

</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	System.out.println(" Exception in SpecimenCollectionListAndLabelsSearchResult.jsp ==>  " +e.toString());
	e.printStackTrace();
}
finally {
	if(con != null)
		con.close();
}
%>

