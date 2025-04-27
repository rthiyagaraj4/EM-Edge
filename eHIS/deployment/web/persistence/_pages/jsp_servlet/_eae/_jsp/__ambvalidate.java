package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;

public final class __ambvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eae/jsp/AMBValidate.jsp", 1709113772660L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

/* Table name specifies the table to query */
	String function_type	= checkForNull(request.getParameter( "function_type" )) ;
	String amb_nature_Code	= checkForNull(request.getParameter( "amb_nature_Code" )) ;
	String escort_type_code	= checkForNull(request.getParameter( "escort_type_code" )) ;
	String short_desc	= checkForNull(request.getParameter( "short_desc" )) ;
	String res_town_code	= checkForNull(request.getParameter( "res_town_code" )) ;

	String facility_id	=(String) session.getAttribute("facility_id");
	StringBuffer listData	= new StringBuffer();

	Connection con				=	null;
	Statement stmt				=	null;
	ResultSet rs 				=	null;
	ArrayList stores 			=	new ArrayList();
	try 
		{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		
		if (function_type.equals("getDfltVals")) //Get Deflt values
		{
			String amb_mileage_uom = "";
			String virt_keypad_display_yn = "";
			String virt_keypad_disp_fld_yn = "";
			String amb_mileage_code = "";

			String gmap_val	= "";
			String amb_prefix_ind ="";
			String sql_query= "select (select short_desc from am_uom where uom_code=amb_mileage_uom) amb_mileage_uom, nvl(virt_keypad_display_yn,'N') virt_keypad_display_yn, nvl(virt_keypad_disp_fld_yn,'N') virt_keypad_disp_fld_yn,amb_mileage_uom amb_mileage_code,amb_prefix_ind  from ae_amb_param_for_facility  WHERE  facility_id ='"+facility_id+"'";
			System.out.println("sql_query : "+sql_query);
			rs = stmt.executeQuery(sql_query);
			
			if( rs != null)
			{
				if ( rs.next() )
				{
					amb_mileage_uom = rs.getString("amb_mileage_uom");
					virt_keypad_display_yn = rs.getString("virt_keypad_display_yn");
					virt_keypad_disp_fld_yn = rs.getString("virt_keypad_disp_fld_yn");
					amb_mileage_code = rs.getString("amb_mileage_code");
					amb_prefix_ind=rs.getString("amb_prefix_ind");
				}
				rs = null;
			}
			
			sql_query= " SELECT res_town_code, (SELECT long_desc FROM MP_RES_TOWN WHERE res_town_code=a.res_town_code AND ROWNUM <=1) town_desc,  (SELECT LONG_NAME || ',' FROM MP_COUNTRY WHERE COUNTRY_CODE = a.COUNTRY_CODE) || (SELECT LONG_DESC   || ',' FROM MP_REGION WHERE REGION_CODE = a.region_code) gmap_val FROM sm_facility_param a WHERE facility_id ='"+facility_id+"'";
			System.err.println("sql_query 52: "+sql_query);
			rs = stmt.executeQuery(sql_query);
			if( rs != null)
			{
				if ( rs.next() )
				{
					gmap_val = rs.getString("gmap_val")==null?"":rs.getString("gmap_val");
				}
				rs = null;
			}
			out.println("~"+amb_mileage_uom+"~"+virt_keypad_display_yn+"~"+virt_keypad_disp_fld_yn+"~"+gmap_val+"~"+amb_mileage_code+"~"+amb_prefix_ind);
		} 
		else if (function_type.equals("getAmbUom")) //Get UOM for vehicle
		{
			String amb_vehicle_id	= checkForNull(request.getParameter( "amb_vehicle_id" )) ;
			String amb_mileage_uom = "";
			String sql_query= "select (select SHORT_DESC from am_uom where uom_code=a.amb_mileage_uom) amb_mileage_uom from ae_amb_vehicle a WHERE  amb_vehicle_id ='"+amb_vehicle_id+"' and facility_id ='"+facility_id+"'";
			//System.out.println("sql_query : "+sql_query);
			rs = stmt.executeQuery(sql_query);
			
			if( rs != null)
			{
				if ( rs.next() )
				{
					amb_mileage_uom = rs.getString("amb_mileage_uom");
				}
			out.println(amb_mileage_uom);
			}
		}
		else if (function_type.equals("getSysDate")) //Get System Date
		{
			String sys_date = "";
			String sql_query= "select to_char(sysdate,'DD/MM/YYYY HH:MM') sys_date   from dual";
			//System.out.println("sql_query : "+sql_query);
			rs = stmt.executeQuery(sql_query);
			
			if( rs != null)
			{
				if ( rs.next() )
				{
					sys_date = rs.getString("sys_date");
				}
			out.println(sys_date);
			}
		}
		else if (function_type.equals("getLocn")) //Get current location of hospital
		{
			res_town_code	= "";
			String town_desc	= "";
			String gmap_val	= "";

			String sql_query= " SELECT res_town_code, (SELECT long_desc FROM MP_RES_TOWN WHERE res_town_code=a.res_town_code AND ROWNUM <=1)||','||(select facility_name from sm_facility where facility_id='"+facility_id+"') town_desc,  (SELECT LONG_NAME || ',' FROM MP_COUNTRY WHERE COUNTRY_CODE = a.COUNTRY_CODE) || (SELECT LONG_DESC   || ',' FROM MP_REGION WHERE REGION_CODE = a.region_code) || (SELECT long_desc FROM MP_RES_TOWN WHERE res_town_code=a.res_town_code AND ROWNUM <=1)||','||(select facility_name from sm_facility where facility_id='"+facility_id+"')gmap_val FROM sm_facility_param a WHERE facility_id ='"+facility_id+"'";
			System.err.println("sql_query ================="+sql_query);
			rs = stmt.executeQuery(sql_query);

			if( rs != null && rs.next())
			{
					town_desc = rs.getString("town_desc");
					res_town_code = rs.getString("res_town_code");
					gmap_val = rs.getString("gmap_val");
			}
			out.println("~"+res_town_code+"~"+town_desc+"~"+gmap_val);
			//System.out.println(res_town_code+"~"+town_desc+"~"+gmap_val);
		}
		else if (function_type.equals("patSearch")) //Get patient name 
		{
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String patient_name	= "" ;
			String sex	= "" ;
			String age	= "" ;

			String sql_query= "select patient_name, decode(sex,'M','Male','F','Female','U','Unknown') sex, get_age(date_of_birth) age from mp_patient where  UPPER(patient_id) LIKE UPPER('"+patient_id+"%')";
			//System.out.println("sql_query : "+sql_query);
			rs = stmt.executeQuery(sql_query);

			if( rs != null && rs.next())
			{
					patient_name = rs.getString("patient_name");
					sex = rs.getString("sex");
					age = rs.getString("age");
			}
			out.println(patient_name+"~"+sex+"~"+age);
		}
		else if (function_type.equals("loadResources")) 
		//Get Resources and Vehicle related info on blur of vehicle id selection
		{
			//AMB_LAST_MILEAGE,AMB_MILEAGE_UOM	
			String amb_vehicle_id	= checkForNull(request.getParameter( "amb_vehicle_id" )) ;
			String mode	= checkForNull(request.getParameter( "mode" )) ;
			String amb_mileage_uom	= "" ;
			String amb_last_mileage	= "" ;
			String uom_code="";

			String sql_query= "select (select short_desc from am_uom where uom_code=AMB_MILEAGE_UOM) amb_mileage_uom, nvl(amb_last_mileage,'') amb_last_mileage,AMB_MILEAGE_UOM uom_code from AE_AMB_VEHICLE where UPPER(amb_vehicle_id) LIKE UPPER('"+amb_vehicle_id+"%') and facility_id='"+facility_id+"' ";
			System.err.println("sql_query 146: "+sql_query);
			rs = stmt.executeQuery(sql_query);
			if( rs != null && rs.next())
			{
					amb_mileage_uom = rs.getString("amb_mileage_uom");
					amb_last_mileage = rs.getString("amb_last_mileage");
					uom_code=rs.getString("uom_code");

			}
			rs=null;

			StringBuffer resourceBuf = new StringBuffer("");
			String amb_resource_type	= "" ;
			String amb_resource_id	= "" ;
			String amb_resource_desc	= "" ;
			String amb_equipment_code	= "" ;
			String amb_equipment_desc	= "" ;
			ArrayList resourceList = new ArrayList();
			if (!mode.equals("update"))
			{
			sql_query= "select amb_resource_type, amb_resource_id, (case when amb_resource_type='P' then(SELECT    (SELECT position_desc FROM am_position WHERE position_code = a.position_code) || '~P~'|| practitioner_name resource_desc FROM am_practitioner a WHERE UPPER(practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') when amb_resource_type='E' then (SELECT    (SELECT position_desc FROM am_position WHERE position_code = a.position_code) || '~E~'|| practitioner_name resource_desc FROM am_ext_practitioner a WHERE UPPER(practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E')  when amb_resource_type='O' then (SELECT   (SELECT long_desc FROM am_other_staff_type WHERE other_staff_type = a.other_staff_type) || '~O~'||other_staff_name resource_desc FROM am_other_staff a WHERE UPPER(other_staff_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') else '' end) amb_resource_desc from ae_amb_vehicle_resource a where UPPER(amb_vehicle_id) LIKE UPPER('"+amb_vehicle_id+"%') and facility_id='"+facility_id+"'" ;
			System.err.println("sql_query 167: "+sql_query);
			rs = stmt.executeQuery(sql_query);
			if( rs != null )
			{
				while (rs.next())
				{
					amb_resource_type = rs.getString("amb_resource_type");
					amb_resource_id = rs.getString("amb_resource_id");
					amb_resource_desc = rs.getString("amb_resource_desc");
					resourceList.add(amb_resource_id+"~"+amb_resource_desc);
					resourceBuf.append(amb_resource_id+"~"+amb_resource_desc+'`');
				}
			}
			rs = null;
			
			
			sql_query= "select amb_equipment_code,(select long_desc from am_resource where resource_id=a.amb_equipment_code and facility_id = a.facility_id) amb_equipment_desc from ae_amb_vehicle_equip a where UPPER(amb_vehicle_id) LIKE UPPER('"+amb_vehicle_id+"%') and facility_id='"+facility_id+"'";
			System.err.println("sql_query 184: "+sql_query);
			rs = stmt.executeQuery(sql_query);
			if( rs != null )
			{
				while (rs.next())
				{
					amb_equipment_code = rs.getString("amb_equipment_code");
					amb_equipment_desc = rs.getString("amb_equipment_desc");
					resourceList.add(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc);
					resourceBuf.append(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc+'`');
				}
			}
			rs = null;
			}
			if (mode.equals("update"))
			{
				
				String amb_case_no	= checkForNull(request.getParameter( "amb_case_no" )) ;
				 amb_vehicle_id	= checkForNull(request.getParameter( "amb_vehicle_id" )) ;

				/*sql_query= "select  amb_resource_id,(select amb_resource_type from ae_amb_vehicle_resource  where amb_resource_id = a.amb_resource_id) amb_resource_type , (case when (select amb_resource_type from ae_amb_vehicle_resource  where amb_resource_id = a.amb_resource_id)='P' then(SELECT    (SELECT position_desc FROM am_position WHERE position_code = a.position_code) || '~P~'|| practitioner_name resource_desc FROM am_practitioner a WHERE UPPER(practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') when (select amb_resource_type from ae_amb_vehicle_resource  where amb_resource_id = a.amb_resource_id)='E' then (SELECT    (SELECT position_desc FROM am_position WHERE position_code = a.position_code) || '~E~'|| practitioner_name resource_desc FROM am_ext_practitioner a WHERE UPPER(practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E')  when (select amb_resource_type from ae_amb_vehicle_resource  where amb_resource_id = a.amb_resource_id)='O' then (SELECT   (SELECT long_desc FROM am_other_staff_type WHERE other_staff_type = a.other_staff_type) || '~O~'||other_staff_name resource_desc FROM am_other_staff a WHERE UPPER(other_staff_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') else '' end) amb_resource_desc from ae_amb_request_resource a where UPPER(amb_case_no) LIKE UPPER('"+amb_case_no+"%') and UPPER(amb_vehicle_id) LIKE UPPER('"+amb_vehicle_id+"%') and UPPER(facility_id) LIKE UPPER('"+facility_id+"%')" ;*/

				sql_query="select  practitioner_name , practitioner_id ,pract_source  type  , Position_desc  Postion_desc  from AM_PRACT_FOR_AMB_VW a , Ae_AMB_Request_resource b Where b.amb_resource_id = a.practitioner_id and amb_case_no = '"+amb_case_no+"' and facility_id ='"+facility_id+"' union select  long_desc practitioner_name , resource_id practitioner_id,'Q'  type ,'Equipment' Position_desc from am_resource a , ae_AMB_Request_Equip  b Where a.resource_id = b.amb_equipment_code and amb_case_no = '"+amb_case_no+"' and b.facility_id='"+facility_id+"'";
				 
				System.err.println("sql_query 208: "+sql_query);
				 amb_equipment_code	= "" ;
				 amb_equipment_desc	= "" ;
				 String rec_type="";
				rs = stmt.executeQuery(sql_query);
				if( rs != null )
				{
					while (rs.next())
					{  
						rec_type=rs.getString("type")==null?"":rs.getString("type");
						if(rec_type.equals("Q")){
							amb_equipment_code = rs.getString("practitioner_id");
							amb_equipment_desc = rs.getString("practitioner_name");
							resourceList.add(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc);
							resourceBuf.append(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc+'`');
						}else{
							amb_resource_type = rec_type;
							amb_resource_id = rs.getString("practitioner_id");
							amb_equipment_desc=rs.getString("Postion_desc")==null?"":rs.getString("Postion_desc");
							amb_resource_desc = amb_equipment_desc+"~"+rec_type+"~"+rs.getString("practitioner_name");
							resourceList.add(amb_resource_id+"~"+amb_resource_desc);
							resourceBuf.append(amb_resource_id+"~"+amb_resource_desc+'`');
						}
					}
				}
				rs = null;
				
			/*	 amb_equipment_code	= "" ;
				 amb_equipment_desc	= "" ;
				sql_query= "select amb_equipment_code,(select long_desc from am_resource where resource_id=a.amb_equipment_code) amb_equipment_desc from AE_AMB_REQUEST_EQUIP a where UPPER(amb_case_no) LIKE UPPER('"+amb_case_no+"%') and UPPER(amb_vehicle_id) LIKE UPPER('"+amb_vehicle_id+"%') and UPPER(facility_id) LIKE UPPER('"+facility_id+"%')" ;
				System.out.println("sql_query : "+sql_query);
				rs = stmt.executeQuery(sql_query);
				if( rs != null )
				{
					while (rs.next())
					{
						amb_equipment_code = rs.getString("amb_equipment_code");
						amb_equipment_desc = rs.getString("amb_equipment_desc");
						resourceList.add(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc);
						resourceBuf.append(amb_equipment_code+"~Equipment~Q~"+amb_equipment_desc+'`');
					}
				}
				rs = null;*/

			}
			
			
			out.println(amb_mileage_uom+"~"+uom_code+"`"+amb_last_mileage+"`"+resourceBuf.toString());
		}
		else if (function_type.equals("caseRequest")) //Get patient name 
		{
			String amb_case_no	= checkForNull(request.getParameter( "amb_case_no" )) ;
			String pat_dtls	= "" ;


			String sql_query= "select GET_AGE(DATE_OF_BIRTH) age, amb_arrv_destn, amb_caller_contact_no, amb_caller_name, amb_caller_remarks, to_char(amb_case_booked_date,'dd/mm/yyyy hh24:mi') amb_case_booked_date, to_char(amb_case_end_date,'dd/mm/yyyy hh24:mi')amb_case_end_date, amb_case_no, amb_case_recorded_by, to_char(amb_case_start_date,'dd/mm/yyyy hh24:mi') amb_case_start_date, amb_case_status, amb_disp_remarks, amb_dist_covered, amb_end_mileage, amb_exp_dist_covered, amb_map_location, amb_nature_call_code,trim(case when amb_priority_ind='H' then 'High' when amb_priority_ind='M' then 'Medium' else 'Low' end) amb_priority_ind, amb_service_type, nvl(amb_start_mileage,'') amb_start_mileage, amb_started_yn, amb_uom, amb_vehicle_id, date_of_birth, destn_address, destn_locn_code, destn_locn_desc, destn_to_hosp_yn, escort_type_code, facility_id, patient_id, patient_name, pickup_address, pickup_from_hosp_yn, pickup_locn_code, pickup_locn_desc,trim(case when sex='F' then 'Female' when sex='M' then 'Male' else 'Unknown' end) sex, unknown_pat_dtl_yn, (select short_desc from am_escort_type where escort_type_code = a.escort_type_code) escort_desc, (select appl_user_name from sm_appl_user where appl_user_id = a.amb_case_recorded_by) attd_by, (select short_desc from ae_amb_nature where amb_nature_Code = a.amb_nature_call_code) nature_call_desc, (select amb_vehicle_name from ae_amb_vehicle where amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id) amb_desc,(select amb_vehicle_type from AE_AMB_VEHICLE where amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id) amb_vehicle_type,(select (select practitioner_name  from am_pract_for_amb_vw where practitioner_id = amb_resource_id and pract_source = amb_resource_type)  from  ae_amb_vehicle_resource where facility_id = a.facility_id and amb_vehicle_id = a.amb_vehicle_id and contact_disply_yn = 'Y'  )  amb_cont_name, (select (select contact_no  from am_pract_for_amb_vw where practitioner_id = amb_resource_id and pract_source = amb_resource_type)  from  ae_amb_vehicle_resource where facility_id = a.facility_id and amb_vehicle_id = a.amb_vehicle_id and contact_disply_yn = 'Y'  ) amb_cont_phone,(select trim(amb_regn_no) from ae_amb_vehicle  where amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id) amb_regn_no,  (CASE WHEN (select suspend_maint_yn FROM ae_amb_vehicle   WHERE amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id)  = 'Y'  THEN 'M' ELSE CASE WHEN (select suspend_maint_yn FROM ae_amb_vehicle   WHERE amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id)  = 'N' AND EXISTS ( SELECT 'Y' FROM ae_amb_open_request WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id) THEN 'A' ELSE CASE WHEN (select suspend_maint_yn FROM ae_amb_vehicle WHERE amb_vehicle_id = a.amb_vehicle_id and facility_id = a.facility_id) = 'N' AND NOT EXISTS ( SELECT 'Y' FROM ae_amb_open_request   WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id) THEN 'B' END END END ) amb_status,(select long_desc from ae_amb_service_type where amb_service_type=a.amb_service_type) service_desc,(select AMB_CURRENT_LOCATION from AE_AMB_OPEN_REQUEST where amb_case_no=a.amb_case_no) loc,amb_case_cancelled_by,to_char(amb_case_cancelled_date,'dd/mm/yyyy hh24:mi') amb_case_cancelled_date from ae_amb_case_request a where  amb_case_no='"+amb_case_no+"' and facility_id='"+facility_id+"'";

			
			System.err.println("sql_query 266: "+sql_query);
			rs = stmt.executeQuery(sql_query);
			String pAge="";

			if( rs != null && rs.next())
			{ pAge=rs.getString("age")==null?"":rs.getString("age");
			  pAge=pAge.equals("null")?"":pAge;
			 pat_dtls = 
				
				pAge+"~"+rs.getString("amb_arrv_destn")+"~" +rs.getString("amb_caller_contact_no")+"~"+rs.getString("amb_caller_name")+"~" +rs.getString("amb_caller_remarks")+"~"+rs.getString("amb_case_booked_date")+"~" +rs.getString("amb_case_end_date")+"~"+rs.getString("amb_case_no")+"~" +rs.getString("amb_case_recorded_by")+"~"+rs.getString("amb_case_start_date")+"~" +rs.getString("amb_case_status")+"~"+rs.getString("amb_disp_remarks")+"~" +rs.getString("amb_dist_covered")+"~"+rs.getString("amb_end_mileage")+"~" +rs.getString("amb_exp_dist_covered")+"~"+rs.getString("amb_map_location")+"~" +rs.getString("amb_nature_call_code")+"~"+rs.getString("amb_priority_ind")+"~" +rs.getString("amb_service_type")+"~"+rs.getString("amb_start_mileage")+"~" +rs.getString("amb_started_yn")+"~"+rs.getString("amb_uom")+"~" +rs.getString("amb_vehicle_id")+"~"+rs.getString("date_of_birth")+"~" +rs.getString("destn_address")+"~"+rs.getString("destn_locn_code")+"~"+rs.getString("destn_locn_desc")+"~" +rs.getString("destn_to_hosp_yn")+"~"+rs.getString("escort_type_code")+"~" +rs.getString("facility_id")+"~"+rs.getString("patient_id")+"~" +rs.getString("patient_name")+"~"+rs.getString("pickup_address")+"~" +rs.getString("pickup_from_hosp_yn")+"~"+rs.getString("pickup_locn_code")+"~" +rs.getString("pickup_locn_desc")+"~"+rs.getString("sex")+"~" +rs.getString("unknown_pat_dtl_yn")+"~"+rs.getString("escort_desc")+"~"+rs.getString("attd_by")+"~" +rs.getString("nature_call_desc")+"~"+rs.getString("amb_desc")+"~" +rs.getString("amb_vehicle_type")+"~"+rs.getString("amb_cont_name")+"~" +rs.getString("amb_cont_phone")+"~"+rs.getString("amb_regn_no")+"~"+rs.getString("amb_status")
				+"~"+ rs.getString("service_desc")+"~"+rs.getString("loc")+"~"+rs.getString("amb_case_cancelled_date")
				+"~"+rs.getString("amb_case_cancelled_by");
			}
			out.println(pat_dtls);
		}
	}
	catch (Exception e)
	{
		//out.println( " Error from Ambulance Validate : " +  e.getMessage());
		e.printStackTrace(System.err);
	}
	finally
	{
		if(stmt != null) stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
