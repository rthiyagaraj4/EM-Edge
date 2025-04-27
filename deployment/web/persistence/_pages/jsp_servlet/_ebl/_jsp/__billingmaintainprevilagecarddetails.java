package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.resources.*;
import eCommon.Common.*;
import eBL.BillingPrevilageCardPatientBean;
import eBL.BillingPrevilageCardMemberBean;
import eBL.BillingPrevilageCardVisiiUtilizationBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billingmaintainprevilagecarddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingMaintainPrevilageCardDetails.jsp", 1709114364213L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n    <!--<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> -->\n        <script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\" ></script>\t\t\n\n        \n        <script language =\"javaScript\"    src =\'../../eCommon/js/CommonLookup.js\'></Script>\t\n\t\t<script language=\"javascript\"     src=\"../../eCommon/js/ValidateControl.js\"></script> \n\t\t<script language=\'javascript\'     src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\n\t \t<script language=\"javascript\" src=\"../../eBL/js/BLPatientEncounters.js\"></script> \t\n\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/BillingMainatainPrevilageCard.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t\t\n\t  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eBL/html/ui.dropdownchecklist.css\" />\n         <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eBL/html/main.css\" />\n    \n\n      \n  \n\t\n</head>\n<BODY onLoad=\"  \"  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\" >\n\n <FORM method=\'post\' name=\"BillingMaintainPrevilageCardDetails\" id=\"BillingMaintainPrevilageCardDetails\"  id=\"BillingMaintainPrevilageCardDetails\"  action=\"\" onsubmit=\"return funQry()\">\n\n   \t\t<table class=\'grid\' width=\'100%\' id=\"pkgSubs_tabId\" name=\"pkgSubs_tabId\" id=\"pkgSubs_tabId\" >\n\t\t\t<tr>\n\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'4\' ><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b><b></td>\n\t\t\t</tr>\n\t\t</table>\n\n   <br/>\n  \n    \n   <table align=\'center\' border=\'1\' cellpadding=3 cellspacing=0  width=\'100%\'> \n\n\t\t <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th> \n\t     <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th> \n\t\t <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\t\t\t\t <th class=\'CAFLOWSHEETLEVEL1\'  width=\"1%\"  align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t\n         <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\t\n\t\t <th class=\'CAFLOWSHEETLEVEL1\' \twidth=\"1%\"\talign=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\t\n\t</table>\t\t \n<div id=\"card_type_div\" name=\"card_type_div\" style=\"width:100%; height:145px; overflow: auto;\">\t\t \n\t<table align=\'center\' border=\'0\' cellpadding=3 cellspacing=0  width=\'100%\' id=\"primary_patient_table\" name=\"primary_patient_table\" id=\"primary_patient_table\">\t \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n    \t <tr onclick=\"ShowCardsubsciptionDetails(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\">\n\t\t\t  <td class=\"fields\" width=\"1%\"><input type=\"text\"  \tname=\"primary_patientId";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"primary_patientId";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" \t\t\tid=\"primary_patientId";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\t\t  \t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\tsize=\"15\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' \tonKeyPress=\'changeToUpper()\' \tonBlur=\"\" \talign=\"left\"></td>\n\t\t     <td class=\"fields\" width=\"1%\"><input type=\"text\"  \tname=\"card_type";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"card_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" \t\t\tid=\"card_type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\tsize=\"25\" \tmaxlength=\'20\' \tvalue=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' \tonKeyPress=\'changeToUpper()\' \tonBlur=\"\" \talign=\"left\"></td>\n\t\t          <td class=\"fields\" width=\"1%\"><select style=\"width: 180px;\" id=\"price_class_Code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"price_class_Code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onChange=\"showAlert(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',this);\">\n\t\t              ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t              <option title=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" - ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" > ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </option>\n\t\t              ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t     \t\t\t\t\t\t\t\t</select></td>         \n\t\t\t <td class=\"fields\" width=\"1%\"><input type=\'text\' \tname=\"from_date";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"from_date";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" \t\t\tid=\"from_date";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\tsize=\"27\" \tmaxlength=\'12\' \tvalue=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  \tonKeyPress=\'ChkNumberInput()\' \tonBlur=\"\"\talign=\"left\"></td> \n\t\t\t <td class=\"fields\" width=\"1%\"><input type=\'text\' \tname=\"to_date";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"to_date";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" \t\t\tid=\"to_date";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'  \tonKeyPress=\'ChkNumberInput()\' \tonBlur=\"\"\talign=\"left\"></td> \n\t\t\t <td class=\"fields\" width=\"1%\"><input type=\'text\' \tname=\"memeber_fees";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"memeber_fees";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" \t\tid=\"memeber_fees";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'  \tonKeyPress=\'ChkNumberInput()\' \tonBlur=\"\"\talign=\"left\">\n\t\t\t\t <input type=\'button\' class= \'button\' name =\'Print";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  value=\'Print\'  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" onclick=\"printPrevilageCardReport(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\')\" >\n\t\t\t\t </td>\n\t\t\t \t\t\t\t\t <input type=\"hidden\"  \tname=\"hcardseqno";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"hcardseqno";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" \t\tid=\"hcardseqno";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'\t\t\t\t\t\t\t\t\t\t\t\t/>\n\t\t\t \t\t\t\t\t <input type=\"hidden\"  \tname=\"card_type_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"card_type_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" \tid=\"card_type_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'\t\t\t\t\t\t\t\t\t\t\t\t/>\n\t\t\t \t\t\t\t\t <input type=\'hidden\' \tname=\'packageCode";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'packageCode";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' \t\tid=\'packageCode";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"\t\t\t\t\t\t\t\t\t\t\t\t/>\n\t\t\t \t\t\t\t\t <input type=\'hidden\' \tname=\'billingServiceCode";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'billingServiceCode";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\t\t\t\t\t\t\t\t\t\t\t\t/>\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t<script>\n\tvar hiddenPatientId =\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\tShowCardsubsciptionDetails(hiddenPatientId,\"0\");\n\t</script>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\n<script>\n\talert(getMessage(\"BL9132\",\"BL\"));\n</script>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\n    </table>\t\n    \n</div>    \n<br/>\n    \n  \n  \t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' \t\t\t\t \tid=\'locale\'  \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\t \t     \tid=\'facilityId\'  \t\t\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' \t\t\t\t \tid=\'mode\' \t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t\t<input type=\'hidden\' name=\'authorized\' id=\'authorized\'\t\t\t \tid=\'authorized\'  \t\t\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" /> \n\t\t<input type=\'hidden\' name=\'isUserCanAcess\' id=\'isUserCanAcess\'\t\t \tid=\'isUserCanAcess\' \t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" />\n\t\t<input type=\'hidden\' name=\'hiddenCardTypeCode\' id=\'hiddenCardTypeCode\' \t \tid=\'hiddenCardTypeCode\'\t\tvalue=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPatientId\' id=\'hiddenPatientId\' \t \tid=\'hiddenPatientId\'\t\tvalue=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPriceClassCode\' id=\'hiddenPriceClassCode\' \tid=\'hiddenPriceClasscode\'\tvalue=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\'hidden\' name=\'hiddenPriceClassDesc\' id=\'hiddenPriceClassDesc\' \tid=\'hiddenPriceClassDesc\'\tvalue=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\'\t\t\t \tid=\'rowCount\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\'hidden\' name=\'primaryPatientId\' id=\'primaryPatientId\' \t \tid=\'primaryPatientId\'\t\tvalue=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\n\t\t\n\t\t\n   \t</form>\n</body>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n</html>\n\n";
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

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode														=	new String();
String locale															=	"";
String facilityId														=	"";
String hiddenPatientId													=	"";
String patientDetails													=	"";
String mode																=	"";
String isUserCanAcess													=	"";
String sStyle 															=	"";
String authorized 														=	"";
String bean_id															=	"";
String bean_name														=	"";
String bean_id1															=	"";
String bean_name1														=	"";
String bean_id2															=	"";
String bean_name2														=	"";
String hiddenPriceClasscode												=	"";
String hiddenPriceClassDesc												=	"";
String hiddenCardTypeCode												=	"";
String billingServiceCode												=	"";
String rowCount															=	"";
ArrayList<String[]> PatientDetailsList									=	null;
ArrayList<String[]> visitUtilizationDetailsList							=	null;
ArrayList			 PrevilageCardList									=	null;
String cardIndex														=	null;
String readonly															=	"DISABLED";
String disableMode														=	"DISABLED";
ArrayList<String[]> priceClassCodeAndDescList							= 	null;
String selected 														=	"SELECTED";
String disablePrint														=	"DISABLED";


