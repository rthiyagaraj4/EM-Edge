package jsp_servlet._emo._jsp;

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
import eCommon.Common.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __moregisterattnresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegisterAttnResult.jsp", 1745293368876L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n\n<head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script src=\'../../eMP/js/MPStillBirthDetails.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eMO/js/MORegisterAttn.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n </head>\n  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\tparent.frames[1].location.href = \"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Facility_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ;  \n\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t<script>\n\t\t\tparent.frames[1].location.href = \"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ;  \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t    \n\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<script>       \n\t\t\t\tparent.frames[1].location.href = \"../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ;  \n\t\t\t</script>\n\t   \n\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t <body OnMouseDown=\'CodeArrest()\' onLoad=\"assignmlc();enableService();enableservices(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');getClaimant1(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');clearBed();ClearClaimantValues();enableManGif(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');EnableFields();\" onKeyDown=\"lockKey()\" onSelect=\'codeArrestThruSelect();\' >\t \n\t <form name=\"MO_regn_form\" id=\"MO_regn_form\"  action=\"../../servlet/eMO.MOMortuaryRegnServlet\"  method=\"post\" target=\"messageFrame\" >\n\t<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->\n\t <div id = \'REGDETAILS\'>\n\t <a name=\"tab1\" id=\"tab1\"></a>\t\n    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'white\' align=\'right\'> \n\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  class=\'button\' onClick=\"viewPatientDetails(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"><INPUT TYPE=\"button\" \n\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onClick=\"showPrevEncounter(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\"class=button>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t\t<tr><td class=\'white\'>&nbsp;</td></tr>\n\t\t\t</table>\n\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t\t<li class=\"tablistitem\" title=\"RegnDtls\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'regn_dtls_tab\')\" id=\"regn_dtls_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"regn_dtls_tabspan\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"OrganDonation\">\n\t\t\t\t\t\t<a  onclick=\"javascript:tab_enable(\'organ_dtn_tab\')\" id=\"organ_dtn_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"organ_dtn_tabspan\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\" id=\'claimantDis\'>\n\t\t\t\t\t\t<a  onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\">\n\t\t\t\t\t\t<a  onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</ul>\t\n\t\n\n\t  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t  <tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n\t  </tr>\t\n\t  <tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=label width=\'25%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t  <td class=\'querydata\' width=\'25%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t  <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t  <td class=\'querydata\' width=\'30%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\t\n\t\t\t\t</tr>\t  \n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t  <td class=\'querydata\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t  <td class=\'label\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t  </tr>\t\t  \n\t <input type=hidden name=\'referral_source\' id=\'referral_source\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t <input type=hidden name=\'referral_by\' id=\'referral_by\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t <input type=hidden name=\'refe_type\' id=\'refe_type\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t <input type=hidden name=\'hcare_type\' id=\'hcare_type\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\n\t  <tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n\t  </tr>\t\t\n\t  <tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t <td class=\'fields\' width=\'30%\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t \n\t\t\t\t\t <INPUT TYPE=\"text\" name=\"relgn_desc\" id=\"relgn_desc\" onblur=\'searchReligion1(relgn_desc,relgn_code,\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\");\' value=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'relg_button\' id=\'relg_button\' onClick=\'searchReligion(relgn_desc,relgn_code,\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\");\' ><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t <input type=hidden name=\'relflagyn\' id=\'relflagyn\' value=\'Y\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t <b>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b>\n\t\t\t\t\t </td>\n\t\t\t\t\t <input type=hidden name=\'relgn_code\' id=\'relgn_code\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\t\n\t\t\t\t</tr>\t\t\t\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td> \n\t\t\t\t\t <td class=\'fields\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t <INPUT TYPE=\"checkbox\" name=\"unclaimedbodyyn\" id=\"unclaimedbodyyn\" onClick=\'ClearClaimantValues()\' value=\"Y\" checked>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t <INPUT TYPE=\"checkbox\" name=\"unclaimedbodyyn\" id=\"unclaimedbodyyn\"   onClick=\'ClearClaimantValues()\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t </td> \n\t\t\t\t\t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td> <!--below legend name change against ML-MMOH-CRF-0737 by Mano -->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t <td class=\'label\'>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" \n\t\t\t\t\t <INPUT TYPE=\"checkbox\" name=\"highriskbodyyn\" id=\"highriskbodyyn\" value=\"Y\" checked>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t <INPUT TYPE=\"checkbox\" name=\"highriskbodyyn\" id=\"highriskbodyyn\">\n\t\t\t\t\t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t </td>\n\t\t\t\t</tr>  \n\t\t\t\t<tr> <!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\'manner_of_death\' id=\'manner_of_death\'  >\n\t\t\t\t\t<option value=\'\'>------";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="------</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' selected>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t        </td><A HREF=\"\"></A>\n\t\t\t\t       <td class=\'label\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t\t   <td class=\'fields\'><input type=\'text\' name=\'place_of_death\' id=\'place_of_death\' size=36 maxlength=100  value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'></td> \n\t\t\t\t</tr>\n\t\t\t\t <!--Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->\n\t\t\t\t  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="<!--Modified by Thamizh selvi on 19th Sep 2017 against [IN:065280]-->\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t<td class=\'fields\'><select name=\'manner_of_death_after_potmrtm\' id=\'manner_of_death_after_potmrtm\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" >\n\t\t\t\t<option value=\'\'>------";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="------</option>\n\t\t\t\t ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t   <option value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</option>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t    <option value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</option>\n                           ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</select> \n\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td> \n\t\t\t\t\t <td class=\'fields\'><INPUT TYPE=\"text\" name=\"bodyfounddat\" id=\"bodyfounddat\" maxlength=100 value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'></td> \n\t\t\t\t\n\t\t\t\t <!--end Bru-HIMS-CRF-365 [IN:039572]-->\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\t\t\n\t\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start-->\n\t\t\t\t\t\t<!--modified against [IN:068178] -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" maxlength=16 size=16 name=\"deceased_date\" id=\"deceased_date\" value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" disabled ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="onblur=\"if(validDateObj(this,\'DMYHM\',localeName))chkWithSysDt(this); disDeathDate1(this); \"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" id=\'decdate\' ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" onClick=\"document.forms[0].deceased_date.select();return showCalendar(\'deceased_date\', null, \'hh:mm\' );\"><img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="<!--End-->\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t <input type=\'hidden\' name=\'deceased_date\' id=\'deceased_date\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t <td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" maxlength=16 size=16 name=\"deceased_date\" id=\"deceased_date\" value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" onblur=\"if(validDateObj(this,\'DMYHM\',localeName))chkWithSysDt(this); disDeathDate1(this);\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" id=\'decdate\' ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="onClick=\"document.forms[0].deceased_date.select();return showCalendar(\'deceased_date\', null, \'hh:mm\' );\"><img src=\'../../eCommon/images/mandatory.gif\' ></img>\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t <!--Below condition added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]-->\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td> \n\t\t\t\t\t<td class=\'fields\'><INPUT TYPE=\"text\" name=\"bodyfounddat\" id=\"bodyfounddat\" maxlength=100 value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'></td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\n\t\t\t\t\t <td class=\'button\'>\n\t\t\t\t\t <!-- Added siteCheck below by Ashwin K for ML-MMOH-CRF-1891-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t<input type=\"button\" name=\"death_cause\" id=\"death_cause\" style=\"width:95\" class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'   onclick=\"deathCause(\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\',\n\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\');\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t </td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n  </tr>\t\n  \n<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<!--Modified by Ashwini on 25-Jul-2019 for ML-MMOH-CRF-0991-->\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="&nbsp;";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n\t</tr>\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\t\t<td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t\t\t\t<!--Below label Modified by Shanmukh on 26th-JUNE-2018 for ML-ML-MMOH-CRF-1036-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&nbsp;</td>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t<td class=\'fields\' width=\'30%\'>\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t <input type=\'text\' size=\'16\' maxlength=\'16\' id=\'body_received_date_time\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" name=\'body_received_date_time\' onfocus=\'\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' onblur=\"if(validDateObj(this,\'DMYHM\',localeName)){chkWithSysDt(this);chkWithDates(this,\'BRD\');}\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  disabled id=\'bodychk\' onClick=\"document.forms[0].body_received_date_time.select();return showCalendar(\'body_received_date_time\', null, \'hh:mm\' );\"style=\"cursor=\'hand\'\"><img src=\'../../eCommon/images/mandatory.gif\' ></img>\t\t \n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' onblur=\"if(validDateObj(this,\'DMYHM\',localeName)){chkWithSysDt(this);chkWithDates(this,\'BRD\');}\" ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" id=\'bodychk\' onClick=\"document.forms[0].body_received_date_time.select();return showCalendar(\'body_received_date_time\', null, \'hh:mm\' );\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\t\n\t\t\t\t\t\t </td>\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><select name=\'body_condition_code\' id=\'body_condition_code\' >\n\t\t\t\t\t\t<option value=\'\'>------";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t%>\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' selected >";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</option>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t  </select><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t\t\t\t\t  <td class=\'fields\'><textarea name=\'identification_marks\' id=\'identification_marks\' cols=\'20\' rows=\'2\' onKeyPress=\'\' onBlur=\'\' >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</textarea>\n\t\t\t\t\t  </td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\t\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t\t\t\t  ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t  <td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t\t\t  ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t<!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t\t\t</tr> \n\t\t\t</table> \n\t\t</td>\n\t</tr>\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t<!--below legend name change against ML-MMOH-CRF-0737 by Mano-->\n\t\t\t\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t\t\t\t        ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t   <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =" \n\t\t\t\t\t   <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t   <!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t\t\t\t   <td class=\'fields\' width=\'25%\'> \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t <input type=\'checkbox\'   name=\"mlc_yn\" id=\"mlc_yn\" ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' onClick=\'assignmlc();enableservices();clearBed1();checkserv1()\' ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =">\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t <input type=\'checkbox\' ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="  name=\"mlc_yn\" id=\"mlc_yn\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"   onClick=\'enableservices();clearPoliceDtls();\'><!--Modified by Thamizh selvi on 4th Aug 2017 for ML-MMOH-CRF-0689-->\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t\t\t\t\t\t <td class=\'fields\' id=\"treat_area\">\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t \n\t\t\t\t\t\t  <input type=\'checkbox\'  value=\'Y\'  name=\"brought_by_police_yn\" id=\"brought_by_police_yn\" checked onclick=\'policevalue()\' >\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t  <input type=\'checkbox\'  value=\'N\'  name=\"brought_by_police_yn\" id=\"brought_by_police_yn\" onclick=\'policevalue()\' >\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\t\n\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t   <td class=\'button\' align=\'right\'><input type=\"button\" name=\"Police_Details\" id=\"Police_Details\" style=\"width:90\" value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' class=\'BUTTON\' onclick=\'policedetails()\'><input type=\'hidden\' name=\'police_details\' id=\'police_details\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\t\n\t\t\t\t\t\t </td> \n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\t  \n \t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' id=\"treat_area\" width=\'25%\'>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t<input type=\'checkbox\'  ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" name=\"postmortem_reqd_yn\"  ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' onclick=\'clearArea();enableservices();clearBed1();clearpoliceconsent();\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<input type=\'checkbox\'  name=\"postmortem_reqd_yn\" id=\"postmortem_reqd_yn\" ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'   onclick=\'clearArea();enableservices();clearBed1();clearpoliceconsent();\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><SELECT name=\"postmortem_type\" id=\"postmortem_type\" disabled onChange=\'enableConsent()\'>\n\t\t\t\t\t\t<option value=\"\">------";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="------</option>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t<option value=\'C\' selected>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</option> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t<option value=\'C\' >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</option> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t<option value=\'M\' selected>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</SELECT><img id=\'idpttype\'src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  \n\t\t\t\t\t\tstyle=\'visibility:hidden\' ></td>\n\t\t\t\t\t\t<td class=\'button\' align=\"right\"\"><input type=\"button\" name=\"Consent_forms\" id=\"Consent_forms\" style=\"width:90\"  class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' onclick=\"getConsentForm()\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t    <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\' ><select ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =" name=\'service_code\' id=\'service_code\'   >\n\t\t\t\t\t\t\t<option value=\'\'>------";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="------</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' selected> ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</option>\n\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'> ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</option>\n\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\n\t\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' == \"insert\" && \'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' == 1)\n\t\t\t\t\t\t\t\t\t\t  document.forms[0].service_code.options(1).selected=true;\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\n\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'30%\'>\t<select name=\'area_type\' id=\'area_type\'  onblur=\'if(this.value ==\"\")document.getElementById(\"tab1\").scrollIntoView();document.forms[0].unclaimedbodyyn.focus();\' onchange=\'clearBed();enableareagif();\'>\n\t\t\t\t\t\t\t<option value = \"\">------";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="-------</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n\t\t\t\t\t  <td class=\'fields\'><input type=\'text\' name=\'bed_no\' id=\'bed_no\' size=\'8\' maxlength=\'8\'  value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" \n\t\t\t\t\t  onBlur=\'BedCheck();\' ><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\' disabled  onClick=\'searchBed(this,bed_no);\' ></td>\n\t\t\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td>\n\t\t\t\t\t  <td class=\'fields\'><input type=\'text\' id=\'assigndatetime\' name=\"assign_date_time\" id=\"assign_date_time\"  value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" maxLength=\'16\' size=\'16\' onBlur=\"if(validDateObj(this,\'DMYHM\',localeName)){chkAssignDate(this,\'ASD\')}else{this.value=\'\';};document.forms[0].unclaimedbodyyn.focus();\"  disabled><input  id=\'acalendar\' type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'assigndatetime\', null, \'hh:mm\' );\" disabled><img align=\'center\' id=\'adatetime\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t  <input type=\"button\" name=\"postmortem_det\" id=\"postmortem_det\" class=BUTTON  style=\"width:90;visibility:hidden\"  value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' onclick=\"viewPostmortemDet()\"></td>\n\t\t\t\t </tr> \n\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t <tr>\n\t\t\t\t <td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="&nbsp;</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =" name=\'RFID_Tag\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" onBlur=\'blurRFID(this);\' ><input type=button class=button value=\'?\' ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" name=\'RFID_Tag_button\' onClick=\'searchRFID(this,RFID_Tag);\' ></td>\n\n\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table> \n</div>\n\t<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->\n\t<div id = \'BURIAL\' style = \'display:none\'>\n\t<a name=\"tab4\"></a>\n\t<!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->\n\t\t\t   <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'white\' align=\'right\'> \n\t\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\')\"><INPUT TYPE=\"button\" \n\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\');\"class=button>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t<tr><td class=\'white\'>&nbsp;</td></tr>\n\t\t\t\t</table>\n\n\t\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t\t<li class=\"tablistitem\" title=\"RegnDtls\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'regn_dtls_tab\')\" id=\"regn_dtls_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"regn_dtls_tabspan\">";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"OrganDonation\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'organ_dtn_tab\')\" id=\"organ_dtn_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"organ_dtn_tabspan\">";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis4\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\" >\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis4\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t</ul>\t\t\t\t\n\t\n\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\n\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\t\n\n";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><INPUT TYPE=\"checkbox\" name=\"generate_burial_permit\" id=\"generate_burial_permit\"  onClick=\'enterBurial(this)\'></td>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t<INPUT TYPE=\"hidden\" name=\"generate_burial_permit\" id=\"generate_burial_permit\">\n\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t<tr><!--maxlength=\"16\" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="&nbsp;</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' size=\'16\' maxlength=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" name=\'body_burial_permit_no\' id=\'body_burial_permit_no\' onKeyPress=\"return CheckForSpecCharsLocal(event);\" ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'><img id = \'burMan\' src=\'../../eCommon/images/mandatory.gif\'  ></img> </td> \n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\t\n\t<!--Below code modified by Shanmukh for CRF ML-MMOH-CRF-1183-->\n\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t<tr>\n\t       <td class=\'label\'>";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t   ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t   <td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'disDeathDate\' id=\'disDeathDate\' value =\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\' disabled></td>";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t   <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</td> ";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t</tr>";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="<!--  !datetimeOfClaimingAppl condition Added by Santhosh for ML-MMOH-CRF-1948-->\n\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="<!--Condition is to hide label, For ML-ML-MMOH-CRF-1031-->\n\t<!--Below line modified for this CRF ML-MMOH-CRF-0695-->\n\t<tr>\n\t\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' size=\'16\' maxlength=\'16\' name=\'body_claiming_date_time\' id=\'body_claiming_date_time\'  value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' onblur=\"if(validDateObj(this,\'DMYHM\',localeName))chkAssignDate(this,\'CLD\')\" ";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 =" >\n\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'otdatetime1\'  name=\'OTDate1\' onClick=\"document.forms[0].body_claiming_date_time.select();return showCalendar(\'body_claiming_date_time\',null,\'hh:mm\');\" ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 =" style=\"cursor=\'hand\'\"  ><img id = \'burMan1\' src=\'../../eCommon/images/mandatory.gif\' ></img>";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</td>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n     <!--End this CRF ML-MMOH-CRF-0695-->\t\n\t<tr>\t\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</td>\n\t\t<td class=\'fields\'><INPUT TYPE=\"text\" name=\"vechile_no\" id=\"vechile_no\"  maxlength=30 value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =" ></td> \n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\t\n\t<tr>\n\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</td>\n\t<td class=\'fields\'>\n\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t<!--Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990-->\n\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t<input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" size=\"30\" maxlength=\"30\" onBlur=\'beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);\' ";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="><input type=\'button\' name=\'pract_id\' id=\'pract_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, burial_permit_app_desc)\' ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =">\n\t\t<input type=\'hidden\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value =\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'><img id = \'burMan2\' src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\t<input type=\'text\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" size=\"60\" maxlength=\"60\" ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =">\n\t\t<input type=hidden name=\'pract_id\' id=\'pract_id\'>\n\t\t<input type=\'hidden\' name=\'burial_permit_app_desc\' id=\'burial_permit_app_desc\' value =\'\'>\n\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\n\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t <input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="><input type=\'button\'  name=\'pract_id\' id=\'pract_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, burial_permit_app_desc)\' ";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =">\n\t\t   <input type=\'hidden\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value =\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t \n\t ";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t<input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="><input type=\'button\'   name=\'pract_id\' id=\'pract_id\' value=\'?\' class=\'button\' onclick=\'searchCode(this, burial_permit_app_desc)\' ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\'><img id = \'burMan2\' src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t<input type=\'text\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =">\n\t\t\t<input type=hidden name=\'pract_id\' id=\'pract_id\'>\n\t\t\t<input type=\'hidden\' name=\'burial_permit_app_desc\' id=\'burial_permit_app_desc\' value =\'\'>\n\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t  \n\t\t  ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t  ";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t\t<input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 =">\n\t\t\t   <input type=\'hidden\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value =\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'><img id = \'burMan2\' src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t ";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t ";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n  ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t<input type=\"text\" name=\"burial_permit_app_desc\" id=\"burial_permit_app_desc\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" size=\"15\" maxlength=\"15\"  ";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="><input type=\'button\'   style=\"visibility:hidden;width=\'0%\'\" name=\'pract_id\' id=\'pract_id\' value=\'\' class=\'button\'>\n\t<input type=\'hidden\' name=\'burial_permit_app_by\' id=\'burial_permit_app_by\' value =\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'>\n\t<img id = \'burMan2\' src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\n\t ";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t</td> \n\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</td>\n\t\t<td><input type=\'text\' size=\'16\' maxlength=\'16\' name=\'burial_app_date\' id=\'burial_app_date\' onfocus=\'\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\' onblur=\"if(validDateObj(this,\'DMYHM\',localeName))chkAssignDate(this,\'CLD\')\"  ";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="><input type=\"image\" id=\'buraprdt\' src=\"../../eCommon/images/CommonCalendar.gif\"   onClick=\"document.forms[0].burial_app_date.select();return showCalendar(\'burial_app_date\', null, \'hh:mm\' );\" ";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 =" style=\"cursor=\'hand\'\"><img id = \'burMan3\' src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t<td colspan=\'2\'>&nbsp;</td>\n\t</tr>\n\t\n\t</table>\n</div>\n\t  <!-- table close of mortuary services ***************** -->\n\t  \t<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->\n  <div id = \'CLAIMANT\' style = \'display:none\'>\n  <a name=\"tab3\"></a>\n\t    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'white\' align=\'right\'> \n\t\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis1\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\" id=\'clmt\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\" id=\'clmt\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis1\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\t\t\t\t</ul>\t\n\t\t\t\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'> \n\t\t\t\t<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\n\t\t\t\t\t<tr><td class=\'fields\' colspan=\"2\"><a  href=\"javascript:FnDefaultPreviousClaimantDetails();\" >";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="</a></td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\t\t\t\t<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 End-->\n\t\t\t\t<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\t\t\t\t\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</td>&nbsp;\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\"30%\">&nbsp;<select name=\'CLAIMANT_TYPE\' id=\'CLAIMANT_TYPE\'   onchange=\"getClaimant(this,\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\');\" onBlur=\'\' >\n\t\t\t\t\t\t\t\t <option value=\'\' >------";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="------</option>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t <!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\n\t\t\t\t\t\t\t\t <option value=\'K\' selected>";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</option>\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n\t\t\t\t\t\t\t\t <option value=\'K\' >";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t\t\t\t\t <option value=\'E\' selected>";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t\t\t\t\t\t\t <option value=\'E\' >";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\n\t\t\t\t\t\t\t\t <option value=\'M\' selected>";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n\t\t\t\t\t\t\t\t <option value=\'M\' >";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n\t\t\t\t\t\t\t\t <option value=\'W\' selected>";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t\t\t\t\t <option value=\'W\' >";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n\t\t\t\t\t\t\t   <option value=\'R\' selected>";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\n\t\t\t\t\t\t\t\t   <option value=\'R\' >";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t\t\t   <option value=\'U\' selected>";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="</option>\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t\t\t   <option value=\'U\' >";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\n\t\t\t\t\t\t\t\t <option value=\'F\' selected>";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t\t\t\t\t\t\t<option value=\'F\' >";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n\t\t\t\t\t\t\t\t <option value=\'O\' selected>";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\n\t\t\t\t\t\t\t\t<option value=\'O\' >";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\t-->\t\t\t\t\t\t\t\n\t\t\t\t\t\t </select></td>\t\n\t\t\t\t\t\t <!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\t\t\t\t \n\t\t\t\t\t   <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="&nbsp;</td>\n\t\t\t\t\t   <td class=\'fields\'>&nbsp;<select name=\'CLAIMANT_TYPE_CODE\' id=\'CLAIMANT_TYPE_CODE\' onchange=\"set_values(this,\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\');\"  disabled><option value=\'\'>------";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="------</select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=id3 style=\"visibility:hidden\"></img>\n\t\t\t\t\t  </td>\n\t\t\t\t\t <td class=\'button\'><INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\' name=copydet disabled onClick=\"copyDet(\'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\')\"class=button></td>\n\t<tr>\t\t\t\t  </tr>\n\t\t<td colspan=\'1\'>&nbsp;</td>\n\t</tr>\n\t<!-- Added by Santhosh for ML-MMOH-CRF-1948-->\n\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\t\n   <tr>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</td>\n\t<td class=\'fields\'><input type=\'text\' size=\"16\" maxlength=\"16\" name=\'body_claiming_date_time\' id=\'body_claiming_date_time\' ";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="value=\'\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="value=\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 =" onblur=\'dtchk(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].body_claiming_date_time.select();return showCalendar(\'body_claiming_date_time\', null, \'hh:mm\' );\" style=\"cursor=\'hand\'\">";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =" </td>\n\t</tr><!--END-->\n\t";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\t <!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031\t-->\t\t\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' size=\'16\' maxlength=\'16\' name=\'body_claiming_date_time\' id=\'body_claiming_date_time\'  ";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="  onblur=\"if(validDateObj(this,\'DMYHM\',localeName))chkAssignDate(this,\'CLD\')\"><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'otdatetime1\'  name=\'OTDate1\' onClick=\"return showCalendar(\'body_claiming_date_time\',null,\'hh:mm\');\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="style=\"cursor=\'hand\'\"  ><img  src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t<!--End-->\n\t\n</table>\n\t\t\t\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'>\n\t<tr>\n\t\t<td valign=\'top\' width=\'50%\'>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\t\t\t\t     <!--Below line added for ML-MMOH-CRF-0887.1-->\n\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'30%\'>";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\t\t   <textarea name=\'NAME\' rows=3 maxlength=80 cols=45 onblur=\'makeValidString(this); maxLengthPaste1(this);\' onkeypress=\'checkMaxLimit(this,80)\' onkeyup=\'RemoveSpecialChar(this)\'>";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="</textarea>\n\t\t\t      ";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"text\" name=\"NAME\" id=\"NAME\"  maxlength=\'30\' size=\'20\'  value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" ></td>\n\t\t\t\t ";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>  <!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\t\t\t\t<td class=\'label\'width=\'20%\'>";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="</td>\n\t\t\t\t<td class=\'fields\'width=\'30%\'><select name=\'RELATIONSHIP\' id=\'RELATIONSHIP\' ><option value=\"\">-------";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =" ----------</option>\n\t\t\t\t ";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t\t\t\t <option value=\'";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 =" </option>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 =" </option>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="  \n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\n\t<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\n\t\t<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->\n\t\t";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\n\t\t<td class=\'label\'width=\'20%\'>";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="</td>\n\t\t";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\t\n\t\t<td class=\'fields\'width=\'30%\'><input type=\"text\" name=\"NAT_ID_NO\" id=\"NAT_ID_NO\"  maxlength=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\' size=\'20\'  value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\' >\n\t\t</td>\n\t</tr>\t\n  ";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\n\t\t<input type=hidden name=NAT_ID_NO value=\"\">\n\t\n\t";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\t\n\t\n\t<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\t\t<td class=\'label\'width=\'20%\'>";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="</td>\n\t\t<td class=\'fields\'width=\'30%\'><input type=\"text\" name=\"PATIENT_EMPLOYEE_ID\" id=\"PATIENT_EMPLOYEE_ID\"  maxlength=\'20\' size=\'20\'  value=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\' >\n\t\t</td>\n    </tr>\n\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t<tr><td  class=\'LABEL\' width=\'20%\'>";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="</td>\n\t<td class=\'fields\' width=\'30%\'>   <input type=\"text\" name=\"PASSPORT_NO\" id=\"PASSPORT_NO\" onBlur=\'validSplchars(this);\' onKeyPress=\"return SpCharChkForPassportNo(event);\" maxlength=\'15\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\' >\n\t</td></tr>\n\t<tr><td  class=\'LABEL\' width=\'20%\'>";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="</td>\n\t<td class=\'fields\' width=\'30%\'>   <input type=\"text\" name=\"OTHER_IDENTIFICATION\" id=\"OTHER_IDENTIFICATION\"  maxlength=\'60\' size=\'30\'  value=\'";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\' >\n\t</td></tr>\n\t";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\n       <!--Below line added for this CRF ML-MMOH-CRF-0860.2-->\n\t<tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="</td>\n\t\t<td class=\'fields\' width=\'30%\'><input type=\"text\" name=\"JOB_TITLE\" id=\"JOB_TITLE\"  maxlength=\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\' size=\'";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\'  value=\'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\' ></td>\n    </tr>\n   <tr><!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n        <!--Below line added for this CRF ML-MMOH-CRF-0860.2-->\n\t\t<td class=\'label\'width=\'20%\'>";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="</td>\n\t\t<td class=\'fields\'width=\'30%\'><input type=\"text\" name=\"ORGANIZATION_NAME\" id=\"ORGANIZATION_NAME\"  maxlength=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\' ></td>\n   </tr>\n";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n<!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\t\n<tr><td class=\'label\' id=\'hed1\'width=\'20%\'>";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="</td>\n<td><label id=ocpnlab class=\'querydata\'width=\'30%\'><b>";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="</b></td>\n</tr>\n";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="<!-- // ALIGNMENT Changes Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg -->\n<tr><td class=\'label\' id=\'hed1\'width=\'20%\'>&nbsp;</td>\n<td><label id=\'ocpnlab\'width=\'30%\'></td>\n</tr>\n";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\n<!--  Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n<tr>\n<td class=\"label\" width=\'20%\' id=\'releasefacid\'style=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="</td>&nbsp;\n<td class=\"fields\" width=\'30%\' id=\'releasefacdesc\'style=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\"><select name=\'RELEASE_TO_FACILITY\' id=\'RELEASE_TO_FACILITY\'>\n<!--option value=\'\' selected>-------";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="-------</option-->\n ";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\n\t\t\t\t\t\t \n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\'selected>";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 =" \t\t </select></td>\n<!--  Saanthaakumar  Bru-HIMS-CRF-366 [IN:039612] End-->\n\t </tr> \n\t <!--Below line Added for this CRF Bru-HIMS-CRF-366 [IN:039612] -->\n\t <tr>\n<td class=\"label\" width=\'20%\' id=\'remarksid\' style=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="</td>&nbsp;\n<td class=\"fields\" width=\'30%\' id=\'remarksdesc\' style=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\"><textarea name=\'reason_desc\' rows=\'5\' cols=\'40\'  onKeyPress=\'checkMaxLimit(this,100);\' onpaste=\'return maxLengthPaste(this,\"100\");\' onBlur=\'return maxLength(this,\"100\");\'>\n";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="</textarea>\n\t\t\t\t\t\t\t\n</td></tr>\n </table>\n</td>  \n<td>\n     <table cellspacing=\'0\' cellpadding=\'3\' border=\'0\'>              \n      \n\n\t\t\t\t";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t   <input type=hidden name=claim";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 =" value=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\" >\t\n\t ";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t <td class=\'fields\' width=\'30%\'><textarea name=\'";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\' id=\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\' rows=\'3\' maxlength=\'100\' cols=\'50\' onblur=\'makeValidString(this); maxLengthPaste1(this);\' onkeypress=\'checkMaxLimit(this,100)\'>";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</textarea></td>\n\t\t\t ";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\' rows=\'3\' maxlength=\'100 \' cols=\'50\' onblur=\'makeValidString(this); maxLengthPaste1(this);\'  onkeypress=\'checkMaxLimit(this,100)\'>";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\' rows=\'3\' maxlength=\'100\' cols=\'50\' onblur=\'makeValidString(this); maxLengthPaste1(this);\'  onkeypress=\'checkMaxLimit(this,100)\'>";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="</textarea></td>\n\t\t\t";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\t\t\t       \n      \t <tr>\n\t\t <td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="</td>\n         <td class=\'fields\' ><input type=\'text\' onBlur=\"searchCountry1(this,COUNTRY_DESC)\" name=\'COUNTRY_DESC\' id=\'COUNTRY_DESC\' size=\'15\' value=\"";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\"  maxlength=\'15\'  ><input type=\'button\' name=\'cntrysrh\'  value=\'?\' id=\'cntrysrh\' class=\'button\' onclick=\"searchCountry(this,COUNTRY_DESC)\" ></td>\n          </tr>\n          <tr>\n              <td class=\'label\'>";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="</td>\n              <td class=\'fields\'><input type=\'text\' name=\'TELEPHONE_RES\' id=\'TELEPHONE_RES\' maxlength=\'20\' size=\'20\'  onblur=\'\'    value =\"";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\"></td>\n\t\t  </tr>\n          <tr>\n              <td class=\'label\'>";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="</td>\n              <td class=\'fields\'><input type=\'text\' name=\'MOB_TEL_NO\' id=\'MOB_TEL_NO\' maxlength=\'20\' size=\'20\'  onblur=\'\' value =\"";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\"></td>\n\t\t  <tr>\n\t\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="</td>\n              <td class=\'fields\'><input type=\'text\' name=\'TELEPHONE_OFF\' id=\'TELEPHONE_OFF\' maxlength=\'20\' size=\'20\'  onblur=\'\'  value =\"";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\"></td>\n          </tr>\n\t\t  <tr>\n\t\t      <td class=\'label\'>";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="</td>\n              <td class=\'fields\'><input type=\'text\' name=\'EMAIL_ID\' id=\'EMAIL_ID\'  onBlur=\'document.getElementById(\"tab2\").scrollIntoView();document.getElementById(\"CLAIMANT_TYPE\").focus()\'maxlength=\'50\' size=\'30\'     value = \"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\">\n\t\t\t </td>\n          </tr>\n\t\t  </table>\n\t\t</td>\n\t</tr>\n\t\t\t\t<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 Start-->\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\n\t\t\t\t\t<tr><td class=\'fields\' colspan=\"2\"><a  href=\"javascript:FnViewClaimantHistory();\" >";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\n\t\t\t\t<!--Added For Bru-HIMS-CRF-0368 By Dharma on 4th Dec 2013 End-->\n </table>\n</div>\n\t\t<!--Added For [IN:046059] By Lenin on 02-Jan-2013 Start-->\n<div id = \'ORGDONATION\' style = \'display:none\'>\n<a name=\"tab2\"></a>\n\t    <!--Added For [IN:046059] By Lenin on 02-Jan-2013 End-->\n\t\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'white\' align=\'right\'> \n\t\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"OrganDonation\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'organ_dtn_tab\')\" id=\"organ_dtn_tab\" class=\"tabClicked\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"organ_dtn_tabspan\">";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis3\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Claimant\" id=\"claimantDis3\">\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'claimant_tab\')\" id=\"claimant_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"claimant_tabspan\">";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="</span><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\t\n\t\t\t\t\t<li class=\"tablistitem\" title=\"BurialPermit\" id=\'dis3\'>\n\t\t\t\t\t\t<a onclick=\"javascript:tab_enable(\'burial_prmt_tab\')\" id=\"burial_prmt_tab\" class=\"tabA\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"burial_prmt_tabspan\">";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\n\t\t\t\t</ul>\t\n\n\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'>\n\t<tr>\n\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="</td>\t\n\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t\t<INPUT TYPE=\"checkbox\" onClick=\'enableService()\'NAME=\"donor_card_available_yn\" ID=\"donor_card_available_yn\" value=\"Y\" ";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 =" checked></td>\t\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\n\t\t\t\t\t\t<INPUT TYPE=\"checkbox\" onClick=\'enableService()\'NAME=\"donor_card_available_yn\" ID=\"donor_card_available_yn\" ";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 =" > </td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'button\' colspan=\'2\' align=\'right\'><INPUT TYPE=\"button\" name=\"donar_card_info\" id=\"donar_card_info\" onClick=\'donarcardInfo()\'class=\"button\" value=\'";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\'><INPUT TYPE=\"button\" name=\"Concent1\" id=\"Concent1\" value=\'";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\'  onclick=\"getConsentFormforDonar()\" class=\"button\"></td>\t\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' border=\'0\' align=\'center\'>\n\t\t\t\t";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\t\n\t\t\t\t\t  \n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\t<INPUT TYPE=\"checkbox\"   ";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 =" NAME=\"org";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\"   checked value=\'";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\n\t\t\t\t\t<INPUT TYPE=\"checkbox\" ";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\"   value=\'";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 =" \n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\t\n</div>\n<!--Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start-->\n<input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value = \'";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\'>\n<input type=\'hidden\' name=\'externalBidYn\' id=\'externalBidYn\' value = \'";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\'>\n<input type=\'hidden\' name=\'pol_officer_name\' id=\'pol_officer_name\' value = \'";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\'>\n<input type=\'hidden\' name=\'extBidYnFrmVw\' id=\'extBidYnFrmVw\' value = \'";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\'>\n<input type=\'hidden\' name=\'pol_contact_no\' id=\'pol_contact_no\' value = \'";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\'>\n<!--End-->\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value = \'";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\'>\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\n<input type=\'hidden\' name=\'dec_fac_id\' id=\'dec_fac_id\' value=\"";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n<input type=\'hidden\' name=\'dec_enc_id\' id=\'dec_enc_id\' value=\"";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\">\n<input type=\'hidden\' name=\'external\' id=\'external\' value=\"";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\">\n<input type=\'hidden\' name=\'regno\' id=\'regno\' value=\'";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\'>\n\n<input type=\'hidden\' name=\'pol_rep_no\' id=\'pol_rep_no\' value=\'";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\'>\n<input type=\'hidden\' name=\'pol_stn_id\' id=\'pol_stn_id\' value=\'";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\'>\n<input type=\'hidden\' name=\'pol_id\' id=\'pol_id\' value=\'";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\'>\n\n\n<input type=\'hidden\' name=\'police_approval_received_yn\' id=\'police_approval_received_yn\' value=\'";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\'>\n<input type=\'hidden\' name=\'police_received_by\' id=\'police_received_by\' value=\'";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\'>\n<input type=\'hidden\' name=\'police_received_date\' id=\'police_received_date\' value=\'";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\'>\n\t\n\n\n<!-- <input type=\'hidden\' name=\'bodypart\' id=\'bodypart\' value=\"\"> -->\t\t \n<input type=\'hidden\' name=\'consent_form_code\' id=\'consent_form_code\' value=\'";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\'>\n<input type=\'hidden\' name=\'consent_desc\' id=\'consent_desc\' value=\'\'>\n\n\n<input type=\'hidden\' name=\'enable_rfid_yn\' id=\'enable_rfid_yn\' value=\'";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0996 -->\n\n<input type=\'hidden\' name=\'area1\' id=\'area1\' value=\'";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\'>\n<input type=\'hidden\' name=\'town1\' id=\'town1\' value=\'";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\'>\n<input type=\'hidden\' name=\'region1\' id=\'region1\' value=\'";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\'>\n\n<input type=\'hidden\' name=\'conscentgivenby\' id=\'conscentgivenby\' value=\'";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\'>\n<input type=\'hidden\' name=\'deceasedrelationship\' id=\'deceasedrelationship\' value=\'";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\'>\t\t \n<input type=\'hidden\' name=\'consent_received_by\' id=\'consent_received_by\' value=\'";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\'>\n<input type=\'hidden\' name=\'consent_received_date\' id=\'consent_received_date\' value=\"";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\">\n<input type=\'hidden\' name=\'system_date\' id=\'system_date\' value=\"";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\">\n<input type=\'hidden\' name=\'system_date_cnv\' id=\'system_date_cnv\' value=\"";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\">\n             <!-- donar details -->\n\n<input type=\'hidden\' name=\'donar_card_no\' id=\'donar_card_no\' value=\"";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\">\n<input type=\'hidden\' name=\'donardetails\' id=\'donardetails\' value=\"";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\">\n<input type=\'hidden\' name=\'organcnt\' id=\'organcnt\' value=\"";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\">\n<input type=\'hidden\' name=\'maxrecord_count\' id=\'maxrecord_count\' value=\"";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\">\n<input type=\'hidden\' name=\'donatedorgan\' id=\'donatedorgan\' value=\"\">\n<!-- //consent for donar -->\n\n\n\n\n\n\n<input type=\'hidden\' name=\'consent_form_code1\' id=\'consent_form_code1\' value=\"";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\">\n<input type=\'hidden\' name=\'consent_desc1\' id=\'consent_desc1\' value=\'\'>\t\t \n<!-- <input type=\'hidden\' name=\'RELATIONSHIP\' id=\'RELATIONSHIP\' value=\'";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\'> -->\n\t\n<input type=\'hidden\' name=\'conscentgivenby1\' id=\'conscentgivenby1\' value=\"";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\">\n<input type=\'hidden\' name=\'deceasedrelationship1\' id=\'deceasedrelationship1\' value=\"";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\">\n<input type=\'hidden\' name=\'consent_received_by1\' id=\'consent_received_by1\' value=\"";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\">\n<input type=\'hidden\' name=\'consent_received_date1\' id=\'consent_received_date1\' value=\"";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\">\n<input type=\'hidden\' name=\'ZIP_CODE\' id=\'ZIP_CODE\' value=\"";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\">\n<input type=\'hidden\' name=\'COUNTRY_CODE\' id=\'COUNTRY_CODE\' value=\"";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\">\n<input type=\'hidden\' name=\'regn_no\' id=\'regn_no\' value=\"";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\">\n<input type=\'hidden\' name=\'consent_received_desc2\' id=\'consent_received_desc2\' value=\"";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\">\n<input type=\'hidden\' name=\'consent_received_desc\' id=\'consent_received_desc\' value=\"";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\">\n<input type=\'hidden\' name=\'area_codedum\' id=\'area_codedum\' value=\"";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\">\n<input type=\'hidden\' name=\'burial_permit_appr_by_name1\' id=\'burial_permit_appr_by_name1\' value=\"";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\"> <!-- IN018776 Tuesday, February 09, 2010 Venkat S -->\n\n<input type=\'hidden\' name=\'startendstat\' id=\'startendstat\' value=\"";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\">\n\t<input type=\'hidden\' name=\'brought_dead_yn\' id=\'brought_dead_yn\' value=\"";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\">\n\t\n\t<input type=\'hidden\' name=\'areatype\' id=\'areatype\' value=\"";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\">\n<input type=\'hidden\' name=\'police_approval_received_by_desc\' id=\'police_approval_received_by_desc\' value=\"";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\">\n<input type=\'hidden\' name=\'burial_permit_reqd_yn\' id=\'burial_permit_reqd_yn\' value=\"";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\">\n\n<!-- Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 Start-->\n<input type=\'hidden\' name=\'external_rec_exists\' id=\'external_rec_exists\' value=\'";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\' >\n<input type=\'hidden\' name=\'default_claimant_type\' id=\'default_claimant_type\' value=\'";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\' >\n<input type=\'hidden\' name=\'default_claimant_type_code\' id=\'default_claimant_type_code\' value=\'";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\' >\n<input type=\'hidden\' name=\'default_relationship\' id=\'default_relationship\' value=\'";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\' >\n<input type=\'hidden\' name=\'default_name\' id=\'default_name\' value=\'";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\' >\n<input type=\'hidden\' name=\'default_job_title\' id=\'default_job_title\' value=\'";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\' >\n<input type=\'hidden\' name=\'default_addrl1\' id=\'default_addrl1\' value=\'";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\' >\n<input type=\'hidden\' name=\'default_addrl2\' id=\'default_addrl2\' value=\'";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\' >\n<input type=\'hidden\' name=\'default_addrl3\' id=\'default_addrl3\' value=\'";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\' >\n<input type=\'hidden\' name=\'default_addrl4\' id=\'default_addrl4\' value=\'";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\' >\n<input type=\'hidden\' name=\'default_postal_code\' id=\'default_postal_code\' value=\'";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\' >\n<input type=\'hidden\' name=\'default_country_code\' id=\'default_country_code\' value=\'";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\' >\n<input type=\'hidden\' name=\'default_zip_code\' id=\'default_zip_code\' value=\'";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\' >\n<input type=\'hidden\' name=\'default_res_town_code\' id=\'default_res_town_code\' value=\'";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\' >\n<input type=\'hidden\' name=\'default_res_area_code\' id=\'default_res_area_code\' value=\'";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\' >\n<input type=\'hidden\' name=\'default_region_code\' id=\'default_region_code\' value=\'";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\' >\n<input type=\'hidden\' name=\'default_res_town_desc\' id=\'default_res_town_desc\' value=\'";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\' >\n<input type=\'hidden\' name=\'default_res_area_desc\' id=\'default_res_area_desc\' value=\'";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\' >\n<input type=\'hidden\' name=\'default_region_desc\' id=\'default_region_desc\' value=\'";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\' >\n<input type=\'hidden\' name=\'default_telephone_off\' id=\'default_telephone_off\' value=\'";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\' >\n<input type=\'hidden\' name=\'default_telephone_res\' id=\'default_telephone_res\' value=\'";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\' >\n<input type=\'hidden\' name=\'default_email_id\' id=\'default_email_id\' value=\'";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\' >\n<input type=\'hidden\' name=\'default_mob_tel_no\' id=\'default_mob_tel_no\' value=\'";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\' >\n<input type=\'hidden\' name=\'default_nat_id_no\' id=\'default_nat_id_no\' value=\'";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\' >\n<input type=\'hidden\' name=\'default_organization_name\' id=\'default_organization_name\' value=\'";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\' >\n<input type=\'hidden\' name=\'default_patient_employee_id\' id=\'default_patient_employee_id\' value=\'";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\' >\n\n<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->\n<input type=\'hidden\' name=\'default_Passport_No\' id=\'default_Passport_No\' value=\'";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\' >\n<input type=\'hidden\' name=\'default_Other_Identification\' id=\'default_Other_Identification\' value=\'";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\' >\n\n<input type=\'hidden\' name=\'default_RELEASE_TO_FACILITY\' id=\'default_RELEASE_TO_FACILITY\' value=\'";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\' >\n<input type=\'hidden\' name=\'default_reason_deceased_desc\' id=\'default_reason_deceased_desc\' value=\'";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\' >\n<input type=\'hidden\' name=\'default_country_desc\' id=\'default_country_desc\' value=\'";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\' >\n<input type=\'hidden\' name=\'isRemoveMandBPermitAppBy\' id=\'isRemoveMandBPermitAppBy\' value=\'";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\' >\n\n<!-- Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 End-->\n\n<!--Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743-->\n<input type=\'hidden\' name=\'isClaimantChngsApplicable\' id=\'isClaimantChngsApplicable\' value =\'";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\'>\n\n<!--Below line added for this CRF ML-MMOH-CRF-0695-->\n<input type=\'hidden\' name=\'datetimeofclaimingApplicable\' id=\'datetimeofclaimingApplicable\' value =\'";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\'> \n<!--End this CRF ML-MMOH-CRF-0695 -->\n\n<!--Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696-->\n<input type=\'hidden\' name=\'rearrangeTabBurlPermtClaimnt\' id=\'rearrangeTabBurlPermtClaimnt\' value =\'";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\'> \n<!--Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031-->\t\n<input type=\'hidden\' name=\'isChangeOfDateTimeClaimingAppl\' id=\'isChangeOfDateTimeClaimingAppl\' value =\'";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\'>\n<input type=\'hidden\' name=\'isReceivedDateTimeAppl\' id=\'isReceivedDateTimeAppl\' value =\'";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\'>\n<input type=\'hidden\' name=\'isDateTimeOfDeathAppl\' id=\'isDateTimeOfDeathAppl\' value =\'";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\'>  \n\n<!--Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value =\'";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\'> \n<input type=\'hidden\' name=\'claimant_type_mstr\' id=\'claimant_type_mstr\' value=\'";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\'>\n\n<!--Added by Santhosh for ML-MMOH-CRF-1948-->\n<input type=\'hidden\' name=\'datetime_claim_mand\' id=\'datetime_claim_mand\' value=\'";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\'>\n<input type=\'hidden\' name=\'datetimeOfClaimingAppl\' id=\'datetimeOfClaimingAppl\' value=\'";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\'>\n<!--END-->\n\n";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\n </form>\n <script>\n //enableservices();\n //Below IF clause modified by Shanmukh on 27th-JUNE-2018 for ML-ML-MMOH-CRF-1031\nif(document.forms[0].burial_permit_reqd_yn.value==\"N\" && document.forms[0].body_burial_permit_no.value==\"\"){// Suresh M\n\tif(document.forms[0].isChangeOfDateTimeClaimingAppl.value==\"false\"){\n\t\tdocument.forms[0].body_claiming_date_time.value = \"\";\n\t\tdocument.forms[0].body_claiming_date_time.disabled=false;\n\t}\n\tdocument.forms[0].burial_permit_appr_by_name1.value = \"\";\n\tdocument.forms[0].burial_app_date.value = \"\";\n\tdocument.forms[0].burial_permit_app_by.value = \"\";\n\tdocument.forms[0].burial_permit_app_desc.value = \"\";\n\t//Added for the incident - 46080 - start\n\tdocument.forms[0].burial_app_date.disabled=false;\n\t//Added for the incident - 46080 - end\n} // Suresh M Ends\n </script>\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\n<script>\n\t\n/* Below line was added this CRF Bru-HIMS-CRF-366 [IN:039612]  */\n\n function maxLength(field,maxChars)\n {\n       //if(field.value.length >= maxChars) {\n\t   if(field.value.length > maxChars) {\n\t      alert(getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null));\n           // event.returnValue=false;\t\n              field.select();\n              field.focus();\t\t  \n          return false;\n       }\n\t   else{\n\t     return true;\n\t   }\n }  \n\n function maxLengthPaste(field,maxChars)\n {\n       event.returnValue=false;\n       if((field.value.length +  window.clipboardData.getData(\"Text\").length) > maxChars) {\t \n\t     var errors1 = getMessage(\'REASON_EXCEED_MAX_LEN\',\'MO\');\n\t\t   alert(errors1);         \t  \n         return false;\n       }\n       event.returnValue=true;\n }\n\t/*Bru-HIMS-CRF-366 [IN:039612] */\n\tfunction FnDefaultPreviousClaimantDetails(){\n\t\tdocument.forms[0].CLAIMANT_TYPE.value = document.forms[0].default_claimant_type.value ;\n\t\tif(document.forms[0].default_claimant_type.value!=\"\"){\n\t\t\tgetClaimant1(document.forms[0].default_claimant_type.value,document.forms[0].default_claimant_type_code.value);\n\t\t\tif(document.forms[0].addr_line_1!=null){\n\t\t\t\tdocument.forms[0].addr_line_1.value\t= document.forms[0].default_addrl1.value; \n\t\t\t}\n\t\t\tif(document.forms[0].addr_line_2!=null){\n\t\t\t\tdocument.forms[0].addr_line_2.value\t= document.forms[0].default_addrl2.value; \n\t\t\t}\n\t\t\tif(document.forms[0].addr_line_3!=null){\n\t\t\t\tdocument.forms[0].addr_line_3.value\t= document.forms[0].default_addrl3.value; \n\t\t\t}\n\t\t\tif(document.forms[0].addr_line_4!=null){\n\t\t\t\tdocument.forms[0].addr_line_4.value\t= document.forms[0].default_addrl4.value; \n\t\t\t}\n\t\t\tif(document.forms[0].town!=null){\n\t\t\t\tdocument.forms[0].town.value\t= document.forms[0].default_res_town_desc.value; \n\t\t\t\tdocument.forms[0].town1.value\t= document.forms[0].default_res_town_code.value;\n\t\t\t}\n\t\t\tif(document.forms[0].area!=null){\n\t\t\t\tdocument.forms[0].area.value\t= document.forms[0].default_res_area_desc.value; \n\t\t\t\tdocument.forms[0].area1.value\t= document.forms[0].default_res_area_code.value;\n\t\t\t}\n\t\t\tif(document.forms[0].region!=null){\n\t\t\t\tdocument.forms[0].region.value\t= document.forms[0].default_region_desc.value; \n\t\t\t\tdocument.forms[0].region1.value\t= document.forms[0].default_region_code.value;\n\t\t\t}\n\t\t\t\n\t\t\tif(document.forms[0].postal_code!=null){\n\t\t\t\tdocument.forms[0].postal_code.value\t= document.forms[0].default_postal_code.value; \n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\tdocument.forms[0].COUNTRY_DESC.value\t= document.forms[0].default_country_desc.value;\n\t\t\tdocument.forms[0].COUNTRY_CODE.value\t= document.forms[0].default_country_code.value;\n\t\t\tdocument.forms[0].TELEPHONE_RES.value\t= document.forms[0].default_telephone_res.value;\n\t\t\tdocument.forms[0].TELEPHONE_OFF.value   = document.forms[0].default_telephone_off.value;\n\t\t\tdocument.forms[0].MOB_TEL_NO.value\t= document.forms[0].default_mob_tel_no.value;\n\t\t\tdocument.forms[0].EMAIL_ID.value\t= document.forms[0].default_email_id.value;\n\t\t\t\n\t\t\tif(document.forms[0].default_relationship.value!=\"\")\n\t\t\t\tdocument.forms[0].RELATIONSHIP.value\t= document.forms[0].default_relationship.value;\n\t\t\tdocument.forms[0].NAME.value\t= document.forms[0].default_name.value;\n\t\t\tdocument.forms[0].NAT_ID_NO.value\t= document.forms[0].default_nat_id_no.value;\n\t\t\tdocument.forms[0].PATIENT_EMPLOYEE_ID.value\t= document.forms[0].default_patient_employee_id.value;\n\t\t\t\n\t\t\t//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743\n\t\t\tdocument.forms[0].PASSPORT_NO.value\t= document.forms[0].default_Passport_No.value;\n\t\t\tdocument.forms[0].OTHER_IDENTIFICATION.value = document.forms[0].default_Other_Identification.value;\n\n\t\t\tdocument.forms[0].JOB_TITLE.value\t= document.forms[0].default_job_title.value;\n\t\t\tdocument.forms[0].ORGANIZATION_NAME.value\t= document.forms[0].default_organization_name.value;\n\t\t\n\t\t\tif(document.forms[0].default_claimant_type.value==\'F\'){\n\t\t\t\tdocument.getElementById(\"releasefacid\").style.visibility=\'visible\';\t\n\t\t\t\tdocument.getElementById(\"releasefacdesc\").style.visibility=\'visible\';\t\n\t\t\t\tdocument.getElementById(\"remarksid\").style.visibility=\'visible\';\t\t\n\t\t\t\tdocument.getElementById(\"remarksdesc\").style.visibility=\'visible\';\n\t\t\t\tif(document.forms[0].default_RELEASE_TO_FACILITY.value!=\"\")\n\t\t\t\tdocument.forms[0].RELEASE_TO_FACILITY.value\t= document.forms[0].default_RELEASE_TO_FACILITY.value;\n\t\t\t\t\n\t\t\t\tdocument.forms[0].reason_desc.value\t= document.forms[0].default_reason_deceased_desc.value;\n\t\t\t}\n\t\t}\n\t\tEnableFields();\n\t}\n\t\n\tfunction FnViewClaimantHistory(){\n\t\tvar regn_no\t\t= document.forms[0].regn_no.value;\n\t\tvar patient_id\t= document.forms[0].patient_id.value;\n\t\tvar encounter_id\t=  document.forms[0].encounter_id.value;\n\t\tvar title = getLabel(\"eMO.ViewClaimantHistory.label\",\"MO\");\n\t\tvar dialogHeight= \"40\" ;\n\t\tvar dialogWidth\t= \"75\" ;\n\t\tvar dialogTop= \"50\";\n\t\tvar dialogLeft= \"50\";\n\t\tvar prev=\"prev\";\n\t\tvar display=\"display\";\n\t\tvar features= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\t\twindow.showModalDialog(\'../../eMO/jsp/ViewClaimantHistoryFrames.jsp?title=\'+title+\'&patient_id=\'+patient_id+\'&display=\'+display+\"&EncounterId=\"+encounter_id,arguments,features);\n\t\t\n\t}\n\tfunction EnableFields(){\n\t\t\n\t\tif(document.forms[0].mode.value==\'modify\' && document.forms[0].CLAIMANT_TYPE.value!=\"\")\t{\n\t\t\tdocument.forms[0].NAT_ID_NO.disabled=false;\n\t\t\tdocument.forms[0].JOB_TITLE.disabled=false;\n\t\t\tdocument.forms[0].MOB_TEL_NO.disabled=false;\n\t\t}\n\t}\n//ML-MMOH-CRF-0860.2\nfunction maxLengthPaste1(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n//End ML-MMOH-CRF-0860.2\nfunction disDeathDate1(obj)\n{ \n\tvar isDateTimeOfDeathAppl=document.forms[0].isDateTimeOfDeathAppl.value;\n\tif(isDateTimeOfDeathAppl==\"true\"){\n\t\t document.forms[0].disDeathDate.value=obj.value;\n\t}\n}\n\t</script>\n\n";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

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


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
	 request.setCharacterEncoding("UTF-8");


	 String user_id = (String) session.getValue("login_user");
	 Properties p		= (java.util.Properties) session.getValue("jdbc");
 

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
        Connection con							= null;
    	PreparedStatement pstmt2				= null;
       	ResultSet vrs							= null;
		java.sql.Statement vpstmt				= null;
        PreparedStatement pstmt                 =null; 
		java.sql.Statement sstat                = null;
		String body_found_at="";
		String ocpn_class_desc="";
		String checkmlc="N";
		String checkpm="N";
		String disabledyn="";
		String release_fac_id="";  // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String release_fac_desc="";		// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String RELEASE_TO_FACILITY = "";// Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		String releasefacility = "visibility:hidden"; // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
		
		String reason_deceased_desc=""; //this line added for this CRF Bru-HIMS-CRF-366 [IN-039612]
	 	String mode                             = request.getParameter("mode")==null?"insert":request.getParameter("mode");
		/*Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
		String death_after_potmrtm_yn="";
		String death_after_potmrtm="";
		 	 
		 
        if(mode.equals("modify")||mode.equals("viewdata"))
		{	disabledyn="disabled" ; 
		    
		} else{death_after_potmrtm_yn="disabled";}
	  try
	  {
		String facilityId				        = checkForNull((String)session.getValue("facility_id"));
		String patient_id						= checkForNull(request.getParameter("patient_id"));
	    String accept_national_id_no_yn="";
        String nat_id_length="";
        String nat_id_prompt="";
		String addrl1                      = "";
	    String addrl2                      = "";
	    String addrl3                      = "";
	    String addrl4                      = "";
	    String postal_code                 = "";
		String res_town_desc="";
        String res_area_desc="";
        String region_desc="";
        String area_type="";  
		String relgn_code="";
		String relgn_desc="";
		String	claimant_type="";      
		String	claimant_type_code=""; 
		String	relationship="";       
		String	name="";               
		String	job_title="";          
		String  blurData="";
		String disunclim="";
		String	zip_code="";           
		String	country_code="";       
		String	res_town_code="";      
		String	res_area_code="";      
		String	region_code="";        
		String	telephone_off="";      
		String	telephone_res="";      
		String	email_id="";           
		String vechile_no="";
		String	mob_tel_no="";         
		String	nat_id_no="";          
		String	organization_name="";  
		String	patient_employee_id=""; 

		String	Passport_No=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		String	Other_Identification=""; //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

     	String body_claiming_date_time="";
     	String body_claiming_date_time_cnv="";
		String postmortem_startend_status ="";
	//	String hcare_type_code="";
		
		String	referred_by                 = "";
		String	death_manner_code           ="";
		String	body_cond_code              ="";
		String	high_risk_body_yn           =""; 
		String	unclaimed_body_yn           ="";
		String	death_certificate_reqd_yn   =""; 
		String	brought_by_police_yn        =""; 
		String	service_code                ="";  
		String	area_code                   ="";
		String	bed_no                      =""; 
		String	 rfid_tag_num           =""; 
		String	assign_date_time            ="";
		String	assign_date_time_cnv            ="";
        String  identification_marks        ="";
        String  place_of_death               ="";  
        String  postmortem_type              ="";
		String  postmortem_status           ="";
		String  referral_type="";
        String kcou ="";
		String hcare_setting_type=""; 
		String hcare_setting_type_desc="";
		String ref_source_code="";
		String referral_desc="";
		String referral_type_desc=""; 
		String  police_details              ="";
		String  police_approval_received_yn ="";
		String 	police_received_by          =""; 
		String 	police_received_date        =""; 
		String  consent_given_by            ="";  
        String  relationship_with_deceased  ="";
        String  consent_form_code           ="";
        String  consent_form_received_by    ="";
        String  consent_form_received_date  ="";
        String  consent_form_code1          ="";
        String  conscentgivenby1            =""; 
        String  deceasedrelationship1       =""; 
        String donor_card_available_yn="";
		String  consent_received_by1        ="";
        String  consent_received_date1      =""; 
        String  donar_card_no               ="";
        String  donar_card_details          ="";
        String  body_received_date          =""; 
        String  body_received_date_cnv      =""; 
		String police_approval_received_by_desc="";		
		String brought_dead_yn = "N";	
		String deceased_date			= "";
		String body_release_date_time   = "";	
		String encounter_id			    = "";
		String burial_permit_reqd_yn			    = "Y";   //Changes introduced for Bru-HIMS-CRF-161 [IN:030280] and KDAH-CRF-0038 [IN:029002] on 13.03.2012 by Suresh M
		String visit_adm_date_time      = "";
		String patient_class = "";
		String location = "";
	//	String specialty_desc = "";
//		String attend_pract_name = "";	
		String sys_date					=  "";
		String sys_date_cnv					=  "";
    	String mlc_yn = "N";
        String deathcseregby="";
		String regno = "";	
		String pol_rep_no = "";
		String pol_stn_id = "";
		String pol_id = "";
		String regn_allowed_in_mo_yn="";
		String regn_no="";
		String prevencdis="";
		String burial_permit_appr_by_name="";
		String consent_form_recd_by_name2="";
		String consent_form_recd_by_name="";
		String func_role_id="";	
		String burial_perm_no="";
		String burial_perm_by="";	
		String burial_perm_date="";
		String burial_perm_date_cnv="";
		String readText="";
	 	String disablebut="";
		String deceased_date_cnv = "";
		String body_release_date_time_cnv = "";
		String date_of_birth = "";
		String sex = "";
		String splty_code = "";		
		String pract_type = "";		
		String role_pract_type = "";		
		String locn_code = "";		
		String locn_type = "";
		/*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
		String extBidYnFrmVw	= "";
		String pol_officer_name	= ""; 
		String pol_contact_no	= "";
		String calledFrom		= request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		String externalBidYn	= request.getParameter("externalBidYn")==null?"N":request.getParameter("externalBidYn");
		/*End*/
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
		String function_id = request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
		//End this CRF ML-MMOH-CRF-0695
        String functionid = request.getParameter("function_id")==null?"":request.getParameter("function_id");//Added by Shanmukh on 26th-JUNE-2018 for ML-ML-MMOH-CRF-1031
		String external=request.getParameter("external")==null?"N":request.getParameter("external");
		String dec_fac_id="";
		String dec_enc_id="";
		String dec_dt_time="";
		String burial_permit_approved_date=""; //Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
		boolean IsViewClaimantHistoryDisplay	= false;//Added For Bru-HIMS-CRF-0368 By Dharma on 18th Dec 2013 
		con = ConnectionManager.getConnection(request);
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
		Boolean siteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE");
		/*end ML-MMOH-CRF-0354 [IN057191] */
		Boolean isRemoveMandBPermitAppBy = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","BURIAL_PERMIT_MANDATORY");//Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]
		
		Boolean isClaimantChngsApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CLAIMANT_MNDT_FLD_RENAME"); //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743

	   //Below line added for this CRF ML-MMOH-CRF-0695
	   boolean datetimeofclaimingApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_OF_CLAIMING");

	   Boolean rearrangeTabBurlPermtClaimnt = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","MO_REARRANGE_TABS"); //Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696

	   //Below line added against ML-MMOH-CRF-0737 by Mano
	   boolean mlcAndInfectiousDeceBodyApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CHANGE_MLC_AND_INFEC_DECS_BODY");
	   String datetimeofclaiming="";
       //String disdatetimeofclaiming=""; 	   Commented for checkstyle 
	   //End this CRF ML-MMOH-CRF-0695
	   
	   /*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
		JSONArray ClaimantTypeJsonArr = new JSONArray();
		ClaimantTypeJsonArr = eMO.MOCommonBean.getClaimantType(con,function_id);
		/*End ML-MMOH-CRF-1095*/
	   
	   //Added for this CRF ML-MMOH-CRF-0860.2
	   String maxsize="30";
	   String maximumLength="30";
       Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	   if(increasedaddressLength){
	     maximumLength="50";
		 maxsize="64";
	   }
	  //End ML-MMOH-CRF-0860.2
	  
	  Boolean isChangeOfDateTimeClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_CLAIMING_CHANGE");//Added by Shanmukh on 25th-JUNE-2018 for ML-MMOH-CRF-1031
	  Boolean isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036
	  Boolean isDateTimeOfDeathAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","DATE_TIME_OF_DEATH_APPL");// Added by Shanmukh  for ML-MMOH-CRF-1183
	  
	  //Added by Santhosh for ML-MMOH-CRF-1948
	  String date_time_of_climing ="";
	  String datetime_claim_mand ="";
	  Boolean datetimeOfClaimingAppl = false;
	  
	  datetimeOfClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","DATETIME_OF_CLAIMING");
	  pstmt2  = con.prepareStatement("select DATETIME_CLAIM_MAND from MO_PARAMETER where facility_id = '"+facilityId+"' ");		
		vrs = pstmt2.executeQuery();
		if((vrs!=null) && vrs.next()){
			datetime_claim_mand= checkForNull(vrs.getString("DATETIME_CLAIM_MAND"));
		}

		if(pstmt2 != null) {
			pstmt2.close();
		}
		if(vrs != null) {
			vrs.close();
		}
		//END
	   

	   Boolean siteCheck = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","CAUSE_OF_DEATH"); //Added by Ashwin K for ML-MMOH-CRF-1891
 
		/*Below line added for this CRF  Bru-HIMS-CRF-407 [IN:045167]*/
		int regCount=0;
		String register_no=request.getParameter("register_no")==null?"":request.getParameter("register_no"); 
			  String sqlQuery="SELECT COUNT (*) reg_count  FROM or_order_line WHERE order_id in (SELECT order_id FROM or_order_line_mo  WHERE registration_no = '"+register_no+"' AND facility_id = '"+facilityId+"') and ORDER_LINE_STATUS Not in ('CN','DC')";			  
		      pstmt2=con.prepareStatement(sqlQuery); 
		      vrs=pstmt2.executeQuery();
		      if(vrs!=null && vrs.next()){
		           regCount=vrs.getInt("reg_count");
		      }		
		
		if(vrs!=null) vrs.close();
		if(pstmt2!=null)pstmt2.close();
		
		//End Bru-HIMS-CRF-407 [IN:045167]
         
		if(external.equals("Y") || mode.equals("viewdata")){
			/*pstmt2=con.prepareStatement("select DECEASED_FACILITY_ID,DECEASED_ENCOUNTER_ID,to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_date,RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC from mp_patient where patient_id=? and DECEASED_DATE is not null ");*/
			
			/*Above line commented and Below line added for this incident[65303]*/
			pstmt2=con.prepareStatement("select DECEASED_FACILITY_ID,DECEASED_ENCOUNTER_ID,to_char(DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_date,RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC from mp_patient where patient_id=?");
			
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();

			if (vrs!=null && vrs.next())	{
				dec_fac_id=checkForNull(vrs.getString("DECEASED_FACILITY_ID"));
				dec_enc_id=checkForNull(vrs.getString("DECEASED_ENCOUNTER_ID"));
				dec_dt_time=checkForNull(vrs.getString("deceased_date"));
				relgn_code=checkForNull(vrs.getString("RELGN_CODE"));
				relgn_desc=checkForNull(vrs.getString("RELGN_DESC"));
			}
			
			

			if(vrs!=null) vrs.close();
			if(pstmt2!=null)pstmt2.close();

			
		}
		
			
		
		pstmt2  = con.prepareStatement("select count(*) from pr_encounter where facility_id= ?  and patient_id= ?");	
		
        if(external.equals("Y")){
			pstmt2.setString(1,dec_fac_id);
		}else{
			pstmt2.setString(1,facilityId);
		}
		pstmt2.setString(2,patient_id);
		
		vrs = pstmt2.executeQuery();
            if(vrs.next())
            {
           prevencdis="";
				
            }else
			 {
			   prevencdis="disabled";
			 }
        if (vrs!=null) vrs.close();
		 if(pstmt2!=null) pstmt2.close();

		
				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(con, facilityId); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
		
		
		
		
		pstmt2  = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
        vrs = pstmt2.executeQuery();
        if (vrs!=null)
        {
            while (vrs.next())
            {
                sys_date = vrs.getString(1);
				burial_perm_date=sys_date;
            }
        }if (vrs!=null) vrs.close();
		 if(pstmt2!=null) pstmt2.close();

		if(sys_date!=null && !sys_date.equals(""))
		{
			sys_date_cnv = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 	
		}

		//pstmt2 = con.prepareStatement("select func_role_id from sm_appl_user where appl_user_id = ? ");
		pstmt2 = con.prepareStatement("select a.func_role_id func_role_id, b.pract_type pract_type from sm_appl_user a, am_practitioner b where 		a.appl_user_id = ? and a.func_role_id=b.practitioner_id");
		pstmt2.setString(1,user_id);
		vrs = pstmt2.executeQuery();	
		
		while(vrs.next())
			 {							
				func_role_id		= checkForNull(vrs.getString("func_role_id"));				
				role_pract_type		= vrs.getString("pract_type");
			 }
			 
		
		//pstmt2  = con.prepareStatement("select PATIENT_ID, PATIENT_NAME, SEX, DATE_OF_BIRTH, AGE, DECEASED_DATE, DEATH_STATUS_REMARKS, RELGN_CODE, RELGN_DESC, CITIZEN_YN, FACILITY_ID, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, ASSIGN_CARE_LOCN_CODE, LOCATION, TREATMENT_AREA_CODE, TREATMENT_AREA_DESC, ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DISCHARGE_DATE_TIME, SPECIALTY_CODE, SPECIALTY_DESC, ATTEND_PRACTITIONER_ID, ATTEND_PRACT_NAME, DISCH_PRACTITIONER_ID, DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_ID, REFERRAL_TYPE, REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, REFERRAL_DESC, REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?");

		if(external.equals("Y") && dec_enc_id.equals("")){
			

			pstmt2  = con.prepareStatement("select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"' ");		
			vrs = pstmt2.executeQuery();
			if((vrs!=null) && vrs.next()){
				burial_permit_reqd_yn= checkForNull(vrs.getString("BURIAL_PERMIT_REQD_YN"));
			}

			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}
		}
		String enc_query="";
		/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013 Start*/
		
		
		/*if(external.equals("Y") && !dec_enc_id.equals("")){
			enc_query="select a.PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id, assign_care_locn_code,'"+localeName+"',1)) LOCATION,MLC_YN, DISCH_PRACTITIONER_ID,(select PRACT_TYPE from am_practitioner where practitioner_id=a.DISCH_PRACTITIONER_ID) DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',2) DISCH_PRACT_NAME,  PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, '' REGN_ALLOWED_IN_MO_YN, '' BURIAL_PERMIT_NO, '' REFERRAL_TYPE, ''REFERRAL_TYPE_DESC,'' HCARE_SETTING_TYPE, ''  HCARE_SETTING_TYPE_DESC,'' REF_SOURCE_CODE, '' REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn, '' REFERRED_BY from PR_ENCOUNTER a,mp_patient b where a.patient_id = ? and a.patient_id=b.patient_id and a.facility_id='"+dec_fac_id+"' and a.encounter_id="+dec_enc_id;
		}else{
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',2) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?";
		}*/

		String external_rec_exists	= "N";
		String latest_facility_id	= "";
		
			String qry_latest_facility_id	= "select a.FACILITY_ID from mo_mortuary_regn a  where   a.patient_id=? order by a.ADDED_DATE desc";
			pstmt2  = con.prepareStatement(qry_latest_facility_id);
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();
			if(vrs!=null){
				if(vrs.next()){
					latest_facility_id	= vrs.getString("FACILITY_ID");
				}
			}
					
			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}
			int external_rec_count	= 0; 
			String latest_claiment_fac_id	= "";
			String latest_claiment_regn_no	= "";
		
			String qry_external_rec_exists	= "select  a.FACILITY_ID,b.REGISTRATION_NO from mo_mortuary_regn a,mo_claimant b where a.REGISTRATION_NO=b.REGISTRATION_NO and  a.patient_id=? order by a.ADDED_DATE desc";
			pstmt2  = con.prepareStatement(qry_external_rec_exists);
			pstmt2.setString(1,patient_id);
			vrs = pstmt2.executeQuery();
			if(vrs!=null){
				while(vrs.next()){
					external_rec_exists	= "Y";
					external_rec_count++;
					if(external_rec_count==1){
						latest_claiment_fac_id	= vrs.getString("FACILITY_ID");
						latest_claiment_regn_no	= vrs.getString("REGISTRATION_NO");
					}
				}
			}
			
			if(pstmt2 != null) {
				pstmt2.close();
			}
			if(vrs != null) {
				vrs.close();
			}

		
		

		if(external_rec_exists.equals("Y") && external.equals("Y")){
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ? ";
		}
		else if(external.equals("Y") && !dec_enc_id.equals("")){
			enc_query="select a.PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N', IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id, assign_care_locn_code,'"+localeName+"',1)) LOCATION,MLC_YN, DISCH_PRACTITIONER_ID,(select PRACT_TYPE from am_practitioner where practitioner_id=a.DISCH_PRACTITIONER_ID) DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME,  PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, '' REGN_ALLOWED_IN_MO_YN, '' BURIAL_PERMIT_NO, '' REFERRAL_TYPE, ''REFERRAL_TYPE_DESC,'' HCARE_SETTING_TYPE, ''  HCARE_SETTING_TYPE_DESC,'' REF_SOURCE_CODE, '' REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn, '' REFERRED_BY from PR_ENCOUNTER a,mp_patient b where a.patient_id = ? and a.patient_id=b.patient_id and a.facility_id='"+dec_fac_id+"' and a.encounter_id="+dec_enc_id;
		}else{
			enc_query="select PATIENT_ID, DECEASED_DATE, DATE_OF_BIRTH , SEX, SPECIALTY_CODE , RELGN_CODE,mp_get_desc.mp_religion(relgn_code,'"+localeName+"',2) RELGN_DESC, ENCOUNTER_ID, VISIT_ADM_DATE_TIME, PATIENT_CLASS, ASSIGN_CARE_LOCN_TYPE, assign_care_locn_code, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id, assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION, DISCH_PRACTITIONER_ID, DISCH_PRACT_TYPE, am_get_desc.AM_PRACTITIONER(disch_practitioner_id,'"+localeName+"',1) DISCH_PRACT_NAME, MLC_YN, PM_YN, HIGH_RISK_YN, POL_REP_NO, POL_STN_ID, POL_ID, BODY_RELEASE_DATE_TIME, BROUGHT_DEAD_YN, REGN_ALLOWED_IN_MO_YN, BURIAL_PERMIT_NO, REFERRAL_TYPE, REFERRAL_TYPE REFERRAL_TYPE_DESC, HCARE_SETTING_TYPE, am_get_desc.AM_HCARE_SETTING_TYPE(HCARE_SETTING_TYPE,'"+localeName+"',2) HCARE_SETTING_TYPE_DESC, REF_SOURCE_CODE, am_get_desc.AM_REFERRAL(REF_SOURCE_CODE,'"+localeName+"',2) REFERRAL_DESC ,( select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+facilityId+"')burial_permit_reqd_yn,  REFERRED_BY from MO_ENCOUNTER_DTLS_VW where patient_id = ?";
		}//Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
		
		/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013 End*/

		pstmt2  = con.prepareStatement(enc_query);

		
		pstmt2.setString(1,patient_id);
		vrs = pstmt2.executeQuery();
		if(vrs!=null)
		 {
			while(vrs.next())
			 {
	
				encounter_id			= checkForNull(vrs.getString("encounter_id"));
				visit_adm_date_time		= checkForNull(vrs.getString("visit_adm_date_time"));
				date_of_birth			= checkForNull(vrs.getString("DATE_OF_BIRTH"));
				sex					    = checkForNull(vrs.getString("SEX"));
				splty_code				= checkForNull(vrs.getString("SPECIALTY_CODE"));
				patient_class			= checkForNull(vrs.getString("patient_class"));
				location				= checkForNull(vrs.getString("location"));			
				locn_code				= checkForNull(vrs.getString("assign_care_locn_code"));			
				locn_type				= checkForNull(vrs.getString("ASSIGN_CARE_LOCN_TYPE"));			
				burial_permit_appr_by_name= checkForNull(vrs.getString("disch_pract_name"));
				burial_permit_reqd_yn= checkForNull(vrs.getString("BURIAL_PERMIT_REQD_YN"));

				burial_perm_by = checkForNull(vrs.getString("disch_practitioner_id"));
				//dis_pract_type = checkForNull(vrs.getString("DISCH_PRACT_TYPE"));
	
				deceased_date			= checkForNull(vrs.getString("deceased_date"));	
				if(deceased_date!=null && !deceased_date.equals(""))
				{
					deceased_date_cnv = DateUtils.convertDate(deceased_date,"DMYHM","en",localeName); 	
				}
				mlc_yn					= checkForNull(vrs.getString("mlc_yn"),"N");
				high_risk_body_yn       = checkForNull(vrs.getString("HIGH_RISK_YN"),"N");
				postmortem_status			= checkForNull(vrs.getString("PM_YN"),"N");
				
				pol_rep_no				= checkForNull(vrs.getString("pol_rep_no"));
				pol_stn_id				= checkForNull(vrs.getString("pol_stn_id"));
				pol_id					= checkForNull(vrs.getString("pol_id"));
				body_release_date_time  = checkForNull(vrs.getString("body_release_date_time"));

				if(body_release_date_time!=null && !body_release_date_time.equals(""))
				{
					body_release_date_time_cnv = DateUtils.convertDate(body_release_date_time,"DMYHM","en",localeName); 	
				}

				referral_type           =checkForNull(vrs.getString("referral_type"));
				referral_type_desc      =checkForNull(vrs.getString("referral_type_desc"));

				if( referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("L"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
				}
				else if(referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("E"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
				}
				else if(referral_type_desc!=null && !referral_type_desc.equals("") && referral_type_desc.equals("X"))
				{
					referral_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}

				hcare_setting_type      =checkForNull(vrs.getString("hcare_setting_type"));
				hcare_setting_type_desc =checkForNull(vrs.getString("hcare_setting_type_desc"));
				ref_source_code         =checkForNull(vrs.getString("ref_source_code"));
				referral_desc           =checkForNull(vrs.getString("referral_desc"));
				referred_by   	        =checkForNull(vrs.getString("referred_by"));
                relgn_code=checkForNull(vrs.getString("RELGN_CODE"));
				relgn_desc=checkForNull(vrs.getString("RELGN_DESC"));		
				
				brought_dead_yn			= checkForNull(vrs.getString("brought_dead_yn"),"N");
			    regn_allowed_in_mo_yn=checkForNull(vrs.getString("regn_allowed_in_mo_yn"));
				//Commented below line and added it out of this while loop (for patients without encounter)
			    //if (mode.equals("modify")||mode.equals("viewdata"))regn_allowed_in_mo_yn="Y";				
				
				if(func_role_id==null||func_role_id=="") 
				{
					deathcseregby	=	burial_perm_by;
					pract_type		=	checkForNull(vrs.getString("DISCH_PRACT_TYPE"));
				}
				else
				{
					deathcseregby = func_role_id;
					pract_type    = role_pract_type;
				}

				/*
				if(brought_dead_yn.equals("Y"))
				{
					burial_perm_by="";
				}
				*/
			}
		}
		if(vrs!=null) vrs.close();
		if(pstmt2!=null) pstmt2.close();
		if (mode.equals("modify")||mode.equals("viewdata"))regn_allowed_in_mo_yn="Y";//Added by Thamizh selvi on 19th Sep 2017 against [IN:065280]
	//if(mode.equals("modify")||mode.equals("viewdata")).
	/*Modified For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
	if(mode.equals("modify")||mode.equals("viewdata") || (external.equals("Y")))	
	{
	//pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY, CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE, DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM,     BODY_FOUND_AT from mo_mortuary_regn_vw where patient_id = ?");

	 /*Below  line(s) DEATH_CODE_AFTER_POSTMRM column added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572]*/
	
	 
	 //pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO,RFID_TAG_NUM, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, am_get_desc.AM_PRACTITIONER(police_approval_received_by,'"+localeName+"',2) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY,    am_get_desc.AM_PRACTITIONER(consent_form_received_by,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE,    DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, am_get_desc.AM_PRACTITIONER(CONSENT_FORM_RECEIVED_BY2,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY,     am_get_desc.AM_PRACTITIONER(BURIAL_PERMIT_APPROVED_BY,'"+localeName+"',2) BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM, BODY_FOUND_AT,ACTUAL_DEATH_MANNER_CODE from mo_mortuary_regn_vw where patient_id = ?");
	
	 /* FACILITY_ID Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013*/
	 pstmt2  = con.prepareStatement("select REGISTRATION_NO, UNCLAIMED_BODY_YN, BODY_RECEIVED_DATE, HIGH_RISK_BODY_YN, DEATH_MANNER_CODE, BODY_COND_CODE, PLACE_OF_DEATH, DEATH_CERTIFICATE_REQD_YN, IDENTIFICATION_MARKS, MLC_YN, BROUGHT_BY_POLICE_YN, SERVICE_CODE, PM_YN, POSTMORTEM_TYPE, AREA_CODE, BED_NO,RFID_TAG_NUM, AREA_TYPE, ASSIGN_DATE_TIME, POL_REP_NO, POL_STN_ID, POL_ID, POLICE_DTLS, POLICE_APPROVAL_RECEIVED_YN, POLICE_APPROVAL_RECEIVED_BY, am_get_desc.AM_PRACTITIONER(police_approval_received_by,'"+localeName+"',2) POLICE_APPROVAL_RECD_BY_NAME, POLICE_APPROVAL_RECEIVED_DATE, CONSENT_GIVEN_BY, RELATIONSHIP_WITH_DECEASED, CONSENT_FORM_CODE, CONSENT_FORM_RECEIVED_BY,    am_get_desc.AM_PRACTITIONER(consent_form_received_by,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME, CONSENT_FORM_RECEIVED_DATE,    DONOR_CARD_AVAILABLE_YN, DONOR_CARD_NO, DONOR_CARD_DETAILS, CONSENT_GIVEN_BY2, RELATIONSHIP_WITH_DECEASED2, CONSENT_FORM_CODE2, CONSENT_FORM_RECEIVED_BY2, am_get_desc.AM_PRACTITIONER(CONSENT_FORM_RECEIVED_BY2,'"+localeName+"',2) CONSENT_FORM_RECD_BY_NAME2, CONSENT_FORM_RECEIVED_DATE2, POSTMORTEM_STATUS, BURIAL_PERMIT_NO, BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPR_BY_NAME, CLAIM_DATE_TIME, VEHICLE_NUM, BODY_FOUND_AT,ACTUAL_DEATH_MANNER_CODE,external_bid_yn,police_officer_name, police_contact_no,BURIAL_PERMIT_APPROVED_DATE from mo_mortuary_regn_vw where patient_id = ? and FACILITY_ID=?");//Modified by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-0689
	 //Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
	 //Modified by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423


	pstmt2.setString(1,patient_id);
	/*Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 Start*/
	
	if(external.equals("Y") && mode.equals("insert")){
		pstmt2.setString(2,latest_facility_id);	
	}else{
		pstmt2.setString(2,facilityId);	
	}
	/*Added For Bru-HIMS-CRF-0368 By Dharma on 3rd Dec 2013 End*/
	vrs = pstmt2.executeQuery();
	while(vrs.next())
		 {
	regn_no=vrs.getString("registration_no")==null?"":vrs.getString("registration_no"); 	
	vechile_no=vrs.getString("VEHICLE_NUM")==null?"":vrs.getString("VEHICLE_NUM"); 	
	if(!mode.equals("insert")){
		postmortem_startend_status 	= vrs.getString("POSTMORTEM_STATUS")==null?"":vrs.getString("POSTMORTEM_STATUS"); 
	}else{
		postmortem_startend_status	= "";
	}
	
	burial_permit_appr_by_name=vrs.getString("burial_permit_appr_by_name")==null?"":vrs.getString("burial_permit_appr_by_name"); 	donor_card_available_yn=vrs.getString("donor_card_available_yn")==null?"":vrs.getString("donor_card_available_yn"); 
	body_claiming_date_time=vrs.getString("CLAIM_DATE_TIME")==null?"":vrs.getString("CLAIM_DATE_TIME"); 

	burial_perm_no=vrs.getString("BURIAL_PERMIT_NO")== null?"":vrs.getString("BURIAL_PERMIT_NO");
    body_found_at=vrs.getString("BODY_FOUND_AT")== null?"":vrs.getString("BODY_FOUND_AT");
	burial_perm_by=vrs.getString("BURIAL_PERMIT_APPROVED_BY") == null?"":vrs.getString("BURIAL_PERMIT_APPROVED_BY");
	area_type=vrs.getString("area_type") == null?"":vrs.getString("area_type");
	/* Below line(s) added by Venkatesh.S on 12-Nov-2013 against Bru-HIMS-CRF-365 [IN:039572] and 45192*/
	death_after_potmrtm=vrs.getString("ACTUAL_DEATH_MANNER_CODE") == null?"":vrs.getString("ACTUAL_DEATH_MANNER_CODE");
	/*Added by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-0689 Start*/
	extBidYnFrmVw		= vrs.getString("external_bid_yn");
	pol_officer_name	= vrs.getString("police_officer_name") == null?"":vrs.getString("police_officer_name");
	pol_contact_no		= vrs.getString("police_contact_no") == null?"":vrs.getString("police_contact_no");
	/*End*/
	if(death_after_potmrtm.equals(""))  
	  {death_after_potmrtm_yn="disabled";}
	if(burial_perm_no!="")
	{
	readText="readOnly";
	disablebut="disabled";
	
	}else
	{
	blurData="onBlur=document.getElementById('body_burial_permit_no').focus();";
	}
	body_received_date=vrs.getString("body_received_date")==null?"":vrs.getString("body_received_date");

	if(body_received_date!=null && !body_received_date.equals(""))
	{
		body_received_date_cnv = DateUtils.convertDate(body_received_date,"DMYHM","en",localeName); 	
	}
	
	death_manner_code=vrs.getString("death_manner_code")==null?"":vrs.getString("death_manner_code"); 
	body_cond_code=vrs.getString("body_cond_code")==null?"":vrs.getString("body_cond_code"); 
	high_risk_body_yn= vrs.getString("high_risk_body_yn")==null?"":vrs.getString("high_risk_body_yn"); 
	unclaimed_body_yn=vrs.getString("unclaimed_body_yn")==null?"":vrs.getString("unclaimed_body_yn"); 
	if(unclaimed_body_yn.equals("N"))disunclim="disabled";
	death_certificate_reqd_yn= vrs.getString("death_certificate_reqd_yn")==null?"":vrs.getString("death_certificate_reqd_yn"); 
	brought_by_police_yn= vrs.getString("brought_by_police_yn")==null?"":vrs.getString("brought_by_police_yn"); 
	mlc_yn= vrs.getString("mlc_yn")==null?"":vrs.getString("mlc_yn"); 
	

	//Below condition Added For Bru-HIMS-CRF-0368 By Dharma on 16th Dec 2013
	if(!external.equals("Y") || !mode.equals("insert")){
		service_code=  vrs.getString("service_code")==null?"":vrs.getString("service_code");
		area_code=vrs.getString("area_code")==null?"":vrs.getString("area_code");
		bed_no= vrs.getString("bed_no")==null?"":vrs.getString("bed_no"); 
		rfid_tag_num= vrs.getString("RFID_TAG_NUM")==null?"":vrs.getString("RFID_TAG_NUM"); 
		assign_date_time=vrs.getString("assign_date_time")==null?"":vrs.getString("assign_date_time"); 
	}

	if(assign_date_time!=null && !assign_date_time.equals(""))
	{
		assign_date_time_cnv = DateUtils.convertDate(assign_date_time,"DMYHM","en",localeName); 	
	}

	pol_rep_no				= checkForNull(vrs.getString("pol_rep_no"));
	pol_stn_id				= checkForNull(vrs.getString("pol_stn_id"));
	pol_id					= checkForNull(vrs.getString("pol_id"));
	police_approval_received_yn	= checkForNull(vrs.getString("police_approval_received_yn"));
	police_received_by					= checkForNull(vrs.getString("police_approval_received_by"));
	police_approval_received_by_desc=checkForNull(vrs.getString("POLICE_APPROVAL_RECD_BY_NAME"));
	police_received_date					= checkForNull(vrs.getString("police_approval_received_date"));

	if(police_received_date!=null && !police_received_date.equals(""))
	{
		police_received_date = DateUtils.convertDate(police_received_date,"DMYHM","en",localeName); 	
	}
				
	police_details=vrs.getString("police_dtls")==null?"":vrs.getString("police_dtls");   identification_marks=vrs.getString("identification_marks")==null?"":vrs.getString("identification_marks");   
	place_of_death=vrs.getString("place_of_death")==null?"":vrs.getString("place_of_death");    
	postmortem_type= vrs.getString("postmortem_type")==null?"":vrs.getString("postmortem_type"); postmortem_status=vrs.getString("PM_YN")==null?"":vrs.getString("PM_YN"); 
	consent_given_by =vrs.getString("consent_given_by")==null?"":vrs.getString("consent_given_by");           
	relationship_with_deceased= vrs.getString("relationship_with_deceased")==null?"":vrs.getString("relationship_with_deceased"); 
	consent_form_code= vrs.getString("consent_form_code")==null?"":vrs.getString("consent_form_code"); 
		  
	consent_form_received_by = vrs.getString("consent_form_received_by")==null?"":vrs.getString("consent_form_received_by");   
	consent_form_received_date=vrs.getString("consent_form_received_date")==null?"":vrs.getString("consent_form_received_date"); 

	consent_form_code1=vrs.getString("CONSENT_FORM_CODE2")==null?"":vrs.getString("CONSENT_FORM_CODE2");
	conscentgivenby1=vrs.getString("CONSENT_GIVEN_BY2")==null?"":vrs.getString("CONSENT_GIVEN_BY2");
	deceasedrelationship1=vrs.getString("RELATIONSHIP_WITH_DECEASED2")==null?"":vrs.getString("RELATIONSHIP_WITH_DECEASED2");
	consent_received_by1=vrs.getString("CONSENT_FORM_RECEIVED_BY2")==null?"":vrs.getString("CONSENT_FORM_RECEIVED_BY2");
	consent_received_date1=vrs.getString("CONSENT_FORM_RECEIVED_DATE2")==null?"":vrs.getString("CONSENT_FORM_RECEIVED_DATE2");
	donar_card_no=vrs.getString("DONOR_CARD_NO")==null?"":vrs.getString("DONOR_CARD_NO");
    donar_card_details=vrs.getString("DONOR_CARD_DETAILS")==null?"":vrs.getString("DONOR_CARD_DETAILS");
	consent_form_recd_by_name2=vrs.getString("consent_form_recd_by_name2")==null?"":vrs.getString("consent_form_recd_by_name2");
	consent_form_recd_by_name=vrs.getString("consent_form_recd_by_name")==null?"":vrs.getString("consent_form_recd_by_name");
	burial_permit_approved_date=vrs.getString("burial_permit_approved_date")==null?"":vrs.getString("burial_permit_approved_date"); //Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
			 } 
		}
		   if(vrs!=null) vrs.close();
		   if(pstmt2!=null) pstmt2.close();

	
	pstmt2  = con.prepareStatement("select ALT_ID1_TYPE,NAT_ID_PROMPT,ACCEPT_OTH_ALT_ID_YN ,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_LENGTH from MP_PARAM");
	vrs = pstmt2.executeQuery();
	 	 
   if(vrs.next())
	{
	
	nat_id_prompt           =vrs.getString("nat_id_prompt")==null?"":vrs.getString("nat_id_prompt");
	nat_id_length    =vrs.getString("NAT_ID_LENGTH")==null?"":vrs.getString("NAT_ID_LENGTH");
	accept_national_id_no_yn =vrs.getString("ACCEPT_OTH_ALT_ID_YN")==null?"":vrs.getString("ACCEPT_OTH_ALT_ID_YN");
	}
	  
	  
	  
	  
	//  if(mode.equals("modify")||mode.equals("viewdata") )
/*Modified For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
		
		//Added for Default Previous Claimant Details start 
		String default_claimant_type			= "";
		String default_claimant_type_code		= "";
		String default_relationship				= "";
		String default_name						= "";
		String default_job_title				= "";
		String default_addrl1					= "";
		String default_addrl2					= "";
		String default_addrl3					= "";
		String default_addrl4					= "";
		String default_postal_code				= "";
		String default_country_desc				= "";
		String default_country_code				= "";
		String default_zip_code					= "";
		String default_res_town_code			= "";
		String default_res_area_code			= "";
		String default_region_code				= "";
		String default_res_town_desc			= "";
		String default_res_area_desc			= "";
		String default_region_desc				= "";
		String default_telephone_off			= "";
		String default_telephone_res			= "";
		String default_email_id					= "";
		String default_mob_tel_no				= "";
		String default_nat_id_no				= "";
		String default_organization_name		= "";
		String default_patient_employee_id		= "";

		//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
		String default_Passport_No				= "";
		String default_Other_Identification		= "";

		String default_RELEASE_TO_FACILITY		= "";
		String default_reason_deceased_desc		= "";
		
		
		
		if(external_rec_exists.equals("Y") && external.equals("Y")){
			  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE,CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION, REGION_DESC,RES_AREA_DESC,RES_TOWN_DESC,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ?");
			  pstmt2.setString(1,latest_claiment_regn_no);
			  vrs = pstmt2.executeQuery();
			  if(vrs.next()) {
				 
				  default_claimant_type				= vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
				  default_claimant_type_code		= vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
				  default_relationship				= vrs.getString("relationship")==null?"":vrs.getString("relationship");
				  default_name						= vrs.getString("name")==null?"":vrs.getString("name");
				  default_job_title					= vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
				  default_addrl1					= vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
				  default_addrl2					= vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
				  default_addrl3					= vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
				  default_addrl4					= vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
				  default_postal_code				= vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
				  default_country_code				= vrs.getString("country_code")==null?"":vrs.getString("country_code");
				  default_zip_code					= postal_code;
				  default_res_town_code				= vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
				  default_res_area_code				= vrs.getString("res_area_code")==null?"":vrs.getString("res_area_code");
				  default_region_code				= vrs.getString("region_code")==null?"":vrs.getString("region_code");
				  default_res_town_desc				= vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
				  default_res_area_desc				= vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
				  default_region_desc				= vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
				  default_telephone_off				= vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
				  default_telephone_res				= vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
				  default_email_id					= vrs.getString("email_id")==null?"":vrs.getString("email_id");
				  default_mob_tel_no				= vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
				  default_nat_id_no					= vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
				  default_organization_name			= vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
				  default_patient_employee_id		= vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id"); 

				  //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
				  default_Passport_No				= vrs.getString("Passport_No")==null?"":vrs.getString("Passport_No");
				  default_Other_Identification		= vrs.getString("Other_Identification")==null?"":vrs.getString("Other_Identification");

				  default_RELEASE_TO_FACILITY		= vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
				  default_reason_deceased_desc		= vrs.getString("REASON")==null?"":vrs.getString("REASON");
				}
			   if(vrs!=null) vrs.close();
			   if(pstmt2!=null) pstmt2.close();
			   if(!default_country_code.equals("")){
				  	String sqlcountry = "select short_name from mp_country_lang_vw where language_id = '"+localeName+"' and country_code = '"+default_country_code+"'";
	
					pstmt2  = con.prepareStatement(sqlcountry);
			        vrs = pstmt2.executeQuery();
			    	while( vrs.next()){
			    		default_country_desc=checkForNull(vrs.getString("short_name"));
					}
					if(vrs!=null) vrs.close();
					if(pstmt2!=null) pstmt2.close();
			   }
			   
			   
		}
		//Added for Default Previous Claimant Details End	
		if(mode.equals("modify")||mode.equals("viewdata") || (external_rec_exists.equals("N") && external.equals("Y"))){	
		  /*Below query modified for this CRF Bru-HIMS-CRF-366*/    

		  pstmt2  = con.prepareStatement("select FACILITY_ID, REGISTRATION_NO, CLAIMANT_TYPE,CLAIMANT_TYPE_CODE, RELATIONSHIP, NAME, JOB_TITLE, ADD_LINE1, ADD_LINE2, ADD_LINE3, ADD_LINE4, ZIP_CODE, COUNTRY_CODE, RES_TOWN_CODE, RES_AREA_CODE, REGION_CODE, TELEPHONE_OFF, TELEPHONE_RES, EMAIL_ID, MOB_TEL_NO, NAT_ID_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,PASSPORT_NO,OTHER_IDENTIFICATION,REGION_DESC,RES_AREA_DESC,RES_TOWN_DESC,RELEASE_TO_FACILITY,REASON from mo_claimant_vw where  REGISTRATION_NO = ?");
		  
		  
		  pstmt2.setString(1,regn_no);
		  vrs = pstmt2.executeQuery();
		  while(vrs.next())
		 {
		
		claimant_type=vrs.getString("CLAIMANT_TYPE")==null?"":vrs.getString("CLAIMANT_TYPE"); 
	    claimant_type_code=vrs.getString("claimant_type_code")==null?"":vrs.getString("claimant_type_code");
		relationship=vrs.getString("relationship")==null?"":vrs.getString("relationship");
		name=vrs.getString("name")==null?"":vrs.getString("name");
		job_title=vrs.getString("job_title")==null?"":vrs.getString("job_title"); 
		addrl1=vrs.getString("add_line1")==null?"":vrs.getString("add_line1");
		addrl2=vrs.getString("add_line2")==null?"":vrs.getString("add_line2"); 
		addrl3=vrs.getString("add_line3")==null?"":vrs.getString("add_line3");
		addrl4=vrs.getString("add_line4")==null?"":vrs.getString("add_line4");
		
		
		postal_code=vrs.getString("zip_code")==null?"":vrs.getString("zip_code");
		
		country_code=vrs.getString("country_code")==null?"":vrs.getString("country_code");
		zip_code=postal_code;
		res_town_code=vrs.getString("res_town_code")==null?"":vrs.getString("res_town_code"); 
		res_area_code=vrs.getString("res_area_code")==null?"":vrs.getString("res_area_code");
		region_code=vrs.getString("region_code")==null?"":vrs.getString("region_code");
		
		res_town_desc=vrs.getString("res_town_desc")==null?"":vrs.getString("res_town_desc"); 
		res_area_desc=vrs.getString("res_area_desc")==null?"":vrs.getString("res_area_desc");
		region_desc=vrs.getString("region_desc")==null?"":vrs.getString("region_desc");
		
		telephone_off=vrs.getString("telephone_off")==null?"":vrs.getString("telephone_off"); 
		telephone_res=vrs.getString("telephone_res")==null?"":vrs.getString("telephone_res");
		email_id=vrs.getString("email_id")==null?"":vrs.getString("email_id");
		mob_tel_no=vrs.getString("mob_tel_no")==null?"":vrs.getString("mob_tel_no"); 
		nat_id_no=vrs.getString("nat_id_no")==null?"":vrs.getString("nat_id_no");
	   
		organization_name=vrs.getString("organization_name")==null?"":vrs.getString("organization_name");
	   patient_employee_id=vrs.getString("patient_employee_id")==null?"":vrs.getString("patient_employee_id"); 

	   //Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
	   Passport_No=vrs.getString("Passport_No")==null?"":vrs.getString("Passport_No");
	   Other_Identification=vrs.getString("Other_Identification")==null?"":vrs.getString("Other_Identification");

		RELEASE_TO_FACILITY = vrs.getString("RELEASE_TO_FACILITY")==null?"":vrs.getString("RELEASE_TO_FACILITY");
		
		reason_deceased_desc= vrs.getString("REASON")==null?"":vrs.getString("REASON"); //this line Added for this CRF -Bru-HIMS-CRF-366


		 }
		  
	  if(vrs!=null) vrs.close();
     if(pstmt2!=null) pstmt2.close();

	 if(claimant_type.equals("E"))
	  {
	  pstmt2  = con.prepareStatement("select b.short_desc ocpn_class_desc from mp_occupation a, MP_OCCUPATION_CLASS_LANG_VW b, mp_pat_rel_contacts c where a.OCPN_CODE=c.OCPN_CODE and  a.OCPN_CLASS_CODE=b.OCPN_CLASS_CODE and c.patient_id=?");
	  pstmt2.setString(1,patient_id);
	  vrs = pstmt2.executeQuery();
	  while(vrs.next())
	  {
	  
	  ocpn_class_desc=vrs.getString("ocpn_class_desc");
	  }
	  }
	  
	  }
	  
	  


	  if(body_claiming_date_time.equals(""))
	  {
		body_claiming_date_time=sys_date;
	  }

		if(external.equals("Y") || mode.equals("viewdata")){//modified against [IN:068178]
			regn_allowed_in_mo_yn="Y";

			deceased_date_cnv = DateUtils.convertDate(dec_dt_time,"DMYHM","en",localeName); 	
			
		}
				
	
	 	 
	  if(regn_allowed_in_mo_yn.equals("Y") )
	  {
        if(encounter_id!="") {

		if(external.equals("Y")){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dec_enc_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dec_fac_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block16Bytes, _wl_block16);
}else {
		  if(external.equals("Y") && ! dec_enc_id.equals("")){
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dec_enc_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dec_fac_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
		}
		
  
		int maxrecord = 0;

		//Added by Kamatchi S on 12/10/2019 for ML-MMOH-SCF-1423
		if(!burial_permit_approved_date.equals("")){
			burial_perm_date =burial_permit_approved_date;
		}


		if((postmortem_status.equals("N") || postmortem_status.equals("")|| postmortem_startend_status.equals("E"))&& (burial_perm_no.equals("")))
		  {
			pstmt2=con.prepareStatement("select BURIAL_PERMIT_NO,BURIAL_PERMIT_APPROVED_BY, BURIAL_PERMIT_APPROVED_BY_NAME, BURIAL_PERMIT_APPROVED_DATE from MO_BURIAL_PERMIT_VW where patient_id='"+patient_id+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Modified by Ashwini on 01-Jul-2019 for ML-MMOH-CRF-0990
			vrs = pstmt2.executeQuery();
			if(vrs != null)
			  {
				 vrs.last();
				 maxrecord=vrs.getRow();
			
				 if(maxrecord == 0)
				  {
					 readText="";
					 disablebut="";
				  }
				 else
				 {
					readText="readOnly";
					disablebut="disabled";
 				    vrs.beforeFirst();
				while(vrs.next())
				 {
				burial_perm_no=vrs.getString("BURIAL_PERMIT_NO");
						
				burial_perm_by=vrs.getString("BURIAL_PERMIT_APPROVED_BY")==null?burial_perm_by:vrs.getString("BURIAL_PERMIT_APPROVED_BY");
				burial_permit_appr_by_name=vrs.getString("BURIAL_PERMIT_APPROVED_BY_NAME")==null?burial_permit_appr_by_name:vrs.getString("BURIAL_PERMIT_APPROVED_BY_NAME");
				burial_perm_date=vrs.getString("BURIAL_PERMIT_APPROVED_DATE");
					  }

				 }
			  }
			  if(vrs != null) vrs.close();
			  if(pstmt2 != null) pstmt2.close();
		   }


	  		   
     if(postmortem_status.equals("Y"))checkpm="Checked" ;else checkpm="";
	if(mlc_yn.equals("Y"))checkmlc="Checked"; else checkmlc="";
/*
	//Added by Ashwin K for ML-MMOH-CRF-1891
String finalize_yn = "";

String finalize_query = "SELECT    c.finalize_yn as finalize_yn FROM pr_encounter a,mp_patient b,    mr_death_register_hdr c where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id  and a.facility_id = '"+facilityId+"' and a.facility_id =c.facility_id AND  a.patient_id like '"+patient_id+"'";

 System.err.println("finalize_query "+finalize_query);

	pstmt2=con.prepareStatement(finalize_query);
	vrs = pstmt2.executeQuery();
	if(vrs != null)
	{
		while(vrs.next())
		{
		finalize_yn=vrs.getString("finalize_yn");
		}
	}

	if(vrs != null) vrs.close();
	if(pstmt2 != null) pstmt2.close();

	 if(finalize_yn.equals(""))
		  {
		 finalize_yn="N" ;
		  }

		  System.err.println("finalize_yn "+finalize_yn);


//Ended by Ashwin K for ML-MMOH-CRF-1891

*/
/*Added by santhosh for ML-MMOH-CRF-1947 Start*/
	Boolean maxSizeBurialPermitAppl = false;
	 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
	 String max_size_burial_permit_no = "";
		sstat = con.createStatement();
		vrs = sstat.executeQuery("select NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO from mo_parameter a where  a.facility_id='"+facilityId+"' ");
		while(vrs.next())
		{
		   max_size_burial_permit_no = (maxSizeBurialPermitAppl)?vrs.getString("MAX_SIZE_BURIAL_PERMIT_NO"):"16";
		}
		if(vrs!=null) vrs.close();
		if(sstat!=null) sstat.close();
		
	/*END*/



	 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(postmortem_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(postmortem_startend_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(claimant_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(claimant_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(burial_permit_reqd_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(rearrangeTabBurlPermtClaimnt){
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(referral_type_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(referral_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(referred_by));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ref_source_code ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(referred_by));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(referral_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
if(relgn_code.equals("")){
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block57Bytes, _wl_block57);
}else
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(relgn_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(relgn_code));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
if(unclaimed_body_yn.equals("Y")){
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
if(mlcAndInfectiousDeceBodyApplicable){
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
if(high_risk_body_yn.equals("Y")){
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
 pstmt2 = con.prepareStatement("select death_manner_code,short_desc from mo_manner_of_death_lang_vw where eff_status='E' and language_id='"+localeName+"' order by 2");
					   vrs = pstmt2.executeQuery();
					  while(vrs.next())
						  {
							if(death_manner_code.equals(vrs.getString("death_manner_code"))){
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(vrs.getString("death_manner_code")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(vrs.getString("death_manner_code")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(place_of_death));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(mode.equals("modify") || mode.equals("viewdata")){
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(death_after_potmrtm_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

				          vrs = pstmt2.executeQuery();
						   while(vrs.next()){ 
						   if(death_after_potmrtm.equals(vrs.getString("death_manner_code"))){
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(vrs.getString("death_manner_code")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(vrs.getString("death_manner_code")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block88Bytes, _wl_block88);
} }
						   if(vrs!=null) vrs.close();
						   if(pstmt2!=null) pstmt2.close();
						   
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(body_found_at));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
 if(calledFrom.equals("MO_BID_REGN") || extBidYnFrmVw.equals("Y")){ 
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(mode.equals("viewdata")){
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
if(mode.equals("viewdata")){
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
 }else{ 
            _bw.write(_wl_block99Bytes, _wl_block99);
if(!brought_dead_yn.equals("Y")){
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block102Bytes, _wl_block102);
}else{
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(mode.equals("viewdata")){
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
if(mode.equals("viewdata")){
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
 } 
            _bw.write(_wl_block106Bytes, _wl_block106);
if(mode.equals("insert")){
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(body_found_at));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
            _bw.write(_wl_block110Bytes, _wl_block110);
if(! external.equals("Y")){
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(deathcseregby));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(siteCheck));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
if(isReceivedDateTimeAppl){

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(body_release_date_time_cnv));
            _bw.write(_wl_block119Bytes, _wl_block119);
if(isReceivedDateTimeAppl){
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
	// if(mode.equals("modify")||mode.equals("viewdata"))
						/*Added For Bru-HIMS-CRF-0368 By Dharma on 29th Nov 2013*/
						if(mode.equals("modify")||mode.equals("viewdata") || (external_rec_exists.equals("Y") && external.equals("Y")))	
							  {
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(body_received_date_cnv));
            _bw.write(_wl_block127Bytes, _wl_block127);
}else{
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(sys_date_cnv));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

						 pstmt2 = con.prepareStatement("select body_cond_code,short_desc from mo_body_condition_lang_vw where eff_status='E' and language_id='"+localeName+"'order by 2");
						vrs = pstmt2.executeQuery();
						while(vrs.next())
						{if(body_cond_code.equals(vrs.getString("body_cond_code"))){
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(vrs.getString("body_cond_code")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block134Bytes, _wl_block134);
}else{
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(vrs.getString("body_cond_code")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block137Bytes, _wl_block137);
}
						} if(vrs!=null) vrs.close();
						  if(pstmt2!=null) pstmt2.close();
						
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(identification_marks));
            _bw.write(_wl_block140Bytes, _wl_block140);
if(siteSpecific){
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
}else{
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
}
            _bw.write(_wl_block146Bytes, _wl_block146);
if(siteSpecific){
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
if(mlcAndInfectiousDeceBodyApplicable){
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}else{
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}}
            _bw.write(_wl_block150Bytes, _wl_block150);
 				
						 
						 if(area_type.equals("P")||area_type.equals("R")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("R")){
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(checkmlc));
            _bw.write(_wl_block154Bytes, _wl_block154);
}else{
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(checkmlc));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(mlc_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
}
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
if(brought_by_police_yn.equals("Y")){
            _bw.write(_wl_block160Bytes, _wl_block160);
}else{
            _bw.write(_wl_block161Bytes, _wl_block161);
}
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(police_details));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
 //Below line modified for this CRF  Bru-HIMS-CRF-407 [IN:045167]	
                        						
						 if(area_type.equals("R")||area_type.equals("P")|| regCount>0){
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(checkpm));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block169Bytes, _wl_block169);
}else
							{
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(checkpm));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
 if(postmortem_type.equals("C")){
							
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
}else{
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
 if(postmortem_type.equals("M")){
							
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
}else{
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(disabledyn));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

										int serviceCount = 0;
										sstat = con.createStatement();
										String DFLT_SERVICE_CODE	= "";
									   //vrs = sstat.executeQuery("select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+localeName+"',2) short_desc from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by short_desc");
									   //DFLT_SERVICE_CODE Added for Bru-HIMS-CRF-413 [IN:045501]
										vrs = sstat.executeQuery("select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+localeName+"',2) short_desc,(select DFLT_SERVICE_CODE from mo_parameter where facility_id=a.operating_facility_id) DFLT_SERVICE_CODE from AM_FACILITY_SERVICE_VW a where OPERATING_FACILITY_ID='"+facilityId+"' and dept_code =(select dept_code from mo_parameter where facility_id=a.operating_facility_id) and eff_status='E' order by short_desc");
									   while(vrs.next())
									   {
								
										 	  DFLT_SERVICE_CODE	= vrs.getString("DFLT_SERVICE_CODE");
										   
										   if(!service_code.equals("")){  
											   if(service_code.equals(vrs.getString("SERVICE_CODE"))){
													   
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(vrs.getString("SERVICE_CODE")));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block189Bytes, _wl_block189);
}else{
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(vrs.getString("SERVICE_CODE")));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block191Bytes, _wl_block191);
}
										   }else{
											   
											   if(vrs.getString("SERVICE_CODE").equals(DFLT_SERVICE_CODE)){
												   
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(vrs.getString("SERVICE_CODE")));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block193Bytes, _wl_block193);
}else{
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(vrs.getString("SERVICE_CODE")));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(vrs.getString("short_desc")));
            _bw.write(_wl_block194Bytes, _wl_block194);
}
											
										   
											   
										   }
										   
										   
										   
									serviceCount++;
									} 
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(serviceCount));
            _bw.write(_wl_block197Bytes, _wl_block197);

									   if(vrs!=null) vrs.close();
									   if(sstat!=null) sstat.close();
									  if(pstmt2!=null) pstmt2.close();
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(assign_date_time_cnv));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
  
						String disRFID = "";

						if((mode.equals("modify") && !rfid_tag_num.equals("")) || mode.equals("viewdata") )
							disRFID="disabled" ; 
						
				if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
				{
									
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(disRFID));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(disRFID));
            _bw.write(_wl_block210Bytes, _wl_block210);

				}
				
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
if(rearrangeTabBurlPermtClaimnt){
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block220Bytes, _wl_block220);
 
		if(body_claiming_date_time!=null && !body_claiming_date_time.equals(""))
		{
			body_claiming_date_time_cnv = DateUtils.convertDate(body_claiming_date_time,"DMYHM","en",localeName); 	
		}
		if(burial_perm_date!=null && !burial_perm_date.equals(""))
		{
			burial_perm_date_cnv = DateUtils.convertDate(burial_perm_date,"DMYHM","en",localeName); 	
		}
		
		
	//  Added against IN:45900 by Dharma on 23rd Dec 2013 Start
	String disable_date_of_claiming			= "";
	String disable_vehicle_no				= "";	
	String disable_burial_permit_app_by		= "";
	String disable_burial_permit_app_date	= "";
	
	if(external.equals("Y") && mode.equals("insert")) {	
		if(!body_claiming_date_time_cnv.equals("")){
			disable_date_of_claiming			= "disabled";
		}
		
		if(!vechile_no.equals("")){
			disable_vehicle_no			= "disabled";
		}
		
		if(!burial_perm_by.equals("")){
			disable_burial_permit_app_by			= "disabled";
		}
		
		if(!burial_perm_date_cnv.equals("")){
			disable_burial_permit_app_date			= "disabled";
		}
	}
	
	//  Added against IN:45900 by Dharma on 23rd Dec 2013 End
	
	/*Below line added for this ML-MMOH-CRF-0695*/
	if(datetimeofclaimingApplicable && !function_id.equals("Reg_Details")){
		   body_claiming_date_time_cnv = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 
		   datetimeofclaiming="disabled";
           disable_date_of_claiming= "";		   
	}else{
		   datetimeofclaiming=disablebut;
	}
	//End this CRF ML-MMOH-CRF-0695
	
	
	
            _bw.write(_wl_block221Bytes, _wl_block221);
	if(burial_perm_no.equals("")&&(!mode.equals("viewdata"))){
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
}else{
            _bw.write(_wl_block224Bytes, _wl_block224);
}
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(max_size_burial_permit_no));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(burial_perm_no));
            _bw.write(_wl_block228Bytes, _wl_block228);
if(isDateTimeOfDeathAppl){
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
if(calledFrom.equals("MO_BID_REGN") || extBidYnFrmVw.equals("Y") || brought_dead_yn.equals("Y")){
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block232Bytes, _wl_block232);
}else{
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block235Bytes, _wl_block235);
}
            _bw.write(_wl_block236Bytes, _wl_block236);
if(!isChangeOfDateTimeClaimingAppl && !datetimeOfClaimingAppl){
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(body_claiming_date_time_cnv));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(datetimeofclaiming));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_date_of_claiming));
            _bw.write(_wl_block240Bytes, _wl_block240);
