package jsp_servlet._emp._jsp._25032024;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import eBL.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eBL.*;
import eMP.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __newpatientregistration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/25032024/NewPatientRegistration.jsp", 1714397559209L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/25032024/PatientAddressLegends.jsp", 1720595267175L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html> \n\n<!-- Last Modified Date Time : 11/5/2005 12:38 PM    -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!-- End Of Common Include -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head> \n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.getElementById(\'r_postal_code\').value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.getElementById(\'m_postal_code\').value= arr[0];\n\t\t\tsendToValidation(7, document.getElementById(\'m_postal_code\'),messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.getElementById(\'next_postal_code\').value= arr[0];\n\t\t\tsendToValidation(7, document.getElementById(\'next_postal_code\'),messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/ValidateControl.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eMP/js/SmartCard.js\"></Script>\n\t<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->\n\t<Script language=\"JavaScript\" src=\"../../eMP/js/EmployeePrivilege.js\"></Script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n\t\t\n\t<Script src=\"../../eMP/js/json02.js\"></Script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/dchk.js\" ></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration4.js\'></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eBL/js/BLClearBean.js\"></script>\n\t<script Language=\"javascript\" src=\"../../eCommon/js/ScanDocument.js\"></script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n <!--Added by Rameswar on  15-03-2016 for MMS-DM-CRF-0035-->\n</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script>\n\t\tclearBeanForBilling();\n\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script> \n\t\t\t if(parent.parent.frames[0].document.forms[0].home)\n\t\t\t\t parent.parent.frames[0].document.forms[0].home.disabled = true;\n\t\t\t if(parent.parent.frames[0].document.forms[0].query)\n\t\t\t\t parent.parent.frames[0].document.forms[0].query.disabled = true;\n\t\t\t if(parent.parent.frames[0].document.forms[0].create)\n\t\t\t\t parent.parent.frames[0].document.forms[0].create.disabled = true;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->\n    <body onSelect=\"codeArrestThruSelect()\" onload=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="telephone();";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="displayScanner();chkNatlIdMandatory(\"onload\");\' onKeyPress=\'return ChkKey(event);\'OnMouseDown=\"CodeArrest()\"  onKeyDown=\'lockKey()\'>\n\t\t<form name=\'PatRegForm\' id=\'PatRegForm\' method=\'post\'   action=\'../../servlet/eMP.PatientRegistrationServlet\' target=\'messageFrame\'>\n\t\t<input type=\'hidden\' name=\'ccount\' id=\'ccount\' value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t<input type=\'hidden\' name=\'patient_grp\' id=\'patient_grp\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t    <!-- <a name=\'demo\'></a> -->\n\t\t\t<div id = \'demo\' name=\'demo\'>\n\t\t\t<input type=\'hidden\' name=\'r_postal_code\' id=\'r_postal_code\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\'> <!-- added by mujafar for ML-MMOH-CRF-0601 -->\n\t\t\t<input type=\'hidden\' name=\'m_postal_code\' id=\'m_postal_code\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'next_postal_code\' id=\'next_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'first_postal_code\' id=\'first_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'employ_postal_code\' id=\'employ_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_town\' id=\'m_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\'>\n\t\t\t<input type=\'hidden\' name=\'n_town\' id=\'n_town\'>\n\t\t\t<input type=\'hidden\' name=\'f_town\' id=\'f_town\'>\n\t\t\t<input type=\'hidden\' name=\'e_town\' id=\'e_town\'>\n\t\t\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_area\' id=\'m_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_area\' id=\'n_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_area\' id=\'f_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_area\' id=\'e_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_region\' id=\'m_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_region\' id=\'n_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_region\' id=\'f_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_region\' id=\'e_region\' value=\'\'>\n\t\t\t<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<input type=\'hidden\' name=\'nkma_town\' id=\'nkma_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact1_region\' id=\'contact1_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'nkma_area\' id=\'nkma_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_ma_postal_code\' id=\'n_ma_postal_code\' value=\'\'>\n\n\t\t\t<input type=\'hidden\' name=\'contact2_res_town\' id=\'contact2_res_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_region\' id=\'contact2_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_res_area\' id=\'contact2_res_area\' value=\'\'>\t\t\n\t\t\t<input type=\'hidden\' name=\'fst_no_ma_pos_cod\' id=\'fst_no_ma_pos_cod\' value=\'\'>\n\t\t\t<!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<input type=\'hidden\' name=\'accept_national_id_no\' id=\'accept_national_id_no\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_oth_pat_ser_yn\' id=\'alt_id1_accept_oth_pat_ser_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric_yn\' id=\'alt_id1_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<!--added by mujafar for ML-MMOH-CRF-524.1 start -->\n\t\t\t<input type=\'hidden\' name=\'alt_id1_alphanum_validate_yn\' id=\'alt_id1_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id2_alphanum_validate_yn\' id=\'alt_id2_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id3_alphanum_validate_yn\' id=\'alt_id3_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id4_alphanum_validate_yn\' id=\'alt_id4_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<!--added by mujafar for ML-MMOH-CRF-524.1 end -->\n\n\t\t\t<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start -->\n\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_oth_pat_ser_yn\" id=\"alt_id2_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" />\n\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_alphanumeric_yn\" id=\"alt_id2_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" /> \n\n\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_oth_pat_ser_yn\" id=\"alt_id3_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_alphanumeric_yn\" id=\"alt_id3_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" /> \n\n\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_oth_pat_ser_yn\" id=\"alt_id4_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_alphanumeric_yn\" id=\"alt_id4_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" />\n\t\t\t<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End -->\n\t\t\t\n\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->\n\t        <input type=\'hidden\' name=\'a_area\' id=\'a_area\' value=\"\">\n\t        <input type=\'hidden\' name=\'a_region\' id=\'a_region\' value=\"\">\n\t        <input type=\'hidden\' name=\'a_town\' id=\'a_town\' value=\"\">\n\t        <!--End this ML-MMOH-CRF-0860.2 -->\n\n\n\t\t    <input type=\'hidden\' name=\'max_patient_age\' id=\'max_patient_age\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'pat_cato_reqd_yn\' id=\'pat_cato_reqd_yn\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></input>  <!-- //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522 -->\n\t\t\t<input type =\'hidden\' name=\'org_member_relationship_code\' id=\'org_member_relationship_code\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'org_member_relationship_desc\' id=\'org_member_relationship_desc\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\"\"></input>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\n\t\t\t<!-- Added by Ashwin K for AAKH-CRF-0150-->\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<!-- Ended by Ashwin K for AAKH-CRF-0150-->\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" \n\t\t\t<tr></tr>\n\t\t\t ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" maxlength=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" size=\'20\' value=\'\'  onblur=\'makeValidString(this);if(\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" == \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\") { document.forms[0].pat_ser_grp_code.focus();}\'></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" size=\'20\' value=\'\' onblur=\'makeValidString(this);if(\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\") { document.forms[0].pat_ser_grp_code.focus();}\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t \n                 </table>\n\t\t\t</div>\t\t\t\t\n\t\t\t<!-- <a name=\'addr\'></a> -->\n\t\t\t<div id = \'addr\' style = \'display:none\'>\n            <table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n                <tr>\n                    <td  class=\'BODYCOLORFILLED\' width=\'1%\'></td>\n                    <td width=\'99%\'  class=\'BODYCOLORFILLED\' valign=\'top\' colspan=\'6\'>\n                    <table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' height=\'100%\' width=\'99.5%\'>\n\t\t\t\t\t        <!--Below line added for this CRF ML-MMOH-CRF-0860.2 -->\n                        <tr>\n                            <td class=\'COLUMNHEADER\'  ></td>\n                            <td  class=\'COLUMNHEADER\' colspan=\'2\'><fmt:message key=\"eMP.residenceaddress.label\" bundle=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n                            <td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' ><fmt:message key=\"eMP.AlternateAddress.label\" bundle=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'4\' ><fmt:message key=\"Common.MailingAddress.label\" bundle=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/></td>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t <td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'><fmt:message key=\"Common.MailingAddress.label\" bundle=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/></td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n                        </tr>\n                        ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n                                <tr><td class=\'label\'  >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" <td class=\'fields\' colspan=\'2\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--Below line added for ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n                                          <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" </td> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--End this ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n                                    <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<a href=\'javascript:copyDetails(4)\'><fmt:message key=\"eMP.CopyResidenceAddress.label\" bundle=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"/></a>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t <script>\n\t\t\t\t        // Added on 13/06/2003 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\t\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line2)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line2.value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line3)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line3.value = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_addr_line4)\n\t\t\t\t\t\t\tdocument.forms[0].r_addr_line4.value = \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].r_town_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_town_code.value = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].r_town.value = \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].r_region.value = \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].r_area.value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\t\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].m_addr_line1)\n\t\t\t\t\t\tdocument.forms[0].m_addr_line1.value = \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].m_addr_line2)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line2.value = \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_addr_line3)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line3.value = \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_addr_line4)\n\t\t\t\t\t\t\tdocument.forms[0].m_addr_line4.value = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].m_town_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_town.value = \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].m_town_code.value = \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_region.value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].m_region_code.value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_area.value = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].m_area_code.value = \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\t\t\t\tdocument.forms[0].m_postal_code1.value = \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\n\t\t\t\t\t\t/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\t\t\tif(document.forms[0].a_addr_line1)\n\t\t\t\t\t\t\tdocument.forms[0].a_addr_line1.value\t= \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t\t\t\t\tif(document.forms[0].a_addr_line2)\n\t\t\t\t\t\t\tdocument.forms[0].a_addr_line2.value\t= \"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].a_addr_line3)\n\t\t\t\t\t\t\tdocument.forms[0].a_addr_line3.value\t= \"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].a_addr_line4)\n\t\t\t\t\t\t\tdocument.forms[0].a_addr_line4.value\t= \"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" ;\n\t\t\t\t\t\tif(document.forms[0].a_town_code){\n\t\t\t\t\t\t\tdocument.forms[0].a_town.value\t\t\t= \"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].a_town_code.value\t\t= \"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].a_region_code){\n\t\t\t\t\t\t\tdocument.forms[0].a_region.value\t\t= \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].a_region_code.value\t= \"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].a_area_code){\n\t\t\t\t\t\t\tdocument.forms[0].a_area.value\t\t\t= \"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].a_area_code.value\t\t= \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].alt_postal_code1){\n\t\t\t\t\t\t\tdocument.forms[0].alt_postal_code1.value = \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\t\t\t\t\t\t\tdocument.forms[0].alt_postal_code.value\t = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t/*End*/\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t// End of addition on 13/06/2003 for assigning values to dynamically generated address related fields..\n\t\t\t\t\t\t </script>\n\t\t\t\t\t\t<tr>\n                         ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="   \n\t\t\t\t\t\t <td  class=\'label\'><fmt:message key=\"Common.country.label\" bundle=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"/> </td>\n                         <td colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'r_country_desc\' id=\'r_country_desc\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" size=\'15\' maxlength=\'15\' onblur=\'if(this.value != \"\") {searchCountry(contry_code[0],r_country_desc)} else{clearCountryFields(this);}\' tabIndex=\'61\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,r_country_desc)\' tabIndex=\'61\'><img id=\'id2\' src=\'../images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'></img><input type=\'hidden\' name=\'r_country_code\' id=\'r_country_code\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n                         </td> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'a_country_desc\' id=\'a_country_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" onblur=\'if(this.value !=\"\") {searchCountry(contry_code[0],a_country_desc); } else {clearCountryFields(this);}\' tabIndex=\'76\' ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,a_country_desc)\' tabIndex=\'76\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'a_country_code\' id=\'a_country_code\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t   <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'m_country_desc\' id=\'m_country_desc\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" onblur=\'if(this.value !=\"\") {searchCountry(contry_code[0],m_country_desc); } else {clearCountryFields(this);}\' tabIndex=\'79\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,m_country_desc)\' tabIndex=\'79\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'m_country_code\' id=\'m_country_code\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--End this CRF ML-MMOH-CRF-0860.2-->\n\t\t\t\t\t\t</tr>\n                        <input type=\'hidden\' name=\'r_invalid_yn\' id=\'r_invalid_yn\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'m_invalid_yn\' id=\'m_invalid_yn\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'a_invalid_yn\' id=\'a_invalid_yn\'>\n\t\t\t\t\t\t<!--Below line Modified for this CRF ML-MMOH-CRf-0860.2 -->\n                        <tr>\n                            ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t<!--below legend name changed ML-MMOH-CRF-939 by Mano--> \n\t\t\t\t\t\t\t<td class=\'label\'  ><fmt:message key=\"eMP.ContactPerson.label\" bundle=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"/></td> \n                            <td colspan=\'2\' class=\'fields\'>\n                                <input type=\'text\' name=\'r_contact_name\' id=\'r_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" tabIndex=\'63\'>\n                            </td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n                                <input type=\'text\' name=\'a_contact_name\' id=\'a_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" tabIndex=\'77\'>\n                            </td >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\t\t\t\t\t\t\t\t\t\n                            <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n                                <input type=\'text\' name=\'m_contact_name\' id=\'m_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" tabIndex=\'80\'>\n                            </td>\t\t\t\t\t\t\t\n                        </tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'2\'><a href=\'javascript:copyDetails(7)\'><fmt:message key=\"eMP.CopyAlternateAddress.label\" bundle=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(4)\'><fmt:message key=\"eMP.CopyResidenceAddress.label\" bundle=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"/></a></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t<!--End this CRF ML-MMOH-CRF-0860.2 --> \n\t\t\t\t\t\t<tr>\n                            <!--Added CRF ML-MMOH-CRF-0601 --> \n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="  ><b><fmt:message key=\"eMP.ContactModes.label\" bundle=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"/></b>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n                            ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n                        </tr>\n                       ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t<td class=\'label\'><fmt:message key=\"eMP.othermodes.label\" bundle=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"/> </td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'contact3_mode\' id=\'contact3_mode\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="  onchange=\'enableContactNo(this)\'>\n\t\t\t\t\t\t\t<option value=\'\'>----<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"/>----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact3_no\' id=\'contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'func1();makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t<td class=\'fields\'><select name=\'contact4_mode\' id=\'contact4_mode\' ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact4_no\' id=\'contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'func2();makeValidString(this);\' value=\"\"></td>\n\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'fields\'><select name=\'contact5_mode\' id=\'contact5_mode\' ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact5_no\' id=\'contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'><fmt:message key=\"eMP.othermodes.label\" bundle=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact3_no\' id=\'contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'func1();makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</tr></tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'contact4_mode\' id=\'contact4_mode\' ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact4_no\' id=\'contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'func2();makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</tr></tr>\n\t\t\t\t\t\t<td class=\'fields\'></td>\n\t\t\t\t\t\t<td  >\n\t\t\t\t\t\t\t<select name=\'contact5_mode\' id=\'contact5_mode\' ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact5_no\' id=\'contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\t       <!--Below line added for this CRF ML-MMOH-CRf-0601 -->\n\t\t\t\t\t\t\t\t\t\t<tr><td class=\'COLUMNHEADER\' ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" ><b><fmt:message key=\"Common.additionaldetails.label\" bundle=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"/></b></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n                        </table>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t  </table>\n\t\t\t</div>\n           \n\t\t    <!-- <a name=\'kin\'></a> -->\n\t\t\t<div id = \'NextOfKin\' style = \'display:none\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t\t<tr>\n\t\t\t\t<td class=\"white\">\n\t\t\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"/>\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabClicked\" id = \'kin\'>\n\t\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"kinspan\"><fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"/></span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabA\" id = \'kin1\'>\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kin1span\"><fmt:message key=\"Common.firsttonotify.label\" bundle=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"/> </span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\"/>\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabA\" id = \'empyr\'>\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"empyrspan\"><fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"/></span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\t\n\t\t\t\t\t</ul>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\'>\n            <tr>\n\t\t\t\t<td valign=top width=\'45%\'>\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' width=\'40%\'><fmt:message key=\"Common.name.label\" bundle=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"/></td>\n\t\t\t\t\t<!--Below line modified for ML-MMOH-CRF-0887.1-->\n\t\t\t\t\t<td class=\'fields\' width=\'60%\'>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t<textarea name=\'next_contact_name\' rows=3 maxlength=80 cols=45 onblur=\'makeValidString(this); maxLengthPaste(this);\' onkeypress=\'checkMaxLimit(this,80)\' onkeyup=\'RemoveSpecialChar(this)\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</textarea>\n\t\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t<input type=\"text\" name=\"next_contact_name\" id=\"next_contact_name\" value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' maxlength=\'80\' size=\'30\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t<!--above next_contact name length change against CRF-0887 by mano on 25/7/2017-->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 =" \n\t\t\t\t<!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007 -->\n\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t<tr>\n\t\t\t\t<td  class=\"label\" ><fmt:message key=\"eMP.AliasName.label\" bundle=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"/></td>\n\t\t\t\t<td  class=\'fields\'>\n\t\t\t\t<input type=\'text\' name=\'rel_alias_name\' id=\'rel_alias_name\' maxlength=\'30\' size=\'20\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t<!-- Ended for ML-MMOH-CRF-1527 -->\n\t\t\t\t<tr><td  class=\'label\' ><fmt:message key=\"Common.relationship.label\"  bundle=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"/></td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t <td  class=\'fields\'> <input type=\'text\' name=\'next_contact_relation_desc\' id=\'next_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(next_contact_relation,next_contact_relation_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'next_contact_relation_id\'  name=\'next_contact_relation_code_id\' id=\'next_contact_relation_code_id\' value=\'?\' class=\'button\' onclick=\'searchRelationship(this,next_contact_relation_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'next_contact_relation\' id=\'next_contact_relation\' value=\"\">\t<td> \n\t\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td><td class=\'fields\'> <input type=\'text\' name=\'contact1_new_nat_id_no\' id=\'contact1_new_nat_id_no\' maxlength=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' size=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'  onblur=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" onkeypress=\'return ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>   \n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="<td  class=\'label\'><input type=\'hidden\' name=\'contact1_new_nat_id_no\' id=\'contact1_new_nat_id_no\' value=\'\' ></td>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t<tr><td  class=\'label\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</td><td class=\'fields\'><input type=\'hidden\' name=\'contact1_alt_id1_type\' id=\'contact1_alt_id1_type\' value= \"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\"> <input type=\'text\' name=\'contact1_alt_id1_no\' id=\'contact1_alt_id1_no\' maxlength=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' onblur=\'makeValidString(this);\' onKeyPress=\'return SpecialCharRestriction(event)\' value= \'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' ></td></tr>";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td><td class=\'fields\'> <input type=\'hidden\' name=\'contact1_alt_id2_type\' id=\'contact1_alt_id2_type\' value= \"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"><input type=\'text\' name=\'contact1_alt_id2_no\' id=\'contact1_alt_id2_no\' maxlength=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'  onblur=\'makeValidString(this);\' onKeyPress=\'return SpecialCharRestriction(event)\' value= \'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</td><td class=\'fields\'><input type=\'hidden\' name=\'contact1_alt_id3_type\' id=\'contact1_alt_id3_type\' value= \"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\"> <input type=\'text\' name=\'contact1_alt_id3_no\' id=\'contact1_alt_id3_no\' maxlength=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td><td class=\'fields\'><input type=\'hidden\' name=\'contact1_alt_id4_type\' id=\'contact1_alt_id4_type\' value= \"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"> <input type=\'text\' name=\'contact1_alt_id4_no\' id=\'contact1_alt_id4_no\' maxlength=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\t\t\t\n\t\t\t\t\t<tr><td  class=\'label\'><fmt:message key=\"Common.otheraltid.label\" bundle=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\"/></td>\n                    <td class=\'fields\' nowrap>\n\t\t\t\t\t\t<select name=\'contact1_oth_alt_id_type\' id=\'contact1_oth_alt_id_type\' onChange=\'enableOtherAltIdText(this.value)\' > \n\n\t\t\t\t\t\t<option value=\'\'>----<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\"/>----</option>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t</select>\n                        <input type=\'text\' name=\'contact1_oth_alt_id_no\' id=\'contact1_oth_alt_id_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\'  DISABLED value = \"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"></td></tr>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t<tr><td  class=\'label\'><fmt:message key=\"Common.birthDate.label\" bundle=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\"/></td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'contact1_birth_date\' id=\'contact1_birth_date\' id=\'birthdate1\' maxlength=\'10\' size=\'10\' onblur=\'makeValidString(this);gotoNext(this)\' value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\' ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"birthdate\"  onClick=\"document.forms[0].contact1_birth_date.select();return showCalendar(\'birthdate1\');\" >\n                    </td></tr>\t\n                <!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007 -->\n                ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n                <tr>\n                <td class=\"label\" ><fmt:message key=\"Common.nationality.label\" bundle=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"/></td>\n\t\t\t    <td class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'rel_nationality_desc\' id=\'rel_nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\") {searchCountry(rel_contry_code, rel_nationality_desc);}\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" ><input type=\'button\' name=\'rel_contry_code\' id=\'rel_contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,rel_nationality_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'rel_nationality_code\' id=\'rel_nationality_code\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t    </tr>\n\t\t\t    <tr>&nbsp;</tr>\n\t\t\t    ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t\t<tr><td  class=\"label\" ><fmt:message key=\"Common.race.label\" bundle=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"/>\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'rel_race_desc\' id=\'rel_race_desc\' size=\'20\' maxlength=\'20\' onblur=\'if(this.value !=\"\") {searchRace(rel_race_code,rel_race_desc);}\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\"><input type=\'button\' name=\'rel_race_desc_id\' id=\'rel_race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,rel_race_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'rel_race_code\' id=\'rel_race_code\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t    <!-- Ended for ML-MMOH-CRF-1527 -->\n\t\t\t\t<tr><td  class=\'label\'><fmt:message key=\"eMP.occupation.label\" bundle=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"/></td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'next_job_title\' id=\'next_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'>\n                    </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t</table>\n\t\t\t\t</td> \n\t\t\t\t<td width=\'55%\'>\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' border=\'0\' width=\'100%\'>\n                <!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t<td><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\'  ></td>\n                     <td  class=\'COLUMNHEADER\' ><fmt:message key=\"eMP.residenceaddress.label\" bundle=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"/></td>\n                     <td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.MailingAddress.label\" bundle=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\"/></td>\n                </tr>\n                </td>\n                ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n                <!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n                ";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 =" \n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' ><fmt:message key=\"Common.country.label\" bundle=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"/></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_country_desc\' id=\'next_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\' onblur=\'if(this.value !=\"\") {searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this);}\' tabindex=\'65\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,next_country_desc)\' tabindex=\'65\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'next_country_code\' id=\'next_country_code\' value=\'\'>\n\t\t\t\t\t</td>\n\t\t\t\t<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'nk_ma_country_desc\' id=\'nk_ma_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' onblur=\'if(this.value !=\"\") {searchCountry(nk_ma_country_code,nk_ma_country_desc);}else{clearCountryFields(this);} \' tabindex=\'68\'><input type=\'button\' name=\'nk_ma_country_code\' id=\'nk_ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nk_ma_country_desc)\' tabindex=\'68\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'nkin_mail_country_code\' id=\'nkin_mail_country_code\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' nowrap ><fmt:message key=\"eMP.ContactPerson.label\" bundle=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"/></td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ra_contact_name\' id=\'ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" tabindex=\'66\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ma_contact_name\' id=\'ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" tabindex=\'69\'>\n                    </td></tr>\n                 <table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t    <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(10)\'><fmt:message key=\"eMP.CopyFirsttoNotify.label\" bundle=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<a href=\'javascript:copyDetails(8)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(9)\'><fmt:message key=\"eMP.CopyResidenceAddress.label\" bundle=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"/></a>\n\t\t\t    </td></tr></table></table>\n\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="<!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.homephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\"/></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n                    <td  class=\'label\' ><fmt:message key=\"Common.MobileNo.label\" bundle=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"/></td>\n                    <td class=\'fields\'><input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'></td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.officephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"/></td>\n                    <td class=\'fields\'><input type=\'text\' name=\'next_off_tel_no\' id=\'next_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n                    </td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\"/></td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'>\n                    </td>\n                </tr>\n\t\t\t\t ";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="   <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t</td></tr></table>\n\t\t\t<tr>\n\t\t    </table>\n\t\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'2\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t\t <td class=\'label\' width=\'20%\'><!-- <a href=\'javascript:copyDetails(5)\'><fmt:message key=\"eMP.CopyFirsttoNotify.label\" bundle=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"/></a> --></td>\n\t\t\t\t\t <td class=\'label\' width=\'55%\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(1)\'  id=\'copy_head\' style=\'visibility:hidden\'><fmt:message key=\"eMP.CopyHeadofFamily.label\" bundle=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"/></a>&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t<!--Added by Shagar GDOH-CRF-0111 -->\n                     ";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t\t \n\t\t\t\t\t<a href=\'javascript:copyDetails(2)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\"/></a>\t\t\t\t\t \n\t                  ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t <a href=\'javascript:copyDetails(5)\'><fmt:message key=\"eMP.CopyFirsttoNotify.label\" bundle=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\"/></a>&nbsp;&nbsp;&nbsp;<a href=\'javascript:copyDetails(2)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\"/></a>\n\t\t\t\t\t \n\t\t\t\t\t \n\t\t\t\t\t </td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t  </tr>\n\t\t\t  </table>\n\t\t\t</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t<table width=\"100%\"><tr>\n\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'7\' ><fmt:message key=\"eMP.ContactModes.label\" bundle=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"/></td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.homephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'></td>\n\t\t\t\t\n                    <td  class=\'label\' ><fmt:message key=\"Common.MobileNo.label\" bundle=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\'></td>\n\t\t\t\t\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'></td>\n                    \n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'><fmt:message key=\"eMP.othermodes.label\" bundle=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'nk_contact3_mode\' id=\'nk_contact3_mode\' ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact3_no\' id=\'nk_contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact4_mode\' id=\'nk_contact4_mode\' ";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact4_no\' id=\'nk_contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact5_mode\' id=\'nk_contact5_mode\' ";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact5_no\' id=\'nk_contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr></table>\n\t\t\t";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t</table>\n\t\t\t</div>\n           <!-- Added for New tab-->\t\t \t\t\t\n\t\t<!-- <a name=\'kin1\'></a> -->\n\t\t<div id = \'FirstToNotify\' style = \'display:none\'>\n\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\"/>\">\n\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabA\" id=\'kin\'>\n\t\t\t\t\t<span class=\"tabAspan\" id=\"kinspan\"><fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabClicked\" id=\'kin1\'>\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"kin1span\"> <fmt:message key=\"Common.firsttonotify.label\" bundle=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\n\n\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"/>\">\n\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabA\" id=\'empyr\'>\n\t\t\t\t\t<span class=\"tabAspan\" id=\"empyrspan\"><fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\"/></span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t</ul>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n        <table border = 0 cellspacing=\'0\' cellpadding=\'0\' width=\'100%\'>\n\t \t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\n\t\t<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n        ";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n         <tr>\n\t\t\t\t<td class=\'bodycolorfilled\'></td>\n\t\t\t\t<td valign=top>\n\t\t\t\t\t<table cellspacing=\'1\' cellpadding=\'3\' width=\'100%\' border=\'0\'>\n                            <tr>&nbsp;</tr>\n\t\t\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.name.label\" bundle=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' maxlength=\'80\' value=\"\" value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t</td>\n\t\t </tr>\n\t\t <tr>\n\t\t\t\t\t   <td class=\'label\'><fmt:message key=\"Common.relationship.label\" bundle=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t   <input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  id=\'first_contact_relation_id\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>\n                    ";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'text\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\"\"  maxlength=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'   value=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="<input type=\'hidden\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\'\' >";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t\t\t<tr><td  class=\'label\' nowrap><fmt:message key=\"Common.otheraltid.label\" bundle=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' onchange=\'nenableAltID()\' >\n                            <option value=\'\'>---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\"/>---</option>\n                            ";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n                    </select><input type=\'text\' name=\'notify_oth_alt_id_text\' id=\'notify_oth_alt_id_text\' value=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'  maxlength=\'20\' size=\'20\' disabled onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"eMP.occupation.label\" bundle=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value= \'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'>\n                    </td>\n\t\t\t\t</tr></table>\n\t\t";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n         <tr>\n\t\t\t\t<td class=\'bodycolorfilled\' width=\'15%\'></td>\n\t\t\t\t<td>\n\t\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=\'0\'>\n\n\t\t\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.name.label\" bundle=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\"/></td><td class=\'fields\'><input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' maxlength=\'80\' value=\"\" value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\n\t\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.officephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\"/></td>\n\t\t\t\t\t\t<td  class=\'filed\'><input type=\'text\' name=\'first_off_tel_no\' id=\'first_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'></td>\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!-- Below line commented ML-MMOH-CRF-0860.2-->\n\t\t\t\t\t<!--<tr>\n\t\t\t\t\t\t<td class=\'label\'><fmt:message key=\"Common.relationship.label\" bundle=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\"/></td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  id=\'first_contact_relation_id\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'><td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\'><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\"/></td>\n\t\t\t\t\t\t<td  class=\'filed\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' \n\t\t\t\t\t\tvalue = \'\'></td>\t\t\t\t\t\t   \n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>-->\n\t\t\t\t\t<!--End ML-MMOH-CRF-0860.2-->\n\t\t\t\t\t<tr>\n\t\t\t\t\t   <td class=\'label\'><fmt:message key=\"Common.relationship.label\" bundle=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\"/></td>\n\t\t\t\t\t    <td class=\'fields\'><input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  id=\'first_contact_relation_id\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n\t\t\t\t\t\t  <td class=\'label\'><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\"/></td>\n\t\t\t\t\t\t  <td class=\'fields\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' \n\t\t\t\t\t\tvalue = \'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\"\"  maxlength=\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t\t\t\t<td  class=\'label\' colspan=2><a href=\'javascript:copyDetails(6)\'><fmt:message key=\"eMP.CopyNextofKin.label\" bundle=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(3)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\"/></a> </td>\n\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t\t\t<tr><td  class=\'label\'><fmt:message key=\"Common.otheraltid.label\" bundle=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\"/></td>\n\t\t\t\t\t\t\t<td class=\'fields\'><select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' onchange=\'nenableAltID()\' >\n                            <option value=\'\'>---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'  maxlength=\'20\' size=\'20\' disabled onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t\t\t\t\t\t<td  class=\'label\' colspan=2>";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="<a href=\'javascript:copyDetails(6)\'><fmt:message key=\"eMP.CopyNextofKin.label\" bundle=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\"/></a> ";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="</td>\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\"/></td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value= \'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'>\n                    </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t</tr>\n\t\t  \n\t\t<!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\t\t<td width=\'55%\'><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\' ></td>\n                     <td  class=\'COLUMNHEADER\' ><fmt:message key=\"eMP.residenceaddress.label\" bundle=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\t\t\t<!--Ended by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="                \n                <tr>\n\t\t\t\t  <td  class=\'label\'><fmt:message key=\"Common.country.label\" bundle=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\"/></td>\n                  <td class=\'fields\'><input  type=\'text\' value=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\' name=\'first_country_desc\'  size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],first_country_desc);}else{clearCountryFields(this);}\' tabindex=\'65\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_country_desc)\' tabindex=\'65\'></td>\n\t\t\t\t  <input type=\'hidden\' name=\'first_country_code\' id=\'first_country_code\' value=\'\'>\n\t\t\t\t  <!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\t\n\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'first_mail_country_desc\' id=\'first_mail_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\' onblur=\'if(this.value !=\"\") {searchCountry(ma_country_code,first_mail_country_desc);}else{clearCountryFields(this);} \' tabindex=\'68\'><input type=\'button\' name=\'ma_country_code\' id=\'ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_mail_country_desc)\' tabindex=\'68\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'first_mail_country_code\' id=\'first_mail_country_code\' value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\"/></td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ra_contact_name\' id=\'fton_ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" tabindex=\'66\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ma_contact_name\' id=\'fton_ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" tabindex=\'69\'>\n                    </td>\n\t\t\t\t</tr>\n\n\t\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t    <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(13)\'><fmt:message key=\"eMP.CopyNextofKin.label\" bundle=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<a href=\'javascript:copyDetails(11)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(12)\'><fmt:message key=\"eMP.CopyResidenceAddress.label\" bundle=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\n\t\t\t\t\t\t<td  class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t<td  class=\'filed\'>&nbsp;</td>\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\n                 \n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t    <td  class=\'label\' ><fmt:message key=\"Common.homephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\"/></td>\n                    <td class=\'fields\'><input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\'label\' ><fmt:message key=\"Common.MobileNo.label\" bundle=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\"/></td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t   <td  class=\'label\' ><fmt:message key=\"Common.officephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\"/></td>\n\t\t                   <td class=\'fields\'><input type=\'text\' name=\'first_off_tel_no\' id=\'first_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t <td  class=\'label\'><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\"/></td>\n\t\t\t\t\t\t\t <td class=\'fields\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\'fields\' ><a href=\'javascript:copyDetails(6)\'><fmt:message key=\"eMP.CopyNextofKin.label\" bundle=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(3)\'><fmt:message key=\"eMP.CopyPatientAddress.label\" bundle=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\"/></a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n                    ";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\t\n\t\t\t\t<!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\"/></td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t    <td  class=\'label\' nowrap ><fmt:message key=\"Common.homephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\'></td>\n\t\t\t\t    \n\t\t\t\t\t\t\n\t\t\t\t    <td  class=\'label\' nowrap ><fmt:message key=\"Common.MobileNo.label\" bundle=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\'></td>\n\t\t\t\t    \n\n\t\t\t\t    <td  class=\'label\' nowrap ><fmt:message key=\"Common.email.label\" bundle=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'fton_contact3_mode\' id=\'fton_contact3_mode\' ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact3_no\' id=\'fton_contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact4_mode\' id=\'fton_contact4_mode\' ";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact4_no\' id=\'fton_contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact5_mode\' id=\'fton_contact5_mode\' ";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact5_no\' id=\'fton_contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr></table>\n\t\t\t";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n\t\t\t\t</table>\n\t\t\t\t<td class=\'bodycolorfilled\' width=\'15%\'></td>\n\t\t\t</tr>\n\t\t\t</table> \n\t\t\t</div>\n\t\t\t\n            <!-- <a name=\'empyr\'></a> -->\n\t\t\t<div id = \'EmplyrDtls\' style = \'display:none\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t\t<tr>\n\t\t\t<td width= \"100%\" class=\"white\">\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\"/>\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabA\" id=\'kin\'>\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kinspan\"><fmt:message key=\"Common.nextofkin.label\" bundle=\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\"/></span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabA\" id=\'kin1\'>\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kin1span\"> <fmt:message key=\"Common.firsttonotify.label\" bundle=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\"/></span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"<fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\"/>\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabClicked\" id=\'empyr\'>\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"empyrspan\"><fmt:message key=\"Common.employmentdetails.label\" bundle=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\"/></span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t</ul>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n        <table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t<tr>\n                <td align=\'center\' class=\'COLUMNHEADER\' ><fmt:message key=\"Common.employerdetails.label\" bundle=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\"/></td>\n\t\t\t\t<td align=\'center\' class=\'COLUMNHEADER\' ><fmt:message key=\"Common.employeedetails.label\" bundle=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\"/></td>\n        </tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t\t<!--Below line modified for this CRF ML-MMOH-CRF-0860.2 increase the maxlength 30 to 50-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' ><fmt:message key=\"Common.orgName.label\" bundle=\"";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\"/></td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'organization_name\' id=\'organization_name\' maxlength=\'";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\'   onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\" ></input>\n                    </td>\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t <td class=\'label\' ><fmt:message key=\"eMP.ContactPersonName.label\" bundle=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\"/></td>\n                  <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_contact_name\' id=\'empyr_contact_name\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\"></input>\n                    </td>\n\t\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="              \n                <tr>\n                    <td  class=\'label\'><fmt:message key=\"Common.country.label\" bundle=\"";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\"/> </td>\n                    <td class=\'fields\'><input type=\'text\' name=\'empyr_country_desc\' id=\'empyr_country_desc\'                       size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],empyr_country_desc);}else {clearCountryFields(this);} \' ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,empyr_country_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'empyr_country_code\' id=\'empyr_country_code\' value=\'\'>\n                   </td>\n               </tr>\n               <tr>\n                   <td  class=\'label\'><fmt:message key=\"Common.homephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\"/></td>\n                   <td >\n                       <input type=\'text\' name=\'res3_tel_no\' id=\'res3_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\">\n                   </td>\n                </tr>\n\t\t\t\t<tr>\n                   <td  class=\'label\'><fmt:message key=\"Common.officephoneno.label\" bundle=\"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\"/></td>\n                   <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_off_tel_no\' id=\'empyr_off_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\">\n                   </td>\n               </tr>\n\t\t\t   </table>\n\t\t\t</td>\n\t\t\t<td valign=top>\n\t\t\t<table cellspacing=\'1\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t\t   <tr>\n\t\t\t\t\t<td class=\'label\'  ><fmt:message key=\"Common.employmentid.label\" bundle=\"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\"/></td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_eid\' id=\'empyr_eid\' maxlength=\'20\' size=\'20\'  onfocus=\'\' onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\"></input>\n                    </td>\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 =" \n\t\t\t\t\t\t<SCRIPT>document.forms[0].empyr_eid.value = \'";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\';\n\t\t\t\t\t\tdocument.forms[0].empyr_eid.readOnly = true;</script>\n\t\t\t\t";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  ><fmt:message key=\"eMP.OccupationClass.label\" bundle=\"";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\"/></td>\n\t\t\t\t\n\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'occ_class_desc\' id=\'occ_class_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchOccupationClass(occ_class,occ_class_desc);sendToServer(15,occ_class);}else{clearfields();clearOccPer(document.forms[0].occ_of_per);} enableocpn_class();\'    ><input type=\'button\'  id=\'occ_class_id\'  name=\'occ_class_code_id2\' id=\'occ_class_code_id2\' value=\'?\' class=\'button\' onclick=\'searchOccupationClass(this,occ_class_desc);if(document.forms[0].occ_class.value!=\"\"){sendToServer(15,occ_class);}\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'occ_class\' id=\'occ_class\' value=\"\"> </td>\n\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  ><fmt:message key=\"eMP.OccupationofthePerson.label\" bundle=\"";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\"/></td>\n                    <td class=\'fields\'>\n                        <select name=\'occ_of_per\' id=\'occ_of_per\'  onChange=\'enableocpn();\'>\n                            <option value=\'\'>---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\"/>---</option>\n                        </select>\n\t\t\t\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0860.2 increase the maxLength from 30 to 50-->\n                        <input type=\'text\' name=\'occu_of_per_desc\' id=\'occu_of_per_desc\' size=\'";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\' maxlength=\'";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\' onblur=\'\'  onblur=\'makeValidString(this);\' value = \"\"></input>\n                    </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  ><fmt:message key=\"Common.status.label\" bundle=\"";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\"/></td>\n                    <td class=\'fields\'>\n                        <select name=\'empyr_employment_status\' id=\'empyr_employment_status\'  onblur=\"document.forms[0].organization_name.focus()\" onchange=\'\'>\n                            <option value=\'\'>---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\"/>---</option>\n                            <option value=\'FE\'><fmt:message key=\"eMP.FullTimeEmployed.label\" bundle=\"";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'FS\'><fmt:message key=\"eMP.FullTimeStudent.label\" bundle=\"";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'NA\'><fmt:message key=\"Common.notapplicable.label\" bundle=\"";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\"/></option>\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'PE\'><fmt:message key=\"eMP.PartTimeEmployed.label\" bundle=\"";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'PS\'><fmt:message key=\"eMP.PartTimeStudent.label\" bundle=\"";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'SE\'><fmt:message key=\"eMP.SelfEmployed.label\" bundle=\"";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'UE\'><fmt:message key=\"eMP.Unemployed.label\" bundle=\"";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\"/></option>\n\t\t\t\t\t\t\t\t<option value=\'UK\'><fmt:message key=\"Common.unknown.label\" bundle=\"";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\"/></option>\n                        </select>\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\n\t\t\t\t</table>\n\t\t\t</table>\n\t\t\t</div>             \n            <!-- <a name=\'pat_docs_tab\'></a> -->\n\t\t\t<div id = \'pat_docs_tab\' style = \'display:none\'>\n            <table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\'>\n                <tr>\n                    <td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.documenttype.label\" bundle=\"";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\"/></td>\n                    <td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.documentno.label\" bundle=\"";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\"/></td>\n                    <td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.expiryDate.label\" bundle=\"";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\"/></td>\n                    <td  class=\'COLUMNHEADER\' ><fmt:message key=\"eMP.PlaceOfIssue.label\" bundle=\"";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\"/></td>\n                    <td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.IssueDate.label\" bundle=\"";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\"/></td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td  class=\'COLUMNHEADER\' ><fmt:message key=\"Common.UplodDoc.label\" bundle=\"";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\"/></td>\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n                </tr>\n\n                ";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\n                <tr>\n                  \t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id1_desc\' id=\'doc_id1_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id1,doc_id1_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\'  id=\'doc1_id\'  name=\'doc_code_id1\' id=\'doc_code_id1\' value=\'?\' class=\'button\' onclick=\'searchDocumentType(this,doc_id1_desc); enbl_disble(doc_id1_desc);\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id1\' id=\'doc_id1\' value=\"\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n                    \n                    <td class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_num1\' id=\'doc_num1\'  size=15 maxlength=15  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_num1\' id=\'doc_num1\' value=\"\" size=15 maxlength=15  onblur=\'makeValidString(this);\' disabled value =\'\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t\t\t\t\t<img id=\'doc1\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt1\' id=\'doc_exp_dt1\' id=\"docexpdt1\" size=10 maxlength=10  onblur = \'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt1\' id=\'doc_exp_dt1\' id=\"docexpdt1\" size=10 maxlength=10  onblur = \'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\");return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate1\" disabled onClick=\"document.forms[0].doc_exp_dt1.select();return showCalendar(\'docexpdt1\');\" >\n                    </td>\t\t\t\t\t\t\t\t\t\t\t  \n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue1\' id=\'place_of_issue1\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\">\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date1\' id=\'issue_date1\' id=\"issuedate1\" value=\'";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\' size=10 maxlength=10  onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value=\'\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date1\' id=\'issue_date1\' id=\"issuedate1\" value=\'";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\' size=10 maxlength=10  onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\");return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value=\'\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt1\" disabled onClick=\"document.forms[0].issue_date1.select();return showCalendar(\'issuedate1\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t \t<td class=\'fields\'><div id=\'doc1imageId\'> <input type=\'file\' name=\'doc1image\' id=\'doc1image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t<!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\t\n\t\t\t\t\t\n\t\t\t\t\t<input type=\'button\' name=\'doc1scan\' id=\'doc1scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\',\'MP\',\'";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\',this);\" style=\'visibility:hidden\'> \n\t\t\t\t\t </div></td></td>\n\t\t\t\t\t <input type=\'hidden\' name=\'iDocFolderOption\' id=\'iDocFolderOption\' value=\"";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'iDocScanEnabled\' id=\'iDocScanEnabled\' value=\"";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\n\t\t\t\t\t <input type=\'hidden\' name=\'document_id1\' id=\'document_id1\' value=\"";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id2_desc & doc2_code_id2 -->\n         \t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id2_desc\' id=\'doc_id2_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id2,doc_id2_desc);}else{clearfields();} enbl_disble(this);\'    ><input type=\'button\'  id=\'doc2_id\'  name=\'doc2_code_id2\' id=\'doc2_code_id2\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id2_desc); enbl_disble(doc_id2_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id2\' id=\'doc_id2\' value=\"\">\n\n\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num2\' id=\'doc_num2\' size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\'>\n\t\t\t\t\t\t<img id=\'doc2\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt2\' id=\'doc_exp_dt2\' id = \"docexpdt2\" size=10 maxlength=10 disabled onblur = \'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt2\' id=\'doc_exp_dt2\' id = \"docexpdt2\" size=10 maxlength=10 disabled onblur = \'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\");return ChkForIssueDate(this,document.forms[0].issue_date2);\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate2\" disabled onClick=\"document.forms[0].doc_exp_dt2.select();return showCalendar(\'docexpdt2\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue2\' id=\'place_of_issue2\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\'>\n                    </td>\n                    <td>\n                        <!--<input type=\'text\' name=\'issue_date2\' id=\'issue_date2\' id=\"issuedate2\" value=\"";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)\'  onblur=\'makeValidString(this);\' value=\'\'> --><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date2\' id=\'issue_date2\' id=\"issuedate2\" value=\"";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\");return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)\'  onblur=\'makeValidString(this);\' value=\'\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt2\" disabled onClick=\"document.forms[0].issue_date2.select();return showCalendar(\'issuedate2\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'> <div id=\'doc2imageId\'><input type=\'file\' name=\'doc2image\' id=\'doc2image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\n\t\t\t\t\t\n\t\t\t\t\t <input type=\'button\' name=\'doc2scan\' id=\'doc2scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id2\' id=\'document_id2\' value=\'";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id3_desc & doc3_code_id3 -->\n                 \t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id3_desc\' id=\'doc_id3_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id3,doc_id3_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\'  id=\'doc3_id\'  name=\'doc3_code_id3\' id=\'doc3_code_id3\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id3_desc); enbl_disble(doc_id3_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id3\' id=\'doc_id3\' value=\"\">\n\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num3\' id=\'doc_num3\' size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n\t\t\t\t\t\t<img id=\'doc3\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt3\' id=\'doc_exp_dt3\' id=\"docexpdt3\" size=10 maxlength=10 disabled  onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt3\' id=\'doc_exp_dt3\' id=\"docexpdt3\" size=10 maxlength=10 disabled  onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\");return ChkForIssueDate(this,document.forms[0].issue_date3);\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate3\" disabled onClick=\"document.forms[0].doc_exp_dt3.select();return showCalendar(\'docexpdt3\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue3\' id=\'place_of_issue3\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\">\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date3\' id=\'issue_date3\' id=\"issuedate3\" value=\"";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)\'  onblur=\'makeValidString(this);\' value = \"\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date3\' id=\'issue_date3\' id=\"issuedate3\" value=\"";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\");return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)\'  onblur=\'makeValidString(this);\' value = \"\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt3\" disabled onClick=\"document.forms[0].issue_date3.select();return showCalendar(\'issuedate3\');\" >\n                    </td>\n\t\t\t\t\t  <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'><div id=\'doc3imageId\'> <input type=\'file\' name=\'doc3image\' id=\'doc3image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\n\t\t\t\t\t \n\t\t\t\t\t <input type=\'button\' name=\'doc3scan\' id=\'doc3scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id3\' id=\'document_id3\' value=\'";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id4_desc & doc4_code_id4 -->\n           \t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id4_desc\' id=\'doc_id4_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id4,doc_id4_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\'  id=\'doc4_id\'  name=\'doc4_code_id4\' id=\'doc4_code_id4\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id4_desc); enbl_disble(doc_id4_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id4\' id=\'doc_id4\' value=\"\">\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num4\' id=\'doc_num4\' value=\"";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\" size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\'>\n\t\t\t\t\t\t<img id=\'doc4\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt4\' id=\'doc_exp_dt4\' id=\"docexpdt4\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt4\' id=\'doc_exp_dt4\' id=\"docexpdt4\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\");return ChkForIssueDate(this,document.forms[0].issue_date4);\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate4\" disabled onClick=\"document.forms[0].doc_exp_dt4.select();return showCalendar(\'docexpdt4\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue4\' id=\'place_of_issue4\' value=\"";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\" size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' >\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date4\' id=\'issue_date4\' id=\"issuedate4\" value=\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)\'  onblur=\'makeValidString(this);\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date4\' id=\'issue_date4\' id=\"issuedate4\" value=\"";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\");return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)\'  onblur=\'makeValidString(this);\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt4\" disabled onClick=\"document.forms[0].issue_date4.select();return showCalendar(\'issuedate4\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'><div id=\'doc4imageId\'> <input type=\'file\' name=\'doc4image\' id=\'doc4image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t<!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\n\t\t\t\t\t \n\t\t\t\t\t <input type=\'button\' name=\'doc4scan\' id=\'doc4scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id4\' id=\'document_id4\' value=\'";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t\n                </tr>\n            </table>\n\t\t\t<br>\n\n\t\t\t\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\'>\n                <tr>\n                    <td  class=\'COLUMNHEADER\' colspan=\'4\'><fmt:message key=\"Common.Miscellaneous.label\" bundle=\"";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\"/></td>\n                </tr>\n                <tr>\n                    <td  class=\'label\' ><fmt:message key=\"Common.Dependency.label\" bundle=\"";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\"/></td>\n\n                    <td  class=\'fields\' colspan=\'3\'>\n                        <select name=\'living_dependency\' id=\'living_dependency\'>\n                            <option value=\'UN\'><fmt:message key=\"Common.NotKnown.label\" bundle=\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\"/></option>\n                            <option value=\'D\'><fmt:message key=\"eMP.SpouseDependent.label\" bundle=\"";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\"/></option>\n                            <option value=\'M\'><fmt:message key=\"eMP.MedicalSupervisionReqd.label\" bundle=\"";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\"/></option>\n                            <option value=\'S\'><fmt:message key=\"eMP.SmallChildren.label\" bundle=\"";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\"/></option>\n                            <option value=\'WU\'><fmt:message key=\"eMP.WalkUp.label\" bundle=\"";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\"/></option>\n                        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n\t\t\t   </tr>\n                <tr>\n                    <td  class=\'label\' ><fmt:message key=\"eMP.Arrangement.label\" bundle=\"";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\"/></td>\n                    <td class=\'fields\' colspan=\'3\'>\n                        <select name=\'living_arrangement\' id=\'living_arrangement\' >\n                            <option value=\'U\'><fmt:message key=\"Common.unknown.label\" bundle=\"";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\"/> </option>\n                            <option value=\'A\'><fmt:message key=\"eMP.Alone.label\" bundle=\"";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\"/></option>\n                            <option value=\'F\'><fmt:message key=\"eMP.family.label\" bundle=\"";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\"/></option>\n                            <option value=\'R\'><fmt:message key=\"eMP.relative.label\" bundle=\"";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\"/> </option>\n                            <option value=\'S\'><fmt:message key=\"eMP.spouseonly.label\" bundle=\"";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\"/> </option>\n                        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                </tr>\n                \n                <tr>\n                    <td class=\'label\' ><fmt:message key=\"eMP.EducationLevel.label\" bundle=\"";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\"/></td>\n             \t\t<td  class=\'fields\'> <input type=\'text\' name=\'education_level_desc\' id=\'education_level_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchEducation(education_level,education_level_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'education_level_id\'  name=\'education_level_id1\' id=\'education_level_id1\' value=\'?\' class=\'button\' onclick=\'searchEducation(this,education_level_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'education_level\' id=\'education_level\' value=\"\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\n                </tr>\n                \n                <tr><td  class=\'bodycolorfilled\' colspan=5></td></tr>\n                <tr><td  class=\'COLUMNHEADER\' colspan=5><fmt:message key=\"eMP.RegistrationSource.label\" bundle=\"";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\"/></td></tr>\n                <tr>\n                    <td  width=\'25%\' class=\'label\' ><fmt:message key=\"eMP.Informant.label\" bundle=\"";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\"/></td>\n                    <td  width=\'75%\' colspan=\'4\' class=\'fields\'>\n                        <input type=\'text\' name=\'regn_informant\' id=\'regn_informant\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\'></td>\n                </tr>\n\n                <tr>\n                    <td  width=\'25%\' class=\'label\' ><fmt:message key=\"eMP.InformantRemarks.label\" bundle=\"";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\"/></td>\n                    <td  class=\'fields\' colspan=3>\n                        <font name=\'verdana\'><textarea name=\'regn_comments\' rows=\'2\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,100)\' onBlur=\'makeValidString(this);checkLength(this,100)\'  value=\'";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\'></textarea></font>\n                    </td>\n                </tr>\n\n                <tr><td  class=\'bodycolorfilled\' colspan=5></td></tr>\n                <tr><td  class=\'COLUMNHEADER\' colspan=5 ><fmt:message key=\"Common.generalRemarks.label\" bundle=\"";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\"/></td></tr>\n               \n                <tr>\n                    <td width=\'25%\' class=\'label\' ></td>\n                    <td width=\'75%\' class=\'fields\' colspan=3>\n\t\t\t\t\t";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="    \n\t\t\t\t\t\t\t<textarea name=\'general_remarks\' rows=\'5\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,500)\' onblur=\'makeValidStringRemark(this);checkLength(this,500);\'></textarea>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\n\t\t\t\t\t\t\t<textarea name=\'general_remarks\' rows=\'5\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,500)\' onblur=\'makeValidStringRemark(this);checkLength(this,500);\'>";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="</textarea>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\n                    </td>\n                </tr>\n            </table>\n\t\t\t</table>\n\t\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'>\n                   ";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\n                </tr>\n            </table> \t\t\t\n";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\t\t\t\n\t\t\t<script>\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" != \'\' && document.getElementById(\"next_addr_line1\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_addr_line1\").value=\"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\"; \n\t\t\t\tif(\"";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\" != \'\' && document.getElementById(\"next_addr_line2\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_addr_line2\").value=\"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\" != \'\' && document.getElementById(\"next_addr_line3\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_addr_line3\").value=\"";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\" != \'\' && document.getElementById(\"next_addr_line4\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_addr_line4\").value=\"";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\" != \'\' && document.getElementById(\"contact1_res_area_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact1_res_area_code\").value=\"";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" != \'\' && document.getElementById(\"contact1_region_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact1_region_code\").value=\"";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\" != \'\' && document.getElementById(\"next_postal_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_postal_code\").value=\"";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\" != \'\' && document.getElementById(\"contact1_res_town_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact1_res_town_code\").value=\"";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\" != \'\' && document.getElementById(\"fton_addr_line1\") != null)\n\t\t\t\t\tdocument.getElementById(\"fton_addr_line1\").value=\"";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\" != \'\' && document.getElementById(\"fton_addr_line2\") != null)\n\t\t\t\t\tdocument.getElementById(\"fton_addr_line2\").value=\"";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" != \'\' && document.getElementById(\"fton_addr_line3\") != null)\n\t\t\t\t\tdocument.getElementById(\"fton_addr_line3\").value=\"";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\" != \'\' && document.getElementById(\"fton_addr_line4\") != null)\n\t\t\t\t\tdocument.getElementById(\"fton_addr_line4\").value=\"";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\" != \'\' && document.getElementById(\"contact2_res_town_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact2_res_town_code\").value=\"";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" != \'\' && document.getElementById(\"contact2_res_area_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact2_res_area_code\").value=\"";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\" \n\t\t\t\tif(\"";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" != \'\' && document.getElementById(\"contact2_region_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact2_region_code\").value=\"";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" != \'\' && document.getElementById(\"first_postal_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"first_postal_code\").value=\"";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\" != \'\' && document.getElementById(\"first_contact_relation\") != null)\n\t\t\t\t\tdocument.getElementById(\"first_contact_relation\").value=\"";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" != \'\' && document.getElementById(\"employ_addr_line1\") != null)\n\t\t\t\t\tdocument.getElementById(\"employ_addr_line1\").value=\"";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\" != \'\' && document.getElementById(\"employ_addr_line2\") != null)\n\t\t\t\t\tdocument.getElementById(\"employ_addr_line2\").value=\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" != \'\' && document.getElementById(\"employ_addr_line3\") != null)\n\t\t\t\t\tdocument.getElementById(\"employ_addr_line3\").value=\"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\" != \'\' && document.getElementById(\"employ_addr_line4\") != null)\n\t\t\t\t\tdocument.getElementById(\"employ_addr_line4\").value=\"";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" != \'\' && document.getElementById(\"contact2_res_town_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact3_res_town_code\").value=\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\";\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\" != \'\' && document.getElementById(\"contact3_region_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact3_region_code\").value=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\" != \'\' && document.getElementById(\"contact3_res_area_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact3_res_area_code\").value=\"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" != \'\' && document.getElementById(\"employ_postal_code\") != null)\n\t\t\t\t\tdocument.getElementById(\"employ_postal_code\").value=\"";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\";\n\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\" != \'\' && document.getElementById(\"contact3_mode\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact3_mode\").value=\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" != \'\' && document.getElementById(\"contact3_no\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact3_no\").value=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" != \'\' && document.getElementById(\"contact4_mode\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact4_mode\").value=\"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\" != \'\' && document.getElementById(\"contact4_no\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact4_no\").value=\"";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\"\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" != \'\' && document.getElementById(\"contact5_mode\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact5_mode\").value=\"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\" != \'\' && document.getElementById(\"contact5_no\") != null)\n\t\t\t\t\tdocument.getElementById(\"contact5_no\").value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\" != \'\' && document.getElementById(\"next_contact_relation\") != null)\n\t\t\t\t\tdocument.getElementById(\"next_contact_relation\").value=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\" !=\'\' && document.getElementById(\"contact1_oth_alt_id_type\") != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"contact1_oth_alt_id_type\").value = \"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\";\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t\n\n\t\t <!-- The below hidden fields should always be before the code which is the below script -->\n\t\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_long\' id=\'name_drvn_logic_long\' value=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang_long\' id=\'name_drvn_logic_oth_lang_long\' value=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\"";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"\"></input>\n            <input type=\'hidden\' name=\'patient_name_loc_lang\' id=\'patient_name_loc_lang\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_group\' id=\'patient_group\' value=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'nat_series_loaded\' id=\'nat_series_loaded\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'First_Name\' id=\'First_Name\' value=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Second_Name\' id=\'Second_Name\' value=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Third_Name\' id=\'Third_Name\' value=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Family_Name\' id=\'Family_Name\' value=\"";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patientName\' id=\'patientName\' value=\"";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patientNameLocLang\' id=\'patientNameLocLang\' value=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\"></input>\n            <input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\'S\'></input>\n            <input type=\'hidden\' name=\'pass_val\' id=\'pass_val\' value=\'N\'></input>\n            <input type=\'hidden\' name=\'error_alt_no1\' id=\'error_alt_no1\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no2\' id=\'error_alt_no2\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no3\' id=\'error_alt_no3\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no4\' id=\'error_alt_no4\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_expiry_date\' id=\'error_expiry_date\' value=\"\"></input>\n            <input type=\'hidden\' name=\'Alt_Id1_Unique_Yn1\' id=\'Alt_Id1_Unique_Yn1\' value=\"";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\"></input>\n            <input type=\'hidden\' name=\'Alt_Id2_Unique_Yn2\' id=\'Alt_Id2_Unique_Yn2\' value=\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\"></input>\n            <input type=\'hidden\' name=\'Alt_Id3_Unique_Yn3\' id=\'Alt_Id3_Unique_Yn3\' value=\"";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\"\'></input>\n            <input type=\'hidden\' name=\'Alt_Id4_Unique_Yn4\' id=\'Alt_Id4_Unique_Yn4\' value=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_pat_ser_grp_code\' id=\'dflt_pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\"></input>\n            <input type=\'hidden\' name=\'dflt_pref_facility_id\' id=\'dflt_pref_facility_id\' value=\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\"></input>\n            <input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'\'></input>\n\t\t\t<input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\"";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\"></input>\n            <input type=\'hidden\' name=\'town_desc\' id=\'town_desc\' value=\"\"></input>\n            <input type=\'hidden\' name=\'appt_ref_no\' id=\'appt_ref_no\' value=\"";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\"></input>\n            <input type=\'hidden\' name=\'booking_ref_no\' id=\'booking_ref_no\' value=\"";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\"></input>\n            <input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\'></input>\n           \t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\"";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'refrlAappt\' id=\'refrlAappt\' value=\'\'></input>\n\t\t\t<input type =\'hidden\' name=\'refIDValue\' id=\'refIDValue\' value=\'\'></input>\n\t\t\t<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->\n\t\t\t<input type=\'hidden\' name=\'region_prompt1\' id=\'region_prompt1\' value=\"";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'region_appl_yn1\' id=\'region_appl_yn1\' value=\"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\"></input>\n\n\t\t\t<!--Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324-->\n\t\t\t<input type=\'hidden\' name=\'addr_line1_prompt\' id=\'addr_line1_prompt\' value=\"";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'addr_line2_prompt\' id=\'addr_line2_prompt\' value=\"";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'postal_code_prompt\' id=\'postal_code_prompt\' value=\"";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'area_code_prompt\' id=\'area_code_prompt\' value=\"";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\"></input><!--Added by shagar on 21-10-2016 for  AMRI-CRF-0388-->\n\t\t\t<input type=\'hidden\' name=\'town_code_prompt\' id=\'town_code_prompt\' value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\"></input><!-- Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522 -->\n\t\t\t\n\t\t\t\n            <!-- The above hidden fields should always be before the code which is the below script -->\n\t\t\t\n\t\t\t<!-- The below code in the below script should be fallowed by the above hidden fields -->\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\' != \'\') {\n\t\t\t\t\t\n\t\t\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t\t\tdispMandatoryImage(\'N\');\n\t\t\t\t} else FocusFirstElement()\n\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\' != \'\') {\n\t\t\t\t\tdispMandatoryImage(\'A\');\n\t\t\t\t}\n\n                if(\'";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\' != \'\' && \'";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\' == \'\') {\n\t\t\t\t\tgotoNext(document.forms[0].date_of_birth);\n\t\t\t\t}\n\n            \tif(parent.patient_main.document.getElementById(\"patient_name\")) {\n\t\t\t\t\tif((\'";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\' != \'DuplicateRegistration\' && \'";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\' != \'\') || (\'";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\' == \'P\')) {\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\" != \'\') {\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t//\tparent.parent.frames[1].frames[0].document.forms[0].patient_name.value = \"";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\";\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tputPatientName(document.forms[0].first_name);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\t\n\t\t\t\t\t\tputPatientName(document.forms[0].first_name);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(parent.patient_main.document.getElementById(\"patient_name_loc_lang\")) {\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\' != \'\') {\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\" != \'\') {\n\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].patient_name_loc_lang.value = \"";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\";\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tputLocalLangPatientName(document.forms[0].first_name_oth_lang);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\t\n\t\t\t\t\t\tputLocalLangPatientName(document.forms[0].first_name_oth_lang);\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t/*\n\t            if(\"";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\" != \'\') { \n\t\t\t\t\tif ( (parent.frames[0].document.forms[0].patient_name) && (parent.frames[0].document.forms[0].patient_name.value == \'\') ) {\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_name.value = \"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t*/\n\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script> \t\n\t\n            <input type=\'hidden\' name=\'blood_grp\' id=\'blood_grp\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'rh_factor\' id=\'rh_factor\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_nat_id_chk_val\' id=\'dflt_nat_id_chk_val\' value=\"\"></input>\n\n\t\t\t<input type=\'hidden\' name=\'a_ethnic_group_code\' id=\'a_ethnic_group_code\' value=\"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\"";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Family_No\' id=\'Family_No\' value=\"";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id_No\' id=\'Alt_Id_No\' value=\"";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id2_No\' id=\'Alt_Id2_No\' value=\"";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id3_No\' id=\'Alt_Id3_No\' value=\"";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id4_No\' id=\'Alt_Id4_No\' value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_a_national_id_no\' id=\'temp_a_national_id_no\' value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_referral_id\' id=\'temp_referral_id\' value=\"";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_booking_ref_no\' id=\'temp_booking_ref_no\' value=\"";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_nat_id\' id=\'temp_nat_id\' value=\"";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_appt_ref_no\' id=\'temp_appt_ref_no\' value=\"";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId1Desc\' id=\'altId1Desc\' value=\"";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId2Desc\' id=\'altId2Desc\' value=\"";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId3Desc\' id=\'altId3Desc\' value=\"";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId4Desc\' id=\'altId4Desc\' value=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'FamilyNoLink\' id=\'FamilyNoLink\' value=\"";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\"";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'datasource_id\' id=\'datasource_id\' value=\"\"></input>\n\t\t\t<input type =\'hidden\' name=\'appfirstname\' id=\'appfirstname\' value=\"";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'appsecondname\' id=\'appsecondname\' value=\"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\"></input>\n            <input type =\'hidden\' name=\'appthirdname\' id=\'appthirdname\' value=\"";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\"></input>\n            <input type =\'hidden\' name=\'appfamilyname\' id=\'appfamilyname\' value=\"";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\"></input>\n            <input type =\'hidden\' name=\'appdateofbirth\' id=\'appdateofbirth\' value=\"";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\"></input>\n            <input type =\'hidden\' name=\'appsex\' id=\'appsex\' value=\"";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\"></input>\n            <input type =\'hidden\' name=\'appprefix\' id=\'appprefix\' value=\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\"></input>\n            <input type =\'hidden\' name=\'appsuffix\' id=\'appsuffix\' value=\"";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\"></input>\n            <input type =\'hidden\' name=\'appt_yn\' id=\'appt_yn\' value=\"";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\"";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\"></input>\n           \t<input type=\'hidden\' name=\'dr_function_id\' id=\'dr_function_id\' value=\"";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\"></input> \n\t\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\'></input>\n\t\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\'></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=\"";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\">\n\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'photo_file_name\' id=\'photo_file_name\' value=\"";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 =".jpg\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_alt_id1_in_emp_id_yn\' id=\'dflt_alt_id1_in_emp_id_yn\' value=\"";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\">\n\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\"></input> \t\t\t\n\t\t\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"PatRegForm\"></input>\n\t\t\t<input type=\'hidden\' name=\'img_dir_name\' id=\'img_dir_name\' value=\"\"></input>\n\n\t\t\t<input type=\'hidden\' name=\'deceased_yn\' id=\'deceased_yn\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'deceased_date\' id=\'deceased_date\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'dla_image_yn\' id=\'dla_image_yn\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'upload_patient_id\' id=\'upload_patient_id\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'output\' id=\'output\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'funCall\' id=\'funCall\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'bl_success_msg\' id=\'bl_success_msg\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'Photo_upload_yn\' id=\'Photo_upload_yn\' value=\"N\"></input>\n\t\t";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\n\t\t\t";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 =" \n\t\t\t";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\n\t\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\n\t\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t\t";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\n\t\t\t\n\t\n\t\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\n\t\t\t<!-- FOR MYKAD READING -->\n\t\t\t<OBJECT id=Cad style=\\\"WIDTH: 149px; HEIGHT: 25px\\\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>\n\t\t\t<OBJECT id=jpndf1 style=\\\"WIDTH: 192px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>\n\t\t\t<OBJECT id=jpndf4 style=\\\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>\n\t\t\t<OBJECT id=gmpcpic style=\\\"WIDTH: 345px; HEIGHT: 303px\\\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>\n\t\t\t<!-- END FOR MYKAD READING -->\n\t\t\t";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\n\t \t<script>\n\t\t/* \nBelow line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065]*/\nfunction makeValidStringRemark(txtObj)\n{  \n    var text_value  =   txtObj.value;\n\t\n    while(text_value.indexOf(\'\"\')!=-1)\n    {\n        text_value = text_value.replace(\'\"\',\"\'\");\n    }\n\t\n\twhile (text_value.indexOf(\'+\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'+\',\"\");\n\t}\n\twhile (text_value.indexOf(\'%\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'%\',\"\");\n\t}\n\t\n    txtObj.value = text_value;\n\n    if(text_value.indexOf(\"&\")==(text_value.length-1))\n    {\n        return false;\n    }\n\n    for(var i=0; i<text_value.length; i++)\n    {\n        if( (text_value.charAt(i)==\'&\')  || (text_value.charAt(i)==\'<\') )\n        {\n            if(text_value.charAt(i+1)!=\' \')\n            {\n                text_value  =   text_value.substring(0,(i+1))+\' \'+ text_value.substring((i+1),text_value.length);\n                i++;\n            }\n        }\n    }\n    txtObj.value = text_value;\n    if(txtObj.value.length>txtObj.maxLength)\n    {\n        alert(getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null));\n\n        txtObj.select();\n        txtObj.focus();\n    }\n}\n\t\t/*SKR-SCF-0631 [IN035065]*/\t\n\t\t\t\n\t\t\tpopulateethnicity();\n\t\t\tdispMandatoryImage(id);\n\t\t\tdispMandatoryImageForOthNames();\n\t\t</script>\n\t\t\n\t\t<!--Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF-->\n\t\t<input type=\'hidden\' name=\'fileTypeSiteSpec\' id=\'fileTypeSiteSpec\' value=\'";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\'></input>\n\t\t<input type=\'hidden\' name=\'alterAddressApplicable\' id=\'alterAddressApplicable\' value=\'";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\'></input>\n\t\t<!--Added by Ashwini on 07-Sep-2018-->\n\t\t<input type=NewPatientRegistration\'hidden\' name=\'finDtlsChkNationality\' id=\'finDtlsChkNationality\' value=\'";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\'></input>\n\t\t<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US007 -->\n\t\t<input type=\'hidden\' name=\'aliasnameNationalityRace\' id=\'aliasnameNationalityRace\' value=\'";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="\'></input>\n\t\t<!-- Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008 -->\n        <input type=\'hidden\' name=\'resiAddMailAdd\' id=\'resiAddMailAdd\' value=\'";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\'></input>\n        <input type=\'hidden\' name=\'isVirtualConsultation\' id=\'isVirtualConsultation\' value=\'";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\'></input><!--Added by Arthi for ML-MMOH-CRF-1930 US004-->\n\n\t\t\n\t\t</form>\n    </body>\n</html>\n";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="\n<!--End-->\n\n";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

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
			alert("rset1"+rset1);
	          
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
			 
			 addr_line1 = "<textarea name='r_addr_line1' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line2 = "<textarea name='r_addr_line2' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line3 = "<textarea name='r_addr_line3' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 			 
			}else{			
		     addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			 addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
             addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			}			
			//End this ML-MMOH-CRF-0860.2
			
			
			String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
             
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
				res_town_prompt		= rset1.getString("res_town_prompt");
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				region_prompt		= rset1.getString("region_prompt");
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
            _bw.write(_wl_block3Bytes, _wl_block3);
 
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

	 
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
  
 
 
	int tindex				= 1;
	int Demoaddlcnt		= 0;
	int Contactaddlcnt	= 0;
	int Othersaddlcnt		= 0;
	int order					= 1;
	Connection con		= ConnectionManager.getConnection(request);
	Properties p				= (java.util.Properties) session.getValue("jdbc");
	PreparedStatement stmt			= null;
	Boolean iSSiteApplicable = false;//added by shagar against GDOH-CRF-0111
	//PreparedStatement stmt1			= null;
	//PreparedStatement stmt_bl		= null;            
	//PreparedStatement doc_pstmt	= null;
	PreparedStatement oth_stmt		= null;	
	ResultSet rset				= null;
	ResultSet rs				= null;
	//ResultSet rs_bl				= null;
	//ResultSet doc_rs			= null;
	ResultSet oth_rset		= null;
	//ResultSet rs		= null;
	String patient_grp		= checkForNull( request.getParameter("group") );
	String bl_install_yn		= (String) session.getValue("mp_bl_oper_yn");
	String Facility				= (String) session.getValue("facility_id");

	String operation				= "";
	String dflt_pat_regn_blng_class = "";
	String sql						= "";
	String maintain_doc_or_file		= "";
	String family_org_id_accept_yn		= "";
	String entitlement_by_pat_cat_yn		= "";
	String pat_category_reqd_yn = ""; //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522
	String org_member_relationship_code		= "";
	String org_member_relationship_desc		= "";
	String FamilyNoLink				= "";
	String a_nationality_code		= "";
	String ext_system_interface_yn	= "";
	String dfltPSG					= "";
	String citizen_nationality_code	= "";
	//String sql_bl					= null;
	String name_prefix_reqd_yn		="";
   String cust_fields[]			= new String[5];
   
	//Added by Kamatchi S for ML-MMOH-CRF-1930 US004
	Boolean isVirtualConsultation = false;
	isVirtualConsultation=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION");
	String countryC = "";
	countryC = checkForNull(eMP.MPCommonBean.getCountryFrmFacility(con,Facility,locale) );

	String classcode="";
	String classdesc="";
	String countryD = "";

	ArrayList codes	= null;
	ArrayList descs	= null; 
	
	ArrayList acodes	= new ArrayList();
	ArrayList adescs	= new ArrayList();
   
	HashMap hash_Map2 = new HashMap();
	//Below Added by Suji Keerthi for ML-MMOH-CRF-1527
	HashMap hash_Map	= new HashMap();
	HashMap hash_Map3   = new HashMap();
	HashMap hash_Map6	= new HashMap();
	

	Object altidcode[]		= null;
	Object altiddesc[]		= null;
	Object contactmode[]	= null;
	Object contactdesc[]	= null;
	Object relationcode[]	= null;
	Object relationdesc[]	= null;
	
	String[] contact_col_names	= null;
	String[] contact_prompts		= null;
	String[] contact_fields			= null;

	Object oth_code[] = null; 
	Object oth_desc[] = null; 
	
	String PatInfflag = checkForNull(request.getParameter("PatIdflag"));
	/*Added to clear the bean values Start*/
	String bean_id = "";
	String bean_name = "";
	BLInsuranceImageBean blInsuranceImageBean 		= 	null;
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	blInsuranceImageBean					= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageBean.clearBean();
	
            _bw.write(_wl_block13Bytes, _wl_block13);

	/*Added to clear the bean values End*/		
	
	/****** Imp. Note1: The sequence of getting the alt_id param value should always fallow the getting of AltIdNo param value ******/	

	String AltIdNo		= checkForNull( request.getParameter("Alt_Id_No") ); 

	/*** Thee values of variable 'alt_id' i.e., Alternate ID1 which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/

	String alt_id		= checkForNull(request.getParameter("alt_id")); 
	if(patient_grp.equals("A")) {
		if(!alt_id.equals("")) {
			AltIdNo = alt_id;
		}
	}
	
	/****** End of Imp. Note1 Ends ******/	

	/****** Imp. Note2: The sequence of getting the nat_id param value should always fallow the getting of a_national_id_no param value ******/	

	String a_national_id_no = checkForNull(request.getParameter("National_Id_No"));
	//hash_mp_param=eMP.NewbornDetails.getNewBornRelMandatory(con);
	
     
				
	/*** Thee values of variable 'nat_id' i.e., National ID which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/
	String nat_id = checkForNull( request.getParameter("nat_id") );
				
	if(patient_grp.equals("N")) {
		if(!nat_id.equals("")) {
			a_national_id_no = nat_id;
		}
	}
	
	/****** End of Imp. Note2 Ends ******/	

	String AltIdNo2					=  checkForNull(request.getParameter("Alt_Id2_No")); 
	String AltIdNo3					=  checkForNull(request.getParameter("Alt_Id3_No")); 
	String AltIdNo4					=  checkForNull(request.getParameter("Alt_Id4_No")); 
	String func_act					=  checkForNull(request.getParameter("func_act")); 
	String function_id					=  checkForNull(request.getParameter("function_id")); 
	String referral_id					=  checkForNull(request.getParameter("referral_id")); 
	String booking_ref_no			=  checkForNull(request.getParameter("booking_ref_no"));
	String init_appt_ref_no			=  checkForNull(request.getParameter("appt_ref_no"));
	String init_referral_id				=  checkForNull(request.getParameter("referral_id")); 
	String init_booking_ref_no		=  checkForNull(request.getParameter("booking_ref_no"));
	String init_a_national_id_no	=  checkForNull(request.getParameter("National_Id_No"));
	String init_nat_id					=  checkForNull(request.getParameter("nat_id")); 
	String refIDValue					=  checkForNull(request.getParameter("refIDValue")); 
	String refrlAappt					=  checkForNull(request.getParameter("refrlAappt")); 
	String appt = "";
	String appt_ref_no				= request.getParameter("appt_ref_no");
	String patient_id	=	checkForNull(request.getParameter("patient_id"));
   

	if(refrlAappt.equals("A") || refrlAappt.equals("R") || refrlAappt.equals("L") || refrlAappt.equals("I"))
		PatInfflag="N";
	else if(refrlAappt.equals("P"))
		PatInfflag="Y";

	
	if (appt_ref_no.equals("null"))  
		appt_ref_no = "" ;
    if (appt_ref_no.equals("")) 
		appt="N" ;
    else 
		appt = "Appt";

	if(!func_act.equals("") || !appt_ref_no.equals("")) operation = "insert";
	else operation = "Generate_File";

	if(!patient_grp.equals("N")) {
		if(!AltIdNo.equals("")&& patient_grp.equals("G")) 
			patient_grp = "A" ;
	}
	String q_booking_type = checkForNull( request.getParameter("q_booking_type") );

	String a_alt_id1_no = AltIdNo;

	String a_alt_id2_no	= AltIdNo2, a_alt_id3_no = AltIdNo3, a_alt_id4_no = AltIdNo4, a_alt_id1_exp_date = "";
	String a_alt_id2_exp_date = "", a_alt_id3_exp_date = "", a_alt_id4_exp_date = "";
	String a_oth_alt_id_type = "", a_oth_alt_id_no = "", a_race_code = "", a_ethnic_group_code = "";
	String a_res_addr_line1 = "", a_res_addr_line2	= "", a_res_addr_line3	= "";
	String a_res_addr_line4 = "", a_res_area_code = "", a_res_town_code = "", a_postal_code = "",a_postal_desc="";
	String a_country_code = "", a_res_country_desc = "", a_res_region_code = "", a_res_tel_no = "";
	String a_oth_contact_no = "", a_email_id = "", a_name_prefix = "", a_res_town_desc = "";
	String a_res_area_desc = "", a_res_region_desc = "", a_mail_addr_line1 = "";
	String a_mail_addr_line2 = "", a_mail_addr_line3 = "", a_mail_addr_line4 = "";
	String a_mail_town_code	= "", a_mail_area_code	= "", a_mail_country_code = "";
	String a_mail_country_desc = "", a_mail_postal_code = "", a_mail_region_code = "",a_mail_postal_desc="";
	String a_mail_town_desc	= "", a_mail_area_desc = "", general_remarks = "";
	String a_mail_region_desc = "", Site = "", a_birth_place_code = "", a_birth_place_desc = "";
	String a_place_of_birth	= "", relgn_code = "", contact3_mode = "", contact3_no = "";
	String contact4_mode = "", contact4_no = "", contact5_mode = "", contact5_no = "";
	String nkin_contact_name = "", nkin_contact_relation = "", contact1_nat_id_no = "";
	String contact1_alt_id1_no = "", contact1_alt_id2_no = "", contact1_alt_id3_no = "";
	String contact1_alt_id4_no = "", contact1_oth_alt_id_type = "", nkin_oth_alt_id_no = "";
	String contact1_birth_date = "", nkin_job_title = "", nkin_addr_line1 = "", nkin_addr_line2 = "";
	String nkin_addr_line3 = "", nkin_addr_line4 = "", nkin_area_long_desc = "";
	String nkin_region_long_desc = "", nkin_postal_code	= "", nkin_town_long_desc = "";
	String nkin_country_name = "", nkin_res_tel_no = "", nkin_mob_tel_no = "", nkin_off_tel_no = "";
	String nkin_email_id = "", fton_contact_name = "", fton_contact_relation = "", fton_alt_id_no = "";
	String fton_job_title = "", fton_nat_id_no = "", fton_addr_line1 = "", fton_addr_line2 = "";
	String fton_addr_line3 = "", fton_addr_line4 = "", fton_town_long_desc = "";
	String fton_area_long_desc = "", fton_region_long_desc = "", fton_postal_code = "";
	String fton_country_name = "", fton_res_tel_no = "", fton_mob_tel_no = "", fton_off_tel_no = "";
	String fton_email_id = "", organization_name = "", emplr_contact_name = "", emplr_addr_line1 = "";
	String emplr_addr_line2	= "", emplr_addr_line3	= "", emplr_addr_line4 = "", doc1_num = "";
	String emplr_off_tel_no	= "", emplr_res_tel_no	= "", patient_employee_id = "", doc2_num = "";
	String emplr_town_long_desc	= "", emplr_region_long_desc = "", emplr_area_long_desc	= "";
	String emplr_postal_code = "", emplr_country_name = "", doc1_exp_date = "", doc3_num = "";
	String doc1_place_of_issue = "", doc1_iss_date = "", doc2_exp_date = "", doc2_place_of_issue = "";
	String doc2_iss_date = "", doc3_exp_date = "", doc3_place_of_issue = "", doc3_iss_date = "";
	String doc4_num = "", doc4_exp_date = "", doc4_place_of_issue = "", doc4_iss_date = "";
	String informant = "", informant_remarks = "", dflt_alt_id1_in_emp_id_yn = "N";
	//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	String nk_mail_country_desc="", nkin_m_country_desc="";
	String nk_contact3_mode="", nk_contact3_no="";
	String nk_contact4_mode="", nk_contact4_no="";
	String nk_contact5_mode="", nk_contact5_no="";
	String resadd_contact_name ="",mailadd_contact_name =""; 
	String fton_mail_country_desc="", fton_m_country_desc="";
	String fton_resadd_contact_name="", fton_mailadd_contact_name="";
	String fton_contact3_mode="", fton_contact3_no="";
	String fton_contact4_mode="", fton_contact4_no="";
	String fton_contact5_mode="", fton_contact5_no="";
	//Ended for ML-MMOH-CRF-1527 US008
	/*Below variable added for this [RUT-CRF-0011]*/
	String patient_cat_code=""; String patient_cat_desc=""; String language_id="";String language_desc="";

	String dflt_language_id="",dflt_relgn_code="",inv_pat_search_in_reg_pat_yn="N";
	String res_contact_name ="";
	String mail_contact_name ="";
	String nkin_alias_name =""; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US007
	String a_first_name		= checkForNull( request.getParameter("First_Name") );
	String a_second_name	= checkForNull( request.getParameter("Second_Name") );
	String a_third_name		= checkForNull( request.getParameter("Third_Name") );
	String a_family_name		= checkForNull( request.getParameter("Family_Name") );	

	String a_family_name_loc_lang		= checkForNull( request.getParameter("a_family_name_loc_lang") );
	String a_first_name_loc_lang		= checkForNull( request.getParameter("a_first_name_loc_lang") );
	String a_second_name_loc_lang		= checkForNull( request.getParameter("a_second_name_loc_lang") );
	String a_third_name_loc_lang		= checkForNull( request.getParameter("a_third_name_loc_lang") );
	String a_patient_name_loc_lang		= checkForNull( request.getParameter("a_patient_name_loc_lang") ); 	


	String drfunctionid		= checkForNull( request.getParameter("dr_function_id") );
	// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
	String country_reqd_yn="N",region_reqd_yn="N",mobile_no_reqd_yn="N";
	String country_visibility = "visibility:hidden";
	String region_visibility = "visibility:hidden";
	String mobile_no_visibility = "visibility:hidden";
	String region_prompt		= "";
	String region_appl_yn		= "";
	// New parameter  is added against AMRI-CRF-0388 by Shagar
	String postal_cd_reqd_yn="N",area_reqd_yn="N";
	String town_reqd_yn="N"; //Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522
	//String postal_visibility = "visibility:hidden";
	//String area_visibility = "visibility:hidden";
	//Ends here
