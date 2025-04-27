 	var strDate;
	var strDay; 
	var strMonth;
	var strYear;
	var length;
	var noofdays;
	var strMonth2;
	var month;
	var var_Month;
	var var_Month;
	var end_date;
	var c;
	var rule_appl_yn ;


function reset()
{
	if(parent.frames[2].frames[1].frames[1].name=="querying")
	{


	/*var lBox=parent.frames[2].frames[1].frames[1].document.schedule_appointment.clinic; 
	var len=parent.frames[2].frames[1].frames[1].document.schedule_appointment.clinic.options.length;
 
    lBox.remove(lBox.options[0]);
  
    var i=0;
    while(i< len)
		lBox.remove(lBox.options[i++]);
	  var opt=document.createElement('OPTION');	
	opt.value='';
    opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	lBox.add(opt); */
	if (parent.frames[2].frames[1].frames[0].name=='image'){
		
		parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp";
		parent.frames[2].frames[1].frames[3].location.href='../../eCommon/html/blank.html'; 
		parent.frames[2].frames[1].frames[1].location.href='../../eOA/jsp/ScheduleAppointment.jsp'; 
		parent.frames[2].frames[1].frames[1].document.forms[0].reset();
		
		//parent.frames[2].frames[1].frames[1].document.getElementById("pract_type").innerHTML="&nbsp;";
		parent.frames[2].frames[1].frames[1].document.forms[0].disp_next.disabled=true;
		parent.frames[2].frames[1].frames[1].document.forms[0].search_pract.disabled=true;
		if(parent.frames[2].frames[1].frames[1].document.forms[0].search.disabled)
		{
		parent.frames[2].frames[1].frames[1].document.forms[0].search.disabled=false; }
         
	    }
	else
		{
		parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html';
        }
	}else
		if(parent.frames[2].frames[1].frames[1].frames[0].name=="image34")
	{
		
	parent.frames[2].frames[1].frames[1].frames[0].location.reload();
	parent.frames[2].frames[1].frames[1].frames[1].location.reload();
	}
	else if(parent.frames[2].frames[1].frames[1].name=="queries")
	{
		parent.frames[2].frames[1].frames[1].location.href="../../eOR/jsp/PendingOrdersSchedule.jsp?";
	}
	else if(parent.frames[2].frames[1].frames[1].name=="f_query_add_mod_main")
	{ 
		var from_page="OA_PENDING_REFERRAL_BOOKING";
	
		parent.frames[2].frames[1].frames[1].location.href="../../eMP/jsp/ReferralSearchFrameset.jsp?function_id="+from_page;
	}
	
}
function enableDays()
		{
			parent.frames[1].document.forms[0].days.disabled=false;
			parent.frames[1].document.forms[0].r_month.checked=false;
			parent.frames[1].document.forms[0].r_week.checked=false;
			parent.frames[1].document.forms[0].prefenddate.value="";
			parent.frames[1].document.forms[0].prefenddate1.value="";
			parent.frames[1].document.forms[0].search.disabled=true;

		}

function enableMonth()
		{
			parent.frames[1].document.forms[0].search.disabled=false;
			parent.frames[1].document.forms[0].r_days.checked=false;
			parent.frames[1].document.forms[0].days.disabled=true;
			parent.frames[1].document.forms[0].r_month.checked=true;
			parent.frames[1].document.forms[0].r_week.checked=false;
			parent.frames[1].document.forms[0].days.value="";
		}
function enableWeek()
		{
			parent.frames[1].document.forms[0].search.disabled=false;
			parent.frames[1].document.forms[0].r_days.checked=false;
			parent.frames[1].document.forms[0].days.disabled=true;
			parent.frames[1].document.forms[0].r_month.checked=false;
			parent.frames[1].document.forms[0].r_week.checked=true;
			parent.frames[1].document.forms[0].days.value="";
		}

function calculateWeek(Obj)    //THIS IS TO POPULATE T.F END DATE ON CLICK OF RADIO BUTTON WEEK
		{
			var datefield = Obj;
			var strDateArray = new Array();
			strDate = datefield.value;
			strDateArray = strDate.split("/");



			strDay = strDateArray[0];
			strMonth = strDateArray[1];
			strYear = strDateArray[2];

			if(strDay == "08" ) strDay="8";
			if(strDay == "09") strDay="9";

			var day1 = eval(parseInt(strDay));

			if(strMonth == 1  || strMonth == 3 || strMonth == 5 || strMonth == 7  || strMonth == 8  || strMonth == 10  || strMonth == 12 )
			{
			if(day1 >= 25)
					{
					var k= 31-day1;
					var q=6-k;
					day1=q;
					if(day1<=9) day1="0"+day1;
					var day=day1;
					strMonth1= parseInt(strMonth)+1;
					if(strMonth1<=9) strMonth="0"+strMonth1;
						if(strMonth1 >12)
							{
								strMonth="01";
								strYear=parseInt(strYear)+1;
							}
					}
					else
					{
					var day=day1+6;
					if(day <=9) day="0"+day;
					}
				var set=day+"/"+strMonth+"/"+strYear;
				parent.frames[1].document.forms[0].prefenddate.value=set;
				parent.frames[1].document.forms[0].prefenddate1.value=set;
			}

			else
			if(strMonth == 4  || strMonth == 6 || strMonth == 9 || strMonth == 11)
			{
			if(day1 > 25)
					{
					var k= 30-day1;
					var q=6-k;
					day1=q;
					if(day1<=9) day1="0"+day1;
					var day=day1;
					strMonth1= parseInt(strMonth)+1;
					if(strMonth1<=9) strMonth="0"+strMonth1;
					}
					else
					{
					var day=day1+6;
					if(day <=9) day="0"+day;
					}
				var set=day+"/"+strMonth+"/"+strYear;
				parent.frames[1].document.forms[0].prefenddate.value=set;
				parent.frames[1].document.forms[0].prefenddate1.value=set;
			}

			else
			if(strMonth == 2)
			{
			if(parseInt(strYear) % 4 == 0)
				{
					if(day1 > 22)
						{
						var k= 28-day1;
						var q=5-k;
						day1=q;
						if(day1<=9) day1="0"+day1;
						var day=day1;
						strMonth1= parseInt(strMonth)+1;
						if(strMonth1<=9) strMonth="0"+strMonth1;
						}
						else
						{
						var day=day1+6;
						if(day <=9) day="0"+day;
						if(strMonth<=9) strMonth="0"+strMonth;
						}
				var set=day+"/"+strMonth+"/"+strYear;
				parent.frames[1].document.forms[0].prefenddate.value=set;
				parent.frames[1].document.forms[0].prefenddate1.value=set;
			   }
			   else
			   {
			   		if(day1 > 23)
						{
						var k= 29-day1;
						var q=7-k;
						day1=q;
						if(day1<=9) day1="0"+day1;
						var day=day1;
						strMonth1= parseInt(strMonth)+1;
						if(strMonth1<=9) strMonth="0"+strMonth1;
						}
						else
						{
						var day=day1+6;
						if(day <=9) day="0"+day;
						}
				var set=day+"/"+strMonth+"/"+strYear;
				parent.frames[1].document.forms[0].prefenddate.value=set;
				parent.frames[1].document.forms[0].prefenddate1.value=set;
			   }
			}
		}		//E.O.FUNCTION  CALCULATE-WEEK


	function calculateMonth(Obj)
	{
		//alert(Obj.value)
			
				var datefield = Obj;
				var strDateArray = new Array();
				strDate = datefield.value;
				strDateArray = strDate.split("/");

				strDay = strDateArray[0];
				strMonth = strDateArray[1];
				strYear = strDateArray[2];

				if(strDay == "01" ) strDay="1";
				if(strDay == "02" ) strDay="2";
				if(strDay == "03" ) strDay="3";
				if(strDay == "04" ) strDay="4";
				if(strDay == "05" ) strDay="5";
				if(strDay == "06" ) strDay="6";
				if(strDay == "07" ) strDay="7";
				if(strDay == "08" ) strDay="8";
				if(strDay == "09") strDay="9";
	
				if(strMonth == "01" ) strMonth="1";
				if(strMonth == "02" ) strMonth="2";
				if(strMonth == "03" ) strMonth="3";
				if(strMonth == "04" ) strMonth="4";
				if(strMonth == "05" ) strMonth="5";
				if(strMonth == "06" ) strMonth="6";
				if(strMonth == "07" ) strMonth="7";
				if(strMonth == "08" ) strMonth="8";
				if(strMonth == "09" ) strMonth="9";

				
				var day1 = parseInt(strDay);
						if(strMonth == 1  || strMonth == 3 || strMonth == 5 || strMonth == 7  || strMonth == 8  || strMonth == 10  || strMonth == 12 )
						{

							if(strYear % 4 == 0 )
							{
								if(strMonth == 1 && strDay == 31){
									var day="29/02/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
								}else{
									var t1=Obj.value;				
									var t2=t1.substring(0,2);
									var t3=t1.substring(3,5);
									var t4=t1.substring(6);

									t1=t3+"/"+t2+"/"+t4

									var dt=new Date(t1);
									var frval=dt.valueOf();

									frval=(frval)+(29*1000*60*60*24);
									var temp=new Date(dt.setTime(frval));
									t2=temp.getDate();
									if(t2<10) 
										t2="0"+t2;
									t3=temp.getMonth()+1;
									if(t3<10) 
										t3="0"+t3;
									t4=temp.getFullYear();
									
									parent.frames[1].document.forms[0].prefenddate.value=t2+"/"+t3+"/"+t4;
									parent.frames[1].document.forms[0].prefenddate1.value=t2+"/"+t3+"/"+t4;
								}

							}else if(strMonth == 1 && strDay == 31)	{
									var day="01/03/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
							}else{
								var j=parseInt(strDay);
								var extra=31-j;
								if(strDay == 1 || strDay == 2 ){
								var day1=parseInt(strDay)+29;
								if(day1 <= 9) day1="0"+day1;
								if(strMonth1 <=9) strMonth1="0"+strMonth1;
								var day=day1+"/"+strMonth+"/"+strYear;
								parent.frames[1].document.forms[0].prefenddate.value=day;
								parent.frames[1].document.forms[0].prefenddate1.value=day;
							}
							else if(j >2 && strMonth<12)
							{
							var day1=31-(extra+2);
							var strMonth1=parseInt(strMonth)+1;
							if(strMonth1 <=9) strMonth1="0"+strMonth1;
							if(day1 <= 9) day1="0"+parseInt(day1);
							var day=day1+"/"+strMonth1+"/"+strYear;
							parent.frames[1].document.forms[0].prefenddate.value=day;
							parent.frames[1].document.forms[0].prefenddate1.value=day;

							}

							else if(strMonth == 12)
							{
								var day1=31-(extra+2);
								var strMonth1="01";
								if(day1<=9) day1="0"+day1;

								var strYear1=parseInt(strYear)+1;
								var day=day1+"/"+strMonth1+"/"+strYear1;
							parent.frames[1].document.forms[0].prefenddate.value=day;
							parent.frames[1].document.forms[0].prefenddate1.value=day;
							}

						}
					}

					if(strMonth == 4  || strMonth == 6 || strMonth == 9 || strMonth == 11)
						{
								var j=parseInt(strDay);
								var extra=30-j;
								if(j == 1)
							{

								var day1=parseInt(strDay)+29;
								if(day1 <= 9) day1="0"+day1;
								var strMonth1= parseInt(strMonth);
								if(strMonth1<=9) strMonth="0"+strMonth1;
								var day=day1+"/"+strMonth+"/"+strYear;
								parent.frames[1].document.forms[0].prefenddate.value=day;
								parent.frames[1].document.forms[0].prefenddate1.value=day;
								
							}
							else if(j >1)
							{
								var day1=30-(extra+1);
								if(day1 <= 9) day1="0"+day1;
								var strMonth1=parseInt(strMonth)+1;
								if(strMonth1 <= 9) strMonth1="0"+strMonth1;
								var day=day1+"/"+strMonth1+"/"+strYear;
								parent.frames[1].document.forms[0].prefenddate.value=day;
								parent.frames[1].document.forms[0].prefenddate1.value=day;
							}

						}

					if(strMonth == 2)
					{
							if(strYear % 4 == 0)
							{
								var j=parseInt(strDay);
								var extra=29-j;
								if(strDay == 1)
								{
									var day="01/03/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
								}
								else if(j >1)
								{
									var day1=28-(extra-1);
									if(day1 <= 9) day1="0"+day1;
									var strMonth1=parseInt(strMonth)+1;
									strMonth1= parseInt(strMonth)+1;
									if(strMonth1<=9) strMonth="0"+strMonth1;
									var day=day1+"/"+strMonth+"/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
								}

							}
							else
							{
								var j=eval(parseInt(strDay));
								var extra=28-j;
								if(j == 1)
								{
									var day="02/03/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
								}
								else if(j >1 || j ==0)
								{
									var day1=28-(extra-1);
									if(day1 <= 9) day1="0"+day1;
									var strMonth1=parseInt(strMonth)+1;
									if(strMonth1 <= 10) strMonth1="0"+strMonth1;
									var day=day1+"/"+strMonth1+"/"+strYear;
									parent.frames[1].document.forms[0].prefenddate.value=day;
									parent.frames[1].document.forms[0].prefenddate1.value=day;
								}
							}

						}
				strDate = parent.frames[1].document.forms[0].prefdate1.value;
				
	

	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn_id.value;
	end_date=parent.frames[1].document.forms[0].prefenddate.value;
	parent.frames[1].document.forms[0].prefenddate2.value = parent.frames[1].document.forms[0].prefenddate.value; 

	var clinic= parent.frames[1].document.forms[0].clinic.value;
	clinic = clinic.substring(2,clinic.length);


	var practitioner=parent.frames[1].document.forms[0].practitioner.value;
	var practitioner_type=parent.frames[1].document.getElementById("practitioner_type").value;
	var speciality =parent.frames[1].document.forms[0].speciality.value;
	var visittype= parent.frames[1].document.forms[0].visittype.value;
	var ca_mode= parent.frames[1].document.forms[0].ca_mode.value;
	var ca_patient_id= parent.frames[1].document.forms[0].ca_patient_id.value;
	var pref_start_date=parent.frames[1].document.forms[0].prefdate1.value;
	var pref_end_date=parent.frames[1].document.forms[0].prefenddate1.value;
	var call_date_yn = parent.frames[1].document.forms[0].call_date_yn.value;	 	
	var callingMode = parent.frames[1].document.forms[0].callingMode.value;
	var calledFrom = parent.frames[1].document.forms[0].calledFrom.value;
	var disp_ear_sch="";
	if (parent.frames[1].document.forms[0].disp_next.checked==true)
		disp_ear_sch="Y";
	else
		disp_ear_sch ="N";

	var hddSpeclty=parent.frames[1].document.forms[0].hddSpeciality.value;
	var unidfyres='';//parent.frames[1].document.forms[0].chkUnidPract.checked;

	var care_locn_ind=parent.frames[1].document.forms[0].location_type.value;
	var res_class=parent.frames[1].document.forms[0].resourceType1.value;
	//var res_class=parent.frames[1].document.forms[0].resourceType_1.value;

	var or_catalogue_code="";
	if(parent.frames[1].document.forms[0].or_catalogue_code)
					{
			or_catalogue_code=parent.frames[1].document.forms[0].or_catalogue_code.value;
			}
	var order_id=parent.frames[1].document.forms[0].order_id.value;
	var order_line_num=parent.frames[1].document.forms[0].order_line_num.value;
	var order_catalog_code=parent.frames[1].document.forms[0].order_catalog_code.value;
	var specialty_codema1 =parent.frames[1].document.forms[0].specialty_codema1.value;
	var install_yn_val=parent.frames[1].document.forms[0].install_yn_val.value;
	var from_OR= parent.frames[1].document.forms[0].from_OR.value;
	var create_wait_list_yn= parent.frames[1].document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= parent.frames[1].document.forms[0].visit_flag_OP.value;
	var no_dwm= parent.frames[1].document.forms[0].no_dwm.value;
var visittype= parent.frames[1].document.forms[0].visittype.value;
var dwm_desc= parent.frames[1].document.forms[0].dwm_desc.value;
var from_page=parent.frames[1].document.forms[0].from_page_new.value;
var from_facility_id=parent.frames[1].document.forms[0].from_facility_id.value;
var from_encounter_id=parent.frames[1].document.forms[0].from_encounter_id.value;
var rd_appt_yn="N"
	if(parent.frames[1].document.forms[0].rd_oa_integration_yn.value=="Y"){	
		if(parent.frames[1].document.forms[0].rd_appt_yn.checked){
			parent.frames[1].document.forms[0].rd_appt_yn.value = "Y"
			rd_appt_yn = parent.frames[1].document.forms[0].rd_appt_yn.value;
		}else{
			parent.frames[1].document.forms[0].rd_appt_yn.value = "N"
			rd_appt_yn = parent.frames[1].document.forms[0].rd_appt_yn.value;
		}
	}
	
res_class=parent.frames[1].document.forms[0].resourceType_1.value;
 var urlStr="../../eOA/jsp/ScheduleResult1.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&week=no&month=yes&days=no&Date="+convertDate(strDate,"DMY",localeName,"en")+"&var_Day="+strDay+"&var_Month="+strMonth+"&var_Year="+strYear+"&end_date="+convertDate(end_date,"DMY",localeName,"en")+"&hddSpeclty="+hddSpeclty+"&oper_stn_id="+oper_stn_id+"&clinic="+clinic+"&practitioner="+practitioner+"&call_date_yn="+call_date_yn+"&pref_start_date="+convertDate(pref_start_date,"DMY",localeName,"en")+"&pref_end_date="+convertDate(pref_end_date,"DMY",localeName,"en")+"&practitioner_type="+practitioner_type+"&speciality="+speciality+"&ca_mode="+ca_mode+"&ca_patient_id="+ca_patient_id+"&visittype="+visittype+"&disp_ear_sch="+disp_ear_sch+"&callingMode="+callingMode+"&unidfyres="+unidfyres+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&or_catalogue_code="+or_catalogue_code+"&order_catalog_code="+order_catalog_code+"&specialty_codema1="+specialty_codema1+"&install_yn_val="+install_yn_val+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&no_dwm="+no_dwm+"&visittype"+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&calledFrom="+calledFrom+"&rd_appt_yn="+rd_appt_yn;

	parent.result.document.location.href=urlStr;
}
//THIS IS FOR FILLING END DAYS IF NO PARAMETERS LIKE WEEK,MONTH OR DAYS R CHECKED
	function fillemptyfields(prefdate)
		{
		if(parent.frames[1].document.forms[0].r_days.checked==false && parent.frames[1].document.forms[0].r_week.checked==false && parent.frames[1].document.forms[0].r_month.checked== false && parent.frames[1].document.forms[0].prefenddate.value==" " )
			{
			 calculateMonth(prefdate);
			}
		}

