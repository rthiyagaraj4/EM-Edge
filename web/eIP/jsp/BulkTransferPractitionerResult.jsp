<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
Connection con = null;
try	
{
	con				= ConnectionManager.getConnection(request);	
	Statement stmt	= null;
	ResultSet rs	= null;
%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eIP/js/BulkTransferPractitioner.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<%
		try
		{
			request.setCharacterEncoding("UTF-8");
			String locale						= (String)session.getAttribute("LOCALE");
			String loginUser=session.getAttribute("login_user") == null ? "" : (String) session.getAttribute("login_user");
			StringBuffer where_criteria			= new StringBuffer();
			StringBuffer sql					= new StringBuffer();
			String encounter_id					= "";
			String class_val					= "QRYEVENSMALL";
			String whereClause					= request.getParameter("whereclause");
			String from							= request.getParameter( "from" ) ;
			String to							= request.getParameter( "to" ) ;
			String checkedOnes					= "";			
			String facility_id					= checkForNull((String)session.getValue("facility_id"));
			//String p_practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
			String nursing_unit_code_from			= checkForNull(request.getParameter("nursing_unit"));
			String speciality_code				= checkForNull(request.getParameter("Splcode"));
			String practitioner_id_from			= checkForNull(request.getParameter("practid_from"));
			String practitioner_id				= "";
			String practitioner_id_to			= checkForNull(request.getParameter("practid_to"));
			String trans_type				= checkForNull(request.getParameter("trans_type"));

			

			String nursing_unit_code="";
			String nursing_unit_desc="";
			String dbspeciality_code="";
			String service_code="";
			String team_id="";
			String bed_type_code="";
			String patient_class="";
			String bed_class_code="";
			
			
			String from_date					= checkForNull(request.getParameter("fromdate"));
			

			if(!(from_date.equals("") || from_date == null))
					from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 	
	
						
		
			String to_date						= checkForNull(request.getParameter("todate"));
						
			if(!(to_date.equals("") || to_date == null))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 			
	
		
			String e1							= checkForNull(request.getParameter("e1"));
			String e2							= checkForNull(request.getParameter("e2"));
			String patient_name					= "";
			String bed_no						= "";
			String room_no						= "";
			String bed_class					= "";
			String bed_type						= "";
			String specialty_short_desc			= "";
			String practitioner_name			= "";
			String prev_val						= "";
			String Sex							= "";
			String admission_date_time			= "";
			//String allow_bed_swap_yn			= "";
			String patient_id					= "";
			//String hid_gender1					= "";
			String admission_date_time_converted= "";
			String curr_loc						= "";
			//String frpractdesc					= "";
			String opstn_id					    = "";
			String SELECT_CHK_BOX				= "";
			String SELECT_CHK_BOX1				= "";
			String chkAttribute					= "";
			

			int start							= 0;
			int end								= 0;
			int i								= 1;
			int maxRecord						= 0;
			int cnt								= 0;
			
			if ( from == null )
			
			start								= 1 ;		
			
			else
			start								= Integer.parseInt( from ) ;
			
			if ( to == null )
			end									= 12 ;
			
			else
			end									= Integer.parseInt( to ) ;
			
			String req_start					= checkForNull(request.getParameter("start"),"0");
			String req_end						= checkForNull(request.getParameter("end"),"0");

			//out.println(whereClause);
			
			if(whereClause == null)
			{
				//out.println("cmg 1");
				//where_criteria.append(" where a.facility_id='"+facility_id+"' ");
				if(nursing_unit_code_from!=null && !nursing_unit_code_from.equals(""))
					where_criteria.append( " and a.nursing_unit_code='"+nursing_unit_code_from+"' ");
				if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
				if(practitioner_id_from!=null && !practitioner_id_from.equals(""))
					where_criteria.append( " and a.attend_practitioner_id = '"+practitioner_id_from+"' ");
				if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
				if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				
			}
			else
			{
				where_criteria.append( whereClause );
			}
			//out.println(where_criteria.toString());
			
%>
	
	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
		<!--<form name = "BulkTransferPractitionerResult" method = "post" action ="../../eIP/jsp/BulkTransferPractitionerResult.jsp" target = "parent.frames[1]"> target = 'messageFrame'>-->
	<form name = "BulkTransferPractitionerResult" method = "post" action = "../../servlet/eIP.BulkTransferPractitionerServlet">
<%
			
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("Check"+(i-1)) != null)
					{
						checkedOnes = request.getParameter("Check"+(i-1));						
						
						j++;
					}
					else
					{
					}
				}
