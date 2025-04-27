<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
	<head>
<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='/eHIS-DS/core/css/<%=sStyle%>'></link>

<Script>
	   function activate( newimg ) {
			return true;
		}
		function reset()
		{
			parent.reset();
		}
		function onDelete(){
		  parent.deleterec();
		  parent.commontoolbarFrame.location.href='../eDS/MealType/html/process.html';
		}

		function onApply() {
			parent.apply() ;
		}
	</Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 bgcolor=#ffffff>

		<form name="CommonToolbar_form" id="CommonToolbar_form" action="/ToolbarAction">
			<table width="100%" cellspacing='0' cellpading='0'>
				<tr class="COMMONTOOLBARFUNCTION">
					<td align="left" class="COMMONTOOLBARFUNCTION">
						<%
						//= functionname
						%>
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
												<input type='button'
													onclick="parent.create();parent.messageFrame.location.href='MessageFrame.jsp'"
													value='Create' name='create' id='create' class='BUTTON'></input>
											</td>



											<td class="COMMON_TOOLBAR">
												<input type='button'
													onclick="parent.query();parent.messageFrame.location.href='MessageFrame.jsp'"
													value='Query' name='query' id='query' class='BUTTON'></input>
											</td>



											<td class="COMMON_TOOLBAR">
												<input type='button' onclick="parent.deleterec();parent.messageFrame.location.href='MessageFrame.jsp'"
													value='Delete' class='BUTTON'></input>
											</td>



											<td class="COMMON_TOOLBAR">
												<input type='button' onclick="onApply();" value='Apply' onclick="parent.reset();parent.messageFrame.location.href='MessageFrame.jsp'" name='apply' id='apply' class='BUTTON'></input>
											</td>

											<td class="COMMON_TOOLBAR">
												<input type='button' onclick="parent.run();" value='Run'
													onclick="parent.run();parent.messageFrame.location.href='MessageFrame.jsp'"
													name='run' id='run' class='BUTTON'></input>
											</td>


											<td class="COMMON_TOOLBAR">
												<input type='button' onclick="parent.reset();" value='Reset'
													onclick="parent.reset();parent.messageFrame.location.href='MessageFrame.jsp'"
													 name='reset' id='reset' class='BUTTON'></input>
											</td>
											<td>
											<input type='button' onClick='parent.parent.parent.frames[1].expand(this)' onclick="'" value='Menu' name='home' id='home' class='BUTTON'></input>
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
</html>

