<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<Script src="../../eOA/js/SecondaryResource.js" language="JavaScript"></Script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = (String)session.getAttribute("LOCALE");
		String Clinic_Code=request.getParameter("clinic_code");
		String Practitioner_id=request.getParameter("pract_id");
		String From_time=request.getParameter("from_time");
		String To_time=request.getParameter("to_time");
		String VisitTypeCD=request.getParameter("visit_type");
		String time_table_type=request.getParameter("timetable_type");

		String from_date=request.getParameter("from_date");
		String to_date=request.getParameter("to_date");

			from_date=DateUtils.convertDate(from_date,"DMY",locale,"en");
				to_date=DateUtils.convertDate(to_date,"DMY",locale,"en");

		String week_day=request.getParameter("week_day");
		String rec_type=request.getParameter("rec_type");
		String patient_id=request.getParameter("patient_id");
		String no_of_slots=request.getParameter("no_of_slots");
		String care_locn_ind=request.getParameter("care_locn_ind");
		String res_class=request.getParameter("res_class");
		String facilityid=(String)session.getValue("facility_id");
		java.util.ArrayList arrlst=new java.util.ArrayList();

		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs2_oa=null;
		String classValue="";
		PreparedStatement pstmt=null;
		StringBuffer str1=new StringBuffer();
		StringBuffer str2=new StringBuffer();
		String status="";
		String checked="";
		String disabled="";
		//String comment="";
		String rec_days_from_sess=(String) session.getValue("REC_RES_SEL");
		if(rec_days_from_sess==null) rec_days_from_sess="";
		java.util.ArrayList arrlst_for_sess=new java.util.ArrayList();


	if(! rec_days_from_sess.equals(""))
	{
		java.util.StringTokenizer strtkrecc=new java.util.StringTokenizer(rec_days_from_sess,"*");

		while (strtkrecc.hasMoreElements())
		{
			String Stringtk1recc=(String) strtkrecc.nextElement();

			java.util.StringTokenizer strtk1recc=new java.util.StringTokenizer(Stringtk1recc,"@");
			arrlst_for_sess.add((String) strtk1recc.nextElement() );

			Stringtk1recc=(String) strtk1recc.nextElement();

			strtk1recc=new java.util.StringTokenizer(Stringtk1recc," - ");
			arrlst_for_sess.add((String) strtk1recc.nextElement() );
			arrlst_for_sess.add((String) strtk1recc.nextElement() );
			arrlst_for_sess.add((String) strtk1recc.nextElement() );
		}
	}

%>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="recur_day_results" id="recur_day_results" method="post">

