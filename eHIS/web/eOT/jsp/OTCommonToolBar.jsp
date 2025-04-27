<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
   <!--  <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eOT/js/OTMessages.js"></script> -->
	<script language="Javascript" src="../../eOT/js/Slate.js"></script>
	<script language="Javascript" src="../../eOT/js/Booking.js"></script>
	<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>

	<script language="JavaScript">
		function activate( newimg ) {
			document.blankImage.src="../images/" + newimg;
			return true;
		}

		function onDelete(){
		  parent.deleterecord();
		  parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
		}

		function onApply() {
			parent.apply() ;
			//parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
		}
		function gohome() {
			history.go(-1);
			//parent.commontoolbarFrame.location.href='../html/process.html';
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String functionname	= request.getParameter("function_name");
	String function_type	= request.getParameter( "function_type" ) ;
	String access				= request.getParameter( "access" ) ;
	String insertaccess		= access.substring( 0,1 ) ;
	String updateaccess	= access.substring( 1,2 ) ;
	String queryaccess		= access.substring( 2,3 ) ;
	String deleteaccess		= access.substring( 3,4 ) ;
	String printaccess		= access.substring( 4,5 ) ;

	String QueryString	= request.getQueryString() ;
	session.putValue( "IPQueryString", QueryString ) ;
%>
<form name="CommonToolbar_form_ot" id="CommonToolbar_form_ot">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<%= functionname %>
		</td>
	</tr>
	<tr class="COMMON_TOOLBAR">
		<td class="COMMON_TOOLBAR">
			<table width="100%" cellspacing='0' cellpading='0'>
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" align="left" width="50%">
						<table cellspacing='0' cellpading='0'>
							<tr class="COMMON_TOOLBAR">
								<%
									if ( insertaccess.equals( "Y" ) ) {
								%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.create();parent.messageFrame.location.href='MstCodeError.jsp'" value='<fmt:message key="Common.create.label" bundle="${common_labels}"/>' name='create' class='BUTTON'></input>
								</td>
								<td class="COMMON_TOOLBAR">
										<input type='button' onclick="onApply();" value='<fmt:message key="Common.home.label" bundle="${common_labels}"/>' name='apply' class='BUTTON'></input>
								</td>
									<%
								}
							%>

								<%
									if ( queryaccess.equals( "Y" ) ) {
								%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.query();parent.messageFrame.location.href='MstCodeError.jsp'" value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' name='query' class='BUTTON'></input>
								</td>
										 <td class="COMMON_TOOLBAR">
										<input type='button' onclick="onApply();" value='<fmt:message key="Common.home.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>
								</td>
									<%
								}
							%>

							<%
								if ( deleteaccess.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onDelete();" value='Delete' class='BUTTON'></input>
								</td>
										<td class="COMMON_TOOLBAR">
										<input type='button' onclick="onApply();" value='<fmt:message key="Common.home.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>
								</td>
							<%
								}
							%>
								
							<%
								if( insertaccess.equals( "Y" ) || updateaccess.equals( "Y" ) ) 
								{
							%>
								<td class="COMMON_TOOLBAR">
										<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply'  class='BUTTON'></input>
								</td>
										
									<%
								}
							%>

							<%
								if ( function_type.equals( "R" ) || function_type.equals( "P" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<!-- <img src="../../eCommon/images/Rrun.gif"
									alt="Run"
				 					onClick="parent.run();"
									onMouseOver="src='../../eCommon/images/RRrun.gif'"
									onMouseOut="src='../../eCommon/images/Rrun.gif'"> -->
									<input type='button' onclick="parent.run();" value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>' name='run'  class='BUTTON'></input>
								</td>
										
							<%
								}
							%>

								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.reset();" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='reset' class='BUTTON'></input>
								</td>
								<td class="COMMON_TOOLBAR">
										<!--<input type='button'onclick="parent.location.href='../../eCommon/jsp/dmenu.jsp'" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>-->
										<input type='button' onClick='parent.parent.parent.frames[1].expand(this)' value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>
										
								</td>

							</tr>
						</table>
					</td>

					<td class="COMMON_TOOLBAR" align="right" width="50%">
						<%
//							if ( printaccess.equals( "Y" ) ) {
						%>
<!-- 						<input type='button' onclick="parent.print();parent.messageFrame.location.href='MstCodeError.jsp'" value='Print' class='BUTTON'></input> -->
							<%
//								}
							%>

<!-- 						<input type='button' onclick="alert('Help is under construction')" value='Help' class='BUTTON'></input> -->


					</td>

					
				</tr>
			</table>
		</td>
	</tr>
<table>
</form>
</body>
</html>

