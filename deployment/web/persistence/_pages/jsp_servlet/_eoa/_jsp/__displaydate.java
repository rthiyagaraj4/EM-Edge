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
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __displaydate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DisplayDate.jsp", 1709119233209L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t\t<Script src=\"../../eOA/js/ChangeDate.js\" language=\"JavaScript\"></Script>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<head>\n\n\t</head>\n<script>\nfunction disable_go()\n{\n\tif(document.forms[0].hddTracker.value==\"MR\" || document.forms[0].hddTracker.value==\"OP_RV\")\n\t{\n\t\t\n\t\tdocument.forms[0].go.disabled=true;\n\t\tdocument.forms[0].valid_date.disabled=true;\n\t\tdocument.getElementById(\"cal1\").disabled=true;\n\t}else\n\t{\n\t\tdocument.forms[0].go.disabled=false;\n\t\tdocument.forms[0].valid_date.disabled=false;\n\t\tdocument.getElementById(\"cal1\").disabled=false;\n\t}\n\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'==\'B\'){\n\t\tdocument.forms[0].date_of_expiry.disabled=true;\n\t\tdocument.forms[0].cal1.disabled=true;\n\t\tdocument.forms[0].go.disabled=true;\n\t}\n}\n</script>\n\n\n\n\t<body onload=\'disable_go();\'onmousedown =\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n\t<form name=image>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<br>\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<table border=0 width=\'100%\' cellspacing=\'0\' cellpadding=\'0\'>\n\n <tr>\n\t\t<td class=label   nowrap width=\'11%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\n\t\t<td  class=fields nowrap width=\'15%\'><input type=hidden name=\"cur_dt\" id=\"cur_dt\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input id=\"date_of_expiry\" type=text size=10 maxlength = 10 name=\'valid_date\' id=\'valid_date\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onfocus=\"enabgo(this);\" onblur=\"DateCheck_new(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',this)\" tabindex=1 ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onkeypress=\"return check_val(event)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'cal1\' onClick=\"document.forms[0].valid_date.select();return showCalendar(\'date_of_expiry\',null); \" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t</td>\n\t\t<td class=\'label\' id = day1 width=\'10%\' nowrap><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td>\n\n\t\t<td align=\'left\'  nowrap width=\'5%\'><input type=\'button\' name=\'go\' id=\'go\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \' class=\'button\' onfocus=\"alt_fn();\" onClick=\'blankdatechk();\'  > </td>\n\t\t<!--below line is commented and next one is added for Bru-HIMS-CRF-173-->\n\t\t<!--<td colspan=\'2\' width=\'35%\'>&nbsp</td>-->\n\t\t<td colspan=\'1\' width=\'35%\' ><input type=\'button\' class=\'button\'  name=\'ViewWaitList\' id=\'ViewWaitList\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\'viewWaitList(\"view\")\' ></td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<td align=\'left\'  nowrap width=\'35%\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \' class=\'button\' onClick=\'window.close();\'> </td>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t</tr>\n</table>\n\n\t<input type=\'hidden\' size=\'\' name=\'gggg\' id=\'gggg\' value=\"\" >\n    <input type=\'hidden\' name=\'clinic\' id=\'clinic\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t<input type=\'hidden\' name=\'changed_date\' id=\'changed_date\' value=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n\t<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\' value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n\t<input type=\'hidden\' name=\'decide\' id=\'decide\' value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n\t<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >\n\t<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t<input type=\'hidden\' name=\'mode_find\' id=\'mode_find\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >\n\t<input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >\n\t<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t<input type=\'hidden\' name=\'move\' id=\'move\' value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >\n\t<input type=\'hidden\' name=\'hddTracker\' id=\'hddTracker\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"display_validate_date\" id=\"display_validate_date\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<input type=\'hidden\' name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t<input type=\"hidden\" name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\"hidden\" name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\"hidden\" name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t<input type=\"hidden\" name=\'position\' id=\'position\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\"hidden\" name=\'addtl_splty\' id=\'addtl_splty\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</form>\n</body>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<script>\n\t\tdocument.forms[0].valid_date.focus();</script>\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</html>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
      // Modified for CRF - SRR -0425 -- Order Catalog.
   
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String mode_find="";
			String read_only_date="";
			String valid_date_display="";
			String locale=(String)session.getAttribute("LOCALE");

			String ca_mode=(String)request.getParameter("ca_mode");
			if(ca_mode==null || ca_mode.equals("") || ca_mode.equals("null"))
			   ca_mode="";
			mode_find=(String)request.getParameter("mode_find");
			if(mode_find==null || mode_find.equals("null")) mode_find="";
			String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
			if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
			String clinic_code=(String)request.getParameter("clinic_code");
			String practitioner_id=(String)request.getParameter("practitioner_id");
			String value12=(String)request.getParameter("value12");
			if(value12 == null)value12="";
			String value13=(String)request.getParameter("value13");
			if(value13 == null) value13="";
			String date=(String)request.getParameter("Date");
			String old_date=(String)request.getParameter("old_date");
			if(old_date  == null || old_date.equals("null")) old_date="";
			String decide=(String)request.getParameter("decide");
			if(decide == null || decide.equals("null")) decide="";
			String valid_date = request.getParameter("valid_date");
			if( valid_date == null) valid_date="";
			String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
			String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//for pending orders
			String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
			String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

			String old_from_time = request.getParameter("old_from_time");
			if( old_from_time == null) old_from_time="";

			String old_to_time = request.getParameter("old_to_time");
			if( old_to_time == null) old_to_time="";

			String sysdate="";
			String callingMode= request.getParameter("callingMode");

			String clinic_type=request.getParameter("clinic_type");
			String res_type=request.getParameter("res_type");

			if (clinic_type==null) clinic_type = "C";
			if (res_type==null) res_type = "P";

			String visit_limit_rule=request.getParameter("visit_limit_rule");
			if(visit_limit_rule == null) visit_limit_rule="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
			String alcn_criteria=request.getParameter("alcn_criteria");
			if(alcn_criteria == null) alcn_criteria="";

			String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
			if(slot_appt_ctrl == null) slot_appt_ctrl="";

			String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";

			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
			if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
			//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

  	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
	String disabled="";
	if(wtListControl.equals("B")){
		disabled="disabled";
	}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block10Bytes, _wl_block10);

	if(ca_mode.equals("ca_mode")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			PreparedStatement pstmt=null;
		try
		{
			 con = ConnectionManager.getConnection(request);
			 stmt = con.createStatement();
			 String display="";
			 String day1="";

				//rs=stmt.executeQuery("select replace(to_char(to_date('"+date+"','dd/mm/yyyy'), 'Day, Month,dd,yyyy'),'','')dat_val,to_char(sysdate,'dd/mm/yyyy')dat_val1,to_char(to_date('"+valid_date+"','dd/mm/yyyy'),'Day') day1 from dual");
				String sql1 = "select replace(to_char(to_date(?,'dd/mm/yyyy'), 'Day, Month,dd,yyyy'),'','')dat_val,to_char(sysdate,'dd/mm/yyyy')dat_val1,to_char(to_date(?,'dd/mm/yyyy'),'Day') day1 from dual";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,date);
				pstmt.setString(2,valid_date);
				rs = pstmt.executeQuery();
				if(rs !=null ){
				while(rs.next()){
			
				 display=rs.getString("dat_val");
				  if(display ==null) display="";
				 sysdate=rs.getString("dat_val1");
				  if(sysdate==null) sysdate="";
				 day1=rs.getString("day1");
				  if(day1 ==null) day1="";

			}
				}
				if(rs !=null) rs.close();


day1=day1.trim();
String day_show="";
		if(day1.equals("Sunday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day1.equals("Monday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day1.equals("Tuesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day1.equals("Wednesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day1.equals("Thursday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day1.equals("Friday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day1.equals("Saturday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
			 valid_date_display=DateUtils.convertDate(valid_date,"DMY","en",locale);	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(valid_date_display));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(read_only_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(read_only_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(day_show));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(wtListControl.equals("B")){
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(decide));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(display));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(valid_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(position));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block58Bytes, _wl_block58);

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) 
{ 
    //out.println("exception  here :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block59Bytes, _wl_block59);

	if(!ca_mode.equals("ca_mode")){
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ViewWaitList.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
