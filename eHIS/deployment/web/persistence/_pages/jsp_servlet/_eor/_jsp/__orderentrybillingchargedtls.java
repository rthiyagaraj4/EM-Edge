package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __orderentrybillingchargedtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryBillingChargeDtls.jsp", 1737434872000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n14/09/2012    IN034785      Chowminya G     Incident No: IN034785 <In the multi-facility scenario -  Charge details display> \n19/10/2017\tIN065324\t\tDinesh T\t\tTo display the price in OR screen and the billing status in Manage Specimen screen\n05/02/2020\tIN068314\tNijitha S\t05/02/2020\tRamesh G\tML-MMOH-CRF-1229\n--------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrderBillingChargeDtls.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- for Tool Tip-->\n\t\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"billing_details\" id=\"billing_details\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table cellpadding=3 cellspacing=0 border=1 width=\'100%\' id=\'detailTab\' align=\'center\' class=\"grid\">\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'16%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'16%\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n \t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' width=\'15%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'16%\' style=\'text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'actual_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span></font></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' width=\'15%\' style=\'text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'payable_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' width=\'15%\' style=\'text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'paid_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span></font></td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  width=\'15%\' style=\'text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'included_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</span></font></td>\n\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  width=\'15%\' style=\'text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'approved_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' width=\'16%\' style=\'text-align: center;\' nowrap><FONT SIZE=\"1\" ><a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'EXIST_ORDER\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\" title=\'Charge Details\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</a></FONT></td> <!--Added ord_fac_id for [IN034785] -->\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\n\t\t\t\t\t\n\t\t\t<input type=hidden name=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=hidden name=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=hidden name=\'ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=hidden name=\'ord_appr_by_user_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'ord_appr_by_user_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=hidden name=\'ord_consent_reqd_yn";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'ord_consent_reqd_yn";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=hidden name=\'ord_consent_by_id";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'ord_consent_by_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=hidden name=\'order_line_num";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'order_line_num";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t<input type=hidden name=\'order_id";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'order_id";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t<input type=hidden name=\'order_catalog_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'order_catalog_code";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t<input type=hidden name=\'order_catalog_desc";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'order_catalog_desc";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t<input type=hidden name=\'order_qty";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'order_qty";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t<input type=hidden name=\'start_date_time";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'start_date_time";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t\t<input type=hidden name=\'order_set_bill_yn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'order_set_bill_yn";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t<input type=hidden name=\'billing_call_yn";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'billing_call_yn";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\n\t\t\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' width=\'\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t<td colspan=\"7\">\n\t\t\t\t\t\t <table class=\"grid\" width=\"100%\" cellpadding=3 cellspacing=0>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t <td class=\'columnheader\' width=\'\' nowrap >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t  <tr>\n\t\t\t\t\t\t <td class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t <td class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));window.close();</script> \n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n</table>\n\n<input type=hidden name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n<input type=hidden name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n<input type=\"hidden\" name=\'localeName\' id=\'localeName\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\n<input type=hidden name=\'total_rows\' id=\'total_rows\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<input type=\"hidden\" name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<input type=\"hidden\" name=\'ordering_practitioner\' id=\'ordering_practitioner\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\"hidden\" name=\'billing_interface_yn\' id=\'billing_interface_yn\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\"hidden\" name=\'orderId\' id=\'orderId\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\"hidden\" name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\n<SCRIPT>\n\nsetTimeout(\'showBillingTable();\',2000);\nif(\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"==\"S\")\n{\n\tif(parent.OrderBillChargeHeader.document.getElementById(\"ApprovalReqd\"))\n\t{\n\t\tparent.OrderBillChargeHeader.document.getElementById(\"ApprovalReqd\").style.display = \"\";\n\t}\n\tif(parent.OrderBillChargeHeader.document.getElementById(\"Included\"))\n\t{\n\t\tparent.OrderBillChargeHeader.document.getElementById(\"Included\").style.display = \"\";\n\t}\n}\nelse\n{\n\tif(parent.OrderBillChargeHeader.document.getElementById(\"ApprovalReqd\"))\n\t{\n\t\tparent.OrderBillChargeHeader.document.getElementById(\"ApprovalReqd\").style.display = \"none\";\n\t}\n\tif(parent.OrderBillChargeHeader.document.getElementById(\"Included\"))\n\t{\n\t\tparent.OrderBillChargeHeader.document.getElementById(\"Included\").style.display = \"none\";\n\t}\n}\n\n</SCRIPT>\n</body>\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	

	String temp_order_id="";
	String bean_id			 = "Or_billingQueryBean" ;
	String bean_name		 = "eOR.OrderEntryBillingQueryBean";
	
	String orderId			 = request.getParameter("orderId");
	String order_line_num	 = request.getParameter("lineId");
	String patient_id		 = request.getParameter("patient_id");
	String encounter_id		 = request.getParameter("encounter_id");
	String patient_class	 = request.getParameter("patient_class");
	String called_from=request.getParameter("called_from");
	
	called_from = (called_from == null) ? "" : called_from;

	orderId					= (orderId == null) ? "" : orderId;
    order_line_num			 = (order_line_num == null) ? "" : order_line_num;  
    patient_id				 = (patient_id == null) ? "" : patient_id;
    encounter_id			 = (encounter_id == null) ? "" : encounter_id;
    patient_class			 = (patient_class == null) ? "" : patient_class;
   
	String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
	String facility_id		 = (String)session.getValue("facility_id");
	
	if(practitioner_id == null)practitioner_id = "";
	if(facility_id == null)facility_id = "";
	
	ArrayList allValues		 = new ArrayList();
	
	OrderEntryBillingQueryBean bean = (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	
	//bean.clearBean() ;
	String order_set_id=bean.checkForNull(request.getParameter("order_set_id"),"");
	if(order_set_id == null || order_set_id.equals("null"))order_set_id="";

	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String order_set_bill_yn="N";
	String ord_fac_id = "";//--[IN034785]
	
	

	HashMap  setBills_dtls	 = new HashMap();
	HashMap  bill_dtls		 = new HashMap();
	ArrayList BillChargeInfo = null;
	ArrayList OrderCatalogsInfo=new ArrayList();
	String[] catalog_details = null;
	catalog_details = new String[6];
	if(!order_set_id.equals(""))
	{
		String[] OrderSetDetails=bean.getOrderSetDetails(order_set_id);
		if(OrderSetDetails[5].equalsIgnoreCase("Y"))
			orderId=order_set_id;
		OrderCatalogsInfo=bean.getOrderSetSearchDetails(orderId);
		order_set_bill_yn=OrderSetDetails[5];
		
	}
	if(!called_from.equals("register_visit"))
	{		
		allValues					= bean.viewBillCatalogDetails(orderId);
	}
	else
	{
		allValues				=bean.viewBillMultiCatalogDetails(patient_id,encounter_id,patient_class,facility_id);
	}


	String slClassValue 	= "";
	String[] record			= null;
	String[] billing_details= null;
	String billing_call_yn	= "N";
	String order_category="";
	int total_count			= 0;
	int total_records=0;
	String billing_serv_ind = "";

	boolean show_bill_dtls = false;//IN065324
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324

            _bw.write(_wl_block10Bytes, _wl_block10);

if(allValues != null && allValues.size() > 0){
	
	total_count = allValues.size();
	for(int i=0; i<allValues.size(); i++){
	
		record = (String [])allValues.get(i);
		
		slClassValue="gridData";
		if(called_from.equalsIgnoreCase("register_visit"))
		{
			orderId=record[19];
			order_category=record[20];
		}
		else
		{
			order_category=record[18];
		}
	
		//IN065324, starts
		if(is_bt_view_bill_dtls && "BT".equals(order_category.trim()) && ("OP".equals(patient_class) || "EM".equals(patient_class)) || !"BT".equals(order_category.trim()))
		{
			show_bill_dtls = true;
		}
		//IN065324, ends
		
		//if ( billing_interface_yn.equals("Y") && record[4].equals("Y") && !order_category.equals("BT") )//IN065324
		if ( billing_interface_yn.equals("Y") && record[4].equals("Y") && show_bill_dtls)//IN065324
		{
			total_records++;
			billing_call_yn		= "Y";
			//[IN034785] - Start
			ord_fac_id		= bean.getOrderFacility(orderId, record[0]);
			//[IN034785] - End
			//IN068314 Starts
			//BillChargeInfo		= bean.getBillChargeDetails(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id) ;
			if("Y".equals(record[19]))
			{
				BillChargeInfo		= bean.getBillChargeDetailsfpp(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id,record[19],record[20]) ;
			}
			else{
				BillChargeInfo		= bean.getBillChargeDetails(record[9],record[7],record[10], localeName, orderId,record[0],record[1],record[3],record[2],practitioner_id) ;
			}
			//IN068314 Ends
				if(BillChargeInfo!=null)
				{
					for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
						billing_details 	= (String[])BillChargeInfo.get(k);
						setBills_dtls		= new HashMap();
						setBills_dtls.put("charged_yn"       , billing_details[1]);
						setBills_dtls.put("total_payable"    , billing_details[2]);
						setBills_dtls.put("patient_payable"  , billing_details[3]);
						setBills_dtls.put("quantity"         , record[9]);
						setBills_dtls.put("preapp_yn"        , billing_details[5]);
						setBills_dtls.put("incl_excl_action" , billing_details[4]);
						setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
						setBills_dtls.put("patient_paid_amt" , billing_details[6]);
						setBills_dtls.put("bl_panel_str"     , billing_details[0]);
						setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
						setBills_dtls.put("serv_panel_code"  , billing_details[11]);
						setBills_dtls.put("p_episode_type"	 , billing_details[13]);
						setBills_dtls.put("p_episode_id"	 , billing_details[14]);
						setBills_dtls.put("p_visit_id"		 , billing_details[15]);
						setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
						setBills_dtls.put("rate"		 , "");
						setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
						setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
						setBills_dtls.put("fpp_yn"		 , record[19]);//IN068314
						setBills_dtls.put("fpp_category"		 , record[20]);//IN068314
					
						bean.setOrderBillDtls(orderId+record[0], setBills_dtls); 
					

				}

				bill_dtls = (HashMap)bean.getOrderBillDtls(orderId+record[0]);
		
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(called_from.equalsIgnoreCase("register_visit"))
		{
			if(!temp_order_id.equals(orderId))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block14Bytes, _wl_block14);

				temp_order_id=orderId;
			}
			else
			{
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_paid_amt"),"0.0")));
            _bw.write(_wl_block25Bytes, _wl_block25);

			if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
			{
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"&nbsp;")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"&nbsp;")));
            _bw.write(_wl_block25Bytes, _wl_block25);

			} 
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ord_fac_id));
            _bw.write(_wl_block33Bytes, _wl_block33);

				if(!billing_details[7].equalsIgnoreCase("Y")){

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block34Bytes, _wl_block34);

			billing_serv_ind = bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[13]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[14]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[16]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(billing_call_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
	  }
	  else
			billing_call_yn = "N";
	}
}
		if(OrderCatalogsInfo.size()>0)
			{
				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

				for(int z=0; z<OrderCatalogsInfo.size(); z++)
				{
					   catalog_details = (String[])OrderCatalogsInfo.get(z);
					   if(catalog_details[0] == null) catalog_details[0] = "";
					   if(catalog_details[1] == null) catalog_details[1] = "";
					   if(catalog_details[2] == null) catalog_details[2] = "";
					   if(catalog_details[3] == null) catalog_details[3] = "";
					   if(catalog_details[4] == null) catalog_details[4] = "";
					   if(catalog_details[5] == null) catalog_details[5] = "";
					   String  priority_desc=catalog_details[0];
					   if(priority_desc.equalsIgnoreCase("R"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
						}
						else if(priority_desc.equalsIgnoreCase("U"))
						{				
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");		
						}
						else if(priority_desc.equalsIgnoreCase("S"))
						{		
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
					   }	
					   String  order_date_time=catalog_details[1];
					   String  order_catalog_detail=catalog_details[2];
					   String  order_type_short_desc=catalog_details[3];
					   String ordering_pract_name=catalog_details[4];
					   String order_status_short_desc=catalog_details[5];

				 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_date_time));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_type_short_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_catalog_detail));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ordering_pract_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_status_short_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);

				}
				
            _bw.write(_wl_block72Bytes, _wl_block72);

			}
		//}
	
		if(total_records==0)
		{
			
            _bw.write(_wl_block73Bytes, _wl_block73);

		}


            _bw.write(_wl_block74Bytes, _wl_block74);

	//}
//}


            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(total_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(billing_serv_ind));
            _bw.write(_wl_block88Bytes, _wl_block88);

	putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingChargesDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
