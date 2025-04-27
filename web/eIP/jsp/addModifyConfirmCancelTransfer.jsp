<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 	:	27/08/2001
	Module		:	ip
-->
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	ResultSet rset_practid		= null;
	Statement stmt1		= null;
	ResultSet rset1		= null;
	String facilityId	= (String)session.getAttribute("facility_id");

	
	try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	/*Following Code is to Check the Module with Billing Interface */
	String bl_interfaced_yn="";
	Statement stmt_bl =con.createStatement();
	ResultSet rs_bl=null;
	String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+facilityId+"'";
	try
	{
		rs_bl=stmt_bl.executeQuery(query_bl_interface);
		if(rs_bl.next())
		{
			bl_interfaced_yn=rs_bl.getString("bl_interfaced_yn");
		}
		if(rs_bl!=null) rs_bl.close();
		if(stmt_bl!=null) stmt_bl.close();
	}
	catch(Exception e)
	{
		out.println("Exception @try1"+e);
	}

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	
	<script src='../js/ConfirmCancelTransfer.js' language="javascript"></script>
    
	<script language="JavaScript">
	<!--


// By Annadurai 2/17/2004 starts.,. for Enhancement...  

override_yn = new Array();

function objChk(obj)
{
	if (obj.checked)
		document.forms(0).overrides.value = 'Y';
	else
		document.forms(0).overrides.value = 'N';
}

function setOverride(object)
{
	var i = object.selectedIndex;
	if (i > 0)
	{
			if(override_yn[i-1]=='Y')
			{
				document.all.overrides.checked = true;
				document.all.override.value = 'Y';							
			}
			else
			{
				document.all.overrides.checked = false;
				document.all.override.value = 'N';
			}
	}
	else
	{
		document.all.overrides.checked = false;
		document.all.override.value = 'N';
	}
}

function OffsetDate(sysdatetime,strPri1,strDftUnts1)
{
	
	var result = "";
	var days= strPri1;
	if(days!=''){
	var sysdate = sysdatetime.substring(0,10);
	var systime = sysdatetime.substring(11,16);
	
	/***building current date object from sysdate to avoid local machine date setting errors **/
	var dateArray = sysdate.split("/");
	sysdate1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]
	var tempdate = Date.parse(sysdate1);
	var currentDate=new Date(tempdate);

	var timeArray = systime.split(":");
	systime1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]+" "+timeArray[0]+":"+timeArray[1]
	var tempdatetime = Date.parse(systime1);
	var currentDateTime=new Date(tempdatetime);
	
	var dwm= strDftUnts1;
	var currentMonth=currentDate.getMonth();
	var presentDate=currentDate.getDate();
	var presentTime=currentDateTime.getHours();
			
	var finaldate;

		if(dwm=='D'){
			finaldate=presentDate+eval(days);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='W'){
			finaldate=presentDate+eval(days*7);
			currentDate.setDate(finaldate);
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
		else if(dwm=='H') {
			finaldate=presentTime+eval(days);
			currentDateTime.setHours(finaldate);
			result = currentDateTime.getDate()+"/"+eval(currentDateTime.getMonth()+1)+"/"+currentDateTime.getFullYear()+" "+currentDateTime.getHours()+":"+currentDateTime.getMinutes();
		}
		else{
			currentDate.setMonth(eval(currentMonth+eval(days)));
			result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
		}
	document.ConfirmCancelTransfer_form.pri_target.value = result;
	}
	else
	{
		document.ConfirmCancelTransfer_form.pri_target.value = "";
	}
	
	return result;
}

function getRoomNo(obj)
{
	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
		self.document.ConfirmCancelTransfer_form.to_room_no.value = '';	
		var nursingunit = self.document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
		var to_bed_no = self.document.ConfirmCancelTransfer_form.to_bed_no.value;
		var bedno = obj.value;
		var url = parent.frames(2).location.href;
		var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' method='post' action='../eIP/jsp/GetValidation.jsp'>"+
				" <input type='hidden' name='field1' value=''><input type='hidden' name='field2' value=''> "+
				" <input type='hidden' name='field3' value='"+nursingunit+"'><input type='hidden' name='field4' value='Emergency_form'><input type='hidden' name='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/GetValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Emergency_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no+"'></form></body></html>";
			}

		
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dum_form.submit();
		}
	}
}