%>
					<input type=hidden name='pages' id='pages' value='multiple'>
					<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>
<%      
			}
			i = 1 ;

			
			sql.append("Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+loginUser+"','N','','PRACT_TRANSFER_YN')login_user FROM dual");
			//out.println(sql);
			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());
			if(rs!=null && rs.next()){
			opstn_id=rs.getString("login_user");
			}
			
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			sql.append("select a.specialty_code dbspeciality_code, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.attend_practitioner_id practitioner_id,to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,a.encounter_id encounter_id,a.patient_id patient_id,decode('"+locale+"','"+locale+"',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name,b.sex gender,a.nursing_unit_code,ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, a.bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc,   a.bed_num bed_no,a.room_num room_no, DECODE (pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (facility_id, pat_curr_locn_code, '"+locale+"', 2 ), 'R', pat_curr_locn_code, op_get_desc.op_clinic (facility_id, pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,A.SERVICE_CODE SERVICE_CODE, A.TEAM_ID,(CASE WHEN (SELECT COUNT(*) FROM IP_NURSING_UNIT_FOR_PRACT WHERE FACILITY_ID = A.FACILITY_ID AND NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND  PRACTITIONER_ID  = '"+practitioner_id_to+"') > 0 and (SELECT COUNT(*) FROM AM_PRACT_ALL_SPLTY_VW WHERE FACILITY_ID = A.FACILITY_ID AND PRACTITIONER_ID  = '"+practitioner_id_to+"' and SPECIALTY_CODE=A.SPECIALTY_CODE) > 0 THEN 'Y' ELSE 'N' END) SELECT_CHK_BOX from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.patient_id = b.patient_id and a.attend_practitioner_id is not null and a.attend_practitioner_id<>'"+practitioner_id_to+"' and a.nursing_unit_code in (SELECT locn_code FROM AM_OS_USER_LOCN_ACCESS_VW WHERE facility_id='"+facility_id+"' and locn_type = 'N' AND oper_stn_id = '"+opstn_id+"' AND appl_user_id = '"+loginUser+"' AND PRACT_TRANSFER_YN = 'Y')"); 
			
			sql.append(where_criteria);
			sql.append("order by specialty_short_desc,practitioner_short_name");
			
			//out.println("SQL-->"+sql.toString());

			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			
			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());

			int recSelect = 0;
			if ( start != 1 )
			{
				for( int j=1; j<start; i++,j++ )
				{
					rs.next() ;
				}
					recSelect +=start;
					--recSelect;
			}
			
