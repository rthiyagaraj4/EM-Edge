/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
?           100				?				created
05/12/2017	IN065683		Ramesh G								After create vaccine category as age specific, System 																		automatically add this vaccine category in manage 																			immunization for all patients.
------------------------------------------------------------------------------------------------------------------------------------
*/
var flag="false";
function scrollTitle()
{
	  var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
				//	document.getElementById("divDataTitle").style.position = 'static';
				//	document.getElementById("divDataTitle").style.posTop  = 0;
	  }
	  else
	  {
			//	document.getElementById("divDataTitle").style.position = 'relative';
			//	document.getElementById("divDataTitle").style.posTop  = scrollXY;
	 }
}
/*
   Function Name : checkSequence(objSequence)
	Description :		The Function is Used For Validating Non Zero Entries
   @param objSequence  is Text Object Itself
  */
function checkSequence(objSequence)
{
	var errorMessage =""
	 if(parseInt(objSequence.value,10) <= 0)
			{
				errorMessage= messageArray["SEQUENCE_NOT_ZERO"];
				alert(getMessage(errorMessage,"CA"));
				objSequence.value=''
				objSequence.select()
				return false
			}
	 if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
			{
				errorMessage= messageArray["SEQUENCE_NOT_ZERO"];
				alert(getMessage(errorMessage,"CA"));
				objSequence.value=''
				objSequence.select()
				return false
			}

}
/*
	Function Name :  removeRow(objIndex)
	Description :  The Function is Used For ConCatenation  and Splitting  a String of Text Fields Values and TD Data and also based upon the  status of the CheckBox
    @param objIndex  Index of the Dynamically Created HTML Object
  */
function removeRow(obj, vaccineId, vaccineDesc)
{

	var msg = getMessage("REMOVE_SCHEDULE","CA")
	msg = msg.replace('$', vaccineDesc);
	var confirmFlag = confirm(msg);

	if (confirmFlag)
	{
		var xmlStr = "";
		var categoryId = parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
		var CallFrom = "RemoveVaccineFormSchedule";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "vaccineId=\""+ vaccineId +"\" " ;
		xmlStr += "categoryId=\""+ categoryId +"\" " ;
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);

		var length = parent.VaccinesForCategoryBottomFrame.document.vaccinesForCategoryDtlForm.sequence.value;
		for(index = 0; index < length ;index++)
		{	
			var vaccineCodeDtl = eval("parent.VaccinesForCategoryBottomFrame.document.vaccinesForCategoryDtlForm.vaccineCode"+index);
			var selectYNDtl = eval("parent.VaccinesForCategoryBottomFrame.document.vaccinesForCategoryDtlForm.select_yn"+index);

			if(vaccineCodeDtl.value == vaccineId)
			{
				selectYNDtl.checked = false
			}			
		}
		if (document.vaccinesForCategoryResultForm)
		{
			document.vaccinesForCategoryResultForm.categoryId.value=parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
			document.vaccinesForCategoryResultForm.method ='post'
			document.vaccinesForCategoryResultForm.action ='VaccinesForCategoryList.jsp?tempValue=temp';
			document.vaccinesForCategoryResultForm.submit();
		}
		else
		{
			parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.categoryId.value=parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
			parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.method ='post'
			parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.action ='VaccinesForCategoryList.jsp?tempValue=temp';
			parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.submit();
		}
	}else
	{
		obj.checked = true;	
	}
	
}
/*
    Function Name :  stringConCatenate(objIndex,objRowId)
	Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
   @param objIndex  Index of the Dynamically Created HTML Object
    @param objRow  is the  ID for the Table Row  Dynamically Created 
 */
function stringConCatenate(obj, vaccineId, vaccineDesc)
{
	if (obj.checked)
	{	
		var xmlStr = "";
		var CallFrom = "AddVaccineToSchedule";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "vaccineId=\""+ vaccineId +"\" " ;
		xmlStr += "vaccineDesc=\""+ vaccineDesc +"\" " ;
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);

		var categoryId = parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
		parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.method ='post'
		parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.action ='VaccinesForCategoryList.jsp?tempValue=temp&categoryId='+categoryId;
		parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.submit();
	}
	else
	{
		removeRow(obj, vaccineId, vaccineDesc);			
	}	
}
/*
    Function Name :  create()
	Description :	The Function is Used For loading  Function
 */
function create()
{
	  f_query_add_mod.location.href = '../../eCA/jsp/VaccinesForCategoryFrameSet.jsp'
}
/*
    Function Name :  apply()
	Description :	The Function is Used For inserting updating the Records with  the Database
 */
