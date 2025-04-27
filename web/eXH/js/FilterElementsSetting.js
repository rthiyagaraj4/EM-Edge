function valuePopulate(string)
{
	if(string=="SIU_L") 
	{
 		//str="C-Clinic-E-Operating Room";
		str="C-"+getLabel("eXH.Clinic.Label","XH")+"-E-"+getLabel("eXH.OperatingRoom.Label","XH");
       	return str;
	}

	if(string=="ORM_L")
	{
		//str1="C-Clinic-W-Nursing Unit-D-Daycare Unit-U-Procedure Unit-R-Referal";
		str1="C-"+getLabel("eXH.Clinic.Label","XH")+"-W-"+getLabel("eXH.NursingUnit.Label","XH")+"-D-"+getLabel("eXH.DaycareUnit.Label","XH")+"-U-"+getLabel("eXH.ProcedureUnit.Label","XH")+"-R-"+getLabel("eXH.Referal.Label","XH");
		return str1;
	}

	if(string=="ADT_L")
	{
		 //str2="C-Clinic-W-Nursing Unit-D-Daycare Unit-U-Procedure Unit";
		 str2="C-"+getLabel("eXH.Clinic.Label","XH")+"-W-"+getLabel("eXH.NursingUnit.Label","XH")+"-D-"+getLabel("eXH.DaycareUnit.Label","XH")+"-U-"+getLabel("eXH.ProcedureUnit.Label","XH");
		return str2;
	}

	if(string=="SUB_L") 
	{

		 //str3="M-Room-A-Treatment Area";
		 str3="M-"+getLabel("eXH.Room.Label","XH")+"-A-"+getLabel("eXH.TreatmentArea.Label","XH");
		return str3;
	}
	
	if(string=="PT") 
	{

		 //str4="P-Patient Type";
		str4="P-"+getLabel("eXH.PatientType.Label","XH");
		return str4;
	}
	
	if(string=="PC") 
	{

		 //str5="O-Order Category";
		 str5="O-"+getLabel("eXH.OrderCategory.Label","XH");
		return str5;
	}
  
  if(string=="OT") 
	{

		// str6="T-Order Type";
		 str6="T-"+getLabel("eXH.OrderType.Label","XH");
		return str6;
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
function populateValues()
{
    var msgType=this.document.forms[0].message_type.value;
	
	var	filter_type=this.document.forms[0].f1;
    var filter_sub_type=this.document.forms[0].f2;
    var filter_sub1_type=this.document.forms[0].f3;
    var filter_sub2_type=this.document.forms[0].f4;

	var tempArray1=new Array(filter_type,filter_sub_type,filter_sub1_type,filter_sub2_type);
	var tempArray=new Array('filter_type','filter_sub_type','filter_sub1_type','filter_sub2_type');
	for(var i=0;i<tempArray.length;i++)
    {
    
	
	if(((msgType=='ADT')||(msgType=='ADR'))&&(tempArray1[i].value=='L'))
	{    
		callArray(tempArray[i],"ADT_L");
	}
	if(((msgType=='ORM')||(msgType=='ORU'))&&(tempArray1[i].value=='L'))
	{
		callArray(tempArray[i],"ORM_L");
	}
	if((msgType=='SIU')&&(tempArray1[i].value=='L'))
	{
		callArray(tempArray[i],"SIU_L");
	}

	if(((msgType=='SIU')||(msgType=='ADT')||(msgType=='ADR')||(msgType=='ORM')||(msgType=='ORU'))&&(tempArray1[i].value=='S'))
	{
		callArray(tempArray[i],"SUB_L");
	}
	
	if(((msgType=='SIU')||(msgType=='ADT')||(msgType=='ADR')||(msgType=='ORM')||(msgType=='ORU'))&&(tempArray1[i].value=='P'))
	{
		callArray(tempArray[i],"PT");
	}
	
	if(((msgType=='SIU')||(msgType=='ADT')||(msgType=='ADR')||(msgType=='ORM')||(msgType=='ORU'))&&(tempArray1[i].value=='C'))
	{
		callArray(tempArray[i],"PC");
	}

	if(((msgType=='SIU')||(msgType=='ADT')||(msgType=='ADR')||(msgType=='ORM')||(msgType=='ORU'))&&(tempArray1[i].value=='T'))
	{
		callArray(tempArray[i],"OT");
	}
}

}

//*****************************************************************************************/
function  optionSettings()
{
populateValues();	
setTextValues();

}
//***************************************************************************************
function setTextValues()
{
var mode=this.document.forms[0].actualmode.value;	
var f11_des=this.document.forms[0].f11_desc.value
var ftype=document.getElementById("filter_type");
var index=ftype.selectedIndex;
var ftype_ele=document.getElementById("filterelement_desc");
var ftype_des=document.getElementById("filterelement_value");
if(mode=='M') ftype_ele.value=f11_des;
ftype_des.value=ftype.options[index].value;

}

function setTextValues1()
{
var mode=this.document.forms[0].actualmode.value;
var f22_des=this.document.forms[0].f22_desc.value

var ftype1=document.getElementById("filter_sub_type");
var index1=ftype1.selectedIndex;
var ftype1_ele=document.getElementById("filterelement_sub_desc");
var ftype1_des=document.getElementById("filterelement_sub_value");
if(mode=='M') ftype1_ele.value=f22_des;
ftype1_des.value=ftype1.options[index1].value;
var ftype=document.getElementById("filter_type");
if(ftype.value=='*')
{
removeAllOptions(ftype1);
var optn11= document.createElement("OPTION");
optn11.text = getLabel("eXH.None.Label","XH");
optn11.value ='*';
ftype1.options.add(optn11);
}



}

function setTextValues2()
{
var mode=this.document.forms[0].actualmode.value;
var f33_des=this.document.forms[0].f33_desc.value

var ftype2=document.getElementById("filter_sub1_type");
var index2=ftype2.selectedIndex;
var ftype2_ele=document.getElementById("filterelement_sub1_desc");
var ftype2_des=document.getElementById("filterelement_sub1_value");
 if(mode=='M') ftype2_ele.value=f33_des;
ftype2_des.value=ftype2.options[index2].value;

/*var ftype1=document.getElementById("filter_sub_type");
alert(ftype1.value);
if(ftype1.value=='*')
{
removeAllOptions(ftype2);
var optn11= document.createElement("OPTION");
optn11.text = getLabel("eXH.None.Label","XH");
optn11.value ='*';
ftype2.options.add(optn11);
}*/
}


function setTextValues3()
{
var mode=this.document.forms[0].actualmode.value;
var f44_des=this.document.forms[0].f44_desc.value
var ftype3=document.getElementById("filter_sub2_type");
var index3=ftype3.selectedIndex;
var ftype3_ele=document.getElementById("filterelement_sub2_desc");
var ftype3_des=document.getElementById("filterelement_sub2_value");
if(mode=='M') ftype3_ele.value=f44_des;
ftype3_des.value=ftype3.options[index3].value;
}

//*****************************************************************************

function searchPopulation()
{

var insertoper =document.getElementById("insertoper");
var modifyoper =document.getElementById("modifyoper");
modifyoper.style.display='block';
insertoper.style.display='none';


populateValues();

var	filter1=this.document.forms[0].f11.value;
var filter2=this.document.forms[0].f22.value;
var filter3=this.document.forms[0].f33.value;
var filter4=this.document.forms[0].f44.value;

var ftype=document.getElementById("filter_type");
var ftype1=document.getElementById("filter_sub_type");
var ftype2=document.getElementById("filter_sub1_type");
var ftype3=document.getElementById("filter_sub2_type");

for( var j=0;j<ftype.options.length;j++)
	{
	   if(ftype.options[j].value ==filter1)
       ftype.options[j].selected=true;
	}
for( var j=0;j<ftype1.options.length;j++)
	{
	   if(ftype1.options[j].value ==filter2)
       ftype1.options[j].selected=true;
	}
	for( var j=0;j<ftype2.options.length;j++)
	{
	   if(ftype2.options[j].value ==filter3)
       ftype2.options[j].selected=true;
	}
	for( var j=0;j<ftype3.options.length;j++)
	{
	   if(ftype3.options[j].value ==filter4)
       ftype3.options[j].selected=true;
	}
setTextValues();
}


function firstMethod()
{
 var mode=this.document.forms[0].actualmode.value;
 if(mode=='I') optionSettings();
 if(mode=='M') searchPopulation();

}