//THIS FUNCTION WILL TAKE U TO ANOTHER FRAME TO FILL THE CELLS
function fetchResult1(){
	
	var dttm=getCurrentDate('DMYHM' ,'<%=locale%>');	
	
	var arr =new Array();
	arr=dttm.split(' ');	
	var sys_time=arr[1];
	from_time=parent.frames[1].document.forms[0].From_timeval.value;
	to_time=parent.frames[1].document.forms[0].To_timeval.value;
	var speciality=parent.frames[1].document.forms[0].speciality.value;
	var locn=parent.frames[1].document.forms[0].clinic.value;
	var ca_md=parent.frames[1].document.forms[0].callingMode.value;
	var practitioner=parent.frames[1].document.forms[0].practitioner.value;
	rule_appl_yn = parent.frames[1].document.forms[0].rule_appl_yn.value;
	var tr_rule_based=false;
	
	//var schedule_gender=parent.frames[1].document.forms[0].schedule_gender.value; //Added this Line for this CRF [Bru-HIMS-CRF-167]
	
	
	if(parent.frames[1].document.forms[0].tr_rule_applicable){
		//alert("line 509");
		tr_rule_based=parent.frames[1].document.forms[0].tr_rule_applicable.checked;
	}
	if((speciality =="" && locn=="" && practitioner=="")&&(!tr_rule_based)){ 
		//alert("line 513");
		parent.frames[3].location.href="../../eCommon/html/blank.html";
		var error = getMessage("SPECIALITY_OR_LOCATION","OA");
		alert(error);	
	}else if(speciality =="" && tr_rule_based){
		//alert("line 518");
		parent.frames[3].location.href="../../eCommon/html/blank.html";
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.speciality.label","Common"));
		alert(error);	
	}else{	
		if(parent.frames[1].document.forms[0].no_dwm.value !=''){
			//alert("line 525");
			setTimeout('calucalte_enddate(1)',500);
		}
		//alert("line 528");
		setTimeout('fetchResult()',1000);
				
	}
}
function fetchResult(){  //calledFrom parameter added by Sathish.S for IN020026 onMonday, March 22, 2010
	var tr_rule_based=false;
	if(parent.frames[1].document.forms[0].tr_rule_applicable){
		tr_rule_based=parent.frames[1].document.forms[0].tr_rule_applicable.checked;
	}
	var rule_appl_yn=parent.frames[1].document.forms[0].rule_appl_yn.value;
	var rd_appt_yn=  "";
	if(parent.frames[1].document.forms[0].rd_oa_integration_yn.value=="Y"){
		if(parent.frames[1].document.forms[0].rd_appt_yn.checked){
			parent.frames[1].document.forms[0].rd_appt_yn.value = "Y"
			rd_appt_yn = parent.frames[1].document.forms[0].rd_appt_yn.value;			
		}else{
				parent.frames[1].document.forms[0].rd_appt_yn.value = "N"
			rd_appt_yn = parent.frames[1].document.forms[0].rd_appt_yn.value;				
			}
	}
	
//	var tr_rule_based=false;
	
	if(rule_appl_yn == 'Y'){
	//Below Code Fix[parent.parent.frames[1] Changed in to parent.frames[1]--Line Number 522 to 526 ] Against Incident Number 35182 Dated on 18-09-2012 By Saanthaakumar
		if(parent.frames[1].AppointmentFrame){
			//parent.frames[1].AppointmentFrame.rows='3%,47%,0%,*';
		parent.frames[1].document.getElementById("image").style.height="3vh";
		parent.frames[1].document.getElementById("querying").style.height="47vh";
		parent.frames[1].document.getElementById("dummy").style.height="0vh";
		parent.frames[1].document.getElementById("result").style.height="50vh";
		}else if(parent.frames[1].appt_page){
			//parent.frames[1].appt_page.rows='3%,47%,0%,*';
		parent.frames[1].document.getElementById("image").style.height="3vh";
		parent.frames[1].document.getElementById("querying").style.height="47vh";
		parent.frames[1].document.getElementById("dummy").style.height="0vh";
		parent.frames[1].document.getElementById("result").style.height="50vh";
		}// 35182 End
		
	}else{
		if(document.forms[0].callingMode.value=='RSCAPPT'){
		}else{
			if(parent.parent.frames[1].AppointmentFrame) {
				//parent.parent.frames[1].AppointmentFrame.rows='3%,30%,0%,*';
				parent.frames[1].document.getElementById("image").style.height="3vh";
				parent.frames[1].document.getElementById("querying").style.height="30vh";
				parent.frames[1].document.getElementById("dummy").style.height="0vh";
				parent.frames[1].document.getElementById("result").style.height="67vh";
			}
		}
	}
	if(tr_rule_based && parent.frames[1].document.forms[0].practitioner.value!=''){
		alert(getMessage("RES_SEL_RULE_NOT_APPL","OA"));
		tr_rule_based = false;
		parent.frames[1].document.forms[0].tr_rule_applicable.checked = false;
		CheckRule(parent.frames[1].document.forms[0].tr_rule_applicable,'N');
	}
	//if((document.forms[0].all.PractProcImg && document.forms[0].all.PractProcImg.style.visibility=='visible')&&(parent.frames[1].document.forms[0].linking_code.value=='')){
		if((document.getElementById('PractProcImg') && document.getElementById('PractProcImg').style.visibility=='visible')&&(parent.frames[1].document.forms[0].linking_code.value=='')){
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.ProcedureCode.label","Common"));
		alert(error);
		return;
	}

	//if(document.forms[0].all.ordCatImg && document.forms[0].all.ordCatImg.style.visibility=='visible' && document.forms[0].all.or_catalogue_desc.value==""){
	if(document.getElementById('ordCatImg') && document.getElementById('ordCatImg').style.visibility=='visible' && document.getElementById('or_catalogue_desc').value==""){
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.ordercatalog.label","Common"));
		alert(error);
		return;
	}
	if(tr_rule_based){
		var patient_id		= parent.frames[1].document.forms[0].patient_id.value;
		var oper_stn_id		= parent.frames[1].document.forms[0].oper_stn_id.value;
		var speciality		= parent.frames[1].document.forms[0].speciality.value;
		var care_locn_ind	= parent.frames[1].document.forms[0].location_type.value;
		var prefdate1		= parent.frames[1].document.forms[0].prefdate1.value;
		var From_timeval	= parent.frames[1].document.forms[0].From_timeval.value;
		var To_timeval		= parent.frames[1].document.forms[0].To_timeval.value;
		var term_set_id		= parent.frames[1].document.forms[0].term_set_id.value;
		var linking_code	= parent.frames[1].document.forms[0].linking_code.value;
		var language_code	= parent.frames[1].document.forms[0].language_code.value;
		var nationality_code= parent.frames[1].document.forms[0].nationality_code.value;
		var	name_prefix="";	
		var first_name="";
		var second_name="";
		var third_name="";
		var family_name="";
		var name_suffix="";
		var name_prefix_oth_lang="";	
		var first_name_oth_lang="";
		var second_name_oth_lang="";
		var third_name_oth_lang="";
		var family_name_oth_lang="";
		var name_suffix_oth_lang="";
		var gender="";
		var contact_no="";
		var prefDate_is_sysDate="N";
		var sysdate = parent.frames[1].document.forms[0].prefdate_curr.value; 
		var clinic= parent.frames[1].document.forms[0].clinic.value;
		clinic = clinic.substring(2,clinic.length);
		
		if(parent.frames[1].document.forms[0].name_prefix){
			name_prefix=encodeURIComponent(parent.frames[1].document.forms[0].name_prefix.value);
		}
		if(parent.frames[1].document.forms[0].first_name){
			first_name = encodeURIComponent(parent.frames[1].document.forms[0].first_name.value);
		}
		if(parent.frames[1].document.forms[0].second_name){
			second_name = encodeURIComponent(parent.frames[1].document.forms[0].second_name.value);
		}
		if(parent.frames[1].document.forms[0].third_name){
			third_name = encodeURIComponent(parent.frames[1].document.forms[0].third_name.value);
		}
		if(parent.frames[1].document.forms[0].family_name){
			family_name = encodeURIComponent(parent.frames[1].document.forms[0].family_name.value);
		}
		if(parent.frames[1].document.forms[0].name_suffix){
			name_suffix=encodeURIComponent(parent.frames[1].document.forms[0].name_suffix.value);
		}
		
		if(parent.frames[1].document.forms[0].name_prefix_oth_lang){
			name_prefix_oth_lang=encodeURIComponent(document.forms[0].name_prefix_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].first_name_oth_lang){
			first_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].first_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].second_name_oth_lang){
			second_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].second_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].third_name_oth_lang){
			third_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].third_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].family_name_oth_lang){
			family_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].family_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].name_suffix_oth_lang){
			name_suffix_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].name_suffix_oth_lang.value);
		}
		
		if(parent.frames[1].document.forms[0].gender){
			gender = parent.frames[1].document.forms[0].gender.value;
		}
		if(parent.frames[1].document.forms[0].contact_no){
			contact_no = parent.frames[1].document.forms[0].contact_no.value;
		}
		var resource_class = parent.frames[1].document.forms[0].resourceType_1.value;
		var order_id 			= "";
		var order_line_num		= "";
		var order_catalog_code	= "";
		if(prefdate1 == "" || From_timeval == "" || To_timeval == ""){
			var error = getMessage("PREF_DATE_TIME","OA");
			//var error = 'Preferre Date and time Can\'t be blank';
			alert(error)
			return;
		}else{
			sysdate = convertDate(sysdate,"DMY","en",localeName)
			if(prefdate1 == sysdate){
				prefDate_is_sysDate = 'Y';
			}
			if(document.forms[0].order_id.value !=""){
				order_id 			= document.forms[0].order_id.value;
				order_line_num  	= document.forms[0].order_line_num.value;
				order_catalog_code	= document.forms[0].order_catalog_code.value;
				var prfDate =convertDate(parent.frames[1].document.forms[0].prefdate1.value,"DMY",localeName,"en");
				if(!(isBefore(parent.frames[1].document.forms[0].prefdate.value,prfDate,'DMY',localeName))){
					alert(getMessage("PREF_DATE_SHLD_GRTR_THAN_ORDDT","OA"));
					return;
				}
			}
			var url="../../eOA/jsp/RuleScheduleResultMain.jsp?oper_stn_id="+oper_stn_id+"&speciality="+speciality+"&care_locn_ind="+care_locn_ind+"&prefdate1="+prefdate1+"&From_timeval="+From_timeval+"&To_timeval="+To_timeval+"&patient_id="+patient_id+"&name_prefix="+name_prefix+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_suffix="+name_suffix+"&name_prefix_oth_lang="+name_prefix_oth_lang+"&first_name_oth_lang="+first_name_oth_lang+"&second_name_oth_lang="+second_name_oth_lang+"&third_name_oth_lang="+third_name_oth_lang+"&family_name_oth_lang="+family_name_oth_lang+"&name_suffix_oth_lang="+name_suffix_oth_lang+"&gender="+gender+"&contact_no="+contact_no+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&resource_class="+resource_class+"&language_code="+language_code+"&prefDate_is_sysDate="+prefDate_is_sysDate+"&clinic="+clinic+"&nationality_code="+nationality_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code;
			//alert(url)
			parent.result.location.href=url;
		}
	}else{
	strDate = parent.frames[1].document.forms[0].prefdate1.value;
	end_date=parent.frames[1].document.forms[0].prefenddate1.value;	
	var calledFrom=parent.frames[1].document.forms[0].calledFrom.value;	
	var tosubmit=true;
	var position="";
	var addtl_splty="";
	if(parent.frames[1].document.forms[0].position){
		position=parent.frames[1].document.forms[0].position.value;
	}
	addtl_splty=parent.frames[1].document.forms[0].addtl_splty.value;
	if(strDate!="" && end_date!=""){
		var year_count=yearsBetween(strDate,end_date,'DMY',localeName);
		if(year_count >= 1){
			var error = getMessage('SCH_GREATER_THAN_YEAR','OA');	
			alert(error);
			tosubmit=false;
		}else{
			tosubmit=true;
		}
	}
		var patient_id_temp	= "";
		var language_code_temp	= "";
		var nationality_code_temp = "" ;	
		var	name_prefix="";			
		var first_name="";
		var second_name="";
		var third_name="";
		var family_name="";
		var name_suffix="";
		var	name_prefix_oth_lang="";	
		var first_name_oth_lang="";
		var second_name_oth_lang="";
		var third_name_oth_lang="";
		var family_name_oth_lang="";
		var name_suffix_oth_lang="";
		var gender="";
		var contact_no="";
		var prefDate_is_sysDate="N";
		var sysdate = parent.frames[1].document.forms[0].hidden_from_date.value; 
		var clinic= parent.frames[1].document.forms[0].clinic.value;
		clinic = clinic.substring(2,clinic.length);
		if(parent.frames[1].document.forms[0].patient_id)
			patient_id_temp = parent.frames[1].document.forms[0].patient_id.value;
		if(parent.frames[1].document.forms[0].name_prefix){
			name_prefix=encodeURIComponent(parent.frames[1].document.forms[0].name_prefix.value);
		}
		if(parent.frames[1].document.forms[0].first_name){
			first_name = encodeURIComponent(parent.frames[1].document.forms[0].first_name.value);
		}
		if(parent.frames[1].document.forms[0].second_name){
			second_name = encodeURIComponent(parent.frames[1].document.forms[0].second_name.value);
		}
		if(parent.frames[1].document.forms[0].third_name){
			third_name = encodeURIComponent(parent.frames[1].document.forms[0].third_name.value);
		}
		if(parent.frames[1].document.forms[0].family_name){
			family_name = encodeURIComponent(parent.frames[1].document.forms[0].family_name.value);
		}
		if(parent.frames[1].document.forms[0].name_suffix){
			name_suffix=encodeURIComponent(parent.frames[1].document.forms[0].name_suffix.value);
		}
		
		if(parent.frames[1].document.forms[0].name_prefix_oth_lang){
			name_prefix_oth_lang=encodeURIComponent(parent.frames[1].document.forms[0].name_prefix_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].first_name_oth_lang){
			first_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].first_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].second_name_oth_lang){
			second_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].second_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].third_name_oth_lang){
			third_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].third_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].family_name_oth_lang){
			family_name_oth_lang = encodeURIComponent(parent.frames[1].document.forms[0].family_name_oth_lang.value);
		}
		if(parent.frames[1].document.forms[0].name_suffix_oth_lang){
			name_suffix_oth_lang = error_id=encodeURIComponent(parent.frames[1].document.forms[0].name_suffix_oth_lang.value);
		}
		
		if(parent.frames[1].document.forms[0].gender){
			gender = parent.frames[1].document.forms[0].gender.value;
		}
		if(parent.frames[1].document.forms[0].contact_no){
			contact_no = parent.frames[1].document.forms[0].contact_no.value;
		}
		if(parent.frames[1].document.forms[0].language_code)
			language_code_temp = parent.frames[1].document.forms[0].language_code.value;
		if(parent.frames[1].document.forms[0].nationality_code)				
			nationality_code_temp = parent.frames[1].document.forms[0].nationality_code.value;
		var term_set_id 	= '';
		var linking_code	= '';

		if(parent.frames[1].document.forms[0].term_set_id)
		term_set_id=parent.frames[1].document.forms[0].term_set_id.value;
		else
		term_set_id="";

		if(parent.frames[1].document.forms[0].linking_code)
		linking_code=parent.frames[1].document.forms[0].linking_code.value;
		else
		linking_code="";	
	if(tosubmit ==true){
		var trker=parent.frames[1].document.forms[0].fromTracker.value;
		var ca_md=parent.frames[1].document.forms[0].ca_mode.value
		if(trker==''){		
			//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 
			var ca_md=parent.frames[1].document.forms[0].ca_mode.value
			if(ca_md != '' ){
				if(top.content){
					top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
				}
			}else{
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			}
		}
		var oper_stn_id=parent.frames[1].document.forms[0].oper_stn_id.value;
		var clinic= parent.frames[1].document.forms[0].clinic.value;
		clinic = clinic.substring(2,clinic.length);
		var practitioner=parent.frames[1].document.forms[0].practitioner.value;
		var practitioner_type=parent.frames[1].document.getElementById("practitioner_type").value;
		var speciality =parent.frames[1].document.forms[0].speciality.value;
		var visittype= parent.frames[1].document.forms[0].visittype.value;
		var ca_mode= parent.frames[1].document.forms[0].ca_mode.value;
		var ca_patient_id= parent.frames[1].document.forms[0].ca_patient_id.value;		
		if(strDate=='' && end_date==''){
			parent.frames[1].document.forms[0].call_date_yn.value="Y";
			var prefdate1_bud=convertDate(parent.frames[1].document.forms[0].prefdate_curr.value,"DMY","en",localeName);
			parent.frames[1].document.forms[0].prefdate1.value=prefdate1_bud;
			calculateMonth(parent.frames[1].document.forms[0].prefdate1);
			}else{ //Added by S.Sathish for IN020569 on Monday, April 19, 2010
				parent.frames[1].document.forms[0].call_date_yn.value="N";
			}
		
		if(strDate=='' || end_date==''){
			if(strDate!=''){
				calculateMonth(parent.frames[1].document.forms[0].prefdate1);
			}else if(end_date!=''){
				var t='';
				var t1=parent.frames[1].document.forms[0].prefenddate1.value;
				if (t1.substring(4,5)=='/'){
					t=t1.substring(0,3)+'0'+t1.substring(3);
					//	alert("t2 "+t2)
					t1=t;
				}
				//	alert('t1'+t1)
				var t2=t1.substring(0,2);
				var t3=t1.substring(3,5);
				var t4=t1.substring(6);
				t1=t3+"/"+t2+"/"+t4
				var dt=new Date(t1);
				var frval=dt.valueOf();
				frval=(frval)-(29*1000*60*60*24);
				var temp=new Date(dt.setTime(frval));
				t2=temp.getDate();
				if(t2<10) 
					t2="0"+t2;
				t3=temp.getMonth()+1;
				if(t3<10) 
					t3="0"+t3;
				t4=temp.getFullYear();
				parent.frames[1].document.forms[0].prefdate1.value=t2+"/"+t3+"/"+t4;
								
				if(DateCompare_apply(parent.frames[1].document.forms[0].prefdate_curr,parent.frames[1].document.forms[0].prefdate1)){
					strDate = parent.frames[1].document.forms[0].prefdate1.value;
					var pref_start_date=parent.frames[1].document.forms[0].prefdate1.value;
					var pref_end_date=parent.frames[1].document.forms[0].prefenddate1.value;
					var disp_ear_sch="";
					if (parent.frames[1].document.forms[0].disp_next.checked==true)
						disp_ear_sch="Y";
					else
						disp_ear_sch ="N";
					var call_date_yn = parent.frames[1].document.forms[0].call_date_yn.value;	 
					
					var hddSpeclty=parent.frames[1].document.forms[0].hddSpeciality.value;
					var callingMode = parent.frames[1].document.forms[0].callingMode.value;
					parent.frames[1].document.forms[0].search.disabled=true;
				
					var unidfyres='';

					var care_locn_ind=parent.frames[1].document.forms[0].location_type.value;
					var res_class=parent.frames[1].document.forms[0].resourceType1.value;
					//var res_class=parent.frames[1].document.forms[0].resourceType_1.value;
					var or_catalogue_code="";
					if(parent.frames[1].document.forms[0].or_catalogue_code){
						or_catalogue_code=parent.frames[1].document.forms[0].or_catalogue_code.value;
					}
					var order_id=parent.frames[1].document.forms[0].order_id.value;
					var order_line_num=parent.frames[1].document.forms[0].order_line_num.value;
					var order_catalog_code =parent.frames[1].document.forms[0].order_catalog_code.value;
					var specialty_codema1 =parent.frames[1].document.forms[0].specialty_codema1.value;
					var req_id=parent.frames[1].document.forms[0].req_id.value;
					var install_yn_val=parent.frames[1].document.forms[0].install_yn_val.value;
					var from_OR= parent.frames[1].document.forms[0].from_OR.value;
					var create_wait_list_yn= parent.frames[1].document.forms[0].create_wait_list_yn.value;
					var visit_flag_OP= parent.frames[1].document.forms[0].visit_flag_OP.value;
					var no_dwm= parent.frames[1].document.forms[0].no_dwm.value;
					var visittype= parent.frames[1].document.forms[0].visittype.value;
					var dwm_desc= parent.frames[1].document.forms[0].dwm_desc.value;
					var from_page=parent.frames[1].document.forms[0].from_page_new.value;
					var from_facility_id=parent.frames[1].document.forms[0].from_facility_id.value;
					var from_encounter_id=parent.frames[1].document.forms[0].from_encounter_id.value;


					var strDate_greg=convertDate(strDate,"DMY",localeName,"en");
					var end_date_greg=convertDate(end_date,"DMY",localeName,"en");

					var pref_start_date_greg=convertDate(pref_start_date,"DMY",localeName,"en");
					var pref_end_date_greg=convertDate(pref_end_date,"DMY",localeName,"en");
					
					
					res_class=parent.frames[1].document.forms[0].resourceType_1.value;
					
					var url="../../eOA/jsp/ScheduleResult1.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&week=no&month=yes&days=no&Date="+strDate_greg+"&var_Day="+strDay+"&var_Month="+strMonth+"&var_Year="+strYear+"&end_date="+end_date_greg+"&oper_stn_id="+oper_stn_id+"&clinic="+clinic+"&practitioner="+practitioner+"&practitioner_type="+practitioner_type+"&speciality="+speciality+"&pref_start_date="+pref_start_date_greg+"&pref_end_date="+pref_end_date_greg+"&call_date_yn="+call_date_yn+"&ca_mode="+ca_mode+"&ca_patient_id="+ca_patient_id+"&visittype="+visittype+"&disp_ear_sch="+disp_ear_sch+"&callingMode="+callingMode+"&hddSpeclty="+hddSpeclty+"&unidfyres="+unidfyres+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&or_catalogue_code="+or_catalogue_code+"&order_catalog_code="+order_catalog_code+"&specialty_codema1="+specialty_codema1+"&req_id="+req_id+"&install_yn_val="+install_yn_val+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id_temp+"&name_prefix="+name_prefix+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_suffix="+name_suffix+"&name_prefix_oth_lang="+name_prefix_oth_lang+"&first_name_oth_lang="+first_name_oth_lang+"&second_name_oth_lang="+second_name_oth_lang+"&third_name_oth_lang="+third_name_oth_lang+"&family_name_oth_lang="+family_name_oth_lang+"&name_suffix_oth_lang="+name_suffix_oth_lang+"&gender="+gender+"&contact_no="+contact_no+"&language_code_temp="+language_code_temp+"&nationality_code_temp="+nationality_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
					parent.result.document.location.href=url;
	
				}else{
					alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
					parent.frames[1].document.forms[0].prefdate1.value='';
					parent.frames[1].document.forms[0].prefenddate1.value='';
					parent.frames[1].document.forms[0].prefdate1.focus();
					parent.result.document.location.href="../../eCommon/html/blank.html";
				}				
			 }			
		}else{
			var callingMode = parent.frames[1].document.forms[0].callingMode.value;
			if (callingMode==""){
				var ca_md=parent.frames[1].document.forms[0].ca_mode.value
				//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 
				if(ca_md != '' ){
						top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}else{
					parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}
			}

			strDate = parent.frames[1].document.forms[0].prefdate1.value;
			var pref_start_date=parent.frames[1].document.forms[0].prefdate1.value;
			var pref_end_date=parent.frames[1].document.forms[0].prefenddate1.value;
	
			var disp_ear_sch="";
			if (parent.frames[1].document.forms[0].disp_next.checked==true)
				disp_ear_sch="Y";
			else
				disp_ear_sch ="N";
			var call_date_yn = parent.frames[1].document.forms[0].call_date_yn.value;	 	
			
			var hddSpeclty=parent.frames[1].document.forms[0].hddSpeciality.value;
			parent.frames[1].document.forms[0].search.disabled=true;
			var unidfyres='';//parent.frames[1].document.forms[0].chkUnidPract.checked;
			var care_locn_ind=parent.frames[1].document.forms[0].location_type.value;
			var res_class=parent.frames[1].document.forms[0].resourceType1.value;
			//var res_class=parent.frames[1].document.forms[0].resourceType_1.value;
			var order_id=parent.frames[1].document.forms[0].order_id.value;
			var order_line_num=parent.frames[1].document.forms[0].order_line_num.value;
			var or_catalogue_code="";
			if(parent.frames[1].document.forms[0].or_catalogue_code)
					{
			or_catalogue_code=parent.frames[1].document.forms[0].or_catalogue_code.value;
			}
			var order_catalog_code=parent.frames[1].document.forms[0].order_catalog_code.value;
			var specialty_codema1 =parent.frames[1].document.forms[0].specialty_codema1.value;
			var req_id=parent.frames[1].document.forms[0].req_id.value;
			var install_yn_val=parent.frames[1].document.forms[0].install_yn_val.value;
			var visittype= parent.frames[1].document.forms[0].visittype.value;

			var from_OR= parent.frames[1].document.forms[0].from_OR.value;
			var create_wait_list_yn= parent.frames[1].document.forms[0].create_wait_list_yn.value;
			var visit_flag_OP= parent.frames[1].document.forms[0].visit_flag_OP.value;
			var no_dwm= parent.frames[1].document.forms[0].no_dwm.value;
			var dwm_desc= parent.frames[1].document.forms[0].dwm_desc.value;
			var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
			var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;

			var strDate_greg=convertDate(strDate,"DMY",localeName,"en");
			var end_date_greg=convertDate(end_date,"DMY",localeName,"en");

			var pref_start_date_greg=convertDate(pref_start_date,"DMY",localeName,"en");
			var pref_end_date_greg=convertDate(pref_end_date,"DMY",localeName,"en");
			var from_page=parent.frames[1].document.forms[0].from_page_new.value;

			res_class=parent.frames[1].document.forms[0].resourceType_1.value;
			
			var schedule_gender="";
			if(parent.frames[1].document.forms[0].schedule_gender)
			schedule_gender=parent.frames[1].document.forms[0].schedule_gender.value;  // Line Added for CRF [Bru-HIMS-CRF-167] 
            
		
				var url="../../eOA/jsp/ScheduleResult1.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&week=no&month=yes&days=no&Date="+strDate_greg+"&var_Day="+strDay+"&var_Month="+strMonth+"&var_Year="+strYear+"&end_date="+end_date_greg+"&oper_stn_id="+oper_stn_id+"&clinic="+clinic+"&practitioner="+practitioner+"&practitioner_type="+practitioner_type+"&speciality="+speciality+"&pref_start_date="+pref_start_date_greg+"&pref_end_date="+pref_end_date_greg+"&call_date_yn="+call_date_yn+"&ca_mode="+ca_mode+"&ca_patient_id="+ca_patient_id+"&visittype="+visittype+"&disp_ear_sch="+disp_ear_sch+"&callingMode="+callingMode+"&hddSpeclty="+hddSpeclty+"&unidfyres="+unidfyres+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&or_catalogue_code="+or_catalogue_code+"&order_catalog_code="+order_catalog_code+"&specialty_codema1="+specialty_codema1+"&req_id="+req_id+"&install_yn_val="+install_yn_val+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&no_dwm="+no_dwm+"&visittype"+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id_temp+"&name_prefix="+name_prefix+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_suffix="+name_suffix+"&name_prefix_oth_lang="+name_prefix_oth_lang+"&first_name_oth_lang="+first_name_oth_lang+"&second_name_oth_lang="+second_name_oth_lang+"&third_name_oth_lang="+third_name_oth_lang+"&family_name_oth_lang="+family_name_oth_lang+"&name_suffix_oth_lang="+name_suffix_oth_lang+"&gender="+gender+"&contact_no="+contact_no+"&language_code_temp="+language_code_temp+"&nationality_code_temp="+nationality_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn+"&schedule_gender="+schedule_gender;
			
		
			parent.result.document.location.href=url;
	
		}
	}else{		
	}
	}
		
	}


		function check_for_positive(Obj,Obj1)
		{
		var check=parent.frames[1].document.forms[0].days.value
		if(check > 30 || check < 1 ) {  parent.frames[1].document.forms[0].days.select();parent.frames[1].document.forms[0].days.focus();//alert("APP-OA0167 Days should be between 1 and 30"); 
		alert(getMessage('DAYS_RANGE','OA'));
		}
		else
		calculateDays(Obj,Obj1);
		}

	//  THIS IS FOR CALCULATING -DAYS BASED ON THE NO. OF DAYS THE USER ENTERS
	function calculateDays(Obj,Obj1)
		{
				parent.frames[1].document.forms[0].search.disabled=false;
				var datefield = Obj1;
				var strDateArray = new Array();
				strDate = datefield.value;
				strDateArray = strDate.split("/");

				strDay = strDateArray[0];
				strMonth = strDateArray[1];
				strYear = strDateArray[2];

				if(strDay == "08" ) strDay="8";
				if(strDay == "09") strDay="9";

				var day1 = parseInt(strDay);

				var z=Obj.value;

			var day=day1+parseInt(z)-1;

			if(strMonth == 1  || strMonth == 3 || strMonth == 5 || strMonth == 7  || strMonth == 8  || strMonth == 10  || strMonth == 12 )
				{

					if(day <= 31)
						{
						if(day <= 9) day ="0"+day;
						var set=day+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;

						}
					else if(day > 31)
						{
						if(strMonth == 12) strYear = parseInt(strYear) +1;
						var end=day-31;
						if(end <= 9) end ="0"+end;
						if(strMonth == 12) strMonth = "1";
						else
						strMonth=parseInt(strMonth)+1;
						if(strMonth <=9) strMonth="0"+strMonth
						var set1=end+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set1;
						parent.frames[1].document.forms[0].prefenddate1.value=set1;
						}

				}

			else	if(strMonth == 4  || strMonth == 6 || strMonth == 9 || strMonth == 11)
					{
					if(day < 30)
						{
						if(day <= 9) day ="0"+day;
						var set=day+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}
					else if(day > 30)
						{
						var end=day-30;
						if(end <= 9) end ="0"+end;
						strMonth=parseInt(strMonth)+1;
						if(strMonth <=9) strMonth="0"+strMonth
						var set=end+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}
					}

			else if(strMonth == 2)
				{
				if(strYear % 4 != 0)
				{
					{
					if(day <=28)
						{
						if(day <= 9) day ="0"+day;
						var set=day+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}
					else if(day > 28)
						{
						var end=day-28;
						if(end <= 9) end ="0"+end;
						strMonth=parseInt(strMonth)+1;
						if(strMonth <=9) strMonth="0"+strMonth
						var set=end+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}
					}
				}
				else
				if(strYear % 4 == 0)
				{
					{
					if(day <=29)
						{
						if(day <= 9) day ="0"+day;
						var set=day+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}
					else if(day > 28)
						{
						var end=day-29;
						if(end <= 9) end ="0"+end;
						strMonth=parseInt(strMonth)+1;
						if(strMonth <=9) strMonth="0"+strMonth
						var set=end+"/"+strMonth+"/"+strYear;
						parent.frames[1].document.forms[0].prefenddate.value=set;
						parent.frames[1].document.forms[0].prefenddate1.value=set;
						}

					}
				}
			}
		}

