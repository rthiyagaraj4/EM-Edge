package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __specialitiesprepostoperativechecklistaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SpecialitiesPrePostOperativeChecklistAddModify.jsp", 1721119630000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eOT/js/Specialities.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<!--body onLoad=\"parent.commontoolbarFrame.document.forms[0].apply.disabled=false\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'-->\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'> <!--Modified Against GHL-SCF-1519-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name=\"SpecialitiesPrePostOperativeChecklist\" id=\"SpecialitiesPrePostOperativeChecklist\"  onload=\'FocusFirstElement();\'  action=\"../../servlet/eOT.SpecialitiesServlet\" method=\"post\" target=\"messageFrame\"> \n<table border=0 cellspacing=0 cellpadding=3 width=\'100%\'  align=center id=\'t\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t\t<input type=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"\" onBlur=\"if(this.value!=\'\') callSpeciality_Code(speciality_code,speciality_desc); else speciality_code.value=\'\'\"><input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForSpecialityCode\" id=\"generic_searchForSpecialityCode\" value=\"?\" onclick=\"callSpeciality_Code(speciality_code,speciality_desc);\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td width=\"20%\" class=\"label\" nowrap>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t</td>\n\t\t  <td width=\"20%\">\n\t\t\t\t<select name=\"diag_code_scheme\" id=\"diag_code_scheme\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' > ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  </option>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</select>\n\t\t</td>\n</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr>\n\t\t\t<td class=label width=\"25%\">\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t<input type=\"text\" name=\"chart_desc\" id=\"chart_desc\" value=\"\" onBlur=\"if(this.value!=\'\')callChartID(chart_id,chart_desc); else chart_id.value=\'\'\"><input type=\"hidden\" name=\"chart_id\" id=\"chart_id\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForChartID\" id=\"generic_searchForChartID\" value=\"?\" onclick=\"callChartID(chart_id,chart_desc);\">\n\t\t\t\t</td><td></td><td></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\">\n\t\t<input type=\"text\" name=\"swamb_instrument\" id=\"swamb_instrument\" value=\"\" onBlur=\"if(this.value!=\'\')callSwabAndInstrID(template_id,swamb_instrument); else template_id.value=\'\'\"><input type=\"hidden\" name=\"template_id\" id=\"template_id\" value=\"\" ><input type=\"button\" class=\"button\" name=\"generic_searchForswamb_instrument_id\" id=\"generic_searchForswamb_instrument_id\" value=\"?\" onclick=\"callSwabAndInstrID(template_id,swamb_instrument);\">\n\t</td><td></td><td></td>\n</tr>\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\">\n\t\t<input type=\"text\" name=\"med_ser_group\" id=\"med_ser_group\" value=\"\" onBlur=\"if(this.value!=\'\')callMedicalServiceGroup(service_id,med_ser_group); else service_id.value=\'\'\"><input type=\"hidden\" name=\"service_id\" id=\"service_id\" value=\"\" ><input type=\"button\" class=\"button\" name=\"generic_searchFormed_ser_group\" id=\"generic_searchFormed_ser_group\" value=\"?\" onclick=\"callMedicalServiceGroup(service_id,med_ser_group);\">\n\t</td><td></td><td></td>\n</tr>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" > \n\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForSpecialityCode\" id=\"generic_searchForSpecialityCode\" value=\"?\" onclick=\"callSpeciality_Code(speciality_code,speciality_desc);\"><img src=\'../../eCommon/images/mandatory.gif\' img id=\"img2\"></td>\n\t<td width=\"20%\" class=\"label\" nowrap>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\n\n\t\t\t  </select>\n\t  </td>\n</tr>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<tr>\n\t\t\t<td class=label width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t<input type=\"text\" name=\"chart_desc\" id=\"chart_desc\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onBlur=\"if(this.value!=\'\')callChartID(chart_id,chart_desc); else chart_id.value=\'\'\"><input type=\"hidden\" name=\"chart_id\" id=\"chart_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ><input type=\"button\" class=\"button\" name=\"generic_searchForChartID\" id=\"generic_searchForChartID\" value=\"?\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onclick=\"callChartID(chart_id,chart_desc);\">\n\t\t\t</td><td></td><td></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"swamb_instrument\" id=\"swamb_instrument\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onBlur=\"if(this.value!=\'\')callSwabAndInstrID(template_id,swamb_instrument); else template_id.value=\'\'\" ><input type=\"hidden\" name=\"template_id\" id=\"template_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ><input type=\"button\" class=\"button\" name=\"generic_searchForswamb_instrument_id\" id=\"generic_searchForswamb_instrument_id\" value=\"?\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onclick=\"callSwabAndInstrID(template_id,swamb_instrument);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"med_ser_group\" id=\"med_ser_group\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onBlur=\"if(this.value!=\'\')callMedicalServiceGroup(service_id,med_ser_group); else service_id.value=\'\'\" >\n\t<input type=\"hidden\" name=\"service_id\" id=\"service_id\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForswamb_instrument_id\" id=\"generic_searchForswamb_instrument_id\" value=\"?\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onclick=\"callMedicalServiceGroup(service_id,med_ser_group);\">\n\t</td><td></td><td></td>\n</tr>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t\t<input type=\"checkbox\" name=\"anaesthesia_required_yn\" id=\"anaesthesia_required_yn\" onClick=\'setAnaestheiaYN();\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t\t<input type=\"checkbox\" name=\"status\" id=\"status\" onClick=\'setCheckValue();\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n\t</td><td></td><td></td>\n</tr>\n<!--</table>-->\n\n<!-- <table border=0 cellspacing=0 cellpadding=3 width=\'100%\'  align=center > -->\n<tr>\n<th class=\'columnHeaderCenter\' width=\'100%\' colspan=4 >\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" \n</th>\n</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t\t<input type=\"hidden\" name=\"pre_op_checklist_code\" id=\"pre_op_checklist_code\" value=\"\">\n\t\t<input type=\"text\" name=\"pre_op_checklist_desc\" id=\"pre_op_checklist_desc\" value=\"\" size=25 maxlength=60 onblur=\"checkEmpty(this,no_of_verifications); \" ><input type=\"button\" class=\"button\" name=\"generic_searchForChecklistCode\" id=\"generic_searchForChecklistCode\" value=\"?\" onclick=\"callPreOPChecklist_Code(pre_op_checklist_code,pre_op_checklist_desc);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t<select name=\"no_of_verifications\" id=\"no_of_verifications\" onchange=\"displayAppRole(this,\'PRE\');\" disabled >\n\t\t<option value=\'\' selected>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t<option value=\'1\'>1</option>\n\t\t<option value=\'2\'>2</option>\n\t\t<option value=\'3\'>3</option>\n\t\t<option value=\'4\'>4</option>\n\t</select>\n\t<img id=\"img1\" src=\'../../eCommon/images/Blank1.gif\' >\n\t<!--<td width=\"25%\" class=\"fields\" name=\'image1\' style=\"display:none\">\n\t<img src=\'../../eCommon/images/mandatory.gif\'></td>-->\n\t</td><td></td><td></td>\n</tr>\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" 1\t</td>\n\t<td width=\"25%\" class=\"fields\" >\n\t<input type=\"text\" name=\"role_desc1\" id=\"role_desc1\" value=\"\"  size=\'20\' maxlength=\'60\' onBlur=\"if(this.value!=\'\')callRole(role_id1,role_desc1); else role_id1.value=\'\' \" disabled><input type=\"hidden\" name=\"role_id1\" id=\"role_id1\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole1\" id=\"generic_searchForRole1\" value=\"?\"  onclick=\"callRole(role_id1,role_desc1);\"disabled>\n\t<!--<img src=\'../../eCommon/images/mandatory.gif\'>-->\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" 2 </td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc2\" id=\"role_desc2\" value=\"\"   size=\'20\' maxlength=\'60\'  disabled onBlur=\"if(this.value!=\'\')callRole(role_id2,role_desc2); else role_id2.value=\'\' \"><input type=\"hidden\" name=\"role_id2\" id=\"role_id2\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole2\" id=\"generic_searchForRole2\" value=\"?\" disabled onclick=\"callRole(role_id2,role_desc2);\">\n\t<!--<img src=\'../../eCommon/images/mandatory.gif\'>-->\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\t \n\t<td class=label width=\"25%\">\n\t\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" 3\t</td>\n\t<td class=\"field\" width=\'25%\'>\n\t<input type=\"text\" name=\"role_desc3\" id=\"role_desc3\" value=\"\"   size=\'20\' maxlength=\'60\' disabled onBlur=\"if(this.value!=\'\')callRole(role_id3,role_desc3); else role_id3.value=\'\'\"><input type=\"hidden\" name=\"role_id3\" id=\"role_id3\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole3\" id=\"generic_searchForRole3\" value=\"?\" disabled onclick=\"callRole(role_id3,role_desc3);\">\n\t</td><td></td><td></td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'25%\'>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" 4\t</td>\n\t<td class=\"field\" width=\'25%\'>\n\t\t<input type=\"text\" name=\"role_desc4\" id=\"role_desc4\" value=\"\"  size=\'20\' maxlength=\'60\' onBlur=\"if(this.value!=\'\')callRole(role_id4,role_desc4); else role_id4.value=\'\' \" disabled><input type=\"hidden\" name=\"role_id4\" id=\"role_id4\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole4\" id=\"generic_searchForRole4\" value=\"?\" disabled onclick=\"callRole(role_id4,role_desc4);\">\n\t</td><td></td><td></td>\n</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" </td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"pre_op_checklist_desc\" id=\"pre_op_checklist_desc\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" size=25 maxlength=60 onBlur=\"checkEmpty(this,no_of_verifications); \" ><input type=\"hidden\" name=\"pre_op_checklist_code\" id=\"pre_op_checklist_code\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" ><input type=\"button\" class=\"button\" name=\"generic_searchForChecklistCode\" id=\"generic_searchForChecklistCode\" value=\"?\"  onclick=\"callPreOPChecklist_Code(pre_op_checklist_code,pre_op_checklist_desc);\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<select name=\"no_of_verifications\" id=\"no_of_verifications\" onchange=\"displayAppRole(this,\'PRE\');\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<option value=\'\'> ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</option>\n\t<option value=\'1\' selected>1</option>\n\t<option value=\'2\'>2</option>\n\t<option value=\'3\'>3</option>\n\t<option value=\'4\'>4</option>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t<option value=\'1\'>1</option>\n\t<option value=\'2\' selected>2</option>\n\t<option value=\'3\'>3</option>\n\t<option value=\'4\'>4</option>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t<option value=\'1\'>1</option>\n\t<option value=\'2\'>2</option>\n\t<option value=\'3\' selected>3</option>\n\t<option value=\'4\'>4</option>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option>\n\t<option value=\'1\'>1</option>\n\t<option value=\'2\'>2</option>\n\t<option value=\'3\'>3</option>\n\t<option value=\'4\' selected>4</option>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<option value=\'\' selected >\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</option>\n\t<option value=\'1\'>1</option>\n\t<option value=\'2\'>2</option>\n\t<option value=\'3\'>3</option>\n\t<option value=\'4\'>4</option>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n</select>\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t<img id=\"img1\" src=\'../../eCommon/images/Blank1.gif\' ></td><td></td><td></td>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<img id=\"img1\" src=\'../../eCommon/images/mandatory.gif\' ></td><td></td><td></td>\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n</tr>\n\n\n<tr>\n\t<td class=label width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" 1\t</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc1\" id=\"role_desc1\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"  size=\'20\' maxlength=\'60\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onBlur=\"if(this.value!=\'\')callRole(role_id1,role_desc1); else role_id1.value=\'\' \" ><input type=\"hidden\" name=\"role_id1\" id=\"role_id1\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole1\" id=\"generic_searchForRole1\" value=\"?\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" onclick=\"callRole(role_id1,role_desc1);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" 2</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc2\" id=\"role_desc2\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"   size=\'20\' maxlength=\'60\' ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" onBlur=\"if(this.value!=\'\')callRole(role_id2,role_desc2); else role_id2.value=\'\' \"><input type=\"hidden\" name=\"role_id2\" id=\"role_id2\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole2\" id=\"generic_searchForRole2\" value=\"?\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" onclick=\"callRole(role_id2,role_desc2);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" 3</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc3\" id=\"role_desc3\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" onBlur=\"if(this.value!=\'\')callRole(role_id3,role_desc3); else role_id3.value=\'\'\"><input type=\"hidden\" name=\"role_id3\" id=\"role_id3\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole3\" id=\"generic_searchForRole3\" value=\"?\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" onclick=\"callRole(role_id3,role_desc3);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" 4</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc4\" id=\"role_desc4\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  onBlur=\"if(this.value!=\'\')callRole(role_id4,role_desc4); else role_id4.value=\'\'\" ><input type=\"hidden\" name=\"role_id4\" id=\"role_id4\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" ><input type=\"button\" class=\"button\" name=\"generic_searchForRole4\" id=\"generic_searchForRole4\" value=\"?\"  ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" onclick=\"callRole(role_id4,role_desc4);\">\n\t</td><td></td><td></td>\n</tr>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n<th class=\'columnHeaderCenter\' width=\'100%\' colspan=\'4\' >\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" </th>\n\n<tr>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"post_op_checklist_desc\" id=\"post_op_checklist_desc\" value=\"\" size=25 maxlength=60 onblur=\"checkEmpty(this,no_of_verifications1); \" ><input type=\"hidden\" name=\"post_op_checklist_code\" id=\"post_op_checklist_code\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForChecklistCode\" id=\"generic_searchForChecklistCode\" value=\"?\" onclick=\"callPostOPChecklist_Code(post_op_checklist_code,post_op_checklist_desc);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" </td>\n\t<td width=\"25%\" class=\"fields\">\n\t<select name=\"no_of_verifications1\" id=\"no_of_verifications1\" onchange=\"displayAppRole(this,\'POST\');\" disabled>\n\t<option value=\'\' selected >\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t</option>\n\t<option value=\'1\'>1</option>\n\t<option value=\'2\'>2</option>\n\t<option value=\'3\'>3</option>\n\t<option value=\'4\'>4</option>\n\t</select>\n\t<img id=\"img2\" src=\'../../eCommon/images/Blank1.gif\'>\n\t</td><td></td><td></td>\n</tr>\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" 1 </td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc5\" id=\"role_desc5\" value=\"\"  size=\'20\' maxlength=\'60\' disabled onBlur=\"if(this.value!=\'\')callRole(role_id5,role_desc5); else role_id5.value=\'\' \"><input type=\"button\" class=\"button\" name=\"generic_searchForRole5\" id=\"generic_searchForRole5\" value=\"?\" disabled onclick=\"callRole(role_id5,role_desc5);\"><input type=\"hidden\" name=\"role_id5\" id=\"role_id5\" value=\"\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" 2</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc6\" id=\"role_desc6\" value=\"\" size=\'20\' maxlength=\'60\' disabled\tonBlur=\"if(this.value!=\'\')callRole(role_id6,role_desc6); else role_id6.value=\'\' \"><input type=\"hidden\" name=\"role_id6\" id=\"role_id6\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole6\" id=\"generic_searchForRole6\" value=\"?\" disabled onclick=\"callRole(role_id6,role_desc6);\">\n\t</td><td></td><td></td>\n\t\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" 3</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc7\" id=\"role_desc7\" value=\"\"   size=\'20\' maxlength=\'60\' disabled onBlur=\"if(this.value!=\'\')callRole(role_id7,role_desc7); else role_id7.value=\'\' \"><input type=\"hidden\" name=\"role_id7\" id=\"role_id7\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole7\" id=\"generic_searchForRole7\" value=\"?\" disabled onclick=\"callRole(role_id7,role_desc7);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" 4 </td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc8\" id=\"role_desc8\" value=\"\"  size=\'20\' maxlength=\'60\' disabled onBlur=\"if(this.value!=\'\')callRole(role_id8,role_desc8); else role_id8.value=\'\' \"><input type=\"hidden\" name=\"role_id8\" id=\"role_id8\" value=\"\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole8\" id=\"generic_searchForRole8\" value=\"?\" disabled onclick=\"callRole(role_id8,role_desc8);\">\n\t</td><td></td><td></td>\n</tr>\n\t\t\n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n<tr>\n\t<td class=label width=\"25%\">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" </td>\n\t<td width=\"25%\" class=\"fields\">\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t<input type=\"text\" name=\"post_op_checklist_desc\" id=\"post_op_checklist_desc\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" size=25 maxlength=60 onblur=\"checkEmpty(this,no_of_verifications1); \" ><input type=\"hidden\" name=\"post_op_checklist_code\" id=\"post_op_checklist_code\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForChecklistCode\" id=\"generic_searchForChecklistCode\" value=\"?\"  onclick=\"callPostOPChecklist_Code(post_op_checklist_code,post_op_checklist_desc);\" ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" >\n</td></td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" </td>\n\t<td width=\"25%\" class=\"fields\">\n\t\t<select name=\"no_of_verifications1\" id=\"no_of_verifications1\" onchange=\"displayAppRole(this,\'POST\');\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =">\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t<option value=\'\'> ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\t\t\t\t<option value=\'1\' selected>1</option>\n\t\t\t\t<option value=\'2\'>2</option>\n\t\t\t\t<option value=\'3\'>3</option>\n\t\t\t\t<option value=\'4\'>4</option>\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="--</option>\n\t\t\t\t<option value=\'1\'>1</option>\n\t\t\t\t<option value=\'2\' selected>2</option>\n\t\t\t\t<option value=\'3\'>3</option>\n\t\t\t\t<option value=\'4\'>4</option>\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="--</option>\n\t\t\t\t<option value=\'1\'>1</option>\n\t\t\t\t<option value=\'2\'>2</option>\n\t\t\t\t<option value=\'3\' selected>3</option>\n\t\t\t\t<option value=\'4\'>4</option>\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="--</option>\n\t\t\t\t<option value=\'1\'>1</option>\n\t\t\t\t<option value=\'2\'>2</option>\n\t\t\t\t<option value=\'3\'>3</option>\n\t\t\t\t<option value=\'4\' selected>4</option>\n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t<option value=\'\' selected>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</option>\n\t\t\t\t<option value=\'1\'>1</option>\n\t\t\t\t<option value=\'2\'>2</option>\n\t\t\t\t<option value=\'3\'>3</option>\n\t\t\t\t<option value=\'4\'>4</option>\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t<img id=\"img2\" src=\'../../eCommon/images/Blank1.gif\'>\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t<img id=\"img2\" src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t </td><td></td><td></td>\n\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" 1</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc5\" id=\"role_desc5\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="  onBlur=\"if(this.value!=\'\')callRole(role_id5,role_desc5); else role_id5.value=\'\'\"><input type=\"hidden\" name=\"role_id5\" id=\"role_id5\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole5\" id=\"generic_searchForRole5\" value=\"?\" ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" onclick=\"callRole(role_id5,role_desc5);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" 2</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc6\" id=\"role_desc6\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" onBlur=\"if(this.value!=\'\')callRole(role_id6,role_desc6); else role_id6.value=\'\' \"><input type=\"hidden\" name=\"role_id6\" id=\"role_id6\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole6\" id=\"generic_searchForRole6\" value=\"?\"  ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" onclick=\"callRole(role_id6,role_desc6);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\t\n\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" 3</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc7\" id=\"role_desc7\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" size=\'20\' maxlength=\'60\' ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="  onBlur=\"if(this.value!=\'\')callRole(role_id7,role_desc7); else role_id7.value=\'\' \"><input type=\"hidden\" name=\"role_id7\" id=\"role_id7\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole7\" id=\"generic_searchForRole7\" value=\"?\"  ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" onclick=\"callRole(role_id7,role_desc7);\">\n\t</td><td></td><td></td>\n</tr>\n\n<tr>\n\t<td class=label width=\"25%\">\n\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" 4</td>\n\t<td width=\"25%\" class=\"fields\">\n\t<input type=\"text\" name=\"role_desc8\" id=\"role_desc8\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" onBlur=\"if(this.value!=\'\')callRole(role_id8,role_desc8); else role_id8.value=\'\' \"><input type=\"hidden\" name=\"role_id8\" id=\"role_id8\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"><input type=\"button\" class=\"button\" name=\"generic_searchForRole8\" id=\"generic_searchForRole8\" value=\"?\"  ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" onclick=\"callRole(role_id8,role_desc8);\">\n\t</td><td></td><td></td>\n</tr>\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n</table>\n<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n<input type=\"hidden\" name=\'pre_op_no_of_verifications\' id=\'pre_op_no_of_verifications\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<input type=\"hidden\" name=\'post_op_no_of_verifications\' id=\'post_op_no_of_verifications\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

