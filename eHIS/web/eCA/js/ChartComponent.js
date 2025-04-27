/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
26/06/2013    	IN039171		Dinesh	 System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
16/09/2013    	IN039171_reopen		vijayakumark	 System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
17/05/2018      IN066995        Ramyamaddena     
---------------------------------------------------------------------------------------------------------------
*/


var a = new Array();
			var i = 0;
			var ii = 1;//referred to in the next frame..
			var value, element;
			
			
			
function apply(){

   // alert('Framename'+chartComponentHeaderFrame.name); 
	//alert(chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value);
	if(chartComponentHeaderFrame.document.ChartComponentHeaderForm!=null)
	{
	if(chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value=="")
		{
		var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
		chartComponentListFrame.document.location.href = '../../eCommon/html/blank.html';
		messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
		}
		else
	{
	var indexI = parseInt(chartComponentListFrame.document.ChartComponentListForm.sequence.value)
	var indexJ	=parseInt(chartComponentListFrame.document.ChartComponentListForm.sequenceGrp.value)
	var indexRow=0
	var indexCol = 0;		
	
	for(indexRow = 0;indexRow < indexJ ;indexRow++){
		var noOfRows = eval("chartComponentListFrame.document.ChartComponentListForm.noOfRows"+indexRow);
		for(indexCol = 0;indexCol < parseInt(noOfRows.value);indexCol++){
			var objText = eval("chartComponentListFrame.document.ChartComponentListForm.summary_column"+indexRow+""+indexCol);

			var objSelect = eval("chartComponentListFrame.document.ChartComponentListForm.summaryType"+indexRow+""+indexCol);
			var objButton = eval("chartComponentListFrame.document.ChartComponentListForm.btnSumm"+indexRow+""+indexCol);
			var objSummYN = eval("chartComponentListFrame.document.ChartComponentListForm.sum_yn"+indexRow+""+indexCol);
			var flagSumm = checkForSummary(objText,objSelect,objButton,objSummYN);
			if(flagSumm==false){
				return false;
			}
		}//end of for-2
	}//end of for-1

	chartComponentListFrame.document.ChartComponentListForm.action='../../servlet/eCA.ChartComponentServlet';
	chartComponentListFrame.document.ChartComponentListForm.target='messageFrame';
	chartComponentListFrame.document.ChartComponentListForm.method='post';
	chartComponentListFrame.document.ChartComponentListForm.submit();
	}
	}
	else { messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'; 
	return false; 
	}
}

function checkForSummary(objText,objSelect,objButton,objSummYN)
{
	if(objSummYN.checked == true && objSummYN.value == "Y"){
		if(objText.value==''){
			alert(getMessage("SUMMARY_COLUMN_NOT_BLANK","CA"));
			objText.readOnly = false;
			objText.focus();
			frames[0].location.reload();
			return false
		}
		else if(objSelect.value=='X'){
			alert(getMessage("SUMMARY_TYPE_NOT_BLANK","CA"));
			objSelect.disabled = false;
			objSelect.focus();
			frames[0].location.reload();
			return false
		}
	}
	else{
		return true
	}
}


function resetValues()
{
	parent.chartComponentListFrame.location.href = '../../eCA/jsp/blank.jsp';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';	
}

function create(){
	chartComponentHeaderFrame.document.location.href='../../eCA/jsp/ChartComponentHeader.jsp';
	chartComponentListFrame.location.href = '../../eCA/jsp/blank.jsp';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

function reset(){
	create();
}

function onSuccess(){
	chartComponentHeaderFrame.location.href = '../../eCA/jsp/ChartComponentHeader.jsp';
	chartComponentListFrame.location.href = '../../eCA/jsp/blank.jsp';
}

/****************************************************************************/

async function getChart(){
	var target = document.ChartComponentHeaderForm.chartDesc;
	var retVal = new String();
	var dialogTop = "40";
	var dialogHeight = "30";
	var dialogWidth = "40";
	var features = "dialogTop:"+dialogTop+"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";status=no;";
	var arguments = "";
	var search_code = "";
	var search_desc = "";
	var title = getLabel("Common.Chart.label","COMMON");
	var sql = ' select chart_id, short_desc from ca_chart where eff_status = `E`';
	search_code = 'chart_id';
	search_desc = 'short_desc';
	var chart = document.ChartComponentHeaderForm.chartDesc.value;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&chart="+chart+ "&search_code="+search_code+"&title="+encodeURIComponent(title,"UTF-8")+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst",arguments,features);
	var ch_arr = new Array();
	if(retVal!=null && retVal!=''){
		var retVal = unescape(retVal);
		//ch_arr = retVal.split("::");
		ch_arr = retVal.split(",");
		document.ChartComponentHeaderForm.chartDesc.value = ch_arr[0];
		document.ChartComponentHeaderForm.chartCompSearch.value = ch_arr[1];		
	}
}

function dispDesc()
{
	
	if(document.ChartComponentHeaderForm.chartCompSearch.value!=""){
		var searchChId = document.ChartComponentHeaderForm.chartCompSearch.value;

		parent.chartComponentListFrame.document.location.href = '../../eCA/jsp/ChartComponentList.jsp?chartCompSearch='+searchChId;
		parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
	else{
		var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
		parent.chartComponentListFrame.document.location.href = '../../eCommon/html/blank.html';
		parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}
}

/*****************************Formula Part***************************************/

var HTMLtext, remVal, j;

function loadDefault(){
	parent.chartSectionFormulaConstructionFrame.location.href ='../../eCA/jsp/ChartComponentFormulaConstruction.jsp?temp=Y';
}

async function formulaDefn(panel_desc_id){
	var formDefn = parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value;

	var retVal = "";
	var dialogHeight = "80vh";
	var dialogWidth =	"75vw";
	var dialogTop = "10";
	var status = "no";
	var arguments ="";
	var action_url = '../../eCA/jsp/ChartComponentFormulaMain.jsp';
	var features =	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url += "?formDefn="+formDefn+'&panel_desc_id='+panel_desc_id;
	retVal = await top.window.showModalDialog(action_url,arguments,features);
}

function onOperation(val){
	if(val=='.'){
		var value = document.getElementById("intVal").value;
		var spl = value.split('.');
		var nums = value.length;
		if(nums > 1){
			return false;
		}	
	}
	document.chartSectionComponentFormulaConstructionForm.finVal.insertAdjacentText("beforeend",val);	
}

function radioCheck(obj){
	if(obj.disabled){
		obj.checked = false;
	}
	else{
		obj.checked = true;
	}
}

function onReset(){
    retVal=confirm(getMessage("DELETE_FORMULA_YN","CA"));
	if (retVal==true){
		parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i = 0;
		parent.chartSectionFormulaConstructionFrame.location.href='../../eCA/jsp/ChartComponentFormulaConstruction.jsp';
	}else{
		return false;
	}
}

function onClickOfPID(panel_id){
	panel_id = "$$$"+panel_id+"###";
	parent.chartSectionFormulaConstructionFrame.newTextVal(panel_id);
}

function displayValues(){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	if (parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i !=0){
		document.getElementById("rese").disabled			= false;
		document.getElementById("remov").disabled			= false;
		document.getElementById("replaceOpt").disabled	= false;
		document.getElementById("replaceRigOpt").disabled = false;
		document.getElementById("replaceRigOpt").checked  = true;
		document.getElementById("replaceLefOpt").disabled = false;
		document.getElementById("validat").disabled		= false;
	}
	HTMLtext='';	
	
	for(j=1;j<=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;j++){
		var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[j];
		var spli=arrVal.split('|');
		var val=spli[1];
		if (val.indexOf('$')!= -1){
			val=val.replace('$$$','');
			vv=val.split('!');
			val=vv[0];
		}
		HTMLtext=HTMLtext+" <input type=text id=text"+j+" name="+parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[j]+" id="+parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[j]+" value="+val + " onClick='selectValue(this);' onBlur='catchValue(this);' readonly size="+val.length+">";
	}
	
	document.getElementById("f").insertAdjacentHTML("BeforeEnd",HTMLtext);	
	var o=eval(document.getElementById("text"+parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii));
	if(!o){
		var o=eval(document.getElementById("text"+parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i));
	}
	if(o){
		o.select();
		o.style.background = 'yellow' ; 
		o.style.color = 'black' ;      
	}
	else return false;
}

function catchValue(obj){
	remVal=obj.name;
	rem=obj.id;
	objplace=obj;
	obj.style.background = 'yellow' ;  
	obj.style.color = 'black' ;      
}

function selectValue(obj){
	/*var a=eval('document.all.'+rem+'.style.background="white"'); 
	var a=eval('document.all.'+rem+'.style.color="black"');  */
	var a=eval('document.getElementById('+obj.id+').style.background="white"'); 
	var a=eval('document.getElementById('+obj.id+').style.color="black"');   
	obj.style.background="yellow"; 
	obj.style.color="black";      
}

function onOperation(intvalue){ 
	if (intvalue == '.'){
		var value=document.getElementById("intVal").value;
		var split=value.split('.');
		var nos=split.length;
		if (nos>1){ return false; }
	}	
	/*
	document.getElementsByName('finVal').insertAdjacentText("beforeend",intvalue);
	*/
	
	let elements = document.getElementsByName('finVal');

	if (elements.length > 0) {	     
	    elements[0].innerText += intvalue;  // Append the value
	    elements[0].value += intvalue;	   
	}					
}

function isOperator(val){
	if(val=='+' || val=='-' || val=='/' || val=='*' || val=='(' || val==')')
		return true;
	return false;
}

function callOnOk(){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	
	document.forms[0].formulaDefinition.value='';
	var flag=false;
	for(k=1;k<=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;k++)
	{
		var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k];
		var spli=arrVal.split('|');
		var val=spli[1];
		if(!isOperator(val))
		{			
			if(flag)
			{   alert(getMessage("EXP_INVALID","CA"));
				
				return;
			}
			flag=true;
		}
		else
		{
			flag=false;
		}
		document.forms[0].formulaDefinition.value=document.forms[0].formulaDefinition.value+val+"~";
	}
	var panel_desc_id = parent.chartSectionComponentListFrame.document.forms[0].panel_desc_id.value;
	
	var formulaDefinition = document.forms[0].formulaDefinition.value;
	document.forms[0].defContent.value = document.forms[0].formulaDefinition.value;
	var calledFrom = document.forms[0].calledFrom.value = 'OK';
	//parent.blankframeformula.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='formulaDefinition' id='formulaDefinition' value = \""+formulaDefinition+"\"><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+panel_desc_id+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"></form></body></html>");
	var HtmlVal="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='formulaDefinition' id='formulaDefinition' value = \""+formulaDefinition+"\"><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+panel_desc_id+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"></form></body></html>";
	parent.blankframeformula.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
	//parent.blankframeformula.document.write(HtmlVal);
	parent.blankframeformula.document.tempformformula.submit();
}

