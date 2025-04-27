package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewclinicalnotenotecontentheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewClinicalNoteNoteContentHeader.jsp", 1709116439885L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n27/02/2012\t  IN031538\t\t Menaka V\t In discharge summary note we have put the variable for Admitting doctor\n\t\t\t\t\t\t\t\t\t\t but the data is not showing in the report Admitting Doctor and Attending Doctor, both Name should print in discharge summary and all other notes\t\n15/05/2012\t  IN032721\t\tRamesh G\t\tWhen we Click on Print Preview the Date is not displayed in the examination date component.\t\n22/02/2013\t  IN036821\t\tChowminya G\t\t  Reporting Practitioner name not coming in the CA report\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History    \tName\t\t\t\tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n30/11/2015\t  \tIN058541/IN057113\tKarthi\t\t\t\t\t\t\t\t\t\t\t\tSystem does not prompt for PIN in Record Charts Function\t\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"JavaScript\" src=\'../js/PhysicianNote.js\'></script>\n<script Language=\"JavaScript\" src=\'../../eCA/js/ViewClinicalNote.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n</head>\n<body  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'heading\' id=\'heading\'>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' id=\'tb1\' align=\'center\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<tr>\n<td class=\'COLUMNHEADER\' ><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td><!-- <td class=\'COLUMNHEADER\'  width=\'25%\'></td><td class=\'COLUMNHEADER\'  width=\'50%\'></td> -->\n<td class=\'COLUMNHEADER\' align=\'right\' width=\'15%\'><input type=\"BUTTON\" class=\"BUTTON\" name=\"print\" id=\"print\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onClick=\"printNotes()\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<input type=\"button\" class=\'Button\' name=\"open_winodow\" id=\"open_winodow\" title=\'Zoom\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="+\' onClick=\"reSize(this)\"></td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<tr>\n<td class=\'white\' ><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b>\n</td>\n</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</table>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' name=\'facilityid\' ></input>\n<input type=\'hidden\' name =\'authorized_by_name\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n<input type=\'hidden\' name =\'print_date_time\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n<input type=\'hidden\' name =\'last_modified_by_name\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n<input type=\"hidden\" name =\"performed_by_name\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name =\'speciality_code\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n<input type=\"hidden\" name =\"event_date_time\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name =\"note_type\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name =\'patient_age\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n<input type=\'hidden\' name =\'sex\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' >\n<input type=\'hidden\' name =\'specialty_name\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n<input type=\'hidden\' name =\'note_header_desc\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n<input type=\'hidden\' name =\'patient_name\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\n<input type=\'hidden\' name =\'med_service\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >\n<input type=\'hidden\' name =\'facility_name\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >\n<input type=\"hidden\" name =\"loggedUser\"\t\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"dis_summ_disclaimer_txt\" id=\"dis_summ_disclaimer_txt\"\t\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"speciality\" id=\"speciality\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"location_name\" id=\"location_name\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"discharge_date\" id=\"discharge_date\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"attend_pract\" id=\"attend_pract\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"admitting_practitioner\" id=\"admitting_practitioner\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"><!-- IN031538-->\n<input type=\"hidden\" name=\"siteName\" id=\"siteName\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"contr_mod_accession_num\" id=\"contr_mod_accession_num\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">  <!-- [IN032721] -->\n<input type=\"hidden\" name=\"l_conf_pin_req_yn\" id=\"l_conf_pin_req_yn\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> <!-- ML-MMOH-CRF-0335 - IN057113 -->\n</form>\n</body>\n</html>\n\n<!--\n\nFor testing\nupdate ca_encntr_note\nset note_content=\'<HTML><HEAD><LINK rel=\'||\'\'\'\'||\'stylesheet\'||\'\'\'\'||\'type=\'||\n\'\'\'\'||\'text/css\'||\'\'\'\'||\' \n\'><body><table><tr wrap>For testing in Physican notes<For testing in Physican notesFor testing in Phy\nwhere accession_num=\'01984\'\n/-->\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String accession_num=request.getParameter("accession_num");
String function_id= request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
//out.println("<script>alert('function_id ="+function_id+"=');</script>");
String no_modal=request.getParameter("no_modal");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //[IN032721] 
String sql			="";
String sqltype			="";
Connection con		= null;
ResultSet rs		= null ,rs1 = null;
PreparedStatement stmt		= null,pstmt1 = null;
String note_type_desc ="";
String note_type      ="";
String authorized_by_name	=	"";
String print_date_time	    =	"";
String last_modified_by_name =	"";
String performed_by_name	= "";
String speciality_code	="";
String specialty_name	="";
String event_date_time	= "";
String patient_age	= "";
String patient_name	= "";
String sex	= "";
String facility_name	= "";
String note_header_desc	= "";
String med_service	= "";
String	loggedUser				= "";
String	dis_summ_disclaimer_txt				= "";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityid		= ""; //(String) session.getValue("facility_id");
loggedUser              = (String) session.getValue("login_user");
String patient_class = "";
String location = "";
String speciality = "";
String admission_date = "";
String discharge_date = "";
String attend_pract = "";
String sqlSite = "";
String siteName = "";
String admitting_practitioner="";//IN031538