/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	String addr_line1_prompt		= "";
	String addr_line2_prompt		= "";
	String postal_code_prompt		= "";
	String area_code_prompt		    = ""; /*Added against AMRI-CRF-0388 by Shagar*/
	String town_code_prompt         = ""; /*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/	

	/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
	String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
	String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
	String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
	/*End*/

	// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
	String email_id_reqd_yn = "N";
	String email_visibility = "visibility:hidden"; //Ends here
	if(a_family_name.length() >= 1) {
		int ch = a_family_name.charAt(0);
		if((ch >= 65 && ch <= 90) || (ch >= 97) && ch <= 122) {
			a_family_name = (a_family_name.substring(0,1)).toUpperCase() + a_family_name.substring(1);
		} 
	}
	
	String a_name_suffix = "", a_patient_name = "", a_patient_long_name = "",a_patient_long_name_loc_lang = "",year = "", days	= "", months = "", a_legal_yn = "",hours = "";
	String max_pat_age = "", a_citizen_yn = "", pat_name_as_multipart_yn = "";
	String Accept_oth_alt_id_yn	= "", create_file_at_pat_regn_yn = "";
	String accept_national_id_no_yn	= "N", alt_id1_accept_oth_pat_ser_yn = "N"; 
	String alt_id1_accept_alphanumeric_yn = "N";
	//added by mujafar for ML-MMOH-CRF-524.1 start
	String alt_id1_alphanum_validate_yn = "N" ;
	String alt_id2_alphanum_validate_yn = "N" ;
	String alt_id3_alphanum_validate_yn = "N" ;
	String alt_id4_alphanum_validate_yn = "N" ;
	//added by mujafar for ML-MMOH-CRF-524.1 end
	String nat_id_accept_alphanumeric_yn = "N";
	String a_name_prefix_loc_lang="", a_name_suffix_loc_lang = ""; 

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start */
	String alt_id2_accept_oth_pat_ser_yn		= "";
	String alt_id2_accept_alphanumeric_yn		= "";
	String alt_id3_accept_oth_pat_ser_yn		= "";
	String alt_id3_accept_alphanumeric_yn		= "";
	String alt_id4_accept_oth_pat_ser_yn		= "";
	String alt_id4_accept_alphanumeric_yn		= "";
	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End */


	
	a_patient_name_loc_lang= "";

	String a_gender			= checkForNull( request.getParameter("Sex") ); 
	if (a_gender.equals("A"))
		 a_gender="";

	//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
	 a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";
	

	String a_date_of_birth	= checkForNull(request.getParameter("Dob")); 
	String a_familyno			= checkForNull(request.getParameter("Family_No"));
	String nat_invoke_routine = "";
	String nat_data_source_id = "";
	String nat_id_check_digit_id = "";
	String nat_id_chk_len  = "";
	String def_nat_id_pat_ser_grp   = "";

	String function_name =""; //Added by Ashwin K for AAKH-CRF-0150

	String pat_series =""; //Added by Ashwin K for AAKH-CRF-0150


	ArrayList contact_addr  = fetchContactAddresses(con, out,"parent.parent.messageFrame",p);
	Site							= (String)contact_addr.get(0);
	contact_col_names		= (String[])contact_addr.get(1);
	contact_prompts			= (String[])contact_addr.get(2);
	contact_fields				= (String[])contact_addr.get(3);
	//contact_addr				= null;
	
	
