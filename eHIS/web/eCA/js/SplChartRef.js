var chkFlag="";
function create()
{
	frameSplChartRefMain.location.href='../../eCA/jsp/SplChartRefMain.jsp';
}

function checkIsValidForProceed()
{
 var url = frameSplChartRefMain.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}

function apply()
{	
	if(!(frameSplChartRefMain.frameSplChartRefHdr))
	{
		var errors = getMessage("NOT_VALID",'CA') ;
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return;
	}

	var formObj1 = frameSplChartRefMain.frameSplChartRefHdr.document.forms[0];
	var xValue=formObj1.yAxis_element.value;
	if('*'==xValue)
		formObj1.yAxis_element.value='';
	var fields = new Array (formObj1.spl_chart_type,formObj1.spl_chart_group,formObj1.yAxis_element);
var names = new Array  (frameSplChartRefMain.frameSplChartRefHdr.getLabel("Common.Chart.label",'COMMON') + 																	 frameSplChartRefMain.frameSplChartRefHdr.getLabel("Common.type.label",'COMMON'),                    										  frameSplChartRefMain.frameSplChartRefHdr.getLabel("Common.Chart.label",'COMMON')+
									 frameSplChartRefMain.frameSplChartRefHdr.getLabel("Common.Group.label",'COMMON'),
									 frameSplChartRefMain.frameSplChartRefHdr.getLabel("eCA.Yaxiselement.label",'CA'));

	if(frameSplChartRefMain.checkFieldsofMst( fields, names, messageFrame)) 
	{	
		if(!(frameSplChartRefMain.frameSplChartRefDtl.frameSplChartRefDtlList.document.forms[0]))
		{
			var errors = getMessage("NOT_VALID",'CA') ;
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
			return;
		}		
		var formObj2 = frameSplChartRefMain.frameSplChartRefDtl.frameSplChartRefDtlList;
		var headerArray=new Array();			
		var header1 = formObj2.document.SplChartRefDtlList.header1.value;
		var header2 = formObj2.document.SplChartRefDtlList.header2.value;
		var header3 = formObj2.document.SplChartRefDtlList.header3.value;
		var header4 = formObj2.document.SplChartRefDtlList.header4.value;
		var header5 = formObj2.document.SplChartRefDtlList.header5.value;
		var header6  =formObj2.document.SplChartRefDtlList.header6.value;
		var header7 = formObj2.document.SplChartRefDtlList.header7.value;
		var header8 = formObj2.document.SplChartRefDtlList.header8.value;
		var header9 = formObj2.document.SplChartRefDtlList.header9.value;
		var header10 = formObj2.document.SplChartRefDtlList.header10.value;
		var header11 = formObj2.document.SplChartRefDtlList.header11.value;
		var header12 = formObj2.document.SplChartRefDtlList.header12.value;			

		headerArray[0] = header1;
		headerArray[1] = header2;
		headerArray[2] = header3;
		headerArray[3] = header4;
		headerArray[4] = header5;
		headerArray[5] = header6;
		headerArray[6] = header7;
		headerArray[7] = header8;
		headerArray[8] = header9;
		headerArray[9] = header10;
		headerArray[10] = header11;
		headerArray[11] = header12;

		var isErr = true;
		var isAll = false;
		var allCnt = 0;

		var emptyArr = new Array();
		for (var k = 0; k < 12; k++ )
		{
			if(headerArray[k] == '')
			{
				allCnt++;

			}
		}

		if (allCnt == 12)
		{
			isAll = true;
		}

		

		for (var k = 0; k < 12; k++ )
		{
			if(headerArray[k] == '')
			{
				for (var j = k; j < 12  ; j++)
				{
					if(headerArray[j] != '')
					{
						if (emptyArr.length == 0)
						{
							emptyArr[emptyArr.length]  = k+1;
						}
						else
						{
							var flag = true;
							for (var v = 0; v < emptyArr.length; v++)
							{
								if (parseInt(emptyArr[v]) == parseInt(k+1) )
								{
									flag = false;										
								}
							}

							if (flag)
							{
								emptyArr[emptyArr.length]  = k+1;
							}
						}
						isErr = false;			
					}
				}					
			}	
		}

		if (isAll)
		{
			var msg = getMessage("HDR_PERCNTL_NOT_BLANK","CA");					
			msg = msg.replace("#", "");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}

		if (emptyArr.length > 0)
		{
			var msg = getMessage("HDR_PERCNTL_NOT_BLANK","CA") 
			var msg1 = '';
			for (var i =0; i<emptyArr.length  ;i++ )
			{ 
				if (msg1 == "")
				{
					msg1 += ' '+emptyArr[i];				
				}else
				{ 
					if (i == emptyArr.length - 1)					
						msg1 += ' and '+emptyArr[i];
					else
						msg1 += ', '+emptyArr[i];
				}
				
			}			
			msg = msg.replace("#", " at postion(s) "+msg1)			
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		if (isErr && !isAll)
		{
			formObj2.document.forms[0].submit();		
		}

	}
}

function onSuccess()
{
	create();
}


function reset()
{
	if(!(frameSplChartRefMain.frameSplChartRefHdr))
	{
		return;
	//	var errors = "APP-000001 Reset is not a valid operation here" ;
	//	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
	}
	else
	if(frameSplChartRefMain.frameSplChartRefHdr)
	{
		//frameSplChartRefMain.frameSplChartRefHdr.SplChartRefHdrForm.reset();
	//	frameSplChartRefMain.frameSplChartRefHdr.yAxis_element.value = "*";//IN058006
		frameSplChartRefMain.location.reload();
	}
}

function allowPositiveNumber(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46)) ) {
       return false;
   }
   return true;
}

