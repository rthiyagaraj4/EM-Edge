package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import com.ehis.util.*;
import eCommon.Common.*;
import eOP.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __aeregisterattnresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterAttnResult.jsp", 1743066665378L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eMP/jsp/PatientAddressLegends.jsp", 1744875458541L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>   \n<head>\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="  \n\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AERegisterAttn.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script> \n  <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script>\n  \n  <script language=\'javascript\' src=\'../../eAE/js/AEPractitionerComponent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n  <script>\n  function aa(){\n\t  if(document.forms[0].PrevEncounter.disabled == true && document.forms[0].visit_within_24hrs.disabled == true){\n\t\t  document.forms[0].visit_date_time.focus();\n\t  }\n  }\n async function tab_click(objName)\n\t{if(objName==\"addVisit_tab\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'tab1\').scrollIntoView();\n\t\t        document.forms[0].visit_date_time.focus();\n\t\t\t}\n\t\t   if(objName==\"arrival_tab\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'tab2\').scrollIntoView();\n\t\t        document.forms[0].accompany_by.focus();\n\t\t\t}\n\t\t\tif(objName==\"rlcnts_tab\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'kin\').scrollIntoView();\n\t\t\t\tdocument.getElementById(\'next_contact_name\').focus();\n\t\t\t}\n\t\t\tif(objName==\"#kin1\") \n\t\t\t{\n             document.getElementById(\'kin1\').scrollIntoView();\n\t\t\t\tdocument.getElementById(\'first_contact_name\').focus();\n\t\t\t}\n\t\t\tif(objName==\"#empyr\")\n\t\t\t {\n\t\t\t\tdocument.getElementById(\'empyr\').scrollIntoView();\n\t\t\t\tdocument.getElementById(\"organization_name\").focus();\n\t\t\t}\n\t\t\tif (objName==\"findtl_tab\")\n\t\t    {\n\t\t\t var bl_install_yn\t= document.forms[0].bl_install_yn.value;   \n             if ((objName == \'findtl_tab\')  && (bl_install_yn == \"Y\")){\n\t\t\t\t if(document.forms[0].visit_type.value!=\"\")\n                   var retval = await chkOnSub();\n\t\t\t\t else{\n\t\t\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\terr = err.replace(\'$\', getLabel(\"eAE.RegistrationType.label\",\"AE\"));\n\t\t\t\t\talert(err)\n\t\t\t\t }\n\t\t\t }\n\n\t\t\t}\n\t}\n\tfunction tab_click1(id) \n\t\t{\n\t\t\tselectTab(id);\n\t\t\ttab_click(id);\n\t\t}\n\n\t\tfunction tab_click2(id,idval){\n\t\t\t\tselectTab(idval);\n\t\t\t\ttab_click22(id);\n\t\t}\n\n\t\tfunction tab_click22(Object)\n\t\t{\n\t\t\tif(Object==\'#kin\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'next_contact_name\')!=null&&document.getElementById(\'next_contact_name\').disabled==false)\n\t\t\t\tdocument.getElementById(\'next_contact_name\').focus();\n\t\t\t\t else\n\t\t\t\t document.getElementById(\'kin\').scrollIntoView();\n\t\t\t}\n\t\t\tif(Object==\'#kin1\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'first_contact_name\')!=null&&document.getElementById(\'first_contact_name\').disabled==false)\n\t\t\t\tdocument.getElementById(\'first_contact_name\').focus();\n\t\t\t\t else\n\t\t\t\t   document.getElementById(\'kin1\').scrollIntoView();\n\t\t\t}\n\t\t\tif(Object==\'#empyr\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"organization_name\")!=null&&document.getElementById(\"organization_name\").disabled==false)\n\t\t\t\tdocument.getElementById(\"organization_name\").focus();\n\t\t\t\telse\n\t\t\t\t  document.getElementById(\'empyr\').scrollIntoView();\n\t\t\t}\n\t\t}\n\n\n\t\tfunction expandCollapse(calledFrom) {\t\t\t\t\t\n\n\t\t\t\t\tif(calledFrom == \'add_Visit_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'none\';\t\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'arrival_tab\') {\n\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'rel_con_tab\') {\n\t\t\t\t\t\tselectTab(\'firstkin\');\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'fin_tab\') {\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar bl_install_yn\t= document.forms[0].bl_install_yn.value;   \n\t\t\t\t\t\tif ((calledFrom == \'fin_tab\')  && (bl_install_yn == \"Y\")){\n\t\t\t\t\t\t\t if(document.forms[0].visit_type.value!=\"\")\n\t\t\t\t\t\t\tchkOnSub();\n\t\t\t\t\t\t\t else{\n\t\t\t\t\t\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\t\t\t\terr = err.replace(\'$\', getLabel(\"eAE.RegistrationType.label\",\"AE\"));\n\t\t\t\t\t\t\t\talert(err)\n\t\t\t\t\t\t\t }\n\t\t\t\t\t\t }\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'next_of_kin\') {\n\t\t\t\t\t\tselectTab(\'firstkin\');\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'first_to_notify\') {\n\t\t\t\t\t\tselectTab(\'firstkin1\');\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'none\';\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(calledFrom == \'emp_details\') {\n\t\t\t\t\t\tselectTab(\'firstempyr\');\n\t\t\t\t\t\tdocument.getElementById(\'ADDVISIT\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'ARRIVAL\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'RELATEDCONTACT\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'NEXT_OF_KIN\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'FIRST_TO_NOTIFY\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'EMP_DETAILS\').style.display = \'inline\';\n\t\t\t\t\t\t\n\t\t\t\t\t} \n\t\t}\nvar prevTabObj=\'firstkin\';\n\tfunction selectTab(tabObj){\t\t\t\n\t\tif(prevTabObj!=null){\n\t\t\t\tdocument.getElementById(prevTabObj).className=\"tabA\"\n\t\t\t\tdocument.getElementById(prevTabObj+\"span\").className=\"tabAspan\"\n\t\t\t}\t\t\t\n\t\t\tdocument.getElementById(tabObj).className=\"tabClicked\"\n\t\t\tdocument.getElementById(tabObj+\"span\").className=\"tabSpanclicked\"\n\t\t\tprevTabObj=tabObj\n}\n/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/\nfunction doDatecheck(obj)\n\t{\n\t  if(obj.value != \'\') \n\t  {\n\t\tif(!validDate(obj.value,\'DMYHM\',localeName))\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\'SM\'))\n\t\t\tobj.select();\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif((!isBeforeNow(obj.value,\'DMYHM\',localeName)))\n\t\t\t{\n\t\talert(getMessage(\"DATE_NOT_GREATER_SYSDATE\",\'Common\'));\n\t\tobj.select();\n\t\t\t}\t\n\t\t}\n\t  }\n    }/*Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1*/\n\n/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/\nfunction enablePrac(){\n\nif((document.forms[0].priorityR.checked==true||document.forms[0].priorityY.checked==true||document.forms[0].priorityG.checked==true )&& (document.forms[0].treat_area.value!=\'\')){\n\tdocument.forms[0].practitioner_desc.disabled\t\t=\tfalse;\n\tdocument.forms[0].pract_button.disabled\t\t\t\t=\tfalse;\n\tdocument.forms[0].pract_mand_img.style.visibility\t=\t\'visible\';\n\tdocument.forms[0].practitioner_desc.value\t\t\t=\t\'\';\n\tdocument.forms[0].practitioner_id.value\t\t\t\t=\t\'\';\n}else{\n\tdocument.forms[0].practitioner_desc.disabled\t\t=\ttrue;\n\tdocument.forms[0].pract_button.disabled\t\t\t\t=\ttrue;\n\tdocument.forms[0].pract_mand_img.style.visibility\t=\t\'hidden\';\n\tdocument.forms[0].practitioner_desc.value\t\t\t=\t\'\';\n\tdocument.forms[0].practitioner_id.value\t\t\t\t=\t\'\';\n}\t\n}\n/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/\n  </script>\n  </head> \n  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onSelect=\"codeArrestThruSelect()\" onLoad=\"Loc();disReset();enableocpn();\">\t \n\t <form name=\"ae_reg_attn_result_form\" id=\"ae_reg_attn_result_form\"  action=\"../../servlet/eAE.AERegisterAttnServlet\"  method=\"post\" target=\"messageFrame\"> \n   <div id = \'ADDVISIT\'>  \n\t<!--  <a name=\"tab1\" ></a>  -->\n\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n            <tr><td class=\'white\'>\n\n\t\t <ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Add Visit\">\n\t\t\t\t<a class=\"tabClicked\" id=\'addVisit_tab\' >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"addVisit_tabspan\" onClick=\'javascript:expandCollapse(\"add_Visit_tab\")\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Arrival\">\n\t\t\t\t<a class=\"tabA\" id=\"arrival_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"arrival_tabspan\" onClick=\'javascript:expandCollapse(\"arrival_tab\")\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t<a class=\"tabA\" id=\"rlcnts_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"rlcnts_tabspan\" onClick=\'javascript:expandCollapse(\"rel_con_tab\")\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t<a class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\" onClick=\'javascript:expandCollapse(\"fin_tab\")\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n</ul>\n\n</td></tr></table>\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n        <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'92%\' align=\'center\'>\n           <tr>\n                <th align=\'left\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n           </tr>\n          ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="       \n          <tr>\n              <td  width=\'75%\' id=\'refdetails\' style=\'position:relative;\' class=\"label\"><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b>\n\t\t      </td>\n          </tr>\n        </table>\n      ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t<!--Referral details Ends here -->\n\t   <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\t\t  <tr>\n\t\t         <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t      </tr>\n   \t\t  <tr><td  class=label height=5 colspan=\'4\'></td></tr>\n\n           ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\n\t\t\t  <input type=\'hidden\'  name=\"sysDateSer\" id=\"sysDateSer\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t  <input type=\'hidden\'  name=\"deceased_yn\" id=\"deceased_yn\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t  <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t  <td class=\'LABEL\'  width=\'25%\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'LABEL\'> &nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                      <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t      <td class=\'QUERYDATA\'  width=\'25%\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td>\n\t\t\t    ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t  <td class=\'LABEL\' width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' width=\'25%\'>&nbsp;</td>\n                ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n          </tr> \n          <tr><td colspan=4 class=label height=5></td></tr>\n         <!--  added for PMG2014-HSA-CRF-0001 [IN:050020] --> \n          <tr>\n\t\t\n\t\t\t   ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n          </tr> \n          <tr><td colspan=4 class=label height=5></td></tr>\n          <tr>\n\t\t\n\t\t\t   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t   \n          </tr> \n          <tr><td colspan=4 class=label height=5></td></tr>\n\t\t  <tr>\n\t\t\t  <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n              <td class=\'QUERYDATA\'  width=\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;</td>\n\n\t\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n              ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t  <td class=\'LABEL\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t  <td class=\'QUERYDATA\' width=\'25%\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<td class=\'LABEL\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'QUERYDATA\'  width=\'25%\' >&nbsp;</td>\n              ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t      </tr>\t\n          <tr><td class=label height=5 colspan=\'4\'></td></tr>\n\t\t  <tr>\n              <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t  <td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n              </td>\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n              </td>\n\t      </tr>\n          <tr><td class=label height=5 colspan=\'4\'></td></tr>\n\n\t\t  <tr>\n\t\t      <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n  \t\t      <td class=\'QUERYDATA\' width=\'25%\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t  <input type=\'hidden\'  name=\"blood_group\" id=\"blood_group\"  value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t  <td class=\'QUERYDATA\' width=\'25%\' > ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n              <input type=\'hidden\'  name=\"rh_factor\" id=\"rh_factor\"  value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t      </tr>\t\n       \n         <tr>\n\t\t\t <td  class=label colspan=\'3\'></td>\n\t\t\t <td class=\'label\' ><input type=\'button\' class=\'button\' name=\'contact_details\' id=\'contact_details\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'  onclick=\"Modal_Contact_Details(this);\" id = \'\' ><input type=\"hidden\" name=\'hdddob\' id=\'hdddob\' value =      \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'></td> \n                  \n          </tr> \n\t\t   ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" \n\t\t<tr>\n\t\t         <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t    </tr>\n\t\t  \n\t\t  <tr>\n\t\t\t  <input type=\'hidden\' name=\'StartDate1\' id=\'StartDate1\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input>\n              <input type=\'hidden\' name=\'AllowedDate\' id=\'AllowedDate\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></input>\n              <input type=\'hidden\' name=\'to_service\' id=\'to_service\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></input>\n\t\t      <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t <input type=\'text\'   name=\"visit_date_time\" id=\"visit_date_time\"  value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" maxLength=\'19\' size=\'19\' onBlur=\'chkFromToTime2(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'regndatetime\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null );\" style=\'cursor:pointer\'></img>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></img>\n                ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<input type=\'text\'  name=\"visit_date_time\" id=\"visit_date_time\"  value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" maxLength=\'19\' size=\'19\' readonly >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n              </td>\n\t\t\t<!--Added by Kamatchi S for ML-MMOH-CRF-1609--> \n\t\t\t  <td class=\'label\' width=\'18%\'>      \n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;\n\t\t\t  </td> \n\t\t\t  <td class=\'fields\' style=\'position:relative;\' width=\'30%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t  </td>\n\t\t\n\t\t\t  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n              <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t  <!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->\n\t\t\t  <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\'><input type=\'text\' size=\'15\' name=\"followup_enc\" id=\"followup_enc\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" disabled>&nbsp;<input type=\'button\' name=\'followup_enc_add\' id=\'followup_enc_add\' value=\'+\' class=\'button\' onclick = \"linkFollowUpEncounters(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')\">&nbsp;<input type=\'button\' name=\'followup_enc_remove\' id=\'followup_enc_remove\' value=\'X\' class=\'button\' onclick = \"delinkFollowUpEncounters()\"></td>\n\t\t\t <!--ML-MMOH-CRF-0657-->\n\t\t\t  ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n          </tr>\n\t\t \n\t\t  <tr>\n\t\t      <td class=\'LABEL\' width=\'15%\' >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t  <td class=\'fields\' width=\'35%\' >\n\t\t\t  <select name=\'location\' id=\'location\' onChange=\'remVal1(document.forms[0].service);remVal(document.forms[0].sub_service);remVal(document.forms[0].treat_area);setTreat();setVisit(this);\'>\n    \t\t\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\n\t\t\t\t   </select>\n\n\t\t\t\t   <script>\n\t\t\t\t\t\t  var rec_exists=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =";\n\t\t\t\t\t\t\tif(!rec_exists){\n\t\t\t\t\t\t\t\talert(getMessage(\"AE_NO_LOC_FOR_SEL_AGE_SEX\",\"AE\"));\n\t\t\t\t\t\t\t\t// Commented and added the new code by Suresh M on 01.12.2010\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].clear.onclick();\n\t\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].search.disabled=false;\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;\t\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t}\n\t\t\t\t\t</script> \n\t\t\n\t\t\t\t   <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n                   <input type=\"hidden\" name=\'hddgender\' id=\'hddgender\' value = \'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'></td>\n\n\t\t\t\t   </td><td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n            \t   <td class=\'fields\' width=\'25%\' >\n\t\t\t\t   <select name=\'service\' id=\'service\' onFocus=\'remVal(document.forms[0].sub_service);setSubService(this);\' onChange=\'remVal(document.forms[0].sub_service);setSubService(this);\' >  \n\t\t     </select><img id=\'mandatory\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t  <tr>\n\t\t      <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n \t\t\t\t   <select name=\'visit_type\' id=\'visit_type\' >\n\t\t\t\t\t     <option value=\'\'>----------";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="----------\n\n\t\t\t\t\t\n                   </select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n              </td>\n\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' >\n                   <select name=\'sub_service\' id=\'sub_service\' >\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="----------\n\n\t\t\t\t       </select>\n\t\t\t  </td>\n\t      </tr>\n  \t\t  <tr>\n\t\t    <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t<td class=\'fields\'  colspan=\'3\'>\n\t\t\t\t   <select name=\'transport_mode\' id=\'transport_mode\'\t  onFocus=\"remVal(document.forms[0].mode_of_arrival);setTrans(this);\" onChange=\"remVal(document.forms[0].mode_of_arrival);setTrans(this);\" >\n\t\t\t\t    \t<option value=\'\'>----------";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="----------\n                ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t   </select>\n                   <select name=\'mode_of_arrival\' id=\'mode_of_arrival\' >\n\t\t\t\t\t\t <option value=\'\'>----------";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="----------\n\t\t\t\t   </select>\n\t\t    </td> \n\t\t    </td> \n          </tr>\n\t\t  <!--Added by Thamizh selvi on 20th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n\t\t ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t</table>\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t\t\t<!--Modified by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' id=\'trauma\' value=\'N\' onClick=\'caseDetailsOnChange(this);\'></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'13%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'7%\'>\n\t\t\t\t\t<input type=\'radio\' name=\'caseDetails\' id=\'caseDetails\' id=\'oscc\' value=\'N\' onClick=\'caseDetailsOnChange(this);\'></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t\t\t<span id=\'osccTypeLabel\' style=\"visibility:hidden\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&nbsp;";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</span>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<select name=\'osccType\' id=\'osccType\' style=\"visibility:hidden\">\n\t\t\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="--------\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'osccTypeMandImg\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'25%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'medical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\' checked></input>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'13%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' colspan=3>\n\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'surgical\' value=\'N\' onClick=\'caseDetailsOnChange(this);\'></input> \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  width=\'25%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' colspan=5>\n\t\t\t\t\t<input type=\'radio\' name=\"caseDetails\" id=\"caseDetails\" id=\'OandG\' value=\'N\' onClick=\'caseDetailsOnChange(this);\'></input>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'oscc_yn\' id=\'oscc_yn\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'medical_yn\' id=\'medical_yn\' value=\'Y\'>\n\t\t\t<input type=\'hidden\' name=\'surgical_yn\' id=\'surgical_yn\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'CaseofTrauma_val\' id=\'CaseofTrauma_val\' value=\'N\'>\n\t\t</table>\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\t\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t <!--End-->\n          <!--Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2-->\n          <tr>  \n\t\t\t        <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t        <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'   name=\"CaseofTrauma\" id=\"CaseofTrauma\"  onClick=\'checktrauma(this);setMechInj1(this);\'  >\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n                    <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"oscc_yn\" id=\"oscc_yn\"   value=\'N\' onClick=\'chkOsccValue(this);remVal(document.forms[0].mechan_injury);setMechInj();\'  >\n\t\t\t\t\t</td><input type=\'hidden\' name=\'CaseofTrauma_val\' id=\'CaseofTrauma_val\' value=\'N\'>\n         </tr>\n          <tr> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"medical_yn\" id=\"medical_yn\"  onClick=\'chkMedicalValue(this);\' ></td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'> <input type=\'checkbox\'  name=\"surgical_yn\" id=\"surgical_yn\"   value=\'\' onClick=\'chkSurgValue(this);\'> \n\t\t\t\t\t</td>\n\t\t </tr> \n\t\t ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t <tbody id=\'MechInjFieldsDisplay\' style=\"display:none;\">\n\t\t ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t <tr>\t\n\t\t           <td class=\'LABEL\' width=\'25%\' >\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="<!--End-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t   </td>\n  \t\t           <td class=\'fields\' width=\'25%\'>\n\t\t\t\t   <select name=\'mechan_injury\' id=\'mechan_injury\' onChange=\'setInjury(this)\' > \n\t\t\t\t    <option value=\'\'>--------";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="--------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="  \n                 </select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand4\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="<!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\t\t\t\t <font  class=\'label\'></font>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="&nbsp;&nbsp;&nbsp;\n\t\t\t \t<select name=\'injury\' id=\'injury\' >\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="--------\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand5\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t<input type=\'hidden\' name=\'mech_sub_code\' id=\'mech_sub_code\' value=\'\' >\n\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n              </td> \n\t\t\t  <!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649 Start-->\n\t\t\t  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' >\n\t\t\t\t\t<select name=\'injury\' id=\'injury\' >\n\t\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="--------\n\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'mand5\' style=\"visibility:hidden\" align=\'center\'></img>\n\t\t\t\t\t<input type=\'hidden\' name=\'mech_sub_code\' id=\'mech_sub_code\' value=\'\' >\n\t\t\t\t</td>\n\t\t\t  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t  <!--End-->\n\t\t\t  <!--Added by Shanmukh for MMS-DM-CRF-0147 Start-->\n\t\t\t  ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>\t\t\t\t\t\n\t\t\t\t\t<input type=\'checkbox\'  name=\"pat_critical_case_yn\" id=\"pat_critical_case_yn\" value=\'Y\'>\n\t\t\t\t</td>\n\t\t\t  ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t  <!--End-->\n\t  </tr>\n\t  ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t  </tbody>\n\t  ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t  <tr>\t\n\t\t      <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n\t\t\t\t <select name=\'protective_device\' id=\'protective_device\' >\n\t\t\t\t   <option value=\'\'>---------";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="--------\n\t\t\t   ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n                 </select>\n               </td>\n               <tr>\t\n           <!--Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2-->\n\t\t  <tr>\n\t\t  <!--Below line modified by Ashwini on 18-Jan-2017 for GDOH-CRF-0123--> \n\t\t   ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" \n\t\t\t\t <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t \t<td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->\n\t\t\t ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t <!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n  \t\t     <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"brought_dead_yn\" id=\"brought_dead_yn\"  onClick=\'broughtDead(this);\'  ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="&nbsp;&nbsp; ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" <input type=\'checkbox\'  name=\"mlc_case_yn\" id=\"mlc_case_yn\"  onClick=\'mlcCase(this);\' ></td>\n\t\t\t <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t <td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\n\t\t\t <!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n  \t\t     <td class=\'fields\' width=\'25%\' ><input type=\'checkbox\'  name=\"mv_accident_yn\" id=\"mv_accident_yn\"  onClick=\"mvAccident(this); ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="placeOfAccidentMandatory(this);";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=\'N\'></td>\n             <input type=\'hidden\' name=\'brought_dead_ynhdd\' id=\'brought_dead_ynhdd\' value=\'\'>\n\t\t\t <input type=\'hidden\' name=\'mlc_case_ynhdd\' id=\'mlc_case_ynhdd\' value=\'\'>\n\t\t  </tr>\n\n\t\t ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t <tbody id=\'placeOfOccFieldsDisplay\' style=\"display:none;\">\n\t\t ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\n\t\t\t<!--Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1-->\n\t\t\t\n\t\t\t<tr>\n\t\t\t<!-- if else block added by mujafar for ML-MMOH-CRF-0647 -->\n\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\n\t\t      <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t  \n  \t\t      <td class=\'fields\' width=\'25%\' >\n \t\t\t\t   <input type=\'text\'  id=\'accidentdatetime\' name=\'accidentdatetime\' id=\'accidentdatetime\'   maxLength=\'16\' size=\'16\' tabindex=\'\'\n\t\t\t  value=\"\"  onBlur=\'doDatecheck(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'accidentdatetime\', null, \'hh:mm\' );\" style=\'cursor:pointer\'> </img><img src=\'../../eCommon/images/mandatory.gif\' id=\'dateOfOccurImg\' style=\"visibility:hidden\" align=\'center\'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n              </td>\n\n\t\t\t<!--Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131-->\n\t\t\t<!-- if else code modified by mujafar for ML-MMOH-CRF-0647 --> \n\t\t\t<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="/";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t\t\t  ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td> \n\t\t\t\t\n\t\t\t ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\n\t\t\t<!--Modified by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t  <td class=\'fields\' width=\'25%\' >\n                   <input type=\'text\' name=\"place_of_accident\" id=\"place_of_accident\"  maxLength=\'30\' size=\'25\'  tabindex=\'\' value=\"\" onBlur=\"makeValidString(this)\"> ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="<img src=\'../../eCommon/images/mandatory.gif\' id=\'poa_mand\' style=\"visibility:hidden\" align=\'center\'></img> ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t  </td>\n\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t<!--<td class=\'fields\' width=\'25%\' >\n                   <input type=\'text\' name=\"place_of_accident\" id=\"place_of_accident\"  maxLength=\'30\' size=\'25\'  tabindex=\'\' value=\"\" onBlur=\"makeValidString(this)\">\n\t\t\t  </td> -->\n\t\t\t  <td class=\'fields\' width=\'25%\'><select name=\'place_of_accident\' id=\'place_of_accident\' >\n\t\t\t   <option value=\'\'>----------";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="----------</option> \n                ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'placeOfOccurImg\' style=\"visibility:hidden\" align=\'center\'><!--Added mandatory image for ML-MMOH-CRF-0648 on 5th Apr 2018 by Thamizh selvi-->\n\t\t\t\t</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t<!--\t<input type=\"hidden\" name=\'isPlaceOfOccuurrence\' id=\'isPlaceOfOccuurrence\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"> -->\n\n\t      </tr>\n\t  ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t<tr>\n\t\t      <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n  \t\t      <td class=\'fields\' width=\'25%\' >\n \t\t\t\t   <select name=\'vehicle_invol1\' id=\'vehicle_invol1\' ><option value=\'\' >--------";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="-------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t  </select>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" \n\t\t\t\t  <select name=\'vehicle_invol2\' id=\'vehicle_invol2\' >\n\t\t\t\t  <option value=\'\'>--------";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="-------\n\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t  </select>\n  \n              </td>\n\n\t\t\t  <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n\t\t\t  <td class=\'fields\' width=\'25%\' ><select name=\'PosDurInc\' id=\'PosDurInc\' >\n\t\t\t\t  <option value=\'\'>---------";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t  </select></td>\n\t      </tr>\n\n<!--Added by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->\n\t<tr>\n\t <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</td>\n\t <td class=\'fields\' width=\'25%\' >\n        <input type=\'text\' name=\"Vehicle_Reg_No1\" id=\"Vehicle_Reg_No1\"  maxLength=\'15\' size=\'20\'  onKeyPress=\"return SpCharChkForMotorVecRegNo(event);\">\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" \n        <input type=\'text\' name=\"Vehicle_Reg_No2\" id=\"Vehicle_Reg_No2\"  maxLength=\'15\' size=\'20\' onKeyPress=\"return SpCharChkForMotorVecRegNo(event);\">\n\t </td>\n\t</tr>\n\n<!-- Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023 -->\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t<tr>\n\t\t  <td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\"checkbox\" name=\'mlc_case_yn\' id=\'mlc_case_yn\' value=\'N\' onClick = \"enableOthMlcFlds(this);\" ></td></td>\t\n\t\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\"checkbox\" name=\'mlc_death\' id=\'mlc_death\' onClick=\"updateSelf(this)\" value=\'N\' disabled></td></td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\' name=\"police_rep_no\" id=\"police_rep_no\" onpaste=\"maxLengthPaste(this, \'100\')\" maxlength=\'100\' disabled></td></td>\t\n\t\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\"police_stn_dtls\" id=\"police_stn_dtls\" onpaste=\"maxLengthPaste(this, \'100\')\" maxlength=\'100\' disabled></td></td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'outside_mlc_dtls\' id=\'outside_mlc_dtls\' onpaste=\"maxLengthPaste(this, \'100\')\" maxlength=\'100\' disabled></td></td>\t\n\t\t\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<input type=\'text\'  id=\'dateofmlccapture\' name=\"date_of_mlc_capture\" id=\"date_of_mlc_capture\" onBlur=\"validateMlcCapture(this)\" maxLength=\'19\' size=\'19\' disabled><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\"mlcCaptureDateCalendar\" onClick=\"return showCalendar(\'dateofmlccapture\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null );\" style=\'cursor:pointer\'></img>\n\t\t\t\t\t</td></td>\t\t\t\t\n\t</tr>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\n\t\t\t\t\t<textarea name=\'mlc_remarks\' rows=\"3\" cols=\"45\" onpaste=\"maxLengthPaste(this, \'500\')\" onKeyPress=\"checkMaxLimit(this, 500)\" disabled></textarea>\n\t\t\t\t\t\n\t\t\t\t\t</td></td>\t\n\t\t\t\t\t\n\t</tr>\n\t\n\t\n\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n<!-- END of GHL-CRF-0650 -->\n<!--Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1-->\n\n        ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" \n\t\t<tr id=\'PrimaryTriageDetailsHeader\' >\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n\t    </tr>\n\t    ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t </table>\n\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =" \n\t\t\n\t\t\n\t<!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\t \n\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\t<tr>\n\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<select name=\'Priority_Zone_Type\' id=\'Priority_Zone_Type\' onChange=\'remVal(document.forms[0].treat_area);setTreatment(this);enableBed(this)\'>\n\t\t\t\n\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t </select>\n\t\t\t</td>\n\t\t\n\t\t </tr>\n\t\t\n\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t<table border=\"0\" align=\'center\' width=\'92%\'>\n         <tr>\n\t\t    <td class=\'LABELCENTER\' align=\'center\' width=\'18%\'>&nbsp;</td>\n\t\t\t<!-- below lines designing are add by Suresh.M on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->\n\t\t\t<td style = \"COLOR:#444444;background-color:#FFFFFF; FONT-SIZE: 8pt;TEXT-ALIGN: CENTER; PADDING-LEFT:7px;PADDING-RIGHT:7px\"  width=\'15%\'>";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="&nbsp;</td>\n\t\t\t\n\t\t\t<td style = \"COLOR:#444444;background-color:#FFFFFF; FONT-SIZE: 8pt;TEXT-ALIGN: CENTER; PADDING-LEFT:7px;PADDING-RIGHT:7px\"  width=\'15%\'>";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="&nbsp;</td>\n\t\t\t<td style = \"COLOR:#444444;background-color:#FFFFFF; FONT-SIZE: 8pt;TEXT-ALIGN: CENTER; PADDING-LEFT:7px;PADDING-RIGHT:7px\"   width=\'15%\'>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="&nbsp;</td>\n\t\t\t<td  colspan=\'2\'></td>\n\t\t\t<!--CRF  SKR-CRF-0021 [IN028173] end-->\n\t\t </tr> \n\t\t<!--Below line added for this CRF ML-MMOH-CRF-0629-->\n\t\t <tr>\n\t\t\t<td class=\'LABEL\' width=\'18%\'>";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</td>\n            <td  align=\'center\' width=\'15%\' >\n\t\t\t<input type=\"checkbox\" name=\'priorityR\' id=\'priorityR\' onClick=\'remVal(document.forms[0].treat_area);setTreatment(this);enableBed(this);";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'></td>\n\t\t\t <td  align=\'center\'  width=\'15%\'>\n\t\t\t <input type=\"checkbox\" name=\'priorityY\' id=\'priorityY\' onClick=\'remVal(document.forms[0].treat_area);setTreatment(this);enableBed(this);";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'></td>\n\t\t\t <td  align=\'center\'  width=\'15%\'>\n\t\t\t <input type=\"checkbox\" name=\'priorityG\' id=\'priorityG\' onClick=\'remVal(document.forms[0].treat_area);setTreatment(this);enableBed(this);";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' >\n           \t\t\t<!--enablePrac () is added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n            </td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\t\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\t\t\t\n\t\t\t\n\t\t\t \n\t\t\t\n<tr>\n\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t    <select name=\'priority11\' id=\'priority11\' >\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="----------\n\t\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t\n\t\t\t<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t<!--<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=text  name=practitioner_desc id=practitioner_desc size=30 maxlength=30 value=\"\" onBlur=\"aegetPractitioneratVisit(this,practitioner_desc);\" disabled><input type=hidden value=\"\" name=practitioner_id id=practitioner_id ><input type=button class=button value=\'?\' name=pract_button id=pract_button   onclick=\"aegetPractitioneratVisit(this,practitioner_desc); \" disabled><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'pract_mand_img\' style=\"Visibility : \'hidden\'\"></img><input type=\'text\' name=practitioner_id id=practitioner_id value=\"\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\"> -->\n\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=text  name=\"practitioner_desc\" id=\"practitioner_desc\" size=30 maxlength=30 value=\"\" onBlur=\"beforeGetPractitioneratVisit(document.forms[0].pract_button,practitioner_desc);\" disabled><input type=hidden value=\"\" name=\"practitioner_id\" id=\"practitioner_id\" ><input type=button class=button value=\'?\' name=\"pract_button\" id=\"pract_button\"   onclick=\"aegetPractitioneratVisit(this,practitioner_desc); \" disabled><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'pract_mand_img\' style=\"Visibility : \'hidden\'\"></img><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">\n\t\t</td> \n\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t<!-- Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n\n\t\t   </tr>\n           <tr>\n\t\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</td>\n\t\t\t<td class=\'fields\'  id=\"treat_area\" width=\'25%\'>\n\t\t\t\t    <select name=\'treat_area\' id=\'treat_area\' onChange=\'enableBed(this);";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="----------\n\t\t\t\t\t</select>\n\t\t\t</td>\n\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'bed_bay_no\' id=\'bed_bay_no\' size=\'8\' maxlength=\'8\' readonly onblur=\"ChangeUpperCase(this)\" onKeyPress=\"return(CheckForSpecChars(event))\" disabled><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\'  onClick=\"callBedAvailChart();\" disabled>\n\t\t\t   </td>\n\t\t  </tr> \n           <tr> \n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\"checkbox\" name=\'Disaster_YN\' id=\'Disaster_YN\'  onClick=\'setDisaster(this)\'></td>\n\t\t\t<td class=\'LABEL\'  >";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"disaster_area1\" id=\"disaster_area1\"  maxLength=\'15\' onblur=\'if(this.value !=\"\")searchDisasterArea(this,disaster_area1);\'  disabled><input type=\'button\' name=\'disaster\' id=\'disaster\' value=\'?\' class=\'button\' onclick=\"searchDisasterArea(this,disaster_area1);\"  disabled>\n            </td>\n\t\t   ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t</tr>\n\t\t\t<tr>\n              <td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</td>\n              <td class=\'fields\' width=\'25%\'><select name=\'disaster_type\' id=\'disaster_type\' disabled>\n\t\t\t   <option value=\'\'>----------";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"disaster_Reference\" id=\"disaster_Reference\"   onKeyPress=\"return CheckForSpecChar(event)\"   maxLength=\'15\' disabled>\n\t\t<td colspan=2 class=label >&nbsp;</td>\t\n\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\t\t\t\n\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"disaster_Reference\" id=\"disaster_Reference\"   onKeyPress=\"return CheckForSpecChars(event)\"   maxLength=\'15\' disabled>\n\t\t<td colspan=2 class=label >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t</tr>\n\t\t<tr>\n\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t <td  class=\'label\' NOWRAP width = \'18%\'>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</td>\n     <td  class=\'Fields\' width = \'30%\'><input type=\"text\" name=\"assigncare_location_desc\" id=\"assigncare_location_desc\" maxlength=\"40\" size=\"25\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =" >\n     </td>\t \n\t ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"presentingproblem_desc\" id=\"presentingproblem_desc\" value=\"\" onblur=\'if(this.value !=\"\") searchPresentingProblem(this,presentingproblem_desc);\' ><input type=\'button\' name=\'presenting_problem\' id=\'presenting_problem\' value=\'?\' class=\'button\' onclick=\'searchPresentingProblem(this,presentingproblem_desc);\'  onblur=\'aa();\'></td>\n\t\t<td colspan=2 class=label >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t <input type=\'hidden\' name=\'presentingproblem_code\' id=\'presentingproblem_code\' value=\"\">\n\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t <td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"presentingproblem_desc\" id=\"presentingproblem_desc\" value=\"\" onblur=\'if(this.value !=\"\") searchPresentingProblem(this,presentingproblem_desc);\' ><input type=\'button\' name=\'presenting_problem\' id=\'presenting_problem\' value=\'?\' class=\'button\' onclick=\'searchPresentingProblem(this,presentingproblem_desc);\'  onblur=\'aa();\'><input type=\'hidden\' name=\'presentingproblem_code\' id=\'presentingproblem_code\' value=\"\"></td>\n\t\t<td colspan=2 class=label >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t</tr>\n\t\t</table> \n\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t<tr>\n\t\t  <td  class=label width=\'25%\'>&nbsp;</td>\n\t      <td class=\'BUTTON\' width=\'25%\'><input type=\"button\" name=\"PrevEncounter\" id=\"PrevEncounter\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'  onClick=\"showPrevEncounter();\"  onblur=\'if(document.forms[0].visit_within_24hrs.disabled==true)document.forms[0].visit_date_time.focus();\' ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="></td>\n\t\t  <td class=\'BUTTON\' colspan=\'2\'>\n          <input type=\"button\" name=\"visit_within_24hrs\" id=\"visit_within_24hrs\" class=\"BUTTON\" value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'   onClick=\"showLastVisitDetails(\'LastVisit24\');\" onblur=\'document.forms[0].visit_date_time.focus();\' disabled>&nbsp;&nbsp;</td>\n          </tr>  \n\t\t       </table>\n</div>\n<!-- fields for contact details start -->\n<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\'>\n<!-- concat_address_hidden -->\n<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\t\t\n<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\t\t\n<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\' >\n<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\' >\n<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\' >\n<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\' >\n<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\'\'>\n<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\'>\t\n<input type=\'hidden\' name=\'postals_code\' id=\'postals_code\' value=\'\'>\t\n<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\' >\t\n<input type=\'hidden\' name=\'res_region_code\' id=\'res_region_code\' value=\'\' >\t\n<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\'\' >\t\n<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\' >\n<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\'>\n<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\' maxlength=\'30\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' maxlength=\'30\' value=\'\'>\n<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\'  maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\' maxlength=\'30\'>\n<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\'\' maxlength=\'8\'>\n<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\' maxlength=\'4\'>\n<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\'>\n<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'mail_country_desc\' id=\'mail_country_desc\' value=\'\' maxlength=\'6\'>\n<input type=\'hidden\' name=\'r_postal_code1\' id=\'r_postal_code1\' value=\'\' maxlength=\'45\'>\n<input type=\'hidden\' name=\'m_postal_code12\' id=\'m_postal_code12\' value=\'\' maxlength=\'45\'>\n<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n<input type=\'hidden\' name=\'patient_valuables_rcdby\' id=\'patient_valuables_rcdby\' value=\'\'>\n<input type=\'hidden\' name=\'patient_valuables_chkin_dtm\' id=\'patient_valuables_chkin_dtm\' value=\'\'>\n<input type=\'hidden\' name=\'patient_valuables_remarks\' id=\'patient_valuables_remarks\' value=\'\'> \n  <input type=\"hidden\" name=\'hddpriority\' id=\'hddpriority\' value=\'U\'>\n <input type=\"hidden\" name=\'upt_contact_dtls_oa_yn\' id=\'upt_contact_dtls_oa_yn\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"> <!--added changes for HSA-CRF-0226 [IN:050599]-->\n<!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start-->\n<input type=\'hidden\' name=\'addr3_type\' id=\'addr3_type\' value=\"\">\n<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\"\">\n<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\"\">\n<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\"\">\n<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\"\">\n<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\"\">\n<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\"\">\n<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\"\">\n<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\"\">\n<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\"\">\n<input type=\'hidden\' name=\'alt_postal_desc\' id=\'alt_postal_desc\' value=\"\">\n<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\"\">\n<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\"\">\n<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\"\">\n<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\"\">\n<!--End-->\n<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n<input type=\"hidden\" name=\'isPracApplicable\' id=\'isPracApplicable\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\n<input type=\"hidden\" name=\'isAutoPopulateNOKDOBAppl\' id=\'isAutoPopulateNOKDOBAppl\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"><!--Added by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177-->\n\n<!-- fields for contact details ends here -->\n\n<script>\n\t\tpopulateContactDetails(\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\");\n</script>\n\n<!--Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->\n<input type=\"hidden\" name=\'invoke_recall\' id=\'invoke_recall\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n<script>\nif(document.forms[0].invoke_recall.value == \"Y\")\n{\n\tif(document.forms[0].followup_enc.value == \"\" || document.forms[0].followup_enc.value == null)\n\t{\n\t\tdocument.forms[0].followup_enc_remove.style.visibility=\'hidden\';\n\t}else\n\t{\n\t\tdocument.forms[0].followup_enc_remove.style.visibility=\'visible\';\n\t}\n}\n</script>\n<!--End ML-MMOH-CRF-0657-->\n\n<div id = \'ARRIVAL\' style = \'display:none\'>\n <!--  <a name=\"tab2\" tabindex=\'23\' ></a> -->\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n        <tr><td class=\'white\'>\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Add Visit\">\n\t\t\t\t\t\t\t<a  class=\"tabA\" id=\'addVisit_tab\' >\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"addVisit_tabspan\" onClick=\'javascript:expandCollapse(\"add_Visit_tab\")\'>";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Arrival\">\n\t\t\t\t\t\t<a class=\"tabClicked\" id=\"arrival_tab\" >\n\t\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"arrival_tabspan\" onClick=\'javascript:expandCollapse(\"arrival_tab\")\'>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t\t\t\t<a class=\"tabA\" id=\"rlcnts_tab\" >\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"rlcnts_tabspan\" onClick=\'javascript:expandCollapse(\"rel_con_tab\")\'>";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t\t\t\t<a class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\" onClick=\'javascript:expandCollapse(\"fin_tab\")\'>";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\t\n\t\t\t</ul>\n\t</td></tr></table> \n\n    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'92%\'>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</td>\n\t</tr>\n\n          <tr><td colspan=4 class=label height=5></td></tr>\n          <tr>\n            <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</td>\n\t\t\t<td class=\'fields\'  width=\'25%\'>\n\t\t\t\t <select name=\'accompany_by\' id=\'accompany_by\' >\n\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="---\n\t\t\t\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 =" \n\t\t\t\t </select>\n\t\t\t</td>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n          </tr>\n\t\t  <tr>\t\n\t\t\t\t<td class=\'LABEL\' >";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</td>\n  \t\t\t\t<td class=\'fields\' >\n \t\t\t     <select name=\'relation_val\' id=\'relation_val\' >\n\t\t\t\t  <option value=\'\'>----------";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="----------\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n                 </select>\n\t\t\t\t</td>\n\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n\t\t  </tr>\t\n\t\t  <tr>\t\n            ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\t\t<td class=\'LABEL\'  >";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</td>\n  \t\t    <td class=\'fields\'  colspan=\'2\' >\n \t\t\t      <select name=\'other_alt_id\' id=\'other_alt_id\'  onchange=\'ClearAltID();\' >\n\t\t\t\t     <option value=\'\' >----------";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="----------\n\t\t\t\t\t     ";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="  \n                   </select>\n                 <input type=\'text\'  name=\"oth_alt_id\" id=\"oth_alt_id\"  value=\"\" maxLength=\'15\' size=\'15\'  ></td>\n               ";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t  <td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n              ";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t      <td class=\'label\' >&nbsp;</td> \n\t\t\t\t</tr>\t\t \n               <tr>\t\n\t\t\t\t ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t    \t    <td class=\'LABEL\' >";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="&nbsp;</td>\n\t\t\t\t<td class=\'fields\' ><input type=\'text\'  name=\"nat_id_no\" id=\"nat_id_no\"  value=\"\" maxlength=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\' onblur=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =";document.forms[0].e_addr_line1.focus();\" onkeypress=\'return ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'  size=\'20\' >\n\t\t    \t</td>";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n                <td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n                ";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t<td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n\t        </tr>\t\n\t\t\t<input type=\'hidden\' name=\'nat_id_check_digit_id\' id=\'nat_id_check_digit_id\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n\t\t\t<input type=\'hidden\' name=\'nat_id_chk_len\' id=\'nat_id_chk_len\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n\t\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'>\n\t\t\t<!--Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start-->\n\t\t\t<input type=\'hidden\' name=\'natInvokeRoutine\' id=\'natInvokeRoutine\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'>\n\t\t\t<input type=\'hidden\' name=\'natDataSourceId\' id=\'natDataSourceId\' value=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\'>\n\t\t\t<!--End-->\n\t\t\t<input type=\'hidden\' name=\'m_town\' id=\'m_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'n_town\' id=\'n_town\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'f_town\' id=\'f_town\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'e_town\' id=\'e_town\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_area\' id=\'m_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_area\' id=\'n_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_area\' id=\'f_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_area\' id=\'e_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_region\' id=\'m_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_region\' id=\'n_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_region\' id=\'f_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_region\' id=\'e_region\' value=\'\'>\n\t\t\t\n\n\t\t\t<!-- added new -->\n            <input type=\'hidden\' name=\'employ_postal_code\' id=\'employ_postal_code\' value=\'\'> \n\t\t\t<input type=\'hidden\' name=\'m_postal_code\' id=\'m_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'next_postal_code\' id=\'next_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'first_postal_code\' id=\'first_postal_code\' value=\'\'>\n            \n\t\t\t<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<input type=\'hidden\' name=\'nkma_town\' id=\'nkma_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact1_region\' id=\'contact1_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'nkma_area\' id=\'nkma_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_ma_postal_code\' id=\'n_ma_postal_code\' value=\'\'>\n\n\t\t\t<input type=\'hidden\' name=\'contact2_res_town\' id=\'contact2_res_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_region\' id=\'contact2_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_res_area\' id=\'contact2_res_area\' value=\'\'>\t\t\n\t\t\t<input type=\'hidden\' name=\'fst_no_ma_pos_cod\' id=\'fst_no_ma_pos_cod\' value=\'\'>\n\t\t\t<!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="                \n          <tr>\n    \t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</td>\n            <td class=\'fields\'><input type=\'text\' name=\'e_country_desc\' id=\'e_country_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],e_country_desc);\' tabindex=\'44\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,e_country_desc)\' tabindex=\'45\'>\n\t\t\t\t<input type=\'hidden\' name=\'e_country_code\' id=\'e_country_code\' value=\'\'>\n            </td>\n            <td class=\'LABEL\'  colspan=\'2\'>&nbsp;</td> \n\t\t  </tr>\n\t\t  <tr>\n\t\t    <td class=\'LABEL\' >";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</td>\n  \t\t    <td class=\'fields\'  colspan=\'3\'>\n \t\t\t\t   <textarea name=\'arrival_remarks\' cols=\'60\' rows=\'2\' align=\'left\'  onKeyPress=\'checkMaxLimit(this,2000);\' onBlur=\'makeValidString(this);return(callCheckMaxLen(this,2000,\"Remarks\"));\'  tabindex=\'46\'>";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="</textarea>\n\t\t    </td>\n\t\t  </tr>\n\t\t  <tr><td colspan=4 class=label height=5></td></tr>\t\n\t\t  <tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</td>\n\t\t  </tr>\n          <tr><td colspan=4 class=label height=5></td></tr>\n          <tr>\n\t\t\t <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="</td>\n  \t\t     <td class=\'fields\'  width=\'25%\'>\n \t\t\t <input type=\'text\'  name=\"name_of_escort\" id=\"name_of_escort\"  value=\"\" maxLength=\'30\' size=\'25\'  onBlur=\"makeValidString(this)\" tabindex=\'47\'>\n\t\t     </td>\n\t\t\t <td colspan=2 class=label >&nbsp;</td>\n\t\t  </tr>\n\n          <tr>\n\t\t\t\t<td class=\'LABEL\' >";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\'text\'  name=\'ambulance_contact_no\' id=\'ambulance_contact_no\' value=\'\' maxLength=\'18\' size=\'20\' onBlur=\'makeValidString(this)\' tabindex=\'48\'></td>\n\t\t\t   <td colspan=2 class=label >&nbsp;</td>\n\t\t  </tr>\n\n\t\t  <tr>\n\t\t\t   <td class=\'LABEL\' >";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="</td>\n\t\t\t   <td class=\'fields\' ><input type=\'text\'  name=\'motor_vehicle_reg_no\' id=\'motor_vehicle_reg_no\' value=\"\" maxLength=\'15\' size=\'20\'  onBlur=\'makeValidString(this);document.forms[0].accompany_by.focus();\' tabindex=\'49\'></td>\n\t\t\t   <td colspan=2 class=label >&nbsp;</td>\n\t\t  </tr>\n          <tr><td colspan=4 class=label height=5></td></tr>\n\n\t    </table>\n  </div>\n     <!--  <a name=\"tab3\" ></a>  -->\n\t <div id = \'RELATEDCONTACT\' style = \'display:none\'>\n\t   <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n        <tr><td class=\'white\'>\n\t\t\t\t  <ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Add Visit\">\n\t\t\t\t\t\t\t<a class=\"tabA\" id=\'addVisit_tab\' >\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"addVisit_tabspan\" onClick=\'javascript:expandCollapse(\"add_Visit_tab\")\'>";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Arrival\">\n\t\t\t\t\t\t\t<a class=\"tabA\" id=\"arrival_tab\" >\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"arrival_tabspan\" onClick=\'javascript:expandCollapse(\"arrival_tab\")\'>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t\t\t\t<a class=\"tabClicked\" id=\"rlcnts_tab\" >\n\t\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"rlcnts_tabspan\" onClick=\'javascript:expandCollapse(\"rel_con_tab\")\'>";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\t\n\t\t\t</ul>\n\t </td></tr></table> \n\t   \n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n      <tr><td class=\'white\'>\n\t  \n\t  \t<!-- <a name=\'kin\'></a> -->\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Next of kin\">\n\t\t\t\t\t<a class=\"tabClicked\" id=\"firstkin\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"firstkinspan\" onClick=\'javascript:expandCollapse(\"next_of_kin\")\'>";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t<a class=\"tabA\" id=\"firstkin1\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"firstkin1span\" onClick=\'javascript:expandCollapse(\"first_to_notify\")\'>";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Employment Details\">\n\t\t\t\t\t<a class=\"tabA\" id=\"firstempyr\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"firstempyrspan\" onClick=\'javascript:expandCollapse(\"emp_details\")\'>";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t</ul>\n          </td></tr>\n</table>\n<div id = \'NEXT_OF_KIN\' style = \'display:none\'>\n  <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n            <tr><td valign=top width=\'50%\'><table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n\t\t\t\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t\t<!-- added by mujafar for ML-MMOH-CRF-0632 START -->\t\n\t\t\t\t";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' width=\'25%\' >\n\t\t\t\t";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="&nbsp;&nbsp;<span class=\'field\'><td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"patient_id1\" id=\"patient_id1\"  value=\"\" maxLength=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' size=\'20\' onKeyPress=\"return(CheckForSpecChars(event))\" \n\t\t\tonBlur=\'changeCase(this);searchPatient1(document.forms[0].patient_id1);\'>&nbsp;<input type=\"button\" name=\"patient_search\" id=\"patient_search\" class=BUTTON value=\"?\" onChange=\'disReset();\' onClick=\"if(document.forms[0].patient_id1.value==\'\'){callPatientSearch1()}\" ></td></span>\t\n             <input type=\'hidden\' name=\'patient_id1_val\' id=\'patient_id1_val\' value=\'\'>\n            </td>\n\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t ";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="  \n\t\t \t\t  <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="&nbsp;</td>\n\t\t\t      <td class=\'fields\'  width=\'25%\'>\n\t\t\t\t     <input type=\'text\' name=\'contact1_new_nat_id_no\' id=\'contact1_new_nat_id_no\' maxlength=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\' size=\'20\'  onkeypress=\'return ";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'  onblur=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" onkeypress=\"return allowValidNumber(this,event,20, 0);\" ><!--Modified by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177-->\n\t\t\t\t  </td>  \n\t\t\t   ";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="  \n                 <td align=\'right\' class=\'label\' width=\'5%\' ></td> \n               ";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="   \n\t\t  </tr>\n\t\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t<!-- added by mujafar for ML-MMOH-CRF-0632 END -->\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<tr> <!--below length change CRF-0887 by mano -->\n\t                <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n\t                <td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\n\t\t\t\t\t<textarea name=\'next_contact_name\' rows=3 maxlength=100 cols=45 onblur=\'makeValidString(this); maxLengthPaste(this);\' onkeypress=\'checkMaxLimit(this,80)\' onkeyup=\'RemoveSpecialChar(this)\'>";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="</textarea> <!-- maxlength increased to 100 for ICN-7899 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\t\t\t\t\t\n\t\t\t\t\t<input type=\"text\" name=\"next_contact_name\" id=\"next_contact_name\"  maxlength=\'80\' size=\'30\'  value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\n\t\t\t\t\t</td>\n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t<select name=\'next_contact_relation\' id=\'next_contact_relation\' >\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="---</option>\n                         \n\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n                    </select>\n\t\t\t\t </td>\n\t\t\t\t</tr>\n\t\t<!-- IF added by mujafar for ML-MMOH-CRF-0632  -->\t\t\n\t\t\t";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n\t\t      <tr>\n\t\t\t\t ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="   \n\t\t  </tr>\n\t\t\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 =" \n\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n          <tr><td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="</td>\n              <td  class=\'fields\'  width=\'25%\'>\n\t\t\t\t\t<select name=\'contact1_oth_alt_id_type\' id=\'contact1_oth_alt_id_type\' onChange=\'enableOtherAltIdText(this.value)\' > \n  \t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="---\n\t\t\t\t\t";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\n\t\t\t\t\t</select>\n                        <input type=\'text\' name=\'contact1_oth_alt_id_no\' id=\'contact1_oth_alt_id_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\'  DISABLED value = \"\">\n              </td>\n\t\t  </tr>";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t  <tr><td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="</td>\n              <td class=\'fields\'  width=\'25%\'>\n                  <input type=\'text\' name=\'contact1_birth_date\' id=\'contact1_birth_date\' id=\'birthdate1\' maxlength=\'10\' size=\'10\'  value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" onBlur = \'makeValidString(this);doDate(this);\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"birthdate\"  onClick=\"document.forms[0].contact1_birth_date.select();return showCalendar(\'birthdate1\');\" style=\'cursor:pointer\' ></img>\n                </td>\n\t\t  </tr>\t\n\t\t  <tr><td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="</td>\n              <td class=\'fields\'  width=\'25%\'>\n                  <input type=\'text\' name=\'next_job_title\' id=\'next_job_title\' maxlength=\'30\' size=\'30\' onblur=\'makeValidString(this);document.forms[0].next_addr_line1.focus();document.forms[0].n_next_addr_line1.focus();\' value =\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n              </td>\n\t\t\t\n\t\t</table>\n\t\t\t  </td>  \n\t\t\t  <td><table cellspacing=\'0\' cellpadding=\'0\' border=0>\n\t\t\t  <!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\n\t\t\t\t<td width=\'70%\'><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\'  ></td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="</td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</td>\n                </tr>\n                </td>\n                ";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\n                <!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n                ";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="  \n\t\t<script>\n\t\t  // Added on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\tif(document.forms[0].next_addr_line1)\n\t\t\t\t\t\t   document.forms[0].next_addr_line1.value = \"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].next_addr_line2)\n\t\t\t\t\t\t   document.forms[0].next_addr_line2.value = \"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].next_addr_line3)\n\t\t\t\t\t\t   document.forms[0].next_addr_line3.value = \"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].next_addr_line4)\n\t\t\t\t\t\t   document.forms[0].next_addr_line4.value = \"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].contact1_res_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t document.forms[0].contact1_res_town_code.value = \"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\";\n\t\t\t\t\t\t document.forms[0].n_town.value = \"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].contact1_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t     document.forms[0].contact1_region_code.value = \"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\";\n\t\t\t\t\t\t document.forms[0].n_region.value = \"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\"; \n                        }\n\t\t\t\t\t\tif(document.forms[0].contact1_res_area_code)\n\t\t\t\t\t\t{\n                \t\tdocument.forms[0].contact1_res_area_code.value = \"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\";\n\t\t\t\t\t\tdocument.forms[0].n_area.value = \"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].next_postal_code1){\n\t\t\t\t\t\t   document.forms[0].next_postal_code.value = \"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\";\n\t\t\t\t\t\t document.forms[0].next_postal_code1.value = \"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\";\n\t\t\t\t\t\t \n\t\t\t\t\t\t}\n                        //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t\t\t\t\tif(document.forms[0].n_next_addr_line1)\n\t\t\t\t\t\t   document.forms[0].n_next_addr_line1.value = \"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].n_ma_addr_line2)\n\t\t\t\t\t\t   document.forms[0].n_ma_addr_line2.value = \"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].n_ma_addr_line3)\n\t\t\t\t\t\t   document.forms[0].n_ma_addr_line3.value = \"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].n_ma_addr_line4)\n\t\t\t\t\t\t   document.forms[0].n_ma_addr_line4.value = \"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].n_contact_ma_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t document.forms[0].n_contact_ma_town_code.value = \"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\";\n\t\t\t\t\t\t document.forms[0].nkma_town.value = \"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].n_contac_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t     document.forms[0].n_contac_region_code.value = \"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\";\n\t\t\t\t\t\t document.forms[0].contact1_region.value = \"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\"; \n                        }\n\t\t\t\t\t\tif(document.forms[0].n_contact_ma_area_code)\n\t\t\t\t\t\t{\n                \t\tdocument.forms[0].n_contact_ma_area_code.value = \"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\";\n\t\t\t\t\t\tdocument.forms[0].nkma_area.value = \"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].n_ma_postal_code1){\n\t\t\t\t\t\t   document.forms[0].n_ma_postal_code.value = \"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\";\n\t\t\t\t\t\t document.forms[0].n_ma_postal_code1.value = \"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\";\n\t\t\t\t\t\t \n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n                        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n        // End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t</script>\n          <tr>\n\t\t\t  <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="</td>\n              <td class=\'fields\' width=\'25%\'><input align=\'left\' type=\'text\' name=\'next_country_desc\' id=\'next_country_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],next_country_desc);\' value = \"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" tabindex=\'51\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,next_country_desc)\' tabindex=\'51\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'next_country_code\' id=\'next_country_code\' >\n                        <script>\n\t\t\t\t\t\t   if(document.forms[0].next_country_code)\n\t\t\t\t\t\t      document.forms[0].next_country_code.value = \"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\";\n\t\t\t\t\t\t   if(document.forms[0].next_country_desc)\n\t\t\t\t\t\t\t  document.forms[0].next_country_desc.value = \"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\";\n\t\t\t\t\t\t</script>\n              </td>\n\t\t\t  <!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'nk_ma_country_desc\' id=\'nk_ma_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\' onblur=\'if(this.value !=\"\") searchCountry(nk_ma_country_code,nk_ma_country_desc);\' tabindex=\'54\'><input type=\'button\' name=\'nk_ma_country_code\' id=\'nk_ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nk_ma_country_desc)\' tabindex=\'54\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'nkin_mail_country_code\' id=\'nkin_mail_country_code\' value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n                    <script>\n\t\t\t\t\t\t   if(document.forms[0].nkin_mail_country_code)\n\t\t\t\t\t\t      document.forms[0].nkin_mail_country_code.value = \"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\";\n\t\t\t\t\t\t   if(document.forms[0].nk_ma_country_desc)\n\t\t\t\t\t\t\t  document.forms[0].nk_ma_country_desc.value = \"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="</td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ra_contact_name\' id=\'ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\" tabindex=\'52\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ma_contact_name\' id=\'ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" tabindex=\'55\'>\n                    </td></tr>\n\t\t\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t        <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(2)\'>";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(1)\'>";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="</a>\n\t\t\t    </td></tr></table>\n\t\t\t\t\t</table>\t\t\t\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\n\t\t\t <!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n          ";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\n          <tr>\n              <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="</td>\n              <td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\' tabindex=\'58\'>\n              </td>\n\t\t  </tr>\n          <tr>\n              <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="</td>\n              <td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" tabindex=\'59\'>\n              </td>\n\t\t  <tr>\n\t\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="</td>\n              <td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'next_off_tel_no\' id=\'next_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\" tabindex=\'60\'>\n              </td>\n          </tr>\n\t\t  <tr>\n\t\t      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="</td>\n              <td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\' onblur=\'makeValidString(this);document.forms[0].next_contact_name.focus();\' value = \"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" tabindex=\'61\'>\n              </td>\n          </tr>\n\t\t  ";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n\t\t  \n\t\t  </td></tr>\n\t\t  <tr><td colspan=6 class=label height=5></td></tr></table>\n\t\t  ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\n\t\t  <table width=\"100%\"><tr>\n\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'7\' >";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="</td>\n                </tr>\n\t\t\t\t<tr>\n\n\t\t\t\t\t<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\' tabindex=\'58\'>\n                    </td>\n\t\t\t\t\n                    <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\" tabindex=\'59\'>\n                    </td>\n\t\t\t\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\' onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\" tabindex=\'61\'>\n                    </td>     \n                </tr>\n\t\t\t\t";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'nk_contact3_mode\' id=\'nk_contact3_mode\' ";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="  onchange=\'enableContactNo(this)\'>\n\t\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact3_no\' id=\'nk_contact3_no\' maxlength=\'20\' size=\'13\' onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact4_mode\' id=\'nk_contact4_mode\' ";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact4_no\' id=\'nk_contact4_no\' maxlength=\'20\' size=\'13\' onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact5_mode\' id=\'nk_contact5_mode\' ";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact5_no\' id=\'nk_contact5_no\' maxlength=\'20\' size=\'13\' onblur=\'makeValidString(this);\'value=\"\">\n\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\tif(document.forms[0].nk_contact3_mode.value==\'\') \n\t\t\t\t\t\t\t\tdocument.forms[0].nk_contact3_no.disabled= true;\n\t\t\t\t\t\tif(document.forms[0].nk_contact4_mode.value==\'\') \n\t\t\t\t\t\t       document.forms[0].nk_contact4_no.disabled= true; \n\t\t\t\t\t\tif(document.forms[0].nk_contact5_mode.value==\'\') \n\t\t\t\t\t\t       document.forms[0].nk_contact5_no.disabled= true; \n\n\t\t\t\t\t\tif(document.forms[0].nk_contact3_mode)\n\t\t\t\t\t\t   document.forms[0].nk_contact3_mode.value = \"";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].nk_contact3_no)\n\t\t\t\t\t\t   document.forms[0].nk_contact3_no.value = \"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\" ;\n\n\t\t\t\t\t\tif(document.forms[0].nk_contact4_mode)\n\t\t\t\t\t\t   document.forms[0].nk_contact4_mode.value = \"";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].nk_contact4_no)\n\t\t\t\t\t\t   document.forms[0].nk_contact4_no.value = \"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\" ;\n\n\t\t\t\t\t\tif(document.forms[0].nk_contact5_mode)\n\t\t\t\t\t\t   document.forms[0].nk_contact5_mode.value = \"";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].nk_contact5_no)\n\t\t\t\t\t\t   document.forms[0].nk_contact5_no.value = \"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\" ;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\n\t\t  </table>\n\n</div>\n<div id = \'FIRST_TO_NOTIFY\' style = \'display:none\'>  \n   <!-- <a name=\"kin1\" ></a>   -->\n <!-- <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n    <tr><td class=\'white\'>\n\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Add Visit\">\n\t\t\t\t\t\t<a  class=\"tabA\" id=\'addVisit_tab\' >\n\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"addVisit_tabspan\" onClick=\'javascript:expandCollapse(\"add_Visit_tab\")\'>";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Arrival\">\n\t\t\t\t\t\t<a class=\"tabA\" id=\"arrival_tab\" >\n\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"arrival_tabspan\" onClick=\'javascript:expandCollapse(\"arrival_tab\")\'>";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t\t\t<a class=\"tabClicked\" id=\"rlcnts_tab\" >\n\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"rlcnts_tabspan\" onClick=\'javascript:expandCollapse(\"rel_con_tab\")\'>";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t\t\t<a  class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\" onClick=\'javascript:expandCollapse(\"fin_tab\")\'>";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\t\n\t\t</ul>\n\t</td></tr></table> \n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n       <tr >\n\t\t   <td class=\'white\'>\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Next of kin\">\n\t\t\t\t\t\t<a class=\"tabA\" id=\"secondkin\" >\n\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"secondkinspan\" onClick=\'javascript:expandCollapse(\"next_of_kin\")\'>";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t\t<a  class=\"tabClicked\" id=\"secondkin1\" >\n\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"secondkin1span\" onClick=\'javascript:expandCollapse(\"first_to_notify\")\'>";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Employment Details\">\n\t\t\t\t\t\t<a class=\"tabA\" id=\"secondempr\" >\n\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"secondemprspan\" onClick=\'javascript:expandCollapse(\"emp_details\")\'>";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t   </ul>\n\t       </td>\n\t   </tr>\n     </table>  -->\n\n            <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' align=\'center\' border=\'0\'>\n\t\t\t</tr><td colspan=4 class=label height=5>&nbsp;</td></tr>\n\t\t\t<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n        ";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\n\t\t\t<td valign=top width=\'45%\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' align=\'center\' border=\'0\'>\n\t\t\t</tr><td colspan=4 class=label height=5>&nbsp;</td></tr>\n            <tr>\n\t\t\t\t<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' value=\"";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\" onblur=\'makeValidString(this);\' maxlength=\'80\' size =\'30\'>\n\t\t\t    </td>\n\t\t\t\t<td colspan=2 class=label height=5>&nbsp;</td>\n\t\t\t</tr>\n\t\t    <tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<select name=\'first_contact_relation\' id=\'first_contact_relation\' >\n                         <option value=\'\'>---";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="---</option>\n                            ";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\n                        </select></td>\n\t\t\t\t\t   <td colspan=2 class=label height=5>&nbsp;</td>\n\t\t   \n\t\t\t\t</tr>\n\t\t       \t\n\t\t\t\t ";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\n\t\t\t\t <tr>\n\t\t\t\t\t  <td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t  <input type=\'text\'  name=\"contact2_nat_id_no\" id=\"contact2_nat_id_no\"   value = \"";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\" onkeypress=\'return ";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\'  maxlength=\'";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\"  size=\'20\'  ></td>\n\t\t\t\t\t  <td class=\'label\'  colspan=\'2\'>&nbsp;</td> \n\t            </tr>\t\n                ";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t    <select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' >\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\n                        </select>&nbsp;<input type=\'text\' name=\'notify_oth_alt_id_text\' id=\'notify_oth_alt_id_text\' value=\'\'  maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t\t<td colspan=2 class=label height=5>&nbsp;</td>\n                    </tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                           <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);document.forms[0].first_addr_line1.focus();\' value=\"";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\">\n                        </td> \n   \t\t\t\t\t   <td colspan=2 class=label height=5>&nbsp;</td>\n\t\t\t\t\t </tr>\n\t\t\t\t\t </table></td>\n\t\t";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n            <tr>\n\t\t\t\t<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' value=\"";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'first_contact_relation\' id=\'first_contact_relation\' >\n                         <option value=\'\'>---";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="&nbsp;</td>\n\t\t\t\t\t  <td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"contact2_nat_id_no\" id=\"contact2_nat_id_no\"   value = \"";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t    <select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' >\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="</td>\n                        <td class=\'fields\' width=\'25%\'>\n                           <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);document.forms[0].first_addr_line1.focus();\' value=\"";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\">\n                        </td> \n   \t\t\t\t\t   <td colspan=2 class=label height=5>&nbsp;</td>\n\t\t\t\t\t</tr>\n                    <!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t\t<td width=\'50%\'><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\' ></td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\n\t\t\t    <!--Ended by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n                ";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 =" \n\t\t\t\t\t<script>\n\t\t\t\t        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\tif(document.forms[0].first_addr_line1)\n\t\t\t\t\t\t   document.forms[0].first_addr_line1.value = \"";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].first_addr_line2)\n\t\t\t\t\t\t   document.forms[0].first_addr_line2.value = \"";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].first_addr_line3)\n\t\t\t\t\t\t   document.forms[0].first_addr_line3.value = \"";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].first_addr_line4)\n\t\t\t\t\t\t   document.forms[0].first_addr_line4.value = \"";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].contact2_res_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t document.forms[0].contact2_res_town_code.value = \"";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\";\n\t\t\t\t\t\t document.forms[0].f_town.value = \'";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\';\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].contact2_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t     document.forms[0].contact2_region_code.value = \"";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\";\n\t\t\t\t\t\t document.forms[0].f_region.value = \'";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\'; \n\n                        }\n\t\t\t\t\t\tif(document.forms[0].contact2_res_area_code)\n\t\t\t\t\t\t{\n                \t\tdocument.forms[0].contact2_res_area_code.value = \"";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\";\n\t\t\t\t\t\tdocument.forms[0].f_area.value = \'";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\';\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].first_postal_code1){\n\t\t\t\t\t\t   document.forms[0].first_postal_code.value = \"";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\"; \n\t\t\t\t\t\t   document.forms[0].first_postal_code1.value = \"";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\"; \n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(document.forms[0].fton_mail_addr_line1)\n\t\t\t\t\t\t   document.forms[0].fton_mail_addr_line1.value = \"";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_mail_addr_line2)\n\t\t\t\t\t\t   document.forms[0].fton_mail_addr_line2.value = \"";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_mail_addr_line3)\n\t\t\t\t\t\t   document.forms[0].fton_mail_addr_line3.value = \"";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_mail_addr_line4)\n\t\t\t\t\t\t   document.forms[0].fton_mail_addr_line4.value = \"";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fst_to_no_ma_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t document.forms[0].fst_to_no_ma_town_code.value = \"";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\";\n\t\t\t\t\t\t document.forms[0].contact2_res_town.value = \"";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].fst_to_no_ma_reg_cod)\n\t\t\t\t\t\t{\n\t\t\t\t\t     document.forms[0].fst_to_no_ma_reg_cod.value = \"";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\";\n\t\t\t\t\t\t document.forms[0].contact2_region.value = \"";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\"; \n                        }\n\t\t\t\t\t\tif(document.forms[0].fst_to_no_ma_area_code)\n\t\t\t\t\t\t{\n                \t\tdocument.forms[0].fst_to_no_ma_area_code.value = \"";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\";\n\t\t\t\t\t\tdocument.forms[0].contact2_res_area.value = \"";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].fst_no_ma_pos_cod1){\n\t\t\t\t\t\t   document.forms[0].fst_no_ma_pos_cod.value = \"";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\";\n\t\t\t\t\t\t document.forms[0].fst_no_ma_pos_cod1.value = \"";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\";\n\t\t\t\t\t\t \n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\t// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\t </script>\n                  <tr>\n\t\t\t\t\t   <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="</td>\n\t\t\t\t\t   <td class=\'fields\' width=\'25%\'><input align=\'left\' type=\'text\' name=\'first_country_desc\' id=\'first_country_desc\'  size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],first_country_desc);\'  value =\"";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\" tabindex=\'61\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_country_desc)\' tabindex=\'61\'>\n\t\t\t\t\t   <input type=\'hidden\' name=\'first_country_code\' id=\'first_country_code\' value=\'\'>\n\t\t\t\t\t   <script>\n\t\t\t\t\t\t\tif(document.forms[0].first_country_code)\n\t\t\t\t\t\t\t   document.forms[0].first_country_code.value = \"";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\";\n\t\t\t\t\t\t\tif(document.forms[0].first_country_desc)\n\t\t\t\t\t\t\t   document.forms[0].first_country_desc.value = \"";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\";\n\t\t\t\t\t  </script>\n                      </td>\n                      <!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\t\n\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'first_mail_country_desc\' id=\'first_mail_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\' onblur=\'if(this.value !=\"\") searchCountry(ma_country_code,first_mail_country_desc); \' tabindex=\'64\'><input type=\'button\' name=\'ma_country_code\' id=\'ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_mail_country_desc)\' tabindex=\'64\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'first_mail_country_code\' id=\'first_mail_country_code\' value=\"";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\">\n\t\t\t\t\t <script>\n\t\t\t\t\t\t\tif(document.forms[0].first_mail_country_code)\n\t\t\t\t\t\t\t   document.forms[0].first_mail_country_code.value = \"";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\";\n\t\t\t\t\t\t\tif(document.forms[0].first_mail_country_desc)\n\t\t\t\t\t\t\t   document.forms[0].first_mail_country_desc.value = \"";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\";\n\t\t\t\t\t  </script>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="</td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ra_contact_name\' id=\'fton_ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\" tabindex=\'62\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ma_contact_name\' id=\'fton_ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\" tabindex=\'65\'>\n                    </td>\n\t\t\t\t</tr>\n\n\t\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t    <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(4)\'>";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(3)\'>";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="</a>\n\t\t\t    </td></tr></table></table>\n\n\t\t\t\t<table width=\"100%\"><tr>\n\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'7\' >";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="</td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t    \n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\" tabindex=\'70\'>\n\t\t\t\t    </td>\n\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\" tabindex=\'71\'>\n\t\t\t\t    </td>\n\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);document.forms[0].first_contact_name.focus();\' value = \"";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\" tabindex=\'73\'>\n\t\t\t\t\t</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'fton_contact3_mode\' id=\'fton_contact3_mode\' ";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact3_no\' id=\'fton_contact3_no\' maxlength=\'20\' size=\'13\'   onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact4_mode\' id=\'fton_contact4_mode\' ";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact4_no\' id=\'fton_contact4_no\' maxlength=\'20\' size=\'13\'   onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact5_mode\' id=\'fton_contact5_mode\' ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact5_no\' id=\'fton_contact5_no\' maxlength=\'20\' size=\'13\'   onblur=\'makeValidString(this);\'value=\"\">\n\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\tif(document.forms[0].fton_contact3_mode.value==\'\') \n\t\t\t\t\t\t\t\tdocument.forms[0].fton_contact3_no.disabled= true;\n\t\t\t\t\t\tif(document.forms[0].fton_contact4_mode.value==\'\') \n\t\t\t\t\t\t       document.forms[0].fton_contact4_no.disabled= true; \n\t\t\t\t\t\tif(document.forms[0].fton_contact5_mode.value==\'\') \n\t\t\t\t\t\t       document.forms[0].fton_contact5_no.disabled= true; \n\t\t\t\t\t\tif(document.forms[0].fton_contact3_mode)\n\t\t\t\t\t\t   document.forms[0].fton_contact3_mode.value = \"";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_contact3_no)\n\t\t\t\t\t\t   document.forms[0].fton_contact3_no.value = \"";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\" ;\n\n\t\t\t\t\t\tif(document.forms[0].fton_contact4_mode)\n\t\t\t\t\t\t   document.forms[0].fton_contact4_mode.value = \"";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_contact4_no)\n\t\t\t\t\t\t   document.forms[0].fton_contact4_no.value = \"";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\" ;\n\n\t\t\t\t\t\tif(document.forms[0].fton_contact5_mode)\n\t\t\t\t\t\t   document.forms[0].fton_contact5_mode.value = \"";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].fton_contact5_no)\n\t\t\t\t\t\t   document.forms[0].fton_contact5_no.value = \"";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\" ;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</td>\n\t\t\t\t    </tr>\t\n\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\n\t\t\t\t<td colspan=2 class=label>&nbsp;</td>\n                ";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\n                <tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n                        <input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\" tabindex=\'70\'>\n\t\t\t\t\t\t<td colspan=2 class=label>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="</td>\n                        <td class=\'fields\' width=\'25%\'>\n                        <input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\" tabindex=\'71\'>\n\t\t\t\t\t\t<td colspan=2 class=label>&nbsp;</td>\n\t\t\t\t    </tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'  >";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'first_off_tel_no\' id=\'first_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" tabindex=\'72\'>\n\t\t\t\t\t    <td colspan=2 class=label>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);document.forms[0].first_contact_name.focus();\' value = \"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\" tabindex=\'73\'>\n\t\t\t\t\t\t<td colspan=2 class=label>&nbsp;</td>\n\t\t\t\t  </tr>\n\t\t\t\t  ";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\n    \t\t\t  <tr><td colspan=4 class=label height=5></td></tr>\n    </table>\n    \n</div>\n<div id = \'EMP_DETAILS\' style = \'display:none\'>  \n<!--  <a name=\"empyr\" ></a>  --> \n<!--  <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n    <tr><td class=\'white\'>\n\t\t  <ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Add Visit\">\n\t\t\t\t\t<a class=\"tabA\" id=\'addVisit_tab\' >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"addVisit_tabspan\" onClick=\'javascript:expandCollapse(\"add_Visit_tab\")\'>";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Arrival\">\n\t\t\t\t\t<a  class=\"tabA\" id=\"arrival_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"arrival_tabspan\" onClick=\'javascript:expandCollapse(\"arrival_tab\")\'>";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Related Contact details\">\n\t\t\t\t\t<a class=\"tabClicked\" id=\"rlcnts_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"rlcnts_tabspan\" onClick=\'javascript:expandCollapse(\"rel_con_tab\")\'>";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t\t";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\n\t\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t\t<a class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\" onClick=\'javascript:expandCollapse(\"fin_tab\")\'>";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\t\n\t\t </ul>\n\t</td></tr></table>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n        <tr><td class=\'white\'>\n\n\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Next of kin\">\n\t\t\t\t<a class=\"tabA\" id=\"thirdkin\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"thirdkinspan\" onClick=\'javascript:expandCollapse(\"next_of_kin\")\'>";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a  class=\"tabA\" id=\"thirdkin1\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"thirdkin1span\" onClick=\'javascript:expandCollapse(\"first_to_notify\")\'> ";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\n\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\"Employment Details\">\n\t\t\t\t<a class=\"tabClicked\" id=\"thirdempr\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"thirdemprspan\" onClick=\'javascript:expandCollapse(\"emp_details\")\'>";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t</ul>\n\t\t\t\t</td></tr></table> -->\n \n\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=0 align=\'center\'>\n\t\t\t\t<tr>\n                   <td align=\'center\' class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</td>\n\t\t\t\t   <td align=\'center\' class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="</td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t<td><table cellspacing=\'0\' cellpadding=\'0\' width=\'92%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr><td colspan=2 class=label height=5></td></tr>\n\t\t\t\t<!--Below line added for this ML-MMOH-CRF-0860.2-->  \n\t\t\t\t<tr>\n\t\t\t\t\t <td class=\'label\' width=\'50%\'  >";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="</td>\n                     <td class=\'fields\' width=\'50%\'>\n                      <input type=\'text\' name=\'organization_name\' id=\'organization_name\' maxlength=\'";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\' size=\'";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\'  onblur=\"makeValidString(this);\" value=\"";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\"></input>\n                    </td>\t\t\n\t\t\t   </tr>\n\t\t\t   <!--End ML-MMOH-CRF-0860.2-->\n\t\t\t   <tr>\n\t\t\t\t\t<td class=\'label\' width=\'50%\' nowrap>";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="</td>\n                    <td class=\'fields\' width=\'50%\'>\n                        <input type=\'text\' name=\'empyr_contact_name\' id=\'empyr_contact_name\' maxlength=\'30\' size=\'30\' onblur=\'makeValidString(this);document.forms[0].employ_addr_line1.focus();\'  value = \"";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" ></input>\n                    </td>\n\t\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 =" \n\t\t\t\t<script>\n\t\t\t\t        // Added on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\tif(document.forms[0].employ_addr_line1)\n\t\t\t\t\t\t   document.forms[0].employ_addr_line1.value = \"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].employ_addr_line2)\n\t\t\t\t\t\t   document.forms[0].employ_addr_line2.value = \"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].employ_addr_line3)\n\t\t\t\t\t\t   document.forms[0].employ_addr_line3.value = \"";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].employ_addr_line4)\n\t\t\t\t\t\t   document.forms[0].employ_addr_line4.value = \"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].contact3_res_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t document.forms[0].contact3_res_town_code.value = \"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\";\n\t\t\t\t\t\t document.forms[0].e_town.value = \"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].contact3_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t     document.forms[0].contact3_region_code.value = \"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\";\n\t\t\t\t\t\t document.forms[0].e_region.value = \"";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\"; \t\n                        }\n\t\t\t\t\t\tif(document.forms[0].contact3_res_area_code)\n\t\t\t\t\t\t{\n                \t\tdocument.forms[0].contact3_res_area_code.value = \"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\";\n\t\t\t\t\t\tdocument.forms[0].e_area.value = \"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].employ_postal_code1){\n\t\t\t\t\t\t   document.forms[0].employ_postal_code.value = \"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\";\n\t\t\t\t\t\t   document.forms[0].employ_postal_code1.value = \"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\n       \t\t\t\t\t\t// End of addition on 7/05/2004 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\t </script>\t\n                <tr>\n                    <td class=\'label\' width=\'50%\'>";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="</td>\n\n                    <td class=\'fields\' width=\'50%\'><input type=\'text\' name=\'empyr_country_desc\' id=\'empyr_country_desc\'                       size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],empyr_country_desc);\' value = \"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],empyr_country_desc);\' tabindex=\'80\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\'  onclick=\'searchCountry(this,empyr_country_desc)\' tabindex=\'81\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'empyr_country_code\' id=\'empyr_country_code\' value=\'\'>\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t   if(document.forms[0].empyr_country_code)\n\t\t\t\t\t\t\t     document.forms[0].empyr_country_code.value = \"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\";\n\t\t\t\t\t\t\t   if(document.forms[0].empyr_country_desc)\n\t\t\t\t\t\t\t     document.forms[0].empyr_country_desc.value = \"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\";\n\t\t\t\t           </script>\n                   </td>\n               </tr>\n               <tr>\n                   <td class=\'label\' width=\'50%\' >";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="</td>\n                   <td class=\'fields\' width=\'50%\'>\n                       <input type=\'text\' name=\'res3_tel_no\' id=\'res3_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\" tabindex=\'82\'>\n                   </td>\n\t\t\t\t   \n                   </tr>\n\t\t\t\t   <tr>\n               \n                   <td class=\'label\' width=\'50%\' >";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="</td>\n                   <td class=\'fields\' width=\'50%\'>\n                        <input type=\'text\' name=\'empyr_off_tel_no\' id=\'empyr_off_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value =\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\" tabindex=\'83\'>\n                   </td>\n               </tr><tr><td colspan=8 class=label height=5></td></tr>\n\t\t\t   </table> </td>\n\t\t\t   <td valign=top><table cellspacing=\'1\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t\t   <tr><td colspan=8 class=label height=5></td></tr>\n\t\t\t   <tr><td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="</td>\n                    <td class=\'fields\' width=\'25%\'>\n                        <input type=\'text\' name=\'empyr_eid\' id=\'empyr_eid\' maxlength=\'20\' size=\'20\' onfocus=\"\" onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\" tabindex=\'84\'></input>\n                    </td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t        <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'> <select name=\'occ_class\' id=\'occ_class\'  onchange=\'setOccOfPerson();\' tabindex=\'85\'>\n                            <option value=\'\'>----";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="---</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\n                        </select></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t        <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="</td>\n                    <td class=\'fields\' colspan=\'2\'>\n                        <select name=\'occ_of_per\' id=\'occ_of_per\' onchange= \'enableocpn();\' tabindex=\'86\'>\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="---</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\n\t\t\t\t\t</select>&nbsp;&nbsp;<input type=\'text\' name=\'occu_of_per_desc\' id=\'occu_of_per_desc\' size=\'";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\' maxlength=\'";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\' onblur=\'\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\" align=\'left\' tabindex=\'87\'></td> \t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!--Above line modified for ML-MMOH-CRF-860.2-->\n\t\t\t    <tr>\n\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="</td>\n                    <td class=\'fields\' width=\'25%\'>\n                        <select name=\'empyr_employment_status\' id=\'empyr_employment_status\'  onblur=\"tab_click2(\'#empyr\',\'firstempyr\')\" onchange=\'\' tabindex=\'88\'>\n\t\t\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="-----------&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\n\t\t\t\t\t\t  <option value=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\" selected>";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="</option>\n                         ";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n                            <option value=\'FE\'>";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'FS\'>";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'NA\'>";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="</option>\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'PE\'>";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'PS\'>";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'SE\'>";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'UE\'>";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'UK\'>";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="</option>\n                        </select>\t\n\n\t\t\t</td>\n\t\t\t</tr>\n\t\t</table></table>\n\t\t</div>\n\t\t</div>\n    <!--Start--Hidden Fields for Billing Interface-->\n    ";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 =" \n        ";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\n        ";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 =" \n    ";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\n    <input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n    <input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\"\"></input>\n    <input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\"\"></input>\n    <input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\"\"></input>\n    <input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\"Add\"></input>\n    <input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'\'></input>\n    <input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\'\'></input>\n    <input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\'\'></input>\n<!-- Added for Billing Enhancements -->    \n\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\'></input>\n    <input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\'\'></input>\n    <input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\'\'></input>\n    <input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\'\'></input>\n    <input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\'\'></input>\n    <input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'\'></input>\n    <input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\'\'></input>\n    <!-- End for Billing Enhancements -->\n    <input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\'\'></input>\n    <input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'></input>  \n\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\"\"></input> \n    ";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\n    <!--End--Hidden Fields for Billing Interface-->\n\t<input type=\'hidden\' name=\'ct_patient_id\' id=\'ct_patient_id\' value=\"C\"></input>\n\t<input type=\'hidden\' name=\'care_locn_type_ind\' id=\'care_locn_type_ind\' value=\"C\"></input>\n    <input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'></input>\n    <input type=\'hidden\' name=\'upd_user_flag\' id=\'upd_user_flag\' value=\'\'></input>\n    <input type=\'hidden\' name=\'reccnt\' id=\'reccnt\' value=\"";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\"></input>\n    <!-- Hidden fields for Visit Charge Calculation  -->\n    <input type=\'hidden\' name=\'pkg_bill_doc_type\' id=\'pkg_bill_doc_type\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_bill_doc_num\' id=\'pkg_bill_doc_num\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'effective_date\' id=\'effective_date\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\"\"></input>\n    <input type=\'hidden\' name=\'approved_days\' id=\'approved_days\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_qty\' id=\'base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_rate\' id=\'base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_charge_amt\' id=\'base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'gross_charge_amt\' id=\'gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'disc_amt\' id=\'disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'net_charge_amt\' id=\'net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_qty\' id=\'pat_base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_rate\' id=\'pat_base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_serv_qty\' id=\'pat_serv_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_charge_amt\' id=\'pat_base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_gross_charge_amt\' id=\'pat_gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_disc_amt\' id=\'pat_disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_net_charge_amt\' id=\'pat_net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_qty\' id=\'cust_base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_rate\' id=\'cust_base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_serv_qty\' id=\'cust_serv_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_charge_amt\' id=\'cust_base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_gross_charge_amt\' id=\'cust_gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_disc_amt\' id=\'cust_disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_net_charge_amt\' id=\'cust_net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'split_yn\' id=\'split_yn\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_ins_pat_ind\' id=\'pkg_ins_pat_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_pkg_qty\' id=\'req_pkg_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_addl_qty\' id=\'req_addl_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_std_qty\' id=\'req_std_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'curr_availed\' id=\'curr_availed\' value=\"\"></input>\n    <input type=\'hidden\' name=\'canadj_alert_ind\' id=\'canadj_alert_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_serv_code\' id=\'pkg_serv_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'visit_charge_stage\' id=\'visit_charge_stage\' value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\"></input>\n    <input type=\'hidden\' name=\'day_type_code\' id=\'day_type_code\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'time_type_code\' id=\'time_type_code\' value=\"\"></input>     \n    <input type=\'hidden\' name=\'disc_perc\' id=\'disc_perc\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'addl_fctr\' id=\'addl_fctr\' value=\"\"></input>  \n    <!-- End of Hidden fields for Visit Charge Calculation  -->\n    <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\"></input>  \n    <input type=\'hidden\' name=\'pkg_sel\' id=\'pkg_sel\' value=\"\"></input>    \n    <input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\"\"></input> \n\n    <!--   Start of modifications for billing enhancement on 9th Dec 2003  -->\n    <input type=\'hidden\' name=\'cred_start_dt1\' id=\'cred_start_dt1\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'cred_start_dt2\' id=\'cred_start_dt2\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'cred_start_dt3\' id=\'cred_start_dt3\' value=\"\"></input> \n\t   \n    <!-- End of modifications for billing enhancement on 9th Dec 2003    -->\n\n   \t<!-- added on 8/25/2003 -->  \n\t <input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\"";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\">\n\t<input type=\'hidden\' name=\'outst_amt\' id=\'outst_amt\' value=\"";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\">\n\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\"> \n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\"> \n    <!-- Added for Billing validation on 16/8/2002 -->\n\t<input type=\'hidden\' name=\'health_card_expired_yn1\' id=\'health_card_expired_yn1\' value=\'";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\'>\n\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\">\n\t<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start-->\n\t<input type=\'hidden\' name=\'invoke_from\' id=\'invoke_from\' value=\"";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\">\n\t<input type=\'hidden\' name=\'frameRef\' id=\'frameRef\' value=\"";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\">\n\t<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End-->\n\n\t<!-- Added by Ajay Hatwate for GHL-CRF-0650 -->\n\t<input type=\'hidden\' name=\'isMLCAppl\' id=\'isMLCAppl\' value=\"";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\">\n  ";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\n   \n\t\t  ";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\n\t\t\t<input type=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"N\">\n\t\t\t";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\n\t\t\t<input type=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"Y\">\n\t\t  ";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\n\n\t\t  <input type=\"hidden\" name=\"isAENextofKinchngAppl\" id=\"isAENextofKinchngAppl\" value=\"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\"> <!-- added by mujafar for ML-MMOH-CRF-0632 -->\n\t\t  <input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" value=\"";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\">\t\n\t\t  <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\"> \n          <input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\'S\'></input>\n\t\t  <input type=\'hidden\' name=\'entitlement_by_cat_yn\' id=\'entitlement_by_cat_yn\' value=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\"> \n\t\t  <input type=\'hidden\' name=\'patFlag\' id=\'patFlag\' value=\"";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\"> \n\t\t  <input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\">\n\t\t  <input type=\'hidden\' name=\'patient_age\' id=\'patient_age\' value=\"";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\">\n\t\t  <input type=\'hidden\' name=\'accident_type_val\' id=\'accident_type_val\' value=\"\">\n   \t\t  <input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\"\">\n   \t\t  <input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'sub_service_code\' id=\'sub_service_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'priority_no_code\' id=\'priority_no_code\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'visit_type_ind\' id=\'visit_type_ind\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'sysDateWithoutTime\' id=\'sysDateWithoutTime\' value=\"";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\">\n\t\t  <input type=\'hidden\' name=\'new_episode_yn_val\' id=\'new_episode_yn_val\' value=\"Y\">\n\t\t  <input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\"\">\t\t  \n   \t\t  <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\">\n\t\t  <input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\">\n   \t\t  <input type=\'hidden\' name=\'buildEpisodeRule\' id=\'buildEpisodeRule\' value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\">\n          <input type=\'hidden\' name=\'disaster_area\' id=\'disaster_area\' value=\'\'>\n          <input type=\'hidden\' name=\'new_file_no\' id=\'new_file_no\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'responsiveness\' id=\'responsiveness\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'symptom\' id=\'symptom\' value=\'\'> \n\t\t  <input type=\'hidden\' name=\'pregnant_at_present_yn\' id=\'pregnant_at_present_yn\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'developmental_mile_stone_yn\' id=\'developmental_mile_stone_yn\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'immunization_upto_date_yn\' id=\'immunization_upto_date_yn\' value=\'\'>\n   \t\t  <input type=\'hidden\' name=\'relation\' id=\'relation\' value=\'\'>\t\t   \n   \t\t  <input type=\'hidden\' name=\'blunt_yn\' id=\'blunt_yn\' value=\'\'>\t\t   \n   \t\t  <input type=\'hidden\' name=\'penetrating_yn\' id=\'penetrating_yn\' value=\'\'>\t\t \n   \t\t  <input type=\'hidden\' name=\'case_of_trauma_yn\' id=\'case_of_trauma_yn\' value=\'\'>\t\t \n   \t\t  <input type=\'hidden\' name=\'rtaCheck\' id=\'rtaCheck\' value=\'\'>\t\t   \n\t\t  <input type=\'hidden\' name=\'vaccinated_yn\' id=\'vaccinated_yn\' value=\'\'>\t\t     \n   \t\t  <input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'GENERATEFILE\'>\n\t\t  <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\"";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\">\n\t\t  <input type=\'hidden\' name=\'start_date\' id=\'start_date\' value=\"";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\">\n\t\t  <input type=\'hidden\' name=\'paediatric_yn\' id=\'paediatric_yn\' value=\"";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\">\n   \t\t  <input type=\'hidden\' name=\'gynaec_yn\' id=\'gynaec_yn\' value=\"";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\">\n\t\t  <input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\">\n\t\t  <input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\">\n\t\t  <input type=\'hidden\' name=\'regn_date\' id=\'regn_date\' value=\"";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\">\n\t\t  <input type=\'hidden\' name=\'dummy_visit_dttm\' id=\'dummy_visit_dttm\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'dummy_location_code\' id=\'dummy_location_code\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'dummy_visit_type\' id=\'dummy_visit_type\' value=\"\">\n\t\t  <input type=\'hidden\' name=\'nat_id_accept_alphanumeric_yn\' id=\'nat_id_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\"> \n\t\t   <input type=\'hidden\' name=\'nationality_id\' id=\'nationality_id\' value=\"";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\"> \n\t\t  \n\t\t<input type=\'hidden\' name=\'downtimePatient\' id=\'downtimePatient\' value=\"";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\">\n\t\t<input type=\'hidden\' name=\'reg_date_time\' id=\'reg_date_time\' value=\"";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\"><!--Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] -->\n\n\n<!-- *********added on 9th Dec 2003 , pass referral_id  to financila details******* -->\n\t<input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'org_type\' id=\'org_type\' value=\"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\">\n    <input type=\'hidden\' name=\'bl_enter_yn\' id=\'bl_enter_yn\' value=\'N\'>\n\t\t\n<!-- ends  -->\n    <input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'EM\'>\n<!-- Added on 26/08/2004 for calling MP_PAT_ADD_UPDATE in ejb -->\n<!-- \t<input type=\'hidden\' name=\'call_mp_pat_add_update\' id=\'call_mp_pat_add_update\' value=\"N\"></input>  Monday, April 26, 2010 (venkat s) Contact deatisl proc change related modification -->\n<!-- Addition ends-->\n\t<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start -->\n\t<input type=\"hidden\" name=\"five_level_triage_appl_yn\" id=\"five_level_triage_appl_yn\" value=\"";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\">\n\t<!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End -->\n\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start-->\n\t<input type = \'hidden\' name = \'isForm60Available\' value=\"";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\">  \n\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End-->\n\t\n\t<!--Below line added for this CRF GDOH-CRF-0129-->\n\t<input type=\"hidden\" name=\"assigncare_loctype_ind\" id=\"assigncare_loctype_ind\" id=\"assigncare_loctype_ind\" value=\"";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\">\n\t<input type=\"hidden\" name=\"assigncare_locacode\" id=\"assigncare_locacode\" id=\"assigncare_locacode\" value=\"";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\">\n\t<input type=\"hidden\" name=\"isReferral\" id=\"isReferral\" id=\"isReferral\" value=\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\"> \n\t<!--End GDOH-CRF-0129-->\n\t<!--Below line added for this CRF ML-MMOH-CRF-0629-->\n\t<input type=\"hidden\" name=\"priorityZone\" id=\"priorityZone\" id=\"priorityZone\" value=\"\"> \n\t<!-- End this CRF ML-MMOH-CRF-0629-->\n\t\n\t<!-- START Added by Sangeetha for KDAH-CRF-0347-->\n\t<input type=\"hidden\" name=\"validationForPanCardAvail\" id=\"validationForPanCardAvail\" value=\"";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\"> \n\t<input type=\"hidden\" name=\"form60_YN\" id=\"form60_YN\" value=\"\">\n\t<!-- END KDAH-CRF-0347-->\n\n\t<!--Added by Ashwini on 17-Aug-2017 for GDOH-CRF-0161-->\n\t<input type=\"hidden\" name=\"isLabelChngAppl\" id=\"isLabelChngAppl\" value=\"";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\"> \n\n\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601-->\n\n\t<input type=\'hidden\' name=\'isMechInjLabelChngAppl\' id=\'isMechInjLabelChngAppl\' value=\"";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\"><!--Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-0649-->\n\n\t<!--Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start-->\n\t<input type=\'hidden\' name=\'isCaseDtlsRadioBtnAppl\' id=\'isCaseDtlsRadioBtnAppl\' value=\'";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\'>\n\t<input type=\'hidden\' name=\'OandG_yn\' id=\'OandG_yn\' value=\'N\'>\n\t<!--End-->\n\t<!--Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\n\t<input type=\'hidden\' name=\'isPriorityZoneAppl\' id=\'isPriorityZoneAppl\' value=\'";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\'>\n\t<!-- Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008 -->\n    <input type=\'hidden\' name=\'resiAddMailAdd\' id=\'resiAddMailAdd\' value=\'";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\'>\n\n\t<!--Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409-->\n    <input type=\'hidden\' name=\'isReconfirmCOTAppl\' id=\'isReconfirmCOTAppl\' value=\'";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\'>\n    <input type=\'hidden\' name=\'reconf_cot_param\' id=\'reconf_cot_param\' value=\'";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\'>\n\n\t </form>\n\t </body>\n";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

   ArrayList fetchContactAddresses(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;	
		
		//Added for this CRF ML-MMOH-CRF-0860.2
		boolean increasedaddressLength = false;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
		    //Added for this CRF ML-MMOH-CRF-0860.2
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	          
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				res_town_prompt		= rset1.getString("res_town_prompt");
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				region_prompt		= rset1.getString("region_prompt");
			}
           
		    /*Below line modified for this CRF ML-MMOH-CRF-0860 (increase the maxlength from 30 to 100)*/		  
			/*String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='100' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
			*/
            //End this CRF ML-MMOH-CRF-0860
			 
			//below line added for this ML-MMOH-CRF-0860.2
			String addr_line1="";
			String addr_line2="";
			String addr_line3="";
			String town_length="40";
			String rapidreg_nextofkin_addr_line1="";
			String rapidreg_nextofkin_addr_line2="";
			String rapidreg_nextofkin_addr_line3="";
			if(increasedaddressLength){
             town_length="36";			
			/* addr_line1 = "<textarea name='r_addr_line1' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line2 = "<textarea name='r_addr_line2' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line3 = "<textarea name='r_addr_line3' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";*/
			 
			 addr_line1 = "<textarea name='r_addr_line1' id='r_addr_line1' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line2 = "<textarea name='r_addr_line2' id='r_addr_line2' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line3 = "<textarea name='r_addr_line3' id='r_addr_line3' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 			 
			}else{			
		     addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			 addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
             addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			}			
			//End this ML-MMOH-CRF-0860.2
			
			
			String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			System.out.println("res_town_prompt"+res_town_prompt);
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='"+town_length+"'  maxlength='"+town_length+"' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";	
           
		   
			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
			
			
			
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
															
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);
			
			

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        {
         
        e.printStackTrace();		 
         
		}
        return return_arrlist ;
    }
	   ArrayList fetchContactAddressesLocal(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				System.out.println("area"+res_area_prompt);
				res_town_prompt		= rset1.getString("res_town_prompt");
				System.out.println("town"+res_area_prompt);
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				System.out.println("code"+res_area_prompt);
				region_prompt		= rset1.getString("region_prompt");
				System.out.println("region_prompt"+region_prompt);
			}
         
			String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='20'  maxlength='40' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        { }
        return return_arrlist ;
    }


	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block8Bytes, _wl_block8);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Start - Added for GDOH-CRF-149
	session.removeAttribute("str_clinic_code");
	session.removeAttribute("classTypChangeAuthYnPatId");
