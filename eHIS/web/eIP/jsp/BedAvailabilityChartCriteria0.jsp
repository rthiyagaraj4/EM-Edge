<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String age				= "";
	String call_function	= checkForNull(request.getParameter("call_function"));
	String main_bed_no		= checkForNull(request.getParameter("main_bed_no"));
	String call_func  		= checkForNull(request.getParameter("P_call_func"));
	String nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String enable_bed_date	= checkForNull(request.getParameter("enable_bed_date"),"N");
	String reserve_bed_selectable	= checkForNull(request.getParameter("reserve_bed_selectable"),"N");
	//String practitionerid	= checkForNull(request.getParameter("practitioner_id"));
	String ipparam_bed_yn	= checkForNull(request.getParameter("ipparam_bed_yn"));
	String practitioner_desc= checkForNull(request.getParameter("practitioner_desc"));
	String specialitycode	= checkForNull(request.getParameter("speciality_code"));
	String bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String bed_type			= checkForNull(request.getParameter("bed_type"));
	String agevalue			= checkForNull(request.getParameter("age_value"));
	//String gender			= checkForNull(request.getParameter("gender"));
	String disable_field 	= checkForNull(request.getParameter("disable_field"));
	String patient_class 	= checkForNull(request.getParameter("patient_class"));
	String bedClass_dis_yn 	= checkForNull(request.getParameter("bedClass_dis_yn"));
	String room_no_code 	= checkForNull(request.getParameter("room_no_code"));
	String med_service_grp 	= checkForNull(request.getParameter("med_service_grp"));
	String create_booking_admission_date_time 	= checkForNull(request.getParameter("create_booking_admission_date_time"));
	String exp_discharge_date 	= checkForNull(request.getParameter("exp_discharge_date"));
	String bed_booking_ref_no 	= checkForNull(request.getParameter("bed_booking_ref_no"));


	String wherecondn 		= checkForNull(request.getParameter("wherecondn"));
	int sm_cntl_assign_bed_count=0;

	if(wherecondn.equals("")) 
		wherecondn = "ADMIT_PAT_YN";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String curdate = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" );
	java.util.Date dt=new java.util.Date();
	curdate = dateFormat.format( dt ) ;


%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript' ></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function setGroupBy(spclty)
{
	
	if(spclty.value != '')
	{
		document.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;
		
		var val_id	= new Array();
		val_id[0] = "specialty_short_desc";
		val_id[1] = "bed_type_short_desc";
		val_id[2] = "room_long_desc";
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val_id[3] = "admission_type";
		var val		= new Array();
		val[0] = getLabel("Common.speciality.label","Common");
		val[1] = getLabel("Common.bedtype.label","Common");
		val[2] = getLabel("Common.RoomCubicle.label","Common");
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val[3] = getLabel("Common.admissiontype.label","Common");


		removeitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );
		removeitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			removeitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );
		
			for ( var i=0; i<val_id.length; i++ )
			{
				var element		  = document.createElement("option");
					element.value = val_id[i];
					element.text  =	val[i];
				document.BedAvailabilityChart_Form0.BedListinOrder2.add(element)
			}
			document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
			document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;
			document.BedAvailabilityChart_Form0.BedListinOrder3.disabled =	true;
			if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
				document.BedAvailabilityChart_Form0.BedListinOrder4.disabled =	true;
			if(document.forms[0].sm_cntl_assign_bed_count.value>0 ){
				document.forms[0].BedListinOrder1.options[3].selected = true;
				getBedListinOrder(document.forms[0].BedListinOrder1);
			}
	}	
	else
	{
		document.forms[0].BedListinOrder1.options[0].selected = true;
		document.forms[0].BedListinOrder2.options[0].selected = true;
		document.forms[0].BedListinOrder2.disabled = true;
	}
}

var calledoption;
function cancelAction()
{
	if(parent.criteria0.document.forms[0].call_func.value == 'ADMIT')
	{
		parent.location.href = '../jsp/PaintAdmitPatient.jsp?P_call_func=ADMIT';
	}
	else
	{
		parent.parent.document.getElementById("dialog_tag").close(); 
	}
}

