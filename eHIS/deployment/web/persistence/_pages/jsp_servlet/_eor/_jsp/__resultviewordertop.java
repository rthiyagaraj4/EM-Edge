package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __resultviewordertop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultViewOrderTop.jsp", 1709120000000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" <!-- 35142 added -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!--<Script>alert(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')</Script>-->\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=center >\n\t<tr>\n\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'data\'><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B>\n\t\t<!-- 31792 starts -->\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<input type=\'image\' src=\'../../eCA/images/MotherBlood.png\' onClick=\"NeonatalMotherSpecimenDetails(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"/></td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<!-- 31792 starts -->\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'data\'> <B>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</B></td>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\t\n\t\t<td class=\'data\'> <B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t<td class=\'data\' ><B>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td class=\'data\' nowrap><B> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td><!-- IN058811 New Label-->\n\t\t<td class=\'data\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></td> <!-- IN058811 New Label -->\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td><!-- IN058811 changed order-->\n\t\t<td class=\'data\' nowrap><B>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</B></td><!-- IN058811 changed order-->\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td><!-- IN058811 changed order-->\n\t\t<td class=\'data\'><B>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</B></td><!-- IN058811 changed order-->\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<tr>\n\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td class=\'data\'  >  <a class=\"gridLink\" href=\"javascript:viewOrderFormat(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</a> </td>\n\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td><!-- IN058811 changed order-->\n\t\t<td class=\'data\'> <B>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </B></td><!-- IN058811 changed order-->\n\n\t\t\n\t</tr>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<TD class=\'data\'  title=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><B>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</B></TD>\n\t\t<td  class=\'label\' >\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<a class=\"gridLink\" href=\"javascript:viewHeaderComments(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</a>  \n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t</td>\n\t\t<td></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<TD class=\'data\'><B>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</B></TD>\n\t\t<!-- IN058811 starts changed order-->\n\n\t\t <td class=\"label\"></td>\n\t\t<!-- IN058811 Ends changed order-->\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</TD>\n\t\t\t<TD class=\'data\'><B>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</B></TD>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</TD><!-- IN058811 changed order-->\n\t\t\t<TD class=\'data\'><B>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</B></TD><!-- IN058811 changed order-->\n\t\t\t<!-- <TD>&nbsp;</TD> -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td class=\'data\' ><b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</b></td>\n\t\t\t\t<td  class=\'label\' >\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<TD class=\'label\' colspan=\'2\'></TD>\n\t\t\t<td  class=\'label\' >\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t</tr>\n\t<!-- IN066453 Starts -->\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\n\t\t<tr>\n\t\t\t<TD class=\'label\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</TD>\n\t\t\t<td class=\'data\'><B>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</B></td>\n\t\t\t<TD class=\'label\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</B></td>\n\t\t\t</tr><tr><!-- 7632 -->\n\t\t\t<TD class=\'label\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</B></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t<!-- IN066453 ends -->\n\t\n\t<!-- 35142 Starts. -->\n\t\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t<tr>\n\t\t<td class=label></td>\n\t\t<td class=fields></td>\t\n\t\t<td class=label>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t<td class=fields><input id=\'quePkiId\' name=\'quePkiId\' id=\'quePkiId\' type=text size=\"25\" value=\'\' onBlur=\"getQUEPKICode(this)\"></td>\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=label></td>\n\t\t<td class=fields></td>\t\n\t\t<td class=label colspan=2 id=\"quePkiIdMessage\">&nbsp;</td>\n\t\t\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" \n\t<input type=hidden id=\"pkiSiteSpecificYN\" name=\"pkiSiteSpecificYN\" id=\"pkiSiteSpecificYN\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\n\t<input type=hidden id=\"quePkiStatus\" name=\"quePkiStatus\" id=\"quePkiStatus\" value=\"E\"/>\n\t<input type=hidden id=\"quePkiStatusText\" name=\"quePkiStatusText\" id=\"quePkiStatusText\" value=\"User missed entering primary key of queue no\"/>\t\n\t<input type=hidden id=\"quePkiToken\" name=\"quePkiToken\" id=\"quePkiToken\" value=\"\"/>\n\t<input type=hidden id=\"quePkiNumber\" name=\"quePkiNumber\" id=\"quePkiNumber\" value=\"\"/>\n\t<input type=hidden id=\"quePkiIsueDateTime\" name=\"quePkiIsueDateTime\" id=\"quePkiIsueDateTime\" value=\"\"/>\n\t<input type=hidden id=\"quePkiCallDateTime\" name=\"quePkiCallDateTime\" id=\"quePkiCallDateTime\" value=\"\"/>\t\n\t\n\t<input type=hidden id=\"ordFacilityId\" name=\"ordFacilityId\" id=\"ordFacilityId\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n\t<input type=hidden id=\"patientId\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"/>\n\t<input type=hidden id=\"encounterId\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n\t<input type=hidden id=\"referenceId\" name=\"referenceId\" id=\"referenceId\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"/>\n\t<input type=hidden id=\"userId\" name=\"userId\" id=\"userId\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n\t<!-- 31792 starts -->\n\t<input type=hidden id=\"order_id\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"/>\n\t<input type=hidden id=\"order_category\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n\t<input type=hidden id=\"performing_facility_id\" name=\"performing_facility_id\" id=\"performing_facility_id\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"/>\n\t<input type=hidden id=\"accession_num\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"/>\n\t<input type=hidden id=\"patient_id\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"/>\n\t<!-- 31792 ends -->\n\n\t<!-- 35142 end. -->\n\t\t\t\n</table>\n<!--INO30714 <Input name=\'querystring\' id=\'querystring\' type=\'hidden\' value=\'orderId=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&order_line_num=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="&cont_order_ind=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&patient_id=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&ord_cat=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&practitioner_id=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="&timeHeader=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&order_status=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&pract_reln_id=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>INO30714 -->\n<!--IN064215 start-->\n<!--<Input name=\'querystring\' id=\'querystring\' type=\'hidden\' value=\'orderId=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="&encounter_id=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>--><!--INO30714 -->\n\n<!--<Input name=\'querystring\' id=\'querystring\' type=\'hidden\' value=\'orderId=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="&view_by=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>-->\n<!--IN064215 end-->\n<Input name=\'querystring\' id=\'querystring\' type=\'hidden\' value=\'orderId=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&event_code=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="&order_catalog_code=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'><!-- IN061961 -->\n<Input type=\'hidden\' name=\'orderFormatAuditTrailYN\' id=\'orderFormatAuditTrailYN\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'> <!--  IN056017 -->\n<Script>\nif((screen.width==800) && (screen.height==600))\n{\n\t\tvar colsfordetail=querystring.value\n\t\tcolsfordetail+=\"&cols=74\";\n\t\tquerystring.value=colsfordetail;\n}\nelse\n{\n\t\tvar colsfordetail=querystring.value\n\t\tcolsfordetail+=\"&cols=300\";\n\t\tquerystring.value=colsfordetail;\n\t\n}\n\t//parent.ViewOrderHeader.location.href = \"../../eOR/jsp/ResultViewOrderHeader.jsp\";\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\tparent.ViewOrderDtl.location.href = \"../../eOR/jsp/MedPntredit.jsp?called_from=RESULT_VIEW&order_id=";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&bean_id=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&bean_name";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="  // if image is not there call this one \n\n\t\tparent.ViewOrderDtl.location.href = \"../../eOR/jsp/ResultViewOrderDetail.jsp?\"+querystring.value;\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n</Script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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

/*
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100         	?            	created
27/01/2012	  	INO30714		Menaka V	 	THAI screen>View Clinical Event History>View>In the Recorded Clinical
												Note the name is not displayed in THAI 
22/02/2013	   	IN036821		Chowminya G	 	Reporting Practitioner name not coming in the CA report										 
08/05/2013	    IN029323		NijithaS    	System displays External order details as "null" and unable to Record the Result for that order.
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
10/04/2014		IN048449		Karthi L										Alpha-OR-Wrong date format displayed at Results window when application Switched to Thai language
22/06/2015 		IN056017		Nijitha S										Alpha-OR-Existing Orders-System throws script error in Result window for order format item.
09/5/2016		IN058811		Raja S			10/05/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 	Order Categories) is a national requirement.
23/08/2016		IN061345		Ramesh G										Not able to view the lab reports through clinician access.
10/05/2017		IN064215		Krishna Gowtham J 10/05/2017	Ramesh G		PMG2017-SH-CRF-0001		
18/07/2018              IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
4/02/2019               IN066453                Ramya Maddena   6/02/2019       Ramesh G		ML-BRU-CRF-0491
18/09/2020		IN074069			Sivabagyam M		18/09/2020		Ramesh G			SKR-SCF-1437
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
04/10/2022     35142            Twinkle Shah                                     TH-KW-CRF-0020.6
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

System.out.println("----------------->ResultViewOrderTop.jsp");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String viewBean_id = "Or_ViewOrder";
	String viewBean_name = "eOR.ViewOrder";
	//String priority="";
	String orderId = request.getParameter("orderId");
	String facility_id = (String)session.getValue("facility_id");
	//String[] allValues = new String[40];//IN066453
	//String[] allValues = new String[44];//added for 7632
	String[] allValues = new String[45];//added for 7632//31792
	String location="";
	String patient_details="";
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");	
	
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name , request) ;
	String  orderFormatAuditTrailYN= bean.getOrderFormatAuditTrailYN();  //IN056017
	bean.setLanguageId(localeName);

	/*****Added by Deepa on 11/4/2009 at 2:55 PM for IN011473*****************/
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String resp_id = (String) session.getAttribute("responsibility_id") == null ? "" : (String) session.getAttribute("responsibility_id");
	String userid = (String)session.getAttribute("login_user") == null ? "" : (String)session.getAttribute("login_user"); //35142
	String repPract = "";
	String repPractName = "";
	ViewOrder vwBean = (ViewOrder) getBeanObject( viewBean_id, viewBean_name,request ) ;
	vwBean.setLanguageId(localeName);	

	//String view_bean_id = "Or_ViewOrder" ;
	//String view_bean_name = "eOR.ViewOrder";
	//ViewOrder view_bean = (ViewOrder)getBeanObject( view_bean_id, view_bean_name , request) ;
	// From the View Order get the clinical comments if it is there
	//view_bean.setLanguageId(localeName);	
 	String ca_pract_name		=  "";
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	bean.clear() ;
	bean.setMode( mode ) ;
 	allValues		= bean.viewMainDetails(orderId);
	String [] print_details = {"","","","","","",""};
    print_details = (String[])bean.getOrderDetails(orderId);

	// Query to found to call the image file or the result file
	//String image_ref_yn = view_bean.getImageRefYn(orderId);
		
	//out.println("image_ref_yn="+image_ref_yn);
	String order_type_code = bean.checkForNull(allValues[39]);
    String order_status    = print_details[6];
    String reportingTime   = "";
    String specimenCollectedTime   = "";
	String view_by = request.getParameter("view_by"); //IN064215
	String lv_neonate_spec_yn = "";//31792
	lv_neonate_spec_yn = allValues[45];//31792
	System.out.println("------------lv_neonate_spec_yn------->"+lv_neonate_spec_yn);
	/*ADDED BY Deepa */
/*
	ArrayList repPractList = new ArrayList();
	String textToolTip = "";
	try
	{
		repPractList = (ArrayList) vwBean.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
	
		if(repPractList.size() > 0)
		{
			repPract = (String) repPractList.get(0);	
			repPractName = (String) vwBean.getRepPractName(repPract, localeName);

			if(repPractList.size() == 1) 
			{
				repPractName = repPractName;
				textToolTip = "";
			}
			else 
			{
				repPractName = repPractName + " * ";
				textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
			}
		}
	}
	catch(Exception ee)
	{
		System.out.println("Exception in ResultViewOrderTop.jsp -"+ee.toString());
		ee.printStackTrace(System.err);
	}
	*/
	/*ADDED BY Deepa */
          
	
	//35142 Start.
	String fromFunction=request.getParameter("fromFunction") == null ? "" : request.getParameter("fromFunction");
	bean.setSiteSpecificYN("QUE_PKI_APPLIC_ORDER_TRACKING");
	boolean  quePki_SiteSpecific =bean.isSiteSpecific("QUE_PKI_APPLIC_ORDER_TRACKING");
	bean.setSiteSpecificYN("NEONATAL_MOTHER_SPECIMEN");
	boolean  isSiteSpecificNeonatalMotherSpecimen =bean.isSiteSpecific("NEONATAL_MOTHER_SPECIMEN");
	System.out.println("------------isSiteSpecificNeonatalMotherSpecimen------->"+isSiteSpecificNeonatalMotherSpecimen);
	String  pkiSiteSpecificYN="N";
	//35142 End.
	
	//String max_action_seq_num	= bean.checkForNull(view_bean.getMaxCount(orderId),"");
	String max_action_seq_num	= allValues[29];
	String image_ref_yn=allValues[31];
	if(image_ref_yn==null) image_ref_yn="N";
	ArrayList practitionerDetails = new ArrayList();
	practitionerDetails = bean.getPractitionerDetails(orderId,cont_order_ind,facility_id,request.getParameter("ord_cat"),order_type_code);
	int timeHeader = 0;
	if (practitionerDetails.size() == 2) timeHeader = 1;

	if(allValues!=null && orderId!=null) 
	{
		//ca_pract_name		= bean.checkForNull(view_bean.getOrderPractitioner(orderId),"");
		ca_pract_name		= allValues[30];
	}
	if(ca_pract_name==null)	ca_pract_name = "";

	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals("") )
	{
		allValues[2]="R";
	}
		 
	  if(allValues[2].compareTo("R")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	}
	else if(allValues[2].compareTo("U")==0)
	{						  
	
	    allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	}
	else if(allValues[2].compareTo("S")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
	}	
	

	String sex1="";
	
	if (allValues[3].equalsIgnoreCase("M"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(allValues[3].equalsIgnoreCase("F"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

	if(allValues[36].equalsIgnoreCase("C"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
	//IN029323 Starts
	if(null==allValues[4])
		allValues[4]="";
	//IN029323 Ends
	patient_details=allValues[6]+","+sex1+"/"+allValues[34]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[35];
	//out.println(allValues.length);
//out.println("<script>alert('ca_pract_name="+ca_pract_name+"');</script>");
	

            _bw.write(_wl_block10Bytes, _wl_block10);
//=practitionerDetails.size()
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block13Bytes, _wl_block13);
 if (isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(allValues[32] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(allValues[15] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(allValues[44] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(allValues[41] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(allValues[35] ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(allValues[41] ));
            _bw.write(_wl_block16Bytes, _wl_block16);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(allValues[0]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(allValues[1]));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allValues[2]));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(allValues[4]));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(allValues[12],"DMYHM","en",localeName)));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((allValues[40]== null)? "" :allValues[40]));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(location));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(allValues[38]));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(allValues[5]));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(allValues[8]));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(allValues[7]));
            _bw.write(_wl_block31Bytes, _wl_block31);

		if(allValues[10] == null) allValues[10] = "";
		// added for IN048449 - Start
		String	converted_date="";	 
		String	format_date="";
		int date_part=allValues[10].indexOf("/");
		if(date_part!=-1)
		{
			if((date_part+14)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+14).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+14);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMYHM",localeName))
				{
					 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMYHM","en",localeName);
					 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
			else if((date_part+8)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+8).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+8);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMY",localeName))
				{
						 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMY","en",localeName);
						 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
		}
		 if ((practitionerDetails.size() == 1) ) //IN036821
			//IN061345 End.
			{
				//IN061345 Start.
				ArrayList repPractList = new ArrayList();
				String textToolTip = "";
				try
				{
					repPractList = (ArrayList) vwBean.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
				
					if(repPractList.size() > 0)
					{
						repPract = (String) repPractList.get(0);	
						repPractName = (String) vwBean.getRepPractName(repPract, localeName);

						if(repPractList.size() == 1) 
						{
							repPractName = repPractName;
							textToolTip = "";
						}
						else 
						{
							repPractName = repPractName + " * ";
							textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
						}
					}
				}
				catch(Exception ee)
				{
					System.out.println("Exception in ResultViewOrderTop.jsp -"+ee.toString());
					ee.printStackTrace(System.err);
				}
		// added for IN048449 - End
	
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(allValues[10]));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allValues[9]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block38Bytes, _wl_block38);

		//if(!order_line_num.equals("")){
		
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(textToolTip));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(repPractName));
            _bw.write(_wl_block42Bytes, _wl_block42);
 if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		} 
		else 
		{ 		   
			out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"");
		} 
		
            _bw.write(_wl_block45Bytes, _wl_block45);

		if (practitionerDetails.size() == 3) 
		{
			/*Added by Uma on 12/1/2010 for IN025168*/
			specimenCollectedTime = (String)practitionerDetails.get(1);
			specimenCollectedTime =  com.ehis.util.DateUtils.convertDate(specimenCollectedTime,"DMYHM","en",localeName);
			reportingTime		  = (String)practitionerDetails.get(2);
			reportingTime		 =  com.ehis.util.DateUtils.convertDate(reportingTime,"DMYHM","en",localeName);
			/*Ends Here*/
		
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( practitionerDetails.get(0)== null ? "" :(String)practitionerDetails.get(0)));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(reportingTime));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(specimenCollectedTime));
            _bw.write(_wl_block51Bytes, _wl_block51);

		}
		// IN061345 Start.
		//else if ((practitionerDetails.size() == 1) || !repPractName.equals("")) //IN036821
		//IN061345 End.			
		
            _bw.write(_wl_block52Bytes, _wl_block52);

		}
		else if(ca_pract_name!=null && !ca_pract_name.equals("")) 
		{
		
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ca_pract_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
 if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		} 
		else 
		{ 		   
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")); 
		} 
		
            _bw.write(_wl_block56Bytes, _wl_block56);

		}
		else
		{
		
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		} 
		else 
		{ 		   
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")); 
		} 
		
            _bw.write(_wl_block56Bytes, _wl_block56);

		}
		//}
		

		
            _bw.write(_wl_block58Bytes, _wl_block58);
