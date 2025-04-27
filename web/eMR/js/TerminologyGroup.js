// N.S. Ramanjaneyulu
// Added Functionality By N.S. Ramanjaneyulu on 12-08-2005

var qstring="";
var sn_val="";
function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=1";
}

/**************************************** End of Create() method.***************************************/


function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/TerminologyGroupQueryCriteria.jsp";
}

/**************************************** End of Query() method.****************************************/


function reset()
{
	var loc=frames[1].document.forms[0];
	var href;

	if(loc!=null)
	{
		parent.frames[2].frames[1].document.location.reload();
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		//href=loc.document.location.href;
		href="";
		//href=href.toLowerCase();

		if(href.indexOf("criteria.jsp")!=-1) 
		{
			//frames[1].document.forms[0].reset();
			frames[1].document.forms[0].document.location.reload();
		}
		else if(href.indexOf("result.jsp")!=-1)
		{
		}
	}
	else
	{
		var loc1=f_query_add_mod.document.location.href;
		loc1=loc1.toLowerCase();
		if(!(loc1.indexOf("blank")==-1))
		{
		}
		else if(loc1.indexOf("header")!=-1)
		{
			if(f_query_add_mod.term_associated.document.location.href!=null)
			{
				var loc2=f_query_add_mod.term_associated.document.location.href;
				var obj=f_query_add_mod.term_set.document.TerminologyAddModify_Form;
				if(loc2.indexOf("blank")!=-1)
				{
					obj.reset();
					f_query_add_mod.term_set.document.forms[0].inp.style.visibility='hidden';
				}
				else if(loc2!=null)
				{
					var term_group_id=obj.Term_Group_ID.value;
					var term_set_id=obj.term_set_id.value;	
					//var term_group_desc=obj.Term_Group_Desc.value;
					var eff_status=obj.term_status_yn.value;
					var term_set_desc=obj.desc.value;
					var mode=obj.mode.value;
					var term_index_yn=obj.term_index_yn.value;
//					eff_status="E";
					if(mode=="1")
					{
						f_query_add_mod.document.location.href='../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=1';
					}
					else if (mode=="2")
					{
						eff_status=f_query_add_mod.term_set.document.getElementById('TerminologyAddModify_Form').effstatus.value;
						//eff_status=f_query_add_mod.document.getElementById("effstatus").value;
						obj.reset();
						var term_group_desc=obj.Term_Group_Desc.value;
						f_query_add_mod.location.href="../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=2&term_group_id="+term_group_id+"&term_set_id="+term_set_id+"&term_group_desc="+escape(term_group_desc)+"&eff_status="+eff_status+"&term_set_desc="+term_set_desc+"&indexed="+term_index_yn;
					}
				}
			}
		}
	}
}

/**************************************** End of Reset() method.****************************************/


function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();

		if(url.indexOf("blank.html")!=-1)
			return false;

		else if((url.indexOf("addmodifyheader.jsp")!=-1) && (url.indexOf("header.jsp")!=-1) && url.indexOf("blank.html")==-1)
		{
			return true;
			/*var a=f_query_add_mod.term_associated.location.href;
			a = a.toLowerCase();

			if(a.indexOf("blank.html")==-1)
			{
				return true;
			}*/
		}
		else
		{
			return false;
		}
}

/********************************* End of checkIsValidForProceed() method.******************************/


