function BLCheckElig()
{
	var bed_ref = "parent.frames[1].document.forms[0].to_bed_no";
	var modified_bed_type_ref = "parent.frames[1].document.forms[0].modified_bed_type_code";
	var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+document.forms[0].bedtypecode.value+"\"><input type='hidden' name='field2' id='field2' value=\""+document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Admission'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field4' id='field4' value='../js/AssignBedDetail.js'></form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	
	parent.frames[2].document.dummy_form1.submit();
}


function Apply()
{
	parent.frames[1].document.forms[0].record.disabled = true;
	parent.frames[1].document.forms[0].Bedcode.disabled = false;
	parent.frames[1].document.forms[0].Bedtype.disabled = false; 

	if(parent.frames[1].document.assign_bed.bed_alloc_date_time != null)
		parent.frames[1].document.assign_bed.bed_alloc_date_time.disabled = false;

	if(parent.frames[1].document.assign_bed.arrival_date_time != null)
		parent.frames[1].document.assign_bed.arrival_date_time.disabled = false;

	setTimeout('submitVal()',500);
}


function submitVal()
{
	if(document.forms[0].BalnkFlag.value == 'Y')
	{
		var fields= new Array(document.forms[0].nursing_unit_desc,document.forms[0].service,document.forms[0].Splcode_desc, document.forms[0].pract_desc,document.forms[0].Bedcode,document.forms[0].to_bed_no,document.forms[0].bed_alloc_date_time,document.forms[0].Bedtype);
		var names=new Array( getLabel('Common.nursingUnit.label','Common'), getLabel('Common.service.label','Common'), getLabel('Common.speciality.label','Common'), getLabel('Common.AttendingPractitioner.label','Common'), getLabel('Common.BedClass.label','common'), getLabel('Common.bedno.label','Common'), getLabel('eIP.BedAllocationDateTime.label','IP'), getLabel('Common.bedtype.label','Common'));
		
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
		if(document.forms[0].is_validate_weight_on_admission.value=="Y"){
			fields.unshift(document.forms[0].weight_on_admission);
			names.unshift(getLabel('eIP.WeightOnAdmission.label','IP'));
		}
		/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/

		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		
		var enable_height_bmi_pat_cls=document.forms[0].enable_height_bmi_pat_cls.value;
		var patient_class=document.forms[0].patient_class.value;
		var is_validate_height_on_admission=document.forms[0].is_validate_height_on_admission.value;
		var isHeightAndBmiEnable=document.forms[0].isHeightAndBmiEnable.value;
			if( isHeightAndBmiEnable== "true"){
		if((enable_height_bmi_pat_cls==patient_class  || enable_height_bmi_pat_cls=="ID")&&is_validate_height_on_admission=="Y"){
			fields.unshift(document.forms[0].height_on_admission);
			names.unshift(getLabel('eIP.HeightOnAdmission.label','IP'));
		}
			}
		
		
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 END*/
		populateDailyRate(parent.frames[1].document.forms[0].to_bed_no);
		if(checkFields1( fields, names)) 
		{
			/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/
			var weight_on_admission	= document.forms[0].weight_on_admission.value;
			if(weight_on_admission!=""){
				var chk_weight_on_admission	= parseFloat(weight_on_admission);
				if(chk_weight_on_admission <= 0){
					var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
					msg = msg.replace('Value',getLabel("eIP.WeightOnAdmission.label","IP") );
					alert(msg);
					document.forms[0].weight_on_admission.focus();
					parent.frames[1].document.forms[0].record.disabled = false;
					return false;
				}
				
				if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(weight_on_admission)){//Decimal validation
					var msg = getMessage("INVALID_WEIGHT_ON_ADMISSION","IP");
					alert(msg);
					document.forms[0].weight_on_admission.focus();
					parent.frames[1].document.forms[0].record.disabled = false;
					return false;
				}
			}
			
			if(weight_on_admission==""){
				document.forms[0].weight_on_admission_unit.value="";
			}
			/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
			var enable_height_bmi_pat_cls=document.forms[0].enable_height_bmi_pat_cls.value;
			var patient_class=document.forms[0].patient_class.value;
			var is_validate_height_on_admission=document.forms[0].is_validate_height_on_admission.value;
			var isHeightAndBmiEnable=document.forms[0].isHeightAndBmiEnable.value;
			if( isHeightAndBmiEnable== "true"){
			if((enable_height_bmi_pat_cls==patient_class  || enable_height_bmi_pat_cls=="ID") )
				{	
			var height_on_admission	= document.forms[0].height_on_admission.value;
			if(height_on_admission!=""){
				var chk_height_on_admission	= parseFloat(height_on_admission);
				if(chk_height_on_admission == 0){
					var msg = getMessage("VALUE_SHOULD_BE_GR_ZERO","Common");
					msg = msg.replace('Value',getLabel("eIP.HeightOnAdmission.label","IP") );
					alert(msg);
					document.forms[0].height_on_admission.focus();
					parent.frames[1].document.forms[0].record.disabled = false;
					return false;
				}
				
				if(!(/^\d{1,8}(?:\.\d{1,3})?$/).test(height_on_admission)){//Decimal validation
					
					var msg = getMessage("INVALID_HEIGHT_ON_ADMISSION","IP");
					alert(msg);
					document.forms[0].height_on_admission.focus();
					parent.frames[1].document.forms[0].record.disabled = false;
					return false;
				}
			}
			
			if(height_on_admission==""){
				document.forms[0].height_on_admission_unit.value="";
			}
				}
			}
					
			/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
			
			
			var fields = new Array(document.forms[0].to_bed_no);
			var names = new Array(getLabel('Common.bedno.label','Common'));
			
			if(SpecialCharCheck(fields,names,'',"A",''))
			{
				if(document.forms[0].bl_operational.value=='Y')
				{
					if(document.forms[0].pat_check_in_allowed_yn.value=='N')
					{
						//alert('1');
						var bed_ref = "parent.frames[1].document.forms[0].to_bed_no";
						var modified_bed_type_ref = "parent.frames[1].document.forms[0].modified_bed_type_code";
						var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+document.forms[0].Bedtype.value+"\"><input type='hidden' name='field2' id='field2' value=\""+document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Admission'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/AssignBedDetail.js'></form></body></html>";
						parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
						parent.frames[2].document.dummy_form.submit();
					}
					else
						
					{//alert('2');
						applyone('Y');
					}
				}
				else
				{//alert('3');
					applyone('Y');
				}
			 }		 
			 else
			 {
				document.forms[0].to_bed_no.select();
				document.forms[0].to_bed_no.focus();
			 }
		}else
			parent.frames[1].document.forms[0].record.disabled = false;
	}

	if(parent.frames[1].document.forms[0].pat_check_in_allowed_yn.value == 'Y')
	{
		parent.frames[1].document.forms[0].Bedcode.disabled = true;
		parent.frames[1].document.forms[0].Bedtype.disabled = true;
	}
	if(parent.frames[1].document.assign_bed.bed_alloc_date_time != null)
		parent.frames[1].document.assign_bed.bed_alloc_date_time.disabled = true;
	if(parent.frames[1].document.assign_bed.arrival_date_time != null)
		parent.frames[1].document.assign_bed.arrival_date_time.disabled = true;
}


