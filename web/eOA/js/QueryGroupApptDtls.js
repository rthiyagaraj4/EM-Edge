
function populateLocations(Obj){
			if(Obj.value==null || Obj.value==""){
			document.getElementById("b_loc_val").value="";
			document.getElementById("b_loc").value="";
			document.getElementById("group_name").value="";
			document.getElementById("group_id").value="";
			document.getElementById("b_loc_val").disabled=true;
			document.getElementById("b_loc_search").disabled=true;
			document.getElementById("group_name").disabled=true;
			document.getElementById("group_name_lookup").disabled=true;
			clearValues();
			}else{
			document.getElementById("b_loc_val").value="";
			document.getElementById("b_loc").value="";
			document.getElementById("b_loc_val").disabled=false;
			document.getElementById("b_loc_search").disabled=false;
			}
			}
			
	
			function populateGroup(Obj){
			if(Obj.value==null || Obj.value==""){
			document.getElementById("group_name").value="";
			document.getElementById("group_id").value="";
			document.getElementById("group_name").disabled=true;
			document.getElementById("group_name_lookup").disabled=true;
			}else{
			document.getElementById("group_name").value="";
			document.getElementById("group_id").value="";
			document.getElementById("group_name").disabled=false;
			document.getElementById("group_name_lookup").disabled=false;
			}
			}

	function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			document.forms[0].b_loc_val.value="";
			document.forms[0].b_loc.value="";
			}else{
		open_loc_lookup()
		}
	}


	async function open_loc_lookup(){
		var location1=document.forms[0].locationType.value;
		var location_val=document.forms[0].b_loc_val.value;
		locn_type=location1 
		var care_locn_ind=location1; 
		var dialogTop = "60" ;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var status = "no";
		var arguments	= "" ;
		var tit="locn_Srch";
		var clinic_desc=""
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&clinic_desc="+clinic_desc+"&function_id=SCH_APPT",arguments,features);
			
		if(retVal!=null){
			var rvalues=retVal.split("~");
			var code=rvalues[0];	 
						
			document.forms[0].b_loc_val.value=rvalues[1];
			document.forms[0].b_loc.value=rvalues[0];
			
		}else{
			document.forms[0].b_loc_val.value="";
			document.forms[0].b_loc.value="";
			
		
		}

	}
	
