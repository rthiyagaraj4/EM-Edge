function onSuccess()
{

}
function recodeScreen()
{
	
			var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
			var temp_code = parent.frames[2].document.forms[0].temp_code.value;
			var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
			var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
			var gender = parent.frames[2].document.forms[0].gender.value;
			var age = parent.frames[2].document.forms[0].age.value;
			var dob = parent.frames[2].document.forms[0].dob.value;
			var spec_code = parent.frames[2].document.forms[0].spec_code.value;
			var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
			var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
			var caused_death = parent.frames[2].document.forms[0].caused_death.value;
			var hd_term_code = parent.frames[2].document.forms[0].hd_term_code.value;
			var chk_yn = parent.frames[2].document.getElementById("chk_yn").value;
			var recode_status = "RECODED";
					
					//alert(parent.frames[3].document.forms[0].procedure_yn.value);

			//alert("temp_proc "+parent.frames[3].document.forms[0].temp_proc.value);
			if(parent.frames[3].document.forms[0].procedure_yn.value == 'Y')
			{
				
				parent.RecodeScreen.rows="35%,25%,5%,*";
				
					parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?procedure_yn="+parent.frames[3].document.getElementById("procedure_yn").value+"&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&temp_code="+parent.frames[3].document.getElementById("temp_proc").value+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code+"&chk_yn="+chk_yn;

			}
			else
			{
				
				if(parent.frames[2].document.forms[0].temp_code.value != '' && parent.frames[2].document.forms[0].temp_code.value!=null)
				{

					parent.RecodeScreen.rows="35%,25%,5%,*";
					parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code+"&chk_yn="+chk_yn;
				}
				else
				{
					parent.RecodeScreen.rows="47%,47%,5%,0%";
				}
			}
}

function resetAddModify()
{
		var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
		var temp_code = parent.frames[2].document.forms[0].temp_code.value;
		var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
		var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
		var gender = parent.frames[2].document.forms[0].gender.value;
		var age = parent.frames[2].document.forms[0].age.value;
		var dob = parent.frames[2].document.forms[0].dob.value;
		var spec_code = parent.frames[2].document.forms[0].spec_code.value;
		var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
		var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
		var newCode_yn = parent.frames[5].document.forms[0].newCode_yn.value;

	if(parent.frames[5].document.forms[0].newCode_yn.value == 'Y')
	{
		parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?newCode_yn="+newCode_yn+"&stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;


	}
	else
	{
		if(parent.frames[3].document.forms[0].procedure_yn.value == 'Y')
		{
				parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?procedure_yn="+parent.frames[3].document.getElementById("procedure_yn").value+"&stage_no="+parent.frames[3].document.forms[0].stage_no.value+"&temp_code="+parent.frames[3].document.getElementById("temp_proc").value+"&dflt_termset="+parent.frames[2].document.forms[0].dflt_termset.value+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;
		}
		else
		{
			parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class;
		}
	}
}

function enableSelect1(m,obj,term_code1)
{	
	var count1 = document.forms[0].i.value; 
	var k = 0;
	/*for(var j=1;j<=count1;j++)
	{
		alert(j);
		//alert(eval("parent.frames[2].document.f.select_chk1"+j).value);
		if(eval(document.getElementById("select_chk1"+j)))
		{
			
			if(eval(parent.frames[2].document.getElementById("select_chk1")+j).checked)
			{
						parent.frames[2].document.forms[0].checked_yn.value="Y";

				if(k == 0)
				{
										
						parent.frames[2].document.forms[0].temp_code.value=j+"$"+eval("document.getElementById("select_chk1")"+j).value+"$"+eval("parent.frames[2].document.forms[0].hd_termset"+j).value+"~";			

				}
				else
				{
					parent.frames[2].document.getElementById("temp_code").value=parent.frames[2].document.getElementById("temp_code").value+j+"$"+eval("document.getElementById("select_chk1")"+j).value+"$"+eval("parent.frames[2].document.getElementById("hd_termset")"+j).value+"~";

				}
				k++;
			}
			
				//parent.frames[2].document.forms[0].temp_code.value="";


		}
	}
	document.getElementById("tot_cnt").value=k;



		if(document.getElementById("tot_cnt").value == 0)
		{
			parent.frames[2].document.getElementById("temp_code").value="";
			parent.RecodeScreen.rows="47%,47%,5%,0%";
		}

*/

//alert(eval("parent.frames[2].document.getElementById("select_chk1")"+m).checked);
	if (obj.checked == true )
	{
		//alert(m);
		//alert(eval("parent.frames[2].document.forms[0].hd_termset"+m).value);

		//var tstr="parent.frames[2].document.forms[0].";
		//var str3=".value";
		//alert(finstr);

		parent.frames[2].document.forms[0].checked_yn.value="Y";
			if(document.forms[0].temp_chk.value == "Y")
			{
				
				//alert('if');
				//alert(parent.frames[2].document.forms[0].temp_code.value);
				parent.frames[2].document.forms[0].temp_code.value=parent.frames[2].document.forms[0].temp_code.value+m+"$"+obj.value;
				//alert(parent.frames[2].document.forms[0].temp_code.value);
				parent.frames[2].document.forms[0].temp_code.value=parent.frames[2].document.forms[0].temp_code.value+"$"+eval("parent.frames[2].document.forms[0].hd_termset"+m).value+"~";

				

				//alert(parent.frames[2].document.forms[0].temp_code.value);
			}
			else
			{
				
					//alert('else');
					//alert(m);
					//alert(obj.value)
					parent.frames[2].document.forms[0].temp_code.value=m+"$"+obj.value;
					
					//alert(parent.frames[2].document.forms[0].temp_code.value);
					///alert(eval("parent.frames[2].document.forms[0].hd_termset"+m))
						//alert(eval("parent.frames[2].document.forms[0].hd_termset"+m).value)
					parent.frames[2].document.forms[0].temp_code.value=parent.frames[2].document.forms[0].temp_code.value+"$"+eval("parent.frames[2].document.forms[0].hd_termset"+m).value+"~";

					//alert(parent.frames[2].document.forms[0].temp_code.value);
			}

			parent.frames[2].document.forms[0].temp_chk.value="Y";
			//alert('p'+parent.frames[2].document.forms[0].temp_code)
			//alert('w'+parent.frames[2].document.forms[0].temp_code.value);

	}
	else
	{

		var tot = parent.frames[2].document.forms[0].temp_code.value;
		var arr = tot.split("~");
	//alert(m);
	//alert(arr.length)
		var temp_arr ="";
		for(var i=0;i< arr.length-1;i++)
		{
			
			var fval=arr[i];
			//alert(fval)
			var inner_arr=fval.split("$");
			var sel_indx=inner_arr[0];
			//alert(inner_arr)
			//alert(sel_indx)
			if(sel_indx!=m){
				temp_arr=temp_arr+arr[i]+"~";
				

				

			}
		}
		//alert(temp_arr);
parent.frames[2].document.forms[0].temp_code.value = temp_arr;
		/*if(parent.frames[2].document.getElementById("y").value == 0)
		{
			parent.frames[2].document.getElementById("chk_yn").value=m;
			parent.frames[2].document.getElementById("y").value='1';

		}
		else
		{
			parent.frames[2].document.getElementById("chk_yn").value=parent.frames[2].document.getElementById("chk_yn").value+","+m;

		}*/

		//alert(parent.frames[2].document.getElementById("chk_yn").value);
	}
}

