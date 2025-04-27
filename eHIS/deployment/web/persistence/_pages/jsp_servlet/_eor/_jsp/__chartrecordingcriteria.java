package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ChartRecordingCriteria.jsp", 1709119652000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" OnLoad=\'defaultValue()\'>\n<form name =\"ChartLayoutCriteriaForm\"  >\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\"  width=\"100%\"  >\n<tr><td colspan=\'2\'  width=\'43%\'>\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tbId\' width=\"100%\" valign=\'bottom\'>\n<tr><td width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</td><td width=\'25%\' class=\'fields\'  nowrap >\n\t\t<select name=chart_id onchange=\"loadChart(this)\" >\n\t\t\t<option value=\"\">-----------";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="-----------</option>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</select>\n<img align=center src=\'../../eCommon/images/mandatory.gif\'></img></td>\n</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<tr>\n<td width=\'25%\' class=\'label\' nowrap>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</td>\n<td  width=\'25%\' class=\'fields\' colspan=\'2\'>\n\t<input  type=\'text\' size=\'14\'  name=rec_time value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" OnBlur=\'CheckDateTime(this)\' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength=\'16\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'rec_time\')\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n</td>\n</tr>\n<tr>\n<td colspan=\'3\'  width=\'100%\' class=\'label\'>\n<input type=\'button\' class=\'button\' name=\'buttonAddItem\' id=\'buttonAddItem\'  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' OnClick=\'loadPanels()\' style=\'visibility:hidden\'>\n<input type=\'button\' class=\'button\' name=\'buttonShowRec\' id=\'buttonShowRec\'  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' OnClick=\'openWiinForRecording()\' style=\'display:none\'>\n</td>\n</tr>\n<tr><td colspan=1></td></tr>\n<tr><td colspan=1></td></tr>\n</table>\n</td>\n<td colspan=\'2\' width=\'57%\'>\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tableId2\' width=\"100%\" >\n<!-- <tr>\n<td colspan=\'3\' class=\'label\' align=\'left\'>\n<B>Previous Recording</B>\n</td>\n</tr>\n -->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n <tr>\n<td  colspan=\'2\' class=\'label\'  width=\'100%\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;<input type=\'checkbox\' name=\'detailYN\' id=\'detailYN\'  OnClick=\'filterToSummary()\' checked></td>\n<td class=label width=\'25%\'>\n<label class=\'label\' id=\'labelSummary\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</label>&nbsp<input type=\'checkbox\' name=\'summaryYN\' id=\'summaryYN\'  OnClick=\'filterToSummary()\' checked></td>\n</tr>\n<tr>\n<td class=label width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</td>\n<td width=\'25%\' class=\'fields\' colspan=2>\n\t<select name=\'sort_by_asc_desc\' id=\'sort_by_asc_desc\' onchange=\'valForSort(this)\'>\n\t\t<option value = \'D\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t<option value = \'A\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t</select>\n<!-- Grand Summary&nbsp;<input type=\'checkbox\' name=\'grandsummaryYN\' id=\'grandsummaryYN\'  OnClick=\'\' checked style=\'display:none\'> -->\n</td>\n</tr>\n<tr>\n<td  class=\'label\' width=\'25%\'>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</td><td width=\'25%\' class=\'fields\' colspan=2>\n<input type=\'textbox\' id=\'fromDate\' name=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'14\' maxlength=\'16\' onblur=\"CheckDateTime(this)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'fromDate\')\"></img>-<input type=\'textbox\' id=\'toDate\' name=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' size=\'14\' maxlength=\'16\' onblur=\"CheckDateTime(this);ValidateDateTimeOfPeriod(document.getElementById(\"fromDate\"),document.getElementById(\"toDate\"),\'DMYHM\')\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'toDate\')\"></img><img ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" id = \'forExtPat\' align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\n</td>\n</tr>\n<tr>\n<td   width=\'25%\' class=\'label\'>\n<label id=\'labelScope\' class=\'label\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</label></td>\n<td class=\'fields\' width=\'25%\'><input type=hidden name=\'past_scope\' id=\'past_scope\' value=\'\'>\n<input type=\'text\' name=\'summaryText\' id=\'summaryText\' size=\'4\' maxlength=\'2\' OnKeyPress=\'return allowValidNumber(this, event,2,0)\' value=\'1\' Onchange=\'\' OnBlur=\"resetValuesForCriteria(this,past_scope);checkSequence(this);\"><label id=\'labelScope\' class=\'label\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n</td>\n</tr>\n<tr><td class=\'label\' width=\'25%\' ></td><td width=\'25%\' align=\'right\'colspan=2>\n<input type=\'button\' name=\'Search\' id=\'Search\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' class=button onclick=\"SearchChart(\'jsp\')\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=button onclick=\"resetCriteria();\">\n</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\"  id=\'tableId1\' width=\"100%\">\n<tr>\n<td colspan=\'3\'  id =\'tdIdForClassCriteria\'  align=\'right\' width=\'100%\' class=\'label\'>\n<label id=\'label\' style=\'display:none\'></label>\n <input type=\'button\' class=\'button\' name=\'buttonFirst\' id=\'buttonFirst\'  value=\'<<\' OnClick=\'getRecords(this)\' style=\'visibility:hidden\'> \n\n\n<input type=\'button\' class=\'button\' name=\'buttonPrev\' id=\'buttonPrev\'  value=\'<\' OnClick=\'getRecords(this)\' style=\'visibility:hidden\'>\n\n\n<label id=\'dayView\' style=\'display:none\'></label>\n<a href=\'javascript:\' OnClick=\'getDay()\'  title=\'Click here for other Day Record\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'imgDate\' border=\'0\' style=\'display:none\'></img>\n</a>\n\n<input type=\'button\' class=\'button\' name=\'buttonNext\' id=\'buttonNext\'  value=\'>\' OnClick=\'getRecords(this)\' style=\'visibility:hidden\'>\n\n\n <input type=\'button\' class=\'button\' name=\'buttonLast\' id=\'buttonLast\'  value=\'>>\' OnClick=\'getRecords(this)\' style=\'visibility:hidden\'>\n\n</td>\n</tr>\n</table>\n\n<script language=javascript>\n /*var date = new Date();\n var hr = date.getHours(); if ( hr >=0 && hr <=9 ) hr=\'0\'+hr ;\n  var min = date.getMinutes(); if ( min >=0 && min <=9) min=\'0\'+min ;\n\n var currdatetime = date.getDate()+\'/\'+((date.getMonth())+1)+\'/\'+date.getYear()+\' \'+hr+\':\'+min;\ndocument.forms[0].rec_time.value = \tcurrdatetime\n*/\nsetTimeout(\"loadChart();\",500);\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<input type=hidden name=qs value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=hidden name=\'Sex\' id=\'Sex\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=hidden name=\'adm_date\' id=\'adm_date\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=hidden name=\'detailDate\' id=\'detailDate\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=hidden name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=hidden name=\'toDateForExt\' id=\'toDateForExt\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=hidden name=\'fromDateForExt\' id=\'fromDateForExt\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=hidden name=\'fromDateExcludingTime\' id=\'fromDateExcludingTime\' value=\'\'>\n<input type=hidden name=\'detailSelectHidden\' id=\'detailSelectHidden\' value=\'\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'\'>\n\n<input type=hidden name=\'toolTipForLast\' id=\'toolTipForLast\' value=\'\'>\n<input type=hidden name=\'toolTipForFirst\' id=\'toolTipForFirst\' value=\'\'>\n<input type=hidden name=\'toolTipForNext\' id=\'toolTipForNext\' value=\'\'>\n<input type=hidden name=\'toolTipForPrev\' id=\'toolTipForPrev\' value=\'\'>\n\n<input type=hidden name=\'maxRecord\' id=\'maxRecord\' value=\'\'>\n<input type=hidden name=\'sortValue\' id=\'sortValue\' value=\'D\'>\n<input type=hidden name=\'errorAuth\' id=\'errorAuth\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=hidden name=\'flagStringValue\' id=\'flagStringValue\' value=\'\'>\n<input type=hidden name=\'function_from\' id=\'function_from\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=hidden name=\'detDate\' id=\'detDate\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=hidden name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\n<input type=hidden name=\'splChartType\' id=\'splChartType\' value=\'\'>\n<input type=hidden name=\'DEFINE_MODIFIABLE_AT_TRN_YN\' id=\'DEFINE_MODIFIABLE_AT_TRN_YN\' value=\'\'>\n<input type=hidden name=\'modifyYN\' id=\'modifyYN\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=hidden name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\n<script>\nif(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' == \'Y\')\n\talignHeightWidth();\n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String function_from= request.getParameter("function_from") == null ? "" : request.getParameter("function_from");
String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

