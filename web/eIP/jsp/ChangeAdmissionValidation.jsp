<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,com.ehis.util.*,webbeans.op.CurrencyFormat,blopin.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="validateBed.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale =	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script src='../../eIP/js/ReviseAdmission.js' language='Javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='Javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="Change_AdmissionValidation_form" id="Change_AdmissionValidation_form">
<%
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	//PreparedStatement	pstmt		=	null;

	Statement			stmt		=	null;
	//Statement			stmt_nu		=	null;
	ResultSet			rset		=	null;


	Statement			SubSerStmt	=	null;
	ResultSet			SubSerRset	=	null;

	//ResultSet			rset_nu		=	null;
	//ResultSet			rsetBL		=	null;
	//Statement			stmt1		=	null;
	//ResultSet			rs			=	null;
	//Statement			stmt1_p		=	null;
	//ResultSet			rs_p		=	null;
	//Statement			patstmt		=   null;
	//ResultSet			patrs		=   null;
	//String loginUser				= (String)session.getAttribute("login_user");
	//String install_yn				=(String)session.getValue("bl_operational");

	//java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" ) ;
	StringBuffer sql				= new StringBuffer(); 
	//StringBuffer query_booking_ref_no= new StringBuffer(); 
	//String maxperiodforrevbkg1		= checkForNull(request.getParameter("bkg_grace_period"));	
	//String admission_for			= checkForNull(request.getParameter("admission_for"));
	String facilityId				= "";
	String value1					= ""; 
	String value2					= "";
	String value3					= ""; 
	String from						= ""; 
	String value5					= "";
	String patientid				= "";
	//String dissource              = "";
	//String disspec				= "";	
	//String attendpractitionerid	= "";
	//String bookingrefno			= "";
	//String patient				= "";
	//String encounter				= "";
	//String referralid				= "";
	//String ID						= "";
	//String dat					= ""; 
	//String practitionerid			= "";
	//String nursingunit			= "";
	//String bookingstatus			= "";
	//String blooddonation			= "";
	//String specialitycode			= "";
	//String chiefcomplaint			= "";
	//String otdatetime				= "";	
	//String chiefcomplaint_desc	= "";
	//String bedclasscode			= "";	
	//String bedClassDesc			= "";	
	String bedtypecode				= "";
	String roomno					= "";
	String bedno					= "" ;	
	String ancillaryyn				= "";
	String servicecode				= "",		servicedesc				=	"";
	String Indicator				= "";
	String visit_adm_date_time		= "";	
	String expDaysofStay			= "";
	//String continue_yn			= "";
	//String to_service_code		= "";
	//String to_speciality_code		= "";
	//String to_speciality_desc		= "";
	//String queryString			= "";
	//String teamid					= "";
	//String financial_detail_ref_id= "";
	//String org_type_data			= "";
	//String practitioner			= "";
	String servcode					= "";
	
	String patient_nursingunit		= "";
	String bed_class				= "";	
	String nursingunit_code			= "";	
	String deactivate_pseudo_bed_yn = "N";	
	String frame_ref				= "";
	String populateList				= "";
	String bedType_code				= "";
	String forBllingProc			= "";
	String future_YN				= "";

	try{
		con							=	ConnectionManager.getConnection(request);
		patdata.setFacility_id(facilityId);
		facilityId					=	(String)session.getValue("facility_id");


		value1						=	checkForNull(request.getParameter("field1"));
		value2						=	checkForNull(request.getParameter("field2"));
		value3						=	checkForNull(request.getParameter("field3"));
		nursingunit_code			=	checkForNull(request.getParameter("nursingunit_code"));
		from						=	checkForNull(request.getParameter("field4"));
		Indicator					=	checkForNull(request.getParameter("Indicator"));
		value5						=	checkForNull(request.getParameter("field5"));
		expDaysofStay				=	checkForNull(request.getParameter("expDaysofStay"));
		frame_ref					= checkForNull(request.getParameter("frame_ref"));
		populateList				= checkForNull(request.getParameter("populateList"));
		bedType_code				= checkForNull(request.getParameter("bedtype_Code"));

		visit_adm_date_time			=	checkForNull(request.getParameter("visit_adm_date_time"));
		servicecode					= checkForNull(request.getParameter("service_code"));
		servcode					=	checkForNull(request.getParameter("serviceCode"));
		bed_class					=	checkForNull(request.getParameter("bed_class"));
		patientid					= checkForNull(request.getParameter("patient_id"));
		forBllingProc				= checkForNull(request.getParameter("forBllingProc"),"N");
		future_YN					= checkForNull(request.getParameter("future_yn"),"N");


		deactivate_pseudo_bed_yn	= request.getParameter("deactivate_pseudo_bed_yn");
		if(deactivate_pseudo_bed_yn == null) deactivate_pseudo_bed_yn= "N";
		
		

		String bed_type_code		= "";
		String bed_type_desc		= "";


if(future_YN.equals("Y")){

			patient_nursingunit		= checkForNull(request.getParameter("bl_Nursingunit"));
			String f_flag2			= "";	

			if(sql.length() > 0) sql.delete(0,sql.length());

			sql.append(" Select booking_type, override_yn, patient_id from IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+patient_nursingunit+"' and req_bed_no = '"+value3+"' and booking_status = '0' and blocked_from_date_time > sysdate and ( patient_id is null or patient_id != '"+patientid+"') ");

			stmt					=	con.createStatement();
			rset					=	stmt.executeQuery(sql.toString());

			if(rset!=null && rset.next())
			{
				f_flag2				= "Y";
			}
			if(rset !=null) rset.close(); 
			if(stmt != null) stmt.close();
			%>

			<%if(f_flag2.equals("Y"))
			{
	
				out.println("<script>var retval = confirm(getMessage('BED_BLCKD_FOR_FUT_DT','IP'));if(retval){parent.frames[1].document.Change_Adm_Dtls_Form.confirm_flag.value = 'Y';parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;if(parent.frames[1].document.Change_Adm_Dtls_Form.bl_instal.value == 'Y'){if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='N'){if(parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value!=''){parent.frames[1].BLCheckElig(parent.frames[1])}else{parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}else{parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}</script>");
			}
			else
			{
				out.println("<script>parent.frames[1].document.Change_Adm_Dtls_Form.confirm_flag.value = 'N';parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;if(parent.frames[1].document.Change_Adm_Dtls_Form.bl_instal.value =='Y'){if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='N') {if(parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value!=''){parent.frames[1].BLCheckElig(parent.frames[1])}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}else{parent.frames[1].BLCheckElig(parent.frames[1])}}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}</script>");
			}
		}



	if(populateList.equals("Y")){%>
		<script>
					var ambulatory_status		= parent.frames[1].document.Change_Adm_Dtls_Form.ambulatory_status;
					while(ambulatory_status.options.length > 1)
						ambulatory_status.remove(ambulatory_status.options[1]);
				</script>
				<%			
					String ambulatory_short_desc= "";
					String ambulatory_code		= "";

					// To populate the AMBULATORY STATUS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select ambulatory_status, short_desc from AM_AMBULATORY_STATUS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ");
					/*Tuesday, May 18, 2010 , modified for PE*/
					sql.append(" SELECT   ambulatory_status, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',2)short_desc FROM am_ambulatory_status WHERE eff_status = 'E' ORDER BY short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							ambulatory_short_desc	= rset.getString("short_desc");
							ambulatory_code			= rset.getString("ambulatory_status");
					%>		<script>
								var ambulatoryOpt	= parent.frames[1].document.createElement("OPTION");
								ambulatoryOpt.text	= "<%=ambulatory_short_desc%>";
								ambulatoryOpt.value = "<%=ambulatory_code%>";
								 parent.frames[1].document.Change_Adm_Dtls_Form.ambulatory_status.add(ambulatoryOpt);
							</script>
					<%	}// E.O While
					}// E.O if

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
					%>
					<script>
					var visit_adm_type = parent.frames[1].document.Change_Adm_Dtls_Form.visit_adm_type;
					while(visit_adm_type.options.length > 1)
						visit_adm_type.remove(visit_adm_type.options[1]);
				</script>
				<%			

					String admission_type_short_desc= "";
					String admission_type_code		= "";
					
					//To populate the ADMISSION TYPE ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select admission_type_code, short_desc from IP_ADMISSION_TYPE_LANG_VW where language_id = '"+locale+"' and  eff_status='E' order by short_desc ");
					/*Tuesday, May 18, 2010 , modified for PE*/
					sql.append(" SELECT   admission_type_code,ip_get_desc.ip_admission_type(admission_type_code,'"+locale+"',2) short_desc FROM ip_admission_type WHERE eff_status = 'E' ORDER BY short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							admission_type_short_desc	= rset.getString("short_desc");
							admission_type_code			= rset.getString("admission_type_code");
					%>		<script>
								var admTypeOpt			= parent.frames[1].document.createElement("OPTION");
								admTypeOpt.text			= "<%=admission_type_short_desc%>";
								admTypeOpt.value		= "<%=admission_type_code%>";
								parent.frames[1].document.Change_Adm_Dtls_Form.visit_adm_type.add(admTypeOpt);
							</script>
					<%	}// E.O While
					}// E.O if
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
%>
				<script>
					var Bedcode = parent.frames[1].document.Change_Adm_Dtls_Form.Bedcode;
					for(i=0;i<Bedcode.length;i++) {
						Bedcode.remove(1);
					}
				</script>
				<%			
					String bed_class_short_desc	= "";
					String bed_class_code		= "";
					// To populate the BED CLASS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(!value3.equals("")){
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+value3+"'  ORDER BY short_desc ");
					}
					else if(!value3.equals("")){
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E'  AND a.nursing_unit_code = '"+value3+"' ORDER BY short_desc ");
					}else{
						sql.append(" Select bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ");
					}

					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							bed_class_short_desc	= rset.getString("short_desc");
							bed_class_code			= rset.getString("bed_class_code");
							%>	<script>
									var BedcodeOpt  = parent.frames[1].document.createElement("OPTION");
									BedcodeOpt.text	= "<%=bed_class_short_desc%>";
									BedcodeOpt.value= "<%=bed_class_code%>";
									parent.frames[1].document.Change_Adm_Dtls_Form.Bedcode.add(BedcodeOpt);

									
								</script>
							<%	
						}// E.O While
					}// E.O if

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();

			}

	if(!bed_class.equals("")){
			if( deactivate_pseudo_bed_yn.equals("Y") && !nursingunit_code.equals("") ){
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.BED_TYPE_CODE,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E' AND a.psuedo_bed_status = 'N' ORDER BY bed_type_short_desc ");
			}
			else if( deactivate_pseudo_bed_yn.equals("N") && !nursingunit_code.equals("") ){
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.BED_TYPE_CODE,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E'  ORDER BY bed_type_short_desc ");
			}
			stmt	=	con.createStatement();
			rset	=	stmt.executeQuery(sql.toString());

			
			out.println("<script>var obj =parent.frames[1].document.Change_Adm_Dtls_Form.bed_type;</script>");
			out.println("<script>var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(1);}");
			out.println("</script>");

			if(rset != null){
				while(rset.next()){
					bed_type_code = checkForNull(rset.getString("bed_type_code"));
					bed_type_desc = checkForNull(rset.getString("bed_type_short_desc"));
						if((!bedType_code.equals("")) && (bedType_code.equals(bed_type_code))){
						out.println ("<script>var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";opt.selected=true;obj.add(opt);");
						out.println ("eval('parent.frames[1].document').createElement('Option')") ;
						out.println("</script>");
					}else{
						out.println ("<script>var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";obj.add(opt);");
						out.println ("eval('parent.frames[1].document').createElement('Option')") ;
						out.println("</script>");
					}
				}//while loop
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			 }//if rset not null
		}



		if (from.equals("Main_form")){
			bedno=value5;
			nursingunit_code=value3;
					if(!nursingunit_code.equals("")){
						String addlservice = "";
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2) short_desc, ancillary_yn from AM_SERVICE where Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingunit_code+"') order by short_desc ");
						String service_add = checkForNull(request.getParameter("service_add"));
						stmt = con.createStatement();
						rset = stmt.executeQuery(sql.toString());
					if(!service_add.equals("N")){
						if(rset != null && rset.next()){
						servicecode			=	checkForNull(rset.getString("service_code"));
						servicedesc			=	checkForNull(rset.getString("short_desc"));
						ancillaryyn			=	checkForNull(rset.getString("ancillary_yn"));
						%>
						<script>
							if(parent.frames[1].document.Change_Adm_Dtls_Form) {	
									parent.frames[1].document.Change_Adm_Dtls_Form.ancillary_yn.value="<%=ancillaryyn%>";
								var obj =parent.frames[1].document.Change_Adm_Dtls_Form.service;
								var length  = obj.length;
								for(i=0;i<length;i++) {obj.remove(1);}
								var opt= parent.frames[1].document.createElement('Option');
								opt.text = "<%=servicedesc%>";
								opt.value= "<%=servicecode%>";
								opt.selected = true;
								obj.add(opt);
							}
						</script>
					<%
					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					//Adding Services.	
					%><script> 
						if(parent.frames[1].document.Change_Adm_Dtls_Form){
							var obj =parent.frames[1].document.Change_Adm_Dtls_Form.service;
							var length  = obj.length;
							for(i=0;i<length;i++) 
							{
								obj.remove(1);
							}
						}
						</script>
					<%
					//patient class is not used.
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingunit_code+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityId+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursingunit_code+"' order by 2 ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());	
					if(rset!=null ){
						while (rset.next()){
							addlservice			=	checkForNull(rset.getString("service_code"));
							servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					%>		<script>
								var opt = parent.frames[1].document.createElement('Option');
								opt.text="<%=servicedesc%>";
								opt.value="<%=addlservice%>";
								obj.add(opt);
								parent.frames[1].document.createElement('Option');
							</script>
					<%	}
					}

					out.println("<script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					
					String subservice_code = "", subservice_desc = "";
					StringBuffer sersql = new StringBuffer();
					sersql.append(" Select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servicecode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sersql.toString());

					if(rset!=null ){
						while(rset.next()){
							subservice_code  = checkForNull(rset.getString("SUBSERVICE_CODE"));
							subservice_desc = checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
							out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; \nobj.add(opt)");
							out.println ("eval(frame_ref+'.document').createElement('Option')") ;
						}
					}
					out.println("</script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}
				String bedcode = "";
				String beddesc = ""; 
				StringBuffer bedcodeSql = new StringBuffer();

				if(deactivate_pseudo_bed_yn.equals("Y")){
					bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' AND  a.psuedo_bed_status = 'N' ORDER BY short_desc ");
				}else{
					bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' ORDER BY short_desc ");
				}

				stmt = con.createStatement();
				rset = stmt.executeQuery(bedcodeSql.toString());

				if(rset != null){
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].Bedcode');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					while(rset.next()){
						bedcode			=	checkForNull(rset.getString("bed_class_code"));
						beddesc			=	checkForNull(rset.getString("short_desc"));
						out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+beddesc+"\"; opt.value=\""+bedcode+"\"; \nobj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
					out.println("</script>");
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			}
		
			if (!servcode.equals("") ||servcode.equals("")){
				if(!servcode.equals("")){
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				}
				String subservice_code = "", subservice_desc = "";
				StringBuffer serSql = new StringBuffer();

				serSql.append(" select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servcode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");
				SubSerStmt = con.createStatement();
				try{
				SubSerRset = SubSerStmt.executeQuery(serSql.toString());
				if(SubSerRset != null ){
					while(SubSerRset.next()){
						subservice_code  = checkForNull(SubSerRset.getString("SUBSERVICE_CODE"));
						subservice_desc = checkForNull(SubSerRset.getString("SUBSERVICE_SHORT_DESC"));
						out.println("var opt= eval(frame_ref+'.document').createElement('Option');");
						out.println("opt.text=\""+subservice_desc+"\";");
						out.println("opt.value=\""+subservice_code+"\"; ");
						out.println("obj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
				}
				out.println("</script>");
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}catch (Exception EXp){
					EXp.printStackTrace();
				}
			}
			if(!bedno.equals("")){
				if(sql.length()>0) sql.delete(0,sql.length());
				sql.append(" select room_no, bed_type_code, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, bed_class_code, current_status, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc from IP_NURSING_UNIT_BED where nursing_unit_code = '"+nursingunit_code+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' and eff_status = 'E'  and main_bed_no is null ");
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());
				if(rset != null && rset.next()){
					bedtypecode		=	"";
					String bed_class_code	=	"";
					String curr_status		=	"";
					String bed_type_short_desc = "";

					bedtypecode				=	checkForNull(rset.getString("bed_type_code")).trim();
					roomno						=	checkForNull(rset.getString("room_no"));
					bed_class_code			=	checkForNull(rset.getString("bed_class_code"));
					curr_status					=	checkForNull(rset.getString("current_status"));
					bed_type_short_desc	=   checkForNull(rset.getString("bed_type_short_desc"));
					if(curr_status.equals("O"))	{
						out.print("<script>alert(getMessage('OCCUPIED_BED','IP'));parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value='';</script>");
					}else{	
						out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.Bedcode.value=\""+bed_class_code+"\";parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value=\""+roomno+"\" ;var obj = parent.frames[1].document.Change_Adm_Dtls_Form.bed_type;for(i=0;i<obj.length;i++){obj.remove(1);}var opt=parent.frames[1].document.createElement('Option');opt.text=\""+bed_type_short_desc+"\";opt.value=\""+bedtypecode+"\";opt.selected=true;obj.add(opt);if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='Y')parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility='hidden';</script>"); 
					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}else{ 
					out.print("<script>alert(getMessage('INVALID_BED','IP'));parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value='';</script>");
				
						out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value='';</script>");

					out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility='hidden';}</script>");
				}
			}

		}

	if (forBllingProc.equals("Y")){
		PreparedStatement trnsfr_pst=null,bl_chrg_pt = null,bl_prcs_pt =	null,bl_adm_pt=null;
		ResultSet               trnsfr_rslt=null,bl_chrg_rs = null,bl_prcs_rs  = null,bl_adm_rs=null;


		String patient_id		=	checkForNull(request.getParameter("patient_id"));
		String encounter_id	=	checkForNull(request.getParameter("encounter_id"));
		//int cutt_off_time		=	Integer.parseInt(request.getParameter("cutt_of_time"));
		//int change_adm_dtls_duration	=	Integer.parseInt(request.getParameter("change_adm_dtls_duration"));
		String cutt_off_time		=	request.getParameter("cutt_of_time");
		String change_adm_dtls_duration	=	request.getParameter("change_adm_dtls_duration");
		String pract_id			=	checkForNull(request.getParameter("pract_id"));
		String location_code	=	checkForNull(request.getParameter("location_code"));
		String sex					=	checkForNull(request.getParameter("sex"));
		String bed_no			=	checkForNull(request.getParameter("bed_no"));
		String patient_class	=	checkForNull(request.getParameter("patient_class"));
		String colorCode		=	checkForNull(request.getParameter("colorCode"));
		String status_value	=	checkForNull(request.getParameter("status_value"));
		String tfr_req_status	=	checkForNull(request.getParameter("tfr_req_status"));
		String leave_exp_dt_flag	=	checkForNull(request.getParameter("leave_exp_dt_flag"));
		//String query_for_transfer		=	"";
		try{
			/*MOdified for Service Change Only
			if(cutt_off_time>change_adm_dtls_duration){
					adm_time_xcd	 =	false;
					error	 =	"The Patient Admission Time was exceeded over parameter setup.So cannot proceed.";
					out.println("<script>parent.frames[2].alert(getMessage('ADMISSION_TIME_EXCEEDED','IP'));</script>");
			}else{
			query_for_transfer=	"select count(*) tr_cnt from ip_adt_trn where facility_id='"+facilityId+"' and encounter_id='"+encounter_id+"' ";
			trnsfr_pst	=	con.prepareStatement(query_for_transfer);
			trnsfr_rslt	=	trnsfr_pst.executeQuery();
			if(trnsfr_rslt!=null&&trnsfr_rslt.next()){
				TR_Count	=	trnsfr_rslt.getInt("tr_cnt");
			}
			 if(TR_Count>1){
					err_status	 =	false;
					out.println("<script>parent.frames[2].alert(getMessage('PATIENT_IS_TRANSFFERED','IP'));</script>");
				}
			}

				if(err_status){
					out.println("<script>parent.frames[2].proceedAdmission('"+encounter_id+"','"+patient_id+"','"+pract_id+"','"+location_code+"','"+sex+"','"+bed_no+"','"+patient_class+"','"+colorCode+"','"+status_value+"','"+tfr_req_status+"','"+leave_exp_dt_flag+"','"+cutt_off_time+"','"+change_adm_dtls_duration+"');</script>");
				}*/

					out.println("<script>parent.frames[2].proceedAdmission('"+encounter_id+"','"+patient_id+"','"+pract_id+"','"+location_code+"','"+sex+"','"+bed_no+"','"+patient_class+"','"+colorCode+"','"+status_value+"','"+tfr_req_status+"','"+leave_exp_dt_flag+"','"+cutt_off_time+"','"+change_adm_dtls_duration+"');</script>");

			}catch(Exception ex){
				ex.printStackTrace();
		}finally{
			if(trnsfr_pst!=null)trnsfr_pst.close();
			if(bl_chrg_pt!=null)bl_chrg_pt.close();
			if(bl_prcs_pt!=null)bl_prcs_pt.close();
			if(bl_adm_pt!=null)bl_adm_pt.close();
			if(trnsfr_rslt!=null)trnsfr_rslt.close();
			if(bl_chrg_rs!=null)bl_chrg_rs.close();
			if(bl_prcs_rs!=null)bl_prcs_rs.close();
			if(bl_adm_rs!=null)bl_adm_rs.close();

		}
	}
}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		  ConnectionManager.returnConnection(con,request); 
	}

	%>
		</form>
	</body>
</html>
	