function apply()
{
	var message="";
	var messageFrame = parent.frames[2].frames[2]; 
	if (!checkIsValidForProceed()) 
	{
		//var message=getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		return false;
	}

	var formObj	= f_query_add_mod.term_set.document.TerminologyAddModify_Form;
	var term_group_id = formObj.Term_Group_ID.value;
	var term_group_desc= formObj.Term_Group_Desc.value;
	var term_set_id=formObj.term_set_id.value;
	var term_status_yn=formObj.term_status_yn.value;
	var t="";
	var t1="";
	var termcodes="";
	var t2="";
	var sn="";
	var sn_vals="";

	// Getting Frame reference to get the values of term_code and term_level
	var params = "term_group_id="+term_group_id+"&term_group_desc="+escape(term_group_desc)+"&term_set_id="+term_set_id+"&term_status_yn="+term_status_yn;

	if(formObj.term_status_yn.checked==true)
		formObj.term_status_yn.value="E";
	else
		formObj.term_status_yn.value="D";

	var	fields = new Array (formObj.Term_Group_ID,formObj.Term_Group_Desc,formObj.term_set_id);
	var	names =	new Array (getLabel("Common.identification.label","Common"),getLabel("Common.description.label","Common"),getLabel("Common.TermSet.label","Common"));

	var disp_type="M";
	var specfield=new Array(formObj.Term_Group_ID);
	var specname=new Array(getLabel("Common.identification.label","Common"));
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame))
	{
		var tcode=f_query_add_mod.term_associated.document.term_code_associated==null?null:f_query_add_mod.term_associated.document.term_code_associated;

		var count=null;
		if(tcode!=null)
		count = tcode.count.value;

		var f=0;
		var temp_sn=new Array();
		if(count!=null)
		{
			var fun=tcode.fun.value;
			for(var i=0;i<count;i++)
			{	
				t=eval("tcode.term_chk"+i);
				t1=eval("tcode.term_code"+i);
				sn=eval("tcode.term_sn"+i);

				if(t.checked==true)
				{
					termcodes+=t1.value+"~";
					sn_vals+=sn.value+"~";
					f=1;
				}
				temp_sn[i]=sn.value;
			}

			for(var i=0;i<temp_sn.length;i++)
			{
				var tmp=temp_sn[i];
				t=eval("tcode.term_chk"+i);
				if((temp_sn[i]=="" || temp_sn[i]==null) && t.checked==true)
				{
					if(tmp=="")
					{
						message=getMessage("SERIAL_NO_NOT_BLANK",'MR');
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
						return false;
					}
				}
				else if(temp_sn[i]!="" && t.checked==true)
				{
					if(tmp=="0" || tmp==("00") || tmp=="000")
					{	
						message=getMessage("VALUE_SHOULD_BE_GR_ZERO",'Common');
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
						return false;
					}
					for(var j=i+1;j<temp_sn.length;j++)
					{
						if(tmp!="" & eval(tmp)==eval(temp_sn[j]))
						{
							message=getMessage("DUP_SERIAL_NO",'MR');
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
							return false;
						}
					}
				}
			}

			if(f==0)
			{
				message=getMessage("ATLEAST_ONE_SELECTED",'Common');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
				return false;
			}
			else
			{
				params+="&termcodes="+termcodes;
				params+="&function="+fun;
				params+="&sr_nos="+sn_vals;
				params+="&indextype_yn="+formObj.term_index_yn.value;
//				params+="&indexed="+formObj.indexed.value;

				if(f_query_add_mod.SpecialCharCheck(specfield, specname, messageFrame,disp_type,error_jsp) && termcodes!="")
				{
					f_query_add_mod.term_associated.document.term_code_associated.action="../../servlet/eMR.TerminologyGroupServlet?"+params;
					parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
					parent.frames[2].frames[1].frames[1].document.forms[0].submit();

				}
			}
		}
		else
		{
			message=getMessage("ATLEAST_ONE_SELECTED",'Common');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			return false;
		}
	}		
}

/**************************************** End of Apply() method.***************************************/


function onSuccess()
{
  	var formObj=f_query_add_mod.term_associated.document.term_code_associated;
	   
	var mode =formObj.mode.value;
	

	if(mode!="2")
	{
		formObj.reset();
		f_query_add_mod.location.href='../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=1';
    }
	else
	{
		var obj=f_query_add_mod.term_set.document.TerminologyAddModify_Form;
		var term_group_id=obj.Term_Group_ID.value;
		var term_set_id=obj.term_set_id.value;	
		var term_group_desc=obj.Term_Group_Desc.value;
		var eff_status=obj.term_status_yn.value;
		var term_set_desc=obj.desc.value;
		var term_index_yn=obj.term_index_yn.value;
	
		f_query_add_mod.location.href="../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=2&term_group_id="+term_group_id+"&term_set_id="+term_set_id+"&term_group_desc="+escape(term_group_desc)+"&eff_status="+eff_status+"&term_set_desc="+term_set_desc+"&indexed="+term_index_yn;
	}
  }

/*************************************** End of onSuccess() method.*************************************/

function indicatorcheck(obj)
{
  var formObj=document.forms[0];
  if(obj.checked==true)
  {
    formObj.Indicator1.value=obj.value;
  }
}


/********* This fuction is to add Button dynamically as and when the option value is changed *********/


function changeTerminology(obj)
{
	var val=obj.value;
	if(val!="")
	{
		document.forms[0].inp.style.visibility='visible';
		document.forms[0].desc.value = document.forms[0].term_set_id.value;
	}	
	else
	{
		document.forms[0].inp.style.visibility='hidden';
		document.forms[0].term_set_id.options.selectedIndex=0;
	}
	
}

/************************************ End of changeTerminology() method.********************************/


/********* This fuction is to Call a page Dynamically as and when we click on Term Code Button *********/

