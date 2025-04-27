var rowEle = "";
var Que="Que";
var refresh_param=0;
/* Below lines added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
var prevObjID;
var prevClassName;
var prevImgObj;
var prevlink;
/*end Bru-HIMS-CRF-303 [IN035021] */
function query()
{
 frame1.location.href="../../eOP/jsp/ManageSPatQueueFr2.jsp?Que=Que&refresh="+refresh_param;
}
 function clearList()
{
parent.frame1.manage_patient.Qloc.value="";    
parent.frame1.manage_patient.Qloc1.value="";     
//spec_code=parent.frame1.manage_patient.Qspeciality.value;   

 

}

function onBlurgetLoc(loginuser,oper_id,fac_id,objval,target)
{

		 
		if(target.value == "")
		{
			target.value="";
			document.forms[0].Qloc.value="";
			return;
		}
 getLocn(loginuser,oper_id,fac_id,objval,target);

}
async function getLocn(loginuser,oper_id,fac_id,objval,target)
{
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";				
   locale=document.forms[0].locale.value; 
   spec_code=document.forms[0].Qspeciality.value
   tit=getLabel("Common.Location.label",'Common')
   sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";

		if(!spec_code=="")
		{
		sql=sql+" and a.speciality_code='"+spec_code+"' ORDER BY  2";
		}else
		{
		sql=sql+"  ORDER BY  2";
		}
   
   
  				
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
				document.forms[0].Qloc.value=arr[0];


          }
}
function PopulateList(obj)
{
    
	var practcode = parent.frame1.manage_patient.Qpr;
	var loc_code  = parent.frame1.manage_patient.Qloc;
    if (loc_code)
    	var length  =loc_code.length;
     
    for(i=1;i<length;i++)
    	loc_code.remove(1);
    
    var operstnid   = manage_patient.Qoperstat.value;

    Qloctype =parent.frame1.manage_patient.Qloctype.value;   
	spec_code=parent.frame1.manage_patient.Qspeciality.value;   
	if(Qloctype!='')
	{
		if (operstnid != null && operstnid != "")
	    {
	        var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='managepatient' id='managepatient' method='post' action='../../eOP/jsp/ManagePatientQ.jsp'><input type='hidden' name='objname' id='objname' value='"+obj.name+"'><input type='hidden' name='objval' id='objval' value='"+obj.value+"'><input type='hidden' name='operstnid' id='operstnid' value='"+operstnid+"'><input type='hidden' name='spec_code' id='spec_code' value='"+spec_code+"'></form></body></html>";
	        parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	        parent.parent.messageFrame.document.managepatient.submit();
	    }
	}
}



function getRow(obj)
{
    rowEle = obj.rowIndex;
}

async function popupMenu(obj)
{
    var dialogHeight= "20vh" ;
    var dialogWidth = "15vw" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth ;
    var arguments   = "" ;

    var retVal = await window.showModalDialog("../../eOP/jsp/PopUpMenu.jsp?queuestatus="+p_queue_status+"",arguments,features);

    if (retVal=="ok")
    {
        //window.close();
		parent.parent.document.getElementById("dialog_tag").close();
    }
}

function loadMenus()
{

    window.myMenu2      = new Menu("Pat");
    myMenu2.addMenuItem("Patient Arrival");
    myMenu2.fontColor   = "red";
    myMenu2.menuItemBgColor = "white";

    myMenu2.writeMenus();
}

function reset() {
       
	  /*Below line was modified by Venkatesh.S on 13-Feb-2013 against 37912 */
	   /*Below line was modified by Venkatesh.S on 02-may-2013 against Bru-HIMS-CRF-179 [IN030297] */
     document.location.reload()
	 if(window.frames[1].ManagePatQueueFrame){  
		 window.frames[1].ManagePatQueueFrame.document.location.reload();
		 window.frames[1].frame2.location.href='../../eCommon/html/blank.html';
	 } 
}

// JS functions used in ManageSPatQ criteria.jsp

async function call_visit_regn(patient,q_appt_ref_no,referral_id,q_clinic_code,q_locn_type,q_Appt_time,q_visit_adm_type,q_practitioner_id,contact_reason_code,reason, service_code,resource_class)
{ 
		if(referral_id=='null')
			referral_id = "";
		if(contact_reason_code=='null')
			contact_reason_code = "";
		if(reason=='null')
			reason = "";
		if(service_code=='null')
			service_code = "";
				
		var dialogHeight= "67vh" ;
		var dialogWidth = "55vw" ;
		var dialogTop 	= "85";
		var center = "1" ; 
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retval= await window.showModalDialog("../../eOP/jsp/VisitRegistration.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register Visit&function_type=F&access=NYNNN&patient="+patient+"&q_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&q_clinic_code="+q_clinic_code+"&q_locn_type="+q_locn_type+"&q_visit_adm_type="+q_visit_adm_type+"&q_Appt_time="+q_Appt_time+"&q_practitioner_id="+q_practitioner_id+"&contact_reason_code="+contact_reason_code+"&reason="+reason+"&call_from=CA&service_code="+service_code+"&resource_class="+resource_class,arguments,features);
		
		//if(retval == 'Y')
			document.location.reload();		
}

function callSingleQ()
{  
	
	var refresh=document.forms[0].rfresh_param.value;
	var access_rule=parent.frames[0].document.forms[0].access_rule.value;
    var oper_stn=parent.frames[0].document.forms[0].Qoperstat.value;
	var action_on_pending_bill=parent.frames[0].document.forms[0].action_on_pending_bill.value;
	var sdate = document.forms[0].sdate.value;
	var pat_id_length = document.forms[0].pat_id_length.value;
	var bl_package_enabled_yn = document.forms[0].bl_package_enabled_yn.value;
	
	parent.parent.frames[1].location.href="../../eOP/jsp/ManageMPatQueueQuery.jsp?&refresh="+refresh+"&access_rule="+access_rule+"&oprstn="+oper_stn+"&sdate="+sdate+"&pat_id_length="+pat_id_length+"&bl_package_enabled_yn="+bl_package_enabled_yn+"&action_on_pending_bill="+action_on_pending_bill;            
}

function checkvalues(objname2)
{		
	if(objname2.value!="")
	{
		if(objname2.value == "Qvisittype")
			manage_patient.Qvisittype.value='Y'
	    else
	    	manage_patient.Qvisittype.value='N'
		
		if(objname2.value == "include_prev_visits")
			manage_patient.include_prev_visits.value='Y'
		else
			manage_patient.include_prev_visits.value='N'
		if(objname2.value == "Qcpat")
			manage_patient.Qcpat.value='Y'
		else
			manage_patient.Qcpat.value='N'
	}
	else
	{
		manage_patient.Qvisittype.value='N'
		manage_patient.include_prev_visits.value='N'
		manage_patient.Qcpat.value='N'
	}	
}        


