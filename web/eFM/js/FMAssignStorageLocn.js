function apply()
{
	if(parent.frames[2].frames[1].frames[1].document.forms[0])
	{
	var CBValStr	=	parent.frames[2].frames[1].frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	=	parent.frames[2].frames[1].frames[1].document.forms[0].LocnValStr.value;
	var fm_cnt		=	parent.frames[2].frames[1].frames[2].document.forms[0].fm_disp.value;
	var to_cnt		=	parent.frames[2].frames[1].frames[2].document.forms[0].to_disp.value;

	for (i=fm_cnt; i<=to_cnt;i++)
	{
		//var chk		=	eval("parent.frames[2].frames[1].frames[2].document.forms[0].associate_yn"+i)
		//var chk1	=	eval("parent.frames[2].frames[1].frames[2].document.forms[0].fs_locn_code"+i)
		var chk = parent.frames[2].frames[1].frames[2].document.getElementById("associate_yn" + i);
		var chk1 = parent.frames[2].frames[1].frames[2].document.getElementById("fs_locn_code" + i);

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
	parent.frames[2].frames[1].frames[1].document.forms[0].CBValStr.value	=	CBValStr;
	parent.frames[2].frames[1].frames[1].document.forms[0].LocnValStr.value	=	LocnValStr;

	if(LocnValStr != "")
	{
		parent.frames[2].frames[1].frames[1].document.forms[0].method='post';
		parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMAssignStorageLocationServlet';
		parent.frames[2].frames[1].frames[1].document.forms[0].target='messageFrame';
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
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=0";
			return false;	
	}
}
function fetchResults()
{ 
	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
	if(maintain_doc_or_file == 'F' )
	{
		var whereClause="and";
		var selectClause="";
		var strand = "";
		var empty = 0;
		var count_sql = "";
		var i=0;
		var fields;
		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
		if(file_type_appl_yn == 'N')
		{
			fields = new Array(	FMAssnStrLocnCriteriaForm.terminal_digit,
								FMAssnStrLocnCriteriaForm.patient_id,
								FMAssnStrLocnCriteriaForm.file_no,
								FMAssnStrLocnCriteriaForm.file_date
								);
		}
		else if(file_type_appl_yn == 'Y')
		{
			fields = new Array(	FMAssnStrLocnCriteriaForm.terminal_digit,
								FMAssnStrLocnCriteriaForm.patient_id,
								FMAssnStrLocnCriteriaForm.file_no,
								FMAssnStrLocnCriteriaForm.file_date,
								FMAssnStrLocnCriteriaForm.patient_file_type
								);	
		}
		for(i=0;i<fields.length;i++) 
		{
			if(fields[i] != null)
			{
				if(trimCheck(fields[i].value))  empty++;
			}
		}
		if(empty != 0) 
		{
			flag=true;
			if(fields[0] != null)
			{
				if( trimCheck(fields[0].value)) 
				{
					whereClause = whereClause + " a.terminal_digit = trim('" + fields[0].value + "') and ";
				}
			}
			if(fields[1] != null)
			{
				if( trimCheck(fields[1].value)) 
				{
					whereClause = whereClause + " a.patient_id = trim('" + fields[1].value + "') and ";
				}
			}
			if(fields[2] != null)
			{
				if( trimCheck(fields[2].value)) 
				{
					whereClause = whereClause + " a.file_no = trim('" + fields[2].value + "') and ";
				}
			}
			if(fields[3] != null)
			{
				if( trimCheck(fields[3].value)) 
				{
					var added_date=fields[3].value;
					added_date=convertDate(added_date,"DMY",localeName,"en");
					whereClause = whereClause + " trunc(a.added_date)= to_date(trim('" + added_date + "'),'dd/mm/yyyy') and ";
				}
			}
			if(file_type_appl_yn == 'Y')
			{
				if(fields[4] != null)
				{
					if( trimCheck(fields[4].value)) 
					{
						whereClause = whereClause + " a.file_type_code = trim('" + fields[4].value + "') and ";
					}
				}
			}
			whereClause = whereClause + strand;
			
			var replace_url		= 	/%/g ;
			var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
			
			whereClause   	= whereClause.replace(replace_url,"~" );
			if(whereClause.lastIndexOf("and") != -1)
			whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));
			whereClause += "order by 1,2";
			
			var chkFileds = "";
			var chkNames = "";
			
			if(file_type_appl_yn == 'N')
			{
				 chkFileds = new Array ( document.forms[0].patient_id,document.forms[0].file_no);
				 chkNames = new Array ( getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));	
			}
			else if(file_type_appl_yn == 'Y')
			{
				 chkFileds = new Array ( document.forms[0].patient_id,document.forms[0].file_type_code);
				 chkNames = new Array (  getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));	
			}
			if(checkFields(chkFileds, chkNames, parent.parent.messageFrame)) 
			{
				document.forms[0].patient_id.disabled=true;
				document.forms[0].pat_search.disabled=true;
				document.forms[0].terminal_digit.disabled=true;
				if(file_type_appl_yn == 'N')
					document.forms[0].file_no.disabled=true;
				if(file_type_appl_yn == 'Y')
					document.forms[0].file_type_code.disabled=true;
				document.forms[0].file_date.disabled=true;
				document.forms[0].search_dtl.disabled=true;
				document.forms[0].reset1.disabled=true;
				
				parent.FMAssnStrLocnSubResultFrame.location.href="../../eFM/jsp/FMAssignStorageLocnSubResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&maintain_doc_or_file="+maintain_doc_or_file+"&whereClause="+whereClause;
				
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
				return true;
			}
			else
			{
				document.forms[0].patient_id.focus();
			}
		}
		else
		{
			var msg =	getMessage('ATLEAST_ONE_CRITERIA','FM');
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
		var fields;
		
		fields = new Array(	FMAssnStrLocnCriteriaForm.file_no,
							FMAssnStrLocnCriteriaForm.doc_type_code,
							FMAssnStrLocnCriteriaForm.doc_folder_id
						  );	
		for(i=0;i<fields.length;i++) 
		{
			if(fields[i] != null)
			{
				if(trimCheck(fields[i].value))  empty++;
			}
		}
		if(empty != 0) 
		{
			flag=true;
			if(fields[0] != null)
			{
				if( trimCheck(fields[0].value)) 
				{
					whereClause = whereClause + " a.file_no = trim('" + fields[0].value + "') and ";
				}
			}
			if(fields[1] != null)
			{
				if( trimCheck(fields[1].value)) 
				{
					whereClause = whereClause + " a.doc_type_code = trim('" + fields[1].value + "') and ";
				}
			}
			if(fields[2] != null)
			{
				if( trimCheck(fields[2].value)) 
				{
					whereClause = whereClause + " a.doc_folder_id = trim('" + fields[2].value + "') and ";
				}
			}
			whereClause = whereClause + strand;
			
			var replace_url		= 	/%/g ;
						
			whereClause   	= whereClause.replace(replace_url,"~" );
			if(whereClause.lastIndexOf("and") != -1)
			whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));
			whereClause += "order by 3";
			var chkFileds = "";
			var chkNames  = "";
			chkFileds = new Array (document.forms[0].doc_folder_id,document.forms[0].doc_type_code);
			chkNames = new Array (getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));	
			
			if(checkFields(chkFileds, chkNames, parent.parent.messageFrame)) 
			{
				document.forms[0].search_dtl.disabled=true;
				document.forms[0].reset1.disabled=true;
				
				parent.FMAssnStrLocnSubResultFrame.location.href="../../eFM/jsp/FMAssignStorageLocnSubResult.jsp?maintain_doc_or_file="+maintain_doc_or_file+"&whereClause="+whereClause;
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
				return true;
			}
		}
		else
		{
			var msg =	getMessage('ATLEAST_ONE_CRITERIA','FM');
			if(msg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
		}	
	}
}
function checkVal()
{
	var CBValStr	= parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	= parent.frames[1].document.forms[0].LocnValStr.value;

	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;
	for (i=fm_cnt; i<=to_cnt;i++)
	{
		var chk		= eval("document.forms[0].associate_yn"+i)
		var chk1	= eval("document.forms[0].fs_locn_code"+i)

		if(chk.checked)
		{
			if((CBValStr.indexOf(chk.name)) == -1)
				CBValStr += chk.name+"~";
		}
		if(chk1.value != "")
		{
			if((LocnValStr.indexOf(chk1.name)) == -1)
				LocnValStr += chk1.name+"|"+chk1.value+"~";
		}
	}
	parent.frames[1].document.forms[0].CBValStr.value	= CBValStr;
	parent.frames[1].document.forms[0].LocnValStr.value	= LocnValStr;
}

