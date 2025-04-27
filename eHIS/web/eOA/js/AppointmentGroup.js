function create() {	 
	f_query_add_mod.location.href = "../../eOA/jsp/AppointmentGroup.jsp" ;
}
function query() {
   f_query_add_mod.location.href ="../../eOA/jsp/AppointmentGroupQueryPage.jsp";
}

function locationPopulate(obj){		
	
		 document.getElementById('b_loc_val').value="";
		 document.getElementById("blocation").value="";		
		
}

	function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			document.forms[0].b_loc_val.value="";
			document.forms[0].blocation.value="";
			
			
		}else{
		open_loc_lookup()
		}
	}


	async function open_loc_lookup(){
		var location1=document.forms[0].locationType.value;
		var location_val=document.forms[0].b_loc_val.value;
		//location1 = location1.split("|");
		var locn_type=location1;
		var care_locn_ind=location1; 
		//var dialogTop = "60" ;
		//var dialogHeight= "37" ;
		//var dialogWidth	= "60" ;
		var dialogTop = "10px" ;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var status = "no";
		var arguments	= "" ;
		var tit="locn_Srch";
		var clinic_desc=""
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		//retVal = window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&clinic_desc="+clinic_desc+"&function_id=GRP_APPT_DOCT",arguments,features);
		
		retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&clinic_desc="+clinic_desc+"&function_id=SCH_APPT",arguments,features);
			
		if(retVal!=null){
			var rvalues=retVal.split("~");
			var code=rvalues[0];	 
						
			document.forms[0].b_loc_val.value=rvalues[1];
			document.forms[0].blocation.value=rvalues[0];
			
		}else{
			document.forms[0].b_loc_val.value="";
			document.forms[0].blocation.value="";
			
		
		}

	}

function apply(){ 
	
	
		 var fields=new Array(f_query_add_mod.document.forms[0].group_id,		
				f_query_add_mod.document.forms[0].group_name,
				f_query_add_mod.document.forms[0].locationType,
				f_query_add_mod.document.forms[0].b_loc_val,
				f_query_add_mod.document.forms[0].min_patient,
				f_query_add_mod.document.forms[0].max_patient);
         var names=new Array(
        		  getLabel("eOA.GroupId.label","OA"), 
        		  getLabel("Common.GroupName.label","Common"),
        		  getLabel("Common.locationtype.label","Common"),
				  getLabel("Common.Location.label","Common"),
				  getLabel("Common.MIN.label","Common")+" "+getLabel("Common.patient.label","Common"),
				  getLabel("Common.Max.label","Common")+" "+getLabel("Common.patient.label","Common"));
        
        
         /*var group_id=f_query_add_mod.document.forms[0].group_id.value;
         var group_name=f_query_add_mod.document.forms[0].group_name.value ;
		 var locationtype=f_query_add_mod.document.forms[0].locationType.value ;
		 var b_loc_val=	f_query_add_mod.document.forms[0].b_loc_val.value;
		 var min_patient=	f_query_add_mod.document.forms[0].min_patient.value;
		 var max_patient=f_query_add_mod.document.forms[0].max_patient.value;
		 var function_name=f_query_add_mod.document.forms[0].function_name.value ;
		 var blocation=f_query_add_mod.document.forms[0].blocation.value;*/
		 
		
 	//	var HTMLVal = "<html><body onKeyDown='lockKey();'>" +
 			//	"<form name='create_group' id='create_group' method='post' action='../../servlet/eOA.AppointmentGroupServlet'><input type='hidden' name='group_id' id='group_id' value='"+group_id+"'><input type='hidden' name='group_name' id='group_name' value='"+group_name+"'><input type='hidden' name='locationtype' id='locationtype' value='"+locationtype+"'><input type='hidden' name='blocation' id='blocation' value='"+blocation+"'><input type='hidden' name='min_patient' id='min_patient' value='"+min_patient+"'><input type='hidden' name='max_patient' id='max_patient' value='"+max_patient+"'><input type='hidden' name='function_name' id='function_name' value='"+function_name+"'><input type='hidden' name='eff_status' id='eff_status' value='"+eff_status+"'></form></body></html>";	
 		//f_query_add_mod.document.write(HTMLVal);
 		//alert(HTMLVal);
	//	 var messageFrame=document.frames[1];
		
	 
	 if(f_query_add_mod.checkFields( fields, names, messageFrame)){		
 		 f_query_add_mod.document.forms[0].submit();	
		
	 }

 		//parent.frames[2].document.write(HTMLVal);		
		//parent.frames[2].document.create_group.submit();
         
   // }
}
function reset() {
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function checkValue(obj){
	if(obj.value <= 0){		
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
		obj.value="";
		obj.focus();
	}
}



function allowPositiveNumber() 
{
	var key = window.event.keyCode;
	if((key < 48 ) || (key >= 58)) 	
		return false;		
}

function MaxminChk(){
	 var min_patient=document.forms[0].min_patient.value;
	 var max_patient=document.forms[0].max_patient.value;
	if(min_patient!="" && max_patient!=""){
	   if(parseInt(min_patient)<=parseInt(max_patient)){ 
	       return true;
    	}else{
    		
	       
	        alert(getMessage("MIN_MAX_PATIENT","OA"));
	        document.forms[0].min_patient.value="";
    		//document.forms[0].max_patient.value="";
    		document.forms[0].min_patient.focus();
	   }	return false;
	  }
}
	
function check_eff(obj){
	if(obj.checked == true){
		obj.value='E';
	}
	else{
		obj.value='D';
	}
}	
	



	

