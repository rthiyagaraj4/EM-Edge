package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;
import eCommon.XSSRequestWrapper;

public final class __nataltidcomponentcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/natAltIDComponentCriteria.jsp", 1743068532476L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/26/2005 4:24 PM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<Script language=\'javascript\' src=\'../../eMP/js/natAltIDComponentCriteria.js\'></Script>\n<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n\n<!-- Added by Ashwin K for AAKH-CRF-0150-->\n<Script src=\"../../eMP/js/SmartCard01.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\n\t\t\n<Script src=\"../../eMP/js/json02.js\"></Script>\n\n <Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n<!--<Script src=\"../../eCommon/js/jquery-3.6.0.min.js\"></Script> -->\n <!-- Added By Ashwin K for AAKH-CRF-0150 -->\n   \n<link href=\"../../eCommon/html/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<table cellpadding=\'2\' border=\'0\' cellspacing=\'0\' width=\'100%\' id=\'moreCrite1\' Style=\"display:none;visibility:hidden\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table cellpadding=\'2\' border=\'0\' cellspacing=\'0\' width=\'100%\' id=\'moreCrite1\' >\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'  >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<!-- <applet code=\"CardReaderApplet.class\" name=\"CardReader\"\n\t\t\t\t\t\tcodebase=\"../../eMP/CardReader/\" archive=\"CardReaderApplet.jar\" width=\"5\"\n\t\t\t\t\t\theight=\"5\">\n\t\t\t\t\t\t<PARAM name=\"button_width\" value=\"0\" />\n\t\t\t\t\t\t<PARAM name=\"button_height\" value=\"0\" />\n\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\t\t\t\t\t\n\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t\t\t\t</applet> -->\n\n<!--\n\t\t\t\t\t\t\t <APPLET style=\"border:solid 1px gray\" id=\"PublicDataWebComponent\" name=\"PublicDataWebComponent\" codebase=\"../../eMP/CardReader/\" CODE=\"emiratesid.jio.webcomponents.PublicDataReader\"\n                                                        ARCHIVE=\"PublicDataApplet-Sagem.jar\" WIDTH=\"0\" HEIGHT=\"0\">\n                                                        <param name=\"EncryptParameters\" value=\"false\" />\n                                                        <param name=\"RelativeCertPath\" value=\"certs\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\n                                                         This browser does not support Applets.\n                                                    </APPLET> -->\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->\n\t\t\t\t\t\t\t\t\t\t\t\t <APPLET style=\"border:solid 1px gray\" id=\"PublicDataWebComponent\" name=\"PublicDataWebComponent\" codebase=\"../../eMP/CardReader/\" CODE=\"emiratesid.jio.webcomponents.PublicDataReader\"\n                                                        ARCHIVE=\"PublicDataApplet-Sagem.jar\" WIDTH=\"0\" HEIGHT=\"0\">\n                                                        <param name=\"EncryptParameters\" value=\"false\" />\n                                                        <param name=\"RelativeCertPath\" value=\"certs\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\n                                                         This browser does not support Applets.\n                                                    </APPLET> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\t\n\t\t\t\t<!-- Added By  Ashwin K id=\"national_id_no\"  for AAKH-CRF-0150 -->\n\t\t\t\t<td class=\'fields\'  width=\'25%\'><input type=\'text\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" id=\"national_id_no\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" name=\'national_id_no\' maxlength=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onKeyPress=\'return ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' size=\'27\' onBlur=\'validateID(this,\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\n\t\t\t\t</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<tr>\t\n\t\t\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t\t\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"\">\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t<td class=\'label\'  width=\'25%\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<input type=\'hidden\' name=\'h_accept_oth_alt_id_yn\' id=\'h_accept_oth_alt_id_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\' width=\'25%\'><select onchange=\'enabledFields(this);\' name=\'other_alt_type\' id=\'other_alt_type\'  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="><option value=\'\'>------";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t</select></td>\n\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t<!-- Lnk Inc: 48147 - Modified the maximum length of other_alt_id field as 20-->\n\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"\" size=\'20\' maxlength=\'20\' disabled onKeyPress=\'return SpecialCharRestriction(event)\' onBlur=\'validateID(this);\'></td>\n\t\t\t\t<input type=\'hidden\' name=\'alert_reqd_yn\' id=\'alert_reqd_yn\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->\n\t\t\t\t<input type=\'hidden\' name=\'mr_transaction\' id=\'mr_transaction\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\t\n\t\t\t<!-- Addition Ends -->\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->\n\t\t\t\t<input type=\'hidden\' name=\'mr_transaction\' id=\'mr_transaction\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\t\n\t\t\t<!-- Addition Ends -->\n\t\t\t \t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</TR>\n\t\t\t<TR>\t\t\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t<td  class=\'fields\' ><input type=\'text\' name=\'alt_id1_no\' id=\'alt_id1_no\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onKeyPress=\'return CheckForSpeclChars(event)\' size=\'27\' maxlength=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_reqd_yn\' id=\'alt_id1_reqd_yn\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_type\' id=\'alt_id1_type\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></td>\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric\' id=\'alt_id1_accept_alphanumeric\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t<td  class=\'label\'  >&nbsp;</td>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t<td  class=\'fields\' ><input type=\'text\' name=\'alt_id2_no\' id=\'alt_id2_no\' onBlur=\'//validateID(this);\'  size=\'27\' onKeyPress=\'return altID234Validations(event)\' maxlength=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id2_reqd_yn\' id=\'alt_id2_reqd_yn\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id2_type\' id=\'alt_id2_type\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t\t<td  class=\'label\'  >&nbsp;</td>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</tr>\n\t\t\t<tr>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t\n\t\t\t\t<td  class=\'fields\'  ><input type=\'text\' name=\'alt_id3_no\' id=\'alt_id3_no\' onBlur=\'//validateID(this);\' size=\'27\' onKeyPress=\'return altID234Validations(event)\' maxlength=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id3_reqd_yn\' id=\'alt_id3_reqd_yn\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id3_type\' id=\'alt_id3_type\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t<td  class=\'fields\'   ><input type=\'text\' name=\'alt_id4_no\' id=\'alt_id4_no\' onBlur=\'//validateID(this);\' size=\'27\' onKeyPress=\'return altID234Validations(event)\' maxlength=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_reqd_yn\' id=\'alt_id4_reqd_yn\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id4_type\' id=\'alt_id4_type\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<td  class=\'label\'  >&nbsp;</td>\n\t\t\t\t\t<td  class=\'label\' >&nbsp;</td>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t</tr>\n\t\t</table>\n\t\t\t<!--for smart card-->\n\t<input type=\"hidden\" name=\"txtSmartcard_path\" id=\"txtSmartcard_path\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"txtSmartcard_dup\" id=\"txtSmartcard_dup\" value=\"\">\n\t<input type=\"hidden\" name=\"txtSmartcard_fn\" id=\"txtSmartcard_fn\" value=\"\">\n\t<input type=\"hidden\" name=\"txtSmartcard_pat_id\" id=\"txtSmartcard_pat_id\" value=\"\">\n\t<!--for smart card-->\n\t<!--for Alkhaleej smart card-->\n\t<input type=\"hidden\" name=\"txtSmart_fn_name\" id=\"txtSmart_fn_name\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023-->\n\t<input type=\"hidden\" name=\"biometric_authentication_yn\" id=\"biometric_authentication_yn\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n<!-- Added By Ashwin K for AAKH-CRF-0150 -->\n<script> \n$(document).ready(function(){\n$(\"#M_btn2\").prop(\'disabled\', false); \n$(\"#national_id_no\").prop(\'disabled\', true);\n$(\"#AddVisit_EmiratesID_edit\").click(function()\n {\n\t if($(\'#AddVisit_EmiratesID_edit\').is(\':checked\'))\n\t {\n\t\tvar auth_userEmirates = EditEmiratesID_authScr();\n\t\tif(auth_userEmirates == true)\n\t\t {\n\t\t\t$(\"#national_id_no\").prop(\'disabled\', false);\n\t\t\t$(\"#M_btn2\").prop(\'disabled\', true);\n\t\t }\n\t\telse\n\t\t {\n\t\t$(\'#AddVisit_EmiratesID_edit\').prop(\'checked\', false);\n\t\t }\n\t }\n\t else\n\t {\n\t\t\t$(\"#national_id_no\").prop(\'disabled\', true);\n\t\t\t$(\"#M_btn2\").prop(\'disabled\', false);\n\t }\n\t\t  });\n\t});\nasync function EditEmiratesID_authScr()\n{\t\n\tvar retVal=new Array();\n\tvar dialogHeight= \"10\" ;\n\tvar dialogWidth\t= \"22\" ;\n\tvar dialogTop = \"225\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tretVal =await window.showModalDialog(\"../../eSM/jsp/AuthorizeMain.jsp?mode=s\",arguments,features);\n\treturn retVal;\n\n}\n\t\tfunction MButton_click_AddVisit()\n\t\t\t{\n\t\t \tvar res = RegAttnSearch_ReadDF1_onclick(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =");\n\t\t\tvar arr = res.split(\"!~\");\n\t\t\tvar res_natid = arr[0].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\tvar res_mobno = arr[1].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\tvar patcnt = 0;\n\t\t\tvar p_id = \"\";\t\n\t\t\t$.ajax({\n\t\t\t\ttype: \"POST\",\n\t\t\t\turl: \"../../eMP/jsp/getPatientCount.jsp\",\n\t\t\t\tdata: {\n\t\t\t\t\tNatID : res_natid,\n\t\t\t\t\tsmart_data : res\t\n\t\t\t\t},\n\t\t\t\tasync: false\n\t\t\t})\n\t\t\t.done (function(data, textStatus, jqXHR) { \n\t\t\tres = data;\n\t\t\tvar res1 = res.substring(res.indexOf(\"<patcnt>\")+8,res.indexOf(\"</patcnt>\"));\n\t\t\tvar res2 = res.substring(res.indexOf(\"<patid>\")+7,res.indexOf(\"</patid>\"));\n\t\t\tpatcnt = parseInt(res1);\n\t\tp_id = res2;  \n\t\t});\nif(patcnt == 0)\n\t{\n\talert(getMessage(\'MOBILE_NO_SEARCH\',\'MP\'));\n\tgetPatID_Mbtn(res_mobno);\n\t}\nelse\n\t{\n\tdocument.getElementById(\"pat_id1\").value= p_id;\n\tdocument.getElementById(\'srch_code\').click();\n\t}\n\t}\n\tfunction MButton_click_OPRegVisit()\n\t\t\t{\n\t\t \tvar res = OPRegVisit_ReadDF1_onclick(";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =");\n\t\t\tvar arr = res.split(\"!~\");\n\t\t\tvar res_natid = arr[0].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\tvar res_mobno = arr[1].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\tvar patcnt = 0;\n\t\t\tvar p_id = \"\";\t\n\t\t\t$.ajax({\n\t\t\t\ttype: \"POST\",\n\t\t\t\turl: \"../../eMP/jsp/getPatientCount.jsp\",\n\t\t\t\tdata: {\n\t\t\t\t\tNatID : res_natid,\n\t\t\t\t\tsmart_data : res\t\n\t\t\t\t},\n\t\t\t\tasync: false\n\t\t\t})\n\t\t\t.done (function(data, textStatus, jqXHR) { \n\t\t\tres = data;\n\t\t\tvar res1 = res.substring(res.indexOf(\"<patcnt>\")+8,res.indexOf(\"</patcnt>\"));\n\t\t\tvar res2 = res.substring(res.indexOf(\"<patid>\")+7,res.indexOf(\"</patid>\"));\n\t\t\tpatcnt = parseInt(res1);\n\t\tp_id = res2;  \n\t\t});\nif(patcnt == 0)\n\t{\n\talert(getMessage(\'MOBILE_NO_SEARCH\',\'MP\'));\n\tgetPatID_Mbtn(res_mobno);\n\t}\nelse\n\t{\n\tdocument.getElementById(\"pat_id1\").value= p_id;\n\tdocument.getElementById(\'srch_code\').click();\n\t}\n\t}\n\t</script>\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con			= null;
    PreparedStatement pstmt	= null;
    ResultSet rs			= null ;
	
	con = ConnectionManager.getConnection(request);

	String sql							= "";
	String alt_id1_reqd_yn				= "";
	String alt_id2_reqd_yn				= "";
	String alt_id3_reqd_yn				= "";
	String alt_id4_reqd_yn				= "";
	String alt_id1_type					= "";
	String alt_id2_type					= "";
	String alt_id3_type					= "";
	String alt_id4_type					= "";
	String alt_id1_length				= "";
	String alt_id2_length				= "";
	String alt_id3_length				= "";
	String alt_id4_length				= "";
	String nat_id_length				= "";
	String alt_id1_exp_date_accept_yn	= "";
	String alt_id2_exp_date_accept_yn	= "";
	String alt_id3_exp_date_accept_yn	= "";
	String alt_id4_exp_date_accept_yn	= "";
	String accept_national_id_no_yn		= "";
	String nat_id_accept_alphanumeric_yn= "";
	String nat_id_prompt				= "";
	String alt_id1_desc					= "";
	String alt_id2_desc					= "";
	String alt_id3_desc					= "";
	String alt_id4_desc					= "";
	String alt_id1_no					= "";
	String alt_id2_no					= "";
	String alt_id3_no					= "";
	String alt_id4_no					= "";
	String national_id_no				= "";
	String alt_id1_exp_date				= "";
	String alt_id2_exp_date				= "";
	String alt_id3_exp_date				= "";
	String alt_id4_exp_date				= "";
	String disabledFields				= "";
	String Accept_oth_alt_id_yn			= "";
	String nat_id_check_digit_id = "";
	String nat_data_source_id = "";
	String ext_system_interface_yn = "";
	String biometric_authentication_yn="N";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	String nat_id_onKeyPress = "";
	String alt_id1_accept_alphanumeric_yn = "";
	String tab_name = checkForNull(request.getParameter("tab_name")); //Added by Ashwin K for AAKH-CRF-0150
	
	String patient_id		= request.getParameter("patient_id");
	String alert_reqd_yn	= request.getParameter("alert_reqd_yn");
    String hidetbl	= request.getParameter("hidetbl")==null?"":request.getParameter("hidetbl"); 
	String validateIDFn = "";
    String validateIdYN	= request.getParameter("validateIdYN")==null?"Y":request.getParameter("validateIdYN"); 
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 

	if(validateIdYN.equals("Y")) {
		validateIDFn = "onBlur='validateID(this);'";
	} else {
		validateIDFn = "";
	}

	//Added for disabling fields as per parameter obtained from OP

	String nat_id_disabled = request.getParameter("nat_id_disabled");
	if(nat_id_disabled == null) nat_id_disabled = "N";
	
	if(alert_reqd_yn == null) alert_reqd_yn = "N";
    if (patient_id==null || patient_id.equals("") || patient_id == "") patient_id = "";	
	if(nat_id_disabled.equals("N")) disabledFields = "";

	//Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records

	String mr_transaction = request.getParameter("mr_transaction") == null ? "N" : request.getParameter("mr_transaction");	
	
	try
	{
		if(!patient_id.equals(""))
		{
			disabledFields = "disabled";
			
			sql = "SELECT alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no, to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, to_char(alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, to_char(alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, to_char(alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, national_id_no FROM mp_patient WHERE patient_id = '"+patient_id+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs!= null&&rs.next())
			{
			
				alt_id1_no = rs.getString("alt_id1_no");
				alt_id2_no = rs.getString("alt_id2_no");
				alt_id3_no = rs.getString("alt_id3_no");
				alt_id4_no = rs.getString("alt_id4_no");
				national_id_no = rs.getString("national_id_no");
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				alt_id2_exp_date = rs.getString("alt_id2_exp_date");
				alt_id3_exp_date = rs.getString("alt_id3_exp_date");
				alt_id4_exp_date = rs.getString("alt_id4_exp_date");
			}
			if(alt_id1_no==null) alt_id1_no = "";
			if(alt_id2_no==null) alt_id2_no = "";
			if(alt_id3_no==null) alt_id3_no = "";
			if(alt_id4_no==null) alt_id4_no = "";
			if(national_id_no==null) national_id_no = "";
			if(alt_id1_exp_date==null) alt_id1_exp_date = "";
			if(alt_id2_exp_date==null) alt_id2_exp_date = "";
			if(alt_id3_exp_date==null) alt_id3_exp_date = "";
			if(alt_id4_exp_date==null) alt_id4_exp_date = "";
		}
		
		//for smart card
			pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

			rs = pstmt.executeQuery();	


			if(rs!=null && rs.next())
			{
			Smartcard_path=rs.getString("VALUE_1");
			function_name=rs.getString("VALUE_2");   // alkhaleej smart card

			}		


			if(pstmt!=null)
			pstmt.close();
			if(rs!=null)
			rs.close();
			//for smart card
		//sql = " SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N')Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type,substr(alt_id1.short_desc,1,15) alt_id1_desc, Alt_Id2_type, substr(alt_id2.short_desc,1,15) alt_id2_desc, Alt_Id3_type,substr(alt_id3.short_desc,1,15) alt_id3_desc, Alt_Id4_type, substr(alt_id4.short_desc,1,15) alt_id4_desc, nvl(Alt_Id1_length,0) Alt_Id1_length, nvl(Alt_Id2_length,0) Alt_Id2_length, nvl(Alt_Id3_length,0) Alt_Id3_length, nvl(Alt_Id4_length,0) Alt_Id4_length, nat_id_length, Accept_oth_alt_id_yn, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, accept_national_id_no_yn, nvl(nat_id_prompt,'National ID No') nat_id_prompt FROM mp_param, mp_alternate_id_type_lang_vw  alt_id1, mp_alternate_id_type_lang_vw  alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw  alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id='"+locale+"' and alt_id2.language_id='"+locale+"' and alt_id3.language_id='"+locale+"' and  alt_id4.language_id='"+locale+"'";
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,"+
				 "        NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,"+
				 "        NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,"+
				 "        NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,"+
				 "        alt_id1_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,"+
				 "        alt_id2_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,"+
				 "        alt_id3_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,"+
				 "        alt_id4_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,"+
				 "        NVL(alt_id1_length,0) alt_id1_length,"+
				 "        NVL(alt_id2_length,0) alt_id2_length,"+
				 "        NVL(alt_id3_length,0) alt_id3_length,"+
				 "        NVL(alt_id4_length,0) alt_id4_length,"+
				 "        nat_id_length,"+
				 "        accept_oth_alt_id_yn,"+
				 "        alt_id1_exp_date_accept_yn,"+
				 "        alt_id2_exp_date_accept_yn,"+
				 "        alt_id3_exp_date_accept_yn,"+
				 "        alt_id4_exp_date_accept_yn,"+
				 "        accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_alphanumeric_yn,"+
				 "        NVL(nat_id_prompt,'National ID No') nat_id_prompt,"+
				 "        nat_id_check_digit_id,nat_data_source_id,ext_system_interface_yn,biometric_authentication_yn"+
				 " FROM   mp_param_lang_vw"+
				 " WHERE  module_id = 'MP' and language_id='"+localeName+"'";

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs != null)
		{
			while(rs.next())
			{
				alt_id1_reqd_yn				= rs.getString("Alt_Id1_reqd_yn");
				alt_id2_reqd_yn				= rs.getString("Alt_Id2_reqd_yn");
				alt_id3_reqd_yn				= rs.getString("Alt_Id3_reqd_yn");
				alt_id4_reqd_yn				= rs.getString("Alt_Id4_reqd_yn");
				alt_id1_type				= rs.getString("Alt_Id1_type");
				alt_id2_type				= rs.getString("Alt_Id2_type");
				alt_id3_type				= rs.getString("Alt_Id3_type");
				alt_id4_type				= rs.getString("Alt_Id4_type");
				alt_id1_length				= rs.getString("Alt_Id1_length");
				alt_id2_length				= rs.getString("Alt_Id2_length");
				alt_id3_length				= rs.getString("Alt_Id3_length");
				alt_id4_length				= rs.getString("Alt_Id4_length");
				nat_id_length				= rs.getString("nat_id_length");
				alt_id1_exp_date_accept_yn	= rs.getString("alt_id1_exp_date_accept_yn");
				alt_id2_exp_date_accept_yn	= rs.getString("alt_id2_exp_date_accept_yn");
				alt_id3_exp_date_accept_yn	= rs.getString("alt_id3_exp_date_accept_yn");
				alt_id4_exp_date_accept_yn	= rs.getString("alt_id4_exp_date_accept_yn");
				accept_national_id_no_yn	= rs.getString("accept_national_id_no_yn");
				nat_id_accept_alphanumeric_yn	= rs.getString("nat_id_accept_alphanumeric_yn");
				nat_id_prompt 				= rs.getString("nat_id_prompt");
				nat_id_check_digit_id		= rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
				nat_data_source_id		= rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
				ext_system_interface_yn		= rs.getString("ext_system_interface_yn")==null?"":rs.getString("ext_system_interface_yn");
				alt_id1_desc 				= rs.getString("alt_id1_desc");
				alt_id2_desc 				= rs.getString("alt_id2_desc");
				alt_id3_desc 				= rs.getString("alt_id3_desc");
				alt_id4_desc 				= rs.getString("alt_id4_desc");
				Accept_oth_alt_id_yn 		= rs.getString("Accept_oth_alt_id_yn");
				alt_id1_accept_alphanumeric_yn 		= rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");
				biometric_authentication_yn 		= rs.getString("biometric_authentication_yn")==null?"N":rs.getString("biometric_authentication_yn");//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
				
			}
		}

		if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";
		if(alt_id2_exp_date_accept_yn == null) alt_id2_exp_date_accept_yn = "N";
		if(alt_id3_exp_date_accept_yn == null) alt_id3_exp_date_accept_yn = "N";
		if(alt_id4_exp_date_accept_yn == null) alt_id4_exp_date_accept_yn = "N";
		if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
		if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";
		if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N";
		if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";
		if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";
		if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";
		if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
		if(alt_id1_length == null) alt_id1_length = "0";
		if(alt_id2_length == null) alt_id2_length = "0";
		if(alt_id3_length == null) alt_id3_length = "0";
		if(alt_id4_length == null) alt_id4_length = "0";
		if(nat_id_length == null) nat_id_length = "0";
		if(nat_id_prompt == null) nat_id_prompt = "";
		if(nat_id_check_digit_id == null) nat_id_check_digit_id = "";
		if(alt_id1_type == null) alt_id1_type = "";
		if(alt_id2_type == null) alt_id2_type = "";
		if(alt_id3_type == null) alt_id3_type = "";
		if(alt_id4_type == null) alt_id4_type = "";
		if(alt_id1_desc == null) alt_id1_desc = "";
		if(alt_id2_desc == null) alt_id2_desc = "";
		if(alt_id3_desc == null) alt_id3_desc = "";
		if(alt_id4_desc == null) alt_id4_desc = "";
		
		
		if(hidetbl.equals("Y"))
		{
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
		if(accept_national_id_no_yn.equals("Y"))
			{
				/*
				if ( nat_id_check_digit_id.equals("M11") )
					nat_id_onKeyPress = " return CheckForCharsNatID(event);";
				else
					nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
				*/
				
				 if(nat_id_accept_alphanumeric_yn.equals("Y"))
				 {
					nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
				 }
				 else
				 {
					if(nat_id_check_digit_id.equals("M11"))
						nat_id_onKeyPress = "CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
				 }
				 String interface_btn = "";
				 if(ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC")) {
					 //Added id='M_btn2' by Ashwin K for AAKH-CRF-0150
					if(function_name.equals("01") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")))
					{
					interface_btn = "<input type='button' value='M' id='M_btn2' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"MButton_click_AddVisit()\">";
						
					interface_btn = interface_btn+" <input type='checkbox' id='AddVisit_EmiratesID_edit' name='AddVisit_EmiratesID_edit' id='AddVisit_EmiratesID_edit'  >";
					 }
					else if(function_name.equals("05") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")))
					{//Added  by santhosh for TH-KW-CRF-0019.1
					interface_btn = "<input type='button' value='M' id='M_btn2' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"MButton_click_OPRegVisit()\">";
						
					 }
					 else if(function_name.equals("07")) {
						 interface_btn = "";
					 }
					 else
					 {
						interface_btn = "<input type='button' value='M'  class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"ReadDF2_onclick('CC','NC');\">";
					 }
					// Ended By Ashwin K for AAKH-CRF-0150 
				 } else {
					 interface_btn = "";
				 }
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(function_name.equals("01")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
 if(function_name.equals("01") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")) ){ 
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( nat_id_length ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(interface_btn));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			else
			{
				
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Accept_oth_alt_id_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);

			if(Accept_oth_alt_id_yn.equals("Y"))
			{
				
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

				sql = "SELECT alt_id_type,long_desc FROM mp_alternate_id_type_lang_vw   WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM) and EFF_STATUS='E' and language_id='"+locale+"' ORDER BY SHORT_DESC";
			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();	
		
				if(rs != null)
				{
					while(rs.next())
					{
						
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs.getString("alt_id_type")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString("long_desc")));
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
				}
				
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alert_reqd_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mr_transaction));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
			else if(!Accept_oth_alt_id_yn.equals("Y") && mr_transaction.equals("Y"))
			{
				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(mr_transaction));
            _bw.write(_wl_block38Bytes, _wl_block38);

			}
			else 
			{
				
            _bw.write(_wl_block39Bytes, _wl_block39);

			} 
			
            _bw.write(_wl_block40Bytes, _wl_block40);

			if(!alt_id1_type.equals(""))
			{
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(validateIDFn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alt_id1_reqd_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
			else
			{
				
            _bw.write(_wl_block50Bytes, _wl_block50);

			}
			
			if(!alt_id2_type.equals(""))
			{
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(alt_id2_reqd_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block55Bytes, _wl_block55);

			}
			else
			{
				
            _bw.write(_wl_block56Bytes, _wl_block56);

			}
			
            _bw.write(_wl_block57Bytes, _wl_block57);

			if(!alt_id3_type.equals(""))
			{
				
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(alt_id3_reqd_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block55Bytes, _wl_block55);

			}
			else
			{
				
            _bw.write(_wl_block56Bytes, _wl_block56);

			}
		
			if(!alt_id4_type.equals(""))
			{
				
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disabledFields));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alt_id4_reqd_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
			else
			{
				
            _bw.write(_wl_block66Bytes, _wl_block66);

			}
			
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Smartcard_path));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(biometric_authentication_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) 
	{ 
		out.println(e.toString());
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block71Bytes, _wl_block71);
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
}
