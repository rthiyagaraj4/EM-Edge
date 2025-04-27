function reset() {
	f_query_add_mod.location.href = "../../eOA/jsp/PurgeScheduleRecordmain.jsp" ;
}



function populateLocations(Obj){

	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" steps='6' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) */
	document.getElementById('practitioner_name').value='';
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('search_pract').disabled=true;
	document.forms[0].resourceType.disabled=true;
	document.forms[0].resourceType.value="";
	document.getElementById('practitioner').value='';



	if(Obj.value==null||Obj.value==""){
	document.getElementById('b_loc_val').disabled=true;
	document.getElementById('b_loc_val').value="";
	document.getElementById('b_loc_search').disabled=true ;

}else{
	document.getElementById('b_loc_val').disabled=false ;
	document.getElementById('b_loc_search').disabled=false ;
}



}

function clearDetail(X){
	
	if(X){
	}else{
		if(document.getElementById('location').value==''){
			document.getElementById('resourceType').value='';
			document.getElementById('resourceType').disabled=true;
			document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
		}else{
			document.getElementById('resourceType').disabled=false;
			document.getElementById('practitioner_name').disabled=false;
		document.getElementById('search_pract').disabled=false;
		}

		document.getElementById('resourceType').value="";
		document.getElementById('practitioner_name').value='';
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
		document.getElementById('practitioner').value='';
	}
	//parent.frames[2].location.href = '../../eCommon/html/blank.html' ;

}

/* Based on the location selected pract_butt is enabled and selected */
function PopPract(obj){
	
	document.getElementById('location_code1').value= document.forms[0].location.value;
	document.forms[0].practitioner_name.value ="";
		document.forms[0].practitioner.value="";
		var  HTMLVal = new String();
		locn = obj.value;
		if (locn == null || locn == '')
		{
			if(document.forms[0].locn_type)
			document.forms[0].locn_type.innerText = '';
			
			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.value='';
			opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';

		}
			
		var p_clinic_code		= document.forms[0].location.value;
		

		if (locn!=null||locn!=''){
			var temp = new Array();
			temp = locn.split("|");
			if(temp[3]=="P")
			document.getElementById('imgpract').style.visibility='visible'
			else
			document.getElementById('imgpract').style.visibility='hidden'
			}
		else
			document.getElementById('imgpract').style.visibility='hidden'
		
		var obj1=document.forms[0].location_type.value;
		if(obj1=='D')
	{
			var res=document.forms[0].resourceType;
		document.forms[0].resourceType.disabled=false;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';

	 res.add(opt);
	 opt=document.createElement('OPTION');
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
	
	} else{  
	   var res=document.forms[0].resourceType;
	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   	opt.value='';
		opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
   
	}
   return obj1;
	
}

