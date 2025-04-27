/*
 Developed By : Venkatesh.s
 Date         : 28-Nov-2013 

*/

 function create()
 {
   
f_query_add_mod.location.href="../../eMO/jsp/MOEmbalmFrames.jsp";
  
  }
function query()
{ 

      
	
		 f_query_add_mod.location.href ="../../eMO/jsp/EmbalmQueryCriteria.jsp";
 
}
 
 function reset() {
  url=f_query_add_mod.location.href;
  
 if(f_query_add_mod.EmbalmCriteria && f_query_add_mod.EmbalmResult){
     f_query_add_mod.location.href="../../eMO/jsp/MOEmbalmFrames.jsp"}
  
 if(url.indexOf("EmbalmQueryCriteria.jsp") !=-1){ 
    f_query_add_mod.location.href ="../../eMO/jsp/EmbalmQueryCriteria.jsp";}

}

 function apply()
 { 
        
		 
     if(f_query_add_mod.EmbalmResult  && f_query_add_mod.EmbalmCriteria ){
		
		 url=f_query_add_mod.EmbalmResult.location.href;
		if(url.indexOf("blank.html")==-1){ 
	 if( f_query_add_mod.frames[1].frames[1].document.forms[0].name_prefix) {
	  f_query_add_mod.frames[1].frames[1].document.forms[0].name_prefix.disabled=false}
       
	    if( f_query_add_mod.frames[1].frames[1].document.forms[0].name_prefix) {
	 
	 f_query_add_mod.frames[1].frames[1]. document.forms[0].name_prefix.disabled=false}
	  
	  
	  if( f_query_add_mod.frames[1].frames[1].document.forms[0].name_prefix_oth_lang) { 
	  
	  f_query_add_mod.frames[1].frames[1].document.forms[0].name_prefix_oth_lang.disabled=false
	  }
	  if( f_query_add_mod.frames[1].frames[1].document.forms[0].name_suffix) { 
	  
	  f_query_add_mod.frames[1].frames[1].document.forms[0].name_suffix.disabled=false
	  }
	  
	   if( f_query_add_mod.frames[1].frames[1].document.forms[0].name_suffix_oth_lang) { 
	 
	  f_query_add_mod.frames[1].frames[1].document.forms[0].name_suffix_oth_lang.disabled=false
	  }
	  
	  if( f_query_add_mod.frames[1].frames[1].document.forms[0].family_name) { 
	 f_query_add_mod.frames[1].frames[1].document.forms[0].family_name.disabled=false
	  f_query_add_mod.frames[1].frames[1].document.forms[0].bfam.disabled=false
	  }

	  if( f_query_add_mod.frames[1].frames[1].document.forms[0].family_name_oth_lang) { 
	 
	  f_query_add_mod.frames[1].frames[1].document.forms[0].family_name_oth_lang.disabled=false
	  f_query_add_mod.frames[1].frames[1].document.forms[0].bf.disabled=false
	  }

	 if( f_query_add_mod.frames[1].frames[1].document.forms[0].first_name){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].first_name.disabled=false
	   f_query_add_mod.frames[1].frames[1].document.forms[0].bf.disabled=false}
	   
	 if( f_query_add_mod.frames[1].frames[1].document.forms[0].first_name_oth_lang){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].first_name_oth_lang.disabled=false
	   f_query_add_mod.frames[1].frames[1].document.forms[0].bfo.disabled=false}
	   
	   if( f_query_add_mod.frames[1].frames[1].document.forms[0].second_name){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].second_name.disabled=false
	  f_query_add_mod.frames[1].frames[1]. document.forms[0].bs.disabled=false}
	   
	   if( f_query_add_mod.frames[1].frames[1].document.forms[0].second_name_oth_lang){
	   
	   f_query_add_mod.frames[1].frames[1].document.forms[0].second_name_oth_lang.disabled=false
	   f_query_add_mod.frames[1].frames[1].document.forms[0].bso.disabled=false}
	   
	    if( f_query_add_mod.frames[1].frames[1].document.forms[0].third_name){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].third_name.disabled=false
	   f_query_add_mod.frames[1].frames[1].document.forms[0].bt.disabled=false}
	   
	    if( f_query_add_mod.frames[1].frames[1].document.forms[0].third_name_oth_lang){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].third_name_oth_lang.disabled=false
	   f_query_add_mod.frames[1].frames[1].document.forms[0].bto.disabled=false}
	   
	      if( f_query_add_mod.frames[1].frames[1].document.forms[0].sex){
	  
	   f_query_add_mod.frames[1].frames[1].document.forms[0].sex.disabled=false
	   }
	   
	       f_query_add_mod.frames[1].frames[1].document.forms[0].national_id_no.disabled=false
		 f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=false;
	    f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_id.disabled=false   
		 f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=false;
	   
	
        
		 f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=false;
	    f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_id.disabled=false   
		 f_query_add_mod.frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=false;
		  f_query_add_mod.frames[1].frames[1].document.forms[0].requestor_dob.disabled=false;
		 f_query_add_mod.frames[1].frames[1].document.forms[0].national_id_no.disabled=false;
       
	  
	  var obj=f_query_add_mod.frames[1].frames[1].document.forms[0];
					



var fields = new Array();
	var names = new Array();

	obj=f_query_add_mod.frames[1].frames[1].document.forms[0];