function applyone(difframe)
{
	var sStyle				= parent.frames[1].document.forms[0].sStyle.value;
	var nursing_unit_code	= parent.frames[1].document.forms[0].nursing_unit_code.value;
	var to_bed_no			= parent.frames[1].document.forms[0].to_bed_no.value;
	var bed_code			= parent.frames[1].document.forms[0].Bedcode.value;
	if (parent.frames[1].document.forms[0].setup_bl_dtls_in_ip_yn.value=='Y')
	{
		// alert('here');
		 var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetchdailycharge' id='fetchdailycharge' method='post' action='../jsp/FetchDailyCharge.jsp'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value=\""+nursing_unit_code+"\"><input type='hidden' name='to_bed_no' id='to_bed_no' value=\""+to_bed_no+"\"><input type='hidden' name='bed_code' id='bed_code' value=\""+bed_code+"\"><input type='hidden' name='submit_yn' id='submit_yn' value=\"Y\"><input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value=\""+document.forms[0].setup_bl_dtls_in_ip_yn.value+"\">";
		 HTMLVal = HTMLVal+"</form></body></html>";
		 parent.frames[2].document.write(HTMLVal);
		 parent.frames[2].document.fetchdailycharge.submit();
	 }
	 else
	 {	
		//alert('else');
		 parent.frames[1].document.forms[0].Bedcode.disabled = false;
		 parent.frames[1].document.forms[0].Bedtype.disabled = false;
		 parent.frames[1].document.forms[0].bed_alloc_date_time.disabled = false;
		 parent.frames[1].document.forms[0].submit();
 		 parent.frames[1].document.forms[0].record.disabled = true;
	 }
}

function closeWin()
{
window.close();
}

function fetchValForBedClass() {} 

async function callModal()
{
	var sStyle = document.forms[0].sStyle.value;
	var oper_stn_id = document.assign_bed.oper_stn_id.value;
	var nursingunit = document.assign_bed.nursing_unit_code.value;
	var practitionerid = document.assign_bed.practitioner_id.value;
	var specialitycode = document.assign_bed.specialty_code.value; 
	var bedclasscode = document.assign_bed.Bedcode.value;
	var gender = document.assign_bed.gender.value;
	var agevalue = document.assign_bed.age.value;

	var age = "";

	if(agevalue != '')
	{
		var yr = eval(agevalue.indexOf("Y"));
		var mon = eval(agevalue.indexOf("M"));

		if(mon>=0 && yr>=0)
		{
			age = agevalue.substring(0,yr);		
			agevalue = "Y";
		}
		else if(mon >= 0)
		{
			age = agevalue.substring(0,mon);		
			agevalue = "M";
		}
		else
		{
			age = agevalue.substring(0,yr);		
			agevalue = "Y";
		}
	}

	var retVal = 	new String();
	var dialogHeight= "70vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop = "72";
	var status = "no";
	var arguments	= "" ;
	var wherecondn = "ASSIGN_BED_YN";
	var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	retVal = await window.showModalDialog("../jsp/BedAvailabilityChart.jsp?nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&oper_stn_id="+oper_stn_id+"&wherecondn="+wherecondn,arguments,features);

	if(retVal!=null && retVal != "")
	{		
		var arr=retVal.split("^");
		if (arr.length > 2)
		{
			document.forms[0].nursing_unit_short_desc.value =arr[0];
			if(arr[1] == null) arr[1]="";
			if(arr[4] == null) arr[4]="";
			if(arr[3] == null) arr[3]="";

			if(arr[1] != null)
			{
				var arr1 = arr[1].split("/");
				document.forms[0].to_bed_no.value		= arr1[0];
			}

				document.forms[0].room_no.value		= arr[4];
				document.getElementById("roomno").innerHTML="<b>"+arr[4]+"</b>";
				document.forms[0].Bedcode.value		= arr[3];
				document.forms[0].bedtypecode.value = arr[2];
				
			if(document.forms[0].setup_bl_dtls_in_ip_yn.value=="Y")
			{
				var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetchdailycharge' id='fetchdailycharge' method='post' action='../jsp/FetchDailyCharge.jsp'><input type='hidden' name='flag' id='flag' value='frombedchart'><input type='hidden' name='Bedcode' id='Bedcode' value='"+arr[3]+"'><input type='hidden' name='bed_code1' id='bed_code1' value=\""+arr[3]+"\">";
				HTMLVal = HTMLVal+"</form></body></html>";
				parent.frames[2].document.write(HTMLVal);
				parent.frames[2].document.fetchdailycharge.submit();
			}
		}
		else
		{
			document.forms[0].nursing_unit_short_desc.value =arr[0];
		}
		document.forms[0].to_bed_no.focus();
	}
}