// This array building is now handled in PatNamesComp.jsp
	
	/*Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF*/
	Boolean fileTypeSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FILE_TYPE_RESTRICT");
	
    iSSiteApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "COPY_FIRST_NOTIFY_REMOVED");
	Boolean addr_pincode_mand = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ADDR_PINCODE_MAND");
	/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	Boolean finDtlsChkNationality = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FIN_DTLS_CHK_NATIONALITY");//Added by Ashwini on 07-Sep-2018
	
	Boolean alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); // added by mujafar for ML-MMOH-CRF-0601	
	Boolean aliasnameNationalityRace	=eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US007
	Boolean resiAddMailAdd   	=eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	//Added for this CRF ML-MMOH-CRF-0860.2
	String maxsize="30";
	String col_span_td="";
	String maximumLength="30";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength){
	  col_span_td="2";
	  maximumLength="50";
	 // maxsize="58";
	 maxsize="64";
	}
	//End this ML-MMOH-CRF-0860.2
	
	//Added for this CRF ML-MMOH-CRF-0601
	String colspantd="colspan=4";	
	if(alterAddressApplicable || increasedaddressLength){
		colspantd="colspan=6";		
	}	 
	//End this ML-MMOH-CRF-0601
	
	//Added by santhosh for TH-KW-CRF-0019.1
	String blood_group = "";//Added by santhosh for TH-KW-CRF-0019.1
	String nat_id_exp_date = "";
	//End
    
	if(appt.equals("Appt") || func_act.equals("Visitreg") || func_act.equals("REF_SEARCH") ||func_act.equals("DuplicateRegistration"))
	{ 
		
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
			
	try
	{
		//query to populate values for Patient Information 		

		if(refrlAappt.equals("P"))
		{
			sql="SELECT b.PATIENT_NAME patient_name,b.patient_long_name patient_long_name,b.patient_long_name_loc_lang patient_long_name_loc_lang,a.addr1_line1 res_addr_line1,a.addr1_line2 res_addr_line2,a.addr1_line3 res_addr_line3,a.addr1_line4 res_addr_line4,a.res_town1_code res_town_code, mp_get_desc.MP_RES_TOWN(a.res_town1_code,'"+locale+"',1) res_town_desc,a.res_area1_code res_area_code,mp_get_desc.MP_RES_AREA(a.res_area1_code,'"+locale+"',1) res_area_desc,a.region1_code res_region_code,mp_get_desc.MP_REGION(a.region1_code,'"+locale+"',1) res_region_desc,a.postal1_code postal_code,mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,a.COUNTRY1_CODE res_country_code ,mp_get_desc.MP_COUNTRY(a.COUNTRY1_CODE,'"+locale+"',1) res_country_desc,a.addr2_line1 mail_addr_line1,a.addr2_line2 mail_addr_line2,a.addr2_line3 mail_addr_line3,a.addr2_line4 mail_addr_line4,a.res_town2_code mail_town_code,mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"',1) mail_town_desc,a.region2_code mail_region_code, mp_get_desc.MP_REGION(a.region2_code,'"+locale+"',1) mail_region_desc,a.res_area2_code mail_area_code, mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"',1) mail_area_desc,a.postal2_code,a.COUNTRY2_CODE mail_country_code,mp_get_desc.MP_COUNTRY(a.COUNTRY2_CODE,'"+locale+"',1) mail_country_desc,postal2_code mail_postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) mail_postal_desc,b.contact1_no res_tel_no,a.CONTACT1_NAME res_contact_name,CONTACT2_NAME mail_contact_name, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc,  a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc, a.alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"','2') alt_postal_desc FROM MP_PAT_ADDRESSES a,mp_patient b WHERE b.PATIENT_ID=a.PATIENT_ID AND b.PATIENT_ID='"+refIDValue+"'";//Modified by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601

			
			
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();	

		}//Query to populate the values from OP
		else if(func_act.equals("DuplicateRegistration"))
		{
			
				StringBuffer  sqlSb = new StringBuffer();
				sqlSb.append("SELECT patient.alt_id1_type alt_id1_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id1_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id1_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id1_desc,");
				sqlSb.append("        patient.alt_id1_no alt_id1_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,");
				sqlSb.append("        patient.alt_id2_type alt_id2_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id2_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id2_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id2_desc,");
				sqlSb.append("        patient.alt_id2_no alt_id2_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,");
				sqlSb.append("        patient.alt_id3_type alt_id3_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id3_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id3_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id3_desc,");
				sqlSb.append("        patient.alt_id3_no alt_id3_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,");
				sqlSb.append("        patient.alt_id4_type alt_id4_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id4_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id4_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id4_desc,");
				sqlSb.append("        patient.alt_id4_no alt_id4_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,");
				sqlSb.append("        patient.birth_place_code birth_place_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.birth_place_code IS NOT NULL  THEN (mp_get_desc.MP_BIRTH_PLACE(patient.birth_place_code,'"+locale+"',1))");
				sqlSb.append("         END) birth_place_desc,");
				sqlSb.append("        patient.place_of_birth place_of_birth,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) ear,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,");
				sqlSb.append("        patient.citizen_yn citizen_yn,");
				sqlSb.append("        pat_rl_con.contact1_alt_id1_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id2_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id2_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id2_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id2_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id3_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id3_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id3_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id3_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id4_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id4_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id4_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id4_no,");
				sqlSb.append("        pat_rl_con.contact1_oth_alt_id_type,");
				sqlSb.append("        pat_rl_con.contact1_nat_id_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id1_type,");
				sqlSb.append("        pat_rl_con.contact2_oth_alt_id_type,");
				sqlSb.append("        patient.contact3_mode contact3_mode,");
				sqlSb.append("        patient.contact3_no contact3_no,");
				sqlSb.append("        patient.contact4_mode contact4_mode,");
				sqlSb.append("        patient.contact4_no contact4_no,");
				sqlSb.append("        patient.contact5_mode contact5_mode,");
				sqlSb.append("        patient.contact5_no contact5_no,");
				sqlSb.append("        patient.oth_alt_id_no oth_alt_id_no,");
				sqlSb.append("        patient.email_id email_id,");
				sqlSb.append("        pat_rl_con.addr3_line1 emplr_addr_line1,");
				sqlSb.append("        pat_rl_con.addr3_line2 emplr_addr_line2,");
				sqlSb.append("        pat_rl_con.addr3_line3 emplr_addr_line3,");
				sqlSb.append("        pat_rl_con.addr3_line4 emplr_addr_line4,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact3_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) emplr_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact3_name emplr_contact_name,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country3_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country3_code,'"+locale+"',1))");
				sqlSb.append("         END) emplr_country_name,");
				sqlSb.append("        pat_rl_con.off3_tel_no emplr_off_tel_no,");
				sqlSb.append("        pat_rl_con.res3_tel_no emplr_res_tel_no,");
				sqlSb.append("        pat_rl_con.postal3_code emplr_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact3_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) emplr_region_long_desc,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact3_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) emplr_town_long_desc,");
				sqlSb.append("        patient.ethnic_grp_code ethnic_group_code,");
				sqlSb.append("        patient.family_name family_name,");
				sqlSb.append("        patient.first_name first_name,");
				sqlSb.append("        pat_rl_con.addr2_line1 fton_addr_line1,");
				sqlSb.append("        pat_rl_con.addr2_line2 fton_addr_line2,");
				sqlSb.append("        pat_rl_con.addr2_line3 fton_addr_line3,");
				sqlSb.append("        pat_rl_con.addr2_line4 fton_addr_line4,");
				sqlSb.append("        pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact2_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) fton_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact2_name fton_contact_name,");
				sqlSb.append("        pat_rl_con.contact2_relation fton_contact_relation,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country2_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country2_code,'"+locale+"',1))");
				sqlSb.append("         END) fton_country_name,");
				sqlSb.append("        pat_rl_con.contact2_email_id fton_email_id,");
				sqlSb.append("        pat_rl_con.job2_title fton_job_title,");
				sqlSb.append("        pat_rl_con.contact2_mob_tel_no fton_mob_tel_no,");
				sqlSb.append("        pat_rl_con.contact2_nat_id_no fton_nat_id_no,");
				sqlSb.append("        pat_rl_con.off2_tel_no fton_off_tel_no,");
				sqlSb.append("        pat_rl_con.postal2_code fton_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact2_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) fton_region_long_desc,");
				sqlSb.append("        pat_rl_con.res2_tel_no fton_res_tel_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact2_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) fton_town_long_desc,");
				sqlSb.append("        pat_oth_dtls.general_remarks general_remarks,");
				sqlSb.append("        pat_oth_dtls.regn_informant informant,");
				sqlSb.append("        pat_oth_dtls.regn_comments informant_remarks,");
				sqlSb.append("        patient.legal_yn legal_yn,");
				sqlSb.append("        pat_addr.addr2_line1 mail_addr_line1,");
				sqlSb.append("        pat_addr.addr2_line2 mail_addr_line2,");
				sqlSb.append("        pat_addr.addr2_line3 mail_addr_line3,");
				sqlSb.append("        pat_addr.addr2_line4 mail_addr_line4,");
				sqlSb.append("        pat_addr.country2_code mail_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.country2_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_addr.country2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_country_desc,");
				sqlSb.append("        pat_addr.postal2_code mail_postal_code,");
				sqlSb.append("        pat_addr.region2_code mail_region_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_addr.region2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_region_desc,");
				sqlSb.append("        pat_addr.res_area2_code mail_area_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.res_area2_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_addr.res_area2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_area_desc,");
				sqlSb.append("        pat_addr.res_town2_code mail_town_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.res_town2_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_addr.res_town2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_town_desc,");
				sqlSb.append("        patient.name_prefix name_prefix,");
				sqlSb.append("        patient.name_suffix name_suffix,");
				sqlSb.append("        patient.national_id_no national_id_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.nationality_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(patient.nationality_code,'"+locale+"',3))");
				sqlSb.append("         END) nationality_desc,");
				sqlSb.append("        pat_rl_con.addr1_line1 nkin_addr_line1,");
				sqlSb.append("        pat_rl_con.addr1_line2 nkin_addr_line2,");
				sqlSb.append("        pat_rl_con.addr1_line3 nkin_addr_line3,");
				sqlSb.append("        pat_rl_con.addr1_line4 nkin_addr_line4,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact1_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) nkin_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact1_name nkin_contact_name,");
				sqlSb.append("        pat_rl_con.contact1_relation nkin_contact_relation,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_relation IS NOT NULL  THEN (mp_get_desc.MP_RELATIONSHIP(pat_rl_con.contact1_relation,'"+locale+"',");
				sqlSb.append("                                                                                            2))");
				sqlSb.append("         END) nkin_contact_relation_desc,");
				sqlSb.append("        pat_rl_con.country1_code nkin_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country1_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country1_code,'"+locale+"',1))");
				sqlSb.append("         END) nkin_country_name,");
				sqlSb.append("        pat_rl_con.contact1_email_id nkin_email_id,");
				sqlSb.append("        pat_rl_con.job1_title nkin_job_title,");
				sqlSb.append("        pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no,");
				sqlSb.append("        pat_rl_con.off1_tel_no nkin_off_tel_no,");
				sqlSb.append("        pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no,");
				sqlSb.append("        pat_rl_con.postal1_code nkin_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact1_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) nkin_region_long_desc,");
				sqlSb.append("        pat_rl_con.res1_tel_no nkin_res_tel_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact1_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) nkin_town_long_desc,");
				sqlSb.append("        pat_rl_con.organization_name,");
				sqlSb.append("        patient.contact2_no oth_contact_no,");
				sqlSb.append("        patient.oth_alt_id_type oth_alt_id_type,");
				sqlSb.append("        pat_rl_con.patient_employee_id patient_employee_id,");
				sqlSb.append("        patient.patient_name patient_name,");
				sqlSb.append("        patient.patient_long_name patient_long_name,");
				sqlSb.append("        patient.patient_long_name_loc_lang patient_long_name_loc_lang,");
				sqlSb.append("        patient.contact1_no res_tel_no,");
				sqlSb.append("        patient.race_code race_code,");
				sqlSb.append("        patient.region_code res_region_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(patient.region_code,'"+locale+"',1))");
				sqlSb.append("         END) res_region_desc,");
				sqlSb.append("        patient.relgn_code relgn_code,");
				sqlSb.append("        patient.res_area_code res_area_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(patient.res_area_code,'"+locale+"',1))");
				sqlSb.append("         END) res_area_desc,");
				sqlSb.append("        patient.res_town_code res_town_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(patient.res_town_code,'"+locale+"',1))");
				sqlSb.append("         END) res_town_desc,");
				sqlSb.append("        pat_addr.addr1_line1 res_addr_line1,");
				sqlSb.append("        pat_addr.addr1_line2 res_addr_line2,");
				sqlSb.append("        pat_addr.addr1_line3 res_addr_line3,");
				sqlSb.append("        pat_addr.addr1_line4 res_addr_line4,");
				sqlSb.append("        pat_addr.country1_code res_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.country1_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_addr.country1_code,'"+locale+"',1))");
				sqlSb.append("         END) res_country_desc,");
				sqlSb.append("        pat_addr.postal1_code postal_code,");
				sqlSb.append("        patient.second_name second_name,");
				sqlSb.append("        patient.sex gender,");
				sqlSb.append("        patient.third_name third_name,");
				sqlSb.append("        TO_CHAR(patient.date_of_birth,'dd/mm/yyyy') date_of_birth"); 

				sqlSb.append(" , pat_docs.DOC1_TYPE, nvl(pat_docs.DOC1_NUM,' ') DOC1_NUM, to_char(pat_docs.DOC1_EXP_DATE,'dd/mm/yyyy') DOC1_EXP_DATE, nvl(pat_docs.DOC1_PLACE_OF_ISSUE,'') DOC1_PLACE_OF_ISSUE, to_char(pat_docs.DOC1_ISS_DATE,'dd/mm/yyyy') DOC1_ISS_DATE, nvl(pat_docs.DOC2_TYPE,'') DOC2_TYPE, nvl(pat_docs.DOC2_NUM,'') DOC2_NUM, to_char(pat_docs.DOC2_EXP_DATE,'dd/mm/yyyy') DOC2_EXP_DATE, nvl(pat_docs.DOC2_PLACE_OF_ISSUE,'') DOC2_PLACE_OF_ISSUE, to_char(pat_docs.DOC2_ISS_DATE,'dd/mm/yyyy') DOC2_ISS_DATE, nvl(pat_docs.DOC3_TYPE,'') DOC3_TYPE, nvl(pat_docs.DOC3_NUM,'') DOC3_NUM, to_char(pat_docs.DOC3_EXP_DATE,'dd/mm/yyyy') DOC3_EXP_DATE, nvl(pat_docs.DOC3_PLACE_OF_ISSUE,'') DOC3_PLACE_OF_ISSUE, to_char(pat_docs.DOC3_ISS_DATE,'dd/mm/yyyy') DOC3_ISS_DATE, nvl(pat_docs.DOC4_TYPE,'') DOC4_TYPE, nvl(pat_docs.DOC4_NUM,'') DOC4_NUM, to_char(pat_docs.DOC4_EXP_DATE,'dd/mm/yyyy') DOC4_EXP_DATE, nvl(pat_docs.DOC4_PLACE_OF_ISSUE,'') DOC4_PLACE_OF_ISSUE, to_char(pat_docs.DOC4_ISS_DATE,'dd/mm/yyyy') DOC4_ISS_DATE ");
				
				sqlSb.append("        , pat_addr.alt_addr_line1, pat_addr.alt_addr_line2,  pat_addr.alt_addr_line3,  pat_addr.alt_addr_line4, pat_addr.alt_town_code, MP_GET_DESC.MP_RES_TOWN(pat_addr.alt_town_code,'"+locale+"','1') alt_town_desc,  pat_addr.alt_area_code, MP_GET_DESC.MP_RES_AREA(pat_addr.alt_area_code,'"+locale+"','1') alt_area_desc, pat_addr.alt_region_code, MP_GET_DESC.MP_REGION(pat_addr.alt_region_code,'"+locale+"','1') alt_region_desc, pat_addr.alt_country_code, MP_GET_DESC.MP_COUNTRY(pat_addr.alt_country_code,'"+locale+"','1') alt_country_desc, pat_addr.alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(pat_addr.alt_postal_code,'"+locale+"','2') alt_postal_desc");//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601

				sqlSb.append(" FROM   mp_patient patient,");
				sqlSb.append("        mp_pat_addresses pat_addr,");
				sqlSb.append("        mp_pat_rel_contacts pat_rl_con,");
				sqlSb.append("        mp_pat_oth_dtls pat_oth_dtls");

				sqlSb.append("		  mp_pat_documents pat_docs");

				sqlSb.append(" WHERE  patient.patient_id = pat_addr.patient_id (+) ");
				sqlSb.append("        AND patient.patient_id = pat_rl_con.patient_id (+) ");
				sqlSb.append("        AND patient.patient_id = pat_oth_dtls.patient_id (+) ");

				sqlSb.append("        AND patient.patient_id = pat_docs.patient_id (+) ");

				sqlSb.append("        AND patient.patient_id ='"+drfunctionid+"'");

			

			oth_stmt = con.prepareStatement(sqlSb.toString());
			oth_rset = oth_stmt.executeQuery();	
		}//end of if for DR...
		else
		if (appt.equals("Appt") || refrlAappt.equals("A"))
		{
		   /*sql = "SELECT facility_id,"+
					 "        appt_ref_no,"+
					 "        clinic_code,"+
					 "        practitioner_id,"+
					 "        name_prefix,"+
					 "        first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        family_name,"+
					 "        name_suffix,"+
					 "        patient_name,"+
					 "        name_prefix_loc_lang,"+
					 "        first_name_loc_lang,"+
					 "        second_name_loc_lang,"+
					 "        third_name_loc_lang,"+
					 "        family_name_loc_lang,"+
					 "        name_suffix_loc_lang,"+
					 "        patient_name_loc_lang,"+
					 "        national_id_no,"+
					 "        alt_id1_no,"+
					 "        alt_id2_no,"+
					 "        alt_id3_no,"+
					 "        alt_id4_no,"+
					 "        oth_alt_id_type,"+
					 "        oth_alt_id_no,"+
					 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
					 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
					 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
					 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        gender,"+
					 "        birth_place_code,"+
					 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
					 "        birth_place_desc place_of_birth,"+
					 "        country_code nationality_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
					 "        race_code,"+
					 "        ethnic_group_code,"+
					 "        res_addr_line1,"+
					 "        res_addr_line2,"+
					 "        res_addr_line3,"+
					 "        res_addr_line4,"+
					 "        res_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
					 "        res_town_code,"+
					 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
					 "        res_region_code,"+
					 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
					 "        postal_code,"+
					 "        res_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
					 "        mail_addr_line1,"+
					 "        mail_addr_line2,"+
					 "        mail_addr_line3,"+
					 "        mail_addr_line4,"+
					 "        mail_town_code,"+
					 "        mail_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
					 "        mail_region_code,"+
					 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
					 "        mail_postal_code,"+
					 "        mail_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
					 "        res_tel_no,"+
					 "        oth_contact_no,"+
					 "        email_id,"+
					 "        referral_id,"+
					 "        contact_reason_code,"+
					 "        mode_of_contact,"+
					 "        citizen_yn,"+
					 "        legal_yn"+
					 " FROM   oa_appt a"+
					 " WHERE  facility_id = '"+ Facility +"'"+
					 "        AND appt_status = '1'";*/
					 /*Below Query modified for this CRF [RUT-CRF-0011]*/
					 
					 sql = "SELECT facility_id,"+
					 "        appt_ref_no,"+
					 "        clinic_code,"+
					 "        practitioner_id,"+
					 "        name_prefix,"+
					 "        first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        family_name,"+
					 "        name_suffix,"+
					 "        patient_name,"+
					 "        patient_long_name,"+
					 "        patient_long_name_loc_lang,"+
					 "        name_prefix_loc_lang,"+
					 "        first_name_loc_lang,"+
					 "        second_name_loc_lang,"+
					 "        third_name_loc_lang,"+
					 "        family_name_loc_lang,"+
					 "        name_suffix_loc_lang,"+
					 "        patient_name_loc_lang,"+
					 "        national_id_no,"+
					 "        alt_id1_no,"+
					 "        alt_id2_no,"+
					 "        alt_id3_no,"+
					 "        alt_id4_no,"+
					 "        oth_alt_id_type,"+
					 "        oth_alt_id_no,"+
					 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
					 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
					 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
					 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        gender,"+
					 "        birth_place_code,"+
					 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
					 "        birth_place_desc place_of_birth,"+
					 "        country_code nationality_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
					 "        race_code,"+
					 "        ethnic_group_code,"+
					 "        res_addr_line1,"+
					 "        res_addr_line2,"+
					 "        res_addr_line3,"+
					 "        res_addr_line4,"+
					 "        res_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
					 "        res_town_code,"+
					 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
					 "        res_region_code,"+
					 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
					 "        postal_code,"+
					 "        res_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
					 "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
					 "        mail_addr_line1,"+
					 "        mail_addr_line2,"+
					 "        mail_addr_line3,"+
					 "        mail_addr_line4,"+
					 "        mail_town_code,"+
					 "        mail_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
					 "        mail_region_code,"+
					 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
					 "        mail_postal_code,"+
					 "        mail_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
					 "         mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
					/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					 "        a.alt_addr_line1,"+
					 "        a.alt_addr_line2,"+
					 "        a.alt_addr_line3,"+
					 "        a.alt_addr_line4,"+
					 "        a.alt_town_code,"+
					 "        a.alt_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
					 "        a.alt_region_code,"+
					 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
					 "        a.alt_postal_code,"+
					 "        a.alt_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
					 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
					/*End*/
					 "        a.patient_cat_code,mp_get_desc.MP_PAT_CATEGORY(a.patient_cat_code,'"+locale+"',2) pat_cat_desc,"+					 
					 "        a.language_id,mp_get_desc.MP_LANGUAGE(a.language_id,'"+locale+"',1) language_desc,"+					 
					 "        res_tel_no,"+
					 "        oth_contact_no,"+
					 "        email_id,"+
					 "        referral_id,"+
					 "        contact_reason_code,"+
					 "        mode_of_contact,"+
					 "        citizen_yn,"+
					 "        legal_yn"+
					 " FROM   oa_appt a"+
					 " WHERE  facility_id = '"+ Facility +"'"+
					 "        AND appt_status = '1'";
					 

		   if(refrlAappt.equals("A"))
		   {
			   sql = sql + " AND appt_ref_no = '"+ refIDValue +"' ";
		   }
		   else
		   {
			  sql = sql + " AND appt_ref_no = '"+ appt_ref_no +"' ";
		   }

		   if(oth_rset!=null) oth_rset.close();
		   if(oth_stmt!=null) oth_stmt.close();
		   oth_stmt = con.prepareStatement(sql);
		   oth_rset = oth_stmt.executeQuery();		
			
		}//end of if for OA...
		else if(!booking_ref_no.equals("") || refrlAappt.equals("I"))         
		{	 
			if(!q_booking_type.equals("D") || refrlAappt.equals("I"))
			{	
				sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        nationality_code,"+
						 "        ethnic_grp_code ethnic_group_code,"+
						 "        race_code,"+
						 "        res_addr_line1,"+
						 "        res_addr_line2,"+
						 "        res_addr_line3,"+
						 "        res_addr_line4,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) res_country_desc,"+
						 "        res_tel_no,"+
						 "        oth_contact_no,"+
						 "        email_id,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
					     "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        referral_id,"+
						 "        mode_of_contact,"+
						 "        citizen_yn,"+
						 "        legal_illegal_yn legal_yn"+
						 " FROM   ip_booking_list a"+
						 " WHERE  facility_id = '"+ Facility +"'" ;

				if(refrlAappt.equals("I"))
				{
					sql = sql + " AND bkg_lst_ref_no = '"+ refIDValue +"' " ;
				}
				else sql = sql +" AND bkg_lst_ref_no = '"+booking_ref_no+"'";
			}//end of if for Daycare
			else
			{
				sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        country_code nationality_code,"+
						 "        ethnic_group_code,"+
						 "        race_code,"+
						 "        res_addr_line1,"+
						 "        res_addr_line2,"+
						 "        res_addr_line3,"+
						 "        res_addr_line4,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
						 "        res_tel_no,"+
						 "        oth_contact_no,"+
						 "        email_id,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        referral_id,"+
						 "        mode_of_contact,"+
						 "        citizen_yn,"+
						 "        legal_yn"+
						 " FROM   oa_appt a"+
						 " WHERE  facility_id = '"+ Facility +"'"+
						 "        AND appt_ref_no = '"+booking_ref_no+"'";

						/*appt_ref_no		= booking_ref_no;
						booking_ref_no	= "";*/

			}//end of if for IP

			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);					
			oth_rset = oth_stmt.executeQuery();	
		}
		//Query to populate the values from Ref-search
		else if(func_act.equals("REF_SEARCH") || refrlAappt.equals("L"))
		{	
			
			sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        sex gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        nationality_code,"+
						 "        race_code,"+
						 "        ethnic_grp_code ethnic_group_code,"+
						 "        addr_line1 res_addr_line1,"+
						 "        addr_line2 res_addr_line2,"+
						 "        addr_line3 res_addr_line3,"+
						 "        addr_line4 res_addr_line4,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        region_code res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.region_code,'"+locale+"',1) res_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.postal_code,'"+locale+"',2) postal_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) res_country_desc,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_res_town_code mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_res_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_res_area_code mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_res_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.mail_postal_code,'"+locale+"',2) mail_postal_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        contact1_no res_tel_no,"+
						 "        contact2_no oth_contact_no,"+
						 "        email_id,"+
						 "        referral_id,"+
						 "        citizen_yn,"+
						 "        legal_illegal_yn legal_yn"+
						 " FROM   pr_referral_register a"+
						 " WHERE " ;
			if(refrlAappt.equals("L"))
			{
				sql = sql + " referral_id = '"+ refIDValue +"' " ;
			}
			else sql = sql + " referral_id = '"+ referral_id +"' " ;
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();							
		}
		else if(refrlAappt.equals("R"))
		{	
			sql = "SELECT first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        name_suffix,"+
					 "        title_code name_prefix,"+
					 "        short_name patient_name,"+
					 "        last_name family_name,"+
					 "        national_id_num national_id_no,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        sex gender,"+
					 "        appt_ref_num referral_id,"+
					 "        res_telephone_num res_tel_no,"+
					 "        other_contact_num oth_contact_no,"+
					 "        ln1_res_add res_addr_line1,"+
					 "        ln2_res_add res_addr_line2,"+
					 "        ln3_res_add res_addr_line3,"+
					 "        ln4_res_add res_addr_line4"+
					 " FROM   rd_appt"+
					 " WHERE  appt_ref_num = '"+refIDValue+"'";
		
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();		
		}			
		if(oth_rset!=null && oth_rset.next())
		{
			
			if(refrlAappt.equals("P"))
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
				a_patient_long_name		=	checkForNull( oth_rset.getString("patient_long_name") );
				a_patient_long_name_loc_lang		=	checkForNull( oth_rset.getString("patient_long_name_loc_lang") );
				res_contact_name	=	checkForNull( oth_rset.getString("res_contact_name") );
				mail_contact_name	=	checkForNull( oth_rset.getString("mail_contact_name") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1			= 	checkForNull( oth_rset.getString("alt_addr_line1") );
				alt_addr_line2			= 	checkForNull( oth_rset.getString("alt_addr_line2") );
				alt_addr_line3			= 	checkForNull( oth_rset.getString("alt_addr_line3") );
				alt_addr_line4			= 	checkForNull( oth_rset.getString("alt_addr_line4") );
				alt_town_code			= 	checkForNull( oth_rset.getString("alt_town_code") );
				alt_town_desc			= 	checkForNull( oth_rset.getString("alt_town_desc") );
				alt_area_code			= 	checkForNull( oth_rset.getString("alt_area_code") );
				alt_area_desc			= 	checkForNull( oth_rset.getString("alt_area_desc") );
				alt_country_code		= 	checkForNull( oth_rset.getString("alt_country_code") );
				alt_country_desc		= 	checkForNull( oth_rset.getString("alt_country_desc") );
				alt_region_code			= 	checkForNull( oth_rset.getString("alt_region_code") );
				alt_region_desc			= 	checkForNull( oth_rset.getString("alt_region_desc") );
				alt_postal_code			= 	checkForNull( oth_rset.getString("alt_postal_code") );
				alt_postal_desc			= 	checkForNull( oth_rset.getString("alt_postal_desc") );
				/*End*/

			}
			else
			{
			a_gender					= 	checkForNull( oth_rset.getString("gender") );
			a_date_of_birth				= 	checkForNull( oth_rset.getString("date_of_birth") );
			if (!a_date_of_birth.equals(""))
			{
				if(!locale.equals("en"))
				{ 	
					a_date_of_birth= DateUtils.convertDate(a_date_of_birth,"DMY","en",locale);
				}
			}
			a_national_id_no			= 	checkForNull( oth_rset.getString("national_id_no") );
			year							= 	checkForNull( oth_rset.getString("YEAR") );
			months						= 	checkForNull( oth_rset.getString("MONTHS") );
			days							= 	checkForNull( oth_rset.getString("DAYS") );
			hours							= 	checkForNull( oth_rset.getString("hours") );
			a_res_tel_no				= 	checkForNull( oth_rset.getString("res_tel_no") );
			a_oth_contact_no			= 	checkForNull( oth_rset.getString("oth_contact_no") );
			a_res_addr_line1			= 	checkForNull( oth_rset.getString("res_addr_line1") );
			a_res_addr_line2			= 	checkForNull( oth_rset.getString("res_addr_line2") );
			a_res_addr_line3			= 	checkForNull( oth_rset.getString("res_addr_line3") );
			a_res_addr_line4			= 	checkForNull( oth_rset.getString("res_addr_line4") );

			

			if(!func_act.equals("DuplicateRegistration"))
			{
				
				a_name_prefix			=	checkForNull( oth_rset.getString("name_prefix") );
				a_family_name			=	checkForNull( oth_rset.getString("family_name") );
				a_patient_name		=	checkForNull( oth_rset.getString("patient_name") );
				a_patient_long_name		=	checkForNull( oth_rset.getString("patient_long_name") );
				a_patient_long_name_loc_lang		=	checkForNull( oth_rset.getString("patient_long_name_loc_lang") );
				a_first_name			=	checkForNull( oth_rset.getString("first_name") );
				a_second_name		=	checkForNull( oth_rset.getString("second_name") );
				a_third_name			=	checkForNull( oth_rset.getString("third_name") );
				a_name_suffix			=	checkForNull( oth_rset.getString("name_suffix") );
				a_name_prefix_loc_lang			=	checkForNull( oth_rset.getString("name_prefix_loc_lang") );
				a_first_name_loc_lang				=	checkForNull( oth_rset.getString("first_name_loc_lang") );
				a_second_name_loc_lang		=	checkForNull( oth_rset.getString("second_name_loc_lang") );
				a_third_name_loc_lang			=	checkForNull( oth_rset.getString("third_name_loc_lang") );
				a_family_name_loc_lang			=	checkForNull( oth_rset.getString("family_name_loc_lang") );
				a_name_suffix_loc_lang			=	checkForNull( oth_rset.getString("name_suffix_loc_lang") );
				a_patient_name_loc_lang			=	checkForNull( oth_rset.getString("patient_name_loc_lang") );

				referral_id				=  checkForNull( oth_rset.getString("referral_id") );
				

			if (appt.equals("Appt") || refrlAappt.equals("A")){
				/*Below Code Added For this CRF [RUT-CRF-0011]*/					
					patient_cat_code=  checkForNull( oth_rset.getString("patient_cat_code") );
					patient_cat_desc=  checkForNull( oth_rset.getString("pat_cat_desc") );
					language_id=  checkForNull( oth_rset.getString("language_id") );
					language_desc=  checkForNull( oth_rset.getString("language_desc") );						
				}

				if(!refrlAappt.equals("R"))
				{
					a_nationality_code = checkForNull( oth_rset.getString("nationality_code") );
				}
				
			}

			if(!refrlAappt.equals("R"))
			{

				a_email_id					= 	checkForNull( oth_rset.getString("email_id") );
				a_alt_id1_no					= 	checkForNull( oth_rset.getString("alt_id1_no") );
				a_alt_id2_no					= 	checkForNull( oth_rset.getString("alt_id2_no") );
				a_alt_id3_no					= 	checkForNull( oth_rset.getString("alt_id3_no") );
				a_alt_id4_no					= 	checkForNull( oth_rset.getString("alt_id4_no") );
				a_oth_alt_id_type			= 	checkForNull( oth_rset.getString("oth_alt_id_type") );
				a_oth_alt_id_no				= 	checkForNull( oth_rset.getString("oth_alt_id_no") );
				a_alt_id1_exp_date			= 	checkForNull( oth_rset.getString("alt_id1_exp_date") );
				a_alt_id2_exp_date			= 	checkForNull( oth_rset.getString("alt_id2_exp_date") );
				a_alt_id3_exp_date			= 	checkForNull( oth_rset.getString("alt_id3_exp_date") );
				a_alt_id4_exp_date			= 	checkForNull( oth_rset.getString("alt_id4_exp_date") );
				if ( !locale.equals("en") )
				{ 
					if (!a_alt_id1_exp_date.equals(""))
							a_alt_id1_exp_date= DateUtils.convertDate(a_alt_id1_exp_date,"DMY","en",locale);
					if (!a_alt_id2_exp_date.equals(""))
							a_alt_id2_exp_date= DateUtils.convertDate(a_alt_id2_exp_date,"DMY","en",locale);
					if (!a_alt_id3_exp_date.equals(""))
							a_alt_id3_exp_date= DateUtils.convertDate(a_alt_id3_exp_date,"DMY","en",locale);
					if (!a_alt_id4_exp_date.equals(""))
							a_alt_id4_exp_date= DateUtils.convertDate(a_alt_id4_exp_date,"DMY","en",locale);
				}
				a_race_code				= 	checkForNull( oth_rset.getString("race_code") );
				a_ethnic_group_code		= 	checkForNull( oth_rset.getString("ethnic_group_code") );
				a_postal_code				= 	checkForNull( oth_rset.getString("postal_code") );
				a_country_code			= 	checkForNull( oth_rset.getString("res_country_code") );
				a_res_country_desc		= 	checkForNull( oth_rset.getString("res_country_desc") );
				a_res_town_code			= 	checkForNull( oth_rset.getString("res_town_code") );
				a_res_town_desc			= 	checkForNull( oth_rset.getString("res_town_desc") );
				a_res_region_code		= 	checkForNull( oth_rset.getString("res_region_code") );
				a_res_region_desc			= 	checkForNull( oth_rset.getString("res_region_desc") );
				a_res_area_code			= 	checkForNull( oth_rset.getString("res_area_code") );
				a_res_area_desc			= 	checkForNull( oth_rset.getString("res_area_desc") );
				a_mail_country_desc		= 	checkForNull( oth_rset.getString("mail_country_desc") );
				a_mail_addr_line1			= 	checkForNull( oth_rset.getString("mail_addr_line1") );
				a_mail_addr_line2			= 	checkForNull( oth_rset.getString("mail_addr_line2") );
				a_mail_addr_line3			= 	checkForNull( oth_rset.getString("mail_addr_line3") );
				a_mail_addr_line4			= 	checkForNull( oth_rset.getString("mail_addr_line4") );
				a_mail_town_code			= 	checkForNull( oth_rset.getString("mail_town_code") );
				a_mail_area_code			= 	checkForNull( oth_rset.getString("mail_area_code") );
				a_mail_country_code		= 	checkForNull( oth_rset.getString("mail_country_code") );
				a_mail_postal_code		= 	checkForNull( oth_rset.getString("mail_postal_code") );
				a_mail_region_code		= 	checkForNull( oth_rset.getString("mail_region_code") );
				a_mail_area_desc			= 	checkForNull( oth_rset.getString("mail_area_desc") );
				a_mail_town_desc			= 	checkForNull( oth_rset.getString("mail_town_desc") );
				a_mail_region_desc		= 	checkForNull( oth_rset.getString("mail_region_desc") );
				a_birth_place_code		= 	checkForNull( oth_rset.getString("birth_place_code") );
				a_birth_place_desc		= 	checkForNull( oth_rset.getString("birth_place_desc") );
				a_place_of_birth			= 	checkForNull( oth_rset.getString("place_of_birth") );
				a_legal_yn					= 	checkForNull( oth_rset.getString("legal_yn") );
				a_citizen_yn					= 	checkForNull( oth_rset.getString("citizen_yn") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1			= 	checkForNull( oth_rset.getString("alt_addr_line1") );
				alt_addr_line2			= 	checkForNull( oth_rset.getString("alt_addr_line2") );
				alt_addr_line3			= 	checkForNull( oth_rset.getString("alt_addr_line3") );
				alt_addr_line4			= 	checkForNull( oth_rset.getString("alt_addr_line4") );
				alt_town_code			= 	checkForNull( oth_rset.getString("alt_town_code") );
				alt_town_desc			= 	checkForNull( oth_rset.getString("alt_town_desc") );
				alt_area_code			= 	checkForNull( oth_rset.getString("alt_area_code") );
				alt_area_desc			= 	checkForNull( oth_rset.getString("alt_area_desc") );
				alt_country_code		= 	checkForNull( oth_rset.getString("alt_country_code") );
				alt_country_desc		= 	checkForNull( oth_rset.getString("alt_country_desc") );
				alt_region_code			= 	checkForNull( oth_rset.getString("alt_region_code") );
				alt_region_desc			= 	checkForNull( oth_rset.getString("alt_region_desc") );
				alt_postal_code			= 	checkForNull( oth_rset.getString("alt_postal_code") );
				alt_postal_desc			= 	checkForNull( oth_rset.getString("alt_postal_desc") );
				/*End*/
				
			}

			if(func_act.equals("DuplicateRegistration")) {

				if(!refrlAappt.equals("R")) {
					relgn_code						= 	checkForNull( oth_rset.getString("relgn_code") );
					contact3_mode				= 	checkForNull( oth_rset.getString("contact3_mode") );
					contact3_no					= 	checkForNull( oth_rset.getString("contact3_no") );
					contact4_mode				= 	checkForNull( oth_rset.getString("contact4_mode") );
					contact4_no					= 	checkForNull( oth_rset.getString("contact4_no") );
					contact5_mode				= 	checkForNull( oth_rset.getString("contact5_mode") );
					contact5_no					= 	checkForNull( oth_rset.getString("contact5_no") );
					nkin_contact_name			= 	checkForNull( oth_rset.getString("nkin_contact_name") );
				    nkin_alias_name             = 	checkForNull( oth_rset.getString("nkin_alias_name") );//Added by Suji Keerthi for ML-MMOH-CRF-1527 US007
					nkin_contact_relation		= 	checkForNull( oth_rset.getString("nkin_contact_relation") );
					contact1_nat_id_no			=	checkForNull( oth_rset.getString("contact1_nat_id_no") );
					contact1_alt_id1_no			=	checkForNull( oth_rset.getString("contact1_alt_id1_no") );
					contact1_alt_id2_no			=	checkForNull( oth_rset.getString("contact1_alt_id2_no") );
					contact1_alt_id3_no			=	checkForNull( oth_rset.getString("contact1_alt_id3_no") );
					contact1_alt_id4_no			=	checkForNull( oth_rset.getString("contact1_alt_id4_no") );
					contact1_oth_alt_id_type	=	checkForNull( oth_rset.getString("contact1_oth_alt_id_type") );
					nkin_oth_alt_id_no			=	checkForNull( oth_rset.getString("nkin_oth_alt_id_no") );
					contact1_birth_date			=	checkForNull( oth_rset.getString("contact1_birth_date") );

					if  ( !contact1_birth_date.equals("") ) 
					{
							if  ( !localeName.equals("en"))
							contact1_birth_date= DateUtils.convertDate(contact1_birth_date,"DMY","en",localeName);
					}
					nkin_job_title					= 	checkForNull( oth_rset.getString("nkin_job_title") );
					nkin_addr_line1				= 	checkForNull( oth_rset.getString("nkin_addr_line1") );
					nkin_addr_line2				= 	checkForNull( oth_rset.getString("nkin_addr_line2") );
					nkin_addr_line3				= 	checkForNull( oth_rset.getString("nkin_addr_line3") );
					nkin_addr_line4				= 	checkForNull( oth_rset.getString("nkin_addr_line4") );
					nkin_area_long_desc			= 	checkForNull( oth_rset.getString("nkin_area_long_desc") );
					nkin_region_long_desc		= 	checkForNull( oth_rset.getString("nkin_region_long_desc") );
					nkin_town_long_desc		= 	checkForNull( oth_rset.getString("nkin_town_long_desc") );
					nkin_postal_code				= 	checkForNull( oth_rset.getString("nkin_postal_code") );
					nkin_country_name			= 	checkForNull( oth_rset.getString("nkin_country_name") );
					//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					nk_mail_country_desc    = 	checkForNull( oth_rset.getString("nk_mail_country_desc") );
					nkin_m_country_desc     = 	checkForNull( oth_rset.getString("nkin_m_country_desc") );
					resadd_contact_name      = 	checkForNull( oth_rset.getString("resadd_contact_name") );
					mailadd_contact_name      = 	checkForNull( oth_rset.getString("mailadd_contact_name") );
                    nk_contact3_mode   = 	checkForNull( oth_rset.getString("nk_contact3_mode") );
                    nk_contact3_no     = 	checkForNull( oth_rset.getString("nk_contact3_no") );
                    nk_contact4_mode   = 	checkForNull( oth_rset.getString("nk_contact4_mode") );
                    nk_contact4_no     = 	checkForNull( oth_rset.getString("nk_contact4_no") );
					nk_contact5_mode   = 	checkForNull( oth_rset.getString("nk_contact5_mode") );
                    nk_contact5_no     = 	checkForNull( oth_rset.getString("nk_contact5_no") );
                   
				    fton_mail_country_desc  = 	checkForNull( oth_rset.getString("fton_mail_country_desc") );
					fton_m_country_desc     = 	checkForNull( oth_rset.getString("fton_m_country_desc") );
					fton_contact3_mode   = 	checkForNull( oth_rset.getString("fton_contact3_mode") );
                    fton_contact3_no     = 	checkForNull( oth_rset.getString("fton_contact3_no") );
                    fton_contact4_mode   = 	checkForNull( oth_rset.getString("fton_contact4_mode") );
                    fton_contact4_no     = 	checkForNull( oth_rset.getString("fton_contact4_no") );
					fton_contact5_mode   = 	checkForNull( oth_rset.getString("fton_contact5_mode") );
                    fton_contact5_no     = 	checkForNull( oth_rset.getString("fton_contact5_no") );
					//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
					nkin_res_tel_no				=	checkForNull( oth_rset.getString("nkin_res_tel_no") );
					nkin_mob_tel_no				= 	checkForNull( oth_rset.getString("nkin_mob_tel_no") );
					nkin_off_tel_no				=	checkForNull( oth_rset.getString("nkin_off_tel_no") );
					nkin_email_id					= 	checkForNull( oth_rset.getString("nkin_email_id") );
					fton_addr_line1				= 	checkForNull( oth_rset.getString("fton_addr_line1") );
					fton_addr_line2				= 	checkForNull( oth_rset.getString("fton_addr_line2") );
					fton_addr_line3				= 	checkForNull( oth_rset.getString("fton_addr_line3") );
					fton_addr_line4				= 	checkForNull( oth_rset.getString("fton_addr_line4") );
					fton_town_long_desc		=  checkForNull( oth_rset.getString("fton_town_long_desc") );
					fton_area_long_desc			=  checkForNull( oth_rset.getString("fton_area_long_desc") );
					fton_region_long_desc		= 	checkForNull( oth_rset.getString("fton_region_long_desc") );
					fton_postal_code				= 	checkForNull( oth_rset.getString("fton_postal_code") );
					fton_country_name			= 	checkForNull( oth_rset.getString("fton_country_name") );
					fton_contact_name			= 	checkForNull( oth_rset.getString("fton_contact_name") );
					fton_contact_relation		= 	checkForNull( oth_rset.getString("fton_contact_relation") );
					fton_alt_id_no					= 	checkForNull( oth_rset.getString("fton_alt_id_no") );
					fton_job_title					= 	checkForNull( oth_rset.getString("fton_job_title") );
					fton_res_tel_no				= 	checkForNull( oth_rset.getString("fton_res_tel_no") );
					fton_mob_tel_no				= 	checkForNull( oth_rset.getString("fton_mob_tel_no") );
					fton_email_id					= 	checkForNull( oth_rset.getString("fton_email_id") );
					fton_email_id					= 	checkForNull( oth_rset.getString("fton_email_id") );
					organization_name			=	checkForNull( oth_rset.getString("organization_name") );
					emplr_contact_name			= 	checkForNull( oth_rset.getString("emplr_contact_name") );
					emplr_addr_line1				= 	checkForNull( oth_rset.getString("emplr_addr_line1") );
					emplr_addr_line2				= 	checkForNull( oth_rset.getString("emplr_addr_line2") );
					emplr_addr_line3				= 	checkForNull( oth_rset.getString("emplr_addr_line3") );
					emplr_addr_line4				= 	checkForNull( oth_rset.getString("emplr_addr_line4") );
					emplr_town_long_desc		= 	checkForNull( oth_rset.getString("emplr_town_long_desc") );
					emplr_region_long_desc		= 	checkForNull( oth_rset.getString("emplr_region_long_desc") );
					emplr_area_long_desc		= 	checkForNull( oth_rset.getString("emplr_area_long_desc") );
					emplr_postal_code			= 	checkForNull( oth_rset.getString("emplr_postal_code") );
					emplr_country_name			= 	checkForNull( oth_rset.getString("emplr_country_name") );
					emplr_off_tel_no				=	checkForNull( oth_rset.getString("emplr_off_tel_no") );
					emplr_res_tel_no				=	checkForNull( oth_rset.getString("emplr_res_tel_no") );
					patient_employee_id			=	checkForNull( oth_rset.getString("patient_employee_id") );
					informant						=	checkForNull( oth_rset.getString("informant") );
					informant_remarks			=	checkForNull( oth_rset.getString("informant_remarks") );
					general_remarks				=	checkForNull( oth_rset.getString("general_remarks") );
				}

				/*
				doc_pstmt = con.prepareStatement("select DOC1_TYPE, nvl(DOC1_NUM,' ') DOC1_NUM, to_char(DOC1_EXP_DATE,'dd/mm/yyyy') DOC1_EXP_DATE, nvl(DOC1_PLACE_OF_ISSUE,'') DOC1_PLACE_OF_ISSUE, to_char(DOC1_ISS_DATE,'dd/mm/yyyy') DOC1_ISS_DATE, nvl(DOC2_TYPE,'') DOC2_TYPE, nvl(DOC2_NUM,'') DOC2_NUM, to_char(DOC2_EXP_DATE,'dd/mm/yyyy') DOC2_EXP_DATE, nvl(DOC2_PLACE_OF_ISSUE,'') DOC2_PLACE_OF_ISSUE, to_char(DOC2_ISS_DATE,'dd/mm/yyyy') DOC2_ISS_DATE, nvl(DOC3_TYPE,'') DOC3_TYPE, nvl(DOC3_NUM,'') DOC3_NUM, to_char(DOC3_EXP_DATE,'dd/mm/yyyy') DOC3_EXP_DATE, nvl(DOC3_PLACE_OF_ISSUE,'') DOC3_PLACE_OF_ISSUE, to_char(DOC3_ISS_DATE,'dd/mm/yyyy') DOC3_ISS_DATE, nvl(DOC4_TYPE,'') DOC4_TYPE, nvl(DOC4_NUM,'') DOC4_NUM, to_char(DOC4_EXP_DATE,'dd/mm/yyyy') DOC4_EXP_DATE, nvl(DOC4_PLACE_OF_ISSUE,'') DOC4_PLACE_OF_ISSUE, to_char(DOC4_ISS_DATE,'dd/mm/yyyy') DOC4_ISS_DATE FROM MP_PAT_DOCUMENTS where patient_id = '"+drfunctionid+"'");
				doc_rs = doc_pstmt.executeQuery();
				while(doc_rs.next()) {
					*/
					doc1_num					=  	checkForNull( oth_rset.getString("DOC1_NUM") );
					doc1_exp_date				=  	checkForNull( oth_rset.getString("DOC1_EXP_DATE") );
					doc1_place_of_issue		=  	checkForNull( oth_rset.getString("DOC1_PLACE_OF_ISSUE") );
					doc1_iss_date				=  	checkForNull( oth_rset.getString("DOC1_ISS_DATE") );
					doc2_num					=  	checkForNull( oth_rset.getString("DOC2_NUM") );
					doc2_exp_date				=  	checkForNull( oth_rset.getString("DOC2_EXP_DATE") );
					doc2_place_of_issue		=  	checkForNull( oth_rset.getString("DOC2_PLACE_OF_ISSUE") );
					doc2_iss_date				=  	checkForNull( oth_rset.getString("DOC2_ISS_DATE") );
					doc3_num					=  	checkForNull( oth_rset.getString("DOC3_NUM") );
					doc3_exp_date				=  	checkForNull( oth_rset.getString("DOC3_EXP_DATE") );
					doc3_place_of_issue     =  checkForNull( oth_rset.getString("DOC3_PLACE_OF_ISSUE") );
					doc3_iss_date				=  	checkForNull( oth_rset.getString("DOC3_ISS_DATE") );
					doc4_num					=  	checkForNull( oth_rset.getString("DOC4_NUM") );
					doc4_exp_date				=  	checkForNull( oth_rset.getString("DOC4_EXP_DATE") );
					doc4_place_of_issue     =  checkForNull( oth_rset.getString("DOC4_PLACE_OF_ISSUE") );
					doc4_iss_date				=  	checkForNull( oth_rset.getString("DOC4_ISS_DATE") );

					if ( !locale.equals("en") )
					{ 
						if (!doc1_exp_date.equals(""))
							doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",locale);
						if (!doc1_iss_date.equals(""))
							doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",locale);
						if (!doc2_exp_date.equals(""))
							doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",locale);
						if (!doc2_iss_date.equals(""))
							doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",locale);
						if (!doc3_exp_date.equals(""))
							doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",locale);
						if (!doc3_iss_date.equals(""))
							doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",locale);
						if (!doc4_exp_date.equals(""))
							doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",locale);
						if (!doc4_iss_date.equals(""))
							doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",locale);
					}
				//}
			}
		}
		}

		//Added by Ashwin K for AAKH-CRF-0150	
		//for smart card
		oth_stmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
		oth_rset = oth_stmt.executeQuery();	
		if(oth_rset!=null && oth_rset.next())
		{
		function_name=oth_rset.getString("VALUE_2");   // alkhaleej smart card
		}		
		if(oth_rset!=null) oth_rset.close();
		if(oth_stmt!=null) oth_stmt.close();
		oth_stmt = con.prepareStatement("select PAT_SER_GRP_CODE from MP_PAT_SER_GRP where DEFAULT_YN = 'Y'");
		oth_rset = oth_stmt.executeQuery();	
		if(oth_rset!=null && oth_rset.next())
		{
		pat_series=oth_rset.getString(1);   
		}	
		if(oth_rset!=null) oth_rset.close();
		if(oth_stmt!=null) oth_stmt.close();
		//Ended by Ashwin K for AAKH-CRF-0150

	}
	catch(Exception e) {		
		e.printStackTrace();
	}
	finally {
		
		//if(doc_pstmt!=null) doc_pstmt.close();
		//if(doc_rs!=null) doc_rs.close();
	}
	try { 
		//Query to get the values from mp-param
		// Below query  is modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		// Below query  is modified against KDAH-CRF-0273 [IN:045012] by Saanthaakumar
		//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772]
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,alt_id1_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,alt_id2_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,alt_id3_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,alt_id4_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,NVL(first_name_accept_yn,'N') first_name_accept_yn,first_name_order,NVL(first_name_prompt,'First Name') first_name_prompt,NVL(second_name_accept_yn,'N') second_name_accept_yn,second_name_order,NVL(second_name_prompt,'Second Name') second_name_prompt,NVL(third_name_accept_yn,'N') third_name_accept_yn,third_name_order,NVL(third_name_prompt,'Third Name') third_name_prompt,NVL(family_name_accept_yn,'N') family_name_accept_yn,family_name_order,NVL(family_name_prompt,'Family Name') family_name_prompt,name_dervn_logic,NAME_DERVN_LOGIC_LONG,NVL(alt_id1_length,0) alt_id1_length,NVL(alt_id2_length,0) alt_id2_length,NVL(alt_id3_length,0) alt_id3_length,NVL(alt_id4_length,0) alt_id4_length,NVL(name_suffix_accept_yn,'N') name_suffix_accept_yn,NVL(name_prefix_accept_yn,'N') name_prefix_accept_yn,NVL(name_suffix_prompt,'Name Suffix') name_suffix_prompt,NVL(name_prefix_prompt,'Name Prefix') name_prefix_prompt,NVL(first_name_reqd_yn,'N') first_name_reqd_yn,NVL(second_name_reqd_yn,'N') second_name_reqd_yn,NVL(third_name_reqd_yn,'N') third_name_reqd_yn,NVL(family_name_reqd_yn,'N') family_name_reqd_yn,NVL(name_suffix_reqd_yn,'N') name_suffix_reqd_yn,NVL(name_prefix_reqd_yn,'N') name_prefix_reqd_yn,NVL(family_no_link_yn,'N') family_no_link_yn,NVL(patient_id_length,0) patient_id_length,citizen_nationality_code,default_race_code,NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn,NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn,NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,DECODE('"+patient_grp+"','N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dfltpsg,NVL(alt_id_pat_ser_grp,'') altdfltpsg,nat_id_length,NVL(alt_id1_len_validation_yn,'N') alt_id1_len_validation_yn,NVL(alt_id2_len_validation_yn,'N') alt_id2_len_validation_yn,NVL(alt_id3_len_validation_yn,'N') alt_id3_len_validation_yn,NVL(alt_id4_len_validation_yn,'N') alt_id4_len_validation_yn,alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn,alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn,alt_id1_routine_yn,alt_id1_data_source_id alt_id1_routine,alt_id2_routine_yn,alt_id2_data_source_id alt_id2_routine,alt_id3_routine_yn,alt_id3_data_source_id alt_id3_routine,alt_id4_routine_yn,alt_id4_data_source_id alt_id4_routine,NVL(nat_id_pat_ser_grp,'') def_nat_id_pat_ser_grp,NVL(nat_id_prompt,'National ID No') nat_id_prompt,names_in_oth_lang_yn,DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp,alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,alt_id4_chk_digit_scheme,invoke_routine,nat_data_source_id,NVL(nat_id_check_digit_id,'') nat_id_check_digit_id,NVL(addl_field1_prompt,'') addl_field1_prompt,NVL(addl_field1_length,'0') addl_field1_length,NVL(addl_field1_section,'') addl_field1_section,NVL(addl_field2_prompt,'') addl_field2_prompt,NVL(addl_field2_length,'0') addl_field2_length,NVL(addl_field2_section,'') addl_field2_section,NVL(addl_field3_prompt,'') addl_field3_prompt,NVL(addl_field3_length,'0') addl_field3_length,NVL(addl_field3_section,'') addl_field3_section,NVL(addl_field4_prompt,'') addl_field4_prompt,NVL(addl_field4_length,'0') addl_field4_length,NVL(addl_field4_section,'') addl_field4_section,NVL(addl_field5_prompt,'') addl_field5_prompt,NVL(addl_field5_length,'0') addl_field5_length,NVL(addl_field5_section,'') addl_field5_section,NVL(nat_id_chk_len,'N') nat_id_chk_len,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name,NVL(nat_id_reqd_all_series,'N') nat_id_reqd_all_series,NVL(name_prefix_loc_lang_prompt,'') name_prefix_loc_lang_prompt,NVL(first_name_loc_lang_prompt,'') first_name_loc_lang_prompt,NVL(second_name_loc_lang_prompt,'') second_name_loc_lang_prompt,NVL(third_name_loc_lang_prompt,'') third_name_loc_lang_prompt,NVL(family_name_loc_lang_prompt,'') family_name_loc_lang_prompt,NVL(name_suffix_loc_lang_prompt,'') name_suffix_loc_lang_prompt,accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn,max_patient_age,name_dervn_logic_oth_lang,NAME_DERVN_LOGIC_OTH_LANG_LONG,pat_name_as_multipart_yn,accept_oth_alt_id_yn,ext_system_interface_yn,create_file_at_pat_regn_yn,dflt_alt_id1_in_emp_id_yn,NVL(maintain_doc_or_file,'F') maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn,pat_category_reqd_yn,TRIM(org_member_relationship_code) org_member_relationship_code,DFLT_LANGUAGE_ID,DFLT_RELGN_CODE,INV_PAT_SEARCH_IN_REG_PAT_YN,COUNTRY_REQD_YN,REGION_REQD_YN,MOBILE_NO_REQD_YN,EMAIL_ID_REQD_YN,postal_cd_reqd_yn,area_reqd_yn,town_reqd_yn,(CASE WHEN org_member_relationship_code IS NOT NULL  THEN (mp_get_desc.MP_RELATIONSHIP(org_member_relationship_code,'"+locale+"',2)) END) org_member_relationship_desc, alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn,ALT_ID1_ALPHANUM_VALIDATE_YN,ALT_ID2_ALPHANUM_VALIDATE_YN,ALT_ID3_ALPHANUM_VALIDATE_YN,ALT_ID4_ALPHANUM_VALIDATE_YN  "; // query modified by mujafar for GHL-0524.1

		if(bl_install_yn.equals("Y")) {
			sql = sql+" , (select dflt_pat_regn_blng_class from bl_mp_param) dflt_pat_regn_blng_class ";
		} 		
		
		sql = sql+" FROM mp_param_lang_vw mp_param WHERE module_id = 'MP' AND language_id = '"+locale+"'";
		 
		stmt = con.prepareStatement(sql);
		rset = stmt.executeQuery();		     
		if(rset != null)
		   rset.next();
		ext_system_interface_yn			= checkForNull( rset.getString("ext_system_interface_yn"),"N");
		dflt_alt_id1_in_emp_id_yn			= checkForNull( rset.getString("dflt_alt_id1_in_emp_id_yn"),"N");
		family_org_id_accept_yn			= checkForNull( rset.getString("family_org_id_accept_yn"),"N");
		entitlement_by_pat_cat_yn		= checkForNull( rset.getString("entitlement_by_pat_cat_yn"),"N");
		pat_category_reqd_yn            = checkForNull( rset.getString("pat_category_reqd_yn"),"N"); //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522
		org_member_relationship_code	= checkForNull( rset.getString("org_member_relationship_code") );
		org_member_relationship_desc	= checkForNull( rset.getString("org_member_relationship_desc") );
		accept_national_id_no_yn			= checkForNull( rset.getString("accept_national_id_no_yn"),"N");
		nat_id_accept_alphanumeric_yn			= checkForNull(rset.getString("nat_id_accept_alphanumeric_yn"),"N");
		alt_id1_accept_oth_pat_ser_yn	= checkForNull( rset.getString("alt_id1_accept_oth_pat_ser_yn"),"N");
		alt_id1_accept_alphanumeric_yn = checkForNull( rset.getString("alt_id1_accept_alphanumeric_yn"),"N");
		 // added by mujafar for ML-MMOH-CRF-524.1 start 
		alt_id1_alphanum_validate_yn = checkForNull( rset.getString("alt_id1_alphanum_validate_yn"),"N");
		alt_id2_alphanum_validate_yn = checkForNull( rset.getString("alt_id2_alphanum_validate_yn"),"N");
		alt_id3_alphanum_validate_yn = checkForNull( rset.getString("alt_id3_alphanum_validate_yn"),"N");
		alt_id4_alphanum_validate_yn = checkForNull( rset.getString("alt_id4_alphanum_validate_yn"),"N");
		 // added by mujafar for ML-MMOH-CRF-524.1 end 

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		alt_id2_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
		alt_id2_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id2_accept_alphanumeric_yn"),"N");
		alt_id3_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
		alt_id3_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id3_accept_alphanumeric_yn"),"N");
		alt_id4_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
		alt_id4_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id4_accept_alphanumeric_yn"),"N");
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

		pat_name_as_multipart_yn			= checkForNull( rset.getString("pat_name_as_multipart_yn"),"N");
		maintain_doc_or_file					= checkForNull( rset.getString("maintain_doc_or_file") );
		max_pat_age							= checkForNull( rset.getString("max_patient_age") );
		Accept_oth_alt_id_yn				= checkForNull( rset.getString("Accept_oth_alt_id_yn"),"N");
		create_file_at_pat_regn_yn		= checkForNull( rset.getString("create_file_at_pat_regn_yn"),"N");
		nat_invoke_routine				= checkForNull( rset.getString("invoke_routine"));
		nat_data_source_id			= checkForNull( rset.getString("nat_data_source_id"));
		nat_id_check_digit_id			= checkForNull( rset.getString("nat_id_check_digit_id"));
		nat_id_chk_len					= checkForNull( rset.getString("nat_id_chk_len"));
		name_prefix_reqd_yn				= checkForNull( rset.getString("name_prefix_reqd_yn"));
		dflt_language_id				= checkForNull( rset.getString("DFLT_LANGUAGE_ID"));
		dflt_relgn_code					= checkForNull( rset.getString("DFLT_RELGN_CODE"));
		inv_pat_search_in_reg_pat_yn	= checkForNull( rset.getString("INV_PAT_SEARCH_IN_REG_PAT_YN"),"N");
		// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn	= checkForNull( rset.getString("COUNTRY_REQD_YN"),"N");
		region_reqd_yn	= checkForNull( rset.getString("REGION_REQD_YN"),"N");
		mobile_no_reqd_yn	= checkForNull( rset.getString("MOBILE_NO_REQD_YN"),"N");
		// New parameter  is added against AMRI-CRF-0388 by Shagar
		postal_cd_reqd_yn	= checkForNull( rset.getString("postal_cd_reqd_yn"),"N");
		area_reqd_yn	= checkForNull( rset.getString("area_reqd_yn"),"N");
		town_reqd_yn    = checkForNull( rset.getString("town_reqd_yn"),"N"); //Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522
		// Ends here
		// New Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
		email_id_reqd_yn	= checkForNull( rset.getString("EMAIL_ID_REQD_YN"),"N");
		if(bl_install_yn.equals("Y")) {
			dflt_pat_regn_blng_class	= checkForNull( rset.getString("dflt_pat_regn_blng_class"),"");
		}		

		if(AltIdNo.equals("") && !patient_grp.equals("N")) patient_grp = "G" ;
		sql = "SELECT pat_ser_grp_code,"+
				 "        gen_pat_id_yn,"+
				 "        mp_get_desc.MP_PAT_SER_GRP(pat_ser_grp_code,'"+locale+"',2) short_desc"+
				 " FROM   mp_pat_ser_grp"+
				 " WHERE  id_type NOT IN ('X','R')";
		if(oth_rset!=null) oth_rset.close();
		if(oth_stmt!=null) oth_stmt.close();
		oth_stmt = con.prepareStatement(sql);
		oth_rset = oth_stmt.executeQuery();	

		if(oth_rset != null)
		{
			int k= 0;
			out.println("<script>");
			while ( oth_rset.next() )
			{
				out.println("PSGCodeArray["+k+"]=\""+oth_rset.getString("pat_ser_grp_code")+"\";");
				out.println("PSGYNArray["+k+"]=\""+oth_rset.getString("gen_pat_id_yn")+"\";");
				out.println("PSGCodeArrayValues["+k+"]=\""+oth_rset.getString("short_desc")+"\";");
				k++;
			}
			out.println("</script>");
			if(oth_rset != null)  oth_rset.close();
		}

		cust_fields[0] = rset.getString("addl_field1_section")+"`"+rset.getString("addl_field1_prompt")+"`"+ rset.getString("addl_field1_length")+"`addl_field1";
		cust_fields[1] = rset.getString("addl_field2_section")+"`"+rset.getString("addl_field2_prompt")+"`"+ rset.getString("addl_field2_length")+"`addl_field2";
		cust_fields[2] = rset.getString("addl_field3_section")+"`"+rset.getString("addl_field3_prompt")+"`"+ rset.getString("addl_field3_length")+"`addl_field3";
		cust_fields[3] = rset.getString("addl_field4_section")+"`"+rset.getString("addl_field4_prompt")+"`"+ rset.getString("addl_field4_length")+"`addl_field4";
		cust_fields[4] = rset.getString("addl_field5_section")+"`"+rset.getString("addl_field5_prompt")+"`"+ rset.getString("addl_field5_length")+"`addl_field5"; 

		for(int i=0;i<cust_fields.length;i++) {
			if(cust_fields[i].charAt(0) == 'D')
				++Demoaddlcnt;
			if(cust_fields[i].charAt(0) == 'C')
				++Contactaddlcnt;
			/*if(cust_fields[i].charAt(0) == 'N')
				++NoKaddlcnt;
			if(cust_fields[i].charAt(0) == 'F')
				++FtNotifyaddlcnt;
			if(cust_fields[i].charAt(0) == 'E')
				++Empraddlcnt;*/
			if(cust_fields[i].charAt(0) == 'O')
				++Othersaddlcnt;
		}
	}
	catch(Exception e) {
		out.println("Error in the header block:"+e+"<br>"+sql) ;
		e.printStackTrace();
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isVirtualConsultation){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Contactaddlcnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_grp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block20Bytes, _wl_block20);

		try
		{
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(a_postal_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(a_mail_postal_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id1_accept_oth_pat_ser_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(alt_id1_alphanum_validate_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id2_alphanum_validate_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alt_id3_alphanum_validate_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alt_id4_alphanum_validate_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alt_id2_accept_oth_pat_ser_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id2_accept_alphanumeric_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id3_accept_oth_pat_ser_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id3_accept_alphanumeric_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id4_accept_oth_pat_ser_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id4_accept_alphanumeric_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(max_pat_age));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pat_category_reqd_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(org_member_relationship_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(org_member_relationship_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

			FamilyNoLink					= checkForNull(rset.getString("Family_No_Link_Yn"),"N");
			dfltPSG							= checkForNull(rset.getString("dfltPSG"));
			
			citizen_nationality_code	= checkForNull(rset.getString("citizen_nationality_code"));
			if(a_race_code.equals("")) {
				a_race_code = checkForNull(rset.getString("default_race_code"));
			} 
			/*Two param added for this CRF [RUT-CRF-0011]*/ 
			// Below appt_ref_no param newly added for Incident 36262 
			
            _bw.write(_wl_block43Bytes, _wl_block43);
 if(function_name.equals("01"))
			{
				try
				{
					if(session.getAttribute("smart_data") != null)
					{	
						String smartdata = (String)session.getAttribute("smart_data");
						String smartdata_arr[] = smartdata.split("!~");
						a_national_id_no = smartdata_arr[0];
						a_oth_contact_no = smartdata_arr[1];
						a_first_name = smartdata_arr[2];
						a_second_name =  smartdata_arr[3];
						a_third_name = smartdata_arr[4];
						a_name_prefix = smartdata_arr[5];
						a_family_name = smartdata_arr[6];
						a_gender = smartdata_arr[7];
						a_date_of_birth = smartdata_arr[8];
						alt_addr_line1 = smartdata_arr[9];
						a_oth_alt_id_no =  smartdata_arr[10]; //passport numer
						//a_first_name =  smartdata_arr[11]; //passport exp date
						//a_nationality_code = smartdata_arr[12];
						a_res_country_desc = smartdata_arr[13];
						//a_first_name = smartdata_arr[14]; //emirates
						dfltPSG = pat_series;
						//dfltPSG = "97";
						
						//to get the nationality code --start
						oth_stmt = con.prepareStatement("select country_code as VALUE_2 from mp_country where long_name = '"+smartdata_arr[12]+"'");
						oth_rset = oth_stmt.executeQuery();	
						if(oth_rset!=null && oth_rset.next())
						{
							a_nationality_code=oth_rset.getString("VALUE_2");   // alkhaleej smart card
						}		
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						//to get the nationality code --end

					



						}

					}
					catch(Exception e)
					{
					e.printStackTrace();
					}
			session.removeAttribute("smart_card_data");		
			
			} else if(function_name.equals("05")){//Start by santhosh for TH-KW-CRF-0019.1
				try
				{
					if(session.getAttribute("smart_card_data") != null)
					{
						String smart_card_data = (String)session.getAttribute("smart_card_data");
						String smartCardData_arr[] = smart_card_data.split("!~");
						
						a_national_id_no = smartCardData_arr[0];
						a_first_name = smartCardData_arr[1];
						a_second_name =  smartCardData_arr[2];						
						a_family_name = smartCardData_arr[3];
						a_date_of_birth = smartCardData_arr[4];
						nat_id_exp_date =  smartCardData_arr[5]; //passport exp date
						a_gender = smartCardData_arr[7];
						blood_group = smartCardData_arr[8];
						a_oth_alt_id_no =  smartCardData_arr[9]; //passport numer
						dfltPSG = pat_series;
						
						//to get the nationality code --start
						oth_stmt = con.prepareStatement("select country_code as VALUE_2 from mp_country where long_name = '"+smartCardData_arr[6]+"'");
						oth_rset = oth_stmt.executeQuery();	
						if(oth_rset!=null && oth_rset.next())
						{
							a_nationality_code=oth_rset.getString("VALUE_2");   // alkhaleej smart card
						}		
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						//to get the nationality code --end
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//End by santhosh for TH-KW-CRF-0019.1
				session.removeAttribute("smart_card_data");
			}  
            _bw.write(_wl_block44Bytes, _wl_block44);
            {java.lang.String __page ="../../eMP/jsp/ChangePatientSubNames.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("group"), weblogic.utils.StringUtils.valueOf(patient_grp
                        )},{ weblogic.utils.StringUtils.valueOf("CalledFromFunction"), weblogic.utils.StringUtils.valueOf("PatientRegistration")},{ weblogic.utils.StringUtils.valueOf("patient_cat_code"), weblogic.utils.StringUtils.valueOf(patient_cat_code
                        )},{ weblogic.utils.StringUtils.valueOf("patient_cat_desc"), weblogic.utils.StringUtils.valueOf(patient_cat_desc
                        )},{ weblogic.utils.StringUtils.valueOf("language_id"), weblogic.utils.StringUtils.valueOf(language_id
                        )},{ weblogic.utils.StringUtils.valueOf("language_desc"), weblogic.utils.StringUtils.valueOf(language_desc
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name"), weblogic.utils.StringUtils.valueOf(a_family_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name"), weblogic.utils.StringUtils.valueOf(a_first_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name"), weblogic.utils.StringUtils.valueOf(a_second_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name"), weblogic.utils.StringUtils.valueOf(a_third_name
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix"), weblogic.utils.StringUtils.valueOf(a_name_prefix
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix"), weblogic.utils.StringUtils.valueOf(a_name_suffix
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_prefix_loc_lang"), weblogic.utils.StringUtils.valueOf(a_name_prefix_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_first_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_first_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_second_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_second_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_third_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_third_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_family_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_family_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_name_suffix_loc_lang"), weblogic.utils.StringUtils.valueOf(a_name_suffix_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_patient_name_loc_lang"), weblogic.utils.StringUtils.valueOf(a_patient_name_loc_lang
                        )},{ weblogic.utils.StringUtils.valueOf("a_national_id_no"), weblogic.utils.StringUtils.valueOf(a_national_id_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_oth_alt_id_type"), weblogic.utils.StringUtils.valueOf(a_oth_alt_id_type
                        )},{ weblogic.utils.StringUtils.valueOf("a_oth_alt_id_no"), weblogic.utils.StringUtils.valueOf(a_oth_alt_id_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id1_no"), weblogic.utils.StringUtils.valueOf(a_alt_id1_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id1_exp_date"), weblogic.utils.StringUtils.valueOf(a_alt_id1_exp_date
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id2_no"), weblogic.utils.StringUtils.valueOf(a_alt_id2_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id2_exp_date"), weblogic.utils.StringUtils.valueOf(a_alt_id2_exp_date
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id3_no"), weblogic.utils.StringUtils.valueOf(a_alt_id3_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id3_exp_date"), weblogic.utils.StringUtils.valueOf(a_alt_id3_exp_date
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id4_no"), weblogic.utils.StringUtils.valueOf(a_alt_id4_no
                        )},{ weblogic.utils.StringUtils.valueOf("a_alt_id4_exp_date"), weblogic.utils.StringUtils.valueOf(a_alt_id4_exp_date
                        )},{ weblogic.utils.StringUtils.valueOf("a_familyno"), weblogic.utils.StringUtils.valueOf(a_familyno
                        )},{ weblogic.utils.StringUtils.valueOf("a_gender"), weblogic.utils.StringUtils.valueOf(a_gender
                        )},{ weblogic.utils.StringUtils.valueOf("a_birth_place_desc"), weblogic.utils.StringUtils.valueOf(a_birth_place_desc
                        )},{ weblogic.utils.StringUtils.valueOf("a_birth_place_code"), weblogic.utils.StringUtils.valueOf(a_birth_place_code
                        )},{ weblogic.utils.StringUtils.valueOf("a_place_of_birth"), weblogic.utils.StringUtils.valueOf(a_place_of_birth
                        )},{ weblogic.utils.StringUtils.valueOf("a_date_of_birth"), weblogic.utils.StringUtils.valueOf(a_date_of_birth
                        )},{ weblogic.utils.StringUtils.valueOf("a_citizen_yn"), weblogic.utils.StringUtils.valueOf(a_citizen_yn
                        )},{ weblogic.utils.StringUtils.valueOf("a_legal_yn"), weblogic.utils.StringUtils.valueOf(a_legal_yn
                        )},{ weblogic.utils.StringUtils.valueOf("a_nationality_code"), weblogic.utils.StringUtils.valueOf(a_nationality_code
                        )},{ weblogic.utils.StringUtils.valueOf("a_race_code"), weblogic.utils.StringUtils.valueOf(a_race_code
                        )},{ weblogic.utils.StringUtils.valueOf("relgn_code"), weblogic.utils.StringUtils.valueOf(relgn_code
                        )},{ weblogic.utils.StringUtils.valueOf("citizen_nationality_code"), weblogic.utils.StringUtils.valueOf(citizen_nationality_code
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_alt_id1_in_emp_id_yn"), weblogic.utils.StringUtils.valueOf(dflt_alt_id1_in_emp_id_yn
                        )},{ weblogic.utils.StringUtils.valueOf("Site"), weblogic.utils.StringUtils.valueOf(Site
                        )},{ weblogic.utils.StringUtils.valueOf("dfltPSG"), weblogic.utils.StringUtils.valueOf(dfltPSG
                        )},{ weblogic.utils.StringUtils.valueOf("year"), weblogic.utils.StringUtils.valueOf(year
                        )},{ weblogic.utils.StringUtils.valueOf("months"), weblogic.utils.StringUtils.valueOf(months
                        )},{ weblogic.utils.StringUtils.valueOf("days"), weblogic.utils.StringUtils.valueOf(days
                        )},{ weblogic.utils.StringUtils.valueOf("Demoaddlcnt"), weblogic.utils.StringUtils.valueOf(Demoaddlcnt
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_language_id"), weblogic.utils.StringUtils.valueOf(dflt_language_id
                        )},{ weblogic.utils.StringUtils.valueOf("dflt_relgn_code"), weblogic.utils.StringUtils.valueOf(dflt_relgn_code
                        )},{ weblogic.utils.StringUtils.valueOf("inv_pat_search_in_reg_pat_yn"), weblogic.utils.StringUtils.valueOf(inv_pat_search_in_reg_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("nat_id_accept_alphanumeric_yn"), weblogic.utils.StringUtils.valueOf(nat_id_accept_alphanumeric_yn
                        )},{ weblogic.utils.StringUtils.valueOf("PatInfflag"), weblogic.utils.StringUtils.valueOf(PatInfflag
                        )},{ weblogic.utils.StringUtils.valueOf("appt_ref_no"), weblogic.utils.StringUtils.valueOf(appt_ref_no
                        )},{ weblogic.utils.StringUtils.valueOf("blood_group"), weblogic.utils.StringUtils.valueOf(blood_group
                        )},{ weblogic.utils.StringUtils.valueOf("nat_id_exp_date"), weblogic.utils.StringUtils.valueOf(nat_id_exp_date
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block50Bytes, _wl_block50);

					// Code for additional fields for Demographics tab
                    order=0;
					int demo_cnt = 1;
                    for(int i=0; i<cust_fields.length;i++)
                    {
						if(cust_fields[i].charAt(0) == 'D' )
                        {
                           	int intind_0		= cust_fields[i].indexOf('`');
							String strcf		= cust_fields[i];		
							String strs1	 	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1		= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	 	= strs1.substring(intind_1+1, strs1.length());
							int intind_2		= strs2.indexOf('`');
							String size		= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme		= strs3.substring(0);

							if(order == 0)
                            {
                                out.println("<tr></tr><tr>");
                                out.println("<td colspan=2>");
                            }

                            if( order %2 == 0 || order == 0)
                            {
								out.println("</tr><tr>") ;
								if(Demoaddlcnt == (i+1))
								{ 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(size));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
 } else { 
										
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(size));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
 }
                            }
							if(order %2 != 0 && order!=0)
							{
								if(Demoaddlcnt==(i+1))
								{ 
									
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(size));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } else { 
										
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(size));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
 }
							}
                            order++;
							demo_cnt++;
                        }
						
                    }
					if(order %2 != 0 && order!=0)
					{
            _bw.write(_wl_block60Bytes, _wl_block60);
}
                   if (order != 0)
                    {
                        out.println("</table>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block62Bytes, _wl_block62);
if(alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block62Bytes, _wl_block62);
} if(!alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
} if((!alterAddressApplicable && !increasedaddressLength) || (alterAddressApplicable && increasedaddressLength)){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
// New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar 	
						if(region_reqd_yn.equals("Y")){ 
										region_visibility = "visibility:visible";} // Ends here
							
							StringBuffer sb1a			= new StringBuffer();
                            StringBuffer fieldVala		= new StringBuffer();
							StringBuffer sba			= new StringBuffer();
							StringBuffer sbap			= new StringBuffer();
							StringBuffer sbar			= new StringBuffer();
							StringBuffer sb1aa		= new StringBuffer();
                            StringBuffer fieldValaa	= new StringBuffer();
							
							//Added for this CRF ML-MMOH-CRF-0601
							StringBuffer sb_a = new StringBuffer();
							StringBuffer sb_ap			= new StringBuffer();
							StringBuffer sb_ar			= new StringBuffer();
							StringBuffer sb1_aa		= new StringBuffer();
                            StringBuffer fieldVal_aa	= new StringBuffer(); 
							//End this CRF ML-MMOH-CRF-0601

							for(int i=0;i<contact_col_names.length; i++)
                            { 
								
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(contact_prompts[i]));
            _bw.write(_wl_block72Bytes, _wl_block72);
 
									String val  = contact_fields[i];
									String val_alt = contact_fields[i]; //Added for this CRF ML-MMOH-CRF-0601
									sb1a.append(val);
                                    fieldVala.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1a.substring(z,z+1);
										
										if(tempVal.equals("@"))
										{
											fieldVala.append("50");
										}
										else
										{
											fieldVala.append(tempVal);
										}
									}
									val = fieldVala.toString();
									val_alt = fieldVala.toString(); //Added for this CRF ML-MMOH-CRF-0601
									
									// modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
                                   
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(val));

									
                                    val = contact_fields[i] ;
									val_alt = contact_fields[i] ; //Added for this CRF ML-MMOH-CRF-0601
																		
                                    sba.append(val) ;
									sb_a.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
									 String new_val_alt=""; //Added for this CRF ML-MMOH-CRF-0601
									if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "m_addr_line1" ;
										new_val_alt = "a_addr_line1" ; //Added for this CRF ML-MMOH-CRF-0601
                                        if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                        out.println("<img id='addr_pincode_mand1' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "m_addr_line2" ;
										new_val_alt = "a_addr_line2" ;  //Added for this CRF ML-MMOH-CRF-0601
                                        if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                        out.println("<img id='addr_pincode_mand2' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "m_addr_line3" ;
										new_val_alt = "a_addr_line3" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "m_addr_line4" ;
										new_val_alt = "a_addr_line4" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
										new_val_alt = "a_town_code" ; //Added for this CRF ML-MMOH-CRF-0601
									if(town_reqd_yn.equals("Y")){/*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
	                                        out.println("<img id='town_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
										// Image is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
										out.println("<img id='id1' src='../images/mandatory.gif' style='"+region_visibility+"'</img>");
                                        new_val = "m_region_code" ;
										new_val_alt = "a_region_code" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
										new_val_alt = "a_area_code" ; //Added for this CRF ML-MMOH-CRF-0601
									if(area_reqd_yn.equals("Y")){/*Added by agiant AMRI-CRF-0388*/
                                        out.println("<img id='area_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
										new_val_alt = "alt_postal_code" ;  //Added for this CRF ML-MMOH-CRF-0601
                                       // if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                       //out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
									   //above 2 lines commented against AMRI-CRF-0388 by Shagar
									/*Added by agiant AMRI-CRF-0388*/
									if(postal_cd_reqd_yn.equals("Y")){
                                        out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sba = sba.replace(j,(j+old_val.length()),new_val);
                                        val = sba.toString();
									}
									//Added for this CRF ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
									while(val_alt.indexOf(old_val) != -1)
                                    {
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
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
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
									
									for(int z=0;z<val_alt.length();z++)
									{
										String tempVal=sb1_aa.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal_aa.append("64"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal_aa.append(tempVal);
										}
									}
									
									val_alt = fieldVal_aa.toString();
									
									//End ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
									
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{ 
										sbap.append(val);
										
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
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
											
											sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
											val = sbar.toString();
											
										}
									}
									
									
									
									
									
									
                                    sb1aa.append(val) ;
                                    fieldValaa.append("");
									
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1aa.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldValaa.append("78"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldValaa.append(tempVal);
										}
									}
									
									val = fieldValaa.toString();
									
            _bw.write(_wl_block74Bytes, _wl_block74);
									
									if(alterAddressApplicable){
									if(i == 1)
									{  
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(val_alt));
            _bw.write(_wl_block77Bytes, _wl_block77);
}else{   
									    out.println("<td class='fields' colspan='"+col_span_td+"'>"+val_alt+"</td>") ;
									  }						
									}
									
            _bw.write(_wl_block78Bytes, _wl_block78);
if(i == 0)
									{ 
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(val));
            _bw.write(_wl_block80Bytes, _wl_block80);
 //Added for ML-MMOH-CRF-0860.2
									if( (!increasedaddressLength) || (increasedaddressLength && ! alterAddressApplicable) ){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block82Bytes, _wl_block82);
}//End ML-MMOH-CRF-0860.2
            _bw.write(_wl_block83Bytes, _wl_block83);
}else	
									if(i==1 && alterAddressApplicable)
									{
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(val));
            _bw.write(_wl_block86Bytes, _wl_block86);
}	
									else
									{
									    out.println("<td class='fields'  colspan='"+col_span_td+"' >"+val+"</td>") ;
									}
									out.println("</tr><tr><td class='label' colspan='4' ></td></tr>") ;
									
									sb1a.setLength(0);
									fieldVala.setLength(0);
									sba.setLength(0);
									sb_a.setLength(0);
									sb1aa.setLength(0);
									sb1_aa.setLength(0);
									fieldValaa.setLength(0);
									fieldVal_aa.setLength(0);
									sbap.setLength(0);
									sb_ap.setLength(0);
									sbar.setLength(0);
									sb_ar.setLength(0);
									
								}
							
							    
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(a_res_addr_line1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(a_res_addr_line2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(a_res_addr_line3));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(a_res_addr_line4));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(a_res_town_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(a_res_town_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(a_res_region_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(a_res_region_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(a_res_area_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(a_res_area_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(a_postal_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(a_mail_addr_line1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(a_mail_addr_line2));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(a_mail_addr_line3));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(a_mail_addr_line4));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(a_mail_town_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(a_mail_town_desc));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(a_mail_region_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(a_mail_region_desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(a_mail_area_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(a_mail_area_desc));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(a_mail_postal_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
 //tindex=61; //Commented by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						 // New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						 if(country_reqd_yn.equals("Y")){
						country_visibility = "visibility:visible";}
						// below New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(a_res_country_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(country_visibility));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(a_country_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
 //tindex=76; //Commented by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
            _bw.write(_wl_block127Bytes, _wl_block127);

						//Below line added for this CRF and ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2	
						if(alterAddressApplicable)
						{
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
}
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(a_mail_country_desc));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(a_mail_country_code));
            _bw.write(_wl_block135Bytes, _wl_block135);
 //tindex=63; //Commented by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(res_contact_name));
            _bw.write(_wl_block138Bytes, _wl_block138);
 //tindex=78; //Commented by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
            _bw.write(_wl_block139Bytes, _wl_block139);

							//Below line added for this CRF and ML-MMOH-CRF-0601 
							if(alterAddressApplicable)
							{							
							
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mail_contact_name));
            _bw.write(_wl_block142Bytes, _wl_block142);

							}
							
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(mail_contact_name));
            _bw.write(_wl_block145Bytes, _wl_block145);
if(alterAddressApplicable){
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block148Bytes, _wl_block148);
}
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(colspantd));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block151Bytes, _wl_block151);

                                sql="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
                                if(oth_rset!=null) oth_rset.close();
								if(oth_stmt!=null) oth_stmt.close();
								oth_stmt = con.prepareStatement(sql);
							    oth_rset = oth_stmt.executeQuery();	

                                if(oth_rset.next())
                                {
								   //Modified for this SCF AAKH-SCF-0261							
                                    out.println("<td  class='label'  >"+oth_rset.getString(1)+"</td>");
                                    out.println("<td class='fields'>") ;
                                    out.println("<input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13' value=\""+a_res_tel_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>") ;
                                    out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='13' value=\""+oth_rset.getString(2)+"\"  onblur='makeValidString(this);'>") ;
                                    out.println("</td>") ;
                                }
                                else
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
                                    out.println("<td class='fields'>") ;
                                    out.println("<input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13' value=\""+a_res_tel_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>") ;
                                    out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='13' value=\"\"  onblur='makeValidString(this);'>") ;
                                }
								if(mobile_no_reqd_yn.equals("Y")){ 
								   mobile_no_visibility = "visibility:visible";}
                                if(oth_rset.next())
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
									out.println("<td class='label'  >"+oth_rset.getString(1)+"</td> ");
                                    out.println("<td class='fields'>") ;
							//Added by Kamatchi S for ML-MMOH-CRF-1930 US004 start
							if(isVirtualConsultation){
							try{
							stmt=con.prepareStatement("Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and language_id='en'  ORDER BY 2 ");
							rs = stmt.executeQuery();
									out.println("<select name='country' id='country' onChange= 'telephoneCode(this);'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------</option>");
									
									if( rs != null )
									{
										while(rs.next()) 
											{
											classcode = rs.getString( "code" ) ;
											classdesc = rs.getString( "description" ) ;
											if(!countryC.equals("") || !countryC.equals("null")){
												if(countryC.equals(classcode)){
													out.println("<option value=\"" + classcode + "\" selected>" + classdesc );
												}else{
													out.println("<option value=\"" + classcode + "\">" + classdesc);
												}
											}else{
												out.println("<option value=\"" + classcode + "\">" + classdesc);
											}
										}
									}
									out.println("<input type='hidden' name='countryC' id='countryC' value=\""+countryC+"\"  ") ;
									} catch(Exception e) { 
										out.println(e.toString());
										e.printStackTrace();
									} finally {
									if (rs != null) rs.close();
									if (stmt != null) stmt.close(); 			
									}
								out.println("</select> <input type='text' name='telephone' id='telephone' maxlength='6' size='6' Readonly value='' >") ;
								}
								//Added by Kamatchi S for ML-MMOH-CRF-1930 US004 END
									out.println("<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13' value= \""+a_oth_contact_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' >") ;
									// New Image  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
									out.println("<img id='id3' src='../images/mandatory.gif' style='"+mobile_no_visibility+"'</img>");
									out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='13' value=\""+oth_rset.getString(2)+"\"  ") ;
                                    out.println("</td>") ;
                                }
                                else
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
                                    out.println("<td  class='fields'>") ;
                                    out.println("<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13' value= \""+a_oth_contact_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' >") ;
                                    out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='13' value=\"\" >") ;
                                    out.println("</td>") ;
                                }
								
							//Below line added for this CRF ML-MMOH-CRF-0860.2
						    if(increasedaddressLength){							
							if(email_id_reqd_yn.equals("Y")){email_visibility = "visibility:visible";} 							
							out.println("<td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"</td>");
							out.println("<td class='fields'><input type='text' name='email' id='email' maxlength=50 size=34.5 value='"+a_email_id+"'  onblur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='"+email_visibility+"'</img></td>");
							}
							//End this CRF ML-MMOH-CRF-0860.2
							
								
							out.println("</tr>");
							
							//Below line added for this CRF ML-MMOH-CRF-0860.2
						    if(!increasedaddressLength){
							// Condition & Iamge Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
							if(email_id_reqd_yn.equals("Y")){
							email_visibility = "visibility:visible";} 
							out.println("<tr><td class='label'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"</td>");
							out.println("<td class='fields'><input type='text' name='email' id='email' maxlength=50 size=34.5 value='"+a_email_id+"'  onblur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='"+email_visibility+"'</img></td><td class='label' colspan='2' ></td></tr>");
                            if (oth_rset != null)    oth_rset.close() ;
                            
            _bw.write(_wl_block152Bytes, _wl_block152);

					   }//End this CRF ML-MMOH-CRF-0860.2
					   
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
					/*
						sql = "select contact_mode,short_desc from mp_contact_mode_lang_vw  where language_id='"+locale+"' and eff_status='E' and contact_mode not in ('PRN','ORN') order by 2";
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
													
						//String enabledisable = "disabled";
						if (oth_rset.next()) enabledisable = ""; 
						*/
						
						
						
						//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block162Bytes, _wl_block162);
}else{
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block166Bytes, _wl_block166);
 }//End ML-MMOH-CRF-0860.2
						
						for(int i=0; i<cust_fields.length;i++)
								{
									if(cust_fields[i].charAt(0) == 'C' )
									{
									
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(colspantd));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block169Bytes, _wl_block169);
 break;} 
								} 
            _bw.write(_wl_block170Bytes, _wl_block170);

							int myflag=0;	
							int custLngth=0;
                            for(int i=0; i<cust_fields.length;i++)
                            {
                                if(cust_fields[i].charAt(0) == 'C' )
                                {
                                    int intind_0	= cust_fields[i].indexOf('`');
									String strcf	= cust_fields[i];	
									String strs1	= strcf.substring(intind_0+1, strcf.length());
														
									int intind_1	= strs1.indexOf('`');
									String lab		= strs1.substring(0, intind_1);
									String strs2	= strs1.substring(intind_1+1, strs1.length());
									int intind_2	= strs2.indexOf('`');
									String size		= strs2.substring(0, intind_2);
									
									String strs3	= strs2.substring(intind_2+1, strs2.length());
									String nme		= strs3.substring(0);
									myflag++;
									out.println("<td class='label'>"+lab+"</td>");
                                    out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  value=\"\" onblur='makeValidString(this);' value=\"\"></td>");
									if (myflag%2==0)
										out.println("</tr><tr>");
                                }
								custLngth = i;
                            }
							if (myflag%2 != 0)
							{
								out.println("<td class='label' colspan='2'></td></tr>");
							}
                        
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block177Bytes, _wl_block177);
if(increasedaddressLength){
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(nkin_contact_name));
            _bw.write(_wl_block179Bytes, _wl_block179);
}else{
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(nkin_contact_name));
            _bw.write(_wl_block181Bytes, _wl_block181);
}
            _bw.write(_wl_block182Bytes, _wl_block182);
 
				sql = "select relationship_code,short_desc from mp_relationship_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2";
							
                    codes =new ArrayList();
                    descs =new ArrayList();

					if(oth_rset!=null) oth_rset.close();
					if(oth_stmt!=null) oth_stmt.close();	

                    oth_stmt = con.prepareStatement(sql);
					oth_rset = oth_stmt.executeQuery();	
								
                    while(oth_rset.next())
                    {
                       codes.add(oth_rset.getString(1)) ;
                       descs.add(oth_rset.getString(2)) ;
                    }
                    relationcode = codes.toArray();   
					relationdesc = descs.toArray();
					
                    codes = null; 
                    descs = null;
                    if( oth_rset != null )  oth_rset.close();  
				
            _bw.write(_wl_block183Bytes, _wl_block183);
