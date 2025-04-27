/*
	Developed By       :  sudhakaran
	Developed on   	   :  27/02/2002
	Module Name 	   :  DR
	Function Name	   :  Exclude Duplicates
*/
						
function replaceStr(str,start,end,str1){

	var len =str.length;
	return(str.substr(0,parseInt(start))+str1+str.substr(parseInt(end)+1,len))
}
 
 function deleterecord()
{
	if(frames[1].length > 1)
	{
		var for_name=frames[1].frames[1].document.forms[0].name;
		if(for_name=='result_form')
		{
			
			if(confirm(getMessage("DELETE_RECORD","Common")))
			{
				var proceed_val = 0;
				var proceed;
				var chk_value=0;
				var p_patient_id1="";
				var p_patient_id2="";
				var fin_patient_id_val="";
				var count=frames[1].frames[1].document.forms[0].count.value;
				var start=frames[1].frames[1].document.forms[0].start.value;
			   	for(loops=1;loops<=count;loops++)
				{
					var var_chk_tf =eval("frames[1].frames[1].document.forms[0].checkbox"+loops).checked;
					if(var_chk_tf==true)
					{
						p_patient_id1=eval("frames[1].frames[1].document.forms[0].view_pat1_id"+loops).value;
						p_patient_id2=eval("frames[1].frames[1].document.forms[0].view_pat2_id"+loops).value;
						if (loops==1) fin_patient_id_val = p_patient_id1+'|'+p_patient_id2;
						else
						{
							fin_patient_id_val += '~' + p_patient_id1+'|'+p_patient_id2;
						}
						proceed_val++;
					}
					start++;
				}
				if(proceed_val > 0) proceed = true;
				else proceed = false;
				if(proceed == true)
				{
					frames[1].frames[1].document.forms[0].fin_patient_id.value=fin_patient_id_val;
					if(fin_patient_id_val=='')
					{
						frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
					}
					else
					{
						frames[1].frames[1].document.forms[0].submit();
					}
				}
				else if(proceed == false)
				{
					var messag = getMessage("ATLEAST_ONE_SELECTED","Common");
					frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
				}
			}
			else
				frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		}
	}
	else
	{
		frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
	}
}

// WHEN THE CREATE BUTTON IS PRESSED
function create()
{
      parent.frames[2].frames[1].location.href='../../eDR/jsp/ExcludePossibleDuplicateManual.jsp';
}

function reset()
{
	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
        return false;
    }
	
	if(parent.frames[2].frames[1].document.forms[0])
	{  
		
		 parent.frames[2].frames[1].document.forms[0].reset();
		 parent.frames[2].frames[1].document.getElementById("pat_name1").innerHTML='';
		 parent.frames[2].frames[1].document.getElementById("pat_name2").innerHTML='';
		
	}
	else if(parent.frames[2].frames[1].frames[0].document.forms[0].name=="query_form")
	{  
		 parent.frames[2].frames[1].frames[0].document.forms[0].reset();
		 parent.frames[2].frames[1].frames[0].document.getElementById("pat_name1").innerHTML='';
		 parent.frames[2].frames[1].frames[0].document.forms[0].patient_id.value='';
		 parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	}
}

function query()
{     	
     parent.frames[2].frames[1].location.href='../../eDR/jsp/ExcludePossiblePatIdQueryFrameset.jsp';
}

// this function is called on load of the valid patient frame
function button_disable(start,end,max_record,startVar,endVar) {
	if(parseInt(max_record) > 0){ // if there is no record next and previous should not be enabled
				//cond:1
				if((parseInt(start)==parseInt(startVar)) && (parseInt(end)< parseInt(max_record))) {
						parent.frames[1].document.forms[0].previous.disabled=true;
						parent.frames[1].document.forms[0].next.disabled=false;
					}
				//cond:2
				if(parseInt(start)==parseInt(startVar) && parseInt(end) >= parseInt(max_record)) {
						parent.frames[1].document.forms[0].previous.disabled=true;
						parent.frames[1].document.forms[0].next.disabled=true;
				}
				//cond:3
				 if((parseInt(start)>parseInt(endVar) )&& (parseInt(end) < parseInt(max_record)) ){
							parent.frames[1].document.forms[0].previous.disabled=false;
							parent.frames[1].document.forms[0].next.disabled=false;
				}
				//cond:4
				if((parseInt(start)>parseInt(endVar) )&&(parseInt(end) >= parseInt(max_record))){
						parent.frames[1].document.forms[0].previous.disabled=false;
						parent.frames[1].document.forms[0].next.disabled=true;
				}
		}
		else
		{
		if(parseInt(max_record) <= 0)
		{
			parent.frames[1].document.forms[0].previous.disabled=true;
			parent.frames[1].document.forms[0].next.disabled=true;
		}
	 }
}