//End - Added for GDOH-CRF-149

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
        Connection con							= null;
    	PreparedStatement pstmt_race			= null;
    	PreparedStatement pstmt					= null;
		ResultSet rset_race						= null; 
		ResultSet rset							= null; 
		ResultSet rs							= null;
		ArrayList contact_addr                  = null; 
        PreparedStatement oth_stmt              = null;
		ResultSet oth_rset                      = null;
		//PreparedStatement pstmtR                = null;
		//ResultSet rsetR                         = null;
		ArrayList race_array = new ArrayList();
		PreparedStatement pstmtEncounter = null;
		ResultSet rsetEncounter = null;
		int countRecEnc =0;
		String auth_win_reqd_yn = "N";
		String sel                              = "";
		String Accept_oth_alt_id_yn             = "";
		//String sql             = "";
        //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		
		Object contactmode[]	= null;
	        Object contactdesc[]	= null;

		Object oth_code[] = null; 
	        Object oth_desc[] = null; 

		ArrayList codes	= null;
	        ArrayList descs	= null;
		
        //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		String[] contact_col_names				= null ;
		String[] contact_prompts				= null ;
		String[] contact_fields					= null ;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale					= (String)session.getAttribute("LOCALE");
		java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" ) ;
        String remarks				    = "";
		String alt_id1_no		         = "", 		nat_id_prompt		        = "";
		String blood_group			    = "",		rh_factor			        = "";
		String sysdate				    = "",		proBrought_dead				= "";
		String sysDateWithoutTime       = "",		accept_national_id_no_yn    = "";
		String accept_oth_alt_id_yn     = "",       nat_id_length               = "";
		String nationality_id			= "",		nationality				    = "";
		String date_of_birth            = "",       buildEpisodeRule	        = "X";
		String alt_id1_desc				= "";
		String oth_alt_id_desc			= "",		oth_alt_id_no				= "";
		String residency				= "",		legal_status				= "";	
		String visit_back_yn			= "",		start_date				    = "";
		String sex						= "";
		String paediatric_yn			= "",		gynaec_yn				    = "";
		String EncounterProp ="disabled";
		String blood_group_code         = "",	    rh_factor_code              = "";
		String nat_id_accept_alphanumeric_yn = "";
		String alt_id2_no		         = "", alt_id2_desc				= ""; // added for PMG2014-HSA-CRF-0001 [IN:050020] 
		String alt_id3_no		         = "", alt_id3_desc				= ""; // added for PMG2014-HSA-CRF-0001 [IN:050020] 
		String alt_id4_no		         = "", alt_id4_desc				= ""; // added for PMG2014-HSA-CRF-0001 [IN:050020] 

		int  patient_age				= 0;
		int	 tindex                     = 0;
		
 
		// For AE Related Contacts
		String contact1_relation	    = "",       contact1_name				= "";
	    String contact1_nat_id_no       = "",		contact1_birth_date         = "";
		String job1_title			    = "",		addr1_line1				    = "";	
		String addr1_line2				= "",		addr1_line3				    = "";
		String addr1_line4				= "",		contact1_res_town           = ""; 
		String contact1_area_code       = "",		contact1_region_code        = "";
        String res1_mbo_tel_no          = "",		postal1_code			    = "";
		String country1_code		    = "",		res1_tel_no			        = "";
		String off1_tel_no				= "",		contact2_relation           = "";
		String contact2_nat_id          = "",		contact2_town_code          = "";
		String contact2_res_tel_no      = "",		contact2_mob_tel_no         = "";
		String contact2_off_tel_no      = "",		contact2_mail_id		    = "";
		String contact2_add_l1			= "",		contact2_add_l2			    = "";
		String contact2_add_l3			= "",		contact2_add_l4			    = "";
		String contact2_area_code       = "",		contact2_reg_code		    = "";
		String contact3_org_name        = "",		contact3_town_code          = "";
		String contact3_reg_code		= "",		contact3_area_code		    = "";
		String ocpn_class_code          = "",		contact2_country_code       = "";
		String contact1_email_id        = "",		employer_name		        = "";
		String job2_title			    = "",		postal2_code			    = "";
		String first_to_notify_name		= ""; 
		String addr3_line1				= "";
		String addr3_line2				= "",		addr3_line3				    = "";
		String addr3_line4				= "",		postal3_code			    = "";
		String country3_code		    = "",		res3_tel_no			        = "";
		String off3_tel_no				= "",		ocpn_code				    = "";
		String ocpn_desc				= "",		patient_employee_id         = "";
		String employment_status	    = "",		regn_date				    = "";
		String contact1_res_town_desc   = "",		country1_code_desc          = "";
		String contact2_res_town_desc   = "",		contact2_res_area__desc     = "";
		String contact2_region_desc     = "",		contact1_res_area__desc     = "";
		String contact1_region_desc     = "",		country2_code_desc		    = "";
		String contact3_res_town_desc	= "",		contact3_region_desc        = "";
		String contact3_res_area__desc	= "",		country3_code_desc		    = "";
		String gender1					= "";
		String deceased_yn              = "";
		/*Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008*/
		String nk_mail_addr_line1="", nk_mail_addr_line2="";
		String nk_mail_addr_line3="", nk_mail_addr_line4="";
		String n_contact_ma_town_desc   = "", nkcontact1_res_town  = "";
		String n_contac_region_desc="", nkcontact1_region_code="";
		String n_contact_ma_area_desc="", nkcontact1_area_code="";
		String nkpostal1_code="", nkpostal1_desc="";
		String nk_mail_country_desc="", nkin_m_country_desc="", nk_mail_country_code="";
		String nk_res_contact_name="", nk_mail_contact_name="";
		String nk_contact3_mode="", nk_contact3_no="";
	        String nk_contact4_mode="", nk_contact4_no="";
	        String nk_contact5_mode="", nk_contact5_no=""; 

		String fton_mail_addr_line1="", fton_mail_addr_line2="";
		String fton_mail_addr_line3="", fton_mail_addr_line4="";
		String fst_to_no_ma_town_desc   = "", ftoncontact2_res_town  = "";
		String fst_to_no_ma_reg_desc="", ftoncontact2_region="";
		String fst_to_no_ma_area_desc="", ftoncontact2_res_area="", fton_mail_country_code="";
		String ftonpostal1_code="", ftonpostal1_desc="";
		String fton_res_contact_name="", fton_mail_contact_name="";
		String fton_mail_country_desc="", fton_m_country_desc="";
		String fton_resadd_contact_name="", fton_mailadd_contact_name="";
		String fton_contact3_mode="", fton_contact3_no="";
	        String fton_contact4_mode="", fton_contact4_no="";
	        String fton_contact5_mode="", fton_contact5_no=""; 
		/*Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008*/
        /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
         String color="";     
	  String red                      ="";
        String yellow                   ="";
        String green                    ="";
		String unassigned               ="";
		String sql                      ="";
		String gen_remark				="";
	
       /* CRF  SKR-CRF-0021 [IN028173] end  */
		
		String facilityId				= (String)session.getValue("facility_id");
		
		Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF GDOH-CRF-0129

	//	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

		String StartDate1			    = "";
		String AllowedDate			    = "";
		String bl_interface_yn		    = "";
		String sys_date					= "";
		String entitlement_by_cat_yn    = "";
		String patient_id				=   checkForNull(request.getParameter("Patient_ID"));
		//String last_encounter_id        = ""; 
		String bl_install_yn = (String)session.getValue("bl_operational"); 
		
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
		String five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
		
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
				
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String frameRef				= checkForNull(request.getParameter("frameRef"),"top.content");
		String invoke_from			= checkForNull(request.getParameter("invoke_from"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		String to_locn_type=null;
		String to_locn_code=null;
		String to_service_code=null;
		 if(bl_install_yn == null)
	     {
		   bl_install_yn=""; 
	     }
		String oper_stn_id			    = checkForNull(request.getParameter("oper_stn_id"));
		String patFlag =checkForNull(request.getParameter("patFlag"));
		String referal_id				= checkForNull(request.getParameter("referral_id"));
		String user_id 					= (String)session.getValue("login_user") ;
		StartDate1           = checkForNull(request.getParameter("StartDate1"));
		AllowedDate          = checkForNull(request.getParameter("AllowedDate"));
		bl_interface_yn      = checkForNull(request.getParameter("bl_interface_yn"));
		visit_back_yn		 = checkForNull(request.getParameter("visit_back_yn"));
		start_date			 = checkForNull(request.getParameter("start_date"));
        entitlement_by_cat_yn=checkForNull(request.getParameter("entitlement_by_cat_yn"));
		if(entitlement_by_cat_yn.equals("")) entitlement_by_cat_yn = "N";
        String HcExpired				= request.getParameter("HcExpired");
			  if (HcExpired==null) HcExpired = "N";
	    String ChgToVisitorGrp		 = request.getParameter("ChgToVisitorGrp");                        		  if(ChgToVisitorGrp==null)   ChgToVisitorGrp = "";
	
		//if(!AllowedDate.equals(""))
		//AllowedDate=AllowedDate.substring(0,16);

		//StartDate1=DateUtils.convertDate(StartDate1,"DMYHMS","en",locale);
		AllowedDate=DateUtils.convertDate(AllowedDate,"DMYHMS","en",locale);
		
		/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
		String invoke_recall	= checkForNull(request.getParameter("invoke_recall"));
		String enc_id			= checkForNull(request.getParameter("enc_id"));
		/*ML-MMOH-CRF-0657*/
	   
        // added on 8/25/2003 for billing interface
		//PreparedStatement pstmt2	 =	null;  
		String visit_charge_stage	 =	"";
		String record				 =	"N";
        float outst_amt				 =	0;       
		String outst_amt1			 =	"0";
		String episode = "Y";
		String org_type_data ="";
		
		double os_amt=0;//Added by Kamatchi S for ML-MMOH-CRF-1609
		String os_amt1="0";//Added by Kamatchi S for ML-MMOH-CRF-1609

		//Patient Contact Address

		String	 a_res_addr_line1	= "";
	    String a_res_addr_line2		= "";
	    String a_res_addr_line3		= "";
	    String a_res_addr_line4		= "";
	    String a_country_code		= "";
	    String a_postal_code		= "";
		String a_postal_code1	    = "";
	    String a_res_area			= "";
	    String a_res_area_code		= "";
	    String a_res_town2_code		= "";
	    String a_res_town2_desc		= "";
	    String a_res_region_code	= "";
	    String a_res_region_desc	= "";

	    String m_res_addr_line1		= "";
	    String m_res_addr_line2		= "";
	    String m_res_addr_line3		= "";
	    String m_res_addr_line4		= "";
	    String m_postal_code		= "";
		String m_postal_code1		= "";
		String m_country_code		= "";
		String m_res_area_code		= "";
		String m_res_area_desc		= "";
		String m_res_town2_code		= "";
		String m_res_town2_desc		= "";
		String m_res_region_code	= "";
		String m_res_region_desc	= "";
		String strPrimaryResNo		= "";
		String strOtherResNo		= "";
		String strEmail				= "";

		String country1_desc		= "";
		String country2_desc		= "";
		StringBuffer contactAddress=new StringBuffer();
		StringBuffer sqlRef = new StringBuffer();
		StringBuffer sqlAlt = new StringBuffer();
	    String nat_id_check_digit_id = "";
	    String nat_id_chk_len        = "";
		String nat_id_onKeyPress     = "";
		String postal1_desc			 = "";
		String postal2_desc          = "";
		String postal3_desc          = "";
		
		String sql1="";
		Boolean isPriorityZoneAppl			=	false;//Added By Shanmukh for MMS-DM-CRF-0147
		String patient_id_length	 = ""; // added by mujafar for ML-MMOH-CRF-0632

		String optSelected			 = "";//Added by Rameswar on 28-Nov-15 for GDOH-CRF-0004.1
		
		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
		String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
		String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
		String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
		boolean isAlternateAddressAppl = false;
		/*End*/
		
//Below line added for this CRF GDOH-CRF-0129
		String assigncare_location_code="",assigncare_location_desc="",assigncareloctype="";
		Boolean isReferral=false;
		Boolean isCurrentEncounter=false;
		ArrayList arrIPList=null;
		ArrayList arrOPList=null; 
		String referralforcurrentencounter="";
//End GDOH-CRF-0129

      /*Below line added for this CRF ML-MMOH-CRF-0629*/
	    Boolean isRegisterAttn=false;
	  /*End this CRF ML-MMOH-CRF-0629*/

		Boolean isCaseDtlsRadioBtnAppl	= false;//Added by Thamizh selvi on 20th Mar 2018 against ML-MMOH-CRF-645

		Boolean isMechInjLabelChngAppl	= false;//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649

		Boolean resiAddMailAdd = false;  //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		
		Boolean isAENextofKinchngAppl   = false; // Added by mujafar for ML-MMOH-CRF-0632
		
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		Boolean isReconfirmCOTAppl = false;
		String reconf_cot_param = "";
		
		/*Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start*/
		Boolean isAutoPopulateNOKDOBAppl = false;
		String natInvokeRoutine = "";
		String natDataSourceId = "";
		/*End*/
		/* Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023 */
		Boolean isMLCAppl = false;

	/*
		String p_facility_id = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");

		String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		String p_episode_type = request.getParameter("p_episode_type")==null?"":request.getParameter("p_episode_type");
	*/

 try{
        con = ConnectionManager.getConnection(request);
        //Added for ML-MMOH-CRF-1802
		if(!patient_id.equals("")){
		try{
			pstmt   = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id='"+patient_id+"'");
	    		rset    = pstmt.executeQuery();
			if(rset!=null && rset.next())
				{
	    				gen_remark = checkForNull(rset.getString("patient_remarks"));
				}
	    		if(pstmt != null) pstmt.close();
	    		if(rset != null) rset.close();
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		}
		Boolean isForm60Available	= CommonBean.isSiteSpecific(con, "MP","REG_PAT_ALT_ID3_PAN_CARD");//Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799]

		Boolean validationForPanCardAvail	= CommonBean.isSiteSpecific(con, "MP","GENERATE_FORM_60"); //Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347

	/*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
	isPriorityZoneAppl			= CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
	Boolean isPracApplicable	= CommonBean.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE"); 
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	
	Boolean isLabelChngAppl = CommonBean.isSiteSpecific(con, "AE","LABEL_CHG_BR_DEAD_PLACE_ACCDNT"); //Added by Ashwini on 18-Jan-2017 for GDOH-CRF-0131 and GDOH-CRF-0123
	
	boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF"); //Added by Mano on 26-Apr-2017
	
	Boolean isPlaceOfOccuurrence = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","PLACE_OF_OCCURRENCE"); // Added by mujafar for ML-MMOH-CRF-0647

	isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

	isCaseDtlsRadioBtnAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","SEC_TRIAGE_CASE_DETAILS");//Added by Thamizh selvi on 20th Mar 2018 against ML-MMOH-CRF-645

	isMechInjLabelChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","RENAME_MECH_INJ_SUB_INJ");//Added by Thamizh selvi on 29th Mar 2018 against ML-MMOH-CRF-649
	
	isAENextofKinchngAppl  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_NEXT_OF_KIN_CHNG_APPL"); // Added by mujafar for ML-MMOH-CRF-0632

	isAutoPopulateNOKDOBAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","AUTO_POPULATE_NOK_DOB");//Added by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177

	resiAddMailAdd   	=eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	isMLCAppl 			=eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "MLC_DTLS");//Added by Ajay Hatwate for GHL-CRF-0650
	
	//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
	isReconfirmCOTAppl		= CommonBean.isSiteSpecific(con, "AE", "RECONFIRM_CASE_OF_TRAUMA");
	JSONObject aeParamJson	= new JSONObject();
	aeParamJson				= eAE.AECommonBean.getAEParam(con, facilityId);
	reconf_cot_param		= (String)aeParamJson.get("reconfirm_case_of_trauma");	
	
	//Added for this CRF ML-MMOH-CRF-0860.2	
	String maximumLength="30";
	String maxsize="30";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength){
	maximumLength="50";	
	//maxsize="58";
	maxsize="64";
	}
	//End ML-MMOH-CRF-0860.2

	/*Below line added for this CRF ML-MMOH-CRF-0629*/
	  isRegisterAttn=CommonBean.isSiteSpecific(con, "AE","REGISTER_ATTENDANCE");	  
		String priorityRed="";
		 if(isRegisterAttn){
			priorityRed="priorityZoneRed();";
		 }	
	//End this CRF ML-MMOH-CRF-0629
	
	//Below line added for this GDOH-CRF-0129
  isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");  
	 if(isReferral){
		arrIPList=(ArrayList)ReferralCurrentEncounterDetails.getIPCurrentEncounterDetails(con,patient_id,facilityId,p);
			 for(int ip=0; ip<arrIPList.size(); ip++){
					ReferralCurrentEncounterDetailsBean ipEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrIPList.get(ip); 
					assigncare_location_code=ipEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=ipEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=ipEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
					
			 }
	 if(arrIPList.size()==0){
		arrOPList=(ArrayList)ReferralCurrentEncounterDetails.getOPCurrentEncounterDetails(con,patient_id,facilityId,p);
			 for(int op=0; op<arrOPList.size(); op++){
					ReferralCurrentEncounterDetailsBean opEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrOPList.get(op); 
					assigncare_location_code=opEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=opEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=opEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
			}
		  }
	 }
 //End GDOH-CRF-0129
	

	String enablePrac="";
	if(isPracApplicable){
	enablePrac="enablePrac();";
	} /*Added by Rameswar on 08-Feb-16 for GDOH-CRF-081*/
		try{



		contact_addr = fetchContactAddresses(con, out, "parent.parent.messageFrame",propertiesBill) ;
		/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
			     color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")){unassigned=rset.getString("PRIORITY_ZONE_DESC");}
				}
			/* CRF  SKR-CRF-0021 [IN028173] end  */
		    }catch(Exception e){e.printStackTrace();}
		contact_col_names = (String[])contact_addr.get(1) ;
		contact_prompts   = (String[])contact_addr.get(2) ; 
		contact_fields    = (String[])contact_addr.get(3) ;
		contact_addr = null;

	 int reccnt = 0;
	/* if (bl_install_yn.equals("Y"))
      {	
			  if(!patient_id.equals(""))
              {
				  StringBuffer sqlBLFin = new StringBuffer();
                  sqlBLFin.append("select nvl(tot_def_pat_outst_amt,0) from ");
				  sqlBLFin.append(" bl_patient_fin_dtls where patient_id= ?  ");
				  pstmt2  = con.prepareStatement(sqlBLFin.toString());
                  pstmt2.setString(1,patient_id);
                  rs = pstmt2.executeQuery();     
                  if (rs!=null) 
                  {
                    while (rs.next())
                    {
                        //reccnt = 1;
//                        record="Y";		
                        outst_amt = rs.getFloat(1);
                    }
                  }
				  if (rs != null)   rs.close();
				  if (pstmt2 != null) pstmt2.close();

				  if((sqlBLFin != null) && (sqlBLFin.length() > 0))
				   {
					 sqlBLFin.delete(0,sqlBLFin.length());
				   }
				   reccnt = 1;
			       record="Y";
              }
			 // if (pstmt2 != null) pstmt2.close();
             // if (rs != null)   rs.close();
	    }*/

     if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y"))
      {
    /*       //calculate outstanding amount if outstanding amount > 0 then display at the end of patient line(blinking)          
  	       CallableStatement cstmt =null;
             try 
             {    
 				// MOD#02 The following statements were commented and the new code is 
 				// introduced between line 457 and line 471   AND IN 483
 				BLFunctionalValidation blFunction  = new BLFunctionalValidation();
 				Hashtable blData = new Hashtable();
 				blData.put("patient",patient_id);
 				blData.put("facilityid",facilityId);
 				blData.put("bl_install_yn",bl_install_yn);
 				blData.put("bl_interface_yn",bl_interface_yn);
 
 				Hashtable blResult = blFunction.billPatientService(propertiesBill,con,blData); 
 				if (blResult != null)
 	                outst_amt = ((Float)blResult.get("outst_amt")).floatValue();
 				else
 					outst_amt =0;
 				blFunction = null;

			   reccnt = 1;
			   record="Y";

				if (cstmt != null) cstmt.close();
			}
            catch (Exception e)
            {
               	outst_amt = 0;
               // out.println("Error in calling procedure BL_CALCULATE_OUTST_AMT "+e);
				e.printStackTrace();
            }
	      // End of Billing
          outst_amt1 = ""+outst_amt;
          CurrencyFormat cf1 = new CurrencyFormat();
          outst_amt1 = cf1.formatCurrency(outst_amt1, 2);

		    sql="select BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityId+"', '"+patient_id+"','E') from dual";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()) {
				auth_win_reqd_yn = rs.getString(1);
			}
            } */

		CallableStatement call = con.prepareCall("{ ? = call  BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityId+"', '"+patient_id+"','E',?)}");

		call.registerOutParameter(1, java.sql.Types.VARCHAR);
		call.registerOutParameter(2, java.sql.Types.VARCHAR); 
				
		call.execute(); 
			
		auth_win_reqd_yn = call.getString(1);
		outst_amt1 = call.getString(2);			

		//Added by Kamatchi S for ML-MMOH-CRF-1609
		os_amt = call.getDouble(2);
		os_amt1 = ""+os_amt;
 
		CurrencyFormat cf1 = new CurrencyFormat();
		outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
		os_amt1 = cf1.formatCurrency(os_amt1, 2);//Added by Kamatchi S for ML-MMOH-CRF-1609
		reccnt = 1;
		record="Y";	

		if(call!=null)
		call.close();
     //   out.println("<script>alert('"+auth_win_reqd_yn+"');</script>");
     //   out.println("<script> alert("+outst_amt1+");</script>");
   }
      
     // End of billing  
	 /* Wednesday, May 05, 2010 venkat s 
	StringBuffer displLastVisit = new StringBuffer();
	displLastVisit.append(" SELECT ENCOUNTER_ID from OP_PATIENT_QUEUE where  ");
	displLastVisit.append(" QUEUE_DATE = (SELECT max(QUEUE_DATE) ");
	displLastVisit.append(" from OP_PATIENT_QUEUE where PATIENT_ID = ? and   ");
	displLastVisit.append(" QUEUE_STATUS !='99'  and FACILITY_ID = ? and ");
	displLastVisit.append(" PATIENT_CLASS = 'EM') ");
	displLastVisit.append(" and PATIENT_ID = ? and  QUEUE_STATUS !='99' ");
	displLastVisit.append(" and FACILITY_ID = ? and patient_class='EM'");
    try{
		   pstmt = con.prepareStatement(displLastVisit.toString());
		   pstmt.setString(1,patient_id);
		   pstmt.setString(2,facilityId);
		   pstmt.setString(3,patient_id);
		   pstmt.setString(4,facilityId);
		   rset = pstmt.executeQuery();
		   while(rset!=null && rset.next())
		   {
				last_encounter_id = rset.getString(1);
		   }
		   if(rset!=null) rset.close();
		   if(pstmt!=null) pstmt.close();
		   if((displLastVisit != null) && (displLastVisit.length() > 0))
		   {
				displLastVisit.delete(0,displLastVisit.length());
		   }
	 }catch(Exception e)
     {
        //out.println("Exception in CAInstall ="+e);
					e.printStackTrace();
     }

	 */
	try{ 
				 
    // Arrival Tab 
	 //added changes  HSA-CRF-0226 [IN:050599]
      String mp_sql="select upt_contact_dtls_oa_yn,patient_id_length  from MP_PARAM where  MODULE_ID='MP' "; // modified by mujafar for ML-MMOH-CRF-0632
      pstmt = con.prepareStatement(mp_sql);
	 rset=pstmt.executeQuery();
	 String upt_contact_dtls_oa_yn="";
	 if(rset != null && rset.next()){
     upt_contact_dtls_oa_yn=rset.getString("upt_contact_dtls_oa_yn");
	 patient_id_length = rset.getString("patient_id_length"); // added by mujafar for ML-MMOH-CRF-0632
	}  
	if(rset != null) rset.close();
    if(pstmt!=null)pstmt.close();
 //end changes for HSA-CRF-0226 [IN:050599]

    String sqlRelation =  "select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and EFF_STATUS='E'  order by SHORT_DESC ";	
	
	pstmt_race = con.prepareStatement(sqlRelation);
	rset_race  = pstmt_race.executeQuery();
	
	while (rset_race != null && rset_race.next()) {		
		race_array.add(checkForNull(rset_race.getString("RELATIONSHIP_CODE")));
		race_array.add(checkForNull(rset_race.getString("SHORT_DESC")));			
	}	
	
	if(rset_race != null) rset_race.close();
	if(pstmt_race != null) pstmt_race.close();

	StringBuffer episodeDisp = new StringBuffer();
	episodeDisp.append(" select BUILD_EPISODE_RULE ");
	episodeDisp.append(" from OP_PARAM ");
	episodeDisp.append(" where operating_facility_id= ?  ");

    StringBuffer nationalDisp = new StringBuffer();
	nationalDisp.append("select  a.NATIONAL_ID_NO, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.ALT_ID1_TYPE,'"+locale+"','1') ALT_ID1_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.ALT_ID2_TYPE,'"+locale+"','1') ALT_ID2_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.ALT_ID3_TYPE,'"+locale+"','1') ALT_ID3_DESC,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(b.ALT_ID4_TYPE,'"+locale+"','1') ALT_ID4_DESC, a.NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(a.NATIONALITY_CODE,'"+locale+"','3') short_desc, a.ALT_ID1_NO,a.ALT_ID2_NO,a.ALT_ID3_NO,a.ALT_ID4_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(a.OTH_ALT_ID_TYPE,'"+locale+"','1') OTH_ALT_ID_DESC, a.OTH_ALT_ID_NO, a.SEX, floor((sysdate-date_of_birth)/365) patient_age, to_char(REGN_DATE,'dd/mm/yyyy hh24:mi') regn_date, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') date_of_birth,  A.CITIZEN_YN RESIDENCY, A.LEGAL_YN  LEGAL_STATUS,  b.ALT_ID1_TYPE,  b.NAT_ID_PROMPT,b.ACCEPT_NATIONAL_ID_NO_YN, b.nat_id_accept_alphanumeric_yn, b.NAT_ID_LENGTH, b.ACCEPT_OTH_ALT_ID_YN , a.DECEASED_YN, C.BLOOD_GRP, MR_GET_DESC.MR_BLOOD_GRP(C.BLOOD_GRP,'"+locale+"','2') BLOOD_GRP_DESC, C.RH_FACTOR RHESUS_FACTOR_CODE,MR_GET_DESC.MR_RHESUS_FACTOR(C.RH_FACTOR,'"+locale+"','2') rh_factor_desc,  D.contact1_name, D.contact1_relation, D.contact1_nat_id_no, to_char(D.contact1_birth_date,'dd/mm/rrrr')  contact1_birth_date, D.job1_title, D.addr1_line1, D.addr1_line2,  D.addr1_line3, D.addr1_line4, D.contact1_res_town_code, MP_GET_DESC.MP_RES_TOWN(D.contact1_res_town_code,'"+locale+"','1') contact1_res_town_desc,  D.contact1_res_area_code, MP_GET_DESC.MP_RES_AREA(D.contact1_res_area_code,'"+locale+"','1') contact1_res_area__desc,  D.contact1_region_code, MP_GET_DESC.MP_REGION(D.contact1_region_code,'"+locale+"','1')  contact1_region_desc, D.postal1_code,MP_GET_DESC.MP_POSTAL_CODE(D.postal1_code,'"+locale+"','2') postal1_desc, D.country1_code, MP_GET_DESC.MP_COUNTRY(D.country1_code,'"+locale+"','1') country1_code_desc, D.res1_tel_no,  D.contact1_mob_tel_no, D.off1_tel_no, D.contact1_email_id,  D.contact2_name, D.contact2_relation, D.contact2_nat_id_no,  D.job2_title, D.contact2_res_town_code, MP_GET_DESC.MP_RES_TOWN(D.contact2_res_town_code,'"+locale+"','1') contact2_res_town_desc, D.res2_tel_no,  D.contact2_mob_tel_no,  D.off2_tel_no, D.contact2_email_id, D.addr2_line1, D.addr2_line2,  D.addr2_line3, D.addr2_line4, D.contact2_res_area_code,  MP_GET_DESC.MP_RES_AREA(D.contact2_res_area_code,'"+locale+"','1') contact2_res_area__desc,  D.contact2_region_code, MP_GET_DESC.MP_REGION(D.contact2_region_code,'"+locale+"','1') contact2_region_desc, D.postal2_code,MP_GET_DESC.MP_POSTAL_CODE(D.postal2_code,'"+locale+"','2') postal2_desc, D.country2_code, MP_GET_DESC.MP_COUNTRY(D.country2_code,'"+locale+"','1') country2_code_desc, D.organization_name,  D.contact3_name, D.addr3_line1, D.addr3_line2, D.addr3_line3,  D.addr3_line4, D.contact3_res_town_code, MP_GET_DESC.MP_RES_TOWN(D.contact3_res_town_code,'"+locale+"','1') contact3_res_town_desc,  D.contact3_res_area_code, MP_GET_DESC.MP_RES_AREA(D.contact3_res_area_code,'"+locale+"','1') contact3_res_area__desc,  D.contact3_region_code, MP_GET_DESC.MP_REGION(D.contact3_region_code,'"+locale+"','1') contact3_region_desc, D.postal3_code,MP_GET_DESC.MP_POSTAL_CODE(D.postal3_code,'"+locale+"','2') postal3_desc, D.country3_code, MP_GET_DESC.MP_COUNTRY(D.country3_code,'"+locale+"','1') country3_code_desc, D.res3_tel_no,  D.off3_tel_no, D.patient_employee_id, D.ocpn_class_code,  D.ocpn_code, D.ocpn_desc, D.employment_status,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys, to_char(sysdate,'dd/mm/yyyy') sys1,b.nat_id_check_digit_id,b.nat_id_chk_len,b.invoke_routine,b.nat_data_source_id, D.nk_mail_addr_line1, D.nk_mail_addr_line2,  D.nk_mail_addr_line3, D.nk_mail_addr_line4, D.nk_mail_town_code, MP_GET_DESC.MP_RES_TOWN(D.nk_mail_town_code,'"+locale+"','1') n_contact_ma_town_desc, D.nk_mail_region_code, MP_GET_DESC.MP_REGION(D.nk_mail_region_code,'"+locale+"','1')  n_contac_region_desc, D.nk_mail_area_code, MP_GET_DESC.MP_RES_AREA(D.nk_mail_area_code,'"+locale+"','1') n_contact_ma_area_desc, D.nk_mail_postal_code,MP_GET_DESC.MP_POSTAL_CODE(D.nk_mail_postal_code,'"+locale+"','2') nkpostal1_desc, D.nk_mail_country_code, MP_GET_DESC.MP_COUNTRY(D.nk_mail_country_code,'"+locale+"','1') nk_mail_country_desc, D.nk_res_contact_name, D.nk_mail_contact_name,D.nk_contact3_mode nk_contact3_mode, (CASE WHEN D.nk_contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.nk_contact3_mode,'"+locale+"',2)) END ) nk_contact3_mode_desc, D.nk_contact3_no nk_contact3_no, D.nk_contact4_mode nk_contact4_mode, (CASE WHEN D.nk_contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.nk_contact4_mode,'"+locale+"',2)) END ) nk_contact4_mode_desc, D.nk_contact4_no nk_contact4_no, D.nk_contact5_mode nk_contact5_mode, (CASE WHEN D.nk_contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.nk_contact5_mode,'"+locale+"',2)) END ) nk_contact5_mode_desc, D.nk_contact5_no nk_contact5_no,D.fton_mail_addr_line1, D.fton_mail_addr_line2,  D.fton_mail_addr_line3, D.fton_mail_addr_line4, D.fton_mail_town_code, MP_GET_DESC.MP_RES_TOWN(D.fton_mail_town_code,'"+locale+"','1') fst_to_no_ma_town_desc, D.fton_mail_region_code, MP_GET_DESC.MP_REGION(D.fton_mail_region_code ,'"+locale+"','1')  fst_to_no_ma_reg_desc, D.fton_mail_area_code, MP_GET_DESC.MP_RES_AREA(D.fton_mail_area_code,'"+locale+"','1') fst_to_no_ma_area_desc, D.fton_mail_postal_code,MP_GET_DESC.MP_POSTAL_CODE(D.fton_mail_postal_code,'"+locale+"','2') ftonpostal1_desc, D.fton_mail_country_code, MP_GET_DESC.MP_COUNTRY(D.fton_mail_country_code,'"+locale+"','1') fton_mail_country_desc, D.fton_res_contact_name, D.fton_mail_contact_name,D.fton_contact3_mode fton_contact3_mode, (CASE WHEN D.fton_contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.fton_contact3_mode,'"+locale+"',2)) END ) fton_contact3_mode_desc, D.fton_contact3_no fton_contact3_no, D.fton_contact4_mode fton_contact4_mode, (CASE WHEN D.fton_contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.fton_contact4_mode,'"+locale+"',2)) END ) fton_contact4_mode_desc, D.fton_contact4_no fton_contact4_no, D.fton_contact5_mode fton_contact5_mode, (CASE WHEN D.fton_contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(D.fton_contact5_mode,'"+locale+"',2)) END ) fton_contact5_mode_desc, D.fton_contact5_no fton_contact5_no from MP_PATIENT A, MP_PARAM_LANG_VW B,  MP_PAT_OTH_DTLS C, MP_PAT_REL_CONTACTS D  where  B.module_id='MP' AND B.language_id = '"+locale+"' and A.patient_id = C.patient_id  and A.patient_id =D.patient_id and A.patient_id=?  ");//Modified by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177
     //Query modified by Suji keerthi for ML-MMOH-CRF-1527 US008
    StringBuffer  displaycontactdet =new StringBuffer();

	if(!referal_id.equals(""))
		{
			displaycontactdet.append("SELECT TO_LOCN_TYPE,TO_LOCN_CODE,TO_SERVICE_CODE,addr_line1 addr1_line1,addr_line2  addr1_line2,addr_line3 addr1_line3,addr_line4 addr1_line4,res_town_code, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') res_town,res_area_code, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1') res_area, region_code,MP_GET_DESC.MP_REGION(region_code,'"+locale+"','1') region,   country_code country1_code, MP_GET_DESC.MP_COUNTRY(country_code,'"+locale+"','1') country1_desc,nvl(postal_code,'')  postal1_code,MP_GET_DESC.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postal1_desc,mail_addr_line1 addr2_line1,  mail_addr_line2 addr2_line2,  mail_addr_line3 addr2_line3,  mail_addr_line4 addr2_line4,  mail_res_town_code res_town2_code, MP_GET_DESC.MP_RES_TOWN(mail_res_town_code,'"+locale+"','1') res_town2,  mail_res_area_code res_area2_code, MP_GET_DESC.MP_RES_AREA(mail_res_area_code,'"+locale+"','1') res_area2,mail_region_code region2_code, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') region2_desc, mail_country_code country2_code, MP_GET_DESC.MP_COUNTRY(mail_country_code,'"+locale+"','1') country2_desc, mail_postal_code postal2_code,MP_GET_DESC.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2') postal2_desc,contact1_no,  contact2_no,email_id, alt_addr_line1, alt_addr_line2,  alt_addr_line3,  alt_addr_line4, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc,  alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc, alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(alt_postal_code,'"+locale+"','2') alt_postal_desc FROM pr_referral_register WHERE  referral_id = '"+referal_id+"'");//Modified by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601
		}
		else
		{
			displaycontactdet.append("SELECT a.addr1_type,a.addr1_line1,a.addr1_line2, a.addr1_line3,addr1_line4, nvl(a.postal1_code,'') postal1_code,MP_GET_DESC.MP_POSTAL_CODE(a.postal1_code,'"+locale+"','2') postal1_desc, a.country1_code, MP_GET_DESC.MP_COUNTRY(a.country1_code,'"+locale+"','1') country1_desc, a.contact1_name, a.invalid1_yn, MP_GET_DESC.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"','1') res_area,  b.res_area_code ,MP_GET_DESC.MP_RES_TOWN(b.RES_TOWN_CODE,'"+locale+"','1') res_town, b.res_town_code , MP_GET_DESC.MP_REGION(b.region_code,'"+locale+"','1') region, b.region_code, a.addr2_type, a.addr2_line1, a.addr2_line2, a.addr2_line3, a.addr2_line4, a.postal2_code, MP_GET_DESC.MP_POSTAL_CODE(a.postal2_code,'"+locale+"','2') postal2_desc, a.country2_code, MP_GET_DESC.MP_COUNTRY(a.country2_code,'"+locale+"','1') country2_desc, a.contact2_name, a.invalid2_yn, MP_GET_DESC.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2, a.res_area2_code, MP_GET_DESC.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2, a.res_town2_code, MP_GET_DESC.MP_REGION(region2_code,'"+locale+"','1') region2_desc,  a.region2_code, b.CONTACT1_NO, b.CONTACT2_NO,  b.EMAIL_ID, a.alt_addr_line1, a.alt_addr_line2,  a.alt_addr_line3,  a.alt_addr_line4, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc,  a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc, a.alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"','2') alt_postal_desc FROM mp_pat_addresses a , MP_PATIENT b WHERE b.PATIENT_ID=a.PATIENT_ID  and  b.patient_id='"+patient_id+"'");//Modified by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601
		}
		pstmt    = con.prepareStatement(displaycontactdet.toString()) ;
		rset = pstmt.executeQuery() ;
		if(rset != null && rset.next())
		{
			if(!referal_id.equals("")){
			to_locn_type=checkForNull(rset.getString("TO_LOCN_TYPE"));
			to_locn_code=checkForNull(rset.getString("TO_LOCN_CODE"));
			to_service_code=checkForNull(rset.getString("TO_SERVICE_CODE"));
			}
			a_res_addr_line1  = checkForNull(rset.getString("addr1_line1"));
			a_res_addr_line2  = checkForNull(rset.getString("addr1_line2"));
			a_res_addr_line3  = checkForNull(rset.getString("addr1_line3"));
			a_res_addr_line4  = checkForNull(rset.getString("addr1_line4") );
			a_country_code    = checkForNull(rset.getString("country1_code"));
			a_postal_code     = checkForNull(rset.getString("postal1_code"));
			a_postal_code1    = checkForNull(rset.getString("postal1_desc"));
			a_res_area_code   = checkForNull(rset.getString("res_area_code"));
			a_res_area        = checkForNull(rset.getString("res_area") );			
		    a_res_town2_code  = checkForNull(rset.getString("res_town_code"));
		    a_res_town2_desc  = checkForNull(rset.getString("res_town"));
		    a_res_region_code = checkForNull(rset.getString("region_code"));
			a_res_region_desc = checkForNull(rset.getString("region"));			
			m_res_addr_line1  = checkForNull(rset.getString("addr2_line1"));
			m_res_addr_line2  = checkForNull(rset.getString("addr2_line2"));
			m_res_addr_line3  = checkForNull(rset.getString("addr2_line3"));
			m_res_addr_line4  = checkForNull(rset.getString("addr2_line4"));
			m_postal_code     = checkForNull(rset.getString("postal2_code"));
			m_postal_code1     = checkForNull(rset.getString("postal2_desc"));
			m_country_code    = checkForNull(rset.getString("country2_code"));
			m_res_area_code   = checkForNull(rset.getString("res_area2_code"));
			m_res_area_desc   = checkForNull(rset.getString("res_area2"));
		    m_res_town2_code  = checkForNull(rset.getString("res_town2_code"));
		    m_res_town2_desc  = checkForNull(rset.getString("res_town2"));
		    m_res_region_code = checkForNull(rset.getString("region2_code"));
		    m_res_region_desc = checkForNull(rset.getString("region2_desc"));
		    strPrimaryResNo   = checkForNull(rset.getString("CONTACT1_NO"));
			strOtherResNo     = checkForNull(rset.getString("CONTACT2_NO"));
			strEmail	      = checkForNull(rset.getString("EMAIL_ID"));	
			country1_desc	  = checkForNull(rset.getString("country1_desc"));	
			country2_desc	  = checkForNull(rset.getString("country2_desc"));
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1 = checkForNull(rset.getString("alt_addr_line1"));
			alt_addr_line2 = checkForNull(rset.getString("ALT_ADDR_LINE2"));
			alt_addr_line3 = checkForNull(rset.getString("ALT_ADDR_LINE3"));
			alt_addr_line4 = checkForNull(rset.getString("ALT_ADDR_LINE4"));
			alt_country_code  = checkForNull(rset.getString("ALT_COUNTRY_CODE"));
			alt_country_desc  = checkForNull(rset.getString("ALT_COUNTRY_DESC"));
			alt_postal_code    = checkForNull(rset.getString("ALT_POSTAL_CODE"));
			alt_postal_desc    = checkForNull(rset.getString("ALT_POSTAL_DESC"));
			alt_area_code = checkForNull(rset.getString("ALT_AREA_CODE"));
			alt_area_desc = checkForNull(rset.getString("ALT_AREA_DESC"));			
			alt_town_code = checkForNull(rset.getString("ALT_TOWN_CODE"));
			alt_town_desc = checkForNull(rset.getString("ALT_TOWN_DESC"));
			alt_region_code = checkForNull(rset.getString("ALT_REGION_CODE"));
			alt_region_desc = checkForNull(rset.getString("ALT_REGION_DESC"));
			/*End*/

		contactAddress.append(""+"^^");
		contactAddress.append(a_res_addr_line1+"^^");
		contactAddress.append(a_res_addr_line2+"^^");
		contactAddress.append(a_res_addr_line3+"^^");
		contactAddress.append(a_res_addr_line4+"^^");
		contactAddress.append(a_res_town2_code+"^^");
		contactAddress.append(a_res_area_code+"^^");
		contactAddress.append(a_postal_code+"^^");
		contactAddress.append(a_res_region_code+"^^");
		contactAddress.append(a_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(m_res_addr_line1+"^^");
		contactAddress.append(m_res_addr_line2+"^^");
		contactAddress.append(m_res_addr_line3+"^^");
		contactAddress.append(m_res_addr_line4+"^^");
		contactAddress.append(m_res_town2_code+"^^");
		contactAddress.append(m_res_area_code+"^^");
		contactAddress.append(m_postal_code+"^^");
		contactAddress.append(m_res_region_code+"^^");
		contactAddress.append(m_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(strPrimaryResNo+"^^");
		contactAddress.append(strOtherResNo+"^^");
		contactAddress.append(strEmail+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_town2_desc+"^^");
		contactAddress.append(a_res_area+"^^");
		contactAddress.append(a_res_region_desc+"^^");
		contactAddress.append(m_res_town2_desc+"^^");
		contactAddress.append(m_res_area_desc+"^^");
		contactAddress.append(m_res_region_desc+"^^");
		contactAddress.append(country1_desc+"^^");
		contactAddress.append(country2_desc+"^^");
		contactAddress.append(a_postal_code1+"^^");
		contactAddress.append(m_postal_code1);
		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		contactAddress.append(""+"^^");
		contactAddress.append(alt_addr_line1+"^^");
		contactAddress.append(alt_addr_line2+"^^");
		contactAddress.append(alt_addr_line3+"^^");
		contactAddress.append(alt_addr_line4+"^^");
		contactAddress.append(alt_town_code+"^^");
		contactAddress.append(alt_area_code+"^^");
		contactAddress.append(alt_postal_code+"^^");
		contactAddress.append(alt_region_code+"^^");
		contactAddress.append(alt_country_code+"^^");
		contactAddress.append(alt_town_desc+"^^");
		contactAddress.append(alt_area_desc+"^^");
		contactAddress.append(alt_postal_desc+"^^");
		contactAddress.append(alt_region_desc+"^^");
		contactAddress.append(alt_country_desc+"^^");
		/*End*/
		}
		if(rset != null) rset.close(); 
		if(pstmt != null) pstmt.close();
		if((displaycontactdet != null) && (displaycontactdet.length() > 0))
		{
			displaycontactdet.delete(0,displaycontactdet.length());
		}

			// Add Visit
	StringBuffer sqlLocation = new StringBuffer();
// sqlLocation.append("select a.CLINIC_CODE, a.long_desc SHORT_DESC, a.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') SERVICE_DESC, a.CLINIC_TYPE, a.OPEN_TO_ALL_PRACT_YN, c.gender, a.SPECIALITY_CODE from OP_CLINIC_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b, am_age_group c where decode(b.day_no, '1', working_day_1, '2', working_day_2, '3', working_day_3, '4',  working_day_4, '5', working_day_5, '6', working_day_6, '7',working_day_7)='Y' and a.facility_id = ? and language_id = '"+locale+"' and a.clinic_type = 'C' and a.level_of_care_ind = 'E' and a.eff_status = 'E' and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from am_os_user_locn_access_vw where facility_id = ? and Oper_stn_id = ? and  appl_user_id = ?  and register_visit_yn = 'Y') and a.age_group_code = c.age_group_code(+) and ? between nvl(c.min_age,?) and nvl(c.max_age,?) order by 2 ");
// Modified query 14.10.09

	sqlLocation.append("select a.CLINIC_CODE, a.long_desc SHORT_DESC, a.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') SERVICE_DESC, a.CLINIC_TYPE, a.OPEN_TO_ALL_PRACT_YN, c.gender, a.SPECIALITY_CODE from OP_CLINIC_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b, am_age_group c where decode(b.day_no, '1', working_day_1, '2', working_day_2, '3', working_day_3, '4',  working_day_4, '5', working_day_5, '6', working_day_6, '7',working_day_7)='Y' and a.facility_id = ? and language_id = '"+locale+"' and a.clinic_type = 'C' and a.level_of_care_ind = 'E' and a.clinic_code like '%' and a.eff_status = 'E' and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from am_os_user_locn_access_vw where facility_id = ? and Oper_stn_id = ? and locn_type = 'C' and  appl_user_id = ?  and register_visit_yn = 'Y') and a.age_group_code = c.age_group_code(+) and ? between nvl(c.min_age,?) and nvl(c.max_age,?) order by 2 ");

//	"SELECT   a.clinic_code, a.long_desc short_desc, a.service_code, am_get_desc.am_service (a.service_code,'en','2') service_desc, a.clinic_type, a.open_to_all_pract_yn, c.gender, a.speciality_code    FROM op_clinic_lang_vw a, (SELECT day_no FROM sm_day_of_week WHERE day_of_week = RTRIM (TO_CHAR (SYSDATE, 'DAY'))) b, am_age_group c WHERE DECODE (b.day_no, '1', working_day_1, '2', working_day_2, '3', working_day_3, '4', working_day_4, '5', working_day_5, '6', working_day_6, '7', working_day_7 ) = 'Y' AND a.facility_id = 'HS'     AND a.language_id = 'en'     AND a.clinic_type = 'C'     AND a.level_of_care_ind = 'E' ****  AND a.clinic_code like '%' **** AND a.eff_status = 'E'     AND (a.clinic_type, a.clinic_code) IN ( SELECT locn_type, locn_code FROM am_os_user_locn_access_vw WHERE facility_id = 'HS' AND oper_stn_id = 'ALL' **** AND locn_type = 'C' **** AND appl_user_id = 'NAREN' AND register_visit_yn = 'Y')     AND a.age_group_code = c.age_group_code(+)     AND 10 BETWEEN NVL (c.min_age, 9) AND NVL (c.max_age, 150)ORDER BY 2"

	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(!referal_id.equals("")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		   sqlRef.append("select get_referral_detail_line( ?,'FROM',?) from dual "); 
           pstmt  = con.prepareStatement(sqlRef.toString());
		   pstmt.setString(1,referal_id );
		   pstmt.setString(2,locale );

           rset = pstmt.executeQuery() ;
           rset.next() ;
          
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( (rset.getString(1).substring(2))));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(rset!=null) rset.close();    
		if(pstmt!=null) pstmt.close();}
		if((sqlRef != null) && (sqlRef.length() > 0))
		{
			sqlRef.delete(0,sqlRef.length());
		}		

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

					   // To get the Patient Sex, Nationality, Expiry Date,Alternate Id,blood grp,rhfactor, Address, etc.
				
					   pstmt = con.prepareStatement(nationalDisp.toString());
					   pstmt.setString(1,patient_id);
					   rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
						  nationality_id = checkForNull(rset.getString("NATIONAL_ID_NO"));
						  nationality	 = checkForNull(rset.getString("short_desc"));
						  alt_id1_no= checkForNull(rset.getString("ALT_ID1_NO")); 
						  alt_id1_desc   = checkForNull(rset.getString("ALT_ID1_DESC"));
						  //added for PMG2014-HSA-CRF-0001 [IN:050020]
						  alt_id2_no     = checkForNull(rset.getString("ALT_ID2_NO")); 
						  alt_id2_desc   = checkForNull(rset.getString("ALT_ID2_DESC"));
						  alt_id3_no= checkForNull(rset.getString("ALT_ID3_NO")); 
						  alt_id3_desc   = checkForNull(rset.getString("ALT_ID3_DESC"));
						  alt_id4_no= checkForNull(rset.getString("ALT_ID4_NO")); 
						  alt_id4_desc   = checkForNull(rset.getString("ALT_ID4_DESC"));
						  sex			 = checkForNull(rset.getString("SEX"));
						  oth_alt_id_desc= checkForNull(rset.getString("OTH_ALT_ID_DESC"));
                          oth_alt_id_no	 = checkForNull(rset.getString("OTH_ALT_ID_NO"));
						  residency		 = checkForNull(rset.getString("RESIDENCY"));
						  legal_status	 = checkForNull(rset.getString("LEGAL_STATUS"));
						  patient_age	 = rset.getInt("patient_age");
						  regn_date      = checkForNull(rset.getString("regn_date"));
						  date_of_birth  = checkForNull(rset.getString("date_of_birth"));
						  deceased_yn    = checkForNull(rset.getString("DECEASED_YN"));
						  nat_id_prompt = checkForNull(rset.getString("NAT_ID_PROMPT"));
						  accept_national_id_no_yn = checkForNull(rset.getString("ACCEPT_NATIONAL_ID_NO_YN"));
						  nat_id_accept_alphanumeric_yn = checkForNull(rset.getString("nat_id_accept_alphanumeric_yn"));
                          nat_id_length = checkForNull(rset.getString("NAT_ID_LENGTH"));
						  accept_oth_alt_id_yn = checkForNull(rset.getString("ACCEPT_OTH_ALT_ID_YN"));
						  //alt_id1_type = checkForNull(rset.getString("ALT_ID1_TYPE"));
						  blood_group = checkForNull(rset.getString("BLOOD_GRP_DESC"));
						  blood_group_code =checkForNull(rset.getString("BLOOD_GRP"));
						  rh_factor   = checkForNull(rset.getString("rh_factor_desc"));
						  rh_factor_code = checkForNull(rset.getString("RHESUS_FACTOR_CODE"));
						  contact1_relation	     = checkForNull(rset.getString("CONTACT1_RELATION"));
						  contact1_name		     = checkForNull(rset.getString("CONTACT1_NAME"));
							contact1_nat_id_no       = checkForNull(rset.getString("CONTACT1_NAT_ID_NO"));
							contact1_birth_date      = checkForNull(rset.getString("CONTACT1_BIRTH_DATE"));
							job1_title			     = checkForNull(rset.getString("JOB1_TITLE"));
							addr1_line1			     = checkForNull(rset.getString("ADDR1_LINE1"));
							addr1_line2			     = checkForNull(rset.getString("ADDR1_LINE2"));
							addr1_line3			     = checkForNull(rset.getString("ADDR1_LINE3"));
							addr1_line4			     = checkForNull(rset.getString("ADDR1_LINE4"));
							contact1_res_town        = checkForNull(rset.getString("CONTACT1_RES_TOWN_CODE"));
							contact1_res_town_desc   = checkForNull(rset.getString("contact1_res_town_desc"));
							contact1_area_code       = checkForNull(rset.getString("CONTACT1_RES_AREA_CODE"));
							contact1_res_area__desc  = checkForNull(rset.getString("contact1_res_area__desc"));
							contact1_region_code     = checkForNull(rset.getString("CONTACT1_REGION_CODE"));
							contact1_region_desc     = checkForNull(rset.getString("contact1_region_desc"));
							postal1_code		     = checkForNull(rset.getString("POSTAL1_CODE"));
							postal1_desc		     = checkForNull(rset.getString("postal1_desc"));
							country1_code		     = checkForNull(rset.getString("COUNTRY1_CODE"));
							country1_code_desc	     = checkForNull(rset.getString("country1_code_desc"));
							//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
                                                        nk_mail_addr_line1			     = checkForNull(rset.getString("nk_mail_addr_line1"));
							nk_mail_addr_line2			     = checkForNull(rset.getString("nk_mail_addr_line2"));
							nk_mail_addr_line3			     = checkForNull(rset.getString("nk_mail_addr_line3"));
							nk_mail_addr_line4			     = checkForNull(rset.getString("nk_mail_addr_line4"));
							nkcontact1_res_town        = checkForNull(rset.getString("nk_mail_town_code"));
							n_contact_ma_town_desc   = checkForNull(rset.getString("n_contact_ma_town_desc"));
							nkcontact1_region_code     = checkForNull(rset.getString("nk_mail_region_code"));
							n_contac_region_desc     = checkForNull(rset.getString("n_contac_region_desc"));
		                                        nkcontact1_area_code     = checkForNull(rset.getString("nk_mail_region_code"));
							n_contact_ma_area_desc     = checkForNull(rset.getString("n_contact_ma_area_desc"));
							nkpostal1_code     = checkForNull(rset.getString("nk_mail_postal_code"));
							nkpostal1_desc     = checkForNull(rset.getString("nkpostal1_desc"));
							nk_mail_country_code		     = checkForNull(rset.getString("nk_mail_country_code"));
							nk_mail_country_desc	     = checkForNull(rset.getString("nk_mail_country_desc"));
							nk_res_contact_name			     = checkForNull(rset.getString("nk_res_contact_name"));
							nk_mail_contact_name			     = checkForNull(rset.getString("nk_mail_contact_name"));
							nk_contact3_mode       = checkForNull(rset.getString("nk_contact3_mode"));
							nk_contact3_no       = checkForNull(rset.getString("nk_contact3_no"));
							nk_contact4_mode       = checkForNull(rset.getString("nk_contact4_mode"));
							nk_contact4_no       = checkForNull(rset.getString("nk_contact4_no"));
							nk_contact5_mode       = checkForNull(rset.getString("nk_contact5_mode"));
							nk_contact5_no       = checkForNull(rset.getString("nk_contact5_no"));

							fton_mail_addr_line1			     = checkForNull(rset.getString("fton_mail_addr_line1"));
							fton_mail_addr_line2			     = checkForNull(rset.getString("fton_mail_addr_line2"));
							fton_mail_addr_line3			     = checkForNull(rset.getString("fton_mail_addr_line3"));
							fton_mail_addr_line4			     = checkForNull(rset.getString("fton_mail_addr_line4"));
							ftoncontact2_res_town        = checkForNull(rset.getString("fton_mail_town_code"));
							fst_to_no_ma_town_desc   = checkForNull(rset.getString("fst_to_no_ma_town_desc"));
							ftoncontact2_region     = checkForNull(rset.getString("fton_mail_region_code"));
							fst_to_no_ma_reg_desc     = checkForNull(rset.getString("fst_to_no_ma_reg_desc"));
		                                        ftoncontact2_res_area     = checkForNull(rset.getString("fton_mail_area_code"));
							fst_to_no_ma_area_desc     = checkForNull(rset.getString("fst_to_no_ma_area_desc"));
							ftonpostal1_code     = checkForNull(rset.getString("fton_mail_postal_code"));
							ftonpostal1_desc     = checkForNull(rset.getString("ftonpostal1_desc"));
							fton_mail_country_code		     = checkForNull(rset.getString("fton_mail_country_code"));
							fton_mail_country_desc	     = checkForNull(rset.getString("fton_mail_country_desc"));
							fton_res_contact_name			     = checkForNull(rset.getString("fton_res_contact_name"));
							fton_mail_contact_name			     = checkForNull(rset.getString("fton_mail_contact_name"));

							fton_contact3_mode       = checkForNull(rset.getString("fton_contact3_mode"));
							fton_contact3_no       = checkForNull(rset.getString("fton_contact3_no"));
							fton_contact4_mode       = checkForNull(rset.getString("fton_contact4_mode"));
							fton_contact4_no       = checkForNull(rset.getString("fton_contact4_no"));
							fton_contact5_mode       = checkForNull(rset.getString("fton_contact5_mode"));
							fton_contact5_no       = checkForNull(rset.getString("fton_contact5_no"));
							//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
							res1_tel_no			     = checkForNull(rset.getString("RES1_TEL_NO"));
							res1_mbo_tel_no		     = checkForNull(rset.getString("CONTACT1_MOB_TEL_NO"));
							off1_tel_no			     = checkForNull(rset.getString("OFF1_TEL_NO"));
							contact1_email_id	     = checkForNull(rset.getString("CONTACT1_EMAIL_ID"));
							first_to_notify_name     = checkForNull(rset.getString("CONTACT2_NAME"));
							contact2_relation	     = checkForNull(rset.getString("CONTACT1_RELATION"));
							contact2_nat_id		     = checkForNull(rset.getString("CONTACT2_NAT_ID_NO"));
							job2_title			     = checkForNull(rset.getString("JOB2_TITLE"));
							contact2_res_tel_no	     = checkForNull(rset.getString("RES2_TEL_NO"));
							contact2_mob_tel_no	     = checkForNull(rset.getString("CONTACT2_MOB_TEL_NO"));
							contact2_off_tel_no	     = checkForNull(rset.getString("OFF2_TEL_NO"));
							contact2_mail_id	     = checkForNull(rset.getString("CONTACT2_EMAIL_ID"));
							contact2_add_l1	         = checkForNull(rset.getString("ADDR2_LINE1"));
							contact2_add_l2	         = checkForNull(rset.getString("ADDR2_LINE2"));
							contact2_add_l3	         = checkForNull(rset.getString("ADDR2_LINE3"));
							contact2_add_l4		     = checkForNull(rset.getString("ADDR2_LINE4"));
							contact2_town_code	     = checkForNull(rset.getString("CONTACT2_RES_TOWN_CODE"));
							contact2_res_town_desc	 = checkForNull(rset.getString("contact2_res_town_desc"));
							contact2_area_code	     = checkForNull(rset.getString("CONTACT2_RES_AREA_CODE"));
							contact2_res_area__desc	 = checkForNull(rset.getString("contact2_res_area__desc"));
							contact2_reg_code	     = checkForNull(rset.getString("CONTACT2_REGION_CODE"));
							contact2_region_desc	 = checkForNull(rset.getString("contact2_region_desc"));
							postal2_code             = checkForNull(rset.getString("POSTAL2_CODE"));
							postal2_desc		     = checkForNull(rset.getString("postal2_desc"));
							contact2_country_code	 = checkForNull(rset.getString("COUNTRY2_CODE"));
							country2_code_desc	     = checkForNull(rset.getString("country2_code_desc"));
							contact3_org_name	     = checkForNull(rset.getString("ORGANIZATION_NAME"));
							employer_name			 = checkForNull(rset.getString("CONTACT3_NAME"));
							addr3_line1			     = checkForNull(rset.getString("ADDR3_LINE1"));
							addr3_line2			     = checkForNull(rset.getString("ADDR3_LINE2"));
							addr3_line3			     = checkForNull(rset.getString("ADDR3_LINE3"));
							addr3_line4			     = checkForNull(rset.getString("ADDR3_LINE4"));
							contact3_town_code	     = checkForNull(rset.getString("CONTACT3_RES_TOWN_CODE"));
							contact3_res_town_desc   = checkForNull(rset.getString("contact3_res_town_desc"));
							contact3_reg_code	     = checkForNull(rset.getString("CONTACT3_REGION_CODE"));
							contact3_region_desc	 = checkForNull(rset.getString("contact3_region_desc"));
							contact3_area_code	     = checkForNull(rset.getString("CONTACT3_RES_AREA_CODE"));
							contact3_res_area__desc	 = checkForNull(rset.getString("contact3_res_area__desc"));
							postal3_code		     = checkForNull(rset.getString("POSTAL3_CODE"));
							postal3_desc		     = checkForNull(rset.getString("postal3_desc"));
							country3_code		     = checkForNull(rset.getString("COUNTRY3_CODE"));
							country3_code_desc	     = checkForNull(rset.getString("country3_code_desc"));
							res3_tel_no			     = checkForNull(rset.getString("RES3_TEL_NO"));
							off3_tel_no			     = checkForNull(rset.getString("OFF3_TEL_NO"));
							patient_employee_id 	 = checkForNull(rset.getString("PATIENT_EMPLOYEE_ID"));
							ocpn_class_code			 = checkForNull(rset.getString("OCPN_CLASS_CODE"));
							ocpn_code			     = checkForNull(rset.getString("OCPN_CODE"));
							ocpn_desc			     = checkForNull(rset.getString("OCPN_DESC"));
							employment_status	     = checkForNull(rset.getString("EMPLOYMENT_STATUS"));
							sysdate				    = checkForNull(rset.getString("sys"));
							sysDateWithoutTime	    = checkForNull(rset.getString("sys1"));
							nat_id_check_digit_id	= checkForNull( rset.getString("nat_id_check_digit_id"));
							nat_id_chk_len		    = checkForNull( rset.getString("nat_id_chk_len"));
							/*Added by Thamizh selvi on 7th Aug 2018 against ML-MMOH-CRF-1177 Start*/
							natInvokeRoutine		= checkForNull( rset.getString("invoke_routine"));
							natDataSourceId		    = checkForNull( rset.getString("nat_data_source_id"));
							/*End*/

					   }
					   if(pstmt!=null) pstmt.close();
					   if(rset!=null) rset.close();  
					   if((nationalDisp != null) && (nationalDisp.length() > 0))
						{
							nationalDisp.delete(0,nationalDisp.length());
						}
						if (deceased_yn.equals("Y")){
							proBrought_dead = "disabled";
						}
						else{
							proBrought_dead = "";
						}
						String  sysDateSer = sysdate;

						sysdate=DateUtils.convertDate(sysdate,"DMYHMS","en",locale);
					

					    if (!contact1_birth_date.equals("")){	contact1_birth_date=DateUtils.convertDate(contact1_birth_date,"DMY","en",locale);
					   }
		   
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sysDateSer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!nat_id_prompt.equals("")){  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nationality_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } else {  
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(!alt_id1_desc.equals("")){  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( alt_id1_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
 } else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(!alt_id2_desc.equals("")){  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } else {  
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(!alt_id3_desc.equals("")){  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( alt_id3_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
 } else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(!alt_id4_desc.equals("")){  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } else {  
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(oth_alt_id_desc.equals(""))  oth_alt_id_desc="&nbsp;"; 
            _bw.write(_wl_block41Bytes, _wl_block41);
if (! oth_alt_id_desc.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oth_alt_id_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } else{ 
            _bw.write(_wl_block44Bytes, _wl_block44);
 }
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(residency.equals("Y")){ 
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
 } else { 

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
 } 
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(legal_status.equals("Y")){ 
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
 } else { 

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
 } 
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(blood_group_code));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rh_factor));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rh_factor_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block57Bytes, _wl_block57);

					   // to get the build_episode_rule and the sysdate
					   pstmt = con.prepareStatement(episodeDisp.toString());
					   pstmt.setString(1,facilityId);
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
			                buildEpisodeRule	= rset.getString("BUILD_EPISODE_RULE");
					   }

					   if(pstmt!=null) pstmt.close();
					   if(rset!=null) rset.close();
					   if((episodeDisp != null) && (episodeDisp.length() > 0))
						{
							episodeDisp.delete(0,episodeDisp.length());
						}
    					sys_date  =sysDateWithoutTime;
					   if(buildEpisodeRule==null) buildEpisodeRule="X"; 
	  	
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(StartDate1));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(AllowedDate));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 if (visit_back_yn.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block65Bytes, _wl_block65);
 } else { 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
 
			  if (bl_install_yn.equals("Y")&&(os_amt > 0)) {
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(os_amt1));
            _bw.write(_wl_block71Bytes, _wl_block71);
 } 
            _bw.write(_wl_block72Bytes, _wl_block72);
if(!invoke_recall.equals("Y")){
            _bw.write(_wl_block73Bytes, _wl_block73);
}else{
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

						   int countRec = 0;		
						   pstmt=con.prepareStatement(sqlLocation.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						   pstmt.setString(1,facilityId);
					       pstmt.setString(2,facilityId);
 					       pstmt.setString(3,oper_stn_id);
					       pstmt.setString(4,user_id);
						   pstmt.setInt(5,patient_age);
						   pstmt.setInt(6,patient_age);
						   pstmt.setInt(7,patient_age);
						   rs = pstmt.executeQuery();
						   boolean rec_exists=false;
						   if(rs != null){
				              rs.last();
			                  countRec = rs.getRow();
                              rs.beforeFirst();
					       }
                           if (countRec >= 1){
					          while(rs!=null && rs.next()){
	        
								 gender1 = rs.getString(7);					 
								 if(gender1==null)  gender1	= "";
								 if(gender1.equals("") || gender1.equals(sex)){									 
									 if(referal_id.equals("")){
										 out.println( "<option value='"+rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6)+"::"+rs.getString(8)+"'>"+rs.getString(2)+"</option>"); 
										

										 
									 }else{
										if(!to_locn_code.equals("")){
											if(to_locn_code.equals(rs.getString(1))){										
												out.println( "<option value='"+rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6)+"::"+rs.getString(8)+"'>"+rs.getString(2)+"</option>"); 
											
								
											}
										}else{
											out.println( "<option value='"+rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6)+"::"+rs.getString(8)+"'>"+rs.getString(2)+"</option>"); 

									}
									 }
						              rec_exists=true;
									 }
									
									
						       }
							   //End of While
						   }else if (countRec == 1){ //End of More Record
						      while(rs!=null && rs.next()) {
								  gender1 = rs.getString(7);


								  if(gender1 == null) gender1	= "";
   						          if(gender1.equals("") || gender1.equals(sex)){
									out.println( "<option value='"+rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6)+"::"+rs.getString(8)+"'  selected>"+rs.getString(2)+""); 
									rec_exists=true;
								  }
						       }//End of While
						   }
						   if(rs!=null) rs.close();
						   if(pstmt!=null) pstmt.close();
						  // pstmt=null;
						   if((sqlLocation != null) && (sqlLocation.length() > 0))
							{
								sqlLocation.delete(0,sqlLocation.length());
							}					 
							 
					   
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(rec_exists));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
  
				   PreparedStatement pstmtTrans = null;
				   ResultSet rsetTrans = null;
				   StringBuffer sqlAMTrans = new StringBuffer();
                   sqlAMTrans.append("SELECT transport_mode, short_desc FROM am_transport_mode_lang_vw WHERE language_id='"+locale+"' and PATIENT_RELATED_YN='Y' AND eff_status = 'E' ORDER BY 2 ");
                   pstmtTrans = con.prepareStatement(sqlAMTrans.toString());
					
				   rsetTrans = pstmtTrans.executeQuery();
				  while(rsetTrans!=null && rsetTrans.next())
					 {
					out.println("<option value='"+rsetTrans.getString(1)+"'>"+rsetTrans.getString(2)+""); 
					 }
				  if(pstmtTrans!=null) pstmtTrans.close();
				  if(rsetTrans!=null) rsetTrans.close();
				  if((sqlAMTrans != null) && (sqlAMTrans.length() > 0))
				  {
						sqlAMTrans.delete(0,sqlAMTrans.length());
				   }
	            
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

								JSONArray osccTypeJsonArr	= new JSONArray();
								osccTypeJsonArr  = eAE.AECommonBean.getOSCCTypeList(con,locale,"");	
									
								for(int i = 0 ; i < osccTypeJsonArr.size() ; i++) 
								{
									JSONObject osccTypejson		= (JSONObject)osccTypeJsonArr.get(i);
									String injCategoryCode		= (String) osccTypejson.get("injCategoryCode");
									String injSubCategoryCode	= (String) osccTypejson.get("injSubCategoryCode");
									String subCategoryShortDesc	= (String) osccTypejson.get("subCategoryShortDesc");
											
									out.println("<option value="+injCategoryCode+","+injSubCategoryCode+">"+subCategoryShortDesc+"</option>");
											
								}
											
						
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
 }else{ 
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
 }
		 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block107Bytes, _wl_block107);
 } 
            _bw.write(_wl_block108Bytes, _wl_block108);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
 }else{ 
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
 } 
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

					
						 StringBuffer sqlMechaInjury = new StringBuffer();
						 sqlMechaInjury.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW  WHERE language_id='"+locale+"'  and EFF_STATUS='E'  and oscc_yn=  'N'  ORDER BY 2 ");  
						 pstmtTrans = con.prepareStatement(sqlMechaInjury.toString());
					     rsetTrans = pstmtTrans.executeQuery();
						 
						 while(rsetTrans!=null && rsetTrans.next())
						   {
							 
                              out.println("<option value='"+rsetTrans.getString(1)+"' >"+rsetTrans.getString(2)+" ");
						   }
						 if(pstmtTrans!=null) pstmtTrans.close();
						 if(rsetTrans!=null) rsetTrans.close();
						 if((sqlMechaInjury != null) && (sqlMechaInjury.length() > 0))
						 {
							sqlMechaInjury.delete(0,sqlMechaInjury.length());
						 }
					     
            _bw.write(_wl_block114Bytes, _wl_block114);
 if(!isMechInjLabelChngAppl){ 
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
 } 
            _bw.write(_wl_block118Bytes, _wl_block118);
 if(isMechInjLabelChngAppl){ 
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
 } 
            _bw.write(_wl_block122Bytes, _wl_block122);
