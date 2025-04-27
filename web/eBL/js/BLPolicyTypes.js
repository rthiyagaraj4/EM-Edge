 /*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200929            72977         NMC-JD-CRF-0059       Mohana Priya K
*/

function create(){
	f_query_add_modify.location.href="../../eBL/jsp/BLPolicyTypesAddModify.jsp?&mode=insert";
}

function apply(){
	var frm=f_query_add_modify.document.forms[0];
	if(frm.name=='query_form' || frm.name=='QueryResult'){
		commontoolbarFrame.location.reload();
	}else{	
			var fields = new Array (f_query_add_modify.document.forms[0].facility,f_query_add_modify.document.forms[0].policy_type_code,f_query_add_modify.document.forms[0].long_desc,f_query_add_modify.document.forms[0].short_desc);
			var facility = getLabel("Common.FacilityID.label","Common")
			var policytype=getLabel("eBL.POLICY_TYPE_CODE.label","BL");
			var description_value=getLabel("Common.longdescription.label","Common");
			var short_desc_value=getLabel("Common.shortdescription.label","Common");
			var names = new Array (facility,policytype,description_value,short_desc_value);
			if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_modify.document.forms[0].submit();
			}
	}
}

function onSuccess(){
	if(f_query_add_modify.document.forms[0].mode.value=="insert") 				f_query_add_modify.location.href='../../eBL/jsp/BLPolicyTypesAddModify.jsp?mode=insert';
	else 
	f_query_add_modify.location.reload();
}

function reset(){
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BLPolicyTypesAddModify.jsp") != -1){
		if(f_query_add_modify.document.location.href.indexOf("BLPolicyTypesMainFrame.jsp") != -1)
			return false;
		else
			f_query_add_modify.document.forms[0].reset();
		}
	else			if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BLPolicyTypeQueryCriteria.jsp") != -1)
	{
		f_query_add_modify.document.forms[0].reset();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_modify.location.href='../../eBL/jsp/BLPolicyTypeQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].status.checked==true)			
		document.forms[0].status.value="E";
	else			
		document.forms[0].status.value="D";
}

function setGosiValue(){ 
	if(document.forms[0].gosipolicy.checked==true)			
		document.forms[0].gosipolicy.value="Y";
	else			
		document.forms[0].gosipolicy.value="N";
}
