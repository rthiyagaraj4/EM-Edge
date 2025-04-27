/*
	Developed By       :  sudhakaran
	Developed on   	   :  01/03/2002
	Module Name 	   :  DR
	Function Name	   :  Merge Duplicates for patient
*/
// this function is called on load of the valid patient frame
/*
function button_disable(start,end,max_record,startVar,endVar){ 
if(parseInt(document.forms[0].max_record.value) > 0){ // if there is no record next and previous should not be enabled
				//cond:1
				if((parseInt(start)==parseInt(startVar)) && (parseInt(end)< parseInt(document.forms[0].max_record.value))) {
						parent.frames[2].document.forms[0].previous.disabled=true;
						parent.frames[2].document.forms[0].next.disabled=false;
					}
				//cond:2
				if(parseInt(start)==parseInt(startVar) && parseInt(end) >= parseInt(document.forms[0].max_record.value)) {
						parent.frames[2].document.forms[0].previous.disabled=true;
						parent.frames[2].document.forms[0].next.disabled=true;
				}
				//cond:3
				 if((parseInt(start)>parseInt(endVar) )&& (parseInt(end) < parseInt(document.forms[0].max_record.value)) ){
							parent.frames[2].document.forms[0].previous.disabled=false;
							parent.frames[2].document.forms[0].next.disabled=false;
				}
				//cond:4
				if((parseInt(start)>parseInt(endVar) )&&(parseInt(end) >= parseInt(document.forms[0].max_record.value))){
						parent.frames[2].document.forms[0].previous.disabled=false;
						parent.frames[2].document.forms[0].next.disabled=true;
				}
}else
	 {
		if(parseInt(document.forms[0].max_record.value) <= 0)
		{
		parent.frames[2].document.forms[0].previous.disabled=true;
		parent.frames[2].document.forms[0].next.disabled=true;
		}
	 }

		
}
*/

// this is called when the next button is pressed
function call_next(startVar,endVar){   
		var start=parent.frames[3].document.forms[0].start.value;
		var end=parent.frames[3].document.forms[0].end.value;
		var p_line = "";
		var acc_btn_dis = "";

		if(parent.frames[2].document.forms[0].accept.disabled==false)
		{
			acc_btn_dis="false"	;		
		}
		if(parent.frames[2].document.forms[0].accept.disabled==true)
		{
			acc_btn_dis="true";
			
		}

		parent.frames[2].document.forms[0].next.disabled=true;
	//	if(parent.frames[3].document.forms[0].p_line)
	//	  p_line =parent.frames[3].document.forms[0].p_line.value;
		var order_by_val=parent.frames[3].document.forms[0].order_by_val.value;
		var fin_query=parent.frames[3].document.forms[0].fin_query.value;
		var date_form=parent.frames[3].document.forms[0].date_form.value;
		var date_val=parent.frames[3].document.forms[0].date_val.value;
		var asc_desc=parent.frames[3].document.forms[0].asc_desc.value;
		var call_again="call_again";
		var function_name="";
		if(start=="")start="0";
		if(end=="")end="0";
		if(startVar=="")startVar="0";
		if(endVar=="")endVar="0";
	
			parent.frames[3].document.location.href='../../eDR/jsp/MergeDuplicatePatIdQueryResult.jsp?final_query='+fin_query+'&from='+(parseInt(start)+parseInt(endVar))+'&to='+(parseInt(end)+parseInt(endVar))+'&call_again='+call_again+'&date_val='+date_val+'&date_form='+date_form+'&criteria=query'+'&order_by_val='+order_by_val+'&asc_desc='+asc_desc+'&p_line='+p_line+'&acc_btn_dis='+acc_btn_dis;
		
	
}


