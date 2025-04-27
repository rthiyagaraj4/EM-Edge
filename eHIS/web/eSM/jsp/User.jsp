<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
<script language='javascript' src='../js/User.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
 

	<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String ValUser = "";	
	String responsibility_id= (String) session.getAttribute("responsibility_id");
	String create_user_yn="";//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020
	Boolean isUserFacilityAppilcable = false;//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020

	Connection con=null;
	//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020
	Properties p=(Properties)session.getValue("jdbc");
	String globaluser = (String)p.getProperty("login_user"); 
	try{
	con = ConnectionManager.getConnection(request);

	
	isUserFacilityAppilcable = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "USER_FACILITY_AUTHORIZATION");//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020

				
			
	if(	isUserFacilityAppilcable)//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		{
JSONObject Json	= eSM.SMCommonBean.getUserFacilityAccessYN(con,globaluser);//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
				create_user_yn = (String) Json.get("create_user_yn");//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	

	if(create_user_yn.equals("Y") )//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
	   {
	   
%>

		<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>				
		<iframe name='f_query_add_mod' 	 src='../../eCommon/html/blank.html'  scrolling='auto'frameborder=0 style='height:83vh;width:100vw'></iframe>				
		<iframe name='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp'frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>				
		
<%
	}
	else
	   {
%>
		<SCRIPT>
			alert(getMessage('ACCESS_USER_FACILITY_DENIED','SM'));//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
			document.location.href='../../eCommon/jsp/dmenu.jsp';//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		</SCRIPT>
<%		
	  }   
		}
		else
		{
%>


		<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>								
		<iframe name='f_query_add_mod' 	 src='../../eCommon/html/blank.html'  scrolling='auto'frameborder=0 style='height:83vh;width:100vw'></iframe>				
		<iframe name='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp'frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>				

<%
		}
%>


<%
}catch(Exception e){out.println(e);}
finally {				
			ConnectionManager.returnConnection(con,request);
		}	
%>
</html>