function validate_date_from(obj,obj1)
{
	if(obj.value!="")
	{
	
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt =document.forms[0].sys_date.value;		
		if(isBefore(sysdt,obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			
	}
	
		


	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

function validate_date_to(obj,obj1)
{	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
			var sysdt = document.forms[0].sys_date.value;		
		if(isBefore(sysdt,obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

function chkmangif()
{
document.getElementById("b_loc_val").disabled=true;
document.getElementById("b_loc_search").disabled=true;
document.getElementById("group_name").disabled=true;
document.getElementById("group_name_lookup").disabled=true;
var sysdate=document.forms[0].sys_date.value;
var sysdate1=document.forms[0].sysdate1.value;
document.forms[0].b_from_date.value=sysdate;
document.forms[0].b_to_date.value=sysdate1; 
}


async function callgroupname(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	   
	tit=getLabel("Common.Group.label",'Common');
	var loc_code=document.forms[0].b_loc.value;
	sql ="select distinct a.group_id code, a.group_name description from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and locn_code = '"+loc_code+"' and a.group_id=b.group_id and upper(a.group_id) like upper(?) and upper(a.group_name) like upper(?) order by 2";	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );	
	if(retVal != null && retVal != "" ) {
              var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
	    document.forms[0].group_name.value=arr[1];	
	    document.forms[0].group_id.value=arr[0];
	    var GroupId		= document.forms[0].group_id.value;
	    callGroupLocation(GroupId);
    } else {
		document.forms[0].group_name.value = "";
		clearValues();
    }
}

function clearValues(){
	$("#min_patient").val("");
	$("#max_patient").val("");
	$("#Existing_Group_Members").val("");
	$("#group_location_id").val("");
	$("#TdLocationResult").html("");

}

function callGroupLocation(GroupId){
	 $.ajax({  
      url:'../../eOA/jsp/GetGroupPat.jsp',  
      type:'post',  
      data:{'GroupId':GroupId},
      dataType: 'json',
      success: function(data) {
     	/* if(data.isJsonResults==1){
     		var ResultString	= "";
     		ResultString+="<span style='margin-left:10px;' class='label'>Min Patients: "+data.MIN_PATIENTS+"</span>";
     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('eOA.MaxPatients.label','eOA')+" : "+data.MAX_PATIENTS+"</span>";
     		$("#min_patient").val(data.MIN_PATIENTS);
     		$("#max_patient").val(data.MAX_PATIENTS);
     		$("#TdLocationResult").html(ResultString);
     	 }*/
		 /*Above line commented and below line added by senthil*/
		  if(data.isJsonResults==1){
	     		var ResultString	= "";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.Location.label','Common')+" : "+data.LOCN_NAME+"</span>";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.MIN.label','Common')+" "+getLabel('Common.patient.label','Common')+" : "+data.MIN_PATIENTS+"</span>";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.Max.label','Common')+" "+getLabel('Common.patient.label','Common')+" : "+data.MAX_PATIENTS+"</span>";
	     		if(data.TotMemberInGroup > 0){
	     			ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('eOA.TotalPatientsLinkedInGroup.label','OA')+" : "+data.TotMemberInGroup+"</span>";
	     		}
	     		$("#min_patient").val(data.MIN_PATIENTS);
	     		$("#max_patient").val(data.MAX_PATIENTS);
	     		$("#Existing_Group_Members").val(data.TotMemberInGroup);
	     		$("#group_location_id").val(data.LOCN_CODE);
	     		$("#TdLocationResult").html(ResultString);
	    	   
	     	 }
		 
      } ,
      error: function(jqXHR, textStatus, errorThrown) {
          alert("incoming Text " + jqXHR.responseText);
      }
  });  
}



function callResult()
{
	    var value1 = document.forms[0].b_from_date.value;
		var value2 =document.forms[0].b_to_date.value;
		var dbd=0;
		if(value1 !='' && value2 !=''){
			var day1, day2;
			var month1, month2;
			var year1, year2;
			
			day1 = value1.substring (0, value1.indexOf ("/"));
			month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
			year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);

			day2 = value2.substring (0, value2.indexOf ("/"));
			month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
			year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length); 

			date1 = year1+"/"+month1+"/"+day1;
			date2 = year2+"/"+month2+"/"+day2;
			firstDate = Date.parse(date1)
			secondDate= Date.parse(date2)
			msPerDay = 24 * 60 * 60 * 1000;
			dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
		}

		if(dbd>14){
			
			var msg=getMessage("SRCH_PER_VALID","OA");
			msg = msg.replace('$','14');
			alert(msg);
			document.forms[0].b_to_date.value="";
			parent.frame2.location.href='../../eCommon/html/blank.html' ;
			parent.frames[1].document.forms[0].select.disabled=false;

		}
	var fields = new Array (parent.frames[1].document.forms[0].group_name,parent.frames[1].document.forms[0].b_from_date, parent.frames[1].document.forms[0].b_to_date);

	var names = new Array (getLabel("Common.Group.label","Common"),getLabel("eOA.ApptDateFrom.label","oa"),getLabel("eOA.ApptDateTo.label","oa"));



	if(!parent.frames[1].checkFields( fields, names, parent.frames[3]))
	{
		parent.frame2.location.href = '../../eCommon/html/blank.html' ;
	}
	else{
		parent.frames[1].document.forms[0].select.disabled=true;
		parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp' ;
		var loc= parent.frames[1].document.forms[0].b_loc.value;
		var loc_Type= parent.frames[1].document.forms[0].locationType.value;
		var group_id= parent.frames[1].document.forms[0].group_id.value;
		var fromDate= parent.frames[1].document.forms[0].b_from_date.value;
		var toDate= parent.frames[1].document.forms[0].b_to_date.value;		
		var group_name= parent.frames[1].document.forms[0].group_name.value;
		
		var min_patient= parent.frames[1].document.forms[0].min_patient.value;//this line added by senthil	 
				
		parent.frame2.location.href = "../../eOA/jsp/QueryGroupApptResult.jsp?locationType="+loc_Type+"&location="+loc+"&group_id="+group_id+"&fromDate="+fromDate+"&toDate="+toDate+"&group_name="+group_name+"&min_patient="+min_patient;
	}
}

function clearAll(){
parent.frame2.location.href='../../eCommon/html/blank.html' ;
parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp' ;
}
function reset()
{    
window.location.reload();
}
