package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;

public final class __servervalidationxml extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ServerValidationXML.jsp", 1743078392277L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/HealthCardInterface.jsp", 1711968138173L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n       \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\n\t\t\t\t\t\tval1 = getMessage(\'DUP_ALT_ID\',\'MP\');\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" == 1)\n\t\t\t\t\t\t\tval = document.getElementById(\"altId1Desc\").value\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" == 2)\n\t\t\t\t\t\t\tval = document.getElementById(\"altId2Desc\").value\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" == 3)\n\t\t\t\t\t\t\tval = document.getElementById(\"altId3Desc\").value\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" == 4)\n\t\t\t\t\t\t\tval = document.getElementById(\"altId4Desc\").value\n\t\t\t\t\t\tval = val1.replace(\'$\',val);\n\t\t\t\t\t\tif (";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" == 1) { \n\t\t\t\t\t\t\tif (document.getElementById(\"family_org_id_accept_yn\").value==\'N\')  \n\t                        alert(val);\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\talert(val);\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                \n                    val1 = getMessage(\'INVALID_ALT_ID\',\'MP\');\n                    if(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" == 1)\n                        val = document.getElementById(\"alt_id1_type\").value\n                    if(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" == 2)\n                        val = document.getElementById(\"alt_id2_type\").value\n                    if(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" == 3)\n                        val = document.getElementById(\"alt_id3_type\").value\n                    if(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" == 4)\n                        val = document.getElementById(\"alt_id4_type\").value\n                       val = val1.replace(\'$\',val)\n                        alert(val)\n                \n                ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\tarr[0] = old_vals\n\t\t\t\t\t\t\tarr[1] = new_vals\n\t\t\t\t\t\t\tarr[2] = legends\n\t\t\t\t\t\t\tarr[3] = objs\n\n\t\t\t\t\t\t\tvar dialogHeight= \"28\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"43\" ;\n\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\tvar arguments   = arr ;\n\t\t\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n                        \n\t\t\t\t\t\t\tretVal = window.showModalDialog( \"../../eMP/jsp/FetchExtValues.jsp\",arguments,features);\n\t\t\t\t\t\t\tif(retVal == null)  retVal = \'N\'\n\t\t\t\t\t\t\tif(retVal ==\'Y\'){\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\tif(obj.name == \'nationality_code\'){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_desc\").value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_code\").value=\'\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"nationality_desc\").value=\'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(obj.name == \'mar_status_code\'){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"mar_status_desc\").value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"mar_status_code\").value=\'\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"mar_status_desc\").value=\'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\tif(obj.name == \'relgn_code\'){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"relgn_desc\").value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"relgn_code\").value=\'\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"relgn_desc\").value=\'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\t\t\t\tif(obj.name == \'language_code\'){\n\t\t\t\t\t\t\t\t    if(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"language_desc\").value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"language_code\").value=\'\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"language_desc\").value=\'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(obj.name == \'pref_facility_id\'){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pref_facility_desc\").value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pref_facility_id\").value=\'\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pref_facility_desc\").value=\'\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t}\n\t\t                    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                                val1 = getMessage(\'ALT_ID_BLANK_EXT\',\'MP\');\n                                if(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" == 1)\n                                    val = document.getElementById(\"altId1Desc\").value\n                                if(";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" == 2)\n                                    val = document.getElementById(\"altId2Desc\").value\n                                if(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" == 3)\n                                    val = document.getElementById(\"altId3Desc\").value\n                                if(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" == 4)\n                                    val = document.getElementById(\"altId4Desc\").value\n                                \n\t\t\t\t\t\t\t\tval = val1.replace(\'$\',val)\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\tdocument.getElementById(\"date_of_birth\").value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\tdocument.getElementById(\"Birth_Date\").value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\t\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"b_age\").value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\tdocument.getElementById(\"b_months\").value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\tdocument.getElementById(\"b_days\").value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\tdocument.getElementById(\"place_of_birth_code\").value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\tdocument.getElementById(\"sex\").value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\tdocument.getElementById(\"place_of_birth_desc\").value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n\t\tvar obj =document.getElementById(\"ethnic_group\");\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) {obj.remove(0);}\n\t\tvar element1 = document.createElement(\'OPTION\');\n\t\telement1.text = \" -------\"+\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'+\"------- \";\n\t\telement1.value= \"\";\n\t\t//document.getElementById(\"ethnic_group\").add(element1);\t\n\t\t\n\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t//\tdocument.getElementById(\"ethnic_group\").add(element);\t\n\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" == \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\")\n\t\t\t\t\t{\n\t\t\t\t//\t\tdocument.getElementById(\"ethnic_group\").options[";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="].selected = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\n\t\tvar obj =document.getElementById(\"occ_of_per\");\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) {obj.remove(0);}\n\t\tvar element1 = document.createElement(\'OPTION\');\n\t\telement1.text = \" ------- \"+\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'+\"-------- \";\n\t\telement1.value= \"\";\n\t\tdocument.getElementById(\"occ_of_per\").add(element1);\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\t\n\t\t\t\n\t\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\tdocument.getElementById(\"occ_of_per\").add(element);\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\tdocument.getElementById(\"nationality_desc\").value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\tdocument.getElementById(\"nationality_desc\").value=\"\";\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\tif(document.getElementById(\"relationship_level\"))\n\t\t\tdocument.getElementById(\"relationship_level\").value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t \n\t\t\t\t document.getElementById(\"relntext\").innerHTML=\"<input type=\'text\' name=\'relationship_level1_desc\' id=\'relationship_level1_desc\' size=\'25\' maxlength=\'25\' value=\'\' onblur=\'searchRelationshiplevel1(relationship_level1_code,relationship_level1_desc);clearfields();\'  ><input type=\'button\'  id=\'relationship_level1_id\'  name=\'relationship_level1_code_id\' id=\'relationship_level1_code_id\' value=\'?\' class=\'button\' onclick=\'searchRelationshiplevel1(this,relationship_level1_desc)\' ><img src=\'../../eCommon/images/mandatory.gif\'></img><input type=\'hidden\' name=\'relationship_level1_code\' id=\'relationship_level1_code\' value=\'\'>\"; \n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t \n\t\t\t\tdocument.getElementById(\"relntext\").innerHTML=\"<input type=\'text\' name=\'relationship_level1_desc\' id=\'relationship_level1_desc\' size=\'25\' maxlength=\'25\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onblur=\'searchRelationshiplevel1(relationship_level1_code,relationship_level1_desc);clearfields();\'   ><input type=\'button\'  id=\'relationship_level1_id\'  name=\'relationship_level1_code_id\' id=\'relationship_level1_code_id\' value=\'?\' class=\'button\' onclick=\'searchRelationshiplevel1(this,relationship_level1_desc)\' ><img src=\'../../eCommon/images/mandatory.gif\'></img><input type=\'hidden\' name=\'relationship_level1_code\' id=\'relationship_level1_code\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\";\t\t\t\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\t\t\t\t\n\t\t\t\tdocument.getElementById(\"relnlabel\").innerHTML = \"\";\n\t\t\t\tdocument.getElementById(\"relntext\").innerHTML = \"\";\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\tif(";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =".family_org_membership){\n\t\t\t\tif(";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =".family_org_membership.value==\"4\")\n\t\t\t\t\talert(getMessage(\"NON_ORGMEM_NOT_PAT_SER\",\"MP\"));\n\t\t\t\telse if(";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =".family_org_membership.value==\"3\")\n\t\t\t\t\talert(getMessage(\"NON_FAMILY_NOT_PAT_SER\",\"MP\"));\n\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =".family_org_membership.value=\"\";\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =".alt_id1_no.value=\"\";\n\t\t\t\tif(";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =".relationship_to_head_desc){\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =".relationship_to_head_desc.value=\"\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =".relationship_to_head.value=\"\";\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t  \tdocument.forms[0].isAlternateIdCount.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" ;\n\t  ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" \n\tif(document.getElementById(\'nationality_id\')!=null){document.getElementById(\'nationality_id\').innerHTML=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";}\n\tif(document.getElementById(\'oth_alternate_id\')!=null){document.getElementById(\'oth_alternate_id\').innerHTML=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";}\n\t  ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    public HashMap HealthCardData(java.sql.Connection con, String curr_ds_id, String scr_item_name, String scr_item_value,javax.servlet.jsp.JspWriter out, String frame_ref)
    {
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet rset = null ;
        String sql ="";
        String ret_script = "" ;
        HashMap return_hash =  new HashMap() ;

        try
        {
            if(curr_ds_id != null)
            {
                sql = "Select Dsrc_Col_Name from MP_DATASOURCE_MAPPING_VW where Datasource_id = ? and Med_scr_item_name = ?" ;
                stmt = con.prepareStatement (sql);
				stmt.setString(1, curr_ds_id ) ;
                stmt.setString(2, scr_item_name ) ;

                rset = stmt.executeQuery();	               
                String ds_col_name = "";
                if(rset !=null)
                {
                    if(rset.next())
                    {
                        ds_col_name = rset.getString(1) ;
                        if(rset != null)  rset.close() ;
                        if(stmt != null)  stmt.close() ;

                        sql  = "select "+ds_col_name+" from mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                        stmt = con.prepareStatement (sql);
                        stmt.setString(1, scr_item_value ) ;

                        rset = stmt.executeQuery();
                       
                        if(rset != null)
                        {
                            if(rset.next())
                            {
                                if(rset != null)  rset.close() ;
                                if(stmt != null)  stmt.close() ;

                                sql =" select med_col_name, med_col_datawidth,med_col_datadec, dsrc_col_datawidth,dsrc_col_datatype,dsrc_col_name, med_scr_item_name, override_yn,med_scr_legend from mp_datasource_mapping_vw where datasource_id = ? " ;
                                stmt = con.prepareStatement (sql);
                                stmt.setString(1, curr_ds_id ) ;

                                rset = stmt.executeQuery() ;
                               // out.println(sql);
                                if( rset!= null ){
                                     ret_script += ("//from here\nif(prev_set_objs !=null)\n");
                                     ret_script += ("{\n");
                                        ret_script += ("for(i =0;i<prev_set_objs.length;i++)\n");
                                         ret_script += ("{\n");
                                         ret_script += ( "if(prev_set_objs[i] != null){" ) ;
                                            ret_script += ("prev_set_objs[i].value = ''\n");
                                            
                                            ret_script += ("if(prev_set_objs[i].name == 'first_name' || prev_set_objs[i].name == 'second_name' || prev_set_objs[i].name == 'third_name' || prev_set_objs[i].name == 'family_name'||(prev_set_objs[i].name).indexOf('oth_lang')!= -1){\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.ChangeInitCase(prev_set_objs[i])\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.putPatientName(prev_set_objs[i])}\n") ;
                                            
                                               ret_script += ("if(prev_set_objs[i].name.indexOf('oth_lang') != -1) \n");
                                               ret_script += ("parent.f_query_add_mod.patient_sub.putLocalLangPatientName(obj) \n");

											  ret_script += ( "if( prev_set_objs[i].name == 'date_of_birth'){\n" );
                                              ret_script += ("parent.f_query_add_mod.patient_sub.gotoNext( prev_set_objs[i])\n") ;
                                              ret_script += ("parent.f_query_add_mod.patient_sub.document.getElementById('age_or_dob').disabled = false;}");

                                            ret_script += ("if(prev_set_objs[i].type == 'text')\n");
                                                ret_script += ("prev_set_objs[i].readOnly = false ;\n");
                                            ret_script += ("else\n") ;
                                                 ret_script += ("prev_set_objs[i].disabled = false ;\n");
                                         ret_script += ("}\n");
                                     ret_script += ("}}\n//end here"); 

                                    sql = "select ";
                                    ArrayList screen_items = new ArrayList() ;
                                    ArrayList legends = new ArrayList() ;
                                    while(rset.next())
                                    {
                                        if(rset.getString("DSRC_COL_DATATYPE").equals("D"))
                                            sql += " nvl(to_char("+rset.getString("dsrc_col_name")+",'dd/mm/yyyy'),'')" +"  "+  rset.getString("med_scr_item_name")+", " ;
                                        else
                                            sql += "substr("+rset.getString("dsrc_col_name") +",1,"+rset.getString("med_col_datawidth")+")  "+  rset.getString("med_scr_item_name")+", " ;

                                        if(rset.getString("override_yn").equals("N"))
                                        {
                                            screen_items.add(rset.getString("med_scr_item_name") );
                                        }
                                        
                                        legends.add(rset.getString("med_scr_legend")) ;
                                    }
                                    return_hash.put("disable_items",screen_items) ;
                                    return_hash.put("legends",legends);

                                    if(sql.indexOf(',')!= -1)
                                        sql = sql.substring(0,sql.lastIndexOf(',')) ;

                                    sql += " from  mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                                    
//									 out.println(sql); 
                                    if(rset != null)  rset.close() ;
                                    if(stmt != null)  stmt.close() ;

                                    stmt = con.prepareStatement (sql);
                                    stmt.setString(1,scr_item_value);
                                    rset = stmt.executeQuery();
                                    
                                    java.sql.ResultSetMetaData rsmd = rset.getMetaData();
                                    String cols[] = new String[rsmd.getColumnCount()] ;

                                    if(rset.next()){
                                        for(int i=1; i<=rsmd.getColumnCount();i++){
                                            cols[i-1] = (rsmd.getColumnName(i).toLowerCase()) +"`"+ (rset.getString(i)==null ? " ": rset.getString(i)) ;
                                        }
                                        return_hash.put("disp_vals",cols);
                                    }
                                    if(rset != null)  rset.close() ;
                                }
                                return_hash.put("Return_Script",ret_script);								
                           }
                        }
                    }
                }
            }
        }
        catch(Exception e){try{out.println(e+":"+sql);}catch(Exception e1){}
        }
        finally
        {
            try
            {
            if( stmt != null )  stmt.close() ;
            if( rset != null )  rset.close() ;
            }catch(Exception e){}
        }
        return return_hash ;
   }
   
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 

	request.setCharacterEncoding("UTF-8"); 

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	String localeName=(String)session.getAttribute("LOCALE") ;

	Hashtable hash	= (Hashtable)obj.parseXMLString(request);
 	hash			= (Hashtable)hash.get("SEARCH");
	String frmObj		= (String) hash.get("frmObj");
	String toObj		= (String) hash.get("toObj");
	String param_val	= (String) hash.get("param_val") ;
	if(frmObj == null) frmObj = "";
	if(toObj == null) toObj = "";
	if(param_val == null) param_val = "";
		
	param_val = new String(param_val.getBytes(),"UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);

	String pr_id = (String) hash.get("process_id"); 
    Connection con		= null;
	ResultSet rs			= null;
	ResultSet rs2			= null;
	ResultSet rset			= null;
	PreparedStatement stmt	= null;
	PreparedStatement stmt2	= null;
		
	String date_of_birth = "";
    int process = Integer.parseInt(pr_id);  
	
	String locale			= (String)session.getAttribute("LOCALE");
	String postalcode_link_yn="";
	String defaultSelect	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	try{
		con = ConnectionManager.getConnection(request);
		
	   //Below line added for this CRF ML-MMOH-CRF-0621
	   Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	   //End ML-MMOH-CRF-0621

	   Boolean resiAddMailAdd   	= CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		
		// Getting DATE OF BIRTH FUNCTION, DAYS, MONTH AND YEAR FUNCTION
	    if(process == 2){
			String DAYS,MONTHS,AGE,HOURS;
        
	        DAYS = (String) hash.get("b_days"); 
		    MONTHS = (String) hash.get("b_months"); 
			AGE = (String) hash.get("b_age"); 
			HOURS = (String) hash.get("b_hours"); 
			
			if ( DAYS.equals("")) DAYS = "null";
			if ( MONTHS.equals("")) MONTHS = "null";
	        if ( AGE.equals("")) AGE = "null";
	        if ( HOURS.equals("")) HOURS = "null";
			

			String htmlVal = "";

			String DOB = "";
		    String sql = "select calculate_date_of_birth_hours ("+AGE+","+MONTHS+","+DAYS+","+HOURS+") from dual";
			
		
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs != null){
				rs.next();
		        DOB = rs.getString(1);
			}
			if ( DOB !=null && !DOB.equals("") ){
				if (!localeName.equals("en")){
					DOB = DateUtils.convertDate(DOB,"DMYHMS","en",localeName); 
				}
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		
	        //String htmlVal = "document.getElementById("date_of_birth").value='"+DOB+"';if(!validDateObj(document.getElementById("date_of_birth"),'DMY',\""+localeName+"\")){ doValidation=true;document.getElementById("b_age").value='';document.getElementById("date_of_birth").value='';document.getElementById("b_age").focus();}else{doValidation=false;}document.getElementById("date_of_birth").value='"+DOB+"'";  

	        //String htmlVal = "document.getElementById("date_of_birth").value='"+DOB+"';if(!validDateObj(document.getElementById("date_of_birth"),'DMY',\""+localeName+"\")){ doValidation=true;document.getElementById("b_age").value='';document.getElementById("date_of_birth").value='';document.getElementById("b_age").focus();}else{doValidation=false;}";  

			//out.println("var dob_date='"+DOB+"'; var dob_arr = dob_date.split(' '); birth_date = dob_arr[0]; dob_time = dob_arr[1]; dob_time = dob_time.split(':'); dob_min = dob_time[0]+':'+dob_time[1];");

			//out.println("var dob_date='"+DOB+"'; var dob_arr = dob_date.split(' '); birth_date = dob_arr[0]; dob_time = dob_arr[1]; dob_time = dob_time.split(':'); dob_hrs = parseInt(dob_time[0],'10'); dob_min = parseInt(dob_time[1],'10'); if(dob_min<30){dob_hrs = dob_hrs;} else if(dob_min>=30){dob_hrs = dob_hrs+1;} if(dob_hrs<=9){dob_hrs='0'+dob_hrs+':00';}else{dob_hrs=dob_hrs+':00';} if(dob_hrs=='24:00'){dob_hrs='23:00';}");

			out.println("var dob_date='"+DOB+"'; var dob_arr = dob_date.split(' '); birth_date = dob_arr[0]; dob_time = dob_arr[1]; dob_time = dob_time.split(':'); dob_hrs = parseInt(dob_time[0],'10'); dob_min = parseInt(dob_time[1],'10'); if(dob_hrs<=9){dob_hrs='0'+dob_hrs;} if(dob_min<=9){dob_min='0'+dob_min;} dob_hm = dob_hrs+':'+dob_min; ");

			
			if( DAYS.equals("null") && MONTHS.equals("null") && AGE.equals("null") && !HOURS.equals("null") ) {
			    
			
				htmlVal = htmlVal+"document.getElementById('b_time').value=dob_hm;";
			}				 

			htmlVal = htmlVal+"document.getElementById('date_of_birth').value=birth_date; document.getElementById('Birth_Date').value='"+DOB+"';if(!validDateObj(document.getElementById('date_of_birth'),'DMY',\""+localeName+"\")){ doValidation=true;document.getElementById('b_age').value='';document.getElementById('date_of_birth').value='';}else{doValidation=false;}"; 

			//String htmlVal = "document.getElementById('date_of_birth').value=birth_date;document.getElementById('b_time').value=dob_min; document.getElementById('Birth_Date').value='"+DOB+"';if(!validDateObj(document.getElementById('date_of_birth'),'DMY',\""+localeName+"\")){ doValidation=true;document.getElementById('b_age').value='';document.getElementById('date_of_birth').value='';}else{doValidation=false;}"; 

		    out.println(htmlVal);
			date_of_birth = DOB ;

			if(stmt != null) stmt.close();
	    }
    	if(process == 3){
			String pat_id = (String) hash.get("pat_id");          
	        if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement("select patient_id from mp_patient where patient_id=?");
        
		    stmt.setString(1,pat_id) ;
			rs = stmt.executeQuery();        
			if(rs.next()){
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
				out.println("window.alert(getMessage('DUPL_PAT_ID','MP')); document.getElementById('patient_id').value='';document.getElementById('patient_id').focus();");
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
	        }else {
				String sql = "select count(1) from mp_pat_ser_facility a, mp_pat_ser_grp b, mp_param where a.pat_ser_grp_code =b.pat_ser_grp_code and ? between decode(b.prefix_reqd_yn,'Y',a.pat_ser_grp_code||lpad(start_srl_no, patient_id_length, '0'),lpad(start_srl_no, patient_id_length, '0')) and decode(b.prefix_reqd_yn,'Y',a.pat_ser_grp_code||lpad(max_srl_no, patient_id_length, '0'),lpad(max_srl_no, patient_id_length, '0')) ";
	            stmt = con.prepareStatement(sql);
				stmt.setString(1,pat_id);
			    rs = stmt.executeQuery();
				if (rs.next()){
					if (rs.getInt(1) > 0){
						out.println("window.alert(getMessage('PAT_ID_EXIST_IN_RANGE','MP')); document.getElementById('patient_id').value='';document.getElementById('patient_id').focus();");
					}
				}else{			
					out.println("if (parent.frames[1].document.getElementById('national_id_no').type=='text')  parent.frames[1].document.getElementById('national_id_no').focus(); else if (parent.frames[1].document.getElementById('pat_ser_grp_code').disabled==false) parent.frames[1].document.getElementById('pat_ser_grp_code').focus();");
				}
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		if(process == 13){
			String pat_id = (String) hash.get("pat_id"); // 
			String aban  = (String) hash.get("aban"); // 

			if(aban==null) aban="";
			if(rs!=null) rs.close();
        
			String sql = "select patient_id from mp_patient where patient_id='"+pat_id+"'";
        	stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
	        if(rs.next()){
				if(!aban.equals("")){
					out.println("alert( getMessage('DUPL_PAT_ID','MP')); parent.frames[2].document.getElementById('duplicate').value=\"Y\";document.getElementById('patient_id').focus();");
				}else{
					//out.println("<script language='javascript'>alert('" + rs.getString(1) + "');parent.frames[1].frames[2].document.getElementById('duplicate').value=\"Y\";parent.frames[1].frames[1].document.getElementById('patient_id').focus();");
					out.println("alert(getMessage('DUPL_PAT_ID','MP'));parent.frames[2].document.getElementById('duplicate').value=\"Y\";document.getElementById('patient_id').focus();");
				}
			}else {
				sql = "select count(1) from mp_pat_ser_facility a, mp_pat_ser_grp b, mp_param where a.pat_ser_grp_code =b.pat_ser_grp_code and ? between decode(b.prefix_reqd_yn,'Y',a.pat_ser_grp_code||lpad(start_srl_no, patient_id_length, '0'),lpad(start_srl_no, patient_id_length, '0')) and decode(b.prefix_reqd_yn,'Y',a.pat_ser_grp_code||lpad(max_srl_no, patient_id_length, '0'),lpad(max_srl_no, patient_id_length, '0')) ";
	            stmt = con.prepareStatement(sql);
				stmt.setString(1,pat_id);
			    rs = stmt.executeQuery();
				if (rs.next()){
					if (rs.getInt(1) > 0){
						out.println("window.alert(getMessage('PAT_ID_EXIST_IN_RANGE','MP')); document.getElementById('patient_id').value='';document.getElementById('patient_id').focus();");
					}
				}else{			
					out.println("if (document.getElementById('national_id_no').type=='text')  document.getElementById('national_id_no').focus(); else if (document.getElementById('pat_ser_grp_code').disabled==false) document.getElementById('pat_ser_grp_code').focus();");
				}
				out.println("parent.frames[2].document.getElementById('duplicate').value=\"N\";");	
			}
	      /*  else
		    { 
				if(!aban.equals(""))
				{
					out.println("parent.frames[2].document.getElementById('duplicate').value=\"N\";");
				}
				else
				{
					out.println("parent.frames[1].frames[2].document.getElementById('duplicate').value=\"N\";");	
				}
			}*/
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		

		if(process==36){ 
			    String pat_ser_grp_code = (String) hash.get("pat_ser_grp_code"); 
				String gen_pat_id_yn="";	
			     String pat_no_ctrl="";
				String prefix_reqd_yn="";
				String pat_id_chk_digit_scheme="";
				String allow_family_no_yn="";
				String pat_name_in_loc_lang_reqd_yn="";
				String email_appl_yn="";
				if(rs!=null) rs.close();
        
			String sql = "select GEN_PAT_ID_YN, PAT_NO_CTRL, PREFIX_REQD_YN, PAT_ID_CHK_DIGIT_SCHEME  ,allow_family_no_yn,pat_name_in_loc_lang_reqd_yn,email_appl_yn  from mp_pat_ser_grp_lang_vw where PAT_SER_GRP_CODE='"+pat_ser_grp_code+"' and language_id='"+localeName+"'";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
         if(rs.next()){
		    gen_pat_id_yn=rs.getString("GEN_PAT_ID_YN")==null? "" : rs.getString("GEN_PAT_ID_YN");
		    pat_no_ctrl=rs.getString("PAT_NO_CTRL")==null? "" : rs.getString("PAT_NO_CTRL");
		    prefix_reqd_yn=rs.getString("PREFIX_REQD_YN")==null? "N" : rs.getString("PREFIX_REQD_YN");
		    pat_id_chk_digit_scheme=rs.getString("PAT_ID_CHK_DIGIT_SCHEME")==null ?  "" : rs.getString("PAT_ID_CHK_DIGIT_SCHEME");
		 
		   allow_family_no_yn=rs.getString("allow_family_no_yn")==null? "N" : rs.getString("allow_family_no_yn");
		  pat_name_in_loc_lang_reqd_yn=rs.getString("pat_name_in_loc_lang_reqd_yn")==null? "N" : rs.getString("pat_name_in_loc_lang_reqd_yn");
			email_appl_yn=rs.getString("email_appl_yn")==null? "N" : rs.getString("email_appl_yn");
		}

			out.println("if(patientnumbering_form.pat_ser_chk_dig_scheme){	patientnumbering_form.pat_ser_chk_dig_scheme.value='"+pat_id_chk_digit_scheme+"';}");

			out.println("if(patientnumbering_form.gen_pat_id_yn){	patientnumbering_form.gen_pat_id_yn.value='"+gen_pat_id_yn+"';}");			

			out.println("if(patientnumbering_form.patCtrlVal){	patientnumbering_form.patCtrlVal.value='"+pat_no_ctrl+"';}");

			out.println("if(patientnumbering_form.pat_no_ctrl){	patientnumbering_form.pat_no_ctrl.value='"+pat_no_ctrl+"';}");

			out.println("if(patientnumbering_form.prefix_reqd_yn){	patientnumbering_form.prefix_reqd_yn.value='"+prefix_reqd_yn+"';}");
           
			out.println("if(patientnumbering_form.family_no_link_yn){	patientnumbering_form.family_no_link_yn.value='"+allow_family_no_yn+"';}");

			out.println("if(patientnumbering_form.name_in_oth_lang_yn){	patientnumbering_form.name_in_oth_lang_yn.value='"+pat_name_in_loc_lang_reqd_yn+"';}");

			out.println("if(patientnumbering_form.email_appl_yn){	patientnumbering_form.email_appl_yn.value='"+email_appl_yn+"';}");
			
			
			
			if(gen_pat_id_yn.equals("Y")){ 
			  out.println("patientnumbering_form.gen_pat_id_yn.checked = true;");
			}else{
				out.println("patientnumbering_form.gen_pat_id_yn.checked =false;");
			}

			if(prefix_reqd_yn.equals("Y")){ 
			  out.println("patientnumbering_form.prefix_reqd_yn.checked = true;");
			}else{
				out.println("patientnumbering_form.prefix_reqd_yn.checked =false;");
			}
				
				if(allow_family_no_yn.equals("Y")){ 
			  out.println("patientnumbering_form.family_no_link_yn.checked = true;");
			}else{
				out.println("patientnumbering_form.family_no_link_yn.checked =false;");
			}
			
				if(pat_name_in_loc_lang_reqd_yn.equals("Y")){ 
			  out.println("patientnumbering_form.name_in_oth_lang_yn.checked = true;");
			}
			else{
				out.println("patientnumbering_form.name_in_oth_lang_yn.checked =false;");
			}	
				if(email_appl_yn.equals("Y")){ 
			  out.println("patientnumbering_form.email_appl_yn.checked = true;");
			}else{
				out.println("patientnumbering_form.email_appl_yn.checked =false;");
			}		
				
				if(pat_no_ctrl.equals("Z")){ 
			 out.println("patientnumbering_form.pat_no_ctrl.item(0).checked = true;patientnumbering_form.pat_no_ctrl.item(1).checked =false;patientnumbering_form.pat_no_ctrl.item(2).checked =false;");
				}
				if(pat_no_ctrl.equals("U")){ 
			 out.println("patientnumbering_form.pat_no_ctrl.item(0).checked =false ; patientnumbering_form.pat_no_ctrl.item(1).checked =true;patientnumbering_form.pat_no_ctrl.item(2).checked =false;");
				}
				
				if(pat_no_ctrl.equals("N")){ 
			 out.println("patientnumbering_form.pat_no_ctrl.item(0).checked =false;patientnumbering_form.pat_no_ctrl.item(1).checked =false;patientnumbering_form.pat_no_ctrl.item(2).checked =true;");
				}					
						
	         out.println("patientnumbering_form.prefix_reqd_yn.disabled = true;patientnumbering_form.gen_pat_id_yn.disabled = true;patientnumbering_form.pat_no_ctrl.item(0).disabled = true;patientnumbering_form.pat_no_ctrl.item(1).disabled = true;patientnumbering_form.pat_no_ctrl.item(2).disabled =true;patientnumbering_form.pat_ser_chk_dig_scheme.disabled =true;		patientnumbering_form.family_no_link_yn.disabled =true;patientnumbering_form.name_in_oth_lang_yn.disabled=true;			patientnumbering_form.email_appl_yn.disabled=true;");
				
			
			    if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
		}		
		
		if(process == 4){
			String pat_id = (String) hash.get("family_link_no"); 
			if(rs!=null) rs.close();
        
			String sql = "select patient_id, decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name from mp_patient where patient_id = '"+pat_id+"' ";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		
			if(rs.next()){
					out.println("document.getElementById('head_pat_name').innerHTML=\"<b>&nbsp;&nbsp;"+rs.getString("patient_name")+"\";if(document.getElementById('relationship_to_head_desc') != null){document.getElementById('relationship_to_head_desc').disabled = false;} if(document.getElementById('relationship_to_head_code_id') != null){document.getElementById('relationship_to_head_code_id').disabled = false; document.getElementById('relationship_to_head_code_id').focus();}");
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
			}else {
				out.println("document.getElementById('family_link_no').value='';window.alert(getMessage('INVALID_PATIENT','MP'));document.getElementById('family_link_no').focus();");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(process == 5){
			if(rs!=null) rs.close();

	        String sql = "";
		    String alt_id_no = (String) hash.get("alt_id_no");  
			String error_msg = "";
	   
			int Id_No = Integer.parseInt((String) hash.get("id_no"));
       
		    String dup_data_var = "";		
			if(!alt_id_no.equals("")){
		        if(Id_No == 1){
				    sql = "select patient_id from mp_patient where alt_id1_no ='"+alt_id_no+"'";
					dup_data_var = "alt_id1_no_dup" ;
	            }
		        if( Id_No == 2){
				    sql = "select patient_id from mp_patient where alt_id2_no ='"+alt_id_no+"'";
					dup_data_var = "alt_id2_no_dup" ;
	            }
		        if(Id_No == 3){
				    sql = "select patient_id from mp_patient where alt_id3_no ='"+alt_id_no+"'";
					dup_data_var = "alt_id3_no_dup" ;
				}
	            if(Id_No == 4){
	                sql = "select patient_id from mp_patient where alt_id4_no ='"+alt_id_no+"'";
		            dup_data_var = "alt_id4_no_dup" ;
			    }
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()){
					
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block8Bytes, _wl_block8);

					out.println("var obj=document.getElementById('" + dup_data_var + "');var val='';if( obj != null ) if(obj.value != 'null') val = obj.value;");
					if (Id_No == 1)  {
						out.println("if (document.getElementById('family_org_id_accept_yn').value=='N')  {	    document.getElementById('error_alt_no1').value=\""+error_msg+"1\";document.getElementById('alt_id1_no').focus();document.getElementById('alt_id1_no').value=val;if(document.getElementById('alt_id1_no').value =='' && document.getElementById('alt_id1_exp_date') !=null){document.getElementById('alt_id1_exp_date').readOnly=true;document.getElementById('alt_id1_exp_date').value='';document.getElementById('altidexpdt1').disabled=true;}} ");
				}
                else if(Id_No == 2){
                    out.println("document.getElementById('error_alt_no2').value=\""+error_msg+"2\";document.getElementById('alt_id2_no').focus();document.getElementById('alt_id2_no').value=val;if(document.getElementById('alt_id1_no').value =='' && document.getElementById('alt_id2_exp_date') !=null){document.getElementById('alt_id2_exp_date').readOnly=true;document.getElementById('alt_id2_exp_date').value='';document.getElementById('altidexpdt2').disabled=true;}");
				}
                else if(Id_No == 3){
                    out.println("document.getElementById('error_alt_no3').value=\""+error_msg+"3\";document.getElementById('alt_id3_no').focus();document.getElementById('alt_id3_no').value=val;if(document.getElementById('alt_id1_no').value =='' && document.getElementById('alt_id3_exp_date')!=null){document.getElementById('alt_id3_exp_date').readOnly=true;document.getElementById('alt_id3_exp_date').value='';document.getElementById('altidexpdt3').disabled=true;}");
				}
                else if( Id_No == 4){
						out.println("document.getElementById('error_alt_no4').value=\""+error_msg+"4\";document.getElementById('alt_id4_no').focus();document.getElementById('alt_id4_no').value=val;if(document.getElementById('alt_id1_no').value =='' && document.getElementById('alt_id4_exp_date')!=null){document.getElementById('alt_id4_exp_date').readOnly=true;document.getElementById('alt_id4_exp_date').value='';document.getElementById('altidexpdt4').disabled=true;}");
				}
                //out.println("location.href='../../eCommon/jsp/error.jsp?err_num='") ;
			}else{
				if(Id_No == 1)
					out.println("document.getElementById('error_alt_no1').value='';");
               else if(Id_No == 2)
                    out.println("document.getElementById('error_alt_no2').value='';");
               else if(Id_No == 3)
                    out.println("document.getElementById('error_alt_no3').value='';");
               else if(Id_No == 4)
                    out.println("document.getElementById('error_alt_no4').value = '';");

              // out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE'></body></html>");

               //process = 12;
               String dig_scheme  = (String) hash.get("alt_id_chk_digit_scheme"); // 
               if(dig_scheme ==null )  dig_scheme="" ;
               process  =  dig_scheme.equals("")? 10 : 12;
			}
			if(rs != null) rs.close();
            if(stmt != null) stmt.close();
        }
    }

	//  FUNCTION FOR EXPIRY DATE CHECKING OF ALTERNATE ID'S 
	/* This function is handled in PatRegExpChk.jsp  */
    if(process == 6){
		
		/* 
		if(rs!=null) rs.close();
        String expiry_date;
        expiry_date = (String) hash.get("expiry_date"); // 
        int ExpDateNo = Integer.parseInt((String) hash.get("expdateno"));

        String sql = "select * from dual where trunc(to_date('"+expiry_date+"','dd/mm/yyyy')) >= trunc(sysdate)";
                
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        if(rs.next())
        {
            out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE'></body></html>");
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
        }
        else 
        {
				out.println("");
			if ( ExpDateNo == 2 )
				out.println("           parent.f_query_add_mod.patient_sub.document.getElementById('alt_id2_exp_date').focus();</body></html>");
			if ( ExpDateNo == 3 )
				out.println("           parent.f_query_add_mod.patient_sub.document.getElementById('alt_id3_exp_date').focus();</body></html>");
			if ( ExpDateNo == 4 )
				out.println("           parent.f_query_add_mod.patient_sub.document.getElementById('alt_id4_exp_date').focus();</body></html>");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		*/
	}

// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
    
	
	if(process == 7){
		String postal_code = (String) hash.get("postal_code"); 
		if(postal_code == null) postal_code = "";
		String res_area_code = (String) hash.get("res_area_code"); 
		if(res_area_code==null) res_area_code ="";
		String region_code = (String) hash.get("region_code"); 
		if(region_code==null) region_code ="";
		String prev_region = (String) hash.get("prev_region"); 
		if(prev_region==null) prev_region ="";
		
		String res_town_code = (String) hash.get("res_town_code"); 
		if (res_town_code==null) res_town_code ="";
		

		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
		String fieldName6 ="";
        String mode = (String) hash.get("mode");
		if (mode==null) mode="";
		
		
		String sql = "";
		
		if(mode.equals("first_postal_code"))
		{
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code"))
		{
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_ma_postal_code"))
		{
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_contact_ma_area_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
			fieldName5 = "nkma_town";
		}
		else if(mode.equals("fst_no_ma_pos_cod"))
		{
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_to_no_ma_area_code";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
			fieldName5 = "contact2_res_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
		}
		else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_town_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
		}
		else if(mode.equals("fst_to_no_ma_town_code")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		/*Below line added for this CRF ML-MOH-CRF-0601*/	
		}else if(mode.equals("a_town_code")){
			fieldName = "a_area_code";			
			fieldName1 = "alt_postal_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_area";
			//End ML-MOH-CRF-0601
		}else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
        //Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_area_code")){
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_town";
		}
		else if(mode.equals("fst_to_no_ma_area_code")){
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_town";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
			//Added for this CRF ML-MMOH-CRF-0601
		}else if(mode.equals("a_area_code")){
			fieldName = "a_town_code";			
			fieldName1 = "alt_postal_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_town";
			//End ML-MMOH-CRF-0601
		}else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
			fieldName5 = "next_country_code";
			fieldName6 = "next_country_desc";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
        else if(mode.equals("n_contac_region_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_contact_ma_town_code";
			fieldName2 = "n_ma_postal_code";
			fieldName3 = "nkma_area";
			fieldName4 = "nkma_town";
			fieldName5 = "nkin_mail_country_code";
			fieldName6 = "nk_ma_country_desc";
		}
		else if(mode.equals("fst_to_no_ma_reg_cod")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_to_no_ma_town_code";
			fieldName2 = "fst_no_ma_pos_cod";
			fieldName3 = "contact2_res_area";
			fieldName4 = "contact2_res_town";
			fieldName5 = "first_mail_country_code";
			fieldName6 = "first_mail_country_desc";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
			fieldName5 = "first_country_code";
			fieldName6 = "first_country_desc";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
			fieldName5 = "empyr_country_code";
			fieldName6 = "empyr_country_desc";
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
			fieldName5 = "r_country_code";
			fieldName6 = "r_country_desc";
		}else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
			fieldName5 = "m_country_code";
			fieldName6 = "m_country_desc";
			//Added for this CRF ML-MMOH-CRF-0601
		}else if(mode.equals("a_region_code")){
			fieldName = "a_area_code";
			fieldName1 = "a_town_code";
			fieldName2 = "alt_postal_code";
			fieldName3 = "a_area";
			fieldName4 = "a_town";
			fieldName5 = "a_country_code";
			fieldName6 = "a_country_desc";
		}else if(mode.equals("alt_postal_code")){
			fieldName = "a_town_code";
			fieldName1 = "a_area_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_area";
			fieldName5 = "a_town";
		}		
		//End this ML-MMOH-CRF-0601

        if(rs!=null) rs.close();
		  if(stmt != null) stmt.close();
		
	        stmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
			   rs = stmt.executeQuery();
		    	if (rs.next()){
				postalcode_link_yn = rs.getString("POSTAL_CODE_LINK_YN");
				}
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close(); 
		if(postalcode_link_yn.equals("Y"))
		{

        	
		
	if (!postal_code.equals("")){
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where a.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()){
				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("if (document.getElementById('" + fieldName + "') != null) document.getElementById('" + fieldName + "').value = '" + town_code + "';");
				out.println("document.getElementById('" + fieldName5 + "').value = '" + (rs.getString("res_town_code") == null ? "" : rs.getString("res_town_code")) + "';");


				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next()){
					out.println("if (document.getElementById('" + fieldName1 + "') != null) document.getElementById('" + fieldName1 + "').value = '" + (rs.getString("res_area_desc") == null ? "" : rs.getString("res_area_desc")) + "';");
					out.println("if (document.getElementById('" + fieldName2 + "') != null) document.getElementById('" + fieldName2 + "').value = '" + (rs.getString("region_desc") == null ? "" : rs.getString("region_desc")) + "';");
					out.println("document.getElementById('" + fieldName4 + "').value = '" + (rs.getString("res_area_code") == null ? "" : rs.getString("res_area_code")) + "';");
					out.println("document.getElementById('" + fieldName3 + "').value = '" + (rs.getString("region_code") == null ? "" : rs.getString("region_code")) + "';");

				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!res_town_code.equals("")){
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
									
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()){
			    out.println("if (document.getElementById('" + fieldName + "') != null) document.getElementById('" + fieldName + "').value = '" + (rs.getString("res_area_desc") == null ? "" : rs.getString("res_area_desc")) + "';");
				out.println("if (document.getElementById('" + fieldName2 + "') != null) document.getElementById('" + fieldName2 + "').value = '" + (rs.getString("region_desc") == null ? "" : rs.getString("region_desc")) + "';");
				out.println("document.getElementById('" + fieldName4 + "').value = '" + (rs.getString("res_area_code") == null ? "" : rs.getString("res_area_code")) + "';");
				out.println("document.getElementById('" + fieldName3 + "').value = '" + (rs.getString("region_code") == null ? "" : rs.getString("region_code")) + "';");

			}	
			out.println("if (document.getElementById('" + fieldName1 + "') != null) { document.getElementById('" + fieldName1 + "').value = '' }");

			//sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";
			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";
						
			stmt2 = con.prepareStatement(sql);
			rs2 = stmt2.executeQuery();
			if(rs2.next()){
				out.println("if (document.getElementById('" + fieldName1 + "') != null) { document.getElementById('" + fieldName1 + "').value = \"" + (rs2.getString("postal_code") == null ? "" : rs2.getString("postal_code")) + "\" }");
				out.println("if (document.getElementById('" + fieldName1 + "1') != null) { document.getElementById('" + fieldName1 + "1').value = \"" + (rs2.getString("short_desc") == null ? "" : rs2.getString("short_desc")) + "\" }");

				
			}
			/*
		if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("if (document.getElementById('" + fieldName1 + "1')) document.getElementById('" + fieldName1 + "1').focus();");
			}
			else
			{
			out.println("if (document.getElementById('" + fieldName1 + "')) document.getElementById('" + fieldName1 + "').focus();");
			}
			*/
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
			if(rs2!=null) rs2.close();
			if(stmt2 != null) stmt2.close();
		}
		if(!res_area_code.equals("")){

			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				out.println("if (document.getElementById('" + fieldName1 + "') != null) document.getElementById('" + fieldName1 + "').value = '';"); 
				out.println("if (document.getElementById('" + fieldName2 + "') != null) document.getElementById('" + fieldName2 + "').value = \"" + (rs.getString("long_desc") == null ? "" : rs.getString("long_desc")) + "\";");
				out.println("document.getElementById('" + fieldName3 + "').value = \"" + (rs.getString("region_code") == null ? "" : rs.getString("region_code")) + "\";");

			}else{
				out.println("if (document.getElementById('" + fieldName + "')) document.getElementById('" + fieldName + "').value = '';"); 
				out.println("if (document.getElementById('" + fieldName1 + "')) document.getElementById('" + fieldName1 + "').value = '';"); 
				out.println("if (document.getElementById('" + fieldName2 + "')) document.getElementById('" + fieldName2 + "').value = '';"); 
				out.println("document.getElementById('" + fieldName3 + "').value = '';"); 
				out.println("document.getElementById('" + fieldName4 + "').value = '';");

			}
			/*
			out.println("if (document.getElementById('" + fieldName1 + "'))");
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code"))
			{
			out.println("if (document.getElementById('" + fieldName2 + "1')) { document.getElementById('" + fieldName1 + "1').focus(); }");
			}
			else
			{
			out.println("document.getElementById('" + fieldName1 + "').focus();");
			}
			*/

			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(!region_code.equals("")){

			sql = "select country_code,long_name from mp_country_lang_vw where language_id='"+locale+"' and country_code = (select country_code from mp_region where region_code ='"+region_code+"')";
			System.err.println("========sql====== : "+sql);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
			out.println("if (document.getElementById('" + fieldName1 + "') != null) document.getElementById('" + fieldName1 + "').value = '';"); 
out.println("if (document.getElementById('" + fieldName6 + "') != null) document.getElementById('" + fieldName6 + "').value = \"" + (rs.getString("long_name") == null ? "" : rs.getString("long_name")) + "\";");
out.println("document.getElementById('" + fieldName5 + "').value = \"" + (rs.getString("country_code") == null ? "" : rs.getString("country_code")) + "\";");

			}else{
				out.println("if (document.getElementById('" + fieldName + "')) document.getElementById('" + fieldName + "').value = '';"); 
out.println("if (document.getElementById('" + fieldName1 + "')) document.getElementById('" + fieldName1 + "').value = '';"); 
out.println("if (document.getElementById('" + fieldName2 + "')) document.getElementById('" + fieldName2 + "').value = '';"); 
out.println("document.getElementById('" + fieldName3 + "').value = '';"); 
out.println("document.getElementById('" + fieldName4 + "').value = '';");

			}
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}
	}else{
	        // ********** Modification against Incident Number 28817 on 19-03-2012 by Saanthaakumar ************
out.println("if (document.getElementById('" + fieldName + "'))"); // out.println("document.getElementById('" + fieldName + "').value='';");
out.println("if (document.getElementById('" + fieldName2 + "'))");
out.println("if (document.getElementById('" + fieldName1 + "'))");
// out.println("document.getElementById('" + fieldName3 + "').value='';");
// out.println("document.getElementById('" + fieldName4 + "').value='';");
// Modification over //

	}
		
		if(!region_code.equals("") && !prev_region.equals("") && !region_code.equals(prev_region)){
			out.println("if (document.getElementById('" + fieldName + "')) document.getElementById('" + fieldName + "').value = '';"); 
out.println("if (document.getElementById('" + fieldName2 + "')) document.getElementById('" + fieldName2 + "').value = '';"); 
out.println("if (document.getElementById('" + fieldName1 + "')) document.getElementById('" + fieldName1 + "').value = '';"); 
out.println("document.getElementById('" + fieldName3 + "').value = '';"); 
out.println("document.getElementById('" + fieldName4 + "').value = '';");

			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code"))
			{
out.println("if (document.getElementById('" + fieldName2 + "1')) { document.getElementById('" + fieldName2 + "1').focus(); }");
			}
			else
			{
out.println("document.getElementById('" + fieldName2 + "').focus();");
			}
			*/
		}
    }
    

// FOR POPULATING THE HEAD PATIENT DETAILS IN PAIENT REGISTRATION
    if ( process == 8 ){
        String pat_id;
        pat_id = (String) hash.get("head_patient_id");
		if(rs!=null) rs.close();
        String sql = "SELECT nvl(b.addr1_line1,'') resi_addr_line1, nvl(addr1_line2,'') resi_addr_line2, nvl(addr1_line3,'') resi_addr_line3, nvl(addr1_line4,'') resi_addr_line4, nvl(b.postal1_code,'') resi_postal_code, nvl(country1_code,'') resi_country_code , nvl(contact1_name,'') resi_contact1_name, nvl(a.contact1_no,'') prn_tel_no, nvl(contact2_no,'') orn_tel_no, decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, nvl(a.res_area_code,'') res_area_code, nvl(a.res_town_code,'') res_town_code, nvl(a.region_code,'') region_code, nvl(mp_get_desc.mp_country(b.country1_code, '"+locale+"', '1'),'') resi_country_name, nvl(mp_get_desc.mp_res_town(a.res_town_code,'"+locale+"','1') ,'') res_town_long_desc, nvl(mp_get_desc.mp_res_area(a.res_area_code,'"+locale+"','1'),'') res_area_long_desc, nvl(mp_get_desc.mp_region(a.region_code,'"+locale+"','1'),'') region_long_desc, nvl(mp_get_desc.mp_postal_code(b.postal1_code,'"+locale+"',2),'') resi_postal_desc FROM mp_patient a, mp_pat_addresses b WHERE a.patient_id='"+pat_id+"' and a.patient_id = b.patient_id"; 
		
       
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        if ( rs!= null && rs.next() ){
           // String htmlVal = "";
            //out.println(htmlVal);
        }
        else 
            out.println("Head Patient details not available");
		if(rs!=null) rs.close();
		if(stmt != null) stmt.close();
    }
        
    if(process == 12){
        
        int Id_No = Integer.parseInt((String) hash.get("id_no"));
        String alt_id_chk_digit_scheme  =(String) hash.get("alt_id_chk_digit_scheme") ;
        String sql = "select program_name from mp_check_digit_scheme where scheme_id='"+alt_id_chk_digit_scheme+"'" ;
        
		stmt = con.prepareStatement(sql);
		rset = stmt.executeQuery();
        if(rset.next())  {
			alt_id_chk_digit_scheme = rset.getString(1);
		}
		if(stmt != null) stmt.close();
							
        String alt_id_no = (String) hash.get("alt_id_no");
        
        if(!alt_id_no.equals("")){
            sql= "select "+alt_id_chk_digit_scheme +"('"+alt_id_no+"') from dual" ;
              
                if(rset != null)    rset.close() ;
           
				stmt = con.prepareStatement(sql);
				rset = stmt.executeQuery();
                rset.next() ;
                if(rset.getString(1).equals("TRUE"))
                    process = 10;
                else{
                
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block13Bytes, _wl_block13);

                }
            
                if(stmt != null)    stmt.close();
                if(rset != null)    rset.close();
           
        }
    }
	   
	if( process == 10){
		String alt_id_no = (String)hash.get("alt_id_no") == null ? (String)hash.get("alt_id_no") : (String)hash.get("alt_id_no") ;
        int Id_No = Integer.parseInt( ((String)hash.get("id_no") == null ? "0":(String)hash.get("id_no")) );
        String scr_name = "alt_id1_no";
        alt_id_no = java.net.URLDecoder.decode(alt_id_no) ;
       
        String dup_data_var = "alt_id1_no_dup" ;

		String nat_routine = (String)hash.get("nat_routine");
		if (nat_routine==null) nat_routine="N";
		//Added by kumar on 10/9/2002 for Adding patient series group value only to Alternate Series
		PreparedStatement pstmt = null;
		
		String site = ""; 
		String nme = "";
		String val = "";

		
			pstmt = con.prepareStatement("select site_id from sm_site_param");
			rset = pstmt.executeQuery();
			if (rset.next())
				site = rset.getString("site_id");
		
			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();

		String fac_id = (String)session.getValue("facility_id");
		//End of addition

        if(Id_No == 0){
            scr_name = "national_id_no";
        }else if(Id_No == 2){
            scr_name = "alt_id2_no";
        }
        else if(Id_No == 3){
            scr_name = "alt_id3_no";
            dup_data_var = "alt_id3_no_dup" ;
        }else if(Id_No == 4){
            scr_name = "alt_id4_no";
            dup_data_var = "alt_id4_no_dup" ;
        }
        
            String curr_ds_id = (String)hash.get("curr_ds_id");
			if (curr_ds_id==null) curr_ds_id = "";
            String first_time_only =(String)hash.get("first_time_only");
            if(first_time_only == null) first_time_only = "N";
            
            String operation = (String)hash.get("operation") ;
            if(operation ==null)  operation="insert" ;
			String operation_modify = operation; //Condition added for not disabling the fields on change patient details.
            if(operation.equals("Generate_File"))   operation = "insert" ;
            if(first_time_only.equals("Y")) operation = "insert" ;
            
			out.println("");
            out.println("var prev_set_objs =prev_set_objs ;");
            
            
            if( !curr_ds_id.equals("") && nat_routine.equals("N")){
				HashMap ret_hash = HealthCardData(con,curr_ds_id, scr_name,alt_id_no,out,"") ; 
				
                if(!ret_hash.isEmpty()) {					
					out.println((String)ret_hash. get("Return_Script")) ;
                    out.println("prev_set_objs= new Array();");
                    
                    ArrayList disable_items = (ArrayList)ret_hash.get("disable_items");
                    ArrayList legends = (ArrayList)ret_hash.get("legends");

                    String vals[] = ( String[] )ret_hash.get("disp_vals");
					if (operation_modify.equals("insert") || operation_modify.equals("Generate_File")){						
						for(int i=0; i<disable_items.size(); i++){
							out.println ( "var obj = eval(document.all."+(String)disable_items.get(i)+");" );
							out.println ("if(obj != null){");
							out.println ("if(obj.type == 'text'){");
							out.println ("obj.readOnly = true ;"); 
							out.println ("if(obj.name == 'first_name')    document.getElementById('bf').disabled = true;") ;
							out.println ("if(obj.name == 'second_name')    document.getElementById('bs').disabled = true;") ;
							out.println ("if(obj.name == 'third_name')    document.getElementById('bt').disabled = true;") ;
							out.println ("if(obj.name == 'family_name')    document.getElementById('bfam').disabled = true;"); 
							out.println ("if(obj.name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = true;") ;
							out.println ("if(obj.name == 'second_name_oth_lang')    document.getElementById('bso').disabled = true;") ;
							out.println ("if(obj.name == 'third_name_oth_lang')    document.getElementById('bto').disabled = true;") ;
							out.println ("if(obj.name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = true;}"); 
							out.println ("else") ;
							out.println ("obj.disabled = true ;}"); 
						}
					}
                    boolean dispConfirm = false; 
                    
                    if(operation.equals("modify"))  
						dispConfirm = true;

                    out.println("var arr = new Array () ;") ;
                    out.println("var old_vals = new Array();") ;
                    out.println("var new_vals = new Array();") ;   
                    out.println("var legends = new Array();") ;
                    out.println("var comp_name = new Array();") ;
                    out.println("var objs = new Array();") ;   
                    out.println("var ide = 0");
					String sql_one="select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"' and id_type not in ('R', 'X') and id_type = 'A' and gen_pat_id_yn = 'Y' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S',?,'F',?))OR associated_pat_ser_grp_code IS NOT NULL) union select pat_ser_grp_code,short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"' and  id_type not in ('R', 'X') and id_type = 'A' and gen_pat_id_yn = 'N' order by 2";
					pstmt = con.prepareStatement(sql_one);
					String Nat_Query		="select  long_desc from mp_country where country_code=?";
					String mar_sts_qry	="select  long_desc from mp_marital_status where mar_status_code=?";
					String rlgn_qry			="select  long_desc from mp_religion where relgn_code=?";
					String lang_qry			="select  long_name from mp_language where lang_id=?";
					String Occpn_qry		="select  long_desc from mp_occupation where ocpn_code=?";
					String facility_qry		="SELECT facility_name FROM sm_facility_param_lang_vw WHERE language_id = '"+locale+"' and Facility_Type = 'F' and facility_id =?";

					String nat_desc="";
					String mar_sts_desc="";
					String relgn_desc="";
					String lang_desc="";
					String fcy_desc="";	
					String ocpn_desc="";

				PreparedStatement nat_pstmt=null,mar_sts_pt=null,relgn_pstmt=null,lang_pstmt=null,ocpn_pstmt=null,fcy_pstmt=null;

				ResultSet nat_rslt=null,mar_sts_rslt=null,relgn_rslt=null,lang_rslt=null,ocpn_rslt=null,fcy_rslt=null;
					nat_pstmt=con.prepareStatement(Nat_Query);
					mar_sts_pt=con.prepareStatement(mar_sts_qry);
					relgn_pstmt=con.prepareStatement(rlgn_qry);
					lang_pstmt=con.prepareStatement(lang_qry);
					ocpn_pstmt=con.prepareStatement(Occpn_qry);
					fcy_pstmt=con.prepareStatement(facility_qry);
			
					for(int i=0; i<vals.length; i++)  {

						String strcf	= vals[i];	
						int intind_1	= strcf.indexOf('`');
						nme		= strcf.substring(0, intind_1).trim();
						val		= strcf.substring(intind_1+1).trim();
					
						if(val.equals(" "))   val = "";

//						out.println ( "var obj = eval(document.all."+nme+");" );
				        out.println ( "var obj = eval(document.getElementById('nme');" );
						//out.print("alert(obj)");

									if(nme.equals("nationality_code")){											
										nat_pstmt.setString(1,val);
										nat_rslt=nat_pstmt.executeQuery();
										if(nat_rslt!=null && nat_rslt.next()){ 							 nat_desc=nat_rslt.getString("long_desc")==null?"":nat_rslt.getString("long_desc");				
										}
									}

									if(nme.equals("mar_status_code")){ 		
										
										mar_sts_pt.setString(1,val);
										mar_sts_rslt=mar_sts_pt.executeQuery();
										if(mar_sts_rslt!=null && mar_sts_rslt.next()){
											mar_sts_desc=mar_sts_rslt.getString("long_desc")==null?"":mar_sts_rslt.getString("long_desc"); 				
										}
									}

									if(nme.equals("relgn_code")){ 									
										
										relgn_pstmt.setString(1,val);
										relgn_rslt=relgn_pstmt.executeQuery();
										if(relgn_rslt!=null && relgn_rslt.next()){
											relgn_desc=relgn_rslt.getString("long_desc")==null?"":relgn_rslt.getString("long_desc"); 						
										}								
									}
									
									if(nme.equals("language_code")){
										
										lang_pstmt.setString(1,val);
										lang_rslt=lang_pstmt.executeQuery();
										if(lang_rslt!=null && lang_rslt.next()){
											lang_desc=lang_rslt.getString("long_name")==null?"":lang_rslt.getString("long_name");							
										}
									}
									
									if(nme.equals("pref_facility_id")){											
																			
										fcy_pstmt.setString(1,val);											
										fcy_rslt = fcy_pstmt.executeQuery(); 						
										if(fcy_rslt!=null && fcy_rslt.next()){
											fcy_desc=fcy_rslt.getString("facility_name")==null?"":fcy_rslt.getString("facility_name");				
										}
									}

									if(nme.equals("next_job_title")){ 									
										
										ocpn_pstmt.setString(1,val);
										ocpn_rslt=ocpn_pstmt.executeQuery();
										if(ocpn_rslt!=null && ocpn_rslt.next()){ 						ocpn_desc=ocpn_rslt.getString("long_desc")==null?"":ocpn_rslt.getString("long_desc");						
										}
									}

	
					    
						if(operation.equals("modify")){
							out.println("for(var j=0;j<original_vals[0].length;j++){" ) ;
                            out.println ("if(original_vals[0][j] == '"+nme+"')") ;
                            out.println("var oldval = original_vals[1][j]; if (oldval==null || oldval=='null') oldval=''; old_vals[ide] = oldval");
	                        out.println("}") ;
							out.println("legends[ide] =\""+ (String)legends.get(i)+"\"") ;
							out.println("new_vals[ide] = \""+val+"\";");
							out.println("objs[ide] = obj;");
							out.println("ide++");
						}else if(operation.equals("insert")){
							out.println("");
							out.println( "if(obj != null) {prev_set_objs["+i+"]=obj ") ;
							if(first_time_only.equals("N")){

								if(nme.equals("date_of_birth")){ 
									date_of_birth = val ;
								}
							        out.println("obj.value =\""+val+"\";");
									out.println("if(obj.name == 'date_of_birth'){");
									out.println("gotoNext(document.getElementById('date_of_birth'))");
									out.println("}");

									out.println("if(obj.name == 'first_name' || obj.name == 'second_name' || obj.name == 'third_name' || obj.name == 'family_name' ||(obj.name).indexOf('oth_lang') != -1 ){") ; 
									out.println("ChangeInitCase(obj)") ;
									out.println("putPatientName(obj)}") ;

									out.println( "if(obj.name.indexOf('oth_lang') != -1)" ); 
									out.println("putLocalLangPatientName(obj)") ;

									out.println( "if(obj.name == 'alt_id1_exp_date'){" ); 
                                	out.println("document.getElementById('alt_exp_date_fromHCS').value = 'Y';}") ;

									out.println( "if(obj.name == 'date_of_birth'){" ); 
                                	out.println("document.getElementById('age_or_dob').disabled = true; document.getElementById('imgdateofbirth').disabled = true;}") ;

									if(nme.equals("nationality_code")){	
										out.println("document.getElementById('nationality_desc').value='"+nat_desc+"';"); 
										if(nat_desc.equals(""))	{
											 out.println("document.getElementById('nationality_code').value='';");
										}
									}

									if(nme.equals("mar_status_code")){										
										out.println("document.getElementById('mar_status_desc').value='"+mar_sts_desc+"';");
										if(mar_sts_desc.equals(""))	{
											out.println("document.getElementById('mar_status_code').value='';");
										}
									}

									if(nme.equals("relgn_code")){										
										out.println("document.getElementById('relgn_desc').value='"+relgn_desc+"';"); 
										if(relgn_desc.equals("")) {
											out.println("document.getElementById('relgn_code').value='';"); 
										}
									}
									
									if(nme.equals("language_code")){
										out.println("document.getElementById('language_desc').value='"+lang_desc+"';");	
										if(lang_desc.equals("")) {
											out.println("document.getElementById('language_code').value='';");
										}
									}
									
									if(nme.equals("pref_facility_id")) {
										out.println("document.getElementById('pref_facility_desc').value='"+fcy_desc+"';"); 
										if(fcy_desc.equals("")) {
											out.println("document.getElementById('pref_facility_id').value='';"); 
										}
									}

									/*
									if(nme.equals("next_job_title")) {						
										out.println("document.getElementById('next_job_title').value=\""+ocpn_desc+"\";"); 	
									}
									*/
                                	
									/*
									if(nme.equals("nationality_code")){ 									
										String nat_desc="";
										nat_pstmt.setString(1,val);
										nat_rslt=nat_pstmt.executeQuery();
										if(nat_rslt!=null && nat_rslt.next()){
											 nat_desc=nat_rslt.getString("long_desc");
											out.println("document.getElementById('nationality_desc').value=\""+nat_desc+"\";");
										}else{
											out.println("document.getElementById('nationality_desc').value=\""+nat_desc+"\";");
										}
									}

									if(nme.equals("mar_status_code")){ 		
										String mar_sts_desc="";
										mar_sts_pt.setString(1,val);
										mar_sts_rslt=mar_sts_pt.executeQuery();
										if(mar_sts_rslt!=null && mar_sts_rslt.next()){
										 mar_sts_desc=mar_sts_rslt.getString("long_desc");
										out.println("document.getElementById('mar_status_desc').value=\""+mar_sts_desc+"\";");
										}else{
										out.println("document.getElementById('mar_status_desc').value=\""+mar_sts_desc+"\";");
										}
									}

									if(nme.equals("relgn_code")){ 									
										String relgn_desc="";
										relgn_pstmt.setString(1,val);
										relgn_rslt=relgn_pstmt.executeQuery();
										if(relgn_rslt!=null && relgn_rslt.next()){
										 relgn_desc=relgn_rslt.getString("long_desc");
										out.println("document.getElementById('relgn_desc').value=\""+relgn_desc+"\";");
										}else{
										out.println("document.getElementById('relgn_desc').value=\""+relgn_desc+"\";");
										}									
									}
									
									if(nme.equals("prime_language")){
										String lang_desc="";
										lang_pstmt.setString(1,val);
										lang_rslt=lang_pstmt.executeQuery();
										if(lang_rslt!=null && lang_rslt.next()){
										 lang_desc=lang_rslt.getString("long_name");
										 
										out.println("document.getElementById('language_desc').value=\""+lang_desc+"\";");
										}else{
										out.println("document.getElementById('language_desc').value=\""+lang_desc+"\";");
										}
									}
									
									if(nme.equals("pref_facility_id")){											
										String fcy_desc="";										
										fcy_pstmt.setString(1,val);											
										fcy_rslt = fcy_pstmt.executeQuery(); 						
										if(fcy_rslt!=null && fcy_rslt.next()){
										 fcy_desc=fcy_rslt.getString("facility_name");
										out.println("document.getElementById('pref_facility_desc').value=\""+fcy_desc+"\";");
										}else{
										out.println("document.getElementById('pref_facility_desc').value=\""+fcy_desc+"\";");
										} 	
									}

									if(nme.equals("next_job_title")){ 									
										String ocpn_desc="";
										ocpn_pstmt.setString(1,val);
										ocpn_rslt=ocpn_pstmt.executeQuery();
										if(ocpn_rslt!=null && ocpn_rslt.next()){
										ocpn_desc=ocpn_rslt.getString("long_desc");
										out.println("document.getElementById('occ_of_per').value=\""+ocpn_desc+"\";");
										}else{
										out.println("document.getElementById('next_job_title').value=\""+ocpn_desc+"\";");
										}
									}
									*/
									
									out.println("if(obj !=null && document.getElementById('AltdfltPSG') != null){");
									out.println("if(obj.name == 'alt_id1_no'){") ;
									out.println( "if( ('"+scr_name+"' == 'alt_id1_no' && obj.value !='' && '"+scr_name+"' !='nationa_id_no') || (document.getElementById('alt_id1_no').value != '')  )"); 
								
			//Added by kumar on 9/9/2002 to remove other series types if QID no is not null
									out.println( "{");
									out.println(" var cnt = document.getElementById('pat_ser_grp_code').options.length;for(var j=0;j<cnt;j++)");
					                out.println( "{ document.getElementById('pat_ser_grp_code').remove(document.getElementById('pat_ser_grp_code').options[0]);}");

									out.println("pat_sergrp_id_types = new Array ();var i = 0");
									
										pstmt.setString(1, site);								
										pstmt.setString(2, fac_id);
										rset = pstmt.executeQuery();
										while (rset.next()){
											out.println ("var opt= document.createElement('Option');\nopt.text=\""+rset.getString(2)+"\"; opt.value=\""+rset.getString(1)+"\";\ndocument.getElementById('pat_ser_grp_code').add(opt)") ;
											out.println("pat_sergrp_id_types[i]='"+(rset.getString("id_type") == null ?"" : rset.getString("id_type"))+"';") ;
											out.println("pat_sergrp_reqd_yn[i]='"+(rset.getString("prefix_reqd_yn") == null ? "" : rset.getString("prefix_reqd_yn"))+"';") ;
											out.println("pat_name_in_loc_lang[i]='"+(rset.getString("pat_name_in_loc_lang_reqd_yn") == null ?"N" : rset.getString("pat_name_in_loc_lang_reqd_yn"))+"'; i++") ;
   										} 
										if(rset != null) rset.close();
									
									out.println( "for(var j=0;j<document.getElementById('pat_ser_grp_code').options.length;j++)");	out.println("{if(document.getElementById('pat_ser_grp_code').options[j].value == document.getElementById('AltdfltPSG').value )");
                                	out.println("{document.getElementById('pat_ser_grp_code').options[j].selected = true;break;}");
                                	out.println("else{document.getElementById('pat_ser_grp_code').value=document.getElementById('dflt_pat_ser_grp_code').value}}") ;
									out.println("checkPatGenYN()");
									out.println("}}}");
								}
                             
								out.println ("if(obj.value == '' ){") ; 
								out.println ("if(obj.type == 'text'){");
                                out.println ("obj.readOnly = false ;"); 
                                out.println ("if(obj.name == 'first_name')    document.getElementById('bf').disabled = false;") ;
                                out.println ("if(obj.name == 'second_name')    document.getElementById('bs').disabled = false;") ;
                                out.println ("if(obj.name == 'third_name')    document.getElementById('bt').disabled = false;") ;
                                out.println ("if(obj.name == 'family_name')    document.getElementById('bfam').disabled = false;"); 

                                out.println ("if(obj.name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = false;") ;
                                out.println ("if(obj.name == 'second_name_oth_lang')    document.getElementById('bso').disabled = false;") ;
                                out.println ("if(obj.name == 'third_name_oth_lang')    document.getElementById('bto').disabled = false;") ;
                                out.println ("if(obj.name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = false;}"); 
								out.println ("else") ;
                                out.println ("obj.disabled = false ;}"); 
								out.println("}");
                          		out.println("document.getElementById('datasource_id').value=\""+curr_ds_id+"\" ") ;
							}
							
						}
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();

						if(dispConfirm){
							
            _bw.write(_wl_block14Bytes, _wl_block14);

								out.println( "for(var i=0;i<objs.length;i++){ ") ;
								out.println("obj = objs[i]") ;
								out.println( "if(obj != null) {prev_set_objs[i]=obj ") ;

								out.println("obj.value =new_vals[i];");
								out.println("if(obj.name == 'first_name' || obj.name == 'second_name' || obj.name == 'third_name' || obj.name == 'family_name' ||(obj.name).indexOf('oth_lang') != -1 ){") ; 
								out.println("ChangeInitCase(obj)") ;
								out.println("putPatientName(obj)}") ;

								out.println( "if(obj.name.indexOf('oth_lang') != -1)" ); 
                                out.println("putLocalLangPatientName(obj)") ;

								//out.println( "if(obj.name == 'date_of_birth'){" ); 
                               	//out.println("document.getElementById('age_or_dob').disabled = true;}") ;
                                
								out.println( "if(obj.name == 'alt_id1_exp_date'){" ); 
                              	out.println("document.getElementById('alt_exp_date_fromHCS').value = 'Y';}") ;

								/*
                                out.println("if(obj !=null && document.getElementById('AltdfltPSG') != null){");
                                out.println("if(obj.name == 'alt_id1_no'){") ;
                                out.println( "if( '"+scr_name+"' != 'alt_id1_no' && obj.value !='' && '"+scr_name+"' !='nationa_id_no' )" ); 
                                out.println("{document.getElementById('pat_ser_grp_code').value = document.getElementById("AltdfltPSG").value;}") ;
                                out.println("else{document.getElementById('pat_ser_grp_code').value=document.getElementById('dflt_pat_ser_grp_code').value}") ;
                                out.println("checkPatGenYN()");
                                out.println("}}");
								*/

								out.println("if(obj.name == 'date_of_birth'){");
								out.println("gotoNext(document.getElementById('date_of_birth'))");
								out.println("}"); 	
								
								
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nat_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nat_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mar_sts_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mar_sts_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(lang_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lang_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fcy_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fcy_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);


								/*
								out.println("if(obj.name == 'next_job_title'){");	
								out.println("document.getElementById('occ_of_per').value=\""+ocpn_desc+"\";");		
								out.println("}"); 									
								*/

								out.println ("if(obj.value == '' ){") ; 
                                out.println ("if(obj.type == 'text'){");
                                out.println ("obj.readOnly = false ;"); 
                                out.println ("if(prev_set_objs[i].name == 'first_name')    document.getElementById('bf').disabled = false;") ;
                                out.println ("if(prev_set_objs[i].name == 'second_name')    document.getElementById('bs').disabled = false;") ;
                                out.println ("if(prev_set_objs[i].name == 'third_name')    document.getElementById('bt').disabled = false;") ;
                                out.println("if(prev_set_objs[i].name == 'family_name')    document.getElementById('bfam').disabled = false;"); 
                                out.println ("if(prev_set_objs[i].name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = false;") ;
                                out.println ("if(prev_set_objs[i].name == 'second_name_oth_lang')    document.getElementById('bso').disabled = false;") ;
                                out.println ("if(prev_set_objs[i].name == 'third_name_oth_lang')    document.getElementById('bto').disabled = false;") ;
                                out.println("if(prev_set_objs[i].name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = false;}"); 
                                out.println ("else") ;
                                out.println ("obj.disabled = false ;}"); 
								out.println("}");
								out.println("}") ;
								out.println("document.getElementById('datasource_id').value=\""+curr_ds_id+"\" ") ;
								out.println("document.getElementById('change_data_source').value=\""+curr_ds_id+"\" ") ;
								
            _bw.write(_wl_block26Bytes, _wl_block26);

								out.println( "for(var i=0;i<objs.length;i++){ ") ;
								out.println("obj = objs[i]") ;
								out.println( "if(obj != null) {prev_set_objs[i]=obj ") ;
                            
								out.println("obj.value =old_vals[i];");
								out.println("if(obj.name == 'first_name' || obj.name == 'second_name' || obj.name == 'third_name' || obj.name == 'family_name' ||(obj.name).indexOf('oth_lang') != -1 ){") ; 
								out.println("ChangeInitCase(obj)") ;
								out.println("putPatientName(obj)}") ;

								out.println( "if(obj.name.indexOf('oth_lang') != -1)" ); 
                                out.println("putLocalLangPatientName(obj)") ;

								out.println( "if(obj.name == 'date_of_birth'){" ); 
                                out.println("document.getElementById('age_or_dob').disabled = false;}") ;

                                out.println ("if(obj.type == 'text'){");
                                out.println ("obj.readOnly = false ;"); 
                                out.println ("if(obj.name == 'first_name')    document.getElementById('bf').disabled = false;") ;
                                out.println ("if(obj.name == 'second_name')    document.getElementById('bs').disabled = false;") ;
                                out.println ("if(obj.name == 'third_name')    document.getElementById('bt').disabled = false;") ;
                                out.println ("if(obj.name == 'family_name')    document.getElementById('bfam').disabled = false;"); 
                                out.println ("if(obj.name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = false;") ;
                                out.println ("if(obj.name == 'second_name_oth_lang')    document.getElementById('bso').disabled = false;") ;
                                out.println ("if(obj.name == 'third_name_oth_lang')    document.getElementById('bto').disabled = false;") ;
                                out.println ("if(obj.name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = false;}"); 
                                out.println ("else") ;
                                out.println ("obj.disabled = false ;}"); 
								out.println("}");
  								//out.println("document.all."+scr_name+".select()");
								//out.println("if(document..getElementById('scr_name')){document..getElementById('scr_name').focus()}");
								
            _bw.write(_wl_block27Bytes, _wl_block27);

						}
						out.println("dataFetchedFromRepos='Y';");
						if (scr_name == "alt_id2_no"){
							out.println("dataFetchedFromRepos2='Y';dataFetchedFromRepos1='N';dataFetchedFromRepos3='N';dataFetchedFromRepos4='N';");	
						}
						else if (scr_name == "alt_id3_no"){
							out.println("dataFetchedFromRepos2='N';dataFetchedFromRepos1='N';dataFetchedFromRepos3='Y';dataFetchedFromRepos4='N';");	
						}
						else if (scr_name == "alt_id4_no"){
							out.println("dataFetchedFromRepos2='N';dataFetchedFromRepos1='N';dataFetchedFromRepos3='N';dataFetchedFromRepos4='Y';");
						}
						else{
							out.println("dataFetchedFromRepos2='N';dataFetchedFromRepos1='Y';dataFetchedFromRepos3='N';dataFetchedFromRepos4='N';");
						}
						legends.clear(); 						
					}else{
						if(!alt_id_no.equals("")){
							if(Id_No != 0){
								
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Id_No));
            _bw.write(_wl_block32Bytes, _wl_block32);

							}else{
								out.println("var msg = getMessage('NAT_ID_BLANK_EXT','MP'); msg = msg.replace('#', document.getElementById('nat_id_prompt').value);alert(msg);") ; 
							}
						}
						if(operation.equals("modify")){
							out.println ("if(prev_set_objs !=null)");
							out.println ("{");
                            out.println ("for(i =0;i<prev_set_objs.length;i++)");
                            out.println ("{");
                            out.println("if(prev_set_objs[i] != null){ ") ;
                            out.println("if(prev_set_objs[i].name == 'date_of_birth'){") ;
                            out.println("document.forms[0].age_or_dob.disabled= false ") ;
                            out.println("}") ;
                                 
                            out.println( "if(prev_set_objs[i].name == 'alt_id1_exp_date'){" ); 
                            out.println("document.getElementById('alt_exp_date_fromHCS').value = 'N';}") ;

                            out.println ("for(j =0;j<original_vals[0].length;j++){");
                            out.println ("if(original_vals[0][j] == prev_set_objs[i].name )");
                            out.println ("prev_set_objs[i].value = original_vals[1][j]");
                            out.println("}") ;

                            out.println("if(prev_set_objs[i].type == 'text'){");
                            out.println("prev_set_objs[i].readOnly = false ;");
							out.println ("if(prev_set_objs[i].name == 'first_name')    document.getElementById('bf').disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'second_name')    document.getElementById('bs').disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'third_name')    document.getElementById('bt).disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'family_name')    document.getElementById('bfam').disabled = false;"); 
							out.println ("if(prev_set_objs[i].name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'second_name_oth_lang')    document.getElementById('bso').disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'third_name_oth_lang')    document.getElementById('bto').disabled = false;") ;
							out.println ("if(prev_set_objs[i].name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = false;}"); 
							out.println ("else") ;
                            out.println ("prev_set_objs[i].disabled = false ;");
                            out.println ("}}");
							out.println ("}");
							out.println("prev_set_objs= new Array();");
							out.println("document.getElementById('datasource_id').value=''") ;
						}else{
							if (scr_name == "alt_id2_no"){
								out.println("dataFetchedFromRepos2='N';");	
							}
							else if (scr_name == "alt_id3_no"){
								out.println("dataFetchedFromRepos3='N';");	
							}
							else if (scr_name == "alt_id4_no"){
								out.println("dataFetchedFromRepos4='N';");	
							}else{
								out.println("dataFetchedFromRepos1='N';");	
							}
							out.println("if((dataFetchedFromRepos1 == 'N') && (dataFetchedFromRepos2 == 'N') && (dataFetchedFromRepos3 == 'N') && (dataFetchedFromRepos4 == 'N')) dataFetchedFromRepos = 'N'");

							out.println ("if(prev_set_objs !=null)");
							out.println ("{");
							out.println ("for(i =0;i<prev_set_objs.length;i++)");
							out.println ("{");
							out.println("if(prev_set_objs[i] != null){") ;

							out.println("if (dataFetchedFromRepos=='N') 			{ //prev_set_objs[i].value=''") ;
                            out.println("if(prev_set_objs[i].name == 'first_name' || prev_set_objs[i].name == 'second_name' || prev_set_objs[i].name == 'third_name' || prev_set_objs[i].name == 'family_name' ||(prev_set_objs[i].name).indexOf('oth_lang') != -1 ){") ; 
                            out.println("ChangeInitCase(prev_set_objs[i])") ;
                            out.println("putPatientName(prev_set_objs[i])}") ;
							out.println( "if(prev_set_objs[i].name == 'alt_id1_exp_date'){" ); 
							out.println("document.getElementById('alt_exp_date_fromHCS').value = 'N';}") ;
							out.println( "if(prev_set_objs[i].name.indexOf('oth_lang') != -1)" ); 
                            out.println("putLocalLangPatientName(prev_set_objs[i])") ;
                            out.println("if(prev_set_objs[i].name == 'date_of_birth'){") ;
                            out.println("document.forms[0].age_or_dob.disabled= false ") ;
							out.println("}") ;

                            out.println ("if(prev_set_objs[i].type == 'text'){");
                            out.println ("prev_set_objs[i].readOnly = false ;");
                            out.println ("if(prev_set_objs[i].name == 'first_name')    document.getElementById('bf').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'second_name')    document.getElementById('bs').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'third_name')    document.getElementById('bt').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'family_name')    document.getElementById('bfam').disabled = false;"); 
                            out.println ("if(prev_set_objs[i].name == 'first_name_oth_lang')    document.getElementById('bfo').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'second_name_oth_lang')    document.getElementById('bso').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'third_name_oth_lang')    document.getElementById('bto').disabled = false;") ;
                            out.println ("if(prev_set_objs[i].name == 'family_name_oth_lang')    document.getElementById('bfamo').disabled = false;}"); 
                            out.println ("else") ;
                            out.println ("prev_set_objs[i].disabled = false ;");
                            out.println ("}}");
							out.println ("}}");
						 
							out.println("if (dataFetchedFromRepos=='N') ");
							out.println("prev_set_objs= new Array();");
							out.println("if (dataFetchedFromRepos=='N') ");				out.println("document.getElementById('datasource_id').value=''") ;
						}
					}
				}
				else if( curr_ds_id.equals("VERIFY_NATIONAL_ID")  && nat_routine.equals("Y")){
				String result = "";
				String error_message = "";
				stmt = con.prepareStatement("select VERIFY_NATIONAL_ID('"+alt_id_no+"') FROM DUAL");
				rs = stmt.executeQuery();
				if (rs.next())
					result = rs.getString(1);
				
				StringTokenizer strTok = new StringTokenizer(result,"$");
						
				String age_in_years  = "";
				String age_in_months = "";
				String age_in_days   = "";
				String sex = "";
				String place_of_birth_code="";
				String place_of_birth_desc = "";				
				if (strTok.hasMoreTokens())
					result = strTok.nextToken();
				
				if ( result.equals("TRUE") ){
					if (strTok.hasMoreTokens())
						date_of_birth = strTok.nextToken();	
					if (strTok.hasMoreTokens())
						age_in_years = strTok.nextToken();	
					if (strTok.hasMoreTokens())
						age_in_months = strTok.nextToken();	
					if (strTok.hasMoreTokens())
						age_in_days = strTok.nextToken();	
					if (strTok.hasMoreTokens())
						sex = strTok.nextToken();
					if (strTok.hasMoreTokens())
						place_of_birth_code = strTok.nextToken();
					if (strTok.hasMoreTokens())
						place_of_birth_desc = strTok.nextToken();
					if (!localeName.equals("en"))
					{
						date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",localeName); 
					}
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(age_in_years));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(age_in_months));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(age_in_days));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(place_of_birth_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(place_of_birth_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);

					if(!(place_of_birth_code == null)){
						out.println("document.getElementById('place_of_birth').value=''");
						out.println("document.getElementById('place_of_birth_desc').disabled=false;");
						out.println("document.getElementById('birth_place').disabled=false");
					}
					if(place_of_birth_desc.equals(""))
						out.println("document.getElementById('place_of_birth').disabled=false");
				}
				else if ( result.equals("FALSE") ){
					if(strTok.hasMoreTokens()) 
						error_message = strTok.nextToken();

					out.println("var msg = getMessage('"+error_message+"','MP'); msg = msg.replace('#', document.getElementById('nat_id_prompt').value);alert(msg);document.getElementById('national_id_no').focus();") ;
				}else{
					if (strTok.hasMoreTokens())
						error_message = strTok.nextToken();
					out.println("alert(\""+error_message+"\")");
				}
				strTok = null;
			}else	{
				//Added on 22/2/2003 for focussing to Exp date if external is not set. mainly for emergency registration.
				if (scr_name == "alt_id2_no"){
					//out.println("if (document.getElementById('alt_id2_exp_date')) document.getElementById('alt_id2_exp_date').focus();"); Commented for ML-MMOH-SCF-0434.1 by Rameswar on 10-Aug-16
				}
				else if (scr_name == "alt_id3_no"){
					 //out.println("if (document.getElementById('alt_id3_exp_date')) document.getElementById('alt_id3_exp_date').focus();"); Commented for ML-MMOH-SCF-0434.1 by Rameswar on 10-Aug-16
				}
				else if (scr_name == "alt_id4_no"){
					//out.println("if (document.getElementById('alt_id4_exp_date')) document.getElementById('alt_id4_exp_date').focus();"); Commented for ML-MMOH-SCF-0434.1 by Rameswar on 10-Aug-16
				}
				else if (scr_name == "alt_id1_no"){
					out.println("if (document.getElementById('alt_id1_exp_date')){ document.getElementById('alt_id1_exp_date').disabled=false;}");
					//document.getElementById('alt_id1_exp_date').focus(); Commented for ML-MMOH-SCF-0434.1 by Rameswar on 10-Aug-16
				}
				else if (scr_name == "national_id_no")
					out.println("document.getElementById('alt_id1_no').focus();");
			}
            out.println("prev_set_objs = prev_set_objs ;");
            out.println("");
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
        /*ends here*/
	}
        
    if ( process == 1 ){
		String age_value = "";
		String year_value = "";
		String month_value = "";
		String day_value = "";
		String hours_value = "";

        String DOB = "";
		String objName = "";		
		String birthDate = "";

		String patient_deceased_yn = "";
		String patient_deceased_date = "";



		DOB				= checkForNull((String) hash.get("date_of_birth"));
		objName				= checkForNull((String) hash.get("obj_name"));
		birthDate				= checkForNull((String) hash.get("birthDate"));

		patient_deceased_yn				= checkForNull((String) hash.get("patient_deceased_yn"),"N");
		patient_deceased_date				= checkForNull((String) hash.get("patient_deceased_date"));

		String DateStr = DOB;		
		String DateStr1 = patient_deceased_date;		
		
		if (!localeName.equals("en")) {				
			DateStr = DateUtils.convertDate(DOB,"DMYHMS",localeName,"en");				
			DateStr1 = DateUtils.convertDate(DateStr1,"DMYHMS",localeName,"en");				
		}		
		
		String sql = "";

		if(patient_deceased_yn.equals("Y")) {
			sql = "SELECT MP_GET_AGE_YMDH(TO_DATE('"+DateStr+"','dd/mm/yyyy hh24:mi:ss'),TO_DATE('"+DateStr1+"','dd/mm/yyyy hh24:mi:ss')) FROM dual";
		} else {
			sql = "select MP_GET_AGE_YMDH(to_date('"+DateStr+"','dd/mm/yyyy hh24:mi:ss')) from dual";
		}		
		
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        rs.next();
        age_value = rs.getString(1);		

		StringTokenizer st = new StringTokenizer(age_value," ");

		while ( st.hasMoreTokens() ) {

			String date_elmnt = st.nextToken();			

			char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);			

			String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));			

			if(ymdh_char=='Y') {
				year_value = ymdh_elmnt;
			} else if (ymdh_char=='M') {
				month_value	= ymdh_elmnt;
			} else if (ymdh_char=='D') {
				day_value	= ymdh_elmnt;
			} else if (ymdh_char=='H') {
				hours_value	= ymdh_elmnt;
			}
		}

		/*
		String sql = "select calculate_age_hours('"+DateStr+"',1) from dual";		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        rs.next();
        AGE = rs.getInt(1);

		sql = "select calculate_age_hours('"+DateStr+"',2) from dual";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        rs.next();
        MONTHS = rs.getInt(1);

        sql = "select calculate_age_hours('"+DateStr+"',3) from dual";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        rs.next();
        DAYS = rs.getInt(1);

		sql = "select calculate_age_hours('"+DateStr+"',4) from dual";		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
        rs.next();
        HOURS = rs.getInt(1);			
		*/
		
        StringBuffer htmlVal = new StringBuffer(" document.getElementById('b_age').value='"+year_value+"';document.getElementById('b_months').value='"+ month_value +"';document.getElementById('b_days').value='"+day_value+"';document.getElementById('b_hours').value='"+hours_value+"';document.getElementById('date_of_birth').value='"+birthDate+"';document.getElementById('Birth_Date').value='"+DOB+"';");
		//htmlVal.append(" </body></html>" );
		out.println(htmlVal.toString());
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}

	if ( process == 14 ){	
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(defaultSelect));
            _bw.write(_wl_block43Bytes, _wl_block43);


		String race_code = (String) hash.get("race_code");
		String a_ethnic_group_code = (String) hash.get("a_ethnic_group_code");

		
		if(race_code == null) race_code="";
		if(!race_code.equals("")){	/*Changed Long description to short description - 4/4/2006 : Vinod*/
			String sql = "Select ethnic_group_code,short_desc from mp_ethnic_group_lang_vw where language_id='"+locale+"' and race_code='"+race_code+"' and eff_status='E' and trunc(sysdate) between  nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))  order by 2";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs!=null)
			{
				int i = 0;
				while (rs.next())
				{
					i++;
					
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rs.getString("ethnic_group_code")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rs.getString("ethnic_group_code")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(a_ethnic_group_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
			 }
		 }
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	if ( process == 20 ){
		String postal_code = (String) hash.get("postal_code"); 
		if (postal_code==null) postal_code ="";
		String res_area_code = (String) hash.get("res_area_code"); 
		if (res_area_code==null) res_area_code ="";
		String region_code = (String) hash.get("region_code"); 
		if (region_code==null) region_code ="";
		
		String res_town_code = (String) hash.get("res_town_code"); 
		if (res_town_code==null) res_town_code ="";
		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
		String fieldName6 ="";
        String mode = (String) hash.get("mode"); 
		if (mode==null) mode="";
		
		String sql = "";
		
		
	
		if(mode.equals("first_postal_code")){
			
			fieldName = "contact2_res_town_code";
			fieldName1 = "contact2_res_area_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
			fieldName5 = "f_town";
		}
		else if(mode.equals("next_postal_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "contact1_res_area_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
			fieldName5 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_ma_postal_code"))
		{
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_contact_ma_area_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
			fieldName5 = "nkma_town";
		}
		else if(mode.equals("fst_no_ma_pos_cod"))
		{
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_to_no_ma_area_code";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
			fieldName5 = "contact2_res_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008

		else if(mode.equals("employ_postal_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "contact3_res_area_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
			fieldName5 = "e_town";
		}
		else if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
			fieldName5 = "r_town";
		}
		else if(mode.equals("m_postal_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_area_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
			fieldName5 = "m_town";
			//Below line addded for this CRF ML-MMOH-CRF-0601
		}else if(mode.equals("alt_postal_code")){
			fieldName = "a_town_code";
			fieldName1 = "a_area_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_area";
			fieldName5 = "a_town";
			//End ML-MMOH-CRF-0601
			
		}else if(mode.equals("contact1_res_town_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_area";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_town_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_area";
		}
		else if(mode.equals("fst_to_no_ma_town_code")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_area";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_town_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_area";
		}
		else if(mode.equals("contact3_res_town_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_area";
		}
		else if(mode.equals("m_town_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_area";
		}
		else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_area";
		/*Below line added for this ML-MMOH-CRF-0601*/	
		}else if(mode.equals("a_town_code")){
			fieldName = "a_area_code";
			fieldName1 = "alt_postal_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_area";
		   //End this CRF ML-MMOH-CRF-0601	
		}
		else if(mode.equals("contact1_res_area_code")){
			fieldName = "contact1_res_town_code";
			fieldName1 = "next_postal_code";
			fieldName2 = "contact1_region_code";
			fieldName3 = "n_region";
			fieldName4 = "n_town";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
         else if(mode.equals("n_contact_ma_area_code")){
			fieldName = "n_contact_ma_town_code";
			fieldName1 = "n_ma_postal_code";
			fieldName2 = "n_contac_region_code";
			fieldName3 = "contact1_region";
			fieldName4 = "nkma_town";
		}
		else if(mode.equals("fst_to_no_ma_area_code")){
			fieldName = "fst_to_no_ma_town_code";
			fieldName1 = "fst_no_ma_pos_cod";
			fieldName2 = "fst_to_no_ma_reg_cod";
			fieldName3 = "contact2_region";
			fieldName4 = "contact2_res_town";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_res_area_code")){
			fieldName = "contact2_res_town_code";
			fieldName1 = "first_postal_code";
			fieldName2 = "contact2_region_code";
			fieldName3 = "f_region";
			fieldName4 = "f_town";
		}
		else if(mode.equals("contact3_res_area_code")){
			fieldName = "contact3_res_town_code";
			fieldName1 = "employ_postal_code";
			fieldName2 = "contact3_region_code";
			fieldName3 = "e_region";
			fieldName4 = "e_town";
		}
		else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_region";
			fieldName4 = "r_town";
		}
		else if(mode.equals("m_area_code")){
			fieldName = "m_town_code";
			fieldName1 = "m_postal_code";
			fieldName2 = "m_region_code";
			fieldName3 = "m_region";
			fieldName4 = "m_town";
		/*Below line added for this ML-MMOH-CRF-0601*/	
		}else if(mode.equals("a_area_code")){
			fieldName = "a_town_code";
			fieldName1 = "alt_postal_code";
			fieldName2 = "a_region_code";
			fieldName3 = "a_region";
			fieldName4 = "a_town";
		    //End ML-MMOH-CRF-0601
		}
		else if(mode.equals("contact1_region_code")){
			fieldName = "contact1_res_area_code";
			fieldName1 = "contact1_res_town_code";
			fieldName2 = "next_postal_code";
			fieldName3 = "n_area";
			fieldName4 = "n_town";
			fieldName5 = "next_country_code";
			fieldName6 = "next_country_desc";
		}
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
        else if(mode.equals("n_contac_region_code")){
			fieldName = "n_contact_ma_area_code";
			fieldName1 = "n_contact_ma_town_code";
			fieldName2 = "n_ma_postal_code";
			fieldName3 = "nkma_area";
			fieldName4 = "nkma_town";
			fieldName5 = "nkin_mail_country_code";
			fieldName6 = "nk_ma_country_desc";
		}
		else if(mode.equals("fst_to_no_ma_reg_cod")){
			fieldName = "fst_to_no_ma_area_code";
			fieldName1 = "fst_to_no_ma_town_code";
			fieldName2 = "fst_no_ma_pos_cod";
			fieldName3 = "contact2_res_area";
			fieldName4 = "contact2_res_town";
			fieldName5 = "first_mail_country_code";
			fieldName6 = "first_mail_country_desc";
		}
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		else if(mode.equals("contact2_region_code")){
			fieldName = "contact2_res_area_code";
			fieldName1 = "contact2_res_town_code";
			fieldName2 = "first_postal_code";
			fieldName3 = "f_area";
			fieldName4 = "f_town";
			fieldName5 = "first_country_code";
			fieldName6 = "first_country_desc";
		}
		else if(mode.equals("contact3_region_code")){
			fieldName = "contact3_res_area_code";
			fieldName1 = "contact3_res_town_code";
			fieldName2 = "employ_postal_code";
			fieldName3 = "e_area";
			fieldName4 = "e_town";
			fieldName5 = "empyr_country_code";
			fieldName6 = "empyr_country_desc";			
		}
		else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_town";
			fieldName5 = "r_country_code";
			fieldName6 = "r_country_desc";
		}
		else if(mode.equals("m_region_code")){
			fieldName = "m_area_code";
			fieldName1 = "m_town_code";
			fieldName2 = "m_postal_code";
			fieldName3 = "m_area";
			fieldName4 = "m_town";
			fieldName5 = "m_country_code";
			fieldName6 = "m_country_desc";
			/*Below line added for ML-MMOH-CRF-0601*/
		}else if(mode.equals("a_region_code")){
			fieldName = "a_area_code";
			fieldName1 = "a_town_code";
			fieldName2 = "alt_postal_code";
			fieldName3 = "a_area";
			fieldName4 = "a_town";
			fieldName5 = "a_country_code";
			fieldName6 = "a_country_desc";
		}
		
		//End ML-MMOH-CRF-0601
		
		//Added by kumar on 14/03/2003 for Defaulting area, town, region based on selection.	
         if(rs!=null) rs.close();
		  if(stmt != null) stmt.close();
		
	      stmt = con.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
			   rs = stmt.executeQuery();
		    	if (rs.next()){
				postalcode_link_yn = rs.getString("POSTAL_CODE_LINK_YN");
				}
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close(); 
		if(postalcode_link_yn.equals("Y"))
		{ 
			
		if (!postal_code.equals("")){
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code_lang_vw a, mp_res_town_lang_vw b where b.language_id='"+locale+"' and a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code and a.language_id=b.language_id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()){
				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("if (parent.frames[0].document.forms[0]."+fieldName+" !=null) parent.frames[0].document.forms[0]."+fieldName+".value=\""+town_code+"\";");
				out.println("parent.frames[0].document.forms[0]."+fieldName5+".value=\""+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"\";");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where a.language_id='"+locale+"' and a.res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code and a.language_id=b.language_id" ;

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next()){
					out.println("if (parent.frames[0].document.forms[0]."+fieldName1+" != null) parent.frames[0].document.forms[0]."+fieldName1+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				 
					out.println("if (parent.frames[0].document.forms[0]."+fieldName2+" !=null) parent.frames[0].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				 	out.println("parent.frames[0].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				 	out.println("parent.frames[0].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";");
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if (!res_town_code.equals("")){
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area_lang_vw a, mp_region_lang_vw b where b.language_id='"+locale+"' and res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code and a.language_id=b.language_id";
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()){
				out.println("if (parent.frames[0].document.forms[0]."+fieldName+" != null) parent.frames[0].document.forms[0]."+fieldName+".value=\""+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"\";");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName2+" !=null) parent.frames[0].document.forms[0]."+fieldName2+".value=\""+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"\";");
				out.println("parent.frames[0].document.forms[0]."+fieldName4+".value=\""+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"\";");
				out.println("parent.frames[0].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";");
			}	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			sql="select postal_code,short_desc from mp_postal_code_lang_vw where res_town_code = '"+res_town_code+"' and language_id='"+locale+"'";
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()){
				out.println("if (parent.frames[0].document.forms[0]."+fieldName1+" !=null) {parent.frames[0].document.forms[0]."+fieldName1+".value = \""+(rs.getString("postal_code")==null ? "" : rs.getString("postal_code"))+"\"}else{}");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName1+"1 !=null) {parent.frames[0].document.forms[0]."+fieldName1+"1.value = \""+(rs.getString("short_desc")==null ? "" : rs.getString("short_desc"))+"\"}else{}");
				
			}else{
				out.println("parent.frames[0].document.forms[0]."+fieldName1+".value=''");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();

			/*
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code")){
			out.println("if(parent.frames[0].document.forms[0]."+fieldName1+"1)parent.frames[0].document.forms[0]."+fieldName1+"1.focus();");
			}
			else{
			out.println("if (parent.f_query_add_mod.patient_sub.document.getElementById('" + fieldName1 + "')) parent.frames[0].document.forms[0]." + fieldName1 + ".focus();");
			}
			*/
			/*out.println("if(parent.frames[0].document.forms[0]."+fieldName1+") parent.frames[0].document.forms[0]."+fieldName1+".focus();");*/
		}
		if(!region_code.equals("")){

			sql = "select country_code,long_name from mp_country_lang_vw where language_id='"+locale+"' and country_code = (select country_code from mp_region where region_code ='"+region_code+"')";
			System.err.println("========sql====== : "+sql);
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				out.println("if (document.getElementById('fieldName1') !=null) document..getElementById('fieldName1').value='';");
				out.println("if (document.getElementById('fieldName6') !=null) document.getElementById('fieldName6').value=\""+(rs.getString("long_name")==null ? "" : rs.getString("long_name"))+"\";");
				out.println(" document.getElementById('fieldName5').value=\""+(rs.getString("country_code")==null ? "" : rs.getString("country_code"))+"\";");
			}else{
				out.println(" if(document.getElementById('fieldName')) document.getElementById('fieldName').value='';");
				out.println("if (document.getElementById('fieldName1')) document.getElementById('fieldName1').value='';");
				out.println("if (document.getElementById('fieldName2') ) document.getElementById('fieldName2').value='';");
				out.println("document.getElementById('fieldName3').value='';");
				out.println("document.getElementById('fieldName4').value='';");
			}
			if(rs!=null) rs.close();
			if(stmt != null) stmt.close();
		}
		}else{
                out.println("if (parent.frames[0].document.forms[0]."+fieldName+" ) parent.frames[0].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName1+") parent.frames[0].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName2+" ) parent.frames[0].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[0].document.forms[0]."+fieldName3+".value='';");
	     		out.println("parent.frames[0].document.forms[0]."+fieldName4+".value='';");

		}
		
		if(!res_area_code.equals("")){
			sql = "select region_code,long_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				out.println("if (parent.frames[0].document.forms[0]."+fieldName1+" !=null) parent.frames[0].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName2+" !=null) {parent.frames[0].document.forms[0]."+fieldName2+".value=\""+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"\";}else{}");
				out.println(" parent.frames[0].document.forms[0]."+fieldName3+".value=\""+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"\";");
			}
			else{
				out.println("if (parent.frames[0].document.forms[0]."+fieldName+" ) parent.frames[0].document.forms[0]."+fieldName+".value='';");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName1+") parent.frames[0].document.forms[0]."+fieldName1+".value='';");
				out.println("if (parent.frames[0].document.forms[0]."+fieldName2+" ) parent.frames[0].document.forms[0]."+fieldName2+".value='';");
				out.println("parent.frames[0].document.forms[0]."+fieldName3+".value='';");
				out.println("parent.frames[0].document.forms[0]."+fieldName4+".value='';");
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			//out.println("if(parent.frames[0].document.forms[0]."+fieldName1+")parent.frames[0].document.forms[0]."+fieldName1+".focus();");

			/*
			if(fieldName1.equals("next_postal_code") || fieldName1.equals("first_postal_code") || fieldName1.equals("employ_postal_code") || fieldName1.equals("m_postal_code") || fieldName1.equals("r_postal_code")){
			out.println("if(parent.frames[0].document.forms[0]."+fieldName1+"1)parent.frames[0].document.forms[0]."+fieldName1+"1.focus();");
			}
			else{
			out.println("if(parent.frames[0].document.forms[0]."+fieldName1+")parent.frames[0].document.forms[0]."+fieldName1+".focus();");
			}
			*/
		}
		if(!region_code.equals("")){
			out.println("if(parent.f_query_add_mod != null) { ");
			out.println("if(parent.f_query_add_mod.patient_sub != null) { ");
			out.println("if(parent.f_query_add_mod.patient_sub.document.getElementById('fieldName') ) parent.f_query_add_mod.patient_sub.document.getElementById('fieldName').value='';");
			out.println("if (parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2')) parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2').value='';");
			out.println("if (parent.f_query_add_mod.patient_sub.document.getElementById('fieldName1')) parent.f_query_add_mod.patient_sub.document.getElementById('fieldName1').value='';");
			out.println("parent.f_query_add_mod.patient_sub.document.getElementById('fieldName3').value='';");
			out.println("parent.f_query_add_mod.patient_sub.document.getElementById('fieldName4').value='';");

			/*
			if(fieldName2.equals("next_postal_code") || fieldName2.equals("first_postal_code") || fieldName2.equals("employ_postal_code") || fieldName2.equals("m_postal_code") || fieldName2.equals("r_postal_code")){
			out.println("if(parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2')1)parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2')1.focus();}}");
			}else{
			out.println("if(parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2'))parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2').focus();}}");
			}
			*/

			out.println("}}");
			
			//out.println("parent.f_query_add_mod.patient_sub.document.getElementById('fieldName2').focus();}}");
		}
	}

	if ( process == 15 ){
		
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(defaultSelect));
            _bw.write(_wl_block51Bytes, _wl_block51);

		String occ_class = (String) hash.get("occ_class");
		String sql = "select ocpn_code,short_desc from mp_occupation_lang_vw where language_id='"+locale+"' and ocpn_class_code = '"+occ_class+"' and eff_status='E' order by 2";
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs != null && rs.next()){
			
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rs.getString("ocpn_code")));
            _bw.write(_wl_block54Bytes, _wl_block54);

		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	/*if(process == 21)
	{
		String result = "";
		String error_message = "";
		String nat_id_no = request.getParameter("nationalidno")==null?"":request.getParameter("nationalidno");
		String nat_id_name = request.getParameter("nationalidname")==null?"":request.getParameter("nationalidname");
		String natlength = request.getParameter("natlength")==null?"":request.getParameter("natlength");
						
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		stmt = con.prepareStatement("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
		rs = stmt.executeQuery();
		if (rs.next())
			result = rs.getString(1);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();		
		StringTokenizer strTok = new StringTokenizer(result,"$");				
				
		if (strTok.hasMoreTokens()) 
			result = strTok.nextToken();
		if ( result.equals("TRUE") )
		{
			if(nat_id_name.equals("contact1_new_nat_id_no"))
			{
				if (strTok.hasMoreTokens())
					date_of_birth = strTok.nextToken();
					if  ( !date_of_birth.equals("") ) 
					{
							if  ( !localeName.equals("en"))
							date_of_birth= DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
					}	out.println("parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value='"+date_of_birth+"'");
			}
		}
		else if ( result.equals("FALSE") )
		{
			if (strTok.hasMoreTokens())
				error_message = strTok.nextToken();
out.println("var msg = parent.f_query_add_mod.patient_sub.getMessage('" + error_message + "','MP'); msg = msg.replace('#', parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value); msg = msg.replace('@'," + natlength + "); alert(msg); parent.f_query_add_mod.patient_sub.document.getElementById('" + nat_id_name + "').focus();");
		}
		strTok = null;
	}
	*/
	if(process == 22){
		String nat_code = (String) hash.get("nat_id_code"); 
		String nationality_desc="";
		String sql = "Select long_desc from Mp_Country_lang_vw where eff_status='E' and language_id='"+locale+"' and country_code='"+nat_code+"'";
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		if(rs.next()){
			nationality_desc=rs.getString("long_desc");
			
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);
}

	}

	if(process == 25){
		String relationship_to_head = (String) hash.get("relationship_to_head"); 
		String CalledFromFunction = (String) hash.get("CalledFromFunction"); 
		String relation_level1_code = (String) hash.get("relation_level1_code"); 
		String relationship_level1_description = (String) hash.get("relationship_level1_description");
		
		
		String relationship_level="";
		String sql = "select relationship_level from mp_relationship where relationship_code='"+relationship_to_head+"'";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		if(rs.next()){
			relationship_level=rs.getString("relationship_level");
			
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
		}
		
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(relationship_level));
            _bw.write(_wl_block56Bytes, _wl_block56);


		if(!relationship_level.equals("0")){
			String RelationshipLevel		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RelationshipLevel.label","mp_labels");

				out.println("document.getElementById('relnlabel').innerHTML='"+RelationshipLevel+"'");
				
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) {
			
            _bw.write(_wl_block60Bytes, _wl_block60);

				 } else if(CalledFromFunction.equals("ChangePatDtls")) {  
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(relationship_level1_description));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(relation_level1_code));
            _bw.write(_wl_block63Bytes, _wl_block63);

		}	
		}
		else if(relationship_level.equals("0")){
			
            _bw.write(_wl_block64Bytes, _wl_block64);

		}
	}

	if(process == 30){
		String pat_ser_grp_code = (String) hash.get("pat_ser_grp_code"); 
		String CalledFromFunction = (String) hash.get("CalledFromFunction"); 
		String call_from = (String) hash.get("call_from"); 
		String frame_reference = "";
		if(call_from.equals("call_from_apply"))
			frame_reference = "f_query_add_mod.patient_sub.document.all";
		else if(call_from.equals("call_from_page"))
			frame_reference = "document.forms[0].all";
		
		
		String gen_pid_using_alt_id1_rule_yn="";
		String sql = "select gen_pid_using_alt_id1_rule_yn from mp_pat_ser_grp_lang_vw where pat_ser_grp_code='"+pat_ser_grp_code+"' and language_id = '"+locale+"' ";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		if(rs.next()){
			gen_pid_using_alt_id1_rule_yn=rs.getString("gen_pid_using_alt_id1_rule_yn");
		}
		
		if(gen_pid_using_alt_id1_rule_yn.equals("Y")){
		
		
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(frame_reference));
            _bw.write(_wl_block73Bytes, _wl_block73);

		}	

	}/*Below line Added for this CRF HSA-CRF-0289*/
	if(process == 31){
	String alt_id_name=(String)hash.get("alt_id_name");
	String alt_id_value=(String)hash.get("alt_id_value");
	int altCount=0;
	StringBuffer strBuffer=new StringBuffer("select patient_id from mp_patient where ");
	strBuffer.append(alt_id_name);
	strBuffer.append("='");
	strBuffer.append(alt_id_value).append("'");
	
	stmt = con.prepareStatement(strBuffer.toString());
	rs = stmt.executeQuery();
	while(rs.next()){
    	altCount++;	  
	  }
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(altCount));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
	//End HSA-CRF-0289
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	/*Below line added for this CRF ML-MMOH-CRF-0621*/	
	if(process == 32 && isRegNewbornApplicable){
	String attend_physician_id=request.getParameter("attend_physician_id")==null?"":request.getParameter("attend_physician_id");
	String accept_national_id_no_yn=request.getParameter("accept_national_id_no_yn")==null?"":request.getParameter("accept_national_id_no_yn");
	String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	
	
	String national_id="", other_alter_id ="", nat_other_alter_id="", nat_other_alter_legend="";
	
	StringBuffer natstrBuffer=new StringBuffer("select national_id_num, oth_alt_id_no from am_practitioner where practitioner_id ='");	
	natstrBuffer.append(attend_physician_id).append("'");
			
	
	stmt = con.prepareStatement(natstrBuffer.toString());
	rs = stmt.executeQuery();
	if(rs!=null && rs.next()){
	national_id=rs.getString("national_id_num")==null?"":rs.getString("national_id_num");
	other_alter_id=rs.getString("oth_alt_id_no")==null?"":rs.getString("oth_alt_id_no");    	 
	}
		
	 if(!national_id.equals("")){
                 if(national_id_no.equals("")){
                    nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
                 }else{
                    nat_other_alter_legend=national_id_no;	
                  }				  
				 nat_other_alter_id=national_id;
	 }else if(national_id.equals("") && !other_alter_id.equals("")){
				   nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels"); 
				   nat_other_alter_id=other_alter_id;
				 
	}
	
	
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(nat_other_alter_legend));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(nat_other_alter_id));
            _bw.write(_wl_block78Bytes, _wl_block78);

	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	  }	
	//End ML-MMOH-CRF-0621
	
	
	
}
catch(Exception e){
	e.printStackTrace();
	
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block79Bytes, _wl_block79);
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
