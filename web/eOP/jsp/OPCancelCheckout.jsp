<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript' ></script>
    <script language='javascript' src='../../eOP/js/OPCancelCheckout.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		//int refresh_interval = 0;
		//String oper_stn_access_rule="";
		try {
				con=ConnectionManager.getConnection(request);
				
				
			
				String fac_id    	= (String) session.getValue( "facility_id" ) ;
				//String sql="select queue_refresh_interval,oper_stn_access_rule from op_param where operating_facility_id='"+fac_id+"'";

				String userid           = (String) session.getValue("login_user");			 
				
				stmt	= con.createStatement();	
				//rs	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CANCEL_CHECKOUT_YN') FROM dual") ;
				
				rs	= stmt.executeQuery(" select patient_id_length, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CANCEL_CHECKOUT_YN') osval from mp_param where module_id='MP' ") ;
	
				

				rs.next();
				String OsVal=rs.getString("osval");	
				String patient_id_length=rs.getString("patient_id_length");	
				
				if(OsVal.equals("1"))
				 {
				 out.print(" <script>alert(getMessage('CANCEL_CHECKOUT_NOT_ALL_OPERSTN','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				 }else if(OsVal.equals("2"))
				{
				out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("3"))
				{
				out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("4"))
				{
				out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				} else if(OsVal.equals("5"))
			{
				
				out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String module_id = request.getParameter("module_id");
	String function_id = request.getParameter("function_id");

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>		
		<iframe name='OPCancelChkout_Search' id='OPCancelChkout_Search' src='../../eOP/jsp/OPCancelCheckoutSearchCriteria.jsp?function_id=<%=function_id%>&module_id=<%=module_id%>&oper_stn_id=<%=OsVal%>&patient_id_length=<%=patient_id_length%>' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
		<iframe name='OPCancelChkout_Result' id='OPCancelChkout_Result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:60vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>	
	<form>	    
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
    </form>

</html>
<%
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
%>

