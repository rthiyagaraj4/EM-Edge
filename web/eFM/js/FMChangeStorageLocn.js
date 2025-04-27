//var added_file_vol = new ActiveXObject("Scripting.Dictionary");  commented by Jeyachitra (ActiveXobject is not supported in chrome)
//var added_file_vol_file_code = new ActiveXObject("Scripting.Dictionary");
var added_file_vol = {};  // added by Jeyachitra for edge support
var added_file_vol_file_code = {};
function apply()
{

	if (parent.frames[2].frames[1].frames[1].document.forms[0])
	{
		var CBValStr	=	parent.frames[2].frames[1].frames[1].document.forms[0].CBValStr.value;
		var LocnValStr	=	parent.frames[2].frames[1].frames[1].document.forms[0].LocnValStr.value;
		var sel_all    =	parent.frames[2].frames[1].frames[1].document.forms[0].sel_all.value;
		var fm_cnt		=	parent.frames[2].frames[1].frames[2].document.forms[0].fm_disp.value;
		var to_cnt		=	parent.frames[2].frames[1].frames[2].document.forms[0].to_disp.value;
		for (i=fm_cnt; i<=to_cnt;i++)
		{
			var chk		=	parent.frames[2].frames[1].frames[2].document.getElementById('associate_yn'+i)
			var chk1	=	parent.frames[2].frames[1].frames[2].document.getElementById('fs_locn_code'+i)
			if(chk.checked)
			{
				if((CBValStr.indexOf(chk.name)) == -1)
				CBValStr += chk.name+"~";
			}
			if(chk1.value !="")
			{
				if((LocnValStr.indexOf(chk1.name)) == -1)
				LocnValStr += chk1.name+"|"+chk1.value+"~";
			}else 
			{
			if(chk.checked)
			{
			var msg="";
			 msg =	getMessage('FILE_STORAGE_NOT_BLANK','FM');
			if(msg!="")
			{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
			}
			}
		}
		parent.frames[2].frames[1].frames[1].document.forms[0].CBValStr.value	=	CBValStr;
		if(sel_all=="false")
		{
		parent.frames[2].frames[1].frames[1].document.forms[0].LocnValStr.value	=	LocnValStr;
		}
	//	alert('CBValStr:'+CBValStr);
	
		parent.frames[2].frames[1].frames[1].document.forms[0].fm_cnt.value = fm_cnt;
		parent.frames[2].frames[1].frames[1].document.forms[0].to_cnt.value = to_cnt;


		if(CBValStr != "")
		{
		//added_file_vol.RemoveAll();
		
			parent.frames[2].frames[1].frames[1].document.forms[0].method='post';
			parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMChangeStorageLocationServlet';
			parent.frames[2].frames[1].frames[1].document.forms[0].target='messageFrame';
			parent.frames[2].frames[1].frames[1].document.getElementById("flag").value='true';
			
			parent.frames[2].frames[1].frames[1].document.forms[0].submit();
		}
		else
		{
			var msg=getMessage('VAL_NOT_BLANK','FM');
			if(msg!="")
			{
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}


function fetchResults()
{	

	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
	var status_flag=document.forms[0].status.value;
	var fileno=document.forms[0].fileno.value;
	var volno=document.forms[0].volno.value;
	var patarray="";
    var patfilevol="";
	var  added_temp_code="";
	 var  filevol="";
	  var  file_vol="";
	var added_temp_codekey= parent.frames[0].document.forms[0].added_temp_codekey.value ;
  
	if(added_temp_codekey!="")
	{
	patarray =added_temp_codekey.split(",");
	//added_file_vol_file_code.RemoveAll();
	added_file_vol_file_code = {};
	}
	
	 for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		if(patfilevol!="" && patfilevol!=undefined)
			{
		  filevol=patfilevol.split("`");
		  file_vol=filevol[0];
			}
		
		 //if(!added_file_vol_file_code.Exists(file_vol) && file_vol!="")
		if(!added_file_vol_file_code.hasOwnProperty(file_vol) && file_vol!="")
		   {	
			//added_file_vol_file_code.add(file_vol,patfilevol);
			added_file_vol_file_code[file_vol]=patfilevol;
		  	   }
		}
  
    if(status_flag=="true" || FMChngStrLocnCriteriaForm.patient_id.value=="")
	{
    //added_file_vol.RemoveAll();
    added_file_vol={};
	//added_file_vol_file_code.RemoveAll();
    added_file_vol_file_code={};
	document.forms[0].status.value="";
	}
	if(status_flag=="remone")
	{
  
	var temp="('"+fileno+"',"+volno+")";
	if (added_file_vol.hasOwnProperty(temp))
	//added_file_vol.remove(temp);
	delete added_file_vol[temp];
	document.forms[0].status.value="";
	document.forms[0].volno.value="";
	document.forms[0].fileno.value="";	
		}
	
	if(maintain_doc_or_file == 'F')
	{
		var whereClause="and";
		var selectClause="";
		var strand = "";
		var empty = 0;
		var count_sql = "";
		var i=0;
		var fs_locn="";
		var fs_locn_check = document.getElementById('tdlocn').checked;

		if(fs_locn_check) 
			fs_locn='P' 
		else 
			fs_locn='C'
		//var file_no =FMChngStrLocnCriteriaForm.file_no.value;
		var volume_no= document.getElementById('volume_no').value;

		var to_proceed = false;
		var fields = new Array();
		var fields1 = new Array();
		var names = new Array();
		var names1 = new Array();
		var file_type_appl_yn = FMChngStrLocnCriteriaForm.file_type_appl_yn.value;
		var terminaldigit =FMChngStrLocnCriteriaForm.terminal_digit.value;
		var whereClause1="";
		if(terminaldigit!="" )
		{
      	 whereClause1=document.forms[0].whereClause1.value;
			}
		
		fields[fields.length] = FMChngStrLocnCriteriaForm.terminal_digit;
			names[names.length]	= getLabel("Common.TerminalDigit.label","common");
		fields[fields.length] = FMChngStrLocnCriteriaForm.patient_id;
			names[names.length]	= getLabel("Common.patientId.label","common");
		if (file_type_appl_yn == "N")
		{
			fields[fields.length] = FMChngStrLocnCriteriaForm.file_no;
			names[names.length]	= getLabel("Common.fileno.label","common");
		     if(document.forms[0].patient_id.value!=""){
			fields1[fields1.length] = FMChngStrLocnCriteriaForm.file_no;
			names1[names1.length]	= getLabel("Common.fileno.label","common");
			 }
		}
		else if (file_type_appl_yn == "Y")
		{
			fields[fields.length] = FMChngStrLocnCriteriaForm.patient_file_type;
			names[names.length]	= getLabel("Common.filetype.label","common");
		  if(document.forms[0].patient_id.value!=""){
		   fields1[fields1.length] = FMChngStrLocnCriteriaForm.patient_file_type;
			names1[names1.length]	= getLabel("Common.filetype.label","common");
		  }
		}
		
		fields[fields.length] = FMChngStrLocnCriteriaForm.volume_no;
			names[names.length]	= getLabel("Common.volume.label","common")+ " " +getLabel("Common.no.label","common");
		fields[fields.length] = FMChngStrLocnCriteriaForm.file_date;
			names[names.length]	= getLabel("eFM.FileCreationDate.label","FM");
		fields[fields.length] = FMChngStrLocnCriteriaForm.fs_locn_code;
			names[names.length]	= getLabel("eFM.PermanentFSLocation.label","FM");
			
		var error_jsp = "../../eCommon/jsp/error.jsp";
			 for(i=0;i<fields.length;i++) 
			 {
				if(fields[i] != null)
				{
					if(trimCheck(fields[i].value))empty++;
				}
			}
			if(empty != 0 || FMChngStrLocnCriteriaForm.to_file_date.value !="") 
			{
				flag=true;
				if(fields[0] != null)
				{
					if( trimCheck(fields[0].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " terminal_digit = trim('" + fields[0].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " terminal_digit = trim('" + fields[0].value + "') and ";
					}
				}
				/*if(fields[1] != null)
				{
					if( trimCheck(fields[1].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " patient_id = trim('" + fields[1].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " patient_id = trim('" + fields[1].value + "') and ";
					}
				}*/
				
				if((fields[2] != null) && (file_type_appl_yn == "N"))
				{
					if( trimCheck(fields[2].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " file_no = trim('" + fields[2].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " file_no = trim('" + fields[2].value + "') and ";
					}
				}

				

			/*	if((fields[2] != null) && (file_type_appl_yn == "Y"))
				{
					if( trimCheck(fields[2].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " file_type_code = trim('" + fields[2].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " file_type_code = trim('" + fields[2].value + "') and ";
					}
				}*/
				if(fields[3] != null)
				{
				/*	if( trimCheck(fields[3].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " volume_no = trim('" + fields[3].value + "')  and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " volume_no = trim('" + fields[3].value + "')  and ";
					}*/       
				}
				if(fields[4] != null)
				{
					if( trimCheck(fields[4].value ) || FMChngStrLocnCriteriaForm.to_file_date.value != "") 
					{
						var file_creation_date=fields[4].value;
						var file_creation_date_to=FMChngStrLocnCriteriaForm.to_file_date.value;
						
					if(localeName != "en")	file_creation_date=convertDate(file_creation_date,"DMY",localeName,"en");
					
					if (file_creation_date_to != "" && localeName != "en")
					{
						file_creation_date_to=convertDate(file_creation_date_to,"DMY",localeName,"en");
					}

						/*if(fs_locn == 'P')
						whereClause = whereClause + " trunc(file_creation_date)= to_date(trim('" + file_creation_date + "'),'dd/mm/yyyy') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " trunc(file_creation_date)= to_date(trim('" + file_creation_date + "'),'dd/mm/yyyy') and ";*/
						if (file_creation_date_to != "" && file_creation_date != "")
						{
							whereClause = whereClause + " trunc(file_creation_date) between to_date(trim('" + file_creation_date + "'),'dd/mm/yyyy') and to_date(trim('" + file_creation_date_to + "'),'dd/mm/yyyy') and";
						}
						else if (file_creation_date_to == "" && file_creation_date != "")
						{
							whereClause = whereClause + " trunc(file_creation_date) between to_date(trim('" + file_creation_date + "'),'dd/mm/yyyy') and sysdate and";
						}
						else if (file_creation_date_to != "" && file_creation_date == "")
						{
							whereClause = whereClause + " trunc(file_creation_date) between to_date(trim('01/01/1000'),'dd/mm/yyyy') and to_date(trim('" + file_creation_date_to + "'),'dd/mm/yyyy') and";
						}
					
					}
				}
				if(fields[5] != null)
				{
					if( trimCheck(fields[5].value)) 
					{
						if(fs_locn == 'P')
							whereClause = whereClause + " a.mr_pat_fs_locn_code = trim('" + fields[5].value + "') and ";
						else if(fs_locn == 'C')
							whereClause = whereClause + " a.mr_pat_fs_locn_code = trim('" + fields[5].value + "') and ";
					}
				}
				
				//if(FMChngStrLocnCriteriaForm.patient_id.value != "" && FMChngStrLocnCriteriaForm.file_type_code.value != "")
				if(FMChngStrLocnCriteriaForm.patient_id.value != "")
				{
						
					var file_no = FMChngStrLocnCriteriaForm.file_no.value;
					
					//var volume_no = FMChngStrLocnCriteriaForm.volume_no.value;
					var volume_no = document.getElementById('volume_no').value;
						if(volume_no!="") {
						var temp="('"+file_no+"',"+volume_no+")";
						if (!added_file_vol.hasOwnProperty(temp))
						added_file_vol[temp] = temp;
						//var added_temp=((added_file_vol.Keys()).toArray()).toString();
						
						var added_temp=Object.keys(added_file_vol).join(", ");
					 	whereClause = whereClause + " (file_no,volume_no) in ("+ added_temp + ") and " ;
									}
					
				}
				
				
				whereClause = whereClause + strand;
				var replace_url		= 	/%/g ;
				whereClause   	= whereClause.replace(replace_url,"~" );
				if(whereClause.lastIndexOf("and") != -1)
				whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));
				
				//alert('fileno:'+FMChngStrLocnCriteriaForm.file_no.value +'  vol:'+FMChngStrLocnCriteriaForm.volume_no.value);
				//alert(whereClause);

				var chkFields = "";
				var chkValues = "";
				var flag = true;
				
				if(FMChngStrLocnCriteriaForm.file_no)
				{
				if (FMChngStrLocnCriteriaForm.to_file_date.value == "" && FMChngStrLocnCriteriaForm.file_date.value == "" && FMChngStrLocnCriteriaForm.patient_id.value == "" && FMChngStrLocnCriteriaForm.file_no.value == "")
				{
					var msg = getMessage('PAT_FR_TO_DATE_BLANK','FM');
					parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
					flag = false;
				}
				}
			else if(FMChngStrLocnCriteriaForm.to_file_date.value == "" && FMChngStrLocnCriteriaForm.file_date.value == "")
				{
					if(file_type_appl_yn == 'N')
					{
						if(document.forms[0].file_no!=undefined)
						{
						chkFields = new Array(document.forms[0].patient_id, document.forms[0].file_no);
							chkValues = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));
						}else{
                          chkFields = new Array(document.forms[0].patient_id);
							chkValues = new Array(getLabel("Common.patientId.label","common"));
 
						}
					
					}
					else if(file_type_appl_yn == 'Y')
					{
						if(document.forms[0].file_type_code!=undefined)
						{
						chkFields = new Array(document.forms[0].patient_id, document.forms[0].file_type_code);
						}else{
                             chkFields = new Array(document.forms[0].patient_id);
						}
						chkValues = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));
					}	
				}
				
				
				if(checkFields(chkFields, chkValues, parent.parent.messageFrame) && flag== true) 
				{
					
					var file_type_code ="";
					var patient_id		= document.forms[0].patient_id.value;
					if(document.forms[0].file_type_code == undefined)
					 file_type_code  = document.forms[0].patient_file_type.value;
					if(document.forms[0].whereClause1.value=="")
					{
					whereClause1=whereClause;
					}
					
					
					var storage_locn= FMChngStrLocnCriteriaForm.tdlocn.value;
					document.forms[0].patient_id.disabled=true;
					document.forms[0].pat_search.disabled=true;
					document.forms[0].terminal_digit.disabled=true;
					if(file_type_appl_yn == "N")
					document.forms[0].file_no.disabled=true;
					if(file_type_appl_yn == "Y")
					if(document.forms[0].file_type_code)
					document.forms[0].file_type_code.disabled=true;
					document.forms[0].fs_locn_code.disabled=true;
					document.forms[0].tdlocn.disabled=true;
					document.forms[0].search_dtl.disabled=true;
					document.forms[0].reset1.disabled=true;
					document.forms[0].whereClause1.value=whereClause;
					//added_temp_code=((added_file_vol_file_code.Items()).toArray()).toString();
						//parent.FMChngStrLocnSubResultFrame.location.href='../../eFM/jsp/FMChangeStorageLocnSubResult.jsp?whereClause='+whereClause+'&file_type_appl_yn='+file_type_appl_yn+'&file_no='+file_no+'&volume_no='+volume_no+'&fs_locn='+fs_locn;
			
					added_temp_code=Object.keys(added_file_vol_file_code).join(", "); 
					if(checkFields( fields1,names1, parent.parent.messageFrame)) 
		           {
						HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMChangeStorageLocnSubResult.jsp' target='FMChngStrLocnSubResultFrame'><input name='whereClause' id='whereClause' type='hidden' value=\""+whereClause+"\"><input name='whereClause1' id='whereClause1' type='hidden' value=\""+whereClause1+"\"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='file_no' id='file_no' type='hidden' value="+file_no+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='fs_locn' id='fs_locn' type='hidden' value="+fs_locn+"><input name='file_type_code' id='file_type_code' type='hidden' value="+file_type_code+"><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='storage_locn' id='storage_locn' type='hidden' value="+storage_locn+"><input name='terminaldigit' id='terminaldigit' type='hidden' value="+terminaldigit+"><input name='added_temp_code' id='added_temp_code' type='hidden' value="+added_temp_code+"></form></BODY></HTML>";
					//alert(HTMLVal);

					parent.parent.frames[2].document.write(HTMLVal);
					parent.parent.frames[2].document.form1.submit();
					
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
					return true;
						   
				   }else{
               				
					document.forms[0].patient_id.disabled=false;
					document.forms[0].pat_search.disabled=false;
					document.forms[0].terminal_digit.disabled=false;
					if(file_type_appl_yn == "N")
					document.forms[0].file_no.disabled=false;
					if(file_type_appl_yn == "Y")
					if(document.forms[0].file_type_code)
					document.forms[0].file_type_code.disabled=false;
					document.forms[0].fs_locn_code.disabled=false;
					document.forms[0].tdlocn.disabled=false;
					document.forms[0].search_dtl.disabled=false;
				   document.forms[0].reset1.disabled=false;
						   
				   }
				
				}
			}
			else
			{
				var msg =	getMessage('PAT_FR_TO_DATE_BLANK','FM');
				if(msg!="")
				{
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
			}
	}
	else if(maintain_doc_or_file == 'D')
	{
		var whereClause="and";
		var selectClause="";
		var strand = "";
		var empty = 0;
		var count_sql = "";
		var i=0;
		var fs_locn="";
		var fs_locn_check = FMChngStrLocnCriteriaForm.storage_locn[0].checked;
       var terminaldigit =FMChngStrLocnCriteriaForm.terminal_digit.value;
		var whereClause1="";
		if(terminaldigit!="")
		{
         whereClause1=document.forms[0].whereClause1.value;
		}
		
		
		if(fs_locn_check) 
			fs_locn='P' 
		else 
			fs_locn='C'

		var to_proceed = false;
		var fields = new Array();
		var names = new Array();
		
		fields[fields.length] = FMChngStrLocnCriteriaForm.doc_folder_id;
		names[names.length]	= getLabel("eFM.DocumentFolder.label","FM");//"Document Folder";
		fields[fields.length] = FMChngStrLocnCriteriaForm.file_no;
		names[names.length]	= "file_no";
		fields[fields.length] = FMChngStrLocnCriteriaForm.doc_type_code;
		names[names.length]	= getLabel("Common.documenttype.label","common");//"Document Type";
		fields[fields.length] = FMChngStrLocnCriteriaForm.fs_locn_code;
		names[names.length]	= getLabel("eFM.PermanentFSLocation.label","FM");//"Permanant FS Location";
				
			
		var error_jsp = "../../eCommon/jsp/error.jsp";
		 for(i=0;i<fields.length;i++) 
		 {
			if(fields[i] != null)
			{
				if(trimCheck(fields[i].value))empty++;
			}
		 }
			if(empty != 0) 
			{
				flag=true;
				if(fields[0] != null)
				{
					if(trimCheck(fields[0].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " a.doc_folder_id = trim('" + fields[0].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " a.doc_folder_id = trim('" + fields[0].value + "') and ";
					}
				}
		/*		if((fields[1] != null))
				{
					if( trimCheck(fields[1].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " a.file_no = trim('" + fields[1].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " a.file_no = trim('" + fields[1].value + "') and ";
					}
				}*/
				if((fields[2] != null))
				{
					if( trimCheck(fields[2].value)) 
					{
						if(fs_locn == 'P')
						whereClause = whereClause + " a.doc_type_code = trim('" + fields[2].value + "') and ";
						else if(fs_locn == 'C')
						whereClause = whereClause + " a.doc_type_code = trim('" + fields[2].value + "') and ";
					}
				}
				if(fields[3] != null)
				{
					if( trimCheck(fields[3].value)) 
					{
						if(fs_locn == 'P')
							whereClause = whereClause + " a.mr_pat_fs_locn_code = trim('" + fields[3].value + "') and ";
						else if(fs_locn == 'C')
							whereClause = whereClause + " a.mr_pat_fs_locn_code = trim('" + fields[3].value + "') and ";
					}
				}
				
				whereClause = whereClause + strand;
				var replace_url		= 	/%/g ;
				whereClause   	= whereClause.replace(replace_url,"~" );
				if(whereClause.lastIndexOf("and") != -1)
				whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));
				
				var chkFields;
				var chkValues;

				chkFields = new Array(document.forms[0].doc_folder_id, document.forms[0].doc_type_code);
				chkValues = new Array( getLabel("eFM.DocumentFolder.label","FM"),getLabel("Common.documenttype.label","common"));
				
				if(checkFields( chkFields, chkValues, parent.parent.messageFrame)) 
				{			
					if(document.forms[0].whereClause1.value=="")
					{
					whereClause1=whereClause;
					}
					
					document.forms[0].fs_locn_code.disabled=true;
					document.forms[0].storage_locn.disabled=true;
					document.forms[0].search_dtl.disabled=true;
					document.forms[0].reset1.disabled=true;
					document.forms[0].whereClause1.value=whereClause;
					var patient_id		= document.forms[0].patient_id.value;
					var file_type_code  = document.forms[0].patient_file_type.value;
					
					//parent.FMChngStrLocnSubResultFrame.location.href='../../eFM/jsp/FMChangeStorageLocnSubResult.jsp?maintain_doc_or_file='+maintain_doc_or_file+'&whereClause='+whereClause+'&patient_id='+patient_id+'&file_type_code='+file_type_code+'&fs_locn='+fs_locn;

				   
					if(checkFields( fields1,names1, parent.messageFrame)) 
		           {
		
				  HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMChangeStorageLocnSubResult.jsp' target='FMChngStrLocnSubResultFrame'><input name='maintain_doc_or_file' id='maintain_doc_or_file' type='hidden' value="+maintain_doc_or_file+"><input name='whereClause' id='whereClause' type='hidden' value="+whereClause+"><input name='whereClause1' id='whereClause1' type='hidden' value="+whereClause1+"><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='file_type_code' id='file_type_code' type='hidden' value="+file_type_code+"><input name='fs_locn' id='fs_locn' type='hidden' value="+fs_locn+"><input name='terminaldigit' id='terminaldigit' type='hidden' value="+terminaldigit+"><input name='added_temp_code' id='added_temp_code' type='hidden' value="+added_temp_code+"></form></BODY></HTML>";
	
					parent.parent.frames[2].document.write(HTMLVal);
					parent.parent.frames[2].document.form1.submit();
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
					return true;
				}else{

                  document.forms[0].patient_id.disabled=false;
					document.forms[0].pat_search.disabled=false;
					document.forms[0].terminal_digit.disabled=false;
					if(file_type_appl_yn == "N")
					document.forms[0].file_no.disabled=false;
					if(file_type_appl_yn == "Y")
					if(document.forms[0].file_type_code)
					document.forms[0].file_type_code.disabled=false;
					document.forms[0].fs_locn_code.disabled=false;
					document.forms[0].storage_locn.disabled=false;
					document.forms[0].search_dtl.disabled=false;
					document.forms[0].reset1.disabled=false;

				}
				}
			}
			else
			{
				var msg =	getMessage('PAT_FR_TO_DATE_BLANK','FM');
				if(msg!="")
				{
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
			}
	}
	
}
function loadCurrPage()
{
	var i=0;
	var CBValStr		=	parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr		=	parent.frames[1].document.forms[0].LocnValStr.value;

	var chk_val="";
	chk_val				=	parent.frames[1].document.forms[0].locn_code.value;

	var fm_disp	=	document.forms[0].fm_disp.value;
	var to_disp	=	document.forms[0].to_disp.value;
	if(chk_val != "")
	{
		var to_val	=	parseInt(to_disp);
		var fm_val	=	parseInt(fm_disp);

		for(i=fm_val; i<=to_val; i++)
		{
			eval('document.forms[0].fs_locn_code'+i+'.value=chk_val;');
			eval('document.forms[0].associate_yn'+i+'.checked=true;');
			eval('document.forms[0].fs_locn_code'+i+'.disabled=true;');
			eval('document.forms[0].associate_yn'+i+'.disabled=true;');
		}
	}
}
function checkVal()
{
	var CBValStr	=	parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	=	parent.frames[1].document.forms[0].LocnValStr.value;
	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;

	for (i=fm_cnt; i<=to_cnt;i++)
	{
		var chk		=	eval("document.forms[0].associate_yn"+i)
		var chk1	=	eval("document.forms[0].fs_locn_code"+i)
		if(chk.checked)
		{
			if((CBValStr.indexOf(chk.name)) == -1)
				CBValStr += chk.name+"~";
		}
		if(chk1.value !="")
		{
			if((LocnValStr.indexOf(chk1.name)) == -1)
				LocnValStr += chk1.name+"|"+chk1.value+"~";
		}
	}
	parent.frames[1].document.forms[0].CBValStr.value	=	CBValStr;
	parent.frames[1].document.forms[0].LocnValStr.value	=	LocnValStr;

	//apply();
}
function dispRecord()
{
	var CBValStr	=	parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	=	parent.frames[1].document.forms[0].LocnValStr.value;
	if(CBValStr != "")
	{
		var val	=	CBValStr.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
	if(LocnValStr != "")
	{
		var val1	=	LocnValStr.split('~')
		for(i=0; i<val1.length; i++)
		{
			var assign	=	val1[i];
			var fld_name_value	=	assign.split('|');
			var fld_name		=   fld_name_value[0];
			var fld_value		=   fld_name_value[1];

			if(fld_name!="")
			{
				if(eval('document.forms[0].'+fld_name))
				{
					eval('document.forms[0].'+fld_name+'.value=fld_value');
				}
			}
		}
	}
}
function CBValue(obj1, obj2)
{
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var del_locn_obj="fs_locn_code"+obj2;
	var temp_cb_str="";
	var temp_locn_str="";
	var chk_locn=eval('document.forms[0].fs_locn_code'+obj2);
	var chk_locn_val=eval('document.forms[0].fs_locn_code'+obj2+'.value');
	var def_val=eval('document.forms[0].default_code'+obj2+'.value');

	if(!(del_chk))
	{
		var cbString	= parent.frames[1].document.forms[0].CBValStr.value;
		var locnString	= parent.frames[1].document.forms[0].LocnValStr.value;

		if(cbString =="")chk_locn.value="";
		var split=cbString.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";
			}
			else
			{
				temp_cb_str=temp_cb_str;
			}
		}
		cbString=temp_cb_str;
		var split1=locnString.split('~');
		for (i=0; i<(split1.length-1); i++)
		{
			var split_locn= split1[i].split('|');
			if(split_locn[0] != del_locn_obj)
			{
				temp_locn_str += split1[i]+"~";
			}
			else
			{
				temp_locn_str=temp_locn_str;
			}
		}
		locnString=temp_locn_str;
		parent.frames[1].document.forms[0].CBValStr.value=cbString;
		parent.frames[1].document.forms[0].LocnValStr.value=locnString;
	}
	else
	{
		if(chk_locn.value =="")
		{
			chk_locn.focus();
			var msg="";
			 msg =	getMessage('FILE_STORAGE_NOT_BLANK','FM');
			if(msg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
			obj1.checked=false;
		}
	}
}
function checkAssign(obj, obj2)
{
	var chk_value=obj.value;
	var temp="";
	var temp1="";
	//var status_flag=document.forms[0].status.value;
	var file_no=eval('document.forms[0].file_no'+obj2+'.value');
	var volume_no=eval('document.forms[0].volume_no'+obj2+'.value');
	var fs_locn_code=eval('document.forms[0].fs_locn_code'+obj2+'.value');
	

/*	 if(status_flag=="true")
	{
    added_file_vol_file_code.RemoveAll();
	document.forms[0].status.value="";
	} */
	temp1=file_no+volume_no;
	if(fs_locn_code!="")
	temp=file_no+volume_no+"`"+fs_locn_code;
	else
	temp=file_no+volume_no;
	
	
	
	if (added_file_vol_file_code.hasOwnProperty(temp1) || fs_locn_code=="")
	{
	//added_file_vol_file_code.remove(temp1);
	delete added_file_vol_file_code[temp1];
	}
	if (!added_file_vol_file_code.hasOwnProperty(temp1) && fs_locn_code!="")
	{
	//added_file_vol_file_code.add(temp1 , temp ); 
		added_file_vol_file_code[temp1]= temp ; 
	}
	//parent.frames[0].document.forms[0].added_temp_codekey.value  =((added_file_vol_file_code.Items()).toArray()).toString();
	parent.frames[0].document.forms[0].added_temp_codekey.value  = Object.keys(added_file_vol_file_code).join(", ");
	if(chk_value==undefined) chk_value=""; 
	if(chk_value != "")
	{
		document.getElementById('associate_yn'+obj2).checked=true;
	}
	else
	{
		document.getElementById('associate_yn'+obj2).checked=false;
	}
	CBValue(document.getElementById('associate_yn'+obj2),obj2);
	var msg="";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
}
function checkAll(obj,val1)
{	

	if(obj){
	var val=obj.value;
	var row_count=0;
	var LocnValStr="";
	if(val1=="onchnge"){
	row_count=parent.frames[2].document.getElementById('row_count').value ;
	var row_cnt=parseInt(row_count);
	if(val=="")
		{
		
		LocnValStr ="";
		parent.frames[1].document.forms[0].sel_all.value="false";
		}
	else{
	parent.frames[1].document.forms[0].sel_all.value="true";
	for(var i=0 ;i<row_cnt ;i++)
		{
	LocnValStr += "fs_locn_code"+i+"|"+val+"~";
		}
	}
	parent.frames[1].document.forms[0].LocnValStr.value=LocnValStr;
	}

	
	var fs_locn = parent.frames[2].document.forms[0].fs_locn.value;
	var row_count	=	Math.abs(parent.frames[2].document.forms[0].row_count.value);
	var fm_disp		=	Math.abs(parent.frames[2].document.forms[0].fm_disp.value);
	var to_disp		=	Math.abs(parent.frames[2].document.forms[0].to_disp.value);
	var patient_id		=""; 
		if(parent.frames[2].document.forms[0].patient_id)
		patient_id=parent.frames[2].document.forms[0].patient_id.value;
    var patarray="";
    var patfilevol="";
	var  added_temp_code="";
    var  filevol="";
	  var  file_vol="";

if(patient_id==undefined) patient_id="";
if(patient_id=="")
		{
	   parent.frames[0].document.forms[0].added_temp_codekey.value="";	
		//added_file_vol.RemoveAll( );
		//added_file_vol_file_code.RemoveAll( );
	   added_file_vol_file_code={};
		}
var added_temp_codekey= parent.frames[0].document.forms[0].added_temp_codekey.value ;
	if(added_temp_codekey!="")
		  patarray =added_temp_codekey.split(",");
	
	 for(var i=0;i<=patarray.length;i++)
		{
		 patfilevol=patarray[i];
		if(patfilevol!="" && patfilevol!=undefined)
			{
		  filevol=patfilevol.split("`");
		  file_vol=filevol[0];
			}
		 
		 if(!added_file_vol_file_code.hasOwnProperty(file_vol) && file_vol!="")
		   {	
			added_file_vol_file_code[file_vol]=patfilevol;
		  	   }
		}	
	
	
	if(val !="")
	{
		if(fs_locn == 'P')
		{
		for (var i=fm_disp; i<=to_disp; i++)
		{
			var per_loc="";
			var cur_loc="";
			if(parent.frames[2].document.getElementById('default_code'+i))
			 per_loc = parent.frames[2].document.getElementById('default_code'+i).value;
			 if(parent.frames[2].document.getElementById('other_code'+i))
			 cur_loc = parent.frames[2].document.getElementById('other_code'+i).value;
		
			if(per_loc == cur_loc && per_loc!=val)
			{
			if(parent.frames[2].document.getElementById('fs_locn_code'+i))
			parent.frames[2].document.getElementById('fs_locn_code'+i).value=val;
				if(parent.frames[2].document.getElementById('associate_yn'+i))
			parent.frames[2].document.getElementById('associate_yn'+i).checked=true;
			}else
			{
			if(parent.frames[2].document.getElementById('fs_locn_code'+i))
			parent.frames[2].document.getElementById('fs_locn_code'+i).value="";
			if(parent.frames[2].document.getElementById('associate_yn'+i))
			parent.frames[2].document.getElementById('associate_yn'+i).checked=false;
			}
			if(parent.frames[2].document.getElementById('fs_locn_code'+i))
			parent.frames[2].document.getElementById('fs_locn_code'+i).disabled=true;
			if(parent.frames[2].document.getElementById('associate_yn'+i))
			parent.frames[2].document.getElementById('associate_yn'+i).disabled=true;
		
		var temp="";
	   var temp1="";
	//var status_flag=document.forms[0].status.value;
	var file_no=parent.frames[2].document.getElementById('file_no'+i).value;
	var volume_no=parent.frames[2].document.getElementById('volume_no'+i).value;
	var fs_locn_code=parent.frames[2].document.getElementById('fs_locn_code'+i).value;
/*	 if(status_flag=="true")
	{
    added_file_vol_file_code.RemoveAll();
	document.forms[0].status.value="";
	} */
	temp1=file_no+volume_no;
	if(fs_locn_code!="")
	temp=file_no+volume_no+"`"+fs_locn_code;
	else
	temp=file_no+volume_no;
	 
    if(temp==undefined) temp="";
 
     if(temp1==undefined) temp1=""; 
  
  
	if (fs_locn_code=="")
    {
	//added_file_vol_file_code.RemoveAll( );
	added_file_vol_file_code={};
	parent.frames[0].document.forms[0].added_temp_codekey.value="";
	}	

	if (added_file_vol_file_code.hasOwnProperty(temp1) && fs_locn_code!="" && temp1!="")
   {
	 delete added_file_vol_file_code[temp1]; 
	}
   
   if (!added_file_vol_file_code.hasOwnProperty(temp1) && fs_locn_code!="" && temp1!="")
   {
	added_file_vol_file_code[temp1]= temp ; 
	}
	}
		//parent.frames[0].document.forms[0].added_temp_codekey.value  =((added_file_vol_file_code.Items()).toArray()).toString();
		parent.frames[0].document.forms[0].added_temp_codekey.value  = Object.keys(added_file_vol_file_code).join(", ");
	if (fs_locn_code=="")
   {
	added_file_vol_file_code={};
	parent.frames[0].document.forms[0].added_temp_codekey.value="";
	}	
		
		}else
		{
			for (var i=fm_disp; i<=to_disp; i++)
			{
						
			if(parent.frames[2].document.getElementById('fs_locn_code'+i))
			parent.frames[2].document.getElementById('fs_locn_code'+i).value=val;
			if(parent.frames[2].document.getElementById('associate_yn'+i))
				{
			if(parent.frames[2].document.getElementById('fs_locn_code'+i).value!="" )
			parent.frames[2].document.getElementById('associate_yn'+i).checked=true;
				}
			if(parent.frames[2].document.getElementById('fs_locn_code'+i))
			parent.frames[2].document.getElementById('fs_locn_code'+i).disabled=true;
			if(parent.frames[2].document.getElementById('associate_yn'+i))
			parent.frames[2].document.getElementById('associate_yn'+i).disabled=true;
			
				var temp="";
	   var temp1="";
	//var status_flag=document.forms[0].status.value;
	var file_no=parent.frames[2].document.getElementById('file_no'+i).value;
	var volume_no=parent.frames[2].document.getElementById('volume_no'+i).value;
	var fs_locn_code=parent.frames[2].document.getElementById('fs_locn_code'+i).value;
	

/*	 if(status_flag=="true")
	{
    added_file_vol_file_code.RemoveAll();
	document.forms[0].status.value="";
	} */
	temp1=file_no+volume_no;
	if(fs_locn_code!="")
	temp=file_no+volume_no+"`"+fs_locn_code;
	else
	temp=file_no+volume_no;
	  if(temp1==undefined) temp1=""; 
  
	if (fs_locn_code=="")
   {
	//added_file_vol_file_code.RemoveAll( );
		added_file_vol_file_code={};
	parent.frames[0].document.getElementById('added_temp_codekey').value="";
	}	

	if (added_file_vol_file_code.hasOwnProperty(temp1) && fs_locn_code!="" && temp1!="")
   {
	 delete added_file_vol_file_code[temp1]; 
	}
     
   
   if (!added_file_vol_file_code.hasOwnProperty(temp1) && fs_locn_code!="" && temp1!="")
   {
	added_file_vol_file_code[temp1]= temp ; 
	}
			}
		//parent.frames[0].document.forms[0].added_temp_codekey.value  =((added_file_vol_file_code.Items()).toArray()).toString();
		parent.frames[0].document.forms[0].added_temp_codekey.value  =  Object.keys(added_file_vol_file_code).join(", ");
		}
	}
	else 
	{
	for (var i=fm_disp; i<=to_disp; i++)
		{
		   var file_no="";
			var volume_no="";	
			var temp="";	
			var flag="false";
			if(eval('document.forms[0].file_no'+i+''))
				file_no=eval('document.forms[0].file_no'+i+'.value');
	      	  if(eval('document.forms[0].volume_no'+i+''))
		        volume_no =eval('document.forms[0].volume_no'+i+'.value');
			   
			  temp=file_no+volume_no;
		 
		if (added_file_vol_file_code.hasOwnProperty(temp) && patient_id!="")
			{
             flag="true";
			}
					
	//added_file_vol_file_code.RemoveAll( );
//	parent.frames[0].document.forms[0].added_temp_codekey.value="";
	
		if(val1=="onchnge")
			{
	added_file_vol_file_code={};
	parent.frames[0].document.forms[0].added_temp_codekey.value="";
			
			}
		 if(eval('parent.frames[2].document.forms[0].fs_locn_code'+i) && flag=="false" )
			{
			parent.frames[2].document.getElementById('fs_locn_code'+i).value="";
				parent.frames[2].document.getElementById('associate_yn'+i).checked=false;
				if(fs_locn == 'C')
				{
					parent.frames[2].document.getElementById('fs_locn_code'+i).disabled=false;
					parent.frames[2].document.getElementById('associate_yn'+i).disabled=false;
				}
			}
		}
		parent.frames[1].document.forms[0].CBValStr.value="";
		parent.frames[1].document.forms[0].LocnValStr.value="";
	}
  }
}

