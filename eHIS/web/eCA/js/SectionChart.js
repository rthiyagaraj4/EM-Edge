
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
function removeRow(objIndex)
{
	var length ;
	var selectYN = 	eval("document.sectionChartResultForm.selectYN"+objIndex);
	var sectionCode=eval("document.sectionChartResultForm.sectionCode"+objIndex);
	var finalString = "";
	var sequenceNumber="";
	var remove_value = parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.remove_value;
	//var rowCount=parent.sectionChartMiddleFrame.document.sectionChartResultForm.array_length.value ; 
	var index;
	if(selectYN.checked != true)
	{
		length = parent.sectionChartBottomFrame.document.sectionChartDtlForm.sequence.value;
		//alert(length);
			
		if(remove_value.value =="")
		{
			remove_value.value = sectionCode.value; 
		}
		else
		{
			remove_value.value = remove_value.value + '||' +sectionCode.value; 
			
		}
		
		for(index = 0; index < length ;index++)
					{
			//alert(length);
			var sectionCodeDtl = eval("parent.sectionChartBottomFrame.document.sectionChartDtlForm.sectionCode"+index);

			var selectYNDtl = eval("parent.sectionChartBottomFrame.document.sectionChartDtlForm.select_yn"+index);

			if(sectionCodeDtl.value == sectionCode.value)
			{
				selectYNDtl.checked = false
			}
			
		}
		length  = document.sectionChartResultForm.array_length.value
			//alert(length);

		for(index=0;index <length;index++)
		{
			if(index != objIndex)
			{
				var serviceCode = eval("document.sectionChartResultForm.sectionCode"+index)			
				var select_yn = 	eval("document.sectionChartResultForm.selectYN"+index)
				sequenceNumber = eval("document.sectionChartResultForm.seq_num"+index)
				var sequenceNumberIntermediate 
				//var tdText = eval(document.getElementById("trRowId"+index).cells[2].innerText);
				var tdText = document.getElementById("trRowId" + index).cells[2].innerText;
				if(sequenceNumber.value > objIndex)
					{
					sequenceNumber.value = parseInt(sequenceNumber.value,10)-1;
					}
				if( finalString == "")
				{
					finalString = tdText + "||" + serviceCode.value +"||" + sequenceNumber.value + "||" + select_yn.value
				}
				else
				{
					finalString =finalString+'~'+ tdText + "||" + serviceCode.value +"||" + sequenceNumber.value + "||" + select_yn.value
					
				}
			}
		}
	}
	else
	{
		return false;
	}
	document.sectionChartResultForm.finalString.value=finalString
	document.sectionChartResultForm.chartId.value=parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value;
	document.sectionChartResultForm.operation.value='split'
	document.sectionChartResultForm.method ='post'
	document.sectionChartResultForm.action ='SectionChartList.jsp?tempValue=temp';
	document.sectionChartResultForm.submit();
}
/*
    Function Name :  stringConCatenate(objIndex,objRowId)
	Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
   @param objIndex  Index of the Dynamically Created HTML Object
    @param objRow  is the  ID for the Table Row  Dynamically Created 
 */
