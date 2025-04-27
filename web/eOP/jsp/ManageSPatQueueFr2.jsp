<!DOCTYPE html>
<!--
	Developed by 	:	Parimala
	Created on 		:	22/12/2000
	Module			:	Out Patient Management
	Function		:	This file is used for displaying of frame 1 & 2 as- below.
-->
    
 <%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <script src="../../eOP/js/ManageSPatQueue.js"></script>
 <script language="javascript" src="../../eCommon/js/common.js"></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<%
    
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ; 
	String function_id=request.getParameter("function_id");
     if(function_id == null) function_id = "";
     
	String Vitalsign = request.getParameter("Vitalsign");
	String ChkOut = request.getParameter("ChkOut");
	String Que = request.getParameter("Que");
	String rfresh_param = request.getParameter("refresh");
	String oper_stn_access_rule=request.getParameter("oper_stn_access_rule");
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");

	String ca_install_yn = "";
	String pat_id_length = request.getParameter("pat_id_length")==null?"":request.getParameter("pat_id_length");
	String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");
	String sdate = request.getParameter("sdate")==null?"":request.getParameter("sdate");
	
	String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]
	if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
	{
		ca_install_yn = request.getParameter("ca_install_yn")==null?"N":request.getParameter("ca_install_yn");
	}

	
	String frame1Height = "38vh";
	
	if (ChkOut != null && ChkOut.equalsIgnoreCase("ChkOut"))
		frame1Height = "34vh";
	/*
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//String ca_install_yn="";

	if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
	{
		ca_install_yn="N";
	}
	Connection con=null;

	try{
		con=ConnectionManager.getConnection(request);

		if((Vitalsign != null && Vitalsign.equals("Vitalsign")) && ChkOut == null)
		{
		
			pstmt = con.prepareStatement("select install_yn from sm_module where module_id ='CA'");
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
			  while (rs.next())
			  {
				  ca_install_yn = rs.getString("install_yn");
			  }
			}
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null) 
			ConnectionManager.returnConnection(con,request);

	}
*/
// The below if condition tells if the CA module is installed the function is proceeded further or else and alert is displayed.
	if(ca_install_yn.equals("N"))
	{
	%>
		<script>		
			alert(getMessage("CA_NOT_INSTALLED","COMMON"));
            document.location.href ='../../eCommon/jsp/dmenu.jsp'
		</script>
	<%
	}
	else
	{
	%>
	<!-- Below is defined another frameset :
		1.	The first frame is for the query criteria to be given.
		2.	The second frame is initially blank.
		3.	The third frame is a dummy frame for any intermediate validations.-->
		
		<!--Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297]  -->
		<iframe name='frame1' id='frame1' 	src='../../eOP/jsp/ManageSPatQueueQueryCriteria.jsp?function_id=<%=function_id%>&Vitalsign=<%=Vitalsign%>&ChkOut=<%=ChkOut%>&Que=<%=Que%>&refresh=<%=rfresh_param%>&Que=<%=Que%>&oper_stn_access_rule=<%=oper_stn_access_rule%>&oper_id=<%=oper_id%>&pat_id_length=<%=pat_id_length%>&sdate=<%=sdate%>&bl_package_enabled_yn=<%=bl_package_enabled_yn%>&action_on_pending_bill=<%=action_on_pending_bill%>' frameborder=0 scrolling='no' noresize style='height:<%=frame1Height%>;width:99vw'></iframe>
		<iframe name='searchbutton' id='searchbutton' src='../../eOP/jsp/ManagePatQueSearchButton.jsp' frameborder=0 noresize scrolling='auto'  style='height:4vh;width:99vw'></iframe> 
		<iframe src='../../eCommon/html/blank.html' frameborder=0 name='frame2' id='frame2' noresize  scrolling="auto"  style='height:45vh;width:99vw'></iframe>
		<iframe src='../../eCommon/html/blank.html' frameborder=0 name='checkbox' id='checkbox'  FRAMEBORDER=NO   marginwidth='5' scrolling='auto' noresize style='height:4vh;width:99vw'></iframe>
	
	<!-- end Bru-HIMS-CRF-179 [IN030297] -->
	
	<%}%>