<%try{
	conn = ConnectionManager.getConnection(request);


	str1.append("select to_char(clinic_date,'dd/mm/yyyy') dt,to_char(clinic_date,'Day') dy ,to_char(clinic_date,'W') wm ,");
	
	if(time_table_type.equals("1"))
	{
		str1.append("max_slots_per_day max_slots,");
	}else{
		str1.append("max_patients_per_day max_slots,");
	}
	
		
	//str1.append("nvl(max_first_visits,0) max_first,nvl(max_other_visits,0) max_other,nvl(total_first_visit_slots_booked,0) first_booked,nvl(total_follow_up,0) + nvl(total_routine,0) +nvl(total_series,0) +nvl(total_consult,0) + nvl(Total_emergency,0) other_booked  from oa_clinic_schedule where care_locn_type_ind='"+care_locn_ind+"' and resource_class='"+res_class+"' and clinic_code='"+Clinic_Code+"' and nvl(practitioner_id,'x')=nvl('"+Practitioner_id+"','x') and facility_id='"+facilityid+"' and clinic_date between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"','dd/mm/yyyy') and time_table_type='"+time_table_type+"' and nvl(schedule_status,'x') =nvl('','x')  ") ; commented as part of tuning
	str1.append("nvl(max_first_visits,0) max_first,nvl(max_other_visits,0) max_other,nvl(total_first_visit_slots_booked,0) first_booked,nvl(total_follow_up,0) + nvl(total_routine,0) +nvl(total_series,0) +nvl(total_consult,0) + nvl(Total_emergency,0) other_booked  from oa_clinic_schedule where care_locn_type_ind='"+care_locn_ind+"' and resource_class='"+res_class+"' and clinic_code='"+Clinic_Code+"' and facility_id='"+facilityid+"' and clinic_date between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"','dd/mm/yyyy') and time_table_type='"+time_table_type+"' and schedule_status is null ") ;
	if(Practitioner_id.equals("")){
		str1.append(" and practitioner_id  is null ");
	}else{
		str1.append(" and practitioner_id='"+Practitioner_id+"' ");
	}
	


	if(rec_type.equals("2"))
	{
		str1.append("and to_char(clinic_date,'D') in ("+week_day+") ");
	}else if(rec_type.equals("3")){
	}else if(rec_type.equals("4")){
	}else if(rec_type.equals("5")){
	}

	stmt=conn.createStatement();	
	rs=null;
	str1.append("order by clinic_date ");
	rs=stmt.executeQuery(str1.toString());


	str1.setLength(0);

	if(rs!=null)
	{

		while(rs.next())
		{
			arrlst.add(rs.getString("dt"));
			arrlst.add(rs.getString("dy"));
			arrlst.add(rs.getString("wm"));
			arrlst.add(rs.getString("max_slots"));
			arrlst.add(rs.getString("max_first"));
			arrlst.add(rs.getString("first_booked"));
			arrlst.add(rs.getString("max_other"));
			arrlst.add(rs.getString("other_booked"));			
			
		}

	}

	if(arrlst.size()>0){%>
		<table  cellpadding="0" cellspacing="0" width="100%" valign='top' border='1'>
		
		<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="eOA.TimeDuration.label" bundle="${oa_labels}"/></td>

		<%
		int ij=0;	
		for (int i=0;i<arrlst.size();i+=8){
			String dtVal=(String) arrlst.get(i);
			String day_val=(String) arrlst.get(i+1);
			int max_slots=Integer.parseInt((String) arrlst.get(i+3));
			int max_first=Integer.parseInt((String) arrlst.get(i+4));
			int max_other=Integer.parseInt((String) arrlst.get(i+6));
			int first_bkd=Integer.parseInt((String) arrlst.get(i+5));
			int other_bkd=Integer.parseInt((String) arrlst.get(i+7));

			String disp_flag="N";

			if(VisitTypeCD.equals("F")){
				if(max_first==0){
					if(max_slots > (first_bkd+other_bkd)){
						disp_flag="Y";
					}else{
						disp_flag="N";
					}
				}else{
					if(first_bkd<max_first){
						disp_flag="Y";
					}else{
						disp_flag="N";
					}
				}
			}else{
				if(max_other==0){
					if(max_slots > (first_bkd+other_bkd)){
						disp_flag="Y";
					}else{
						disp_flag="N";
					}
				}else{
					if(other_bkd<max_other){
						disp_flag="Y";
					}else{
						disp_flag="N";
					}
				}
			}
			if(disp_flag.equals("Y")){

				if ( ij % 2 == 0 )
					classValue = "OAQRYEVEN" ;
				else
					classValue = "OAQRYODD" ;

			String date_val_display =DateUtils.convertDate(dtVal,"DMY","en",locale);


			String day_val_display ="";
			day_val=day_val.trim();
			if(day_val.equals("Sunday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day_val.equals("Monday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day_val.equals("Tuesday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day_val.equals("Wednesday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day_val.equals("Thursday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day_val.equals("Friday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day_val.equals("Saturday"))
		{
			day_val_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}

	%>
				<tr>
				<td class="<%=classValue%>" >
					<a href="javascript:onclick=open_details('<%=dtVal%>','<%=ij%>')">
					<%=date_val_display%>
					</a>
					</td>
				<td class="<%=classValue%>" ><%=day_val_display%></td>

				<%
			//	out.println("str21 :");
				//str2="select nvl(schedule_status,'N') status from oa_clinic_schedule_slot_slab where clinic_code='"+Clinic_Code+"' and facility_id= '"+facilityid+"' and nvl(practitioner_id,'x')=nvl('"+Practitioner_id+"','x') and trunc(clinic_date)=to_date('"+dtVal+"','dd/mm/yyyy') and resource_class='"+res_class+"' and to_date(to_char(SLOT_SLAB_START_TIME,'HH24:mi'),'HH24:mi') 				<=to_date('"+From_time+"','HH24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'HH24:mi'),'HH24:mi') 				>=to_date('"+To_time+"','HH24:mi')  order by slot_slab_start_time,srl_no";//commented as part of Tuning
				str2=str2.append("select nvl(schedule_status,'N') status from oa_clinic_schedule_slot_slab where clinic_code='"+Clinic_Code+"' and facility_id= '"+facilityid+"' and clinic_date=to_date('"+dtVal+"','dd/mm/yyyy') and resource_class='"+res_class+"' and to_date(to_char(SLOT_SLAB_START_TIME,'HH24:mi'),'HH24:mi') 				<=to_date('"+From_time+"','HH24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'HH24:mi'),'HH24:mi') 				>=to_date('"+To_time+"','HH24:mi')");
				if(Practitioner_id.equals("")){
					str2.append(" and practitioner_id  is null ");
				}else{
					str2.append(" and practitioner_id='"+Practitioner_id+"' ");
				}
				str2.append("   order by slot_slab_start_time,srl_no ");						
				rs2_oa=stmt.executeQuery(str2.toString());
				str2.setLength(0);
                //comment for ML-BRU-SCF-0428 [IN:035167]
				/*if(rs2_oa !=null && rs2_oa.next())
				{
						status=rs2_oa.getString("status");
				}else
				{
					status="BR";
				}*/
				//Maheshwaran K added for the Incident No:ML-BRU-SCF-0428 [IN:035167]  as on 12/11/2012
				status="";
				checked="";
				//End 035167
                    // Added for ML-BRU-SCF-0428 [IN:035167]
				while(rs2_oa !=null && rs2_oa.next()){
					status=rs2_oa.getString("status");
					if(status.equals("N")){
						break;
					} //end 35167
				}


				if(rs2_oa !=null)rs2_oa.close();
					if(status.equals("N"))
					{
						disabled="";
						checked="checked";	
					
					}else if(status.equals("1"))
					{
						disabled="disabled";
						checked="";	
					}else if(status.equals("B"))
					{
						disabled="disabled";
						checked="";
					}else if(status.equals("X"))
					{
						disabled="disabled";
						checked="";
					}
					else
					{
						disabled="disabled";
						//comment="Time slot not available for the schedule";
					}%>
				
				<%
				int pos=0;
				String sts="";
				String sts1="";
				String sts2="";
				String sts3="";
				if(arrlst_for_sess.size()>0){
					pos=(ij*4)+0;
					sts=(String)arrlst_for_sess.get(pos);
					sts1=(String)arrlst_for_sess.get(pos+1);
					sts2=(String)arrlst_for_sess.get(pos+2);
					sts3=(String)arrlst_for_sess.get(pos+3);

					if(sts.equals("N")){
						if(sts1.equals("C")){
							disabled="disabled";
						}else{
							disabled="";
							
						}

						checked="";
					}else{
						disabled="";
						checked="checked";
						//comment="";
						From_time=sts1;
						To_time=sts2;
						no_of_slots=sts3;
					}


					%>
					<td class="<%=classValue%>" ><input type="checkbox" name="chk" id="chk" <%=disabled%> <%=checked%>></td>
					<td  class="<%=classValue%>" >
					<%if(status.equals("N")){%>
						<font id="inhrtml"><%=From_time%> - <%=To_time%></font>
							<input type="hidden" name="hddTime" id="hddTime" value="<%=From_time%> - <%=To_time%> - <%=no_of_slots%>">
					<%}else if(status.equals("1")){%>
							<input type="hidden" name="hddTime" id="hddTime" value="">
							<font id="inhrtml"><fmt:message key="eOA.AppointmentExists.label" bundle="${oa_labels}"/></font>
					<%}else if(status.equals("B")){ %>
							<input type="hidden" name="hddTime" id="hddTime" value="">
							<font id="inhrtml"><fmt:message key="eOA.BlockExists.label" bundle="${oa_labels}"/></font>
					<%}else if(status.equals("X")){ %>
							<input type="hidden" name="hddTime" id="hddTime" value="">
							<font id="inhrtml"><fmt:message key="eOA.ScheduleBreakExists.label" bundle="${oa_labels}"/></font>
					<%}%>

							<input type="hidden" name="hddDT" id="hddDT" value="<%=dtVal%>">
						
					</td>
				<%}else{%>

					<td class="<%=classValue%>" ><input type="checkbox" name="chk" id="chk" <%=disabled%> <%=checked%>></td>
					<td  class="<%=classValue%>" >
						<%if(status.equals("N")){%>
						<font id="inhrtml"><%=From_time%> - <%=To_time%></font>
							<input type="hidden" name="hddTime" id="hddTime" value="<%=From_time%> - <%=To_time%> - <%=no_of_slots%>">
					<%}else if(status.equals("1")){%>
							<input type="hidden" name="hddTime" id="hddTime"  value="">
							<font id="inhrtml"><fmt:message key="eOA.AppointmentExists.label" bundle="${oa_labels}"/></font>
					<%}else if(status.equals("B")){ %>
							<input type="hidden" name="hddTime" id="hddTime" value="">
							<font id="inhrtml"><fmt:message key="eOA.BlockExists.label" bundle="${oa_labels}"/></font>
					<%}else if(status.equals("X")){ %>
							<input type="hidden" name="hddTime" id="hddTime" value="">
							<font id="inhrtml"><fmt:message key="eOA.ScheduleBreakExists.label" bundle="${oa_labels}"/></font>
					<%}%>
							<input type="hidden" name="hddDT" id="hddDT" value="<%=dtVal%>">
						
					</td>
				<%}%>
				</tr>
		<%	ij++;
			}
		}%>
		</table>

				<script>
					parent.f_query_add_mod.document.forms[0].AcceptDates.disabled=false;
				</script>
	<%}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"))
			parent.f_query_add_mod.document.forms[0].AcceptDates.disabled=true;
			</script>		
	<%}
	

	if (rs!=null) rs.close();
	if (rs1!=null) rs1.close();
	if (rs2!=null) rs2.close();
	if (rs3!=null) rs3.close();
	if (rs4!=null) rs4.close();
	if (rs2_oa !=null) rs2_oa.close();
	if (stmt!=null) stmt.close();
	if (pstmt!=null) pstmt.close();
	arrlst.clear();
	arrlst_for_sess.clear();
}catch(Exception ex){
	ex.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	//out.println("exception is "+ ex);

}finally
{
	 ConnectionManager.returnConnection(conn,request);
}
%>
<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="<%=Clinic_Code%>">
<input type="hidden" name="Practitioner_id" id="Practitioner_id" value="<%=Practitioner_id%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name ="care_locn_ind" value="<%=care_locn_ind%>">
<input type="hidden" name ="res_class" value="<%=res_class%>">

</form>
</body>
</html>

