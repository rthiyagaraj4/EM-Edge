function reset()
{  
	if(f_query_add_mod.document.forms[0])
	{ 
		f_query_add_mod.document.forms[0].reset();
	}	
 /* if(parent.frames[1].frames[1].document.repOPRefStatMonwiseform){
	parent.frames[1].frames[1].document.repOPRefStatMonwiseform.reset() ;
	}*/
	
	
}//e.o.reset


function run()
{	

if(f_query_add_mod.document.repVisitTypeList){	
	
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.VisitTypeCode.label","Common"), f_query_add_mod.document.repVisitTypeList.p_fm_visit_type_code,f_query_add_mod.document.repVisitTypeList.p_to_visit_type_code, messageFrame )  )
f_query_add_mod.document.repVisitTypeList.submit() ;
}

if(f_query_add_mod.document.repPractforClinic){
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repPractforClinic.p_fm_clinic_code,f_query_add_mod.document.repPractforClinic.p_to_clinic_code, messageFrame )  )
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.practitionerid.label","Common"), f_query_add_mod.document.repPractforClinic.p_fm_pract_id,f_query_add_mod.document.repPractforClinic.p_to_pract_id, messageFrame )  )
f_query_add_mod.document.repPractforClinic.submit() ;
}

if(f_query_add_mod.document.repVisitTypeforClinic){
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repVisitTypeforClinic.p_fm_clinic_code,f_query_add_mod.document.repVisitTypeforClinic.p_to_clinic_code, messageFrame )  )
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.VisitTypeCode.label","Common"), f_query_add_mod.document.repVisitTypeforClinic.p_fm_visit_type_code,f_query_add_mod.document.repVisitTypeforClinic.p_to_visit_type_code, messageFrame )  )
f_query_add_mod.document.repVisitTypeforClinic.submit() ;
}

if(f_query_add_mod.document.repClinic){
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repClinic.p_fm_clinic_code,f_query_add_mod.document.repClinic.p_to_clinic_code, messageFrame )  )
f_query_add_mod.document.repClinic.submit() ;
}

if(f_query_add_mod.document.repClinicforRoom){
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repClinicforRoom.p_from_clinic_code,f_query_add_mod.document.repClinicforRoom.p_to_clinic_code, messageFrame )  ) 
	if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.roomno.label","Common"), f_query_add_mod.document.repClinicforRoom.p_from_room_no,f_query_add_mod.document.repClinicforRoom.p_to_room_no, messageFrame )  ) 
f_query_add_mod.document.repClinicforRoom.submit() ;
}

if(f_query_add_mod.document.repClinicforService){
if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repClinicforService.p_from_clinic_code,f_query_add_mod.document.repClinicforService.p_to_clinic_code, messageFrame )  ) 
	if( menuFrame.CheckString(f_query_add_mod.getLabel("Common.ServiceCode.label","Common"), f_query_add_mod.document.repClinicforService.p_from_service_code,f_query_add_mod.document.repClinicforService.p_to_service_code, messageFrame )  ) 
f_query_add_mod.document.repClinicforService.submit() ;
}


}//e.o.run


function codeCheck(Obj)
{
if(Obj==' ')
	parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';

if(Obj=='OP_VISIT_TYPE')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repVisitTypeList.jsp";

if(Obj=='OP_CLINIC')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repClinic.jsp";

if(Obj=='OP_PRACT_FOR_CLINIC')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repPractforClinic.jsp";

if(Obj=='OP_VISIT_TYPE_FOR_CLINIC')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repVisitTypeforClinic.jsp";
	
if(Obj=='OP_CLINIC_ROOM')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repClinicforRoom.jsp";

if(Obj=='OP_CLINIC_FOR_SERVICE')
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repClinicforService.jsp";


	/*if(Obj==5){
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repEncounterNum.jsp";
	}
	if(Obj==6){
	parent.f_query_add_mod.location.href ="../../eOP/jsp/repEpisodeNum.jsp";
	}*/
}


function CheckString(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        var fro;
		var to;
		if(isNaN(fromobj.value) && isNaN(toobj.value)){			
			 fro=fromobj.value;
			 to=toobj.value;			
		 }else{
			  fro=parseInt(fromobj.value);
			  to=parseInt(toobj.value);
		 }
        if(fro <= to) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
