function scrollTitle()
{
	  var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById("divDataTitle").style.position = 'static';
					document.getElementById("divDataTitle").style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById("divDataTitle").style.position = 'relative';
				document.getElementById("divDataTitle").style.posTop  = scrollXY;
	 }
}
 
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


  


function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/SitesForVaccineFrameSet.jsp'
}

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}

function getSiteCode(objCode)
{
	
	if(objCode.name=='siteDesc')
	{
		siteCode(objCode)
	}

	if(objCode.name == "buttonSite")
	{
		
		if(document.site_vaccine_form.flag.value=='false')
			return false
		else
			
			callFunctionButton()
	}
			
}

async function  callFunctionButton()
{
	
	var sql = "Select VACCINE_ID code, SHORT_DESC  description from CA_IM_VACCINE  where eff_status='E' and upper(VACCINE_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
	var title = getLabel('Common.Vaccine.label','COMMON');
	var target = document.site_vaccine_form.siteDesc;
	
	target.value='';
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
	retArray = await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	if(retArray != null && retArray !="")	
	{
		document.site_vaccine_form.siteDesc.value = arr[1];
		document.site_vaccine_form.siteCode.value = arr[0];
					
	}
	document.site_vaccine_form.flag.value='true'
}


function resetValues()
{
	//(var i=0;i<5;i++){}

	parent.SitesForVaccineMiddleFrame.location.href='../../eCommon/html/blank.html';
	parent.SitesForVaccineSearchFrame.location.href='../../eCommon/html/blank.html';
	parent.SitesForVaccineBottomFrame.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	
}
function setValue()
{
	document.site_vaccine_form.flag.value='false'
}



function searchSitesForVaccine()
{
	var searchText = document.site_vaccine_form.siteDesc;
	
	if(searchText.value=="")
	{
		var errorMsg = getMessage("VACCINE_CANNOT_BLANK","CA");
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}
	else
	{
			var vaccineId = document.site_vaccine_form.siteCode.value;			
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			parent.SitesForVaccineMiddleFrame.location.href='../../eCA/jsp/SitesForVaccineList.jsp?vaccineId='+vaccineId
			parent.SitesForVaccineSearchFrame.location.href='../../eCA/jsp/SitesForVaccineSearch.jsp'
			parent.SitesForVaccineBottomFrame.location.href='../../eCA/jsp/SitesForVaccineDtl.jsp?vaccineId='+vaccineId
	}
}
function onSuccess()
{
		f_query_add_mod.SitesForVaccineHeaderFrame.location.href='../../eCA/jsp/SitesForVaccineHdr.jsp'
	f_query_add_mod.SitesForVaccineMiddleFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.SitesForVaccineSearchFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.SitesForVaccineBottomFrame.location.href='../../eCommon/html/blank.html'
}

function reset()
{
	f_query_add_mod.location.reload();
}

