<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
    
</head>
<script>

function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();
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
}
</script>
<%!
   boolean ValidateOPeratorStn(String OsVal,JspWriter out)
   {try{
     if(OsVal.equals("1"))
	  {
		out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else if(OsVal.equals("2"))
		{
		out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else  if(OsVal.equals("3"))
		{
		out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else  if(OsVal.equals("4"))
		{
		out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else  if(OsVal.equals("5"))
		{
		out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}
  
      }catch(Exception e)
	   {
	   }
	 return true;
	}

%>

<%
    request.setCharacterEncoding("UTF-8");
	String url			= "../../eCommon/jsp/commonToolbar.jsp?";
	String params		= request.getQueryString() ;
	String source		= url + params ;
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");	
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	String priotity_status="N";
	
	Connection con		= null;
	ResultSet rs 		= null; 
	Statement stmt 		= null;
	PreparedStatement pstmt = null;
	ResultSet rset     = null;
	String emergencytfryn	= "";
	String oper_stn_id		= "";
	
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	boolean result 			= false;
	String cancel_tfr_out_yn= "";

	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select 1,PRIORITY_APPLICABLE_YN from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			priotity_status=checkForNull(rs.getString("PRIORITY_APPLICABLE_YN"));

			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CANCEL_TRANSFER_OUT_YN') CANCEL_TRANSFER_OUT_YN, AM_OPER_STN_ACCESS_CHECK(?,?,'N','','TRANSFER_IN_PATIENT_YN') TRANSFER_IN_PATIENT_YN  from dual");
			pstmt.setString(1,facilityId);
		    pstmt.setString(2,loginUser);
			pstmt.setString(3,facilityId);
		    pstmt.setString(4,loginUser);

			rset = pstmt.executeQuery();

            rset.next();

		cancel_tfr_out_yn=rset.getString("CANCEL_TRANSFER_OUT_YN");
		emergencytfryn=rset.getString("TRANSFER_IN_PATIENT_YN");
		result=ValidateOPeratorStn(cancel_tfr_out_yn,out);
		result=ValidateOPeratorStn(emergencytfryn,out);
        if(result){
			oper_stn_id = emergencytfryn;
		}
		if(rset!=null)rs.close();
		if(pstmt!=null)stmt.close();

if(result)
{	
if(priotity_status.equals("Y"))
{%>
	<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=CancelTransferPatientOutFrames.jsp&win_height=33.4&win_width=49.6&call_function=CancelTransferPatientOut&wherecondn=CANCEL_TRANSFER_OUT_YN&oper_stn_id=<%=emergencytfryn%>' frameborder=0 scrolling='no' noresize style='height:29vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:49vh;width:100vw'></iframe>
	<iframe name='desc_frame' src='QuerySearchResultFrames.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
	<iframe name='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
<%}else{%>
	<iframe name='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=CancelTransferPatientOutFrames.jsp&win_height=33.4&win_width=49.6&call_function=CancelTransferPatientOut&wherecondn=CANCEL_TRANSFER_OUT_YN&oper_stn_id=<%=emergencytfryn%>' frameborder=0 scrolling='no' noresize style='height:39vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:43vh;width:100vw'></iframe>
	<iframe name='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
<%}%>
				

<%}
}else
     out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	}
	
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally{
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rset_opr !=null )rset_opr.close();
		if(rset_clinic!=null) 	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
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
