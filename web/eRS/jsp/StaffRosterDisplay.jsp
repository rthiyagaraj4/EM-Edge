<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Karabi S.
*	Created On		:	01 Dec 2004-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<script language="javascript" src="../js/StaffRoster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String p_mode=request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
String p_staff_id=request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
String p_role_type=request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
String function_id = request.getParameter( "function_id") ;
Connection Con			= null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String f_date="";
String t_date="";

Con=ConnectionManager.getConnection(request);
try
{
	String sql="select to_char(sysdate,'dd/mm/yyyy') date_fm,to_char(last_day(sysdate),'dd/mm/yyyy') date_to from dual";
	pstmt=Con.prepareStatement(sql);
	rset=pstmt.executeQuery();
	if(rset!=null)
	{
		while(rset.next())
		{
			f_date=rset.getString("date_fm");
			t_date=rset.getString("date_to");
		}
	}
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();
}
catch(Exception exp)
{
	out.println(exp.toString());
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(Con,request);
}
%>
<frameset rows='15%,0%,*'>
<iframe name='f_query__select' id='f_query__select'src='../../eRS/jsp/StaffRosterCriteria.jsp?p_mode=<%=p_mode%>&p_staff_id=<%=p_staff_id%>&p_role_type=<%=p_role_type%>' frameborder=no scrolling=no noresize style='height:15vh;width:100vw'></iframe>
<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style='height:15vh;width:100vw'></iframe>
<%
if(p_mode.equals("CA"))
{
%>
<iframe name='f_query_details' id='f_query_details' src='../../eRS/jsp/StaffRosterResultFrameset.jsp?staff_id=<%=p_staff_id%>&role_type=<%=p_role_type%>&mode=<%=p_mode%>&function_id=<%=function_id%>&from_date=<%=f_date%>&to_date=<%=t_date%>&new_todate=<%=t_date%>&next_fromdate=<%=f_date%>&onclick_of=S' frameborder=no noresize scrolling=auto style='height:0vh;width:100vw'></iframe>
<%
}
else
{
%>
<iframe name='f_query_details' id='f_query_details' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style='height:85vh;width:100vw'></iframe>
<%
}
%>
</frameset>
</html>