function func1()
{

}
	
	/*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
function refresh_records()
{    
 	var Vitalsign=parent.frame1.document.forms[0].Vitalsign.value;
	var ChkOut=parent.frame1.document.forms[0].ChkOut.value;
	var que =parent.frame1.document.forms[0].Que.value;
	var refresh=parent.frame1.document.forms[0].rfresh_param.value;
	var sdate=parent.frame1.document.forms[0].sdate.value;
	var function_id=parent.frame1.document.forms[0].function_id.value;
	var action_on_pending_bill=parent.frame1.document.forms[0].action_on_pending_bill.value;
	if(parent.searchbutton.document.forms[0].refresh.value==getLabel("Common.search.label","Common")){  
		parent.searchbutton.document.forms[0].refresh.value=getLabel("eMR.Expand.label","eMR");
		//5.1%,2.5%,40%,1.5%
		//5.1%,3%,40%,1.5%
		//10%,3%,95%,3%
		//parent.ManagePatQueueFrame.rows="5.1%,3%,40%,1.5%";
		parent.document.getElementById("frame1").style.height="18.5vh";
		parent.document.getElementById("searchbutton").style.height="4vh";
		parent.document.getElementById("frame2").style.height="65vh";
		parent.document.getElementById("checkbox").style.height="5vh";
		parent.frame2.location.href="../../eOP/jsp/ManageSPatResult.jsp?Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&refresh="+refresh+"sdate="+sdate+"&action_on_pending_bill="+action_on_pending_bill; 
	} 
	else
	{ 
		parent.searchbutton.document.forms[0].refresh.value=getLabel("Common.search.label","Common");
		//parent.ManagePatQueueFrame.rows="29%,5%,80%,3%";
		parent.document.getElementById("frame1").style.height="38vh";
		if (ChkOut == "ChkOut")
		{
			parent.document.getElementById("frame1").style.height="34vh";
		}		
		parent.document.getElementById("searchbutton").style.height="4vh";
		parent.document.getElementById("frame2").style.height="45vh";
		parent.document.getElementById("checkbox").style.height="5vh";
		/*This code was commmented by  Venkatesh.S 13-Feb-2013  against 37911 */
	 
		//parent.frame2.location.href="../../eOP/jsp/ManageSPatResult.jsp?Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&refresh="+refresh+"&sdate="+sdate; 
	} 
	/*end Bru-HIMS-CRF-179 [IN030297] */	
	
}

function callFr()
        {
			var Vitalsign=document.forms[0].Vitalsign.value;
			var ChkOut=document.forms[0].ChkOut.value;
			var que =document.forms[0].Que.value;
			var refresh=document.forms[0].rfresh_param.value;
			parent.frames[1].location.href=" ../../eOP/jsp/ManageSPatResult.jsp?Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&refresh="+refresh;
            parent.frames[2].location.href="../../eOP/jsp/CheckBoxDisplay.jsp";
        }
 /*function chgbuttonclr()
        {
            document.getElementById("re_fresh").style.background="navy" ;
            document.getElementById("re_fresh").style.color="white" ;
            document.getElementById("re_fresh").style.fontWeight="700" ;
            document.getElementById("re_fresh").style.borderStyle="solid" ;
        }*/


function callGetPractitioner(obj,target)
		{
			
			var facility_id = document.forms[0].facility_id.value;
			var loginuser   = document.forms[0].loginuser.value;
            var locale=document.forms[0].locale.value; 

			/*
			if(target_name==null)
				target_name=document.forms[0].pract_name;

			if(target_name.value==null)
				target_name.value="";

			if(target_id==null)
				target_id=document.forms[0].Qpr;

			var speciality="";

			target_name.value=trimString(target_name.value);
			
			if(target_name.value == "" && window.event.target == target_name)
			{
				target_id.value = "";
				return;
			}
			
			var practitionerName=target_name.name;
			var practitionerValue=target_name.value;
			*/

			target.value=trimString(target.value);
			if(target.value=="" && window.event.target == target)
			{
				document.forms[0].Qpr.value="";
				return;
			}
			
			if(document.forms[0].Qspeciality && document.forms[0].Qspeciality.value!=null)
				speciality=document.forms[0].Qspeciality.value;     
			
			getPractitioner(obj,target,facility_id,speciality,'','','','','','',"Q2");
							
					
			//	sql  ="SELECT  DISTINCT a.practitioner_id practitioner_id,a.practitioner_name    practitioner_name,am_get_desc.am_practitioner(a.pract_type,'"+facility_id+"',1) practitioner_type, a.position_code job_title , DECODE(a.gender,'M','Male','F','Female','Unknown') gender  ,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty FROM  am_practitioner_lang_vw a  , op_patient_queue_vw d WHERE d.facility_id='"+facility_id+"' AND language_id='"+locale+"'  AND d.queue_status <'07'   AND   (    d.locn_type,d.locn_code  ) IN (  SELECT    locn_type ,locn_code   FROM    am_locn_for_oper_stn   WHERE facility_id='"+facility_id+"'    AND oper_stn_id = '"+oper_station_id+"' )  AND a.practitioner_id IS  NOT NULL   AND a.practitioner_id=d.practitioner_id   AND d.speciality_code=a.primary_speciality_code    AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(?)   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))   and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))  )   AND UPPER(a.gender) LIKE UPPER(NVL(?,a.gender))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123')))";
			 
			// var sqlSecond="SELECT  DISTINCT a.practitioner_id practitioner_id ,a.practitioner_name   practitioner_name,am_get_desc.am_practitioner(a.pract_type,'"+facility_id+"',1) practitioner_type , a.position_code job_title  ,DECODE(a.gender,'M','Male','F','Female','Unknown') gender  ,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty FROM  am_practitioner_lang_vw a  , op_patient_queue_vw d WHERE d.facility_id='"+facility_id+"' AND language_id='"+locale+"'  AND d.queue_status <'07'   AND   (    d.locn_type,d.locn_code  ) IN (  SELECT    locn_type ,locn_code   FROM    am_locn_for_oper_stn   WHERE facility_id='"+facility_id+"'    AND oper_stn_id = '"+oper_station_id+"' )  AND a.practitioner_id IS  NOT NULL   AND a.practitioner_id=d.practitioner_id   AND d.speciality_code=a.primary_speciality_code    AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(?)   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))   OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))  )   AND UPPER(a.gender) LIKE UPPER(NVL(?,a.gender))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123')))";
   
	
			/*	if(check_out == "ChkOut")
				{
                    sql += " and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facility_id+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and checkout_pat_yn = 'N')" ;

					sqlSecond+=" and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facility_id+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and checkout_pat_yn = 'N')" ;
				}
                else
				{
                    sql += " and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facility_id+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and manage_queue_yn = 'N')" ;

					sqlSecond+=" and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facility_id+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and checkout_pat_yn = 'N')" ;
				}*/
			
				/*
				sql="";
				sqlSecond="";
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + practitionerName + "\"";
				xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";				

				xmlStr += " sql=\"" +escape(sql)+"\"";
				xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";

				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + speciality + "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";

				xmlStr +=" /></root>" ;
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
				*/
		}
	function PractLookupRetVal(retVal,objName)
		{
			var arr;

			if (retVal != null)
			{
				arr=retVal.split("~");		
				
				document.forms[0].Qpr.value=arr[0];
				document.forms[0].pract_name.value=arr[1];		
			}
			else
			{		
				document.forms[0].Qpr.value="";
				document.forms[0].pract_name.value="";					
			}
		}

   function CheckNumberEntry(obj)
		{
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
			{		
			//	refresh_records();
			}
			else
			{
				if ( obj.value.length > 0 ) 
				{
					alert(getMessage("NUM_ALLOWED","SM"));
					obj.select();
					obj.focus();
					return false;
				}
			}
		}

	function dateLength(dt)
		{
		var splitValArray=new Array(2);
		splitValArray=obj.value.split(":");
		var DTlen = splitValArray[1].length

		if(DTlen > 2)
			return false;
		else
			return true;
		}
function validateTIme(obj)
{
	
	if(obj.value != "")
	{
		if(validDate(obj.value,"HM",localeName) == false)
		{
			alert(getMessage("INVALID_TIME_FMT","SM"));
			//obj.select();
			obj.value="";
		}
		else 
			return true;
	}
}

/*function CheckTime(obj) 
{
	var pass = "True";
		
	if(obj.value != "")
	{
		if(!chkTime(obj.value))
		{
			alert(getMessage("INVALID_TIME_FMT","SM"));
			obj.select();
			obj.focus();
		}
		if(chkTime(obj.value))
		{
			var splitValArray=new Array(2);
			splitValArray=obj.value.split(":");
			var DTlen = splitValArray[1].length

			if(DTlen > 2)
			{
				alert(getMessage("INVALID_TIME_FMT","SM"));
				obj.select();
				obj.focus();
			}
		}
	}
 }*/
//js function used in ManageSPat queue Result.jsp

