<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	String incdec = request.getParameter("inc_dec")==null?"":request.getParameter("inc_dec");
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript">
			function validateSlots(obj,rownum)
			{
				if(obj.value == '') obj.value=0;

				if(CheckNum(obj))
				{
					if('<%=incdec%>' == 'Decreased')
					{
						var a = eval("document.getElementById("block_slot")"+rownum+".value");
						var arr = a.split("`");
						totalslots = arr[0];
						if(eval(obj.value)>totalslots)
						{
							alert("<%=incdec%> Slots must be lesser than or equal to (Max Patients - Total Booked Patients )");
							obj.focus();
						}
					}
				}
			}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String facilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
        String sql="";
		String locncode =request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String practitionerid = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
		String clinicdate = request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
		String alcncriteria = request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String allocation_changed = request.getParameter("allocation_changed")==null?"":request.getParameter("allocation_changed");
		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");
		String max_patients_per_day = request.getParameter("max_patients_per_day")==null?"":request.getParameter("max_patients_per_day");
		String alcncriteriadesc = "";
		if(alcncriteria.equals("NG"))
			alcncriteriadesc = "Nationality Group";
		else if(alcncriteria.equals("BG"))
			alcncriteriadesc = "Billing Group";
		String slotsincdec = request.getParameter("slots_inc_dec")==null?"&nbsp;":request.getParameter("slots_inc_dec");
		Connection con = null ;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String className = "";
		String readOnly = "";
		int i =0;
%>
<body onLoad="document.getElementById("h").verticalAlign='middle'" OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
<form name="BlockApptAllocationDetails_form" id="BlockApptAllocationDetails_form">
	<table align=right cellpadding=0 cellspacing=0 width="98%" border=1>
		<tr>
			<td colspan=4 class=DATA>
				<h5 id=h style="vertical-align: middle">Slots to be <%=incdec%>= <%=slotsincdec%></h5>
				<input type="hidden" value="<%=slotsincdec%>" name=slots_inc_dec>
			</td>
		</tr>
		<tr>
			<th><%=alcncriteriadesc%></th>
			<th>Max Patients</th>
			<th>Total Booked Patients</th>
			<!-- <th>Slots Blocked</th> -->
			<th><%=incdec%> Slots</th>
		</tr>
		<%		
			
			if(alcncriteria.equals("NG"))
			{
				//sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
			}
			else if(alcncriteria.equals("BG"))
			{
				//sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
				sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
			}
			else if(alcncriteria.equals("PC"))
			{
				//sql  = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
				sql  = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
			}
			int max_percen=0;
	        int total_booked	= 0;
			int total_blocked	= 0;
			
				try
				{
					con=ConnectionManager.getConnection(request);
				if (allocation_changed.equals("N"))
				  {
					//stmt =  con.createStatement();
					//rs = stmt.executeQuery(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,clinicdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
					{
						while(rs.next())
						{
							if(i%2 == 0 )
								className = "QRYEVEN";
							else
								className = "QRYODD";
							if(rs.getInt("final_slots") == 0 )
								readOnly = "readonly";
							else
								readOnly = "";

							String code = rs.getString("alcn_catg_code")==null?"":rs.getString("alcn_catg_code");
							String desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
							if(code.equals("*O")) desc = "Others";
							String passvalue = rs.getInt("final_slots")+"`"+alcncriteria+"`"+code+"`"+"$"+"`"+incdec+"`"+rs.getInt("total_booked_patients")+"`"+rs.getInt("total_blocked_slots")+"`";

							out.println("<tr><td class="+className+">"+desc+"</td>");
							out.println("<td  class="+className+">"+rs.getInt("max_patients")+"</td>");
							out.println("<td  class="+className+">"+rs.getInt("total_booked_patients")+"</td>");
							out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
							out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
							out.println("</tr>");
							i++;
						}
					}
				}
				else
				{
						StringTokenizer indtoken = new StringTokenizer(final_string, "|");
						while (indtoken.hasMoreTokens())
						{
						String inner_string = indtoken.nextToken();
						StringTokenizer stoken = new StringTokenizer(inner_string,"~");
						while(stoken.hasMoreTokens())
						{						
						if (i% 2 == 0 ) className = "QRYEVEN" ;
						else className = "QRYODD" ;
						String pat_category_code	= stoken.nextToken();
						String pat_category_desc	= stoken.nextToken();
						String percentage			= stoken.nextToken();
						int chk_percen				= Integer.parseInt(percentage);
				        total_booked			    = Integer.parseInt(stoken.nextToken());
						total_blocked			    = Integer.parseInt(stoken.nextToken());
						String passvalue = percentage+"`"+alcncriteria+"`"+pat_category_code+"`"+"$"+"`"+incdec+"`"+total_booked+"`"+total_blocked+"`";

						max_percen +=chk_percen;
						if (chk_percen <=total_booked) readOnly = "readonly";
						else
							readOnly ="";
						out.println("<tr><td class="+className+">"+pat_category_desc+"</td>");
						out.println("<td  class="+className+">"+chk_percen+"</td>");
						out.println("<td  class="+className+">"+total_booked+"</td>");
						out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
						out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
						out.println("</tr>");						
						i++;				                
						}                        
						}
                    int others = 0;
				    others = Integer.parseInt(max_patients_per_day) - max_percen;
					if  (others>0)
					{
				//	sql  = "select total_booked_patients,total_blocked_slots from oa_clinic_schedule_dtl where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|') and alcn_catg_code = '*O'";		
					sql  = "select total_booked_patients,total_blocked_slots from oa_clinic_schedule_dtl where facility_id=? and clinic_code=? and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl(?,'|') and alcn_catg_code = '*O'";		
					if (stmt!=null) stmt.close();
					if (pstmt!=null) pstmt.close();
					if (rs!=null) rs.close();
					//stmt =  con.createStatement();
					//rs = stmt.executeQuery(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,clinicdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
						{
						if (rs.next())
							{
						        total_booked			    = rs.getInt(1);
								total_blocked			    = rs.getInt(2);
							}
						 else
                            {
						        total_booked			    = 0;
								total_blocked			    = 0;
						 }
						}
						String passvalue = others+"`"+alcncriteria+"`"+"*O"+"`"+"$"+"`"+incdec+"`"+total_booked+"`"+total_blocked+"`";
						out.println("<tr><td class="+className+">"+"Others"+"</td>");
						out.println("<td  class="+className+">"+others+"</td>");
						out.println("<td  class="+className+">"+total_booked+"</td>");
						out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
						out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
						out.println("</tr>");					
						i++;				                
					}
				}
				}catch (Exception e){
					//out.println(e);
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally
				{
					if(stmt !=null) stmt.close();
					if(rs !=null) rs.close();
					ConnectionManager.returnConnection(con,request);
				}

		%>
	</table>
	<input type="hidden" value="<%=i%>" name="total_count">
	<input type="hidden" value="<%=incdec%>" name="inc_dec">
</form>
</body>
</html>