if(isPriorityZoneAppl){
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
 } 
            _bw.write(_wl_block124Bytes, _wl_block124);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

			   StringBuffer sqlProtect = new StringBuffer();
			  
			   sqlProtect.append("SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM  AE_PROTECTIVE_DEVICE_LANG_VW WHERE language_id='"+locale+"'  and EFF_STATUS ='E' and PROTECTIVE_DEVICE_CODE like '%%' ORDER BY 2");

			   pstmtTrans = con.prepareStatement(sqlProtect.toString());
			   rsetTrans = pstmtTrans.executeQuery();
			    
			   optSelected="";
			   while(rsetTrans!=null && rsetTrans.next())
			   {				   
				  out.println("<option value='"+rsetTrans.getString(1)+"' >"+rsetTrans.getString(2)+" ");
			   }
			   if(pstmtTrans!=null) pstmtTrans.close();
			   if(rsetTrans!=null)	rsetTrans.close();
			   if((sqlProtect != null) && (sqlProtect.length() > 0))
				 {
					sqlProtect.delete(0,sqlProtect.length());
				 } 
			   
            _bw.write(_wl_block129Bytes, _wl_block129);
if(!five_level_triage_appl_yn.equals("Y") && (isLabelChngAppl == false)){ 
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
}else{ 
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
} 
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(proBrought_dead));
            _bw.write(_wl_block135Bytes, _wl_block135);