if(allValues[15].equals("LB")){
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((allValues[41]== null)? "" :allValues[41]));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((allValues[42]== null)? "" :allValues[42]));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((allValues[43]== null)? "" :allValues[43]));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
if (quePki_SiteSpecific && "ORDER_TRACKING".equals(fromFunction) && "RD".equals(allValues[15])) {
	pkiSiteSpecificYN="Y";	
	
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(pkiSiteSpecificYN));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allValues[13]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(allValues[35]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(allValues[4]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(allValues[32]));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(allValues[15]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(allValues[9]));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allValues[41]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(allValues[35]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(request.getParameter("orderId")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(request.getParameter("order_line_num")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(request.getParameter("ord_cat")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allValues[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(timeHeader));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("pract_reln_id")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(request.getParameter("orderId")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(request.getParameter("order_line_num")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(request.getParameter("ord_cat")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allValues[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(timeHeader));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("pract_reln_id")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(allValues[4]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(request.getParameter("orderId")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(request.getParameter("order_line_num")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(request.getParameter("ord_cat")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allValues[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(timeHeader));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("pract_reln_id")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(allValues[4]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(request.getParameter("view_by")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(request.getParameter("orderId")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(request.getParameter("order_line_num")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(request.getParameter("ord_cat")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(allValues[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(timeHeader));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("pract_reln_id")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(allValues[4]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(request.getParameter("view_by")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(request.getParameter("event_code")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(request.getParameter("order_catalog_code")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(orderFormatAuditTrailYN));
            _bw.write(_wl_block95Bytes, _wl_block95);
  
	if(image_ref_yn.equals("Y")) 
	{ 

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block99Bytes, _wl_block99);
  
	}	
	else 
	{ 
		
	
            _bw.write(_wl_block100Bytes, _wl_block100);
	
	} 
	
            _bw.write(_wl_block101Bytes, _wl_block101);
 
	putObjectInBean(bean_id,bean,request);
	//putObjectInBean( view_bean_id, view_bean , request) ;

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderCategory.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDateTime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NationalId.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderStatus.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingFacility.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderFormat.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingFacility.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingPractitioner.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReportingTime.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SpecimenCollectedTime.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderPlacedBy.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SpecimenNo.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CategoryNo.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SpecimenType.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.QuePkiCode.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
