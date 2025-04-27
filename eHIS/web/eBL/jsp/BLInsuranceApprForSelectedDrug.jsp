
<%@ page import="java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.net.URLEncoder,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");

String sel_drug_code = "", sel_drug_desc = "", sel_drug_chk = "N", IPYN = "N", DCYN = "N", OPYN = "N", EMYN = "N", ALLYN = "N";
HashMap sel_drug_list = new HashMap();

try
{
	sel_drug_code = request.getParameter("sel_drug_code");
	if(sel_drug_code == null) sel_drug_code = "";

	sel_drug_desc = request.getParameter("sel_drug_desc");
	if(sel_drug_desc == null) sel_drug_desc = "";
	
	sel_drug_list = (HashMap) session.getAttribute("sel_drug_list");
	System.err.println("sel_drug_list in BLInsuranceApprForSelectedDrug.jsp:"+sel_drug_list);
	if(sel_drug_list != null) {
		Iterator itr = sel_drug_list.keySet().iterator();
		while (itr.hasNext())
		{
			String key = (String) itr.next();
			String value = (String) sel_drug_list.get(key);
			if(key.equals(sel_drug_code)){
				String[] val1 = value.split("~");
				sel_drug_chk = val1[2];
				IPYN = val1[3];
				DCYN = val1[4];
				OPYN = val1[5];
				EMYN = val1[6];
				ALLYN = val1[7];
			}
		}
	}	
%>

<link rel='StyleSheet' href='../../eCommon/html/'<%=sStyle%>'' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLInsuranceApprDrugs.js"></script>
<script language="JavaScript" src="../../eBL/js/BLInsuranceApprDrugsList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

	
<form name="Insurance_BlngLinkForm" id="Insurance_BlngLinkForm"  action="../../servlet/eBL.BLInsuranceBlngLinkServlet" method="post" target="messageFrame">

<table  width='100%' border=0 >
	<tr>
		<td class='NONURGENT' align="right">
			&nbsp;
		</td>
	</tr>
</table>  
	
<table cellpadding=3 cellspacing=0 width="75%" align="center" border=1 id="ApprovedDrugsTable" class='grid' >
	<tr>
		<td class='COLUMNHEADER'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
		<td class='COLUMNHEADER'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
		<!-- <td class='COLUMNHEADER'><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></th> -->
		<td class='COLUMNHEADER'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></th>
		<td class='COLUMNHEADER'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></th>
		<td class='COLUMNHEADER'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></th>
		<td class='COLUMNHEADER'><fmt:message key="Common.EM.label" bundle="${common_labels}"/></th>
		<td class='COLUMNHEADER'><fmt:message key="Common.all.label" bundle="${common_labels}"/></th>	
	</tr>

	<tr>
		<td class='gridData'>
			<%=sel_drug_code%>
			<input type='hidden' name='sel_drug_code' id='sel_drug_code' value="<%=sel_drug_code%>">	
		</td>
		<td class='gridData'>
			<%=sel_drug_desc%>
			<input type='hidden' name='sel_drug_desc' id='sel_drug_desc' value="<%=sel_drug_desc%>">
			<input type='hidden' name='apprChk' id='apprChk' id='apprChk'  value="N">
		</td>	
<!--		
		<td class='gridData' width='10%'>
			<input type='checkbox' name='apprChk' id='apprChk' id='apprChk'  value="<%=sel_drug_chk%>" <%=("Y".equals(sel_drug_chk) ? "checked" : "")%>  
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'apprChk', sel_drug_desc);">
		</td>
-->		
		<td class='gridData' width='10%'>
			<input type='checkbox' name='chkIPPatClass' id='chkIPPatClass' id='chkIPPatClass' value="<%=IPYN%>" <%=("Y".equals(IPYN) ? "checked" : "")%>
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'IP', sel_drug_desc);" >
		</td>
		<td class='gridData' width='10%'>
			<input type='checkbox' name='chkDCPatClass' id='chkDCPatClass' id='chkDCPatClass' value="<%=DCYN%>" <%=("Y".equals(DCYN) ? "checked" : "")%>
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'DC', sel_drug_desc);" >
		</td>
		<td class='gridData' width='10%'>
			<input type='checkbox' name='chkOPPatClass' id='chkOPPatClass' id='chkOPPatClass' value="<%=OPYN%>" <%=("Y".equals(OPYN) ? "checked" : "")%>
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'OP', sel_drug_desc);" >
		</td>				
		<td class='gridData' width='10%'>
			<input type='checkbox' name='chkEMPatClass' id='chkEMPatClass' id='chkEMPatClass' value="<%=EMYN%>" <%=("Y".equals(EMYN) ? "checked" : "")%>
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'EM', sel_drug_desc);" >
		</td>
		<td class='gridData' width='10%'>
			<input type='checkbox' name='chkAllPatClass' id='chkAllPatClass' id='chkAllPatClass' value="<%=ALLYN%>" <%=("Y".equals(ALLYN) ? "checked" : "")%>
			onclick="chkApprAndPatClassSelDrug(this, sel_drug_code,'ALL', sel_drug_desc);" >
		</td>				
	</tr>				
</table>
</form>
</body>
</html>

<%

}catch (Exception e){
	System.err.println("Exception in BLInsuranceApprForSelectedDrug.jsp:"+e);
}

%>