function refDet(obj)
{
	var retVal = 	new String();
	var dialogHeight= "41" ;
	var dialogTop = "72" ;
	var dialogWidth	= "65" ;
	var ref = obj.value;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
}
/*
function onBedClassChange(obj)
{
	self.document.forms[0].to_bed_no.value = '';
	self.document.forms[0].to_room_no.value = '';	
}
*/
function doDateTimeChk123(obj)
{
	
	var objchk = obj.value;
		if(objchk != '')
	{
		var comp=obj
		obj=obj.value
		var sysdat = document.forms[0].sdate.value;
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
		if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt(dt) )
			{	
				alert(getMessage("INVALID_DATE_TIME","SM"))
				retval= false
				comp.focus();
				comp.select();
			}
			else
			{
				if(time==null || time=="")
				{
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
					comp.focus();
					comp.select();
				 }
				else
				{
					if(!chkTime(time))
					{
						retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
						comp.focus();
						comp.select();
					 }
				}
	   		}
	         }
		 else
		 {
			retval= false
			alert(getMessage("INVALID_DATE_TIME","SM"))
			comp.focus();
			comp.select();
		  }

		if(retval != false)	
			ValidateDateTime(obj,sysdat)

	return retval
	}
}

function checkDt(date1)
{
	retval=true
	var date1arr=new Array()
	date1arr=date1.split("/")

	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);
	
		if(date1m<=12)
		{

			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false}

	    		if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
				{
					retval= false}

					if ((date1y.length <4) || (date1y.length >4))
					{
						retval= false
					}
			}
			else
			{
				retval= false;
			}
		}
		else
		{
			retval= false;
		}
	
	return retval;
}


function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
			var strCheck = ':0123456789';
			 for(var i=0;i<=time1min.length;i++) {
                if (strCheck.indexOf(time1min.charAt(i)) == -1){
					return false;
                    break;
                }
            }
			time1hr=eval(time1hr)
			time1min=eval(time1min)
			if(time1hr<=23)
			{
				if(time1min>60)
					retval=false;
			}
			else
				retval=false;
			
		}
		else
			retval=false;
	}
	else
		retval=false;
	
	return retval
}
function ValidateDateTime(from,to)
{
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage("INVALID_BED_ALLOC_DATE_TIME","IP"));
		document.forms[0].bed_alloc_date_time.focus();
		document.forms[0].bed_alloc_date_time.select();		
		return false
	}
	else
	{
		var fromval = from;
		var toval   = document.forms[0].trn_date.value;				
		ValidateDateTime12(fromval,toval)
	}			
}	

function ValidateDateTime12(from,to)
{	
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))


	if(Date.parse(to_date) > Date.parse(from_date))
	{
		alert(getMessage("INVALID_BED_ALLOCDATE","IP"));
		document.forms[0].bed_alloc_date_time.focus();
		document.forms[0].bed_alloc_date_time.select();		
		return false
	}
	else{
		return true;
	    }		
}	

var onload	= 0;
function popDynamicValues(obj)
{
	var nurs_unit_fr=self.document.assign_bed.nursing_unit_code.value ;
	var nurs_unit_to=self.document.assign_bed.nursing_unit.value;
	var bed_class_to=self.document.assign_bed.Bedcode.value;
	var spl_fr=self.document.assign_bed.specialty_code.value;
	var team_fr=self.document.assign_bed.to_pract_team_id.value;
	var bed_class_fr=self.document.assign_bed.bed_class_code.value;

	if(nurs_unit_to != nurs_unit_fr)
	{
		self.document.assign_bed.to_bed_no.value = '';
		self.document.assign_bed.room_no.value = '';	
		self.document.assign_bed.Bedcode.options[0].selected=true;
		self.document.assign_bed.practid.value = '';
		self.document.assign_bed.team_id.options[0].selected=true;
		spl_fr='';
		tem_fr='';
	}
	else
	{
		document.forms[0].nursing_unit_desc.value=self.document.assign_bed.nursing_unit_desc.value ;
		if(onload ==1)
		spl_fr='';
		self.document.assign_bed.to_bed_no.value = '';
		self.document.assign_bed.to_room_no.value = '';	
	}
	var val = obj.value;
	if (val != null && val != "")
	{
		onload=	1	;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value='"+val+"'><input type='hidden' name='funct' id='funct' value='spec'><input type ='hidden'  name='spl_fr' id='spl_fr' value='"+spl_fr+"'><input type ='hidden'  name='team_fr' id='team_fr' value='"+team_fr+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.query_spec.submit();
	}
}

