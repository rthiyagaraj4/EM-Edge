//function create 
function create()
{

window.search.location.href="../../eXH/jsp/FilteringRuleApplicationSearch.jsp";		
window.filterframe.location.href="../../eCommon/html/blank.html";
//window.recordframe.location.href="../../eXH/jsp/FilterRulesAddModifyFunctionality.jsp";	

}

function valuePopulate(string)
{
	
	var blocation=getLabel("eXH.ByLocation.Label","XH");
	var bpatient=getLabel("eXH.BYPatientType.Label","XH");
	var bnone=getLabel("eXH.None.Label","XH");
	var border=getLabel("eXH.BYCategory.Label","XH");
	

	if((string=="ADT")||(string=="ADR")) 
	{
		//getLabel("eXH.Admission.label","XH");
		str="L-"+blocation+"-P-"+bpatient;
 		//str="L-By Location-P-BY PatientType-*-None";
       	return str;
	}

	if(string=="ORM") 
	{
		//getLabel("eXH.Admission.label","XH");
		str1="L-"+blocation+"-P-"+bpatient+"-C-"+border;
		//str1="L-By Location-P-BY PatientType-C-BY Category-*-None";
		return str1;
	}

	if(string=="ORU") 
	{
		//getLabel("eXH.Admission.label","XH");
		str2="L-"+blocation+"-P-"+bpatient+"-C-"+border;
		//str2="L-By Location-P-BY PatientType-C-BY Category-*-None";
		return str2;
	}

	if(string=="SIU") 
	{
       //getLabel("eXH.Admission.label","XH");
	     str3="L-"+blocation;
		//str3="L-By Location-*-None";
		return str3;
	}
  
}
//**********************************************************************************************

var ArrayOption=null;
var ArrayValue1=null;
var ArrayOption1=null;
var ResultArray=null;

//**********************************************************************************************

function callArray(Idstr,msgString)
{
 ArrayValue=new Array();
 ArrayOption=new Array();
 ArrayValue1=new Array();
 ArrayOption1=new Array();
 ResultArray=new Array();
	var returnString=valuePopulate(msgString);
		
	ResultArray=returnString.split('-');

	for(var i=0;i<ResultArray.length;i++)
	{

		if(i%2==0) ArrayValue.push(ResultArray[i]);
		else ArrayOption.push(ResultArray[i]);
	}

	for(var i=0;i<ArrayValue.length;i++)
	{

		 ArrayValue1.push(ArrayValue[i]);
	}

	for(var i=0;i<ArrayOption.length;i++)
	{
		ArrayOption1.push(ArrayOption[i]);
	}
	
    var selectbox=document.getElementById(Idstr);
    removeAllOptions(selectbox);
	var optn=null;
	for(var i=0;i<ArrayOption.length;i++)
	{
	optn=new Array();
	optn[i] = document.createElement("OPTION");
	optn[i].text = ArrayOption1[i];
	optn[i].value =ArrayValue1[i];
	selectbox.options.add(optn[i]);
	
	}
	
}
//**********************************************************************************************


function removeAllOptions(selectbox)
{
var i;
for(i=selectbox.options.length-1;i>=0;i--)
{
selectbox.remove(i);
}
}

//**********************************************************************************************
function generateLevel2AdtOptions(selectbox2,val)
{
if(val=='P')
	{
		
		var optn11= document.createElement("OPTION");
		optn11.text = getLabel("eXH.ByLocation.Label","XH");
		optn11.value ='L';
		selectbox2.options.add(optn11);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox2.options.add(optn2);
	}
	else if(val=='L')
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox2.options.add(optn3);
	} 
	/*else{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYPatientType.Label","XH");
		optn1.value ='P';
		selectbox2.options.add(optn1); 
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox2.options.add(optn3);
	}*/

}

//**********************************************************************************************

function generateLevel3AdtOptions(selectbox3,val1,val2)
{
if((val1=='L')&&(val2=='S'))
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYPatientType.Label","XH");
		optn1.value ='P';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox3.options.add(optn2);
	}
	
	else if((val1=='L')&&(val2=='P'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.None.Label","XH");
		optn1.value ='*';
		selectbox3.options.add(optn1);
		
	}
	else if((val1=='L')&&(val2=='*'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.None.Label","XH");
		optn1.value ='*';
		selectbox3.options.add(optn1);
	}
	else if(((val1=='P')&&(val2=='L'))||((val1=='*')&&(val2=='L')))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox3.options.add(optn2);
	}

	else if(((val1=='P')&&(val2=='*'))||((val1=='*')&&(val2=='P')))
	{
		
		/*var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);*/
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox3.options.add(optn2);
	}
	/*else if((val1=='*')&&(val2=='*'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYPatientType.Label","XH");
		optn1.value ='P';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}*/
}
//**********************************************************************************************