var i = 0;

	if(obj.name_prefix_reqd_yn)
		if(obj.name_prefix_reqd_yn.value=="Y"){		
		fields[i]=obj.name_prefix;
		names[i]= obj.name_prefix_prompt.value;
		i=i+1;
	}

	 if(obj.first_name_reqd_yn)
		if(obj.first_name_reqd_yn.value=="Y"){		
		fields[i]=obj.first_name;
		names[i]= obj.first_name_prompt.value;
		i=i+1;
	}
	
	 if(obj.second_name_reqd_yn)
		if(obj.second_name_reqd_yn.value=="Y"){		
		fields[i]=obj.second_name;
		names[i]= obj.second_name_prompt.value;
			i=i+1;
	}

	 if(obj.third_name_reqd_yn)
		if(obj.third_name_reqd_yn.value=="Y"){		
		fields[i]=obj.third_name;
		names[i]= obj.third_name_prompt.value;
			i=i+1;
	}

	 if(obj.family_name_reqd_yn)
		if(obj.family_name_reqd_yn.value=="Y"){		
		fields[i]=obj.family_name;
		names[i]= obj.family_name_prompt.value;
			i=i+1;
	}
	 
	 if(obj.name_prefix_oth_name_reqd_yn)
	       if(obj.name_prefix_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.name_prefix_oth_lang;
		names[i]= obj.name_prefix_oth_prompt.value;
			i=i+1;
	      }
		  
	if(obj.name_suffix_oth_name_reqd_yn)
	       if(obj.name_suffix_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.name_suffix_oth_lang;
		names[i]= obj.name_suffix_oth_prompt.value;
			i=i+1;
	      }

		if(obj.first_oth_name_reqd_yn)
	       if(obj.first_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.first_name_oth_lang;
		names[i]= obj.first_name_prompt.value;
			i=i+1;
	      }
		  
		  if(obj.second_oth_name_reqd_yn)
	       if(obj.second_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.second_name_oth_lang;
		names[i]= obj.second_name_oth_prompt.value;
			i=i+1;
	      }
		  
		if(obj.third_oth_name_reqd_yn)
	       if(obj.third_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.third_name_oth_lang;
		names[i]= obj.third_name_oth_prompt.value;
			i=i+1;
	      }
        
		if(obj.family_oth_name_reqd_yn)
	       if(obj.family_oth_name_reqd_yn.value=="Y"){		
		fields[i]=obj.family_name_oth_lang;
		names[i]= obj.family_name_oth_prompt.value;
			i=i+1;
	      }
		  
		  
	if(checkFields(fields, names, messageFrame)){

				  if(f_query_add_mod.frames[1].frames[1].document.forms[0].home_embal.checked || f_query_add_mod.frames[1].frames[1].document.forms[0].hospital_embal.checked ){
				     
					 
			
				      f_query_add_mod.frames[1].frames[1].document.forms[0].document.forms[0].submit();
		
					
				  	  
				  } else{	
				  
				  alert(getMessage("EMBALM_HOME_OR_HOSPITAL","MO"));
			    
				 messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
				
				  }
				  
				 }

  }else{commontoolbarFrame.location.reload() }
 }
 else {commontoolbarFrame.location.reload()}
 }
 
 function clearData(){
	if(parent.parent.frames[1].frames[1]){ 
		parent.parent.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	 }
  }
 
 function submitPage(patient_id)
{	   
		if(patient_id!="") 
         {    
       		 var srl_no=document.forms[0].srl_no.value
			 var app_id=document.forms[0].app_id.value
			 var mode=document.forms[0].mode.value
             parent.frames[1].location.href="../../eMO/jsp/MOEmbalmRegFrameSet.jsp?Patient_ID="+patient_id+"&srl_no="+srl_no+"&app_id="+app_id+"&mode="+mode;
         } else{ 
		   var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
	       msg = msg.replace('$',getLabel("Common.patientId.label","Common"));
	       alert(msg);
		 
		 }
 }
 
 function callpatientsearch(obj,facilityId,target)
 {   
    var patientid = PatientSearch('','','','','','','Y','','N','MO');
	if(patientid!=null)
	{
	 document.getElementById("patient_id").value = patientid;
//	 document.getElementById("patient_id").focus();
	if(document.forms[0].search)
		document.forms[0].search.onclick();
	}
	else
	{
		document.getElementById("patient_id").value = "";

	}
 }

  function callpatientsearchapptID(obj,facilityId,target)
 {   
    var patientid = PatientSearch('','','','','','','Y','','N','');
	if(patientid!=null)	{
	 document.getElementById("patient_id").value = patientid;
	document.getElementById("patient_id").focus();	
	}else{
		document.getElementById("patient_id").value = "";
	}
 }
 
 function placeOrder(or_installyn,patient_id,encounter_id,facility_id)
  {
  
	 if(or_installyn=="Y"){
	 
	    var dialogHeight	=	"34"; 
		var dialogWidth		=	"60"; 
		var dialogTop		=	"59";
		var status			=	"no";
		var arguments		=	"" ;

	var action_url	=  "../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&function_from=MO&ord_status=Z&order_by=D&view=C&view_by=L&search_criteria=S&patient_class=&facility_id="+facility_id+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&registration_no="+document.forms[0].srl_no.value+"&requestedModule=MO&deceased_yn=Y&medico_legal_yn=E&postmortem_status=&body_part_yn=&registration_no=&age=&dob=&visit_adm_date=&callingFrom=E"

	//var url="../../eOR/jsp/ExistingOrderResultsFrameset.jsp?patientId="+patient_id+"&function_from=MO&ord_status=Z&order_by=D&view=C&view_by=L&search_criteria=S&patient_class="+patient_class+"&facility_id="+facility_id+"&encntr_id="+encounter_id+"&requestedModule=MO&deceased_yn="+deceased_yn+"&medico_legal_yn="+postmortem_type+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+regstrn_no+"&age="+patient_age+"&dob="+patient_dob+"&visit_adm_date="+visit_adm_date+"&callingFrom=Q";
	     
		var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
		retVal				=	window.showModalDialog(action_url,arguments,features);
		parent.window.close();
	
	  
	 }
  }

 function putLocalLangPatientName(from){  

 
	 var language_direction= document.getElementById("language_direction").value;
	
	 


    var logic = new String();	   
	 logic = document.getElementById("name_drvn_logic_oth_lang").value;

	var pat_name_as_multipart_yn = document.getElementById("pat_name_as_multipart_yn").value;
    var derievedName = new String();
    derievedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;	
	for ( i=0;i<logicElements.length;i++)
    {
		       
        if ( logicElements[i] == '1N' && document.getElementById("first_name_oth_lang")!= null)
        {
			
        
            if ( document.getElementById("first_name_oth_lang").value != '' ){
				if(language_direction=='R'){
					derievedName =  document.getElementById("first_name_oth_lang").value+derievedName ;
				}else{
					derievedName =  derievedName+ document.getElementById("first_name_oth_lang").value  ;
				}
			}
			
        }
        else if ( logicElements[i] == '2N' && document.getElementById("second_name_oth_lang") != null )
        {
            if ( document.getElementById("second_name_oth_lang").value != '' ){
				if(language_direction=='R'){
					derievedName =  document.getElementById("second_name_oth_lang").value+derievedName ;
				}else{
					derievedName =  derievedName+ document.getElementById("second_name_oth_lang").value ;
				}
			}
		
        }
        else if ( logicElements[i] == '3N' && document.getElementById("third_name_oth_lang") != null)
        {
            if ( document.getElementById("third_name_oth_lang").value != '' ){
				if(language_direction=='R'){
					derievedName =  document.getElementById("third_name_oth_lang").value+derievedName ;
				}else{
	                derievedName = derievedName+ document.getElementById("third_name_oth_lang").value ;
				}
			}
		
        }
        else if ( logicElements[i] == 'FN' && document.getElementById("family_name_oth_lang") != null)
        {
            if ( document.getElementById("family_name_oth_lang").value != '' ){
				if(language_direction=='R'){
					derievedName =  document.getElementById("family_name_oth_lang").value+derievedName ;
				}else{
	                derievedName =  derievedName+ document.getElementById("family_name_oth_lang").value ;
				}
			}
			
        }
        else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix_oth_lang") != null)
        {
            if ( (document.getElementById("name_prefix_oth_lang")) && (document.getElementById("name_prefix_oth_lang").value != '') )
            {
                var prefix_loc_lang = document.getElementById("name_prefix_oth_lang").value;
				if(language_direction=='R'){
					derievedName =  prefix_loc_lang +derievedName;
				}else{
	                derievedName =   derievedName+prefix_loc_lang ;
				}		
            }
        }
        else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix_oth_lang") != null)
        {
             if ( document.getElementById("name_suffix_oth_lang").value != '') 
            {
                var suffix_loc_lang = document.getElementById("name_suffix_oth_lang").value;
				if(language_direction=='R'){
					derievedName =   suffix_loc_lang+derievedName;
				}else{
					derievedName =   derievedName + suffix_loc_lang ;
				}
            }
        }
        else
        {
            if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
            {
                var arLen = logicElements[i].length;
                var tempVal = logicElements[i].substring(1,arLen - 1);
                if(derievedName == "")  tempVal="";
				if(language_direction=='R'){
					derievedName =  tempVal+derievedName;
				}else{
	                derievedName = derievedName + tempVal;
				}
            }
		
        }
    
    }

	 
	 	document.getElementById("patient_name_loca_long").value = derievedName;

        
	
	// Brunei CRF for Local Lang Name starts
	/*if(document.getElementById("name_drvn_logic_oth_lang_long")){ 
		var localLongNamelogic = new String();	   
		localLongNamelogic = document.getElementById("name_drvn_logic_oth_lang_long").value;

		var pat_name_as_multipart_yn = document.getElementById("pat_name_as_multipart_yn").value;
		var derivedName = new String();
		derivedName = '';
		var logicElements = new Array();
		logicElements = localLongNamelogic.split('+');
		var i=0;	
		for ( i=0;i<logicElements.length;i++)
		{
				   
			if ( logicElements[i] == '1N' && document.getElementById("first_name_oth_lang")!= null)
			{
				
			
				if ( document.getElementById("first_name_oth_lang").value != '' ){
					if(language_direction=='R'){
						derivedName =  document.getElementById("first_name_oth_lang").value+derivedName ;
					}else{
						derivedName =  derivedName+ document.getElementById("first_name_oth_lang").value  ;
					}
				}
				
			}
			else if ( logicElements[i] == '2N' && document.getElementById("second_name_oth_lang") != null )
			{
				if ( document.getElementById("second_name_oth_lang").value != '' ){
					if(language_direction=='R'){
						derivedName =  document.getElementById("second_name_oth_lang").value+derivedName ;
					}else{
						derivedName =  derivedName+ document.getElementById("second_name_oth_lang").value ;
					}
				}
			
			}
			else if ( logicElements[i] == '3N' && document.getElementById("third_name_oth_lang") != null)
			{
				if ( document.getElementById("third_name_oth_lang").value != '' ){
					if(language_direction=='R'){
						derivedName =  document.getElementById("third_name_oth_lang").value+derivedName ;
					}else{
						derivedName = derivedName+ document.getElementById("third_name_oth_lang").value ;
					}
				}
			
			}
			else if ( logicElements[i] == 'FN' && document.getElementById("family_name_oth_lang") != null)
			{
				if ( document.getElementById("family_name_oth_lang").value != '' ){
					if(language_direction=='R'){
						derivedName =  document.getElementById("family_name_oth_lang").value+derivedName ;
					}else{
						derivedName =  derivedName+ document.getElementById("family_name_oth_lang").value ;
					}
				}
				
			}
			else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix_oth_lang") != null)
			{
				if ( (document.getElementById("name_prefix_oth_lang")) && (document.getElementById("name_prefix_oth_lang").value != '') )
				{
					var prefix_loc_lang = document.getElementById("name_prefix_oth_lang").value;
					if(language_direction=='R'){
						derivedName =  prefix_loc_lang +derivedName;
					}else{
						derivedName =   derivedName+prefix_loc_lang ;
					}		
				}
			}
			else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix_oth_lang") != null)
			{
				 if ( document.getElementById("name_suffix_oth_lang").value != '') 
				{
					var suffix_loc_lang = document.getElementById("name_suffix_oth_lang").value;
					if(language_direction=='R'){
						derivedName =   suffix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName + suffix_loc_lang ;
					}
				}
			}
			else
			{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
				{
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derivedName == "")  tempVal="";
					if(language_direction=='R'){
						derivedName =  tempVal+derivedName;
					}else{
						derivedName = derivedName + tempVal;
					}
				}
			
			}
		
		}

		
			document.getElementById("patient_name_loca_long").value = derivedName;
			
		
	}*/
	// Brunei CRF for Local Lang Name Ends
	
}


