package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __flowsheetcontrols extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetControls.jsp", 1742387185664L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> New Document </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/common.js\"\t\t\tlanguage=\"javascript\"></script>\n<STYLE>\n\ttd.errorEvents\n\t{\n\t\tbackground-color: BROWN;\n\t\tborder-style: dashed;\n\t}\n\tFONT.DELTAFAIL{\n\t\tbackground-color:#FFE4E1;\n\t}\n\t.ColorTab\n\t{\n\t\twidth:55px;\n\t\tfont-family: Verdana;\n\t\tfont-size: 7pt;\n\t\tcolor: #000000;\n\t\tfont-weight:normal;\n\t\ttext-align:left;\n\t\tpadding-right:5px;\n\t\tvertical-align:middle;\n\t}\n</STYLE>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/FlowSheet.js\'></script>\n<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCA/js/ViewClinicalDocument.js\' language=\'javascript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="] = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>dtArr[";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<!--\t\t\t<script>alert(dtArr)</script> -->\n\n<body  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"button_form\" id=\"button_form\">\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<BODY  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'controlsForm\' id=\'controlsForm\' >\n<input type = hidden  name = idx_value\t\tvalue = ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" - 1>\n<input type = hidden  name = cur_idx_value\tvalue = \"0\">\n<input type = hidden  name = called_from\tvalue =";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n<input type = hidden  name = enc_called_from\tvalue =";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n<input type = hidden  name = strFromDate\tvalue =";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n<input type = hidden  name = strToDate\t\tvalue =";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n<input type = hidden  name = strPatientId\tvalue =";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n<input type = hidden  name = strHistRecType value =";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n<input type = hidden  name = strEventClass\tvalue =";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n<input type = hidden  name = strEventGroup\tvalue =";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n<input type = hidden  name = strEventCode\tvalue =";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n<input type = hidden  name = strFacilityId\tvalue =";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n<input type = hidden  name = strEncounterId value =";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n<input type = hidden  name = enc_id value =";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n<input type = hidden  name = strEpisodeType\tvalue =";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n<input type = hidden  name = strNormalcyInd\tvalue =";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n<input type = hidden  name = strAbnormal\tvalue =";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n<input type = hidden  name = strFlowSheetId value =";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n<input type = hidden  name = strViewConfRes\tvalue =";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n<input type = hidden  name = strGraphOrder\tvalue =";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\n<input type = hidden  name = strErrorEvent\tvalue =";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\n<input type = hidden  name = patient_id    \tvalue =";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >\n<input type = hidden  name = fac_id value =";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ><!-- IN033489-->\n<input type = hidden  name = enctr_id value =";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ><!-- IN033489-->\n<input type = hidden  name = l_conf_pin_req_yn value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="> <!-- ML-MMOH-CRF-0335 - IN057113 -->\n<input type = hidden  name = speciality_code\tvalue =";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" > <!-- IN064106 -->\n<input type = hidden  name = attend_pract_code\tvalue =";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" > <!-- IN064106 -->\n<input type=hidden name=p_review_rad_yn id=p_review_rad_yn value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="><!-- IN071561-->\n<input type=hidden name=order_type_3T id=order_type_3T value=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="> <!-- 39052 -->\n\n<table border=0 cellpadding=0 cellspacing=3 width=\"100%\">\n<tr>\n<td>\n\t<table border=1 cellpadding=0 cellspacing=0 width=\"100%\">\n\t<tr>\n\t\t<td width=\'25%\' align=\'right\'>\n\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' class=\'BUTTON\' onClick=\'openGraph1()\' title=\'Click here to view the graph\'>&nbsp;\n\t\t</td>\n\t\n\t\t<td align=\'right\'>\n\t\t\t<TABLE width=\'100%\' border=0 cellpadding=0 cellspacing=0>\n\t\t\t<!--IN066453 diable condition added for print,comments,manage button-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t<td width=\'2%\'><INPUT TYPE=\"button\" name=\"manage\" id=\"manage\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="disabled";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' class=\'BUTTON\' onClick=\'manageText()\' title=\'Click to manage the events\'></td>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<TD align=\'right\' width=\"5%\"><input type=\"button\"  name=\"birth\" id=\"birth\"  class=\"button\" value=\"Birth Register\" onClick=\"modalForBirth(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\">&nbsp;</td>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<td width=\'2%\'><INPUT TYPE=\"button\" name=\"comments\" id=\"comments\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" width=\'3%\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" class=\'BUTTON\' onClick=\"if(parent.dataFrame.document.getElementById(\'length\')>5)parent.dataFrame.enterQuickText()\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" title=\'Click to enter comments\'></td>\n\t\t\t\t\t<td width=\'1%\'><input type=\"button\"  name=\"print\" id=\"print\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" class=\"button\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' onClick=\"valsForPrint()\" title=\'Click to print the events\'></td>\n\t\t\t\t\t<td width=\'2%\'><INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' class=\'BUTTON\' onClick=\'emailText()\' title=\'Click to email the events\' ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="></td>\n\n\t\t\t\t\t<!-- Added BY Arvind For CRF 043   -->\n\t\t\t\t<td width=\'2%\'>\n\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' class=\'BUTTON\' title=\'Click to view\' name=\'emailBtn\' onclick=\'loadViewPage()\'>\n\t\t\t\t</td>\n\t\t\t\t<!-- End Here -->\n\n\t\t\t\t\t<td align=right>\n\t\t\t\t\t<!-- <table border=0 cellpadding=0 cellspacing=0 width=\"100%\" align=\'right\' id=\'tablePrevNext\' style=\'display:inline\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td  width=\'85%\'>&nbsp;</td>\n\t\t\t\t\t<td align=\'right\' width=\'5%\' ><input type=\'button\' id=\'prev\' name=\'prev\' id=\'prev\' value=\'<\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" class=\'button\' onclick=\'loadPrevNext(this)\' align=\'right\'></td>\n\t\t\t\t\t<td  align =\'center\' class = \'QRYEVEN\'>\n\t\t\t\t\t<input type =\'label\' class=\"LABEL\" name = \'label_cap\'> \n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'next\' name=\'next\' id=\'next\' value=\'>\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" class=\'button\' onclick=\'loadPrevNext(this)\' ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table> -->\n\t\t\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\"80%\" id=\'tablePrevNext\' style=\'border-color:#CFCFCD;display:inline\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridSPreviousNOR16.gif\' id=\'first\' onclick=\'loadPrevNext(this)\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" /><img src=\'../../eCommon/images/iGridPreviousNOR16.gif\' id=\'prev\' onclick=\'loadPrevNext(this)\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" /></td>\n\t\t\t\t\t<td id=\'label_cap\' class=\'Pagination\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridNextNOR16.gif\' id=\'next\' onclick=\'loadPrevNext(this)\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" /><img src=\'../../eCommon/images/iGridSNextNOR16.gif\' id=\'last\' onclick=\'loadPrevNext(this)\' ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" /></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t\t\n\t</tr>\n\t</table>\n</td>\n</tr>\n<tr>\n<td nowrap>\n<TABLE width=\'100%\' border=0 cellpadding=0 cellspacing=0>\n\t<tr>\n\t<!--<td width=\'26%\'>&nbsp;</td>-->\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t <td nowrap onMouseOut=\'clearLayer()\' onMouseOver=\"showToolTip(this, \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\', \'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\')\">\n        <span style=\'background:url(../../eCA/images/";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="); width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</span>&nbsp;\n    </td>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<td nowrap onMouseOut=\'clearLayer()\' onMouseOver=\"showToolTip(this, \'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\">\n        <span style=\'background-color:";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="; width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</span>\n    </td>\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t <td nowrap>\n        <span style=\'background:url(\"../../eCA/images/NI_Normal.gif\"); width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t <td nowrap>\n        <span style=\'background-color:#32CD32; width:16px; height:16px; display:inline-block;\'>&nbsp;&nbsp;</span>&nbsp;\n        <span style=\"font-size:12px;\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<!--<td colspan=\'2\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td  class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t<td width=\'2%\'><INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' class=\'BUTTON\' onClick=\'manageText()\' title=\'Click to manage the events\'></td>\t\t\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t<td width=\'2%\'><INPUT TYPE=\"button\" width=\'3%\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" title=\'Click to enter comments\'></td>\n\t\t<td width=\'1%\'><input type=\"button\"  name=\"print\" id=\"print\"  class=\"button\" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' onClick=\"valsForPrint()\" title=\'Click to print the events\'></td>\n\t\t<td width=\'2%\'><INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="></td> -->\n\t\t\n\t\t\n\t</TR>\n</TABLE>\n</td>\n</tr>\n</table>\n<script> \n\nfunction defaultPage() {\n    var idx_value = document.forms[0].idx_value.value;\n\n    var called_from = parent.controlsFrame.document.forms[0].called_from.value;\n    var graphorder = parent.controlsFrame.document.forms[0].strGraphOrder.value;\n    \n    var cur_idx_value = document.forms[0].cur_idx_value.value;\n\n    var fromDateTime = \"\";\n    var toDateTime = \"\";\n    var displend = \"\";\n    var displstart = 1;\n\n    if (idx_value > 0) {\n        fromDateTime = dtArr[0];\n        toDateTime = dtArr[0];\n\n        if (idx_value >= 1) {\n            if (graphorder == \"asc\")\n                toDateTime = dtArr[1];\n            else \n                fromDateTime = dtArr[1];\n\n            displend = eval(idx_value);\n        } else {\n            displend = 1;\n        }\n\n        parent.controlsFrame.document.forms[0].cur_idx_value.value = 0;\n        parent.controlsFrame.document.getElementById(\"label_cap\").innerText = \"Page \" + displstart + \" of \" + displend;\n\n\t\tif(idx_value == 1)\n\t\t{\n\t\t\tparent.controlsFrame.document.forms[0].next.disabled = true;\n\t\t\tparent.controlsFrame.document.forms[0].prev.disabled = true;\n\t\t\tparent.controlsFrame.document.forms[0].first.disabled = true;\n\t\t\tparent.controlsFrame.document.forms[0].last.disabled = true;\n\t\t}\n\n        if (called_from != \'OR\') {\n            populateControl(fromDateTime, toDateTime);\n        } else {\n            populateControlOR(fromDateTime, toDateTime);\n        }\n    }\n}\n\nfunction disableButtons() {\n    var controlsFrame = parent.controlsFrame.document.forms[0];\n    \n    // Disable buttons\n    controlsFrame.next.disabled = true;\n    controlsFrame.prev.disabled = true;\n    controlsFrame.first.disabled = true;\n    controlsFrame.last.disabled = true;\n\n    // Remove onclick handlers to ensure they cannot trigger the function anymore\n    controlsFrame.next.onclick = function(event) { event.preventDefault(); return false; };\n    controlsFrame.prev.onclick = function(event) { event.preventDefault(); return false; };\n    controlsFrame.first.onclick = function(event) { event.preventDefault(); return false; };\n    controlsFrame.last.onclick = function(event) { event.preventDefault(); return false; };\n}\n\ndefaultPage();\n</script>\n<div id=\'descLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\' ></div>\n</form>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name				Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           											created
13/12/2012		IN035950		Nijitha													CHL Hospital suggested that 
																						the presentation of the Clinician desktop be changed and more appealing. 
																						Keeping the display of information more clear and visible.
27/12/2013		IN046075		Ramesh G												Bru-HIMS-CRF-391/20
10/06/2015		IN057797		Vijayakumar K											GHL-SCF-976 [IN:057797]
18/11/2015		IN057113		Karthi L									 			ML-MMOH-CRF-0335 - IN057113
12/10/2016		IN047572		Karthi L												[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
07/03/2017		IN063542		Raja S				10/03/2017		Ramesh G			GHL-CRF-0460
02/05/2017		IN064106		Raja S				03/05/2017		Ramesh G			AAKH-SCF-0323
19/01/2018		IN066218  		PRATHYUSHA P		28/1/2018		Ramesh G			ML-MMOH-CRF-0985.1
02/01/2019 		 IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020		39052			Ramesh											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/

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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String login_user = (String)session.getValue("login_user");//IN071561

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtDt = null;

		ResultSet rsDt = null;
		ResultSet rs = null;

		//out.println("<script>alert('"+request.getQueryString()+"');</script>");
	

	//String strQueryString = request.getQueryString();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String delta_fail_str = "";
	String disabled ="";
	String disablePrev = "disabled";
	String disableNext = "disabled";
	String birth="";
	String called_from ="";
	String enc_called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEncId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String legend_type = "";
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();

	StringBuffer sbQryCriteria = new StringBuffer();
	StringBuffer	strBuffDates	= new StringBuffer();

	String emailDisp = "style='display'";
	String defPrevStatus = "";
	String defPrevStatusForPrint = "";
	String printDisp = "style='display'";
	String enctr_id = "";//IN031989
	String fac_id="";//IN033489
	String resp_id = (String)session.getValue("responsibility_id"); //IN057797
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	int nKey = 0;
	int nIndex =1;

  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
  strNormalcyInd	= request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");

  if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
  else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");	strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
  enc_called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");
  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
  //IN035950 Starts
  String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");
String p_hist_type		= request.getParameter("p_hist_type")==null?"":request.getParameter("p_hist_type");
String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T"); //Added for IN066218
String isSiteSpecificForLabPrint	= request.getParameter("isSiteSpecificForLabPrint")==null?"":request.getParameter("isSiteSpecificForLabPrint");//IN066453
String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");

String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052

boolean restrict_rd	=false;	//IN071561
if("CA_RESULTS_WIDGET".equals(called_from_widget))
strHistRecType=p_hist_type;
//IN035950 Ends
  strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");

  if(strEncId.equals("")) strEncId = "0";

  strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
  strToDate			= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");
    
//	if(called_from.equals("OR"))
//		disabled = "disabled";

	try
	{
		con = ConnectionManager.getConnection(request);
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
  sbQryCriteria.append(" a.patient_id = ? ");

	if(!strHistRecType.equals(""))
		sbQryCriteria.append(" and a.hist_rec_type = ? ");

	if(!strEventClass.equals(""))
		sbQryCriteria.append(" and a.event_class = ? ");

	if(!strEventGroup.equals(""))
		sbQryCriteria.append(" and a.event_group = ? ");

	if(!strEventCode.equals(""))
		sbQryCriteria.append(" and a.event_code = ? ");

	if(!strFromDate.equals(""))
		sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

	if(!strToDate.equals(""))
		sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')"); 

	if(!strFacilityId.equals(""))
		sbQryCriteria.append(" and a.facility_id = ? ");
	//IN071561 STARTS
	 if(restrict_rd)
		   sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
	//IN071561 ENDS
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End
	if(!strEncounterId.equals("")&&!strEncounterId.equals("0"))
		sbQryCriteria.append(" and a.encounter_id = ? ");

	if (!strEpisodeType.equals("") )
		sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

	if(strAbnormal.equals("Y"))
	{
		//Modified the following condition by Archana  on 9/16/2010 related to the incident IN023804.
		sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	}

	if(strViewConfRes.equals("X"))
		//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");
		//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z' ");//VICHAYUT DEMO Issue
		sbQryCriteria.append("and nvl(a.PROTECTION_IND,'N')!='Z' ");//VICHAYUT DEMO Issue

   if(strErrorEvent.equals("Y"))//dont'include error events
		sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
   else 
	   sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 

	//strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");//Menaka
	strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date, a.encounter_ID, a.FACILITY_ID 	From 	cr_encounter_detail a, PR_ENCOUNTER g  ");//Menaka -- // added PR_ENCOUNTER g for  MMS-QH-CRF-0177 [IN047572] 
	strBuffDates.append("where  "+sbQryCriteria.toString());
	//IN046075 Start.
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	//String resp_id = (String)session.getValue("responsibility_id"); 
    strBuffDates.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.EVENT_CODE_TYPE,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); 
	//IN046075 End.
	strBuffDates.append(" and g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID "); // MMS-QH-CRF-0177 [IN047572]
	if(!strFlowSheetId.equals("")){
		//strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ; // Commented for IN063542
		strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND (f.event_code = a.event_code OR f.event_code = a.EVENT_GROUP)) ") ; // Added for IN063542
	}			
	if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
		if(!speciality_code.equals("")){
			strBuffDates.append(" and g.SPECIALTY_CODE = ? ");
		}
	} else {
		strBuffDates.append(" and g.ATTEND_PRACTITIONER_ID = ? ");
	} // MMS-QH-CRF-0177 [IN047572] - End
	//IN066218 starts
	if("Y".equals(calling_from_2T))
		strBuffDates.append(" and a.Added_BY_ID ='DM'");
	//IN066218 Ends
	strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//IN057797 starts
		//pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'PRINT_CLIN_DATA' ");
		pstmt = con.prepareStatement("select GET_TASK_APPLICABILITY('PRINT_CLIN_DATA',NULL,?,NULL) DFLT_PRIVILEGE_STATUS from dual");
		pstmt.setString(1,resp_id);
		//IN057797 ends
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(called_from.equals("OR"))
		{
			pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				legend_type = rs.getString("LEGEND_TYPE") == null ? "S" : rs.getString("LEGEND_TYPE");
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";

		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";

		pstmtDt = con.prepareStatement(strBuffDates.toString());
		
		pstmtDt.setString(nIndex++,strPatientId);
		
		if(!strHistRecType.equals(""))
		{
			pstmtDt.setString(nIndex++,strHistRecType);
			
		}

		if(!strEventClass.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventClass);
			
		}
		if(!strEventGroup.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventGroup);
			
		}

		if(!strEventCode.equals(""))
		{
			pstmtDt.setString(nIndex++,strEventCode);
			
		}	

		//if(!strGraphOrder.equals("desc"))
		{
			if(!strFromDate.equals(""))
			{
				pstmtDt.setString(nIndex++,strFromDate);
				
			}	

			if(!strToDate.equals(""))
			{
				pstmtDt.setString(nIndex++,strToDate);
				
			}
		}
		//else
		/*{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);
		}
		*/

		if(!strFacilityId.equals(""))
		{
			pstmtDt.setString(nIndex++,strFacilityId);
			
		}	

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			pstmtDt.setString(nIndex++,eventClasswidget);
		}
		//IN035950 Ends
		if(!strEncounterId.equals("")&&!strEncounterId.equals("0"))
		{
			pstmtDt.setString(nIndex++,strEncounterId);
			
		}	
	
		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
			{
				pstmtDt.setString(nIndex++,"IP");
				
			}	
			else if(strEpisodeType.equals("O"))
			{
				pstmtDt.setString(nIndex++,"OP");
				
			}	
			else if(strEpisodeType.equals("D"))
			{
				pstmtDt.setString(nIndex++,"DC");
				
			}	
			else if(strEpisodeType.equals("E"))
			{
				pstmtDt.setString(nIndex++,"EM");
				
			}	
			else if(strEpisodeType.equals("X"))
			{
				pstmtDt.setString(nIndex++,"XT");
				
			}	
		}
		
		if(!strFlowSheetId.equals(""))
		{
			pstmtDt.setString(nIndex++,strFlowSheetId);
			
		}	
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				pstmtDt.setString(nIndex++, speciality_code);
			}
		} else {
			pstmtDt.setString(nIndex++, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		int nCtr = 0;

		try
		{
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);
				enctr_id = rsDt.getString("encounter_ID") == null ? "" : rsDt.getString("encounter_ID");//Menaka
				fac_id = rsDt.getString("FACILITY_ID") == null ? "" : rsDt.getString("FACILITY_ID");//Menaka
				if (nCtr == 0 || nCtr == 10)
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block10Bytes, _wl_block10);

					nKey++;
					nCtr =0;

				}
				
				nCtr++;
			}

			if(nCtr >= 1)
			{
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
				if(called_from.equals("OR"))
					out.println("parent.window.close();</script>");
				else
					out.println("clearForm('FS');</script>");
			}


		}
		catch (Exception ee1)
		{
			out.println("Dates -"+strBuffDates.toString()+"-");
			//out.println("exception at try 2 of FlowSheetControls.jsp -"+ee1.toString());//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		pstmt = con.prepareStatement("SELECT high_str_desc,high_color_code,HIGH_SYMBOL_ICON,low_str_desc,low_color_code,LOW_SYMBOL_ICON,abn_str_desc,abn_color_code,ABN_SYMBOL_ICON,crit_str_desc,crit_color_code,CRIT_SYMBOL_ICON,crit_high_str_desc,crit_high_color_code,CRIT_HIGH_SYMBOL_ICON,crit_low_str_desc,crit_low_color_code,CRIT_LOW_SYMBOL_ICON,DELTA_FAIL_STR,nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,strPatientId);

		rs = pstmt.executeQuery();
		
		if(rs.next())			
		{
			high_value_desc = rs.getString("high_str_desc") == null ? "" : rs.getString("high_str_desc");
			
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				high_value_color = rs.getString("HIGH_SYMBOL_ICON") == null ? "" : rs.getString("HIGH_SYMBOL_ICON");
			else
				high_value_color = rs.getString("high_color_code") == null ? "" : rs.getString("high_color_code");
		   
			mapDescColor.put(high_value_desc,high_value_color);
		    listDesc.add(high_value_desc);

		    low_value_desc = rs.getString("low_str_desc") == null ? "" : rs.getString("low_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				low_value_color = rs.getString("LOW_SYMBOL_ICON") == null ? "" : rs.getString("LOW_SYMBOL_ICON");
			else
				low_value_color = rs.getString("low_color_code") == null ? "" : rs.getString("low_color_code");
			if(!(mapDescColor.containsKey(low_value_desc)))
			{
				mapDescColor.put(low_value_desc,low_value_color);
				listDesc.add(low_value_desc);
			}

		    abnml_value_desc = rs.getString("abn_str_desc") == null ? "" : rs.getString("abn_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				abnml_value_color = rs.getString("ABN_SYMBOL_ICON") == null ? "" : rs.getString("ABN_SYMBOL_ICON");
			else
				abnml_value_color = rs.getString("abn_color_code") == null ? "" : rs.getString("abn_color_code");
			if(!(mapDescColor.containsKey(abnml_value_desc)))
			{
				mapDescColor.put(abnml_value_desc,abnml_value_color);
				listDesc.add(abnml_value_desc);
			}

		    crtcl_value_desc = rs.getString("crit_str_desc") == null ? "" : rs.getString("crit_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_value_color = rs.getString("CRIT_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_SYMBOL_ICON");
			else
				crtcl_value_color = rs.getString("crit_color_code") == null ? "" : rs.getString("crit_color_code");
			if(!(mapDescColor.containsKey(crtcl_value_desc)))
			{
				mapDescColor.put(crtcl_value_desc,crtcl_value_color);
				listDesc.add(crtcl_value_desc);
			}

		    crtcl_high_value_desc = rs.getString("crit_high_str_desc") == null ? "" : rs.getString("crit_high_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_high_value_color = rs.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_HIGH_SYMBOL_ICON");
			else
				crtcl_high_value_color = rs.getString("crit_high_color_code") == null ? "" : rs.getString("crit_high_color_code");
			if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
			{
				mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
				listDesc.add(crtcl_high_value_desc);
			}

		    crtcl_low_value_desc = rs.getString("crit_low_str_desc") == null ? "" : rs.getString("crit_low_str_desc");
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				crtcl_low_value_color = rs.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_LOW_SYMBOL_ICON");
			else
				crtcl_low_value_color = rs.getString("crit_low_color_code") == null ? "" : rs.getString("crit_low_color_code");
			if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
			{
				mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
				listDesc.add(crtcl_low_value_desc);
			}
			delta_fail_str  = rs.getString("DELTA_FAIL_STR") == null ? "" : rs.getString("DELTA_FAIL_STR");

			birth = rs.getString("birth");		
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");
		}
		
		else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}	

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(enc_called_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(enctr_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( conf_pin_req_yn ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(attend_pract_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_review_rad_yn ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_type_3T ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
if(birth.equals("Y")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(printDisp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(emailDisp));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block64Bytes, _wl_block64);

			String listValues = "";
			String listValuesdisp = "";
			String mapValues = "";
	//		int tdWidth = 100/listDesc.size();
		
            _bw.write(_wl_block65Bytes, _wl_block65);


			for(int i=0;i<listDesc.size();i++)
			{
				listValues = (String) listDesc.get(i);
				if(listValues.length()>15)
					listValuesdisp=listValues.substring(0,16);
				else
					listValuesdisp=listValues;
				mapValues = (String) mapDescColor.get(listValues);
				if(strNormalcyInd.equals("I") || legend_type.equals("S"))
				{
		
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( listValues ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( mapValues ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( listValuesdisp ));
            _bw.write(_wl_block70Bytes, _wl_block70);

				}
				else{
					//out.println("<td nowrap><font style='background-color:"+mapValues+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+listValues+"</font>&nbsp;</td>");
					
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( listValues ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( mapValues ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( listValuesdisp ));
            _bw.write(_wl_block74Bytes, _wl_block74);
}}
			if(strNormalcyInd.equals("I") || legend_type.equals("S"))
			{
		
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

			}
			else
			{
		
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

			}
			
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
if(birth.equals("Y")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(printDisp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(emailDisp));
            _bw.write(_wl_block83Bytes, _wl_block83);

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	
	}
	catch(Exception e)
	{
		//out.println(e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}



            _bw.write(_wl_block84Bytes, _wl_block84);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickOnValueCell.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Manage.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Email.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.View.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickOnValueCell.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Manage.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Email.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