if(!datetimeofclaimingApplicable){
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(datetimeofclaiming));
            _bw.write(_wl_block242Bytes, _wl_block242);
}
            _bw.write(_wl_block243Bytes, _wl_block243);
}
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(vechile_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable_vehicle_no));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);

		  if(brought_dead_yn.equals("Y")&&mlc_yn.equals("Y")&&postmortem_status.equals("Y"))
		  {	
	
            _bw.write(_wl_block248Bytes, _wl_block248);
if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_by));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(burial_perm_by));
            _bw.write(_wl_block253Bytes, _wl_block253);
}else{
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block256Bytes, _wl_block256);
}
            _bw.write(_wl_block257Bytes, _wl_block257);
}else if(mlc_yn.equals("Y")||postmortem_status.equals("Y"))
	 {
            _bw.write(_wl_block257Bytes, _wl_block257);
if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_by));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(burial_perm_by));
            _bw.write(_wl_block253Bytes, _wl_block253);
}else{
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block256Bytes, _wl_block256);
}
            _bw.write(_wl_block261Bytes, _wl_block261);
}
    else if(brought_dead_yn.equals("N")&&(mlc_yn.equals("Y")||postmortem_status.equals("Y")))
		  {
            _bw.write(_wl_block262Bytes, _wl_block262);
if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_by));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(burial_perm_by));
            _bw.write(_wl_block265Bytes, _wl_block265);
}else{
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block267Bytes, _wl_block267);
}
            _bw.write(_wl_block268Bytes, _wl_block268);
}
		else if(brought_dead_yn.equals("N")&&(!(mlc_yn.equals("Y")&&postmortem_status.equals("Y"))))
		  {
            _bw.write(_wl_block269Bytes, _wl_block269);
if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_by));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(burial_perm_by));
            _bw.write(_wl_block272Bytes, _wl_block272);
}else{
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block267Bytes, _wl_block267);
}
            _bw.write(_wl_block273Bytes, _wl_block273);
}	  
	  else{ 
            _bw.write(_wl_block274Bytes, _wl_block274);
if(!isRemoveMandBPermitAppBy){
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_by));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(burial_perm_by));
            _bw.write(_wl_block278Bytes, _wl_block278);
}else{
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block267Bytes, _wl_block267);
}
            _bw.write(_wl_block279Bytes, _wl_block279);
}
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(burial_perm_date_cnv));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(readText));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(disable_burial_permit_app_date));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(disablebut));
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
if(rearrangeTabBurlPermtClaimnt){
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block289Bytes, _wl_block289);
}
            _bw.write(_wl_block290Bytes, _wl_block290);

				
				if(external_rec_exists.equals("Y") && external.equals("Y") && mode.equals("insert")){	
            _bw.write(_wl_block291Bytes, _wl_block291);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block292Bytes, _wl_block292);
}
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(claimant_type_code));
            _bw.write(_wl_block295Bytes, _wl_block295);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);

								for(int i = 0 ; i < ClaimantTypeJsonArr.size() ; i++) 
								{
									JSONObject ClaimantTypeJson	= (JSONObject)ClaimantTypeJsonArr.get(i);
									String claimant_type_mstr_code = (String) ClaimantTypeJson.get("claimant_type_mstr_code");
									String claimant_short_desc = (String) ClaimantTypeJson.get("short_desc");
									out.println("<option value='"+claimant_type_mstr_code+"'>"+claimant_short_desc+"</option>");	
								}
							  
            _bw.write(_wl_block297Bytes, _wl_block297);
