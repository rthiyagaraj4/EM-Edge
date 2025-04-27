<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="CommonInclude.jsp"%>
<%
	//response.setContentType("text/html;charset=UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript">
			function activate( newimg ) {
				document.blankImage.src="../../eCommon/images/" + newimg;
				return true;
			}

			//added by sri
			function onDelete(){
			  parent.deleterecord();
			  parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
			}
			//ends here sri

			function onApply() {
				parent.apply() ;
				parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
			}
		</script>
</head>

<body  onKeyDown = 'lockKey()' class="COMMON_TOOLBAR" leftmargin=0 topmargin=0>

<%
	request.setCharacterEncoding("UTF-8");

	String queryString	= request.getQueryString() ;

	session.putValue( "queryString",queryString) ;


	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	String access		= request.getParameter( "access" ) ;


	String home_required_yn =  request.getParameter("home_required_yn" ) ;
	if (home_required_yn ==null) home_required_yn ="";
	if ( module_id		== null ) module_id 	= "" ;
	if ( function_id		== null ) function_id 	= "" ;
	if ( function_name	== null ) function_name	= "" ;
	if ( function_type	== null ) function_type	= "F" ;
	if ( access			== null ) access		= "NNNNN" ;


	String insert_access	= access.substring( 0,1 ) ;
	String update_access	= access.substring( 1,2 ) ;
	String query_access	= access.substring( 2,3 ) ;
	String delete_access	= access.substring( 3,4 ) ;
	//String print_access	= access.substring( 4,5 ) ;

%>

<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpadding='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<%= function_name %>
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
								if ( function_type.equals( "F" ) && insert_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.create();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='<fmt:message key="Common.create.label" bundle="${common_labels}"/>' name='create' class='BUTTON' ACCESSKEY='C'></input>
								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "F" ) && query_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.query();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' name='query' class='BUTTON' ACCESSKEY='Q'></input>
								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "F" ) && delete_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onDelete();" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='BUTTON' ACCESSKEY='D'></input>
								</td>
							<%
								}
							%>

							<%
								if 	( function_type.equals( "F" ) && ( insert_access.equals( "Y" ) || update_access.equals( "Y" ) ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' class='BUTTON' ACCESSKEY='A'></input>

								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "R" ) || function_type.equals( "P" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.run();" value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>' name='run'  class='BUTTON' ACCESSKEY='R'></input>
								</td>
							<%
								}
							%>

								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.reset();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='reset' class='BUTTON' ACCESSKEY='R'></input>
								</td>

								<td class="COMMON_TOOLBAR">
									<td class="COMMON_TOOLBAR">
									<%if (!home_required_yn.equals("N")) {%>
									<input type='button' onClick='parent.parent.parent.frames[1].expand(this)' onclick="'" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>
									<%}%>
								</td>
	
								</tr>
						</table>
					</td>

					<td class="COMMON_TOOLBAR" align="right" width="50%">

					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

