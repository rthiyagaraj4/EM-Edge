<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="BooingValidation_form" id="BooingValidation_form">
<%
	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String bl_operational			= (String)session.getValue("bl_operational"); 
	//String  loginUser				= (String)session.getAttribute("login_user");

	String module_id = "IP";
	String calling_function_id = "BOOKING";
	String episode_type = "I";


	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			= null;
	Statement			stmt		= null;
	PreparedStatement	pstmt		= null;
	ResultSet			rset		= null;
	ResultSet			rs			= null;
	//Statement			paramStmt	= null;
	//ResultSet			paramRS		= null;
	String	facilityId				= "" ; 
	String	value3					= ""; 
	String	from					= "",		value5					=	"";
	String	sql						= ""; 
	String	roomno					= "";
	String	bedno					= "";	
	String	servicecode				= "",		servicedesc				=	"";
	String patient_id				= "";
	String blng_grp					= "";
	String is_tab_click				= "";
	//String oper_stn_id				= "";
	String confirm_yn				= "";
	String callingfrom				= "";
	
	try
	{
		con						=	ConnectionManager.getConnection(request);
		facilityId				=	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);
		String criteria			=	checkForNull(request.getParameter("criteria"));
		String nursingUnitCode	=	checkForNull(request.getParameter("nursingUnitCode"));
		String bedClass			=	checkForNull(request.getParameter("bedClass"));
		String bedType			=	checkForNull(request.getParameter("bedType"));
		String option_val		=	checkForNull(request.getParameter("option_val"));		
		value3					=	checkForNull(request.getParameter("field3"));
		from					=	checkForNull(request.getParameter("field4"));
		value5					=	checkForNull(request.getParameter("field5"));
		patient_id				=	checkForNull(request.getParameter("patient_id"));
		blng_grp				=	checkForNull(request.getParameter("blng_grp"));
		is_tab_click			=	checkForNull(request.getParameter("is_tab_click"));
		callingfrom  			=	checkForNull(request.getParameter("callingfrom"));

		/*Added by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525] Start*/
		String request_service_desc		= 	checkForNull(request.getParameter("request_service_desc"));
		String is_default_service		=	checkForNull(request.getParameter("is_default_service"));
		/*Added by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525] End*/
	
		String bed_type_short_desc	= "";
		String bed_type_code		= "";
		
		/*Friday, April 23, 2010 commented for performance tuning ,query executed multiple time*/
