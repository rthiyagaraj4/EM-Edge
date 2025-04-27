function getPatient(obj)
{
	var patientid=PatientSearchWithGender('F','N');
	var patseries = document.forms[0].gypatseries.value;

	if(patientid != null)
	{
		if(obj.name == "src_pat_search")
		{
			top.content.frames[1].document.getElementById('encounter_id').value = "";
			parent.frames[1].document.getElementById("srcpatinfo").innerText = "";
			top.content.frames[2].location.href = "../../eCommon/html/blank.html";
			top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp"; 
			document.forms[0].src_pat_id.value = patientid;
			//document.MTPAddModifyForm.all.search.disabled = true;
			document.getElementById(search).disabled = true;

		}
		else
		{
			var patser = patientid.substring(0,2);
			
			if(patser == patseries)
			{
				var srcpat	=	 document.forms[0].src_pat_id.value;

				if(srcpat != patientid)
				{
					top.content.frames[1].document.getElementById('tgt_encounter_id').value = "";
					parent.frames[1].document.getElementById("tgtpatinfo").innerText = "";
					top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp";
					document.forms[0].tgt_pat_id.value = patientid;
				}
				else
				{
					alert(getMessage("SRC_TGT_PAT_CANNOT_BE_SAME","CA"));
					document.forms[0].tgt_pat_id.focus();
					return false;
				}
			}
			else
			{
				alert(getMessage("PAT_SERIES_NOT_ALLOWED","CA"));
				document.forms[0].tgt_pat_id.focus();
				return false;
			}
		}
	}
}

async function callSearchScreen(val,obj)
{
	if(val=='E') 
	{
		var retVal =    new String();
		var objname =	obj.name;

		var dialogHeight = "23.4" ;
		var dialogWidth  = "40" ;
		var dialogTop    = "65";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
		var arguments		= "" ;
		var patient_id		=	"";
		
		if(objname == "enc_id_search")
			patient_id = document.forms[0].src_pat_id.value;
		else
			patient_id = document.forms[0].tgt_pat_id.value;
		
		retVal =await window.showModalDialog("../../eCA/jsp/CAEncounterDisplayFrame.jsp?patient_id="+patient_id,arguments,features);

		var srcPatientId	=	document.forms[0].src_pat_id.value;
		var srcEncId		=	document.forms[0].encounter_id.value;

		if(retVal != null) 
		{
			retVal = retVal.split("|");

			if(objname =="enc_id_search")
			{
				document.forms[0].encounter_id.value = retVal[0];
				document.forms[0].encounter_id.focus();
			}
			else
			{
				document.forms[0].tgt_encounter_id.value = retVal[0];
				document.forms[0].tgt_encounter_id.focus();
			}

			parent.frames[2].location.href = "../../eCA/jsp/MTPEventsList.jsp?patient_id="+patient_id+"&enc_id="+retVal[0]+"&objname="+objname+"&srcpatid="+srcPatientId+"&srcencid="+srcEncId+"&mode=1";
		}
	}
}


function validSplchars1(obj) 
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";

	if(SpecialCharCheck( fields, names,'',"A",'')) 
	{
		return true;
	} 
	else 
	{
		obj.select();
		obj.focus();
		return false;
	}
}


async function callResults(nIndex)
{
	var accObj			=	eval("document.forms[0].acc_num"+nIndex);
	var HistRecObj		=	eval("document.forms[0].hist_type"+nIndex);
	var ContrSysObj		=	eval("document.forms[0].cont_sysid"+nIndex);
	var ContEvCodeObj	=	eval("document.forms[0].cont_evcode"+nIndex);

	var win_height		= "28";
	var win_width		= "70";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT')
	{
		win_height		= "23";
		win_width		= "37";
		win_scroll_yn	= "no";
	}

	var retVal = new String();


	var Accessionnum		=	accObj.value;
	var Histrectype			=	HistRecObj.value;
	var Contrsysid			=	ContrSysObj.value;
	var Contrsyseventcode	=	ContEvCodeObj.value;

	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	retVal =await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
}


