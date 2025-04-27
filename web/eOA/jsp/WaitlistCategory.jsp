<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eOA/js/WaitlistCategory.js"> </script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

 <%
    Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	try{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
    String WAITLIST_CATEGORY_APPL_YN="";
	pstmt = con.prepareStatement("SELECT WAITLIST_CATEGORY_APPL_YN FROM oa_param");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					WAITLIST_CATEGORY_APPL_YN = rs.getString("WAITLIST_CATEGORY_APPL_YN");
					if(WAITLIST_CATEGORY_APPL_YN == null || WAITLIST_CATEGORY_APPL_YN.equals("null")) 
						WAITLIST_CATEGORY_APPL_YN = "";
				}
		if(WAITLIST_CATEGORY_APPL_YN.equals("Y"))
			{

				String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
				String params	= request.getQueryString() ;
				String source   = url+params ;
			%> 

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling=no noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eCommon/html/blank.html?' frameborder=0 scrolling=no style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:9vh;width:100vw'></iframe>
			 <%}else{%>

			<script>
			alert(getMessage("WL_CAT_NOT_APPL","OA"));
			self.location.href='../../eCommon/html/blank.html';
			document.location.href ='../../eCommon/jsp/dmenu.jsp'; 
			</script>
			<%
		}
	}
	catch(Exception e) 
	{ 
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%> 

</html>