//out.println("<script>alert()</script>");
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement icd_stmt=null;
ResultSet rs=null;
ResultSet icd_rs=null;
String mode=request.getParameter("mode");

String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
String chk_checked="checked";
String chk_checked1="";
String chk_value1="";
String chk_value="E";
String disable_flag="";
String speciality_code_disable="";
String diag_code_scheme="";
String speciality_desc="";
String chart_id="";
String chart_desc="";
String pre_op_checklist="";
String pre_op_checklist_desc="";
String pre_op_no_of_verifications="";
String pre_op_verify1_user_role="";
String pre_op_verify1_user_role_desc="";
String pre_op_verify2_user_role="";
String pre_op_verify2_user_role_desc="";
String pre_op_verify3_user_role="";
String pre_op_verify3_user_role_desc="";
String pre_op_verify4_user_role="";
String pre_op_verify4_user_role_desc="";
String post_op_checklist="";
String post_op_checklist_desc="";
String post_op_no_of_verifications="";
String post_op_verify1_user_role="";
String post_op_verify1_user_role_desc="";
String post_op_verify2_user_role="";
String post_op_verify2_user_role_desc="";
String post_op_verify3_user_role="";
String post_op_verify3_user_role_desc="";
String post_op_verify4_user_role="";
String post_op_verify4_user_role_desc="";
String swab_instr_tmpl_id="";
String swab_instr_tmpl_desc="";
String med_ser_grp_code="";
String med_ser_grp_desc="";
String anaesthesia_review_reqd_yn="";
String status="";
String sql="";
String pre_op_verify1_disable="";
String pre_op_verify2_disable="";
String pre_op_verify3_disable="";
String pre_op_verify4_disable="";
String post_op_verify1_disable="";
String post_op_verify2_disable="";
String post_op_verify3_disable="";
String post_op_verify4_disable="";
String pre_op_no_of_verifications_disable="";
String post_op_no_of_verifications_disable="";
String ca_module_yn="";
String mr_term_code="";
String mr_term_desc="";
ca_module_yn=request.getParameter("ca_module_yn");
//ca_module_yn="N"; // For testing purpose
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		if (ca_module_yn.equals("Y")) {
			//Maheshwaran K modified the query for the incident no :38452 as on 14/03/2013
			sql="select A.SPECIALITY_CODE,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID, GET_DESC(?,'CA_CHART_LANG_VW','SHORT_DESC','CHART_ID',C.CHART_ID) SHORT_DESC, A.PRE_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) PRE_DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS,A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) PRE_ROLE_DESC1, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) PRE_ROLE_DESC2, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) PRE_ROLE_DESC3, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) PRE_ROLE_DESC4, A.POST_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) POST_DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) POST_ROLE_DESC1, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) POST_ROLE_DESC2, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) POST_ROLE_DESC3, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) POST_ROLE_DESC4, A.SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) TEMP_DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS,A.MED_SER_GRP_CODE, GET_DESC(?,'IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',A.MED_SER_GRP_CODE) MED_SERVICE,A.DIAG_CODE_SCHEME FROM OT_SPECIALITIES A,AM_SPECIALITY B,CA_CHART C,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=? AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.DISCR_MSR_ID=C.CHART_ID(+) AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) ORDER BY A.SPECIALITY_CODE";
			}else{
		//Maheshwaran K modified the query for the incident no :38452 as on 14/03/2013
			sql="select A.SPECIALITY_CODE,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) LONG_DESC, A.DISCR_MSR_ID,NULL SHORT_DESC,A.PRE_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',D.CHECKLIST_CODE) PRE_DESCRIPTION, A.PRE_OP_NO_OF_VERIFICATIONS, A.PRE_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',E.ROLE_ID) PRE_ROLE_DESC1, A.PRE_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',F.ROLE_ID) PRE_ROLE_DESC2, A.PRE_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',G.ROLE_ID) PRE_ROLE_DESC3, A.PRE_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',H.ROLE_ID) PRE_ROLE_DESC4, A.POST_OP_CHECK_LIST, GET_DESC(?,'OT_CHECKLIST_HDR_LANG_VW','DESCRIPTION','CHECKLIST_CODE',N.CHECKLIST_CODE) POST_DESCRIPTION, A.POST_OP_NO_OF_VERIFICATIONS,A.POST_OP_VERIFY1_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',I.ROLE_ID) POST_ROLE_DESC1, A.POST_OP_VERIFY2_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',J.ROLE_ID) POST_ROLE_DESC2, A.POST_OP_VERIFY3_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',K.ROLE_ID) POST_ROLE_DESC3, A.POST_OP_VERIFY4_USER_ROLE, GET_DESC(?,'OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',L.ROLE_ID) POST_ROLE_DESC4, A.SWAB_INSTR_TMPL_ID, GET_DESC(?,'OT_SWAB_INSTR_TMPL_HDR_LANG_VW','DESCRIPTION','TEMPLATE_ID',M.TEMPLATE_ID) TEMP_DESCRIPTION, nvl(A.ANAESTHESIA_REVIEW_REQD_YN,'N') ANAESTHESIA_REVIEW_REQD_YN,nvl(A.STATUS,'E') STATUS, A.MED_SER_GRP_CODE, GET_DESC(?,'IP_MEDICAL_SERVICE_GRP_LANG_VW','SHORT_DESC','MED_SER_GRP_CODE',MED_SER_GRP_CODE) MED_SERVICE,A.DIAG_CODE_SCHEME FROM OT_SPECIALITIES  A,AM_SPECIALITY B,OT_CHECKLIST_HDR D,OT_CHECKLIST_HDR N,OT_ROLES E,OT_ROLES F,OT_ROLES G,OT_ROLES H,OT_ROLES I,OT_ROLES J,OT_ROLES K,OT_ROLES L,OT_SWAB_INSTR_TMPL_HDR M where A.SPECIALITY_CODE=? AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.PRE_OP_CHECK_LIST=D.CHECKLIST_CODE(+) AND A.PRE_OP_VERIFY1_USER_ROLE=E.ROLE_ID(+) AND A.PRE_OP_VERIFY2_USER_ROLE=F.ROLE_ID(+)  AND A.PRE_OP_VERIFY3_USER_ROLE=G.ROLE_ID(+)  AND A.PRE_OP_VERIFY4_USER_ROLE=H.ROLE_ID(+)  AND A.POST_OP_CHECK_LIST=N.CHECKLIST_CODE(+) AND A.POST_OP_VERIFY1_USER_ROLE=I.ROLE_ID(+)  AND A.POST_OP_VERIFY2_USER_ROLE=J.ROLE_ID(+)  AND A.POST_OP_VERIFY3_USER_ROLE=K.ROLE_ID(+)  AND A.POST_OP_VERIFY4_USER_ROLE=L.ROLE_ID(+)  AND A.SWAB_INSTR_TMPL_ID=M.TEMPLATE_ID(+) ORDER BY A.SPECIALITY_CODE";
					}
		stmt=con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,locale);
			stmt.setString(7,locale);
			stmt.setString(8,locale);
			stmt.setString(9,locale);
			stmt.setString(10,locale);
			stmt.setString(11,locale);
			stmt.setString(12,locale);
			stmt.setString(13,locale);
		if (ca_module_yn.equals("Y")) {
			stmt.setString(14,locale);
			stmt.setString(15,speciality_code);
		}else{
			stmt.setString(14,speciality_code);
		}

		rs=stmt.executeQuery();
		while(rs.next()){
			speciality_code=checkForNull(rs.getString(1));
			speciality_desc=checkForNull(rs.getString(2));
			chart_id=checkForNull(rs.getString(3));
			chart_desc=checkForNull(rs.getString(4));
			pre_op_checklist=checkForNull(rs.getString(5));
			pre_op_checklist_desc=checkForNull(rs.getString(6));
			pre_op_no_of_verifications=checkForNull(rs.getString(7));
			pre_op_verify1_user_role=checkForNull(rs.getString(8));
			pre_op_verify1_user_role_desc=checkForNull(rs.getString(9));
			pre_op_verify2_user_role=checkForNull(rs.getString(10));
			pre_op_verify2_user_role_desc=checkForNull(rs.getString(11));
			pre_op_verify3_user_role=checkForNull(rs.getString(12));
			pre_op_verify3_user_role_desc=checkForNull(rs.getString(13));
			pre_op_verify4_user_role=checkForNull(rs.getString(14));	
			pre_op_verify4_user_role_desc=checkForNull(rs.getString(15));
			post_op_checklist=checkForNull(rs.getString(16));
			post_op_checklist_desc=checkForNull(rs.getString(17));
			post_op_no_of_verifications=checkForNull(rs.getString(18));
			post_op_verify1_user_role=checkForNull(rs.getString(19));
			post_op_verify1_user_role_desc=checkForNull(rs.getString(20));
			post_op_verify2_user_role=checkForNull(rs.getString(21));
     		post_op_verify2_user_role_desc=checkForNull(rs.getString(22));
			post_op_verify3_user_role=checkForNull(rs.getString(23));
			post_op_verify3_user_role_desc=checkForNull(rs.getString(24));
			post_op_verify4_user_role=checkForNull(rs.getString(25));
			post_op_verify4_user_role_desc=checkForNull(rs.getString(26));
			swab_instr_tmpl_id=checkForNull(rs.getString(27));
     		swab_instr_tmpl_desc=checkForNull(rs.getString(28));
	        anaesthesia_review_reqd_yn=checkForNull(rs.getString(29));
			status=checkForNull(rs.getString(30));
			med_ser_grp_code=checkForNull(rs.getString(31));
			med_ser_grp_desc=checkForNull(rs.getString(32));
			diag_code_scheme=checkForNull(rs.getString(33));
		}
		
		chk_checked1 = (anaesthesia_review_reqd_yn.equals("Y"))?"checked":"";
		chk_value1 = (anaesthesia_review_reqd_yn.equals("Y"))?"Y":"N";
		if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}

		 if(pre_op_no_of_verifications.equals("1")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="disabled";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("2")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("3")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="";
		   pre_op_verify4_disable="disabled";
		}else if(pre_op_no_of_verifications.equals("4")){
		   pre_op_verify1_disable="";
		   pre_op_verify2_disable="";
		   pre_op_verify3_disable="";
		   pre_op_verify4_disable="";
		}else{
		   pre_op_no_of_verifications_disable="disabled";
		   pre_op_verify1_disable="disabled";
		   pre_op_verify2_disable="disabled";
		   pre_op_verify3_disable="disabled";
		   pre_op_verify4_disable="disabled";
		  }  
        
		 
		 if(post_op_no_of_verifications.equals("1")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="disabled";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("2")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("3")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="";
		  post_op_verify4_disable="disabled";
		 }else if(post_op_no_of_verifications.equals("4")){
          post_op_verify1_disable="";
		  post_op_verify2_disable="";
		  post_op_verify3_disable="";
		  post_op_verify4_disable="";
		 }else{
		  post_op_no_of_verifications_disable="disabled";
          post_op_verify1_disable="disabled";
		  post_op_verify2_disable="disabled";
		  post_op_verify3_disable="disabled";
		  post_op_verify4_disable="disabled";
		 }
		speciality_code_disable="disabled";	

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
System.err.println("mode====>"+mode);

            _bw.write(_wl_block7Bytes, _wl_block7);
 if(mode.equals("insert")){ 

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block11Bytes, _wl_block11);

	try{
	//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);

		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union  SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y' AND LANGUAGE_ID = ? ";

		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mr_term_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mr_term_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}


            _bw.write(_wl_block15Bytes, _wl_block15);
 if (ca_module_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} else if(mode.equals("modify")){

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(speciality_code_disable));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block11Bytes, _wl_block11);

	try{
	//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
				/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union  SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y' AND LANGUAGE_ID = ? ";


		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			
			if(diag_code_scheme.equals(mr_term_code))
			{
				out.println("<option selected value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			else
			{
				out.println("<option value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}


            _bw.write(_wl_block26Bytes, _wl_block26);
	if (ca_module_yn.equals("Y")) { 
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chart_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(swab_instr_tmpl_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(swab_instr_tmpl_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(med_ser_grp_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(med_ser_grp_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chk_value1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chk_checked1));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 
	if (mode.equals("insert")){

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
}else if(mode.equals("modify")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pre_op_checklist_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pre_op_checklist));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pre_op_no_of_verifications_disable));
            _bw.write(_wl_block59Bytes, _wl_block59);
 if(pre_op_no_of_verifications.equals("1")){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(pre_op_no_of_verifications.equals("2")){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
 }else if(pre_op_no_of_verifications.equals("3")){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 }else if(pre_op_no_of_verifications.equals("4")){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
 }else{
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}//end of if else

            _bw.write(_wl_block67Bytes, _wl_block67);
 
if(pre_op_checklist.equals("")){
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(pre_op_verify1_user_role_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pre_op_verify1_disable));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(pre_op_verify1_user_role));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(pre_op_verify1_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(pre_op_verify2_user_role_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(pre_op_verify2_disable));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(pre_op_verify2_user_role));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(pre_op_verify2_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(pre_op_verify3_user_role_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(pre_op_verify3_disable));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pre_op_verify3_user_role));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(pre_op_verify3_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(pre_op_verify4_user_role_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(pre_op_verify4_disable));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(pre_op_verify4_user_role));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(pre_op_verify4_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
 if(mode.equals("insert")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if(mode.equals("modify")){
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

		System.err.println("630,post_op_checklist_desc========>"+post_op_checklist_desc);
		System.err.println("631,post_op_checklist========>"+post_op_checklist);
	
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(post_op_checklist_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(post_op_checklist));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(post_op_no_of_verifications_disable));
            _bw.write(_wl_block106Bytes, _wl_block106);
 if(post_op_no_of_verifications.equals("1")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
}else if(post_op_no_of_verifications.equals("2")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
}else if(post_op_no_of_verifications.equals("3")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
 }else if(post_op_no_of_verifications.equals("4")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
} else{
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
 
if(post_op_checklist.equals("")){
            _bw.write(_wl_block115Bytes, _wl_block115);
}else{
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(post_op_verify1_user_role_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(post_op_verify1_disable));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(post_op_verify1_user_role));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(post_op_verify1_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_op_verify2_user_role_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(post_op_verify2_disable));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_op_verify2_user_role));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(post_op_verify2_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(post_op_verify3_user_role_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(post_op_verify3_disable));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(post_op_verify3_user_role));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(post_op_verify3_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(post_op_verify4_user_role_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(post_op_verify4_disable ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(post_op_verify4_user_role));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(post_op_verify4_disable));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(pre_op_no_of_verifications));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(post_op_no_of_verifications));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block139Bytes, _wl_block139);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureCodingScheme.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChartID.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SwabandInstrumentCount.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalServiceGroup.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureCodingScheme.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChartID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SwabandInstrumentCount.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalServiceGroup.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaReviewRequired.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeCheckList.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Checklist.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfVerifications.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Checklist.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfVerifications.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PostOperativeCheckList.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Checklist.Label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfVerifications.Label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Checklist.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfVerifications.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }
}
