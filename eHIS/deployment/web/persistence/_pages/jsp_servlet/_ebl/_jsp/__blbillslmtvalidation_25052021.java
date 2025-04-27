package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import eXH.CreditCardTransactions;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmtvalidation_25052021 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtValidation_25052021.jsp", 1737916082151L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t    Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210113             8157          NMC-JD-CRF-0072              Shikha Seth\n2            V210211             13526         MOHE-CRF-0060 \t            Shikha Seth\n3            V210212             13526         MOHE-CRF-0060 \t            Shikha Seth\n4            V210224             8157          NMC-JD-CRF-0072\t\t\t\tShikha Seth\n5            V210319             16156         NMC-JD-CRF-0072.2            Shikha Seth\n6\t     \t\t\t 15771\t       NMC-JD-SCF-0164\t\t\t\tSethuraman D\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script>\nfunction callAsyncOnlinePrint(){\n\tvar xmlStr=\"<root><report/></root>\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\txmlHttp.send(xmlDoc);\t\n}\n\nfunction callAsyncOnlineReceipt(){\n\tvar xmlStr=\"<root><report/></root>\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp?calledForReceipt=Y\",true);\n\txmlHttp.send(xmlDoc);\t\n}\n\n//V210113 start\nfunction callNuhdeekTransactions(patientID,LoggedUser,clientIpAddress,recDocType,recNum,coupon){\t\t\t\n\tvar transactionid=recDocType.concat(recNum);\t\n\tvar NuhdeekResponse = NuhdeekTransactions(\'USED\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\n\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\t\t\t\t\t\n\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\treturn false;\n\t}\t\n}\n//V210113 end\n</script>\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\t  \n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\t\t\n\t\t\t\t\t\t\talert(v_error);\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'BL\'));\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n//\t\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\n\t\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t  \n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(v_error);\t\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'BL\'));\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n//\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n//\t\t\t\t\t\t\tparent.frames[2].loc\tation.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\t\t\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"1\";\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\tcallNuhdeekTransactions(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\",";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\t\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\talert(v_error);\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'BL\'));\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<script>\n//\t\t\t\t\t\tparent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\t\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t  \n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\t\t\n\t\t\t\t\t\t\t\t\talert(v_error);\t\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'BL\'));\n\t\t\t\t\t\t\t\t</script>\n\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\t\t\t\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar v_recrefno = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'+\'/\'+\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\t\t\tvar v_slmtamt  = \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t\n\t\t\t\t\t\tif ((parseFloat(v_slmtamt) > 0 && parseFloat(v_slmtamt) != 0) || (parseFloat(v_slmtamt) < 0 && parseFloat(v_slmtamt) != 0 ))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'+\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar called_frm = \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\t\tvar alw_co_wit_bl_slmt_yn = \'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t\tvar cal_frm_multi_bil_slmt = \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\tvar episode_type = \'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\tif(called_frm == \"CHECKOUT_VISIT\" && alw_co_wit_bl_slmt_yn == \"Y\" && episode_type == \'E\' && cal_frm_multi_bil_slmt==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.frames[0].location.href=\"../../eBL/jsp/BLBillListDtls.jsp?patient_id=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&episode_type=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&episode_id=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&visit_id=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&encounter_id=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&module_id=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&function_id=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&alw_co_wit_bl_slmt_yn=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tvar retVal = \'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\';\n\t\t\t\t\t\t\tparent.window.returnValue = retVal;\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(v_error);\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t//\tparent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\t\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"1\";\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\");\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\talert(v_error);\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\',\'BL\'));\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<script>\n\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\t\tparent.frames[3].document.forms[0].ok_button.disabled=false;\n\t\t\t\t</script>\t\t\t\t\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\t\t  \n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\';\t\t\n\t\t\t\t\t\t\t\talert(v_error);\t\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',\'BL\'));\n\t\t\t\t\t\t\t</script>\n\t\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\t\t\t\t\t//parent.frames[2].location.href=\"../../eBL/jsp/BLBillSlmtType.jsp?error_flag=true&cashcounter=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar v_recrefno = \'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\';\n\t\t\t\t\tvar v_slmtamt  = \'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\';\n\t\n\t\t\t\t\tif ((parseFloat(v_slmtamt) > 0 && parseFloat(v_slmtamt) != 0) || (parseFloat(v_slmtamt) < 0 && parseFloat(v_slmtamt) != 0 ))\n\t\t\t\t\t{\n\t\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' + v_recrefno);\n\t\t\t\t\t}\n\t\t\t\t\tvar called_frm = \'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\';\n\t\t\t\t\tvar alw_co_wit_bl_slmt_yn = \'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\';\n\t\t\t\t\tvar cal_frm_multi_bil_slmt = \'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\';\n\t\t\t\t\tvar episode_type = \'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\';\n\t\t\t\t\tif(called_frm == \"CHECKOUT_VISIT\" && alw_co_wit_bl_slmt_yn == \"Y\" && episode_type == \'E\' && cal_frm_multi_bil_slmt==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.parent.frames[0].location.href=\"../../eBL/jsp/BLBillListDtls.jsp?patient_id=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\n\t\t\t\t\t\tvar retVal = \'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\';\n\t\t\t\t\t\tparent.window.returnValue = retVal;\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t}\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t<Script>\n\t\t\t\t\t\tvar retVal = \"N\";\n\t\t\t\t\t\tparent.window.returnValue = retVal;\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" \n\t<head>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form>\n\t\t<input type=\"hidden\" name=\"querystring\" id=\"querystring\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"called_frm\" id=\"called_frm\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t</form>\t \n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet  rstMt =  null;
	PreparedStatement pstmtRpt = null;
	//Added by Manivel Natarajan on 10/Aug/2006  
	request.setCharacterEncoding("UTF-8");
	int intReceiptsTotRec=0;
	String strRecptDocAmt="", strRecptDocNum="", strRecptDocTypeCode = "",strRecptDocSrNo="",bill_print_reqd="";
	String locale	= (String)session.getAttribute("LOCALE");
	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> (); //Code added by Karthik to move the Online Print module to asyncronous mode
	CallableStatement call = null;

	String strBlrblprt="";
	//Added by Rajesh V - SCF 1140
	String separateReceipt = "";
	//Added by Rajesh V - SCF 1140

	String called_moduleId=(String)session.getAttribute("called_module_id"); 
	if ( called_moduleId == null ) called_moduleId = "";

    String strmoduleid=request.getParameter("moduleid");	
	String strfacilityid = request.getParameter("facilityid");	
	if(strfacilityid == null || strfacilityid.equals(""))
	{
		 strfacilityid	=  (String) session.getValue("facility_id");
	}
	String		strpatientid  = request.getParameter("patientid");	
	String		strepisodetype = request.getParameter("episodetype");	
	String		strepisodeid = request.getParameter("episodeid");
	String		strvisitid = request.getParameter("visitid");	
	String		strencounterid = request.getParameter("encounterid");	
	String		strbilldoctypecode = request.getParameter("billdoctypecode");	
	String		strbilldocnum = request.getParameter("billdocnum");	
	String      strpayableAmt = request.getParameter("billpayableamt");  //newly added for  partial settlment case from PH
	String		strslmtamt = request.getParameter("bill_slmt_amtdet");		
	String		strslmttypecode = request.getParameter("slmttypecode");	
	String		strslmtdocref = request.getParameter("slmtdocref");	
	String		strslmtdocrefdate = request.getParameter("slmtdocrefdate");	
	String		strslmtdocrefremark = request.getParameter("slmtdocrefremark");	
	String		strslmtidno = "";	
	String		strslmtpayername = request.getParameter("slmtpayername");	
	String		struser = request.getParameter("loggeduser");
	String		strslmtapprrefno = request.getParameter("slmtapprrefno");
	String		stronlineapproval = request.getParameter("onlineapproval");
	String		strbatchno = request.getParameter("batchno");
	String		strsaledraftno = request.getParameter("saledraftno");
	String		strrectype = request.getParameter("rectype");

	//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
	String		strtermidnum = request.getParameter("cctermidnum");
	String		strtrxdatetime = request.getParameter("cctrxdatetime");
	String		strccinstbranch = request.getParameter("instbranch");

	String		strCurrStlmt = request.getParameter("rtnCurrSlmt");
	if ( strCurrStlmt == null ) strCurrStlmt = "";
	String		strPendStlmt = request.getParameter("rtnPendSlmt");
	if ( strPendStlmt == null ) strPendStlmt = "";
	String		strSerDate = request.getParameter("rtnArrayDt");
	if ( strSerDate == null ) strSerDate = "";
	String		strserDocRef = request.getParameter("rtnArrayDocref");
	if ( strserDocRef == null ) strserDocRef = "";
	String		strSerDocRefLine = request.getParameter("rtnArrayDocrefLine");
	if ( strSerDocRefLine == null ) strSerDocRefLine = "";
	String		strSerDocRefSeq = request.getParameter("rtnArrayDocrefSeq");
	if ( strSerDocRefSeq == null ) strSerDocRefSeq = "";
	String   strServiceTotRec=request.getParameter("services_tot_records");
	if ( strServiceTotRec == null ) strServiceTotRec = "";
	
	String roundingamt = request.getParameter("roundingamt");
	if ( roundingamt == null ) roundingamt = "";
	
	String strBlngServCode=request.getParameter("rtnBlngServCode");
	if ( strBlngServCode == null ) strBlngServCode = "";

	String strTrxDate=request.getParameter("rtnTrxDate");
	if ( strTrxDate == null ) strTrxDate = "";
	
	String strPrtGrpHdrCode=request.getParameter("rtnPrtGrpHdrCode");
	if ( strPrtGrpHdrCode == null ) strPrtGrpHdrCode = "";
	
	String strPrtGrpLineCode=request.getParameter("rtnPrtGrpLineCode");
	if ( strPrtGrpLineCode == null ) strPrtGrpLineCode = "";

	String strUpdGrossChrgAmt=request.getParameter("rtnUpdGrossChrgAmt");
	if ( strUpdGrossChrgAmt == null ) strUpdGrossChrgAmt = "";

	String strUpdNetChrgAmt=request.getParameter("rtnUpdNetChrgAmt");
	if ( strUpdNetChrgAmt == null ) strUpdNetChrgAmt = "";

	String tot_rec_for_serv_insert=request.getParameter("tot_rec_for_serv_insert");
	if ( tot_rec_for_serv_insert == null ) tot_rec_for_serv_insert = "";

	String called_frm = request.getParameter("called_frm");
	if(called_frm == null) called_frm="";

	String alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
	if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

	String cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");
	if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="N";

	String querystring=(String)request.getQueryString();
	//V210211 start
	String strEncounterFacilityId = request.getParameter("encounterFacilityId");
	if (strEncounterFacilityId== null || strEncounterFacilityId.equals("") || strEncounterFacilityId.equals("null")) 
	strEncounterFacilityId = strfacilityid; //V210212
	//V210211 end
	int  blprintVal =0;
	String		strerrorlevel="";	String		strsysmessageid="";
	String		strerrortext="";	//String		strencounterid="";	
	String		strCashgiven="";	String		strCashreturn="";
	String		strbank_cccode="";	String		v_strbank_cccode="";	String		v_stlmt_type_code="";
	String		error_flag="";	String		strbillslmtamt="";	String		v_strslmtdocrefdate="";
	String		proc_success="Y",str_slmt_mode_wise_rcpt_yn="",hand_without_counter_chk_out="";
	String retrnValue = "Y";
	ArrayList existing_records_array=new ArrayList();
	String		genmesg = request.getParameter("genmesg");
	if ( strrectype == null ) strrectype = "";
	String      strextacccode=request.getParameter("ext_acc_code");
	if ( strextacccode == null ) strextacccode = "";
	String      strextaccdept=request.getParameter("ext_acc_dept");
	if ( strextaccdept == null ) strextaccdept = "";
	String      strextaccfacid=request.getParameter("ext_acc_fac_id");
	if ( strextaccfacid == null ) strextaccfacid = "";
	String strstlmtdoctypecode="";
	String strrecordcount=request.getParameter("total_records");	
	if ( strrecordcount == null ) strrecordcount = ""; //"0"; //V210212
	String cash_counter_code=request.getParameter("cash_counter_code");	
	if ( cash_counter_code == null ) cash_counter_code = "";

	//int total_records=Integer.parseInt( (strrecordcount.equals("")) ? "0" : strrecordcount );
	//Commented Above and added existing Code	
	
	//int total_records= 0;
	//if(!strrecordcount.equals(""))
		//total_records=Integer.parseInt(strrecordcount); 

	int total_records=Integer.parseInt( (strrecordcount.equals("")) ? "0" : strrecordcount ); 
	int intslmt_doc_sr_num=1; 
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			
	String strclientip = p.getProperty("client_ip_address");
	String strclientname = "";			String strslmtdocnum	  = "";			
	String strrecrefformatind = "C";	String strprintrequestyn  = "Y";
	String currdate="";
	String str_arr_slmt_doc_type_code="",str_arr_slmt_doc_num="",doc_type_code="",doc_num="",final_msg ="",str_for_serv_slmt_doc_type_code="",str_for_serv_slmt_doc_num="",str_rcpt_doc_amt="";

	String str_slmt_type_code="";
	String str_bill_prt_format_YN = "N";
	String str_bill_prt_format_vals = "";
	String str_bill_print_format_flag = "N";
	String pgm_id ="";
	String session_id ="";
	String pgm_date ="";
	String mpi_id_rep = "";
	//V210113 start
	String patMembershipID ="";
	String strCoupon ="";
	String strcouponAndAmt="";
	//V210113 end
	CallableStatement cstmt = null;//KDAH-CRF-0546

	StringTokenizer st_arr_slmt_doc_type_code=null;
	StringTokenizer st_arr_slmt_doc_num = null;
	if ( strmoduleid == null )  strmoduleid = "";
	if ( strfacilityid == null )  strfacilityid = "";
	if ( strpatientid == null )   strpatientid = "";
	if ( strepisodetype == null ) strepisodetype = "";
	if ( strepisodeid == null ) strepisodeid = "";
	if ( strvisitid == null ) strvisitid = "";
	if ( strencounterid == null ) strencounterid = "";
	if ( strbilldoctypecode ==  null ) strbilldoctypecode = "";
	if ( strbilldocnum == null ) strbilldocnum = "";
	if ( strslmtamt == null ) strslmtamt = "";
	if ( strpayableAmt == null ) strpayableAmt = "";
	if ( strslmttypecode == null ) strslmttypecode = "";
	if ( strslmtdocref == null) strslmtdocref = "";
	if ( strslmtdocrefdate == null ) strslmtdocrefdate = "";
	if ( strslmtdocrefremark == null ) strslmtdocrefremark = "";
	if ( strslmtidno == null ) strslmtidno = "";
	if ( strslmtpayername == null ) strslmtpayername = "";			
	if ( strslmtapprrefno == null ) strslmtapprrefno = "";
	if ( stronlineapproval == null ) stronlineapproval = "";	
	if ( strbatchno == null ) strbatchno = "";
	if ( strsaledraftno == null ) strsaledraftno = "";
	if ( strrectype == null ) strrectype = "";
	if ( strextaccfacid == null ) strextaccfacid = "";
	if ( strextacccode == null ) strextacccode = "";
	if ( strextaccdept == null ) strextaccdept = "";	
	if (struser == null || struser.equalsIgnoreCase("null")) 
	{
		struser = request.getParameter("user");
	}	
	if (struser == null || struser.equalsIgnoreCase("null")) 
	{
		struser = (String) httpSession.getAttribute("login_user");
	}	
	if (querystring == null || querystring.equalsIgnoreCase("null")) 
	{
		querystring = "";
	}

	//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
	if ( strtermidnum == null ) strtermidnum = "";
	if ( strtrxdatetime == null ) strtrxdatetime = "";
	if ( strccinstbranch == null ) strccinstbranch = "";
	
	String bill_print_format_enabled_yn = request.getParameter("bill_print_format_enabled_yn");	
	if ( bill_print_format_enabled_yn == null ) bill_print_format_enabled_yn = "N";
	//Added by muthu on 13-7-12
	String rec_print_format_enabled_yn = request.getParameter("rec_print_format_enabled_yn");
	if ( rec_print_format_enabled_yn == null ) rec_print_format_enabled_yn = "N";
	//Added by muthu on 13-7-12
	String called_frm_cancel = request.getParameter("called_frm_cancel");	
	if ( called_frm_cancel == null ) called_frm_cancel = "N";

	con	=	ConnectionManager.getConnection(request);
	//String str_facility_id	=  (String) session.getValue("facility_id");//Added V200120-MuthuN/GHL-CRF-0611/Starts 
	Boolean Slysite=false;
	String Slysite_spec ="";
	String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
	if(billAlreadyPrinted == null) billAlreadyPrinted="N";
	try
	{
		Slysite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");				
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	if(Slysite){
		Slysite_spec="Y";
	}
	else{
		Slysite_spec="N";
	}

	//Added below code for GST-GHL-CRF-0477
	String custId = BLReportIdMapper.getCustomerId();
	String gstApplicableYN = "N";
	String printOrientation = "P";
	try{
		pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
		rstMt = pstmtRpt.executeQuery();
		if(rstMt != null && rstMt.next()){
			gstApplicableYN = rstMt.getString("gst_applicable");
		}
		
		if("Y".equals(gstApplicableYN)){
		/*	String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
										"FROM bl_parameters "+
										"WHERE operating_facility_id = ?";
			
			pstmtRpt = con.prepareStatement(printOrientationSql);
			pstmtRpt.setString(1, strfacilityid);
			rstMt = pstmtRpt.executeQuery();
			
			if(rstMt != null && rstMt.next()){
				printOrientation = rstMt.getString("default_bill_print_orientation");
			}		*/	
		//ADDED FOR KDAH-CRF-0546 on 15-May-20
		try{ 				
				cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
				cstmt.setString(1,strfacilityid);
				cstmt.setString(2,strepisodetype);				
				cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				cstmt.execute();
				printOrientation = cstmt.getString(3);
				strBlrblprt = cstmt.getString(4);	
				System.out.println("264-- printOrientation===>"+printOrientation);
				System.out.println("265-- strBlrblprt===>"+strBlrblprt);
			}
			catch(Exception e){
				printOrientation = "P";
				System.err.println("Exception in getting BLBillSlmtValidation.jsp, 1"+e);
				e.printStackTrace();
			}
			finally{
				try
				{
					if (cstmt !=null) cstmt.close();
				}
				catch(Exception ee1) 
				{
					System.err.println("Exception in getting BLBillSlmtValidation.jsp, 2"+ee1);
					ee1.printStackTrace();
				}
			}
			//ADDED FOR KDAH-CRF-0546 on 15-May-20
		}
	}
	catch(Exception e){
		printOrientation = "P";
		System.err.println("Exception in getting printOrientation, 1"+e);
		e.printStackTrace();
	}
	finally{
		try
		{
			if(rstMt != null)  rstMt.close();	
			if (pstmtRpt !=null) pstmtRpt.close();
		}
		catch(Exception ee1) 
		{
			System.err.println("Exception in getting printOrientation, 2"+ee1);
			ee1.printStackTrace();
		}
	}
	//Added below code for GST-GHL-CRF-0477
	// Modified By DhanasekarV  on  05/3/2013  againt  PH ST   specific  BLRBLPRT
			
	/* Added V200116-MuthuN/GHL-CRF-0611/Starts */
	String printFormatSql = "SELECT NVL(PRINT_A5_FORMAT,'N') PRINT_A5_FORMAT FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+strfacilityid+"'";
	pstmtRpt = con.prepareStatement(printFormatSql);
	rstMt = pstmtRpt.executeQuery();
	String printFormat = "N";
	while(rstMt.next()) {
		printFormat = rstMt.getString("PRINT_A5_FORMAT");
	}
	pstmtRpt.close();
	rstMt.close();
	/* Added V200116-MuthuN/GHL-CRF-0611/Ends */
	if("Y".equals(printFormat)  && "P".equals(printOrientation) && "MC".equalsIgnoreCase(custId)) {//Added V200116-MuthuN/GHL-CRF-0611
		strBlrblprt = "BLRBLPRT_GHL";
	} else {
		strBlrblprt  ="BLRBLPRT";
	}

	/*Added by Karthik for Report Rerint called from */
	if(called_moduleId.equals("")){
		String moduleCalledFromReportReprint=(String)session.getAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT");
		if(moduleCalledFromReportReprint==null) moduleCalledFromReportReprint="";
		
		if(moduleCalledFromReportReprint.equals("")==false){
			called_moduleId=moduleCalledFromReportReprint;	
		}
		session.removeAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT");			
	}
				retrnValue ="Y";
	if(called_moduleId.equals("PH") || called_moduleId.equals("ST"))
		{
		if(strpayableAmt.length()>0 &&strslmtamt.length() >0 && Float.parseFloat(strpayableAmt)  > Float.parseFloat(strslmtamt))
		{											
			retrnValue = "P";
		}

	try{		
		String qryStmt="select report_id  from  bl_bill_reports where OPERATING_FACILITY_ID = '"+strfacilityid+"'  and bill_type='PH-BILL'";				

		 pstmtRpt = con.prepareStatement(qryStmt);							
		 rstMt = pstmtRpt.executeQuery();
		while (rstMt!=null && rstMt.next())
		{	
			strBlrblprt  =  rstMt.getString(1);
		}
		}catch(Exception ee)
		{
		if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
			strBlrblprt = "BLRBLPRT_GHL";
		} else {
			strBlrblprt  ="BLRBLPRT";
		}
		}
		finally
		{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}catch(Exception ee1) 
			{
				ee1.printStackTrace();
			}
			}								 
		}

		//Added By Rajesh V - RUT-CRF0095
		//String custId = BLReportIdMapper.getCustomerId();
		String strBlrRecpt = "";
		if("RTN".equalsIgnoreCase(custId)){
			String billTypeId = BLReportIdMapper.getBillType(strepisodetype,called_frm,called_moduleId);
			strBlrblprt = BLReportIdMapper.getBlrBlPrtReportId(strfacilityid, billTypeId);
			if(strBlrblprt == null || "".equals(strBlrblprt)){
				if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
				strBlrblprt = "BLRBLPRT_GHL";
				} else {
				strBlrblprt  ="BLRBLPRT";
				}
			}	
		}
		// Added By Rajesh V - RUT-CRF0095
			
		try {
			/* BLReportIdMapper.getReportId function used in other modules also
			 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
			 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
			 * eMP - PatientRegistrationServlet.java
			 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
			 */
			strBlrblprt = BLReportIdMapper.getReportId(con, locale,strBlrblprt, strfacilityid); //Added strfacilityid by subha for MMS-DM-CRF-131.1
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Exception in BLBillSlmtValidation for reportID "+ e);
			}				
	/*//Added below code for GST-GHL-CRF-0477
		String gstApplicableYN = "N";
		String printOrientation = "P";
		try{
			pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
			rstMt = pstmtRpt.executeQuery();
			if(rstMt != null && rstMt.next()){
				gstApplicableYN = rstMt.getString("gst_applicable");
			}
			
			if("Y".equals(gstApplicableYN)){
				String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
											"FROM bl_parameters "+
											"WHERE operating_facility_id = ?";
				
				pstmtRpt = con.prepareStatement(printOrientationSql);
				pstmtRpt.setString(1, strfacilityid);
				rstMt = pstmtRpt.executeQuery();
				
				if(rstMt != null && rstMt.next()){
					printOrientation = rstMt.getString("default_bill_print_orientation");
				System.err.println("BLSlmtValidation printOrientation==>"+printOrientation);
				}			
				
			}
		}
		catch(Exception e){
			printOrientation = "P";
			System.err.println("Exception in getting printOrientation"+e);
			e.printStackTrace();
		}
		finally{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}
			catch(Exception ee1) 
			{
				System.err.println("Exception in getting printOrientation"+ee1);
				ee1.printStackTrace();
			}
		}*/
	if(("L".equals(printOrientation)) && ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
			strBlrblprt = "BLRBLPRL";
		}
		//Added below code for GST-GHL-CRF-0477
	//END
	try
	{
		if(called_frm_cancel.equals("N"))
		{
			con.setAutoCommit(false);					
			String str_ws_by_ip_name = "";	String str_facility_id = strfacilityid;
			PreparedStatement pst1=con.prepareStatement("select ws_by_ip_name from sm_facility_param where facility_id = ?");
			pst1.setString(1,str_facility_id);
			ResultSet rst1 = pst1.executeQuery();
			if (rst1!=null)
			{
			   if (rst1.next())
			   {
					 str_ws_by_ip_name = rst1.getString("ws_by_ip_name");
			   }
			}

		if (rst1 != null)   rst1.close();
		if (pst1 != null)   pst1.close();

		if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";
		if (str_ws_by_ip_name.equals("I"))
		{
			strclientname = InetAddress.getByName((String) strclientip).getHostName().toUpperCase();
		}
		else
		{	
			strclientname = strclientip; 
		}

		String sqlst2="select SLMT_MODE_WISE_RCPT_YN,HAND_WITHOUT_COUNTER_CHK_OUT,to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from BL_PARAMETERS where OPERATING_FACILITY_ID = '"+str_facility_id+"'";
		PreparedStatement pst2=con.prepareStatement(sqlst2);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 str_slmt_mode_wise_rcpt_yn = rst2.getString(1);
				 hand_without_counter_chk_out = rst2.getString(2);
				 currdate = rst2.getString(3);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();

		//FOR MUILTIPLE SLMT WISE --22/12/08
		//str_slmt_mode_wise_rcpt_yn="N";//Testing Purpose
		if(str_slmt_mode_wise_rcpt_yn.equals("Y"))
		{
	try
	{
		if(proc_success.equals("Y"))
		{			
			for(int tot_rec=0;tot_rec<total_records;tot_rec++)
			{		
				String[] records1=new String[20];
				records1[0]=request.getParameter("billslmtamt"+tot_rec);	
				strbillslmtamt=records1[0];			
				if ( strbillslmtamt == null )  strbillslmtamt = "";
				strRecptDocAmt = strRecptDocAmt+strbillslmtamt+"|";
				str_rcpt_doc_amt=str_rcpt_doc_amt+"|"+records1[0];

				records1[1]=request.getParameter("slmttype"+tot_rec);
				strslmttypecode =records1[1];
				if ( strslmttypecode == null )  strslmttypecode = "";

				v_stlmt_type_code=strslmttypecode.substring(0,2);
				patMembershipID = request.getParameter("patMembershipID"); //V210113
				//call = con.prepareCall("{ call blopin.BILL_SLMT_HDR_PROC (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				//Added by muthu against Arabic Language Issue on 12-6-12
				call = con.prepareCall("{ call blopin.BILL_SLMT_HDR_PROC_1 (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); //V210113
				call.setString(1, strEncounterFacilityId); //V210211
				//call.setString(1,strfacilityid); //V210211 commented
				call.setString(2,strpatientid);
				call.setString(3,strepisodetype);
				call.setString(4,strencounterid);
				call.setString(5,strepisodeid);
				call.setString(6,strvisitid);
				call.setString(7,called_frm);//Added for GHL-45
				call.setString(8,alw_co_wit_bl_slmt_yn);//Added for GHL-45
				call.setString(9,strbilldoctypecode);
				call.setString(10,strbilldocnum);
				call.setString(11,strstlmtdoctypecode);		
				call.setString(12,strbillslmtamt);
				call.setString(13,strprintrequestyn);
				call.setString(14,struser);
				call.setString(15,strclientip);
				call.setString(16,strclientname);
				call.setString(17,strrectype);
				call.setString(18,strextaccfacid);			
				call.setString(19,strextacccode);
				call.setString(20,strextaccdept);
				call.setInt(21,tot_rec);//P_SLMT_LINE_CNT   
				call.setString(22,v_stlmt_type_code);//Added for SCRUM CRF-GHL-8.2
				call.registerOutParameter(11,java.sql.Types.VARCHAR);	
				call.registerOutParameter(23,java.sql.Types.VARCHAR);	
				call.registerOutParameter(24,java.sql.Types.VARCHAR);	
				call.registerOutParameter(25,java.sql.Types.VARCHAR);	
				call.registerOutParameter(26,java.sql.Types.VARCHAR);					
				call.registerOutParameter(27,java.sql.Types.VARCHAR);	
				call.registerOutParameter(28,java.sql.Types.VARCHAR);
				call.setString(29,locale); //Added for Arabic Issue by Muthu on 12-6-12
				call.setString(30,patMembershipID); //V210113
				call.execute();				
				strstlmtdoctypecode	 = call.getString(11);	
				strslmtdocnum  	     = call.getString(23);		
				if(tot_rec == 0)
				{
					str_bill_prt_format_YN = call.getString(24);
					if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
					str_bill_prt_format_vals = call.getString(25);
					if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
				}
				strerrorlevel		 = call.getString(26);		
				strsysmessageid		 = call.getString(27);		
				strerrortext     	 = call.getString(28);				
				if ( strstlmtdoctypecode == null ) strstlmtdoctypecode = "";
				if ( strslmtdocnum == null ) strslmtdocnum = "";			
				if ( strerrorlevel == null ) strerrorlevel = "";
				if ( strsysmessageid == null ) strsysmessageid ="";
				if ( strerrortext == null ) strerrortext ="";
				call.close();// Karthik added Closing unclosed Connection
				str_arr_slmt_doc_type_code =	str_arr_slmt_doc_type_code+"@@"+strstlmtdoctypecode;
				str_arr_slmt_doc_num = str_arr_slmt_doc_num+"@@"+strslmtdocnum;

				strRecptDocTypeCode = strRecptDocTypeCode+strstlmtdoctypecode+"|";
				strRecptDocNum=strRecptDocNum+strslmtdocnum+"|";

				str_for_serv_slmt_doc_type_code = str_for_serv_slmt_doc_type_code+"|"+strstlmtdoctypecode;

				str_for_serv_slmt_doc_num =str_for_serv_slmt_doc_num+"|"+strslmtdocnum;
		
				if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
				{
					con.rollback();
					//con.close();
		
					if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
					{	
						error_flag="";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block7Bytes, _wl_block7);

						error_flag="true";
					}
					if(!strsysmessageid.equals(""))
					{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block9Bytes, _wl_block9);

						error_flag="true";
					}
					proc_success="N";
				}		
				if(!error_flag.equals("") && error_flag.equals("true"))
				{
					session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				final_msg = final_msg+" :: "+strstlmtdoctypecode+" / "+strslmtdocnum;
				strRecptDocSrNo = strRecptDocSrNo+"1"+"|"; // For Multiple Receipts logic sl no should be 1 always
				/* GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration */
				String slmtForCreditCard=strslmttypecode.substring(0,2);						
				String ccCheck="SELECT credit_card_machine_int_yn FROM bl_slmt_cash_counter WHERE operating_facility_id = ? AND cash_counter_code = ? AND slmt_type_code = ?";
				
				String str_credit_card_machine_int_yn="N";
				PreparedStatement ccPst=con.prepareStatement(ccCheck);
				ccPst.setString(1,strfacilityid);
				ccPst.setString(2,cash_counter_code);
				ccPst.setString(3,slmtForCreditCard);	
				ResultSet ccRst = ccPst.executeQuery();
				if (ccRst!=null)
				{
				   if (ccRst.next())
				   {
					   str_credit_card_machine_int_yn = ccRst.getString(1);
					   if(str_credit_card_machine_int_yn == null) str_credit_card_machine_int_yn="";
				   }
				}						
				if (ccRst != null)   ccRst.close();
				if (ccPst != null)   ccPst.close();

				String responseText=null;
				Map<String,String> reqParams=(Map<String,String>)session.getAttribute("BL_CREDIT_CARD_PARAM_MAP");
				String cardData=(String) session.getAttribute("BL_CREDIT_CARD_DETAILS");
				
				if(str_credit_card_machine_int_yn.equals("Y") && !(slmtForCreditCard.equals("PT"))){
					String P_Reciept_number=strslmtdocnum;
					String P_RECEIPT_TYPE=strstlmtdoctypecode;					
					reqParams.put("P_Reciept_number", P_Reciept_number );
					reqParams.put("P_RECEIPT_TYPE", P_RECEIPT_TYPE );							
					String P_Preapaid_Card_Number="";
					StringTokenizer sessionTextTok=new StringTokenizer(cardData,"|");
					if(sessionTextTok.hasMoreTokens()) P_Preapaid_Card_Number=sessionTextTok.nextToken();
					reqParams.put("P_Preapaid_Card_Number",P_Preapaid_Card_Number);							
					//out.println("<script>alert('**** ALERT FOR TESTING PURPOSE **** P_Preapaid_Card_Number :" + P_Preapaid_Card_Number +"')</script>");
					//out.println("<script>alert('Input Params Start:" + reqParams +"')</script>");
					
					try{
						if (slmtForCreditCard.toUpperCase().equals("WC")){ // if condition added by Sethu for KDAH Testing
							responseText=new CreditCardTransactions().processCC01Transaction(reqParams);	
						}
						else
						{
						//responseText = "S$|#$|#Amount deducted$|#Test Payer$|#992836$|#7777801$|#XXXXXX$|#VISA$|#104793$|#15/12/2014$|#1234001$|#$|#$|#$|#HDFC"; 
							responseText="S$|#Amount deducted successfully$|#$|#Mr. Sudhish Chandra Gupta$|#366$|#366$|#AA$|#WC$|#100033$|#01/01/2099$|#366$|#06/01/2015$|#113617$|#$|#WC";
						}
						responseText=responseText.trim();
						if( responseText==null || responseText.equals("") || responseText.charAt(0) != 'S' ){
							proc_success="N";
						}
						if(responseText.charAt(0) == 'S'){
							String successMessage="";
							StringTokenizer responseTextTok=new StringTokenizer(responseText,"$|#");
							if(responseTextTok.hasMoreTokens()) {
								responseTextTok.nextToken();
								successMessage=responseTextTok.nextToken();			
							}
							out.println("<script>alert('" + successMessage +"')</script>");
						}
					}catch(Exception e){
						proc_success="N";
						System.err.println("641");
						e.printStackTrace();
					}
				}					
				//out.println("<script>alert('Input Params End:" + reqParams +"')</script>");
				//out.println("<script>alert('Response Text:" + responseText +"')</script>");
				
				/* GHL-CRF-0366.1 Karthik added the below code for Credit Card Integration ends */
				
			}// end for 
		//SERVICE FOR MLTL RECPT
			st_arr_slmt_doc_type_code = new StringTokenizer(str_arr_slmt_doc_type_code,"@@");
			st_arr_slmt_doc_num = new StringTokenizer(str_arr_slmt_doc_num,"@@");
	
			intReceiptsTotRec = st_arr_slmt_doc_num.countTokens();

			//for(int tot_rec=0;tot_rec<total_records;tot_rec++)
			//{	
	
		//	while(st_arr_slmt_doc_type_code.hasMoreTokens())
		//	{
				//doc_type_code=st_arr_slmt_doc_type_code.nextToken();
		}
		if(proc_success.equals("Y"))
		{
			String sql_check="{ call  BL_INSERT_DEPOSIT.BL_PROC_INSERT_SERV_RCPT_TABLE('"+strfacilityid+"','"+strserDocRef+"','"+strSerDocRefLine+"','"+strSerDocRefSeq+"','"+strBlngServCode+"','"+strbilldoctypecode+"','"+strbilldocnum+"','"+strepisodetype+"','"+strpatientid+"','"+strepisodeid+"','"+strvisitid+"','"+strCurrStlmt+"','"+strTrxDate+"','"+strSerDate+"','"+strPrtGrpHdrCode+"','"+strUpdNetChrgAmt+"','"+strPrtGrpLineCode+"','"+tot_rec_for_serv_insert+"',"+intReceiptsTotRec+",'"+struser+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+struser+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+strUpdGrossChrgAmt+"','"+strclientname+"','"+strfacilityid+"','"+strclientname+"','"+strfacilityid+"','"+roundingamt+"','"+strRecptDocTypeCode+"','"+strRecptDocNum+"','"+strRecptDocSrNo+"','"+strRecptDocAmt+"',?,?,?)}";					   
			call = con.prepareCall(sql_check);						
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.execute();
			strerrorlevel		 = call.getString(1);		
			strsysmessageid		 = call.getString(2);		
			strerrortext     	 = call.getString(3);				
			if ( strerrorlevel == null ) strerrorlevel = "";
			if ( strsysmessageid == null ) strsysmessageid ="";
			if ( strerrortext == null ) strerrortext ="";
					
			call.close();	
			if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
			{
				con.rollback();
//						con.close();
				if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
				{
					error_flag="";

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block15Bytes, _wl_block15);

					error_flag="true";
				}
				if(!strsysmessageid.equals(""))
				{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block17Bytes, _wl_block17);

					error_flag="true";
				}
				proc_success="N";
			}
			if(!error_flag.equals("") && error_flag.equals("true"))
			{
				session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
				}
			//}//outer tokens while end 
//}// end for 

//FOR DTL PROC
				int i=0;
				st_arr_slmt_doc_type_code = new StringTokenizer(str_arr_slmt_doc_type_code,"@@");
				st_arr_slmt_doc_num = new StringTokenizer(str_arr_slmt_doc_num,"@@");
				while(st_arr_slmt_doc_num.hasMoreTokens())
				{
					doc_type_code=st_arr_slmt_doc_type_code.nextToken();
					doc_num = st_arr_slmt_doc_num.nextToken();		
					//for(int i=0;i<total_records;i++)
					//{
					
					//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->
					//String[] records=new String[22]; //V210113 
					String[] records=new String[24];
					records[0]=request.getParameter("billslmtamt"+i);	
					strbillslmtamt=records[0];			
					if ( strbillslmtamt == null )  strbillslmtamt = "";

					records[1]=request.getParameter("slmttype"+i);
					strslmttypecode =records[1];
					if ( strslmttypecode == null )  strslmttypecode = "";

					records[2]=request.getParameter("cash_given"+i);
					strCashgiven=records[2];
					if ( strCashgiven == null )  strCashgiven = "";
			
					records[3]=request.getParameter("cash_return"+i);	
					strCashreturn=records[3];
					if ( strCashreturn == null )  strCashreturn = "";

					records[4]=request.getParameter("instref"+i);	
					strslmtdocref=records[4];
					if ( strslmtdocref == null )  strslmtdocref = "";

					records[5]=request.getParameter("instdate"+i);	
					v_strslmtdocrefdate=records[5];
					if ( v_strslmtdocrefdate == null )  v_strslmtdocrefdate = "";
					
					if(!v_strslmtdocrefdate.equals("")){
					v_strslmtdocrefdate=com.ehis.util.DateUtils.convertDate(v_strslmtdocrefdate,"DMY",locale,"en");}
	
					String slmtflag=strslmttypecode.substring(2);
					if(slmtflag.equals("A"))
					{
						if ( strbank_cccode == null )  strbank_cccode = "";
						records[6]=request.getParameter("creditcardco"+i);				
						strbank_cccode=records[6];
						records[7]="";
					}
					else
					{
						if ( strbank_cccode == null )  strbank_cccode = "";
						records[7]=request.getParameter("instbankname"+i);
						strbank_cccode=records[7];
						records[6]="";
					}
			
					if ( strbank_cccode == null )  strbank_cccode = "";
					records[8]=request.getParameter("instbranch"+i);	
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
					strccinstbranch = records[8];
					if ( strccinstbranch == null )  strccinstbranch = "";

					records[9]=request.getParameter("instremarkcode"+i);				
					records[10]=request.getParameter("batchno"+i);	
					strbatchno=records[10];
					if ( strbatchno == null )  strbatchno = "";
	
					records[11]=request.getParameter("apprrefno"+i);
					strslmtapprrefno=records[11];
					if ( strslmtapprrefno == null )  strslmtapprrefno = "";
			
					records[12]=request.getParameter("saledraftno"+i);	
					strsaledraftno=records[12];
					if ( strsaledraftno == null )  strsaledraftno = "";
			
					records[13]=request.getParameter("payername"+i);
					strslmtpayername=records[13];
					if ( strslmtpayername == null )  strslmtpayername = "";
				
					records[14]=request.getParameter("recrefidno"+i);				
					strslmtidno = records[14];
					if(strslmtidno == null) strslmtidno="";

					records[15]=request.getParameter("ext_acc_interface_yn"+i);
					records[16]=request.getParameter("ext_acc_fac_id"+i);				
				
					records[17]=request.getParameter("onlineapproval"+i);
					if ( records[17] == null )  records[17] = "";
				
					records[18]=request.getParameter("instremarkcode"+i);
					if ( records[18] == null )  records[18] = "";
					v_strbank_cccode=records[18];
				
					records[19]=request.getParameter("shortdesc"+i);
					if ( records[19] == null )  records[19] = "";				 
					if(records[17].equals("checked"))
					{stronlineapproval="Y";}
					else{stronlineapproval="N";}
					
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->

					records[20]=request.getParameter("cc_term_id_num"+i);	
					strtermidnum = records[20];
					if ( strtermidnum == null )  strtermidnum = "";

					records[21]=request.getParameter("cc_trx_date_time"+i);	
					strtrxdatetime = records[21];
					if ( strtrxdatetime == null )  strtrxdatetime = "";


					System.out.println(" ************* strtermidnum... "+strtermidnum+ " ************** strtrxdatetime... "+ strtrxdatetime);
					
					//V210113 start
					records[22] = request.getParameter("couponcode"+i);
					if(records[22] == null) records[22] = "";
					strCoupon=records[22];
					records[23] = request.getParameter("couponAndAmt"+i);
					if(records[23] == null) records[23] = "";
					strcouponAndAmt=records[23];
					//V210113 end
//					intslmt_doc_sr_num=intslmt_doc_sr_num+i;
					existing_records_array.add(records);	
					
					v_stlmt_type_code=strslmttypecode.substring(0,2);
				
					//st_arr_slmt_doc_type_code = new StringTokenizer(str_arr_slmt_doc_type_code,"@@");
					//st_arr_slmt_doc_num = new StringTokenizer(str_arr_slmt_doc_num,"@@");
					//		System.out.println("proc_success FOR dtl :"+proc_success);
					//					 doc_num = st_arr_slmt_doc_num.nextToken();	
					//					 doc_type_code=st_arr_slmt_doc_type_code.nextToken();
					//	 				 System.out.println("doc_type_code token MULT DTL:"+doc_type_code);
					//					 System.out.println("doc_num tokrn MULT DTL:"+doc_num);		 

					if(proc_success.equals("Y"))
					{
						error_flag="";
						if(strslmtdocref.equals("COUPONS")) { strslmtdocref = "Coupons"; } //V210319
						//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->
						//call = con.prepareCall("{ call blopin.BILL_SLMT_DTL_PROC (?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");		
						//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
						call = con.prepareCall("{ call blopin.BILL_SLMT_DTL_PROC_1 (?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, to_date(?,'dd/mm/yyyy hh24:mi:ss'),?)}");
						call.setString(1, strEncounterFacilityId); //V210211
						//call.setString(1,strfacilityid); //V210211 commented
						call.setString(2,strpatientid);
						call.setString(3,strepisodetype);
						call.setString(4,strencounterid);
						call.setString(5,strepisodeid);
						call.setString(6,strvisitid);			
						call.setString(7,strbilldoctypecode);
						call.setString(8,strbilldocnum);
						call.setString(9,doc_type_code);
						call.setString(10,doc_num);
						call.setInt(11,intslmt_doc_sr_num);
						call.setString(12,strbillslmtamt);
						call.setString(13,v_stlmt_type_code);
						call.setString(14,strslmtdocref);
						call.setString(15,v_strslmtdocrefdate);
						call.setString(16,v_strbank_cccode);//strslmtdocrefremark
						call.setString(17,strslmtidno);
						call.setString(18,strrecrefformatind);
						call.setString(19,strprintrequestyn);			
						call.setString(20,strslmtpayername);
						call.setString(21,struser);
						call.setString(22,strclientip);
						call.setString(23,strclientname);
						call.setString(24,strslmtapprrefno);
						call.setString(25,stronlineapproval);
						call.setString(26,strbatchno);
						call.setString(27,strsaledraftno);
						call.setString(28,strrectype);
						call.setString(29,strextaccfacid);
						call.setString(30,strextacccode);
						call.setString(31,strextaccdept);
						call.setString(32,strCashgiven);
						call.setString(33,strCashreturn);			
						call.registerOutParameter(34,java.sql.Types.VARCHAR);	
						call.registerOutParameter(35,java.sql.Types.VARCHAR);	
						call.registerOutParameter(36,java.sql.Types.VARCHAR);
						//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
						call.setString(37,strccinstbranch);
						call.setString(38,strtermidnum);
						call.setString(39,strtrxdatetime);	
						call.setString(40,strcouponAndAmt); //V210113	
						call.execute();
	
						strerrorlevel		 = call.getString(34);	
						strsysmessageid		 = call.getString(35);		
						strerrortext     	 = call.getString(36);				
								
						if ( strerrorlevel == null ) strerrorlevel = "";
						if ( strsysmessageid == null ) strsysmessageid ="";
						if ( strerrortext == null ) strerrortext ="";
						call.close();	
						if ( strsysmessageid.equals("") && strerrortext.equals("") && strerrorlevel.equals(""))
						{

            _bw.write(_wl_block21Bytes, _wl_block21);
 //V210113 start
								if (!strCoupon.equals("")) { //V210224 
								
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strpatientid ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(struser ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strclientip ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strstlmtdoctypecode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strslmtdocnum ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strCoupon));
            _bw.write(_wl_block26Bytes, _wl_block26);
 } 
								//V210113 end
								
            _bw.write(_wl_block27Bytes, _wl_block27);

							//ram
							//con.commit();
							//call.close();
							//end
							proc_success="Y";
						}
			
						if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
						{		

            _bw.write(_wl_block28Bytes, _wl_block28);

						    con.rollback();
			
							if (strerrorlevel.equals("10") ||(!strerrortext.equals("")))
							{
								error_flag="";

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block30Bytes, _wl_block30);

								error_flag="true";
							}	
				
							if(!strsysmessageid.equals(""))
							{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block32Bytes, _wl_block32);

								error_flag="true";
							}
							proc_success="N";
						}
					}	
					i++;
					intslmt_doc_sr_num++;			
				}
				if(!error_flag.equals("") && error_flag.equals("true"))
				{
					session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
				//ADDED BY RAM CRF-13
				if(proc_success.equals("Y"))
				{
					if(hand_without_counter_chk_out.equals("Y"))
					{
						//String s_stlmt_type_code="",
						String s_str_rcpt_doc_amt="",s_strRecptDocAmt="";

						for(int tot_rec1=0;tot_rec1<total_records;tot_rec1++)
						{
							String[] records1=new String[20];
							records1[0]=request.getParameter("billslmtamt"+tot_rec1);	
							strbillslmtamt=records1[0];	
							if ( strbillslmtamt == null )  strbillslmtamt = "";

							s_strRecptDocAmt = s_strRecptDocAmt+strbillslmtamt+"~";
							s_str_rcpt_doc_amt=s_str_rcpt_doc_amt+"~"+records1[0];
							records1[1]=request.getParameter("slmttype"+tot_rec1);
							strslmttypecode =records1[1];
							if ( strslmttypecode == null )  strslmttypecode = "";
							v_stlmt_type_code=strslmttypecode.substring(0,2);
							str_slmt_type_code = str_slmt_type_code+v_stlmt_type_code+"~";

							//records1[20]=request.getParameter("cash_counter_code");

//							cash_counter_code =records1[20];
						}			
						call = con.prepareCall("{ call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");
				
						call.setString(1,strfacilityid);
						call.setString(2,struser);
						call.setString(3,cash_counter_code);
						call.setString(4,str_slmt_type_code);
						call.setString(5,s_str_rcpt_doc_amt);
						call.registerOutParameter(6,java.sql.Types.VARCHAR);	
						call.registerOutParameter(7,java.sql.Types.VARCHAR);	
						call.registerOutParameter(8,java.sql.Types.VARCHAR);
						call.execute();	
						strerrorlevel		 = call.getString(6);		
						strsysmessageid		 = call.getString(7);		
						strerrortext     	 = call.getString(8);				
				
						if ( strerrorlevel == null ) strerrorlevel = "";
						if ( strsysmessageid == null ) strsysmessageid ="";
						if ( strerrortext == null ) strerrortext ="";


						call.close();
						if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
						{
							//con.rollback();
							//con.close();
							if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
							{
								error_flag="";

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block36Bytes, _wl_block36);

								error_flag="true";
								proc_success="N";
								con.rollback();
							}
							if(!strsysmessageid.equals(""))
							{

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block38Bytes, _wl_block38);
								if(	strsysmessageid.equals("BL7340"))
								{
									error_flag="false";
									proc_success="Y";
								}
								else
								{
									error_flag="true";
									proc_success="N";
									con.rollback();
								}	
							}
	
						}		

						if(!error_flag.equals("") && error_flag.equals("true"))
						{
							session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block41Bytes, _wl_block41);

						}
					}//if
				}//process       
				
		/*********END CRF-13**************/
			if(proc_success.equals("Y"))
			{
				con.commit();
				if(str_bill_prt_format_YN.equals("Y") && !str_bill_prt_format_vals.equals(""))
				{					
					int docNum = 0;
					if("Y".equals(Slysite_spec)){
					try{
							pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
							docNum = Integer.parseInt(strbilldocnum);
							pstmt.setString(1,strfacilityid);							
							pstmt.setString (2,strbilldoctypecode);
							pstmt.setInt(3,docNum);
							rs = pstmt.executeQuery();
						 if(rs != null && rs.next()){
							 bill_print_reqd = rs.getString(1);
						   }
						 if("Y".equals(bill_print_reqd) && !"Y".equals(billAlreadyPrinted)) {
							asyncPrinterAttrib = new HashMap<String,String>();
							asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
							System.err.println("1077, validation.jsp asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
						}
						}
						 catch (SQLException e) {
								e.printStackTrace();
								System.err.println("1077");
							}							
						}
						else{
						/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
						asyncPrinterAttrib = new HashMap<String,String>();
						asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
						System.err.println("1093, validation.jsp asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
						session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
						out.println("<script>callAsyncOnlinePrint();</script>");
						}
					}
					con.commit();
				}
				else
				{
					con.rollback();
				}		
		
		if(proc_success.equals("Y"))
		{					
			if("Y".equals(Slysite_spec)){					
				if(strBlrRecpt == null || "".equals(strBlrRecpt) || "null".equals(strBlrRecpt)){
					strBlrRecpt = "BLRECPRT";
				}
				
				String separateReceiptQuery = "Select NVL(BILL_RECEIPT_SEPARATE_YN,'N') BILL_RECEIPT_SEPARATE_YN from BL_PARAMETERS where operating_facility_id = ? ";
				String prgParam = "Insert into sy_prog_param(operating_facility_id,pgm_id,session_id,pgm_date,param1,param2,param3,param4,param5,param6) values(?,?,?,?,?,?,?,?,?,?) ";				
				
				PreparedStatement pstmtReceipt = null;
				ResultSet rstReceipt = null;
				try{					
					pstmtReceipt = con.prepareStatement(separateReceiptQuery);
					pstmtReceipt.setString(1, strfacilityid);
					rstReceipt = pstmtReceipt.executeQuery();
					if(rstReceipt != null && rstReceipt.next()){
						separateReceipt = rstReceipt.getString("BILL_RECEIPT_SEPARATE_YN");
					}
					pstmtReceipt = null;
					rstReceipt = null;
						
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");
					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						session_id = st1.nextToken();
						pgm_date = st1.nextToken();
						mpi_id_rep = st1.nextToken();
					}
					
					if("Y".equals(separateReceipt)){
						pstmtReceipt = con.prepareStatement(prgParam);
						pstmtReceipt.setString(1, strfacilityid);
						pstmtReceipt.setString(2, "BLRECPRT");
						pstmtReceipt.setString(3, session_id);
						pstmtReceipt.setString(4, pgm_date);
						pstmtReceipt.setString(5, strstlmtdoctypecode);
						pstmtReceipt.setString(6, strstlmtdoctypecode);
						pstmtReceipt.setString(7, strslmtdocnum);
						pstmtReceipt.setString(8, strslmtdocnum);
						pstmtReceipt.setString(9, "P");
						//pstmtReceipt.setString(10, locale);
						Boolean printRcptSiteSpec = false;
						printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "ARABIC_REPORT_PRINT");
						if (printRcptSiteSpec) {
							if("BLRBLPRT_ALMOAR".equals(strBlrblprt)) {
							pstmtReceipt.setString(10, "ar");
						} else if("BLRBLPRT".equals(strBlrblprt)) {
							pstmtReceipt.setString(10, "en");
						} else {
							pstmtReceipt.setString(10, locale);
						}
					} else {
						pstmtReceipt.setString(10, locale);
					}
						pstmtReceipt.execute();
						con.commit();
					}
				}
				catch(Exception e){
					try{
						System.err.println("Exception in sy_prog_pram insertion "+e);
						//con.rollback();
					}
					catch(Exception e1){
						e1.printStackTrace();
						System.err.println("1169");
					}							
				}
				finally{
					//ConnectionManager.returnConnection(conReceipt);
					pstmtReceipt = null;							
				}	

				if(rec_print_format_enabled_yn.equals("Y") && !str_bill_prt_format_vals.equals("") && strerrortext.equals(""))
				{							
				if("Y".equals(separateReceipt)){						
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");
					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						session_id = st1.nextToken();
						pgm_date = st1.nextToken();
						mpi_id_rep = st1.nextToken();
						//function_id = st1.nextToken();//Added against GHL-CRF-0611 by NMuthu
					}																
					
					pgm_id = "BLRECPRT";
					//function_id ="A5_Online_YN";//Added against GHL-CRF-0611 by NMuthu
					str_bill_prt_format_vals =  pgm_id+"/"+session_id+"/"+pgm_date+"/"+mpi_id_rep;//Commented against GHL-CRF-0611 by NMuthu
					//str_bill_prt_format_vals =  pgm_id+"/"+session_id+"/"+pgm_date+"/"+mpi_id_rep+"/"+function_id;//Added against GHL-CRF-0611 by NMuthu
					asyncPrinterAttrib = new HashMap<String,String>();
					asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrRecpt);
					System.err.println("1208, validation.jsp asyncPrinterAttrib 2nd place->"+asyncPrinterAttrib);
					session.setAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT", asyncPrinterAttrib);
					out.println("<script type=\"text/javascript\">"); 
					out.println("callAsyncOnlineReceipt();");
					out.println("</script>"); 
					}
				}					
			}
		}
			if(proc_success.equals("Y"))
			{
					str_arr_slmt_doc_type_code=str_arr_slmt_doc_type_code.replaceAll("@@","/");
					str_arr_slmt_doc_num=str_arr_slmt_doc_num.replaceAll("@@","/");

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str_arr_slmt_doc_type_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(str_arr_slmt_doc_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(genmesg));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(final_msg));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(retrnValue));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
				System.out.println("Exception in MULTL RECPT "+ee);
			}
		}// end if 
		else
		{
			for(int tot_rec_serv=0;tot_rec_serv<total_records;tot_rec_serv++)
			{
				String[] records1=new String[20];
				records1[0]=request.getParameter("billslmtamt"+tot_rec_serv);	
				strbillslmtamt=records1[0];			
				if ( strbillslmtamt == null )  strbillslmtamt = "";
				strRecptDocAmt = strRecptDocAmt+strbillslmtamt+"|";
				
			}
			patMembershipID = request.getParameter("patMembershipID");
	//FOR HDR	
			if(proc_success.equals("Y"))	//SCRUMRELATED
			{
				//call = con.prepareCall("{ call blopin.BILL_SLMT_HDR_PROC (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				//Added by muthu against Arabic Language Issue on 12-6-12
				try{
				call = con.prepareCall("{ call blopin.BILL_SLMT_HDR_PROC_1 (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");				
				call.setString(1, strEncounterFacilityId); //V210211
				//call.setString(1,strfacilityid); //V210211 commented
				call.setString(2,strpatientid);
				call.setString(3,strepisodetype);
				call.setString(4,strencounterid);
				call.setString(5,strepisodeid);
				call.setString(6,strvisitid);
				call.setString(7,called_frm);//Added for GHL-45
				call.setString(8,alw_co_wit_bl_slmt_yn);//Added for GHL-45
				call.setString(9,strbilldoctypecode);
				call.setString(10,strbilldocnum);
				call.setString(11,strstlmtdoctypecode);		
				call.setString(12,strslmtamt);
				call.setString(13,strprintrequestyn);
				call.setString(14,struser);
				call.setString(15,strclientip);
				call.setString(16,strclientname);
				call.setString(17,strrectype);
				call.setString(18,strextaccfacid);			
				call.setString(19,strextacccode);
				call.setString(20,strextaccdept);
				call.setString(21,strrecordcount);//P_SLMT_LINE_CNT
				call.setString(22,"");//Added for SCRUM CRF-GHL-8.2
				call.registerOutParameter(11,java.sql.Types.VARCHAR);	
				call.registerOutParameter(23,java.sql.Types.VARCHAR);	
				call.registerOutParameter(24,java.sql.Types.VARCHAR);	
				call.registerOutParameter(25,java.sql.Types.VARCHAR);	
				call.registerOutParameter(26,java.sql.Types.VARCHAR);			
				call.registerOutParameter(27,java.sql.Types.VARCHAR);	
				call.registerOutParameter(28,java.sql.Types.VARCHAR);	
				call.setString(29,locale); //Added for Arabic Issue by Muthu on 12-6-12
				call.setString(30,patMembershipID);
				call.execute();									
				strstlmtdoctypecode	 = call.getString(11);	
				strslmtdocnum  	     = call.getString(23);	
				
				str_bill_prt_format_YN = call.getString(24);
				if(str_bill_prt_format_YN==null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

				str_bill_prt_format_vals = call.getString(25);
				if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";

				strerrorlevel		 = call.getString(26);		
				strsysmessageid		 = call.getString(27);		
				strerrortext     	 = call.getString(28);			
				}
				catch(Exception e){
					e.printStackTrace();
				}
				if ( strstlmtdoctypecode == null ) strstlmtdoctypecode = "";
				if ( strslmtdocnum == null ) strslmtdocnum = "";			
				if ( strerrorlevel == null ) strerrorlevel = "";
				if ( strsysmessageid == null ) strsysmessageid ="";
				if ( strerrortext == null ) strerrortext ="";	
				
				for(int tot_rec_serv=0;tot_rec_serv<total_records;tot_rec_serv++)
				{
					str_for_serv_slmt_doc_type_code = str_for_serv_slmt_doc_type_code+strstlmtdoctypecode+"|";
					str_for_serv_slmt_doc_num =str_for_serv_slmt_doc_num+strslmtdocnum+"|";
				}
		
				strRecptDocSrNo = strRecptDocSrNo+"1"+"|";

				if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
				{
					con.rollback();
					
					if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
					{
						error_flag="";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block7Bytes, _wl_block7);

						error_flag="true";
					}	
					if(!strsysmessageid.equals(""))
					{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block9Bytes, _wl_block9);

						error_flag="true";
					}
					proc_success="N";
				}
				if(!error_flag.equals("") && error_flag.equals("true"))
				{
						session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
			}
			//FOR SERVICE	
			//String slmt_doc_srno="";
			//String slmt_trn_type_code="";
			//String slmt_rcpt_nature_code="BI";
		//	String added_date=currdate;		
		//	int intServiceTotRec=Integer.parseInt(strServiceTotRec);
		
			if(proc_success.equals("Y"))
			{	
				/*for(int i=0;i<intServiceTotRec;i++);
				{
					StringTokenizer st = new StringTokenizer(strPendStlmt,"|");
					StringTokenizer st1 = new StringTokenizer(strCurrStlmt,"|");
					StringTokenizer st2 = new StringTokenizer(strSerDate,"|");
					StringTokenizer st3 = new StringTokenizer(strserDocRef,"|");
					StringTokenizer st4 = new StringTokenizer(strSerDocRefLine,"|");
					StringTokenizer st5 = new StringTokenizer(strSerDocRefSeq,"|");
			//		while(st.hasMoreTokens())
				//	{
						String strPendSlmt1=st.nextToken();
						String strCurrSlmt1=st1.nextToken();
						String strSerDate1=st2.nextToken();
						String strserDocRef1=st3.nextToken();
						String strSerDocRefLine1=st4.nextToken();
						String strSerDocRefSeq1=st5.nextToken();
						System.out.println("strSerDate1 :"+strSerDate1);

						if(!strSerDate1.equals(""))
						{
							strSerDate1=com.ehis.util.DateUtils.convertDate(strSerDate1,"DMYHMS",locale,"en");
						}*/
				String sql_check="{ call  BL_INSERT_DEPOSIT.BL_PROC_INSERT_SERV_RCPT_TABLE('"+strfacilityid+"','"+strserDocRef+"','"+strSerDocRefLine+"','"+strSerDocRefSeq+"','"+strBlngServCode+"','"+strbilldoctypecode+"','"+strbilldocnum+"','"+strepisodetype+"','"+strpatientid+"','"+strepisodeid+"','"+strvisitid+"','"+strCurrStlmt+"','"+strTrxDate+"','"+strSerDate+"','"+strPrtGrpHdrCode+"','"+strUpdNetChrgAmt+"','"+strPrtGrpLineCode+"','"+tot_rec_for_serv_insert+"',"+strrecordcount+",'"+struser+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+struser+"',TO_DATE('"+currdate+"','DD/MM/YYYY HH24:MI:SS'),'"+strUpdGrossChrgAmt+"','"+strclientname+"','"+strfacilityid+"','"+strclientname+"','"+strfacilityid+"','"+roundingamt+"','"+str_for_serv_slmt_doc_type_code+"','"+str_for_serv_slmt_doc_num+"','"+strRecptDocSrNo+"','"+strRecptDocAmt+"',?,?,?)}";					   
		
				call = con.prepareCall(sql_check);		
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.execute();   
				strerrorlevel		 = call.getString(1);		
				strsysmessageid		 = call.getString(2);		
				strerrortext     	 = call.getString(3);				
				if ( strerrorlevel == null ) strerrorlevel = "";
				if ( strsysmessageid == null ) strsysmessageid ="";
				if ( strerrortext == null ) strerrortext ="";
					
				call.close();	
			//	}
			
				if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
				{
					con.rollback();
//					con.close();
					if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
					{
						error_flag="";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block62Bytes, _wl_block62);

						error_flag="true";
					}
					if(!strsysmessageid.equals(""))
					{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block9Bytes, _wl_block9);

						error_flag="true";
					}
					proc_success="N";
				}

				if(!error_flag.equals("") && error_flag.equals("true"))
				{
					session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block65Bytes, _wl_block65);

				}
			//}
			}
			//FOR DEATAILS

			for(int i=0;i<total_records;i++)
			{
				//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->
				//String[] records=new String[22];  //V210113
				//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
				String[] records=new String[24];
				records[0]=request.getParameter("billslmtamt"+i);	
				strbillslmtamt=records[0];			
				if ( strbillslmtamt == null )  strbillslmtamt = "";

				records[1]=request.getParameter("slmttype"+i);
				strslmttypecode =records[1];
				if ( strslmttypecode == null )  strslmttypecode = "";

				records[2]=request.getParameter("cash_given"+i);
				strCashgiven=records[2];
				if ( strCashgiven == null )  strCashgiven = "";
				
				records[3]=request.getParameter("cash_return"+i);	
				strCashreturn=records[3];
				if ( strCashreturn == null )  strCashreturn = "";

				records[4]=request.getParameter("instref"+i);	
				strslmtdocref=records[4];
				if ( strslmtdocref == null )  strslmtdocref = "";

				records[5]=request.getParameter("instdate"+i);	
				v_strslmtdocrefdate=records[5];
				if ( v_strslmtdocrefdate == null )  v_strslmtdocrefdate = "";
			
				if(!v_strslmtdocrefdate.equals("")){
				v_strslmtdocrefdate=com.ehis.util.DateUtils.convertDate(v_strslmtdocrefdate,"DMY",locale,"en");}

				
				String slmtflag=strslmttypecode.substring(2);
				if(slmtflag.equals("A"))
				{
					if ( strbank_cccode == null )  strbank_cccode = "";
					records[6]=request.getParameter("creditcardco"+i);				
					strbank_cccode=records[6];
					records[7]="";
				}
				else
				{
					if ( strbank_cccode == null )  strbank_cccode = "";
					records[7]=request.getParameter("instbankname"+i);
					strbank_cccode=records[7];
					records[6]="";
				}
			
				if ( strbank_cccode == null )  strbank_cccode = "";
				records[8]=request.getParameter("instbranch"+i);	
				//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
				strccinstbranch = records[8];
				if ( strccinstbranch == null )  strccinstbranch = "";

				records[9]=request.getParameter("instremarkcode"+i);				
				records[10]=request.getParameter("batchno"+i);	
				strbatchno=records[10];
				if ( strbatchno == null )  strbatchno = "";
	
				records[11]=request.getParameter("apprrefno"+i);
				strslmtapprrefno=records[11];
				if ( strslmtapprrefno == null )  strslmtapprrefno = "";
			
				records[12]=request.getParameter("saledraftno"+i);	
				strsaledraftno=records[12];
				if ( strsaledraftno == null )  strsaledraftno = "";
			
				records[13]=request.getParameter("payername"+i);
				strslmtpayername=records[13];
				if ( strslmtpayername == null )  strslmtpayername = "";
				
				records[14]=request.getParameter("recrefidno"+i);				
				strslmtidno = records[14];
				if(strslmtidno == null) strslmtidno="";

				records[15]=request.getParameter("ext_acc_interface_yn"+i);
				records[16]=request.getParameter("ext_acc_fac_id"+i);				
				
				records[17]=request.getParameter("onlineapproval"+i);
				if ( records[17] == null )  records[17] = "";
			
				records[18]=request.getParameter("instremarkcode"+i);
				if ( records[18] == null )  records[18] = "";
				v_strbank_cccode=records[18];
			
				records[19]=request.getParameter("shortdesc"+i);
				if ( records[19] == null )  records[19] = "";	
				
				//Added by Sethu for GHL-SCF-1545 on 11/01/2021--> 

				records[20]=request.getParameter("cc_term_id_num"+i);	
				strtermidnum = records[20];
				if ( strtermidnum == null )  strtermidnum = "";

				records[21]=request.getParameter("cc_trx_date_time"+i);	
				strtrxdatetime = records[21];
				if ( strtrxdatetime == null )  strtrxdatetime = "";

				if(records[17].equals("checked"))
				{
					stronlineapproval="Y";
				}
				else
				{
					stronlineapproval="N";
				}

//				intslmt_doc_sr_num=intslmt_doc_sr_num+i;

				//records[20]=request.getParameter("cash_counter_code");	
				//V210113 start
					records[22] = request.getParameter("couponcode"+i); 
					if(records[22] == null) records[22] = "";
					strCoupon=records[22];
					records[23] = request.getParameter("couponAndAmt"+i); 
					if(records[23] == null) records[23] = "";
					strcouponAndAmt=records[23];
					//V210113 end						 
					
				existing_records_array.add(records);	
			
				v_stlmt_type_code=strslmttypecode.substring(0,2);
	
				if(proc_success.equals("Y"))
				{
					error_flag="";
					if(strslmtdocref.equals("COUPONS")) { strslmtdocref = "Coupons"; } //V210319						
					//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->
					//call = con.prepareCall("{ call blopin.BILL_SLMT_DTL_PROC (?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
					try{
					call = con.prepareCall("{ call blopin.BILL_SLMT_DTL_PROC_1 (?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?)}");
					call.setString(1, strEncounterFacilityId); //V210211
					//call.setString(1,strfacilityid); //V210211 commented
					call.setString(2,strpatientid);
					call.setString(3,strepisodetype);
					call.setString(4,strencounterid);
					call.setString(5,strepisodeid);
					call.setString(6,strvisitid);			
					call.setString(7,strbilldoctypecode);
					call.setString(8,strbilldocnum);
					call.setString(9,strstlmtdoctypecode);
					call.setString(10,strslmtdocnum);
					call.setInt(11,intslmt_doc_sr_num);
					call.setString(12,strbillslmtamt);
					call.setString(13,v_stlmt_type_code);
					call.setString(14,strslmtdocref);
					call.setString(15,v_strslmtdocrefdate);
					call.setString(16,v_strbank_cccode);//strslmtdocrefremark
					call.setString(17,strslmtidno);
					call.setString(18,strrecrefformatind);
					call.setString(19,strprintrequestyn);			
					call.setString(20,strslmtpayername);
					call.setString(21,struser);
					call.setString(22,strclientip);
					call.setString(23,strclientname);
					call.setString(24,strslmtapprrefno);
					call.setString(25,stronlineapproval);
					call.setString(26,strbatchno);
					call.setString(27,strsaledraftno);
					call.setString(28,strrectype);
					call.setString(29,strextaccfacid);
					call.setString(30,strextacccode);
					call.setString(31,strextaccdept);
					call.setString(32,strCashgiven);
					call.setString(33,strCashreturn);			
					call.registerOutParameter(34,java.sql.Types.VARCHAR);	
					call.registerOutParameter(35,java.sql.Types.VARCHAR);	
					call.registerOutParameter(36,java.sql.Types.VARCHAR);
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
					call.setString(37,strccinstbranch);
					call.setString(38,strtermidnum);
					call.setString(39,strtrxdatetime);	
					call.setString(40,strcouponAndAmt); //V210113
					call.execute();							
					strerrorlevel		 = call.getString(34);	
					strsysmessageid		 = call.getString(35);		
					strerrortext     	 = call.getString(36);				
							
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";
	
					call.close();	
					}
					catch(Exception e){
						e.printStackTrace();
					}
					if ( strsysmessageid.equals("") && strerrortext.equals("") && strerrorlevel.equals(""))
					{

            _bw.write(_wl_block66Bytes, _wl_block66);
 //V210113 start
							if (!strCoupon.equals("")) { //V210224
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strpatientid ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(struser ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strclientip ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strstlmtdoctypecode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strslmtdocnum ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strCoupon));
            _bw.write(_wl_block67Bytes, _wl_block67);
 }
							//V210113 end
							
            _bw.write(_wl_block68Bytes, _wl_block68);

						proc_success="Y";
						//con.commit();
						//call.close();
					}
			
					if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
					{		

            _bw.write(_wl_block69Bytes, _wl_block69);


						//con.rollback();
						//call.close();
			
						if (strerrorlevel.equals("10") ||(!strerrortext.equals("")))
						{
							error_flag="";

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block71Bytes, _wl_block71);

							error_flag="true";
						}	
				
						if(!strsysmessageid.equals(""))
						{

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block73Bytes, _wl_block73);

							error_flag="true";
						}
						proc_success="N";
					}
				}
				intslmt_doc_sr_num++;
			}
			/*if(proc_success.equals("Y"))
			{
				con.commit();
			}
			else
			{
				con.rollback();
				call.close();
			}*/
			if(!error_flag.equals("") && error_flag.equals("true"))
			{
				session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block75Bytes, _wl_block75);

			}