function putPatientName(from)  {  

   var logic = new String();

    logic = document.getElementById("name_drvn_logic").value;

	var pat_name_as_multipart_yn = document.getElementById("pat_name_as_multipart_yn").value;

    var derievedName = "";
    derievedName = '';
    var logicElements = new Array();

    logicElements = logic.split('+');
    var i=0;
    for ( i=0;i<logicElements.length;i++)
    {
		if(logicElements[i] == '1N' && document.getElementById("first_name") != null)
        {
            if ( document.getElementById("first_name").value != '' ){
			
                derievedName = derievedName + document.getElementById("first_name").value;
			}
			
        }
        else if ( logicElements[i] == '2N' && document.getElementById("second_name") != null )
        {
		
            if ( document.getElementById("second_name").value != '' )
                derievedName = derievedName + document.getElementById("second_name").value;
        }
        else if ( logicElements[i] == '3N' && document.getElementById("third_name") != null)
        {
		
            if ( document.getElementById("third_name").value != '' )
                derievedName = derievedName + document.getElementById("third_name").value;
        }
        else if ( logicElements[i] == 'FN' && document.getElementById("family_name") != null)
        {
		
	          if ( document.getElementById("family_name").value != '' ){
                derievedName = derievedName + document.getElementById("family_name").value;
			}
		}
        else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix") != null)
        {
            if ( document.getElementById("name_prefix").value != '' )
			{
		
                derievedName = derievedName + document.getElementById("name_prefix").value;
		
			}
        }
        else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix") != null)
        {
		
            if ( document.getElementById("name_suffix").value != '' )
                derievedName = derievedName + document.getElementById("name_suffix").value;
        }
        else
        {
		
            if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
            {
                var arLen = logicElements[i].length;
		
                var tempVal = logicElements[i].substring(1,arLen - 1);
		
				if(derievedName == "")  tempVal="";
				
                derievedName = derievedName + tempVal;
		
            }
        }
    }  
		
	
		
	//Code added by Gomathi.

	/*
	if(document.getElementById("name_prefix") != null)
	{
		if(document.getElementById("name_prefix").value == '')
		{
			
			var s=derievedName.length;
			var temp=derievedName.substring(s);
			var temp1=derievedName.substring(0,s);
			var n=temp1.charCodeAt(0);

			if((n>=65 && n<=91)||(n>=97 && n<=123))
			{
				  derievedName=temp + temp1;
			}
			else
			{		
				 derievedName=temp;
			} 
		}
	}  
	*/
		
	var derievedName1 = derievedName.split(',');
	if(derievedName1[1] == ' ')
	{
	  
		derievedName = 	derievedName1[0];
		
	}
		
    document.getElementById("patient_name").value = derievedName;
	
  
//Brunei CRF for Long Names starts
	if(document.getElementById("name_drvn_logic_long")){  
		var longNamelogic = new String();
		longNamelogic = document.getElementById("name_drvn_logic_long").value;

		var pat_name_as_multipart_yn = document.getElementById("pat_name_as_multipart_yn").value;
		var derivedName = '';
		var logicElements = new Array();
		logicElements = longNamelogic.split('+');
		i=0;
		
		for ( i=0;i<logicElements.length;i++)
		{
			if(logicElements[i] == '1N' && document.getElementById("first_name") != null)
			{
				if ( document.getElementById("first_name").value != '' ){
					derivedName = derivedName + document.getElementById("first_name").value;
				}
				
			}
			else if ( logicElements[i] == '2N' && document.getElementById("second_name") != null )
			{
				if ( document.getElementById("second_name").value != '' )
					derivedName = derivedName + document.getElementById("second_name").value;
			}
			else if ( logicElements[i] == '3N' && document.getElementById("third_name") != null)
			{
				if ( document.getElementById("third_name").value != '' )
					derivedName = derivedName + document.getElementById("third_name").value;
			}
			else if ( logicElements[i] == 'FN' && document.getElementById("family_name") != null)
			{
				  if ( document.getElementById("family_name").value != '' ){
					derivedName = derivedName + document.getElementById("family_name").value;
				}
			}
			else if ( logicElements[i] == 'PR' && document.getElementById("name_prefix") != null)
			{
				if ( document.getElementById("name_prefix").value != '' )
				{
					derivedName = derivedName + document.getElementById("name_prefix").value;
					
				}
			}
			else if ( logicElements[i] == 'SF' && document.getElementById("name_suffix") != null)
			{
				if ( document.getElementById("name_suffix").value != '' )
					derivedName = derivedName + document.getElementById("name_suffix").value;
			}
			else
			{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
				{
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derivedName == "")  tempVal="";

					derivedName = derivedName + tempVal;
				}
			}
		}
		var derivedName1 = derivedName.split(',');
		if(derivedName1[1] == ' ')
		{
			derivedName = 	derivedName1[0];
		}
		
	   document.getElementById("patient_name_long").value = derivedName;
	 
		
   }
	//Brunei CRF for Long Name ends

	
}// End of FUNCTION


