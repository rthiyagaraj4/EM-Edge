<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="en" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery Horizontal splitter</title>
<script type="text/javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script type="text/javascript" src="../js/splitter.js"></script>

<!-- General page styles (not critical to the demos) -->
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<link rel="stylesheet" href="../css/moduleDetails.css"/> 
<style type="text/css" media="all">

/*
 * Splitter container. Set this to the desired width and height
 * of the combined left and right panes.
 */
#MySplitter {
	height: 620px;
	width: 98%;
	border: 1px solid #F2F2F5;
	/* No padding allowed */
}
/*
 * Top element of the splitter. Use pixel units for the
 * min-height and max-height; the splitter plugin parses them to
 * determine the splitter movement limits. Set the height to
 * the desired initial height of the element; the plugin changes
 * the height of this element dynamically.
 */
#TopPane {
	background: #ffe;
	overflow: auto;
	/* Initial/min/max height for this pane */
	height: 400px;
	min-height: 200px;
	max-height: 620px;
	position: relative;
	/* No margin or border allowed */
}
/*
 * Bottom element of the splitter; the plugin changes the top
 * position and height of this element dynamically.
 */
#BottomPane {
	background: #ffd;
	overflow: auto;
	position: relative;
	min-height: 0px;
	max-height: 400px;
	/* No margin or border allowed */
}
/* 
 * Splitter bar style; the .active class is added when the
 * mouse is over the splitter or the splitter is focused
 * via the keyboard taborder or an accessKey. 
 */
#MySplitter .hsplitbar {
	height: 10px;
	width: 500px;
	background: #c8c8d2 url(../images/Separator.PNG) no-repeat center;
}

#MySplitter .hsplitbar.active {
	background: #c8c8d2 url(../images/Separator.PNG) no-repeat center;
}
</style >
<style  type="text/css" >