function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
			var nursingunit		= self.document.assign_bed.nursing_unit.value;
			var to_bed_no		= self.document.assign_bed.to_bed_no.value;
			var bed_class_code  = self.document.assign_bed.Bedcode.value;
			var bed_type		= self.document.assign_bed.Bedtype.value;
			var bedno = obj.value;
			var bed_change_YN =parent.frames[1].document.assign_bed.pat_check_in_allowed_yn.value;
			var url = parent.frames[2].location.href;
			var action_url="";
			if(url.indexOf("/servlet")!=-1)
			{			
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+bed_class_code+"'><input type='hidden' name='field2' id='field2' value='"+bed_type+"'> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value=''><input type='hidden' name='field9' id='field9' value='"+bed_change_YN+"'><input type='hidden' name='field10' id='field10' value='assign_bed'></form></body></html>";
			}
			else
			{
								
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+bed_class_code+"'><input type='hidden' name='field2' id='field2' value='"+bed_type+"'> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value=''><input type='hidden' name='field9' id='field9' value='"+bed_change_YN+"'><input type='hidden' name='field10' id='field10' value='assign_bed'></form></body></html>";
			}
				
			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.dum_form.submit();
			
		}
	}
}

function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		if (obj.name == "to_bed_no")
			var names1 = new Array(getLabel('Common.bedno.label','Common'));
		if (obj.name == "to_room_no")
			var names1 = new Array(getLabel("Common.RoomCubicleNo.label","Common"));
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
					{
						 return true;
					}
					else 
					{
						 obj.focus();
						 obj.value='';
						 return false;
					}
			}
			else if(val=="Char")
			{
				return true;
			}
			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}
}

async function callBedAvailChart()
{
	if(document.forms[0].Splcode_desc.value=='')
    document.forms[0].Splcode.value=''; 
	var ipparam_bed_yn =parent.frames[1].document.assign_bed.pat_check_in_allowed_yn.value;
	var bed_type = parent.frames[1].document.assign_bed.Bedtype.value;
	var nursingunit = parent.frames[1].document.assign_bed.nursing_unit.value;
	var practitionerid = parent.frames[1].document.assign_bed.practid.value;
	var specialitycode = parent.frames[1].document.assign_bed.Splcode.value;
	var bedclasscode = parent.frames[1].document.assign_bed.Bedcode.value;
	var gender = parent.frames[1].document.assign_bed.gender.value;
	var agevalue = parent.frames[1].document.assign_bed.age.value;
	var chg_nurs_unit_in_assign_bed_yn = parent.frames[1].document.assign_bed.chg_nurs_unit_in_assign_bed_yn.value;
	var patient_class = parent.frames[1].document.assign_bed.patient_class.value;
	var room_no = parent.frames[1].document.assign_bed.to_room_no.value;
	var age = "";
	var yr = eval(agevalue.indexOf("Y"));
	var mon = eval(agevalue.indexOf("M"));

	if(mon>=0 && yr>=0)
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}
	else if(mon >= 0)
	{
		age = agevalue.substring(0,mon);
		agevalue = "M";
	}
	else
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}

	var retVal = 	new String();
	var dialogHeight= "700px";
	var dialogWidth = "900px";
	var dialogTop	= "10";
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = ""; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var oper_stn_id = document.assign_bed.oper_stn_id.value;

	if (chg_nurs_unit_in_assign_bed_yn != "N")
	{
		wherecondn  = "CHG_NURS_UNIT_IN_ASSIGN_BED_YN"; 
		var URLValue = "../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=BcBt&nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&ipparam_bed_yn="+ipparam_bed_yn+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bed_type)+"&room_no="+room_no+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&oper_stn_id="+oper_stn_id+"&wherecondn="+escape(wherecondn)+"&patient_class="+escape(patient_class);
	}
	else if (chg_nurs_unit_in_assign_bed_yn == "N")
	{
		wherecondn  = "ASSIGN_BED_YN"; 
		var URLValue = "../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=NuBcBt&nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&ipparam_bed_yn="+ipparam_bed_yn+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn)+"&patient_class="+escape(patient_class)+"&oper_stn_id="+oper_stn_id+"&bed_type="+escape(bed_type)+"&room_no="+room_no;
		
	}

	retVal = await window.showModalDialog(URLValue,arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			var arr1 = arr[1].split("/");
			parent.frames[1].document.assign_bed.to_bed_no.value = arr1[0];
			parent.frames[1].document.assign_bed.nursing_unit.value=arr[0];
			parent.frames[1].document.assign_bed.nursing_unit_code.value=arr[0];
			parent.frames[1].document.assign_bed.nursing_unit_desc.value=arr[9];
			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				parent.frames[1].document.assign_bed.Splcode_desc.value=arr[11];
				parent.frames[1].document.assign_bed.Splcode.value=arr[10];
			}
			
			var obj = parent.frames[1].document.assign_bed.Bedtype;
				var length = obj.length;
				for(i=0;i<length;i++)
					{
					obj.remove(0);
					}
				var opt = parent.frames[1].document.createElement('Option');
				opt.value = arr[2];
				opt.text = arr[13];
				obj.add(opt);


			p = parent.frames[1].document.assign_bed.Bedcode;

			
			for (i=0; i<p.length; i++) {
				if(p.options[i].value ==arr[3])
					p.options[i].selected = true;
			}

			
			if(arr[4] ==null )  	arr[4] ='';	
			parent.frames[1].document.assign_bed.to_room_no.value=arr[4];
            parent.frames[1].document.assign_bed.room_no.value=arr[4]; 
			getRoomNo(parent.frames[1].document.assign_bed.to_bed_no);
		}
		else
		{
			parent.frames[1].document.assign_bed.nursing_unit.value=arr[0];			
			if (arr.length == 2)
				parent.frames[1].document.assign_bed.nursing_unit_desc.value=arr[1];
		}
			
	}
		
		check_bed_alcn_val(document.assign_bed.to_bed_no);
}

// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF 'Yes'.. then user will have to select another practitioner..
function chkPractRole(practID)
{
	var sStyle = document.forms[0].sStyle.value;
	var encounterId = document.forms[0].encounterId.value;
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='practRole_form' id='practRole_form' method='post' action='../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&encounter_ID="+encounterId+"&pract_ID="+practID+"'></form></BODY></HTML>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.practRole_form.submit();
}


// Function will check for empty values before calling up the common lookup func..
function beforeGetSpecialty(aSpecialtID, Facility_ID)
{
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value != "")
			getSpecialty(aSpecialtID, Facility_ID)
		else
		{
			document.forms[0].Splcode_desc.value	=	"";
			document.forms[0].Splcode.value			=	"";
		}
	}
}


function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
	}

	if(document.forms[0].nursing_unit_desc.value == "")
	{	
		var team_id = document.forms[0].team_id;
		var length = team_id.length;
		for(j=0;j<=length;j++)
		{
			team_id.remove(1);
		}

		if(document.forms[0].pat_check_in_allowed_yn.value=='N')
		{
			var BedClass = document.forms[0].Bedcode;
			var length = BedClass.length;
			for(i=0;i<=length;i++)
			{
				BedClass.remove(0);
			}
			var bedclassopt = document.createElement('OPTION');
			bedclassopt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			bedclassopt.value = "";
			BedClass.add(bedclassopt);
		
			
			var Bedtype = document.forms[0].Bedtype;
			var length = Bedtype.length;
			for(j=0;j<=length;j++)
			{
				Bedtype.remove(0);
			}
			var opt = document.createElement('OPTION');
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.value = "";
			Bedtype.add(opt);
		}
	}
}

function beforeGetPractitioner(obj,target, aFacilityID)
{

	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value != "")
		getPractitionerLocal(obj,target, aFacilityID);
	}
}

//	By Annadurai starts.
//	  To check whether bedno is empty or not., if empty., then clear the roomno.
var flag = 0; // To avoid error message duplication

function clearBedDetails()
{
	//For daycare patients the values have to be retained.	
	if(document.forms[0].dcunitcode.value=="" && document.forms[0].pat_check_in_allowed_yn.value=="N")
	{
		document.forms[0].to_room_no.value	= "";
		document.forms[0].Bedcode.value		= "";
		document.forms[0].to_bed_no.value	= "";
	}	
}

function checkForBedNo()
{
	if (document.assign_bed.to_bed_no.value=="" && document.assign_bed.dcunitcode.value=="")
		document.assign_bed.to_room_no.value="";
} // End of checkForBedNo.

function checkForNursing() // To check the presence of Nursing Unit.
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
} 

// To check the Nursing Unit and Specialty when selecting Practitioner.  
function checkForValues()
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 2;
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
		return false;
	}
	else if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		alert(getMessage('SPLTY_NOTNULL',"IP"));
		document.forms[0].Splcode_desc.focus();
		return false;
	}
} 

