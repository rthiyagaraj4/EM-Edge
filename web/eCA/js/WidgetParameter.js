/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created
12/02/2013	  CHL_CRF		Nijitha S									CHL_CRF
21/03/2014	 IN034513	  	Vijayakumar K 							SS-CRF-0007 In the patient Chart Clinician Access, 
																	the previous Encounters were grouped by specialty in eHIS version 5x. This enabled the doctors to view the details of their desired specialty. With the upgrade, this grouping has been removed.
---------------------------------------------------------------------------------------------------------------

*/
function apply() {
			f_query_add_mod.document.chartSummaryWidgetParamForm.submit();
		
	}
function enableDisableWidgetThemeOrIcon(obj)
{
if(obj.checked)
	{
		document.chartSummaryWidgetParamForm.EnableWidgetThemeOrIcon.value = 'Y';
		document.chartSummaryWidgetParamForm.widget_ThemeIcon_yn.value = 'Y';
			document.chartSummaryWidgetParamForm.widget_Icon_yn.value = 'Y';
		document.chartSummaryWidgetParamForm.widget_Theme_yn.value = 'Y';
		document.getElementById('widgetThemes').style.display='';
		document.getElementById('widgetThemes1').style.display='';
		document.getElementById('widgetIcons').style.display='';
		document.getElementById('widgetIcons1').style.display='';
		
		document.getElementById('themerequired').checked=true;
		document.getElementById('iconsrequired').checked=true;
	}
	else
	{
		document.chartSummaryWidgetParamForm.EnableWidgetThemeOrIcon.value = 'N';
		document.chartSummaryWidgetParamForm.widget_ThemeIcon_yn.value = 'N';
		document.chartSummaryWidgetParamForm.widget_Icon_yn.value = 'N';
		document.chartSummaryWidgetParamForm.widget_Theme_yn.value = 'N';
		document.getElementById('widgetThemes').style.display='none';
		document.getElementById('widgetIcons').style.display='none';
		document.getElementById('widgetThemes1').style.display='none';
		document.getElementById('widgetIcons1').style.display='none';
		
	}
}

function defaultWidgetIconSelection(obj)
{
	document.getElementById("widget_Icon_yn").value=obj.value;
}


function defaultWidgetThemeSelection(obj)
{
	document.getElementById("widget_Theme_yn").value=obj.value;
}
function onSuccess() {	
	f_query_add_mod.location.reload();
}


function reset() {
			
			f_query_add_mod.document.chartSummaryWidgetParamForm.reset() ;
		f_query_add_mod.document.getElementById('widgetThemes').style.display='';
		f_query_add_mod.document.getElementById('widgetThemes1').style.display='';
		f_query_add_mod.document.getElementById('widgetIcons').style.display='';
	f_query_add_mod.document.getElementById('widgetIcons1').style.display='';
}
//IN034513 starts
function enableEncounterGrpByCurrSpeclty(obj)
{
	if(obj.checked)
		document.chartSummaryWidgetParamForm.enc_grp_by_splty_yn.value = 'Y';
	else
	document.chartSummaryWidgetParamForm.enc_grp_by_splty_yn.value = 'N';
}
//IN034513 ends
