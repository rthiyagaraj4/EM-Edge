package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __bookinggetexpdaysdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookingGetExpDaysDate.jsp", 1719574251842L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\tvar opt =  document.createElement(\'Option\');\n\t\t\topt.text=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\';\n\t\t\topt.value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\n\t\t\tdocument.forms[0].service.add(opt);\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\t\t\tif(document.forms[0].specialtyCheck)document.forms[0].specialtyCheck.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t \n\t\t\tif(document.forms[0].practitionerCheck)document.forms[0].practitionerCheck.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet associateDiagBean= null;synchronized(session){
                associateDiagBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("associateDiagBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(associateDiagBean==null){
                    associateDiagBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("associateDiagBean",associateDiagBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection conn = null;
ResultSet rs	= null;
Statement stmt	= null;

try
{
	String locale			= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String facilityId = (String) session.getValue("facility_id");
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String step = (String) hash.get("step");
    conn = ConnectionManager.getConnection(request);
	if(step.equals("One"))
	{
		String prefDateTime =(String) hash.get("prefDateTime");
		String expDaysofStay=(String) hash.get("expDaysofStay");

		String sql = " Select to_char(to_date('"+prefDateTime+"','DD/MM/rrrr HH24:MI')+"+expDaysofStay+",'dd/mm/rrrr hh24:mi') From DUAL ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		out.println(rs.getString(1));
		//out.println(DateUtils.convertDate(rs.getString(1),"DMYHM","en",locale));
		
		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();
	}
	else if(step.equals("Two"))
	{
		String nursingUnitCode = (String) hash.get("nursingUnitCode");
		String sql = " Select service_code, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingUnitCode+"' union select service_code, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from ip_nursing_unit where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingUnitCode+"' order by 2 ";
		stmt = conn.createStatement();		
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(rs.getString("service_short_desc")));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(rs.getString("service_code")));
            _bw.write(_wl_block4Bytes, _wl_block4);

		}
		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();
	}/*Friday, December 18, 2009 To Check any active confirm booking is present for patient_id 17418*/
	else if(step.equals("Three"))
	{
		
		
		String patientid			= (String) hash.get("patientid");
		String bkg_grace_period   = "";
		
		String paramSQL = "Select bkg_grace_period from IP_PARAM where facility_id='"+facilityId+"' ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(paramSQL);
		 if(rs!= null)
		{
			if(rs.next())
			{
				bkg_grace_period = rs.getString("bkg_grace_period");         
			}                   
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

		String sql = " select count(*) from ip_booking_list a where  a.booking_status in ('0','1') and trunc(a.preferred_date)>= trunc(sysdate - "+bkg_grace_period+")  and a.facility_id='"+facilityId+"' and a.patient_id like '"+patientid+"%'  order by a.priority_ind desc, a.preferred_date ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		out.write(rs.getString(1));
				
		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();
	}
	/*Saturday, January 09, 2010 This code is added to get patient_id when booking reference no is given and tab out from booking ref no field in Admit Patient screen.*/
	else if(step.equals("four"))
	{
		String bookingref			= (String) hash.get("bookingref");
		String operatorstation		= (String) hash.get("operatorstation");
		String bkg_type				= (String) hash.get("bkg_type");
		String login_user			= (String)session.getAttribute("login_user");
		String sql					= "";
	
		if(bkg_type.equals("D")){
			//sql = " select a.patient_id from oa_appt a where   a.appt_status = '1' and trunc(a.appt_date) >= trunc(sysdate)  and a.facility_id='"+facilityId+"' and a.appt_ref_no = '"+bookingref+"' order by a.appt_date ";
			/*Friday, January 07, 2011 , and trunc(a.appt_date) >= trunc(sysdate) removed from where criteria for SRR20056-SCF-6370 [IN:025788] , since this query does not return patient_id for expired bookings.*/
			sql = " select a.patient_id from oa_appt a where   a.appt_status = '1'   and a.facility_id='"+facilityId+"' and a.appt_ref_no = '"+bookingref+"' order by a.appt_date ";
			
		}else
		{
			//sql = " select a.patient_id from ip_booking_list a where   a.booking_status = '1' and trunc(a.preferred_date) >= trunc(sysdate)  and a.facility_id='"+facilityId+"' and (a.nursing_unit_code in (Select n.nursing_unit_code from IP_NURSING_UNIT n, AM_OS_USER_LOCN_ACCESS_VW b where n.facility_id='"+facilityId+"' and n.eff_status = 'E' and b.locn_type = 'N' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+operatorstation+"' and b.appl_user_id='"+login_user+"')  or a.nursing_unit_code is null) and a.BKG_LST_REF_NO = '"+bookingref+"' order by a.priority_ind desc, a.preferred_date ";

			/*Friday, January 07, 2011 , and trunc(a.preferred_date) >= trunc(sysdate) removed from where criteria for SRR20056-SCF-6370 [IN:025788] , since this query does not return patient_id for expired bookings.*/
			sql = " select a.patient_id from ip_booking_list a where   a.booking_status = '1'  and a.facility_id='"+facilityId+"' and (a.nursing_unit_code in (Select n.nursing_unit_code from IP_NURSING_UNIT n, AM_OS_USER_LOCN_ACCESS_VW b where n.facility_id='"+facilityId+"' and n.eff_status = 'E' and b.locn_type = 'N' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+operatorstation+"' and b.appl_user_id='"+login_user+"')  or a.nursing_unit_code is null) and a.BKG_LST_REF_NO = '"+bookingref+"' order by a.priority_ind desc, a.preferred_date ";
		}
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs!= null && rs.next())
			out.write(checkForNull(rs.getString(1)));
		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();
	}
	/*
       Code added for the 18206  date Tuesday, January 19, 2010start here
	*/
	else if(step.equals("five"))
	{
		String nursingunitcode			= (String) hash.get("nursing_unit_code");
		String practitionerid		= (String) hash.get("practitioner_id");
		String specilitycode			= (String) hash.get("specialty_code");

		String sql="Select count(*) from IP_NURSING_UNIT_FOR_PRACT where  facility_id='"+facilityId +"' and nursing_unit_code='"+nursingunitcode+"'  and practitioner_id='"+practitionerid+"'  ";
		int pract_count = 0;

		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		pract_count=rs.getInt(1);

		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();

		String sql1="Select count(*) from ip_nurs_unit_for_specialty a, am_speciality b where  a.facility_id='"+facilityId +"' and a.nursing_unit_code='"+nursingunitcode+"'  and a.specialty_code = b.speciality_code and b.eff_status = 'E' and a.specialty_code='"+specilitycode+"'  ";

		int spl_count = 0;

		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		rs.next();
		spl_count=rs.getInt(1);

		if(rs!=null)    rs.close();
		if(stmt!=null) stmt.close();

		out.write(pract_count+"||"+spl_count);	


	}
	/*
       Code added for the 18350  date Wednesday, January 20, 2010 start here
	*/

	else  if(step.equals("six"))
	{
			String nursingunitcode			= (String) hash.get("nursing_unit_code");
			String medical_service			= (String) hash.get("medical_service");
			StringBuffer sbSql=new StringBuffer();
			String validservice="";

			sbSql.append(" SELECT med_ser_grp_code FROM ip_nursing_unit a, ip_med_ser_grp_nurs_ut_type b ");
			sbSql.append(" WHERE  b.facility_id = a.facility_id ");
			sbSql.append(" AND b.nursing_unit_type_Code = a.nursing_unit_type_code ");
			sbSql.append(" AND a.facility_id = '"+ facilityId +"'  ");
			sbSql.append(" AND nursing_unit_code = '"+nursingunitcode+"' ");
			sbSql.append(" AND b.med_ser_grp_code = '"+medical_service+"' ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sbSql.toString());
			if(rs!=null )
			{
				if(!rs.next())
				{
					validservice="N";
				}
				else
					validservice="Y";
				

			}
			if(rs!=null)    rs.close();
		    if(stmt!=null) stmt.close();
			out.write(validservice+"||");

	}
	/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
	else if(step.equals("seven"))
	{
		String nursing_unit			= (String) hash.get("nursing_unit");
		String operatorstation		= (String) hash.get("operatorstation");
		String Login_User			= (String) hash.get("Login_User");
		String admit_patient_with_bed_yn = "Y";

		String oprStnSQL = "Select admit_patient_with_bed_yn from am_os_user_locn_access_vw where facility_id='"+facilityId+"' and locn_code = '"+nursing_unit+"' and appl_user_id = '"+Login_User+"' and oper_stn_id = '"+operatorstation+"' ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(oprStnSQL);
		 if(rs!= null)
		{
			if(rs.next())
			{
				admit_patient_with_bed_yn = rs.getString("admit_patient_with_bed_yn");         
			}                   
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		out.write(admit_patient_with_bed_yn);
	}
	//Added for the CRF - RUT-CRF-13.1 - 35825 - start
	else if(step.equals("eight"))
	{
		String nursing_unit			= (String) hash.get("nursing_unit_code");
		int patInsCount=0;
		String patInsCheckSql ="SELECT instruction_id, display_order,am_get_desc.am_pat_instructions (instruction_id, '"+locale+"', 1) INSTRUCTION_DESC, DEFAULT_LINKED_YN FROM IP_NURS_PAT_INSTRUCTIONS where NURSING_UNIT_CODE='"+nursing_unit+"' and facility_id='"+facilityId+"'"; 
		stmt = conn.createStatement();
		rs = stmt.executeQuery(patInsCheckSql);
		String display_order_instn="";
		String instn_id="";
		String inst_desc="";
		String checkYN="N";
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");
		if (patInstructionsMap == null){
			patInstructionsMap=new TreeMap();
		}
		while(rs.next())
		{

			display_order_instn=rs.getString("DISPLAY_ORDER");
			instn_id=rs.getString("INSTRUCTION_ID");
			inst_desc=rs.getString("INSTRUCTION_DESC");
			checkYN=rs.getString("DEFAULT_LINKED_YN");
			String instns=instn_id+"||"+inst_desc+"||"+checkYN;
			Integer dis_ord=new Integer(Integer.parseInt(display_order_instn));
			patInstructionsMap.put(dis_ord,instns);
			if(checkYN != null && checkYN.equals("Y")){
				patInsCount++;         
			}
		}                 
		session.setAttribute("ipPatInstructionsMap",patInstructionsMap);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		out.println(patInsCount);
	}
	else if(step.equals("nine"))
	{
		String bookingref			= (String) hash.get("bookingref");
		int patInsCount=0;
		String patInsCheckSql ="SELECT count(*) FROM IP_BKG_PAT_INSTRUCTIONS where BKG_REF_NO='"+bookingref+"' and facility_id='"+facilityId+"'"; 
		stmt = conn.createStatement();
		rs = stmt.executeQuery(patInsCheckSql);
		
		while(rs.next())
		{
			patInsCount=rs.getInt(1);         
		}                 
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		out.println(patInsCount);
	}
	else if(step.equals("ten")){
		String instruction_id="";
		String ins_dec="";
		String dflt_to_print="";
		String pos			= (String) hash.get("position");
		String default_yn= (String) hash.get("default_yn");
		String description= (String) hash.get("description")	;	
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");
		Integer dis_ord=new Integer(Integer.parseInt(pos));
		if (patInstructionsMap!=null){
				String instValue=(String)patInstructionsMap.remove(dis_ord);
				StringTokenizer tokenizer=new StringTokenizer(instValue,"||");
				while (tokenizer.hasMoreTokens()){
					instruction_id=tokenizer.nextToken();
					ins_dec=tokenizer.nextToken();	
					dflt_to_print=tokenizer.nextToken();
				}
				if (description !=null && !description.equals("")){
					ins_dec=java.net.URLDecoder.decode(description,"UTF-8");
					//ins_dec=description;
				}
				instValue=instruction_id+"||"+ins_dec+"||"+default_yn;
				patInstructionsMap.put(dis_ord,instValue);
				session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
			}
	}	//Added for the CRF - RUT-CRF-13.1 - 35825 - End
	else if(step.equals("eleven")){//added for 39700		
		session.removeAttribute("ipPatInstructionsMap");// Instruction removed from session for abort cancellation functionality
	}
	else if(step.equals("twelve")){//added for 39926
		String pos			= (String) hash.get("position");
		String default_yn= (String) hash.get("default_yn");
		int new_pos=(Integer.parseInt(pos)*4)+3;
		associateDiagBean.setObject(new_pos,default_yn);
	}
	else if(step.equals("Delink")){
		int babycount=0;
		int availablebed=0;
		boolean proceed=true;
		//String patientid			= (String) hash.get("patient_id");
		String patient_id=request.getParameter("patient_id");
		String frnursingunitcode=request.getParameter("frnursingunitcode");
		String tonursingunitcode=request.getParameter("tonursingunitcode");
		String to_bed_no=request.getParameter("to_bed_no");
		String delinkSql="SELECT (SELECT COUNT (*) FROM ip_nursing_unit_bed WHERE facility_id = '"+facilityId+"'AND nursing_unit_code = '"+frnursingunitcode+"' AND mothers_patient_id = '"+patient_id+"') baby_count, (SELECT COUNT (*)  FROM ip_nursing_unit_bed WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+tonursingunitcode+"' AND main_bed_no = '"+to_bed_no+"' AND current_status = 'A' AND EFF_STATUS='E') available_bed_count FROM DUAL";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(delinkSql);
		while(rs.next())
		{
			babycount=rs.getInt(1);         
			availablebed=rs.getInt(2);         
		}    
		if(availablebed>=babycount){			
			out.println(proceed);
		}else{
			proceed=false;
			out.println(proceed);
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	//Added for this CRF GHL-CRF-0340
	else if(step.equals("SpecialityCode")){		
		String facilityid=(String)hash.get("facilityid");
		String nursing_unitcode=(String)hash.get("nursing_unitcode");
		String splcode=(String)hash.get("splcode");
		String SpecialityQuery="select count(*) as total from ip_nurs_unit_for_specialty where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unitcode+"' and specialty_code='"+splcode+"'"; 
        		
 		String specialty_code="";
		int record_count=0;
			if(rs!=null)rs.close();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SpecialityQuery) ;	
			if(rs !=null && rs.next())
			{				
			   record_count=rs.getInt("total");
			 
			 }	
           			
			
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block6Bytes, _wl_block6);

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
	}
	else if(step.equals("Practitionercheck")){		
		String facilityid=(String)hash.get("facilityid");
		String nursing_unitcode=(String)hash.get("nursing_unitcode");
		String practid=(String)hash.get("practid");
		String PractitionerQuery="select count(*) as total from ip_nursing_unit_for_pract where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unitcode+"' and practitioner_id='"+practid+"'"; 
       	
 		
		    int pract_record_count=0;
			if(rs!=null)rs.close();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PractitionerQuery) ;	
			if(rs !=null && rs.next())
			{ 			
			  pract_record_count=rs.getInt("total");
			}	
           			
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pract_record_count));
            _bw.write(_wl_block6Bytes, _wl_block6);

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
	}
	//End GHL-CRF-0340
	
	hash.clear();	
}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
