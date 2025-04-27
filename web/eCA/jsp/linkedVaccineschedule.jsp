<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/01/2017	IN066125		Dinesh T		03/01/2017		Ramesh G		EM run on window 10 and IE 11
																			Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
---------------------------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

 <%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
    String vacc_category_link = request.getParameter("vacc_category_link")==null?"":request.getParameter("vacc_category_link");
	
    String patientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
    String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
    String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
    String vaccine_desc = request.getParameter("vaccine_desc")==null?"":request.getParameter("vaccine_desc");
    String Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String vaccinceId = "";
	String vaccCetgoryId = "";
	String strDoseNo = "";
	String vac_sch_ref = "";
	String vac_sch_ref_db = "";
	String admin_site_desc = "";
	String img = "";
	boolean isEmpty =  true;
	
	if(!vacc_category_link.equals(""))
	{
		String str[] = vacc_category_link.split("~");
		if(str != null)
		{
			if(str.length > 2)
			{
				vaccinceId = str[1];
				vaccCetgoryId = str[0];
				strDoseNo = str[2];
				vac_sch_ref = str[3];
			}
			else if(str.length == 2)
			{
				vaccinceId = str[1];			
			}
			else if(str.length == 1)
			{
				vaccinceId = str[0];			
			}				

		}
		else
			vaccinceId = vacc_category_link;
	}

	 Connection con = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;

	try
	{
		String vaccDescSql = "select CA_GET_DESC.CA_IM_VACCINE (?,? ,2) SHORT_DESC from dual";
		con = ConnectionManager.getConnection(request);
		pst = con.prepareStatement(vaccDescSql);		
		pst.setString(1, vaccinceId);	
		pst.setString(2, locale);	
		rs = pst.executeQuery();
		if(rs.next())
		{
			vaccine_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
		}
		if(rs != null)
		{
			rs.close();
		}

		if(pst != null)
		{
			pst.close();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}


/*	out.println("<br>vacc_category_link -->"+vacc_category_link+"<----");
	out.println("<br>patientId -->"+patientId+"<----");
	out.println("<br>vaccinceId -->"+vaccinceId+"<---");
	out.println("<br>vaccCetgoryId -->"+vaccCetgoryId+"<---");
	out.println("<br>strDoseNo -->"+strDoseNo+"<---");
	out.println("<br>vac_sch_ref -->"+vac_sch_ref+"<---");*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
 <SCRIPT LANGUAGE="JavaScript">
 <!--
	function setSelect(obj)
	{
		var cnt = document.getElementById("chkCnt").value;

		for (var i = 0; i < cnt; i++)
		{
			var chkObj = document.getElementById("chk_"+i);
			if(chkObj.name == obj.name )
			{
				chkObj.checked = true;
				document.getElementById("selectedChkValue").value = chkObj.value;
			}
			else
			{
				chkObj.checked = false;
			}
		}
	}
 //-->
 </SCRIPT>
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='linkVaccineScheduleForm' id='linkVaccineScheduleForm' >
		<table class='grid' width='100%'>
				<tr>
					<%if(!callFrom.equals("") && callFrom.equals("ADMIN_RX")){%>
					<td class='label' colspan='3'>
						<B><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</B><%=vaccine_desc%>
					</td>
					<td class='label' colspan='5'>
						<B><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</B><%=order_id%>
					</td>
					<%}else{%>
					<td class='label' colspan='8'>
						<B><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</B><%=vaccine_desc%>
					</td>
					<%}%>
				</tr>
				<tr>				
					<td class='columnheadercenter' nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter'nowrap><fmt:message key="eCA.VaccineCategory.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter' nowrap><fmt:message key="eCA.VaccineDoseNo.label" bundle="${ca_labels}"/></td>
					<td class='columnheadercenter' v><fmt:message key="eCA.VaccineCategoryType.label" bundle="${ca_labels}"/></td>
					<!-- this is to show when call from other MAR screen -->
					<%if(!callFrom.equals("") && !callFrom.equals("ADMIN_RX")){%>
					<td class='columnheadercenter' nowrap><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
					<%}%>
					<td class='columnheadercenter' nowrap><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
					<td class='columnheadercenter' nowrap><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/></td>					
					<td class='columnheadercenter' nowrap><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<%
					  StringBuffer sql = new StringBuffer();
					//sql.append("SELECT b.VAC_SCH_REF, b.vacc_categ_id,ca_get_desc.ca_im_vac_categ (b.vacc_categ_id, ?, 2) vacc_categ_desc,a.dose_no, TO_CHAR (b.sch_created_date, 'dd/mm/yyyy') schedule_date,ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),a.SCHEDULE_DATE)  schedule_age,a.admin_site_id site_id,(select DECODE (c.age_specific_yn,'Y', 'Age Specific','N', 'Non Age Specific') from ca_im_vac_categ_lang_vw c where c.language_id = ? and c.vacc_categ_id = b.vacc_categ_id) vacc_categ_type,a.vaccine_id,a.order_id , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC FROM ca_im_pat_vac_sch_dtl a,ca_im_pat_vac_sch_hdr b WHERE a.vaccine_id = ? AND b.patient_id = ? AND a.vac_sch_ref = b.vac_sch_ref  AND a.LINKED_SCH_YN = 'N' ");//IN066125
					sql.append("SELECT b.VAC_SCH_REF, b.vacc_categ_id,ca_get_desc.ca_im_vac_categ (b.vacc_categ_id, ?, 2) vacc_categ_desc,a.dose_no, TO_CHAR (a.SCHEDULE_DATE, 'dd/mm/yyyy') schedule_date,ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),a.SCHEDULE_DATE)  schedule_age,a.admin_site_id site_id,(select DECODE (c.age_specific_yn,'Y', 'Age Specific','N', 'Non Age Specific') from ca_im_vac_categ_lang_vw c where c.language_id = ? and c.vacc_categ_id = b.vacc_categ_id) vacc_categ_type,a.vaccine_id,a.order_id , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC FROM ca_im_pat_vac_sch_dtl a,ca_im_pat_vac_sch_hdr b WHERE a.vaccine_id = ? AND b.patient_id = ? AND a.vac_sch_ref = b.vac_sch_ref  AND a.LINKED_SCH_YN = 'N' ");//IN066125
					 if(callFrom.equals("CA_IMMU"))
					{
						sql.append(" AND a.outcome_code = 'C'  AND a.order_id IS NOT NULL AND b.vacc_categ_id = (select vacc_categ_id from CA_IM_PARAM)");					  
					}else
					{
						sql.append(" AND a.outcome_code NOT IN ('C', 'N', 'E') ");					  
					}
						sql.append(" order by a.vaccine_id,b.VAC_SCH_REF DESC,a.DOSE_NO ");
					 
					  int cnt = 0;
					  try
					  {
						
						pst = con.prepareStatement(sql.toString());
						pst.setString(1, locale);
						pst.setString(2, Dob);
						pst.setString(3, locale);
						pst.setString(4, locale);
						pst.setString(5, vaccinceId);
						pst.setString(6, patientId);
						
						rs= pst.executeQuery();

						String vaccCategID = "";
						String vaccCategDesc = "";
						String dosoNo = "";
						String scheduleDate = "";
						String status = "";
						String scheduleAge = "";
						String siteId = "";
						String vaccCategType = "";
						String vaccID = "";
						

						while(rs.next())
						{
							isEmpty = false;
							vaccCategID = rs.getString("vacc_categ_id")==null?"":rs.getString("vacc_categ_id");
							vaccCategDesc = rs.getString("vacc_categ_desc")==null?"":rs.getString("vacc_categ_desc");
							dosoNo = rs.getString("dose_no")==null?"":rs.getString("dose_no");
							scheduleDate = rs.getString("schedule_date")==null?"":rs.getString("schedule_date");
							status = rs.getString("status")==null?"":rs.getString("status");
							scheduleAge = rs.getString("schedule_age")==null?"":rs.getString("schedule_age");
							scheduleAge = scheduleAge.equals("D")?"&nbsp;":scheduleAge;
							siteId = rs.getString("site_id")==null?"":rs.getString("site_id");
							vaccCategType = rs.getString("vacc_categ_type")==null?"":rs.getString("vacc_categ_type");
							vaccID = rs.getString("vaccine_id")==null?"":rs.getString("vaccine_id");							
							vac_sch_ref_db = rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");							
							order_id = rs.getString("order_id")==null?"":rs.getString("order_id");							
							admin_site_desc = rs.getString("ADMIN_SITE_DESC")==null?"":rs.getString("ADMIN_SITE_DESC");	
							
							if(status.equals("C"))
							{
								img = "Completed.gif";
							}
							else if(status.equals("E") )
							{
								img = "notadministered.gif";
							}
							else if(status.equals("D") )
							{
								img = "Due.gif";
							}
							else if(status.equals("L"))
							{
								img = "Elapsed.gif";
							}
							else if(status.equals("N"))
							{
								img = "In-Error.gif";
							}
							else if(status.equals("F"))
							{
								img = "Future.gif";
							}
							else if(status.equals("O"))
							{
								img = "OverDue.gif";
							}							
						%>
							<tr>								
								<td class='gridData'><input type='checkbox' name='chk_<%=cnt%>' id='chk_<%=cnt%>' value='<%=vaccCategID%>~<%=vaccID%>~<%=dosoNo%>~<%=vac_sch_ref_db%>`~<%=vaccCategDesc%>' <%if(vac_sch_ref_db.equals(vac_sch_ref) && vaccCategID.equals(vaccCetgoryId) && vaccID.equals(vaccinceId) && dosoNo.equals(strDoseNo)){%>checked<%}%> onclick='setSelect(this)'></td>
								<td class='gridData'><img src='../../eCA/images/<%=img%>'>&nbsp;<%=vaccCategDesc%></td>
								<td class='gridData'><%=dosoNo%></td>
								<td class='gridData'><%=vaccCategType%></td>
								<%if(!callFrom.equals("") && !callFrom.equals("ADMIN_RX")){%>
								<td class='gridData'><%=order_id%></td>
								<%}%>
								<!--<td class='gridData'><%=scheduleDate%></td>--><!--IN066125-->
								<td class='gridData' nowrap><%=com.ehis.util.DateUtils.convertDate(scheduleDate,"DMY","en",locale)%></td><!--IN066125-->
								<td class='gridData'><%=scheduleAge%></td>								
								<td class='gridData'><%=admin_site_desc%></td>	 
							</tr>
						<%
							cnt++;
								if (vacc_category_link.indexOf(",") <= 0 && vaccCategID.equals(vaccCetgoryId))
									vacc_category_link = vacc_category_link+"`~"+vaccCategDesc;
						}
						if(rs != null)
						{
							rs.close();
						}

						if(pst != null)
						{
							pst.close();
						}

					  }
					  catch(Exception e)
					  {
						e.printStackTrace();
					  }
					  finally
					  {
						try
						{
							if (con != null)
							{
								con.close();
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					  }
					%>
					
				</tr>
		</table>
		<input type='hidden' value='<%=cnt%>' name='chkCnt' id='chkCnt'>
		<input type='hidden' value='<%=vacc_category_link%>' name='selectedChkValue' id='selectedChkValue'>
	</form>
</body>
<SCRIPT LANGUAGE="JavaScript">
<!--
	<%if(isEmpty)
	{%>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "Common"));
		window.close();
	<%}%>
//-->
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>