function apply()
{
	var seqArray = new Array();
	var indexI;
	var indexJ;
	var finalString = "";
	var length  = 0;

	if (f_query_add_mod.VaccinesForCategoryHeaderFrame)
	{
		var fields = new Array (f_query_add_mod.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode);
		var names = new Array(getLabel("Common.category1.label",'COMMON'));
		
		if(f_query_add_mod.VaccinesForCategoryHeaderFrame.checkFieldsofMst( fields, names, messageFrame ))
		{

		 if(f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm != null)
		 {
				length = f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.array_length.value;
				
				for (var index1 = 2 ;index1 < length;index1++ )
				{
					//;eval("f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.mandatoryYN_"+index1);
					var prvAdm_YN = eval("f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.prvAdmYN_"+index1);
					var chkDays = eval("f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.chk_dup_days_"+index1);

					var duration_1 = eval("f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.duration_s"+index1);
					var duration_type = eval("f_query_add_mod.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.duration_type_s"+index1);
					
					/*if (mandatory_YN.checked)
					{
						mandatory_YN.value = "Y";
					}else {
						mandatory_YN.value = "N";
					}*/				
				
					if (prvAdm_YN.checked)
					{
						prvAdm_YN.value = "Y";
					}else {
						prvAdm_YN.value = "N";
					}				
					if ((prvAdm_YN.checked) && chkDays.value == "")
					{				
						var message  = getMessage("PREVIOUS_ADM_CHECK","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						return false ;					
					}
								
				}// for end

				var xmlStr = "";
				var colName = "";
				var vaccineCnt = "";
				var mandatory_YN = 'N';
				var CallFrom = "checkVacccineSchedules";
				xmlStr ="<root><SEARCH ";
				xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
				var tbl = f_query_add_mod.VaccinesForCategoryMiddleFrame.document.querySelector('#dataTitleTable1');
				var allRows = tbl.getElementsByTagName("tr");
				if (allRows.length <= 2)
				{
					var error =getMessage("ATLEAST_ONE_SELECTED","Common");
					error = error.replace('record',getLabel("Common.Vaccine.label","Common"));
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&error_value=0";
					return false
				}
				
				var categoryId = f_query_add_mod.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
				var mapRowCnt = 0;

				xmlStr += "vaccineCnt=\""+ (allRows.length - 2) +"\" " ;
				xmlStr += "categoryId=\""+ categoryId +"\" " ;
			//	alert('allRows.length  '+allRows.length);
					
				for (var row=2;row < allRows.length ;row++ )
				{	
					allRows[row].id="trRowId_"+parseInt(row);
					xmlStr += "orderSqeNo"+mapRowCnt+"=\""+ row +"\" " ;
					xmlStr += "Mandatory"+mapRowCnt+"=\""+ mandatory_YN +"\" " ;
					
					var cInp = allRows[row].getElementsByTagName('input');//the inputs' collection of the 1st row 
					var cSel = allRows[row].getElementsByTagName('select'); // the select collection of the 1st row

					for(var i=0;i<cInp.length;i++)
					{	
						colName = cInp[i].getAttribute('name');
						colName = colName.substring(0,colName.lastIndexOf("_"));

						if (colName == "vaccineId")
						{
							xmlStr += "vaccineId"+mapRowCnt+"=\""+ cInp[i].getAttribute('value') +"\" " ;						
						}
						else if (colName == "num_of_doses")
						{
							xmlStr += "noDoeses"+mapRowCnt+"=\""+ cInp[i].getAttribute('value') +"\" " ;						
						}
						/*else if(colName == "mandatoryYN")
						{
								commented which 
						}*/
						else if(colName == "prvAdmYN")
						{
							xmlStr += "checkPrevAdministered"+mapRowCnt+"=\""+ cInp[i].getAttribute('value') +"\" " ;	
						}
						else if(colName == "chk_dup_days")
						{
							xmlStr += "checkPrevDays"+mapRowCnt+"=\""+ cInp[i].getAttribute('value') +"\" " ;	
						}
					

					} 

					for (var j=0;j<cSel.length;j++ )
					{
						colName = cSel[j].getAttribute('name');
						colName = colName.substring(0,colName.lastIndexOf("_"));
						if (colName == "default_site_name")
						{
							xmlStr += "defaultSite"+mapRowCnt+"=\""+ cSel[j].getAttribute('value') +"\" " ;						
						}
						else if(colName == "chk_prv_action")
						{
							xmlStr += "checkPrevAction"+mapRowCnt+"=\""+ cSel[j].getAttribute('value') +"\" " ;	
						}			
					}
					
					mapRowCnt++;
				}		

				xmlStr +=" /></root>" ;		
				
				var xmlHttp = new XMLHttpRequest() ;
				var xmlDoc = "" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				eval(responseText);
			} // inner IF end
			else
			{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				return false;
			}
		}//outer if end
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=2';
	}

	
}

/*
    Function Name :  onSuccess()
	Description :	It is Called when Success Transaction is Done with the Database
 */
function onSuccess()
{
		f_query_add_mod.VaccinesForCategoryHeaderFrame.location.href='../../eCA/jsp/VaccinesForCategoryHdr.jsp'
	f_query_add_mod.VaccinesForCategoryMiddleFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.VaccinesForCategorySearchFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.VaccinesForCategoryBottomFrame.location.href='../../eCommon/html/blank.html'
}
/*
    Function Name :  reset()
	Description :	Used to reset the Function
 */
function reset()
{
	if (f_query_add_mod)
	{
		f_query_add_mod.location.reload();
	}
	return false;	
}

/*
    Function Name :  populateValues()
	Description :	Used to Search Criteria for the Vaccine Description of the Vaccine For Category Function
 */
 function populateValues()
 {
	 var searchText = document.vaccinesForCategorySearchForm.searchtext.value;
	 var categoryId = parent.VaccinesForCategoryHeaderFrame.document.vaccinesForCategoryHeaderForm.categoryCode.value;
	  //parent.VaccinesForCategoryMiddleFrame.location.href = '../../eCA/jsp/VaccinesForCategoryList.jsp?categoryDesc='+searchText+'&categoryId='+categoryId;
	 parent.VaccinesForCategoryBottomFrame.location.href = '../../eCA/jsp/VaccinesForCategoryDtl.jsp?categoryDesc='+searchText+'&categoryId='+categoryId;
 }

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	



/*
    Function Name :  CheckForSpecialCharacter(ObjText)
	Description :	The Function is Used For restricting Special Chracters in the Text Box
   @param ObjText  Text Box Object
 */
function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}
/*
    Function Name :  searchVaccinesForCategory()
	Description :	The Function is Used For Providing Search Criteria for selected Vaccines For Category
   
 */