if(siteSpecific){
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!isMLCAppl){ 
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
} 
            _bw.write(_wl_block136Bytes, _wl_block136);
}else{
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!isMLCAppl){ 
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
 if(!isMLCAppl){ 
            _bw.write(_wl_block139Bytes, _wl_block139);
} 
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
if(isLabelChngAppl == true){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block143Bytes, _wl_block143);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block144Bytes, _wl_block144);
 } 
            _bw.write(_wl_block145Bytes, _wl_block145);
if(isPlaceOfOccuurrence == true){
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
 }
			else{
				
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
}
            _bw.write(_wl_block149Bytes, _wl_block149);
if(isLabelChngAppl == true){ 
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
}
			  else if(isPlaceOfOccuurrence == true)
			  {
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
 }
			  else{
				  
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
} 
            _bw.write(_wl_block157Bytes, _wl_block157);
if(isPlaceOfOccuurrence == false){ 
            _bw.write(_wl_block158Bytes, _wl_block158);
if(isLabelChngAppl == true){ 
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
}
			else
			{
				
			
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
                   pstmtTrans1 = con.prepareStatement("select PLACE_OCCURRENCE_TYPE_CODE, short_desc from AE_PLACE_OF_OCCURRENCE where  eff_status='E' order by short_desc");
					
				   rsetTrans1 = pstmtTrans1.executeQuery();
				   while(rsetTrans1!=null && rsetTrans1.next())
					{
					  out.println("<option value='"+rsetTrans1.getString("PLACE_OCCURRENCE_TYPE_CODE")+"'>"+rsetTrans1.getString("short_desc")+""); 
					}
                  if(rsetTrans1!=null) rsetTrans1.close();
				  if(pstmtTrans1!=null) pstmtTrans1.close();
				  }catch(Exception e) {/* out.println("Exception in Place of Occurrence="+e); */			e.printStackTrace();}
	            
            _bw.write(_wl_block163Bytes, _wl_block163);
}
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(isPlaceOfOccuurrence));
            _bw.write(_wl_block165Bytes, _wl_block165);
 if(isCaseDtlsRadioBtnAppl){ 
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

						 StringBuffer sqlVehicleInv = new StringBuffer();
						 //sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"'  order by 2");

						 sqlVehicleInv.append("select ARRIVAL_CODE, SHORT_DESC ARRIVAL_SHORT_DESC from am_arrival_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E' and facility_id='"+facilityId+"' and ARRIVAL_CODE like '%%' order by 2");

						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							  optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

						 pstmt = con.prepareStatement(sqlVehicleInv.toString());
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							  optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
						 if((sqlVehicleInv != null) && (sqlVehicleInv.length() > 0))
						 {
							sqlVehicleInv.delete(0,sqlVehicleInv.length());
						 }
					   
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

							StringBuffer  sqlPosition = new StringBuffer();
		
							sqlPosition.append("SELECT a.PAT_POSITION_CODE, a.SHORT_DESC FROM AE_PAT_POSITION_LANG_VW a WHERE a.language_id = '"+locale+"' AND a.EFF_STATUS = 'E' AND a.pat_position_code like '%%' ORDER BY a.SHORT_DESC");

						   pstmt = con.prepareStatement(sqlPosition.toString());
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   if((sqlPosition != null) && (sqlPosition.length() > 0))
							{
								sqlPosition.delete(0,sqlPosition.length());
							}
					   
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
 if(isMLCAppl){ 
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
 }
            _bw.write(_wl_block186Bytes, _wl_block186);
if(!five_level_triage_appl_yn.equals("Y")){ 
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
} 
            _bw.write(_wl_block189Bytes, _wl_block189);
if(!five_level_triage_appl_yn.equals("Y")){ 
            _bw.write(_wl_block190Bytes, _wl_block190);
if(isPriorityZoneAppl){
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

		try{
		sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in('B','W') order by PRIORITY_ZONE_ORDER";
				
			    pstmt   = con.prepareStatement(sql1);
				pstmt.setString(1,locale) ;
				rset    = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				{
					if(rset.getString("PRIORITY_ZONE").equals("U"))
							out.println("<option value='"+rset.getString(1)+"' selected>");	
							else
				            out.println("<option value='"+rset.getString(1)+"'>");	     
							out.println(rset.getString(2));
							out.println("</option>"); 
				}
					 
				
		    }catch(Exception e){e.printStackTrace();}
						
            _bw.write(_wl_block193Bytes, _wl_block193);
}else{
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(red));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(green));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(enablePrac));
            out.print( String.valueOf(priorityRed));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(enablePrac));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(enablePrac));
            _bw.write(_wl_block201Bytes, _wl_block201);
}
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
if(isPracApplicable){
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
}
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(enablePrac));
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);

			   try 
				  {	
			       StringBuffer encoutBuff = new StringBuffer();
                   encoutBuff.append("select count(*) from pr_encounter where ");	
				   encoutBuff.append(" facility_id= ?  and patient_id= ? ");
				   pstmtEncounter = con.prepareStatement(encoutBuff.toString());
                   pstmtEncounter.setString(1,facilityId);
				   pstmtEncounter.setString(2,patient_id);
					
				   rsetEncounter = pstmtEncounter.executeQuery();
						  while(rsetEncounter!=null && rsetEncounter.next())
							 {
						      countRecEnc=rsetEncounter.getInt(1);
							 }
			          if(rsetEncounter!=null) rsetEncounter.close();
			          if(pstmtEncounter!=null) pstmtEncounter.close();
					  if (countRecEnc==0)
					  {
						  EncounterProp = "disabled";
					  }else
					  {
						  EncounterProp ="";
					  }
                      if((encoutBuff != null) && (encoutBuff.length() > 0))
				      {
						encoutBuff.delete(0,encoutBuff.length());
				      }
				  }catch(Exception e) {/* out.println("Exception in Encounter="+e); */e.printStackTrace();}
			
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
  
                  try 
				  {	
				   PreparedStatement pstmtTrans1 = null;
				   ResultSet rsetTrans1 = null;
                   pstmtTrans1 = con.prepareStatement("select disaster_type_code, short_desc from ae_disaster_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by short_desc");
					
				   rsetTrans1 = pstmtTrans1.executeQuery();
				   while(rsetTrans1!=null && rsetTrans1.next())
					{
					  out.println("<option value='"+rsetTrans1.getString("disaster_type_code")+"'>"+rsetTrans1.getString("short_desc")+""); 
					}
                  if(rsetTrans1!=null) rsetTrans1.close();
				  if(pstmtTrans1!=null) pstmtTrans1.close();
				  }catch(Exception e) {/* out.println("Exception in Disaster Type="+e); */			e.printStackTrace();}
	            
            _bw.write(_wl_block217Bytes, _wl_block217);

				/*Below line added for this CRF MMOH-CRF-0644*/
				if(allowSplChar)
				{
				
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);

		}
		else
		{
		
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);

		}
		
            _bw.write(_wl_block221Bytes, _wl_block221);

	/*Below line added for this CRF GDOH-CRF-0129*/
