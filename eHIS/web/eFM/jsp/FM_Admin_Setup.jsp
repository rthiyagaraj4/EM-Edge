<!DOCTYPE html>
<!--
	Created On	: 6/7/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Admin Setup	
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con			=	null;
	java.sql.Statement stmt	=	null;
	ResultSet	rs			=	null;
	String maintain_doc_or_file = "";
	String mysql				= "SELECT maintain_doc_or_file FROM mp_param";
	try
	{
		con  = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs   =  stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		}
	%>
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows[prev].cells[0].className=prevcol;
				prevcol=ro.cell[0].className;
				ro.cells[0].className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'FMParameter')
				parent.frames[1].location.href = '../../eFM/jsp/FMParam.jsp?module_id=MP&function_id=FM_PARAM&function_name='+encodeURIComponent(getLabel('eFM.FMParameter.label','FM'))+'&function_type=F&access=NYNNN';

			if(val == 'DTParameter')
				parent.frames[1].location.href = '../../eFM/jsp/FMParam.jsp?module_id=MP&function_id=FM_PARAM&function_name='+encodeURIComponent(getLabel('eFM.DTParameter.label','FM'))+'&function_type=F&access=NYNNN';

			if(val == 'FMUserAccessRights')
				parent.frames[1].location.href = '../../eFM/jsp/FMUserRights.jsp?module_id=FM&function_id=FM_USER_RIGHTS&function_name='+encodeURIComponent(getLabel('Common.UserAccessRights.label','common'))+'&function_type=F&access=YYYYY';
		}

	</script>

	</head>

	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
	<%
			if(maintain_doc_or_file.equals("F"))
			{
	%>		

		<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMParameter') class='MENUSUBLEVELLINK'><fmt:message key="eFM.FMParameter.label" bundle="${fm_labels}"/></a></td>
		</tr>
	<%
		}
		else if(maintain_doc_or_file.equals("D"))
		{
	%>
		<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('DTParameter') class='MENUSUBLEVELLINK'><fmt:message key="eFM.DTParameter.label" bundle="${fm_labels}"/></a></td>
		</tr>
	<%		
		}
	%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick=javascript:callJSPs('FMUserAccessRights') class='MENUSUBLEVELLINK'><fmt:message key="Common.UserAccessRights.label" bundle="${common_labels}"/></a></td>
		</tr>


			 <tr>
				 <td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
			 </tr> 
	</table>
	</form>
<%
	if(rs   != null) rs.close();
	if(stmt != null) stmt.close();
	}
		catch(Exception e)
		{
			out.println("Exception e:"+e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
%>
	</body>
	
</html>

