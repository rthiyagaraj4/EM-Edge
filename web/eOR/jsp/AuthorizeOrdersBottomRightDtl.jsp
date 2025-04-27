<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--  
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
26/09/2011	  27156			Menaka 		     Incident No: 27156 - <Pharmacy order When amend drug
															  from authorization function for discharge medication have massage "APP-BL9022 Visit Financial Details could not be selected".>	
19/09/2013	  IN043383	   Karthi L			In order authorization screen, the Authorize check box is disabled															  
14/03/2014    IN041644		Nijitha S		Prescription Authorization of Drugs Based on Rules
10/04/2014	  IN048381		Nijitha S		Alpha-Regression- CA>Pending Authorization>Incorrect count is displayed when filtered by �All� and �Specialty specific�
23/06/2014		IN049228		Karthi L		23/06/2014		Akbar			Based on Authorization Rights, Authorization can be done by either a senior doctor from same speciality of ordering practitioner�s speciality OR    a senior doctors from patients� speciality.	
17/09/2014		IN051144		Nijitha S			?			?			Amend Reason Pop up Window is not displayed, when Amend Order while Authorization	
19/09/2014		IN051237		Nijitha S			?			?			Amend Reason Window validation differed while Amend order During Authorization	
20/06/2016		IN059086		Karthi L											ML-MMOH-CRF-0493 [IN059086]
18/04/2018    		IN064980             	RamyaMaddena  18/04/2018   Ramesh G 		  ML-MMOH-CRF-0956[IN064980]	
14/10/2019      IN071315	    Nijitha S   GHL-CRF-0607	
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!---->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function dummy()
	{
	}
	function hideToolTip(obj,imgObj,row)	
	{
	 //document.getElementById("tooltiplayer").style.visibility = 'hidden'
		dynamichide(obj, window.event,row);
	  //if (obj != null)
	  //{
			//obj.className = 'gridDataBlue';
			//eval("document.all."+imgObj).src = "../../eCommon/images/inactiveArrow.gif";
	  //}	  
	}

	function callMouseOver(obj)	
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';
	}

	function callOnMouseOut(obj)
	{
		obj.className = 'contextMenuItem';
	}

	function resizeWindow(orderctlHDR)
	{

		var orderctlHDR1 = orderctlHDR.id;

		var wdth = document.getElementById(orderctlHDR1).offsetWidth;
		var hght1 = document.getElementById(orderctlHDR1).offsetHeight;		
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
		y=y-25;
		document.getElementById("tooltiplayer").style.left= x+"px";
		document.getElementById("tooltiplayer").style.top = y+"px";
		document.getElementById("tooltiplayer").style.visibility='visible'
	}


	function displayToolTip(val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,orderctlHDR,imgObj) {
			
			callMouseOverOnTD(orderctlHDR,imgObj);

		  	buildTable (val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob)
			resizeWindow(orderctlHDR)
	}

	function buildTable(val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob) {
//		alert(val);
//		alert(val1);
		bean_id      = document.authorise_order_dtl.bean_id.value;
        var rowval   = val.split (",");
		var row      = ("View,Cancels,Ammend,Discontinue,,,");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style=' z-index: 1000;background-color: #d9d9d9;border: 1px solid #ccc;box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);position: absolute;'>";
		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i]

			var colval1 = rowval1[i];
           if (colval != "")
           {
           
				tab_dat     += "<tr>"
				if(colval1 == "Ammend"){
					//alert("'"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"'");
					//alert( "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:callAmmendFunctions('"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"')><B>"+colval+" </B></a></td>" );
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:getVisitAdmDate('"+orderId+"','"+patient_id+"','"+encounter_id+"','"+pract_reln_id+"','"+escape(location_type)+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+escape(dob)+"','"+bean_id+"')>"+colval+" </a></td>"//IN051144
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:getVisitAdmDate('"+orderId+"','"+patient_id+"','"+encounter_id+"','"+pract_reln_id+"','"+escape(location_type)+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+escape(dob)+"','"+bean_id+"','"+ord_cat+"')>"+colval+" </a></td>";//IN051144

				}else{

					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+ord_cat+"','"+escape(val1)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+encounter_id+"','"+patient_class+"')>"+colval+"</a></td>"//Commented for IN071315
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+ord_cat+"','"+escape(val1)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+encounter_id+"','"+patient_class+"','"+p_called_from_ca+"')>"+colval+"</a></td>";//Added for IN071315
				}
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
		
		document.getElementById("t").innerHTML = tab_dat
			//alert(document.getElementById("t").innerHTML)
	}
