package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __schedulevaccinresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ScheduleVaccinResult.jsp", 1741071129276L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n---------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n---------------------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n12/07/2012    IN033073      Nijitha S     New Vaccines added to the existing category does not appear in CA\n08/10/2013    IN035541      Chowminya G   Manage Immunization->System is displaying the Vaccine Category of Age specific \n18/10/2013\t  IN037203 \t\tKarthi L\t  Manage Immunization -> The system is displaying the  disabled Vaccine Category  by default . \n20/11/2013    IN040377\t\tChowminya \t  New Immunization report required Patient wise.\n27/11/2013    IN000000\t\tChowminya\t  Manage Immunization> sequence of vaccine not as per order_seq_no\n---------------------------------------------------------------------------------------------------------------------------------\nDate       \tEdit History\tName        \tRev.Date\t\tRev.Name\t\tDescription\n---------------------------------------------------------------------------------------------------------------------------------\n03/01/2017\tIN066125\t\tDinesh T\t\t03/01/2017\t\tRamesh G\t\tEM run on window 10 and IE 11\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tVaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR\n---------------------------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head> \n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<!-- <modifeid by Arvind @02-12-2008> -->\n\t\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCA/js/ScheduleForVacination.js\' language=\'javascript\'></script>\n\t    <script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t    <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title></title>\n\t</head>\n\t<body class=\'CONTENT\' onload=\"\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\"processScroll()\">\n\t\n\t<form name=\"vaccineResult\" id=\"vaccineResult\">\n<div id=\"divPatVaccData\" style=\"width: 98vw;position: absolute;\">\n\t<table class=\'grid\' id=\'patVaccData\'  width=\'100%\' >\n\t<tr  id=\"heading\" > \n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap>&nbsp;</td>\n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'columnheadercenter\'   width=\'\' nowrap >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\t\n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'columnheadercenter\'   width=\'\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;/&nbsp;<BR>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> <!-- IN040377 -->\n\t\t <!-- <td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>  -->\n\t</tr> \n  \n   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<tr><td class=\'CAGROUP\' colspan=\'9\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td></tr>\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\n\t\t\t<tr><td class=\'gridData\' width=\'\' nowrap><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<img src=\'../../eCA/images/link.gif\'  name=\'btnLink\"+k+\"\' title=\'Linked vaccine Schedule\' onclick=\'fnLinkVaccineCategory(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\' style=\'cursor:pointer;\'>\n\t\t\t\t<!-- <input type=\'button\' name=\'btnLink\"+k+\"\' id=\'btnLink\"+k+\"\' value=\'L\' title=\'Linked vaccine Schedule\' onclick=\'fnLinkVaccineCategory(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\")\'> -->\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t\t<td class=\'gridData\' width=\'\' title=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' nowrap>\n\t\t\t<a class=\'gridLink\'  href=\'javascript:loadAllergyPage(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\'><img src=\'../../eCommon/images/PI_Allergies.gif\' BORDER=\'0\' style=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></a> <a class=\'gridLink\'  href=\'javascript:loadAdminPage(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\");\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a></td>\n\n\t\t\t<!-- Two Date Convesion added by Archana Dhal on 12/8/2010 related to incident no IN025377. -->\t\t\t\t\n\t\t\t\t<td class=\'gridData\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td class=\'gridData\' nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\t\t\t\t\n\t\t\t\t<td class=\'gridData\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t<!-- IN040377 Start -->\n\t\t\t\t<td class=\'gridData\' nowrap><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'chk";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  value=\"N\" onClick=\'clickLine(this)\' </td>\n\t\t\t\t<!-- <td class=\'gridData\' nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td> --></tr> \n\t\t\t\t<input type=\'hidden\' name=\'vaccine_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'vaccine_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'vac_sch_ref";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'vac_sch_ref";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dose_no";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'dose_no";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t<!-- IN040377 end -->\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\n\t\t<!--\n\t\t/* Modified by Kishore Kumar N on Spet 09-09*/\n\t\t\n\t\t\n\t\t<tr style=\"visibility:hidden\" > \n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<!-- <td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td> -->\n\t\t<!-- </tr>\n\t\t\n\t\t\tends here.\n\t\t-->\n\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<!-- \n\t\t\n\t\t/* Modified by Kishore Kumar N on Spet 09-09*/\n\t\t<tr style=\"visibility:hidden\" > \n\t\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td> -->\n\t\t<!-- </tr>\n\t\t\n\t\tends here.\n\t\t-->\n\t\t\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n   </table>\n   </div>\n   <input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' name=\'query_string\' id=\'query_string\'>\n   <input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' name=\'patient_id\' id=\'patient_id\'>\n   <input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' name=\'encounter_id\' id=\'encounter_id\'>\n   <!-- IN040377 start -->\n   <input type=hidden \tvalue=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' name=\'total_recs\' id=\'total_recs\'> \n   <input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' name=\'facility_id\' id=\'facility_id\'>\n   <!-- IN040377 end -->\n   </form>\n<script>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t/*if(parent.VaccineResTitle.document.getElementById(\"patVaccTitle\") == null) \n\t\t\t{\t\t\t\t\n\t\t\t\tsetTimeout(\"alignHeading1();\",300);\n\t\t\t}\n\t\t\telse \n\t\t\t{\t\n\t\t\t\t\n\t\t\t\talignHeading1();\n\t\t\t\t\n\t\t\t}*/\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\n\t</script>\n\n   </body>\n\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE"); 	
	String client_ip_address=	p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
	String login_user_id =  p.getProperty("login_user")==null?"":(String)p.getProperty("login_user")  ;
	String facility_id = session.getAttribute("facility_id")==null?"":(String) session.getAttribute("facility_id"); 	
	String scheduled_user_id = session.getAttribute("ca_practitioner_id")==null?"":(String)session.getAttribute("ca_practitioner_id"); 	
	
 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	String patient_id =""; 
	String vac_sch_ref ="";
	String vacc_categ_desc_prev ="";
	Boolean flag= true;
