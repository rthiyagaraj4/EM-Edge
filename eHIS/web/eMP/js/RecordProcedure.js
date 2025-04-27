var radioval = "D"

function SearchByVal(currad) {
    radioval=currad.value

}

function validatetext(searchTxt,searchCrit,event){
	var searchText = "";
	var searchCriteria = "";
	if(event=='onblur'){
		searchText = searchTxt;
		searchCriteria = searchCrit
	} else {
		searchText = searchTxt.value;
		searchCriteria = searchCrit.value;
	}
	var selectedCodeDtl = parent.RecProcedure_query.document.getElementById("selectedCodeDtl").value;
	parent.RecProcedure_result.location.href="../../eMP/jsp/RecProcedureResult.jsp?searchText="+searchText+"&searchCriteria="+searchCriteria+"&radioval="+radioval+"&selectedCodeDtl="+selectedCodeDtl;
}

function resetForms( formObj )
{
	formObj.reset();
	document.CriteriaForm.search_by.checked=true;
	document.CriteriaForm.search_by.value="D";
	storeVal(document.CriteriaForm.search_by);
	var argArray = window.dialogArguments ;
	var functionId = argArray[11];
	if(functionId == "DefaultSearchCriteria")
		document.forms[0].search_criteria.options.value = argArray[10] ;
    parent.RecProcedure_result.location.href = "../../eCommon/html/blank.html";

}

function previous(){
	var start = parent.RecProcedure_result.document.getElementById("start").value;
	var end = parent.RecProcedure_result.document.getElementById("end").value;
	var records_to_show = parent.RecProcedure_result.document.getElementById("records_to_show").value;
	var searchText = parent.RecProcedure_result.document.getElementById("searchText").value;
	var searchCriteria = parent.RecProcedure_result.document.getElementById("searchCriteria").value;
	var radioval = parent.RecProcedure_result.document.getElementById("radioval").value;
	var selectedCodeDtl = parent.RecProcedure_result.document.getElementById("selectedCodeDtl").value

	var URL ="../../eMP/jsp/RecProcedureResult.jsp?";
	var param ="from="+(parseInt(start)-parseInt(records_to_show))+"&to="+(parseInt(end)-parseInt(records_to_show))+"&searchText="+searchText+"&searchCriteria="+searchCriteria+"&radioval="+radioval+"&selectedCodeDtl="+selectedCodeDtl;
	document.location.href=URL+param;  	
}

function next(){
	var start = parent.RecProcedure_result.document.getElementById("start").value;
	var end = parent.RecProcedure_result.document.getElementById("end").value;
	var records_to_show = parent.RecProcedure_result.document.getElementById("records_to_show").value;
	var searchText = parent.RecProcedure_result.document.getElementById("searchText").value;
	var searchCriteria = parent.RecProcedure_result.document.getElementById("searchCriteria").value;
	var radioval = parent.RecProcedure_result.document.getElementById("radioval").value;
	var selectedCodeDtl = parent.RecProcedure_result.document.getElementById("selectedCodeDtl").value

	var URL ="../../eMP/jsp/RecProcedureResult.jsp?";
	var param ="from="+(parseInt(start)+parseInt(records_to_show))+"&to="+(parseInt(end)+parseInt(records_to_show))+"&searchText="+searchText+"&searchCriteria="+searchCriteria+"&radioval="+radioval+"&selectedCodeDtl="+selectedCodeDtl;
	document.location.href=URL+param;
}

var NphCodeString = "";
function bulkOrder(NphCode, NphDesc, quantity, obj) {
	NphCodeString = parent.RecProcedure_result.document.getElementById("selectedCodeDtl").value;
	if (obj.checked) {
		if (NphCodeString=="null" || NphCodeString=="") {
			NphCodeString = NphCode+"*"+NphDesc+"*"+quantity;
		} else {
			NphCodeString = NphCodeString + "~" + NphCode+"*"+NphDesc+"*"+quantity;
		}

	} else {
		var arrayRemove = new Array();
		arrayRemove = NphCodeString.split('~');
		var index = 0;
		var countRemove = 0;
		for (var j = 0; j < arrayRemove.length; j++) {
			var nphCodeQuantity = new Array();
			nphCodeQuantity= arrayRemove[j].split("*");
			if (nphCodeQuantity[0]==NphCode) {
				countRemove++;
				index = j;
				break;
			}
		}
		if (countRemove > 0) {
			arrayRemove.splice(index, 1);
			if(arrayRemove!=null){
				NphCodeString="";
				for (var i = 0; i < arrayRemove.length; i++) {
					if(NphCodeString==""){
						NphCodeString=arrayRemove[i];
					} else {
						NphCodeString=NphCodeString+"~"+arrayRemove[i]
					}
				}
			}
		}

	}
	parent.RecProcedure_result.document.getElementById("selectedCodeDtl").value = NphCodeString;
}

function submitCode(){
	var selectedNPHCode = parent.RecProcedure_result.document.getElementById("selectedCodeDtl").value;
	window.returnValue = selectedNPHCode;
	window.close();
}
