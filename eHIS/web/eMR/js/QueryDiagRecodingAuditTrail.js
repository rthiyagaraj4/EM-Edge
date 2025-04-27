function reset()
{
parent.frames[2].document.location.reload();
}

function clearScreen()
{
	//parent.header.location.href="../../eCommon/html/blank.html"
	//parent.query_result.location.href="../../eCommon/html/blank.html"
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}
function callSearch1()
{ 
	
	error=''
	if(document.forms[0].update_by_text.value=='')
		document.forms[0].update_by.value='';
	
 	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	//parent.frames[4].location.href="../../eCommon/html/blank.html";
    mr_diagnosis_code=document.forms[0].mr_diagnosis_code.value;

	//mr_diagnosis_code1=document.forms[0].mr_diagnosis_code1.value;
	patient_id=document.forms[0].patient_id.value;

	//var recodedfromdate=document.forms[0].encounter1_exp_date.value;
	//var recodedtodate=document.forms[0].encounter2_exp_date.value;
	var recodedfromdate='';
	var recodedtodate='';
	if(document.forms[0].encounter1_exp_date.value!='')
		recodedfromdate= convertDate(document.forms[0].encounter1_exp_date.value,'DMY',localeName,'en');
	if(document.forms[0].encounter2_exp_date.value!='')
		recodedtodate= convertDate(document.forms[0].encounter2_exp_date.value,'DMY',localeName,'en');

	encounter_id=document.forms[0].encounter_id.value;
	update_by=document.forms[0].update_by.value;
	encounter_type_sel=document.forms[0].encounter_type_sel.value;
	gender_val=document.forms[0].gender_val.value;
	age_from=document.forms[0].age_from.value;
	age_to=document.forms[0].age_to.value;
	diagnosis_stage=document.forms[0].diagnosis_stage.value;
	location_hidden=document.forms[0].location_hidden.value;
	location_sel=document.forms[0].location_sel.value;
	if(document.forms[0].location_desc.value=='')
		location_hidden='';
	else
		location_hidden=document.forms[0].location_hidden.value;


	 
	if(patient_id=="" && (recodedfromdate=="" || recodedtodate==""))
	{
	      error=getMessage("DIAG_REC0D_AUDIT",'MR');
       parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';
	}
	else
	{
		
		recodedfromdate=escape(recodedfromdate)
			
		recodedtodate=escape(recodedtodate)
			
			

 		parent.query_result.location.href="../../eMR/jsp/DiagRecodingAuditTrailQueryResult.jsp?mr_diagnosis_code="+mr_diagnosis_code+"&encounter_type_sel="+encounter_type_sel+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&update_by="+update_by+"&recodedfromdate="+recodedfromdate+"&recodedtodate="+recodedtodate+"&gender_val="+gender_val+"&age_from="+age_from+"&age_to="+age_to+"&location_hidden="+location_hidden+"&location_sel="+location_sel+"&diagnosis_stage="+diagnosis_stage;
	}
}

async function funPatient()
{
var patid= await PatientSearch('','','','','','','Y','','','OTHER');
if( patid ==null)patid="";
document.forms[0].patient_id.value = patid;
}

async function callSearch(obj,target)
{
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
       	tit= getLabel("eMR.RecodedBy.label","MR");
		//sql="Select appl_user_id code,appl_user_name description from sm_appl_user where  upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";

		sql="Select appl_user_id code,appl_user_name description from sm_appl_user_lang_vw where  language_id='"+localeName+"' and  upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		retVal = await CommonLookup( tit,argumentArray);
	
		if(retVal != null && retVal != "" )
	    {
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			document.forms[0].update_by.value=arr[0];
		}
}