if(isReferral){
     if(isCurrentEncounter){
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(assigncare_location_desc));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(referralforcurrentencounter));
            _bw.write(_wl_block225Bytes, _wl_block225);
}else{
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
}
            _bw.write(_wl_block228Bytes, _wl_block228);
}else{
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
}
		  //End this CRF GDOH-CRF-0129
		
            _bw.write(_wl_block231Bytes, _wl_block231);
} 
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(EncounterProp));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.LastVisitWithin24Hrs.label","ae_labels")));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(upt_contact_dtls_oa_yn));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(isPracApplicable));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(isAutoPopulateNOKDOBAppl));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(contactAddress.toString()));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(invoke_recall));
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
}
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
  
				   PreparedStatement pstmtAccom = null;
				   ResultSet rsetAccom = null;
				   StringBuffer sqlAMEsc = new StringBuffer();
                   sqlAMEsc.append("SELECT ESCORT_TYPE_CODE, SHORT_DESC  FROM  AM_ESCORT_TYPE_LANG_VW WHERE language_id='"+locale+"' AND EFF_STATUS='E' ORDER BY 2 ");
				   pstmtAccom = con.prepareStatement(sqlAMEsc.toString());
				   rsetAccom = pstmtAccom.executeQuery();
				   while(rsetAccom!=null && rsetAccom.next())
					 {
					out.println("<option value='"+rsetAccom.getString(1)+"'>"+rsetAccom.getString(2)+""); 
					 }
				   if(rsetAccom!=null) rsetAccom.close();
				   if(pstmtAccom!=null) pstmtAccom.close(); 
				   if((sqlAMEsc != null) && (sqlAMEsc.length() > 0))
					{
						sqlAMEsc.delete(0,sqlAMEsc.length());
					}
	             
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);

							/*	 
						   pstmt = con.prepareStatement(sqlRelation.toString());
					       rset = pstmt.executeQuery();
						   while(rset_race!=null && rset_race.next())
						   {
                              out.println("<option value='"+rset_race.getString(1)+"'>"+rset_race.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						   */
						for(int i=0;i<race_array.size();i+=2) {
							out.println("<option value='"+(String) race_array.get(i)+"'>"+(String) race_array.get(i+1)+" ");		
						}
					   
            _bw.write(_wl_block253Bytes, _wl_block253);
