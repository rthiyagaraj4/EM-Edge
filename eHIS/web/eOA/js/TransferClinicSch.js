function apply()
{ 
	if(self.frames[2].document.forms[0])
	{
		var n = self.frames[2].document.forms[0].no_of_rec.value;
		var e=0;
		var p="";
		var p1="";
		var sel=0;
		for(var k=0;k<n;k++){
			if(self.frames[2].document.forms[0].elements[e].checked == true){
				p += self.frames[2].document.forms[0].elements[e+1].value + "-";
				p1 += self.frames[2].document.forms[0].elements[e+2].value + "-";
				sel++;
				

			}
				e+=3;
		}

		self.frames[2].document.forms[0].final_vals.value = p;
		self.frames[2].document.forms[0].final_vals1.value = p1;
		self.frames[2].document.forms[0].sel_rec.value = sel	;
		if(self.frames[2].document.forms[0].final_vals.value == '' || self.frames[2].document.forms[0].final_vals.value == null)
		{
			var msg = self.frames[2].getMessage("INVALID_TRAN_SELECT","OA");
			self.frames[3].location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0' ;
		}else
		{

		self.frames[2].document.forms[0].submit();
		}
	}else{
			var fields=new Array();
			var names = new Array ();
			if(self.frames[1].document.forms[0].date_day[0].checked == true)
			{    
				fields[0]= self.frames[1].document.forms[0].b_loc_val;
				fields[1]= self.frames[1].document.forms[0].resourceType;
				fields[2]= self.frames[1].document.forms[0].eff_from;
				fields[3]= self.frames[1].document.forms[0].eff_to;
				fields[4]= self.frames[1].document.forms[0].reason;
				names[0]=getLabel("Common.Location.label","Common");
				names[1]=getLabel("Common.resourcetype.label","Common");
				names[2]=getLabel("Common.fromdate.label","Common");
				names[3]=getLabel("Common.todate.label","Common");
				names[4]=getLabel("Common.reason.label","Common");
				
				/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
				if(self.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
				{
					fields[5] = self.frames[1].document.forms[0].other_remarks;
					names[5] = getLabel("Common.remarks.label","Common");
				}
				/*End ML-MMOH-CRF-1114*/
					
			}
			else
			{
				fields[0]= self.frames[1].document.forms[0].b_loc_val;
				fields[1]= self.frames[1].document.forms[0].resourceType;
				fields[2]= self.frames[1].document.forms[0].eff_from;
				fields[3]= self.frames[1].document.forms[0].eff_to;
				fields[4]= self.frames[1].document.forms[0].from_day;
				fields[5]= self.frames[1].document.forms[0].to_day;
				fields[6]= self.frames[1].document.forms[0].reason;
				names[0]=getLabel("Common.Location.label","Common");
				names[1]=getLabel("Common.resourcetype.label","Common");
				names[2]=getLabel("Common.fromdate.label","Common");
				names[3]=getLabel("Common.todate.label","Common");
				names[4]=encodeURIComponent(getLabel("eOA.FromDay.label","OA"));
				names[5]=getLabel("Common.to.label","Common")+" "+getLabel("Common.day.label","Common");
				names[6]=getLabel("Common.reason.label","Common");

				/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
				if(self.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
				{
					fields[7] = self.frames[1].document.forms[0].other_remarks;
					names[7] = getLabel("Common.remarks.label","Common");
				}
				/*End ML-MMOH-CRF-1114*/
			}
			if(checkFields(fields,names,self.frames[3]))
			{
		if(self.frames[2].document.forms[0])
				{
		self.frames[2].document.forms[0].submit();
				}else
				{
				self.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
				}

			}	
		}
		//alert(parent.frames[1].document.forms[0].reason_code.value);
}

function generateReport()
{

if(parent.frames[2].document.forms[0])
  {
	var n = parent.frames[2].document.forms[0].no_of_rec.value;
	var e=0;
	var p="";
	var sel=0;
	
	for(var k=0;k<n;k++)
	{
		if(parent.frames[2].document.forms[0].elements(e).checked == false)
		{
			p += parent.frames[2].document.forms[0].elements(e+1).value + "-";
			sel++;
		}
		e+=2;
	}
	
	parent.frames[2].document.forms[0].final_vals.value = p;
	parent.frames[2].document.forms[0].sel_rec.value = sel	;	
	parent.frames[2].document.forms[0].genrep.value = "Y"	;
	
	parent.frames[2].document.forms[0].submit();
  }	
  else
   {
   
   parent.frames[1].document.forms[0].only_header.value="Y";
	var n = parent.frames[1].document.forms[0].location.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];		
	parent.frames[1].document.forms[0].P_Clinic_Code.value = locncode;
	
	parent.frames[1].document.forms[0].P_From_Date.value =parent.frames[1].document.forms[0].eff_from.value;
	parent.frames[1].document.forms[0].P_To_Date.value = parent.frames[1].document.forms[0].eff_to.value;
	parent.frames[1].document.forms[0].P_Reason.value = parent.frames[1].document.forms[0].reason.value;
	
	parent.frames[1].document.forms[0].P_Day_No.value = parent.frames[1].document.forms[0].from_day.value;
	parent.frames[1].document.forms[0].P_To_Day_No.value = parent.frames[1].document.forms[0].to_day.value;
	
	parent.frames[1].document.forms[0].P_Practitioner_Id.value = parent.frames[1].document.forms[0].practitioner.value;
        parent.frames[1].document.forms[0].P_Report_Title.value ='List_of_Appointments_for_Transfer';	
        parent.frames[1].document.forms[0].P_Action.value ='Transfer_Schedule';	
        
	parent.frames[1].document.forms[0].submit();
   }	
		
}


function blank_chk(objname)
{
	parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
	var fields=new Array();
	var names = new Array ();

	if(parent.frames[1].document.forms[0].date_day[0].checked == true)
	{
		fields[0]= parent.frames[1].document.forms[0].b_loc_val;
		fields[1]= parent.frames[1].document.forms[0].resourceType;
		fields[2]= parent.frames[1].document.forms[0].eff_from;
		fields[3]= parent.frames[1].document.forms[0].eff_to;
		fields[4]= parent.frames[1].document.forms[0].reason;

		names[0]=getLabel("Common.Location.label","Common");
		names[1]=getLabel("Common.resourcetype.label","Common");
		names[2]=getLabel("Common.fromdate.label","Common");
		names[3]=getLabel("Common.todate.label","Common");
		names[4]=getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[5] = parent.frames[1].document.forms[0].other_remarks;
			names[5] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}
	else
	{
		fields[0]= parent.frames[1].document.forms[0].b_loc_val;
		fields[1]= parent.frames[1].document.forms[0].resourceType;
		fields[2]= parent.frames[1].document.forms[0].eff_from;
		fields[3]= parent.frames[1].document.forms[0].eff_to;
		fields[4]= parent.frames[1].document.forms[0].from_day;
		fields[5]= parent.frames[1].document.forms[0].to_day;
		fields[6]= parent.frames[1].document.forms[0].reason;

		names[0]=getLabel("Common.Location.label","Common");
		names[1]=getLabel("Common.resourcetype.label","Common");
		names[2]=getLabel("Common.fromdate.label","Common");
		names[3]=getLabel("Common.todate.label","Common");
		names[4]=encodeURIComponent(getLabel("eOA.FromDay.label","OA"));
		names[5]=getLabel("Common.to.label","Common")+" "+getLabel("Common.day.label","Common");
		names[6]=getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[7] = parent.frames[1].document.forms[0].other_remarks;
			names[7] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

		
	}
	if(checkFields(fields,names,parent.frames[3]))
	{
		if(objname == "Select")
		{
			show_details();
			parent.frames[1].document.forms[0].generaterep.disabled = true;
		}
		else if(objname == "generaterep")
			generateReport();
	}
}

function show_details()
{
	var dd;
	if(parent.frames[1].document.forms[0].date_day[0].checked == true)
	{
		dd='A';
	}else
	{
		dd='Y';
	}
	var ref_val=parent.frames[1].document.forms[0].ref_val.value;
	var efffrom = parent.frames[1].document.forms[0].eff_from.value;
	var effto = parent.frames[1].document.forms[0].eff_to.value;
	var fday = parent.frames[1].document.forms[0].from_day.value;
	var tday = parent.frames[1].document.forms[0].to_day.value;
	var practid = parent.frames[1].document.forms[0].practitioner.value;
	var n = parent.frames[1].document.forms[0].location.value;
	var arr =  new Array();
	arr = n.split("|");
	var locncode = arr[0];
	var res = parent.frames[1].document.forms[0].reason_code.value;
	var locnType=parent.frames[1].document.forms[0].location_type.value;
	var resourceType=parent.frames[1].document.forms[0].resourceType1.value;
	
	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	/*Commented by KAMATCHI S for ML-MMOH-CRF-1390*/
	/*if(parent.frames[1].document.forms[0].remarks_img.style.visibility == 'visible')
	{*/
		var other_remarks = parent.frames[1].document.forms[0].other_remarks.value;
	/*}else
	{
		var other_remarks = "";
	}*/
	/*End ML-MMOH-CRF-1114*/

	var u1= '../../eOA/jsp/addmodifyTransferClinicSchDetail.jsp?eff_from='+efffrom+'&eff_to='+effto+'&date_day='+dd+'&from_day='+fday+'&to_day='+tday+'&pract_id='+practid+'&locn_code='+locncode+'&reason='+res+'&locnType='+locnType+'&resType='+resourceType+'&ref_val='+ref_val+'&other_remarks='+other_remarks;
	parent.frames[2].location.href=u1;	
}

function reset() {
			parent.frames[2].frames[1].location.href = '../../eOA/jsp/addmodifyTransferClinicSch.jsp' ;
			parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html' ;
}


	
	function validate_date_from(obj,obj1)
{
	var ref_val= parent.frames[1].document.forms[0].ref_val.value;

	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			
	}
	
			var fromarray;
			var toarray;
			var from = "";
			var to ="";

	if(obj.value!="" && obj1.value!="" && parent.frames[1].document.forms[0].date_day[1].checked == true)
		{
					from = parent.frames[1].document.forms[0].eff_from;
					to   = parent.frames[1].document.forms[0].eff_to;
					if (to.value!=""){
						fromarray = from.value.split("/");
						toarray = to.value.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt)) {
							parent.frames[1].document.forms[0].ref_val.value="true";

					}else 
					{
						parent.frames[1].document.forms[0].ref_val.value="false";
					}
					}
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();
				//	parent.frames[1].document.forms[0].ref_val.value="true";
				return false;
			}
			else
			{
				//parent.frames[1].document.forms[0].ref_val.value="false";
				return true;
			}
		
		
				
		}else
		{
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
			var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
	}
	var fromarray;
			var toarray;
			var from = "";
			var to ="";
	if(obj.value!="" && obj1.value!="" && parent.frames[1].document.forms[0].date_day[1].checked == true)
		{
			from = parent.frames[1].document.forms[0].eff_from;
					to   = parent.frames[1].document.forms[0].eff_to;
					if (to.value!=""){
						fromarray = from.value.split("/");
						toarray = to.value.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt)) {
							parent.frames[1].document.forms[0].ref_val.value="true";

					}else 
					{
						parent.frames[1].document.forms[0].ref_val.value="false";
					}
					}
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
		}else
	{
	}
}

	function onSuccess() 
	{
		reset();
	}




