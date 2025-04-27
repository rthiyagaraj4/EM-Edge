<!DOCTYPE html>
<html>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<% 
  String  message = "";
  String facility="";
  String comm_type ="";
  String comm_client = "";
  String appl_Id ="";
  String process_id ="";
  String process_status = "";
  message =request.getParameter("message");
  facility=(String)request.getAttribute("facility");
  comm_type =(String) request.getAttribute("comm_type"); 
  comm_client =(String) request.getAttribute("comm_client"); 
  appl_Id = (String)request.getAttribute("appl_Id");
  process_id =(String) request.getAttribute("process_id");
  process_status =(String) request.getAttribute("process_status");
%>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
function callFirst()
{
	parent.f_query_img.location.href ='../eCommon/html/blank.html';
	parent.f_query_btn.location.href ='../eCommon/html/blank.html';
	<% 
		if (comm_type.equalsIgnoreCase("O")) 
	{ %> review_commprocess_refresh_form.action ='../eXH/jsp/ReviewCommProcessOutbound.jsp';
	<%} if (comm_type.equalsIgnoreCase("I")) { %>
      review_commprocess_refresh_form.action ='../eXH/jsp/ReviewCommProcessInbound.jsp';
	<%} %>
	review_commprocess_refresh_form.target="f_query_add_mod";
	review_commprocess_refresh_form.submit();

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY CLASS="MESSAGE" onLoad="callFirst();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="review_commprocess_refresh_form" id="review_commprocess_refresh_form">
<input type="hidden" name="facility" id="facility" value='<%=facility%>'/>
<input type="hidden" name="comm_client" id="comm_client" value='<%=comm_client%>'/>
<input type="hidden" name="appl_Id" id="appl_Id" value='<%=appl_Id%>'/>
<input type="hidden" name="process_status" id="process_status" value='<%=process_status%>'/>
<input type="hidden" name="process_id" id="process_id" value='<%=process_id%>'/>
<input type="hidden" name="comm_type" id="comm_type" value='<%=comm_type%>'/>
<p align="left">
<%=message%>
</p>
</form>
</BODY>
</html>