function searchVaccinesForCategory()
{
	var searchText = document.vaccinesForCategoryHeaderForm.categoryDesc;
	
	
	if(searchText.value=="")
	{
		var errorMsg = getMessage("CATEGORY_CANNOT_BLANK","CA");
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}
	else
	{
		document.vaccinesForCategoryHeaderForm.buttonCategory.disabled = true;
		document.vaccinesForCategoryHeaderForm.categoryDesc.disabled = true;	

		var xmlStr = "";
		var CallFrom = "clearScheduleVaccineDose";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;			
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert('clearScheduleVaccineDose form js');
		xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	
		
		/*var categoryId = document.vaccinesForCategoryHeaderForm.categoryCode.value;			
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.VaccinesForCategorySearchFrame.location.href='../../eCA/jsp/VaccinesForCategorySearch.jsp';
		parent.VaccinesForCategoryBottomFrame.location.href='../../eCA/jsp/VaccinesForCategoryDtl.jsp?categoryId='+categoryId;
		window.setTimeout("", 9000);
		parent.VaccinesForCategoryMiddleFrame.location.href = '../../eCA/jsp/VaccinesForCategoryList.jsp?categoryId='+categoryId;
		*/			
	}
}



/*
    Function Name :  CheckForSpecialCharacter(Object)
	Description :	The Function is Used For restricting Special Chracters in the Text Box
   @param Object  Used to Check whether this Object is Button or TextBox
 */
function getCategoryCode(objCode)
{
	if(objCode.name=='categoryDesc' && objCode.value != '')
	{		
		//categoryCode(objCode)
		callFunctionButton()
		
	}
	else if(objCode.name=='categoryDesc' && objCode.value == '')
	{		
		document.vaccinesForCategoryHeaderForm.flag.value ='true';
		
	}
	if(objCode.name=='buttonCategory')
	{
		if(document.vaccinesForCategoryHeaderForm.flag.value=='false')
			return false
		else
			callFunctionButton()
	}
			
}
/*
    Function Name :  categoryCode(objCode)
	Description :	It is a  Obtaining Code And Description  of Category Function
	@param objCode Text Value is Passed to the Look Up Function 
 */
 function categoryCode(objCode)
{
	var category = objCode.value;	
	if(category == '')
	{		
		document.vaccinesForCategoryHeaderForm.flag.value='true'
		return false
	}
	else
	{				
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.VaccinesForCategoryMiddleFrame.location.href='../../eCommon/html/blank.html'
		parent.VaccinesForCategorySearchFrame.location.href='../../eCommon/html/blank.html'
		parent.VaccinesForCategoryBottomFrame.location.href='../../eCommon/html/blank.html'
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='VaccinesForCategoryIntermediate.jsp'><input type=hidden name='categoryCode' id='categoryCode' value='"+category+"'></form></body></html>";
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempform.submit();
	}
}
/*
    Function Name :  callFunction(sql,title,target)
	Description :	It is a  Obtaining Code And Description  of Chart Function from Common Look Up 						Feature
	@param objCode Text Value is Passed to the Look Up Function 
	@sql  Query to be passed to the Common Look Up
	@target Text Object Value
 */

 async function callFunction(sql,title,target)
{	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	title = getLabel('Common.category1.label','COMMON');
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
 }
/*
    Function Name :  callFunctionButton()
	Description :	It is a  Obtaining Code And Description  of Category Function from Common Look Up 						Feature
 */
 async function  callFunctionButton()
{
	
	var sql = "Select VACC_CATEG_ID code, SHORT_DESC description from CA_IM_VAC_CATEG a where eff_status='E' and upper(VACC_CATEG_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) AND NOT EXISTS (SELECT 1 FROM ca_im_param WHERE vacc_categ_id = a.vacc_categ_id) order by 2 ";
	var title = getLabel('Common.category1.label','COMMON');

	var target = document.vaccinesForCategoryHeaderForm.categoryDesc;	
	//target.value='';
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
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;	
	retArray =await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	
	if(retArray != null && retArray !="")	
	{
		document.vaccinesForCategoryHeaderForm.categoryDesc.value = arr[1];
		document.vaccinesForCategoryHeaderForm.categoryCode.value = arr[0];
					
	}
	else
	{
		document.vaccinesForCategoryHeaderForm.categoryDesc.value = '';
		document.vaccinesForCategoryHeaderForm.categoryCode.value = '';
	}
		document.vaccinesForCategoryHeaderForm.flag.value='true'

}