function clearDetail(X){
	
	if(X){
	}else{
		if(document.getElementById("location").value==''){
			document.getElementById("resourceType").value='';
			document.getElementById("resourceType").disabled=true;
		}else{
			document.getElementById("resourceType").disabled=false;
		}


		document.getElementById("practitioner_name").value='';
		document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
		document.getElementById("practitioner").value='';
	}
	var p_clinic_code=document.forms[0].location.value;
	document.getElementById("location_code1").value= p_clinic_code;
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.getElementById("generaterep").disabled=true;

}

function enable_dsiable_res(Obj){
	document.getElementById("practitioner").value='';
	document.getElementById("practitioner_name").value='';
	
	if(Obj.value=='' || Obj.value=='B'){
		document.getElementById("practitioner_name").disabled=true;
		document.getElementById("search_pract").disabled=true;
	}else{
		document.getElementById("practitioner_name").disabled=false;
		document.getElementById("search_pract").disabled=false;
	}
	document.getElementById("resourceType1").value=Obj.value;
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.getElementById("generaterep").disabled=true;

}

function populateLocations(Obj){

	document.getElementById("practitioner_name").value='';
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("search_pract").disabled=true;
	document.getElementById("practitioner").value='';
	document.forms[0].resourceType.disabled=true;
	document.forms[0].resourceType.options.selectedIndex=0;

	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\"  steps='4' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) */

	PopFromDays(document.getElementById("location"))
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.getElementById("generaterep").disabled=true;
	document.forms[0].resourceType.disabled=true;

	if(Obj.value!=""){
	document.getElementById("b_loc_val").value="";
	document.getElementById("location").value="";
	document.getElementById("b_loc_val").disabled=false;
	document.getElementById("b_loc_search").disabled=false;
	}else{
	document.getElementById("b_loc_val").value="";
	document.getElementById("location").value="";
	document.getElementById("b_loc_val").disabled=true;
	document.getElementById("b_loc_search").disabled=true;
	}

	
}