// To get the nursing unit using CommonLookup.
async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	if((document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value) || document.forms[0].nursing_unit_desc.value == '')
	{
		var nursingUnit = aNursingUnit.value;
		var facilityId	= aFacilityId;
		var loginUserId	= aLoginUser;
		var	operStnID	= pOperStnID;
		var pat_class   = document.forms[0].patient_class.value;
		var retVal =    new String();

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var call_function = document.forms[0].help_function_id.value;
		var nursingUnitCode = document.forms[0].nursing_unit_desc.value;
		var locale = document.forms[0].locale.value;
		var tit=getLabel("Common.nursingUnit.label","Common");
		var dialogHeight			= "400px" ;
		var dialogWidth				= "700px" ;
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		
		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&specilaty_code=&pract_id=&login_user="+loginUserId+"&oper_id="+operStnID+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&patientclass="+pat_class+"&call_function="+call_function+"&bkg_type=";

		/*sql = " select a.nursing_unit_code code, a.short_desc description from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW b where a.language_id = '"+locale+"' and a.eff_status = 'E' and a.facility_id  like '"+facilityId+"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and a.patient_class = '"+pat_class+"' and  b.oper_stn_id  like '"+operStnID+"' and b.appl_user_id  like '"+loginUserId+"' and assign_bed_yn='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?) ";
		*/

		retVal =  await window.showModalDialog(jsp_name,arguments, features);
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split("~");
			document.forms[0].nursing_unit.value				=	arr[0];
			document.forms[0].nursing_unit_code.value			=	arr[0];
			document.forms[0].nursing_unit_desc.value			=	arr[1];
			document.forms[0].nurs_desc_hid.value				= document.forms[0].nursing_unit_desc.value;
			
			popDynamicValues(document.forms[0].nursing_unit);

			if(document.forms[0].dcunitcode.value == "")
			{
				document.forms[0].Splcode_desc.value				=	'';
				document.forms[0].Splcode.value						=	'';
				document.forms[0].practid.value						=	'';
				document.forms[0].pract_desc.value					=	'';
				document.forms[0].team_id.value						=	'';
			}
			validateFields(arr[0]);
			clearBedDetails();
		}
		else
		{
			var service = document.forms[0].service;
			var length = service.length;
			for(j=0;j<=length;j++)
			{
				service.remove(1);
			}

			var team_id = document.forms[0].team_id;
			var length = team_id.length;
			for(j=0;j<=length;j++)
			{
				team_id.remove(1);
			}

			if(document.forms[0].dcunitcode.value=="")
			{
				document.forms[0].nursing_unit_desc.value			=	'';
				document.forms[0].nursing_unit.value				=	'';
				document.forms[0].nursing_unit_code.value			=	'';
				document.forms[0].Splcode_desc.value				=	'';
				document.forms[0].Splcode.value						=	'';
				document.forms[0].practid.value						=	'';
				document.forms[0].pract_desc.value					=	'';
				document.forms[0].team_id.value						=	'';
				//document.forms[0].Bedcode.value					=	'';
				document.forms[0].to_bed_no.value					=	'';
				document.forms[0].to_room_no.value					=	'';
			}
		}
	}
}

// Function Will Pass the NursingUnitCode to AdmissionValidation.jsp & fetch the values from ... Table & Populate Service Values...  
function validateFields(obj)
{
	if (obj == "") 
		return false;

	var continue_yn = true ;
	if(obj == '')  
		continue_yn =false

    if(continue_yn)
    {
		var nursingcode = obj;
		var urlStr = parent.frames[1].location.href;

		var HTMLVal =	" <html><body class='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' "+
		" method='post' action='../../eIP/jsp/AdmissionValidation.jsp'>"+
		" <input type='hidden' name='field3' id='field3' value='"+nursingcode+"'> "+
		" <input type='hidden' name='field4' id='field4' value='Service_form'> "+
		" </form></body></html>";

		if(parent.parent.messageFrame.document.body != null)
		{			
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.dum_form.submit();
		}
	
		if(document.forms[0].pat_check_in_allowed_yn.value=='N')
		{
			setTimeout('populatebedClass()',500);
		}
	}
}

function onBedClassChange()
{
	var bed_class = document.forms[0].Bedcode.value;
	//To populate the Bed Type based on bedclass
	var obj = document.forms[0].Bedtype;
	var length = obj.length;
	for(i=0;i<length;i++)
	{
		obj.remove(0);
	}
	var opt = document.createElement('OPTION');
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value = "";
	obj.add(opt);
	if(bed_class!="")
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='nursingunit_code' id='nursingunit_code' value='"+document.forms[0].nursing_unit_code.value+"'><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='assign_bed_yn' id='assign_bed_yn' value='Y'></form></body></html>";
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.dum_form.submit();
	}
}

function clearBedDetailsOnly()
{
	if(document.forms[0].dcunitcode.value == "")
			document.forms[0].to_room_no.value	= "";
	document.forms[0].to_bed_no.value	= "";
}

// To get the specialty using CommonLookup.
async function getSpecialty(aSpecialtID, Facility_ID)
{
	if(document.forms[0].nursing_unit_desc.value=="")
	{
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit_desc.focus();
	}
	else if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{	
	
	var target			= document.forms[0].Splcode_desc;
	var code			= document.forms[0].nursing_unit.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var locale = document.forms[0].locale.value;

	sql	= " select a.speciality_code code, a.short_desc description from AM_SPECIALITY_LANG_VW a, IP_NURS_UNIT_FOR_SPECIALTY b where a.language_id = '"+locale+"' and eff_status='E' and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code like ? and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";

	tit=getLabel("Common.speciality.label","Common");
	
	dataNameArray[0]	= "b.facility_id" ;
	dataValueArray[0]	= FacilityID;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "b.nursing_unit_code" ;
	dataValueArray[1]	= code;
	dataTypeArray[1]	= STRING ;
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3, 4";
	argumentArray[5] = aSpecialtID.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value			=	arr[0];
		document.forms[0].Splcode_desc.value	=	arr[1];
		document.forms[0].spec_desc_hid.value	=	document.forms[0].Splcode_desc.value;
		document.forms[0].pract_desc.value		=	'';
		document.forms[0].practid.value			=	'';
		document.forms[0].team_id.value			=	"";
		PopulateMedicalTeam();
		clearBedDetails();
	}
	else
	{
		document.forms[0].Splcode_desc.value	=	"";
		document.forms[0].Splcode.value			=	"";
		document.forms[0].pract_desc.value		=	"";
		document.forms[0].practid.value			=	"";
		document.forms[0].team_id.value			=	"";
	} 
 }
} 