// this is called when the next button is pressed
function call_next(startVar,endVar){
		var start=parent.frames[1].document.forms[0].start.value;
		var end=parent.frames[1].document.forms[0].end.value;
		var patient_id=parent.frames[1].document.forms[0].patient_id.value;
		var function_name="";
		if(start=="")start="0";
		if(end=="")end="0";
		if(startVar=="")	startVar="0";
		if(endVar=="")endVar="0";
	obJ1=parent.frames[0].document.forms[0];
	obJ2=parent.frames[1].document.forms[0];

	chr=(obJ1.CheckBoxes.value).substr(parseInt(obJ2.end.value),1)
	obJ2.chkedVls.value="";
	for(i=1;i<9;i++) 
	{
		if(eval("parent.frames[1].document.forms[0].checkbox"+i))
		{
			if (eval("parent.frames[1].document.forms[0].checkbox"+i).checked==true)
			{
				obJ2.chkedVls.value+=i;
				
				}
		    else obJ2.chkedVls.value+="0";
		}
		else obJ2.chkedVls.value+="0";
	}
	obJ1.CheckBoxes.value=(replaceStr(obJ1.CheckBoxes.value,parseInt(obJ2.start.value)-1,parseInt(obJ2.end.value)-1,obJ2.chkedVls.value));
	var str=obJ1.CheckBoxes.value;
       if(str==null || str=='') str='';
		parent.frames[1].document.location.href='../../eDR/jsp/ExcludePossiblePatIdQueryResult.jsp?patient_id='+patient_id+'&from='+(parseInt(start)+parseInt(endVar))+'&to='+(parseInt(end)+parseInt(endVar))+'&criteria=query'+'&chkVls='+str;
	
		}


// this is called when the previous button is pressed	
function call_previous(startVar,endVar)
{

var start=parent.frames[1].document.forms[0].start.value;
var end=parent.frames[1].document.forms[0].end.value;
var patient_id=parent.frames[1].document.forms[0].patient_id.value;
var function_name="";
	if(start=="")start="0";
	if(end=="")end="0";
	if(startVar=="")startVar="0";
	if(endVar=="")endVar="0";
	obJ1=parent.frames[0].document.forms[0];
	obJ2=parent.frames[1].document.forms[0];
   
	chr=(obJ1.CheckBoxes.value).substr(parseInt(obJ2.end.value),1)
	obJ2.chkedVls.value="";
	//obJ1.dup_group_id.value="";
	for(i=1;i<9;i++) 
	{
		if(eval("parent.frames[1].document.forms[0].checkbox"+i))
		{
			if (eval("parent.frames[1].document.forms[0].checkbox"+i).checked==true)
			{
				obJ2.chkedVls.value+=i;
				}
		    else obJ2.chkedVls.value+="0";
		}
		else obJ2.chkedVls.value+="0";
	}
	obJ1.CheckBoxes.value=(replaceStr(obJ1.CheckBoxes.value,parseInt(obJ2.start.value)-1,parseInt(obJ2.end.value)-1,obJ2.chkedVls.value));
	var str=obJ1.CheckBoxes.value;
       if(str==null || str=='') str='';
		parent.frames[1].document.location.href="../../eDR/jsp/ExcludePossiblePatIdQueryResult.jsp?from="+(parseInt(start)-parseInt(endVar))+"&to="+(parseInt(end)-parseInt(endVar))+"&function_name="+function_name+"&patient_id="+patient_id+"&criteria=search"+'&chkVls='+str;;  
}

function call_rowchk(obj)
{
	
}

function select_all(start,end)
{
var i;
for(i=parseInt(start);i<=parseInt(end);i++)
{
eval("parent.frames[1].document.forms[0].row"+(i)).checked=true;
}
}


