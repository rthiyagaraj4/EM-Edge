function query() {

	f_query_mod.location.href ="../../eMR/jsp/ICDCodeForDiagGrpQueryPage.jsp";
}

function create()
{
f_query_mod.location.href ="../../eMR/jsp/ICDForDiagGroupMain.jsp";
}


function apply() {


			var fields = new Array (parent.frames[1].document.frames[1].document.frames[0].document.forms[0].diag_grp_detail);
			var names = new Array(getLabel("eMR.DiagnosisProcedureGroup.label","MR"));			
			if(f_query_mod.parent.frames[1].checkFieldsofMst( fields, names, f_query_mod.parent.frames[2]))
			{
			if(parent.frames[1].document.frames[1].document.frames[1])
			{
			if (parent.frames[1].document.frames[1].document.frames[1].document.forms[0])
			{
			parent.frames[1].document.frames[1].document.frames[1].document.forms[0].action="../../servlet/eMR.ICDForDiagGroupServlet";
			parent.frames[1].document.frames[1].document.frames[1].document.forms[0].target="messageFrame";
			parent.frames[1].document.frames[1].document.frames[1].document.forms[0].submit();
			}
				 else history.go(0);
			}
	
			}	
}

function onSuccess() {
		parent.frames[1].document.frames[1].location.reload();
}

function reset() {

	//if(parent.frames[1].document.frames[1].document.forms[0])
		//parent.frames[1].document.frames[1].location.reload();
	if(frames[1].document.frames[0].document.forms[0])
		frames[1].document.frames[0].location.reload();	
}
function ChgVal(Obj) {
	if(Obj.value == "Y")
		Obj.value="N";
	else if(Obj.value == "N")
		Obj.value="Y";
}

function submitPrevNext(from, to){
	            document.forms[0].from.value = from;
	            document.forms[0].to.value = to;
				document.forms[0].alphadescription.value = document.forms[0].alphadescription.value; 
				document.forms[0].searchby.value = document.forms[0].searchby.value; 
				document.forms[0].searchcrt.value = document.forms[0].searchcrt.value; 
	            document.forms[0].submit();
	        }
	
	/*function callMember1(alpha)
	{	
	//var temp=document.forms[0].diag_grp_detail.value;
	//var temp1=temp.split('^');
	//var diag_group_code=temp1[0];
	//var diag_code_scheme=temp1[1];
	//var group_type_value = temp1[5];
	//parent.frames[1].location.href="../../eMR/jsp/ICDForDiagGroupResult.jsp?diag_group_code="+diag_group_code+"&fromSelect=fromSelect&selectedAlpha="+alpha+"&diag_code_scheme="+diag_code_scheme+"&group_type="+group_type_value;

				//document.forms[0].from.value = from;
	            //document.forms[0].to.value = to; 
				document.forms[0].selectedAlpha.value=alpha;
				document.forms[0].from.value="0";
				document.forms[0].to.value="12";			
	            document.forms[0].submit();
				document.getElementById("header").style.visibility="visible";
	}
	
	*/	
		function populateResult()
		{
			search();
			
		
		}
		function search()
		{
			var fields = new Array (document.forms[0].diag_grp_detail);
			var names = new Array(getLabel("eMR.DiagnosisProcedureGroup.label","MR"));
			if(parent.parent.frames[1].checkFieldsofMst( fields, names, parent.parent.frames[2]))
			{
				callMember();
				//to_visible();				
			}
			else
			return false;
		
		}

		function clearValues()
		{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		}
		
		function to_hide()
		{
			//document.getElementById("alpha").style.visibility="hidden";
			parent.frames[1].location.href='../../eCommon/html/blank.html';			


		}
		/*
	    function to_visible()
		{

			document.getElementById("alpha").style.visibility="visible";
			
			parent.frames[1].location.href='../../eCommon/html/blank.html'
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'
		}*/
	
	function callMember()
	{		
	var temp=document.forms[0].diag_grp_detail.value;	
	var temp1=temp.split('^');
	var diag_group_code=temp1[0];
	var diag_code_scheme=temp1[1];
	var group_type_value = temp1[5];
	var searchby=document.forms[0].searchby.value;
	var searchcrt=document.forms[0].searchcriteria.value;
	var alphadescription=document.forms[0].alpha_desc.value;
	parent.frames[1].location.href="../../eMR/jsp/ICDForDiagGroupResult.jsp?diag_group_code="+diag_group_code+"&fromSelect=fromSelect&selectedAlpha=A&diag_code_scheme="+diag_code_scheme+"&group_type="+group_type_value+"&searchby="+searchby+"&alphadescription="+alphadescription+"&searchcrt="+searchcrt;
	}
		
	function populateValues(Obj)
	{
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';//for clearing the messageFrame

		if(Obj.value !='')
		{
		var temp=new Array();
		temp=Obj.value.split('^');
		diag_group_code=temp[0];diag_code_scheme=temp[1];speciality_code=temp[2];facility_id=temp[3];
		var group_type = temp[4];
		var group_type_value = temp[5];
		if (group_type_value=="D")
		{
			if(diag_code_scheme == '1')
				document.getElementById("diag_code_disp").innerText=getLabel("eMR.ICD10.label","MR");
			else
			if(diag_code_scheme =='2')
				document.getElementById("diag_code_disp").innerText="ICD9CM";
		}
		else
		{
			if(diag_code_scheme == '3')
				document.getElementById("diag_code_disp").innerText="CPT4";
			else
			if(diag_code_scheme =='4')
				document.getElementById("diag_code_disp").innerText="ICD9CM";
			else if (diag_code_scheme =='6')
				document.getElementById("diag_code_disp").innerText="ICD10-PCS";
		}
			
		var htmlVal = "<html><head></head><body onKeyDown='lockKey()'>"
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eMR/jsp/ICDForDiagGroupPopulate.jsp' target='messageFrame'>"
		htmlVal += "<input type=hidden name=diag_group_code value=" +diag_group_code + ">"
		htmlVal += "<input type=hidden name='diag_code_scheme' id='diag_code_scheme' value=" +diag_code_scheme + ">"
		htmlVal += "<input type=hidden name='speciality_code' id='speciality_code' value=" +speciality_code + ">"
		htmlVal += "<input type=hidden name='facility_id' id='facility_id' value=" +facility_id + ">"
		htmlVal += "<input type=hidden name='group_type' id='group_type' value=" +group_type_value + ">"
		htmlVal += "</form></body></html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
		parent.parent.messageFrame.document.frm_temp.submit();
		}
		else
		{
		document.getElementById("diag_code_disp").innerText="";
		document.getElementById("speciality").innerText="";
		document.getElementById("practitioner").innerText="";
		document.getElementById("facility").innerText="";		
		document.getElementById("speciality_disp").innerText="";
		document.getElementById("facility_disp").innerText="";
		document.getElementById("pract_disp").innerText="";
		document.getElementById("diag_code_desc").innerText="";
		document.getElementById("group_type").innerText="";
		document.getElementById("group_type_disp").innerText="";
		}	
	}

	function callMember1(alpha)
	{	
		document.forms[0].selectedAlpha.value=alpha;
		document.forms[0].from.value="0";
		document.forms[0].to.value="12";
		document.forms[0].submit();
		document.getElementById("header").style.visibility="visible";
	}