if(claimant_type.equals("K")){
            _bw.write(_wl_block298Bytes, _wl_block298);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block300Bytes, _wl_block300);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}			
								 if(claimant_type.equals("E")){
            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
								if(claimant_type.equals("M")){
            _bw.write(_wl_block303Bytes, _wl_block303);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
								if(claimant_type.equals("W")){
            _bw.write(_wl_block305Bytes, _wl_block305);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block306Bytes, _wl_block306);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
								if(claimant_type.equals("R")){
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block308Bytes, _wl_block308);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
							   if(claimant_type.equals("U")){
            _bw.write(_wl_block309Bytes, _wl_block309);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block310Bytes, _wl_block310);
}else{
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
}
								 if(claimant_type.equals("F")){
            _bw.write(_wl_block313Bytes, _wl_block313);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block314Bytes, _wl_block314);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
								 if(claimant_type.equals("O")){
            _bw.write(_wl_block315Bytes, _wl_block315);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}else{
            _bw.write(_wl_block316Bytes, _wl_block316);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
}
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block319Bytes, _wl_block319);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block322Bytes, _wl_block322);
if(datetimeOfClaimingAppl){
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);
if(mode.equals("insert")){
            _bw.write(_wl_block325Bytes, _wl_block325);
}else{
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(body_claiming_date_time));
            _bw.write(_wl_block327Bytes, _wl_block327);
}
            _bw.write(_wl_block328Bytes, _wl_block328);
