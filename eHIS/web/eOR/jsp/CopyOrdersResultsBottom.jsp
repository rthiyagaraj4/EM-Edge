<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
The logic of implementing this modal window functionality is based on the array.
There are many array as the number of the columns/objects in the form.
Both in the case of adding new set, a new element is added to all the arrays and
while updating the existing set the corresponding array elements from
all the arrays are accessed and populated

-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<HTML>
<HEAD> 
    <TITLE></TITLE>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript"	src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
	//String mode	   = "1";//request.getParameter( "mode" ) ;
	ArrayList allValues = new ArrayList();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String finalString 	= request.getParameter("finalString");
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
	String localeName  = request.getParameter("localeName");
	String view_by		= request.getParameter("view_by");

	finalString = (finalString == null) ? "" : finalString;
	bean_id	= (bean_id == null) ? "" : bean_id;
	bean_name = (bean_name == null) ? "" : bean_name;
	view_by		= (view_by == null) ? "L" : view_by.trim();

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	      bean.setLanguageId(localeName);


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.clear() ;
	//bean.setMode( mode ) ;
	/* Initialize Function specific end */
%>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='copy_orders_results_bottom' id='copy_orders_results_bottom'>
<table cellpadding=3 cellspacing=0 border=o width='100%' class="grid">
<tr><td class='COLUMNHEADER'   colspan='30' align="center"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SelectedOrderables.label","or_labels")%></td></tr>
<%
	allValues		= bean.getBeanValues();
	String[] copy_details = null;
	String slClassValue = "";
	int j = 0;

	for(int i=0; i<allValues.size(); i++){
		if (finalString.indexOf("~"+i+"~") != -1) {
			copy_details = (String[])allValues.get(i);

	        /*if(j % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";

			if(copy_details[0] == null) copy_details[0] = "";
	        if(copy_details[1] == null) copy_details[1] = "";
	        if(copy_details[2] == null) copy_details[2] = "";
	        if(copy_details[3] == null) copy_details[3] = "";
	        if(copy_details[4] == null) copy_details[4] = "";
	        if(copy_details[5] == null) copy_details[5] = "";
	        if(copy_details[6] == null) copy_details[6] = "";
	        if(copy_details[7] == null) copy_details[7] = "";
			if(copy_details[8] == null) copy_details[8] = "";
			if(copy_details[9] == null) copy_details[9] = "";
			if(copy_details[10] == null) copy_details[10] = "";
			if(copy_details[11] == null) copy_details[11] = "";
	        if(copy_details[12] == null) copy_details[12] = "";
	        if(copy_details[13] == null) copy_details[13] = "";
	        if(copy_details[14] == null) copy_details[14] = "";
			if(copy_details[15] == null) copy_details[15] = "";
	        if(copy_details[16] == null) copy_details[16] = "";
	        if(copy_details[17] == null) copy_details[17] = "";
	        if(copy_details[18] == null) copy_details[18] = "";
			if(copy_details[19] == null) copy_details[19] = "";
	        if(copy_details[20] == null) copy_details[20] = "";
	        if(copy_details[21] == null) copy_details[21] = "";
	        if(copy_details[22] == null) copy_details[22] = "";
			if(copy_details[23] == null) copy_details[23] = "";
	        if(copy_details[24] == null) copy_details[24] = "";
	        if(copy_details[25] == null) copy_details[25] = "";
	        if(copy_details[26] == null) copy_details[26] = "";
	        if(copy_details[27] == null) copy_details[27] = "";
	        if(copy_details[28] == null) copy_details[28] = "";
			
	        if (view_by.equals("L")) {
		        if(copy_details[29] == null) copy_details[29] = "";
		        if(copy_details[30] == null) copy_details[30] = "";
		        if(copy_details[31] == null) copy_details[31] = "";
	        }
	        %>
			<tr>
	        	<td width='5%' class='<%=slClassValue%>' ><input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  value="N" onClick='clickUnSelect()' checked></td>
	        	<td width='8%' class='<%=slClassValue%>' ><font size=1><%=copy_details[1]%></font></td>
	        	<td width='8%' class='<%=slClassValue%>' ><font size=1><%=copy_details[2]%></font></td>
	        	
				<%if (view_by.equals("L")) {%>
	        		<td width='10%' class='<%=slClassValue%>' ><font size=1><a class="gridLink" href="javascript:callCopyMenuFunctions1('View','<%=copy_details[1]%>','<%=copy_details[0]%>','<%=copy_details[6]%>','','<%=copy_details[29]%>','<%=copy_details[30]%>','','<%=copy_details[7]%>','<%=copy_details[20]%>','<%=copy_details[18]%>','<%=copy_details[21]%>')"><%=copy_details[10]%></a></font></td>
	        	<%} else if (view_by.equals("H")) {%>
	        		<td width='10%' class='<%=slClassValue%>' ><font size=1><a class="gridLink" href="javascript:callMenuFunctions('View','<%=copy_details[7]%>','<%=copy_details[0]%>','<%=copy_details[1]%>','<%=copy_details[6]%>','<%=copy_details[20]%>','<%=copy_details[18]%>','<%=copy_details[21]%>','<%=copy_details[14]%>','','<%=copy_details[8]%>','<%=copy_details[5]%>')"><%=copy_details[10]%></a></font></td>
	        	<%}%>
	        	<td width='12%' class='<%=slClassValue%>' ><font size=1><%=com.ehis.util.DateUtils.convertDate(copy_details[27],"DMYHM","en",localeName)%></font></td>
	        	<td width='12%' class='<%=slClassValue%>' ><font size=1><%=com.ehis.util.DateUtils.convertDate(copy_details[28],"DMYHM","en",localeName)%></font></td>
	        	<td width='6%' class='<%=slClassValue%>' ><font size=1><%=copy_details[3]%></font></td>
	        	<td width='10%' class='<%=slClassValue%>' ><font size=1><%=copy_details[17]%></font></td>

	        	<td width='10%' class='<%=slClassValue%>' ><font size=1><%=copy_details[19]%></font></td>

				<input type='hidden' name='order_id<%=i%>' id='order_id<%=i%>' value='<%=copy_details[6]%>'>
				<input type='hidden' name='sex<%=i%>' id='sex<%=i%>' value='<%=copy_details[21]%>'>
	        	<input type='hidden' name='dob<%=i%>' id='dob<%=i%>' value='<%=copy_details[22]%>'>
	        	<input type='hidden' name='order_type_code<%=i%>' id='order_type_code<%=i%>' value='<%=copy_details[14]%>'>
	        	<input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value='<%=copy_details[0]%>'>
	        	<input type='hidden' name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=copy_details[7]%>'>
	        	<input type='hidden' name='encounter_id<%=i%>' id='encounter_id<%=i%>' value='<%=copy_details[8]%>'>
	        	<input type='hidden' name='ord_pract_id<%=i%>' id='ord_pract_id<%=i%>' value='<%=copy_details[16]%>'>
	        	<input type='hidden' name='priority<%=i%>' id='priority<%=i%>' value='<%=copy_details[13]%>'>
	        	<input type='hidden' name='order_status<%=i%>' id='order_status<%=i%>' value='<%=copy_details[18]%>'>
	        	<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value='<%=copy_details[20]%>'>
	        	<input type='hidden' name='ordering_facility_id<%=i%>' id='ordering_facility_id<%=i%>' value='<%=copy_details[23]%>'>
	        	<input type='hidden' name='source_code<%=i%>' id='source_code<%=i%>' value='<%=copy_details[12]%>'>
	        	<input type='hidden' name='iv_prep_yn<%=i%>' id='iv_prep_yn<%=i%>' value='<%=copy_details[25]%>'>
	        	<input type='hidden' name='age<%=i%>' id='age<%=i%>' value='<%=copy_details[26]%>'>
	        	<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value='<%=copy_details[11]%>'>
	        	<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value='<%=copy_details[5]%>'>
	        	<%if (view_by.equals("L")) {%>
		        	<input type='hidden' name='order_line_num<%=i%>' id='order_line_num<%=i%>' value='<%=copy_details[29]%>'>
					<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value='<%=copy_details[30]%>'>
				<%}%>
	        </tr>
	<%		j++;
		}
	}
%>
<input type='hidden' name='allValues' id='allValues' value='<%=allValues.size()%>'>
<input type='hidden' name='view_by' id='view_by' value='<%=view_by%>'>
<input type='hidden' name='finalString' id='finalString' value='<%=finalString%>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>


</form>
</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);
%>