function compareFromDate(to,from,to1) {
          if (from.value!=null && from.value!="")
          {
			if (CheckDate(from,'test'))
			{
			var fromarray; var toarray;var toarray1;
			var fromdate = from.value ;
			var todate   = to.value ;
			if(fromdate.length > 0 && todate.length > 0 ) {
					fromarray = todate.split("/");
					toarray = fromdate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt   = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)) {
						  var err_msg = getMessage('PREF_FM_DT_VALIDATION','OA');
						  alert(err_msg);
						  from.focus();
						return false;
					}                    
				
        else
		{

				if (to1.value!=null)
                    {
					var to1date= to1.value;
					fromarray   = fromdate.split("/");
					toarray     = to1date.split("/");
					var fromdt  = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt    = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)) {
						  var err_msg = getMessage('FM_DATE_GR_TO_DATE','OA');
						  alert(err_msg);
						  from.focus();
						return false;
					}
					}
        return true;
		}
		}
        else
		{
		from.focus();
		return false;
		}
		}
		else
		{
		from.focus();
		return false;
		}
		}
         }
function compareToDate(to,from,to1) {
          if (from.value!=null && from.value!="")
          {
			if (CheckDate(from,'test'))
			{
			var fromarray; var toarray;var toarray1;
			var fromdate = from.value ;
			var todate   = to.value ;
			if(fromdate.length > 0 && todate.length > 0 ) {
					fromarray = todate.split("/");
					toarray = fromdate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt   = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)) {
						  var err_msg = getMessage('PREF_FM_DT_VALIDATION','OA');
						  alert(err_msg);
						  from.focus();
						return false;
					}                    
				
        else
		{

				if (to1.value!=null)
                    {
					var to1date= to1.value;
					fromarray   = fromdate.split("/");
					toarray     = to1date.split("/");
					var fromdt  = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt    = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) > Date.parse(fromdt)) {
						  var err_msg = getMessage('PRF_DATE_NOT_GR_CURR_DATE','Common');
						  err_msg=err_msg.replace("or equal to current date",getLable("Common.fromdate.label","common"));
						  alert(err_msg);
						  from.focus();
						return false;
					}
					}
        return true;
		}
		}
        else
		{
		from.focus();
		return false;
		}
		}
		else
		{
		from.focus();
		return false;
		}
		}
         }
	function clearFields(){
		var callingMode = document.forms[0].callingMode.value;
		
		if(callingMode == "OP" || callingMode == "OP_RV")
		{
			parent.frames[3].location.href='../../eCommon/html/blank.html';		
		
		}
		else
		{
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			
			var ca_md=parent.frames[1].document.forms[0].ca_mode.value
	 		//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 

			if(ca_md != '' ){
					top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
			}else{
				if(document.forms[0].callingMode.value=='RSCAPPT'){
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='
				}else{
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='
				}
			}
			
			
			//parent.frames[1].location.reload();
		}
	}

	function fillDays(Obj)
	{
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
	var u=parent.frames[1].document.forms[0].prefenddate1.value;
	var u1=parent.frames[1].document.forms[0].prefdate1.value;
	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/ServerValidation.jsp'><input type='hidden' name='to_date' id='to_date' value='"+u+"'><input type='hidden' name='from_date' id='from_date' value='"+u1+"'></form></BODY></HTML>";
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.form1.submit();
	
	}

	function block(Obj)
	{
	var b=Obj.value;

	if(parseInt(b) > 7)
		{
		parent.frames[1].document.forms[0].r_week.disabled=true;
		}
		else
		parent.frames[1].document.forms[0].r_week.disabled=false;
	}

	function check_date(Obj)
	{
		var flag=false;
		flag = CheckDate(Obj);
		if(flag)
		{
			var u1=Obj.value;
			if(u1!='')
			{
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';

				var u2= parent.frames[1].document.forms[0].hidden_from_date.value;
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/Validation.jsp'><input type='hidden' name='to_date' id='to_date' value='"+u1+"'><input type='hidden' name='from_date' id='from_date' value='"+u2+"'></form></BODY></HTML>";
				parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.frames[2].document.form1.submit();
			}
		}
	}



	function check_nextsch(obj){
	if(obj.checked==true){
	parent.frames[1].document.forms[0].prefenddate.value='';
	parent.frames[1].document.forms[0].prefenddate1.value='';
	parent.frames[1].document.forms[0].prefdate.value='';	
	parent.frames[1].document.forms[0].prefdate1.value='';	
	parent.frames[1].document.forms[0].no_dwm.value='';
	parent.frames[1].document.forms[0].no_dwm.disabled=true;
	parent.frames[1].document.forms[0].dwm_desc.value='';
	parent.frames[1].document.forms[0].dwm_desc.disabled=true;
	parent.result.document.location.href="../../eCommon/html/blank.html";
	}
	else{
	
	parent.frames[1].document.forms[0].no_dwm.value='';
	parent.frames[1].document.forms[0].no_dwm.disabled=false;
	parent.frames[1].document.forms[0].dwm_desc.value='';
	parent.frames[1].document.forms[0].dwm_desc.disabled=false;
	}
	
	
}