// This function will clear all the criteria values except the Nusring Unit Value if that's Disabled.
function clearCriteria()
{
	parent.result.location.href ='../../eCommon/html/blank.html';
	var bedClass_dis_yn = "<%=bedClass_dis_yn%>";
	var patient_class = "<%=patient_class%>";
	var bed_yn="<%=ipparam_bed_yn%>";

	if ("<%=disable_field%>"=="NursingUnit")
	{
		if(bed_yn=="Y")
		{
			
			document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&disable_field=<%=disable_field%>&nursing_unit_code=<%=nursingunitcode%>&patient_class=<%=patient_class%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&call_function=<%=call_function%>&main_bed_no=<%=main_bed_no%>&oper_stn_id=<%=oper_stn_id%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&patient_id=<%=patient_id%>&reserve_bed_selectable=<%=reserve_bed_selectable%>';
		}
		else
		{
			
			document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&disable_field=<%=disable_field%>&nursing_unit_code=<%=nursingunitcode%>&patient_class=<%=patient_class%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&main_bed_no=<%=main_bed_no%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&patient_id=<%=patient_id%>&reserve_bed_selectable=<%=reserve_bed_selectable%>';
		}
	}/*Friday, February 12, 2010 IN000242(emergency release),Nursing unit list item getting enable from Bed for Nursing Unit function*/
	else if ("<%=disable_field%>"=="Nursing" )
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?call_function=<%=call_function%>&disable_field=<%=disable_field%>&nursing_unit_code=<%=nursingunitcode%>&P_call_func=<%=call_func%>&oper_stn_id=<%=oper_stn_id%>';
	}
	else if ("<%=disable_field%>"=="NursingUnitSpecialty" )
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&call_function=<%=call_function%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&disable_field=<%=disable_field%>&nursing_unit_code=<%=nursingunitcode%>&patient_class=<%=patient_class%>&speciality_code=<%=specialitycode%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&oper_stn_id=<%=oper_stn_id%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&exp_discharge_date=<%=exp_discharge_date%>&create_booking_admission_date_time=<%=create_booking_admission_date_time%>&patient_id=<%=patient_id%>';
	}
	else if("<%=disable_field%>"=="specialty")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&call_function=<%=call_function%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&disable_field=<%=disable_field%>&patient_class=<%=patient_class%>&speciality_code=<%=specialitycode%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&oper_stn_id=<%=oper_stn_id%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&exp_discharge_date=<%=exp_discharge_date%>&create_booking_admission_date_time=<%=create_booking_admission_date_time%>&patient_id=<%=patient_id%>';
	}
	else if (disable_field == "NuBcBt")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&P_call_func=<%=call_func%>&disable_field=<%=disable_field%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&patient_class=<%=patient_class%>&med_service_grp=<%=med_service_grp%>&nursing_unit_code=<%=nursingunitcode%>&bed_class_code=<%=bedclasscode%>&bed_type=<%=bed_type%>&room_no_code=<%=room_no_code%>&patient_id=<%=patient_id%>';
	}
	else if (disable_field == "NuSyBcBt")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&P_call_func=<%=call_func%>&disable_field=<%=disable_field%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&patient_class=<%=patient_class%>&med_service_grp=<%=med_service_grp%>&nursing_unit_code=<%=nursingunitcode%>&speciality_code=<%=specialitycode%>&bed_class_code=<%=bedclasscode%>&bed_type=<%=bed_type%>&room_no_code=<%=room_no_code%>&patient_id=<%=patient_id%>';
	}
	else if (disable_field == "SyBcBt")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&P_call_func=<%=call_func%>&disable_field=<%=disable_field%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&patient_class=<%=patient_class%>&med_service_grp=<%=med_service_grp%>&speciality_code=<%=specialitycode%>&bed_class_code=<%=bedclasscode%>&bed_type=<%=bed_type%>&room_no_code=<%=room_no_code%>&patient_id=<%=patient_id%>';
	}
	else if (disable_field == "BcBt")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&P_call_func=<%=call_func%>&disable_field=<%=disable_field%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&patient_class=<%=patient_class%>&med_service_grp=<%=med_service_grp%>&bed_class_code=<%=bedclasscode%>&bed_type=<%=bed_type%>&room_no_code=<%=room_no_code%>&patient_id=<%=patient_id%>';
	}
	else if(bed_yn=="Y")
	{
		
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&disable_field=<%=disable_field%>&nursing_unit_code=<%=nursingunitcode%>&patient_class=<%=patient_class%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&bed_class_code=<%=bedclasscode%>&bed_type=<%=bed_type%>&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&patient_id=<%=patient_id%>';
	}
	else
	{
		document.location.href ='../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=<%=wherecondn%>&patient_class=<%=patient_class%>&bedClass_dis_yn=<%=bedClass_dis_yn%>&speciality_code=<%=specialitycode%>&room_no_code=<%=room_no_code%>&call_function=<%=call_function%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&oper_stn_id=<%=oper_stn_id%>&P_call_func=<%=call_func%>&med_service_grp=<%=med_service_grp%>&patient_id=<%=patient_id%>';
	}
}


