function apply() {

	var fields = new Array ( f_query_add_mod.f_search.document.ChangePract_form.location,
		         f_query_add_mod.f_search.document.ChangePract_form.resource,
				 f_query_add_mod.f_search.document.ChangePract_form.from_date,
				 f_query_add_mod.f_search.document.ChangePract_form.to_date,
				 f_query_add_mod.f_search.document.ChangePract_form.pract_from,
				 f_query_add_mod.f_search.document.ChangePract_form.pract_to,
				 f_query_add_mod.f_search.document.ChangePract_form.reason1

				);

	var names = new Array ( getLabel("Common.Location.label","Common"),getLabel("Common.resource.label","Common"),
				getLabel("Common.fromdate.label","Common"),
				getLabel("Common.todate.label","Common"),
				getLabel("Common.fromresource.label","Common"),
				getLabel("Common.toresource.label","Common"),
				getLabel("Common.reason.label","Common")
  			      );
	if ( checkFields( fields, names, messageFrame) ) {
		if(frames[1].frames[1].document.forms[0])
		{

			var n = frames[1].frames[1].document.forms[0].no_of_rec.value;
			var sel=0;
			var p="";
			var fin=true;

			var finstr="";
			for(var k=0;k<n;k++)
			{
				var ad_chk_obj = eval("frames[1].frames[1].document.forms[0].ad_chk_"+k);
				if(ad_chk_obj.checked == true)
				{
					var con_val_obj = eval("frames[1].frames[1].document.forms[0].con_val_"+k).value;
					if (fin==true)
					{
						finstr = con_val_obj;
						fin=false;
					}
					else
					{
						finstr += "~"+con_val_obj;
					}
						
					sel++;
				}
	//			fin++;

			}
			frames[1].frames[1].document.forms[0].final_vals.value = finstr;
			frames[1].frames[1].document.forms[0].sel_rec.value = sel	;	
//			parent.frames[1].frames[1].frames[1].document.forms[0].genrep.value = "N"	;
		   	if (finstr=="")
		   	{
			var msg =frames[1].frames[0].getMessage("INVALID_SELECT_FOR_CHGPR","OA");
			parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0' ;
			}
			else
			frames[1].frames[1].document.forms[0].submit();

		}
		else{
			frames[1].frames[0].document.forms[0].only_header.value="Y";
			var n = frames[1].frames[0].document.forms[0].location.value;
			var arr =  new Array();
			arr = n.split("|");
			var locncode = arr[0];	
			frames[1].frames[0].document.forms[0].P_Clinic_Code.value = locncode;
			frames[1].frames[0].document.forms[0].eff_from.value =parent.frames[1].frames[1].frames[0].document.forms[0].from_date.value;
			 frames[1].frames[0].document.forms[0].eff_to.value = parent.frames[1].frames[1].frames[0].document.forms[0].to_date.value;
			 frames[1].frames[0].document.forms[0].reason.value = parent.frames[1].frames[1].frames[0].document.forms[0].remarks.value;
			 frames[1].frames[0].document.forms[0].P_Practitioner_Id.value = parent.frames[1].frames[1].frames[0].document.forms[0].pract_from.value;
			 frames[1].frames[0].document.forms[0].P_To_Practitioner_Id.value = parent.frames[1].frames[1].frames[0].document.forms[0].pract_to.value;
			 frames[1].frames[0].document.forms[0].P_Day_No.value = 
			 frames[1].frames[0].document.forms[0].day.value;

//			parent.frames[0].document.forms[0].day.value;

			 frames[1].frames[0].document.forms[0].submit();

		}
	 }
}

function setVal(Obj)
{
	if(Obj.checked == true)
		Obj.value ="Y"
	else
		Obj.value ="N"
}