/*To populate the to_day field after selection of from_day based on Location Selected */
function PopPract(obj){
		var  HTMLVal = new String();
		locn = obj.value;
		clear_list(parent.frames[1].document.forms[0].practitioner);
		if (locn == null || locn == ''){
			clear_list(parent.frames[1].document.forms[0].practitioner);
			clear_list(parent.frames[1].document.forms[0].from_day);
			clear_list(parent.frames[1].document.forms[0].to_day);

			document.forms[0].locn_type.innerText = '';
			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].practitioner.add(opt);

			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].from_day.add(opt);

			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].to_day.add(opt);

		}

		if (locn != null || locn != ''){
			HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eOA/jsp/GetValTransferSch.jsp'><input type='hidden' name='locn' id='locn' value='"+locn+"'><input type='hidden' name='pract' id='pract' value=''><input type='hidden' name='fromday' id='fromday' value=''><input type='hidden' name='p_flag' id='p_flag' value='Y'></form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();

		}

}
/*To populate the  From_day and Practitioner field  based on location selected*/
function  PopFromDays(obj){
		var  HTMLVal = new String();
		clear_list(parent.frames[1].document.forms[0].from_day);
		clear_list(parent.frames[1].document.forms[0].to_day);
		pract = obj.value;
		locn = parent.frames[1].document.forms[0].location.value;
		var p_clinic_code		= document.forms[0].location.value;


		if (pract == ''){
			//var opt = parent.document.frames[1].document.createElement("OPTION");
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].from_day.add(opt);

			//var opt = parent.document.frames[1].document.createElement("OPTION");
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].to_day.add(opt);

		}