function generateLevel4AdtOptions(selectbox4,val1,val2,val3)
{
if(((val1=='L')&&(val2=='S')&&(val3=='P'))||((val1=='L')&&(val2=='P')&&(val3=='*'))||((val1=='L')&&(val2=='*')&&(val3=='P'))||((val1=='P')&&(val2=='L')&&(val3=='S'))||((val1=='P')&&(val2=='L')&&(val3=='*'))||((val1=='L')&&(val2=='*')&&(val3=='*'))||((val1=='P')&&(val2=='*')&&(val3=='*')))
	{
   	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.None.Label","XH");
	optn1.value ='*';
	selectbox4.options.add(optn1);
	}
	else if(((val1=='L')&&(val2=='S')&&(val3=='*'))||((val1=='*')&&(val2=='L')&&(val3=='S'))||((val1=='*')&&(val2=='L')&&(val3=='*')))
	{
	/*var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);*/
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.None.Label","XH");
	optn.value ='*';
	selectbox4.options.add(optn);
	}
	else if(((val1=='P')&&(val2=='*')&&(val3=='L'))||((val1=='*')&&(val2=='P')&&(val3=='L')))
	{
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.BySubLocation.Label","XH");
	optn.value ='S';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.None.Label","XH");
	optn1.value ='*';
	selectbox4.options.add(optn1);
	
	
	}
	else if(((val1=='P')&&(val2=='*')&&(val3=='*'))||((val1=='*')&&(val2=='P')&&(val3=='*'))||((val1=='*')&&(val2=='*')&&(val3=='P')))
	{
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.ByLocation.Label","XH");
	optn.value ='L';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.None.Label","XH");
	optn1.value ='*';
	selectbox4.options.add(optn1);
	
	}
	else if(((val1=='*')&&(val2=='*')&&(val3=='P')))
	{
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.BySubLocation.Label","XH");
	optn.value ='S';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
	}
	else if(((val1=='*')&&(val2=='*')&&(val3=='*')))
	{
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.ByLocation.Label","XH");
	optn.value ='L';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
	}
  
}

//**********************************************************************************************
function generateLevel2SiuOptions(selectbox2,val)
{
if(val=='L')
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox2.options.add(optn1);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox2.options.add(optn3);
	} 
	else if(val=='*')
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox2.options.add(optn2);
	}
}

//**********************************************************************************************
function generateLevel3SiuOptions(selectbox3,val1,val2)
{
if((val1=='L')&&(val2=='S'))
	{
		
		var optn= document.createElement("OPTION");
		optn.text = getLabel("eXH.None.Label","XH");
		optn.value ='*';
		selectbox3.options.add(optn);
	}
	else if((val1=='L')&&(val2=='*'))
	{
		
		/*var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox3.options.add(optn1);*/
		var optn= document.createElement("OPTION");
		optn.text = getLabel("eXH.None.Label","XH");
		optn.value ='*';
		selectbox3.options.add(optn);
	}
	else if((val1=='*')&&(val2=='*'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn= document.createElement("OPTION");
		optn.text = getLabel("eXH.None.Label","XH");
		optn.value ='*';
		selectbox3.options.add(optn);
	}
  
}

//**********************************************************************************************
function generateLevel4SiuOptions(selectbox4,val1,val2,val3)
{

if(((val1=='L')&&(val2=='S')&&(val3=='*'))||((val1=='*')&&(val2=='L')&&(val3=='S'))||((val1=='*')&&(val2=='L')&&(val3=='*'))||((val1=='L')&&(val2=='*')&&(val3=='*')))
	{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.None.Label","XH");
	optn1.value ='*';
	selectbox4.options.add(optn1);
	}
	else if(((val1=='*')&&(val2=='*')&&(val3=='L')))
	{
	var optn= document.createElement("OPTION");
	optn.text = 'By Sub Location';
	optn.value ='S';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.None.Label","XH");
	optn1.value ='*';
	selectbox4.options.add(optn1);
	}
}

//**********************************************************************************************
function generateLevel2Options(selectbox2,val)
{
if(val=='L')
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.BYCategory.Label","XH");
		optn3.value ='C';
		selectbox2.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox2.options.add(optn4);
	
	}
	else if(val=='P')
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYCategory.Label","XH");
		optn2.value ='C';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox2.options.add(optn3);
	} 
	else if(val=='C')
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByType.Label","XH");
		optn1.value ='T';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.BYPatientType.Label","XH");
		optn3.value ='P';
		selectbox2.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox2.options.add(optn4);
	}
	
	else{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYPatientType.Label","XH");
		optn1.value ='P';
		selectbox2.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox2.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox2.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.BYCategory.Label","XH");
		optn4.value ='C';
		selectbox2.options.add(optn4);
	}



}
//**********************************************************************************************