function generateReport()
{
	if(parent.frames[1].document.forms[0])
	{
		var n = parent.frames[1].document.forms[0].no_of_rec.value;
		var sel=0;
		var p="";
		var fin=true;

		var finstr="";
		for(var k=0;k<n;k++)
		{
			var ad_chk_obj = eval("parent.frames[1].document.forms[0].ad_chk_"+k);
			if(ad_chk_obj.checked == false)
			{
				var con_val_obj = eval("parent.frames[1].document.forms[0].con_val_"+k).value;
				if (fin==true)
				{
					finstr = con_val_obj;
					fin=false;
				}
				else
				{
					finstr += "~"+con_val_obj;
				}
					
				sel++;
			}
//			fin++;

		}
		parent.frames[1].document.forms[0].final_vals.value = finstr;
		parent.frames[1].document.forms[0].sel_rec.value = sel	;	
		parent.frames[1].document.forms[0].genrep.value = "Y"	;
		parent.frames[1].document.forms[0].submit();

 	}
 	else{
		parent.frames[0].document.forms[0].genrep.value = "Y"	;
		parent.frames[0].document.forms[0].only_header.value="Y";
		var n = parent.frames[0].document.forms[0].location.value;
		var arr =  new Array();
		arr = n.split("|");
		var locncode = arr[0];	
		parent.frames[0].document.forms[0].P_Clinic_Code.value = locncode;
		parent.frames[0].document.forms[0].eff_from.value =parent.frames[0].document.forms[0].from_date.value;
		parent.frames[0].document.forms[0].eff_to.value = parent.frames[0].document.forms[0].to_date.value;
		parent.frames[0].document.forms[0].reason.value = parent.frames[0].document.forms[0].remarks.value;
		parent.frames[0].document.forms[0].P_Practitioner_Id.value = parent.frames[0].document.forms[0].pract_from.value;
		parent.frames[0].document.forms[0].P_To_Practitioner_Id.value = parent.frames[0].document.forms[0].pract_to.value;
		parent.frames[0].document.forms[0].P_Day_No.value = parent.frames[0].document.forms[0].day.value;

		parent.frames[0].document.forms[0].submit();

	}
}



function clear_list(obj) {
    while(obj.options.length > 0) {
            obj.remove(obj.options[0]);
    }
}


function Select_Click(f_id) {
        //location1,resource
        var facility_id = f_id;
        var location = parent.f_search.document.ChangePract_form.location.value;
        var from_pract_id = parent.f_search.document.ChangePract_form.pract_from.value;
        var to_pract_id = parent.f_search.document.ChangePract_form.pract_to.value;
        var day = parent.f_search.document.ChangePract_form.day.value;
        var from_dt = parent.f_search.document.ChangePract_form.from_date.value;
        var to_dt = parent.f_search.document.ChangePract_form.to_date.value;
		var reason = parent.f_search.document.ChangePract_form.remarks.value;
		var reason1 = parent.f_search.document.ChangePract_form.reason1.value;
		var locationType = parent.f_search.document.ChangePract_form.location1.value;
		var resourceType = parent.f_search.document.ChangePract_form.resource.value;
		//alert(locationType+" "+resourceType);
	var fields = new Array ( parent.f_search.document.ChangePract_form.location,
				 parent.f_search.document.ChangePract_form.from_date,
				 parent.f_search.document.ChangePract_form.to_date,
				 parent.f_search.document.ChangePract_form.pract_from,
				 parent.f_search.document.ChangePract_form.pract_to,
				 parent.f_search.document.ChangePract_form.reason1

				);

	var names = new Array ( getLabel("Common.Location.label","Common"),
				getLabel("Common.fromdate.label","Common"),
				getLabel("Common.todate.label","Common"),
				getLabel("Common.fromresource.label","Common"),
				getLabel("Common.toresource.label","Common"),
				getLabel("Common.reason.label","Common")
  			      );
	 if ( checkFields( fields, names,parent.parent.frames[2]) ) {
	  //Below line modified for this incident [IN:044516]	
	  
	   parent.frames[1].document.location.href = '../../eOA/jsp/ChangePractitionerforGenSchResult.jsp?facility_id='+facility_id+'&locn='+location+'&from_pract='+from_pract_id+'&to_pract='+to_pract_id+'&day='+day+'&from_dt='+from_dt+'&to_dt='+to_dt+'&reason='+reason+'&reason1='+encodeURIComponent(reason1)+'&locationType='+locationType+'&resourceType='+resourceType;
	 }

}