function callOnValidate(){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	
	document.forms[0].formulaDefinition.value='';
	var flag=false;
	var arrVal="";
	var spli="";
	var val="";
	for(k=1;k<=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;k++)
	{
		arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k];
		spli=arrVal.split('|');
		val=spli[1];
		if(!isOperator(val))
		{
			if(flag)
			{
				alert(getMessage("EXP_INVALID","CA"));
				return;
			}
			flag=true;
		}
		else
		{
			flag=false;
		}
		val=val+" ";
		document.forms[0].formulaDefinition.value=document.forms[0].formulaDefinition.value+val;
	}
	document.forms[0].defContent.value = document.forms[0].formulaDefinition.value;
	var formulaDefinition = document.forms[0].formulaDefinition.value;
	var calledFrom = document.forms[0].calledFrom.value = 'VALIDATE';
	//parent.blankframeformula.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='formulaDefinition' id='formulaDefinition' value = \""+formulaDefinition+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"></form></body></html>");
	var HtmlVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='formulaDefinition' id='formulaDefinition' value = \""+formulaDefinition+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"></form></body></html>"
	parent.blankframeformula.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
	parent.blankframeformula.document.forms[0].submit();
}

function clearVal(){
	document.forms[0].finVal.value='';
}

function newTextInt(obj){
	/*var i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	var a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	var ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	if(obj.value == null || obj.value==''){
		var msg = getMessage("CA_SEC_FORMULA_VAL","CA");
		alert(msg);
		return false;
	}
	if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
		alert(getMessage("SELECT_ANY_VALUE","CA"));
	}
	else
	{
		if(document.getElementById("replaceOpt").checked)
		{
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			var value=index+"|"+obj.value;
			/*a[index]=value;
			ii=index;*/
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=value;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}
		else if(document.getElementById("replaceRigOpt").checked)
		{
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			//i=i+1;
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			index=parseInt(index)+1;
			var insVal=index+"|"+obj.value;
			for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--){
				var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				//a[k]=value; 
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
			}
			/*a[index]=insVal;
			ii=index;*/ 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}
		else if(document.getElementById("replaceLefOpt").checked){
			//i=i+1;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			var spli=remVal.split('|');
			var index=spli[0];
			var val=spli[1];
			var insVal=index+"|"+obj.value;
			for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--)
			{
				var arrVal=a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				//a[k]=value; 
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
			}
			/*a[index]=insVal;
			ii=index;*/ 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}
		else{
			//i=i+1;
			//var value=i+"|"+obj.value;
			//a[i]=value;
			//ii=i; 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			var value=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+"|"+obj.value;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i]=value;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i; 
		}
		loadDefault();
	}
}

function newTextOpe(obj){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
		alert(getMessage("SELECT_ANY_VALUE","CA"));
	}else{
		if(document.getElementById("replaceOpt").checked){
			var spli=remVal.split('|');
			var index=spli[0];
			var opeval=spli[1];
			var value=index+"|"+obj.name;
			objplace.name=value;
//			a[index]=value;
//			ii=index; 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=value;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}else if(document.getElementById("replaceRigOpt").checked){
				//i=i+1;
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.name;
				for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					//a[k]=value; 
					parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
				}
//				a[index]=insVal;
//				ii=index; 
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
			}else if(document.getElementById("replaceLefOpt").checked){
					//i=i+1;
					parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
					var spli=remVal.split('|');
					var index=spli[0];
					var opeval=spli[1];
					var insVal=index+"|"+obj.name;
					for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--){
						var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k-1];
						var spl=arrVal.split('|');
						var val=spl[1];
						var value=(k)+'|'+val;
						//a[k]=value; 
						parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
					}
					//a[index]=insVal;
					//ii=index; 
					parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
					parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
				}else{
						//i=i+1;
						parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=i+1;
						var insVa=i+"|"+obj.name;
						/*a[i]=insVa;
						ii=i; */
						parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i]=insVa;
						parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i; 
					}
					loadDefault();
	}
}

function newTextVal(obj2){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	
	if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
		alert(getMessage("SELECT_ANY_VALUE","CA"));
	}else{
		if(document.getElementById("replaceOpt").checked){
			var spli=remVal.split('|');
			var index=spli[0];
			var opeval=spli[1];
			var value=index+"|"+obj2;
//			a[index]=value;
//			ii=index;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=value;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}else if(document.getElementById("replaceRigOpt").checked){
			/*i=i+1;*/
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			var spli=remVal.split('|');
			var index=spli[0];
			var opeval=spli[1];
			index=parseInt(index)+1;
			var insVal=index+"|"+obj2;
			for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--){
				var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				//a[k]=value; 
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
			}
			//a[index]=insVal;
			//ii=index; 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}else if(document.getElementById("replaceLefOpt").checked){
			//i=i+1;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			var spli=remVal.split('|');
			var index=spli[0];
			var opeval=spli[1];
			var insVal=index+"|"+obj2;
			for(k=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;index<k;k--){
				var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				//a[k]=value; 
				parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
			}
//			a[index]=insVal;
//			ii=index; 
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[index]=insVal;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=index; 
		}else{
			//i=i+1;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i+1;
			obj2=i+"|"+obj2;
			/*a[i]=obj2;
			ii=i; */
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[i]=obj2;
			parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii=i; 
		}
		loadDefault();
	}
}

function removeValue(){
	/*i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;
	a=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a;
	ii=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.ii;*/
	if(!remVal){
		//i=i-1;
		parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i-1;
	}else{
		var spli=remVal.split('|');
		var index=spli[0];
		var ope=spli[1];
		for(j=1;j<=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;j++){
			if (index==j){
				for(k=j;k<parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i;k++){
					var arrVal=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k+1];
					var spli=arrVal.split('|');
					var val=spli[1];
					var value=k+'|'+val;
					//a[k]=value; 
					parent.document.getElementById('chartSectionComponentListFrame').contentWindow.a[k]=value;
				}
				break;
			}
		}		
		//i=i-1;
		parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i=parent.document.getElementById('chartSectionComponentListFrame').contentWindow.i-1;
	}
	loadDefault();
}

function callClose(){	
		//window.close(); 
		
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
}

/****************************Summary part************************************/


async function summaryDefn(panel_desc_id,objText,objHidden){
	var target = objText;
	var retVal = new String();
	var dialogTop = "40";
	var dialogHeight = "30";
	var dialogWidth = "40";
	var features = "dialogTop:"+dialogTop+"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";status=no";
	var arguments = "";
	var search_code = "";
	var search_desc = "";
	var title = getLabel("eCA.DiscreteMeasureSearch.label","CA");

	var sql = ' select discr_msr_id, short_desc from am_discr_msr where eff_status = `E` and result_type=`S`';

	search_code = 'discr_msr_id';
	search_desc = 'short_desc';

	var chart = objText.value
	//alert('--'+chart);
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&chart="+chart+ "&search_code="+search_code+"&title="+encodeURIComponent(title,"UTF-8")+"&search_desc="+search_desc+"&dispDescFirst=dispDescFirst",arguments,features);
	var ch_arr = new Array();
	
	if(retVal!=null && retVal!=''){
		
		var retVal = unescape(retVal);
		ch_arr = retVal.split("::"); 
		objHidden.value = ch_arr[1];
		objText.value = ch_arr[0];
		//objText.focus();
	}

}

function onBlursummaryDefn(panel_desc_id,objText,objHidden)
{
	if(objText.value!=null && objText.value!="")
		summaryDefn(panel_desc_id,objText,objHidden)	

}


