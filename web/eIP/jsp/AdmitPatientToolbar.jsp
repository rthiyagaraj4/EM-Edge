<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%	request.setCharacterEncoding("UTF-8"); 
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/MPValidateControl.js' language='javascript'></script>
	<script language="JavaScript">
		function activate( newimg ) 
		{
			document.blankImage.src="../../eCommon/images/" + newimg;
			return true;
		}

		//added by sri
		function onDelete()
		{
		  parent.deleterecord();
		  parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		}
		//ends here sri

		function onApply() 
		{
			parent.apply() ;
			//parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		}
	</script>
</head>
<%
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
%>
<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown='lockKey()'>

<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<fmt:message key="Common.AdmitPatient.label" bundle="${common_labels}"/>
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
								<input type='button' onclick="onApply();" value='Apply' name='apply' id='apply' class='BUTTON'></input>
    						  </td>
							  <td class="COMMON_TOOLBAR">
								<%if(from_adv_bed_mgmt.equals("N")){%>
								 <input type='button' onclick="top.close();" value='Menu' name='home' id='home' class='BUTTON'></input>
								<%}else{%>
									<input type='button' onclick="top.close();" value='Close' name='home' id='home' class='BUTTON'></input>
								<%}%>
							  </td>
							</tr>
						</table>
					</td>

					<!-- <td class="COMMON_TOOLBAR" align="right" width="50%">
						<input type='button' onclick="parent.print();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='Print' name='print' id='print' class='BUTTON'></input>

						<input type='button' onclick="parent.showhelp()" value='Help' name='help' id='help' class='BUTTON'></input>
					</td> -->
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

