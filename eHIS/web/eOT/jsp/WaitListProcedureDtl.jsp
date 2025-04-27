<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*"%>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*"
%>


<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</link>
	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<!-- 	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>
<body >
<form name='wait_existing_order_hdg' id='wait_existing_order_hdg'>
<!--<table border="1" cellpadding="0" cellspacing="0" width="100%">
<tr> <td align='left' class='CAGROUPHEADING'>Operations/Procedures</td>
</tr></table>-->
<table  border='1' cellpadding='3' cellspacing='0'  width='100%' >
	<tr>
		<td class='columnHeaderCenter' width='25%' ><fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/></td>
		<td class='columnHeaderCenter' width='45%' ><fmt:message key="eOT.OperationDescription.Label" bundle="${ot_labels}"/></td>	
		<td class='columnHeaderCenter' width='20%' ><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></td>		 
		<td class='columnHeaderCenter' width='10%' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
	</tr>

<%
String strOperationDesc="";
String strRightLeftFlag="";
String strOperationCode="";

String sql="";

String strFacilityId="";
String strWaitListNum="";
String strOperDurn="";

String strQuery="";


int fetchCount=0;

strFacilityId=CommonBean.checkForNull(request.getParameter("facility_id"));
strWaitListNum=CommonBean.checkForNull(request.getParameter("waitlist_no"));

Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

try
{
conn = ConnectionManager.getConnection(request);


//sql="SELECT A.OPER_CODE OPER_CODE1, B.SHORT_DESC SHORT_DESC1, DECODE(NVL(A.APPL_RIGHT_LEFT_FLAG,'N'), 'R', 'Right Side', 'L', 'Left Side', 'B', 'Bilateral', 'N', 'Not Applicable') RIGHT_LEFT_FLAG_DESC1,to_char(a.OPER_DURN,'hh24:mi') OPER_DURN1  FROM     OT_WAITLISTING_DTL A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID = ? AND       A.WAITLIST_NUM = ?  AND A.OPER_CODE  = B.OPER_CODE";
sql="SELECT A.OPER_CODE OPER_CODE1, B.LONG_DESC LONG_DESC1, DECODE(NVL(A.APPL_RIGHT_LEFT_FLAG,'N'), 'R', 'Right Side', 'L', 'Left Side', 'B', 'Bilateral', 'N', 'Not Applicable') RIGHT_LEFT_FLAG_DESC1,to_char(a.OPER_DURN,'hh24:mi') OPER_DURN1  FROM     OT_WAITLISTING_DTL A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID = ? AND       A.WAITLIST_NUM = ?  AND A.OPER_CODE  = B.OPER_CODE"; //MMS-CRF-199
pstmt=conn.prepareStatement(sql);
pstmt.setString(1,strFacilityId);
pstmt.setString(2,strWaitListNum);
rs=pstmt.executeQuery();

//eOT.LogFile.log("OTDebugger","sql"+sql,this);
//eOT.LogFile.log("OTDebugger","FacilityId"+strFacilityId,this);
//eOT.LogFile.log("OTDebugger","waitListNo"+strWaitListNum,this);



while(rs.next())
{
fetchCount++;
strOperationCode=CommonBean.checkForNull(rs.getString("OPER_CODE1"));
strOperationDesc=CommonBean.checkForNull(rs.getString("LONG_DESC1")); //MMS-CRF-199
strRightLeftFlag=CommonBean.checkForNull(rs.getString("RIGHT_LEFT_FLAG_DESC1"));
strOperDurn=CommonBean.checkForNull(rs.getString("OPER_DURN1"));
out.println("<td  '"+strQuery+"' align='left'>"+strOperationCode+"&nbsp;</td>");
out.println("<td  '"+strQuery+"' align='left'>"+strOperationDesc+"&nbsp;</td>");
out.println("<td  '"+strQuery+"' align='left'>"+strRightLeftFlag+"&nbsp;</td>");
out.println("<td  '"+strQuery+"' align='left'>"+strOperDurn+"&nbsp;</td>");


out.println("</tr>");

}
}catch(Exception ee)
{
	//eOT.LogFile.log("OTDebugger","Exception"+ee,this);
}
finally{
if(rs!=null) rs.close();
pstmt.close();
ConnectionManager.returnConnection(conn, request);	
}

%>	

</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

