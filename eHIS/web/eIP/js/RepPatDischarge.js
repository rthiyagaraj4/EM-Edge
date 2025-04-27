function reset()
{	
//f_query_add_mod.document.forms[0].reset();
window.location.reload();
}

function run()
{	
 if(f_query_add_mod.document.Rep2PatDischargeForm && f_query_add_mod.document.getElementById('adm_id').checked)
		{
		var fields = new Array( f_query_add_mod.document.Rep2PatDischargeForm.p_fm_admission_date,
		f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date );
		var names = new Array(getLabel('eIP.AdmDateFrom.label','IP'), getLabel('eIP.AdmDateTo.label','IP'));
		
		if(f_query_add_mod.document.Rep2PatDischargeForm.currentIP_id.checked==false)
		{
		  
		if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		
		
		    
		
		if(f_query_add_mod.document.getElementById('CashPat').checked){
		  f_query_add_mod.document.getElementById('p_cash').value="C"
		 }else{
		 f_query_add_mod.document.getElementById('p_cash').value="Z"
		 }
		if(f_query_add_mod.document.getElementById('current_patient').checked){
		  f_query_add_mod.document.getElementById('p_current_patient').value="Y"
		 }else{
		 f_query_add_mod.document.getElementById('p_current_patient').value="N"
		 }
	     var dttime 
		 var dt
         var time
		var p_fm_admission_date=f_query_add_mod.document.forms[0].p_fm_admission_date.value;

			dttime = p_fm_admission_date.split(" ");
			var from=f_query_add_mod.document.forms[0].p_fm_admission_date.value;
			var to=f_query_add_mod.document.forms[0].p_to_admission_date.value;

			 if(dttime.length>1)
			{
					  dt=dttime[0]
				time=dttime[1]
			}

			f_query_add_mod.document.forms[0].p_fm_admission_date.value=dt+time;


			   var p_to_admission_date=f_query_add_mod.document.forms[0].p_to_admission_date.value;

				 dttime = p_to_admission_date.split(" ");

			 if(dttime.length>1)
			{
			    dt=dttime[0]
				time=dttime[1]
			}
         
		   
		   f_query_add_mod.document.Rep2PatDischargeForm.currentIP_id.value="N"
			f_query_add_mod.document.forms[0].p_to_admission_date.value=dt+time;;
			f_query_add_mod.document.forms[0].p_fm_admission_date.value=from;
			f_query_add_mod.document.forms[0].p_to_admission_date.value=to; 
			
		
			f_query_add_mod.document.forms[0].p_report_id.value='IPBADCWR';
			
		
			
	       if(!f_query_add_mod.isBefore(f_query_add_mod.document.Rep2PatDischargeForm.p_fm_admission_date.value,f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date.value,"DMYHM",localeName))
			{
			
			   alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date.select();
			return false;
			
			} 
			f_query_add_mod.document.Rep2PatDischargeForm.submit() ;
			}
		} else {
		 
		    
			 if(f_query_add_mod.document.Rep2PatDischargeForm.p_fm_admission_date.value !="" && f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date.value!=""){
		 if(!f_query_add_mod.isBefore(f_query_add_mod.document.Rep2PatDischargeForm.p_fm_admission_date.value,f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date.value,"DMYHM",localeName))
			{
			
			   alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2PatDischargeForm.p_to_admission_date.select();
			return false;
			
			} }
		       
		   if(f_query_add_mod.document.getElementById('CashPat').checked){
		  f_query_add_mod.document.getElementById('p_cash').value="C"
		 }else{
		
		 f_query_add_mod.document.getElementById('p_cash').value="Z"
		 }
		 
		  if(f_query_add_mod.document.getElementById('current_patient').checked){
		  f_query_add_mod.document.getElementById('p_current_patient').value="Y"
		 }else{
		  
		 f_query_add_mod.document.getElementById('p_current_patient').value="N"
		 }
		    var dttime 
		 var dt
         var time
		var p_fm_admission_date=f_query_add_mod.document.forms[0].p_fm_admission_date.value;

			dttime = p_fm_admission_date.split(" ");
			var from=f_query_add_mod.document.forms[0].p_fm_admission_date.value;
			var to=f_query_add_mod.document.forms[0].p_to_admission_date.value;

			 if(dttime.length>1)
			{
					  dt=dttime[0]
				time=dttime[1]
			}

			f_query_add_mod.document.forms[0].p_fm_admission_date.value=dt+time;


			   var p_to_admission_date=f_query_add_mod.document.forms[0].p_to_admission_date.value;

				 dttime = p_to_admission_date.split(" ");

			 if(dttime.length>1)
			{
			    dt=dttime[0]
				time=dttime[1]
			}
      
		   f_query_add_mod.document.Rep2PatDischargeForm.currentIP_id.value="Y"
			f_query_add_mod.document.forms[0].p_to_admission_date.value=dt+time;;
			f_query_add_mod.document.forms[0].p_fm_admission_date.value=from;
			f_query_add_mod.document.forms[0].p_to_admission_date.value=to;
			f_query_add_mod.document.forms[0].p_report_id.value='IPBADCWR';
			
			
			f_query_add_mod.document.Rep2PatDischargeForm.submit() ;
		} 
		}
		if(f_query_add_mod.document.Rep2PatDischargeForm && f_query_add_mod.document.getElementById('dis_id').checked)
		{
		var fields = new Array( f_query_add_mod.document.Rep2PatDischargeForm.p_fm_discharge_date,
		f_query_add_mod.document.Rep2PatDischargeForm.p_to_discharge_date );
		var names = new Array(getLabel('eIP.DischargeDateFrom.label','IP'), getLabel('eIP.DischargeDateTo.label','IP'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
	    if( !doDateCheckAlert( f_query_add_mod.document.Rep2PatDischargeForm.p_fm_discharge_date,f_query_add_mod.document.Rep2PatDischargeForm.p_to_discharge_date )  )
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				f_query_add_mod.document.Rep2PatDischargeForm.p_to_discharge_date.select();
				return;
			}
			
		if(f_query_add_mod.document.getElementById('CashPat').checked){
		  f_query_add_mod.document.getElementById('p_cash').value="C"
		 }else{
		 f_query_add_mod.document.getElementById('p_cash').value="Z"
		 }
		if(f_query_add_mod.document.getElementById('current_patient').checked){
		  f_query_add_mod.document.getElementById('p_current_patient').value="Y"
		 }else{
		 f_query_add_mod.document.getElementById('p_current_patient').value="N"
		 }
		  f_query_add_mod.document.forms[0].p_report_id.value='IPPDISLT';
		  f_query_add_mod.document.Rep2PatDischargeForm.submit() ;

		}
		}
		}
		
		
		
		
		
	
function doDateCheckAlert(from,to)
		{
			var fromdate = from.value ;
			var todate = to.value ;
			if(fromdate!='' && todate!='')
			{
					var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
					var greg_toDate = convertDate(todate,"DMY",localeName,"en");
					if(isBefore(greg_fromDate,greg_toDate,"DMY","en"))
					{
						
						return true;
					}
					else 
					{
						return false;
					
					}
			}
			else
				return true;

		}
	
 
