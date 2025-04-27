//********************************************************************************************
function create()
{
}
//********************************************************************************************
function query()
{
	
}
//********************************************************************************************
function apply()
{
 var tab=window.hr_menu_bar.document.forms[0].tab.value; 

if(tab=='element')
		{

		this.window.bodyframe.document.forms[0].action="../../servlet/eXH.DataElementCrossRefElementSetupServlet";	
		this.window.bodyframe.document.forms[0].action_type.value='R';
		this.window.bodyframe.document.forms[0].target='messageFrame'
		this.window.bodyframe.document.forms[0].submit();
	
		}

		
		if(tab=='usage')
		{
		this.window.bodyframe.applicationframe.document.forms[0].action="../../servlet/eXH.DataElementCrossRefApplicationUsageServlet";	
		this.window.bodyframe.applicationframe.document.forms[0].action_type.value='R';
		this.window.bodyframe.applicationframe.document.forms[0].target='messageFrame'
		this.window.bodyframe.applicationframe.document.forms[0].submit();

		}

		if(tab=='table_values')
		{
			this.window.bodyframe.applicationframe.appltablecode.document.forms[0].action="../../servlet/eXH.DataElementCrossRefTableValuesServlet";	
			this.window.bodyframe.applicationframe.appltablecode.document.forms[0].action_type.value='R';
			this.window.bodyframe.applicationframe.appltablecode.document.forms[0].target='messageFrame'
			this.window.bodyframe.applicationframe.appltablecode.document.forms[0].submit();
		}

		if(tab=='non_table_values')
		{   
		/*	this.window.bodyframe.applicationframe.applnontablecode.document.forms[0].action="../../servlet/eXH.DataElementCrossRefNonTableValuesServlet";	
			this.window.bodyframe.applicationframe.applnontablecode.document.forms[0].action_type.value='R';
			this.window.bodyframe.applicationframe.applnontablecode.document.forms[0].target='messageFrame'
			this.window.bodyframe.applicationframe.applnontablecode.document.forms[0].submit();*/
		}
	  //  }

if(tab=='element_id')
		{
//this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value
//alert(this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value);
var Searchvalue_set=this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value;
var application_id=this.window.bodyframe.applmenubar.document.application_element_setup_form.application_id.value;
var element_id =this.window.bodyframe.applmenubar.document.application_element_setup_form.element_desc.value;


if(Searchvalue_set=='U')
{

	
this.window.bodyframe.elementIDframe.funSubmit2(application_id,element_id);

//this.window.bodyframe.elementIDframe.document.forms[0].action= '../../servlet/eXH.DataElementCrossRefSearchServlet';
//this.window.bodyframe.elementIDframe.document.forms[0].submit();
}	
else
{

	}
	  		}

if(tab=='Derivation-ID')
		{


//this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value
//alert(this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value);
var Searchvalue_set=this.window.bodyframe.applmenubartrans.document.application_element_setup_form.Action_code.value;
var application_id=this.window.bodyframe.applmenubartrans.document.application_element_setup_form.application_id.value;
var element_id =this.window.bodyframe.applmenubartrans.document.application_element_setup_form.element_desc.value;


if(Searchvalue_set=='U')
{


this.window.bodyframe.elementIDframetrans.funSubmit2(application_id,element_id);

//this.window.bodyframe.elementIDframe.document.forms[0].action= '../../servlet/eXH.DataElementCrossRefSearchServlet';
//this.window.bodyframe.elementIDframe.document.forms[0].submit();
}	
else
{

	}
	  		}

		
if(tab=='Rearrnage_id')
		{





	window.frames[2].frames[0].Remove1();
window.commontoolbarFrame.document.location.reload();
		}



		window.commontoolbarFrame.document.location.reload();
	
}
//********************************************************************************************
function reset()
{
	     
		 var tab=window.hr_menu_bar.document.forms[0].tab.value; 
         if(window.bodyframe.document.forms[0])
         {
	        window.bodyframe.document.forms[0].reset();
	     }

		if(window.bodyframe.applmenubar.document.forms[0])
		{	 
		  window.bodyframe.applmenubar.document.forms[0].reset();
		  window.bodyframe.applmenubar.document.forms[0].tab1.className="XHTAB2";
		  window.bodyframe.applmenubar.document.forms[0].tab2.className="XHTAB2";
		  window.bodyframe.applmenubar.document.forms[0].tab3.className="XHTAB2";
	 	  window.bodyframe.applicationframe.document.location.href = '../../eCommon/html/blank.html';
	    }
		

 
}
//********************************************************************************************
function onSelectAppliction()
{
if(parent.frames[0].document.forms[0].Standardcode_combo.value=="" ||parent.frames[0].document.forms[0].Standardcode_combo.value==null)
	{
alert(getMessage("XH1037","XH"));
	return false;
	}

parent.frames[1].location.href="../../eXH/jsp/DatacrossElementstanderdtable.jsp?standardcode="+parent.frames[0].document.forms[0].Standardcode_combo.value+"&Application_id="+parent.frames[0].document.forms[0].application.value;   
}

function funAdd(Action1)
{

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

 this.parent.frames[1].document.location.href="../../eXH/jsp/DataElementCrossRefElementIDAddModify.jsp?application_id="+application_id+"&element_id="+escape(element_id)+"&Rule="+this.document.forms[0].Rule.value;
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

document.forms[0].Action_code.value=Action;
var application_id = this.document.forms[0].application_id.value;


	var element_id = escape(this.document.forms[0].element_id.value);


//alert(document.forms[0].Action_code.value);
	//this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefBasicElement.jsp';
this.parent.frames[1].document.location.href="../../eXH/jsp/DataElementCrossRefElementID.jsp?application_id="+application_id+"&element_id="+element_id;
    parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';

 /*   this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/DataElementCrossRefElementID.jsp';
	this.document.forms[0].target='elementIDframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
*/
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
