function apply()
{


      if(window.frames[2].document.forms[0])
	{
 		window.frames[2].document.forms[0].action="../../servlet/eXH.DataElementCrossRefApplicationUsageServlet";	
		window.frames[2].document.forms[0].action_type.value='R';
		window.frames[2].document.forms[0].target='messageFrame'
		window.frames[2].document.forms[0].submit();
		window.commontoolbarFrame.document.forms[0].reset.disabled=true;
	}     
	window.commontoolbarFrame.document.location.reload();
}
//********************************************************************************************
function reset()
{

		// var tab=window.hr_menu_bar.document.forms[0].tab.value;  
	
         if(window.frames[1].document.forms[0])
         {
	        window.frames[1].document.forms[0].reset();
			frames[2].document.location.href='../../eCommon/html/blank.html';
	       messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
			//onSelectAppliction();
	     }


  
 
}
//********************************************************************************************
function onSelectAppliction()
{ 
 
	var appl =  frames[1].document.forms[0].application.value; 
var code_yn=frames[1].document.forms[0].code.value;
frames(2).document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid='+appl;
frames(3).location.href ='../../eCommon/jsp/MstCodeError.jsp';
/*if(parent.frames[0].document.forms[0].Standardcode_combo.value=="" ||parent.frames[0].document.forms[0].Standardcode_combo.value==null)
	{
alert(getMessage("XH1037","XH"));
	return false;
	}

parent.frames[1].location.href="../../eXH/jsp/DatacrossElementstanderdtable.jsp?standardcode="+parent.frames[0].document.forms[0].Standardcode_combo.value+"&Application_id="+parent.frames[0].document.forms[0].application.value;   */
}

function funAdd(Action1)
{

this.parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	document.forms[0].Action_code.value=Action1;
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	var application_id = this.document.forms[0].application_id.value;


	var element_id = this.document.forms[0].element_id.value;
	var element_desc=this.document.forms[0].element_desc.value;

	var fields = new Array (  document.forms[0].application_id,
					     document.forms[0].element_desc				     
					   );


var names = new Array ( 
						getLabel("Common.Application.label","common"),
						getLabel("Common.Element.label","common"));

//alert(window.parent.parent.frames[3].name);   
if(!checkFields( fields, names,window.parent.parent.frames[3]))
	{
//	parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//window.parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?<%=params%>";
	}
	else
	{
 
 this.parent.frames[1].document.location.href="../../eXH/jsp/DataElementCrossRefElementIDAddModify.jsp?application_id="+application_id+"&element_id="+escape(element_id)+"&Rule="+this.document.forms[0].Rule.value+"&mode=I";
//parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';  
 
	}
	
 /*   this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/DataElementCrossRefElementID.jsp';
	this.document.forms[0].target='elementIDframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
*/
//this.parent.frames[0].document.location.href=document.forms[0].sourcedata.value;
window.parent.parent.commontoolbarFrame.document.location.reload();
}

function funSearch(Action)
{
	
	var rule=document.forms[0].Rule.value;

document.forms[0].Action_code.value=Action;
var application_id = this.document.forms[0].application_id.value;

var element_desc=escape(this.document.forms[0].element_desc.value);
	var element_id = escape(this.document.forms[0].element_id.value);

if(element_desc=="")
	{
element_id="";
}
//alert(document.forms[0].Action_code.value);
	//this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefBasicElement.jsp';

	
this.parent.frames[1].document.location.href="../../eXH/jsp/DataElementCrossRefElementID.jsp?application_id="+application_id+"&element_id="+element_id+"&Rule="+rule+"&element_desc="+element_desc+"&segment_type="+document.forms[0].segment_type.value+"&Standardcode_combo="+document.forms[0].Standardcode_combo.value;
    
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';

 /*   this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/DataElementCrossRefElementID.jsp';
	this.document.forms[0].target='elementIDframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
*/
}


function funValidSearch()
{

		var rule=document.forms[0].Rule.value;
		var application_id = this.document.forms[0].application_id.value;
        var element_desc=escape(this.document.forms[0].element_desc.value);
		var element_id = escape(this.document.forms[0].element_id.value);
		var event_type=this.document.forms[0].event_type.value;
       var source=document.forms[0].sourcedata.value;
var segment_type=document.forms[0].segment_type.value;

//alert(segment_type)
		if(element_desc=="")
	 { 
      element_id=""; 
     }

			this.window.parent.frames[1].document.location.href="../../eXH/jsp/DataElementCrossRefValidationSearchMain.jsp?application_id="+application_id+"&element_id="+element_id+"&element_desc="+element_desc+"&segment_type="+segment_type+"&event_type="+event_type+'&mode=I';
//alert(window.parent.parent.frames(3 ).name);
window.parent.parent.frames[3].location.href ='../../eCommon/jsp/error.jsp';

} 
 
function cancel(img_name1,what)				    
{
	 document[img_name1].src='../../eCommon/images/empty.gif';
	document.getElementById(what).style.display="none";
	document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
    document.DATAELEMENTCROSSREF.reset();
}
function record(val)
{

 window.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeToolbar.jsp';
var fields="";
var names="";
	if(document.forms[0].expectedvalue.value=='Y')
	{

if(document.forms[0].expectedvalue2.value=='Y')
	{

 fields = new Array ( 
					     document.forms[0].expected_value,document.forms[0].expected_value2,document.forms[0].Position_value				     
					   );
 names = new Array (getLabel("eXH.ExpectedValue.Label","XH"),getLabel("eXH.ExpectedValue2.Label","XH"),getLabel("Common.Position.Label","common"));



	}
	else
		{

 fields = new Array ( 
					     document.forms[0].expected_value,document.forms[0].Position_value				     
					   );

 names = new Array (getLabel("eXH.ExpectedValue.Label","XH"),getLabel("Common.Position.Label","common"));

		}

	} 
	else
	{

if(document.forms[0].expectedvalue2.value=='Y')
		{


 fields = new Array ( 
					    document.forms[0].expected_value2,document.forms[0].Position_value				     
					   );

 names = new Array (getLabel("eXH.ExpectedValue2.Label","XH"),getLabel("Common.Position.Label","common"));
		}
else
		{

		 fields = new Array ( 
					   document.forms[0].Position_value				     
					   );
		 names = new Array (getLabel("Common.Position.Label","common"));
		}


	}


	



if(!checkFields( fields, names, window.parent.parent.messageFrame))
	{
	
	}
	else
	{
		
 this.document.forms[0].actualmode.value = val;
 this.document.forms[0].submit();
	}
 
window.parent.parent.commontoolbarFrame.document.location.reload();



 
}
function recordVal()
{
}
function hide( ) 
{
// document.DATAELEMENTCROSSREF.expected_value2.style.visibility = 'hidden'; 
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
var Expected_ena=["IF","<>","=", "<", ">", "<=",">=","BETWEEN","NOT BETWEEN","IS NULL","IS NOT NULL","IN","NOT IN","LIKE","NOT LIKE","PREFIX","PRESUFFIX","SUFFIX"];



	



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
else
{
document.DATAELEMENTCROSSREF.expected_value.disabled=false;
}
}
}
}