function allowNumber(){
   var key = window.event.keyCode;
     
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46) || (key == 45)) ) {
       return false;
   }
   return true;
}

function checkNumber(obj) {
   var sequence = "0123456789.";
   var obj_value = obj.value;

   var obj_length = obj_value.length;   
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
			obj.focus();
			return false;
		}
   }
   return true ;
}

function checkPositiveNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return false;
	}
	if(!checkNumber(obj))
		return false;
	if(obj.value!=0)
	if(parseFloat(obj.value) == 0){
			alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
 //Here is the Change
			obj.focus();
			return false;
	}
   var obj_value = obj.value;
   var i1 = obj_value.indexOf('.'); 
   if(i1 != -1){
	   if(obj_value.indexOf('.',i1+1)!=-1)
	   {
		    alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
			obj.focus();
			return false;
	   }
	}
	if(obj != null ){
		if(parseFloat(obj_value)>=0 && parseFloat(obj_value)<=9999999999.9999999999){
			return true;
		}else{
			alert(getMessage("NUMBER_NOT_IN_RANGE",'CA'));
			obj.select();
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

function checkNumber1(obj) 
{ 
	if ( obj.value.length > 0 && isNaN(obj.value) == true) {
		alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
		obj.select();
		obj.focus();
	}else{
		checkLimit(obj);		
	}
}

function checkval1(str,str1,obj,obj1)
    {
        var val=parseFloat(obj.value,10);
        var val1=parseFloat(obj1.value,10);
        if (val>=val1) {
            alert("APP-SM0053 "+str+" must be greater than "+str1);
            obj1.select();
            obj1.focus();
			return true;
        }
}
function checkMaxDigit(obj) 
	{			
		var key = window.event.keyCode;
		var value=obj.value;
		 if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46) || (key == 45)) ) 
	   {
			 return false;   
	   }
        if ( value.length> 3 )
			{            
			return false; 			
	}		
	   
	return true;
}