</style>
<script type="text/javascript">
	$().ready(function() {
		$("#MySplitter").splitter({
			type : "h",
			sizeBottom : 0, /* use height set in stylesheet */
			accessKey : "P"
		});
	});

	function showInBottomFrame() {
		var bottomDiv = document.getElementById("BottomPane");
		if (bottomDiv) {
			bottomDiv.style.height = '300px';
		}
		var topDiv = document.getElementById("TopPane");
		if (topDiv) {
			topDiv.style.height = '300px';
		}

	}
	
	function resizeSplitter(){
		$("#MySplitter").trigger("resize", [ 300 ]);
	}
	
	function showAttr(entityName){
		//var url = "EntityAttributes.jsp?entityName="+entityName;
		//parent.REPWINDOW.location.href = url;
		//showInBottomFrame(url);
		//window.location.href = url;
		var hdnAttributeClickedComp = document.getElementById("hdnAttributeClicked");
		if(hdnAttributeClickedComp){
			hdnAttributeClickedComp.value = "yes";
		}
		
		var hdnModuleNameComp = document.getElementById("hdnModuleName");
		if(hdnModuleNameComp){
			hdnModuleNameComp.value = entityName;
		}
		
		
		var hdnModuleIdComp = document.getElementById("moduleId");
		var moduleId = "";
		if(hdnModuleIdComp){
			moduleId = hdnModuleIdComp.value;
		}
		
		var hdnModuleNameComp = document.getElementById("moduleName");
		var moduleName = "";
		if(hdnModuleNameComp){
			moduleName = hdnModuleNameComp.value;
		}
		
		var actionScr = "ModuleDetailsMain.jsp?moduleId="+moduleId+"&moduleName="+moduleName+"&hdnAssociateClicked=&hdnAttributeClicked=yes&hdnModuleName="+entityName;
		document.forms[0].action = actionScr;
		
		document.forms[0].submit();
	}
	
	function showAssociatedEntities(entityName){
		//var url = "EntityAssociates.jsp?entityName="+entityName;
		//parent.REPWINDOW.location.href = url;
		//showInBottomFrame(url);
		//window.location.href = url;
		
		var hdnAttributeClickedComp = document.getElementById("hdnAttributeClicked");
		if(hdnAttributeClickedComp){
			hdnAttributeClickedComp.value = "yes";
		}
		
		var hdnModuleNameComp = document.getElementById("hdnModuleName");
		if(hdnModuleNameComp){
			hdnModuleNameComp.value = entityName;
		}
		
		
		var hdnModuleIdComp = document.getElementById("moduleId");
		var moduleId = "";
		if(hdnModuleIdComp){
			moduleId = hdnModuleIdComp.value;
		}
		
		var hdnModuleNameComp = document.getElementById("moduleName");
		var moduleName = "";
		if(hdnModuleNameComp){
			moduleName = hdnModuleNameComp.value;
		}
		
		var actionScr = "ModuleDetailsMain.jsp?moduleId="+moduleId+"&moduleName="+moduleName+"&hdnAssociateClicked=yes&hdnAttributeClicked=&hdnModuleName="+entityName;
		document.forms[0].action = actionScr;
				
		document.forms[0].submit();
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body bgcolor="#F8F8F9" onload="resizeSplitter()">
<%
	String moduleId = request.getParameter("moduleId");
	if (moduleId == null) {
		moduleId = "";
	}
	String moduleName = request.getParameter("moduleName");
	if (moduleName == null) {
		moduleName = "";
	}
	
	String associateClicked = request.getParameter("hdnAssociateClicked");
	if(associateClicked == null){
		associateClicked = "";
	}
	
	String attributeClicked = request.getParameter("hdnAttributeClicked");
	if(attributeClicked == null){
		attributeClicked = "";
	}
	
	String entityName = request.getParameter("hdnModuleName");
	if(entityName == null){
		entityName = "";
	}
	
	int rowCounter = 0;
	String styleClassName = "";
%>
<form method="post" id="moduleForm" name="moduleForm" id="moduleForm">
	<div id="MySplitter" style="background-color: #F8F8F9;">

		<div id="TopPane" class="viewpanestyle">
			<table width="98%" style="min-height: 290;" border="0" cellpadding="0" cellspacing="0"
				class="viewtablestyle">
				<tr>
					<td class="viewtabletdstyle"><b><span class="viewtabletitlestyle" >List of views for Module
							:&nbsp;</span></b><b><span class="viewtabletitleviewnamestyle" ><%=moduleName%></span></b></td>
				</tr>

				<tr>
					<td>
						<%
							String completeModuleName = moduleId + "%";

							String query = "";

							PreparedStatement prepStmt = null;
							Connection conn = null;

							try {
								conn = ConnectionManager.getConnection(request);
							} catch (Exception e) {
								out.println("<span class='spanstyle'>Could not get connection. Error Message ="
										+ e.getMessage() + "</span>");
								return;
							}

							// safe approach
							if (conn == null) {
								out.println("<span class='spanstyle'>Error in showing details as connection to the database was not obtained</span>");
								return;
							}

							String userName = "";
							DatabaseMetaData dbmd = null;
							try {
								dbmd = conn.getMetaData();
							} catch (Exception ex) {
								out.println("<span class='spanstyle'>Error in showing details</span>");
								return;
							}

							if (dbmd == null) {
								out.println("<span class='spanstyle'>Error in showing details</span>");
								return;
							}

							userName = dbmd.getUserName();

							query = "SELECT A.OWNER,A.VIEW_NAME,B.TABLE_TYPE,B.COMMENTS FROM ALL_VIEWS A, ALL_TAB_COMMENTS B WHERE A.OWNER = B.OWNER AND A.VIEW_NAME = B.TABLE_NAME and A.owner = '"
									+ userName
									+ "' AND A.VIEW_NAME LIKE ('"
									+ completeModuleName + "') AND B.TABLE_TYPE = 'VIEW'";

							String entName = "";
							ResultSet rs = null;
							int rowCount = 0;
							try {
								prepStmt = conn.prepareStatement(query);
								rs = prepStmt.executeQuery();
								if (rs != null) {
						%>
						<table border="0" width="98%" cellpadding="0" cellspacing="0" style="margin-left:5px;margin-bottom: 5px;"
							class="viewdatatablestyle">
							<%
								while (rs.next()) {
											if (rowCount == 0) {
							%>

							<tr>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">View Name</th>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Description</th>
								<th align="center" class="viewdatatableheaderstyle">Attributes</th>
								<th align="center" class="viewdatatableheaderstyle">Associated
									Entities</th>
							</tr>
							<%
								rowCount++;
											}
											
											if(rowCount % 2 == 0){
												styleClassName = "viewdatarowoddstyle";
											}else{
												styleClassName = "viewdatarowevenstyle";
											}
											
											entName = rs.getString("VIEW_NAME");
											if (entName != null && !entName.trim().equals("")) {
							%>
							<tr>
								<td  align="left" valign="middle" style="padding-left: 5px;" width="25%" class="<%=styleClassName%>"><%=entName%></td>
								<%
									if (rowCount == 1) {
								%>
								<td  align="left" valign="middle" width="48%" style="padding-left: 5px;" class="<%=styleClassName%>">This is a test for
									description column this is a very long description in deed just
									to test how the GUI is showing this column</td>
								<%
									} else {
								%>
								<td  align="left" valign="middle" width="48%" style="padding-left: 5px;" class="<%=styleClassName%>">&nbsp;</td>
								<%
									}
								%>
								<td align="center" width="10%" class="<%=styleClassName%>"><img
									src="List_Attr.gif" onclick="showAttr('<%=entName%>')" style="cursor:pointer;cursor: hand;"></img>
								</td>
								<td align="center" width="15%" class="<%=styleClassName%>"><img
									src="Linked_Entities.gif"
									onclick="showAssociatedEntities('<%=entName%>')"  style="cursor:pointer;cursor: hand;"></img></td>
							</tr>
							<%
								}
											rowCount++;
										}
							%>
						</table> <%
 	// indicates no records were fetched
 			if (rowCount == 0) {
 %> <span class="spanstyle">No records obtained for the selected
							module</span> <%
 	}
 		}

 	} catch (Exception ex) {
 		out.println("<span class='spanstyle'>Could not obtain records for the module "
 				+ moduleName + "</span>");
 		return;
 	} finally {
 		if (rs != null) {
 			try {
 				rs.close();
 			} catch (Exception ex) {

 			}
 		}

 		if (prepStmt != null) {
 			try {
 				prepStmt.close();
 			} catch (Exception ex) {

 			}
 		}
 		ConnectionManager.returnConnection(conn, request);
 	}
 %>
					</td>
				</tr>
			</table>
		</div>

		<div id="BottomPane" style="background-color: #F8F8F9;" width="99%">
			<%
			if (rs != null) {
	 			try {
	 				rs.close();
	 			} catch (Exception ex) {

	 			}
	 		}

	 		if (prepStmt != null) {
	 			try {
	 				prepStmt.close();
	 			} catch (Exception ex) {

	 			}
	 		}
			
	 		
	 		styleClassName = "";
				if("yes".equalsIgnoreCase(attributeClicked)){
					if(entityName == null || entityName.trim().equals("")){
						out.println("<span>A view should be selected first.</span")	;
						return;
					}
					
					try {
						conn = ConnectionManager.getConnection(request);
					} catch (Exception e) {
						out.println("Could not get connection. Error Message ="+e.getMessage());
						return;
					}

					// safe approach
					if(conn == null){
						out.println("Error in showing the details as connection to the database was not obtained");
						return;
					}
					
					query = "SELECT ROWNUM NUMB, ATTRIBUTE_NAME, data_type||'('||data_length||')' data_type, DESCRIPTIONS FROM ( SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 )";
					
					%>
					<table width="98%" cellpadding="0" cellspacing="0" class="viewdatatablestyle">
						<tr>
     						<td class="viewtabletdstyle"> <span class="viewtabletitlestyle" >List of attributes for view :&nbsp;</span><span class="viewtabletitleviewnamestyle"><%=entityName %></span>
     						</td>
						</tr>
						<tr>
							<td>
						<%
						try{
							prepStmt = conn.prepareStatement(query);
							rs = prepStmt.executeQuery();
							if(rs != null){
						%>
							<table width="98%" cellpadding="0" cellspacing="0" class="viewdatatablestyle" style="margin-left:5px;margin-bottom: 5px;">
							<tr>	
								<th class="viewdatatableheaderstyle">No</th>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Name</th>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Type</th>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Descriptions</th>
							</tr>	
						<%	
							Object numbObj = null;
							
							while(rs.next()){
								String desc = rs.getString("DESCRIPTIONS");
								if(desc == null){
									desc = "&nbsp;";
								}
								
								if(rowCounter % 2 == 1){
									styleClassName = "viewdatarowoddstyle";
								}else{
									styleClassName = "viewdatarowevenstyle";
								}
								rowCounter++;
						%>
							<tr>
								<td width="7%" class="<%=styleClassName%>" align="center" valign="middle"><%=rs.getObject("NUMB") %>					
								</td>
								<td width="25%" class="<%=styleClassName%>" style="padding-left: 10px;" align="left" valign="middle"><%=rs.getString("ATTRIBUTE_NAME") %>
								</td>
								<td width="20%" class="<%=styleClassName%>" style="padding-left: 10px;" align="left" valign="middle"><%=rs.getObject("data_type") %>				
								</td>
								<td width="48%" class="<%=styleClassName%>" style="padding-left: 10px;" align="left" valign="middle"><%=desc %></td>
							</tr>	
								<%		
								}
							// reset the rowCounter to 1
								rowCounter = 0;
							%>
							</table>
							<%
							}else{
								out.println("Could not obtain records for "+entityName);
								return;
							}
						%>
	
						
						<%	
					}catch(Exception ex){
						out.println("Could not obtain records for "+entityName);
						return;
					}finally{
						if(rs != null){
							try{
								rs.close();
							}catch(Exception ex){
								
							}
						}
						
						if(prepStmt != null){
							try{
								prepStmt.close();
							}catch(Exception ex){
								
							}
						}
						ConnectionManager.returnConnection(conn, request);
					}
					
					
					%>
					</td>
					</tr>	
				</table>	
					
				<%	
				}else if("yes".equalsIgnoreCase(associateClicked)){
					if(entityName == null || entityName.trim().equals("")){
						out.println("<span>A view should be selected first.</span")	;
						return;
					}
					
					try {
						conn = ConnectionManager.getConnection(request);
					} catch (Exception e) {
						out.println("Could not get connection. Error Message ="+e.getMessage());
						return;
					}
					
					// safe approach
					if(conn == null){
						out.println("Error in showing the details as connection to the database was not obtained");
						return;
					}
					
					query = "SELECT referenced_owner AS TABLE_OWNER, referenced_name AS TABLE_NAME, OWNER AS REFERENCED_BY_OBJECT_OWNER, name AS REFERENCED_BY_OBJECT_NAME, TYPE AS REFERENCED_BY_OBJECT_TYPE FROM sys.dba_dependencies WHERE referenced_type='TABLE' AND referenced_owner='IBAEHIS' and name='"+entityName+"' ORDER BY 1,2";
					%>
					
					<table width="98%" border="0" cellpadding="0" cellspacing="0" class="viewdatatablestyle">
					<tr>
					     <td class="viewtabletdstyle"><span class="viewtabletitlestyle" >List of associated entities for view :&nbsp;</span><span class="viewtabletitleviewnamestyle"><%=entityName %></span>
					     </td>
					</tr>
					<tr>
						<td>
							
					<%
					try{
						prepStmt = conn.prepareStatement(query);
						rs = prepStmt.executeQuery();
						if(rs != null){
					
					%>
							<table width="98%" cellpadding="0" cellspacing="0" class="viewdatatablestyle" style="margin-left:5px;margin-bottom: 5px;">
							<tr>	
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Table Owner</th>
								<th style="padding-left: 10px;" align="left" class="viewdatatableheaderstyle">Table Name</th>
							</tr>
					<%	
							while(rs.next()){
								if(rowCounter % 2 == 1){
									styleClassName = "viewdatarowoddstyle";
								}else{
									styleClassName = "viewdatarowevenstyle";
								}
								rowCounter++;
								
					%>
							<tr>
								<td  align="left" valign="middle" style="padding-left: 10px;" class="<%=styleClassName%>"><%=rs.getString("TABLE_OWNER")%></td>
								<td  align="left" valign="middle" style="padding-left: 10px;" class="<%=styleClassName%>"><%=rs.getString("TABLE_NAME") %></td>
							</tr>		
					<%		
							}
					%>
					</table>
					<%
						}
					%>
							
						
					<%	
						}catch(Exception ex){
							out.println("Could not obtain records for "+entityName);
							return;
						}finally{
							if(rs != null){
								try{
									rs.close();
								}catch(Exception ex){
									
								}
							}
							
							if(prepStmt != null){
								try{
									prepStmt.close();
								}catch(Exception ex){
									
								}
							}
							ConnectionManager.returnConnection(conn, request);
						}
					
					
					%>
						</td>
					</tr>
				</table>
					<%	
				}
			
			%>
		</div>

	</div>

	<input type="hidden" id="hdnAssociateClicked" value=""/> 
	<input type="hidden" id="hdnAttributeClicked" value=""/>
	<input type="hidden" id="hdnModuleName" value=""/>
	<input type="hidden" id="moduleId" value="<%=moduleId %>"/>
	<input type="hidden" id="moduleName" value="<%=moduleName %>"/>
</form>
</body>
</html>