//ADDED BY RAM CRF-13
			if(proc_success.equals("Y"))
			{
				if(hand_without_counter_chk_out.equals("Y"))
				{
//					String s_stlmt_type_code="",
					String s_str_rcpt_doc_amt="",s_strRecptDocAmt="";

					for(int tot_rec1=0;tot_rec1<total_records;tot_rec1++)
					{
						String[] records1=new String[21];
						records1[0]=request.getParameter("billslmtamt"+tot_rec1);	
						strbillslmtamt=records1[0];	
						if ( strbillslmtamt == null )  strbillslmtamt = "";

						s_strRecptDocAmt = s_strRecptDocAmt+strbillslmtamt+"~";
						s_str_rcpt_doc_amt=s_str_rcpt_doc_amt+"~"+records1[0];
						records1[1]=request.getParameter("slmttype"+tot_rec1);
						strslmttypecode =records1[1];
						if ( strslmttypecode == null )  strslmttypecode = "";
						
						v_stlmt_type_code=strslmttypecode.substring(0,2);
				
						str_slmt_type_code = str_slmt_type_code+v_stlmt_type_code+"~";

						//records1[20]=request.getParameter("cash_counter_code");
						//cash_counter_code =records1[20];
					}
					call = con.prepareCall("{ call bl_proc_check_lmt(?,?,?,?,?,?,?,?)}");

					call.setString(1,strfacilityid);
					call.setString(2,struser);
					call.setString(3,cash_counter_code);
					call.setString(4,str_slmt_type_code);
					call.setString(5,s_str_rcpt_doc_amt);
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.execute();	
					strerrorlevel		 = call.getString(6);		
					strsysmessageid		 = call.getString(7);		
					strerrortext     	 = call.getString(8);				
			
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";

					if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
					{	
						//con.rollback();
						//con.close();		
						if(strerrorlevel.equals("10") && (!strerrortext.equals("")))
						{
							error_flag="";

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block77Bytes, _wl_block77);

							error_flag="true";
							proc_success="N";
							con.rollback();
						}
						if(!strsysmessageid.equals(""))
						{

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block79Bytes, _wl_block79);

							if(	strsysmessageid.equals("BL7340"))
							{
								error_flag="false";
								proc_success="Y";
							}
							else
							{
								error_flag="true";
								proc_success="N";
								con.rollback();
							}
						}
					}	
			
					if(!error_flag.equals("") && error_flag.equals("true"))
					{
						session.setAttribute("existing_records_array",existing_records_array);

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
				}	//if		
			}//proc
			/*********END CRF-13**************/
			if(proc_success.equals("Y"))
			{
				con.commit();

				if(str_bill_prt_format_YN.equals("Y") && !str_bill_prt_format_vals.equals(""))
				{		
					int docNum = 0;
					if("Y".equals(Slysite_spec)){
						try{
						pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
						docNum = Integer.parseInt(strbilldocnum);
						pstmt.setString(1,strfacilityid);							
						pstmt.setString (2,strbilldoctypecode);
						pstmt.setInt(3,docNum);
						  rs = pstmt.executeQuery();
						 if(rs != null && rs.next()){
							 bill_print_reqd = rs.getString(1);
						   }
						 if("Y".equals(bill_print_reqd)  && !"Y".equals(billAlreadyPrinted)) {
							asyncPrinterAttrib = new HashMap<String,String>();
							asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
							System.err.println("1829, asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
						}
						}
						 catch (SQLException e) {
								e.printStackTrace();
								System.err.println("1809");
							}
					}
					else{
					/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
					asyncPrinterAttrib = new HashMap<String,String>();
					asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
					System.err.println("1842, validation.jsp asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
					session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
					out.println("<script>callAsyncOnlinePrint();</script>");
					}					
				}
				con.commit();
			}
			else
			{
				con.rollback();
			}
			
			if(proc_success.equals("Y"))
			{
				//Added by Rajesh V - SCF 1140
				String separateReceiptQuery = "Select NVL(BILL_RECEIPT_SEPARATE_YN,'N') BILL_RECEIPT_SEPARATE_YN from BL_PARAMETERS where operating_facility_id = ? ";
				String prgParam = "Insert into sy_prog_param(operating_facility_id,pgm_id,session_id,pgm_date,param1,param2,param3,param4,param5,param6) values(?,?,?,?,?,?,?,?,?,?) ";
				
				//Connection conReceipt = null;
				PreparedStatement pstmtReceipt = null;
				ResultSet rstReceipt = null;
				try{
					//conReceipt = ConnectionManager.getConnection(request);
					pstmtReceipt = con.prepareStatement(separateReceiptQuery);
					pstmtReceipt.setString(1, strfacilityid);
					rstReceipt = pstmtReceipt.executeQuery();
					if(rstReceipt != null && rstReceipt.next()){
						separateReceipt = rstReceipt.getString("BILL_RECEIPT_SEPARATE_YN");
					}
					pstmtReceipt = null;
					rstReceipt = null;
					// IN48755 - Added by Karthik to resolve BL- On-Line Bill printing issue - Starts			
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						session_id = st1.nextToken();
						pgm_date = st1.nextToken();
						mpi_id_rep = st1.nextToken();
					}			
					
					strBlrRecpt="BLRECPRT";
					
					try{
						strBlrRecpt=BLReportIdMapper.getReportIdForReceipt(con, locale,strBlrRecpt,strfacilityid); //Added strfacilityid by subha for MMS-DM-CRF-131.1
					}catch(Exception e)
					{
						e.printStackTrace();
						System.err.println("Exception in BLBillSlmtValidation for reportID "+e);
					}					
					
					// IN48755 - Added by Karthik to resolve BL- On-Line Bill printing issue - Ends
					if("Y".equals(separateReceipt)){
						pstmtReceipt = con.prepareStatement(prgParam);
						pstmtReceipt.setString(1, strfacilityid);
						pstmtReceipt.setString(2, "BLRECPRT");
						pstmtReceipt.setString(3, session_id);
						pstmtReceipt.setString(4, pgm_date);
						pstmtReceipt.setString(5, strstlmtdoctypecode);
						pstmtReceipt.setString(6, strstlmtdoctypecode);
						pstmtReceipt.setString(7, strslmtdocnum);
						pstmtReceipt.setString(8, strslmtdocnum);
						pstmtReceipt.setString(9, "P");
						Boolean printRcptSiteSpec = false;
						printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
								"BL", "ARABIC_REPORT_PRINT");
						if (printRcptSiteSpec) {
							if("BLRBLPRT_ALMOAR".equals(strBlrblprt)) {
								pstmtReceipt.setString(10, "ar");
							} else if("BLRBLPRT".equals(strBlrblprt)) {
								pstmtReceipt.setString(10, "en");
							} else {
								pstmtReceipt.setString(10, locale);
							}
						} else {
							pstmtReceipt.setString(10, locale);
						}
						//pstmtReceipt.setString(10, locale);
						pstmtReceipt.execute();
						con.commit();
					}
				}
				catch(Exception e){
					try{
						System.err.println("Exception in sy_prog_pram insertion "+e);
						//con.rollback();
					}
					catch(Exception e1){
						e1.printStackTrace();
						System.err.println("1906");
					}					
				}
				finally{
					//ConnectionManager.returnConnection(conReceipt);
					pstmtReceipt = null;					
				}
				//Added by Rajesh V - SCF 1140				

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strstlmtdoctypecode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strslmtdocnum));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(strslmtamt));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(genmesg));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(retrnValue));
            _bw.write(_wl_block91Bytes, _wl_block91);

