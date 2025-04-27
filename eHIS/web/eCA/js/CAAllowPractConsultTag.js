/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------
*/

function checkAll(ele) 
{ 
var checkboxes = document.getElementsByName('pract_consult_tag_yn');

if (ele.checked) {
    for (var i = 0; i < checkboxes.length; i++) { 
        if (checkboxes[i].type == 'checkbox') { 
            checkboxes[i].checked = true;
			checkboxes[i].value="Y";
        }
    }
} else {
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].type == 'checkbox') {
            checkboxes[i].checked = false;
			checkboxes[i].value="N";
        }
    }
}
}

function apply()
{
	f_query_add_mod.document.allowPractConslTag.action="../../servlet/eCA.CAAllowPractConsultTagServlet";
	f_query_add_mod.document.allowPractConslTag.target='messageFrame';
	f_query_add_mod.document.allowPractConslTag.method='post';
	f_query_add_mod.document.allowPractConslTag.submit();
}

function practConsutTag(element) { 
	if(element.checked){
		element.value="Y";
		return;
	}else{
		element.value="N";
		if(document.getElementById('allChecked').checked==true)
			document.getElementById('allChecked').checked = false;
	}
}

function reset()
{
location.reload();	
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}
