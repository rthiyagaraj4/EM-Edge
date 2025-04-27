<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page  contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>            
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eIP/js/AdmitPatient.js' language='Javascript'></script>
<script src='../../eIP/js/AdmitPatient1.js' language='Javascript'></script>
<script language="JavaScript">

var continueFlag = "Y";
var temp2 = "";

function makeDisabled(booleanFlag)
{
	if(parent.frames.length>1)		
	{
		if(parent.frames[1].frames.length>0)
		{
			if(parent.frames[1].frames[0].document.Select_form && parent.frames[1].frames[0].name=="Select_frame")
			{
				var booking_ref_no		=	parent.frames[1].frames[0].document.Select_form.booking_ref_no;
				var patient_id			=	parent.frames[1].frames[0].document.Select_form.patient_id;
				var referral_id			=	parent.frames[1].frames[0].document.Select_form.referral_id;
				var encounter_id		=	parent.frames[1].frames[0].document.Select_form.encounter_id;
				var book_ref_no_search	=	parent.frames[1].frames[0].document.Select_form.book_ref_no_search;
				var patient_id_search	=	parent.frames[1].frames[0].document.Select_form.patient_id_search;
				var referral_id_search	=	parent.frames[1].frames[0].document.Select_form.referral_id_search;
				
				if( (trimCheck(booking_ref_no.value)) || (trimCheck(patient_id.value)) || (trimCheck(referral_id.value)) || (trimCheck(encounter_id.value)) )
				{						
					if(parent.frames[1].frames[0].document.Select_form.referral_id.value != "")
						parent.frames[1].frames[3].document.getElementById("referal_details").disabled = false
					else
						parent.frames[1].frames[3].document.getElementById("referal_details").disabled = true

					if(booleanFlag)
					{
						parent.frames[1].frames[0].proceedFurther = true;
					}

					booking_ref_no.readOnly			=	booleanFlag;
					referral_id.readOnly			=	booleanFlag;
					encounter_id.readOnly			=	booleanFlag;
					book_ref_no_search.disabled		=	booleanFlag;
					referral_id_search.disabled		=	booleanFlag;
				}
				else
					parent.frames[1].frames[0].proceedFurther = true;
			}
		}
	}
}	
</script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="DischargeValidation_form" id="DischargeValidation_form">
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	String locale			= (String)session.getAttribute("LOCALE");
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	Statement			stmt		=	null;
	ResultSet			rset		=	null;
	PreparedStatement	pstmt		=	null;

	String	facilityId				=	"",		value1					=	""; 
	String	value2					=	"",		value3					=	""; 
	String	from					=	"",		value5					=	"";
	String	patientid				=	"";
	String	bookingrefno			= "";
	String	referralid				= "";
	String	sql						= ""; 
	String	specialitycode			= "";
	String  queryString				= "";