async function show_window(obj)
{
	
	//var dob = parent.frames[5].document.forms[0].age.value;
	//var age = parent.frames[5].document.forms[0].dob.value;
	var dob = parent.frames[5].document.forms[0].dob.value;
	var age = parent.frames[5].document.forms[0].age.value;
	var sex = parent.frames[5].document.forms[0].gender.value;
	var searchtext = parent.frames[5].document.forms[0].diagprob_code.value;
	var practitioner_id = parent.frames[5].document.forms[0].Practitioner_Id.value;
	var term_set_id = parent.frames[5].document.forms[0].dflt_termset.value;
	var Encounter_Id = parent.frames[5].document.forms[0].EncounterId.value;
	var speciality_code = parent.frames[5].document.forms[0].speciality_code.value;

	var retVal =    new String();
	var dialogHeight= "27.22vh" ;
	var dialogWidth = "44vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	

	retVal = await window.showModalDialog("TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		if(obj == 1)
		{
			parent.frames[5].document.forms[0].diagprob_code.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code.onblur();
		}
		else if(obj == 2)
		{
			parent.frames[5].document.forms[0].diagprob_code1.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code1.onblur();
		}
		else if(obj == 3)
		{
			parent.frames[5].document.forms[0].diagprob_code2.value = retcode;
			parent.frames[5].document.forms[0].diagprob_code2.onblur();
		}
	}
}

function getDescription(obj)
{
	if(obj == 1)
	{
		var diag_code = parent.frames[5].document.forms[0].diagprob_code.value;
		diag_code =  diag_code.toUpperCase();
		parent.frames[5].document.forms[0].diagprob_code.value = diag_code;
	}
	else if(obj == 2)
	{
		var diag_code = parent.frames[5].document.forms[0].diagprob_code1.value;
		diag_code =  diag_code.toUpperCase();
		parent.frames[5].document.forms[0].diagprob_code1.value = diag_code;
	}
	else if(obj == 3)
	{
		var diag_code = parent.frames[5].document.forms[0].diagprob_code2.value;
		diag_code =  diag_code.toUpperCase();
		parent.frames[5].document.forms[0].diagprob_code2.value = diag_code;
	}
	

	

	
	if(diag_code!="")
	{
		htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+parent.frames[5].document.forms[0].dflt_termset.value+"'><input type='hidden' name='term_set_code' id='term_set_code' value='"+diag_code+"'><input type='hidden' name='Age' id='Age' value='"+parent.frames[5].document.forms[0].age.value+"'><input type='hidden' name='Sex' id='Sex' value='"+parent.frames[5].document.forms[0].gender.value+"'><input type='hidden' name='Dob' id='Dob' value='"+parent.frames[5].document.forms[0].dob.value+"'></input><input type='hidden' name='mode' id='mode' value='recode'></input><input type='hidden' name='descIndex' id='descIndex' value='"+obj+"'></input></form></body></html>";
		
		parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
		parent.frames[6].document.MRvalidate.submit();

	}
	else
	{
		if(obj == 1)
			parent.frames[5].document.forms[0].diagprob_desc.value = "";
		else if(obj == 2)
			parent.frames[5].document.forms[0].diagprob_desc1.value = "";
		else if(obj == 3)
			parent.frames[5].document.forms[0].diagprob_desc2.value = "";


	}
}

