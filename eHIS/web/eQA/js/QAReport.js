function run()
{
 		var str = f_query_add_mod.document.forms[0].P_QIND_CLIND_NAME.value;
		str = str.replace('%','.');
		str = str.replace('&','.');
		str = str.replace('?','.');
		f_query_add_mod.document.forms[0].P_QIND_CLIND_NAME.value = str;
	
	if(f_query_add_mod.document.forms[0].P_PERIODICITY.value=='A')
	{
     var fields = new Array (f_query_add_mod.document.forms[0].P_QIND_CLIND_NAME);
	 var names = new Array ( "Clinical Indicator")								

	 if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.forms[0].submit();
	}
	}else
		{
	var fields = new Array (f_query_add_mod.document.forms[0].P_QIND_CLIND_NAME,f_query_add_mod.document.forms[0].P_PERIODICITY,f_query_add_mod.document.forms[0].P_FROM);
	var names = new Array ( "Clinical Indicator", "Report Periodicity", "From  Period")								
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.forms[0].submit();
	}
}
	}


function replaceText(obj)
 {
 var str=obj;
   str=str.replace('%','.');
   str=str.replace('?','.');
   str=str.replace('&','.');
   obj=str;
 }


function reset()
{
	window.frames[1].location.reload();
}

async function funClinicianGroup(obj)
{     var retVal =    new String();               
	   var argumentArray  = new Array() ;
       var dataNameArray  = new Array() ;
	   var dataValueArray = new Array() ;
	   var dataTypeArray  = new Array() ;
	   var tit="";
	   var sql="";
	
		
		 tit="Clinician Indicator Search";
 
		
    	sql="SELECT  QIND_CLIND_ID code,QIND_CLIND_DESC description FROM  QA_QIND_CLIND where upper(QIND_CLIND_ID) like upper(?) and upper(QIND_CLIND_DESC) like upper(?) order by to_number(QIND_CLIND_ID) "

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
//corrected by Shashi against SCR 3067
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;
//	argumentArray[6] = DESC_LINK  ;
//	argumentArray[7] = DESC_CODE ;


	retVal = await CommonLookup( tit, argumentArray );				
	if(retVal != null && retVal != "" )
	{					
	  var ret1=unescape(retVal);
	  arr=ret1.split(",");
	     if(obj.name=="P_QIND_CLIND_NAME")
		{
	     document.forms[0].P_QIND_CLIND_NAME.value = arr[1];
	     document.forms[0].P_QIND_CLIND_ID.value = arr[0];
              		
		
		
		
		}

		
   } 
}

function poprep()
{
clind=document.forms[0].P_QIND_CLIND_ID.value
HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eQA/jsp/QAPopulateIndicatorDesc.jsp'><input type='hidden' name='indicator_id' id='indicator_id' value='"+clind+"'><input type='hidden' name='reportyn' id='reportyn' value='Y'></form></BODY></HTML>";
parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
if(parent.blankFrame.document.form1!=null)
 parent.blankFrame.document.form1.submit();


}



function addAll(selobj,arr)    
{
	var arrval = '';
	var arrtxt = '';
	var arrtot ='';
	var arrSplit = new Array();
	for (i=0; i<arr.length;i++)
	{
		var element = document.createElement('OPTION'); 
		arrtot = arr[i];
		arrSplit = arrtot.split('-');
		arrval =  arrSplit[0];	
		arrtxt =  arrSplit[1];
		element.text = arrtxt;
		element.value= arrval;
		selobj.add(element);      
	}
}
function removeAll(selobj)    
{
	var len = selobj.length;

	for (var i=len;i>-1;i--)
	{
		selobj.remove(i); 
	}


	var element = document.createElement('OPTION'); 
	element.text = '-----------Select-------';
	element.value= '';
	selobj.add(element);      
}

/* if any change is made to function funPeriodicity() then make 
respective changes in this page QAPopulateIndicatorDesc.jsp
*/

