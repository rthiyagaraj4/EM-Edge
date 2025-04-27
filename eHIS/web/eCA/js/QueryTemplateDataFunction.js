/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
async function getQryDesc()
{
	var txtQry = document.getElementById('qryTxt').value;
	var argArray = new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = "SELECT QUERY_REF code, QUERY_DESC description FROM CA_TEMP_QRY_HDR WHERE EFF_STATUS='E' and  upper(query_ref) like(?) and upper(QUERY_DESC) like upper(?) ORDER BY 2";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = txtQry;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	var retVal = await CommonLookup('Query Template Data Function Search', argArray );
	var frmSet = parent.document.getElementById('qryTemplaetDataFun');

	var ret1=unescape(retVal);
 	var arr=ret1.split(",");
 	
 	if(arr[1]==undefined) {
 		arr[0]="";	
 		arr[1]="";	
	}
	if(retVal != null && retVal != ""){
		document.getElementById('qryTxt').value = arr[1];		
		//frmSet.rows = "5%,*,0";
		parent.QryTempDataCriteriaFrm.location.href='../../eCA/jsp/QueryTemplateDataFunctionCriteriaMain.jsp?qryRef='+ arr[0]+'&qryDesc='+arr[1];
	}
	else
	{
		document.getElementById('qryTxt').value = '';
		//frmSet.rows = "5%,0,0";
	}

}

function getQryDescBytxt()
{	
	var txtQry = document.getElementById('qryTxt').value;
	if(txtQry!= '')
	{
		getQryDesc(txtQry);
	}
	else if(txtQry == '')
	{
		parent.QryTempDataCriteriaFrm.location.href = '../../eCA/jsp/blank.jsp';
		parent.QryTempDataResultFrm.location.href = '../../eCA/jsp/blank.jsp';	
	}
}

function dispCompound(obj)
{
	//alert(obj.name)
	var objName = obj.name;
	var objVal = obj.value
	var cnt =  objName.substring(0, objName.indexOf("_"));
	var cmpName = objName.substring(objName.indexOf("_")+1, objName.length);

	if(cmpName == 'I' || cmpName == 'N' || cmpName == 'A')
	{
		if (objVal == 'BT')
		{
			document.getElementById(cnt+'_txtBetween1').style.display='inline';
			document.getElementById(cnt+'_txtBetween1').value='';
			document.getElementById(cnt+'_txtBetween2').style.display='inline';
			document.getElementById(cnt+'_txtBetween2').value='';
			document.getElementById(cnt+'_imgBetween1').style.display='inline';
			document.getElementById(cnt+'_imgBetween2').style.display='inline';
		}
		else if (objVal !='')
		{
			document.getElementById(cnt+'_txtBetween1').style.display='inline';
			document.getElementById(cnt+'_txtBetween1').value='';
			document.getElementById(cnt+'_imgBetween1').style.display='inline';
			document.getElementById(cnt+'_txtBetween2').style.display='none';
			document.getElementById(cnt+'_imgBetween2').style.display='none';
		}
		else 
		{
			document.getElementById(cnt+'_txtBetween1').style.display='none';
			document.getElementById(cnt+'_txtBetween2').style.display='none';
			document.getElementById(cnt+'_imgBetween1').style.display='none';
			document.getElementById(cnt+'_imgBetween2').style.display='none';
			if (objVal == '')
			{
				var element = document.getElementById(cnt+'_hidden').value;
				saveObjToBean(element, objVal, "REMOVE");
			}
		}

		
	}
	else
	{
		/* Storing the requied values to bean */
		if ( !(cmpName == 'I' || cmpName == 'N' || cmpName == 'A'))
		{
			var element = document.getElementById(cnt+'_hidden').value;

			if(objVal != '')
			{
				saveObjToBean(element, objVal, "ADD");
			}
			else if(objVal == '')
			{
				saveObjToBean(element, objVal, "REMOVE");
			}
		}
		else 
		{
			return false;				
		}
		
	}
}


function saveObjToBeanByTxt(obj)
{
	var objName = obj.name;
	var objVal = obj.value
	var cnt =  objName.substring(0, objName.indexOf("_"));
	var selObj = document.getElementById(cnt+"_I");
	
	if(!selObj)
	{
		selObj = document.getElementById(cnt+"_N");
		if(!selObj)
		{
			selObj = document.getElementById(cnt+"_A");
		}
	}

	if(selObj.value == 'BT')
	{
		var numTxt1 = document.getElementById(cnt+'_txtBetween1').value;
		var numTxtName = document.getElementById(cnt+'_txtBetween1').name;
		var numTxt2 = document.getElementById(cnt+'_txtBetween2').value;
		var element = document.getElementById(cnt+'_hidden').value;

		var selObjVal = selObj.value+'~#'+numTxt1+'~#'+numTxt2;

		if(objName != numTxtName){
			if(objVal != '')
			{
				saveObjToBean(element, selObjVal, "ADD");
			}
		}
	}
	else
	{
		var numTxt1 = document.getElementById(cnt+'_txtBetween1').value;
		var element = document.getElementById(cnt+'_hidden').value;
		var selObjVal = selObj.value+'~#'+numTxt1;

		if(objVal != '')
		{
			saveObjToBean(element, selObjVal, "ADD");
		}
	}
}

