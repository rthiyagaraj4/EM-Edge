function apply() {

	var hmis_hospital=frames[1].document.forms[0].hmis_hospital;
	var rep_date=frames[1].document.forms[0].rep_date;
	var report_name=frames[1].document.forms[0].report_name;

	if(trimCheck(hmis_hospital.value)==""){
		var msg = getMessage('CAN_NOT_BE_BLANK','Common');
		msg=msg.replace('$','Hospital');
		hmis_hospital.focus();
		messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
		return false;
	} else {
		if(trimCheck(rep_date.value)==""){
			var msg = getMessage('CAN_NOT_BE_BLANK','Common');
			msg=msg.replace('$','Report For');
			rep_date.focus();
			messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
			return false;
		} else {

			if(trimCheck(report_name.value)==""){
				var msg = getMessage('CAN_NOT_BE_BLANK','Common');
				msg=msg.replace('$','External File ');
				report_name.focus();
				messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
				return false;
			}else{
				//createjsonFile(hmis_hospital.value,rep_date.value,report_name.value);
				
				if(report_name.value=='PD102'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD102";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PD301'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD301";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='RH301'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GenerateRH301";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PD101'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD101";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='RH101'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GenerateRH101";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PD105'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD105";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PD103'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD103";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PD207'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePD207";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PLOPDGEN'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePLOPD";
					
					//frames[1].document.forms[0].action="http://localhost:7001/eHIS/eMR/jsp/TestJson.jsp";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PLOPDSPL'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePLOPSPL";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PLOPDEMER'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePLOPEMER";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PLOPDPAC'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePLOPPAC";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='PSPRO'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GeneratePSPRO";

					frames[1].document.forms[0].submit();
				}else if(report_name.value=='CSSP'){

					frames[1].document.forms[0].action="../../servlet/eMR.smrp.GenerateCSSP";

					frames[1].document.forms[0].submit();
				}
			}
		}
	}    
}

function onSuccess() 
{
	frames[1].location.reload();
}

function reset() 
{
   frames[1].document.forms[0].reset();
}


