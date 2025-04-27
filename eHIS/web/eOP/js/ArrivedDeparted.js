function showresult(obj,val)
{
    var objname=obj.name;
    var locntype=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].value;
    //var locncode=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].value;
    var locncode=parent.frames[1].document.forms[0].location_code.value;
    var locntypedesc=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].text;
    //var locndesc=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].text;
    var locndesc=parent.frames[1].document.forms[0].loc_code.value;
    var patientclass=parent.frames[1].document.forms[0].patient_class.options[parent.frames[1].document.forms[0].patient_class.selectedIndex].value;    
    var encounterid=parent.frames[1].document.forms[0].encounter_id.value;
    var patientid=parent.frames[1].document.forms[0].patient_id.value;
    var encounterdate=parent.frames[1].document.forms[0].encounter_date.value;
    var orderby=parent.frames[1].document.forms[0].order_by.value;
    var allencounters="";

    if(encounterdate!="")       
            encounterdate = convertDate(encounterdate,"DMY",localeName,"en");    
        

    if((objname =="Arrived" || objname == "srch_code") && val == "A")
    {

        if(parent.frames[1].document.forms[0].all_encounters.checked == true)
        {
            allencounters="Y";
        }
        else
        {
            allencounters="N";
        }
    }
    else
    {
        allencounter="N";
    }
    
    
    if(objname != "srch_code")
    {       
        
    parent.frames[1].location.href="../../eOP/jsp/ArrivedDepartedCriteria.jsp?Pageval="+val+"&callfrom="+objname;

    parent.frames[2].location.href="../../eCommon/html/blank.html";
    
    }
    var fields = new Array (parent.frames[1].document.forms[0].location_code);
     var names = new Array (getLabel("Common.Location.label",'Common'));

  if(allencounters != "Y"  && objname == "srch_code")
    {
    
        if(parent.parent.frames[1].checkFields( fields, names, parent.parent.messageFrame))
        {
            parent.frames[2].location.href="../../eOP/jsp/ArrivedDepartedResult.jsp?callfrom="+objname+"&Pageval="+val+"&patientid="+patientid+"&encounterid="+encounterid+"&patientclass="+patientclass+"&locntype="+locntype+"&locntypedesc="+locntypedesc+"&locncode="+locncode+"&locndesc="+locndesc+"&encounterdate="+encounterdate+"&allencounters="+allencounters+"&orderby="+orderby;
        }
    }else if(objname == "srch_code")
    {
        if(parent.parent.frames[1].checkFields( fields, names, parent.parent.messageFrame))
        {
            parent.frames[2].location.href="../../eOP/jsp/ArrivedDepartedResult.jsp?callfrom="+objname+"&Pageval="+val+"&patientid="+patientid+"&encounterid="+encounterid+"&patientclass="+patientclass+"&locntype="+locntype+"&locntypedesc="+locntypedesc+"&locncode="+locncode+"&locndesc="+locndesc+"&encounterdate="+encounterdate+"&allencounters="+allencounters+"&orderby="+orderby;
        }
    }
}



function reset()
{

    // reset the criteria page and clear the results
    
    f_query_add_mod.document.dispimg_frame.location.href="../../eOP/jsp/PatTrackMovementHead.jsp";
    f_query_add_mod.document.criteria_frame.location.href="../../eOP/jsp/ArrivedDepartedCriteria.jsp?Pageval=D";
    f_query_add_mod.document.result_frame.location.href="../../eCommon/html/blank.html";

}

/*function validateDate(obj)
    {
    if(obj.value!="")
        {
            if(validDate(obj.value,'DMY',localeName)==false)
                {
                    alert(getMessage("INVALID_DATE_FMT","SM"));
                    obj.select();   
                    return false;
            }
            else
                return true;
        }
}*/
function onBlurgetLoc(fac_id,locale,callvalue,target)
{

        if(target.value == "")
        {
            target.value="";

            if(callvalue=="Criteria")
            {
                document.forms[0].location_code.value="";
            }
            else if (callvalue=="Departed")
            {
                document.forms[0].location_code1.value="";
            }   
            return;
        }

         getLocn(fac_id,locale,callvalue,target);

}

