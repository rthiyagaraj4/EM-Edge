function cancel(img_name1,what)				  
{
	 document[img_name1].src='../../eCommon/images/empty.gif';
	document.getElementById(what).style.display="none";
	document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
    document.DATAELEMENTCROSSREF.reset();
}
function record(val)
{

// window.parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
var fields="";
var names="";
	if(document.forms[0].expectedvalue.value=='Y')
	{

if(document.forms[0].expectedvalue2.value=='Y')
	{

 fields = new Array ( 
					     document.forms[0].expected_value,document.forms[0].expected_value2,document.forms[0].Position_value,document.forms[0].derivation_type				     
					   );
 names = new Array (getLabel("eXH.ExpectedValue.Label","XH"),getLabel("eXH.ExpectedValue2.Label","XH"),getLabel("Common.Position.label","common"),getLabel("eXH.DerivationType.Label","XH"));



	}
	else
		{

 fields = new Array ( 
					     document.forms[0].expected_value,document.forms[0].Position_value,document.forms[0].derivation_type				     
					   );

 names = new Array (getLabel("eXH.ExpectedValue.Label","XH"),getLabel("Common.Position.label","common"),getLabel("eXH.DerivationType.Label","XH"));

		}

	} 
	else
	{

if(document.forms[0].expectedvalue2.value=='Y')
		{


 fields = new Array ( 
					    document.forms[0].expected_value2,document.forms[0].Position_value,document.forms[0].derivation_type				     
					   );

 names = new Array (getLabel("eXH.ExpectedValue2.Label","XH"),getLabel("Common.Position.label","common"),getLabel("eXH.DerivationType.Label","XH"));
		}
else
		{

		 fields = new Array ( 
					   document.forms[0].Position_value	,document.forms[0].derivation_type			     
					   );
		 names = new Array (getLabel("Common.Position.label","common"),getLabel("eXH.DerivationType.Label","XH"));
		}


	}


	



if(!checkFields( fields, names, window.parent.parent.messageFrame,'1'))
	{
	
	}
	else
	{
		
 this.document.forms[0].actualmode.value = val;
 this.document.forms[0].submit();
	}
 
window.parent.parent.commontoolbarFrame.document.location.reload();



 
}
function hide( ) 
{
 document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
}
function CheckForSpecCharsforID(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
function changeTexts(img_name,img_name1,what)
{
document.DATAELEMENTCROSSREF.expected_value2.value="";
document.DATAELEMENTCROSSREF.expected_value.value="";
document.DATAELEMENTCROSSREF.execution_order.value="";
document.getElementById(what).style.display="none";
document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
//document[img_name].src='../../eCommon/images/empty.gif';
//document[img_name1].src='../../eCommon/images/empty.gif';
var myString = document.DATAELEMENTCROSSREF.derivation_type.value;
var Expected_dis=["AE", "LTRIM", "RTRIM", "TRIM", "SUBSTR", "REPLACE", "USER_DEF_FORMAT","ENCOD_DECOD_ALGORITH"];
var Expected_ena=["IF","<>","=", "<", ">", "<=",">=","BETWEEN","NOT BETWEEN","IS NULL","IS NOT NULL","IN","NOT IN","LIKE","NOT LIKE","PREFIX","PRESUFFIX","SUFFIX","GR"];



	



for (var i=0;i<Expected_dis.length;i++)
{
	document.DATAELEMENTCROSSREF.expected_value.disabled=true;
    document[img_name].src='../../eCommon/images/empty.gif';
	 document[img_name1].src='../../eCommon/images/empty.gif';
}
for (var i=0;i<Expected_ena.length;i++)
{
if(myString==Expected_ena[i])
{
if(myString=="PREFIX")
{
		document.forms[0].expectedvalue2.value='N';
document.forms[0].expectedvalue.value='Y';
 document.DATAELEMENTCROSSREF.expected_value.disabled=false;
 document[img_name].src='../../eCommon/images/mandatory.gif';
// document[img_name1].src='../../eCommon/images/empty.gif';
}
else if(myString=="SUFFIX")
{
	 document.forms[0].expectedvalue2.value='Y';
document.forms[0].expectedvalue.value='N';
 document.DATAELEMENTCROSSREF.expected_value.disabled=true;
 document.getElementById(what).style.display="block";
 document.DATAELEMENTCROSSREF.expected_value2.style.visibility='';
 document[img_name].src='../../eCommon/images/empty.gif';
 document[img_name1].src='../../eCommon/images/mandatory.gif';
}
else if(myString=="PRESUFFIX")
{
	 document.forms[0].expectedvalue2.value='Y'; 
document.forms[0].expectedvalue.value='Y';
	document[img_name].src='../../eCommon/images/mandatory.gif';
  document[img_name1].src='../../eCommon/images/mandatory.gif';
  document.DATAELEMENTCROSSREF.expected_value.disabled=false;
  document.getElementById(what).style.display="block";
  document.DATAELEMENTCROSSREF.expected_value2.style.visibility='';
  
}
else if(myString=="GR")
	{
 document.DATAELEMENTCROSSREF.expected_value.disabled=true;
document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden';
 document[img_name].src='../../eCommon/images/empty.gif';
  document[img_name1].src='../../eCommon/images/empty.gif';
document.DATAELEMENTCROSSREF.execution_order.disabled=true;

	}

else
{
document.DATAELEMENTCROSSREF.expected_value.disabled=false;
}
}
}
}
function hide( ) 
{
 document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
}
