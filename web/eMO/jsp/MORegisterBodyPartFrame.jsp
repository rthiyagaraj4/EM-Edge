<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../../eMO/js/MORegisterBodyPart.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>parent.messageFrame.location.href="../../eMO/jsp/MOManageDeceasedColor.jsp"

</script>
<%
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String parmeters = request.getQueryString() ;
	
//	String source = url + parmeters ;
 
	String function_id=request.getParameter("function_id");
	%>
   
 
    <frameset rows='35%,*,3%' id="b">
	
   <frame name='patientFrame' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?function_id=<%=function_id%>&callfrom=callfrombdyprt' frameborder=0 scrolling='no' noresize>
   <frame name='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
  <frame name='messageFrame' src='' frameborder=0 noresize scrolling='no'>
  
	</frameset>
 


<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>


</html>