if(aliasnameNationalityRace){
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(nkin_alias_name));
            _bw.write(_wl_block186Bytes, _wl_block186);
} 
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block188Bytes, _wl_block188);
 
					String nat_on_blurfn_st = "";
					String nat_id_onKeyPress="";
					if(accept_national_id_no_yn.equals("Y")) { 
					nat_on_blurfn_st = "makeValidString(this);validateNationality(this,'"+Site+"','"+def_nat_id_pat_ser_grp+"','"+nat_invoke_routine+"','"+nat_data_source_id+"','"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','N')";

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

					
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(rset.getString("nat_id_prompt")));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(rset.getString("nat_id_length") ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(contact1_nat_id_no));
            _bw.write(_wl_block195Bytes, _wl_block195);
}else{
            _bw.write(_wl_block196Bytes, _wl_block196);
}
            _bw.write(_wl_block197Bytes, _wl_block197);
if( rset.getString("alt_id1_type") != null ) {
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( (rset.getString("alt_id1_desc") == null? "":rset.getString("alt_id1_desc")) ));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(rset.getString("alt_id1_type")));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(rset.getString("Alt_Id1_length")));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(rset.getString("Alt_Id1_length")));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(contact1_alt_id1_no));
            _bw.write(_wl_block202Bytes, _wl_block202);
}
				if( rset.getString("alt_id2_type") != null ) {
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( (rset.getString("alt_id2_desc") == null? "":rset.getString("alt_id2_desc")) ));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(rset.getString("alt_id2_type")));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(rset.getString("Alt_Id2_length")));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(rset.getString("Alt_Id2_length")));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(contact1_alt_id2_no));
            _bw.write(_wl_block202Bytes, _wl_block202);
}if( rset.getString("alt_id3_type") != null ) {
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( (rset.getString("alt_id3_desc") == null? "":rset.getString("alt_id3_desc")) ));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(rset.getString("alt_id3_type")));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(rset.getString("Alt_Id3_length")));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(rset.getString("Alt_Id3_length")));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(contact1_alt_id3_no));
            _bw.write(_wl_block202Bytes, _wl_block202);
}if( rset.getString("alt_id4_type") != null ) {
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf( (rset.getString("alt_id4_desc") == null? "":rset.getString("alt_id4_desc")) ));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(rset.getString("alt_id4_type")));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(rset.getString("Alt_Id4_length")));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(rset.getString("Alt_Id4_length")));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(contact1_alt_id4_no));
            _bw.write(_wl_block202Bytes, _wl_block202);
}
            _bw.write(_wl_block210Bytes, _wl_block210);
 if ( Accept_oth_alt_id_yn.equals("Y") )
					{ 
						sql = "SELECT alt_id_type,long_desc SHORT_DESC FROM MP_ALTERNATE_ID_TYPE_lang_vw WHERE language_id='"+locale+"' and alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id2_type,1)  FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";


						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
						
						while(oth_rset != null && oth_rset.next())
						{         
						    acodes.add(oth_rset.getString(1));
							adescs.add(oth_rset.getString(2));
						}
					altidcode = acodes.toArray();
					altiddesc = adescs.toArray();
					
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block213Bytes, _wl_block213);

						for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					    
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(nkin_oth_alt_id_no));
            _bw.write(_wl_block215Bytes, _wl_block215);
}
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(contact1_birth_date));
            _bw.write(_wl_block218Bytes, _wl_block218);
