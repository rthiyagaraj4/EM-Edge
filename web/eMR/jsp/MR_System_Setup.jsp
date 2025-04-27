<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
	<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		
	<script language="JavaScript">
		var expand = "";
		var temparr = new Array();
		var count = 0;
		var prev='a';
		var prevcol='ECMENUHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
			if(prev!='a')
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			
			if(val == 'MR_PARAMETER')
				{
				parent.frames[1].location.href = '../../eMR/jsp/Mrparameter.jsp?module_id=MR&function_id=MR_PARAMETER&function_name='+encodeURIComponent(getLabel("eMR.MRParameter.label","MR"))+'&function_type=F&access=NYNNN';
				}
			if(val == 'USER_ACCESS_RIGHTS'){
				parent.frames[1].location.href = '../../eMR/jsp/MrUserAccessRights.jsp?module_id=MR&function_id=USER_ACCESS_RIGHTS&function_name='+encodeURIComponent(getLabel("Common.UserAccessRights.label","common"))+'&function_type=F&access=YYYNN';
			}
		}
		
		function refreshPage()
		{
			parent.frames[0].location.href='../../eMR/jsp/MR_System_Setup.jsp?expand='+expand
		}
		
		function chkRow( ro,val,exp )
		{
			var E =expand.charAt(0)
			var A =expand.charAt(1)
			var P =expand.charAt(2)			
			var O =expand.charAt(3)
			var Q =expand.charAt(4)			
			var R =expand.charAt(5)
			var B =expand.charAt(6)
			if( val == "E" )
			{
				if( exp =="E")
					E = "C";
				else
					E = "E";
			}
			
			if( val == "A"  )
			{
				 if( exp =="E" )
					A= "C"
				else
					A = "E";
			}
			if( val == "P" )
			{
				if(exp =="E" )
					P="C";
				else
					P ="E"
			}
			if( val == "O")
			{
				if(exp =="E" )
					O ="C"
				else
					O ="E"
			}
			if( val == "Q")
			{
				if(exp =="E" )
					Q ="C"
				else
					Q ="E"
			}
			if( val == "R")
			{
				if(exp =="E" )
					R ="C"
				else
					R ="E"
			}
			if( val == "B" )
			{
				if( exp =="E")
					B = "C";
				else
					B = "E";
			}
		
			expand = E + A + P + O + Q + R + B;
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<% 
String expand=request.getParameter("expand");
if( expand == null) expand="CCCCCCC";
//String responsibility_id= (String) session.getValue("responsibility_id");
//String Log_user= (String)session.getValue("login_user");
//Connection con=null;
//ResultSet rs=null;
//Statement stmt=null;
%>
	<body style="background-color:dimgray;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="MRSystemSetup_form" id="MRSystemSetup_form">
	<table cellspacing=1 cellpadding=2 width='111%' border=0 id='t'>
		<% //if(expand.charAt(0) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('MR_PARAMETER')">&nbsp;&nbsp;<fmt:message key="eMR.MRParameter.label" bundle="${mr_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('USER_ACCESS_RIGHTS')" >&nbsp;&nbsp;<fmt:message key="Common.UserAccessRights.label" bundle="${common_labels}"/></td>
		</tr>
		<%
//			out.println( "<script>expand='"+ expand +"'</script>" );
		%>
		 <tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr> 
	
		</table>

	</body>
	
	</form>
</html>

