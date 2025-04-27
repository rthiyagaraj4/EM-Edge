<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<script>

function reset()
{
	parent.frames[1].frames[1].document.forms[0].reset();
	parent.frames[1].frames[1].document.forms[0].search.disabled=false;
	parent.frames[1].frames[2].location.href = "../../eCommon/html/blank.html";
}
</script>
<%

	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");		
	
	Connection con  = null;
	ResultSet rs 	= null; 
	Statement stmt 	= null;
	String emergencytfryn = "";
	String oper_stn_id = "";
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	boolean result 			= true;

	StringBuffer operSql = new StringBuffer();
	StringBuffer sqltfr = new StringBuffer();

	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			 //Added by Devang For Operator Station & Clinic  Check
				operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  ");
				operSql.append(" WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id ");
				operSql.append(" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  ");
				operSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
						
				stmt_opr = con.createStatement();
				rset_opr  = stmt_opr.executeQuery(operSql.toString());
				
				if(rset_opr!=null)
				{
					
					if(rset_opr.next())
					{
						oper_stn_id = rset_opr.getString("OPER_STN_ID");
						if(oper_stn_id == null) oper_stn_id ="";			
					}	
					else
					{
						 out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						 result = false;
					}

				}

				if (!oper_stn_id.equals("") && result)
			   {
				 try
				{
				  String sql = "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facilityId+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";
				  
				  stmt_clinic  = con.createStatement();
				  rset_clinic = stmt_clinic.executeQuery(sql);
				 
				  if (!rset_clinic.next())
				  {
					  out.println("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					  result = false;
				   }
				}
				   catch(Exception e) { result = false; out.println(e.toString());}
				   finally 
				 {
					if (rset_clinic != null)   rset_clinic.close();
				 }
			  } 
			  // Added end
		


				sqltfr.append("select CANCEL_TRANSFER_YN from am_oper_stn ");
				sqltfr.append(" where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  ");
				sqltfr.append(" where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ");

		
		
		rs = stmt.executeQuery(sqltfr.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				emergencytfryn = rs.getString("CANCEL_TRANSFER_YN");
				if(emergencytfryn == null) emergencytfryn ="";			
			}
		}


if(emergencytfryn.equals("Y"))
{	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/CancelTransferCriteria.jsp?jsp_name=CancelTransferFrames.jsp&win_height=33.4&win_width=49.6&call_function=CancelTransferPatient&wherecondn=CANCEL_TRANSFER_YN' frameborder=0 scrolling='no' noresize style='height:137%;width:100vw'></iframe>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>


<%}
else
{	
	out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
	
}

	}else
            out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp'</script>");

	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rset_opr !=null )rset_opr.close();
		if(rset_clinic!=null) 	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
	
	
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally{
		ConnectionManager.returnConnection(con,request);
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