// To get the Attending Pratitioner using GeneralPratitionerSearch.
function getPractitionerLocal(obj,target, aFacilityID)
{
	checkForValues();

	if(document.forms[0].nursing_unit.value != "" && document.forms[0].Splcode.value != "")
	{
		var practName_FName		=	"";
		var practName_FValue	=	"";
		var practId_FName		=	"";
		
		practName_FName			=	target.name;
		practName_FValue		=	target.value;
		practId_FName			=	document.forms[0].practid.name;

		var nursing_unit_code	=	document.forms[0].nursing_unit.value;
		var spl_code			=	document.forms[0].Splcode.value;
		var facility_id			=	aFacilityID;
		locale					=   document.forms[0].locale.value;
		
		getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
		
		/*var sql = "SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"'  AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)";

		var sql2 = "SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.specialty_code, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, a.gender gender, am_get_desc.AM_POSITION(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.specialty_code = '"+spl_code+"'  AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(e.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)";

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	= "<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + spl_code+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText	=	xmlHttp.responseText;
		responseText	=	trimString(responseText);
		eval(responseText);	*/
	}
} // End of getPractitioner();

// To Display the Attending Practitioner as Chief of Selected Medical Team if
//  the attending pratitioner is empty.
function getMedicalTeamHead(Obj)
{
	if (Obj.value == "")
	{
		document.assign_bed.pract_desc.value = "";
	}
	else if (document.assign_bed.pract_desc.value == "")
	{
		 var teamId		= document.assign_bed.team_id.value;
		 var sqlString	= "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = '"+ document.assign_bed.team_id.value + "' AND pract_role='C'";
		
		document.assign_bed.selecTeam.value	=	sqlString;

		var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' 							action='../../eIP/jsp/AdmissionValidation.jsp'>";
		HTMLValue += " <input type='hidden' name='selectedTeam' id='selectedTeam' value='"+teamId+"'>";
		HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'executeQuery' >";
		HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value='"+sqlString+"'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
		parent.frames[2].document.dum_form.submit();
	}
} // End of getMedicalTeamHead().

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal, objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value			=	arr[0];
		document.forms[0].pract_desc.value		=	arr[1];	
		document.forms[0].pract_desc_hid.value	=	document.forms[0].pract_desc.value;
		chkPractRole(document.forms[0].practid.value);
		PopulateMedicalTeam();
	}
	else
	{
		document.forms[0].practid.value			=	"";
		document.forms[0].pract_desc.value		=	"";			
	}
} // End of PractLookupRetVal().


function populatebedClass()
{
	var BedClass = document.forms[0].Bedcode;
	var length = BedClass.length;
	for(i=0;i<length;i++)
	{
		BedClass.remove(1);
	}
	var Bedtype = document.forms[0].Bedtype;
	var length = Bedtype.length;
	for(j=0;j<=length;j++)
	{
		Bedtype.remove(0);
	}
	var opt = document.createElement('OPTION');
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value = "";
	Bedtype.add(opt);

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='nursingunit_code' id='nursingunit_code' value='"+document.forms[0].nursing_unit_code.value+"'><input type='hidden' name='field4' id='field4' value='populateBedClass'></form></body></html>";
	parent.messageFrame.document.write(HTMLVal);
	parent.messageFrame.document.dum_form.submit();
}

// To Populate Medical Team.
function PopulateMedicalTeam()
{ 	
	var selected = document.forms[0].team_id;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var	str1	= "" ;
	var	str2	= "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].team_id.add(element);

	var ippractid		= document.forms[0].practid.value;
	var getservice		= document.forms[0].practid.value;
	var spl_code		= document.forms[0].Splcode.value;
	
	if (document.forms[0].Splcode.value != "")
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'></form></body></html>";

		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.querydept.submit();
	}
}

// To handle Null or Not an Object Exception.
function checkForNull(inString)
{
	return (trimCheck(inString))	?	inString	:	"";
}

// To get the Patient Valuables at the time of assigning bed to the admitted 
//	patient. The Patient Valuables get commited when pressing Asign Button.
async function showValuables()
{
		var retVal			=	"";
		var dialogTop		=	"130";
		var dialogHeight    =	"19.5" ;
		var dialogWidth		=	"50" ;
		var features		=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		=	"";
		var valubl			=	document.forms[0].valubles.value ;

		valubl += checkForNull(document.forms[0].recorded_by.value);
		valubl += "||"+checkForNull(document.forms[0].recorded_date.value);
		valubl += "||"+checkForNull(document.forms[0].valuble_remakrs.value);
		var url   = "../../eOP/jsp/PatientValuablesMain.jsp?encounterId="+document.forms[0].encounterId.value+"& patientId="+document.forms[0].p_patient_id.value +"&valuble="+escape(valubl);

		retVal = await window.showModalDialog(url,arguments,features);

		if(retVal != null)
		{
			if(retVal != "")
			{
				var contact_vals	= new Array();
				contact_vals		= retVal;
				var contacts		= contact_vals.split("||");

				document.forms[0].recorded_by.value		= contacts[0];
				document.forms[0].recorded_date.value	= contacts[1];
				document.forms[0].valuble_remakrs.value = contacts[2];
			}
		}
} // End of showValuables().
// By Annadurai end.

