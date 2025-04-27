<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
    
	response.setContentType("text/html;charset=UTF-8");
	String error=request.getParameter( "err_num" );
	String home_required_yn	=request.getParameter("home_required_yn");
	String invoke_from	= request.getParameter("invoke_from") == null ?"" : request.getParameter("invoke_from");//Added by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	
	if ( error != null ) {

		/*InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( error.getBytes()), "UTF-8" ) ;
		error = (new BufferedReader(reader)).readLine() ;*/
		if ( error == null ) error = "" ;

		if(!invoke_from.equals("EMER_REGN_NB")){
			out.println( error ) ;
		}
		out.println( "<script language='JavaScript'>parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=AE&function_id=AE_REGISTER_ATTN&function_name=Register Attendance&function_type=F&access=NYNNN&home_required_yn="+home_required_yn+"';</script>" ) ;
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) &&  !invoke_from.equals("EMER_REGN_NB")){
			out.println( "<script language='JavaScript'>parent.onSuccess();</script>" ) ;
		}else{%>
			<script>
				var errMsg	= "<%=error%>";
				errMsg = errMsg.replace(/<(?:.|\n)*?>/gm, '');
				alert(errMsg);
				parent.window.close();
			</script>
		<%}
	}

%>
</p>
</BODY>

