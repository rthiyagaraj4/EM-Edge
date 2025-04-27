<!DOCTYPE html>
<html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8 " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
</head>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eAT/js/Atparameter.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</html>
<%
	
	Connection connection   = null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 =null ;
	ResultSet rs = null ;

try
	{
			


connection	= ConnectionManager.getConnection(request);
System.out.println("datbase");		
			
String preanaesthesia_noteType = request.getParameter("preanaesthesia_noteType");
String intraanaesthesia_noteType=request.getParameter("intraanaesthesia_noteType");
String postanaesthesia_noteType	=request.getParameter("postanaesthesia_noteType");
String discrete_measureCode=request.getParameter("discrete_measureCode");

String sql = "INSERT INTO  AT_PARAM(PRE_ANES_NOTE_TYPE,INTRA_ANES_NOTE_TYPE,POST_ANES_NOTE_TYPE, DISCR_MSR_ID) VALUES(?,?,?,?)";
			
pstmt  =connection.prepareStatement(sql);
pstmt.setString(1,preanaesthesia_noteType);
pstmt.setString(2,intraanaesthesia_noteType);
pstmt.setString(3,postanaesthesia_noteType);
pstmt.setString(4,discrete_measureCode);
pstmt.executeUpdate();
connection.commit();
}


catch ( Exception e ) {


System.err.println("Caught Exception error : "+e);



e.printStackTrace() ;
}

finally 
	{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}
		
		catch(Exception es)
		{
		es.printStackTrace();
		
		}
}


%>











