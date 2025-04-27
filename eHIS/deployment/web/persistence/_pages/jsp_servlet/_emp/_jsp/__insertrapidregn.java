package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.io.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __insertrapidregn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/InsertRapidRegn.jsp", 1742536952753L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/PatientAddressLegends.jsp", 1744875458541L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<!--";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n    <head> \n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block9_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block9_2Bytes = _getBytes( _wl_block9_2 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n        <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></link>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n        <Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eMP/js/SmartCard.js\"></Script>\n\t\t<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->\n\t\t<Script language=\"JavaScript\" src=\"../../eMP/js/EmployeePrivilege.js\"></Script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\n\t\t<Script src=\"../../eMP/js/json02.js\"></Script>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/dchk.js\" ></Script>\n        <Script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n        <script language=\'javascript\' src=\'../../eMP/js/RapidRegn.js\'></script>\n        <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script> \t\t\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLClearBean.js\"></script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n\n\t\n<!--Below line added for this SCF AAKH-SCF-0261-->\n<script>\t\t\nfunction SpecialCharsChk(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\treturn true ;\n}\nfunction isValidCharacter(elementRef) {   \n   var regExp =\"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\";\n   var checkValue = new String(elementRef.value);     \n\t for (var i=0; i<checkValue.length; i++)\n\t {\t\n\t\tif (regExp.indexOf(checkValue.charAt(i)) == -1) {\t\n\t\t\t\tvar msg = getMessage(\"RES_MOB_NO_SPL_NOT_ALLOWED\",\'MP\');\n\t\t\t\telementRef.value = \"\";\n\t\t\t\talert(msg);\n\t\t\t\telementRef.focus();\n\t\t\t\treturn false;\t\t  \n\t\t}\n\t  \n    }  \n}\n</script>\n<!--End AAKH-SCF-0261-->\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t        <script>\n\t\t\t\tif (parent.frames[0].document.getElementById(\'patient_id\'))\n\t\t        parent.frames[0].document.getElementById(\'patient_id\').maxLength = \t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</script>\n\t    </head>\n\t\t<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->\n\t\t<body onSelect=\"codeArrestThruSelect()\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onload=\'populateethnicity();chkNatlIdMandatory(\"onload\");\'>\n\t\t\t<form name=\"Rapid_Regn\" id=\"Rapid_Regn\" action=\"../../servlet/eMP.PatientRegistrationServlet\" method=\"post\" target=\"messageFrame\" >\n\t\t\t\t<!-- <a name=\'demo\'></a> -->\n\t\t\t\t<div id = \'demo\' name=\'demo\'>\n\t\t\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'Generate_File\'></input>\n\t\t\t\t<input type=\'hidden\' name=\'datasource_id\' id=\'datasource_id\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'accept_national_id_no\' id=\'accept_national_id_no\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_oth_pat_ser_yn\' id=\'alt_id1_accept_oth_pat_ser_yn\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric_yn\' id=\'alt_id1_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'max_patient_age\' id=\'max_patient_age\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'org_member_relationship_code\' id=\'org_member_relationship_code\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></input>\n\t\t\t\t<input type =\'hidden\' name=\'org_member_relationship_desc\' id=\'org_member_relationship_desc\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></input>\n\n\t\t\t\t<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start -->\n\t\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_oth_pat_ser_yn\" id=\"alt_id2_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_alphanumeric_yn\" id=\"alt_id2_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" /> \n\n\t\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_oth_pat_ser_yn\" id=\"alt_id3_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" /> \n\t\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_alphanumeric_yn\" id=\"alt_id3_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" /> \n\n\t\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_oth_pat_ser_yn\" id=\"alt_id4_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" /> \n\t\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_alphanumeric_yn\" id=\"alt_id4_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n\t\t\t\t<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End -->\n\t\t\t<!-- added by mujafar for ML-MMOH-CRF-524.1 start -->\n\t\t\t<input type=\'hidden\' name=\'alt_id1_alphanum_validate_yn\' id=\'alt_id1_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t\t<input type=\'hidden\' name=\'alt_id2_alphanum_validate_yn\' id=\'alt_id2_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id3_alphanum_validate_yn\' id=\'alt_id3_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id4_alphanum_validate_yn\' id=\'alt_id4_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t<!-- added by mujafar for ML-MMOH-CRF-524.1 end -->\t\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\n\t\t\t<script>\t\tclearBeanForBilling();\t</script>\n\t\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\t\t\n\t\t\t\t\t<tr></tr>\n\t\t\t\t</table>\t\n\t\t\t</div>\n\n\t<!-- <a name=\'misc\'></a> -->\n    <div id = \'misc\' style = \'display:none\'>\n\n\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t  <table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' HEIGHT=\'100%\'>\n\t\t\t\t\t   <tr>\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                            <td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t<td  colspan=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--Below line added for ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n                                          <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--End this ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t\n                             ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\n                            <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<a href=\'javascript:copyDetails(3)\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" \n\t\t\t\t\t\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t// Added for assigning values to dynamically generated address related fields..\n\n\t\t\t\t\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\t\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line2)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line2.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line3)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line3.value = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line4)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line4.value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_town_code.value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\t\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].m_addr_line1)\n\t\t\t\t\t\tdocument.forms[0].m_addr_line1.value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].m_addr_line2)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line2.value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_addr_line3)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line3.value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_addr_line4)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line4.value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_town_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].m_town_code.value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].m_region_code.value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].m_area_code.value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\t\t\t\tdocument.forms[0].m_postal_code1.value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t// End of addition on 13/06/2003 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t<!--New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' ><input type=\'text\' name=\'r_country_desc\' id=\'r_country_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],r_country_desc);} else{clearCountryFields(this)}\'  value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" tabindex=\'51\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,r_country_desc)\' tabindex=\'51\'><img id=\'id2\' src=\'../images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'></img> \n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'r_country_code\' id=\'r_country_code\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'a_country_desc\' id=\'a_country_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" onblur=\'if(this.value !=\"\") {searchCountry(contry_code[0],a_country_desc); } else {clearCountryFields(this);}\' tabindex=\'53\' ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,a_country_desc)\' tabindex=\'53\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'a_country_code\' id=\'a_country_code\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'m_country_desc\' id=\'m_country_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],m_country_desc);}else{clearCountryFields(this)}\'  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" tabindex=\'55\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,m_country_desc)\' tabindex=\'55\'> \n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'m_country_code\' id=\'m_country_code\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t   <!-- Below line added for ML-MMOH-CRF-0860.2 -->   \n\t\t\t    ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'2\'><a href=\'javascript:copyDetails(4)\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(3)\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</a></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<!--End this CRF ML-MMOH-CRF-0860.2 -->  \t\t\t\n\t\t\t\n\t\t\t<tr><td  class=\'COLUMNHEADER\'  ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t    <td class=\'label\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' colspan=2 ><input type=\'text\' name=\'next_off_tel_no\' id=\'next_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value=\"\"></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t<tr>\n\t\t\t    <!--Below line added for this ML-MMOH-CRF-0601--> \n\t\t\t\t<td  class=\'COLUMNHEADER\'  ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="<a href=\'javascript:copyDetails(1)\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</a></td>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="<td>&nbsp;</td><td>&nbsp;</td>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t<a href=\'javascript:copyDetails(2)\'>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t</td> \n\t\t\t\t\t ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t <td class=\'label\' >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t\t\t <td class=\'fields\' colspan=2 ><textarea name=\'next_contact_name\' rows=3 maxlength=80 cols=45 onblur=\'makeValidString(this); maxLengthPaste(this);\' onkeypress=\'checkMaxLimit(this,80)\' onkeyup=\'RemoveSpecialChar(this)\'></textarea></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t\t\t\t<td class=\'fields\'> <!--below CRF length increased against CRF-887 by mano-->\n\t\t\t\t\t<input type=\'text\' name=\'next_contact_name\' id=\'next_contact_name\' maxlength=\'80\' size=\'25\' onblur=\'makeValidString(this);\'  value= \"\">\n\t\t\t\t\t<a href=\'javascript:copyDetails(2)\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</a></td> <td  class=\'label\'>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_off_tel_no\' id=\'next_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value=\"\"></td> \n\t\t\t\t\t ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t    <td class=\'label\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_country_desc\' id=\'next_country_desc\'                   size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this)}\' tabindex=\'61\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,next_country_desc)\' tabindex=\'61\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'next_country_code\' id=\'next_country_code\' value=\'\'>\t\t\t\t\t \n\t\t\t\t\t ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_country_desc\' id=\'next_country_desc\' size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this)}\' tabindex=\'61\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,next_country_desc)\' tabindex=\'61\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'next_country_code\' id=\'next_country_code\' value=\'\'>\n\t\t\t\t\t</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t</tr> \n\t\t</table>\n\t</td>\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\n\t<input type=\'hidden\' name=\'blood_grp\' id=\'blood_grp\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'rh_factor\' id=\'rh_factor\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'r_postal_code\' id=\'r_postal_code\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t<input type=\'hidden\' name=\'m_postal_code\' id=\'m_postal_code\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t<input type=\'hidden\' name=\'next_postal_code\' id=\'next_postal_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'m_town\' id=\'m_town\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'></input>\n\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'></input>\n\t<input type=\'hidden\' name=\'n_town\' id=\'n_town\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'></input>\n\t<input type=\'hidden\' name=\'m_area\' id=\'m_area\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'></input>\n\t<input type=\'hidden\' name=\'n_area\' id=\'n_area\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'></input>\n\t<input type=\'hidden\' name=\'m_region\' id=\'m_region\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'></input>\n\t<input type=\'hidden\' name=\'n_region\' id=\'n_region\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'RAPID_REG\'></input>\n\t<input type=\'hidden\' name=\'patient_group\' id=\'patient_group\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"></input>\n\t<input type=\'hidden\' name=\'nat_series_loaded\' id=\'nat_series_loaded\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'patient_name_loc_lang\' id=\'patient_name_loc_lang\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'></input>\n\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'></input>\n\t<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'></input>\n\t<input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\'S\'></input>\n\t<input type=\'hidden\' name=\'dflt_grp\' id=\'dflt_grp\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"></input>\n\t<input type=\'hidden\' name=\'town_desc\' id=\'town_desc\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'Alt_Id1_Unique_Yn1\' id=\'Alt_Id1_Unique_Yn1\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'></input>\n\t<input type=\'hidden\' name=\'Alt_Id2_Unique_Yn2\' id=\'Alt_Id2_Unique_Yn2\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'></input>\n\t<input type=\'hidden\' name=\'Alt_Id3_Unique_Yn3\' id=\'Alt_Id3_Unique_Yn3\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'></input>\n\t<input type=\'hidden\' name=\'Alt_Id4_Unique_Yn4\' id=\'Alt_Id4_Unique_Yn4\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'></input>\n\t<!-- <input type=\'hidden\' name=\'AltdfltPSG\' id=\'AltdfltPSG\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"></input> -->\n\t<input type=\'hidden\' name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"></input>\n\t<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"></input>\n\t<input type=\'hidden\' name=\'dflt_nat_id_chk_val\' id=\'dflt_nat_id_chk_val\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'></input>\n\t\n\t<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->\n\t<input type=\'hidden\' name=\'a_area\' id=\'a_area\' value=\"\">\n\t<input type=\'hidden\' name=\'a_region\' id=\'a_region\' value=\"\">\n\t<input type=\'hidden\' name=\'a_town\' id=\'a_town\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\"\">\n\t<!--End this ML-MMOH-CRF-0860.2 -->\n\t\n\n\t<input type =\'hidden\' name=\'refrlAappt\' id=\'refrlAappt\' value=\'\'></input>\n\t<input type =\'hidden\' name=\'refIDValue\' id=\'refIDValue\' value=\'\'></input>\n\t\n\t<script>\t\t\t\n\t\tvar natid = \"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\";\n\t\tvar altid = \"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\";\n\n\t\tif(natid != \'\') dispMandatoryImage(\'N\');\n\t\tif(altid != \'\') dispMandatoryImage(\'A\');\n\t\t\n\t\tvar val = \"\"\n        val =\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"\n\t\tif(val==\"\") val = \"N\";\n\t\t\n        if(val ==\"N\")\n        {\n\t\t\tval =\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"\n          \tif(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'first_name\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'first_name\'))\n    \t\t\t}\n\t\t\t}\n            val =\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"\n          \t\t\tif(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'second_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'second_name\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'second_name\'))\n    \t\t\t}\n\t\t\t}\n            val =\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"\n            if(val !=\"\" && val !=\'null\')\n            {\n\t            if(document.getElementById(\'third_name\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'third_name\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'third_name\'))\n    \t\t\t}\n\t\t\t}\n\n\t\t\tval =\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"\n\t\t\t\t\n            if(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'family_name\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'family_name\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'family_name\'))\n\t\t\t\t}\n            }\n\t//\t}\n      //   if(val ==\"N\")\n        //{\n\t\t\t\t\n\t\t\tval =\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"\n    \t\tif(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\t document.getElementById(\'first_name_oth_lang\').value=val\n\t\t\t\t\t putPatientName(document.getElementById(\'first_name_oth_lang\'))\n\t\t\t\t}\n\t\t\t}\n            val =\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"\n            if(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'second_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'second_name_oth_lang\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'second_name_oth_lang\'))\n                }\n\t\t\t}\n\n            val =\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"\n            if(val !=\"\" && val !=\'null\')\n            {\n\t\t\t\tif(document.getElementById(\'third_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'third_name_oth_lang\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'third_name_oth_lang\'))\n                }\n\t\t\t}\n\n            val =\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"\n\t\t\t\t\n\t\t\tif(val !=\"\" && val !=\'null\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'family_name_oth_lang\'))\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'family_name_oth_lang\').value=val\n\t\t\t\t\tputPatientName(document.getElementById(\'family_name_oth_lang\'))\n\t\t\t\t}\n\t\t\t}\n        }\n            \n        val =\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"\n\t\tif(document.getElementById(\'alt_id1_no\') != null)\n\t\t{\n\t\t\tif(val !=\'null\' && document.getElementById(\'alt_id1_no\').value == \'\')\n\t        {\n\t\t\t\tif(document.getElementById(\'alt_id1_no\'))\n\t\t\t    document.getElementById(\'alt_id1_no\').value=val\n\t\t\t}\n\t\t}\n\t\tval =\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"\n\t\tif(document.getElementById(\'alt_id2_no\') != null)\n\t\t{\n\t\t\tif(document.getElementById(\'alt_id2_no\'))\n\t\t\t{\n\t\t\t\tif(val !=\'null\' && document.getElementById(\'alt_id2_no\').value == \'\')\n\t\t\t\t\tdocument.getElementById(\'alt_id2_no\').value = val\n\t\t\t}\n\t\t}\n        val =\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"\n        if(document.forms[0].national_id_no.value == \'\' && val !=\"null\")\n        {\n\t\t\tif(document.forms[0].national_id_no)\n\t\t\t{\n                document.forms[0].national_id_no.value=val;\n\t\t\t    ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t}\n\t\t}\n   \n        val =\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"\n        if(val !=\"\" && val !=\'null\')\n        {\n\t\t\tif(document.getElementById(\'date_of_birth\'))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'date_of_birth\').value = val\n\t\t\t\tdocument.getElementById(\'date_of_birth\').focus();\n\t\t\t}\n\t\t}\n            \n       val =\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\n\t\tvar par_ser_cnt = document.getElementById(\'pat_ser_grp_code\').options.length;\n\t\tif (par_ser_cnt <=1)\n\t\t{\n\t\t\tif(document.getElementById(\'national_id_no\'))\n\t\t\t\tdocument.getElementById(\'national_id_no\').focus();\n\t\t\telse \n\t\t\t\tFocusFirstElement()\n\t\t}\n\t\telse\n\t\t\tFocusFirstElement()\n\t\t\n\n\t\tvar nationalIDNum = \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"; \n\t\t\t\n\t\tif(nationalIDNum != \'\'){\n\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t}\n\t\telse\n\t\t\tFocusFirstElement()\n\n\t\t\t/*\n\t\t\tif (parent.frames[0].document.getElementById(\"patient_name\"))\n\t\t\t{\n\t\t\t\tparent.frames[0].document.getElementById(\"patient_name\").readOnly = false;\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' == \'P\')\n\t\t\t\t{\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" != \'\') {\n\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].patient_name.value = \"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t*/\n\t\n\n\t</script>\n\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"></input>\n\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"Rapid_Regn\"></input>\n\t<input type=\'hidden\' name=\'cred_start_dt1\' id=\'cred_start_dt1\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'cred_start_dt2\' id=\'cred_start_dt2\' value=\"\"></input>  \n\t<input type=\'hidden\' name=\'cred_start_dt3\' id=\'cred_start_dt3\'  value=\"\"></input> \n\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\"\"></input> \n\t<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =">\n\t<input type=\'hidden\' name=\'dflt_pat_ser_grp_code\' id=\'dflt_pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"></input>\n\t\n\t<input type=\'hidden\' name=\'photo_file_name\' id=\'photo_file_name\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =".jpg\'></input>\n\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t<input type=\'hidden\' name=\'error_alt_no1\' id=\'error_alt_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'error_alt_no2\' id=\'error_alt_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'error_alt_no3\' id=\'error_alt_no3\' value=\"\">\n\t<input type=\'hidden\' name=\'error_alt_no4\' id=\'error_alt_no4\' value=\"\">\n\t<input type=\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"></input>\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\"></input>\n\t<input type=\'hidden\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"></input>\n \t <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t <input type =\'hidden\' name=\'altId1Desc\' id=\'altId1Desc\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t <input type =\'hidden\' name=\'altId2Desc\' id=\'altId2Desc\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t <input type =\'hidden\' name=\'altId3Desc\' id=\'altId3Desc\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t <input type =\'hidden\' name=\'altId4Desc\' id=\'altId4Desc\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t <input type=\'hidden\' name=\'name_drvn_logic_long\' id=\'name_drvn_logic_long\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n\t <input type=\'hidden\' name=\'name_drvn_logic_oth_lang_long\' id=\'name_drvn_logic_oth_lang_long\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\"\"></input>\n\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\"\"></input>\n\t<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->\n\t<input type=\'hidden\' name=\'region_prompt1\' id=\'region_prompt1\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"></input>\n\t<input type=\'hidden\' name=\'region_appl_yn1\' id=\'region_appl_yn1\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"></input>\n\t<input type=\'hidden\' name=\'postal_code_prompt\' id=\'postal_code_prompt\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\"></input>\n    <input type=\'hidden\' name=\'area_code_prompt\' id=\'area_code_prompt\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"></input>\n    <!-- Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522 -->\n    <input type=\'hidden\' name=\'town_code_prompt\' id=\'town_code_prompt\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"></input>\n\t<!--Added by Ashwini on 07-Sep-2018-->\n\t<input type=\'hidden\' name=\'finDtlsChkNationality\' id=\'finDtlsChkNationality\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'></input>\n\t </div>\n\n\t ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t<!-- FOR MYKAD READING -->\n\t\t<OBJECT id=Cad style=\\\"WIDTH: 149px; HEIGHT: 25px\\\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>\n\t\t<OBJECT id=jpndf1 style=\\\"WIDTH: 192px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>\n\t\t<OBJECT id=jpndf4 style=\\\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>\n\t\t<OBJECT id=gmpcpic style=\\\"WIDTH: 345px; HEIGHT: 303px\\\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>\n\t\t<!-- FOR MYKAD READING -->\n\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t<script>\n\t\t\tcheckPatGenYN();\t\n\t\t</script>\n\t</form>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block9_2Bytes, _wl_block9_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

	 	
		
		Connection con						= null;
		java.sql.Statement oth_stmt		= null;
		java.sql.Statement inner_stmt	= null;
		PreparedStatement pstmt			= null;
		PreparedStatement stmt_bl		= null;
		ResultSet rs_bl					= null;
		ResultSet rset					= null;
		ResultSet rs					= null;
		ResultSet oth_rset		= null;
		PreparedStatement oth_stmt1		= null;	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale			= (String)session.getAttribute("LOCALE");
		Properties p		= (java.util.Properties) session.getValue("jdbc");
       	String group		= checkForNull(request.getParameter("group"));
		String patient_id	=	checkForNull(request.getParameter("patient_id"));
		String RapidPatInfflag = checkForNull(request.getParameter("RapidPatInfflag"));
		String refrlAappt = checkForNull(request.getParameter("refrlAappt"));
		String refIDValue = checkForNull(request.getParameter("refIDValue"));
		//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		String country_reqd_yn="N",region_reqd_yn="N",mobile_no_reqd_yn="N";
		String country_visibility = "visibility:hidden";
		String region_visibility = "visibility:hidden";
		String mobile_no_visibility = "visibility:hidden";
		String region_prompt		= "";
		String region_appl_yn		= "";
		/*added against AMRI--CRF-0388 by Shagar*/
		String postal_cd_reqd_yn="N",area_reqd_yn="N";
		String town_reqd_yn="N";// Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
		String area_code_prompt ="";
		String town_code_prompt=""; // Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
		String postal_code_prompt ="";
		//Ends here

		con			= ConnectionManager.getConnection(request);
		oth_stmt	= con.createStatement();
		inner_stmt	= con.createStatement() ;
// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar   

// Below line added for ML-MMOH-CRF-0601
Boolean alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); 
Boolean finDtlsChkNationality = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FIN_DTLS_CHK_NATIONALITY");//Added by Ashwini on 07-Sep-2018
	//Added for this CRF ML-MMOH-CRF-0860.2
	String col_span_td="2";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength) col_span_td="2";
	//End this ML-MMOH-CRF-0860.2
	
	//Added for this CRF ML-MMOH-CRF-0601
	String colspantd="colspan=7";	
	if(alterAddressApplicable){
		colspantd="colspan=7";		
	}	
    	
	//End this ML-MMOH-CRF-0601

  
try
        {
			
		String sql1 = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN,initcap(postal_code_prompt)postal_code_prompt,initcap(RES_AREA_PROMPT)area_code_prompt,initcap(RES_TOWN_PROMPT)town_code_prompt FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";
			
			
						if(rs!=null) rs.close();
					    if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql1);
						rs = pstmt.executeQuery();
						
						while (rs.next()){ 
								region_prompt		= rs.getString("region_prompt");
								region_appl_yn		= rs.getString("REGION_APPL_YN");
								postal_code_prompt  = rs.getString("postal_code_prompt");
								area_code_prompt    = rs.getString("area_code_prompt");  
								town_code_prompt    = rs.getString("town_code_prompt");  //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
								
			}			if(rs!=null) rs.close();
				
			 }
			 
		catch(Exception e)
        { } // Ends here  
		String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");        
		String sql								= "";
		String gen_pat_id_yn					= "N";		
        String exestr							= "";
		String alt_id	 = "";
		String alt_id2 =	"";
		String alt_id3 =	"";
		String alt_id4 ="";
		String nat_id							= "";
		String a_national_id_no					= "";	
		String dflt_pat_regn_blng_class			= "";
		String a_gender							= "";
		String sql_bl							= null;
		String dfltPSG							= "";	
		String Nationality_Code					= "";		
		String[] contact_col_names	= null;
		String[] contact_prompts	= null;
		String[] contact_fields		= null;
						

			String patient_id_length = "";
			String family_no_link_yn = "";
			String name_dervn_logic = "";
			String citizen_nationality_code = "";
			String default_race_code = "";
			String dflt_grp = "";
			String alt_id1_unique_yn = "";
			String alt_id2_unique_yn = "";
			String alt_id3_unique_yn = "";
			String alt_id4_unique_yn = "";
			String serverdate = "";
			String photo_file_name = "";
			String accept_national_id_no_yn = "";
			String nat_id_accept_alphanumeric_yn = "";
			String alt_id1_accept_oth_pat_ser_yn = "";
			String alt_id1_accept_alphanumeric_yn = "";
			String max_patient_age = "";
			String name_dervn_logic_oth_lang = "";		
			String alt_id1_desc = "";
			String alt_id2_desc = "";
			String alt_id3_desc = "";
			String alt_id4_desc = "";
			String maintain_doc_or_file = "";
			String create_file_at_pat_regn_yn = "";
			String ext_system_interface_yn = "";
			String nat_data_source_id = "";
			String altdfltpsg = "";

			String a_res_addr_line1 = "", a_res_addr_line2	= "", a_res_addr_line3	= "";
			String a_res_addr_line4 = "", a_res_area_code = "", a_res_town_code = "",a_postal_code = "",a_postal_desc="";
			String a_country_code = "", a_res_country_desc = "", a_res_region_code = "", a_res_tel_no = "";
			String a_res_area_desc = "", a_res_region_desc = "", a_mail_addr_line1 = "";
			String a_mail_addr_line2 = "", a_mail_addr_line3 = "", a_mail_addr_line4 = "";
			String a_mail_town_code	= "", a_mail_area_code	= "", a_mail_country_code = "";
			String a_mail_country_desc = "", a_mail_postal_code = "", a_mail_region_code = "",a_mail_postal_desc = "";
			String a_mail_town_desc	= "", a_mail_area_desc = "",a_mail_region_desc = "";
			String a_patient_name = "",res_contact_name = "",mail_contact_name ="",a_res_town_desc ="";

			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
			String alt_id2_accept_oth_pat_ser_yn		= "";
			String alt_id2_accept_alphanumeric_yn		= "";
			String alt_id3_accept_oth_pat_ser_yn		= "";
			String alt_id3_accept_alphanumeric_yn		= "";
			String alt_id4_accept_oth_pat_ser_yn		= "";
			String alt_id4_accept_alphanumeric_yn		= "";
			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */
			/* added by mujafar for ML-MMOH-CRF-524.1 start */
			String alt_id1_alphanum_validate_yn = "N" ;
			String alt_id2_alphanum_validate_yn = "N" ;
			String alt_id3_alphanum_validate_yn = "N" ;
			String alt_id4_alphanum_validate_yn = "N" ; 
			/* added by mujafar for ML-MMOH-CRF-524.1 end */

		int tindex			= 1;
		
		ArrayList codes = new ArrayList();
		ArrayList descs = new ArrayList();

		Object relationcode[] = null;
		Object relationdesc[] = null;

		ArrayList arrayList2 = new ArrayList();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
		HashMap hash_mp_param=new HashMap();
        hash_mp_param=eMP.ChangePatientDetails.getSetupData(facility_id,group,con,p);//modified for the incident 34901
		
		String family_org_id_accept_yn=checkForNull((String)hash_mp_param.get("family_org_id_accept_yn"));
		
		
		String org_member_relationship_code=checkForNull((String)hash_mp_param.get("org_member_relationship_code"));
		String org_member_relationship_desc=checkForNull((String)hash_mp_param.get("org_member_relationship_desc"));
		
		String entitlement_by_pat_cat_yn=checkForNull((String)hash_mp_param.get("entitlement_by_pat_cat_yn"));		
		//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn=checkForNull((String)hash_mp_param.get("COUNTRY_REQD_YN"),"N");	
		region_reqd_yn=checkForNull((String)hash_mp_param.get("REGION_REQD_YN"),"N");	
		mobile_no_reqd_yn=checkForNull((String)hash_mp_param.get("MOBILE_NO_REQD_YN"),"N");	
		//Added Against AMRI-CRF-0388 by shagar
		postal_cd_reqd_yn=checkForNull((String)hash_mp_param.get("POSTAL_CD_REQD_YN"),"N");	
		area_reqd_yn=checkForNull((String)hash_mp_param.get("AREA_REQD_YN"),"N");
		town_reqd_yn=checkForNull((String)hash_mp_param.get("TOWN_REQD_YN"),"N");
		/* added by mujafar for ML-MMOH-CRF-524.1 start */
		alt_id1_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id1_alphanum_validate_yn"),"N");
		alt_id2_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id2_alphanum_validate_yn"),"N");
		alt_id3_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id3_alphanum_validate_yn"),"N");
		alt_id4_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id4_alphanum_validate_yn"),"N");
		/* added by mujafar for ML-MMOH-CRF-524.1 start */
		//Ends here	
        try {

			String Town			= request.getParameter("Town");
			String Family_Name1 = request.getParameter("Family_Name");
			String Region		= request.getParameter("Region");
			String Area			= request.getParameter("Area");
						
			if(Town == null) Town = "";
			if(Family_Name1 == null) Family_Name1 = "";
			if(Region == null) Region = "";
			if(Area == null) Area = "";	
			
			a_gender = request.getParameter("Sex"); 
			if(a_gender == null) a_gender = "";
			if (a_gender.equals("A"))
			a_gender="";

			String AltdfltPSG	= "";

            String patient_grp	= request.getParameter("group") == null ? "" : request.getParameter("group");
			
			/*** Thee values of variable 'alt_id' i.e., Alternate ID1 which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/

			alt_id = request.getParameter("alt_id") == null ? "" : request.getParameter("alt_id");
			alt_id2 = request.getParameter("Alt_Id2_No") == null ? "" : request.getParameter("Alt_Id2_No");
			alt_id3 = request.getParameter("Alt_Id3_No") == null ? "" : request.getParameter("Alt_Id3_No");
			alt_id4 = request.getParameter("Alt_Id4_No") == null ? "" : request.getParameter("Alt_Id4_No");	

			a_national_id_no	= request.getParameter("National_Id_No");
			if(a_national_id_no == null || a_national_id_no.equals("null")) a_national_id_no = "";
			
			/****** Imp. Note: The sequence of retrieving nat_id param should always fallow the retrieving of a_national_id_no param value **********/	

			nat_id = request.getParameter("nat_id") == null ? "" : request.getParameter("nat_id");

			if(patient_grp.equals("N"))
			{
				/*** Thee values of variable 'nat_id' i.e., National ID which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/
			
				if(!nat_id.equals("")) 
				{
					a_national_id_no = nat_id;
				}
			}
			
			/****** Imp. Note2 Ends **********/		
				
			
			
			patient_id_length = request.getParameter("patient_id_length");
			family_no_link_yn = checkForNull(request.getParameter("family_no_link_yn"),"N");
			name_dervn_logic = request.getParameter("name_dervn_logic");
			citizen_nationality_code = request.getParameter("citizen_nationality_code");
			default_race_code = request.getParameter("default_race_code");
			dflt_grp = request.getParameter("dflt_grp");
			alt_id1_unique_yn = request.getParameter("alt_id1_unique_yn");
			alt_id2_unique_yn = request.getParameter("alt_id2_unique_yn");
			alt_id3_unique_yn = request.getParameter("alt_id3_unique_yn");
			alt_id4_unique_yn = request.getParameter("alt_id4_unique_yn");
			serverdate = request.getParameter("serverdate");
			photo_file_name = request.getParameter("photo_file_name");
			accept_national_id_no_yn = request.getParameter("accept_national_id_no_yn");
			nat_id_accept_alphanumeric_yn = checkForNull(request.getParameter("nat_id_accept_alphanumeric_yn"),"N");
			alt_id1_accept_oth_pat_ser_yn = checkForNull(request.getParameter("alt_id1_accept_oth_pat_ser_yn"),"N");
			alt_id1_accept_alphanumeric_yn = checkForNull(request.getParameter("alt_id1_accept_alphanumeric_yn"),"N");


			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
			alt_id2_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id2_accept_oth_pat_ser_yn"),"N");
			alt_id2_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id2_accept_alphanumeric_yn"),"N");
			alt_id3_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id3_accept_oth_pat_ser_yn"),"N");
			alt_id3_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id3_accept_alphanumeric_yn"),"N");
			alt_id4_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id4_accept_oth_pat_ser_yn"),"N");
			alt_id4_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id4_accept_alphanumeric_yn"),"N");
			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */
		
			
			max_patient_age = request.getParameter("max_patient_age");
			altdfltpsg = request.getParameter("altdfltpsg");
			name_dervn_logic_oth_lang = request.getParameter("name_dervn_logic_oth_lang");
		
			alt_id1_desc = request.getParameter("alt_id1_desc");
			alt_id2_desc = request.getParameter("alt_id2_desc");
			alt_id3_desc = request.getParameter("alt_id3_desc");
			alt_id4_desc = request.getParameter("alt_id4_desc");
			maintain_doc_or_file =checkForNull(request.getParameter("maintain_doc_or_file"),"F");
			create_file_at_pat_regn_yn =checkForNull(request.getParameter("create_file_at_pat_regn_yn"),"N");		
			ext_system_interface_yn =checkForNull(request.getParameter("ext_system_interface_yn"),"N");
			nat_data_source_id =checkForNull(request.getParameter("nat_data_source_id"),"N");			
		
			ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageFrame",p) ;
						
            
			String Site = (String) contact_addr.get(0) ;

            contact_col_names = (String[])contact_addr.get(1) ;
            contact_prompts   = (String[])contact_addr.get(2) ; 
            contact_fields    = (String[])contact_addr.get(3) ;
			contact_addr = null;
			
            
            sql= "SELECT pat_ser_grp_code,nvl(gen_pat_id_yn,'N') gen_pat_id_yn FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R')";
            rs = inner_stmt.executeQuery(sql);
           
            if(rs != null) {
                int k = 0;
                out.println("<script>");

                while(rs.next()) {
                    if((dflt_grp==null?"":dflt_grp).equals( (rs.getString(1) ==null? "" :rs.getString(1))  ))
						gen_pat_id_yn = (rs.getString(2) == null ?"N":rs.getString(2));
                    out.println("PSGCodeArray["+k+"]='"+rs.getString(1)+"';");
                    out.println("PSGYNArray["+k+"]='"+rs.getString(2)+"';");
                    k++;
				}
                out.println("</script>");
                
				if(rs != null) rs.close();
			}

			if(refrlAappt.equals("P"))
			{

				sql="SELECT b.PATIENT_NAME patient_name,a.addr1_line1 res_addr_line1,a.addr1_line2 res_addr_line2,a.addr1_line3 res_addr_line3,a.addr1_line4 res_addr_line4,a.res_town1_code res_town_code, mp_get_desc.MP_RES_TOWN(a.res_town1_code,'"+locale+"',1) res_town_desc,a.res_area1_code res_area_code,mp_get_desc.MP_RES_AREA(a.res_area1_code,'"+locale+"',1) res_area_desc,a.region1_code res_region_code,mp_get_desc.MP_REGION(a.region1_code,'"+locale+"',1) res_region_desc,a.postal1_code postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,a.COUNTRY1_CODE res_country_code ,mp_get_desc.MP_COUNTRY(a.COUNTRY1_CODE,'"+locale+"',1) res_country_desc,a.addr2_line1 mail_addr_line1,a.addr2_line2 mail_addr_line2,a.addr2_line3 mail_addr_line3,a.addr2_line4 mail_addr_line4,a.res_town2_code mail_town_code,mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"',1) mail_town_desc,a.region2_code mail_region_code, mp_get_desc.MP_REGION(a.region2_code,'"+locale+"',1) mail_region_desc,a.res_area2_code mail_area_code, mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"',1) mail_area_desc,a.postal2_code,a.COUNTRY2_CODE mail_country_code,mp_get_desc.MP_COUNTRY(a.COUNTRY2_CODE,'"+locale+"',1) mail_country_desc,postal2_code mail_postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) mail_postal_desc,b.contact1_no res_tel_no,a.CONTACT1_NAME res_contact_name,CONTACT2_NAME mail_contact_name FROM MP_PAT_ADDRESSES a,mp_patient b WHERE b.PATIENT_ID=a.PATIENT_ID AND b.PATIENT_ID='"+refIDValue+"'";

			
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt1!=null) oth_stmt1.close();
			oth_stmt1 = con.prepareStatement(sql);
			oth_rset = oth_stmt1.executeQuery();
			
			if(oth_rset.next())
			{

				a_res_addr_line1			= 	checkForNull( oth_rset.getString("res_addr_line1") );
				a_res_addr_line2			= 	checkForNull( oth_rset.getString("res_addr_line2") );
				a_res_addr_line3			= 	checkForNull( oth_rset.getString("res_addr_line3") );
				a_res_addr_line4			= 	checkForNull( oth_rset.getString("res_addr_line4") );
				a_res_town_code			= 	checkForNull( oth_rset.getString("res_town_code") );
				a_res_town_desc			= 	checkForNull( oth_rset.getString("res_town_desc") );
				a_res_area_code			= 	checkForNull( oth_rset.getString("res_area_code") );
				a_res_area_desc			= 	checkForNull( oth_rset.getString("res_area_desc") );
				a_res_region_code		= 	checkForNull( oth_rset.getString("res_region_code") );
				a_res_region_desc			= 	checkForNull( oth_rset.getString("res_region_desc") );
				a_country_code			= 	checkForNull( oth_rset.getString("res_country_code") );
				a_res_country_desc		= 	checkForNull( oth_rset.getString("res_country_desc") );
				a_postal_code				= 	checkForNull( oth_rset.getString("postal_code") );
				a_mail_addr_line1			= 	checkForNull( oth_rset.getString("mail_addr_line1") );
				a_mail_addr_line2			= 	checkForNull( oth_rset.getString("mail_addr_line2") );
				a_mail_addr_line3			= 	checkForNull( oth_rset.getString("mail_addr_line3") );
				a_mail_addr_line4			= 	checkForNull( oth_rset.getString("mail_addr_line4") );
				a_mail_town_code			= 	checkForNull( oth_rset.getString("mail_town_code") );
				a_mail_town_desc			= 	checkForNull( oth_rset.getString("mail_town_desc") );
				a_mail_area_code			= 	checkForNull( oth_rset.getString("mail_area_code") );
				a_mail_area_desc			= 	checkForNull( oth_rset.getString("mail_area_desc") );
				a_mail_country_code		= 	checkForNull( oth_rset.getString("mail_country_code") );
				a_mail_country_desc		= 	checkForNull( oth_rset.getString("mail_country_desc") );
				a_mail_postal_code		= 	checkForNull( oth_rset.getString("mail_postal_code") );
				a_mail_region_code		= 	checkForNull( oth_rset.getString("mail_region_code") );
				a_mail_region_desc		= 	checkForNull( oth_rset.getString("mail_region_desc") );
				a_res_tel_no				= 	checkForNull( oth_rset.getString("res_tel_no") );
				a_patient_name		=	checkForNull( oth_rset.getString("patient_name") );
				res_contact_name	=	checkForNull( oth_rset.getString("res_contact_name") );
				mail_contact_name	=	checkForNull( oth_rset.getString("mail_contact_name") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				
			}
			}
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_id1_accept_oth_pat_ser_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(max_patient_age));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(org_member_relationship_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(org_member_relationship_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alt_id2_accept_oth_pat_ser_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id2_accept_alphanumeric_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id3_accept_oth_pat_ser_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(alt_id3_accept_alphanumeric_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id4_accept_oth_pat_ser_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alt_id4_accept_alphanumeric_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alt_id1_alphanum_validate_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alt_id2_alphanum_validate_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id3_alphanum_validate_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id4_alphanum_validate_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);

				dfltPSG =dflt_grp==null ? "" :dflt_grp;
				if(dfltPSG == null) dfltPSG = "";
				
				default_race_code = default_race_code  == null ? "" : default_race_code;
				
				Nationality_Code = citizen_nationality_code  == null ? "" :citizen_nationality_code;
												
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            {java.lang.String __page ="../../eMP/jsp/ChangePatientSubNames.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("group"), weblogic.utils.StringUtils.valueOf(patient_grp
                        )},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("RapidReg")},{ weblogic.utils.StringUtils.valueOf("a_national_id_no"), weblogic.utils.StringUtils.valueOf(a_national_id_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id1_no"), weblogic.utils.StringUtils.valueOf(alt_id
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id2_no"), weblogic.utils.StringUtils.valueOf(alt_id2
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id3_no"), weblogic.utils.StringUtils.valueOf(alt_id3
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id4_no"), weblogic.utils.StringUtils.valueOf(alt_id4
                        )},{ weblogic.utils.StringUtils.valueOf("a_gender"), weblogic.utils.StringUtils.valueOf(a_gender
                        )},{ weblogic.utils.StringUtils.valueOf("Site"), weblogic.utils.StringUtils.valueOf(Site
                        )},{ weblogic.utils.StringUtils.valueOf("dfltPSG"), weblogic.utils.StringUtils.valueOf(dfltPSG
                        )},{ weblogic.utils.StringUtils.valueOf("default_race_code"), weblogic.utils.StringUtils.valueOf(default_race_code
                        )},{ weblogic.utils.StringUtils.valueOf("a_nationality_code"), weblogic.utils.StringUtils.valueOf(Nationality_Code
                        )},{ weblogic.utils.StringUtils.valueOf("nat_id_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(nat_id_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("RapidPatInfflag"), weblogic.utils.StringUtils.valueOf(RapidPatInfflag
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
if(alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
}if(!alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
}		
							  if((alterAddressApplicable && increasedaddressLength) || (!alterAddressApplicable && !increasedaddressLength)){
							
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

						//New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						if(region_reqd_yn.equals("Y")){ 
										region_visibility = "visibility:visible";}
						StringBuffer sb12		= new StringBuffer();
						StringBuffer fieldVal2	= new StringBuffer();
						StringBuffer sb21		= new StringBuffer();
						StringBuffer sb121		= new StringBuffer();
						StringBuffer fieldVal21 = new StringBuffer();
						StringBuffer sbaa = new StringBuffer();
						StringBuffer sbrr = new StringBuffer();
						
						//Below line added for this CRF ML-MMOH-CRF-0601						
						//StringBuffer alt_sb = new StringBuffer();	                       
							StringBuffer sb_a = new StringBuffer();
							StringBuffer sb_ap			= new StringBuffer();
							StringBuffer sb_ar			= new StringBuffer();
							StringBuffer sb1_aa		= new StringBuffer();
                            StringBuffer fieldVal_aa	= new StringBuffer(); 							
						//End ML-MMOH-CRF-0601
						

						for(int i=0;i<contact_col_names.length; i++) {
							out.println("<tr>");
							out.println("<td class='label'  >"+contact_prompts[i]+"</td>");

							String val = contact_fields[i];
							
							String val_alt = contact_fields[i]; //Added for this CRF ML-MMOH-CRF-0601

							sb12.append(val);
							fieldVal2.append("");
							
							for(int z=0;z<val.length();z++) {
								String tempVal = sb12.substring(z,z+1);
								if(tempVal.equals("@")) {
									fieldVal2.append("50");
								}
								else {
									fieldVal2.append(tempVal);
								}
							}
							val = fieldVal2.toString();							
							val_alt = fieldVal2.toString(); //Added for this CRF ML-MMOH-CRF-0601
							
							//Modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
							out.println("<td class='fields' colspan='"+col_span_td+"' >"+val);
							val = contact_fields[i] ;
							
							val_alt = contact_fields[i] ; //Added for this CRF ML-MMOH-CRF-0601
							
							sb21.append(val) ;
							
							//alt_sb.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
							
							sb_a.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
							
							int j = 0;
							int j1=0 ;
							String old_val = "" ;
							String new_val = "" ;
							
							String new_val_alt=""; //Added for this CRF ML-MMOH-CRF-0601

							if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
								old_val = "r_addr_line1" ;
								new_val = "m_addr_line1" ;
								new_val_alt = "a_addr_line1" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
								old_val = "r_addr_line2" ;
								new_val = "m_addr_line2" ;
								new_val_alt = "a_addr_line2" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
								old_val = "r_addr_line3" ;
								new_val = "m_addr_line3" ;
								new_val_alt = "a_addr_line3" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
								old_val = "r_addr_line4" ;
								new_val = "m_addr_line4" ;
								new_val_alt = "a_addr_line4" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
								old_val = "r_area_code" ;
								new_val = "m_area_code" ;
								new_val_alt = "a_area_code" ;  
								if(area_reqd_yn.equals("Y")){//Added for AMRI-CRF-0388 by shagar
                                         out.println("<img id='area_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
								//Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
								old_val = "r_town_code" ;
								new_val = "m_town_code" ;
								new_val_alt = "a_town_code" ;  //Added for this CRF ML-MMOH-CRF-0601
								if(town_reqd_yn.equals("Y")){ //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
                                    out.println("<img id='town_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
							}
							else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
								old_val = "r_region_code" ;
								//New Iamge is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
								out.println("<img id='id1' src='../images/mandatory.gif' style='"+region_visibility+"'</img>");
								new_val = "m_region_code" ;
								
								new_val_alt = "a_region_code" ; //Added for this CRF ML-MMOH-CRF-0601
								
							}   
							else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
								old_val = "r_postal_code" ;
								new_val = "m_postal_code" ;
								if(postal_cd_reqd_yn.equals("Y")){//Added for AMRI-CRF-0388 by shagar
                                         out.println("<img id='postal_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
								new_val_alt = "alt_postal_code" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							
							//Added for this CRF ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
							while(val_alt.indexOf(old_val) != -1){
                                        int jk =0;
										jk = val_alt.indexOf(old_val,jk) ;
                                        sb_a = sb_a.replace(jk,(jk+old_val.length()),new_val_alt);
                                        val_alt = sb_a.toString();
										
							}												
							if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sb_ap.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{ 
											
											int jk1 = 0;
											jk1= val_alt.indexOf("r_postal_code",jk1) ;
											
											sb_ap = sb_ap.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ap.toString();
									
										}
									}
							if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")){
										int jk1 = 0;
										sb_ar.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{
											
											jk1 = val_alt.indexOf("r_postal_code",jk1) ;											
											sb_ar = sb_ar.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ar.toString();
											
										}
									}
									
									
							sb1_aa.append(val_alt) ;
                            fieldVal_aa.append("");
									
							for(int z=0;z<val_alt.length();z++)	{
									String tempVal=sb1_aa.substring(z,z+1);
									if(tempVal.equals("@"))	{
											fieldVal_aa.append("52"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
									}else{
											fieldVal_aa.append(tempVal);
									}
							}
									
							val_alt = fieldVal_aa.toString();									
							//End ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
							
							
							
							
																							
							while(val.indexOf(old_val) != -1) {
								j = val.indexOf(old_val,j) ;
								sb21 = sb21.replace(j,(j+old_val.length()),new_val);
								val = sb21.toString();
							}
							if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
							{
								sbaa.append(val);
								while(val.indexOf("r_postal_code") != -1)
								{
									
									j1 = val.indexOf("r_postal_code",j1) ;
									
									sbaa = sbaa.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
									val = sbaa.toString();
							
								}
							}
							if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
							{
								j1 = 0;
								sbrr.append(val);
								while(val.indexOf("r_postal_code") != -1)
								{
									
									j1 = val.indexOf("r_postal_code",j1) ;
									
									sbrr = sbrr.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
									val = sbrr.toString();
									
								}
							}
							sb121.append(val);
							fieldVal21.append("");
							for(int z=0;z<val.length();z++) {
								String tempVal = sb121.substring(z,z+1);
								if(tempVal.equals("@")) {
									fieldVal21.append("54"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								} else {
									fieldVal21.append(tempVal);
								}
							}
							val = fieldVal21.toString();
							out.println("</td>") ;
                              
            _bw.write(_wl_block48Bytes, _wl_block48);
								
									if(alterAddressApplicable){
									if(i == 1)
									{  
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(val_alt));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{   
									    out.println("<td class='fields' colspan='"+col_span_td+"'>"+val_alt+"</td>") ;
									  }						
									}
									
            _bw.write(_wl_block51Bytes, _wl_block51);

							if(i==0)
							{ 
							  
							  String colspan_td="";
							  if(increasedaddressLength && !alterAddressApplicable){
							  colspan_td=col_span_td;
							  col_span_td="4";
							  }
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(val));
            _bw.write(_wl_block53Bytes, _wl_block53);
 //Added for ML-MMOH-CRF-0860.2
							  if(increasedaddressLength && !alterAddressApplicable) col_span_td=colspan_td;
							  
							if( (!increasedaddressLength) || (increasedaddressLength && !alterAddressApplicable)){
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}//End ML-MMOH-CRF-0860.2
            _bw.write(_wl_block56Bytes, _wl_block56);
}else	if(i==1 && alterAddressApplicable){
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(val));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
								  out.println("<td class='fields'  colspan='"+col_span_td+"' >"+val+"</td>") ;
							 }
							out.println("</tr><tr><td class='label' colspan='4' ></td></tr>") ;

							sb12.setLength(0);
							fieldVal2.setLength(0);
							sb21.setLength(0);
							sb121.setLength(0);
							fieldVal21.setLength(0);
							sbaa.setLength(0);
							sbrr.setLength(0);
							
						//Below line added for ML-MMOH-CRF-0860.2
							 sb_a.setLength(0);
							 sb_ap.setLength(0);
							 sb_ar.setLength(0);
							 sb1_aa.setLength(0);
                             fieldVal_aa.setLength(0);							
						//End ML-MMOH-CRF-860.2
							
						} //Condition is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						if(country_reqd_yn.equals("Y")){
						country_visibility = "visibility:visible";}
						
						
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(a_res_addr_line1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(a_res_addr_line2));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(a_res_addr_line3));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(a_res_addr_line4));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(a_res_town_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(a_res_region_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(a_res_area_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(a_postal_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(a_mail_addr_line1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(a_mail_addr_line2));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(a_mail_addr_line3));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(a_mail_addr_line4));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(a_mail_town_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(a_mail_region_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(a_mail_area_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(a_mail_postal_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
tindex=61;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(a_res_country_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(country_visibility));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(a_country_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
tindex=76;
            _bw.write(_wl_block83Bytes, _wl_block83);

						//Below line added for this CRF and ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2	
						if(alterAddressApplicable)
						{
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(a_mail_country_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(a_mail_country_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
						  //End ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2
						
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(a_mail_country_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(a_mail_country_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
if(alterAddressApplicable){
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(colspantd));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

//Condition is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar						
						if(mobile_no_reqd_yn.equals("Y")){ 
								   mobile_no_visibility = "visibility:visible";}
						 tindex = 78;
						sql=" select mp_get_desc.MP_CONTACT_MODE(contact_mode,'"+locale+"',2) short_desc,contact_mode from mp_contact_mode where contact_mode in ('PRN','ORN') order by contact_mode desc ";
						rs = inner_stmt.executeQuery(sql);
						if(rs != null) {
							if(rs.next()) {
							    //Modifed for this SCF AAKH-SCF-0261
								out.println("<tr><td class='label'  >"+rs.getString(1)+"</td>");
								out.println("<td class='fields'><input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='15' value=\""+a_res_tel_no+"\" onblur='makeValidString(this);isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>");
								out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='15' value='"+rs.getString(2)+"' ></td>");
																
								
							}
							if(rs.next()) {
							    //Modified for this SCF AAKH-SCF-0261
								out.println("<td class='label'  >"+rs.getString(1)+"</td>") ;
								
								out.println("<td class='fields'><input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='15' value=\"\"  onblur='makeValidString(this);isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>");
								//New Iamge is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
								out.println("<img id='id3' src='../images/mandatory.gif' style='"+mobile_no_visibility+"'</img>");
								out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='15' value='"+rs.getString(2)+"' ></td>");
								
								if(increasedaddressLength){
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
}else{
								out.println("</tr>");
								}
							}
						}
						if(rs != null) rs.close();
						
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(colspantd));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
 if(family_no_link_yn.equals("Y")) { 
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
 
						sql="SELECT relationship_code, initcap(mp_get_desc.MP_RELATIONSHIP(relationship_code,'"+locale+"',2)) Short_Desc FROM mp_relationship WHERE eff_status='E' order by 2";
						rs = inner_stmt.executeQuery(sql);
						if(rs != null ) 
						while(rs.next()) {
							codes.add(rs.getString("Relationship_Code")) ;
							descs.add(rs.getString("Short_Desc")) ;
						}
						relationcode = codes.toArray();   
						relationdesc = descs.toArray();

						out.println("<select name='next_contact_relation' id='next_contact_relation' onFocus=''>");
						out.println("<option value=\"\">--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------------- </option>");
						for(int i=0;i<relationcode.length;i++)
							out.println("<option value='"+relationcode[i]+"'>"+relationdesc[i]+ "</option>");
						out.println("</select>");
						
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

					} else { 
            _bw.write(_wl_block105Bytes, _wl_block105);
 } 
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
 //Below line added for ML-MMOH-CRF-0887.1
					if(increasedaddressLength){
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
}
            _bw.write(_wl_block110Bytes, _wl_block110);
 //Below line modified for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0887.1
					if(increasedaddressLength){
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block113Bytes, _wl_block113);

				//Below line added ML-MMOH-CRF-0860.2				   
				  if(!increasedaddressLength){				   
				
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
 //Added for ML-MMOH-CRF-0860.2
					   if(increasedaddressLength){
							    out.println("<td class='label' >&nbsp;</td><td class='label' >&nbsp;</td><td class='label' >&nbsp;</td>");
						}
						
            _bw.write(_wl_block113Bytes, _wl_block113);
} //End ML-MMOH-CRF-0860.2
				
				
				StringBuffer sbc			=	new StringBuffer();
				StringBuffer sb1c			=	new StringBuffer();
				StringBuffer fieldValc		=	new StringBuffer();
				StringBuffer sbap			=	new StringBuffer();
				StringBuffer sbar			=	new StringBuffer();
				
				//Below line added for ML-MMOH-CRF-0860.2				
				int displayCountry=contact_col_names.length-1;				
				int conutry=0;
				
				System.err.println("InsertRapidRegn.jsp displayCountry===>"+displayCountry);
				System.err.println("InsertRapidRegn.jsp contact_col_names.length===>"+contact_col_names.length);
				
				for(int i=0;i<contact_col_names.length; i++) {
				   
					//Below line added for ML-MMOH-CRF-0860.2
					if(increasedaddressLength){
					if(i==0 || i==3 || i==6){
					conutry=i;
					out.println("<tr>") ;
					}					
					out.println("<td class='label' >"+contact_prompts[i]+"</td>") ;					
					}else{
					out.println("<tr>") ;
					out.println("<td class='label' >"+contact_prompts[i]+"</td>") ;
					}
                     //End ML-MMOH-CRF-0860.2					
					 String val = contact_fields[i] ;					
					 sbc.append(val) ;
					
					int j = 0;
					int j1=0 ;
					String old_val = "" ;
					String new_val = "" ;
					if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
					{
						old_val = "r_addr_line1" ;
						new_val = "next_addr_line1" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
					 {
						old_val = "r_addr_line2" ;
						new_val = "next_addr_line2" ;
					}
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
					 {
						old_val = "r_addr_line3" ;
						new_val = "next_addr_line3" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
					{
						old_val = "r_addr_line4" ;
						new_val = "next_addr_line4" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
					{
						old_val = "r_town_code" ;
						new_val = "contact1_res_town_code" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
					{
						old_val = "r_region_code" ;
						new_val = "contact1_region_code" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
					{
						old_val = "r_area_code" ;
						new_val = "contact1_res_area_code" ;
					}                                     
					else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
					{
						old_val = "r_postal_code" ;
						new_val = "next_postal_code" ;
					}				
					while(val.indexOf(old_val) != -1)
					{
						j = val.indexOf(old_val,j) ;
						sbc = sbc.replace(j,(j+old_val.length()),new_val);
						val = sbc.toString();
					}
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
					{
						sbap.append(val);
						while(val.indexOf("r_postal_code") != -1)
						{
							
							j1 = val.indexOf("r_postal_code",j1) ;
							
							sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbap.toString();
					
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
					{
						j1 = 0;
						sbar.append(val);
						while(val.indexOf("r_postal_code") != -1)
						{							
							j1 = val.indexOf("r_postal_code",j1) ;
							
							sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar.toString();
							
						}
					}
					sb1c.append(val);
					fieldValc.append("");
					for(int z=0;z<val.length();z++)
					{
						String tempVal=sb1c.substring(z,z+1);
						if(tempVal.equals("@"))
						{
							fieldValc.append(60); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						}
						else
						{
							fieldValc.append(tempVal);
						}
					}	
					val = fieldValc.toString();
 
                    //Below line added for this ML-MMOH-CRF-0860.2
					if(increasedaddressLength){					
					out.println("<td class='fields' >"+val+"</td>") ;
					//System.err.println("InsertRapidRegn.jsp   i==>"+i);
					 
					if((i==displayCountry && contact_col_names.length ==7) || (i==displayCountry && contact_col_names.length ==8) || (i==displayCountry && contact_col_names.length ==2) || (i==displayCountry && contact_col_names.length ==1) || (i==displayCountry && contact_col_names.length ==4 || (i==displayCountry && contact_col_names.length ==5))){
					//if(i==7){
					 
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
}
					if(i==2 || i==5 || i==7){					
					out.println("<td>&nbsp;</td></tr>") ; 
					//out.println("</tr>") ;
					}
					//else{
                     
					 //}					
					}else{
					out.println("<td class='fields' >"+val+"</td>") ;
					out.println(" <td>&nbsp;</td><td>&nbsp;</td></tr>") ;
					}
					//End ML-MMOH-CRF-0860.2

					sbc.setLength(0);
					sb1c.setLength(0);
					fieldValc.setLength(0);
					sbap.setLength(0);
					sbar.setLength(0);
				}
				
				//Below line added for ML-MMOH-CRF-0860.2
				if((!increasedaddressLength) || (increasedaddressLength && contact_col_names.length==0)){		
				
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
}
				//End ML-MMOH-CRF-0860.2
				
            _bw.write(_wl_block121Bytes, _wl_block121);

	if(bl_install_yn.equals("Y"))
	{
		sql_bl="select dflt_pat_regn_blng_class from bl_mp_param";
		stmt_bl = con.prepareStatement(sql_bl);
		rs_bl = stmt_bl.executeQuery();
		if(rs_bl!=null)
		{
			while(rs_bl.next())
			{
				dflt_pat_regn_blng_class = rs_bl.getString(1)==null?"":rs_bl.getString(1);
			}
		}
	}
	
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(a_postal_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(a_mail_postal_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(a_mail_town_code));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(a_res_town_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(a_res_area_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(a_mail_area_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(a_res_region_code));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(a_mail_region_code));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(patient_grp));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(name_dervn_logic));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(name_dervn_logic_oth_lang));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(gen_pat_id_yn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(dflt_grp));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(alt_id1_unique_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(alt_id2_unique_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(alt_id3_unique_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(alt_id4_unique_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(AltdfltPSG));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(citizen_nationality_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(default_race_code));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(serverdate));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(nat_id));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(alt_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(request.getParameter("apply_oth_name")));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(request.getParameter("First_Name")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(request.getParameter("Second_Name")));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(request.getParameter("Third_Name")));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(request.getParameter("Family_Name")));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(request.getParameter("first_name_loc_lang")));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(request.getParameter("second_name_loc_lang")));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(request.getParameter("third_name_loc_lang")));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(request.getParameter("family_name_loc_lang")));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(request.getParameter("Alt_Id_No")));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(request.getParameter("Alt_Id2_No")));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(request.getParameter("National_Id_No")));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(exestr));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(request.getParameter("Dob")));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(request.getParameter("Area")));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(dflt_pat_regn_blng_class));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(dflt_grp));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(photo_file_name));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(create_file_at_pat_regn_yn));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( (alt_id1_desc == null? "&nbsp;":alt_id1_desc) ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( (alt_id2_desc== null? "&nbsp;":alt_id2_desc) ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( (alt_id3_desc == null? "&nbsp;":alt_id3_desc) ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( (alt_id4_desc == null? "&nbsp;":alt_id4_desc) ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf((String)hash_mp_param.get("name_dervn_logic_long")));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)hash_mp_param.get("name_dervn_logic_oth_lang_long")));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(region_appl_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(postal_code_prompt));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(area_code_prompt));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(town_code_prompt));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(finDtlsChkNationality));
            _bw.write(_wl_block184Bytes, _wl_block184);

		if(pstmt != null) pstmt.close();
		if(inner_stmt != null) inner_stmt.close();
		if(rset != null) rset.close();
		if(rs != null) rs.close();
		if(oth_stmt != null) oth_stmt.close();
		if(oth_stmt1 != null) oth_stmt1.close();
	}
    catch(Exception e)
    {
		out.println("Exception in main try"+e.getMessage()+sql);
		e.printStackTrace();
	}
    finally
    {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC")) {
		
		
            _bw.write(_wl_block185Bytes, _wl_block185);
 } 
            _bw.write(_wl_block186Bytes, _wl_block186);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactAddresses.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateAddress.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mailing.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mailing.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyAlternateAddress.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyHeadofFamily.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.telephoneres.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
}