async function callTermCode(obj)
{
	TerminologyAddModify_Form.term_set_id.disabled=true;
	var temp_term_code = "";
	var term_code_associated = "";
	var mode ="";

	if(parent.term_associated.document.term_code_associated!=null)
	{
		temp_term_code = parent.term_associated.document.term_code_associated.temp_term_code.value;
		term_code_associated = parent.term_associated.document.term_code_associated.term_code_associated.value;
		var DB_term_code_associated = parent.term_associated.document.term_code_associated.DB_term_code_associated.value;
		mode = parent.term_associated.document.term_code_associated.mode.value;
		}
	var returnVal1="";
	if(parent.term_associated.document.term_code_associated!=null){
	returnVal1 = parent.term_associated.document.term_code_associated.returnVal1.value;
	}
	if(mode=="")
		mode="1";
	var multiple_yn = "Y";
	var term_group_id=TerminologyAddModify_Form.Term_Group_ID.value;
	var term_set_id= obj.value;
	var retVal = new String();
    var dialogHeight= "450px" ;
    var dialogWidth = "750px" ;
    var status = "no";
	//var dialogUrl       = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+document.TerminologyAddModify_Form.desc.value+"&term_group_id="+term_group_id+"&term_set_id="+term_set_id+"&mulitple_yn="+multiple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated;
	var dialogUrl       = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+document.TerminologyAddModify_Form.desc.value+"&term_group_id="+term_group_id+"&term_set_id="+term_set_id+"&mulitple_yn="+multiple_yn+"&temp_term_code="+temp_term_code+"&returnVal1="+returnVal1;
	/*if(mode == '2')
	{
			dialogUrl+= "&Db_term_code="+DB_term_code_associated;
	}*/
	var dialogArguments = term_set_id;
	var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnVal = await window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);

	var path="mode="+mode+"&term_code_associated="+term_code_associated+"&term_set="+document.TerminologyAddModify_Form.term_set_id.value+"&Db_term_code="+DB_term_code_associated;

	if( returnVal == null || returnVal == "")
	{
		if(parent.term_associated.document.term_code_associated==null)
		{
			TerminologyAddModify_Form.term_set_id.disabled=false;
			TerminologyAddModify_Form.term_set_id.options.selectedIndex=0;
			parent.term_set.document.forms[0].inp.style.visibility='hidden';
		}
	}
	else
	{
	/*	var retValCode = returnVal.split("~");
		var term_code_associated ="";
		for(var i=0;i<(retValCode.length-1);i++)
		{
			var retVal = retValCode[i].split("||");
			term_code =retVal[0];
			term_code_desc =retVal[1];
			level_desc =retVal[2];
			if(level_desc=='')
				level_desc='||';
			var level = retVal[3];
			if(level=='')
				level='||';
			term_code_associated += term_code+"~"+level+"~"+level_desc+"~"+term_code_desc+"`";
			
			
		}*/

//parent.term_associated.location.href="../../eMR/jsp/TerminologyGroupAddModifyDetail.jsp?mode="+mode+"&term_code_associated="+term_code_associated+"&term_set="+document.TerminologyAddModify_Form.term_set_id.value+"&returnVal="+returnVal+"&Db_term_code="+DB_term_code_associated+"&indextype_yn="+document.TerminologyAddModify_Form.term_index_yn.value;
parent.term_associated.location.href="../../eMR/jsp/TerminologyGroupAddModifyDetail.jsp?mode="+mode+"&term_set="+document.TerminologyAddModify_Form.term_set_id.value+"&returnVal="+returnVal+"&indextype_yn="+document.TerminologyAddModify_Form.term_index_yn.value;
	}
}

/************************************** End of callTermCode() method.***********************************/


/******************************* Writen on 09-08-2005 by N.S. Ramanjaneyulu ****************************/

function change()
{
	if (TerminologyAddModify_Form.term_status_yn.checked == true)
	{
		TerminologyAddModify_Form.term_status_yn.value="E";
		TerminologyAddModify_Form.term_status_yn.checked=true;
	}

	else
	{
		TerminologyAddModify_Form.term_status_yn.value="D";
		TerminologyAddModify_Form.term_status_yn.checked=false;
	}
}

/***************************************** End of change() method.**************************************/


function allowPositiveNumber() 
{
	var key = window.event.keyCode;
	
	// allows only numbers to be entered
	
	if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
}


function changeIndex(obj) 
{
	if(obj.checked==true)
	{
		obj.value="Y";
	}
	else if(obj.checked==false)
	{
		obj.value="N";
	}
}
