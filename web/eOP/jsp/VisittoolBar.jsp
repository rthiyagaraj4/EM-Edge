<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
<%
    request.setCharacterEncoding("UTF-8");
    String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> 
	<script language="JavaScript">
		function activate( newimg ) {
			document.blankImage.src="../../eCommon/images/" + newimg;
			return true;
		}

		function onDelete(){
		  parent.deleterecord();
		  parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		}

		function onApply() {
		parent.apply() ;
		//parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
			

		}
	</script>
</head>

<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown ='lockKey()'>
<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION"><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/>
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
									<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' class='BUTTON'></input>
								</td>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="top.close();" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='expand' class='BUTTON'></input>
								</td>

							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

