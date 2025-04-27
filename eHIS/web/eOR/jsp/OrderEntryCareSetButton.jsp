<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
26/07/2018	  	IN064543		Kamalakannan	26/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	//String patient_id					= request.getParameter("patient_id");
	//String encounter_id					= request.getParameter("encounter_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");
	String function_from 			= request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String care_set_order				= "";
	String care_set_value				= "N";
	//IN064543 start
	String order_catalog_nature			= "S";
	String patient_class				= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String encounter_id					= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String admission_date				= request.getParameter("admission_date")==null?"":request.getParameter("admission_date");
	String discharge_date_time			= request.getParameter("discharge_date_time")==null?"":request.getParameter("discharge_date_time");
	String practitioner_type			= request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
	String enbDis =  request.getParameter("enbDis")==null?"disabled": request.getParameter("enbDis");
	//IN064543 end
	/* Mandatory checks end */
	/* Initialize Function specific	 start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		 bean.setLanguageId(localeName);

		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* Initialize Function specific end */
	String care_sets					= bean.checkForNull(request.getParameter("care_sets"));
	//String ammend_called_from			= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_category				= bean.checkForNull(request.getParameter("order_category"),"CS").trim();
	if(!order_category.equalsIgnoreCase("PH"))
		order_category					= "CS";
	String key							= (bean.getPatientId()+bean.getEncounterId());
	String keyItems[]					= null;
	String entryValue					= null;
	java.util.HashMap previousValues	= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
	if(previousValues!=null)
	{
		Set setValues 		 = previousValues.keySet();
		Iterator iterator 	 = setValues.iterator();
		// At the most there will be only one record for the caresets
		for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		{
			entryValue = ((String)iterator.next()) ;
			keyItems	= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
			if( keyItems[0].equals("ck"))     // If it is a check Box
			{
				care_set_value = keyItems[1];
				care_set_order = (String)previousValues.get("h1"+keyItems[1]) ;
				if(care_set_order.equalsIgnoreCase("CS") || care_set_order.equalsIgnoreCase("PH"))
					care_set_value = "Y";
				else
					care_set_value = "N";
			}
		} // End of for
	} // End of if
%>
<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ="careSetButtonForm" id ="careSetButtonForm">
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tr>
				
				<td class="white" align="right">
					<!-- IN064543 start --><input type="button" name="instrnBtn" id="instrnBtn" class="BUTTON" value =" <fmt:message key='eOR.Instruction.label' bundle='${or_labels}'/>" onClick='openInstructionModalForOrderSet("<%=care_sets %>","<%=order_catalog_nature %>","<%=order_category%>","<%=bean_id%>","<%=bean_name%>","<%=encounter_id%>","<%=patient_class%>","<%=admission_date%>","<%=discharge_date_time%>","<%=practitioner_type%>")' <%=enbDis%>><!-- IN064543 end -->
					<input type="button" name="select" id="select" class="BUTTON" value =" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%> " onClick="setCareSet()">
			 	</td>
			 </tr>
		</table>
		<input type="hidden" name="care_set_check_box_val" id="care_set_check_box_val" value="<%=care_set_value%>">
		<input type="hidden" name="check_box_val" id="check_box_val" value="N">

		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="ck<%=care_sets%>" id="ck<%=care_sets%>" value="Y">
		<input type="hidden" name="h1<%=care_sets%>" id="h1<%=care_sets%>" value="<%=order_category%>">
		<input type="hidden" name="h2<%=care_sets%>" id="h2<%=care_sets%>" value="<%=care_sets%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
	</form>
<%
	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);	
%>
</body>
</html>