function ChangeInitCase(obj){
    var name=obj.value;
    var spltval = name.split(" ") ;
    var temp_name = ""
    for(var i=0;i<spltval.length;i++){
       var length= obj.value.length;
       var letter = spltval[i].substring(0,length-(length-1));
       var rest = spltval[i].substring(1,length);
       letter=letter.toUpperCase();
       rest=rest.toLowerCase();
       var  namenow= letter.concat(rest);
	   temp_name+= namenow+" ";
    }
    obj.value= temp_name.substring(0,temp_name.length-1);
}


function checkPatient(Obj)
       { 
     
	   
			 varSubmitFrame = 'parent.parent.parent.frames[2]'
			if(Obj.value != ''){
	
		      var HTMLVal ="<HTML><BODY><form name='form1' id='form1' method='post' action='../../eMO/jsp/PatNameDisplay.jsp'><input type='hidden' name='pat_id' id='pat_id' value='"+Obj.value+ "'><input type='hidden' name='op_call' id='op_call' value='MO'></form></BODY></HTML>";
			  eval(varSubmitFrame).document.write(HTMLVal);
			   if(eval(varSubmitFrame).document.form1!=null){
				eval(varSubmitFrame).document.form1.submit();							
				}
			} else{ 
			
			var form=document.forms[0];
			 
			     if(form.name_prefix){
	             form.name_prefix.value		  =''
                 form.name_prefix.disabled=false}
				 
				 if(form.first_name){
	             form.first_name.value		  ='';
	             form.first_name.disabled=false}
				 
				 if(form.second_name){
                  form.second_name.value	 ='';
	              form.second_name.disabled=false}
				  
				  if(form.third_name){
                   form.third_name.value	 ='';
	               form.third_name.disabled=false}
				   
			      if(form.third_name_oth_lang){
                  form.third_name_oth_lang.value  ='';
                  form.third_name_oth_lang.disabled=false}
				  
				  if(form.second_name_oth_lang){
	                form.second_name_oth_lang.value  ='';
	                form.second_name_oth_lang.disabled=false}
					
				  if(form.family_name){
	                 form.family_name.value		  =''
	                 form.family_name.disabled=false}
					  
				if(form.name_suffix){
					form.name_suffix.value		  =''
					form.name_suffix.disabled=false}
				
				if(form.first_name_oth_lang){
					form.first_name_oth_lang.value  =''
					form.first_name_oth_lang.disable=false
					}	
				
				if(form.name_suffix_oth_lang){
					form.name_suffix_oth_lang.value =''
					form.name_suffix_oth_lang.disabled=false
					}	
					
				if(form.name_prefix_oth_lang){
					form.name_prefix_oth_lang.value =''
					form.name_prefix_oth_lang.disabled=false
					}		
					
				if(form.family_name_oth_lang){
					form.family_name_oth_lang.value =''
					form.family_name_oth_lang.disabled=false
					}
					
				if(form.requestor_dob){
						form.requestor_dob.value		=''
						form.requestor_dob.disabled=false
						}
						
				if(form.national_id_no){
						form.national_id_no.value       =''
						form.national_id_no.disabled=false
						}	
				
				if(form.other_alt_Id_text){
						form.other_alt_Id_text.value           =''
						form.other_alt_Id_text.disabled=false
						}

				form.patient_name_loca_long.value  =''	
                form.patient_name.value            =''	
				form.national_id_no.value		   ='';
				form.national_id_no.disable        =false
				form.other_alt_Id_text.value       =''
				form.other_alt_Id_text.disabled    =false
				form.other_alt_id.disabled         =false
				form.other_alt_id.options[0].selected=true;
				form.sex.options[0].selected        =true;
			    form.sex.disabled                   =false
			    form.addr_line1.value				='' 
			    form.addr_line2.value				='' 
			    form.addr_line3.value				='' 
			    form.addr_line4.value				='' 
				form.res_town_code.value=''
				form.res_town_desc.value=''
				form.res_area_code.value=''
				form.res_area_desc.value=''
				form.res_region_code.value=''
				form.region_desc.value=''
				form.postal_code.value=''
				form.postals_code.value=''
				form.r_postal_code1.value=''
				form.country_code.value=''
				form.country_desc.value=''
				form.contact1_no.value=''
				form.contact2_no.value=''
				form.email.value=''
				form.mail_addr_line1.value=''
				form.mail_addr_line2.value=''
				form.mail_addr_line3.value=''
				form.mail_addr_line4.value=''
				form.mail_res_town_code.value=''
				form.mail_res_town_desc.value=''
				form.mail_res_area_code.value=''
				form.mail_res_area_desc.value=''
				form.mail_region_code.value=''
				form.mail_region_desc.value=''
				form.mail_postal_code.value=''
				form.m_postal_code12.value=''
				form.mail_country_code.value=''
				form.mail_country_desc.value=''
				
				
	
			 
			 }
		
		
		}



