function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/PrintRouting.jsp?mode_type=insert" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
f_query_add_mod.location.href ="../../eSM/jsp/queryPrintRoutingForm.jsp?function=print" ;
	
}



function apply() 
{
	if(f_query_add_mod.document.printrouting_form!=null){
	var to_proceed = true;
	var from_time1 = f_query_add_mod.document.printrouting_form.from_time.value;
	var from_time2 = f_query_add_mod.document.printrouting_form.from_2time.value;
	var from_time3 = f_query_add_mod.document.printrouting_form.from_3time.value;
	var curr_date  = f_query_add_mod.document.printrouting_form.sys.value;


	var fromtime1array; var fromtime2array; var fromtime3array;
	var frtime1;
	var frtime2;
	var frtime3;

	if (parseInt(f_query_add_mod.document.printrouting_form.no_of_copies.value) == 0)
	{
		alert(f_query_add_mod.getMessage('COPY_GR_ZERO','SM'));
		to_proceed=false;
	}

	fromtime1array = from_time1.split(":");
	fromtime2array = from_time2.split(":");
	fromtime3array = from_time3.split(":");

	frtime1 = new Date(1,1,1,fromtime1array[0],fromtime1array[1],0,0) ;
	frtime2 = new Date(1,1,1,fromtime2array[0],fromtime2array[1],0,0) ;
	frtime3 = new Date(1,1,1,fromtime3array[0],fromtime3array[1],0,0) ;

	if(Date.parse(frtime1) == Date.parse(frtime2 ) || Date.parse(frtime1) == Date.parse(frtime3) || Date.parse(frtime2) == Date.parse(frtime3) )
			{
				alert(f_query_add_mod.getMessage('FROM_TIME_CANNOT_BE_SAME','SM'));
				to_proceed=false;
			}
	
	if(to_proceed)
	{
		
		if (Date.parse(frtime1) > Date.parse(frtime2))
		{
			alert(f_query_add_mod.getMessage('FROM_TIME_OVERLAP','SM'));
			to_proceed=false;
		}
		else
		{
			if (Date.parse(frtime1) > Date.parse(frtime3))
			{
				alert(f_query_add_mod.getMessage('FROM_TIME_OVERLAP','SM'));
				to_proceed=false;
			}

		}
	}
if(to_proceed)
{
	if (Date.parse(frtime2) > Date.parse(frtime3))
	{
		alert(f_query_add_mod.getMessage('FROM_TIME_OVERLAP','SM'));
		to_proceed=false;
	}
	else
	{
		if (Date.parse(frtime2) > Date.parse(frtime3))
		{
			alert(f_query_add_mod.getMessage('FROM_TIME_OVERLAP','SM'));
			to_proceed=false;
		}
	}
}

	if (to_proceed==true)
	{
	if(parseInt(f_query_add_mod.document.printrouting_form.from_time.value.length) >0 )
		f_query_add_mod.document.printrouting_form.from_time1.value = curr_date + ' '+f_query_add_mod.document.printrouting_form.from_time.value;
	
	if(parseInt(f_query_add_mod.document.printrouting_form.from_2time.value.length) >0)
		f_query_add_mod.document.printrouting_form.from_time2.value =  curr_date + ' '+f_query_add_mod.document.printrouting_form.from_2time.value;

	if(parseInt(f_query_add_mod.document.printrouting_form.from_3time.value.length) >0)
	f_query_add_mod.document.printrouting_form.from_time3.value = curr_date+'  ' + f_query_add_mod.document.printrouting_form.from_3time.value;

// Tuesday, February 16, 2010 19357 Venkat S.
if(f_query_add_mod.document.printrouting_form.function_name.value == 'insert'){	
 //  Added Below Line for this SCF  [GHL-SCF-658] 	
	  var commondescfield="";
	  var commondescnames="";	 
	 if(f_query_add_mod.document.printrouting_form.locnimg.style.visibility == 'visible' ){	
	  commondescfield=f_query_add_mod.document.printrouting_form.dest_locn_code	;
      commondescnames=f_query_add_mod.getLabel("eSM.DestCode.label","SM");	 		
	  }		 
	  if(f_query_add_mod.document.printrouting_form.locnimg1.style.visibility == 'visible'){	
       commondescfield=f_query_add_mod.document.printrouting_form.dest_locn_code1	;
       commondescnames=f_query_add_mod.getLabel("eSM.DestCode.label","SM");	
      }		 
	  if(f_query_add_mod.document.printrouting_form.facimg.style.visibility == 'visible' && f_query_add_mod.document.printrouting_form.facility_id.value==""){	            
				if(commondescnames==""){
                commondescfield=f_query_add_mod.document.printrouting_form.facility_id;				
				commondescnames=f_query_add_mod.getLabel("Common.facility.label","Common");	
				}else{				
				 commondescfield=commondescfield+","+f_query_add_mod.document.printrouting_form.facility_id;				
				 commondescnames=commondescnames+","+f_query_add_mod.getLabel("Common.facility.label","Common");	
				}
	
	  }
		var fields = new Array ( 
						f_query_add_mod.document.printrouting_form.module_id,
						f_query_add_mod.document.printrouting_form.report_id,
						f_query_add_mod.document.printrouting_form.dest_locn_type,						
						f_query_add_mod.document.printrouting_form.dflt_report_mode,
						f_query_add_mod.document.printrouting_form.printer_id,
						f_query_add_mod.document.printrouting_form.no_of_copies
						
					    );
		 var names = new Array ( f_query_add_mod.getLabel("Common.Module.label","Common"),
						f_query_add_mod.getLabel("Common.report.label","Common"),
						f_query_add_mod.getLabel("Common.Destination.label","Common"),						
						f_query_add_mod.getLabel("eSM.DefaultReportMode.label","SM") ,
						f_query_add_mod.getLabel("eSM.Printer.label","SM")+" "+1,
						f_query_add_mod.getLabel("eSM.NumberofCopies.label","SM") 
					      );	
                                 
					if(commondescnames!=""){						
                        if(commondescnames.indexOf(",") !=-1){						
						var nameSplitResult = commondescnames.split(",");
						var fieldSplitResult= commondescfield.split(",");						
                        for(i = 0; i < nameSplitResult.length; i++){	  
	                    fields.push(fieldSplitResult[i]);            
                        names.push(nameSplitResult[i]);	
                        }
						}else{
						fields.push(commondescfield);            
                        names.push(commondescnames);	
						}
					}
				       //}
				/*if(f_query_add_mod.document.printrouting_form.facimg.style.visibility == 'visible'){
                var facilityid=","+f_query_add_mod.document.printrouting_form.facility_id;				
				var facilitylable=f_query_add_mod.getLabel("Common.facility.label","Common");				          
				fields.push(facilityid);            
                names.push(facilitylable);				
				}*/
   //Added Above Line for this SCF  [GHL-SCF-658] 	
	
	}else{		
//Below line Added for this SCF  [GHL-SCF-658] 
	var fields = new Array (f_query_add_mod.document.printrouting_form.no_of_copies,
						
						f_query_add_mod.document.printrouting_form.printer_id
						
					    );
        
	 var names = new Array (f_query_add_mod.getLabel("eSM.NumberofCopies.label","SM") ,	
						f_query_add_mod.getLabel("eSM.Printer.label","SM")+""+1);
						
						//End this SCF  [GHL-SCF-658] 
	
	
	}
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

		if(f_query_add_mod.document.printrouting_form.function_name.value=="insert")
		{

			if(f_query_add_mod.document.printrouting_form.dest_locn_code.disabled== true)
			{
				f_query_add_mod.document.printrouting_form.dst_loc_code.value=f_query_add_mod.document.printrouting_form.dest_locn_code1.value;
			}
			else if(f_query_add_mod.document.printrouting_form.dest_locn_code1.disabled== true)
			{

				f_query_add_mod.document.printrouting_form.dst_loc_code.value=f_query_add_mod.document.printrouting_form.dest_locn_code.value;

			}

		}

		var time_comp=true;
		var time_comp_must=true;
		if(parseInt(f_query_add_mod.document.printrouting_form.printer_id2.value.length)==0 && parseInt(f_query_add_mod.document.printrouting_form.printer_id3.value.length)==0)
		{
		if(!(parseInt(f_query_add_mod.document.printrouting_form.from_time.value.length)==0)){ 
		time_comp=false;
		}
		else if(!(parseInt(f_query_add_mod.document.printrouting_form.from_2time.value.length)==0))
		{
		time_comp=false;
		}
		else if(!(parseInt(f_query_add_mod.document.printrouting_form.from_3time.value.length)==0)){
		time_comp=false;
		}
		
		}
		

		if(time_comp){
		
				if(!(parseInt(f_query_add_mod.document.printrouting_form.printer_id2.value.length)==0)){
				
					if(parseInt(f_query_add_mod.document.printrouting_form.from_time.value.length)==0 ||
						parseInt(f_query_add_mod.document.printrouting_form.from_2time.value.length)==0){
					time_comp_must=false;
					}
				}
				if(!(parseInt(f_query_add_mod.document.printrouting_form.printer_id3.value.length)==0)){
				
					if(parseInt(f_query_add_mod.document.printrouting_form.from_time.value.length)==0 ||
						parseInt(f_query_add_mod.document.printrouting_form.from_2time.value.length)==0 ||
						parseInt(f_query_add_mod.document.printrouting_form.from_3time.value.length)==0){
					time_comp_must=false;
					}
				}
				
				var printer_id1=f_query_add_mod.document.printrouting_form.printer_id.value;
				var printer_id2=f_query_add_mod.document.printrouting_form.printer_id2.value;
				var printer_id3=f_query_add_mod.document.printrouting_form.printer_id3.value;
				
				var time_comp_must1=true;
				if(printer_id1 !='' && printer_id2 !='' && printer_id3 !='')
				{
					if(printer_id1 == printer_id2 || printer_id1 == printer_id3 || printer_id2 == printer_id3 )
					{
					time_comp_must=false;
					time_comp_must1=false;
					alert(f_query_add_mod.getMessage('SAME_PRN_CANNOT_BE_DEFINED','SM'));
					}
				}
				else
				if(printer_id1 !='' && printer_id2 !='')
				{
					if(printer_id1 == printer_id2)
					{
					time_comp_must=false;
					time_comp_must1=false;
					alert(f_query_add_mod.getMessage('SAME_PRN_CANNOT_BE_DEFINED','SM'));
					}
				
				}

				if(time_comp_must1)
				{
					if(time_comp_must){
						if(f_query_add_mod.document.printrouting_form.function_name.value=="insert")
						{
							var field = new Array ( f_query_add_mod.document.printrouting_form.dest_locn_code1);	
							var name = new Array ( f_query_add_mod.getLabel("Common.Destination.label","Common"));	
							if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
							{
								f_query_add_mod.document.printrouting_form.submit();
							}
						}
						else
							f_query_add_mod.document.printrouting_form.submit();	
					}
					else{
					alert(f_query_add_mod.getMessage("FROMTIME_CANNOT_BE_BLANK",'SM'));
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=";
					}
				}
				else
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=";
		}
		else{
		f_query_add_mod.document.printrouting_form.from_time.value='';
		f_query_add_mod.document.printrouting_form.from_2time.value='';
		f_query_add_mod.document.printrouting_form.from_3time.value='';
		alert(f_query_add_mod.getMessage("FROMTIME_NOT_NECESSARY",'SM'));
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=";
		}
	  }
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=";
	}
}else
{
	frames[0].location.reload();
	return false;
}
}