function funPeriodicity()
{
	
	var obj=document.forms[0].P_PERIODICITY;
	var objFrom=document.forms[0].P_FROM;
	var objTo=document.forms[0].P_TO;
	var arr = new Array();
	//alert('funPeriodicity:'+obj.value);
	if(obj.value=='A')
	{
		
		removeAll(objFrom);
		removeAll(objTo);
document.getElementById("hide").style.visibility='hidden'
document.forms[0].P_FROM.disabled=true
	document.forms[0].P_TO.disabled=true
	}
	if(obj.value=='B')
	{
		
		arr = new Array("F-First Half","S-Second Half");
		document.forms[0].P_FROM.disabled=false
	   document.forms[0].P_TO.disabled=false
		document.getElementById("hide").style.visibility='visible'	
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);
	
	}
	if(obj.value=='Q')
	{
		document.forms[0].P_FROM.disabled=false
	   document.forms[0].P_TO.disabled=false
		
		arr = new Array("Q1-Quarter 1","Q2-Quarter 2","Q3-Quarter 3","Q4-Quarter 4");
		document.getElementById("hide").style.visibility='visible'	
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);

	}
	if(obj.value=='M')
	{
		document.forms[0].P_FROM.disabled=false
	   document.forms[0].P_TO.disabled=false
		document.getElementById("hide").style.visibility='visible'	
		arr = new Array("1-JAN","2-FEB","3-MAR","4-APR","5-MAY","6-JUN","7-JUL","8-AUG","9-SEP","10-OCT","11-NOV","12-DEC");
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);
	}

}


function check_from_date(objfo)
{

var dat=new Date();
var yer = dat.getYear().toString();
objFromYear=document.forms[0].P_FROM_YEAR.value;
if(objFromYear > yer)
	{
 alert('Date From Date is incorrect');
 		objfo.focus();
	}
}


function check_to_date(objfo)
{
var dat=new Date();
var yer = parseInt(dat.getYear());

objToYear=parseInt(document.forms[0].P_TO_YEAR.value);
objFromYear=parseInt(document.forms[0].P_FROM_YEAR.value);


if(objToYear > yer)
{
 alert('Date From Date is incorrect');
 		objfo.focus();
	}

if(objFromYear > objToYear )
	{
 alert('Date From Date is incorrect');
 		objfo.focus();
	}


}

function check_all_date(objfo)
{
var obj=document.forms[0].P_PERIODICITY;
var objFromYr=document.forms[0].P_FROM_YEAR;
var objToYr=document.forms[0].P_TO_YEAR;

var objFrom=document.forms[0].P_FROM;
var objTo=document.forms[0].P_TO;
var dat=new Date();
var yer = dat.getYear();
if(obj.value=='A')
	{
	if(objFromYr.value > yer  ||
		objToYr.value > yer  ||
		objFromYr.value > objToYr)
		{
	  alert('Date From Date is incorrect');
	 objfo.focus();
		}
	}
	else
if(obj.value=='B')
	{
	if(	(objFromYr.value > yer  || 
		objToYr.value > yer  ||  	
		objFromYr.value > objToYr)	
		||(objFromYr.value==objToYr.value 	
		&& objFrom.value > objTo.value))
		{
		alert('Date From Date is incorrect');
		objfo.focus();
		}
	}
	else
	if(obj.value=='Q')
	{
		if(	(objFromYr.value > yer  || 
		objToYr.value > yer  ||  
		objFromYr.value > objToYr)
		||(objFromYr.value==objToYr.value 
		&& objFrom.value > objTo.value))
		{
	  alert('Date From Date is incorrect');
	   		objfo.focus();
		}
	}
	else
				if(	(objFromYr.value > yer  || 
		objToYr.value > yer  ||  
		objFromYr.value > objToYr)
		||(objFromYr.value==objToYr.value 
		&& objFrom.value > objTo.value))
		{
		  alert('Date From Date is incorrect');
  		  objfo.focus();
		}
}

function curDate(obj)
{
	var dat= new Date();
	obj.value=dat.getYear().toString();
	}