async function getLocn(fac_id,locale,callvalue,target)
{
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";  

   if(callvalue=="Departed")    
   {
        var locntype=parent.frames[1].document.forms[0].location_type1.options[parent.frames[1].document.forms[0].location_type1.selectedIndex].value;
        var locncode=parent.frames[1].document.forms[0].user_locn_code.value;
        var enc_loc_type=parent.frames[1].document.forms[0].enc_loc_type.value;
        var enc_loc_code=parent.frames[1].document.forms[0].enc_loc_code.value;
        var lindex=parent.frames[1].document.forms[0].location_type1.options.selectedIndex;
   }
   else if(callvalue=="Criteria")   
   {
        var locntype=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].value;

        //var locncode=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].value;  
        var lindex=parent.frames[1].document.forms[0].location_type.options.selectedIndex;
   }    
    
   var locn_ind;

   if(lindex==0){
          locn_ind="";
   }else{

    locn_ind=Larray[lindex];
    
    tit=getLabel('Common.Location.label','Common');


    if(locn_ind=="N"){

         sql="Select a.nursing_unit_code code ,a.LONG_DESC description from ip_nursing_unit_lang_vw a  where language_id='"+locale+"' and a.facility_id = '"+fac_id+"' and a.eff_status = 'E' and a.locn_type='"+locntype+"' and a.patient_class = 'IP' ";  

         if(callvalue=="Departed" && !locncode=="")
         {
                sql=sql+" and a.nursing_unit_code != '"+locncode+"'";
         }
         sql=sql+" and upper(a.nursing_unit_code) like upper(?) and upper(a.LONG_DESC) like upper(?) order by 2";                
    }else if(locn_ind=="R"){
        
        sql="Select Room_num code, Short_desc description from AM_FACILITY_ROOM_lang_vw where language_id='"+locale+"' AND eff_status = 'E' and operating_facility_id = '"+fac_id+"' and room_type = '"+locntype+"'";
        
         if(callvalue=="Departed" && !locncode=="") {
                sql=sql+" and Room_num != '"+locncode+"'";
         }
         sql=sql+" and upper(Room_num) like upper(?) and upper(Short_desc) like upper(?) order by 2";


    }else if(locn_ind=="O"){
        sql="Select oper_room_code code, Short_desc description from ot_oper_room_lang_vw where language_id='"+locale+"' and nvl(status,'E')='E' and operating_facility_id = '"+fac_id+"' ";
        
         if(callvalue=="Departed" && !locncode=="") {
                sql=sql+" and oper_room_code != '"+locncode+"'";
         }
         sql=sql+"  and upper(oper_room_code) like upper(?) and upper(Short_desc) like upper(?) order by 2";
        

    }else if(locn_ind=="W"){
        sql="Select clinic_code code, Short_desc description from rd_clinic_lang_vw where language_id='"+locale+"' and nvl(status,'E')='E' and operating_facility_id = '"+fac_id+"' ";
        
        if(callvalue=="Departed" && !locncode=="") {
                sql=sql+" and clinic_code != '"+locncode+"'";
        }
         sql=sql+" and upper(clinic_code) like upper(?) and upper(Short_desc) like upper(?) order by 2";        


    }else{
        sql="select clinic_code code ,long_desc description from op_clinic_lang_vw a where facility_id='"+fac_id+"' and language_id='"+locale+"' AND eff_status='E' and clinic_type = '"+locntype+"'"; 
                              
        if(callvalue=="Departed" && !locncode=="")
        {
            sql=sql+" and a.clinic_code != '"+locncode+"'";
        }
        sql=sql+" and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
    }


    //sql ="Select clinic_code code, long_desc description from op_clinic where (care_locn_type_ind='"+care_ind+"') and facility_id='"+fac_id+"' and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+objval+"') and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";    
                
                argumentArray[0] = sql;
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
                    
                    if(callvalue=="Criteria")
                    {
                        document.forms[0].location_code.value=arr[0];
                    }
                    else if (callvalue=="Departed")
                    {
                        if(enc_loc_type==locntype) {                        
                            document.forms[0].location_code1.value=enc_loc_code;
                        }
                        else {
                            document.forms[0].location_code1.value=arr[0];
                        }
                    }   
                }
        }
}
function chkWithSysDt(obj)
    {
        if(obj.value!=''){

            if(isBeforeNow(obj.value,"DMY",localeName))
                return true;
            else {
                alert(getMessage("START_DATE_GREATER_SYSDATE","OP"));
                obj.select();
                //obj.focus();
                return false ;
            }
        }
    }