function apply()
{
	var totrecs =	0;

	if(top.content.frames[2].document.forms[0] != null)
		totrecs		=	top.content.frames[2].document.forms[0].totalrecs.value;

	var patseries = top.content.frames[1].document.forms[0].gypatseries.value;

	if(patseries == "")
	{
		alert(getMessage("TGT_PAT_SERIES_NOT_CONFIG","CA"));
		return false;
	}

	var srcpatient_id	=	top.content.frames[1].document.forms[0].src_pat_id.value;
	var srcenc_id		=	top.content.frames[1].document.forms[0].encounter_id.value;
	var tgtpatient_id	=	top.content.frames[1].document.forms[0].tgt_pat_id.value;
	var tgtenc_id		=	top.content.frames[1].document.forms[0].tgt_encounter_id.value;

	var fields	= new Array(top.content.frames[1].document.forms[0].src_pat_id,top.content.frames[1].document.forms[0].encounter_id,top.content.frames[1].document.forms[0].tgt_pat_id,top.content.frames[1].document.forms[0].tgt_encounter_id);
	var names	= new Array ("Source Patient Id","Source Encounter Id","Target Patient Id","Target Encounter Id");

	/*if(srcpatient_id != "" && tgtpatient_id != "")
	{
		if(srcpatient_id == tgtpatient_id)
		{
			var ermsg = getMessage("SRC_TGT_PAT_CANNOT_BE_SAME","CA");//getMessage("SELECT_EVENT_CLASS","CA");
			top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_value=1&err_num="+ermsg;
			top.content.frames[0].location.reload();
			return false;
		}
	} */
	if(checkFields(fields,names,top.content.frames[3],'../../eCommon/jsp/error.jsp'))
	{
		var vCheckedstr	=	"";

		var checkObj	=	"";

		var yy		=	0;

		if(srcpatient_id == tgtpatient_id)
		{
			var ermsg = getMessage("SRC_TGT_PAT_CANNOT_BE_SAME","CA");//getMessage("SELECT_EVENT_CLASS","CA");
			top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_value=1&err_num="+ermsg;
			top.content.frames[0].location.reload();
			return false;
		}

		for(var xx = 0; xx < totrecs; xx++)
		{
			checkObj	= eval("top.content.frames[2].document.getElementById("selopt")"+xx);

			if(checkObj.checked)
			{
				var accObj			=	eval("top.content.frames[2].document.forms[0].acc_num"+xx);
				var HistRecObj		=	eval("top.content.frames[2].document.forms[0].hist_type"+xx);
				var ContrSysObj		=	eval("top.content.frames[2].document.forms[0].cont_sysid"+xx);
				var ContEvCodeObj	=	eval("top.content.frames[2].document.forms[0].cont_evcode"+xx);

				vCheckedstr			+=	accObj.value+":"+HistRecObj.value+":"+ContrSysObj.value+":"+ContEvCodeObj.value+",";
				yy++;
			}
		}
	
		if(	vCheckedstr == "" || yy == 0  )
		{
			var ermsg = getMessage("SELECT_EVENT_CLASS","CA");
			top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_value=1&err_num="+ermsg;
			return false;
		}
		else
		{
			top.content.frames[2].document.forms[0].selopt.value =  vCheckedstr;
			top.content.frames[2].document.forms[0].cntselrecs.value =  yy;
			top.content.frames[2].document.forms[0].submit();
		}
	}
	else
	{
		return false;
	}
}

function reset()
{
	top.content.frames[1].location.href = "../../eCA/jsp/MTPAddModify.jsp";
	top.content.frames[2].location.href = "../../eCommon/html/blank.html";
	top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp";
}

function fetchRecs()
{
	var srcpatient_id	=	top.content.frames[1].document.forms[0].src_pat_id.value;
	var srcenc_id		=	top.content.frames[1].document.forms[0].encounter_id.value;

	var fields	= new Array(top.content.frames[1].document.forms[0].src_pat_id,top.content.frames[1].document.forms[0].encounter_id);
	var names	= new Array ("Source Patient Id","Source Encounter Id");

	top.content.frames[3].location.href = "../../eCommon/jsp/error.jsp";
	if(checkFields(fields,names))
	{	
		var tgtpatient_id	=	top.content.frames[1].document.forms[0].tgt_pat_id.value;
		var tgtenc_id		=	top.content.frames[1].document.forms[0].tgt_encounter_id.value;
	
		parent.frames[2].location.href = "../../eCA/jsp/MTPEventsList.jsp?patient_id="+tgtpatient_id+"&enc_id="+tgtenc_id+"&srcpatid="+srcpatient_id+"&srcencid="+srcenc_id+"&mode=2";
	}
	else
		return false;
}

function onSuccess()
{
}