//alert(pract);
		if (pract != ''){
			//var opt = parent.document.frames[1].document.createElement("OPTION");
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].to_day.add(opt);

			HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eOA/jsp/GetValTransferSch.jsp'><input type='hidden' name='locn' id='locn' value='"+locn+"'><input type='hidden' name='pract' id='pract' value='"+pract+"'><input type='hidden' name='fromday' id='fromday' value=''><input type='hidden' name='p_flag' id='p_flag' value='N'></form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//alert(HTMLVal);

			parent.messageFrame.document.dum_form.submit();

		}

		var obj2 = document.forms[0].location_type.value;
		if(obj2=='D')
		{
			var res=document.forms[0].resourceType;
	 while (res.options.length>0) res.remove(res.options[0]);
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
	 document.forms[0].resourceType.disabled=false;
	 
		
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
	    document.forms[0].resourceType.disabled=false;
	}
return obj2;
}
/*To populate the to_day field based on Location and from_day Selected */
function  PopToDays(obj){
		var  HTMLVal = new String();
		var locn = parent.frames[1].document.forms[0].location.value;
		var pract = parent.frames[1].document.forms[0].practitioner.value;
		var fromday = parent.frames[1].document.forms[0].from_day.value;

		clear_list(parent.frames[1].document.forms[0].to_day);
		if (fromday == null || fromday == ''){
			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.text = '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			opt.value= '';
			parent.frames[1].document.forms[0].to_day.add(opt);
		}

		if (fromday != ''){
			HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eOA/jsp/GetValTransferSch.jsp'><input type='hidden' name='locn' id='locn' value='"+locn+"'><input type='hidden' name='pract' id='pract' value='"+pract+"'><input type='hidden' name='fromday' id='fromday' value='"+fromday+"'><input type='hidden' name='p_flag' id='p_flag' value='N'></form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();

		}

}

