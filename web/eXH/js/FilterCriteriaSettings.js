function filterDetails()
{   
	if(document.forms[0].Filter_group_desc.value == '')
	{
	}
	else 
	{
		var filterGroupCode = $("#Filter_group_desc_id").val();
		parent.frames[2].location.href = "../../eXH/jsp/FilteringAndSchedulingApplicationSearch.jsp?Filter_group_code=" + filterGroupCode;
		parent.frames[3].location.href = '../../servlet/eXH.FilterCriteriaSettingsServlet?requestType=DISP_FILTER_CRITERIA&filterGroupCode=' + filterGroupCode;
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
	}
}

function addNewFilter()
{
	var filterGroupCode = $("#filterGroupCode").val();
	this.document.forms[0].action = '../servlet/eXH.FilterCriteriaSettingsServlet?requestType=GET_CRITERIA_ELEMENT_LIST&filterGroupCode=' + filterGroupCode;
	this.document.forms[0].target = "recordframe";
	this.document.forms[0].submit();
	parent.frames[5].location.href = '../eCommon/jsp/MstCodeError.jsp';
}

function criteriaElementChange()
{
	var criteriaElement = $("#criteriaElement ").val();
	var filterGroupCode = $("#filterGroupCode ").val();
	var dependantCriteriaDtlsJSON = $("#dependantCriteriaDtlsJSON").val();

	if(criteriaElement != "")
	{
		var dataElements = "criteriaElement=" + criteriaElement + "&filterGroupCode=" + filterGroupCode + "&dependantCriteriaDtlsJSON=" + dependantCriteriaDtlsJSON + "&requestType=GET_QRY_RESULT";

		$.post('../servlet/eXH.FilterCriteriaSettingsServlet',
		dataElements,
		function (data) {
			var select = $('#filterValues').empty();
			var selectBTWN = $('#filterValuesBTWN').empty();
			$('#filterValues').append('<option value=""></option>');
			$('#filterValuesBTWN').append('<option value=""></option>');
			$.each(data, function (key, value) {
				$('#filterValues').append('<option value="' + key + '">' + value + '</option>');
				$('#filterValuesBTWN').append('<option value="' + key + '">' + value + '</option>');
			});
		},
			'json');
	}
}

function addFilterCriteria()
{
	var guiFilterSyntax = $("#guiFilterSyntax").val();
	var processingFilterSyntax = $("#processingFilterSyntax").val();

	var criteriaElementVal = $("#criteriaElement option:selected").text();
	var criteriaElementID = $("#criteriaElement option:selected").val().split("-")[0];
	var operator = $("#operator").val();
	var filterValue = getFilterValue()[0];
	var filterValueID = getFilterValue()[1];
	var logicOperator = $("#logicOperator").val();

	var currentProcessingFilterSyntax = criteriaElementID + operator;
	if(operator != " IS NOT NULL " && operator != " IS NULL ") // space is required as the variable is not trimmed
	{
		currentProcessingFilterSyntax += filterValueID;
	}
	if(operator == " BETWEEN ")
	{
		filterValue += " AND " + getFilterBTWNValue()[0];
		filterValueID += " AND " + getFilterBTWNValue()[1];
		currentProcessingFilterSyntax += " AND " + getFilterBTWNValue()[1];
	}

	if(guiFilterSyntax != "") guiFilterSyntax = guiFilterSyntax + logicOperator;
	if(processingFilterSyntax != "") processingFilterSyntax = processingFilterSyntax + logicOperator;

	guiFilterSyntax = guiFilterSyntax + criteriaElementVal + operator;
	if(operator != " IS NOT NULL " && operator != " IS NULL ")
	{
		guiFilterSyntax = guiFilterSyntax + filterValue;
	}
	processingFilterSyntax = processingFilterSyntax + currentProcessingFilterSyntax;

	$("#guiFilterSyntax").text(guiFilterSyntax);
	$("#processingFilterSyntax").val(processingFilterSyntax);

	add2DependantDtlsJSON(filterValueID);
}

function add2DependantDtlsJSON(filterValueID)
{
	var levelNumber = $("#criteriaElement option:selected").val().split("-")[1];
	var dependantCriteriaDtlsJSON = JSON.parse($("#dependantCriteriaDtlsJSON").val());
	dependantCriteriaDtlsJSON[levelNumber] = filterValueID;

	$("#dependantCriteriaDtlsJSON").val(JSON.stringify(dependantCriteriaDtlsJSON));
}