if(accept_oth_alt_id_yn.equals("Y")){ 
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

                             sqlAlt.append("select alt_id_type,mp_get_desc.mp_alternate_id_type(alt_id_type,'"+locale+"','1') short_desc from  mp_alternate_id_type where  alt_id_type not in (select alt_id1_type   from mp_param where module_id='MP' union select  nvl(alt_id2_type,1) from mp_param where module_id='MP' union  select nvl(alt_id3_type,2) from mp_param where module_id='MP' union select nvl(alt_id4_type,3) from  mp_param where module_id='MP') and eff_status='E' order by 2");
						     PreparedStatement pstmtAlt = null;
				             ResultSet rsetAlt = null;
						     pstmtAlt = con.prepareStatement(sqlAlt.toString());
					         rsetAlt = pstmtAlt.executeQuery();
							  while(rsetAlt!=null && rsetAlt.next())
						      {
						          out.println("<option value='"+rsetAlt.getString(1)+"'>"+rsetAlt.getString(2)+" ");
						      }
						      if(pstmtAlt!=null) pstmtAlt.close();
						      if(rsetAlt!=null) rsetAlt.close(); 
				            
            _bw.write(_wl_block257Bytes, _wl_block257);
}else {
            _bw.write(_wl_block258Bytes, _wl_block258);
 }
            _bw.write(_wl_block259Bytes, _wl_block259);
String nat_on_blurfn_st = "";
				   String nat_on_blurfn_st_nok = "";//Added by Thamizh selvi on 8th Aug 2018 against ML-MMOH-CRF-1177
							//validateNationalID(this,'"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','"+nat_id_prompt+"');

							/*  above line commeted for icn:19689 date:Thursday, March 11, 2010*/ 

					if(accept_national_id_no_yn.equals("Y")){
						nat_on_blurfn_st = "makeValidString(this);CheckSplCharsNatID(this);";
						 /*Added by Thamizh selvi on 8th Aug 2018 against ML-MMOH-CRF-1177 Start*/
						 if(isAutoPopulateNOKDOBAppl && natDataSourceId.equals("NRIC"))
							nat_on_blurfn_st_nok = "makeValidString(this);if(CheckSplCharsNatID(this)){validateNOKNatIDWithDOB(this);}";
						 else
							nat_on_blurfn_st_nok = "makeValidString(this);CheckSplCharsNatID(this)";
						 /*End*/
						
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

						/*
						if ( nat_id_check_digit_id.equals("M11") )
							nat_id_onKeyPress = "return CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";

						*/							
					
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf( nat_id_length));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block264Bytes, _wl_block264);
}else{
            _bw.write(_wl_block265Bytes, _wl_block265);
 } 
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf( nat_id_check_digit_id));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf( nat_id_chk_len));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf( nat_id_prompt));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(natInvokeRoutine));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(natDataSourceId));
            _bw.write(_wl_block271Bytes, _wl_block271);

		tindex	=	31;
		out.println("<tr>") ; 
		StringBuffer sb2 = new StringBuffer() ;
		StringBuffer sb12 = new StringBuffer() ;
		StringBuffer sba2 = new StringBuffer() ;
		StringBuffer sbar2 = new StringBuffer();
        StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "e_addr_line1" ;
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "e_addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "e_addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "e_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "m_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
                                     }
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal2.append(++tindex);
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
                                    out.println("<td class='fields'>"+val) ;
									
						   out.println("</td>");
						   out.println("<td class='label'  colspan='2'>&nbsp;</td>");
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            }
		       
            _bw.write(_wl_block272Bytes, _wl_block272);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block278Bytes, _wl_block278);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block279Bytes, _wl_block279);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
}
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);

				if(isAENextofKinchngAppl)
				{
				
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block288Bytes, _wl_block288);
 if (accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(nat_on_blurfn_st_nok));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(contact1_nat_id_no));
            _bw.write(_wl_block294Bytes, _wl_block294);
}else {
            _bw.write(_wl_block295Bytes, _wl_block295);
}
            _bw.write(_wl_block296Bytes, _wl_block296);
}
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);
 //Below line added for ML-MMOH-CRF-0887.1
					if(increasedaddressLength){
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block300Bytes, _wl_block300);
}else{
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block302Bytes, _wl_block302);
}
            _bw.write(_wl_block303Bytes, _wl_block303);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);


					/*
					String relcode = contact1_relation;
					pstmtR = con.prepareStatement(sqlRelation.toString());
                    rsetR=pstmtR.executeQuery();
					if(rset_race!=null)
					{
					   while(rset_race.next())
					   {
							String relationDesc = rset_race.getString(2);
							String relationCode = rset_race.getString(1);
						
							if(relcode.equals(relationCode))
								sel = "selected";
							else
								sel="";
				
							out.println("<option value='"+relationCode+"' "+sel+">"+relationDesc+"</option>");
						}
					} 
					*/
					String relcode = contact1_relation;

					for(int i=0;i<race_array.size();i+=2) {

						String relationDesc = (String) race_array.get(i+1);
						String relationCode = (String) race_array.get(i);
						
						if(relcode.equals(relationCode))
							sel = "selected";
						else
							sel="";
				
						out.println("<option value='"+relationCode+"' "+sel+">"+relationDesc+"</option>");

						//out.println("<option value='"+(String) race_array.get(i)+"'>"+(String) array_list.get(i+1)+" ");		
					}

				   //if(rsetR!=null) rsetR.close();
				   //if(pstmtR!=null) pstmtR.close();
                    
            _bw.write(_wl_block306Bytes, _wl_block306);
if(!isAENextofKinchngAppl)
			{
            _bw.write(_wl_block307Bytes, _wl_block307);
 if (accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(nat_on_blurfn_st_nok));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(contact1_nat_id_no));
            _bw.write(_wl_block294Bytes, _wl_block294);
}else {
            _bw.write(_wl_block295Bytes, _wl_block295);
}
            _bw.write(_wl_block308Bytes, _wl_block308);
}
            _bw.write(_wl_block309Bytes, _wl_block309);
	
	if(Accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block310Bytes, _wl_block310);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);

					  oth_stmt = con.prepareStatement(sqlAlt.toString());
					  oth_rset = oth_stmt.executeQuery();	
				
					  if(oth_rset != null)
					  {
						while (oth_rset.next())
						{          
						  out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					  }
                     if(oth_rset!=null) oth_rset.close();
                     if(oth_stmt!=null) oth_stmt.close();

				    
            _bw.write(_wl_block313Bytes, _wl_block313);
}
            _bw.write(_wl_block314Bytes, _wl_block314);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(contact1_birth_date));
            _bw.write(_wl_block316Bytes, _wl_block316);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(job1_title));
            _bw.write(_wl_block318Bytes, _wl_block318);
 if(resiAddMailAdd){
            _bw.write(_wl_block319Bytes, _wl_block319);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);
} 
            _bw.write(_wl_block322Bytes, _wl_block322);

					out.println("<tr><td colspan=8 class=label height=5></td></tr>");
					out.println("<tr>") ;
					StringBuffer sb3 = new StringBuffer() ;
					StringBuffer sb31 = new StringBuffer() ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sb13 = new StringBuffer() ;
					StringBuffer sb131 = new StringBuffer() ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sba3 = new StringBuffer() ;
					StringBuffer sba31 = new StringBuffer() ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sbar3 = new StringBuffer() ;
					StringBuffer sbar31 = new StringBuffer() ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                    StringBuffer fieldVal3 = new StringBuffer("");
                                        StringBuffer fieldVal31 = new StringBuffer(""); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                    for(int i=0;i<contact_col_names.length; i++)
                            {   
						            String  val = contact_fields[i] ;
						            String  val1 = contact_fields[i] ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sb3.append(val);
									sb31.append(val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
								    int j=0 ;
									int j1 = 0;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     String new_val1 = "" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "next_addr_line1" ;
										new_val1 = "n_next_addr_line1" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "next_addr_line2" ;
										new_val1 = "n_ma_addr_line2" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "next_addr_line3" ;
										new_val1 = "n_ma_addr_line3" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "next_addr_line4" ;
										new_val1 = "n_ma_addr_line4" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact1_res_town_code" ;
										new_val1 = "n_contact_ma_town_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									 }
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact1_region_code" ;
										new_val1 = "n_contac_region_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact1_res_area_code" ;
										new_val1 = "n_contact_ma_area_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "next_postal_code" ;
										new_val1 = "n_ma_postal_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
									out.println("<td class='label' nowrap align='right' >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb3 = sb3.replace(j,(j+old_val.length()),new_val);
                                        val = sb3.toString();

										sb31 = sb31.replace(j,(j+old_val.length()),new_val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                        val1 = sb31.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                    }
                     // Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba3.append(val);
						sba31.append(val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba3 = sba3.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sba3.toString();

							sba31 = sba31.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val1 = sba31.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar3.append(val);
						sbar31.append(val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar3 = sbar3.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar3.toString();

							sbar31 = sbar31.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val1 = sbar31.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
								   sb13.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb13.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal3.append(50); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal3.append(tempVal);
										}
									}
                                    val = fieldVal3.toString();	
									
									//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sb131.append(val1);
									for(int z=0;z<val1.length();z++)
									{
										String tempVal=sb131.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal31.append(53); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal31.append(tempVal);
										}
									}
                                    val1 = fieldVal31.toString();	
									if(resiAddMailAdd){
                                    out.println("<td class='fields' >"+val+"&nbsp;&nbsp;") ;
                                    out.println("<td class='fields' >"+val1+"&nbsp;&nbsp;") ;
						            out.println("</td>");
						            out.println("</td>");
									}else{
                                    out.println("<td class='fields' >"+val) ;
						            out.println("</td>");
									}
						            //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
						   out.println("</tr>") ;
						   sb13.delete(0,sb13.length());
						   sb131.delete(0,sb131.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                           fieldVal3.delete(0,fieldVal3.length());
                           fieldVal31.delete(0,fieldVal31.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						   sb3.delete(0,sb3.length());
						   sb31.delete(0,sb31.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						   sba3.delete(0,sba3.length());
						   sba31.delete(0,sba31.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						   sbar3.delete(0,sbar3.length());
						   sbar31.delete(0,sbar31.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                            }
        		  
                
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(addr1_line1));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(addr1_line2));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(addr1_line3));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(addr1_line4));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(contact1_res_town_desc));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(contact1_res_town));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(contact1_region_desc));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(contact1_region_code));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(contact1_res_area__desc));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(contact1_area_code));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(postal1_code));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(postal1_desc));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(nk_mail_addr_line1));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(nk_mail_addr_line2));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(nk_mail_addr_line3));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(nk_mail_addr_line4));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(n_contact_ma_town_desc));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(nkcontact1_res_town));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(n_contac_region_desc));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(nkcontact1_region_code));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(n_contact_ma_area_desc));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(nkcontact1_area_code));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(nkpostal1_code));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(nkpostal1_desc));
            _bw.write(_wl_block347Bytes, _wl_block347);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(country1_code_desc));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(country1_code));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(country1_code_desc));
            _bw.write(_wl_block351Bytes, _wl_block351);
 if(resiAddMailAdd){
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(nk_mail_country_desc));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(nkin_m_country_desc));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(nk_mail_country_code));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(nk_mail_country_desc));
            _bw.write(_wl_block356Bytes, _wl_block356);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(nk_res_contact_name));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(nk_mail_contact_name));
            _bw.write(_wl_block359Bytes, _wl_block359);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block360Bytes, _wl_block360);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
}
            _bw.write(_wl_block362Bytes, _wl_block362);
 if(!resiAddMailAdd){ //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block363Bytes, _wl_block363);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(res1_tel_no));
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(res1_mbo_tel_no));
            _bw.write(_wl_block367Bytes, _wl_block367);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(off1_tel_no));
            _bw.write(_wl_block369Bytes, _wl_block369);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(contact1_email_id));
            _bw.write(_wl_block371Bytes, _wl_block371);
} //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block372Bytes, _wl_block372);
//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			  if(resiAddMailAdd){
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block374Bytes, _wl_block374);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(res1_tel_no));
            _bw.write(_wl_block376Bytes, _wl_block376);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(res1_mbo_tel_no));
            _bw.write(_wl_block378Bytes, _wl_block378);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(contact1_email_id));
            _bw.write(_wl_block380Bytes, _wl_block380);
String enabledisable = "disabled";
					   codes = new ArrayList() ; 
					   descs = new ArrayList() ;
					   sql = "select contact_mode,short_desc from mp_contact_mode_lang_vw where language_id='"+locale+"' and eff_status='E' and contact_mode not in ('PRN','ORN') order by 2";
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
						if(oth_rset!=null) {
							 enabledisable = ""; 
							while (oth_rset.next()) {
							   codes .add(oth_rset.getString(1));
							   descs .add(oth_rset.getString(2));
							}
						}
						contactmode = codes.toArray();   
						contactdesc = descs.toArray();

						codes = null; 
						descs = null;
						if( oth_rset != null )  oth_rset.close();
            _bw.write(_wl_block381Bytes, _wl_block381);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block387Bytes, _wl_block387);
}
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(nk_contact3_mode));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(nk_contact3_no));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(nk_contact4_mode));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(nk_contact4_no));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(nk_contact5_mode));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(nk_contact5_no));
            _bw.write(_wl_block396Bytes, _wl_block396);
}//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block398Bytes, _wl_block398);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block400Bytes, _wl_block400);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block401Bytes, _wl_block401);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block402Bytes, _wl_block402);
}
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block404Bytes, _wl_block404);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block406Bytes, _wl_block406);
if(resiAddMailAdd){
            _bw.write(_wl_block407Bytes, _wl_block407);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(first_to_notify_name));
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);
	
			relcode = contact2_relation;

						   for(int i=0;i<race_array.size();i+=2) {

							String relationDesc = (String) race_array.get(i+1);
							String relationCode = (String) race_array.get(i);
						
							if(relcode.equals(relationCode))
								sel = "selected";
							else
								sel="";
				
							out.println("<option value='"+relationCode+"' "+sel+">"+relationDesc+"</option>");							
						  }							  
                           
            _bw.write(_wl_block412Bytes, _wl_block412);
if(accept_national_id_no_yn.equals("Y") ){
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(contact2_nat_id));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block417Bytes, _wl_block417);
 } 
            _bw.write(_wl_block418Bytes, _wl_block418);

					if(Accept_oth_alt_id_yn.equals("Y"))
					{
            _bw.write(_wl_block419Bytes, _wl_block419);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block420Bytes, _wl_block420);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);

					oth_stmt = con.prepareStatement(sqlAlt.toString());
					oth_rset = oth_stmt.executeQuery();	
					if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}
                    if(oth_rset!=null) oth_rset.close();
                    if(oth_stmt!=null) oth_stmt.close();
					if((sqlAlt != null) && (sqlAlt.length() > 0))
					{
						sqlAlt.delete(0,sqlAlt.length());
					}
					
            _bw.write(_wl_block421Bytes, _wl_block421);
}
            _bw.write(_wl_block419Bytes, _wl_block419);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(job2_title));
            _bw.write(_wl_block423Bytes, _wl_block423);
}else {
            _bw.write(_wl_block424Bytes, _wl_block424);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(first_to_notify_name));
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block426Bytes, _wl_block426);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);
						   
						   /*
					       pstmtR = con.prepareStatement(sqlRelation.toString());
                           rsetR=pstmtR.executeQuery();
					       if(rset_race!=null)
					       {
					       while(rset_race.next())
					        {
							String relationDesc = rset_race.getString(2);
							String relationCode = rset_race.getString(1);
						
							if(relcode.equals(relationCode))
								sel = "selected";
							else
								sel="";
				
							out.println("<option value='"+relationCode+"' "+sel+">"+relationDesc+"</option>");
						    }
					       }

                           if(rsetR!=null) rsetR.close();
                           if(pstmtR!=null) pstmtR.close();
						   */

						   relcode = contact2_relation;

						   for(int i=0;i<race_array.size();i+=2) {

							String relationDesc = (String) race_array.get(i+1);
							String relationCode = (String) race_array.get(i);
						
							if(relcode.equals(relationCode))
								sel = "selected";
							else
								sel="";
				
							out.println("<option value='"+relationCode+"' "+sel+">"+relationDesc+"</option>");							
						  }							  
                           
            _bw.write(_wl_block412Bytes, _wl_block412);