function reset() {
    frames[1].frames[0].document.location.href = '../../eOA/jsp/ChangePractitionerforGenSch.jsp';
    frames[1].frames[1].document.location.href = '../../eCommon/html/blank.html';

}

	function onSuccess() {
		reset();
	}


	function clearDetail(){
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
	    document.forms[0].genRep1.disabled=true;	
	}

/*To populate the days for which schedule has been generated based on the Location Selected*/
	 function Loc_Change(obj) {
       var loc=obj.value;
	   var facilityId= document.forms[0].P_Facility_id.value;
       var HtmlVal;
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
       document.forms[0].pract_from.value=''; document.forms[0].pract_from_desc.value='';
       document.forms[0].pract_to.value=''; document.forms[0].pract_to_desc.value='';
      if(loc == null || loc == '') {
	   document.forms[0].from.disabled=true;
		  clear_list(parent.f_search.document.ChangePract_form.day);
          var opt1;
          opt1 = parent.f_search.document.createElement("OPTION");
          opt1.text = ' --------'+getLabel("Common.defaultSelect.label","Common")+'--------- ';
          opt1.value='';
        parent.f_search.document.ChangePract_form.day.add(opt1);
       }
	else
	document.forms[0].from.disabled=false;
	document.forms[0].pract_from_desc.disabled=false;
       if ( !(loc == null || loc == '') ) {
           clear_list(parent.f_search.document.ChangePract_form.day);
           HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eOA/jsp/GetValChgPract.jsp' method='post'><input type='hidden' name='locn' id='locn' value='"+loc+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></body></html>"
           parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
           parent.parent.messageFrame.document.dummy_form.submit();
		
     }
     }
/*To populate the practitioner name based on the Selected Location*/
     function Change_Pract(obj) {
		 	   var facilityId= document.forms[0].P_Facility_id.value;

       var pract_from=obj.value;
       var HtmlVal;
       var loc = parent.f_search.document.ChangePract_form.location.value;
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
       if(pract_from == null || pract_from == '') {
          clear_list(parent.f_search.document.ChangePract_form.pract_to);
          var opt;
          opt = parent.f_search.document.createElement("OPTION");
          opt.text=' ---------'+getLabel("Common.defaultSelect.label","Common")+'--------- ';
          opt.value='';
          parent.f_search.document.ChangePract_form.pract_to.add(opt);
       }
       if ( !(pract_from == null || pract_from == '') ) {
           clear_list(parent.f_search.document.ChangePract_form.pract_to);
           HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eOA/jsp/GetValChgFromPract.jsp' method='post'><input type='hidden' name='pract_id' id='pract_id' value='"+pract_from+"'><input type='hidden' name='loc' id='loc' value='"+loc+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facilityId+"'></form></body></html>"
           parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
           parent.parent.messageFrame.document.dummy1_form.submit();
       }
     }

     function pract_to_change() {
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
     }
     function day_change() {
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
     }
     function from_date_change() {
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
     }
     function to_date_change() {
       parent.f_search_result.location.href = '../../eCommon/html/blank.html';
     }

