<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue  
	%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eCommon/js/common.js'></script>	
	 
	<script language ="javascript" src="../js/EmergencyTransfer.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>//alert("opening TransferPatient.jsp");</script>
<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String function_name 	= request.getParameter( "function_name" ) ;
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");	
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";


	Connection con  = null;
	ResultSet rset	= null; 
	ResultSet rset1	= null; 
	Statement stmt 	= null;
	Statement stmt1	= null;
	StringBuffer sqlQuery	= new StringBuffer();
	int bed_block_period_max= 0;
	String max_blk_type		= "";
	String bedBlock_normal  = "";
	String bl_install_yn	= "";
	String bed_blk_period_max = "";
	int srl_no=0;
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt1	= con.createStatement();
		rset1	= stmt1.executeQuery("select nvl(bl_interfaced_yn,'N') bl_interfaced_yn,BED_BLOCK_PERIOD_MAX,BED_BLOCK_PERIOD_MAX_TYPE,bed_block_period_normal from ip_param where facility_id='"+facilityId+"' ") ;
		if(rset1.next())
		{
			bl_install_yn			= rset1.getString("bl_interfaced_yn");
			bedBlock_normal			= rset1.getString("bed_block_period_normal");
			bed_block_period_max	= rset1.getInt("BED_BLOCK_PERIOD_MAX");
			max_blk_type			= rset1.getString("BED_BLOCK_PERIOD_MAX_TYPE");

			if(max_blk_type.equals("D"))
				bed_block_period_max=(bed_block_period_max)*24;
			bed_blk_period_max = ""+bed_block_period_max;
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());

            stmt = con.createStatement();
			//rset1 = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','EMERGENCY_TFR_YN') FROM dual") ;
			
			rset1 = stmt.executeQuery("Select count(*) , AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','EMERGENCY_TFR_YN') from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ") ;
			rset1.next();
	     	srl_no	=	rset1.getInt(1);
			String OsVal=rset1.getString(2);
            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else	if(!OsVal.equals(""))
	{
	/*
	if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
	stmt	=	con.createStatement();
	rset	=	stmt.executeQuery(sqlQuery.toString());	
	if(rset !=null && rset.next())
	srl_no	=	rset.getInt(1);
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	*/
	if(srl_no != 0)
			{
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no'  style='height:10vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/InpatientLookupCriteria.jsp?function_id=<%=function_id%>&jsp_name=PaintEmergencyTransfer.jsp&win_height=33.4&win_width=49.6&function_name=<%=function_name%>&call_function=TransferPatient&wherecondn=EMERGENCY_TFR_YN&bl_install_yn=<%=bl_install_yn%>&bedBlock_normal=<%=bedBlock_normal%>&bed_block_period_max=<%=bed_blk_period_max%>&max_blk_type=<%=max_blk_type%>&oper_stn_id=<%=OsVal%>' frameborder=0 scrolling='no'  style='height:22vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'  style='height:50vh;width:100vw'></iframe>
		<iframe name='desc_frame' id='desc_frame' 	src='QuerySearchResultFrames.jsp?step=bedbook' frameborder=0 scrolling='auto'  style='height:5vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'  style='height:12vh;width:100vw'></iframe>
		
		<%}
		else
		{%>
			<script>alert(getMessage('SETUP_BOOK_SRL_CTL',"IP"))
			document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%	}
       }
	}
	else
            out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}catch(Exception e){/* out.println("Exception in tryCatch TransferPatient: "+ e.toString()); */ e.printStackTrace();}
	
	finally{
		try
		{
			if(rset!=null) rset.close();
			if(rset1!=null) rset1.close();
			if(stmt!=null) stmt.close();
			if(stmt1!=null) stmt1.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee)
		{/* out.println("Error while closing the connections : " + ee.toString()); */ ee.printStackTrace();}
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

