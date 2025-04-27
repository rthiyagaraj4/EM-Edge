<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String locale					= (String)session.getAttribute("LOCALE");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%! 
public String singleToDoubleQuotes(String strDB)
{
	/*
	StringBuffer stringbuffer	= new StringBuffer(strDB);
	String strModified			= "";
	int i						= 0;

	for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
	{
		i = strDB.indexOf('\'', i);
		stringbuffer.insert(i + j, "'");
		i++;
	}
	strModified=stringbuffer.toString();
	return strModified;
	*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}
	String priority_ind_scr		= "";
	
%>


<%
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facility_id			= (String)session.getAttribute("facility_id");
	String param				= checkForNull(request.getParameter("param"));
	String function_id			= checkForNull(request.getParameter("function_id"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String loc_lang				= checkForNull(request.getParameter("loc_lang"));
	String booking_type			= "";
	String revise_booking_yn	= request.getParameter("revise_booking_yn");
		if(revise_booking_yn == null) revise_booking_yn="";
	String cancel_booking_yn	= request.getParameter("cancel_booking_yn");
		if(cancel_booking_yn == null) cancel_booking_yn="";
	String confirm_booking_yn	= request.getParameter("confirm_booking_yn");
		if(confirm_booking_yn == null) confirm_booking_yn="";
	String create_booking_with_conf_yn = request.getParameter("create_booking_with_conf_yn");
		if(create_booking_with_conf_yn == null) create_booking_with_conf_yn="";
	String create_booking_yn	= request.getParameter("create_booking_yn");
		if(create_booking_yn == null) create_booking_yn="";
	String booking_title		= checkForNull(request.getParameter("title"));


	booking_type				= checkForNull(request.getParameter("booking_type"));
	String bkg_grace_period		= checkForNull(request.getParameter("bkg_grace_period"));
	String capture_fin_dtls_yn  = checkForNull(request.getParameter("capture_fin_dtls_yn"));
	String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
	String login_user			= (String)session.getAttribute("login_user");
	session.removeAttribute("ipPatInstructionsMap");//RUT-CRF-13.1
	
	//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
    String noshow_bkng_period1   =  checkForNull(request.getParameter("noshow_bkng_period")); 
	int noshow_bkng_period = 0;
	if(!(noshow_bkng_period1.equals(""))){
		  noshow_bkng_period = Integer.parseInt(noshow_bkng_period1);
	}
	
	int diff_min   = 0;  
	String flag1 ="N" ;
	//end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	//String pat_cat_val = "";
	//String bkg_ref_no = "";
	
	String fam_name_ind = checkForNull(request.getParameter("fam_name_ind"));
	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/

%>

<html>
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/dchk.js' language='javascript'></script>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <script>
		async function runReport1(enc, patid,nursing_unit_code)
		{
			var retVal			= 	new String();
			var dialogHeight	= "75vh" ;
			var dialogWidth		= "65vw" ;
			var dialogTop		= "58";
			var center			= "1" ;
			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments		= "" ;
			var facility_id		= "<%=facility_id%>";				
			var gen_file_no		= "";
			var location_type	= "N";
			var reportParamNames= "P_BKG_LST_REF_NO,Patient_ID";
			var reportParamValues= ""+enc+","+patid+"";
			//var pat_cat_val =  document.forms[0].pat_cat_val.value;
			var xmlHttp			= new XMLHttpRequest(); 
			xmlHttp.open("POST","../../eIP/jsp/internalReportValidation.jsp?steps=1&patient_id="+patid,false);
			xmlHttp.send(null);
			responseText		= xmlHttp.responseText;  
			responseText		= trimString(responseText);
			var pat_cat_val		= responseText;

			if(pat_cat_val != "")
			{
				var sqlString	= "select distinct a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from IP_ONLINE_REPORT a, SM_REPORT_lang_vw b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and print_on_booking_yn='Y' and a.report_id = b.report_id and language_id = '"+localeName+"' and a.report_id NOT IN 'IPBBKSLP' order by 2 ";
			}else
			{
				var sqlString	= "select distinct a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from IP_ONLINE_REPORT a, SM_REPORT_lang_vw b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and print_on_booking_yn='Y' and a.report_id = b.report_id and language_id = '"+localeName+"' and a.report_id NOT IN  'IPBKSVIP' order by 2 ";
			}
			//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			retVal				= 	await top.window.showModalDialog("../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=BOOKINGREPORT&step=1&P_BKG_LST_REF_NO="+enc+"&Patient_ID="+patid+"&dest_locn_type="+location_type+"&dest_locn_code="+nursing_unit_code+"&sqlString="+escape(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues,arguments,features);
		}

/// Added by SRIDHAR R on 29 JUNE 2004 
/// Function viewReferral() will call the Referral Details Page if the Functions are 
/// Admit Patient [AT] OR Revise/Cancel Booking [RCB] OR Active Booking [AB] ...

		async function viewReferral(ref)
		{
			var retVal			= 	new String();
			var dialogHeight	= "700px";
			var dialogWidth		= "1200px";
			var dialogTop		= "72";

			var status			= "no";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;

			var retVal			= await window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
		}
			
		function closeWin(val,val2,val3,val4,val5,val6,val7,val8,val9)
		{
			
			var retVal			= val+","+val2+","+val3+","+val4+","+val5+","+val6+","+val7+","+val8;
			window.returnValue	= retVal
			window.parent.close()
		}

		async function showModal(valu)
		{
			if(document.forms[0].param.value != 'returnval')
			{
                
				var retVal		=    new String();
				var calling_func= "<%=call_function%>";
				var param		= "<%=param%>";
				var dialogHeight= "90vh";
				var dialogWidth = "95vw";
				var dialogTop	= "0vw";

				var center		= "1" ;
                var status		= "no";
				var alrtmsg		= "<%=oper_stn_id%>";

                var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var condition	= "" ;
				for(var i=0; i<document.forms[0].elements.length; i++)
				{
						condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
						
				}
                var arguments   = "" ;
                retVal			= await top.window.showModalDialog("../../eIP/jsp/AmendBookingMain.jsp?function_id=<%=function_id%>&bookingRefNo="+valu+"&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function="+calling_func+"&"+condition,arguments,features);
				
				if(calling_func == 'RCB')
					parent.frames[1].document.location.reload();
				else if(calling_func == 'AB')
					parent.frames[2].document.location.reload();
				else
					parent.frames[1].document.location.href="../../eIP/jsp/BookingReferenceLookupCriteria.jsp?param="+param+"&call_function="+calling_func;
			}
			else
			{
				//parent.window.returnValue=valu ;
				//parent.window.close();
				let dialogBody = parent.parent.document.getElementById('dialog-body');

    			dialogBody.contentWindow.returnValue = valu;

    			const dialogTag = parent.parent.document.getElementById("dialog_tag");    

    			dialogTag.close();   
			}
		}
		
		async function callCanRev(valu,cliniccode,apptdate)
		{
      			
				var calling_func = "<%=call_function%>";
				var	booking_typ  = "<%=booking_type%>";
				var dialogHeight = "80vh" ;
                var dialogWidth  = "75vw" ;
                var dialogTop    = "71" ;
				/*var dialogHeight= "42" ;
				var dialogWidth = "65" ;
				var dialogTop = "87" ;*/
                var center       = "1" ;
                var status		 = "no";
				var value1		 = valu;
				var value2       = cliniccode;
				var value3       = "";
				var value5       = apptdate;
				var value6       = "";
				var value7       = "";
				var clinic_type  = "";
				if(booking_typ == 'D')
					clinic_type  = "D";
				else
					clinic_type  = "I";

				var res_type     = "R";
                var features     = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
                var arguments    = "" ;
				var condition	 = "" ;
				for(var i=0; i<document.forms[0].elements.length; i++)
				{
						condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
						
				}
				if(booking_typ=='I'|| calling_func == 'RCB'|| calling_func == 'BookingReport')
				retVal = await top.window.showModalDialog("../../eIP/jsp/AmendBookingMain.jsp?function_id=<%=function_id%>&calling=AB&bookingRefNo="+escape(valu)+"&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function="+calling_func+"&bkg_type="+booking_typ+"&"+condition,arguments,features);
				else
				retVal =await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value1+"&i_clinic_code="+value2+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&clinic_type="+clinic_type+"&res_type="+res_type+"&call_function=admit"+"&"+condition,arguments,features);
          }
			
		async function showRemarks(bookingRefNo)
		{
			var retVal1;
			var calling_from			= "BookingReferenceLookupResult";
			var arguments				= "";
			var facilityid				= '<%=facility_id%>';
			var dialogHeight			= "12" ;
			var dialogWidth				= "23" ;
			var dialogTop				= "330";
			var dialogLeft				= "430";
				var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
			retVal1						= await window.showModalDialog("../../eIP/jsp/remarks.jsp?remarks="+calling_from+"&facilityid="+facilityid+"&bookingRefNo="+encodeURIComponent(bookingRefNo)+" ",arguments,features);
		}

		function callMouseOverRemarks(obj,viewremarks)
		{
				
				var Remarks				= getLabel("Common.remarks.label","Common");
				var tabdata				= "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body><table class='grid' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>"+Remarks+"</td></tr><tr><td>"+viewremarks+"</td></tr></table></body></html>";

				document.getElementById("details").innerHTML = tabdata;

				var wdth 				= obj.offsetWidth;
				var hght1 				= obj.offsetHeight;

				var wdth1				= getPos(obj).x - wdth;
				var hght				= getPos(obj).y + hght1;
				
				document.getElementById("details").style.posTop  = hght;
				document.getElementById("details").style.posLeft  = wdth1;
				document.getElementById("details").style.visibility = 'visible' ;
					

	}
		function callOnMouseOutRemarks(obj)
		{
			document.getElementById("details").style.visibility='hidden' ;
		}
		function getPos(inputElement)
		{
		var coords =  new Object();
		coords.x = 0;
		coords.y = 0;
		try
		{
			targetElement = inputElement;
			if(targetElement.x && targetElement.y)
			{
				coords.x = targetElement.x;
				coords.y = targetElement.y;
			}
			else
			{
				if(targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
					while(targetElement = targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
					}
				}
				else
				{
					//alert("Could not find any reference for coordinate positioning.");
				}
			}
			return coords;
		}
		catch(error)
		{
			return coords;
		}
		}
     </script>
			
	<%
		if(booking_title!=null && !booking_title.equals(""))
		{
			out.println("<title>"+booking_title+"</title>");
		}
		
		CallableStatement	Cs_book = null;
		Connection			con		= null;
		Statement			stmt	= null;
		Statement			ipstmt	= null;
		Statement			pat_cat_stmt	= null;
		ResultSet			rs		= null;
		ResultSet			iprs	= null;
		ResultSet			pat_cat_rs	= null;
		
		StringBuffer where_criteria	= new StringBuffer();
		StringBuffer ipsql	    	= new StringBuffer();
		//StringBuffer sql		 = new StringBuffer();
		String class_val		 = "QRYEVENSMALL";
		String priority_ind		 = ""; 
		String temp				 = ""; 
		String priority_ind_desc = "";
		String booking_stat		 = "";
		String whereClause		 = request.getParameter("whereclause");
		String from				 = request.getParameter("from") ;
		String to				 = request.getParameter("to");

		String soundex_type		 = checkForNull(request.getParameter("soundex"));
		String nursing_unit_code = checkForNull(request.getParameter("nursing_unit"));
		String daycare_code		 = checkForNull(request.getParameter("daycare_unit"));
		String speciality_code   = checkForNull(request.getParameter("Splcode"));
		String practitioner_id   = checkForNull(request.getParameter("practid"));
		String from_date		 = checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 

		String to_date			 = checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
		String patient_id		 = checkForNull(request.getParameter("patient_id"));

		//String ismult_bkg_yn_flag	 = checkForNull(request.getParameter("ismult_bkg_yn_flag"));
		String gender			 = checkForNull(request.getParameter("gender"));
		String name_prefix		 = checkForNull(request.getParameter("name_prefix"));
		String name_suffix		 = checkForNull(request.getParameter("name_suffix"));
		String first_name		 = checkForNull(request.getParameter("first_name"));
		String second_name		 = checkForNull(request.getParameter("second_name"));
		String third_name		 = checkForNull(request.getParameter("third_name"));
		String family_name		 = checkForNull(request.getParameter("family_name"));
		String national_id_no	 = checkForNull(request.getParameter("national_id_no"));
		String alt_id1_no		 = checkForNull(request.getParameter("alt_id1_no"));
		String alt_id2_no		 = checkForNull(request.getParameter("alt_id2_no"));
		String alt_id3_no		 = checkForNull(request.getParameter("alt_id3_no"));
		String alt_id4_no		 = checkForNull(request.getParameter("alt_id4_no"));
		String other_alt_type	 = checkForNull(request.getParameter("other_alt_type"));
		String other_alt_Id		 = checkForNull(request.getParameter("other_alt_Id"));
		String bed_class_code	 = checkForNull(request.getParameter("Bedcode"));
		String bed_type_code	 = checkForNull(request.getParameter("bed_type_code"));
		String med_service_grp	 = checkForNull(request.getParameter("med_service_grp"));
		/*modification for SRR20056-CRF-0506*/
		String ip_booking_type 	 = checkForNull(request.getParameter("ip_booking_type"));
		booking_stat = checkForNull(request.getParameter("booking_stat"));
		String searchby = checkForNull(request.getParameter("searchby"));
		if (searchby.equals("")) 
			searchby="S";

		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
		String booking_ref_no		= checkForNull(request.getParameter("booking_ref_no"));
		String ref_type			 = "";
		String ref_source		 = "";
		String referral_id		 = "";
		String ref_pract_name	 = "";
		String ambulance_reqd_yn = "";
		String add_yn			 = "N";
		String past_booking		 = "";
		String booking_type_desc = "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
		//Start
		String surgery_date="";
		String surgery_order="";
		//End

		if(call_function.equals("AB"))
		{
			ambulance_reqd_yn = request.getParameter("ambulance_reqd_yn");	
			ref_type		  = request.getParameter("ref_type");
			//ref_source	      = request.getParameter("ref_source");
			ref_source	      = request.getParameter("referral_source1");
			referral_id	      = request.getParameter("referral_id");
			ref_pract_name	  = request.getParameter("ref_pract_name");
		}
		if(call_function.equals("AT"))
		{
			past_booking = checkForNull(request.getParameter("past_booking"));
		}

		if(ambulance_reqd_yn == null || ambulance_reqd_yn.equals("null")) ambulance_reqd_yn = "N";

		if(name_prefix != null)
			name_prefix=singleToDoubleQuotes(name_prefix);

		if(name_suffix != null)
			name_suffix=singleToDoubleQuotes(name_suffix);              

		if (booking_stat==null) 
			booking_stat="";

		String patient_name				= "";
		String bed_no					= "";
		String patient_id1				= "";
		String turndownreason			= "";
		String bookingStatus			= "";
		String link_referral_id			= "";
		String bed_type					= "";
		String bed_type_desc			= "";
		String bed_class				= "";
		String bed_class_desc			= "";
		String callwinPatientid			= "";
		String nursingunit_code			= "";
		String room_no					= "";	
		String speciality_desc			= "";
		String booking_reason			= "";
		String revision_reason			= "";
		String booking_remarks			= "";
		//String view						= "";
		int	p_max_rec_cnt=0;
		  
		
		  
		

	%>
    </head>                         
    <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
    <form name = 'BookingReferenceLookupResult_form'>
	<%
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		ipstmt	= con.createStatement();
		pat_cat_stmt	= con.createStatement();
		if(whereClause==null)
		{
			where_criteria.append(" and a.facility_id='"+facility_id+"'");

			if(ambulance_reqd_yn.equals("Y"))
				where_criteria.append(" and a.amb_reqd_yn ='"+ambulance_reqd_yn+"' ");

			if(!call_function.equals("AB"))
			{	
				if(booking_type.equals("D")&& !daycare_code.equals(""))
				{
					where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
				}
				else
				{
					if(booking_type.equals("D")&&!daycare_code.equals(""))
					{
						where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
					}
					else if(booking_type.equals("I"))
					{
						if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
							where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"') ");
						else
							where_criteria.append(" and (a.nursing_unit_code in (Select n.nursing_unit_code from IP_NURSING_UNIT n, AM_OS_USER_LOCN_ACCESS_VW b where n.facility_id='"+facility_id+"' and n.eff_status = 'E' and b.locn_type = 'N' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"')  or a.nursing_unit_code is null)");
					}
				}
			}
			else
			{
				if(booking_type.equals("D"))
				{
					where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
				}
				else
				{
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
						where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"')");
				}
			}
			if(!booking_type.equals("D"))
			{

				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
				where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"')");

				if(speciality_code!=null && !speciality_code.equals(""))
				where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
			}
			if(practitioner_id!=null && !practitioner_id.equals(""))
				where_criteria.append( " and a.practitioner_id='"+practitioner_id+"' ");
			if(booking_type.equals("D"))
			{
				if(from_date!=null && !from_date.equals(""))
				where_criteria.append(" and trunc(a.appt_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
			}
			else
			{
				if(from_date!=null && !from_date.equals(""))
				where_criteria.append(" and trunc(a.preferred_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
			}
			
			if(to_date!=null && !to_date.equals(""))
			{
				if(booking_type.equals("D"))
				{
					if(past_booking.equals("Y"))
					where_criteria.append( " and trunc(a.appt_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					else
					where_criteria.append( " and trunc(a.appt_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				}
				else
				{
					if(past_booking.equals("Y"))
					where_criteria.append( " and trunc(a.preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					else
					where_criteria.append( " and trunc(a.preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				}
			}
			else if(past_booking.equals("Y"))
			{
				java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy " ) ;
				 java.util.Date dt=new java.util.Date();
				 String d = dateFormat.format( dt ) ;
				if(booking_type.equals("D"))
				{
					where_criteria.append( " and trunc(a.appt_date) < to_date('"+d+"' , 'dd/mm/rrrr') ");
				}
				else
				{
					where_criteria.append( " and trunc(a.preferred_date) < to_date('"+d+"' , 'dd/mm/rrrr') ");
				}
			}

			if( call_function.equals("AB") || call_function.equals("AT") || call_function.equals("RCB") ||  call_function.equals("BookingReport") || call_function.equals("Booking_Admission"))
			{
				if(!booking_type.equals("D"))
				{
					if(!bed_class_code.equals(""))
						where_criteria.append( " and BED_CLASS_CODE = '"+bed_class_code+"' ");

					if(!bed_type_code.equals(""))	
						where_criteria.append( " and BED_TYPE_CODE = '"+bed_type_code+"' ");
		
					if(!med_service_grp.equals(""))	
						where_criteria.append( " and MED_SER_GRP_CODE = '"+med_service_grp+"' ");

					/*modification for SRR20056-CRF-0506*/
				
					if(!ip_booking_type.equals(""))	
						where_criteria.append( " and BOOKING_TYPE_CODE = '"+ip_booking_type+"' ");
				}
			}

			if(booking_ref_no!=null && !booking_ref_no.equals(""))
				where_criteria.append( " and a.BKG_LST_REF_NO like '"+booking_ref_no+"%' ");

			//if(patient_id!=null && !patient_id.equals("") )
			//if(patient_id!=null && !patient_id.equals("") && ismult_bkg_yn_flag.equals("Y"))	
			if(patient_id!=null && !patient_id.equals("") )
				where_criteria.append( " and a.patient_id like '"+patient_id+"%' ");

			if(gender!=null && !gender.equals(""))
				where_criteria.append( " and a.gender = '"+gender+"' ");

			if(name_prefix!=null && !name_prefix.equals(""))
				where_criteria.append(" and a.name_prefix = '"+name_prefix+"' ");

			if(name_suffix!=null && !name_suffix.equals(""))
				where_criteria.append( " and a.name_suffix = '"+name_suffix+"' ");
			
			if(national_id_no!=null && !national_id_no.equals(""))
				where_criteria.append(" and a.national_id_no = '"+national_id_no+"'");
			
			if(alt_id1_no!=null && !alt_id1_no.equals(""))
				where_criteria.append( " and a.alt_id1_no = '"+alt_id1_no+"'");

			if(alt_id2_no!=null && !alt_id2_no.equals(""))
				where_criteria.append(" and a.alt_id2_no = '"+alt_id2_no+"'");

			if(alt_id3_no!=null && !alt_id3_no.equals(""))
				where_criteria.append(" and a.alt_id3_no = '"+alt_id3_no+"'");

			if(alt_id4_no!=null && !alt_id4_no.equals(""))
				where_criteria.append( " and a.alt_id4_no = '"+alt_id4_no+"'");

			if(other_alt_type!=null && !other_alt_type.equals(""))
				where_criteria.append( " and a.oth_alt_id_type = '"+other_alt_type+"'");

			if(other_alt_Id!=null && !other_alt_Id.equals(""))
				where_criteria.append( " and a.oth_alt_Id_no = '"+other_alt_Id+"'");
	
		if(soundex_type.equals("E"))
		{
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.first_name_loc_lang)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.second_name_loc_lang)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.third_name_loc_lang)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				String fam_name_search = "";
				if (pat_name_as_multipart_yn.equals("N"))
				{
					StringTokenizer stktok = new StringTokenizer(family_name, " ");
					if (stktok.hasMoreTokens())
						fam_name_search = stktok.nextToken();
					else
						fam_name_search = family_name;
				}
				else
					fam_name_search = family_name;

				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.family_name)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.family_name_loc_lang)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
			}
		}
		else if(soundex_type.equals("G"))
		{
		
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(soundex(a.first_name)) like upper(soundex('" +first_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(soundex(a.first_name_loc_lang)) like upper(soundex('" +first_name +"')) || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(soundex(a.second_name)) like upper(soundex('" + second_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(soundex(a.second_name_loc_lang)) like upper(soundex('" + second_name +"')) || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(soundex(a.third_name)) like upper(soundex('"+ third_name+"')) || '%' ");
				else
					where_criteria.append(" and upper(soundex(a.third_name_loc_lang)) like upper(soundex('"+ third_name+"')) || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				String fam_name_search = "";
				if (pat_name_as_multipart_yn.equals("N"))
				{
					StringTokenizer stktok = new StringTokenizer(family_name, " ");
					if (stktok.hasMoreTokens())
						fam_name_search = stktok.nextToken();
					else
						fam_name_search = family_name;
				}
				else
					fam_name_search = family_name;

				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(soundex(a.family_name)) like upper(soundex('" +fam_name_search+"')) || '%' ");
				else
					where_criteria.append(" and upper(soundex(a.family_name_loc_lang)) like upper(soundex('" +fam_name_search+"')) || '%' ");
			}
		}
		else
		{/*
out.println("pat_name_as_multipart_yn==>"+pat_name_as_multipart_yn);
out.println("loc_lang==>"+loc_lang);
out.println("first_name==>"+first_name);*/
/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299 -Start*/
		if (fam_name_ind.equals("Y"))
			{

				if (searchby.equals("C"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
						else
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
					}
				}
				else if (searchby.equals("E"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
						else
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
					}
				}
				else
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
						else
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					}
				}
			
		}else
		  { /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299 - End*/
			if (pat_name_as_multipart_yn.equals("Y"))
			{
					
				if(first_name!=null && !first_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.first_name) like upper('" +first_name +"') || '%' ");
					else
						where_criteria.append(" and upper(a.first_name_loc_lang) like upper('" +first_name +"') || '%' ");
				}
				if(second_name!=null && !second_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.second_name) like upper('" + second_name +"') || '%' ");
					else
						where_criteria.append(" and upper(a.second_name_loc_lang) like upper('" + second_name +"') || '%' ");
				}

				if(third_name!=null && !third_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(a.third_name) like upper('"+ third_name+"') || '%' ");
					else
						where_criteria.append( " and upper(a.third_name_loc_lang) like upper('"+ third_name+"') || '%' ");
				}
					
				if(family_name!=null && !family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					else
						where_criteria.append( " and upper(a.family_name_loc_lang) like upper('" +family_name+"') || '%' ");
				}
			}
			else
			{						
				if (searchby.equals("C"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
						else
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
					}
				}
				else if (searchby.equals("E"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
						else
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
					}
				}
				else
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
						else
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					}
				}
			}
		  }	
		}
			if(call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("AT") || call_function.equals("Booking_Admission"))
			{
				priority_ind_scr  = checkForNull(request.getParameter("priority_ind"));
				
				/*if( (priority_ind_scr != null) && (!priority_ind_scr.equals("")))
				{
					where_criteria.append(" and upper(a.priority_ind) = upper('" +priority_ind_scr+"')");
				}*/
				if( (priority_ind_scr != null) && (!priority_ind_scr.equals("")) && (!booking_type.equals("D")))
				{
					where_criteria.append(" and upper(a.priority_ind) = upper('" +priority_ind_scr+"')");
				}
			}

			if(call_function.equals("AB"))
			{
				if( (ref_source != null) && (!ref_source.equals("")))
				{
					add_yn = "Y";

					if(ref_type.equals("X"))
						where_criteria.append(" and b.FROM_REF_CODE = '"+ref_source+"' ");
					else
						where_criteria.append(" and b.FROM_FACILITY_ID = '"+ref_source+"' ");
				}

				if( (referral_id != null) && (!referral_id.equals("")))
				{
					add_yn = "Y";
					//where_criteria.append( " and b.REFERRAL_ID = '"+referral_id+"' ");  
					where_criteria.append( " and upper(b.REFERRAL_ID) like  upper('"+referral_id+"') || '%' ");
				}

				if( (ref_pract_name != null) && (!ref_pract_name.equals("")))
				{
					add_yn = "Y";
					if(ref_type.equals("X"))
						where_criteria.append( " and b.FROM_PRACT_NAME = '"+ref_pract_name+"' ");
					else
						where_criteria.append( " and b.FROM_PRACT_ID = '"+ref_pract_name+"' ");
				}
			}
		}
		else
		{
			where_criteria.append(whereClause);
		}

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null )
			end = 12;
		else
			end = Integer.parseInt( to ) ;

		// This query is used for getting the grace period from ip param
		int maxRecord = 0;
		/*Saturday, May 08, 2010 ,condition added since in loadrunner this value getting null for multiuser */
		
		if(bkg_grace_period.equals(""))
		{
			ipsql.append("Select bkg_grace_period from IP_PARAM where facility_id='"+facility_id+"' ");
			iprs = ipstmt.executeQuery(ipsql.toString());

			if(iprs!= null)
			{
				if(iprs.next())
				{
					bkg_grace_period = iprs.getString("bkg_grace_period");         
				}                   
			}
			if(iprs != null) iprs.close();
			if(ipstmt != null) ipstmt.close();
		}
		/*if(booking_type.equals("D"))
		{
		sql.append(" select  count(1) from OA_APPT a ");
		}
		else
		{
		 sql.append(" select  count(1) from IP_BOOKING_LIST a ");
		}
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sql.append(", pr_referral_register b ");
		}
		sql.append( " where ");

		if ( call_function.equals("CB") )
			sql.append(" ( ( a.booking_status ='1'  and trunc(a.preferred_date)<= trunc(sysdate))  or a.booking_status='9')  " +where_criteria.toString());       
		else
		{
			if(call_function.equals("AT"))
			{
				
				if(past_booking.equals("Y"))
				{
					if(booking_type.equals("D"))
					{
					sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)<= trunc(sysdate)" +where_criteria.toString() );
					}
					else
					{
					sql.append(" a.booking_status='1'" +where_criteria.toString());
					}
				}
				else
				{
					if(booking_type.equals("D"))
					{
						sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString() );
					}
					else
					{
						sql.append( " a.booking_status='1' and trunc(a.preferred_date)>= trunc(sysdate) " +where_criteria.toString() );
					}
				}
			}
			else
			if(call_function.equals("AB"))
			{
				if(booking_type.equals("D"))
					sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " 	+where_criteria.toString() );
				else
					sql.append( " a.booking_status='1' and trunc(a.preferred_date)>=trunc(sysdate) " +where_criteria.toString() );
			}
			else
			{
				sql.append( " a.booking_status in ('0','1') and trunc(a.preferred_date)>= trunc(sysdate- "+maxperiodforrevbkg+") " +where_criteria.toString() );
			}
		}
   
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sql.append(" and a.REFERRAL_ID = b.REFERRAL_ID (+) ");
		}
		*/

			
		/*rs = stmt.executeQuery(sql.toString());
		rs.next();
		maxRecord = rs.getInt(1);
		if(rs!=null)rs.close();*/
	
	/*if(maxRecord == 0)
	{	*/%>
		<!--<script> 
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); 
		</script>-->
	<%/*	} 
	else
	{*/
	
		StringBuffer sqlSb = new StringBuffer();

		if(booking_type.equals("D"))
		{
			sqlSb.append(" select a.APPT_REF_NO bkg_lst_ref_no, a.CLINIC_CODE clinic_code,a.APPT_DATE,a.referral_id, to_char(a.APPT_DATE, 'dd/mm/rrrr')  ");
			sqlSb.append( "  disp_preferred_date, a.patient_id, decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name,");
			sqlSb.append( " a.gender , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, appt_STATUS from OA_APPT a ");  
		}
		else
		{
			/*sqlSb.append(" select a.bkg_lst_ref_no, a.preferred_date,a.referral_id, to_char(a.preferred_date, 'dd/mm/rrrr hh24:mi')  ");
			sqlSb.append( "  disp_preferred_date, a.patient_id,");
			sqlSb.append( " a.patient_name, a.gender, a.bed_no, a.bed_type_code, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, a.priority_ind, a.turn_down_reason, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, SM_GET_DESC.SM_APPL_USER(modified_by_id,'"+locale+"','1') modified_user_name, booking_status from IP_BOOKING_LIST a ");    */
			
			sqlSb.append("select a.bkg_lst_ref_no, a.preferred_date,a.referral_id,");
			sqlSb.append("to_char(a.preferred_date, 'dd/mm/rrrr hh24:mi') disp_preferred_date, a.patient_id, ");
			sqlSb.append("decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name, a.gender, a.bed_no, a.bed_type_code, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc,");
			sqlSb.append("a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2')");
			sqlSb.append("bed_class_short_desc, a.priority_ind, a.turn_down_reason,"); 
			sqlSb.append(" to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date,"); 
			sqlSb.append(" SM_GET_DESC.SM_APPL_USER(a.MODIFIED_BY_ID,'"+locale+"','1') modified_user_name, booking_status,"); 
			sqlSb.append(" a.NURSING_UNIT_CODE,ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc,a.ROOM_NO,"); 
			sqlSb.append(" a.SPECIALTY_CODE,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"','2') speciality_desc ,"); 
			sqlSb.append(" am_get_desc.am_complaint (a.chief_complaint,'"+locale+"', '1'  ) booking_reason ,"); 
			sqlSb.append(" am_get_desc.am_contact_reason (a.reason_for_revision_code,'"+locale+"', '1'  ) revision_reason ,"); 
			sqlSb.append(" a.diagnosis_remarks booking_remarks "); 
			sqlSb.append(" ,ip_get_desc.ip_booking_type(a.booking_type_code,'"+locale+"','2') booking_type_desc ");
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
			//Start
			sqlSb.append(" ,a.OPER_SHORT_DESC surgery_order,to_char(a.pref_surg_date,'DD/MM/YYYY') surgery_date");
			//End
			sqlSb.append(" ,(SYSDATE - a.preferred_date ) * 1440    diff_min") ;//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			
        	sqlSb.append(" from ip_booking_list a");
			
		}

		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sqlSb.append( ", PR_REFERRAL_REGISTER b ");
		}
		/*
		if(!booking_type.equals("D"))
		{
			sqlSb.append( "  , ip_nursing_unit c , sm_appl_user d where  a.facility_id = c.facility_id (+) and a.nursing_unit_code = c.nursing_unit_code (+)  and  a.modified_by_id = d.appl_user_id and ");
		}
		*/
		if(!booking_type.equals("D"))
		{
			sqlSb.append( " where  ");
		}

		if ( call_function.equals("CB") )
		{
			if(booking_type.equals("D"))
			{
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString() );
			}
			else
			{
				sqlSb.append(" ( ( a.booking_status = '1' and trunc(a.preferred_date)<= trunc(sysdate))  or a.booking_status='9')  " +where_criteria.toString()) ;
			}
		}
		else if(call_function.equals("AT") || call_function.equals("Booking_Admission") )
		{
			if(past_booking.equals("Y"))
			{
				if(booking_type.equals("D"))
				{
					sqlSb.append( " where a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)<= trunc(sysdate)and a.clinic_code in (select clinic_code from IP_DC_UNIT_FOR_NURS_UNIT where facility_id ='"+facility_id+"' AND nursing_unit_code IN ");
					sqlSb.append( "(SELECT a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and a.locn_type = b.locn_type and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id = '"+login_user+"')) "+where_criteria.toString());
				}
				else
				{
					sqlSb.append( " a.booking_status = '1' " +where_criteria.toString()) ;
				}
			}
			else
			{
				if(booking_type.equals("D"))
				{
					sqlSb.append( " where a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate)and a.clinic_code in (select clinic_code from IP_DC_UNIT_FOR_NURS_UNIT where facility_id ='"+facility_id+"' AND nursing_unit_code IN ");
					sqlSb.append( "(SELECT a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and a.locn_type = b.locn_type and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id = '"+login_user+"')) "+where_criteria.toString() );
				}
				else
				{
					sqlSb.append(" a.booking_status = '1' and trunc(a.preferred_date)>= trunc(sysdate) " +where_criteria.toString()) ;
				}
			}
		 }
		else if(call_function.equals("AB"))
		{
			if(booking_type.equals("D"))
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString());
			else
				//sqlSb.append(" a.booking_status in ('0','1') " +where_criteria.toString()) ;
				/*Wednesday, July 29, 2009 IN013094*/
				sqlSb.append(" a.booking_status in ('0','1') and trunc(a.preferred_date)>=trunc(sysdate) " +where_criteria.toString()) ;

		}
		else
		{
			if(booking_type.equals("D"))
			{
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString());
			}
			else
			{
				sqlSb.append(" a.booking_status in ('0','1') and trunc(a.preferred_date)>= trunc(sysdate- "+bkg_grace_period+") " +where_criteria.toString()) ;
			}
		}
	
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sqlSb.append( " and a.REFERRAL_ID = b.REFERRAL_ID (+) ");
		}
		if(booking_type.equals("D"))
			 sqlSb.append( " order by a.APPT_DATE");
		else
			sqlSb.append( " order by a.priority_ind desc, a.preferred_date");
		
		/*
		if(rs!=null && rs.next())
		{
			flag =1;
			rs      = stmt. executeQuery(sqlSb.toString());
			
		}
		if(flag == 0)
		{	%>
			<!--<script> 
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); 
				if('<%=param%>'=='BOOKING')
			{
					parent.window.close();
			}
			</script>-->
	<%	/*} 
		else
		{*/
		int flag=0;
		//if(rs != null ) rs.close();