function dispRecord()
{
	var CBValStr	= parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	= parent.frames[1].document.forms[0].LocnValStr.value;
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
function loadCurrPage()
{
	var i				= 0;
	var CBValStr		= parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr		= parent.frames[1].document.forms[0].LocnValStr.value;
	var chk_val			= "";
	chk_val				= parent.frames[1].document.forms[0].locn_code.value;

	var fm_disp	= document.forms[0].fm_disp.value;
	var to_disp	= document.forms[0].to_disp.value;

	var fm_val	= parseInt(fm_disp);
	var to_val	= parseInt(to_disp);

	if(chk_val != "")
	{
		for(i=fm_val; i<=to_val; i++)
		{
			eval('document.forms[0].fs_locn_code'+i+'.value=chk_val;');
			eval('document.forms[0].associate_yn'+i+'.checked=true;');
			eval('document.forms[0].fs_locn_code'+i+'.disabled=true;');
			eval('document.forms[0].associate_yn'+i+'.disabled=true;');
		}
	}
}

function CBValue(obj1, obj2)
{
	var count;
	var count1;
	var del_obj			= obj1.name;
	var del_chk			= obj1.checked;
	var del_locn_obj	= "fs_locn_code"+obj2;
	var temp_cb_str		= "";
	var temp_locn_str	= "";
	var chk_locn = eval('document.forms[0].fs_locn_code'+obj2);

	if(!(del_chk))
	{
		
		var cbString	= parent.frames[1].document.forms[0].CBValStr.value;
		var locnString	= parent.frames[1].document.forms[0].LocnValStr.value;

		if(cbString == "")chk_locn.value = "";

		var split = cbString.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";
			}
			else
			{
				temp_cb_str = temp_cb_str;
			}
		}
		cbString = temp_cb_str;

		var split1 = locnString.split('~');
		for (i=0; i<(split1.length-1); i++)
		{
			var split_locn= split1[i].split('|');
			if(split_locn[0] != del_locn_obj)
			{
				temp_locn_str += split1[i]+"~";
			}
			else
			{
				eval('document.forms[0].'+del_locn_obj+'.value=""');
				temp_locn_str=temp_locn_str;
			}
		}
		locnString=temp_locn_str;
		parent.frames[1].document.forms[0].CBValStr.value=cbString;
		parent.frames[1].document.forms[0].LocnValStr.value=locnString;
	}
	else
	{
		if(chk_locn.value == "")
		{
			chk_locn.focus();
			var msg = getMessage('FILE_STORAGE_NOT_BLANK','FM');
			if(msg != "")
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
	var chk_value = obj.value;

	if(chk_value != "")
	{
		eval('document.forms[0].associate_yn'+obj2+'.checked=true');
	}
	else
	{
		eval('document.forms[0].associate_yn'+obj2+'.checked=false');
	}
	CBValue(eval('document.forms[0].associate_yn'+obj2+''),obj2);
	var msg="";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
}
function checkAll(obj) 
{
	if(confirm(getMessage('ASSIGN_ALL_FILES_DOCS','FM')))
	{
		var val = obj.value;
		document.forms[0].locn_code_main.value = val;
		document.forms[0].locn_code.disabled = true;
		var row_count	= parent.frames[2].document.forms[0].row_count.value;
		var fm_disp		= parent.frames[2].document.forms[0].fm_disp.value;
		var to_disp		= parent.frames[2].document.forms[0].to_disp.value;
		if(val !="")
		{
			for(var i=fm_disp; i<=to_disp; i++)
			{
			    parent.frames[2].document.getElementById('fs_locn_code'+i).value=val;
				parent.frames[2].document.getElementById('associate_yn' + i).checked = true;
				parent.frames[2].document.getElementById('fs_locn_code' + i).disabled = true;
				parent.frames[2].document.getElementById('associate_yn' + i).disabled = true;

			}
		}
		else
		{
			for (var i=fm_disp; i<=to_disp; i++)
			{
				parent.frames[2].document.getElementById('fs_locn_code' + i).value = "";
				parent.frames[2].document.getElementById('associate_yn' + i).checked = false;
				parent.frames[2].document.getElementById('fs_locn_code' + i).disabled = false;
				parent.frames[2].document.getElementById('associate_yn' + i).disabled = false;

			}
			parent.frames[1].document.forms[0].CBValStr.value="";
			parent.frames[1].document.forms[0].LocnValStr.value="";
		}
	}
	else
	{
		obj.value = "";
	}
}

function loadCurrPage()
{
	var i	= 0;

	var CBValStr	= parent.frames[1].document.forms[0].CBValStr.value;
	var LocnValStr	= parent.frames[1].document.forms[0].LocnValStr.value;
	chk_val			= parent.frames[1].document.forms[0].locn_code.value;
	var chk_val		= "";

	var fm_disp	= document.forms[0].fm_disp.value;
	var to_disp	= document.forms[0].to_disp.value;
	var fm_val	= parseInt(fm_disp);
	var to_val	= parseInt(to_disp);

	if(chk_val != "")
	{
		for(i=fm_val; i<=to_val; i++)
		{
			eval('document.forms[0].fs_locn_code'+i+'.value=chk_val;');
			eval('document.forms[0].associate_yn'+i+'.checked=true;');
			eval('document.forms[0].fs_locn_code'+i+'.disabled=true;');
			eval('document.forms[0].associate_yn'+i+'.disabled=true;');
		}
	}
}
function callMainResultPage(whereClause)
{
	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
	if(maintain_doc_or_file == 'D')
	{
		parent.FMAssnStrLocnMainResultFrame.location.href="../../eFM/jsp/DTAssignStorageLocnMainResult.jsp?whereClause="+whereClause;
	}
	else if(maintain_doc_or_file == 'F')
	{
		var file_type_appl_yn	 = document.forms[0].file_type_appl_yn.value;
		parent.FMAssnStrLocnMainResultFrame.location.href="../../eFM/jsp/FMAssignStorageLocnMainResult.jsp?whereClause="+whereClause+"&file_type_appl_yn="+file_type_appl_yn;
	}
}
function enableFields()
{
	parent.frames[0].document.forms[0].patient_id.disabled		= false;
	parent.frames[0].document.forms[0].pat_search.disabled		= false;	
	parent.frames[0].document.forms[0].terminal_digit.disabled	= false;
	if(parent.frames[0].document.forms[0].file_no != null)
		parent.frames[0].document.forms[0].file_no.disabled = false;
	if(parent.frames[0].document.forms[0].file_type_code != null)
		parent.frames[0].document.forms[0].file_type_code.disabled = false;
	parent.frames[0].document.forms[0].file_date.disabled	= false;
	parent.frames[0].document.forms[0].search_dtl.disabled	= false;
	parent.frames[0].document.forms[0].reset1.disabled		= false;
}
function displayMessage(msg)
{
	if(msg!="")
	{
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	}
	parent.FMAssnStrLocnSubResultFrame.document.forms[0].locn_code.disabled = "true";
}
function onSuccess()
{
	
	parent.frames[2].frames[1].frames[0].location.reload();
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
}
function reset()
{
	parent.frames[2].frames[1].frames[0].location.reload();
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
}
function clearValues()
{
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