function checkFields1( fields, names) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck1(fields[i].value)) 
		{
		}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	if ( errors.length != 0 )
	{
		alert(errors) ;
		return false ;
	}
	return true ;
}
	
    
function fetchValForBedClass(obj)
{
	document.assign_bed.bed_no.value = "";
}

function trimCheck1(inString) 
{
	var startPos;
	var ch;
	startPos	= 0;
	strlength	= inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function populateDailyRate(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	var fields	= new Array(document.forms[0].bed_no);
    var names	= new Array(getLabel("Common.bedno.label","Common"));
	if (fields != "")
    if(SpecialCharCheck(fields,names,'',"A",'') )
    {
         var nursing_unit_code			=	document.forms[0].nursing_unit_code.value;
         var bed_no						=	document.forms[0].bed_no.value;
		 document.forms[0].bed_no.value	=	bed_no.toUpperCase();
		 bed_no							=	bed_no.toUpperCase();
		 var bed_code					=	document.forms[0].Bedcode.value;

		 if(bed_no != "" || document.forms[0].setup_bl_dtls_in_ip_yn.value=="Y")
         {   
             var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetchdailycharge' id='fetchdailycharge' method='post' action='../jsp/FetchDailyCharge.jsp'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value=\""+nursing_unit_code+"\"><input type='hidden' name='bed_no' id='bed_no' value=\""+bed_no+"\"><input type='hidden' name='bed_code' id='bed_code' value=\""+bed_code+"\"><input type='hidden' name='foc_obj' id='foc_obj' value=\""+eval(obj).name+"\">";
             HTMLVal = HTMLVal+"</form></body></html>";
			 
             parent.frames[2].document.write(HTMLVal);
			 parent.frames[2].document.fetchdailycharge.submit();
         }
     }
     else
     {
		
        document.forms[0].bed_no.select()
        document.forms[0].bed_no.focus()
     }
}


function ChkNumberInput1(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	
   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}


function check_bed_alcn_val(obj)
{
  if((obj.value!=null)&&(obj.value!=""))
	{
		if(obj.value == parent.frames[1].document.assign_bed.orig_blocked_bed_no.value)
		{
			parent.frames[1].document.assign_bed.bed_alloc_date_time.value = convertDate(parent.frames[1].document.assign_bed.admission_date_time.value,'DMYHM','en',localeName); //parent.frames[1].document.assign_bed.admission_date_time.value;

		}
		else
		{
			parent.frames[1].document.assign_bed.bed_alloc_date_time.value = convertDate(parent.frames[1].document.assign_bed.sdate.value,'DMYHM','en',localeName); //parent.frames[1].document.assign_bed.sdate.value;
		}
	}
	else
	{
		parent.frames[1].document.assign_bed.bed_alloc_date_time.value =  convertDate(parent.frames[1].document.assign_bed.sdate.value,'DMYHM','en',localeName);
		//parent.frames[1].document.assign_bed.sdate.value;
	}
}

async function showOtherAppointments()
{
	var patientId=assign_bed.p_patient_id.value;
	var retVal = 	new String();
	var dialogHeight= "19" ;
	var dialogWidth	= "65" ;
	var status = "no";
	var dialogTop = "265" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scrollWidth=yes; status: " + status+"; dialogTop :" + dialogTop ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentOther.jsp?patient_id="+patientId+"&calling_from=IP",arguments,features);
}

//Added by Sangeetha on 23/05/17 for GDOH-CRF-0151
function chkforVacantNormalBed(){
	var bed_no			  = document.forms[0].to_bed_no.value;
	var nursing_unit_code = document.forms[0].nursing_unit.value;
	var facility_id		  = document.forms[0].hddfacility.value;
	var Bedcode			  = document.forms[0].Bedcode.value;
	var bed_type		  = document.forms[0].Bedtype.value;

 if(bed_no!="" && nursing_unit_code!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\"  nursing_unit_code=\""+nursing_unit_code+"\" action='chkforVacantNormalBed' facility_id=\""+facility_id+"\" Bedcode=\""+Bedcode+"\" bed_type=\""+bed_type+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)

		if(responseText == "Y"){
			var msg = getMessage("RESTRICT_PSEUDO_BED","IP");
			alert(msg);
			document.forms[0].to_bed_no.value  ="";
			document.forms[0].to_room_no.value ="";
			document.forms[0].bed_avail_chart.focus();
		}
	}

}
/*Added for ML-MMOH-CRF-1527 on 23-JUN-2020 by KAMATCHI S*/

function calculateBmi() {
	
	var weight = document.forms[0].weight_on_admission.value;
	var height = document.forms[0].height_on_admission.value;
	var unit = document.forms[0].weight_on_admission_unit.value;
	var weight_in_grams=0;
	var finalBmi=0;
	if(weight=='')
	{
	weight=0;
	}
	if(height=='')
	{
	height=0;
	}

	if(unit=="G")
		{
		
		weight_in_grams=weight/1000;
		}
		
	if(Number(weight_in_grams > 0) && Number(height > 0))
		{	
	finalBmi = weight_in_grams/(height/100*height/100);
	
	}
	else if(Number(weight > 0) && Number(height > 0))
	{
		finalBmi = weight/(height/100*height/100);
	}

	document.forms[0].bmi.value=finalBmi.toFixed(2);
	
	
		}

/*Added for ML-MMOH-CRF-1527 on 23-JUN-2020 by KAMATCHI S END*/


