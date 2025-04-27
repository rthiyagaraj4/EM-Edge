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
import com.ehis.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ehis.util.*;

public final class __changeadmissiondetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ChangeAdmissionDetails.jsp", 1742369232085L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'</link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n\t<script src=\'../js/ReviseAdmission.js\' language=\'javascript\'></script>\n\t<script type=\"text/javascript\">\n\tfunction closew()\n\t{\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close(); \n\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[2].alert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'IP\'));\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\tparent.frames[2].alert(getMessage(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'IP\'));\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].alert(getMessage(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'IP\'));\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t<form name=\'Change_Adm_Dtls_Form\' id=\'Change_Adm_Dtls_Form\' method=\"post\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="action=\"../../servlet/eIP.ModifyServiceServlet\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="action=\"../../servlet/eIP.ChangeAdmissionDtlsServlet\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="target=\"messageFrame\" >\n\t\t\t\t<input type=\'hidden\' name=\'bedtypecode\' id=\'bedtypecode\' value = \'\'>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'  align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap class=\"label\" width=\'30%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\'querydata\'><b color=\'blue\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></td>\n\t\t\t\t\t<!--Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<td class=\'CAGROUPHEADING\' nowrap><a href=\"javascript:UploadDocument();\"><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</b></a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\'1\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<TR>\n\t\t\t<td class = \'columnheader\' width = \'25%\'>&nbsp;</td>\n\t\t\t<td class=\"columnheader\" width=\'35%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td><td class=\"columnheader\" width=\'35%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td></TR>\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\' ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" maxlength=15 size=15  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onblur=\"if(this.value==\'\'){document.forms[0].nursing_unit.value=\'\';};BeforeNursingUnitLookup(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');CheckNursingUnit();\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  ><input type=\'button\' class=\'BUTTON\' name=\"nursing_unit_lookup\" id=\"nursing_unit_lookup\" value=\'?\' onClick=\"if(document.forms[0].nursing_unit_desc.value == \'\') NursingUnitLookup(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><input type=\'hidden\' name=\"nursing_unit\" id=\"nursing_unit\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><img src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\"nurs_unit_desc_hid\" id=\"nurs_unit_desc_hid\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><input type=\"hidden\" name=\"ServiceFocus\" id=\"ServiceFocus\" value=\"N\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"NUnit_Chk\" id=\"NUnit_Chk\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t\t\t\t\t\t<!-- \t<select name=\"service\" id=\"service\" onChange=\'onServiceChange()\'onmousewheel=\'return false;\'  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="><option value=\"\" >--- ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ---</option> -->\n\t\t\t\t\t\t\t\t\t<select name=\"service\" id=\"service\" onChange=\'onServiceChange()\'onmousewheel=\'return false;\'  ><option value=\"\" >--- ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ---</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Servic_Chk\" id=\"Servic_Chk\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\n\t\t\t\t\t\t\t\t   </td>\n\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<!-- <select name=\"sub_service\" id=\"sub_service\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="  ><option value=\"\">--- ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ---</option> -->\n\t\t\t\t\t\t\t\t\t<select name=\"sub_service\" id=\"sub_service\"  ><option value=\"\">--- ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" ---</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"SubServ_Chk\" id=\"SubServ_Chk\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<select name=\'Bedcode\' id=\'Bedcode\' onChange=\'onBedClassChange(this)\' onmousewheel=\'return false;\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ><option value=\"\" selected>--- ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ---</option> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'> \n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"BedCls_Chk\" id=\"BedCls_Chk\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\n\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t</tr>\n                                <!--Below added by Suji Keerthi for MMS-DM-CRF-0191 US002-->\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t\t\t<td style=\'word-wrap: break-word;width:500px;\' class=\'querydata\' ><b>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"admission_approval_details\" id=\"admission_approval_details\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" size=10 maxlength=100 onKeyPress=\"return CheckForSpecCharsValidation1(event);\" onBlur=\'CheckSplCharsValidation(this);\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"AdmApprDtls_Chk\" id=\"AdmApprDtls_Chk\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<!--Ended by Suji Keerthi for MMS-DM-CRF-0191 US002-->\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<select name=\"bed_type\" id=\"bed_type\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="><option value=\"\">--- ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"BedTyp_Chk\" id=\"BedTyp_Chk\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\n\t\t\t\t\t\t\t\t  </td>\n\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"bed_no\" id=\"bed_no\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" readonly size=\'8\' maxlength=\'8\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" ><input type=\"button\" class=\"button\" name=\'bed_avail_chart\' id=\'bed_avail_chart\' value=\"?\" onclick=\"callModal(\'BED_AVAIL\')\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t<img id=\'bed_img\' src=\'../../eCommon/images/mandatory.gif\'> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"BedNo_Chk\" id=\"BedNo_Chk\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n\t\t\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"room_no\" id=\"room_no\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" size=10 maxlength=10 readonly onBlur=\"\" onKeyPress=\'return CheckForSpecChars(event)\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t\t<img id=\'room_img\' src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"RoomNo_Chk\" id=\"RoomNo_Chk\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t  </td>\n\n\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\' ><b color=\'blue\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\'>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type=\'text\' size=\'15\' maxLength=\'15\' name=\'SplDesc\' id=\'SplDesc\'  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" onblur=\"BeforegetSpecialty(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ><input type=\'button\' class=\'BUTTON\' name=\'specialty_search\' id=\'specialty_search\' value=\'?\' onClick=\"if(document.forms[0].SplDesc.value == \'\') getSpecialty(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\"  ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="><img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Splcode\' id=\'Splcode\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"><input type=\'hidden\' name=\'SplDesc_hid\' id=\'SplDesc_hid\' value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\t<input type=\"hidden\" name=\"Splty_Chk\" id=\"Splty_Chk\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<select name=\"visit_adm_type\" id=\"visit_adm_type\"  onChange=\"return validateFields(this)\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" ><option value=\"\">--- ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"> \n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"AdmTyp_Chk\" id=\"AdmTyp_Chk\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<select name=\"ambulatory_status\" id=\"ambulatory_status\" ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="---</option> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"AmblSts_Chk\" id=\"AmblSts_Chk\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\n\t\t\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\t\t</tr>\n<!-- \t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'exp_days_stay\' id=\'exp_days_stay\' size=\'3\' maxlength=\'3\' value=\"\" onKeyPress=\'return CheckForSpecChars(event)\'  onBlur=\'\' >\n\t\t\t\t\t\t\t\t  </td>\n\n\t\t\t\t\t\t\t\t</tr>\n -->\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\'><b>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\'  name=\'expecteddischargedate\' id=\'expecteddischargedate\' size=15 maxlength=\'16\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' onBlur=\'validateExpDate(this);\' ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'ExpdisDate\'  name=\'ExpdisDate\' onClick=\"document.forms[0].expecteddischargedate.select();return showCalendar(\'expecteddischargedate\',null,\'hh:mm\');\" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" ><input type=\"hidden\" name=\"EDD_Chk\" id=\"EDD_Chk\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\' >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"ot_date_time\" id=\"ot_date_time\" size=16 maxlength=16  onBlur=\"doOTDateTimeChk(this)\" value =\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'OTDate\'  name=\'OTDate\' onClick=\"if (\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' !== \'disabled\'){document.forms[0].ot_date_time.select();return showCalendar(\'ot_date_time\',null,\'hh:mm\');}\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" ><input type=\"hidden\" name=\"OTD_Chk\" id=\"OTD_Chk\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\" >\n\t\t\t\t\t\t\t\t\t<!--Below line  modified for this CRF AMRI-CRF-0284 [IN:049116] -->\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" size=\'15\' maxlength=\'30\'  onblur=\"if(this.value==\'\'){document.forms[0].practid.value=\'\';document.forms[0].practid_desc_hid.value=\'\'};BeforeGetPractID1(document.forms[0].pract_id_search,practid_desc);\"  ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].practid_desc.value == \'\') getPractID(this,practid_desc);\"  ><img src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" size=\'15\' maxlength=\'15\'  ><input type=\'hidden\' name=\'practid_desc_hid\' id=\'practid_desc_hid\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Admtprct_Chk\" id=\"Admtprct_Chk\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'att_practid_desc\' id=\'att_practid_desc\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" size=\'15\' maxlength=\'30\'  onblur=\"if(this.value==\'\'){document.forms[0].att_practid.value=\'\'};BeforeGetPractID2(document.forms[0].att_pract_id_search,att_practid_desc);\" ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" ><input type=\'button\' name=\'att_pract_id_search\' id=\'att_pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].att_practid_desc.value == \'\')getPractID(this,att_practid_desc);\" ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" ><img ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="style=\'visibility:visible\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="style=\'visibility:hidden\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="id=\'attend_img\' src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\'att_practid\' id=\'att_practid\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" size=\'15\' maxlength=\'15\'><input type=\'hidden\' name=\'att_practid_desc_hid\' id=\'att_practid_desc_hid\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" ><input type=\'hidden\' name=\'d_referral_id\' id=\'d_referral_id\' value=\'\'><input type=\'hidden\' name=\'d_clinic_code\' id=\'d_clinic_code\' value=\'\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Attndprct_Chk\" id=\"Attndprct_Chk\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\n\t\t\t\t\t\t\t\t </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td class=\'label\' >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\t\t\t\t\t<td  class=\'querydata\' ><b>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'  ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="  maxlength=\'20\' size=\'25\' onblur=\'searchReferral(this)\'><input type=\'button\' class=\'button\' value=\'?\'  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" name=\'ref_id_search\' onClick=\'getReferralID()\'></td>\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"refId_Chk\" id=\"refId_Chk\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="&nbsp";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'querydata\' maxlength=\'250\' style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\" width = \"35%\">\n\t\t\t\t\t\t\t\t\t\t<textarea name=\"admission_remarks\" width = \"35%\" rows=\"3\" cols = \"35\" maxlength=\'250\'   onBlur=\"makeValidString(this);\" onkeyup=\"return imposeMaxLength(this);\">";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</textarea>\n\t\t\t\t\t\t\t\t\t</td><input type=\"hidden\" name=\"admin_remarks_Chk\" id=\"admin_remarks_Chk\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\'revision_resn_desc\' id=\'revision_resn_desc\' size=\"30\" maxLength=\"200\" onblur=\"BeforeReasonLookup();\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" ><input type=button name=\'revis_resn_lookup\' id=\'revis_resn_lookup\' value=\'?\' class=button onClick=\"if(document.forms[0].revision_resn_desc.value == \'\') ReasonLookup();\" ><img src=\"../../eCommon/images/mandatory.gif\"><input type=hidden name=\'revision_resn_code\' id=\'revision_resn_code\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"><input type=hidden name=\'revision_resn_hid_desc\' id=\'revision_resn_hid_desc\' >\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\n\t\t\t</table>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'  align=\'left\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width = \'85%\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'fields\' width = \'15%\'>\n\t\t\t\t\t<input type=\'button\'  value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' name=\'chkIn_Lodger\' class=\'button\' onClick=\"apply()\"><input type=\'button\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' name=\'cancel\' class=\'button\' onclick=\'closew()\'>\n\t\t\t\t</td>                 \n\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t<!--Common Hidden Vairables Declaration-->\n\t\t\t<input type =\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t\t\t<input type =\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t\t\t<input type =\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t\t<input type=\'hidden\'  name=\'adt_status\' id=\'adt_status\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t\t<input type =\'hidden\' name=\'admission_date_time\' id=\'admission_date_time\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t\t<input type =\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t<input type =\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<input type =\'hidden\' name= \'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">  \n\t\t\t<input type =\'hidden\' name= \'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">  \n\t\t\t<input type =\'hidden\' name= \'bl_instal\' id=\'bl_instal\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">  \n\t\t\t<input type =\'hidden\' name= \'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">  \n\t\t\t<input type =\'hidden\' name= \'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"> \n\t\t\t<input type =\'hidden\' name=\'to_speciality_code\' id=\'to_speciality_code\' value=\'\'>\n\t\t\t<input type =\'hidden\' name= \'nurs_unt_auth_val\' id=\'nurs_unt_auth_val\' value=\"\">  \n\t\t\t<input type =\'hidden\' name= \'ancillary_yn\' id=\'ancillary_yn\' value=\"\">  \n\t\t\t<input type =\'hidden\' name=\"baby_flag\" id=\"baby_flag\" value=\"\">\n\t\t\t<input type =\'hidden\' name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t<input type=\'hidden\'  name=\"age\" id=\"age\" value=\"\">\n\t\t\t<input type=\'hidden\'  name  =\"checkForBilling\"  id =\"checkForBilling\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t<input type=\'hidden\'  name=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t\t\t<!--Hidden Vairables for From Values-->\n\t\t\t<input type=\'hidden\' name=\'frm_specialty_code\' id=\'frm_specialty_code\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_nursing_unit_code\' id=\'frm_nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_service_code\' id=\'frm_service_code\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_subservice_code\' id=\'frm_subservice_code\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_bed_class_code\' id=\'frm_bed_class_code\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_bed_type_code\' id=\'frm_bed_type_code\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_bed_no\' id=\'frm_bed_no\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_room_no\' id=\'frm_room_no\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_admission_type\' id=\'frm_admission_type\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_exp_discharge_date_time\' id=\'frm_exp_discharge_date_time\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_admit_practitioner_id\' id=\'frm_admit_practitioner_id\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_practitioner_id\' id=\'frm_practitioner_id\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_ot_date_time\' id=\'frm_ot_date_time\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_revision_resn_code\' id=\'frm_revision_resn_code\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frm_ambulatory_status_code\' id=\'frm_ambulatory_status_code\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n\t\t\t<input type=\'hidden\' name=\'confirm_flag\' id=\'confirm_flag\' value=\'Y\'>\n\t\t\t<input type=\'hidden\' name=\'r_bed_no\' id=\'r_bed_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'disable_Fields\' id=\'disable_Fields\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n\t\t\t<input type=\'hidden\' name=\'err_status\' id=\'err_status\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t\t<input type=\'hidden\' name=\'att_practitioner_name\' id=\'att_practitioner_name\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t\t<input type=\'hidden\' name=\'att_practitioner_id\' id=\'att_practitioner_id\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tfr_req_status\' id=\'tfr_req_status\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t<input type=\"hidden\" name=\"patient_class_value\" id=\"patient_class_value\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" >\n\t\t\t<input type=\'hidden\' name=\"valid\" id=\"valid\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t<input type=\'hidden\' name=\"from_time\" id=\"from_time\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t<input type=\'hidden\' name=\"max_param_date\" id=\"max_param_date\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t<input type=\'hidden\' name=\"valid_date\" id=\"valid_date\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t<input type=\'hidden\' name=\"referral_id_old\" id=\"referral_id_old\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<input type=\'hidden\' name=\"customer_id\" id=\"customer_id\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\n\n\n\t\t</form>\n\t</body>\n\t<script>\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' ==\'Y\' && \'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'==\'Y\') {\n\t\t\t\tdocument.getElementById(\'nursing_unit_desc\').disabled = true;\n\t\t\t\tdocument.getElementById(\'nursing_unit_lookup\').disabled = true;\n\t\t\t\tdocument.getElementById(\'Bedcode\').disabled = true;\n\t\t\t\tdocument.getElementById(\"bed_type\").disabled = true;\t \n\t\t\t} else {\n\t\t\t\t/*Friday, July 09, 2010 , condition added since if billing is not installed and admission time exceeds over parameter value or patient is transfered , system enables nursing unit,bed class and bed type.*/\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' == \'true\' && \'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' == \'true\'){\n\t\t\t\t\tdocument.getElementById(\'nursing_unit_desc\').disabled = false;\n\t\t\t\t\tdocument.getElementById(\'nursing_unit_lookup\').disabled = false;\n\t\t\t\t\tdocument.getElementById(\'Bedcode\').disabled = false;\n\t\t\t\t\tdocument.getElementById(\"bed_type\").disabled = false;\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'nursing_unit_desc\').disabled = true;\n\t\t\t\t\tdocument.getElementById(\'nursing_unit_lookup\').disabled = true;\n\t\t\t\t\tdocument.getElementById(\'Bedcode\').disabled = true;\n\t\t\t\t\tdocument.getElementById(\"bed_type\").disabled = true;\n\t\t\t\t}\n\t\t\t} \t\t\t\t\n\t</script>\n\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con							  = null;
PreparedStatement stmt	= null,bl_chrg_pt = null,bl_prcs_pt =	null,bl_adm_pt=null,trnsfr_pst=null;
ResultSet rs							  = null,bl_chrg_rs = null,bl_prcs_rs  = null,bl_adm_rs=null,trnsfr_rslt=null;
String facilityID			              =	(String)session.getValue("facility_id");
String locale							  = (String)session.getAttribute("LOCALE");
String loginUser						  = (String)session.getValue("login_user");
String install_yn						  = (String)session.getValue("bl_operational");
String customer_id						  = (String)session.getValue("CUSTOMER_ID");
String encounterID						  =	checkForNull(request.getParameter("encounter_id"));
String patientid						  =	checkForNull(request.getParameter("patient_id"));
String oper_stn_id						  = checkForNull(request.getParameter("oper_stn_id"));
String call_function					  = checkForNull(request.getParameter("call_function"));
String bl_instal						  = checkForNull(request.getParameter("bl_instal"),"N");
String deactivate_pseudo_bed_yn		      =	checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
String pat_check_in_allowed_yn			  =	checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
String bl_interfaced_yn					  =	checkForNull(request.getParameter("bl_interfaced_yn"),"N");
int cutt_off_time						  =	Integer.parseInt(request.getParameter("cutt_off_time"));
int change_adm_dtls_duration			  =	Integer.parseInt(request.getParameter("change_adm_dtls_duration"));
int max_disch_period_for_dc				  = Integer.parseInt(request.getParameter("max_disch_period_for_dc")==null?"0":request.getParameter("max_disch_period_for_dc"));
boolean adm_time_xcd 				      =	true;					
										
