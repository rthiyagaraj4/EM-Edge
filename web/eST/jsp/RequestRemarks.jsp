<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/Request.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

		<script>
			function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
		</script>

		<title><fmt:message key="eST.RequestRemarks.label" bundle="${st_labels}"/></title>
</head>
<%
		String bean_id				=		"requestBean";
	    String bean_name			=		"eST.RequestBean";
		RequestBean bean			=		(RequestBean) getBeanObject(bean_id, bean_name,request); 
		bean.setLanguageId(locale);
		String remarks			=		 bean.checkForNull(bean.getHdrRemarks_Desc(),"");
		
		//System.out.println("remarks===>" +remarks);
		    //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/FEB/2013
			String visibility				=		"visibility:hidden";
			String hdr_remarks_rd = bean.checkForNull((String)bean.fetchRecord("SELECT HDR_REMARKS_REQD FROM ST_TRN_TYPE_FOR_REMARKS WHERE TRN_TYPE ='REQ'").get("HDR_REMARKS_REQD"),"N");
			if(hdr_remarks_rd.equals("Y"))
			visibility				=		"visibility:visible";
	%>
<body onload='FocusFirstElement();'>
	<form name= "formRequestRemarks" id="formRequestRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="hdr_remarks_desc" id="hdr_remarks_desc" rows="3" cols="40" onKeyPress="return false;" readonly><%=remarks%></textarea>&nbsp;<input type="hidden" name="hdr_remarks_code" id="hdr_remarks_code" value = "<%=bean.getHdrRemarks_Code()%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(hdr_remarks_code,hdr_remarks_desc);"><img src="../../eCommon/images/mandatory.gif"  style="<%=visibility%>" >
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  colspan="2"><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		 <input type="hidden"	name="bean_trans_type" id="bean_trans_type"						value= "">
		 <input type="hidden"	name="hdr_remarks_rd" id="hdr_remarks_rd"				        value="<%=hdr_remarks_rd%>">
		
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