if( datetime_claim_mand.equals("D")){
            _bw.write(_wl_block329Bytes, _wl_block329);
}
            _bw.write(_wl_block330Bytes, _wl_block330);
}else if(isChangeOfDateTimeClaimingAppl){
            _bw.write(_wl_block331Bytes, _wl_block331);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block332Bytes, _wl_block332);
if(mode.equals("insert")){
            _bw.write(_wl_block325Bytes, _wl_block325);
}else{
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(body_claiming_date_time));
            _bw.write(_wl_block327Bytes, _wl_block327);
}
            _bw.write(_wl_block333Bytes, _wl_block333);
if(functionid.equals("MO_REGN_DTLS_QUERY")){
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block334Bytes, _wl_block334);
}
            _bw.write(_wl_block335Bytes, _wl_block335);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block336Bytes, _wl_block336);
if(increasedaddressLength){
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(name));
            _bw.write(_wl_block338Bytes, _wl_block338);
}else{
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(name));
            _bw.write(_wl_block340Bytes, _wl_block340);
}
            _bw.write(_wl_block341Bytes, _wl_block341);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block342Bytes, _wl_block342);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block343Bytes, _wl_block343);
 pstmt2  = con.prepareStatement("select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP_LANG_VW where language_id='"+localeName+"' and eff_status='E' order by 2");
	 
				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 if(vrs.getString("RELATIONSHIP_CODE").equals(relationship))
					  {
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(vrs.getString("RELATIONSHIP_CODE")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(vrs.getString("SHORT_DESC")));
            _bw.write(_wl_block345Bytes, _wl_block345);
}else
						  {
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(vrs.getString("RELATIONSHIP_CODE")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(vrs.getString("SHORT_DESC")));
            _bw.write(_wl_block346Bytes, _wl_block346);
}
						  
							  
				  }
            _bw.write(_wl_block347Bytes, _wl_block347);
	if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block348Bytes, _wl_block348);