String admission_date_time1			      = "";
String admission_date_time			      = "";
String specialty_code					  = "";
String specialty_short_desc			      = "";
String nursing_unit_code				  = "";
String nursing_unit_short_desc		      = "";
String service_code						  = "";
String service_short_desc				  = "";
String subservice_code					  = "";
String subservice_short_desc		      = "";
String bed_class_code					  = "";
String bed_class_short_desc			      = "";
String bed_type_code					  = "";
String bed_type_short_desc			      = "";
String bed_no							  = "";
String room_no							  = "";
String exp_discharge_date_time	          = "";
String exp_discharge_date_time1	          = "";
String referral_id1						  = "";
String OT_date_time						  = "";
String OT_date_time1					  = "";
String admission_type					  = "";
String admission_short_desc				  = "";
String admit_practitioner_id			  = "";
String admit_practitioner_name		      = "";
String ambulatory_status_code		      = "";
String ambulatory_status				  = "";
String practitioner_id					  = "";
String practitioner_name				  = "";
String patient_class					  = "";
String revision_resn_code				  = "";
String revision_resn_desc				  = "";
String adt_status						  = "";
String Gender							  = "";

boolean  err_status						  =	true;
boolean  tr_err_status					  =	true;
String Enable_Fields					  =	"";
String disable_Fields					  =	"";
String Enable_Field						  =	"";
String disable_Field					  =	"";
String checkForBilling					  =	"N";
String tr_err_Code				          =	"";
String tfr_req_status				      =	"";
PreparedStatement stm					  = null;
PreparedStatement stm1					  = null;
ResultSet res							  = null;
ResultSet res1							  = null;

