<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    			Name				Rev. Date		Rev. By			Description
----------------------------------------------------------------------------------------------------------------------------------
04/08/2017							Shazana hasan							        				MMS-DM-CRF-099.2(Added Look Up screen for GRN item label)
02/08/2017		MMS-DM-CRF-099.2			Shazana hasan		02/08/2017				Chandra				Newly Added ViewItemLabelGRNSCriteria.jsp for MMS-DM-CRF-099.2
------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>



<%@page
	import="java.util.*,eST.*,eST.Common.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	String bean_id = "goodsReceivedNoteBean";
	String bean_name = "eST.GoodsReceivedNoteBean";
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean) getBeanObject(bean_id,bean_name,request);
	bean.initStore_code_List("SQL_QRY_ST_GRN_STORE_SELECT");

	request.setCharacterEncoding("UTF-8"); 
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	bean.setLanguageId(locale);
	String sys_date=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();// Added for MMS-DM-CRF-099.2
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") 
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script> <!-- Added for Added for MMS-DM-CRF-099.2 -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>		
		<script language='javascript' src='../../eST/js/ViewItemLabelGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function doInit(){
	var val 	= window.dialogArguments;
	while(val.indexOf("~")!=-1)
		val = val.replace("~","'");
	while(val.indexOf("`")!=-1)
		val = val.replace("`","\n");

	document.getElementById('comments').value = val;
	document.getElementById('comments').focus();									   
}

function doClose(){
	this.window.returnValue = document.getElementById('comments').value;
	this.window.close();
}															    
</script>
<title>GRN Search</title>
</head>
<body> 
<form name="formViewGRNSCriteria" id="formViewGRNSCriteria">
<%
String strStDate = "", strEndDate = "";
String suppl_code="";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE-7,'DD/MM/YYYY') STDATE,TO_CHAR(SYSDATE,'DD/MM/YYYY') EDDATE FROM DUAL");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next()) 
	{
		strStDate = rs.getString(1);
		strEndDate = rs.getString(2);
	}
} 
catch (Exception e1) 
{
	e1.printStackTrace(System.err);
	System.out.println(" Error in Criteria Page " + e1.getMessage());
} 
finally 
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (con != null) ConnectionManager.returnConnection(con, request);
}
%>

<table cellpadding="0" cellspacing="0" width="90%" border="0">
<tr>
		

	<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td  class='fields'> &nbsp;&nbsp;<select name="store_code" id="store_code" onChange='AssignStoreCode(this)'><%=bean.getStore_code_List()%></select></td>
	
		
	<td  class="label"><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;&nbsp;<select name="supp_code" id="supp_code" onChange='AssignSupplier(this)'><%=bean.getSupp_code_List()%></select></td>
	
	
	<!-- <td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
	<td class=fields>
		<input maxLength=6 size=10 name="store_name" id="store_name">
		<input class="button" onClick="return searchCodeStore(store_code,store_name);" type="button" value="?">
		<input type="hidden" name="store_code" id="store_code" value=""/>
	</td> -->	
	
	<td class="label" nowrap align='left'>
		<fmt:message key="Common.periodfrom.label" bundle="${common_labels}" />
	</td>
	<td id='dtfrangeb'>
		&nbsp;
		<input type='text' name='from_date_time' id='from_date_time' value='<%=strStDate%>' size='10' maxLength='10' onBlur="checkSysdate(this, sysdate, '<%=locale%>');doDateCheckLocalfrom(this, to_date_time);" > <!-- Added for MMS-DM-CRF-099.2 -->
		<input type='image' id="frcal" name="frcal" id="frcal" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time')"> 
	</td>
	<td id='dtfrangec' class="label" nowrap align='left'>
		<fmt:message key="Common.periodto.label" bundle="${common_labels}" />											 
	</td>
	<td id='dtfranged'>
		&nbsp;
		<input type='text' name='to_date_time' id='to_date_time' " value='<%=strEndDate%>' size='10' maxLength='10' onBlur="checkSysdate(this, sysdate, '<%=locale%>');doDateCheckLocal(from_date_time, this);" > <!-- Added for MMS-DM-CRF-099.2 -->
		<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time')">
		<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
	</td>
	
	<td class='label' width='20%' align='right'>
		<input class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="frmdate()" type="button">
		&nbsp;
	</td>
</tr>
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=strEndDate%>'>
<input type='hidden' name='st_date' id='st_date' value='<%=strStDate%>'>
<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>"> 
 <input type="hidden" name="sysdate" id="sysdate"		value="<%=sys_date%>"><!--Added for MMS-CRF-0099.2-->

<input type="hidden" name="GRNradio" id="GRNradio"  value="P">

<input type="hidden" name="SQL_ST_ITEM_STORE_LOOKUP" id="SQL_ST_ITEM_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_STORE_LOOKUP")%>">
</form>
</body>
</html>

