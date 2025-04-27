<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../js/CancelAdmission.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
   function reset()
   {
		frames[1].document.forms[0].reset();
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
		frames[2].location.href = '../../eCommon/html/blank.html';
   }
	</script>
</head>
<%

	StringBuffer strBuffer	=	new StringBuffer();
	strBuffer.append("../../eCommon/jsp/commonToolbar.jsp?");
	strBuffer.append(request.getQueryString());

	String source				=	strBuffer.toString();
	String facility				=	checkForNull((String) session.getValue("facility_id"));
	String loginUser			=	checkForNull((String)session.getValue("login_user"));
	String canceladmissionyn	=	"";
	String oper_stn_id			=	"";
	
	Connection connection		=	null;
	ResultSet resultSet 		=	null; 
	Statement statement 		=	null;
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	boolean result 	= true;

	try{
		connection = ConnectionManager.getConnection(request);
		statement = connection.createStatement();

		resultSet = statement.executeQuery("select 1 from ip_param where facility_id='"+facility+"' ") ;
		if(resultSet.next())
		{


		 //Added by Devang For Operator Station & Clinic  Check
				String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  "+
						" WHERE a.facility_id='"+facility+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id "+
							" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  "+
						" nvl(b.eff_date_to,trunc(sysdate)) ";
						
				stmt_opr = connection.createStatement();
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

				if (!oper_stn_id.equals("") && result)
			   {
				 try
				{
				  String sql = "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facility+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";
				  
				  stmt_clinic  = connection.createStatement();
				  rset_clinic = stmt_clinic.executeQuery(sql);
				 
				  if (!rset_clinic.next())
				  {
					  out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					  result = false;
				   }
				}
				   catch(Exception e) { result = false; out.println(e.toString());}
				   finally 
				 {
					if (rset_clinic != null)   rset_clinic.close();
				 }
			  } 
		String sqlcan = "select canc_admission_yn from am_oper_stn "+
				" where facility_id = '"+facility+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  "+ 
				" where facility_id='"+facility+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";

		resultSet = statement.executeQuery(sqlcan);
		if(resultSet!= null)
		{
			if(resultSet.next())
			{
				canceladmissionyn = resultSet.getString("canc_admission_yn");
				if(canceladmissionyn == null) canceladmissionyn ="";
				
			}
		}

	
if(canceladmissionyn.equals("Y"))
{		
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/InpatientLookupCriteria.jsp?jsp_name=PatientValuablesMain.jsp&win_height=30&dialogTop=120&win_width=49&call_function=CancelAdmission&wherecondn=CANC_ADMISSION_YN' frameborder=0 scrolling='no' noresize style='height:180%;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:45%;width:100vw'></iframe>
	
<%}
else
{
	out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
}

}else
  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally
	{
		if(statement!=null) statement.close();
		if(resultSet!=null) resultSet.close();
		if(rset_opr!=null)		rset_opr.close();
		if(rset_clinic!=null)	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
		ConnectionManager.returnConnection(connection,request);
	}

%>	
	
</html>

<%!
	// By Annadurai 2/4/2004., to Handle NullPointerException.,
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>

