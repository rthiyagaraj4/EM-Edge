<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/BundleInclude.jsp"%>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<title>eHospital Information System</title>
    <script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
    <script Language="JavaScript" src="../../eCommon/js/logout.js"></script>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
request.setCharacterEncoding("UTF-8");	

PreparedStatement pstmt = null;
Connection con = null;
ResultSet rs = null;
String executable            ="";
String responsibility_id=(String) session.getValue( "responsibility_id" ) ;
String desktop_code="" ;
desktop_code=(String) session.getValue( responsibility_id ) ;
String desktop_summary_type  ="";
String desktop_summary_area  ="";
String dflt_module_id        = "";
String dflt_function_id      = "";
String login_user 			= (String) session.getValue( "login_user" ) ;
%>
<script language="JavaScript">
   fullScreen() ;

    function fullScreen() {
        window.resizeTo( screen.availWidth, screen.availHeight ) ;
        window.moveTo( 0,0 ) ;
    }

	function resizing() {
		alert(obj.name)
	}

/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
/*For ALT+F4*/
	document.onkeydown = windowRefreshOrClose;
	document.onkeypress = windowRefreshOrClose
	document.onkeyup = windowRefreshOrClose;
	var wasPressed = false;

	function windowRefreshOrClose(e){
		e = e || window.event;
	    if( wasPressed ) return; 
		if (e.keyCode == 116) {
			wasPressed = true;
		}else {
			if(e.altKey && e.keyCode==115){
				fnLogout("<%=login_user%>");
			}
		}
	 }
	
	//window.onbeforeunload = function (e) {
	//	windowRefreshOrClose();
	//}
	
	window.onbeforeunload = function () {
		fnLogout("<%=login_user%>");
    	}

  
			
			
	/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/


</script>

