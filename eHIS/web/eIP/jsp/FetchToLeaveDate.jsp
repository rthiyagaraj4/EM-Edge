<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*" %>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script language="JavaScript">
	async function showPseudoBed(nursingunit)
	{
		var features	= "dialogHeight:18.5; dialogWidth:40; dialogTop:185;scroll=auto; status:no;"
		var arguments = "";
		var retVal = await parent.window.showModalDialog("../../eIP/jsp/PseudoBedAvailabilityChart.jsp?nursing_unit_code="+nursingunit,arguments,features);
		if(retVal != null && retVal != 'F')
		{
			parent.frames[1].document.getElementById('pseudo_bed').value = retVal;
		}
		else 
		{
			parent.frames[1].document.getElementById('pseudo_bed').value="";
			parent.frames[1].document.getElementById('release_bed').value="N";
			parent.frames[1].document.getElementById('release_bed').checked=false;
		}
	}

	function showCreatePseudobed(nursingunit,nursingunitdesc)
	{
		parent.frames[1].document.getElementById('pseudo_bed').readOnly = true;
		parent.frames[1].document.getElementById('generate_pseudo_bed').value = 'Y';
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
   Connection con = null;
   Statement stmt =  null;
   ResultSet rs=null;
   String facilityid  = "";
   String currdate    = "";
   int 	  leaveperiod = 0;
   String leaveind    = "";
   int    maxleave    = 0;
   
	try
	{
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

		con  = ConnectionManager.getConnection(request);
		stmt = con.createStatement();	 
		String to_date   = "";	
		currdate    = request.getParameter("currdate");
		leaveperiod = Integer.parseInt((request.getParameter("leaveperiod")==null?"0":request.getParameter("leaveperiod")));
		leaveind    = request.getParameter("leaveind");   
		maxleave = Integer.parseInt((request.getParameter("maxleave")==null?"0":request.getParameter("maxleave")));
		facilityid  = (String)session.getValue("facility_id");
		String operation = request.getParameter("operation") ;

		if(operation == null)
		{
			try
			{
				String LeaveSql = "SELECT  to_char((to_date('"+currdate+"','dd/mm/rrrr hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24)),'dd/mm/rrrr hh24:mi') to_date, to_date('"+currdate+"','dd/mm/rrrr hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24) act_dt  from dual";

				boolean chk = true ;
				stmt=con.createStatement();
				rs = stmt.executeQuery(LeaveSql);    
				rs.next();

				to_date = rs.getString("to_date");	
				Timestamp ts = rs.getTimestamp("act_dt") ;

				Timestamp currdate1 = new Timestamp(System.currentTimeMillis());
				out.println(ts+"\n"+currdate1+"\n"+ts.before(currdate1) +"\n");
				if(to_date == null ) to_date = "";		
				else if(ts.before(currdate1))
				chk=false;

				%>
				<script>
				parent.frames[1].document.getElementById('to_date1').innerText = "<%=to_date%>";
				parent.frames[1].document.forms[0].to_date.value = "<%=to_date%>";

				if (!<%=chk%> && !parent.frames[1].document.forms[0].leaveperiod.readOnly)
				{
					alert(getMessage("INVALID_LEAVE_REVISE","IP"));
				}
				</script>
				<%
				//Valid Leave Check
				if(leaveind.equals("D"))
				{     
					if ((maxleave / 24) < leaveperiod) 
					{
						out.println("<script>alert(getMessage('LEAVE_LT_DAYS_XCEED','IP'));</script>");
						out.println("<script>parent.frames[1].document.forms[0].leaveperiod.focus();</script>");
					} 
				}	
				else
				{
					if (maxleave < leaveperiod) 
					{
					out.println("<script>alert(getMessage('LEAVE_LT_HRS_XCEED','IP'));</script>");	 
					out.println("<script>parent.frames[1].document.forms[0].leaveperiod.select();</script>");
					} 
				}
				if (stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			}catch(Exception e){out.println("error " + e);}
			finally
			{
				if (stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			}
		}
		else if(operation.equals("pseudo_bed"))
		{
			String nursing_unit	 = request.getParameter("nursing_unit_code");
			String sql = " Select allow_pseudo_bed_yn, generate_pseudo_bed_srl_yn, nursing_unit_short_desc from IP_NURSING_UNIT_LANG_VW where language_id='"+locale+"' and Nursing_Unit_Code= '"+nursing_unit+"' and facility_id = '"+facilityid+"'";
			String genpseudobedno="";
			try
			{
				stmt = con.createStatement();
				Statement stmt2 = con.createStatement();
				rs	= stmt.executeQuery(sql);
				if(rs.next())
				{
				String allow_pseudo_bed_yn = rs.getString("Allow_Pseudo_Bed_YN")==null?"N":rs.getString("Allow_Pseudo_Bed_YN");
				String nursingunitdesc = rs.getString("NURSING_UNIT_SHORT_DESC");
				if(allow_pseudo_bed_yn.equals("N"))
				{
					out.println("<script>parent.frames[1].document.getElementById('release_bed').disabled=true;alert(getMessage('NU_PSEUDO_BED_NOT_ALLOWED','IP'));parent.frames[1].document.getElementById('release_bed').checked=false;parent.frames[1].document.getElementById('release_bed').value='N'</script>");
				}
				else
				{
					if(rs.getString("Generate_Pseudo_Bed_Srl_YN").equals("Y"))
					{
						String selectnosql = " SELECT PREFIX_FOR_PSEUDO_BED_SRL_NO,NVL(NEXT_PSEUDO_BED_SRL,0) NEXT_PSEUDO_BED_SRL ,NVL(MAX_PSEUDO_BED_SRL,0) MAX_PSEUDO_BED_SRL FROM IP_NURSING_UNIT WHERE NURSING_UNIT_CODE = '"+nursing_unit+"' and facility_id='"+facilityid+"' " ;
						if(stmt2 != null) stmt2.close();
						stmt2 = con.createStatement();
						ResultSet rset = stmt2.executeQuery(selectnosql);
						if(rset.next())
						{
							if(rset.getInt("NEXT_PSEUDO_BED_SRL") > rset.getInt("MAX_PSEUDO_BED_SRL"))
							{
								out.println("<script>alert(getMessage('MAX_BED_NUM_REACHED','IP'));</script>");
							}
							else
							{
								String PREFIX_FOR_PSEUDO_BED_SRL_NO = rset.getString("PREFIX_FOR_PSEUDO_BED_SRL_NO");
								String NEXT_PSEUDO_BED_SRL = rset.getString("NEXT_PSEUDO_BED_SRL");

								if(PREFIX_FOR_PSEUDO_BED_SRL_NO == null || PREFIX_FOR_PSEUDO_BED_SRL_NO.equals("null"))PREFIX_FOR_PSEUDO_BED_SRL_NO="";
								if(NEXT_PSEUDO_BED_SRL == null || NEXT_PSEUDO_BED_SRL.equals("null"))NEXT_PSEUDO_BED_SRL="";

								if(!PREFIX_FOR_PSEUDO_BED_SRL_NO.equals(""))
								{
									genpseudobedno = PREFIX_FOR_PSEUDO_BED_SRL_NO+NEXT_PSEUDO_BED_SRL;
									out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value=\""+genpseudobedno+"\"</script>");
								}
								else
								{
									genpseudobedno = NEXT_PSEUDO_BED_SRL;
								out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value=\""+genpseudobedno+"\"</script>");
								}
							}
						}	
						if(rset != null) rset.close();
						if(stmt2 != null) stmt2.close();
						out.println("<script>showCreatePseudobed('"+nursing_unit+"','"+nursingunitdesc+"')</script>");
					}
					else
					{
					out.println("<script>showPseudoBed('"+nursing_unit+"')</script>");
					}
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			}
			catch(Exception e)
			{
				out.println(e.toString());
			}
			finally
			{
				if(stmt!=null)	stmt.close();
				if(rs!=null)	rs.close();			
			}
		}
		else
		{
		String occupaid_pat_id="";
		String override_yn="";
		String patient_id_value="";
		String nursing_unit	 = request.getParameter("nursing_unit_code");
		String bed_no			 = request.getParameter("bed_no");
		String patient_id=request.getParameter("patient_id");
		String sql = "select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','1') bed_class_long_desc, bed_class_code,bed_type_code, OCCUPYING_PATIENT_ID from ip_nursing_unit_bed where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and facility_id='"+facilityid+"'";
		try
		{
		stmt = con.createStatement();
		rs	= stmt.executeQuery(sql);
		if(rs!=null)
		{
		if(rs.next())
		{
		String room_no= rs.getString(1);
		String bed_class = rs.getString(2);
		String bed_class_code=rs.getString(3);
		String bed_type_code=rs.getString(4);
		occupaid_pat_id=rs.getString("OCCUPYING_PATIENT_ID");
		if(room_no==null) room_no="";
		if(bed_class==null) bed_class="";
		if(bed_class_code==null) bed_class_code="";
		if(rs!=null)	rs.close();
		%>		<script>
		var obj= parent.frames[1].document.forms[0];
		obj.Bedcode.value = "<%=bed_class_code%>";
		obj.bed_cls_code.value="<%=bed_class_code%>";
		obj.bed_type_code.value = "<%=bed_type_code%>";
		obj.bed_typ_code.value = "<%=bed_type_code%>";
		</script>
		<%	}
		else
		{	%>
		<script>
		alert(getMessage('INVALID_BED','IP'));
		var obj= parent.frames[1].document.forms[0];
		obj.bed_cls_code.value = '';
		obj.bed_type_code.value = '';
		obj.room_no.value = '';
		obj.disp_room_no.value = '';
		if(obj.bed_chart.disabled == false)
		obj.bed_chart.focus();
		</script>
		<%
		}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(occupaid_pat_id.equals(patient_id))
		{
		stmt=con.createStatement();
		sql = " SELECT OVERRIDE_YN,PATIENT_ID FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE='"+nursing_unit+"' and REQ_BED_NO='"+bed_no+"' and facility_id='"+facilityid+"'";
		rs	= stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
		override_yn=rs.getString("OVERRIDE_YN");
		patient_id_value=rs.getString("PATIENT_ID");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(override_yn.equals("N"))
		{
		if(patient_id.equals(patient_id_value))
		{%>
		<script>
		alert(getMessage('NON_OVERRIDEABLE_BKG','IP'));
		var obj= parent.frames[1].document.forms[0]
		obj.bed_no.disabled=false;
		obj.bed_chart.disabled=false;
		</script>
		<%}%>
		<%}
		else
		{
		stmt=con.createStatement();
		sql = " SELECT 1 FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE='"+nursing_unit+"' and REQ_BED_NO='"+bed_no+"' and facility_id='"+facilityid+"'";
		rs	= stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
		%>
		<script>
		alert(getMessage('INVALID_BED','IP'));
		var obj= parent.frames[1].document.forms[0];
		obj.bed_cls_code.value = '';
		obj.bed_type_code.value = '';
		obj.room_no.value = '';
		obj.disp_room_no.value = '';
		if(obj.bed_chart.disabled == false)
		obj.bed_chart.focus();
		
		</script>
		<%
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		}
		}
		else
		{%>
		<script>
		alert(getMessage('OCCUPIED_BED','IP'));
		var obj= parent.frames[1].document.forms[0]
		obj.bed_no.disabled=false;
		obj.bed_no.readOnly=false;
		obj.bed_chart.disabled=false;
		obj.Bedcode.disabled=false;
		obj.bed_type_code.disabled=false;
		obj.bed_chart.disabled=false;
		</script>
		<%}


		}
		catch(Exception e)
		{
		out.println(e.toString());
		}
		finally
		{
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();			
		}
		}
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
   finally
   {
   	ConnectionManager.returnConnection(con,request);
   }	
%>
</html>