function checkyear(obj)
{
	var len=obj.value.length;
	if((obj.value != ""))
	{
		if(len<4)
		{
			var msg = getMessage("INVALID_YR_FORMAT",'SM');
			alert(msg);
			obj.focus();
		return false;
		}
		else
		if((len==4)&&(obj.value == 0000))
		{
			var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	}
}

function checkmonth(obj)
{
	var t1 =obj;
	if(obj.value != "")
	{
		if((obj.value>0) && (obj.value<=12))
		{
		return true;
		}
	else
		if(obj.value==0)
		{
			var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	else
		if(obj.value>12)
		{
			var msg = getMessage("MONTH_IS_GR_12",'Common');
			alert(msg);
			obj.focus();
			return false;
		}
	}
}

function datefun(obj)
{
		var t1 = ChkDate(obj);		
		if(!t1)
			{
			//obj.value=""; 
			var msg = getMessage("INVALID_DATE_FMT",'SM');
			alert(msg);
			obj.focus();
			return;
			}
}
/*function onloadfun()
{
	document.getElementById("bar1").innerHTML="<td colspan='2' class='label'>&nbsp;</td>"
	
}*/

function chooseobj()
{

	if (document.forms[0].hmis_file_type.value == "PD301")
	{
		document.forms[0].filetype_flag.value="pd301";

		document.getElementById('bar1').style.backgroundColor = "navy";
		document.getElementById('bar1').style.Fontfamily = "verdana";
		document.getElementById('bar1').style.color = "#FFFFFF";
		document.getElementById('bar1').style.size = "10";

		document.getElementById('bar1').innerHTML="<th align='center' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("Common.daily.label","Common")+"&nbsp;"+getLabel("Common.Discharge.label","Common")+"</B></th>";
		document.getElementById('label2').innerText= getLabel("Common.dischargedate.label","Common");	 
		// document.getElementById("dateofbirth").value="";
		document.getElementById('obj2').innerHTML = "&nbsp;<input type='text' name='date_of_birth' id='date_of_birth' id='dateofbirth' maxlength='10' size='8' onkeypress='return Valid_DT(event);' onblur='datefun(this);'>&nbsp;<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].date_of_birth.select();return showCalendar('dateofbirth')\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	}
	else
	if (document.forms[0].hmis_file_type.value == "PD103")
	{
	  document.getElementById('bar1').innerHTML="<th  align='left' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("Common.daily.label","Common")+"&nbsp;"+getLabel("eMR.InpatientCensus.label","MR")+"<B></th>";
	  document.forms[0].filetype_flag.value="pd103";

	document.getElementById('bar1').style.backgroundColor = "navy";
	document.getElementById('bar1').style.Fontfamily = "verdana";
	document.getElementById('bar1').style.color = "#FFFFFF";
	document.getElementById('bar1').style.size = "10";

	  document.getElementById('label2').innerText=getLabel("eIP.CensusDate.label","IP");	
	  document.getElementById('obj2').innerHTML = "&nbsp;<input type='text' name='date_of_birth2' id='date_of_birth2' id='dateofbirth2' maxlength='10' size='8' onkeypress='return Valid_DT(event)' onblur='datefun(this);'>&nbsp;<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].date_of_birth2.select();return showCalendar('dateofbirth2')\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	
	  //document.getElementById("label1").innerText="Causes date";	 
	  // document.getElementById("dateofbirth").value="";
	}
	else
	if (document.forms[0].hmis_file_type.value == "PD205")
	{
	// document.getElementById("dateofbirth").value="";

	document.getElementById('bar1').style.backgroundColor = "navy";
	document.getElementById('bar1').style.Fontfamily = "verdana";
	document.getElementById('bar1').style.color = "#FFFFFF";
	document.getElementById('bar1').style.size = "10";

	document.getElementById('bar1').innerHTML="<th  align='left' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B>"+getLabel("eMR.MonthlyMaternityCensus.label","MR")+"</B></th>";
	document.forms[0].filetype_flag.value="pd205";
	document.getElementById('label2').innerText=getLabel("Common.month.label","Common");

	document.getElementById('obj2').innerHTML = "&nbsp;<input type='text' name='maternitymonth' id='maternitymonth' id='matmonth' maxlength='02' size='2' onkeypress='return Valid_DT2(event)' onblur='checkmonth(this);'>&nbsp;&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;&nbsp;<input type='text' name='maternityyear' id='maternityyear' onkeypress='return Valid_DT2(event)' id='matyear' maxlength='04' size='4'  onblur='checkyear(this);'>&nbsp;&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	}
	else
	if (document.forms[0].hmis_file_type.value == "")
	{
		
		document.getElementById('bar1').innerHTML="&nbsp;";
		document.getElementById('bar1').style.backgroundColor = "#E2E3F0";

		document.forms[0].filetype_flag.value="";
		// document.getElementById("dateofbirth").value="";
		document.getElementById('label2').innerText="";
		document.getElementById('obj2').innerHTML = "&nbsp;"
	}
}

function Valid_DT(event)
	{
		var strCheck = '0123456789:/';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	} 

	function Valid_DT2(event)
	{
		var strCheck = '0123456789';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	} 



function validdate_rep_date(Obj){

	if(!ChkDate(Obj)){
		alert(getMessage("INVALID_DATE_FMT", "SM"));
		Obj.select();
		Obj.focus();
	}
}

function createjsonFile(facility_id,rep_date,rep_name){



var url;

if(	rep_name=='PD102'){	
	url='../../servlet/eCommon.GeneratePD102';
}

   var jsonArguments	= {	
							'P_FACILITY_ID':facility_id,
							'P_FM_ADMN_DATE':rep_date,
							'P_TO_ADMN_DATE':rep_date
						  };

	$.ajax({  
			 url:'../../servlet/eCommon.GeneratePD102',  
			 type: 'post',  
			 data: jsonArguments,
			 dataType: 'json',
			 success: function(data) { 
				alert(data)
				if(data!=''){
					 if(data != null && data.forms.length > 1){
						 alert("JSON file Created.");
						}
				}
			 }
		 });

frames(0).location.reload();

}

function repop_Rep(){
	var smrp_rep=document.getElementById('smrp_rep').value;

	var all_smrp="PD101*Buku Daftar Kemasukan ke Hospital (PD101)!RH101*Buku Daftar Rawatan Harian Bagi Hospital / Institusi (RH101)!PD301*Borang Daftar Masuk dan Keluar Hospital (PD301)!RH301*Borang Daftar Pesakit Rawatan Harian (RH301)!PD102*Buku Daftar Bersalin (PD102)!PD103*Bancian Harian Wad (PD103)!PD105*Buku Daftar Kematian (PD105)!PD207*Laporan Bancian Bulanan/Tahunan Pembedahan Yang Dilakukan Mengikut Jenis dan Disiplin (PD207)!PLOPDGEN*PLOPD General!PLOPDSPL*PLOPD Specialist!PLOPDEMER*PLOPD Emergency!PLOPDPAC*PLOPD PAC!PSPRO*PS(Procedure)!CSSP*CS(ClinicalSupport)";

	var arr_smrp_rep=smrp_rep.split("|");
	var arr_all_smrp=all_smrp.split("!");
	for(j=0;j<=arr_all_smrp.length;j++){
		for(k=0;k<=arr_smrp_rep.length;k++){				
			if (j==arr_smrp_rep[k]){
				
				var opt = document.createElement('Option');
				var elment_arr=arr_all_smrp[j].split("*");
				
				opt.value=elment_arr[0];
				opt.text=elment_arr[1];
				document.getElementById('report_name').add(opt)					
			}
		}				
	}

}

