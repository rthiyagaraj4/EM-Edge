<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList, eSS.*, eSS.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/SurgeryType.js"></script>	
	
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()">
	<%
		String	mode			=	request.getParameter( "mode" ) ;
		String	bean_id			=	"surgeryTypeBean" ;
		String	bean_name		=	"eSS.SurgeryTypeBean";
		String disabled			=	"";
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		SurgeryTypeBean bean = (SurgeryTypeBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
		 bean.setLanguageId(locale);
		//Added by sakti against KDAH_CRF_0247
		 String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
		if(surg_nature_link_to_OT_yn.equals("N")){
			disabled = "disabled";
		}
		//Added ends
%>
<form name="formSurgeryType" id="formSurgeryType" id="Surgery Type Form" >
	<table border="0" cellpadding="100" cellspacing="0" width='100%' align='center' height='100%' >
	<tr>
	<td width='100%' align='center'  class="WHITE">	
		<table cellpadding="0" cellspacing="0" align="center" border=1 id='mySelTable'>
		<tr>
			<th align="center" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></th>
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
			 <TR>
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="code_<%=cnt %>" id="code_<%=cnt %>"  size="15" maxlength="15" class="UPPER" onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
					
				</td>		
			
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="long_desc_<%=cnt %>" id="long_desc_<%=cnt %>"  size="42" maxlength="40" onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="short_desc_<%=cnt %>" id="short_desc_<%=cnt %>" size="20" maxlength="15" onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<!-- Added By Sakti against KDAH-CRF-0247 -->
				<td align="center" class="<%=classValue %>" >
					<input type="text" name="surg_name_<%=cnt %>" id="surg_name_<%=cnt %>" size="20" maxlength="15" onBlur="makeValidString(this);resetColorCode(this);" <%=disabled %> onkeydown="return isNumberKey(event);">
					<input type='button' class='BUTTON' value='?' onClick="callNatureTypeSearchWindow(surgery_type_search_<%=cnt %>, surg_name_<%=cnt %>);"  name="surgery_name_search<%=cnt %>" <%=disabled %> onkeydown="return isNumberKey(event);">
					<input type="hidden" name="surgery_type_search_<%=cnt %>" id="surgery_type_search_<%=cnt %>" value="">
				</td>	
				
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="eff_status_<%=cnt %>" id="eff_status_<%=cnt %>" value="E" checked onkeydown="return isNumberKey(event);"> 
				</td>
			</tr>
	<%
		}
	%>	
	
		</table>
			
	</td>
	</tr>
</table>
<script>
	document.formSurgeryType.code_0.focus() ;
</script>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=max_rows%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="surg_nature_link_to_OT_yn" id="surg_nature_link_to_OT_yn" value="<%=surg_nature_link_to_OT_yn%>">
	
</form>
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>
 