async function callDiagnosis(obj,target)
{	var dialogTop	  = "50"; //50
	var dialogHeight  = "60vh" ; //35
	var dialogWidth   = "80vh" ; //50
	var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	//alert('diag_code'+diag_code);
	//alert('diag_desc'+diag_desc);
	var encounter_id	= '';
	
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=";   
	
	var retVal =  await window.showModalDialog(params,arguments,features);
	
	
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=obj.name;
		
		if(target.name=="diag_button"||obj.name=="mr_diagnosis_code")
		{
			document.forms[0].mr_diagnosis_code.value=retdata[0];
		}else if(target.name=="diag_button1"||obj.name=="mr_diagnosis_code1")
		{
			document.forms[0].mr_diagnosis_code1.value=retdata[0];
		}
    }

}
//Functions for repDiagRecodingAuditTrailForm.jsp fil	e 
async function callDiagnosis(obj)
{ 
	var dialogTop	  = "10px";
	var dialogHeight  = "600px" ;
	var dialogWidth   = "1000px" ;
	var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	var encounter_id	= '';
	
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator="; 
	
	

	var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=obj.name;
		
		document.forms[0][objname].value = retdata[0];	
    }
}
/*function funPatient()
{
	var patid=PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	document.forms[0].patient_id.value = patid;
}*/
async function searchCode(obj,target)
{
	    var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
       	tit=getLabel("eMR.RecodedBy.label","MR");
		//sql="Select appl_user_id code,appl_user_name description from sm_appl_user where  upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";
		sql="Select appl_user_id code,appl_user_name description from sm_appl_user_lang_vw where  language_id='"+localeName+"' upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and eff_status='E'";
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		retVal = await CommonLookup( tit,argumentArray);
		if(retVal != null && retVal != "" )
                {
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
		}
}

////////////////////////////////
async function searchCode_new()
{
	    var val_txt=document.forms[0].location_desc.value
		var facility_id     = document.forms[0].facility_id.value;
		var location_sel    = document.forms[0].location_sel.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	
		
       	
		if(location_sel=="C")
	    {
		    tit=getLabel("Common.clinic.label","Common");
			//sql="select clinic_code code,short_desc description  from op_clinic where facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(clinic_code ) like upper(?)";
			sql="select clinic_code code,short_desc description  from op_clinic_lang_vw where language_id='"+localeName+"' AND facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(clinic_code ) like upper(?)";
		}
		else
	    {
			tit=getLabel("Common.nursingUnit.label","Common");
			//sql="select nursing_unit_code code,short_desc description  from ip_nursing_unit where facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(nursing_unit_code ) like upper(?)";
			sql="select nursing_unit_code code,short_desc description  from ip_nursing_unit_lang_vw where language_id='"+localeName+"' AND facility_id='"+facility_id+"' and eff_status='E' and upper(short_desc)  like upper(?) and upper(nursing_unit_code ) like upper(?)";		
		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = val_txt;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
		retVal = await CommonLookup( tit,argumentArray);
		if(retVal != null && retVal != "" )
                {
			var ret1=unescape(retVal);
			
			arr=ret1.split(",");
			document.forms[0].location_desc.value=arr[1];
			document.forms[0].location_hidden.value=arr[0];
		}
}
//////////////////////////////////

//Newly added by Shyam on 17/09/2005
async function callLocation_desc(target)
{		       
	var text_value      = document.forms[0].location_desc;
	var target			= document.forms[0].location_desc;
	var facility_id     = document.forms[0].facility_id.value;
	var location_sel    = document.forms[0].location_sel.value;
	var retVal	=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10vh" ;
	var dialogWidth			= "40vw" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc="";
	var search_code="";
	var title=getLabel("Common.LocationDescription.label","Common");
	var sql="";
	if(location_sel=="C")
	{
	
		//sql="select clinic_code,short_desc from op_clinic where facility_id=`"+facility_id+"` and eff_status=`E` ";
		sql="select clinic_code,short_desc from op_clinic_lang_vw where language_id=`"+localeName+"` AND facility_id=`"+facility_id+"` and eff_status=`E` ";

		search_code="clinic_code";
		search_desc="short_desc";
	}
	else
	{
		//sql="select nursing_unit_code,short_desc from ip_nursing_unit where facility_id=`"+facility_id+"` and eff_status=`E`";
		sql="select nursing_unit_code,short_desc from ip_nursing_unit_lang_vw where language_id=`"+localeName+"` and facility_id=`"+facility_id+"` and eff_status=`E` ";

	  search_code="nursing_unit_code";
	  search_desc="short_desc";
	}
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.forms[0].location_desc.value=arr[0];
		document.forms[0].location_hidden.value=arr[1];
		document.forms[0].location_desc.focus();
	}
	

}
function clear_desc()
{
	document.forms[0].location_desc.value='';
	var sel=document.forms[0].location_sel.value;
	if(sel=="" || sel==null)
	{
	 document.forms[0].location_desc.disabled=true;
	 document.forms[0].location.disabled=true;
	}
	else
	{
	 document.forms[0].location_desc.disabled=false;
	 document.forms[0].location.disabled=false;
	}
	document.forms[0].location_hidden.value='';


}
function allowPositiveNumber() 
	{		
			var key = window.event.keyCode;
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		
	}
	function callAgeto(obj)
	{
		if(obj.value!='' || obj.value!=null)
		{
			document.forms[0].age_to.disabled=false;
		}
		else
			document.forms[0].age_to.disabled=true;


	}

	///Newly added by Shyam on 21/12/2005