// this is called when the previous button is pressed	
function call_previous(startVar,endVar)
{
	var start=parent.frames[3].document.forms[0].start.value;
	var end=parent.frames[3].document.forms[0].end.value;
	var p_line = "";
	var acc_btn_dis = "";

		if(parent.frames[2].document.forms[0].accept.disabled==false)
		{
			acc_btn_dis="false"	;		
		}
		if(parent.frames[2].document.forms[0].accept.disabled==true)
		{
			acc_btn_dis="true"	;		
		}

		parent.frames[2].document.forms[0].previous.disabled=true;

		//if(parent.frames[3].document.forms[0].p_line)
		//	p_line = parent.frames[3].document.forms[0].p_line.value;
	var order_by_val=parent.frames[3].document.forms[0].order_by_val.value;
	var fin_query=parent.frames[3].document.forms[0].fin_query.value;
	var date_form=parent.frames[3].document.forms[0].date_form.value;
	var date_val=parent.frames[3].document.forms[0].date_val.value;	
	var asc_desc=parent.frames[3].document.forms[0].asc_desc.value;
	var call_again="call_again";
	var function_name="";
	if(start=="")start="0";
	if(end=="")end="0";
	if(startVar=="")startVar="0";
	if(endVar=="")endVar="0";
	parent.frames[3].document.location.href='../../eDR/jsp/MergeDuplicatePatIdQueryResult.jsp?final_query='+fin_query+'&from='+(parseInt(start)-parseInt(endVar))+'&to='+(parseInt(end)-parseInt(endVar))+'&date_val='+date_val+'&call_again='+call_again+'&&date_form='+date_form+'&function_name='+function_name+'&criteria=search'+'&order_by_val='+order_by_val+'&asc_desc='+asc_desc+'&p_line='+p_line+'&acc_btn_dis='+acc_btn_dis;  

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
		function search_patient_ID1(file)// this function is called when the question mark button is pressesd and it returns the patient_id
		{
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

function execute_query()
		{ 
		
		var patient_id=parent.frames[1].document.forms[0].patient_id.value;
	parent.frames[3].location.href='../../eCommon/html/blank.html';
	parent.frames[4].location.href='../../eCommon/html/blank.html';
	parent.frames[5].location.href='../../eCommon/jsp/error.jsp';
	parent.frames[2].location.href='../../eDR/jsp/MergePossiblePatIdQueryCriteria.jsp?patient_id='+patient_id;
		}

function call_patient_query(obj){


		var patient_id=obj.value;	
		document.location.href='../../eDR/jsp/excludePossiblePatIdQuery.jsp?patient_id='+patient_id;
}


function apply(){
var patient_id1=frames[1].document.forms[0].patient_id1.value;
var patient_id2=frames[1].document.forms[0].patient_id2.value;
if(patient_id1!='' && patient_id2!='')
frames(1).document.forms[0].submit();
else
	{
	var errors = getMessage("SHOULD_NOT_BE_BLANK","Common");
	frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		
	}
}

function onSuccess(){
	frames[1].location.href='../../eCommon/html/blank.html';
}


async function viewPatientDetails(p_patient_id)
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "400vh" ;
	var dialogWidth	= "600vw" ;
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}


async function patient_search(file)
{
	var patient_id = await PatientSearch();
	if(patient_id == null) patient_id="";
	document.location.href="../../eDR/jsp/"+file+".jsp?patient_id="+patient_id;
}

function bulid_query()
{
	parent.frames[3].location.href='../../eCommon/html/blank.html';
	parent.frames[4].location.href='../../eCommon/html/blank.html';	
	parent.frames[5].location.href='../../eCommon/jsp/error.jsp';	
	parent.frames[2].document.forms[0].identify.disabled=true;
	parent.frames[2].document.forms[0].start_now.disabled=true;
	parent.frames[2].document.forms[0].start_later.disabled=true;
	//parent.frames[2].document.forms[0].merge.disabled=true;
	//parent.frames[2].document.forms[0].accept.disabled=true;

	var first_name_criteria="";
	var second_name_criteria="";
	var third_name_criteria="";
	var family_name_criteria="";
	var first_second_criteria="";
	var first_family_criteria="";
	var nationality_criteria="";
	var sex_criteria		="";
	var dob_criteria		="";
	var contact1_criteria	="";
	var area_criteria		="";
	var all_facil_send		="";
	var contact2_criteria	="";
	var col_name_first		="";
	var col_name_second		="";
	var col_name_third		="";
	var col_name_family		="";
	var fin_query			="";
	var count				=false;
	var count_sel			=false;
	var value_sel			=0;
	var all_facil="";
	var patient_id_for="";
	
	if(parent.frames[2].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		if(parent.frames[2].document.forms[0].name_loc_lang_yn.checked)
		{  
			value_sel++;
			if(parent.frames[2].document.forms[0].first_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].first_name_chk.checked)
				{
					count_sel=true;
					value_sel++;
					first_name_criteria=parent.frames[2].document.forms[0].first_name_loc_lang.value;			
				
					if(first_name_criteria != '')
					{
						col_name_first='first_name_loc_lang';
						fin_query+="upper("+col_name_first+")"+" like "+"upper('"+first_name_criteria+"')";
					//	fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";						 
						count = true;
					}
				}
			}
			if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].second_name_chk.checked)
				{
					count_sel=true;
					value_sel++;
					second_name_criteria=parent.frames[2].document.forms[0].second_name_loc_lang.value;
					col_name_second='second_name_loc_lang';
					if(second_name_criteria != '')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_second+" = "+"'"+second_name_criteria+"'";
						fin_query+="upper("+col_name_second+")"+" like "+"upper('"+second_name_criteria+"')";
						count = true;
					}
				}
			}
			if(parent.frames[2].document.forms[0].third_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].third_name_chk.checked)
				{
					count_sel=true;
					value_sel++;
					third_name_criteria=parent.frames[2].document.forms[0].third_name_loc_lang.value;
					col_name_third='third_name_loc_lang';
					if(third_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_third+" = "+"'"+third_name_criteria+"'";
						fin_query+="upper("+col_name_third+")"+" like "+"upper('"+third_name_criteria+"')";
						count = true;			
					}
				}	
			}
			if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].family_name_chk.checked)
				{	
					count_sel=true;
					value_sel++;		family_name_criteria=parent.frames[2].document.forms[0].family_name_loc_lang.value;
					col_name_family='family_name_loc_lang';
					if(family_name_criteria != '')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_family+" = "+"'"+family_name_criteria+"'";
						fin_query+="upper("+col_name_family+")"+" like "+"upper('"+family_name_criteria+"')";
						count=true;			
					}
				}
			}
		}//if for name_loc_lang_yn.checked
		else
		{
			var soundex_type_value=parent.frames[2].document.forms[0].names_sndx_type.value;
			count=false;
			if(soundex_type_value =='E')
			{
				if(parent.frames[2].document.forms[0].first_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].first_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
						{
							if(parent.frames[2].document.forms[0].second_name_chk.checked)
							{		
								first_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_first_second.value;
								if(first_name_criteria != '')
								{
									col_name_first='ethnic_sndx_first_second';
									fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
									count = true;			
								}	
							}
						}
						else if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
						{
							if(parent.frames[2].document.forms[0].family_name_chk.checked)
							{
								first_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_first_family.value;
								col_name_family='ethnic_sndx_first_family';
								if(first_name_criteria != '')
								{
									fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
									count = true;
								}
							}
						}
						else
						{
							first_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_first.value;
							col_name_first='ethnic_sndx_first';
							if(first_name_criteria != '')
							{
								fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
								count = true;	
							}
						}
					}
				}
				if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].second_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						second_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_second.value;
						col_name_second='ethnic_sndx_second';
						if(second_name_criteria !='')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_second+" = "+"'"+second_name_criteria+"'";
							count = true;
						}
					}
				}
				if(parent.frames[2].document.forms[0].third_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].third_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						third_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_third.value;
						col_name_third='ethnic_sndx_third';
						if(third_name_criteria !='')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_third+" = "+"'"+third_name_criteria+"'";
							count = true;		
						}
					}
				}
				if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].family_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						family_name_criteria=parent.frames[2].document.forms[0].ethnic_sndx_family.value;
						col_name_family='ethnic_sndx_family';
						if(family_name_criteria != '')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_family+" = "+"'"+family_name_criteria+"'";
							count=true;
						}
					}
				}
			}// for E
			else if(soundex_type_value =='G')
			{
				if(parent.frames[2].document.forms[0].first_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].first_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
						{
							if(parent.frames[2].document.forms[0].second_name_chk.checked)
							{		
								first_name_criteria=parent.frames[2].document.forms[0].generic_sndx_first_second.value;
								col_name_first='generic_sndx_first_second';
								if(first_name_criteria != '')
								{
									fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
									count = true;
								}
							}
						}
						else if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
						{
							if(parent.frames[2].document.forms[0].family_name_chk.checked)
							{
								first_name_criteria=parent.frames[2].document.forms[0].generic_sndx_first_family.value;
								col_name_family='generic_sndx_first_family';
								if(first_name_criteria != '')
								{
									fin_query+=col_name_family+" = "+"'"+first_name_criteria+"'";
									count = true;
								}
							}
						}
						else
						{
							first_name_criteria=parent.frames[2].document.forms[0].generic_sndx_first.value;
							col_name_first='generic_sndx_first';
							if(first_name_criteria !='')
							{
								fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
								count = true;
							}
						}
					}
				}
				if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].second_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						second_name_criteria=parent.frames[2].document.forms[0].generic_sndx_second.value;
						col_name_second='ethnic_sndx_second';
						if(second_name_criteria != '')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_second+" = "+"'"+second_name_criteria+"'";
							count = true;
						}
					}
				}
				if(parent.frames[2].document.forms[0].third_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].third_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						third_name_criteria=parent.frames[2].document.forms[0].generic_sndx_third.value;
						col_name_third='generic_sndx_third';
						if(third_name_criteria != '')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_third+" = "+"'"+third_name_criteria+"'";
							count = true;
						}
					}
				}
				if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
				{
					if(parent.frames[2].document.forms[0].family_name_chk.checked)
					{
						count_sel=true;
						value_sel++;
						family_name_criteria=parent.frames[2].document.forms[0].generic_sndx_family.value;
						col_name_family='generic_sndx_family';
						if(family_name_criteria != '')
						{
							if(count==true)fin_query+=' and ';
							fin_query+=col_name_family+" = "+"'"+family_name_criteria+"'";
							count=true;				
						}
					}
				}
			}// for G
		}
		if(parent.frames[2].document.forms[0].name_loc_lang_yn.checked==false && (parent.frames[2].document.forms[0].names_sndx_type.value=='N' || parent.frames[2].document.forms[0].names_sndx_type.value==''))	 
		{
			if(parent.frames[2].document.forms[0].first_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].first_name_chk.checked)
				{		
					count_sel=true;
					value_sel++;
					first_name_criteria=parent.frames[2].document.forms[0].first_name.value;
					col_name_first='first_name';
					if(first_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
						fin_query+="upper("+col_name_first+")"+" like "+"upper('"+first_name_criteria+"')";
						count = true;			
					}
				}
			}
			if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].second_name_chk.checked)
				{
					count_sel=true;
					value_sel++;
					second_name_criteria=parent.frames[2].document.forms[0].second_name.value;
					col_name_second='second_name';
					if(second_name_criteria != '')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_second+" = "+"'"+second_name_criteria+"'";
						fin_query+="upper("+col_name_second+")"+" like "+"upper('"+second_name_criteria+"')";
						count = true;		
					}
				}
			}
			if(parent.frames[2].document.forms[0].third_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].third_name_chk.checked)
				{
					value_sel++;
					count_sel=true;
					third_name_criteria=parent.frames[2].document.forms[0].third_name.value;
					col_name_third='third_name';
					if(third_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_third+" = "+"'"+third_name_criteria+"'";
						fin_query+="upper("+col_name_third+")"+" like "+"upper('"+third_name_criteria+"')";
						count = true;		
					}
				}
			}
			if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].family_name_chk.checked)
				{
					value_sel++;
					count_sel=true;
					family_name_criteria=parent.frames[2].document.forms[0].family_name.value;
					col_name_family='family_name';
					if(family_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_family+" = "+"'"+family_name_criteria+"'";
						fin_query+="upper("+col_name_family+")"+" like "+"upper('"+family_name_criteria+"')";
						count=true;		
					}
				}
			}
		}
	}
	else if(parent.frames[2].document.forms[0].names_in_oth_lang_yn.value == 'N')
	{
		if(parent.frames[2].document.forms[0].names_sndx_type.value=='N' || parent.frames[2].document.forms[0].names_sndx_type.value=='')
		{
			if(parent.frames[2].document.forms[0].first_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].first_name_chk.checked)
				{		
					count_sel=true;
					value_sel++;
					first_name_criteria=parent.frames[2].document.forms[0].first_name.value;
					col_name_first='first_name';
					if(first_name_criteria !='')
					{
					//	fin_query+=col_name_first+" = "+"'"+first_name_criteria+"'";
						fin_query+="upper("+col_name_first+")"+" like "+"upper('"+first_name_criteria+"')";
						count = true;			
					}
				}
			}
			if(parent.frames[2].document.forms[0].second_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].second_name_chk.checked)
				{
					count_sel=true;
					value_sel++;
					second_name_criteria=parent.frames[2].document.forms[0].second_name.value;
					col_name_second='second_name';
					if(second_name_criteria != '')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_second+" = "+"'"+second_name_criteria+"'";
						fin_query+="upper("+col_name_second+")"+" like "+"upper('"+second_name_criteria+"')";
						count = true;		
					}
				}
			}
			if(parent.frames[2].document.forms[0].third_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].third_name_chk.checked)
				{
					value_sel++;
					count_sel=true;
					third_name_criteria=parent.frames[2].document.forms[0].third_name.value;
					col_name_third='third_name';
					if(third_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
					//	fin_query+=col_name_third+" = "+"'"+third_name_criteria+"'";
						fin_query+="upper("+col_name_third+")"+" like "+"upper('"+third_name_criteria+"')";
						count = true;		
					}
				}
			}
			if(parent.frames[2].document.forms[0].family_name_avail.value=='Y')
			{
				if(parent.frames[2].document.forms[0].family_name_chk.checked)
				{
					value_sel++;
					count_sel=true;
					family_name_criteria=parent.frames[2].document.forms[0].family_name.value;
					col_name_family='family_name';
					if(family_name_criteria !='')
					{
						if(count==true)fin_query+=' and ';
						//fin_query+=col_name_family+" = "+"'"+family_name_criteria+"'";
						fin_query+="upper("+col_name_family+")"+" like "+"upper('"+family_name_criteria+"')";
						count=true;		
					}
				}
			}
		}
	}
	if(count_sel==false)
	{
		errors = getMessage("ATLEAT_ONE_NAME","DR");
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	}
	else
	{
		if(parent.frames[2].document.forms[0].nationality_chk.checked)
		{
			value_sel++;
			nationality_criteria=parent.frames[2].document.forms[0].nationality.value;
			if(nationality_criteria != '')
			{
				if(count==true)fin_query+=' and ';
				fin_query+="nationality_code = "+"'"+nationality_criteria+"'";
				count=true;
			}
		}
		if(parent.frames[2].document.forms[0].sex_chk.checked)
			{
			value_sel++;
			sex_criteria=parent.frames[2].document.forms[0].sex.value;
			if(sex_criteria != '')
			{
				if(count==true)fin_query+=' and ';
				fin_query+="sex = "+"'"+sex_criteria+"'";
				count=true;
			}
		}
		if(parent.frames[2].document.forms[0].all_facil.value=='Y')
		{
			if(parent.frames[2].document.forms[0].search_all_chk.checked==true)
			{
				value_sel++;
				//parent.frames[2].document.forms[0].all_facil.value="N";
				//all_facil_send=parent.frames[2].document.forms[0].all_facil.value;
				all_facil_send="N";
			}
		}
		else
		{
			//parent.frames[2].document.forms[0].all_facil.value="Y";
			//all_facil_send=parent.frames[2].document.forms[0].all_facil.value;
			all_facil_send="N";
		}
		if(parent.frames[2].document.forms[0].dob_chk.checked)
		{			 
			value_sel++;
			dob_criteria=parent.frames[2].document.forms[0].dob.value;
			if(dob_criteria !='')
			{
				var date_val=parent.frames[2].document.forms[0].dob.value;
				var date_val_cri=parent.frames[2].document.forms[0].by_date.value;
				count=true;
				 
			}
		}else {
			var date_val = "";
			var date_val_cri = "";
		}
		if(parent.frames[2].document.forms[0].contact1_no_chk.checked)
		{
			value_sel++;
			contact1_criteria=parent.frames[2].document.forms[0].contact1_no.value;
			if(contact1_criteria != '')
			{
				if(count==true)fin_query+=' and ';
				fin_query+="contact1_no = "+"'"+contact1_criteria+"'";
				count=true;
			}
		}
		if(parent.frames[2].document.forms[0].contact2_no_chk.checked)
		{
			value_sel++;
			contact2_criteria=parent.frames[2].document.forms[0].contact2_no.value;
			if(contact2_criteria != '')
			{
				if(count==true)fin_query+=' and ';
				fin_query+="contact2_no = "+"'"+contact2_criteria+"'";
				count=true;
			}
		}
		if(parent.frames[2].document.forms[0].area_name_avail.value=='Y')
		{
			if(parent.frames[2].document.forms[0].area_chk.checked)
			{
				value_sel++;
				area_criteria=parent.frames[2].document.forms[0].area_type.value;
				if(area_criteria != '')
				{
					if(count==true)fin_query+=' and ';
					fin_query+="res_area_code = "+"'"+area_criteria+"'";
					count=true;
				}
			}
		}
	}
	if(count_sel==true)
	{
		if(value_sel>=3)
		{
			if(parent.frames[2].document.forms[0].other_alt_id_chk.disabled == false)
			{
				if(parent.frames[2].document.forms[0].other_alt_id_chk.checked == true)
				{
					var other_alt_id_val = parent.frames[2].document.forms[0].other_alt_id_type.value;
					if(other_alt_id_val != '')
					{
						fin_query+= " and oth_alt_id_type = "+"'"+other_alt_id_val+"'";
					}
				}
			}
			//fin_query+= ' and rownum<=100 ';
			
        parent.frames[2].document.forms[0].search.disabled=true; 	
		parent.frames[3].document.location.href='../../eDR/jsp/MergeDuplicatePatIdQueryResult.jsp?final_query='+fin_query+'&all_facil='+all_facil_send+'&date_val='+date_val+'&date_form='+date_val_cri;		 
		parent.frames[4].document.location.href='../../eDR/jsp/MergeDuplicatePatIdQueryResultColor.jsp';
		}
		else
		{
			errors = getMessage("THREE_FIELD","DR");
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			
		}
	}
}
function disable_soundex()
{
	if(parent.frames[2].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		var mode=parent.frames[2].document.forms[0].name_loc_lang_yn.checked;
		if(mode==true)
		{
			parent.frames[2].document.forms[0].names_sndx_type.value="N";
			parent.frames[2].document.forms[0].names_sndx_type.disabled=true;
		}
		if(mode==false)
		{
			parent.frames[2].document.forms[0].names_sndx_type.disabled=false;
		}
	}
}
function active_by()
{
if(parent.frames[2].document.forms[0].dob_chk.checked)
parent.frames[2].document.forms[0].by_date.disabled=false;
else if(parent.frames[2].document.forms[0].dob_chk.checked==false)
parent.frames[2].document.forms[0].by_date.disabled=true;
}