/*function Populatelocn(obj)
{
    var locntype=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].value;

    var locncode=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].value;

    clearlist(obj)

    var lindex=obj.options.selectedIndex;
    var ind;
    
    if(lindex==0){
          ind="";
    }else{

     ind=Larray[lindex];
    
    var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poplocn' id='poplocn'method='post' action='../../eOP/jsp/ArrivedDepartedGetVal.jsp'><input type='hidden' name='locn_type' id='locn_type' value='"+locntype+"'><input type='hidden' name='locn_code' id='locn_code' value='"+locncode+"'><input type='hidden' name='locn_ind' id='locn_ind' value='"+ind+"'><input type='hidden' name='callval' id='callval' value='Criteria' ></form></body></html>";
    
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.poplocn.submit();
    }
}*/

function clearlist(obj)
{
    if(obj.name=="location_type")
    {
        parent.frames[1].document.forms[0].location_code.value="";
        parent.frames[1].document.forms[0].loc_code.value="";
    }
    /*if(obj.name=="location_type")
    {
        var length  =parent.frames[1].document.forms[0].location_code.length;
        var element = parent.frames[1].document.forms[0].document.createElement('OPTION');
        element.text= "&nbsp;&nbsp;--------"+getLabel('Common.defaultSelect.label','Common')+" --------&nbsp;&nbsp;";
        element.value="";
    
        for(i=1;i<length;i++)
          parent.frames[1].document.forms[0].location_code.remove(1);
    }*/
}

function dummy(){}

async function ShowModal(objval,Pageval,patientid,locationtype,locationtypedesc,locationcode,locationdesc,userlocn,userlocndesc,userlocntype,userlocntypedesc,encounterid,enc_dt_time,enc_type,pat_trn_time,enc_loc_type,enc_loc_code)
{
    if(objval == "A")
    {
    var dialogHeight ='250px' ;
    var dialogWidth = '1000px' ;
    var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=yes; status=no';
    var arguments;
    retVal = await window.showModalDialog("../../eOP/jsp/DepartedFrameSet.jsp?&Pageval="+Pageval+"&Patientid="+patientid+"&location_type="+locationtype+"&locationtypedesc="+encodeURIComponent(locationtypedesc)+"&location_code="+locationcode+"&location_desc="+encodeURIComponent(locationdesc)+"&user_locn="+userlocn+"&userlocntype="+userlocntype+"&userlocndesc="+userlocndesc+"&userlocntypedesc="+userlocntypedesc+"&encounter_id="+encounterid+"&enc_dt_time="+enc_dt_time+"&pat_trn_time="+pat_trn_time+"&enc_type="+enc_type,arguments,features);
    }
    else if(objval == "D")
    {
        
   var dialogHeight ='400px' ;
    var dialogWidth = '700px' ;
    var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=yes; status=no';
    var arguments;
    
    
        retVal = await window.showModalDialog("../../eOP/jsp/DepartedFrameSet.jsp?&Pageval="+Pageval+"&Patientid="+patientid+"&location_type="+locationtype+"&locationtypedesc="+locationtypedesc+"&location_code="+locationcode+"&location_desc="+escape(locationdesc)+"&user_locn="+userlocn+"&userlocndesc="+userlocndesc+"&userlocntype="+userlocntype+"&userlocntypedesc="+userlocntypedesc+"&encounter_id="+encounterid+"&enc_dt_time="+enc_dt_time+"&pat_trn_time="+pat_trn_time+"&enc_type="+enc_type+"&enc_loc_type="+enc_loc_type+"&enc_loc_code="+enc_loc_code,arguments,features);
    }

    refreshpage(Pageval);
}