/**********************************Add New**************************************/
async function addNewRowForComponents(chart_id,panel_id,rowNumber,componentText)
{
	var rowNumbers =0;
	var indexNo = parseInt(rowNumber);
	var index=0;
	var dialogHeight = "30";
	var dialogWidth =	"40";
	var dialogTop = "150";
	var status = "no";
	var arguments ="";
	var htmlVal="";
	var flag=0;
	var retVal = "";
	var action_url = '../../eCA/jsp/ChartComponentFormulaForSummaryMain.jsp';
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url += "?chart_id="+chart_id+"&panel_id="+panel_id+"&searchText="+componentText;
	retVal = await window.showModalDialog(action_url,arguments,features);
	if(retVal != undefined)
	{
		var dataArray = retVal.split("||")
		var noofrow= eval("document.ChartComponentListForm.noOfRows"+parseInt(rowNumber))
		for(index = 0;index < parseInt(noofrow.value);index++)
		{
			tr= eval(document.getElementById("trRowId"+parseInt(rowNumber)+index));
			if(tr.cells[1].innerText == dataArray[1])
			{
				flag = 1;
				alert(getMessage("CHART_COMPONENT_EXISTS","CA"));
				addNewRow(chart_id,panel_id,rowNumber)
				return false;
			}

		}	
		if(flag == 0)
		{
			for(index = 0;index < parseInt(noofrow.value);index++)
			{
				tr= eval(document.getElementById("trRowId"+parseInt(rowNumber)+index));

				if(parseInt(tr.cells[0].innerText) == parseInt(dataArray[0]))	
				{
					flag = 1;
					alert(getMessage("DUPLICATE_SEQUENCE_NUMBER","CA"));
					addNewRowForComponents(chart_id,panel_id,rowNumber,dataArray[2])
					return false	
				}			
			}
		}	
		parent.blankFrame.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempForm' id='tempForm' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='retVal' id='retVal' value = '"+retVal+"'><input type='hidden' name='calledFrom' id='calledFrom' value = 'addRow'><input type='hidden' name='chart_id' id='chart_id' value = '"+chart_id+"'></form></body></html>");
		parent.blankFrame.document.tempForm.submit();

		var summary_req_yn = parent.chartComponentListFrame.document.ChartComponentListForm.sum_req.value;
		var change_at_trans = parent.chartComponentListFrame.document.ChartComponentListForm.change_trans.value;

		var disableSummReq = '';
		if(summary_req_yn == 'N'){
			disableSummReq = ' disabled ';
		}
		else{
			disableSummReq = '';
		}
		
		var disableDefault = '';
		var checkDefault = '';
		if(change_at_trans == 'N'){
			checkDefault = ' checked ';
			disableDefault = ' disabled ';
		}
		else{
			//checkDefault = '';
			disableDefault = '';
		}

		var summary ="";
		var argSummary = chart_id+":"+panel_id+":"+dataArray[1];
		var panel_desc_id = argSummary;
		var insertValue
		var noOfRows = eval("document.ChartComponentListForm.noOfRows"+parseInt(rowNumber));
		var rowValue = parseInt(noOfRows.value);
		var select_yn = "<input type='checkbox' name='select_yn"+rowValue+"' id='select_yn"+rowValue+"' value='Y' checked OnCLick='removeRow("+rowNumber+","+noOfRows.value+",this)'>"

		var mandatory_yn =""
		var element_type = "";
		//var	enable_ele_type =     parent.chartComponentListFrame.document.ChartComponentListForm.all.enable_ele_type.value;
		var	enable_ele_type = parent.chartComponentListFrame.document.getElementById('enable_ele_type').value;
			

		var default_yn = "<input type='checkbox' name='default_yn"+rowNumber+noOfRows.value+"' id='default_yn"+rowNumber+noOfRows.value+"' '"+disableDefault+"' '"+checkDefault+"' onclick='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
		var sum_yn = "<input type='checkbox' name='sum_yn"+rowNumber+noOfRows.value+"' id='sum_yn"+rowNumber+noOfRows.value+"' value='N' '"+disableSummReq+"' onclick='enableSumm("+rowNumber+","+noOfRows.value+",this)'>"
		var result_type = dataArray[3];
		if(result_type=="A")
		{
			htmlVal="<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' title='click here to open formula definition window'>Defn.</a><input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+dataArray[3]+"'>"
			mandatory_yn= "<input type='checkbox' style='display:none' name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"' value='N'  onclick='chkAndDisableDef(this,document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")'>"
		}
		else
		{
			htmlVal = "<input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+dataArray[3]+"'>";
			mandatory_yn= "<input type='checkbox'  name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"' value='N'  onclick='chkAndDisableDef(this,document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")'>"
		}
			//element_type = "<SELECT name='elementType"+rowNumber+noOfRows.value+"' id='elementType"+rowNumber+noOfRows.value+"' "+enable_ele_type+" onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option>"+document.forms[0].all.element_types.value+"</SELECT></td>";
			element_type = "<SELECT name='elementType"+rowNumber+noOfRows.value+"' id='elementType"+rowNumber+noOfRows.value+"' "+enable_ele_type+" onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option>"+parent.chartComponentListFrame.document.getElementById('element_types').value+"</SELECT></td>";		
		
	
		var summaryType="<select name='summaryType"+rowNumber+noOfRows.value+"' id='summaryType"+rowNumber+noOfRows.value+"' disabled onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");checkDiscrValue(document.forms[0].summary_column"+rowNumber+noOfRows.value+",this)'><option value='X'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option><option value='SUM'>"+getLabel("eCA.SUM.label","CA")+"</option><option value='AVERAGE'>"+getLabel("eCA.AVG.label","CA")+"</option><option value='MAXIMUM'>"+getLabel("Common.Max.label","Common")+"</option><option value='MINIMUM'>"+getLabel("Common.MIN.label","Common")+"</option></SELECT>"
		summary="<input type='text' name='summary_column"+rowNumber+noOfRows.value+"' id='summary_column"+rowNumber+noOfRows.value+"' SIZE='10' value='' readOnly OnChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' OnBlur='getDiscrId(this,"+rowNumber+","+noOfRows.value+");chkDupSummValues(this,"+rowNumber+","+noOfRows.value+")'><input type ='hidden' name='summaryColumnCode"+rowNumber+noOfRows.value+"' id='summaryColumnCode"+rowNumber+noOfRows.value+"'><input type='button' class='button' name='btnSumm"+rowNumber+noOfRows.value+"' id='btnSumm"+rowNumber+noOfRows.value+"' value='?' disabled onclick='summaryDefn(\""+argSummary+"\",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")'>";
		
		if(indexNo > 0)
		{
			while (indexNo >= 0)
			{
				var row = eval("document.ChartComponentListForm.noOfRows"+indexNo);
				rowNumbers = rowNumbers + parseInt(row.value) + 1
				indexNo--;
			}
		}
		else
		{
			rowNumbers = parseInt(noOfRows.value)+1
		}
		var data = eval("document.forms[0].displaySeqNumber"+rowNumber+".value") + " <input type='hidden' name='panel_desc_msr_id"+rowNumber+noOfRows.value+"' id='panel_desc_msr_id"+rowNumber+noOfRows.value+"' value='"+argSummary+"'> ";
		var insertValue = (rowNumbers + 1);
		var classValue =	""
		var noOfRowsValue = eval("document.ChartComponentListForm.noOfRows"+rowNumber)
		if(parseInt(noOfRowsValue.value) == 0){
					classValue =	"gridData"
			}	
			else
			{
				var trTextRow = eval(document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value-1)));
				classValue=  trTextRow.cells[0].className
				if(classValue ==	"gridData")
						classValue =	"gridData";				
				else
						classValue =	"gridData";
			}
	
		var rowvar = document.getElementById("tabList").insertRow(insertValue);
		rowvar.id = "trRowId"+rowNumber+noOfRows.value;
		var cellvar = rowvar.insertCell();
		cellvar.className=	"gridNumericData";
		cellvar.insertAdjacentHTML("BeforeEnd",dataArray[0]);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",dataArray[1]);	
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",dataArray[2]);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",sum_yn);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",summary);
		cellvar = rowvar.insertCell();	
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",summaryType);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",select_yn);
		cellvar = rowvar.insertCell();
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",mandatory_yn);
		cellvar = rowvar.insertCell();		
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",element_type);
		cellvar = rowvar.insertCell();		
		cellvar.className=	classValue
		cellvar.insertAdjacentHTML("BeforeEnd",default_yn);
		var trTextRow1 = eval(document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value-1)));
		var data1 =eval("document.forms[0].displaySeqNumber"+rowNumber+".value")
		var intermediateVar =parseInt(rowNumber)+""+ parseInt(noOfRows.value - 1)
		var rowsValue=eval("document.ChartComponentListForm.rowValue"+intermediateVar) ;
		var dummyVariable = rowNumber;
		var rowName = "rowValue"+parseInt(rowNumber)+(parseInt(noOfRows.value));
		htmlVal =data + "<input type='hidden' name='"+rowName+"' id='"+rowName+"' value='"+dummyVariable+"'>"
		cellvar = rowvar.insertCell();
		cellvar.style.display='none'
		cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
		
		clickOKSecond(argSummary,eval("document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value),eval("document.forms[0].summaryType"+rowNumber+noOfRows.value),eval("document.forms[0].summary_column"+rowNumber+noOfRows.value),eval("document.forms[0].default_yn"+rowNumber+noOfRows.value),eval("document.forms[0].sum_yn"+rowNumber+noOfRows.value),eval("document.forms[0].mandatory_yn"+rowNumber+noOfRows.value),change_at_trans,dataArray[0],dataArray[3],data1,eval("document.forms[0].elementType"+rowNumber+noOfRows.value));
		noOfRows.value = parseInt(noOfRows.value) + 1
		
		var seq_no = document.forms[0].sequence.value;
		seq_no++;
		
	}
}

async function addNewRow(chart_id,panel_id,rowNumber){
	var rowNumbers =0;
	var indexNo = parseInt(rowNumber);
	var index=0;
	/*
	var dialogHeight = "27";
	var dialogWidth =	"36";
	var dialogTop = "150";
	*/
	var dialogTop   = "10px";
	 var dialogHeight= "500px" ;
	 var dialogWidth = "800px" ;
	var status = "no";
	var arguments ="";
	var htmlVal="";
	var retVal = "";
	var action_url = '../../eCA/jsp/ChartComponentFormulaForSummaryMain.jsp';
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url += "?chart_id="+chart_id+"&panel_id="+panel_id;
	retVal = await top.window.showModalDialog(action_url,arguments,features);
	var flag= 0;	
	var rowNum = 0;
	if(retVal != undefined)
	{
		var dataArray = retVal.split("||");		
		var noofrow= eval("document.ChartComponentListForm.noOfRows"+parseInt(rowNumber));
		for(index = 0;index < parseInt(noofrow.value);index++)
		{
			rowNum = parseInt(rowNumber)+""+index;
			tr= eval(document.getElementById("trRowId"+rowNum));
			
			if(tr.cells[1].innerText == dataArray[1])
			{
				flag = 1;
				alert(getMessage("CHART_COMPONENT_EXISTS","CA"));
				addNewRow(chart_id,panel_id,rowNumber)
				return false;
			}

		}	
		if(flag == 0)
		{
			for(index = 0;index < parseInt(noofrow.value);index++)
			{
				//tr= eval(document.getElementById("trRowId")+parseInt(rowNumber)+index);
				rowNum = parseInt(rowNumber)+""+index;
				tr= eval(document.getElementById("trRowId"+rowNum));
				
				if(parseInt(tr.cells[0].innerText) == parseInt(dataArray[0]))	
				{
					flag = 1;
					alert(getMessage("DUPLICATE_SEQUENCE_NUMBER","CA"));
					addNewRowForComponents(chart_id,panel_id,rowNumber,dataArray[2])
					return false
				}			
			}
		}
		if(flag == 1)
		{
			return false
		}
		else
		{
			parent.blankFrame.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempForm' id='tempForm' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='retVal' id='retVal' value = '"+retVal+"'><input type='hidden' name='calledFrom' id='calledFrom' value = 'addRow'><input type='hidden' name='chart_id' id='chart_id' value = '"+chart_id+"'></form></body></html>");
			parent.blankFrame.document.tempForm.submit();		
			var summary_req_yn = parent.chartComponentListFrame.document.ChartComponentListForm.sum_req.value;
			var change_at_trans = parent.chartComponentListFrame.document.ChartComponentListForm.change_trans.value;

			var disableSummReq = '';
			if(summary_req_yn == 'N' || summary_req_yn == ''){
				disableSummReq = ' disabled ';
			}
			else{
				if(dataArray[3] == "I" || dataArray[3] =="N" || (dataArray[3] =="L" && dataArray[4]=="Y") || dataArray[3] =="A")
					disableSummReq = '';
				else
					disableSummReq = ' disabled ';
			}
			
			var disableDefault = '';
			var checkDefault = '';
			if(change_at_trans == 'N'){
				checkDefault = ' checked ';
				disableDefault = ' disabled ';
			}
			else{
				checkDefault = '';
				disableDefault = '';
			}
			var summary ="";
			var argSummary = chart_id+":"+panel_id+":"+dataArray[1];
			var panel_desc_id = argSummary;
			var insertValue
			
			var noOfRows = eval("document.ChartComponentListForm.noOfRows"+parseInt(rowNumber));			
			var rowValue = parseInt(noOfRows.value);

			var select_yn = "<input type='checkbox' name='select_yn"+rowValue+"' id='select_yn"+rowValue+"' value='Y' checked OnCLick='removeRow("+rowNumber+","+noOfRows.value+",this)'>"

			var mandatory_yn = "";
			var element_type = "";
			//var	enable_ele_type = parent.chartComponentListFrame.document.ChartComponentListForm.all.enable_ele_type.value;
			var	enable_ele_type = parent.chartComponentListFrame.document.getElementById('enable_ele_type').value;

			var default_yn = "<input type='checkbox' name='default_yn"+rowNumber+noOfRows.value+"' id='default_yn"+rowNumber+noOfRows.value+"' '"+disableDefault+"' '"+checkDefault+"'  onclick='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
			var sum_yn = "<input type='checkbox' name='sum_yn"+rowNumber+noOfRows.value+"' id='sum_yn"+rowNumber+noOfRows.value+"' value='N' onclick='enableSumm("+rowNumber+","+noOfRows.value+",this)' '"+disableSummReq+"' >"
		
			var result_type = dataArray[3];
			if(result_type=="A")
			{
				htmlVal="<a href='javascript:' onclick='formulaDefn(\""+panel_desc_id+"\")' title='click here to open formula definition window'>Def.</a><input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+dataArray[3]+"'>"

				mandatory_yn="<input type='checkbox' style='display:none' name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"' value='N'  onclick='chkAndDisableDef(this,document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
			}
			else
			{
				htmlVal =" <input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+dataArray[3]+"'>";
				mandatory_yn="<input type='checkbox' name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"' value='N'  onclick='chkAndDisableDef(this,document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
			}

			//element_type = "<SELECT name='elementType"+rowNumber+noOfRows.value+"' id='elementType"+rowNumber+noOfRows.value+"' "+enable_ele_type+" onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+getLabel("Common.defaultSelect.label","Common")+"-------</option>"+document.forms[0].all.element_types.value+"</SELECT></td>";
			element_type = "<SELECT name='elementType"+rowNumber+noOfRows.value+"' id='elementType"+rowNumber+noOfRows.value+"' "+enable_ele_type+" onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option>"+parent.chartComponentListFrame.document.getElementById('element_types').value+"</SELECT></td>";

			var summaryType="<select name='summaryType"+rowNumber+noOfRows.value+"' id='summaryType"+rowNumber+noOfRows.value+"' disabled onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");checkDiscrValue(document.forms[0].summary_column"+rowNumber+noOfRows.value+",this)'><option value='X'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option><option value='SUM'>"+getLabel("eCA.SUM.label","CA")+"</option><option value='AVERAGE'>"+getLabel("eCA.AVG.label","CA")+"</option><option value='MAXIMUM'>"+getLabel("Common.Max.label","Common")+"</option><option value='MINIMUM'>"+getLabel("Common.MIN.label","Common")+"</option></SELECT>";
			//IN039171_reopen  starts
			//summary="<input type='text' name='summary_column"+rowNumber+noOfRows.value+"' id='summary_column"+rowNumber+noOfRows.value+"' SIZE='10' value='' readOnly OnChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' OnBlur='getDiscrId(this,"+rowNumber+","+noOfRows.value+");chkDupSummValues(this,"+rowNumber+","+noOfRows.value+")'><input type ='hidden' name='summaryColumnCode"+rowNumber+noOfRows.value+"' id='summaryColumnCode"+rowNumber+noOfRows.value+"'><input type='button' class='button' name='btnSumm"+rowNumber+noOfRows.value+"' id='btnSumm"+rowNumber+noOfRows.value+"' value='?' disabled onclick='summaryDefn(\""+argSummary+"\",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")'>";
			summary="<input type='text' name='summary_column"+rowNumber+noOfRows.value+"' id='summary_column"+rowNumber+noOfRows.value+"' SIZE='10' value='' readOnly OnChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")' OnBlur='getDiscrId(this,"+rowNumber+","+noOfRows.value+");chkDupSummValues(this,"+rowNumber+","+noOfRows.value+")'><input type ='hidden' name='summaryColumnCode"+rowNumber+noOfRows.value+"' id='summaryColumnCode"+rowNumber+noOfRows.value+"'><input type='button' class='button' name='btnSumm"+rowNumber+noOfRows.value+"' id='btnSumm"+rowNumber+noOfRows.value+"' value='?' disabled onclick='summaryDefnLookup(\""+argSummary+"\",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+","+rowNumber+","+noOfRows.value+");clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_at_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+")'>";
			//IN039171_reopen  ends
			if(indexNo > 0)
			{
				while (indexNo >= 0)
				{
					var row = eval("document.ChartComponentListForm.noOfRows"+indexNo);				
					rowNumbers = rowNumbers + parseInt(row.value) + 1
					indexNo--;
				}
			}
			else
			{
				rowNumbers = parseInt(noOfRows.value)+1
			}


			var data = eval("document.ChartComponentListForm.displaySeqNumber"+rowNumber+".value") + "<input type='hidden' name='panel_desc_msr_id"+rowNumber+noOfRows.value+"' id='panel_desc_msr_id"+rowNumber+noOfRows.value+"' value='"+argSummary+"'> ";
			
			var insertValue = (rowNumbers + 1);

			var classValue =	"";
			var noOfRowsValue = eval("document.ChartComponentListForm.noOfRows"+rowNumber);
			if(parseInt(noOfRowsValue.value) == 0){
				classValue =	"gridData"
			}	
			else
			{
				var trTextRow = eval(document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value-1)));
				
				classValue=  trTextRow.cells[0].className;
				if(classValue ==	"gridData")
						classValue =	"gridData"				
				else
						classValue =	"gridData"
			}
			var rowvar = document.getElementById("tabList").insertRow(insertValue);
			rowvar.id = "trRowId"+rowNumber+noOfRows.value
			var cellvar = rowvar.insertCell();
			cellvar.className=	"gridNumericData";
			cellvar.insertAdjacentHTML("BeforeEnd",dataArray[0]);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",dataArray[1]);	
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",dataArray[2]);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",sum_yn);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",summary);
			cellvar = rowvar.insertCell();	
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",summaryType);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",select_yn);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",mandatory_yn);
			cellvar = rowvar.insertCell();
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",element_type);
			cellvar = rowvar.insertCell();	
			cellvar.className=	classValue
			cellvar.insertAdjacentHTML("BeforeEnd",default_yn);
			var trTextRow1 = eval(document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value-1)));
			var data1  = eval("document.ChartComponentListForm.displaySeqNumber"+rowNumber+".value");
			var intermediateVar =parseInt(rowNumber)+""+ parseInt(noOfRows.value - 1)
			var rowsValue=eval("document.ChartComponentListForm.rowValue"+intermediateVar) ;
			var dummyVariable = rowNumber;
			var rowName = "rowValue"+parseInt(rowNumber)+(parseInt(noOfRows.value));
			htmlVal =data + "<input type='hidden' name='"+rowName+"' id='"+rowName+"' value='"+dummyVariable+"'>"
			cellvar = rowvar.insertCell();
			cellvar.style.display='none'
			cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
			clickOKSecond(argSummary,eval("document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value),eval("document.forms[0].summaryType"+rowNumber+noOfRows.value),eval("document.forms[0].summary_column"+rowNumber+noOfRows.value),eval("document.forms[0].default_yn"+rowNumber+noOfRows.value),eval("document.forms[0].sum_yn"+rowNumber+noOfRows.value),eval("document.forms[0].mandatory_yn"+rowNumber+noOfRows.value),change_at_trans,dataArray[0],dataArray[3],data1,eval("document.forms[0].elementType"+rowNumber+noOfRows.value));

			noOfRows.value = parseInt(noOfRows.value) + 1
			
			var seq_no = document.forms[0].sequence.value;
			seq_no++;
			
		}		
	}
	else
		return false;
}

