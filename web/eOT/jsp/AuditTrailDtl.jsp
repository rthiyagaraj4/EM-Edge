<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	 String locale = (String)session.getAttribute("LOCALE");

	 request.setCharacterEncoding("UTF-8");
%>

<html>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript'  src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript'  src='../../eOT/js/Booking.js' ></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='auditTrail' id='auditTrail'>
		<table  border='1' width='100%' cellpadding=3 cellspacing=0 align="center">


<div id="tableContainer">
	<THEAD>
		<TR>
			<th nowrap> <fmt:message key="eOT.ChangeType.Label" bundle="${ot_labels}"/></th>
			<th nowrap> <fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></th>
			<th nowrap> <fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></th>
			<th align='left' nowrap><fmt:message key="Common.ChangeDescription.label" bundle="${common_labels}"/></th>
	  </TR>
	</THEAD>
</div>
<%	
	String strFacilityId=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String strChangeType="";
	String strUserId="";
	String strTransDate="";
	String strChangeDesc="";
	String strBookingNum="";
	String strQuery="";
/*
	String  Changetype_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ChangeType.Label","ot_labels")+",";
	 String  Doneby_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DoneBy.label","common_labels")+",";
	 String  ActionDateTime_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActionDateTime.label","common_labels")+",";
	 String  ChangeDescription_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChangeDescription.label","common_labels")+",";
	 String strLegends=Changetype_title+Doneby_title+ActionDateTime_title+ChangeDescription_title;
	 String strSizes="20,20,25,35";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="legends="+strLegends+"&sizes="+strSizes;

<div id="tableContainer">
	<THEAD>
		<TR>
			<th> <fmt:message key="eOT.ChangeType.Label" bundle="${ot_labels}"/></th>
			<th> <fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></th>
			<th> <fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ChangeDescription.label" bundle="${common_labels}"/></th>
	  </TR>
	</THEAD>
</div>

*/
	strBookingNum=checkForNull(request.getParameter("booking_no"));
	String sql="SELECT DECODE(CHANGE_TYPE,'P','Priority','S','Stage','T','Transfer','Q','Sequence') CHANGE_TYPE1, USER_ID USER_ID1, TO_CHAR(TRN_DATE,'DD/MM/YYYY HH24:MI') TRN_DATE1, CHANGE_DESC CHANGE_DESC1 FROM OT_BOOKING_CHANGE_LOG WHERE FACILITY_ID = ? AND APPT_REF_NUM = ? ORDER BY TRN_DATE";
	int fetchCount=0;
try{
	conn = ConnectionManager.getConnection(request);
    pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strFacilityId);
	pstmt.setString(2,strBookingNum);
	rs=pstmt.executeQuery();
while(rs.next()){
	fetchCount++;
	strChangeType=checkForNull(rs.getString("CHANGE_TYPE1"));
	strUserId=checkForNull(rs.getString("USER_ID1"));
	strTransDate=checkForNull(rs.getString("TRN_DATE1"));
	strTransDate=com.ehis.util.DateUtils.convertDate(strTransDate,"DMYHM","en",locale);
	strChangeDesc=checkForNull(rs.getString("CHANGE_DESC1"));
	if(fetchCount%2==0)	
		strQuery="class='gridData'";
	else
		strQuery="class='gridData'";
	out.println("<tr>");
	out.println("<td "+strQuery+"  width='20%' class='"+strQuery+"'  align='left' nowrap>"+strChangeType+"</td>");
	out.println("<td "+strQuery+"  width='20%' class='"+strQuery+"'  align='left' nowrap>"+strUserId+"</td>");
	out.println("<td "+strQuery+"  width='25%' class='"+strQuery+"'  align='left' nowrap>"+strTransDate+"</td>");
	out.println("<td "+strQuery+"  width='35%' class='"+strQuery+"'  align='left' nowrap>"+strChangeDesc+"</td>");
	out.println("</tr>");
}
	if(fetchCount==0)
		out.println("<script>callNoRecord();</script>");
}catch(Exception ee){
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
ConnectionManager.returnConnection(conn,request);
}
%>
 </table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</html>

