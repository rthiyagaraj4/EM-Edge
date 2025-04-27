<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eAE/js/ReleaseBay.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String url						= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params					= request.getQueryString() ;
		String source					= url + params ;
        String fac_id					= (String) session.getValue( "facility_id" );
		String userid					= (String) session.getValue("login_user");
		PreparedStatement	pstmt		=	null;
	    ResultSet			rs			=	null;
	    java.sql.Statement  stmt        =	null;
	    ResultSet			rset		=	null;
	    Connection con=null;
	try
		{
		con=ConnectionManager.getConnection(request);
		String sql1				=	"select 1  from ae_param  where OPERATING_FACILITY_ID=?";
				   
				pstmt  = con.prepareStatement(sql1);
				pstmt.setString(1,fac_id);
				rs = pstmt.executeQuery();
								
				if (rs ==null || !rs.next())
				{

					out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
				}
				else
				{
			   stmt	= con.createStatement();	
			   rset	= stmt.executeQuery("SELECT AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','RELEASE_BED_BAY_YN') FROM DUAL") ;
			   
			   rset.next();
			   String OsVal=rset.getString(1);
			   
					if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else if(OsVal.equals("2"))
					{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("3"))
					{
						out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','OA'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("4"))
					{
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5"))
					{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					   %>
					   <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/ReleaseBay.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

	                   <%
			       } 
		if(rset!=null)	rset.close();
		if(stmt!=null)	stmt.close();
		} // end of else ae_param
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
		ConnectionManager.returnConnection(con,request);
       }
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>       
</html>