function getSiteForVaccineOnClick(objCode)
{
	if(objCode.name=='siteDesc')
	{
		siteCode(objCode);
	}		
}
 function populateValues()
 {
	 var searchText = document.sitesForVaccineSearchForm.searchtext.value;
	 var searchWith = document.sitesForVaccineSearchForm.search_criteria.value;
	 var vaccineId = parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode.value;
	 parent.SitesForVaccineBottomFrame.location.href = '../../eCA/jsp/SitesForVaccineDtl.jsp?siteDesc='+searchText+'&vaccineId='+vaccineId+'&searchWith='+searchWith;
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
    Function Name :  siteCode(objCode)
	Description :	It is a  Obtaining Code And Description  of Site for Vaccine Function
	@param objCode Text Value is Passed to the Look Up Function 
 */
 function siteCode(objCode)
{
	var site = objCode.value;
	if(site == '')
	{
		document.site_vaccine_form.flag.value='true'
		return false
	}
	else
	{		
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.SitesForVaccineMiddleFrame.location.href='../../eCommon/html/blank.html'
		parent.SitesForVaccineSearchFrame.location.href='../../eCommon/html/blank.html'
		parent.SitesForVaccineBottomFrame.location.href='../../eCommon/html/blank.html'
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='SitesForVaccineIntermediate.jsp'><input type=hidden name='siteCode' id='siteCode' value='"+site+"'></form></body></html>";
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempform.submit();
	}
}

/*
	Function Name :  removeRow(objIndex)
	Description :  The Function is Used For ConCatenation  and Splitting  a String of Text Fields Values and TD Data and also based upon the  status of the CheckBox
    @param objIndex  Index of the Dynamically Created HTML Object
  */
function removeRow(objIndex)
{
	var length ;
	var selectYN = 	eval("document.sitesForVaccineResultForm.selectYN"+objIndex);
	var siteName =  eval("document.sitesForVaccineResultForm.siteName"+objIndex);
	var finalString = "";
	
	var remove_value = parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.remove_value;	
	var index;
	if(selectYN.checked != true)
	{
		length = parent.SitesForVaccineBottomFrame.document.sitesForVaccineDtlForm.sequence.value;
		//alert(length);
		//alert(remove_value.value);	
		if(remove_value.value =="")
		{
			remove_value.value = siteName.value; 
		}
		else
		{
			remove_value.value = remove_value.value + '||' +siteName.value; 
			
		}
		
		for(index = 0; index < length ;index++)
					{
			//alert(length);
			var siteNameDtl = eval("parent.SitesForVaccineBottomFrame.document.sitesForVaccineDtlForm.siteName"+index);

			var selectYNDtl = eval("parent.SitesForVaccineBottomFrame.document.sitesForVaccineDtlForm.select_yn"+index);

			if(siteNameDtl.value == siteName.value)
			{
				selectYNDtl.checked = false
			}
			
		}
		length  = document.sitesForVaccineResultForm.array_length.value

		for(index=0;index <length;index++)
		{
			if(index != objIndex)
			{
				var siteCode1 = eval("document.sitesForVaccineResultForm.siteName"+index);				
				var default_yn = 	eval("document.sitesForVaccineResultForm.defaultYN"+index);
				var select_yn = 	eval("document.sitesForVaccineResultForm.selectYN"+index);
				//sequenceNumber = eval("document.sitesForVaccineResultForm.seq_num"+index)
				//var sequenceNumberIntermediate 
				var tdText = eval(document.getElementById("trRowId"+index)).cells[0].innerText;
				///if(sequenceNumber.value > objIndex)
					//{
					//sequenceNumber.value = parseInt(sequenceNumber.value,10)-1;
					//}
				
				if( finalString == "")
				{
					finalString = tdText + "||" + siteCode1.value + "||" + select_yn.value+ "||" +default_yn.value;
				}
				else
				{
					finalString =finalString+'~'+ tdText + "||" + siteCode1.value + "||" + select_yn.value+ "||" +default_yn.value;
					
				}
			}
		}
	}
	else
	{
		return false;
	}
	
	document.sitesForVaccineResultForm.finalString.value=finalString;
	document.sitesForVaccineResultForm.remove_value.value=remove_value.value;
	//alert("remove_value.value    "+document.sitesForVaccineResultForm.remove_value.value);
//alert("finalString===279"+finalString);
    document.sitesForVaccineResultForm.vaccineId.value=parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode.value;
	document.sitesForVaccineResultForm.operation.value='split';
	document.sitesForVaccineResultForm.method ='post';
	document.sitesForVaccineResultForm.action ='SitesForVaccineList.jsp?tempValue=temp';
	document.sitesForVaccineResultForm.submit();
}

/*
    Function Name :  stringConCatenate(objIndex,objRowId)
	Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
   @param objIndex  Index of the Dynamically Created HTML Object
    @param objRow  is the  ID for the Table Row  Dynamically Created 
 */
function stringConCatenate(objIndex,objRowId)
{
	
	var selectYN = 		eval("document.sitesForVaccineDtlForm.select_yn"+objIndex);
	var tdText ;
	var finalString = ""; 
	//var sequenceNumber; 
	var description = "";
	//var seq_num ="";

	//var remove_value=parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.remove_value.value;

	var remove_value = parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.remove_value.value;
 
	var rowCount;
	var length;
	var index ;
	if(selectYN.checked==true)
	{
		//alert("click")
		rowCount=parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.array_length.value; 
		for(index =0 ;index < rowCount;index++)
		{	
		var select_yn = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.selectYN"+index)
		var  siteName = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.siteName"+index);
		var defaultY = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.defaultYN"+index);

		tdText = eval(parent.SitesForVaccineMiddleFrame.document.getElementById("trRowId"+index));

		//if(sequenceNumber.value=="")
			//{
				
				//seq_num = sequenceNumber.value;
			//}
		//else
			//{
				//seq_num = sequenceNumber.value;
			//}
		if(finalString == "")
			{

				finalString = tdText.cells[0].innerText +'||'+ siteName.value + "||" + select_yn.value+"||"+defaultY.value
					
			}
		else
			{
			
				finalString =finalString + '~' + tdText.cells[0].innerText +'||' + siteName.value + "||" + select_yn.value+"||"+defaultY.value
			}
		}
		siteName = eval("document.sitesForVaccineDtlForm.siteName"+objIndex);
		trText = objRowId.cells[0].innerText;
		var temp= parseInt(rowCount)+1;
		var defaultN = "N"
		//alert("defaultN  "+defaultN);
		selectYN.value = "Y"
		finalString =finalString + "~" + trText +"||" + siteName.value + "||"+ selectYN.value+"||"+defaultN
	 }
	else
	{		
		//alert("In Else");
			var default_Y = "";
			rowCount=parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.array_length.value;  
			siteName = eval("document.sitesForVaccineDtlForm.siteName"+objIndex);
			//alert("siteName   "+siteName.value);
			if(remove_value=="")
				{
					remove_value = siteName.value
				}
			else
				{
					remove_value =remove_value +'||'+ siteName.value
				}
			//parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.remove_value.value =remove_value

		    parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.remove_value.value =remove_value
			
			//var temp3 = 0;
			for(index = 0 ; index < rowCount ; index++)
			{
				var siteNameList = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.siteName"+index);
				default_Y = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.defaultYN"+index);
				
				//if(siteName.value == siteNameList.value)
					//{
						//temp3 = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.seq_num"+index).value;
					
					//}
			}
			for(index = 0 ; index < rowCount ; index++)
			{
				var siteNameList = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.siteName"+index);
				default_Y = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.defaultYN"+index);
				//sequenceNumber = eval("parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.seq_num"+index);
				tdText = eval(parent.SitesForVaccineMiddleFrame.document.getElementById("trRowId"+index));
				if(siteName.value != siteNameList.value)
				{		
					//if(parseInt(sequenceNumber.value,10) > parseInt(temp3,10))
						//{
							//sequenceNumber.value = parseInt(sequenceNumber.value,10)-1;
						//}
					//else
						//{
							//sequenceNumber.value = sequenceNumber.value;
						//}
					if(finalString == "")
						{

							finalString =tdText.cells[0].innerText+'||'+ siteNameList.value + "||" + 'Y'+ "||" + default_Y.value
						}
					else
						{
							finalString =finalString + '~' + tdText.cells[0].innerText +'||' + siteNameList.value + "||" +'Y'+ "||" + default_Y.value
						}
				 }
				
			}
	 }
	
//alert("406finalString"+finalString);

parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.finalString.value=finalString
	parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.vaccineId.value=parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode.value;
	parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.operation.value='split'
	parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.method ='post'
	parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.action ='SitesForVaccineList.jsp?tempValue=temp';
	parent.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.submit();
}

/*
    Function Name :  apply()
	Description :	The Function is Used For inserting updating the Records with  the Database
 */
function apply()
{
	var seqArray = new Array();
	//var indexI;
	//var indexJ;
	//var finalString = "";
	var length  = 0;
	var count = 0;

//	alert(f_query_add_mod.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode);
	var fields = new Array (f_query_add_mod.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode);
	var names = new Array(getLabel('Common.Vaccine.label','COMMON'));
	
	if(f_query_add_mod.SitesForVaccineHeaderFrame.checkFieldsofMst( fields, names, messageFrame ))
	{

	 if(f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm != null)
		{
			length = f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.array_length.value;

			for(index = 0 ; index < length ; index++)
			{
				var chkDefault=eval("f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.defaultYN"+index);
				
				
				if(chkDefault.checked)
				{
					chkDefault.value = "Y";
					count++;			
				}		
				
			}
	
			if (count > 1)
			{
				//alert(count)
				
				var errorMessage = "";
		        errorMsg = getMessage("DEFAULT_CHECK","CA");
		        messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
				return false;
		 	}
			

			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.method ='post'
			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.remove_value.value = f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.remove_value.value
			//f_query_add_mod.SitesForVaccineHeaderFrame.document.site_vaccine_form.remove_value.value =''
			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.vaccineId.value= f_query_add_mod.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteCode.value
			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.action ='../../servlet/eCA.SitesForVaccineServlet'
			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.target='messageFrame'
			f_query_add_mod.SitesForVaccineMiddleFrame.document.sitesForVaccineResultForm.submit();
		}
		else
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
	}
}

/*
    Function Name :  callFunction(sql,title,target)
	Description :	It is a  Obtaining Code And Description  of Sites For Vaccine Function from Common Look Up 						Feature
	@param objCode Text Value is Passed to the Look Up Function 
	@sql  Query to be passed to the Common Look Up
	@target Text Object Value
 */

function callFunction(sql,title,target)
{
	
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
	retArray = CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
 }

