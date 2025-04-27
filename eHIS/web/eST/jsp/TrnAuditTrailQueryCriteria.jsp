<!DOCTYPE html>
<%@ page import="eST.TrnAuditTrailBean,eST.Common.StRepository" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eST/js/TrnAuditTrail.js'></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript'  src='../../eCommon/js/CommonLookup.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body >
		<form name='formTrnAuditTrail' id='formTrnAuditTrail'>
		<%
			TrnAuditTrailBean bean	=	(TrnAuditTrailBean) getBeanObject( "trnAuditTrailBean","eST.TrnAuditTrailBean",request );
			bean.setLanguageId(locale);
		//	bean.clear();
		//	String mode = request.getParameter("mode");
		String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	

		%>
			<table border="0" cellspacing="0" width="100%" align=center>
				<tr>
					<td class="label"><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name="trn_type" id="trn_type" onchange="setTrnType(this);"><%=bean.getTrn_type_List()%></select></td>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name="doc_type_code" id="doc_type_code"><%=default_value%></select>  </td>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" ></td>
					</tr>
				<tr>
					<td class="label"><fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/></td>
					<td class='fields'><input type="text" maxLength=10 size=10 name="doc_date_from" id="doc_date_from" value= "<%=com.ehis.util.DateUtils.convertDate((String)bean.getSystemDate(),"DMY","en",locale)%>" >&nbsp;&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date_from');"></img> <%=bean.getImage("M")%></td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class='fields'>	<input type="text" maxLength=10 size=10 name="doc_date_to" id="doc_date_to" value="" >&nbsp;&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date_to');"></img></td>
					<td class="label"><fmt:message key="eST.DeletedBy.label" bundle="${st_labels}"/></td>
					<td class='fields'> <input type="text" name="deleted_by" id="deleted_by" value="" size=25 maxLength=60    align="centre"><input type="button" class="button" name="deleted_by_search" id="deleted_by_search" value="?" onClick="searchCode(deleted_by)" align="left"><input type="hidden" name="deleted_by_id" id="deleted_by_id" value="" ></td>
					
				</tr>
				<tr>
					<td  align="right" colspan="6">&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="searchDeletedDocsAuditLog();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"		value="trnAuditTrailBean">
			<input type="hidden" name="bean_name" id="bean_name"	value="eST.TrnAuditTrailBean">
			 <input type="hidden" name="sysdate" id="sysdate"	value="<%=com.ehis.util.DateUtils.convertDate((String)bean.getSystemDate(),"DMY","en",locale)%>">
			 <input type="hidden"	name="SQL_ST_DELETED_BY_USER" id="SQL_ST_DELETED_BY_USER"		value="<%=StRepository.getStKeyValue("SQL_ST_USER_LOOKUP_USERACCESS")%>">
			 <input type='hidden'	name="language_id" id="language_id"							value="<%=locale%>">
		
		</form>
	</body>
</html>

