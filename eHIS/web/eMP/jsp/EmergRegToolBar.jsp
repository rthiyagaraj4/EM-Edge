<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

	<script language="JavaScript">
		function activate( newimg ) {
			document.blankImage.src="../../eCommon/images/" + newimg;
			return true;
		}

		//added by sri
		function onDelete(){
		  parent.deleterecord();
		  parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		}
		//ends here sri

		function onApply() {
			
		parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		parent.apply() ;
			

		}
	</script>
</head>

<body class="COMMON_TOOLBAR" leftmargin='0' topmargin='0' onKeyDown='lockKey();'>



<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<fmt:message key="eMP.EmerRegn.label" bundle="${mp_labels}"/>
		</td>
	</tr>
	<tr class="COMMON_TOOLBAR">
		<td class="COMMON_TOOLBAR">
			<table width="100%" cellspacing='0' cellpading='0'>
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" align="left" width="50%">
						<table cellspacing='0' cellpading='0'>
							<tr class="COMMON_TOOLBAR">
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' id='apply' class='BUTTON'></input>
								</td>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.close();"value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='expand' id='expand' class='BUTTON'></input>
								</td>
							</tr>
						</table>
					</td><td class='label'>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>

