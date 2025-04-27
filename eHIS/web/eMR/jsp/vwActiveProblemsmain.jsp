<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/ecis.css'></link>
</head>
<%
request.setCharacterEncoding("UTF-8");
String patID=request.getParameter("Patient_Id");

//Added for this CRF ML-MMOH-CRF-0868 
boolean isSupportingDiag = false ; 
Connection conn = null;
String scrolling_auto="no";

try{
    conn = ConnectionManager.getConnection(request) ;
    isSupportingDiag=CommonBean.isSiteSpecific(conn, "MR","ACTIVE_PROB_LIST_EXT_CAUSES");
	if(isSupportingDiag) scrolling_auto="auto";
}catch(Exception e){
   e.printStackTrace();
}finally{
   try{
     ConnectionManager.returnConnection(conn,request);
    }catch(Exception conex){
     conex.printStackTrace();
   }
}
//End this CRF ML-MMOH-CRF-0868 

%>
<iframe name='patLine' id='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no'  style='height:9vh;width:100vw'></iframe>
	<iframe name='vwpatfile' id='vwpatfile' src='../../eMR/jsp/vwActiveProblemsquery.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='<%=scrolling_auto%>' style='height:100vh;width:100vw'></iframe>
</html>