function clear_list(obj){
	while ( obj.options.length > 0 )
		obj.remove(obj.options[0]);

}
/*To make change depending on selection of By Day or By Date*/
function changeDate(obj){
	if((obj.value) == 'A'){
		parent.frames[1].document.getElementById('date').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel("Common.Period.label","Common")+"&nbsp;&nbsp;";
		parent.frames[1].document.getElementById('ch1').innerHTML = "&nbsp;";
		parent.frames[1].document.getElementById('ch2').innerHTML = "&nbsp;";
		parent.frames[1].document.forms[0].from_day.value = "";
		parent.frames[1].document.forms[0].to_day.value = "";
		parent.frames[1].document.forms[0].from_day.disabled = true;
		parent.frames[1].document.forms[0].to_day.disabled = true;
		parent.frames[1].document.forms[0].ref_val.value = "";
		parent.frames[1].document.forms[0].eff_from.value = "";
		parent.frames[1].document.forms[0].eff_to.value = "";
	}else{
		parent.frames[1].document.getElementById('date').innerText = getLabel("eOA.DateRange.label","OA");
		parent.frames[1].document.forms[0].from_day.value = "";
		parent.frames[1].document.forms[0].to_day.value = "";
		parent.frames[1].document.forms[0].from_day.disabled = false;
		parent.frames[1].document.forms[0].to_day.disabled = false;
		parent.frames[1].document.forms[0].ref_val.value = "";
		parent.frames[1].document.forms[0].eff_from.value = "";
		parent.frames[1].document.forms[0].eff_to.value = "";
		parent.frames[1].document.forms[0].ch1.innerHTML = "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
		parent.frames[1].document.forms[0].ch2.innerHTML = "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
	}

}