/*
		String paramSql = " select deactivate_pseudo_bed_yn from IP_PARAM where facility_id='"+facilityId+"' ";

		paramStmt	= con.createStatement();
		paramRS		= paramStmt.executeQuery(paramSql);

	
		if(paramRS.next())
		{
			deactivate_pseudo_bed_yn = paramRS.getString("deactivate_pseudo_bed_yn");
		}

		if(deactivate_pseudo_bed_yn == null) deactivate_pseudo_bed_yn= "N";
		if(paramRS !=null)    paramRS.close(); 
		if(paramStmt != null) paramStmt.close();

		try
		{
			StringBuffer operSql = new StringBuffer();
			operSql.append("SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='");
			operSql.append(facilityId);	
			operSql.append("' AND a.facility_id = b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='");
			operSql.append(loginUser);
			operSql.append("' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
			stmt = con.createStatement();
			rs   = stmt.executeQuery(operSql.toString());
			if(rs!=null)
			{
				if(rs.next())
				{
					oper_stn_id = checkForNull(rs.getString("OPER_STN_ID"));
				}	
			}
				if(rs	 != null)   rs.close(); 
				if(stmt	 != null)   stmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			StringBuffer confSql = new StringBuffer();
			confSql.append(" select CREATE_BOOKING_WITH_CONF_YN from AM_OPER_STN where FACILITY_ID = '");
			confSql.append(facilityId);
			confSql.append("' and OPER_STN_ID = '");
			confSql.append(oper_stn_id);
			confSql.append("'");
			stmt	= con.createStatement();
			rs = stmt.executeQuery(confSql.toString());
			if (rs.next())
			{
				confirm_yn = rs.getString("CREATE_BOOKING_WITH_CONF_YN");
			}
		
			if(rs	 != null)   rs.close(); 
			if(stmt	 != null)   stmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// Added by SRIDHAR R On 20 OCT 2004 for Populating Service Values...
*/		
//out.println("<script>alert(\"criteria :"+criteria+"\");</script>");	
		if(criteria.equals("PopulateService"))
		{
			
			if(!nursingUnitCode.equals(""))
			{
				// Query Used for Populating default Service Value...
				confirm_yn				= checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
				String addlservice = "";
				
				///sql = "Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and  Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";
				sql = "Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql);

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("short_desc"));					
				}
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				if(option_val.equals("retrieve")){
			%>
				<script>
					var obj =parent.frames[1].document.forms[0].service;//_desc;
					var length  = obj.length;
					for(i=0;i<length;i++) 
					{
						obj.remove(1);
					}
				</script>
			<%
				} else{
			%>
				<script>
					var obj =parent.frames[1].document.forms[0].service_desc;
					var length  = obj.length;
					for(i=0;i<length;i++) 
					{
						obj.remove(1);
					}
				</script>
			<%	
				}
				// Query Used for adding Service Values to the prevoius options...

				sql = " select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code = ? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2 ";



				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,nursingUnitCode);
				rset = pstmt.executeQuery();								
				while (rset.next())
				{
					addlservice	= checkForNull(rset.getString("service_code"));
					servicedesc	= checkForNull(rset.getString("service_short_desc"));
				%>
				<script>	
					var opt= parent.frames[1].document.createElement('Option');
					opt.text="<%=servicedesc%>"; 
					opt.value="<%=addlservice%>";
					/*Modified by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525]  Start*/
				
					/*if("<%=servicecode%>" == "<%=addlservice%>") 
						opt.selected = true;
					*/

					
					<%if(is_default_service.equals("N")){	%>
						if("<%=request_service_desc%>" == "<%=addlservice%>") 
							opt.selected = true;
					<%}else{%>
						if("<%=servicecode%>" == "<%=addlservice%>") 
							opt.selected = true;
					<%}%>
					/*Modified by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525]  End*/
					obj.add(opt);
					parent.frames[1].document.createElement('Option');
				</script>
		<%		}

				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();

				// Query Used for adding Bed Class Values to the prevoius options
				if(confirm_yn.equals("Y") || (!callingfrom.equals("createBooking"))){
				if(option_val.equals("retrieve")){
				%>
				<script>
					var bedclass_obj = '';
					if(parent.frames[1].document.forms[0].Bedcode!=null)
					{
						bedclass_obj =parent.frames[1].document.forms[0].Bedcode;
						var length  = bedclass_obj.length;
						for(i=0;i<length;i++) 
						{
							bedclass_obj.remove(1);
						}
					}
				</script>
				<%
				} else {
				%>
				<script>
					var bedclass_obj = '';
					if(parent.frames[1].document.forms[0].bed_class_desc!=null)
					{
						bedclass_obj =parent.frames[1].document.forms[0].bed_class_desc;
						var length  = bedclass_obj.length;
						for(i=0;i<length;i++) 
						{
							bedclass_obj.remove(1);
						}
					}
					
				</script>
				<%
				}			
					//sql = " SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code and b.language_id = ? ORDER BY b.short_desc ";
					sql = "SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ?  ORDER BY short_desc";



					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					rset = pstmt.executeQuery();
					
					if(rset!=null)
					{
						while (rset.next())
						{
							String bed_class_code	= checkForNull(rset.getString("bed_class_code"));
							String bed_class_desc	= checkForNull(rset.getString("short_desc"));

							%>
						<script>	
								var opt= parent.frames[1].document.createElement('Option');
								opt.text="<%=bed_class_desc%>"; 
								opt.value="<%=bed_class_code%>";
								bedclass_obj.add(opt);
								parent.frames[1].document.createElement('Option');
						</script>
				<%		}
				}

				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				
				//  Query Used for adding Bed Type Values to the prevoius options
				%>
				
				<script>
				var bedtype_obj =parent.frames[1].document.forms[0].bed_type_desc;
				var length  = bedtype_obj.length;
					for(i=0;i<length;i++) 
					{
						bedtype_obj.remove(1);
					}
				</script>
				<%
				/*Friday, April 23, 2010 commented for performance tuning , query getting executed multiple time*/
				/*sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code  AND a.bed_class_code = ? and a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,bedClass);
				rset = pstmt.executeQuery();
				
				if(rset!=null)
				{
					while (rset.next())
					{
						String bedtype_code	= checkForNull(rset.getString("bed_type_code"));
						String bedtype_shortdesc	= checkForNull(rset.getString("bed_type_short_desc"));
*/
						%>
					<!--
					<script>	
						var opt= parent.frames[1].document.createElement('Option');
						opt.text="<%--=bedtype_shortdesc--%>"; 
						opt.value="<%--=bedtype_code--%>";
						bedtype_obj.add(opt);
						parent.frames[1].document.createElement('Option');
					</script>-->
			<%		//}
				//}

				//if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
			}			 
			}
			session.removeAttribute("ipPatInstructionsMap");// Included for the CRF - RUT-CRF013 - 23396 
			
		}// E.O PopulateService
	
		// Query Used for Populating Bed Type for selected Bed Class...
		if(criteria.equals("PopulateBedType"))
		{
			if((!bedClass.equals(""))&&(!nursingUnitCode.equals("")))
			{
				String bedClass_Sql	="";

				String service_Sql ="";

				String defaultServiceCodeSql ="";
				String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
				String service_desc = checkForNull(request.getParameter("service_desc"));
				String validationType = checkForNull(request.getParameter("validationType"));
				// Query Used for Populating default Service Value...
				if(validationType.equals("Bed_Avaibility_Chart_Validation") && service_desc.equals(""))
				{
					/*Friday, April 23, 2010 modified for performance tuining*/
					//defaultServiceCodeSql ="Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and  Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";
					defaultServiceCodeSql ="Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";



					stmt = con.createStatement();
					rset = stmt.executeQuery(defaultServiceCodeSql);
					
					if(rset != null && rset.next())
					{
						servicecode			=	checkForNull(rset.getString("service_code"));
						servicedesc			=	checkForNull(rset.getString("short_desc"));					
					}
					
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();


					// Query Used for adding Service Values to the prevoius options...
					service_Sql = "select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code =? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2 ";
					pstmt = con.prepareStatement(service_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,nursingUnitCode);
					rset = pstmt.executeQuery();	
					
					if(rset!=null)
					{
						%>
						<script>
						var service_obj;
						if(parent.frames[1].document.forms[0].service_desc!=null)
						{
							service_obj =parent.frames[1].document.forms[0].service_desc;
							var length  = service_obj.length;
							for(i=0;i<length;i++) 
							{
								service_obj.remove(1);
							}
							
						}
						else if(parent.frames[1].document.forms[0].service!=null)
						{
							service_obj =parent.frames[1].document.forms[0].service;
							var length  = service_obj.length;
							for(i=0;i<length;i++) 
							{
								service_obj.remove(1);
							}
							
						}
						</script>
						<%
							while (rset.next())
							{
								String service_Code	= checkForNull(rset.getString("service_code"));
								String service_Desc	= checkForNull(rset.getString("service_short_desc"));
							%>
						<script>	
								var opt= parent.frames[1].document.createElement('Option');
								opt.text="<%=service_Desc%>"; 
								opt.value="<%=service_Code%>";
								if("<%=servicecode%>" == "<%=service_Code%>") 
									opt.selected = true;
								service_obj.add(opt);
								parent.frames[1].document.createElement('Option');
							</script>
					<%		}
						if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
					}
				}

				// Query Used for adding Bed Class Values to the prevoius options...
				if(validationType.equals("Bed_Avaibility_Chart_Validation"))
				{
					//bedClass_Sql = " SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code and b.language_id = ? ORDER BY b.short_desc  ";
					/*modified for performance tuning Friday, April 23, 2010*/
					bedClass_Sql = " SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ?  ORDER BY short_desc  ";
					pstmt	=	con.prepareStatement(bedClass_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					rset	=	pstmt.executeQuery();

					if(rset!=null)
					{
						%>
						<script>
							if(parent.frames[1].document.forms[0].bed_class_desc!=null)
							{
								bedclass_obj =parent.frames[1].document.forms[0].bed_class_desc;
								var length  = bedclass_obj.length;
								for(i=0;i<length;i++) 
								{
									bedclass_obj.remove(1);
								}
							}
							else if(parent.frames[1].document.forms[0].Bedcode!=null)
							{
								bedclass_obj =parent.frames[1].document.forms[0].Bedcode;
								var length  = bedclass_obj.length;
								for(i=0;i<length;i++) 
								{
									bedclass_obj.remove(1);
								}
							}
							
						</script>
						<%
												
						while(rset.next())
						{
							String bed_class_code	= checkForNull(rset.getString("bed_class_code"));
							String bed_class_desc	= checkForNull(rset.getString("short_desc"));
							%>
							<script>
								var bedClassOpt	= parent.frames[1].document.createElement("OPTION");
								bedClassOpt.text	= "<%=bed_class_desc%>";;
								bedClassOpt.value= "<%=bed_class_code%>";
								if("<%=bedClass%>" == "<%=bed_class_code%>")
								{
									bedClassOpt.selected = true;
									
								}
								
								bedclass_obj.add(bedClassOpt);
							</script>
							<%
						}// E.O While
							if(rset !=null) rset.close(); 
							if(pstmt != null) pstmt.close();
					}// E.O if

				}
					// Query Used for adding Bed Type Values to the prevoius options...

					if(deactivate_pseudo_bed_yn.equals("Y") )
					{
						//bedClass_Sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b where b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = ? AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ";
						bedClass_Sql = "SELECT DISTINCT a.bed_type_code bed_type_code,ip_get_desc.ip_bed_type (a.bed_type_code,?,'2' ) bed_type_short_desc  FROM ip_nursing_unit_bed a  WHERE a.facility_id = ?  AND a.nursing_unit_code = ? AND a.bed_class_code = ? AND a.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY bed_type_short_desc ";
					}
					else if(deactivate_pseudo_bed_yn.equals("N"))
					{
						//bedClass_Sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = ? AND a.eff_status='E' AND b.eff_status = 'E' ORDER BY b.short_desc ";
						/*Friday, April 23, 2010 modified for performance tuning*/
						bedClass_Sql = "SELECT DISTINCT a.bed_type_code bed_type_code,ip_get_desc.ip_bed_type (a.bed_type_code,?,'2' ) bed_type_short_desc  FROM ip_nursing_unit_bed a  WHERE a.facility_id = ?  AND a.nursing_unit_code = ? AND a.bed_class_code = ? AND a.eff_status = 'E' ORDER BY bed_type_short_desc ";
					}
					pstmt	=	con.prepareStatement(bedClass_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					pstmt.setString(4,bedClass);
					rset	=	pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
							bed_type_short_desc	= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
							bed_type_code		= checkForNull(rset.getString("BED_TYPE_CODE"));
							%>
							<script>
								var bedTypeOpt	= parent.frames[1].document.createElement("OPTION");
								bedTypeOpt.text	= "<%=bed_type_short_desc%>";;
								bedTypeOpt.value= "<%=bed_type_code%>";
								if("<%=bedType%>" == "<%=bed_type_code%>")
								{
									bedTypeOpt.selected = true;
								}
								
								parent.frames[1].document.forms[0].bed_type_desc.add(bedTypeOpt);
							</script>
							<%
						}// E.O While
							if(rset !=null) rset.close(); 
							if(pstmt != null) pstmt.close();
					}// E.O if
				
			}
		} // E.O PopulateBedType

		

		if(from.equals("Booking_form"))
		{

			
			String nursingcode  =	value3;
			bedno				=	value5;
			//String from_date		=	checkForNull(request.getParameter("from_date"));
			//String to_date			=	checkForNull(request.getParameter("to_date"));
			if(!bedno.equals(""))
			{
					//int no_of_time_bed_booked = 0;

					
					/*sql	= "select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI')))";

					out.println("<script>alert(\""+sql+"\");</script>");
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_time_bed_booked				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();*/
				//if(no_of_time_bed_booked == 0)
				//{
						sql	=" select room_no, bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, specialty_code, bed_type_code, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2')  bed_type_short_desc, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc  from IP_NURSING_UNIT_BED where eff_status = 'E' and  nursing_unit_code = '"+nursingcode+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' ";

						stmt	=	con.createStatement();
						rset	=	stmt.executeQuery(sql);

						if(rset.next())
						{
							roomno				= checkForNull(rset.getString("room_no"));
							String bedClassCode	= checkForNull(rset.getString("bed_class_code"));
							String bedtype_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
						%>	<script>
								parent.frames[1].document.forms[0].room_no.value="<%=roomno%>";
								parent.frames[1].document.forms[0].Bedcode.value="<%=bedClassCode%>";
								parent.frames[1].document.forms[0].bed_class_desc.value="<%=bedClassCode%>";
								parent.frames[1].populateBedType("<%=bedClassCode%>", "<%=bedtype_code%>");
							</script>
						<%	}
						else
						{
							out.println("<script>alert(getMessage('INVALID_BED','Common'));parent.frames[1].document.forms[0].room_no.value='';parent.frames[1].document.forms[0].bed_no.value='';parent.frames[1].document.forms[0].bed_no.focus();parent.frames[1].document.forms[0].bed_class_desc.value='';parent.frames[1].document.forms[0].bed_no.select(); </script>");
						}
						if(rset !=null) rset.close(); 
						if(stmt != null) stmt.close();
				/*}
				else
				{
					out.println("<script>alert(getMessage('OVERLAP_BLOCK_TIME','IP'));parent.frames[1].document.forms[0].room_no.value='';parent.frames[1].document.forms[0].bed_no.value='';parent.frames[1].document.forms[0].bed_no.focus();parent.frames[1].document.forms[0].bed_class_desc.value='';parent.frames[1].document.forms[0].bed_no.select(); </script>");
				}*/
					
			}
			else if (!nursingcode.equals(""))
			{
				String addlservice = "";
				//sql = " Select service_code, short_desc, ancillary_yn  from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"') ";
				/*Friday, April 23, 2010 modified for performance tuining*/
				sql = " Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"') ";



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql);

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("short_desc"));
				}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				out.println("<script>");
				out.println("var obj =parent.frames[1].document.forms[0].service;");
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");

				sql = " select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code = ? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2  ";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,nursingUnitCode);
				rset = pstmt.executeQuery();								
				while (rset.next())
				{
					addlservice			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					
					
					/*Modified by Dharma on jan 17 2014 for RUT-SCF-0352 [IN:046525] Start*/

					/*out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					out.println ("parent.frames[1].document.createElement('Option')") ;*/

					out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\";opt.value=\""+addlservice+"\";");

					if(is_default_service.equals("N")){	
						out.println ("if(\""+request_service_desc+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					}else{
						out.println ("if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					}
					out.println ("parent.frames[1].document.createElement('Option')") ;

					/*Modified by Dharma on jan 17 2014 for RUT-SCF-0352 [IN:046525] End*/


				}
				out.println("</script>");
				if(rset !=null) rset.close(); 
				if(pstmt != null) pstmt.close();

				//generation of bed class
				String BedClass_code = "";
				String BedClass_desc = "";
				// Query Used for Populating bed class Value...
				%>
				<script>
				var bedclass_obj = '';
					if(parent.frames[1].document.forms[0].Bedcode!=null)
					{
						bedclass_obj =parent.frames[1].document.forms[0].Bedcode;
						var length  = bedclass_obj.length;
						for(i=0;i<length;i++) 
						{
							bedclass_obj.remove(1);
						}
					}
				</script>				
				<%
				//sql =" select distinct a.bed_class_code, b.short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b where b.language_id = ? and a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ";
				/*Friday, April 23, 2010 modified for performance tuining*/
				sql = "SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ? AND a.psuedo_bed_status = 'N' ORDER BY short_desc" ;

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingcode);

				rset = pstmt.executeQuery();

				if(rset != null)
				{
					while(rset.next())
					{
						BedClass_code =	checkForNull(rset.getString("bed_class_code"));
						BedClass_desc =	checkForNull(rset.getString("short_desc"));
			%>
				<script>
					var bedClassOpt	= parent.frames[1].document.createElement("OPTION");
					bedClassOpt.text	= "<%=BedClass_desc%>";;
					bedClassOpt.value= "<%=BedClass_code%>";
					//parent.frames[1].document.forms[0].Bedcode.add(bedClassOpt);
					bedclass_obj.add(bedClassOpt);
				</script>
			<%
					}
				}
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				//end of generating bed class
			}
		}	

		// validation of bed no.

		if(from.equals("validate_bed_no"))
		{
			//String nursingcode  =	value3;
			bedno				=	value5;
			//String from_date		=	checkForNull(request.getParameter("from_date"));
			//String to_date			=	checkForNull(request.getParameter("to_date"));
			//String call_function	=	checkForNull(request.getParameter("call_function"));

			if(!bedno.equals(""))
			{
					//int no_of_time_bed_booked = 0;

					
					/*sql	= "select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI')))";

					
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_time_bed_booked				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				
					if(no_of_time_bed_booked>0)
					{

						
							out.println("<script> var msg = getMessage('OVERLAP_BLOCK_TIME','IP');		parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=BOOKING&call_func="+call_function+"&function_name=Create%20Booking&function_type=F&access=NYNNN';						parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?err_num='+msg+'&err_value=0&call_func="+call_function+"';</script>");
		
					}
					else
					{*/
						
						out.println("<script>parent.frames[1].callApply();</script>");
					//}
					
			}
			else
			{
				out.println("<script>parent.frames[1].callApply();</script>");
			}

		}
		/*Friday, October 01, 2010 , referral source in Active Booking changed to lookup since AM_REFERRAL has huge data and screen taking time to load*/
		if(from.equals("Active_booking"))
		{
			 String ref_type = request.getParameter("ref_type");
			 if(ref_type==null) ref_type="";
			 StringBuffer sqlFacility = new StringBuffer();
			 String referredFacilityid = "";
			 String referredFacilitydesc = "";
			 if(ref_type.equals("L"))
			 {
				if(sqlFacility.length() > 0) sqlFacility.delete(0,sqlFacility.length());
				sqlFacility.append("Select sm_get_desc.sm_facility_param(facility_id ,'"+locale+"',1) facility_name, facility_id from sm_facility_param Where STATUS = 'E'");
				sqlFacility.append(" and facility_id = '"+facilityId+"' ");
		
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sqlFacility.toString());
				if(rset.next())
				{
						referredFacilityid				= rset.getString("facility_id");		
						referredFacilitydesc			= rset.getString("facility_name");	
						%>
					<script>
						var temp = "<%=referredFacilityid%>";
						var temp1="<%=referredFacilitydesc%>";
						var opt3=parent.frames[1].document.createElement("OPTION");
						opt3.text=temp1;
						opt3.value=temp;          
						<%
						if(ref_type.equals("L"))
						{
						%>				

						parent.frames[1].document.forms[0].referral_source.value=temp1;
						parent.frames[1].document.forms[0].referral_source1.value=temp;
						parent.frames[1].document.forms[0].referral_source.disabled=true;
						parent.frames[1].document.forms[0].referral_source_lkp_but.disabled=true;
						//parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=temp1;
						//parent.frames[1].document.forms[0].referral_source1.value=temp;
						<%
						}
						%>
					</script>
					<%
				}
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			}
			
		}
	/*	if(from.equals("OT"))
		{
			String nursingcode		=	value3;
			String splcode			=	checkForNull(request.getParameter("splCode"));
			String patientclass		=	checkForNull(request.getParameter("patientclass"));
			String practID			=	checkForNull(request.getParameter("practID"));
			String p_oper_stn_id	=	checkForNull(request.getParameter("p_oper_stn_id"));
			String loginUser		=	checkForNull(request.getParameter("loginUser"));


			
					int no_of_user = 0;

					
					sql	= "select count(*) no_of_record from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW c ,IP_MED_SER_GRP_NURS_UT_TYPE e, IP_NURS_UNIT_FOR_SPECIALTY f  ,IP_NURSING_UNIT_FOR_PRACT g  where language_id = '"+localeName+"' and a.facility_id ='"+facilityId+"' and a.eff_status = 'E' and  c.facility_id  = a.facility_id  and c.locn_type = 'N' and c.locn_code  = a.nursing_unit_code and  c.appl_user_id = '"+loginUser+"'  and c.oper_stn_id = '"+p_oper_stn_id+"' and e.FACILITY_ID = a.FACILITY_ID and e.NURSING_UNIT_TYPE_CODE = a.NURSING_UNIT_TYPE_CODE and f.FACILITY_ID = a.FACILITY_ID AND f.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND f.SPECIALTY_CODE = '"+splcode+"'  and g.FACILITY_ID = a.FACILITY_ID AND g.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND g.PRACTITIONER_ID = '"+practID+"' and a.NURSING_UNIT_CODE='"+nursingcode+"' and (c.CREATE_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y')  and a.PATIENT_CLASS='"+patientclass+"' ";
					
					out.println("<script>alert(\""+sql+"\");</script>");
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_user				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				
					if(no_of_user>0)
					{
					
						//out.println("<script>parent.frames[1].ChangeVal(parent.frames[1].document.forms[0].med_service_grp);parent.frames[1].displayDefaultValue(parent.frames[1].document.forms[0].exp_days_of_stay);parent.frames[1].dateCal(parent.frames[1].document.forms[0].pref_adm_date);</script>");

						//out.println("<script>return true;</script>");
						//out.println("<script> var msg = getMessage('OVERLAP_BLOCK_TIME','IP');		parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=BOOKING&call_func="+call_function+"&function_name=Create%20Booking&function_type=F&access=NYNNN';						parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?err_num='+msg+'&err_value=0&call_func="+call_function+"';</script>");		
					}
					else
					{
						//out.println("<script>parent.frames[1].callApply();</script>");
						out.println("<script> var msg = 'User is not associated with Nursing Unit . ';	alert(msg);						parent.window.close();</script>");		
					}
		}*/
		
			//out.println("<script>alert(\""+bl_operational+"\");</script>");
			//out.println("<script>alert(\""+patient_id+"\");</script>");
			//out.println("<script>alert(\""+blng_grp+"\");</script>");
			// Start of billing interface
			if(bl_operational.equals("Y") && !patient_id.equals("") && is_tab_click.equals("Y")) 
			{
				if((blng_grp == null || blng_grp.equals("")))
				{
					
				
				%>
						<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="patient_id" value="<%=patient_id%>" />
							<jsp:param name="calling_module" value="<%=module_id%>" />
							<jsp:param name="calling_function_id" value="<%=calling_function_id%>" />
							<jsp:param name="episode_type" value="<%=episode_type%>" />
							
						</jsp:include>
						<script>
						if(parent.frames[1].booking_form)
						{
							parent.frames[1].booking_form.billing_group.value=document.forms[0].billing_group.value;
							parent.frames[1].booking_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;
							parent.frames[1].booking_form.bl_operation.value=document.forms[0].bl_operation.value;
							
						}
						</script>

						
				<%
				}

					out.println("<script>parent.frames[1].grabFinancialDetails();</script>");

			}
			else if(bl_operational.equals("Y") && patient_id.equals("") && is_tab_click.equals("Y"))
			{
				out.println("<script>parent.frames[1].grabFinancialDetails();</script>");
			}

			//End of Billing Interfacing


	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(stmt != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(rset != null )	rset.close();
		if(rs != null )		rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</form>
</html>

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

