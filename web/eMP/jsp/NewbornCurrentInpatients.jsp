<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>


<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
</head>
<script>
function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();

 if(parent.frames[2].frames[1].document.forms[0].gender != null)
	if(parent.frames[2].frames[1].document.forms[0].targetURL.value != "")
	{
		parent.frames[2].frames[1].document.forms[0].gender.value = "F";
		parent.frames[2].frames[1].document.forms[0].gender.disabled = "true";
	}

	if (frames[1].document.forms[0].searchby != null)
	    {
			if (frames[1].document.forms[0].soundex.value!='')
			{
				frames[1].document.forms[0].searchby.value="";
				frames[1].document.forms[0].searchby.disabled=true;
			}
			else
			{
				frames[1].document.forms[0].searchby.disabled=false;
				frames[1].document.forms[0].searchby.value="S";
			}
	    }
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	 
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;

	self.document.location.reload();

}
</script>
<%
	//String url="../../eCommon/jsp/commonToolbar.jsp?";
	//String params = request.getQueryString() ;
	

	//String source = url + params ;	
	String parameters = request.getParameter("parameters");	

	String accessRights		=	checkForNull(request.getParameter("accessRights"));
	String functionid		=	checkForNull(request.getParameter("functionid"));
	
	String parent_details	=	checkForNull(request.getParameter("parent_details"));
	String function_invoked	=	checkForNull(request.getParameter("function_invoked"));

	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	//String loginUser		=	checkForNull((String)session.getValue("login_user"));		
	//String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"":request.getParameter("mother_nursing_unit");
	//String mother_bed_no = request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no");

	String module_invoked = "IP";
	StringBuffer targetURL = new StringBuffer();
	targetURL.append("../../eMP/jsp/NewbornRegistration.jsp?accessRights=");
	targetURL.append(accessRights);
	targetURL.append("&parent_details=");
	targetURL.append(parent_details);
	targetURL.append("&function_invoked=");
	targetURL.append(function_invoked);
	targetURL.append("&module_invoked=");
	targetURL.append(module_invoked);

	Connection con  = null;
	ResultSet rs 	= null; 
	Statement stmt 	= null;
	
	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			//out.println("<script> alert('Here 2')</script>");
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= parameters %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<!--frame name='f_query_add_mod' 	src='../../eIP/jsp/InpatientLookupCriteria.jsp?functionid=<%=functionid%>&jsp_name=NewbornRegistrationFirst.jsp&win_height=33.4&win_width=49.6&call_function=NEWBORN_REG&wherecondn=EMERGENCY_TFR_YN&targetURL=<%=URLEncoder.encode(targetURL.toString())%>' frameborder=0 scrolling='no' noresize-->
				<!--Thursday, March 11, 2010 , IN019962 , EMERGENCY_TFR_YN is for Intraward Transfer in Operator Station set up -->
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eIP/jsp/InpatientLookupCriteria.jsp?functionid=<%=functionid%>&jsp_name=NewbornRegistrationFirst.jsp&win_height=33.4&win_width=49.6&call_function=NEWBORN_REG&wherecondn=reg_newborn_for_ip_yn&targetURL=<%=URLEncoder.encode(targetURL.toString())%>' frameborder=0 scrolling='no' noresize style='height:24vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:60vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>


<%	}else
            out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}catch(Exception e){}
	
	finally{
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