/*function ValidateDatefn2(date)
{
    //alert(date);
    document.forms[0].encounter_date1.value=date;
}

function ValidateDatefn(flag)
{
if(flag==true)
    {
    encounter_date=document.forms[0].encounter_date.value
    var currdate=DateUtils.convertDate(encounter_date,"DMY",localeName,"en",ValidateDatefn2);
    
    }
}
function Checkdt(obj)
{
if(obj.value!="")
DateUtils.validDate(obj.value,'DMY',localeName,ValidateDatefn)
else
    document.forms[0].encounter_date1.value="";

    /*if(!CheckDate(obj))
    {
        obj.focus();
        obj.value="";
        
    }*/
//}

function refreshpage(val)
{
    
    var locntype=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].value;
    //var locncode=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].value;
    var locncode=parent.frames[1].document.forms[0].location_code.value;
    var locntypedesc=parent.frames[1].document.forms[0].location_type.options[parent.frames[1].document.forms[0].location_type.selectedIndex].text;
    //var locndesc=parent.frames[1].document.forms[0].location_code.options[parent.frames[1].document.forms[0].location_code.selectedIndex].text;
    var locndesc=parent.frames[1].document.forms[0].loc_code.value;
    var patientclass=parent.frames[1].document.forms[0].patient_class.options[parent.frames[1].document.forms[0].patient_class.selectedIndex].value;    
    var encounterid=parent.frames[1].document.forms[0].encounter_id.value;
    var patientid=parent.frames[1].document.forms[0].patient_id.value;
    var encounterdate=parent.frames[1].document.forms[0].encounter_date.value;
    var orderby=parent.frames[1].document.forms[0].order_by.value;
    var allencounters="";

    if(encounterdate!="")
        encounterdate = convertDate(encounterdate,"DMY",localeName,"en");       


    if(parent.frames[1].document.forms[0].all_encounters != null)
    {

        if(parent.frames[1].document.forms[0].all_encounters.checked == true)
        {
            allencounters="Y";
        }
        else
        {
            allencounters="N";
        }
    }
    else
    {
        allencounter="N";
    }
  parent.frames[2].location.href="../../eOP/jsp/ArrivedDepartedResult.jsp?callfrom=success&Pageval="+val+"&patientid="+patientid+"&encounterid="+encounterid+"&patientclass="+patientclass+"&locntype="+locntype+"&locntypedesc="+locntypedesc+"&locncode="+locncode+"&locndesc="+locndesc+"&encounterdate="+encounterdate+"&allencounters="+allencounters+"&orderby="+orderby;

}

// JS functions used in PatTrackMovement head .jsp

var currentTab = new String();
currentTab = "Arrived_tab";


function tab_click(objName)
{
    selectTab(objName)
  if (objName == "Arrived_tab")
    {
         // changeTab(objName);
         showresult(this,'A');
    }
    else if(objName == "Departed_tab")
    {
        // changeTab(objName);
        showresult(this,'D');
    }
}


async function getPatID()
{                     
    var pat_id=await PatientSearch();
    if( pat_id != null )                        
        parent.frames[1].document.forms[0].patient_id.value = pat_id ;                  
}

function clearData(val,obj)
 {
    var objname=obj.name;
    parent.frames[1].location.href="../../eOP/jsp/ArrivedDepartedCriteria.jsp?Pageval="+val+"&callfrom="+objname;
    parent.frames[2].location.href="../../eCommon/html/blank.html";
 }

// js functions in ArrivedMain.jsp