function checkPercentileHeader(obj)
{	
		var userInput=obj.value;		
		var poistion=obj.name;
		poistion=poistion.slice(6);	
		var firstChar=userInput.charAt(0);	
		var percent=userInput;				
		if(percent<0 || percent>100){

			var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
			msg =msg.replace('(1)',0);
			msg =msg.replace('(2)',100);		
			alert(msg);		
			obj.value='';
			obj.focus();							
			return false;
		}else
		{
			if(poistion>=0)
			{			
				checkOrder1(obj);			
			}	
		}
}
/*
function checkOrder(second,first)
{			
			var headerArray=new Array();			
			var header1=document.SplChartRefDtlList.header1.value;
			var header2=document.SplChartRefDtlList.header2.value;
			var header3=document.SplChartRefDtlList.header3.value;
			var header4=document.SplChartRefDtlList.header4.value;
			var header5=document.SplChartRefDtlList.header5.value;
			var header6=document.SplChartRefDtlList.header6.value;
			var header7=document.SplChartRefDtlList.header7.value;
			var header8=document.SplChartRefDtlList.header8.value;
			var header9=document.SplChartRefDtlList.header9.value;
			var header10=document.SplChartRefDtlList.header10.value;
			var header11=document.SplChartRefDtlList.header11.value;
			var header12=document.SplChartRefDtlList.header12.value;
			

			headerArray[0]=header1;
			headerArray[1]=header2;
			headerArray[2]=header3;
			headerArray[3]=header4;
			headerArray[4]=header5;
			headerArray[5]=header6;
			headerArray[6]=header7;
			headerArray[7]=header8;
			headerArray[8]=header9;
			headerArray[9]=header10;
			headerArray[10]=header11;
			headerArray[11]=header12;
			if(headerArray[first]==''){
				//return false;
			}
			//alert(headerArray[second]);
			//alert(headerArray[first]);
			var currentHeader=headerArray[second];				
			var checkDefineHeader='';				
			var checkDefineHeader1='';				
			var index;
			var index1;			
			var indexValue=indexNumber(first);
				function indexNumber(first)
						{						
						 checkDefineHeader=headerArray[first];	
							
						if(checkDefineHeader=='' && first !=0)
						{								
							indexNumber(first-1);
						}
						else
							{							 
							for(index=0;index<second;index++)
							{
								if(headerArray[index]==checkDefineHeader)	
								{	
									
									return index;
								}
							}
						
						}
					}
					//alert(index);
			var secondVal=second+1;					
			var lastIndexValue=lastIndexNumber(secondVal);
				function lastIndexNumber(secondVal)
						{						
						 checkDefineHeader1=headerArray[secondVal];
						
						if(checkDefineHeader1=='')
						{								
							lastIndexNumber(secondVal+1);
						}
						else
							{							 
							for(index1=secondVal;index1<13;index1++)
							{								
								if(headerArray[index1]==checkDefineHeader1)	
								{															
									return index1;
								}
							}
						
						}
					}				
				if(headerArray[index]!=0)
				{
					if(headerArray[index].charAt(0)==0){					
						headerArray[index]=headerArray[index].slice(1);						
					}
				}
				if(headerArray[second]!=0)
				{
					if(headerArray[second].charAt(0)==0){					
						headerArray[second]=headerArray[second].slice(1);
					}
				}
				if(headerArray[index1]!=0)
				{
					if(headerArray[index1]!=undefined && headerArray[index1].charAt(0)==0){					
						headerArray[index1]=headerArray[index1].slice(1);
					}
				}
			if(currentHeader !='' && first !=-1)
			{				
				if(parseInt(headerArray[index])>=parseInt(headerArray[second]) || parseInt(headerArray[second])>=parseInt(headerArray[index1]))
				{		
				return false;
				}				
			}
			if(first ==-1)
				{
				if(parseInt(headerArray[second])>=parseInt(headerArray[index1]))
					return false;
				}
					
		return true;
}
*/

function checkLimit(obj)
{
	var  value=obj.value;	
	if(value.indexOf("-") > 0 ){
		alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
		return false;
	}else{
		if (value.indexOf(".") > 10)
		{
			var msg = getMessage("DECIMAL_DIGIT_POSITION",'CA');
			msg = msg.replace("#","10");
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}else if (value.indexOf(".") < 0 && value.length > 10){			
			var msg = getMessage("MAXIMUM_DIGITS",'CA');
			msg += " lessthan or equals to 10"
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}
	}
	
}
 function CheckForSpeChar(event)
{	
   var strCheck='0123456789';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode); 
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}
/*function Keypress_Event(obj)
{
	
     // This is for Getting the Source Element..
    var objTxtBox = window.event.target; 
    // declare the variable for the bool value.
    var isOk = false;
    // Here we need not backspace keycode = 8 and the delete keycode 46
    isOk = ( event.keyCode == 8 || event.keyCode == 46 ) ? false:true;   
	
	if (obj.value.length > 1)
	{		
		event.returnValue=isOk;
	}
	
}*/

