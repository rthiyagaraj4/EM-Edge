package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eBL.BLReportIdMapper;
import eBL.BLCashSlmtRestriction;

public final class __bladhocdiscbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscBtn.jsp", 1743571026697L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\tfunction apply()\n\t{\t\n\t\tparent.frames[1].document.forms[0].called_butt.value=\"SUBMIT_BUTTON\";\n\n\t\tif(parent.frames[1].document.forms[0].checked_services.value==\"\")\n\t\t{\n\t\t\talert(\"Select Atleast one record\");\n\t\t\treturn;\n\t\t}\n\n\t/*\tparent.frames[1].document.forms[0].target=\'submit_frame\';\n\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eBL.BLAdhocDiscServlet\";\n\t\tparent.frames[1].document.forms[0].submit();*/\n\n\t\tparent.frames[1].document.forms[0].target=\'submit_frame\';\n\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLAdhocDiscSubmit.jsp\";\n\t\tparent.frames[1].document.forms[0].submit();\n\t}\n\n\tfunction cancel()\n\t{\n\t\tdocument.AdhocBtnForm.cancel_button.disabled = true;\n\t\tvar called_frm = parent.frames[1].document.forms[0].called_frm.value;\n\t\tvar called_module_id = parent.frames[1].document.forms[0].module_id.value;\n\t\tvar dep_exist = document.forms[0].dep_exist.value;\n\t\tvar dep_alert = document.forms[0].dep_alert.value;\n\t\tvar dep_adjust_yn =null;\t\n\t\t//var dep_adjust_yn =\"N\";\t\n\t\t//\tAdded by Karthik for site Id Verification GHL-SCF-1036\n\t\tvar siteId=document.AdhocBtnForm.siteId.value;\n\t\t//added by sarath making sitespecific CRF KDAH339.2 \n\t\tvar restrictEligibility = document.forms[0].restrictEligibility.value;\n\t\tvar site3TierAlmoFeatureYN = document.forms[0].site3TierAlmoFeatureYN.value; //Added V200228 SHIKHA against AAKH-CRF-0112\n\t\tif(called_frm == \'OTH_MOD\')\t\t\t\t\n\t\t{\t\t\t\t\n\t\t\t//if(called_module_id != \'OR\' || siteId==\'AMS\'  || siteId==\'ALMO\' || siteId==\'MC\' ){ //Added By Muthukumar on 08-06-12 for OR Module Change\n\t\t\tif(called_module_id != \'OR\' || siteId==\'AMS\'  || siteId==\'ALMO\' || siteId==\'MC\' ||site3TierAlmoFeatureYN ==\'Y\'){ //Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1  //Added By Muthukumar on 08-06-12 for OR Module Change \n\t\t\t\tif(dep_alert == \"Y\")\n\t\t\t\t {\n\t\t\t\t\tif(dep_exist == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar dep_yn;\n\t\t\t\t\t\tif(restrictEligibility == \"Y\"){\n\t\t\t\t\t\t\tdep_yn = confirm(getMessage(\'BL0707\',\'BL\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tdep_yn = confirm(getMessage(\'BL9123\',\'BL\'))\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\tif(dep_yn == true)\n\t\t\t\t\tdep_adjust_yn=\"Y\";\n\t\t\t\telse\n\t\t\t\t\tdep_adjust_yn=\"N\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\t {\n\t\t\t\t\t\tdep_adjust_yn = \"N\";\n\t\t\t\t\t }\n\t\t\t\t }\n\t\t\t\t else{\n\t\t\t\t\t\tdep_adjust_yn = \"Y\";\n\t\t\t\t\t }\n\n\t\t}//Added By Muthukumar on 08-06-12 for OR Module Change// 29-06-12\n\t\t\n\t\tvar bl_items_sl_no  =document.forms[0].bl_items_sl_no.value;\n\tparent.frames[1].document.forms[0].called_butt.value=\"CLOSE_BUTTON\";\t\t\t\n\tparent.frames[1].document.forms[0].target=\'submit_frame\';\n\tparent.frames[1].document.forms[0].method=\'post\';\n\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLAdhocDiscSubmit.jsp?dep_adjust_yn=\"+dep_adjust_yn+\"&bl_items_sl_no=\"+bl_items_sl_no;\n\tparent.frames[1].document.forms[0].submit();\n\t\t}\t\t\n\t\telse\n\t\t{\n\t\t\twindow.close();\n\t\t}\n\t}\n\n\tasync function log_in_cash_counter()\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"50\";\n\t\tvar dialogWidth\t= \"70\";\n\t\tvar dialogTop = \"100\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar cash_counter_leg = getLabel(\"eBL.CASH_COUNTER_LOGIN.label\",\"BL\");\n\t\tcash_counter_leg = encodeURIComponent(cash_counter_leg);\n\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll: yes \" + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLLogInMain.jsp?called_frm=DISC_FUN\";\n\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t\tif(retVal==null) retVal=\"\";\n\n\t\tif(retVal == \"SUCCESS\")\n\t\t{\n\t\t\tdocument.getElementById(\"cash_counter_log_in_disp\").style.display=\"none\";\n\t\t\tdocument.getElementById(\"cash_counter_log_out_disp\").style.display=\"none\";\n\t\t}\n\t}\n\n\tasync function log_out_cash_counter()\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"50\";\n\t\tvar dialogWidth\t= \"70\";\n\t\tvar dialogTop = \"100\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar cash_counter_leg = getLabel(\"eBL.CASH_COUNTER_LOGOUT.label\",\"BL\");\n\t\tcash_counter_leg = encodeURIComponent(cash_counter_leg);\n\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll: yes \" + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLLogoutMain.jsp?called_frm=DISC_FUN\";\n\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t\tif(retVal==null) retVal=\"\";\n\t\t\n\t\tif(retVal == \"SUCCESS\")\n\t\t{\n\t\t\tdocument.getElementById(\"cash_counter_log_out_disp\").style.display=\"none\";\n\t\t\tdocument.getElementById(\"cash_counter_log_in_disp\").style.display=\"inline\";\n\t\t}\n\t}\n</script>\n<body onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"   onSelect=\"codeArrestThruSelect();\">\n<form name=\'AdhocBtnForm\' id=\'AdhocBtnForm\' method=\'post\' action=\'\'   >\t\n\t<table cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\t\n\t\t<tr>\n\t\t<!--\n\t\t\t<td class=\"label\" width=\"24%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"16%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"18%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"16%\"><div align=\"right\"><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></div></td>\n\t\t\t<td width=\'7%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_gross_amt\' id=\'tot_gross_amt\' size=\'4\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'7%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_disc_amt\' id=\'tot_disc_amt\' size=\'4\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'7%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_net_amt\' id=\'tot_net_amt\' size=\'4\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'5%\' class=\'label\'>&nbsp;</td>\n-->\n\n\t\t\t<td class=\"label\" width=\"14%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"14%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"14%\">&nbsp;</td>\n\t\t\t<td class=\"label\" width=\"14%\"><div align=\"right\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></div></td>\n\t\t\t<td width=\'9%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_gross_amt\' id=\'tot_gross_amt\' size=\'4\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'9%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_disc_amt\' id=\'tot_disc_amt\' size=\'4\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'9%\' class=\"fields\">\n\t\t\t<div align=\"right\"><input type=\'text\' name=\'tot_net_amt\' id=\'tot_net_amt\' size=\'4\'  maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' readonly style=\'text-align:right\'></div>\n\t\t\t</td>\n\t\t\t<td width=\'9%\' class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'8%\' class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t</table>\n\t<table  cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\t\n\t\t<tr>\n\t\t\t<td class=\"label\" width=\"25%\">&nbsp;</td>\n\t\t\t<td width=\"25%\"  class=\'labels\' align=\'right\'>\n\t\t\t\t<div id=\'cash_counter_log_in_disp\' style=\'display:none\' >\n\t\t\t\t\t<input type=\'button\'  name=\"log_in_cash_counter_btn\" id=\"log_in_cash_counter_btn\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\'button\' onClick=\'log_in_cash_counter()\'>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t<td width=\"25%\"  class=\'labels\' align=\'right\'>\n\t\t\t\t<div id=\'cash_counter_log_out_disp\' style=\'display:none\'>\n\t\t\t\t\t<input type=\'button\'  name=\"log_out_cash_counter_btn\" id=\"log_out_cash_counter_btn\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\'button\' onClick=\'log_out_cash_counter()\'>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t<td width=\"25%\"  class=\'labels\' align=\'right\'>\n\t\t\t\t<div >\n\t\t\t\t\t<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" class=\'button\' onClick=\'cancel()\'>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t</tr>         \n\t</table> \n\t<input type= \'hidden\' name=\"billgenlater\" id=\"billgenlater\"  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type= \'hidden\' name=\"slmt_reqd_yn\" id=\"slmt_reqd_yn\"  value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\n\t<!--Added By Muthukumar on 30-1-12 for GAP -09 -->\n\t<input type=\"hidden\" name=\"dep_adjust_yn\" id=\"dep_adjust_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"dep_alert\" id=\"dep_alert\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"dep_exist\" id=\"dep_exist\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\n\t<input type=\"hidden\" name=\"bl_items_sl_no\" id=\"bl_items_sl_no\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<!-- \tAdded by Karthik for site Id Verification -->\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<input type=\'hidden\' name=\'siteId\' id=\'siteId\' id =\'siteId\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' />\n\t<!-- added by sarath making sitespecific CRF KDAH339.2 -->\n\t<input type=\'hidden\' name=\'restrictEligibility\' id=\'restrictEligibility\' id =\'restrictEligibility\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' />\n\t<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<!--Added By Muthukumar on 30-1-12 for GAP -09 -->\n\t\n</form>\t \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	CallableStatement call = null;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	String str_error_code="", str_error_text="";
	String str_deposit_alert_yn="",str_deposit_exists_YN="";
	//String str_deposit_alert_yn=request.getParameter("dep_alert");
	//String str_deposit_exists_YN=request.getParameter("dep_exist");
	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String params = request.getQueryString();
	//System.out.println("params AdhocDiscBtn.jsp:"+params);

	//Added By Muthukumar on 30-1-12 for GAP -09
	String dep_adjust_yn  = "Y";
	//Added By Muthukumar on 30-1-12 for GAP -09			

	String str_facility_id = (String) session.getValue("facility_id");
	//System.err.println("str_facility_id in Button Page --> " +str_facility_id);

	String	strloggeduser	=  (String) session.getValue("login_user");	
	if (strloggeduser==null) strloggeduser = "";

	String p_patient_id = request.getParameter("patient_id");	
	if(p_patient_id==null) p_patient_id="";	
	//System.err.println("p_patient_id in Button Page --> " +p_patient_id);

	String episode_type = request.getParameter("episode_type");	
	if(episode_type==null) episode_type="";	
	//System.err.println("episode_type in Button Page --> " +episode_type);
	
	String episode_id = request.getParameter("episode_id");	
	if(episode_id==null) episode_id="";	
	//System.err.println("episode_id in Button Page --> " +episode_id);

	String visit_id = request.getParameter("visit_id");	
	if(visit_id==null) visit_id="";	
	//System.err.println("visit_id in Button Page --> " +visit_id);

	String strclientip = p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
	//System.err.println("strclientip "+strclientip);

	String p_billgenlater = request.getParameter("billgenlater");	
	if(p_billgenlater==null) p_billgenlater="";	

	String p_gross_amt = request.getParameter("gross_amt");	
	if(p_gross_amt==null) p_gross_amt="";	

	String p_disc_amt = request.getParameter("disc_amt");	
	if(p_disc_amt==null) p_disc_amt="";	

	String p_net_amt = request.getParameter("net_amt");	
	if(p_net_amt==null) p_net_amt="";

	String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
	if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";
	
	String bl_items_sl_no = request.getParameter("bl_items_sl_no");
	if(bl_items_sl_no==null) bl_items_sl_no="";
	
	//added by sarath making sitespecific CRF KDAH339.2
	BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
	String restrictEligibility = billRestr.checkCashRestrictionEligibility(str_facility_id);
	System.out.println("restrictEligibility -- >"+restrictEligibility);
	

