<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="ForSplChars.jsp" %>
<jsp:useBean id="swapPatientBedResultBean" class="webbeans.eCommon.RecordSet" scope="session"/> 
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
		<script src='../../eIP/js/SwapPatientBeds.js' language='javascript'></script>
		
		<%
		try
		{
			request.setCharacterEncoding("UTF-8");
			String locale					= (String)session.getAttribute("LOCALE");
			StringBuffer where_criteria		= new StringBuffer();
			StringBuffer sql				= new StringBuffer();
			String encounter_id				= "";
			String class_val				= "QRYEVENSMALL";
			String whereClause				= request.getParameter("whereclause");
			String from						= request.getParameter( "from" ) ;
			String to						= request.getParameter( "to" ) ;
			String checkedOnes				= "";			
			String facility_id				= checkForNull((String)session.getValue("facility_id"));
			String p_practitioner_id		= checkForNull(request.getParameter("practitioner_id"));
			String nursing_unit_code		= checkForNull(request.getParameter("nursing_unit"));
			String speciality_code			= checkForNull(request.getParameter("Splcode"));
			String practitioner_id			= checkForNull(request.getParameter("practid"));
			String from_date				= checkForNull(request.getParameter("from_date"));
			if(!(from_date.equals("") || from_date == null))
					from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 

			String to_date					= checkForNull(request.getParameter("to_date"));
			if(!(to_date.equals("") || to_date == null))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 

			String e1						= checkForNull(request.getParameter("e1"));
			String e2						= checkForNull(request.getParameter("e2"));
			String patient_name				= "";
			String bed_no					= "";
			String room_no					= "";
			String bed_class				= "";
			String specialty_short_desc		= "";
			String practitioner_name		= "";
			String prev_val					= "";
			String Sex						= "";
			String admission_date_time		= "";
			String allow_bed_swap_yn		= "";
			String patient_id				= "";
			//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start
			Boolean isNewBornChngsAppl		= eCommon.Common.CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");
			String trans_yn_unfnzed_newborn	= "N";
			//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End


			int start	= 0;
			int end		= 0;
			int i		= 1;
			int maxRecord=0;
			if ( from == null )
				start = 1 ;		
			else
				start = Integer.parseInt( from ) ;
			if ( to == null )
				end = 12 ;
			else
				end = Integer.parseInt( to ) ;
			/*Added by Thamizh selvi on 29th May 2018 - checkbox check/uncheck value not retained while traversing through next/prev link*/
			if(from != null && to != null)
				maxRecord = Integer.parseInt(to);
			/*End*/
			String req_start       = checkForNull(request.getParameter("start"),"0");
			String req_end         = checkForNull(request.getParameter("end"),"0");
			if(whereClause==null)
			{
				where_criteria.append(" where a.facility_id='"+facility_id+"' ");
				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					where_criteria.append( " and a.nursing_unit_code='"+nursing_unit_code+"' ");
				
				if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
				
				if(practitioner_id!=null && !practitioner_id.equals(""))
					where_criteria.append( " and a.attend_practitioner_id='"+practitioner_id+"' ");
				if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(a.admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
				
				if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(a.admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
				{
						where_criteria.append(" and (a.ATTEND_PRACTITIONER_ID ='"+ p_practitioner_id +"'  ");
						where_criteria.append(" or a.encounter_id in ");
						where_criteria.append("(select encounter_id  ");
						where_criteria.append("  from pr_encounter_pract ");
						where_criteria.append(" where operating_facility_Id= '"+ facility_id +"'  ");
						where_criteria.append(" and practitioner_id= '"+ p_practitioner_id +"' )) ");
				}
			}
			else
			{
				where_criteria.append( whereClause );
			}
			/*Wednesday, June 02, 2010 , commented for PE*/
			/*			
			sql.append(" select  count(*) from IP_OPEN_ENCOUNTER a, MP_PATIENT B  "+where_criteria.toString() );	
			sql.append(" and a.patient_id=b.patient_id and a.room_num is not null and a.bed_num is not null  ");
			sql.append(" and oth_adt_status is null and ip_leave_status is null ");
			sql.append(" and tfr_req_status is null ");

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());

			rs.next();
			maxRecord = rs.getInt(1);
			*/
			%>
			</head>
			<body onLoad='validateCheck()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			<form name='iplookupqueryresult' id='iplookupqueryresult' method="post" action="../../eIP/jsp/SwapPatientBedsResult.jsp"  target='messageFrame'>
			<%
			if (whereClause==null)
				swapPatientBedResultBean.clearAll();
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("Check"+(i-1)) != null)
					{
						checkedOnes = request.getParameter("Check"+(i-1));						
						if(!(swapPatientBedResultBean.containsObject(checkedOnes)))
							swapPatientBedResultBean.putObject(checkedOnes);
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

			//Added by Devang on 28/09/2002
			
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" select to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,");
			sql.append("b.sex gender ,  AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc,"); 
			sql.append("a.nursing_unit_code nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+locale+"','1') "); 
			sql.append(" practitioner_short_name,a.encounter_id encounter_id, a.patient_id patient_id, ");
			sql.append(" decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, ");
			sql.append("IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc,a.ATTEND_PRACTITIONER_ID ");
			sql.append(" practitioner_id,(CASE WHEN A.BED_CLASS_CODE IS NOT NULL THEN( SELECT ALLOW_BED_SWAP_YN FROM IP_BED_CLASS WHERE BED_CLASS_CODE = A.BED_CLASS_CODE )END )  allow_bed_swap_yn,a.room_num room_no,a.bed_num bed_no,(select TRANS_YN_UNFNZED_NEWBORN from ip_param where facility_id='"+facility_id+"') TRANS_YN_UNFNZED_NEWBORN  from IP_OPEN_ENCOUNTER a, MP_PATIENT B  "+where_criteria.toString()+"  ");
			sql.append(" and a.patient_id=b.patient_id and a.room_num is not null and a.bed_num is not null ");
			sql.append(" and a.tfr_req_status is null ");
			sql.append(" and a.oth_adt_status is null and a.ip_leave_status is null ");

			sql.append(" order by bed_class_short_desc, admission_date_time, encounter_id");

			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());

			int recSelect = 0;
			int flag=0;
			if(rs !=null)
			{
				if ( start != 1 )
				{
					for( int j=1; j<start; i++,j++ )
					{
						rs.next() ;
					}
					recSelect +=start;
					--recSelect;
				}
				while ( rs.next() && i<=end ) 
				{
			/*if (( !(start <= 1)) || ( !((start+12) > maxRecord )) )
			{*/
					if(flag==0)
					{
				%>
				<table  align='right' id ='maxrec'>
					<tr>
							<input type=hidden name=from value="<%=start%>">
							<input type=hidden name=to value="<%=end%>">
							<input type=hidden name='start' id='start' value="<%=start%>">
							<input type=hidden name='end' id='end' value="<%=end%>">
							<%
							if ( !(start <= 1)) 
							{
								%>
								<td align='right' id='prev' style='visibility:visible'><a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
								<input type=hidden name='whichPage' id='whichPage' value='prev'>
								<%
							}
							//if ( !((start+12) > maxRecord ))
							//{
								%>
								<td align='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
								<input type=hidden name='whichPage' id='whichPage' value='next'>
								<%
							//}
							%>
					</tr>
				</table>
				<br><BR>
				<%
			//}
			%>
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
				<tr>
					<td class="columnheadercenter" nowrap>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="columnheadercenter" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
				</tr>
				<%
					}
					
						room_no					= checkForNull(rs.getString("room_no"));
						bed_no					= checkForNull(rs.getString("bed_no"));
						admission_date_time		= checkForNull(rs.getString("admission_date_time"),"&nbsp;");
						admission_date_time		= DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);
						specialty_short_desc	= checkForNull(rs.getString("specialty_short_desc"),"&nbsp;");
						encounter_id			= checkForNull(rs.getString("encounter_id"));
						Sex						= checkForNull(rs.getString("gender"));
						patient_id				= checkForNull(rs.getString("patient_id"));
						patient_name			= checkForNull(rs.getString("patient_name"),"&nbsp;");
						bed_class				= checkForNull(rs.getString("BED_CLASS_SHORT_DESC"));
						practitioner_id			= checkForNull(rs.getString("practitioner_id"));
						practitioner_name		= checkForNull(rs.getString("practitioner_short_name"));
						allow_bed_swap_yn		= checkForNull(rs.getString("allow_bed_swap_yn"));
						/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
						trans_yn_unfnzed_newborn		= checkForNull(rs.getString("TRANS_YN_UNFNZED_NEWBORN"),"N");
						int unFinalizedNewBornCnt	= 0;
						if("F".equals(Sex) && isNewBornChngsAppl && "Y".equals(trans_yn_unfnzed_newborn)){
							unFinalizedNewBornCnt		= eIP.IPCommonBean.getUnfinalizedNewBornCount(con,patient_id);	
						}
						/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
					

						try
						{
							if(swapPatientBedResultBean.containsObject(encounter_id))  allow_bed_swap_yn = "Y";
							else if(!allow_bed_swap_yn.equals("Y"))  allow_bed_swap_yn = "N";
							int recordIndex = swapPatientBedResultBean.indexOfObject(encounter_id);
							if(recordIndex!=-1)
							if(allow_bed_swap_yn.equals("Y"))    swapPatientBedResultBean.removeObject(recordIndex);
						}
						catch(Exception e)
						{
							//out.println("Exception@containsObject : "+e);
							e.printStackTrace();
						}
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
						%>
						<tr>
							<%		
							if(!prev_val.equals(bed_class))
							{ %>
								<td 
									class='CAGROUPHEADING' colspan='11' align='left'><%=bed_class%>
								</td></tr><tr>
								<%	
							}
							%>		
							<td class="<%=class_val%>" nowrap> <a href="javascript:closeWin('<%=encounter_id%>','<%=patient_id%>','N')">+</a></td>
							<td nowrap class='<%=class_val%>' align='center'>
							<input type='checkbox' name="Check<%=recSelect%>" id="Check<%=recSelect%>"  value='<%=encounter_id%>' onClick="checkNoSelect(this,<%=recSelect%>,<%=unFinalizedNewBornCnt%>)"></td>
							<td class='<%=class_val%>' nowrap><%=room_no%></td>
							<td class='<%=class_val%>' nowrap><%=bed_no%></td>
							<td class='<%=class_val%>' nowrap><%=admission_date_time%></td>
							<td nowrap class='<%=class_val%>'><%=encounter_id%></td>
							<td nowrap class='<%=class_val%>'><%=patient_id%></td>
							<td nowrap class='<%=class_val%>'><%=patient_name%></td>
							<td nowrap class='<%=class_val%>'><%=Sex%></td>
							<td nowrap class='<%=class_val%>'><%=specialty_short_desc%></td>
							<td nowrap class='<%=class_val%>'><%=practitioner_name%></td>				
							<td ><input type='hidden'  value='<%=allow_bed_swap_yn%>' name='allow_bed_swap_yn<%=recSelect%>'></td>
						</tr>
						<%	
						prev_val=bed_class;
						recSelect++;				
						i++;
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
					{
						%>
						<script >
							if (document.getElementById("next"))
									document.getElementById("next").style.visibility='visible';
						</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%
					}
					
			}
				%>			
				</table>
				<input type='hidden' name='whereclause' id='whereclause' value="<%=where_criteria.toString()%>" >
				<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>" >
				<input type='hidden' name='total_count' id='total_count' value="<%=(recSelect-1)%>" >
				<input type='hidden' name='e1' id='e1' value="<%=e1%>" >
				<input type='hidden' name='e2' id='e2' value="<%=e2%>" >
				<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
				<input type='hidden' name='maxRecord' id='maxRecord' value="<%=maxRecord%>" >
				</form>
				</body>
		
	<%	
			if(maxRecord == 0)
			{%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
					parent.frames[3].location.href='../../eCommon/html/blank.html';
					</script>
				<%
				return;
			}
			else
			{
				%>
				<script>
					parent.frames[3].location.href= '../../eIP/jsp/SwapPatientBedButtons.jsp?<%=request.getQueryString()%>';
				</script>
				<%
			}
					
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
				
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}

	}catch(Exception e)
	{
		//out.println("Exception:"+e.getMessage());
		e.printStackTrace();
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