//function checkOrder1(second,first,obj)
function checkOrder1(obj)
{			
	
			var headerArray=new Array();			
			var header1=document.SplChartRefDtlList.header1.value;
			var header2=document.SplChartRefDtlList.header2.value;
			var header3=document.SplChartRefDtlList.header3.value;
			var header4=document.SplChartRefDtlList.header4.value;
			var header5=document.SplChartRefDtlList.header5.value;
			var header6=document.SplChartRefDtlList.header6.value;
			var header7=document.SplChartRefDtlList.header7.value;
			var header8=document.SplChartRefDtlList.header8.value;
			var header9=document.SplChartRefDtlList.header9.value;
			var header10=document.SplChartRefDtlList.header10.value;
			var header11=document.SplChartRefDtlList.header11.value;
			var header12=document.SplChartRefDtlList.header12.value;			

			headerArray[0]=header1;
			headerArray[1]=header2;
			headerArray[2]=header3;
			headerArray[3]=header4;
			headerArray[4]=header5;
			headerArray[5]=header6;
			headerArray[6]=header7;
			headerArray[7]=header8;
			headerArray[8]=header9;
			headerArray[9]=header10;
			headerArray[10]=header11;
			headerArray[11]=header12;	
			
			var pos = obj.name;
			var position = parseInt(obj.name.substring(obj.name.indexOf("r")+1, obj.name.length)) - 1;
			
			if(headerArray[position] != '')
			{
				if(headerArray[position - 1] == '')
				{
					var prevObj = eval("document.SplChartRefDtlList.header"+position);
					prevObj.focus();
					//obj.focus();
					alert(getMessage("PREV_HDR_PERCNTL_NOT_BLANK","CA"));
					//obj.value = '';
					
					return false;
				}

				if(parseInt(headerArray[position + 1]) <= parseInt(headerArray[position]))
				{
					var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
					var min='Previous Percentile';
					var max='Next Percentile';
					msg =msg.replace('(1)',min);
					msg =msg.replace('(2)',max);					
					obj.focus();
					obj.value= '';
					alert(msg);						
					return false;
				}

				if(parseInt(headerArray[position]) <= parseInt(headerArray[position - 1]))
				{
					var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
					var min='Previous Percentile';
					var max='Next Percentile';
					msg =msg.replace('(1)',min);
					msg =msg.replace('(2)',max);					
					obj.focus();
					obj.value= '';
					alert(msg);											
					return false;
				}				
				
			}
			
			
			
		/*	if(headerArray[first]=='' ){
				alert(getMessage("PREV_HDR_PERCNTL_NOT_BLANK","CA"));
				obj.value="";
				return false;
			}			
			if(headerArray[second]=='' && headerArray[second+1]!='' && second!=11)
			{
				alert(getMessage("HDR_PERCNTL_NOT_BLANK","CA"));
				obj.value="";
				obj.focus();
				return false;
			}
			if(headerArray[first]!=0 && first!=-1)
				{
					if(headerArray[first].charAt(0)==0){					
						headerArray[first]=headerArray[first].slice(1);						
					}
				}
			if(headerArray[second]!=0)
				{
					if(headerArray[second].charAt(0)==0){					
						headerArray[second]=headerArray[second].slice(1);						
					}
				}
				
			if(headerArray[second+1]!=0 && headerArray[second+1]!=undefined)
				{
					if(headerArray[second+1].charAt(0)==0){					
						headerArray[second+1]=headerArray[second+1].slice(1);						
					}
				}
		if(headerArray[second] !='' && first !=-1)
			{
			if(parseInt(headerArray[first])>=parseInt(headerArray[second]) || parseInt(headerArray[second])>=parseInt(headerArray[second+1]))
				{				
				var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
				var min='Previous Percentile';
				var max='Next Percentile';
				msg =msg.replace('(1)',min);
				msg =msg.replace('(2)',max);
				alert(msg);				
				obj.value='';	
				obj.focus();
				return false;
				}
			}
		if(first ==-1)
				{			
				if(parseInt(headerArray[second])>=parseInt(headerArray[second+1]))
					{
					var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
					var min='Previous Percentile';
					var max='Next Percentile';
					msg =msg.replace('(1)',min);
					msg =msg.replace('(2)',max);
					alert(msg);				
					obj.value='';					
					return false;
					}
					
				}*/
			//alert('true end of fun')
					
		return true;
}

function enableFileds(obj)
{
	
	var userInput = obj.value;		
	var poistion = obj.name;
	poistion = poistion.slice(6);		
	var total = document.forms[0].rec_count.value;		        		 
	for(var i=1;i<=parseInt(total);i++)
	{				 
		var t="p"+poistion+"_value"+i;			 
		var fields=eval("document.forms[0]."+t);			
		if(obj.value=='')
		{
		// fields.value="";
		 fields.readOnly = true;		 
		}
		else
		{
			fields.readOnly = false;	
		}
	}
}
function validateElementType(obj,obj1){		
	var xElementyType = document.forms[0].xAxis_element.value;
	var yElementyType = document.forms[0].element_type.value;
	if(xElementyType==yElementyType){
		alert(getMessage('XAXI_YAXI_NOT_SAME','CA'));
		obj.value=obj1.value;		
	}else{
		checkChartType();
		obj1.value=obj.value;
	}
}

