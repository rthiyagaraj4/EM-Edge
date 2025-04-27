package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __visitvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/VisitValidation.jsp", 1743076371929L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n     \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t alert(getMessage(\'MAX_FIRST_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\tdocument.forms[0].no_slots.value=\'\';\n\t\t\t\t\t\t   \n\t\t\t\t\t  \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\talert(getMessage(\'MAX_OTHER_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\n\t\t\t\t\t   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t  alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";\n\t\t\t\t   ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t  alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t     ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t       document.forms[0].no_slots.value==";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";\n\t\t     ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t   document.forms[0].no_slots.value==";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =";\n\t\t\t\t\t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t   document.forms[0].no_slots.value=\'\';\n\t\t\t\t\t   alert(getMessage(\'MAX_FIRST_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t   document.forms[0].no_slots.value=\'\';\n\t\t\t\t\t   alert(getMessage(\'MAX_OTHER_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t     ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t       document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\talert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t document.forms[0].To_timeval.value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\tdocument.forms[0].pract_type1.innerHTML=\"&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t    document.forms[0].pract_type1.innerHTML==\"\";\n\t\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\tdocument.forms[0].pract_type1.innerHTML=\"\";\n\t\t  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\tdocument.forms[0].speciality.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t    document.forms[0].disp_next.checked=true;\n\t\t\tdocument.forms[0].disp_next.disabled=false;\n\t\t\tif (document.forms[0].speciality.value==\"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].speciality.value=\"\";\n\t\t        document.forms[0].disp_next.checked=false;\n\t\t\t    document.forms[0].disp_next.disabled=true;\n\t\t\t}\n\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\tdocument.forms[0].pat_cat.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tdocument.forms[0].pat_cat.disabled=true;\n\t\t  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\tdocument.forms[0].pat_cat.value=\"*O\";\n\t\t\tdocument.forms[0].pat_cat.disabled=true;\n\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t     \tdocument.forms[0].pat_cat.value=\"*O\";\n\t\t\tdocument.forms[0].pat_cat.disabled=true;\n\t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\tif (document.forms[0].pat_cat.value==\"\")\n\t\t\t\t{\t\t\n\t\t\t\tdocument.forms[0].pat_cat.value=\"*O\";\n\t\t\t\tdocument.forms[0].pat_cat.disabled=true;\n\t\t \t\t}\n\t\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\talert(getMessage(\'APPT_OVERLAP_NOT_PROCEED\',\'OA\'));\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="               \n\t\t\t   alert(getMessage(\'MAX_FIRST_VISITS_REACHED\',\'OA\'));\n\t\t\t   document.forms[0].visit_type_short_desc.value=\'\'\n\t\t\t   document.forms[0].first_visit_flag.value=\'Y\';\n\t\t\t   document.forms[0].no_slots.value=\'\' ;\n\t\t\t   ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t   alert(getMessage(\'MAX_OTHER_VISITS_REACHED\',\'OA\'));\n\t\t\t   document.forms[0].visit_type_short_desc.value=\'\'\n\t\t\t   document.forms[0].other_visit_flag.value=\'Y\';\n\t\t\t   document.forms[0].no_slots.value=\'\' ;\n\t\t\t   ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t   alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\')); \n\t\t       document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =";\n\t\t      ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t   alert(getMessage(\'MAX_FIRST_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t\t   document.forms[0].no_slots.value=\'\' ;\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t   alert(getMessage(\'MAX_OTHER_VISITS_REACHED\',\'OA\'));\n\t\t\t\t\t\t   document.forms[0].no_slots.value=\'\' ;\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t      alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\')); \n\t\t\t\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =";\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t   alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" ;\n\t\t   ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t   alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t   document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ;\n\t\t\t   ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =";\n\t\t\t ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t\t\t\t document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t alert(getMessage(\'CONTINUOUS_SLOT_ERROR\',\'OA\'));\n\t\t     document.forms[0].no_slots.value=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\t\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
Connection con = null;
ResultSet rs=null;
Statement stmt =null;
PreparedStatement pstmt =null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	CallableStatement cstmt = null;
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String facilityId				=(String) session.getValue("facility_id");
	String clinic_code				=(String) hash.get("clinic_code");
	String practitioner_id			=(String) hash.get("practitioner_id");
	String clinic_date				=(String) hash.get("clinic_date");
	
	String steps					=(String) hash.get("steps");
		
	String fromTime					=(String) hash.get("fromTime");


	String toTime					=(String) hash.get("toTime");
	String no_of_slots				=(String) hash.get("no_of_slots");
	String firstvisit				=(String) hash.get("firstvisit");
	String overbookedyn				=(String) hash.get("overbookedyn");
	String calling_from				=(String) hash.get("calling_from");
	String appt_ref_no				=(String) hash.get("appt_ref_no");
	String patient_id				=(String) hash.get("patient_id");
	String visit_limit_rule			=(String) hash.get("visit_limit_rule");
	String slot_appt_ctrl			=(String) hash.get("slot_appt_ctrl");
	String Forced					=(String) hash.get("Forced");
	String visit_type_ind				=(String) hash.get("visit_type_ind");	
	String from_appt_date 			= (String) hash.get("from_appt_date");
	String from_practitioner_id		= (String) hash.get("from_practitioner_id");
	String from_clinic_code			= (String) hash.get("from_clinic_code");

	if (steps==null)		steps="";
	
	if (patient_id==null)		patient_id="";
	if (calling_from==null) calling_from="";
	if (no_of_slots==null)	no_of_slots="";
	if (firstvisit==null)	firstvisit="";
	if (clinic_code==null)	clinic_code="";
	if (fromTime==null)	fromTime="";
	if (toTime==null)	toTime="";
	if (overbookedyn==null)	overbookedyn="";
	if (calling_from==null)	calling_from="";
	if (practitioner_id==null)	practitioner_id ="";
	if (appt_ref_no==null)	appt_ref_no ="";
	if (visit_limit_rule==null)	visit_limit_rule ="";
	if (visit_type_ind==null)	visit_type_ind="";
	
	if (from_appt_date==null)	from_appt_date="";
	if (from_practitioner_id==null)	from_practitioner_id="";
	if (from_clinic_code==null)	from_clinic_code="";

	if(Forced==null || Forced.equals("null") || Forced.equals("")){
		Forced="N";
	}

	String wd1="0";
	String wd2="0";
	String max_slots_for_first_visit="";
	String time_table_type="",max_other_visits="",total_other_visits="";
	String total_first_visit="";
	boolean alert_flag=true;
	if (no_of_slots==""||no_of_slots.equals("")) no_of_slots="0";
	int end_time_value =0,total_other_visits_value=0,max_other_visits_value=0;
	int max_visit=0,tot_first=0;


	int no_of_slots_value = Integer.parseInt(no_of_slots);
	String function=(String) hash.get("function");
	if(function==null || function.equals("null")){
		function="";
	}

	/* Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1 */
	cstmt = con.prepareCall("{? = call OA_CONT_SLT_YN(?,?,?,?,?,?)}");

	cstmt.registerOutParameter( 1, Types.VARCHAR );
	cstmt.setString( 2, facilityId );
	cstmt.setString( 3, clinic_code );
	cstmt.setString( 4, practitioner_id );
	cstmt.setString( 5, clinic_date );
	cstmt.setString( 6, fromTime );
	cstmt.setInt( 7, no_of_slots_value );

	cstmt.execute() ;

	String cont_slt_yn = cstmt.getString( 1 ); 
	if(cont_slt_yn == null) cont_slt_yn = "";
	
	/* End ML-BRU-CRF-0628.1 */
	
	if (steps.equals("1") && function.equals("RuleBasedTransfer")){

			StringBuffer sql1=new StringBuffer("");
			sql1.append("select count(1) total from oa_appt  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ");
			rs = stmt.executeQuery(sql1.toString());
			sql1.setLength(0);
			String total="";
			while(rs.next()){
				total = rs.getString("total");
				if (!(total.equals("0"))){
					alert_flag=false; 
					no_of_slots="1";
            _bw.write(_wl_block3Bytes, _wl_block3);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}
			if (rs!=null) rs.close();
			
			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag=false; 
					no_of_slots="1";
            _bw.write(_wl_block3Bytes, _wl_block3);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}

			if (alert_flag){
				String sql2="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0)+nvl(TOTAL_FIRST_VISITS_BLOCKED,0) total_first_visit ,nvl(max_other_visits,0) max_other_visits ,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0) total_other_visits from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
				rs = stmt.executeQuery(sql2);
				while(rs.next()){
					end_time_value= rs.getInt("end_time");
					wd1 = rs.getString("max_first_visits");
					wd2=rs.getString("total_first_visit");
					max_other_visits=rs.getString("max_other_visits");
					total_other_visits=rs.getString("total_other_visits");		
				}
				max_visit=Integer.parseInt(wd1);
				tot_first=Integer.parseInt(wd2);
				max_other_visits_value=Integer.parseInt(max_other_visits);
				total_other_visits_value=Integer.parseInt(total_other_visits);

				if (max_visit > 0) {
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if(visit_type_ind.equals("F")&&((tot_first+no_of_slots_value) > max_visit)&&slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block6Bytes, _wl_block6);
 if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block7Bytes, _wl_block7);
alert_flag=false;
					}	
				}	   					
				if (max_other_visits_value>0){			   					
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if((!visit_type_ind.equals("F"))&&((total_other_visits_value+no_of_slots_value) > max_other_visits_value)&&slot_appt_ctrl.equals("S")){ no_of_slots="1";
            _bw.write(_wl_block8Bytes, _wl_block8);
 if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block10Bytes, _wl_block10);
alert_flag=false;
					}	
				}
				if (end_time_value<0 && alert_flag){
					alert_flag=false;
					no_of_slots="1";
            _bw.write(_wl_block11Bytes, _wl_block11);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag=false; 
						no_of_slots="1";
            _bw.write(_wl_block13Bytes, _wl_block13);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
				}

				if (alert_flag){
					if (rs!=null) rs.close();
					String sql12="select count(1) total from OA_CLINIC_SCHEDULE_BREAK  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
					rs = stmt.executeQuery(sql12);
					String total2="";
					while(rs.next()){
						total2 = rs.getString("total");
						if (!(total2.equals("0"))){		 
							alert_flag =false;
							no_of_slots="1";
            _bw.write(_wl_block16Bytes, _wl_block16);

							if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
					}
			  }

			    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag =false;
						no_of_slots="1";
            _bw.write(_wl_block18Bytes, _wl_block18);

						if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
		}

	   if (alert_flag){
			if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;		
				no_of_slots="1";
			 
            _bw.write(_wl_block20Bytes, _wl_block20);

             if (!(calling_from.equals("TRANSFER")))
              
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block22Bytes, _wl_block22);

			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;		
					no_of_slots="1";
					 
            _bw.write(_wl_block23Bytes, _wl_block23);

					 if (!(calling_from.equals("TRANSFER")))
					  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}

}else if (steps.equals("1")){
	
		if (no_of_slots_value>1){
			StringBuffer sql1=new StringBuffer("");
				sql1.append("select count(1) total from oa_appt  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ");
		
			rs = stmt.executeQuery(sql1.toString());
			sql1.setLength(0);
			String total="";
			while(rs.next()){
				total = rs.getString("total");
				if (!(total.equals("0"))){
					alert_flag=false; 
					no_of_slots="1";//Modified Against 43188
            _bw.write(_wl_block3Bytes, _wl_block3);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}
			if (rs!=null) rs.close();

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag=false; 
					no_of_slots="1";
            _bw.write(_wl_block3Bytes, _wl_block3);
if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}

			if (alert_flag){
				String sql2="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0) total_first_visit ,nvl(max_other_visits,0) max_other_visits ,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and TIME_TABLE_TYPE='1'";
				rs = stmt.executeQuery(sql2);
				while(rs.next()){
					end_time_value= rs.getInt("end_time");
					wd1 = rs.getString("max_first_visits");
					wd2=rs.getString("total_first_visit");
					max_other_visits=rs.getString("max_other_visits");
					total_other_visits=rs.getString("total_other_visits");		
				}
				max_visit=Integer.parseInt(wd1);
				tot_first=Integer.parseInt(wd2);
				max_other_visits_value=Integer.parseInt(max_other_visits);
				total_other_visits_value=Integer.parseInt(total_other_visits);

				if (max_visit>0) {
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if(visit_type_ind.equals("F")&&((tot_first+no_of_slots_value) > max_visit)&&slot_appt_ctrl.equals("S")){
					   if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block26Bytes, _wl_block26);
alert_flag=false;
					}	
				}
				//if (visit_limit_rule.equals("E")&&max_other_visits_value>0) {			   					
				if (max_other_visits_value>0){			   					
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if((!visit_type_ind.equals("F"))&&((total_other_visits_value+no_of_slots_value) > max_other_visits_value)&&slot_appt_ctrl.equals("S")){
					   if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block27Bytes, _wl_block27);
alert_flag=false;
					}	
				}
				if (end_time_value<0 && alert_flag){
					alert_flag=false;
					no_of_slots="1"; // Modified Against 43188
            _bw.write(_wl_block11Bytes, _wl_block11);
if (!(calling_from.equals("TRANSFER"))) 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag=false; 
						no_of_slots="1"; 
            _bw.write(_wl_block13Bytes, _wl_block13);
if (!(calling_from.equals("TRANSFER"))) 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
				}

				if (alert_flag){
					if (rs!=null) rs.close();
					String sql12="select count(1) total from OA_CLINIC_SCHEDULE_BREAK  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
				
					rs = stmt.executeQuery(sql12);
					String total2="";
					while(rs.next()){
						total2 = rs.getString("total");
						if (!(total2.equals("0"))){		 
							alert_flag =false;
							no_of_slots="1";
            _bw.write(_wl_block28Bytes, _wl_block28);

							if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
					}
			  }

			    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag =false;
						no_of_slots="1";
            _bw.write(_wl_block29Bytes, _wl_block29);

						if (!(calling_from.equals("TRANSFER")))
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
		}

	   if (alert_flag){
			if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;
				no_of_slots="1";
			 
            _bw.write(_wl_block30Bytes, _wl_block30);

             if (!(calling_from.equals("TRANSFER")))
              
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block22Bytes, _wl_block22);

			 }
			}
		  }

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;
					no_of_slots="1";
					 
            _bw.write(_wl_block32Bytes, _wl_block32);

					 if (!(calling_from.equals("TRANSFER")))
					  
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}
	 }
	 //modified by kamatchi S PAS-COMN-OA-Schedule Appointments-Book Appointment screen
	if ((alert_flag && (!(calling_from.equals("TRANSFER")))) || (no_of_slots.equals("1") && !(calling_from.equals("TRANSFER"))))
		{
		if (no_of_slots.equals("0")) no_of_slots="1";
				 String sql12="select to_char((to_date(to_char(sysdate,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi') -to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'),'hh24:mi') tm from dual";
                 if (rs!=null) rs.close();
				 rs=stmt.executeQuery(sql12);
				 String to_time_value = "";
				 while(rs!=null&&rs.next())
				{
                 to_time_value = rs.getString("tm");
				 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(to_time_value));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}		
		} 

	}else if (steps.equals("2")){
	 String pract_id=(String) hash.get("pract_id");
	 String clinic_code1=(String) hash.get("clinic_code");
	 String speciality_code="";
	 if (pract_id==null) pract_id="";
	 String pract_desc ="";
	 if (!clinic_code1.equals(""))
	 {	 if (rs!=null) rs.close();
		 String sql1 = "select speciality_code from op_clinic where facility_id = ? and clinic_code =?";
		 pstmt=con.prepareStatement(sql1);
		 pstmt.setString(1,facilityId);
		 pstmt.setString(2,clinic_code1);
		 rs=pstmt.executeQuery();
		 while(rs!=null && rs.next())
			{
			 speciality_code= rs.getString("speciality_code");   
			}
	 }
	 if(rs!=null) rs.close();
	 String sql =  "SELECT b.DESC_USERDEF descusrdef FROM am_practitioner a, AM_PRACT_TYPE b where a.pract_type = b.pract_type and a.practitioner_id  = ?";
	 if (pstmt!=null) pstmt.close();
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,pract_id);
	 rs=pstmt.executeQuery();
	 if (rs!=null){
	    if (rs.next())
		 {
			pract_desc= rs.getString("descusrdef");
		  
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

		 }
        else
		 {
		  
            _bw.write(_wl_block37Bytes, _wl_block37);

		 }
	 }
	 else
		{
		  
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
     if(!(clinic_code1.equals("")))
		{
		  
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
		
		}
	}else if (steps.equals("3")){
	 String nationality=(String) hash.get("nationality_code");
	 if (nationality==null) nationality="";
	 String pat_cat_code ="";
	 String sql =  "SELECT STAT_GRP_ID FROM AM_STAT_GRP_DETAIL WHERE MEMBER_ID = ?";
	 if (pstmt!=null) pstmt.close();
	 if (rs!=null) rs.close();
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,nationality);
	 rs=pstmt.executeQuery();
	 if (rs!=null){
	    if (rs.next())
		 {
			pat_cat_code = rs.getString("STAT_GRP_ID");
		  
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block42Bytes, _wl_block42);

		 }
        else
		 {
		  
            _bw.write(_wl_block43Bytes, _wl_block43);

		 }
	 }
	 else
		{
		  
            _bw.write(_wl_block44Bytes, _wl_block44);

		}    
		  
            _bw.write(_wl_block45Bytes, _wl_block45);


	}else if (steps.equals("4")){
	   
		String chk_overlap1= "select '1' from oa_appt where (appt_slab_from_time between to_date('"+fromTime+"','hh24:mi') and to_date('"+fromTime+"','hh24:mi') or appt_slab_to_time between to_date('"+toTime+"','hh24:mi') and to_date('"+toTime+"','hh24:mi'))and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' and appt_ref_no !='"+appt_ref_no+"'";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(chk_overlap1) ;
		if(rs !=null){
		  if(rs.next())		{	
			
            _bw.write(_wl_block46Bytes, _wl_block46);

			}
		}
	
	}else{
	if(!Forced.equals("Y")){
	String sql="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0) total_first_visit,nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,time_table_type,nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked,nvl(max_other_visits,0) max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits  from oa_clinic_schedule "+
			" where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
				end_time_value= rs.getInt("end_time");
				wd1 = rs.getString("max_first_visits");
				wd2=rs.getString("total_first_visit");
				max_slots_for_first_visit=rs.getString("max_slots_for_first_visit");
				time_table_type=rs.getString("time_table_type");
				total_first_visit=rs.getString("total_first_visit_slots_booked");
				total_other_visits =  rs.getString("total_other_visits");
				max_other_visits   =  rs.getString("max_other_visits");
		}
		max_visit=Integer.parseInt(wd1);
		tot_first=Integer.parseInt(wd2);
		max_other_visits_value = Integer.parseInt(max_other_visits);
		total_other_visits_value = Integer.parseInt(total_other_visits);		
	  if (visit_type_ind.equals("F")){
		if(max_visit > 0 )
		{
			if(tot_first >= max_visit)
				{
			   
            _bw.write(_wl_block47Bytes, _wl_block47);

				alert_flag=false;
				}				
      }
	  }
	  if (!(visit_type_ind.equals("F"))){
		if(visit_limit_rule.equals("E")&&max_other_visits_value > 0 )
		{
			if(total_other_visits_value >= max_other_visits_value)
				{
			   
            _bw.write(_wl_block48Bytes, _wl_block48);

				alert_flag=false;
				}				
      }
	  }
	  if (!no_of_slots.equals("")&&overbookedyn.equals("N")){
	  if (Integer.parseInt(no_of_slots)>1 &&time_table_type.equals("1")&&alert_flag&&overbookedyn.equals("N"))
		{
		   rs.close();
   		   String sql2="select count(1) total from oa_appt "+
			" where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ";
			rs = stmt.executeQuery(sql2);
		    String total="";
			while(rs.next()){
			 total = rs.getString("total");
			 if (!(total.equals("0"))){		 
			  alert_flag =false;
			  no_of_slots="1";
		      
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
			 }
			else
				{
				if(max_visit > 0 && slot_appt_ctrl.equals("S"))
				{
						if((tot_first+Integer.parseInt(no_of_slots)) > max_visit&&visit_type_ind.equals("F")&&overbookedyn.equals("N"))
						{
						   alert_flag = false;
						   
            _bw.write(_wl_block51Bytes, _wl_block51);

						}				
			       }//max_visit
				if(visit_limit_rule.equals("E")&&max_other_visits_value > 0 && slot_appt_ctrl.equals("S") )
				{
						if((total_other_visits_value+Integer.parseInt(no_of_slots)) > max_other_visits_value&&(!visit_type_ind.equals("F"))&&overbookedyn.equals("N"))
						{
						   alert_flag = false;
						   
            _bw.write(_wl_block52Bytes, _wl_block52);

						}				
			       }				

				}
			}

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;
					  no_of_slots="1";
					  
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block54Bytes, _wl_block54);
	
				}
			}
		}
	   if (end_time_value<0 && alert_flag&&overbookedyn.equals("N"))
		{ 
		   alert_flag =false;
		   no_of_slots="1";
		   
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block56Bytes, _wl_block56);
	
		}

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		if (alert_flag && overbookedyn.equals("N")){

			if ((cont_slt_yn.equals("N"))){
				alert_flag=false; 
				no_of_slots="1";
			   
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block58Bytes, _wl_block58);

			}
		}

	   if (alert_flag&&overbookedyn.equals("N"))
		  {
		   if (rs!=null) rs.close();
			String sql11="select count(1) total from oa_clinic_schedule_break where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
			 rs = stmt.executeQuery(sql11);
		     String total1="";
			 while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;	
				no_of_slots="1";
			 
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block60Bytes, _wl_block60);
	
			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag && overbookedyn.equals("N")){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;	
					no_of_slots="1";
					 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}

	   if (alert_flag&&overbookedyn.equals("N"))
		  {
		   if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;	
			 no_of_slots="1";
			 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block22Bytes, _wl_block22);

			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag && overbookedyn.equals("N")){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;	
					 no_of_slots="1";
					 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}
		}		
    if (alert_flag)
		{
		if (no_of_slots.equals("0")) no_of_slots="1";
				 String sql12="select to_char((to_date(to_char(sysdate,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi') -to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'),'hh24:mi') dttmm from dual";
                 if (rs!=null) rs.close();
				 rs=stmt.executeQuery(sql12);
				 String to_time_value = "";
				 while(rs!=null&&rs.next())
				{
                 to_time_value = rs.getString("dttmm");
				 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(to_time_value));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
		
		}
	}// end forced 
	}

	
	
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	if (cstmt != null) cstmt.close();

hash.clear();
}
catch( Exception e ){
	e.printStackTrace();
	out.println(e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block63Bytes, _wl_block63);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