function stringConCatenate(objIndex,objRowId)
{
	
	var selectYN = 		eval("document.sectionChartDtlForm.select_yn"+objIndex);
	var tdText ;
	var finalString = ""; 
	var sequenceNumber; 
	var description = "";
	var seq_num ="";
	var remove_value=parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.remove_value.value;

	//var rowCount=parent.sectionChartMiddleFrame.document.sectionChartResultForm.array_length.value ; 
	var rowCount;
	var length;
	var index ;
	if(selectYN.checked==true)
	{
		rowCount=parent.sectionChartMiddleFrame.document.sectionChartResultForm.array_length.value; 
		for(index =0 ;index < rowCount;index++)
		{	
		var select_yn = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.selectYN"+index)
		var  sectionCode = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.sectionCode"+index);
		sequenceNumber = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+index);

		tdText = eval(parent.sectionChartMiddleFrame.document.getElementById("trRowId"+index));

		if(sequenceNumber.value=="")
			{
				
				seq_num = sequenceNumber.value;
			}
		else
			{
				seq_num = sequenceNumber.value;
			}
		if(finalString == "")
			{

				finalString = tdText.cells[2].innerText +'||'+ sectionCode.value + "||" + sequenceNumber.value +'||'+select_yn.value
					
			}
		else
			{
			
				finalString =finalString + '~' + tdText.cells[2].innerText +'||' + sectionCode.value + "||" + seq_num +'||'+select_yn.value
			}
		}
		sectionCode = eval("document.sectionChartDtlForm.sectionCode"+objIndex);
		trText = objRowId.cells[0].innerText;
		var temp= parseInt(rowCount)+1;
		
		selectYN.value = 'Y'
		finalString =finalString + '~' + trText +'||' + sectionCode.value + "||" + temp +'||'+ selectYN.value
	 }
	else
	{			
			rowCount=parent.sectionChartMiddleFrame.document.sectionChartResultForm.array_length.value;  
			sectionCode = eval("document.sectionChartDtlForm.sectionCode"+objIndex);

			if(remove_value=="")
				{
					remove_value = sectionCode.value
				}
			else
				{
					remove_value =remove_value +'||'+ sectionCode.value
				}
			parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.remove_value.value =remove_value
			
			var temp3 = 0;
			for(index = 0 ; index < rowCount ; index++)
			{
				var sectionCodeList = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.sectionCode"+index);
				sequenceNumber = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+index);
				
				if(sectionCode.value == sectionCodeList.value)
					{
						temp3 = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+index).value;
					
					}
			}
			for(index = 0 ; index < rowCount ; index++)
			{
				var sectionCodeList = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.sectionCode"+index);
				sequenceNumber = eval("parent.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+index);
				tdText = eval(parent.sectionChartMiddleFrame.document.getElementById("trRowId"+index));
				if(sectionCode.value != sectionCodeList.value)
				{		
					if(parseInt(sequenceNumber.value,10) > parseInt(temp3,10))
						{
							sequenceNumber.value = parseInt(sequenceNumber.value,10)-1;
						}
					else
						{
							sequenceNumber.value = sequenceNumber.value;
						}
					if(finalString == "")
						{

							finalString =tdText.cells[2].innerText+'||'+ sectionCodeList.value + "||" + sequenceNumber.value +'||'+ 'Y'
						}
					else
						{
							finalString =finalString + '~' + tdText.cells[2].innerText +'||' + sectionCodeList.value + "||" + sequenceNumber.value +'||'+'Y'
						}
				 }
				
			}
	 }
	
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.finalString.value=finalString
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.chartId.value=parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value;
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.operation.value='split'
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.method ='post'
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.action ='SectionChartList.jsp?tempValue=temp';
	parent.sectionChartMiddleFrame.document.sectionChartResultForm.submit();
}
/*
    Function Name :  create()
	Description :	The Function is Used For loading  Function
 */