function locationreturn(obj)
{
	/*var n=document.forms[0].location.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].location.remove("clinic");
		
	}*/
	if(obj.value==null||obj.value==""){
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	/*document.forms[0].all.resource.value="";
	document.forms[0].all.resource.disabled=true;
	document.forms[0].all.pract_from_desc.value="";
	document.forms[0].all.pract_from_desc.disabled=true;
	document.forms[0].all.from.disabled=true;
	document.forms[0].all.pract_to_desc.value="";
	document.forms[0].all.pract_to_desc.disabled=true;
	document.forms[0].all.to.disabled=true;*/
	document.forms[0].resource.value="";
	document.forms[0].resource.disabled=true;
	document.forms[0].pract_from_desc.value="";
	document.forms[0].pract_from_desc.disabled=true;
	document.forms[0].from.disabled=true;
	document.forms[0].pract_to_desc.value="";
	document.forms[0].pract_to_desc.disabled=true;
	document.forms[0].to.disabled=true;
	}else{
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].b_loc_val.disabled=false;
	document.forms[0].b_loc_search.disabled=false;
	/*document.forms[0].all.resource.value="";
	document.forms[0].all.resource.disabled=true;
	document.forms[0].all.pract_from_desc.value="";
	document.forms[0].all.pract_from_desc.disabled=true;
	document.forms[0].all.from.disabled=true;
	document.forms[0].all.pract_to_desc.value="";
	document.forms[0].all.pract_to_desc.disabled=true;
	document.forms[0].all.to.disabled=true;*/
	document.forms[0].resource.value="";
	document.forms[0].resource.disabled=true;
	document.forms[0].pract_from_desc.value="";
	document.forms[0].pract_from_desc.disabled=true;
	document.forms[0].from.disabled=true;
	document.forms[0].pract_to_desc.value="";
	document.forms[0].pract_to_desc.disabled=true;
	document.forms[0].to.disabled=true;
	}
	/*var opt=document.createElement("OPTION");
	opt.text=" ------------------------"+getLabel("Common.defaultSelect.label","Common")+"----------------------- ";
	opt.value="";
	//var oper_stn_id=document.forms[0].oper_stn_id.value;
	document.forms[0].location.add(opt);
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	//xmlStr ="<root><SEARCH locn_val=\""+obj.value+"\" oper_stn_id=\""+oper_stn_id+"\" steps='5' /></root>"
	xmlStr ="<root><SEARCH locn_val=\""+obj.value+"\" steps='5' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/
		parent.frames[1].document.location.href='../../eCommon/html/blank.html';
		
}
async function call_common(sql,obj){
	
	var tit				= getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	if(obj =="from")
	{
	argumentArray[5] = document.forms[0].pract_from_desc.value;
	}
	else
	{
	argumentArray[5] = document.forms[0].pract_to_desc.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )	{
		
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(obj == "from")
		{
		document.forms[0].pract_from_desc.value=arr[1];
		document.forms[0].pract_from.value=arr[0];
		}
		else
		{
			document.forms[0].pract_to_desc.value=arr[1];
			document.forms[0].pract_to.value=arr[0];
		}
		
	
	}else{
		if (obj == "from")
		{
		document.forms[0].pract_from_desc.value="";
		document.forms[0].pract_from.value="";
		}
		else
		{
		document.forms[0].pract_to_desc.value="";
		document.forms[0].pract_to.value="";
		}

	}
}

function enablepr()
{
/*	var chk='';
var si=document.forms[0].location.options.selectedIndex-1;

document.getElementById("location_code1").value= document.forms[0].location.value;


if (si==-1){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 document.forms[0].resource.disabled= false;
}*/
var obj=document.forms[0].location;
	if(obj.value==null||obj.value==""){
	document.forms[0].resource.disabled= true;
	document.getElementById("location_code1").value= document.forms[0].location.value;
}else{
	document.forms[0].resource.disabled= false;
	document.getElementById("location_code1").value= document.forms[0].location.value;
}
}
function validateTbs(){
var clValue=document.forms[0].location.value;

 if (!document.forms[0].pract_from_desc.disabled){
document.forms[0].pract_from_desc.value="";
document.forms[0].resource.value="";
document.forms[0].pract_from_desc.disabled=true;
document.forms[0].from.disabled=true;
}
	parent.frames[1].document.location.href='../../eCommon/html/blank.html';
}

