// GLOBAL Variables 
   var LocalErrors = new String();
   var multipleclicks='false';
   var dis_list = new Array();

   var pat_sergrp_id_types = new Array () ;
   var pat_name_in_loc_lang = new Array () ;
   var pat_sergrp_reqd_yn = new Array ();
   var def_series = new Array ();

   var i=0 ;
   var original_vals = new Array();
   var doValidation = new Boolean();
   doValidation = false;
   var dataFetchedFromRepos='N';
   var dataFetchedFromRepos1='N';
   var dataFetchedFromRepos2='N';
   var dataFetchedFromRepos3='N';
   var dataFetchedFromRepos4='N';
   
   

// ***********************************************************************
function home()
{
}

//***************************************************************************
function moveToTab(TabIndex)
{
	
	var bookmarkToMove;
    if ( TabIndex == 1 )
	{        
		document.getElementById("demo").scrollIntoView();
		if(document.getElementById("pat_ser_grp_code")!=null)
			if(document.getElementById("pat_ser_grp_code").disabled ==false)
		document.getElementById("pat_ser_grp_code").focus();
	}
	else if ( TabIndex == 2 )
	{
            document.getElementById("addr").scrollIntoView();

	}
    else if ( TabIndex == 3 )
	{		   
	  if(document.getElementById("next_contact_name")!=null && document.getElementById("next_contact_name.disabled==false) 
	   document.getElementById("next_contact_name").focus();	
	   document.getElementById("kin").scrollIntoView();
	   document.getElementById("firstkin1").className='tabA';
	   document.getElementById("firstkin1span").className='tabAspan';
	   document.getElementById("firstempyr").className='tabA';   
	   document.getElementById("firstempyrspan").className='tabAspan';  
	}
	else if ( TabIndex == 4 )
	{
            if(document.getElementById("misc"))
			document.getElementById("misc").scrollIntoView();
	}
    else if ( TabIndex == 5 )
	{
		document.getElementById("fin").scrollIntoView();
	}
	else if ( TabIndex == 6 )
	{
            document.getElementById("pat_docs_tab").scrollIntoView();
	}
    else if ( TabIndex == 7 )
	{
            document.getElementById("add_mod_dtl").scrollIntoView();
	}
	else if ( TabIndex == 8 )
	{ 
		 document.getElementById("ancParent_det").scrollIntoView();
	}
}


// ***********************************************************************
async function print() 
{
    var retVal =    new String();
    var dialogHeight    = "10" ;
    var dialogWidth = "70" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no; ";
    var arguments   = "" ;
    retVal =await window.showModalDialog("../../eCommon/jsp/InternalReportsReprint.jsp?module_id=MP&step=0&target=step4",arguments,features);
    // Assuming that the window is closed after selecting to PRINT WINDOW ....
    if ( retVal == "WP" )
        f_query_add_mod.print();
}
// ***********************************************************************
function create() { 
	alert(" Inside Create 1");
    f_query_add_mod.location.href = "../../eMP/jsp/PatRegLoad.jsp?calledFromModule=MP";
    alert(" Inside Create 2");
}
// ***********************************************************************
function edit() {
}
// ***********************************************************************
function query() {
 var url = PatientSearch('','','','','','','','N','Y','Patreg');

    if(url)
    {
          f_query_add_mod.location.href=url;
    }
}

function query_search() {
	alert("Inside Query Search Function");
 var url = PatientSearch('','','','','','','','N','Y','Patreg');

    if(url)
    {
           parent.f_query_add_mod.location.href=url;
    }
}
// ***********************************************************************
function CheckForNumber_l(Objval) {
        val = Objval.value;

    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            Objval.select();
            Objval.focus();
            return false;

        }
}
//**************************************************************************


function enableFields()
{
     for(i=0;i<dis_list.length;i++)
     {
         if(dis_list[i] != null)
            dis_list[i].disabled = true
     }
}
function reset(){
	if(f_query_add_mod.patient_sub != null) {	
		  f_query_add_mod.location.reload();
	      if (f_query_add_mod.patient_sub.document.getElementById("func_act").value != '' || f_query_add_mod.patient_sub.document.getElementById("appt_yn").value == 'Appt') {					
			  f_query_add_mod.location.href = frames[1].location.href; // Code added for incident IN022749 by Suresh M on 20-July-2010.
			  setTimeout("disableHome()", 100);
		  } 
	}	
}
// ***********************************************************************
function help() {
}
// ***********************************************************************
function setDate(Object)    { // function to set either Date of Birth or Day Month Age
var l_days = document.getElementById("b_days").value;
var l_months = document.getElementById("b_months")").value;
var l_age = document.getElementById("b_age").value;
var currentDate = new Date();

if ( Object.name == 'date_of_birth' )
{

    if (!validDate(document.getElementById("date_of_birth").value,"DMY",localeName))
    {
        document.getElementById("date_of_birth").focus();
    }
    else
    {

        var today = new Date();

        if (isBeforeNow(Object.value,"DMY",localeName) )
        {
            sendToServer(1);
        }
        else
        {
            if(!Obj.readOnly)
            {
                alert(getMessage("DOB_GREATER",'MP'));
				Object.value="";
                Object.focus();
            }
        }
    }
} // END OF DOB CHECK
// -----------------------------------------------------------------------------
if ( Object.name == 'b_age' )
{
    if ( l_age > 0)
    {
        if ( (l_months == '' || l_months == 0 ) && ( l_days == '' || l_days == 0) )
            document.getElementById("date_of_birth").value='01/01/'+(currentDate.getFullYear()-l_age);

        if ( l_months != '' && l_days == '' && l_months > 0 )
            document.getElementById("date_of_birth").value='01/'+l_months+'/'+(currentDate.getFullYear()-l_age);
    }
    else if ( l_age < 0)
    {

        alert(getMessage("AGE_LESS_ZERO",'MP'))
        Object.value = 0;
        Object.focus();
    }
}

// -----------------------------------------------------------------------------------

if (  Object.name == 'b_months' )
{
    if ( l_months > 11 )
    {
        alert(getMessage("MONTH_GREATER_11",'MP'))
        Object.value = 0;
        Object.focus();
    }
    else if ( l_months <= 11 &&  l_months != '')
    {
        if ( l_months != '' && l_age != '' && l_days == '' )
        {
            if ( l_months <= 12 && l_months > 0 )
                    document.getElementById("date_of_birth").value='01/'+l_months+'/'+(currentDate.getFullYear()- l_age);
        }

    if ( ( l_months == '' || l_months == '0' )&& l_age != '' && l_days == '' )
            document.getElementById("date_of_birth").value='01/01/'+(currentDate.getFullYear()-l_age);

    if ( l_days == '0' && l_months != '0' && l_days == '0' )
        sendToServer(2);

    }
}
// --------------------------------------------------------------------------------

if ( Object.name == 'b_days' )
{
    if ( l_days != '' && l_days <= 31 && l_months != '' && l_age != '' && l_days > 0 )
    {
            document.getElementById("date_of_birth").value='';
            sendToServer(2);
    }
    else if ( l_days == '' && l_age != '' && l_months != '' && l_months > 0 && l_months <= 11 )
            document.getElementById("date_of_birth").value='01/'+l_months+'/'+(currentDate.getFullYear()-l_age);

    else if ( l_days == '' && l_age != '' && l_months == '' )
            document.getElementById("date_of_birth").value='01/01'+'/'+(currentDate.getFullYear()-l_age);
    else if ( l_days > 31 )
    {
        alert(getMessage("DAYS_GREATER_31",'MP'))
        Object.focus();
    }
    else if ( ( l_months == '' || l_months == '0' )&& l_age != '' && l_days == '' )
        document.getElementById("date_of_birth").value='01/01/'+(currentDate.getFullYear()-l_age);
    else if ( l_days == '0' && l_months != '0' && l_days == '0' )
        sendToServer(2);
}

if ( document.getElementById("b_days").value == '0' &&  document.getElementById("b_months").value == '0' &&             document.getElementById("b_age").value == '0' )
    document.getElementById("date_of_birth").value = document.getElementById("ServerDate").value ;
}// END OF THE FUNCTION

// ***********************************************************************
function gotoNext(Obj)  {  
		var dateVal = Obj.value;
		if ( Obj == document.getElementById("date_of_birth")  ||  Obj == document.getElementById("birth_date") || Obj == document.getElementById("contact1_birth_date") || Obj == document.getElementById("b_time"))
		{
            		
			 if(Obj.value == '') {

				 if(Obj == document.getElementById("contact1_birth_date")) {
					if(document.getElementById("contact1_birth_date"))
						document.getElementById("contact1_birth_date").value='';
				 }				 				             
			    /*Below Code Addded by Senthil on 01-Nov-2011 [SKR-SCF-0112]*/
                if(document.getElementById("date_of_birth").value==""){                 				
                        document.getElementById("b_age").value='';					 
						document.getElementById("b_months")").value='';					 
						document.getElementById("b_days").value='';					 
						document.getElementById("b_hours").value='';
						document.getElementById("b_time").value='';
			   }
               /*End*/			   
			 }
			 //Modified for IN:047815
			var tmpDate = formatDate(document.getElementById("date_of_birth").value,"DMY","DMY",localeName); 
			var todayDate = getCurrentDate("DMY",localeName);
			
				
			if(Obj == document.getElementById("b_time")) { 
				if (!validDate(Obj.value,"HM",localeName))
				{   	
					if(Obj.value != "")
					{
						alert(getMessage("INVALID_TIME_FMT", "SM"));
						Obj.select();					
					}
				}
				else
				{   	
					if((document.getElementById("date_of_birth").value!="")){
						//Modified for IN:047815
						//if(document.getElementById("date_of_birth").value == getCurrentDate("DMY",localeName)){
						if(tmpDate == todayDate){
							if(isBeforeNow(dateVal,"HM",localeName)){
								sendToServer(1,Obj);			 	
							}else{
							 if(!Obj.readOnly){
								alert(getMessage("BIRTH_TIME_GREATER_SYSTIME",'MP'));
								Obj.value="";
								Obj.focus();								
							  }	
						   }
					    }else{
							sendToServer(1,Obj);
						}			  							
				    }else{ 	
						if(isBeforeNow(dateVal,"HM",localeName)){
							sendToServer(1,Obj);						
						} else{
							 if(!Obj.readOnly){
								alert(getMessage("BIRTH_TIME_GREATER_SYSTIME",'MP'));
								Obj.value="";
								Obj.focus();							
							  }			
						}						
					}					
				}
				//Making age, months, days field as empty if DOB is empty or today's date  
				//Making hours field as empty if DOB is empty or today's date and birth time is empty 
				if(document.getElementById("date_of_birth").value == "" || tmpDate == todayDate)
				{
					document.getElementById("b_age").value='';					 
					document.getElementById("b_months")").value='';					 
					document.getElementById("b_days").value='';
					if(document.getElementById("b_time").value == "")
					{
						document.getElementById("b_hours").value='';					
					}
				}
			}else{	
				//IN:047815 - if DOB is today's Date, then it is checking if birthtime is greater than sys time.			
				if(tmpDate == todayDate && document.getElementById("b_time").value != ""){
					if(!isBeforeNow(document.getElementById("b_time").value,"HM",localeName)){
					 if(!document.getElementById("b_time").readOnly){
						alert(getMessage("BIRTH_TIME_GREATER_SYSTIME",'MP'));
						document.getElementById("b_time").value="";
						document.getElementById("b_hours").value='';
						document.getElementById("b_time").focus();								
					  }	
				   }
				}
						
				if (!validDate(Obj.value,"DMY",localeName)){
					if(Obj.value != ""){
						alert(getMessage("INVALID_DATE_FMT", "SM"));
						document.getElementById("invalid_dob").value="Y";    //MMS-QH-CRF-0145
						Obj.select();
					}else{
						document.getElementById("invalid_dob").value="N";   //MMS-QH-CRF-0145
					}
				}else{					
					if(document.getElementById("b_time").value!="" && isAfterNow(document.getElementById("b_time").value,"HM",localeName) && dateVal == getCurrentDate("DMY",localeName)){ 
						if(!Obj.readOnly){
							alert(getMessage("DOB_GREATER",'MP'));
							Obj.value="";
							Obj.focus();							
						}						
					}else{ 
					 if(isBeforeNow(dateVal,"DMY",localeName)){					
						 if(Obj != document.getElementById("contact1_birth_date")){
							sendToServer(1,Obj);		
						 }
					 }else{ 
						if(!Obj.readOnly){
							alert(getMessage("DOB_GREATER",'MP'));
							Obj.value="";
							Obj.focus();
							
						}
					 }
				   }
				}
			}
		} else if ( Obj == document.getElementById("b_days") )	{
           		
			if (Obj.value.length > 0)
			{
				if (CheckForNumber_l(Obj) == true )
				{
					if ( Obj.value > 31 )
					{
						alert(getMessage("DAYS_GREATER_31",'MP'));
						Obj.focus();
						doValidation=false;
					}
					else
						sendToServer(2);
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		} else if ( Obj == document.getElementById("b_months")") ) {
				
			if (Obj.value.length > 0)
			{
				if (CheckForNumber_l(Obj) == true )
				{
					if ( Obj.value > 11 )
					{
						alert(getMessage("MONTH_GREATER_11",'MP'));
						Obj.focus();
					}
					else
						sendToServer(2);
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		} else if ( Obj == document.getElementById("b_age") )	{
            		
			if (Obj.value.length > 0) {
							
				if (CheckForNumber_l(Obj) == true)	{

					if ( Obj.value < 0)	{
						alert(getMessage("AGE_LESS_ZERO",'MP'));
						Obj.focus();
					} else if ( Obj.value == '') {						
						Obj.value = 0;
					} else {
						sendToServer(2);
					}
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}
		}
		else if ( Obj == document.getElementById("b_hours") )
		{ 		
			display_new_born_age_in_hrs = parseInt(document.getElementById("display_new_born_age_in_hrs").value);
			
			val = parseInt(Obj.value);
			
			if (Obj.value.length > 0)
			{
					
				if (CheckForNumber_l(Obj) == true)
				{
					
					if ( Obj.value < 0)
					{
						alert(getMessage("AGE_LESS_ZERO",'MP'));
						Obj.focus();
					}
					else if(val>display_new_born_age_in_hrs)
					{
						alert(getMessage("AGE_EXCEEDS_MPPARAM_VAL",'MP'));
						Obj.value="";
						Obj.focus();
					}
					else if ( Obj.value == '')
					{
						Obj.value = 0;
					}
					else
					{
						sendToServer(2);
					}
				}
			} else {
				if(Obj.value=="") {
					sendToServer(2);
				} else {
					doValidation=false;			
				}
			}

		}
		
} // END OF THE FUNCTION
// ***********************************************************************


function sendToServer(Val,areaobj)  {
	
	//Commented by Sethu on 17/07/2023 for Edge Compatibility
	/*
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	var xmlStr ="<root><SEARCH ";

var HTMLVal = new String();
if ( Val == 1 )
{
	var date_of_birth = "";
	var birthDate = "";
	
	var cur_month = "";
	var cur_hours = "";
	var cur_mins = "";
	
	var cur_date = new Date();
	
	
	
	if(areaobj.name=='b_time') {	
        locale = document.forms[0].locale.value;
		v_b_time = document.getElementById("b_time").value;	
		bir_date = document.getElementById("date_of_birth").value;	

		if(bir_date=="") {		
			cur_month = cur_date.getMonth()+1;
			date_of_birth = cur_date.getDate()+"/"+cur_month+"/"+cur_date.getFullYear()+" "+v_b_time+":00";	
			birthDate = cur_date.getDate()+"/"+cur_month+"/"+cur_date.getFullYear();
		}
		else {
			date_of_birth = bir_date+" "+v_b_time+":00";	
			birthDate = bir_date;
		}
/*
		if(locale!='en') {
			birthDate = convertDate(birthDate,"DMY","en",locale);
			date_of_birth = convertDate(date_of_birth,"DMYHMS","en",locale);			
		}		
*/
	}
	else if(areaobj.name=='date_of_birth') {
		var dob = document.getElementById("date_of_birth").value;	
		b_time = document.getElementById("b_time").value;
		if(b_time=="") {
			//cur_hours = cur_date.getHours();
			//cur_mins = cur_date.getMinutes();		
			date_of_birth = dob+" 00:00:00";	
		} else {
			date_of_birth = dob+" "+b_time+":00";
		}
		birthDate = document.getElementById("date_of_birth").value;	
	}
	else {
		date_of_birth = document.getElementById("date_of_birth").value;
		birthDate = document.getElementById("date_of_birth").value;	
	}

	
	var patient_deceased_yn = "N";
	var patient_deceased_date = "";
	if(document.getElementById("CalledFromFunction").value == 'ChangePatDtls') {
		if(document.getElementById("patient_deceased_yn"))
			patient_deceased_yn = document.getElementById("patient_deceased_yn").value;
		if(document.getElementById("patient_deceased_date"))
			patient_deceased_date = document.getElementById("patient_deceased_date").value
		locale = document.getElementById("locale").value;
			

		if((patient_deceased_yn == 'Y')&&(date_of_birth != "")){			
			if(isBefore(date_of_birth,patient_deceased_date,"DMYHMS",locale)==false)
			{			
				var str  = getMessage("CANNOT_GREATER","MP");
				str  = str.replace('#', getLabel('Common.birthDate.label','Common')+" "+getLabel('Common.time.label','Common'));
				str  = str.replace('$', getLabel('Common.DeceasedDate.label','Common')+" "+getLabel('Common.time.label','Common'));				
				alert(str);				
				areaobj.select();
				return;
			}				
		}
	}	 
	
	xmlStr+=" process_id=\"1\" ";
	xmlStr+=" date_of_birth=\""+date_of_birth+"\"";
	xmlStr+=" patient_deceased_date=\""+patient_deceased_date+"\"";
	xmlStr+=" patient_deceased_yn=\""+patient_deceased_yn+"\"";
	xmlStr+=" birthDate=\""+birthDate+"\"";
	xmlStr+=" obj_name=\""+areaobj.name+"\"";
	xmlStr +=" /></root>";
	
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
	//  ALPHA-PAS-Unable to register the patient [IN:036348] 
	if(document.getElementById("Birth_Date").value == "" || document.getElementById("Birth_Date").value == null){
		//	document.getElementById("Birth_Date").value = document.getElementById("date_of_birth.value;
			document.getElementById("Birth_Date").value = date_of_birth;
	}//	 ALPHA-PAS-Unable to register the patient [IN:036348] 
}																											
if ( Val == 14 )
{
	var a_ethnic_group_code = "";

	/****** when called from Register Patient Function *******/
	if(document.getElementById("a_ethnic_group_code") != null)
	{
		a_ethnic_group_code = document.getElementById("a_ethnic_group_code").value
	}
	/****** end *******/

	xmlStr+=" process_id=\"14\" ";
	xmlStr+=" race_code=\""+document.getElementById("race_code").value+"\"";
	xmlStr+=" a_ethnic_group_code=\""+a_ethnic_group_code+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
if ( Val == 15 )
{
	xmlStr+=" process_id=\"15\" ";
	xmlStr+=" occ_class=\""+document.getElementById("occ_class").value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
if ( Val == 2 )
{
	var age = document.getElementById("b_age").value;
	var months = document.getElementById("b_months").value;
	var days = document.getElementById("b_days").value;
	var hours = document.getElementById("b_hours").value;	

	if(age!="" || months!="" || days!="" || hours!="") {

		xmlStr+=" process_id=\"2\" ";
		xmlStr+=" b_age=\""+age+"\"";
		xmlStr+=" b_months=\""+months+"\"";
		xmlStr+=" b_days=\""+days+"\"";
		xmlStr+=" b_hours=\""+hours+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eMP/jsp/ServerValidationXML.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		// crf MMS-QH-CRF-0145
		if(document.getElementById("hij_appl_YN").value=='Y'){
			
			calc_hij(document.getElementById("date_of_birth")); 
		}
		// crf MMS-QH-CRF-0145
	} else {
		document.getElementById("date_of_birth").value = "";	
		document.getElementById("b_time.value = "";
		document.getElementById("Birth_Date").value = "";
		// crf MMS-QH-CRF-0145
		if(document.getElementById("hij_appl_YN").value=='Y'){
			
			document.getElementById("date_of_birth_hj").value="";
		}
		// crf MMS-QH-CRF-0145
	}	
}

if ( Val == 3 )
{
	xmlStr+=" process_id=\"3\" ";
	xmlStr+=" b_age=\""+document.getElementById("b_age").value+"\"";
	xmlStr+=" b_months=\""+document.getElementById("b_months").value+"\"";
	xmlStr+=" b_days=\""+document.getElementById("b_days").value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

if ( Val == 4 )
{
	var varLength = new String();
    varLength = document.getElementById("family_link_no").value;
    varLength = varLength.length;
    if ( varLength > 0 )
    {
        if ( varLength == document.getElementById("family_link_no").maxLength)
        {
            if ( document.getElementById("family_link_no").value == document.getElementById("patient_id").value )
            {
                alert(getMessage("HEAD_PAT_SAME_AS_PAT",'MP'));
                document.getElementById("family_link_no").focus();
            }
            else
            {

				xmlStr+=" process_id=\"4\" ";
				xmlStr+=" family_link_no=\""+document.getElementById("family_link_no").value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);				
			}            
        }
        else
        {
            var val = getMessage("HEAD_PATID_CHAR",'MP');
            val = val.replace("@",document.getElementById("family_link_no").maxLength)
            alert(val)
            document.getElementById("family_link_no").focus();
        }
    }
    else if ( varLength == 0 )
    {	/*If Membership type exixts do not clear relationship*/
		document.getElementById("head_pat_name").innerText = "";
		if (document.getElementById("family_org_id_accept_yn").value=='N')
        {
			if(document.getElementById("relationship_to_head_desc") != null)
			{
				document.getElementById("relationship_to_head").value = "";
				document.getElementById("relationship_to_head_desc").value = "";
				document.getElementById("relationship_to_head_desc").disabled = true;
				document.getElementById("relationship_to_head_code_id").disabled = true;
			}
		}
		else
		{		   
			if(document.getElementById("relationship_to_head_desc") != null)
			{
			   if (document.getElementById("family_org_membership")
			   {
				if (document.getElementById("family_org_membership").value ==1 )
				{
					
					document.getElementById("relationship_to_head").value = document.getElementById("org_member_relationship_code").value;
					document.getElementById("relationship_to_head_desc").disabled=true;
					document.getElementById("rel.style").visibility=='hidden';
					document.getElementById("relationship_to_head_code_id").disabled = true;
				}
				else
				if ( (document.getElementById("family_org_membership").value ==2 ) || (document.getElementById("family_org_membership").value ==3 ) )
				{
					document.getElementById("relationship_to_head").value ='';
					document.getElementById("relationship_to_head_desc").value ='';
					document.getElementById("rel.style").visibility=='visible';
					document.getElementById("relationship_to_head_desc").disabled = false;
				}
				else
				{
					document.getElementById("rel.style").visibility=='hidden';
					document.getElementById("relationship_to_head").value = '';
					document.getElementById("relationship_to_head_desc").value = '';
					document.getElementById("relationship_to_head_desc").disabled = true;
					document.getElementById("relationship_to_head_code_id").disabled = true;
				}
			}
		 }
		}
    }
}
if ( Val == 7 )
{

        if(areaobj.value !='')
        {
           
			xmlStr+=" process_id=\"7\" ";
						
			var mode =areaobj.name
			
			if (mode=="r_region_code")
				xmlStr+=" region_code=\""+document.getElementById("r_region").value+"\"";
				
			if( mode=="m_region_code")
				xmlStr+=" region_code=\""+document.getElementById("m_region").value+"\"";
				
			if( mode=="contact1_region_code")
				xmlStr+=" region_code=\""+document.getElementById("n_region").value+"\"";
				
			if( mode=="contact2_region_code")
				xmlStr+=" region_code=\""+document.getElementById("f_region").value+"\"";
				
			if( mode=="contact3_region_code")
				xmlStr+=" region_code=\""+document.getElementById("e_region").value+"\"";
				
			if (mode=="r_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("r_area").value+"\"";
				
			if( mode=="m_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("m_area").value+"\"";
				
			if( mode=="contact1_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("n_area").value+"\"";
				
			if( mode=="contact2_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("f_area").value+"\"";
				
			if( mode=="contact3_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("e_area").value+"\"";
				
			if (mode=="r_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("r_town").value+"\"";
				
			if( mode=="m_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("m_town").value+"\"";
				
			if( mode=="contact1_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("n_town").value+"\"";
				
			if( mode=="contact2_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("f_town").value+"\"";
				
			if( mode=="contact3_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("e_town").value+"\"";
				
			if (mode=="r_postal_code" || mode=="m_postal_code" || mode=="next_postal_code" || mode=="first_postal_code" || mode=="employ_postal_code")
				xmlStr+=" postal_code=\""+areaobj.value+"\"";
				
            
			xmlStr+=" mode=\""+mode+"\"";
                    		
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);
        }
       
}

} // END OF THE FUNCTION
function onSuccess(){
        multipleclicks='false';
}
function clearrace() {
	

	if ((document.getElementById("nationality_code) && (document.getElementById("nationality_desc.value=='') )
	{
		document.getElementById("nationality_code.value='';
	}

	if ((document.getElementById("language_code) && (document.getElementById("language_desc.value=='') )
	{
		document.getElementById("language_code.value='';
	}

	if(  (document.getElementById("dflt_nationality_code) && (document.getElementById("dflt_nationality_code.value != '')  && (document.getElementById("nationality_code.value == document.getElementById("dflt_nationality_code.value) )
	{	
			if( document.getElementById("default_race_code.value != '' )
			{ 
				document.getElementById("race_code").value = document.getElementById("default_race_code.value;
				document.getElementById("race_desc.value = document.getElementById("default_race_desc.value;
			} 
			else
			{ 					
				document.getElementById("race_code").value = ""; 
			}

			if(document.getElementById("national_id_no && document.getElementById("national_id_no.value.length == 0) 
			{
				document.getElementById("national_id_no.disabled = false;
			}
	} 
	else
	{ 
			
			document.getElementById("race_code").value = ""; 
			document.getElementById("race_desc.value = ""; 
	}
}
function enableimg()
		{
			if(document.getElementById("family_link_no").value.length!=0)
			document.getElementById("rel.style.visibility = 'visible';
			else
			document.getElementById("rel.style.visibility = 'hidden';
		}
			/**
				Used to set the focus to PatientSeries.
				called in the onblur event of AliasName or Additional field based on
				the condition.
			*/
			function focusBack()
			{
    			document.forms[0].pat_ser_grp_code.focus();
			}
			/**
		    	Used to control the focus of additional fields in ContactAddress tab.
				func1() - called onblur of contact3_mode
				If there are no additionalfields focus is placed in contact4_mode.
				func2() - called onblur of contact4_mode
				If there is one additional field focus is placed on contact5_mode.
				@Author - Gomathi
			*/
			function func1()
			{
			if(document.forms[0].ccount.value < 1)
			document.forms[0].contact4_mode.focus();
			}
			function func2()
			{
			if(document.forms[0].ccount.value < 2)
			document.forms[0].contact5_mode.focus();
			}
			/**
				Used to enable or disable the PlaceofBirth(TextField) based on BirthPlaceCode(Lookup).
				If Birthplace code is not entered,TextField(PlaceofBirth) is enabled
				If PlaceofBirth is not entered, Birthplacecode is enabled.
				@author - Gomathi
			*/
			function CheckBirthPlace()
			{
			//Added by Sangeetha for ML-MMOH-SCF-0717
			if(document.forms[0].txtSmart_fn_name.value != '03'){
				if(document.forms[0].place_of_birth_desc.value!="")			
				   document.forms[0].place_of_birth.disabled=true;
				else
				   document.forms[0].place_of_birth.disabled=false;
			}
			}
			function CheckBirthCode()
			{
			//Added by Sangeetha for ML-MMOH-SCF-0717
			if(document.forms[0].txtSmart_fn_name.value != '03'){
				if(document.forms[0].place_of_birth.value=="")
				{
				   document.forms[0].place_of_birth_desc.disabled=false;
					document.forms[0].birth_place.disabled=false;
				}
				else
				{
				   document.forms[0].place_of_birth_code.value="";
				   document.forms[0].place_of_birth_desc.disabled=true;
				   document.forms[0].birth_place.disabled=true;
				}
			}
				
		}

		/** Used to make the mandatory gif of race visible or invisible based on NRIC. @Author - Gomathi */
		
	   			/** SearchLookup for Country. @param  - Lookup title,Target fieldname */
				function searchCountry(obj,target)
				{

				var retVal =    new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				
				var tit="";				
                if(obj.name=="contry_code" )
                {
					
					if(target.name=="nationality_desc"){

					tit=getLabel("Common.nationality.label","common");
                    sql="Select country_code code,long_desc description from Mp_Country_lang_vw where language_id='"+localeName+"' and eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) and eff_status = 'E'";
					}
					else{

						tit=getLabel("Common.country.label","common");
						sql="Select country_code code,long_name description from Mp_Country_lang_vw where language_id='"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?) and eff_status = 'E'";
					}
               	}
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "2,1";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                {
					
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					if(target.name == 'nationality_desc')
						document.forms[0].nationality_code.value= arr[0];
					else if(target.name == 'r_country_desc')
						document.forms[0].r_country_code.value= arr[0];
					else if(target.name == 'm_country_desc')
						document.forms[0].m_country_code.value= arr[0];
					else if(target.name == 'first_country_desc')
						document.forms[0].first_country_code.value= arr[0];
					else if(target.name == 'next_country_desc')
						document.forms[0].next_country_code.value= arr[0];
					else if(target.name == 'empyr_country_desc')
						document.forms[0].empyr_country_code.value= arr[0];
					else if(target.name == 'a_country_desc')
						document.forms[0].a_country_code.value= arr[0];							
					/*Above line added for this CRF ML-MMOH-CRF-0860.2*/ 		
				}
				else{
					target.value='';
					}
			}
          	var disp_in_oth_lang = false;
            var PSGCodeArray = new Array();
			var PSGCodeArrayValues = new Array();
            var PSGYNArray = new Array(); 
          /*  var NamePrefixArray = new Array(); 
            var NamePrefixLocArray = new Array(); 
            var PrefixSexArray = new Array();
            var NameSuffixArray = new Array();
            var NameSuffixLocArray = new Array();
            var SuffixSexArray = new Array();*/
			/**
			   Used to enable or disable the Occupation Description TextField
			   based on the List Item.
			*/
			function enableocpn(){
					if(document.getElementById("occ_of_per.selectedIndex != 0){
						document.getElementById("occu_of_per_desc.value = '';
						document.getElementById("occu_of_per_desc.disabled = true;
					}
					else if (document.getElementById("occ_of_per.selectedIndex == 0)
					{
						
						document.getElementById("occu_of_per_desc.disabled = false;
					}
			}
			function tab_click1(Object)
			{
				if(Object=='#kin')
				{
					if(document.getElementById("next_contact_name!=null&&document.getElementById("next_contact_name.disabled==false)
					document.getElementById("next_contact_name.focus();
					 else
					 document.getElementById("kin.scrollIntoView();
				}
				if(Object=='#kin1')
				{
					if(document.getElementById("first_contact_name!=null&&document.getElementById("first_contact_name.disabled==false)
					document.getElementById("first_contact_name.focus();
					 else
					   document.getElementById("kin1.scrollIntoView();
				}
				if(Object=='#empyr')
				{
					if(document.getElementById("organization_name!=null&&document.getElementById("organization_name.disabled==false)
					document.getElementById("organization_name.focus();
					else
					  document.getElementById("empyr.scrollIntoView();
				}
			}
			/**
			   Used to select Legal/Illegal based on Citizen/Non-citizen.
			   @Author - Gomathi.
			*/
			function change_status() {

			

				if (document.getElementById("nationality_code) {
					document.PatRegForm.nationality_code.value="";
					document.PatRegForm.nationality_desc.value="";
				}

				document.PatRegForm.race_code.value="";
				document.getElementById("race_desc.value="";				
				
				if(document.PatRegForm.citizen[0].checked==true) {
					document.PatRegForm.citizen_yn.value='Y';
					document.PatRegForm.legal_yn.value='Y';
					document.PatRegForm.legal[0].disabled=true;
					document.PatRegForm.legal[1].disabled=true;
				} else {
					document.PatRegForm.citizen_yn.value='N';
					document.PatRegForm.legal[0].disabled=false;
					document.PatRegForm.legal[1].disabled=false;
				}
			}
			/**
			   Used to set the values when citizen or non-citizen is selected.
			   
			*/
			function change_stat_dis(){	 
				
				

				document.PatRegForm.legal[0].disabled=true;
				document.PatRegForm.legal[1].disabled=true;				

				if(document.PatRegForm.citizen[0].checked==true) {
					document.PatRegForm.legal[0].checked=true;
					document.PatRegForm.citizen_yn.value='Y';
					document.PatRegForm.legal_yn.value='Y';					
				} else {
					document.PatRegForm.legal[0].checked=true;
					document.PatRegForm.citizen_yn.value='N';									
				}
				
			}
			/**
			   Used to set the values when legal or illegal is selected.
			*/
			function select_val() {

				if(document.PatRegForm.legal[0].checked==true) {
					document.PatRegForm.legal_yn.value='Y';
				} else	{
					document.PatRegForm.legal_yn.value='N';
				}				
			}
			/**
			   Used to enable the Other Alternate ID TextField when Other AltID Type is
			   selected from the list item.
			   @Author - Gomathi.
			*/
			function enableAltID(){
					
				document.PatRegForm.other_alt_Id_text.value="";
				if(document.PatRegForm.other_alt_id.selectedIndex != 0){
					document.PatRegForm.other_alt_Id_text.disabled = false;
					document.PatRegForm.other_alt_Id_text.value="";
				}
				else 
					document.PatRegForm.other_alt_Id_text.disabled = true;
			
			}
			/**
			   Used to enable the Other Alternate ID TextField when Other AltID Type is
			   selected from the list item.	(applies to first to notify tab)
			   @Author - Gomathi.
			*/
			function nenableAltID(){
					
				document.PatRegForm.notify_oth_alt_id_text.value="";
				if(document.PatRegForm.notify_oth_alt_id_type.selectedIndex != 0)
				{
					document.PatRegForm.notify_oth_alt_id_text.disabled = false;
					document.PatRegForm.notify_oth_alt_id_text.value="";
				}
				else 
				{	
				document.PatRegForm.notify_oth_alt_id_text.disabled = true;
				document.PatRegForm.notify_oth_alt_id_text.value="";
				}
			
			}
            function get_patient_id()
            {
                var patient_id_back = PatientSearch('','','','','','','','','','PAT_REG');
                 if(document.PatRegForm!=null)
				{
                if ((patient_id_back != null))
                {
					patient_id_back = unescape(patient_id_back)
                    document.PatRegForm.family_link_no.value=patient_id_back;
                    document.PatRegForm.family_link_no.focus();
                }
                else document.PatRegForm.family_link_no.focus();
				}
				else
				{
				if ((patient_id_back != null))
                {
                    patient_id_back = unescape(patient_id_back)
                    document.ChangePatDtlForm.family_link_no.value=patient_id_back;
                    document.ChangePatDtlForm.family_link_no.focus();
                }
                else document.ChangePatDtlForm.family_link_no.focus();
				
				}
            }

            /**
			  Used for InitCap.
			*/
			function ChangeInitCase(obj)
            {
				
              var name=obj.value;
              var spltval = name.split(" ") ;
              var temp_name = ""
             for(var i=0;i<spltval.length;i++)
             {
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
			/**
			   Used to enable the Contact1 Other Alternate ID TextField when Contact1 Other AltID Type is	selected from the list item.
			   @Author - Gomathi.
			*/
			function enableOtherAltIdText(val)
			{
			if(val != "")
			{
				
				document.forms[0].contact1_oth_alt_id_no.disabled= false;
				document.forms[0].contact1_oth_alt_id_no.value="";
			}
			else
			{
				document.forms[0].contact1_oth_alt_id_no.value="";
				document.forms[0].contact1_oth_alt_id_no.disabled= true;
			}
		}



/*changed on 3/9/2007*/

function sendToValidation(Val,areaobj,messageFrame,prev_region)  
{
	if(prev_region == null || prev_region == undefined || prev_region == "undefined") {
		prev_region = "";
	}

	//Commented by Sethu on 17/07/2023 for Edge Compatibility
	/* 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	var xmlStr ="<root><SEARCH ";
	if ( Val == 7 )
	{
        if(areaobj.value !='')
        {
           
			if(messageFrame=="parent.parent.messageFrame")
			{
			xmlStr+=" process_id=\"7\"";
			}
			else
			{
			xmlStr+=" process_id=\"20\"";
			}

			var mode =areaobj.name
			if (mode=="r_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("r_region").value+"\"";
				xmlStr+=" prev_region=\""+prev_region+"\"";
			}
				
			if( mode=="m_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("m_region").value+"\"";
				xmlStr+=" prev_region=\""+prev_region+"\"";
			}
				
			if( mode=="contact1_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("n_region").value+"\"";
				xmlStr+=" prev_region=\""+prev_region+"\"";
			}
				
			if( mode=="contact2_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("f_region").value+"\"";
				xmlStr+=" prev_region=\""+prev_region+"\"";
			}
				
			if( mode=="contact3_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("e_region").value+"\"";
				xmlStr+=" prev_region=\""+prev_region+"\"";
			}
				
			if (mode=="r_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("r_area").value+"\"";
				
			if( mode=="m_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("m_area").value+"\"";
				
			if( mode=="contact1_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("n_area").value+"\"";
				
			if( mode=="contact2_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("f_area").value+"\"";
				
			if( mode=="contact3_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("e_area").value+"\"";
				
			if (mode=="r_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("r_town").value+"\"";
				
			if( mode=="m_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("m_town").value+"\"";
				
			if( mode=="contact1_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("n_town").value+"\"";
				
			if( mode=="contact2_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("f_town").value+"\"";
				
			if( mode=="contact3_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("e_town").value+"\"";
				
			//Below line added for ML-MMOH-CRF-0601
            if (mode=="a_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("a_town").value+"\"";	
    
            if( mode=="a_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("a_area").value+"\"";
				
			if (mode=="a_region_code") 
				xmlStr+=" region_code=\""+document.getElementById("a_region").value+"\"";	
		   
				
			if (mode=="alt_postal_code" || mode=="r_postal_code" || mode=="m_postal_code" || mode=="next_postal_code" || mode=="first_postal_code" || mode=="employ_postal_code")
				xmlStr+=" postal_code=\""+areaobj.value+"\"";
				
			 //End this ML-MMOH-CRF-0601	 		
			            
           xmlStr+=" mode=\""+mode+"\"";
			xmlStr +=" /></root>";
			//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);			
			eval(xmlHttp.responseText);
        }
        
	} 
}  
function populateethnicity()
{
	if ( (document.forms[0].race_code) && (document.forms[0].race_code.value!="") )
		sendToServer(14,this);
		
		//Below line added for this CRF ML-MMOH-SCF-0719
		if((document.forms[0].func_act && document.forms[0].func_act.value!="Visitreg") && (document.forms[0].func_act && document.forms[0].func_act.value!="")) { 		
		validateNationality(document.getElementById("national_id_no").value,document.getElementById("Site").value,document.getElementById("nat_id_pat_ser_grp").value,document.getElementById("invoke_routine").value,document.getElementById("nat_data_source_id").value, document.getElementById("nat_id_check_digit_id").value,document.getElementById("nat_id_chk_len").value,'Y');
		
		}//End this CRF ML-MMOH-SCF-0719
}
////////////*********added on June 7 2005 *******///////////////////////
function callResultPage(val)
{
		
		var refrlAappt = '';	
		var refIDValue = '';
		var patient_id = '';
		
		if(val != '')
		{
			refrlAappt	= document.forms[0].refrlAappt.value;
			refIDValue	= document.forms[0].refIDValue.value;
			patient_id = document.forms[0].refIDValue.value;
		}
		
	
		var appt_ref_no		= parent.frames[1].document.forms[0].temp_appt_ref_no.value;
		var patient_grp		= parent.frames[1].document.forms[0].patient_grp.value;
		var NationalIdNo	= parent.frames[1].document.forms[0].temp_a_national_id_no.value;
		var booking_ref_no	= parent.frames[1].document.forms[0].temp_booking_ref_no.value;
		var nat_id			= parent.frames[1].document.forms[0].temp_nat_id.value;
		var referral_id		= parent.frames[1].document.forms[0].temp_referral_id.value;	
		var FirstName		= parent.frames[1].document.forms[0].First_Name.value;
		var SecondName		= parent.frames[1].document.forms[0].Second_Name.value;
		var ThirdName		= parent.frames[1].document.forms[0].Third_Name.value;
		var FamilyName		= parent.frames[1].document.forms[0].Family_Name.value;
		var Dob				= parent.frames[1].document.forms[0].Dob.value;
		var Sex				= parent.frames[1].document.forms[0].Sex.value;
		var AltIdNo			= parent.frames[1].document.forms[0].Alt_Id_No.value;
		var AltId2No		= parent.frames[1].document.forms[0].Alt_Id2_No.value;
		var AltId3No		= parent.frames[1].document.forms[0].Alt_Id3_No.value;
		var AltId4No		= parent.frames[1].document.forms[0].Alt_Id4_No.value;
		var drfunctionid	= parent.frames[1].document.forms[0].dr_function_id.value;
		var FamilyNo		= parent.frames[1].document.forms[0].Family_No.value;
		var func_act		= parent.frames[1].document.forms[0].func_act.value;
		var q_booking_type	= parent.frames[1].document.forms[0].q_booking_type.value;
	
		
		if(patient_grp == "N")
		{
			parent.frames[1].location.href="../jsp/NewPatientRegistration.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&dr_function_id="+drfunctionid+"&nat_id="+nat_id+"&appt_ref_no="+appt_ref_no+"&First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&patient_id="+patient_id;
		}
		if(patient_grp == "A")
		{
			parent.frames[1].location.href="../jsp/NewPatientRegistration.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&group="+patient_grp+"&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&patient_id="+patient_id;
		}
		if(patient_grp == "G")
		{
			 parent.frames[1].location.href="../jsp/NewPatientRegistration.jsp?refIDValue="+refIDValue+"&refrlAappt="+refrlAappt+"&dr_function_id="+drfunctionid+"&group=G&appt_ref_no="+appt_ref_no+"&First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&q_booking_type="+q_booking_type+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&patient_id="+patient_id;
		}
		if(val != '')
		{
			document.forms[0].refrlAappt.disabled		= true;
			document.forms[0].refIDValue.disabled		= true;
			document.forms[0].refIDValueButton.disabled	= true;
		}
	
}
function enbDsbRefIDVal(obj)
{	
	if(obj.value == 'P')
	{		
		document.forms[0].PatIdflag.value='Y';
		document.forms[0].phimg.style.visibility='visible';
		if(document.getElementById("refIDValue")!=null && document.getElementById("patient_id"))
			document.getElementById("refIDValue").maxLength = document.getElementById("patient_id").maxLength;
	}
	else
	{		
		document.forms[0].PatIdflag.value='N';
		document.forms[0].phimg.style.visibility='visible'; //Added by S.Sathish for IN020269 on Thursday, March 25, 2010
		if(document.getElementById("refIDValue")!=null && document.getElementById("patient_id"))
			document.getElementById("refIDValue").maxLength = "20";
	}	

	if(obj.value != '')
	{		
		document.forms[0].refIDValue.value			= '';
		document.forms[0].refIDValue.disabled		= false;
		document.forms[0].refIDValueButton.disabled	= false;
		document.forms[0].patient_id.value			= '';

	}
	else 
	{		
		document.forms[0].refIDValue.value			= '';
		document.forms[0].refIDValue.disabled		= true;
		document.forms[0].refIDValueButton.disabled	= true;
		document.forms[0].phimg.style.visibility='hidden';  //Added by S.Sathish for IN020269 on Thursday, March 25, 2010
		document.forms[0].patient_id.value			= '';
	}
}
// ** This function is used to populate the referral patients ** //
async function PopAppRefDetails()
{
	if(document.forms[0].refrlAappt.value == 'P')
	{
		//var patid=PatientSearch('','','','','','','Y','','Y','Patreg','');
		var patid=PatientSearch('','','','','','','Y','','','Patreg','');
		if(patid != undefined && patid != "undefined") {
			if(patid != null)
			{
				document.forms[0].refIDValue.value=patid;
				document.forms[0].refIDValue.focus();

			}
			else
			{
				document.forms[0].refIDValue.value='';
				document.forms[0].refIDValue.focus();
			}
		}

	}
	else if(document.forms[0].refrlAappt.value != '')
	{
		var refrlAappt = document.forms[0].refrlAappt.value;
		var OAinstall_yn = document.forms[0].OAinstall_yn.value;
		var OPinstall_yn = document.forms[0].OPinstall_yn.value;
		var IPinstall_yn = document.forms[0].IPinstall_yn.value;
		var RDinstall_yn = document.forms[0].RDinstall_yn.value;
		var toDayDate	 = document.forms[0].toDayDate.value;
		
		var dialogTop		= "65";
		var dialogHeight	= "42.2" ;
		var dialogWidth		= "65" ;
		var status			= "no";
		var scroll			= "no";
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
		var arguments   = "" ;			
		var url = "../../eMP/jsp/PopulateApptReferralComp.jsp?refrlAappt="+refrlAappt+"&IPinstall_yn="+IPinstall_yn+"&OPinstall_yn="+OPinstall_yn+"&RDinstall_yn="+RDinstall_yn+"&toDayDate="+toDayDate+"&OAinstall_yn="+OAinstall_yn;
		retVal =await window.showModalDialog(url,arguments,features);
		if(retVal != null && retVal != '' && retVal != 'undefined')
		{
			document.forms[0].refIDValue.value = retVal;
			document.forms[0].refIDValue.focus();
		}
		if(retVal == null || retVal == '' || retVal == 'undefined')
		{
			retVal = "";
			document.forms[0].refIDValue.value = retVal;
			document.forms[0].refIDValue.focus();

		}
	}
}

function chkrefIDValue(obj)
{
	if(document.forms[0].refrlAappt.value == 'P')
	{
		checkPatientId1();
	}
	if(obj.value!='')
	{	

		
		var refrlAappt = document.forms[0].refrlAappt.value;
		var refIDValue = document.forms[0].refIDValue.value;
		var sStyle = document.forms[0].sStyle.value
			
		var HTMLVal = new String();

		HTMLVal = "<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='message' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatRegExpChk.jsp'><input name='funcId' id='funcId' type='hidden' value='registerPatient'><input name='refrlAappt' id='refrlAappt' type='hidden' value='"+refrlAappt+"'><input name='refIDValue' id='refIDValue' type='hidden' value='"+refIDValue+"'></form></BODY></HTML>";

		parent.parent.frames[2].document.open() ;
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit();
	} 
	
}
function assignEmpID(obj)
{ 	
	if( (obj.value != '') && (document.forms[0].empyr_eid) ){
	if ( document.forms[0].family_org_id_accept_yn.value=='Y')
	{
		if ( document.forms[0].family_org_membership.value=='1')
		{
			document.forms[0].empyr_eid.value = obj.value;
			document.forms[0].empyr_eid.readOnly = true;
		}
		else 
		{
			document.forms[0].empyr_eid.value = '';
			document.forms[0].empyr_eid.readOnly = false;
		}
	}
	else {
		document.forms[0].empyr_eid.value = obj.value;
		document.forms[0].empyr_eid.readOnly = true;
	}
 }

}
///////////////*-/*******end of added *********/////////////////

/////****** function ChkKey is called in NewPatientRegistration & ChangePatientSub.jsp *****///////
function ChkKey(evnt)
{ 
	if(evnt.keyCode == '13')
		return false;
}
///////**** end of function ChkKey ******////////
function changeMakeOrgMand(obj)
{ 
	  /*For Changing Membership Type - To check for related members*/
	var prev_mem_type = document.forms[0].prev_mem_type.value; // Previous selected option  
	var mem_type_db = document.forms[0].mem_type_db.value;	   // Membership type From DB
	var CalledFromFunction = document.forms[0].CalledFromFunction.value;
	if(document.forms[0].pat_cat_sql)
		document.forms[0].pat_cat_sql.value = "";
	var alt_id1_db = '';
	if (document.forms[0].alt_id1_db)
			alt_id1_db = document.forms[0].alt_id1_db.value;	
 
	
	if ( (CalledFromFunction=='ChangePatDtls') && (mem_type_db=='1') && (obj.value!='')  )
	{	
		 
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='alt_id1_no' id='alt_id1_no' value='"+document.forms[0].alt_id1_no.value+"'><input type='hidden' name='param' id='param' value='CHK_RELATED_MEM'><input type='hidden' name='alt_id1_db' id='alt_id1_db' value='"+alt_id1_db+"'></form></BODY></HTML>";
	    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	    parent.parent.messageFrame.document.form1.submit();
	}
	else
	{
		makeOrgMandate(obj);
	}
}
function clearMembership()
{
  if ((document.forms[0].family_org_membership) && (document.forms[0].CalledFromFunction.value!='ChangePatDtls')) 	{	
	    document.forms[0].family_org_membership.value='';

		if(document.forms[0].alt_id1_reqd_yn) {
			if(document.forms[0].alt_id1_reqd_yn.value == 'Y') {
				document.forms[0].alt1_gif.style.visibility='visible';
			} else {
			    document.forms[0].alt1_gif.style.visibility='hidden';
			}
		}

		document.forms[0].org_sub_org.style.visibility='hidden';
		document.forms[0].organization.value='';
		document.forms[0].org_id.value='';
		document.forms[0].sub_org_desc.value='';
		document.forms[0].sub_organization.value='';
		document.forms[0].org_id_btn.disabled=true;
		document.forms[0].organization.disabled=true;
		
		document.forms[0].sub_org_desc.disabled=true;
		document.forms[0].sub_org_id_btn.disabled=true;
		if(document.forms[0].family_link_no)	
			document.forms[0].family_link_no.value='';		
		
		if(document.forms[0].head_pat_name)
		document.forms[0].head_pat_name.innerText='';		  
		
		if(document.forms[0].relationship_to_head_desc)
		{	        
			document.forms[0].relationship_to_head_desc.value='';
			document.forms[0].relationship_to_head.value='';

			document.forms[0].relationship_to_head_desc.disabled=true;			
		    document.forms[0].relationship_to_head_id.disabled=true;			
		    document.forms[0].rel.style.visibility='hidden';
			document.getElementById("relnlabel").innerHTML = "";
			document.getElementById("relntext").innerHTML = "";
		}	
  }
	    
	
}


/*Added for Validating Organization Membership 2/14/2006 6:02 PM*/
function makeOrgMandate(obj)
{
	 
	var prev_mem_type = document.forms[0].prev_mem_type.value; // Previous selected option  
	var mem_type_db = document.forms[0].mem_type_db.value;	   // Membership type From DB
	var CalledFromFunction = document.forms[0].CalledFromFunction.value;
	var name_pfx_reqd_for_org_mem_yn = document.forms[0].name_pfx_reqd_for_org_mem_yn.value;

	if(document.forms[0].pat_cat_sql)
		document.forms[0].pat_cat_sql.value = "";
	
	if(document.forms[0].alt_id1_no.readOnly)
		document.forms[0].alt_id1_no.readOnly = false;

if(document.forms[0].pat_cat_desc)
	document.forms[0].pat_cat_desc.value="";
	if(obj.value == '1' || obj.value == '4')
	{ 
	
		if(document.forms[0].family_link_no)
			document.forms[0].family_link_no.disabled=false;
		if(document.forms[0].head_pat_search_reg)
			document.forms[0].head_pat_search_reg.disabled=false;
	}

	if ( (document.forms[0].alt_id1_no.value=='') && (obj.value!='4') && (obj.value!=''))
	{

		if(document.forms[0].alt_id1_reqd_yn.value) {
			if(document.forms[0].alt_id1_reqd_yn.value == 'Y') {
				document.forms[0].alt1_gif.style.visibility='visible';
			}
		}
		
		if (document.forms[0].alt_id1_no.disabled==true)
			document.forms[0].alt_id1_no.disabled=false;
		var msg = getMessage("CAN_NOT_BE_BLANK",'common');
		msg = msg.replace('$',document.getElementById("alt_id1_prompt").innerText)
		alert(msg);
		document.forms[0].family_org_membership.value='';
		document.forms[0].alt_id1_no.focus();
		return;
	}

	if(obj.value == '4' || obj.value == '3')
	{
		chkAltIdforMemship('call_from_page');
	}
	
	if (obj.value=='')
	{	
			
		  clearMembership();

		  document.forms[0].org_sub_org.style.visibility='hidden';

		  if(document.forms[0].alt_id1_reqd_yn.value == 'Y')
			  document.forms[0].alt1_gif.style.visibility='visible';
		  else
  		      document.forms[0].alt1_gif.style.visibility='hidden';

		  if(document.forms[0].name_prefix_reqd_yn) {
			  if(document.forms[0].name_prefix_reqd_yn.value == 'Y') {
				  if(document.forms[0].name_prefix_img)
					 document.forms[0].name_prefix_img.style.visibility='visible';
			  }	else {
				  if(document.forms[0].name_prefix_img)
						 document.forms[0].name_prefix_img.style.visibility='hidden';
			  }
		  }

		  document.forms[0].imgCatExpDateMan.style.visibility='hidden';
  		  document.forms[0].alt_id1_no.disabled=false;
		  return false;
	}
	/*
	else
    if (obj.value!='1')
	{
	
	   if (document.forms[0].name_prefix_img)
		  document.forms[0].name_prefix_img.style.visibility='hidden';
	}
	*/
	if (document.forms[0].organization_name)
		document.forms[0].organization_name.value = "";
	if (document.forms[0].employ_addr_line1)
		document.forms[0].employ_addr_line1.value =  "";	
	if (document.forms[0].employ_addr_line2)
		document.forms[0].employ_addr_line2.value =  "";							
	if (document.forms[0].employ_addr_line3)
		document.forms[0].employ_addr_line3.value = 	 "";						
	if (document.forms[0].employ_addr_line4)
		document.forms[0].employ_addr_line4.value =  "";							
	if (document.forms[0].contact3_res_town_code)
		document.forms[0].contact3_res_town_code.value =  "";				
	if (document.forms[0].e_town)
		document.forms[0].e_town.value = "";
	if (document.forms[0].contact3_region_code)
		document.forms[0].contact3_region_code.value =  "";				
	if (document.forms[0].e_region)
		document.forms[0].e_region.value = "";
	if (document.forms[0].contact3_res_area_code)
		document.forms[0].contact3_res_area_code.value =  "";				
	if (document.forms[0].e_area)
		document.forms[0].e_area.value=  "";
	if (document.forms[0].employ_postal_code)
		document.forms[0].employ_postal_code.value =  "";				
	if (document.forms[0].empyr_country_desc)
		document.forms[0].empyr_country_desc.value = 	 "";			
	if (document.forms[0].empyr_country_code)
		document.forms[0].empyr_country_code.value = 	 "";
	if (document.forms[0].res3_tel_no)
		document.forms[0].res3_tel_no.value = "";
	if (document.forms[0].empyr_off_tel_no)
		document.forms[0].empyr_off_tel_no.value = "";
	if (document.forms[0].empyr_contact_name)
		document.forms[0].empyr_contact_name.value =  ""; 			

		var alt_id1_no = document.forms[0].alt_id1_no.value;
		if ( (alt_id1_no!='')&&(obj.value== '4') )
		{		
		
			alert(getMessage("MEM_ID_SHLD_BE_BLANK",'MP'));
			document.forms[0].alt_id1_no.focus();											
		}
	/* If the Membership type is changed to 1 clear ALt ID1 no*/
	if  (obj.value == '1')  // && (prev_mem_type!='1') )
	{
		chkMembershipID(document.forms[0].alt_id1_no);
		document.forms[0].organization.disabled=false;
		document.forms[0].org_id_btn.disabled=false;
		if(document.forms[0].family_link_no)
		document.forms[0].family_link_no.disabled=false;	
	}
	if  (obj.value != '1') 
	{
	
		if(document.forms[0].family_link_no)
		document.forms[0].family_link_no.value='';
		if(document.forms[0].head_pat_name)
		document.forms[0].head_pat_name.innerText='';
		document.forms[0].organization.value='';
		document.forms[0].org_id.value='';
		if(document.forms[0].relationship_to_head)
		document.forms[0].relationship_to_head.value='';
		if(document.forms[0].relationship_to_head_desc)
		document.forms[0].relationship_to_head_desc.value='';
		if (document.forms[0].empyr_eid)
		{
			document.forms[0].empyr_eid.value = '';
		}

		if (document.forms[0].name_prefix)
		{
			document.forms[0].name_prefix.value = '';
			document.forms[0].name_prefix.disabled = false;
		}
		
		document.forms[0].organization.disabled=true;
		document.forms[0].org_id_btn.disabled=true;	
		document.forms[0].sub_org_desc.disabled=true;
		document.forms[0].sub_org_id_btn.disabled=true;
		document.forms[0].sub_organization.value='';
		document.forms[0].sub_org_desc.value='';
	}

	if (obj.value == '4')
	{   
	    /*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	   if(document.forms[0].alt_id1_man_non_ctz && document.forms[0].alt_id1_man_non_ctz.value=="false") { 
		document.forms[0].alt_id1_no.value='';
		document.forms[0].alt_id1_no.disabled=true;
		}
		//End  this CRF GHL-CRF-0332 [IN:042060]*/
		
		document.forms[0].organization.value='';
		document.forms[0].sub_organization.value='';
		document.forms[0].sub_org_desc.value='';
		document.forms[0].org_id_btn.disabled=true;
		document.forms[0].organization.disabled=true;
		
		document.forms[0].sub_org_desc.disabled=true;
		document.forms[0].sub_org_id_btn.disabled=true;
		if(document.forms[0].family_link_no)
			document.forms[0].family_link_no.disabled=false;
		if(document.forms[0].head_pat_search_reg)
			document.forms[0].head_pat_search_reg.disabled=false;
		
		if(document.forms[0].relationship_to_head_desc){
			document.forms[0].relationship_to_head_desc.disabled=true;
			document.forms[0].relationship_to_head_code_id.disabled=true;
			document.getElementById("relnlabel").innerHTML = "";
			document.getElementById("relntext").innerHTML = "";
		}
	}
	else
	{
	
		document.forms[0].organization.disabled=false;
		document.forms[0].org_id_btn.disabled=false;
		
		document.forms[0].sub_org_desc.disabled=false;
		document.forms[0].sub_org_id_btn.disabled=false;
		document.forms[0].alt_id1_no.disabled=false;
	}

	if (obj.value != '4')
	{  
							
	  document.forms[0].org_sub_org.style.visibility='visible';
	  document.forms[0].alt1_gif.style.visibility='visible';
	  if (obj.value != '1')
	  {
			 if (document.getElementById("rel"))
			{
				document.getElementById("rel").style.visibility='visible';
			}
	  }else{
			 if (document.getElementById("rel"))
			{	  
				document.getElementById("rel").style.visibility='hidden';
			}
	  }
	}
	else
	{
							
	  document.forms[0].org_sub_org.style.visibility='hidden';
	  /*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	  if(document.forms[0].alt_id1_man_non_ctz && document.forms[0].alt_id1_man_non_ctz.value=="false")
     	  document.forms[0].alt1_gif.style.visibility='hidden';
	  
	  if (obj.value != '1')
		   if (document.getElementById("rel"))
		{
			 document.getElementById("rel").style.visibility='hidden';
		}
	}

	if  ( (obj.value == '2') || (obj.value == '3') ) 
	{
	
		    chkMembershipID(document.forms[0].alt_id1_no);
			
			document.forms[0].org_id_btn.disabled=true;
			document.forms[0].organization.disabled=true;
			
			document.forms[0].sub_org_desc.disabled=true;
			document.forms[0].sub_org_id_btn.disabled=true;

			if(document.forms[0].family_link_no)
			{
			if (document.forms[0].family_link_no.value=='') 
				document.forms[0].relationship_to_head_desc.disabled=true;
			else
				document.forms[0].relationship_to_head_desc.disabled=false;
			}
	}
	if (obj.value == '1')	 // Membership type = 'Organization Member' 
	{		
		 if(document.forms[0].name_prefix_img && name_pfx_reqd_for_org_mem_yn == 'Y' )
			document.forms[0].name_prefix_img.style.visibility='visible';
		 else if(document.forms[0].name_prefix_img)
			document.forms[0].name_prefix_img.style.visibility='hidden';
	
		if (document.forms[0].relationship_to_head_desc)
		{ 
			document.forms[0].relationship_to_head_desc.disabled=false;
			
			document.forms[0].relationship_to_head.value=document.forms[0].org_member_relationship_code.value;	
			if(document.forms[0].org_member_relationship_desc)
			document.forms[0].relationship_to_head_desc.value=document.forms[0].org_member_relationship_desc.value;	
			document.forms[0].relationship_to_head_desc.disabled=true;
			if(document.forms[0].family_link_no)
			document.forms[0].family_link_no.value=''
			if(document.forms[0].head_pat_name)
			document.forms[0].head_pat_name.innerText='';
			document.forms[0].organization.value=''
			document.forms[0].sub_organization.value=''
			document.forms[0].sub_org_desc.value=''
			getLevel();
			
		}
		if (document.forms[0].empyr_eid)
		{
			document.forms[0].empyr_eid.value = document.forms[0].alt_id1_no.value;
			document.forms[0].empyr_eid.readOnly = true;
		}
  }
  else
  {
	if(document.forms[0].name_prefix_img && document.forms[0].name_prefix_reqd_yn.value == 'Y' ){
		document.forms[0].name_prefix_img.style.visibility='visible'; 
	} else if(document.forms[0].name_prefix_img) {
		document.forms[0].name_prefix_img.style.visibility='hidden';
	}

	if(document.forms[0].name_prefix_oth && document.forms[0].name_prefix_reqd_yn.value == 'Y' ) {  
		document.forms[0].name_prefix_oth.style.visibility='hidden';
	} else {  
		if (document.forms[0].name_prefix_oth)
		document.forms[0].name_prefix_oth.style.visibility='hidden';
	} 	
	
  }

/* If changed from Family to Non Family new relationship to be d*/
  if ( (prev_mem_type=='2') && (obj.value=='3') )
  {
	  if(document.forms[0].relationship_to_head)
		document.forms[0].relationship_to_head.value='';
	  if(document.forms[0].relationship_to_head_desc)
		document.forms[0].relationship_to_head_desc.value='';
  }
  if ( (obj.value=='4'))   /*For others no need for calling the function here*/
  { 
	  getPatCategory();
  }
/*The previous membership option*/
	document.forms[0].prev_mem_type.value = obj.value;
	
}

function chg_get_sub_org()
{
	var CalledFromFunction = document.forms[0].CalledFromFunction.value;
	/* If called from change patient Details look shld come only if the defaulted value is changable*/
	var org_id = parent.frames[1].document.forms[0].org_id.value ;
	HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='organization' id='organization' value='"+org_id+"'><input type='hidden' name='param' id='param' value='PATREG'></form></BODY></HTML>";
	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.forms[0].submit();

}

function get_org_sub_org(organization,sub_organization)
{
	/*
	parent.frames[1].document.forms[0].sub_org_desc.value = '';
	parent.frames[1].document.forms[0].sub_organization.value = '';

	if(document.forms[0].entitlement_by_pat_cat_yn.value=='Y') {
		parent.frames[1].document.forms[0].pat_cat_code.value = '';
		parent.frames[1].document.forms[0].pat_cat_desc.value = '';
		parent.frames[1].document.forms[0].pat_cat_sql.value = '';
	}
	*/

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var tit="";	
	
	tit=getLabel("Common.Organization.label","Common");
	sql="select family_org_id code, family_org_name description from MP_FAMILY_ORG_lang_vw where language_id='"+locale+"' and eff_status = 'E' and upper(family_org_id) like upper(?) and upper(family_org_name) like upper(?)";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = organization.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );	
	if(!(retVal== null && retVal== "" ))
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		var org_id = arr[0];
		parent.frames[1].document.forms[0].org_id.value = org_id;
		organization.value=arr[1];
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='organization' id='organization' value='"+org_id+"'><input type='hidden' name='param' id='param' value='PATREG'></form></BODY></HTML>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
		
	}
	if(retVal==null || retVal=="")
	{
		organization.value='';
		organization.focus();
	}
}

function get_sub_org(sub_org_desc)
{
    
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var org_id = parent.frames[1].document.forms[0].org_id.value
	var tit="";	
	
	tit=getLabel("eMP.suborgn.label","MP");		

	sql="select FAMILY_ORG_SUB_ID code, FAMILY_ORG_SUB_NAME description from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+org_id+"' and EFF_STATUS = 'E' and upper(FAMILY_ORG_SUB_ID) like upper(?) and upper(FAMILY_ORG_SUB_NAME) like upper(?)";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = sub_org_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(!(retVal== null && retVal== "" ))
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		var sub_org_id = arr[0];
		parent.frames[1].document.forms[0].sub_organization.value = sub_org_id;
		sub_org_desc.value=arr[1];	
		getPatCategory();
	}
	if(retVal==null || retVal=="")
	{
		sub_org_desc.value='';
		sub_org_desc.focus();
	}
}

function getExpDate(obj,obj2)
{   

	 if ( (document.forms[0].entitlement_by_pat_cat_yn) && (document.forms[0].entitlement_by_pat_cat_yn.value=='Y') )
	{ 
		var selInd = obj;
		
		var entitlement_by_pat_cat_yn = obj2;
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='category' id='category' value='"+selInd+"'><input type='hidden' name='param' id='param' value='CATEXP'><input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value='"+entitlement_by_pat_cat_yn+"'></form></BODY></HTML>";
		if (selInd != '')
		{	
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
			
		}
		else
		{	
			parent.frames[1].document.forms[0].pat_cat_code_exp_date.value=	"";
			parent.frames[1].document.forms[0].pat_cat_code_exp_date.disabled=true;
			parent.frames[1].document.forms[0].imgCatExpDate.disabled=true;
			parent.frames[1].document.forms[0].imgCatExpDateMan.style.visibility='hidden';
		}
	}
 }
	
function populateEmpDat(organization,org_id,sub_organization)
{																						   
	var selInd = sub_organization.value;
	HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='param' id='param' value='COPYEMP'><input type='hidden' name='org_id' id='org_id' value='"+org_id.value+"'><input type='hidden' name='org_sub_id' id='org_sub_id' value='"+selInd+"'></form></BODY></HTML>";
    if (document.getElementById("family_org_membership"))
    {
     if ( (selInd != '') && ( document.forms[0].family_org_membership.value=='1') )
     {
		parent.parent.messageFrame.document.open()
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
		if (document.forms[0].organization_name)
			document.forms[0].organization_name.value = organization.value;
     }
	 else
    {		
		if (document.forms[0].organization_name)
			document.forms[0].organization_name.value = "";
		if (document.forms[0].employ_addr_line1)
			document.forms[0].employ_addr_line1.value =  "";	
		if (document.forms[0].employ_addr_line2)
			document.forms[0].employ_addr_line2.value =  "";							
		if (document.forms[0].employ_addr_line3)
			document.forms[0].employ_addr_line3.value = 	 "";						
		if (document.forms[0].employ_addr_line4)
			document.forms[0].employ_addr_line4.value =  "";							
		if (document.forms[0].contact3_res_town_code)
			document.forms[0].contact3_res_town_code.value =  "";				
		if (document.forms[0].e_town)
			document.forms[0].e_town.value = "";
		if (document.forms[0].contact3_region_code)
			document.forms[0].contact3_region_code.value =  "";				
		if (document.forms[0].e_region)
			document.forms[0].e_region.value = "";
		if (document.forms[0].contact3_res_area_code)
			document.forms[0].contact3_res_area_code.value =  "";				
		if (document.forms[0].e_area)
			document.forms[0].e_area.value=  "";
		if (document.forms[0].employ_postal_code)
			document.forms[0].employ_postal_code.value =  "";				
		if (document.forms[0].empyr_country_desc)
			document.forms[0].empyr_country_desc.value = 	 "";			
		if (document.forms[0].empyr_country_code)
			document.forms[0].empyr_country_code.value = 	 "";
		if (document.forms[0].res3_tel_no)
			document.forms[0].res3_tel_no.value = "";
		if (document.forms[0].empyr_off_tel_no)
			document.forms[0].empyr_off_tel_no.value = "";
		if (document.forms[0].empyr_contact_name)
			document.forms[0].empyr_contact_name.value =  ""; 
		if (document.forms[0].name_prefix)
			document.forms[0].name_prefix.disabled = false; 
   }
  }
}

function chkMembershipID(alt_id1_no)			   
{  
	// if ( (document.forms[0].family_org_membership) && (document.forms[0].mem_type_db.value != '1') )
	if ( (document.forms[0].family_org_membership) )
	{	
		var CalledFromFunction = document.forms[0].CalledFromFunction.value;
		var alt_id1_db = '';
		if (document.forms[0].alt_id1_db)
			alt_id1_db = document.forms[0].alt_id1_db.value;
		var membership_type = document.forms[0].family_org_membership.value;
		var patient_id = document.forms[0].patient_id.value;
		var entitlement_by_pat_cat_yn = document.forms[0].entitlement_by_pat_cat_yn.value;
		var family_org_id_accept_yn = document.forms[0].family_org_id_accept_yn.value;
	    if   ( (membership_type!='4')  && (membership_type!='') )
		{			
		   var selInd = alt_id1_no.value;
			HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='param' id='param' value='CHKMEMBERSHIP'><input type='hidden' name='CalledFromFunction' id='CalledFromFunction' value='"+CalledFromFunction+"'><input type='hidden' name='alt_id1_no' id='alt_id1_no' value='"+selInd+"'><input type='hidden' name='alt_id1_db' id='alt_id1_db' value='"+alt_id1_db+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='membership_type' id='membership_type' value='"+membership_type+"'><input type='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='"+family_org_id_accept_yn+"'></form></BODY></HTML>";
		   if (selInd != '')
		   {
            parent.parent.messageFrame.document.open()
            parent.parent.messageFrame.document.write(HTMLVal);
            parent.parent.messageFrame.document.form1.submit();
		   }
	}
	else
	if  ( (membership_type=='4')  && (alt_id1_no.value!='') )
	{
			alert(getMessage("MEM_ID_SHLD_BE_BLANK",'MP'));
			document.forms[0].alt_id1_no.focus();
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
 }
}

function chkAltIdforMemship(call_from) {
	
	//Commented by Sethu on 17/07/2023 for Edge Compatibility
	/* 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	var xmlStr ="<root><SEARCH ";
	
	var frame_reference = "";

	if(call_from=='call_from_apply')
		frame_reference = f_query_add_mod.patient_sub.document.all;
	else if(call_from=='call_from_page')
		frame_reference = document.forms[0].all;
    
        if(frame_reference.pat_ser_grp_code)
        { 
			if(frame_reference.pat_ser_grp_code.value!="")
            {
				xmlStr+=" process_id=\"30\" ";
				xmlStr+=" pat_ser_grp_code=\""+frame_reference.pat_ser_grp_code.value+"\"";
				xmlStr+=" CalledFromFunction=\""+frame_reference.CalledFromFunction.value+"\"";
				xmlStr+=" call_from=\""+call_from+"\"";
				xmlStr +=" /></root>";
				//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
	
			}			
        }
    
}

function clearFieldVal(obj) {
	if(obj=="org"){
	document.forms[0].sub_org_desc.value = '';
	document.forms[0].sub_organization.value = '';
	}
	if(document.forms[0].entitlement_by_pat_cat_yn.value=='Y') {
		document.forms[0].pat_cat_code.value="";
		document.forms[0].pat_cat_desc.value="";  	
		document.forms[0].pat_cat_sql.value="";  
	}
}


function getPatCategory(patCatVal)
{	
	
         if((document.forms[0].family_link_no) && (document.forms[0].family_link_no.value!='')) {
			if(document.getElementById("copy_head"))
				document.getElementById("copy_head").style.visibility='visible';
		 }
		 else { 
			if(document.getElementById("copy_head"))
		    document.getElementById("copy_head").style.visibility='hidden';
		 } 
    
	 if ( (document.forms[0].entitlement_by_pat_cat_yn != null) && (document.forms[0].entitlement_by_pat_cat_yn.value=='Y') )
	{
		 
	 var family_org_membership ="";
	 if(document.forms[0].family_org_membership){
		 family_org_membership = document.forms[0].family_org_membership.value;
	 }
	 var name_prefix = '';
	 var org_id = '';
	 var sub_organization = '';
	 var selected_sub = '';
	 var relationship_to_head ='';
	 var alt_id1_no = "";
	 if(document.forms[0].alt_id1_no){
		 alt_id1_no = document.forms[0].alt_id1_no.value;
	 }

	 /*
	 if (document.forms[0].pat_cat_code) {
		 document.forms[0].pat_cat_code.value="";
	 }
	 if (document.forms[0].pat_cat_desc)	{
		 document.forms[0].pat_cat_desc.value="";
	 }
	
	 if (document.forms[0].pat_cat_sql)	{
		 document.forms[0].pat_cat_sql.value="";
	 }
	 */

	 if (document.forms[0].name_prefix)
		 name_prefix = document.forms[0].name_prefix.value;
	 if (document.forms[0].org_id)
		org_id = document.forms[0].org_id.value;
	 if (document.forms[0].sub_organization)
		sub_organization = document.forms[0].sub_organization.value;
	 if (document.forms[0].selected_sub)
		selected_sub = document.forms[0].selected_sub.value;
	 if (document.forms[0].relationship_to_head)
		relationship_to_head = document.forms[0].relationship_to_head.value;
	 var patCatDB = '';
	 if (patCatVal != null)																						
		 patCatDB = patCatVal;
	 //Commented by Sethu on 17/07/2023 for Edge Compatibility
	/* 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	 xmlStr = "<root><SEARCH family_org_membership=\""+family_org_membership+"\" org_id=\""+org_id+"\" sub_organization=\""+sub_organization+"\" name_prefix=\""+name_prefix+"\" relationship_to_head=\""+relationship_to_head+"\" alt_id1_no=\""+alt_id1_no+"\" selected_sub=\""+selected_sub+"\" patCatDB=\""+patCatDB+"\" /></root>";
	 //xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST","../../eMP/jsp/RegPatCategoryTemp.jsp",false)
	 xmlHttp.send(xmlDoc)
	 responseText = xmlHttp.responseText;
 	 // Script tags should be removed while evaluating response text
	 responseText = responseText.replace("<script>","");
	 responseText = responseText.replace("</script>","");
	 if(document.forms[0].Select1){
		 responseText = responseText.replace("Select",document.forms[0].Select1.value);
	 }
	 eval(responseText)		 
	}
}


function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForAlphaCharsNatID(event){  	

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}	 

function validateResidency(Obj) {	

	var nat_desc = Obj.value;

	
	var national_id_no = "";
	if(document.forms[0].national_id_no)
		national_id_no = document.forms[0].national_id_no.value;	
	

	if(Obj.value!="" && national_id_no == "") {
		var nat_code = document.forms[0].nationality_code.value;
		var dfltNatCode = document.forms[0].dflt_nationality_code.value;   				
		
		if(nat_code == dfltNatCode) {
			document.forms[0].citizen.item(0).checked = true;
			document.forms[0].citizen.item(0).click();
		} else {
			document.forms[0].citizen.item(1).checked = true;	
			document.forms[0].citizen.item(1).click();
		}
		if(document.getElementById("nationality_code"))
			document.getElementById("nationality_code").value = nat_code;
		if(document.getElementById("nationality_desc"))
			document.getElementById("nationality_desc").value = nat_desc;
	}

}
//below code change done for SRR20056-SCF-12671
function altID234Validations(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
function form60OnChange(){
	var form60value	= document.forms[0].formno60.value;
	if(form60value=="Y"){
		document.forms[0].alt_id3_no.value="";
		document.forms[0].alt_id3_no.disabled=true;
		document.forms[0].alt_id3_reqd_yn.value="N";
		document.getElementById("alt3_gif.style").visibility='hidden';
	}else{
		//Commented by Dharma on july 13th 2016 against KDAH-SCF-0358 [IN:060809]
		/*document.forms[0].alt_id3_reqd_yn.value="Y";
		document.getElementById("alt3_gif.style").visibility='visible';*/
		document.forms[0].alt_id3_no.disabled=false;
	}
}

/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
function chkNatlIdMandatory(calledFrom){
	var nationalIdValue				= document.getElementById("pat_ser_grp_code").value;
	var isNatIdMandatory			= document.getElementById("isNatIdMandatory").value;
	var isClearNatIdValues			= document.getElementById("isClearNatIdValues").value;
	var nat_id_pat_ser_grp			= document.getElementById("nat_id_pat_ser_grp").value;
	var function_id					= document.getElementById("function_id").value;

	/*Added By Dharma on 10th Oct 2017 against GDOH-SCF-0274 [IN:065413] Start*/
	var nat_id_prompt				= document.getElementById("nat_id_prompt").value;
	if(isNatIdMandatory=="Y" && nat_id_pat_ser_grp!=nationalIdValue && document.getElementById("national_id_no").value!="" && calledFrom=="1") {
		document.getElementById("pat_ser_grp_code").value = nat_id_pat_ser_grp;
		var errMsg  = getMessage("NATID_ENTERED_CAN_NOT_CHG_PAT_SER","MP");
		errMsg  = errMsg.replace('$', nat_id_prompt);
		alert(errMsg);
		return false;
	}
	/*Added By Dharma on 10th Oct 2017 against GDOH-SCF-0274 [IN:065413] End*/

	if(isNatIdMandatory=="Y" && nationalIdValue!=""){
		if(nat_id_pat_ser_grp==nationalIdValue){
			var isNatIdGifVisible	= "Y"; 
			if(function_id=="EMERG_REG"){
				if(document.getElementById("details_unknown").checked == false){
					isNatIdGifVisible	= "Y";
				}else{
					isNatIdGifVisible	= "N";
				}
			}
			if(isNatIdGifVisible=="Y"){
				document.getElementById("nat_gif.style").visibility="visible";
				document.getElementById("nat_id_reqd_all_series").value="Y";
			}
		}else{
			
			document.getElementById("nat_gif.style").visibility="hidden"
			document.getElementById("nat_id_reqd_all_series").value="N";
			if(isClearNatIdValues=="C" && document.getElementById("CalledFromFunction").value != 'ChangePatDtls'){
				document.getElementById("national_id_no").value="";

			}
		}
	}
/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
	var isNatIdOrAltId1MandRes	= document.getElementById("isNatIdOrAltId1MandRes").value;
	var isNatIdOrAltIdMandVisaType	= document.getElementById("isNatIdOrAltIdMandVisaType").value;
	if(isNatIdOrAltId1MandRes=="true" || isNatIdOrAltIdMandVisaType=="true"){
		getVisibleMandNatAltIds();
	}
	/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/
}
/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] End*/
/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
function fnMakeMandNatIdAltId(){
	var function_id = document.getElementById("function_id").value; 
	var isNatIdOrAltIdMandVisaType	= document.getElementById("isNatIdOrAltIdMandVisaType").value;
	var isNatIdOrAltId1MandRes	= document.getElementById("isNatIdOrAltId1MandRes").value;
	if(isNatIdOrAltIdMandVisaType=="true" || isNatIdOrAltId1MandRes=="true"){
		if(function_id == "EMERG_REG"){
			if(document.forms[0].details_unknown.checked == true){
				if(document.getElementById("nat_gif")){
					document.getElementById("nat_gif.style").visibility="hidden";
				}
					document.getElementById("nat_id_reqd_all_series").value="N";
				if(document.forms[0].alt1_gif){
					document.forms[0].alt_id1_reqd_yn.value="N"; 
					document.forms[0].alt1_gif.style.visibility="hidden";
				}
				if(document.forms[0].alt2_gif){
					document.forms[0].alt_id2_reqd_yn.value="N"; 
					document.forms[0].alt2_gif.style.visibility="hidden";
				}
			}else{
				getVisibleMandNatAltIds();
			}
		}else{
			getVisibleMandNatAltIds();
		}
	}
}
function getVisibleMandNatAltIds() {
		var isNatIdOrAltIdMandVisaType	= document.getElementById("isNatIdOrAltIdMandVisaType").value;
		var isNatIdOrAltId1MandRes	= document.getElementById("isNatIdOrAltId1MandRes").value;
		var isNatVisible	= "hidden";
		var natIdReqYN		= "N";
		var isAltId1MandVisible	= "visible";
		var altId1ReqYN		= "Y";
		if(isNatIdOrAltIdMandVisaType=="true"){
			var isAltId2MandVisible	= "visible";
			var altId2ReqYN		= "Y";	
		}
		if(document.getElementById("citizen[0]").checked==true){
			if(document.forms[0].visa_type){
				document.forms[0].visa_type.value="W";
				document.forms[0].visa_type.disabled=true;
			}
			isNatVisible	= "visible";
			natIdReqYN		= "Y";
			isAltId1MandVisible	= "hidden";
			altId1ReqYN		= "N";
			if(isNatIdOrAltIdMandVisaType=="true"){
				isAltId2MandVisible	= "hidden";
				altId2ReqYN		= "N";
			}
		} else {
			if(document.getElementById("visa_type")){
				document.forms[0].visa_type.disabled=false;
				isNatVisible	= "hidden";
				natIdReqYN		= "N";
				if(document.getElementById("visa_type").value=="V"){
					isAltId1MandVisible	= "hidden";
					altId1ReqYN		= "N";
					isAltId2MandVisible	= "visible";
					altId2ReqYN		= "Y";
				}else{
					isAltId1MandVisible	= "visible";
					altId1ReqYN		= "Y";
					isAltId2MandVisible	= "hidden";
					altId2ReqYN		= "N";
				}
			}
		}

		if(isNatIdOrAltIdMandVisaType=="true" || isNatIdOrAltId1MandRes=="true"){
			var age_not_consider_natid_altid	= parseInt(document.forms[0].age_not_consider_natid_altid.value);
			var CurrentDate = getCurrentSysDate("DMY",localeName);
			var dob			= document.forms[0].date_of_birth.value;
			if(dob!="" && CurrentDate!=""){
				var interval	= parseInt(daysBetween(dob,CurrentDate,"DMY",localeName));
				if(age_not_consider_natid_altid > 0 && interval >= 0) {
					if(interval <= age_not_consider_natid_altid){
						isNatVisible		= "hidden";
						natIdReqYN			= "N";
						isAltId1MandVisible	= "hidden";
						altId1ReqYN			= "N";
						if(isNatIdOrAltIdMandVisaType=="true"){
							isAltId2MandVisible	= "hidden";
							altId2ReqYN			= "N";
						}
					}
				}
			}
		}
		if(document.getElementById("nat_gif")){
			document.getElementById("nat_gif").style.visibility=isNatVisible;
		}
		document.getElementById("nat_id_reqd_all_series").value=natIdReqYN;
		if(document.forms[0].alt1_gif){
			document.forms[0].alt_id1_reqd_yn.value=altId1ReqYN; 
			document.forms[0].alt1_gif.style.visibility=isAltId1MandVisible;
		}
		if(isNatIdOrAltIdMandVisaType=="true"){
			if(document.forms[0].alt2_gif){
				document.forms[0].alt_id2_reqd_yn.value=altId2ReqYN; 
				document.forms[0].alt2_gif.style.visibility=isAltId2MandVisible;
			}
		}
}
function fnChkAgeChkNatIDAltId1AltId2(){
	var isNatIdOrAltIdMandVisaType	= document.getElementById("isNatIdOrAltIdMandVisaType").value;
	if(isNatIdOrAltIdMandVisaType=="true"){
		fnMakeMandNatIdAltId();
	}
}
/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/

 /*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] Start*/ 
function fnChkDOBNatIDValidation(dobVal,NatIdVal){
	var day			= dobVal.substring(0,2);
	var month		= dobVal.substring(3,5);
	var year		= dobVal.substring(8,10);
	var natIDYear	= NatIdVal.substring(0,2);
	var natIDMonth	= NatIdVal.substring(2,4);
	var natIDDay	= NatIdVal.substring(4,6);
	if(day==natIDDay && month==natIDMonth && year==natIDYear){
		return true;
	}else{
		return false;
	}
}
/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] End*/ 
/*Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145 Start*/
function chkNatIDWithGender(gender,natId){
	var natIdDigit	= natId.substring(6,7);
	if(gender == "M"){
		if(natIdDigit.match("5|6|7|8|9"))
			return true;
		else
			return false;
	}
	else if(gender == "F"){
		if(natIdDigit.match("0|1|2|3|4"))
			return true;
		else
			return false;
	}
	else{
		return true;}
} 

// added by mujafar for KDAH-CRF-370.1 START 
function callfunc(facility_id,patient_id,login_user,login_ws_no,calledfrom )
{ 
	
	if(document.forms[0].alt_id3_no.value == "")
	{
		
		alert(getMessage('PANCARD_NOT_BLANK','MP'));
		document.getElementById("pancard_display").innerHTML="";
		document.getElementById("pancard_relationship").style.visibility = 'hidden';
		document.getElementById("pancard_pancardrelation").style.visibility = 'hidden';
		document.forms[0].pan_holder_name.value = "";
		document.forms[0].pan_status.value = "";
	}
	else
	{ 
		var called_function = "";
		if(calledfrom == "ChangePatDtls")
			 called_function = "CHGPAT";
		else
			called_function="REGPAT";
		
		var pan_no = document.forms[0].alt_id3_no.value;
		pan_no = pan_no.toUpperCase();

		var strValue = "<FACILITY_ID>SI$!^<PATIENT_ID>AAAAA$!^<LOGGED_IN_USER_ID>BBBBB$!^<LOGGED_IN_WSNO>DFLT_WSNO$!^<SESSION>REGPAT$!^<PANCARDNO>CCCCC";
		strValue=strValue.replace("SI",facility_id);
		strValue=strValue.replace("AAAAA",patient_id);
		strValue=strValue.replace("BBBBB",login_user);
		strValue=strValue.replace("DFLT_WSNO",login_ws_no);
		strValue=strValue.replace("REGPAT",called_function);
		strValue=strValue.replace("CCCCC",pan_no);
		
		
		var returnval = invokePanCardValidation(strValue);
		  var temp_return = returnval.split("$!^");
		  var pan_status ='';   
			var pan_holder_name =''; 
			var pan_transaction_id='';
			var pan_card_no ='';
			
		  if(temp_return[0] == 'S')
		  {
				 pan_card_no =temp_return[1];
				 pan_holder_name = temp_return[2];
				 pan_status  = temp_return[3].toUpperCase();
				 pan_transaction_id = temp_return[5];
				 
				
				if (pan_status == 'ACTIVE')	
				{		
					if(document.getElementById("pancard_display")!=null)
					{	document.getElementById("pancard_display").style.visibility='visible';
						document.getElementById("pancard_display").innerHTML='\xa0\xa0'+pan_status+'\xa0\xa0\xa0\xa0\xa0\xa0\xa0'+pan_holder_name;
					}
						
						document.getElementById("pancard_relationship").style.visibility = 'visible';
						document.getElementById("pancard_pancardrelation").style.visibility = 'visible'; 
						document.forms[0].pan_holder_name.value = pan_holder_name;
						document.forms[0].pan_status.value = 'A';
						document.forms[0].pan_trans_id.value = pan_transaction_id;  
						document.forms[0].pancard_no.value  = pan_card_no;
				
				}
				
		  }
		  else if(temp_return[0] == 'E')
		  { pan_status  = temp_return[3].toUpperCase();
				
				if(pan_status== 'IN-ACTIVE')
				{
					alert(getMessage('PANCARD_INACTIVE','MP'));
					document.forms[0].alt_id3_no.value = "";
					document.forms[0].pan_holder_name.value = "";
					document.forms[0].pan_status.value = "";
					document.forms[0].pan_trans_id.value ="";
					document.forms[0].pancard_no.value = "";
					
				}
				else
				if(pan_status== 'OTHERS')
				{
					
					alert(getMessage('PANCARD_TECH_PROB','MP'));
					document.forms[0].alt_id3_no.value = "";
					document.forms[0].pan_holder_name.value = "";
					document.forms[0].pan_status.value = "";
					document.forms[0].pan_trans_id.value ="";
					document.forms[0].pancard_no.value = "";
					
				}
				

		  }
		 
	
	}
		
}
function makeClear()
{    
     // added by mujafar for ICN-64510 start
     if(document.forms[0].chkPanValidate.value=="true")
	{ // if block replaced by mujafar for AAKH-SCF-0344
	 var temp=document.forms[0].alt_id3_no.value;
	 var temp1=document.forms[0].pancard_no.value;
	 temp=temp.toUpperCase();
	 temp1=temp1.toUpperCase();
	  // added by mujafar for ICN-64510 end
	
  
   

		
		if(temp != temp1) // modified by mujafar ICN-64510
		{
		pan_holder_name = document.forms[0].pan_holder_name.value = "";
		pan_status = document.forms[0].pan_status.value = "";
		document.forms[0].pan_trans_id.value ="";
		document.getElementById("pancard_display").innerHTML='\xa0\xa0'+pan_status+'\xa0\xa0\xa0\xa0\xa0\xa0\xa0'+pan_holder_name;
		var select = document.getElementById("pan_rel_mem");
		select.options.value='';
		document.getElementById("pancard_pancardrelation").style.visibility = 'hidden';
		document.getElementById("pancard_relationship").style.visibility = 'hidden';
		}
	}
	
	
}
// added by mujafar for KDAH-CRF-370.1 END 
/*End*/
function primaryOnChange(obj){ 
	if(obj.value=="Y" && document.forms[0].alt_id3_no.value !=""){
		//Commented by Sethu on 17/07/2023 for Edge Compatibility
	/* 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
		xmlStr ='<root><SEARCH /></root>';
		//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=primaryNuhdeek&alt_id3_no='+document.forms[0].alt_id3_no.value+'&patient_id='+document.forms[0].patient_id.value,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		if(responseText > 0){							
			alert(getMessage("NUDHEEK_PRIMARY_NO_EXISTS",'MP'));							
			obj.value="";						
		}
	}
}

function nuhdeekField(){
		 if(document.forms[0].isNuhdeekIDAppl.value=="true"){
			if(document.forms[0].alt_id3_no.value!="" && document.forms[0].alt_id3_no.value!=document.forms[0].alt_id3_no_dup.value){
				if(document.forms[0].primaryMember.disabled){
					document.forms[0].primaryMember.disabled=false;
				}					
			    if(document.getElementById("otpSuccess")!=null){ 
					document.getElementById("otpSuccess").style.visibility='hidden';
					document.getElementById("otpSuccess").innerHTML="";
					document.forms[0].getOtp.disabled = true;
				}
				if(document.getElementById("OTP")!=null){ 
					document.getElementById("OTP").style.visibility='hidden';					
				}
				if(document.getElementById("otpError")!=null){
					document.getElementById("otpError").style.visibility='visible';
					document.getElementById("otpError").innerHTML="";
				}
				if(document.getElementById("otpValidationSuccess")!=null){
					document.getElementById("otpValidationSuccess").style.visibility='visible';
					document.getElementById("otpValidationSuccess").innerHTML="";
				}
				if(document.getElementById("otpValidationError")!=null){
					document.getElementById("otpValidationError").style.visibility='visible';
					document.getElementById("otpValidationError").innerHTML="";
				}
				if(document.forms[0].getOtp.disabled){
					document.forms[0].getOtp.disabled=false;
				}			
				document.forms[0].alt_id3_no_dup.value=document.forms[0].alt_id3_no.value;
				if(document.forms[0].primaryMember.value=="Y"){
					primaryOnChange(document.forms[0].primaryMember)
				}

				if(document.forms[0].nuhdeekReady.value=="Y")
					document.forms[0].nuhdeekReady.value="N";
			}
			if(document.forms[0].alt_id3_no.value==""){ 
				if(document.forms[0].primaryMember.disabled==false){
					document.forms[0].primaryMember.value="";
					document.forms[0].primaryMember.disabled=true;
				}
				if(document.forms[0].getOtp.disabled==false){
					document.forms[0].getOtp.disabled=true;
				}
			    if(document.getElementById("otpSuccess")!=null){ 
					document.getElementById("otpSuccess").style.visibility='hidden';
					document.getElementById("otpSuccess").innerHTML="";
					document.forms[0].getOtp.disabled = true;
				}
				if(document.getElementById("OTP")!=null){ 
					document.getElementById("OTP").style.visibility='hidden';					
				}
				if(document.getElementById("otpError")!=null){
					document.getElementById("otpError").style.visibility='hidden';
					document.getElementById("otpError").innerHTML="";
				}
				if(document.getElementById("otpValidationSuccess")!=null){
					document.getElementById("otpValidationSuccess").style.visibility='hidden';
					document.getElementById("otpValidationSuccess").innerHTML="";
				}
				if(document.getElementById("otpValidationError")!=null){
					document.getElementById("otpValidationError").style.visibility='hidden';
					document.getElementById("otpValidationError").innerHTML="";
				}
				if(document.forms[0].nuhdeekReady.value=="Y")
					document.forms[0].nuhdeekReady.value="N";
			}
	 }
}


function getOTP(facility_id,patient_id,login_user,action,login_ws_no){	
if(document.forms[0].alt_id3_no.value!=""){
	if(document.forms[0].primaryMember.value!=""){
	if(action=="GENERATE_OTP"){
			if(document.getElementById("otpValidationError")!=null){
				if(document.getElementById("otpValidationError").style.visibility=='visible'){
					document.getElementById("otpValidationError").style.visibility='hidden';					
				}
				if(document.forms[0].OTP){ 
					document.forms[0].OTP.value="";
				}
			}
			var strValue = "<FACILITY_ID>FID$!^<PATIENT_ID>PATID$!^<PHONE_NUM>ALTID3$!^<PRIM_SEC_FLAG>PRIMARY_NUHDEEK_YN$!^<OTP>$!^<REQUEST>GENERATE_OTP$!^<USER>LOGON_USER_ID$!^<WS_NO>DFLT_WSNO";
			strValue=strValue.replace("FID",facility_id);
			strValue=strValue.replace("PATID",patient_id);
			strValue=strValue.replace("ALTID3",document.forms[0].alt_id3_no.value);
			strValue=strValue.replace("PRIMARY_NUHDEEK_YN",document.forms[0].primaryMember.value);
			strValue=strValue.replace("LOGON_USER_ID",login_user);
			strValue=strValue.replace("DFLT_WSNO",login_ws_no);
			var returnval = OTPTransaction(strValue);
			//returnval = "S$!^OTP Successfully Generated."
			//returnval = "E$!^Error Message";
			var returnArray = returnval.split("$!^");
			if(returnArray[0] == 'S'){		
				if(document.getElementById("otpSuccess")!=null){ 
					document.getElementById("otpSuccess").style.visibility='visible';
					document.getElementById("otpSuccess").innerHTML=returnArray[1];
					document.forms[0].getOtp.disabled = true;
				}
				if(document.getElementById("OTP")!=null){ 
					document.getElementById("OTP").style.visibility='visible';					
				}
			}else if(returnArray[0] == 'E'){
				if(document.getElementById("otpError")!=null){
					document.getElementById("otpError").style.visibility='visible';
					document.getElementById("otpError").innerHTML=returnArray[1];
					if(document.forms[0].getOtp.disabled==true){
						document.forms[0].getOtp.disabled=false;
					}
				}
			}else{
				alert("No response from OTP server");
			    }
		   }
		}else{
			alert(getMessage("PRIMARY_CANNOT_BLANK",'MP'));							
		}	
	  }
  }

function validateOTP(facility_id,patient_id,login_user,action,login_ws_no){
if(document.forms[0].alt_id3_no.value!="" && document.forms[0].OTP.value!=""){
	if(action=="VALIDATE_OTP"){	
			var strValue = "<FACILITY_ID>FID$!^<PATIENT_ID>PATID$!^<PHONE_NUM>ALTID3$!^<PRIM_SEC_FLAG>PRIMARY_NUHDEEK_YN$!^<OTP>OTP_VALUE$!^<REQUEST>VALIDATE_OTP$!^<USER>LOGON_USER_ID$!^<WS_NO>DFLT_WSNO";
			strValue=strValue.replace("FID",facility_id);
			strValue=strValue.replace("PATID",patient_id);
			strValue=strValue.replace("ALTID3",document.forms[0].alt_id3_no.value);
			strValue=strValue.replace("PRIMARY_NUHDEEK_YN",document.forms[0].primaryMember.value);
			strValue=strValue.replace("OTP_VALUE",document.forms[0].OTP.value);
			strValue=strValue.replace("LOGON_USER_ID",login_user);
			strValue=strValue.replace("DFLT_WSNO",login_ws_no);
			var returnval = OTPTransaction(strValue);
			//returnval = "S$!^OTP Validation Successful."
			//returnval = "E$!^Error Message";
			var returnArray = returnval.split("$!^");
			if(returnArray[0] == 'S'){
				if(document.getElementById("otpValidationError")!=null){
					if(document.getElementById("otpValidationError").style.visibility=='visible'){
						document.getElementById("otpValidationError").innerHTML="";
					}
				}
				if(document.getElementById("otpValidationSuccess")!=null){ 
					document.getElementById("otpValidationSuccess").style.visibility='visible';
					document.getElementById("otpValidationSuccess").innerHTML="Nuhdeek Ready";
					document.forms[0].nuhdeekReady.value="Y";					
				}
			}else if(returnArray[0] == 'E'){
				if(document.getElementById("otpValidationSuccess")!=null){ 
					if(document.getElementById("otpValidationSuccess").style.visibility=='visible')
					document.getElementById("otpValidationSuccess").innerHTML="";
					document.forms[0].nuhdeekReady.value="N";					
				}
				if(document.getElementById("otpValidationError")!=null){
					document.getElementById("otpValidationError").style.visibility='visible';
					document.getElementById("otpValidationError").innerHTML=returnArray[1];
					if(document.forms[0].getOtp.disabled==true){
						document.forms[0].getOtp.disabled=false;
					}
				}
			}else{
				alert("No response from OTP validation server");
		  }
		}
	}else{
		if(document.getElementById("otpValidationSuccess")!=null){
					document.getElementById("otpValidationSuccess").style.visibility='hidden';
					document.getElementById("otpValidationSuccess").innerHTML="";
				}
				if(document.getElementById("otpValidationError")!=null){
					document.getElementById("otpValidationError").style.visibility='hidden';
					document.getElementById("otpValidationError").innerHTML="";
				}
	}
 }
// Added for MO-CRF-20162 by KAMATCHI S
function checkstatus(obj)
{
	var patient_id = obj;
	//Commented by Sethu on 17/07/2023 for Edge Compatibility
	/* 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	*/
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc = "";
	xmlStr ='<root><SEARCH /></root>';
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=checkStatus&patient_id='+patient_id.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var chkstatus	= TrimStr(responseText);
	if(chkstatus == "SUSPENDED")
    {
		alert(getMessage("PAT_SUSPENDED_NOT_ALLOWED",'MP'));
		obj.value="";
		obj.focus();
    }
}

