<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079  for September 2016 Release -->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eDS.Common.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";
	String encounter_id=request.getParameter("encounter_id");
%>
<html>
	<head>
	<title><fmt:message key="eDS.SupplementaryOrderAuditTrail.Label" bundle="${ds_labels}" /></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script language="Javascript" src="../../eDS/js/json.js"></script>		
		<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
		<!-- script language="Javascript" src="../../eDS/js/PlaceSupplementaryOrder.js"></script-->
		<style>
		
		
	.thwrap{
			position: relative;
            top: expression(this.offsetParent.scrollTop);
			/*white-space:nowrap;*/
			/*color:#ff0000;*/
			font-size:12px;
			width:auto;		
			background: url("../images/headerSeparator.jpg") repeat-y;
			background-position:right;
			COLOR: white ;
			background-color:#83AAB4;
			border:2px;
			padding-left:3px;
			font-family: Verdana;
			font-size: 8pt;
			/*font-weight:bold;*/
			border-collapse:collapse; 
			/*position:absolute;*/
			left:0;		
		
			}
			.datawrap{
			/*align:center;*/
		</style>
		<script type="text/javascript">
		forViewAllTable	=function(){

			var table		= $('#ViewOldSupplementaryOrders');

			$("#ViewOldSupplementaryOrders").find("tr").remove();
			
			var row=$('<tr><th>'+getLabel("Common.date.label","common")+'</th></tr>').addClass("thwrap").appendTo(table);
			
			$('<th>'+getLabel("eDS.SupplementaryDietFor.Label","DS")+'</th>').appendTo(row);
			$('<th>'+getLabel("eOT.ItemType.Label","ot_labels")+'</th>').appendTo(row);
			$('<th>'+getLabel("eDS.FoodItem.Label","DS")+'</th>').appendTo(row);
			$('<th>'+getLabel("eOT.qty.Label","ot_labels")+'</th>').appendTo(row);
			$('<th>'+getLabel("eDS.MealType.Label","DS")+'</th>').appendTo(row);
			$('<th>'+getLabel("Common.Instructions.label","common")+'</th>').appendTo(row);
			
			var params="mode=Get_OLD_SUPPLEMENTARY_MEAL_ORDER";
			var locale=$("#locale").val();
			var encounter_id=$("#encounter_id").val();
			var facility_id=$("#facility_id").val();
			
			params+="&encounter_id="+encounter_id;
			params+="&locale="+locale;
			params+="&facility_id="+facility_id;
						
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			xmlHttp.open("POST", "../../servlet/eDS.SupplementaryOrderServlet?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;	
			
			var jsonObjResponse=eval('(' + retVal + ')');	

			var tempSupplementaryMeals=new Array();
			tempSupplementaryMeals = jsonObjResponse;
			
			$.each(tempSupplementaryMeals, function (i, item){
							var row1=$("<tr><td>"+item.Date+"</td></tr>").appendTo(table);
							
							$('<td align="left">'+item.SupplementaryOrderForDesc+'</td>').appendTo(row1);
							$('<td align="left">'+item.Item_Type_Desc+'</td>').appendTo(row1);
							$('<td align="left">'+item.Item_Desc+'</td>').appendTo(row1);
							$('<td align="left">'+item.Qty+'</td>').appendTo(row1);
							if(item.Meal_Type_Desc==" "){
								$('<td align="center"> &nbsp; </td>').appendTo(row1);
							}else{
							$('<td align="left"> '+item.Meal_Type_Desc+' </td>').appendTo(row1);
							}
							if(trim(item.Instructions)==" " || trim(item.Instructions)=="undefined" ||trim(item.Instructions)=="null" || trim(item.Instructions)==""){
								$('<td align="left" >&nbsp;</td>').appendTo(row1);
							}else{
							$('<td align="left" style=" word-break: break-all">'+item.Instructions+'</td>').appendTo(row1);
							}
			});
		}
		
        $(document).ready(function () {
		var localeName="<%=localeName%>";
		forViewAllTable();
});

    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
table {
    border-collapse: separate;
    //empty-cells: hide;
}
</style>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">		
		<form action="">
		<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:650;width:100%;border: 1px outset #9999FF;word-break: break-word;" align="center">
		<table border='1' cellpadding='1' cellspacing='2' width='100%' align='center' id="ViewOldSupplementaryOrders" style="overflow-y: scroll;overflow-x: scroll;width:100%;border: 1px outset #9999FF;">
		<tbody></tbody>
		</table>
		</div>
		<input type="hidden" name="encounter_id" id="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
		</form>
	</body>
</html>