</script>

	<!-- <STYLE TYPE="text/css">
       	A:link
       	 {
       	     COLOR: blue;
       	 }
     	A:visited
     	 {
             COLOR: blue ;
         }
        A:active
         {
             COLOR: red;
         }
    </STYLE> -->
</head>

<body  onScroll="processScroll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = "1" ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_AuthoriseOrder" ;
	String bean_name = "eOR.AuthoriseOrders";
	String bean_id1 = "Or_ExistingOrder" ;
	String bean_name1 = "eOR.ExistingOrder";

	/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	if(PrivilegeApplicabilityAuth == null || PrivilegeApplicabilityAuth.equals("null")) PrivilegeApplicabilityAuth ="N"; else PrivilegeApplicabilityAuth = PrivilegeApplicabilityAuth.trim();
	/*Ends Here*/

/* Mandatory checks end */

	/* Initialize Function specific start */

//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

/* Initialize Function specific end */


	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");

	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	if(resp_id== null)resp_id = "";
	if(pract_reln_id== null) pract_reln_id= "";

	String encounter_dtls="";
	String patientdetails="";
	String location="";

	//String[] allsess_vals = (String[])session.getValueNames();
//	for(int i=0; i<allsess_vals.length; i++)



	String security_level = "";
	security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1"; // needs to be replaced with session values
	
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;

	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter		= request.getParameter("filter");
	String Inc_Force_Auth		= request.getParameter("Inc_Force_Auth");
	String auth_filter		= request.getParameter("auth_filter");
	String total_query_records  = "0";
	String auth_ord_priv_rule_only_yn = "N"; //ML-MMOH-CRF-0493 [IN059086] 
	//int total_records = 0;

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ;
	if(period_from== null) period_from="" ; else period_from = period_from.trim();
	if(period_to== null) period_to="" ; else period_to = period_to.trim();
	if(filter== null) filter="" ; else filter = filter.trim();
	if(Inc_Force_Auth== null) Inc_Force_Auth="" ; else Inc_Force_Auth = Inc_Force_Auth.trim();
	if(auth_filter== null) auth_filter="" ; else auth_filter = auth_filter.trim();

	AuthoriseOrders bean = (AuthoriseOrders)getBeanObject( bean_id, bean_name, request  ) ;
	ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request   ) ;
	bean.setLanguageId(localeName);
	bean1.setLanguageId(localeName);
	//bean.setRequestResponse(request,response);
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");
	//String  auth_yn = bean.getAuthYN(practitioner_id,resp_id) ;
	String slClassValue = "";
	//String classValue = "";
	//int total = 0;
	String pract_spec_code=bean.checkForNull(bean.getPractSpecCode(practitioner_id));
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 		bean.clear() ;
	//}
 	//bean.clear() ;
	bean.setMode( mode ) ;

	auth_ord_priv_rule_only_yn = bean.getAuthOrdPrivRuleOnlyYN();  //ML-MMOH-CRF-0493 [IN059086] 
	String dis_select = bean.getDisSelectAllOptionYN();  //IN064980
	ArrayList StatusDetail = new ArrayList();

	//if(from!=null && from.equals("1")) {
			
  		StatusDetail = bean.getStatusByDetail( facility_id,source_type,source_code,practitioner_id,resp_id,priority,ord_cat,order_by,patientId,period_from,period_to,start,end,"PO",filter,PrivilegeApplicabilityAuth,Inc_Force_Auth,auth_filter) ;
	
 		// Setting as a persistence bean
		//bean.setDetails(StatusDetail);
 	//} else {
	//	StatusDetail=bean.getDetails();
  	//}
	 


	String menu_security = "";
	String menu_security1 = "";


%>
<form name='authorise_order_dtl' id='authorise_order_dtl'  action="../../eOR/jsp/AuthorizeOrdersBottomRightDtl.jsp" method="post">
<div id="divHeadSep">
<table class='grid' cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult">
<!--<tr id="heading"><td class='columnheader' width='' nowrap><input type-->
<tr id="heading"><td class='COLUMNHEADER' width='' nowrap> <%if(dis_select.equals("Y")){%> <!--ML-MMOH-CRF-0956[IN064980]-----STARTS-->
<input type=checkbox disabled  name='select_all' id='select_all' onClick='clickAll()'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/>
<%}else{%>
	<input type=checkbox name='select_all' id='select_all' onClick='clickAll()'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></td>
<%}%><!--ML-MMOH-CRF-0956[IN064980]-----ENDS-->
	<%if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals("")){%>
		<td class=COLUMNHEADER width='' nowrap><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
	<%}%>

	<%if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals("")){	%>
		<td class=COLUMNHEADER width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<%}%>
		<td class=COLUMNHEADER width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class=COLUMNHEADER width='' nowrap><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
		<td class=COLUMNHEADER width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<%
		if(bill_yn.equalsIgnoreCase("Y"))
		{
		%>
			<td class=COLUMNHEADER width='' nowrap><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></td>
		<%
		}
		%>
	</tr>