if(!isClaimantChngsApplicable){
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block350Bytes, _wl_block350);
}else{
            _bw.write(_wl_block349Bytes, _wl_block349);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block350Bytes, _wl_block350);
}
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(nat_id_no));
            _bw.write(_wl_block353Bytes, _wl_block353);
}else{
            _bw.write(_wl_block354Bytes, _wl_block354);
	}
            _bw.write(_wl_block355Bytes, _wl_block355);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(patient_employee_id));
            _bw.write(_wl_block357Bytes, _wl_block357);
if(isClaimantChngsApplicable){
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(Passport_No));
            _bw.write(_wl_block360Bytes, _wl_block360);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(Other_Identification));
            _bw.write(_wl_block362Bytes, _wl_block362);
}
            _bw.write(_wl_block363Bytes, _wl_block363);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(job_title));
            _bw.write(_wl_block367Bytes, _wl_block367);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(maximumLength));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(maxsize));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(organization_name));
            _bw.write(_wl_block369Bytes, _wl_block369);
if(!ocpn_class_desc.equals("")){
            _bw.write(_wl_block370Bytes, _wl_block370);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block372Bytes, _wl_block372);
}else{
            _bw.write(_wl_block373Bytes, _wl_block373);
}if(!mode.equals("insert") && claimant_type.equals("F")){ 
releasefacility = "visibility:visible";
}
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(releasefacility));
            _bw.write(_wl_block375Bytes, _wl_block375);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(releasefacility));
            _bw.write(_wl_block377Bytes, _wl_block377);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);
 pstmt2  = con.prepareStatement("select b.FACILITY_ID facility_id ,a.FACILITY_NAME facility_name from SM_FACILITY_PARAM a,sm_modules_facility b where a.facility_id = b.facility_id and b.module_id = 'MO' and a.facility_id!='"+facilityId+"'order by 2");
				 vrs = pstmt2.executeQuery();
				 while(vrs.next())
				  {
					 release_fac_id= vrs.getString("facility_id");
					 
					 release_fac_desc= vrs.getString("facility_name");
							// out.println("<script>alert('release_fac_desc---- :"+release_fac_desc+"')</script>");
					 
            _bw.write(_wl_block379Bytes, _wl_block379);
if((!mode.equals("insert"))&&release_fac_id.equals(RELEASE_TO_FACILITY))
						 {
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(release_fac_id));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(release_fac_desc));
            _bw.write(_wl_block346Bytes, _wl_block346);
}else{
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(release_fac_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(release_fac_desc));
            _bw.write(_wl_block346Bytes, _wl_block346);
} 
						  
							  
				  }
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(releasefacility));
            _bw.write(_wl_block375Bytes, _wl_block375);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(releasefacility));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(reason_deceased_desc));
            _bw.write(_wl_block384Bytes, _wl_block384);

 String[] address1_fld_names={"addr_line_1","addr_line_2","addr_line_3","addr_line_4","region","area","town","postal_code"};
