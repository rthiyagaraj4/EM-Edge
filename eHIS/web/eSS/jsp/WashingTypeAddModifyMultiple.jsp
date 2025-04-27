<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	
	<script language="javascript" src="../../eSS/js/WashingType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();"  onMouseDown='CodeArrest();' >
<%
		String mode;
		String bean_id;
		String bean_name;
		
		mode	= request.getParameter( "mode") ;
		if ( mode == null || mode.equals("")) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return ;

		bean_id = "WashingTypeBean" ;
		bean_name = "eSS.WashingTypeBean";
		WashingTypeBean bean = (WashingTypeBean)getBeanObject( bean_id, bean_name, request) ;  
		bean.clear() ;
		bean.setMode( mode) ;
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	%>
		
<form name="formWashingType" id="formWashingType" >
	<table border="0" cellpadding="100" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
		<table cellpadding="0" cellspacing="0" align="center" border=1>
		<tr>
			<th align="center" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
		%>
		 <tr>                                         
			<td align="center" class="<%=classValue %>" >
				<input type="text" name="code_<%=cnt %>" id="code_<%=cnt %>"  size="8" maxlength="8" class="UPPER" onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
			</td>                                    
			<td align="center" class="<%=classValue %>" >
				<input type="text" name="long_desc_<%=cnt %>" id="long_desc_<%=cnt %>"  size="42" maxlength="40" onBlur="makeValidString(this);resetColorCode(this);">
			</td>                                    
			<td align="center" class="<%=classValue %>" >
				<input type="text" name="short_desc_<%=cnt %>" id="short_desc_<%=cnt %>" size="20" maxlength="15" onBlur="makeValidString(this);resetColorCode(this);">
			</td>                                    
			<td align="center" class="<%=classValue %>">
				<input type="checkbox" name="eff_status_<%=cnt %>" id="eff_status_<%=cnt %>" value="E" checked>
			</td>
		</tr>
		<%
			}
		%>
		</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">	
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=max_rows%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>"
</form>

<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

