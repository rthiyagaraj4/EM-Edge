package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.DecimalFormat;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationwsorderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationWSOrderDetails.jsp", 1709120753270L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\"frmDispMedicationWSOrderDetails\" id=\"frmDispMedicationWSOrderDetails\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"wsorderdetailstable\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" class=\"label\" colspan=\"4\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"75%\"><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"15%\" ><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">&nbsp;&nbsp;&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<label style=\'font-size:9\' id=\"fluid_name";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\'cursor:pointer;color:blue;font-size:9\' onClick=\"callCalSection(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'F\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</label>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\'font-size:9\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<label style=\'font-size:9;display:none\' id=\"lbl_fluid_name";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\"></img>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t<label style=\'font-size:9;\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label>\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" </label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td class=\"white\" colspan=\"2\" >&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"55%\"><b>(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =")</b></td>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"15%\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b></td>\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"15%\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b></td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"15%\" ><b>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<td  style=\"background:#FDE6D0;font-size:10\" width=\"15%\"><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"order_line_no";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' style=\"cursor:pointer\" onClick=\"callMultiStrength(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'WORKSHEET\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'\')\" title=\"Alternate Drug\">\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t&nbsp;\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<label  onClick=\"callCalSection(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\'I\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\" style=\'cursor:pointer;color:blue;font-size:9\' id=\"ingredient_name";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t<label   style=\'font-size:9\' id=\"ingredient_name";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<label  style=\'font-size:9;display:none\' id=\"lbl_ingredient_name";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n\t\t\t\t\t\t\t\t\t<label style=\'font-size:9;\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</label>\n\t\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</label>\n\t\t\t\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t\t\t\t\t\t<label style=\'font-size:9;\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\t\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\t\t\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\'background-color:#CC99CC;\'>&nbsp;&nbsp;</label>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9\' onClick=\"callCalSection(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\',\'IM\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\" id=\"alt_ingredient_name";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\'font-size:9;display:none\' id=\"lbl_alt_ingredient_name";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\'font-size:9;\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\" style=\"text-align:right\" ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td><label style=\'font-size:9;\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</label></td>\n\t\t\t\t\t\t<TD ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">&nbsp;</TD>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"tot_num_of_drugs\" id=\"tot_num_of_drugs\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"selected_drug\" id=\"selected_drug\" value=\"\">\n\t\t\t<!-- <input type=\"hidden\" name=\"MakeReadOnly\" id=\"MakeReadOnly\" value=\"\"> -->\n\t\t\t<input type=\"hidden\" name=\"IngredientsType\" id=\"IngredientsType\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"orderType\" id=\"orderType\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t<script language=\"javascript\">\n\t\tdocument.getElementById(\"fluid_name1\").click();\n\t\tdocument.getElementById(\"fluid_name1\").style.backgroundColor\t= \"#FDE6D0\";\n\t\tdocument.getElementById(\"selected_drug\").value=\"1\";\n\t\t/*for(var i=1;i<=document.getElementById(\"tot_num_of_drugs\").value;i++){\n\t\t\tif(eval(\"document.getElementById(\"ingredient_name\")\"+i)!=null){\n\t\t\t\talert(\"inside if\")\n\t\t\t\teval(\"document.getElementById(\"ingredient_name\")\"+i).style.display=\"none\";\n\t\t\t\teval(\"document.getElementById(\"lbl_ingredient_name\")\"+i).style.display=\"inline\";\n\t\t\t}else if(eval(\"document.getElementById(\"alt_ingredient_name\")\"+i)!=null){\n\t\t\t\talert(\"inside else if\");\n\t\t\t\teval(\"document.getElementById(\"alt_ingredient_name\")\"+i).style.display=\"none\";\n\t\t\t\teval(\"document.getElementById(\"lbl_alt_ingredient_name\")\"+i).style.display=\"inline\";\n\t\t\t}\n\t\t}*/\n\t\t</script>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<script language=\"javascript\">\n        document.getElementById(\"ingredient_name1\").click();\n\t    document.getElementById(\"ingredient_name1\").style.backgroundColor\t= \"#FDE6D0\";\n\t    document.getElementById(\"selected_drug\").value=\"1\";\n       </script>\n\n";
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

 
	DecimalFormat dfToInteger = new DecimalFormat("#.####");
	private String retunFormatedInt(String sValue){
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String bean_id = "DispMedicationBean" ;
		String bean_name = "ePH.DispMedicationBean";
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clearOrderedQty();

		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		param_bean.setLanguageId(locale);

		String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();

		String store_code = bean.getStoreCode();
		String patient_id = request.getParameter("patient_id");
		String order_id   = request.getParameter("order_id");
		String order_line_no = request.getParameter("order_line_no");
		//String disp_stage = request.getParameter("disp_stage");
		Hashtable result = bean.showWSOrderDetails(order_id);
		ArrayList ingredients = (ArrayList)result.get("ingredients");

		String sColumnName		= "";
		String sShowHideColumns = "style='display:none'";
		//String sMakeReadonly	= "false";
		String sIngredientsType = "S";
		String ip_scope             = bean.getIPScope();  // Added for ML-MMOH-CRF-0434 [IN057356]
		if(bean.getOrderType().equals("CO") && ingredients.size()>0 ){
			if(ingredients.get(8).equals("R")){
				sColumnName			= SpringCacheBean.getLabel(pageContext,"ePH.Ratio.label","ph_labels.resources.Labels");		
				sShowHideColumns	= "style='display:All'";
				//sMakeReadonly		= "true";
			}
			else if(ingredients.get(8).equals("P")){
				sColumnName			= SpringCacheBean.getLabel(pageContext,"ePH.Percentage.label","ph_labels.resources.Labels");
				sShowHideColumns	= "style='display:All'";
				//sMakeReadonly		= "true";
			}
		}
		//if(bean.checkHold(order_id,order_line_no)) 
			//continue;
		ArrayList fluids = (ArrayList)result.get("fluids");
		
		/*String worksheet_id = bean.getWorksheetID();
		if(((bean.getHTWSAllocateBatches()).size()==0)&&(!worksheet_id.equals(""))){
			bean.setWSDrugDetails(order_id,worksheet_id);
			bean.setWSBatchDetails(order_id);
		}*/
		String classvalue = "";
		String bean_id_1 = "DispMedicationAllStages" ;
		String bean_name_1 = "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;
		bean_1.setLanguageId(locale);
		ArrayList multi_drugs = new ArrayList();
		if(order_line_no!=null){
			multi_drugs	=	bean_1.getMultiDrugs(patient_id,order_id,order_line_no);
		}
		int rowCount = 1;	
		String drug_code, drug_desc, order_line_num, qty_value, qty_unit, fluid_external_prod_id, sPresQty, sPresUOM, encoded_drug_desc, ingredient_external_prod_id, sReqQty, sDerivedQty, sDerivedUom, multi_strength;
		String alt_drug_code, alt_drug_desc, alt_qty, alt_qty_uom, sRatioOrPercent;


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

				if(fluids.size()>0){
					bean_1.addPatient(patient_id);
					bean_1.addPrescription(patient_id,order_id);			

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

					for (int i=0;i<fluids.size();i=i+10){
						if ( rowCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
						drug_code					= (String)fluids.get(i);
						drug_desc					= (String)fluids.get(i+1);
						order_line_num				= (String)fluids.get(i+3);
						qty_value					= (String)fluids.get(i+4);
						qty_unit						= (String)fluids.get(i+5);
						fluid_external_prod_id		= (String)fluids.get(i+7);
						sPresQty						= (String)fluids.get(i+8);
						sPresUOM						= (String)fluids.get(i+9);
						encoded_drug_desc =java.net.URLEncoder.encode(drug_desc,"UTF-8");
						if((bean_1.loadHoldRemarks(order_id,order_line_num).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A"))) {   // if condition Added for ML-MMOH-CRF-0434 [IN057356]

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block15Bytes, _wl_block15);

							if(!bean_1.checkHold(order_id,order_line_num)){

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

							}
							else{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

							}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

							if ((fluid_external_prod_id!=null)&& !(fluid_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fluid_external_prod_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
  
							}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sPresQty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,sPresUOM)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,qty_unit)));
            _bw.write(_wl_block31Bytes, _wl_block31);

						bean.setOrderedQty(order_line_num,qty_value);
						rowCount++;
					}
				   }
				}
				if(ingredients.size()>0){

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sColumnName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
		
						if(!sShowHideColumns.contains("All")){

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
		
						}

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					String sFinalQty					= (String)ingredients.get(11);
					String sFinalUom					= (String)ingredients.get(12);
					for (int i=0;i<ingredients.size();i=i+15){
						if ( rowCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;

						drug_code		= (String)ingredients.get(i);
						drug_desc		= (String)ingredients.get(i+1);
						order_line_num	= (String)ingredients.get(i+3);
						qty_value		= (String)ingredients.get(i+4);
						qty_unit			= (String)ingredients.get(i+5);
						ingredient_external_prod_id= (String)ingredients.get(i+7);
						encoded_drug_desc =java.net.URLEncoder.encode(drug_desc,"UTF-8");
						sRatioOrPercent="";
						sReqQty="";
						sDerivedQty="";
						sDerivedUom="";
						sPresQty="";
						sPresUOM="";

						if(sShowHideColumns.contains("All")){ // if its a compound order
							if(ingredients.get(i+8).equals("P")){ //For percentage
								// If the percentage column is null then the ingredient is prescribed with Base Qty. So "Base Qty" should be displayed instead of the percentage.
								sRatioOrPercent		= ingredients.get(i+9).toString().equals("")?SpringCacheBean.getLabel(pageContext,"ePH.BaseQty.label","ph_labels.resources.Labels"):ingredients.get(i+9).toString()+" %";
								sIngredientsType	= "P";
							}
							else{
								sRatioOrPercent		= (String)ingredients.get(i+9);
								sIngredientsType	= "R";
							}

							sReqQty					= retunFormatedInt((String)ingredients.get(i+10));
							sDerivedQty				= retunFormatedInt((String)ingredients.get(i+13));
							sDerivedUom				= (String)ingredients.get(i+14);
						}
						else{
							sPresQty				= (String)ingredients.get(i+13);
							sPresUOM				= (String)ingredients.get(i+14);
						}

						multi_strength ="N";
						bean_1.addDrugs(patient_id,order_id,drug_code,multi_strength,order_line_num);	
						
						if((bean_1.loadHoldRemarks(order_id,order_line_num).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A")))  {  // if condition Added for ML-MMOH-CRF-0434 [IN057356]

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);

								if(multi_strength.equals("Y")){

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block45Bytes, _wl_block45);

								}
								else{

            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								if(!bean_1.checkHold(order_id,order_line_num)){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_unit));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
    
								}
								else{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

								}

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
								if ((ingredient_external_prod_id!=null)&& !(ingredient_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ingredient_external_prod_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);

								}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sRatioOrPercent));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sReqQty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,sFinalUom)));
            _bw.write(_wl_block57Bytes, _wl_block57);

								if(!sShowHideColumns.contains("All")){ // if its not a compound order then show the prescribed uom as req qty

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sPresQty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,sPresUOM)));
            _bw.write(_wl_block60Bytes, _wl_block60);

								}
								if(sShowHideColumns.contains("All")){ // if its a compound order

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sDerivedQty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,sDerivedUom)));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}
								else {

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,qty_unit)));
            _bw.write(_wl_block62Bytes, _wl_block62);
	
								}

            _bw.write(_wl_block63Bytes, _wl_block63);

							bean.setOrderedQty(order_line_num,qty_value);
							if(multi_drugs.size()>0){
								int altRecCount=0;
								for(int n=0; n<multi_drugs.size(); n+=5){ 
									altRecCount++;
									alt_drug_code			=	(String)multi_drugs.get(n);
									alt_drug_desc			=   (String)multi_drugs.get(n+1);
									alt_qty=(String)multi_drugs.get(n+3);
									alt_qty_uom =(String)multi_drugs.get(n+4);
									encoded_drug_desc =java.net.URLEncoder.encode(alt_drug_desc,"UTF-8");

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encoded_drug_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(alt_qty_uom));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(altRecCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_drug_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(alt_qty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,alt_qty_uom)));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}
						}
						rowCount++;
					}
				}

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sFinalQty));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,sFinalUom)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(sShowHideColumns));
            _bw.write(_wl_block74Bytes, _wl_block74);

				}	

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(rowCount-1));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(sIngredientsType));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean.getOrderType()));
            _bw.write(_wl_block82Bytes, _wl_block82);

	if(fluids.size()>0){

            _bw.write(_wl_block83Bytes, _wl_block83);

	}
	else if(ingredients.size()>0){

            _bw.write(_wl_block84Bytes, _wl_block84);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(param_bean_id,param_bean,request);
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetails/Quantity.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReqQty.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Ingredient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReqQty.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReqQty.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DerivedQty.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TotalQuantity.label", java.lang.String .class,"key"));
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
}