function assignOnFocus(obj){}
/*
function changeOnClickFSLocn(Obj)
{
	var fs_locn = Obj.value;
	var optlength = document.forms[0].fs_locn_code.options.length;
	for (var i=0; i<optlength; i++)
	{
		document.forms[0].fs_locn_code.options.remove("fs_locn_code");
	}
	if((fs_locn=="P") ||(fs_locn=="C")) 
	{
		var fs_locn_code	= '';
		var fs_desc	= '    ---- getLabel("Common.defaultSelect.label","common") ----   ';
		var opt=document.createElement('OPTION'); 
		opt.text	=	fs_desc; 
		opt.value	=	fs_locn_code; 
		document.forms[0].fs_locn_code.add(opt); 
		document.forms[0].fs_locn_code.selectedIndex = 0;
	}
	var HTMLVal="<html><body><form name='FMFSLocnForm' id='FMFSLocnForm' method='post' action='../../eFM/jsp/FMFSLocationCode.jsp'>"+
	"<input type='hidden' name='fs_locn' id='fs_locn' value='"+fs_locn+"'>"+
	"</form></body></html>";
	parent.parent.frames[2].document.write( HTMLVal);
	parent.parent.frames[2].document.FMFSLocnForm.submit();
	return true;
}
*/

function onSuccess()
{
	
	if(parent.frames[2].frames[1].frames[1].document.getElementById("flag").value == "true")
	{
	
		added_file_vol={};
		added_file_vol_file_code={};
		parent.frames[2].frames[1].frames[0].location.reload();	
		parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html'
		parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html'
	}

	//parent.frames[2].frames[1].frames[0].location.reload();
	//parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	//parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
	
}
function reset()
{
	parent.frames[2].frames[1].frames[0].location.reload();
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
}
function clearVal()
{
	//added_file_vol.RemoveAll( );
	added_file_vol = {};
	//added_file_vol_file_code.RemoveAll( );
	added_file_vol_file_code={};
	parent.frames[0].document.forms[0].added_temp_codekey.value="";
	parent.frames[0].document.forms[0].row_cnt.value="";
	parent.frames[1].document.location.href="../../eCommon/html/blank.html";
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
    

}

