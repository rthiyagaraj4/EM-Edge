<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"  %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<html>
    <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryDecisionSupport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eOR.MultiSelect.label" bundle="${or_labels}"/></title>
	<script>
		
	</script>
    </head>
    <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
    <form name="OrderFormatMultiSelectForm" id="OrderFormatMultiSelectForm" method="post">
     <%

	    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Properties properties			= (Properties) session.getValue( "jdbc" );
			
	    beanQueryObj.setLanguageId(localeName);
		//Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String	  order_category		= beanQueryObj.checkForNull(request.getParameter("order_category"),"");	
		String	  catalog_code=beanQueryObj.checkForNull(request.getParameter("catalog_code"),"") ;
 		String	  field_mnemonic		= beanQueryObj.checkForNull(request.getParameter("field_mnemonic"),"");	
		String	  contr_msr_panel_id	= beanQueryObj.checkForNull(request.getParameter("contr_msr_panel_id"),"");	
		String	  contr_msr_mod_id		= beanQueryObj.checkForNull(request.getParameter("contr_msr_mod_id"),"");	
		String	  order_type_code		= beanQueryObj.checkForNull(request.getParameter("order_type_code"),"");	
		String	  discr_msr_id			= beanQueryObj.checkForNull(request.getParameter("discr_msr_id"),"");	
		String	  performing_facility_id= beanQueryObj.checkForNull(request.getParameter("performing_facility_id"),"");
		String	  login_facility_id		= beanQueryObj.checkForNull(request.getParameter("login_facility_id"),"");	
 		String	  sex					= beanQueryObj.checkForNull(request.getParameter("sex"),"");	
 
		String	  lab_install_yn		= beanQueryObj.checkForNull(request.getParameter("lab_install_yn"),"");	
		String	  bt_install_yn		= beanQueryObj.checkForNull(request.getParameter("bt_install_yn"),"");	
		String	  rd_install_yn		= beanQueryObj.checkForNull(request.getParameter("rd_install_yn"),"");	
		String	  ot_install_yn		= beanQueryObj.checkForNull(request.getParameter("ot_install_yn"),"");	

		String	  multi_list_code	= beanQueryObj.checkForNull(request.getParameter("multi_list_code"),"");	

  		String records[]	  = null;
     	ArrayList OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id, sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
%>
  <table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
<%  if(!field_mnemonic.equals("")) {  %>
  <tr>
		<th colspan='6'><%=field_mnemonic%></th>	
  </tr>
<%	} %>
 <tr>

<%		
		int		k = 0;
		if(OrderFormatList.size()>0) {
			for( k=0; k<OrderFormatList.size(); k++)
			{
%>
				<td class="LABEL">
<%				records = (String[])OrderFormatList.get(k);
%>				<font size='1' color='black'><b><%=records[1]%></b></font>
				</td>
				<td class="LABEL" width="5%">
					<input type="checkbox" name="chk_<%=k%>" id="chk_<%=k%>" value="<%=records[0]%>">
				</td>
<%				
				if(k!= 0 && k%3==2)
				{
%>
					</tr><tr>
<%			}
				records	= null;
			} // End of for
			OrderFormatList.clear();
			OrderFormatList = null; //Nullifying the objects
		} else { 
%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));</script>
<%			} %>
		<input type="hidden" name="total_rows" id="total_rows" value="<%=k%>">
 </table>
 <script>
	previousValuesSelect("<%=multi_list_code%>")
 </script>
</form>
</body>
</html>