function practValidate(){
var clinicCode=document.forms[0].location.value;
var resourceCode=document.forms[0].resource.value;

document.getElementById("resourceType1").value=document.getElementById("resource").value;

if (clinicCode!=null && clinicCode!="" && resourceCode !=null && resourceCode!=""){

document.forms[0].pract_from_desc.value="";
document.forms[0].pract_to_desc.value="";
document.forms[0].pract_from.value="";
document.forms[0].pract_to.value="";
document.forms[0].pract_from_desc.disabled=false;
document.forms[0].from.disabled=false;
document.forms[0].pract_to_desc.disabled=true;
document.forms[0].to.disabled=true;
}
else
{
document.forms[0].pract_from_desc.value="";
document.forms[0].pract_to_desc.value="";
document.forms[0].pract_from.value="";
document.forms[0].pract_to.value="";
document.forms[0].pract_to_desc.disabled=true;
document.forms[0].to.disabled=true;
document.forms[0].pract_from_desc.disabled=true;
document.forms[0].from.disabled=true;
 }
	//parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';
 	parent.frames[1].document.location.href='../../eCommon/html/blank.html';
}

function resourceOnBlur(){
	var selIn=document.forms[0].resource.options.selectedIndex;

	var valIs= document.forms[0].resource.options[selIn].value;
	document.getElementById('resourceType').value=valIs;
	//parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';
	parent.frames[1].document.location.href='../../eCommon/html/blank.html';
}
function gen_report()
{

	var fields = new Array ( parent.f_search.document.ChangePract_form.location,
				 parent.f_search.document.ChangePract_form.from_date,
				 parent.f_search.document.ChangePract_form.to_date,
				 parent.f_search.document.ChangePract_form.pract_from,
				 parent.f_search.document.ChangePract_form.pract_to,
				 parent.f_search.document.ChangePract_form.reason1
				);
	var names = new Array ( getLabel("Common.Location.label","Common"),
				getLabel("Common.fromdate.label","Common"),
				getLabel("Common.todate.label","Common"),
				getLabel("Common.fromresource.label","Common"),
				getLabel("Common.toresource.label","Common"),
				getLabel("Common.reason.label","Common")
			      );
	 if ( checkFields( fields, names,parent.parent.frames[2]) ) {
			var pract_from_desc		= document.forms[0].pract_from_desc.value;
			var pract_to_desc		= document.forms[0].pract_to_desc.value;
			var p_clinic_code		= document.forms[0].location.value;
			var arr =new Array();
			arr=p_clinic_code.split('|');
			p_clinic_code = arr[0];
			var p_day_no =document.forms[0].day.value; //this line added for this incident [IN:044516]
           /*Below line commented incident [IN:044516]*/
		   /* if (document.forms[0].day.value!="")
			p_day_no= document.forms[0].day.options(document.forms[0].day.options.selectedIndex).text;
			else
			p_day_no			= "";*/
			
			//End [IN:044516]
			
			var p_facility_id		= document.forms[0].P_Facility_id.value;
			/*Below line Added and commented for this incident [IN:044516]*/
			var p_from_date=convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
			var p_to_date=convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
			/*var p_from_date			= document.forms[0].from_date.value;
			var p_to_date			= document.forms[0].to_date.value;*/
			//End [IN:044516]
			
			var p_module_id			= "OA";
			var p_practitioner_id	= document.forms[0].pract_from.value;
			var p_reason			= document.forms[0].remarks.value;
			var p_report_id			= "OAAFAPLST";
			var reason1				= document.forms[0].reason_code.value;
			var p_to_pract			= document.forms[0].pract_to.value;
			var p_action            ="CHANGE_OF_PRACTITIONER";
			var p_care_locn_type_ind =document.forms[0].location1.value;
			var p_resource_class=document.forms[0].resourceType.value;
			
			var HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='p_day_no' id='p_day_no' value='"+p_day_no+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_from_date' id='p_from_date' value='"+p_from_date+"'><input type='hidden' name='p_action' id='p_action' value='"+p_action+"'><input type='hidden' name='p_clinic_code' id='p_clinic_code' value='"+p_clinic_code+"'><input type='hidden' name='p_to_date' id='p_to_date' value='"+p_to_date+"'><input type='hidden' name='p_practitioner_id' id='p_practitioner_id' value='"+p_practitioner_id+"'><input type='hidden' name='p_reason' id='p_reason' value='"+p_reason+"'><input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'><input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'><input type='hidden' name='p_to_pract' id='p_to_pract' value='"+p_to_pract+"'><input type='hidden' name='P_TO_PRACT_ID' id='P_TO_PRACT_ID' value='"+p_to_pract+"'><input type='hidden' name='reason1' id='reason1' value='"+reason1+"'><input type='hidden' name='care_locn_type_ind' id='care_locn_type_ind' value='"+p_care_locn_type_ind+"'><input type='hidden' name='resource_class' id='resource_class' value='"+p_resource_class+"'></form></body></html>"
			
			   parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
			   parent.parent.messageFrame.document.dummy1_form.submit();
	 }
}


