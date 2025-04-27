<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<HTML>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eBL/js/BLFutOrdInsApprTrack.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	System.err.println("In BLFutOrdInsApprTrackMain.jsp");
	
	String params = request.getQueryString() ;
	if(params==null || params.equals("")) params="";
	
	String function_id=request.getParameter("function_id");
	if(function_id==null || function_id.equals("")) function_id="";
	
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String source = url + params ;
	
	String userId = (String) session.getAttribute("login_user");
	String responsibility_id=(String)session.getAttribute("responsibility_id");	
	String facility_id  =  (String) session.getValue("facility_id") ;
	System.err.println("userId BLApprStatusTrackMain.jsp=>"+userId);
	System.err.println("responsibility_id "+responsibility_id);
	System.err.println("facility_id "+facility_id);	

	String functionID	= 	"EBL_FUT_ORD_INS_APPR_TRK";
	String privilegeID	= 	"FUT_ORD_INS_APPR_TRACK";
	String privilegeYN = "Y";
	String allowedYN = "Y";
	String validUserYN = "Y";
	Connection con = null;
	CallableStatement cstmt1 = null;
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
		cstmt1.setString(1, facility_id);			
		cstmt1.setString(2, userId);			
		cstmt1.setString(3, responsibility_id);			
		cstmt1.setString(4, functionID);			
		cstmt1.setString(5, privilegeID);	
		cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
		cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt1.execute();	
		
		privilegeYN = cstmt1.getString(6);
		
			//System.out.println("privilage");
			//System.out.println(cstmt1.getString(6));
		allowedYN = cstmt1.getString(7);
		//	System.out.println("allowed");
			//System.out.println(cstmt1.getString(7));
		
		if(privilegeYN.equals("Y") /*&& allowedYN.equals("Y")*/)
		{
			//System.out.println("user is allowed");
			validUserYN = "Y";
		}
		else
		{		
		//	System.out.println("user is not allowed");	
			validUserYN="N";
		} 
	
%>
<%if("Y".equals(validUserYN)){%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='FutOrdInsApprTrackMainFrame' id='FutOrdInsApprTrackMainFrame' 	src='../../eBL/jsp/BLFutOrdInsApprTrackMainFrame.jsp' frameborder=0 scrolling='' noresize style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe>  
		
<%}else{%>
	<script>
		alert(getMessage('BL0968','BLEXT'));
		document.location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
	<% } %>
</HTML> 

<%
}
	catch(Exception ee)
	{
		System.err.println("Exception in BLFutOrdInsApprTrackMain.jsp: "+ee);	
	}
	finally
	{		
		if(cstmt1 != null) 	
		{
			cstmt1.close(); 	
		}
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
System.err.println("In BLFutOrdInsApprTrackMain.jsp end1");			
%>