/*******************************Removing a Tr from the table***********************/
function removeRow(rowIdI,rowIdJ,objCheck)
{

	rowId = rowIdI + "" + rowIdJ;
	var sequenceI = document.ChartComponentListForm.sequence.value
	var sequenceJ = document.ChartComponentListForm.sequenceGrp.value
	var change_at_trans = document.ChartComponentListForm.change_trans.value
	for(var indexRow = 0;indexRow < parseInt(sequenceJ) ;indexRow++)
	{
		var noofrows = eval("document.ChartComponentListForm.noOfRows"+indexRow);
		for(var indexCol = 0;indexCol < parseInt(noofrows.value);indexCol++)
		{
			var objText = eval("document.ChartComponentListForm.summary_column"+indexRow+""+indexCol);
			var objSelect = eval("document.ChartComponentListForm.summaryType"+indexRow+""+indexCol);
			/*********************************************************************/
			var objSummYN = eval("document.ChartComponentListForm.sum_yn"+indexRow+""+indexCol);
			/*********************************************************************/

		/*
		The below if-else block was UNCOMMENTED by
		Name   : T DINESH
		Date   : 2010-08-04
		INCNO  : IN022998
		Changes: Uncommented because when summary required column is checked and while at the same time
				 if we are trying to remove any discrete measure from the list page, it is not validating for the summary required with the summary column and summary type.
		*/
		
		if(objSummYN.checked==true )
		{
			if(objText.value !="")
			{
				if(objSelect.disabled != true)
				{
					if(objSelect.value=="X"){
						alert(getMessage("SUMMARY_TYPE_NOT_BLANK","CA"));
						objSelect.focus();
						objCheck.checked=true
						return false
					}						
				}				
			}
			else if(objSelect.value !="X" && objText.value=="")
			{
				
				alert(getMessage("SUMMARY_COLUMN_NOT_BLANK","CA"));
				objText.focus();
				objCheck.checked=true
				return false
			}
			else{
				alert(getMessage("SUMMARY_COLUMN_NOT_BLANK","CA"));
				objText.focus();
				objCheck.checked=true
				return false
			}	
		}
		}
	}

	if(objCheck.checked == false)
	{
		var trId = eval(document.getElementById("trRowId"+rowIdI+rowIdJ));
		var rowValue = eval("document.ChartComponentListForm.rowValue"+rowIdI+rowIdJ+".value");
		var chartId = 	 document.ChartComponentListForm.chartCompSearch.value
		var removeValue = parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.remove_value
				
		var tempString =  eval("document.ChartComponentListForm.groupId"+rowValue+".value");
		if(removeValue.value == "")
		{
			removeValue.value = chartId + "||" +trId.cells[1].innerText + "||" + tempString
		}
		else
		{
			removeValue.value =removeValue.value + '~' +chartId + "||" +trId.cells[1].innerText + "||" + tempString
		}
		document.ChartComponentListForm.remove_value.value = removeValue.value
	
		for(index = 0; index < parseInt(sequenceJ);index++)
		{
			var noOfRows = eval("document.ChartComponentListForm.noOfRows"+index);
			var finalStringMain =  eval("document.ChartComponentListForm.finalString"+index);
			var finalString = "";
			var displaySeq=eval("document.forms[0].displaySeqNumber"+index)
			for(indexI = 0 ;indexI < parseInt(noOfRows.value);indexI++)
			{
				var trText = eval(document.getElementById("trRowId"+index+indexI));

				var objText = eval("document.ChartComponentListForm.summary_column"+index+indexI);
				var objHidden = eval("document.ChartComponentListForm.summaryColumnCode"+index+indexI);
				var objSelect = eval("document.ChartComponentListForm.summaryType"+index+indexI);
				var mandatory_yn = eval("document.ChartComponentListForm.mandatory_yn"+index+indexI);
				var default_yn = eval("document.ChartComponentListForm.default_yn"+index+indexI);
				var sum_yn = eval("document.ChartComponentListForm.sum_yn"+index+indexI);
				var result_type = eval("document.ChartComponentListForm.result_type"+index+indexI);
				var element_type = eval("document.ChartComponentListForm.elementType"+index+indexI);

				
/*check*/				
				if(default_yn.checked == true)
					default_yn.value = 'Y'
				else
					default_yn.value = 'N'

/*check*/						
				
	/***************************************************************************/			
				
	/***************************************************************************/
				if(mandatory_yn.checked == true)
					mandatory_yn.value = 'Y'
				else
					mandatory_yn.value = 'N'


				var ij = index+""+indexI
				if(ij != rowId)
				{
					if(sum_yn.disabled == false)
					{
						if(sum_yn.checked == true )
							sum_yn.value = 'Y'
						else
							sum_yn.value = 'N'
					}
					else
					{
						sum_yn.disabled = true;

						if(sum_yn.checked == true )
							sum_yn.value = 'Y'
						else
							sum_yn.value = 'X'
						//sum_yn.value = 'X'
					}

					var tempString = "";
					tempString = objText.value;
					if(tempString=='')	
						tempString='X'
					if(objHidden.value=='')
						objHidden.value='X'
					if(objSelect.disabled==true)
						objSelect.disabled =false
					elementValue = element_type.value;
					if(elementValue=="")
						elementValue = '##';
					if(finalString=="")
					{
						finalString = trText.cells[0].innerText + '||' + trText.cells[1].innerText +'||' + trText.cells[2].innerText + '||' + result_type.value + '||' +displaySeq.value  +'||' + tempString + '||' +objHidden.value+"||" +objSelect.value +'||'+default_yn.value + '||' + sum_yn.value + '||' + mandatory_yn.value + '||' + change_at_trans + '||' + elementValue;
					}
					else
					{
						finalString = finalString +'~' +  trText.cells[0].innerText + '||' + trText.cells[1].innerText +'||' + trText.cells[2].innerText + '||' +  result_type.value + '||' + displaySeq.value +'||' + tempString + '||' +objHidden.value+"||" +objSelect.value + '||'+default_yn.value + '||' + sum_yn.value + '||' + mandatory_yn.value + '||' + change_at_trans + '||' + elementValue;
					}
											
				}
			}
	
			finalStringMain.value =finalString;			
		}
		document.ChartComponentListForm.operation.value='split';	
		document.ChartComponentListForm.method='post';		
		document.ChartComponentListForm.action='ChartComponentList.jsp';		
		document.ChartComponentListForm.submit();				
	}
	else
		return false
}

