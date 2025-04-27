<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
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
    });
  });
</script>

<STYLE TYPE="text/css">

	A:active { 
		COLOR: blue; 
	}

	A:visited { 
		COLOR: blue; 
	}
	A:link { 
		COLOR: blue; 
	}
 
	</STYLE>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String mode	= request.getParameter("mode");
	String tabValue	= request.getParameter("tabvalue");
	String hidden="hidden";
	String value="&nbsp;";
	if(mode == null)mode="1";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	ArrayList orderCategory = new ArrayList();
	String classValue="";
	
%>
<form name="ordercataegorydtls" id="ordercataegorydtls">

<table class='grid' width='100%' height="100%">
	<%
					orderCategory=bean.getOrderCategory();
					String[] record=null;
					for(int i=0;i<orderCategory.size(); i++){
						classValue			=	( (i%2)==0 )? "gridData" : "gridData";
					record = (String [])orderCategory.get(i);
					String keyvalue=tabValue+"!!"+record[0];
					String keyvalue1=tabValue+"!!"+"C"+"!!"+record[0];
					//System.out.println("for modify key="+keyvalue1);
					//String accesssValue=bean.getValueForUpdate(keyvalue1);
					//System.out.println("for modify values="+accesssValue);
					String accesssValue=bean.getCategoryValue(keyvalue);
					//if(accesssValue1!=null) accesssValue=accesssValue1;
					//System.out.println("==="+accesssValue+"===");
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
	<td class='<%=classValue%>' width='70%'><font size=1><a class='gridLink' href='#' onClick='loadOrdertypes("<%=record[0]%>","<%=record[1]%>");'><%=((record[1].equals(""))?"&nbsp;":record[1])%></a></td>
	<td class='<%=classValue%>' width='30%'> 
	<select name='accessspecifier<%=i%>' id='accessspecifier<%=i%>' onchange='  saveChanged("<%=tabValue%>","<%=record[0]%>",this,"category","<%=i%>","<%=value%>");  changeSelectColor(this);' >
	<option value='defaultSelect' <%=accesssValue.equals("defaultSelect")?"selected":""%>><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<!-- 
		Modified by Kishore kumar N/Uma on 9/27/2009, for the CRF 641
	-->
	<option value='A' <%=accesssValue.equals("A")?"selected":""%> style='background-color:#FFFF00'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
	<!-- <option value='S' <%=accesssValue.equals("S")?"selected":""%> style='background-color:#9370DB'>S</option> -->
	<!--<option value='M' <%=accesssValue.equals("M")?"selected":""%> style='background-color:#90EE90'>M</option>-->
	<!-- <option value='N' <%=accesssValue.equals("N")?"selected":""%> style='background-color:#808080'>Not Applicable</option> -->
	<!-- ends here. -->
	</select><span style='Visibility:<%=hidden%>' id='a_cate<%=i%>'><a href='#' onClick='undoChanges("<%=tabValue%>","<%=record[0]%>","C","C","<%=value%>","<%=i%>");'>U</a></span><%hidden="hidden";%>	
	</td>
	</tr>
		<%}%>
</table>
<input type="hidden" name="tabValue" id="tabValue" value="<%=tabValue%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">

</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