try
{
	
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	mode																					=	(String)session.getAttribute("maintainMode");
	mode																					=	checkForNull(mode);
	PrevilageCardList																		= 	new ArrayList(); 
	priceClassCodeAndDescList																=	new ArrayList();
	hiddenPatientId																			=	checkForNull(request.getParameter("patientId"));
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	authorized 																				=	(String)session.getAttribute("authorized");
	 System.out.println("mode::::: "+mode+" ::authorized::: "+authorized);
	 if(mode.equalsIgnoreCase("modify") && authorized.equalsIgnoreCase("Y"))
	{
		 readonly ="READONLY";
		 disablePrint="";
	}
	 else
	 {
		 readonly ="DISABLED";
		 disablePrint="DISABLED";
	 }
	 System.out.println("mode::::: "+mode);
	  disableMode ="DISABLED";
//	System.out.println("hiddenPatientId::BillingMaintainPrevilageCardDetails.jsp::::: "+hiddenPatientId);
//	System.out.println("disableMode::::: "+disableMode);
	


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPatientDetails(hiddenPatientId, facilityId, locale)));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

PrevilageCardList = billingPrevilageCardPatientBean.getBillingPrevilageCardPatient(hiddenPatientId,facilityId,locale);
if(PrevilageCardList.size()>0)
{
for(int index=0;index<PrevilageCardList.size();index++)
{
	billingPrevilageCardPatientBean = (BillingPrevilageCardPatientBean)PrevilageCardList.get(index);
	priceClassCodeAndDescList		= billingPrevilageCardPatientBean.getPriceClassCodeAndDescList();
	
	for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
	{
		System.out.println("priceClassCodeAndDescList::::::::: "+priceClassCodeAndDescList.get(priceListIndex)[0]+" - "+priceClassCodeAndDescList.get(priceListIndex)[1]);
	}


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(hiddenPatientId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrimaryPatientId()				!=null ? billingPrevilageCardPatientBean.getPrimaryPatientId() 			: "" ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrevilageCardType()				!=null ? billingPrevilageCardPatientBean.getPrevilageCardType() 			: "" ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode() ));
            _bw.write(_wl_block31Bytes, _wl_block31);

		              for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
		          		{
		            	  
		              
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[1]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[0]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( priceClassCodeAndDescList.get(priceListIndex)[0].equalsIgnoreCase(billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode()) ? "SELECTED" : "" ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priceClassCodeAndDescList.get(priceListIndex)[1]));
            _bw.write(_wl_block37Bytes, _wl_block37);

		          		}
		              
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrevilageCardFromDate()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardFromDate() 		: "" ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(index));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrevilageCardToDate()				!=null ? billingPrevilageCardPatientBean.getPrevilageCardToDate() 			: "" ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disableMode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrevilageCardMemberFees()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardMemberFees() 		: "" ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disablePrint));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(index));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getHcardSeqNo()						!=null ? billingPrevilageCardPatientBean.getHcardSeqNo()					: "" ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPrevilageCardTypeCode()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardTypeCode()			: "" ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(index));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getPackageCode()						!=null ? billingPrevilageCardPatientBean.getPackageCode()					: "" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(index));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( billingPrevilageCardPatientBean.getBillingServiceCode()				!=null ? billingPrevilageCardPatientBean.getBillingServiceCode()			: "" ));
            _bw.write(_wl_block68Bytes, _wl_block68);

if(index==0)
{
	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(hiddenPatientId));
            _bw.write(_wl_block70Bytes, _wl_block70);
	}
}
}
else
{

            _bw.write(_wl_block71Bytes, _wl_block71);

}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(authorized));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(isUserCanAcess));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(hiddenCardTypeCode));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(hiddenPatientId));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(hiddenPriceClasscode));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(hiddenPriceClassDesc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(checkForNull(billingPrevilageCardPatientBean.getPrimaryPatientId())));
            _bw.write(_wl_block83Bytes, _wl_block83);

putObjectInBean(bean_id, billingPrevilageCardPatientBean, request);
}
catch(Exception e)
{
	System.out.println("Exception in BillingMaintainPrevilageCardPatientDetails.jsp.jsp::"+e);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PrimaryPatientID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CARD_TYPE.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRICE_CLASS.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MEMBER_SHIP_FEES.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