if(accept_national_id_no_yn.equals("Y") ){
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(contact2_nat_id));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block417Bytes, _wl_block417);
 } 
            _bw.write(_wl_block418Bytes, _wl_block418);

					if(Accept_oth_alt_id_yn.equals("Y"))
					{
            _bw.write(_wl_block419Bytes, _wl_block419);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block428Bytes, _wl_block428);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);

					oth_stmt = con.prepareStatement(sqlAlt.toString());
					oth_rset = oth_stmt.executeQuery();	
					if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}
                    if(oth_rset!=null) oth_rset.close();
                    if(oth_stmt!=null) oth_stmt.close();
					if((sqlAlt != null) && (sqlAlt.length() > 0))
					{
						sqlAlt.delete(0,sqlAlt.length());
					}
					
            _bw.write(_wl_block421Bytes, _wl_block421);
}
            _bw.write(_wl_block419Bytes, _wl_block419);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(job2_title));
            _bw.write(_wl_block430Bytes, _wl_block430);
 } 
					if(resiAddMailAdd){
            _bw.write(_wl_block431Bytes, _wl_block431);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);
} 
            _bw.write(_wl_block432Bytes, _wl_block432);
  
					out.println("<tr>") ;
						//int counter1=0;
						StringBuffer sb4 = new StringBuffer() ;
						StringBuffer sb41 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
						StringBuffer sb14 = new StringBuffer() ;
						StringBuffer sb141 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
						StringBuffer sba4 = new StringBuffer() ;
						StringBuffer sba41 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
						StringBuffer sbar4 = new StringBuffer() ;
						StringBuffer sbar41 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
						StringBuffer fieldVal4 = new StringBuffer("");
						StringBuffer fieldVal41 = new StringBuffer(""); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                                                   
									out.println("<td class='label' nowrap width='25%' >"+contact_prompts[i]+"</td>") ; //Modified by Suji keerthi for ML-MMOH-CRF-1527 US008

                                    String val = contact_fields[i] ;
                                    String val2 = contact_fields[i] ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
									sb4.append(val);
									sb41.append(val2); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
                                    int j1=0;
                                     int j=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     String new_val2 = "" ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "first_addr_line1" ;
										new_val2 = "fton_mail_addr_line1" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "first_addr_line2" ;
										new_val2 = "fton_mail_addr_line2" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "first_addr_line3" ;
										new_val2 = "fton_mail_addr_line3" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "first_addr_line4" ;
										new_val2 = "fton_mail_addr_line4" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact2_res_town_code" ;
										new_val2 = "fst_to_no_ma_town_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact2_region_code" ;
										new_val2 = "fst_to_no_ma_reg_cod" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact2_res_area_code" ;
										new_val2 = "fst_to_no_ma_area_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "first_postal_code" ;
										new_val2 = "fst_no_ma_pos_cod" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     }

                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb4 = sb4.replace(j,(j+old_val.length()),new_val);
                                        val = sb4.toString();

										sb41 = sb41.replace(j,(j+old_val.length()),new_val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                        val2 = sb41.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                    }
                                    // Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba4.append(val);
						sba41.append(val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba4 = sba4.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
							val = sba4.toString();

							sba41 = sba41.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val2 = sba41.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar4.append(val);
						sbar41.append(val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar4 = sbar4.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
							val = sbar4.toString();

							sbar41 = sbar41.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val2 = sbar41.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
									sb14.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb14.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal4.append(60); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal4.append(tempVal);
										}
									}
                                  	val = fieldVal4.toString();
                                    //Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sb141.append(val2);
									for(int z=0;z<val2.length();z++)
									{
										String tempVal=sb141.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal41.append(63); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal41.append(tempVal);
										}
									}
                                  	val2 = fieldVal41.toString();
                                    if(resiAddMailAdd){
                                    out.println("<td class='fields' >"+val+"&nbsp;") ;
                                    out.println("<td class='fields' >"+val2+"&nbsp;") ;
								    out.println("</td>");
								    out.println("</td>");
                                    }else{
									out.println("<td class='fields' width='25%'>"+val) ;
								    out.println("</td>");
									}
									//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
									out.println("<td colspan=2 class=label>&nbsp;</td>");
						            out.println("</tr>") ;
									sb14.delete(0,sb14.length());
									sb141.delete(0,sb141.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
								    fieldVal4.delete(0,fieldVal4.length());
								    fieldVal41.delete(0,fieldVal41.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sb4.delete(0,sb4.length());
									sb41.delete(0,sb41.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sba4.delete(0,sba4.length());
									sba41.delete(0,sba41.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
									sbar4.delete(0,sbar4.length());
									sbar41.delete(0,sbar41.length()); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                            }
                
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(contact2_add_l1));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(contact2_add_l2));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(contact2_add_l3));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(contact2_add_l4));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(contact2_res_town_desc));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(contact2_town_code));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(contact2_region_desc));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(contact2_reg_code));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(contact2_res_area__desc));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(contact2_area_code));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(postal2_code));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(postal2_desc));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(fton_mail_addr_line1));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(fton_mail_addr_line2));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(fton_mail_addr_line3));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(fton_mail_addr_line4));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(fst_to_no_ma_town_desc));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(ftoncontact2_res_town));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(fst_to_no_ma_reg_desc));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(ftoncontact2_region));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(fst_to_no_ma_area_desc));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(ftoncontact2_res_area));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(ftonpostal1_code));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(ftonpostal1_desc));
            _bw.write(_wl_block457Bytes, _wl_block457);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(country2_code_desc));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(contact2_country_code));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(country2_code_desc));
            _bw.write(_wl_block461Bytes, _wl_block461);
 if(resiAddMailAdd){
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(fton_mail_country_desc));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(fton_m_country_desc));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(fton_mail_country_code));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(fton_mail_country_desc));
            _bw.write(_wl_block466Bytes, _wl_block466);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(fton_res_contact_name));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(fton_mail_contact_name));
            _bw.write(_wl_block469Bytes, _wl_block469);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block470Bytes, _wl_block470);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block471Bytes, _wl_block471);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block472Bytes, _wl_block472);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(contact2_res_tel_no));
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag178(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(contact2_mob_tel_no));
            _bw.write(_wl_block476Bytes, _wl_block476);

            if (_jsp__tag179(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(contact2_mail_id));
            _bw.write(_wl_block478Bytes, _wl_block478);
String enabledisable="";
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag180(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag181(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block387Bytes, _wl_block387);
}
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag182(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag183(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(fton_contact3_mode));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(fton_contact3_no));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(fton_contact4_mode));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(fton_contact4_no));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(fton_contact5_mode));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(fton_contact5_no));
            _bw.write(_wl_block489Bytes, _wl_block489);
 } //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block490Bytes, _wl_block490);