function checkdate(obj)
{
var fromdate = document.getElementById("file_date").value;
var todate = document.getElementById("to_file_date").value;

if( fromdate != "" && todate !="")
{
	if (!isBefore(fromdate,todate,"DMY",localeName))
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		FMChngStrLocnCriteriaForm.document.getElementById("to_file_date").select();
	}
}
}

function submitPrevNext(from,to,mode,file_type_appl_yn,fs_locn)
{
	//checkVal()
/*	alert('from:'+from);
	alert('to:'+to);
	alert('mode:'+mode);
	alert('file_type_appl_yn:'+file_type_appl_yn);
	alert('fs_locn:'+fs_locn);*/
	var whereClause = parent.frames[2].document.getElementById("whereClause").value;
	parent.frames[1].document.getElementById("flag").value = mode;
	parent.frames[1].document.getElementById("from").value = from;
	parent.frames[1].document.getElementById("to").value = to;
	parent.frames[1].document.getElementById("whereClause").value = whereClause;
	
	parent.frames[3].document.location.href="../../eCommon/html/blank.html";
	
	if(confirm(getMessage('WANT_TO_SAVE','common')))
	{
			parent.frames[1].document.forms[0].sel_all.value="false";
		
		apply1()
		
		
			//parent.frames[2].location.reload();
			//parent.frames[2].location.href='../jsp/FMChangeStorageLocnMainResult.jsp?from='+from+'&to='+to+'&mode=Previous&file_type_appl_yn='+file_type_appl_yn+'&fs_locn='+fs_locn;

			
			/*HTMLVal = "<html><BODY><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMChangeStorageLocnMainResult.jsp' target='FMChngStrLocnMainResultFrame'><input name='whereClause' id='whereClause' type='hidden' value=\""+whereClause+"\"><input name='from' id='from' type='hidden' value="+from+"><input name='to' id='to' type='hidden' value="+to+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='fs_locn' id='fs_locn' type='hidden' value="+fs_locn+"></form></BODY></HTML>";
					//alert(HTMLVal);
			parent.frames[3].document.write(HTMLVal);
			parent.frames[3].document.form1.submit();
			checkVal();*/
	}
	else
	{
	checkVal();	
	

//	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMChangeStorageLocnMainResult.jsp' target='FMChngStrLocnMainResultFrame'><input name='whereClause' id='whereClause' type='hidden' value=\""+whereClause+"\"><input name='from' id='from' type='hidden' value="+from+"><input name='to' id='to' type='hidden' value="+to+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='fs_locn' id='fs_locn' type='hidden' value="+fs_locn+"></form></BODY></HTML>";
					
	document.forms[0].from_1.value=from;
	document.forms[0].to_1.value=to;
	document.forms[0].fs_locn.value=fs_locn;
	document.forms[0].file_type_appl_yn.value=file_type_appl_yn;
	document.forms[0].whereClause.value=whereClause;
	document.forms[0].submit();		
	//parent.frames[3].document.write(HTMLVal);
	//parent.frames[3].document.form1.submit();
	//parent.frames[1].document.forms[0].whereClause.value = from;
	//parent.frames[1].document.forms[0].to.value	 = to; 
//	parent.frames[1].document.getElementById("whereClause").value = whereClause;
//	parent.frames[1].document.forms[0].file_type_appl_yn.value	 =file_type_appl_yn; 
//	parent.frames[1].document.forms[0].fs_locn.value	 =fs_locn; 
//	parent.frames[1].document.forms[0].submit();
	
	
	}
}

