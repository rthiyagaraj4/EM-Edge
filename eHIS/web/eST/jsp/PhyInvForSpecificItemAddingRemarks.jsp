<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/PhyInvForSpecificItem.js"></script>
	<!--<script language='javascript' src="../../eST/js/StMessages.js"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<%
		String rem_val							=		"";
		if ( request.getParameter("show").equals("yes"))
		{
			String facility_id					=		(String)session.getValue("facility_id");
			String bean_id						=		"PhyInvForSpecificItemBean";
			String bean_name					=		"eST.PhyInvForSpecificItemBean";
			
			PhyInvForSpecificItemBean bean		=		(PhyInvForSpecificItemBean) getBeanObject(bean_id,bean_name,request);
			bean.setLanguageId(locale);
			String temp_id						=		 bean.checkForNull(request.getParameter("temp_id"),"");
			bean.setFacility_id(facility_id);
			bean.setTemp_phy_id(temp_id);

			rem_val								=			bean.getRemarks();

			putObjectInBean(bean_id,bean,request);
		}
	
%>
	


	</head>
<body>
<form name="FormPhyInvForSpecificItemAddingRemarks" id="FormPhyInvForSpecificItemAddingRemarks" >
<div >
<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height=40>
	<tr>
		<td   class="label" width=100 ></td>
		<td   class="label" width=100><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td   class="fields"><input type="text" size=50 name="remarks" id="remarks" value="<%=rem_val%>" onKeyPress="return false;"><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
		<td   class="label" width=200></td>
</table>
</div>
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="VAR">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
</form>

</body>
</html>

