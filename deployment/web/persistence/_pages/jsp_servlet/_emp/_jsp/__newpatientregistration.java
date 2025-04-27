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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
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
        if (sci.isResourceStale("/emp/jsp/NewPatientRegistration.jsp", 1742477754530L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n<!-- Last Modified Date Time : 11/5/2005 12:38 PM    -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- End Of Common Include -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n<head> \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block10_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block10_2Bytes = _getBytes( _wl_block10_2 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/ValidateControl.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eMP/js/SmartCard.js\"></Script>\n\t<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->\n\t<Script language=\"JavaScript\" src=\"../../eMP/js/EmployeePrivilege.js\"></Script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\n\t\t\n\t<Script src=\"../../eMP/js/json02.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/dchk.js\" ></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration4.js\'></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eBL/js/BLClearBean.js\"></script>\n\t<script Language=\"javascript\" src=\"../../eCommon/js/ScanDocument.js\"></script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n<Script src=\'../../eXH/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n <!--Added by Rameswar on  15-03-2016 for MMS-DM-CRF-0035-->\n</head>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<script>\n\t\tclearBeanForBilling();\n\t</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script> \n\t\t\t if(parent.parent.frames[0].document.forms[0].home)\n\t\t\t\t parent.parent.frames[0].document.forms[0].home.disabled = true;\n\t\t\t if(parent.parent.frames[0].document.forms[0].query)\n\t\t\t\t parent.parent.frames[0].document.forms[0].query.disabled = true;\n\t\t\t if(parent.parent.frames[0].document.forms[0].create)\n\t\t\t\t parent.parent.frames[0].document.forms[0].create.disabled = true;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->\n    <body onSelect=\"codeArrestThruSelect()\" onload=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="telephone();";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="displayScanner();chkNatlIdMandatory(\"onload\");\' onKeyPress=\'return ChkKey(event);\'OnMouseDown=\"CodeArrest()\"  onKeyDown=\'lockKey()\'>\n\t\t<form name=\'PatRegForm\' id=\'PatRegForm\' method=\'post\'   action=\'../../servlet/eMP.PatientRegistrationServlet\' target=\'messageFrame\'>\n\t\t<input type=hidden name=\'ccount\' id=\'ccount\' value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t<input type=\'hidden\' name=\'patient_grp\' id=\'patient_grp\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t    <!-- <a name=\'demo\'></a> -->\n\t\t\t<div id = \'demo\' name=\'demo\'>\n\t\t\t<input type=\'hidden\' name=\'r_postal_code\' id=\'r_postal_code\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\'> <!-- added by mujafar for ML-MMOH-CRF-0601 -->\n\t\t\t<input type=\'hidden\' name=\'m_postal_code\' id=\'m_postal_code\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'next_postal_code\' id=\'next_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'first_postal_code\' id=\'first_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'employ_postal_code\' id=\'employ_postal_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_town\' id=\'m_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\'>\n\t\t\t<input type=\'hidden\' name=\'n_town\' id=\'n_town\'>\n\t\t\t<input type=\'hidden\' name=\'f_town\' id=\'f_town\'>\n\t\t\t<input type=\'hidden\' name=\'e_town\' id=\'e_town\'>\n\t\t\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_area\' id=\'m_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_area\' id=\'n_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_area\' id=\'f_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_area\' id=\'e_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'m_region\' id=\'m_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_region\' id=\'n_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'f_region\' id=\'f_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'e_region\' id=\'e_region\' value=\'\'>\n\t\t\t<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<input type=\'hidden\' name=\'nkma_town\' id=\'nkma_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact1_region\' id=\'contact1_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'nkma_area\' id=\'nkma_area\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'n_ma_postal_code\' id=\'n_ma_postal_code\' value=\'\'>\n\n\t\t\t<input type=\'hidden\' name=\'contact2_res_town\' id=\'contact2_res_town\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_region\' id=\'contact2_region\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contact2_res_area\' id=\'contact2_res_area\' value=\'\'>\t\t\n\t\t\t<input type=\'hidden\' name=\'fst_no_ma_pos_cod\' id=\'fst_no_ma_pos_cod\' value=\'\'>\n\t\t\t<!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<input type=\'hidden\' name=\'accept_national_id_no\' id=\'accept_national_id_no\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_oth_pat_ser_yn\' id=\'alt_id1_accept_oth_pat_ser_yn\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric_yn\' id=\'alt_id1_accept_alphanumeric_yn\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<!--added by mujafar for ML-MMOH-CRF-524.1 start -->\n\t\t\t<input type=\'hidden\' name=\'alt_id1_alphanum_validate_yn\' id=\'alt_id1_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id2_alphanum_validate_yn\' id=\'alt_id2_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id3_alphanum_validate_yn\' id=\'alt_id3_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type=\'hidden\' name=\'alt_id4_alphanum_validate_yn\' id=\'alt_id4_alphanum_validate_yn\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<!--added by mujafar for ML-MMOH-CRF-524.1 end -->\n\n\t\t\t<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start -->\n\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_oth_pat_ser_yn\" id=\"alt_id2_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n\t\t\t<input type=\"hidden\" name=\"alt_id2_accept_alphanumeric_yn\" id=\"alt_id2_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" /> \n\n\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_oth_pat_ser_yn\" id=\"alt_id3_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"alt_id3_accept_alphanumeric_yn\" id=\"alt_id3_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" /> \n\n\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_oth_pat_ser_yn\" id=\"alt_id4_accept_oth_pat_ser_yn\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" /> \n\t\t\t<input type=\"hidden\" name=\"alt_id4_accept_alphanumeric_yn\" id=\"alt_id4_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" />\n\t\t\t<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End -->\n\t\t\t\n\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->\n\t        <input type=\'hidden\' name=\'a_area\' id=\'a_area\' value=\"\">\n\t        <input type=\'hidden\' name=\'a_region\' id=\'a_region\' value=\"\">\n\t        <input type=\'hidden\' name=\'a_town\' id=\'a_town\' value=\"\">\n\t        <!--End this ML-MMOH-CRF-0860.2 -->\n\n\n\t\t    <input type=\'hidden\' name=\'max_patient_age\' id=\'max_patient_age\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'pat_cato_reqd_yn\' id=\'pat_cato_reqd_yn\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></input>  <!-- //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522 -->\n\t\t\t<input type =\'hidden\' name=\'org_member_relationship_code\' id=\'org_member_relationship_code\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'org_member_relationship_desc\' id=\'org_member_relationship_desc\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'pat_no_gen_yn\' id=\'pat_no_gen_yn\' value=\"\"></input>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" \n\n\t\t\t<!-- Added by Ashwin K for AAKH-CRF-0150-->\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<!-- Ended by Ashwin K for AAKH-CRF-0150-->\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" \n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" \n\t\t\t<tr></tr>\n\t\t\t ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" maxlength=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" size=\'20\' value=\'\'  onblur=\'makeValidString(this);if(\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" == \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\") { document.forms[0].pat_ser_grp_code.focus();}\'></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" size=\'20\' value=\'\' onblur=\'makeValidString(this);if(\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\") { document.forms[0].pat_ser_grp_code.focus();}\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t \n                 </table>\n\t\t\t</div>\t\t\t\t\n\t\t\t<!-- <a name=\'addr\'></a> -->\n\t\t\t<div id = \'addr\' style = \'display:none\'>\n            <table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n                <tr>\n                    <td  class=\'BODYCOLORFILLED\' width=\'1%\'></td>\n                    <td width=\'99%\'  class=\'BODYCOLORFILLED\' valign=\'top\' colspan=\'6\'>\n                    <table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' height=\'100%\' width=\'99.5%\'>\n\t\t\t\t\t        <!--Below line added for this CRF ML-MMOH-CRF-0860.2 -->\n                        <tr>\n                            <td class=\'COLUMNHEADER\'  ></td>\n                            <td  class=\'COLUMNHEADER\' colspan=\'2\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n                            <td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t <td  class=\'COLUMNHEADER\' colspan=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n                        </tr>\n                        ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n                                <tr><td class=\'label\'  >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" <td class=\'fields\' colspan=\'2\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--Below line added for ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n                                          <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" </td> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!--End this ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n                                    <td class=\'fields\' colspan=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t<a href=\'javascript:copyDetails(4)\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" </td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'";
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

    private final static java.lang.String  _wl_block122 ="   \n\t\t\t\t\t\t <td  class=\'label\'>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" </td>\n                         <td colspan=\'2\' class=\'fields\'><input type=\'text\' name=\'r_country_desc\' id=\'r_country_desc\' value=\"";
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

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\t<!--below legend name changed ML-MMOH-CRF-939 by Mano--> \n\t\t\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td> \n                            <td colspan=\'2\' class=\'fields\'>\n                                <input type=\'text\' name=\'r_contact_name\' id=\'r_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
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

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'fields\' colspan=\'2\'><a href=\'javascript:copyDetails(7)\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(4)\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</a></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t<!--End this CRF ML-MMOH-CRF-0860.2 --> \n\t\t\t\t\t\t<tr>\n                            <!--Added CRF ML-MMOH-CRF-0601 --> \n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="  ><b>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</b>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n                            ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n                        </tr>\n                       ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" </td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'contact3_mode\' id=\'contact3_mode\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="  onchange=\'enableContactNo(this)\'>\n\t\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="----</option>\n\t\t\t\t\t\t\t";
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

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact3_no\' id=\'contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'func1();makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</tr></tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'contact4_mode\' id=\'contact4_mode\' ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact4_no\' id=\'contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'func2();makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</tr></tr>\n\t\t\t\t\t\t<td class=\'fields\'></td>\n\t\t\t\t\t\t<td  >\n\t\t\t\t\t\t\t<select name=\'contact5_mode\' id=\'contact5_mode\' ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'contact5_no\' id=\'contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'></td>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\t       <!--Below line added for this CRF ML-MMOH-CRf-0601 -->\n\t\t\t\t\t\t\t\t\t\t<tr><td class=\'COLUMNHEADER\' ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" ><b>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</b></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n                        </table>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t  </table>\n\t\t\t</div>\n           \n\t\t    <!-- <a name=\'kin\'></a> -->\n\t\t\t<div id = \'NextOfKin\' style = \'display:none\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t\t<tr>\n\t\t\t\t<td class=\"white\">\n\t\t\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabClicked\" id = \'kin\'>\n\t\t\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"kinspan\">";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabA\" id = \'kin1\'>\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kin1span\">";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" </span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabA\" id = \'empyr\'>\n\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"empyrspan\">";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</li>\t\n\t\t\t\t\t</ul>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\'>\n            <tr>\n\t\t\t\t<td valign=top width=\'45%\'>\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' width=\'40%\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t\t\t<!--Below line modified for ML-MMOH-CRF-0887.1-->\n\t\t\t\t\t<td class=\'fields\' width=\'60%\'>";
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

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t<tr>\n\t\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t\t\t<td  class=\'fields\'>\n\t\t\t\t<input type=\'text\' name=\'rel_alias_name\' id=\'rel_alias_name\' maxlength=\'30\' size=\'20\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t<!-- Ended for ML-MMOH-CRF-1527 -->\n\t\t\t\t<tr><td  class=\'label\' >";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t <td  class=\'fields\'> <input type=\'text\' name=\'next_contact_relation_desc\' id=\'next_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(next_contact_relation,next_contact_relation_desc);}else{clearfields();}\'   ><input type=\'button\'  id=\'next_contact_relation_id\'  name=\'next_contact_relation_code_id\' value=\'?\' class=\'button\' onclick=\'searchRelationship(this,next_contact_relation_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'next_contact_relation\' id=\'next_contact_relation\' value=\"\">\t<td> \n\t\t\t\t\t\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t";
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

    private final static java.lang.String  _wl_block211 ="\t\t\t\n\t\t\t\t\t<tr><td  class=\'label\'>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</td>\n                    <td class=\'fields\' nowrap>\n\t\t\t\t\t\t<select name=\'contact1_oth_alt_id_type\' id=\'contact1_oth_alt_id_type\' onChange=\'enableOtherAltIdText(this.value)\' > \n\n\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="----</option>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t</select>\n                        <input type=\'text\' name=\'contact1_oth_alt_id_no\' id=\'contact1_oth_alt_id_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\'  DISABLED value = \"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\"></td></tr>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'contact1_birth_date\' id=\'birthdate1\' maxlength=\'10\' size=\'10\' onblur=\'makeValidString(this);gotoNext(this)\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\' ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"birthdate\"  onClick=\"document.forms[0].contact1_birth_date.select();return showCalendar(\'birthdate1\');\" >\n                    </td></tr>\t\n                <!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007 -->\n                ";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n                <tr>\n                <td class=\"label\" >";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</td>\n\t\t\t    <td class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'rel_nationality_desc\' id=\'rel_nationality_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\") {searchCountry(rel_contry_code, rel_nationality_desc);}\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" ><input type=\'button\' name=\'rel_contry_code\' id=\'rel_contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,rel_nationality_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'rel_nationality_code\' id=\'rel_nationality_code\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t    </tr>\n\t\t\t    <tr>&nbsp;</tr>\n\t\t\t    ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t<tr><td  class=\"label\" >";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'rel_race_desc\' id=\'rel_race_desc\' size=\'20\' maxlength=\'20\' onblur=\'if(this.value !=\"\") {searchRace(rel_race_code,rel_race_desc);}\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"><input type=\'button\' name=\'rel_race_desc_id\' id=\'rel_race_desc_id\' value=\'?\' class=\'button\' onclick=\'searchRace(this,rel_race_desc)\' >\n\t\t\t\t<input type=\'hidden\' name=\'rel_race_code\' id=\'rel_race_code\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t    <!-- Ended for ML-MMOH-CRF-1527 -->\n\t\t\t\t<tr><td  class=\'label\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'next_job_title\' id=\'next_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n                    </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t</table>\n\t\t\t\t</td> \n\t\t\t\t<td width=\'55%\'>\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' border=\'0\' width=\'100%\'>\n                <!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t<td><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\'  ></td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</td>\n                </tr>\n                </td>\n                ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n                <!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n                ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" \n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_country_desc\' id=\'next_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\' onblur=\'if(this.value !=\"\") {searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this);}\' tabindex=\'65\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,next_country_desc)\' tabindex=\'65\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'next_country_code\' id=\'next_country_code\' value=\'\'>\n\t\t\t\t\t</td>\n\t\t\t\t<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'nk_ma_country_desc\' id=\'nk_ma_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\' onblur=\'if(this.value !=\"\") {searchCountry(nk_ma_country_code,nk_ma_country_desc);}else{clearCountryFields(this);} \' tabindex=\'68\'><input type=\'button\' name=\'nk_ma_country_code\' id=\'nk_ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nk_ma_country_desc)\' tabindex=\'68\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'nkin_mail_country_code\' id=\'nkin_mail_country_code\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ra_contact_name\' id=\'ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" tabindex=\'66\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'ma_contact_name\' id=\'ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" tabindex=\'69\'>\n                    </td></tr>\n                 <table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t    <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(10)\'>";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<a href=\'javascript:copyDetails(8)\'>";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(9)\'>";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</a>\n\t\t\t    </td></tr></table></table>\n\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="<!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n                    <td  class=\'label\' >";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</td>\n                    <td class=\'fields\'><input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'></td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</td>\n                    <td class=\'fields\'><input type=\'text\' name=\'next_off_tel_no\' id=\'next_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n                    </td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>\n                    </td>\n                </tr>\n\t\t\t\t ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="   <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t\t</td></tr></table>\n\t\t\t<tr>\n\t\t    </table>\n\t\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'2\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t\t <td class=\'label\' width=\'20%\'><!-- <a href=\'javascript:copyDetails(5)\'>";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="</a> --></td>\n\t\t\t\t\t <td class=\'label\' width=\'55%\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(1)\'  id=\'copy_head\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="</a>&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t\t\t\t\t\t<!--Added by Shagar GDOH-CRF-0111 -->\n                     ";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t \n\t\t\t\t\t<a href=\'javascript:copyDetails(2)\'>";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="</a>\t\t\t\t\t \n\t                  ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t\t\t\t <a href=\'javascript:copyDetails(5)\'>";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="</a>&nbsp;&nbsp;&nbsp;<a href=\'javascript:copyDetails(2)\'>";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</a>\n\t\t\t\t\t \n\t\t\t\t\t \n\t\t\t\t\t </td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\t\t\t  </tr>\n\t\t\t  </table>\n\t\t\t</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 =" <!-- Added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->\n\t\t\t";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\t<table width=\"100%\"><tr>\n\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=\'7\' >";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="</td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'next_res_tel_no\' id=\'next_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'></td>\n\t\t\t\t\n                    <td  class=\'label\' >";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'contact1_mob_tel_no\' id=\'contact1_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'></td>\n\t\t\t\t\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact1_email_id\' id=\'contact1_email_id\' maxlength=\'50\' size=\'42\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\'></td>\n                    \n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'nk_contact3_mode\' id=\'nk_contact3_mode\' ";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact3_no\' id=\'nk_contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact4_mode\' id=\'nk_contact4_mode\' ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact4_no\' id=\'nk_contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'nk_contact5_mode\' id=\'nk_contact5_mode\' ";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'nk_contact5_no\' id=\'nk_contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr></table>\n\t\t\t";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t\t</table>\n\t\t\t</div>\n           <!-- Added for New tab-->\t\t \t\t\t\n\t\t<!-- <a name=\'kin1\'></a> -->\n\t\t<div id = \'FirstToNotify\' style = \'display:none\'>\n\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabA\" id=\'kin\'>\n\t\t\t\t\t<span class=\"tabAspan\" id=\"kinspan\">";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabClicked\" id=\'kin1\'>\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"kin1span\"> ";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabA\" id=\'empyr\'>\n\t\t\t\t\t<span class=\"tabAspan\" id=\"empyrspan\">";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t\t</ul>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n        <table border = 0 cellspacing=\'0\' cellpadding=\'0\' width=\'100%\'>\n\t \t<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>\n\n\t\t<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n        ";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n         <tr>\n\t\t\t\t<td class=\'bodycolorfilled\'></td>\n\t\t\t\t<td valign=top>\n\t\t\t\t\t<table cellspacing=\'1\' cellpadding=\'3\' width=\'100%\' border=\'0\'>\n                            <tr>&nbsp;</tr>\n\t\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' maxlength=\'80\' value=\"\" value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t</td>\n\t\t </tr>\n\t\t <tr>\n\t\t\t\t\t   <td class=\'label\'>";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t   <input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>\n                    ";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'text\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\"\"  maxlength=\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'   value=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="<input type=\'hidden\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\'\' >";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t\t\t\t<tr><td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' onchange=\'nenableAltID()\' >\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="---</option>\n                            ";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\n                    </select><input type=\'text\' name=\'notify_oth_alt_id_text\' id=\'notify_oth_alt_id_text\' value=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\'  maxlength=\'20\' size=\'20\' disabled onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value= \'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'>\n                    </td>\n\t\t\t\t</tr></table>\n\t\t";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n         <tr>\n\t\t\t\t<td class=\'bodycolorfilled\' width=\'15%\'></td>\n\t\t\t\t<td>\n\t\t\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=\'0\'>\n\n\t\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="</td><td class=\'fields\'><input type=\'text\' name=\'first_contact_name\' id=\'first_contact_name\' maxlength=\'80\' value=\"\" value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="</td>\n\t\t\t\t\t\t<td  class=\'filed\'><input type=\'text\' name=\'first_off_tel_no\' id=\'first_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'></td>\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!-- Below line commented ML-MMOH-CRF-0860.2-->\n\t\t\t\t\t<!--<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  id=\'first_contact_relation_id\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'><td>\n\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</td>\n\t\t\t\t\t\t<td  class=\'filed\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' \n\t\t\t\t\t\tvalue = \'\'></td>\t\t\t\t\t\t   \n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>-->\n\t\t\t\t\t<!--End ML-MMOH-CRF-0860.2-->\n\t\t\t\t\t<tr>\n\t\t\t\t\t   <td class=\'label\'>";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</td>\n\t\t\t\t\t    <td class=\'fields\'><input type=\'text\' name=\'first_contact_relation_desc\' id=\'first_contact_relation_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}\'>\n\t\t\t\t\t\t<input type=\'button\'  name=\'first_contact_relation_code_id\' id=\'first_contact_relation_code_id\' value=\'?\' \n\t\t\t\t\t\tclass=\'button\' onclick=\'searchRelationship(this,first_contact_relation_desc)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="</td>\n\t\t\t\t\t\t  <td class=\'fields\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' \n\t\t\t\t\t\tvalue = \'";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_contact_relation\' id=\'first_contact_relation\' value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'relationship_level\' id=\'relationship_level\' value=\"\">\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact2_nat_id_no\' id=\'contact2_nat_id_no\' value=\"\"  maxlength=\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t\t\t\t\t\t<td  class=\'label\' colspan=2><a href=\'javascript:copyDetails(6)\'>";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(3)\'>";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="</a> </td>\n\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n\t\t\t\t\t<tr><td  class=\'label\'>";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\'><select name=\'notify_oth_alt_id_type\' id=\'notify_oth_alt_id_type\' onchange=\'nenableAltID()\' >\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'  maxlength=\'20\' size=\'20\' disabled onblur=\'makeValidString(this);\' ></td>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\t\t\t\t<td  class=\'label\' colspan=2>";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="<a href=\'javascript:copyDetails(6)\'>";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="</a> ";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="</td>\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="</td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'first_job_title\' id=\'first_job_title\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value= \'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n                    </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t</tr>\n\t\t  \n\t\t<!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t<td width=\'55%\'><table cellspacing=\'0\' cellpadding=\'3\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n                     <td class=\'COLUMNHEADER\' ></td>\n                     <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\t\t<!--Ended by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="                \n                <tr>\n\t\t\t\t  <td  class=\'label\'>";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="</td>\n                  <td class=\'fields\'><input  type=\'text\' value=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\' name=\'first_country_desc\'  size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],first_country_desc);}else{clearCountryFields(this);}\' tabindex=\'65\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_country_desc)\' tabindex=\'65\'></td>\n\t\t\t\t  <input type=\'hidden\' name=\'first_country_code\' id=\'first_country_code\' value=\'\'>\n\t\t\t\t  <!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t\t";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\t\n\n\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'first_mail_country_desc\' id=\'first_mail_country_desc\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\' onblur=\'if(this.value !=\"\") {searchCountry(ma_country_code,first_mail_country_desc);}else{clearCountryFields(this);} \' tabindex=\'68\'><input type=\'button\' name=\'ma_country_code\' id=\'ma_country_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,first_mail_country_desc)\' tabindex=\'68\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'first_mail_country_code\' id=\'first_mail_country_code\' value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="</td> \n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ra_contact_name\' id=\'fton_ra_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" tabindex=\'66\'>\n                    </td>\n                    <td class=\'fields\'>\n                    <input type=\'text\' name=\'fton_ma_contact_name\' id=\'fton_ma_contact_name\' size=\'30\' maxlength=\'30\'  onblur=\'makeValidString(this);\' value= \"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" tabindex=\'69\'>\n                    </td>\n\t\t\t\t</tr>\n\n\t\t\t\t<table border = 0 cellspacing=\'0\' cellpadding=\'1\' width=\'100%\'>\n\t\t\t    <tr><td class=\'label\' width=\'25%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t    <a href=\'javascript:copyDetails(13)\'>";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<a href=\'javascript:copyDetails(11)\'>";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t        <a href=\'javascript:copyDetails(12)\'>";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\n\t\t\t\t\t\t<td  class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t<td  class=\'filed\'>&nbsp;</td>\t\t\t\t\t\t   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\n                 \n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t    <td  class=\'label\' >";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="</td>\n                    <td class=\'fields\'><input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t   <td  class=\'label\' >";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="</td>\n\t\t                   <td class=\'fields\'><input type=\'text\' name=\'first_off_tel_no\' id=\'first_off_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t <td  class=\'label\'>";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="</td>\n\t\t\t\t\t\t\t <td class=\'fields\'><input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\'></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\'fields\' ><a href=\'javascript:copyDetails(6)\'>";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<a href=\'javascript:copyDetails(3)\'>";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n                    ";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\t\n\t\t\t\t<!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->\n\t\t\t";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="</td>\n                </tr>\n\t\t\t\t<tr>\n\t\t\t\t    <td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n                    <input type=\'text\' name=\'first_res_tel_no\' id=\'first_res_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\'></td>\n\t\t\t\t    \n\t\t\t\t\t\t\n\t\t\t\t    <td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact2_mob_tel_no\' id=\'contact2_mob_tel_no\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);return isValidCharacter(this);\' onKeyPress=\'return SpecialCharsChk(event);\' value = \'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\'></td>\n\t\t\t\t    \n\n\t\t\t\t    <td  class=\'label\' nowrap >";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'contact2_email_id\' id=\'contact2_email_id\' maxlength=\'50\' size=\'45\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select name=\'fton_contact3_mode\' id=\'fton_contact3_mode\' ";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact3_no\' id=\'fton_contact3_no\' maxlength=\'20\' size=\'13\'   disabled onChange=\'makeValidString(this);\' value=\'\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact4_mode\' id=\'fton_contact4_mode\' ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact4_no\' id=\'fton_contact4_no\' maxlength=\'20\' size=\'13\'  disabled onchange=\'makeValidString(this);\' value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'fields\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name=\'fton_contact5_mode\' id=\'fton_contact5_mode\' ";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\n\t\t\t\t\t\t\t</select><input type=\'text\' name=\'fton_contact5_no\' id=\'fton_contact5_no\' maxlength=\'20\' size=\'13\'  disabled onblur=\'makeValidString(this);\'value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr></table>\n\t\t\t";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\n\t\t\t\t</table>\n\t\t\t\t<td class=\'bodycolorfilled\' width=\'15%\'></td>\n\t\t\t</tr>\n\t\t\t</table> \n\t\t\t</div>\n\t\t\t\n            <!-- <a name=\'empyr\'></a> -->\n\t\t\t<div id = \'EmplyrDtls\' style = \'display:none\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t\t\t<tr>\n\t\t\t<td width= \"100%\" class=\"white\">\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'kin\')\" class=\"tabA\" id=\'kin\'>\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kinspan\">";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'kin1\')\" class=\"tabA\" id=\'kin1\'>\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"kin1span\"> ";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t\t\t<a onclick=\"invokeTab(\'empyr\')\" class=\"tabClicked\" id=\'empyr\'>\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"empyrspan\">";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t</ul>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n        <table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t<tr>\n                <td align=\'center\' class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="</td>\n\t\t\t\t<td align=\'center\' class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="</td>\n        </tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t\t<!--Below line modified for this CRF ML-MMOH-CRF-0860.2 increase the maxlength 30 to 50-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="</td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'organization_name\' id=\'organization_name\' maxlength=\'";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\'   onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\" ></input>\n                    </td>\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t <td class=\'label\' >";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="</td>\n                  <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_contact_name\' id=\'empyr_contact_name\' maxlength=\'30\' size=\'30\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\"></input>\n                    </td>\n\t\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="              \n                <tr>\n                    <td  class=\'label\'>";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 =" </td>\n                    <td class=\'fields\'><input type=\'text\' name=\'empyr_country_desc\' id=\'empyr_country_desc\'                       size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\' onblur=\'if(this.value !=\"\"){searchCountry(contry_code[0],empyr_country_desc);}else {clearCountryFields(this);} \' ><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,empyr_country_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'empyr_country_code\' id=\'empyr_country_code\' value=\'\'>\n                   </td>\n               </tr>\n               <tr>\n                   <td  class=\'label\'>";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</td>\n                   <td >\n                       <input type=\'text\' name=\'res3_tel_no\' id=\'res3_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\">\n                   </td>\n                </tr>\n\t\t\t\t<tr>\n                   <td  class=\'label\'>";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="</td>\n                   <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_off_tel_no\' id=\'empyr_off_tel_no\' size=\'20\' maxlength=\'20\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n                   </td>\n               </tr>\n\t\t\t   </table>\n\t\t\t</td>\n\t\t\t<td valign=top>\n\t\t\t<table cellspacing=\'1\' cellpadding=\'2\' width=\'100%\' border=0>\n\t\t\t   <tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="</td>\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'empyr_eid\' id=\'empyr_eid\' maxlength=\'20\' size=\'20\'  onfocus=\'\' onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\"></input>\n                    </td>\n\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 =" \n\t\t\t\t\t\t<SCRIPT>document.forms[0].empyr_eid.value = \'";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\';\n\t\t\t\t\t\tdocument.forms[0].empyr_eid.readOnly = true;</script>\n\t\t\t\t";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="</td>\n\t\t\t\t\n\n\t\t\t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'occ_class_desc\' id=\'occ_class_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchOccupationClass(occ_class,occ_class_desc);sendToServer(15,occ_class);}else{clearfields();clearOccPer(document.forms[0].occ_of_per);} enableocpn_class();\'    ><input type=\'button\'  name=\'occ_class_code_id2\' id=\'occ_class_code_id2\' value=\'?\' class=\'button\' onclick=\'searchOccupationClass(this,occ_class_desc);if(document.forms[0].occ_class.value!=\"\"){sendToServer(15,occ_class);}\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'occ_class\' id=\'occ_class\' value=\"\"> </td>\n\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="</td>\n                    <td class=\'fields\'>\n                        <select name=\'occ_of_per\' id=\'occ_of_per\'  onChange=\'enableocpn();\'>\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="---</option>\n                        </select>\n\t\t\t\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0860.2 increase the maxLength from 30 to 50-->\n                        <input type=\'text\' name=\'occu_of_per_desc\' id=\'occu_of_per_desc\' size=\'";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\' maxlength=\'";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\' onblur=\'\'  onblur=\'makeValidString(this);\' value = \"\"></input>\n                    </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="</td>\n                    <td class=\'fields\'>\n                        <select name=\'empyr_employment_status\' id=\'empyr_employment_status\'  onblur=\"document.forms[0].organization_name.focus()\" onchange=\'\'>\n                            <option value=\'\'>---";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="---</option>\n                            <option value=\'FE\'>";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'FS\'>";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'NA\'>";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="</option>\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'PE\'>";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'PS\'>";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'SE\'>";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'UE\'>";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'UK\'>";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="</option>\n                        </select>\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t</table>\n\t\t\t</table>\n\t\t\t</div>             \n            <!-- <a name=\'pat_docs_tab\'></a> -->\n\t\t\t<div id = \'pat_docs_tab\' style = \'display:none\'>\n            <table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\'>\n                <tr>\n                    <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="</td>\n                    <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="</td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="</td>\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n                </tr>\n\n                ";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\n\n                <tr>\n                  \t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id1_desc\' id=\'doc_id1_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id1,doc_id1_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\'  name=\'doc_code_id1\' id=\'doc_code_id1\' value=\'?\' class=\'button\' onclick=\'searchDocumentType(this,doc_id1_desc); enbl_disble(doc_id1_desc);\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id1\' id=\'doc_id1\' value=\"\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n                    \n                    <td class=\'fields\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_num1\' id=\'doc_num1\'  size=15 maxlength=15  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_num1\' id=\'doc_num1\' value=\"\" size=15 maxlength=15  onblur=\'makeValidString(this);\' disabled value =\'\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t\t\t\t<img id=\'doc1\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt1\' id=\'doc_exp_dt1\' id=\"docexpdt1\" size=10 maxlength=10  onblur = \'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt1\' id=\'doc_exp_dt1\' size=10 maxlength=10  onblur = \'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\");return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value =\'";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate1\" disabled onClick=\"document.forms[0].doc_exp_dt1.select();return showCalendar(\'doc_exp_dt1\');\" >\n                    </td>\t\t\t\t\t\t\t\t\t\t\t  \n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue1\' id=\'place_of_issue1\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\">\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date1\' id=\'issue_date1\' id=\"issuedate1\" value=\'";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\' size=10 maxlength=10  onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value=\'\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date1\' id=\"issue_date1\" value=\'";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\' size=10 maxlength=10  onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\");return ChkForIssueDate(this,document.forms[0].issue_date1);\' disabled  onblur=\'makeValidString(this);\' value=\'\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt1\" disabled onClick=\"document.forms[0].issue_date1.select();return showCalendar(\'issue_date1\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t \t<td class=\'fields\'><div id=\'doc1imageId\'> <input type=\'file\' name=\'doc1image\' id=\'doc1image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t<!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\t\n\t\t\t\t\t\n\t\t\t\t\t<input type=\'button\' name=\'doc1scan\' id=\'doc1scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\',\'MP\',\'";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\',this);\" style=\'visibility:hidden\'> \n\t\t\t\t\t </div></td></td>\n\t\t\t\t\t <input type=\'hidden\' name=\'iDocFolderOption\' id=\'iDocFolderOption\' value=\"";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'iDocScanEnabled\' id=\'iDocScanEnabled\' value=\"";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\">\n\t\t\t\t\t <input type=\'hidden\' name=\'document_id1\' id=\'document_id1\' value=\"";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\">\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id2_desc & doc2_code_id2 -->\n         \t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id2_desc\' id=\'doc_id2_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id2,doc_id2_desc);}else{clearfields();} enbl_disble(this);\'    ><input type=\'button\' name=\'doc2_code_id2\' id=\'doc2_code_id2\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id2_desc); enbl_disble(doc_id2_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id2\' id=\'doc_id2\' value=\"\">\n\n\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num2\' id=\'doc_num2\' size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\'>\n\t\t\t\t\t\t<img id=\'doc2\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt2\' id=\'doc_exp_dt2\' id = \"docexpdt2\" size=10 maxlength=10 disabled onblur = \'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt2\' id = \"doc_exp_dt2\" size=10 maxlength=10 disabled onblur = \'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\");return ChkForIssueDate(this,document.forms[0].issue_date2);\'  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate2\" disabled onClick=\"document.forms[0].doc_exp_dt2.select();return showCalendar(\'doc_exp_dt2\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue2\' id=\'place_of_issue2\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\'";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\'>\n                    </td>\n                    <td>\n                        <!--<input type=\'text\' name=\'issue_date2\' id=\'issue_date2\' id=\"issuedate2\" value=\"";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)\'  onblur=\'makeValidString(this);\' value=\'\'> --><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date2\' id=\"issue_date2\" value=\"";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\");return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)\'  onblur=\'makeValidString(this);\' value=\'\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt2\" disabled onClick=\"document.forms[0].issue_date2.select();return showCalendar(\'issue_date2\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'> <div id=\'doc2imageId\'><input type=\'file\' name=\'doc2image\' id=\'doc2image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\n\t\t\t\t\t\n\t\t\t\t\t <input type=\'button\' name=\'doc2scan\' id=\'doc2scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id2\' id=\'document_id2\' value=\'";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id3_desc & doc3_code_id3 -->\n                 \t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id3_desc\' id=\'doc_id3_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id3,doc_id3_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\' name=\'doc3_code_id3\' id=\'doc3_code_id3\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id3_desc); enbl_disble(doc_id3_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id3\' id=\'doc_id3\' value=\"\">\n\n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num3\' id=\'doc_num3\' size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\">\n\t\t\t\t\t\t<img id=\'doc3\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt3\' id=\'doc_exp_dt3\' id=\"docexpdt3\" size=10 maxlength=10 disabled  onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt3\' id=\"doc_exp_dt3\" size=10 maxlength=10 disabled  onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\");return ChkForIssueDate(this,document.forms[0].issue_date3);\'  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate3\" disabled onClick=\"document.forms[0].doc_exp_dt3.select();return showCalendar(\'doc_exp_dt3\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue3\' id=\'place_of_issue3\' size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' value=\"";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date3\' id=\'issue_date3\' id=\"issuedate3\" value=\"";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)\'  onblur=\'makeValidString(this);\' value = \"\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date3\' id=\"issue_date3\" value=\"";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\");return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)\'  onblur=\'makeValidString(this);\' value = \"\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt3\" disabled onClick=\"document.forms[0].issue_date3.select();return showCalendar(\'issuedate3\');\" >\n                    </td>\n\t\t\t\t\t  <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'><div id=\'doc3imageId\'> <input type=\'file\' name=\'doc3image\' id=\'doc3image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\n\t\t\t\t\t \n\t\t\t\t\t <input type=\'button\' name=\'doc3scan\' id=\'doc3scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id3\' id=\'document_id3\' value=\'";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n                </tr>\n                \n                <tr>\n\t\t\t\t\t<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added \'disabled\' for doc_id4_desc & doc4_code_id4 -->\n           \t\t\t<td  class=\'fields\'> <input type=\'text\' name=\'doc_id4_desc\' id=\'doc_id4_desc\' size=\'20\' maxlength=\'20\' value=\"\" disabled onblur=\'if(this.value!=\"\"){searchDocumentType(doc_id4,doc_id4_desc);}else{clearfields();} enbl_disble(this);\'   ><input type=\'button\' name=\'doc4_code_id4\' id=\'doc4_code_id4\' value=\'?\' disabled class=\'button\' onclick=\'searchDocumentType(this,doc_id4_desc); enbl_disble(doc_id4_desc);\'  >\n\t\t\t\t\t<input type=\'hidden\' name=\'doc_id4\' id=\'doc_id4\' value=\"\">\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'doc_num4\' id=\'doc_num4\' value=\"";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\" size=15 maxlength=15 disabled  onblur=\'makeValidString(this);\'>\n\t\t\t\t\t\t<img id=\'doc4\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'doc_exp_dt4\' id=\'doc_exp_dt4\' id=\"docexpdt4\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'doc_exp_dt4\'  id=\"doc_exp_dt4\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\");return ChkForIssueDate(this,document.forms[0].issue_date4);\'  onblur=\'makeValidString(this);\' value = \"";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"docexpdate4\" disabled onClick=\"document.forms[0].doc_exp_dt4.select();return showCalendar(\'doc_exp_dt4\');\" >\n                    </td>\n                    \n                    <td class=\'fields\'>\n                        <input type=\'text\' name=\'place_of_issue4\' id=\'place_of_issue4\' value=\"";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\" size=30 maxlength=30 disabled  onblur=\'makeValidString(this);\' >\n                    </td>\n                    <td class=\'fields\'>\n                        <!--<input type=\'text\' name=\'issue_date4\' id=\'issue_date4\' id=\"issuedate4\" value=\"";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\" size=10 maxlength=10 disabled onblur=\'validDateObj(this,\"DMY\",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)\'  onblur=\'makeValidString(this);\'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->\n\t\t\t\t\t\t<input type=\'text\' name=\'issue_date4\' id=\"issue_date4\" value=\"";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\");return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)\'  onblur=\'makeValidString(this);\'><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"issuedt4\" disabled onClick=\"document.forms[0].issue_date4.select();return showCalendar(\'issuedate4\');\" >\n                    </td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t\t<td class=\'fields\'><div id=\'doc4imageId\'> <input type=\'file\' name=\'doc4image\' id=\'doc4image\' disabled  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->\n\t\t\t\t\t<!--   end PMG2012-CRF-0006 [IN034693]   -->\n\t\t\t\t\t <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\n\t\t\t\t\t \n\t\t\t\t\t <input type=\'button\' name=\'doc4scan\' id=\'doc4scan\'  value=\'Scan\' disabled  size=4  onClick=\"ShowScanner(\'";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\',this);\" style=\'visibility:hidden\'>\n\t\t\t\t\t  </div></td>\n\t\t\t\t\t   <input type=\'hidden\' name=\'document_id4\' id=\'document_id4\' value=\'";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\'>\n\t\t\t\t\t  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->\n\t\t\t\t\t\n                </tr>\n            </table>\n\t\t\t<br>\n\n\t\t\t\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\'>\n                <tr>\n                    <td  class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="</td>\n                </tr>\n                <tr>\n                    <td  class=\'label\' >";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="</td>\n\n                    <td  class=\'fields\' colspan=\'3\'>\n                        <select name=\'living_dependency\' id=\'living_dependency\'>\n                            <option value=\'UN\'>";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="</option>\n                            <option value=\'D\'>";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="</option>\n                            <option value=\'M\'>";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="</option>\n                            <option value=\'S\'>";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="</option>\n                            <option value=\'WU\'>";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="</option>\n                        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n\t\t\t   </tr>\n                <tr>\n                    <td  class=\'label\' >";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="</td>\n                    <td class=\'fields\' colspan=\'3\'>\n                        <select name=\'living_arrangement\' id=\'living_arrangement\' >\n                            <option value=\'U\'>";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 =" </option>\n                            <option value=\'A\'>";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="</option>\n                            <option value=\'F\'>";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="</option>\n                            <option value=\'R\'>";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 =" </option>\n                            <option value=\'S\'>";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 =" </option>\n                        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\n                </tr>\n                \n                <tr>\n                    <td class=\'label\' >";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="</td>\n             \t\t<td  class=\'fields\'> <input type=\'text\' name=\'education_level_desc\' id=\'education_level_desc\' size=\'20\' maxlength=\'20\' value=\"\" onblur=\'if(this.value!=\"\"){searchEducation(education_level,education_level_desc);}else{clearfields();}\'   ><input type=\'button\' name=\'education_level_id1\' id=\'education_level_id1\' value=\'?\' class=\'button\' onclick=\'searchEducation(this,education_level_desc)\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'education_level\' id=\'education_level\' value=\"\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\n                </tr>\n                \n                <tr><td  class=\'bodycolorfilled\' colspan=5></td></tr>\n                <tr><td  class=\'COLUMNHEADER\' colspan=5>";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="</td></tr>\n                <tr>\n                    <td  width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="</td>\n                    <td  width=\'75%\' colspan=\'4\' class=\'fields\'>\n                        <input type=\'text\' name=\'regn_informant\' id=\'regn_informant\' maxlength=\'20\' size=\'20\'  onblur=\'makeValidString(this);\' value = \'";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\'></td>\n                </tr>\n\n                <tr>\n                    <td  width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="</td>\n                    <td  class=\'fields\' colspan=3>\n                        <font name=\'verdana\'><textarea name=\'regn_comments\' rows=\'2\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,100)\' onBlur=\'makeValidString(this);checkLength(this,100)\'  value=\'";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\'></textarea></font>\n                    </td>\n                </tr>\n\n                <tr><td  class=\'bodycolorfilled\' colspan=5></td></tr>\n                <tr><td  class=\'COLUMNHEADER\' colspan=5 >";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="</td></tr>\n               \n                <tr>\n                    <td width=\'25%\' class=\'label\' ></td>\n                    <td width=\'75%\' class=\'fields\' colspan=3>\n\t\t\t\t\t";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="    \n\t\t\t\t\t\t\t<textarea name=\'general_remarks\' rows=\'5\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,500)\' onblur=\'makeValidStringRemark(this);checkLength(this,500);\'></textarea>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\n\t\t\t\t\t\t\t<textarea name=\'general_remarks\' rows=\'5\' cols=\'45\'  onKeyPress=\'checkMaxLimit(this,500)\' onblur=\'makeValidStringRemark(this);checkLength(this,500);\'>";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="</textarea>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\n                    </td>\n                </tr>\n            </table>\n\t\t\t</table>\n\t\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'>\n                   ";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\n                </tr>\n            </table> \t\t\t\n";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\t\t\t\n\t\t\t<script>\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\" != \'\' && document.getElementById(\'next_addr_line1\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_addr_line1\').value=\"";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\"; \n\t\t\t\tif(\"";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\" != \'\' && document.getElementById(\'next_addr_line2\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_addr_line2\').value=\"";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" != \'\' && document.getElementById(\'next_addr_line3\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_addr_line3\').value=\"";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" != \'\' && document.getElementById(\'next_addr_line4\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_addr_line4\').value=\"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\" != \'\' && document.getElementById(\'contact1_res_area_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact1_res_area_code\').value=\"";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\" != \'\' && document.getElementById(\'contact1_region_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact1_region_code\').value=\"";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\" != \'\' && document.getElementById(\'next_postal_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_postal_code\').value=\"";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\" != \'\' && document.getElementById(\'contact1_res_town_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact1_res_town_code\').value=\"";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\" != \'\' && document.getElementById(\'fton_addr_line1\') != null)\n\t\t\t\t\tdocument.getElementById(\'fton_addr_line1\').value=\"";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" != \'\' && document.getElementById(\'fton_addr_line2\') != null)\n\t\t\t\t\tdocument.getElementById(\'fton_addr_line2\').value=\"";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\" != \'\' && document.getElementById(\'fton_addr_line3\') != null)\n\t\t\t\t\tdocument.getElementById(\'fton_addr_line3\').value=\"";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\" != \'\' && document.getElementById(\'fton_addr_line4\') != null)\n\t\t\t\t\tdocument.getElementById(\'fton_addr_line4\').value=\"";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\" != \'\' && document.getElementById(\'contact2_res_town_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact2_res_town_code\').value=\"";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\" != \'\' && document.getElementById(\'contact2_res_area_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact2_res_area_code\').value=\"";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" \n\t\t\t\tif(\"";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\" != \'\' && document.getElementById(\'contact2_region_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact2_region_code\').value=\"";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\" != \'\' && document.getElementById(\'first_postal_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'first_postal_code\').value=\"";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" != \'\' && document.getElementById(\'first_contact_relation\') != null)\n\t\t\t\t\tdocument.getElementById(\'first_contact_relation\').value=\"";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\" != \'\' && document.getElementById(\'employ_addr_line1\') != null)\n\t\t\t\t\tdocument.getElementById(\'employ_addr_line1\').value=\"";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" != \'\' && document.getElementById(\'employ_addr_line2\') != null)\n\t\t\t\t\tdocument.getElementById(\'employ_addr_line2\').value=\"";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" != \'\' && document.getElementById(\'employ_addr_line3\') != null)\n\t\t\t\t\tdocument.getElementById(\'employ_addr_line3\').value=\"";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\" != \'\' && document.getElementById(\'employ_addr_line4\') != null)\n\t\t\t\t\tdocument.getElementById(\'employ_addr_line4\').value=\"";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" != \'\' && document.getElementById(\'contact2_res_town_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact3_res_town_code\').value=\"";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\";\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" != \'\' && document.getElementById(\'contact3_region_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact3_region_code\').value=\"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\" != \'\' && document.getElementById(\'contact3_res_area_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact3_res_area_code\').value=\"";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" != \'\' && document.getElementById(\'employ_postal_code\') != null)\n\t\t\t\t\tdocument.getElementById(\'employ_postal_code\').value=\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\";\n\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\" != \'\' && document.getElementById(\'contact3_mode\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact3_mode\').value=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\" != \'\' && document.getElementById(\'contact3_no\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact3_no\').value=\"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" != \'\' && document.getElementById(\'contact4_mode\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact4_mode\').value=\"";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\" != \'\' && document.getElementById(\'contact4_no\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact4_no\').value=\"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\"\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" != \'\' && document.getElementById(\'contact5_mode\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact5_mode\').value=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" != \'\' && document.getElementById(\'contact5_no\') != null)\n\t\t\t\t\tdocument.getElementById(\'contact5_no\').value=\"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\" != \'\' && document.getElementById(\'next_contact_relation\') != null)\n\t\t\t\t\tdocument.getElementById(\'next_contact_relation\').value=\"";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\" !=\'\' && document.getElementById(\"contact1_oth_alt_id_type\") != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"contact1_oth_alt_id_type\").value = \"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\";\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t\n\n\t\t <!-- The below hidden fields should always be before the code which is the below script -->\n\t\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang\' id=\'name_drvn_logic_oth_lang\' value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_long\' id=\'name_drvn_logic_long\' value=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic_oth_lang_long\' id=\'name_drvn_logic_oth_lang_long\' value=\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\"\"></input>\n            <input type=\'hidden\' name=\'patient_name_loc_lang\' id=\'patient_name_loc_lang\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_group\' id=\'patient_group\' value=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'nat_series_loaded\' id=\'nat_series_loaded\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'First_Name\' id=\'First_Name\' value=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Second_Name\' id=\'Second_Name\' value=\"";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Third_Name\' id=\'Third_Name\' value=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Family_Name\' id=\'Family_Name\' value=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patientName\' id=\'patientName\' value=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'patientNameLocLang\' id=\'patientNameLocLang\' value=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\"></input>\n            <input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\'S\'></input>\n            <input type=\'hidden\' name=\'pass_val\' id=\'pass_val\' value=\'N\'></input>\n            <input type=\'hidden\' name=\'error_alt_no1\' id=\'error_alt_no1\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no2\' id=\'error_alt_no2\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no3\' id=\'error_alt_no3\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_alt_no4\' id=\'error_alt_no4\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"\"></input>\n            <input type=\'hidden\' name=\'error_expiry_date\' id=\'error_expiry_date\' value=\"\"></input>\n            <input type=\'hidden\' name=\'Alt_Id1_Unique_Yn1\' id=\'Alt_Id1_Unique_Yn1\' value=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\"></input>\n            <input type=\'hidden\' name=\'Alt_Id2_Unique_Yn2\' id=\'Alt_Id2_Unique_Yn2\' value=\"";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\"></input>\n            <input type=\'hidden\' name=\'Alt_Id3_Unique_Yn3\' id=\'Alt_Id3_Unique_Yn3\' value=\"";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\"\'></input>\n            <input type=\'hidden\' name=\'Alt_Id4_Unique_Yn4\' id=\'Alt_Id4_Unique_Yn4\' value=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'default_race_code\' id=\'default_race_code\' value=\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_pat_ser_grp_code\' id=\'dflt_pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\"></input>\n            <input type=\'hidden\' name=\'dflt_pref_facility_id\' id=\'dflt_pref_facility_id\' value=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\"></input>\n            <input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'\'></input>\n\t\t\t<input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\"";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\"></input>\n            <input type=\'hidden\' name=\'town_desc\' id=\'town_desc\' value=\"\"></input>\n            <input type=\'hidden\' name=\'appt_ref_no\' id=\'appt_ref_no\' value=\"";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\"></input>\n            <input type=\'hidden\' name=\'booking_ref_no\' id=\'booking_ref_no\' value=\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\"></input>\n            <input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\'></input>\n           \t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'refrlAappt\' id=\'refrlAappt\' value=\'\'></input>\n\t\t\t<input type =\'hidden\' name=\'refIDValue\' id=\'refIDValue\' value=\'\'></input>\n\t\t\t<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->\n\t\t\t<input type=\'hidden\' name=\'region_prompt1\' id=\'region_prompt1\' value=\"";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'region_appl_yn1\' id=\'region_appl_yn1\' value=\"";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\"></input>\n\n\t\t\t<!--Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324-->\n\t\t\t<input type=\'hidden\' name=\'addr_line1_prompt\' id=\'addr_line1_prompt\' value=\"";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'addr_line2_prompt\' id=\'addr_line2_prompt\' value=\"";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'postal_code_prompt\' id=\'postal_code_prompt\' value=\"";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'area_code_prompt\' id=\'area_code_prompt\' value=\"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\"></input><!--Added by shagar on 21-10-2016 for  AMRI-CRF-0388-->\n\t\t\t<input type=\'hidden\' name=\'town_code_prompt\' id=\'town_code_prompt\' value=\"";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\"></input><!-- Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522 -->\n\t\t\t\n\t\t\t\n            <!-- The above hidden fields should always be before the code which is the below script -->\n\t\t\t\n\t\t\t<!-- The below code in the below script should be fallowed by the above hidden fields -->\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\' != \'\') {\n\t\t\t\t\t\n\t\t\t\t\t//document.forms[0].national_id_no.focus();\n\t\t\t\t\tdispMandatoryImage(\'N\');\n\t\t\t\t} else FocusFirstElement()\n\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\' != \'\') {\n\t\t\t\t\tdispMandatoryImage(\'A\');\n\t\t\t\t}\n\n                if(\'";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\' != \'\' && \'";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\' == \'\') {\n\t\t\t\t\tgotoNext(document.forms[0].date_of_birth);\n\t\t\t\t}\n\n            \tif(parent.patient_main.document.getElementById(\'patient_name\')) {\n\t\t\t\t\tif((\'";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\' != \'DuplicateRegistration\' && \'";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\' != \'\') || (\'";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\' == \'P\')) {\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\" != \'\') {\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t//\tparent.parent.frames[1].frames[0].document.forms[0].patient_name.value = \"";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\";\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tputPatientName(document.forms[0].first_name);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\t\n\t\t\t\t\t\tputPatientName(document.forms[0].first_name);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(parent.patient_main.document.getElementById(\'patient_name_loc_lang\')) {\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\' != \'\') {\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\" != \'\') {\n\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].patient_name_loc_lang.value = \"";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\";\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tputLocalLangPatientName(document.forms[0].first_name_oth_lang);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\t\n\t\t\t\t\t\tputLocalLangPatientName(document.forms[0].first_name_oth_lang);\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t/*\n\t            if(\"";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\" != \'\') { \n\t\t\t\t\tif ( (parent.frames[0].document.forms[0].patient_name) && (parent.frames[0].document.forms[0].patient_name.value == \'\') ) {\n\t\t\t\t\t\tparent.frames[0].document.forms[0].patient_name.value = \"";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t*/\n\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script> \t\n\t\n            <input type=\'hidden\' name=\'blood_grp\' id=\'blood_grp\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'rh_factor\' id=\'rh_factor\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_nat_id_chk_val\' id=\'dflt_nat_id_chk_val\' value=\"\"></input>\n\n\t\t\t<input type=\'hidden\' name=\'a_ethnic_group_code\' id=\'a_ethnic_group_code\' value=\"";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\"";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Family_No\' id=\'Family_No\' value=\"";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id_No\' id=\'Alt_Id_No\' value=\"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id2_No\' id=\'Alt_Id2_No\' value=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id3_No\' id=\'Alt_Id3_No\' value=\"";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'Alt_Id4_No\' id=\'Alt_Id4_No\' value=\"";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_a_national_id_no\' id=\'temp_a_national_id_no\' value=\"";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_referral_id\' id=\'temp_referral_id\' value=\"";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_booking_ref_no\' id=\'temp_booking_ref_no\' value=\"";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_nat_id\' id=\'temp_nat_id\' value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'temp_appt_ref_no\' id=\'temp_appt_ref_no\' value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId1Desc\' id=\'altId1Desc\' value=\"";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId2Desc\' id=\'altId2Desc\' value=\"";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId3Desc\' id=\'altId3Desc\' value=\"";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'altId4Desc\' id=\'altId4Desc\' value=\"";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'FamilyNoLink\' id=\'FamilyNoLink\' value=\"";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'create_file_at_pat_regn_yn\' id=\'create_file_at_pat_regn_yn\' value=\"";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'datasource_id\' id=\'datasource_id\' value=\"\"></input>\n\t\t\t<input type =\'hidden\' name=\'appfirstname\' id=\'appfirstname\' value=\"";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'appsecondname\' id=\'appsecondname\' value=\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\"></input>\n            <input type =\'hidden\' name=\'appthirdname\' id=\'appthirdname\' value=\"";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\"></input>\n            <input type =\'hidden\' name=\'appfamilyname\' id=\'appfamilyname\' value=\"";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\"></input>\n            <input type =\'hidden\' name=\'appdateofbirth\' id=\'appdateofbirth\' value=\"";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\"></input>\n            <input type =\'hidden\' name=\'appsex\' id=\'appsex\' value=\"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\"></input>\n            <input type =\'hidden\' name=\'appprefix\' id=\'appprefix\' value=\"";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\"></input>\n            <input type =\'hidden\' name=\'appsuffix\' id=\'appsuffix\' value=\"";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\"></input>\n            <input type =\'hidden\' name=\'appt_yn\' id=\'appt_yn\' value=\"";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\"></input>\n\t\t\t<input type =\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\"";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\"></input>\n           \t<input type=\'hidden\' name=\'dr_function_id\' id=\'dr_function_id\' value=\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\"></input> \n\t\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\'></input>\n\t\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\'></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_pat_regn_blng_class\' id=\'dflt_pat_regn_blng_class\' value=\"";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\">\n\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'photo_file_name\' id=\'photo_file_name\' value=\"";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 =".jpg\"></input>\n\t\t\t<input type=\'hidden\' name=\'dflt_alt_id1_in_emp_id_yn\' id=\'dflt_alt_id1_in_emp_id_yn\' value=\"";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\">\n\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\"></input> \t\t\t\n\t\t\t<input type=\'hidden\' name=\'alt_exp_date_fromHCS\' id=\'alt_exp_date_fromHCS\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"PatRegForm\"></input>\n\t\t\t<input type=\'hidden\' name=\'img_dir_name\' id=\'img_dir_name\' value=\"\"></input>\n\n\t\t\t<input type=\'hidden\' name=\'deceased_yn\' id=\'deceased_yn\' value=\"N\"></input>\n\t\t\t<input type=\'hidden\' name=\'deceased_date\' id=\'deceased_date\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'dla_image_yn\' id=\'dla_image_yn\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'upload_patient_id\' id=\'upload_patient_id\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'output\' id=\'output\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'funCall\' id=\'funCall\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'bl_success_msg\' id=\'bl_success_msg\' value=\"\"></input>\n\t\t\t<input type=\'hidden\' name=\'Photo_upload_yn\' id=\'Photo_upload_yn\' value=\"N\"></input>\n\t\t";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\n\t\t\t";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 =" \n\t\t\t";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\n\t\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\n\t\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n\t\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n\t\t";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\n\t\t\t\n\t\n\t\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\n\t\t\t<!-- FOR MYKAD READING -->\n\t\t\t<OBJECT id=Cad style=\\\"WIDTH: 149px; HEIGHT: 25px\\\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>\n\t\t\t<OBJECT id=jpndf1 style=\\\"WIDTH: 192px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>\n\t\t\t<OBJECT id=jpndf4 style=\\\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\\\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>\n\t\t\t<OBJECT id=gmpcpic style=\\\"WIDTH: 345px; HEIGHT: 303px\\\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>\n\t\t\t<!-- END FOR MYKAD READING -->\n\t\t\t";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\n\t \t<script>\n\t\t/* \nBelow line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065]*/\nfunction makeValidStringRemark(txtObj)\n{  \n    var text_value  =   txtObj.value;\n\t\n    while(text_value.indexOf(\'\"\')!=-1)\n    {\n        text_value = text_value.replace(\'\"\',\"\'\");\n    }\n\t\n\twhile (text_value.indexOf(\'+\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'+\',\"\");\n\t}\n\twhile (text_value.indexOf(\'%\')!=-1)\n\t{ \n\ttext_value=text_value.replace(\'%\',\"\");\n\t}\n\t\n    txtObj.value = text_value;\n\n    if(text_value.indexOf(\"&\")==(text_value.length-1))\n    {\n        return false;\n    }\n\n    for(var i=0; i<text_value.length; i++)\n    {\n        if( (text_value.charAt(i)==\'&\')  || (text_value.charAt(i)==\'<\') )\n        {\n            if(text_value.charAt(i+1)!=\' \')\n            {\n                text_value  =   text_value.substring(0,(i+1))+\' \'+ text_value.substring((i+1),text_value.length);\n                i++;\n            }\n        }\n    }\n    txtObj.value = text_value;\n    if(txtObj.value.length>txtObj.maxLength)\n    {\n        alert(getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null));\n\n        txtObj.select();\n        txtObj.focus();\n    }\n}\n\t\t/*SKR-SCF-0631 [IN035065]*/\t\n\t\t\t\n\t\t\tpopulateethnicity();\n\t\t\tdispMandatoryImage();\n\t\t\tdispMandatoryImageForOthNames();\n\t\t</script>\n\t\t\n\t\t<!--Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF-->\n\t\t<input type=\'hidden\' name=\'fileTypeSiteSpec\' id=\'fileTypeSiteSpec\' value=\'";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\'></input>\n\t\t<input type=\'hidden\' name=\'alterAddressApplicable\' id=\'alterAddressApplicable\' value=\'";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\'></input>\n\t\t<!--Added by Ashwini on 07-Sep-2018-->\n\t\t<input type=\'hidden\' name=\'finDtlsChkNationality\' id=\'finDtlsChkNationality\' value=\'";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\'></input>\n\t\t<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US007 -->\n\t\t<input type=\'hidden\' name=\'aliasnameNationalityRace\' id=\'aliasnameNationalityRace\' value=\'";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\'></input>\n\t\t<!-- Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008 -->\n        <input type=\'hidden\' name=\'resiAddMailAdd\' id=\'resiAddMailAdd\' value=\'";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\'></input>\n        <input type=\'hidden\' name=\'isVirtualConsultation\' id=\'isVirtualConsultation\' value=\'";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\'></input><!--Added by Arthi for ML-MMOH-CRF-1930 US004-->\n\n\t\t\n\t\t</form>\n    </body>\n</html>\n";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\n<!--End-->\n\n";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
            _bw.write(_wl_block10_2Bytes, _wl_block10_2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

	 
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
  
 
 
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
	
            _bw.write(_wl_block15Bytes, _wl_block15);

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
		
            _bw.write(_wl_block16Bytes, _wl_block16);

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
	
            _bw.write(_wl_block17Bytes, _wl_block17);
if(isVirtualConsultation){
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Contactaddlcnt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_grp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block22Bytes, _wl_block22);

		try
		{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(a_postal_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(a_mail_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(alt_id1_accept_oth_pat_ser_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alt_id1_alphanum_validate_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alt_id2_alphanum_validate_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alt_id3_alphanum_validate_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id4_alphanum_validate_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id2_accept_oth_pat_ser_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id2_accept_alphanumeric_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id3_accept_oth_pat_ser_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id3_accept_alphanumeric_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_id4_accept_oth_pat_ser_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_id4_accept_alphanumeric_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(max_pat_age));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pat_category_reqd_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(org_member_relationship_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(org_member_relationship_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);

			FamilyNoLink					= checkForNull(rset.getString("Family_No_Link_Yn"),"N");
			dfltPSG							= checkForNull(rset.getString("dfltPSG"));
			
			citizen_nationality_code	= checkForNull(rset.getString("citizen_nationality_code"));
			if(a_race_code.equals("")) {
				a_race_code = checkForNull(rset.getString("default_race_code"));
			} 
			/*Two param added for this CRF [RUT-CRF-0011]*/ 
			// Below appt_ref_no param newly added for Incident 36262 
			
            _bw.write(_wl_block45Bytes, _wl_block45);
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
            _bw.write(_wl_block46Bytes, _wl_block46);
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
            }_bw.write(_wl_block52Bytes, _wl_block52);

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
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(size));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } else { 
										
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(size));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }
                            }
							if(order %2 != 0 && order!=0)
							{
								if(Demoaddlcnt==(i+1))
								{ 
									
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(size));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block61Bytes, _wl_block61);
 } else { 
										
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(lab));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nme));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(size));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(demo_cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Demoaddlcnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }
							}
                            order++;
							demo_cnt++;
                        }
						
                    }
					if(order %2 != 0 && order!=0)
					{
            _bw.write(_wl_block62Bytes, _wl_block62);
}
                   if (order != 0)
                    {
                        out.println("</table>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
} if(!alterAddressApplicable && increasedaddressLength){
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
} if((!alterAddressApplicable && !increasedaddressLength) || (alterAddressApplicable && increasedaddressLength)){
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
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
								
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(contact_prompts[i]));
            _bw.write(_wl_block74Bytes, _wl_block74);
 
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
                                   
            _bw.write(_wl_block75Bytes, _wl_block75);
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
									
            _bw.write(_wl_block76Bytes, _wl_block76);
									
									if(alterAddressApplicable){
									if(i == 1)
									{  
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(val_alt));
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{   
									    out.println("<td class='fields' colspan='"+col_span_td+"'>"+val_alt+"</td>") ;
									  }						
									}
									
            _bw.write(_wl_block79Bytes, _wl_block79);
if(i == 0)
									{ 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(val));
            _bw.write(_wl_block81Bytes, _wl_block81);
 //Added for ML-MMOH-CRF-0860.2
									if( (!increasedaddressLength) || (increasedaddressLength && ! alterAddressApplicable) ){
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
}//End ML-MMOH-CRF-0860.2
            _bw.write(_wl_block84Bytes, _wl_block84);
}else	
									if(i==1 && alterAddressApplicable)
									{
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(col_span_td));
            _bw.write(_wl_block70Bytes, _wl_block70);
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

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(colspantd));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block162Bytes, _wl_block162);
}else{
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(nkin_alias_name));
            _bw.write(_wl_block186Bytes, _wl_block186);
} 
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					    
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(nkin_oth_alt_id_no));
            _bw.write(_wl_block215Bytes, _wl_block215);
}
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(contact1_birth_date));
            _bw.write(_wl_block217Bytes, _wl_block217);