function generateLevel3Options(selectbox3,val1,val2)
{
if(((val1=='L')&&(val2=='S')))
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYPatientType.Label","XH");
		optn1.value ='P';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYCategory.Label","XH");
		optn2.value ='C';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}
	
	else if((val1=='L')&&(val2=='P'))
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BYCategory.Label","XH");
		optn1.value ='C';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox3.options.add(optn2);
		
	}
	else if((val1=='L')&&(val2=='C'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByType.Label","XH");
		optn1.value ='T';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}
	else if((val1=='P')&&(val2=='L'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYCategory.Label","XH");
		optn2.value ='C';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}

	else if((val1=='P')&&(val2=='C'))
	{
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByType.Label","XH");
		optn1.value ='T';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}
	/*else if((val1=='P')&&(val2=='*'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYCategory.Label","XH");
		optn2.value ='C';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}*/
	else if((val1=='C')&&(val2=='L'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}
	else if((val1=='C')&&(val2=='P'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.None.Label","XH");
		optn2.value ='*';
		selectbox3.options.add(optn2);
	}
	else if(((val1=='C')&&(val2=='T')))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	}
	else if((val1=='*')&&(val2=='L'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.BySubLocation.Label","XH");
		optn1.value ='S';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.BYCategory.Label","XH");
		optn3.value ='C';
		selectbox3.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox3.options.add(optn4);

		
	}
	else if((val1=='*')&&(val2=='P'))
	{
	 var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYCategory.Label","XH");
		optn2.value ='C';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.None.Label","XH");
		optn3.value ='*';
		selectbox3.options.add(optn3);
	
		
		}
	else if((val1=='*')&&(val2=='C'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByType.Label","XH");
		optn1.value ='T';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.ByLocation.Label","XH");
		optn2.value ='L';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.BYPatientType.Label","XH");
		optn3.value ='P';
		selectbox3.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox3.options.add(optn4);
	}
	else if((val1=='*')&&(val2=='*'))
	{
		
		var optn1= document.createElement("OPTION");
		optn1.text = getLabel("eXH.ByLocation.Label","XH");
		optn1.value ='L';
		selectbox3.options.add(optn1);
		var optn2= document.createElement("OPTION");
		optn2.text = getLabel("eXH.BYPatientType.Label","XH");
		optn2.value ='P';
		selectbox3.options.add(optn2);
		var optn3= document.createElement("OPTION");
		optn3.text = getLabel("eXH.BYCategory.Label","XH");
		optn3.value ='C';
		selectbox3.options.add(optn3);
		var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox3.options.add(optn4);
	}
	else if(((val1=='L')&&(val2=='*'))||(val1=='P')&&(val2=='*')||((val1=='C')&&(val2=='*')))

	{

	   var optn4= document.createElement("OPTION");
		optn4.text = getLabel("eXH.None.Label","XH");
		optn4.value ='*';
		selectbox3.options.add(optn4);
	
	}

}

//**********************************************************************************************
function generateLevel4Options(selectbox4,val1,val2,val3)
{

if(((val1=='L')&&(val2=='S')&&(val3=='P'))||((val1=='*')&&(val2=='L')&&(val3=='P'))||((val1=='L')&&(val2=='*')&&(val3=='P'))||((val1=='P')&&(val2=='L')&&(val3=='S'))||((val1=='*')&&(val2=='L')&&(val3=='P')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYCategory.Label","XH");
	optn1.value ='C';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);

}
else if(((val1=='L')&&(val2=='S')&&(val3=='C'))||((val1=='*')&&(val2=='L')&&(val3=='C')))
{
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.ByType.Label","XH");
	optn.value ='T';
	selectbox4.options.add(optn);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='*')&&(val2=='L')&&(val3=='S')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.BYCategory.Label","XH");
	optn.value ='C';
	selectbox4.options.add(optn);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}

else if(((val1=='L')&&(val2=='P')&&(val3=='C'))||((val1=='L')&&(val2=='*')&&(val3=='C'))||((val1=='P')&&(val2=='L')&&(val3=='C'))||((val1=='*')&&(val2=='P')&&(val3=='C')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.ByType.Label","XH");
	optn1.value ='T';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='L')&&(val2=='C')&&(val3=='T'))||((val1=='C')&&(val2=='L')&&(val3=='S')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='L')&&(val2=='*')&&(val3=='*'))||((val1=='L')&&(val2=='P')&&(val3=='*'))||((val1=='C')&&(val2=='*')&&(val3=='*'))||((val1=='P')&&(val2=='*')&&(val3=='*'))||((val1=='L')&&(val2=='S')&&(val3=='*'))||((val1=='L')&&(val2=='C')&&(val3=='*')))
{
	/*var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.BYCategory.Label","XH");
	optn.value ='C';
	selectbox4.options.add(optn);*/
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='P')&&(val2=='C')&&(val3=='T'))||((val1=='C')&&(val2=='T')&&(val3=='P'))||((val1=='*')&&(val2=='P')&&(val3=='*'))||((val1=='*')&&(val2=='C')&&(val3=='P'))||((val1=='C')&&(val2=='*')&&(val3=='P'))||((val1=='*')&&(val2=='*')&&(val3=='P')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.ByLocation.Label","XH");
	optn1.value ='L';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='P')&&(val2=='C')&&(val3=='L'))||((val1=='C')&&(val2=='P')&&(val3=='L')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BySubLocation.Label","XH");
	optn1.value ='S';
	selectbox4.options.add(optn1);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}