function enable_dsiable_res(Obj){
	var arr1=document.getElementById('resourceType').value;
	var arr2=arr1.split("|");
	var pri_res_class=arr2[4];
	
	

	clearDetail('X');

	document.getElementById('resourceType1').value=document.getElementById('resourceType').value;
    
	document.getElementById('practitioner').value='';
	document.getElementById('practitioner_name').value='';
	if(Obj.value==''){
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
	}else{
		document.getElementById('practitioner_name').disabled=false;
		document.getElementById('search_pract').disabled=false;
		if(Obj.value!=pri_res_class){
			clearDetail('X');
			 
		}
			 

	}
	//parent.frames[2].location.href = '../../eCommon/html/blank.html' ;

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
		var sysdt = parent.frames[1].document.forms[0].sys_date1.value;
	
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isAfterNow(obj2,'DMY',localeName))
				{
				alert(getMessage("FROM_DATE_SHOULD_LESS_CURRENT_DATE","OA"));
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
				obj1.value="";
				obj1.select();					
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
			var sysdt = parent.frames[1].document.forms[0].sys_date1.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isAfterNow(obj2,'DMY',localeName))
				{
				alert(getMessage("TO_DATE_SHOULD_LESS_CURRENT_DATE","OA"));
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


function apply()
{
var fields=new Array();
if (frames[1].document.getElementById('imgpract').style.visibility=="hidden")
    {
	
		fields[0]= frames[1].document.forms[0].location_type;
		fields[1]= frames[1].document.forms[0].location;
		fields[2]= frames[1].document.forms[0].resourceType;
		fields[3]= frames[1].document.forms[0].eff_from;
		fields[4]= frames[1].document.forms[0].eff_to;
		fields[5]= frames[1].document.forms[0].time_table_type;

		var names = new Array (	getLabel("Common.locationtype.label","Common"),
								getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.fromdate.label","Common"),
								getLabel("Common.todate.label","Common"),
								getLabel("eOA.TimeTableType.label","OA")
					);
	}
	else
	{
		fields[0]= frames[1].document.forms[0].location_type;
		fields[1]= frames[1].document.forms[0].location;
		fields[2]= frames[1].document.forms[0].resourceType;
		fields[3]= frames[1].document.forms[0].practitioner_name;
		fields[4]= frames[1].document.forms[0].eff_from;
		fields[5]= frames[1].document.forms[0].eff_to;
		fields[6]= frames[1].document.forms[0].time_table_type;

		var names = new Array (	getLabel("Common.locationtype.label","Common"),
								getLabel("Common.Location.label","Common"),
								getLabel("Common.resourcetype.label","Common"),
								getLabel("Common.resourcename.label","Common"),
								getLabel("Common.fromdate.label","Common"),
								getLabel("Common.todate.label","Common"),
								getLabel("eOA.TimeTableType.label","OA")
					);

	}
	var locn_val=frames[1].document.forms[0].location.value;
var location_code=locn_val.split("|");
location_code=location_code[0];
frames[1].document.forms[0].location_code.value=location_code;
var location_type=frames[1].document.forms[0].location_type.value;
var resourceType=frames[1].document.forms[0].resourceType.value;
var practitioner=frames[1].document.forms[0].practitioner.value;
var eff_from=frames[1].document.forms[0].eff_from.value;
var eff_to=frames[1].document.forms[0].eff_to.value;
var time_table_type=frames[1].document.forms[0].time_table_type.value;


	if(checkFields(fields,names,frames[2]))
	{
	//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "location_type=\"" +location_type + "\"  location_code=\"" +location_code+"\" resourceType=\"" +resourceType+"\" practitioner=\"" +practitioner+"\" eff_from=\"" +eff_from+"\" eff_to=\"" +eff_to+"\" time_table_type=\"" +time_table_type+"\" steps='chk_sch_exists'";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
	if (Flag==true)
	{
	frames[1].document.forms[0].action="../../servlet/eOA.PurgeScheduleRecordServet";
	
	frames[1].document.forms[0].target="messageFrame";
	frames[1].document.forms[0].submit();
	}else
	{
		
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	//frames[1].location.reload();
	//frames[1].location.href = "../../eCommon/html/blank.html";
	frames[0].location.reload();
	}
	}
}

function onsuccess(obj)
{
var error_id="";
	if(obj=="true")
	{
	 error_id=encodeURIComponent(getMessage("RECORD_INSERTED","SM"));

	frames[1].location.reload();
	messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
	}else if(obj=="false")
	{
	error_id=getMessage("NO_RECORD_INSERTION","OA");
	messageFrame.document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
	}
}

function chgbuttonclr()
		{
			document.getElementById('b_loc_val').disabled="true" ;
			document.getElementById('b_loc_search').disabled="true" ;


		}
    async function open_loc_lookup(){	

	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].location_type.value;
	var care_locn_ind=document.forms[0].location_type.value;
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
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=PURG_SCH_REC",arguments,features);
	
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var cTyp=rvalues[3];
		var open_to_all_pract_yn=rvalues[2];
		var identitiy_check_in=rvalues[4];
		var primary_resource_class=rvalues[5];

        document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=clinic_code+"|"+cTyp+"|"+open_to_all_pract_yn+"|"+identitiy_check_in+"|"+primary_resource_class;
		document.forms[0].resourceType.disabled=false;


	}else{	
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		document.forms[0].resourceType.value="";
		document.getElementById('resourceType').disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
         document.forms[0].resourceType.value="";
		document.getElementById('resourceType').disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;

	}else{
	open_loc_lookup()
	}
}