String max_param_date					  = "";
String valid							  = "";
String from_time						  = "";
String valid_date						  = "";
String dis_bed_room_no					  = "";
StringBuffer sqlSB						  = new StringBuffer();
int TR_Count							  = 0;
String p_service_charge_YN				  =	"";
String disableReferral					  = "" ;
String admission_remarks				  = "" ;
String admission_approval_details         = ""; //Added by Suji Keerthi for MMS-DM-CRF-0191 US002

Boolean isInvokeUploadDocAppl = false; //Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11

try{
	con = ConnectionManager.getConnection(request);

	//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
	isInvokeUploadDocAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");
		
	if(sqlSB.length() > 0) sqlSB.delete(0,sqlSB.length());
	sqlSB.append("SELECT A.adt_status, to_char(A.admission_date_time,'dd/mm/yyyy hh24:MI')admission_date_time,A.specialty_code,am_get_desc.am_speciality(A.specialty_code,'"+locale+"',2)specialty_short_desc,A.nursing_unit_code,ip_get_desc.ip_nursing_unit(A.facility_id,A.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc,A.service_code,am_get_desc.am_service (A.service_code,'"+locale+"',2) service_short_desc,A.subservice_code,am_get_desc.am_subservice (A.subservice_code,a.service_code,'"+locale+"',2)  subservice_short_desc,A.bed_class_code,ip_get_desc.ip_bed_class (A.bed_class_code,'"+locale+"',2)   bed_class_short_desc,A.bed_type_code,ip_get_desc.ip_bed_type (A.bed_type_code,'"+locale+"',2) bed_type_short_desc,nvl(A.bed_num,A.BLOCKED_BED_NO)bed_no,A.room_num,A.admission_type,ip_get_desc.ip_admission_type (A.admission_type,'"+locale+"',2) admission_short_desc,A.admit_practitioner_id,am_get_desc.am_practitioner(A.admit_practitioner_id,'"+locale+"',1) admit_practitioner_name,A.attend_practitioner_id practitioner_id,am_get_desc.am_practitioner(A.attend_practitioner_id,'"+locale+"',1) practitioner_name,A.patient_class,D.sex Gender,B.ambulatory_status ambulatory_status_code ,B.referral_id,am_get_desc.am_ambulatory_status(B.ambulatory_status,'"+locale+"',2)ambulatory_status,to_char(B.exp_discharge_date_time,'dd/mm/yyyy hh24:MI')exp_discharge_date_time,to_char(C.ot_date_time,'dd/mm/yyyy hh24:MI')ot_date_time,B.contact_reason_code revision_resn_code ,am_get_desc.am_contact_reason(B.contact_reason_code,'"+locale+"',1)revision_resn_desc,a.tfr_req_status ");
	/*Tuesday, May 18, 2010 , added for PE*/
	sqlSB.append(",TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = A.facility_id AND encounter_id = A.encounter_id ), 'dd/mm/rrrr hh24:mi') FROM_TIME,TO_CHAR(A.admission_date_time + (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE ,(CASE WHEN TRUNC (TO_DATE(A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID");
	sqlSB.append (",TO_CHAR((CASE WHEN TRUNC (  TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE (A.admission_date_time, 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE(A.admission_date_time, 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE(A.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE ");
	
	sqlSB.append(",(select count(1) from ip_adt_trn where facility_id=A.facility_id and encounter_id=A.encounter_id)tr_cnt");
	sqlSB.append(",b.admission_approval_details admission_approval_details "); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
	if(install_yn.equals("Y"))
	{
		sqlSB.append(", BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(a.facility_id , a.patient_id , 'I' , a.encounter_id) p_service_charge_YN ");
	}
	/**/
	if(customer_id.equals("AMRI"))
	{
		sqlSB.append(",b.admission_remarks admission_remarks ");
	}
	sqlSB.append (" from ip_open_encounter A, pr_encounter B, ip_adt_trn C,MP_PATIENT D  where  A.facility_id='"+facilityID+"' and A.encounter_id='"+encounterID+"' and A.encounter_id=B.encounter_id and A.facility_id=B.facility_id and   A.facility_id = C.facility_id and A.encounter_id=C.encounter_id AND A.PATIENT_ID=D.PATIENT_ID");

	stmt=con.prepareStatement(sqlSB.toString());
	rs=stmt.executeQuery();
	if(rs!=null && rs.next()){
		admission_date_time1			=	checkForNull(rs.getString("admission_date_time"));
		specialty_code					=	checkForNull(rs.getString("specialty_code"));
		specialty_short_desc			=	checkForNull(rs.getString("specialty_short_desc"));
		nursing_unit_code				=	checkForNull(rs.getString("nursing_unit_code"));
		nursing_unit_short_desc			=	checkForNull(rs.getString("nursing_unit_short_desc"));
		referral_id1					=	checkForNull(rs.getString("referral_id"));
		
		service_code					=	checkForNull(rs.getString("service_code"));
		service_short_desc				=	checkForNull(rs.getString("service_short_desc"));
		subservice_code					=	checkForNull(rs.getString("subservice_code"));
		subservice_short_desc			=	checkForNull(rs.getString("subservice_short_desc"));
		bed_class_code					=	checkForNull(rs.getString("bed_class_code"));
		bed_class_short_desc			=	checkForNull(rs.getString("bed_class_short_desc"));
		bed_type_code					=	checkForNull(rs.getString("bed_type_code"));
		bed_type_short_desc				=	checkForNull(rs.getString("bed_type_short_desc"));
		bed_no							=	checkForNull(rs.getString("bed_no"));
		room_no							=	checkForNull(rs.getString("room_num"));
		admission_type					=	checkForNull(rs.getString("admission_type"));
		admission_short_desc			=	checkForNull(rs.getString("admission_short_desc"));
		exp_discharge_date_time1		=	checkForNull(rs.getString("exp_discharge_date_time"));
		admit_practitioner_id			=	checkForNull(rs.getString("admit_practitioner_id"));
		admit_practitioner_name			=	checkForNull(rs.getString("admit_practitioner_name"));
		practitioner_id					=	checkForNull(rs.getString("practitioner_id"));
		practitioner_name				=	checkForNull(rs.getString("practitioner_name"));
		patient_class					=	checkForNull(rs.getString("patient_class"));
		ambulatory_status_code			=	checkForNull(rs.getString("ambulatory_status_code"));
		ambulatory_status				=	checkForNull(rs.getString("ambulatory_status"));
		OT_date_time1					=	checkForNull(rs.getString("ot_date_time"));
		revision_resn_code				=	checkForNull(rs.getString("revision_resn_code"));
		revision_resn_desc				=	checkForNull(rs.getString("revision_resn_desc"));
		adt_status						=	checkForNull(rs.getString("adt_status"));
		Gender							=	checkForNull(rs.getString("Gender"));
		tfr_req_status					=	checkForNull(rs.getString("tfr_req_status"));
		valid							=	checkForNull(rs.getString("VALID"));
		from_time						=	checkForNull(rs.getString("FROM_TIME"));
		max_param_date					=	checkForNull(rs.getString("MAX_PARAM_DATE"));
		valid_date						=	checkForNull(rs.getString("VALID_DATE"));
		admission_approval_details		=	checkForNull(rs.getString("admission_approval_details")); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
		TR_Count						=	rs.getInt("tr_cnt");
		if(install_yn.equals("Y"))
		{
			p_service_charge_YN			=	checkForNull(rs.getString("p_service_charge_YN"),"N");
		}
		if(customer_id.equals("AMRI"))
		{
			admission_remarks				=	checkForNull(rs.getString("admission_remarks"));
		}
	}
		//valid_date						= valid_date+ " 23:59";
		valid_date = max_param_date; //Modified for AAKH-SCF-0093
	if(patient_class.equals("DC"))
		disableReferral = "disabled";
	else 
		disableReferral = "";

/*Monday, May 17, 2010 , commented for PE , value will be passed from InpatientLookupQueryResult.jsp*/
	/*
String str="Select max_disch_period_for_dc from IP_PARAM where facility_id='"+facilityID+"' ";
//out.println(str);
stm=con.prepareStatement(str);
	res=stm.executeQuery();
	if(res!=null )
		{
			while(res.next())
			{
max_disch_period_for_dc	= res.getInt("max_disch_period_for_dc"); 
			}
		}
*/

exp_discharge_date_time = DateUtils.convertDate(exp_discharge_date_time1,"DMYHM","en",locale); 			
OT_date_time = DateUtils.convertDate(OT_date_time1,"DMYHM","en",locale); 	
admission_date_time = DateUtils.convertDate(admission_date_time1,"DMYHM","en",locale); 	

/*Tuesday, May 18, 2010 , commented for PE and moved to line no 104*/
/*
String str1= "SELECT TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ), 'dd/mm/rrrr hh24:mi') FROM_TIME,TO_CHAR(TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE,(CASE WHEN TRUNC (TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID,TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admission_date_time+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE from IP_OPEN_ENCOUNTER_VW WHERE  facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ";
stm1=con.prepareStatement(str1);
	res1=stm1.executeQuery();
			if ((res1 != null) && (res1.next()))
			{
				

				valid			= res1.getString("VALID");
				from_time		= res1.getString("FROM_TIME");
				max_param_date	= res1.getString("MAX_PARAM_DATE");
				valid_date		= res1.getString("VALID_DATE");
				
				//out.println("valid=="+valid);
				
			}

*/
/*Before Changing Details,
	Billing Validations & Transfer Count are to be checked,
	Once the seclected Patient is through with validation  Recording is Allowed */
try{
StringBuffer billing_SQL		= new StringBuffer();
String p_Unprcs_Servc_YN		=	"";
String p_adm_deposit_YN			=	"";
String bl_err_Code				=	"";

/**/
if(cutt_off_time > change_adm_dtls_duration)
{
	adm_time_xcd	 =	false;
	tr_err_status	 =	false; // 17th sep 09
	if(customer_id.equals("AMRI"))
	{
		out.println("<script>parent.frames[2].alert(getMessage('ADMIN_TIME_EXCEEDED_AMRI','IP'));</script>");
	}else{
		out.println("<script>parent.frames[2].alert(getMessage('ADMISSION_TIME_EXCEEDED','IP'));</script>");
	}
}
if(adm_time_xcd)
{
			/*Tuesday, May 18, 2010 , commented for PE moved to line no 105*/
			/*
			query_for_transfer=	"select count(*) tr_cnt from ip_adt_trn where facility_id='"+facilityID+"' and encounter_id='"+encounterID+"' ";
			stmt	=	con.prepareStatement(query_for_transfer);
			rs	=	stmt.executeQuery();
			if(rs!=null&&rs.next()){
				TR_Count	=	rs.getInt("tr_cnt");
			}*/
			 if(TR_Count>1){
					tr_err_status	 =	false;
					if(customer_id.equals("AMRI"))
					{
						tr_err_Code		 = "PATIENT_TRANSFFERED_AMRI";
					}else
					{
						tr_err_Code		 = "PATIENT_IS_TRANSFFERED";
					}
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tr_err_Code));
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
}
if(tr_err_status)
{
/*Tuesday, May 18, 2010 , commented for PE , moved to line no 109*/
/*
billing_SQL.append("Select BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(?,?,'I',?)p_service_charge_YN from dual");

if (install_yn.equals("Y")){
		bl_chrg_pt	=	con.prepareStatement(billing_SQL.toString());
		bl_chrg_pt.setString(1,facilityID);
		bl_chrg_pt.setString(2,patientid);
		bl_chrg_pt.setString(3,encounterID);
		bl_chrg_rs	=	bl_chrg_pt.executeQuery();
		if(bl_chrg_rs!=null && bl_chrg_rs.next()){
			p_service_charge_YN	=	checkForNull(bl_chrg_rs.getString("p_service_charge_YN"));
		}
*/
		if (install_yn.equals("Y")){
			if(p_service_charge_YN.equals("Y")){
				err_status			= false;
				checkForBilling		= "Y";
				if(customer_id.equals("AMRI"))
				{
					bl_err_Code			=	"SERVICE_CHARGE_EXISTS_AMRI";
				}else
				{
					bl_err_Code			=	"SERVICE_CHARGE_EXISTS"	;
				}
							
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bl_err_Code));
            _bw.write(_wl_block11Bytes, _wl_block11);

// Charged Sercvice Ends
			}else{
					if(billing_SQL.length()>0)billing_SQL.delete(0,billing_SQL.length());
					billing_SQL.append("Select  BL_IP_DETAILS.BL_CHECK_UNPROCESSED_EXISTS (?,?,'I',?) P_UNPROCESSED_SERVICE_YN  from dual");
					bl_prcs_pt	=	con.prepareStatement(billing_SQL.toString());
					bl_prcs_pt.setString(1,facilityID);      
					bl_prcs_pt.setString(	2,patientid); 
					bl_prcs_pt.setString(	3,encounterID);      
					bl_prcs_rs	=	bl_prcs_pt.executeQuery();
						if(bl_prcs_rs!=null && bl_prcs_rs.next()){
							p_Unprcs_Servc_YN	=	checkForNull(bl_prcs_rs.getString("P_UNPROCESSED_SERVICE_YN"));
						}
						if (p_Unprcs_Servc_YN.equals("Y")){
							err_status			=	false;
							checkForBilling		= "Y";
							if(customer_id.equals("AMRI"))
							{
								bl_err_Code			=	"UNPROCESSED_SERVICE_EXISTS_AMRI";
							}
							else
							{
								bl_err_Code			=	"UNPROCESSED_SERVICE_EXISTS";
							}
							
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bl_err_Code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						//UN Processed Srvice Ends
							}else{
							if(billing_SQL.length()>0)billing_SQL.delete(0,billing_SQL.length());
								billing_SQL.append("Select  bl_ip_details.BL_CHECK_ADM_DEPOSIT_EXISTS(?,?) P_ADM_DEPOSIT_YN  from dual");
								bl_adm_pt	=	con.prepareStatement(billing_SQL.toString());
								bl_adm_pt.setString(1,facilityID);      
								bl_adm_pt.setString(	2,encounterID); 
								bl_adm_rs	=	bl_adm_pt.executeQuery();
								if(bl_adm_rs!=null && bl_adm_rs.next()){
										p_adm_deposit_YN	=	checkForNull(bl_adm_rs.getString("P_ADM_DEPOSIT_YN"));
								}
								if (p_adm_deposit_YN.equals("Y")){
										err_status	 =	false;
										checkForBilling="Y";
										if(customer_id.equals("AMRI"))
											bl_err_Code	 =	"DEPOSIT_EXISTS_AMRI";
										else
											bl_err_Code	 =	"DEPOSIT_EXISTS";
										//ADM Deposit Ends
									
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bl_err_Code));
            _bw.write(_wl_block13Bytes, _wl_block13);


							}
					}
			}
	}
}
//Inner Try Ends
}catch(Exception Billex){
		Billex.printStackTrace();
	}finally{
		if(bl_chrg_pt	 != null)bl_chrg_pt.close();
		if(bl_chrg_rs  != null)bl_chrg_rs.close();
		if(bl_prcs_pt  != null)bl_prcs_pt.close();
		if(bl_prcs_rs  != null)bl_prcs_rs.close();
		if(bl_adm_pt  != null)bl_adm_pt.close();
		if(bl_adm_rs  != null)bl_adm_rs.close();
		if(rs  != null)rs.close();
		if(stmt  != null)stmt.close();
		if(trnsfr_pst  != null)trnsfr_pst.close();
		if(trnsfr_rslt  != null)trnsfr_rslt.close();
}


