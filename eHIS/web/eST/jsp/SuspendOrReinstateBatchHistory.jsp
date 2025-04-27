<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/SuspendOrReinstateBatch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"

    </script>
	<title><fmt:message key="eST.BatchStatusHistory.label" bundle="${st_labels}"/></title>
</head>
<%
		//boolean editMode = false;
		String bean_id = "SuspendOrReinstateBatchBean";
		String bean_name = "eST.SuspendOrReinstateBatchBean";
		//String facility_id = (String) session.getValue("facility_id");	

		String item_code = request.getParameter("item_code").trim();
        String item_desc = request.getParameter("item_desc").trim();
        String uom_desc = request.getParameter("uom_desc").trim();
        String manufacturer_name = request.getParameter("manufacturer_name").trim();

		String batch_id = request.getParameter("batch_id").trim();
		String expiry_date = request.getParameter("expiry_date").trim();
        String trade_name = request.getParameter("trade_name").trim();

		SuspendOrReinstateBatchBean bean = (SuspendOrReinstateBatchBean) getBeanObject(bean_id,  bean_name, request );  
		bean.setLanguageId(locale);
		ArrayList alTemp = new ArrayList();
		
		alTemp = bean.getBatchHistoryRecords(item_code,batch_id,com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale));
		int flag=0;
		String classValue			= "";

	%>
<body onload='FocusFirstElement();'>
	<form name= "formSuspendOrReinstateRemarks">
	<br>
	

    <table border="0" cellpadding=0 cellspacing=0 align=center width='100%' height=20>

	<tr>
		<td class=ITEMSELECT    nowrap > <b><fmt:message key="Common.item.label" bundle="${common_labels}"/>:&nbsp;</b><%=item_desc%></td>
        <td class=ITEMSELECT   nowrap > <b><fmt:message key="Common.uom.label" bundle="${common_labels}"/>:&nbsp;</b><%=uom_desc%></td>
		<td class=ITEMSELECT      nowrap > <b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>:&nbsp;</b><%=batch_id%></td>
    </tr>
    <tr><td class=ITEMSELECT colspan=3>&nbsp;</td></tr>
	<tr>
		<td class=ITEMSELECT     nowrap > <b><fmt:message key="eST.Expiry/ReceiptDate.label"
		bundle="${st_labels}"/>:&nbsp;</b><%=expiry_date%></td>

        <td class=ITEMSELECT      nowrap > <b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>:&nbsp;</b><%=trade_name%></td>
     	<td class=ITEMSELECT     nowrap > <b><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/>:&nbsp;</b><%=manufacturer_name%></td>
	</tr>

	</table>

	<table border='1' cellpadding='0' cellspacing='0' width='100%' align=center>

		<th align=center><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		<th align=center><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<!-- Added by Rabbani #Bru-HIMS-CRF-111[INC NO:30070] on 22-AUG-2013 --> 
		<th align=center><fmt:message key="eST.Facility.label" bundle="${st_labels}"/></th>
		<th align=center><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th align=center><fmt:message key="eST.UserInfo.label" bundle="${st_labels}"/></th>
		<th align=center><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>

		<% 
			HashMap hmTemp = new HashMap();
			for(int i=0;i<alTemp.size();i++ ){  
            hmTemp = (HashMap)alTemp.get(i);
			if(flag%2==0)
				classValue="QRYEVEN";
			else 
				classValue="QRYODD";

        %>
        <tr>
			<td class="<%=classValue%>"  width='15%'>
			<%
			String added_date="";
			added_date=(String)hmTemp.get("ADDED_DATE");
	        added_date=com.ehis.util.DateUtils.convertDate(added_date,"DMYHM","en",locale);
			 String remarks="";
		    remarks=(String)hmTemp.get("REMARKS");
			//remarks=com.ehis.util.DateUtils.convertDate(remarks,"DMY","en",locale);
			
		     %>
			<label style="font-family:verdana;font-size:10"><%=bean.checkForNull(added_date)%></label>&nbsp;</td>
			<td class="<%=classValue%>"  width='10%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmTemp.get("BATCH_STATUS"))%></label>&nbsp;</td>
			<td class="<%=classValue%>"  width='12%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmTemp.get("FACILITY_NAME"),"All")%></label>&nbsp;</td>
			<td class="<%=classValue%>"  width='10%' ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmTemp.get("STORE_DESC"),"All")%></label>&nbsp;</td>
			<td class="<%=classValue%>" ><label style="font-family:verdana;font-size:10"><%=bean.checkForNull((String)hmTemp.get("USER_NAME"))%><BR><%=bean.checkForNull((String)hmTemp.get("STATUS_REMARKS_OTH"))%></label>&nbsp;</td>	
			<!--<td class="<%=classValue%>" ><label style="font-family:verdana;font-size:10">
			<%=bean.checkForNull(remarks)%></label>&nbsp;</td> -->
			<td class="<%=classValue%>" align="left" style="font-size:7pt;WORD-BREAK:BREAK-ALL;"><%=bean.checkForNull(remarks,"&nbsp;")%></td>
         </tr>

        <% flag++ ; } %>
	</table>

		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
        <input type="hidden" name="batch_id" id="batch_id" value="<%=batch_id%>">
		<input type="hidden" name="expiry_date" id="expiry_date" value="<%=expiry_date%>">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

