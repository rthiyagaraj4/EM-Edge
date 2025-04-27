<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<% String autopsy_no="";
   String  reg_no="";
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
Connection con	 =	(Connection)ConnectionManager.getConnection(request);
Boolean isAutopsyNoAppl =false;
 try
     {	
	   isAutopsyNoAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","AUTOPSY_NUMBER");//Added by Shanmukh on 27th-JUNE-2018 for ML-MMOH-CRF-1034

		 String fac_id = (String) session.getValue("facility_id") ;
		reg_no=request.getParameter("regn_no")==null?"":request.getParameter("regn_no");
		String getdata="select AUTOPSY_NO	from mo_mortuary_regn where REGISTRATION_NO='"+reg_no+"' and facility_id='"+fac_id+"'";
		
     
	    
        Statement st               = con.createStatement();
	    ResultSet rs               = st.executeQuery(getdata);
	    if( rs.next())
	   {
	     autopsy_no=rs.getString("AUTOPSY_NO");
	   
	   }
	 if(rs!=null)rs.close();
	if(st!=null)st.close();
	 }catch(Exception e)
	 {
		out.println("Error"+e);
	 }finally
	 {
	 ConnectionManager.returnConnection(con,request);
	 }
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>
<body onKeyDown = 'lockKey()'>


<form name='MOPosmortemHeader' id='MOPosmortemHeader' method='POST' action="../../servlet/eMO.MOManageDeceasedAssignAreaServlet">
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
 <td class='PATIENTLINECOLOR'  style='position:relative;' ><fmt:message key="eMO.RegnNo.label" bundle="${mo_labels}"/>:<b id='regstrn_no'><%=reg_no%></b>
 </font>
 </td>
 <!-- Below label modified by Shanmukh on 27th-JUNE-2018 for ML-MMOH-CRF-1034-->
 <td   class='PATIENTLINECOLOR'  style='position:relative;' align=right><%if(isAutopsyNoAppl){%><fmt:message key="eMO.AutopsyNo.label" bundle="${mo_labels}"/><%}else{%><fmt:message key="eMO.PostMortemNo.label" bundle="${mo_labels}"/> <%}%>:<b id='autopsy_no_id'><%=autopsy_no%></b></td>
 
 

 
 </tr>
 <tr>
 <td colspan=2 class='PATIENTLINECOLOR'  style='position:relative;'>&nbsp;</td>
 <tr>
 </table>
</form>

</body>
</html>