if(adm_time_xcd){
	if(tr_err_Code.equals("")){
		if(err_status){
			Enable_Fields="";
			disable_Fields="";
		}else{
		
		disable_Fields="disabled";
		}
	}else{
		if(tr_err_status){
			Enable_Field="";
			disable_Field="";
		}else{
		
		disable_Field="disabled";
		}
	}


	if(!bed_no.equals("") && bl_instal.equals("N") && install_yn.equals("N") && tr_err_status == true) {
		dis_bed_room_no = "";
	} else {
		dis_bed_room_no = "disabled";
	}


} else {
	disable_Field="disabled";
	dis_bed_room_no = "disabled";
} 

//out.println("<script>alert('"+disable_Fields+"')</script>");
//out.println("<script>alert('"+Enable_Field+"')</script>");


//out.println("<script>alert('"+disable_Field+"')</script>");


            _bw.write(_wl_block14Bytes, _wl_block14);
if(tr_err_Code.equals("PATIENT_IS_TRANSFFERED")){
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);

					int ins_count = eMP.MPCommonBean.getInsuranceCount(con,encounterID,patientid);

					if(isInvokeUploadDocAppl && ins_count > 0){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(service_short_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_Fields));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);


								StringBuffer sql=new StringBuffer();
								Statement stmt1=null;
								ResultSet rset=null;
								String Code="";
								String Desc="";
								String sel="";
										sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityID+"' and nursing_unit_code = '"+nursing_unit_code+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityID+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursing_unit_code+"' order by 2");
										stmt1 = con.createStatement();
										rset = stmt1.executeQuery(sql.toString());	
										if(rset!=null ){
											while (rset.next()){
												Code			=	checkForNull(rset.getString("service_code"));
												Desc	 			=	checkForNull(rset.getString("service_short_desc"));
													if (Code.equals(service_code)){
													sel = "selected";
													}else{sel = "";}
													out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(subservice_short_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disable_Fields));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 )service_short_desc, subservice_code, am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"',2 ) subservice_short_desc FROM am_facility_subsrvc WHERE operating_facility_id = '"+facilityID+"' AND service_code = '"+service_code+"' and eff_status = 'E'");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("subservice_code"));
														Desc	 			=	checkForNull(rset.getString("subservice_short_desc"));
															if (Code.equals(subservice_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(subservice_code));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityID+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursing_unit_code+"' ORDER BY short_desc ");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("bed_class_code"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
															if (Code.equals(bed_class_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(admission_approval_details));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(admission_approval_details));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(admission_approval_details));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bed_type_short_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityID+"' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.bed_class_code = '"+bed_class_code+"' AND a.eff_status='E'  ORDER BY bed_type_short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("bed_type_code"));
														Desc	 			=	checkForNull(rset.getString("bed_type_short_desc"));
															if (Code.equals(bed_type_code)){
															sel = "selected";
															}else{sel = "";}
															out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dis_bed_room_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(dis_bed_room_no));
            _bw.write(_wl_block64Bytes, _wl_block64);
