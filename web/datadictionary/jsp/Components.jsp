<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.moduleStripStyle {
	height: 33px;
	background-color: #007cb9; /* Old browsers */
	border-top: 1px solid #00a3cf;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css"/> 
<script type="text/javascript">
function showModuleDetails(moduleId,moduleName){
	//parent.REPWINDOW.location.href = "ModuleDetails.jsp?moduleId="+moduleId+"&moduleName="+moduleName;
	//parent.REPWINDOW.location.href = "ModuleDetailsMain.jsp?moduleId="+moduleId+"&moduleName="+moduleName;
	parent.REPWINDOW.location.href = "ModuleDetailsMain.jsp?moduleId="+moduleId+"&moduleName="+moduleName+"&hdnAssociateClicked=&hdnAttributeClicked=&hdnModuleName=";
	//parent.ATTRWINDOW.location.href = "../html/blank.html";
	var hdnSelectedModuleNameComp = document.getElementById("hdnSelectedModuleName");
	var prevSelectedModuleName="";
	if(hdnSelectedModuleNameComp){
		prevSelectedModuleName = hdnSelectedModuleNameComp.value;
	}
	
	var hdnSelectedModuleIdComp = document.getElementById("hdnSelectedModuleId");
	var prevSelectedModuleId="";
	if(hdnSelectedModuleIdComp){
		prevSelectedModuleId = hdnSelectedModuleIdComp.value;
	}
	
	var prevImagetd = document.getElementById('img'+prevSelectedModuleName+prevSelectedModuleId);
	if(prevImagetd){
		prevImagetd.style.display = "none";
		//prevImagetd.src = "";
	}
	
	var imagetd = document.getElementById('img'+moduleName+moduleId);
	if(imagetd){
		imagetd.style.display = "block";
		//imagetd.src = "../images/SelectArrow.PNG";
	}
	
	if(hdnSelectedModuleNameComp){
		hdnSelectedModuleNameComp.value = moduleName;
	}
	
	if(hdnSelectedModuleIdComp){
		hdnSelectedModuleIdComp.value = moduleId;
	}
	
}

function autocompleteForModule(textObj){
	var inputValue = textObj.value;
	var hdnCompleteModuleNameComp = document.getElementById("hdnCompleteModuleName");
	var completeModuleName = "";
	if(hdnCompleteModuleNameComp){
		completeModuleName = hdnCompleteModuleNameComp.value;
	}
	
	var hdnCompleteModuleIdComp = document.getElementById("hdnCompleteModuleId");
	var completeModuleId = "";
	if(hdnCompleteModuleIdComp){
		completeModuleId = hdnCompleteModuleIdComp.value;
	}
	
	
	var moduleNamesArr = completeModuleName.split(";");
	var moduleIdArr = completeModuleId.split(";");
	var moduleNamesLen = moduleNamesArr.length;
	if(moduleIdArr.length != moduleNamesLen){
		alert("Internal System Error - Cannot filter the modules");
	}
	for(var count=0;count<moduleNamesLen;count++){
		var trElem = document.getElementById("tr"+moduleNamesArr[count]+moduleIdArr[count]);
		var matchIndex = moduleNamesArr[count].toLowerCase().indexOf(inputValue.toLowerCase());
		if(matchIndex == 0){
			if(trElem){
				trElem.style.display = "block";
			}
		}else{
			if(trElem){
				trElem.style.display = "none";
			}
		}
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR=#000000>
<TABLE height="110px" width="221px" style="background-image: url('../images/HeaderBg.png');" border=0 cellpadding="0" cellspacing="0">
<TR>
<TD ALIGN="Center" width="100%" valign="bottom">
<span class="eMTitleStyle">eM</span>
</TD>
</TR>
<tr>
<td align="center" valign="top">
<span class="moduleHeaderStyle">Health View Model</span>
</td>
</tr>
</TABLE>

<table width="215px" border=0 style="height:33px;margin-left: 7px;background-image: url('../images/HeaderBg.png');background-repeat: repeat-x;">
<tr style="background-image: url('../images/MenuHeaderBg.png');background-repeat: repeat-x;">
<td ALIGN="center" style="margin-left: 8px;" >
 <span class ="modulespanStyle">Module</span> 
</td>
</tr>
</table>

<table class="autocompleteTableStyle" style="background-image: url('../images/MenuBg.png');" border=0>
<tr>
<td width="100%"  ALIGN="LEFT" style="padding-left: 8px;" >
<input type="text" class="autocompleteTextStyle" onkeyup="autocompleteForModule(this)"/>
</td>
</tr>
</table>

<div id="moduleTableDiv">
<table width="100%" style="background-image: url('../images/MenuBg.png');background-repeat:repeat-y;" cellpadding="0" cellspacing="0">

<%
	PreparedStatement prepStmt = null;
	Connection conn = null;
	try {
		conn = ConnectionManager.getConnection(request);
	} catch (Exception e) {
		out.println("Could not get connection. Error Message ="
				+ e.getMessage());
		return;
	}

	// safe approach
	if (conn == null) {
		out.println("Error in showing the details as connection to the database was not obtained");
		return;
	}

	String query = "Select * from SM_Module order by upper(Module_name)";
	ResultSet rs = null;
	StringBuffer completeModuleName = new StringBuffer("");
	StringBuffer completeModuleId = new StringBuffer("");
	try {
		prepStmt = conn.prepareStatement(query);
		rs = prepStmt.executeQuery();
		if (rs != null) {
%>
	<%
		String moduleName = "";
				String moduleId = "";
				int rowCounter = 0;
				
				while (rs.next()) {
					moduleId = rs.getString("MODULE_ID");
					moduleName = rs.getString("MODULE_NAME");
					completeModuleName.append(moduleName);
					completeModuleName.append(";");
					completeModuleId.append(moduleId);
					completeModuleId.append(";");
	%>	
			<TR id="tr<%=moduleName%><%=moduleId %>" style="display: block;padding-top: 5px;padding-bottom: 5px;padding-left: 5px;" width="100%">		
			<TD style="padding-left: 10px;" align="left" valign="middle">
			<img src="../images/Arrow.PNG"/>
			</TD>
			<TD style="padding-left: 5px;" align="left" valign="middle">
			<A class="componentAnchor" href = "javascript:showModuleDetails('<%=moduleId%>','<%=moduleName%>');"><%=moduleName%>
			</TD>
			<TD align="right" valign="middle" >
				<table id="img<%=moduleName%><%=moduleId %>"  style="display:none;" border=0>
					<tr>
						<td align="right">
							<img src="../images/SelectArrow.PNG"/>
						</td>
					</tr>
				</table>
			</TD>
			</TR>
		<%
			}

			if (completeModuleName.length() > 0) {
				completeModuleName.delete(
						completeModuleName.length() - 1,
						completeModuleName.length());
			}
			
			if (completeModuleId.length() > 0) {
				completeModuleId.delete(
						completeModuleId.length() - 1,
						completeModuleId.length());
			}
		%>
	
	
	<%
		}
	} catch (Exception ex) {
		out.println("Could not get the list of modules. Error Message ="
				+ ex.getMessage());
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


</TABLE>

<input type="hidden" id="hdnCompleteModuleName" name="hdnCompleteModuleName" id="hdnCompleteModuleName" value="<%=completeModuleName.toString()%>"> 
<input type="hidden" id="hdnCompleteModuleId" name="hdnCompleteModuleId" id="hdnCompleteModuleId" value="<%=completeModuleId.toString()%>">
<input type="hidden" id="hdnSelectedModuleName" name="hdnSelectedModuleName" id="hdnSelectedModuleName" value=""/>
<input type="hidden" id="hdnSelectedModuleId" name="hdnSelectedModuleId" id="hdnSelectedModuleId" value=""/>
 
</div>

</body>
</html>