function addrow(rowId)
{
	var retVal = "";	
	var order_seq_num  = eval("document.forms[0].seq_num"+parseInt(rowId))
	var trText = eval(document.getElementById("trRowId"+rowId))
	if(order_seq_num.style.visibility=="hidden"){
		alert(getMessage("CHECK_SEQUENCE_NUMBER","CA"));
		return false;
	}
	else if(order_seq_num.value=="")
	{
		alert(getMessage("SEQUENCE_NOT_BLANK","CA"));
		return false;
	}
	else{
		retVal = order_seq_num.value +"||" + trText.cells[0].innerText + "||" +trText.cells[1].innerText + "||" +trText.cells[2].innerText 
		//window.returnValue= retVal;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = retVal;
		
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();   
	}
}

/****************************Summary Part******************************/
async function showId(chart_id){
	var chart_id = chart_id;
	var retVal = new String();
	var dialogTop = "40";
	var dialogHeight = "30";
	var dialogWidth = "40";
	var features = "dialogTop:"+dialogTop+"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";status=no";
	var arguments = "";
	var search_code = "";
	var search_desc = "";
	var title = getLabel("eCA.DiscreteMeasureIdSearch.label","CA");
	var sql = 'select distinct a.discr_msr_id, a.short_desc from am_discr_msr a, ca_chart_section b where a.discr_msr_id = b.panel_id and a.eff_status=`E`';

	search_code = 'discr_msr_id';
	search_desc = 'short_desc';

	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&chart_id="+chart_id+ "&search_code="+search_code+"&title="+encodeURIComponent(title,"UTF-8")+"&search_desc="+search_desc,arguments,features);

	var ch_arr = new Array();
	if(retVal!=null && retVal!=''){
		var retVal = unescape(retVal);
		ch_arr = retVal.split("::");
		document.ChartComponentSummarySearchForm.chartCompDiscrSearch.value = ch_arr[1];
		document.ChartComponentSummarySearchForm.chartCompDiscrSearch.value = ch_arr[0];
		document.ChartComponentSummarySearchForm.chartCompDiscrSearch.focus();
	}

}


function loadSummaryPage(panel_desc_id,discr_msr_id){
	parent.chartSectionSummaryFormulaConstructionFrame.location.href='../../eCA/jsp/ChartComponentFormulaConstructionForSummary.jsp?panel_desc_id='+panel_desc_id+'&discr_msr_id='+discr_msr_id;
}

function clickOK(panel_desc_id,objHidden,objSelect,objText,objCheck,objChkSum,objMandatory,objTrans,objElement){
	var calledFrom = "Summary";

//	alert(objChkSum.value);
	//var change_at_trans = document.ChartComponentListForm.change_trans.value;
	if(objMandatory.checked == true)
		objMandatory.value = 'Y'
	else
		objMandatory.value = 'N'

	if(objCheck.checked == true)
		objCheck.value = 'Y';
	else
		objCheck.value = 'N';

	/*if(objMandatory.checked==true)
		objMandatory.value='Y'
	else{
		document.forms[0].chkMainMandatory.checked = false;
		objMandatory.value='N'
	}*/
/*****************************************************************************/

	if(objChkSum.checked==true)
		objChkSum.value='Y'
	else
		objChkSum.value='N'
/*****************************************************************************/

	var SummaryType = objSelect.value;
	if(objText.value=='')
	{
		objHidden.value='X'
	}

	parent.blankFrame.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+panel_desc_id+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"><input type='hidden' name='SummaryType' id='SummaryType' value = \""+SummaryType+"\"><input type='hidden' name='element_type' id='element_type' value = \""+objElement.value+"\"><input type='hidden' name='SummaryColumn' id='SummaryColumn' value = \""+objHidden.value+"\"><input type='hidden' name='default_yn' id='default_yn' value = \""+objCheck.value+"\"><input type='hidden' name='sum_yn' id='sum_yn' value = \""+objChkSum.value+"\"><input type='hidden' name='mandatory_yn' id='mandatory_yn' value = \""+objMandatory.value+"\"><input type='hidden' name='change_at_trans' id='change_at_trans' value = \""+objTrans+"\"></form></body></html>");
	parent.blankFrame.document.tempformformula.submit();
}


function clickOKSecond(panel_desc_id,objHidden,objSelect,objText,objCheck,objSumCheck,objMandatory,change_at_trans,order_seq_no,result_type,display_order_seq,element_type){
	
	var calledFrom = "SummaryFromSecond";
	if(objText.value=='')
	{
		objHidden.value='X'
	}
	if(objCheck.checked==true)
		objCheck.value='Y'
	else
		objCheck.value='N'

	/************************************************************************/
	if(objSumCheck.checked==true)
		objSumCheck.value='Y'
	else
		objSumCheck.value='N'

	/************************************************************************/

	if(change_at_trans == 'N'){
		objCheck.checked = true;
		objCheck.disabled = true;
	}
	else{
		objCheck.disabled = false;
	}
	
	var recordValues = result_type + "$" +order_seq_no + "$" + display_order_seq

	//alert('recordValues = '+recordValues);
	var SummaryType = objSelect.value;
	var HtmlVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+panel_desc_id+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"><input type='hidden' name='SummaryType' id='SummaryType' value = \""+SummaryType+"\"><input type='hidden' name='SummaryColumn' id='SummaryColumn' value = \""+objHidden.value+"\"><input type='hidden' name='default_yn' id='default_yn' value = \""+objCheck.value+"\"><input type='hidden' name='sum_yn' id='sum_yn' value = \""+objSumCheck.value+"\"><input type='hidden' name='mandatory_yn' id='mandatory_yn' value = \""+objMandatory.value+"\"><input type='hidden' name='element_type' id='element_type' value = \""+element_type.value+"\"><input type='hidden' name='recordValues' id='recordValues' value = \""+recordValues+"\"><input type='hidden' name='change_at_trans' id='change_at_trans' value = \""+change_at_trans+"\"></form></body></html>";
	parent.blankFrame2.document.write("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()'><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+panel_desc_id+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"><input type='hidden' name='SummaryType' id='SummaryType' value = \""+SummaryType+"\"><input type='hidden' name='SummaryColumn' id='SummaryColumn' value = \""+objHidden.value+"\"><input type='hidden' name='default_yn' id='default_yn' value = \""+objCheck.value+"\"><input type='hidden' name='sum_yn' id='sum_yn' value = \""+objSumCheck.value+"\"><input type='hidden' name='mandatory_yn' id='mandatory_yn' value = \""+objMandatory.value+"\"><input type='hidden' name='element_type' id='element_type' value = \""+element_type.value+"\"><input type='hidden' name='recordValues' id='recordValues' value = \""+recordValues+"\"><input type='hidden' name='change_at_trans' id='change_at_trans' value = \""+change_at_trans+"\"></form></body></html>");
	//parent.blankFrame2.document.body.insertAdjacentHTML('afterbegin',HtmlVal)
	parent.blankFrame2.document.tempformformula.submit();
}

function cancelwin(){
	//window.close();
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
}

/****************************************************************/
function selectValues() //function to get the values from combo boxes and text field 
{
	var search_val = 	document.TaskSearchForm.search_criteria.value
	var text_val = document.TaskSearchForm.search_text.value;
	var rad_val_desc = document.TaskSearchForm.radSearch[0];
	var rad_val_code = document.TaskSearchForm.radSearch[1];
	var condition = "";
	if(rad_val_desc.checked==true){
		condition = "D";
	}
	else if(rad_val_code.checked==true){
		condition = "C";
	}	parent.frames[1].document.location.href='../../eCA/jsp/ChartComponentAddRow.jsp?search_val='+search_val+'&text_val='+text_val+'&condition='+condition;
}

/****************************************************************/
function loadFrames() //if a different item is selected in the list box previous values are cleared
{
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/****************************************************************/
function activateText(objCheck,rowNum)
{
	if(objCheck.checked==true)
	{
		var objText = eval("document.chartComponentAddNewForm.seq_num"+rowNum);
		objText.style.visibility='visible'	
		var len = parseInt(document.chartComponentAddNewForm.sequence.value)
		for(var index=0;index < len;index++)
		{
			if(parseInt(rowNum) !=index )
			{
				var check = eval("document.chartComponentAddNewForm.default_yn"+index);
				objText=eval("document.chartComponentAddNewForm.seq_num"+index);
				check.checked=false;

				objText.value=''
				objText.style.visibility='hidden'	
			}
		}			
	}	
}


function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


/*function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}*/

/**************************ONBLUR EVENT*******************************/

async function getChartCode(objCode)
{
	
	if(objCode.name=='chartDesc')
	{
		if((objCode.value) == "null" || (objCode.value ==""))
		{
			
				return false;			
		}
		else
		{
			
			await chartCode(objCode);
		}
	}
	else if(objCode.name=='cmnlookupChart')
	{
		if((objCode.value) == "null" || (objCode.value =="") || (objCode.value ==undefined) || (objCode.value) == null)
		{
			return false;
		}
		else 
		{
			await chartCode(objCode);			
		}
		
		
		//chartCode(objCode);
	}
}

function setValue()
{
//	document.ChartComponentHeaderForm.flag.value='false'
}

async function chartCode(objCode)
{	
		var chart = objCode.value;
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforlookup' id='tempformforlookup' method='post' action='../../eCA/jsp/ChartComponentIntermediate.jsp'><input type=hidden name='chartCode' id='chartCode' value='"+chart+"'></form></body></html>";
		//parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal)
		//parent.blankFrame.document.tempformforlookup.submit();
		parent.blankFrame.document.forms['tempformforlookup'].submit();
		
}

 /*
		The below new functions were written by
		Name   : T DINESH
		Date   : 2010-08-04
		INCNO  : IN022998
		Changes: new functions have been written for onblur and onclick events
*/
//IN039171 starts
//function summaryDefnLookup(panel_desc_id,objText,objHidden)
async function summaryDefnLookup(panel_desc_id,objText,objHidden,k,noofrows)
//IN039171 ends
{	
		var summaryValue = objText.value;
		objTextName = objText.name;
		hidObjName = objHidden.name;
		//parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		//IN039171 starts
		//var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforlookup' id='tempformforlookup' method='post' action='ChartComponentIntermediate.jsp?'><input type=hidden name='summaryDefn' id='summaryDefn' value='summaryDefn'><input type=hidden name='calledFrom' id='calledFrom' value='summaryDefn'><input type=hidden name='summaryValue' id='summaryValue' value='"+summaryValue+"'><input type=hidden name='objText' id='objText' value='"+objText+"'><input type=hidden name='summaryValue' id='summaryValue' value='"+summaryValue+"'><input type=hidden name='objHidden' id='objHidden' value='"+objHidden+"'><input type=hidden name='objTextName' id='objTextName' value='"+objTextName+"'><input type=hidden name='objHidden' id='objHidden' value='"+objHidden+"'><input type=hidden name='hidObjName' id='hidObjName' value='"+hidObjName+"'></form></body></html>";
		//var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforlookup' id='tempformforlookup' method='post' action='ChartComponentIntermediate.jsp?'><input type=hidden name='summaryDefn' id='summaryDefn' value='summaryDefn'><input type=hidden name='calledFrom' id='calledFrom' value='summaryDefn'><input type=hidden name='summaryValue' id='summaryValue' value='"+summaryValue+"'><input type=hidden name='objText' id='objText' value='"+objText+"'><input type=hidden name='summaryValue' id='summaryValue' value='"+summaryValue+"'><input type=hidden name='objHidden' id='objHidden' value='"+objHidden+"'><input type=hidden name='objTextName' id='objTextName' value='"+objTextName+"'><input type=hidden name='objHidden' id='objHidden' value='"+objHidden+"'><input type=hidden name='hidObjName' id='hidObjName' value='"+hidObjName+"'><input type=hidden name='k' id='k' value='"+k+"'><input type=hidden name='noofrows' id='noofrows' value='"+noofrows+"'></form></body></html>";//
		//var label = "eCA.DiscreteMeasureSearch.label";
		//IN066995---starts
		var textObj = eval("parent.chartComponentListFrame.ChartComponentListForm."+objTextName); 
		var hidObj = eval("parent.chartComponentListFrame.ChartComponentListForm."+hidObjName); 
		 var summarySql = "select discr_msr_id code , short_desc description from am_discr_msr where eff_status = 'E' and upper(discr_msr_id) like  upper(?) and upper(short_desc) like upper(?) and  result_type='S' order by 2";
		//objTextName = request.getParameter("objTextName") == null ? "" : request.getParameter("objTextName");
		//hidObjName = request.getParameter("hidObjName") == null ? "" : request.getParameter("hidObjName"
		retArray = await callFunction(summarySql,getLabel("eCA.DiscreteMeasureSearch.label","eCA"),textObj)
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
				textObj.value = arr[1];
				hidObj.value = arr[0];
				
			}
			else
			{
				textObj.value = '';
				hidObj.value = '';
			
			}
//IN066995----ends
		chkDupSummValues(textObj,k,noofrows);////IN039171 
		//IN039171 ends
		//parent.blankFrame2.document.write(HtmlVal);
		//parent.blankFrame2.document.tempformforlookup.submit();
}

