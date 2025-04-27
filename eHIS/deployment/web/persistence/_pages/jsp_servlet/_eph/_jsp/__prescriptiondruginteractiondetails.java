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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptiondruginteractiondetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionDrugInteractionDetails.jsp", 1741152512732L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n \n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link> <!-- added for MMS-KH-CRF-0029[IN070606] -->\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/Prescription_1.js\"></SCRIPT> \n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body >\n\t\t<form name=\"FormDrugInteractionsDetail\" id=\"FormDrugInteractionsDetail\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<TABLE name=\"DrugInteractionAlert\" id=\"DrugInteractionAlert\" cellpadding=0 cellspacing=0 width=\"110%\" align=\"center\" border=\"0\">   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr> <!-- MMS-KH-CRF-0029[IN070606] start-->\n\t\t\t\t\t\t\t\t<td width= \"180%\" class=\"white\">\n\t\t\t\t\t\t\t\t <ul id=\"tablist\" class=\"tablist\" >   \n\n\t\t\t\t\t\t\t\t <li class=\"tablistitem\" title=\'Drug-Drug\' style=\"display:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t\t\t <a onclick=\"tab_click1(\'Drug_tab\')\" class=\"tabClicked\" id=\"Drug_tab\" >\n\t\t\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"Drug_tabspan\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t<li class=\"tablistitem\" title=\'Drug-Lab\' style=\"display:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t\t\t <a onclick=\"tab_click3(\'DrugLab_tab\')\" class=\"tabA\" id=\"DrugLab_tab\" >\n\t\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"DrugLab_tabspan\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t <li class=\"tablistitem\" title=\'Drug Food\' style=\"display:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t\t\t <a onclick=\"tab_click2(\'DrugFood_tab\')\" class=\"tabA\" id=\"DrugFood_tab\" >\n\t\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"DrugFood_tabspan\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t<li class=\"tablistitem\" title=\'Drug Disease\' style=\"display:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\t\t <a onclick=\"tab_click4(\'DrugDisease_tab\')\" class=\"tabA\" id=\"DrugDisease_tab\" >\n\t\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"DrugDisease_tabspan\">\n\t\t\t\t\t\t\t\t\tDrug to Disease</span>\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<TABLE  cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width = \"100%\" align=\"center\" id=\"drug_interations\" style=\"display\"> \n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t<!--<td class=\"label\" width=\'2px\' style=\'vertical-align:top;\'><img value=\"\" src=\"../../ePH/images/redAlert.png\" height=\'40 \' width=\'40\'></img>  -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  class=\"label\" align=\'left\' style=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><label id=\'drugIntrAlertMsg1\'></label><br><label id=\'drugIntrAlertMsg2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</label><br><label id=\'drugIntrAlertMsg3\'></label></td > <!-- modified for MMS-KH-CRF-0029[IN070606] and removed decode for MMS-KH-SCF-0079-->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><!-- added for RUT-SCF-0318.1 [IN:046811] -->\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"PH_INTERACTION_ALERT\",\"PH\");\n\t\t\t\t\t\t\t\t\tvar\tmsg1 = getMessage(\"PH_INTERACTION_RESTRICT\",\"PH\");\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"$$$\",document.FormDrugInteractionsDetail.drug_desc.value);//added for RUT-SCF-0318.1 [IN:046811]\n\t\t\t\t\t\t\t\t\t//msg = msg.replace(\"###\",\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'); // Commented for FD-RUT-CRF-0066.1 [IN036975]\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"drugIntrAlertMsg1\").innerText=msg; //commented for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"drugIntrAlertMsg2\").innerText=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =".\';\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"drugIntrAlertMsg3\").innerText=msg1;\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\n\t\t\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width = \"100%\" align=\"center\" name=\"lab_interations\" id=\"lab_interations\" style=\"display\"> \n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<!--\t<td class=\"label\" width=\'2px\' style=\'vertical-align:top;\'><img value=\"\" src=\"../../ePH/images/redAlert.png\" height=\'40 \' width=\'40\'></img>-->\n\t\t\t\t\t\t\t\t<td  class=\"label\" align=\'left\' style=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><label id=\'labIntrAlertMsg1\'></label><br><label id=\'labIntrAlertMsg2\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =".</label><br><label id=\'labIntrAlertMsg3\'></label></td ><!-- modified for MMS-KH-CRF-0029[IN070606]  and removed decode for MMS-KH-SCF-0079-->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><!-- added for RUT-SCF-0318.1 [IN:046811] -->\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"PH_INTERACTION_ALERT\",\"PH\");\n\t\t\t\t\t\t\t\t\tvar\tmsg1 = getMessage(\"PH_INTERACTION_RESTRICT\",\"PH\");\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"$$$\",document.FormDrugInteractionsDetail.drug_desc.value);\n\t\t\t\t\t\t\t\t//\tdocument.getElementById(\"drugIntrAlertMsg1\").innerText=msg; commented for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"labIntrAlertMsg3\").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t\t<TABLE  cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width = \"100%\" align=\"center\" id=\"food_interations\" style=\"display\">  <!-- MMS-KH-CRF-0029[IN070606] start-->\n\t\t\t\t\t\t\t<tr > \n\t\t\t\t\t\t\t\t<!--<td class=\"label\" width=\'2px\' style=\'vertical-align:top;\'><img value=\"\" src=\"../../ePH/images/redAlert.png\" height=\'40 \' width=\'40\'></img> -->\n\t\t\t\t\t\t\t\t<td  class=\"label\" align=\'left\' style=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><label id=\'foodIntrAlertMsg1\'></label><br><label id=\'foodIntrAlertMsg2\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =".</label><br><label id=\'foodIntrAlertMsg3\'></label></td ><!-- modified for MMS-KH-CRF-0029[IN070606] -->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><!-- added for RUT-SCF-0318.1 [IN:046811] -->\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"PH_INTERACTION_ALERT\",\"PH\");\n\t\t\t\t\t\t\t\t\tvar\tmsg1 = getMessage(\"PH_INTERACTION_RESTRICT\",\"PH\");\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"$$$\",document.FormDrugInteractionsDetail.drug_desc.value);//added for RUT-SCF-0318.1 [IN:046811]\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t//msg = msg.replace(\"###\",\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'); // Commented for FD-RUT-CRF-0066.1 [IN036975]\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"drugIntrAlertMsg1\").innerText=msg;//commented for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"drugIntrAlertMsg2\").innerText=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"foodIntrAlertMsg3\").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width = \"100%\" align=\"center\" id=\"disease_interations\" style=\"display\"> \n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t<td  class=\"label\" align=\'left\' style=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><label id=\'diseaseIntrAlertMsg1\'></label><br><label id=\'diseaseIntrAlertMsg2\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =".</label><br><label id=\'diseaseIntrAlertMsg3\'></label></td >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"PH_INTERACTION_ALERT\",\"PH\");\n\t\t\t\t\t\t\t\t\tvar\tmsg1 = getMessage(\"PH_INTERACTION_RESTRICT\",\"PH\");\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"$$$\",document.FormDrugInteractionsDetail.drug_desc.value);\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"diseaseIntrAlertMsg3\").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tasync function toHoldDrugLab(){\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\tawait callDrugInteractionForDrug();\n\t\t\t\t\t\t\t\t\tawait Drug_tab.click();\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\tawait callDrugInteractionForLab();\n\t\t\t\t\t\t\t\t\t\tawait DrugLab_tab.click();//modified for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\tawait callDrugInteractionForDisease();\n\t\t\t\t\t\t\t\t\t\tawait DrugDisease_tab.click();//modified for MMS-DM-CRF-0229\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\tawait callDrugInteractionForFood(); //modified for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t\tawait DrugFood_tab.click();\t\t\t//modified for MMS-KH-CRF-0029[IN070606]\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t}toHoldDrugLab();\n\t\t\t\t\t\t</script>\n\t\t\t\t        \n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<TABLE name=\"DrugInteractionList\" id=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td >\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">    \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;</td >\n</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\'15%\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<!--  //MMS-KH-CRF-0029 - start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t\t\t \n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\tDrug Name\n\t\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" commented RUT-SCF-0319 [IN:044814] -->\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t\tGeneric Name\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td width=\'*\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\"><b>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</b></td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr><!-- display added for MMS-KH-CRF-0029-->\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC;display:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >Dosage Form \n\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC;display:";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Severity&nbsp;Level\n\t\t\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\t\n\t\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tMajor\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tModerate\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t\tMinor\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Significant&nbsp;Level\n\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Documentation\n\t\t\t\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" commented RUT-SCF-0319 [IN:044814] -->\n\t\t\t\t\t\t\t\t\t\t</td >  <!-- Modified for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\n\t\t\t\t\t\t\t\t                   <!--";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="-->\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t   \t\t\t\t<!--\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tEstablished\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tProbable\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tSuspected\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tPossible\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t\t\tUnlikely\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">RestrictTransaction\n\t\t\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\t\t\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/disabled.gif\'>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Interaction&nbsp;Description\n\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t</td > \n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\"><textarea readonly=\"false\"  style=\"BACKGROUND-COLOR:#FFFFCC;border: none;overflow: auto;\" cols=\"80\" >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</textarea></td> <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t<tr> <td style=\"BACKGROUND-COLOR:#FFFFCC\">Lab Result(s)&nbsp;</td> <!--MMS-KH-CRF-0034.4-->\n\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:white\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t<tr> <td colspan=\'2\' style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t<TABLE name=\"DrugInteractionList\" id=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t<TABLE name=\"DrugInteractionList\" id=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td >\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
08/11/2019  IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
15/07/2020  IN073414                Manickavasagam J                       MMS-KH-SCF-0079
30/08/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.2[IN073795]
02/09/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			try{
				java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
				String patient_id				=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
				String drug_code		        = request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
				String srl_no		        = request.getParameter( "srl_no" )==null?"":request.getParameter("srl_no");
				String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
				String bean_name		= "ePH.PrescriptionBean_1";
				String calledFor		        = request.getParameter( "calledFor" )==null?"":request.getParameter("calledFor");
				String intr_restric_trn		        = request.getParameter( "intr_restric_trn" )==null?"":request.getParameter("intr_restric_trn");
				String CalledFrom		        = request.getParameter( "CalledFrom" )==null?"":request.getParameter("CalledFrom");
				String fontStyle="font-size:12;";
				String order_id		        = request.getParameter( "order_id" )==null?"":request.getParameter("order_id");
				String order_line_no		        = request.getParameter( "order_line_no" )==null?"":request.getParameter("order_line_no");
				//String fontStyle="font-size:12;";
				if(order_id==null || order_id.equals("undefined"))
					order_id="";
				ArrayList prescriptionDetails = null;
				PrescriptionBean_1 bean_1 = null; //MMS-KH-CRF-0034.4
				
				

				if(CalledFrom.equals("DD")){
					bean_id					= "DirectDispensingBean";
					bean_name		= "ePH.DirectDispensingBean";
					DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
				}
				else{
					PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
				}
				// MMS-KH-CRF-0034.4
				if(CalledFrom.equals("") && !order_id.equals("")){
					bean_1 = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
				}

				if(prescriptionDetails!=null && prescriptionDetails.size()>0){
					int     recordcount    =   0;
					String intr_option,intr_name, severity_level, significant_level, probability, interaction_desc, restrict_transaction, ext_drug_code, ext_srl_no, drug_desc="", form_desc="",interaction_type="";//MMS-KH-CRF-0029[IN070606]
					StringBuffer intr_names = new StringBuffer();
					StringBuffer intr_msg_content = new StringBuffer();
				//added for MMS-KH-CRF-0029[IN070606] - start
					StringBuffer intr_msg_content_drug_drug = new StringBuffer();
					StringBuffer intr_msg_content_drug_food = new StringBuffer();
					StringBuffer intr_msg_content_drug_lab = new StringBuffer();
					StringBuffer intr_msg_content_drug_disease = new StringBuffer();//Added for MMS-DM-CRF-0229
				//added for MMS-KH-CRF-0029[IN070606] - end
					StringBuffer test_result_content = null; //MMS-KH-CRF-0034.2
					String return_flag_yn = ""; // MMS-KH-CRF-0034.4
					String test_result_value = ""; // MMS-KH-CRF-0034.4

					boolean msgRestrictTrans = false;
					ArrayList intrType = new ArrayList();//MMS-KH-CRF-0029[IN070606]
					
					ArrayList hmDrugIntList=null;
					HashMap ext_drugData=null;
					HashMap DrugInteractionDtl=null;
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData=(HashMap) prescriptionDetails.get(j);

						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");

						if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
							drug_desc=(String) ext_drugData.get("DRUG_DESC");
							form_desc=(String) ext_drugData.get("FORM_DESC");
							hmDrugIntList=(ArrayList) ext_drugData.get("INTERACTION_DTL");
							break;
						}
					}
					if(calledFor.equals("Alert")){
						//added for MMS-KH-CRF-0029[IN070606] - start
						ArrayList drugDrugInteractionList = new ArrayList();
						ArrayList drugFoodInteractionList = new ArrayList();
						ArrayList drugLabInteractionList = new ArrayList();
						ArrayList drugDiseaseInteractionList = new ArrayList();
						
						//added for MMS-KH-CRF-0029[IN070606] - end						
						if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
							for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
								intr_msg_content = new StringBuffer(); //MMS-KH-CRF-0029[IN070606]
								DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
								intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
								intr_name = (String)DrugInteractionDtl.get("intr_name");
								severity_level = (String)DrugInteractionDtl.get("severity_level");
								significant_level = (String)DrugInteractionDtl.get("significant_level");
								probability = (String)DrugInteractionDtl.get("probability");
								restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
								interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
								interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2"); //MMS-KH-CRF-0029[IN070606]
								// MMS-KH-CRF-0034.2 - start
								return_flag_yn = (String)DrugInteractionDtl.get("return_flag_yn");
								test_result_value = (String)DrugInteractionDtl.get("test_result_value");
								if(test_result_value==null)
									test_result_value = "";
								if(return_flag_yn==null)
									return_flag_yn = "";

								// MMS-KH-CRF-0034.2 - end

								intrType.add(interaction_type);//MMS-KH-CRF-0029[IN070606]
								//if(severity_level.equals("H") || restrict_transaction.equals("Y")){
									if(intr_names.length()>0)
										intr_names.append("");
									intr_names.append(intr_name);
									//MMS-KH-CRF-0029[IN070606] - start
									if(intr_msg_content.length()>0)
										intr_msg_content.append(","); 

									/*if(drugDrugInteractionList.size()>0)
										intr_msg_content.append("<hr>" + drug_desc +" Interact with  " );
									if(drugFoodInteractionList.size()>0)
										intr_msg_content.append("<hr>" + drug_desc +" Interact with   ");
									if(drugLabInteractionList.size()>0)
										intr_msg_content.append("<hr>"+ drug_desc +" Interact with ") ; */
									//MMS-KH-CRF-0029[IN070606] - end

									intr_msg_content.append(intr_name+" <br> "+interaction_desc+" <br> ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SeverityLevel.label", "ph_labels")+" - ");  // Modified '[' as '(' for FD-RUT-CRF-0066.1 [IN036975] added encode for interaction_desc for MMS-KH-CRF-0029 and removed for MMS-KH-SCF-0079
									if(severity_level.equals("L"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Minor.label", "ph_labels"));
									if(severity_level.equals("M"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Moderate.label", "common_labels"));
									if(severity_level.equals("H"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Major.label", "ph_labels"));
									//intr_msg_content.append(" and "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SiginificantLevel.label", "ph_labels")+" "+significant_level);  // Commented and Added below for FD-RUT-CRF-0066.1 [IN036975]
									intr_msg_content.append(") , ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SignificantLevel.label", "ph_labels")+" - "+significant_level);
									intr_msg_content.append(") "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.and.label", "common_labels"));
									//intr_msg_content.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.documentation.label", "ph_labels")+" - ");
									intr_msg_content.append(" ( Documentation - ");
									if(probability.equals("E")) // added for FD-RUT-CRF-0066.1 [IN036975] --begin
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.established.label", "ph_labels"));
									else if(probability.equals("P"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Probable.label", "common_labels"));
									else if(probability.equals("S"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.suspected.label", "ph_labels"));
									else if(probability.equals("O"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Possible.label", "ph_labels"));
									else if(probability.equals("U"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Unlikely.label", "ph_labels"));
									intr_msg_content.append(")"); // added for FD-RUT-CRF-0066.1 [IN036975] --end
									if(restrict_transaction.equals("Y")){
									//	intr_msg_content.append(", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RestrictTransaction.label", "ph_labels")); // Commented for FD-RUT-CRF-0066.1 [IN036975]
										msgRestrictTrans = true;
									}
									if(severity_level.equals("H"))
										fontStyle ="color:red;font-size:12;";
									else										// added for FD-RUT-CRF-0066.1 [IN036975] 
										fontStyle ="color:blue;font-size:12;";  
									//intr_msg_content.append("]"); // Commented for FD-RUT-CRF-0066.1 [IN036975]
								//}
								//MMS-KH-CRF-0029[IN070606] - start
								if(interaction_type.equals("D") || interaction_type.equals("G")){	
									//intr_msg_content_drug_drug.append(drug_desc + " Interact with " +intr_msg_content);
									drugDrugInteractionList.add(drug_desc + " Interact with " +intr_msg_content.toString());
								}
								if(interaction_type.equals("F")){	
									//intr_msg_content_drug_food.append(drug_desc + " Interact with  " +intr_msg_content);
									drugFoodInteractionList.add(drug_desc + " Interact with  " +intr_msg_content.toString());
								}
								if(interaction_type.equals("L")){	
									test_result_content = new StringBuffer();

									if(return_flag_yn.equals("YY") || return_flag_yn.equals("YN")){

								//added for MMS-KH-CRF-0034.2 - start 
									  if(!test_result_value.equals("") ){ 
										String lab_test_result_grp = "";
										StringTokenizer strToken = null;
										String token_value = "";
										String prev_token = "";
										String test_result[] = test_result_value.split("##");
							test_result_content.append("----------------------------------------------------------");
							test_result_content.append("-------------------------------------------");
							//test_result_content.append("<br><br>");
										if(test_result.length>1){
										 for(int j=0;j<test_result.length;j++){
										    lab_test_result_grp= test_result[j];
											strToken = new StringTokenizer(lab_test_result_grp,"$$");
											token_value = "";
											prev_token  = "";
											while(strToken.hasMoreTokens())
											{
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											//	test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");
											}
											test_result_content.append("<br><br>");
										 }
										}else{

											lab_test_result_grp= test_result[0];
										
										strToken = new StringTokenizer(lab_test_result_grp,"$$");
										token_value = "";
										prev_token  = "";
										while(strToken.hasMoreTokens())
										{
											/*token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:11'>");
											}
											if(!token_value.equals("Low"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");
											*/
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
										}
											test_result_content.append("<br><br>");
										}
							test_result_content.append("----------------------------------------------------------");
							test_result_content.append("-------------------------------------------");
							//test_result_content.append("<br><br>");

									  }
									}
									//added for MMS-KH-CRF-0034.2 - start
									//intr_msg_content_drug_lab.append(drug_desc + " Interact with " +intr_msg_content);
							drugLabInteractionList.add(drug_desc + " Interact with " +intr_msg_content.toString()+"<table><tr><td style='BACKGROUND-COLOR:#FFFFCC' ><label  style='color:black;font-size:11'><br><br>"+test_result_content.toString()+"</label></td></tr></table>");
								}
								if(interaction_type.equals("I")){	//Added for MMS-DM-CRF-0229
									drugDiseaseInteractionList.add(drug_desc + " Interact with  " +intr_msg_content.toString());
								}
								//MMS-KH-CRF-0029[IN070606] - start								
							}
						}
						//MMS-KH-CRF-0029[IN070606] - start
						String drug_drug_display = "none";
						String drug_food_display = "none";
						String drug_lab_display = "none";
						String drug_disease_display = "none";//Added for MMS-DM-CRF-0229
						if(intrType!=null && intrType.size()>0){
						if(intrType.contains("D") || intrType.contains("G")){
							drug_drug_display = "inline";
						}
						if(intrType.contains("F")){
							drug_food_display = "inline";
						}
						if(intrType.contains("L")){
							drug_lab_display = "inline"; 
						}
						if(intrType.contains("I")){
							drug_disease_display = "inline"; 
						}

						}

					//MMS-KH-CRF-0029[IN070606] - start	
						if(drugDrugInteractionList!=null && drugDrugInteractionList.size()>0){
							 intr_msg_content_drug_drug = new 	StringBuffer();
							for(int i=0;i<drugDrugInteractionList.size();i++){
								if(i>0)
									intr_msg_content_drug_drug.append("<hr size=1>");
								intr_msg_content_drug_drug.append(drugDrugInteractionList.get(i));
								
							}
							intr_msg_content_drug_drug = new 	StringBuffer(intr_msg_content_drug_drug.toString()); //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
						if(drugFoodInteractionList!=null && drugFoodInteractionList.size()>0){
						
							intr_msg_content_drug_food = new 	StringBuffer();
							for(int i=0;i<drugFoodInteractionList.size();i++){
								if(i>0)
									intr_msg_content_drug_food.append("<hr size=1>");

								intr_msg_content_drug_food.append((String)drugFoodInteractionList.get(i));
														}
							intr_msg_content_drug_food = new 	StringBuffer(intr_msg_content_drug_food.toString());//Removed the encode for MMS-KH-CRF-0029
						}
						if(drugLabInteractionList!=null && drugLabInteractionList.size()>0){
						intr_msg_content_drug_lab = new 	StringBuffer();
							for(int i=0;i<drugLabInteractionList.size();i++){
							if(i>0)
								intr_msg_content_drug_lab.append("<hr size=1>");

								intr_msg_content_drug_lab.append((String)drugLabInteractionList.get(i));
								
							}
							intr_msg_content_drug_lab = new 	StringBuffer(intr_msg_content_drug_lab.toString());  //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
					//	System.err.println("drugDiseaseInteractionList@@==="+drugDiseaseInteractionList);
						if(drugDiseaseInteractionList!=null && drugDiseaseInteractionList.size()>0){//Adding start for MMS-DM-CRF-0229
						intr_msg_content_drug_disease = new 	StringBuffer();
							for(int i=0;i<drugDiseaseInteractionList.size();i++){
							    if(i>0)
								intr_msg_content_drug_disease.append("<hr size=1>");

								intr_msg_content_drug_disease.append((String)drugDiseaseInteractionList.get(i));
								
							}
							intr_msg_content_drug_disease = new 	StringBuffer(intr_msg_content_drug_disease.toString());  
						}//Adding end for MMS-DM-CRF-0229

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_drug_display));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_lab_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_food_display));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_disease_display));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fontStyle));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(intr_msg_content_drug_drug.toString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intr_names.toString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(intr_msg_content.toString()));
            _bw.write(_wl_block22Bytes, _wl_block22);

									if(msgRestrictTrans){

            _bw.write(_wl_block23Bytes, _wl_block23);

									}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fontStyle));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(intr_msg_content_drug_lab.toString()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

									if(msgRestrictTrans){

            _bw.write(_wl_block28Bytes, _wl_block28);

									}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fontStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(intr_msg_content_drug_food.toString()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(intr_names.toString()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(intr_msg_content.toString()));
            _bw.write(_wl_block22Bytes, _wl_block22);

									if(msgRestrictTrans){

            _bw.write(_wl_block34Bytes, _wl_block34);

									}
System.err.println("intr_msg_content_drug_lab=====300=>"+intr_msg_content_drug_lab);

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fontStyle));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(intr_msg_content_drug_disease.toString()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

									if(msgRestrictTrans){

            _bw.write(_wl_block39Bytes, _wl_block39);

									}

            _bw.write(_wl_block40Bytes, _wl_block40);
  //MMS-KH-CRF-0029[IN070606] - start
							if(intrType!=null && intrType.size()>0){
								
								if(drug_drug_display.equals("inline")){

            _bw.write(_wl_block41Bytes, _wl_block41);
	
								}else{
									if(drug_lab_display.equals("inline")){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
									}else if(drug_disease_display.equals("inline")){ 
            _bw.write(_wl_block43Bytes, _wl_block43);
									}else{ 
            _bw.write(_wl_block44Bytes, _wl_block44);
									}
								}

							} //MMS-KH-CRF-0029[IN070606] - end
						
            _bw.write(_wl_block45Bytes, _wl_block45);

					}
					else{
						if(hmDrugIntList!=null && hmDrugIntList.size()> 2){

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
								String intr_desc = "";  //MMS-KH-CRF-0029
								String drug_dosage_display = "inline"; //MMS-KH-CRF-0029
								String intr_code = ""; // MMS-KH-CRF-0034.4
								
								for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
									DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
									intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
									intr_name = (String)DrugInteractionDtl.get("intr_name");
									severity_level = (String)DrugInteractionDtl.get("severity_level");
									significant_level = (String)DrugInteractionDtl.get("significant_level");
									probability = (String)DrugInteractionDtl.get("probability");
									restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
									interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
									form_desc = (String)DrugInteractionDtl.get("form_desc")==null?"":(String)DrugInteractionDtl.get("form_desc");
									test_result_value = (String)DrugInteractionDtl.get("test_result_value"); // MMS-KH-CRF-0034.4
									intr_code = (String)DrugInteractionDtl.get("intr_code")==null?"":(String)DrugInteractionDtl.get("intr_code"); // MMS-KH-CRF-0034.4
									interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");  //MMS-KH-CRF-0029 - start
									if(interaction_type.equals("F")){
										intr_desc = "Drug-Food";
										drug_dosage_display	="none";
									}
									else if(interaction_type.equals("L")){
										intr_desc = "Drug-Lab";
										drug_dosage_display	="none";
									}else if(interaction_type.equals("I")){
										intr_desc = "Drug-Disease";
										drug_dosage_display	="none";
									}
									else{
										intr_desc = "Drug-Drug";
										drug_dosage_display	="inline";
									}
									if(interaction_type.equals("L")){
										test_result_content = new StringBuffer();
									 if(CalledFrom.equals("") && !order_id.equals("")){
									 test_result_value= bean_1.getLabTestResult(order_id,order_line_no,drug_code,intr_code);
								//	  System.err.println("test_result_value=495==>"+test_result_value);
									 }
								//	 System.err.println("test_result_value=498==>"+test_result_value);
									if(!test_result_value.equals("") ){ 
										String lab_test_result_grp = "";
										StringTokenizer strToken = null;
										String prev_token = "";
										String token_value = "";
										String test_result[] = test_result_value.split("##");
//										test_result_content.append("<label style='color:black;font-size:9'>");
										if(test_result.length>1){
										 for(int j=0;j<test_result.length;j++){
										    lab_test_result_grp= test_result[j];
											strToken = new StringTokenizer(lab_test_result_grp,"$$");
											token_value = "";
											prev_token  = "";
											while(strToken.hasMoreTokens())
											{
												//test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											//	test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");

											}
											test_result_content.append("<br><br>");
										 }
										}else{

											lab_test_result_grp= test_result[0];
										
										strToken = new StringTokenizer(lab_test_result_grp,"$$");
										token_value = "";
										prev_token  = "";
										while(strToken.hasMoreTokens())
											{
											 /*token_value = strToken.nextToken();
											 test_result_content.append(token_value+"&nbsp;&nbsp;");*/
											 token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											}
											test_result_content.append("<br><br>");
										}
										//test_result_content.append("</label>");
									  }
									   System.err.println("test_result_content===>"+test_result_content);
									}


            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(intr_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
		
										if(interaction_type.equals("F")){  
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);
										}
										else if(interaction_type.equals("L")){  
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
										}
										else if(interaction_type.equals("I")){  
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);
										}
										else if(intr_option.equals("D")){

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

										}
										else{

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

										}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(intr_name));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_dosage_display));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_dosage_display));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

										if(severity_level.equals("H")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

										}
										else if(severity_level.equals("M")){

            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

										}
										else if(severity_level.equals("L")){

            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

										}

            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(significant_level));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

							                      //if(probability.equals("D")){   Commented and added for FD-RUT-CRF-0066.1 [IN036975] --begin

            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

						                              //}
						                              //else if(probability.equals("P")){

            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

									//	}

										if(probability.equals("E")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

										}
										else if(probability.equals("P")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

										}
										else if(probability.equals("S")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

										}
										else if(probability.equals("O")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

										}
										else if(probability.equals("U")){

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

										} //FD-RUT-CRF-0066.1 [IN036975] --end

            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

									if(restrict_transaction.equals("Y")){

            _bw.write(_wl_block86Bytes, _wl_block86);

									}
									else if(restrict_transaction.equals("N")){

            _bw.write(_wl_block87Bytes, _wl_block87);

									}

            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(interaction_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);

									if(interaction_type.equals("L")){
								
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(test_result_content.toString()));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block93Bytes, _wl_block93);

							}

            _bw.write(_wl_block94Bytes, _wl_block94);

						}
						else{

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

						}
					}
				}
				else{

            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

				}
			}
			catch(Exception e){
				e.printStackTrace();
			}

            _bw.write(_wl_block99Bytes, _wl_block99);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-Drug.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-Lab.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-Food.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InteractionType.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FoodIngredient.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LabOrderCatalog.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCodeDescription.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageForm.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Major.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Minor.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.significant.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.documentation.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Definitive.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Probable.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.established.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Probable.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.suspected.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Possible.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Unlikely.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RestrictTransaction.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Interaction.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoDrugInteractionFound.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoDrugInteractionFound.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
