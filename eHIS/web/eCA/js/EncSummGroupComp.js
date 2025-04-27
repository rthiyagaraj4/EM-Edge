//Created by Sethuraman for encounter Summary requirements
/* Functions called from EncSummGroupCompHeader.jsp */
function create()
{	
	f_query_add_mod.location.href = '../../eCA/jsp/EncSummGroupCompMain.jsp?mode=insert';
}

function query(){
	f_query_add_mod.document.location.href = '../../eCA/jsp/EncSummGroupCompMain.jsp?mode=delete';
}

function resetValues()
{	
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
}

function onSuccess(){
	
	var groupFlag = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_flag1.value;
	var groupType = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_type1.value;	
	var groupCode = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1.value;
	var mode = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.mode.value;
	
	f_query_add_mod.componentsFrame.location.href = '../../eCA/jsp/EncSummGroupCompList.jsp?mode='+mode+'&groupFlag='+groupFlag+'&groupType='+groupType+'&groupCode='+groupCode+'&flag=0&loadFirst=Yes';	
}

function resetValuesHeader(obj)
{
	
	if (obj.name == 'es_group_flag')
	{
		document.EncSummGroupCompPopForm.es_group_type.value="";
		document.EncSummGroupCompPopForm.es_group_code.value="";
		document.EncSummGroupCompPopForm.es_group_flag1.value=obj.value;
		document.EncSummGroupCompPopForm.es_group_type1.value="";
		document.EncSummGroupCompPopForm.es_group_code1.value="";
	}
	if (obj.name == 'es_group_type')
	{
		
		document.EncSummGroupCompPopForm.es_group_code.value="";		
		document.EncSummGroupCompPopForm.es_group_type1.value=obj.value;
		document.EncSummGroupCompPopForm.es_group_code1.value="";
	}
	
	parent.componentsFrame.location.href = '../../eCommon/html/blank.html';
	parent.addCompsFrame.location.href = '../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
		
}

function setGroupFlag(obj)
{	
	if (obj.value == '0')
		document.EncSummGroupCompPopForm.es_group_flag1.value="0";	
	else
		document.EncSummGroupCompPopForm.es_group_flag1.value="1";	
}

function setGroupType(obj){	
	document.EncSummGroupCompPopForm.es_group_type1.value=obj.value;	
}

function setValue()
{
	document.EncSummGroupCompPopForm.flag.value='false';
}

function getGroupSubGroupCode(objCode)
{		
	if(objCode.name=='es_group_code')
	{
		document.EncSummGroupCompPopForm.es_group_code1.value = document.EncSummGroupCompPopForm.es_group_code.value;
		groupCodeSearch(objCode);
	}

	if(objCode.name == "groupcode_srch")
	{		
		if(document.EncSummGroupCompPopForm.flag.value=='false')
			return false;
		else			
			callGroupCodeType();
	}
			
}

function groupCodeSearch(objCode)
{	
	var groupCodeValue = objCode.value;
	var groupFlag = document.EncSummGroupCompPopForm.es_group_flag1.value;
	var groupType = document.EncSummGroupCompPopForm.es_group_type1.value;	
	
	if(groupCodeValue == '')
	{
		document.EncSummGroupCompPopForm.flag.value='true';
		return false;
	}
	else
	{			
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' " +
				"language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<body  onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummGroupCompIntermediate.jsp'>" +
				"<input type=hidden name='groupFlag' id='groupFlag' value='"+groupFlag+"'>" +
						"<input type=hidden name='groupType' id='groupType' value='"+groupType+"'>" +
								"<input type=hidden name='groupCode' id='groupCode' value='"+groupCodeValue+"'></form></body></html>";		
		parent.BlankFrame.document.write(HtmlVal);		
		parent.BlankFrame.document.tempform.submit();		
	}
}

function callGroupCodeType()
{
	var groupFlag = document.EncSummGroupCompPopForm.es_group_flag1.value;
	var groupType = document.EncSummGroupCompPopForm.es_group_type1.value;	
	
	if (groupFlag == ''){		
		alert("Please select "+getLabel("Common.GroupSubFlag.label","Common"));
		return false;		
	}
	
	if (groupType == ''){
		alert("Please select Group Type ");
		return false;
	}	
	
	//var sql = "SELECT note_type code,note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) ORDER BY  note_type_desc";
	var sql = "SELECT es_group_code code, es_group_desc description FROM cr_es_group_header where es_group_status='E' and es_group_flag = "+groupFlag+" and es_group_type = '"+groupType+"' and upper(es_group_desc) like upper(?) order by es_group_desc";
	var title = getLabel("Common.GroupSubGroup.label","Common");
	var target = document.EncSummGroupCompPopForm.es_group_code1;
	target.value = "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "3,4";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
		document.EncSummGroupCompPopForm.es_group_code.value = retArray[1];
		document.EncSummGroupCompPopForm.es_group_code1.value = retArray[0];
	}
	else
	{
		document.EncSummGroupCompPopForm.es_group_code.value = '';
		document.EncSummGroupCompPopForm.es_group_code1.value = '';
	}
}

function callGroupCodeType1(sql,title,target)
{		
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;	
}

