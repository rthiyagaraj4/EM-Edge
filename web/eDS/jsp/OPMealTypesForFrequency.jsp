<!DOCTYPE html>
<!--
File Name		: OPMealTypesForFrequency.jsp
File Description: This file is for selecting MealTypes for OPMeal Order.
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%  
	    //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends

		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		if (sStyle == null)
				sStyle = "IeStyle.css";
         
		//String locale = (String)request.getAttribute("LOCALE");

		String mealtype=(String)request.getParameter("mealtype");

		String fecthedMealTypes=request.getParameter("fecthedMealTypes");

	System.out.println("fecthedMealTypes:: "+ fecthedMealTypes);
	System.out.println("mealtype:: "+ mealtype);
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script type="text/javascript">
	
//Function: For Getting Meal Types:
function getMealTypes(fecthedMealTypes,mealtype){

	var mealArray = fecthedMealTypes.split(",");
	var tableObj = null;
	var found_flag = false;
	var code = null;
	tableObj = document.getElementById("AbleM");
	var selObj = "";
	var row_ind = 0;
	//get Meal Desc ::
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var param="func_mode=getMealDesc&fecthedMealTypes="+fecthedMealTypes;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		retVal = TrimStr(retVal);
		if(retVal != null && retVal != ""){
			var mealArray = retVal.split("???");
			if(mealArray!=''){
		
				for (var i=0; i < mealArray.length;) {
					var mealList = mealArray[i].split(":::");
					var mealCode = mealList[0];
					var mealDesc = mealList[1];
					
					var sel="";
					//if( i % 2 == 0){

						var newRow = tableObj.insertRow(row_ind);
						var newCellDesc = newRow.insertCell(newRow.cells.length);
						newCellDesc.className = "label";
						//newCellDesc.appendChild(document.createTextNode(mealArray[i+1]));
						newCellDesc.appendChild(document.createTextNode(mealDesc));
						//sel="<input type='hidden' name='mealType' id='mealType'"+row_ind+" value='"+mealArray[i]+"'>";
						sel="<input type='hidden' name='mealType' id='mealType'"+row_ind+" value='"+mealCode+"'>";
						var newCellCBox = newRow.insertCell(newRow.cells.length);
						var mealTypesind="mealType_"+row_ind;
						var mealTypeDesc = mealDesc; //mealArray[i+1];
							if(mealTypeDesc != ""){
								var mealTypeDescArr = mealTypeDesc.split(" ");
								for(var j=1 ; j <=mealTypeDescArr.length;j++){
									mealTypeDesc = mealTypeDesc.replace(" ","#");
								}
							}
						//code = mealArray[i]+"@"+mealTypeDesc;
						code = mealCode+"@"+mealTypeDesc;

					var checkedYn = ""
					var disabledYn = "";
					//if(mealtype==mealArray[i])
					
					if(mealtype==mealCode)
					{
						checkedYn="checked"
					}

					//alert("mealtype.."+mealtype)
					sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" onclick=\"setStatus("+row_ind+",this.value)\" >"
					
					newCellCBox.innerHTML = sel;
					row_ind++;
					//}
					i++;
				}
			}
		}
}

var k=0;
var mealTypesArray = new Array();
function setStatus(ind,mealTypes){
	chkBox = document.getElementById(("mealType_" + ind));
	if(chkBox != null || chkBox != ""){
		if(chkBox.checked == true){
			mealTypesArray[ind]=mealTypes;
			k++;
		}else{
			mealTypesArray[ind]="";
			k++;
		}
	}
}
var mealTypeStr;

function getMealTypesSpFoodItems() {
		for (var i=0; i < mealTypesArray.length ;i++ )
		{
			if(mealTypesArray[i] == undefined){
				mealTypesArray[i] = "";
			}
		}
	mealTypeStr=mealTypesArray.join("*");
	parent.document.querySelectorAll('#dialog-body')[parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = mealTypeStr;
	parent.document.querySelectorAll('#dialog_tag')[parent.document.querySelectorAll('#dialog_tag').length-1].close();
	//top.returnValue = mealTypeStr;
	//top.close();
}

	</script>
	<title>MealTypes...</title>
	<style type="text/css">
	@import url(../../eDS/css/css2/themes/winxp/skin.css);


	</style>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>
<body>
	<form name="" id="" action="" target="messageFrame">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<tr id="contentsForAssignDietType" >
					<TD>
						<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:136;width:233;border: 1px outset #9999FF" align="center">
							<TABLE width="100%" id="AbleM" CELLSPACING="0" cellpadding="0">
							</TABLE>
						</div>
					</TD>
			</tr>
			<TR>
				<TD colspan="4" align="center" style="height:90vh">
					<input type="button" name="Close" id="Close" value="<fmt:message key='Common.close.label' bundle='${common_labels}'/>" onClick="getMealTypesSpFoodItems()" class="Button">
				</TD>
			</TR>
		</table>
		<input type="hidden" name="test" id="test" value="Test" />
		<input type="hidden" name="fecthedMealTypes" id="fecthedMealTypes" value="<%=fecthedMealTypes%>" />
		<input type="hidden" name="mealtype" id="mealtype" value="<%=mealtype%>" />
		<script>
			var fecthedMealTypes = document.getElementById("fecthedMealTypes").value;
			var mealtype = document.getElementById("mealtype").value;
			getMealTypes(fecthedMealTypes,mealtype);
		</script>
	</form>

</body>

</html>

