<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	String title_name	=	"Reserve Bay";
%>
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
    <script language='javascript' src='../../eAE/js/AEReserveBed.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><%=title_name%></title>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url    = "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params = request.getQueryString() ;
	String source = url + params ;
	String clinic_code=checkForNull(request.getParameter("clinic_code"));
	String treatment_area_code=checkForNull(request.getParameter("treatment_area_code"));
	String bedno=checkForNull(request.getParameter("bedno"));
	String clinic_desc=checkForNull(request.getParameter("clinic_desc"));
	String treatment_area_desc=checkForNull(request.getParameter("treatment_area_desc"));
	String fac_id=(String) session.getValue( "facility_id" );
	String userid					= (String) session.getValue("login_user");
	String five_level_triage_appl_yn	= "N";
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
//	java.sql.Statement  stmt        =	null;
	//ResultSet			rset		=	null;
	Connection con=null;
	String OsVal="";
	String sys_date="";
	try
		{
		con=ConnectionManager.getConnection(request);
		//String sql1 =	"select 1  from ae_param  where OPERATING_FACILITY_ID=?";
		String sql1 ="SELECT (AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','RESERVE_BED_BAY_YN')) OsVal ,TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_date,five_level_triage_appl_yn FROM ae_param WHERE operating_facility_id =?";
 
		   		pstmt  = con.prepareStatement(sql1);
				pstmt.setString(1,fac_id);
				rs = pstmt.executeQuery();
				if (rs!=null && rs.next())
				{
						  // stmt	= con.createStatement();	
						  // rset	= stmt.executeQuery("SELECT AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','RESERVE_BED_BAY_YN') FROM DUAL") ;
						  // rset.next();
					   OsVal=rs.getString("OsVal");
					   sys_date=rs.getString("sys_date");
					   five_level_triage_appl_yn	= (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");

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
							<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eAE/jsp/AEReserveBedDtl.jsp?clinic_code=<%=clinic_code%>&treatment_area_code=<%=treatment_area_code%>&bedno=<%=bedno%>&treatment_area_desc=<%=treatment_area_desc%>&clinic_desc=<%=clinic_desc%>&OsVal=<%=OsVal%>&sys_date=<%=sys_date%>&five_level_triage_appl_yn=<%=five_level_triage_appl_yn%>' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
						<%
			       } 
		//if(rset!=null)	rset.close();
		//if(stmt!=null)	stmt.close();
		} else{
				out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}

		// end of else ae_param
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

