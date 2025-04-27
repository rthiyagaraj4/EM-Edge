<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="CommonInclude.jsp"%>

<html>
<head>
    <script src="../js/common.js" language="javascript"></script>

<SCRIPT LANGUAGE="JavaScript">
<%
	String persFrom=request.getParameter("persFrom")==null?"":request.getParameter("persFrom");
%>

function apply(){

	var contin=true;
	var called_from=frames[1].document.forms[0].called_from.value;

	//if(frames[1].document.forms[0].name=='ModifyLang_form'){

		if(frames[1].document.forms[0].called_from.value=='CA_PATIENT_CHART'){
			contin=false;
			
			var warn_msg=getMessage("LANG_SWITCH_REL_CHRT","SM");

			if(window.confirm(warn_msg)){
				contin=true;
			}
		}
	//}

	if(contin){
		var err_msg=getMessage("RECORD_MODIFIED","SM");
		alert(err_msg);
		f_query_add_mod.change(called_from);

		//top.location.href=top.location.href;
		if( frames[1].document.forms[0].called_from.value!='CA_PATIENT_CHART'){

			if('<%=persFrom%>'=='HomeSummary'){
				top.frames[0].location.href=top.frames[0].location.href;
				top.frames[2].frames[0].location.href=top.frames[2].frames[0].location.href;
				top.frames[2].frames[1].location.href=top.frames[2].frames[1].location.href;

			}else{
				top.location.href=top.location.href;
			}
			
		}else{
			window.returnValue ='Success';
			window.close();
		}
	}  
}
function reset(){
	
f_query_add_mod.document.ModifyLang_form.reset();

} 
</SCRIPT>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 String called_from = request.getParameter("CALLED_FROM")==null?"":request.getParameter("CALLED_FROM");

		 
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/FreqAccessFunc.js'></script>
	<%if(called_from!=null && called_from.equals("CA_PATIENT_CHART")){%>
	<title><fmt:message key="Common.switchlanguage.label" bundle="${common_labels}"/></title>
	<%}%>
</head>
	<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("UTF-8");	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//out.println(url);
	//out.println("--->"+params);
	Connection con =null;
	con = ConnectionManager.getConnection(request);
	int count=0;
	PreparedStatement pstmt=null ;
	ResultSet reset=null;
	
	//out.println("--->"+called_from);

	
	

	try{
		//pstmt = con.prepareStatement("select count(*) as total from sm_language where EFF_STATUS='E' and LANGUAGE_DIRECTION !='R'");
		pstmt = con.prepareStatement("select count(*) as total from sm_language where EFF_STATUS='E'");
		reset=pstmt.executeQuery();
		if (reset != null && reset.next()) {
			count = reset.getInt("total");
		}
		if(count != 1){%>
			</script>
			<%if(called_from!=null && called_from.equals("CA_PATIENT_CHART")){%>
				<frameset rows='20,*,50'>
					<frame id='commontoolbarFrame'  name='commontoolbarFrame'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize>			
			
			<%}else{%>
				<frameset rows='42,*,50'>
					<frame id='commontoolbarFrame'  name='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize>
			<%}%>
				
					<frame id='f_query_add_mod'  name='f_query_add_mod' 	src="../../eCommon/jsp/ModifyLanguage.jsp?called_from=<%=called_from%>" frameborder=0>
					<frame id='messageFrame'  name='messageFrame'		src='error.jsp' frameborder=0 noresize scrolling='auto'>
				</frameset>
			</script>
		<%}else{%>
			<script>
				alert(getMessage("SWITCH_LANG_NOT_APPL","Common"));
			</script>
		<%}
		if(reset !=null)
			reset.close();
		if(pstmt!=null)
			pstmt.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>




</html>