function saveFilterCriteria()
{
	var filterLevelTypeID = $("#filterLevelType option:selected").val();
	var operator = $.trim($("#operator").val());
	var filterValueID = $("#filterValues option:selected").val();

	if(filterLevelTypeID == "") { alert("Please select a Filter Type"); }
	else if(operator == "") { alert("Please select a Operator"); }
	else if((operator != "IS NOT NULL" && operator != "IS NULL" && operator != "IN" && operator != "NOT IN") && filterValueID == "") { alert("Please select a Filter Value"); }
	else if($("#guiFilterSyntax").text() != "" && $("#processingFilterSyntax").val() != "")
	{
		document.getElementById("FilterCriteriaSettings").submit();
		parent.frames[4].document.location.href='../eCommon/html/blank.html';
	}
}

function clearFilterCriteria()
{
	$("#guiFilterSyntax").text("");
	$("#processingFilterSyntax").val("");
}

async function showFilterCriteria(trxNo)
{
	var filterCriteriaValue = escape($("#filterCriteriaValue"+trxNo).text());
	var filterGroupCode = $("#filterGroupCode").val();

	var dialogHeight = "15vh";			    
	var dialogWidth  = "50vw";
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = "../eXH/jsp/FilterCriteriaDisplay.jsp?" +
				"filterGroupCode=" + filterGroupCode +
				"&filterCriteriaValue=" + filterCriteriaValue + "&trxNo=" + trxNo;
 
	await window.showModalDialog(url,arguments,features);
}

function deleteFilterCriteria()
{
	this.document.forms[0].action = '../../servlet/eXH.FilterCriteriaSettingsServlet?requestType=DELETE_FILTER_CRITERIA';
	this.document.forms[0].target = "messageFrame";
	this.document.forms[0].submit();
	window.close();
	window.frame(3).document.location.reload();
}

function addLeftBracket()
{
	var guiFilterSyntax = $("#guiFilterSyntax").val();
	var processingFilterSyntax = $("#processingFilterSyntax").val();

	if(guiFilterSyntax != "")
	{
		guiFilterSyntax += $("#logicOperator").val();
		processingFilterSyntax += $("#logicOperator").val();
	}
	$("#guiFilterSyntax").text(guiFilterSyntax + "(");
	$("#processingFilterSyntax").val(processingFilterSyntax + "(");
}

function addRightBracket()
{
	$("#guiFilterSyntax").text($("#guiFilterSyntax").val() + ")");
	$("#processingFilterSyntax").val($("#processingFilterSyntax").val() + ")");
}

function operatorChange()
{
	var operator = $.trim($("#operator").val());
	$("#filterValues").attr('disabled', false);
	document.getElementById('filterValuesBTWN').style.display = "none";
	
	if(operator == "IN" || operator == "NOT IN")
	{
		$("#filterValues").attr('multiple', true);
	}
	else if(operator == "IS NOT NULL" || operator == "IS NULL")
	{
		$("#filterValues").val('');
		$("#filterValues").attr('disabled', 'disabled');
	}
	else if(operator == "BETWEEN")
	{
		document.getElementById('filterValuesBTWN').style.display = "block";
		$('#filterValues option').clone().appendTo('#filterValuesBTWN');
	}
	else
	{
		$("#filterValues").attr('multiple', false);
	}
}

function appLevelInit()
{
	document.getElementById("addFilterButton").focus();
}

function criteriaSettingsInit()
{
	$("#criteriaElement").focus();
}

function getFilterValue()
{
	var filterValue = ['',''];

	for (var i = 0; i < document.getElementById("filterValues").length; i++) 
	{
		if (document.getElementById("filterValues").options[i].selected == true) 
		{
			filterValue[0] = filterValue[0] +"'"+ document.getElementById("filterValues").options[i].text + "',";
		}
	}

	filterValue[0] = filterValue[0].substring(0, filterValue[0].length - 1);

	var operator = $.trim($("#operator").val());
	if(operator == 'IN' || operator == 'NOT IN')
	{
		filterValue[0] = "(" + filterValue[0] + ")";
		filterValue[1] = "('" + ($("#filterValues").val() || []).join("','") + "')";
	}
	else
	{
		filterValue[1] = "'" + $("#filterValues").val() + "'";
	}
	return filterValue;
}

function getFilterBTWNValue()
{
	var filterValue = ['',''];

	for (var i = 0; i < document.getElementById("filterValuesBTWN").length; i++) 
	{
		if (document.getElementById("filterValuesBTWN").options[i].selected == true) 
		{
			filterValue[0] = filterValue[0] +"'"+ document.getElementById("filterValuesBTWN").options[i].text + "',";
		}
	}

	filterValue[0] = filterValue[0].substring(0, filterValue[0].length - 1);

	var operator = $.trim($("#operator").val());
	if(operator == 'IN' || operator == 'NOT IN')
	{
		filterValue[0] = "(" + filterValue[0] + ")";
		filterValue[1] = "('" + ($("#filterValuesBTWN").val() || []).join("','") + "')";
	}
	else
	{
		filterValue[1] = "'" + $("#filterValuesBTWN").val() + "'";
	}
	return filterValue;
}
