<!DOCTYPE html>
<HTML>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% 
  String facility="";
  String comm_type ="";
  String comm_client = "";
  String appl_Id ="";
  String process_id ="";
  String process_status = "";
%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function func2
function func2()
{
	if(document.forms[0].sel_process.value=='DTraxAppl')
		window.open("ReviewCommProcessPopup.jsp?type=outbound&appl=DTraxAppl","ReviewCommunicationProcess",100,100);
		else
		window.open("ReviewCommProcessPopup.jsp?type=inbound&appl=PACS","ReviewCommunicationProcess",800,600);
			
}
//function checkCondition
function checkCondition()
{
 <% 
 	 facility=request.getParameter("facility");
	 comm_type = request.getParameter("comm_type"); 
	 comm_client = request.getParameter("comm_client"); 
	 appl_Id = request.getParameter("appl_Id");
	 process_id = request.getParameter("process_id");
	 process_status = request.getParameter("process_status");
 %>
  
  var Startbtn=document.getElementById("Start");
  var Stopbtn=document.getElementById("Stop");
   var Refreshbtn=document.getElementById("Refresh");

  <% if( process_status.equalsIgnoreCase("C")) {%>Stopbtn.disabled=true;   
       Startbtn.enabled=true; <%}%>  
	  
  
  
  <% if( process_status.equalsIgnoreCase("S"))
	{ %> 
	      Startbtn.disabled=true;  <%} %> 

  
}
//function startProcess
function startProcess()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].action ='../../servlet/eXH.XHProcessControllerServlet';
	this.document.forms[0].action_type.value="Start";
	this.document.forms[0].target='messageFrame';
	this.document.forms[0].submit();
}
//function stopProcess
function stopProcess()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].action ='../../servlet/eXH.XHProcessControllerServlet';
	this.document.forms[0].action_type.value="Stop";
	this.document.forms[0].target='messageFrame';
	this.document.forms[0].submit();
}
//function refreshProcess
function refreshProcess()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	parent.f_query_img.location.href ='../../eCommon/html/blank.html';
	parent.f_query_btn.location.href ='../../eCommon/html/blank.html';
	
	<%
		if (comm_type.equalsIgnoreCase("O")) 
	{ %> review_commprocess_footer_form.action ='../../eXH/jsp/ReviewCommProcessOutbound.jsp';
	<%} if (comm_type.equalsIgnoreCase("I")) { %>
      review_commprocess_footer_form.action ='../../eXH/jsp/ReviewCommProcessInbound.jsp';
	<%} %>
	review_commprocess_footer_form.target="f_query_add_mod";
	review_commprocess_footer_form.submit();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="checkCondition()">
<form name="review_commprocess_footer_form" id="review_commprocess_footer_form" method="post" >
<input type="hidden" name="action_type" id="action_type"/>
<input type="hidden" name="facility" id="facility" value='<%=facility%>'/>
<input type="hidden" name="comm_client" id="comm_client" value='<%=comm_client%>'/>
<input type="hidden" name="appl_Id" id="appl_Id" value='<%=appl_Id%>'/>
<input type="hidden" name="process_status" id="process_status" value='<%=process_status%>'/>
<input type="hidden" name="process_id" id="process_id" value='<%=process_id%>'/>
<input type="hidden" name="comm_type" id="comm_type" value='<%=comm_type%>'/>
<input type="hidden" name="mode" id="mode" value='W'/>		

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td width='90%'></td> 
<td width='10%'></td> 
</tr>
<tr>
<td></td>
<td ><input class='BUTTON' type="button" id="Start" name=review value='<fmt:message key="eXH.Start.Label" bundle="${xh_labels}"/>' onClick="startProcess()"><input class='BUTTON' type="button"  name=reset value='<fmt:message key="eXH.Stop.Label" bundle="${xh_labels}"/>' id="Stop" onClick="stopProcess()"><input class='BUTTON'  type="button"  name=reset value='<fmt:message key="eXH.Refresh.Label" bundle="${xh_labels}"/>' id="Refresh" onClick="refreshProcess()"></td>
</tr>
<tr>
<td width='90%'></td> 
<td width='10%'></td> 
</tr>
</table>
</form>
</body>
</html>