if(aliasnameNationalityRace){
            _bw.write(_wl_block210Bytes, _wl_block210);
hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(con, a_nationality_code, citizen_nationality_code,p);
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_code"))));
            _bw.write(_wl_block222Bytes, _wl_block222);

	 
			     hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(con, a_race_code,p); 
				 hash_Map = eMP.ChangePatientDetails.getSetupData(Facility,patient_grp,con,p);
			    
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_code"))));
            _bw.write(_wl_block226Bytes, _wl_block226);
} 
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(nkin_job_title));
            _bw.write(_wl_block229Bytes, _wl_block229);

					 
                    for(int i=0; i<cust_fields.length;i++)
                    {
                        if(cust_fields[i].charAt(0) == 'N' )
                        {
                            out.println("<tr>");
                            int intind_0	= cust_fields[i].indexOf('`');
							String strcf	= cust_fields[i];		
							String strs1	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1	= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	= strs1.substring(intind_1+1, strs1.length());
							int intind_2	= strs2.indexOf('`');
							String size	= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme	= strs3.substring(0);

                            out.println("<td class='label'   >"+lab+"</td>");
                            out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  onblur='makeValidString(this);' value = \"\"></td>");
                            out.println("</tr>"); 
                      }
                    }
			   
            _bw.write(_wl_block230Bytes, _wl_block230);
 if(resiAddMailAdd){
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block233Bytes, _wl_block233);
} 
            _bw.write(_wl_block234Bytes, _wl_block234);
	
					out.println("<tr>") ; 
					StringBuffer sbb = new StringBuffer() ;
					StringBuffer sbb1 = new StringBuffer() ;
					StringBuffer sb1b = new StringBuffer() ;
					StringBuffer sb1b1 = new StringBuffer() ;
					StringBuffer sbap1 = new StringBuffer() ;
					StringBuffer sbap11 = new StringBuffer() ;
					StringBuffer sbar1 = new StringBuffer() ;
					StringBuffer sbar11 = new StringBuffer() ;
                    StringBuffer fieldValb = new StringBuffer();
                    StringBuffer fieldValb1 = new StringBuffer();
                    for(int i=0;i<contact_col_names.length; i++) {
								String  val = contact_fields[i] ;
								String  val1 = contact_fields[i] ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
										  			
									sbb.append(val) ;
									sbb1.append(val1) ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
									 String new_val1 = "" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
              
					 if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
						old_val = "r_addr_line1"  ;
						new_val = "next_addr_line1" ;
						new_val1 = "n_next_addr_line1" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
						old_val = "r_addr_line2" ;
						new_val = "next_addr_line2" ;
						new_val1 = "n_ma_addr_line2" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
						old_val = "r_addr_line3" ;
						new_val = "next_addr_line3" ;
						new_val1 = "n_ma_addr_line3" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
						old_val = "r_addr_line4" ;
						new_val = "next_addr_line4" ;
						new_val1 = "n_ma_addr_line4" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						old_val = "r_town_code" ;
						new_val = "contact1_res_town_code" ;
						new_val1 = "n_contact_ma_town_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
						old_val = "r_region_code" ;
						new_val = "contact1_region_code" ;
						new_val1 = "n_contac_region_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						old_val = "r_area_code" ;
						new_val = "contact1_res_area_code" ;
						new_val1 = "n_contact_ma_area_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }                                     
					 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
						old_val = "r_postal_code" ;
						new_val = "next_postal_code" ;
						new_val1 = "n_ma_postal_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					 }
					out.println("<td class='label' nowrap width='50%'  >"+contact_prompts[i]+"</td>"); 
					while(val.indexOf(old_val) != -1) {
						j = val.indexOf(old_val,j) ;
						sbb = sbb.replace(j,(j+old_val.length()),new_val);
						val = sbb.toString();  
						sbb1 = sbb1.replace(j,(j+old_val.length()),new_val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						val1 = sbb1.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					}
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sbap1.append(val);
						sbap11.append(val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbap1 = sbap1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbap1.toString();
							sbap11 = sbap11.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val1 = sbap11.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar1.append(val);
						sbar11.append(val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar1 = sbar1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar1.toString();
							sbar11 = sbar11.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
							val1 = sbar11.toString();  //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
						}
					}
					sb1b.append(val) ;
					fieldValb.append("");
					for(int z=0;z<val.length();z++) {
						String tempVal=sb1b.substring(z,z+1);
						if(tempVal.equals("@")) {
							fieldValb.append(64); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						}
						else {
							fieldValb.append(tempVal);
						}
					}
					val = fieldValb.toString();
					
					//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
					sb1b1.append(val1) ;
					fieldValb1.append("");
					for(int z=0;z<val1.length();z++) {
						String tempVal=sb1b1.substring(z,z+1);
						if(tempVal.equals("@")) {
							fieldValb1.append(67); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						}
						else {
							fieldValb1.append(tempVal);
						}
					}
					val1 = fieldValb1.toString();

					
					if(resiAddMailAdd){
					out.println("<td class='fields' >"+val+"&nbsp;&nbsp;") ;
					out.println("<td class='fields' >"+val1+"&nbsp;&nbsp;") ;
					out.println("</td>");
					out.println("</td>");
					}else{
					out.println("<td width='50%' class='fields' >"+val) ;
					out.println("</td>");
					}
					//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
					out.println("</tr>");
	
					sbb.setLength(0);
					sb1b.setLength(0);
					sbb1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					sb1b1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					sbap1.setLength(0);
					sbar1.setLength(0);
					sbap11.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					sbar11.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					fieldValb.setLength(0);
					fieldValb1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
				}
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(nkin_country_name));
            _bw.write(_wl_block237Bytes, _wl_block237);
 if(resiAddMailAdd){
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(nk_mail_country_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(nkin_m_country_desc));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(resadd_contact_name));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(mailadd_contact_name));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block246Bytes, _wl_block246);
} 				
				
            _bw.write(_wl_block247Bytes, _wl_block247);
 if(!resiAddMailAdd){
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(nkin_res_tel_no));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(nkin_mob_tel_no));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(nkin_off_tel_no));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(nkin_email_id));
            _bw.write(_wl_block256Bytes, _wl_block256);
}
            _bw.write(_wl_block257Bytes, _wl_block257);
 if(!resiAddMailAdd){
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block259Bytes, _wl_block259);
   
						if(rset.getString("Family_No_Link_Yn").equals("Y"))
						{
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block261Bytes, _wl_block261);
} 
            _bw.write(_wl_block262Bytes, _wl_block262);