function resetValues()
{
	//(var i=0;i<5;i++){}

	parent.VaccinesForCategoryMiddleFrame.location.href='../../eCommon/html/blank.html'
	parent.VaccinesForCategorySearchFrame.location.href='../../eCommon/html/blank.html'
	parent.VaccinesForCategoryBottomFrame.location.href='../../eCommon/html/blank.html'
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
	
}
function setValue()
{
	document.vaccinesForCategoryHeaderForm.flag.value='false'
}


function getCategoryCodeOnClick(objCode)
{
	if(objCode.name=='categoryDesc')
	{
		categoryCode(objCode);
	}		
}

function changeSeq(obj)
 {		
	index = obj.parentNode.parentNode.rowIndex;		
	var colCnt = document.getElementById("dataTitleTable").rows[index].cells.length;
	var w = "";
	var s = document.vaccinesForCategoryResultForm.firstPos.value;
	if ( s == "")
	{
		document.vaccinesForCategoryResultForm.firstPos.value = index-1;
		for(i=0; i <colCnt; i++)
		{
			if (i == 0)
			{
				document.getElementById("dataTitleTable").rows[index].cells[i].className='selectedNumericData';
			}
			else
			{
				document.getElementById("dataTitleTable").rows[index].cells[i].className='selectedRow';
			}
			 
		}

	}else{
		s = parseInt(s);
		for(i=0; i <colCnt; i++)
		{
			if (i == 0)
			{
				document.getElementById("dataTitleTable").rows[s+1].cells[i].className='gridNumericData';
			}
			else
			{
				document.getElementById("dataTitleTable").rows[s+1].cells[i].className='gridData';
			}
			 
		}
	
		w = index-1;
		if (!s || isNaN(s) || !w || isNaN(w) || s == w) return false;
		exchange(s,w,document.getElementById("dataTitleTable"));

	}
	
}

function reloadSecFrame(cunt,slno)
{   


	//var finalString = document.vaccinesForCategoryResultForm.finalString.value;
	
	if(document.vaccinesForCategoryResultForm.firstPos.value != "")
	{
		
		document.vaccinesForCategoryResultForm.secPos.value = slno;
		var categoryId = document.vaccinesForCategoryResultForm.categoryId.value;
		var firstPos = document.vaccinesForCategoryResultForm.firstPos.value;		
		exchange(firstPos, slno, document.getElementById("dataTitleTable"));
		/*var secPos = document.vaccinesForCategoryResultForm.secPos.value;
		var rowCount = document.vaccinesForCategoryResultForm.array_length.value;	
		var tdText ;var index;
		var rowCount = document.vaccinesForCategoryResultForm.array_length.value;	
		var tdText ;
		alert('firstPos '+firstPos+", "+slno)
	//	parent.VaccinesForCategoryMiddleFrame.location.href = "../../eCA/jsp/VaccinesForCategoryList.jsp?firstPosition="+document.vaccinesForCategoryResultForm.firstPos.value+"&secondPosition="+document.vaccinesForCategoryResultForm.secPos.value+"&operation=split&rowCount="+rowCount+"&flag_for_list=true&finalString="+finalString+"&categoryId="+categoryId;*/
		
	}
}

async function showSchedulePopup(obj)
{	
	var noofDoses = "";
	var mandatoryYN = "";
	var vaccineId = "";
	var colName = obj.name;
	var rowCount = colName.substring(colName.lastIndexOf("_")+1,colName.length);	
	rowCount = parseInt(rowCount);
	var categoryId = document.getElementById('categoryId').value;	
	var returnVal = "";	
	var title = getLabel('eCA.VaccinationSchedule.label','CA');	
	var oTable = document.getElementById("dataTitleTable")
	var allRows = oTable.getElementsByTagName("tr");
	var cInp = allRows[rowCount].getElementsByTagName('input');
	
	for(var i=0;i<cInp.length;i++)
	{			
		colName = cInp[i].getAttribute('name');		
		colName = colName.substring(0,colName.lastIndexOf("_"));				
		if (colName == "num_of_doses")
		{
			noofDoses = cInp[i].value;				
		}else if (colName == "vaccineId")
		{
			vaccineId = cInp[i].value;	
		}else if (colName == "mandatoryYN")
		{
			mandatoryYN = cInp[i];	
		}
	
	} 
	var mandatoryYN1 = "";
	if (mandatoryYN.checked)
	{
		mandatoryYN1 = "Y";
		
	}else{
		mandatoryYN1 = "N";
	}	
	var dialogHeight= "350px" ;
    var dialogWidth = "80%" ;
    var status = "no";
	var dialogArguments = new Array();
	dialogArguments[0] = title;	
	
	var dialogUrl       = "../../eCA/jsp/VaccinesSchForCategoryPopup.jsp?categoryId="+categoryId+"&vaccineId="+vaccineId+"&rowCount="+noofDoses+"&mandatoryYN="+mandatoryYN1;//+"&freq_duration="+freq_duration1.value;
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	
	returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
	
	if (returnVal != null && returnVal != undefined && returnVal != '')
	{
		document.getElementById("adhocAgeSpecYN").value = returnVal
	}	
}