//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
//ML-MMOH-CRF-0335 - IN057113 - End

 sqltype= "select  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT,to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time,  AM_GET_DESC.AM_PRACTITIONER(A.authorized_by_id,?,'2') Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,?) from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_PRACTITIONER(a.last_amended_by_id,?,'1') last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group_lang_vw ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type and ib.language_id = ? )  note_header_desc,note_type,performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,'1') performed_by_name, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') service_name ,sex,get_age(date_of_birth) age,patient_name,a.facility_id facilityID from ca_encntr_note a,mp_patient b where	a.patient_id=b.patient_id and a.accession_num=?"; //IN036821 - performed_by_name to get long Description

	try
	{
		con		= ConnectionManager.getConnection(request);
		sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc FROM ca_encntr_note a where  a.accession_num=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,accession_num);
		rs=stmt.executeQuery();
		
		if(rs!=null)
		{
			if(rs.next())
			{
				note_type_desc=rs.getString("note_type_desc");
			}
		}


		    pstmt1	=	con.prepareStatement(sqltype);
			pstmt1.setString	(	1,	locale	);
			pstmt1.setString	(	2,	locale	);
			pstmt1.setString	(	3,	locale	);
			pstmt1.setString	(	4,	locale	);
			pstmt1.setString	(	5,	locale	);
			pstmt1.setString	(	6,	locale	);
			pstmt1.setString	(	7,	locale	);
			pstmt1.setString	(	8,	locale	);
		//	pstmt1.setString	(9,	facilityid	);			
			pstmt1.setString	(9,	accession_num );

			rs1		=	pstmt1.executeQuery();
			if(rs1.next())
			{
				event_date_time         =	rs1.getString("event_date_time");
				authorized_by_name		=	rs1.getString("Authorized_by_name");
				print_date_time			=	rs1.getString("print_date_time");
				last_modified_by_name	=	rs1.getString("last_modified_by_name");
				note_type		        =	rs1.getString("note_type");
				performed_by_name	    =	rs1.getString("performed_by_name");
				patient_age				=	rs1.getString("age");
				sex					    =	rs1.getString("sex");
				facility_name			=	rs1.getString("facility_name");
				note_header_desc		=	rs1.getString("note_header_desc");
				patient_name		    =	rs1.getString("patient_name");
				med_service			    =	rs1.getString("service_name");
				dis_summ_disclaimer_txt	=	rs1.getString("DIS_SUMM_DISCLAIMER_TXT");
				facilityid =  rs1.getString("facilityID");
				
                if(sex.equals("M"))
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			    else if (sex.equals("F"))
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			    else 
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(rs1 !=null) rs1.close();
			if(pstmt1 !=null) pstmt1.close();

			//sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,?,'2')  attending_practitioner  from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			//sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner  from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.ADMIT_PRACTITIONER_ID,?,1) admitting_practitioner from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,locale);
			stmt.setString(7,locale);
			stmt.setString(8,facilityid);
			stmt.setString(9,encounter_id);// one more parameter setting is missed by someone - by Dinesh T

			rs = stmt.executeQuery();

			if(rs != null)
			{
				if(rs.next())
				{
					patient_class = rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
					speciality = rs.getString("specialty_name") == null ? "" : rs.getString("specialty_name");
					location = rs.getString("locn_name") == null ? "" : rs.getString("locn_name");
					admission_date = rs.getString("visit_adm_date") == null ? "" : rs.getString("visit_adm_date");
					discharge_date = rs.getString("DISCHARGE_DATE_TIME") == null ? "" : rs.getString("DISCHARGE_DATE_TIME");
					attend_pract = rs.getString("attending_practitioner") == null ? "" : rs.getString("attending_practitioner");
					admitting_practitioner=rs.getString("admitting_practitioner") == null ? "" : rs.getString("admitting_practitioner");//IN031538
				}
			}

			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			sqlSite = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
			stmt	=	con.prepareStatement(sqlSite);
			stmt.setString(1,locale);
			rs		=	stmt.executeQuery();
			if(rs !=null)
			{
				rs.next();
				siteName = rs.getString(1);
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}


	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

if(no_modal !=null && no_modal.equals("Y")){

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!function_id.equals("SPCL_NOTE")){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block15Bytes, _wl_block15);

}else{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

}


            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(authorized_by_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(print_date_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(last_modified_by_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialty_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(note_header_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(med_service));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(loggedUser));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dis_summ_disclaimer_txt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(location));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(admission_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(discharge_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(attend_pract));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(admitting_practitioner));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(siteName));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( conf_pin_req_yn ));
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Notescontent.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Zoom.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