function DRGCal()
{
	/*if(parent.frames[2].document.forms[0].Patient_Class.value == 'IP')
	{
		parent.RecodeScreen.rows="32%,32%,5%,*";
		parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingDRGFrames.jsp";
	}*/


	if(confirm(getMessage('AUTHORIZE_CODE','MR')))
	{
		//alert(parent.frames[2].document.forms[0].authorize_item.value);
		var HTMLVal = new String();

		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[2].document.forms[0].term_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='Patient_Class' id='Patient_Class' value='"+parent.frames[2].document.forms[0].Patient_Class.value+"'><input type='hidden' name='authorize_item' id='authorize_item' value='"+parent.frames[2].document.getElementById("authorize_item").value+"'><input type='hidden' name='mode' id='mode' value='authorize'><input type='hidden' name='recode_status' id='recode_status' value='AUTHORIZED'></input></form></body></html>";
		parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[6].document.tempRecode.submit();
	}
	else
		parent.RecodeScreen.rows="47%,47%,5%,0%";

}

function recodeVal()
{
			if(parent.frames[5].document.forms[0].diagprob_code1.value == '' && parent.frames[5].document.forms[0].diagprob_code2.value == '')
			parent.frames[5].document.forms[0].termcode_cnt.value = 1;
		else if(parent.frames[5].document.forms[0].diagprob_code1.value == '' || parent.frames[5].document.forms[0].diagprob_code2.value == '') 
				parent.frames[5].document.forms[0].termcode_cnt.value = 2;
		else
				parent.frames[5].document.forms[0].termcode_cnt.value = 3;


	if(parent.frames[5].document.forms[0].newCode_yn.value == 'Y')
	{
		parent.frames[5].document.forms[0].sel_item.value=parent.frames[5].document.forms[0].diagprob_code.value+","+parent.frames[5].document.forms[0].code_set.value;
		parent.frames[5].document.forms[0].orig_termset.value=parent.frames[5].document.forms[0].code_set.value;

				//var fields = new Array(parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code,parent.frames[5].document.forms[0].accuracy,parent.frames[5].document.forms[0].severity,parent.frames[5].document.forms[0].priority,parent.frames[5].document.forms[0].onset_date,parent.frames[5].document.forms[0].status_date);

				//var names = new Array(getLabel("Common.DiagnosisSet.label","Common"),getLabel("Common.diagnosis.label","Common"),getLabel("Common.Accuracy.label","Common"),getLabel("Common.Severity.label","Common"),getLabel("Common.priority.label","Common"),getLabel("Common.onsetdate.label","Common"),getLabel("Common.Ason.label","Common"));

				var fields=new Array();
			var names = new Array();
			var p = 0;

			if(parent.frames[5].document.forms[0].as_on_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status_date;
				names[p] = getLabel("Common.Ason.label","Common");
				p++;
			}
			if(parent.frames[5].document.forms[0].priority_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].priority;
				names[p] = getLabel("Common.priority.label","Common");
				p++;
			}


			if(parent.frames[5].document.forms[0].severity_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].severity;
				names[p] = getLabel("Common.Severity.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].accuracy_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].accuracy;
				names[p] = getLabel("Common.Accuracy.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].onset_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_date;
				names[p] = getLabel("Common.onsetdate.label","Common");
				p++;
			}

			fields[p] = parent.frames[5].document.forms[0].code_set;
			names[p] = getLabel("Common.DiagnosisSet.label","Common");
			p++;

			fields[p] = parent.frames[5].document.forms[0].diagprob_code;
			names[p] = getLabel("Common.diagnosis.label","Common");
			p++;

		var	msgFrame=parent.frames[6];
		if(parent.frames[5].checkFieldsofMst(fields, names, msgFrame)) 
		{
			if(parent.frames[5].document.forms[0])
			{

				parent.frames[5].document.forms[0].submit();
				parent.RecodeScreen.rows="47%,47%,5%,0%";
			}
		}

	}
	else
	{

		if(parent.frames[5].document.forms[0].procedure_yn.value == 'Y')
		{
			var fields = new Array(parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code);
			
			var names = new Array(getLabel("Common.DiagnosisSet.label","Common"),getLabel("Common.Procedure.label","Common"));


		}
		else
		{

			var fields=new Array();
			var names = new Array();
			var p = 0;

			if(parent.frames[5].document.forms[0].as_on_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].status_date;
				names[p] = getLabel("Common.Ason.label","Common");
				p++;
			}
			if(parent.frames[5].document.forms[0].priority_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].priority;
				names[p] = getLabel("Common.priority.label","Common");
				p++;
			}


			if(parent.frames[5].document.forms[0].severity_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].severity;
				names[p] = getLabel("Common.Severity.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].accuracy_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].accuracy;
				names[p] = getLabel("Common.Accuracy.label","Common");
				p++;
			}

			if(parent.frames[5].document.forms[0].onset_date_appl_yn.value == "Y")
			{
				fields[p] = parent.frames[5].document.forms[0].onset_date;
				names[p] = getLabel("Common.onsetdate.label","Common");
				p++;
			}

			fields[p] = parent.frames[5].document.forms[0].code_set;
			names[p] = getLabel("Common.DiagnosisSet.label","Common");
			p++;

			fields[p] = parent.frames[5].document.forms[0].diagprob_code;
			names[p] = getLabel("Common.diagnosis.label","Common");
			p++;
			

			//fields[p] = parent.frames[5].document.forms[0].onset_date;
			//names[p] = getLabel("Common.onsetdate.label","Common");



	
		//var fields = new Array(parent.frames[5].document.forms[0].code_set,parent.frames[5].document.forms[0].diagprob_code,parent.frames[5].document.forms[0].onset_date);

		//var names = new Array(getLabel("Common.DiagnosisSet.label","Common"),getLabel("Common.diagnosis.label","Common"),getLabel("Common.onsetdate.label","Common"));
		}
		var	msgFrame=parent.frames[6];
		if(parent.frames[5].checkFieldsofMst(fields, names, msgFrame)) 
		{
			

			if(parent.frames[5].document.forms[0])
			{

				parent.frames[5].document.forms[0].submit();
				parent.RecodeScreen.rows="47%,47%,5%,0%";
			}
		}
	

}
}