/*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
function clearfields()
{
	//parent.ManagePatQueueFrame.rows="35.5%,5%,90%,2%";
	var ChkOut=parent.frame1.document.forms[0].ChkOut.value;
	parent.document.getElementById("frame1").style.height="38vh";
	if (ChkOut == "ChkOut")
	{
		parent.document.getElementById("frame1").style.height="34vh";
	}	
	//parent.document.getElementById("frame1").style.height="38vh";
	parent.document.getElementById("searchbutton").style.height="4vh";
	parent.document.getElementById("frame2").style.height="45vh";
	parent.document.getElementById("checkbox").style.height="5vh";
	parent.frame1.document.location.reload();
	parent.searchbutton.document.location.reload();
	parent.frame2.location.href="../../eCommon/html/blank.html"
	parent.checkbox.location.href="../../eCommon/html/blank.html"
}
/*end Bru-HIMS-CRF-179 [IN030297] */

function initQueue()
{
			  
  	var rfresh_param	= parent.frames[0].document.forms[0].rfresh_param.value;
  	var function_id	= parent.frames[0].document.forms[0].function_id.value;
			
	var Vitalsign=parent.frames[0].document.forms[0].Vitalsign.value;
	var ChkOut=parent.frames[0].document.forms[0].ChkOut.value;
	var que =parent.frames[0].document.forms[0].Que.value;

	var p_loc_id 		= parent.frames[0].document.forms[0].Qloc.value;
	var p_loc_type		= parent.frames[0].document.forms[0].Qloctype.value
	var p_pract_id 		= parent.frames[0].document.forms[0].Qpr.value;

	var p_vis_type		= parent.frames[0].document.forms[0].Qvisittype.value;
	if (p_vis_type==null) p_vis_type ="N";

	var p_inc_check_out	= parent.frames[0].document.forms[0].Qcpat.value;
	if (p_inc_check_out==null) p_inc_check_out ="N";

	var p_enc_id		= parent.frames[0].document.forms[0].Qencid.value;
	var p_queue_no		= parent.frames[0].document.forms[0].Qno.value;
	
	var p_patient_id	= parent.frames[0].document.forms[0].Qpatientid.value;
	var p_gender		= parent.frames[0].document.forms[0].Qgender.value;

	var p_inc_prev_visits	= parent.frames[0].document.forms[0].include_prev_visits.value;			
	if (p_inc_prev_visits==null) p_inc_prev_visits ="N";
	
	var p_appt_status	= parent.frames[0].document.forms[0].Qapptstatus.value;
	var p_start_time	= parent.frames[0].document.forms[0].Qstarttime.value;
	var p_operator_station	= parent.frames[0].document.forms[0].Qoperstat.value;
	var p_emergency	= parent.frames[0].document.forms[0].emergency_patients.value;
	var p_speciality_code=parent.frames[0].document.forms[0].Qspeciality.value;
	var bl_install_yn=parent.frames[0].document.forms[0].bl_install_yn.value;
	var bl_package_enabled_yn = parent.frames[0].document.forms[0].bl_package_enabled_yn.value;
	var sdate = parent.frames[0].document.forms[0].sdate.value;
	
	//Added by Ajay Hatwate for ML-MMOH-CRF-1930
	var virtualConsVisit="N";
	if(parent.frames[0].document.forms[0].isVirtualCons.value == "true"){
		if(parent.frames[0].document.forms[0].VirtualConsultVisit){
			if(parent.frames[0].document.forms[0].VirtualConsultVisit.checked){
				 virtualConsVisit = "Y";
			}else{
			 virtualConsVisit = "N";	
			}
		}
	}
	/*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
	parent.checkbox.location.href="../../eOP/jsp/CheckBoxDisplay.jsp"
	/*end Bru-HIMS-CRF-179 [IN030297] */
	var mins1_for_wait_time = parent.parent.document.getElementById("mins1_for_wait_time").value;
	var mins2_for_wait_time = parent.parent.document.getElementById("mins2_for_wait_time").value;
	var action_on_pending_bill=parent.frames[0].document.forms[0].action_on_pending_bill.value;// Added For MMS-QH-CRF-0126 [IN:041880]

	//Modified by Ajay Hatwate for ML-MMOH-CRF-1930
	if(function_id != "SEARCH_FOR_VITAL_SIGN"){ 
		if(parent.parent.document.getElementById("open_search_reqd_yn").value == "Y"){ 
			var jspVal = "<html><body onKeyDown='lockKey();'><form name='patientqueue' id='patientqueue' method='post' action='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?function_id="+function_id+"&Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&action_on_pending_bill="+action_on_pending_bill+" '><input type='hidden' name='emergency_patients_only' id='emergency_patients_only' value='"+p_emergency+"'><input type='hidden' name='locid' id='locid' value='"+p_loc_id+"'><input type='hidden' name='loctype' id='loctype' value='"+p_loc_type+"'> <input type='hidden' name='pract_id' id='pract_id' value='"+p_pract_id+"'> <input type='hidden' name='vistype' id='vistype' value='"+p_vis_type+"'><input type='hidden' name='speciality_code' id='speciality_code' value='"+p_speciality_code+"'> <input type='hidden' name='checkout' id='checkout' value='"+p_inc_check_out+"'>  <input type='hidden' name='queueno' id='queueno' value='"+p_queue_no+"'> <input type='hidden' name='patient_id' id='patient_id' value='"+p_patient_id+"'><input type='hidden' name='encid' id='encid' value='"+p_enc_id+"'> <input type='hidden' name='starttime' id='starttime' value='"+p_start_time+"'><input type='hidden' name='operator_station' id='operator_station' value='"+p_operator_station+"'><input type='hidden' name='gender' id='gender' value='"+p_gender+"'><input type='hidden' name='inc_prev_visits' id='inc_prev_visits' value='"+p_inc_prev_visits+"'><input type='hidden' name='appt_status' id='appt_status' value='"+p_appt_status+"'><input type='hidden' name='refresh' id='refresh' value='"+rfresh_param+"'><input type='hidden' name='sdate' id='sdate' value='"+sdate+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='package_bl_install_YN' id='package_bl_install_YN' value='"+bl_package_enabled_yn+"'><input type='hidden' name='mins1_for_wait_time' id='mins1_for_wait_time' value='"+mins1_for_wait_time+"'><input type='hidden' name='mins2_for_wait_time' id='mins2_for_wait_time' value='"+mins2_for_wait_time+"'> <input type='hidden' name='virtualConsultVisit' id='virtualConsultVisit' value='"+virtualConsVisit+"'> </form></body></html>";
	
	        /*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
			parent.frame2.document.body.insertAdjacentHTML('afterbegin',jspVal);
            parent.frame2.document.patientqueue.submit();
			 /*end Bru-HIMS-CRF-179 [IN030297] */
		}
		else
		{ 				
			if(p_speciality_code!=""||p_loc_id!="" || p_patient_id!=""||p_enc_id!="" || p_queue_no!=""){ 
				var jspVal = "<html><body onKeyDown='lockKey();'><form name='patientqueue' id='patientqueue' method='post' action='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?function_id="+function_id+"&Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&action_on_pending_bill="+action_on_pending_bill+" '><input type='hidden' name='emergency_patients_only' id='emergency_patients_only' value='"+p_emergency+"'><input type='hidden' name='locid' id='locid' value='"+p_loc_id+"'><input type='hidden' name='loctype' id='loctype' value='"+p_loc_type+"'> <input type='hidden' name='pract_id' id='pract_id' value='"+p_pract_id+"'> <input type='hidden' name='vistype' id='vistype' value='"+p_vis_type+"'><input type='hidden' name='speciality_code' id='speciality_code' value='"+p_speciality_code+"'> <input type='hidden' name='checkout' id='checkout' value='"+p_inc_check_out+"'>  <input type='hidden' name='queueno' id='queueno' value='"+p_queue_no+"'> <input type='hidden' name='patient_id' id='patient_id' value='"+p_patient_id+"'><input type='hidden' name='encid' id='encid' value='"+p_enc_id+"'> <input type='hidden' name='starttime' id='starttime' value='"+p_start_time+"'><input type='hidden' name='operator_station' id='operator_station' value='"+p_operator_station+"'><input type='hidden' name='gender' id='gender' value='"+p_gender+"'><input type='hidden' name='inc_prev_visits' id='inc_prev_visits' value='"+p_inc_prev_visits+"'><input type='hidden' name='appt_status' id='appt_status' value='"+p_appt_status+"'><input type='hidden' name='refresh' id='refresh' value='"+rfresh_param+"'><input type='hidden' name='sdate' id='sdate' value='"+sdate+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='package_bl_install_YN' id='package_bl_install_YN' value='"+bl_package_enabled_yn+"'><input type='hidden' name='mins1_for_wait_time' id='mins1_for_wait_time' value='"+mins1_for_wait_time+"'><input type='hidden' name='mins2_for_wait_time' id='mins2_for_wait_time' value='"+mins2_for_wait_time+"'><input type='hidden' name='virtualConsultVisit' id='virtualConsultVisit' value='"+virtualConsVisit+"'></form></body></html>";
		        /*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
				parent.frame2.document.body.insertAdjacentHTML('afterbegin',jspVal);
				parent.frame2.document.patientqueue.submit();
                /*end Bru-HIMS-CRF-179 [IN030297] */
			}
			else
			{ 
			   /*This code was added by  Venkatesh.S 13-Feb-2013  against 37911 */
			    parent.searchbutton.document.forms[0].refresh.value=parent.frames[1].getLabel("Common.search.label","Common");
			    //parent.ManagePatQueueFrame.rows='29%,5%,80%,6%';
				//parent.document.getElementById("frame1").style.height="38vh";
				parent.document.getElementById("frame1").style.height="38vh";
				if (ChkOut == "ChkOut")
				{
					parent.document.getElementById("frame1").style.height="34vh";
				}	
				parent.document.getElementById("searchbutton").style.height="4vh";
				parent.document.getElementById("frame2").style.height="50vh";
				parent.document.getElementById("checkbox").style.height="5vh";
				alert(parent.getMessage("SPEC_LOCN_PAT_ENC_QNO","OP"));	
						
				//return false;
			}
		}
	}
	else
	{
		if(p_speciality_code!=""||p_loc_id!="")
		{ 
			var jspVal = "<html><body onKeyDown='lockKey();'><form name='patientqueue' id='patientqueue' method='post' action='../../eOP/jsp/ManageSPatQueueQueryResult.jsp?function_id="+function_id+"&Vitalsign="+Vitalsign+"&ChkOut="+ChkOut+"&Que="+Que+"&action_on_pending_bill="+action_on_pending_bill+" '><input type='hidden' name='emergency_patients_only' id='emergency_patients_only' value='"+p_emergency+"'><input type='hidden' name='locid' id='locid' value='"+p_loc_id+"'><input type='hidden' name='loctype' id='loctype' value='"+p_loc_type+"'> <input type='hidden' name='pract_id' id='pract_id' value='"+p_pract_id+"'> <input type='hidden' name='vistype' id='vistype' value='"+p_vis_type+"'><input type='hidden' name='speciality_code' id='speciality_code' value='"+p_speciality_code+"'> <input type='hidden' name='checkout' id='checkout' value='"+p_inc_check_out+"'>  <input type='hidden' name='queueno' id='queueno' value='"+p_queue_no+"'> <input type='hidden' name='patient_id' id='patient_id' value='"+p_patient_id+"'><input type='hidden' name='encid' id='encid' value='"+p_enc_id+"'> <input type='hidden' name='starttime' id='starttime' value='"+p_start_time+"'><input type='hidden' name='operator_station' id='operator_station' value='"+p_operator_station+"'><input type='hidden' name='gender' id='gender' value='"+p_gender+"'><input type='hidden' name='inc_prev_visits' id='inc_prev_visits' value='"+p_inc_prev_visits+"'><input type='hidden' name='appt_status' id='appt_status' value='"+p_appt_status+"'><input type='hidden' name='refresh' id='refresh' value='"+rfresh_param+"'><input type='hidden' name='sdate' id='sdate' value='"+sdate+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'><input type='hidden' name='package_bl_install_YN' id='package_bl_install_YN' value='"+bl_package_enabled_yn+"'><input type='hidden' name='mins1_for_wait_time' id='mins1_for_wait_time' value='"+mins1_for_wait_time+"'><input type='hidden' name='mins2_for_wait_time' id='mins2_for_wait_time' value='"+mins2_for_wait_time+"'><input type='hidden' name='virtualConsultVisit' id='virtualConsultVisit' value='"+virtualConsVisit+"'></form></body></html>";
	       /*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
			parent.frame2.document.body.insertAdjacentHTML('afterbegin',jspVal);
            parent.frame2.document.patientqueue.submit();
            /*end Bru-HIMS-CRF-179 [IN030297] */
		}
		else
		{
			alert(parent.getMessage("SPEC_LOCN_MAND","OP"));			
			//return false;
		}

	}
}