String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};


	

String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,region_desc,res_area_desc,res_town_desc,postal_code};	      
ArrayList contact_addr= fetchContactAddresses(con,out,"parent.parent.messageFrame",p) ;
String[]	contact_col_names		        = (String[])contact_addr.get(1) ;
String[]	 contact_prompts			    = (String[])contact_addr.get(2) ;
//String[]  contact_fields					= (String[])contact_addr.get(3) ;
 contact_addr				    = null;
int k=0;
int l=1;




for(int i=0;i<contact_col_names.length;i++) 
 {
// if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
  //{
   out.println("<tr><td class='label' width='20%'>"+contact_prompts[i]+"</td>") ;		
   for(int j=0; j<address_col_names.length; j++)
     {
	if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
	 {
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(j));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block387Bytes, _wl_block387);
	  if(address_col_names[j].equalsIgnoreCase("REGION_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30'  onBlur='searchCountry1(this,region)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='reg_search' id='reg_search' class='BUTTON'  id='rgnsrh' value='?'   onClick=searchCountry(this,region) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_AREA_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30' onBlur='searchCountry1(this,area)'  onKeyPress='return CheckForSpecChars(event)'><input type='button' name='areasrch' id='areasrch' class='BUTTON'  id='areasrch' value='?'   onClick=searchCountry(this,area) ></td>") ;  			
		   }else if(address_col_names[j].equalsIgnoreCase("RES_TOWN_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"	maxLength='30' size='30'  onBlur='searchCountry1(this,town)' onKeyPress='return CheckForSpecChars(event)'><input type='button' name='twnsearch' id='twnsearch' class='BUTTON'  id='twnsrch' value='?'   onClick=searchCountry(this,town) ></td>") ;  			
		   }else 	
	       if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
		   {
			 out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value='"+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"'	maxLength='8' size='8' onBlur='blurPostalSearch(this,town)'   onKeyPress='return CheckForSpecChars(event)'><input type='button' name='postal_search' id='postal_search' class='BUTTON'  id='pstsrh' value='?'   onClick='callPostalSearch("+address1_fld_names[j]+");' ></td>") ;  			
		   }
		   else
		   {
		      
			  
			 //Below line added for this CRF ML-MMOH-CRF-0860
			 /*String addressLength="30";
			 if(address1_fld_names[j].equalsIgnoreCase("addr_line_1") || address1_fld_names[j].equalsIgnoreCase("addr_line_2") || address1_fld_names[j].equalsIgnoreCase("addr_line_3") ) {
			       addressLength="100";
			 }*/    
            //End this CRF ML-MMOH-CRF-0860 
			
		//Below line added for this CRF ML-MMOH-CRF-0860.2
        if(increasedaddressLength){
			 if(address1_fld_names[j].equalsIgnoreCase("addr_line_1")){ 
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block391Bytes, _wl_block391);
}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_2")){
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block391Bytes, _wl_block391);
}else if(address1_fld_names[j].equalsIgnoreCase("addr_line_3")){
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block394Bytes, _wl_block394);
 }else if(address1_fld_names[j].equalsIgnoreCase("addr_line_4")){
		out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\" maxLength='30' size='32' onBlur='makeValidString(this)' > </td>");
			 }			 
		 }else{
			out.println("<td class='fields' width='30%'><input type='text' name='"+address1_fld_names[j]+"' id='"+address1_fld_names[j]+"' value=\""+ecis.utils.HTMLUtilities.getDisplayString(address_fld_values[j])+"\"		maxLength='30' size='32'  onBlur='makeValidString(this)' > </td>") ; 
		  }	
		  //End  ML-MMOH-CRF-0860.2	
					  
		}
						
	}
	k=j;
				
   }   
			
   
   out.println("</td></tr>");
    l++;
   }

        String sq3 = "select short_name from mp_country_lang_vw where language_id = '"+localeName+"' and country_code = '"+country_code+"'";

		pstmt2  = con.prepareStatement(sq3);
        vrs = pstmt2.executeQuery();
        
		
		while( vrs.next())
		{
			kcou=checkForNull(vrs.getString("short_name"));
		
	//	}     


}
            _bw.write(_wl_block395Bytes, _wl_block395);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(kcou));
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(telephone_res));
            _bw.write(_wl_block399Bytes, _wl_block399);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(mob_tel_no));
            _bw.write(_wl_block401Bytes, _wl_block401);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(telephone_off));
            _bw.write(_wl_block403Bytes, _wl_block403);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block405Bytes, _wl_block405);

				
				if(external_rec_exists.equals("Y") && external_rec_count > 1){ 
					IsViewClaimantHistoryDisplay	= true;
				}else if(external_rec_exists.equals("Y") && external_rec_count==1 && !facilityId.equals(latest_claiment_fac_id)){
					IsViewClaimantHistoryDisplay	= true;
				}
				if(IsViewClaimantHistoryDisplay){
				
            _bw.write(_wl_block406Bytes, _wl_block406);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block292Bytes, _wl_block292);
}
            _bw.write(_wl_block407Bytes, _wl_block407);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block408Bytes, _wl_block408);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(rearrangeTabBurlPermtClaimnt){
            _bw.write(_wl_block409Bytes, _wl_block409);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block410Bytes, _wl_block410);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block411Bytes, _wl_block411);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block412Bytes, _wl_block412);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block414Bytes, _wl_block414);
