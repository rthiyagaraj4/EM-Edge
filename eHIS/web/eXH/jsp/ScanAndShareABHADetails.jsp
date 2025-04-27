<!DOCTYPE html>
<%@ page import="java.util.*,com.ehis.util.*,eXH.*"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	boolean isDebugYN = false;
	
	try{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PROTOCOL_LINK WHERE PROTOCOL_LINK_ID = 'ABDMPL1'").equals("Y")) ? true : false;
		System.out.println("***Inside Scan ABHA ID - isDebugYN..."+isDebugYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Scan ABHA ID - Exception while checking isDebugYN Flag... "+e);
	}

	boolean isConsumedYN = false;
	
	try{
		isConsumedYN = (XHUtil.singleParamExeQry("SELECT NVL(DEFAULT_VALUE, 'N') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID ='ACONO5' AND ELEMENT_ID ='FLTRYN'").equals("Y")) ? true : false;
		System.out.println("***Inside Scan ABHA ID - isConsumedYN..."+isConsumedYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Scan ABHA ID - Exception while checking isConsumedYN Flag... "+e);
	}finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Scan ABHA ID - Conection closed");
	}
	
	boolean timerOn = true;
	String waitTime = "30";
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ScanAndShare</title>
<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>"
	type="text/css" />
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCA/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function onchangeflag(object){
	document.getElementById("flagVal").value = object.value;
}

function search(){
	var Name = document.getElementById("Name");
    var SMobileNo = document.getElementById("SearchMobileNo");
    var SearchMode = document.getElementById("searchMode").value;
    var UsedFlag = document.getElementById("flagVal").value;
    
	var mobile=SMobileNo.value;
	var name = Name.value;
	
	$("#abhaIdInfoTable").html("");
	document.getElementById("healthIdNumber").value = "";
	
    if((mobile!=null && mobile!="")||(name!=null && name!="" && name.length>=3)){
	var response = callScanABHA(name,mobile,SearchMode,UsedFlag);
	//alert("response: "+response);
	document.getElementById("OkBtn").disabled=true;
	
	if(response!="" && response!="[]"){
		var tableData = jQuery.parseJSON(response);

		$("#abhaIdInfoTable").append('<tr id="headerRow"></tr>');
		if(tableData.length>1){
			$("#headerRow").append('<th></th>');
		}else{
			document.getElementById("OkBtn").disabled=false;
		}
		$.each(tableData[0], function(a, b) {
			$("#headerRow").append('<th>' + a + '</th>');
		});

		$.each(tableData, function(a, b) {
			$("#abhaIdInfoTable").append('<tr id="' + a + '"></tr>');
			var dataRowId = '#' + a;
			$.each(b, function(c, d) {
				if(c=='ABHA ID' && tableData.length>1){
					$(dataRowId).append('<td><input id="abha'+a+'Id" name="selectAbha" id="selectAbha" type="radio" onclick="selectAbhaDtl(this)" value="'+d+'"></td>');
				}
			});
			$.each(b, function(c, d) {
				if(c=='ABHA ID'){
					document.getElementById("healthIdNumber").value = d;
				}
				$(dataRowId).append('<td>' + d + '</td>');
			});
		});
		
		ResponseMsg('green','Scanned records are retrieved successfully.');
	}else{
		ResponseMsg('red','Record not found.');
	}
    }else{
    	if(name!=null && name!="" && name.length<3){
    		ResponseMsg('red','Enter a name with at least 3 characters.');
    	}else{
    		ResponseMsg('red','Enter Name or MobileNumber details.');
    	}
    }
}

function selectAbhaDtl(data){
	
	var isDebugYN = document.getElementById("isDebugYN").value;
	
	if(isDebugYN=="true")
		alert("healthIdNumber :"+data.value);
	
	document.getElementById("healthIdNumber").value = data.value;
	
	if(data.value!=null)
		document.getElementById("OkBtn").disabled=false;
}

function ResponseMsg(color,resMsg){
		$("#footerResId").html("");
		$("#footerResId").append('<p id="resMsg" style="color: '+color+';">'+resMsg+'</p>');
}
 
function reset(){
	document.forms[0].reset();
}
function cancel(){
	window.close();
}

function finish(option) {
	var healthId = document.getElementById("healthIdNumber").value;
	window.returnValue=healthId;
	window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<style type="text/css">
.okBtn {
	width: 60px;
}

.content {
	padding: 10px;
	padding-bottom: 35px;
}

#footer {
	position: fixed;
	bottom: 0;
	width: 98%;
	text-align: right;
	padding: 10px;
	background-color: white;
}
</style>
</head>
<body>
	<form>
		<div class="content">
			<div id="searchDiv" style="display: block;">
				<table cellspacing=0 cellpadding=3>
					<tr>
						<td align="left">
						<td align="right" class='label'><fmt:message
								key="eXH.Name.label" bundle="${xh_labels}" /></td>
						<td align="left"><input type="text" id="Name" name="Name" id="Name"
							size=20></td>

						<td align="left"><select id="searchMode" name="searchMode" id="searchMode">
								<option selected value="C">Contains</option>
								<option value="S">Starts with</option>
								<option value="E">Ends with</option>
						</select></td>

						<td class='label'><fmt:message key="eXH.MobileNumber.label"
								bundle="${xh_labels}" /></td>
						<td align="left"><input type="number" id="SearchMobileNo"
							name="SearchMobileNo" id="SearchMobileNo" size=20 maxlength=10></td>
						<%
						if(isConsumedYN){
						%>
						<td align="left"><select id="usedFlag" name="usedFlag" id="usedFlag" onchange="onchangeflag(this);">
						<%
						try{
							String query = "SELECT LIST_SRL_NO, LIST_ELMT_VALUE, LIST_ELMT_LABEL FROM SM_LIST_ITEM WHERE MODULE_ID='XH' AND LIST_REF='XH_USED_FLAG_TYPE' ORDER BY LIST_SRL_NO";
							
							if(isDebugYN)
								System.out.println("***Inside Scan ABHA ID - Flag list query..."+query);
							
							conn = ConnectionManager.getConnection();
							stmt = conn.createStatement();
							rs = stmt.executeQuery(query);
							while (rs.next()) {
								
								if(isDebugYN)
									System.out.println("***Inside Scan ABHA ID - Flag list val..."+rs.getString("LIST_SRL_NO")+" "+rs.getString("LIST_ELMT_VALUE")+" "+rs.getString("LIST_ELMT_LABEL"));
							
								if(rs.getString("LIST_ELMT_VALUE").equals("N")){
							%>
								<option value="<%=rs.getString("LIST_ELMT_VALUE")%>" selected ><%=rs.getString("LIST_ELMT_LABEL")%></option>
							<%
								} else{
							%>
								<option value="<%=rs.getString("LIST_ELMT_VALUE")%>" ><%=rs.getString("LIST_ELMT_LABEL")%></option>
							<%	
								}
							}
							%>
						</select></td>
						<%
						} catch (Exception e){
							e.printStackTrace();
							System.out.println("***Inside Scan ABHA ID - Exception while getting Flag list... "+e);
						} finally {
							if (rs != null) rs.close();			
							if(stmt != null) stmt.close();
							ConnectionManager.returnConnection(conn, request);
						}
						}
						%>

						<td align="right"><input id="searchBtn" type="button"
							class="button" value="Search" onclick="search()"></td>

						<td align="right"><input id="resetBtn" type="button"
							class="button" value="Reset" onclick="reset()"></td>
					</tr>
				</table>
			</div>
			</br>
			<hr style="border-top: 1px solid #bbb">
			</br>
			<div>
				<table id='abhaIdInfoTable' border=1 cellspacing=0 cellpadding=3
					align="center" width="95%">
				</table>
			</div>
			<div id="footer">
				<div id="footerResId"
					style="padding-left: 10px; float: left; text-align: left;">
					<p id="resMsg"></p>
				</div>
				<div id="btnFooter" style="padding-right: 10px;">
					<input type="button" class="button" value="Cancel"
						onclick="cancel()"> <input id="OkBtn" type="button"
						class="button okBtn" value="OK" onclick="finish()" disabled>
				</div>
			</div>
			
			<input type="hidden" id="isDebugYN" name="isDebugYN" id="isDebugYN" value="<%=isDebugYN%>">
			<input type="hidden" id="healthIdNumber" name="healthIdNumber" id="healthIdNumber" value="">
			<input type="hidden" id="flagVal" name="flagVal" id="flagVal" value="N">
	</form>
</body>
.
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
</html>

