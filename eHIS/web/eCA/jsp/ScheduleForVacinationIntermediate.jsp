
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%


	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;

	String action_mode ="";
	String vac_sch_ref ="";
	String vaccine_id ="";
	String vacc_categ_id ="";
	String lastAdministeddate ="";
	String administer_date ="";
	String adhoc_yn ="";
	String dup_chk1 ="";
	String patient_id ="";
	String encounter_id ="";
	String dupl_check_action ="";

	String site_id ="";
	String default_yn ="";
	String short_desc ="";
	String sel ="";

	float interval=0;
	int prev_check_days=0;

 
	try
	{
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		con = ConnectionManager.getConnection(request);
		hash = (Hashtable)hash.get( "SEARCH" ) ;

		if(hash.containsKey("action_mode"))
		{
			action_mode =(String)hash.get("action_mode");
		}

		if(action_mode.equals("dup_chk"))
		{
		
		if(hash.containsKey("vac_sch_ref"))
		{
			vac_sch_ref = (String)hash.get("vac_sch_ref");
		}
		if(hash.containsKey("vaccine_id"))
		{
			vaccine_id = (String)hash.get("vaccine_id");
		}
		if(hash.containsKey("vacc_categ_id"))
		{
			vacc_categ_id = (String)hash.get("vacc_categ_id");
		}
		if(hash.containsKey("patient_id"))
		{
			patient_id = (String)hash.get("patient_id");
		}
		if(hash.containsKey("encounter_id"))
		{
			encounter_id = (String)hash.get("encounter_id");
		}
		if(hash.containsKey("adhoc_yn"))
		{
			adhoc_yn = (String)hash.get("adhoc_yn");
		}
		if(hash.containsKey("administer_date"))
		{
			administer_date = (String)hash.get("administer_date");
		}
			
				

		if(vac_sch_ref.equals("")&&adhoc_yn.equals("Y"))
		{

			String vacc_sch_qry ="select VAC_SCH_REF from CA_IM_PAT_VAC_SCH_HDR where VACC_CATEG_ID =? and PATIENT_ID=? and INITIATING_ENCOUNTER_ID =?";

			pstmt=con.prepareStatement(vacc_sch_qry);
			pstmt.setString(1,vacc_categ_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,encounter_id);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				vac_sch_ref = rs.getString("VAC_SCH_REF")==null ? "":rs.getString("VAC_SCH_REF");	
			}
					
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		
		}
		if(!vac_sch_ref.equals(""))
		{
		
			String dup_chk ="select nvl(to_char(max(ADMINISTERED_DATE),'DD/MM/YYYY HH24:MI'),'01/01/1900 00:00') ADMINISTERED_DATE from CA_IM_PAT_VAC_SCH_DTL WHERE VAC_SCH_REF = ? AND VACCINE_ID= ? and OUTCOME_CODE='C'";
			
			pstmt=con.prepareStatement(dup_chk);
			pstmt.setString(1,vac_sch_ref);
			pstmt.setString(2,vaccine_id);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				lastAdministeddate = rs.getString("ADMINISTERED_DATE")==null ? "":rs.getString("ADMINISTERED_DATE");	
			}
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		

			if(adhoc_yn.equals("Y"))
			{

				dup_chk1 = "select (to_date(?,'DD/MM/YYYY HH24:MI')+.00068287)-to_date(?,'DD/MM/YYYY HH24:MI') interval, DUPL_CHECK_DAYS DUPL_CHECK_DAYS,DUPL_CHECK_ACTION DUPL_CHECK_ACTION from CA_IM_VACCINE where VACCINE_ID=?";
			}
			else
			{
				dup_chk1 = "select (to_date(?,'DD/MM/YYYY HH24:MI')+.00068287)-to_date(?,'DD/MM/YYYY HH24:MI') interval, PREV_CHECK_DAYS DUPL_CHECK_DAYS,PREV_CHECK_ACTION DUPL_CHECK_ACTION from CA_IM_VAC_FOR_CATEG  where VACCINE_ID=? and  VACC_CATEG_ID=? ";
			}
			pstmt=con.prepareStatement(dup_chk1);
			pstmt.setString(1,administer_date);
			pstmt.setString(2,lastAdministeddate);
			//pstmt.setString(2,vacc_categ_id);

		
			pstmt.setString(3,vaccine_id);
			if(!adhoc_yn.equals("Y"))
			{
				pstmt.setString(4,vacc_categ_id);
			}
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				interval = rs.getFloat("interval");
				
				prev_check_days = rs.getInt("DUPL_CHECK_DAYS");	
				dupl_check_action = rs.getString("DUPL_CHECK_ACTION")==null?"":rs.getString("DUPL_CHECK_ACTION");	
			}
			
			out.println("top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.interval.value='"+(int)Math.ceil(interval)+"'");
			out.println("top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.prev_check_days.value='"+prev_check_days+"'");
			out.println("top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.dupl_check_action.value='"+dupl_check_action+"'");

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		}
		else if(action_mode.equals("pop_vac"))
		{

			if(hash.containsKey("vaccine_id"))
			{
				vaccine_id = (String)hash.get("vaccine_id");
			}

			String Vacc_site_qry ="Select A.SITE_ID,A.DEFAULT_YN,B.SHORT_DESC from CA_IM_SITE_FOR_VACCINE A,AM_ANATOMICAL_SITE B where A.VACCINE_ID = ? AND B.ANATOMICAL_SITE_CODE = A.SITE_ID order by 2 ";

			pstmt=con.prepareStatement(Vacc_site_qry);
			//pstmt.setString(1,vac_sch_ref);
			pstmt.setString(1,vaccine_id);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
						
			site_id	= rs.getString("SITE_ID");
			default_yn	= rs.getString("DEFAULT_YN");
			short_desc		= rs.getString("short_desc");
			if((site_id == null) || site_id.equals("null"))site_id="";
			if((default_yn == null) || default_yn.equals("null"))default_yn="N";
			if((short_desc == null) || short_desc.equals("null"))short_desc="";
			if(default_yn.equals("Y"))
				{
					sel ="selected";
				}
				else
				{
					sel ="";	
				}
			
			//out.println("top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.dupl_check_action.value='"+dupl_check_action+"'");
		
			
			out.println("var element = top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.createElement('OPTION')");
			out.println("element.text = '"+short_desc+"'");
			out.println("element.value = '"+site_id+"'");
			out.println("element.selected = '"+sel+"'");
			out.println("top.content.workAreaFrame.VaccinationFrame.VaccinAdminDetailsFrame.document.adminDetailform.site_name.add(element)");
			

			}
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();


			
		}
	}
	catch(Exception e)
	{
			
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>

