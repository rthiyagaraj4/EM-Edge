<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" import="eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String grp_no = request.getParameter("grp_no");
	String modal	= request.getParameter("modal");
	if(modal == null) modal = "N";

	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function modal_close_win()
		{
			top.window.document.getElementById('dialog_tag').close(); 
		}
	</script>
</head>

		<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>		
		<form name='group_header_title' id='group_header_title'>
			<%	
			if(modal != null && modal.equals("Y")) 
			{
				%>
				<table border=0 cellpadding=0 cellspacing=0 width="100%">
					<tr>
						<td class="COMMON_TOOLBAR" width="" align='left'>
						<input type='button' onclick="modal_apply()"; value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' class='BUTTON'></input>
						<input type='button' onclick="modal_close_win()";  value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='BUTTON'></input>
						</td>
					</tr>
				</table>
				<%
			}
			%>
			<table border='0' width='100%' cellspacing='0' id='tb1' >
			
			<tr>
				<td class='label' width='80%'></td>
				<td class='label' width='15%'></td>			
			</tr>
			<tr><th class='columnheader' colspan='2' style="text-align:left;"><fmt:message key="eDR.DuplicateGroups.label" bundle="${dr_labels}"/></th></tr>
			
			<tr>
				<th class='columnheader' colspan=2 class ='QUERYDATA' style="text-align:left;"><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> = <%=grp_no%></th>
			</tr>
			
			<tr> 					
				<th class='columnheader' style="text-align:left;"> <fmt:message key="eDR.Sug.MainPatientID.label" bundle="${dr_labels}"/></th> 				
				<th class='columnheader' style="text-align:left;"> <fmt:message key="Common.count.label" bundle="${common_labels}"/></th> 	
			</tr>
		
	</table>
			<input type='hidden' name='modal' id='modal' value='<%=modal%>'>
		</form>		
</body>
</html>

