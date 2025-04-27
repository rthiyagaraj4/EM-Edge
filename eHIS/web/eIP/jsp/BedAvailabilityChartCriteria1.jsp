<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<html>
	<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	Statement stmt_oper	= null;
	ResultSet rs_oper	= null;

	String facility_id			= (String)session.getValue("facility_id");
	String loginUser			= (String)session.getValue("login_user");
	String calledoption			= checkForNull(request.getParameter("calledoption"));
	//String bed_available_date_yn= checkForNull(request.getParameter("bed_available_date_yn"));
	String nursing_unit_code	= checkForNull(request.getParameter("nursing_unit"));
	String pracitioner_id		= checkForNull(request.getParameter("practid"));
	String speciality_code		= checkForNull(request.getParameter("Splcode"));
	String bed_class_code		= checkForNull(request.getParameter("Bedcode"));
	String gender				= checkForNull(request.getParameter("gender"));
	String age_value			= checkForNull(request.getParameter("age_value"));
	String age					= checkForNull(request.getParameter("age"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));
	String bed_type_code		= checkForNull(request.getParameter("bed_type_code"));
	String ipparam_bed_yn		= checkForNull(request.getParameter("ipparam_bed_yn"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String query_gender_type	= checkForNull(request.getParameter("query_gender_type"));
	String wherecondn			= checkForNull(request.getParameter("wherecondn"));
	//String bed_booking_ref_no	= checkForNull(request.getParameter("bed_booking_ref_no"));
		if(wherecondn.equals("")) wherecondn = "ADMIT_PAT_YN";

	StringBuffer sql			= new StringBuffer();
	String operstn				= "";

	try
	{
		con = ConnectionManager.getConnection(request);
		if(oper_stn_id == null || oper_stn_id.equals(""))
		{
			StringBuffer operSql = new StringBuffer();
			operSql.append("select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b  where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ");
			stmt_oper = con.createStatement();
			rs_oper = stmt_oper.executeQuery(operSql.toString());
			
			if (rs_oper.next())
			{
				operstn	 = checkForNull(rs_oper.getString("oper_stn_id"));
			}
			if (rs_oper != null) rs_oper.close();
			if (stmt_oper != null) stmt_oper.close();
		}
		else
		{
				operstn = oper_stn_id;
		}

		sql.append(" select a.nursing_unit_code, a.short_desc from ip_nursing_unit a, am_os_user_locn_access_vw b  ");
		sql.append(" where a.facility_id = '"+ facility_id +"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code "); 
		sql.append(" and a.locn_type=b.locn_type and b.locn_type = 'N' ");
		sql.append(" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "); 

		if(wherecondn.equals("CREATE_BOOKING_YN"))
			sql.append(" and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");
		else if(wherecondn.equals("ASSIGN_BED_YN"))
			sql.append(" and b.ASSIGN_BED_YN='Y' and a.appl_patient_class ='"+patient_class+"' ");
		else
			sql.append(" and b."+wherecondn+"='Y' ");
		
		sql.append(" and a.eff_status='E' ");

		if ( !nursing_unit_code. equals( "" ) )
			sql.append(" and nursing_unit_code = '"+ nursing_unit_code +"' ");

		if ( !pracitioner_id. equals("") )
		{
			sql.append(" and exists ( select '1' from ip_nursing_unit_for_pract b where facility_id = '"+facility_id+"'  ");
			sql.append(" and b.nursing_unit_code = a.nursing_unit_code and b.practitioner_id = '"+pracitioner_id +"'  ) ");
		}

		if ( !speciality_code. equals("") )
		{
			sql.append(" and exists ( select '1' from ip_nurs_unit_for_specialty c where c.facility_id = '"+facility_id+"'  ");
			sql.append(" and nursing_unit_code = a.nursing_unit_code and c.specialty_code = '"+speciality_code+"' ) ");
		}

		if ( (!bed_class_code. equals("")) ||(!bed_type_code.equals("")))
		{
			sql.append(" and exists(select '1' from ip_nursing_unit_bed d where d.facility_id = '"+facility_id+"' ");
			sql.append(" and d.nursing_unit_code = a.nursing_unit_code  ");
			if(!bed_class_code.equals(""))
			sql.append(" and d.bed_class_code = nvl( '"+bed_class_code+"', bed_class_code ) ");
			if(!bed_type_code.equals(""))
			{
			sql.append(" and d.bed_type_code = nvl( '"+bed_type_code+"', bed_type_code ) and rownum<2 ) ");
			} else{
  sql.append(" and rownum<2 ) ");

			}
		}

		if ( !gender. equals("") || !age_value. equals("") )
		{
			sql.append(" and  (( a.age_group_code is null ) or   ((a.age_group_code is not null ) and ");
			sql.append(" exists ( select age_group_code  from am_age_group  ");
			sql.append(" where age_group_code=a.age_group_code  ");

			if( !gender. equals("") )
			{
				sql.append(" and nvl( gender, '"+ gender +"' ) = '"+ gender +"' ");
			}

			if( !age_value. equals("") )
			{
				sql.append( " and decode('"+age+"' , 'Y', 365, 'M', 30, 1 ) * "+ age_value + "  ");
				sql.append( " between decode ( age_unit, 'Y', 365, 'M', 30, 1 ) * min_age and decode( age_unit, 'Y', 365, 'M', 30, 1 ) * max_age "); 
			}
			sql.append( " ))) ");
		}

		sql.append("  order by a.short_desc ");
	//	out.println("<script>alert(\""+sql+"\");</script>");
		stmt = con.createStatement();
		rs	= stmt.executeQuery(sql.toString());

	%>

		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<%	if(rs!=null)
		{
			int i=0;
			if(calledoption.equals("C"))
			i=1;
			i++;
			if( i>0 )
			{	%>
				<script>
				var params = "";
				frm = parent.criteria0.document.forms[0]
				var bed_list = true ; 
				if( frm.BedListinOrder1.value!="" &&  frm.BedListinOrder2.value!="" )
				{
					if ( frm.BedListinOrder1.value == frm.BedListinOrder2.value )
						bed_list = false
					else
					{
						if ( frm.BedListinOrder3.value!=""  )
						{
							if ( frm.BedListinOrder1.value == frm.BedListinOrder3.value )
							{
								bed_list = false
							}
							else
							{
								if( frm.BedListinOrder2.value == frm.BedListinOrder3.value )
								{
									bed_list = false;
								}
							}
						}
					}
				}

				if(bed_list)
				{
					for( var i=0; i<frm.elements.length; i++ )
						params += frm.elements[i]. name + "=" + escape(frm.elements[i].value) +"&";
					var bed_yn='<%=ipparam_bed_yn%>';

					var from_date = parent.criteria0.document.forms[0].from_date.value;
					var to_date = parent.criteria0.document.forms[0].to_date.value;
					if(from_date!=null && from_date!='')
						from_date = convertDate(from_date,"DMYHM",localeName,"en");
					if(to_date!=null && to_date!='')
						to_date = convertDate(to_date,"DMYHM",localeName,"en");


					parent.result.location.href = '../jsp/BedAvailabilityChartResult.jsp?'+params+"&ipparam_bed_yn="+bed_yn+"&query_gender_type="+'<%=query_gender_type%>'+"&from_date_converted="+from_date+"&to_date_converted="+to_date;
				}
				else
				{
					parent.result.location.href = '../../eCommon/html/blank.html'
				}
				</script>
		<%	}
			else
			{	%>
				<script>
					parent.result.location.href = '../../eCommon/html/blank.html'
				</script>				
		<%	}
		}

		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

	}catch(Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
</html>

<%!
// Added by Sridhar R on 2/23/2005... 
// This func will check for null values & return empty string if Null...
	private String checkForNull(String inputString)
	{
		return (inputString==null)? "" : inputString;
	}
%>