//	String  financial_detail_ref_id = "";
//	String  org_type_data			= "";
	String  bed_block_period_normal = "";
	boolean	continueyn				=	true;

	try
	{
		con					   =	ConnectionManager.getConnection(request);
		stmt				   =	con.createStatement();
		value1				   =	checkForNull(request.getParameter("field1"));
		value2				   =	checkForNull(request.getParameter("field2"));
		value3				   =	checkForNull(request.getParameter("field3"));
		from				   =	checkForNull(request.getParameter("field4"));
		bed_block_period_normal=	checkForNull(request.getParameter("bed_block_period_normal"));
		facilityId			   =	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);
		value5				=	checkForNull(request.getParameter("field5"));
		queryString 		=	checkForNull(request.getParameter("queryString"));
		String frame_ref = checkForNull(request.getParameter("frame_ref"));
		//added on 3-7-2008 for SCR 3228
		String indicator		= checkForNull(request.getParameter("indicator"));
		String discharge_type	= checkForNull(request.getParameter("discharge_type"));
		String code             = "";
		String desc             = "";

	
		if ((from.equals("TransferOutForm")) && (!value2.equals("")) )
		{
			StringBuffer sqlBuffer	= new StringBuffer();
			String info_pat_name	= "";
			if (value3.equals("01"))
			{
				sqlBuffer.append(" select contact1_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			else if (value3.equals("02"))
			{
				sqlBuffer.append(" select contact2_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			
			pstmt	=	con.prepareStatement(sqlBuffer.toString());
			rset	=	pstmt.executeQuery();	
			if ((rset != null) && (rset.next()))
				info_pat_name = checkForNull(rset.getString("info_pat_name"));
 			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();

			
			
			if ((value5.equals("Discharge"))  && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[2].document.forms[0].informed_name.value = '';</script>");	
			}
			else if ((value5.equals("TransferIn")) && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[1].document.forms[0].informed_name.value = '';</script>");	
			}

			if ((value5.equals("Discharge")) &&  (!info_pat_name.equals("")))
			{
				%>
				<script>
					parent.frames[2].document.forms[0].informed_name.value = "<%=info_pat_name%>";
   					parent.frames[2].document.forms[0].informed_name.disabled=false;
					parent.frames[2].document.forms[0].informed_name.focus();
				</script>
				<%
			}
			else if ((value5.equals("TransferIn")) &&  (!info_pat_name.equals("")))
			{
				%>
				<script>
					parent.frames[1].document.forms[0].informed_name.value = "<%=info_pat_name%>";
	   				parent.frames[1].document.forms[0].informed_name.disabled=false;
					parent.frames[1].document.forms[0].informed_name.focus();
				</script>
				<%
			}
			else if ((value5.equals("TransferOut")) && ((!info_pat_name.equals(""))))
			{
				out.println("<script>parent.frames[2].document.forms[0].info_pat_name.value = \""+info_pat_name+"\"; parent.frames[2].document.forms[0].info_pat_name.focus();</script>");
			}
			if ((value5.equals("Discharge")) && (info_pat_name.equals("")))
			{	

			out.println("<script>parent.frames[2].document.forms[0].informed_name.value = '';</script>");
			}
			return;
		}
		else if((from.equals("DischargeCheckList")) && (!value2.equals("")) )
		{
			StringBuffer sqlBuffers	= new StringBuffer();
			String info_pat_name	= "";
			if (value3.equals("01"))
			{
				sqlBuffers.append(" select contact1_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffers.append(value2);
				sqlBuffers.append("' ");
			}
			else if (value3.equals("02"))
			{
				sqlBuffers.append(" select contact2_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffers.append(value2);
				sqlBuffers.append("' ");
			}
			

			pstmt	=	con.prepareStatement(sqlBuffers.toString());
			rset	=	pstmt.executeQuery();	
			if ((rset != null) && (rset.next()))
				info_pat_name = checkForNull(rset.getString("info_pat_name"));
 			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();

			if ((value5.equals("Discharge"))  && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[0].document.forms[0].informed_name.value = '';</script>");	
			}

			if ((value5.equals("Discharge")) &&  (!info_pat_name.equals("")))
			{
				%>
				<script>
					parent.frames[0].document.forms[0].informed_name.value = "<%=info_pat_name%>";
  						parent.frames[0].document.forms[0].informed_name.disabled=false;
						parent.frames[0].document.forms[0].informed_name.focus();
				</script>
				<%
			}
					
			if ((value5.equals("Discharge")) && (info_pat_name.equals("")))
			{	
				out.println("<script>parent.frames[0].document.forms[0].informed_name.value = '';</script>");
			}
		}
		else if(from.equals("Discharge_form"))
		{
			String	dischargetypecode   =	value1;
			String	deceasedyn			=	"";
			//Added by kishore for Bed Block Details on 8/26/2004
			String dischage_type		=	value3;
			String blk_rs				= value5;
			String blocking_type="";
			int block_period=0;
			String blocked_until_date="";
			String blocking_code	= "";
			String str_block_period="";			
		
			if(!dischage_type.equals(""))
			{ 
				 String blocking_date="SELECT a.blocking_type_code, ip_get_desc.ip_blocking_type (a.blocking_type_code, '"+locale+"', '2' ) blocking_type_short_desc, CASE WHEN a.block_period IS NOT NULL THEN DECODE (a.block_units,  'D', a.block_period * 24,  'H', a.block_period  )  ELSE b.bed_block_period_normal  END block_period,  CASE  WHEN a.block_period IS NOT NULL THEN TO_CHAR (DECODE (a.block_units,  'D', SYSDATE + a.block_period,  'H', SYSDATE + a.block_period / 24  ),  'dd/mm/rrrr hh24:mi'  )  ELSE TO_CHAR (SYSDATE + b.bed_block_period_normal / 24,  'dd/mm/rrrr hh24:mi'  )  END blocked_until_date FROM ip_discharge_type_vw a, ip_param b  WHERE discharge_type_code = '"+dischage_type+"' AND facility_id = '"+facilityId+"' ";
				
				 rset = stmt.executeQuery(blocking_date);		
			    if (rset.next()) {
					blocking_code = checkForNull(rset.getString("blocking_type_code"));
					blocking_type = checkForNull(rset.getString("blocking_type_short_desc"));					
					blocked_until_date = checkForNull(rset.getString("blocked_until_date"));					
					block_period =rset.getInt("BLOCK_PERIOD");		
					if (rset!=null) rset.close();
				 }

				if(!blocking_code.equals("")) {									out.print("<script>parent.frames[2].document.forms[0].blocking_type.value=\""+blocking_type+"\";parent.frames[2].document.forms[0].bed_blocking_period.value=\""+block_period+"\";parent.frames[2].document.forms[0].bed_block_until.value=\""+blocked_until_date+"\";parent.frames[2].document.forms[0].blocking_type_code.value=\""+blocking_code+"\";</script>");
				}  else { 						out.print("<script>parent.frames[2].document.forms[0].blocking_type.value='';parent.frames[2].document.forms[0].blocking_type.disabled=true;parent.frames[2].document.forms[0].bed_blocking_period.value='';parent.frames[2].document.forms[0].bed_blocking_period.disabled=true;parent.frames[2].document.forms[0].bed_block_until.value='';parent.frames[2].document.forms[0].bed_block_remarks.value='';parent.frames[2].document.forms[0].bed_block_remarks.disabled=true;parent.frames[2].document.forms[0].auth_pract_desc.focus();</script>");
		      }				
		}
		else if(!blk_rs.equals(""))
		{
			block_period = Integer.parseInt(blk_rs);			
			if(block_period >0)
			{	
				
				str_block_period = " select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
				
				rset = stmt.executeQuery(str_block_period);
				if (rset != null && rset.next())
				{
					blocked_until_date = rset.getString("a");
					if(blocked_until_date==null) blocked_until_date="";
					if (rset!=null) rset.close();
					
				}
				String blocked_until_date_display = blocked_until_date; 

				blocked_until_date_display = DateUtils.convertDate(blocked_until_date,"DMYHM","en",locale);
				//out.println("<script>alert('"+blocked_until_date_display+"');</script>");
				out.print("<script>parent.frames[2].document.forms[0].bed_block_until.value='"+blocked_until_date_display+"';</script>");
				}
			else
			{
			out.print("<script>parent.frames[2].document.forms[0].bed_block_until.value='';</script>");
			}
		}
			//Ended Here on 8/26/2004
			else if(!dischargetypecode.equals(""))
			{
				sql			=	" select deceased_yn from IP_DISCHARGE_TYPE where discharge_type_code = '"+dischargetypecode+"' and eff_status = 'E'" ;		
				
				rset		=	stmt.executeQuery(sql);
				if(rset != null && rset.next())
					deceasedyn	=	rset.getString("deceased_yn");
					if (rset!=null) rset.close();
					
				if(deceasedyn.equals("Y"))
					out.print("<script>parent.frames[2].document.DischargePatient_form.deceased_yn.checked = true;parent.frames[2].document.DischargePatient_form.deceased_yn.disabled = true;parent.frames[2].document.DischargePatient_form.deceased_yn.value = 'Y';parent.frames[2].document.DischargePatient_form.post_mortem_request.disabled =  false;parent.frames[2].document.DischargePatient_form.post_mortem_request.checked=true;parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.disabled = false;parent.frames[2].document.getElementById('deceasedimg').style.visibility='visible';parent.frames[2].document.DischargePatient_form.new_medicine.value='N';parent.frames[2].document.DischargePatient_form.new_medicine.checked=false;parent.frames[2].document.DischargePatient_form.new_medicine.disabled=true;parent.frames[3].Medical_Certificate.disabled=true;<!-- parent.frames[2].document.DischargePatient_form.referred.checked=false;parent.frames[2].document.DischargePatient_form.referred.disabled=true;parent.frames[2].enable_referred(parent.frames[2].document.DischargePatient_form.referred);parent.frames[2].document.getElementById('calcomp').disabled = false; --></script>");
				else
					out.print("<script>parent.frames[2].document.DischargePatient_form.deceased_yn.checked = false;parent.frames[2].document.DischargePatient_form.deceased_yn.disabled = true;parent.frames[2].document.DischargePatient_form.deceased_yn.value = 'N';parent.frames[2].document.DischargePatient_form.post_mortem_request.checked = false;parent.frames[2].document.DischargePatient_form.post_mortem_request.disabled = true;parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.value='';parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.disabled = true;parent.frames[2].document.getElementById('deceasedimg').style.visibility='hidden';parent.frames[2].document.DischargePatient_form.new_medicine.disabled = false;parent.frames[3].document.getElementById('Medical_Certificate').disabled=false;<!-- parent.frames[2].document.DischargePatient_form.bookingappointment.disabled=false;parent.frames[2].document.DischargePatient_form.referred.disabled=false;parent.frames[2].document.getElementById('calcomp').disabled = true;parent.frames[2].document.DischargePatient_form.bookingappointment.disabled=false; --></script>"); 
			}
		}
		else if(from.equals("Prepare_Discharge_form"))
		{
			// Changed Frame reference from frames[1] to frames[2] as Prepare Discharge form Design Changed on 27 MAY 2004 by SRIDHAR ...
			String	dischargetypecode =	value1;
			String	pat_dtls_unknown_yn	=	value3;
			String	deceasedyn =	value2;
			String patient_status = request.getParameter("patient_status");
			
			if(patient_status == null)patient_status = "";

			if(dischargetypecode.equals(""))
			{
				out.print("<script>parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled=true;parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;</script>");
			}
			else if(!dischargetypecode.equals(""))
			{
				sql		=	"  select deceased_yn from IP_DISCHARGE_TYPE where discharge_type_code = '"+dischargetypecode+"' and eff_status = 'E' ";
				
				rset	=	stmt.executeQuery(sql);
				if(rset != null && rset.next())
					deceasedyn	=	rset.getString("deceased_yn");
				if (rset!=null) rset.close();
					
				out.println("<script>parent.frames[2].document.dischargeadvice_form.check_death_date.value = \""+deceasedyn+"\";</script>");
	if(deceasedyn.equals("Y"))
	{
	%><script>
		parent.frames[2].document.getElementById('deathlable').innerText	    =	"Death Date/Time ";
		parent.frames[2].document.getElementById('death_id').style.visibility	    =	"Visible";
		parent.frames[2].document.getElementById('selcalimg').style.visibility	    =	"Visible";
		parent.frames[2].document.getElementById('postmortlable').innerText	    =	"Post-mortem requested ";
		parent.frames[2].document.getElementById('post_check').style.visibility	    =	"Visible";
		parent.frames[2].document.getElementById('deathimg').style.visibility	    =	"Visible";
		parent.frames[2].document.dischargeadvice_form.death_date.disabled	=	false;
		parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility	=	'visible'; 
		parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled = false;
		parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=true;
		parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=true;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=true;
		parent.frames[2].document.dischargeadvice_form.lab.checked=false;
		parent.frames[2].document.dischargeadvice_form.lab.disabled=true;
		parent.frames[2].document.dischargeadvice_form.xray.checked=false;
		parent.frames[2].document.dischargeadvice_form.xray.disabled=true;
		parent.frames[2].document.dischargeadvice_form.scan.checked=false;
		parent.frames[2].document.dischargeadvice_form.scan.disabled=true;
		parent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;
		parent.frames[2].document.dischargeadvice_form.ultrasound.disabled=true;
		parent.frames[2].document.dischargeadvice_form.mri.checked=false;
		parent.frames[2].document.dischargeadvice_form.mri.disabled=true;
		parent.frames[2].document.dischargeadvice_form.rt.checked=false;
		parent.frames[2].document.dischargeadvice_form.rt.disabled=true;
		parent.frames[2].document.dischargeadvice_form.physio.checked=false;
		parent.frames[2].document.dischargeadvice_form.physio.disabled=true;
		parent.frames[2].document.dischargeadvice_form.ecg.checked=false;
		parent.frames[2].document.dischargeadvice_form.ecg.disabled=true;
		parent.frames[2].document.dischargeadvice_form.diet.checked=false;
		parent.frames[2].document.dischargeadvice_form.diet.disabled=true;
		parent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;
		parent.frames[2].document.dischargeadvice_form.pharmacy.disabled=true;
		
	</script>
	  <%
	  /// If the Discahrge Type is "Deceased" then the Absconding details must not be Entered...
		
	}		  
		else if ((pat_dtls_unknown_yn.equals("Y")) && (!deceasedyn.equals("Y")))
		{	out.print("<script>parent.frames[2].document.dischargeadvice_form.death_date.value='';parent.frames[2].document.dischargeadvice_form.death_date.disabled=true;parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility='hidden';parent.frames[2].document.getElementById('death_id').style.visibility='hidden';parent.frames[2].document.getElementById('selcalimg').style.visibility='Hidden';parent.frames[2].document.getElementById('post_check').style.visibility='hidden';parent.frames[2].document.getElementById('deathimg').style.visibility='hidden';parent.frames[2].document.getElementById('calImage1').disabled=true;parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.referral_type.value='X';parent.frames[2].getval1(parent.frames[2].document.dischargeadvice_form.referral_type);parent.frames[2].document.dischargeadvice_form.referral_type.disabled=true;</script>");
		
		  			/// If the Discahrge Type is not "Deceased" then the Absconding details can be Entered...
					out.print("<script>parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_yn.checked=false;parent.frames[2].document.dischargeadvice_form.absconding_date.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_date.value='';parent.frames[2].document.getElementById('calImage').disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.value='';parent.frames[2].document.getElementById('AbsImg').style.visibility='Hidden'; </script>");

	}
	else 
	{
		if(!patient_status.equals("3"))
		{	out.print("<script>parent.frames[2].document.dischargeadvice_form.death_date.value='';parent.frames[2].document.dischargeadvice_form.death_date.disabled=true;parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility='hidden';parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false; </script>");%>
			<script>
			parent.frames[2].document.getElementById('deathlable').innerText	    =	'';
			parent.frames[2].document.getElementById('death_id').style.visibility	    =	"Hidden";
			parent.frames[2].document.getElementById('selcalimg').style.visibility	    =	"Hidden";
		
			parent.frames[2].document.getElementById('postmortlable').innerText	    =	'';
			parent.frames[2].document.getElementById('post_check').style.visibility	    =	"Hidden";
			parent.frames[2].document.getElementById('deathimg').style.visibility	    =	"Hidden";
			</script>
			<%if(!patient_status.equals("4"))
			{
				out.print("<script>parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_yn.checked=false;parent.frames[2].document.dischargeadvice_form.absconding_date.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_date.value='';parent.frames[2].document.getElementById('calImage').disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.value='';parent.frames[2].document.getElementById('AbsImg').style.visibility='Hidden';</script>");
			}
			%>
		<script>
		parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;
		parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false;
		parent.frames[2].document.dischargeadvice_form.lab.checked=false;
		parent.frames[2].document.dischargeadvice_form.lab.disabled=false;
		parent.frames[2].document.dischargeadvice_form.xray.checked=false;
		parent.frames[2].document.dischargeadvice_form.xray.disabled=false;
		parent.frames[2].document.dischargeadvice_form.scan.checked=false;
		parent.frames[2].document.dischargeadvice_form.scan.disabled=false;
		parent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;
		parent.frames[2].document.dischargeadvice_form.ultrasound.disabled=false;
		parent.frames[2].document.dischargeadvice_form.mri.checked=false;
		parent.frames[2].document.dischargeadvice_form.mri.disabled=false;
		parent.frames[2].document.dischargeadvice_form.rt.checked=false;
		parent.frames[2].document.dischargeadvice_form.rt.disabled=false;
		parent.frames[2].document.dischargeadvice_form.physio.checked=false;
		parent.frames[2].document.dischargeadvice_form.physio.disabled=false;
		parent.frames[2].document.dischargeadvice_form.ecg.checked=false;
		parent.frames[2].document.dischargeadvice_form.ecg.disabled=false;
		parent.frames[2].document.dischargeadvice_form.diet.checked=false;
		parent.frames[2].document.dischargeadvice_form.diet.disabled=false;
		parent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;
		parent.frames[2].document.dischargeadvice_form.pharmacy.disabled=false;
		</script>
						<%
		}
		else
		{
			out.print("<script>parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false; <!-- parent.frames[2].document.dischargeadvice_form.referred.disabled=true; --></script>");%>
			<script>
			parent.frames[2].document.getElementById('deathlable').innerText	    =	'';
			parent.frames[2].document.getElementById('death_id').style.visibility	    =	"Hidden";
			parent.frames[2].document.getElementById('selcalimg').style.visibility	    =	"Hidden";
		
			parent.frames[2].document.getElementById('postmortlable').innerText	    =	'';
			parent.frames[2].document.getElementById('post_check').style.visibility	    =	"Hidden";
			parent.frames[2].document.getElementById('deathimg').style.visibility	    =	"Hidden";
			</script>
	<%
		}
	 }
			}
		
	
			if(patient_status.equals("3") || patient_status.equals("4"))
			{
			%>	
			<script>
				parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;
				parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=true;
				parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;
				parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=true;
				parent.frames[2].document.dischargeadvice_form.lab.checked=false;
				parent.frames[2].document.dischargeadvice_form.lab.disabled=true;
				parent.frames[2].document.dischargeadvice_form.xray.checked=false;
				parent.frames[2].document.dischargeadvice_form.xray.disabled=true;
				parent.frames[2].document.dischargeadvice_form.scan.checked=false;
				parent.frames[2].document.dischargeadvice_form.scan.disabled=true;
				parent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;
				parent.frames[2].document.dischargeadvice_form.ultrasound.disabled=true;
				parent.frames[2].document.dischargeadvice_form.mri.checked=false;
				parent.frames[2].document.dischargeadvice_form.mri.disabled=true;
				parent.frames[2].document.dischargeadvice_form.rt.checked=false;
				parent.frames[2].document.dischargeadvice_form.rt.disabled=true;
				parent.frames[2].document.dischargeadvice_form.physio.checked=false;
				parent.frames[2].document.dischargeadvice_form.physio.disabled=true;
				parent.frames[2].document.dischargeadvice_form.ecg.checked=false;
				parent.frames[2].document.dischargeadvice_form.ecg.disabled=true;
				parent.frames[2].document.dischargeadvice_form.diet.checked=false;
				parent.frames[2].document.dischargeadvice_form.diet.disabled=true;
				parent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;
				parent.frames[2].document.dischargeadvice_form.pharmacy.disabled=true;
			</script>
			<%	
			}

		}				
		else if(value2.trim().length() > 0 && value5.trim().length() == 0 && continueyn)
		{
			/*
			stmt = con.createStatement();
			sql = " Select referral_id from PR_ENCOUNTER where facility_id = '" + facilityId + "' and patient_class not in ('OP', 'EM') and adt_status != '09' and patient_id = '" + value2 + "' Order by VISIT_ADM_DATE_TIME " ;
	
			rset = stmt.executeQuery(sql);
	
			if(rset.next()) //take value from last row
			{
				financial_detail_ref_id = checkForNull(rset.getString("referral_id"));
			}
			if (rset!=null) rset.close();
			if (stmt!=null) stmt.close();
			if(financial_detail_ref_id.trim().length() > 0)
			{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value == '')");
				out.print("parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value='" + financial_detail_ref_id + "'</script>");	
			}
	
			String orgTypeSQL =" select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referralid+"' and a.from_ref_code = b.referral_code";
			stmt = con.createStatement();
			rset = stmt.executeQuery(orgTypeSQL) ;
			if(rset.next()) 
			{
				org_type_data = rset.getString("org_type");
				if(org_type_data == null) org_type_data = "";
				if(org_type_data.equals("P"))  		
					org_type_data="P";
				else
					org_type_data="G";
				if (rset!=null) rset.close();
				if (stmt!=null) stmt.close();
			}
			else
			{
				org_type_data="G";
			}
	
			if(org_type_data.trim().length() > 0)
			{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form && parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value == '')");
				out.print("parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value='"+org_type_data+"'</script>");	
			}
			*/
		}
	
	if( from.equals("Select_form") && ((!(bookingrefno.equals(""))) || (!(patientid.equals("")))) && (continueyn) )
	{	%>
			<script>
				parent.frames[1].frames[3].document.getElementById("contact_details").disabled = false;
			</script>
<%	}

	if( from.equals("Select_form") && (bookingrefno.equals("")&& patientid.equals("")) && (continueyn) )
	{
	%>
		<script>
			parent.frames[1].frames[3].document.getElementById("contact_details").disabled = true;
					</script>
	<%
	}
	
	if( ( from.equals("Select_form")  || from.equals("Main_form") || from.equals("AdmitPatient_form")) && continueyn )
	{	%>
		<script>
		if (continueFlag=="Y")
		{
			makeDisabled(true);
			var frame_ref = "<%=frame_ref%>";
			if(frame_ref == "")
			frame_ref = "parent.frames[1].frames[2]";

			if(eval(frame_ref+'.document.AdmitPatient_form.nursing_unit'))
			{
				Splcode = eval(frame_ref+'.document.AdmitPatient_form.Splcode.value');
				if(Splcode=="")	Splcode	=	"<%=specialitycode%>";
			}
		}
		</script>
<%	}
	else
	{	%>
		<script>
			if (continueFlag=="Y")
			makeDisabled(false);
		</script>		
	<%
	}
	/*//added on 3-7-2008 for SCR 3228*/
	%>
	<%
	if (from.equals("Prepare_Discharge_advice")) 
	{
		if(discharge_type.equals(""))	
		{	
	%>
			<script>
				var n = parent.frames[2].document.getElementById("dischargestatus").options.length;
				for(var i=0;i<n;i++)
				{ 
					parent.frames[2].document.getElementById("dischargestatus").remove(0);
				}
				var tp ="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[2].document.getElementById("dischargestatus").add(opt);
			</script>
	<%
		}
		else
		{	
	%>
			<script>
			var n = parent.frames[2].document.getElementById('dischargestatus').options.length;
			for(var i=0;i<n;i++)
			{ 
				parent.frames[2].document.getElementById('dischargestatus').remove(0);
			}
			var tp ="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			var opt=parent.frames[2].document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
				parent.frames[2].document.getElementById('dischargestatus').add(opt);
		</script>
		<%
			if(indicator.equals("DS"))
			{
				String stat_sql = "select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind = 'D' order by short_desc";
				
				rset = stmt.executeQuery(stat_sql);
				if( rset!=null )
				{
					while(rset.next())
					{
						code = rset.getString("discharge_status_code");
						desc = rset.getString("short_desc");
						%>
							<script>
								
								var oOption = parent.frames[2].document.createElement("OPTION");
								oOption.text="<%=desc%>";
								oOption.value="<%=code%>";
								parent.frames[2].document.getElementById('dischargestatus').add(oOption);
								
							</script>
						<%
					}
				}
			}
			else 
			{
				String stat_sql = "select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind in ('C','P','S','W') order by short_desc";
				
				rset = stmt.executeQuery(stat_sql);
				if( rset!=null )
				{
					while(rset.next())
					{
						code = rset.getString("discharge_status_code");
						desc = rset.getString("short_desc");
						%>
							<script>
								
								var oOption = parent.frames[2].document.createElement("OPTION");
								oOption.text="<%=desc%>";
								oOption.value="<%=code%>";
								parent.frames[2].document.getElementById('dischargestatus').add(oOption);
							</script>
						<%
					}
				}
			}
	}
		
	}%>

	<%/*3228*/
}
catch(Exception e)
{
	out.print(e.toString());
	e.printStackTrace();
}
finally
{
	if(stmt != null) stmt.close();
	if(rset != null ) rset.close();
	ConnectionManager.returnConnection(con,request);
}
%>
<!-- Added on 28/04/2003-->
	<input type = 'hidden' name = 'queryString' value="<%=queryString%>">
	<input type = 'hidden' name = 'referralid' value="<%=referralid%>">
	<input type = 'hidden' name = 'sStyle' value="<%=sStyle%>">
</body>
</form>
</html>
<!-- 
The Following Method is to compare the date passesd as String argument with sysdate+offset Days.
It returns true if Argument Date is less than Sysdate
-->

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

