<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
%>
<script>

function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	{
		if (frames[1].document.forms[0].soundex != null)
		{
			if (frames[1].document.forms[0].soundex.value!='')
			{
				frames[1].document.forms[0].searchby.value="";
				frames[1].document.forms[0].searchby.disabled=true;
			}
		}
		else
		{
			frames[1].document.forms[0].searchby.disabled=false;
			frames[1].document.forms[0].searchby.value="S";
		}
	}
	parent.frames[2].frames[1].document.forms[0].search.disabled = false;
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;
}
</script>
<%!
   boolean ValidateOPeratorStn(String OsVal,JspWriter out)
   {
	  try
	{
		
     if(OsVal.equals("1"))
	  {
		out.print("<script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else if(OsVal.equals("2"))
		{
		out.print("<script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		return false;
		}else  if(OsVal.equals("3"))
		{
		out.print("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
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
		  e.printStackTrace();
	   }
	 return true;
	}

%>

<%

	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String function = checkForNull(request.getParameter("function_id"));

	String source	= url + params ;
	
	Connection con			= null;
	ResultSet rs 			= null; 
	PreparedStatement pstmt = null;
	
	String oper_stn_id				= "";
	String routine_tfr_yn			= "";
	String sydate					= "";
	String priotity_status			= "";
	String change_bed_class_yn		= "";
	String deactivate_pseudo_bed_yn	= "";
	String bl_interfaced_yn			= "";
	int bed_block_period_max_int	= 0;
	String bed_block_period_max_type= "";
    boolean result=false;
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");
	String confirm_request_yn_val="";
	String cancel_request_yn_val="";
	String routine_tfr_yn_val="";
	String sqlQuery = "";

try
{
	con = ConnectionManager.getConnection(request);		

	sqlQuery = "select to_char(sysdate,'dd/mm/rrrr hh24:mi')sydate, priority_applicable_yn, change_bed_class_yn, deactivate_pseudo_bed_yn, nvl(bl_interfaced_yn,'N') bl_interfaced_yn, bed_block_period_max, bed_block_period_max_type,(AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CONFIRM_REQUEST_YN')) confirm_request_yn_val,(AM_OPER_STN_ACCESS_CHECK(?,?,'N','','CANCEL_REQUEST_YN'))cancel_request_yn_val,(AM_OPER_STN_ACCESS_CHECK(?,?,'N','','ROUTINE_TFR_YN')) routine_tfr_yn_val from ip_param where facility_id=? ";

	pstmt = con.prepareStatement(sqlQuery);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,loginUser);
	pstmt.setString(3,facilityId);
	pstmt.setString(4,loginUser);
	pstmt.setString(5,facilityId);
	pstmt.setString(6,loginUser);
	pstmt.setString(7,facilityId);
	rs = pstmt.executeQuery();	
	if(rs.next())
	{
		sydate						=	checkForNull(rs.getString("sydate"));
		priotity_status				=	checkForNull(rs.getString("priority_applicable_yn"));
		change_bed_class_yn			=	checkForNull(rs.getString("change_bed_class_yn"));
		deactivate_pseudo_bed_yn	=	checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
		bl_interfaced_yn					=	checkForNull(rs.getString("bl_interfaced_yn"));
		bed_block_period_max_int		=	rs.getInt("bed_block_period_max");
		bed_block_period_max_type	=	checkForNull(rs.getString("bed_block_period_max_type"));	
		confirm_request_yn_val         =	checkForNull(rs.getString("confirm_request_yn_val"));
		cancel_request_yn_val			=	checkForNull(rs.getString("cancel_request_yn_val"));
		routine_tfr_yn_val				=	checkForNull(rs.getString("routine_tfr_yn_val"));

		if(function.equals("CONFIRM_TRANS_BOOKING"))		
			result=ValidateOPeratorStn(confirm_request_yn_val,out);
		else if(function.equals("CANCEL_TRANS_BOOKING")) 		
			result=ValidateOPeratorStn(cancel_request_yn_val,out);			
		
		if(result) {	
			if (!(routine_tfr_yn_val.equals("1")||routine_tfr_yn_val.equals("2")||routine_tfr_yn_val.equals("3")|| routine_tfr_yn_val.equals("4")||routine_tfr_yn_val.equals("5"))) {
				routine_tfr_yn="Y";
			} else {
				routine_tfr_yn="N";
			}
			if(function.equals("CONFIRM_TRANS_BOOKING")) {
				oper_stn_id=confirm_request_yn_val;
			} else if(function.equals("CANCEL_TRANS_BOOKING")) {
				oper_stn_id=cancel_request_yn_val;
			}
			
			String style1="height:6vh;width:100vw";
			String style2="height:37vh;width:100vw";
			String style3="height:45vh;width:100vw";
			String style4="height:4vh;width:100vw";
			String style5="height:7vh;width:100vw";
			
			if(priotity_status.equals("Y")) {	
				style1="height:6vh;width:100vw";  
				style2="height:37vh;width:100vw"; 
				style3="height:45vh;width:100vw"; 
				style4="height:4vh;width:100vw";  
				style5="height:7vh;width:100vw";  
		} else {
			style1="height:5vh;width:100vw";  
			style2="height:37vh;width:100vw"; 
			style3="height:49vh;width:100vw"; 
			style5="height:8vh;width:100vw";  
		}	%>
				<iframe name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='<%= style1%>'></iframe>
		<%if(function.equals("CONFIRM_TRANS_BOOKING"))
			{	%>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='IPLookupCriteriaForAmendTrn.jsp?jsp_name=PaintAmendTransfer.jsp&win_height=33.4&win_width=49.6&call_function=AmendTransferPatient&wherecondn=CONFIRM_REQUEST_YN&function_id=<%=function%>&routine_tfr_yn=<%=routine_tfr_yn%>&oper_stn_id=<%=oper_stn_id%>&sydate=<%=java.net.URLEncoder.encode(sydate)%>&priority_applicable_yn=<%=java.net.URLEncoder.encode(priotity_status)%>&change_bed_class_yn=<%=java.net.URLEncoder.encode(change_bed_class_yn)%>&deactivate_pseudo_bed_yn=<%=java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&bed_block_period_max_type=<%=java.net.URLEncoder.encode(bed_block_period_max_type)%>&bed_block_period_max_int=<%=bed_block_period_max_int%>' frameborder=0 scrolling='no' noresize style='<%= style2%>'></iframe>
		<%}else if(function.equals("CANCEL_TRANS_BOOKING")) 	{	%>
					<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='IPLookupCriteriaForAmendTrn.jsp?jsp_name=PaintAmendTransfer.jsp&win_height=33.4&win_width=49.6&call_function=AmendTransferPatient&wherecondn=CANCEL_REQUEST_YN&function_id=<%=function%>&routine_tfr_yn=<%=routine_tfr_yn%>&oper_stn_id=<%=oper_stn_id%>&sydate=<%=java.net.URLEncoder.encode(sydate)%>&priority_applicable_yn=<%=java.net.URLEncoder.encode(priotity_status)%>&change_bed_class_yn=<%=java.net.URLEncoder.encode(change_bed_class_yn)%>&deactivate_pseudo_bed_yn=<%=java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&bed_block_period_max_type=<%=java.net.URLEncoder.encode(bed_block_period_max_type)%>&bed_block_period_max_int=<%=bed_block_period_max_int%>' frameborder=0 scrolling='no' noresize style='<%= style2%>'></iframe>
		<%}	%>
				<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='<%= style3%>'></iframe>	
		<%if(priotity_status.equals("Y")) {	%>
				<iframe name='desc_frame' id='desc_frame' src='QuerySearchResultFrames.jsp' frameborder=0 noresize scrolling='auto' style='<%= style4%>'></iframe>
		<%}	%>
				<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='<%= style5%>'></iframe>
			
	<%}		
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}

	if(rs!=null)rs.close();	
	if(pstmt!=null)pstmt.close();
	

}catch(Exception e){e.printStackTrace();}
finally
{
if(con!=null)
ConnectionManager.returnConnection(con,request);
}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

%>

