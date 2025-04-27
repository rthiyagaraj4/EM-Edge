<!DOCTYPE html>
<%@ page import="java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eMO/js/MORegisterBodyPart.js' language='javascript'></script> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID");
	String registration_no=request.getParameter("registration_no")==null?"":request.getParameter("registration_no");
	String source = url + params ;
	String functionid=request.getParameter("functionid")==null?"":request.getParameter("functionid");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");	
	/*Below line added for this CRF ML-MMOH-CRF-0695*/
	String function_id1=request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
	
/*Below Code Added for this incident[33931] */		
String	facility_id =  (String) session.getValue( "facility_id" ) ;
Connection con		=	null;
Statement	st		=	null;
ResultSet	rs		=	null;
String interval="";           
    try 
		{ 			
			con	 =	(Connection)ConnectionManager.getConnection(request);			
			st	 =con.createStatement();
			rs=st.executeQuery("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id='"+facility_id+"'");
			if(rs.next())
			{
			interval=rs.getString("QUEUE_REFRESH_INTERVAL")==null?"0":rs.getString("QUEUE_REFRESH_INTERVAL");			   
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			}catch(Exception e)
	        {
	        e.printStackTrace();
	        }finally {
	           ConnectionManager.returnConnection(con,request);
             }

if(interval.equals("")){%>
<script>
		alert(getMessage("MO_PARAM_NOT_FOUND","MO"));	      			
		document.location.href='../../eCommon/jsp/dmenu.jsp';
</script>
<%}%>
<head>
<title><fmt:message key="Common.BodyParts.label" bundle="${common_labels}"/></title>
<%
	String sStyle= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>   

</head>
<% 
	if(mode.equals("viewdata")){
	%>
		<!--<frameset rows='0,25,7%,*,33,0,0' id="bp" name="bp" >-->
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<%}else{%>
		<!--<frameset rows='47,25,7%,*,20,0,0' id="bp" name="bp">-->
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<%}%>	
	<%if(mode.equals("modify")||mode.equals("viewdata"))
	{
	  /*Below line modified for this CRF ML-MMOH-CRF-0695*/
	%>
		<iframe name='criteria' id='criteria' src='../../eMO/jsp/MORegisterBodyPartCriteria.jsp?function_id=<%=functionid%>&functionid=<%=function_id%>&mode=<%=mode%>&patient_id=<%=patientID%>&registration_no=<%=registration_no%>&function_id1=<%=function_id1%>' scrolling='no' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>
	<%}else
	{%>
		<iframe name='criteria' id='criteria' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:3vh;width:100vw'></iframe>
	<%}%>
		<iframe name='patientline' id='patientline' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:69vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='yes' style='height:9vh;width:100vw'></iframe>
	  	<iframe name='dummyframe' id='dummyframe'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='dummyframe1' id='dummyframe1'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
<!--</frameset>-->

<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	<input type='hidden' name='functionid' id='functionid' value=<%=functionid%>>
	</form>
</html>
