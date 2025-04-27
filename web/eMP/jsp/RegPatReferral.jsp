<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/RegPatReferral.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script> 
	<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con = null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	
	try
	{
	String facilityid = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String calling_from =request.getParameter("calling_from"); 
	String speciality_code =request.getParameter("speciality_code"); 
	String patient_id = request.getParameter("patient_id");		
	String practitioner =request.getParameter("practitioner"); 
	String practitioner_name =request.getParameter("practitioner_name");
	String p_calling_function=(request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");		
	String p_to_locn_type=(request.getParameter("p_to_locn_type") == null)?"":request.getParameter("p_to_locn_type");
	String p_to_locn_code=(request.getParameter("p_to_locn_code") == null)?"":request.getParameter("p_to_locn_code");
	String ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	
	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc=(request.getParameter("p_service_desc") == null)?"":request.getParameter("p_service_desc");
	String p_service_code=(request.getParameter("service_code") == null)?"":request.getParameter("service_code");
	//END
	
	if (calling_from==null) calling_from="";
	if (speciality_code==null) speciality_code="";
	if (practitioner==null) practitioner="";
	if (practitioner_name==null) practitioner_name="";
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

	//practitioner_name = java.net.URLEncoder.encode(practitioner_name);
	String utl1= "../../eMP/jsp/RegPatReferralMainPage.jsp?";
	utl1 =  utl1+params+"&function_id="+function_id+"&p_calling_function="+p_calling_function+"&p_to_locn_type="+p_to_locn_type+"&ass_func_id="+ass_func_id+"&patientid="+patient_id+"&p_to_locn_code="+p_to_locn_code+"&p_service_desc="+p_service_desc+"&p_service_code="+p_service_code;		
	 if (calling_from.equals("SEARCH"))
	 {%>
		<title><fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/></title>
	 <%}
	int count=0;
	int operator_station_access=0;
	con = ConnectionManager.getConnection(request);
	pstmt1=con.prepareStatement("select count(*) as count  from AM_REF_ID_NUM_FOR_FCY where facility_id='"+facilityid+"'");
	rset1=pstmt1.executeQuery();

	if(rset1 != null)
	{
		if(rset1.next())
		{
			count=rset1.getInt(1);
		}
	}

	if(count != 0)
		{
	pstmt=con.prepareStatement("select count(*) as total from mp_param");
	rset=pstmt.executeQuery();

	if(rset != null)
	{
		if(rset.next())
		{
			operator_station_access=rset.getInt(1);
		}
	}

	
	if(operator_station_access == 0)
	{
		%>
		<script>
		alert(getMessage('MP_PARAM_NOT_FOUND','MP'));
		</script>
		<%
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");%>
		<%
	}

	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	
	if (calling_from.equals("SEARCH")) 
	{%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize tabindex=-1 style='height:7vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src="<%= utl1 %>" frameborder=0 scrolling='no' tabindex=-1 style='height:90vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' tabindex=-1 style='height:3vh;width:100vw'></iframe>
		<iframe name='dummy' id='dummy' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize tabindex=-1 style='height:0vh;width:100vw'></iframe>
	<%}
	else{%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize tabindex=-1 style='height:7vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize tabindex=-1 style='height:88vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' tabindex=-1 style='height:5vh;width:100vw'></iframe>
		<iframe name='dummy' id='dummy' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize tabindex=-1 style='height:0vh;width:100vw'></iframe>
	<%}%>
		
<%
	}
	else
		{%>
		<script>
		alert(getMessage('REFERRAL_ID_NUM_NOT_DEFINED','MP'));
		parent.parent.parent.parent.frames[1].expand();
		</script>
		<%}
		if(rset1 != null) rset1.close();
	if(pstmt1 != null) pstmt1.close();
   }catch(Exception e)
	   {
		 out.println("Exception in main RegPatReferral="+e.toString());
		 e.printStackTrace();
	   }
	   finally
	   {
			if(con != null) ConnectionManager.returnConnection(con,request);
	   }
%>


</html>

