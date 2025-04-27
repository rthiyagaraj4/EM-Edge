<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtStyle.css"/>
<Script src="../js/json2.js" language="JavaScript"></Script>
<script src='../../eIP/js/IPAdvBedMgmtSupplementary.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style type="text/css">
#cornerdesignLeft {
	position: relative;
	width: 00px;
	height: 0px;
	/* margin-left:100px; */
	-ms-transform: rotate(-15deg);
	-moz-transform: rotate(-15deg);
	-o-transform: rotate(-15deg);
	-webkit-transform: rotate(-15deg);
}

/* #cornerdesignLeft:before {
	content: "";
	position: absolute;
	top: -30px;
	left: -70px;
	width: 40px;
	height: 40px;
	border: 16px solid #407784;
	border-left: 0px;
	border-right: 0px;
	border-top: 10px solid #407784;
	
	border-radius: 0px 00px 0 50px;
	-moz-border-radius: 0px 00px 0 50px;
	
	transform: rotate(-65deg);
	-ms-transform: rotate(-65deg);
	
	background-color: #407784;
}

#cornerdesignLeft:after {
	content: "";
	position: absolute;
	top: -5px;
	left: 0px;
	right: 0px;
	width: 35px;
	height: 30px;
	
	border: 15px solid #407784;
	border-bottom: 0px;
	border-right: 0px;
	border-top: 0px;
}

#cornerdesignLeft:after {
	left: -30px;
	right: 0px;
	bottom: 0px;
	
	-moz-border-radius: 50px 00px 00px 0;
	border-radius: 50px 00px 00px 0;
	
	-webkit-transform: rotate(50deg);
	-moz-transform: rotate(50deg);
	-ms-transform: rotate(50deg);
	-o-transform: rotate(50deg);
	transform: rotate(50deg);
} */

.leftTabStyle{
	/* display:table-cell; */
	height:85%;
	width:20%;
	vertical-align: middle;
	background-color:#3ca0b2;
	/* background-color:#aca072; */
	float: left;
	color:#FFFFFF;
	PADDING-LEFT:5px;
	font-family:Arial;
	FONT-SIZE: 12px;
	FONT-WEIGHT: bold ;
	
}

A { 
	text-decoration: none;
}

/* A:link { 
	COLOR: #e2e2e2; 
}

A:visited { 
	COLOR: #e2e2e2; 
} 
A:active { 
	COLOR: #e2e2e2; 
}

A.MENUSUBLEVELLINK
{
	COLOR: #e2e2e2;
}
A.MENUHIGHERLEVELLINK
{
	COLOR: #e2e2e2;
}
 */
</style>


</head>
<body style='background-color:#e2e2e2;'>

<%
// facilityId
String facilityId		= (String)session.getAttribute("facility_id");


%> 
 
 
 <!-- <div id="wrapper" style='width:100%;height:24px;display:table;margin-bottom:2px;margin-top:2px;background-color:#ffffff;border-bottom:1px solid #000000;'> 
 	<div id="header" style='display: table-row; height:100%;width:20%;'>
 		<div style='display:inline-block;height:100%;width:10%;background-color:#3ca0b2;'></div>
 		<div id="cornerleft" style='display:table-cell;height:100%;width:100%;vertical-align: middle;background-color:#3ca0b2;float: left;color:#FFFFFF;PADDING-LEFT:5px;font-family:arial;FONT-SIZE: 12px;FONT-WEIGHT: bold ;'>Bed View</div>
 		<div id="cornerleft" class="leftTabStyle">Bed View</div>
 	</div>
 </div> -->
 
 <table cellspacing=0 cellpadding=0 align='left' v-align='bottom' width='100%' height='30px' style='margin-left:2px; margin-bottom:2px;margin-top:2px;background-color:#e2e2e2;border-bottom:1px solid #000000;'>
 	<tr>
 		<td class="leftTabStyle">Bed View</td>
 		<td style='width:80%;'></td>
 		<td style='width:20%;float:right;height:100%;vertical-align: middle;padding-right:10px;'>
 			<table cellspacing=0 cellpadding=0 align='left' width='100%' height='30px'>
 				<tr>
 				<td style='cursor:pointer;'>
 				<%-- <img src='../../eCA/images/MI_ManageSpecimen.gif' alt='Manage Spec' title='Manage Specimens' onclick="showManageSpecimen('<%=facilityId%>','<%=CATaskAccessConstants.FACILITYID_REQUEST_KEY%>','<%=GBMConstants.IP_MODULE_IDENTIFIER%>','<%=CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY%>','<%=CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD%>','<%=CATaskAccessConstants.TASK_ID_REQUEST_KEY%>')" ></img> --%>
 				<img src='../images/MI_ManageSpecimen.png' alt='Manage Spec' title='Manage Specimens' onclick="showManageSpecimen('<%=facilityId%>','<%=CATaskAccessConstants.FACILITYID_REQUEST_KEY%>','<%=GBMConstants.IP_MODULE_IDENTIFIER%>','<%=CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY%>','<%=CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD%>','<%=CATaskAccessConstants.TASK_ID_REQUEST_KEY%>')" ></img>
 				</td>
 				</tr>
 			</table>
 			<%-- <img src='../../eCA/images/MI_ManageSpecimen.gif' alt='Manage Spec' title='Manage Specimens' onclick="showManageSpecimen('<%=facilityId%>','<%=CATaskAccessConstants.FACILITYID_REQUEST_KEY%>','<%=GBMConstants.IP_MODULE_IDENTIFIER%>','<%=CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY%>','<%=CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD%>','<%=CATaskAccessConstants.TASK_ID_REQUEST_KEY%>')" ></img> --%>
 			
 			
 			<!-- <a class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'> -->
 			<!-- <a> -->
 			<%-- <img class='imageClass1' src='../../eCA/images/MI_ManageSpecimen.gif' alt='Manage Spec' title='Manage Specimens' onclick="showManageSpecimen('<%=facilityId%>','<%=CATaskAccessConstants.FACILITYID_REQUEST_KEY%>','<%=GBMConstants.IP_MODULE_IDENTIFIER%>','<%=CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY%>','<%=CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD%>','<%=CATaskAccessConstants.TASK_ID_REQUEST_KEY%>')" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'></img> --%>
 			
 			<%-- <img src='../../eCA/images/MI_ManageSpecimen.gif' alt="Manage Spec" title="Manage Specimens" onclick="showManageSpecimen('<%=facilityId%>','<%=CATaskAccessConstants.FACILITYID_REQUEST_KEY%>','<%=GBMConstants.IP_MODULE_IDENTIFIER%>','<%=CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY%>','<%=CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD%>','<%=CATaskAccessConstants.TASK_ID_REQUEST_KEY%>') class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'"></img> --%>
 			
 			<!-- </a> -->
 		</td>
 	</tr>
 </table>
 

</body>


</html>
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

