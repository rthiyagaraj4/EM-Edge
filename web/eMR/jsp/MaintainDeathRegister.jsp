<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<script language ='javascript' src='../../eMR/js/CreatePatientFile.js'></script>
	<script language=JavaScript src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>


<%

	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String ca_install_yn = "N";
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String userid           = (String) session.getValue("login_user");			 


	int count = 0;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		rs		= stmt.executeQuery("SELECT MAX_PRI_DIAG_INDICATE_CO_DEATH FROM MR_PARAMETER");	
		if ((rs != null) && (rs.next()))
			count = rs.getInt(1);

		if(rs	 != null)   rs.close();
		if(stmt !=null) stmt.close();

		stmt	= con.createStatement();
		rs		= stmt.executeQuery("SELECT install_yn FROM SM_MODULE WHERE module_id = 'CA'");	

		if ((rs != null) && (rs.next()))
			ca_install_yn = checkForNull(rs.getString("install_yn"),"N");
		
		if(rs	 != null)   rs.close();
		if(stmt !=null) stmt.close();

	

				stmt	= con.createStatement();
				rs		= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','MAINTAIN_DEATH_REGISTER_YN') FROM dual");	
				rs.next();
				String OsVal=rs.getString(1);	
				
			  if(OsVal.equals("1"))
			{%>
			 	<script>alert(getMessage('NO_OPER_STN_FOR_USER','Common'));
				//location.href='../../eCommon/jsp/home.jsp';
				document.location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
			<%}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");			
			}else if(OsVal.equals("3"))
			{
				out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");		
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}

			if(rs	 != null)   rs.close();
			if(stmt !=null) stmt.close();


	
	if(count>0)
	{
		if(ca_install_yn.equals("Y"))
		{


			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String url="../../eCommon/jsp/commonToolbar.jsp?";
			String params = request.getQueryString() ;
			String source = url + params ;

%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/DeathRegisterCriteria.jsp?' frameborder=0 scrolling='no' noresize style='height:24vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod1' id='f_query_add_mod1' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
			<iframe name='colour_ind' id='colour_ind' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='auto' noresize style='height:8vh;width:100vw'></iframe>
		
		</html>
<%

		}
		else
		{
			out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
			out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
	}
	else
	{
		out.println("<script>alert(getMessage('MR_PARAM_NOT_DEFINED_MDR','MR'));</script>");
		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}

	}catch(Exception exp)
	{
		//out.println("Exception in MaintainDeathRegister.jsp : "+exp.toString());
		exp.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
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

