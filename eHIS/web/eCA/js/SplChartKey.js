function create()
{
	frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyMain.jsp?mode=insert';
}

function processInterval()
{
	var formObj =	document.SplChartKeyHdrForm;
	var mode	=	document.getElementById('mode').value;
	document.SplChartKeyHdrForm.type_value1.value = 'I';
	var xAxis_element	=	formObj.xAxis_element.value; //IN058006
	if(formObj.spl_chart_type.value!='' && formObj.spl_chart_group.value!='')
	{
		parent.frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyIntervalMain.jsp?mode='+mode+'&xAxis_element='+xAxis_element;  //IN058006
	}
	parent.parent.messageFrame.location.href=src='../../eCommon/jsp/MstCodeError.jsp';
}

function processStatic()
{
	var formObj =	document.SplChartKeyHdrForm;
	var mode	=	document.getElementById('mode').value;
	document.SplChartKeyHdrForm.type_value1.value = 'S';
	var xAxis_element	=	formObj.xAxis_element.value; //IN058006
	if(formObj.spl_chart_type.value!='' && formObj.spl_chart_group.value!='')
	{
		parent.frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyStaticMain.jsp?mode='+mode+'&xAxis_element='+xAxis_element;  //IN058006
	}
	parent.parent.messageFrame.location.href=src='../../eCommon/jsp/MstCodeError.jsp';
}

function processGenerate()
{

	var fields = new Array (parent.parent.frameSplChartKeyHdr.document.SplChartKeyHdrForm.spl_chart_type,
							document.forms[0].start_value,
							document.forms[0].end_value,
							document.forms[0].interval );

	var names = new Array (	getLabel("Common.Chart.label",'COMMON') + 																																	getLabel("Common.type.label",'COMMON'),  																														getLabel("Common.Start.label",'COMMON')+ 
											getLabel("Common.Value.label",'COMMON'),
											getLabel("Common.End.label",'COMMON')+
											getLabel("Common.Value.label",'COMMON'),
											getLabel("eCA.Interval.label",'CA'));
	parent.parent.parent.messageFrame.location.href=src='../../eCommon/jsp/MstCodeError.jsp';
	if(checkFieldsofMst( fields, names, parent.parent.parent.messageFrame)) 
	{		
		if(checkval1('End Value','Start Value',document.forms[0].start_value,document.forms[0].end_value))
			return false;
		var formObj =	document.SplChartKeyIntervalDtlForm;
		var mode	=	parent.parent.frameSplChartKeyHdr.document.getElementById('mode').value;
		var unit	=   document.getElementById('unit').value;
		var	startValue	=	document.getElementById('start_value').value;
		var	endValue	=	document.getElementById('end_value').value;
		var	interval	=	document.getElementById('interval').value;
		var splChartType	=	parent.parent.frameSplChartKeyHdr.document.SplChartKeyHdrForm.spl_chart_type.value;
		var xAxis_element	=	parent.parent.frameSplChartKeyHdr.document.SplChartKeyHdrForm.xAxis_element.value;  //IN058006
		parent.frameSplChartKeyIntervalList.location.href='../../eCA/jsp/SplChartKeyIntervalList.jsp?mode='+mode+'&spl_chart_type='+splChartType+'&xAxis_element='+xAxis_element+'&unit='+unit+'&start_value='+startValue+'&end_value='+endValue+'&interval='+interval; //IN058006
	}
}

function processClear()
{
	parent.parent.parent.messageFrame.location.href=src='../../eCommon/jsp/MstCodeError.jsp';
	parent.frameSplChartKeyIntervalList.location.href='../../eCommon/html/blank.html';
	document.SplChartKeyIntervalDtlForm.reset();
}

function checkForGenerate( obj, messageFrame ) {
//	alert(obj.spl_chart_type.value);
    if(obj)
		return true;
	var errors = "" ;
	errors = getMessage("KEYS_NOT_GENERATED",'CA') + "<br>" ;
	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
 }