function create()
{
	  f_query_add_mod.location.href = '../../eCA/jsp/SectionChartFrameSet.jsp';
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
/*
	var searchText = f_query_add_mod.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc;
	alert(searchText.value);
	
	if(searchText.value=="")
	{
		var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}*/

	var fields = new Array (f_query_add_mod.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode);
	var names = new Array(getLabel("Common.Chart.label",'COMMON'));
	
	if(f_query_add_mod.sectionChartHeaderFrame.checkFieldsofMst( fields, names, messageFrame ))
	{

	 if(f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm != null)
		{
			length = f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.array_length.value;

	
	for(var index = 0 ;index < length;index++)
	{
		var sequenceNumber = eval("f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+index);
		
		if(sequenceNumber.value=="")
		{   var error =getMessage("CAN_NOT_BE_BLANK","Common");
		     error = error.replace('$',getLabel("Common.SequenceNo.label","Common"));
			//var error = messageArray["SEQUENCE_NOT_BLANK"];
			sequenceNumber.select()
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&error_value=0";
			return false
		}
		else
		{
			seqArray[index] = parseInt(sequenceNumber.value);
		}
		
	}
	for(indexI =0 ;indexI <seqArray.length;indexI++)
	{
		
		for(indexJ =indexI+1 ;indexJ <seqArray.length;indexJ++)
		{
			if(seqArray[indexI] == seqArray[indexJ])
			{
				sequenceNumber = eval("f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.seq_num"+indexJ);
				var error = getMessage("DUPLICATE_SEQUENCE_NUMBER","CA");
				//var error = messageArray["DUPLICATE_SEQUENCE_NUMBER"];
				sequenceNumber.select()
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&error_value=0";
				return false
			}
		}
	}
	
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.method ='post'
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.remove_value.value = f_query_add_mod.sectionChartHeaderFrame.document.sectionChartHeaderForm.remove_value.value
		f_query_add_mod.sectionChartHeaderFrame.document.sectionChartHeaderForm.remove_value.value =''
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.chartId.value= f_query_add_mod.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.action ='../../servlet/eCA.SectionChartServlet'
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.target='messageFrame'
		f_query_add_mod.sectionChartMiddleFrame.document.sectionChartResultForm.submit();
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	}
}

/*
    Function Name :  onSuccess()
	Description :	It is Called when Success Transaction is Done with the Database
 */
function onSuccess()
{
		f_query_add_mod.sectionChartHeaderFrame.location.href='../../eCA/jsp/SectionChartHdr.jsp'
	f_query_add_mod.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html'
}
/*
    Function Name :  reset()
	Description :	Used to reset the Function
 */
function reset()
{
	/*if(f_query_add_mod.document.forms[0]!=null){
	
	f_query_add_mod.sectionChartHeaderFrame.location.href='../../eCA/jsp/SectionChartHdr.jsp'
	f_query_add_mod.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html'
	f_query_add_mod.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html'
	}*/
	f_query_add_mod.location.reload();
}

/*
    Function Name :  populateValues()
	Description :	Used to Search Criteria for the Section Description of the Section Chart Function
 */
 function populateValues()
 {
	 var searchText = document.sectionChartSearchForm.searchtext.value;
	 var chartId = parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value;
	  //parent.sectionChartMiddleFrame.location.href = '../../eCA/jsp/SectionChartList.jsp?chartDesc='+searchText+'&chartId='+chartId;
	 parent.sectionChartBottomFrame.location.href = '../../eCA/jsp/SectionChartDtl.jsp?chartDesc='+searchText+'&chartId='+chartId;
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
    Function Name :  searchChartSection()
	Description :	The Function is Used For Providing Search Criteria for selected Chart Id and 								Description
   
 */

function searchChartSection()
{
	var searchText = document.sectionChartHeaderForm.chartDesc;
	
	if(searchText.value=="")
	{
		var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}
	else
	{
			var chartId = document.sectionChartHeaderForm.chartCode.value;
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			parent.sectionChartMiddleFrame.location.href='../../eCA/jsp/SectionChartList.jsp?chartId='+chartId
			parent.sectionChartSearchFrame.location.href='../../eCA/jsp/SectionChartSearch.jsp'
			parent.sectionChartBottomFrame.location.href='../../eCA/jsp/SectionChartDtl.jsp?chartId='+chartId
	}
}
/*
    Function Name :  CheckForSpecialCharacter(Object)
	Description :	The Function is Used For restricting Special Chracters in the Text Box
   @param Object  Used to Check whether this Object is Button or TextBox
 */
async function getChartCode(objCode)
{
	if(objCode.name=='chartDesc')
	{
		chartCode(objCode)
	}
	if(objCode.name=='buttonChart')
	{
		if(document.sectionChartHeaderForm.flag.value=='false')
			return false
		else
			await callFunctionButton()
	}
			
}
/*
    Function Name :  chartCode(objCode)
	Description :	It is a  Obtaining Code And Description  of Chart Function
	@param objCode Text Value is Passed to the Look Up Function 
 */
 function chartCode(objCode)
{
	var chart = objCode.value;
	if(chart == '')
	{
		document.sectionChartHeaderForm.flag.value='true'
		return false
	}
	else
	{		
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html'
		parent.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html'
		parent.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html'
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'  class=MESSAGE><form name='tempform' id='tempform' method='post' action='SectionChartIntermediate.jsp'><input type=hidden name='chartCode' id='chartCode' value='"+chart+"'></form></body></html>";
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
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
 }
/*
    Function Name :  callFunctionButton()
	Description :	It is a  Obtaining Code And Description  of Chart Function from Common Look Up 						Feature
 */
async function  callFunctionButton()
{
	var sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E' and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) and not exists (select 1 from ca_chart_section_comp where chart_id=ca_chart.chart_id ) order by 2";
	var title = getLabel('Common.Chart.label','COMMON');

	var target = document.sectionChartHeaderForm.chartDesc;
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
	 
	 var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")	
	{
		document.sectionChartHeaderForm.chartDesc.value = arr[1];
		document.sectionChartHeaderForm.chartCode.value = arr[0];
					
	}
	document.sectionChartHeaderForm.flag.value='true'
}

function resetValues()
{
	//(var i=0;i<5;i++){}

	parent.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html'
	parent.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html'
	parent.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html'
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
	
}
function setValue()
{
	document.sectionChartHeaderForm.flag.value='false'
}


function getChartCodeOnClick(objCode)
{
	if(objCode.name=='chartDesc')
	{
		chartCode(objCode);
	}		
}

function changeSeq(cunt,slno)
 {	 
	var count=document.sectionChartResultForm.array_length.value;
	var classValue = 'gridData';//((parseInt(count)%2)==0 )? "QRYEVEN" : "QRYODD";

	if(document.sectionChartResultForm.firstPos.value == "")
	   {
		  var temp =document.getElementById("trRowId"+cunt);
		  var temp1 = temp.cells.length;
    if(document.sectionChartResultForm.firstPos.value == "")
		{
		for(var i=0;i<temp1;i++)
			{
			temp.cells[i].className = 'FIRSTSELECTED';
			temp.cells[i].align="left";
			}
		}
		document.getElementById("extraRow").style.display = "inline";
		if(document.getElementById("extraRow").style.display == "inline")
		{
			for(var j=0;j<(document.getElementById("extraRow").cells.length);j++)
			{
				document.getElementById("extraRow").cells[j].className = classValue;
			}
		}
		document.sectionChartResultForm.firstPos.value = slno;
		 
			}
	else
	{		
		reloadSecFrame(cunt,slno);
		
	}
}

function reloadSecFrame(cunt,slno)
{
	var finalString = document.sectionChartResultForm.finalString.value;
	if(document.sectionChartResultForm.firstPos.value != "")
	{
		
		document.sectionChartResultForm.secPos.value = slno;
		var firstPos = document.sectionChartResultForm.firstPos.value;
		var secPos = document.sectionChartResultForm.secPos.value;
		var rowCount = document.sectionChartResultForm.array_length.value;	
		var tdText ;var index;
		var rowCount = document.sectionChartResultForm.array_length.value;	
		var tdText ;	
		parent.sectionChartMiddleFrame.location.href = "../../eCA/jsp/SectionChartList.jsp?firstPosition="+document.sectionChartResultForm.firstPos.value+"&secondPosition="+document.sectionChartResultForm.secPos.value+"&operation=split&rowCount="+rowCount+"&flag_for_list=true&finalString="+finalString;
	}
	
	}

