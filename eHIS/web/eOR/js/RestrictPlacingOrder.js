/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	          Name		 Rev.Date		 Rev.Name		        Description
--------------------------------------------------------------------------------------------------------------
16/05/2022     29147      krishna pranay       17/05/2023     Ramesh Goli                MO-CRF-20183

---------------------------------------------------------------------------------------------------------------
*/



function reset()
{
location.reload();	
}

function resetValues()
{
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function onSuccess() {


	f_query_add_mod.location.href = "../../eOR/jsp/RestrictPlacingOrder.jsp?mode="+MODE_MODIFY
}



function selfCheck(element) { 
	if(element.checked){
		element.value="Y";
		return;
	}else{
		element.value="N";
		if(document.getElementById('allChecked').checked==true)
			document.getElementById('allChecked').checked = false;
	}
}



function familyCheck(element) { 
if(element.checked){
	element.value="Y";
	return;
}else{
	element.value="N";
	if(document.getElementById('allSelected').checked==true)
		document.getElementById('allSelected').checked = false;
}
}


function checkAll(ele) 
{
var checkboxes = document.getElementsByName('rest_order_self_yn');
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


function selectAll(ele) 
{ 
var checkboxes = document.getElementsByName('rest_order_family_yn');
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
	f_query_add_mod.document.restrict_place_order.action="../../servlet/eOR.RestrictPlacingOrderServlet";
	f_query_add_mod.document.restrict_place_order.target='messageFrame';
	f_query_add_mod.document.restrict_place_order.method='post';
	f_query_add_mod.document.restrict_place_order.submit();
}