function order_by(rowNo,elementName) {
	
    var start=document.forms[0].start.value;
	var end=document.forms[0].end.value;
	var fin_query=parent.frames[3].document.forms[0].fin_query.value;
	var date_val_cri=parent.frames[3].document.forms[0].date_form.value;
	var date_val=parent.frames[3].document.forms[0].date_val.value;
	var asc_desc=parent.frames[3].document.forms[0].asc_desc.value;	
	
	var call_again="call_again";

	if(elementName=='Date_of_Birth') {
		if(asc_desc=='0') {
			var order_by_val = " order by to_date(Date_of_Birth,'DD/MM/YYYY') asc";		
			asc_desc = '1';
		} else if(asc_desc=='1') {
			var order_by_val = " order by to_date(Date_of_Birth,'DD/MM/YYYY') desc";
			asc_desc = '0';
		}
	} else {
		if(asc_desc=='0') {
			var order_by_val=" order by "+rowNo+" asc";		
			asc_desc = '1';
		} else if(asc_desc=='1') {
			var order_by_val=" order by "+rowNo+" desc";
			asc_desc = '0';
		}
	}	
	parent.frames[3].document.location.href='../../eDR/jsp/MergeDuplicatePatIdQueryResult.jsp?final_query='+fin_query+'&from='+(parseInt(start))+'&to='+(parseInt(end))+'&order_by_val='+order_by_val+'&call_again='+call_again+'&date_val='+date_val+'&date_form='+date_val_cri+'&asc_desc='+asc_desc;
}