function addVaccineDuration(){
	var rowCount = document.forms[0].array_length.value;
	var seqNo = "";
	var duration = "";
	var durationType = "";
	var mandatory = "";
	var defaultC = "";
	var returnVal = "";
	var delimit = "";
	var txtYrs = "";
	var txtMonths = "";
	var txtDays = "";	
	var durArray = new Array (rowCount);
	var durTypeArray = new Array (rowCount);
	var dueArray = new Array (rowCount);
	var elapsedArray = new Array (rowCount);
	var years = new Array (rowCount);
	var months = new Array (rowCount);
	var days = new Array (rowCount);

	var adhocAgeSpecYN = document.getElementById("adhocAgeSpecYN").value;
	var vaccineId = document.getElementById("vaccineId").value;

	var isAgeSpecific = true;	
	for (index=0;index < rowCount;index++ )
	{
		durArray[index] = eval(document.getElementById('duration'+index));
		durTypeArray[index]	= eval(document.getElementById('duration_type'+index));	
		dueArray[index]	= eval(document.getElementById('txtDueduration'+index));		
		elapsedArray[index]	= eval(document.getElementById('txtElapsed'+index));
		years[index]	= eval(document.getElementById('txtYear'+index));	
		/*isAgeSpecific = checkAgeSpecific(eval("vaccinesForCatSchPopupForm.document.forms[0].txtYear"+index), "Y");
		if (!isAgeSpecific)
		{
			break;
		}*/
		months[index]	= eval(document.getElementById('txtMonth'+index));	
		/*isAgeSpecific = checkAgeSpecific(eval("vaccinesForCatSchPopupForm.document.forms[0].txtMonth"+index), "M");
		if (!isAgeSpecific)
		{
			break;
		}*/
		days[index]	= eval(document.getElementById('txtDay'+index));		
		isAgeSpecific = checkAgeSpecific(eval(document.getElementById('txtDay'+index), "D"));
		if (!isAgeSpecific)
		{
			break;
		}		
	}

	if (!isAgeSpecific)
	{
		return false;
	}

	if (adhocAgeSpecYN == "N")
	{
		for (index1=0;index1<durArray.length ;index1++ )
		{		
			if ((durArray[index1].value == "") || (durTypeArray[index1].value == ""))
			{
				alert(getMessage("DURATION_CANNOT_BLANK","CA"));				
				return false;
			}
		}		
	}
	else if (adhocAgeSpecYN == "Y")
	{
		for (index1=0;index1<durArray.length ;index1++ )
		{		
			if ((years[index1].value == "") && (months[index1].value == "") && (days[index1].value == "") )
			{
				//alert(getMessage("DAY_MON_YEAR_ZERO","CA"));				
				alert(getMessage("APPLICABLE_AGE_EMPTY","CA"));				
				return false;
			}
		}
	}	
	if (adhocAgeSpecYN == "Y")
	{
	
		for (index2=0;index2<dueArray.length ;index2++ )
		{
			if ((dueArray[index2].value == "") || document.getElementById("selDueduration_type"+index2).value == '')
			{
				alert(getMessage("DUE_BEFORE_NOT_EMPTY","CA"));				
				return false;
			}
			else if ((dueArray[index2].value == "") || document.getElementById("selDueduration_type"+index2).value == '')
			{
				alert(getMessage("DUE_BEFORE_NOT_EMPTY","CA"));				
				return false;
			}		
		}

		for (index2=0;index2<elapsedArray.length ;index2++ )
		{
			if ((elapsedArray[index2].value == "") || document.getElementById("selElapsedduration_type"+index2).value == '')
			{
				alert(getMessage("ELAPSED_AFTER_NOT_EMPTY","CA"));				
				return false;
			}
			else if ((elapsedArray[index2].value == "") || document.getElementById("selElapsedduration_type"+index2).value == '')
			{
				alert(getMessage("ELAPSED_AFTER_NOT_EMPTY","CA"));				
				return false;
			}		
		}
	}
	else
	{
		for (index2=0;index2<dueArray.length ;index2++ )
		{
			if ((dueArray[index2].value != "") && document.getElementById("selDueduration_type"+index2).value == '')
			{
				alert(getMessage("DUE_BEFORE_NOT_EMPTY","CA"));				
				return false;
			}
			else if ((dueArray[index2].value == "") && document.getElementById("selDueduration_type"+index2).value != '')
			{
				alert(getMessage("DUE_BEFORE_NOT_EMPTY","CA"));				
				return false;
			}		
		}

		for (index2=0;index2<elapsedArray.length ;index2++ )
		{
			if ((elapsedArray[index2].value != "") && document.getElementById("selElapsedduration_type"+index2).value == '')
			{
				alert(getMessage("ELAPSED_AFTER_NOT_EMPTY","CA"));				
				return false;
			}
			else if ((elapsedArray[index2].value == "") && document.getElementById("selElapsedduration_type"+index2).value != '')
			{
				alert(getMessage("ELAPSED_AFTER_NOT_EMPTY","CA"));				
				return false;
			}		
		}


	}
	if (adhocAgeSpecYN == "Y")
	{
		for (index1=0;index1<durArray.length ;index1++ )
		{		
			for (var i = index1+1; i <durArray.length; i++)
			{
				if ( (years[index1].value == years[i].value) && (months[index1].value == months[i].value) && (days[index1].value == days[i].value))
				{
					alert(getMessage("DURATION_DUPLICATE_CHECK","CA"));	
					return false;
				}
			}
		}
	}
	else if(adhocAgeSpecYN == "N")
	{
		for (index2=0;index2<durArray.length ;index2++ )
		{
			for (index3=index2+1;index3<durArray.length ;index3++ )
			{			
				if ((durArray[index2].value == durArray[index3].value) && (durTypeArray[index2].value == durTypeArray[index3].value))
				{
					alert(getMessage("DURATION_DUPLICATE_CHECK","CA"));
					return false;
				}

			}
		}
	}

	if(adhocAgeSpecYN == "Y")
	{
		duration = "";
	    durationType = "";
	}

	var duplicateYN = document.getElementById("duplicateYN").value;
	var duplicateDays = document.getElementById("duplicateDays").value;
	var duplicateAction = document.getElementById("duplicateAction").value;
	var isAdhocAgeSpec = document.getElementById("isAdhocAgeSpec").value;
	var categoryId = document.getElementById("categoryId").value;
	
	var xmlStr = "";
	var CallFrom = "VaccineScheduleDose";
	xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
	xmlStr += "vaccineId=\""+ vaccineId +"\" " ;
	xmlStr += "duplicateYN=\""+ duplicateYN +"\" " ;
	xmlStr += "duplicateDays=\""+ duplicateDays +"\" " ;
	xmlStr += "duplicateAction=\""+ duplicateAction +"\" " ;
	xmlStr += "isAdhocAgeSpec=\""+ isAdhocAgeSpec +"\" " ;
	xmlStr += "categoryId=\""+ categoryId +"\" " ;
	xmlStr += "rowCount=\""+ rowCount +"\" " ;

	for(var i=0;i<rowCount;i++)
	{
		if (i > 0)
		{
			delimit = '|';
		} 	
		if (adhocAgeSpecYN == "N")
		{
			//duration = eval("document.forms[0].duration"+i+".value");
			duration = eval(document.getElementById('duration'+i)).value;  	
			durationType = eval(document.getElementById('duration_type'+i)).value;		

			if (eval(document.getElementById('mandatoryYN'+i)).checked)
			{
				mandatory = "Y";
			}else {
				mandatory = "N";
			} 
			if (eval(document.getElementById('defaultCU'+i)).checked)
			{
				defaultC = "C";
			}else {
				defaultC = "U";
			} 

			xmlStr += "duration"+i+"=\""+ duration +"\" " ;
			xmlStr += "durationType"+i+"=\""+ durationType +"\" " ;
			xmlStr += "mandatory"+i+"=\""+ mandatory +"\" " ;
			xmlStr += "defaultC"+i+"=\""+ defaultC +"\" " ;
			xmlStr += "Yrs"+i+"=\""+ txtYrs +"\" " ;
			xmlStr += "Months"+i+"=\""+ txtMonths +"\" " ;
			xmlStr += "Days"+i+"=\""+ txtDays +"\" " ;

		}
		else if(adhocAgeSpecYN == "Y")
		{
			txtYrs = eval(document.getElementById('txtYear'+i)).value;		
		    txtMonths = eval(document.getElementById('txtMonth'+i)).value;		
		    txtDays = eval(document.getElementById('txtDay'+i)).value;
			mandatory = "N";
			defaultC = "U";
			//IN065683 Start.
			if (eval(document.getElementById('mandatoryYN'+i)).checked)
			{
				mandatory = "Y";
			}else {
				mandatory = "N";
			} 
			if (eval(document.getElementById('defaultCU'+i)).checked)
			{
				defaultC = "C";
			}else {
				defaultC = "U";
			} 
			//IN065683 End.
			xmlStr += "Yrs"+i+"=\""+ txtYrs +"\" " ;
			xmlStr += "Months"+i+"=\""+ txtMonths +"\" " ;
			xmlStr += "Days"+i+"=\""+ txtDays +"\" " ;
			xmlStr += "mandatory"+i+"=\""+ mandatory +"\" " ;
			xmlStr += "defaultC"+i+"=\""+ defaultC +"\" " ;
			xmlStr += "duration"+i+"=\""+ duration +"\" " ;
			xmlStr += "durationType"+i+"=\""+ durationType +"\" " ;
		}

		seqNo = eval(document.getElementById('seq_num'+i)).value;			
		txtDue = eval(document.getElementById('txtDueduration'+i)).value;  		
		txtElapsed = eval(document.getElementById('txtElapsed'+i)).value;		
		elapsedType = eval(document.getElementById('selElapsedduration_type'+i)).value;
		dueType = eval(document.getElementById('selDueduration_type'+i)).value;

		//xmlStr += "seqNo"+i+"=\""+ seqNo +"\" " ;
		xmlStr += "Due"+i+"=\""+ txtDue +"\" " ;
		xmlStr += "elapsed"+i+"=\""+ txtElapsed +"\" " ;
		xmlStr += "elapsedType"+i+"=\""+ elapsedType +"\" " ;
		xmlStr += "dueType"+i+"=\""+ dueType +"\" " ;
		
	}
	
		
	xmlStr +=" /></root>" ;		
//	alert(xmlStr);
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	if (responseText.indexOf("DUPLICATE_CHECK") != -1)
	{
		alert(getMessage('VACCINE_ALLREADY_DEFINED','CA'))
	}
	else
	{
		eval(responseText);
		window.returnValue = adhocAgeSpecYN;
		const dialogTag = parent.document.getElementById("dialog_tag");
		      dialogTag.close();
	}
	//eval(responseText);
	/*var retArr = new Array(2);
	retArr[0] = returnVal;
	retArr[1] =  adhocAgeSpecYN;*/
	
}