function specialChar(obj)
{
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(CheckNum(obj))
			{
				 return true;
			}
			else 
			{
				 obj.focus();
				 return false;
			}
		}
		else
		{
			obj.focus();
			return false;
		}
	}
}

			
function getCheckValue(obj)
{
	if (obj.checked)
		 obj.value =  "Y";
	else obj.value =  "N";
}

			
function submitPage(frm,calledoption)
{
	
	var chk_string = "";
	var nursing_unit = document.forms[0].nursing_unit.value;
	var speciality = document.forms[0].Splcode.value;
	var Practitioner =  document.forms[0].practid.value;

	var bed_class = document.forms[0].Bedcode.value;
	var bed_type = document.forms[0].bed_type_code.value;
	var gender = document.forms[0].gender.value;
	var age = document.forms[0].age_value.value;

	var gender_type="";

	if(document.forms[0].gender_type[0].checked==true)
		gender_type	=	document.forms[0].gender_type[0].value;
	else if(document.forms[0].gender_type[1].checked==true)
		gender_type	=	document.forms[0].gender_type[1].value;
	//
	
	
/*
	if(nursing_unit != "")
		chk_string = chk_string + '*';

	if(speciality != "")
		chk_string = chk_string + '*';

	if(Practitioner != "")
		chk_string = chk_string + '*';

	if(bed_class != "")
		chk_string = chk_string + '*';

	if(bed_type != "")
		chk_string = chk_string + '*';

	if(gender != "")
		chk_string = chk_string + '*';

	if(age != "")
		chk_string = chk_string + '*';

	var arr = chk_string.split("*");
*/
	if(nursing_unit == "" && speciality == "")
	{
		parent.frames[2].document.location.href = "../../eCommon/html/blank.html";
		alert(getMessage('NU_OR_SPCLTY',"IP"));
	}
	else if(document.forms[0].from_date.value == "" && document.forms[0].to_date.value != "")
	{
		var error1 = getMessage('GENERAL_CNT_BE_BLANK','IP');
		error1 = error1.replace('$',getLabel("Common.fromdate.label","common"));
		alert(error1);
	}
	else if(document.forms[0].from_date.value != "" && document.forms[0].to_date.value == "")
	{
		var error2 = getMessage('GENERAL_CNT_BE_BLANK','IP');
		error2 = error2.replace('$',getLabel("Common.todate.label","common"));
		alert(error2);
	}
	else
	{
		var fields = new Array();	
		fields[0] = document.forms[0].nursing_unit;
		var names = new Array (getLabel('Common.nursingUnit.label','common'));
		var params = "";
		for( var i=0; i<frm.elements.length; i++ )
		{
			params += frm.elements[i].name + "=" + escape(frm.elements[i].value) +"&";
		}

		var avail_nursing_unit = document.forms[0].available_nursing_unit.value;
		if(document.forms[0].nursing_unit.value == "")
			avail_nursing_unit = "";

		var obj = frm.available_nursing_unit
		var len=obj.length;
		var i=1;
		var n_code	=	frm.nursing_unit.value;

		while(i<len)
		{
			len=obj.length
			obj.remove(i)
		}
		// Added by Nanda 02/10/2002 
		var wherecondn= document.forms[0].wherecondn.value;
		var nursing_unit= document.forms[0].nursing_unit.value;
		var bed_classification=document.forms[0].bed_classification.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		parent.result.document.location.href = "../../eCommon/html/blank.html";
		parent.processBar.document.location.href = "../../eCommon/html/process.html";
		document.forms[0].nursing_unit.disabled = true;
		document.forms[0].Splcode.disabled = true;
		document.forms[0].pract_id_search.disabled = true;
		document.forms[0].Bedcode.disabled = true;
		document.forms[0].bed_type_code.disabled = true;
		document.forms[0].bed_classification.disabled = true;
		document.forms[0].gender.disabled = true;
		document.forms[0].age_value.disabled = true;
		document.forms[0].age.disabled = true;
		document.forms[0].release_hrs.disabled = true;
		document.forms[0].search_by_beds.disabled = true;
		document.forms[0].search_butt.disabled = true;
		document.forms[0].clear_butt.disabled = true;
		if(document.forms[0].cancel_butt)
			document.forms[0].cancel_butt.disabled = true;

		
		//document.forms[0].BedListinOrder1.disabled = true;
		//document.forms[0].BedListinOrder2.disabled = true;
		//document.forms[0].BedListinOrder3.disabled = true;
		//document.forms[0].BedListinOrder4.disabled = true;
		
	
		document.forms[0].privacy_level.disabled = true;
//		document.forms[0].smoking.disabled = true;
//		document.forms[0].infectious_disease.disabled = true;

		var patient_class = "<%=patient_class%>";
	
		if(document.forms[0].from_date.value != "" && document.forms[0].to_date.value != "")
			document.forms[0].bed_available_date_yn.value = "Y";
		else
			document.forms[0].bed_available_date_yn.value = "N";

		var from_date = document.forms[0].from_date.value;
		var to_date = document.forms[0].to_date.value;
		if(from_date!=null && from_date!='')
			from_date = convertDate(from_date,"DMYHM",localeName,"en");
		if(to_date!=null && to_date!='')
			to_date = convertDate(to_date,"DMYHM",localeName,"en");

		var s = '../jsp/BedAvailabilityChartCriteria1.jsp?bed_available_date_yn='+document.forms[0].bed_available_date_yn.value+'&avail_nursing_unit='+avail_nursing_unit+'&calledoption='+escape(calledoption)+'&'+params+"&patient_class="+patient_class+"&oper_stn_id="+oper_stn_id+"&query_gender_type="+gender_type+"&from_date_converted="+from_date+"&to_date_converted="+to_date+"&bed_booking_ref_no="+document.forms[0].bed_booking_ref_no.value;
		
		parent.dummy.location.href = s;
	}
}


