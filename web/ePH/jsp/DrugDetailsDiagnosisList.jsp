<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

		String	bean_id			=	"DrugDetailsBean" ;
		String	bean_name		=	"ePH.DrugDetailsBean";

		DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id,bean_name, request ) ;
		String drug_code = bean.getDRUG_CODE();
		ArrayList DiagnosisList = bean.getDiagnosisList();
		HashMap hmRecord = null;
//bean.getDrugDetails();
%>
		<form name="DiscontinueDrugForm" id="DiscontinueDrugForm" >
			<BR>
			<table cellpadding="1" cellspacing="0" width="99%"  align="center" border="1">
<% 
				if(DiagnosisList!=null && DiagnosisList.size()>0){
%>
					<tr>
						<td  class="COLUMNHEADER"  nowrap width='20%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;</td>
						<td  class="COLUMNHEADER"  nowrap ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;</td>
					</tr>
<%
					//Object []DiagnosisListKeys = ((Set) DiagnosisList.keySet()).toArray();
					for(int i=0; i<DiagnosisList.size(); i++){
						hmRecord = (HashMap)DiagnosisList.get(i);
%>
						<tr>
							<td  class="label"  nowrap width='20%'><%=(String)hmRecord.get("TERM_SET")%>&nbsp;</td>
							<td  class="label"  nowrap ><%=(String)hmRecord.get("DIAG_DESC")%>&nbsp;</td>
						</tr>
<%
					}
				}
%>
			</table>
		</FORM>
	</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);
%>

