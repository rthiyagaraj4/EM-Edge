<!DOCTYPE html>
<%@page import="java.util.*,eOR.*,eOR.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function printit() 
	{

		parent.frames[0].focus();
		if (document.all){
			var i = 0;		
			while( i < parent.frames[0].document.applets.length ){
				var j = 0 ;
				while ( !parent.frames[0].document.applets[i].isActive() && j++ <=75000 )
					window.status = i;
					i++;
				}
		window.print();	
		}
	}
	</script>
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="ExternalDisplayNotes" id="ExternalDisplayNotes">
		<table width='100%' height='100%' cellpadding=3 cellspacing=0>
			<tr>
				<td class='button' align='right' colspan='3'>
					<input class="button" type="button" name="print" id="print" onClick='printit()' value="Print">&nbsp;&nbsp;&nbsp;&nbsp;
				</td> 
			</tr>
		</table>
	</form>
	</body>
</html>