/* function validatePatient(obj) {	
			 
			varSubmitFrame = 'parent.parent.frames[3]'
			
			varBodyFrame = '<%=strBodyFrame%>'

			varAlertYn = '<%=strAlertReqdYn%>'
			varDervnlogic = '<%=strNameDrvnLogic%>'
			varpartname = '<%=strPatNameAsMultiPart%>'
			var vAltId1Type = '<%=AltId1Type%>'
			var vAltId2Type = '<%=AltId2Type%>'
			var vAltId3Type = '<%=AltId3Type%>'
			var vAltId4Type = '<%=AltId4Type%>'
			var vAcceptOtherAltId = '<%=AcceptOtherAltId%>'
		
			var op_call = '<%=op_call%>'
			 
			if(op_call=="reg_pat"||op_call=="ae_reg_pat")
				varSubmitFrame = "parent.parent.frames[2]";
			
			  if(obj.value != '')	{
			//	document.forms[0].change_address.value ="N";
				
				
				
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatIdValidations.jsp'><input type='hidden' name='process_id' id='process_id' value='4'><input type='hidden' name='pat_id' id='pat_id' value='" +obj.value + "'><input type='hidden' name='bodyFrame' id='bodyFrame' value='"+varBodyFrame+"'><input type='hidden' name='submitFrame' id='submitFrame' value='"+varSubmitFrame+"'><input type='hidden' name='name_dervn_logic' id='name_dervn_logic' value='"+varDervnlogic+"'><input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value='"+varAlertYn+"'><input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='"+varpartname+"'><input type='hidden' name='AltId1Type' id='AltId1Type' value='"+vAltId1Type+"'><input type='hidden' name='AltId2Type' id='AltId2Type' value='"+vAltId2Type+"'><input type='hidden' name='AltId3Type' id='AltId3Type' value='"+vAltId3Type+"'><input type='hidden' name='AltId4Type' id='AltId4Type' value='"+vAltId4Type+"'><input type='hidden' name='AcceptOtherAltId' id='AcceptOtherAltId' value='"+vAcceptOtherAltId+"'><input type='hidden' name='op_call' id='op_call' value='"+op_call+"'></form></BODY></HTML>";
				
//			eval(varSubmitFrame).document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				eval(varSubmitFrame).document.write(HTMLVal);					
						
				if(eval(varSubmitFrame).document.form1!=null){
				eval(varSubmitFrame).document.form1.submit();							
				}
				parent.parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num="
		//		if(op_call != "reg_pat" && op_call != "ae_reg_pat"){
		//		localValidations(obj.value);
		//		}

			}else{
				document.forms[0].change_address.value ="Y";
				if(document.getElementById("past_visits"))
				document.forms[0].past_visits.disabled=true;
				if(document.getElementById("last_visits"))
				document.forms[0].last_visits.disabled=true;
				if(document.getElementById("other_id1"))
					document.getElementById("other_id1").style.visibility='hidden';
				
				clearAll();	
				
				
			}
			
		}*/


		
		
		
