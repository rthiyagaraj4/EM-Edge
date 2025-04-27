function query() 
{
	f_query_mod.location.href ="../../eMR/jsp/ICDCodeForDaggerQueryPage.jsp";
}

function create()
{
	f_query_mod.location.href ="../../eMR/jsp/ICDCodeForDaggerMain.jsp";
	parent.frames[1].document.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'
}


function apply() 
{
	var fields = new Array ( parent.frames[1].document.frames[1].document.frames[0].document.forms[0].dagger_code);
	var names = new Array(getLabel("eMR.DaggerCode.label","MR"));			
	if(f_query_mod.parent.frames[1].checkFieldsofMst( fields, names, f_query_mod.parent.frames[2]))
	{
		if(parent.frames[1].document.frames[1].document.frames[1])
		{
			if(parent.frames[1].document.frames[1].document.frames[1].document.forms[0])
			{
				parent.frames[1].document.frames[1].document.frames[1].document.forms[0].action="../../servlet/eMR.ICDCodeForDaggerServlet";
				parent.frames[1].document.frames[1].document.frames[1].document.forms[0].target="messageFrame";
				parent.frames[1].document.frames[1].document.frames[1].document.forms[0].submit();
			}
			else history.go(0);
		}

	}
}


function onSuccess() 
{
	if(frames[1].document.forms[0].name=="parentForm")
		frames[1].location.href = "../../eMR/jsp/ICDCodeForDaggerMain.jsp";
}


function reset()
{
	if(frames[1].document.forms[0].name=="parentForm")
		frames[1].location.href = "../../eMR/jsp/ICDCodeForDaggerMain.jsp";
	else
		frames[1].document.forms[0].reset();
}


function ChgVal(Obj)
{
	if(Obj.value == "Y")
		Obj.value="N";
	else if(Obj.value == "N")
		Obj.value="Y";
}