String disabledonor="";
							if(postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S"))
								disabledonor="disabled";
						  if(donor_card_available_yn.equals("Y"))
						 {
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(disabledonor));
            _bw.write(_wl_block416Bytes, _wl_block416);
}else{
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(disabledonor));
            _bw.write(_wl_block418Bytes, _wl_block418);
}
            _bw.write(_wl_block419Bytes, _wl_block419);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block420Bytes, _wl_block420);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block421Bytes, _wl_block421);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block422Bytes, _wl_block422);
	int i=0;
					String viewdisdata="";
					//pstmt = con.prepareStatement("select a.ORGAN_CODE, a.SHORT_DESC,case when b.ORGAN_CODE=a.ORGAN_CODE then 'Y' else 'N' end checkedyn  from MO_ORGAN_FOR_DONATION_LANG_VW a,mo_organ_donation_regn b  where a.ORGAN_CODE=b.ORGAN_CODE(+) and a.eff_status='E' and b.facility_id(+)='"+facilityId+"' and language_id = '"+localeName+"' and b.registration_no(+)='"+ regn_no+"' order by 2  ");
					//facility_id removed for Bru-HIMS-CRF-0368 By Dharma on 11th Dec 2013 
					pstmt = con.prepareStatement("select a.ORGAN_CODE, a.SHORT_DESC,case when b.ORGAN_CODE=a.ORGAN_CODE then 'Y' else 'N' end checkedyn  from MO_ORGAN_FOR_DONATION_LANG_VW a,mo_organ_donation_regn b  where a.ORGAN_CODE=b.ORGAN_CODE(+) and a.eff_status='E' and language_id = '"+localeName+"' and b.registration_no(+)='"+ regn_no+"' order by 2  ");
					vrs=pstmt.executeQuery();

					if(mode.equals("viewdata")||postmortem_startend_status.equals("E")||postmortem_startend_status.equals("S"))
					 viewdisdata="disabled";
					while(vrs.next())
					{ 
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(vrs.getString("SHORT_DESC")));
            _bw.write(_wl_block424Bytes, _wl_block424);