function Modal_Contact_Details(obj)
{
		
		var retVal =    new String();
		var dialogHeight= "23" ;
		var dialogWidth = "50" ;
		
		/*Below line added for ML-MMOH-CRF-0860.2*/
		if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){
		 dialogHeight= "35" ;
		 dialogWidth = "65" ;
		}
		//End ML-MMOH-CRF-0860.2
		
		var status = "no";
		var patient_id = document.forms[0].requestor_id.value
		
		var concat_address_hidden=document.forms[0].addr1_type.value +"^^"
		+document.forms[0].addr_line1.value						+"^^"
		+document.forms[0].addr_line2.value						+"^^"
		+document.forms[0].addr_line3.value						+"^^"
		+document.forms[0].addr_line4.value						+"^^"
		+document.forms[0].res_town_code.value			    +"^^"
		+document.forms[0].res_area_code.value				+"^^"
		+document.forms[0].postal_code.value				+"^^"
		+document.forms[0].res_region_code.value			+"^^"
		+document.forms[0].country_code.value				+"^^"
		+document.forms[0].contact1_name.value				+"^^"
		+document.forms[0].invalid1_yn.value				+"^^"
		+document.forms[0].addr2_type.value					+"^^"
		+document.forms[0].mail_addr_line1.value			+"^^"
		+document.forms[0].mail_addr_line2.value			+"^^"
		+document.forms[0].mail_addr_line3.value			+"^^"
		+document.forms[0].mail_addr_line4.value			+"^^"
		+document.forms[0].mail_res_town_code.value	+"^^"
		+document.forms[0].mail_res_area_code.value	+"^^"
		+document.forms[0].mail_postal_code.value	    +"^^"
		+document.forms[0].mail_region_code.value		+"^^"
		+document.forms[0].mail_country_code.value+"^^"
		+document.forms[0].contact2_name.value		+"^^"
		+document.forms[0].invalid2_yn.value +"^^"
		+document.forms[0].contact1_no.value +"^^"
		+document.forms[0].contact2_no.value +"^^"
		+document.forms[0].email.value +"^^"
		+document.forms[0].change_address.value +"^^"
		+document.forms[0].res_town_desc.value +"^^"
		+document.forms[0].res_area_desc.value +"^^"
		+document.forms[0].region_desc.value +"^^"
		+document.forms[0].mail_res_town_desc.value +"^^"
		+document.forms[0].mail_res_area_desc.value +"^^"
		+document.forms[0].mail_region_desc.value +"^^"
		+document.forms[0].country_desc.value +"^^"
		+document.forms[0].mail_country_desc.value+"^^"
		+document.forms[0].r_postal_code1.value+"^^"
		+document.forms[0].m_postal_code12.value ;


		var arguments	=concat_address_hidden;
		
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;  
		
		retVal = window.showModalDialog( "../../eMO/jsp/MOContactDetailsFrame.jsp?AE_YN=Y&patient_id="+patient_id,arguments,features);
 
		if(retVal != null)
		{  
		 	document.forms[0].concat_address_hidden.value=retVal;
			var arr_concat_vals=retVal.split("^^");
			document.forms[0].addr1_type.value					= arr_concat_vals[0];
			document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
			document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
			document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
			document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
			document.forms[0].res_town_code.value			= arr_concat_vals[5]; 
			document.forms[0].res_area_code.value				= arr_concat_vals[6]; 
			document.forms[0].postal_code.value					= arr_concat_vals[7]; 
			document.forms[0].res_region_code.value					= arr_concat_vals[8]; 
			document.forms[0].country_code.value				= arr_concat_vals[9]; 
			document.forms[0].contact1_name.value			= arr_concat_vals[10]; 
			document.forms[0].invalid1_yn.value				= arr_concat_vals[11]; 

			document.forms[0].addr2_type.value					= arr_concat_vals[12]; 
			document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
			document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
			document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
			document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; 
			document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; 
			document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; 
			document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; 

			document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; 
			document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; 

			document.forms[0].contact2_name.value		=  arr_concat_vals[22]; 
			document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; 

			document.forms[0].contact1_no.value		=  arr_concat_vals[24];
			document.forms[0].contact2_no.value		=  arr_concat_vals[25];
			document.forms[0].email.value		=  arr_concat_vals[26];
			document.forms[0].change_address.value  = 'Y';

			document.forms[0].res_town_desc.value =arr_concat_vals[27];
		   document.forms[0].res_area_desc.value =arr_concat_vals[28];
		   document.forms[0].region_desc.value =arr_concat_vals[29];

		   document.forms[0].mail_res_town_desc.value =arr_concat_vals[30];
		   document.forms[0].mail_res_area_desc.value =arr_concat_vals[31];
		   document.forms[0].mail_region_desc.value =arr_concat_vals[32];
		    document.forms[0].country_desc.value =arr_concat_vals[33];
		   document.forms[0].mail_country_desc.value =arr_concat_vals[34];
		   document.forms[0].r_postal_code1.value =arr_concat_vals[35];
		   document.forms[0].m_postal_code12.value =arr_concat_vals[36];

	}
}