if(iSSiteApplicable){
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block264Bytes, _wl_block264);
}else{
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block267Bytes, _wl_block267);
}
            _bw.write(_wl_block268Bytes, _wl_block268);
} 
            _bw.write(_wl_block269Bytes, _wl_block269);
 if(resiAddMailAdd){
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(nkin_res_tel_no));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(nkin_mob_tel_no));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(nkin_email_id));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block281Bytes, _wl_block281);
} 
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block287Bytes, _wl_block287);
if(resiAddMailAdd){
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(fton_contact_name));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block291Bytes, _wl_block291);
 
						if(accept_national_id_no_yn.equals("Y")) { 
					
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(rset.getString("nat_id_prompt")));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(fton_nat_id_no));
            _bw.write(_wl_block295Bytes, _wl_block295);
}else{
            _bw.write(_wl_block296Bytes, _wl_block296);

					}
					//added by gomathi.
				 	if(Accept_oth_alt_id_yn.equals("Y")) 
					{ 
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block299Bytes, _wl_block299);

					for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(fton_alt_id_no));
            _bw.write(_wl_block301Bytes, _wl_block301);
}
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(fton_job_title));
            _bw.write(_wl_block304Bytes, _wl_block304);
}
		else
		 {//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(fton_contact_name));
            _bw.write(_wl_block307Bytes, _wl_block307);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(fton_off_tel_no));
            _bw.write(_wl_block310Bytes, _wl_block310);
}
						//End ML-MMOH-CRF-0860.2
						
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block314Bytes, _wl_block314);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block317Bytes, _wl_block317);
}//End ML-MMOh-CRF-0860.2
            _bw.write(_wl_block318Bytes, _wl_block318);
 
						if(accept_national_id_no_yn.equals("Y")) { 
					
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(rset.getString("nat_id_prompt")));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(fton_nat_id_no));
            _bw.write(_wl_block320Bytes, _wl_block320);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block323Bytes, _wl_block323);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block324Bytes, _wl_block324);
}else{
            _bw.write(_wl_block296Bytes, _wl_block296);

					
					
					}
					//added by gomathi.
				 	if(Accept_oth_alt_id_yn.equals("Y")) 
					{ 
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block299Bytes, _wl_block299);

						//sql = "select alt_id_type,long_desc SHORT_DESC from mp_alternate_id_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2";
						/*
						sql = "SELECT alt_id_type,long_desc SHORT_DESC FROM MP_ALTERNATE_ID_TYPE_lang_vw WHERE language_id='"+locale+"' AND alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM WHERE module_id = 'MP') AND eff_status='E' ORDER BY 2";						
						if(oth_rset!=null) oth_rset.close();
					    if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();
						
						if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}*/
					for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(fton_alt_id_no));
            _bw.write(_wl_block327Bytes, _wl_block327);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block328Bytes, _wl_block328);