//			while ( i<=end && rs.next() ) 
			while ( rs.next() ) 
			{
				
			if(maxRecord==0)
			{
			
%>
				<table align='right'>
					<tr>
						
							<input type=hidden name=from id=from value="<%=start%>">
							<input type=hidden name=to id=to value="<%=end%>">
							<input type=hidden name='start' id='start' value="<%=start%>">
							<input type=hidden name='end' id='end' value="<%=end%>">
<%
							if ( !(start <= 1)) 
							{
%>								<!--previous & next-->
								<!--<td align='right' id='prev'><a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td> 
								<input type=hidden name='whichPage' id='whichPage' value='prev'>-->
<%
							}
							
%>
								<!--<td align='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
								<input type=hidden name='whichPage' id='whichPage' value='next'>-->
						
					</tr>
				</table>
				<br><BR>

				<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='1' cellpadding=0 cellspacing=0 >
					<tr>
						<td class="columnheadercenter" >&nbsp;</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.AdmissionDateTime.label"bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>
						</td>
					
					<!--<td class="columnheadercenter" >
							<fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>
						</td>-->
						<td class="columnheadercenter" >
							<fmt:message key="Common.bedno.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.room.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter" >
							<fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/>
						</td>
						<td class="columnheadercenter"  checked>
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />&nbsp;&nbsp;
						</td>
					</tr>
			<!--</table>
				<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='1' cellpadding=0 cellspacing=0 >-->
<%
			}//end of if(maxRecord==0)
				
						
					admission_date_time			= checkForNull(rs.getString("ADMISSION_DATE_TIME"),"");
						
						
						if(!(admission_date_time.equals("") || admission_date_time == null))
							admission_date_time_converted = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 			
						
						dbspeciality_code		= checkForNull(rs.getString("dbspeciality_code"));
						service_code			= checkForNull(rs.getString("SERVICE_CODE"));
						team_id					= checkForNull(rs.getString("TEAM_ID"));
						bed_type_code			= checkForNull(rs.getString("BED_TYPE_CODE"));
						bed_class_code			= checkForNull(rs.getString("bed_class_code"));
						patient_class			= checkForNull(rs.getString("PATIENT_CLASS"));
						encounter_id			= checkForNull(rs.getString("ENCOUNTER_ID"));
						patient_id				= checkForNull(rs.getString("PATIENT_ID"));
						patient_name			= checkForNull(rs.getString("PATIENT_NAME"),"");
						Sex						= checkForNull(rs.getString("GENDER"));
						nursing_unit_code		= checkForNull(rs.getString("NURSING_UNIT_CODE"),"");
						nursing_unit_desc		= checkForNull(rs.getString("NURSING_UNIT_SHORT_DESC"),"");
						bed_class				= checkForNull(rs.getString("BED_CLASS_SHORT_DESC"),"");
						bed_type				= checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));
						bed_no					= checkForNull(rs.getString("BED_NO"));
						room_no					= checkForNull(rs.getString("ROOM_NO"));
						curr_loc				= checkForNull(rs.getString("NURSING_UNIT_SHORT_DESC"),"");
						specialty_short_desc	= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"),"");
						practitioner_id			= checkForNull(rs.getString("PRACTITIONER_ID"));
						//practitioner_id			= checkForNull(rs.getString("attend_practitioner_id"));
						practitioner_name		= checkForNull(rs.getString("PRACTITIONER_SHORT_NAME"),"");
						SELECT_CHK_BOX			= checkForNull(rs.getString("SELECT_CHK_BOX"));
						//out.println(SELECT_CHK_BOX);
						if(Sex.equals ("M"))
                         Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(Sex.equals ("F"))
							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else
							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
%>
					<tr>
<%		
							
						String val				= specialty_short_desc+"/"+practitioner_name;
						if(!prev_val.equals(val))
							{ 
%>
								<td class='CAGROUPHEADING' colspan='13'><%=val%>
								</td>
							</tr>
							<tr>
<%	
							}
%>		
							<input type="hidden" name='dbspeciality_code<%=cnt%>' value='<%=dbspeciality_code%>'>
							<input type="hidden" name='service_code<%=cnt%>' value='<%=service_code%>'>
							<input type="hidden" name='team_id<%=cnt%>' value='<%=team_id%>'>
							<input type="hidden" name='bed_type_code<%=cnt%>' value='<%=bed_type_code%>'>
							<input type="hidden" name='bed_class_code<%=cnt%>' value='<%=bed_class_code%>'>
							<input type="hidden" name='patient_class<%=cnt%>' value='<%=patient_class%>'>
							<td class="<%=class_val%>">
								<a href="javascript:closeWin('<%=encounter_id%>','<%=patient_id%>','N')">+</a>
								<input type = "hidden" name = 'plus <%=i++%>'>
							</td>
							<td  class='<%=class_val%>'>
								<input type = "hidden" name = 'admission_date_time<%=cnt%>' value='<%=admission_date_time%>'> <%=admission_date_time_converted%>
							</td>
							<td  class='<%=class_val%>'>
							<input type = "hidden" name = 'encounter_id<%=cnt%>' value='<%=encounter_id%>'><%=encounter_id%>
							</td>
							<td  class='<%=class_val%>'>
							<input type = "hidden" name = 'patient_id<%=cnt%>' value='<%=patient_id%>'><%=patient_id%>
							</td>
							<td  class='<%=class_val%>'>
								<input type = "hidden" name = 'patient_name'><%=patient_name%>
							</td>
							<td  class='<%=class_val%>'>
								<input type = "hidden" name = 'Sex'><%=Sex%>
							</td>
							<td  class='<%=class_val%>'>
								<input type = "hidden" name = 'nursing_unit_code<%=cnt%>' value='<%=nursing_unit_code%>'><%=nursing_unit_desc%>
							</td>
							<td  class='<%=class_val%>'>
								<input type = "hidden" name = 'bed_class<%=cnt%>' value='<%=bed_class%>'><%=bed_class%>
							</td>
							<td class='<%=class_val%>' >
								<input type = "hidden" name = 'bed_no<%=cnt%>' value='<%=bed_no%>'><%=bed_no%>
							</td>
							<td class='<%=class_val%>' >
								<input type = "hidden" name = 'room_no<%=cnt%>' value='<%=room_no%>'><%=room_no%>
							</td>
							<td class='<%=class_val%>' >
								<input type = "hidden" name = 'nursing_unit_desc'><%=nursing_unit_desc%>
							</td>
							<td class='<%=class_val%>'>
								<!--<input type='checkbox' name="Check<%=recSelect%>" id="Check<%=recSelect%>"  
								value='<%=SELECT_CHK_BOX%>'>-->
								<!--<input type = "hidden" name = 'chkAttribute<%=i++%>'>-->