function loadFrames()
{
	var mode = document.EncSummGroupCompPopForm.mode.value;
	var groupFlag = document.EncSummGroupCompPopForm.es_group_flag1.value;
	var groupType = document.EncSummGroupCompPopForm.es_group_type1.value;	
	var groupCode = document.EncSummGroupCompPopForm.es_group_code1.value;
	
	if (groupFlag == "")
	{
		var erroMsg=getMessage("CAN_NOT_BE_BLANK",'COMMON');
		erroMsg=erroMsg.replace('$',getLabel("Common.GroupSubFlag.label","Common"));
		if(erroMsg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
			return false;
		}
	}
	if (groupType == "")
	{
		var erroMsg=getMessage("CAN_NOT_BE_BLANK",'COMMON');
		erroMsg=erroMsg.replace('$',getLabel("Common.GroupType.label","Common"));
		if(erroMsg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
			return false;
		}
	}
	
	if (groupCode !="")
	{
		parent.componentsFrame.location.href = '../../eCA/jsp/EncSummGroupCompList.jsp?mode='+mode+'&groupFlag='+groupFlag+'&groupType='+groupType+'&groupCode='+groupCode+'&flag=0&loadFirst=Yes';
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}	
	else
	{
		var erroMsg=getMessage("CAN_NOT_BE_BLANK",'COMMON');
		erroMsg=erroMsg.replace('$',getLabel("Common.code.label","Common"));
		if(erroMsg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
			return false;
		}
	}
	
}

