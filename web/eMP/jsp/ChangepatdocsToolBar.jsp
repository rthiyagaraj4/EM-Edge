<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
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

<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown='lockKey();'>
<%
String home_required_yn =  request.getParameter("home_required_yn" ) ;
String function_id =  request.getParameter("function_id")==null?"N":request.getParameter("function_id") ;
if (home_required_yn ==null) home_required_yn ="";
%>
<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<fmt:message key="eMP.ChgPatDtl.title.label" bundle="${mp_labels}"/>
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
							<%if (home_required_yn.equals("N")){
								if(function_id.equals("CHG_PAT_DTLS")){%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.reset();"value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='reset' id='reset' class='BUTTON'></input>
							</td>
								<%}else{%>
							
							<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.close();"value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='expand' id='expand' class='BUTTON' disabled></input>
							</td>
							<%}
							}else{%>
							<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.parent.parent.frames[1].expand(this)"value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='expand' id='expand' class='BUTTON'></input>
								</td>
							<%}%>
							</tr>
						</table>
					</td>
<!-- 					<%//if (!home_required_yn.equals("N")) {%>
					<td class="COMMON_TOOLBAR" align="right" width="50%">
						<input type='button' onclick="parent.print();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='Print' name='print' id='print' class='BUTTON'></input>

						<input type='button' onclick="parent.showhelp()" value='Help' name='help' id='help' class='BUTTON'></input>
			

					</td>
 -->						<%//}%>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