function checkPrefix()
{
	var prefix_value = '';
	if(document.getElementById("name_prefix1") != null)
	{
		prefix_value = document.getElementById("name_prefix1").value;
		document.getElementById("name_prefix").value = document.getElementById("name_prefix1").value;
	}
	
	var gender = document.getElementById("sex").value;
	if(prefix_value != '' && gender != '')
	{
		var prefix_check = "Y";
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH prefix_value=\""+prefix_value+"\" gender=\""+gender+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMP/jsp/natAltIDComponentPrefixCheck.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(eval(responseText)==1)
		{
			

			var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
			if(localeName=='en')
			{
			msg = msg.replace('$',document.getElementById("name_prefix_prompt").value);
			}else
			{
			msg = msg.replace('$',document.getElementById("name_prefix_oth_prompt").value);
			}

			alert(msg);
			document.getElementById("name_prefix1").value="";
		}
	}
}

function enableAltID(){
					
					 
			 document.forms[0].other_alt_Id_text.value="";
				if(document.forms[0].other_alt_id.selectedIndex != 0){
					document.forms[0].other_alt_Id_text.disabled = false;
					document.forms[0].other_alt_Id_text.value="";
				}
				else 
					document.forms[0].other_alt_Id_text.disabled = true;
			
			}
function showResult(srlno,patient_id,app_id,function_id,facilityid){	 
	
		if(function_id =="EMBALM"){
			parent.frames[1].location.href="../../eMO/jsp/MOEmbalmFrames.jsp?mode=modifiy&srl_no="+srlno+"&patient_id="+patient_id+"&app_id="+app_id;	 
	    }else{
				sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID='MOEMBSER'";		
				var reportParamNames = "p_facility_id,P_SRL_NO,P_PATIENT_ID";
				var reportParamValues = ""+facilityid+","+srlno+","+patient_id+"";			
				 var dialogHeight    = '30' ;
				 var dialogWidth = '70' ;
				 var dialogTop = '65';
				 var arguments =   ''; 			
				 var getUrl        =  "../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MOINTERNALREPORT&step=1&sqlString="+escape(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_id;
				 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;
				 retVal            =   window.showModalDialog(getUrl,arguments,features); 
		}
	}			
function validateCheckbox(obj){
   if(obj.name=='embalmcomplete'){	 
	  if(obj.checked){
		  document.forms[0].embalmcomplete.value='Y'
		  document.forms[0].cancelembalm.checked=false
		  document.forms[0].cancelReson.disabled=true
	  }
   }else if(obj.name=='cancelembalm'){	
      if(obj.checked){
		  document.forms[0].cancelembalm.value='Y'	
		  document.forms[0].cancelReson.disabled=false	
		  document.forms[0].embalmcomplete.checked=false 
	  }else{
	    document.forms[0].cancelembalm.value='N'
	    document.forms[0].cancelembalm.checked=false
	    document.forms[0].cancelReson.options[0].selected=true
	    document.forms[0].cancelReson.disabled=true
	   }	
  }else if(obj.name=='home_embal') {
	   if(obj.checked){
			document.forms[0].home_embal.value='Y'
			document.forms[0].hospital_embal.checked=false
	   }else{
		   document.forms[0].home_embal.value='N'
		   document.forms[0].hospital_embal.checked=true
	  }
  }else if(obj.name=='hospital_embal'){
		if(obj.checked){
			 document.forms[0].hospital_embal.value='Y'
			 document.forms[0].home_embal.checked=false
		 }else{
			 document.forms[0].hospital_embal.value='N'
			 document.forms[0].home_embal.checked=true
		 } 
   }else if(obj.name=='hiv_yn'){
	      if(obj.checked==false) { 
			 document.forms[0].hiv_yn.value='N'
		  }else{
			  document.forms[0].hiv_yn.value='Y'
		  }
   }else if(obj.name=='hep_yn'){
	       	if(obj.checked==false){
			  document.forms[0].hep_yn.value='N'
			 }else{
				 document.forms[0].hep_yn.value='Y'
			 }
   } 

}

 
 
 function timeValidation(Obj){ // 1

   if (Obj.value!=''){ //2
	if (chkTime(Obj.value)==false || checkColon(Obj.value)==false ){ //3
		var errors= getMessage("INVALID_TIME_FMT","SM");
		 alert(errors);
		Obj.value='';
		Obj.focus();
	}
 }
 
 if (Obj.value=="00:00" || Obj.value=="00:0" )
  { 

   eval("document.forms[0]."+Obj.name).value="";
   alert( getMessage("CANNOT_BE_ZERO","Common"));
 }
}


function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23)
			{
				if(time1min>59)
				{
						retval=false;
				}
			}
			else
					retval=false;
		}
		else
			retval=false;
	}
	else
			retval=false;

	return retval
}