<%
								
			if(SELECT_CHK_BOX.equals("Y"))
			 {
				chkAttribute = "CHECKED";
				SELECT_CHK_BOX1="true";
%>
								<input type='checkbox' name="Check<%=cnt%>" id="Check<%=cnt%>"  value='Y' onclick='getchkvalues(this)' checked>
<%
			 }
			 else
			 {
				chkAttribute = "DISABLED";
				SELECT_CHK_BOX1="false";
%>

								<input type='checkbox' name="Check<%=cnt%>" id="Check<%=cnt%>"  value='N' disabled>
<%
			 }
%>					
								
								<!--<%	if(SELECT_CHK_BOX.equals("Y")) {%>
								<input type='checkbox' name="Check" id="Check"  value='<%=SELECT_CHK_BOX%>' checked>
								<%}else {%>
								<input type='checkbox' name="Check" id="Check" value='<%=SELECT_CHK_BOX%>' disabled>
								<%}%>-->
							</td>
							<!--												onClick="checkNoSelect(this,<%=recSelect%>)" checked></td>-->
							<!--<td  class='<%=class_val%>'><%=specialty_short_desc%></td>
							<td  class='<%=class_val%>'><%=practitioner_name%></td>-->	
						</tr>
						<%	
						prev_val=val;
						recSelect++;				
						i++;
						cnt++;
						maxRecord++;
			}// end of while
					
				
				%>			
				</table>				
				<input type='hidden' name='whereclause' id='whereclause' value="<%=where_criteria.toString()%>" >
				<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>" >
				<input type='hidden' name='total_count' id='total_count' value="<%=(recSelect-1)%>" >
				<input type='hidden' name='e1' id='e1' value="<%=e1%>" >
				<input type='hidden' name='e2' id='e2' value="<%=e2%>" >
				<input type='hidden' name='nursing_unit_code_from' id='nursing_unit_code_from' value="<%=nursing_unit_code_from%>" >
				<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>" >
				<input type='hidden' name='from_date' id='from_date' value="<%=from_date%>" >
				<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>" >
				<input type='hidden' name='trans_type' id='trans_type' value="<%=trans_type%>" >
				<input type='hidden' name='practitioner_id_from' id='practitioner_id_from' value="<%=practitioner_id_from%>" >
				<input type='hidden' name='practitioner_id_to' id='practitioner_id_to' value="<%=practitioner_id_to%>" >
				<input type='hidden' name='counter' id='counter' value="<%=cnt%>" >
			</form>
		
	</body>
		<%	
		
			if(maxRecord<12 || (!rs.next()))
				{%>
					<!--<script >
						if (document.getElementById("next"))
						//document.getElementById("next").style.visibility='visible';	
						document.getElementById("next").style.visibility='hidden';
					</script>-->
				<%}
				else
				{%>
					<!--<script >
						if (document.getElementById("next"))
						//document.getElementById("next").style.visibility='hidden';	
						document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


-->
				<%}


		
				if(maxRecord == 0)
				{%>
					<script>
						//alert(""+sql);	
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
					//parent.frames[3].location.href= '../../eIP/jsp/BulkTransferPractitionerResult.jsp';
					//parent.frames[3].location.href='../../eCommon/html/blank.html';
					//history.go(-1);
					</script>
					<%
				}
				else
				{%>
					<!--<script>
						parent.frames[3].location.href= '../../eIP/jsp/BulkTransferPractitionerResult.jsp?<%=request.getQueryString()%>';
					</script>-->
				<%
				}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
				
		}catch(Exception e)
		{
			out.println(e);
			e.printStackTrace();
		}

	}catch(Exception e)
	{
		out.println("Exception:"+e.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}	
%>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