//out.println("sqlSB==>"+sqlSb.toString());

		rs      = stmt. executeQuery(sqlSb.toString());

		
		
				
		if(rs != null)	
		{	
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
			
			//while ( rs!=null && rs.next() && i<=end )
			while ( i<=end && rs.next())
			{
						
			//if (( !(start <= 1) ) || ( !( (start+12) > maxRecord ) ))
			//{
				if(flag==0)
				{
				out.println("<p><table align='right' id ='maxrec'><tr>");
				if ( !(start <= 1) )
					 out.println("<td align='right' id='prev' style='visibility:visible'><A HREF='../jsp/BookingReferenceLookupResult.jsp?noshow_bkng_period="+URLEncoder.encode(noshow_bkng_period1,"UTF-8")+"&param="+param+"&from="+(start-12)+"&to="+(end-12)+"&oper_stn_id="+oper_stn_id+"&past_booking="+past_booking+"&revise_booking_yn="+revise_booking_yn+"&cancel_booking_yn="+cancel_booking_yn+"&confirm_booking_yn="+confirm_booking_yn+"&create_booking_yn="+create_booking_yn+"&create_booking_with_conf_yn="+create_booking_with_conf_yn+"&booking_type="+booking_type+"&daycare_code="+daycare_code+"&whereclause="+URLEncoder.encode(where_criteria.toString(),"UTF-8")+"&call_function="+URLEncoder.encode(call_function,"UTF-8")+"&bkg_grace_period="+URLEncoder.encode(bkg_grace_period,"UTF-8")+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); //modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				
				 //if ( !( (start+12) > maxRecord ) )
					out.println("<td align='right' id='next' style='visibility:hidden'><A HREF='../jsp/BookingReferenceLookupResult.jsp?noshow_bkng_period="+URLEncoder.encode(noshow_bkng_period1,"UTF-8")+"&param="+param+"&from="+(start+12)+"&to="+(end+12)+"&revise_booking_yn="+revise_booking_yn+"&cancel_booking_yn="+cancel_booking_yn+"&confirm_booking_yn="+confirm_booking_yn+"&create_booking_yn="+create_booking_yn+"&create_booking_with_conf_yn="+create_booking_with_conf_yn+"&oper_stn_id="+oper_stn_id+"&past_booking="+past_booking+"&booking_type="+booking_type+"&daycare_code="+daycare_code+"&whereclause="+URLEncoder.encode(where_criteria.toString(),"UTF-8")+"&call_function="+URLEncoder.encode(call_function,"UTF-8")+"&bkg_grace_period="+URLEncoder.encode(bkg_grace_period,"UTF-8")+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");//modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				out.println("</tr></table></p>");
				out.println("<br><br>");
			//}
	%>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
		<tr>
		<%
			if(!call_function.equals("AB") && !param.equals("BOOKING"))
			{	%>
			   <th>&nbsp;</th>
		<%	}	%><B></B>
			   <th nowrap><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</th>
		   <%
			  
			if(call_function.equals("AT") || call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("Booking_Admission"))
			{	%>
					<th nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</th>
		<%	}	%>
				<th nowrap>
			<%   
				if(booking_type.equals("D")){%>Appointment Date <%}else{%><fmt:message key="eIP.PreferredDateTime.label" bundle="${ip_labels}"/><%}%>&nbsp;&nbsp;</th>
				<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th>
				<%
					if(param.equals("BOOKING") || call_function.equals("AB"))
			{
				%>
						<th nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;</th>
				<%
			}
					if(call_function.equals("AB"))
					{
						%>
							<th nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</th>
						<%
					}
				%>
				
				<th nowrap><fmt:message key="Common.BookingStatus.label" bundle="${common_labels}"/>&nbsp;</th>
				<%if(!booking_type.equals("D")){%>
				<!--/*modification for SRR20056-CRF-0506*/-->
				<th nowrap><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="eIP.Reasonforbooking.label" bundle="${ip_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="eIP.Reasonforrevision.label" bundle="${ip_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</th>
				<%}%>
			<%	if(call_function.equals("AB"))
				{%>
					<th nowrap><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/>&nbsp;</th>
					<th nowrap><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</th>
			<%	} %>
			<!--//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013-->
			<!--End-->
			<%if(!booking_type.equals("D")){%>
				<th nowrap><fmt:message key="eIP.SurgeryOrder.label" bundle="${ip_labels}"/>&nbsp;</th>
				<th nowrap><fmt:message key="eIP.SurgeryDate.label" bundle="${ip_labels}"/>&nbsp;</th>
			<%}%>
			<!--END-->
			</tr>
	   
		<%	
			
				}
				link_referral_id = rs.getString("REFERRAL_ID");
				if(link_referral_id == null) link_referral_id="&nbsp;";
			
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
				//Start
				if(!booking_type.equals("D")){
				surgery_order = rs.getString("surgery_order");
				if(surgery_order == null) surgery_order="&nbsp;";
				surgery_date = com.ehis.util.DateUtils.convertDate(rs.getString("surgery_date"),"DMY","en",locale);		
				if(surgery_date == null) surgery_date="&nbsp;";
				}
				//End
				patient_id1=rs.getString("patient_id");
				callwinPatientid=patient_id1;
				if(callwinPatientid == null) callwinPatientid="";
				if(patient_id1 == null) patient_id1="&nbsp;";
				
				patient_name=rs.getString("patient_name");
				if(patient_name == null) patient_name="&nbsp;";

				gender=rs.getString("gender");
				if(gender == null) 
					gender = "&nbsp;";
				else if (gender.equals("M"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		
				if(!booking_type.equals("D"))
				{
					bed_no = rs.getString("bed_no");
					if( bed_no == null) bed_no="&nbsp;";
				}
				if(!booking_type.equals("D"))
				{
					priority_ind = rs.getString("priority_ind");
						if( priority_ind == null) priority_ind="";
					if(priority_ind.equals("U")) priority_ind_desc="Urgent";
						else if (priority_ind.equals("N")) priority_ind_desc="Non-Urgent";

					turndownreason = rs.getString("turn_down_reason");
					if(turndownreason == null || turndownreason.equals("null")) 
						turndownreason = "";
				}
				if(!booking_type.equals("D"))
				{
					bookingStatus= rs.getString("booking_status");
				}
				else
				{
					bookingStatus = rs.getString("appt_status");
				}

				if(bookingStatus == null || bookingStatus.equals("null"))
					bookingStatus = "0";
				if(!booking_type.equals("D"))
				{
					booking_remarks  = rs.getString("booking_remarks");
					//if(booking_remarks == null) booking_remarks = "&nbsp";
					//if(!booking_remarks.equals(""))
					//booking_remarks		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels");
					revision_reason  = rs.getString("revision_reason");
					if(revision_reason == null) revision_reason = "&nbsp";
					booking_reason  = rs.getString("booking_reason");
					if(booking_reason == null) booking_reason = "&nbsp";
				
					booking_type_desc  = rs.getString("booking_type_desc");
					if(booking_type_desc == null) booking_type_desc = "&nbsp";
				}
				if(!booking_type.equals("D"))
				{
					bed_type=checkForNull(rs.getString("BED_TYPE_CODE"));

					bed_type_desc=checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));
					if(bed_type_desc == null || bed_type_desc.equals("null") || bed_type_desc.equals(""))
						bed_type_desc = "&nbsp;";
				
					bed_class=checkForNull(rs.getString("BED_CLASS_CODE"));

					bed_class_desc=checkForNull(rs.getString("BED_CLASS_SHORT_DESC"));
					if(bed_class_desc == null || bed_class_desc.equals("null") || bed_class_desc.equals(""))
						bed_class_desc = "&nbsp;";
		
					/*nursingunit_code=checkForNull(rs.getString("NURSING_UNIT_CODE")); 
					modified on 12-03-2008 in the refrence of CRF20056-0226 to display nursing unit description instead of mursing unit code.
					*/
					nursingunit_code=checkForNull(rs.getString("nursing_unit_short_desc"));  
					if(nursingunit_code == null || nursingunit_code.equals("null") || nursingunit_code.equals(""))
						nursingunit_code = "&nbsp;";
		
					room_no=checkForNull(rs.getString("ROOM_NO"));
					if(room_no == null || room_no.equals("null") || room_no.equals(""))
						room_no = "&nbsp;";

					speciality_desc=checkForNull(rs.getString("speciality_desc"));
					if(speciality_desc == null || speciality_desc.equals("null") || speciality_desc.equals(""))
						speciality_desc = "&nbsp;";
			
				}
				if(call_function.equals("AB"))
				{
					if ((!(priority_ind.equals(temp)))) 
					{
						%>
						<tr>
							<td colspan='21' class='CAGROUPHEADING' align='left'><%=priority_ind_desc%></td>
						</tr>
						<%
					}
					temp=priority_ind;
				}
				else if(priority_ind_scr.equals("") || call_function.equals("RCB"))
				{
						if(param.equals("BOOKING") && !(priority_ind.equals(temp)))
						{
					%>
							<tr>
							<td colspan='16' class='CAGROUPHEADING' align='left'><%=priority_ind_desc%></td>
							</tr>
					<%
						}
					else if ((!(priority_ind.equals(temp)))) 
					{
						
						%>
						<tr>
							<td colspan='14' class='CAGROUPHEADING' align='left'><%=priority_ind_desc%></td>
						</tr>
						<%
					}
					temp=priority_ind;
				}
				
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";
				%>
				<tr>
				<%String clin_code="";
				
				  if(param.equals("ADMIT") || param.equals("BOOK_ADMIT")) 
				  {

				  if(booking_type.equals("D"))
					 clin_code = rs.getString("clinic_code");
				  else
					clin_code = "";
				 %>
						<td class='<%=class_val%>' nowrap>
					<a href=javascript:callCanRev('<%=rs.getString("bkg_lst_ref_no")%>','<%=clin_code%>','<%=java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))%>')>+</a></td>
					<td class='<%=class_val%>' nowrap>
					<%if((!past_booking.equals("Y") && booking_type.equals("D")) || booking_type.equals("I")){%><a href="javascript:closeWin('<%=rs.getString("bkg_lst_ref_no")%>', '<%=booking_type%>','<%=clin_code%>','<%=link_referral_id%>','<%=callwinPatientid%>','<%=bed_type%>','<%=bed_type_desc%>','<%=bed_class%>','<%=bed_class_desc%>')">  <%=rs.getString("bkg_lst_ref_no")%>
					</a><%}else{%> <%=rs.getString("bkg_lst_ref_no")%><%}%>&nbsp;</td>  	
					<%
					}
					else if(param.equals("BOOKING")) // for create booking 
					{ 
						
						//out.println(" <td class='"+class_val+"'></td> ");
					%>

					<td class='<%=class_val%>'><%=rs.getString("bkg_lst_ref_no")%></td>

<%					}
					else if(call_function.equals("RCB"))
					{	
						%>
						<td class='<%=class_val%>'>
						<a href="javascript:callCanRev('<%=rs.getString("bkg_lst_ref_no")%>','<%=clin_code%>','<%=java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))%>')">+</a>
						</td> 					
						<td class='<%=class_val%>'><a href=javascript:showModal('<%=rs.getString("bkg_lst_ref_no")%>')>         <%=rs.getString("bkg_lst_ref_no")%></a>&nbsp;</td> 
				<%	}
					else if((call_function.equals("CB")||call_function.equals("RCB")))
					{	%>
					
					<td class='<%=class_val%>'>
					<a href=javascript:callCanRev('<%=rs.getString("bkg_lst_ref_no")%>','<%=clin_code%>','<%=java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))%>')>+</a	> 
					&nbsp;</td> 
					
					<td class='<%=class_val%>'><a href=javascript:showModal('<%=rs.getString("bkg_lst_ref_no")%>')>         <%=rs.getString("bkg_lst_ref_no")%></a>&nbsp;</td> 
				
					<%}else if(call_function.equals("AB"))
					{%>
				
					

					<td class='<%=class_val%>'><a href=javascript:showModal('<%=rs.getString("bkg_lst_ref_no")%>')>         <%=rs.getString("bkg_lst_ref_no")%></a>&nbsp;</td>

					<%}
					else if(call_function.equals("BookingReport"))
					{	

						
						%>
				
						<td class='<%=class_val%>'><a href=javascript:callCanRev('<%=rs.getString("bkg_lst_ref_no")%>','<%=clin_code%>','<%=java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))%>')>+</a>&nbsp;</td>
						

						<td class='<%=class_val%>'><a href=javascript:runReport1('<%=rs.getString("bkg_lst_ref_no")%>','<%=rs.getString("patient_id")%>','<%=nursing_unit_code%>')><%=rs.getString("bkg_lst_ref_no")%></a>&nbsp;</td>
				<%	}
					
					/// This block will call the Referral Details Page if the Function is Admit Patient OR Revise/Cancel Booking OR Active Booking...

					if(param.equals("BOOKING")) 
						out.println(" <td class='"+class_val+"'>&nbsp;</td> ");
					else if(call_function.equals("AT") || call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("Booking_Admission"))
					{	%>
						<td class='<%=class_val%>' nowrap>
						
						<a href=javascript:viewReferral('<%=rs.getString("REFERRAL_ID")%>')><%=link_referral_id%></a></td> 
					<%  
					}
					
					  //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						if(!booking_type.equals("D")) // Condition Added Against Incident 35847 Dated on 23-10-2012
						{
							diff_min= rs.getInt("DIFF_MIN");
						
				     		if(diff_min > noshow_bkng_period)
							{  
								flag1 ="Y";
							}
							else{
								flag1 ="N";
								}
						} //  Incident 35847 ended  
					 //end   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
					
						String Booking_Status = "";
						if(bookingStatus.equals("0"))
						{	
							Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotConfirmed.label","common_labels");
						}
						else
						{  
						//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						
						if(flag1.equals("Y") || flag1=="Y"){
						   Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noshow.label","common_labels");
						   }  //end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						else{
						   	Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels");
							}
						}
						String disp_preferred_date_DayCare_Inpatient = "";
						if(booking_type.equals("D"))
							disp_preferred_date_DayCare_Inpatient = DateUtils.convertDate(rs.getString("disp_preferred_date"),"DMY","en",locale);
						else
							disp_preferred_date_DayCare_Inpatient = DateUtils.convertDate(rs.getString("disp_preferred_date"),"DMYHM","en",locale);
					%>
					<td class='<%=class_val%>' nowrap><%=disp_preferred_date_DayCare_Inpatient%></td>
					<td class='<%=class_val%>' nowrap><%=patient_id1%></td>
				   <td class='<%=class_val%>' nowrap><%=patient_name%></td>
				   <td class='<%=class_val%>' nowrap><%=gender%></td>
					<%
						if(param.equals("BOOKING") || call_function.equals("AB"))
						{
					%>
							<td class='<%=class_val%>' nowrap><%=nursingunit_code%></td>
							<td class='<%=class_val%>' nowrap><%=bed_class_desc%></td>
							<td class='<%=class_val%>' nowrap><%=bed_type_desc%></td>
							<td class='<%=class_val%>' nowrap><%=bed_no%></td>
							<td class='<%=class_val%>' nowrap><%=room_no%></td>
					<%
						}
						if(call_function.equals("AB"))
						{%>
							<td class='<%=class_val%>' nowrap><%=speciality_desc%></td>
					<%}
					%>
				   <td class='<%=class_val%>' nowrap><%=Booking_Status%></td>
				  <!--/*modification for SRR20056-CRF-0506*/-->
				  <%if(!booking_type.equals("D")){%>
				   <td class='<%=class_val%>' nowrap><%=booking_type_desc%></td>
				   <td class='<%=class_val%>' nowrap><%=booking_reason%></td>
				   <td class='<%=class_val%>' nowrap><%=revision_reason%></td>
				   <%if(rs.getString("booking_remarks") != null) {%>
				   <td class='<%=class_val%>' nowrap style='COLOR:BLUE;cursor:pointer;' onclick = "showRemarks('<%=rs.getString("bkg_lst_ref_no")%>')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></td><%}else{%> <td class='<%=class_val%>' nowrap>&nbsp;</td><%}%>
				<%}%>

				<%	if(call_function.equals("AB"))
					{	%>
						<td class='<%=class_val%>' nowrap><%=DateUtils.convertDate(rs.getString("modified_date"),"DMYHM","en",locale)%></td>
						<td class='<%=class_val%>' nowrap><%=checkForNull(rs.getString("modified_user_name"),"&nbsp;")%></td>
				<%	}	%>
				<!--//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
				//Start-->
				<%if(!booking_type.equals("D"))	{%>
				<td class='<%=class_val%>' nowrap><%=surgery_order%></td>
				<td class='<%=class_val%>' nowrap><%=surgery_date%></td>
				<%}%>
				<!--End-->
				</tr>
				<% i++;
				p_max_rec_cnt++;
				maxRecord++;
				flag++;
			} 

							
				if ( maxRecord < 12 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
						{
							document.getElementById("next").style.visibility='hidden';
							document.getElementById("maxrec").style.visibility='hidden';
						}
							
					</script>
					<% 
				}
				else
				{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
							
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

				<%
				}
					
				if(maxRecord == 0)
				{	%>
					<script> 
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); 
					</script>
				<%	} 
		}%>
</table>

<center></center>
	<%//}
}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	
	}
    finally
    {
		try{
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
		if (iprs != null) iprs.close();
		if (ipstmt != null) ipstmt.close();
		if (pat_cat_rs != null) pat_cat_rs.close();
		if (pat_cat_stmt != null) pat_cat_stmt.close();
       	if(Cs_book != null) Cs_book.close();
		}
		catch(Exception e)
		{
			//out.println(e.toString());
				e.printStackTrace();
		}
		 ConnectionManager.returnConnection(con,request);
		
		if(call_function.equals("RCB") && !param.equals("BOOKING"))
		{%>	
			<script>
				
			if(parent.frames[0].document.forms[0] != null)
				parent.frames[0].document.forms[0].search.disabled=false;
			</script>
		<%}
		else if(call_function.equals("AB"))// Added by Sridhar to disable the search button in the criteria page when function is Active Booking
			{ %>
			<script>
				
				parent.frames[1].document.forms[0].search.disabled=false 
			</script>		
		<%	}
		else if(!call_function.equals("BookingReport") && !param.equals("BOOKING") && call_function.equals("ADMIT"))
		{ %>
		<script>
							
			parent.frames[0].document.forms[0].search.disabled=false
			parent.frames[0].document.forms[0].search.focus();
		</script>
	<%	}
		else if(call_function.equals("BookingReport"))
		{
			%>
		<script>
					
			parent.frames[0].document.forms[0].search.disabled=false
			
		</script>

			<%
		}
		else if(call_function.equals("AT"))
		{
				%>
		<script>
				
			parent.frames[0].document.forms[0].search.disabled=false
			
		</script>

			<%
		}

    }	%>

	<input type='hidden' name='param' id='param' value="<%=param%>" >
	<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value ="<%=bl_interfaced_yn%>">
	<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value ="<%=capture_fin_dtls_yn%>">
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

