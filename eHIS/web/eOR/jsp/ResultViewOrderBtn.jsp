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
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
03/07/2013    IN039857		 Chowminya G    Print Button from result view page for LB order
17/07/2013    IN041798	 Chowminya G    Print Button from result view page for LB order - Changes the function name
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/11/2015		IN057113		Karthi L							 				ML-MMOH-CRF-0335 - IN057113
18/07/2018		IN061961		sivabagyam M        18/07/2018		Ramesh G		GHL-CRF-0433
15/01/2021		7632			Sivabagyam M		15/01/2021		Ramesh G		ML-MMOH-CRF-1261.1
24/02/2022	 	25671			Ramesh G											NMC-JD-CRF-0091.2 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 

<!-- ViewOrderBtn.jsp -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ResultOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
 		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
	<tr>
	<%
	String legend_type = "";
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	//7632 STARTS
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
	String locale = (String) p.getProperty("LOCALE");
	String clinician_id				= (String) session.getValue("ca_practitioner_id");
	String login_user = (String)session.getValue("login_user"); 
	String resp_id					= (String)session.getValue("responsibility_id");
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String self_submit	= "YES";
	String facility	= (String) session.getValue( "facility_id" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String desformat="pdf";
	String destype="cache",report_option="V";
	String patient_id = request.getParameter("patient_id");
	String order_id = request.getParameter("orderId");
	String event_code = request.getParameter("event_code");
	//7632ENDS
	bean.setLanguageId(localeName);
	ArrayList DetailsColors=new ArrayList();
	ArrayList listDesc=new ArrayList();
	//IN039857 - Start
	String ord_cat = request.getParameter("ord_cat");
	String order_catalog_code = request.getParameter("order_catalog_code");//IN061961
	
	String order_line_num = request.getParameter("order_line_num");//IN061961
	String view_by = request.getParameter("view_by");//IN061961
	String LBInstallYN	= "N";
	//25671 Start.
	boolean isSiteSpecificESignature = bean.isSiteSpecific("ESIGNATURE_REQUIRED");
	String eSignatureYN ="N";
	if(isSiteSpecificESignature)
		eSignatureYN ="Y";
	//25671 End.
	if("LB".equals(ord_cat))
	{
		LBInstallYN = bean.getLBInstallYN();
	}
	//IN039857 - End
	String conf_pin_req_yn = ""; //ML-MMOH-CRF-0335 - IN057113
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	HashMap mapDescColor=new HashMap();
	DetailsColors=bean.getDetailsColors();
	//7632 STARTS
	boolean ispdfprint=false;//7632
	ispdfprint =  bean.isSiteSpecific("RESULTSPRINTINGINPDF");//7632 
	ArrayList pdfEvents=new ArrayList();  
	ArrayList viewing=new ArrayList();  
	pdfEvents=	bean.getPdfPrintingEvents(patient_id);	
	viewing=bean.viewCall(facility,ws_no,reportServer,userid,report_option,order_id);
	String REQ_DATE="";
	String session_id="";
	String accession_num="";
	String performing_facility_id="",machine_name="",reqdate="",report="",server="",copies="",queue_name="";
	String message="",app_server_ip="",rep_server_key="",report_Server="",facilty="";
	
		if(pdfEvents.size() >= 3){
			session_id=(String)pdfEvents.get(0);
			reqdate=(String)pdfEvents.get(1);
			machine_name=(String)pdfEvents.get(2);
			performing_facility_id=(String)pdfEvents.get(3);
			facilty=(String)pdfEvents.get(4);
		}
		
		if(viewing.size() >= 9){
			report=(String)viewing.get(0);
			server=(String)viewing.get(1);
			copies=(String)viewing.get(2);
			queue_name=(String)viewing.get(3);
			message=(String)viewing.get(4);
			app_server_ip=(String)viewing.get(5);
			rep_server_key=(String)viewing.get(6);
			report_Server=(String)viewing.get(7);
			accession_num=(String)viewing.get(8);
		}//7632 ENDS
	if(DetailsColors.size()==3)
	{
		listDesc=(ArrayList)DetailsColors.get(0);
		mapDescColor=(HashMap)DetailsColors.get(1);
		legend_type=(String)DetailsColors.get(2);
	%>
	<td>
		<table cellpadding=3 cellspacing=0 width='100%' border='0' >
		<tr>
		<%
		String listValues = "";
		String mapValues = "";
		String listValuesdisp = "";
		String tooltip = "";
		int tdWidth = 0;
		if(listDesc.size() != 0)
			tdWidth = 100/listDesc.size();
		else
			tdWidth = 100;

		for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			mapValues = (String) mapDescColor.get(listValues);

			if(listValues.length()>15)
			{
				listValuesdisp = listValues.substring(0,15);
				tooltip = listValues;
			}
			else
			{
				listValuesdisp = listValues;
				tooltip = "";
			}
			//out.println("<td width='"+tdWidth+"%' style='background-color:"+mapValues+"'>"+listValues+"</td>");

			if(legend_type.equals("S"))
			{
	%>
			<td width='15%' nowrap title='<%=tooltip%>'>
				<font style='background:url("../../eCA/images/<%=mapValues%>");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font><font size=1><%=listValuesdisp%></font>
			</td>
	<%
			}
			else
			{
	%>
			<td width='15%' nowrap title='<%=tooltip%>'>
				<font style='background-color:<%=mapValues%>;size:1;width:16px;height:16px'>&nbsp;&nbsp;</font><font size=1><%=listValuesdisp%></font>
			</td>
	<%
			}
		}
		if(legend_type.equals("S"))
		{
	%>
			<td  width='15%' nowrap>
				<font style='background:url("../../eCA/images/NI_Normal.gif");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font><font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
		}
		else
		{
	%>
			<td  width='15%' nowrap>
				<font style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font><font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
		}
	%>
		</tr>
		</table>
		</td>
		<%}%>
		<td  class='button' align="right">
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")%>' class='button' onClick='showHistory()'>
		<%		 
			//IN039857 Start//7632	 STARTS	
			if("Y".equals(LBInstallYN) && ispdfprint)
			{
			%>
				<INPUT TYPE="button" value='Print' class='button' onClick="run('<%=event_code%>')"> <!-- IN041798 -->
			<%
			}else if("Y".equals(LBInstallYN) && !ispdfprint){%>
				<INPUT TYPE="button" value='Print' class='button' onClick="printLBValues();"> <!-- IN041798 -->	
			<% }//7632 ENDS
			else
			{//IN039857 End
			%>
			<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>' class='button' onClick='printing()'>
			<%
			}		
		%>
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='toCloseTopShowModal()'>
		</td>
	</tr>