function calucalte_enddate(process){


if(parent.frames[1].document.forms[0].dwm_desc.value !=''){
		
		var param=parent.frames[1].document.forms[0].dwm_desc.value;

		var no=parent.frames[1].document.forms[0].no_dwm.value;
		if (no=='')
		{
		  no=0;
		}
		//if(parent.frames[1].document.forms[0].fromTracker.value=="OP" || parent.frames[1].document.forms[0].fromTracker.value=="OP_RV" || parent.frames[1].document.forms[0].fromTracker.value=="OR" || parent.frames[1].document.forms[0].fromTracker.value=="CA"){
		
		/*Above line commeneted and below line added for this incident SKR-SCF-1147 [IN:063469]*/
		
		if(parent.frames[1].document.forms[0].fromTracker.value=="OP_RV" || parent.frames[1].document.forms[0].fromTracker.value=="OR" ){
			
			strDate = parent.frames[1].document.forms[0].prefdate1.value;
			end_date=parent.frames[1].document.forms[0].prefenddate1.value;

			//var t1=parent.frames[1].document.forms[0].prefdate_curr.value;
			var t1_bud=convertDate(parent.frames[1].document.forms[0].prefdate_curr.value,"DMY","en",localeName);
			t1_bud=trimString(t1_bud);
			

			var t1= t1_bud;
				
				var t2=t1.substring(0,2);
				var t3=t1.substring(3,5);
				var t4=t1.substring(6);
				
				t1=t3+"/"+t2+"/"+t4
				
				var dt=new Date(t1);
				var frval=dt.valueOf();
				var frval1=dt.valueOf();


				var x;
				var temp;
				if(parent.frames[1].document.forms[0].dwm_desc.value=='D'){
					x=parent.frames[1].document.forms[0].no_dwm.value;
					if(x=='') x=0;
					temp=new Date(dt.setDate(parseInt(dt.getDate())+parseInt(x)));

				}else if(parent.frames[1].document.forms[0].dwm_desc.value=='W'){
					x=parent.frames[1].document.forms[0].no_dwm.value;
					if(x=='') x=0;
					x=parseInt(x)*7;
					temp=new Date(dt.setDate(parseInt(dt.getDate())+parseInt(x)));
					
				}else if(parent.frames[1].document.forms[0].dwm_desc.value=='M'){
					x=parent.frames[1].document.forms[0].no_dwm.value;
					if(x=='') x=0;
					
					temp=new Date(dt.setMonth(parseInt(dt.getMonth())+parseInt(x)));
					

				}

				
				
				t2=temp.getDate();
				if(t2<10) 
					t2="0"+t2;
				t3=temp.getMonth()+1;
				if(t3<10) 
					t3="0"+t3;
				t4=temp.getFullYear();
				parent.frames[1].document.forms[0].prefdate1.value=t2+"/"+t3+"/"+t4;

				
				var temp1=new Date(temp.setDate(parseInt(temp.getDate())+29));
				t2=temp1.getDate();
				if(t2<10) 
					t2="0"+t2;
				t3=temp1.getMonth()+1;
				if(t3<10) 
					t3="0"+t3;
				t4=temp1.getFullYear();
				parent.frames[1].document.forms[0].prefenddate1.value=t2+"/"+t3+"/"+t4;



		}else{
	
		 		//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 

			var ca_md=parent.frames[1].document.forms[0].ca_mode.value;
			var callingMode=document.forms[0].callingMode.value;
/*if(document.forms[0].callingMode.value =="OH")
{
ca_md="";
}  */
			if(ca_md != '' ){ 
			
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DatePopulation.jsp'><input type='hidden' name='param' id='param' value='"+param+"'><input type='hidden' name='callingMode' id='callingMode' value='"+callingMode+"'><input type='hidden' name='no' id='no' value='"+no+"'><input type='hidden' name='frmCa' id='frmCa' value='Y'></form></BODY></HTML>";
					top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					top.content.messageFrame.document.form1.submit();

			}else{
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DatePopulation.jsp'><input type='hidden' name='param' id='param' value='"+param+"'><input type='hidden' name='callingMode' id='callingMode' value='"+callingMode+"'><input type='hidden' name='no' id='no' value='"+no+"'><input type='hidden' name='frmCa' id='frmCa' value='N'></form></BODY></HTML>";
				parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.frames[2].document.form1.submit();

			}

			
			
		}

	
}
else
{
	
parent.frames[1].document.forms[0].prefenddate.value='';
parent.frames[1].document.forms[0].prefenddate1.value='';
parent.frames[1].document.forms[0].prefdate.value='';	
parent.frames[1].document.forms[0].prefdate1.value='';	
}

}



 /*On blur of prefdate1 text box focus goes to Prefenddate1 text box */
function focusprefenddate1(){
parent.frames[1].document.forms[0].prefenddate1.focus();
}
/* Obtaining focus of prefdate1 text box*/
function focusprefdate1(){

	parent.frames[1].document.forms[0].prefdate1.focus();
}

//Added to close the existing page 
/* This exitVal function is called on retun of present window. it retuns the cause of return. ie. which button viz. confirm,abort made this window closed.*/
function exitval(){
	var v=getLabel("Common.Abort.label","Common");
	//parent.window.returnValue=v;
	//parent.window.close();
	//let dialogBody = parent.parent.parent.document.getElementById('dialog-body');
	  let dialogBody = parent.parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = v;
    
    //const dialogTag =  parent.parent.parent.document.getElementById("dialog_tag");
    const dialogTag =  parent.parent.parent.document.getElementById("dialog_tag");
    dialogTag.close();   
}

/*onChange of clinic list box this function gets called. which clears the text boxes.*/
function enable_disp_next(Obj,obj2){ 
	var ObjVal=Obj.value;
	if(obj2 =="OA"){
		parent.frames[1].document.forms[0].practitioner.value = "";
		parent.frames[1].document.forms[0].practitioner_name.value = "";
	}else{
		document.forms[0].location_code1.value=ObjVal;
	}
	if(ObjVal==""){
		document.forms[0].resourceType_1.value="";
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	} 
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var clinic_type=parent.frames[1].document.forms[0].location_type.value;
	if(parent.frames[1].document.forms[0].speciality.value !=""){
		parent.frames[1].document.forms[0].disp_next.checked=true;
		parent.frames[1].document.forms[0].disp_next.disabled=false;
	}else{
		parent.frames[1].document.forms[0].disp_next.checked=false;
		parent.frames[1].document.forms[0].disp_next.disabled=true;
	}
	if(clinic_type!='C'){
		//document.forms[0].all.pract_type.innerHTML="&nbsp;";
	}
	if(obj2 =="OA"){
		if(ObjVal==''){
			document.forms[0].practitioner_name.value='';
			document.forms[0].practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
		}else{
			document.forms[0].practitioner_name.value='';
			document.forms[0].practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
		}
	}else{
		if(ObjVal==''){
			document.forms[0].practitioner_name.value='';
			document.forms[0].practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
		}else{
			//IF Else condition Added by S.Sathish for IN021901 on Friday, June 11, 2010
			if(document.forms[0].resourceType_2)
			if(document.forms[0].resourceType_2.value !='P'){			
			document.forms[0].practitioner_name.value=document.forms[0].tt_pract_name.value;
			document.forms[0].practitioner.value=document.forms[0].op_practitioner.value;
			document.forms[0].practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
			}else{
				document.forms[0].location_code1.value=document.forms[0].clinic.value;
			}			
		}
	}
		
	var clinic_type=document.forms[0].location_type.value;
	if(clinic_type == "Y")
		clinic_type = "D";
	var specialty=document.forms[0].speciality.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()

	xmlStr ="<root><SEARCH speciality=\""+specialty+"\" location=\""+ObjVal+"\" clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" steps='XXX' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	if(document.forms[0].resource_class.value !=""){
		document.forms[0].resourceType_1.value=document.forms[0].resource_class.value;
	}
	if(document.forms[0].rd_oa_integration_yn.value=="Y"){
		if(document.forms[0].rd_appt_yn.checked==true){
			document.forms[0].resourceType_1.disabled=true;
			document.forms[0].resourceType_1.value='E';//added by shanthi
			document.forms[0].resourceType_1.onchange();
		}
	}
    }

/*on Selection of speciality list box Display earliest Sch Check box is enabled and checked to true*/
function enaable_ear(Obj){
parent.frames[3].location.href="../../eCommon/html/blank.html";
	var specialty=document.forms[0].speciality.value;
	document.getElementById("specialty_code1").value = specialty;
	if(document.forms[0].callingMode.value=='OP_RV'){
		//document.forms[0].b_loc_search.disabled=true; 
		
		populateLocations(document.forms[0].location_type);
		//	fetchResult1();
	}else{
		document.forms[0].clinic.value="";
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc_val.disabled=true;
		document.forms[0].b_loc_search.disabled=true;
		document.forms[0].resourceType_1.value="";
		document.forms[0].location_type.selectedIndex=0;
		document.forms[0].location_type.disabled=false;//Added by S.Sathish for 20026 on Thursday, March 18, 2010
		document.forms[0].practitioner.value='';
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}
	if (Obj.value!=""){
	   parent.frames[1].document.forms[0].disp_next.checked=true;
	   parent.frames[1].document.forms[0].disp_next.disabled=false;
	   
	}else{
	   parent.frames[1].document.forms[0].disp_next.checked=false;
	   parent.frames[1].document.forms[0].disp_next.disabled=true;
	}
	if(document.forms[0].callingMode.value=='OR'){
		 document.forms[0].specialty_codema1.value=Obj.value;
	}

	if(document.forms[0].rd_oa_integration_yn.value=="Y"){
		if(document.forms[0].rd_appt_yn.checked){
			radRuleAppl(document.forms[0].rd_appt_yn)
		}
	}
}

function populateLocations(Obj){ 
	document.forms[0].resourceType_1.value=""; // Suresh M
	if(document.forms[0].location_type.value==""){
		document.forms[0].resourceType_1.value="";
		// document.forms[0].resourceType_1.disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}
	if(Obj.value==null||Obj.value==""){
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic.value="";
		document.getElementById("b_loc_val").disabled=true;
		document.getElementById("b_loc_search").disabled=true ;
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic.value="";
		document.getElementById("b_loc_val").disabled=false ;
		document.getElementById("b_loc_search").disabled=false ;
	}
	var speciality=document.forms[0].speciality.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" speciality=\""+speciality+"\"  steps='11' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) */
	if(Obj.value=='C'){
	}else{
		//document.getElementById("pract_type").innerHTML="&nbsp;";
		document.getElementById("practitioner").value='';
	}
	//document.getElementById("pract_type").innerHTML="&nbsp;";
	document.getElementById("practitioner").value='';
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner.value='';
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
}


function clear_vals(){
	if(document.forms[0].or_catalogue_desc.value==''){
		document.forms[0].or_catalogue_code.value='';
	}else{
		callORSearch();
	}
}

async function callORSearch(){
	//var dialogHeight= "29" ;
	//var dialogTop = "125" ;
	//var dialogWidth	= "50" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "900px" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var or_catalogue_desc=document.forms[0].or_catalogue_desc.value;	
	var clinic=document.forms[0].clinic.value;	
	var arr=clinic.split("$");
	var locnCode=arr[1];
	var rd_appt_yn = "N";
	if(document.forms[0].rd_oa_integration_yn.value=="Y"){	
		if(document.forms[0].rd_appt_yn.checked){			
			rd_appt_yn = "Y"
		}else{			
			rd_appt_yn = "N"
		}
	}
	var url="../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(or_catalogue_desc)+"&called_from=OA&mode="+MODE_INSERT+"&locnCode="+locnCode+"&rd_appt_yn="+rd_appt_yn+"&order_category=&order_type="
	
	var retVal = new String();
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal){
		var secArr=retVal.split("&");
		document.forms[0].or_catalogue_code.value=secArr[0];
		document.forms[0].or_catalogue_desc.value=secArr[1];
	}else{
		document.forms[0].or_catalogue_code.value='';
		document.forms[0].or_catalogue_desc.value='';
	}
}
function getValues(PractType){
    parent.frames[1].document.forms[0].practitioner.value="";
}

/*This function validates whether the given number in the no_dwn text box is valid number. if it is valid it calls calculat_enddate*/
function CheckNum(obj){
	var valid = 'T';
	var strCheck = '0123456789';
	if ( obj.value.length > 0 ) {
		for(var i=0;i<=obj.value.length;i++) {
			if (strCheck.indexOf(obj.value.charAt(i)) == -1){
				alert(getMessage("NUM_ALLOWED","SM"));
				valid='F';
				obj.select();
				obj.focus();
				return false;
				break;
			}
		}
	}
	if (valid=='T')
		calucalte_enddate(1);
}
/*this is called on load of the body tag. if calling mode value is equal to OP then fetchResult script function which is defined in validate.js is called. */
function disp_data()
{
	//The following code is moved from jsp and will fire only onLoad instead of sequntial execution in jsp
	if(document.forms[0].care_locn_ind.value !=''){
	}
	if(document.forms[0].from_wait_list.value =="Y" && document.forms[0].callingMode.value =="OP"){
		document.forms[0].speciality.value = document.forms[0].speclty_Cd.value;
		document.forms[0].speciality.disabled=true;
		document.forms[0].location_type.value = document.forms[0].care_locn_ind.value;
		document.forms[0].location_type.disabled=false;
		document.forms[0].clinic.disabled=false;
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
	}
	if(document.forms[0].callingMode.value == "OP" && document.forms[0].from_wait_list.value =="N"){
		document.forms[0].speciality.value=document.forms[0].speclty_Cd.value;
		document.forms[0].speciality.disabled=true;
		document.forms[0].disp_next.checked=true;
		if(document.forms[0].care_locn_ind.value !=''){
			document.forms[0].location_type.value = document.forms[0].care_locn_ind.value;
			document.forms[0].location_type.disabled=true;
		}
	}
	if(document.forms[0].callingMode.value =="OR" || document.forms[0].callingMode.value =="OH"){
		document.forms[0].or_catalogue_desc.value=document.forms[0].or_cat_desc.value;
		document.forms[0].or_catalogue_desc.disabled=true;
		if(document.forms[0].spe_or_value.value !=""){
			document.forms[0].speciality.value=document.forms[0].specialty_codema1.value;
			document.forms[0].disp_next.checked=true;
			document.forms[0].disp_next.disabled=true;
		}else{
			document.forms[0].disp_next.checked=false;
		}
		document.getElementById("frm_img").disabled=true;
		document.forms[0].prefdate1.disabled=true;
		document.forms[0].search_or.disabled=true;
		document.forms[0].search_pract.disabled=true;
		document.forms[0].practitioner_name.disabled=true;
		if(!document.forms[0].care_locn_ind.value ==""){
			document.forms[0].location_type.disabled=true;
		}
	}
	if(document.forms[0].callingMode.value =="MR") {
		document.forms[0].prefdate1.disabled=true;
		document.forms[0].prefenddate1.disabled=true;
		document.getElementById("frm_img").disabled=true;
		//document.getElementById("end").disabled=true;
		document.getElementById("dwm_desc").disabled=true;
		document.getElementById("no_dwm").disabled=true;
	}
	if(document.forms[0].from_page_new.value =="Pending_referral"){
		if(document.forms[0].speclty_Cd.value !="") {
			document.forms[0].speciality.value=document.forms[0].speclty_Cd.value;
			if(document.forms[0].speciality.value == ''){
				alert(getMessage("NO_CLINIC_AVAIL_BOOK","OA"));	
				history.go(-1);
			}else{
			document.forms[0].speciality.disabled=true;
			document.forms[0].disp_next.checked=true;
			}
		}else {
			document.forms[0].speciality.disabled=false;
			document.forms[0].disp_next.checked=false;
		}	
		if(document.forms[0].care_locn_ind.value !=""){
			document.forms[0].location_type.value=document.forms[0].care_locn_ind.value;
			document.forms[0].location_type.disabled=true;
		}else{
			document.forms[0].location_type.disabled=false;
		}
		//document.forms[0].prefdate1.disabled=true;
		//document.forms[0].prefenddate1.disabled=true;
	}
	if(document.forms[0].callingMode.value =="OP_RV") {
		if(document.forms[0].speclty_Cd.value !=""){
			document.forms[0].speciality.value=document.forms[0].speclty_Cd.value;
			document.forms[0].disp_next.checked=true;
			document.forms[0].disp_next.disabled=false;
		}else{
			document.forms[0].disp_next.checked=false;
		}
	}
	if (document.forms[0].clinic.value!=''){
		var obj=document.forms[0].clinic;
		enable_disp_next(obj,'NotOA');
	}
	//ends

	if(document.forms[0].callingMode.value=='OP' && document.forms[0].from_wait_list.value=="N")
	{
		if(document.forms[0].from_page_new.value =="")
		{
		if(document.forms[0].passed_clinic.value==''){ 
			populateLocations(document.forms[0].location_type)
		}else{
			document.forms[0].clinic.disabled=true;
		}
		
		document.forms[0].resourceType_1.disabled=true;
		//document.forms[0].practitioner_name.disabled=true;
		//document.forms[0].search_pract.disabled=true;
		
		/*
			above code is commented by Sudhakar for brunei changes to enable practitioner from op check out comeback
			Below code is added to enable resource and resource look up button in case of primary resource type for clinic is not practitioner
			By Sudhakar
		*/
		if(document.forms[0].primary_resource_class && document.forms[0].primary_resource_class.value!='P'){			
			document.forms[0].practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
			document.forms[0].practitioner.value='';
			document.forms[0].practitioner_name.value='';
		}
		
		}else
		{
			if(document.forms[0].passed_clinic.value==''){ 
			populateLocations(document.forms[0].location_type)
		}else{
			//document.forms[0].clinic.disabled=true;
		}
		}
		
		fetchResult1();
	}else {
		//If condition Added by S.Sathish for IN021901 on Friday, June 11, 2010 
		if(document.forms[0].resourceType_2){
		if(document.forms[0].resourceType_1.value=="" && document.forms[0].resourceType_2.value=="")
		{
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		}else
		{
			document.forms[0].practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
			}
		}else{
			document.forms[0].practitioner_name.disabled=true;
			document.forms[0].search_pract.disabled=true;
		}
		
	}
		if(document.forms[0].callingMode.value=='OR')
		{
			if(document.forms[0].passed_clinic.value==''){
				document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false; 
			populateLocations(document.forms[0].location_type)
		}else{

			document.forms[0].practitioner_name.disabled=false;
			document.forms[0].search_pract.disabled=false;
			//document.forms[0].clinic.disabled=true;
		}
		//fetchResult1();
		}else if(document.forms[0].callingMode.value=='OP_RV')
		{
			document.forms[0].location_type.disabled=false; 
			populateLocations(document.forms[0].location_type);
		}

		if(document.forms[0].module_id.value=='OA')
		{
			
			//document.forms[0].practitioner_name.disabled=false;
			//document.forms[0].search_pract.disabled=false;
			
			if(document.forms[0].dwm_desc_old.value !="")
			{
				var dwm_desc_old=document.forms[0].dwm_desc_old.value;
				document.forms[0].dwm_desc.value=dwm_desc_old;
			}
			
			if(document.forms[0].speciality.value !="")
			{
				document.forms[0].disp_next.disabled=false;
				document.forms[0].disp_next.checked=true;
			}else
			{
				document.forms[0].disp_next.disabled=true;
				document.forms[0].disp_next.checked=false;
			}

		}
		if(document.forms[0].rule_appl_yn.value == 'Y'){
			if(document.forms[0].patient_id && document.forms[0].patient_id.value!=''){				
				var from_page_new=document.forms[0].from_page_new.value
				var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_patient' id='rule_based_patient' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='rule_based_patient_val'><input type=hidden name='patient_id' id='patient_id' value='"+document.forms[0].patient_id.value+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'><input type=hidden name='callingMode' id='callingMode' value='"+document.forms[0].callingMode.value+"'></form></body></html>";
				document.forms[0].patient_id.disabled 	= true;
				document.forms[0].searchPatientButton.disabled= true;
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
				parent.messageFrame.document.rule_based_patient.submit();
			}else if(document.forms[0].from_wait_list.value == 'Y' &&document.forms[0].waitListNo.value!=''){
				var from_page_new=document.forms[0].from_page_new.value
				var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_patient' id='rule_based_patient' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='pop_wtlist_data'><input type=hidden name='waitListNo' id='waitListNo' value='"+document.forms[0].waitListNo.value+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'><input type=hidden name='callingMode' id='callingMode' value='"+document.forms[0].callingMode.value+"'></form></body></html>";
				document.forms[0].patient_id.disabled 	= true;
				document.forms[0].searchPatientButton.disabled= true;
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
				parent.messageFrame.document.rule_based_patient.submit();
			}
			// added by N Munisekhar on 04-May-2012 against [IN:039768]
			else if((document.forms[0].patient_id &&document.forms[0].patient_id.value=='') &&(document.forms[0].apptrefno.value!='')){		
				var from_page_new=document.forms[0].from_page_new.value
				var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_patient' id='rule_based_patient' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='rule_based_patient_val'><input type=hidden name='apptrefno' id='apptrefno' value='"+document.forms[0].apptrefno.value+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'><input type=hidden name='callingMode' id='callingMode' value='"+document.forms[0].callingMode.value+"'></form></body></html>";
				document.forms[0].patient_id.disabled 	= true;
				document.forms[0].searchPatientButton.disabled= true;
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
				parent.messageFrame.document.rule_based_patient.submit();
			}
		}
		if(document.forms[0].callingMode.value=='RSCAPPT'){
			fetchResult1();
		}

		if(document.forms[0].rd_oa_integration_yn.value=="Y"){			

			if(document.forms[0].rd_appt_yn.value=="Y"){
				document.forms[0].rd_appt_yn.checked=true;
				document.forms[0].rd_appt_yn.onclick();			
		    }
			
			if(document.forms[0].order_category.value=="RD" || (document.forms[0].callingMode.value=="OR" && document.forms[0].rd_appt_yn.value=="Y") ){
				document.forms[0].rd_appt_yn.checked=true;
				document.forms[0].rd_appt_yn.onclick();	
			}
			if(document.forms[0].callingMode.value=="RD"){
				document.forms[0].or_catalogue_desc.value=document.forms[0].or_cat_desc.value;
				document.forms[0].rd_appt_yn.disabled=true;
			}
	    }
		
}

