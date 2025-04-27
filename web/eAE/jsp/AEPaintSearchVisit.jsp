<!DOCTYPE html>
<!-- Same from (eHIS/OP/jsp')  Revise Visit Function from OP Module -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head> 
	<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<% 
	Connection  con					= null ;
    PreparedStatement pstmt			= null ;
	ResultSet rset					= null ;
	String  p_mode ="";
	String  patient_id ="";
	String  oper_stn_id = "";
	String  StartDate ="";
	String  sys_date    ="";
	String  RevCanceldays ="";
	String  max_days_allow_update = "";
	String  params  = "";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String facilityId = (String) session.getValue( "facility_id" ) ;
	StringBuffer sqlAEParam = new  StringBuffer(); 
	try{
		 con=ConnectionManager.getConnection(request);
	     p_mode=request.getParameter("p_mode");
	     patient_id=request.getParameter("patient_id");
		 oper_stn_id=checkForNull(request.getParameter("oper_stn_id"));
		 params=checkForNull(request.getParameter("params"));

		 params=params+"&oper_stn_id="+oper_stn_id ;

		 sqlAEParam.append("select  to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,");
		 sqlAEParam.append("'dd/mm/yyyy hh24:mi') startdate, ");
		 sqlAEParam.append(" to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,");
		 sqlAEParam.append(" to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,");
		 sqlAEParam.append(" 'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE from dual,");
		 sqlAEParam.append(" ae_param a where a.operating_facility_id= ? ");
		 pstmt = con.prepareStatement(sqlAEParam.toString());
		 pstmt.setString(1, facilityId);
		 rset = pstmt.executeQuery();
		 if (rset != null)
          {
          while(rset.next()) 
          {
			  
			  StartDate=rset.getString("startdate");
			  params  = params+"&StartDate="+StartDate ;
		      sys_date = rset.getString("sys_date");
			  params  = params+"&sys_date="+sys_date ;
		      RevCanceldays=rset.getString("sys_1date");
			  params  = params+"&RevCanceldays="+RevCanceldays ;
			  max_days_allow_update =rset.getString("MAX_DAYS_ALLOW_UPDATE");
			  params  = params+"&max_days_allow_update="+max_days_allow_update ;
          }
        }
		else{
			    out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));");
				out.println("document.location.href= '../../eCommon/jsp/dmenu.jsp';");
				out.println("</script>");
		}
		if(pstmt != null) pstmt.close();
		if(rset != null)  rset.close();
		if((sqlAEParam != null) && (sqlAEParam.length() > 0))
		{
			sqlAEParam.delete(0,sqlAEParam.length());
		} 
	}catch(Exception e) {e.printStackTrace();}
    finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<title><fmt:message key="Common.SearchVisit.label" bundle="${common_labels}"/></title>
	<title><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></title>
        <iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize src='../../eAE/jsp/AESearchVisitToolbar.jsp' style='height:5vh;width:100vw'></iframe>
        <iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eAE/jsp/AESearchVisitQueryCriteria.jsp?p_mode=<%=p_mode%>&params=<%=params%>&patient_id=<%=patient_id%>' style='height:14vh;width:100vw'></iframe>
        <iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:76vh;width:100vw'></iframe>
        <iframe name='Detail_head' id='Detail_head' src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:0vh;width:100vw'></iframe>
		
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>


</html>