function checkForBedNo()
{
	if (document.ConfirmCancelTransfer_form.to_bed_no.value=="")
		document.ConfirmCancelTransfer_form.to_room_no.value="";
} // End of checkForBedNo.

async function callBedAvailChart()
{

	var nursingunit = parent.frames[1].document.ConfirmCancelTransfer_form.to_nursing_unit_code.value;
	var practitionerid = parent.frames[1].document.ConfirmCancelTransfer_form.to_practitioner_id.value;
	var specialitycode = parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value;
	var bedclasscode = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.value;
	var gender = parent.frames[1].document.ConfirmCancelTransfer_form.patient_gender.value;
	var agevalue = parent.frames[1].document.ConfirmCancelTransfer_form.age.value;
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
	var dialogWidth = "1200px";
	var dialogTop	= "72";

	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN"; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			var arr1 = arr[1].split("/");
			parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no.value = arr1[0];

			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				parent.frames[1].document.ConfirmCancelTransfer_form.to_speciality_code.value=arr[10];
			}

			p = parent.frames[1].document.ConfirmCancelTransfer_form.Bedcode.options;
			for (i=0; i<p.options.length; i++) {
				if(p.options[i].value ==arr[3])
					p.options[i].selected = true;
			}

			
			if(arr[4] ==null )  	arr[4] ='';
			
			parent.frames[1].document.ConfirmCancelTransfer_form.to_room_no.value=arr[4];
			getRoomNo(parent.frames[1].document.ConfirmCancelTransfer_form.to_bed_no);
		}
	}

}
function specialChar(obj,val)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
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
// By Annadurai 2/17/2004 ends.,

function ComputeBlDtl()
{
	var fm_nur_code	=	document.forms[0].fr_nursing_unit_code;
	var to_nur_code	=	document.forms[0].to_nursing_unit_code;
	var fm_bed_no	=	document.forms[0].fr_bed_no;
	var to_bed_no	=	document.forms[0].to_bed_no;
	var fm_bed_class=	document.forms[0].fr_bed_class;
	var to_bed_class=	document.forms[0].to_bed_class;
	var trans_code	=	document.forms[0].transfer_type;
	var encount_id	=	document.forms[0].encounter_id;

	if(trans_code.value=="")
	{

		var	error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("eIP.TransferType.label","IP"));
		alert(error);					
		trans_code.focus();
		return false;
	}

	if(to_nur_code.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK','Common');
	error = error.replace('$',getLabel("Common.TransfertoNursingUnit.label","Common"));
	alert(error);					
		to_nur_code.focus();
		return false;
	}

	if(to_bed_class.value=="")
	{
	var error = getMessage('CAN_NOT_BE_BLANK','Common');
	error = error.replace('$',getLabel("Common.TransfertoBed.label","Common"));
	alert(error);					
	to_bed_class.focus();
	return false;
	}

	if(to_bed_no.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.TransfertoRoomCubicleNo.label","Common"));
		alert(error);					
		to_bed_no.focus();
		return false;
	}

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp' >"+
	"<input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'>"+
	"<input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'> "+
	"<input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
	"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
	"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
	"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
	"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
	"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
	"</form></body></html>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.BLBedTrans.submit();
}
	</script>