if(!resiAddMailAdd){  //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block491Bytes, _wl_block491);

            if (_jsp__tag184(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(contact2_res_tel_no));
            _bw.write(_wl_block493Bytes, _wl_block493);

            if (_jsp__tag185(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(contact2_mob_tel_no));
            _bw.write(_wl_block495Bytes, _wl_block495);

            if (_jsp__tag186(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(contact2_off_tel_no));
            _bw.write(_wl_block497Bytes, _wl_block497);

            if (_jsp__tag187(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(contact2_mail_id));
            _bw.write(_wl_block499Bytes, _wl_block499);
} //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block500Bytes, _wl_block500);

            if (_jsp__tag188(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block501Bytes, _wl_block501);

            if (_jsp__tag189(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block502Bytes, _wl_block502);

            if (_jsp__tag190(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block503Bytes, _wl_block503);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block504Bytes, _wl_block504);

            if (_jsp__tag191(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block505Bytes, _wl_block505);
}
            _bw.write(_wl_block506Bytes, _wl_block506);

            if (_jsp__tag192(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block507Bytes, _wl_block507);

            if (_jsp__tag193(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block508Bytes, _wl_block508);

            if (_jsp__tag194(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block509Bytes, _wl_block509);

            if (_jsp__tag195(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);

            if (_jsp__tag196(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block511Bytes, _wl_block511);

            if (_jsp__tag197(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(contact3_org_name));
            _bw.write(_wl_block515Bytes, _wl_block515);

            if (_jsp__tag198(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(employer_name));
            _bw.write(_wl_block517Bytes, _wl_block517);

					out.println("<tr>") ; 
					StringBuffer sb5 = new StringBuffer() ;
					StringBuffer  sb15 = new StringBuffer() ;
					StringBuffer  sba5 = new StringBuffer() ;
					StringBuffer  sbar5 = new StringBuffer() ;
					StringBuffer fieldVal5 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {                             
								out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	

                                   String val = contact_fields[i] ;
								   sb5.append(val);
                                    int j1=0;
                                     int j=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "employ_addr_line1" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "employ_addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "employ_addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "employ_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact3_res_town_code" ;
                                     } 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact3_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact3_res_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "employ_postal_code" ;
                                     }
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb5 = sb5.replace(j,(j+old_val.length()),new_val);
                                        val = sb5.toString();
                                    }
                    // Newly added
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sba5.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sba5 = sba5.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sba5.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar5.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar5 = sbar5.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sbar5.toString();
						}
					}
								  sb15.append(val);
								for(int z=0;z<val.length();z++)
									{
										String tempVal=sb15.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal5.append(++tindex);
										}
										else
										{
											fieldVal5.append(tempVal);
										}
									}
                                    val = fieldVal5.toString();
						   out.println("<td class='fields' >"+val+"</td>") ;
						   out.println("</tr>") ;
						   sb15.delete(0,sb15.length());
						   fieldVal5.delete(0,fieldVal5.length());
						   sb5.delete(0,sb5.length());
						   sba5.delete(0,sba5.length());
						   sbar5.delete(0,sbar5.length());
                            }
							 
				
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(addr3_line1));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(addr3_line2));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(addr3_line3));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(addr3_line4));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact3_res_town_desc));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(contact3_town_code));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(contact3_region_desc));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(contact3_reg_code));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(contact3_res_area__desc));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(contact3_area_code));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(postal3_code));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(postal3_desc));
            _bw.write(_wl_block530Bytes, _wl_block530);

            if (_jsp__tag199(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(country3_code_desc));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(country3_code));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(country3_code_desc));
            _bw.write(_wl_block534Bytes, _wl_block534);

            if (_jsp__tag200(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(res3_tel_no));
            _bw.write(_wl_block536Bytes, _wl_block536);

            if (_jsp__tag201(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(off3_tel_no));
            _bw.write(_wl_block538Bytes, _wl_block538);

            if (_jsp__tag202(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(patient_employee_id));
            _bw.write(_wl_block540Bytes, _wl_block540);

            if (_jsp__tag203(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block541Bytes, _wl_block541);

            if (_jsp__tag204(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block542Bytes, _wl_block542);

						String occpnC = ocpn_class_code;
						StringBuffer sqlOccp = new StringBuffer();
						sqlOccp.append("select OCPN_CLASS_CODE,LONG_DESC from mp_occupation_class_lang_vw where language_id='"+locale+"' and EFF_STATUS='E'   order by 2  ");
                        oth_stmt = con.prepareStatement(sqlOccp.toString());
						oth_rset = oth_stmt.executeQuery();	
						while(oth_rset.next())
						{
						   String occuDesc = oth_rset.getString("LONG_DESC");
						   String occuCode = oth_rset.getString("OCPN_CLASS_CODE");
						   if(occpnC.equals(occuCode))
								sel = "selected";
						   else
								sel="";
				    	   out.println("<option value='"+occuCode+"' "+sel+">"+occuDesc+"</option>");
						}
                        while(oth_rset.next())
						{
						   out.println("<Option value='" + oth_rset.getString("OCPN_CLASS_CODE") + "'>" + oth_rset.getString("LONG_DESC")+"</option>");
						}
                           if(oth_rset!= null) oth_rset.close() ;
						   if(oth_stmt!= null) oth_stmt.close() ;
						   if((sqlOccp != null) && (sqlOccp.length() > 0))
							{
								sqlOccp.delete(0,sqlOccp.length());
							}
						
            _bw.write(_wl_block543Bytes, _wl_block543);

            if (_jsp__tag205(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block544Bytes, _wl_block544);

            if (_jsp__tag206(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block545Bytes, _wl_block545);

						String occ_of_per = ocpn_code;
						String occpnc_sv = ocpn_class_code;


						StringBuffer sqlOcc = new StringBuffer();
						
						//sqlOcc.append("select ocpn_code,SHORT_DESC from mp_occupation_lang_vw where language_id='"+locale+"'  and EFF_STATUS='E'    order by 2");

						sqlOcc.append("SELECT ocpn_code, short_desc FROM mp_occupation_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' and ocpn_class_code ='"+occpnc_sv+"' and ocpn_code LIKE '%%' ORDER BY 2");	
	
                        oth_stmt = con.prepareStatement(sqlOcc.toString());
						oth_rset = oth_stmt.executeQuery();	
						while(oth_rset.next())
						{
						   String occuDesc1 = oth_rset.getString("SHORT_DESC");
						   String occuCode1 = oth_rset.getString("ocpn_code");
						   if(occ_of_per.equals(occuCode1))
								sel = "selected";
						   else
								sel="";
				    	   out.println("<option value='"+occuCode1+"' "+sel+">"+occuDesc1+"</option>");
						}
						 while(oth_rset.next())
						{
						   out.println("<Option value='" + oth_rset.getString("ocpn_code") + "'>" + oth_rset.getString("Short_Desc")+"</option>");
						}
					   if(oth_rset!= null) oth_rset.close() ;
					   if(oth_stmt!= null) oth_stmt.close() ;
					   if((sqlOcc != null) && (sqlOcc.length() > 0))
						{
							sqlOcc.delete(0,sqlOcc.length());
						}
						
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(ocpn_desc));
            _bw.write(_wl_block549Bytes, _wl_block549);

            if (_jsp__tag207(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block550Bytes, _wl_block550);

            if (_jsp__tag208(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block551Bytes, _wl_block551);
 String emp_stat_code =employment_status;
					       String emp_stat_desc = "";
					      if (emp_stat_code.equals("FE"))
		                  	   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeEmployed.label","mp_labels");
                          else if  (emp_stat_code.equals("FS"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeStudent.label","mp_labels");
						  else if  (emp_stat_code.equals("NA"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						  else if  (emp_stat_code.equals("PE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeEmployed.label","mp_labels");
    					  else if  (emp_stat_code.equals("PS"))
							   emp_stat_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeStudent.label","mp_labels");
						  else if  (emp_stat_code.equals("SE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels");
						  else if  (emp_stat_code.equals("UE"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels");
						  else if  (emp_stat_code.equals("UK"))
							   emp_stat_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						  if (employment_status != ""){
                          
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(employment_status));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(emp_stat_desc));
            _bw.write(_wl_block554Bytes, _wl_block554);
}
            _bw.write(_wl_block555Bytes, _wl_block555);

            if (_jsp__tag209(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block556Bytes, _wl_block556);

            if (_jsp__tag210(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block557Bytes, _wl_block557);

            if (_jsp__tag211(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block558Bytes, _wl_block558);

            if (_jsp__tag212(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block559Bytes, _wl_block559);

            if (_jsp__tag213(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block560Bytes, _wl_block560);

            if (_jsp__tag214(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block561Bytes, _wl_block561);

            if (_jsp__tag215(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block562Bytes, _wl_block562);

            if (_jsp__tag216(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block563Bytes, _wl_block563);

    if((episode.equals("Y") && record.equals("Y")) || (episode.equals("N") && record.equals("Y")))
    {
    
            _bw.write(_wl_block564Bytes, _wl_block564);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode"), weblogic.utils.StringUtils.valueOf(episode
                        )},{ weblogic.utils.StringUtils.valueOf("record"), weblogic.utils.StringUtils.valueOf(record
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("AE")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("E")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf("VISIT_REGISTRATION")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block566Bytes, _wl_block566);

    }
    else {
    
            _bw.write(_wl_block567Bytes, _wl_block567);
} 
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(reccnt));
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(visit_charge_stage));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(ChgToVisitorGrp));
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(outst_amt));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(HcExpired));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(invoke_from));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(frameRef));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(isMLCAppl));
            _bw.write(_wl_block579Bytes, _wl_block579);

     //Added for biling  
		
      if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") )
      {
            //calculate outstanding amount if outstanding amount > 0 then display at the end of patient line(blinking)          
           //if (outst_amt > 0) 
          //{
			  if(auth_win_reqd_yn.equals("Y") || !gen_remark.equals("")) {
              //Credit Authorisation screen is called.
              //out.println("<script>dispAuth1("+outst_amt+",'"+patient_id+"');</script>");
				  out.println("<script>setTimeout(function() {dispAuth1("+outst_amt+",'"+patient_id+"')}, 1500);</script>");
			  }
			  /*
				  Below code added for Scrum 10638
				*/
			  else
		  {
				
					  out.println("<script>funPatRegCharges('"+patient_id+"');</script>");

		  }
          //}
      }
      // End of Billing
	  boolean downtimePatient =CommonBean.isDownTimePatient(con,patient_id);//Rameswar on 05-Nov-15

	  /*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
	  String reg_date_time =CommonBean.getRegistrationDateTime(con,patient_id);//Dharma May 24,2016
	  if(!reg_date_time.equals("")){
		  reg_date_time = DateUtils.convertDate(reg_date_time,"DMYHMS","en",locale);
	  }
	 /*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/
		
try
  {
PreparedStatement refTypePstmt = null;
ResultSet refTypeRS = null;
PreparedStatement orgTypePstmt = null;
ResultSet orgTypeRS = null;
String 	from_ref_type="";
org_type_data="";
StringBuffer  refTypeSQL = new StringBuffer();	
StringBuffer  orgTypeSQL = new StringBuffer();
			if (!referal_id.equals(""))
            {
                // Insurance Expiry check 
                // Check whether package exists for the patient or not  
				  refTypeSQL.append("select from_ref_type from pr_referral_register where referral_id = ?");
				  refTypePstmt = con.prepareStatement( refTypeSQL.toString());
	              refTypePstmt.setString ( 1, referal_id ) ;
				  refTypeRS = refTypePstmt.executeQuery() ;
		            if(refTypeRS.next()) {
					from_ref_type = refTypeRS.getString( "from_ref_type");
					}
                
					if(from_ref_type.equals("E") || from_ref_type.equals("L")){
								
					org_type_data="G";				
					
					}else{
					
					orgTypeSQL.append("select org_type from pr_referral_register, am_referral where referral_id = ? and from_ref_code = referral_code");
					orgTypePstmt = con.prepareStatement( orgTypeSQL.toString());
	                orgTypePstmt.setString ( 1, referal_id ) ;
					orgTypeRS = orgTypePstmt.executeQuery() ;
		            if(orgTypeRS.next()) {
						org_type_data = orgTypeRS.getString( "org_type");
						if(org_type_data==null)  		
							org_type_data="";
					
					}
					}
					if (orgTypePstmt != null) orgTypePstmt.close();
                    if (orgTypeRS != null)   orgTypeRS.close();
					if (refTypePstmt != null) refTypePstmt.close();
                    if (refTypeRS != null)   refTypeRS.close();
					if((refTypeSQL != null) && (refTypeSQL.length() > 0))
					{
						refTypeSQL.delete(0,refTypeSQL.length());
					}
					if((orgTypeSQL != null) && (orgTypeSQL.length() > 0))
					{
						orgTypeSQL.delete(0,orgTypeSQL.length());
					}
            }
          }

          catch(Exception e) { /* out.println("Exception in Referral ID End="+e);	 */		e.printStackTrace();}
		
            _bw.write(_wl_block580Bytes, _wl_block580);
if(localeName.equals("en"))
			{
            _bw.write(_wl_block581Bytes, _wl_block581);
}
		  else if(localeName.equals("th"))
			{
            _bw.write(_wl_block582Bytes, _wl_block582);
}
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(isAENextofKinchngAppl));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(entitlement_by_cat_yn));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(patFlag));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(sysDateWithoutTime));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(buildEpisodeRule));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(paediatric_yn));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(gynaec_yn));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(nationality_id));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(downtimePatient));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(reg_date_time));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(org_type_data));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(isForm60Available));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(assigncareloctype));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(assigncare_location_code));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(isReferral));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(validationForPanCardAvail));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(isLabelChngAppl));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(isMechInjLabelChngAppl));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(isCaseDtlsRadioBtnAppl));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(isPriorityZoneAppl));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(resiAddMailAdd));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(isReconfirmCOTAppl));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(reconf_cot_param));
            _bw.write(_wl_block620Bytes, _wl_block620);

   }
    catch(Exception e)
    {
        //out.println("Exception in Main ="+e);
					e.printStackTrace();
    }
   }
   catch(Exception e)
   {
        //out.println("Exception in Main ="+e);
					e.printStackTrace();
   }
   finally
   {
	    ConnectionManager.returnConnection(con,request);
   }

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block621Bytes, _wl_block621);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.arrival.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RhFactor.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.LinkDelink.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounter.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RegistrationType.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.OandG.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaseofTrauma.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.oscc.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medical.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechOfMainInj.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MechanismofInjury.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MechaofSubInjury.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Critical.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Patient.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Case.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProtectiveDeviceUsed.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.broughtdead.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DeadOnArrival.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.MotorVehicleAccident.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfOccurrence.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeOfAccident.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PickupPlace.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfOccurrence.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PlaceOfAccident.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VehiclesInvolved.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PositionDuringIncident.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.VehicleRegNo.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.and.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MlcDeath.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceStationDetails.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OutMlcNoDtls.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateOfMlcCapture.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PrimaryTriageDetails.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Disaster.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterArea.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterReference.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisRegnReference.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referralfrom.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referralfrom.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PresentingProblem.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.arrival.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.EscortDetail.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AccompaniedBy.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AmbulanceDetails.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.NameofEscortService.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.EscAmbulanceContNo.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.VehicleRegNo.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.arrival.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }

    private boolean _jsp__tag128(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag128 = null ;
        int __result__tag128 = 0 ;

        if (__tag128 == null ){
            __tag128 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag128);
        }
        __tag128.setPageContext(pageContext);
        __tag128.setParent(null);
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag128;
        __result__tag128 = __tag128.doStartTag();

        if (__result__tag128!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag128== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag128.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag128);
            return true;
        }
        _activeTag=__tag128.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag128);
        __tag128.release();
        return false;
    }

    private boolean _jsp__tag129(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag129 = null ;
        int __result__tag129 = 0 ;

        if (__tag129 == null ){
            __tag129 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag129);
        }
        __tag129.setPageContext(pageContext);
        __tag129.setParent(null);
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag129;
        __result__tag129 = __tag129.doStartTag();

        if (__result__tag129!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag129== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag129.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag129);
            return true;
        }
        _activeTag=__tag129.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag129);
        __tag129.release();
        return false;
    }

    private boolean _jsp__tag130(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
        int __result__tag130 = 0 ;

        if (__tag130 == null ){
            __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
        }
        __tag130.setPageContext(pageContext);
        __tag130.setParent(null);
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag130;
        __result__tag130 = __tag130.doStartTag();

        if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag130);
            return true;
        }
        _activeTag=__tag130.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
        __tag130.release();
        return false;
    }

    private boolean _jsp__tag131(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
        int __result__tag131 = 0 ;

        if (__tag131 == null ){
            __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
        }
        __tag131.setPageContext(pageContext);
        __tag131.setParent(null);
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag131;
        __result__tag131 = __tag131.doStartTag();

        if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag131);
            return true;
        }
        _activeTag=__tag131.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
        __tag131.release();
        return false;
    }

    private boolean _jsp__tag132(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag132 = null ;
        int __result__tag132 = 0 ;

        if (__tag132 == null ){
            __tag132 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag132);
        }
        __tag132.setPageContext(pageContext);
        __tag132.setParent(null);
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag132;
        __result__tag132 = __tag132.doStartTag();

        if (__result__tag132!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag132== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag132.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag132);
            return true;
        }
        _activeTag=__tag132.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag132);
        __tag132.release();
        return false;
    }

    private boolean _jsp__tag133(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag133 = null ;
        int __result__tag133 = 0 ;

        if (__tag133 == null ){
            __tag133 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag133);
        }
        __tag133.setPageContext(pageContext);
        __tag133.setParent(null);
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag133;
        __result__tag133 = __tag133.doStartTag();

        if (__result__tag133!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag133== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag133.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag133);
            return true;
        }
        _activeTag=__tag133.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag133);
        __tag133.release();
        return false;
    }

    private boolean _jsp__tag134(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag134 = null ;
        int __result__tag134 = 0 ;

        if (__tag134 == null ){
            __tag134 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag134);
        }
        __tag134.setPageContext(pageContext);
        __tag134.setParent(null);
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag134;
        __result__tag134 = __tag134.doStartTag();

        if (__result__tag134!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag134== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag134.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag134);
            return true;
        }
        _activeTag=__tag134.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag134);
        __tag134.release();
        return false;
    }

    private boolean _jsp__tag135(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag135 = null ;
        int __result__tag135 = 0 ;

        if (__tag135 == null ){
            __tag135 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag135);
        }
        __tag135.setPageContext(pageContext);
        __tag135.setParent(null);
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag135;
        __result__tag135 = __tag135.doStartTag();

        if (__result__tag135!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag135== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag135.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag135);
            return true;
        }
        _activeTag=__tag135.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag135);
        __tag135.release();
        return false;
    }

    private boolean _jsp__tag136(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag136 = null ;
        int __result__tag136 = 0 ;

        if (__tag136 == null ){
            __tag136 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag136);
        }
        __tag136.setPageContext(pageContext);
        __tag136.setParent(null);
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPerson.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag136;
        __result__tag136 = __tag136.doStartTag();

        if (__result__tag136!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag136== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag136.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag136);
            return true;
        }
        _activeTag=__tag136.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag136);
        __tag136.release();
        return false;
    }

    private boolean _jsp__tag137(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag137 = null ;
        int __result__tag137 = 0 ;

        if (__tag137 == null ){
            __tag137 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag137);
        }
        __tag137.setPageContext(pageContext);
        __tag137.setParent(null);
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyFirsttoNotify.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag137;
        __result__tag137 = __tag137.doStartTag();

        if (__result__tag137!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag137== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag137.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag137);
            return true;
        }
        _activeTag=__tag137.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag137);
        __tag137.release();
        return false;
    }

    private boolean _jsp__tag138(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag138 = null ;
        int __result__tag138 = 0 ;

        if (__tag138 == null ){
            __tag138 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag138);
        }
        __tag138.setPageContext(pageContext);
        __tag138.setParent(null);
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag138;
        __result__tag138 = __tag138.doStartTag();

        if (__result__tag138!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag138== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag138.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag138);
            return true;
        }
        _activeTag=__tag138.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag138);
        __tag138.release();
        return false;
    }

    private boolean _jsp__tag139(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag139 = null ;
        int __result__tag139 = 0 ;

        if (__tag139 == null ){
            __tag139 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag139);
        }
        __tag139.setPageContext(pageContext);
        __tag139.setParent(null);
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag139;
        __result__tag139 = __tag139.doStartTag();

        if (__result__tag139!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag139== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag139.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag139);
            return true;
        }
        _activeTag=__tag139.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag139);
        __tag139.release();
        return false;
    }

    private boolean _jsp__tag140(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag140 = null ;
        int __result__tag140 = 0 ;

        if (__tag140 == null ){
            __tag140 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag140);
        }
        __tag140.setPageContext(pageContext);
        __tag140.setParent(null);
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag140;
        __result__tag140 = __tag140.doStartTag();

        if (__result__tag140!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag140== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag140.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag140);
            return true;
        }
        _activeTag=__tag140.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag140);
        __tag140.release();
        return false;
    }

    private boolean _jsp__tag141(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag141 = null ;
        int __result__tag141 = 0 ;

        if (__tag141 == null ){
            __tag141 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag141);
        }
        __tag141.setPageContext(pageContext);
        __tag141.setParent(null);
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag141;
        __result__tag141 = __tag141.doStartTag();

        if (__result__tag141!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag141== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag141.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag141);
            return true;
        }
        _activeTag=__tag141.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag141);
        __tag141.release();
        return false;
    }

    private boolean _jsp__tag142(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag142 = null ;
        int __result__tag142 = 0 ;

        if (__tag142 == null ){
            __tag142 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag142);
        }
        __tag142.setPageContext(pageContext);
        __tag142.setParent(null);
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag142;
        __result__tag142 = __tag142.doStartTag();

        if (__result__tag142!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag142== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag142.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag142);
            return true;
        }
        _activeTag=__tag142.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag142);
        __tag142.release();
        return false;
    }

    private boolean _jsp__tag143(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag143 = null ;
        int __result__tag143 = 0 ;

        if (__tag143 == null ){
            __tag143 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag143);
        }
        __tag143.setPageContext(pageContext);
        __tag143.setParent(null);
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag143;
        __result__tag143 = __tag143.doStartTag();

        if (__result__tag143!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag143== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag143.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag143);
            return true;
        }
        _activeTag=__tag143.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag143);
        __tag143.release();
        return false;
    }

    private boolean _jsp__tag144(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag144 = null ;
        int __result__tag144 = 0 ;

        if (__tag144 == null ){
            __tag144 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag144);
        }
        __tag144.setPageContext(pageContext);
        __tag144.setParent(null);
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag144;
        __result__tag144 = __tag144.doStartTag();

        if (__result__tag144!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag144== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag144.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag144);
            return true;
        }
        _activeTag=__tag144.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag144);
        __tag144.release();
        return false;
    }

    private boolean _jsp__tag145(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag145 = null ;
        int __result__tag145 = 0 ;

        if (__tag145 == null ){
            __tag145 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag145);
        }
        __tag145.setPageContext(pageContext);
        __tag145.setParent(null);
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag145;
        __result__tag145 = __tag145.doStartTag();

        if (__result__tag145!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag145== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag145.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag145);
            return true;
        }
        _activeTag=__tag145.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag145);
        __tag145.release();
        return false;
    }

    private boolean _jsp__tag146(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag146 = null ;
        int __result__tag146 = 0 ;

        if (__tag146 == null ){
            __tag146 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag146);
        }
        __tag146.setPageContext(pageContext);
        __tag146.setParent(null);
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag146;
        __result__tag146 = __tag146.doStartTag();

        if (__result__tag146!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag146== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag146.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag146);
            return true;
        }
        _activeTag=__tag146.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag146);
        __tag146.release();
        return false;
    }

    private boolean _jsp__tag147(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag147 = null ;
        int __result__tag147 = 0 ;

        if (__tag147 == null ){
            __tag147 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag147);
        }
        __tag147.setPageContext(pageContext);
        __tag147.setParent(null);
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag147;
        __result__tag147 = __tag147.doStartTag();

        if (__result__tag147!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag147== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag147.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag147);
            return true;
        }
        _activeTag=__tag147.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag147);
        __tag147.release();
        return false;
    }

    private boolean _jsp__tag148(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag148 = null ;
        int __result__tag148 = 0 ;

        if (__tag148 == null ){
            __tag148 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag148);
        }
        __tag148.setPageContext(pageContext);
        __tag148.setParent(null);
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag148;
        __result__tag148 = __tag148.doStartTag();

        if (__result__tag148!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag148== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag148.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag148);
            return true;
        }
        _activeTag=__tag148.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag148);
        __tag148.release();
        return false;
    }

    private boolean _jsp__tag149(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag149 = null ;
        int __result__tag149 = 0 ;

        if (__tag149 == null ){
            __tag149 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag149);
        }
        __tag149.setPageContext(pageContext);
        __tag149.setParent(null);
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag149;
        __result__tag149 = __tag149.doStartTag();

        if (__result__tag149!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag149== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag149.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag149);
            return true;
        }
        _activeTag=__tag149.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag149);
        __tag149.release();
        return false;
    }

    private boolean _jsp__tag150(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag150 = null ;
        int __result__tag150 = 0 ;

        if (__tag150 == null ){
            __tag150 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag150);
        }
        __tag150.setPageContext(pageContext);
        __tag150.setParent(null);
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag150;
        __result__tag150 = __tag150.doStartTag();

        if (__result__tag150!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag150== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag150.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag150);
            return true;
        }
        _activeTag=__tag150.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag150);
        __tag150.release();
        return false;
    }

    private boolean _jsp__tag151(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag151 = null ;
        int __result__tag151 = 0 ;

        if (__tag151 == null ){
            __tag151 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag151);
        }
        __tag151.setPageContext(pageContext);
        __tag151.setParent(null);
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag151;
        __result__tag151 = __tag151.doStartTag();

        if (__result__tag151!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag151== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag151.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag151);
            return true;
        }
        _activeTag=__tag151.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag151);
        __tag151.release();
        return false;
    }

    private boolean _jsp__tag152(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag152 = null ;
        int __result__tag152 = 0 ;

        if (__tag152 == null ){
            __tag152 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag152);
        }
        __tag152.setPageContext(pageContext);
        __tag152.setParent(null);
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.arrival.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag152;
        __result__tag152 = __tag152.doStartTag();

        if (__result__tag152!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag152== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag152.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag152);
            return true;
        }
        _activeTag=__tag152.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag152);
        __tag152.release();
        return false;
    }

    private boolean _jsp__tag153(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag153 = null ;
        int __result__tag153 = 0 ;

        if (__tag153 == null ){
            __tag153 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag153);
        }
        __tag153.setPageContext(pageContext);
        __tag153.setParent(null);
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag153.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag153;
        __result__tag153 = __tag153.doStartTag();

        if (__result__tag153!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag153== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag153.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag153);
            return true;
        }
        _activeTag=__tag153.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag153);
        __tag153.release();
        return false;
    }

    private boolean _jsp__tag154(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag154 = null ;
        int __result__tag154 = 0 ;

        if (__tag154 == null ){
            __tag154 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag154);
        }
        __tag154.setPageContext(pageContext);
        __tag154.setParent(null);
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag154;
        __result__tag154 = __tag154.doStartTag();

        if (__result__tag154!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag154== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag154.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag154);
            return true;
        }
        _activeTag=__tag154.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag154);
        __tag154.release();
        return false;
    }

    private boolean _jsp__tag155(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag155 = null ;
        int __result__tag155 = 0 ;

        if (__tag155 == null ){
            __tag155 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag155);
        }
        __tag155.setPageContext(pageContext);
        __tag155.setParent(null);
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag155;
        __result__tag155 = __tag155.doStartTag();

        if (__result__tag155!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag155== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag155.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag155);
            return true;
        }
        _activeTag=__tag155.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag155);
        __tag155.release();
        return false;
    }

    private boolean _jsp__tag156(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag156 = null ;
        int __result__tag156 = 0 ;

        if (__tag156 == null ){
            __tag156 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag156);
        }
        __tag156.setPageContext(pageContext);
        __tag156.setParent(null);
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag156;
        __result__tag156 = __tag156.doStartTag();

        if (__result__tag156!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag156== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag156.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag156);
            return true;
        }
        _activeTag=__tag156.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag156);
        __tag156.release();
        return false;
    }

    private boolean _jsp__tag157(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag157 = null ;
        int __result__tag157 = 0 ;

        if (__tag157 == null ){
            __tag157 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag157);
        }
        __tag157.setPageContext(pageContext);
        __tag157.setParent(null);
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag157;
        __result__tag157 = __tag157.doStartTag();

        if (__result__tag157!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag157== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag157.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag157);
            return true;
        }
        _activeTag=__tag157.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag157);
        __tag157.release();
        return false;
    }

    private boolean _jsp__tag158(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag158 = null ;
        int __result__tag158 = 0 ;

        if (__tag158 == null ){
            __tag158 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag158);
        }
        __tag158.setPageContext(pageContext);
        __tag158.setParent(null);
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag158.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag158;
        __result__tag158 = __tag158.doStartTag();

        if (__result__tag158!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag158== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag158.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag158);
            return true;
        }
        _activeTag=__tag158.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag158);
        __tag158.release();
        return false;
    }

    private boolean _jsp__tag159(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag159 = null ;
        int __result__tag159 = 0 ;

        if (__tag159 == null ){
            __tag159 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag159);
        }
        __tag159.setPageContext(pageContext);
        __tag159.setParent(null);
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag159.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag159;
        __result__tag159 = __tag159.doStartTag();

        if (__result__tag159!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag159== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag159.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag159);
            return true;
        }
        _activeTag=__tag159.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag159);
        __tag159.release();
        return false;
    }

    private boolean _jsp__tag160(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag160 = null ;
        int __result__tag160 = 0 ;

        if (__tag160 == null ){
            __tag160 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag160);
        }
        __tag160.setPageContext(pageContext);
        __tag160.setParent(null);
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag160.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag160;
        __result__tag160 = __tag160.doStartTag();

        if (__result__tag160!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag160== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag160.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag160);
            return true;
        }
        _activeTag=__tag160.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag160);
        __tag160.release();
        return false;
    }

    private boolean _jsp__tag161(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag161 = null ;
        int __result__tag161 = 0 ;

        if (__tag161 == null ){
            __tag161 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag161);
        }
        __tag161.setPageContext(pageContext);
        __tag161.setParent(null);
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag161;
        __result__tag161 = __tag161.doStartTag();

        if (__result__tag161!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag161== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag161.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag161);
            return true;
        }
        _activeTag=__tag161.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag161);
        __tag161.release();
        return false;
    }

    private boolean _jsp__tag162(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag162 = null ;
        int __result__tag162 = 0 ;

        if (__tag162 == null ){
            __tag162 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag162);
        }
        __tag162.setPageContext(pageContext);
        __tag162.setParent(null);
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag162;
        __result__tag162 = __tag162.doStartTag();

        if (__result__tag162!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag162== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag162.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag162);
            return true;
        }
        _activeTag=__tag162.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag162);
        __tag162.release();
        return false;
    }

    private boolean _jsp__tag163(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag163 = null ;
        int __result__tag163 = 0 ;

        if (__tag163 == null ){
            __tag163 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag163);
        }
        __tag163.setPageContext(pageContext);
        __tag163.setParent(null);
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag163;
        __result__tag163 = __tag163.doStartTag();

        if (__result__tag163!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag163== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag163.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag163);
            return true;
        }
        _activeTag=__tag163.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag163);
        __tag163.release();
        return false;
    }

    private boolean _jsp__tag164(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag164 = null ;
        int __result__tag164 = 0 ;

        if (__tag164 == null ){
            __tag164 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag164);
        }
        __tag164.setPageContext(pageContext);
        __tag164.setParent(null);
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag164;
        __result__tag164 = __tag164.doStartTag();

        if (__result__tag164!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag164== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag164.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag164);
            return true;
        }
        _activeTag=__tag164.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag164);
        __tag164.release();
        return false;
    }

    private boolean _jsp__tag165(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag165 = null ;
        int __result__tag165 = 0 ;

        if (__tag165 == null ){
            __tag165 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag165);
        }
        __tag165.setPageContext(pageContext);
        __tag165.setParent(null);
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag165;
        __result__tag165 = __tag165.doStartTag();

        if (__result__tag165!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag165== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag165.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag165);
            return true;
        }
        _activeTag=__tag165.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag165);
        __tag165.release();
        return false;
    }

    private boolean _jsp__tag166(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag166 = null ;
        int __result__tag166 = 0 ;

        if (__tag166 == null ){
            __tag166 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag166);
        }
        __tag166.setPageContext(pageContext);
        __tag166.setParent(null);
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag166;
        __result__tag166 = __tag166.doStartTag();

        if (__result__tag166!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag166== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag166.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag166);
            return true;
        }
        _activeTag=__tag166.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag166);
        __tag166.release();
        return false;
    }

    private boolean _jsp__tag167(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag167 = null ;
        int __result__tag167 = 0 ;

        if (__tag167 == null ){
            __tag167 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag167);
        }
        __tag167.setPageContext(pageContext);
        __tag167.setParent(null);
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag167;
        __result__tag167 = __tag167.doStartTag();

        if (__result__tag167!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag167== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag167.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag167);
            return true;
        }
        _activeTag=__tag167.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag167);
        __tag167.release();
        return false;
    }

    private boolean _jsp__tag168(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag168 = null ;
        int __result__tag168 = 0 ;

        if (__tag168 == null ){
            __tag168 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag168);
        }
        __tag168.setPageContext(pageContext);
        __tag168.setParent(null);
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag168;
        __result__tag168 = __tag168.doStartTag();

        if (__result__tag168!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag168== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag168.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag168);
            return true;
        }
        _activeTag=__tag168.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag168);
        __tag168.release();
        return false;
    }

    private boolean _jsp__tag169(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag169 = null ;
        int __result__tag169 = 0 ;

        if (__tag169 == null ){
            __tag169 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag169);
        }
        __tag169.setPageContext(pageContext);
        __tag169.setParent(null);
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag169;
        __result__tag169 = __tag169.doStartTag();

        if (__result__tag169!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag169== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag169.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag169);
            return true;
        }
        _activeTag=__tag169.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag169);
        __tag169.release();
        return false;
    }

    private boolean _jsp__tag170(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag170 = null ;
        int __result__tag170 = 0 ;

        if (__tag170 == null ){
            __tag170 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag170);
        }
        __tag170.setPageContext(pageContext);
        __tag170.setParent(null);
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag170;
        __result__tag170 = __tag170.doStartTag();

        if (__result__tag170!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag170== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag170.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag170);
            return true;
        }
        _activeTag=__tag170.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag170);
        __tag170.release();
        return false;
    }

    private boolean _jsp__tag171(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag171 = null ;
        int __result__tag171 = 0 ;

        if (__tag171 == null ){
            __tag171 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag171);
        }
        __tag171.setPageContext(pageContext);
        __tag171.setParent(null);
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
        __tag171.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag171;
        __result__tag171 = __tag171.doStartTag();

        if (__result__tag171!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag171== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag171.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag171);
            return true;
        }
        _activeTag=__tag171.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag171);
        __tag171.release();
        return false;
    }

    private boolean _jsp__tag172(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag172 = null ;
        int __result__tag172 = 0 ;

        if (__tag172 == null ){
            __tag172 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag172);
        }
        __tag172.setPageContext(pageContext);
        __tag172.setParent(null);
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag172;
        __result__tag172 = __tag172.doStartTag();

        if (__result__tag172!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag172== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag172.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag172);
            return true;
        }
        _activeTag=__tag172.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag172);
        __tag172.release();
        return false;
    }

    private boolean _jsp__tag173(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag173 = null ;
        int __result__tag173 = 0 ;

        if (__tag173 == null ){
            __tag173 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag173);
        }
        __tag173.setPageContext(pageContext);
        __tag173.setParent(null);
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPerson.label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag173;
        __result__tag173 = __tag173.doStartTag();

        if (__result__tag173!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag173== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag173.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag173);
            return true;
        }
        _activeTag=__tag173.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag173);
        __tag173.release();
        return false;
    }

    private boolean _jsp__tag174(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag174 = null ;
        int __result__tag174 = 0 ;

        if (__tag174 == null ){
            __tag174 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag174);
        }
        __tag174.setPageContext(pageContext);
        __tag174.setParent(null);
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag174;
        __result__tag174 = __tag174.doStartTag();

        if (__result__tag174!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag174== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag174.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag174);
            return true;
        }
        _activeTag=__tag174.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag174);
        __tag174.release();
        return false;
    }

    private boolean _jsp__tag175(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag175 = null ;
        int __result__tag175 = 0 ;

        if (__tag175 == null ){
            __tag175 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag175);
        }
        __tag175.setPageContext(pageContext);
        __tag175.setParent(null);
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag175;
        __result__tag175 = __tag175.doStartTag();

        if (__result__tag175!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag175== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag175.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag175);
            return true;
        }
        _activeTag=__tag175.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag175);
        __tag175.release();
        return false;
    }

    private boolean _jsp__tag176(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag176 = null ;
        int __result__tag176 = 0 ;

        if (__tag176 == null ){
            __tag176 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag176);
        }
        __tag176.setPageContext(pageContext);
        __tag176.setParent(null);
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag176.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag176;
        __result__tag176 = __tag176.doStartTag();

        if (__result__tag176!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag176== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag176.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag176);
            return true;
        }
        _activeTag=__tag176.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag176);
        __tag176.release();
        return false;
    }

    private boolean _jsp__tag177(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag177 = null ;
        int __result__tag177 = 0 ;

        if (__tag177 == null ){
            __tag177 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag177);
        }
        __tag177.setPageContext(pageContext);
        __tag177.setParent(null);
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag177.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag177;
        __result__tag177 = __tag177.doStartTag();

        if (__result__tag177!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag177== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag177.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag177);
            return true;
        }
        _activeTag=__tag177.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag177);
        __tag177.release();
        return false;
    }

    private boolean _jsp__tag178(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag178 = null ;
        int __result__tag178 = 0 ;

        if (__tag178 == null ){
            __tag178 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag178);
        }
        __tag178.setPageContext(pageContext);
        __tag178.setParent(null);
        __tag178.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag178.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag178;
        __result__tag178 = __tag178.doStartTag();

        if (__result__tag178!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag178== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag178.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag178);
            return true;
        }
        _activeTag=__tag178.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag178);
        __tag178.release();
        return false;
    }

    private boolean _jsp__tag179(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag179 = null ;
        int __result__tag179 = 0 ;

        if (__tag179 == null ){
            __tag179 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag179);
        }
        __tag179.setPageContext(pageContext);
        __tag179.setParent(null);
        __tag179.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag179.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag179;
        __result__tag179 = __tag179.doStartTag();

        if (__result__tag179!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag179== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag179.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag179);
            return true;
        }
        _activeTag=__tag179.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag179);
        __tag179.release();
        return false;
    }

    private boolean _jsp__tag180(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag180 = null ;
        int __result__tag180 = 0 ;

        if (__tag180 == null ){
            __tag180 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag180);
        }
        __tag180.setPageContext(pageContext);
        __tag180.setParent(null);
        __tag180.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag180.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag180;
        __result__tag180 = __tag180.doStartTag();

        if (__result__tag180!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag180== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag180.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag180);
            return true;
        }
        _activeTag=__tag180.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag180);
        __tag180.release();
        return false;
    }

    private boolean _jsp__tag181(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag181 = null ;
        int __result__tag181 = 0 ;

        if (__tag181 == null ){
            __tag181 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag181);
        }
        __tag181.setPageContext(pageContext);
        __tag181.setParent(null);
        __tag181.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag181.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag181;
        __result__tag181 = __tag181.doStartTag();

        if (__result__tag181!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag181== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag181.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag181);
            return true;
        }
        _activeTag=__tag181.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag181);
        __tag181.release();
        return false;
    }

    private boolean _jsp__tag182(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag182 = null ;
        int __result__tag182 = 0 ;

        if (__tag182 == null ){
            __tag182 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag182);
        }
        __tag182.setPageContext(pageContext);
        __tag182.setParent(null);
        __tag182.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag182.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag182;
        __result__tag182 = __tag182.doStartTag();

        if (__result__tag182!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag182== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag182.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag182);
            return true;
        }
        _activeTag=__tag182.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag182);
        __tag182.release();
        return false;
    }

    private boolean _jsp__tag183(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag183 = null ;
        int __result__tag183 = 0 ;

        if (__tag183 == null ){
            __tag183 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag183);
        }
        __tag183.setPageContext(pageContext);
        __tag183.setParent(null);
        __tag183.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag183.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag183;
        __result__tag183 = __tag183.doStartTag();

        if (__result__tag183!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag183== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag183.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag183);
            return true;
        }
        _activeTag=__tag183.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag183);
        __tag183.release();
        return false;
    }

    private boolean _jsp__tag184(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag184 = null ;
        int __result__tag184 = 0 ;

        if (__tag184 == null ){
            __tag184 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag184);
        }
        __tag184.setPageContext(pageContext);
        __tag184.setParent(null);
        __tag184.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag184.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag184;
        __result__tag184 = __tag184.doStartTag();

        if (__result__tag184!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag184== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag184.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag184);
            return true;
        }
        _activeTag=__tag184.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag184);
        __tag184.release();
        return false;
    }

    private boolean _jsp__tag185(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag185 = null ;
        int __result__tag185 = 0 ;

        if (__tag185 == null ){
            __tag185 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag185);
        }
        __tag185.setPageContext(pageContext);
        __tag185.setParent(null);
        __tag185.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag185.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag185;
        __result__tag185 = __tag185.doStartTag();

        if (__result__tag185!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag185== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag185.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag185);
            return true;
        }
        _activeTag=__tag185.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag185);
        __tag185.release();
        return false;
    }

    private boolean _jsp__tag186(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag186 = null ;
        int __result__tag186 = 0 ;

        if (__tag186 == null ){
            __tag186 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag186);
        }
        __tag186.setPageContext(pageContext);
        __tag186.setParent(null);
        __tag186.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag186.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag186;
        __result__tag186 = __tag186.doStartTag();

        if (__result__tag186!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag186== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag186.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag186);
            return true;
        }
        _activeTag=__tag186.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag186);
        __tag186.release();
        return false;
    }

    private boolean _jsp__tag187(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag187 = null ;
        int __result__tag187 = 0 ;

        if (__tag187 == null ){
            __tag187 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag187);
        }
        __tag187.setPageContext(pageContext);
        __tag187.setParent(null);
        __tag187.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag187.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag187;
        __result__tag187 = __tag187.doStartTag();

        if (__result__tag187!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag187== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag187.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag187);
            return true;
        }
        _activeTag=__tag187.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag187);
        __tag187.release();
        return false;
    }

    private boolean _jsp__tag188(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag188 = null ;
        int __result__tag188 = 0 ;

        if (__tag188 == null ){
            __tag188 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag188);
        }
        __tag188.setPageContext(pageContext);
        __tag188.setParent(null);
        __tag188.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDetail.label", java.lang.String .class,"key"));
        __tag188.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag188;
        __result__tag188 = __tag188.doStartTag();

        if (__result__tag188!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag188== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag188.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag188);
            return true;
        }
        _activeTag=__tag188.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag188);
        __tag188.release();
        return false;
    }

    private boolean _jsp__tag189(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag189 = null ;
        int __result__tag189 = 0 ;

        if (__tag189 == null ){
            __tag189 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag189);
        }
        __tag189.setPageContext(pageContext);
        __tag189.setParent(null);
        __tag189.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.arrival.label", java.lang.String .class,"key"));
        __tag189.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag189;
        __result__tag189 = __tag189.doStartTag();

        if (__result__tag189!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag189== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag189.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag189);
            return true;
        }
        _activeTag=__tag189.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag189);
        __tag189.release();
        return false;
    }

    private boolean _jsp__tag190(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag190 = null ;
        int __result__tag190 = 0 ;

        if (__tag190 == null ){
            __tag190 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag190);
        }
        __tag190.setPageContext(pageContext);
        __tag190.setParent(null);
        __tag190.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedcontacts.label", java.lang.String .class,"key"));
        __tag190.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag190;
        __result__tag190 = __tag190.doStartTag();

        if (__result__tag190!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag190== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag190.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag190);
            return true;
        }
        _activeTag=__tag190.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag190);
        __tag190.release();
        return false;
    }

    private boolean _jsp__tag191(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag191 = null ;
        int __result__tag191 = 0 ;

        if (__tag191 == null ){
            __tag191 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag191);
        }
        __tag191.setPageContext(pageContext);
        __tag191.setParent(null);
        __tag191.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag191.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag191;
        __result__tag191 = __tag191.doStartTag();

        if (__result__tag191!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag191== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag191.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag191);
            return true;
        }
        _activeTag=__tag191.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag191);
        __tag191.release();
        return false;
    }

    private boolean _jsp__tag192(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag192 = null ;
        int __result__tag192 = 0 ;

        if (__tag192 == null ){
            __tag192 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag192);
        }
        __tag192.setPageContext(pageContext);
        __tag192.setParent(null);
        __tag192.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag192.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag192;
        __result__tag192 = __tag192.doStartTag();

        if (__result__tag192!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag192== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag192.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag192);
            return true;
        }
        _activeTag=__tag192.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag192);
        __tag192.release();
        return false;
    }

    private boolean _jsp__tag193(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag193 = null ;
        int __result__tag193 = 0 ;

        if (__tag193 == null ){
            __tag193 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag193);
        }
        __tag193.setPageContext(pageContext);
        __tag193.setParent(null);
        __tag193.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
        __tag193.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag193;
        __result__tag193 = __tag193.doStartTag();

        if (__result__tag193!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag193== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag193.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag193);
            return true;
        }
        _activeTag=__tag193.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag193);
        __tag193.release();
        return false;
    }

    private boolean _jsp__tag194(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag194 = null ;
        int __result__tag194 = 0 ;

        if (__tag194 == null ){
            __tag194 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag194);
        }
        __tag194.setPageContext(pageContext);
        __tag194.setParent(null);
        __tag194.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag194.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag194;
        __result__tag194 = __tag194.doStartTag();

        if (__result__tag194!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag194== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag194.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag194);
            return true;
        }
        _activeTag=__tag194.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag194);
        __tag194.release();
        return false;
    }

    private boolean _jsp__tag195(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag195 = null ;
        int __result__tag195 = 0 ;

        if (__tag195 == null ){
            __tag195 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag195);
        }
        __tag195.setPageContext(pageContext);
        __tag195.setParent(null);
        __tag195.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employerdetails.label", java.lang.String .class,"key"));
        __tag195.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag195;
        __result__tag195 = __tag195.doStartTag();

        if (__result__tag195!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag195== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag195.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag195);
            return true;
        }
        _activeTag=__tag195.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag195);
        __tag195.release();
        return false;
    }

    private boolean _jsp__tag196(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag196 = null ;
        int __result__tag196 = 0 ;

        if (__tag196 == null ){
            __tag196 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag196);
        }
        __tag196.setPageContext(pageContext);
        __tag196.setParent(null);
        __tag196.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employeedetails.label", java.lang.String .class,"key"));
        __tag196.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag196;
        __result__tag196 = __tag196.doStartTag();

        if (__result__tag196!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag196== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag196.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag196);
            return true;
        }
        _activeTag=__tag196.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag196);
        __tag196.release();
        return false;
    }

    private boolean _jsp__tag197(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag197 = null ;
        int __result__tag197 = 0 ;

        if (__tag197 == null ){
            __tag197 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag197);
        }
        __tag197.setPageContext(pageContext);
        __tag197.setParent(null);
        __tag197.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orgName.label", java.lang.String .class,"key"));
        __tag197.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag197;
        __result__tag197 = __tag197.doStartTag();

        if (__result__tag197!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag197== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag197.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag197);
            return true;
        }
        _activeTag=__tag197.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag197);
        __tag197.release();
        return false;
    }

    private boolean _jsp__tag198(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag198 = null ;
        int __result__tag198 = 0 ;

        if (__tag198 == null ){
            __tag198 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag198);
        }
        __tag198.setPageContext(pageContext);
        __tag198.setParent(null);
        __tag198.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPersonName.label", java.lang.String .class,"key"));
        __tag198.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag198;
        __result__tag198 = __tag198.doStartTag();

        if (__result__tag198!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag198== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag198.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag198);
            return true;
        }
        _activeTag=__tag198.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag198);
        __tag198.release();
        return false;
    }

    private boolean _jsp__tag199(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag199 = null ;
        int __result__tag199 = 0 ;

        if (__tag199 == null ){
            __tag199 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag199);
        }
        __tag199.setPageContext(pageContext);
        __tag199.setParent(null);
        __tag199.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag199.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag199;
        __result__tag199 = __tag199.doStartTag();

        if (__result__tag199!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag199== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag199.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag199);
            return true;
        }
        _activeTag=__tag199.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag199);
        __tag199.release();
        return false;
    }

    private boolean _jsp__tag200(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag200 = null ;
        int __result__tag200 = 0 ;

        if (__tag200 == null ){
            __tag200 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag200);
        }
        __tag200.setPageContext(pageContext);
        __tag200.setParent(null);
        __tag200.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag200.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag200;
        __result__tag200 = __tag200.doStartTag();

        if (__result__tag200!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag200== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag200.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag200);
            return true;
        }
        _activeTag=__tag200.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag200);
        __tag200.release();
        return false;
    }

    private boolean _jsp__tag201(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag201 = null ;
        int __result__tag201 = 0 ;

        if (__tag201 == null ){
            __tag201 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag201);
        }
        __tag201.setPageContext(pageContext);
        __tag201.setParent(null);
        __tag201.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag201.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag201;
        __result__tag201 = __tag201.doStartTag();

        if (__result__tag201!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag201== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag201.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag201);
            return true;
        }
        _activeTag=__tag201.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag201);
        __tag201.release();
        return false;
    }

    private boolean _jsp__tag202(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag202 = null ;
        int __result__tag202 = 0 ;

        if (__tag202 == null ){
            __tag202 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag202);
        }
        __tag202.setPageContext(pageContext);
        __tag202.setParent(null);
        __tag202.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentid.label", java.lang.String .class,"key"));
        __tag202.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag202;
        __result__tag202 = __tag202.doStartTag();

        if (__result__tag202!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag202== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag202.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag202);
            return true;
        }
        _activeTag=__tag202.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag202);
        __tag202.release();
        return false;
    }

    private boolean _jsp__tag203(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag203 = null ;
        int __result__tag203 = 0 ;

        if (__tag203 == null ){
            __tag203 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag203);
        }
        __tag203.setPageContext(pageContext);
        __tag203.setParent(null);
        __tag203.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag203.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag203;
        __result__tag203 = __tag203.doStartTag();

        if (__result__tag203!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag203== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag203.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag203);
            return true;
        }
        _activeTag=__tag203.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag203);
        __tag203.release();
        return false;
    }

    private boolean _jsp__tag204(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag204 = null ;
        int __result__tag204 = 0 ;

        if (__tag204 == null ){
            __tag204 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag204);
        }
        __tag204.setPageContext(pageContext);
        __tag204.setParent(null);
        __tag204.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag204.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag204;
        __result__tag204 = __tag204.doStartTag();

        if (__result__tag204!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag204== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag204.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag204);
            return true;
        }
        _activeTag=__tag204.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag204);
        __tag204.release();
        return false;
    }

    private boolean _jsp__tag205(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag205 = null ;
        int __result__tag205 = 0 ;

        if (__tag205 == null ){
            __tag205 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag205);
        }
        __tag205.setPageContext(pageContext);
        __tag205.setParent(null);
        __tag205.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationofthePerson.label", java.lang.String .class,"key"));
        __tag205.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag205;
        __result__tag205 = __tag205.doStartTag();

        if (__result__tag205!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag205== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag205.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag205);
            return true;
        }
        _activeTag=__tag205.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag205);
        __tag205.release();
        return false;
    }

    private boolean _jsp__tag206(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag206 = null ;
        int __result__tag206 = 0 ;

        if (__tag206 == null ){
            __tag206 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag206);
        }
        __tag206.setPageContext(pageContext);
        __tag206.setParent(null);
        __tag206.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag206.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag206;
        __result__tag206 = __tag206.doStartTag();

        if (__result__tag206!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag206== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag206.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag206);
            return true;
        }
        _activeTag=__tag206.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag206);
        __tag206.release();
        return false;
    }

    private boolean _jsp__tag207(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag207 = null ;
        int __result__tag207 = 0 ;

        if (__tag207 == null ){
            __tag207 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag207);
        }
        __tag207.setPageContext(pageContext);
        __tag207.setParent(null);
        __tag207.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag207.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag207;
        __result__tag207 = __tag207.doStartTag();

        if (__result__tag207!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag207== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag207.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag207);
            return true;
        }
        _activeTag=__tag207.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag207);
        __tag207.release();
        return false;
    }

    private boolean _jsp__tag208(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag208 = null ;
        int __result__tag208 = 0 ;

        if (__tag208 == null ){
            __tag208 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag208);
        }
        __tag208.setPageContext(pageContext);
        __tag208.setParent(null);
        __tag208.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag208.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag208;
        __result__tag208 = __tag208.doStartTag();

        if (__result__tag208!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag208== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag208.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag208);
            return true;
        }
        _activeTag=__tag208.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag208);
        __tag208.release();
        return false;
    }

    private boolean _jsp__tag209(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag209 = null ;
        int __result__tag209 = 0 ;

        if (__tag209 == null ){
            __tag209 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag209);
        }
        __tag209.setPageContext(pageContext);
        __tag209.setParent(null);
        __tag209.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FullTimeEmployed.label", java.lang.String .class,"key"));
        __tag209.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag209;
        __result__tag209 = __tag209.doStartTag();

        if (__result__tag209!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag209== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag209.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag209);
            return true;
        }
        _activeTag=__tag209.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag209);
        __tag209.release();
        return false;
    }

    private boolean _jsp__tag210(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag210 = null ;
        int __result__tag210 = 0 ;

        if (__tag210 == null ){
            __tag210 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag210);
        }
        __tag210.setPageContext(pageContext);
        __tag210.setParent(null);
        __tag210.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FullTimeStudent.label", java.lang.String .class,"key"));
        __tag210.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag210;
        __result__tag210 = __tag210.doStartTag();

        if (__result__tag210!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag210== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag210.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag210);
            return true;
        }
        _activeTag=__tag210.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag210);
        __tag210.release();
        return false;
    }

    private boolean _jsp__tag211(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag211 = null ;
        int __result__tag211 = 0 ;

        if (__tag211 == null ){
            __tag211 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag211);
        }
        __tag211.setPageContext(pageContext);
        __tag211.setParent(null);
        __tag211.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
        __tag211.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag211;
        __result__tag211 = __tag211.doStartTag();

        if (__result__tag211!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag211== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag211.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag211);
            return true;
        }
        _activeTag=__tag211.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag211);
        __tag211.release();
        return false;
    }

    private boolean _jsp__tag212(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag212 = null ;
        int __result__tag212 = 0 ;

        if (__tag212 == null ){
            __tag212 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag212);
        }
        __tag212.setPageContext(pageContext);
        __tag212.setParent(null);
        __tag212.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PartTimeEmployed.label", java.lang.String .class,"key"));
        __tag212.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag212;
        __result__tag212 = __tag212.doStartTag();

        if (__result__tag212!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag212== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag212.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag212);
            return true;
        }
        _activeTag=__tag212.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag212);
        __tag212.release();
        return false;
    }

    private boolean _jsp__tag213(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag213 = null ;
        int __result__tag213 = 0 ;

        if (__tag213 == null ){
            __tag213 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag213);
        }
        __tag213.setPageContext(pageContext);
        __tag213.setParent(null);
        __tag213.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PartTimeStudent.label", java.lang.String .class,"key"));
        __tag213.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag213;
        __result__tag213 = __tag213.doStartTag();

        if (__result__tag213!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag213== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag213.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag213);
            return true;
        }
        _activeTag=__tag213.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag213);
        __tag213.release();
        return false;
    }

    private boolean _jsp__tag214(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag214 = null ;
        int __result__tag214 = 0 ;

        if (__tag214 == null ){
            __tag214 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag214);
        }
        __tag214.setPageContext(pageContext);
        __tag214.setParent(null);
        __tag214.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SelfEmployed.label", java.lang.String .class,"key"));
        __tag214.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag214;
        __result__tag214 = __tag214.doStartTag();

        if (__result__tag214!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag214== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag214.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag214);
            return true;
        }
        _activeTag=__tag214.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag214);
        __tag214.release();
        return false;
    }

    private boolean _jsp__tag215(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag215 = null ;
        int __result__tag215 = 0 ;

        if (__tag215 == null ){
            __tag215 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag215);
        }
        __tag215.setPageContext(pageContext);
        __tag215.setParent(null);
        __tag215.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unemployed.label", java.lang.String .class,"key"));
        __tag215.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag215;
        __result__tag215 = __tag215.doStartTag();

        if (__result__tag215!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag215== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag215.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag215);
            return true;
        }
        _activeTag=__tag215.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag215);
        __tag215.release();
        return false;
    }

    private boolean _jsp__tag216(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag216 = null ;
        int __result__tag216 = 0 ;

        if (__tag216 == null ){
            __tag216 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag216);
        }
        __tag216.setPageContext(pageContext);
        __tag216.setParent(null);
        __tag216.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag216.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag216;
        __result__tag216 = __tag216.doStartTag();

        if (__result__tag216!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag216== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag216.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag216);
            return true;
        }
        _activeTag=__tag216.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag216);
        __tag216.release();
        return false;
    }
}
