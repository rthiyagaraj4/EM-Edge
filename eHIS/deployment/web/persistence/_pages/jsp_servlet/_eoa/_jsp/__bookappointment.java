package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __bookappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BookAppointment.jsp", 1735563574253L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<head><title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title></head>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<head><title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"../../eOA/jsp/AddModifyBookAppointment.jsp?clinic_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&i_practitioner_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&i_appt_date=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&i_from_time=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&i_to_time=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&i_over_booked=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&i_time_table_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&book_appt_wo_pid_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&book_appt_yn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&book_appt_across_catg_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&obook_appt_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&tfr_appt_yn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&tfr_appt_across_catg_yn=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&canc_appt_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&ca_patient_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&alcn_criteria=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&obvisit_flag=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&Forced=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&Global=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&block_break_appt=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&clinic_type=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&res_type=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&or_catalogue_code=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&order_line_num=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&order_id=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&order_catalog_code=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&slot_appt_ctrl=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&visit_limit_rule=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&oper_stn_id=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&override_no_of_slots_yn=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&req_id=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&visit_flag_OP=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&capture_fin_dtls_yn=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&from_page=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&apptrefno=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&visit_type_ind=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&referral_id=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&from_page1=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&noshow_ctrl_by_splty_or_clinic=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&min_ela_per_resc_noshow_in_day=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&from_facility_id=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&from_encounter_id=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&contact_num_reqd_yn=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&no_of_noshow_appts_for_alert=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&per_chk_for_no_show_alert=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&rule_appl_yn=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&rule_based_tr=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&patient_id_temp=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&name_prefix_temp=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&first_name_temp=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&second_name_temp=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&third_name_temp=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&family_name_temp=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&name_suffix_temp=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&name_prefix_oth_lang_temp=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&first_name_oth_lang_temp=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&second_name_oth_lang_temp=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&third_name_oth_lang_temp=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&family_name_oth_lang_temp=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&name_suffix_oth_lang_temp=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&gender_temp=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&contact_no_temp=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&prefPractYN=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&nationality_code_temp=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&language_code_temp=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&term_set_id=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&linking_code=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&wtListControl=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="&waitListNo=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&canldapptrefno=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&rd_appt_yn=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"  scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' frameborder=\'0\' style=\'height:85vh;width:100vw\'></iframe>\n\t<iframe name=\'SecondaryFrame\' id=\'SecondaryFrame\'  src=\'../../eCommon/html/blank.html\' noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' style=\'height:0vh;width:100vw\' frameborder=\'0\' ></iframe>\n\t<iframe name=\'ButtonFrame\' id=\'ButtonFrame\'  src=\'../../eOA/jsp/BookApptButtons.jsp?fromPage=BookAppointment&patientid=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\' style=\'height:0vh;width:100vw\' frameborder=\'0\' ></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\'  src=\'../../eCommon/jsp/error.jsp\' noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' style=\'height:0vh;width:100vw\' frameborder=\'0\' ></iframe>\n\t<iframe name=\'SubmitFrame\' id=\'SubmitFrame\'  src=\'../../eCommon/jsp/error.jsp\'  noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' style=\'height:0vh;width:100vw\' frameborder=\'0\' ></iframe></html>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );


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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.HashMap patInstructionsMap= null;synchronized(session){
                patInstructionsMap=(java.util.HashMap)pageContext.getAttribute("patInstructionsMap",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(patInstructionsMap==null){
                    patInstructionsMap=new java.util.HashMap();
                    pageContext.setAttribute("patInstructionsMap",patInstructionsMap,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.HashMap prcInstructionMap= null;synchronized(session){
                prcInstructionMap=(java.util.HashMap)pageContext.getAttribute("prcInstructionMap",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(prcInstructionMap==null){
                    prcInstructionMap=new java.util.HashMap();
                    pageContext.setAttribute("prcInstructionMap",prcInstructionMap,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	Connection conn = null;
	Statement stmt=null;
	ResultSet  rs=null;
	PreparedStatement pstmt=null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	try{
		conn = ConnectionManager.getConnection(request);
		String apptdate= request.getParameter("i_appt_date");
		String day_show="";
		String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);

	stmt = conn.createStatement();


	if (apptdate!=""){
		//String sql ="select to_char(to_date('"+apptdate+"','dd/mm/yyyy'),'Day')appt_date from dual";
		String sql ="select to_char(to_date(?,'dd/mm/yyyy'),'Day')appt_date from dual";
	   // rs=stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,apptdate);
		rs = pstmt.executeQuery();
		rs.next();
		String day_val= rs.getString("appt_date");
		day_val=day_val.trim();
		if(day_val.equals("Sunday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day_val.equals("Monday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day_val.equals("Tuesday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day_val.equals("Wednesday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day_val.equals("Thursday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day_val.equals("Friday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day_val.equals("Saturday")){
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
		String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(day_show));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{	

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	String patientid=request.getParameter("i_patient_id");
	String clinicname=request.getParameter("i_clinic_name");
	if (clinicname==null) clinicname ="";
	//clinicname = java.net.URLEncoder.encode(clinicname);
	String cliniccode=request.getParameter("i_clinic_code");
	if (cliniccode==null) cliniccode ="";
	String practid=request.getParameter("i_practitioner_id");
	String practname=request.getParameter("i_practitioner_name");
	if (practname==null) practname="";
	//practname = java.net.URLEncoder.encode(practname);
	String fromtime=request.getParameter("i_from_time");
	String totime=request.getParameter("i_to_time");
	String overbookedyn=request.getParameter("i_over_booked");
	String timetableyn=request.getParameter("i_time_table_type");
	String book_appt_yn = request.getParameter("book_appt_yn");
	String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
	String obook_appt_yn = request.getParameter("obook_appt_yn");
	String book_appt_across_catg_yn = request.getParameter("book_appt_across_catg_yn");
	String tfr_appt_yn = request.getParameter("tfr_appt_yn");
	String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
	String canc_appt_yn = request.getParameter("canc_appt_yn");
	String ca_patient_id=request.getParameter("ca_patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	String Forced=request.getParameter("Forced");
	String Global=request.getParameter("Global");
	String block_break_appt=request.getParameter("block_break_appt");
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String or_catalogue_code=request.getParameter("or_catalogue_code");
	String order_id=request.getParameter("order_id");
	String order_line_num=request.getParameter("order_line_num");
	String order_catalog_code=request.getParameter("order_catalog_code");
	if(order_catalog_code==null) order_catalog_code="";
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	String obvisit_flag=request.getParameter("obvisit_flag");
	if(obvisit_flag==null) obvisit_flag="";
	//Added by Suman for sql tuning
	String alcn_criteria=request.getParameter("alcn_criteria");
	if(alcn_criteria ==null) alcn_criteria="";

	String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
	if(slot_appt_ctrl ==null) slot_appt_ctrl="";

	String visit_limit_rule =request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="";

	String oper_stn_id=request.getParameter("oper_stn_id");
	if(oper_stn_id ==null) oper_stn_id="";

	String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
	if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";	
	//MR by suman 
	String req_id=request.getParameter("req_id");
	if(req_id ==null) req_id="";
	//ends hre
	String visit_flag_OP=request.getParameter("visit_flag_OP");
	if(visit_flag_OP==null) visit_flag_OP="N";
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";

	String from_page1=request.getParameter("from_page1");
	if(from_page1 ==null) from_page1="";
	String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");

	String apptrefno=request.getParameter("apptrefno");
	if(apptrefno ==null) apptrefno="";

	String visit_type_ind=request.getParameter("visit_type_ind");
	if(visit_type_ind ==null) visit_type_ind="";
	String referral_id=request.getParameter("referral_id");
	if(referral_id ==null) referral_id="";
	String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
	if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
	String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
	if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

	String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
	if(contact_num_reqd_yn ==null) contact_num_reqd_yn="N";
	//OPCheckout
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";

	String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
	if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

	String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
	if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";
	//Changes for Rutnin CRF Starts
	String rule_based_tr	= checkForNull(request.getParameter("rule_based_tr"),"N");
	String rule_appl_yn		= checkForNull(request.getParameter("rule_appl_yn"),"N");
	String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	= checkForNull(request.getParameter("name_suffix_temp"));

	String name_prefix_oth_lang_temp	= checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp		= checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	= checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp		= checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	= checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	= checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
	String prefPractYN		= checkForNull(request.getParameter("prefPractYN"));
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 
	String wtListControl			= checkForNull(request.getParameter("wtListControl"));
	String waitListNo			= checkForNull(request.getParameter("waitListNo"));	
	String canldapptrefno			= checkForNull(request.getParameter("canldapptrefno"));	
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	
	//System.out.println("name_suffix_temp BookAppointment.jsp:"+name_suffix_temp);
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(timetableyn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(obvisit_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Global));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(block_break_appt));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(from_page1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rule_based_tr));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(name_prefix_temp));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_suffix_temp));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(name_prefix_oth_lang_temp));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(first_name_oth_lang_temp));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(second_name_oth_lang_temp));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(third_name_oth_lang_temp));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(name_suffix_oth_lang_temp));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(gender_temp));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(prefPractYN));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(canldapptrefno));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){
	e.printStackTrace();
	//out.println(e);
}finally{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BookAppointmentfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