function LoadChkOut(eid,p_queue_date,pat_id,locn_type,bl_install_yn,package_bl_install_YN,pkg_pat_yn,pkg_enc_yn,isPatientEncMovement,Sydate)
{//changed for package billing
			
			
			
			Qoperstat=parent.frames[0].document.forms[0].Qoperstat.value;

			/*if(document.ManagePatQue.pkg_pat_yn)
				pkg_pat_yn = document.ManagePatQue.pkg_pat_yn.value;
			if(document.ManagePatQue.pkg_enc_yn)
				pkg_enc_yn = document.ManagePatQue.pkg_enc_yn.value;*/  		
			h="ae_bed_calYN=N&p3="+eid+"&P_Queue_Date="+p_queue_date+"&p2="+pat_id+"&p4="+locn_type+"&oper_id="+Qoperstat+"&package_bl_install_YN="+package_bl_install_YN+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate;
			var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='packageCheck' id='packageCheck' method='post' action='../../eOP/jsp/OPPackageIntermediateValidations.jsp'>"; 			
			HTMLVal+="<input type='hidden' name='called_function' id='called_function' value='OPCHECKOUT'>";
			HTMLVal+="<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'>";
			HTMLVal+="<input type='hidden' name='package_bl_install_YN' id='package_bl_install_YN' value='"+package_bl_install_YN+"'>";
			HTMLVal+="<input type='hidden' name='encounter_id' id='encounter_id' value='"+eid+"'>";
			HTMLVal+="<input type='hidden' name='patient_id' id='patient_id' value='"+pat_id+"'>";
			HTMLVal+="<input type='hidden' name='pkg_pat_yn' id='pkg_pat_yn' value='"+pkg_pat_yn+"'>";
			HTMLVal+="<input type='hidden' name='pkg_enc_yn' id='pkg_enc_yn' value='"+pkg_enc_yn+"'>";
			HTMLVal+="<input type='hidden' name='parameters' id='parameters' value='"+h+"'>"; 		
			HTMLVal+= "</form></body></html>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.packageCheck.submit();
}
	

//new function to invoke vital sign record - begin
async function LoadVsign(eid,patient_class,patient_id,isPatientEncMovement,Sydate,p_queue_date)
{

		var retVal =    new String();
		var dialogHeight= "67vh" ;
		var dialogWidth = "55vw" ;
		var status = "no";
		var scroll = "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments   = "" ;         
		var visit_id = "1";
		/*Below line modified for this CRF Bru-HIMS-CRF-133*/		
		var eidval ="episode_id="+eid+"&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&module_id=OP"; 
	
		retVal = await window.showModalDialog("../../eCA/jsp/DisDataCharting.jsp?"+eidval,arguments,features);
		setTimeout('callSamepage()',100)
 }