function chkMandatory(objVal,rowCount,disImg, vaccineId)
{
	var chkPrvDayImg;
	var rowField;
	var prevAdminYN = 'N';

	if (objVal.checked)
	{		
		chkPrvDayImg = document.getElementById(disImg+""+rowCount);
		chkPrvDayImg.style.visibility='visible';		
		chkPrvDayImg.style.display='inline';
		prevAdminYN = 'Y';
	}else
	{		
		chkPrvDayImg = document.getElementById(disImg+""+rowCount);		
		chkPrvDayImg.style.visibility='hidden';		
		chkPrvDayImg.style.display='none';	
	}

	setValueToBean('AddPrevAdminYN', 'prevAdminYN', prevAdminYN, vaccineId);	
}

function chkDurMandatory(objVal,rowCount,disImg)
{
	var chkDurImg;
	var rowField;

	if ((objVal.value != "") && (parseInt(objVal.value) >=1))
	{		
		chkDurImg = document.getElementById(disImg+""+rowCount);	
		chkDurImg.style.visibility='visible';		
		chkDurImg.style.display='inline';				
	}else
	{		
		chkDurImg =  document.getElementById(disImg+""+rowCount);
		chkDurImg.style.visibility='hidden';		
		chkDurImg.style.display='none';	
	}
}