function checkColon(dt){
 
 charAtpos3=dt.charAt(2);
 
 if (charAtpos3 == ':')
   return true;
	 else
   return false;
 
}

function Zerocheck(obj)
{
 

        var sttime= document.forms[0].embalm_from_time.value;
        var edtime= document.forms[0].embalm_to_time.value;
		//var schedule_time=document.forms[0].scheduletime.value;
		
		
        var fromarray      = sttime.split(":") ;
		var toarray        = edtime.split(":") ;
       // var schedulearray  =schedule_time.split(":") ;
		
		
		var fromtime = new Date(1,1,1,fromarray[0],fromarray[1],0,0) ;
		var totime   = new Date(1,1,1,toarray[0],toarray[1],0,0) ;
	   
		 if(fromtime>=totime)
		 {
		 
	 	 alert(getMessage("TO_TM_CANT_GR_FROM_TM","OA"))
		 }
	 
		

}

function onSuccess(error,error_value)
{
 
    parent.parent.frames[1].location.reload();
  parent.parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+error;

}

function DeciValidate(obj)
 {
   
   if(obj.value !="")
     {
	   value=obj.value;
	    index=value.indexOf(".");
	
	     if(obj.value=='.0' || obj.value=='0.0' || (index == obj.value.length-1))
		 {
		
			var error = getMessage('INVALID_VALUE','Common');
			error = error.replace('#',getLabel("Common.Value.label","Common"));
			alert(error);			 	         
		    document.forms[0].embalm_fluid_qty.value=''
		    document.forms[0].embalm_fluid_qty.focus();
		
	     }
		
	 
	 }
 
 }