<%



%>

		<%
		String tmp_ord_cat = "";
		String tmp_urgency = "";
		String fontValue ="";
 		String cont_order_ind = "";
		String ord_appr_by_user_id = "";
		String ord_appr_reqd_yn = "";
		String order_category = "";
		String ord_consent_reqd_yn = "";
		String ord_consent_by_id = "";
		String display_checked="";
		menu_security = (String)bean1.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
		menu_security1 = (String)bean1.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
		
		//String privilege_yn			= "N"; 
		String disabled= "";
		String splty_code="";
		String splty_desc="";
		String strOrderCtl = "";
		int i = 0;
		String ord_prac_spec_code = ""; // added for IN049228
	/*	if(StatusDetail.size() < 7 || end > StatusDetail.size()) {
			end = StatusDetail.size();
		}	*/

		for( int k=0 ; k< StatusDetail.size() ; k++ ) {
		//for( i=0 ; i< StatusDetail.size() ; i++ ) {
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				String slClassValueTmp = slClassValue;
				//String[] record = (String[])StatusDetail.get(i);
				String[] record = (String[])StatusDetail.get(k);
				ord_prac_spec_code = bean.checkForNull(bean.getPractSpecCode(record[38])); // added for IN049228
				if(record[2].compareTo("R")==0){
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(record[2].compareTo("U")==0)
				{
					
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(record[2].compareTo("S")==0)
				{
				
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
				}	

				String sex1;
				sex1="";
				if (record[22].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(record[22].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(record[14].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(record[14].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(record[14].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
				patientdetails=record[11]+","+sex1+"/"+record[23]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[7];
			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[8]+","+location+"/"+record[5];

			if(k==0)
			{
					if(record[33] != null)
					total_query_records = bean.checkForNull((String)record[33],"0");
					
				%>
					<%if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
					<tr  align="right">
						<td colspan="6">
							<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name ="from" value= "<%=start%>" /> 
							<jsp:param name ="to" value= "<%=end%>" />	
							<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
							<jsp:param name ="check_box_name" value= "chk" />					 
							<jsp:param name ="form_name" value= "authorise_order_dtl" />  
							</jsp:include>
						</td>
					</tr>
				<%}%>				
				<%	
					if(!priority.equals(" ") || !ord_cat.equals(" ") )
					{
						if(!(priority.equals(" "))){
							if(priority.equals("U")){
								out.println("<tr><td class='ORRED' colspan=6>"+priority_desc+"</td>");
							}else if(priority.equals("S")){
								out.println("<tr><td class='ORBROWN' colspan=6>"+priority_desc+"</td>");
							}else if(priority.equals("R")){
								out.println("<tr><td class=COLUMNHEADER colspan=6>"+priority_desc+"</td>");
							}
					}
					if(!(ord_cat.equals(" "))){
						out.println("<tr><td class=COLUMNHEADER colspan=6>"+ord_cat_desc+"</td>");
					}
				}
			
				}
				order_category = bean.checkForNull((String)record[0],"");
				cont_order_ind = bean.checkForNull((String)record[24],"");
				ord_appr_by_user_id = bean.checkForNull((String)record[26],"");
				ord_appr_reqd_yn = bean.checkForNull((String)record[25],"");
				ord_consent_reqd_yn = bean.checkForNull((String)record[27],"");
				ord_consent_by_id = bean.checkForNull((String)record[28],"");
				//privilege_yn= bean.checkForNull((String)record[29],"");
				splty_desc=(((String)record[29]==null)?"": (String)record[29]);
				splty_code=(((String)record[30]==null)?"": (String)record[30]);
				//if((!splty_code.equals("")) && (!splty_code.equals(pract_spec_code)))// commented for IN049228
				if((!splty_code.equals("")) && (!splty_code.equals(pract_spec_code)) && (!ord_prac_spec_code.equals(pract_spec_code))) // modified for IN049228
				{
					if("Y".equals(auth_ord_priv_rule_only_yn)){
						display_checked="";	
					} else {
						display_checked="disabled"; // commented for IN043383 Reverted Changes for IN048381
						//display_checked=""; // modified for IN043383 Reverted Changes for IN048381
					}		
				}
				else
				{
					    display_checked="";
				}
			 
				/*if(privilege_yn!=null && privilege_yn.equals("Y"))
					disabled  = "";
				else
					disabled  = "DISABLED";	 */

  				//the following 2 if conditions are used to display in "group BY"
				//format of order category or urgency
				if(!(tmp_ord_cat.equals(record[1])) && (!(order_by.equals(" ") ||(order_by.equals("P")))))
				{
					out.println("<tr><td class=COLUMNHEADER colspan=6>"+record[1]+"</td>");
					tmp_ord_cat = record[1];
					
				}
				if(!(tmp_urgency.equals(record[2])) && (!(order_by.equals(" ") ||(order_by.equals("O")))))
				{
					out.println("<tr><td class=COLUMNHEADER colspan=6 >"+record[2]+"</td>");
					tmp_urgency = record[2];
					
				}
		%>

			<tr>
				<td  width='' nowrap id='status<%=i%>' class='<%=slClassValue%>'><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' <%=disabled%><%=display_checked%>></td>

				<%if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals("")){%>
				<td width='' nowrap class='<%=slClassValue%>'><%=record[1]%></td>
				<%}%>

				<%
				if(record[13].equals("U")){
					fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
				}else if(record[13].equals("S")){
					fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				}else{
					fontValue = "<font size=1 color=black><b>";
				}

				%>
				<%if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals("")){  %>
				<td width='' nowrap class='<%=slClassValue%>'><%=fontValue%><%=record[2]%></td>
				<%}%>
				<%
					slClassValue = slClassValueTmp;

					if (record[9] == null || record[9] == "null") record[9]="";
				%>
				<td width='' nowrap class='<%=slClassValue%>'><%=com.ehis.util.DateUtils.convertDate(record[9],"DMYHM","en",localeName)%></td> <!--  date of ordered AT -->
				<%
				if(record[10].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])record[10].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					record[10] = order_detail;
					if(record[10].lastIndexOf(",") ==((record[10].length())-2))
					{
						record[10] = record[10] .substring(0,((record[10].length())-2));
					}
				}
				if(record[10].indexOf("!~!")!=-1)
				{
					record[10] = record[10].replace("!~!",",");
				}
				strOrderCtl = "";
				strOrderCtl = "<td nowrap width='' wrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue'";
				//27156 STARTS
				if(record[19].equalsIgnoreCase("OP") && record[36].equalsIgnoreCase("D"))
				{
					record[19]="IP";
				}  //27156 ENDS
				strOrderCtl = strOrderCtl + " onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((record[35].trim().equals("A"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((record[34].trim().equals("A"))?"'+getLabel('Common.Amend.label','Common')+'":"")+"','"+record[0]+"','"+record[1]+"','"+record[6]+"','"+record[7]+"','"+record[8]+"','"+record[7]+"','"+record[14]+"','"+record[15]+"','"+record[19]+"','Y','"+record[22]+"','"+record[23]+"','"+record[21]+"',this,'imgArrow"+i+"')\"   onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\" >"+record[10];//IN051237
									
				if(!splty_desc.equals(""))
				{
					strOrderCtl = strOrderCtl + "<B><font COLOR='#A4AE00;'>["+splty_desc+"]</B>";
				}
				strOrderCtl = strOrderCtl + "<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>";

					out.println(strOrderCtl);
					
		%>		<!--  data of ordered Catalogs -->
				<td width='' wrap class='<%=slClassValue%>'><%=patientdetails%><BR><%=encounter_dtls%>
				   <a class="gridLink" href="javascript: dummy()" onClick="callPatientHistory('<%=record[7]%>')"    onMouseOver='hideToolTip()' ><fmt:message key="eOR.PatientHistory.label" bundle="${or_labels}"/>
					</a>
					</td><!--  data of ordering locn details -->
				   <%
					StringBuffer menu_text1 = new StringBuffer();
					menu_text1.append( "'+getLabel('Common.view.label','Common')+'");%>
					<!--<script>alert("<%=record[6]%>")</script>-->
			<%if(!order_category.equalsIgnoreCase("PH")&&bill_yn.equalsIgnoreCase("Y"))
				{
				%>
					<td class='<%=slClassValue%>' width='' nowrap><a class="gridLink" href="javascript:callBilling('<%=i%>','<%=record[6]%>','<%=record[7]%>','<%=facility_id%>','<%=record[8]%>','<%=record[19]%>','<%=record[1]%>','<%=record[22]%>','<%=menu_text1%>','<%=record[6]%>','<%=bean.checkForNull(record[31],"")%>')" title='Charge Details'> <!--<fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>--><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></a></td> 
			<%}
				else if(bill_yn.equalsIgnoreCase("Y"))
				{
					%>
						<td class='<%=slClassValue%>' width='' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<%
				}
				%>
				<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=record[16]%>">
				<input type=hidden name='order_category<%=i%>' id='order_category<%=i%>' value="<%=order_category%>">
				<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value="<%=record[17]%>">
				<input type=hidden name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="<%=record[18]%>">
				<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=record[6]%>">
				<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=record[19]%>">
				<input type="hidden" name="discharge_ind<%=i%>" id="discharge_ind<%=i%>" value="<%=record[36]%>"><!--27156 -->
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=record[7]%>">
				<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=record[13]%>">
				<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=record[20]%>">
				<input type="hidden" name="date_of_birth<%=i%>" id="date_of_birth<%=i%>" value="<%=record[21]%>">
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value="<%=record[22]%>">
				<input type="hidden" name="age<%=i%>" id="age<%=i%>" value="<%=record[23]%>">
				<input type="hidden" name="ord_catalog<%=i%>" id="ord_catalog<%=i%>" value="<%=record[10]%>">
				<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>">
				<input type="hidden" name="ord_appr_by_user_id<%=i%>" id="ord_appr_by_user_id<%=i%>" value="<%=ord_appr_by_user_id%>">
				<input type="hidden" name="ord_appr_reqd_yn<%=i%>" id="ord_appr_reqd_yn<%=i%>" value="<%=ord_appr_reqd_yn%>">
				<input type="hidden" name="ord_consent_by_id<%=i%>" id="ord_consent_by_id<%=i%>" value="<%=ord_consent_by_id%>">
				<input type="hidden" name="ord_consent_reqd_yn<%=i%>" id="ord_consent_reqd_yn<%=i%>" value="<%=ord_consent_reqd_yn%>">
				<input type="hidden" name="order_set_id<%=i%>" id="order_set_id<%=i%>" value="<%=bean.checkForNull(record[31],"")%>">
				<input type="hidden" name="encounter_id<%=i%>" id="encounter_id<%=i%>" value="<%=record[8]%>"><!-- IN041644 -->
				<input type="hidden" name="order_date_time<%=i%>" id="order_date_time<%=i%>" value="<%=record[9]%>"><!-- IN041644 -->
				<input type="hidden" name="ordering_pract_id<%=i%>" id="ordering_pract_id<%=i%>" value="<%=record[38]%>"><!-- IN041644 -->
				<input type="hidden" name="ordering_facility_id<%=i%>" id="ordering_facility_id<%=i%>" value="<%=record[37]%>"><!-- IN041644 -->
				<input type="hidden" name="ord_auth_reqd_yn<%=i%>" id="ord_auth_reqd_yn<%=i%>" value="<%=record[39]%>"><!-- IN041644 -->
			</tr>
		<%
			i++;
			}
		%>
		
</table>
</div>
<!-- Next, Prev --> 
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 
<%--<input type=hidden name='total_recs' id='total_recs' value='<%//=StatusDetail.size()%>'>--%>
<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="security_level" id="security_level" value="<%=security_level%>">
<input type="hidden" name="relationship_id" id="relationship_id" value="<%=pract_reln_id%>">


<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>">
<input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">
<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="Inc_Force_Auth" id="Inc_Force_Auth" value="<%=Inc_Force_Auth%>">
<input type="hidden" name="filter" id="filter" value="<%=filter%>">
<input type="hidden" name="auth_filter" id="auth_filter" value="<%=auth_filter%>">
 
<input type="hidden" name="help_function_id" id="help_function_id" value="AUTHORIZE_ORDERS">

		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					</td>
				</tr>
			</table>
		</div>

	<script>
			//if(parent.AuthorizeOrdersBottomRight0.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
	</script>

</form>

</body>
<script>
parent.parent.parent.AuthoriseOrderTop.document.authorise_order.search_btn.disabled = false;
</script>
</html>
<%

	putObjectInBean(bean_id,bean,request);
	//putObjectInBean(bean_id1,bean1,request);
%>