if(adt_status.equals("01") && !bed_no.equals("")){
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(dis_bed_room_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
if(adt_status.equals("01") && !bed_no.equals("")){ 
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Enable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Enable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(admission_short_desc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

												if(sql.length() > 0) sql.delete(0,sql.length());
												if(!admission_type.equals("")){
												sql.append("SELECT   admission_type_code,ip_get_desc.ip_admission_type(admission_type_code,'"+locale+"',2) short_desc FROM ip_admission_type WHERE eff_status = 'E' ORDER BY short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("admission_type_code"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
														if (Code.equals(admission_type)){
														sel = "selected";
														}else{sel = "";}
														out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");

										}
									}
								}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ambulatory_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

												if(sql.length() > 0) sql.delete(0,sql.length());
												sql.append("SELECT   ambulatory_status, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',2)short_desc FROM am_ambulatory_status WHERE eff_status = 'E' ORDER BY short_desc");
												stmt1 = con.createStatement();
												rset = stmt1.executeQuery(sql.toString());	
												if(rset!=null ){
													while (rset.next()){
														Code			=	checkForNull(rset.getString("ambulatory_status"));
														Desc	 			=	checkForNull(rset.getString("short_desc"));
														if (Code.equals(ambulatory_status_code)){
														sel = "selected";
														}else{sel = "";}
														out.print("<option value=\""+Code+"\" "+sel+">"+Desc+"");
										}
									}
									if(stmt1!=null)stmt1.close();
									if(rset!=null)rset.close();
									
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(ambulatory_status_code));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(Enable_Fields));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(Enable_Fields));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(OT_date_time));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(OT_date_time));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(OT_date_time));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(admit_practitioner_name));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(admit_practitioner_name));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(admit_practitioner_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(admit_practitioner_name));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(admit_practitioner_id));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(disable_Fields));
            out.print( String.valueOf(disable_Field));
            _bw.write(_wl_block111Bytes, _wl_block111);
