<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/10/2017      GHL-SCF-1161     Prathyusha P   Exploring a new responsibility: STAFF SCHEDULING. Not functioning properly.[IN063635]
---------------------------------------------------------------------------------------------------------------
 -->
 <%-- JSP Page specific attributes start --%>
<%@page import="org.jinterop.winreg.IJIWinReg.closeKey"%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<title><fmt:message key="eRS.ShiftPattern.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/ShiftPattern.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
</head>
<!-- Added for GHL-SCF-1161 start -->
<%String facility_id = (String)session.getAttribute("facility_id");

Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet resultSet		= null;
try{
   int	count =0;
	connection				= ConnectionManager.getConnection(request);
	pstmt = connection.prepareStatement("select count(*) as count from rs_parameter where facility_id=?");
	pstmt.setString(1,facility_id);
	
	resultSet = pstmt.executeQuery() ;
	while ( resultSet != null && resultSet.next() ) {
	count = resultSet.getInt("COUNT") ;
	  
	}
	System.out.println("count"+count); 

if(count>0){ %>
<!-- Added for GHL-SCF-1161 end -->
<iframe name='frameAddMod' id='frameAddMod' src='../../eRS/jsp/ShiftPatternAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style="height:75vh;width:100vw"></iframe>
<iframe name= "frameShiftList" id="frameShiftList" src='../../eRS/jsp/ShiftPatternShiftList.jsp' frameborder=0 scrolling='auto' noresize style="height:25vh;width:100vw"></iframe>

<!-- Added for GHL-SCF-1161 start -->
<%} else{
	%><script type="text/javascript">alert(getMessage("PARAMETER_SETUP_MISSING","RS"));</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
}
} catch(Exception e){
	e.printStackTrace();
}
finally{
	if(pstmt != null)
		pstmt.close();
	if(resultSet != null)
		resultSet.close();
	ConnectionManager.returnConnection(connection,request);

}%>
<!-- Added for GHL-SCF-1161 end -->
</html>

