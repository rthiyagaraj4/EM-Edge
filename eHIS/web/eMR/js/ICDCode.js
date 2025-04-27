function query() {

	f_query_mod.location.href ="../../eMR/jsp/ICDCodeMain.jsp";
}

function apply() {
	var fields = new Array (add.document.ICDUpdate_form.tab_list_no);
	var names = new Array ( getLabel("eMR.TabulationListNumber.label","MR"));
	if(add.checkFields( fields, names, messageFrame)) {
		add.document.ICDUpdate_form.submit();
	}
}

function onSuccess() {
}

function reset() {
f_query_mod.location.href ="../../eMR/jsp/ICDCodeMain.jsp";

}
function ChgVal(Obj) {
	if(Obj.value == "Y")
		Obj.value="N";
	else if(Obj.value == "N")
		Obj.value="Y";
}

function clearValues()
		{
			document.forms[0].reset();
			parent.frames[1].location.href="../../eCommon/html/blank.html"
		}
		function callResultFrame()
		{
			var param='';
				for(j=0;j<document.forms[0].length-2;j++)
			{
					param=param+'&'+document.forms[0].elements[j].name+'='+document.forms[0].elements[j].value;
					
			}

			parent.frames[1].location.href="../../eMR/jsp/ICDCodeQueryResult.jsp?"+param
		}


			async function showModal(code_ind,diag_srl_no,eff_status)
	{
			var retVal = 	new String();
			var dialogHeight= "24vh" ;
			var dialogWidth	= "42vw" ;
			var dialogLeft="300";
			var status = "no";
			var arguments	= "" ;
			var tit="";
			tit= getLabel("Common.ICDCode.label","Common");
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+"; dialogLeft:"+dialogLeft ;
			retVal = 			await window.showModalDialog("../../eMR/jsp/ModifyICDCodeMain.jsp?diag_srl_no="+diag_srl_no+"&eff_status="+eff_status+"&code_ind="+code_ind+"&title="+encodeURIComponent(tit),arguments,features);
			
			//parent.frames[1].document.forms[0].submit();
			if(retVal == 'cancel');
			else			
			document.location.reload();
	}