if(adt_status.equals("01") && !bed_no.equals("")){
            _bw.write(_wl_block112Bytes, _wl_block112);
}else{
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(referral_id1));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(referral_id1));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(disableReferral));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(disableReferral));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(referral_id1));
            _bw.write(_wl_block123Bytes, _wl_block123);
if(customer_id.equals("AMRI")){
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(admission_remarks));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(admission_remarks));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(admission_remarks));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(revision_resn_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(revision_resn_desc));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(revision_resn_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(adt_status));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bl_instal));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(Gender));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(checkForBilling));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(subservice_code));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(admit_practitioner_id));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(OT_date_time));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(revision_resn_code));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(ambulatory_status_code));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(disable_Fields));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(err_status));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(tfr_req_status));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(max_param_date));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(valid_date));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(referral_id1));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(bl_instal));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(adm_time_xcd));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(tr_err_status));
            _bw.write(_wl_block179Bytes, _wl_block179);
}catch(Exception ex){
	ex.printStackTrace();
	}finally{
	if(stmt!= null)stmt.close();
	if(rs!= null)rs.close();
	if(stm!= null)stm.close();
	if(res!= null)res.close();
	if(stm1!= null)stm1.close();
	if(res1!= null)res1.close();
	ConnectionManager.returnConnection(con,request); 
}
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadInsDoc.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CurrentAdmissionDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ChangeAdmissionDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmissionApprovalDtls.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectesDischargeDate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforChangeAdmission.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