function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck1(fields[i].value)) 
		{}
		else	
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
	}
	if ( errors.length != 0 ) 
	{
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


function submitBedListing(frm,calledoption)
{
	
	var params = "";
	for( var i=0; i<frm.elements.length; i++ )
		params += frm.elements[i]. name + "=" + escape(frm.elements[i].value) +"&";

	parent.result.location.href = '../jsp/BedAvailabilityChartResult.jsp?calledoption='+escape(calledoption)+'&'+params;
}
						

function getBedListinOrder(obj)
{
	
	
	var val_id	= new Array();
	val_id[0] = "specialty_short_desc";
	val_id[1] = "bed_type_short_desc";
	val_id[2] = "room_long_desc";
	if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val_id[3] = "admission_type";
	var val		= new Array();
	val[0] = getLabel("Common.speciality.label","Common");
	val[1] = getLabel("Common.bedtype.label","Common");
	val[2] = getLabel("Common.RoomCubicle.label","Common");
	if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val[3] = getLabel("Common.admissiontype.label","Common");

	if(obj.name == "BedListinOrder1")
	{
		
		if(obj.value == "")
		{
			document.BedAvailabilityChart_Form0.BedListinOrder3.options[0].selected = true;
			document.BedAvailabilityChart_Form0.BedListinOrder2.options[0].selected = true;
			document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true;
			document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true;

			if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			{
				document.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;
				document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true;
			}
				
		}
		else
		{
			removeitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );
			removeitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );
			if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
				removeitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );
		
			for ( var i=0; i<val_id.length; i++ )
			{
				var element		  = document.createElement("option");
					element.value = val_id[i];
					element.text  =	val[i];
				document.BedAvailabilityChart_Form0.BedListinOrder2.add(element)
			}
			document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
			document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;
			document.BedAvailabilityChart_Form0.BedListinOrder3.disabled =	true;
			if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
				document.BedAvailabilityChart_Form0.BedListinOrder4.disabled =	true;

		}
	}
	else
	{
		
		if(obj.name == "BedListinOrder2")
		{
			
			if(obj.value == "")
			{
				document.BedAvailabilityChart_Form0.BedListinOrder3.options[0].selected = true
				document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true
				if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
				{
					document.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;
					document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true;			
				}
	

			}
			else
			{
				removeitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );
				if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
					removeitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );

				for ( var i=0; i<val_id.length; i++ )
				{
					var element	  = document.createElement("option");
					element.value = val_id[i];
					element.text  =	val[i];
					document.BedAvailabilityChart_Form0.BedListinOrder3.add(element)
				}
				document.BedAvailabilityChart_Form0.BedListinOrder3.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
				document.BedAvailabilityChart_Form0.BedListinOrder3.remove(document.BedAvailabilityChart_Form0.BedListinOrder2.selectedIndex);
				document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = false ;
				if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
					document.BedAvailabilityChart_Form0.BedListinOrder4.disabled =	true;

			}
		}
		else
		{
			if(obj.name == "BedListinOrder3")
			{
				if(obj.value == "")
				{
					if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
					{
						document.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;
						document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true
					}

				}
				else if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
				{
					removeitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );

					for ( var i=0; i<val_id.length; i++ )
					{
						var element	  = document.createElement("option");
						element.value = val_id[i];
						element.text  =	val[i];
						document.BedAvailabilityChart_Form0.BedListinOrder4.add(element)
					}
					document.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
					document.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder2.selectedIndex);
					document.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder3.selectedIndex);
			
					document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = false ;
					
				}
			}

		}
	}
}


function enableDisable(obj)
{
	
	
	document.BedAvailabilityChart_Form0.from_date.value = "";
	document.BedAvailabilityChart_Form0.to_date.value = "";

	var enable_bed_date = document.forms[0].enable_bed_date.value;
	if(obj.value == '' && enable_bed_date == 'Y')
	{
		document.BedAvailabilityChart_Form0.from_date.disabled = false;
		document.BedAvailabilityChart_Form0.to_date.disabled = false;
		document.getElementById("fromDtImg").disabled = false;
		document.getElementById("toDtImg").disabled = false;
	}
	else 
	{
		document.BedAvailabilityChart_Form0.from_date.disabled = true;
		document.BedAvailabilityChart_Form0.to_date.disabled = true;
		document.getElementById("fromDtImg").disabled = true;
		document.getElementById("toDtImg").disabled = true;
	}

	if(document.BedAvailabilityChart_Form0.Splcode.value !="")
	{
		document.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;
		
		var val_id	= new Array();
		val_id[0] = "specialty_short_desc";
		val_id[1] = "bed_type_short_desc";
		val_id[2] = "room_long_desc";
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val_id[3] = "admission_type";
		var val		= new Array();
		val[0] = getLabel("Common.speciality.label","Common");
		val[1] = getLabel("Common.bedtype.label","Common");
		val[2] = getLabel("Common.RoomCubicle.label","Common");
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			val[3] = getLabel("Common.admissiontype.label","Common");

		removeitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );
		removeitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
		removeitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );
		
		for ( var i=0; i<val_id.length; i++ )
		{
			var element		  = document.createElement("option");
				element.value = val_id[i];
				element.text  =	val[i];
			document.BedAvailabilityChart_Form0.BedListinOrder2.add(element)
		}
		document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
		document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;
		document.BedAvailabilityChart_Form0.BedListinOrder3.disabled =	true;
		if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=="visible")
			document.BedAvailabilityChart_Form0.BedListinOrder4.disabled =	true;
	}

	
	if(obj.value == '' && ("<%=wherecondn%>" == "CREATE_BOOKING_YN" || "<%=wherecondn%>" == "CONFIRM_BOOKING_YN") )
	{
		
		document.BedAvailabilityChart_Form0.from_date.value = "<%=create_booking_admission_date_time%>" ;
		document.BedAvailabilityChart_Form0.from_date.disabled = true ;
		document.getElementById("fromDtImg").disabled = true;
		document.BedAvailabilityChart_Form0.to_date.value = "<%=exp_discharge_date%>" ;
		document.BedAvailabilityChart_Form0.to_date.disabled = false ;
		document.getElementById("toDtImg").disabled = false;
		//document.BedAvailabilityChart_Form0.fromDtImg.disabled = true ;
	}
	else if("<%=wherecondn%>" == "CREATE_BOOKING_YN" || "<%=wherecondn%>" == "CONFIRM_BOOKING_YN" )
	{
		document.BedAvailabilityChart_Form0.from_date.value = "" ;
		//document.BedAvailabilityChart_Form0.from_date.disabled = false ;
		//document.BedAvailabilityChart_Form0.fromDtImg.disabled = false ;
	}
	else if(obj.value == '')
	{
		document.BedAvailabilityChart_Form0.from_date.disabled = false ;
		document.getElementById("fromDtImg").disabled = false;
		document.BedAvailabilityChart_Form0.to_date.disabled = false ;
		document.getElementById("toDtImg").disabled = false;
	}
	
	if(document.forms[0].sm_cntl_assign_bed_count.value>0 ){
		document.forms[0].BedListinOrder1.options[3].selected = true;
		getBedListinOrder(document.forms[0].BedListinOrder1);
	}

}

