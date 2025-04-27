<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eOR/js/ActivityType.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORGeneraOl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
 </head>


<%	
	String mode= request.getParameter("mode")== null  ? "" :request.getParameter("mode").trim();
	String function_id= request.getParameter("function_id");
	String frameSize = "";
	
	String src1="";
	String src2="";
	String queryStr ="";

	//boolean flag=false;
	if(mode.equals("1"))
	{
		//out.println("<script>alert('mode="+mode+"');</script>");
	frameSize = "7%,*";
	src1  = "../../eOR/jsp/ActivityTypeAddModifyHeader.jsp?mode=1&function_id="+function_id;
	src2  = "../../eOR/jsp/ActivityTypeAddModifyDetail.jsp?mode=1&function_id="+function_id;
	queryStr ="";


	}	
	else if(mode.equals("2"))
	{
		
		String order_category="";
		String order_category_desc= "";
		String eff_status = "";
		String activity_type ="";
		//String long_desc = "";
		//String short_desc	= "";	
		String order_type_code="";
		String order_type_desc="";
		//flag = true;
		activity_type= request.getParameter("activity_type").trim();
		//long_desc = request.getParameter("long_desc");
		//short_desc=request.getParameter("short_desc");
		order_category= request.getParameter("order_category");
		order_category_desc= request.getParameter("order_category_desc");
		order_type_code=request.getParameter("order_type_code");
		order_type_desc=request.getParameter("order_type_desc");
		eff_status=request.getParameter("eff_status");
		
			//out.println("<script>alert('long_desc="+long_desc+"')</script>");
		//out.println("<script>alert('short_desc="+short_desc+"')</script>");

		
			
		frameSize="100%,0%" ;
		src1	 ="../../eOR/jsp/ActivityTypeUpdate.jsp?";
		src2     ="../../eCommon/html/blank.html";
		// Commented by Murthy - 22-05-2007 for not using the Order Category Desc, Order_type_code,order_type_desc
		
		//queryStr = "mode=2&order_category="+order_category+"&activity_type="+activity_type+"&eff_status="+eff_status+"&order_type_code="+order_type_code+"&order_type_desc="+order_type_desc+"&order_category_desc="+order_category_desc;
		
		queryStr = "mode=2&order_category="+order_category+"&activity_type="+activity_type+"&eff_status="+eff_status;
		src1 = src1 + queryStr ;
		//out.println("<script>alert('src1="+src1+"')</script>");

		}
%>
<frameset rows='<%=frameSize%>'>

	<frame name='f_query_add_mod_header' id='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 scrolling='no' noresize>
	
	<frame name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%=src2%>' frameborder=0 scrolling='no' noresize>

</frameset>
</html>