async function show_modwin(Clcode,pid,cday,Cldate,clinic_type,res_type)
	{
		var retVal;
		var dialogHeight = "40" ;
		var dialogWidth  = "65" ;
		var dialogTop    = "75";
		var dialogLeft   = "280";
		var locncode 	 = Clcode;
		var practid  	 = pid;
		var currdate 	 = Cldate;
		
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		retVal 	 	 = await window.showModalDialog("DispListAppointments.jsp?clinic_code="+locncode+"&practitioner_id="+practid+"&res_type="+res_type+"&clinic_type="+clinic_type+"&Date="+currdate+"&currdate="+currdate+"&clinic_day1="+cday+"&mod=tfr",arguments,features);
		
					
	}

	function clear_select() {
             var opt1;
	     opt1 = parent.f_query_add_mod.f_search.document.createElement("OPTION");
	     opt1.text = ' --------'+getLabel("Common.defaultSelect.label","Common")+'--------- ';
	     opt1.value='';
             parent.f_query_add_mod.f_search.document.ChangePract_form.day.add(opt1);
        }

async function reasonlookup(obj)
{
		var locale1= document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var sql="select contact_reason_code code,contact_reason description, to_char(sysdate,'dd/mm/yyyy') d  from am_contact_reason_lang_vw  where  upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?)   and  transfer_schedule_yn = 'Y'  and language_id = '"+locale1+"' order by contact_reason ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason1.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason1.value=desc;
			document.forms[0].reason_code.value=code;
			
		}else
		{
			document.forms[0].reason1.value="";
			document.forms[0].reason_code.value="";
		}
}



function validate_date_from(from,sys)
{
	
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		var obj1=convertDate(from.value,"DMY",localeName,"en");
		if(isBefore(sys,obj1,'DMY',"en")==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();	
				return false;
			}
			else
				return true;

		}
}



function validate_date_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}

		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
}
}

function compare_from(from,to)
{
if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
}

async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].location1.value;
	var care_locn_ind=document.forms[0].location1.value;
	//alert('location_val-->'+location_val)
	//alert('locn_type-->'+locn_type)
	//alert('care_locn_ind-->'+care_locn_ind)
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=CHG_PRACT_SCH",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var clinic_type=rvalues[3];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=code+"|"+clinic_type+"|"+open_to_all_pract_yn;
		Loc_Change(document.forms[0].location);
		clearDetail();
		enablepr();
		validateTbs();
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		Loc_Change(document.forms[0].location);
		clearDetail();
		enablepr();
		validateTbs();
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		document.forms[0].location.value="";
		Loc_Change(document.forms[0].location);
		clearDetail();
		enablepr();
		validateTbs();
	}else{
	open_loc_lookup()
	}
}

function disableFields(){
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
}