function exitArrived() 
    {
        //window.returnValue = "AD";
        let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = "AD";
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
		
    }

function submit_ok()
{
    parent.frames[1].document.forms[0].submit();
}
// JS functions in departed Main.jsp


/*function PopulatelocnD(obj)
{
    
    var locntype=parent.frames[1].document.forms[0].location_type1.options[parent.frames[1].document.forms[0].location_type1.selectedIndex].value;
    var locncode=parent.frames[1].document.forms[0].user_locn_code.value;
    var enc_loc_type=parent.frames[1].document.forms[0].enc_loc_type.value;
    var enc_loc_code=parent.frames[1].document.forms[0].enc_loc_code.value;
    //clearlist1(obj)
    var ind;
    var lindex=obj.options.selectedIndex;
         if(ind == 0)
                 ind="";
             else{
                 ind=Larray[lindex];
                 

            var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='poplocn' id='poplocn'method='post' action='../../eOP/jsp/ArrivedDepartedGetVal.jsp'><input type='hidden' name='locn_type' id='locn_type' value='"+locntype+"'><input type='hidden' name='locn_ind' id='locn_ind' value='"+ind+"'><input type='hidden' name='locn_code' id='locn_code' value='"+locncode+"'><input type='hidden' name='enc_locn_type' id='enc_locn_type' value='"+enc_loc_type+"'><input type='hidden' name='enc_locn_code' id='enc_locn_code' value='"+enc_loc_code+"'><input type='hidden' name='callval' id='callval' value='Departed' ></form></body></html>";
            
            parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.frames[2].poplocn.submit();
             }
}*/

function clearlist1(obj)
{
    if(obj.name=="location_type1")
    {
        parent.frames[1].document.forms[0].location_code1.value="";
        parent.frames[1].document.forms[0].loc_code1.value="";
        /*var length  =parent.frames[1].document.forms[0].location_code1.length;
        var element = parent.frames[1].document.forms[0].document.createElement('OPTION');
        element.text= "&nbsp;&nbsp;-------- "+getLabel('Common.defaultSelect.label','common')+"--------&nbsp;&nbsp;";
        element.value="";
    
        for(i=1;i<length;i++)
          parent.frames[1].document.forms[0].location_code1.remove(1);*/
    }
}

function exitDeparted() 
{
  /*  window.returnValue = "DP";
    parent.window.close();
    */
	// Set the return value if necessary
    let dialogBody = parent.parent.document.getElementById('dialog-body');
    if (dialogBody && dialogBody.contentWindow) {
        dialogBody.contentWindow.returnValue = "DP";
    }

    // Retrieve dialog tags
    const dialogTags = parent.parent.document.querySelectorAll("#dialog_tag");

    // Close each dialog tag if they exist
    dialogTags.forEach(dialogTag => {
        if (typeof dialogTag.close === 'function') {
            dialogTag.close();
        }
    });
}


function Depsubmit_ok()
{
    if(blankchk())
        {
          parent.frames[1].document.forms[0].submit();
        }
}

function blankchk()
{
    var error = "";
    var erval="";

        if(parent.frames[1].document.forms[0].location_type1.value == '')
        {
            erval = getMessage('CAN_NOT_BE_BLANK','COMMON');
            error += erval.replace('$',getLabel('Common.locationtype.label','Common'));
                error += "\n";
            
        }

        if(parent.frames[1].document.forms[0].location_code1.value == '')
        {
            erval = getMessage('CAN_NOT_BE_BLANK','COMMON');
            error += erval.replace('$',getLabel('Common.locationcode.label','Common'));
                error += "\n";
            
        }
        if(parent.frames[1].document.forms[0].move_reason.value == '')
        {
            erval = getMessage('CAN_NOT_BE_BLANK','COMMON');
            error += erval.replace('$',getLabel('eOP.ReasonForMovement.label','OP'));
                error += "\n";
            
        }
        if(error != "")
        {
                alert(error);
                return false
        }
                else
        {
                    return true;
        }
}