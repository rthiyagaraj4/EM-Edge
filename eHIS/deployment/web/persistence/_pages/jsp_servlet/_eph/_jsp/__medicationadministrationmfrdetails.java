package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.DecimalFormat;
import ePH.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationadministrationmfrdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationMFRDetails.jsp", 1709120946205L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></script>\t\t\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t\t<script language=\"JavaScript\" SRC=\"../../eCommon/js/DateUtils.js\"></script>\t\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script>\n\t\tfunction closeWindow(){\n\t\t\twindow.close();\n\t\t}\n\t\tfunction returnMFRDetails(){\n\t\t\tvar frmobjMFRDet=document.MedicationAdministrationMFRDetails;\t\t\t\n\t\t\tvar retVal=new Array();\n\t\t\tvar rowVal=new Array();\n\t\t\tretVal[0]=frmobjMFRDet.totalNoOfRows.value;\n\t\t\tretVal[1]=frmobjMFRDet.order_id.value;\n\t\t\tvar locale=frmobjMFRDet.locale.value;\n\t\t\ttotalrows=parseInt(frmobjMFRDet.totalNoOfRows.value);\n\t\t\tvar count=0;\n\t\t\tvar trows=1;\n\t\t\twhile(trows<totalrows){\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.FlowStatus\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.srl_no\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.holdMinutes\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.gaphours\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.holdDateTime\"+trows).value;\n\t\t\t \trowVal[count++]= convertDate(eval(\"frmobjMFRDet.MFR_inf_date_time_\"+trows).value,\"DMYHM\",locale,\"en\");\n\t\t\t \trowVal[count++]= convertDate(eval(\"frmobjMFRDet.MFR_end_date_time_\"+trows).value,\"DMYHM\",locale,\"en\");\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.inf_prd\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.MFR_flow_rate_\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.MFR_batch_id_\"+trows).value;\n\t\t\t \trowVal[count++]= convertDate(eval(\"frmobjMFRDet.MFR_exp_dt_\"+trows).value,\"DMY\",locale,\"en\");\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.resumeDateTime\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.completedMinutes\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.completedFlow\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.Newly_Admin_\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.iv_trade_id_\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.iv_bin_code_\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.inf_volume_\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.tot_strength_uom\"+trows).value;\n\t\t\t \trowVal[count++]= eval(\"frmobjMFRDet.MFR_flow_rate_\"+trows).value;\n\t\t\t\ttrows++;\n\t\t\t}\n\t\t\tretVal[2]=rowVal;\n\t\t\twindow.returnValue = retVal;\n\t\t\twindow.close();\n\t\t}\n\t\t</script>\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<form name=\"MedicationAdministrationMFRDetails\" id=\"MedicationAdministrationMFRDetails\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\"  noresize>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td Style=\"background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =": <b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </b></td>\n\t\t\t\t\t\t<td align=\"right\" Style=\"background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" &nbsp;</td>\n\t\t\t\t\t\t<td Style=\"background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\"><textarea readonly style=\'height:30px;width:2in\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</textarea></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td>&nbsp</td></tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\"  noresize>\n\t\t\t\t<tr id=\"iv_admin_table_row1\">\n\t\t\t\t\t<td class=\"TDSTYLE\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" #</td>\n\t\t\t\t\t<td class=\"TDSTYLE\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\"TDSTYLE\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t</tr>\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\' align=\"center\"><label>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </label></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" name=\"inf_volume_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"inf_volume_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" size=2 value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" disabled> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>  \n\t\t\t\t\t\t\t<!-- Add tot_strength_uom is replaced by  infusion_vol_str_unit_desc  for SKR-SCF-0215.1-->\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><label style=\"font-size:9;color:black\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</label></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\' style=\"cursor:pointer;\" id=\'orderctl";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\" onMouseOver=\"hideToolTip(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"><B><label style=\"font-size:10;color:blue;align:center;\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label></B><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\"MFR_inf_date_time_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" size=13 maxlength=16 style=\"font-size:11;\" disabled></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" name=\"MFR_flow_rate_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=2 maxlength=9 class=\"number\" style=\"font-size:11;color:blue\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" onBlur=\"calculateInfusionPeriodMFR(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="><b><label style=\"font-size:10;\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</label></b></td>\n\t\t\t\t\t\t\t<!--infusion_vol_str_unit changed to infusion_vol_str_unit_desc SKR-SCF-0215 [IN:029303]-->\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"\" name=\"MFR_inf_prd_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"MFR_inf_prd_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  size=1 maxlength=6 class=\"number\" disabled> <b><label style=\"font-size:10;\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<div id=\"sch_inf_per_MFR_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">&nbsp;</div></label></b></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" name=\"MFR_end_date_time_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"MFR_end_date_time_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=13 maxlength=16 style=\"font-size:11;\" disabled></td>\t\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\'>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t<input type=text value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"MFR_batch_id_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" size=8 maxlength=10 disabled> <input type=text value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" name=\"MFR_exp_dt_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=13 maxlength=16 disabled>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"Newly_Admin_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"Newly_Admin_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<select name=\"MFR_batch_id_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"MFR_batch_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\"font-size:11\" onChange=\"assignBatchDetails(\'MFR\',\'MFR\',this,\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">\n\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="---</option>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<option  value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"> ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_exp_dt_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"MFR_exp_dt_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_batch_id_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" size=8 maxlength=10 disabled> \n\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_exp_dt_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" size=13 maxlength=16 disabled>\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" name=\"MFR_batch_id_but_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"MFR_batch_id_but_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onClick=\"callMednBatchSearchMFR(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"IV_Y\" name=\"Newly_Admin_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'IVFLUID1\' align=\"center\"><label style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openAuditLogWindow(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\');\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</label></td>\t\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\' align=\"center\"><label> ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" </label></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" name=\"inf_volume_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\t<!-- changed tot_strength_uom to  infusion_vol_str_unit_desc for SKR-SCF-0215.1-->\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><label style=\"font-size:9;color:black\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</label></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\' id=\'orderctl";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\')\"> <B><label style=\"font-size:10;align:center;\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" size=13 maxlength=16 style=\"font-size:11;\" disabled></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" size=2 maxlength=9 class=\"number\" style=\"font-size:11;color:blue\" disabled onBlur=\"calculateInfusionPeriodMFR(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\')\" onKeyPress=\"return allowValidNumber(this,event,6,2);\"><b><label style=\"font-size:10;\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</label></b></td>\n\t\t\t\t\t\t\t\t<!--infusion_vol_str_unit changed to infusion_vol_str_unit_desc SKR-SCF-0215 [IN:029303]-->\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" value=\"\" name=\"MFR_inf_prd_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">&nbsp;</div></label></b></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'><input type=\"text\" name=\"MFR_end_date_time_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" size=13 maxlength=16 style=\"font-size:11;\" disabled></td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\'>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t<input type=text value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" size=13 maxlength=16 disabled>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"Newly_Admin_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t<select name=\"MFR_batch_id_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')\" disabled>\n\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t\t<option  value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\t\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_exp_dt_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_batch_id_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" size=8 maxlength=10 disabled> \n\t\t\t\t\t\t\t\t\t<input type=text value=\"\" name=\"MFR_exp_dt_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" size=13 maxlength=16 disabled>\n\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"?\" name=\"MFR_batch_id_but_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\')\" disabled>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"IV_Y\" name=\"Newly_Admin_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t<td class=\'IVFLUID1\' align=\"center\"><label style=\"font-size:10;color:blue;cursor:pointer;align:center;\" onClick=\"openAuditLogWindow(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</label></td>\t\n\t\t\t\t\t\t\t\t</tr>\t\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"FlowStatus";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"FlowStatus";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srl_no";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"srl_no";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"holdMinutes";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"holdMinutes";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedMinutes";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"completedMinutes";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"completedFlow";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"completedFlow";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"gaphours";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"gaphours";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"holdDateTime";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"holdDateTime";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"resumeDateTime";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id=\"resumeDateTime";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_hrs";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"inf_prd_hrs";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd_min";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"inf_prd_min";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"inf_prd";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" id=\"inf_prd";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"batch_id";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flowRateDurationUnit";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"flowRateDurationUnit";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"flowRateDurationUnitDesc";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"flowRateDurationUnitDesc";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"infusion_vol_str_unit";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"infusion_vol_str_unit";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"infusion_vol_str_unit_desc";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"> <!--Added for SKR-SCF-0215 [IN:029303]-->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_trade_id_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"iv_trade_id_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_bin_code_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"iv_bin_code_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" value=\"\" >\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tot_strength_uom";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"tot_strength_uom";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"infusionPeriodUnit";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"infusionPeriodUnit";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"> <!-- Added for SRR20056-SCF-7137.1 IN028154, PH-Incident No.# 28218 -->\n\t\t\n\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\t\tgetHrsMinStrMFR(\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\',\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\')\n\t\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"currentRowNumber\" id=\"currentRowNumber\" id=\"currentRowNumber\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"totalNoOfRows\" id=\"totalNoOfRows\" id=\"totalNoOfRows\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"current_date_time\" id=\"current_date_time\" id=\"current_date_time\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"from_time\" id=\"from_time\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"auto_admin\" id=\"auto_admin\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"first_sch_start_date_time\" id=\"first_sch_start_date_time\" id=\"first_sch_start_date_time\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar cuRoNum=document.getElementById(\"currentRowNumber\").value; \n\t\t\t\t\t\t\tif(cuRoNum>0){\n\t\t\t\t\t\t\t\tvar actDtTime=eval(\"document.MedicationAdministrationMFRDetails.MFR_inf_date_time_\"+cuRoNum).value\n\t\t\t\t\t\t\t\tcalcDatesForMFR(cuRoNum,actDtTime,document.getElementById(\"totalNoOfRows\").value);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"10\" align=\'Right\'>\n\t\t\t\t\t\t<input type=\"button\" name=\"btnOK\" id=\"btnOK\" value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' class=\"button\" onClick=\"returnMFRDetails();\">&nbsp;\n\t\t\t\t\t\t<input type=\"button\" name=\"btnCANCEL\" id=\"btnCANCEL\" value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' class=\"button\" onClick=\"closeWindow();\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</form>\n\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
  	
		String order_id		=	request.getParameter("orderId");
		String order_line_no=	request.getParameter("orderLineNumber");
		String drug_code	=	request.getParameter("drug_code");
		String store_code	=	request.getParameter("store_code");
		String from_time	=	request.getParameter("from_time");
		String Auto_Admin	=	request.getParameter("auto_admin")==null?"":request.getParameter("auto_admin");
		String called_from	=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String drug_desc	=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String disable_batch_lookup_button="";
		if(Auto_Admin.equals("N"))
			disable_batch_lookup_button="disabled";
		drug_desc=java.net.URLEncoder.encode(drug_desc,"UTF-8");
		try{
			String bean_id							= "MedicationAdministrationFTBean";
			String bean_name						= "ePH.MedicationAdministrationFTBean";
			MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
			bean.setLanguageId(locale);
			ArrayList MFRDetailsList = bean.getMFRDetails(order_id,order_line_no);
			ArrayList result						= bean.getCurrentTimeAndAdminWithinHRS();
			String current_date_time				= (String)result.get(0);
			
			
			current_date_time=com.ehis.util.DateUtils.convertDate(current_date_time,"DMYHM",locale,"en");
			ArrayList mfrAdminDtls=new ArrayList();
			if(called_from.equals("MednAdminChart"))
				mfrAdminDtls=bean.getMFRAdminChartDetails(order_id);

            _bw.write(_wl_block9Bytes, _wl_block9);

			if(mfrAdminDtls.size()>0){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mfrAdminDtls.get(0)==null?"":(String)mfrAdminDtls.get(0)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mfrAdminDtls.get(1)==null?"":(String)mfrAdminDtls.get(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
			
			}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				if(MFRDetailsList!=null && MFRDetailsList.size()>0){
					int rowcount=1;
					String flowRateDurationUnit="";
					String infusionPeriodUnit="";
					String flowRateDurationUnitDesc;
					String infusionPeriodUnitDesc;
					String status="";
					String statusString="";
					String infusionDateTime="";
					String infusionEndTime="";
					String batch_id="";
					String expiry_dt="";
					String flow_srl_no="";
					String tot_strength="";
					String tot_strength_uom="";
					String infuse_over="";
					String infusion_rate="";
					String infusion_vol_str_unit="";
					String infusion_vol_str_unit_desc=""; //added for SKR-SCF-0215 [IN:029303]
					String sch_start_date_time="";
					String first_sch_start_date_time="";
					String gap_duration_in_hrs="";
					String hold_durn_in_mins="";
					String hold_date_time="";
					String resume_date_time="";
					String infuse_over_disabled="";
					String completedFlow="0";
					String completedMinutes="0";
					ArrayList batch_ids;
					boolean currentRowFound=false;
					int currentRowNumber=0;
					HashMap MFRDetails;
					for(int i=0;i<MFRDetailsList.size();i++){
						MFRDetails=(HashMap)MFRDetailsList.get(i);
						flow_srl_no = (String)MFRDetails.get("SL_NO")==null?"1":(String)MFRDetails.get("SL_NO");
						tot_strength = (String)MFRDetails.get("TOT_STRENGTH")==null?"":(String)MFRDetails.get("TOT_STRENGTH");
						tot_strength_uom = (String)MFRDetails.get("TOT_STRENGTH_UOM")==null?"":(String)MFRDetails.get("TOT_STRENGTH_UOM");
						infuse_over = (String)MFRDetails.get("INFUSE_OVER")==null?"0":(String)MFRDetails.get("INFUSE_OVER");
						infusionPeriodUnit = (String)MFRDetails.get("INFUSE_OVER_UNIT")==null?"":(String)MFRDetails.get("INFUSE_OVER_UNIT");
						infusion_rate = (String)MFRDetails.get("INFUSION_RATE")==null?"":(String)MFRDetails.get("INFUSION_RATE");

						DecimalFormat dfTest = new DecimalFormat("0.###");
						infusion_rate = dfTest.format(Float.parseFloat(infusion_rate));

						infusion_vol_str_unit = (String)MFRDetails.get("INFUSION_VOL_STR_UNIT")==null?"":(String)MFRDetails.get("INFUSION_VOL_STR_UNIT");
						infusion_vol_str_unit_desc = (String)MFRDetails.get("INFUSION_VOL_STR_UNIT_DESC")==null?"":(String)MFRDetails.get("INFUSION_VOL_STR_UNIT_DESC"); //SKR-SCF-0215 [IN:029303]
						flowRateDurationUnit = (String)MFRDetails.get("INFUSION_PER_UNIT")==null?"":(String)MFRDetails.get("INFUSION_PER_UNIT");			
						sch_start_date_time = (String)MFRDetails.get("START_DATE_TIME")==null?"":(String)MFRDetails.get("START_DATE_TIME");				
						if(i==0)
							first_sch_start_date_time=sch_start_date_time;
						gap_duration_in_hrs = (String)MFRDetails.get("GAP_DURATION_IN_HRS")==null?"":(String)MFRDetails.get("GAP_DURATION_IN_HRS");				
						status=(String)MFRDetails.get("MAR_STATUS")==null?"":(String)MFRDetails.get("MAR_STATUS");
						infusionDateTime=(String)MFRDetails.get("ACT_START_DATE_TIME")==null?"":(String)MFRDetails.get("ACT_START_DATE_TIME");
						infusionEndTime=(String)MFRDetails.get("ACT_END_DATE_TIME")==null?current_date_time:(String)MFRDetails.get("ACT_END_DATE_TIME");
						batch_id=(String)MFRDetails.get("BATCH_ID")==null?"":(String)MFRDetails.get("BATCH_ID");
						expiry_dt=(String)MFRDetails.get("EXPIRY_DATE")==null?"":(String)MFRDetails.get("EXPIRY_DATE");
						hold_durn_in_mins=(String)MFRDetails.get("HOLD_DURN_IN_MINS")==null?"0":(String)MFRDetails.get("HOLD_DURN_IN_MINS");
						completedMinutes=(String)MFRDetails.get("COMPLETED_DURN_IN_MINS")==null?"0":(String)MFRDetails.get("COMPLETED_DURN_IN_MINS");
						completedFlow=(String)MFRDetails.get("COMPLETED_VOLUME")==null?"0":(String)MFRDetails.get("COMPLETED_VOLUME");
						hold_date_time=(String)MFRDetails.get("HOLD_DATE_TIME")==null?"":(String)MFRDetails.get("HOLD_DATE_TIME");
						resume_date_time=(String)MFRDetails.get("RESUME_DATE_TIME")==null?"":(String)MFRDetails.get("RESUME_DATE_TIME");

						flowRateDurationUnitDesc="";
						infusionPeriodUnitDesc="";
						
						if(batch_id.equals("")){
							batch_ids=bean.getAllBatchIDS(order_id,order_line_no,"N");
							if(batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and and 7 to 9 for GHL-CRF-0482
								batch_id=(String)batch_ids.get(0);
								expiry_dt=(String)batch_ids.get(1);
							}
						}
						else{
							batch_ids=new ArrayList();
						}
						//out.println("batch_ids size==>"+batch_ids.size());
						if(flowRateDurationUnit.equals("M")) 
							flowRateDurationUnitDesc="Mins";
						else if(flowRateDurationUnit.equals("H"))
							flowRateDurationUnitDesc="Hrs";
						if(infusionPeriodUnit.equals("M")) 
							infusionPeriodUnitDesc="Mins";
						else if(infusionPeriodUnit.equals("H"))
							infusionPeriodUnitDesc="Hrs";
						
						if(status.equals("NS")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NOTSTARTED.label","ph_labels");
							infuse_over_disabled="";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("ST")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.STARTED.label","ph_labels");
							infuse_over_disabled="disabled";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("HO")){
							infuse_over_disabled="disabled";
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOLD.label","ph_labels");
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("RE")){
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RESUMED.label","ph_labels");
							infuse_over_disabled="disabled";
							if(!currentRowFound){
								currentRowNumber=rowcount;
								currentRowFound=true;
							}
						}
						else if(status.equals("CO")){
							infuse_over_disabled="disabled";
							statusString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.COMPLETED.label","ph_labels");
							currentRowFound=false;					
						}
						else{
							statusString="";
							infuse_over_disabled="";
						}
						
						if(infusionDateTime.equals(""))
							infusionDateTime=current_date_time;

						if(currentRowFound && (currentRowNumber==rowcount)){ //this condition is to find the working row

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(flow_srl_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tot_strength));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(infusion_vol_str_unit_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(sch_start_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(infusionDateTime,"DMYHM","en",locale)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(infuse_over_disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(infusion_vol_str_unit_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(infusionPeriodUnitDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(infusionEndTime,"DMYHM","en",locale)));
            _bw.write(_wl_block45Bytes, _wl_block45);
						
							if(!batch_id.equals("")){

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_dt,"DMY","en",locale)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block52Bytes, _wl_block52);
					
							}
							else if(batch_ids.size()>9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block52Bytes, _wl_block52);
					
							}
							else{

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_batch_lookup_button));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
				
						}
						else{

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(flow_srl_no));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tot_strength));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(infusion_vol_str_unit_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(sch_start_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(statusString));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(infusionDateTime,"DMYHM","en",locale)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(infusion_vol_str_unit_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(infusionPeriodUnitDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(infusionEndTime,"DMYHM","en",locale)));
            _bw.write(_wl_block85Bytes, _wl_block85);

								if(!batch_id.equals("")){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(expiry_dt,"DMYHM","en",locale)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block52Bytes, _wl_block52);

								}
								else if(batch_ids.size()>9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

									for(int kk=0;kk<batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)batch_ids.get(kk)));
            _bw.write(_wl_block60Bytes, _wl_block60);

									}

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block69Bytes, _wl_block69);

								}
								else{

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block69Bytes, _wl_block69);
	
								}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
				
							}

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(status));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(flow_srl_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hold_durn_in_mins));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(completedMinutes));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(completedFlow));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(gap_duration_in_hrs));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hold_date_time));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(resume_date_time));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(flowRateDurationUnit));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(flowRateDurationUnitDesc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(infusion_vol_str_unit));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(infusion_vol_str_unit_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tot_strength_uom));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(infusionPeriodUnit));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(infusionPeriodUnit));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block141Bytes, _wl_block141);
					
							rowcount++;
						}

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(currentRowNumber));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(Auto_Admin));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(first_sch_start_date_time));
            _bw.write(_wl_block153Bytes, _wl_block153);

					}

            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

		} 
		catch(Exception e) {
			e.printStackTrace();
		}

            _bw.write(_wl_block157Bytes, _wl_block157);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDose.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SchTime.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionDate/Time.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FlowRate.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionPeriod.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionEndTime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditLog.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewDetails.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