function displayFreFields(objDoses,index){
	/*var nDoses = objDoses.value;	
	var rowLink;
	var rowField;
	rowCount=parent.VaccinesForCategoryMiddleFrame.document.vaccinesForCategoryResultForm.array_length.value; 
	if (nDoses == 1)
	{
		rowLink = eval("document.getElementById("rowLink")"+index)
		rowField = eval("document.getElementById("rowField")"+index)
		rowLink.style.visibility='hidden';
		rowField.style.visibility='visible';
		rowField.style.display='inline';
		rowLink.style.display='none';			
	}else{
		rowLink = eval("document.getElementById("rowLink")"+index)
		rowField = eval("document.getElementById("rowField")"+index)
		rowLink.style.visibility='visible';
		rowField.style.visibility='hidden';
		rowLink.style.display='inline';
		rowField.style.display='none';			
	}
	*/
}


function exchange(i,j, oTable)
{	
	var colName = "";
	var vaccineId = "";
	i = parseInt(i)+1;
	j = parseInt(j)+1;	
	var allRows = oTable.getElementsByTagName("tr");	
	oTable.insertBefore(allRows[i], allRows[j]);	
	
	
	//var nodeList = root.childNodes;		
	//allRows = oTable.getElementsByTagName("tr");	
	for (var row=2;row < allRows.length ;row++ )
	{	
		allRows[row].id="trRowId_"+parseInt(row);	
		
		var cInp = allRows[row].getElementsByTagName('input');//the inputs' collection of the row 
		var cSel = allRows[row].getElementsByTagName('select'); // the select collection of the row
		var cAnchor = allRows[row].getElementsByTagName('a'); // the select collection of the row
		cAnchor[0].innerText	= row - 1;			
		
		for(var i=0;i<cInp.length;i++)
		{	
			colName = cInp[i].getAttribute('name');					
			colName = colName.substring(0,colName.lastIndexOf("_"));			
			colName = colName+'_'+row;			
			cInp[i].setAttribute('name',colName);						
		} 
		for (var j=0;j<cSel.length;j++ )
		{
			colName = cSel[j].getAttribute('name');		

			colName = colName.substring(0,colName.lastIndexOf("_"));		
			cSel[j].setAttribute('name',colName+'_'+row); //change the selecet's name 		
	
		}		
		colName = cAnchor[1].getAttribute('name');		
		colName = colName.substring(0,colName.lastIndexOf("_"));		
		cAnchor[1].setAttribute('name',colName+'_'+row); //change the selecet's name 			
		
		/*var temp1 = allRows[row].childNodes.length;
		for(var i=0;i<temp1;i++)
		{
			if (i == 0)												
				allRows[row].cells[i].className = 'gridNumericData';
			else
				allRows[row].cells[i].className = 'gridData';	
		}*/
	}		
	document.vaccinesForCategoryResultForm.firstPos.value = '';
	document.vaccinesForCategoryResultForm.secPos.value = '';
	
}