function displayBedOrder(obj)
{
	
	if(!(obj.value=='B' || obj.value=='V'))
	{
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder1);
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder2);
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder3);
		document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility="visible";
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder4);

		document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true ;
		//document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
		document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;
		document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;
	
	}
	else
	{
		
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder1);
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder2);
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder3);
		addOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder4);
		document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility="hidden";

		document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true ;
		//document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
		document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;
		document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;
	}
/*
	if(document.forms[0].Splcode.value != '')
	{
		document.forms[0].BedListinOrder1.options[1].selected = true;		
		document.forms[0].BedListinOrder2.disabled = false;		
	}
	else
	{
		document.forms[0].BedListinOrder1.options[0].selected = true;
	}
*/
}

function addOptionElement(bedlistorder)
{
	
	removeitems(bedlistorder);

	var opt1 = document.createElement('Option');
	opt1.text = getLabel("Common.speciality.label","Common");
	opt1.value = "specialty_short_desc";
	bedlistorder.add(opt1);

	opt1 = document.createElement('Option');
	opt1.text = getLabel("Common.bedtype.label","Common");
	opt1.value = "bed_type_short_desc";
	bedlistorder.add(opt1);


	opt1 = document.createElement('Option');
	opt1.text = getLabel("Common.RoomCubicle.label","Common");
	opt1.value = "room_long_desc";
	bedlistorder.add(opt1);
	
	if(!(document.BedAvailabilityChart_Form0.search_by_beds.value=='B' || document.BedAvailabilityChart_Form0.search_by_beds.value=='V'))
	{
		opt1 = document.createElement('Option');
		opt1.text = getLabel("Common.admissiontype.label","Common");
		opt1.value = "admission_type";
		bedlistorder.add(opt1);
	}

}


function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		
		len=obj.length
		obj.remove(i)
	}
}

			
function popDynamicValues ( obj )
{		
	var wherecondn= document.forms[0].wherecondn.value;
}


function popDynamicValues1 ( obj )
{				
	var wherecondn= document.forms[0].wherecondn.value;
}