String textReadOnly = "";
String imageDisabled = "";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

if(function_from.equals("CP"))
{
	textReadOnly = " readOnly ";
	imageDisabled = " disabled ";
}
else
{
	textReadOnly = "";
	imageDisabled = "";
}

String chartRef= request.getParameter("chartRef")==null?"":request.getParameter("chartRef");
String chtId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
String facility_id = session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
String sysdate = "";
String encounterId = request.getParameter("encounter_id")==null ? "0" : request.getParameter("encounter_id");
String module_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");


if(encounterId.equals("")) encounterId = "0";

String fromDateForExt = "";
String toDateForExt = "";
String displayMandatory = " style = display:none";

if(encounterId.equals("0"))
	displayMandatory = " style = display:inline";
else
	displayMandatory = " style = display:none";


            _bw.write(_wl_block5Bytes, _wl_block5);


	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs= null;
			String systime ="";
			String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
			String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
			String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
			String pract_type =(String) session.getValue("practitioner_type")==null ? "" : (String) session.getValue("practitioner_type");
			String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
			String respId = (String)	session.getValue("responsibility_id")==null ? "" :(String)	session.getValue("responsibility_id") ;
			String relnId = (String)	session.getValue("relationship_id")==null ? "" :(String)	session.getValue("relationship_id") ;
			String sqlAuth = "";
			String errorAuth = "";
			try
			{
				con = ConnectionManager.getConnection(request);
			try
			{
				PreparedStatement pstmtAuth = null;
				ResultSet resAuth = null;
				sqlAuth = "SELECT GET_TASK_APPLICABILITY('MARK_CHART_ERROR',NULL,?,?,?,?,?), 'Y' ERR_EXIST   FROM DUAL";

				pstmtAuth = con.prepareStatement(sqlAuth);
				pstmtAuth.setString(1,respId);
				pstmtAuth.setString(2,relnId);
				pstmtAuth.setString(3,facility_id);
				pstmtAuth.setString(4,encounterId);
				pstmtAuth.setString(5,patient_id);

				resAuth = pstmtAuth.executeQuery();
	
				if (resAuth.next())
					errorAuth =resAuth.getString(1);
				
				if(pstmtAuth != null) pstmtAuth.close();
				if(resAuth != null) resAuth.close();
			}
			catch(Exception e)
			{
				//out.println("Exception in try-Auth of ChartRecordingCriteria.jsp ="+e.toString());//COMMON-ICN-0181
				e.printStackTrace(System.err);
			}

			String location_type="";

			if ((patient_class.equals("OP")) ||(patient_class.equals("EM")))
			   location_type="C";
			else
			   location_type="N";
			StringBuffer sql = new StringBuffer();
		/*	sql.append("select a.CHART_ID,a.SHORT_DESC   from ca_chart a where a.eff_status='E'   and ");
			if(encounterId.equals("0"))
			{
				sql.append(" a.CONFIG_TYPE = 'N' and ");
			}			
			sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); 

			//try
			//{
				String chart_Default="";
			
				if(!chartRef.equals(""))
				{ 
					 sql.append("  and  chart_id  in (select chart_id from ca_custom_chart  where CUST_CHART_REF=? )  ");
					chart_Default=" selected ";
				}
				if(!chtId.equals(""))
				{ 
					 sql.append("  and  chart_id =?  ");
					chart_Default=" selected ";
				}
				
				sql.append(" ORDER BY 2");
			*/
				sql.append("select a.CHART_ID,A.SHORT_DESC   from ca_chart_LANG_VW a where a.eff_status='E'   and language_id = ? and ");
	
				if(encounterId.equals("0"))
					sql.append(" a.CONFIG_TYPE = 'N' and ");
		
				    sql.append(" EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id)  AND  EXISTS (select 1 from ca_chart_applicablity	 where       (PATIENT_CLASS='*A' or PATIENT_CLASS=?)  AND (SPECIALITY_CODE='*ALL' or SPECIALITY_CODE=NVL((SELECT SPECIALTY_CODE FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?),'*ALL') ) and (PRACT_TYPE='*A' or PRACT_TYPE=?) AND (LOCN_TYPE_IND='*' OR LOCN_TYPE_IND=?) and (LOCN_CODE='*ALL' OR LOCN_CODE=?) AND (AGE_GROUP_CODE='*ALL'  OR  EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX))  AND CHART_ID =A.CHART_ID)  "); 

				String chart_Default="";
			
				if(!chartRef.equals(""))
				{ 
					 sql.append("  and  chart_id  in (select chart_id from ca_custom_chart  where CUST_CHART_REF=? )  ");
					 chart_Default=" selected ";
				}
				if(!chtId.equals(""))
				{ 
					 sql.append("  and  chart_id =?  ");
					 chart_Default=" selected ";
				}

			     sql.append(" ORDER BY 2");

				//System.out.println("sql...."+sql.toString());
				int index=0;
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(++index,locale);
				pstmt.setString(++index,patient_class);
				pstmt.setString(++index,facilityId);
				pstmt.setString(++index,encounterId);
				pstmt.setString(++index,pract_type);
				pstmt.setString(++index,location_type);
				pstmt.setString(++index,location_code);
				pstmt.setString(++index,patient_id);
				if(!chartRef.equals(""))
				{ 
					pstmt.setString(++index,chartRef);
				}
				if(!chtId.equals(""))
				{ 
					pstmt.setString(++index,chtId);
				} 
				rs = pstmt.executeQuery();
				String chartId = "";
				String chartDesc = "";
			
				while(rs.next())
				{
					chartId = rs.getString(1);
					chartDesc = rs.getString(2);
					
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chart_Default));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chartDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

				
				}

				/*if(!rs.next())
				{
					out.println("<script>alert('no discrete measures for this chart');</script>");
					out.println("<script>if(top.content == null) window.close();</script>");					
				}*/

				if (pstmt!=null) pstmt.close();
				if( rs!=null) rs.close();

				if(function_from.equals("") || modifyYN.equals("N") || (function_from.equals("CP") && module_id.equals("OR")))
				{
					systime		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					sysdate		=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				
					if(encounterId.equals("0"))
					{
						fromDateForExt = sysdate + " 00:00";
						toDateForExt = sysdate + " 23:59";
					}
					else if(!encounterId.equals("0"))
					{
						fromDateForExt = "";
						toDateForExt = "";
					}
				}
				else
				{
					systime = 	request.getParameter("p_start_date_time")==null ? "" : request.getParameter("p_start_date_time");
					if (systime.equals(""))
					{
							systime		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					}
				/*	else 
					{
							systime	=	com.ehis.util.DateUtils.convertDate(systime,"DMYHM","en",locale);
					} */
				}
			}
			catch(Exception e)
			{
				out.println(e.toString());
			}
			finally
			{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}

            _bw.write(_wl_block14Bytes, _wl_block14);

	if(modifyYN.equals("Y"))
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(systime));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(textReadOnly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(imageDisabled));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ModifyScope.label","ca_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PastRecords.label","ca_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);

	}

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fromDateForExt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(toDateForExt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(displayMandatory));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")
));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(toDateForExt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fromDateForExt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(request.getParameter("p_start_date_time")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Chart.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SortOrder.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.descending.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ascending.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Scope.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
}
