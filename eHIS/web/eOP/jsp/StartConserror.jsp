<!DOCTYPE html>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!--<script src='/eCIS/ca/js/VitalSigns.js' language='javascript'></SCRIPT> -->
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<BODY CLASS="MESSAGE" onKeyDown ='lockKey()'>

<p align="left">
<%
	String error=java.net.URLEncoder.encode(request.getParameter( "err_num" ),"UTF-8");//Modified by Thamizh selvi on 5th Dec 2017
	String moduleId = request.getParameter("moduleId");//Added by Thamizh selvi on 24th Oct 2017 for ML-MMOH-CRF-0623
	if ( error != null ) {%>

		<script>
		var r=decodeURIComponent(("<%=error%>").replace(/\+/g, ' '));//Modified by Thamizh selvi on 5th Dec 2017
		var r1 = r;
		if(r == getMessage("RECORD_MODIFIED","SM")){
			r = r.substr(0,r.length-5);
		}
		alert(r);
		var moduleId = "<%=moduleId%>";
		/*Added by Thamizh selvi on 24th Oct 2017 for ML-MMOH-CRF-0623 Start*/
		if( moduleId == "AE")
		{
			if(r1 == getMessage("RECORD_MODIFIED","SM"))
				{
				 parent.window.returnValue="Y"; 
				//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "Y";  
				}
				
			else
				{
					 parent.window.returnValue="N"; 
				//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "N"; 
					
				}
				
		}/*End*/
		
		//parent.parent.window[2].window[1].window[2].location.reload();
		//parent.parent.document.getElementById('dialog_tag').close();
		parent.window.close();
		</script>
		<%
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		//out.println( "<script language='JavaScript'>parent.tools.document.write ('"+error+"') </script>" ) ;
		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>onsuccess();</script>" ) ;
	}

%>
</p>
</BODY>