</table>

<input type="hidden" name="locale" id="locale" value="<%= locale %>">
<input type="hidden" name="l_conf_pin_req_yn" id="l_conf_pin_req_yn" value="<%= conf_pin_req_yn %>"> <!-- ML-MMOH-CRF-0335 - IN057113 -->
<input type="hidden" id="order_catalog_code" name="order_catalog_code" id="order_catalog_code" value="<%= order_catalog_code %>"> <!--IN061961-->
<input type="hidden" id="order_line_num" name="order_line_num" id="order_line_num" value="<%= order_line_num %>"> <!--IN061961-->
<input type="hidden" id="view_by" name="view_by" id="view_by" value="<%=view_by%>"> <!--IN061961-->
<input type="hidden" id="ord_cat_code" name="ord_cat" id="ord_cat" value="<%=ord_cat%>"> <!--IN061961-->
<input type='hidden' id='performing_facility_id' name='performing_facility_id' id='performing_facility_id' value='<%=performing_facility_id%>'>
<input type='hidden' id='facilityid' name='facilityid' id='facilityid' value='<%=facility%>'><!--7632-->
<input type='hidden' id='login_user' name='login_user' id='login_user' value='<%=login_user%>'><!-- 7632 -->
<input type='hidden' id='patient_id' name='patient_id' id='patient_id' value='<%=patient_id%>'><!-- 7632 -->
<input type='hidden' id='session_id' name='session_id' id='session_id' value='<%=session_id%>'><!-- 7632 -->
<input type='hidden' id='machine_name' name='machine_name' id='machine_name' value='<%=machine_name%>'><!-- 7632 -->
<input type='hidden' id='reqdate' name='reqdate' id='reqdate' value='<%=reqdate%>'><!-- 7632 -->
<input type='hidden' id='report_Server' name='report_Server' id='report_Server' value='<%=report_Server%>'><!-- 7632 -->
<input type='hidden' id='report' name='report' id='report' value='<%=report%>'><!-- 7632 -->
<input type='hidden' id='server' name='server' id='server' value='<%=server%>'><!-- 7632 -->
<input type='hidden' id='copies' name='copies' id='copies' value='<%=copies%>'><!-- 7632 -->
<input type='hidden' id='queue_name' name='queue_name' id='queue_name' value='<%=queue_name%>'><!-- 7632 -->
<input type='hidden' id='message' name='message' id='message' value='<%=message%>'><!-- 7632 -->
<input type='hidden' id='app_server_ip' name='app_server_ip' id='app_server_ip' value='<%=app_server_ip%>'><!-- 7632 -->
<input type='hidden' id='rep_server_key' name='rep_server_key' id='rep_server_key' value='<%=rep_server_key%>'><!-- 7632 -->	
<input type='hidden' id='self_submit' name='self_submit' id='self_submit' value='<%=self_submit%>'><!-- 7632 -->
<input type='hidden' id='report_option' name='report_option' id='report_option' value='<%=report_option%>'><!-- 7632 -->
<input type='hidden' id='destype' name='destype' id='destype' value='<%=destype%>'><!-- 7632 -->
<input type='hidden' id='desformat' name='desformat' id='desformat' value='<%=desformat%>'><!-- 7632 -->
<input type='hidden' id='userid' name='userid' id='userid' value='<%=userid%>'><!-- 7632 -->
<input type='hidden' id='accession_num' name='accession_num' id='accession_num' value='<%=accession_num%>'><!-- 7632 -->
<input type='hidden' id='facilty' name='facilty' id='facilty' value='<%=facilty%>'><!-- 7632 -->
<input type="hidden" name="eSignatureYN" id="eSignatureYN" value="<%=eSignatureYN%>" > <!-- 25671 -->
</form>

</body>
</html>