//Added by muthu on 13-7-12	
				if(rec_print_format_enabled_yn.equals("Y") && !str_bill_prt_format_vals.equals("") && strerrortext.equals(""))
				{					
					/* Code logic moved above by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
					//Added By Rajesh V - RUT-CRF0095
					String custIdRec = BLReportIdMapper.getCustomerId();
					//custId = "RUTNIN";
					if("RTN".equalsIgnoreCase(custIdRec)){
						System.err.println("Came to Bill Slmt Bill Recipt");
						//String billTypeId = BLReportIdMapper.getBillType(strepisodetype,called_frm,called_moduleId);
						strBlrRecpt = BLReportIdMapper.getReciptReportId(strfacilityid, strepisodetype, called_moduleId, "AD", "R");
					}
					if(strBlrRecpt == null || "".equals(strBlrRecpt) || "null".equals(strBlrRecpt)){
						strBlrRecpt = "BLRECPRT";
					}	
					
					/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/				
				if("Y".equals(separateReceipt)){				
					StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");
					while(st1.hasMoreTokens())
					{
						pgm_id = st1.nextToken();
						session_id = st1.nextToken();
						pgm_date = st1.nextToken();
						mpi_id_rep = st1.nextToken();
					}														
					
					pgm_id = "BLRECPRT";
					str_bill_prt_format_vals =  pgm_id+"/"+session_id+"/"+pgm_date+"/"+mpi_id_rep;
					asyncPrinterAttrib = new HashMap<String,String>();
					asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrRecpt);
					System.err.println("2055, validation.jsp asyncPrinterAttrib 2nd place->"+asyncPrinterAttrib);
					session.setAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT", asyncPrinterAttrib);
					out.println("<script type=\"text/javascript\">"); 
					out.println("callAsyncOnlineReceipt();");
					out.println("</script>"); 
					}
				}
			}
		}		//end else	 
		}
		else
		{
			if(!strbilldoctypecode.equals("") && !strbilldocnum.equals(""))
			{
				try
				{
					call = con.prepareCall("{ call blopin.CALL_BILL_PRINT_FRM_SLMT_NEW(?,?,?,?,?,?)}");			
					call.setString(1,strfacilityid);
					call.setString(2,strbilldoctypecode);
					call.setString(3,strbilldocnum);
					call.setString(4,locale);
					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.execute();	
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.err.println("Error while wexecuting CALL_BILL_PRINT_FRM_SLMT_NEW:"+e);
				}
				str_bill_prt_format_vals = call.getString(5);
				if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
				strerrortext     	 = call.getString(6);				
				if ( strerrortext == null ) strerrortext ="";
				
				if(bill_print_format_enabled_yn.equals("Y") && !str_bill_prt_format_vals.equals("") && strerrortext.equals(""))
				{					
					/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
					int docNum = 0;
					if("Y".equals(Slysite_spec)){
						try{
						pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
						docNum = Integer.parseInt(strbilldocnum);
						pstmt.setString(1,strfacilityid);							
						pstmt.setString (2,strbilldoctypecode);
						pstmt.setInt(3,docNum);
						  rs = pstmt.executeQuery();
						 if(rs != null && rs.next()){
							 bill_print_reqd = rs.getString(1);
						   }
						 if("Y".equals(bill_print_reqd) && !"Y".equals(billAlreadyPrinted)) {
							asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
							System.err.println("2035, asyncPrinterAttrib"+asyncPrinterAttrib);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
						}
						}
						 catch (SQLException e) {
								e.printStackTrace();
								System.err.println("2037");
							}						
					}
					else{
						asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
						System.err.println("2047, asyncPrinterAttrib"+asyncPrinterAttrib);
						session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
						out.println("<script>callAsyncOnlinePrint();</script>");
					}					
				}		

            _bw.write(_wl_block92Bytes, _wl_block92);

			}
		}
	}
	catch(Exception e )
	{	
		con.rollback();
		out.println(e);
	} 
	finally
	{
		if(stmt != null)stmt.close();
		con.close();	
		ConnectionManager.returnConnection(con, request);
	}
	/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
/* 	session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);	
	out.println("<script>callAsyncOnlinePrint();</script>"); */

            _bw.write(_wl_block93Bytes, _wl_block93);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block97Bytes, _wl_block97);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