function checkIsValidForProceed()
{
 var url = frameSplChartKeyMain.frameSplChartKeyMain.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}

function apply()
{	
	if(!(frameSplChartKeyMain.frameSplChartKeyHdr) || !(checkIsValidForProceed()) || (frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].r1.disabled==true))
	{
		var errors = getMessage("NOT_VALID",'CA') ;
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return;
	}

	var type = frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].type_value1.value;
	if(type=='I')
	{
		var fields = new Array (frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_type,
							frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_group,
							frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.document.forms[0].start_value,
							frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.document.forms[0].end_value,
							frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.document.forms[0].interval );

/*	var names = new Array (frameSplChartKeyMain.frameSplChartKeyHdr.getLabel("Common.Chart.label",'COMMON') + frameSplChartKeyMain.frameSplChartKeyHdr.getLabel("Common.type.label",'COMMON'),frameSplChartKeyMain.frameSplChartKeyHdr.getLabel("Common.Chart.label",'COMMON')+
	frameSplChartKeyMain.frameSplChartKeyHdr.getLabel("Common.Group.label",'COMMON'), 
	frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.getLabel("Common.Start.label",'COMMON')+ 
	frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.getLabel("Common.Value.label",'COMMON'),
	frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.getLabel("Common.End.label",'COMMON')+
	frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.getLabel("Common.Value.label",'COMMON'),
	frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalDtl.getLabel("eCA.Interval.label",'CA'));*/

	var names = new Array (getLabel("Common.Chart.label",'COMMON') + getLabel("Common.type.label",'COMMON'),getLabel("Common.Chart.label",'COMMON')+getLabel("Common.Group.label",'COMMON'),getLabel("Common.Start.label",'COMMON')+getLabel("Common.Value.label",'COMMON'),getLabel("Common.End.label",'COMMON')+getLabel("Common.Value.label",'COMMON'),getLabel("eCA.Interval.label",'CA'));
		
		if(frameSplChartKeyMain.checkFieldsofMst( fields, names, messageFrame)) 
		{	
			if(checkForGenerate(frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalList.frameSplChartKeyIntervalListDtl,messageFrame))
			{
				frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalList.frameSplChartKeyIntervalListDtl.document.SplChartKeyIntervalListDtl.spl_chart_type.value = frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_type.value;
				frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalList.frameSplChartKeyIntervalListDtl.document.SplChartKeyIntervalListDtl.spl_chart_group.value = frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_group.value;
				frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyIntervalList.frameSplChartKeyIntervalListDtl.document.SplChartKeyIntervalListDtl.submit();		
			}
		}
	}
	else if(type=='S')
	{
		var formObj = frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl;
		var total	= formObj.rec_count.value;	
		
		var fields = new Array (frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_type,
								frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_group,
								frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainHdr.document.SplChartKeyStaticMainHdr.unit,formObj.elements[0],formObj.elements[1]);
		

var names = new Array (getLabel("Common.Chart.label",'COMMON') +getLabel("Common.type.label",'COMMON'),getLabel("Common.Chart.label",'COMMON')+getLabel("Common.Group.label",'COMMON'),getLabel("Common.Unit.label",'COMMON'),getLabel("Common.Start.label",'COMMON')+getLabel("Common.Value.label",'COMMON')+"1",	getLabel("Common.End.label",'COMMON')+getLabel("Common.Value.label",'COMMON')+"1");
		
		if(frameSplChartKeyMain.checkFieldsofMst( fields, names, messageFrame)) 
		{	
			
			var status  = true;
			
				for (i=1,j=0;j<parseInt(total*2);j+=2,i++ )
				{
					if(checkval1('End Value '+i,'Start Value '+i,formObj.elements[j],formObj.elements[j+1]))
					{
					  status = false;
					  break;
					}
				}
				if(status)
				{
					frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl.spl_chart_type.value = frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_type.value;
					frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl.spl_chart_group.value = frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0].spl_chart_group.value;

					frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl.unit.value = frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainHdr.document.SplChartKeyStaticMainHdr.unit.value;
			
					frameSplChartKeyMain.frameSplChartKeyMain.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl.submit();		
				}
				else
				{
					var errors = " " ;
					messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
				}
			}
	}
}