//for getting patient_id from MP_PARAM
		async function search_patient_ID1(file,pat2)// this function is called when the question mark button is pressesd and it returns the patient_id
		  {	    
			//var chk_pat_id=parent.frames[1].document.forms[0].verify_pat2.value;
			var chk_pat_id=parent.frames[1].document.forms[0].patient_id2.value;
			
			var patient_id = await PatientSearch();
			
			if (patient_id=='undefined' || patient_id==null) patient_id="";
			if (patient_id!='')
			{
				if(chk_pat_id==patient_id)
				{
					var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					parent.frames[1].document.forms[0].patient_id1.focus();
				}
				else
				{		
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH Patient_ID1=\""+patient_id+"\" function_id='EXCLUDE_DUPLICATES' /></root>"
    				
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","ValidatePopulatePatient.jsp",false) 

					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
						
					responseText = trimString(responseText)
						
					eval(responseText)
					
					if (patient_id !='undefined')
						parent.frames[1].document.forms[0].patient_id1.value=patient_id;
					//document.location.href='../../eDR/jsp/'+file+'.jsp?patient_id1='+patient_id+'&patient_id2='+pat2;
				}		
			}
		}

		async function search_patient_ID2(file,pat1)// this function is called when the question mark button is pressesd and it returns the patient_id
		{
			//var chk_pat_id=parent.frames[1].document.forms[0].verify_pat1.value;
			var chk_pat_id=parent.frames[1].document.forms[0].patient_id1.value;			
			var patient_id = await PatientSearch();
			if (patient_id=='undefined' || patient_id==null) patient_id="";
			if (patient_id!='')
			{
				if(chk_pat_id==patient_id)
				{
					var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					parent.frames[1].document.forms[0].patient_id2.focus();
				}
				else
				{
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH Patient_ID2=\""+patient_id+"\" function_id='EXCLUDE_DUPLICATES' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","ValidatePopulatePatient.jsp",false) 

					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)
					if (patient_id !='undefined')
						parent.frames[1].document.forms[0].patient_id2.value=patient_id;
					//document.location.href='../../eDR/jsp/'+file+'.jsp?patient_id1='+pat1+'&patient_id2='+patient_id;
				}	
			}
		}
	

		function execute_query()
		{ 
			var patient_id=parent.frames[0].document.forms[0].patient_id.value;
		     parent.frames[0].document.forms[0].CheckBoxes.value="";
			parent.frames[1].location.href='../../eDR/jsp/ExcludePossiblePatIdQueryResult.jsp?patient_id='+patient_id;
		  		
		}

		function call_patient_id1(file,obj)
		{
			obj.value=obj.value.toUpperCase();
			patient_id=obj.value;
			pat2=parent.frames[1].document.forms[0].patient_id2.value;
			
			if (patient_id != '')
			{
				if(patient_id==pat2)
				{
					var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					parent.frames[1].document.forms[0].patient_id1.value="";
					parent.frames[1].document.forms[0].patient_id1.focus();
				}
				else{
				
				   var xmlDoc="";
				   var xmlHttp = new XMLHttpRequest()
				   xmlStr ="<root><SEARCH Patient_ID1=\""+patient_id+"\" function_id='EXCLUDE_DUPLICATES' /></root>"
				   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				   xmlHttp.open("POST","ValidatePopulatePatient.jsp",false)                   
				   xmlHttp.send(xmlDoc)
				   responseText=xmlHttp.responseText
				   responseText = trimString(responseText)
				   eval(responseText);					   
				}
				
			}
			else{
				
				parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num= "
			}

			 
		}

		function call_patient_id2(file,obj)
		{
			obj.value=obj.value.toUpperCase();
			pat2=obj.value;
			patient_id=parent.frames[1].document.forms[0].patient_id1.value;
			if (pat2!='')
			{
				if(patient_id==pat2)
				{
					var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					parent.frames[1].document.forms[0].patient_id2.value="";
					parent.frames[1].document.forms[0].patient_id2.focus();
				}
				else
				{
				   var xmlDoc="";
				   var xmlHttp = new XMLHttpRequest()
				   xmlStr ="<root><SEARCH Patient_ID2=\""+pat2+"\" function_id='EXCLUDE_DUPLICATES' /></root>"
				   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				   xmlHttp.open("POST","ValidatePopulatePatient.jsp",false)

				   xmlHttp.send(xmlDoc)
				   responseText=xmlHttp.responseText
				   responseText = trimString(responseText)
				   eval(responseText)
				}
			}
			else
				parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num= "
		}