function saveObjToBean(obj, objVal, callMode)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	
	xmlStr ="<root><SEARCH ";
	xmlStr += "callMode=\""+ callMode +"\" " ;
	xmlStr += "element=\""+ obj +"\" " ;	
	xmlStr += "elementVal=\""+ objVal +"\" " ;	
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	

	xmlHttp.open( "POST", "QueryTempleteDataPutObject.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function dateChecking(from,to,locale)
{
	if(dateCheck(from,locale) && dateCheck(to,locale))
	{
		if(!isAfter(to.value,from.value,"DMY",locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			to.select();
			to.focus();
			return false;
		}
	}	
}

function dateCheck(obj,locale)
{	
	if(obj.value != '')
	{	
		if(!validDateObj(obj,"DMY",locale))
		{
			return false;
		}
		else
			return true;
	}
}

function search(qryDesc)
{
	var formObj = parent.QryTempDataSerachFrm; 
	var fromDate = formObj.document.getElementById('date_from').value;
	var toDate = formObj.document.getElementById('date_to').value;
	var gender = formObj.document.getElementById('selSex').value;
	var formAge = formObj.document.getElementById('fromAge').value;
	var toAge = formObj.document.getElementById('toAge').value;
	var fromAgeUnit = formObj.document.getElementById('fromSelAgeUnit').value;
	var toAgeUnit = formObj.document.getElementById('toSelAgeUnit').value;
	var selCount = formObj.document.getElementById('selCount').value;
	var frmSet = parent.parent.document.getElementById('qryTemplaetDataFun');	
	var qryRef = formObj.document.getElementById('qryRef').value;
	

	
	if (fromDate == '' && toDate == '')
	{
		alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
		//document.getElementById("date_from").focus();
		return false;
	}
	
	if (fromDate == '')
	{
		alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
		//document.getElementById("date_from").focus();
		return false;
	}

	if (toDate == '')
	{
		alert(getMessage("TO_DATE_NOT_BLANK","CA"));
		//document.getElementById("date_to").focus();
		return false;
	}
	var mandi = true;

	for (var i = 0; i < selCount ; i++ )
	{
		var img1 = formObj.document.getElementById(i+'_imgBetween1');
		var img2 = formObj.document.getElementById(i+'_imgBetween2');

		if (img1 && img2)
		{
			
			var style1 = img1.style.display;
			var style2 = img2.style.display;
			if (style1 != 'none')
			{
				var numTxt1 = formObj.document.getElementById(i+'_txtBetween1').value;				
				
				if (numTxt1 == '')
				{
					//document.getElementById(i+'_txtBetween1').focus();
					alert(getMessage("NUMBER_FIELD_CANNOT_BLANK","CA"));
					mandi = false;
					break;
				}
			}
			if (style2 != 'none')
			{
				var numTxt2 = formObj.document.getElementById(i+'_txtBetween2').value;

				if (numTxt2 == '')
				{
					//document.getElementById(i+'_txtBetween2').focus();
					alert(getMessage("NUMBER_FIELD_CANNOT_BLANK","CA"));
					mandi = false;
					break;
				}
			}			
		}
		else if (img1)
		{
			var numTxt1 = formObj.document.getElementById(i+'_txtBetween1').value;
			var style = img1.style.display;
			if (style != 'none')
			{
				if (numTxt1 == '')
				{
					//document.getElementById(i+'_txtBetween1').focus();
					getMessage("NUMBER_FIELD_CANNOT_BLANK","CA")
					mandi = false;
					break;
				}
			}
		}		
	}


	if (formAge != '' && fromAgeUnit == '')
	{
		var fromAgeUnit = formObj.document.getElementById('fromSelAgeUnit').focus();
		alert(getMessage("AGE_UNIT_NOT_EMPTY","CA"));
		mandi = false;
		return false;
	}

	if (formAge == '' && fromAgeUnit != '')
	{
		var formAge = formObj.document.getElementById('fromAge').focus();
		alert(getMessage("FROM_AGE_NOT_EMPTY","CA"));
		mandi = false;
		return false;
	}

	if(toAge != '' && toAgeUnit == '')
	{
		var toAgeUnit = formObj.document.getElementById('toSelAgeUnit').focus();
		alert(getMessage("AGE_UNIT_NOT_EMPTY","CA"));
		mandi = false;
		return false;
	}

	if (toAge == '' && toAgeUnit != '')
	{
		var toAge = formObj.document.getElementById('toAge').focus();
		alert(getMessage("TO_AGE_NOT_EMPTY","CA"));
		mandi = false;
		return false;
	}


	
	
	//mandi = checkAge();

	if (fromDate != '' && toDate != '' && mandi)
	{
		parent.parent.QryTempDataResultFrm.location.href='../../eCA/jsp/QueryTemplateDataFunctionResultMain.jsp?fromDate='+fromDate+'&toDate='+toDate+'&gender='+gender+'&formAge='+formAge+'&toAge='+toAge+'&qryDesc='+qryDesc+'&qryRef='+qryRef+'&fromAgeUnit='+fromAgeUnit+'&toAgeUnit='+toAgeUnit;
		//frmSet.rows = "5%,0,*";
		parent.parent.document.getElementById("QryTempDataCriteriaFrm").style.height="0vh";
	}
}

function checkAge()
{
	var fromAge = document.getElementById('fromAge').value;
	var toAge = document.getElementById('toAge').value;
	var fromSelAgeUnit = document.getElementById('fromSelAgeUnit').value;
	var toSelAgeUnit = document.getElementById('toSelAgeUnit').value;

	fromAge = parseInt(fromAge);
	toAge = parseInt(toAge) ;
	var ageUnit = 150 * 365;

	if (fromSelAgeUnit != '')
	{
		if(fromSelAgeUnit == 'Y')
		{
			fromAge = fromAge * 365;
		}
		else if (fromSelAgeUnit == 'M')
		{
			fromAge =  fromAge * 30;
		}
		else
		{
			fromAge = fromAge * 1;		
		}
	}

	if (toSelAgeUnit != '')
	{
		if(toSelAgeUnit == 'Y')
		{
			toAge = toAge * 365;
		}
		else if (toSelAgeUnit == 'M')
		{
			toAge =  toAge * 30;
		}
		else
		{
			toAge = toAge * 1;		
		}
	}
	
	
	if (fromAge < 0 || fromAge > ageUnit)
	{
		document.getElementById('fromAge').focus();
		document.getElementById('fromAge').value = '';
		alert(getMessage("AGE_MORE_150_NOT_ALLOWED","CA"));	
		return false;
	}

	if (toAge < 0 || toAge > ageUnit )
	{
		document.getElementById('toAge').focus();
		document.getElementById('toAge').value = '';
		alert(getMessage("AGE_MORE_150_NOT_ALLOWED","CA"));	
		return false;
	}

	if (toSelAgeUnit != '' &&  fromSelAgeUnit != '')
	{
		if (fromAge > toAge)
		{
			document.getElementById('fromAge').value = '';
			document.getElementById('fromSelAgeUnit').selectedIndex = 0; 
			document.getElementById('fromAge').focus();
			alert(getMessage("FROM_AGE_NOT_MORETHAN_TOAGE","CA"));	
			return false;
		}
	}
	
}


function reload(qryRef)
{
	parent.parent.QryTempDataCriteriaFrm.location.href='../../eCA/jsp/QueryTemplateDataFunctionCriteriaMain.jsp?qryRef='+ qryRef;
}

function showCriteria(qryRef, qryDesc)
{
	var frmSet = parent.parent.document.getElementById('qryTemplaetDataFun');
	//parent.parent.QryTempDataCriteriaFrm.location.href='../../eCA/jsp/QueryTemplateDataFunctionCriteriaMain.jsp?qryDesc='+qryDesc+'&qryRef='+ qryRef;
	//frmSet.rows = "5%,*,0";
	parent.parent.document.getElementById("QryTempDataCriteriaFrm").style.height="100vh";
}

function onlyNumbers(event)
{

	
	/*if ((event.keyCode < 48) || (event.keyCode > 57))
			return false;		
	
	return true;*/

	var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;

	if ((charCode < 48) || (charCode > 57))
			return false;

	return true;
	
}

function getExcelSheet(msg)
{
	if (msg== 'callServ')
	{
		formObj = parent.QryTempDataResultFrm.document.getElementById('QueryTemplateDataFunctionResult');
		formObj.submit();
	}
	else
	{
		alert(getMessage("NO_DATA_FOUND","CA"));
		return false;
	}
}

function printDoc(qryDesc,msg)
{
	if (msg== 'callServ')
	{
		var dialogTop	=	"60"; 
		var dialogHeight=	"40" ;
		var dialogWidth	=	"60" ;
		var data		=	new Array();
		var features	=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

		var url = "../../eCA/jsp/QueryTemplateDataFunctionResultPrint.jsp?qryDesc="+qryDesc;
		//window.showModalDialog("../../eCA/jsp/QueryTemplateDataFunctionResultPrint.jsp?qryDesc="+qryDesc,arguments,features);

		window.open(url,'Document','height=570,width=790,top=0,left=0,resizable=no,scrollbars=yes' );  
	}else{
		alert(getMessage("NO_DATA_FOUND","CA"));
		return false;
	}
	
}


function openComponentLookup(obj,comp_name,std_comp_id,lookup_url)
{		
	var objName = "";
	var flag = true;
	if (obj.name.substring(0,3) == "btn")
	{
		objName = obj.name.substring(3,obj.name.length);	
	}else {
		objName = obj.name;
		if (obj.value == "")
		{
			flag = false;
		}
	}
	
		var cnt =  objName.substring(0, objName.indexOf("_"));
		var element = document.getElementById(cnt+'_hidden').value;
	
	if (flag)
	{	
		//var cnt =  objName.substring(0, objName.indexOf("_"));
		//var element = document.getElementById(cnt+'_hidden').value;
		var returnArray		=	new Array();
		var dialogHeight	=	"25" ;
		var dialogWidth		=	"50" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+";scroll=yes;status:" + status;
		returnArray		= window.showModalDialog(lookup_url+"?std_comp_id="+std_comp_id+"&title="+comp_name,arguments,features);
		if (returnArray != null && returnArray != undefined)
		{
			document.getElementById(objName).value = returnArray[1];				
			saveObjToBean(element, returnArray[1], "ADD");
		}else {
			document.getElementById(objName).value = "";
			 saveObjToBean(element, "", "REMOVE");
		}
	}else{
		
		document.getElementById(objName).value = "";
		saveObjToBean(element, "", "REMOVE");
	}
}
//IN057467 Start.
function storeChkVal(obj){
	var objName = obj.name;
	var cnt =  objName.substring(0, objName.indexOf("_"));
	var compId = document.getElementById(cnt+'_Date').value;
	if(obj.checked){
		obj.value="Y";
		var resType = document.getElementById(cnt+'_resultType').value;
		var fDate = document.getElementById('DF'+cnt+'_'+resType).value;
		var tDate = document.getElementById('DT'+cnt+'_'+resType).value;		
		if(fDate=="" && tDate==""){
			alert("Please select date.");
			obj.checked = false;
			return false;
		}
	}else{
		obj.value="N";
	}	
	var objVal = obj.value;
	saveObjToBean(compId, objVal, "COMPCHK");
}
function dateCheckingDF(from,to,locale)
{	
	chekBoxValidation(from,to);
	if(dateCheck(from,locale) && dateCheck(to,locale))
	{ 
		if(!isAfter(to.value,from.value,"DMY",locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			to.select();
			to.focus();
			return false;
		}
	}
	dispCompoundNew(from);
}
function dateCheckingDT(from,to,locale)
{	
	chekBoxValidation(from,to);
	if(dateCheck(to,locale)&& dateCheck(from,locale) )
	{
		if(!isAfter(to.value,from.value,"DMY",locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			to.select();
			to.focus();
			return false;
		}
	}
	dispCompoundNew(to);
}
function chekBoxValidation(obj,obj1){
	var objName = obj.name;
	var cnt =  objName.substring(2, objName.indexOf("_"));
	if(obj.value=="" && obj1.value==""){
		document.getElementById(cnt+'_CHKDate').checked = false;
		document.getElementById(cnt+'_CHKDate').value = "N";
	}
}
function dispCompoundNew(obj)
{
	var objName = obj.name;
	var objVal = obj.value;
	var cnt =  objName.substring(2, objName.indexOf("_"));
	var cmpName = objName.substring(objName.indexOf("_")+1, (objName.length));
	var dateType= objName.substring(0, 2);
	var compId = document.getElementById(cnt+'_Date').value;
	if(cmpName == 'D' || cmpName == 'E')	
	{	
		var element = document.getElementById(cnt+'_hidden').value;
		saveObjToBeanNew(element, objVal, compId, dateType, "ADDDT");
	}
}
function saveObjToBeanNew(obj, objVal, objId, dateType, callMode)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	
	xmlStr ="<root><SEARCH ";
	xmlStr += "callMode=\""+ callMode +"\" " ;
	xmlStr += "element=\""+ obj +"\" " ;	
	xmlStr += "elementVal=\""+ objVal +"\" " ;
	xmlStr += "elementId=\""+ objId +"\" " ;
	xmlStr += "elementType=\""+ dateType +"\" " ;	
	xmlStr +=" /></root>" ;		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	

	xmlHttp.open( "POST", "QueryTempleteDataPutObject.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;	
	eval(responseText);
}
//IN057467 End.