function onSuccess()
{
	create();
}


function reset()
{
	if(!(frameSplChartKeyMain.frameSplChartKeyHdr))
	{
		return;		
	}
	else
	if(frameSplChartKeyMain.frameSplChartKeyHdr.document.forms[0])
	{
		frameSplChartKeyMain.location.reload();
	}
}

function allowPositiveNumber(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46)) ) {
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
			alert(
getMessage("INVALID_NUMBER_FORMAT",'Common')); 
			obj.focus();
			return false;
	}

	
   var obj_value = obj.value;
   
   var i1 = obj_value.indexOf('.'); 
   if(i1 != -1){
	   if(obj_value.indexOf('.',i1+1)!=-1)
	   {
		    alert(
getMessage("INVALID_NUMBER_FORMAT",'Common'));
			obj.focus();
			return false;
	   }
	}


	if(obj != null ){
		if(parseFloat(obj_value)>=0 && parseFloat(obj_value)<=999999999.9){
			return true;
		}else{
			alert(getMessage("NUMBER_NOT_IN_RANGE",'CA'));
			//obj.select();
			obj.value="";
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

function checkval1(str,str1,obj,obj1)
    {
        var val=parseFloat(obj.value,10);
        var val1=parseFloat(obj1.value,10);
        if (val>=val1) {
            alert("APP-SM0053 "+str+" must be greater than "+str1);
          //  obj1.select();
            obj1.value="";
            obj1.focus();
			return true;
        }
}

function checkval2(index)
{
		var formObj = document.SplChartKeyStaticMainDtl;
	
		fele = formObj.elements[(index*2)-2];
		sele = formObj.elements[(index*2)-1];
		
	
		var val1=parseFloat(fele.value,10);
        var val2=parseFloat(sele.value,10);

        if (val1>=val2) {
            alert(getMessage("ENDVAL_LESS_STARTVAL",'CA'));
          //  sele.select();
            sele.value="";
            sele.focus();
			return false;
        }
		return true;
}

function checkval3(index)
{
		var formObj = document.SplChartKeyStaticMainDtl;
		ele = formObj.elements[(index*2)-2];
		if(!(trimCheck(ele.value)))
		{
			alert(getMessage("STARTVALUE_NOT_EXIST",'CA'));
			return false;
		}
		return allowPositiveNumber();
}

function setNextFirstValue(textObj,index)
{
	var formObj = document.SplChartKeyStaticMainDtl;
	if(index < formObj.rec_count.value)
	{	
		formObj.elements[index*2].value = textObj.value;
		formObj.elements[index*2].select();
		formObj.elements[index*2].focus();
	}
}

function checkChartType(obj)
{
	var errors = " " ;
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
	document.SplChartKeyHdrForm.submit();
}

function setDetailsPage(page,type1,type2,type3)
{	
	if(page=='display')
		parent.frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyIntervalList.jsp?mode=insert&db_display=DB&spl_chart_type='+type1+'&spl_chart_group='+type2+'&xAxis_element='+type3;//IN058006
	else if(page=='list')
	{
		var mode = 'insert';

		if(type1=='I')
			parent.frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyIntervalMain.jsp?mode='+mode+'&xAxis_element='+type3; //IN058006
		else if(type1=='S')
			parent.frameSplChartKeyMain.location.href='../../eCA/jsp/SplChartKeyStaticMain.jsp?mode='+mode+'&xAxis_element='+type3; //IN058006
	}
	else
		parent.frameSplChartKeyMain.location.href='../../eCommon/html/blank.html';
}



	