async function showCreate()
{
	//var dialogHeight= "41" ;
	//var dialogTop = "75" ;
	//var dialogWidth	= "65" ;
	var dialogHeight= "500vh" ;
	var dialogTop = "0px" ;
	var dialogWidth	= "100vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var speciality_op=document.forms[0].speciality_op.value;
	var ca_patient_id=document.forms[0].ca_patient_id.value;
	var care_locn_ind=document.forms[0].care_locn_ind.value;
	var resource_class=document.forms[0].resource_class.value;
	var calling_mode=document.forms[0].callingMode.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;

	var i_clinic_code=document.forms[0].i_clinic_code.value;
	var op_practitioner=document.forms[0].op_practitioner.value;
	var callurl="../../eOA/jsp/ApptWaitList.jsp?'module_id=OA&function_id=APPT_WAIT_LIST&function_name=Create Appointment Wait List&function_type=F&menu_id=OA_TRANSACTIONS&access=NYNNN&home_required_yn=Y&from=ScheduleAppt&speciality_op="+speciality_op+"&ca_patient_id="+ca_patient_id+"&care_locn_ind="+care_locn_ind+"&resource_class="+resource_class+"&calling_mode="+calling_mode+"&i_clinic_code="+i_clinic_code+"&op_practitioner="+op_practitioner+"&oper_stn_id="+oper_stn_id;
	var retVal = new String();
	retVal = await window.showModalDialog(callurl,arguments,features);
	if(calling_mode =='OP'  || calling_mode =='OP_RV')
	{
			parent.window.close();
	
	}else
	{
		if(retVal='undefined')
		{
			
		top.content.frames[0].location.href = "../../eCommon/jsp/commonToolbar.jsp?function_name=Schedule Appointments &function_type=F&menu_id=OA_TRANSACTIONS&access=NNNNN";
			
		}
	}

}

function focuschk()
{ 
	var mode=document.forms[0].callingMode.value;
	if (mode!='OR' && mode!='OP' && mode!='CA' && mode!="OP_RV"){
		if(document.forms[0].speciality.disabled!=true)
		document.forms[0].speciality.focus();
	}
	if(document.forms[0].web_request_yn.value=="Y"){
		document.forms[0].resourceType_1.value="P";
		document.forms[0].practitioner.value=document.forms[0].direct_ip_practid.value;
		//alert(document.forms[0].direct_ip_practid.value)
	}

}

function callOR(objname)
{
var install_yn_val=document.forms[0].install_yn_val.value;
var url="../../eOA/jsp/DisplayPendingSchedule.jsp?install_yn_val="+install_yn_val;
parent.parent.frames[1].location.href=url;
}



/*********Date*******/


function DateCompare_from(obj2,obj)
{

var Sys_date = parent.frames[1].document.forms[0].prefdate_curr;
if(document.forms[0].tr_rule_applicable && document.forms[0].tr_rule_applicable.checked){	
		if(!validDateObj(obj,"DMY",localeName)){
			obj.value="";
			return ;
		}else{
			var obj1=convertDate(obj.value,"DMY",localeName,"en");
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}else{
				return true;
			}
		}
}else{


if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
}
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

function validate_date_from(from,to)
{
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
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
	if(document.forms[0].tr_rule_applicable && document.forms[0].tr_rule_applicable.checked){
		enableDisableBtns();
	}
}


function DateCompare_apply(from,to)
{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
						
				return false;
			}
			else
				return true;
		}

}


function fetchResult_new()
{
			strDate = parent.frames[1].document.forms[0].prefdate1.value;
			end_date=parent.frames[1].document.forms[0].prefenddate1.value;
			var tosubmit=true;
	
	if(strDate!="" && end_date!="")
	{
	var year_count=yearsBetween(strDate,end_date,'DMY',localeName);
	
		
	if(year_count >= 1)
				{
					
						var error = getMessage('SCH_GREATER_THAN_YEAR','OA');	
						alert(error);
						tosubmit=false;
				}else
				{
					tosubmit=true;
				}

}
}


function Disable_oprv()
{
	 var mode=document.forms[0].callingMode.value;
	if (mode=='OP_RV'){

		parent.frames[1].document.forms[0].no_dwm.disabled=true;
		parent.frames[1].document.forms[0].dwm_desc.disabled=true;
	}
}


function enable_dsiable_res(obj)
{

	var specialty=document.forms[0].speciality.value;
	document.getElementById("specialty_code1").value = specialty;
 var res_value=obj.value;
 if(res_value=="" )
	{

	 document.forms[0].practitioner_name.value="";
	 document.forms[0].practitioner.value="";
	 document.forms[0].practitioner_name.disabled=true;
	 document.forms[0].search_pract.disabled=true;
	}else{
	 document.forms[0].resourceType1.value=res_value;
	 //document.forms[0].resourceType_1.value=res_value;
	 if(document.forms[0].clinic.value=="")
		{
		  document.forms[0].location_code1.value="Y$";
		}
	 document.forms[0].practitioner_name.value="";
	 document.forms[0].practitioner.value="";
	 document.forms[0].practitioner_name.disabled=false;
	 document.forms[0].search_pract.disabled=false;
	}
}


function ena_loc_lookup(obj){	
	if(obj.value==null || obj.value==''){
		document.forms[0].b_loc_val.value="";
	    document.forms[0].clinic.value="";
		// Below Line Added Against BRF-PAS-Bru-HIMS-CRF-0135/01 ? OP Checkout - Book Appointment [IN:039854] 
		document.forms[0].practitioner_name.value="";
		// [IN:039854] over here
	  	if(parent.frames[1].document.forms[0].rd_oa_integration_yn.value=="Y"){	
			if(parent.frames[1].document.forms[0].rd_appt_yn.checked==false){
			document.forms[0].resourceType_1.value=""; // Suresh M
			}
		}
	    
	}else{
		open_loc_lookup()
	}
}
async function open_loc_lookup(){
    var location_val=document.forms[0].b_loc_val.value;

	var locn_type=document.forms[0].location_type.value;
	var care_locn_ind=document.forms[0].location_type.value;
	var speciality=document.forms[0].speciality.value;
	var rd_appt_yn = "N";
	if(document.forms[0].rd_oa_integration_yn.value=="Y"){
		 rd_appt_yn=document.forms[0].rd_appt_yn.value;
		if(rd_appt_yn=="") rd_appt_yn = "N";
	}
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
	var url = "../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&speciality_code="+speciality+"&rd_appt_yn="+rd_appt_yn+"&function_id=SCH_APPT";
	
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var loc = document.forms[0].clinic.value.split("$")	
		var code=loc[1];
		// Below If Condition Added Against BRF-PAS-Bru-HIMS-CRF-0135/01 ? OP Checkout - Book Appointment [IN:039854] 
		if(code != clinic_code){ 
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
        document.forms[0].b_loc_val.value=desc;
		document.forms[0].clinic.value=open_to_all_pract_yn+"$"+clinic_code;
		enable_disp_next(document.forms[0].clinic,'OA');}		
		if(document.forms[0].isAlertApplicableforBookAppt.value == "true") // added by mujafar for GHL-CRF-0527
		{ 
		  var facilityid =document.forms[0].facilityid.value; 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH locncode1=\""+clinic_code+"\"  facilityid=\""+facilityid+"\" locn_type1=\""+locn_type+"\" steps='get_popup_alert'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText=trimString(responseText);
		var data = responseText.split("~~");
		var alert_yn=data[0];
		var alert_msg=data[1];
		if(alert_yn == "Y")
		{ 
			if(confirm(alert_msg))
			{
				
			}
			else{
				document.forms[0].b_loc_val.value="";
				document.forms[0].clinic.value="";
				parent.frames[1].document.forms[0].resourceType_1.selectedIndex=0;
			}
		}
		}
	}else{	
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic.value="";		
		enable_disp_next(document.forms[0].clinic,'OA');
	}

}
function trimString(sInString) { // added by mujafar for GHL-CRF-0527
	return sInString.replace(/^\s+|\s+$/g, "");
}
//the below function is added for SRR-CRF-595 by Sudhakar
async function addtnl_splty(){
	var dialogTop = "60" ;
	var dialogHeight= "35.6" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	parent.frames[1].document.forms[0].addtl_splty.value="";
	parent.frames[1].document.forms[0].addtl_splty_text.value="";
	//var addtl_splty=parent.frames[1].document.forms[0].addtl_splty.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	//retVal = window.showModalDialog("../../eOA/jsp/OAAdditionalSpecialty.jsp?addtl_splty="+addtl_splty,arguments,features);
	retVal = await window.showModalDialog("../../eOA/jsp/OAAdditionalSpecialty.jsp",arguments,features);
	if(retVal!="" && retVal !=undefined){
		var retValArr=retVal.split("~");
		var descArr=retValArr[1].split("^");
		var desc="";
		if(descArr.length > 1){
			desc=descArr[0]+","+descArr[1];
		}else{
			desc=descArr;
		}
		parent.frames[1].document.forms[0].addtl_splty.value=retValArr[0];
		parent.frames[1].document.forms[0].addtl_splty_text.value=desc;
	}else{
		parent.frames[1].document.forms[0].addtl_splty.value="";
		parent.frames[1].document.forms[0].addtl_splty_text.value="";
	}
}

//Added for Rutnin CRF
function patqry() {
	var pat_id=PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.forms[0].patient_id.value=pat_id;
	if(pat_id!=""){
		var from_page_new=document.forms[0].from_page_new.value
		var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_patient' id='rule_based_patient' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='rule_based_patient_val'><input type=hidden name='patient_id' id='patient_id' value='"+pat_id+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'></form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
		parent.parent.messageFrame.document.rule_based_patient.submit();
	}
}