function checkAgeSpecific(obj, unit)
{
	if (obj)
	{
		var adhocAgeSpecYN = document.getElementById("adhocAgeSpecYN").value;
		var maxAge = document.getElementById("maxAge").value;
		var minAge = document.getElementById("minAge").value;
		var ageUnit = document.getElementById("ageUnit").value;
		var age = obj.value;
		var name = obj.name;	
		var index = '';
		var days = 0;


		age = parseInt(age);

		if(unit == 'Y')
		{

			index = name.substring(name.indexOf('r')+1, name.length);
		}
		else if (unit == 'M')
		{
			index = name.substring(name.indexOf('h')+1, name.length);
		}
		else if (unit == 'D')
		{
			index = name.substring(name.indexOf('y')+1, name.length);
		}

		 if (document.getElementById("txtYear"+index))
		 {
			if (document.getElementById("txtYear"+index).value != '')
			{
				days = (parseInt(document.getElementById("txtYear"+index).value) * 365);
			}
		 }

		 if (document.getElementById("txtMonth"+index))
		 {
			if (document.getElementById("txtMonth"+index).value != '')
			{
				days += (parseInt(document.getElementById("txtMonth"+index).value) * 30);
			}
		 }

		 if (document.getElementById("txtDay"+index))
		 {
			if (document.getElementById("txtDay"+index).value != '')
			{
				days += parseInt(document.getElementById("txtDay"+index).value);
			}
		 }

		age = days;

		

		if (adhocAgeSpecYN == 'Y')
		{
			maxAge = parseInt(maxAge);
			minAge = parseInt(minAge);
			
			if(ageUnit == 'Y')
			{
				maxAge = 365 * maxAge;
				minAge = 365 * minAge;
			}
			else if (ageUnit == 'M')
			{
				maxAge = 30 * maxAge;
				minAge = 30 * minAge;
			}
			else if (ageUnit == 'D')
			{
				maxAge = 1 * maxAge;
				minAge = 1 * minAge;
			}
		}

	//	alert('age = '+age +' , minAge=  '+minAge +' , maxAge '+maxAge)

		if (obj.value != '' && (age < minAge ||  age > maxAge) )
		{	
			alert(getMessage("Age_DOSE_NOT_MATCH","CA"));
			return false;
			//obj.focus();
		}
	}
return true;
	
}

function checkMonths(obj)
{
	var name = obj.name;
	var index = name.substring(name.indexOf('h')+1, name.length);
	var txtYear = document.getElementById("txtYear"+index).value;
	if (txtYear != '')
	{
		if (parseInt(obj.value) >= 12)
		{
			alert(getMessage("MONTHS_VALIDATION","CA"));			
			obj.focus();
		}
	}

}
function checkDays(obj)
{
	if (parseInt(obj.value) > 30 )
	{
		
		alert(getMessage("DAYS_CHECK","CA"));
		obj.focus();
	}
}

function checkDose(obj, vaccineId)
{
	if (obj.value == '' || obj.value  < 1)
	{
		obj.value = 1;
	}

	if (obj.value != '')
	{
		setValueToBean('AddDoseNO', 'doseNo', obj.value, vaccineId);		
	}
}

function addDLFTSite(obj, vaccineId)
{
	if (obj.value != '')
	{
		setValueToBean('AddDLFTSite', 'DLFTSite', obj.value, vaccineId);		
	}
}

function addPrevDays(obj, vaccineId)
{
	if (obj.value != '')
	{
		setValueToBean('AddPrevDays', 'prevDays', obj.value, vaccineId);
	}
}

function addPrevAction(obj, vaccineId)
{

	if (obj.value != '')
	{
		setValueToBean('AddPrevAction', 'prevAction', obj.value, vaccineId);
	}
}

function setValueToBean(CallFrom, setVal, ActVal, vaccineId)
{
	var xmlStr ="<root><SEARCH ";
	xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
	xmlStr += "vaccineId=\""+ vaccineId +"\" " ;
	xmlStr += ""+setVal+"=\""+ ActVal +"\" " ;
	xmlStr +=" /></root>" ;		
	//alert(xmlStr);
	var xmlHttp = new XMLHttpRequest() ;
	var xmlDoc = "" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	eval(responseText);
}

function vaccineDuplicateCheck(duplicateAction, vaccineId)
{
	var removeSch = '';
	if (duplicateAction == 'W')
	{
		var msg = getMessage("VACCINE_ALLREADY_DEFINED","CA")
		var falg = confirm(msg + '?');
		if (falg)
		{
			removeSch = "REMOVE";
		}
	}
	else if (duplicateAction == 'E')
	{
		alert(getMessage('VACCINE_ALLREADY_DEFINED','CA'))
		removeSch = "REMOVE";
	}
	if (removeSch != '')
	{
		CallFrom = "RemoveVaccineFromSchedule"
		var xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "vaccineId=\""+ vaccineId +"\" " ;
		xmlStr +=" /></root>" ;		
		//alert(xmlStr);
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "VaccCateDoseSchInterMediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
}

