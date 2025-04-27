package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getnewbornregnvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/getNewBornRegnValues.jsp", 1739192620895L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n<html>\n<head>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n     <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t  <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown=\'lockKey();\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n                                        <script>\n                                                var temp =\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n                                                var opt=parent.frames[1].frames[2].document.createElement(\"OPTION\");\n                                                opt.text=temp;\n                                                opt.value=temp;\n                                                if(temp==\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\n                                                    opt.selected = true;\n                                                var comp=parent.frames[1].frames[2].document.forms[0].name_suffix;\n                                                comp.add(opt);\n                                        </script>\n                            ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\tvar opt=parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.add(opt);\n\n\t\t\t\t\t\tvar errors = \'\' ;\n\t\t\t\t\t\t\n\n\t\t\t\t\t</script>\n\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<script>\n\tvar fatherDtlsIndex\t= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\tif(parent.frames[1].frames[2].document.forms[0].name_prefix) {\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].first_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].second_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].disabled = true;\n\t} \t\n\t\n\tif(parent.frames[1].frames[2].document.forms[0].third_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].disabled = true;\n\t} \t\n\n\tif(parent.frames[1].frames[2].document.forms[0].family_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].name_suffix) {\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].disabled = true;\n\t}\n\t\t\t\t\n\tif(parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].first_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].second_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].third_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].family_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].disabled = true;\n\t}\n\n</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n                        <script>\n\t\t\t\t\t\talert(getMessage(\'GENDER_MISMATCH\',\'MP\'));\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_patient_id.value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_patient_name.value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_patient_id.focus();\n\t\t\t\t\t \t\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].National_id){\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.value=\'\';\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){\t                                  parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;\t\t\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\t                                  parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;\t\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;\t\n\t\t\t\t\t\t//parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;\t\n\t\t\t\t\t\t//parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value=\'\';\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.value=\'\';\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.value=\'\';\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == \'visible\')\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].natImg.style.visibility = \'hidden\';\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == \'visible\')\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].racImg.style.visibility = \'hidden\';\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'FATHER_PATID_INVALID\',\'MP\')); parent.frames[1].frames[2].document.forms[0].father_patient_id.value=\'\';\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_patient_id.focus();\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_patient_name.value=\'\';\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)\tparent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value=\'\';\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)\tparent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value=\'\';\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no)\tparent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value=\'\';\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)\tparent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value=\'\';\n\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].National_id){\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.value=\'\';\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.disabled=false;}\t\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;\t\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\n\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.value=\'\';\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;\t\n\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.value=\'\';\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.value=\'\';\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;\t\n\n\t\t\t\t/*\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;\t\t\t\t\t\t\n\t\t\t\t*/\n\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value=\'\';\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;\t\n\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.value=\'\';\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.value=\'\';\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;\n\n\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == \'visible\')\n\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].natImg.style.visibility = \'hidden\';\n\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == \'visible\')\n\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].racImg.style.visibility = \'hidden\';\n\t\t\t\t\n\t\t\t\t\n\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<script>\n\tvar fatherDtlsIndex\t= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\n\tif(parent.frames[1].frames[2].document.forms[0].name_prefix) {\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].first_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].second_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].disabled = false;\n\t} \t\n\t\n\tif(parent.frames[1].frames[2].document.forms[0].third_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].disabled = false;\n\t} \t\n\n\tif(parent.frames[1].frames[2].document.forms[0].family_name) {\n\t\tparent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].name_suffix) {\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].disabled = false;\n\t}\n\t\t\t\t\n\tif(parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].first_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].second_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].third_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].family_name_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\tif(parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang) {\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].value=\"\";\n\t\tparent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].disabled = false;\n\t}\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].National_id){\tparent.frames[1].frames[2].document.forms[0].National_id.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.disabled=false;\t}\t\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;\t\n\n\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;\n\t\t\t\t\t\t\t*/\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.value=\'\';\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;\n\n\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == \'visible\')\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].natImg.style.visibility = \'hidden\';\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == \'visible\')\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].racImg.style.visibility = \'hidden\';\n\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value=\'\';\n\t\t\t\t\t\t\t\t\t    parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.disabled=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<script>\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.disabled=true;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value=\'\';\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id2_no.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id2_no.disabled=true;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value=\'\';\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id3_no.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<script>\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no) parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.disabled=true;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value=\'\';\n\t\t\t\t\t\t\t\t\t    parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.disabled=true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].father_alt_id4_no.disabled=true;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].National_id){\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.disabled=true;}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].National_id){\tparent.frames[1].frames[2].document.forms[0].National_id.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].National_id.disabled=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=true;}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar temp;\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\tfor(i=0;i<parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options.length;i++){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\ttemp=parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[i].value;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'==temp){\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[i].selected=true;\n\t\t\t\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].cboOtherAltID.disabled=true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=true;\t\n\t\t\t\t\t\t\t\t}\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.value=\'\';\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=true;\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=true;\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t/*\t var temp;\n\t\t\t\t\t\t\t\t\tfor(i=0;i<parent.frames[1].frames[2].document.forms[0].cboNationality.options.length;i++){\n\t\t\t\t\t\t\t\t\ttemp=parent.frames[1].frames[2].document.forms[0].cboNationality.options[i].value;\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'==temp){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.options[i].selected=true;  \n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].cboNationality.disabled=true;\n\t\t\t\t\t\t\t\t\t}}\t\t */\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality.value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\t            parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=true;\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t<script> \n\t\t\t\t\t\t\t\t\t\t/*\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;\n\t\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value=\'\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled = true;\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled = true;\n\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\t\t\tvar temp;\n\t\t\t\t\t\t\t\t\tfor(i=0;i<parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options.length;i++){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\ttemp=parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[i].value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'==temp){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[i].selected=true;\n\t\t\t\t\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].cboEthnicGroup.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroup.value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=true;\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar temp;\n\t\t\t\t\t\t\t\t\tfor(i=0;i<parent.frames[1].frames[2].document.forms[0].cboReligion.options.length;i++){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\ttemp=parent.frames[1].frames[2].document.forms[0].cboReligion.options[i].value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'==temp){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.options[i].selected=true;\n\t\t\t\t\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].cboReligion.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboReligion.disabled=true;\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar temp;\n\t\t\t\t\t\t\t\t\tfor(i=0;i<parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options.length;i++){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\ttemp=parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[i].value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'==temp){\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[i].selected=true;\n\t\t\t\t\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].cboOccupationClass.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=true;\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t<script>\n\t\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t\t\t\t\t\tvar n = parent.frames[1].frames[2].document.forms[0].cboOccupation.options.length;\n\t\t\t\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.remove(\"cboOccupation\");\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tvar opt=parent.frames[1].frames[2].document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.add(opt);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=true;\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.value=\'\';\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=true;\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<script>\n\t\t\t\tvar tempval;\n\t\t\t\t//if(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'==\'REGISTER_NEWBORN\')\n\t\t\t\ttempval=2;\n\t\t\t    //else \n\t\t\t\t//tempval=2;\n\n\t\t\t\t\tvar n=parent.frames[1].frames[tempval].document.forms[0].";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =".options.length;\n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[tempval].document.forms[0].";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =".remove(\"born_at_locn_code\");\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\tvar temp = \"\";\n\t\t\t\tvar temp1 = \'---\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'---\';\n\t\t\t\t//var temp1=\"--- Select ---\";\n\t\t\t\t\t\t\n\t\t\t\tvar opt=parent.frames[1].frames[tempval].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\tparent.frames[1].frames[tempval].document.forms[0].";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =".add(opt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar opt=parent.frames[1].frames[tempval].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[1].frames[tempval].document.forms[0].";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =".add(opt);\n\t\t\t\t\t</script>\n\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
  
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rset = null;
        ResultSet rset5 = null;
        ResultSet rset2 = null;
        java.sql.Statement stmt3 = null;
        ResultSet rset3 = null;
        java.sql.Statement stmt4 = null;
        ResultSet rset4 = null;

        String facilityId = (String) session.getValue("facility_id");
        String locale =((String)session.getAttribute("LOCALE"));
        String value1 = request.getParameter("field1")==null?"":request.getParameter("field1");
        String value2 = request.getParameter("field2")==null?"":request.getParameter("field2");
        String value3 = request.getParameter("field3")==null?"":request.getParameter("field3");
        String fatherDtlsIndex = request.getParameter("fatherDtlsIndex")==null?"0":request.getParameter("fatherDtlsIndex");
		
        if(value2 == null)  value2 = "";
		String born_at = request.getParameter("born_at_type")==null?"":request.getParameter("born_at_type");

        String sql ="";
		String sqlRelation = "";
        //String code = "";
        String desc = "";
        String fathername = "";
		String strOccupationCode = "";
		String strOccupationDesc = "";
    
        try
        {
			con = ConnectionManager.getConnection(request);
            if(value1.equals("new_born_sex"))
            {
                String selectedsex  = "";;
                String dftmalesuf       = "";
                String dftfemalesuf = "";
                String  defval              = "";
                StringTokenizer st  = new StringTokenizer(value2,"`");
                if(st.countTokens() == 3)
                {
                    while(st.hasMoreTokens())
                    {
                        selectedsex = st.nextToken();
                        dftmalesuf      = st.nextToken();
                        dftfemalesuf    = st.nextToken();
                    }
                }
                else if(st.countTokens() == 2)
                {
                    while(st.hasMoreTokens())
                    {
                        selectedsex = st.nextToken();
                        if(selectedsex.equals("M"))
                            dftmalesuf      = st.nextToken();
                        else if(selectedsex.equals("F"))
                            dftfemalesuf    = st.nextToken();
                    }
                }
				else if(st.countTokens() == 1)
				{
					selectedsex = st.nextToken();		
				}
                if(selectedsex.equals("M"))
                {
                    if(locale.toUpperCase().equals("EN"))
					{
					sql = " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'M' and Eff_Status = 'E' " ;//        Default the value as MP_Param.NAME_SUFFIX_MALE_NB
                    defval = dftmalesuf;
					}else
					{
					sql = " Select (CASE WHEN NAME_SUFFIX_LOC_LANG IS NOT NULL THEN NAME_SUFFIX_LOC_LANG ELSE  NAME_SUFFIX END) NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'M' and Eff_Status = 'E' " ;//        Default the value as MP_Param.NAME_SUFFIX_MALE_NB
                    defval = dftmalesuf;
					
					}
                }
                else if(selectedsex.equals("F"))
                {    if(locale.toUpperCase().equals("EN"))
					{
                    sql = " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'F' and Eff_Status = 'E' " ; //Default the value as MP_Param.NAME_SUFFIX_FEMALE_NB
                    defval = dftfemalesuf;
					}else
					{
					 sql = " Select (CASE WHEN NAME_SUFFIX_LOC_LANG IS NOT NULL THEN NAME_SUFFIX_LOC_LANG ELSE  NAME_SUFFIX END) NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'F' and Eff_Status = 'E' " ; //Default the value as MP_Param.NAME_SUFFIX_FEMALE_NB
                    defval = dftfemalesuf;
					}
                }

                if(!sql.equals(""))
                {
                    
                    pstmt=con.prepareStatement(sql);
                    rset = pstmt.executeQuery();
                    if(rset!=null)
                    {
                        while(rset.next())
                        {
                            desc = rset.getString("NAME_SUFFIX");
                            
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(defval));
            _bw.write(_wl_block8Bytes, _wl_block8);

                        }
                    }
                }
            }
            else if(value1.equals("father_patient_id"))
            {
				sql ="select decode('"+locale+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,sex from mp_patient where PATIENT_ID=?  ";
                
                if(pstmt != null)   pstmt.close();
				if(rset  != null)   rset.close();
                pstmt = con.prepareStatement(sql); 			
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                boolean flag=true; 			

                if(rset.next())
                {
                    if(rset.getString(2).equals("M"))

                    {
                        fathername = rset.getString(1);							
                        out.println("<script>parent.frames[1].frames[2].document.forms[0].father_patient_name.readOnly=true; parent.frames[1].frames[2].document.forms[0].father_patient_name.value=\" "+fathername+" \";</script>"); 						
                    }
                    else
                    {
                        flag=false;
                        out.println("<script>alert(getMessage('GENDER_MISMATCH','MP'));parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();</script>");
                    }
                }
                else
                {
                    flag=false;
                    out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP')); parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");
                }
                if(flag)
                {
                            String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
                            
                            if(pstmt != null)   pstmt.close();
							if(rset2!=null) rset2.close();
                            pstmt = con.prepareStatement(sql2);
                            pstmt.setString(1,value2) ;
                            
                            rset2 = pstmt.executeQuery();
                            String dob="";
                            while(rset2.next())
                            {
                            dob= rset2.getString(1);
                            }

                            String sql3=" select NB_FATHER_MIN_AGE from mp_param";
                            
                            stmt3 = con.createStatement();
                            rset3 = stmt3.executeQuery(sql3);
                            int father_min_age=0;
                            while(rset3.next())
                            {
                            father_min_age=rset3.getInt(1);
                            }
                            int pat_age=0;
                            String sql4="select calculate_age('"+dob+"',1) from dual ";
                            stmt4 = con.createStatement();
                            rset4 = stmt4.executeQuery(sql4);
                            while(rset4.next())
                            {
                            pat_age=rset4.getInt(1);
                            }
                            
                            if(pat_age < father_min_age)
                            {
                            out.println("<script>alert(getMessage('FATHER_AGE_PARAM'),'MP');parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");
                            }
                    }
                
            }
			else if(value1.equals("Umb_cord_cut_by"))
            {
                sql ="select count(PRACTITIONER_ID) from AM_PRACTITIONER where PRACTITIONER_ID=?";
                
                if(pstmt != null)   pstmt.close();
				if(rset  != null)   rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                //boolean flag=true;
				if(rset != null){
					if(rset.next()){
						String sql4="select B.POSITION_DESC JOB_TITLE from AM_PRACTITIONER A, AM_POSITION_LANG_VW B WHERE a.PRACTITIONER_ID =? and a.position_code=b.position_code(+) and language_id='"+locale+"'";						

						if(pstmt != null)   pstmt.close();
						if(rset != null) rset.close();
						pstmt = con.prepareStatement(sql4);
						
						pstmt.setString(1,value2);
						rset = pstmt.executeQuery();
						String desig="";
						if(rset != null){
							if(rset.next()){
								desig=rset.getString("JOB_TITLE");						
							}
						}

						
						if(desig==null || desig.equals("null")){
						}else{				
							out.println("<script>parent.frames[1].frames[2].document.getElementById('nmdesig').innerHTML=\"<b>"+desig+"\";</script>");
							
						}

						
					}else{
						// message to be changed to practitioner id
						out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP')); parent.frames[1].frames[2].document.forms[0].Umb_cord_cut_by.value='';parent.frames[1].frames[2].document.getElementById('nmdesig').innerHTML='';</script>");
					}
				}
			}else if(value1.equals("cboOccupationClass")){
								
                sql ="select short_desc,ocpn_code from MP_occupation_lang_vw where ocpn_class_code=? and language_id='"+locale+ "'";
                
                if(pstmt != null)   pstmt.close();
				if(rset != null) rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                //boolean flag=true;
				String disp="";
				String hid="";
				//String cont="";
				
                if(rset != null){

				while (rset.next())
				{
					hid	= rset.getString("ocpn_code");
					disp	= rset.getString("short_desc");

				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(hid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block11Bytes, _wl_block11);

                
					}
				}
			}else if(value1.equals("DtTm")){

				

				String d1=value2.substring(0,value2.indexOf(" "));
				//String d2=value2.substring(value2.indexOf(" " )+1);
				String d3=value3.substring(0,value3.indexOf("*"));
				String d4=value3.substring(value3.indexOf("*" )+1);
			

				if(d3.equals("H")){

					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+value2+"','dd/mm/yyyy hh24:mi'))* 100 FROM dual";
				}else{				

					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+d1+"','dd/mm/yyyy')) FROM dual";
				}
								
                
                
                if(pstmt != null)   pstmt.close();
                if(rset !=null) rset.close();
				pstmt = con.prepareStatement(sql);
                                
                rset = pstmt.executeQuery();
				double diff=0;
                if(rset != null){

				while (rset.next())
				{
					diff	= rset.getDouble(1);                
					}
				}
				
				
				double d44=Double.parseDouble(d4);
				
				
				if(d3.equals("H")){
					// 4.1666667 represents 1 hour
					if(diff>(d44*4.1666667)){
					out.println("<script>alert(getMessage('REGN_RSTRD_NB_HRS','MP'))");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.value='';");
					 out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.focus()</script>");
					}
				}else{
					if(diff>d44){
					out.println("<script>alert(getMessage('REGN_RESTRICTED_FOR_NB','MP'))");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.value='';");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.focus()</script>");
					}		
				}
				
				
            }

			else if(value1.equals("pat_id"))
            {
				String name_prefix = "";
				String first_name = "";
				String second_name = "";
				String third_name = "";
				String family_name = "";
				String name_suffix = "";
				String name_prefix_loc_lang = "";
				String first_name_loc_lang = "";
				String second_name_loc_lang = "";
				String third_name_loc_lang = "";
				String family_name_loc_lang = "";
				String name_suffix_loc_lang = "";
				
                sql ="select decode('"+locale+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX,name_prefix, first_name, second_name, third_name, family_name, name_suffix, name_prefix_loc_lang, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, name_suffix_loc_lang from mp_patient where PATIENT_ID=? ";
                
                if(pstmt != null)   pstmt.close();
				if(rset != null)   rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                boolean flag=true;

                if(rset.next())
                {
                    if(rset.getString(2).equals("M"))

                    {
                        fathername = rset.getString(1);

						name_prefix = rset.getString("name_prefix")==null?"":rset.getString("name_prefix");
						first_name = rset.getString("first_name")==null?"":rset.getString("first_name");
						second_name = rset.getString("second_name")==null?"":rset.getString("second_name");
						third_name = rset.getString("third_name")==null?"":rset.getString("third_name");
						family_name = rset.getString("family_name")==null?"":rset.getString("family_name");
						name_suffix = rset.getString("name_suffix")==null?"":rset.getString("name_suffix");
						name_prefix_loc_lang = rset.getString("name_prefix_loc_lang")==null?"":rset.getString("name_prefix_loc_lang");
						first_name_loc_lang = rset.getString("first_name_loc_lang")==null?"":rset.getString("first_name_loc_lang");
						second_name_loc_lang = rset.getString("second_name_loc_lang")==null?"":rset.getString("second_name_loc_lang");
						third_name_loc_lang = rset.getString("third_name_loc_lang")==null?"":rset.getString("third_name_loc_lang");
						family_name_loc_lang = rset.getString("family_name_loc_lang")==null?"":rset.getString("family_name_loc_lang");
						name_suffix_loc_lang = rset.getString("name_suffix_loc_lang")==null?"":rset.getString("name_suffix_loc_lang");
                        out.println("<script>parent.frames[1].frames[2].document.forms[0].father_patient_name.readOnly=true; parent.frames[1].frames[2].document.forms[0].father_patient_name.value=\" "+fathername+" \";</script>");

						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fatherDtlsIndex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block25Bytes, _wl_block25);

                    }
                    else
                    {
                        flag=false; 
            _bw.write(_wl_block26Bytes, _wl_block26);

                    }
                }
                else
                {
                    flag=false;
                    
            _bw.write(_wl_block27Bytes, _wl_block27);
					
                }
                if(flag)
                {
                            String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
                            
                            if(pstmt != null)   pstmt.close();
							if(rset2 != null)   rset2.close();
                            pstmt = con.prepareStatement(sql2);
                            pstmt.setString(1,value2) ;
                            
                            rset2 = pstmt.executeQuery();
                            String dob="";
                            while(rset2.next())
                            {
                            dob= rset2.getString(1);
                            }

                            String sql3=" select NB_FATHER_MIN_AGE from mp_param";
                            
							if(stmt3!=null) stmt3.close();
							if(rset3!=null) rset3.close();
                            stmt3 = con.createStatement();
                            rset3 = stmt3.executeQuery(sql3);
                            int father_min_age=0;
                            while(rset3.next())
                            {
                            father_min_age=rset3.getInt(1);
                            }
                            int pat_age=0;
                            String sql4="select calculate_age('"+dob+"',1) from dual ";
							if(stmt4!=null) stmt4.close();
							if(rset4!=null) rset4.close();
                            stmt4 = con.createStatement();
                            rset4 = stmt4.executeQuery(sql4);
                            while(rset4.next())
                            {
                            pat_age=rset4.getInt(1);
                            }
                            
                            if(pat_age < father_min_age)
                            {
                            out.println("<script>alert(getMessage('FATHER_AGE_PARAM','MP'));parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");

							
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fatherDtlsIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);

                            }else{

								//String sql21="SELECT   a.alt_id1_no alt_id1_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,  a.nationality_code AS ncd,  a.race_code AS racecode,  a.relgn_code AS relgcd,  b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  c.long_name   nationality_desc FROM   mp_patient a,  mp_pat_rel_contacts b,  mp_country_lang_vw c WHERE   a.patient_id=? AND  a.patient_id=b.patient_id AND  a.nationality_code=c.country_code  AND c.language_id='"+locale+"'";
								/*String sql21="SELECT   a.alt_id1_no alt_id1_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,  a.nationality_code AS ncd,  a.race_code AS racecode, d.long_desc race_desc, a.relgn_code AS relgcd,  b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  c.long_desc   nationality_desc FROM   mp_patient a,  mp_pat_rel_contacts b,  mp_country_lang_vw c, mp_race_lang_vw d WHERE   a.patient_id=? AND  a.patient_id=b.patient_id AND  a.nationality_code=c.country_code  AND a.race_code = d.race_code and c.language_id='"+locale+"' and d.language_id='"+locale+"'";*/
								String sql21="SELECT   a.alt_id1_no alt_id1_no,a.alt_id2_no alt_id2_no,a.alt_id3_no alt_id3_no,a.alt_id4_no alt_id4_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,a.nationality_code AS ncd,  a.race_code AS racecode, mp_get_desc.mp_race(a.race_code,'"+locale+"',1) race_desc, a.relgn_code AS relgcd, b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  mp_get_desc.mp_country(a.nationality_code,'"+locale+"',1) nationality_desc FROM mp_patient a,  mp_pat_rel_contacts b WHERE a.patient_id=? AND a.patient_id = b.patient_id ";
								
								if(pstmt != null)   pstmt.close();
								if(rset2 != null)   rset2.close();
								pstmt = con.prepareStatement(sql21);
								pstmt.setString(1,value2) ;
								
								rset2 = pstmt.executeQuery();
								
								String tmpnid="";
								String tmpoidtyp="";
								String tmpoidno="";
								String tmpncd="";								
								String tmpethgrp="";
								String tmprelgcd="";								
								String tmpocclscd="";
								String tmpoccd="";
								String tmpocpndesc="";
								String alt_id1_no="";
								String alt_id2_no="";
								String alt_id3_no="";
								String alt_id4_no="";
								String nationality_desc="";
								String race_desc="";

								if(rset2 != null){	
									
									if(rset2.next()){
										alt_id1_no=rset2.getString("alt_id1_no");
										alt_id2_no=rset2.getString("alt_id2_no");
										alt_id3_no=rset2.getString("alt_id3_no");
										alt_id4_no=rset2.getString("alt_id4_no");
										tmpnid=rset2.getString("nid");
										tmpoidtyp=rset2.getString("oidtyp");
										tmpoidno=rset2.getString("oidno");
										tmpncd=rset2.getString("ncd");
										tmpethgrp=rset2.getString("racecode");
										tmprelgcd=rset2.getString("relgcd");
										tmpocclscd=rset2.getString("occlscd");
										tmpoccd=rset2.getString("occd");
										tmpocpndesc=rset2.getString("ocpn_desc");
										nationality_desc=rset2.getString("nationality_desc");
										race_desc=rset2.getString("race_desc");
										if(nationality_desc ==null) nationality_desc="";
									}
								}								
								if(alt_id1_no==null || alt_id1_no.equals("null")){
									
            _bw.write(_wl_block30Bytes, _wl_block30);

								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value='"+alt_id1_no+"';</script>");
								
            _bw.write(_wl_block31Bytes, _wl_block31);
}if(alt_id2_no==null || alt_id2_no.equals("null")){
            _bw.write(_wl_block32Bytes, _wl_block32);

								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value='"+alt_id2_no+"';</script>");
								
            _bw.write(_wl_block33Bytes, _wl_block33);
}if(alt_id3_no==null || alt_id3_no.equals("null")){
            _bw.write(_wl_block34Bytes, _wl_block34);

								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no)parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value='"+alt_id3_no+"';</script>");
								
            _bw.write(_wl_block35Bytes, _wl_block35);
}if(alt_id4_no==null || alt_id4_no.equals("null")){
									
            _bw.write(_wl_block36Bytes, _wl_block36);

								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value='"+alt_id4_no+"';</script>");
								
            _bw.write(_wl_block37Bytes, _wl_block37);

								}
								if(tmpnid==null || tmpnid.equals("null")){
								
            _bw.write(_wl_block38Bytes, _wl_block38);

								}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tmpnid));
            _bw.write(_wl_block40Bytes, _wl_block40);

								}
								if(tmpoidtyp==null || tmpoidtyp.equals("null")){
								
            _bw.write(_wl_block41Bytes, _wl_block41);

								}else{
								
								
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tmpoidtyp));
            _bw.write(_wl_block43Bytes, _wl_block43);

										
									
								}
								
								
								if(tmpoidno==null || tmpoidno.equals("null")){
									
            _bw.write(_wl_block44Bytes, _wl_block44);

								}else{
									out.println("<script>if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='"+tmpoidno+"';parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=true;}</script>");									
								}

								
								if(tmpncd==null || tmpncd.equals("null")){
									
            _bw.write(_wl_block45Bytes, _wl_block45);

								} else {
									
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tmpncd));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tmpncd));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);

									
								}

								if(tmpethgrp==null || tmpethgrp.equals("null")){
									
            _bw.write(_wl_block50Bytes, _wl_block50);

								} else {
									
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tmpethgrp));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tmpethgrp));
            _bw.write(_wl_block54Bytes, _wl_block54);

								}

								if(tmprelgcd==null || tmprelgcd.equals("null")){
									
            _bw.write(_wl_block55Bytes, _wl_block55);

								}else{
									
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tmprelgcd));
            _bw.write(_wl_block57Bytes, _wl_block57);

								}

									if(tmpocclscd==null || tmpocclscd.equals("null")){
									
            _bw.write(_wl_block58Bytes, _wl_block58);

								}else{
									
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tmpocclscd));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}

								if(tmpoccd==null || tmpoccd.equals("null")){
									
            _bw.write(_wl_block61Bytes, _wl_block61);

								}else{
										try{
											sqlRelation = "SELECT ocpn_code, short_desc FROM mp_occupation_lang_vw where OCPN_CODE = ? and language_id='"+locale+"'";
											pstmt1 = con.prepareStatement(sqlRelation);
											pstmt1.setString(1,tmpoccd);
											rset5 = pstmt1.executeQuery();
											if(rset5 != null)
												{
											while(rset5.next())	
												{

											strOccupationCode = rset5.getString("ocpn_code");
											strOccupationDesc = rset5.getString("short_desc");
												}
												}
											
										}
										catch(Exception e)
										{out.println(e.toString());}
										finally {
										if(rset5 != null)rset5.close();
										if(pstmt1 != null)pstmt1.close();
										}
									
									
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strOccupationCode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strOccupationDesc));
            _bw.write(_wl_block64Bytes, _wl_block64);

								}

									if(tmpocpndesc==null || tmpocpndesc.equals("null")){
									
            _bw.write(_wl_block65Bytes, _wl_block65);

								}else{
									out.println("<script>parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='"+tmpocpndesc+"';</script>");
									
            _bw.write(_wl_block66Bytes, _wl_block66);

								}
		
							}
                    }
                
            }
			else if(value1.equals("born_at"))
			{
				String function_idborn=checkForNull(request.getParameter("function_idborn"));
				String ipatenatalfun=checkForNull(request.getParameter("ipatenatalfun"));
				
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(function_idborn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ipatenatalfun));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ipatenatalfun));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(ipatenatalfun));
            _bw.write(_wl_block71Bytes, _wl_block71);

				if(!born_at.equals(""))	
				{
				if(born_at.equals("C"))	
				{
				sql ="SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID ='"+facilityId+"'  AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'A' AND CARE_LOCN_TYPE_IND = 'C'  and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("E"))	
				{
					sql = " SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'E' AND CARE_LOCN_TYPE_IND = 'C' and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("D"))	
				{
					sql = " SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'A' AND CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("N"))	
				{
					sql = " SELECT long_desc SHORT_DESC, NURSING_UNIT_CODE CLINIC_CODE FROM IP_NURSING_UNIT_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND PATIENT_CLASS = 'IP' and language_id='"+locale+"'  ORDER BY SHORT_DESC ";
				}
				/*Added by Ashwini on 27-Jun-2018 for ML-MMOH-CRF-0833*/
				else if(born_at.equals("O"))	
				{
					sql = " SELECT oper_room_code CLINIC_CODE, SHORT_DESC FROM ot_oper_room_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("P"))	
				{
					sql = " SELECT CLINIC_CODE, long_desc SHORT_DESC FROM op_clinic_lang_vw a WHERE facility_id = '"+facilityId+"' AND language_id = '"+locale+"' AND eff_status = 'E' AND clinic_type = 'E' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("W"))	
				{
					sql = " SELECT CLINIC_CODE, SHORT_DESC FROM rd_clinic_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("R"))	
				{
					sql = " SELECT room_num CLINIC_CODE, SHORT_DESC FROM am_facility_room_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' AND operating_facility_id = '"+facilityId+"' AND room_type = 'R' ORDER BY SHORT_DESC ";
				}
				/*End ML-MMOH-CRF-0833*/

                
                if(pstmt != null)   pstmt.close();
				if(rset != null)   rset.close();
                pstmt = con.prepareStatement(sql); 				
                
                rset = pstmt.executeQuery();               
            
				String disp="";
				String hid="";
            _bw.write(_wl_block72Bytes, _wl_block72);
  if(rset != null){
		
				while (rset.next())
				{
					hid	= rset.getString("CLINIC_CODE");
					disp	= rset.getString("SHORT_DESC");

				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(hid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(ipatenatalfun));
            _bw.write(_wl_block74Bytes, _wl_block74);

                
					}
				}
			}
	}
            
    }catch(Exception e) { out.println(e.toString());}
    finally
    {
		if(rset2!=null) rset2.close();
		if(rset3!=null) rset3.close();
		if(rset4!=null) rset4.close();
        if(pstmt != null) pstmt.close();
		if(stmt3!=null) stmt3.close();
		if(stmt4!=null) stmt4.close();	
        if (rset != null) rset.close();
        if(con != null) ConnectionManager.returnConnection(con,request);
    }


            _bw.write(_wl_block75Bytes, _wl_block75);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
