<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<html>
 <head>

	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%request.setCharacterEncoding("UTF-8");%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eBT/js/BTTransaction.js' language='javascript'></SCRIPT>

<script language='javascript'>
function closeWindow()
{
	parent.window.close();
}

function onRecordBut(obj)
{
	var ob = parent.frames[1];	
	ob.onRecordButton(obj);

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </head>
 

  <body onMouseDown="" onKeyDown="">
  <%
  		HttpSession httpSession = request.getSession(false);
		String strFacilityId=""+httpSession.getValue("facility_id");
		 String opt	  = request.getParameter( "opt" ) ;
		String strRequest,strPrint;
				strRequest="";
				strPrint="";

	
	if(opt.equals("RN")==true)	strPrint="disabled";
	else if(opt.equals("RA")==true) strRequest="disabled";					


		%>
 <form name="BTRRIndicationForm" id="BTRRIndicationForm"  DETAIL_BLOCK_NAME='BTRRSelectionForm' method='post' action=""> 
	<table align='center' width='100%' >
		

		<tr> 

        <td class='GREEN' align='right' width='5%'>&nbsp;</td>
		<td class='label' align='left' width='25%' ><fmt:message key="eBT.ReservednotRequested.label" bundle="${bt_labels}" /></td>
	    <td class='Brown' align='right' width='5%'>&nbsp;</td>
		<td class='label' align='left' width='25%'><fmt:message key="eBT.ReservedRequested.label" bundle="${bt_labels}" /></td>
		<td  align='left' width='28%'>
		<% if(strRequest.length() == 0) { %>
		<input type='button' name='Reqprint' id='Reqprint' value='<fmt:message key="eBT.RequestReprint.label" bundle="${bt_labels}" />'  class='button' onClick='onRecordBut(this)' >
					<%}%>
		<% if(strPrint.length() == 0) { %>
		<input type='button' name='Reprint' id='Reprint'  value='<fmt:message key="Common.Reprint.label" bundle="${common_labels}" />' class='button' onClick='onRecordBut(this)'  >		
			<%}%>
		
		 <% if (opt.equals("RR") == true) {%>
				 <td align ='center' width='*' class='COLUMNHEADERCENTER' >&nbsp;
				<fmt:message key="eBT.Sel.label" bundle="${bt_labels}"/>&nbsp;</td>
			 
				<%}%>

		</td>	




		</tr>
		
		</table>
	
	</form>
  </body>
 </html>