if(aliasnameNationalityRace){
            _bw.write(_wl_block210Bytes, _wl_block210);
hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(con, a_nationality_code, citizen_nationality_code,p);
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_long_desc"))));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(checkForNull((String)hash_Map3.get("country_code"))));
            _bw.write(_wl_block221Bytes, _wl_block221);

	 
			     hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(con, a_race_code,p); 
				 hash_Map = eMP.ChangePatientDetails.getSetupData(Facility,patient_grp,con,p);
			    
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_desc"))));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(checkForNull((String)hash_Map6.get("race_code"))));
            _bw.write(_wl_block225Bytes, _wl_block225);
} 
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(nkin_job_title));
            _bw.write(_wl_block228Bytes, _wl_block228);

					 
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
			   
            _bw.write(_wl_block229Bytes, _wl_block229);
 if(resiAddMailAdd){
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
} 
            _bw.write(_wl_block233Bytes, _wl_block233);
	
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
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(nkin_country_name));
            _bw.write(_wl_block236Bytes, _wl_block236);
 if(resiAddMailAdd){
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(nk_mail_country_desc));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(nkin_m_country_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(resadd_contact_name));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(mailadd_contact_name));
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
} 				
				
            _bw.write(_wl_block246Bytes, _wl_block246);
 if(!resiAddMailAdd){
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(nkin_res_tel_no));
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(nkin_mob_tel_no));
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(nkin_off_tel_no));
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(nkin_email_id));
            _bw.write(_wl_block255Bytes, _wl_block255);
}
            _bw.write(_wl_block256Bytes, _wl_block256);
 if(!resiAddMailAdd){
            _bw.write(_wl_block257Bytes, _wl_block257);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
   
						if(rset.getString("Family_No_Link_Yn").equals("Y"))
						{
            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block260Bytes, _wl_block260);
} 
            _bw.write(_wl_block261Bytes, _wl_block261);
