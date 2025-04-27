<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/07/2012	  IN034159		Menaka V	 LIS-Blood Unit Consumption	
27/12/2013	IN046075		Ramesh G		Bru-HIMS-CRF-391/20
--------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<!--Modified by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589-->
<title><fmt:message key="eBT.Blood.label" bundle="${bt_labels}"/>&nbsp;<fmt:message key="eBT.TransfusionTransferHistory.label" bundle="${bt_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryBloodTransfusion.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id				= request.getParameter("patient_id");
//	String encounter_id				= request.getParameter("encounter_id");
	//String bean_id 				= "@accessrightbean"+patient_id+encounter_id;
	//String bean_name 				= "eOR.Common.AccessRightBean";
	bean.setLanguageId(localeName);

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//AccessRightBean bean 		= (AccessRightBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		// AccessRightBean bean		= (AccessRightBean)getBeanObject( bean_id, bean_name, request ) ;
    /* Initialize Function specific end */
    String classValue				= "";
    ArrayList BloodTransfusion      = new ArrayList();
	ArrayList Blood					= null;
	// IN046075 Start.
	//BloodTransfusion 				= bean.getBloodTransfusion(patient_id, properties);
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id"); 
	BloodTransfusion 				= bean.getBloodTransfusion(patient_id, properties,clinician_id,resp_id);	
	// IN046075 End.
	//String str						= "";
	//String event_desc				= "";
	String temp_ord_cat				= "";
	String result_str				= "";
	String hist_data_type           = "";
	String hist_rec_type            = "";
	String contr_sys_id			    = "";
	String accession_num            = "";
	String contr_sys_event_code     = "";
	String  enctr_id = "";//IN034159
	String  fac_id = "";//IN034159
	String dataexists				= "0";
	String data						= "";

	int    i						= 0;

%>
<form name="blood_transfusion" id="blood_transfusion">
	<table width="100%" border='1' cellspacing="0" cellpadding="3" class="grid">
	<tr>
		<th colspan="2"><fmt:message key="eOR.ProductDetails.label" bundle="${or_labels}"/></th>
	</tr>
<%
		for(i=0;i<BloodTransfusion.size();i++)
		{
			Blood =(ArrayList)BloodTransfusion.get(i);
			classValue="gridData";
			data =  "";
			temp_ord_cat = (String)Blood.get(0);
			if(temp_ord_cat==null) temp_ord_cat = "";
			result_str = (String)Blood.get(1);
			if(result_str==null) result_str = "";
			hist_data_type = (String)Blood.get(2);
			if(hist_data_type==null) hist_data_type = "";
			hist_rec_type = (String)Blood.get(3);
			if(hist_rec_type==null) hist_rec_type = "";
			contr_sys_id = (String)Blood.get(4);
			if(contr_sys_id==null) contr_sys_id = "";
			accession_num = (String)Blood.get(5);
			if(accession_num==null) accession_num = "";
			contr_sys_event_code = (String)Blood.get(6);
			if(contr_sys_event_code==null) contr_sys_event_code = "";
			//IN034159 Starts
			enctr_id = (String)Blood.get(7);
			if(enctr_id==null) enctr_id = "";
			fac_id = (String)Blood.get(8);
			if(fac_id==null) fac_id = "";
			//IN034159 Ends
			dataexists = (String)Blood.get(9);
			if(dataexists==null) dataexists = "";

			data = data + result_str+"";

			if(dataexists.equalsIgnoreCase("1") && hist_data_type.equalsIgnoreCase("STR"))
			{
				//data = data +"<a class='gridLink' href=\"javascript:getText('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN034159
				data = data +"<a class='gridLink' href=\"javascript:getText('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN034159
			}

%>
			<tr>
				<td width="15%"  class="<%=classValue%>"><%=temp_ord_cat%></td>
				<td width="85%"  class="<%=classValue%>"><%=data%></td>
			</tr>

<%			
			if(Blood!=null){
				Blood.clear();
				Blood = null; // nullifying the objects
			}
		}
		if(i == 0){ %>
	  	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));window.close();</script>
<% } %>

</table>


</tr>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'><!-- IN034159 -->
</form>
<%
	// Nullifying the objects
	if(BloodTransfusion!=null) {
		BloodTransfusion.clear();
		BloodTransfusion      = null;
	}
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

