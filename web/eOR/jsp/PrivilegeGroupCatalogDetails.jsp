<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
	<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
 function changeSelectColor(selectElement) {
	    if (selectElement.value === 'A') {
	      selectElement.style.backgroundColor = '#FFFF00'; // Yellow for 'Application'
	    } else {
	      selectElement.style.backgroundColor = '#FFFFFF'; // White for default
	    }
	  }
	  document.addEventListener('DOMContentLoaded', function () {
		    // Find all select elements with IDs matching the pattern 'accessspecifier<index>'
		    const selectElements = document.querySelectorAll("[id^='accessspecifier']");
		    selectElements.forEach(function (selectElement) {
		      if (selectElement.value === 'A') {
		        selectElement.style.backgroundColor = '#FFFF00'; // Yellow for default 'Applicable'
		      }
		      else {
		          selectElement.style.backgroundColor = '#FFFFFF'; // White for default
		        }
		    });
		  });

</script>

	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<%
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String order_category	   = request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String order_type	   = request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String tabValue	= request.getParameter("tabValue")==null?"":request.getParameter("tabValue");
	String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
	String hidden ="hidden";
	String value ="&nbsp;";
	String alp = request.getParameter("alp")==null?"":request.getParameter("alp");
	String limit_text = request.getParameter("limit_text")==null?"":request.getParameter("limit_text");
	//System.out.println("=555=="+order_category+"=="+order_type+"=="+alp+"=="+tabValue);


	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id , bean_name, request) ;
	bean.setLanguageId(localeName);
	ArrayList ordercatalog = new ArrayList();
	String classValue="";
	%>
<form name="detailLowerForm" id="detailLowerForm" >
	<table class='grid' width='100%'>
	
	<%
		ordercatalog=bean.getOrdercatalogs(order_category,order_type,alp,tabValue,limit_text);
		String[] record=null;
		if(ordercatalog.size()>0)
		{
			for(int i=0;i<ordercatalog.size(); i++)
			{
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				record = (String [])ordercatalog.get(i);
				if(record[0] == null) record[0] = "";
				if(record[1] == null) record[1] = "";
				if(tabValue.equalsIgnoreCase("AU"))
				{
					if(record[2] == null) record[2] = "";
					//System.out.println("record[2]"+record[2]);
				}
				String keyvalue=tabValue+"!!"+order_category+"!!"+order_type+"!!"+record[0];
				String keyvalue1=tabValue+"!!"+"I"+"!!"+record[0];
				//String accesssValue=bean.getValueForUpdate(keyvalue1);
				//System.out.println("key value"+keyvalue);
				String accesssValue=bean.getCatalogValue(keyvalue);
				if(accesssValue==null) accesssValue="X";
				value=accesssValue;
				if(mode.equals("2") && bean.getUpdateAllValues().containsKey(keyvalue1))
				{
					value=bean.getValueForUpdate(keyvalue1);
					if(!value.equals(accesssValue))
					hidden="visible";
				}
	%>	
	<tr>
	<td class='<%=classValue%>' width='70%'><font size=1><%=((record[1].equals(""))?"&nbsp;":record[1])%><%if(tabValue.equalsIgnoreCase("AU")){out.println((record[2].equals("Y"))?"*":record[2]);}%></td>
	<td class='<%=classValue%>' width='30%'>
	<select name='accessspecifier<%=i%>' id='accessspecifier<%=i%>' onchange='saveChanged("<%=tabValue%>","<%=record[0]%>",this,"catalog","<%=i%>","<%=value%>"); changeSelectColor(this);'>
	<option value='defaultSelect' <%=accesssValue.equals("defaultSelect")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<!-- 
		Modified by Kishore kumar N on Aug-17-09, for the CRF 641
	-->
	<option value='A' <%=accesssValue.equals("A")?"selected":""%> style='background-color:#FFFF00'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
	<!-- <option value='S' <%=accesssValue.equals("S")?"selected":""%> style='background-color:#9370DB'>S</option> -->
	<!--<option value='M' <%=accesssValue.equals("M")?"selected":""%> style='background-color:#90EE90'>M</option>-->
	<!-- <option value='N' <%=accesssValue.equals("N")?"selected":""%> style='background-color:#808080'>Not Applicable</option> -->
	<!-- ends here. -->
	</select><span style='Visibility:<%=hidden%>' id='a_cata<%=i%>'><a class='gridLink' href='#' onClick='undoChanges("<%=tabValue%>","<%=record[0]%>","I","I","<%=value%>","<%=i%>");'>U</a></span><%hidden="hidden";%>	
	</td>
	</tr>
	<script>
		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	</script>
		<%}}
	else
	{%>
	<script>
	var message=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
  parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
  </script>
	<%}%>
</table>

<INPUT TYPE="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<INPUT TYPE="hidden" name="tabValue" id="tabValue" value="<%=tabValue%>">
<INPUT TYPE="hidden" name="order_type" id="order_type" value="<%=order_type%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
</html>


