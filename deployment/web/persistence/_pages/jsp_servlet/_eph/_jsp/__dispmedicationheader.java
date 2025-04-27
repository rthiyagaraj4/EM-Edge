package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eXH.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationHeader.jsp", 1734671274538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?           created\n04/19/2017\tMMS-DM-SCF-0417   Manickavasagam\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\n04/19/2017\tBSP-SCF-0041\t  Mukesh\t\tAllocated Quantity is showing wrong when the batch gets expired before Allocated days\t\t \n08/10/2020\tIN73611             Shazana\t\tMMS-DM-CRF-0174.4\n7/7/2021\t\tTFS:9495\tShazana\t\t\t\t\tMOHE-CRF-0026.1\n10/12/2022     TFS:37091       Erappa             TH-KW-CRF-0020.3\n--------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" <!-- 37091 added -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n\t<head> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PPNRegimen.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>   \n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\n\t\ttable>*\n        {\n        \twhite-space: nowrap;\n        }      \n        \n</style>\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" onload=\"setfldFocus(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\"><!-- Added for Bru-HIMS-CRF-076 [IN:034551] -->\n\t\t<form name=\"DispMedicationAllStages\" id=\"DispMedicationAllStages\" >\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t<tr >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<td  width=\"9%\" style=\"background-color:#fde6d0;\">\n\t\t\t\t\t\t<font style=\'font-size:10px;cursor:pointer;color:blue;\' class=\"HYPERLINK\" onClick=\"showLastViewMedication(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"><b>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<b></font>  \n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t<td  nowrap  width=\"9%\" style=\"background-color:#fde6d0;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></font></td>\n\t\t\t\t\t<td  nowrap  width=\"9%\" style=\"background-color:#fde6d0;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";\"><font style=\'font-size:10px;cursor:pointer;color:blue;\'  onclick=\"openEditLabel(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'preview\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></font></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<td  nowrap  width=\"9%\" style=\"font-size:10px;background-color:#fde6d0\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></td>\n\t\t\t\t\t<td  style=\"font-size:10px;background-color:#fde6d0\" width=\"18%\">&nbsp;<b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></td>\n\t\t\t\t\t<td  nowrap  width=\"9%\" style=\"font-size:10px;background-color:#fde6d0\" >&nbsp;<b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" :</b></td>\n\t\t\t\t\t<td  style=\"font-size:10px;background-color:#fde6d0\" width=\"18%\">&nbsp;<b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<td style=\"background-color:#fde6d0\" align = \"center\" nowrap ><b><font style=\"font-size:9px;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  id =\"AddPPNLbl\"> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B> </font> </td>\n\t\t\t\t\t<td style=\"background-color:#fde6d0;\" align = \"center\" nowrap ><b><font style=\"font-size:9px;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" id =\"RemovePPNLbl\" > ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></B> </td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<td  nowrap  width=\"20%\" colspan=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"   align=\"right\" style=\"font-size:10px;background-color:#fde6d0\" >&nbsp;<b><a  style =\'font-size:9px\' href=\"javascript:callMedicalItemdetails(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </a></b></td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\n\t\t \t\t\t<td  nowrap  width=\"10%\"  style=\"font-size:10px;background-color:#fde6d0\" >&nbsp;<b><a  style =\'font-size:9px\' href=\"javascript:callMedicationPlanner(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'\',\'\')\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<td style=\"font-size:10px;background-color:#fde6d0\" width=\"2%\" align = \"right\" nowrap style=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" </td>\n\t\t\t\t\t<td class=\"label\" width=\"9%\" nowrap style=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"> <input size=\"3\" maxlength=\"3\" type = \"text\" name =\"durationVal\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\"text-align:right\" onKeyPress=\"if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}\" onchange=\" changeDurationValue(this,document.DispMedicationAllStages);\">&nbsp;\n\t\t\t\t\t\t<select name=\"durnType\" id=\"durnType\" onchange=\"changeDurationValue(document.DispMedicationAllStages.durationVal,document.DispMedicationAllStages)\" >\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<option value= \"H\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t<option value= \"D\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t\t\t<option value= \"W\" > ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t\t\t<option value= \"M\" > ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t\t\t<td  width=\"20%\"  style=\'text-align:right;\'>Barcode<input type=\"text\" class=\'fields\' name=\"barcode_id\" id=\"barcode_id\" style=\"text-align:right\"  onkeydown=\"if (event.keyCode==13 || event.keyCode==17) {callBarcodeflg(event,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');}\" maxlength=\"100\" size=50  >\n\t\t\t\t\t<!--Modified for IN073611 increased size to 80 -->\t\t\t\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<td  width=\"30%\"  style=\'text-align:right;\'>Barcode <input type=\"text\" class=\'fields\' name=\"barcode_id\" id=\"barcode_id\" style=\"text-align:right\"  onkeydown=\"if (event.keyCode==13) {callBarcodeflg(\'\',\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');}\" maxlength=\"100\"  ><!-- added \'\' begining for MMS-DM-CRF-0157.1 --> \n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t           <td   width=\"50%\"  style=\'text-align:left;\'><font style=\'font-size:10px;\'>Queue PKID</font> \n\t\t\t           <input id=\'quePkiId\' name=\'quePkiId\' id=\'quePkiId\' type=text size=\"25\" value=\'\' onBlur=\"getQUEPKICode(this)\">\n\t\t\t           <label name=\"quePkiId_res_name\" id=\"quePkiId_res_id\" value=\"\" />\n\t\t\t           </td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<td align=\"right\" nowrap><label>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</label> \n\t\t\t\t<input type=\"text\" value=\"\" maxlength=\"20\" name=\"approval_no\" id=\"approval_no\" onKeyPress=\"return KeyPressSpecCharsForApprovalNo(event)\" onBlur=\"CheckForSpecCharApprovalno(this,\'H\');\"><!-- modified for AAK-CRF-0117-->\n\t\t\t\t<input type=\"button\" value=\"Add\" onclick=\"getApprovalNum(this)\"></td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<td class=\"white\" align=\"right\"><input type=\"button\" value=\"Print\" class=\"button\" onclick = \"printPresAllocateAndFill(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\')\"></td><!-- GHL-CRF-453 and quotes added for GHL-SCF-1268-->\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t       ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t           <td   width=\"50%\" align=\"left\" nowrap ><font style=\'font-size:10px;\'>Queue PKID</font> \n\t\t           <input id=\'quePkiId\' name=\'quePkiId\' id=\'quePkiId\' type=text size=\"25\" value=\'\' onBlur=\"getQUEPKICode(this)\">\n\t\t           <label name=\"quePkiId_res_name\" id=\"quePkiId_res_id\" value=\"\" />\n\t\t           </td>\n\t\t          \n\t\t\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t<input type=hidden id=\"queue_pkid_appl\" name=\"queue_pkid_appl\" id=\"queue_pkid_appl\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/> <!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiStatus\" name=\"quePkiStatus\" id=\"quePkiStatus\" value=\"\"/><!--  //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiStatusText\" name=\"quePkiStatusText\" id=\"quePkiStatusText\" value=\"\"/><!-- \t//added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiToken\" name=\"quePkiToken\" id=\"quePkiToken\" value=\"\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiNumber\" name=\"quePkiNumber\" id=\"quePkiNumber\" value=\"\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiIsueDateTime\" name=\"quePkiIsueDateTime\" id=\"quePkiIsueDateTime\" value=\"\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"quePkiCallDateTime\" name=\"quePkiCallDateTime\" id=\"quePkiCallDateTime\" value=\"\"/>\t<!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"facility_id\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"referenceId\" name=\"referenceId\" id=\"referenceId\" value=\"\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t<input type=hidden id=\"user_id\" name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/><!-- //added for TH-KW-CRF-0020.3 -->\n\t\n\t\n\t\n \n  \t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<td  nowrap class=\"white\"></td>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t<td  nowrap  class=\"white\" border=\"none\" align=\"right\">\n\t\t\t\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" class=\"button\" onClick=\"showWorksheetForIVAdmixture(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'IV\')\" name=\"alloc_but\" ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\n\t\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<td  nowrap  class=\"white\" border=\"none\" align=\"right\">\n\t\t\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\',\'CO\')\" name=\"alloc_but\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\',\'CY\')\" name=\"alloc_but\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<td  nowrap  class=\"white\" border=\"none\" align=\"right\">\n\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" class=\"button\" onClick=\"showWorksheetForTPNAdmixture(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\')\" name=\"alloc_but\" ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\t\t\t</td>\t\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" class=\"button\"  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" onClick=\"callAllocate(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\',\'\',\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="  ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t<td  nowrap  class=\"white\" border=\"none\"  align=\"right\">\n\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">\n\t\t\t</td>\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">\n\t\t\t</td>\t\n\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t<td  nowrap  class=\"white\" border=\"none\" align=\"right\">\n\t\t\t\n\t\t\t\t<input type=\"button\" name=\"btnFill\" id=\"btnFill\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="  onClick=\"callAllocate(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\',\'\',\'F\')\">\n\t\t\t</td>\t\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\n\t\t<!-- MOHE-CRF-0026.1 -->\n\t\t\t<td  nowrap class=\"button\" align=\"right\">\n\t\t\t\t<input type=\"button\" name=\"btnAuthChk\" id=\"btnAuthChk\" value=\"Authorization Check\" class=\"button\"  onClick=\"callAuthCheck(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\');callInterface(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\',\'PHPREAUTH\');\"> \n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"button\" name=\"btnAuthStat\" id=\"btnAuthStat\" value=\"Authorization Status\" class=\"button\" onClick=\"callAuthStatus(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'PHSTATUS\');\"> \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="  \n\t\t\t<td  nowrap class=\"white\" align=\"right\">\n\t\t\t\t<input type=\"button\" name=\"btnDelivery\" id=\"btnDelivery\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" class=\"button\" ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" onClick=\"callDelivery(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\')\">\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<!-- MOHE-CRF-0026.1 -->\n\t\t\t<td  nowrap class=\"button\" align=\"right\">\n\t\t\t\t<input type=\"button\" name=\"btnAuthChk\" id=\"btnAuthChk\" value=\"Authorization Check\" class=\"button\"  onClick=\"callAuthCheck(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t<td  nowrap class=\"white\"></td>\n\t\t<td  border=\"none\" class=\"white\" align=\"right\">\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t<input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" style=\"font-size:12;cursor:pointer;text-align:center\"  name=\"delivery_but\"  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\')\"        >\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\"hidden\" name=\"issue_token_on_regn\" id=\"issue_token_on_regn\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_catg\" id=\"disp_locn_catg\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t<input type=\"hidden\" name=\"OrderIds\" id=\"OrderIds\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t<input type=\'hidden\' name=\'bar_code_scan_site_YN\' id=\'bar_code_scan_site_YN\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'><!--Added for MMS-DM-CRF-157.2-->\n            <input type=\'hidden\' name=\'entry_type\' id=\'entry_type\' value=\'\'><!--Added for MMS-DM-CRF-157.2-->\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'><!--Added for MMS-DM-CRF-157.2bl_patient_class-->\n\t\t\t<input type=\'hidden\' name=\'act_patient_episode_type\' id=\'act_patient_episode_type\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'><!--Added for MMS-DM-CRF-170-->\n\n\n\t\t</form>\n\t</body>\n\t<script>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\tcallAllStages(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\');\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\treloadFillPage();\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\tdocument.DispMedicationAllStages.durnType.value= \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\t\tdocument.DispMedicationAllStages.durationVal.onchange();\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		=   (String) session.getValue("facility_id");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String user_id = ((String)session.getValue("login_user")) == null ? "" : (String)session.getValue("login_user");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;  // added for AAKH-CRF-0117
	
	
try{//moved try above for MOHE-CRF-0026.1
	con				= ConnectionManager.getConnection(request);//moved from above in try block
	boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117
	boolean iqvia_integration_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","IQVIA_INTEGRATION");//MOHE-CRF-0026.1   
	boolean queue_pkid_appl =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_QMS_PATIENT_DTLS");//TH-KW-CRF-0020.3
	
	String settlement_id = "";  
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	
	String bean_id_1 = "DispMedicationAllStages" ;
	String bean_name_1 = "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;
	MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
	medplan_bean.clearMedPlan_DrugDetails();
	medplan_bean.clearMedPlan_Local_DrugDetails();
	medplan_bean.setStrTotal_gross_charge_amount("");
	medplan_bean.clearMediPlanSeqNo();
	medplan_bean.setMedValuesChanged(false);// Added for Bru-HIMS-CRF-072.1 [IN:049144] end
	String disp_stage = bean.getDispStage();	
	String order_id = request.getParameter("order_id");
	String patient_id = request.getParameter("patient_id");
	String sDispLocnCatg	=	bean.getDispLocnCatg();
	bean.setApprovalNoFlag(approval_no_flag);//AAKH-CRF-0117
	bean.setPatientID(patient_id);
	String barcode_flg="N";//Added for Bru-HIMS-CRF-076 [IN:034551]
	String iv_prep_yn = request.getParameter("iv_prep_yn");
	String fill_list = bean.getFillList();
	//Ading start for MMS-DM-CRF-157.1
	//con = ConnectionManager.getConnection(request);
      bean.setBarcodeSiteYN(con);
	  
	  String bar_code_scan_site_YN= bean.getBarcodeSiteYN();
//Ading end for MMS-DM-CRF-157.1
	
	boolean sPPNFlag	 = request.getParameter("PPNFlag")!=null?true:false; // This flag is used to stop reseting the filling page
																			 // if its from "Remove PPN" link
	// In the query criteria if the order type is "ALL" and the orders are admx orders then the order id should be set to ""
	if(iv_prep_yn != null && (bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR")) && !(iv_prep_yn.equals("2") || iv_prep_yn.equals("4") || iv_prep_yn.equals("0") || iv_prep_yn.equals("6"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		order_id = "";
	}

	String selectedOrderType = "";
	if(bean.getCriteriaOrderType().equals("ALL") || bean.getCriteriaOrderType().equals("CDR")){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
		if(iv_prep_yn == null || iv_prep_yn.equals("null"))
			selectedOrderType = "NOR";
		else if(iv_prep_yn.equals("1"))
			selectedOrderType = "IVAD";
		else if(iv_prep_yn.equals("2"))
			selectedOrderType = "IVAA";
		else if(iv_prep_yn.equals("3"))
			selectedOrderType = "IVID";
		else if(iv_prep_yn.equals("4"))
			selectedOrderType = "IVIA";
		else if(iv_prep_yn.equals("5"))
			selectedOrderType = "IVWA";
		else if(iv_prep_yn.equals("6"))
			selectedOrderType = "CO";
		else if(iv_prep_yn.equals("7"))
			selectedOrderType = "TD";
		else if(iv_prep_yn.equals("8"))
			selectedOrderType = "TA";
		else if(iv_prep_yn.equals("9"))
			selectedOrderType = "CD";
		else if(iv_prep_yn.equals("0"))
			selectedOrderType = "CA";

		bean.setOrderType(selectedOrderType);
	}
	
	selectedOrderType		= bean.getOrderType(); // this is required in case of specific order type search instead of ALL 
	String strOrderIds =  request.getParameter("orderIDS_trxRefIDS");
	// 1 - IV with additives (without admixture)
	// 2 - IV with additives( with admixture)
	// 3 - IV with piggy back( without admixture)	
	// 4 - IV with piggy back( with admixture)	
	// 5 - IV Without additives( continuous)
	// 6 - Compound Rx
	// 7 - TPN Standard Regimen (TPN Direct)
	// 8 - TPN Non-Standard Regimen (TPN Admixture)
	//out.println("iv_prep_yn"+iv_prep_yn);

   String disable_yn  ="";
   boolean bChangeValues = true;
	 if(((disp_stage.equals("F") && (bean.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean.getFillingStatus().equals("B")  )))&&(!bean.getDispLocnCatg().equals("I")) ){
	 	if(selectedOrderType.equals("IVAA") || selectedOrderType.equals("IVIA") || selectedOrderType.equals("CA") ||  selectedOrderType.equals("CO")){
			bChangeValues = false;
			disable_yn = "Y";
		}
		else{
			bean.setDurations(order_id);
			bChangeValues= bean.getEditValues();
			if(!bChangeValues)
				disable_yn = "Y";
		}
	}
	String	sDisableEditLabel	= "";
	String	sShowEditLabel	="";//display:none";
    String  billing_interface_yn =	request.getParameter("billing_interface_yn")==null?"N":request.getParameter("billing_interface_yn");
	String  encounter_id		 =	bean.getEncounterID();
	String  disp_locn_code	     =  bean.getDispLocnCode();
	String  store_desc           =  bean.getStoreDesc(disp_locn_code);
    String  orderIDS_trxRefIDS   =  request.getParameter("orderIDS_trxRefIDS");
	String  sysdate				 =  bean.getTodaysDate();
    String  order_type			 =	bean.getOrderType();
	String strDispLocationCategory = bean.getDispLocnCatg()==null?"":bean.getDispLocnCatg();
	String strDuration = "";
	String strDurationType = "";
	String alloc_durn_display="visibility:visible";
	String  bl_patient_class     =  bean_1.getEncounterPatientClass(encounter_id, patient_id);  // patient_id  added for [IN:035667] 
	if(bChangeValues){
		sDisableEditLabel		="<font style='font-size:10px;cursor:pointer;color:blue;'  onclick=openEditLabel('"+patient_id+"','edit','"+bl_patient_class+"')>";
	}
	else{
         sDisableEditLabel		="<font style='font-size:10px;color:gray;'>";
	}

	if(disp_stage.equals("V"))
		sShowEditLabel	="display:none";
	if(selectedOrderType.equals("IVAA") || selectedOrderType.equals("IVIA") || selectedOrderType.equals("CA") || selectedOrderType.equals("TA") || selectedOrderType.equals("TD") || selectedOrderType.equals("CO")|| !bean.getBEditDispLabelAfterDisp())
		sShowEditLabel	="display:none";

	String chk_group_by_patient	= bean.getChkGroupByPatient();
	if(chk_group_by_patient==null)
		chk_group_by_patient="E";
	Hashtable param_legends = bean.getLegendsFromParam();
	String issue_token_on_regn_yn = bean.getIssueTokenOnRegnYN();
	bean.setOrderID(order_id.trim());
	bean.setOrderID1(order_id.trim());

	String params		=	request.getQueryString();
	String disp_level	=	bean.getDispLevelValue();
	String colspan		=	"1";

	if(patient_id==null || patient_id.equals(""))
		patient_id      =bean.getSelectedPatientID();

    String scope        ="";
	if( (bean.getDispLocnCatg()).equals("I")) {
		scope				=	bean.getIPScope();
	} 
	else {
		scope				=	bean.getScope();
	}
	String butt_status			= ""; 
	if(scope.equals("H")){
        butt_status="disabled";
	}
	else{
		butt_status="";
	}
    String disp_butt_status			= ""; 
	if(disable_yn.equals("Y")){
          disp_butt_status="disabled";
	}
	else{
		  disp_butt_status="";
	}
	if(strDispLocationCategory.equals("O")){
		strDuration = bean.getStrOPDispPeriod();
		strDurationType = "D";
	}
	else if(strDispLocationCategory.equals("I")){
		if(fill_list.equals("WF")){ /* if block added for SRR20056-CRF-0663 */
			strDuration = bean.getIPFillDispPeriod();
			strDurationType = bean.getIPFillDispPeriodUnit();
		}
		if(strDuration==null || strDuration.equals("")|| strDurationType==null || strDurationType.equals("")) {/* if condition alone added for SRR20056-CRF-0663 */
			strDuration = bean.getStrIPFillPeriodAhead();
			strDurationType = bean.getStrIPFillPeriodUnit();
		}
		if(strDurationType.equals("P")){
			alloc_durn_display="display:none";
			strDuration        ="999";
			strDurationType    ="D";
		}
	}
	else{
		strDuration = "1";
		strDurationType = "D";
	}
	// If the page is loaded after the close of the Fill or allocate window, we need to restore the durn value from the window
	if(bean.getStrChangedDispensePeriod()!=null && !bean.getStrChangedDispensePeriod().equals("")){
		strDuration = bean.getStrChangedDispensePeriod();
		strDurationType = bean.getStrChangedDispenseUnit();
	}

	bean.setFillPeriod(strDuration);
	bean.setFillUnit(strDurationType);
	String prevEncouterID = bean.getPrevVisitEncounter(patient_id, encounter_id);
	//Added for Bru-HIMS-CRF-076 [IN:034551]
	bean.getBarCodeflg(facility_id,disp_locn_code);
	if(bean.getBarcode_Scan_YN().equals("Y")){
	    barcode_flg="Y";
	}  
	settlement_id = bean.getBillingGrp(patient_id, locale); //added for MOHE-CRF-0026.1 
	bean.setSettlementId(settlement_id);////end    

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(barcode_flg));
            _bw.write(_wl_block10Bytes, _wl_block10);

					if(prevEncouterID!=null && !prevEncouterID.equals("")){ //Added for RUT-CRF-0036[Inc:29925]

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sShowEditLabel));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sDisableEditLabel));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sShowEditLabel));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 
				if(disp_level.equals("P")) {	
					colspan	="5";	
				}	
				else{	

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

				}
				if(iv_prep_yn.equals("7") && disp_stage.equals("F")){
					String sPPNOpenFontStyle	= "";
					String sOpenPPN				= "";
					String sPPNRemoveFontStyle	= "";
					String sRemovePPN			= "";
					if(bean.getHmPPNValues() == null){
						sPPNOpenFontStyle	= "cursor:pointer;color:blue;";
						sPPNRemoveFontStyle	= "";				
						sOpenPPN			= "onclick=\"openAddPPN('"+patient_id+"','"+order_id+"','"+params+"')\" ";
						sRemovePPN	= "";
					}
					else{
						sPPNOpenFontStyle	= "";
						sPPNRemoveFontStyle	= "cursor:pointer;color:blue;";
						sOpenPPN		= "";
						sRemovePPN	= "onclick=openRemovePPN('"+params+"')";
					}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sPPNOpenFontStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sOpenPPN));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sPPNRemoveFontStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sRemovePPN));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
				 //if(!order_type.equals("CO")&&!order_type.equals("IVAA")&&!order_type.equals("IVIA")&&!order_type.equals("CA")&&!order_type.equals("TA")){
				 if(!order_type.equals("TD")&&!order_type.equals("TA")){
					if(disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")) {

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderIDS_trxRefIDS));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

					}
				}
				 if((disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D") || disp_stage.equals("AS")) && sDispLocnCatg.equals("O") && selectedOrderType.equals("NOR") && bean.getMedicationPlannerYN().equals("Y")) {	// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					 medplan_bean.setStrCalledFrom("Dispensing");

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
				}
				if(!disp_stage.equals("V") && !disp_stage.equals("D")&& disp_butt_status.equals("") && !fill_list.equals("AF")){ 

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alloc_durn_display));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alloc_durn_display));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strDuration));
            _bw.write(_wl_block45Bytes, _wl_block45);

						if(strDispLocationCategory.equals("I")){

            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

						}

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
	
				}
				//Added for Bru-HIMS-CRF-076 [IN:034551]
				if(barcode_flg.equals("Y") && !disp_stage.equals("V") && !disp_stage.equals("D")){ 
					bean.getStockDtl().put("barcode_applicable",barcode_flg);	
					if(bar_code_scan_site_YN.equals("Y")){//If considition added for MMS-DM-CRF-0157.1

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block53Bytes, _wl_block53);
			    
				}else{
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
				}else{
					bean.getBarCodesForDrug().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getStockDtl().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getOrderDrugdtl().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.getDrugQty().clear();//Added for KDAH-CRF-0231 [IN-034551]
					bean.setBarcode_multi_id("N");//Added for KDAH-CRF-0231 [IN-034551]
				}

			          //added for TH-KW-CRF-0020.3 start
		              if(queue_pkid_appl && ( disp_stage.equals("AS"))){
		 
            _bw.write(_wl_block56Bytes, _wl_block56);
     
			
				//added for TH-KW-CRF-0020.3 end
		}
				if(approval_no_flag && !disp_stage.equals("V")) //added for AAKH-CRF-0117 - start
				{
				

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

				} //added for AAKH-CRF-0117 - end
				//added for GHL-CRF-0453 
				if(iv_prep_yn==null)
					iv_prep_yn="";
				if(((disp_stage.equals("F")) || (disp_stage.equals("A"))) && !fill_list.equals("AF")){	// Added for IN064793 

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
   //added for TH-KW-CRF-0020.3 start
	              if(queue_pkid_appl && (disp_stage.equals("A") )){
	 
            _bw.write(_wl_block62Bytes, _wl_block62);
     
		
			//added for TH-KW-CRF-0020.3 end
	}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(queue_pkid_appl));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block66Bytes, _wl_block66);

		         

				if(disp_stage.equals("V")){

            _bw.write(_wl_block67Bytes, _wl_block67);

				}
				else if(disp_stage.equals("A")){
					if(iv_prep_yn==null)
						iv_prep_yn="";
					if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
						bean.setAdmixtureType("I");

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
					else if(iv_prep_yn.equals("6")){
						bean.setAdmixtureType("I");

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block71Bytes, _wl_block71);
	
					}
					else if(iv_prep_yn.equals("0")){
						bean.setAdmixtureType("C");

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block75Bytes, _wl_block75);
		}else if(iv_prep_yn != null && iv_prep_yn.equals("8")){
					bean.setAdmixtureType("TA");
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block79Bytes, _wl_block79);
		}else{
					if(iv_prep_yn != null && iv_prep_yn.equals("7") )
						bean.setAdmixtureType("TD");
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(param_legends.get("A")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block79Bytes, _wl_block79);

				}
			}else if(disp_stage.equals("F")){
					if(iv_prep_yn==null)
					iv_prep_yn="";
				if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
					bean.setAdmixtureType("I");
				

		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(param_legends.get("F")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block79Bytes, _wl_block79);

				}else if(iv_prep_yn.equals("6")){
					bean.setAdmixtureType("I");
		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(param_legends.get("F")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block85Bytes, _wl_block85);
		
				}else if(iv_prep_yn.equals("0")){
					bean.setAdmixtureType("C");
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(param_legends.get("F")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block86Bytes, _wl_block86);

				}else if(iv_prep_yn.equals("8")){
					bean.setAdmixtureType("TA");
		
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(param_legends.get("F")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block79Bytes, _wl_block79);

				}else{
					if(iv_prep_yn != null && iv_prep_yn.equals("7") )
						bean.setAdmixtureType("TD");
		
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(param_legends.get("F")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disp_butt_status));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block89Bytes, _wl_block89);

				}
			}else if(disp_stage.equals("D")){
				if(iqvia_integration_flag){//MOHE-CRF-0026.1  
				if( bl_patient_class.equalsIgnoreCase("O") && (settlement_id.equalsIgnoreCase("X")) && (iv_prep_yn==null || iv_prep_yn.equals("") || iv_prep_yn.equals("null")) ) {   
		
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block93Bytes, _wl_block93);
} //END 
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(param_legends.get("D")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(issue_token_on_regn_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
	}}else if(disp_stage.equals("AS")){	
				if(iv_prep_yn != null && iv_prep_yn.equals("S") )
				bean.setAdmixtureType("S");
				if(iqvia_integration_flag){//added for MOHE-CRF-0026.1 
				if( bl_patient_class.equalsIgnoreCase("O") && (settlement_id.equalsIgnoreCase("X")) && ( iv_prep_yn == null || iv_prep_yn.equals("") || iv_prep_yn.equals("null")) ) { //added for MOHE-CRF-0026.1
		
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block93Bytes, _wl_block93);
} }
            _bw.write(_wl_block99Bytes, _wl_block99);

				String filling_reqd			= "";
				String delivery_reqd		= "";
				String allocation_reqd		= "";
				String filling_status		= ""; 
				String display_seq			= "";
				String allocate_button		= "";
				String filling_button		= "";
				 butt_status			= "";
				if(scope.equals("H")){
                      butt_status="disabled";
				}else{
					  butt_status="";
				}
				String stages				=	bean.getStageDisplaySequence();
				filling_status				=	bean.getFillingStatus();

				StringTokenizer stages_token = new StringTokenizer(stages,":");
				while(stages_token.hasMoreTokens()){
					String stage	=	(String)stages_token.nextToken();
					if( stage.equals("F")) {
						filling_reqd = "Y";
						}
					else if( stage.equals("D")) {
						delivery_reqd = "Y";
					}
					else if( stage.equals("A")) {
						allocation_reqd = "Y";
						}
					else if( stage.equals("V")) {
						}
				}

				if(filling_status.equals("A")) 
				   display_seq	=	"A";
				else 
				   display_seq	=	"F";

				allocate_button = "<input type='button' class='button' value='"+param_legends.get("A")+"' style='font-size:12;cursor:pointer;text-align:center' onClick='callAllocate(\""+patient_id+"\",\""+order_id+"\",\"\",\"AS\",\"A\")' name='alloc_but' id='alloc_but' "+butt_status+">&nbsp;";
				filling_button	=	"<input type='button' class='button' value='"+param_legends.get("F")+"' style='font-size:12;cursor:pointer;text-align:center'     name='fill_but' id='fill_but' onClick='callFilling(\""+patient_id+"\",\""+order_id+"\",\"\",\"F\")' "+butt_status+">&nbsp;";

			

					if(display_seq.equals("A")) { 
						if(allocation_reqd.equals("Y")) {
							out.println(allocate_button);
						}	
						if(filling_reqd.equals("Y")) {
							out.println(filling_button);
						}	
					} else	{ 
						if(filling_reqd.equals("Y")) { 
						out.println(filling_button);
						}
						if(allocation_reqd.equals("Y")) {
						out.println(allocate_button);
						}
					}	
					 if(delivery_reqd.equals("Y")) { 
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(param_legends.get("D")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(butt_status));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(issue_token_on_regn_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
			
				 }

            _bw.write(_wl_block103Bytes, _wl_block103);

				}

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bean.getIssueTokenOnRegnYN()));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bean.getDispLocnCatg()));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bean_1.getModuleId()));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(strOrderIds));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(bean.getSFunctionId()));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bean.getBarcodeSiteYN()));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block117Bytes, _wl_block117);
	
		if(disp_stage.equals("AS")) {

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(params));
            _bw.write(_wl_block119Bytes, _wl_block119);

		}	
		if(sPPNFlag){

            _bw.write(_wl_block120Bytes, _wl_block120);

		}
		else if(!disp_stage.equals("V")  && !disp_stage.equals("D") && disp_butt_status.equals("") && !fill_list.equals("AF") && bChangeValues){ //&& !disp_stage.equals("AS") removed for MMS-SCF-417 //&& !disp_stage.equals("AS") removed for BSP-SCF-0041  
			if(strDurationType!=null && !strDurationType.equals("") && bean.getHmPPNValues() == null) {

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strDurationType));
            _bw.write(_wl_block122Bytes, _wl_block122);

		}
	}
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
	e.printStackTrace();
}finally{ // added for AAKH-CRF-0117 - start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request); // added for AAKH-CRF-0117 - end	
}

            _bw.write(_wl_block123Bytes, _wl_block123);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LastVisitRX.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Preview.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Label.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AddPPN.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RemovePPN.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicalItems.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationPlanner.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ALLOCATEDFOR.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WEEKS.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MONTHS.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalNo.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
