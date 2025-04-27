package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eOH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ohtrmtdentalchartviewdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHTrmtDentalChartViewDetails.jsp", 1743660437061L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHTrmtDentalChartViewDetails.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/RecordDiagForTrmt.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHCommon.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n\t\t<script>\n\t\t\tasync function showMaxilaFacialDtl()\n\t\t\t\t{\n\t\t\t\t\tvar patient_id = document.forms[0].patient_id.value\n\t\t\t\t\tvar chart_num = document.forms[0].cur_chart_num.value\n\t\t\t\t\tvar header_tab = document.forms[0].header_tab.value\n\t\t\t\t\tvar oh_chart_level = document.forms[0].oh_chart_level.value\n\t\t\t\t//\tvar chart_line_num = document.forms[0].chart_line_num.value\n\t\t\t\t//\talert(patient_id+\" \"+chart_num+\" \"+chart_line_num)\n\t\t\t\t//\ttitle = encodeURIComponent(title);\n\t\t\t\t\t\n\t\t\t\t\tvar retVal = await window.showModalDialog(\"../../eOH/jsp/MaxilaFacialDetails.jsp?heading=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&header_tab=\"+header_tab+\"&oh_chart_level=\"+oh_chart_level,window,\"dialogHeight: 55vh; dialogWidth:75vw; center: yes; help: no; resizable: no; status: no;\");\n\t\t\t\t\t\n\t\t\t\t}\n\t\t</script>\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" > \n\t<!--Added by Yadav on 10/9/2009 for CRF 707-->\n <script language=\'javascript\' src=\'../../eOH/js/wz_tooltip.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t<!--end-->\n\t\t<form name=\"trmtViewDetailsForm\" id=\"trmtViewDetailsForm\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" onMouseOver= \'hideToolTip();\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t\t\t\t<!--<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menu1\',this);\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/></th>-->\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menu1\',this);\"/></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<div id=\"menuExpand2 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t\t<td id=\"menu1\" style=\'display:none\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- <tr>\n\t\t\t\t\t\t\t<div id=\"menuTasks1 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t\t<td id=\"trmt1\" style=\'display:none\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr> -->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\"  onMouseOver= \'hideToolTip();\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t\t\t\t<!--<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menu5\',this);\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/></th>-->\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menu5\',this);\"/></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\n\n\t\t\t\t\t\t<div id=\"menuExpand3 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menu5\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n                    </tr>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\t\t\t<td><table width=\"100%\" border=\"0\"  onMouseOver= \'hideToolTip();\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"GS_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuSummary\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand1 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuSummary\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\t\t<td><table width=\"100%\" border=\"0\" onMouseOver= \'hideToolTip();\' >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t\t\t\t<!--<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuBC\',this);\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/></th>-->\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"T_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuBC\',this);\"/></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand4 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuBC\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- added by parul for Enterprise Specific Chart Applicable -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\t\t\t<td><table width=\"100%\" border=\"0\"  onMouseOver= \'hideToolTip();\'>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"FC_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuFC\',this);\" /></th>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<div id=\"menuExpand5 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t\t\t<td id=\"menuFC\" style=\'display:none\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\t\t\t<td><table width=\"100%\" border=\"0\"  onMouseOver= \'hideToolTip();\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t\t\t\t\t\t<!--<th align=\"right\"  width=\"10%\"><img name=\"OL_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuOL\',this);\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/></th>-->\n\t\t\t\t\t\t\t\t\t<th align=\"right\"  width=\"10%\"><img name=\"OL_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuOL\',this);\"/></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand6 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuOL\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<!-- <tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\"  width=\"10%\"><img name=\"OL_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuLBRD\',this);\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand6 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuLBRD\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n            </table>\n\n\n\t\t\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type = \"hidden\" name= \"locale\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type = \"hidden\" name= \"location_code\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type = \"hidden\" name= \"location_type\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<input type = \"hidden\" name= \"episode_id\" value = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type = \"hidden\" name= \"episode_type\" value = \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type = \"hidden\" name= \"visit_id\" value = \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'> \n\t\t\t<input type = \"hidden\" name= \"practitioner_id\" value = \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\n\t\t\t<input type = \"hidden\" name= \"source_code\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type = \"hidden\" name= \"source_type\" value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<input type = \"hidden\" name= \"baseline_chart_yn\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\n\t\t\t<input type = \"hidden\" name= \"upper_arch_desc\" value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type = \"hidden\" name= \"lower_arch_desc\" value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q1_id\" value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q2_id\" value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q3_id\" value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q4_id\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q1_desc\" value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q2_desc\" value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q3_desc\" value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q4_desc\" value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type = \"hidden\" name= \'mixed_dentition_YN\' value=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" >\n\t\t\t<input type = \"hidden\" name= \'chart_type\' value=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >\n\t\t\t<input type = \"hidden\" name= \'header_tab\' value=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >\n\t\t\t<input type = \"hidden\" name= \'chart_num\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n\t\t\t<!--  Commented and Added by Sharon Crasta on 3/18/2009 for other facility chart CRF#0423 -->\n\t\t\t<input type = \"hidden\" name= \'cur_chart_num\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n\t\t\t<!--input type = \"hidden\" name= \'cur_chart_num\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >-->\n\t\t\t<!-- -->\n\t\t\t<input type = \"hidden\" name= \'remarks\' value=\'\' >\n\t\t\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >\n\t\t\t<input type=\"hidden\" name=\"gingival_recording_by\" id=\"gingival_recording_by\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' >\n\t\t\t<input type=\"hidden\" name=\"record_gingival_status_yn_param\" id=\"record_gingival_status_yn_param\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n\t\t\t \n\n\t\t\t<input type = \"hidden\" name= \'billing_appl_yn\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >\n\t\t\t<input type = \"hidden\" name= \'or_interface_flag\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' >\n\t\t\t<input type = \"hidden\" name= \'link_lab_flag\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t<!--  Added by Sharon Crasta on 3/14/2009 for other facility chart CRF#0423 -->\n            <input type=\"hidden\" name=\"other_facilitychart_yn\" id=\"other_facilitychart_yn\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' >\n            <input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' >\n            <input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' >\n\t\t\t<input type=\"hidden\" name=\"ord_id0\" id=\"ord_id0\" value = \'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t<input type = \"hidden\" name= \"order_id\" value = \'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->\n\t\t\t<input type=\"hidden\" name=\"dflt_mixed_dentition_chart\" id=\"dflt_mixed_dentition_chart\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\n\t\t\t<input type=\"hidden\" name=\"dentist_comments\" id=\"dentist_comments\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"otFlag\" id=\"otFlag\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\n\t\t\t<!-- -->\n\t\t\t<!--Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920) -->\n\t\t\t<input type=\"hidden\" name=\"date_diff_flag\" id=\"date_diff_flag\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t\t\t<!-- -->\n\n\t\t\t<!-- Parameters for Diagnosis function -->\n\t\t\t<input type = \"hidden\" name= \'option_id\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' >\n\t\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' >\n\t\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' >\n\t\t</form>\n\n<!-- Added by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\' >\n\t<table id=\'tooltiptable\' cellpadding=\"3\" cellspacing=0 border=\'0\' width=\'100%\' align=\'center\' >\n\t\t<tr id=\'tooltiprow\'>\n\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div> \n<!--End -->\n\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

