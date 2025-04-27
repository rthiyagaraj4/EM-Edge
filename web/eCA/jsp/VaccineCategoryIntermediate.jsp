<%@ page  import="java.util.*,java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");				
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String sql = "";
//	int count =0;
	int min_age = 0;
	int max_age = 0;
	String age_unit = "";
	String age_unit_max = "";
	int appl_age_years = 0;
	int appl_age_months = 0;
	int appl_age_days = 0;
	int sch_freq_days = 0;
	int min_appl_age = 0;
	int max_appl_age = 0;
	String message = "";
	String age_group_code = "";
	String vacc_categ_id = "";
	String age_group_old = "";
	try
	{
			Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash = (Hashtable)hash.get( "SEARCH" ) ;	
			String callFrom =(String) hash.get("CALLFROM");					
		if(callFrom.equals("AGE_GRP_APPL"))
		{	
			vacc_categ_id =(String) hash.get("VACC_CATEG_ID");
			age_group_code =(String) hash.get("AGE_GROUP_NEW");
			age_group_old =(String) hash.get("AGE_GROUP_OLD");
			
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("categoryCode") == null ? "" : request.getParameter("categoryCode");
		
			sql = "Select AGE_GROUP_CODE,MIN_AGE, MAX_AGE, AGE_UNIT, AGE_UNIT_MAX from AM_AGE_GROUP where AGE_GROUP_CODE=? AND eff_status='E' ";
	
			ps = con.prepareStatement(sql);
			ps.setString(1,age_group_code);
			rs = ps.executeQuery();
			if(rs.next())
			{
				min_age  = rs.getString("MIN_AGE")==null?0:rs.getInt("MIN_AGE");
				max_age  = rs.getString("MAX_AGE")==null?0:rs.getInt("MAX_AGE");
				age_unit  = rs.getString("AGE_UNIT")==null?"":rs.getString("AGE_UNIT");
				age_unit_max  = rs.getString("AGE_UNIT_MAX")==null?"":rs.getString("AGE_UNIT_MAX");
				if(age_unit.equals("Y"))
				{
					min_appl_age = min_age*365;
				}else if(age_unit.equals("M"))
				{
					min_appl_age = min_age*30;
				}else if(age_unit.equals("D"))
				{
					min_appl_age = min_age*1;
				}else if(age_unit.equals("H"))
				{
					min_appl_age = min_age*1/24;
				}else if(age_unit.equals("N"))
				{
					min_appl_age = min_age*1/24*60;
				}

				if(age_unit_max.equals("Y"))
				{
					max_appl_age = max_age*365;
				}else if(age_unit_max.equals("M"))
				{
					max_appl_age = max_age*30;
				}else if(age_unit_max.equals("D"))
				{
					max_appl_age = max_age*1;
				}else if(age_unit_max.equals("H"))
				{
					max_appl_age = max_age*1/24;
				}else if(age_unit_max.equals("N"))
				{
					max_appl_age = max_age*1/24*60;
				}
			}			
			if(rs != null) rs.close();									
			if(ps != null) ps.close();

			sql = "SELECT VACCINE_ID,DOSE_NO, APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS,DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? ORDER BY VACCINE_ID,DOSE_NO";
	
			ps = con.prepareStatement(sql);
			ps.setString(1,vacc_categ_id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				appl_age_years  = rs.getString("APPL_AGE_YEARS")==null?0:rs.getInt("APPL_AGE_YEARS");
				appl_age_months  = rs.getString("APPL_AGE_MONTHS")==null?0:rs.getInt("APPL_AGE_MONTHS");
				appl_age_days  = rs.getString("APPL_AGE_DAYS")==null?0:rs.getInt("APPL_AGE_DAYS");
				
				sch_freq_days = appl_age_years*365+appl_age_months*30+appl_age_days;
				
				if (min_appl_age > sch_freq_days || max_appl_age < sch_freq_days )
				{
					message= "AGE_GRP_LINK";
					break;
				}			
			}			
			if(rs != null) rs.close();									
			if(ps != null) ps.close();
			
			if(message.equals("AGE_GRP_LINK")){
				out.println("alert(getMessage('"+message+"','CA'))");			
				out.println("document.getElementById('age_group').value='"+age_group_old+"'");			
			}
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 
