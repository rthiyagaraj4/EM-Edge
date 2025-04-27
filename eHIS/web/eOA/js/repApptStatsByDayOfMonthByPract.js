function run() { 
	var fields = new Array ( f_query_add_mod.document.forms[0].mon,
						f_query_add_mod.document.forms[0].years
					    );
	var names = new Array (getLabel("eOA.StatisticsMonth.label","eOA")
,getLabel("Common.year.label","Common"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		f_query_add_mod.document.getElementById('P_From_Pract_Code').value = f_query_add_mod.document.getElementById('p_fm_pract_id').value;
		f_query_add_mod.document.getElementById('P_To_Pract_Code').value = f_query_add_mod.document.getElementById('p_to_pract_id').value; f_query_add_mod.document.getElementById('P_Start_Month').value = f_query_add_mod.document.forms[0].mon.value;
		f_query_add_mod.document.forms[0].P_Start_Year.value = f_query_add_mod.document.forms[0].years.value; 		
        if( f_query_add_mod.CheckString(getLabel("Common.resourceid.label","Common"), f_query_add_mod.document.getElementById('P_From_Pract_Code'),f_query_add_mod.document.getElementById('P_To_Pract_Code'), messageFrame )  ) {
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function reset()
{
	f_query_add_mod.document.forms[0].reset();
}
function practValidate(Obj)
		{
	document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
	document.getElementById('p_fm_pract_id').value='';
		document.getElementById('p_to_pract_id').value='';
		if(Obj.value=='')
		{

			document.getElementById('p_fm_pract_id').value='';
			document.getElementById('p_to_pract_id').value='';
			document.getElementById('p_fm_pract_id').disabled=true;
			document.getElementById('pract_id').disabled=true;
			document.getElementById('pract_id1').disabled=true;
			document.getElementById('p_to_pract_id').disabled=true;
		}
		else
			{
		document.getElementById('p_fm_pract_id').disabled=false;
			document.getElementById('p_to_pract_id').disabled=false;
		document.getElementById('pract_id').disabled=false;
		document.getElementById('pract_id1').disabled=false;
			}
		}

function getResource(Obj)
{
	var carelocn="";
	var resource1 = document.forms[0].p_resource_class1.value;
		var n=document.getElementById('fm_pract_type').options.length;
	for(var i=0;i<n;i++){
		document.getElementById('fm_pract_type').remove("clinic");
		document.getElementById('to_pract_type').remove("clinic");
		
	}
	
	var opt=document.createElement("OPTION");
	opt.text=" -------"+getLabel("Common.defaultSelect.label","Common")+"------ ";
	opt.value="";
	document.getElementById('fm_pract_type').add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text=" -------"+getLabel("Common.defaultSelect.label","Common")+"------ ";
	opt1.value="";
	document.getElementById('to_pract_type').add(opt1);	
	
if(!(resource1 == null || resource1 == ""))
{
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
}





	function validateYear(obj)
	{
		var msg;
		if (obj.value!=""){
			
		var greg_obj = convertDate(obj.value,"yy",localeName,"en");
		
		if (greg_obj < 1900 || greg_obj > 3000)
		{
			msg = getMessage("YR_CHECK","OA")+ "<br>";
			document.forms[0].years.value ="";
			obj.focus();
		}
		if (msg!=null && msg != "")
		{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg ;
		}

		}
	}



	function enablepr(obj)
{
	document.getElementById('p_fm_pract_id').value='';
		
	
}
function enablepr1(obj)
{
	document.getElementById('p_to_pract_id').value='';	
		
}


	function CheckString(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