if(iSSiteApplicable){
            _bw.write(_wl_block262Bytes, _wl_block262);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
}else{
            _bw.write(_wl_block264Bytes, _wl_block264);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
}
            _bw.write(_wl_block267Bytes, _wl_block267);
} 
            _bw.write(_wl_block268Bytes, _wl_block268);
 if(resiAddMailAdd){
            _bw.write(_wl_block269Bytes, _wl_block269);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(nkin_res_tel_no));
            _bw.write(_wl_block272Bytes, _wl_block272);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(nkin_mob_tel_no));
            _bw.write(_wl_block274Bytes, _wl_block274);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(nkin_email_id));
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block280Bytes, _wl_block280);
} 
            _bw.write(_wl_block281Bytes, _wl_block281);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);
if(resiAddMailAdd){
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(fton_contact_name));
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block290Bytes, _wl_block290);
 
						if(accept_national_id_no_yn.equals("Y")) { 
					
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(rset.getString("nat_id_prompt")));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(fton_nat_id_no));
            _bw.write(_wl_block294Bytes, _wl_block294);
}else{
            _bw.write(_wl_block295Bytes, _wl_block295);

					}
					//added by gomathi.
				 	if(Accept_oth_alt_id_yn.equals("Y")) 
					{ 
            _bw.write(_wl_block296Bytes, _wl_block296);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);

					for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(fton_alt_id_no));
            _bw.write(_wl_block300Bytes, _wl_block300);
}
            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(fton_job_title));
            _bw.write(_wl_block303Bytes, _wl_block303);
}
		else
		 {//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(fton_contact_name));
            _bw.write(_wl_block306Bytes, _wl_block306);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(fton_off_tel_no));
            _bw.write(_wl_block309Bytes, _wl_block309);
}
						//End ML-MMOH-CRF-0860.2
						
            _bw.write(_wl_block310Bytes, _wl_block310);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block313Bytes, _wl_block313);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block314Bytes, _wl_block314);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block316Bytes, _wl_block316);
}//End ML-MMOh-CRF-0860.2
            _bw.write(_wl_block317Bytes, _wl_block317);
 
						if(accept_national_id_no_yn.equals("Y")) { 
					
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(rset.getString("nat_id_prompt")));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(nat_on_blurfn_st));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(fton_nat_id_no));
            _bw.write(_wl_block319Bytes, _wl_block319);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block322Bytes, _wl_block322);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block323Bytes, _wl_block323);
}else{
            _bw.write(_wl_block295Bytes, _wl_block295);

					
					
					}
					//added by gomathi.
				 	if(Accept_oth_alt_id_yn.equals("Y")) 
					{ 
            _bw.write(_wl_block324Bytes, _wl_block324);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block325Bytes, _wl_block325);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);

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
					
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(fton_alt_id_no));
            _bw.write(_wl_block326Bytes, _wl_block326);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block327Bytes, _wl_block327);