else if(((val1=='P')&&(val2=='*')&&(val3=='L'))||((val1=='*')&&(val2=='P')&&(val3=='L')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BySubLocation.Label","XH");
	optn1.value ='S';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.BYCategory.Label","XH");
	optn3.value ='C';
	selectbox4.options.add(optn3);

	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}

else if(((val1=='*')&&(val2=='C')&&(val3=='T')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.ByLocation.Label","XH");
	optn1.value ='L';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.BYPatientType.Label","XH");
	optn3.value ='P';
	selectbox4.options.add(optn3);

	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='C')&&(val2=='T')&&(val3=='L'))||((val1=='C')&&(val2=='*')&&(val3=='L'))||((val1=='*')&&(val2=='C')&&(val3=='L'))||((val1=='*')&&(val2=='*')&&(val3=='L')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BySubLocation.Label","XH");
	optn1.value ='S';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.BYPatientType.Label","XH");
	optn3.value ='P';
	selectbox4.options.add(optn3);

	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='L')&&(val2=='C')&&(val3=='P'))||((val1=='C')&&(val2=='L')&&(val3=='P')))
{
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='P')&&(val2=='*')&&(val3=='C')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.ByType.Label","XH");
	optn1.value ='T';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.ByLocation.Label","XH");
	optn3.value ='L';
	selectbox4.options.add(optn3);

	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='P')&&(val2=='*')&&(val3=='*'))||((val1=='P')&&(val2=='L')&&(val3=='*'))||((val1=='P')&&(val2=='C')&&(val3=='*'))||((val1=='C')&&(val2=='T')&&(val3=='*'))||((val1=='C')&&(val2=='L')&&(val3=='*'))||((val1=='C')&&(val2=='P')&&(val3=='*')))
{
	/*var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.ByLocation.Label","XH");
	optn3.value ='L';
	selectbox4.options.add(optn3);
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYCategory.Label","XH");
	optn1.value ='C';
	selectbox4.options.add(optn1);*/
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='*')&&(val2=='C')&&(val3=='*')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.ByLocation.Label","XH");
	optn3.value ='L';
	selectbox4.options.add(optn3);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}
else if(((val1=='*')&&(val2=='*')&&(val3=='*')))
{
	var optn1= document.createElement("OPTION");
	optn1.text = getLabel("eXH.BYPatientType.Label","XH");
	optn1.value ='P';
	selectbox4.options.add(optn1);
	var optn3= document.createElement("OPTION");
	optn3.text = getLabel("eXH.ByLocation.Label","XH");
	optn3.value ='L';
	selectbox4.options.add(optn3);
	var optn= document.createElement("OPTION");
	optn.text = getLabel("eXH.BYCategory.Label","XH");
	optn.value ='C';
	selectbox4.options.add(optn);
	var optn2= document.createElement("OPTION");
	optn2.text = getLabel("eXH.None.Label","XH");
	optn2.value ='*';
	selectbox4.options.add(optn2);
}

  
}