function call_patient_query(obj)
{ 
	/*
	obj.value=obj.value.toUpperCase();
	var patient_id=obj.value;	
	document.location.href='../../eDR/jsp/ExcludePossiblePatIdQuery.jsp?patient_id='+patient_id;
	*/

	obj.value = obj.value.toUpperCase();
	p_patient_id = obj.value ;

	if (p_patient_id.length>0)
	{
		
	   var xmlDoc="";
	   var xmlHttp = new XMLHttpRequest();
	   xmlStr ="<root><SEARCH Patient_ID=\""+p_patient_id+"\" function_id='EXCLUDE_DUPLICATES1' /></root>";
	   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	   xmlHttp.open("POST","ValidatePopulatePatient.jsp",false);

	   xmlHttp.send(xmlDoc);
	   responseText=xmlHttp.responseText;
	   responseText = trimString(responseText);
	   eval(responseText);
	}
}

async function patient_details_view(){
	
			var chk_value=0;
			var p_patient_id1="";
			var p_patient_id2="";
			var count=parent.frames[1].document.forms[0].count.value;			
			
			for(loops=1;loops<=count;loops++)
			{
			var var_chk_tf =eval("parent.frames[1].document.forms[0].checkbox"+loops).checked;
			if(var_chk_tf==true){
			chk_value++;
			p_patient_id1=eval("parent.frames[1].document.forms[0].view_pat1_id"+loops).value
			p_patient_id2=eval("parent.frames[1].document.forms[0].view_pat2_id"+loops).value
			}
			
			}
			
			if(chk_value==0)
			{
			var errors = getMessage("PATIENT_NOT_SELECTED","DR") ;
			parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	
			}
			else if(chk_value>1)
			{
			var errors = getMessage("ONLY_ONE_PAIR","DR") ;
			parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	
			}
			else if (chk_value==1)
			{
			var errors = '';
			parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			var title= encodeURIComponent(getLabel("eDR.PossibleDuplicatesDetails.label","DR"));
			var dialogHeight= "80vh" ;
			var dialogWidth	= "90vw" ;
			var dialogTop="30";
			var dialogLeft="30";
			var scroll = "yes";
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;			await top.window.showModalDialog('../../eDR/jsp/ExcludePossibleDuplicateDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
			}
}

function checkIsValidForProceed()
{
 var url = excludeDuplicatePatients.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1))
  return true;
 else
  return false;
}
		
function apply()
{
			if (! (checkIsValidForProceed()) )
			{
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				return false;
			}
	
			var patient_id1=frames[1].document.forms[0].patient_id1.value;
			var patient_id2=frames[1].document.forms[0].patient_id2.value;
			var fields = new Array ( frames[1].document.forms[0].patient_id1,frames[1].document.forms[0].patient_id2);
			var names = new Array (getLabel("eDR.PatientID1.label","DR"),
									getLabel("eDR.PatientID2.label","DR") );
			if(parent.frames[2].frames[1].checkFields( fields, names, messageFrame))
			{
					frames[1].document.forms[0].submit();
			}
	
}

function onSuccess(){
	frames[1].location.href='../../eCommon/html/blank.html';
}

function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "90vh" ;
	var dialogWidth	= "85vw" ;
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	top.window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}
async function pat_search()// this function is called when the question mark button is pressesd and it returns the patient_id
{
	
		//var patient_id = PatientSearch('','','','','','','','','','','DR_EXCLUDE_POSSIBLE_PATIENTS');
		var patient_id = await PatientSearch('','','','','','','','','','','');
		
		if(patient_id !=null)
		{			
		document.location.href='../../eDR/jsp/ExcludePossiblePatIdQuery.jsp?patient_id='+patient_id;
		}
		else{
		var errors = getMessage("PATIENT_NOT_SELECTED","DR") ;
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[0].document.forms[0].patient_id.focus();
		}
		
		}