//Newly Added
try{
	//System.err.println("Entering into BL_CHECK_DEPOSIT_EXISTS 1");

	con	=	ConnectionManager.getConnection(request);
	//Added V200228 SHIKHA against AAKH-CRF-0112				
	try {
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BLAdhocDiscBtn.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V200228 SHIKHA against AAKH-CRF-0112
	call = con.prepareCall("call BL_CHECK_DEPOSIT_EXISTS(?,?,?,?,?,?,?,?,?)");

	//call = con.prepareCall("call BL_CHECK_DEPOSIT_EXISTS ('"+str_facility_id+"','"+p_patient_id+"','"+episode_type+"','"+episode_id+"','"+visit_id+"',?,?,?,?)");

				call.setString(1,str_facility_id);
				call.setString(2,p_patient_id);
				call.setString(3,episode_type);
				call.setString(4,episode_id);
				call.setString(5,visit_id);
				
				call.registerOutParameter(6,java.sql.Types.VARCHAR);	
				call.registerOutParameter(7,java.sql.Types.VARCHAR);	
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);

				//System.err.println("Before BL_CHECK_DEPOSIT_EXISTS ");

				call.execute();

				//System.err.println("After BL_CHECK_DEPOSIT_EXISTS ");

				str_deposit_alert_yn = call.getString(6);
				if(str_deposit_alert_yn==null) str_deposit_alert_yn="";

				str_deposit_exists_YN = call.getString(7);
				if(str_deposit_exists_YN==null) str_deposit_exists_YN="";
				
				str_error_code = call.getString(8);
	     		if(str_error_code==null) str_error_code="";

				str_error_text = call.getString(9);
				if(str_error_text==null) str_error_text="";
												
				call.close();
				
	//System.err.println("str_facility_id --> " +str_facility_id);
	//System.err.println("p_patient_id --> " +p_patient_id);
	//System.err.println("episode_type --> " +episode_type);
	//System.err.println("episode_id --> " +episode_id);
	//System.err.println("visit_id --> " +visit_id);
	//System.err.println("str_deposit_alert_yn --> " +str_deposit_alert_yn);
	//System.err.println("str_deposit_exists_YN --> " +str_deposit_exists_YN);
	//System.err.println("str_error_code --> " +str_error_code);
	//System.err.println("str_error_text --> " +str_error_text);
		}catch(Exception ec)
		{
			  System.out.println("Get the BL_CHECK_DEPOSIT_EXISTS Values " +ec);
		}	
		finally 
		{
			if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
			}

	//System.err.println("str_deposit_alert_yn" +str_deposit_alert_yn);
	//System.err.println("str_deposit_exists_YN" +str_deposit_exists_YN);	
	//System.err.println("End BL_CHECK_DEPOSIT_EXISTS ");

            _bw.write(_wl_block6Bytes, _wl_block6);
 
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		/*try{
			
				CallableStatement  call = 
						con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'))}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,str_facility_id);
						call.setString(3,blng_serv_code);
						call.setString(4,strloggeduser);
						call.setString(5,currdate);
						call.execute();				
						discount_allowed_yn = call.getString(1);		
						 if(discount_allowed_yn==null) discount_allowed_yn="";
						call.close();	
						System.out.println("discount_allowed_yn :"+discount_allowed_yn); 
			}catch(Exception ul)
			{
				System.out.println("Exception in user validation : "+ul);
			}
			finally 
			{
				if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
			}*/

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_gross_amt));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_disc_amt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_net_amt));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_gross_amt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_disc_amt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_net_amt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CASH_COUNTER_LOGIN.label","bl_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CASH_COUNTER_LOGOUT.label","bl_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_billgenlater));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_slmt_reqd_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dep_adjust_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_deposit_alert_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_deposit_exists_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bl_items_sl_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
 String siteId = BLReportIdMapper.getCustomerId(); 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(siteId ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(restrictEligibility ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(site3TierAlmoFeatureYN ));
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
