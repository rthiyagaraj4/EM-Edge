<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
try{
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null; 
ResultSet rset =null;
ResultSet rs =null;
String pat_id = request.getParameter("pat_id") == null ? "" : request.getParameter("pat_id");
String p_session_id = request.getParameter("p_ses_id");

int resu=0;
boolean result = false;
String InsertPat=" insert into rd_patient_regn(session_id,patient_id) values ('"+p_session_id+"','"+pat_id+"')";

con =  ConnectionManager.getConnection(request);
pstmt = con.prepareStatement( InsertPat );
resu =pstmt.executeUpdate() ;
if(resu > 0){	
	con.commit();
}else{	
	con.rollback();
	%><script>alert('Transaction failed while inserting in RD_PATIENT_REGN');</script><%
}
if(con!=null)con.close();
%><script>window.close()</script><%
}catch(Exception e){
	e.printStackTrace();
}finally{
}

%>