if(accept_national_id_no_yn.equals("N")){
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
}
            _bw.write(_wl_block330Bytes, _wl_block330);
}
						//End ML-MMOH-CRF-0860.2
						
            _bw.write(_wl_block331Bytes, _wl_block331);
}
            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(fton_job_title));
            _bw.write(_wl_block333Bytes, _wl_block333);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block327Bytes, _wl_block327);
if(Accept_oth_alt_id_yn.equals("N") && accept_national_id_no_yn.equals("N")){
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
}
            _bw.write(_wl_block334Bytes, _wl_block334);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block335Bytes, _wl_block335);
}
				if(resiAddMailAdd){
            _bw.write(_wl_block336Bytes, _wl_block336);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
} 
            _bw.write(_wl_block337Bytes, _wl_block337);
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
            _bw.write(_wl_block338Bytes, _wl_block338);
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
					
            _bw.write(_wl_block339Bytes, _wl_block339);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(fton_country_name));
            _bw.write(_wl_block341Bytes, _wl_block341);
 if(resiAddMailAdd){
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(fton_mail_country_desc));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(fton_m_country_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(fton_resadd_contact_name));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(fton_mailadd_contact_name));
            _bw.write(_wl_block346Bytes, _wl_block346);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block348Bytes, _wl_block348);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
 } //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
            _bw.write(_wl_block210Bytes, _wl_block210);