//new function to invoke vital sign record - begin
async function callSamepage()
{ 
     
	if(parent.frames[0].document.forms[0].multiple[1].checked){	//Condition added by suresh M on 10-04-2012 for IN032240 incident
		/*Below line modified by Venkatesh.S on 04/FEB/2013 against Bru-HIMS-CRF-179 [IN030297] */
		if(parent.frame2.document.ManagePatQue.modalWindowOpen){
			if(parent.frame2.document.ManagePatQue.modalWindowOpen.value=="N"){ 
				/*Below line added by Venkatesh.S on 18/FEB/2013 against [IN037940] */
				if(parent.searchbutton.document.forms[0].refresh.value==getLabel("eMR.Expand.label","eMR")){
					await initQueue();
					//parent.ManagePatQueueFrame.rows="5.1%,3%,40%,1.5%";
					parent.document.getElementById("frame1").style.height="18.5vh";
					parent.document.getElementById("searchbutton").style.height="4vh";
					parent.document.getElementById("frame2").style.height="65vh";
					parent.document.getElementById("checkbox").style.height="5vh";							   
					parent.searchbutton.document.forms[0].refresh.value=getLabel("eMR.Expand.label","eMR"); 
				}
				if(parent.searchbutton.document.forms[0].refresh.value==getLabel("Common.search.label","Common")){
					parent.frames[1].document.forms[0].refresh.click();
					//parent.ManagePatQueueFrame.rows="29%,5%,80%,3%";
					//parent.document.getElementById("frame1").style.height="38vh";
					var ChkOut=parent.frame1.document.forms[0].ChkOut.value;
					parent.document.getElementById("frame1").style.height="38vh";
					if (ChkOut == "ChkOut")
					{
						parent.document.getElementById("frame1").style.height="34vh";
					}	
					parent.document.getElementById("searchbutton").style.height="4vh";
					parent.document.getElementById("frame2").style.height="45vh";
					parent.document.getElementById("checkbox").style.height="5vh";	
					parent.searchbutton.document.forms[0].refresh.value=getLabel("Common.search.label","Common");
				}
				 /*end [IN037940] */
			}
			else
			{ 
			}
		}
		else
		{
			parent.frames[1].document.forms[0].refresh.click(); 
		}
	}
	else
	{ 
		//parent.frames[1].document.forms[0].refresh.click(); 
		parent.frames[0].document.forms[0].refresh.click(); //this line modified for this incident [38281] 
	}			
}

async function viewpatmovementdetails(encid)
{
	var dialogHeight= "67vh" ;
	var dialogWidth = "55vw" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;         
	retVal = await window.showModalDialog("../../eOP/jsp/ViewPatMovementFrames.jsp?encounter_id="+encid,arguments,features);

}

/*** Added from here ***/
/* Below method modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
/*Below line modified for this CRF Bru-HIMS-CRF-133 */
function displayToolTip(eid, patient_id, visit_adm_type, locn_code, curr_loc_type, pract_id, p_queue_status, p_patient_class, CARE_LOCN_TYPE_IND, sex, DATE_OF_BIRTH, room_num, p_status, dt, appt_id, p_queue_date, arrival_date, curr_locn, curr_locn_type_desc, VISIT_ADM_TYPE_IND, appt_case_yn, VITAL_SIGNS_DATE_TIME, ARRIVE_DATE_TIME, multiflag, other_res_class, other_res_code, queue_num, appt_walk_ind, queue_id, callfrom, pkg_pat_yn, pkg_enc_yn, obj, imgObj, row, link, episode_id, op_episode_visit_num, curr_locntype, curr_locncode, isPatientEncMovement, Sydate, pat_name) {
    document.getElementById("t").innerHTML = "";

    // Handle previous tooltip
    if (prevObjID != null && prevObjID != obj.id) {
        document.getElementById(prevlink).style.color = "blue";
        document.getElementById(prevObjID).className = prevClassName;
        document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";
    }

    // Set previous class based on row number
    prevClassName = (row % 2 === 1) ? 'QRYODD' : 'QRYEVEN';
    prevlink = link;
    obj.className = 'selectedTDData';
    document.getElementById(link).style.color = "white";
    document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
    prevObjID = obj.id;
    prevImgObj = imgObj;

    buildTable(eid, patient_id, visit_adm_type, locn_code, curr_loc_type, pract_id, p_queue_status, p_patient_class, CARE_LOCN_TYPE_IND, sex, DATE_OF_BIRTH, room_num, p_status, dt, appt_id, p_queue_date, arrival_date, curr_locn, curr_locn_type_desc, VISIT_ADM_TYPE_IND, appt_case_yn, VITAL_SIGNS_DATE_TIME, ARRIVE_DATE_TIME, multiflag, other_res_class, other_res_code, queue_num, appt_walk_ind, queue_id, callfrom, pkg_pat_yn, pkg_enc_yn, obj, episode_id, op_episode_visit_num, curr_locntype, curr_locncode, isPatientEncMovement, Sydate);

    var tooltip = document.getElementById("tooltiplayer");
    tooltip.style.position = 'absolute';
    tooltip.style.backgroundColor = '#D3D3D3';
    tooltip.style.color = 'black';
    tooltip.style.border = '1px solid #ccc';
    tooltip.style.padding = '5px';
    tooltip.style.boxShadow = '0px 0px 5px rgba(0, 0, 0, 0.2)';
    tooltip.style.zIndex = '1000';
    tooltip.style.visibility = 'hidden';

    var tooltipWidth = tooltip.offsetWidth;
    var tooltipHeight = tooltip.offsetHeight;

    // Get mouse position
    var mouseX = event.clientX + window.scrollX;
    var mouseY = event.clientY + window.scrollY;

    // Define offsets
    var offsetX = 10;
    var offsetY = 15;

    // Calculate initial position
    var tooltipX = mouseX + offsetX;
    var tooltipY = mouseY + offsetY;

    // Get viewport dimensions
    var viewportWidth = window.innerWidth + window.scrollX;
    var viewportHeight = window.innerHeight + window.scrollY;

    // Adjust tooltip position to prevent overflow
    if (tooltipX + tooltipWidth > viewportWidth) {
        tooltipX = mouseX - tooltipWidth - offsetX;
    }

    if (tooltipY + tooltipHeight > viewportHeight) {
        tooltipY = mouseY - tooltipHeight - offsetY;

        // Ensure tooltip still fits within the viewport horizontally
        if (tooltipX + tooltipWidth > viewportWidth) {
            tooltipX = mouseX - tooltipWidth - offsetX;
        }
    }

    // Set the tooltip's position and make it visible
    tooltip.style.left = tooltipX + 'px';
    tooltip.style.top = tooltipY + 'px';
    tooltip.style.visibility = 'visible';
}