/*To generate Report Based on all the field Selected*/
function gen_report(){
	parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
	var fields=new Array();
	var names = new Array ();
	var date_day = "";

	if(parent.frames[1].document.forms[0].date_day[0].checked == true){
		fields[0]= parent.frames[1].document.forms[0].b_loc_val;
		fields[1]= parent.frames[1].document.forms[0].eff_from;
		fields[2]= parent.frames[1].document.forms[0].eff_to;
		fields[3]= parent.frames[1].document.forms[0].reason;

		names[0]=getLabel("Common.Location.label","Common");
		names[1]=getLabel("Common.Period.label","Common");
		names[2]=getLabel("Common.todate.label","Common");
		names[3]=getLabel("Common.reason.label","Common");
		date_day ="A";


	}else{
		fields[0]= parent.frames[1].document.forms[0].b_loc_val;
		fields[1]= parent.frames[1].document.forms[0].eff_from;
		fields[2]= parent.frames[1].document.forms[0].eff_to;
		fields[3]= parent.frames[1].document.forms[0].from_day;
		fields[4]= parent.frames[1].document.forms[0].to_day;
		fields[5]= parent.frames[1].document.forms[0].reason;
		
		date_day ="Y";
		names[0]=getLabel("Common.Location.label","Common");
		names[1]=getLabel("Common.Period.label","Common");
		names[2]=getLabel("Common.todate.label","Common");
		names[3]=encodeURIComponent(getLabel("eOA.FromDay.label","OA"));
		names[4]=getLabel("Common.today.label","Common");
		names[5]=getLabel("Common.reason.label","Common");
	
	}

	if(checkFields(fields,names,"D")){
		var pract_from_desc		= document.forms[0].practitioner_name.value;
		var p_clinic_code		= document.forms[0].location.value;
		var arr =new Array();
		arr=p_clinic_code.split('|');
		p_clinic_code = arr[0];
		var p_day_no ="";
		var p_to_day_no ="";
		 
		if (document.forms[0].from_day.value!=""){
		/* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		p_day_no= document.forms[0].from_day.options[document.forms[0].from_day.options.selectedIndex].value;
		 
		}
		else{
		p_day_no			    = "";
		}
		if (document.forms[0].to_day.value!=""){
		/* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		p_to_day_no= document.forms[0].to_day.options[document.forms[0].to_day.options.selectedIndex].value;
		
		}
		else{
		p_to_day_no			    = ""; }
		var p_facility_id		= document.forms[0].P_Facility_id.value;
		/* Below two lines was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
		var p_from_date			= parent.frames[2].document.forms[0].eff_from.value;
		var p_to_date			= parent.frames[2].document.forms[0].eff_to.value;
		
		var p_practitioner_id	= document.forms[0].practitioner.value;
		var reason1				= document.forms[0].reason_code.value;
		var p_care_locn_type_ind =document.forms[0].location_type.value;
		var p_resource_class=document.forms[0].resourceType.value;
		var locale=document.forms[0].locale.value;
		

		//var HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='pract_from_desc' id='pract_from_desc' value='"+escape(pract_from_desc)+"'><input type='hidden' name='p_day_no' id='p_day_no' value='"+p_day_no+"'><input type='hidden' name='p_to_day_no' id='p_to_day_no' value='"+p_to_day_no+"'><input type='hidden' name='p_clinic_code' id='p_clinic_code' value='"+p_clinic_code+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_from_date' id='p_from_date' value='"+p_from_date+"'><input type='hidden' name='p_to_date' id='p_to_date' value='"+p_to_date+"'><input type='hidden' name='p_practitioner_id' id='p_practitioner_id' value='"+p_practitioner_id+"'><input type='hidden' name='date_day' id='date_day' value='"+date_day+"'><input type='hidden' name='p_report_id' id='p_report_id' value='OAAFAPLST'><input type='hidden' name='p_action' id='p_action' value='TRANSFER_SCHEDULE'><input type='hidden' name='p_module_id' id='p_module_id' value='OA'><input type='hidden' name='reason1' id='reason1' value='"+reason1+"'><input type='hidden' name='care_locn_type_ind' id='care_locn_type_ind' value='"+p_care_locn_type_ind+"'><input type='hidden' name='resource_class' id='resource_class' value='"+p_resource_class+"'></form></body></html>";

		var HtmlVal = "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='p_day_no' id='p_day_no' value='"+p_day_no+"'><input type='hidden' name='p_to_day_no' id='p_to_day_no' value='"+p_to_day_no+"'><input type='hidden' name='p_clinic_code' id='p_clinic_code' value='"+p_clinic_code+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_from_date' id='p_from_date' value='"+p_from_date+"'><input type='hidden' name='p_to_date' id='p_to_date' value='"+p_to_date+"'><input type='hidden' name='p_practitioner_id' id='p_practitioner_id' value='"+p_practitioner_id+"'><input type='hidden' name='date_day' id='date_day' value='"+date_day+"'><input type='hidden' name='p_report_id' id='p_report_id' value='OAAFAPLST'><input type='hidden' name='p_action' id='p_action' value='TRANSFER_SCHEDULE'><input type='hidden' name='p_module_id' id='p_module_id' value='OA'><input type='hidden' name='reason1' id='reason1' value='"+reason1+"'><input type='hidden' name='care_locn_type_ind' id='care_locn_type_ind' value='"+p_care_locn_type_ind+"'><input type='hidden' name='resource_class' id='resource_class' value='"+p_resource_class+"'><input type='hidden' name='locale' id='locale' value='"+locale+"'></form></body></html>";

		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
		parent.messageFrame.document.dummy1_form.submit();
	 }
}



async function show_modwin(Clcode,pid,cday,Cldate,clinic_type,res_type){

		var retVal;
		var dialogHeight = "42" ;
		var dialogWidth  = "65" ;
		var dialogTop    = "110";
		var dialogLeft   = "280";
		var locncode 	 = Clcode;
		var practid  	 = pid;
		var currdate 	 = Cldate;
		var align_change="ca_mode";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		retVal 	 	 = await window.showModalDialog("DispListAppointments.jsp?clinic_code="+locncode+"&practitioner_id="+practid+"&res_type="+res_type+"&clinic_type="+clinic_type+"&currdate="+currdate+"&ca_mode="+align_change+"&clinic_day1="+cday+"&Date="+currdate+"&mod=tfr",arguments,features);		
					
	}


	function no_sch() {	
		alert(getMessage("SCH_NOT_DEFINED","OA"));
	}
	function sch_exits(){
		alert(getMessage("TRAN_SCH_EXIST","OA"));
	}

	function sch_exits1(){
		alert(getMessage("SCH_ALREADY_EXISTS","OA"));
	}
	
	function clrval()
	{
		//parent.frames[1].document.forms[0].cntval1.value="";
	}



async function reasonlookup(obj)
{

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var locale=document.forms[0].locale.value;
		var sql="SELECT CONTACT_REASON_CODE code, CONTACT_REASON description FROM AM_CONTACT_REASON_LANG_VW WHERE  upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) and TRANSFER_SCHEDULE_YN = 'Y' AND EFF_STATUS = 'E' and  language_id='"+locale+"'  Order by 2";
		//alert("sql:"+sql);
		//var sql="SELECT DISCR_MSR_ID code, SHORT_dESC description FROM AM_DISCR_MSR WHERE RESULT_TYPE ='H' AND EFF_sTATUS = 'E' and upper(discr_msr_id) like upper(?) and upper(SHORT_dESC) like upper(?) ORDER BY 2 "
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason.value;
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
			document.forms[0].reason.value=desc;
			document.forms[0].reason_code.value=code;
			
		}else
		{
			document.forms[0].reason.value="";
			document.forms[0].reason_code.value="";
		}
}
function chgbuttonclr()
		{
			document.getElementById("b_loc_val").disabled="true" ;
			document.getElementById("b_loc_search").disabled="true" ;


		}
async function open_loc_lookup(){
	var location1=document.forms[0].location_type.value;
	var location_val=document.forms[0].b_loc_val.value;
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
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=TRAN_SCH",arguments,features);

	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var locntype=rvalues[3];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=code+"|"+locntype+"|"+open_to_all_pract_yn;
		clearDetail();
		PopFromDays(document.forms[0].location);		
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		document.forms[0].resourceType.value="";
		document.forms[0].resourceType.disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;		
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		document.forms[0].resourceType.value="";
		document.forms[0].resourceType.disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		
	}else{
	open_loc_lookup()
	}
}

