<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

    <script language='javascript' src='../../eSM/js/RecordTrans.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    </head>
<%
    
%>
<iframe name='RecordTransFrame1' id='RecordTransFrame1'  src='../../eSM/jsp/RecordTrans1.jsp' frameborder=0 scrolling='no' noresize style='height:1vh;width:100vw'></iframe> 
	 <iframe name='RecordTransFrame2' id='RecordTransFrame2'  src='../../eCommon/html/blank.html' frameborder=0  scrolling='no'>
	 <iframe name='RecordTransFrame3' id='RecordTransFrame3'  src='../../eCommon/html/blank.html' frameborder=0 scrolling='yes' noresize style='height:10vh;width:100vw'></iframe>
	

</html>