function apply()
{
	var compSelected = 0;
	var rowIndex = 0;
	var checkBoxName = "secChk";
	var compName = "";
	var compFlag = "";
	var compType = "";
	var compCode = "";
	var compStr = "";
	var recCount = 0;
	
	var compDesc = "";
	
	var groupFlag = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_flag1.value;
	var groupType = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_type1.value;	
	var groupCode = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.es_group_code1.value;
	var mode = f_query_add_mod.EncSummGroupCompFrame.document.EncSummGroupCompPopForm.mode.value;
	
	var compDataStr = "";
	
	if(f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm != null)
	{		
		var els = f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm.elements;
		for (var i = 0, len = els.length; i < len; ++i) {
		    if (els[i].tagName == "INPUT") {
		        if (els[i].type == "checkbox") {
		        	if (els[i].checked == true){
		        		compSelected = 1;
		        		
		        		compName = els[i].name;		        		
		        		compStr = compName.substring(checkBoxName.length);
		        		rowIndex = parseInt(compStr);		        				        		
		        		
		        		var objText1 = eval("f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm.comp_Flag"+rowIndex);		        		
		        		var objText2 = eval("f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm.comp_type"+rowIndex);
		        		var objText3 = eval("f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm.comp_code"+rowIndex);
		        		//var objText4 = eval("f_query_add_mod.componentsFrame.document.encSummGroupSelCompForm.comp_desc"+rowIndex);
		        		
		        		compFlag = objText1.value;
		        		compType = objText2.value;
		        		compCode = objText3.value;		        		
		        		//compDesc = objText3.value;	
		        		
		        		compDataStr = compDataStr + compFlag + "~" + compType + "~" + compCode;		        		
		        		compDataStr = compDataStr + "^";	        		
		        		
		        		recCount++;	        		
		        	}
		            
		        } 
		    }
		}
		if (compSelected == 0){
			alert("Please select "+getLabel("Common.GroupSubFlag.label","Common")+ " to remove ");
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
		else
		{			
			f_query_add_mod.BlankFrame.document.write("<html><body><form name='removeCompForm' id='removeCompForm'>"+
			"<input type='hidden' name='es_group_flag' id='es_group_flag' value='"+groupFlag+"'>" +
			"<input type='hidden' name='es_group_type' id='es_group_type' value='"+groupType+"'>" +
			"<input type='hidden' name='es_group_code' id='es_group_code' value='"+groupCode+"'>" +
			"<input type='hidden' name='comp_data' id='comp_data' value='"+compDataStr+"'>" +	
			"<input type='hidden' name='recordCount' id='recordCount' value='"+recCount+"'>" +
			"<input type='hidden' name='mode' id='mode' value='"+mode+"'></form></body></html>");
			f_query_add_mod.BlankFrame.document.removeCompForm.action='../../servlet/eCA.EncSummGroupCompServlet';
			f_query_add_mod.BlankFrame.document.removeCompForm.target='messageFrame';
			f_query_add_mod.BlankFrame.document.removeCompForm.method='post';			
			f_query_add_mod.BlankFrame.document.forms[0].submit();
			f_query_add_mod.BlankFrame.location.href='../../eCommon/html/blank.html';			
		}
		
	}
	else 
	{ 
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

/* --------------------- Functions called from EncSummGroupCompHeader.jsp ends here ---------------------*/

/* Functions called from EncSummGroupCompList.jsp */

async function loadComponentPage(obj)
{		
	var gFlag = 1;
	
	/*
	if (obj.name == 'addSubGroupbtn')
		gFlag = 1;
	else if (obj.name == 'addCompBtn')
		gFlag = 0;
	*/
	
	parent.addCompsFrame.document.write("<html><form name='remCompForm' id='remCompForm' action='../../eCA/jsp/EncSummGroupCompRemoveComp.jsp'>" +			
			"<input type='hidden' name='called_from' id='called_from' value='resetBean'></form></html>");
	parent.addCompsFrame.document.remCompForm.submit();
	
	var mode = document.encSummGroupSelCompForm.mode.value;
	var groupFlag = document.encSummGroupSelCompForm.groupFlag.value;
	var groupType = document.encSummGroupSelCompForm.groupType.value;
	var groupCode = document.encSummGroupSelCompForm.groupCode.value;	

	//alert(" - - - groupFlag: "+groupFlag+" - - - groupType: "+groupType+" - - - groupCode: "+groupCode);
	
	var retVal = "";
	var dialogHeight = "45";
	var dialogWidth =	"60";
	var dialogTop = "150";
	var status	= "no";
	var arguments =	"" ;
	
	var action_url = "";
	var features = "";

	action_url 	= '../../eCA/jsp/EncSummGroupCompAddCompMain.jsp';	
	features =	"dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url += "?mode="+mode+"&groupFlag="+groupFlag+"&groupType="+groupType+"&groupCode="+groupCode+"&gFlag="+gFlag;
	retVal = await window.showModalDialog(action_url,arguments,features);	
	//retVal = window.open(action_url,arguments,features);	
	
	parent.componentsFrame.location.href = '../../eCA/jsp/EncSummGroupCompList.jsp?mode='+mode+'&groupFlag='+groupFlag+'&groupType='+groupType+'&groupCode='+groupCode+'&flag=0&loadFirst=Yes';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

async function openModifyComp(rowIndex)
{		
	var compFlag = "", compType = "", compCode = "", compDesc = "", compColumns = 0, compTempDef="", compTemplate=0, compColumnType="";
	var compFlagField = "", compTypeField = "", compCodeField = "", compDescField = "", compColumnsField = 0, compTempDefField="", compTemplateField=0, compColumnTypeField="";
	
	//var mode = document.encSummGroupSelCompForm.mode.value;
	var mode = "update";
	var groupFlag = document.encSummGroupSelCompForm.groupFlag.value;
	var groupType = document.encSummGroupSelCompForm.groupType.value;
	var groupCode = document.encSummGroupSelCompForm.groupCode.value;	 
	
	compFlagField = eval ("document.encSummGroupSelCompForm.comp_Flag"+rowIndex);				
	compFlag = compFlagField.value;
	
	compTypeField = eval ("document.encSummGroupSelCompForm.comp_type"+rowIndex);				
	compType = compTypeField.value;
	
	compCodeField = eval ("document.encSummGroupSelCompForm.comp_code"+rowIndex);				
	compCode = compCodeField.value;
	
	compDescField = eval ("document.encSummGroupSelCompForm.comp_desc"+rowIndex);				
	compDesc = compDescField.value;
	
	compColumnsField = eval ("document.encSummGroupSelCompForm.comp_columns"+rowIndex);				
	compColumns = compColumnsField.value;
	
	compTempDefField = eval ("document.encSummGroupSelCompForm.comp_def"+rowIndex);				
	compTempDef = compTempDefField.value;
	
	compTemplateField = eval ("document.encSummGroupSelCompForm.comp_template"+rowIndex);				
	compTemplate = compTemplateField.value;
	
	compColumnTypeField = eval ("document.encSummGroupSelCompForm.comp_col_type"+rowIndex);				
	compColumnType = compColumnTypeField.value;
	
	//alert(":::: "+compFlag+" :: "+compType+" :: "+compCode+" :: "+compDesc+" :: "+compColumns+" :: "+compTempDef+" :: "+compTemplate+" :: "+compColumnType);
	/*
	compFlag = document.getElementById('comp_Flag'+rowIndex).value;	
	compType = document.getElementById('comp_type'+rowIndex).value;
	compCode = document.getElementById('comp_code'+rowIndex).value;
	compDesc = document.getElementById('comp_desc'+rowIndex).value;
	compColumns = document.getElementById('comp_columns'+rowIndex).value;
	compTempDef = document.getElementById('comp_def'+rowIndex).value;
	compTemplate = document.getElementById('comp_template'+rowIndex).value;
	compColumnType = document.getElementById('comp_col_type'+rowIndex).value;
	*/
	var retVal = "";
	var dialogHeight = "25";
	var dialogWidth =	"45";
	var dialogTop = "150";
	var status	= "no";
	var arguments =	"" ;
	
	var action_url = "";
	var features = "";
	action_url 	= '../../eCA/jsp/EncSummGroupCompModCompMain.jsp';	
	features =	"dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url += "?mode="+mode+"&groupFlag="+groupFlag+"&groupType="+groupType+"&groupCode="+groupCode+"&compFlag="+compFlag+"&compType="+compType+"&compId="+compCode+"&compDesc="+compDesc+"&compColumns="+compColumns+"&compTempDef="+compTempDef+"&compTemplate="+compTemplate+"&compColumnType="+compColumnType;

	retVal = await window.showModalDialog(action_url,arguments,features);	
	//retVal = window.open(action_url,arguments,features);	
	
	parent.componentsFrame.location.href = '../../eCA/jsp/EncSummGroupCompList.jsp?mode='+mode+'&groupFlag='+groupFlag+'&groupType='+groupType+'&groupCode='+groupCode+'&flag=0&loadFirst=Yes';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}


/* --------------------- Functions called from EncSummGroupCompList.jsp ends here ---------------------*/

/* Functions called from EncSummGroupCompAddCompCriteria.jsp */
function loadComponents()
{	
	if(document.encSummGroupSearchCompForm!=null)
	{			
		var searchGroupType = document.encSummGroupSearchCompForm.es_comp_type.value;
		var searchText = document.encSummGroupSearchCompForm.searchText.value;
		
		var mode = document.encSummGroupSearchCompForm.mode.value;
		var groupFlag = document.encSummGroupSearchCompForm.groupFlag.value;
		var groupType = document.encSummGroupSearchCompForm.groupType.value;
		var groupCode = document.encSummGroupSearchCompForm.groupCode.value;
		var gFlag = document.encSummGroupSearchCompForm.gFlag.value;
		
		//alert(" - - - groupFlag: "+groupFlag+" - - - groupType: "+groupType+" - - - groupCode: "+groupCode+" - - - gFlag: "+gFlag+" - - - searchGroupType: "+searchGroupType+" - - - searchText: "+searchText);		
		//var pString = "?mode="+mode+"&groupFlag="+groupFlag+"&groupType="+groupType+"&groupCode="+groupCode+"&gType="+gType;
				
		parent.addCompFrame.location.href = '../../eCA/jsp/EncSummGroupCompAddCompList.jsp?mode='+mode+'&groupFlag='+groupFlag+'&groupType='+groupType+'&groupCode='+groupCode+'&gFlag='+gFlag+'&searchText='+encodeURIComponent(searchText)+'&searchGroupType='+searchGroupType+'&flag=1&loadFirst=Yes';			
	}		
	else
	{			
		return false;
	}	
}

function setSearchCompFlag(obj){	
	var fieldLabel = "";	
	document.encSummGroupSearchCompForm.gFlag.value=obj.value;
	
	if (obj.value == '0')
		fieldLabel = new Array (getLabel("Common.SubGroupType.label",'common'));
	else
		fieldLabel = new Array (getLabel("Common.ComponentType.label",'common'));	
	
	document.getElementById('compTypeList').innerHTML = fieldLabel;
}


function setSearchCompType(obj){	
	document.encSummGroupSearchCompForm.compType.value=obj.value;	
}

function resetValuesCompCrit(obj)
{	
	if (obj.name == 'es_comp_flag')
	{
		document.encSummGroupSearchCompForm.es_comp_type.value="";
		document.encSummGroupSearchCompForm.searchText.value="";		
	}
	if (obj.name == 'es_comp_type')
	{		
		document.encSummGroupSearchCompForm.searchText.value="";
	}	
	
	parent.addCompFrame.location.href = '../../eCommon/html/blank.html';
		
}

/* --------------------- Functions called from EncSummGroupCompAddCompCriteria.jsp ends here ---------------------*/

/* Functions called from EncSummGroupCompAddCompList.jsp */
function loadPrevNextRecs(varName)
{
	var start = document.addNewCompForm.from.value;
	var end = document.addNewCompForm.to.value;
	var searchGroupType = document.addNewCompForm.searchGroupType.value;
	var searchText = document.addNewCompForm.searchText.value;
	if(searchText == undefined) searchText = '';

	var mode = document.addNewCompForm.mode.value;
	var flag = document.addNewCompForm.flag.value;
	var groupFlag = document.addNewCompForm.groupFlag.value;
	var groupType = document.addNewCompForm.groupType.value;
	var groupCode = document.addNewCompForm.groupCode.value;
	var gFlag = document.addNewCompForm.gFlag.value;
	
	var totalCount = document.addNewCompForm.totalCount.value;
	var countForNext = document.addNewCompForm.countForNext.value;

	var tempRowIds = "";
	var tempString = "";
	var tempParseInt = 0;

	if(varName == 'prev')
	{
		start = parseInt(start,10) - 5;
		end = parseInt(end,10) - 5;
		tempParseInt = parseInt(countForNext,10)-1;
	}
	else if(varName == 'next')
	{
		start = parseInt(start,10) + 5;
		end = parseInt(end,10) + 5;
		tempParseInt = parseInt(countForNext,10)+1;
	}

	for(var t=parseInt(start,10);t<parseInt(end,10);t++)
	{
		tempString = parent.parent.rowIDCompForEncSumm[t];
		
		if(t < totalCount)
		{
			if(tempString.indexOf("+") != -1)
			{
				for(var x=0;x<tempString.length;x++)
				{
					tempString = tempString.replace("+","^");
				}
			}
			tempRowIds = "'"+tempString+ "'," + tempRowIds;
		}
	}
	
	parent.addCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddCompList.jsp?mode="+mode+"&groupFlag="+groupFlag+"&groupType="+groupType+"&groupCode="+groupCode+"&gFlag="+gFlag+"&flag="+flag+"&start="+start+"&end="+end+"&searchText="+encodeURIComponent(searchText)+"&searchGroupType="+searchGroupType+"&tempRowIds="+tempRowIds+"&flagTemp=temp&totalCount="+totalCount+"&countForNext="+tempParseInt;
}

function addComponents(obj,comp_flag, comp_type, comp_id, comp_desc, tempSeq)
{	
	//modAllComponent();
	
	
	var groupFlag = document.addNewCompForm.groupFlag.value;
	var groupType = document.addNewCompForm.groupType.value;
	var groupCode = document.addNewCompForm.groupCode.value;
	
	var numberOfRecs = "";
	if(parent.selectedCompFrame.document.addedCompForm != null)
	{
		numberOfRecs = parent.selectedCompFrame.document.addedCompForm.countOfRows.value;
	}
	var searchText = document.addNewCompForm.searchText.value;
	var searchGroupType = document.addNewCompForm.searchGroupType.value;

	var mode = document.addNewCompForm.mode.value;
	var flag = document.addNewCompForm.flag.value;
	var gFlag = document.addNewCompForm.gFlag.value;	

	var index = 0;
	var finalString = ""; // variables USed to Concatenate Code ,Text Field Values and Also Description
	var compFlag = "", compType = "", compCode = "", compDesc="", compTemplate="", compColCount= "", compSelected = ""; 
	var checkCode = "", checkCodeValue = "",  flagValue="", typeValue ="", codeValue = "";
	var addCompTemplate="", addCompColCount= "", addCompSelected = "";
	
	if(obj.checked == true)
	{
		/*
		for( index=1;index<=parseInt(numberOfRecs);index++)
		{		
			compFlag = eval("parent.selectedCompFrame.document.es_comp_flag"+index);
			compType = eval("parent.selectedCompFrame.document.es_comp_type"+index);
			compCode = eval("parent.selectedCompFrame.document.es_comp_code"+index);
			compDesc = eval("parent.selectedCompFrame.document.es_comp_desc"+index);
			compTemplate = eval("parent.selectedCompFrame.document.es_comp_template"+index);
			compColCount = eval("parent.selectedCompFrame.document.es_comp_colcount"+index);
			compSelected = eval("parent.selectedCompFrame.document.es_comp_select"+index);
			
			
			flagValue = compFlag.value;
			typeValue = compType.value;
			codeValue = compCode.value;
			
			if ((comp_flag == flagValue) && (comp_type == typeValue) && (comp_id == codeValue)){
				return false;
			}
			if(finalString == "")
			{				
				finalString =   flagValue + "||" + typeValue + "||" + codeValue + "||" + compDesc.value + "||" +compTemplate.value+ "||" + compColCount.value + "||" +compSelected.value;
			}
			else
			{
				finalString = finalString + "~"+flagValue + "||" + typeValue + "||" + codeValue + "||" + compDesc.value + "||" +compTemplate.value+ "||" + compColCount.value + "||" +compSelected.value;
			}				
		}
		finalString = finalString + "~" +comp_flag + "||" + comp_type + "||" + comp_id + "||" + comp_desc + "||" +addCompTemplate+ "||" + addCompColCount + "||" +addCompSelected;			
				
		parent.selectedCompFrame.document.addedCompForm.finalString.value = finalString;
		parent.selectedCompFrame.document.addedCompForm.mode.value = mode;
		parent.selectedCompFrame.document.addedCompForm.groupFlag.value = groupFlag;
		parent.selectedCompFrame.document.addedCompForm.groupType.value = groupType;
		parent.selectedCompFrame.document.addedCompForm.groupCode.value = groupCode;
		parent.selectedCompFrame.document.addedCompForm.submit();
		*/
		
		parent.removeCompFrame.document.write("<html><form name='remCompForm' id='remCompForm' action='../../eCA/jsp/EncSummGroupCompRemoveComp.jsp'>" +
				"<input type='hidden' name='groupFlag' id='groupFlag' value='"+groupFlag+"'>" +
				"<input type='hidden' name='groupType' id='groupType' value='"+groupType+"'>" +
				"<input type='hidden' name='groupCode' id='groupCode' value='"+groupCode+"'>" +				
				"<input type='hidden' name='comp_flag' id='comp_flag' value='"+comp_flag+"'>" +
				"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type+"'>" +
				"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_id+"'>" +
				"<input type='hidden' name='comp_desc' id='comp_desc' value='"+comp_desc+"'>" +
				"<input type='hidden' name='called_from' id='called_from' value='addComp'>" +
				"<input type='hidden' name='searchText' id='searchText' value='"+searchText+"'>" +
				"<input type='hidden' name='searchGroupType' id='searchGroupType' value='"+searchGroupType+"'>" +
				"<input type='hidden' name='mode' id='mode' value='"+mode+"'>" +
				"<input type='hidden' name='flag' id='flag' value='"+flag+"'>" +
				"<input type='hidden' name='gFlag' id='gFlag' value='"+gFlag+"'>" +
				"<input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeCompFrame.document.remCompForm.submit();
				
	}
	else
	{			
		//parent.removeCompFrame.location.href='../../eCommon/html/blank.html';
		parent.removeCompFrame.document.write("<html><form name='remCompForm' id='remCompForm' action='../../eCA/jsp/EncSummGroupCompRemoveComp.jsp'>" +
				"<input type='hidden' name='groupFlag' id='groupFlag' value='"+groupFlag+"'>" +
				"<input type='hidden' name='groupType' id='groupType' value='"+groupType+"'>" +
				"<input type='hidden' name='groupCode' id='groupCode' value='"+groupCode+"'>" +		
				"<input type='hidden' name='comp_flag' id='comp_flag' value='"+comp_flag+"'>" +
				"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type+"'>" +
				"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_id+"'>" +
				"<input type='hidden' name='comp_desc' id='comp_desc' value='"+comp_desc+"'>" +
				"<input type='hidden' name='called_from' id='called_from' value='removeComp'>" +
				"<input type='hidden' name='searchText' id='searchText' value='"+searchText+"'>" +
				"<input type='hidden' name='searchGroupType' id='searchGroupType' value='"+searchGroupType+"'>" +
				"<input type='hidden' name='mode' id='mode' value='"+mode+"'>" +
				"<input type='hidden' name='flag' id='flag' value='"+flag+"'>" +
				"<input type='hidden' name='gFlag' id='gFlag' value='"+gFlag+"'>" +
				"<input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeCompFrame.document.remCompForm.submit();
		//parent.removeCompFrame.location.href='../../eCommon/html/blank.html';		
	}
}

/* --------------------- Functions called from EncSummGroupCompAddCompList.jsp ends here ---------------------*/

/*  Functions called from EncSummGroupCompAddedCompList.jsp  */
function modComponent(obj, comp_flag, comp_type, comp_id, comp_desc, row_count)
{	
	var tempObjName = 'es_comp_template'+row_count;
	var colCountObjName = 'es_comp_colcount'+row_count;
	//var colDescObjName = 'es_comp_Column'+row_count;
	
	var mode = document.addedCompForm.mode.value;
	var groupFlag = document.addedCompForm.es_group_flag.value;
	var groupType = document.addedCompForm.es_group_type.value;
	var groupCode = document.addedCompForm.es_group_code.value;		
	var comp_temp = "";
	var comp_column_count = "";
	//var comp_column = "";
	var selected_flag = "0";
	
	comp_temp = document.getElementById(tempObjName).value;		
	comp_column_count = document.getElementById(colCountObjName).value;		
	//comp_column = document.getElementById(colDescObjName).value;
	
	if (obj.checked == true)
	{		
		if (comp_temp == ''){
			alert("Please select "+getLabel("eCA.TemplateType.label","CA"));
			obj.checked = false;
			return false;		
		}	
		if (comp_temp == '2'){
			if (comp_column_count == '')
			{
				alert("Please select "+getLabel("eCA.ColumnNumbers.label","CA"));
				obj.checked = false;
				return false;
			}
		}
		
		selected_flag = "checked";
	}
	else
		selected_flag = "0";
	
	var numberOfRecs = "";
	if(parent.selectedCompFrame.document.addedCompForm != null)
	{
		numberOfRecs = parent.selectedCompFrame.document.addedCompForm.countOfRows.value;
	}
		
	parent.removeCompFrame.document.write("<html><form name='remCompForm' id='remCompForm' action='../../eCA/jsp/EncSummGroupCompRemoveComp.jsp'>" +
			"<input type='hidden' name='mode' id='mode' value='"+mode+"'>" +
			"<input type='hidden' name='groupFlag' id='groupFlag' value='"+groupFlag+"'>" +
			"<input type='hidden' name='groupType' id='groupType' value='"+groupType+"'>" +
			"<input type='hidden' name='groupCode' id='groupCode' value='"+groupCode+"'>" +				
			"<input type='hidden' name='comp_flag' id='comp_flag' value='"+comp_flag+"'>" +
			"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type+"'>" +
			"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_id+"'>" +
			"<input type='hidden' name='comp_desc' id='comp_desc' value='"+comp_desc+"'>" +
			"<input type='hidden' name='comp_temp' id='comp_temp' value='"+comp_temp+"'>" +
			"<input type='hidden' name='comp_col_count' id='comp_col_count' value='"+comp_column_count+"'>" +
			//"<input type='hidden' name='comp_column' id='comp_column' value='"+comp_column+"'>" +
			"<input type='hidden' name='called_from' id='called_from' value='modComp'>" +
			"<input type='hidden' name='selected_flag' id='selected_flag' value='"+selected_flag+"'>" +
			"<input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
	parent.removeCompFrame.document.remCompForm.submit();
}

function modAllComponent()
{	
	var row_count = 0;
	var compFlagObjName = 'es_comp_flag';
	var compTypeObjName = 'es_comp_type';
	var compCodeObjName = 'es_comp_code';	
	var compDescObjName = 'es_comp_desc';	
	var tempObjName = 'es_comp_template';
	var colCountObjName = 'es_comp_colcount';
	//var colDescObjName = 'es_comp_Column';
	var selectedFlagObjName = 'es_comp_select';
	var formName = 'remCompForm';
	
	var compFlagObjName1 = "", compTypeObjName1 = "", compCodeObjName1 = "", compDescObjName1 = "", tempObjName1 = "", colCountObjName1 = "", selectedFlagObjName1 = "";
	var comp_flag = "", comp_type = "", comp_code = "", comp_desc = "";
	var mode = "", groupFlag = "", groupType = "", groupCode = "";
	
	var comp_temp = "";
	var comp_column_count = "";
	//var comp_column = "";
	var selected_flag = "0";
	var count = 0;	
	
	if(parent.selectedCompFrame.document.addedCompForm != null)
	{
		row_count = parent.selectedCompFrame.document.addedCompForm.countOfRows.value;		
		mode = parent.selectedCompFrame.document.addedCompForm.mode.value;		
		groupFlag = parent.selectedCompFrame.document.addedCompForm.es_group_flag.value;		
		groupType = parent.selectedCompFrame.document.addedCompForm.es_group_type.value;		
		groupCode = parent.selectedCompFrame.document.addedCompForm.es_group_code.value;		
	}
	while(count<row_count)
	{
		compFlagObjName1 = compFlagObjName + count;
		compTypeObjName1 = compTypeObjName + count;
		compCodeObjName1 = compCodeObjName + count;
		compDescObjName1 = compDescObjName + count;
		tempObjName1 = tempObjName + count;
		colCountObjName1 = colCountObjName + count;
		//colDescObjName = colDescObjName + count;
		selectedFlagObjName1 = selectedFlagObjName + count;
		
		comp_flag = parent.selectedCompFrame.document.getElementById(compFlagObjName1).value;		
		comp_type = parent.selectedCompFrame.document.getElementById(compTypeObjName1).value;
		comp_code = parent.selectedCompFrame.document.getElementById(compCodeObjName1).value;
		comp_desc = parent.selectedCompFrame.document.getElementById(compDescObjName1).value;
		comp_temp = parent.selectedCompFrame.document.getElementById(tempObjName1).value;
		comp_column_count = parent.selectedCompFrame.document.getElementById(colCountObjName1).value;
		selected_flag = parent.selectedCompFrame.document.getElementById(selectedFlagObjName1).value;
		//comp_column = document.getElementById(colDescObjName).value;
		
		
		alert(" - - - comp_flag: "+comp_flag+" - - - comp_type: "+comp_type+" - - - comp_code: "+comp_code+" - - - comp_desc: "+comp_desc+" - - - comp_temp: "+comp_temp+" - - - comp_column_count: "+comp_column_count+" - - - selected_flag: "+selected_flag);
		
		if (comp_temp == ''){
			alert("Please select "+getLabel("eCA.TemplateType.label","CA"));
			obj.checked = false;
			return false;		
		}	
		if (comp_temp == '2'){
			if (comp_column_count == '')
			{
				alert("Please select "+getLabel("eCA.ColumnNumbers.label","CA"));
				obj.checked = false;
				return false;
			}
		}
		
		selected_flag = "checked";
		
		//parent.removeCompFrame.location.href='../../eCommon/html/blank.html';
		parent.removeCompFrame.document.write("<html><form name='remCompForm' id='remCompForm' action='../../eCA/jsp/EncSummGroupCompRemoveComp.jsp'>" +
				"<input type='hidden' name='mode' id='mode' value='"+mode+"'>" +
				"<input type='hidden' name='groupFlag' id='groupFlag' value='"+groupFlag+"'>" +
				"<input type='hidden' name='groupType' id='groupType' value='"+groupType+"'>" +
				"<input type='hidden' name='groupCode' id='groupCode' value='"+groupCode+"'>" +				
				"<input type='hidden' name='comp_flag' id='comp_flag' value='"+comp_flag+"'>" +
				"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type+"'>" +
				"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_code+"'>" +
				"<input type='hidden' name='comp_desc' id='comp_desc' value='"+comp_desc+"'>" +
				"<input type='hidden' name='comp_temp' id='comp_temp' value='"+comp_temp+"'>" +
				"<input type='hidden' name='comp_col_count' id='comp_col_count' value='"+comp_column_count+"'>" +
				//"<input type='hidden' name='comp_column' id='comp_column' value='"+comp_column+"'>" +
				"<input type='hidden' name='called_from' id='called_from' value='modCompAll'>" +
				"<input type='hidden' name='selected_flag' id='selected_flag' value='"+selected_flag+"'>" +
				"<input type='hidden' name='noOfRows' id='noOfRows' value='"+count+"'></form></html>");
		parent.removeCompFrame.document.forms[0].submit();
		parent.removeCompFrame.document.write("");
		//parent.removeCompFrame.location.href='../../eCommon/html/blank.html';
		
		count++;		
	}		
}

/* --------------------- Functions called from EncSummGroupCompAddedCompList.jsp ends here ---------------------*/

/*  Functions called from EncSummGroupCompModComp.jsp  */
function changeTemplate(obj)
{
	var tempValue = obj;

	if (tempValue > 0){
		if (tempValue == '2'){
			document.getElementById('lineGraphDiv').style.display = "none";
			document.getElementById('tableDiv').style.display = "block";
		}
		else if (tempValue == '4'){			
			document.getElementById('tableDiv').style.display = "none";
			document.getElementById('lineGraphDiv').style.display = "block";
		}
		else
		{
			document.getElementById('tableDiv').style.display = "none";
			document.getElementById('lineGraphDiv').style.display = "none";
		}
	}
}

function returnCompDef(compTemp, compColCount, compDef, compTypeDef)
{
	var count = 0;
	var colCount = 1;
	var colValue = "";
	var colName = "ColumnName";
	var closeColName = "/ColumnName";
	var colIndex = 0;
	var closeColIndex = 0;

	var xAxislabel = "xAxisLabel=@";
	var xDataType = "xDataType=@";
	var yAxislabel = "yAxisLabel=@";
	var yDataType = "yDataType=@";
	
	var colType = "ColumnType";
	var closeColType = "/ColumnType";
	
	var colTypeIndex = 0;
	var closeColTypeIndex = 0;
	
	var colTypeValue = "";
	
	var columnField = "", colTypeField = "";
	
	
	if (compTemp == '2')
	{
		if (compColCount > 0)
		{
			while (count<compColCount)
			{
				
					colName = colName + colCount;
					closeColName = closeColName + colCount;					
					if (compDef.length>0)
					{
						colIndex = compDef.indexOf(colName);
						closeColIndex = compDef.indexOf(closeColName);		
						if (colIndex>0 && closeColIndex>0){
							colValue = compDef.substring(colIndex+12,closeColIndex-1 );	
							columnField = eval("document.encSummCompModForm.column"+count);
							columnField.value = colValue;
							//document.getElementById('column'+count).value = colValue;
						}
						else
						{
							columnField = eval("document.encSummCompModForm.column"+count);
							columnField.value = "";
							//document.getElementById('column'+count).value = "";
						}
					}
					else
					{
						columnField = eval("document.encSummCompModForm.column"+count);
						columnField.value = "";
						//document.getElementById('column'+count).value = "";
					}
					
					/*
					 * 
					 */
					
					colType = colType + colCount;
					closeColType = closeColType + colCount;					
					if (compTypeDef.length>0)
					{
						colTypeIndex = compTypeDef.indexOf(colType);
						closeColTypeIndex = compTypeDef.indexOf(closeColType);		
						if (colTypeIndex>0 && closeColTypeIndex>0){
							colTypeValue = compTypeDef.substring(colTypeIndex+12,closeColTypeIndex-1 );	
							colTypeField = eval("document.encSummCompModForm.columnType"+count);
							colTypeField.value = colTypeValue;
							//document.getElementById('columnType'+count).value = colTypeValue;
						}
						else
						{
							colTypeField = eval("document.encSummCompModForm.columnType"+count);
							colTypeField.value = "";
							//document.getElementById('columnType'+count).value = "";
						}
					}
					else
					{
						colTypeField = eval("document.encSummCompModForm.columnType"+count);
						colTypeField.value = "";
						//document.getElementById('columnType'+count).value = "";
					}
					/*
					 * 
					 */
					count++;
					colCount++;
					colName = "ColumnName";
					closeColName = "/ColumnName";
					
					colType = "ColumnType";
					closeColType = "/ColumnType";
				
			}
		}
	}
	else if (compTemp == '4')
	{
		colIndex = compDef.indexOf(xAxislabel);
		closeColIndex = compDef.indexOf('@',colIndex+12 );		
		if (colIndex>0 && closeColIndex>0){
			colValue = compDef.substring(colIndex+12,closeColIndex );				
			document.getElementById('es_xaxis_label').value = colValue;
		}
		colIndex = 0;
		closeColIndex = 0;	
		colIndex = compDef.indexOf(yAxislabel);
		closeColIndex = compDef.indexOf('@',colIndex+12 );		
		if (colIndex>0 && closeColIndex>0){
			colValue = compDef.substring(colIndex+12,closeColIndex );				
			document.getElementById('es_yaxis_label').value = colValue;
		}
		colIndex = 0;
		closeColIndex = 0;	
		colIndex = compDef.indexOf(xDataType);
		closeColIndex = compDef.indexOf('@',colIndex+11 );		
		if (colIndex>0 && closeColIndex>0){
			colValue = compDef.substring(colIndex+11,closeColIndex );				
			document.getElementById('es_xaxis_datatype').value = colValue;
		}
		
		colIndex = 0;
		closeColIndex = 0;	
		colIndex = compDef.indexOf(yDataType);
		closeColIndex = compDef.indexOf('@',colIndex+11 );		
		if (colIndex>0 && closeColIndex>0){
			colValue = compDef.substring(colIndex+11,closeColIndex );				
			document.getElementById('es_yaxis_datatype').value = colValue;
		}
	}
}

function scrollTitleTop()
{
	
	var x = document.body.scrollTop;
	var tr = document.getElementById("trcoll");
	var positionTop = 2;
	if(x == 2)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 15);
			tr[i].style.posTop = positionTop;			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x - 5;			
		}
	}
	
}
/* Common functions called from */

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode;
	if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
		return false;
	
	return true;
}

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