if(vrs.getString("checkedyn").equals("Y")){
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(viewdisdata));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(i));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(vrs.getString("ORGAN_CODE")));
            _bw.write(_wl_block428Bytes, _wl_block428);
}else{
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(viewdisdata));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(i));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(vrs.getString("ORGAN_CODE")));
            _bw.write(_wl_block76Bytes, _wl_block76);
} 
            _bw.write(_wl_block431Bytes, _wl_block431);
i++;}
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(externalBidYn));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(pol_officer_name));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(extBidYnFrmVw));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(pol_contact_no));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(dec_fac_id));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(dec_enc_id));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(external));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(regno));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(pol_rep_no));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(pol_stn_id));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(pol_id));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(police_approval_received_yn));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(police_received_by));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(police_received_date));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(consent_form_code));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(enable_rfid_yn));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(consent_given_by));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(relationship_with_deceased));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(consent_form_received_by));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(consent_form_received_date));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(sys_date_cnv));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(donar_card_no));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(donar_card_details));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(i));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(consent_form_code1));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(relationship));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(conscentgivenby1));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(deceasedrelationship1));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(consent_received_by1));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(consent_received_date1));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(zip_code));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(regn_no));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(consent_form_recd_by_name2));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(consent_form_recd_by_name));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(burial_permit_appr_by_name));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(postmortem_startend_status));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(police_approval_received_by_desc));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(burial_permit_reqd_yn));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(external_rec_exists));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(default_claimant_type));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(default_claimant_type_code));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(default_relationship));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(default_name));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(default_job_title));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(default_addrl1));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(default_addrl2));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(default_addrl3));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(default_addrl4));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(default_postal_code));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(default_country_code));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(default_zip_code));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(default_res_town_code));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(default_res_area_code));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(default_region_code));
            _bw.write(_wl_block501Bytes, _wl_block501);
            out.print( String.valueOf(default_res_town_desc));
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(default_res_area_desc));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(default_region_desc));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(default_telephone_off));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(default_telephone_res));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(default_email_id));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(default_mob_tel_no));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(default_nat_id_no));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(default_organization_name));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(default_patient_employee_id));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(default_Passport_No));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(default_Other_Identification));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(default_RELEASE_TO_FACILITY));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(default_reason_deceased_desc));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(default_country_desc));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(isRemoveMandBPermitAppBy));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(isClaimantChngsApplicable));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(datetimeofclaimingApplicable));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(rearrangeTabBurlPermtClaimnt));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(isChangeOfDateTimeClaimingAppl));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(isReceivedDateTimeAppl));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(isDateTimeOfDeathAppl));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(claimant_type));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(datetime_claim_mand));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(datetimeOfClaimingAppl));
            _bw.write(_wl_block527Bytes, _wl_block527);

   if(vpstmt!=null) vpstmt.close();
   if(sstat!=null) sstat.close();
   if(pstmt2!=null)  pstmt2.close();
   if(vrs!=null) vrs.close(); 
 }else
  {
		    out.println("<script>alert(getMessage('REGN_NOT_ALLOWED','MO'));</script>");
			out.println("<script>parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.forms[0].patient_id.disabled=false;parent.frames[0].document.forms[0].patient_search.disabled=false;</script>");
            out.println("<script>parent.dummyframe.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;</script>");
 }
		  
		  
		  
		  
		
		  
	}catch(Exception e)
    {
       e.printStackTrace();

    }
    finally
    {
       
		
		 ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block528Bytes, _wl_block528);
            _bw.write(_wl_block529Bytes, _wl_block529);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Demographics.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RegistrationDtls.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OrganDonation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraltype.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralsource.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HealthcareSettingType.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referredby.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceaseddetails.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.broughtdead.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.UnclaimedBody.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InfectiousDeceasedBody.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.highriskbody.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MannerofDeathuponReceipt.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PlaceofDeath.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MannerofDeathafterPostmortem.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyFoundAt.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceaseddatetime.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyFoundAt.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Body.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.received.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Receipt.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyRelDateTimefromSource.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Body.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.received.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyReceipt.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyCondition.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.IdentificationMarks.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicoLegalCase.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BroughtByPolice.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PoliceDetails.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemDtls.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PMRequired.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemType.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Clinical.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Clinical.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MedicoLegal.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MedicoLegal.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConsentForm.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.assignarea.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.area.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.assigndatetime.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostMortem.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RFIDTag.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Demographics.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RegistrationDtls.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OrganDonation.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.GenerateBurialPermitNo.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNumber.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DateTimeOfDeath.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DateTimeOfClaiming.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.VehicleNumber.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitApprovedBy.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BurialPermitApprovedDate.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Demographics.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RegistrationDtls.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OrganDonation.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DefaultPreviousClaimantDetails.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employer.label", java.lang.String .class,"key"));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employer.label", java.lang.String .class,"key"));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.EmbassyCountry.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.EmbassyCountry.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.WelfareAssociations.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.WelfareAssociations.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ReligiousOrgn.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ReligiousOrgn.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.UnderTaker.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.UnderTaker.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ReleasedToOtherFacility.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ReleasedToOtherFacility.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.CopyDetails.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DateTimeOfClaiming.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DateTimeOfClaiming.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MyKad.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmployeeID.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PassportNo.label", java.lang.String .class,"key"));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OtherId.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orgName.label", java.lang.String .class,"key"));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.MobilePhoneNo.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ViewClaimantHistory.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Demographics.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreviousEncounters.label", java.lang.String .class,"key"));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RegistrationDtls.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.OrganDonation.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Claimant.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermit.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.TissueProcmntRegn.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DonorCardAvlbl.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DonorCardInfo.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Consent.label", java.lang.String .class,"key"));
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
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ListoforganforDonation.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