function apply1()
{
	if (parent.frames[1].document.forms[0])
	{
		var CBValStr	=	parent.frames[1].document.forms[0].CBValStr.value;
		var LocnValStr	=	parent.frames[1].document.forms[0].LocnValStr.value;
		var fm_cnt		=	parent.frames[2].document.forms[0].fm_disp.value;
		var to_cnt		=	parent.frames[2].document.forms[0].to_disp.value;
		for (i=fm_cnt; i<=to_cnt;i++)
		{
			var chk		=	parent.frames[2].document.getElementById('associate_yn'+i)
			var chk1	=	parent.frames[2].document.getElementById('fs_locn_code'+i)
			
			if(chk.checked)
			{
				if((CBValStr.indexOf(chk.name)) == -1)
				CBValStr += chk.name+"~";
			}
			if(chk1.value !="")
			{
				if((LocnValStr.indexOf(chk1.name)) == -1)
				LocnValStr += chk1.name+"|"+chk1.value+"~";
			}else{
			if(chk.checked)
			{
			var msg="";
			 msg =	getMessage('FILE_STORAGE_NOT_BLANK','FM');
			if(msg!="")
			{
			
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				
				return false;
			}
			}
			}
		
		
		
		
		
		}
		parent.frames[1].document.forms[0].CBValStr.value	=	CBValStr;
		parent.frames[1].document.forms[0].LocnValStr.value	=	LocnValStr;
	//	alert('CBValStr:'+parent.frames[1].document.forms[0].CBValStr.value);
		//alert('LocnValStr:'+parent.frames[1].document.forms[0].LocnValStr.value);

		parent.frames[1].document.forms[0].fm_cnt.value = fm_cnt;
		parent.frames[1].document.forms[0].to_cnt.value = to_cnt;

		
		
		
		if(CBValStr != "")
		{
		parent.frames[1].document.forms[0].method='post';
			parent.frames[1].document.forms[0].action='../../servlet/eFM.FMChangeStorageLocationServlet';
			parent.frames[1].document.forms[0].target='messageFrame';
			parent.frames[1].document.getElementById("flag").value = "false";
			parent.frames[1].document.forms[0].submit();
			return true;
		}
		else
		{
			var msg=getMessage('VAL_NOT_BLANK','FM');
			if(msg!="")
			{
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
		}
	}
	else
	{
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}
function clearvalues(obj)
{

FMChngStrLocnCriteriaForm.patient_id.value="";
FMChngStrLocnCriteriaForm.patient_id.onblur();
//document.getElementById("ingflag1").style.visibility="hidden";	

}

function setDate(Object)    {

       var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        }
    }
	}