</head>
<%
try {
	if(desktop_code!=null ){

		con = ConnectionManager.getConnection(request);
		//String module_id             ="";
		//String function_id           ="";
		String function_name         ="";
		String executable_name       ="";
		String function_type         ="";
		//String menu_id               ="";
		String insert_access_yn      ="";
		String update_access_yn      ="";
		String query_only_access_yn  ="";
		String delete_access_yn      ="";
		String print_access_yn       ="";
		int count=0;

		
		String strsql1 = "SELECT DESKTOP_SUMMARY_TYPE, DESKTOP_SUMMARY_AREA, upper(DFLT_MODULE_ID) DFLT_MODULE_ID, upper(DFLT_FUNCTION_ID) DFLT_FUNCTION_ID FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_ID = ?";

		pstmt = con.prepareStatement(strsql1);
		pstmt.setString(1,desktop_code);
		rs = pstmt.executeQuery();

        if(rs!=null && rs.next())
		{
			desktop_summary_type = rs.getString("DESKTOP_SUMMARY_TYPE");
			desktop_summary_area = rs.getString("DESKTOP_SUMMARY_AREA");
			dflt_module_id       = rs.getString("DFLT_MODULE_ID");
			dflt_function_id     = rs.getString("DFLT_FUNCTION_ID");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if (desktop_summary_type.equals("N"))
		{
			String strsql = "SELECT function_id,c.FUNCTION_NAME,c.FUNCTION_TYPE, c.EXECUTABLE_NAME, c.INSERT_ACCESS_YN, c.UPDATE_ACCESS_YN, c.DELETE_ACCESS_YN, c.PRINT_ACCESS_YN, c.QUERY_ONLY_ACCESS_YN FROM sm_resp a, sm_function c WHERE a.resp_id=? AND C.MODULE_ID = '" + dflt_module_id +"' AND C.FUNCTION_ID = '"+dflt_function_id +"' AND EXISTS ( select module_id,function_id from (select module_id,function_id,level lev from sm_menu_dtl connect by prior submenu_id=menu_id start with menu_id=(Select menu_id from sm_resp where resp_id=? )) where function_id is not null AND MODULE_ID = '" + dflt_module_id +"' AND FUNCTION_ID = '"+dflt_function_id +"'  )";
			pstmt = con.prepareStatement(strsql);
			pstmt.setString(1,responsibility_id);
			pstmt.setString(2,responsibility_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
			
						//module_id = rs.getString("module_id");
						//function_id  = rs.getString("function_id");
						function_name ="User Home - " + rs.getString("FUNCTION_NAME");
						executable_name = rs.getString( "EXECUTABLE_NAME" ) ;
						function_type   = rs.getString("function_type");
						//menu_id          = rs.getString("MODULE_ID");
						insert_access_yn = rs.getString("insert_access_yn");
						update_access_yn = rs.getString("update_access_yn");
						query_only_access_yn = rs.getString("query_only_access_yn");
						delete_access_yn = rs.getString("delete_access_yn");
						print_access_yn = rs.getString("print_access_yn");
				
						executable  =  executable_name +"?module_id="   + dflt_module_id     +
							"&function_id=" + dflt_function_id   +
							"&function_name=" + function_name   +
							"&function_type="   + function_type +
							"&menu_id="+ dflt_module_id +
							"&access=" +    insert_access_yn    +
							update_access_yn    +
							query_only_access_yn +
							delete_access_yn    +
							print_access_yn     +"&expand=1";
						count++;
			}
			else{
				executable = "../../eCommon/html/blank.html";
			}

		}
		if((desktop_summary_type!=null && desktop_summary_type.equals("N"))){
			session.putValue("ca_user_desktop_yn","N");
		}else{
			session.putValue("ca_user_desktop_yn","Y");
		}
    	if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

} catch (Exception e) {
	e.printStackTrace();
}
finally
		{
			try
			{
				
				if(con!= null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception e)
			{
				out.println("Exception in eHIS.jsp"+e.toString());
				e.printStackTrace();
			}
		}


	if(desktop_code==null){ 	%>
		<FRAMESET ROWS="12%,*" frameborder="5" FRAMESPACING=0 noresize>
		<FRAME id="header"  SRC="header.jsp" id="header" NAME="header" SCROLLING=NO noresize>		
		<frameset cols="200px,*" frameborder="0"  id="contentFrameset" name="contentFrameset" BORDERCOLOR="red" >
			<frame id="menucontent"  src="FloatMenu.jsp" name="menucontent" scrolling="NO" marginwidth=1 BORDERCOLOR="red" />
			<frame id="content" name="content" src="maindisplay.jsp" scrolling="no" marginwidth=1 BORDERCOLOR="red" noresize/>
		</frameset>
		</FRAMESET>
		<%}else{ %>
				<% if (desktop_summary_type.equals("C")) { %>
				 <FRAMESET ROWS="7.0%,*" frameborder="5" FRAMESPACING=0 noresize>
		           <FRAME SRC="header.jsp?desktop_summary_type=<%=desktop_summary_type%>" id="header" NAME="header" SCROLLING=NO noresize>		
					<frameset frameborder=0 framespacing=0 rows="0%,*,0%" scrolling='auto' id='workArea'   >
						<frame id='plineFrame'  name='plineFrame'  frameborder="no" src='../../eCommon/html/blank.html'  scrolling='no' noresize></frame>
						<frame id='content'  name='content' src='../../eCA/jsp/CAMain.jsp' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes' frameborder=0 noresize>
						<frame id='blankFrameForCharts'  name='blankFrameForCharts' src='../../eCommon/html/blank.html'>
					</frameset>
				 </frameset>					
				<%}else if (desktop_summary_type.equals("N")){  %>
					<FRAMESET ROWS="11.5%,*" frameborder="5" FRAMESPACING=0 noresize id="headerFrameset"  name='headerFrameset'>
					<FRAME SRC="header.jsp?desktop_summary_type=<%=desktop_summary_type%>" id="header" NAME="header" SCROLLING=NO noresize>	
					<frameset cols="200px,*" frameborder="0"  id="contentFrameset" name="contentFrameset" BORDERCOLOR="red" scrolling='no' noresize>
						<frame src='../../eCommon/jsp/UserDesktop.jsp?desktop_summary_area=<%=desktop_summary_area%>' id="menucontent" name="menucontent" marginwidth=1 BORDERCOLOR="red" scrolling='no' noresize />
						<frame id="content" id="content" name="content" src='<%=executable%>' marginwidth=1 BORDERCOLOR="red" scrolling='no' noresize />
					</frameset>
				<%}else{ %>
				<FRAMESET ROWS="12%,*" frameborder="5" FRAMESPACING=0 noresize>
					<FRAME SRC="header.jsp?desktop_summary_type=<%=desktop_summary_type%>" id="header" NAME="header" SCROLLING=NO noresize>		
					<frameset cols="200px,*" frameborder="0"  id="contentFrameset" name="contentFrameset" BORDERCOLOR="red" >
					<frame id="menucontent"  src="FloatMenu.jsp" name="menucontent" scrolling="NO" marginwidth=1 BORDERCOLOR="red" />
					<frame id="content"   name="content" src="maindisplay.jsp" scrolling="no" marginwidth=1 BORDERCOLOR="red" noresize/>
					</frameset>
				</FRAMESET>
			<%}%>		
		<%}%>	
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

</html>