//	String className="";
	String status="";
	String outcome_code="";
	String vac_sch_ref1="";
	String vaccine_id="";
	String vaccine_desc="";
	String dose_no="";
	String schedule_date="";
	String administered_date="";
	String batch_id="";
	String admin_site_desc="";
	String administered_username="";
	String status_desc="";
	String status_ord="";
	String cbSchedule="";
	String adhoc_yn ="";
	String vacc_categ_id ="";
	String vacc_categ_desc ="";
	String alergry_exists_yn = "N";
	String allergy_img_dis = "";
	String cellBGColor = "";
	String rowColor = "";
	String include_err = "";
	String order_id = "";
	String ord_drug_code = "";
	String vacc_categ_desc1 = "";
	String durgToolTip = "";
	String dob="";
	String encounter_id="";
	String scheduled_age="";
	String actual_age="";
	String mrk_err_status = "";
	String linked_sch_yn = "";
	String link_param_yn = "";
	String ord_drug_dose_no = "";
	
	//String patient_id ="";
	StringBuffer  vaccin_details_query = new StringBuffer (); 
	int k =0;
	vac_sch_ref  =request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
	status_ord  =request.getParameter("status_ord")==null?"":request.getParameter("status_ord");
	cbSchedule  =request.getParameter("cbSchedule")==null?"":request.getParameter("cbSchedule");
	adhoc_yn  =request.getParameter("adhoc_yn")==null?"":request.getParameter("adhoc_yn");
	vacc_categ_id  =request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");
	dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
	encounter_id=request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	patient_id  =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	include_err  =request.getParameter("include_err")==null?"N":request.getParameter("include_err");


	
	if(vac_sch_ref.equals("ALL")){
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //Commentted IN000000
	vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO,c.ORDER_SRL_NO,CA_GET_DESC.CA_IM_VAC_CATEG (b.VACC_CATEG_ID,'en',2)  VACC_CATEG_DESC1 FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c, CA_IM_VACCINE d WHERE c.vaccine_id = a.vaccine_id and d.vaccine_id = c.vaccine_id and d.eff_status = 'E'and a.VAC_SCH_REF = B.VAC_SCH_REF AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //IN000000 modified to display only active vaccines
		//vac_sch_ref="";		
	} else{ //[IN035541]
	/*
		Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			b.VACC_CATEG_ID , added to query
	*/
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID, A.DOSE_NO, to_char(A.SCHEDULE_DATE,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,to_date(SCHEDULE_DATE,'DD/MM/YYYY HH24:MI'))  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = B.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),to_date(A.ADMINISTERED_DATE,'DD/MM/YYYY')) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,B.LINKED_SCH_YN FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID) and b.PATIENT_ID= ? AND B.LINKED_SCH_YN = 'N' ");
	//DECODE(NVL(A.ORDER_ID,'*'),'*',A.DOSE_NO,A.ord_drug_dose_no) DOSE_NO,
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //IN033073
	//vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); //[IN035541] // commented for IN037203
	vaccin_details_query.append("SELECT CA_GET_DESC.CA_IM_VAC_CATEG ( b.VACC_CATEG_ID,?,2)||(select '  ('||to_char(min(SCHEDULE_DATE),'DD/MM/YYYY')||' - '||to_char(max(SCHEDULE_DATE),'DD/MM/YYYY')||')' from CA_IM_PAT_VAC_SCH_DTL where  VAC_SCH_REF= A.VAC_SCH_REF )  VACC_CATEG_DESC , A.VAC_SCH_REF, A.VACCINE_ID,A.DOSE_NO,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE, A.BATCH_ID,  A.ADMIN_SITE_ID , AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName, A.OUTCOME_CODE, A.ADMINISTERED_BY ,CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) SHORT_DESC , ca_get_schedule_status(b.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO,A.VAC_SCH_REF,A.SCHEDULE_DATE)  STATUS ,nvl((select 'Y' FROM CA_IM_PAT_VAC_REACTION WHERE VAC_SCH_REF= A.VAC_SCH_REF AND VACCINE_ID=A.VACCINE_ID AND DOSE_NO=A.DOSE_NO AND ROWNUM=1),'N')  Alergry_exists_yn,A.ORDER_ID,A.ORD_DRUG_CODE,(select drug_desc from ph_drug_lang_vw where language_id= ? and drug_code = A.ORD_DRUG_CODE) DRUG_DESC, b.VACC_CATEG_ID, MP_GET_AGE_YMD(to_date(?,'DD/MM/YYYY'),SCHEDULE_DATE) SCHEDULED_AGE, MP_GET_AGE_YMD(NVL2(A.ADMINISTERED_DATE,to_date(?,'DD/MM/YYYY'),NULL),A.ADMINISTERED_DATE) ACTUAL_AGE, DECODE ((SELECT 1               FROM ca_im_pat_vac_err_dtl WHERE vac_sch_ref = a.vac_sch_ref AND vaccine_id = a.vaccine_id AND dose_no = a.dose_no and rownum=1),                 1, 'E', '')  MRK_ERR_STATUS,A.LINKED_SCH_YN, CA_IM_PROIVIDE_LINK_YN(A.VAC_SCH_REF, B.PATIENT_ID,B.VACC_CATEG_ID,A.VACCINE_ID,A.DOSE_NO) LINK_PARAM_YN, A.ORD_DRUG_DOSE_NO,c.ORDER_SRL_NO,CA_GET_DESC.CA_IM_VAC_CATEG (b.VACC_CATEG_ID,'en',2)  VACC_CATEG_DESC1 FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  ,CA_IM_VAC_FOR_CATEG c, CA_IM_VACCINE d WHERE A.VAC_SCH_REF = NVL(?, A.VAC_SCH_REF) and  c.vaccine_id = a.vaccine_id and d.vaccine_id = c.vaccine_id and a.vaccine_id = d.vaccine_id and d.eff_status = 'E' and a.VAC_SCH_REF = B.VAC_SCH_REF and b.VACC_CATEG_ID =NVL(?,b.VACC_CATEG_ID)  and c.vacc_categ_id = NVL (?, c.vacc_categ_id) AND b.vacc_categ_id = c.vacc_categ_id and b.PATIENT_ID= ? AND A.LINKED_SCH_YN = 'N'"); // modified for IN037203	
	}
	 if (status_ord.equals("DO"))
	{
			vaccin_details_query.append(" and ca_get_schedule_status (b.vacc_categ_id,a.vaccine_id, a.dose_no, a.vac_sch_ref, schedule_date)  in ('D', 'O')");
			status_ord = "";
	}
	else if (!status_ord.equals("")) 
	{
		vaccin_details_query.append(" and ca_get_schedule_status (b.vacc_categ_id,a.vaccine_id, a.dose_no, a.vac_sch_ref, schedule_date)   in (?)");		
	}

	if(!include_err.equals("Y"))
	{
		vaccin_details_query.append(" and A.OUTCOME_CODE !='E' ");
	}


	// if(vac_sch_ref.equals("")&&adhoc_yn.equals("N"))
	 {
		//vaccin_details_query.append(" Order by 1 ,A.SCHEDULE_DATE");//IN000000 commented
		vaccin_details_query.append(" Order by VACC_CATEG_DESC1,ORDER_SRL_NO,A.SCHEDULE_DATE");//IN000000
	 }

	/* else
	 {
		vaccin_details_query.append(" Order by 4 ");
	 }*/

	
	try 
	{
		con = ConnectionManager.getConnection(request);	
		//if(vac_sch_ref.equals(""))//IN033073
		if(vac_sch_ref.equals("") && vac_sch_ref!=null)//IN033073 //IN035541 Changed || to &&
		{
			ScheduleForVaccination scheduleBean = new ScheduleForVaccination();
			Map paramMap = new HashMap();
			paramMap.put("PATIENT_ID",patient_id);
			paramMap.put("VACC_CATEG_ID",vacc_categ_id);
			paramMap.put("DOB",dob);
			paramMap.put("CON_OBJ",con);
			paramMap.put("ENCOUNTER_ID",encounter_id);
			paramMap.put("FACILITY_ID",facility_id);
			paramMap.put("SCHEDULED_USER_ID",scheduled_user_id);
			paramMap.put("LOGIN_USER_ID",login_user_id);
			paramMap.put("CLIENT_IP_ADDRESS",client_ip_address);
			paramMap.put("SCHEDULED_USER_ID",scheduled_user_id);
			paramMap.put("LOCALE",locale);			
			paramMap.put("VAC_SCH_REF",vac_sch_ref);//IN033073
			scheduleBean.createScheduleForVaccination(paramMap);
		}
		pstmt = con.prepareStatement(vaccin_details_query.toString());
		//IN033073 - Added indexing
		int indx = 1; 
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,locale);
		pstmt.setString(indx++,dob);
		pstmt.setString(indx++,dob);
		if(!vac_sch_ref.equals("ALL")) //IN035541 Condition Added
		{
		pstmt.setString(indx++,vac_sch_ref);
		pstmt.setString(indx++,vacc_categ_id);
		pstmt.setString(indx++,vacc_categ_id);
		}
		pstmt.setString(indx++,patient_id);

		 if(!status_ord.equals(""))
		 {
			pstmt.setString(indx++,status_ord); 
		 }
		//pstmt.setString(5,patient_id);

		rs= pstmt.executeQuery();
		String img = "";
		String showMrkErrPage = "";
		
		while(rs.next())
		{
			img ="";
			flag =false;
		/*	if (k % 2 == 0 )
				   className = "QRYODD";
				else
					className = "QRYEVEN"; //QRYEVEN	*/	
			vacc_categ_desc = rs.getString("VACC_CATEG_DESC")==null?"":rs.getString("VACC_CATEG_DESC");
			vac_sch_ref1 = rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");
			vaccine_id = rs.getString("VACCINE_ID")==null?"":rs.getString("VACCINE_ID");
			vaccine_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			dose_no = rs.getString("DOSE_NO")==null?"":rs.getString("DOSE_NO");
			schedule_date = rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE");
			administered_date = rs.getString("ADMINISTERED_DATE")==null?"":rs.getString("ADMINISTERED_DATE");//IN035541
			batch_id = rs.getString("BATCH_ID")==null?"&nbsp;":rs.getString("BATCH_ID");
			admin_site_desc = rs.getString("ADMIN_SITE_DESC")==null?"&nbsp;":rs.getString("ADMIN_SITE_DESC");
			administered_username = rs.getString("Administered_UserName")==null?"&nbsp;":rs.getString("Administered_UserName");
			status = rs.getString("STATUS")==null?"&nbsp;":rs.getString("STATUS");
			outcome_code = rs.getString("OUTCOME_CODE")==null?"":rs.getString("OUTCOME_CODE");
			alergry_exists_yn = rs.getString("Alergry_exists_yn")==null?"N":rs.getString("Alergry_exists_yn");		
			order_id = rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
			ord_drug_code = rs.getString("ORD_DRUG_CODE")==null?"":rs.getString("ORD_DRUG_CODE");
			durgToolTip = rs.getString("DRUG_DESC")==null?"":rs.getString("DRUG_DESC");
			scheduled_age = rs.getString("SCHEDULED_AGE")==null?"":rs.getString("SCHEDULED_AGE");
			mrk_err_status = rs.getString("MRK_ERR_STATUS")==null?"":rs.getString("MRK_ERR_STATUS");
			actual_age = rs.getString("ACTUAL_AGE")==null?"":rs.getString("ACTUAL_AGE");
			linked_sch_yn = rs.getString("LINKED_SCH_YN")==null?"":rs.getString("LINKED_SCH_YN");
			link_param_yn = rs.getString("LINK_PARAM_YN")==null?"":rs.getString("LINK_PARAM_YN");
			ord_drug_dose_no = rs.getString("ord_drug_dose_no")==null?"":rs.getString("ord_drug_dose_no");
			actual_age = actual_age.equals("D")?"":actual_age;
			//out.println("status   -->"+status+"  "+vac_sch_ref1+"~"+vaccine_id+"~"+dose_no+"<--");
			
			/*
				Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			*/
			vacc_categ_id = rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");

			/* ends here. */
			
			if (alergry_exists_yn.equals("Y")){
				allergy_img_dis = "display:visible";
			}else{
				allergy_img_dis = "display:none";	
			}						

		
			if(status.equals("C"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");

				//cellBGColor = "background-color:#99CCFF";
				img = "Completed.gif";
			}
			else if(status.equals("E") )
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
				//cellBGColor = "background-color: #FF8000";
				img = "notadministered.gif";
			}
			else if(status.equals("D") )
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Due.label","common_labels");
				//cellBGColor = "background-color:#99FFCC";
				img = "Due.gif";
			}
			else if(status.equals("L"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Elapsed.label","common_labels");
				//cellBGColor = "background-color:#99CC00";
				img = "Elapsed.gif";
			}
			else if(status.equals("N"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotAdministered.label","common_labels");
				//cellBGColor = "";
				img = "In-Error.gif";
			}
			else if(status.equals("F"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Future.label","common_labels");
				//cellBGColor = "";
				img = "Future.gif";
			}
			else if(status.equals("O"))
			{

				status_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
				//cellBGColor = "";
				img = "OverDue.gif";
			}
			else
			{
				status_desc="";
				cellBGColor="";
				rowColor = "";
			}
			//out.println("status   --->"+status+"<-----    img  ------>"+img+"<-----");
			//out.println("vac_sch_ref.."+vac_sch_ref+"....adhoc_yn..."+adhoc_yn+"...cbSchedule..."+cbSchedule);
			
			//if(vac_sch_ref.equals("")&&adhoc_yn.equals("N")&&cbSchedule.equals("Y"))//IN066125
			if(vac_sch_ref.equals("ALL")&&adhoc_yn.equals("N")&&cbSchedule.equals("Y"))//IN066125
			{			
				if(vacc_categ_desc.indexOf("(") == 2)
				{
					vacc_categ_desc1 = "AdministeredRXVaccines";
				}else {
					vacc_categ_desc1 = vacc_categ_desc;
				}
				if(vacc_categ_desc.indexOf("(") == 2 && !vacc_categ_desc1.equals(vacc_categ_desc_prev))
				{ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
			}
				else if(!vacc_categ_desc1.equals(vacc_categ_desc_prev))
				{						
					out.println("<tr><td class='CAGROUP' colspan='9'>"+vacc_categ_desc+"</td></tr>");
				}	
			}
			
			if(mrk_err_status.equals("E"))
			{
				showMrkErrPage = "<img src='../../eCA/images/notadministered.gif' onclick=' loadMarkErrPage(\""+vac_sch_ref1+"\",\""+vaccine_id+"\",\""+dose_no+"\",\""+vaccine_desc+"\");' style='cursor:pointer;'>";
			}
			else
			{
				showMrkErrPage = "";
			}
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(img));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(showMrkErrPage));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(link_param_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vac_sch_ref1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vacc_categ_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(linked_sch_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(vac_sch_ref1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vacc_categ_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(linked_sch_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(durgToolTip));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(vac_sch_ref1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(administered_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(adhoc_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(allergy_img_dis));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(vac_sch_ref1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dose_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(adhoc_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vacc_categ_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alergry_exists_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vaccine_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(schedule_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(administered_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ord_drug_dose_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(vaccine_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(schedule_date,"DMY","en",locale)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(scheduled_age));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(administered_date,"DMYHM","en",locale)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(actual_age));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(admin_site_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(administered_username));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(showMrkErrPage));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(k));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(vaccine_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(k));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(vac_sch_ref1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dose_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
			
			k++;			
			vacc_categ_desc_prev =vacc_categ_desc1;			
		}
		
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);


			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
	
	
	}
	catch(Exception e)
	{
		
		
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

		
		
		e.printStackTrace();
	}
	finally
	{
	 if(con!=null)ConnectionManager.returnConnection(con,request);
	}

	if(flag)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.getElementById('patVaccData').style.display='none'</script>");
		
	}

	
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
 /*if(!flag){*/
            _bw.write(_wl_block57Bytes, _wl_block57);
/*//}*/
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Vaccine.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ScheduledAge.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ActualDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ActualAge.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BatchNumber.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SiteName.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdministeredBy.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AdministeredRxVaccines.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Vaccine.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ActualDate.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BatchNumber.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SiteName.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdministeredBy.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Vaccine.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ActualDate.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BatchNumber.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SiteName.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdministeredBy.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }
}