function disButtons()
{
	var callfunc ="<%=call_func%>";
	if(callfunc == 'ADMIT')
	{
		parent.parent.frames[0].document.forms[0].create.disabled = true;
		parent.parent.frames[0].document.forms[0].apply.disabled = true;
		parent.parent.frames[0].document.forms[0].reset.disabled = true;

		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}
			
// added by chitra to default screen values 
function defaultValues()
{
	
	document.BedAvailabilityChart_Form0.age_value.value="<%=age%>";
	var oper_stn_id=document.forms[0].oper_stn_id.value;

	var p = document.BedAvailabilityChart_Form0.nursing_unit.options;
	
	
	for (i=0; i<p.length; i++) 
	{
		if(p[i].value == "<%=nursingunitcode%>"){
				p[i].selected = true;
		}
	}

	p = document.BedAvailabilityChart_Form0.Splcode;
	for (i=0; i<p.options.length; i++) 
	{
		if(p.options[i].value == "<%=specialitycode%>"&&p.options[i].value != "")
		{
			
			p.options[i].selected = true;
		}
	}

	p = document.BedAvailabilityChart_Form0.Bedcode;
	for (i=0; i<p.options.length; i++) 
	{
		if(p.options[i].value == "<%=bedclasscode%>"){
			
			p.options[i].selected = true;
		}
	}
//document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
	p = document.BedAvailabilityChart_Form0.bed_type_code;
	for (i=0; i<p.options.length; i++) 
	{
		
		if(p.options[i].value == "<%=bed_type%>"){
			
			p.options[i].selected = true;
		}
	}

	p = document.BedAvailabilityChart_Form0.age;
	for (i=0; i<p.options.length; i++) 
	{
		if(p.options[i].value == "<%=agevalue%>")
			p.options[i].selected = true;
	}

	var params = "";
	for( var i=0; i<document.BedAvailabilityChart_Form0.elements.length; i++ )
	{
		params += document.BedAvailabilityChart_Form0.elements[i].name + "=" + document.BedAvailabilityChart_Form0.elements[i].value +"&";
	}
	
	var patient_class = "<%=patient_class%>";
	var bed_yn="<%=ipparam_bed_yn%>";
	var oper_stn_id="<%=oper_stn_id%>";
	
	if(document.BedAvailabilityChart_Form0.Splcode.value!='')
	{
		
		document.forms[0].BedListinOrder1.options[1].selected = true;
		//displayBedOrder(document.forms[0].search_by_beds);
		//enableDisable(document.forms[0].search_by_beds);
		getBedListinOrder(document.forms[0].BedListinOrder1);
		
	}
	else
	{
		
		document.forms[0].BedListinOrder1.options[3].selected = true;
		//displayBedOrder(document.forms[0].search_by_beds);
		//enableDisable(document.forms[0].search_by_beds);
		getBedListinOrder(document.forms[0].BedListinOrder1);
		
	}

	//BRU-CRF-196
	if(document.forms[0].wherecondn.value=='CHG_NURS_UNIT_IN_ASSIGN_BED_YN' && document.forms[0].sm_cntl_assign_bed_count.value>0 ){
		document.forms[0].BedListinOrder1.options[3].selected = true;
		getBedListinOrder(document.forms[0].BedListinOrder1);
	}
	
		
		

<% if (nursingunitcode.equals("") && specialitycode.equals("")	&& !call_func.equals("QUERY_BED_AVAIL")) {%>
		alert(getMessage('NU_OR_SPCLTY','IP'));
<%} else {%>
		var avail_nursing_unit = document.forms[0].available_nursing_unit.value;
	
		var from_date = document.forms[0].from_date.value;
		var to_date = document.forms[0].to_date.value;
		if(from_date!=null && from_date!='')
			from_date = convertDate(from_date,"DMYHM",localeName,"en");
		if(to_date!=null && to_date!='')
			to_date = convertDate(to_date,"DMYHM",localeName,"en");

		if(document.forms[0].from_date.value != "" && document.forms[0].to_date.value != "")
			document.forms[0].bed_available_date_yn.value = "Y";
		else
			document.forms[0].bed_available_date_yn.value = "N";

		var s = '../jsp/BedAvailabilityChartCriteria1.jsp?calledoption=C&'+params+"&ipparam_bed_yn="+bed_yn+"&bed_available_date_yn="+document.forms[0].bed_available_date_yn.value+"&avail_nursing_unit="+avail_nursing_unit+"&patient_class="+patient_class+"&oper_stn_id="+oper_stn_id+"&from_date_converted="+from_date+"&to_date_converted="+to_date+"&bed_booking_ref_no="+document.forms[0].bed_booking_ref_no.value;


//		var s = '../jsp/BedAvailabilityChartCriteria1.jsp?calledoption=C&'+params+"&patient_class="+patient_class+"&ipparam_bed_yn="+bed_yn+"&oper_stn_id="+oper_stn_id ;

	<%     if (!call_func.equals("QUERY_BED_AVAIL")) {%>
			parent.dummy.location.href = s;
<%}
			}%>
}	
	 

function fetchValForBedClass() {} 


function DateCompare(from,to) 
{
	var flg1 = validDateObj(from,"DMYHM",localeName);
	var flg2 = validDateObj(to,"DMYHM",localeName);
	var func_name = document.forms[0].wherecondn.value;
	
	if(flg1 && !(func_name=="CONFIRM_BOOKING_YN" || func_name=="CREATE_BOOKING_YN" || func_name=="REVISE_BOOKING_YN"))
	{
		var greg_frmdate = convertDate(from.value,"DMYHM",localeName,"en");
	    var greg_currdate = convertDate(document.forms[0].curdate.value,"DMYHM","en","en");
		if(!isBefore(greg_currdate,greg_frmdate,"DMYHM","en"))
		{
			alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
			from.value = "";
			from.select();
			from.focus();
			return false;
		}
	}
	
	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"DMYHM",localeName,"en");
		var greg_todate = convertDate(to.value,"DMYHM",localeName,"en");

		if(!isBefore(greg_fromdate,greg_todate,"DMYHM",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}
</script>

</head>
<body onload="defaultValues();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BedAvailabilityChart_Form0' id='BedAvailabilityChart_Form0'  target='result' >
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

<% if(call_func.equals("ADMIT")) 
	{	%>
		<td class="COLUMNHEADER" colspan='4' ><fmt:message key="eIP.BedAvailabilityChart.label" bundle="${ip_labels}"/></th>
<%	} %>
	<tr>
<%	if(call_func.equals("QUERY_BED_AVAIL"))
	{
		wherecondn = "";
	}	%>
		
		<td width="18%" class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class="fields" width="20%"><jsp:include page="NursingUnitComponent.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name='wherecondn' value="<%=wherecondn%>" /><jsp:param name='patient_class' value="<%=patient_class%>" /><jsp:param name='med_service_grp' value="<%=med_service_grp%>" /><jsp:param name='specialitycode' value="<%=specialitycode%>" /></jsp:include><%/*if(call_func.equals("QUERY_BED_AVAIL")){out.println("<img src='../../eCommon/images/mandatory.gif'></img>");



		}	*/%>
		</td>
		<td width="12%" class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td  width="50%" class="fields" >
		
		
		<select name='Splcode' id='Splcode' onchange='setGroupBy(this)' width="15"><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
	<%  try
		{
			con = ConnectionManager.getConnection(request);		
			//String sql2=" Select Speciality_code, short_desc from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
			/*Wednesday, May 05, 2010 , modified for PE*/
			String sql2=" Select Speciality_code, am_get_desc.am_speciality(speciality_code,?,2)short_desc  from AM_SPECIALITY where eff_status='E' order by short_desc ";
			String Splcode   = "";
			String Spldesc   = "";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,locale);
			rs = pstmt.executeQuery();
			if( rs != null )
			{
				while( rs.next() )
				{
					Splcode   = rs.getString(1);
					Spldesc   = rs.getString(2);
	%>
					<OPTION VALUE="<%=Splcode%>" ><%=Spldesc%>
		<%		}
			}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement("select count(*) sm_cntl_assign_bed_count from sm_function_control where FUNCTIONALITY_ID='ASSIGN_BED' and module_ID='IP' and SITE_ID= (select CUSTOMER_ID from SM_SITE_PARAM)");
			
			rs = pstmt.executeQuery();

			if (rs!=null && rs.next()){
				sm_cntl_assign_bed_count=rs.getInt("sm_cntl_assign_bed_count");
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			}catch(Exception e) { 
				//out.println(e.getMessage()); 
				e.printStackTrace();}
			finally
			{		  
				ConnectionManager.returnConnection(con,request);
		  }
	%>
	</select>
		</td>
	</tr>
	<tr>
		<td  class='label' ><fmt:message key="eIP.IncludeBedtobereleasedin.label" bundle="${ip_labels}"/></td>
		<td  class="fields"><input type='text' name='release_hrs' id='release_hrs' maxlength=5 size=5  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='specialChar(this)'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
		<td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class="fields"><jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="practitioner_desc" value="<%=practitioner_desc%>" /></jsp:include></td>
	</tr>
	<tr>
		<td  class='label'  ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
		<td class="fields"><jsp:include page="BedClassComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="ipparam_bed_yn" value="<%=ipparam_bed_yn%>" /></jsp:include></td>
		<td  class='label'  ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
		<td class="fields" ><jsp:include page="BedTypeComponent.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="ipparam_bed_yn" value="<%=ipparam_bed_yn%>" /></jsp:include></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.BedClassification.label" bundle="${ip_labels}"/></td>
		<td class='fields' >
	<%	if (bed_type.equals("pseudo"))
		{	%>
			<select name='bed_classification' id='bed_classification' disabled>
				<option value='P' selected><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></option>
			</select>
		<%	}
		else if(bed_type.equals("baby"))
		{	%>
			<select name='bed_classification' id='bed_classification'>
			<option value='BB' selected><fmt:message key="eIP.BabiesBeds.label" bundle="${ip_labels}"/></option>
			<!-- modified on 19-05-08 -->
			<!--<option value='N'><fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/></option>
			<option value='P'><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></option>
			<option value='B'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			-->
		<!-- -->
			</select>
		<%	}
		else
		{	%>
			<select name='bed_classification' id='bed_classification'>
		<%	if(!call_function.equals("Transfer_Patient"))
			{	%>
				<option value='BB'><fmt:message key="eIP.BabiesBeds.label" bundle="${ip_labels}"/></option>
		<%	}	%>
		
			<option value='N' selected><fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/></option>
		
		<% if(!(wherecondn.equalsIgnoreCase("CREATE_BOOKING_YN") || wherecondn.equalsIgnoreCase("REVISE_BOOKING_YN"))) 
			{	%>
				<option value='P'><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></option>
				<option value='B'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%	}	%>
			</select>
	<%	}	%>
		</td>	
		<td class='label'  ><fmt:message key="Common.bedstatus.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name='search_by_beds' id='search_by_beds' onchange = 'displayBedOrder(this);enableDisable(this);'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value='B'><fmt:message key="Common.booked.label" bundle="${common_labels}"/></option><option selected value='V'><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></option><option value='O'><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/></option><option value='R'><fmt:message key="Common.Reserved.label" bundle="${common_labels}"/></option></select></td>
	</tr>
	<tr>
		<td class='label' nowrap><fmt:message key="eIP.GenderType.label" bundle="${ip_labels}"/></td>
		<td class='fields'nowrap> <fmt:message key="eIP.PatientGender.label" bundle="${ip_labels}"/> <input type='radio' name='gender_type' id='gender_type' value='1' checked> <fmt:message key="eIP.BedGender.label" bundle="${ip_labels}"/>
		<input type='radio' name='gender_type' id='gender_type' value='2' ></td>	
<!-- 		<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td> -->

<!-- 	if(call_func.equals("QUERY_BED_AVAIL")) -->

	<td class='label' nowrap><fmt:message key="eIP.BedAvailablibilityDate.label" bundle="${ip_labels}"/></td>
	<td class='fields' ><input type='text' name='from_date' id='from_date' size='16' maxlength='16'  disabled onblur="DateCompare(this,to_date);"><input type="image" id='fromDtImg' disabled  src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('from_date',null,'hh:mm');"> <fmt:message key="Common.to.label" bundle="${common_labels}"/> <input type='text' disabled name='to_date' id='to_date' size='16' maxlength='16'  onblur="DateCompare(from_date,this);"><input  id='toDtImg' type="image" disabled  src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('to_date',null,'hh:mm');"></td> 
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields'><jsp:include page="GenderComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
		<td class='label' ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='age_value' id='age_value' value='' maxlength='5' size='5'  onKeyPress='return(ChkNumberInput(this,event,0))'  onBlur='specialChar(this)'><select name='age' id='age'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
		</select></td>
	</tr>
	<!-- <tr>
		<td nowrap class='label' ><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="smoking" id="smoking" value="" onClick="getCheckValue(this);" ></td>
		<td class="LABEL"><fmt:message key="Common.InfectiousDisease.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="infectious_disease" id="infectious_disease" value="" onClick="getCheckValue(this);" ></td>
	</tr> -->
	<tr>
		<td class='label'  ><fmt:message key="Common.RoomCubicleStatus.label" bundle="${common_labels}"/></td>
		<td class='fields' ><select name="privacy_level" id="privacy_level"><OPTION VALUE=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<option value='F'><fmt:message key="Common.Isolation.label" bundle="${common_labels}"/></option>
		<option value='P'><fmt:message key="Common.PrivateRoom.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="Common.SemiPrivateRoom.label" bundle="${common_labels}"/></option>
		<option value='W'><fmt:message key="Common.RoomCubicle.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label' ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class='fields'  >
		<jsp:include page="BedListinOrderComponent.jsp"><jsp:param name="flush" value="true" /><jsp:param name="attribute" value="BedListinOrder1"/></jsp:include>
		<jsp:include page="BedListinOrderComponent.jsp"><jsp:param name="flush" value="true" /><jsp:param name="attribute" value="BedListinOrder2"/></jsp:include>
		<jsp:include page="BedListinOrderComponent.jsp"><jsp:param name="flush" value="true" /><jsp:param name="attribute" value="BedListinOrder3"/></jsp:include>
		<jsp:include page="BedListinOrderComponent.jsp"><jsp:param name="flush" value="true" /><jsp:param name="attribute" value="BedListinOrder4"/><jsp:param name="attribute" value="disabled"/></jsp:include>
		</td>
	</tr>
	<tr>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='fields' ><input type='button' class='button' name='search_butt' id='search_butt' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="submitPage(this.form,'search')"><input type='button' name='clear_butt' id='clear_butt' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick="clearCriteria();"><%if(!call_func.equals("QUERY_BED_AVAIL")){%><input type='button' name='cancel_butt' id='cancel_butt' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick='cancelAction();'><%}%>
		</td>
	</tr>
</table>
	<input type="hidden" name="available_nursing_unit" id="available_nursing_unit" value="">
	<input type="hidden" name="bed_available_date_yn" id="bed_available_date_yn" value="N">
	<input type="hidden" name="enable_bed_date" id="enable_bed_date" value="<%=enable_bed_date%>">
	<input type="hidden" name="reserve_bed_selectable" id="reserve_bed_selectable" value="<%=reserve_bed_selectable%>">
	<input type="hidden" name="bedClass_dis_yn" id="bedClass_dis_yn" value="<%=bedClass_dis_yn%>">
	<input type="hidden" name="call_func" id="call_func" value="<%=call_func%>">
	<input type="hidden" name="call_function" id="call_function" value="<%=call_function%>">
	<input type="hidden" name="disable_field" id="disable_field" value="<%=disable_field%>">
	<input type="hidden" name="ipparam_bed_yn" id="ipparam_bed_yn" value="<%=ipparam_bed_yn%>">
	<input type="hidden" name="main_bed_no" id="main_bed_no" value="<%=main_bed_no%>">
	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="hidden" name="room_no_code" id="room_no_code" value="<%=room_no_code%>">
	<input type="hidden" name="wherecondn" id="wherecondn" value="<%=wherecondn%>">
	<input type="hidden" name="sm_cntl_assign_bed_count" id="sm_cntl_assign_bed_count" value="<%=sm_cntl_assign_bed_count%>">	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">  
	<input type='hidden' name='curdate' id='curdate' value="<%=curdate%>">  
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">  
	<input type='hidden' name='bed_booking_ref_no' id='bed_booking_ref_no' value="<%=bed_booking_ref_no%>">  
	<script>
		var nurunit = "<%=nursingunitcode%>"
		popDynamicValues1(nurunit)

	if("<%=wherecondn%>" == "CREATE_BOOKING_YN")
	{
		document.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;		
		document.BedAvailabilityChart_Form0.Splcode.disabled = true;	
	}

	
	
	</script>	
</form>
<script>
	if("<%=wherecondn%>" == "CREATE_BOOKING_YN")
	{	
		document.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false ;
		document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);
		document.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;
		document.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;
		document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility='hidden';	
	}
	disButtons();

	var wherecondn = "<%=wherecondn%>";
	
	if (wherecondn=='CREATE_BOOKING_YN' || wherecondn=='REVISE_BOOKING_YN')
	{
		document.forms[0].bed_classification.value='N';
		document.forms[0].search_by_beds.options[0].selected=true;
		displayBedOrder(document.forms[0].search_by_beds);
		enableDisable(document.forms[0].search_by_beds);
	}	
	else if (wherecondn=='CONFIRM_BOOKING_YN' )
	{
		document.forms[0].search_by_beds.options[0].selected=true;
		displayBedOrder(document.forms[0].search_by_beds);
		enableDisable(document.forms[0].search_by_beds);
	}
	else
	{		
		displayBedOrder(document.forms[0].search_by_beds);
	}

	var disable_field	=	"<%=disable_field%>";
	if (disable_field == "NursingUnit")
	{		
		//document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true; 12/10/2008
/*
		if(document.BedAvailabilityChart_Form0.ipparam_bed_yn.value=='Y')
		{
			document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
			document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
		}*/
	}
	else if (disable_field == "NursingUnitSpecialty")
	{
		
		//document.BedAvailabilityChart_Form0.bed_type_code.disabled=true
		document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
		document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
	}
	else if (disable_field == "specialty")
	{
		document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
	}
	else if (disable_field == "NuBcBt")
	{
		document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
	}
	else if (disable_field == "NuSyBcBt")
	{
		document.BedAvailabilityChart_Form0.nursing_unit.disabled	= true;
		document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
		document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}
	else if (disable_field == "SyBcBt")
	{
		document.BedAvailabilityChart_Form0.Splcode.disabled		= true;
		document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}
	else if (disable_field == "BcBt")
	{
		document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;
		document.BedAvailabilityChart_Form0.Bedcode.disabled=true;
	}/*Friday, February 12, 2010 IN000242(emergency release),Nursing unit list item getting enable from Bed for Nursing Unit function*/
	else if (disable_field == "Nursing")
	{
		document.BedAvailabilityChart_Form0.nursing_unit.disabled=true;
	}


	/// Added by Sridhar R on 13 JULY 2004
	/// This fuunction will default Bed Classification as "Pseudo Bed" & Disable the field, if the parameter bedClass_dis_yn value is "Y"...
	if("<%=bedClass_dis_yn%>" == 'Y')
	{
		document.BedAvailabilityChart_Form0.bed_classification.value = 'P';
		document.BedAvailabilityChart_Form0.bed_classification.disabled	=true;
	}
	else
	{
		document.BedAvailabilityChart_Form0.bed_classification.disabled	=false;
	}
	//document.forms[0].BedListinOrder1.options[3].selected = true;
</script>
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

