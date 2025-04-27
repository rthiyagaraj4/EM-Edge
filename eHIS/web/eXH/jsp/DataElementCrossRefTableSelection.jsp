<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencetable.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form" target='appltablecode' action='../../eXH/jsp/DataElementCrossRefModuleCodeSetup.jsp'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
		<td width='45%'></td>
		<td width='45%'></td>
		<td width='10%'></td>
</tr>
<tr>
<td class=label align=left><fmt:message key="Common.Table.label" bundle="${common_labels}"/>
<%
Connection con=null;
XHSelectQuery xhSelect = null;
ArrayList arrRow = null,arrCol = null;
HashMap hashmpParams = null;
String applicationid = request.getParameter("application");
String sql = " select DISTINCT b.master_code_desc ,  "+
" to_char(a.medicom_master ) MEDICOM_MASTER,  "+
" a.MEDICOM_MODULE_ID , a.FACILITY_BASED_YN  "+
" from xh_element_crossref_lang_vw a, sm_master_code b, xh_appl_element c "+
" where a.medicom_master = b.master_code "+
" AND a.medicom_module_id = b.module_id "+
" AND a.LANGUAGE_ID='"+locale+"' "+
" AND a.element_id   = c.element_id "+
" AND c.application_id = '"+applicationid+"' "+
" AND c.in_use_yn  = 'Y' "+
" AND a.in_use_yn = 'Y' "+
" AND a.crossref_type  IN ('H','U') "+
" AND c.format_type in ('H','S') "+
" UNION "+
" select  DECODE (A.ELEMENT_ID, 'PATIENTCLASS', 'Patient class', "+
"   'PRIMARYLANGUAGE','Primary Language', "+
"   'FACILITY','Facility', "+
"   'ALLERGYREACT','Allergy Reaction', "+
"   'RXRROUTE','RXR-Route', "+
"   'RXEDOSAGEFORM','Dosage Form', "+
"   'ORDERSTATUS','Order Status', "+
"   'PERFORMLOC','Performing Locations', "+
"   'DISCRMSR','Discrete Measures', "+
"   'OBRIDORDCATALOG','Observation Identifier - Order Catalog') master_code_desc , "+
"    To_char(a.medicom_master ) MEDICOM_MASTER,  "+
" a.MEDICOM_MODULE_ID , a.FACILITY_BASED_YN  "+
"    from xh_element_crossref_lang_vw a,  xh_appl_element c "+
"   where "+
"    a.element_id   = c.element_id "+
"   AND c.application_id = '"+applicationid+"'"+
"   AND c.in_use_yn  = 'Y' "+
"   AND a.in_use_yn = 'Y' "+
"   AND a.crossref_type  IN ('H','U') "+
"   AND c.format_type in ('H','S') "+
"  AND a.LANGUAGE_ID='"+locale+"' "+
"  and ( a.medicom_master = '99' or a.medicom_master = '98' or a.medicom_master = '97') "+
" ORDER BY master_code_desc  ";
 
try
{

//System.out.println("(DataElementCrossRefTableSelection.jsp :sqlQuery) "+sql);
con=ConnectionManager.getConnection(request);
xhSelect = new XHSelectQuery();
hashmpParams = new HashMap(5);
hashmpParams.put("connection",con);
hashmpParams.put("sql",sql);
hashmpParams.put("col","4");
arrRow = xhSelect.getResults(hashmpParams);
arrCol = null;	
xhSelect = null;
hashmpParams.clear();


}catch(Exception e1)
{
	System.out.println("(DataElementCrossRefTableSelection.jsp:exception-1) :"+e1.toString());
}
%>
<select name='modulemaster' id='modulemaster' onChange='funSelect(this)'>
<option>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------</option>
<%
for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);
%>

	<option moduleid='<%=arrCol.get(2)+""%>' facility_based_yn='<%=arrCol.get(3)+""%>' value='<%=arrCol.get(1)+""%>'><%=arrCol.get(0)+""%></option>
<%
}
%>
</select><img src='../../eCommon/images/mandatory.gif' align=middle> </td>
<td align='middle' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/>
<%

sql = "SELECT DISTINCT  X.FACILITY_ID fac,Y.FACILITY_NAME facname FROM  XH_APPL_FOR_FACILITY  "+ 
" X,sm_facility_param_lang_vw Y WHERE X.FACILITY_ID=Y.FACILITY_ID and LANGUAGE_ID='"+locale+"'";

hashmpParams = new HashMap(5);
hashmpParams.put("connection",con);
hashmpParams.put("sql",sql);
hashmpParams.put("col","2");
xhSelect = new XHSelectQuery();
arrRow = xhSelect.getResults(hashmpParams);
arrCol = null;	
xhSelect = null;

%>
<select name='facilityid' id='facilityid' onChange='funFacility(this)'>
<option value=''>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------</option>
<%
for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);
%>
<option value='<%=arrCol.get(0)+""%>'><%=arrCol.get(1)+""%></option>

<%
}
%>
</td>
<td>
<input type=button class='button'  name='butt_select' id='butt_select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funMasterCode()'>
</td>

<%
try
{
arrRow.clear();
arrCol.clear();
ConnectionManager.returnConnection(con);
}catch(Exception e1)
{
		System.out.println("(DataElementCrossRefTableSelection.jsp:exception-2) :"+e1.toString());
}
%>
</tr>
<tr>
<td></td>
<td> </td>
<td></td>
</tr>
</table>
<input type=hidden name='mastertableid' id='mastertableid' value=''>
<input type=hidden name='moduleid' id='moduleid' value=''>
<input type=hidden name='facilitybased' id='facilitybased' value=''>
<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
</form>

</BODY>
</HTML>