if(accept_national_id_no_yn.equals("N")){
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block330Bytes, _wl_block330);
}
            _bw.write(_wl_block331Bytes, _wl_block331);
}
						//End ML-MMOH-CRF-0860.2
						
            _bw.write(_wl_block332Bytes, _wl_block332);
}
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(fton_job_title));
            _bw.write(_wl_block334Bytes, _wl_block334);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block328Bytes, _wl_block328);
if(Accept_oth_alt_id_yn.equals("N") && accept_national_id_no_yn.equals("N")){
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block330Bytes, _wl_block330);
}
            _bw.write(_wl_block335Bytes, _wl_block335);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block336Bytes, _wl_block336);
}
				if(resiAddMailAdd){
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block233Bytes, _wl_block233);
} 
            _bw.write(_wl_block338Bytes, _wl_block338);
 out.println("<tr>") ;
					StringBuffer sbc = new StringBuffer();
					StringBuffer sbc1 = new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sb1c = new StringBuffer() ;
					StringBuffer sb1c1 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sbap2 = new StringBuffer() ;
					StringBuffer sbap21 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer sbar2 = new StringBuffer() ;
					StringBuffer sbar21 = new StringBuffer() ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					StringBuffer fieldValc = new StringBuffer();
					StringBuffer fieldValc1 = new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
					//Added for ML-MMOH-CRF-0860.2
					String nextofkin_clospan="";
					if(increasedaddressLength) nextofkin_clospan="3";
					//End  ML-MMOH-CRF-0860.2
					
							for (int i=0;i<contact_col_names.length; i++)
                            {   
								out.println("<td class='label' nowrap >"+contact_prompts[i]+"</td>") ;
                                String val = contact_fields[i] ;
								String val2 = contact_fields[i] ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
                                    
                                    sbc.append(val) ;
									sbc1.append(val2) ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
									 String new_val2 = "" ;
                                     
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
                                     }//Added by kumar on 13/03/2003 for region 
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
                                        sbc = sbc.replace(j,(j+old_val.length()),new_val);
                                        val = sbc.toString();
										sbc1 = sbc1.replace(j,(j+old_val.length()),new_val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                        val2 = sbc1.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                    }	
									
									                                   
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")){
										sbap2.append(val);
										sbap21.append(val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap2 = sbap2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
											val = sbap2.toString();
											sbap21 = sbap21.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
											val2 = sbap21.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008			
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j1 = 0;
										sbar2.append(val);
										sbar21.append(val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
											val = sbar2.toString();
											sbar21 = sbar21.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod");
											val2 = sbar21.toString();			
										}
									}
                                    sb1c.append(val);
									fieldValc.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1c.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldValc.append(64); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldValc.append(tempVal);
										}
									}
                                  	val = fieldValc.toString();

									//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
                                    sb1c1.append(val2);
									fieldValc1.append("");
									for(int z=0;z<val2.length();z++)
									{
										String tempVal=sb1c1.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldValc1.append(67); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldValc1.append(tempVal);
										}
									}
                                  	val2 = fieldValc1.toString();
                                    
									//Below line modified for this ML-MMOH-CRF-0860.2 
            _bw.write(_wl_block339Bytes, _wl_block339);
