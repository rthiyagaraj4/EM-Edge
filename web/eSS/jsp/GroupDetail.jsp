<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import="eSS.GroupItemBean" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="alGroupList" scope="session" class="java.util.ArrayList"/>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<%
			request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>		
		<script language="javascript" src="../../eSS/js/Group.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	GroupItemBean bean = (GroupItemBean)getBeanObject( "groupItemBean", "eSS.GroupItemBean" , request);  
	bean.clear();
	bean.setLanguageId(locale);
	String index			=	bean.checkForNull(request.getParameter("index"),"-1");
	String strButtonLegend	=	"  Add  ";
	String mode				=	index.equals("-1")? bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");
	String disabled			=	"";
	String codeDisabled		=	"";
	//if((request.getParameter("group_code"))!=null && (bean.isDisabledGroupCode(request.getParameter("group_code"))||bean.trayExists(request.getParameter("group_code")))) //Commented by Sakti against ML-BRU-SCF-0775.1[INC#44128]
	if((request.getParameter("group_code"))!=null && (bean.isDisabledGroupCode(request.getParameter("group_code")) ))	
		disabled			=	"disabled";
	if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
		bean.initialize((HashMap)alGroupList.get(Integer.parseInt(index)));
		strButtonLegend	="Modify";
		codeDisabled="disabled";
	}
		putObjectInBean("groupItemBean", bean ,request);
%>

	<body onMouseDown="CodeArrest();" >
		<form name="formGroupDetail" id="formGroupDetail">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' >
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center'>
				

				<tr>

					<td align="right" class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td><td>&nbsp;<input type='text' name="item_desc" id="item_desc" value="<%=bean.getDescription()%>" maxLength='40' size='20' <%=disabled%> <%=codeDisabled%> ><input type='button' class='BUTTON' value='?' onClick="searchItem(item_code,item_desc);" <%=disabled%> <%=codeDisabled%> name='item_search_button'>&nbsp;<%=bean.getMandatoryImageTag()%><input type="hidden" name="item_code" id="item_code" value="<%=bean.getItem_code()%>"></td>
		
				</tr>	

				<tr>
					<td align="right" class="label"><fmt:message key="eSS.ItemQty.label" bundle="${ss_labels}"/></td><td>&nbsp;<input type='text' name="item_qty" id="item_qty" value="<%=bean.getItem_qty()%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" <%=disabled%>   class="NUMBER">&nbsp;<%=bean.getMandatoryImageTag()%></td>
				
					<td align="center" class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="fnCancel();" value="Cancel" <%=disabled%>>					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index" value="<%=index%>">
			<input type='hidden' name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP")%>">
		</form>
	</body>
</html>




