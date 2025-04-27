package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __multitransrequestintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MultiTransRequestIntermediate.jsp", 1737095503585L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	
	StringTokenizer rowTok = null;
	StringTokenizer colTok = null;
	String arrVal ="";
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
	String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

	if(operation_mode.equals("addAllToBean"))
	{

		eCA.PatientBannerGroupLine multiTransBean = null;
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		String facility_id		=	(String) session.getValue("facility_id");
		String resp_id = (String)session.getValue("responsibility_id");
		
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		StringBuffer transReqQry = new StringBuffer();
		String patientId ="";
		String practitionerId ="";
		String speciality_code ="";
		String location_code ="";
		String service_code ="";
		String CurrentDate ="";
		String CurrentTime = "";
		String transcriber = "";
		String notes = "";
		String hash_key = "";
		String hash_value = "";
		String patient_id ="";
		String encounter_id ="";
		String pline ="";
		String rsAdmission_date_time ="";
		String attend_practitioner_id ="";
		String locn_type_crit		 =	"";

		patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
		service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
		CurrentDate			=	(request.getParameter("CurrentDate")==null)	?	""	:	request.getParameter("CurrentDate");
		CurrentTime			=	(request.getParameter("CurrentTime")==null)	?	""	:	request.getParameter("CurrentTime");
		locn_type_crit			=	(request.getParameter("locn_type")==null)	?	""	:	request.getParameter("locn_type");

		bean_key = practitionerId+CurrentDate+CurrentTime;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		transReqQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?) Pline, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME ,nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS) DEFAULT_TRANSCRIBER,CA_GET_DEFAULT_NOTES(?,?,b.SPECIALTY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.ATTEND_PRACTITIONER_ID= ? ");

	if(!speciality_code.equals(""))
		transReqQry.append("and b.SPECIALTY_CODE=? ");
	if(!patientId.equals(""))
		transReqQry.append("and b.PATIENT_ID =? ");
	
	if(!locn_type_crit.equals(""))
		transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");

	if(!location_code.equals(""))
		transReqQry.append("and b.NURSING_UNIT_CODE =? ");
	if(!service_code.equals(""))
		transReqQry.append("and b.SERVICE_CODE=? "); //

	   transReqQry.append(" UNION ALL SELECT a.PATIENT_ID,a.ENCOUNTER_ID,get_patient.get_line_detail(a.PATIENT_ID,?) Pline,to_char(a.ARRIVE_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,PRACTITIONER_ID ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS) DEFAULT_TRANSCRIBER,CA_GET_DEFAULT_NOTES(?,?,a.SPECIALITY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE from op_patient_queue a where a.FACILITY_ID=? and a.PRACTITIONER_ID=? ");

	if(!speciality_code.equals(""))
		transReqQry.append("and a.SPECIALITY_CODE=? ");
	if(!patientId.equals(""))
		transReqQry.append("and a.PATIENT_ID =? ");
	if(!locn_type_crit.equals(""))
		transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");
	
	if(!location_code.equals(""))
		transReqQry.append("and a.PAT_CURR_LOCN_CODE =? ");
	if(!service_code.equals(""))
		transReqQry.append("and a.SERVICE_CODE=? ");

		transReqQry.append(" Order By LOCN_CODE ");

		try
		{

			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(transReqQry.toString());
			int count1=0;
			
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,practitionerId);
			
			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);

			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,practitionerId);

			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);
			
			rs = stmt.executeQuery();

			while(rs.next())
			{

				patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
				encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
				pline = rs.getString("Pline")==null?"":rs.getString("Pline");
				pline =pline.replaceAll("\\|",",");
				rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
				attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
				transcriber = rs.getString("DEFAULT_TRANSCRIBER")==null?"":rs.getString("DEFAULT_TRANSCRIBER");
				notes = rs.getString("DEFAULT_NOTE")==null?"":rs.getString("DEFAULT_NOTE");

				hash_key = patient_id+"~"+encounter_id;
				hash_value = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;

				if(!multiTransBean.ContainsKey(hash_key))
				{
					multiTransBean.addToHashMap(hash_key,hash_value);
				}
			
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();



			putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
	else if(operation_mode.equals("addToBean"))
	{
		
		eCA.PatientBannerGroupLine multiTransBean = null;

		String hashKey ="";
		String hashValue ="";
		
		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");

		try{
		rowTok = new StringTokenizer(final_string,"`");

		while(rowTok.hasMoreTokens())
		{
			
			arrVal = (String) rowTok.nextToken();
			colTok = new StringTokenizer(arrVal,"~");

			while(colTok.hasMoreTokens())
			{

				hashKey =(String)colTok.nextToken()+"~"+(String)colTok.nextToken();
				
				colTok.nextToken();
				colTok.nextToken();
				hashValue = arrVal;

				if(!multiTransBean.ContainsKey(hashKey))
				{
					multiTransBean.addToHashMap(hashKey,hashValue);
				}

			}
	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}


		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);


	}
	else if(operation_mode.equals("remove"))
	{
		
		String patient_id ="";
		String encounter_id ="";
		String mode ="";
		
		eCA.PatientBannerGroupLine multiTransBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
				
		arrVal = patient_id+"~"+encounter_id;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		if(mode.equals("Add"))
		{
			
			if(!(multiTransBean.returnList1().contains(arrVal)))
			{
				multiTransBean.addRecordstoLine1(arrVal);
			}
		}
		else if (mode.equals("Rem"))
		{
			if((multiTransBean.returnList1().contains(arrVal)))
			{
				multiTransBean.remRecordsFromLine1(arrVal);
			}

		}


		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);	

	}
	else if(operation_mode.equals("addNoteToBean"))
	{
		eCA.PatientBannerGroupLine multiTransBean = null;
		
		String patient_id ="";
		String encounter_id ="";
		String transcriber ="";
		String note_type ="";
		//String mode ="";

		String hash_key ="";
		String hash_value ="";
		
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		transcriber = request.getParameter("transcriber")==null?"":request.getParameter("transcriber");
		note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		
		hash_key = patient_id+"~"+encounter_id;
		hash_value = patient_id+"~"+encounter_id+"~"+transcriber+"~"+note_type;
		


		if(!multiTransBean.ContainsKey(hash_key))
		{
			multiTransBean.addToHashMap(hash_key,hash_value);
		}
		
		
		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);
	}
	else if(operation_mode.equals("getSpecialty"))
	{

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		
		String practitionerId ="";
		String speciality_code ="";
		String primary_speciality ="";

		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");

		String speciality_qry= "select PRIMARY_SPECIALITY_CODE, am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,1 ) PRIMARY_SPECIALITY from am_practitioner where PRACTITIONER_ID= ? ";

		try
		{
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(speciality_qry);
			stmt.setString(1,locale);
			stmt.setString(2,practitionerId);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
							
				speciality_code = rs.getString("PRIMARY_SPECIALITY_CODE")==null?"":rs.getString("PRIMARY_SPECIALITY_CODE");
				primary_speciality = rs.getString("PRIMARY_SPECIALITY")==null?"":rs.getString("PRIMARY_SPECIALITY");
			}

				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();

				out.println("parent.MultiTransRequestCriteriFrame.MultiTransRequestCriteriaForm.speciality.value='"+primary_speciality+"'");
				out.println("parent.MultiTransRequestCriteriFrame.MultiTransRequestCriteriaForm.speciality_code.value='"+speciality_code+"'");
				


		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}

	}
	else if(operation_mode.equals("selCount"))
	{
		
	
		eCA.PatientBannerGroupLine multiTransBean = null;
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		
		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		
		if(multiTransBean.returnHashMap().isEmpty())
		{
			
			out.println("callfunction('false');");
		}
		else
		{
			out.println("callfunction('true');");
			
		}

	}


            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
