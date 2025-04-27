<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	Connection con =null;
	Statement  stmt=null;
	PreparedStatement  pstmt=null;
	ResultSet  rs =null;
	String	   operstn = "";

	Statement stmt1=null;
	ResultSet rs1 =null;
	Statement stmt2=null;
	ResultSet rs2 =null;

	try
	{ 
		con = ConnectionManager.getConnection(request);
		String facilityID=(String)session.getValue("facility_id");
		String loginUser = (String)session.getValue("login_user");
		String wherecondn = request.getParameter("wherecondn");
		String patient_class = request.getParameter("patient_class");
		String specialitycode = request.getParameter("specialitycode");
		String med_service_grp = request.getParameter("med_service_grp");
		if(wherecondn == null) wherecondn ="";
		if(patient_class == null) patient_class ="";
		operstn = request.getParameter("oper_stn_id");
		if(operstn == null) operstn = "";
		if(operstn.equals(""))
		{
			String operSql = "select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(operSql);

			if(rs1!=null)
			{
				while(rs1.next())
				{
					operstn	 = rs1.getString("oper_stn_id");
					if(operstn == null) operstn ="";
				}
			}

			if(rs1!=null)rs1.close();
			if(stmt1!=null)stmt1.close();
		}
		String name= request.getParameter("attribute");
		if(name==null)
		name = "nursing_unit";
		%><select name="<%=name%>" id="<%=name%>" width="15" onChange='popDynamicValues(this)'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%	
		stmt = con.createStatement();
		if(wherecondn.equals(""))
		{ 
			//String sql1=" Select short_desc, nursing_unit_code from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id='"+facilityID+"' and locn_type = 'N' and eff_status='E' order by short_desc ";
			/*Wednesday, May 05, 2010 , modified for PE*/
			String sql1=" Select ip_get_desc.ip_nursing_unit(?,nursing_unit_code,?,2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id=? and locn_type = 'N' and eff_status='E' order by short_desc ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facilityID);
			pstmt.setString(2,locale);
			pstmt.setString(3,facilityID);
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() )
				{
					String classcode = rs.getString( "nursing_unit_code" ) ;
					if(classcode == null) classcode ="";
					String classname = rs.getString( "short_desc" ) ;
					if(classname == null) classname ="";
				%>	      				
					<OPTION VALUE="<%= classcode %>" ><%= classname %>
			<%	}
			}
			if(rs!=null) rs.close();	      	
			if(pstmt!=null) pstmt.close();	      	
			}
			else
			{
				/*Friday, May 07, 2010 , commnted for PE */
				/*
				String sql2 = "";
				if(wherecondn.equals("CREATE_BOOKING_YN"))
				{
					sql2=" Select 1 from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b, IP_MED_SER_GRP_NURS_UT_TYPE c, IP_NURS_UNIT_FOR_SPECIALTY d  where a.facility_id='"+facilityID+"' and c.FACILITY_ID = A.FACILITY_ID AND c.MED_SER_GRP_CODE = '"+med_service_grp+"' AND c.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and a.appl_patient_class = 'IP' and b.locn_type =  'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y' ) and a.eff_status='E' and d.FACILITY_ID = A.FACILITY_ID AND d.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND d.SPECIALTY_CODE = '"+specialitycode+"'   order by a.short_desc";

				}
				else if(wherecondn.equals("ASSIGN_BED_YN"))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";

				}
				else if(wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN"))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b.assign_bed_yn = 'Y' AND b."+wherecondn+" = 'Y' and a.eff_status='E' order by a.short_desc";

				}
				else if(wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";
				}
				else
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
					" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";
				}
				rs = stmt.executeQuery(sql2);			

				if( rs != null )
				{
					if( rs.next() )
					{  */    	
						StringBuffer sql1 = new StringBuffer();
						if(wherecondn.equals("CREATE_BOOKING_YN"))
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2)short_desc, a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,   ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b, IP_MED_SER_GRP_NURS_UT_TYPE c, IP_NURS_UNIT_FOR_SPECIALTY d where a.facility_id=?   ");
							sql1.append(" and c.FACILITY_ID = A.FACILITY_ID AND c.MED_SER_GRP_CODE = ? AND c.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE  "); 
							sql1.append(" and a.facility_id=b.facility_id and a.nursing_unit_code = b.locn_code "); 
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and d.FACILITY_ID = A.FACILITY_ID AND d.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND d.SPECIALTY_CODE = ? and a.APPL_PATIENT_CLASS = 'IP' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y') and a.eff_status='E' order by a.short_desc");	
						}
						else if(wherecondn.equals("ASSIGN_BED_YN") )
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b."+wherecondn+"='Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function*/
						else if(wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN") )
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b.assign_bed_yn='Y' ");
							sql1.append(" AND b."+wherecondn+" = 'Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						else if(wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? "); 
							sql1.append(" and b."+wherecondn+"='Y' ");
							/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
							sql1.append(" AND b.admit_patient_with_bed_yn = 'Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						else
						{
							

							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2)short_desc, a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" am_os_user_locn_access_vw b where a.facility_id=? 	   ");
							sql1.append(" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc");
						}



						pstmt = con.prepareStatement(sql1.toString());
							pstmt.setString(1,facilityID);
							pstmt.setString(2,locale);
							pstmt.setString(3,facilityID);
						if(wherecondn.equals("CREATE_BOOKING_YN"))
						{
							pstmt.setString(4,med_service_grp);
							pstmt.setString(5,specialitycode);
							pstmt.setString(6,operstn);
							pstmt.setString(7,loginUser);
						}else if(wherecondn.equals("ASSIGN_BED_YN") || wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN") || (wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))){
							pstmt.setString(4,patient_class);
							pstmt.setString(5,operstn);
							pstmt.setString(6,loginUser);
						}else{
							pstmt.setString(4,operstn);
							pstmt.setString(5,loginUser);
						}
						rs2 = pstmt.executeQuery();			
						if( rs2 != null )
						{
							while( rs2.next() )
							{
								String classcode = rs2.getString( "nursing_unit_code" ) ;
								String classname = rs2.getString( "short_desc" ) ;
							%><OPTION VALUE="<%= classcode %>" ><%= classname %>
						<%	}
						}else{
							String classcode = "";
							String classname = "";
							out.print("<option value=\""+classcode+"\">"+classname+"");
						}
					/*}
					else
					{
						String classcode = "";
						String classname = "";
						%>
						<!--OPTION VALUE="<%--=classcode--%>" ><%--=classname--%>-->
				<%	/*}
				}*/
				if(rs!=null) rs.close();
			}//e.o.Else

	}catch(Exception e)	
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if(rs2!=null) rs2.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}	%>
</select>