function searchPatient(obj,len){
	if(obj.value!=''){
		if((obj.value).length!=len){
			alert(getMessage('INVALID_PATIENT','MP'));
			if(document.schedule_appointment.name_prefix){
				document.schedule_appointment.name_prefix.value="";
				document.schedule_appointment.name_prefix.disabled=false;
			}
			if(document.schedule_appointment.first_name){
				document.schedule_appointment.first_name.value="";
				document.schedule_appointment.first_name.disabled=false;
			}
			if(document.schedule_appointment.second_name){
				document.schedule_appointment.second_name.value="";
				document.schedule_appointment.second_name.disabled=false;
			}
			if(document.schedule_appointment.third_name){
				document.schedule_appointment.third_name.value="";
				document.schedule_appointment.third_name.disabled=false;
			}
			if(document.schedule_appointment.family_name){
				document.schedule_appointment.family_name.value="";
				document.schedule_appointment.family_name.disabled=false;
			}
			if(document.schedule_appointment.name_suffix){
				document.schedule_appointment.name_suffix.value="";
				document.schedule_appointment.name_suffix.disabled=false;
			}
			
			if(document.schedule_appointment.name_prefix_oth_lang){
				document.schedule_appointment.name_prefix_oth_lang.value="";
				document.schedule_appointment.name_prefix_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.first_name_oth_lang){
				document.schedule_appointment.first_name_oth_lang.value="";
				document.schedule_appointment.first_name_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.second_name_oth_lang){
				document.schedule_appointment.second_name_oth_lang.value="";
				document.schedule_appointment.second_name_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.third_name_oth_lang){
				document.schedule_appointment.third_name_oth_lang.value="";
				document.schedule_appointment.third_name_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.family_name_oth_lang){
				document.schedule_appointment.family_name_oth_lang.value="";
				document.schedule_appointment.family_name_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.name_suffix_oth_lang){
				document.schedule_appointment.name_suffix_oth_lang.value="";
				document.schedule_appointment.name_suffix_oth_lang.disabled=false;
			}
			if(document.schedule_appointment.contact_no){
				document.schedule_appointment.contact_no.value="";
				document.schedule_appointment.contact_no.disabled=false;
				if(document.schedule_appointment.contact_no_gif)
					document.schedule_appointment.contact_no_gif.style.visibility='visible';
			}
			if(document.schedule_appointment.gender){
				document.schedule_appointment.gender.value="";
				document.schedule_appointment.gender.disabled=false;
			}
			if(document.schedule_appointment.nationality_desc){
				document.schedule_appointment.nationality_desc.value='';
				document.schedule_appointment.nationality_desc.disabled=false;
				document.schedule_appointment.nationality_button.disabled=false;
				document.schedule_appointment.nationality_code.value='';
			}
			if(document.schedule_appointment.language_desc){
				document.schedule_appointment.language_desc.value='';
				document.schedule_appointment.language_desc.disabled=false;
				document.schedule_appointment.language_button.disabled=false;
				document.schedule_appointment.language_code.value='';
			}
			obj.value="";
		}else{
			var from_page_new=document.forms[0].from_page_new.value;
			var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_patient' id='rule_based_patient' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='rule_based_patient_val'><input type=hidden name='patient_id' id='patient_id' value='"+obj.value+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'></form></body></html>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
			parent.parent.messageFrame.document.rule_based_patient.submit();
		}
	}else{
		if(document.schedule_appointment.first_name){
			document.schedule_appointment.first_name.value="";
			document.schedule_appointment.first_name.disabled=false;
		}
		if(document.schedule_appointment.second_name){
			document.schedule_appointment.second_name.value="";
			document.schedule_appointment.second_name.disabled=false;
		}
		if(document.schedule_appointment.third_name){
			document.schedule_appointment.third_name.value="";
			document.schedule_appointment.third_name.disabled=false;
		}
		if(document.schedule_appointment.family_name){
			document.schedule_appointment.family_name.value="";
			document.schedule_appointment.family_name.disabled=false;
		}
		if(document.schedule_appointment.contact_no){
			document.schedule_appointment.contact_no.value="";
			document.schedule_appointment.contact_no.disabled=false;
			if(document.schedule_appointment.contact_no_gif)
				document.schedule_appointment.contact_no_gif.style.visibility='visible';
		}
		if(document.schedule_appointment.gender){
			document.schedule_appointment.gender.value="";
			document.schedule_appointment.gender.disabled=false;
		}
		if(document.schedule_appointment.nationality_desc){
			document.schedule_appointment.nationality_desc.value='';
			document.schedule_appointment.nationality_desc.disabled=false;
			document.schedule_appointment.nationality_button.disabled=false;
			document.schedule_appointment.nationality_code.value='';
		}
		if(document.schedule_appointment.language_desc){
			document.schedule_appointment.language_desc.value='';
			document.schedule_appointment.language_desc.disabled=false;
			document.schedule_appointment.language_button.disabled=false;
			document.schedule_appointment.language_code.value='';
		}

	}
}
/* Commented by Nandhini to add getElementById
function CheckRule(obj,fromJsp){
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	if(obj.checked){
		document.forms[0].all.pref_per.innerHTML=getLabel("eOA.PreferredDateTime.label","OA");
		document.forms[0].all.date_of_expiry2_span.style.visibility="hidden";
		document.forms[0].all.date_of_expiry2_span.style.display="none";
		document.forms[0].all.timeID.style.visibility="visible";
		document.forms[0].all.From_timeval.value="";
		document.forms[0].all.To_timeval.value="";
		document.forms[0].all.prefdate1.value="";
		document.forms[0].all.prefenddate1.value="";
		if(document.forms[0].order_id.value !=""){
			document.forms[0].all.date_of_expiry.disabled = false;
			document.forms[0].all.frm_img.disabled = false;
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
		}
		if(document.forms[0].callingMode.value =='OP'){
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
		}else if(document.forms[0].callingMode.value == 'OP_RV'){
			document.forms[0].all.date_of_expiry.disabled = false;
			document.forms[0].all.frm_img.disabled = false;
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
			document.forms[0].all.date_of_expiry.disabled = true;
			document.forms[0].all.frm_img.disabled = true;
		} 
		document.forms[0].all.prevDateDiasbled.style.display="";
		document.forms[0].all.nextDateDiasbled.style.display="";
		document.forms[0].all.prevTimePlusDisabled.style.display="";
		document.forms[0].all.prevTimeMinusDisabled.style.display="";
		document.forms[0].all.nextTimePlusDisabled.style.display="";
		document.forms[0].all.nextTimeMinusDisabled.style.display=""; 
	}else{
		document.forms[0].all.pref_per.innerHTML=getLabel("Common.preferredperiod.label","Common");
		document.forms[0].all.date_of_expiry2_span.style.display="";
		document.forms[0].all.date_of_expiry2_span.style.visibility="visible";
		document.forms[0].all.timeID.style.visibility="hidden";
		document.forms[0].all.From_timeval.value="";
		document.forms[0].all.To_timeval.value="";
		if(fromJsp =="N"){
		}else{
			document.forms[0].all.prefdate1.value="";
			document.forms[0].all.prefenddate1.value="";
		}
		if(document.forms[0].order_id.value !=""){
			document.forms[0].all.date_of_expiry.disabled 	= true;
			document.forms[0].all.frm_img.disabled 			= true;
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
			document.forms[0].all.prefenddate1.value=document.forms[0].prefenddate.value;
		}
		if(document.forms[0].callingMode.value =='OP'){
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
			document.forms[0].all.prefenddate1.value=document.forms[0].prefenddate.value;
		}else if(document.forms[0].callingMode.value == 'OP_RV'){
			document.forms[0].all.date_of_expiry.disabled = false;
			document.forms[0].all.frm_img.disabled = false;
			document.forms[0].all.prefdate1.value=document.forms[0].prefdate.value;
			document.forms[0].all.date_of_expiry.disabled = true;
			document.forms[0].all.frm_img.disabled = true;
			document.forms[0].all.prefenddate1.value=document.forms[0].prefdate.value;
		}		
		document.forms[0].all.prevDateDiasbled.style.display="none";
		document.forms[0].all.prevDate.style.display="none";
		document.forms[0].all.nextDateDiasbled.style.display="none";
		document.forms[0].all.nextDate.style.display="none";
		document.forms[0].all.prevTimePlusDisabled.style.display="none";
		document.forms[0].all.prevTimePlus.style.display="none";
		document.forms[0].all.prevTimeMinusDisabled.style.display="none";
		document.forms[0].all.prevTimeMinus.style.display="none";
		document.forms[0].all.nextTimePlusDisabled.style.display="none";
		document.forms[0].all.nextTimePlus.style.display="None";
		document.forms[0].all.nextTimeMinusDisabled.style.display="none";
		document.forms[0].all.nextTimeMinus.style.display="none";
	}
}*/
function CheckRule(obj,fromJsp){
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	if(obj.checked){
		document.getElementById('pref_per').innerHTML=getLabel("eOA.PreferredDateTime.label","OA");
		document.getElementById('date_of_expiry2_span').style.visibility="hidden";
		document.getElementById('date_of_expiry2_span').style.display="none";
		document.getElementById('timeID').style.visibility="visible";
		document.getElementById('From_timeval').value="";
		document.getElementById('To_timeval').value="";
		document.getElementById('prefdate1').value="";
		document.getElementById('prefenddate1').value="";
		if(document.forms[0].order_id.value !=""){
			document.getElementById('date_of_expiry').disabled = false;
			document.getElementById('frm_img').disabled = false;
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
		}
		if(document.forms[0].callingMode.value =='OP'){
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
		}else if(document.forms[0].callingMode.value == 'OP_RV'){
			document.getElementById('date_of_expiry').disabled = false;
			document.getElementById('frm_img').disabled = false;
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
			document.getElementById('date_of_expiry').disabled = true;
			document.getElementById('frm_img').disabled = true;
		} 
		document.getElementById('prevDateDiasbled').style.display="";
		document.getElementById('nextDateDiasbled').style.display="";
		document.getElementById('prevTimePlusDisabled').style.display="";
		document.getElementById('prevTimeMinusDisabled').style.display="";
		document.getElementById('nextTimePlusDisabled').style.display="";
		document.getElementById('nextTimeMinusDisabled').style.display=""; 
	}else{
		document.getElementById('pref_per').innerHTML=getLabel("Common.preferredperiod.label","Common");
		document.getElementById('date_of_expiry2_span').style.display="";
		document.getElementById('date_of_expiry2_span').style.visibility="visible";
		document.getElementById('timeID').style.visibility="hidden";
		document.getElementById('From_timeval').value="";
		document.getElementById('To_timeval').value="";
		if(fromJsp =="N"){
		}else{
			document.getElementById('prefdate1').value="";
			document.getElementById('prefenddate1').value="";
		}
		if(document.forms[0].order_id.value !=""){
			document.getElementById('date_of_expiry').disabled 	= true;
			document.getElementById('frm_img').disabled 			= true;
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
			document.getElementById('prefenddate1').value=document.forms[0].prefenddate.value;
		}
		if(document.forms[0].callingMode.value =='OP'){
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
			document.getElementById('prefenddate1').value=document.forms[0].prefenddate.value;
		}else if(document.forms[0].callingMode.value == 'OP_RV'){
			document.getElementById('date_of_expiry').disabled = false;
			document.getElementById('frm_img').disabled = false;
			document.getElementById('prefdate1').value=document.forms[0].prefdate.value;
			document.getElementById('date_of_expiry').disabled = true;
			document.getElementById('frm_img').disabled = true;
			document.getElementById('prefenddate1').value=document.forms[0].prefdate.value;
		}		
		document.getElementById('prevDateDiasbled').style.display="none";
		document.getElementById('prevDate').style.display="none";
		document.getElementById('nextDateDiasbled').style.display="none";
		document.getElementById('nextDate').style.display="none";
		document.getElementById('prevTimePlusDisabled').style.display="none";
		document.getElementById('prevTimePlus').style.display="none";
		document.getElementById('prevTimeMinusDisabled').style.display="none";
		document.getElementById('prevTimeMinus').style.display="none";
		document.getElementById('nextTimePlusDisabled').style.display="none";
		document.getElementById('nextTimePlus').style.display="None";
		document.getElementById('nextTimeMinusDisabled').style.display="none";
		document.getElementById('nextTimeMinus').style.display="none";
	}
}
function formatTimePerPatient(obj){
	if (obj.value.length == 2){
		if (obj.value.substring(1,2) == ':'){
			obj.value = '0' + obj.value ;
		}
	}
	if (obj.value.length == 3){
		if (obj.value.substring(0,1) == ':'){
			obj.value = '00' + obj.value ;
		}
	}
}
function chkTime(time1){
	var retval=true;
	if( (time1.charAt(time1.length-1) )!=":"){
		var time1arr=new Array()
		time1arr=time1.split(":")
		if(time1arr.length==2){
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23){
				if(time1min>59){
					retval=false;
				}
			}else{
				retval=false;
			}
		}else{
			retval=false;
		}
	}else{
		retval=false;
	}
	return retval
}
function CheckTime(obj,valt){
	var timefield = obj;
	if (obj.value!=""){
		var timefield = obj;
		var val1;
		if(chkTime(obj.value) == false){
			alert(getMessage("INVALID_TIME_FMT","SM"));
			timefield.select();
			timefield.focus();
			return false;
		}else{
			// Added the below code for IN032011 by Suresh M on 27.03.2012
			//if(document.forms[0].all.From_timeval.value!="" && document.forms[0].all.To_timeval.value){	
			if(document.getElementById('From_timeval').value!="" && document.getElementById('To_timeval').value)
			{				
				var frmTime = Date.parse('27 Mar 2012 ' +document.forms[0].all.From_timeval.value);
				var toTime = Date.parse('27 Mar 2012 ' +document.forms[0].all.To_timeval.value);					 
				if(frmTime > toTime){				 
					alert(getMessage("FM_TIME_GR_TO_TIME","Common"));					 
					//document.forms[0].all.To_timeval.select();
					//document.forms[0].all.To_timeval.focus();
					document.getElementById('To_timeval').select();
					document.getElementById('To_timeval').focus();
				}		
			} // Ends
		}
	}else{
	}
	enableDisableBtns();
}

async function displayPatientDetails(){
	var patient_id="";
	var name_prefix="";
	var first_name="";
	var second_name="";
	var third_name="";
	var family_name="";
	var name_suffix="";
	var name_prefix_oth_lang="";
	var first_name_oth_lang="";
	var second_name_oth_lang="";
	var third_name_oth_lang="";
	var family_name_oth_lang="";
	var name_suffix_oth_lang="";
	var gender="";
	var contact_no="";
	var nationality="";
	var language="";

	if(document.forms[0].patient_id)
		patient_id=document.forms[0].patient_id.value;
	if(document.forms[0].name_prefix)
		name_prefix=encodeURIComponent(document.forms[0].name_prefix.value,"UTF-8");		
	if(document.forms[0].first_name)
		first_name=encodeURIComponent(document.forms[0].first_name.value,"UTF-8");		
	if(document.forms[0].second_name)
		second_name=encodeURIComponent(document.forms[0].second_name.value,"UTF-8");		
	if(document.forms[0].third_name)
		third_name=encodeURIComponent(document.forms[0].third_name.value,"UTF-8");		
	if(document.forms[0].family_name)
	   family_name=encodeURIComponent(document.forms[0].family_name.value,"UTF-8");
	if(document.forms[0].name_suffix)
		name_suffix=encodeURIComponent(document.forms[0].name_suffix.value,"UTF-8");
		
	if(document.forms[0].name_prefix_oth_lang)
		name_prefix_oth_lang=encodeURIComponent(document.forms[0].name_prefix_oth_lang.value,"UTF-8");		
	if(document.forms[0].first_name_oth_lang)
		first_name_oth_lang=encodeURIComponent(document.forms[0].first_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].second_name_oth_lang)
		second_name_oth_lang=encodeURIComponent(document.forms[0].second_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].third_name_oth_lang)
		third_name_oth_lang=encodeURIComponent(document.forms[0].third_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].family_name_oth_lang)
	   family_name_oth_lang=encodeURIComponent(document.forms[0].family_name_oth_lang.value,"UTF-8");
	if(document.forms[0].name_suffix_oth_lang)
		name_suffix_oth_lang=encodeURIComponent(document.forms[0].name_suffix_oth_lang.value,"UTF-8"); 
	gender=document.forms[0].gender.value;	
	contact_no=document.forms[0].contact_no.value;	
	nationality=document.forms[0].nationality_code.value;	
	language=document.forms[0].language_code.value;	
	var i=0;
	var fields = new Array ();
	var names = new Array ();
	var engNamesMandCount=0;
	var engNamesFilCount=0;
	//encodeURIComponent(tit,"UTF-8")
	if(document.forms[0].name_prefix){
		if(document.forms[0].name_prefix_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].name_prefix;			
			names[i]=document.forms[0].name_prefix_prompt.value;
			i++;
			if(document.forms[0].name_prefix.value==''){
				engNamesFilCount++;
			}
		}
	}
	if(document.forms[0].first_name){
		if(document.forms[0].first_name_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].first_name;			
			names[i]=document.forms[0].firstnameprompt.value;
			i++;
			if(document.forms[0].first_name.value==''){
				engNamesFilCount++;
			}
		}
	}
	if(document.forms[0].second_name){
		if(document.forms[0].second_name_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].second_name;			
			names[i]=document.forms[0].secondnameprompt.value;
			i++;
			if(document.forms[0].second_name.value==''){
				engNamesFilCount++;
			}
		}
	}
	if(document.forms[0].third_name){
		if(document.forms[0].third_name_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].third_name;			
			names[i]=document.forms[0].thirdnameprompt.value;
			i++;
			if(document.forms[0].third_name.value==''){
				engNamesFilCount++;
			}
		}
	}
	if(document.forms[0].family_name){
		if(document.forms[0].family_name_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].family_name;			
			names[i]=document.forms[0].familynameprompt.value;
			i++;
			if(document.forms[0].family_name.value==''){
				engNamesFilCount++;
			}
		}
	}
	if(document.forms[0].name_suffix){
		if(document.forms[0].name_suffix_reqd_yn.value=='Y'){
			fields[i]=document.forms[0].name_suffix;			
			names[i]=document.forms[0].name_suffix_prompt.value;
			i++;
			if(document.forms[0].name_suffix.value==''){
				engNamesFilCount++;
			}
		}
	}
	engNamesMandCount=i;
	//alert('engNamesMandCount:'+engNamesMandCount)
	//alert('engNamesFilCount:'+engNamesFilCount)
	if(document.forms[0].names_in_oth_lang_yn.value=='Y'){	
		if(document.forms[0].name_prefix_oth_lang){
			if(document.forms[0].name_prefix_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].name_prefix_oth_lang;			
				names[i]=document.forms[0].name_prefix_oth_lang_prompt.value;
				i++;
				if(document.forms[0].name_prefix.value==''){
					engNamesFilCount++;
				}
			}
		}
		if(document.forms[0].first_name_oth_lang){
			if(document.forms[0].first_name_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].first_name_oth_lang;			
				names[i]=document.forms[0].first_name_oth_lang_prompt.value;
				i++;
				if(document.forms[0].first_name_oth_lang.value==''){
					engNamesFilCount++;
				}
			}
		}
		if(document.forms[0].second_name_oth_lang){
			if(document.forms[0].second_name_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].second_name_oth_lang;			
				names[i]=document.forms[0].second_name_oth_lang_prompt.value;
				i++;
				if(document.forms[0].second_name.value==''){
					engNamesFilCount++;
				}
			}
		}
		if(document.forms[0].third_name_oth_lang){
			if(document.forms[0].third_name_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].third_name_oth_lang;			
				names[i]=document.forms[0].third_name_oth_lang_prompt.value;
				i++;
				if(document.forms[0].third_name.value==''){
					engNamesFilCount++;
				}
			}
		}
		if(document.forms[0].family_name_oth_lang){
			if(document.forms[0].family_name_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].family_name_oth_lang;			
				names[i]=document.forms[0].family_name_oth_lang_prompt.value;
				i++;
				if(document.forms[0].family_name.value==''){
					engNamesFilCount++;
				}
			}
		}
		if(document.forms[0].name_suffix_oth_lang){
			if(document.forms[0].name_suffix_reqd_yn.value=='Y'){
				fields[i]=document.forms[0].name_suffix_oth_lang;			
				names[i]=document.forms[0].name_suffix_oth_lang_prompt.value;
				i++;
				if(document.forms[0].name_suffix.value==''){
					engNamesFilCount++;
				}
			}
		}
	}
	if(engNamesFilCount!=0 && engNamesMandCount!=engNamesFilCount){
		//alert('check')
		if(document.forms[0].names_in_oth_lang_yn.value=='Y'){
		}
	}
	if(patient_id ==''){
		fields[i]=document.forms[0].gender;	
		names[i]=getLabel("Common.gender.label","Common");	
		i++;		
	}
	if(document.forms[0].mob_num_req_yn.value=='Y'){
		fields[i]=document.forms[0].contact_no;	
		names[i]=getLabel("Common.MobileNo.label","Common");
		i++;
	}
	 if(document.forms[0].lang_mand){
		 if (document.forms[0].language_code != null )
		 if(document.forms[0].language_code.value==''){
			fields[i]=document.forms[0].language_code;			
			names[i]=getLabel("Common.Language.label","Common");
			i++;
		 }
	 }
	var checkFlag = true;
	if(document.forms[0].callingMode.value =='' && document.forms[0].from_page_new.value == '' && document.forms[0].calledFrom.value ==''){
		checkFlag =checkFields (fields, names, parent.parent.frames[2]);
	}else if(document.forms[0].callingMode.value =='' && document.forms[0].from_page_new.value == 'Pending_referral' && document.forms[0].calledFrom.value ==''){
		checkFlag =checkFields (fields, names, parent.parent.frames[2]);
	}else if(document.forms[0].callingMode.value =='OR' && document.forms[0].from_page_new.value == '' && document.forms[0].calledFrom.value =='OR'){
		checkFlag =checkFields (fields, names, parent.parent.frames[2]);
	}else{
		checkFlag =checkFields1 (fields, names);
	}	 
	if(checkFlag){
			//parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num=';
			var per_chk_cancld_past_appts = document.forms[0].per_chk_cancld_past_appts.value;
			var per_chk_cancld_fut_appts = document.forms[0].per_chk_cancld_fut_appts.value;
			var per_chk_past_resch_appts = document.forms[0].per_chk_past_resch_appts.value;
			var per_chk_fut_resch_appts =document.forms[0]. per_chk_fut_resch_appts.value;
			var no_of_cancld_appts_for_alert = document.forms[0].no_of_cancld_appts_for_alert.value;
			var no_of_resch_appts_for_alert = document.forms[0].no_of_resch_appts_for_alert.value;
			var per_chk_for_no_show_alert = document.forms[0].per_chk_for_no_show_alert.value;
			var no_of_noshow_appts_for_alert = document.forms[0].no_of_noshow_appts_for_alert.value;
			var no_of_fut_appts_for_alert = document.forms[0].no_of_fut_appts_for_alert.value;
			var per_chk_for_fut_appts_alert = document.forms[0].per_chk_for_fut_appts_alert.value;
			

			var retVal = 	new String();
			var dialogHeight= "25" ;
			var dialogWidth	= "50" ;
			var status = "no";
			var dialogTop = "265" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status+"; dialogTop :" + dialogTop ;
			var arguments	= "" ;
			var url="../../eOA/jsp/OAPatApptHistoryMain.jsp?patient_id="+patient_id+"&name_prefix="+name_prefix+"&first_name="+first_name+"&second_name="+second_name+"&third_name="+third_name+"&family_name="+family_name+"&name_suffix="+name_suffix+"&name_prefix_oth_lang="+name_prefix_oth_lang+"&first_name_oth_lang="+first_name_oth_lang+"&second_name_oth_lang="+second_name_oth_lang+"&third_name_oth_lang="+third_name_oth_lang+"&family_name_oth_lang="+family_name_oth_lang+"&name_suffix_oth_lang="+name_suffix_oth_lang+"&gender="+gender+"&contact_no="+contact_no+"&nationality="+nationality+"&language="+language+"&no_of_fut_appts_for_alert="+no_of_fut_appts_for_alert+"&per_chk_for_fut_appts_alert="+per_chk_for_fut_appts_alert+"&no_of_resch_appts_for_alert="+no_of_resch_appts_for_alert+"&per_chk_past_resch_appts="+per_chk_past_resch_appts+"&per_chk_fut_resch_appts="+per_chk_fut_resch_appts+"&no_of_cancld_appts_for_alert="+no_of_cancld_appts_for_alert+"&per_chk_cancld_past_appts="+per_chk_cancld_past_appts+"&per_chk_cancld_fut_appts="+per_chk_cancld_fut_appts+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert;
			retVal = await window.showModalDialog(url,arguments,features);	
			if(retVal=='OKPATID' || retVal==undefined){
			}else if(retVal=='CANCEL'){
				clearValues();		
			}else{
				var retArr = retVal.split("!");
				var count=0;
				name_prefix=retArr[count++];
				if(document.forms[0].name_prefix){
					document.forms[0].name_prefix.value=name_prefix;
				}else{
					name_prefix="";
				}
				first_name=retArr[count++];
				if(document.forms[0].name_prefix){
					document.forms[0].first_name.value=first_name;
				}else{
					first_name="";
				}
				second_name=retArr[count++];
				if(document.forms[0].second_name){
					document.forms[0].second_name.value=second_name;
				}else{
					second_name="";
				}
				third_name=retArr[count++];
				if(document.forms[0].third_name){
					document.forms[0].third_name.value=third_name;
				}else{
					third_name="";
				}
				family_name=retArr[count++];
				if(document.forms[0].family_name){
					document.forms[0].family_name.value=family_name;
				}else{
					family_name="";
				}
				name_suffix=retArr[count++];
				if(document.forms[0].name_suffix){
					document.forms[0].name_suffix.value=name_suffix;
				}else{
					name_suffix="";
				}				
				name_prefix_oth_lang=retArr[count++];
				if(document.forms[0].name_prefix_oth_lang){
					document.forms[0].name_prefix_oth_lang.value=name_prefix_oth_lang;
				}else{
					name_prefix_oth_lang="";
				}
				first_name_oth_lang=retArr[count++];
				if(document.forms[0].first_name_oth_lang){
					document.forms[0].first_name_oth_lang.value=first_name_oth_lang;
				}else{
					first_name_oth_lang="";
				}
				second_name_oth_lang=retArr[count++];
				if(document.forms[0].second_name_oth_lang){
					document.forms[0].second_name_oth_lang.value=second_name_oth_lang;
				}else{
					second_name_oth_lang="";
				}
				third_name_oth_lang=retArr[count++];
				if(document.forms[0].third_name_oth_lang){
					document.forms[0].third_name_oth_lang.value=third_name_oth_lang;
				}else{
					third_name_oth_lang="";
				}
				family_name_oth_lang=retArr[count++];
				if(document.forms[0].family_name_oth_lang){
					document.forms[0].family_name_oth_lang.value=family_name_oth_lang;
				}else{
					family_name_oth_lang="";
				}
				name_suffix_oth_lang=retArr[count++];
				if(document.forms[0].name_suffix_oth_lang){
					document.forms[0].name_suffix_oth_lang.value=name_suffix_oth_lang;
				}else{
					name_suffix_oth_lang="";
				}				
			}
	}
	
}

