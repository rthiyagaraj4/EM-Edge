package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __informeddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/InformedDetails.jsp", 1742386947102L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\n<HEAD>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\n\t\n    \n<script>\n\nfunction ChkNumberInput1(fld, e, deci)\n{\n  if (parseInt(deci)>0)\n     var strCheck = \'.0123456789 /:\';\n  else\n     var strCheck = \'0123456789 /:\';\n\n     var whichCode = (window.Event) ? e.which : e.keyCode;\n      if (whichCode == 13) return true;  // Enter\n  \tkey = String.fromCharCode(whichCode);  // Get key value from key code\n      if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n}\n\nfunction disablefield()\n{\n\tdocument.getElementById(\"im\").style.visibility\t=\t\'hidden\';\n\tdocument.getElementById(\"Ttype\").style.visibility\t=\t\'hidden\';\n}\n\n/*  17956 Thursday, January 07, 2010 */\nfunction datefun(obj)\n{\n\tif(obj.value != \"\")\n\t{\n\t\tvar flag = validDateObj(obj,\"DMYHM\",localeName);\t\n\t\tif(!flag)\n\t\t{\t\t\n\t\t\tif(obj.name == \'informed_date\')\n\t\t\t{\t\n\t\t\t\tdocument.getElementById(\'informed_date\').value = \"\";\n\t\t\t\t//document.getElementById(\'informed_date\').focus();\n\t\t\t}\n\t\t\telse if(obj.name == \'absconding_date\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'absconding_date\').value=\"\";\n\t\t\t\t//document.getElementById(\'absconding_date\').focus();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\tvar greg_informedDate = convertDate(obj.value,\"DMYHM\",localeName,\"en\");\t\n\t\t\t\t//if(greg_date!=\"\"&& document.getElementById(\"infm_dtls_sysdate\").value!=\"\")\n\t\t\t\tif(greg_informedDate!=\"\")\n\t\t\t\t{\n\n\t\t\t\t\t//if(isAfter(greg_date,document.getElementById(\"infm_dtls_sysdate\").value,\'DMYHM\',localeName))\n\t\t\t\t\t//if(!isBeforeNow(greg_informedDate,\'DMYHM\',\'en\'))\n\t\t\t\t//\tif(!isBefore(greg_informedDate,document.getElementById(\"infm_dtls_sysdate\").value,\'DMYHM\',\'en\'))\n\t\t\t\t\tif(!isBeforeNow(greg_informedDate,\'DMYHM\',\'en\'))\n\t\t\t\t\t{\n\t\t\t\n\t\t\t\t\t\tvar error = getMessage(\"DATE1_GT_DATE2\",\"IP\");\n\t\t\t\t\t\tvar object_name = obj.name;\n\n\t\t\t\t\t\tif(obj.name == \"informed_date\")\t\t\t\t\t\n\t\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"))\t\t\t\t\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"eIP.AbscondingDateTime.label\",\"IP\"))\t\n\t\t\t\t\t\t\n\t\t\t\t\t\terror = error.replace(\'#\',getLabel(\"Common.SystemDateTime.label\",\"Common\"))\n\t\t\t\t\t\talert(error);\n\t\t\t\t\t\tobj.value = \'\'; \n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\treturn false; \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if((greg_informedDate!=\"\") && (document.getElementById(\'fromdate\').value!=\"\"))\n\t\t\t\t{\n\t\t\t\t\tif(isAfter(document.getElementById(\"infm_dtls_sysdate\").value,greg_informedDate,\'DMYHM\',\'en\'))\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\tvar error = getMessage(\"DATE1_LT_DATE2\",\"IP\"); \n\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\t\t\t\tif(document.getElementById(\'record_status\').value==\"02\")\n\t\t\t\t\t\t\terror = error.replace(\'#\',getLabel(\"eIP.AbscondingDateTime.label\",\"IP\"))\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\terror = error.replace(\"#\",getLabel(\"eIP.leavedatetime.label\",\"IP\"));\n\t\t\t\t\t\talert(error);\n\t\t\t\t\t\tobj.value = \"\";\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\treturn false; \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\tif( \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" != \"\" && greg_informedDate != null && greg_informedDate != \"\" )\n\t\t\t{\n\t\t\t\t\n\t\t\t\tvar greg_admission_date_time;\n\t\t\t\t/*if(document.forms[0].admissiondatetime!=null)\n\t\t\t\t\tgreg_admission_date_time = document.forms[0].admissiondatetime.value;\n\t\t\t\telse*/\n\t\t\t\t\tgreg_admission_date_time = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\t\t\tvar greg_maxtfrDateTime = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tif(!isBefore(greg_admission_date_time,greg_informedDate,\'DMYHM\',\'en\'))\t\t\n\t\t\t\t{\n\t\t\t\t\t/*  17956 Thursday, January 07, 2010 */\n\t\t\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t\t\t// added by mujafar for ML-MMOH-CRF-0659 start\n\t\t\t\t\t/*error = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));*/ \n\t\t\t\t\t\n\t\t\t\t\tif(obj.name == \"informed_date\")\t\t\t\t\t\n\t\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\t\t\t\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"eIP.AbscondingDateTime.label\",\"IP\"));\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t// added by mujafar for ML-MMOH-CRF-0659 end\n\t\t\t\t\t\t\n\t\t\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\"Common\"));\n\t\t\t\t\talert(error);\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus;\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse if(!isBefore(greg_maxtfrDateTime,greg_informedDate,\'DMYHM\',\'en\'))\n\t\t\t\t{\n\t\t\t\t/*  17956 Thursday, January 07, 2010 */\n\t\t\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t\t\tvar last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\'IP\');\n\t\t\t\t\tif(obj.name == \"informed_date\")\t\n\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\t\t\telse\n\t\t\t\t\t\terror = error.replace(\'$\',getLabel(\"eIP.AbscondingDateTime.label\",\'IP\'));\n\t\t\t\t\terror = error.replace(\'#\',last_encounter);\n\t\t\t\t\talert(error);\n\t\t\t\t\tobj.value = \"\";\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t}\t\t\n\t}\n\tif(obj.name == \'absconding_date\')\n\t{\n\t\tdocument.getElementById(\'absconding_rep_to\').focus();\t\n\t}\n\telse \n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \'Discharge_Advice\')/*4/21/2009 added condition for IN010016*/\n\t\t{\n\t\t\tif(document.forms[0].absconding_yn)\n\t\t\t{\n\t\t\t\tif(!document.forms[0].absconding_yn.checked)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].auth_pract_desc.focus();\t\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{ \n\t\t\t\t\tif(document.getElementById(\'ab_details\').visibility == \"visible\")\n\t\t\t\t\tdocument.forms[0].absconding_yn.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(document.forms[0].Absconding_yn)\n\t\t\t{\n\t\t\t\tif(!document.forms[0].Absconding_yn.checked)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].auth_pract_desc.focus();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{  \n\t\t\t\t\tdocument.forms[0].Absconding_yn.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t}\n}\n\n\n\n\n</script>\n</HEAD>\n\n\n<BODY onload=\'disablefield()\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n<tr >\n\t<td width=\'25%\'></td>\n\t<td width=\'30%\'></td>\n\t<td width=\'20%\'></td>\n\t<td width=\'25%\'></td>\n</tr>\n<tr>\n\t<td class=\'label\' nowrap ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="width=\'\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td nowrap class=\'fields\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" colspan=3><SELECT name=\'inform_to\' id=\'inform_to\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onChange=\"enableInformName_disch()\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="onChange=\"enableInformName()\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="onblur=\"dis_adv_focus(this);\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" tabindex = \'14\' >\n\t\t\t<option value=\"\" selected>---";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="---</option>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<option value=\"01\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<option value=\"02\"  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<option value=\"03\"  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t</SELECT>\n\t<img id=\"Ttype\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" ></td>\t\n\t\t</tr>\n\n<tr>\n\t<td width=\'20%\' nowrap class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><input type=\'text\' name=\'informed_name\' id=\'informed_name\'  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\'20\' maxlength=\'200\' disabled tabindex = \'15\'></td><!-- 17956 Thursday, January 07, 2010 -->\n\t<td width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t<td width=\'20%\' class=\'fields\' >\n\t\t<input type=\'text\' name=\'informed_date\' id=\'informed_date\'  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" disabled   onKeyPress=\'return(ChkNumberInput1(this,event,2));\' size=\'15\' maxlength=\'16\' onblur=\"datefun(this);\" tabindex=\'16\'>\n\t\t<!-- <img  name=\"infocalimg\" id=\"infocalimg\"  src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"document.forms[0].informed_date.focus();return showCalendar(\'informed_date\',null,\'hh:mm\');\" style=\"pointer-events: none;\" tabindex = \'17\'/><img id=\"im\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility: hidden\"> -->\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"document.forms[0].informed_date.select(); if(! document.forms[0].informed_date.disabled){return showCalendar(\'informed_date\',null,\'hh:mm\');}\" tabindex=\"-1\" name=\'infocalimg\' id=\'infocalimg\'> <img id=\"im\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility: hidden\">\n\t\t</td>\n</tr>\n</table>\n\n<input type=\'hidden\' name=\'infm_dtls_sysdate\' id=\'infm_dtls_sysdate\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\n\n</BODY>\n</script>\n\n</script>\n\n</HTML>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	    request.setCharacterEncoding("UTF-8");
		String called_from = checkForNull(request.getParameter("called_from"));
		String locale	= (String)session.getAttribute("LOCALE");
		String facilityID		= (String)session.getValue("facility_id");
		String selec_val="";
		String informed_to=checkForNull(request.getParameter("informed_to"));
		String ip_Trn_Date="";
		String system_date_time_trn="";
		
		selec_val				= "";
		String informed_name=checkForNull(request.getParameter("informed_name"));
		String informed_date_time=checkForNull(request.getParameter("informed_date_time"));
		String admissiondatetime=checkForNull(request.getParameter("admissiondatetime"));
		String system_date_time=checkForNull(request.getParameter("system_date_time"));
		String encounterID=checkForNull(request.getParameter("encounterID"));
		
		String informed_date_time_display = "";
		if(informed_date_time == "" || informed_date_time.equals("null"))
			informed_date_time_display = "";
		else
			informed_date_time_display = DateUtils.convertDate(informed_date_time,"DMYHM","en",locale);
		//String chkDisable = "";
		Connection con			=	null;
		Statement stmt			=	null;
		ResultSet rs			=	null;

		StringBuffer sqlSB = new StringBuffer();
			try
		{
				con = ConnectionManager.getConnection(request);
				stmt=con.createStatement();

				if (sqlSB.length() > 0)	sqlSB.delete(0, sqlSB.length());
				sqlSB.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				rs		= stmt.executeQuery(sqlSB.toString());

				if ((rs != null) && (rs.next()))
				{
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time_trn= rs.getString("system_date_time");
				}
				if (rs!=null) rs.close();
				if(stmt	!=	null) stmt.close();
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}


	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ip_Trn_Date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(called_from.equals("record_leave")){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(called_from.equals("record_leave")){ 
            _bw.write(_wl_block13Bytes, _wl_block13);
 }else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(called_from.equals("dischage_patient")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
if(called_from.equals("Discharge_Advice")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

				if (informed_to.equals("01")) selec_val = "Selected";
				else selec_val = "";	
		    
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selec_val));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

				if (informed_to.equals("02")) selec_val = "Selected";
				else selec_val = "";	
		    
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(selec_val));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

				if (informed_to.equals("03")) selec_val = "Selected";
				else selec_val = "";	
		    
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(selec_val));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(called_from.equals("record_leave")){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(informed_name));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(informed_date_time_display));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(system_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InformedTo.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InformedDate/Time.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