function confirmScreen()
{


	if(parent.frames[3].document.getElementById("procedure_yn").value =="Y")
	{
		parent.RecodeScreen.rows="47%,47%,5%,0%";

			var HTMLVal = new String();

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[3].document.getElementById("proc_code").value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.getElementById("Pat_id").value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[3].document.getElementById("temp_proc").value+"'><input type='hidden' name='mode' id='mode' value='confirm'><input type='hidden' name='recode_status' id='recode_status' value='CONFIRMED'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[3].document.getElementById("procedure_yn").value+"'></input></form></body></html>";
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[6].document.tempRecode.submit();

	}
	else
	{
		if(parent.frames[2].document.forms[0].checked_yn.value == "Y")
		{
			var temp_val=parent.frames[2].document.forms[0].temp_code.value;
			var flg="Y";
			//alert(temp_val)
			if(temp_val!=''){
				temp_arr=temp_val.split("~");
			
				for( i=0;i<temp_arr.length-1;i++){
					var in_arr=temp_arr[i].split("$");
					var trm_cd=in_arr[1];
					
					//alert(parent.frames[2].document.forms[0].recd_count.value);
					if(parent.frames[2].document.forms[0].recd_count.value=="1"){
						//alert('in');
						//alert(trm_cd);
						//alert(eval("parent.frames[2].document.forms[0]."+trm_cd))
						var sts= eval("parent.frames[2].document.forms[0]."+trm_cd+".value");
						//alert(sts)
						if(sts=="Recoded"){
							flg="N";
							break;
						}
					}
					//}
				}
			
			
			parent.RecodeScreen.rows="47%,47%,5%,0%";
			
			if(flg=="Y"){
				var HTMLVal = new String();

				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[2].document.forms[0].term_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[2].document.forms[0].temp_code.value+"'><input type='hidden' name='mode' id='mode' value='confirm'><input type='hidden' name='recode_status' id='recode_status' value='CONFIRMED'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[3].document.forms[0].procedure_yn.value+"'></input></form></body></html>";
				parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[6].document.tempRecode.submit();
			}else{
				alert(getMessage("DIAG_RECODE_CANT_CNF","MR"));
			}
			}
		}
	}

}


function onsuccess()
{
	//alert("stage_no "+parent.frames[2].document.forms[0].stage_no.value);
}

function markScreen()
{

	if(parent.frames[3].document.forms[0].procedure_yn.value =="Y")
	{
			parent.RecodeScreen.rows="47%,47%,5%,0%";

			var HTMLVal = new String();

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[3].document.forms[0].proc_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[3].document.forms[0].temp_proc.value+"'><input type='hidden' name='mode' id='mode' value='error'><input type='hidden' name='recode_status' id='recode_status' value='ERROR'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[3].document.forms[0].procedure_yn.value+"'></input></form></body></html>";
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[6].document.tempRecode.submit();

	}
	else
	{

		if(parent.frames[2].document.forms[0].checked_yn.value == "Y")
		{
				parent.RecodeScreen.rows="47%,47%,5%,0%";


			var HTMLVal = new String();

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[2].document.forms[0].term_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[2].document.forms[0].temp_code.value+"'><input type='hidden' name='mode' id='mode' value='error'><input type='hidden' name='recode_status' id='recode_status' value='ERROR'><input type='hidden' name='procedure_yn' id='procedure_yn' value='"+parent.frames[3].document.forms[0].procedure_yn.value+"'></input></form></body></html>";
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[6].document.tempRecode.submit();
		}
	}

}