////IN039171 starts
//function onBlursummaryDefnLookup(panel_desc_id,objText,objHidden)
function onBlursummaryDefnLookup(panel_desc_id,objText,objHidden,k,noofrows)
//IN039171 ends
{
	if(objText!=null && objText.value!="")
	{
	 //IN039171 starts
	 //summaryDefnLookup(panel_desc_id,objText,objHidden)
	 summaryDefnLookup(panel_desc_id,objText,objHidden,k,noofrows)
	 //IN039171 ends
	}
}
/*
	end
*/

function getDiscrId(objCode,rowNum,colNum)
{
	if(objCode.readOnly == true)	
		return false
	if(objCode.value=='')
		return false
else
	{
		var chart = objCode.value;
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='ChartComponentIntermediateDiscrete.jsp'><input type=hidden name='chartCode' id='chartCode' value='"+chart+"'><input type=hidden name='rowNum' id='rowNum' value='"+rowNum+"'><input type=hidden name='colNum' id='colNum' value='"+colNum+"'></form></body></html>";
		parent.messageFrame.document.write(HtmlVal);
		parent.messageFrame.document.forms[0].submit();
	}
}

async function callFunction(sql,title,target)
{
	//alert(sql);
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = trimString(target.value);
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup(title, argArray);
	return retArray;
 }

 function checkDiscrValue(objText,objSelect)
 {
	if(objSelect.value!='X')
	{
		if(objText.value=='')
		{
			alert(getMessage("DISCRETE_MEASURE_NOT_BLANK","CA"));
			objText.focus();
			return false;
		}
	 }
 }

 function checkSequence(objSequence)
{
	var errorMessage ="";
	 if(parseInt(objSequence.value) <= 0)
	{
		errorMessage= getMessage("SEQUENCE_NOT_ZERO","CA");
		alert(errorMessage);
		objSequence.value='';
		objSequence.select();
		return false
	}
	if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
	{
		errorMessage= getMessage("SEQUENCE_NOT_ZERO","CA");
		alert(errorMessage);
		objSequence.value='';
		objSequence.select();
		return false
	}
}
/****************************************************************************/

function enableSumm(rowIdI,rowIdJ,objSummCheck)
{
	var objSummText = 	eval("parent.chartComponentListFrame.document.forms[0].summary_column"+parseInt(rowIdI)+parseInt(rowIdJ));
	var objSummSelect = eval("parent.chartComponentListFrame.document.forms[0].summaryType"+parseInt(rowIdI)+parseInt(rowIdJ));
	var objSummbtn = eval("parent.chartComponentListFrame.document.forms[0].btnSumm"+parseInt(rowIdI)+parseInt(rowIdJ));

	if(objSummCheck.checked==true)
	{	
		//objSummText.readOnly = true;
		objSummText.readOnly = false;
		objSummSelect.disabled = false;	
		objSummbtn.disabled = false;
		objSummCheck.value = "Y";
	}
	else if(objSummCheck.checked==false)
	{	
		objSummText.readOnly = true;
		objSummSelect.disabled = true;
		objSummbtn.disabled = true;
		objSummText.value = '';
		objSummSelect.value = 'X';
		objSummCheck.value = "N";
	}

}

/*******************************For Default******************************/
/*function perform(obj){
	var calledFrom = "default";
	var default_yn = "";
	var finalDiscrMsrId = "";
	var finalConcatenatedString = "";
	var indexJ = parseInt(parent.chartComponentListFrame.document.ChartComponentListForm.sequenceGrp.value)
	if(obj.checked == true){

				mandatory_yn = 'Y'
			}
			else{

				mandatory_yn = 'N'
			}
	var indexRow = 0
	var indexCol = 0;	
	for(indexRow=0;indexRow<indexJ;indexRow++){
		var noOfRows = eval("parent.chartComponentListFrame.document.ChartComponentListForm.noOfRows"+indexRow);
		for(indexCol=0;indexCol<parseInt(noOfRows.value);indexCol++){
			var objMandatory =	eval("parent.chartComponentListFrame.document.ChartComponentListForm.mandatory_yn"+indexRow+""+indexCol);
			var objDefault =	eval("parent.chartComponentListFrame.document.ChartComponentListForm.default_yn"+indexRow+""+indexCol);
			var SummaryColumn = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summaryColumnCode"+indexRow+""+indexCol);
			var panel_desc_id = 	eval("parent.chartComponentListFrame.document.ChartComponentListForm.panel_desc_msr_id"+indexRow+""+indexCol);
			
			var SummaryType = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summaryType"+indexRow+""+indexCol);
			var summary = "";
			var objChkSum = eval("parent.chartComponentListFrame.document.ChartComponentListForm.sum_yn"+indexRow+""+indexCol);
			if(SummaryColumn.value=="")
				SummaryColumn.value ="X"
			if(objChkSum.disabled == true)
			{
				objChkSum.disabled = false
				if(objChkSum.checked ==true){
					objChkSum.value = 'Y'
				}
				else{
					objChkSum.value = 'N'
				}
				objChkSum.disabled = true	
			}
			if(SummaryType.disabled == true)
			{
				SummaryType.disabled = false
				summary = SummaryType.value
				SummaryType.disabled = true
			}
			else
			{
				summary = "X"
			}
			if(finalDiscrMsrId == "" ||finalConcatenatedString=="")
			{
				finalDiscrMsrId = panel_desc_id.value
				finalConcatenatedString = SummaryColumn.value + ":" +summary + ":" + default_yn +":" + objChkSum.value + ":" + mandatory_yn + 
			}
			else
			{
				finalDiscrMsrId = finalDiscrMsrId + "||" + panel_desc_id.value
				finalConcatenatedString = finalConcatenatedString + "~" +SummaryColumn.value + ":" + summary + ":" + default_yn + ":" + objChkSum.value + ":" + mandatory_yn

			}
			if(obj.checked == true){
				objMandatory.checked = true;
				objDefault.checked = true;
		
			}
			else{
				objMandatory.checked = false;
				objDefault.checked = false;
			}
			if(objDefault.checked == true){
				objDefault.value = 'Y';
			}
			else{
				objDefault.value = 'N';
			}


			
			
		}
	}
	parent.blankFrame3.document.write("<html><body><form name='tempformformula' id='tempformformula' method = 'post' action='../../eCA/jsp/ChartComponentBeanIntermediate.jsp'><input type='hidden' name='panel_desc_id' id='panel_desc_id' value = \""+finalDiscrMsrId+"\"><input type='hidden' name='calledFrom' id='calledFrom' value = \""+calledFrom+"\"><input type='hidden' name='finalString' id='finalString' value = \""+finalConcatenatedString+"\"></form></body></html>");
	parent.blankFrame3.document.tempformformula.submit();
}*/


/********************************Add new Panel***************************/
async function addPanel(chart_id){
	//alert('chart_id from js = '+chart_id);
	var flagDup = 0;
	
	/*
	var dialogHeight = "26.25";
	var dialogWidth =	"35";
	var dialogTop = "150";	
	*/
	
	 var dialogTop   = "0px";
	 var dialogHeight= "500px" ;
	 var dialogWidth = "800px" ;
    
	var status = "no";	
	var features = "dialogTop:"+dialogTop+";dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";status=no;";
	var arguments = "";
	var retVal =await top.window.showModalDialog("../../eCA/jsp/ChartComponentAddPanelMain.jsp?chart_id="+chart_id,arguments,features);

	//alert('retVal = '+retVal);
	
	if(retVal != undefined){
		var split_values = retVal.split("||");
		var noofrow = '';
		var rowNumber = 0;
		var sequenceGrp = document.ChartComponentListForm.sequenceGrp
		var noofrow = eval("document.ChartComponentListForm.noOfRows"+parseInt(sequenceGrp.value));
		var trDup = '';
		for(index = 0; index < parseInt(sequenceGrp.value);index++){
			trDup = eval("document.forms[0].groupId"+index);
			if(trDup.value == split_values[1]){
				flagDup = 1;
				alert(getMessage("CHART_COMPONENT_EXISTS","CA"));
				addPanel(chart_id);
				return false;
			}
		}
		if(flagDup != 1){
			//alert(split_values[2])
			for(index = 0;index < parseInt(sequenceGrp.value);index++){
				trDup = eval("document.forms[0].displaySeqNumber"+index);
				if(trDup.value ==  split_values[0]){
					flagDup = 1;
					alert(getMessage("DUPLICATE_SEQUENCE_NUMBER","CA"));
					addNewPanelForComponents(chart_id,split_values[1],split_values[2]);
					return false
				}
			}
		}

		if(flagDup == 1)
		{
			return false
		}
		else{
			var rowvar = document.getElementById("tabList").insertRow();
			rowvar.id = "trGrpHeader"+sequenceGrp.value;
			var htmlVal = "<input type ='hidden' name='group"+sequenceGrp.value+"' id='group"+sequenceGrp.value+"' value='"+split_values[1]+"'>" +"<input type ='hidden' name='groupId"+sequenceGrp.value+"' id='groupId"+sequenceGrp.value+"' value='"+split_values[1]+"'>" + "<input type='hidden' name='finalString"+sequenceGrp.value+"' id='finalString"+sequenceGrp.value+"' value=''>" + "<input type ='hidden' name='noOfRows"+sequenceGrp.value+"' id='noOfRows"+sequenceGrp.value+"' value='0'>" + "<input type ='hidden' name='displaySeqNumber"+sequenceGrp.value+"' id='displaySeqNumber"+sequenceGrp.value+"' value='"+split_values[0]+"'>"+ split_values[2];
			var cellvar = rowvar.insertCell();
			cellvar.colSpan = '10';
			cellvar.className = 'CAGROUPHEADING';
			cellvar.align = 'left';
			cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
			cellvar = rowvar.insertCell();
			var btnForNewPanel = "<input type='button' class='button'  name='addNew"+split_values[1]+"' id='addNew"+split_values[1]+"' onclick='addNewRow(\""+chart_id+"\",\""+split_values[1]+"\",\""+parseInt(sequenceGrp.value)+"\")' value='"+getLabel("Common.Add.label","Common") +" "+getLabel("Common.New.label","Common")+"'>";	
			cellvar.colSpan = '1';
			cellvar.className = 'button';
			cellvar.insertAdjacentHTML("BeforeEnd",btnForNewPanel);
			sequenceGrp.value = parseInt(sequenceGrp.value) + 1;
			
			parent.blankFrameAddPanel.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformAddPanel' id='tempformAddPanel' method = 'post' action='../../eCA/jsp/chartComponentIntermediateAddPanel.jsp'><input type='hidden' name='panel_id' id='panel_id' value = \""+split_values[1]+"\"><input type='hidden' name='panel_desc' id='panel_desc' value = \""+split_values[2]+"\"><input type='hidden' name='chart_id' id='chart_id' value = \""+chart_id+"\"><input type='hidden' name='display_order_seq' id='display_order_seq' value = \""+split_values[0]+"\"><input type='hidden' name='seqGrpVal' id='seqGrpVal' value = \""+sequenceGrp.value+"\"></body></html>");
			
			parent.blankFrameAddPanel.document.tempformAddPanel.submit();			
		}
	}
	else{
		return false;
	}	
}


