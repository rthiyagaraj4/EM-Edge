<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=request.getParameter("title")%></title>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String flag=""; 
    	 
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
    String facilityid  	= (String) session.getValue("facility_id");
    String patient_id	=  request.getParameter("patient_id");
  	String EncounterId	= request.getParameter("EncounterId") == null ? "" : request.getParameter("EncounterId");
  	try{		 
		 
	
%>


	<iframe name='patienbanner' id='patienbanner' src='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&Facility_Id=<%=facilityid %>' frameborder=0   noresize style='height:8%;width:100vw'></iframe>
		<iframe name='ClaimantCriteria' id='ClaimantCriteria' src='../../eMO/jsp/ViewClaimantHistoryCriteria.jsp?patient_id=<%=patient_id%>' frameborder=1  noresize style='height:20%;width:100vw'></iframe>
		<iframe name='Claimantdetails' id='Claimantdetails' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0  noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='error' id='error' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder=0  noresize style='height:5%;width:100vw'></iframe>
	
<%		
    }
    catch (Exception e) { out.println(e) ; }
	finally{
	 if(con != null) ConnectionManager.returnConnection(con,request);
	 if(rset!=null) rset.close();
	 if(stmt!=null) stmt.close();
}
%>
</html>

