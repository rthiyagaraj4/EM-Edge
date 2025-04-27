<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% /*This file will call MP file NewbornCurrentInpatients.jsp which will create the frameset and call NewBorn Registration window in modal form */%> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmtsql	= null;
	ResultSet rssql				= null;
	String function_id		= checkForNull(request.getParameter("function_id"));
	String parent_details	= checkForNull(request.getParameter("parent_details"));
	String function_invoked = checkForNull(request.getParameter("function_invoked"));
	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	String loginUser = (String)session.getValue("login_user");

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String functionid=request.getParameter("function_id");
        if(functionid == null) functionid = "";
		
	StringBuffer source = new StringBuffer();
	source.append(url + params);

	if(!function_id.equals("") &&	 !function_id.equals("NEWBORN_REG") &&!function_id.equals("REG_NEWBORN_FOR_IP")  )
	{
		source.append("&home_required_yn=N");					
	}

		int src=source.toString().indexOf("access",0);
		String accessRights=source.toString().substring(src+7,src+12);
		session.putValue("accessRights",accessRights);
		session.setAttribute("paramsValue",params);
			
		String parameters = URLEncoder.encode(source.toString());
%>
<html>
<head>
<title><fmt:message key="eIP.RegisterNewBornForIP.label" bundle="${ip_labels}"/></title>	
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script language='javascript' src='../../eMP/js/NewbornRegistration.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 
	<script>
	
	function query()
	{
		self.location.href='../../eCommon/html/blank.html';
		parent.parent.frames[2].location.href='../../eMP/jsp/NewbornCurrentInpatients.jsp?functionid=<%=functionid%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&source=<%=source.toString()%>';			 
			 
	}
	function call_ip() 
	{	
		self.location.href='../../eCommon/html/blank.html';			parent.parent.frames[2].location.href='../../eMP/jsp/NewbornCurrentInpatients.jsp?functionid=<%=functionid%>&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&parameters=<%=parameters%>';			
	}

	</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
try 
{	
	con			=	ConnectionManager.getConnection(request);
	pstmtsql=con.prepareStatement("select 1 from ip_param where facility_id = '"+facilityId+"'");
	rssql = pstmtsql.executeQuery();
	if(rssql.next())
	{ pstmtsql = con.prepareStatement("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','REG_NEWBORN_FOR_IP_YN') FROM dual");
			rssql = pstmtsql.executeQuery() ;
			rssql.next();
	     	String OsVal=rssql.getString(1);
            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else	if(!OsVal.equals(""))
			{
				out.println("<script>call_ip(); </script>");
			}
		 
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}	
}catch (Exception e){ out.println(e);}
finally 
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>	
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