function ShowHistory(calledfor,patient_id,first_name,second_name,third_name,family_name,gender,contact_no){	
	
	var per_chk_cancld_past_appts = document.forms[0].per_chk_cancld_past_appts.value;
	var per_chk_cancld_fut_appts = document.forms[0].per_chk_cancld_fut_appts.value;
	var per_chk_past_resch_appts = document.forms[0].per_chk_past_resch_appts.value;
	var per_chk_fut_resch_appts =document.forms[0]. per_chk_fut_resch_appts.value;
	var no_of_cancld_appts_for_alert = document.forms[0].no_of_cancld_appts_for_alert.value;
	var no_of_resch_appts_for_alert = document.forms[0].no_of_resch_appts_for_alert.value;
	var per_chk_for_no_show_alert = document.forms[0].per_chk_for_no_show_alert.value;
	var no_of_noshow_appts_for_alert = document.forms[0].no_of_noshow_appts_for_alert.value;
	var no_of_fut_appts_for_alert = document.forms[0].no_of_fut_appts_for_alert.value;
	var per_chk_for_fut_appts_alert = document.forms[0].per_chk_for_fut_appts_alert.value;

	var name_prefix="";
	var name_suffix="";
	var name_prefix_oth_lang="";
	var first_name_oth_lang="";
	var second_name_oth_lang="";
	var third_name_oth_lang="";
	var family_name_oth_lang="";
	var name_suffix_oth_lang="";
	
	if(document.forms[0].name_prefix)
		name_prefix=encodeURIComponent(document.forms[0].name_prefix.value,"UTF-8");
	if(document.forms[0].name_suffix)
		name_suffix=encodeURIComponent(document.forms[0].name_suffix.value,"UTF-8");	
	if(document.forms[0].name_prefix_oth_lang)
		name_prefix_oth_lang=encodeURIComponent(document.forms[0].name_prefix_oth_lang.value,"UTF-8");		
	if(document.forms[0].first_name_oth_lang)
		first_name_oth_lang=encodeURIComponent(document.forms[0].first_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].second_name_oth_lang)
		second_name_oth_lang=encodeURIComponent(document.forms[0].second_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].third_name_oth_lang)
		third_name_oth_lang=encodeURIComponent(document.forms[0].third_name_oth_lang.value,"UTF-8");		
	if(document.forms[0].family_name_oth_lang)
	   family_name_oth_lang=encodeURIComponent(document.forms[0].family_name_oth_lang.value,"UTF-8");
	if(document.forms[0].name_suffix_oth_lang)
		name_suffix_oth_lang=encodeURIComponent(document.forms[0].name_suffix_oth_lang.value,"UTF-8");	


	if(calledfor == 'Noshow'){		
		parent.frames[2].location.href='../../eOA/jsp/OAPatApptHistory.jsp?patient_id='+patient_id+'&name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&display=Noshow&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert;
	}else if(calledfor == 'Reschedule'){
		parent.frames[2].location.href='../../eOA/jsp/OAPatApptHistory.jsp?patient_id='+patient_id+'&name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&display=Reschedule&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert;
	}else if(calledfor == 'Future'){
		parent.frames[2].location.href='../../eOA/jsp/OAPatApptHistory.jsp?patient_id='+patient_id+'&name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&display=Future&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert;

	}else if(calledfor == 'Cancel'){	
	/* Modified by munisekhar on 23-10-12 against Incident Number IN35852*/
	  parent.frames[2].location.href='../../eOA/jsp/OAPatApptHistory.jsp?patient_id='+patient_id+'&name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&display=Cancel&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert+"&name_prefix="+escape(document.forms[0].name_prefix.value);
	
      /* Commented by munisekhar on 23-10-12 for incident IN35852 */	
		//parent.frames[2].location.href='../../eOA/jsp/OAPatApptHistory.jsp?patient_id='+patient_id+'&name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&patient_name='+patient_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&display=Cancel&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert+"&name_prefix="+escape(document.forms[0].name_prefix.value);
	}
}

function ShowSummary(gender,contact_no,patient_name,row_no){
		var name_prefix="";
		var first_nam="";
		var second_name="";
		var third_name="";
		var family_name="";
		var name_suffix="";
		var name_prefix_oth_lang="";
		var first_name_oth_lang="";
		var second_name_oth_lang="";
		var third_name_oth_lang="";
		var family_name_oth_lang="";
		var name_suffix_oth_lang="";
		var no_of_fut_appts_for_alert = document.forms[0].no_of_fut_appts_for_alert.value;
		var per_chk_for_fut_appts_alert = document.forms[0].per_chk_for_fut_appts_alert.value;
		var no_of_resch_appts_for_alert = document.forms[0].no_of_resch_appts_for_alert.value;
		var per_chk_past_resch_appts = document.forms[0].per_chk_past_resch_appts.value;
		var per_chk_fut_resch_appts =document.forms[0]. per_chk_fut_resch_appts.value;
		var no_of_cancld_appts_for_alert = document.forms[0].no_of_cancld_appts_for_alert.value;
		var per_chk_cancld_past_appts = document.forms[0].per_chk_cancld_past_appts.value;
		var per_chk_cancld_fut_appts = document.forms[0].per_chk_cancld_fut_appts.value;		
		var per_chk_for_no_show_alert = document.forms[0].per_chk_for_no_show_alert.value;
		var no_of_noshow_appts_for_alert = document.forms[0].no_of_noshow_appts_for_alert.value;
		
		if(eval(document.getElementById('name_prefix'+row_no)))
			name_prefix=encodeURIComponent(eval(document.getElementById('name_prefix'+row_no)).innerText);
		if(eval(document.getElementById('first_name'+row_no)))
			first_name=encodeURIComponent(eval(document.getElementById('first_name'+row_no)).innerText);
		if(eval(document.getElementById('second_name'+row_no)))
			second_name=encodeURIComponent(eval(document.getElementById('second_name'+row_no)).innerText);
		if(eval(document.getElementById('third_name'+row_no)))
			third_name=encodeURIComponent(eval(document.getElementById('third_name'+row_no)).innerText);
		if(eval(document.getElementById('family_name'+row_no)))
			family_name=encodeURIComponent(eval(document.getElementById('family_name'+row_no)).innerText);
		if(eval(document.getElementById('name_suffix'+row_no)))
			name_suffix=encodeURIComponent(eval(document.getElementById('name_suffix'+row_no)).innerText);
		if(eval(document.getElementById('name_prefix_oth_lang'+row_no)))
			name_prefix_oth_lang=encodeURIComponent(eval(document.getElementById('name_prefix_oth_lang'+row_no)).innerText);
		if(eval(document.getElementById('first_name_oth_lang'+row_no)))
			first_name_oth_lang=encodeURIComponent(eval(document.getElementById('first_name_oth_lang'+row_no)).innerText);
		if(eval(document.getElementById('second_name_oth_lang'+row_no)))
			second_name_oth_lang=encodeURIComponent(eval(document.getElementById('second_name_oth_lang'+row_no)).innerText);
		if(eval(document.getElementById('third_name_oth_lang'+row_no)))
			third_name_oth_lang=encodeURIComponent(eval(document.getElementById('third_name_oth_lang'+row_no)).innerText);
		if(eval(document.getElementById('family_name_oth_lang'+row_no)))
			family_name_oth_lang=encodeURIComponent(eval(document.getElementById('family_name_oth_lang'+row_no)).innerText);
		if(eval(document.getElementById('name_suffix_oth_lang'+row_no)))
			name_suffix_oth_lang=encodeURIComponent(eval(document.getElementById('name_suffix_oth_lang'+row_no)).innerText);
		var max_no_of_records = document.forms[0].max_no_of_records.value;			
		for(i=1;i<=max_no_of_records;i++){
			eval(document.getElementById('Summary_row'+i)).style.backgroundColor='';		
		}		
		eval(document.getElementById('Summary_row'+row_no)).style.backgroundColor='#FFFFCC';		

		var url = '../../eOA/jsp/OAPatApptSummary.jsp?name_prefix='+name_prefix+'&first_name='+first_name+'&second_name='+second_name+'&patient_name='+patient_name+'&third_name='+third_name+'&family_name='+family_name+'&name_suffix='+name_suffix+'&name_prefix_oth_lang='+name_prefix_oth_lang+'&first_name_oth_lang='+first_name_oth_lang+'&second_name_oth_lang='+second_name_oth_lang+'&third_name_oth_lang='+third_name_oth_lang+'&family_name_oth_lang='+family_name_oth_lang+'&name_suffix_oth_lang='+name_suffix_oth_lang+'&gender='+gender+'&contact_no='+contact_no+'&no_of_fut_appts_for_alert='+no_of_fut_appts_for_alert+'&per_chk_for_fut_appts_alert='+per_chk_for_fut_appts_alert+'&no_of_resch_appts_for_alert='+no_of_resch_appts_for_alert+'&per_chk_past_resch_appts='+per_chk_past_resch_appts+'&per_chk_fut_resch_appts='+per_chk_fut_resch_appts+'&no_of_cancld_appts_for_alert='+no_of_cancld_appts_for_alert+'&per_chk_cancld_past_appts='+per_chk_cancld_past_appts+'&per_chk_cancld_fut_appts='+per_chk_cancld_fut_appts+'&no_of_noshow_appts_for_alert='+no_of_noshow_appts_for_alert+'&per_chk_for_no_show_alert='+per_chk_for_no_show_alert;
		parent.frames[2].location.href='../../eCommon/html/blank.html';	
		parent.frames[1].location.href=url;	
}

async function get_Nationality(target)
{	
		if(target.value != ""){
			var facilityid=document.forms[0].facilityid.value;
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit=getLabel("Common.nationality.label","Common");		    

			sql = "select country_code code, long_desc description from mp_country_lang_vw where eff_status = 'E'	and  upper(long_desc) like upper(?) and upper(country_code) like upper(?) and language_id='"+localeName+"'";	       
			
			argumentArray[0] =sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "2,1";    
			argumentArray[5] = document.forms[0].nationality_desc.value;		
			argumentArray[6] = DESC_LINK  ;
			argumentArray[7] = DESC_CODE ;
			retVal = await CommonLookup( tit, argumentArray );
			var arr=new Array();

			if(retVal != null && retVal != "" )
			{
				var retVal=unescape(retVal);			
				 arr=retVal.split(",");			 
				 document.forms[0].nationality_desc.value=arr[1];
				 document.forms[0].nationality_code.value=arr[0];					
			}
			else
			{
				document.forms[0].nationality_desc.value='';
				document.forms[0].nationality_code.value=''	;		
			}
		}else{
			document.forms[0].nationality_desc.value='';
			document.forms[0].nationality_code.value='';
		}

}
async function searchLanguage(target)
{
	if(target.value != ""){
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;	
		var tit=getLabel("Common.Language.label","Common");

		sql="Select MP_LANGUAGE_ID code,LONG_DESC description from MP_LANGUAGE_LANG_VW where  eff_status='E' and  upper(LONG_DESC) like upper(?) and upper(LANGUAGE_ID) like upper(?) and language_id='"+localeName+"' order by 2";

		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = document.forms[0].language_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;

		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].language_desc.value=arr[1];
			 document.forms[0].language_code.value=arr[0];			
		}
		else{
			document.forms[0].language_desc.value='';
			document.forms[0].language_code.value='';
		}
	}else{
		document.forms[0].language_desc.value='';
		document.forms[0].language_code.value='';
	}
}