async function showEncounter(enc,patid,Patient_Class)
{
	
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="CurrentEncounterMain.jsp";
	var win_height = "90vh";
	var win_width= "95vw";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
}
	function loadHeader()
	{
		parent.header.location.href='../../eMR/jsp/DiagRecodingAuditTrailHeader.jsp'
	}
	////////Newly added on 20/09/2005
	function displayToolTip_org(vala,valb,valc,vald,vale,valf,obj)
		{
		
			if (vala!="")
			{
				val = unescape(vala)
				//parent.frames[2].document.getElementById("t").innerHTML = vala;
				buildTable_org (vala,valb,valc,vald,vale,valf)
				/*bodwidth = parent.frames[1].document.body.offsetWidth
					
				bodheight = parent.frames[1].document.body.offsetHeight

				var x =event.x
				var y =event.y;
				
					var x1=x;
					var y1=y;
				x = x + (document.getElementById("tooltiplayer").offsetWidth)
				y = y + (document.getElementById("tooltiplayer").offsetHeight)

				if(x<bodwidth)
					x =event.x 
				else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight )
					y =event.y
				else if(event.y>bodheight)
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				else
					y = y - (document.getElementById("tooltiplayer").offsetHeight);

					y+=document.body.scrollTop
					x+=document.body.scrollLeft 


					document.getElementById("tooltiplayer").style.posLeft= x

					if(document.getElementById("tooltiplayer").offsetWidth > 250)
						document.getElementById("tooltiplayer").style.posLeft = 111	
					else
						document.getElementById("tooltiplayer").style.posLeft = 275 
					document.getElementById("tooltiplayer").style.posTop = y */
					parent.frames[2].document.getElementById("tooltiplayer").style.visibility='visible' 
			}
			}

			
			function buildTable_org(one,two,diag_stage,diag_type,recorded_date,recorded_by)
			{
				
				//var concat=val.split("|");
				//var org=concat.split(
				if(two==null) two="";
				if(one==null) one="";
				

				var tab_dat  ="<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'  style='background-color:lightblue' align='center'>";
				tab_dat+="<tr ><td  style='background-color:lightblue' colspan=4></td></tr>";

                 tab_dat+="<tr ><td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OriginalDiagStage.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_stage+"</small></td>";
                  tab_dat+="<td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OriginalDiagType.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_type+"</small></td></tr>";
                 //////////////////////////////////////////////////////
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OriginalDiagDescription.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
               //  tab_dat+="<td  colspan=3 style='background-color:lightblue' align=left ><small>"+one+"</small></td></tr>";
			    //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
                 tab_dat+="<td  colspan=3 style='background-color:lightblue' align=left ><small>"+decodeURIComponent(one.replace(/[+]/g," "))+"</small></td></tr>";
				 tab_dat+="<tr ><td   style='background-color:lightblue'   align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OriginalDiagRemarks.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
				 //tab_dat+="<td colspan=3 style='background-color:lightblue' align=left><small>"+two+"</small></td></tr>";
                 tab_dat+="<td colspan=3 style='background-color:lightblue' align=left><small>"+decodeURIComponent(two.replace(/[+]/g," "))+"</small></td></tr>";

				 //////Newly added by shyam on 2/11/2005/////////////////
				 
                
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.RecordedBy.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_by+"</small></td>";

				 //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
                // tab_dat+="<td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.recordeddate.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.recordeddate.label","Common")+" "+getLabel("Common.time.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_date+"</small></td></tr>";
                

				 tab_dat+"</table>";
				 if (parent.frames[2].document.getElementById("t") != null)
					parent.frames[2].document.getElementById("t").innerHTML = tab_dat

			}

		function displayToolTip(vala,valb,valc,vald,vale,valf,obj)
		{
		
			if (vala!="")
			{
				val = unescape(vala)
				//parent.frames[2].document.getElementById("t").innerHTML = vala;
				buildTable (vala,valb,valc,vald,vale,valf)
				/*bodwidth = parent.frames[1].document.body.offsetWidth
					
				bodheight = parent.frames[1].document.body.offsetHeight

				var x =event.x
				var y =event.y;
				
					var x1=x;
					var y1=y;
				x = x + (document.getElementById("tooltiplayer").offsetWidth)
				y = y + (document.getElementById("tooltiplayer").offsetHeight)

				if(x<bodwidth)
					x =event.x 
				else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight )
					y =event.y
				else if(event.y>bodheight)
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				else
					y = y - (document.getElementById("tooltiplayer").offsetHeight);

					y+=document.body.scrollTop
					x+=document.body.scrollLeft 


					document.getElementById("tooltiplayer").style.posLeft= x

					if(document.getElementById("tooltiplayer").offsetWidth > 250)
						document.getElementById("tooltiplayer").style.posLeft = 111	
					else
						document.getElementById("tooltiplayer").style.posLeft = 275 */
				//document.getElementById("tooltiplayer").style.posTop = y 
					parent.frames[2].document.getElementById("tooltiplayer").style.visibility='visible' 
			}
			}

			function hideToolTip()
			{
					parent.frames[2].document.getElementById("tooltiplayer").style.visibility='hidden'
			}
			function buildTable1(one,two,diag_stage,diag_type,recorded_date,recorded_by)
			{
				
				//var concat=val.split("|");
				//var org=concat.split(
				if(two==null) two="";
				if(one==null) one="";
				

				var tab_dat  ="<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'  style='background-color:lightblue' align='center'>";
				tab_dat+="<tr ><td  style='background-color:lightblue' colspan=4></td></tr>";

                 tab_dat+="<tr ><td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OldDiagStage.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_stage+"</small></td>";
                  tab_dat+="<td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OldDiagType.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_type+"</small></td></tr>";
                 //////////////////////////////////////////////////////
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OldDiagDescription.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td  colspan=3 style='background-color:lightblue' align=left ><small>"+one+"</small></td></tr>";
				 tab_dat+="<tr ><td   style='background-color:lightblue'   align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.OldDiagRemarks.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td colspan=3 style='background-color:lightblue' align=left><small>"+two+"</small></td></tr>";
				 //////Newly added by shyam on 2/11/2005/////////////////
				 
                
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.RecodedBy.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_by+"</small></td>";

				 
                 tab_dat+="<td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.recordeddate.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_date+"</small></td></tr>";
                
				 tab_dat+"</table>";
				 if (parent.frames[2].document.getElementById("t") != null)
					parent.frames[2].document.getElementById("t").innerHTML = tab_dat

			}

				function displayToolTip1(vala,valb,valc,vald,vale,valf,obj)
		        {
			 
			
				if (vala!="")
			    {
				val = unescape(vala)
				//parent.frames[2].document.getElementById("t").innerHTML = vala;
				buildTable1 (vala,valb,valc,vald,vale,valf)
				/*bodwidth = parent.frames[1].document.body.offsetWidth
					
				bodheight = parent.frames[1].document.body.offsetHeight

				var x =event.x
				var y =event.y;
				
					var x1=x;
					var y1=y;
				x = x + (document.getElementById("tooltiplayer").offsetWidth)
				y = y + (document.getElementById("tooltiplayer").offsetHeight)

				if(x<bodwidth)
					x =event.x 
				else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight )
					y =event.y
				else if(event.y>bodheight)
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				else
					y = y - (document.getElementById("tooltiplayer").offsetHeight);

					y+=document.body.scrollTop
					x+=document.body.scrollLeft 


					document.getElementById("tooltiplayer").style.posLeft= x

					if(document.getElementById("tooltiplayer").offsetWidth > 250)
						document.getElementById("tooltiplayer").style.posLeft = 111	
					else
						document.getElementById("tooltiplayer").style.posLeft = 275 */
					//document.getElementById("tooltiplayer").style.posTop = y 
					parent.frames[2].document.getElementById("tooltiplayer").style.visibility='visible' 
			}
			}

			
			function buildTable(one,two,diag_stage,diag_type,recorded_date,recorded_by)
			{
				
				//var concat=val.split("|");
				//var org=concat.split(
				if(two==null) two="";
				if(one==null) one="";

				var tab_dat  ="<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%'  style='background-color:lightblue' align='center'>";
				tab_dat+="<tr ><td  style='background-color:lightblue' colspan=4></td></tr>";

                 tab_dat+="<tr ><td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.NewDiagStage.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_stage+"</small></td>";
                  tab_dat+="<td    style='background-color:lightblue' width='10%'align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.NewDiagType.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left width='40%'><small>"+diag_type+"</small></td></tr>";
                 //////////////////////////////////////////////////////
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.NewDiagDescription.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                // tab_dat+="<td  colspan=3 style='background-color:lightblue' align=left ><small>"+one+"</small></td></tr>";
				 //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
                 tab_dat+="<td  colspan=3 style='background-color:lightblue' align=left ><small>"+decodeURIComponent(one.replace(/[+]/g," "))+"</small></td></tr>";
				 tab_dat+="<tr ><td   style='background-color:lightblue'   align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.NewDiagRemarks.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
				 //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
                // tab_dat+="<td colspan=3 style='background-color:lightblue' align=left><small>"+two+"</small></td></tr>";
                 tab_dat+="<td colspan=3 style='background-color:lightblue' align=left><small>"+decodeURIComponent(two.replace(/[+]/g," "))+"</small></td></tr>";
				 //////Newly added by shyam on 2/11/2005/////////////////
				 
                
                 tab_dat+="<tr ><td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("eMR.RecodedBy.label","MR")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_by+"</small></td>";

				 //Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]
                 //tab_dat+="<td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.recordeddate.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
				 tab_dat+="<td    style='background-color:lightblue' align=right nowrap><b><FONT SIZE='1'>"+getLabel("Common.recordeddate.label","Common")+ " "+getLabel("Common.time.label","Common")+":</font></b>&nbsp;&nbsp;</td>";
                 tab_dat+="<td   style='background-color:lightblue' align=left ><small>"+recorded_date+"</small></td></tr>";
                

				 tab_dat+"</table>";
				 if (parent.frames[2].document.getElementById("t") != null)
					parent.frames[2].document.getElementById("t").innerHTML = tab_dat

			}
async function call_Diagnosis(obj)
{ 
	var dialogTop	  = "50";
	var dialogHeight  = "99vh" ;
	var dialogWidth   = "70vw" ;
	var features    ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	var term_set   = document.forms[0].original_set.value;
	var encounter_id	= '';
	
	//var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?title="+diag_desc+" Code List&p_diag_code=";		
	//params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator="; 
	/*modified on 3/29/2009*/
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?term_set_id="+term_set+"&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator="; 
	

	var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=obj.name;
		
		 document.forms[0][objname].value = retdata[0];	
    }
}
function enable_code()
{
	
	document.forms[0].p_diag_code.value='';
	var sel=document.forms[0].original_set.value;
	if(sel=="" || sel==null)
	{
	 document.forms[0].p_diag_code.disabled=true;
	 document.forms[0].diag_button.disabled=true;
	 document.getElementById("i_diag_code").style.visibility="hidden";
	}
	else
	{
	 document.forms[0].p_diag_code.disabled=false;
	 document.forms[0].diag_button.disabled=false;
	 document.getElementById("i_diag_code").style.visibility="visible";
	}
	


}
