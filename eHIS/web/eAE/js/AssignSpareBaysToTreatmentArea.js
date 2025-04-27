
var func="";
function query()
{f_query_add_mod.location.href ="../../eAE/jsp/AESpareAssignedBedQueryCriteria.jsp";
func="modify";

}
function create()  
{
f_query_add_mod.location.href = "../../eAE/jsp/AssignSpareBaysToTtmtAreaFrame.jsp" ;
func="insert";

}
function reset()
{
if(f_query_add_mod.document.location.href.indexOf("AESpareAssignedBedQueryResult.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	
}
 
function onSuccess() {
parent.frames[1].frames[1].location.reload();
}


function popTreatmentCode(obj)
   {
	   if(obj.value!='')
	   {
			var treatment_area_code = parent.frames[0].document.forms[0].treatment_area_code
           	while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);
    		var treatment = parent.frames[0].document.forms[0].treatment_area_code.value;
			var bedno =  parent.frames[0].document.forms[0].bed_no_val.value;
			var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/PopulateTreatmentArea.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='" +obj.value + "'><input type='hidden' name='treatment_area_code' id='treatment_area_code' value='"+treatment+"'><input type='hidden' name='asstrntbays' id='asstrntbays' value='bays'></form></BODY></HTML>";
			
			parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[2].document.form1.submit();
             
	   }
   else
	   {
		   	var treatment_area_code = parent.frames[0].document.forms[0].treatment_area_code;
			while(treatment_area_code.options.length > 1)
			treatment_area_code.remove(1);
			parent.frames[0].document.forms[0].bed_no_val.value = "";
			
	   }
   }

function submitPage()
{ 
	
	var treatment_area_code = document.forms[0].treatment_area_code.value;
	var clinic_code = document.forms[0].clinic_code.value;
	var bay_mode = document.forms[0].bay_mode.value;
	if (clinic_code=="")
	{
		//alert("APP-000001 Location cannot be blank");
		alert(getMessage('AE_BLANK_LOCATION','AE'));
		 document.forms[0].clinic_code.focus();
		 return;
	}
	
	if (treatment_area_code=="")
	{
		//alert("APP-000001 Treatment Area cannot be blank");
		alert(getMessage('AE_TMT_AREA_BLANK','AE'));
		 document.forms[0].treatment_area_code.focus();
		 return;
	}	
	
	else 
	{
		parent.frames[1].location.href = "../../eAE/jsp/AssignSpareBaysToTreatmentAreaResult.jsp?clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"&bay_mode="+bay_mode;
	}
}


function clearAll()
{
	
	/*parent.frames[1].location.href = '../../eCommon/html/blank.html';
	parent.frames[0].document.forms[0].reset();
	var treatment_area_code = parent.frames[0].document.forms[0].treatment_area_code;
	while(treatment_area_code.options.length > 1)
				treatment_area_code.remove(1);*/
	parent.frames[0].document.assign_sparebays_form.search.disabled = false;
    parent.frames[1].location.href='../../eCommon/html/blank.html';
    
		
}

function aa()
{
	var i;
	for (i=0;i<1000;i++ )
	{
		var temp = parent.frames[2].document.forms[0].bay_no.value;
	}

}

function setvalue(obj)
{
	if (obj.checked)
	{
		obj.value=obj.name;
		var temp = parent.frames[2].document.forms[0].bay_no.value;
	}
	else{
		obj.value=obj.name;
		parent.frames[2].document.forms[0].bay_no.value=obj.value;
		parent.frames[2].document.forms[0].status.value='A';
		var temp = parent.frames[2].document.forms[0].bay_no.value;
		}
}

function apply() {
 
 if(func == "insert")
	{
	 if (eval("parent.frames[2].frames[1].frames[1].document.result_form")!=null)
	  {
	  if (eval("parent.frames[2].frames[1].frames[1].document.result_form.n")!=null)
	   {
		var n=self.f_query_add_mod.frames[1].document.result_form.n.value;	
		var j=0;
		var temp="";
		for(i=0;i<n;i++)
		{
             if(eval("parent.frames[2].frames[1].frames[1].document.result_form.flag"+i).checked)
		    {
				var temp1= eval('parent.frames[2].frames[1].frames[1].document.result_form.flag'+i+'.value');
				temp=temp+temp1+'&';
				j++;
		     }
		  parent.frames[2].frames[1].frames[1].document.result_form.n.value=j;
		  parent.frames[2].frames[1].frames[1].document.result_form.temp.value=temp;
		}
		parent.frames[2].frames[1].frames[1].document.result_form.method = "POST";
		parent.frames[2].frames[1].frames[1].document.result_form.action = '../../servlet/eAE.AESpAssgnBedToTrtmtAreaServlet';
		parent.frames[2].frames[1].frames[1].document.result_form.target = "messageFrame";
		parent.frames[2].frames[1].frames[1].document.result_form.submit()
		}
		else
	    {
		    f_query_add_mod.location.href = "../../eAE/jsp/AssignSpareBaysToTtmtAreaFrame.jsp" ;
            func="insert";
		    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	    }
	  }
	  else
	  {
		    f_query_add_mod.location.href = "../../eAE/jsp/AssignSpareBaysToTtmtAreaFrame.jsp" ;
            func="insert";
		    messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	  }
	}
	else
	{
		if(parent.frames[2].frames[1].document.bed_treatment_area_form!=null)
           parent.frames[2].frames[1].document.bed_treatment_area_form.submit();
        else frames[0].location.reload();
	}
}




   //var validDictionary	= new ActiveXObject("Scripting.Dictionary");
const validDictionary = {};
validDictionary['key1'] = 'value1';
validDictionary['key2'] = 'value2';

/*
function chkValue(obj,val)
   {
	   var validcheck=parent.frames[1].document.forms[0].valid_values.value
	
	   var valid_val		=	"";
	   var hiddenValidArray=new Array();
	   hiddenValidArray	= validcheck.split(",");
	   var validLen=Math.abs(hiddenValidArray.length) ;
	   
	  for (j=0; j<validLen; j++)
	{
		valid_val	=	hiddenValidArray[j];
		if (!validDictionary.Exists(valid_val))
		validDictionary.add(valid_val, valid_val);
	}
    if (obj.checked)
	{
		valid_val	=	val;
		if (!validDictionary.Exists(valid_val))
				validDictionary.add(valid_val, valid_val);
	}
	else
	{
		valid_val	=	val;
		if (validDictionary.Exists(valid_val))
				validDictionary.Remove(valid_val);
	}
	
	document.forms[0].valid_values.value = ((validDictionary.Keys()).toArray()).toString();
   }
*/
function chkValue(obj, val) {
    // Assume validDictionary is a Map
    const validDictionary = new Map();
    
    // Get the valid values from the parent frame's form
    const validcheck = parent.frames[1].document.forms[0].valid_values.value;
    
    // Initialize the validDictionary with values from validcheck
    const hiddenValidArray = validcheck.split(",");
    hiddenValidArray.forEach(valid_val => {
        validDictionary.set(valid_val, valid_val);
    });
    
    // Check the value based on the checkbox state
    const valid_val = val;
    if (obj.checked) {
        validDictionary.set(valid_val, valid_val);
    } else {
        validDictionary.delete(valid_val);
    }
    
    // Update the valid_values in the form
    const validValuesArray = Array.from(validDictionary.keys());
    document.forms[0].valid_values.value = validValuesArray.join(",");
}
 function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
		 
	  }
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}