String MaxilaFacialDetails = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.MaxilaFacialDetails.Label","OH");
	String oh_bean_id 		= "OHBillingBean";
	String oh_bean_name 	= "eOH.OHBillingBean";
	OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String gingival_recording_by = "";
	String or_interface_flag = "";
	String status = "";
	String link_lab_flag = "";
	
	String disabled = "";
	String billing_appl_yn = "N";
	String params	= request.getQueryString();
	String tooth_numbering_system	= checkForNull(request.getParameter("tooth_numbering_system"));
	String upper_arch_desc			= checkForNull(request.getParameter("upper_arch_desc"));
	String lower_arch_desc			= checkForNull(request.getParameter("lower_arch_desc"));
	String Q1_id					= checkForNull(request.getParameter("Q1_id"));
	String Q2_id					= checkForNull(request.getParameter("Q2_id"));
	String Q3_id					= checkForNull(request.getParameter("Q3_id"));
	String Q4_id					= checkForNull(request.getParameter("Q4_id"));
	String Q1_desc					= checkForNull(request.getParameter("Q1_desc"));
	String Q2_desc					= checkForNull(request.getParameter("Q2_desc"));
	String Q3_desc					= checkForNull(request.getParameter("Q3_desc"));
	String Q4_desc					= checkForNull(request.getParameter("Q4_desc"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN        = checkForNull(request.getParameter("mixed_dentition_YN"));
	String date_diff_flag        = checkForNull(request.getParameter("date_diff_flag"));

	String otFlag=checkForNull(request.getParameter("called_from"));
	String called_from=checkForNull(request.getParameter("called_from"));
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String header_tab = checkForNull(request.getParameter( "header_tab" )) ;
	String location_type = checkForNull(request.getParameter( "location_type" )) ;
	String location_code = checkForNull(request.getParameter( "location_code" )) ;

	String option_id = checkForNull(request.getParameter("option_id"));
	String sex = checkForNull(request.getParameter("Sex"));
	String dob = checkForNull(request.getParameter("Dob"));
	String bed_num = checkForNull(request.getParameter("bed_num"));
	String room_num = checkForNull(request.getParameter("room_num"));
	String visit_adm_date = checkForNull(request.getParameter("visit_adm_date"));

	//String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
	String source_code = checkForNull(request.getParameter( "location_code" )) ;
	String source_type = checkForNull(request.getParameter( "location_type" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" ));
	if(date_diff_flag.equals("disable")){
		disabled = "disabled";
	}

	boolean billing_installed = oh_bean.isBillingInstalled(facility_id);

	if(billing_installed == true){
		billing_appl_yn = "Y";
	}
	else{
		billing_appl_yn = "N";
	}


	String record_gingival_status_yn_param = checkForNull(request.getParameter( "record_gingival_status_yn_param" )) ;
	// Added by Sharon Crasta on 3/14/2009  for other facility chart CRF#0423
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;
	String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" ));

	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	//
	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;
	//
	try{
	con = ConnectionManager.getConnection(request);
	// Added by Sharon Crasta on 3/14/2009  for other facility chart CRF#0423
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}

	//
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	/*
	pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,OR_INTERFACE_FLAG FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
	pstmt.setString(1,facility_id);
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		or_interface_flag = checkForNull(rs.getString("OR_INTERFACE_FLAG"));
	}
	*/

	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM");
	}else{//End
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
		pstmt.setString(1,facility_id);
	}
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		//or_interface_flag = checkForNull(rs.getString("OR_INTERFACE_FLAG"));
	}

	//written by parul on 160908
	pstmt = con.prepareStatement("SELECT CHART_STATUS FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID=? AND  PATIENT_ID=?  AND CHART_STATUS='A' ");
	pstmt.setString(1,facility_id);
	pstmt.setString(2,patient_id);
	rs=pstmt.executeQuery();
	while(rs!=null && rs.next()){
			status = checkForNull(rs.getString("CHART_STATUS"));
		}

		  if(status.equals("A")){
			  if (baseline_chart_yn.equals("Y")){
			   link_lab_flag="N";
		     }else{
			  link_lab_flag="Y";
		   }
	   }  
		//

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(MaxilaFacialDetails));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);

						  //if (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					  
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

							//}
						
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);

                             if (oh_chart_level.equals("F")){							
						
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

							}
						
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(!called_from.equals("OT")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);

							//if(or_interface_flag.equals("Y")){
						
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block27Bytes, _wl_block27);

						 // }
						
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(params));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkForNull(request.getParameter("episode_id"))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(checkForNull(request.getParameter("episode_type"))));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkForNull(request.getParameter("visit_id"))));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(header_tab));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(checkForNull(request.getParameter("new_chart_num"))));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(checkForNull(request.getParameter("chart_num"))));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(checkForNull(request.getParameter("cur_chart_num"))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(gingival_recording_by));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(record_gingival_status_yn_param));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(billing_appl_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(or_interface_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(link_lab_flag));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_id" ))));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(checkForNull(request.getParameter( "order_id" ))));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(dflt_mixed_dentition_chart));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(dentist_comments));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(otFlag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block83Bytes, _wl_block83);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsToDo.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsDone.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.BaselineCharts.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.OtherFacilityCharts.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.OtherLinks.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LabRadiology.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
