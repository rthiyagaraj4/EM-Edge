<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
 <head>	
    <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
<script src='../../eCA/js/CAMainMenuLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String strSql					=	"";
	String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String option_id	= "";
	String short_desc	= "";
	String icon_file_name= "";
	String executable_name= "";
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
	
	StringBuffer icons = new StringBuffer("");
%>
			
</head>
<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown="lockKey()">
	
<%
	try
	{
		con = ConnectionManager.getConnection(request);

		icons.append("<table width='100%' border=0 align=center cellpadding=0 cellspacing=0><tr>");

		if(!patient_id.equals(""))
		{
			strSql = "select a.OPTION_ID,a.SHORT_DESC,a.ICON_FILE_NAME,a.EXECUTABLE_NAME from ca_option a, ca_custom_option b where a.option_id = b.option_id and b.practitioner_id = ? and a.DESKTOP_YN <> 'Y' and a.ICON_FILE_NAME is not null";
		}
		else
		{
			strSql = "select a.OPTION_ID,a.SHORT_DESC,a.ICON_FILE_NAME,a.EXECUTABLE_NAME from ca_option a, ca_custom_option b where a.option_id = b.option_id and b.practitioner_id = ? and a.DESKTOP_YN = 'Y' and a.ICON_FILE_NAME is not null";
		}
					
						
		pstmt = con.prepareStatement(strSql);
		pstmt.setString(1,practitioner_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			option_id = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
			short_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			icon_file_name = rs.getString("ICON_FILE_NAME")==null?"":rs.getString("ICON_FILE_NAME");
			executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
			if(executable_name.indexOf("?") != -1)
			{
				executable_name=executable_name + "&option_id="+option_id+"&"+queryString;
			}
			else
			{
				executable_name=executable_name+"?"+"option_id="+option_id+"&"+queryString;
			}
			
			icons.append("<td><img src='../../eCA/images/"+icon_file_name+"' id='"+option_id+"' onclick=callFunction('"+short_desc+"','"+executable_name+"')  alt='"+short_desc+"' width='32' height='30'></img></td>");
			icons.append("<td><img id='divider' src='../../eCA/images/MI_Divider.jpg' alt='Divider'></img></td>");
		}
		icons.append("</tr></table>");			

		if(rs!=null) rs.close();
		if (pstmt != null) pstmt.close();
	} 
	catch (Exception e) 
	{
		//out.println("CAMainTitle: "+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	 finally 
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>

</body>
<script>
	var tableVal = "<%=icons.toString()%>";
	parent.CommonToolbar.displayIcons(tableVal);
	//top.frames[1].frames[0].displayIcons(tableVal);
</script>
</html>

