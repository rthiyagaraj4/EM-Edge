/*
	Developed By       :  sudhakaran
	Developed on   	   :  27/02/2002
	Module Name 	   :  DR
	Function Name	   :  Exclude Duplicates
*/
	
function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}						

function reset()
{}
function query()
{
      parent.frames[1].frames[1].location.href='../../eDR/jsp/excludePossiblePatIdQueryFrameset.jsp';
}

function call_next(startVar,endVar)
	{
		var start=parent.frames[2].document.forms[0].start.value;
		
		var end=parent.frames[2].document.forms[0].end.value;
		
		var patient_id=parent.frames[2].document.forms[0].patient_id.value;
		var function_name="";
		if(start=="")start="0";
		if(end=="")end="0";
		if(startVar=="")startVar="0";
		if(endVar=="")endVar="0";
	//parent.frames[2].document.location.href='../../eDR/jsp/QueryExcludePossiblePatIdQueryResult.jsp?patient_id='+patient_id+'&from='+(parseInt(start)+parseInt(endVar))+'&to='+(parseInt(end)+parseInt(endVar))+'&criteria=query';
	parent.frames[2].document.location.href='../../eDR/jsp/QueryExcludePossiblePatIdQueryResult.jsp?patient_id='+patient_id+'&from='+(parseInt(start)+parseInt(endVar))+'&to='+(parseInt(end)+parseInt(endVar))+'&criteria=query';
	
		}

async function callPatientSearch()
{

var ErrorText = '';
//	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	//var p_patient_id = PatientSearch('','','','','','','','','','','DR_EXCLUDED_PATIENT_ID');
	var p_patient_id = await PatientSearch('','','','','','','','','','','');

	if (p_patient_id != null)
	{
		document.location.href='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp?patient_id='+p_patient_id;

	}
	else
	{
			var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
//			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}

}

// this is called when the previous button is pressed	
function call_previous(startVar,endVar)
{
var start=parent.frames[2].document.forms[0].start.value;

var end=parent.frames[2].document.forms[0].end.value;

var patient_id=parent.frames[2].document.forms[0].patient_id.value;
var function_name="";
	if(start=="")start="0";
	if(end=="")end="0";
	if(startVar=="")startVar="0";
	if(endVar=="")endVar="0";
	parent.frames[2].document.location.href="../../eDR/jsp/QueryExcludePossiblePatIdQueryResult.jsp?from="+(parseInt(start)-parseInt(endVar))+"&to="+(parseInt(end)-parseInt(endVar))+"&function_name="+function_name+"&patient_id="+patient_id+"&criteria=search";  
}

function call_rowchk(obj)
{
	
}



//for getting patient_id from MP_PARAM
		function search_patient_ID1(file,pat2)// this function is called when the question mark button is pressesd and it returns the patient_id
		{
	    
		var chk_pat_id=parent.frames[1].document.forms[0].verify_pat2.value;
		var patient_id = PatientSearch();
		if(chk_pat_id==patient_id){
		var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
		parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[1].document.forms[0].patient_id1.focus();
		}
		else
		{			
		document.location.href='../../eDR/jsp/'+file+'.jsp?patient_id1='+patient_id+'&patient_id2='+pat2;
		}
		
		}
		function search_patient_ID2(file,pat1)// this function is called when the question mark button is pressesd and it returns the patient_id
		{
	   	var chk_pat_id=parent.frames[1].document.forms[0].verify_pat1.value;
		var patient_id = PatientSearch();
		if(chk_pat_id==patient_id)
		{
		var errors = getMessage("DUPLICATE_PATIENT_ENTRY","DR") ;
		parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[1].document.forms[0].patient_id2.focus();
		}
		else{
		document.location.href='../../eDR/jsp/'+file+'.jsp?patient_id1='+pat1+'&patient_id2='+patient_id;
		}
		
		}
		

		
function execute_query()
{ 
	var patient_id=parent.frames[1].document.forms[0].patient_id.value;
	//parent.frames[1].document.forms[0].Execute.disabled=true;	
	document.location.href='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp?patient_id='+patient_id;	parent.frames[2].location.href='../../eDR/jsp/QueryExcludePossiblePatIdQueryResult.jsp?patient_id='+patient_id;
}

/*
function call_patient_query(obj){

		obj.value = obj.value.toUpperCase();
		var patient_id=obj.value;
		document.location.href='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp?patient_id='+patient_id;
}
*/

function patient_details_view(){
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
			var errors = getMessage("ONLY_ONE_PAIR","DR") ;
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	
			}
			else if(chk_value>1)
			{
			var errors = getMessage("ONLY_ONE_PAIR","DR") ;
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	
			}
			else if (chk_value==1)
			{
			var errors = '';
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;

			var title= getLabel("eDR.PossibleDuplicatesDetails.label","DR");
			var dialogHeight= "20" ;
			var dialogWidth	= "28" ;
			var dialogTop="30";
			var dialogLeft="30";
			var scroll = "yes";
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes; scroll="+scroll; ;			window.showModalDialog('../../eDR/jsp/PossibleDuplicateDisplayFrameset.jsp?p_patient_id1='+p_patient_id1+'&p_patient_id2='+p_patient_id2+'&title='+title,arguments,features);
			}



}
		
function button_disable(start,end,max_record,startVar,endVar) {
	if(parseInt(max_record) > 0){ // if there is no record next and previous should not be enabled
				//cond:1 
				
				if((parseInt(start)==parseInt(startVar)) && (parseInt(end)< parseInt(max_record))) { 
						parent.frames[2].document.forms[0].previous.disabled=true;
						parent.frames[2].document.forms[0].next.disabled=false;
					}
				//cond:2
				if(parseInt(start)==parseInt(startVar) && parseInt(end) >= parseInt(max_record)) {
						parent.frames[2].document.forms[0].previous.disabled=true;
						parent.frames[2].document.forms[0].next.disabled=true;
				}
				//cond:3
				 if((parseInt(start)>parseInt(endVar) )&& (parseInt(end) < parseInt(max_record)) ){
							parent.frames[2].document.forms[0].previous.disabled=false;
							parent.frames[2].document.forms[0].next.disabled=false;
				}
				//cond:4
				if((parseInt(start)>parseInt(endVar) )&&(parseInt(end) >= parseInt(max_record))){
						parent.frames[2].document.forms[0].previous.disabled=false;
						parent.frames[2].document.forms[0].next.disabled=true;
				}
		}
		else
		{
		if(parseInt(max_record) <= 0)
		{
			parent.frames[2].document.forms[0].previous.disabled=true;
			parent.frames[2].document.forms[0].next.disabled=true;
		}
	 }
}


async function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "100vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}


function onSuccess()
{

}
function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