function getLevel(obj)
{
	parent.RecodeScreen.rows="47%,47%,5%,0%";
	//alert("Stage_no "+parent.frames[2].document.forms[0].all.Stage_no.value);
//alert(obj.value);
if (parent.frames[2].document.getElementById('Stage_no').value === '3')
{
	if(obj.value == 0)
		{
			for(var i=0;i<proc_cnt;i++)
			{
				parent.frames[3].document.getElementById("proc_recode" + i).style.visibility = "hidden";
				parent.frames[3].document.getElementById("proc_recode" + i).style.display = "none";
				parent.frames[3].document.getElementById("Orig1" + i).style.visibility = "visible";
				parent.frames[3].document.getElementById("Orig1" + i).style.display = "inline";


			}
		}
//	if(obj.value == 1 || obj.value == 0)
	else if(obj.value == 1)
	{
			
		//alert("....."+parent.frames[1].document.forms[0].all.stage_no.value);
			parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?mode1=show_lvl&mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;
			parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode1=show_lvl&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;

	}
	else if(obj.value == 2)
	{
		parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?change_stage=Y&mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;
		parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;

	}
	else if(obj.value == 3)
	{
		parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail2.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;

		parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail2.jsp?mode1=show_lvl1&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;


	}
}
else if (parent.frames[2].document.getElementById('Stage_no').value === '2')
{
	if(obj.value == 0)
		{
			for(var i=0;i<proc_cnt;i++)
			{
				var procRecode = parent.frames[3].document.getElementById('proc_recode' + i);
var orig1 = parent.frames[3].document.getElementById('Orig1' + i);

if (procRecode) {
    procRecode.style.visibility = "hidden";
    procRecode.style.display = "none";
}

if (orig1) {
    orig1.style.visibility = "visible";
    orig1.style.display = "inline";
}


			}
		}
//	if(obj.value == 1 || obj.value == 0)
	else if(obj.value == 1)
	{
			

			parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?mode1=show_lvl&mode=Y&stage_no="+parent.frames[1].document.forms[0].all.stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;
			parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode1=show_lvl&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;

	}
	else if(obj.value == 2)
	{
		parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.forms[0].all.stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;
		parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;

	}
}
else if (parent.frames[2].document.getElementById('Stage_no').value === '1') 
{
	
		var cnt = parent.frames[2].document.getElementById('cnt1').value;
        var proc_cnt = parent.frames[4].document.getElementById('proc_cnt').value;
	//alert(parent.frames[3].document.forms[0].all.proc_chk.value);
    // if(parent.frames[3].document.forms[0].all.proc_chk.value == "Y")
	//{
		if(obj.value == 0)
		{
			for(var i=0;i<proc_cnt;i++)
			{
				var procRecode = parent.frames[3].document.getElementById('proc_recode' + i);
var orig1 = parent.frames[3].document.getElementById('Orig1' + i);

if (procRecode) {
    procRecode.style.visibility = "hidden";
    procRecode.style.display = "none";
}

if (orig1) {
    orig1.style.visibility = "visible";
    orig1.style.display = "inline";
}


			}
		}
		else if(obj.value == 1)
		{
			for(var i=0;i<proc_cnt;i++)
			{
				var procRecode = parent.frames[3].document.getElementById('proc_recode' + i);
var orig1 = parent.frames[3].document.getElementById('Orig1' + i);

if (procRecode) {
    procRecode.style.visibility = "visible";
    procRecode.style.display = "inline";
}

if (orig1) {
    orig1.style.visibility = "hidden";
    orig1.style.display = "none";
}

			}
			
		}
	//}
		else if(obj.value == 2)
		{
			parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?mode1=show_lvl1&mode=Y&stage_no="+parent.frames[1].document.forms[0].all.stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&Patient_Class="+parent.frames[2].document.forms[0].Patient_Class.value;
			parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode1=show_lvl1&mode=Y&EncounterId="+parent.frames[3].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;


		}
	//}
	if(cnt != 0 )
	{

		if(obj.value == 0)
		{
			var n = parent.frames[2].document.getElementById('i').value;
for (var i = 0; i < n; i++) {
    var recodeElement = parent.frames[2].document.getElementById('recode' + i);
    var origElement = parent.frames[2].document.getElementById('Orig' + i);
    
    if (recodeElement) {
        recodeElement.style.visibility = "hidden";
        recodeElement.style.display = "none";
    }
    
    if (origElement) {
        origElement.style.visibility = "visible";
        origElement.style.display = "inline";
    }
}



			}
		
		}
		else if(obj.value == 1)
		{

			var n = parent.frames[2].document.getElementById('i').value;
for (var i = 0; i < n; i++) {
    var recodeElement = parent.frames[2].document.getElementById('recode' + i);
    var origElement = parent.frames[2].document.getElementById('Orig' + i);
    
    if (recodeElement) {
        recodeElement.style.visibility = "visible";
        recodeElement.style.display = "inline";
    }
    
    if (origElement) {
        origElement.style.visibility = "hidden";
        origElement.style.display = "none";
    }
}


			}




		}
	
	}
		
}
	parent.frames[4].location.href="../../eMR/jsp/DiagProcRecodingButton.jsp?show_level="+obj.value+"&pat_class="+parent.frames[2].document.forms[0].Patient_Class.value+"&show=O&EncounterId="+parent.frames[2].document.forms[0].EncounterId.value+"&stage_no="+parent.frames[2].document.forms[0].all.Stage_no.value+"&Pat_id="+parent.frames[2].document.forms[0].Pat_id.value;


}