if(resiAddMailAdd){
                                    out.println("<td class='fields' >"+val+"&nbsp;&nbsp;") ;
                                    out.println("<td class='fields' >"+val2+"&nbsp;&nbsp;") ;
									out.println("</td>");
									out.println("</td>");
									}else{
									out.println("<td class='fields'  colspan='"+nextofkin_clospan+"' >"+val) ;

									
									
							out.println("</td>");
									}//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
							out.println("</tr>");
							sbc.setLength(0);
							sbc1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
							sb1c.setLength(0);
							sb1c1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
							sbap2.setLength(0);
							sbap21.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
							sbar2.setLength(0);
							sbar21.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
							fieldValc.setLength(0);
							fieldValc1.setLength(0); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
						}
					
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(fton_country_name));
            _bw.write(_wl_block342Bytes, _wl_block342);
 if(resiAddMailAdd){
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(fton_mail_country_desc));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(fton_m_country_desc));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(fton_resadd_contact_name));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(fton_mailadd_contact_name));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block246Bytes, _wl_block246);
 } //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block210Bytes, _wl_block210);
//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008	
				if(!resiAddMailAdd){
            _bw.write(_wl_block350Bytes, _wl_block350);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block351Bytes, _wl_block351);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(fton_res_tel_no));
            _bw.write(_wl_block334Bytes, _wl_block334);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block351Bytes, _wl_block351);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(fton_mob_tel_no));
            _bw.write(_wl_block356Bytes, _wl_block356);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block351Bytes, _wl_block351);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block357Bytes, _wl_block357);

					//Added for this CRF ML-MMOh-CRF-0860.2
					if(!increasedaddressLength){
					
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(fton_off_tel_no));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block364Bytes, _wl_block364);
}
					 //End this ML-MMOh-CRF-0860.2
				} //Ended for ML-MMOH-CRF-1527 US008
					
            _bw.write(_wl_block365Bytes, _wl_block365);
if(resiAddMailAdd){
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(fton_res_tel_no));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(fton_mob_tel_no));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block375Bytes, _wl_block375);
} //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(organization_name));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(emplr_contact_name));
            _bw.write(_wl_block388Bytes, _wl_block388);

					out.println("<tr>") ; 
					StringBuffer sbd = new StringBuffer() ;
					StringBuffer  sb1d = new StringBuffer() ;
					StringBuffer  sbap3 = new StringBuffer() ;
					StringBuffer  sbar3 = new StringBuffer() ;
					StringBuffer fieldVald = new StringBuffer();
                    for(int i=0;i<contact_col_names.length; i++)
                            {                             
								out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	

                                   String val = contact_fields[i] ;
                                    sbd.append(val) ;
                                     int j=0 ;
                                     int j1=0 ;
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
                                     }//Added by kumar on 13/03/2003 for region 
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
                                        sbd = sbd.replace(j,(j+old_val.length()),new_val);
                                        val = sbd.toString();
                                    }
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sbap3.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap3 = sbap3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
											val = sbap3.toString();
											
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j1 = 0;
										sbar3.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbar3 = sbar3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
											val = sbar3.toString();
											
										}
									}
                                  sb1d.append(val) ;
								  fieldVald.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal = sb1d.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVald.append(++tindex);
										}
										else
										{
											fieldVald.append(tempVal);
										}
									}
                                    val = fieldVald.toString();
									out.println("<td class='fields' >"+val+"</td>") ;
                               		out.println("<td class='label' colspan='2' ></td>");
									out.println("</tr>") ;
	
							    sbd.setLength(0);
								sb1d.setLength(0);
								sbap3.setLength(0);
								sbar3.setLength(0);
								fieldVald.setLength(0);
                            }
						
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(emplr_country_name));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(emplr_res_tel_no));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(emplr_off_tel_no));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(patient_employee_id));
            _bw.write(_wl_block397Bytes, _wl_block397);
if (!a_alt_id1_no.equals("") && dflt_alt_id1_in_emp_id_yn.equals("Y")) { 
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(a_alt_id1_no));
            _bw.write(_wl_block399Bytes, _wl_block399);
}
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block415Bytes, _wl_block415);
 for(int i=0; i<cust_fields.length;i++)
				{
					if(cust_fields[i].charAt(0) == 'E' )
					{
						out.println("<tr>") ;
						int intind_0	= cust_fields[i].indexOf('`');
						String strcf	= cust_fields[i];		
						String strs1	= strcf.substring(intind_0+1, strcf.length());
											
						int intind_1	= strs1.indexOf('`');
						String lab		= strs1.substring(0, intind_1);
						String strs2	= strs1.substring(intind_1+1, strs1.length());
						int intind_2	= strs2.indexOf('`');
						String size		= strs2.substring(0, intind_2);
						
						String strs3	= strs2.substring(intind_2+1, strs2.length());
						String nme		= strs3.substring(0);

						 out.println("<td class='label'   >"+lab+"</td>");
						out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  onblur='makeValidString(this);' value = \"\"></td>");
						out.println("</tr>");
				   }
				}
			   
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block422Bytes, _wl_block422);

                    codes = new ArrayList();
                    descs = new ArrayList();
					/*Modified By Dharma on Feb 11th 2015 against ML-HSA-SCF-0192 [IN:053070] Start*/
                   // sql="Select doc_type,initcap(short_desc)short_name from mp_document_type_lang_vw where language_id='"+locale+"' and  EFF_STATUS='E' order by 2 ";
				    sql="Select doc_type,short_desc short_name from mp_document_type_lang_vw where language_id='"+locale+"' and  EFF_STATUS='E' order by 2 ";
					/*Modified By Dharma on Feb 11th 2015 against ML-HSA-SCF-0192 [IN:053070] End*/
					if(oth_rset!=null) oth_rset.close();
					if(oth_stmt!=null) oth_stmt.close();
                    oth_stmt = con.prepareStatement(sql);
					oth_rset = oth_stmt.executeQuery();	

                    while(oth_rset.next())
                    {
                        codes.add( oth_rset.getString(1) ) ;
                        descs.add( oth_rset.getString(2) ) ;
                    } 

                    oth_code  = codes.toArray();
                    oth_desc  = descs.toArray();

                    codes = null ;
                    descs = null ;
                    if(oth_rset!= null) oth_rset.close() ;
                
            _bw.write(_wl_block423Bytes, _wl_block423);
if(!doc1_num.equals("")){
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(doc1_num));
            _bw.write(_wl_block425Bytes, _wl_block425);
}else{
            _bw.write(_wl_block426Bytes, _wl_block426);
}
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(doc1_exp_date));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(doc1_exp_date));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(doc1_place_of_issue));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block434Bytes, _wl_block434);

					String sFacilityId = Facility;
					int iDocScanEnabled = 0;
					String document_id="";

					int iDocFolderOption = 0;
					
					List<DocumentConfigBean> oDocConfigList = null;
					List<DocumentTypeBean> oDocTypeList = null;  
					DocumentConfigBean oDocumentConfigBean = null;	
					
					DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
					oDocConfigList = new ArrayList<DocumentConfigBean>();
					oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId);
					int nDocConfigListsize = oDocConfigList.size();
					if (nDocConfigListsize>0)
					{						
					oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
					sFacilityId 	= oDocumentConfigBean.getsFacilityId();
					iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
					iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();
							
					}	
					
					document_id ="doc_id1"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(iDocFolderOption));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(iDocScanEnabled));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(doc2_num));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(doc2_exp_date));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(doc2_exp_date));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(doc2_place_of_issue));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(doc2_iss_date));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(doc2_iss_date));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block448Bytes, _wl_block448);

					document_id ="doc_id2"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(doc3_num));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(doc3_exp_date));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(doc3_exp_date));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(doc3_place_of_issue));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(doc3_iss_date));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(doc3_iss_date));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block458Bytes, _wl_block458);

					document_id ="doc_id3"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(doc4_num));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(doc4_exp_date));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(doc4_exp_date));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(doc4_place_of_issue));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(doc4_iss_date));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(doc4_iss_date));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block468Bytes, _wl_block468);

					document_id ="doc_id4"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(informant));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(informant_remarks));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block491Bytes, _wl_block491);
	
						if(Othersaddlcnt==0){
            _bw.write(_wl_block492Bytes, _wl_block492);
}else{
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(general_remarks));
            _bw.write(_wl_block494Bytes, _wl_block494);
}
            _bw.write(_wl_block495Bytes, _wl_block495);

					// Code for additional fields for First Notify tab
                    order=0;
                    for(int i=0; i<cust_fields.length;i++)
                    {
                        if(cust_fields[i].charAt(0) == 'O' )
                        {
                            int intind_0	= cust_fields[i].indexOf('`');
							String strcf	= cust_fields[i];		
							String strs1	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1	= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	= strs1.substring(intind_1+1, strs1.length());
							int intind_2	= strs2.indexOf('`');
							String size		= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme		= strs3.substring(0);

							if(order == 0)
                            {
                                out.println("<tr></tr><tr></tr><tr>");
                                out.println("<td colspan=2>");
                            }
                            if( order%3 == 0 && order==0)
                            {
								
							out.println("</tr><tr>") ;
							if(Othersaddlcnt==(i+1))
							{
							
                            out.println("<td class='label'   width='13%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);focusBack();' value = \"\"></td>");
							}
							else
							{
							out.println("<td class='label'   width='13%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);' value = \"\"></td>");
							}
                            }
							if( order %3 != 0 && order!=0)
							{
							if(Othersaddlcnt==(i+1))
								{
							
							out.println("<td class='label'   width='15%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);focusBack();' value = \"\"></td>");
								}
							else
								{
								
							out.println("<td class='label'   width='15%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);' value = \"\"></td>");
								}
							}

                            order++;

							
                        }
					}
					// End of the code for additional fields in First Notify Tab
                
            _bw.write(_wl_block496Bytes, _wl_block496);
//Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
try
        {
			
			sql = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN,initcap(ADDR_LINE1_PROMPT) addr_line1_prompt,initcap(ADDR_LINE2_PROMPT) addr_line2_prompt,initcap(POSTAL_CODE_PROMPT) postal_code_prompt,initcap(RES_AREA_PROMPT)area_code_prompt, initcap(RES_TOWN_PROMPT)town_code_prompt FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";
			/*Modified by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
			
						if(oth_rset!=null) oth_rset.close();
					    if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();
						
						while (oth_rset.next()){ 
								region_prompt		= oth_rset.getString("region_prompt");
								region_appl_yn		= oth_rset.getString("REGION_APPL_YN");
								/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
								addr_line1_prompt   = oth_rset.getString("addr_line1_prompt");
								addr_line2_prompt   = oth_rset.getString("addr_line2_prompt");
								postal_code_prompt  = oth_rset.getString("postal_code_prompt");
								area_code_prompt    = oth_rset.getString("area_code_prompt");/*Added by shagar for  AMRI-CRF-0388*/
								town_code_prompt    = oth_rset.getString("town_code_prompt");/*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
								/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
								
			}			if(oth_rset!=null) oth_rset.close();
					    
			 }
			 
		catch(Exception e)
        { }//Ends here
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_area_long_desc));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(nkin_area_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_region_long_desc));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(nkin_region_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_town_long_desc));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(nkin_town_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_town_long_desc));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(fton_town_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_area_long_desc));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(fton_area_long_desc));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(fton_region_long_desc));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(fton_region_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(fton_contact_relation));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(fton_contact_relation));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(emplr_town_long_desc));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(emplr_town_long_desc));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(emplr_region_long_desc));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(emplr_region_long_desc));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(emplr_area_long_desc));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(emplr_area_long_desc));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(contact3_mode));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(contact3_mode));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact3_no));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(contact3_no));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact4_mode));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(contact4_mode));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact4_no));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(contact4_no));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(contact5_mode));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(contact5_mode));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(contact5_no));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(contact5_no));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(nkin_contact_relation));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(nkin_contact_relation));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact1_oth_alt_id_type));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(contact1_oth_alt_id_type));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(rset.getString("name_dervn_logic")));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(rset.getString("name_dervn_logic_oth_lang")));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(rset.getString("NAME_DERVN_LOGIC_LONG")));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(rset.getString("NAME_DERVN_LOGIC_OTH_LANG_LONG")));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(a_patient_long_name));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf( a_patient_long_name_loc_lang));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(patient_grp));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(a_first_name));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(a_second_name));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(a_third_name));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(rset.getString("Alt_Id1_Unique_Yn")));
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(rset.getString("Alt_Id2_Unique_Yn")));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(rset.getString("Alt_Id3_Unique_Yn")));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(rset.getString("Alt_Id4_Unique_Yn")));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(rset.getString("Citizen_Nationality_Code")));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(rset.getString("default_race_code")));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(rset.getString("dfltPSG")));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(Facility));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(rset.getString("ServerDate")));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(region_appl_yn));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(addr_line1_prompt));
            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(addr_line2_prompt));
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(postal_code_prompt));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(area_code_prompt));
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(town_code_prompt));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(a_alt_id1_no));
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(a_ethnic_group_code));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(a_familyno));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(AltIdNo2));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(AltIdNo3));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(AltIdNo4));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(init_a_national_id_no));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(init_referral_id));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(init_booking_ref_no));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(init_nat_id));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(init_appt_ref_no));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id1_desc"))));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id2_desc"))));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id3_desc"))));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id4_desc"))));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(FamilyNoLink));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(create_file_at_pat_regn_yn));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(a_first_name));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(a_second_name));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(a_third_name));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(a_name_prefix));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(a_name_suffix));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(appt));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(dflt_pat_regn_blng_class));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(rset.getString("photo_file_name")));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf(dflt_alt_id1_in_emp_id_yn));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block622Bytes, _wl_block622);
 
			 
			

			if(bl_install_yn.equals("Y")) {	
				String apptrefno="";
				String bookingrefno="";
				if(refrlAappt.equals("A"))
				{
					apptrefno=refIDValue;
				}
				else 
				{
					apptrefno=appt_ref_no;
				}

				if(refrlAappt.equals("I"))
				{
					bookingrefno=refIDValue;
				}
				else 
				{
					bookingrefno=booking_ref_no;
				}				
	
			if(refrlAappt.equals("A") || appt.equals("Appt"))
		   { 
            _bw.write(_wl_block623Bytes, _wl_block623);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("MP")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("apptrefno"), weblogic.utils.StringUtils.valueOf(apptrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block624Bytes, _wl_block624);

		   }
		   else if(!booking_ref_no.equals("") || refrlAappt.equals("I"))
			{
            _bw.write(_wl_block625Bytes, _wl_block625);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("MP")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bookingrefno"), weblogic.utils.StringUtils.valueOf(bookingrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block624Bytes, _wl_block624);
}
				else
				{
            _bw.write(_wl_block626Bytes, _wl_block626);
}
			}
			else
			{
            _bw.write(_wl_block627Bytes, _wl_block627);
	} 			
	
	
            _bw.write(_wl_block628Bytes, _wl_block628);
	hash_Map2.clear();
			
			//if(rs_bl != null) rs_bl.close();
			if(oth_stmt != null) oth_stmt.close();
			if(oth_rset != null) oth_rset.close();
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			//if(stmt_bl != null) stmt_bl.close();
			if(oth_stmt != null) oth_stmt.close();

		/*stmt = con.prepareStatement("SELECT relationship_code, INITCAP(short_desc) short_desc FROM mp_relationship_lang_vw WHERE relationship_code = '"+org_member_relationship_code+"' and language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2");

			rset = stmt.executeQuery();	
			

			if(rset!=null && rset.next())
			{
				org_member_relationship_desc = rset.getString("short_desc");
			}*/

			
			
			
			if(stmt!=null)
				stmt.close();
			if(rset!=null)
				rset.close();			
						
		}
        catch(Exception e)
		{
			e.printStackTrace();
		}
        finally
	    {
			ConnectionManager.returnConnection(con,request);
        }
		if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC")) 
		{
			
			
            _bw.write(_wl_block629Bytes, _wl_block629);

		}
		
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(fileTypeSiteSpec));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(alterAddressApplicable));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(finDtlsChkNationality));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(aliasnameNationalityRace));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(resiAddMailAdd));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(isVirtualConsultation));
            _bw.write(_wl_block636Bytes, _wl_block636);
            _bw.write(_wl_block637Bytes, _wl_block637);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
