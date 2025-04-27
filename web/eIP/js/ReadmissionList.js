function reset(){
if (f_query_add_mod.document.RepReadmissionForm)
	{
		f_query_add_mod.location.href ='../../eIP/jsp/RepReadmission.jsp';
	}
}
function run()
  {	
	 var flag =checkNull();
	 if(flag==true){
	 
  if(chkGrtrDate(f_query_add_mod.document.RepReadmissionForm.p_fm_discharge_date_disp,f_query_add_mod.document.RepReadmissionForm.p_to_discharge_date_disp)){
  var dis_dt_fm=f_query_add_mod.document.RepReadmissionForm.p_fm_discharge_date_disp.value;
  var dis_dt_to=f_query_add_mod.document.RepReadmissionForm.p_to_discharge_date_disp.value;
  f_query_add_mod.document.RepReadmissionForm.p_fm_discharge_date.value= convertDate(dis_dt_fm,"DMY",localeName,"en");
	f_query_add_mod.document.RepReadmissionForm.p_to_discharge_date.value= convertDate(dis_dt_to,"DMY",localeName,"en");
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame"
	f_query_add_mod.document.RepReadmissionForm.submit() ;
	}
	}
     
}

function chkGrtrDate(obj1,obj2)
{
	if( obj1.value != "" && obj2.value != "" )
	{ 
	
		if(isBefore(obj1.value,obj2.value,"DMY",localeName) == false)
		{  
		   var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			var dischargedate=getLabel("Common.dischargedate.label","common"); 
			var from_discharge=getLabel('Common.to.label','common_labels')+" "+dischargedate;
			var to_discharge=getLabel('Common.from.label','common_labels')+" "+dischargedate;
			error = error.replace('To Date',from_discharge);
			error = error.replace('From Date',to_discharge);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			obj2.select();
			obj2.focus();
			
			return false;
		}
		else
			return true;
	}
	else 
		return true;
}



function checkNull(){
 	var flag;
  	var error="";
  	var obj=f_query_add_mod.document.RepReadmissionForm;
  	var from_date =obj.p_fm_discharge_date_disp.value;
	var to_date =obj.p_to_discharge_date_disp.value;
	var no_daysof_dis =obj.p_daysofdischarge.value;
	
    var from_date_label=(getLabel("Common.dischargedate.label","Common")+' '+getLabel("Common.from.label","Common"));
    var to_date_label=(getLabel("Common.dischargedate.label","Common")+' '+getLabel("Common.to.label","Common")); 
    var daysof_dis_label=(getLabel("eIP.Readmissionwithin.label","ip")+' '+getLabel("eIP.Daysofdischarge.label","ip"));
  	if(from_date=="") {
  		flag=false;
  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",from_date_label)+"<br>";
  	}
  	 
   	if(to_date=="") {
   		flag=false;
   		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",to_date_label)+"<br>";
   	}
  	if(no_daysof_dis=="") {
  		flag=false;
  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",daysof_dis_label)+"<br>";
  		
  	}
	
  	
  	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
 	if(flag==false) return false; else return true;
  }