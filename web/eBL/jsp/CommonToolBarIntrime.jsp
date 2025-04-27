<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
	
	request.setCharacterEncoding("UTF-8");

	//response.setContentType("text/html;charset=UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		

		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	%>
<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript">
			function activate( newimg ) {
				document.blankImage.src="../../eCommon/images/" + newimg;
				return true;
			}

			function disableMenuBtnFromCA(){
				if(parent.parent.frames[0].document.getElementById("toolbarQueryString")){
					if(document.forms[0].home){
						document.forms[0].home.style.visibility		= 'hidden';
						document.getElementById("cmnToolBarFuncName").innerHTML	= '';
					}
				}
			}

			//added by sri
			function onDelete(){
			  parent.deleterecord();
			parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
			}
			//ends here sri

			function onApply() {
				parent.apply() ;
				//parent.commontoolbarFrame.location.href='../../eCommon/jsp/process.jsp';
			}

			
			function reset_page()
			{
			
			var expand;
			var final_name=getLabel("Common.menu.label","Common");
			if(parent.commontoolbarFrame.document.forms[0].home)
				{
			if(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )
					{
						expand="0";
					}else
					{
						expand="1";
					}
					

				
					var error='R';
					var url="../../eCommon/jsp/error.jsp?err_num="+error;
					parent.messageFrame.location.href=url;
				}else
				{
					
				parent.reset();
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				}
					
			}
			/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-MAY-2013*/
			function menuHide()
			{ 
			if(document.forms[0].function_id.value=='MANAGE_PAT_QUEUE'){parent.menuHide()}
			/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-362[39365] on 11-Nov-2013*/
            if((document.forms[0].function_id.value=='AE_MANAGE_PATIENT')||(document.forms[0].function_id.value=='AE_CHECK_OUT')){
			parent.menuHide();
			}			
			}
			
			
		</script>
</head>

<body onKeyDown = 'lockKey();' class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onload="disableMenuBtnFromCA();">

<%
	

	String queryString	= request.getQueryString() ;
	

	session.putValue( "queryString",queryString) ;
String expand="";

	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	String access		= request.getParameter( "access" ) ;
		expand	= request.getParameter("expand") ;
		if(expand ==null) expand="";
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
		<td align="left" class="COMMONTOOLBARFUNCTION" id="cmnToolBarFuncName">
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
									 <input type='button' onclick="parent.create();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='<%=common_labels.getString("Common.create.label")%>' name='create'  id='create' class='BUTTON' ACCESSKEY='C'></input>
								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "F" ) && query_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									 <input type='button' onclick="parent.query();parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'" value='<%=common_labels.getString("Common.query.label")%>' name='query'  id='query' class='BUTTON' ACCESSKEY='Q'></input>
								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "F" ) && delete_access.equals( "Y" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onDelete();" value='<%=common_labels.getString("Common.delete.label")%>' class='BUTTON' ACCESSKEY='D'></input>
								</td>
							<%
								}
							%>

							<%
								if 	( function_type.equals( "F" ) && ( insert_access.equals( "Y" ) || update_access.equals( "Y" ) ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onApply();" value='<%=common_labels.getString("Common.apply.label")%>' name='apply' id='apply' class='BUTTON' ACCESSKEY='A'></input>

								</td>
							<%
								}
							%>

							<%
								if ( function_type.equals( "R" ) || function_type.equals( "P" ) ) {
							%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.run();" value='<%=common_labels.getString("Common.run.label")%>' name='run' id='run' class='BUTTON' ACCESSKEY='R'></input>
								</td>
							<%
								}
							%>

								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="reset_page();" value='<%=common_labels.getString("Common.reset.label")%>' name='reset' id='reset' class='BUTTON' ACCESSKEY='R'></input>
								</td>
								<%
								if(function_id!=null && function_id.equals("SWITCH_LANG")){
								}else{
								if(expand.equals("0") || expand.equals("")){ %>
								<td class="COMMON_TOOLBAR">
									<td class="COMMON_TOOLBAR">
									<%if (!home_required_yn.equals("N")) {%>
									<input type='button' onClick='parent.parent.parent.frames[1].expand(this);menuHide()' onclick="'" value='<%=common_labels.getString("Common.menu.label")%>' name='home' id='home' class='BUTTON'></input>
									<%}%>
								</td>
								<%}else{%>
									<td class="COMMON_TOOLBAR">
									<td class="COMMON_TOOLBAR">
									<%if (!home_required_yn.equals("N")) {%>
									<input type='button' onClick='parent.parent.parent.frames[1].expand(this);menuHide()' onclick="'" value='<%=common_labels.getString("Common.hideMenu.label")%>' name='home' id='home' class='BUTTON'></input>
									<%}%>
								</td>
								<%}
								}%>
	
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
	<!-- Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-MAY-2013 -->
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'> 
</form>
</body>

