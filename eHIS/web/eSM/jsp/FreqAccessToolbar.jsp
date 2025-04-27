<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<head>
	<%
          String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>


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

		function reloadfun()
		{
		
		
		parent.parent.frames[0].location.href='../../eCommon/jsp/header.jsp' 
       
		}
	</script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>

<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0
onKeyDown = 'lockKey()'>

<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	String access		= request.getParameter( "access" ) ;
	String queryString	= request.getQueryString() ;

	String home_required_yn =  request.getParameter("home_required_yn" ) ;
	if (home_required_yn ==null) home_required_yn ="";
	if ( module_id		== null ) module_id 	= "" ;
	if ( function_id		== null ) function_id 	= "" ;
	if ( function_name	== null ) function_name	= "" ;
	if ( function_type	== null ) function_type	= "F" ;
	if ( access			== null ) access		= "NNNNN" ;

	session.putValue( "queryString", queryString ) ;

	String insert_access	= access.substring( 0,1 ) ;
	String update_access	= access.substring( 1,2 ) ;
	String query_access	= access.substring( 2,3 ) ;
	String delete_access	= access.substring( 3,4 ) ;
	

%>

<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpadding='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td class="COMMONTOOLBARFUNCTION">
			<% out.println(function_name );
			out.flush();%>
		</td>
	</tr>
	<tr class="COMMON_TOOLBAR">
		<td class="COMMON_TOOLBAR">
			<table width="100%" cellspacing='0' cellpadding='0'>
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" width="50%">
						<table cellspacing='0' cellpadding='0'>
							<tr class="COMMON_TOOLBAR">
							<%
								if ( function_type.equals( "F" ) && insert_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<!-- <img src="../../eCommon/images/Rcreate.gif"
									 alt="Create Record"
									 onClick="parent.create();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'"
									 onMouseOver="src='../../eCommon/images/RRcreate.gif'"
									 onMouseOut="src='../../eCommon/images/Rcreate.gif'"> -->
									 <input type='button' onclick="parent.create();parent.messageFrame.location.href='../../eSM/jsp/FreqAccessFuncError.jsp'" value='<fmt:message key="Common.create.label" bundle="${common_labels}"/>' name='create' class='BUTTON' ACCESSKEY='C'></input>
								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "F" ) && query_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
								<!--	<img src="../../eCommon/images/Rquery.gif"
				 					alt="Query Record"
				 					onClick="parent.query();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'"
				 					onMouseOver="src='../../eCommon/images/RRquery.gif'"
				 					onMouseOut="src='../../eCommon/images/Rquery.gif'"> -->
									 <input type='button' onclick="parent.query();parent.messageFrame.location.href='../../eSM/jsp/FreqAccessFuncError.jsp'" value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' name='query' class='BUTTON' ACCESSKEY='Q'></input>
								</td>
							<%
								} 
							%>

							<%
								if ( function_type.equals( "F" ) && delete_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<!-- <img src="../../eCommon/images/Rdelete.gif"
				 					alt="Delete Record"
				 					onClick = "onDelete();"
				 					onMouseOver="src='../../eCommon/images/RRdelete.gif'"
				 					onMouseOut="src='../../eCommon/images/Rdelete.gif'"> -->
									<input type='button' onclick="onDelete();" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='BUTTON' ACCESSKEY='D'></input>
								</td>
							<%
								}
							%>

							<%
								if 	( function_type.equals( "F" ) && ( insert_access.equals( "Y" ) || update_access.equals( "Y" ) ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<!-- <img src="../../eCommon/images/Rsave.gif"
									onClick="onApply();"
									alt="Apply"
									onMouseOver="src='../../eCommon/images/RRsave.gif'"
									onMouseOut="src='../../eCommon/images/Rsave.gif'">  -->
									<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' class='BUTTON' ACCESSKEY='A'></input>

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
									<input type='button' onclick="parent.run();" value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>' name='run'  class='BUTTON' ACCESSKEY='R'></input>
								</td>
							<%
								}
							%>

								<td class="COMMON_TOOLBAR">
								<!--	<img src="../../eCommon/images/Rreset.gif"
									onClick="parent.reset();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'"
									alt="Reset"
									onMouseOver="src='../../eCommon/images/RRreset.gif'"
									onMouseOut="src='../../eCommon/images/Rreset.gif'">  -->
									<input type='button' onclick="parent.reset();parent.messageFrame.location.href='../../eSM/jsp/FreqAccessFuncError.jsp'" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='reset' class='BUTTON' ACCESSKEY='R'></input>
								</td>

								<!--<td class="COMMON_TOOLBAR">
								<td class="COMMON_TOOLBAR">
									<input type='button' onClick='parent.parent.parent.frames[1].expand(this)' onclick="'" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='expand' class='BUTTON'></input>
								</td>
								</td>-->
							</tr>
						</table>
					</td>

					<td class="COMMON_TOOLBAR" width="50%">
						<!-- <img src="../../eCommon/images/Rprint.gif"
						alt="Print"
			 			onClick="parent.print();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'"
			 			onMouseOver="src='../../eCommon/images/RRprint.gif'"
			 			onMouseOut="src='../../eCommon/images/Rprint.gif'">

						<img src="../../eCommon/images/Rhelp.gif" alt="Help"
						onClick="alert('Help is under construction')" 
						
						onMouseOver="src='../../eCommon/images/RRhelp.gif'"
						onMouseOut="src='../../eCommon/images/Rhelp.gif'">

						<img src="../../eCommon/images/Ronline.gif"
						alt="Online Support"
						onClick="mailto:support@ocsindia.com"
						onMouseOver="src='../../eCommon/images/RRonline.gif'"
						onMouseOut="src='../../eCommon/images/Ronline.gif'">
-->
<!-- 						<input type='button' onclick="parent.print();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='Print' name='print' id='print' class='BUTTON'></input> -->

					<!--	<input type='button' onclick="alert('Help is under construction')" value='Help' name='help' id='help' class='BUTTON'></input> -->
<!-- 						<input type='button' onclick="alert('Help is under construction')" value='Help' name='help' id='help' class='BUTTON'></input> -->


					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