/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
	function getPos(inputElement) {
	
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
	
		if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else { 
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
              //  alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}
/*Below line modified for this CRF Bru-HIMS-CRF-133*/
function buildTable(eid,patient_id,visit_adm_type,locn_code,curr_loc_type,pract_id,p_queue_status,p_patient_class,CARE_LOCN_TYPE_IND,sex,DATE_OF_BIRTH,room_num,p_status,dt,appt_id,p_queue_date,arrival_date,curr_locn,curr_locn_type_desc,VISIT_ADM_TYPE_IND,appt_case_yn,VITAL_SIGNS_DATE_TIME,ARRIVE_DATE_TIME,multiflag,other_res_class,other_res_code,queue_num,appt_walk_ind,queue_id,callfrom,pkg_pat_yn,pkg_enc_yn,obj,episode_id,op_episode_visit_num,curr_locntype,curr_locncode,isPatientEncMovement,Sydate)
{				 
			var calling_module = "";

			var OsVal_chkout = "";
			var allergy_yn = "";
			var caInsYn = "N"; 			
			
			var isQMSapplicable="false"
			
			if(document.forms[0].call_from)			
				calling_module = document.forms[0].call_from.value;				
			if(parent.parent.document.getElementById("OsVal_chkout"))
				OsVal_chkout = parent.parent.document.getElementById("OsVal_chkout").value 
			if(parent.parent.document.getElementById("allergy_yn"))
				allergy_yn = parent.parent.document.getElementById("allergy_yn").value;
			if(parent.parent.document.getElementById("caInsYn"))
				caInsYn = parent.parent.document.getElementById("caInsYn").value;
	
			 //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
			if(parent.parent.document.getElementById("isQMSapplicable"))
				isQMSapplicable = parent.parent.document.getElementById("isQMSapplicable").value ;
			//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->		 
			
		/*if(document.ManagePatQue.pkg_pat_yn)
				pkg_pat_yn = document.ManagePatQue.pkg_pat_yn.value;
			if(document.ManagePatQue.pkg_enc_yn)
				pkg_enc_yn = document.ManagePatQue.pkg_enc_yn.value; */
			
			/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
			 var HTMLVal = "<HTML><BODY onKeyDown='lockKey();'><form name='menu_form' id='menu_form' method='post' action='../../eOP/jsp/ManageQueuePopupMenu.jsp'><input type='hidden' name='Encounter_Id' id='Encounter_Id' value='"+eid+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+visit_adm_type+"'><input type='hidden' name='visit_adm_type' id='visit_adm_type' value='"+visit_adm_type+"'><input type='hidden' name='locn_code' id='locn_code' value='"+locn_code+"'><input type='hidden' name='curr_loc_type' id='curr_loc_type' value='"+curr_loc_type+"'><input type='hidden' name='pract_id' id='pract_id'  value='"+pract_id+"'><input type='hidden' name='p_queue_status' id='p_queue_status' value='"+p_queue_status+"'><input type='hidden' name='p_patient_class' id='p_patient_class' value='"+p_patient_class+"'><input type='hidden' name='CARE_LOCN_TYPE_IND' id='CARE_LOCN_TYPE_IND' value='"+CARE_LOCN_TYPE_IND+"'><input type='hidden' name='sex' id='sex' value='"+sex+"'><input type='hidden' name='DATE_OF_BIRTH' id='DATE_OF_BIRTH' value='"+escape(DATE_OF_BIRTH)+"'><input type='hidden' name='room_num' id='room_num' value='"+room_num+"'><input type='hidden' name='p_status' id='p_status' value='"+p_status+"'><input type='hidden' name='dt' id='dt' value='"+dt+"'><input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'><input type='hidden' name='p_queue_date' id='p_queue_date' value='"+escape(p_queue_date)+"'><input type='hidden' name='arrival_date' id='arrival_date' value='"+escape(arrival_date)+"'><input type='hidden' name='curr_locn' id='curr_locn' value='"+curr_locn+"'><input type='hidden' name='curr_locn_type_desc' id='curr_locn_type_desc' value='"+curr_locn_type_desc+"'><input type='hidden' name='VISIT_ADM_TYPE_IND' id='VISIT_ADM_TYPE_IND' value='"+VISIT_ADM_TYPE_IND+"'><input type='hidden' name='appt_case_yn' id='appt_case_yn' value='"+appt_case_yn+"'><input type='hidden' name='ARRIVE_DATE_TIME' id='ARRIVE_DATE_TIME' value='"+ARRIVE_DATE_TIME+"'><input type='hidden' name='VITAL_SIGNS_DATE_TIME' id='VITAL_SIGNS_DATE_TIME' value='"+VITAL_SIGNS_DATE_TIME+"'><input type='hidden' name='other_res_class' id='other_res_class' value='"+other_res_class+"'><input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'><input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'><input type='hidden' name='appt_walk_ind' id='appt_walk_ind' value='"+appt_walk_ind+"'><input type='hidden' name='queue_id' id='queue_id' value='"+queue_id+"'><input type='hidden' name='callfrom' id='callfrom' value='"+callfrom+"'><input type='hidden' name='calling_module' id='calling_module' value='"+calling_module+"'><input type='hidden' name='OsVal_chkout' id='OsVal_chkout' value='"+OsVal_chkout+"'><input type='hidden' name='allergy_yn' id='allergy_yn' value='"+allergy_yn+"'><input type='hidden' name='caInsYn' id='caInsYn' value='"+caInsYn+"'><input type='hidden' name='pkg_pat_yn' id='pkg_pat_yn' value='"+pkg_pat_yn+"'><input type='hidden' name='pkg_enc_yn' id='pkg_enc_yn' value='"+pkg_enc_yn+"'><input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'><input type='hidden' name='op_episode_visit_num' id='op_episode_visit_num' value='"+op_episode_visit_num+"'><input type='hidden' name='curr_locntype' id='curr_locntype' value='"+curr_locntype+"'><input type='hidden' name='curr_locncode' id='curr_locncode' value='"+curr_locncode+"'><input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='"+isPatientEncMovement+"'><input type='hidden' name='Sydate' id='Sydate' value='"+Sydate+"'><input type='hidden' name='isQMSapplicable' id='isQMSapplicable' value='"+isQMSapplicable+"'></form></BODY></HTML>";
             
			 parent.parent.messageFrame.document.write(HTMLVal);
			 parent.parent.messageFrame.menu_form.submit();
}

function callMouseOver(obj)
{
	currClass = obj.className ;
	/* Below line modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
    obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj)
{
	obj.className = currClass; 
}

/* Below method modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
function hideToolTip(obj,imgObj,row,link) 
{      
   
 dynamicChange( obj,window.event,row)
}
/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
function dynamicChange(m,e,row)
   {     
      if (!this.isContained(m, e))
		{ 
			this.delayhidemenu(row)
		}
   }
/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
function isContained(m, e)
	{ 
            
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
	}
/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/		
function delayhidemenu(row)
	{
          
		   
		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) 
		 if(eval(document.getElementById("patname"+row)))
			if(eval(document.getElementById("patname"+row)).className=='selectedTDData')
			{ 
			 eval(document.getElementById("imgArrow"+row)).src = "../../eCommon/images/activeArrow.gif";
			}
		 if(eval(document.getElementById("imgArrow"+row)) && eval(document.getElementById("patname"+row)).className !='selectedTDData' ) 
			eval(document.getElementById("imgArrow"+row)).src = "../../eCommon/images/inactiveArrow.gif";
			
			
	}
	
/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/	
function hidemenu()
	{ 
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}

function callDummy()
  {
  }
/*Below line modified for this CRF -BRU-HIMS-CRF-133*/
async function CallFunction(p_queue_status,patient_id,EncounterId,assign_care_locn_type,assign_care_locn_code,attend_practitioner_id,visit_adm_type,sex,dob,mode,previousday,p_patient_class,curr_locn1,arrival_date,p_status,dt,appt_id,p_queue_date,room_num,curr_locn,curr_locn_type_desc,VISIT_ADM_TYPE_IND,appt_case_yn,ARRIVE_DATE_TIME,VITAL_SIGNS_DATE_TIME,other_res_class,other_res_code,queue_num,appt_walk_ind,queue_id,val,callfrom,pkg_pat_yn,pkg_enc_yn,episode_id,op_episode_visit_num,curr_locntype,curr_locncode,isPatientEncMovement,Sydate,logged_in_user)
{
	curr_locn=unescape(curr_locn);
	curr_locn_type_desc=unescape(curr_locn_type_desc);
	
	
	p_status=unescape(p_status);
	//Qoperstat=parent.frames[0].document.forms[0].oper_stn.value;
	
	Qoperstat=parent.frames[0].document.forms[0].Qoperstat.value;

	var assign_queue_num_by = "";

	if(parent.parent.document.getElementById("assign_queue_num_by"))
		assign_queue_num_by = parent.parent.document.getElementById("assign_queue_num_by").value;	

	/*if(document.ManagePatQue.pkg_pat_yn)
		pkg_pat_yn = document.ManagePatQue.pkg_pat_yn.value;
	if(document.ManagePatQue.pkg_enc_yn)
		pkg_enc_yn = document.ManagePatQue.pkg_enc_yn.value;	*/
	/*below line modified for this CRF Bru-HIMS-CRF-133*/	
	
	var parameters = "?ae_bed_calYN=N&p1="+p_queue_status+"&p2="+patient_id+"&p3="+EncounterId+"&p4="+assign_care_locn_type+"&p5="+assign_care_locn_code+"&p6="+attend_practitioner_id+"&p7="+visit_adm_type+"&p8="+sex+"&p9="+unescape(dob)+"&p10="+mode+"&p11="+previousday+"&p12="+p_patient_class+"&p13="+assign_care_locn_type+"&p14="+unescape(arrival_date)+"&p15="+encodeURIComponent(p_status)+"&p16="+dt+"&p17="+appt_id+"&p18="+unescape(p_queue_date)+"&p19="+room_num+"&p20="+encodeURIComponent(curr_locn)+"&p21="+encodeURIComponent(curr_locn_type_desc)+"&p22="+VISIT_ADM_TYPE_IND+"&p23="+appt_case_yn+"&p24="+unescape(ARRIVE_DATE_TIME)+"&p25="+VITAL_SIGNS_DATE_TIME+"&p26="+other_res_class+"&p27="+other_res_code+"&p28="+queue_num+"&p29="+appt_walk_ind+"&p30="+queue_id+"&p31="+assign_queue_num_by+"&oper_id="+Qoperstat+"&curr_locntype="+curr_locntype+"&curr_locncode="+curr_locncode+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate;

	//modified by dharma for MMS-QH-CRF-0126 [IN:041880] start
	
	if(val=="Start" || val=="Arrived"){
        var action_on_pending_bill	= $("#action_on_pending_bill").val();
      
        if(action_on_pending_bill=="" || action_on_pending_bill== null){
        	action_on_pending_bill	= "N";
        }
        
        var bl_install_yn		= $("#bl_install_yn").val();
        var facility_id			= $("#facility_id").val();
	}
	
	if(val=="Arrived")
    {
        var dialogHeight= "70vh" ;
        var dialogWidth = "85vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
        if(bl_install_yn=='N' || action_on_pending_bill=="N"){
			var retVal = await top.window.showModalDialog("../../eOP/jsp/CallPatArrival.jsp"+parameters,arguments,features);
	        if (retVal=="ok")
	        {
	            //window.close();    
				parent.parent.document.getElementById("dialog_tag").close();   
	        }
        }else{
        	await FnCheckOPQBLValidation("../../eOP/jsp/CallPatArrival.jsp",parameters,arguments,features,patient_id,action_on_pending_bill,facility_id,episode_id,op_episode_visit_num,"Arrived");
        }
    }	
		
    if(val=="Start")  {
   
        var dialogHeight= "70vh" ;
        var dialogWidth = "85vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
    	if(bl_install_yn=='N' || action_on_pending_bill=="N"){
    		var retVal = await top.window.showModalDialog("../../eOP/jsp/CallConsStart.jsp"+parameters+"&test=test",arguments,features);
        }else{
        	parameters	= parameters + "&test=test";
        	await FnCheckOPQBLValidation("../../eOP/jsp/CallConsStart.jsp",parameters,arguments,features,patient_id,action_on_pending_bill,facility_id,episode_id,op_episode_visit_num,"Start");
        }
    }
        
	//modified by dharma for MMS-QH-CRF-0126 [IN:041880] end
	
/*  if(val=="Departed")
	{
	    var dialogHeight= "18" ;
	    var dialogWidth = "50" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
	    var arguments   = "" ;
	
	    var retVal = window.showModalDialog("../../eOP/jsp/ConsPatDeparted.jsp"+parameters,arguments,features);
	}*/

	if(val=="Allergy")
	{
	
		var retVal =    new String();
		var dialogHeight= "85vh";
		var dialogWidth = "95vw" ;
		var status = "no";
		var scroll = "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments   = "" ;   			
		var visit_id = "1";
		/*below line modified for this CRF Bru-HIMS-CRF-133*/
		//var title = getLabel('Common.RecordAllergy.label','Common');
		var title = getLabel('Common.AllergyDetails.label','Common');
		var eidval ="encounter_id="+EncounterId+"&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+p_patient_class+"&title="+title+"&location_type="+assign_care_locn_type+"&location_code="+assign_care_locn_code+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&p_queue_status="+p_queue_status;
		retVal = await top.window.showModalDialog("../../eMR/jsp/RecordPatientAdverseEvent2.jsp?"+eidval,arguments,features);
		//parent.parent.document.getElementById("dialog_tag").close();  
		if (retVal=="ok")
        {
            //window.close();    
			parent.parent.document.getElementById("dialog_tag").close();   
        }
		
	} 
		
	if(val=="Record")
    {

		var retVal =    new String();
		var dialogHeight= "70vh" ;
		var dialogWidth = "85vw" ;
		var status = "no";
		var scroll = "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments   = "" ;         
		/*Below line modified for this CRF Bru-HIMS-CRF-133*/
		
		var visit_id = "1";
		var eidval ="episode_id="+EncounterId+"&called_from=OP&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+p_patient_class+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate+"&p_queue_date="+p_queue_date+"&module_id=OP";  
		retVal = await top.window.showModalDialog("../../eCA/jsp/DisDataCharting.jsp?"+eidval,arguments,features);
    }
    if(val=="Patient")
    {
    //Added by Ajay Hatwate for MMS-DM-CRF-0210.1
        xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" logged_user=\""+logged_in_user+"\" action='isPractRestricted' /></root>"
		 var temp_jsp="../../eMP/jsp/MPIntermediate.jsp";
		 var xmlDoc = "" ;
		 var xmlHttp = new XMLHttpRequest() ;
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		 xmlHttp.open("POST",temp_jsp,false);
		 xmlHttp.send(xmlDoc);
		 var responseText = xmlHttp.responseText;
		 var response = trimString(xmlHttp.responseText);	
	    /*Below line modified for this CRF Bru-HIMS-CRF-133*/
    	if(response == "N"){
		var HTMLVal  = "<html>";
		HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
		HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + EncounterId + "'>";
		HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
		HTMLVal  += "<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='OP'>";
		HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
		HTMLVal  += "<input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='"+isPatientEncMovement+"'>";
		HTMLVal  += "<input type='hidden' name='Sydate' id='Sydate' value='"+Sydate+"'>";
		HTMLVal  += "<input type='hidden' name='p_queue_date' id='p_queue_date' value='"+p_queue_date+"'>";
		HTMLVal  += "</form>";
		HTMLVal  += "</html>";
	 	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
		parent.parent.messageFrame.document.OpenChartWrapperForm.submit();
    	}else{
    		alert(getMessage('ACCESS_RESTRICTED_AUTH_PERSONAL','COMMON'));
    	}
	}
    if(val=="Revert")
    {
        var dialogHeight= "70vh" ;
		var dialogWidth = "85vw" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
	
		var retVal = await top.window.showModalDialog("../../eOP/jsp/CallPatArrival.jsp"+parameters+"&revert_to_check_in=Y",arguments,features);

		if (retVal=="ok")
		{
			//window.close();
			parent.parent.document.getElementById("dialog_tag").close();   
		}
    }

	if(val=="Check")
    {		
		
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='packageCheck' id='packageCheck' method='post' action='../../eOP/jsp/OPPackageIntermediateValidations.jsp'>";
		//HTMLVal+="<input type='hidden' name='encounter_id' id='encounter_id' value='"+EncounterId+"'>";
		//HTMLVal+="<input type='hidden' name='queue_date' id='queue_date' value='"+p_queue_date+"'>";
		//HTMLVal+="<input type='hidden' name='QStatus' id='QStatus' value='"+p_queue_status+"'>";
		//HTMLVal+="<input type='hidden' name='arriveDTime' id='arriveDTime' value='"+ARRIVE_DATE_TIME+"'>";
		//HTMLVal+="<input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'>";
		//HTMLVal+="<input type='hidden' name='oper_id' id='oper_id' value='"+Qoperstat+"'>";
		HTMLVal+="<input type='hidden' name='called_function' id='called_function' value='OPCHECKOUTTOOLTIP'>";
		HTMLVal+="<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='Y'>";
		HTMLVal+="<input type='hidden' name='pat_id' id='pat_id' value='"+patient_id+"'>";
		HTMLVal+="<input type='hidden' name='encounter_id' id='encounter_id' value='"+EncounterId+"'>";
		HTMLVal+="<input type='hidden' name='parameters' id='parameters' value='"+parameters+"'>";
		HTMLVal+="<input type='hidden' name='pkg_pat_yn' id='pkg_pat_yn' value='"+pkg_pat_yn+"'>";
		HTMLVal+="<input type='hidden' name='pkg_enc_yn' id='pkg_enc_yn' value='"+pkg_enc_yn+"'>";
		//HTMLVal+="<input type='hidden' name='rowNum' id='rowNum' value='"+count+"'>";
		HTMLVal+= "</form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.packageCheck.submit();
		
        /*var dialogHeight= "30" ;
        var dialogWidth = "70" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;

        var retVal = window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp"+parameters,arguments,features);*/
    }

    if(val=="Assign" || val=="ReAssign")
    {
	
        var dialogHeight= "70vh" ;
        var dialogWidth = "85vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
        var retVal = await top.window.showModalDialog("../../eOP/jsp/CallAssign.jsp"+parameters,arguments,features);
    }

    if(val=="Lab Invest")
    {
        var url = "/eCIS/demo/laboratory/PaintLab.jsp"+parameters
        var dialogHeight    = "80vh" ;
        var dialogWidth = "85vw" ;
        var arguments   = "" ;
        var status = "no";
        var scroll = "yes";
        var dialogTop = "0vh";
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
        var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
    }
    if(val=="Rad Invest")
    {
            var url = '/eCIS/demo/Radialogy_files/RadialogyMain.jsp'+parameters
            var dialogHeight    = "80vh" ;
            var dialogWidth = "80vw" ;
            var arguments   = "" ;
            var status = "no";
            var scroll = "yes";
            var dialogTop = "60px";
            var dialogLeft = "50px";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; dialogLeft:"+ dialogLeft + ";status:"+ status + "; scroll:"+ scroll;
            var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
    }
	if(val=="multirefreg"){
		//var url = '../../eOR/jsp/ManageConsultOrders.jsp?encounter_id='+EncounterId+"&called_from=PATIENT_QUEUE";//IN071558
		var url = '../../eOR/jsp/ManageConsultOrders.jsp?patient_id='+patient_id+'&encounter_id='+EncounterId+"&called_from=PATIENT_QUEUE";//IN071558
		var dialogHeight    = "80vh" ;
		var dialogWidth = "85vw" ;
		var arguments   = "" ;
		var status = "no";
		var scroll = "yes";
		var dialogTop = "0px";
		var dialogLeft = "0vh";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; dialogLeft:"+ dialogLeft + ";status:"+ status + "; scroll:"+ scroll;
		var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	}
	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->
	if(val=="QueueNoUpdate")
    {
		
        var dialogHeight= "80vh" ;
        var dialogWidth = "85vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
       	var retVal = await top.window.showModalDialog("../../eOP/jsp/CallQueueNoUpdate.jsp"+parameters,arguments,features);
    } //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 end-->
		
		
	setTimeout(async () => {
		  await callSamepage();
		}, 1000);
		//if(callfrom=="S"){
         //setTimeout('await callSamepage()',1000)
		//}else{

		//	 setTimeout('refreshFrames()',1000)
	//	}

}
function refreshFrames()
{
  /*   var s
		if(parent.frames[0].document.forms[0].visit_type.checked==true)
			s="&orderby=yes"
		else
			s="&orderby=no"
		var oprstn=parent.frames[0].document.forms[0].oper_stn.value
		var starttime = parent.frames[0].document.forms[0].start_time.value;
		var qspeciality=parent.frames[0].document.forms[0].Qspeciality.value;
		var rfresh_param= parent.frames[0].document.forms[0].rfresh_param.value;
		parent.frames[1].location.href="../../eOP/jsp/MultiPatframe3.jsp?refresh="+rfresh_param+"&oprstn="+oprstn+s+"&starttime="+starttime+"&Qspeciality="+qspeciality;*/
}

function openPatientChart(eid){
	var HTMLVal  = "<html>";
	HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
	HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + eid + "'>";
	HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
	HTMLVal  += "<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='OP'>";
	HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
	HTMLVal  += "<input type='hidden' name='ConsOrdChartYn' id='ConsOrdChartYn' value='Y'>";
	HTMLVal  += "</form>";
	HTMLVal  += "</html>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
    parent.parent.messageFrame.document.OpenChartWrapperForm.submit();
}
/*function callcheckout(param)
{
	
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var dialogHeight= "30" ;
    var dialogWidth = "70" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
    var arguments   = "" ;
    var retVal = window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp"+param,arguments,features);
}*/
function callPatient(patient_id,EncounterId,queue_num){

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			 
			var param="&callfunc=callTicket&queue_num="+queue_num+"&patient_id="+patient_id+"&encounter_id="+EncounterId;

			var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			
			responseText=trimString(xmlHttp.responseText);			
			//Added for the SCF - ML-Bru-SCF-1074
			if(responseText!=''){
				alert(responseText)
			}
			setTimeout('callSamepage()',1000)
}

//function callNextPatient(room_num){
function callNextPatient(){ //Modified for the SCF - ML-Bru-SCF-1074

	
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			 
			var param="&callfunc=callNextTicket";//Modified for the SCF - ML-Bru-SCF-1074
//			var param="&callfunc=callNextTicket&room_num="+room_num;
	
			var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			//Added for the SCF - ML-Bru-SCF-1074
			if(responseText!=''){
				alert(responseText)
			}
			setTimeout('callSamepage()',1000)
}
/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-MAY-2013*/
function menuHide()
{
if(frame1.frame2){ 
    if(frame1.frame2.document.getElementById("tooltiplayer")){ 
     frame1.frame2.document.getElementById("tooltiplayer").style.visibility='hidden';}}
	 else{ if(frame1.MultiPatframe3.document.PatQ){
      frame1.MultiPatframe3.document.getElementById("tooltiplayer").style.visibility='hidden';}}
}

//FnCheckOPQBLValidation Added by dharma for MMS-QH-CRF-0126 [IN:041880] 

async function FnCheckOPQBLValidation(jspName, parameters, arguments, features, patient_id, action_on_pending_bill, facility_id, episode_id, op_episode_visit_num, action) {
    var IsProceed = 0;  
    $.ajax({  
        url: '../../eOP/jsp/OPQBLValidation.jsp',  
        type: 'post',  
        data: {
            'facility_id': facility_id,
            'p_patient_id': patient_id,
            'p_episode_type': 'O',
            'p_episode_id': episode_id,
            'p_visit_id': op_episode_visit_num
        },
        dataType: 'json',
        success: async function(data) {
            if (data.IsResult == 1) {
                var p_unbilled_amt = parseInt(data.p_unbilled_amt);
                var p_unsettled_amt = parseInt(data.p_unsettled_amt);
                
                if (p_unbilled_amt == 0 && p_unsettled_amt == 0) {
                    IsProceed = 1;
                } else {
                    if (action_on_pending_bill == 'W') {
                        if (confirm(getMessage("UNSETTLED_UNBILLED_AMT_WARNING", "OP"))) {
                            IsProceed = 1;
                        }
                    } else {
                        alert(getMessage("UNSETTLED_UNBILLED_AMT_STOP", "OP"));
                        return false;
                    }
                }

                if (IsProceed == 1) {
                
                    var retVal = await top.window.showModalDialog(jspName + parameters, arguments, features);
                    if (action == 'Arrived') {
                        if (retVal == "ok") {
                            // Close the dialog window after arriving
                            const dialogTag = parent.parent.document.getElementById("dialog_tag");    
                            dialogTag.close();   
                        }
                    }
                }
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert("Error: " + jqXHR.responseText);
        }
    });
}

//start 68508
async function getMenstrualHistoryDtl(patient_id,facility_id){
	var dialogHeight= "60vh";
	var dialogWidth = "85vw";
	var dialogTop	= "";
	var status = "no";
	var arguments	= "" ;			
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var jsp_name;
	await window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlResultView.jsp?patient_id="+patient_id+"&facility_id="+facility_id,arguments,features);
}
//end 68508