//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008	
				if(!resiAddMailAdd){
            _bw.write(_wl_block349Bytes, _wl_block349);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block350Bytes, _wl_block350);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block351Bytes, _wl_block351);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(fton_res_tel_no));
            _bw.write(_wl_block333Bytes, _wl_block333);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block350Bytes, _wl_block350);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block353Bytes, _wl_block353);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(fton_mob_tel_no));
            _bw.write(_wl_block355Bytes, _wl_block355);
//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){
            _bw.write(_wl_block350Bytes, _wl_block350);
}
						//End ML-MMOh-CRF-0860.2
						
            _bw.write(_wl_block356Bytes, _wl_block356);

					//Added for this CRF ML-MMOh-CRF-0860.2
					if(!increasedaddressLength){
					
            _bw.write(_wl_block357Bytes, _wl_block357);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(fton_off_tel_no));
            _bw.write(_wl_block359Bytes, _wl_block359);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block361Bytes, _wl_block361);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block362Bytes, _wl_block362);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block363Bytes, _wl_block363);
}
					 //End this ML-MMOh-CRF-0860.2
				} //Ended for ML-MMOH-CRF-1527 US008
					
            _bw.write(_wl_block364Bytes, _wl_block364);
if(resiAddMailAdd){
            _bw.write(_wl_block269Bytes, _wl_block269);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(fton_res_tel_no));
            _bw.write(_wl_block367Bytes, _wl_block367);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(fton_mob_tel_no));
            _bw.write(_wl_block369Bytes, _wl_block369);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
 for(int i=0;i<contactmode.length;i++) { 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(contactmode[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(contactdesc[i]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							
            _bw.write(_wl_block374Bytes, _wl_block374);
} //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 
            _bw.write(_wl_block375Bytes, _wl_block375);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block376Bytes, _wl_block376);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block377Bytes, _wl_block377);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block380Bytes, _wl_block380);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block381Bytes, _wl_block381);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(organization_name));
            _bw.write(_wl_block385Bytes, _wl_block385);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(emplr_contact_name));
            _bw.write(_wl_block387Bytes, _wl_block387);

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
						
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(emplr_country_name));
            _bw.write(_wl_block390Bytes, _wl_block390);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(emplr_res_tel_no));
            _bw.write(_wl_block392Bytes, _wl_block392);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(emplr_off_tel_no));
            _bw.write(_wl_block394Bytes, _wl_block394);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(patient_employee_id));
            _bw.write(_wl_block396Bytes, _wl_block396);