function reset() {
	if(f_query_add_mod.document.printrouting_form!=null){
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.location.reload() ;
		if (f_query_add_mod.document.forms[0].function_name)
		{
				if(f_query_add_mod.document.forms[0].function_name.value == "insert")
				{
			}
		}
}else 
{
	frames[1].location.reload();
}
}

function onSuccess() {
		if(f_query_add_mod.document.printrouting_form.function1.value == 'delete')
			f_query_add_mod.location.href='../../eCommon/html/blank.html'
		else
		f_query_add_mod.document.location.reload();

}

function deleterecord()
{
	if(f_query_add_mod.document.printrouting_form!=null){
	if(f_query_add_mod.document.printrouting_form.function1.value !="insert")
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
		f_query_add_mod.document.printrouting_form.function1.value="delete";
		f_query_add_mod.document.printrouting_form.function_name.value="delete";

		f_query_add_mod.document.printrouting_form.submit();
		return true;
	}
	else
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}else
{
	frames[0].location.reload();
	return false;
}
}


function help() {

}

function ValidateDateTime11(from,to)
{
	var retval
	from = from.value+":00";
	to   = to.value+":00";
	
	var a=  from.split(" ")
	var b=  to.split(" ")
	
	var splitdate =a[0].split("/")
	var splittime= a[1].split(":")

        var from_date  = new Date(eval(splitdate[2]), eval(splitdate[1]-1), eval(splitdate[0]), eval(splittime[0]), eval(splittime[1]),eval(splittime[2]))

	var date1 =b[0].split("/")
	 splittime= b[1].split(":")
	
	 var to_date  =new Date(eval(date1[2]), eval(date1[1]-1), eval(date1[0]), eval(splittime[0]), eval(splittime[1]) )

	 if(Date.parse(to_date) == Date.parse(from_date))
	{
	
		retval =  false;
	
	}
	else
		retval = true;
	return retval
}

