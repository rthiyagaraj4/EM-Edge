package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ipconsultationlistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/IPConsultationListResult.jsp", 1743758828772L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n?             100         ?           created\n18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method\n21/12/2011\t  IN30050\t Dinesh T\t  ARTEMIS - Updated for the patient id irrespective of the\t\t\t\t\t\t\t\t\t\t\t\t  practitioners and updated the = to like in qry\n14/12/2012\t  IN033692\t Vijayakumar K patient referral has been closed still patient is appearing in IP Consultation list because of which patients are getting charged extra as consultants are charging visit.attached is the screen shot\n12/03/2013    IN033692\t Chowminya G   patient referral has been closed still patient is appearing\n------------------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\t\tRev.Name\t\t\tDescription\n------------------------------------------------------------------------------------------------------------------------------\n18/07/2018    IN067769\t\tRaja S\t\t18/07/2018\t\tRamesh G\t\t\tKDAH-SCF-0506\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n\t<head>\n\t\t<title></title>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script Language=\"JavaScript\" src=\'../../eCA/js/IPConsultationList.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body OnMouseDown=\'CodeArrest()\' onload=\"loadNextButton();\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'IPConsultationListResultForm\' id=\'IPConsultationListResultForm\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.IPConsultationListServlet\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table class=\'grid\' width=\"100%\" align=\"center\" name=\"resultTable\"  id=\"dataTitleTable\">\n\t\t<tr>\n\t\t\t<th class=\'columnHeadercenter\' width=\'5%\' align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<input type=\'checkbox\' name=\'selectAllNext\' id=\'selectAllNext\' id=\'selectAllNext\' onclick=\'selectAllChkNext()\' checked value=\'Y\'/></th><!--IN29413-->\n\t\t\t<th class=\'columnHeadercenter\' align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th class=\'columnHeadercenter\' width=\'15%\' align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t<th class=\'columnHeadercenter\' width=\'20%\' align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th class=\'columnHeadercenter\' width=\'25%\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\t\t\t\n\t\t</tr>\n\t\t</table>\n\t\t\n\t\t<div style=\'width:100%;height:93%;overflow:auto;position:absolute\'>\n\t\t<table class=\'grid\' align=\"center\" name=\"resultTable\"  id=\"dataTable\" width=\"100%\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\' width=\'5%\'><input type=\'checkbox\' checked value=\'Y\' name=\'consultChk";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'consultChk";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id= \'consultChk";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'onClick=\"addToList(this,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\"></td><!--IN29413-->\n\t\t\t\t<td class=\'gridData\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td class=\'gridData\' width=\'15%\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<td class=\'gridData\' width=\'20%\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td class=\'gridData\' width=\'25%\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'gridData\'>APP-000052 No Records Found...</td>\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t</table>\n\t\t</div>\n\t\t<script>\n\t\t\tdocument.getElementById(\"selectAllNext\").checked=\"\";\n\t\t\tdocument.getElementById(\"selectAllNext\").value=\"N\";\n\t\t</script>\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<table  class=\'grid\' WIDTH=\'100%\' align=\'center\'  >\n\t\t\t\t<tr><td CLASS=\'gridData\' >&nbsp;</td>\t\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<td class=\'gridData\'  width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/IPConsultationListResult.jsp?lower_limit=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&upper_limit=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&res_mode=res_prev\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td class=\'gridData\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/IPConsultationListResult.jsp?lower_limit=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&res_mode=res_next\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t</tr></table>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<table class=\'grid\'  width=\"100%\" align=\"center\" name=\"resultTable\"  id=\"dataTitleTable\">\n\t\t<tr>\n\t\t\t<th class=\'columnHeadercenter\' width=\'5%\' align=\'left\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<input type=\'checkbox\' name=\'selectAll\' id=\'selectAll\' id=\'selectAll\' onclick=\'selectAllChk()\' checked value=\'Y\'/></th><!--IN29413-->\n\t\t\t<th class=\'columnHeadercenter\' align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</th>\n\t\t</tr>\n\t</table>\n\t<table class=\'grid\'  width=\"100%\" align=\"center\" name=\"resultTable\" id=\"dataTable\" >\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<tr>\n\t\t\t<td class=\'gridData\' width=\'5%\'><input type=\'checkbox\' name=\'consultChk";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"addToList(this,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td><!--IN29413-->\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<td class=\'gridData\'>&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<a class=\'gridLink\' href=\"javascript:callBedSideRefferal(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\"> <b>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" </b></a> </td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<td class=\'gridData\' width=\'15%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t<td class=\'gridData\' width=\'20%\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t<td class=\'gridData\' width=\'25%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\t\t\n\t\t</tr>\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\n\t<tr  style=\'visibility:hidden\' >\n\t\t\t<td> ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t<td>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\t\t\t\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\n\t\t<input type=\'hidden\' name=\'bean_key\' id=\'bean_key\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\'hidden\' name=\'create_type\' id=\'create_type\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\'hidden\' name=\'cons_date\' id=\'cons_date\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\'hidden\' name=\'cons_time\' id=\'cons_time\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\'hidden\' name=\'cons_list_desc\' id=\'cons_list_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'practitionerId\' id=\'practitionerId\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\'hidden\' name=\'servMode\' id=\'servMode\' value=\"insert\">\n\t\t<input type=\'hidden\' name=\'consultCnt\' id=\'consultCnt\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t<input type=\'hidden\' name=\'bedNo\' id=\'bedNo\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t<input type=\'hidden\' name=\'totChecked\' id=\'totChecked\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<input type=\'hidden\' name=\'totDisabled\' id=\'totDisabled\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t</form>\n\t\t<script>\n\t\t\talignWidth();\n\t\t\ttotRecords=document.getElementById(\"consultCnt\").value;\n\t\t\tif(document.getElementById(\"selectAll\")!=null)\n\t\t\t{\n\t\t\t\tfor(i=1;i<=totRecords;i++)\n\t\t\t\t{\n\t\t\t\t\tvar clicker = document.getElementById(\'consultChk\'+i);\n\t\t\t\t\tif(clicker.disabled == false)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(!clicker.checked)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\"selectAll\").checked=\'\';\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(totRecords == parseInt(document.getElementById(\"totDisabled\").value)+parseInt(document.getElementById(\"totChecked\").value)  )\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"selectAll\").checked=\'checked\';\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(document.getElementById(\"selectAllNext\")!=null)\n\t\t\t{\n\t\t\t\tfor(i=1;i<=totRecords;i++)\n\t\t\t\t{\n\t\t\t\t\tvar clicker = document.getElementById(\'consultChk\'+i);\n\t\t\t\t\tif(clicker.disabled == false)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(!clicker.checked)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\"selectAllNext\").checked=\'\';\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(totRecords==0)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"selectAllNext\").checked=\'\';\n\t\t\t\t\tdocument.getElementById(\"selectAllNext\").value=\'N\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(totRecords == parseInt(document.getElementById(\"totDisabled\").value)+parseInt(document.getElementById(\"totChecked\").value))\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"selectAllNext\").checked=\'checked\';\n\t\t\t\t\t\tdocument.getElementById(\"selectAllNext\").value=\'Y\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\tif(document.getElementById(\"selectAll\")!=null){\n\t\tvar totDisabled=0;\n\t\tfor(i=1;i<=document.getElementById(\"consultCnt\").value;i++)  \n\t\t{\n\t\t\tvar clicker = document.getElementById(\'consultChk\'+i+);\n\t\t\t\n\t\t\tif(clicker.disabled == true)\n\t\t\t{\n\t\t\t\ttotDisabled=totDisabled+1;\n\t\t\t}\n\t\t}\n\t\tdocument.getElementById(\"totDisabled\").value=totDisabled;\n\t\t//alert(parseInt(document.getElementById(\"consultCnt\").value)+\" \"+parseInt(document.getElementById(\"totChecked\").value));\n\t\tif(parseInt(document.getElementById(\"totDisabled\").value)==parseInt(document.getElementById(\"consultCnt\").value))\n\t\t{\n\t\t\tdocument.getElementById(\"selectAll\").checked=\'\';\n\t\t\tdocument.getElementById(\"selectAll\").value=\'N\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(parseInt(document.getElementById(\"consultCnt\").value)==parseInt(document.getElementById(\"totChecked\").value)+parseInt(document.getElementById(\"totDisabled\").value))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"selectAll\").checked=\'checked\';\n\t\t\t\tdocument.getElementById(\"selectAll\").value=\'Y\';\n\t\t\t}\n\t\t}\n\t\t}\n\t\t</script>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	String facility_id		=	(String) session.getValue("facility_id");
	String ca_practitioner_id		=	(String) session.getValue("ca_practitioner_id");
	eCA.IPConsultationListBean ipConsultListBean = null;
	String queryString = request.getQueryString();
		

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet prs=null;
	ArrayList selectedList =new ArrayList(); 
	StringTokenizer Tokens = null ;
	String patientId ="";
	String practitionerId ="";
	String speciality_code ="";
	String location_code ="";
	String service_code ="";
	String cons_date ="";
	String cons_time ="";
	String create_type ="";
	String bean_key ="";
	String res_mode ="";
	String strVal ="";
	String checked ="";
	String arrVal ="";
	StringBuffer consListQry = new StringBuffer();
	String pline ="";
	String rsAdmission_date_time ="";
	String rsSpecialty_code="";
	String rsSpecialty_desc="";
	String rsLocation_code ="";
	String patient_id ="";
	String encounter_id ="";
	String preRsLocation_code ="";
	String attend_practitioner_id ="";
	String preattend_practitioner_id ="";
	String specialty_desc ="";
	String bedNo="";//IN29413
	String nursing_unit_desc ="";
	String practitioner_name ="";
	String display_admission_date="";
	String control="";
	String max_cons_per_pract="";
	String max_cons_per_splty="";
	String cons_back_date="";
	String amd_cons_list="";
	String min_cons_duration="";
	String control_value="";
	String disabled="";
	String className1="";
	String splty_code="";
	String referral_id="";
	String lower_limit				=	"";	
	String upper_limit				=	"";
	StringBuffer query_string		=	new StringBuffer();
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0 ;
	String classValue = "QRYEVEN";
	int i = 0;
	boolean flag = true;
	int totChecked=0;
	int totDisabled=0;
		
	patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
	practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
	speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
	location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
	service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
	bedNo			=	(request.getParameter("bedNo")==null)	?	""	:	request.getParameter("bedNo");//IN29413	
	cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
	cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
	res_mode			=	(request.getParameter("res_mode")==null)	?	""	:	request.getParameter("res_mode");
	create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
	lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");

	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);
	String restrictSearch = (request.getParameter("restrictSearch")==null)	?	"N"	:	request.getParameter("restrictSearch");//IN30050 
	String tempPractId = practitionerId;//IN30050
	
	query_string.append("practitionerId=");		query_string.append(practitionerId);
	query_string.append("&speciality_code=");	query_string.append(speciality_code);
	query_string.append("&bedNo=");	query_string.append(bedNo);//IN29413
	query_string.append("&location_code=");	query_string.append(location_code);
	query_string.append("&service_code=");	query_string.append(service_code);
	query_string.append("&patientId=");	query_string.append(patientId);
	query_string.append("&cons_date=");	query_string.append(cons_date);
	query_string.append("&cons_time=");	query_string.append(cons_time);
	query_string.append("&create_type=");	query_string.append(create_type);
	query_string.append("&restrictSearch=");	query_string.append(restrictSearch);//IN30050
	
	if(res_mode.equals("Next")||res_mode.equals("Back"))
	{ 
		bean_key			=	(request.getParameter("beankey")==null)	?	""	:	request.getParameter("beankey");
	}
	else
	{
		bean_key =practitionerId+cons_date+cons_time;
	}  	   
	
	//Added By Archana Dhal on 5/3/2010 related to IN021047.
	if(!locale.equals("en"))
	{
		cons_date	= com.ehis.util.DateUtils.convertDate(cons_date,"DMY",locale,"en");
		cons_time	= com.ehis.util.DateUtils.convertDate(cons_time,"HM",locale,"en");
	}	

	ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);

            _bw.write(_wl_block8Bytes, _wl_block8);

	if(res_mode.equals("Next"))
	{ 

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
		
		String pract_qry ="select nvl(b.ATTEND_PRACTITIONER_ID,ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID ,am_get_desc.AM_PRACTITIONER(nvl(ATTEND_PRACTITIONER_ID,ADMIT_PRACTITIONER_ID),?,1)practitioner_name,am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,?,2) SPECIALTY_DESC,b.SPECIALTY_CODE splty_code,IP_get_desc.IP_NURSING_UNIT(?,b.NURSING_UNIT_CODE,?,2) nursing_unit_desc from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.ENCOUNTER_ID =?";
		selectedList =	ipConsultListBean.returnConsList();
		Collections.sort(selectedList);		
		int listSize = selectedList.size();
		out.println("<input type='hidden' id='consultCntNext' name='consultCntNext' id='consultCntNext' value='"+listSize+"'");
		totChecked = listSize;//IN30050
		try
		{
			con =  ConnectionManager.getConnection(request);
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}

		if(listSize>0){
		for(int k=0; k<listSize; k++)
		{
			strVal = (String)selectedList.get(k);
			Tokens = new StringTokenizer(strVal,"~");
			rowCnt++;
			if(i % 2 == 0) 
				classValue = "QRYEVEN";
			else 
				classValue = "QRYODD";
			while(Tokens.hasMoreTokens())
			{
			Tokens.nextToken(); 
			rsLocation_code = (String) Tokens.nextToken();
			pline = (String) Tokens.nextToken();
			rsAdmission_date_time = (String) Tokens.nextToken();
			rsSpecialty_desc = (String) Tokens.nextToken();
			patient_id = (String) Tokens.nextToken();
			encounter_id = (String) Tokens.nextToken();
			Tokens.nextToken();

			try
			{
				stmt = con.prepareStatement(pract_qry);
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,facility_id);
				stmt.setString(4,locale);
				stmt.setString(5,facility_id);
				stmt.setString(6,encounter_id);
					
				rs = stmt.executeQuery();
				while(rs.next())
				{
					attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
					specialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
					nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");
					practitioner_name = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
					splty_code = rs.getString("splty_code")==null?"":rs.getString("splty_code");

				}

				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();

				//pract_key = attend_practitioner_id+"~"+specialty_desc+"~"+pline+"~"+rsAdmission_date_time+"~"+patient_id+"~"+encounter_id;
			if(create_type.equals("S"))
			{
				if(!attend_practitioner_id.equals(preattend_practitioner_id))
				{
					out.println("<tr ><td class='gridData' colspan='5' class=CAFOURTHLEVELCOLOR><font size=1>" +practitioner_name+ "</font></td></tr>");
				}
				
			}
			else
			{
				if(!rsLocation_code.equals(preRsLocation_code))
				{
					out.println("<tr ><td class='gridData' colspan='5' class=CAFOURTHLEVELCOLOR><font size=1>" +nursing_unit_desc+ "</font></td></tr>");
				}
			}
			 display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pline));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsAdmission_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsSpecialty_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsLocation_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLDecoder.decode(pline,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(display_admission_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(specialty_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

			}
			catch(Exception e)
			{
				e.printStackTrace();				

			}
			
		   }
			preRsLocation_code = rsLocation_code;
			preattend_practitioner_id = attend_practitioner_id;
			i++;
		}
		}
		else
		{	

            _bw.write(_wl_block25Bytes, _wl_block25);
		}
		if(con != null) ConnectionManager.returnConnection(con,request);

            _bw.write(_wl_block26Bytes, _wl_block26);

		if(listSize==0)
		{

            _bw.write(_wl_block27Bytes, _wl_block27);
		}
	}
	else 						   
	{	
		selectedList =	ipConsultListBean.returnConsList();
		
		control="select MAX_CONS_PER_PRACT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY MAX_CONS_PER_SPLTY,CONS_BACK_DATE CONS_BACK_DATE,AMD_CONS_LIST AMD_CONS_LIST,MIN_CONS_DURATION MIN_CONS_DURATION from ca_cons_param";
		//String speciality_query="select PRIMARY_SPECIALITY_CODE splty_code from am_practitioner where  practitioner_id=?";
		consListQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?)Pline,(select REFERRAL_ID from PR_REFERRAL_REGISTER where PATIENT_ID = b.PATIENT_ID and FROM_ENCOUNTER_ID =b.ENCOUNTER_ID and BEDSIDE_REFERRAL_YN ='Y' and status != 'C'  and rownum=1 and TO_PRACT_ID like ? )REFERRAL_ID, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME ,b.SPECIALTY_CODE,b.SPECIALTY_CODE  splty_code,am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,?,2) SPECIALTY_DESC,IP_get_desc.IP_NURSING_UNIT(?,b.NURSING_UNIT_CODE,?,2) nursing_unit_desc,b.NURSING_UNIT_CODE,nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID,CA_GET_CONS_LIST_CONTROL(");//IN30050
		//if (create_type.equals("S"))
		consListQry.append("b.ATTEND_PRACTITIONER_ID");
		//else
		//consListQry.append("?");
		
		//IN033692 starts
		//consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b where b.facility_id= ? ");//Commented for IN067769
		//consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b,pr_referral_register prc WHERE b.facility_id= ? ");
		//IN033692 ends
		consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.encounter_id like '%%' ");//Modified for IN067769

		if(!speciality_code.equals(""))
			consListQry.append("and b.SPECIALTY_CODE=? ");
		if(!patientId.equals(""))
			consListQry.append("and b.PATIENT_ID =? ");

		if(!location_code.equals(""))
			consListQry.append("and b.NURSING_UNIT_CODE =? ");
		if(!service_code.equals(""))
			consListQry.append("and b.SERVICE_CODE=? "); //
		if(create_type.equals("S"))
			consListQry.append("and b.SPECIALTY_CODE like ?  "); //IN30050
		
		consListQry.append("AND UPPER(b.BED_NUM) LIKE UPPER(?)");//IN29413

		if (create_type.equals("S"))
		{
			consListQry.append("AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID=b.ATTEND_PRACTITIONER_ID AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID and TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))"); 
		}
		else
		{
			//if(create_type.equals("P"))
			consListQry.append("and (b.ATTEND_PRACTITIONER_ID like ?  "); //IN30050

			if(create_type.equals("O"))
				consListQry.append("or b.ATTEND_PRACTITIONER_ID like ?  "); //P_MIN_CONS_DURATION

			//consListQry.append(" or exists (select 1 from PR_REFERRAL_REGISTER where FROM_FACILITY_ID = B.FACILITY_ID AND FROM_ENCOUNTER_ID = b.encounter_id AND TO_PRACT_ID like ? AND BEDSIDE_REFERRAL_YN='Y' and status != 'C' )) AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID like ? AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID AND  TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))  "); //P_MIN_CONS_DURATION//Added status condition - IN033692
			consListQry.append(" or exists (select 1 from PR_REFERRAL_REGISTER where FROM_FACILITY_ID = B.FACILITY_ID AND FROM_ENCOUNTER_ID = b.encounter_id and facility_id= ? AND TO_PRACT_ID like ? AND BEDSIDE_REFERRAL_YN='Y' and status != 'C' )) AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID like ? AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID AND  TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))  "); //Modified for IN067769
		}

		//consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') "); //Added By Archana Dhal on 5/3/2010 related to IN021047.//CHANGES INCLUDED FOR GET ACCESS RULE
		//consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') AND 'Y'=OR_GET_ACCESS_RULE(B.facility_id,B.encounter_id,'CN',B.patient_class,to_char(B.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = b.facility_id and encounter_id = b.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=B.FACILITY_ID   and ENCOUNTER_ID=B.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1)) "); //CHANGES INCLUDED FOR GET ACCESS RULE//Commented for IN067769
		consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') AND 'Y'=OR_GET_ACCESS_RULE(B.facility_id,B.encounter_id,'CN',B.patient_class,to_char(B.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = b.facility_id and facility_id= ? and encounter_id = b.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=B.FACILITY_ID   and ENCOUNTER_ID=B.encounter_id and facility_id= ? AND DIS_ADV_STATUS in('0','1') and rownum <=1)) "); //Modified for IN067769
		//IN033692 starts
		//consListQry.append("and prc.from_encounter_id = b.ENCOUNTER_ID(+) and prc.status != 'C' ");
		//IN033692 ends
		try																					  
		{
			con =  ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(control);
			prs = pstmt.executeQuery();
			while(prs.next())
			{
				max_cons_per_pract=prs.getString("MAX_CONS_PER_PRACT");
				max_cons_per_splty=prs.getString("MAX_CONS_PER_SPLTY");
				cons_back_date=prs.getString("CONS_BACK_DATE");
				amd_cons_list=prs.getString("AMD_CONS_LIST");
				min_cons_duration=prs.getString("MIN_CONS_DURATION");
			}

			if(prs!=null) 
				prs.close();
			if(pstmt!=null)
				pstmt.close();
			
			if(restrictSearch.equals("Y"))//IN30050
				practitionerId="%";//IN30050
			stmt = con.prepareStatement(consListQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int count1=0;
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);//IN30050
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			//if (!create_type.equals("S"))
			//stmt.setString(++count1,practitionerId);
			//stmt.setString(++count1,splty_code);
			stmt.setString(++count1,cons_date);
			stmt.setString(++count1,cons_time);
			stmt.setString(++count1,max_cons_per_pract);
			stmt.setString(++count1,max_cons_per_splty);
			stmt.setString(++count1,min_cons_duration);
			stmt.setString(++count1,facility_id);
			
			if(!speciality_code.equals(""))
			{
				stmt.setString(++count1,speciality_code);
			}	 
			
			if(!patientId.equals(""))
			{
			   stmt.setString(++count1,patientId);
			}
			
			if(!location_code.equals(""))
			{
				stmt.setString(++count1,location_code);
			}
			
			if(!service_code.equals(""))
			{
				stmt.setString(++count1,service_code);
			}
			 
			if(create_type.equals("S"))
			{
				stmt.setString(++count1,practitionerId); // value is speciality only
			}
			if(bedNo.equals(""))//IN30050
				bedNo="%";//IN30050
			stmt.setString(++count1,bedNo);//IN29413

			if (create_type.equals("S"))
			{
				//stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
			}
			else
			{	
				//if(create_type.equals("P"))
				stmt.setString(++count1,practitionerId);
				
				if(create_type.equals("O"))
				{
					stmt.setString(++count1,ca_practitioner_id);
				}	
				stmt.setString(++count1,facility_id);//IN067769
				stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
			}
			//Below set strings added by Archana Dhal on 5/3/2010 related to IN021047.
			stmt.setString(++count1,cons_date);
			stmt.setString(++count1,cons_time);
			stmt.setString(++count1,facility_id);//IN067769
			stmt.setString(++count1,facility_id);//IN067769
					
			rs = stmt.executeQuery();

			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
	
			if( totalRecordCount>maxRecordsDisp)
			{

            _bw.write(_wl_block28Bytes, _wl_block28);

				if(startIndex>maxRecordsDisp)
				{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
				if(totalRecordCount>endIndex)
				{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

				}

            _bw.write(_wl_block36Bytes, _wl_block36);

			}

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);


	if(startIndex>1)
		rs.absolute((startIndex-1));
	
	while(rs.next())
	{
		if(i % 2 == 0) 
			classValue = "QRYEVEN";
		else 
			classValue = "QRYODD";	
		
		flag = false ;
		rowCnt++;
		
		patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
		encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
		pline = rs.getString("Pline")==null?"":rs.getString("Pline");
		pline =pline.replaceAll("\\|",",");
		referral_id = rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
		rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
		rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
		rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
		nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");
		attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
		control_value = rs.getString("control_value")==null?"":rs.getString("control_value");
		splty_code = rs.getString("splty_code")==null?"":rs.getString("splty_code");
		
		//arrVal = rsLocation_code+"~"+pline+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id;

		if(create_type.equals("S"))
		{
			arrVal = attend_practitioner_id+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
		}
		else
		{
			arrVal = rsLocation_code+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
		} 		
		if(res_mode.equals(""))
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
				checked ="";
				totDisabled++;
			}
			else
			{
				disabled="";
				checked ="checked";
				totChecked++;
				if(!ipConsultListBean.returnConsList().contains(arrVal))
				{
					ipConsultListBean.addtoConsList(arrVal);
				}
			}
		}
		else
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
				totDisabled++;
			}
			else
			{
				disabled="";
			}
			
			
			if(selectedList.contains(arrVal))
			{
				checked ="checked";
				totChecked++;
			}
			else
			{
				checked ="";
			}
		}
		
		if(control_value.equals("DURN"))
		{
			className1="IVINGREDIENT1";
		}
		else if(control_value.equals("PRACT"))
		{
			className1="IVFLUID1";
		}
		else if(control_value.equals("SPLTY"))
		{
			className1="QRY9";
		}
		else
		{
			className1=classValue;
		} 		
		
		display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(pline,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsAdmission_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsSpecialty_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rsLocation_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(checked));
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block43Bytes, _wl_block43);

		if(referral_id.equals(""))
		{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(pline));
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
		else
		{

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pline));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedSideReferral.label","common_labels")));
            _bw.write(_wl_block49Bytes, _wl_block49);

		}

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(display_admission_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rsSpecialty_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);

		i++;

		if(rowCnt>=maxRecordsDisp) 
			break;
	}

            _bw.write(_wl_block54Bytes, _wl_block54);
 
	putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
	
			if(rs!=null) 
				rs.close();
			if(stmt!=null)
				stmt.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>parent.IPConsultationListResultFrame.location.href='../../eCommon/html/blank.html';</script>");
		}
	}
	practitionerId = tempPractId;
	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bean_key));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(create_type));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cons_date));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(cons_time));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(totChecked));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(totDisabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specialty.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specialty.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specialty.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
}