if (!a_alt_id1_no.equals("") && dflt_alt_id1_in_emp_id_yn.equals("Y")) { 
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(a_alt_id1_no));
            _bw.write(_wl_block398Bytes, _wl_block398);
}
            _bw.write(_wl_block399Bytes, _wl_block399);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block400Bytes, _wl_block400);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block401Bytes, _wl_block401);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block404Bytes, _wl_block404);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block406Bytes, _wl_block406);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block407Bytes, _wl_block407);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block408Bytes, _wl_block408);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block412Bytes, _wl_block412);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block414Bytes, _wl_block414);
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
			   
            _bw.write(_wl_block415Bytes, _wl_block415);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block417Bytes, _wl_block417);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block418Bytes, _wl_block418);

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
                
            _bw.write(_wl_block419Bytes, _wl_block419);
if(!doc1_num.equals("")){
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(doc1_num));
            _bw.write(_wl_block421Bytes, _wl_block421);
}else{
            _bw.write(_wl_block422Bytes, _wl_block422);
}
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(doc1_exp_date));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(doc1_exp_date));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(doc1_place_of_issue));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block430Bytes, _wl_block430);

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
					
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(iDocFolderOption));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(iDocScanEnabled));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(doc2_num));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(doc2_exp_date));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(doc2_exp_date));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(doc2_place_of_issue));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(doc2_iss_date));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(doc2_iss_date));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block444Bytes, _wl_block444);

					document_id ="doc_id2"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(doc3_num));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(doc3_exp_date));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(doc3_exp_date));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(doc3_place_of_issue));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(doc3_iss_date));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(doc3_iss_date));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block454Bytes, _wl_block454);

					document_id ="doc_id3"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(doc4_num));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(doc4_exp_date));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(doc4_exp_date));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(doc4_place_of_issue));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(doc4_iss_date));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(doc4_iss_date));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block464Bytes, _wl_block464);

					document_id ="doc_id4"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block467Bytes, _wl_block467);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block468Bytes, _wl_block468);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block469Bytes, _wl_block469);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block470Bytes, _wl_block470);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block471Bytes, _wl_block471);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block472Bytes, _wl_block472);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block473Bytes, _wl_block473);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block476Bytes, _wl_block476);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block477Bytes, _wl_block477);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block478Bytes, _wl_block478);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block479Bytes, _wl_block479);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block480Bytes, _wl_block480);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block482Bytes, _wl_block482);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(informant));
            _bw.write(_wl_block484Bytes, _wl_block484);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(informant_remarks));
            _bw.write(_wl_block486Bytes, _wl_block486);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block487Bytes, _wl_block487);
	
						if(Othersaddlcnt==0){
            _bw.write(_wl_block488Bytes, _wl_block488);
}else{
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(general_remarks));
            _bw.write(_wl_block490Bytes, _wl_block490);
}
            _bw.write(_wl_block491Bytes, _wl_block491);

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
                
            _bw.write(_wl_block492Bytes, _wl_block492);
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
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_area_long_desc));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(nkin_area_long_desc));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_region_long_desc));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(nkin_region_long_desc));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(nkin_town_long_desc));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(nkin_town_long_desc));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_town_long_desc));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(fton_town_long_desc));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_area_long_desc));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(fton_area_long_desc));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(fton_region_long_desc));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(fton_region_long_desc));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(fton_contact_relation));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(fton_contact_relation));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(emplr_town_long_desc));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(emplr_town_long_desc));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(emplr_region_long_desc));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(emplr_region_long_desc));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(emplr_area_long_desc));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(emplr_area_long_desc));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(contact3_mode));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(contact3_mode));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(contact3_no));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(contact3_no));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(contact4_mode));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(contact4_mode));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(contact4_no));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(contact4_no));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(contact5_mode));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(contact5_mode));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(contact5_no));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(contact5_no));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(nkin_contact_relation));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(nkin_contact_relation));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(contact1_oth_alt_id_type));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(contact1_oth_alt_id_type));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(rset.getString("name_dervn_logic")));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(rset.getString("name_dervn_logic_oth_lang")));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(rset.getString("NAME_DERVN_LOGIC_LONG")));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(rset.getString("NAME_DERVN_LOGIC_OTH_LANG_LONG")));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(a_patient_long_name));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf( a_patient_long_name_loc_lang));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(patient_grp));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(a_first_name));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(a_second_name));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(a_third_name));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(rset.getString("Alt_Id1_Unique_Yn")));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(rset.getString("Alt_Id2_Unique_Yn")));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(rset.getString("Alt_Id3_Unique_Yn")));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(rset.getString("Alt_Id4_Unique_Yn")));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(rset.getString("Citizen_Nationality_Code")));
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(rset.getString("default_race_code")));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(rset.getString("dfltPSG")));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(Facility));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block555Bytes, _wl_block555);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(rset.getString("ServerDate")));
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(region_appl_yn));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(addr_line1_prompt));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(addr_line2_prompt));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(postal_code_prompt));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(area_code_prompt));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(town_code_prompt));
            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(a_alt_id1_no));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(a_national_id_no));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block579Bytes, _wl_block579);
            out.print( String.valueOf(a_patient_name));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(a_ethnic_group_code));
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(a_familyno));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(AltIdNo2));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(AltIdNo3));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(AltIdNo4));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(init_a_national_id_no));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(init_referral_id));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(init_booking_ref_no));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(init_nat_id));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(init_appt_ref_no));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id1_desc"))));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id2_desc"))));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id3_desc"))));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(checkForNull(rset.getString("alt_id4_desc"))));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(FamilyNoLink));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(create_file_at_pat_regn_yn));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(a_first_name));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(a_second_name));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(a_third_name));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(a_family_name));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(a_date_of_birth));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(a_gender));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(a_name_prefix));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(a_name_suffix));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(appt));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(dflt_pat_regn_blng_class));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(rset.getString("photo_file_name")));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(dflt_alt_id1_in_emp_id_yn));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block618Bytes, _wl_block618);
 
			 
			

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
            _bw.write(_wl_block619Bytes, _wl_block619);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("MP")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("apptrefno"), weblogic.utils.StringUtils.valueOf(apptrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block620Bytes, _wl_block620);

		   }
		   else if(!booking_ref_no.equals("") || refrlAappt.equals("I"))
			{
            _bw.write(_wl_block621Bytes, _wl_block621);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("MP")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bookingrefno"), weblogic.utils.StringUtils.valueOf(bookingrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block620Bytes, _wl_block620);
}
				else
				{
            _bw.write(_wl_block622Bytes, _wl_block622);
}
			}
			else
			{
            _bw.write(_wl_block623Bytes, _wl_block623);
	} 			
	
	
            _bw.write(_wl_block624Bytes, _wl_block624);
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
			
			
            _bw.write(_wl_block625Bytes, _wl_block625);

		}
		
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(fileTypeSiteSpec));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(alterAddressApplicable));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(finDtlsChkNationality));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(aliasnameNationalityRace));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(resiAddMailAdd));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(isVirtualConsultation));
            _bw.write(_wl_block632Bytes, _wl_block632);
            _bw.write(_wl_block633Bytes, _wl_block633);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateAddress.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPerson.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPerson.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyFirsttoNotify.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyFirsttoNotify.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyHeadofFamily.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyFirsttoNotify.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPerson.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyNextofKin.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyPatientAddress.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employerdetails.label", java.lang.String .class,"key"));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employeedetails.label", java.lang.String .class,"key"));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orgName.label", java.lang.String .class,"key"));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPersonName.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentid.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationofthePerson.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FullTimeEmployed.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FullTimeStudent.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PartTimeEmployed.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PartTimeStudent.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SelfEmployed.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Unemployed.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentno.label", java.lang.String .class,"key"));
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
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PlaceOfIssue.label", java.lang.String .class,"key"));
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
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueDate.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UplodDoc.label", java.lang.String .class,"key"));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Miscellaneous.label", java.lang.String .class,"key"));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dependency.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NotKnown.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SpouseDependent.label", java.lang.String .class,"key"));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MedicalSupervisionReqd.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SmallChildren.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.WalkUp.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Arrangement.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Alone.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.family.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relative.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.spouseonly.label", java.lang.String .class,"key"));
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
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EducationLevel.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegistrationSource.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Informant.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InformantRemarks.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generalRemarks.label", java.lang.String .class,"key"));
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
}