//added
async function show_window()
	{
		var scheme = document.forms[0].scheme.value;
		var scheme_desc	= document.forms[0].scheme_desc.value;
		var p_auth_yn="N";

		if (scheme == 5)
		{
			var retVal = "test Value";
			var dialogHeight= "28vh" ;
			var dialogWidth = "43" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
			var arguments   = "" ;
			retVal =await  window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);
			
			var arr = new Array();
			arr = retVal.split("|");
			var stra = arr[0];
			var strc = arr[1];
			var strb = arr[2];

			document.forms[0].dagger_code.value = stra;
//			document.getElementById("DaggerDescription").innerHTML = "";
		}

		if (scheme == 1 || scheme == 2)
		{
			var retVal =    new String();
			var dialogHeight= "27.22vh" ;
			var dialogWidth = "44vw" ;
			var status = "no";

			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			if(scheme == 1)
				term_set_id	=	"ICD10";
			else
				term_set_id	=	"";


			retVal = await window.showModalDialog("PaintConsultationFrame.jsp?code_indicator=D&called_from=MR&title="+scheme_desc+"&CodeList&p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_desc+"&p_auth_yn="+p_auth_yn+"&term_set_id="+term_set_id,arguments,features);
			
			if (!(retVal == null))
			{
				var retdata;
				if(scheme=="2")
				{
					retdata	= retVal.split("/") ;
					retVal	= retdata[0];
				}
				document.forms[0].dagger_code.value = retVal;
//				document.getElementById("DaggerDescription").innerHTML = "";
			}
		}
	}


	function populateResult()
	{
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
		var fields = new Array (document.forms[0].dagger_code);
		var names = new Array(getLabel("eMR.DaggerCode.label","MR"));
		document.forms[0].search.disabled = true;
		if(parent.parent.frames[1].checkFieldsofMst( fields, names, parent.parent.frames[2]))
		{
			var dagger_code = document.forms[0].dagger_code.value;
		var scheme = document.forms[0].scheme.value;
		var tmpPage = ""	//parent.frames[1].location.href="../../eMR/jsp/ICDCodeForDaggerQueryResult.jsp?dagger_code="+dagger_code+"&scheme="+scheme+"&fromSelect=fromSelect&selectedAlpha=A";

		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMR/jsp/ICDCodeForDaggerQueryResult.jsp'><input type='hidden' name='dagger_code' id='dagger_code' value='"+dagger_code+"'><input type='hidden' name='scheme' id='scheme' value='"+scheme+"'><input type='hidden' name='fromSelect' id='fromSelect' value='fromSelect'><input type='hidden' name='selectedAlpha' id='selectedAlpha' value='A'></form></body></html>";
		 parent.frames[1].document.write(HTMLVal);
	     parent.frames[1].document.tempform1.submit(); 
		 document.forms[0].search.disabled = false;
		
		return true;
		}
		else
		{
			document.forms[0].search.disabled = false;
			return false;
		}
	}


	function clearValues()
	{
		document.forms[0].search.disabled = false;
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
	

	function submitPrevNext(from, to)
	{
		document.forms[0].from.value = from;
		document.forms[0].to.value = to; 
		document.forms[0].submit();
	}

	function callMember(alpha)
	{	
		document.forms[0].selectedAlpha.value=alpha;
		document.forms[0].from.value="0";
		document.forms[0].to.value="12";
		document.forms[0].submit();
		document.getElementById("header").style.visibility="visible";
	}
	



function Call(){
	parent.frames[1].location.href='../../eMR/jsp/PaintConsultation.jsp?'+document.consultation_form.query_string.value
}
function CallSearch(){
	//parent.frames[1].location.href='../../eCA/jsp/PaintSearchProblem.jsp?'+document.consultation_form.query_string.value
	parent.frames[1].location.href='../../eMR/jsp/PaintSearch.jsp?'+document.consultation_form.query_string.value;
}
function CallLevelTab(){
	//parent.frames[1].location.href='../../eCA/jsp/CASearchScreenFrmes.jsp?'+document.consultation_form.query_string.value
	parent.frames[1].location.href='../../eMR/jsp/SelectTermCode.jsp?'+document.consultation_form.query_string.value;
		
}
function CallSelect(){
	//parent.frames[1].location.href='../../eCA/jsp/CASearchScreenFrmes.jsp?'+document.consultation_form.query_string.value
	parent.frames[1].location.href='../../eMR/jsp/MRSearchScreenFrmes.jsp?'+document.consultation_form.query_string.value;
		
}
var currentTab = new String();
currentTab = "demogrp_tab";
function tab_click(objName) {
 		// FIRST CHANGE THE CURRENT SELECTED TAB
 		changeTab(objName);
/*
 		if (objName == 'demogrp_tab')
 			parent.group_head.moveToTab(1);
 		else if (objName == 'cmodeaddr_tab')
 			parent.group_head.moveToTab(2);
 		else if (objName == 'rlcnts_tab')
 			parent.group_head.moveToTab(3);

*/
 		if (objName == 'demogrp_tab'){
 			Call();
		}else if (objName == 'cmodeaddr_tab'){
 			CallSearch();
		}else if (objName == 'level_tab'){
 			CallLevelTab();
		}else if (objName == 'rlcnts_tab'){
 			CallSelect();
		}
}

function changeTab(TabName)	{
	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
		/* if (currentTab == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom List_click.gif';
		else if (currentTab == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search_click.gif';
		else if (currentTab == 'rlcnts_tab')
			document.getElementById("rlcnts_tab").src = '../../eCA/images/Select_click.gif';
*/

	// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

		/*if (TabName == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom_List.gif';
		else if (TabName == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search.gif';
		else if (TabName == 'rlcnts_tab')
			document.getElementById("rlcnts_tab").src = '../../eCA/images/Select.gif';
*/

	// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER

	if(TabName == 'demogrp_tab'){
			document.getElementById("customlist").scrollIntoView();
	}else if (TabName == 'cmodeaddr_tab'){
			document.getElementById("Search").scrollIntoView();
	}else if (TabName == 'level_tab'){
			document.getElementById("Level").scrollIntoView();
	}else if (TabName == 'rlcnts_tab'){
			document.getElementById("Select").scrollIntoView();
	}
		currentTab = TabName;
}



