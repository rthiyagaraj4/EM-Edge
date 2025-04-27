
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
//		java.util.Locale loc = new java.util.Locale(locale);
		//java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
%>
<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
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
	</script>
</head>

<body  onKeyDown = 'lockKey()' class="COMMON_TOOLBAR" leftmargin=0 topmargin=0>
<%
	String functionname	    = checkForNull(request.getParameter("function_name"));
	String function_type	= checkForNull(request.getParameter("function_type"),"F") ;
	String access			= checkForNull(request.getParameter("access" ),"NNNNN");
	String home_required_yn = checkForNull(request.getParameter("home_required_yn" ),"N").substring(0,1);
	
	String insertaccess		= access.substring( 0,1 ) ;
	String updateaccess	= access.substring( 1,2 ) ;
	String queryaccess		= access.substring( 2,3 ) ;
	String deleteaccess		= access.substring( 3,4 ) ;
//	String printaccess		= access.substring( 4,5 ) ;

	String QueryString	= request.getQueryString() ;
	session.putValue( "IPQueryString", QueryString ) ;
%>
<form name="CommonToolbar_form" id="CommonToolbar_form">
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
									 <input type='button' onclick="parent.create();parent.messageFrame.location.href='MstCodeError.jsp'" value='<fmt:message key="Common.create.label" bundle="${common_labels}"/>' name='create' id='create' class='BUTTON'></input>
								</td>
									<%
								}
							%>

								<%
									if ( queryaccess.equals( "Y" ) ) {
								%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.query();parent.messageFrame.location.href='MstCodeError.jsp'" value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' name='query' id='query' class='BUTTON'></input>
								</td>
									<%
								}
							%>

							<%
								if ( deleteaccess.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onDelete();" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='BUTTON' id='Delete' name='Delete'></input>
								</td>
							<%
								}
							%>
								
							<%
								if( insertaccess.equals( "Y" ) || updateaccess.equals( "Y" ) ) 
								{
							%>
								<td class="COMMON_TOOLBAR">
										<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' id='apply' class='BUTTON'></input>
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
									<input type='button' onclick="parent.run();" value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>' id='run' name='run'  class='BUTTON'></input>
								</td>
							<%
								}
							%>
							

								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.reset();parent.messageFrame.location.href='MstCodeError.jsp'" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' id='reset' name='reset' class='BUTTON'></input>
								</td>

								<td class="COMMON_TOOLBAR">
									<td class="COMMON_TOOLBAR">
									<%if (home_required_yn.equals("Y")) {%>
									<input type='button' onClick='parent.parent.parent.frames[1].expand(this)'
									value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' id='home' name='home' class='BUTTON'></input>
									<%}%>
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