function invoke_merge(){
var p_line=parent.frames[3].document.forms[0].p_line.value;
var modal=parent.frames[3].document.forms[0].modal.value;
parent.frames[3].document.forms[0].submit();

}
async function invoke_identify(){ 

 	var ErrorText="";
	parent.frames[5].document.location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	var dialogHeight= "400vh" ;
	var dialogWidth	= "800vw" ;
	var dialogTop="10";
	var dialogLeft="2";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var retval= await top.window.showModalDialog('../../eDR/jsp/ValidDuplicatePatient.jsp?modal=Y&module_id=DR&function_id=DR_VALID_DUPLCATE_PATIENT&function_name=Merge Duplicates for a Patient&function_type=F&access=NNNNNNN',arguments,features);
	if(retval=='Y')
	{
		  document.forms[0].identify.disabled=true;
		  document.forms[0].start_now.disabled=false;
	    document.forms[0].start_later.disabled=false;
	}
//window.open('../../eDR/jsp/ValidDuplicatePatient.jsp?modal=Y&module_id=DR&function_id=DR_VALID_DUPLCATE_PATIENT&function_name=Identify%20Valid%20/%20Duplicate%20Patients&function_type=F&access=NNNNNNN ',40,50);
}

function invoke_access(){ 
//var record_count=parent.frames[3].document.forms[0].count.value;
var p_line=parent.frames[3].document.forms[0].p_line.value;
var count = parent.frames[3].document.forms[0].count.value;


document.forms[0].search.disabled=true;
//document.forms[0].previous.disabled=true;
//document.forms[0].next.disabled=true;


var patient_id=parent.frames[1].document.forms[0].patient_id.value;
parent.frames[2].document.forms[0].patient_id_for.value=patient_id;
patient_id_for=patient_id;
if(parent.frames[2].document.forms[0].names_in_oth_lang_yn.value == 'Y')
{
	if(parent.frames[2].document.forms[0].name_loc_lang_yn.checked==false){
		parent.frames[2].document.forms[0].name_loc_lang_ser.value="N";
	}
	else if(parent.frames[2].document.forms[0].name_loc_lang_yn.checked==true){
		parent.frames[2].document.forms[0].name_loc_lang_ser.value="Y";
	}
}

if(parent.frames[2].document.forms[0].nationality_chk.checked==false){
	parent.frames[2].document.forms[0].nationality_ser.value="N";
}
else if(parent.frames[2].document.forms[0].nationality_chk.checked==true){
	parent.frames[2].document.forms[0].nationality_ser.value="Y";
}
if(parent.frames[2].document.forms[0].first_name_avail.value=='Y'){
if(parent.frames[2].document.forms[0].first_name_chk.checked==false){
parent.frames[2].document.forms[0].first_name_ser.value="N";
}
else if(parent.frames[2].document.forms[0].first_name_chk.checked==true){
parent.frames[2].document.forms[0].first_name_ser.value="Y";
}
}
else{
parent.frames[2].document.forms[0].first_name_ser.value="N";
}
if(parent.frames[2].document.forms[0].sex_chk.checked==false){
parent.frames[2].document.forms[0].sex_ser.value="N";
}
else if(parent.frames[2].document.forms[0].sex_chk.checked==true){
parent.frames[2].document.forms[0].sex_ser.value="Y";
}
if(parent.frames[2].document.forms[0].second_name_avail.value=='Y'){
if(parent.frames[2].document.forms[0].second_name_chk.checked==false){
parent.frames[2].document.forms[0].second_name_ser.value="N";
}
else if(parent.frames[2].document.forms[0].second_name_chk.checked==true){
parent.frames[2].document.forms[0].second_name_ser.value="Y";
}
}
else{
parent.frames[2].document.forms[0].second_name_ser.value="N";
}
if(parent.frames[2].document.forms[0].dob_chk.checked==true){
	var date_val_now=parent.frames[2].document.forms[0].by_date.value;
	if(date_val_now =='Y'){
		parent.frames[2].document.forms[0].year_of_birth_yn.value="Y";
		parent.frames[2].document.forms[0].month_of_birth_yn.value="N";
		parent.frames[2].document.forms[0].day_of_birth_yn.value="N";
		}
	else if(date_val_now =='MY'){
		parent.frames[2].document.forms[0].month_of_birth_yn.value="Y";
		parent.frames[2].document.forms[0].year_of_birth_yn.value="N";
		parent.frames[2].document.forms[0].day_of_birth_yn.value="N";
		}
	else if(date_val_now =='D'){
		parent.frames[2].document.forms[0].day_of_birth_yn.value="Y";
		parent.frames[2].document.forms[0].month_of_birth_yn.value="N";
		parent.frames[2].document.forms[0].year_of_birth_yn.value="N";
		}
}else
	{
		parent.frames[2].document.forms[0].day_of_birth_yn.value="N";
		parent.frames[2].document.forms[0].month_of_birth_yn.value="N";
		parent.frames[2].document.forms[0].year_of_birth_yn.value="N";
	}
if(parent.frames[2].document.forms[0].third_name_avail.value=='Y'){
if(parent.frames[2].document.forms[0].third_name_chk.checked==false){
parent.frames[2].document.forms[0].third_name_ser.value="N";
}
else if(parent.frames[2].document.forms[0].third_name_chk.checked==true){
parent.frames[2].document.forms[0].third_name_ser.value="Y";
}
}
else{
parent.frames[2].document.forms[0].third_name_ser.value="N";
}
if(parent.frames[2].document.forms[0].family_name_avail.value=='Y'){
if(parent.frames[2].document.forms[0].family_name_chk.checked==false){
parent.frames[2].document.forms[0].family_name_ser.value="N";
}
else if(parent.frames[2].document.forms[0].family_name_chk.checked==true){
parent.frames[2].document.forms[0].family_name_ser.value="Y";
}
}
else{
parent.frames[2].document.forms[0].family_name_ser.value="N";
}
if(parent.frames[2].document.forms[0].contact1_no_chk.checked==false){
	parent.frames[2].document.forms[0].contact1_no_ser.value="N";
}
else if(parent.frames[2].document.forms[0].contact1_no_chk.checked==true){
	parent.frames[2].document.forms[0].contact1_no_ser.value="Y";
}
if(parent.frames[2].document.forms[0].contact2_no_chk.checked==false){
	parent.frames[2].document.forms[0].contact2_no_ser.value="N";
}
else if(parent.frames[2].document.forms[0].contact2_no_chk.checked==true){
	parent.frames[2].document.forms[0].contact2_no_ser.value="Y";
}
if(parent.frames[2].document.forms[0].area_name_avail.value=='Y')
{
if(parent.frames[2].document.forms[0].area_chk.checked==false){
parent.frames[2].document.forms[0].area_ser.value="N";
}
if(parent.frames[2].document.forms[0].area_name_avail.value=='Y')
{
if(parent.frames[2].document.forms[0].area_chk.checked==true){
parent.frames[2].document.forms[0].area_ser.value="Y";
}
}
}
else{
parent.frames[2].document.forms[0].area_ser.value="N";
}
if(parent.frames[2].document.forms[0].all_facil.value=='Y'){
if(parent.frames[2].document.forms[0].search_all_chk.checked==false){
parent.frames[2].document.forms[0].search_all_ser.value="N";
}
else if(parent.frames[2].document.forms[0].search_all_chk.checked==true){
parent.frames[2].document.forms[0].search_all_ser.value="Y";
}
} 

parent.frames[2].document.forms[0].count_record.value=count;
parent.frames[2].document.forms[0].p_p_line.value=p_line;
parent.frames[2].document.forms[0].accept.disabled=true;
parent.frames[2].document.forms[0].submit();
}
function onSuccess()
{
	frames[2].document.forms[0].accept.disabled=true;
	frames[2].document.forms[0].identify.disabled=false;
    frames[2].document.forms[0].start_now.disabled=true;
	frames[2].document.forms[0].start_later.disabled=true;
	frames[2].document.forms[0].start_later_time.disabled=false;
	frames[2].document.getElementById("datepicker").disabled=false;

}
function viewPatientDetails_common()
{
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "35" ;
	var dialogWidth	= "150" ;
	var dialogTop="100";
	var dialogLeft="2";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	window.showModalDialog('../../eDR/jsp/DRViewPatientDetails.jsp?display='+display+'&patient_id='+p_patient_id,arguments,features);
}
async function callPatientSearch()
{
	var ErrorText = '';
	parent.frames[5].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
	var p_patient_id = await PatientSearch();
	if(p_patient_id != null)
	{
		parent.frames[1].document.forms[0].patient_id.value = p_patient_id;
		parent.frames[2].document.location.href='../../eCommon/html/blank.html';
		parent.frames[3].document.location.href='../../eCommon/html/blank.html';
	}
	else
	{
		var ErrorText = getMessage('PATIENT_NOT_SELECTED','DR');
		parent.frames[5].document.location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
	}
}
function viewMRN(obj)
{
	var p_patient_id=obj;
	var dialogHeight= "15" ;
	var dialogWidth	= "50" ;
	var dialogTop="76";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status=no"
	window.showModalDialog('../../eMP/jsp/MultipleMRN.jsp?Patient_Id='+p_patient_id,arguments,features);
}
function reset()
{
	frames[2].document.location.href='../../eCommon/html/blank.html';
	frames[3].document.location.href='../../eCommon/html/blank.html';
	frames[1].document.forms[0].reset();
}
function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
/*function later_Click11()
{
	
	var Obj=document.forms[0].start_later_time;
	var givenDate=Obj.value ;
	var datelater=givenDate.split(" ")
	var datee=datelater[0].split("/");
	
	if (givenDate!='')
	{
		if(datee[1]=="00" || datee[1]=="0")
		{
		   alert(getMessage("INVALID_DATE_FMT","SM"));
		   Obj.value='';
		   Obj.focus();
		   Obj.select();
		}
		else if(datee[0]=="00" || datee[0]=="0")
		{
		   alert(getMessage("INVALID_DATE_FMT","SM"));
		   Obj.value='';
		   Obj.focus();
		   Obj.select();
		}
		else if(datee[2]=="0000")
		{
		   alert(getMessage("INVALID_DATE_FMT","SM"));
		   Obj.value='';
		   Obj.focus();
		   Obj.select();
		}
		else if (!(doDateTimeChk(Obj)))
		{
               alert(getMessage("INVALID_DATE_FMT","SM"));
			   Obj.value='';
			   Obj.focus();
			   Obj.select();
		}
	}
}*/
function later_Click()
{
	var Obj=document.forms[0].start_later_time;
	var givenDate=Obj.value ;
    if(givenDate=='')
		alert(getMessage("DATE_TIME_NOT_BLANK","DR"));
	else
	{
	srcObj=event.target;
	start_process_merge(srcObj);
	}
	
}
function start_nowClick()
{  
	var srcObj=event.target;
	start_process_merge(srcObj);
	
	
}

function start_process_merge(obj)
{
	var process=obj.name; 
	
	var final_chk_value='';
	var final_chk_value1='';
	var final_chk='';
	if(process=="start_now")
    {
		
		document.forms[0].process_start.value="process_now";
		document.forms[0].action='../../servlet/eDR.MergeDuplicateServlet'
		
		var p_line12=(parent.frames[3].document.forms[0].p_line.value);	
				
		document.forms[0].p_line1.value=p_line12
			
		document.forms[0].submit();
		
   }
	else if(process=="start_later")
	{
				
			var comp=document.forms[0].start_later_time;
			document.forms[0].process_start.value="process_later";
			document.forms[0].action='../../servlet/eDR.MergeDuplicateServlet'
			var p_line12=(parent.frames[3].document.forms[0].p_line.value);
			document.forms[0].p_line1.value=p_line12
			document.forms[0].submit();
    }//else if	
}





