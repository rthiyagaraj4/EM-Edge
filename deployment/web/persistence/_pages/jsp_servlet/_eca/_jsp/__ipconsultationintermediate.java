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

public final class __ipconsultationintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/IPConsultationIntermediate.jsp", 1731066443013L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413     Dinesh T    ARTEMIS - CRF
-----------------------------------------------------------------------------------------------
*/
	//HashMap dataMap=null;
	
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");


	String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

	if(operation_mode.equals("validate"))
	{
		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

		int sizes=ipConsultListBean.returnConsList().size();
		if(sizes==0)
		{
			out.println("callfunction(\""+sizes+"\");");
		}
		putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);
	}
	else if(operation_mode.equals("validatecreate"))
	{
		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

		int sizes=ipConsultListBean.returnConsList().size();
		if(sizes==0)
		{
			out.println("callfunction(\""+sizes+"\");");
		}
		putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
	}
	else if(operation_mode.equals("create"))
	{

		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
	
		String pline = request.getParameter("pline")==null?"":request.getParameter("pline");

		String Admission_date_time = request.getParameter("Admission_date_time")==null?"":request.getParameter("Admission_date_time");
		String Specialty_code = request.getParameter("Specialty_code")==null?"":request.getParameter("Specialty_code");
		String Location_code = request.getParameter("Location_code")==null?"":request.getParameter("Location_code");
		
		String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String attend_practitioner_id = request.getParameter("attend_practitioner_id")==null?"":request.getParameter("attend_practitioner_id");
		String create_type = request.getParameter("create_type")==null?"":request.getParameter("create_type");
		String splty_code = request.getParameter("splty_code")==null?"":request.getParameter("splty_code");

		String arrVal ="";

	




	if(create_type.equals("S"))
	{
		arrVal = attend_practitioner_id+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
	}
	else
	{
		arrVal = Location_code+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
	}


	if(mode.equals("Add"))

	{
		if(!ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.addtoConsList(arrVal);
		}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}
	

	putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
}
else if(operation_mode.equals("update"))
{


		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

	//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String cons_ref_id = request.getParameter("cons_ref_id")==null?"":request.getParameter("cons_ref_id");
	String consult_date_time = request.getParameter("consult_date_time")==null?"":request.getParameter("consult_date_time");
	String order_catalog = request.getParameter("order_catalog")==null?"":request.getParameter("order_catalog");
	String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");
	String p_episode_id = request.getParameter("p_episode_id")==null?"":request.getParameter("p_episode_id");
	String episode_visit_num = request.getParameter("episode_visit_num")==null?"":request.getParameter("episode_visit_num");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	String source_code = request.getParameter("source_code")==null?"":request.getParameter("source_code");
	String source_type = request.getParameter("source_type")==null?"":request.getParameter("source_type");



	String arrVal ="";

		
	arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+order_catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitioner_id+"~"+source_code+"~"+source_type;

	if(mode.equals("Add"))
	{
		if(!ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.addtoConsList(arrVal);
		}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}

	putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);

}
else if(operation_mode.equals("cancel"))
{
	eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

	//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String cons_ref_id = request.getParameter("cons_ref_id")==null?"":request.getParameter("cons_ref_id");
	String consult_date_time = request.getParameter("consult_date_time")==null?"":request.getParameter("consult_date_time");
	String order_catalog = request.getParameter("order_catalog")==null?"":request.getParameter("order_catalog");
	String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");
	String p_episode_id = request.getParameter("p_episode_id")==null?"":request.getParameter("p_episode_id");
	String episode_visit_num = request.getParameter("episode_visit_num")==null?"":request.getParameter("episode_visit_num");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	String source_code = request.getParameter("source_code")==null?"":request.getParameter("source_code");
	String source_type = request.getParameter("source_type")==null?"":request.getParameter("source_type");
	String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");



	String arrVal ="";

		
	arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+order_catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitioner_id+"~"+source_code+"~"+source_type+"~"+order_id+"~"+order_line_num;

	if(mode.equals("Add"))
	{
		if(!ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.addtoConsList(arrVal);
		}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}

	putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);
}
else if(operation_mode.equals("dupChk"))
{
	
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	String facility_id		=	(String) session.getValue("facility_id");
	String cons_list_desc = request.getParameter("cons_list_desc")==null?"":request.getParameter("cons_list_desc");

	try{

		con =  ConnectionManager.getConnection(request);

		String dupChkQry = "select 1 from CA_CONS_LIST_HDR g where g.CONS_LIST_DESC =? and g.FACILITY_ID =?" ;

		String code_exist="N";
		stmt = con.prepareStatement(dupChkQry);

		stmt.setString(1,cons_list_desc+1);
		stmt.setString(2,facility_id);

		rs = stmt.executeQuery();

		while(rs.next())
		{
			code_exist ="Y";
			break;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	

		out.println("dupDescCheck(\""+code_exist+"\");");


	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in IPConsultationIntermediate.jsp duplicate chk" + e);//COMMON-ICN-0181

	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}
}
else if(operation_mode.equals("patIDValid"))
{


	Connection con = null;
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	String facilityid=(String)session.getValue("facility_id");
	String patientIdStatus="";

	patdata.setFacility_id(facilityid);

	try
	{

		con =  ConnectionManager.getConnection(request);
		String pat_id = request.getParameter("patientId");
		patientIdStatus = patdata.CheckStatus(con,pat_id);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception caught in IPConsultationIntermediate.jsp validate pat_id" + e);

	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}

	

	out.println("patValidCheck(\""+patientIdStatus+"\");");


	

}
else if(operation_mode.equals("clearBean"))
{
		//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");


		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

		ipConsultListBean.clearBean();

		putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);

	
}
else if(operation_mode.equals("addAllToBean"))
{
	eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

		ipConsultListBean.clearBean();

		putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	String facility_id		=	(String) session.getValue("facility_id");
	String ca_practitioner_id		=	(String) session.getValue("ca_practitioner_id");

	//ipConsultListBean = null;		
	//String queryString = request.getQueryString();		
	Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet prs=null;
	ArrayList selectedList =new ArrayList(); 
	String patientId ="";
	String practitionerId ="";
	String speciality_code ="";
	String location_code ="";
	String service_code ="";
	String cons_date ="";
	String cons_time ="";
	String create_type ="";
	String res_mode ="";
	String checked ="";
	String arrVal ="";
	StringBuffer consListQry = new StringBuffer();
	String pline ="";
	String rsAdmission_date_time ="";
	String rsSpecialty_code="";
	String rsSpecialty_desc="";
	String rsLocation_code ="";
	String patient_id ="";
	String encounter_id ="";
	String attend_practitioner_id ="";
	//String preattend_practitioner_id ="";
	//String specialty_desc ="";
	String nursing_unit_desc ="";
	//String practitioner_name ="";
	//String display_admission_date="";
	String control="";
	String max_cons_per_pract="";
	String 	max_cons_per_splty="";
	String 	cons_back_date="";
	String 	amd_cons_list="";
	String 	min_cons_duration="";
	String control_value="";
	String disabled="";
	//String className1="";
	String splty_code="";
	String referral_id="";
	String bedNo="";//IN29413
	///String	lower_limit				=	"";	
	//String	upper_limit				=	"";
	String classValue = "QRYEVEN";
	//StringBuffer query_string		=	new StringBuffer();

	int		rowCnt					=	0;
	int i = 0;

	boolean flag = true;

	patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
	practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
	speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
	location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
	service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
	
	cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
	cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
	res_mode			=	(request.getParameter("res_mode")==null)	?	""	:	request.getParameter("res_mode");
	create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
	bedNo			=	(request.getParameter("bedNo")==null)	?	"%"	:	request.getParameter("bedNo")+"%";//IN29413

	bean_key =practitionerId+cons_date+cons_time;

	ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

	//Added By Archana Dhal on 5/3/2010 related to IN021047.
	if(!locale.equals("en"))
	{
		cons_date	= com.ehis.util.DateUtils.convertDate(cons_date,"DMY",locale,"en");
		cons_time	= com.ehis.util.DateUtils.convertDate(cons_time,"HM",locale,"en");
	}
	
	control="select MAX_CONS_PER_PRACT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY MAX_CONS_PER_SPLTY,CONS_BACK_DATE CONS_BACK_DATE,AMD_CONS_LIST AMD_CONS_LIST,MIN_CONS_DURATION MIN_CONS_DURATION from ca_cons_param";
	//String speciality_query="select PRIMARY_SPECIALITY_CODE splty_code from am_practitioner where  practitioner_id=?";

	consListQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?) Pline,REFERRAL_ID, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME ,b.SPECIALTY_CODE,b.SPECIALTY_CODE  splty_code,am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,?,2) SPECIALTY_DESC,IP_get_desc.IP_NURSING_UNIT(?,b.NURSING_UNIT_CODE,?,2) nursing_unit_desc,b.NURSING_UNIT_CODE,nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID,CA_GET_CONS_LIST_CONTROL(");
	//if (create_type.equals("S"))
	consListQry.append("b.ATTEND_PRACTITIONER_ID");
	//else
	//consListQry.append("?");
		
	consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b where b.facility_id= ? ");

	if(!speciality_code.equals(""))
		consListQry.append("and b.SPECIALTY_CODE=? ");
	if(!patientId.equals(""))
		consListQry.append("and b.PATIENT_ID =? ");

	if(!location_code.equals(""))
		consListQry.append("and b.NURSING_UNIT_CODE =? ");
	if(!service_code.equals(""))
		consListQry.append("and b.SERVICE_CODE=? "); //
	if(create_type.equals("S"))
		consListQry.append("and b.SPECIALTY_CODE=?  "); //
	consListQry.append("AND UPPER(b.BED_NUM) LIKE UPPER(?)");//IN29413
	if (create_type.equals("S"))
	{
		consListQry.append("AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID=b.ATTEND_PRACTITIONER_ID AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID and TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))"); 
	}
	else
	{ 				
	//if(create_type.equals("P"))
		consListQry.append("and (b.ATTEND_PRACTITIONER_ID =?  "); //

	if(create_type.equals("O"))
		consListQry.append("or b.ATTEND_PRACTITIONER_ID = ?  "); //P_MIN_CONS_DURATION

		consListQry.append(" or exists (select 1 from PR_REFERRAL_REGISTER where REFERRAL_ID=b.REFERRAL_ID AND TO_PRACT_ID=?)) AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID=? AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID AND  TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))  "); //P_MIN_CONS_DURATION
		}
		consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') "); //Added By Archana Dhal on 5/3/2010 related to IN021047.
	
	
	try
	{

	con =  ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(control);
	prs = pstmt.executeQuery();
	while(prs.next())
	{
		max_cons_per_pract=prs.getString("MAX_CONS_PER_PRACT");
		max_cons_per_splty=prs.getString("MAX_CONS_PER_SPLTY");
		cons_back_date=prs.getString("CONS_BACK_DATE");
		amd_cons_list=prs.getString("AMD_CONS_LIST");
		min_cons_duration=prs.getString("MIN_CONS_DURATION");
	}
	if(prs!=null) prs.close();
	if(pstmt!=null)pstmt.close();
	stmt = con.prepareStatement(consListQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	int count1=0;
	stmt.setString(++count1,locale);
	stmt.setString(++count1,locale);
	stmt.setString(++count1,facility_id);
	stmt.setString(++count1,locale);
	//if (!create_type.equals("S"))
	//stmt.setString(++count1,practitionerId);
	//stmt.setString(++count1,splty_code);
	stmt.setString(++count1,cons_date);
	stmt.setString(++count1,cons_time);
	stmt.setString(++count1,max_cons_per_pract);
	stmt.setString(++count1,max_cons_per_splty);
	stmt.setString(++count1,min_cons_duration);
	stmt.setString(++count1,facility_id);
	if(!speciality_code.equals(""))
	stmt.setString(++count1,speciality_code);
	if(!patientId.equals(""))
	stmt.setString(++count1,patientId);
	if(!location_code.equals(""))
	stmt.setString(++count1,location_code);
	if(!service_code.equals(""))
	stmt.setString(++count1,service_code);
	if(create_type.equals("S"))
	stmt.setString(++count1,practitionerId); // value is speciality only

	stmt.setString(++count1,bedNo);//IN29413

	if (create_type.equals("S"))
		{
		//stmt.setString(++count1,practitionerId);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_time);
		stmt.setString(++count1,min_cons_duration);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_time);
		stmt.setString(++count1,min_cons_duration);
		}
	else{	
	//if(create_type.equals("P"))
		stmt.setString(++count1,practitionerId);

	

	if(create_type.equals("O"))
		stmt.setString(++count1,ca_practitioner_id);
	
		stmt.setString(++count1,practitionerId);
		stmt.setString(++count1,practitionerId);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_time);
		stmt.setString(++count1,min_cons_duration);
		stmt.setString(++count1,cons_date);
		stmt.setString(++count1,cons_time);
		stmt.setString(++count1,min_cons_duration);
	}
	//Added By Archana Dhal on 5/3/2010 related to IN021047.
	stmt.setString(++count1,cons_date);
	stmt.setString(++count1,cons_time);
	
	rs = stmt.executeQuery();


	while(rs.next())
	{
		if(i % 2 == 0) classValue = "QRYEVEN";
		else classValue = "QRYODD";	
		
		flag = false ;
		rowCnt++;
		patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
		encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
		pline = rs.getString("Pline")==null?"":rs.getString("Pline");
		pline =pline.replaceAll("\\|",",");
		referral_id = rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
		rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
		rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
		rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
		nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");
		attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
		control_value = rs.getString("control_value")==null?"":rs.getString("control_value");
		splty_code = rs.getString("splty_code")==null?"":rs.getString("splty_code");
		
		//arrVal = rsLocation_code+"~"+pline+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id;

		if(create_type.equals("S"))
		{
			arrVal = attend_practitioner_id+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;	
		}
		else
		{
			arrVal = rsLocation_code+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
		}
		

		if(res_mode.equals(""))
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
				checked ="";
			}
			else
			{
				disabled="";
				checked ="checked";

				if(!ipConsultListBean.returnConsList().contains(arrVal))
				{
					ipConsultListBean.addtoConsList(arrVal);
				}
			}
		}
		else
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
			}
			else
			{
				disabled="";
			}
			
			
			if(selectedList.contains(arrVal))
			{
				checked ="checked";
			}
			else
			{
				checked ="";
			}
		}

		i++;
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();

		putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);

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
else if(operation_mode.equals("clearBeanUpd"))
{
		//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");


		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

		ipConsultListBean.clearBean();

		putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);

	
}
else if(operation_mode.equals("UpdateBean"))
{

	
		String bean_id = "Or_FutureOrder" ;
		String bean_name = "eOR.FutureOrder";
		HashMap bill_dtls				= null;
		HashMap setBills_dtls			= null;

		String patient_id = "";
		String encounter_id = "";
		String catalog = "";
		String total_payable = "";
		String patient_payable = "";
		String patient_paid_amt = "";
		String preapp_yn = "";

		patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		catalog = request.getParameter("catalog")==null?"":request.getParameter("catalog");
		total_payable = request.getParameter("total_payable")==null?"":request.getParameter("total_payable");
		patient_payable = request.getParameter("patient_payable")==null?"":request.getParameter("patient_payable");
		patient_paid_amt = request.getParameter("patient_paid_amt")==null?"":request.getParameter("patient_paid_amt");
		preapp_yn = request.getParameter("preapp_yn")==null?"":request.getParameter("preapp_yn");
		
		eOR.FutureOrder bean = (eOR.FutureOrder)getBeanObject( bean_id, bean_name, request ) ;

		eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();

	
		bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patient_id+encounter_id+catalog);



				setBills_dtls		= new HashMap();

				setBills_dtls.put("charged_yn"       , bill_dtls.get("charged_yn"));
				setBills_dtls.put("total_payable"    , total_payable);
				setBills_dtls.put("patient_payable"  , patient_payable);
				setBills_dtls.put("quantity"         , "1");
				setBills_dtls.put("incl_excl_action" , bill_dtls.get("incl_excl_action"));
				setBills_dtls.put("incl_excl_action_orginal" , bill_dtls.get("incl_excl_action_orginal"));
				setBills_dtls.put("preapp_yn"        , preapp_yn);
				setBills_dtls.put("patient_paid_amt" , patient_paid_amt);
				setBills_dtls.put("bl_panel_str"     , bill_dtls.get("bl_panel_str"));
				setBills_dtls.put("serv_panel_ind"   , bill_dtls.get("serv_panel_ind"));
				setBills_dtls.put("serv_panel_code"  , bill_dtls.get("serv_panel_code"));
				setBills_dtls.put("p_episode_type"	 , bill_dtls.get("p_episode_type"));
				setBills_dtls.put("p_episode_id"	 , bill_dtls.get("p_episode_id"));
				setBills_dtls.put("p_visit_id"		 , bill_dtls.get("p_visit_id"));
				setBills_dtls.put("Future_order_yn"		 , bill_dtls.get("Future_order_yn"));
				setBills_dtls.put("error_text"		 , bill_dtls.get("error_text"));



				orderEntryBillBean.setOrderBillDtls(patient_id+encounter_id+catalog, setBills_dtls);

				

				putObjectInBean(bean_id,bean,request);

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