function clearValues(){		
	if(!document.forms[0].patient_id.disabled){
		document.schedule_appointment.patient_id.value="";
		if(document.schedule_appointment.name_prefix){
			document.schedule_appointment.name_prefix.value="";
			document.schedule_appointment.name_prefix.disabled=false;
		}
		if(document.schedule_appointment.first_name){
			document.schedule_appointment.first_name.value="";
			document.schedule_appointment.first_name.disabled=false;
		}
		if(document.schedule_appointment.second_name){
			document.schedule_appointment.second_name.value="";
			document.schedule_appointment.second_name.disabled=false;
		}
		if(document.schedule_appointment.third_name){
			document.schedule_appointment.third_name.value="";
			document.schedule_appointment.third_name.disabled=false;
		}
		if(document.schedule_appointment.family_name){
			document.schedule_appointment.family_name.value="";
			document.schedule_appointment.family_name.disabled=false;
		}
		if(document.schedule_appointment.name_suffix){
			document.schedule_appointment.name_suffix.value="";
			document.schedule_appointment.name_suffix.disabled=false;
		}
		if(document.schedule_appointment.name_prefix_oth_lang){
			document.schedule_appointment.name_prefix_oth_lang.value="";
			document.schedule_appointment.name_prefix_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.first_name_oth_lang){
			document.schedule_appointment.first_name_oth_lang.value="";
			document.schedule_appointment.first_name_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.second_name_oth_lang){
			document.schedule_appointment.second_name_oth_lang.value="";
			document.schedule_appointment.second_name_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.third_name_oth_lang){
			document.schedule_appointment.third_name_oth_lang.value="";
			document.schedule_appointment.third_name_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.family_name_oth_lang){
			document.schedule_appointment.family_name_oth_lang.value="";
			document.schedule_appointment.family_name_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.name_suffix_oth_lang){
			document.schedule_appointment.name_suffix_oth_lang.value="";
			document.schedule_appointment.name_suffix_oth_lang.disabled=false;
		}
		if(document.schedule_appointment.contact_no){
			document.schedule_appointment.contact_no.value="";
			document.schedule_appointment.contact_no.disabled=false;
			if(document.schedule_appointment.contact_no_gif)
				document.schedule_appointment.contact_no_gif.style.visibility='visible';
		}
		if(document.schedule_appointment.gender){
			document.schedule_appointment.gender.value="";
			document.schedule_appointment.gender.disabled=false;
		}
		if(document.schedule_appointment.nationality_desc){
			document.schedule_appointment.nationality_desc.value='';
			document.schedule_appointment.nationality_desc.disabled=false;
			document.schedule_appointment.nationality_button.disabled=false;
			document.schedule_appointment.nationality_code.value='';
		}
		if(document.schedule_appointment.language_desc){
			document.schedule_appointment.language_desc.value='';
			document.schedule_appointment.language_desc.disabled=false;
			document.schedule_appointment.language_button.disabled=false;
			document.schedule_appointment.language_code.value='';
		}
	}
}


async function getProcedurecode(linking_desc,linking_code){
		var formObj=document.schedule_appointment;
		/*if(formObj.term_set_id.value==""){
			var err_msg=getMessage('CAN_NOT_BE_BLANK','Comman');
			err_msg=err_msg.replace("$",getLabel("Common.TerminologySet.label",'COMMON'))
			alert(err_msg)
			formObj.term_set_id.focus();
			if(formObj.linking_desc.value!=""){
				formObj.linking_desc.value="";
			}			
			return;
		}*/
		var temp_term_code = "";
		var term_desc = linking_desc.value;
		var term_code_associated = "";
		var mode ="";
		var mulitple_yn = "";
		var term_set_id= formObj.term_set_id.value;
		var retVal = new String();
		var dialogHeight= "28" ;
		var dialogWidth = "45" ;
		var status = "no";
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(tit,"UTF-8")+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
		if( returnVal == null || returnVal == "" ){
			formObj.linking_code.value="";
			formObj.linking_desc.value="";
		}else{
			var retValCode = returnVal.split("||") ;
			var retVal		 = retValCode[0].split("\"") ;
			formObj.linking_code.value=retValCode[0];
			formObj.linking_desc.value=retValCode[1];
			}
		}

function visibleProcCode(obj){
//alert(obj.value)
	document.schedule_appointment.linking_desc.value="";
	document.schedule_appointment.linking_code.value="";
	if(obj.value !=""){
		document.schedule_appointment.linking_desc.disabled=false;
		document.schedule_appointment.link_lokup_btn.disabled=false;
		//document.forms[0].all.PractProcImg.style.visibility="visible";
		document.getElementById('PractProcImg').style.visibility="visible";
	}else{		
		document.schedule_appointment.linking_desc.disabled=true;
		document.schedule_appointment.link_lokup_btn.disabled=true;		
		//document.forms[0].all.PractProcImg.style.visibility="hidden";
		document.getElementById('PractProcImg').style.visibility="hidden";		
	}
}

function patHistWindow(obj,patient_id){
	//alert(obj.name)
	//alert(patient_id)
	if(patient_id!='' && obj.name =='OK'){
		window.returnValue= "OKPATID";
		window.close();
	}else if(patient_id!='' && obj.name =='CANCEL'){
		window.returnValue= "CANCEL";
		window.close();	
	}else if(patient_id=='' && obj.name =='OK'){
		if(parent.OAPatApptSummary.OAPatApptSummary){
			var retVal = "";
			//if(parent.OAPatApptSummary.OAPatApptSummary.name_prefix)
				retVal = parent.OAPatApptSummary.OAPatApptSummary.name_prefix.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.first_name)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.first_name.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.second_name)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.second_name.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.third_name)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.third_name.value;				
			//if(parent.OAPatApptSummary.OAPatApptSummary.family_name)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.family_name.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.name_suffix)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.name_suffix.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.name_prefix_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.name_prefix_oth_lang.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.first_name_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.first_name_oth_lang.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.second_name_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.second_name_oth_lang.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.third_name_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.third_name_oth_lang.value;				
			//if(parent.OAPatApptSummary.OAPatApptSummary.family_name_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.family_name_oth_lang.value;
			//if(parent.OAPatApptSummary.OAPatApptSummary.name_suffix_oth_lang)
				retVal = retVal+"!"+parent.OAPatApptSummary.OAPatApptSummary.name_suffix_oth_lang.value;
			window.returnValue= retVal;
			window.close();
		}else{
			window.close();
		}
	}else if(patient_id=='' && obj.name =='CANCEL'){
		window.returnValue= "CANCEL";
		window.close();
	}
}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {

		if(fields[i]){
			if(trimCheck1(fields[i].value)) {
				fields[i].value = trimString1(fields[i].value);
				
			}else{ 
				var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$',names[i]);
				errors = errors + err + "\n";
			}
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function trimCheck1(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function trimString1(inString)
{
	var outString;
	var startPos;
	var endPos;
	var ch;

	// where do we start?
	startPos = 0;
	ch = inString.charAt(startPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		startPos++;
		ch = inString.charAt(startPos);
	}

	// where do we end?
	endPos = inString.length - 1;
	ch = inString.charAt(endPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		endPos--;
		ch = inString.charAt(endPos);
	}

	// get the string
	outString = inString.substring(startPos, endPos + 1);

	return outString;
}
// modified by N Munisekhar on 28-Jan-2013 against RUT-SCF-0216 [IN:037457] 
	function prefixToGenderDflt(obj){
	var val=obj.value;
	if(obj.value != ""){
	if(obj.name=="name_prefix"){
		prefix_length=NamePrefixArray.length;
		for(i = 0; i < prefix_length; i++){
			if(unescape(NamePrefixArray[i])==val){
				if(unescape(PrefixSexArray[i])!='B')
					document.getElementById("gender").value=unescape(PrefixSexArray[i]);
				else
					document.getElementById("gender").value=""; 
					
				if(document.getElementById("name_prefix_oth_lang")){ 
					document.getElementById("name_prefix_oth_lang").value=unescape(NamePrefixLocArray[i]);
				}
			}
		}
	
	}else{
	    prefix_length=NamePrefixLocArray.length;
		for(i = 0; i < prefix_length; i++){
			if(unescape(NamePrefixLocArray[i])==val){
				if(unescape(PrefixSexArray[i])!='B')
					document.getElementById("gender").value=unescape(PrefixSexArray[i]);
				else
					document.getElementById("gender").value=""; 
					
				if(document.getElementById("name_prefix")){ 
					document.getElementById("name_prefix").value=unescape(NamePrefixArray[i]);
				}
			}
		}
	}
}else{
        if(document.getElementById("name_prefix_oth_lang"))
		  document.getElementById("name_prefix_oth_lang").value="";
		 if(document.getElementById("name_prefix"))
		  document.getElementById("name_prefix").value="";
	       document.getElementById("gender").value="";
}
}

function suffixToGenderDflt(obj){
	var val=obj.value;
	if(obj.value != ""){
	if(obj.name=="name_suffix"){
		suffix_length=NameSuffixArray.length;
		for(i = 0; i < suffix_length; i++){
			if(unescape(NameSuffixArray[i])==val){
				if(unescape(SuffixSexArray[i])!='B')
					document.getElementById("gender").value=unescape(SuffixSexArray[i]);
				else
					document.getElementById("gender").value=""; 
				if(document.getElementById("name_suffix_oth_lang")) {	
					document.getElementById("name_suffix_oth_lang").value=unescape(NameSuffixLocArray[i]);
				}
			}
		}
	}else{
     	suffix_length=NameSuffixLocArray.length;
		for(i = 0; i < suffix_length; i++){
			if(unescape(NameSuffixLocArray[i])==val){
				if(unescape(SuffixSexArray[i])!='B')
					document.getElementById("gender").value=unescape(SuffixSexArray[i]);
				else
					document.getElementById("gender").value=""; 
					
				if(document.getElementById("name_suffix")){ 
					document.getElementById("name_suffix").value=unescape(NameSuffixArray[i]);
				}
			}
		}
	}
}else{
        if(document.getElementById("name_suffix_oth_lang"))
		  document.getElementById("name_suffix_oth_lang").value="";
		 if(document.getElementById("name_suffix"))
		  document.getElementById("name_suffix").value="";
	       document.getElementById("gender").value="";
}
}
//End of RUT-SCF-0216 [IN:037457] 	
	


function radRuleAppl(obj){ 
if(obj.checked){
	parent.frames[1].document.forms[0].rd_appt_yn.value="Y";	
	parent.frames[1].document.forms[0].location_type.value="E";	
	parent.frames[1].document.forms[0].location_type.onchange();	
	parent.frames[1].document.forms[0].location_type.disabled=true;
	parent.frames[1].document.forms[0].resourceType_1.selectedIndex=2;
	parent.frames[1].document.forms[0].resourceType_1.onchange();
	parent.frames[1].document.forms[0].resourceType_1.disabled=true;
	//document.forms[0].all.ordCatImg.style.visibility='visible'
	document.getElementById('ordCatImg').style.visibility='visible'
	
}else{
	parent.frames[1].document.forms[0].rd_appt_yn.value="N";
	parent.frames[1].document.forms[0].location_type.selectedIndex=0;	
	parent.frames[1].document.forms[0].location_type.onchange();
	parent.frames[1].document.forms[0].location_type.disabled=false;
	parent.frames[1].document.forms[0].resourceType_1.selectedIndex=0;
	parent.frames[1].document.forms[0].resourceType_1.onchange();
	parent.frames[1].document.forms[0].resourceType_1.disabled=false;	
	//document.forms[0].all.ordCatImg.style.visibility='hidden'
	document.getElementById('ordCatImg').style.visibility='hidden'
}
}

/* commented by Nandhini to add getElementById
function enableDisableBtns(){
	//document.forms[0].all.From_timeval.value="";
	//document.forms[0].all.To_timeval.value="";
	//document.forms[0].all.prefdate1.value="";
	//document.forms[0].all.prefenddate1.value="";
	if(document.forms[0].all.prefdate1.value!='' && (document.forms[0].all.From_timeval.value!='' && document.forms[0].all.To_timeval.value!='')){
		document.forms[0].all.prevDateDiasbled.style.display="none";
		document.forms[0].all.prevDate.style.display="";
		document.forms[0].all.nextDateDiasbled.style.display="none";
		document.forms[0].all.nextDate.style.display="";
		document.forms[0].all.prevTimePlusDisabled.style.display="none";
		document.forms[0].all.prevTimePlus.style.display="";
		document.forms[0].all.prevTimeMinusDisabled.style.display="none";
		document.forms[0].all.prevTimeMinus.style.display="";
		document.forms[0].all.nextTimePlusDisabled.style.display="None";
		document.forms[0].all.nextTimePlus.style.display="";
		document.forms[0].all.nextTimeMinusDisabled.style.display="none";
		document.forms[0].all.nextTimeMinus.style.display="";
		
	}else{
		document.forms[0].all.prevDateDiasbled.style.display="";
		document.forms[0].all.prevDate.style.display="none";
		document.forms[0].all.nextDateDiasbled.style.display="";
		document.forms[0].all.nextDate.style.display="none";
		document.forms[0].all.prevTimePlusDisabled.style.display="";
		document.forms[0].all.prevTimePlus.style.display="none";
		document.forms[0].all.prevTimeMinusDisabled.style.display="";
		document.forms[0].all.prevTimeMinus.style.display="none";
		document.forms[0].all.nextTimePlusDisabled.style.display="";
		document.forms[0].all.nextTimePlus.style.display="None";
		document.forms[0].all.nextTimeMinusDisabled.style.display="";
		document.forms[0].all.nextTimeMinus.style.display="none";
	}
}*/
function enableDisableBtns(){
	//document.getElementById('From_timeval').value="";
	//document.getElementById('To_timeval').value="";
	//document.getElementById('prefdate1').value="";
	//document.getElementById('prefenddate1').value="";
	if(document.getElementById('prefdate1').value!='' && (document.getElementById('From_timeval').value!='' && document.getElementById('To_timeval').value!='')){
		document.getElementById('prevDateDiasbled').style.display="none";
		document.getElementById('prevDate').style.display="";
		document.getElementById('nextDateDiasbled').style.display="none";
		document.getElementById('nextDate').style.display="";
		document.getElementById('prevTimePlusDisabled').style.display="none";
		document.getElementById('prevTimePlus').style.display="";
		document.getElementById('prevTimeMinusDisabled').style.display="none";
		document.getElementById('prevTimeMinus').style.display="";
		document.getElementById('nextTimePlusDisabled').style.display="None";
		document.getElementById('nextTimePlus').style.display="";
		document.getElementById('nextTimeMinusDisabled').style.display="none";
		document.getElementById('nextTimeMinus').style.display="";
		
	}else{
		document.getElementById('prevDateDiasbled').style.display="";
		document.getElementById('prevDate').style.display="none";
		document.getElementById('nextDateDiasbled').style.display="";
		document.getElementById('nextDate').style.display="none";
		document.getElementById('prevTimePlusDisabled').style.display="";
		document.getElementById('prevTimePlus').style.display="none";
		document.getElementById('prevTimeMinusDisabled').style.display="";
		document.getElementById('prevTimeMinus').style.display="none";
		document.getElementById('nextTimePlusDisabled').style.display="";
		document.getElementById('nextTimePlus').style.display="None";
		document.getElementById('nextTimeMinusDisabled').style.display="";
		document.getElementById('nextTimeMinus').style.display="none";
	}
}
function invokeRule(obj){
	if(obj.name=='nextTimePlus'){
		var toTimeValArr=(document.forms[0].To_timeval.value).split(':');
		if(parseInt(toTimeValArr[0],10)<23){
			if(parseInt(toTimeValArr[0],10)<9){
				document.getElementById('To_timeval').value="0"+(parseInt(toTimeValArr[0],10)+1)+":"+toTimeValArr[1];
			}else{
				document.getElementById('To_timeval').value=(parseInt(toTimeValArr[0],10)+1)+":"+toTimeValArr[1];
			}
		}
		//fetchResult1();		
	}else if(obj.name=='nextTimeMinus'){
		var fromTimeValArr=(document.getElementById('From_timeval').value).split(':');
		var toTimeValArr=(document.getElementById('To_timeval').value).split(':');		
		if(parseInt(toTimeValArr[0],10)>0){
			if((parseInt(fromTimeValArr[1],10)<=parseInt(toTimeValArr[1],10) && parseInt(fromTimeValArr[0],10)<=(parseInt(toTimeValArr[0],10)-1)) || (parseInt(fromTimeValArr[1],10)>parseInt(toTimeValArr[1],10) && parseInt(fromTimeValArr[0],10)<(parseInt(toTimeValArr[0],10)-1))){
				if(parseInt(toTimeValArr[0],10)<11){
					document.getElementById('To_timeval').value="0"+(parseInt(toTimeValArr[0],10)-1)+":"+toTimeValArr[1];
				}else{
					document.getElementById('To_timeval').value=(parseInt(toTimeValArr[0],10)-1)+":"+toTimeValArr[1];
				}
			}
		}
		//fetchResult1();		
	}else if(obj.name=='prevTimePlus'){
		var fromTimeValArr=(document.getElementById('From_timeval').value).split(':');
		var toTimeValArr=(document.getElementById('To_timeval').value).split(':');
		if((parseInt(fromTimeValArr[0],10)>=0 && parseInt(fromTimeValArr[0],10)<23) && ((parseInt(fromTimeValArr[1],10)<=parseInt(toTimeValArr[1],10) && (parseInt(fromTimeValArr[0],10)+1)<=parseInt(toTimeValArr[0],10)) || (parseInt(fromTimeValArr[1],10)>parseInt(toTimeValArr[1],10) && (parseInt(fromTimeValArr[0],10)+1)<parseInt(toTimeValArr[0],10)))){
			if(parseInt(fromTimeValArr[0],10)<9){
				document.getElementById('From_timeval').value="0"+(parseInt(fromTimeValArr[0],10)+1)+":"+fromTimeValArr[1];
			}else{
				document.getElementById('From_timeval').value=(parseInt(fromTimeValArr[0],10)+1)+":"+fromTimeValArr[1];
			}
		}
		//fetchResult1();
	}else if(obj.name=='prevTimeMinus'){
		var fromTimeValArr=(document.getElementById('From_timeval').value).split(':');
		if(parseInt(fromTimeValArr[0],10)>0){
			if(parseInt(fromTimeValArr[0],10)<11){
				document.getElementById('From_timeval').value="0"+(parseInt(fromTimeValArr[0],10)-1)+":"+fromTimeValArr[1];
			}else{
				document.getElementById('From_timeval').value=(parseInt(fromTimeValArr[0],10)-1)+":"+fromTimeValArr[1];
			}
		}
		//fetchResult1();
	}else if(obj.name=='prevDate'){
		document.getElementById('prefdate1').value=minusDate(document.getElementById('prefdate1').value,'DMY','en','1','d');
		DateCompare_from("from",document.getElementById('prefdate1'));
		//fetchResult1();
	}else if(obj.name=='nextDate'){
		document.getElementById('prefdate1').value=plusDate(document.getElementById('prefdate1').value,'DMY','en','1','d');
		//fetchResult1();
	}
}