//**********************************************************************************************
function Level2(firstId,msgString,secondId)
{
	var selectbox1=document.getElementById(firstId);
	var val=selectbox1.value;
	
	var selectbox2=document.getElementById(secondId);
	removeAllOptions(selectbox2);
   
	if((msgString=="ADT")||(msgString=="ADR"))
	{
    	generateLevel2AdtOptions(selectbox2,val);
	}
	else if(msgString=="SIU")
	{
		generateLevel2SiuOptions(selectbox2,val);
	}
	else if((msgString=="ORU")||(msgString=="ORM"))
	{
  		generateLevel2Options(selectbox2,val);
	}
}
//**********************************************************************************************
function Level3(firstId,msgString,secondId,thirdId)
{

	
	var selectbox1=document.getElementById(firstId);
	var selectbox2=document.getElementById(secondId);

	var val1=selectbox1.value;
	var val2=selectbox2.value;
	
	var selectbox3=document.getElementById(thirdId);
	removeAllOptions(selectbox3);
  	if((msgString=="ADT")||(msgString=="ADR"))
  	{
  		generateLevel3AdtOptions(selectbox3,val1,val2);
	}
	else if(msgString=="SIU")
  	{
		generateLevel3SiuOptions(selectbox3,val1,val2);
    }
	else if((msgString=="ORU")||(msgString=="ORM"))
  	{
  		generateLevel3Options(selectbox3,val1,val2);
    }
}
//**********************************************************************************************

function Level4(firstId,msgString,secondId,thirdId,fourthId)
{

	
	var selectbox1=document.getElementById(firstId);
	var selectbox2=document.getElementById(secondId);
	var selectbox3=document.getElementById(thirdId);

	var val1=selectbox1.value;
	var val2=selectbox2.value;
	var val3=selectbox3.value;
	
	var selectbox4=document.getElementById(fourthId);
	removeAllOptions(selectbox4);
 	if((msgString=="ADT")||(msgString=="ADR"))
  	{
  		generateLevel4AdtOptions(selectbox4,val1,val2,val3);
 	}
    else if(msgString=="SIU")
  	{
  		generateLevel4SiuOptions(selectbox4,val1,val2,val3);
    }
  	else if((msgString=="ORU")||(msgString=="ORM"))
  	{
   		generateLevel4Options(selectbox4,val1,val2,val3);
  	}
}

//**********************************************************************************************

function firstSelectBoxPopulate(msgType)
{

if((msgType!='null')&&((msgType=='ADT')||(msgType=='ORM')||(msgType=='ORU')||(msgType=='SIU')||(msgType=='ADR')))
{
	
	callArray('filter_type',msgType);
	Level2('filter_type',msgType,'filter_type1');
	Level3('filter_type',msgType,'filter_type1','filter_type2');
	Level4('filter_type',msgType,'filter_type1','filter_type2','filter_type3');


}
else if((msgType=='null')) alert(getMessage('XH1008','XH'));
else alert(getMessage('XH1007','XH'));
parent.recordframe.location.href="../../eCommon/html/blank.html";
}

//**********************************************************************************************
function secondSelectBoxPopulate(msgType)
{
if((msgType!='null')&&((msgType=='ADT')||(msgType=='ORM')||(msgType=='ORU')||(msgType=='SIU')||(msgType=='ADR')))
{
	Level2('filter_type',msgType,'filter_type1');
	Level3('filter_type',msgType,'filter_type1','filter_type2');
	Level4('filter_type',msgType,'filter_type1','filter_type2','filter_type3');

}
else if((msgType=='null')) alert(getMessage('XH1008','XH'));
else alert(getMessage('XH1007','XH'));
parent.recordframe.location.href="../../eCommon/html/blank.html";
}
//**********************************************************************************************
function thirdSelectBoxPopulate(msgType)
{
if((msgType!='null')&&((msgType=='ADT')||(msgType=='ORM')||(msgType=='ORU')||(msgType=='SIU')||(msgType=='ADR')))
{
	Level3('filter_type',msgType,'filter_type1','filter_type2');
	Level4('filter_type',msgType,'filter_type1','filter_type2','filter_type3');
}
else if((msgType=='null')) alert(getMessage('XH1008','XH'));
else alert(getMessage('XH1007','XH'));
parent.recordframe.location.href="../../eCommon/html/blank.html";
}
//**********************************************************************************************

function fourthSelectBoxPopulate(msgType)
{
if((msgType!='null')&&((msgType=='ADT')||(msgType=='ORM')||(msgType=='ORU')||(msgType=='SIU')||(msgType=='ADR')))
{
	Level4('filter_type',msgType,'filter_type1','filter_type2','filter_type3');
}
else if((msgType=='null')) alert(getMessage('XH1008','XH'));
else alert(getMessage('XH1007','XH'));
parent.recordframe.location.href="../../eCommon/html/blank.html";
}
