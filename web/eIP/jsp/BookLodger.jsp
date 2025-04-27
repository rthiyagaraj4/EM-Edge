<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/BookLodger.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url    = "../../eCommon/jsp/commonToolbar.jsp?"; 
	String params = request.getQueryString() ;
	String source = url + params ;
	String loginUser	= (String)session.getValue("login_user");
	String facility		= (String) session.getValue( "facility_id" ) ;

	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	boolean result 			= true;
	String checklodgeryn	= "";
	String oper_stn_id		= "";	

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facility+"' ") ;
		if(rs.next())
		{
			//Added by Devang For Operator Station & Clinic Check
			String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  WHERE a.facility_id='"+facility+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";

			stmt_opr = con.createStatement();
			rset_opr  = stmt_opr.executeQuery(operSql);

			if(rset_opr!=null)
			{
				if(rset_opr.next())
				{
					oper_stn_id = rset_opr.getString("OPER_STN_ID");
					if(oper_stn_id == null) oper_stn_id ="";			
				}	
				else
				{
					out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					result = false;
				}
			}
			if(rset_opr!=null)    rset_opr.close(); 
			if(stmt_opr!=null)    stmt_opr.close();

			if (!oper_stn_id.equals("") && result)
			{
				try
				{
					String sql = "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facility+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";
					stmt_clinic  = con.createStatement();
					rset_clinic = stmt_clinic.executeQuery(sql);

					if (!rset_clinic.next())
					{
						out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						result = false;
					}
				}catch(Exception e) 
				{ 
					result = false; 
					out.println(e.toString());
				}
				finally 
				{
					if (rset_clinic != null)   rset_clinic.close();
				}
			} 

			String sqltfr = "select check_lodger_yn from am_oper_stn where facility_id = '"+facility+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";

			rs = stmt.executeQuery(sqltfr);
			if(rs!= null && rs.next())
			{
				checklodgeryn = rs.getString("check_lodger_yn");
				if(checklodgeryn == null) checklodgeryn ="";			
			}

			if(checklodgeryn.equals("Y"))
			{	%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source %> frameborder=0 scrolling='no' noresize scrolling='no' style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/BookLodgerFrames.jsp?' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
			</script>
		<%	}
			else
			{
				out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
				out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
			}	
		}
		else
		{
			  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}
		if(rs!=null)    rs.close(); 
		if(stmt!=null)    stmt.close();
 
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();

	}

%>	

</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