async function addNewPanelForComponents(chart_id,panel_id,panel_desc){	

	var rowNumbers =0;
	var indexNo = parseInt(rowNumber);
	var index=0;
	var dialogHeight = "500px";
	var dialogWidth =	"800px";
	var dialogTop = "0";
	var status = "no";
	var arguments ="";
	var htmlVal="";
	var flagDup = 0;
	var retVal = "";
	var action_url = '../../eCA/jsp/ChartComponentAddPanelMain.jsp';
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url += "?chart_id="+chart_id+"&panel_id="+panel_id+"&searchText="+panel_desc;
	retVal =await top.window.showModalDialog(action_url,arguments,features);

	if(retVal != undefined){
		var split_values = retVal.split("||");
		var noofrow = '';
		var rowNumber = 0;
		var sequenceGrp = document.ChartComponentListForm.sequenceGrp
		var noofrow = eval("document.ChartComponentListForm.noOfRows"+parseInt(sequenceGrp.value));
		var flagDup = 0;	
		var trDup = '';
		for(index = 0; index < parseInt(sequenceGrp.value);index++){
			trDup = eval("document.forms[0].groupId"+index);
			if(trDup.value == split_values[1]){
				flagDup = 1;
				alert(getMessage("CHART_COMPONENT_EXISTS","CA"));
				addPanel(chart_id);
				return false;
			}
		}
		if(flagDup == 0){
			for(index = 0;index < parseInt(sequenceGrp.value);index++){
				trDup = eval("document.forms[0].displaySeqNumber"+index);
				if(trDup.value ==  split_values[0]){
					flagDup = 1;
					alert(getMessage("DUPLICATE_SEQUENCE_NUMBER","CA"));
					addNewPanelForComponents(chart_id,split_values[1],split_values[2]);
					return false
				}
			}
		}
		if(flagDup == 1)
		{
			return false
		}
		else{

			var rowvar = document.getElementById("tabList").insertRow();
			rowvar.id = "trGrpHeader"+sequenceGrp.value;
			var htmlVal = "<input type ='hidden' name='group"+sequenceGrp.value+"' id='group"+sequenceGrp.value+"' value='"+split_values[1]+"'>" +"<input type ='hidden' name='groupId"+sequenceGrp.value+"' id='groupId"+sequenceGrp.value+"' value='"+split_values[1]+"'>" + "<input type='hidden' name='finalString"+sequenceGrp.value+"' id='finalString"+sequenceGrp.value+"' value=''>" + "<input type ='hidden' name='noOfRows"+sequenceGrp.value+"' id='noOfRows"+sequenceGrp.value+"' value='0'>" + "<input type ='hidden' name='displaySeqNumber"+sequenceGrp.value+"' id='displaySeqNumber"+sequenceGrp.value+"' value='"+split_values[0]+"'>"+ split_values[2];
			var cellvar = rowvar.insertCell();
			cellvar.colSpan = '10';
			cellvar.className = 'CAGROUPHEADING';
			cellvar.align = 'left';
			cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);
			cellvar = rowvar.insertCell();
			
			var btnForNewPanel = "<input type='button' class='button'  name='addNew"+split_values[1]+"' id='addNew"+split_values[1]+"' onclick='addNewRow(\""+chart_id+"\",\""+split_values[1]+"\",\""+parseInt(sequenceGrp.value)+"\")' value='"+getLabel("Common.Add.label","Common") +" "+getLabel("Common.New.label","Common")+"'>";	
			cellvar.colSpan = '1';
			cellvar.className = 'button';			
			cellvar.insertAdjacentHTML("BeforeEnd",btnForNewPanel);
			sequenceGrp.value = parseInt(sequenceGrp.value) + 1;
						
			parent.blankFrameAddPanel.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformAddPanel' id='tempformAddPanel' method = 'post' action='../../eCA/jsp/chartComponentIntermediateAddPanel.jsp'><input type='hidden' name='panel_id' id='panel_id' value = \""+split_values[1]+"\"><input type='hidden' name='panel_desc' id='panel_desc' value = \""+split_values[2]+"\"><input type='hidden' name='chart_id' id='chart_id' value = \""+chart_id+"\"><input type='hidden' name='display_order_seq' id='display_order_seq' value = \""+split_values[0]+"\"><input type='hidden' name='seqGrpVal' id='seqGrpVal' value = \""+sequenceGrp.value+"\"></body></html>");
			parent.blankFrameAddPanel.document.tempformAddPanel.submit();
		}
	}
}


function searchPanelValues() //function to get the values from combo boxes and text field 
{
	var search_val = 	document.panelSearchCriteriaForm.search_criteria.value
	var text_val = document.panelSearchCriteriaForm.search_text.value;
	
		var rad_val_desc = document.panelSearchCriteriaForm.radSearch[0];
	var rad_val_code = document.panelSearchCriteriaForm.radSearch[1];

	var condition = "";
	var chart_id =  document.panelSearchCriteriaForm.chartId.value;
	if(rad_val_desc.checked==true){
		condition = "D";
	}
	else if(rad_val_code.checked==true){
		condition = "C";
	}	parent.frames[1].document.location.href='../../eCA/jsp/ChartComponentAddPanel.jsp?search_val='+search_val+'&text_val='+text_val+'&condition='+condition+'&chart_id='+chart_id;
}

function addPanelForChart(rowId)
{
	var retVal = "";	
	var order_seq_num  = eval("document.forms[0].seq_num"+parseInt(rowId))
	var trText = eval(document.getElementById("trRowId"+rowId))
	if(order_seq_num.style.visibility=="hidden"){
		alert(getMessage("CHECK_SEQUENCE_NUMBER","CA"));
		return false;
	}
	else if(order_seq_num.value=="")
	{
		alert(getMessage("SEQUENCE_NOT_BLANK","CA"));
		return false;
	}
	else{
		retVal = order_seq_num.value +"||" + trText.cells[0].innerText + "||" +trText.cells[1].innerText 
		//window.returnValue= retVal;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = retVal;
		
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();   
	}
}