</head>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	String patientid		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String eid					= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	long    encounterid	= Long.parseLong(eid);
	String bookingrefno = request.getParameter("booking_ref_no") == null ? "" : request.getParameter("booking_ref_no");
	String fromfunction = request.getParameter("fromFunction")==null?"":request.getParameter("fromFunction");

	StringBuffer sql	= new StringBuffer();
		String admissiondate			= "";
	String admissiontype			= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	String frpractitionerid			= "";
	String frpractdesc			= "";
	String frspecialitycode			= "";
	String frspecialitydesc			= "";
	String frbedclass			= "";
	String frbedclassdesc			= "";
	String frnursingunitcode		= "";
	String frnursingunitdesc		= "";
	String frbedno				= "";
	String frroomno				= "";
	String frbedtype			= "";
	int	    frdailycharge		= 0;
	String tobedclass			= "";
	String tobedclassdesc			= "";
	String tonursingunitcode		= "";
	String tonursingunitdesc		= "";
	String tonursingunittype		= "";
	String tobedno				= "";
	String toroomno				= "";
	String tobedtype			= "";
	int	    todailycharge		= 0;
	String bookingdatetime			= "";
	String gender				= "";
	String medteamdesc 			= "";
	String allow_transfer_yn 			= "Y";
	String billing_group_id = "";
	String billing_group_desc = "";

	// By Annadurai 2/17/2004 starts.,
	String age				 = "";
	String priority			 = "";
	String default_priority	 = "";
	String max_priority		 = "";
	String sysDate		 = "";
	String disable		 = "";
	String check		 = "";

	String bl_operational =	(String)session.getAttribute("bl_operational");
	try
	{		
			
			// By Annadurai 2/17/2004., age is added in the select list(after gender).
			sql.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date,admission_type,");
			sql.append(" admission_short_desc,fr_nursing_unit_code,fr_nursing_unit_short_desc, ");
			sql.append(" specialty_code, specialty_short_desc,practitioner_id,");
			sql.append(" practitioner_name,fr_room_no,fr_bed_no,");
			sql.append(" fr_bed_class_code,fr_bed_class_short_desc, ");
			sql.append(" '' fr_daily_charge, fr_bed_type_code,gender, ");
			sql.append(" to_bed_class_code,to_bed_class_short_desc,to_nursing_unit_to_code,");
			sql.append(" to_nursing_unit_short_desc,");
			sql.append(" to_room_no,to_bed_no,to_bed_type_code,'' to_daily_charge,to_nursing_unit_locn_type, ");
			sql.append(" transfer_type,transfer_type_short_desc,to_char(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, priority ");
			sql.append(" FROM  ip_bed_booking_tfr_vw ");
			sql.append(" WHERE facility_id = '"+facilityId+"' and encounter_id = "+encounterid );
			rset		= stmt.executeQuery(sql.toString());
			if(rset.next())
			{
				admissiondate			= rset.getString("admission_date") ==null ? "": rset.getString("admission_date");  
				admissiontype			= rset.getString("admission_short_desc") ==null ? "": rset.getString("admission_short_desc");
				frpractitionerid		= rset.getString("practitioner_id") ==null ? "": rset.getString("practitioner_id");                         
				frpractdesc			= rset.getString("practitioner_name") ==null ? "": rset.getString("practitioner_name");    
				frspecialitycode		= rset.getString("specialty_code") ==null ? "": rset.getString("specialty_code");                         
				frspecialitydesc		= rset.getString("specialty_short_desc") ==null ? "": rset.getString("specialty_short_desc");            
				frbedclass			= rset.getString("fr_bed_class_code") ==null ? "": rset.getString("fr_bed_class_code");                        
				frbedclassdesc			= rset.getString("fr_bed_class_short_desc") ==null ? "": rset.getString("fr_bed_class_short_desc");          
				frnursingunitcode		= rset.getString("fr_nursing_unit_code") ==null ? "": rset.getString("fr_nursing_unit_code");                  
				frnursingunitdesc		= rset.getString("fr_nursing_unit_short_desc") ==null ? "": rset.getString("fr_nursing_unit_short_desc");     
				frbedno				= rset.getString("fr_bed_no") ==null ? "": rset.getString("fr_bed_no");                                           
				frroomno			= rset.getString("fr_room_no") ==null ? "": rset.getString("fr_room_no");                                       
				frbedtype			= rset.getString("fr_bed_type_code") ==null ? "": rset.getString("fr_bed_type_code");                           
				gender				= rset.getString("gender");
				priority = rset.getString("priority")==null?"":rset.getString("priority");
				tobedclass			= rset.getString("to_bed_class_code") ==null ? "": rset.getString("to_bed_class_code");                        
				tobedclassdesc			= rset.getString("to_bed_class_short_desc") ==null ? "": rset.getString("to_bed_class_short_desc");          
				tonursingunitcode		= rset.getString("to_nursing_unit_to_code") ==null ? "": rset.getString("to_nursing_unit_to_code");                  
				tonursingunitdesc		= rset.getString("to_nursing_unit_short_desc") ==null ? "": rset.getString("to_nursing_unit_short_desc");     
				tonursingunittype		= rset.getString("to_nursing_unit_locn_type") ==null ? "": rset.getString("to_nursing_unit_locn_type");     
				tobedno				= rset.getString("to_bed_no") ==null ? "": rset.getString("to_bed_no");                                           
				toroomno			= rset.getString("to_room_no") ==null ? "": rset.getString("to_room_no");                                       
				tobedtype			= rset.getString("to_bed_type_code") ==null ? "": rset.getString("to_bed_type_code");                           
				trntypecode			= rset.getString("transfer_type") ==null ? "": rset.getString("transfer_type");                                       
				trntypedesc			= rset.getString("transfer_type_short_desc") ==null ? "": rset.getString("transfer_type_short_desc");  
				bookingdatetime     		= rset.getString("booking_date_time")==null?"":rset.getString("booking_date_time");
		}
			if(rset!=null) rset.close();
		
			if (priority.equals("P1"))
			{
				String sqlQuery = "select  TO_CHAR(SYSDATE,'dd/mm/rrrr hh24:mi') system_date , DFLT_UNIT_PRIORITY_1, MAX_PERIOD_PRIORITY_1 from ip_param, dual  where facility_id = '"+facilityId+"' ";
	
				rset_practid		= stmt.executeQuery(sqlQuery);
				if(rset_practid != null)
				{
					while(rset_practid.next())
					{
						sysDate			 = rset_practid.getString("system_date");
						default_priority = rset_practid.getString("DFLT_UNIT_PRIORITY_1");
						max_priority     = rset_practid.getString("MAX_PERIOD_PRIORITY_1");
					}
			if(rset_practid!=null) rset_practid.close();
				}
				disable = "disabled";
				check = "checked";

			}

			if(sql.length() > 0)
				sql.delete(0, sql.length());

			sql.append(" SELECT a.req_practitioner_id, b.practitioner_name, a.REQ_SPECIALTY_CODE specialty_code, c.SHORT_DESC specialty_short_desc FROM ip_bed_booking a, am_practitioner  b, am_speciality c WHERE a.facility_id = '"+facilityId+"'  and a.req_practitioner_id = b.practitioner_id AND  a.REQ_SPECIALTY_CODE = c.speciality_code AND a. encounter_id= "+encounterid+" AND a.booking_status = '0' ");

			rset_practid		= stmt.executeQuery(sql.toString());
			if(rset_practid != null)
			{
				while(rset_practid.next())
				{
					frpractitionerid = rset_practid.getString("REQ_PRACTITIONER_ID");
					if(frpractitionerid == null)
					{
						frpractitionerid = "";
					}
					frpractdesc			= rset_practid.getString("practitioner_name") ==null ? "": rset_practid.getString("practitioner_name"); 

					frspecialitycode		= rset_practid.getString("specialty_code") ==null ? "": rset_practid.getString("specialty_code");                         
					frspecialitydesc		= rset_practid.getString("specialty_short_desc") ==null ? "": rset_practid.getString("specialty_short_desc");            
				
				}
			if(rset_practid!=null) rset_practid.close();
			if(stmt!=null) stmt.close();
			}

		String medsql = " Select team_short_desc from am_pract_for_team_vw  where facility_id = '"+facilityId+"' and Team_Id = (select to_pract_team_id from ip_adt_trn where to_practitioner_id='"+frpractitionerid+"' and trn_type='A' and encounter_id='"+encounterid+"' and facility_id = '"+facilityId+"' ) ";
			stmt1 = con.createStatement();
			rset1 = stmt1.executeQuery(medsql);
			if(rset1 != null)
			{	
				if(rset1.next())
				{
					medteamdesc = rset1.getString(1);
					if(medteamdesc == null) medteamdesc ="";
				}			
				if(rset1!=null) rset1.close();
			}	
			
			// added by senthil (28/8/2k3)
		
		if(bl_operational.equals("Y"))
		{
			String bl_elig = "select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+encounterid+"'";
			rset1 = stmt1.executeQuery(bl_elig);
			while(rset1.next())
			{
				billing_group_id = rset1.getString("BLNG_GRP_ID");
				billing_group_desc = rset1.getString("SHORT_DESC");
			}
				if(rset1!=null) rset1.close();
		}
						String sql16 = " select install_yn from sm_module where module_id = 'FM' ";
						String fm_install_yn = "";
						String transfter_file_yn ="";
						String auto_file_transfer_yn ="";
						String fm_fs_locn_code="";
						String file_no="";
						rset1 = stmt1.executeQuery(sql16);
						if (rset1!=null && rset1.next())
							fm_install_yn = rset1.getString(1);
							if(rset1!=null) rset1.close();
						if (fm_install_yn.equals("Y")){
							sql16 = "Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id ='"+facilityId+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
							{
								transfter_file_yn = rset1.getString(2);
							}
							if(rset1!=null) rset1.close();
						if (transfter_file_yn.equals("Y")){
							sql16 = "select file_no from mr_pat_file_index where facility_id ='"+facilityId+"' and patient_id ='"+patientid+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
								file_no  = rset1.getString(1);
							if(rset1!=null) rset1.close();
							if (file_no==null) file_no="";
							sql16 = "Select a.auto_file_transfer_yn,a.fs_locn_code,b.locn_identity from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id ='"+facilityId+"' and a.nursing_unit_code='"+frnursingunitcode+"'";
						    rset1 = stmt1.executeQuery(sql16);
							if (rset1!=null && rset1.next())
							{
								auto_file_transfer_yn = rset1.getString(1);
								fm_fs_locn_code		  = rset1.getString(2);
								if (fm_fs_locn_code==null) fm_fs_locn_code="";
								if(rset1!=null) rset1.close();
							}
							if (fm_install_yn.equals("Y")&&transfter_file_yn.equals("Y")
								&&auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!=""&&file_no!=""){
									sql16 = "Select count(1) from fm_transit_file where  facility_id ='"+facilityId+"' and file_no='"+file_no+"'";
						    rset1 = stmt1.executeQuery(sql16);
							int cnt=0;
							if (rset1!=null && rset1.next())
								cnt =rset1.getInt(1);
								if(rset1!=null) rset1.close();
							if(cnt==0)
								allow_transfer_yn="Y";
							else								
								allow_transfer_yn="N";
							}
						}
				}



	%>
	<form name="ConfirmCancelTransfer_form" id="ConfirmCancelTransfer_form"  method="post" action="../../servlet/eIP.ConfirmCancelTransferServlet" target=_top>
	<!--<br>-->
	<table border=0 width="100%" cellpadding=6 cellspacing=0>
		<tr>
			<td align="right" class="label" width="25%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;</td>
			 <td width="35%" class='querydata'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate%></td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td width="25%" class='querydata'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiontype%></td> 
		</tr>

		<tr>
			<td align="right" class="label" width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata' width="35%" ><%=frpractdesc%>
				<input type="hidden" name="to_practitioner_id" id="to_practitioner_id" value="<%=frpractitionerid%>">
			</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata' width="25%"><%=frspecialitydesc%>
				<input type="hidden" name="to_speciality_code" id="to_speciality_code" value="<%=frspecialitycode%>">
			</td>
		</tr>
		<tr>
			<td align="right" class="label" width="25%"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata' width="35%" colspan='3'><%=medteamdesc%>				
			</td>
		</tr>


		<tr>
			<td align="right" class="label" width="25%" nowrap><fmt:message key="eIP.TransferBookingDate.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td class='querydata' width="35%"><%=bookingdatetime%><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=bookingdatetime%>"></td>
			<td align="right" class="label" width="15%"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td class='querydata' width="25%"><%=trntypedesc%>
				<input type="hidden" name="transfer_type" id="transfer_type" value="<%=trntypecode%>">
			</td>
		</tr>
	</table>

	<!--<br>-->

	<table border=0 width="100%" cellpadding=6 cellspacing=0>
		<tr>
				<th colspan=2 width="50%"><fmt:message key="eIP.CurrentOccupancy.label" bundle="${ip_labels}"/></th>
				<th colspan=2 width="50%"><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></th>
		</tr>

		<tr>
			<td align="right" class="label" width="25%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
			<td width="25%" class='querydata'><%=frnursingunitdesc%>
				<input type="hidden" name="fr_nursing_unit_code" id="fr_nursing_unit_code" value="<%=frnursingunitcode%>">
			</td>
			<td align="right" class="label" width="25%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
			<td width="25%" class='querydata'><%=tonursingunitdesc%>
				<input type="hidden" name="to_nursing_unit_code" id="to_nursing_unit_code" value="<%=tonursingunitcode%>">
			</td>
		</tr>

		<tr>
			<td align="right" class="label"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata'><%=frbedclassdesc%>
				<input type="hidden" name="fr_bed_class" id="fr_bed_class" value="<%=frbedclass%>" >
			</td>
			<td align="right" class="label"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</td>
<!-- 		By Annadurai 2/17/2004.,	
			<td class='querydata'><%=tobedclassdesc%>
				<input type="hidden" name="to_bed_class" id="to_bed_class" value="<%=tobedclass%>" >
			</td> -->
    <TD class='querydata' >
	<select name='Bedcode' id='Bedcode'><option value='' selected >---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---

<%
	try{
		stmt = con.createStatement();
	    String sql2="Select bed_class_code,short_desc from ip_bed_class where eff_status='E' order by short_desc ";
	    rset = stmt.executeQuery(sql2);
            
            if( rset != null )
            {
	      while( rset.next() )
	      {
		 String bedcode   = rset.getString(1) ;
		 String beddesc   = rset.getString(2) ;

%>
	 	 <OPTION VALUE="<%=bedcode%>" ><%=beddesc%>
<%            }
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
	    }
	}catch(Exception e) {out.println(e.toString());}
	
%>
</select>           
	<input type="hidden" name="to_bed_class" id="to_bed_class" value="<%=tobedclass%>" >
    <!-- <jsp:include page="BedClassComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include> -->
     <img src='../../eCommon/images/mandatory.gif'align='center'></img>
</td>
		</tr>

		<tr>
			<td align="right" class="label"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata'><input type="hidden" name="fr_bed_no" id="fr_bed_no" value="<%=frbedno%>" > <%=frbedno%></td>
			<td align="right" class="label"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</td>
<!-- By Annadurai 2/17/2004., 
		<td class='querydata'><input type="hidden" name="to_bed_no" id="to_bed_no" value="<%=tobedno%>" ><%=tobedno%> </td> -->
		<TD class='querydata' >
				<input type="text" name="to_bed_no" id="to_bed_no" size=8 maxlength=8 onBlur="ChangeUpperCase(this),getRoomNo(this),checkForBedNo();" onKeyPress='return CheckForSpecChars(event)'><input type="button" class="button" value="?" onclick="callBedAvailChart();">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
		
			</td>

		</tr>

		<tr>
			<td align="right" class="label"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='querydata'><input type="hidden" name="fr_room_no" id="fr_room_no" value="<%=frroomno%>" > <%=frroomno%> </td>
			<td align="right" class="label"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;</td>
<!-- 			<td class='querydata'><input type="hidden" name="to_room_no" id="to_room_no" value="<%=toroomno%>" ><%=toroomno%> </td> -->
				<TD class='querydata' ><input type="text" name="to_room_no" id="to_room_no" size=10 maxlength=10 readonly onBlur="specialChar(this,'Char')"></TD>
		</tr>
	<%
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    String sqlBlkType ="Select blocking_type_code,short_desc,override_yn from ip_blocking_type where eff_status ='E' order by 2";
	    rset  = stmt .executeQuery(sqlBlkType );
		int indexForBlkType = 0;
	%>

				<tr>
					<td class='label' align='right'><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/>&nbsp;</td>
					<td>
						<!--<jsp:include page="BlockTypeComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>-->
						
						<select name='blocktype' id='blocktype' onChange="setOverride(this)"><option value='' selected>&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- &nbsp;</option>
						<%
						while( rset.next() ){
								String code   = rset.getString(1) ;
								String desc   = rset.getString(2) ;								

						%>
						 <OPTION VALUE="<%=code%>" ><%=desc%></option>
						<% }
							if(rset!=null) rset.close();
						%>
						</select>						
						<img src='../../eCommon/images/mandatory.gif'></img>  
					</td>
					<script>
					<%	
						rset.beforeFirst();
						while(rset.next()){
							String str = rset.getString(3);
							%>
							  override_yn[<%=indexForBlkType%>]="<%=str%>";
							<%
							indexForBlkType++;
						}

						rset  = stmt.executeQuery("Select BED_BLOCK_PERIOD_MAX from ip_param where facility_id='"+facilityId+"'");
						if(rset.next())
						{
						}
							if(rset!=null) rset.close();
							if(stmt!=null) stmt.close();
					%>
					</script>
					<td class='label' align='right'><fmt:message key="Common.override.label" bundle="${common_labels}"/>&nbsp;</td>
					<td>
						<input type='checkbox'  name='overrides' id='overrides' value="N" <%=disable%> <%=check%> onClick="	objChk(this)" >
						 <input type="hidden" name=override value="Y">
					</td>
				</tr>
			
<!-- commented by kumar on 14/2/02 required only when bl is interfaced which will be done later-->
<!--		<tr>
			<td align="right" class="label">Daily Rate&nbsp;&nbsp;</td>
			<td class='querydata'><input type="hidden" name="fr_daily_rate" id="fr_daily_rate" value="<%=frdailycharge%>" ><%=frdailycharge%></td>
			<td align="right" class="label">Daily Rate&nbsp;&nbsp;</td>
			<td class='querydata'><input type="hidden" name="to_daily_rate" id="to_daily_rate" value="<%=todailycharge%>" ><%=todailycharge%></td>
		</tr>
-->
		<tr>
			<td colspan=4>&nbsp;</td>
		</tr>
	</table>	

	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">
	<input type="hidden" name="confirm_or_cancel" id="confirm_or_cancel" value="">
	<input type="hidden" name="booking_ref_no" id="booking_ref_no" value="<%=bookingrefno%>">
	<input type="hidden" name="patient_gender" id="patient_gender" value="<%=gender%>">

	<!-- By Annadurai 2/17/2004 starts., -->
	<input type="hidden" name="age" id="age" value="<%=age%>" >
	<input type="hidden" name="continue_yn" id="continue_yn" > 
	<input type="hidden" name="pri_target" id="pri_target">
	<input type="hidden" name="priority_value" id="priority_value" value="<%=priority%>" >
	<!-- By Annadurai 2/17/2004 ends., -->

	<input type="hidden" name="to_nursing_unit_type" id="to_nursing_unit_type" value="<%=tonursingunittype%>">
	<input type="hidden" name="to_bed_type" id="to_bed_type" value="<%=tobedtype%>">

	<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
	<input type="hidden" name="allow_transfer_yn" id="allow_transfer_yn" value="<%=allow_transfer_yn%>">
	 <input type="hidden" name="fr_daily_rate" id="fr_daily_rate" value="0">
	 <input type="hidden" name="to_daily_rate" id="to_daily_rate" value="0">
	 <input type="hidden" name="bill_type_code" id="bill_type_code" value="">
	<input type="hidden" name="blng_class_code" id="blng_class_code" value="">
	<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">

	 <!-- added by senthil (28/8/2k3)  -->
	<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value="">
	<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
<input type='hidden' name='bl_operational' id='bl_operational' value="<%=bl_operational%>">	
	<!-- added by senthil (28/8/2k3) ends  -->

	<%
	if(bl_interfaced_yn.equals("Y"))
	{
	%>
		<!-- START MODIFICATION BY ARUN -->
			<!-- MOD#02 Introduced the following hidden item corresponding to the commented billing -->
				<input type="hidden" name="transfer_chargeable_yn" id="transfer_chargeable_yn" value="">
				<input type="hidden" name="transfer_serv_charge" id="transfer_serv_charge" value="">
				<input type="hidden" name="surgery_reqd_yn" id="surgery_reqd_yn" value="">
				<input type="hidden" name="addnl_dep_amt" id="addnl_dep_amt" value="">
			<!-- Commented out billing completely 
			<!-- MOD#01  Commented
				<table border=0 width="100%" cellpadding=1 cellspacing=0>
				<th colspan='4' align='center'>Billing Details</th>
				<tr>
					<td align="right" class="label" width="25%" nowrap>Transfer Chargeable&nbsp;&nbsp;</td>
					<td class='querydata' ><input type='checkbox' name='transfer_chargeable_yn' id='transfer_chargeable_yn' value='Y' disabled ></td>
					<td align="right" class="label"  nowrap>Transfer Charge&nbsp;</td>
					<td class='querydata' ><input type='text' style='text-align:right' name='transfer_serv_charge' id='transfer_serv_charge' value='' size='10' maxlength='10' readonly></td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap>Additional Deposit Required&nbsp;&nbsp;</td>
					<td class='querydata'><input type='checkbox' name='surgery_reqd_yn' id='surgery_reqd_yn' value='Y' disabled></td>
					<td align="right" class="label" nowrap>Additional Deposit Amount&nbsp;</td>
					<td class='querydata' ><input type='text' style='text-align:right' name='addnl_dep_amt' id='addnl_dep_amt' value='' size='10' maxlength='10' readonly></td>
				</tr>
				</table>
				End of MOD#01
			-->	
		<!-- END MODIFICATION BY ARUN -->
	<%
	}
	%>	
	<br>
	<%if(!fromfunction.equals("Q")){%>
	<table border=0 width="30%" cellpadding=0 cellspacing=0 align="right">
	<tr>
		<% if(bl_interfaced_yn.equals("Y")) {%><td>
		<!-- START MODIFICATION BY ARUN -->
			<!-- MOD#03 Commented out the button Compute TO HIDDEN-->
			<!-- <input type="button" class="button" value="Compute" onclick="ComputeBlDtl();"></td>  -->
			<!-- <input type="hidden" class="button" value="Compute" onclick="ComputeBlDtl();"> --></td> <%}%>
		<!-- END MODIFICATION BY ARUN -->
		
		<td><input type="button" class="button" name = "confirm" value="Confirm Booking Transfer" onclick="OffsetDate('<%=sysDate%>', '<%=max_priority%>', '<%=default_priority%>');submitForm('CONFIRM');"></td>
		<td><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelTransfer.label","common_labels")%>" onclick="OffsetDate('<%=sysDate%>', '<%=max_priority%>', '<%=default_priority%>'); submitForm('CANCEL');"></td>
		<td><input type="button" class="button" value="Close" onclick="parent.window.close();"></td>
	</tr>
	</table>
	<%
	}
		if(rset		!= null)   rset.close();
		if(rs_bl	!= null)   rs_bl.close();
												   
		if(stmt1   != null)   stmt1.close();
		if(rset1   != null)   rset1.close();
		if(stmt   != null)   stmt.close();
		if(stmt_bl   != null)   stmt_bl.close();

	}catch(Exception e){
		out.print("Exception :"+e);
	}

}catch(Exception e){}
finally
{
	ConnectionManager.returnConnection(con,request);
	
}
	 %>
</form>	 
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