function changePline(i,fac_id)
{
	parent.RecodeScreen.rows="47%,47%,5%,0%";

		var st_no = parent.frames[1].document.getElementById('stage_no').value;
		//alert("st_no "+st_no);

	parent.frames[0].location.href="../../eCommon/jsp/pline.jsp?Facility_Id="+fac_id+"&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value;

	if(st_no == 1)
	{
			parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail.jsp?mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_sex="+parent.frames[1].document.forms[0].Pat_sex.value+"&Pat_id="+eval("parent.frames[1].document.forms[0].all.pid"+i).value+"&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&gender="+eval("parent.frames[1].document.forms[0].all.gender"+i).value+"&age="+eval("parent.frames[1].document.forms[0].all.age"+i).value+"&dob="+eval("parent.frames[1].document.forms[0].all.dob"+i).value+"&spec_code="+eval("parent.frames[1].document.forms[0].all.spec_code"+i).value+"&Patient_Class="+parent.frames[1].document.forms[0].Patient_Class.value;
			parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail.jsp?mode=Y&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;

	}
	else if(st_no == 2)
	{
			parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail1.jsp?mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_sex="+parent.frames[1].document.forms[0].all.Pat_sex.value+"&Pat_id="+eval("parent.frames[1].document.forms[0].all.pid"+i).value+"&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&gender="+eval("parent.frames[1].document.forms[0].all.gender"+i).value+"&age="+eval("parent.frames[1].document.forms[0].all.age"+i).value+"&dob="+eval("parent.frames[1].document.forms[0].all.dob"+i).value+"&spec_code="+eval("parent.frames[1].document.forms[0].all.spec_code"+i).value+"&Patient_Class="+parent.frames[1].document.forms[0].Patient_Class.value;
			parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail1.jsp?mode=Y&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;


	}
	else if(st_no == 3)
	{
					parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail2.jsp?mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_sex="+parent.frames[1].document.forms[0].Pat_sex.value+"&Pat_id="+eval("parent.frames[1].document.forms[0].all.pid"+i).value+"&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&gender="+eval("parent.frames[1].document.forms[0].all.gender"+i).value+"&age="+eval("parent.frames[1].document.forms[0].all.age"+i).value+"&dob="+eval("parent.frames[1].document.forms[0].all.dob"+i).value+"&spec_code="+eval("parent.frames[1].document.forms[0].all.spec_code"+i).value+"&Patient_Class="+parent.frames[1].document.forms[0].Patient_Class.value;
					parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail2.jsp?mode=Y&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+parent.frames[3].document.forms[0].Pat_id.value;


	}

		//parent.frames[3].location.href="../../eMR/jsp/DiagProcRecodingProcDetail.jsp?mode=Y&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&stage_no="+parent.frames[1].document.forms[0].all.stage_no.value;

		parent.frames[4].location.href="../../eMR/jsp/DiagProcRecodingButton.jsp?pat_class="+parent.frames[1].document.forms[0].Patient_Class.value+"&EncounterId="+eval("parent.frames[1].document.forms[0].all.enc1"+i).value+"&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&Pat_id="+eval("parent.frames[1].document.forms[0].all.pid"+i).value;

		parent.frames[6].location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function addTermSet(obj)
{
	parent.frames[5].document.getElementById('t1').style.visibility = 'visible';
	parent.frames[5].document.getElementById('t1').style.display = 'inline';
	parent.frames[5].document.getElementById('t2').style.visibility = 'visible';
	parent.frames[5].document.getElementById('t2').style.display = 'inline';
	var obj = 0;
	parent.frames[5].document.getElementById('i').value = obj;

}

function newCode()
{
	//alert(parent.frames[5].document.forms[0].all.status_img.style.visibility);
	//parent.frames[5].document.forms[0].all.status_img.style.visibility='visible';
	var stage_no = parent.frames[2].document.forms[0].Stage_no.value;
	var temp_code = parent.frames[2].document.forms[0].temp_code.value;
	var dflt_termset = parent.frames[2].document.forms[0].dflt_termset.value;
	var Pat_id = parent.frames[2].document.forms[0].Pat_id.value;
	var gender = parent.frames[2].document.forms[0].gender.value;
	var age = parent.frames[2].document.forms[0].age.value;
	var dob = parent.frames[2].document.forms[0].dob.value;
	var spec_code = parent.frames[2].document.forms[0].spec_code.value;
	var EncounterId = parent.frames[2].document.forms[0].EncounterId.value;
	var Patient_Class = parent.frames[2].document.forms[0].Patient_Class.value;
	var caused_death = parent.frames[2].document.forms[0].caused_death.value;
	var hd_term_code = parent.frames[2].document.forms[0].hd_term_code.value;
	var recode_status = "NEWCODE";

		parent.RecodeScreen.rows="35%,25%,5%,*";
	parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?newCode_yn=Y&procedure_yn="+parent.frames[3].document.forms[0].procedure_yn.value+"&stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code;

			//parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingAddModify.jsp?stage_no="+stage_no+"&temp_code="+temp_code+"&dflt_termset="+dflt_termset+"&Pat_id="+Pat_id+"&gender="+gender+"&age="+age+"&dob="+dob+"&spec_code="+spec_code+"&EncounterId="+EncounterId+"&Patient_Class="+Patient_Class+"&caused_death="+caused_death+"&recode_status="+recode_status+"&l1_termCode="+hd_term_code;


	
}

function completeScreen()
{
	//alert(parent.frames[2].document.forms[0].temp_code.value);
	if(parent.frames[3].document.forms[0].procedure_yn.value =="Y")
	{
			parent.RecodeScreen.rows="47%,47%,5%,0%";
			var HTMLVal = new String();

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[3].document.getElementById("proc_code").value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[3].document.getElementById("Pat_id").value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[3].document.getElementById("temp_proc").value+"'><input type='hidden' name='mode' id='mode' value='confirm'><input type='hidden' name='recode_status' id='recode_status' value='COMPLETED'></input></form></body></html>";
			//alert(HTMLVal);
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[6].document.tempRecode.submit();


	}
	else
	{
		if(parent.frames[2].document.forms[0].checked_yn.value == "Y")
		{

			parent.RecodeScreen.rows="47%,47%,5%,0%";
			var HTMLVal = new String();

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='tempRecode' id='tempRecode' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='term_set_code' id='term_set_code' value='"+parent.frames[2].document.forms[0].term_code.value+"'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='temp_code' id='temp_code' value='"+parent.frames[2].document.forms[0].temp_code.value+"'><input type='hidden' name='mode' id='mode' value='confirm'><input type='hidden' name='recode_status' id='recode_status' value='COMPLETED'></input></form></body></html>";
			//alert(HTMLVal);
			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[6].document.tempRecode.submit();
		}
	}

}

function rejectScreen()
{
	parent.RecodeScreen.rows="47%,47%,5%,0%";
}

function recalDRG()
{
		parent.frames[4].document.forms[0].calDRG.disabled=false;
		parent.frames[4].document.forms[0].seqImg.disabled=true;
		//alert(parent.frames[1].document.forms[0].i.value);
		//var i =parent.frames[2].document.forms[0].i.value;
		parent.frames[2].location.href="../../eMR/jsp/DiagProcRecodingDiagDetail.jsp?DRGcal=Y&mode=Y&stage_no="+parent.frames[1].document.forms[0].stage_no.value+"&dflt_termset="+parent.frames[1].document.forms[0].dflt_termset.value+"&Pat_sex="+parent.frames[1].document.forms[0].Pat_sex.value+"&Pat_id="+parent.frames[4].document.forms[0].Pat_id.value+"&EncounterId="+parent.frames[4].document.forms[0].EncounterId.value+"&gender="+eval("parent.frames[1].document.forms[0].all.gender"+i).value+"&age="+eval("parent.frames[1].document.forms[0].all.age"+i).value+"&dob="+eval("parent.frames[1].document.forms[0].all.dob"+i).value+"&spec_code="+eval("parent.frames[1].document.forms[0].all.spec_code"+i).value+"&Patient_Class="+parent.frames[1].document.forms[0].Patient_Class.value;

		parent.RecodeScreen.rows="35%,25%,5%,*";
		parent.frames[5].location.href="../../eMR/jsp/DiagProcRecodingDRGFrames.jsp?DRGcal=Y&Pat_id="+parent.frames[4].document.forms[0].all.Pat_id.value+"&EncounterId="+parent.frames[4].document.forms[0].EncounterId.value;
}

function SeqIndex(i,sel)
{
	var drg_cnt =parent.frames[2].document.getElementById('i').value;
		//alert("drg_cnt "+drg_cnt);

	var j=i+1;

	if(sel.value == 2)
	{
		parent.frames[2].document.getElementById('seqNo' + j).options[0].selected = true;
			var drg_temp=eval("parent.frames[2].document.forms[0].seqNo"+j).value+"&"+eval("parent.frames[2].document.forms[0].drg_tcode"+j).value+"&"+eval("parent.frames[2].document.forms[0].seqNo"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+i).value+"~"

		//if(i ==1)
		//	eval("parent.frames[2].document.forms[0].all.seqNo"+i).options[0].selected = true;
	}
	else if(sel.value == 1)
	{
		parent.frames[2].document.getElementById('seqNo' + j).options[1].selected = true;


		var drg_temp=eval("parent.frames[2].document.forms[0].all.seqNo"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+i).value+"&"+eval("parent.frames[2].document.forms[0].all.seqNo"+j).value+"&"+eval("parent.frames[2].document.forms[0].all.drg_tcode"+j).value+"~"
//		if(i ==1)
//			eval("parent.frames[2].document.forms[0].all.seqNo"+i).options[1].selected = true;

	}

	parent.frames[2].document.getElementById('drg_temp').value = drg_temp;
}

function recallDRG()
{
		//alert(parent.frames[2].document.forms[0].drg_temp.value);

		//var requestText = "DRG|"parent.frames[1].document.forms[0].all.Pat_id.value+"|"+parent.frames[1].document.forms[0].all.EncounterId.value+"|"+parent.frames[1].document.forms[0].all.Pat_name.value+"|"+parent.frames[1].document.forms[0].all.Pat_familyname.value+"|"+parent.frames[1].document.forms[0].all.Pat_visit.value+"|"+parent.frames[1].document.forms[0].all.Pat_disch.value+"|"+parent.frames[1].document.forms[0].all.Pat_disch.value+"|"+parent.frames[1].document.forms[0].all.Pat_age.value+"|"++"|"++"|";
		
		if(parent.frames[2].document.forms[0].drg_temp.value != '')
		{

			htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DiagProcRecodingValidation.jsp'><input type='hidden' name='Pat_id' id='Pat_id' value='"+parent.frames[2].document.forms[0].Pat_id.value+"'><input type='hidden' name='EncounterId' id='EncounterId' value='"+parent.frames[2].document.forms[0].EncounterId.value+"'><input type='hidden' name='Pat_name' id='Pat_name' value='"+parent.frames[1].document.forms[0].Pat_name.value+"'><input type='hidden' name='Pat_familyname' id='Pat_familyname' value='"+parent.frames[1].document.forms[0].Pat_familyname.value+"'><input type='hidden' name='Pat_visit' id='Pat_visit' value='"+parent.frames[1].document.forms[0].Pat_visit.value+"'><input type='hidden' name='Pat_disch' id='Pat_disch' value='"+parent.frames[1].document.forms[0].Pat_disch.value+"'><input type='hidden' name='Age' id='Age' value='"+parent.frames[1].document.forms[0].Pat_age.value+"'><input type='hidden' name='sex' id='sex' value='"+parent.frames[1].document.forms[0].Pat_sex.value+"'><input type='hidden' name='Dob' id='Dob' value='"+parent.frames[1].document.forms[0].Pat_dob.value+"'><input type='hidden' name='Pat_los' id='Pat_los' value='"+parent.frames[1].document.forms[0].Pat_los.value+"'><input type='hidden' name='drg_temp' id='drg_temp' value='"+parent.frames[2].document.forms[0].drg_temp.value+"'><input type='hidden' name='authorize_item' id='authorize_item' value='"+parent.frames[2].document.forms[0].authorize_item.value+"'><input type='hidden' name='Patient_Class' id='Patient_Class' value='"+parent.frames[1].document.forms[0].Patient_Class.value+"'><input type='hidden' name='mode' id='mode' value='DRG'></input><input type='hidden' name='drg_flag' id='drg_flag' value='Recal'><input type='hidden' name='sequenced_yn' id='sequenced_yn' value='Y'></input></form></body></html>";
			//alert(htmlval);

			parent.frames[6].document.body.insertAdjacentHTML('afterbegin',htmlval);
			parent.frames[6].document.MRvalidate.submit();
		}

}

// Procdure Recoding functions below

function selectProcedure(m,obj)
{
	//alert(parent.frames[3].document.forms[0].i.value);
	var count1 = parent.frames[3].document.forms[0].i.value; 
	var k = 0;
	parent.frames[3].document.getElementById("procedure_yn").value='Y';
	/*for(var j=1;j<=count1;j++)
	{
		//alert(j);
		//alert(eval("parent.frames[2].document.f.select_chk1"+j).value);
		if(eval("parent.frames[3].document.getElementById("select_chk1")"+j))
		{
			//alert("here");
			if(eval("parent.frames[3].document.getElementById("select_chk1")"+j).checked)
			{
				if (k == 0)
					parent.frames[3].document.getElementById("temp_proc").value=parent.frames[3].document.getElementById("temp_proc").value+obj.value+"$"+m+"$"+eval("parent.frames[3].document.getElementById("proc_set")"+m).value+"$"+eval("parent.frames[3].document.getElementById("srl_no")"+m).value+"~";
				else
					parent.frames[3].document.getElementById("temp_proc").value=m+"$"+obj.value+"$"+eval("parent.frames[3].document.getElementById("proc_set")"+m).value+"$"+eval("parent.frames[3].document.getElementById("srl_no")"+m).value+"~";


			}
			else
			{
				
				if(parent.frames[3].document.getElementById("y").value == 0)
				{
					parent.frames[3].document.getElementById("chk_yn").value=m;
					parent.frames[3].document.getElementById("y").value='1';

				}
				else
				{
					parent.frames[3].document.getElementById("chk_yn").value=parent.frames[3].document.getElementById("chk_yn").value+","+m;

				}
			}

		}
	}*/

//alert(parent.frames[3].document.getElementById("temp_proc").value);

	if (obj.checked == true )
	{
		parent.frames[3].document.getElementById("proc_code").value = obj.value;
		parent.frames[3].document.getElementById("procedure_yn").value='Y';

		if (parent.frames[3].document.getElementById("temp_chk").value == 'Y')
			parent.frames[3].document.getElementById("temp_proc").value=parent.frames[3].document.getElementById("temp_proc").value+obj.value+"$"+m+"$"+eval("parent.frames[3].document.getElementById("proc_set")"+m).value+"$"+eval("parent.frames[3].document.getElementById("srl_no")"+m).value+"~";
		else
			parent.frames[3].document.getElementById("temp_proc").value=m+"$"+obj.value+"$"+eval("parent.frames[3].document.getElementById("proc_set")"+m).value+"$"+eval("parent.frames[3].document.getElementById("srl_no")"+m).value+"~";

		parent.frames[3].document.forms[0].temp_chk.value="Y";

	}
	else
			{
				
				if(parent.frames[3].document.getElementById("y").value == 0)
				{
					parent.frames[3].document.getElementById("chk_yn").value=m;
					parent.frames[3].document.getElementById("y").value='1';

				}
				else
				{
					parent.frames[3].document.getElementById("chk_yn").value=parent.frames[3].document.getElementById("chk_yn").value+","+m;

				}
			}
}


function chkDiag()
{
	if(parent.frames[5].document.forms[0].newCode_yn.value == 'Y')
		parent.frames[5].document.forms[0].addDiag.disabled=true;
	else
		parent.frames[5].document.forms[0].addDiag.disabled=false;
}

function checkMaxLimitOfRemark(obj)
{
	if ( obj.value.length > 30 )
	{
		var invaldtFrom = getMessage("REMARKS_XCEED_2000_CHARS","MR") ;
		invaldtFrom = invaldtFrom.replace('2000','30');
		alert(invaldtFrom);
		obj.select();
		return false;
	}
	else
		return true;
	
}

function callTermCode(obj)
{
		var temp_term_code = "";
		//var term_desc = document.Procedure_List.proc_desc.value
		var term_desc = "";
		var term_code_associated = "";
		var mode ="";
		
		var mulitple_yn = "";
		var term_set_id= document.forms[0].code_set.value;
		var retVal = new String();
		var dialogHeight= "28vh" ;
		var dialogWidth = "45vw" ;
		var status = "no";
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+tit+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
	
		if( returnVal == null || returnVal == "" ){
			document.forms[0].diagprob_code.value = "";
			document.forms[0].diagprob_desc.value = "";
			//document.Procedure_List.diagprob_code.value="";
			//document.Procedure_List.proc_desc.value="";
			
		}else{
			
			var retValCode = returnVal.split("||") ;
			var retVal		 = retValCode[0].split("\"") ;
			term_code		 = retVal[0];
			term_code_desc	 = retVal[1];
			level_desc		 = retVal[2];
			level			 = retVal[3];
			document.forms[0].diagprob_code.value = term_code;
			document.forms[0].diagprob_desc.value = retValCode[1];
		}
}

function validateDate(obj,obj2) {
		var from = obj.value;
	
		var to   = document.forms[0].currentdate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=obj2;
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