function displayDiscrMsrForPanel(chart_id, panel_id,finalString,summ_req,change_trans,mandatory_yn)
{
	var disableSumReq = '';
	var disableDefault = '';
	var checkDefault = '';
	var disableChangeTrans = '';
	var checkChangeTrans = '';
	

	if(change_trans == 'N')
	{
		checkDefault = " checked ";
		disableDefault = " disabled ";
	}

	/*if(change_trans == 'N'){
		disableChangeTrans = ' disabled ';
		checkChangeTrans = ' checked ';
	}
	else{
		disableChangeTrans = '';
		checkChangeTrans = '';
	}*/

	var finalDiscrMsrId = "";
	var finalConcatenatedString = "";
	
	var recordValues = "";
	var SummaryType = "";//objSelect.value;
	var element_type1 = ''
	var discr_msr_desc = '';
	var discr_msr_id = '';
	var order_srl_no = '';
	var result_type = '';
	var associate_score_yn = '';
	var seqGrpNo = eval("parent.chartComponentListFrame.document.ChartComponentListForm.sequenceGrp");
	var rowNumber = parseInt(seqGrpNo.value) - 1;
	var noOfRows = eval("parent.chartComponentListFrame.document.ChartComponentListForm.noOfRows"+rowNumber);
	var classValue = "";
	splitFinalString = finalString.split("~");
	for(var index = 0; index< splitFinalString.length;index++){
		splitVals = splitFinalString[index].split("||");
		discr_msr_desc = splitVals[0];
		discr_msr_id = splitVals[1];
		order_srl_no = splitVals[2];
		result_type = splitVals[3];
		//result_type = splitVals[3];
		associate_score_yn = splitVals[4];
		element_type1 = splitVals[5];

		
		if(summ_req == 'N'){
			disableSumReq = ' disabled ';
		}
		else{
		
			if((result_type =="L" && associate_score_yn =="Y") || result_type == "I" || result_type =="N" || result_type =="A")
			{
					disableSumReq = '';
			}
			else
			{
				disableSumReq = ' disabled ';
			}
		}

		var summary ="";
		var argSummary = chart_id+":"+panel_id+":"+discr_msr_id;
		var rowValue = parseInt(noOfRows.value);
		var select_yn = "<input type='checkbox' name='select_yn"+rowValue+"' id='select_yn"+rowValue+"' value='Y' checked OnCLick='removeRow("+rowNumber+","+noOfRows.value+",this)'>"
		var mandatory_yn ="";	
		if(result_type != "A")
		{
		 mandatory_yn = "<input type='checkbox' name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"'   value='N' onclick='chkAndDisableDef(this,parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\");clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
		}
		else
		{
			mandatory_yn = "<input type='checkbox' name='mandatory_yn"+rowNumber+noOfRows.value+"' id='mandatory_yn"+rowNumber+noOfRows.value+"'   style='display:none' value='N' onclick='chkAndDisableDef(this,parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\");clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"
		}
		element_type1='##';
		var finalStr = parent.chartComponentListFrame.document.getElementById('element_types').value;
		var elementTypes;
		if(finalStr.indexOf(element_type1)!=-1)
		{
			var s1 = finalStr.substring(0,finalStr.indexOf('>',finalStr.indexOf(element_type1)));
			s1 = s1 + 'selected';
			var s2 = finalStr.substring(finalStr.indexOf('>',finalStr.indexOf(element_type1)));
			elementTypes = s1+s2;
		}
		else
			elementTypes = finalStr;
		
		//var	enable_ele_type = parent.chartComponentListFrame.document.ChartComponentListForm.all.enable_ele_type.value;
		var	enable_ele_type = parent.chartComponentListFrame.document.getElementById('enable_ele_type').value;

		var element_type = "<SELECT name='elementType"+rowNumber+noOfRows.value+"' id='elementType"+rowNumber+noOfRows.value+"'"+enable_ele_type+" onchange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");' onblur='chkDupElementTypes(this,\""+result_type+"\")'> <option value='##'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option>"+elementTypes+"</SELECT></td>"

		var default_yn = "<input type='checkbox' name='default_yn"+rowNumber+noOfRows.value+"' id='default_yn"+rowNumber+noOfRows.value+"' '"+disableDefault+"' '"+checkDefault+"' onclick='clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")' >"

		var sum_yn = "<input type='checkbox' name='sum_yn"+rowNumber+noOfRows.value+"' id='sum_yn"+rowNumber+noOfRows.value+"' value='N' "+disableSumReq+" onclick='enableSumm("+rowNumber+","+noOfRows.value+",this)'>"
		
		if(result_type == "A")
		{
			htmlVal="<a href='javascript:' onclick='formulaDefn(\""+argSummary+"\")' title='click here to open formula definition window'>Defn.</a><input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+result_type+"'>"
		}
		else
		{
			htmlVal = "<input type='hidden' name='result_type"+rowNumber+noOfRows.value+"' id='result_type"+rowNumber+noOfRows.value+"' value='"+result_type+"'>";
		}

		var summaryType="<select name='summaryType"+rowNumber+noOfRows.value+"' id='summaryType"+rowNumber+noOfRows.value+"' disabled onChange='clickOK(\""+argSummary+"\",document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",document.forms[0].summaryType"+rowNumber+noOfRows.value+",document.forms[0].summary_column"+rowNumber+noOfRows.value+",document.forms[0].default_yn"+rowNumber+noOfRows.value+",document.forms[0].sum_yn"+rowNumber+noOfRows.value+",document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",document.forms[0].elementType"+rowNumber+noOfRows.value+");checkDiscrValue(document.forms[0].summary_column"+rowNumber+noOfRows.value+",this)'><option value='X'>------"+getLabel("Common.defaultSelect.label","Common")+"------</option><option value='SUM'>"+getLabel("eCA.SUM.label","CA")+"</option><option value='AVERAGE'>"+getLabel("eCA.AVG.label","CA")+"</option><option value='MAXIMUM'>"+getLabel("Common.Max.label","Common")+"</option><option value='MINIMUM'>"+getLabel("Common.MIN.label","Common")+"</option></SELECT>"

		//IN039171_reopen starts
		//summary="<input type='text' name='summary_column"+rowNumber+noOfRows.value+"' id='summary_column"+rowNumber+noOfRows.value+"' SIZE='10' value='' readOnly OnChange='clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")' OnBlur='getDiscrId(this,"+rowNumber+","+noOfRows.value+");chkDupSummValues(this,"+rowNumber+","+noOfRows.value+")'><input type ='hidden' name='summaryColumnCode"+rowNumber+noOfRows.value+"' id='summaryColumnCode"+rowNumber+noOfRows.value+"'><input type='button' class='button' name='btnSumm"+rowNumber+noOfRows.value+"' id='btnSumm"+rowNumber+noOfRows.value+"' value='?' disabled onclick='summaryDefn(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+");clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")'>";
		summary="<input type='text' name='summary_column"+rowNumber+noOfRows.value+"' id='summary_column"+rowNumber+noOfRows.value+"' SIZE='10' value='' readOnly OnChange='clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")' OnBlur='getDiscrId(this,"+rowNumber+","+noOfRows.value+");chkDupSummValues(this,"+rowNumber+","+noOfRows.value+")'><input type ='hidden' name='summaryColumnCode"+rowNumber+noOfRows.value+"' id='summaryColumnCode"+rowNumber+noOfRows.value+"'><input type='button' class='button' name='btnSumm"+rowNumber+noOfRows.value+"' id='btnSumm"+rowNumber+noOfRows.value+"' value='?' disabled onclick='summaryDefnLookup(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+","+rowNumber+","+noOfRows.value+");clickOK(\""+argSummary+"\",parent.chartComponentListFrame.document.forms[0].summaryColumnCode"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summaryType"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].summary_column"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].default_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].sum_yn"+rowNumber+noOfRows.value+",parent.chartComponentListFrame.document.forms[0].mandatory_yn"+rowNumber+noOfRows.value+",\""+change_trans+"\",parent.chartComponentListFrame.document.forms[0].elementType"+rowNumber+noOfRows.value+")'>";
		//IN039171_reopen ends
		
		var indexNo = eval("parent.chartComponentListFrame.document.ChartComponentListForm.sequenceGrp");
		var rowNumbers = 0;
		var rowNo =0;
		while (rowNumbers < parseInt(indexNo.value))
			{
				var row = eval("parent.chartComponentListFrame.document.ChartComponentListForm.noOfRows"+rowNumbers);
				rowNo = rowNo + parseInt(row.value) + 1
				rowNumbers++;
			}

		var trTextRow = eval(parent.chartComponentListFrame.document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value - 1)));
		var data = eval("parent.chartComponentListFrame.document.forms[0].displaySeqNumber"+rowNumber+".value") + " <input type='hidden' name='panel_desc_msr_id"+rowNumber+noOfRows.value+"' id='panel_desc_msr_id"+rowNumber+noOfRows.value+"' value='"+argSummary+"'> ";

		var insertValue = (rowNo + 1);
	
		if(! (index % 2 == 0))
				classValue =	"gridData"				
			else
				classValue =	"gridData"

		var trTextRow1 = eval(parent.chartComponentListFrame.document.getElementById("trRowId"+rowNumber+parseInt(noOfRows.value-1)));
		var data1 =eval("parent.chartComponentListFrame.document.forms[0].displaySeqNumber"+rowNumber+".value")
		var intermediateVar =parseInt(rowNumber)+""+ parseInt(noOfRows.value - 1)
		var rowsValue=eval("parent.chartComponentListFrame.document.ChartComponentListForm.rowValue"+intermediateVar) ;
		var dummyVariable = rowNumber;
		var rowName = "rowValue"+parseInt(rowNumber)+(parseInt(noOfRows.value));
		var htmlValForDispOrdSeq = '';
		htmlValForDispOrdSeq =data + "<input type='hidden' name='"+rowName+"' id='"+rowName+"' value='"+dummyVariable+"'>"
		var rowvar = parent.chartComponentListFrame.document.getElementById("tabList").insertRow(insertValue);
		rowvar.id = "trRowId"+rowNumber+noOfRows.value
		var cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",order_srl_no);
		cellvar.className= "gridNumericData";
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",discr_msr_id);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",discr_msr_desc);
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",htmlVal);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",sum_yn);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",summary);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",summaryType);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",select_yn);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",mandatory_yn);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",element_type);	
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.insertAdjacentHTML("BeforeEnd",default_yn);			
		cellvar.className=classValue
		cellvar = rowvar.insertCell();
		cellvar.style.display='none'
		cellvar.insertAdjacentHTML("BeforeEnd",htmlValForDispOrdSeq);		
		noOfRows.value = parseInt(noOfRows.value) + 1
	}
}


/****************************Duplicate Summary Values****************************/

function chkDupSummValues(objSumm,rowNum,colNum){
	//IN039171 starts
	//var noofrow = eval("document.forms[0].noOfRows"+rowNum);
	var noofrow = eval("parent.chartComponentListFrame.document.forms[0].noOfRows"+rowNum);
	//IN039171 ends
	for(var indexJ = 0;indexJ < parseInt(noofrow.value);indexJ++){
			//IN039171 starts
			//var trSummVal = eval("document.forms[0].summary_column"+rowNum+indexJ);
			var trSummVal = eval("parent.chartComponentListFrame.document.forms[0].summary_column"+rowNum+indexJ);
			//IN039171 ends
			if(trSummVal.value != ""){
				if(parseInt(colNum)!=indexJ){
					if(trSummVal.value == objSumm.value){
						alert(getMessage("DUPLICATE_SUMMARY_COLUMN","CA"));
						objSumm.select();
						objSumm.value = "";
						return false;
					}
				}
			}
		}
		
}

/*************************************************************************/
function chkAndDisableDef(objMandatory,objDefault,changeAtTrans){
	//alert(objMandatory.value);
	//alert(objDefault.value);
	/*if(objDefault.disabled == false){
		if(objMandatory.checked == true){
			objDefault.checked = true;
			objDefault.disabled = true;
		}	
		else{
			objDefault.checked = false;
			objDefault.disabled = false;
		}
	}*/
	//alert(changeAtTrans);
	if(changeAtTrans != 'N'){
		if(objMandatory.checked == true){
			if(objDefault.disabled == false){
				objDefault.checked = true;
				objDefault.disabled = true;
				//objMandatory.value='Y';
				
			}
		}	
		else{
			objDefault.checked = false;
			objDefault.disabled = false;
			//objMandatory.value='N';
		}
	}
	if(objDefault.checked == true){
		objDefault.value = 'Y';
	}
	else{
		objDefault.value = 'N';
	}
}


//Functions for the file ChartComponentSectionList.jsp-start
var a = new Array();
var i = 0;
var ii = 1;//referred to in the next frame..
var value, element;

function loadNextFrame(resultFrombean)
{
	if(i==0)
	{
		var splitformulaVal = resultFrombean.split('~');
		for(j=1;j<splitformulaVal.length;j++)
		{
		element = splitformulaVal[j-1];
		value = j+"|"+element;
		a[j] = value;
		i=i+1;
		}
	}
}

function dummy()
{
	parent.chartSectionFormulaConstructionFrame.document.location.href = '../../eCA/jsp/ChartComponentFormulaConstruction.jsp';
}


//Functions for the file ChartComponentSectionList.jsp-end


function scrollTitle()
{
	var y = parent.chartSectionComponentListFrame.formulaComponentListForm.document.body.scrollTop;

	if(y == 0){
		parent.chartSectionComponentListFrame.formulaComponentListForm.document.getElementById("divDataTitle").style.position = 'static';
		parent.chartSectionComponentListFrame.formulaComponentListForm.document.getElementById("divDataTitle").style.posTop  = 0;
	}else{
		parent.chartSectionComponentListFrame.formulaComponentListForm.document.getElementById("divDataTitle").style.position = 'relative';
		parent.chartSectionComponentListFrame.formulaComponentListForm.document.getElementById("divDataTitle").style.posTop  = y-2;
	}

}
/****************************Duplicate Element Types ****************************/

function chkDupElementTypes(obj,resType)
{	
	var indexI = parseInt(parent.chartComponentListFrame.document.ChartComponentListForm.sequence.value);
	var indexJ	=parseInt(parent.chartComponentListFrame.document.ChartComponentListForm.sequenceGrp.value);
	var elementType = "";
	var tempElementType = obj.value;
	var noOfRows = 0;
	var j = 0;

	if(obj.value != "##")
	{
		if(resType != "N" && resType != "I" && resType != "A")
		{
			alert(getMessage("ELE_TYPE_NA","CA"));
			obj.value  = "##";
			return false;
		}
		else
		{
			for(j=0;j<indexJ; j++)
			{		
				noOfRows = eval("parent.chartComponentListFrame.document.ChartComponentListForm.noOfRows"+j);
				for(var i=0; i<parseInt(noOfRows.value); i++)
				{
					elementType = eval("parent.chartComponentListFrame.document.ChartComponentListForm.elementType"+j+i);

					if(tempElementType != "##" && obj != elementType)
					{
						if(tempElementType == elementType.value)
						{
							alert(getMessage("DUP_ELE_TYPE","CA"));
							obj.focus();
							return false;
						}
					}
				}
			}
		}
	}
	
	
}

