<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

request.setCharacterEncoding("UTF-8"); 
Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;
String calling_object = "";

String facility_id		= (String)session.getValue("facility_id");
String calling_from	= request.getParameter("calling_from");
	if(calling_from==null) calling_from="";

calling_object	= request.getParameter("object_name");

String param_val		= request.getParameter("object_val");
String other_code		= request.getParameter("other_code");
	if(other_code==null)	other_code="";
String room_no	= request.getParameter("room_no");
	if(room_no==null) room_no="";
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class='message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
try
{

	con = ConnectionManager.getConnection(request);

	if(calling_object.equals("nursing_unit") || calling_from.equals("MAINBED") )
	{
		String sql_gender	  ="select gender from am_age_group where  age_group_code=(select age_group_code from ip_nursing_unit where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"') order by 1 ";
		String gender="";

		String sql_room	="select room_no from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' and eff_status='E' order by 1 ";

		String appl_patient_class="";
		

		String  pateint_class="SELECT appl_patient_class  FROM ip_nursing_unit  WHERE facility_id = '"+facility_id+"' AND nursing_unit_code = '"+param_val+"' AND eff_status = 'E'";
		try{
			stmt= con.createStatement();
			if(rs!=null) rs=null;
			rs	= stmt.executeQuery(pateint_class);
			if(rs!=null)
			{
				while(rs.next())
				{
						appl_patient_class=rs.getString(1);
				}

			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(appl_patient_class.equals("DC"))
			{

	 sql_room="SELECT room_no   FROM ip_nursing_unit_room  WHERE nursing_unit_code = '"+param_val+"'     AND (facility_id, room_no) IN ( SELECT facility_id, practitioner_id FROM op_pract_for_clinic a  WHERE clinic_code IN (SELECT clinic_code       FROM ip_dc_unit_for_nurs_unit  WHERE facility_id =  '"+facility_id+"'  AND nursing_unit_code = '"+param_val+"')   AND a.facility_id =  '"+facility_id+"'    AND a.resource_class = 'R' AND a.eff_status = 'E') ";

		}
	

		String sql_speciality	="select specialty_code, specialty_short_desc from ip_nurs_unit_for_specialty_vw where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' order by specialty_short_desc";
		
		String new_born_yn = "N";
		String sql_New_Born = "select ALLOW_NEW_BORN_REGN_YN from IP_NURSING_UNIT where NURSING_UNIT_CODE = '"+param_val+"' and facility_id='"+facility_id+"' ";

	if(calling_object.equals("nursing_unit"))	
	{
		String sql_bed_class ="select bed_class_code, short_desc from ip_bed_class where eff_status='E' order by short_desc";
											
		try
		{
			stmt= con.createStatement();
			if(rs!=null) rs=null;
			rs	= stmt.executeQuery(sql_bed_class);
	
			
			if(rs!=null)
			{
			%>
				<script>
					var selected = parent.frames[1].document.forms[0].bed_class;
					while ( selected.options.length > 0 )
						selected.remove(selected.options[0]);
					var opt=document.createElement("Option");
					opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
					opt.value="";
					parent.frames[1].document.forms[0].bed_class.add(opt);
				</script>
			<%
				while(rs.next())
				{	%>
					<script>
					var obj=parent.frames[1].document.forms[0].bed_class
					var element=parent.frames[1].document.createElement("option");
					element.text="<%=rs.getString(2)%>"
					element.value="<%=rs.getString(1)%>"
					obj.add(element)
					</script>
			<%	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}
		}

	try
	{
		stmt= con.createStatement();
		rs	= stmt.executeQuery(sql_New_Born);
		if(rs!=null)
		{
			while(rs.next())
			{
				new_born_yn = rs.getString("ALLOW_NEW_BORN_REGN_YN");
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		if(new_born_yn.equals("Y"))
		{
		%>	
			<script>
			var mainBedNo = parent.frames[1].document.forms[0].main_bed_no
			if(mainBedNo)
			{
				parent.frames[1].document.forms[0].main_bed_no.disabled = false;
				parent.frames[1].document.forms[0].search_bed.disabled	= false;
			}
			</script>
		<%
		}
		else if(new_born_yn.equals("N"))
		{
		%>	
			<script>
			if(parent.frames[1].document.forms[0].main_bed_no)
			{
				parent.frames[1].document.forms[0].main_bed_no.disabled = true;
				parent.frames[1].document.forms[0].search_bed.disabled	= true;
			}
			</script>
		<%	
		}
	}catch(Exception e)
	{
		out.print("New Born : "+e);
	}


		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_gender);
			if(rs!=null)
			{
				if(rs.next())
				{
					gender=rs.getString(1);
					if(gender!=null)
					{
						if(gender.equals("M") || gender.equals("F") || gender.equals("U"))
						{	%>
							<script>
								var gender_object=parent.f_query_add_mod.Nursing_Unit_Bed.gender_specific_ind
								for(var i=0;i<gender_object.options.length;i++)
								{
									if(gender_object.options[i].value == '<%=gender%>')
									{
										if(parent.f_query_add_mod.document.forms[0].gender_specific_ind_code.value!=gender_object.value)
											parent.f_query_add_mod.forms[0].gender_specific_ind_code.value=gender_object.value
										if(gender_object.value=="")
											gender_object.options[i].selected=true
										gender_object.disabled=true;
										break;
									}
								}
								</script>
							<%
						}
					}
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print("gender:"+e);					
		}

		/* ROOM population */
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_room);
			
			if(calling_from.equals("MAINBED"))
			{
				if(rs!=null)
				{
					while(rs.next())
					{	%>
						<script>
						var obj = parent.f_query_add_mod.document.Nursing_Unit_Bed.room
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(1)%>";
						element.value="<%=rs.getString(1)%>";
						if(parent.f_query_add_mod.document.Nursing_Unit_Bed.hdd_room.value == '<%=rs.getString(1)%>')
						{	
							element.selected = true;
							obj.disabled = true;
						}
							obj.add(element)
						</script>
				<%	}
				}
				
			}
			else
			{
				if(rs!=null)
				{
					while(rs.next())
					{	%>
						<script>
						var obj = parent.f_query_add_mod.document.Nursing_Unit_Bed.room
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(1)%>";
						element.value="<%=rs.getString(1)%>";
						if("<%=room_no%>"=="<%=rs.getString(1)%>")
						element.selected=true;
						obj.add(element)
						</script>
						<%
					}
				}
			}
			if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();

		}
		catch(Exception e)
		{
			out.print("room:"+e);
		}

	if(calling_from.equals("MAINBED"))
	{
		/// Added on 15 SEP 2004 by SRIDHAR R ...
		/// **** BED CLASS ******
		String bed_class_sql = "select short_desc, bed_class_code from ip_bed_class where eff_status='E' order by short_desc";
											
		try
		{
			stmt= con.createStatement();
			rs	= stmt.executeQuery(bed_class_sql);
			
			if(rs!=null)
			{
				while(rs.next())
				{	%>
					<script>
					var obj=		parent.f_query_add_mod.document.Nursing_Unit_Bed.bed_class
					var element=parent.f_query_add_mod.document.createElement("option");
					element.text="<%=rs.getString(1)%>"
					element.value="<%=rs.getString(2)%>"
					if(parent.f_query_add_mod.document.forms[0].hdd_bed_class.value=="<%=rs.getString(2)%>")
					{	
						element.selected = true;
						obj.disabled = true;
					}
						obj.add(element)
					</script>
			<%	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}

		/// Added on 15 SEP 2004 by SRIDHAR R ...
		// BED TYPE 	
		String bed_class_code	= request.getParameter("bed_class_code");
			if(bed_class_code == null) bed_class_code = "";

		String sql_bed_type	="select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+bed_class_code+"' and eff_status='E' order by short_desc";
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_bed_type);
			if(rs!=null)
			{
				while(rs.next())
				{	%>
					<script>
						var obj=		parent.f_query_add_mod.document.Nursing_Unit_Bed.bed_type
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(1)%>"
						element.value="<%=rs.getString(2)%>"
						if(parent.f_query_add_mod.document.forms[0].hdd_bed_type.value=="<%=rs.getString(2)%>")
						{	
							element.selected = true;
							obj.disabled = true;
						}
						obj.add(element)
					</script>
			<%	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	}
		/// Added on 15 SEP 2004 by SRIDHAR R ...
		// SPECIALTY 
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_speciality);
			
			if(calling_from.equals("MAINBED"))
			{
				if(rs!=null)
				{
					while(rs.next())
					{	%>
						<script>
						var obj=		parent.f_query_add_mod.document.Nursing_Unit_Bed.speciality
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(2)%>"
						element.value="<%=rs.getString(1)%>"
						if(parent.f_query_add_mod.document.Nursing_Unit_Bed.hdd_speciality_code.value == "<%=rs.getString(1)%>")
						{	
							element.selected = true;
						}
						obj.disabled = true;
						obj.add(element)

						</script>
				<%	}
				}
				
			}
			else
			{
				if(rs!=null)
				{
					while(rs.next())
					{	%>
						<script>
						var obj=		parent.f_query_add_mod.document.Nursing_Unit_Bed.speciality
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(2)%>"
						element.value="<%=rs.getString(1)%>"
						if("<%=other_code%>"=="<%=rs.getString(1)%>")
							element.selected=true;
						obj.add(element)
						</script>
				<%	}
				}
			}
			if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}

		/// Added on 15 SEP 2004 by SRIDHAR R for Main Bed No...
		/// If New_Born indicator is 'Y' in ip_nursing_unit table for that nursing_unit then, Main Bed No can be entered...else disabled
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)		rs.close();
		}
	} //end of calling_object.equals("nursing_unit")
	else if(calling_object.equals("bed_class"))
	{
		String sql_bed_type	="select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+param_val+"' and eff_status='E' order by short_desc";
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_bed_type);
			if(rs!=null)
			{
				while(rs.next())
				{
					%>
					<script>
						var obj=		parent.f_query_add_mod.document.Nursing_Unit_Bed.bed_type
						var element=parent.f_query_add_mod.document.createElement("option");
						element.text="<%=rs.getString(1)%>"
						element.value="<%=rs.getString(2)%>"

						if("<%=other_code%>"=="<%=rs.getString(2)%>")
							element.selected=true;
						obj.add(element)
					</script>
					<%
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print("Error : "+e);
		}
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	} // end of if calling_object.equals("bed_class")
}catch(Exception e)
{
	out.println("<script>alert('Error in intermediate page')</script>");
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>
<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

