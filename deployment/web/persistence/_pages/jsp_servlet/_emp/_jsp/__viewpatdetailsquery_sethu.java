package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __viewpatdetailsquery_sethu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewPatDetailsQuery_Sethu.jsp", 1742376573424L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/30/2005 12:20 PM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block6_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block6_2Bytes = _getBytes( _wl_block6_2 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n<meta http-equiv=\"Expires\" content=\"0\">\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<Script src=\"../js/ViewPatDetails.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/calScript/hj/calendar.js\" language=\"JavaScript\"></Script>\n\n\n<script language=\"JavaScript\">\nfunction showPatientPhoto() {\n\tvar view_photo_yn = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tif (view_photo_yn==\"Y\")\n\t{\n\t\tdocument.patient_photo.src = document.patient_photo.src ;\n\t\tdocument.patient_photo.src = document.patient_photo.src ;\n\t\tdocument.patient_photo.src = document.patient_photo.src ;\n\t}\n}\nfunction f1()\n {\n\t parent.patient_main.document.getElementById(\'refrel\').click()\n }\n/*\nfunction lockKey()\n{\n\tif(event.keyCode == 93 || event.keyCode ==32)\n\t{\n\t\talert(getMessage(\'WELCOME\',\'Common\'));\n\t\tevent.returnValue=false;\n\t\t}\n}\n*/\n\tfunction tab_click2(id,idval){\n\t\t\t//selectTab(idval);\n\t\t\ttab_click1(id);\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onSelect=\"codeArrestThruSelect()\" OnMouseDown=\"CodeArrest();\" onKeyDown=\'lockKey()\'>\n<form name=\'PatRegForm\' id=\'PatRegForm\' method=\'post\'>\n<a name=\'demo\' id=\'name\'></a>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"97%\" align=\"center\">\n\t\t\n\t\t<tr>\t\n\t\t\t\t<td  class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td  class=\'data\' width=\'24%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t<td  class=\'label\' width=\'24%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td  class=\'data\' width=\'24%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<tr>\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' width=\'24%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<td  class=\'label\'  width=\'24%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td  class=\'data\' width=\'24%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n  \t\t\t\t\t<td colspan=2  class=\'data\'  ></td>\n\t\t      ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<td   class=\'data\'   width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td> \n\t\t       ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td colspan=2  class=\'data\'  ></td>\n\t\t      ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n        </tr>\n\t\t<tr>\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td  class=\'data\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t<td  class=\'data\'  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t <td  colspan = 2 >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<tr>\n\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td  class=\'data\' > ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t    <td  class=\'label\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td  class=\'data\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td> \n\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td colspan = 2 >&nbsp;</td>\n             ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</tr>\n    \n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t<tr>\n\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t<td  class=\'data\' >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\n\t\t    ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t    <td  class=\'label\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\'data\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td> \n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<td colspan = 2 >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t</tr>\n\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t<td class=\'data\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" </td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t <td  class=\'label\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t <td  class=\'data\' >\n\t\t\t\t\t ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t <td class=\'label\'  colspan=\'2\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t<tr>\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t\t<td  class=\'label\'  width=\'24%\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\n\t\t\t\t<td  class=\'data\'  width=\'24%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t    ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t</td>\n\t\t\t<td  class=\'label\'  width=\'24%\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t<td  class=\'data\'    width=\'25%\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="/&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t</tr>\n\t\t\t ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=4 class=\'label\' >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\n         \n\t ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t   <tr>\n\t\t\t\t<td  class=\'label\'>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<!-- ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t <td colspan=1 align=\'left\' class=\'data\' >\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t  <td colspan=2 align=\'left\' class=\'data\' >\n\t\t\t   ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" -->\n\t\t\t   ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t   <td  class=\'label\'  >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t   <td  class=\'data\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t <tr>\n\t\t\t\t<td colspan=4  class=\'data\' width=\'45%\'>&nbsp;</td>\n\t\t\t </tr>\n\t\t ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n \t \n<!-- </table>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\" align=\"center\"> -->\n<tr>\n<td width=\"100%\" class=\"BORDER\" colspan=\'4\'>\n<table  cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\"100%\" >\n<tr><td class=\"COLUMNHEADER\" colspan=\'6\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td></tr>\n<tr>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n</tr>\n\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n        <tr >\n        ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n        </tr>\n        <tr>\n        ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n</tr>\n</table>\n</td>\n</tr>\n<!-- </table>\n<table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\"97%\" align=\"center\"> -->\n\t<tr>\n\t     <td class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t</tr>\n    \n    <tr>\n\t    <td   class=\"label\" width=\"24%\" >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t    <td  class=\'data\' width=\"24%\" >\n\t       ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t   ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t </td>\n\t\t <td   class=\"label\" width=\"24%\" >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="/";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" \n\t\t </td>\n\t\t <td  class=\'data\' width=\"24%\" >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" /";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\n\t</tr>\n\t\t\n    <tr>\n\t    <td   class=\"label\" width=\"24%\" >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" </td>\n\t    <td  class=\'data\' width=\"24%\" >";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t<td  width=\"24%\" class=\"label\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t<td  width=\"25%\" class=\"label\"><b>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span id=\"hiji_date_display\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</span></b>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t</tr>\n\t <!--above line added for this CRF MMS-QH-CRF-0145 -->\n \n    <tr>\n    \t<td  width=\"24%\" class=\"label\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t    <td  class=\'data\' width=\"15%\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t    <td class=\'data\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t</td>\n     </tr>\n\t\t\t\n\t <tr>\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t<td   class=\"data\" >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t<td   class=\"data\">\n\t\t    \n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t/";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t</td>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t<td  class=\"label\" colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t </tr>\n\n\t\t\t\n\n     <tr>\n\t     <td  class=\"label\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n         <td  class=\"data\">\n             ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\n        </td>\n        <td class=\"label\">\n\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n        <td  class=\"data\">\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t  \n       </td>\n    </tr>\n     \t\t\n    <tr>\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t<td  class=\"data\">\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t\t<td  class=\"data\">\n\t\t    ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="&nbsp;\n\t\t\t</td>\n\t</tr>\n       \t\t\n    <tr>\n\t\t  <td  class=\"label\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t  <td  class=\"data\" >\n\t\t  ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&nbsp;</td>\n\t\t  <td  class=\"label\">";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n          <td class=\"data\">\n          ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&nbsp;</td>\n\t\t  \n    </tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t<td class=\'data\' >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="&nbsp;</td>\n        <td class=\"label\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&nbsp;</td>\n        \n   </tr>\n   \n<!--\n</table>\n\n<table border=\'0\'  cellspacing=\'0\' cellpadding=\'4\' width=\'97%\' align=\'center\'>\n-->\n \t\t\n    ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t   <tr>\n\t\t\t\t        <td class=\'COLUMNHEADER\' colspan=\'4\' > ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t        </td>\n\t\t\t\t   </tr>\n\t\t\t   ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<a name=\'addr\'></a>\n       <table cellpadding=\'4\' cellspacing=\'1\' border =\'0\' width=\'99%\' align=\'center\'>\n                <tr>\n                    <td  class=\'BODYCOLORFILLED\' width=\'1%\'>&nbsp;</td>\n                    <td width=\'99%\'  class=\'BODYCOLORFILLED\' valign=\'top\' colspan=\'4\'>\n                    <table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' height=\'100%\' width=\'99%\'>\n                        <tr>\n                            <td class=\'COLUMNHEADER\'>&nbsp;</td>\n                            <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n                            <td  class=\'COLUMNHEADER\' colspan=\'2\'>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n                        </tr>\n\t                    \n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n<tr>\n\t<td  class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t<td class=\'data\' width=\'24%\'>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t<td class=\'data\' >&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\n\t\t<td ><img src=\'../../eCommon/images/enabled.gif\' ></td>\n\n\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t<td ><img src=\'../../eCommon/images/RRnwd.gif\'></td>\n\n\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\n        <td ><img src=\'../../eCommon/images/enabled.gif\' ></td>\n\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n    \n    <td ><img src=\'../../eCommon/images/RRnwd.gif\'></td>\n\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n<td class=\'data\' >&nbsp;</td>\n</tr>\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t<td  class=\'data\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t<td class=\'data\' >";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t<td class=\'data\' >&nbsp;</td>\n</tr>\n\n</table>\n<!--\n</td></tr></table>\n</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n-->\n<tr>\n<td  class=\'BODYCOLORFILLED\' width=\'1%\'>&nbsp;</td>\n<td width=\'99%\'  class=\'BODYCOLORFILLED\' valign=\'top\' colspan=\'4\'>\n<table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' height=\'100%\' width=\'99%\'>\n\t<tr>\n                <td  class=\'COLUMNHEADER\' colspan=\'4\'  width=\'100%\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n     </tr> \n\n\t ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\n<tr>\n\t\t<!--<td  class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td> -->\n\t\t<td  class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</td>\n\t\t<td  class=\'data\' width=\'24%\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\t\t<!-- <td  class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td>\n\t\t<td  class=\'data\' width=\'25%\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n</tr>\n\n<tr>\n      <td  class=\'label\'>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\n      <td  class=\'data\' >";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n      <td  class=\'data\' colspan=\'2\'>&nbsp;</td>\n</tr>\n\n<tr>\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" </td>\n\t<td colspan=3 class=\'label\' >&nbsp;</td>\n</tr>\n\t\n<tr>\n    <td  class=\'label\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</td>\n    <td  class=\'data\' >";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n    <td  class=\'label\' colspan=2></td>\n</tr>\n\n<tr> \n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</td>\n\t<td  class=\'data\' >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t<td  class=\'label\' colspan=2></td>\n</tr>\n\n<tr>\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t<td  class=\'label\' colspan=2></td>\n</tr>\n\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t   <tr>\n\t\t\t\t       <td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\n\t\t\t\t   </tr>\n\t\t\t   ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n</tr>\n\n</table>\n</td>\n</tr>\n</table>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\t\n<a name=\'fin\'></a>\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\t<a name=\'kin\'></a>\n\t\t\t<ul id=\"tablist\" class=\"tablist\">\n\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'#kin\',\'firstkin\')\" class=\"tabClicked\" id=\"firstkin\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"firstkinspan\">";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'#kin1\',\'firstkin1\')\" class=\"tabA\" id=\"firstkin1\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"firstkin1span\">";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'#empyr\',\'firstempyr\')\" class=\"tabA\" id=\"firstempyr\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"firstempyrspan\">";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\t\n\t\t\t</ul>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\" align=\"center\" valign=top>\n<tr>\n<td width=100% class=\"BORDER\" valign=top>\n<table width=\'100%\' border=0 cellpadding=\'4\' cellspacing=\'0\' valign=top>\n<tr>\n<td valign=top>\n<table width=\'100%\' cellpadding=\'4\' cellspacing=\'1\' border=0 valign=top>\n<tr>\n\t<td  class=\'label\' width=\"24%\">&nbsp;</td>\n\t<td class=\'DATA\' width=\"24%\">&nbsp;</td>\n\t<td class=\'DATA\' width=\"24%\">&nbsp;</td>\n\t<td class=\'DATA\' width=\"25%\">&nbsp;</td>\n</tr>\n<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</td>\n\t\t<td  class=\'data\' >";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n </tr>\n\n<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n</tr>\n\n\n<tr>\n\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n</tr>\n\n\n<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n</tr>\n\n\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\n</tr>\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\t\n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n   ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t<td colspan=\'2\' class = \'label\'>&nbsp;</td>\n   ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n               ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n</tr>\n\n<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</td>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n\t\t<td class=\'DATA\'  >";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n</tr>\n\n<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n</tr>\n\n<tr>\n\t\t<td  class=\'data\' >&nbsp;</td>\n\t\t<td  class=\'data\' >&nbsp;</td>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n</tr>\n\n<tr>\n\t\t<td  class=\'data\'>&nbsp;</td>\n\t\t<td  class=\'data\'>&nbsp;</td>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td>\n\t\t<td class=\'DATA\' >";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</td>\n</tr>\n\n<tr>\n\t\t<td class=\'DATA\' >&nbsp;</td>\n\t\t<td class=\'DATA\' >&nbsp;</td>\n\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="&nbsp;</td>\n</tr>\n\n\n";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t   <tr><td class=\'COLUMNHEADER\' colspan=\'4\' >&nbsp;";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</td></tr>\n\t\t\t   ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n<tr>\n\t<td class=\'label\' >&nbsp;</td>\n\t<td class=\'DATA\'>&nbsp;</td>\n\t<td class=\'DATA\' >&nbsp;</td>\n\t<td class=\'DATA\' >&nbsp;</td>\n</tr>\n</table>\n</td></tr></table>\n</td></tr></table>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t <a name=\'kin1\'></a>\n\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t<a onclick=\"tab_click2(\'#kin\',\'secondkin\')\" class=\"tabA\" id=\"secondkin\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"secondkinspan\">";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a onclick=\"tab_click2(\'#kin1\',\'secondkin1\')\" class=\"tabClicked\" id=\"secondkin1\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"secondkin1span\"> ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t\t\t<a onclick=\"tab_click2(\'#empyr\',\'secondempr\')\" class=\"tabA\" id=\"secondempr\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"secondemprspan\">";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t</ul>\n\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'97%\' align=center>\n<tr><td>\n\t\t<table cellspacing=\'1\' cellpadding=\'4\' width=\'100%\' border=0>\n\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\"24%\" >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\' width=\"24%\" >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\' width=\"24%\" >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\' width=\"25%\" >&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</td>\n\t\t\t\t\t<td  class=\'data\' >";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t</tr>\n\n\t\t\t\n\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t</tr>\n\n\t\t\t\n\n\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="&nbsp;</td>\t\t\t\n\t\t\t\t\t<td  class=\'data\' >";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t</tr>\n\n\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t<td colspan=\'2\' class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</td>\n\t\t\t\t\t<td  class=\'data\'>";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</td>\n\t\t\t\t\t<td class=\'DATA\'  >";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t</tr>\n\n\t\t\t\n\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</td>\n\t\t\t\t\t<td class=\'DATA\' >";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</td>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="</td>\t\n\t\t\t\t\t<td class=\'DATA\' >";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\'  >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'DATA\'  >&nbsp;</td>\n\t\t\t</tr> \n\t\t</table>\n\t<br>\n\t\t\n</td></tr></table>\n\n\n\t<table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n\t\t <tr></tr><tr></tr><tr></tr>\n\t\t <tr></tr><tr></tr><tr></tr>\n ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\n </table>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n<br>\n<a name=\'empyr\'></a>\n\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n\t\t\t\t<a onclick=\"tab_click2(\'#kin\',\'thirdkin\')\" class=\"tabA\" id=\"thirdkin\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"thirdkinspan\">";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Contact Mode and Address details\">\n\t\t\t\t<a onclick=\"tab_click2(\'#kin1\',\'thirdkin1\')\" class=\"tabA\" id=\"thirdkin1\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"thirdkin1span\"> ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\n\t\t\t\n\t\t\t<li class=\"tablistitem\" title=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n\t\t\t\t<a onclick=\"tab_click2(\'#empyr\',\'thirdempr\')\" class=\"tabClicked\" id=\"thirdempr\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"thirdemprspan\">";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t</ul>\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'97%\' align=center>\n<tr><td>\n<table cellspacing=\'0\' cellpadding=\'4\' width=\'100%\' border=0>\n<tr><td  width=\"5%\" class=\'columnheader\'>&nbsp;</td><td  width=\"20%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="&nbsp;</td><td class=\'COLUMNHEADERCENTER\' colspan=\'2\' width=\"40%\">";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td></tr>\n<tr>\n\t\t<td  class=\'label\' width=\"24%\">&nbsp;</td>\n\t\t<td class=\'DATA\' width=\"24%\">&nbsp;</td>\n\t\t<td class=\'DATA\' width=\"24%\">&nbsp;</td>\n\t\t<td class=\'DATA\' width=\"25%\">&nbsp;</td>\n</tr>\n<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</td>\n\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td>\n</tr>\n<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="&nbsp;</td>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</td>\n</tr>\n<tr>\n\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</td>\n</tr>\n\n\n\n<tr>\n\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t<td class=\'label\'  valign=top>";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t<td  class=\'data\'>&nbsp;</td>\n\t\t<td  class=\'data\'>&nbsp;</td>\n</tr>\n\n\n\n<tr>\n\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\t\n\t\t<td class=\'data\'>&nbsp;</td>\n\t\t<td class=\'data\'>&nbsp;</td>\n</tr>\n\n\n\n<tr>\n\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n</tr>\n\n\n\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n</tr>\n\n\n\n<tr>\n\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n\t\t<td width=\"20%\" class=\'data\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</td>\n\t\t<td class=\'data\'>&nbsp;</td>\n\t\t<td class=\'data\'>&nbsp;</td>\n</tr>\n<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="&nbsp;</td>\n\t\t<td class=\'data\'>&nbsp;</td>\n\t\t<td class=\'data\'>&nbsp;</td>\n</tr>\n\t\n\n\n<tr>\n\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</td>\n\t\t<td  class=\'data\'>&nbsp;</td>\n\t\t<td  class=\'data\'>&nbsp;</td>\n</tr>\n\n\n\n<tr>\n\t\t <td  class=\'label\' >&nbsp;</td>\n\t\t <td class=\'DATA\' >&nbsp;</td>\n\t\t <td class=\'DATA\' >&nbsp;</td>\n\t\t <td class=\'DATA\' >&nbsp;</td>\n</tr></table>\n</td>\n</tr>\n</table>\n\n\t <table border=\'0\' cellspacing=\'0\' cellpadding=\'4\' width=\'97%\' align=\'center\'>\n\t <tr></tr><tr></tr><tr></tr><tr></tr>\n\n  ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t   <tr><td class=\'COLUMNHEADER\' colspan=\'4\' >";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\n </table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<!--<a name=\'pat_docs_tab\'></a>\n\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n<tr>\n        <td  class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</td>\n        <td  class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</td>\n        <td  class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</td>\n\t\t\n\t\t <td  class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</td>\n    </tr>\n</table>\n</td></tr><tr><td> -->\n<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n<a name=\'pat_docs_tab\'></a>\n<table width=\'97%%\' cellpadding=\'0\' align=\'center\' cellspacing=\'0\' border=\'0\'>\n<tr>\n        <td  class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="</td>\n        <td  class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</td>\n\t\t\n\t\t <td  class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</td>\n    </tr>\n\t <!--   end PMG2012-CRF-0006 [IN034693]   -->\n    ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n                \n                     <td class=\'data\' width=\'20%\' >&nbsp;";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</td>\n                    <td class=\'data\' width=\'20%\'>";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="</td>\n                    <td class=\'data\' width=\'15%\'>";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="</td>\n                    <td class=\'data\' width=\'30%\'>";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="</td>\n\t\t\t\t\t<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t   ";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =" \n\t\t\t\t\t <td class=\'data\' width=\'30%\'><a href=\"javascript:viewDocument(\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\',\'DOC1_IMAGE\')\">";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n                 </tr>\n                    <!-- end PMG2012-CRF-0006 [IN034693]  -->\n\n                 <tr> \n                     <td class=\'data\'>&nbsp;";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="</td>\n                     <td class=\'data\'>";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</td>\n                     <td class=\'data\' width=\'15%\'>";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="</td>\n                     <td class=\'data\' width=\'30%\'>";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="</td>\n\t\t\t\t\t <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t   ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\',\'DOC2_IMAGE\')\">";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n                 </tr>\n                   <!-- end PMG2012-CRF-0006 [IN034693]  -->\n\n                 <tr> \n                     <td class=\'data\'>&nbsp;";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="</td>\n\t\t\t\t\t   <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t   ";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\',\'DOC3_IMAGE\')\">";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n                </tr>\n                  <!-- end PMG2012-CRF-0006 [IN034693]  -->\n               <tr> \n                     <td class=\'data\'>&nbsp;";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</td>\n\t\t\t\t\t    <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t\t   ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\',\'DOC4_IMAGE\')\">";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\n                 </tr>\n                   <!-- end PMG2012-CRF-0006 [IN034693]  -->\n\t\t\t \n\n</table>\n\n<br>\n\n\n<a name=\'misc\'></a>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\" align=\"center\">\n <tr>\n   <td width=100% class=\"BORDER\">\n\n\t\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' >\n\t\t<tr>\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'5\'>";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="</td>\n\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t   <td colspan=5 class=\'label\' height=5></td>\n\t\t\t</tr>\n\t\t<tr>\n\t\t<td>\n\t\t\t<table width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="</td>\n\t\t\t\t\t<td width=\'20%\' class=\'data\' >";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="</td>\n\t\t\t\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="</td>\n\t\t\t\t\t<td width=\'40%\' class=\'data\' colspan=\'2\'>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</td>\n\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t   <td colspan=5 class=\'label\' height=5></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="</td>\n\t\t\t\t\t<td  class=\'data\' colspan=\'3\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n      </p></td>\n  </tr>\n</table>\n\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n<br>\n";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n  <tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'5\'>";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</td>\n  </tr>\n <tr>\n  <td>\n\t\t<table width=\'100%\' cellpadding=\'3\' cellspacing=\'1\' border=\'0\'>\n\t\t<tr>\n\t\t\t <td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</td>\n\t\t\t <td  width=\'20%\' class=\'data\' >\n\t\t\t ";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</td>\n\t\t\t <td width=\'60%\' colspan=3 class=\'label\' >&nbsp;</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="</td>\n\t\t\t\t<td class=\'data\' colspan=\'4\'>\n\t\t\t\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="</td>\n\t\t </tr>\n\t\t</table>\n</p>\n</td>\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n\t<tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'5\'>";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="</td>\n\t</tr>\n<tr>\n<td>\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'1\' border=\'0\'>\n\n<tr>\n\t\t<td width=\'100%\'  class=\'data\' colspan=5>\n        ";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="</td>\n</tr>\n</table>\n</p>\n</td>\n</tr>\n\n</table>\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n<tr>\n\t<td class=\"COLUMNHEADER\" colspan=\'5\'>";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</td>\n</tr>\n<tr>\n<td>\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'1\' border=\'0\'>\n\n<tr>\n\t\t<td  width=\"20%\"  valign=\"top\" class=\"data\">";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="</td>\n\t\t<td  width=\"80%\" class=\"data\" colspan=\'5\'>";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="</td>\n</tr>\n</table>\n</p>\n</td>\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n<tr>\n<td class=\"COLUMNHEADER\" colspan=\'5\'>";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n</tr>\n<tr>\n<td>\n\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'1\' border=\'0\'>\n\n<tr>\n\t\t<td width=\"20%\"class=\"label\">";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</td>\n\n\t\t";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n\t\t\t\t<td width=\"20%\"class=\"data\"><img src=\'../../eCommon/images/enabled.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t<td width=\"20%\"class=\"data\"><img src=\'../../eCommon/images/disabled.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t<td width=\"20%\"class=\"label\">";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</td>\n\t\t<td width=\"40%\" class=\"data\" colspan=\'2\'>";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="</td>\n\t\t\n</tr>\n</table>\n</td>\n</tr>\n</table>\n</td></tr></table>\n<table width=\'100%\' cellspacing=0 cellpadding=0>\n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="</td>\n</tr>\n<tr>\n<td>\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'1\' border=\'0\'>\n<tr>\n\t\t<td  width=\"20%\" class=\"label\">";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="</td>\n\t\t<td  width=\"80%\" class=\"data\" colspan=\'4\'>";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="</td>\n</tr>\n<tr>\n\t\t<td  width=\"20%\" class=\"label\" valign=\"top\">";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="</td>\n\t\t<td  class=\"data\" width=\"80%\" colspan=\'4\'>";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="</td>\n</tr>\n</table>\n</td>\n</tr>\n\n";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\n<TR>\n<TD colspan=5> </TABLE>\n<table cellspacing=0 cellpadding=0 width=\'97%\' border=0 align=\'center\' border=\'0\'>\n<tr></tr><tr></tr><tr></tr><tr></tr>\n";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t   <tr><td class=\'COLUMNHEADER\' colspan=\'5\' >&nbsp;";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n\n</TABLE>    \n<br><br><br><BR><br><br><br><br><br><br><br><BR><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<a name=\'add_mod_dtl\'>\n<table cellspacing=0 cellpadding=4 width=\'90%\' align=\'center\' border=1 height=\'50%\' >\n    <tr>\n        <td class=\'COLUMNHEADER\'>&nbsp;</td>\n        <td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</td>\n        <td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="</td>\n    </tr>\n    <tr>\n        <td class=\'data\' >";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="</td>\n        <td class=\'data\'>";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="</td>\n    </tr>\n\n    <tr>\n        <td class=\'data\' >";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="</td>\n     </tr>   \n   \n     <tr>\n        <td class=\'data\' >";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="</td>\n        <td class=\'data\'> ";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</td>\n        \n        <td class=\'data\'> ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="</td>\n      </tr>  \n\n      <tr>\n        <td class=\'data\'>";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</td>\n    </tr>\t\t\t\t\t\t\t\t  \n\t<tr>\n        <td class=\'data\' >";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="</td>";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n        <td class=\'label\'>&nbsp;</td>\n    </tr>\n</table> \n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'>\n<script>\n\n/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ \n function viewDocument(patientID,column_name)\n{\n\nvar dialogHeight = \'30\' ;\nvar dialogWidth  = \'30\' ;\nvar features     = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; status=no;\'\nvar arguments    = \'\' ;\n var retVal = window.showModalDialog(\"../../eMP/jsp/ViewPatientDocFrame.jsp?patient_id=\"+patientID+\"&column_name=\"+column_name,arguments,features); \n \n} \n/* end PMG2012-CRF-0006 [IN034693] */\n//Added for MMS-QH-CRF-0145\nif(";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="&&\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'==\"\"){\nvar hijDay=convertToHij(\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\'); \ndocument.getElementById(\'hiji_date_display\').innerHTML=hijDay;\n}\n\n</script>\n \n </form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            _bw.write(_wl_block6_2Bytes, _wl_block6_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

String Facility_Id = (String) session.getValue("facility_id");


String function_id1="";
request.setCharacterEncoding("UTF-8");
function_id1=request.getParameter("function_id");
Connection con = null;
ResultSet  rs_lang=null; 

String locale			= (String)session.getAttribute("LOCALE");
String patient=request.getParameter("Patient");

String disp_dup_pat_dtls=request.getParameter("disp_dup_pat_dtls");
String group_status=request.getParameter("group_status") ; 

Properties p		= (java.util.Properties) session.getValue("jdbc");
String age_value = "";
String language_direction="";
String family_org_id_accept_yn="";
	 String entitlement_by_pat_cat_yn="";
		
/* Friday, April 30, 2010 PE_EXE Venkat S 
StringBuffer sqlresp = new StringBuffer("select view_pat_photo_yn from mp_access_rights where resp_id = '");
sqlresp.append(resp_id);
sqlresp.append("'");
String view_pat_photo_yn = "N"; */

String view_pat_photo_yn=request.getParameter("view_pat_photo_yn");
if(view_pat_photo_yn == null ||view_pat_photo_yn.equals(""))
	view_pat_photo_yn = "N";

String total=request.getParameter("total");
if(total == null ||total.equals(""))
	total = "";
int count = Integer.parseInt(total);

ResultSet rs=null;
ResultSet rs2=null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;



try
{

	con = ConnectionManager.getConnection(request);
	// Friday, April 30, 2010 
	//pstmt = con.prepareStatement(sqlresp.toString());
	//rs=pstmt.executeQuery();

 //   if (rs.next())
     //   view_pat_photo_yn = rs.getString(1);

		
/*
		if(pstmt1 != null) pstmt1.close();
		if(rs2 != null) rs2.close();
		
		pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs2 = pstmt1.executeQuery() ;
             
		 if ( rs2 != null && rs2.next() ) 
		 {
		 count = rs2.getInt("total");
		 }
*/

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}

		//if(pstmt1 != null) pstmt1.close();
		//if(rs2 != null) rs2.close();

}
catch(Exception e)
{
	e.printStackTrace();

}

StringBuffer sql=new StringBuffer();
StringBuffer sql2 =  new StringBuffer();

String citizen_yn="";
String legal_yn="";
String Patient_id="";
String Patient_Name ="";
String Pat_Ser_Grp_Code="";
String Pat_Ser_Grp_Desc  ="";
String National_Id_No  ="";
String Pref_Facility_Id  ="";
String Pref_Facility_Name ="";
String Alt_Id1_Type ="";
String Alt_Id1_No    ="";
String Alt_Id1_Exp_Date  ="";
String Alt_Id2_Type   ="";
String Alt_Id2_No   ="";
String Alt_Id2_Exp_Date ="";
String Alt_Id3_Type    ="";
String Alt_Id3_No     ="";
String Alt_Id3_Exp_Date  ="";
String Alt_Id4_Type   ="";
String Alt_Id4_No     ="";
String  Alt_Id4_Exp_Date ="";
String Family_Link_No    ="";
String Relationship_To_Head ="";
String Relationship_Name  ="";
String Name_Prefix     ="";
String First_Name      ="";
String Second_Name    ="";
String Third_Name     ="";
String Family_Name    ="";
String Name_Suffix   ="";
String Sex          ="";
String Date_Of_Birth  ="";
String Place_Of_Birth ="";
String birth_place_code = "";
String birth_place_desc = "";
String Mar_Status_Code  ="";
String Mar_Status_Desc ="";
String Alias_Name   ="";
String Relgn_Code   ="";
String Relgn_Desc   ="";
String Nationality_Code ="";
String Nationality_Desc  ="";
String Mother_Maiden_Name ="";
String Pat_Cat_Code       ="";
String Pat_Cat_Desc    ="";
String Ref_Source_Code  ="";
String Ref_Source_Desc  ="";
String Age="";
String regn_facility_name = "";


String First_Name_Accept_Yn ="";
int First_Name_Order=0;
String First_Name_Prompt ="";
String Second_Name_Accept_Yn ="";
int Second_Name_Order =0;
String Second_Name_Prompt ="";
String Third_Name_Accept_Yn ="";
int Third_Name_Order =0;
String Third_Name_Prompt ="";
String Family_Name_Accept_Yn ="";
int Family_Name_Order =0;
String Family_Name_Prompt ="";
String Name_Suffix_Accept_Yn ="";
String Name_Suffix_Prompt ="";
String Name_Prefix_Accept_Yn = "";
String Name_Prefix_Prompt = "";
String Family_No_Link_Yn="";
String Resi_Addr_Line1="";	
String Resi_Addr_Line2="";
String Resi_Addr_Line3="";
String Resi_Addr_Line4="";
String Resi_Postal_Code="";
String Resi_Country_Name="";
String Resi_Invalid1_Yn="";
String Resi_Contact1_Name="";
String Resi_Area_Desc="";
String Resi_Town_Desc="";
String Mail_Addr_Line1="";
String Mail_Addr_Line2="";
String Mail_Addr_Line3="";
String Mail_Addr_Line4="";

String name_prefix_loc_lang  =""   ;
String first_name_loc_lang      =""  ;
String second_name_loc_lang=""    ; 
String third_name_loc_lang    =""    ;
String family_name_loc_lang  =""   ;
String name_suffix_loc_lang   =""  ;
String patient_name_loc_lang=""    ;

String Mail_Postal_Code="";
String Mail_Country_Name="";
String Mail_Invalid1_Yn="";
String Mail_Contact1_Name="";

String Prn_Tel_No="";
String Orn_Tel_No="";
String Contact3_Mode="";
String Contact4_Mode="";
String Contact5_Mode="";
String CONTACT3_MODE_DESC="";
String CONTACT4_MODE_DESC="";
String CONTACT5_MODE_DESC="";
String Contact3_No="";
String Contact4_No="";
String Contact5_No="";
String email_id = "";

String Nkin_Contact_Name="";
String Nkin_Job_Title ="";
String Nkin_Addr_Line1 ="";
String Nkin_Addr_Line2="";
String Nkin_Addr_Line3="";
String Nkin_Addr_Line4="";
String Nkin_Region_Code="";
String Nkin_Area_Code = "";
String Nkin_Town_Code="";
String Nkin_Postal_Desc ="";
String Nkin_Postal_Code ="";
String Nkin_Country_Code="";
String Nkin_Country_Name="";
String Nkin_Res_Tel_No ="";
String Nkin_Off_Tel_No=""; 
String Fton_Contact_Relation_Desc="";

String Fton_Contact_Name="";
String Fton_Job_Title ="";
String Fton_Addr_Line1="";
String Fton_Addr_Line2 ="";
String Fton_Addr_Line3 ="";
String Fton_Addr_Line4  ="";
String Fton_Postal_Code ="";
String Fton_Country_Code="";
String Fton_Country_Name ="";
String Fton_Res_Tel_No ="";
String Fton_Off_Tel_No ="";
String Nkin_Contact_Relation_Desc="";

String Ocpn_Desc="";
String Patient_Employee_Id="";
String Employment_Status="";
String Emplr_Contact_Name="";
String Emplr_Job_Title="";
String Emplr_Addr_Line1="";
String Emplr_Addr_Line2="";
String Emplr_Addr_Line3="";
String Emplr_Addr_Line4="";
String Emplr_Postal_Code="";

String Emplr_Country_Name="";
String Emplr_Res_Tel_No="";
String Emplr_Off_Tel_No="";
String Off_Fax_No="";
String Living_Dependency="";
String Living_Arrangement="";
String Education_Level="";
String Informant="";
String Informant_Remarks="";
String General_Remarks="";

String Suspend_Yn       = "";
String Status_Reason_Desc   = "";
String Status_Remarks       = "";
String Active_Yn        = "";
String Last_Contact_Date    = "";
String Deceased_Yn      = "";
String Deceased_Date        = "";
String Death_Status_Remarks     = "";
String cust_fields[] = new String[5];

String nat_id_prompt = "";
String added_by_id = "";
String added_user_name  = "";
String added_date = "";
String added_at_ws_no = "";
String added_facility_id = "";
String added_facility_name = "";
String modified_by_id = "";
String modified_user_name = "";
String modified_date = "";
String modified_at_ws_no = "";
String modified_facility_id  = "";
String modified_facility_name  = "";

String name_prefix_loc_lang_prompt  ="" ;
String first_name_loc_lang_prompt   ="" ;
String second_name_loc_lang_prompt  ="" ;
String third_name_loc_lang_prompt   ="" ;
String family_name_loc_lang_prompt  ="" ;
String name_suffix_loc_lang_prompt  ="" ;
String head_patient_name = "";
String mail_res_area_desc = ""; //added by Dheeraj
String mail_res_town_desc = ""; //added by Dheeraj
String language_name  = "";
//String LANGUAGE_ID = ""; 

ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageFrame",p) ;
String[] contact_col_names = (String[])contact_addr.get(1) ;
String[] contact_prompts   = (String[])contact_addr.get(2) ;
String Addr_val = "";
String related_Addr_val = ""; // added by Dheeraj
String nKin_Addr_val = ""; // added by Dheeraj
String data_source = "";
//Added by kumar on 17/03/2003 for Malaysia Enhancements
String mail_region_desc = "", region_desc = "", race_long_desc = "",ethnic_long_desc="";
//End of Code

////////////////////////////////////////////////////////////// suresh 16/08/2003
String contact1_birth_date="";

String nkin_town_desc="";
String fton_town_desc="";
String emplr_town_desc="";

String nkin_area_desc="";
String fton_area_desc="";	
String emplr_area_desc="";	

String nkin_region_desc="";
String fton_region_desc="";
String emplr_region_desc="";

String nkin_mob_tel_no="";
String fton_mob_tel_no="";

String nkin_email_id="";
String fton_email_id="";

String organization_name="";
String emplr_ocpn_class_desc="";

String demo_oth_alt_id_desc="";
String demo_oth_alt_id_no="";

String fton_alt_desc="";
String fton_alt_id_no="";

String nkin_oth_alt_desc="";
String nkin_oth_alt_id_no="";

/* Friday, April 30, 2010 venkat s PE_EXE
String aid2=null;
String aid3=null;
String aid4=null; */
String contact1_alt_id1_type="";		
String contact1_alt_id1_no="";		
String alt_id1_exp_date_accept_yn = "";
String alt_id2_exp_date_accept_yn = "";
String alt_id3_exp_date_accept_yn = "";
String alt_id4_exp_date_accept_yn = "";
String accept_oth_alt_id_yn = "";
String contact1_alt_id2_type="";		
String contact1_alt_id2_no="";		
String contact1_alt_id3_type="";		
String contact1_alt_id3_no="";		
String contact1_alt_id4_type="";		
String contact1_alt_id4_no="";	
String contact1_nat_id_no="";	
String fton_nat_id_no="";	
String doc_or_file="";	

//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
String create_file_yn="";


String names_in_oth_lang_yn="";	
//Newly added by shyam on 21/02/2006
String MembershipType="";	
String Orgsubname="";	
String Orgname="";	
String patexpirtydate="";
String accept_national_id_no_yn="";

String  doc1_exp_date="";
String  doc1_iss_date="";
String  doc2_exp_date="";
String  doc2_iss_date="";
String  doc3_exp_date="";
String  doc3_iss_date="";
String  doc4_exp_date="";
String  doc4_iss_date="";

String blood_grp_desc=" ";
String rh_factor_desc=" ";

String contactModeOne = "";
String contactModeTwo = "";
// Tuesday, May 04, 2010  PE_EXE Venkat S 
String doc1_type_desc="";
String doc1_num="";
String doc1_place_of_issue="";

String doc2_type_desc="";
String doc2_num="";
String doc2_place_of_issue="";

String doc3_type_desc="";
String doc3_num="";
String doc3_place_of_issue="";

String doc4_type_desc="";
String doc4_num="";
String doc4_place_of_issue="";
int file_cnt=0;
/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
InputStream  doc1=null; 
InputStream  doc2=null; 
InputStream  doc3=null; 
InputStream  doc4=null; 
/* end PMG2012-CRF-0006 [IN034693] */ 

//for Hijri MMS-QH-CRF-0145
String hijri_birth_date="";  
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");
boolean chkAadhaarValidate = CommonBean.isSiteSpecific(con, "MP","AADHAAR_PROFILE");
// end  PE_EXE 
/*
	HashMap hash_mp_param=new HashMap();
	hash_mp_param=eMP.NewbornDetails.getNewBornRelMandatory(con,p);
*/
sql.append("SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type, Alt_Id2_type, Alt_Id3_type, Alt_Id4_type, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn , nvl(First_Name_Order,'0') First_Name_Order, nvl(First_Name_Prompt,'First Name') First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, nvl(Second_Name_Order,'0') Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn, nvl(Third_Name_Order,'0') Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn, nvl(Family_Name_Order,'0') Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt, name_dervn_logic, nvl(Alt_Id1_length,'0') Alt_Id1_length, nvl(Alt_Id2_length,'0') Alt_Id2_length, nvl(Alt_Id3_length,'0') Alt_Id3_length, nvl(Alt_Id4_length,'0') Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N') name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix') name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix') name_prefix_prompt, nvl(first_name_reqd_yn,'N') first_name_reqd_yn, nvl(second_name_reqd_yn,'N') second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N') family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N') name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length, nvl(citizen_nationality_code,'') citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N') Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N') Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N') Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N') Alt_Id4_Unique_yn, nat_id_length, nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N') ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, alt_id1_routine_yn, alt_id1_data_source_id alt_id1_routine, alt_id2_routine_yn, alt_id2_data_source_id alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NAT_ID_PAT_SER_GRP, nvl(ID_CHANGE_ALLOWED_FOR_SERIES,'*') ID_CHANGE_ALLOWED_FOR_SERIES, nvl(ADDL_FIELD1_PROMPT,'') ADDL_FIELD1_PROMPT, nvl(ADDL_FIELD1_LENGTH,'0') ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'') ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'') ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0') ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'') ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'') ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0') ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'') ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'') ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0') ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'') ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'') ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0') ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'') ADDL_FIELD5_SECTION, nvl(nat_id_prompt,'National Id No') nat_id_prompt, nvl(NAT_ID_CHK_LEN,'N') NAT_ID_CHK_LEN, nat_id_check_digit_id,  alt_id1_chk_digit_scheme, alt_id2_chk_digit_scheme, alt_id3_chk_digit_scheme, alt_id4_chk_digit_scheme, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'&nbsp;') FIRST_NAME_LOC_LANG_PROMPT, nvl(SECOND_NAME_LOC_LANG_PROMPT,'&nbsp;') SECOND_NAME_LOC_LANG_PROMPT, nvl(THIRD_NAME_LOC_LANG_PROMPT,'&nbsp;') THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'&nbsp;') FAMILY_NAME_LOC_LANG_PROMPT, nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_SUFFIX_LOC_LANG_PROMPT, accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn, alt_id1_accept_alphanumeric_yn, invoke_routine, nat_data_source_id, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn, nat_id_reqd_all_series, Accept_oth_alt_id_yn, alt_id1.long_desc alt_id1_desc, alt_id2.long_desc alt_id2_desc, alt_id3.long_desc alt_id3_desc, alt_id4.long_desc alt_id4_desc, ext_system_interface_yn, default_race_code, names_in_oth_lang_yn, to_char(sysdate,'dd/mm/yyyy') ServerDate, dflt_alt_id1_in_emp_id_yn, nb_mother_cutoff_age,create_file_yn,maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn FROM mp_param_lang_vw, mp_alternate_id_type_lang_vw alt_id1, mp_alternate_id_type_lang_vw alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id(+) = '"+locale+"' and alt_id2.language_id(+) = '"+locale+"' and alt_id3.language_id(+) = '"+locale+"' and alt_id4.language_id(+) = '"+locale+"' and mp_param_lang_vw.language_id = '"+locale+"'" );

pstmt = con.prepareStatement(sql.toString());
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
        Alt_Id1_Type = rs.getString("Alt_Id1_Type")==null ? "" : rs.getString("alt_id1_desc");
        Alt_Id2_Type = rs.getString("Alt_Id2_Type")==null ? "" : rs.getString("alt_id2_desc");
        Alt_Id3_Type = rs.getString("Alt_Id3_Type")==null ? "" : rs.getString("alt_id3_desc");
        Alt_Id4_Type = rs.getString("Alt_Id4_Type")==null ? "" : rs.getString("alt_id4_desc");
		
		alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn")==null ? "" : rs.getString("alt_id1_exp_date_accept_yn");

		alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn")==null ? "" : rs.getString("alt_id2_exp_date_accept_yn");
			
		alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn")==null ? "" : rs.getString("alt_id3_exp_date_accept_yn");

		alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn")==null ? "" : rs.getString("alt_id4_exp_date_accept_yn");

		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "" : rs.getString("accept_oth_alt_id_yn");
		names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null ? "N" : rs.getString("names_in_oth_lang_yn");

		First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
        First_Name_Order = rs.getInt("First_Name_Order");
        First_Name_Prompt = rs.getString("First_Name_Prompt") == null ? "" : rs.getString("First_Name_Prompt");
        Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
        Second_Name_Order = rs.getInt("Second_Name_Order");
        Second_Name_Prompt = rs.getString("Second_Name_Prompt") == null ? "" : rs.getString("Second_Name_Prompt");
        Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
        Third_Name_Order = rs.getInt("Third_Name_Order");
        Third_Name_Prompt = rs.getString("Third_Name_Prompt") == null ? "" : rs.getString("Third_Name_Prompt");
        Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
        Family_Name_Order = rs.getInt("Family_Name_Order");
        Family_Name_Prompt = rs.getString("Family_Name_Prompt")== null ? "" : rs.getString("Family_Name_Prompt");

        Name_Prefix_Accept_Yn = rs.getString("Name_Prefix_Accept_Yn");
        Name_Suffix_Accept_Yn = rs.getString("Name_Suffix_Accept_Yn");
        Name_Prefix_Prompt = rs.getString("Name_Prefix_Prompt");
        Name_Suffix_Prompt = rs.getString("Name_Suffix_Prompt");

        Family_No_Link_Yn = rs.getString("family_no_link_yn");
        
        cust_fields[0] = rs.getString("addl_field1_section")+"`"+rs.getString("ADDL_FIELD1_PROMPT");
        cust_fields[1] = rs.getString("addl_field2_section")+"`"+rs.getString("ADDL_FIELD2_PROMPT");
        cust_fields[2] = rs.getString("addl_field3_section")+"`"+rs.getString("ADDL_FIELD3_PROMPT");
        cust_fields[3] = rs.getString("addl_field4_section")+"`"+rs.getString("ADDL_FIELD4_PROMPT");
        cust_fields[4] = rs.getString("addl_field5_section")+"`"+rs.getString("ADDL_FIELD5_PROMPT");
        nat_id_prompt = rs.getString("nat_id_prompt");
        
        name_prefix_loc_lang_prompt     =rs.getString("name_prefix_loc_lang_prompt");
        first_name_loc_lang_prompt      =rs.getString("first_name_loc_lang_prompt");
        second_name_loc_lang_prompt     =rs.getString("second_name_loc_lang_prompt");
        third_name_loc_lang_prompt      =rs.getString("third_name_loc_lang_prompt");
        family_name_loc_lang_prompt     =rs.getString("family_name_loc_lang_prompt");
        name_suffix_loc_lang_prompt     =rs.getString("name_suffix_loc_lang_prompt");
        doc_or_file						=rs.getString("maintain_doc_or_file");
		
		//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
		create_file_yn					=rs.getString("create_file_yn");
		
		
        accept_national_id_no_yn						=rs.getString("accept_national_id_no_yn");
        family_org_id_accept_yn						=rs.getString("family_org_id_accept_yn")==null?"":rs.getString("family_org_id_accept_yn");
        entitlement_by_pat_cat_yn						=rs.getString("entitlement_by_pat_cat_yn")==null?"":rs.getString("entitlement_by_pat_cat_yn");	
    }
}

            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(view_pat_photo_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);

try{ 
	try{   
  sql2.append("SELECT patient.patient_name Patient_Name, patient.pat_ser_grp_code pat_ser_grp_code, (CASE WHEN patient.pat_ser_grp_code IS NOT NULL THEN (mp_get_desc.mp_pat_ser_grp(patient.pat_ser_grp_code,'"+locale+"',2)) END ) pat_ser_grp_desc, NVL(pat_ser_grp.ID_TYPE, '') ID_TYPE, pat_ser_grp.allow_family_no_yn, pat_ser_grp.pat_name_in_loc_lang_reqd_yn, patient.national_id_no national_id_no, patient.pref_facility_id pref_facility_id, (CASE WHEN patient.pref_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.pref_facility_id, '"+locale+"', 1)) END ) pref_facility_name, patient.regn_facility_id regn_facility_id, (CASE WHEN patient.regn_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.regn_facility_id, '"+locale+"', 1)) END ) regn_facility_name, patient.alt_id1_type alt_id1_type, (CASE WHEN patient.alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id1_type,'"+locale+"',1)) END ) alt_id1_desc, patient.alt_id1_no alt_id1_no, to_char(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, patient.alt_id2_type alt_id2_type, (CASE WHEN patient.alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id2_type,'"+locale+"',2)) END ) alt_id2_desc, patient.alt_id2_no alt_id2_no, to_char(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, patient.alt_id3_type alt_id3_type, (CASE WHEN patient.alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id3_type,'"+locale+"',2)) END ) alt_id3_desc, patient.alt_id3_no alt_id3_no, to_char(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, patient.alt_id4_type alt_id4_type, (CASE WHEN patient.alt_id4_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id4_type,'"+locale+"',2)) END ) alt_id4_desc, patient.alt_id4_no alt_id4_no, to_char(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, patient.oth_alt_id_type oth_alt_id_type, (CASE WHEN patient.oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.oth_alt_id_type,'"+locale+"',1)) END ) demo_oth_alt_id_desc, patient.oth_alt_id_no demo_oth_alt_id_no, patient.family_link_no family_link_no, (CASE WHEN patient.family_link_no IS NOT NULL THEN (mp_get_desc.mp_patient(patient.family_link_no,1)) END ) head_patient_name, patient.relationship_to_head relationship_to_head, (CASE WHEN patient.relationship_to_head IS NOT NULL THEN (mp_get_desc.mp_relationship(patient.relationship_to_head,'"+locale+"',2)) END ) relationship_name, patient.name_prefix name_prefix, patient.first_name first_name, patient.second_name second_name, patient.third_name third_name, patient.family_name family_name, patient.name_suffix name_suffix, patient.name_prefix_loc_lang name_prefix_loc_lang, patient.first_name_loc_lang first_name_loc_lang, patient.second_name_loc_lang second_name_loc_lang, patient.third_name_loc_lang third_name_loc_lang, patient.family_name_loc_lang family_name_loc_lang, patient.name_suffix_loc_lang name_suffix_loc_lang, patient.patient_name_loc_lang patient_name_loc_lang, patient.sex sex, to_char(patient.date_of_birth, 'dd/mm/yyyy') date_of_birth, patient.calculated_age_yn calculated_age_yn, patient.birth_place_code birth_place_code, (CASE WHEN patient.birth_place_code IS NOT NULL THEN (mp_get_desc.mp_birth_place(patient.birth_place_code,'"+locale+"',1))  END ) birth_place_desc, patient.place_of_birth place_of_birth, patient.mar_status_code mar_status_code, (CASE WHEN patient.mar_status_code IS NOT NULL THEN (mp_get_desc.mp_marital_status(patient.mar_status_code,'"+locale+"',2)) END ) mar_status_desc, patient.alias_name alias_name, patient.relgn_code relgn_code, (CASE WHEN patient.relgn_code IS NOT NULL THEN (mp_get_desc.mp_religion(patient.relgn_code,'"+locale+"',2)) END ) relgn_desc, patient.ethnic_grp_code ethnic_grp_code, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',2)) END ) ethnic_short_desc, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',1)) END ) ethnic_long_desc, patient.race_code race_code, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',2)) END ) race_short_desc, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',1)) END ) race_long_desc, patient.citizen_yn CITIZEN_YN, patient.legal_yn LEGAL_YN, patient.nationality_code nationality_code, (CASE WHEN patient.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(patient.nationality_code,'"+locale+"',3)) END ) nationality_desc, patient.mother_maiden_name mother_maiden_name, patient.pat_cat_code pat_cat_code, (CASE WHEN patient.pat_cat_code IS NOT NULL THEN (mp_get_desc.mp_pat_category(patient.pat_cat_code,'"+locale+"',2)) END ) pat_cat_desc, patient.referral_facility_id referral_facility_id, patient.ref_source_code ref_source_code, NULL ref_source_desc, pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal1_code,'"+locale+"',2) resi_postal_code, pat_addr.country1_code resi_country_code, (CASE WHEN pat_addr.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country1_code,'"+locale+"',1)) END ) resi_country_name, pat_addr.invalid1_yn resi_invalid1_yn, pat_addr.contact1_name resi_contact1_name, patient.res_area_code res_area_code, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',2)) END ) res_area_desc, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',1)) END ) res_area_long_desc, patient.res_town_code res_town_code, (CASE WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',2)) END ) res_town_desc, (CASE WHEN patient.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',1)) END ) res_town_long_desc, patient.region_code region_code, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',2)) END ) region_desc, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',1)) END ) region_long_desc, pat_addr.addr2_line1 mail_addr_line1, pat_addr.addr2_line2 mail_addr_line2, pat_addr.addr2_line3 mail_addr_line3, pat_addr.addr2_line4 mail_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal2_code,'"+locale+"',2) mail_postal_code, pat_addr.country2_code mail_country_code, (CASE WHEN pat_addr.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country2_code,'"+locale+"',1)) END ) mail_country_name, pat_addr.invalid2_yn mail_invalid1_yn, pat_addr.contact2_name mail_contact1_name, pat_addr.res_area2_code mail_res_area, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',2)) END ) mail_res_area_desc, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',1)) END ) mail_res_area_long_desc, pat_addr.res_town2_code mail_res_town, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',2)) END ) mail_res_town_desc, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',1))            END ) mail_res_town_long_desc, pat_addr.region2_code mail_region_code, (CASE WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',2)) END ) mail_region_desc, (CASE WHEN pat_addr.region2_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',1)) END ) mail_region_long_desc, patient.contact1_no prn_tel_no, patient.contact2_no orn_tel_no, patient.email_id email_id, patient.contact3_mode contact3_mode, (CASE WHEN patient.contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact3_mode,'"+locale+"',2)) END ) contact3_mode_desc, patient.contact3_no contact3_no, patient.contact4_mode contact4_mode, (CASE WHEN patient.contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact4_mode,'"+locale+"',2)) END ) contact4_mode_desc, patient.contact4_no contact4_no, patient.contact5_mode contact5_mode, (CASE WHEN patient.contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact5_mode,'"+locale+"',2)) END ) contact5_mode_desc, patient.contact5_no contact5_no, pat_rl_con.contact1_name nkin_contact_name, pat_rl_con.job1_title nkin_job_title, pat_rl_con.contact1_relation nkin_contact_relation, (CASE WHEN pat_rl_con.contact1_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact1_relation,'"+locale+"',2)) END ) nkin_contact_relation_desc,  to_char(pat_rl_con.contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, pat_rl_con.contact1_nat_id_no, pat_rl_con.contact1_alt_id1_type, (CASE WHEN pat_rl_con.contact1_alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id1_type,'"+locale+"',2)) END ) nkin_alt_id1_desc, pat_rl_con.contact1_alt_id1_no, pat_rl_con.contact1_alt_id2_type, (CASE WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id2_type,'"+locale+"',2)) END ) nkin_alt_id2_desc, pat_rl_con.contact1_alt_id2_no, pat_rl_con.contact1_alt_id3_type, (CASE WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id3_type,'"+locale+"',2)) END ) nkin_alt_id3_desc,  pat_rl_con.contact1_alt_id3_no, pat_rl_con.contact1_alt_id4_type, (CASE WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id4_type,'"+locale+"',2)) END ) nkin_alt_id4_desc, pat_rl_con.contact1_alt_id4_no, pat_rl_con.contact1_oth_alt_id_type, (CASE WHEN pat_rl_con.contact1_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_oth_alt_id_type,'"+locale+"',1)) END ) nkin_oth_alt_desc, pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no, pat_rl_con.addr1_line1 nkin_addr_line1,  pat_rl_con.addr1_line2 nkin_addr_line2, pat_rl_con.addr1_line3 nkin_addr_line3, pat_rl_con.addr1_line4 nkin_addr_line4, pat_rl_con.contact1_res_town_code, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',2)) END ) nkin_town_desc, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',1)) END ) nkin_town_long_desc, pat_rl_con.contact1_res_area_code, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',2)) END ) nkin_area_desc, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',1)) END ) nkin_area_long_desc, pat_rl_con.contact1_region_code, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',2)) END ) nkin_region_desc, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',1)) END ) nkin_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal1_code,'"+locale+"',2)  nkin_postal_code, pat_rl_con.country1_code nkin_country_code, (CASE WHEN pat_rl_con.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country1_code,'"+locale+"',1))  END ) nkin_country_name, pat_rl_con.res1_tel_no nkin_res_tel_no, pat_rl_con.off1_tel_no nkin_off_tel_no, pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no, pat_rl_con.contact1_email_id nkin_email_id, pat_rl_con.contact2_relation fton_contact_relation, (CASE WHEN pat_rl_con.contact2_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact2_relation,'"+locale+"',2)) END ) fton_contact_relation_desc,  pat_rl_con.contact2_name fton_contact_name, pat_rl_con.contact2_nat_id_no fton_nat_id_no, pat_rl_con.contact2_oth_alt_id_type, (CASE WHEN pat_rl_con.contact2_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact2_oth_alt_id_type,'"+locale+"',1)) END ) fton_alt_desc, pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no, pat_rl_con.job2_title fton_job_title, pat_rl_con.addr2_line1 fton_addr_line1, pat_rl_con.addr2_line2 fton_addr_line2, pat_rl_con.addr2_line3 fton_addr_line3, pat_rl_con.addr2_line4 fton_addr_line4, pat_rl_con.contact2_res_town_code, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',2)) END ) fton_town_desc, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',1)) END ) fton_town_long_desc, pat_rl_con.contact2_res_area_code, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',2)) END ) fton_area_desc, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',1)) END ) fton_area_long_desc, pat_rl_con.contact2_region_code, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',2)) END ) fton_region_desc, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',1)) END ) fton_region_long_desc, mp_get_desc.mp_postal_code(pat_rl_con.postal2_code,'"+locale+"',2) fton_postal_code, pat_rl_con.country2_code fton_country_code,          (CASE WHEN pat_rl_con.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country2_code,'"+locale+"',1)) END ) fton_country_name, pat_rl_con.contact2_mob_tel_no fton_mob_tel_no, pat_rl_con.contact2_email_id fton_email_id, pat_rl_con.res2_tel_no fton_res_tel_no, pat_rl_con.off2_tel_no fton_off_tel_no, pat_rl_con.organization_name,   pat_rl_con.patient_employee_id patient_employee_id,pat_rl_con.employment_status employment_status, pat_rl_con.contact3_name emplr_contact_name, pat_rl_con.job3_title emplr_job_title, pat_rl_con.contact3_relation emplr_contact_relation, (CASE WHEN pat_rl_con.contact3_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact3_relation,'"+locale+"',2)) END ) emplr_contact_relation_desc,           pat_rl_con.ocpn_class_code, (CASE WHEN pat_rl_con.ocpn_class_code IS NOT NULL THEN (mp_get_desc.mp_occupation_class(pat_rl_con.ocpn_class_code,'"+locale+"',1)) END ) emplr_ocpn_class_desc,           pat_rl_con.ocpn_code ocpn_code, (CASE WHEN pat_rl_con.ocpn_code IS NOT NULL THEN (mp_get_desc.mp_occupation(pat_rl_con.ocpn_code,'"+locale+"',2))  ELSE ocpn_desc END ) occupation_desc,   pat_rl_con.addr3_line1 emplr_addr_line1, pat_rl_con.addr3_line2 emplr_addr_line2, pat_rl_con.addr3_line3 emplr_addr_line3,  pat_rl_con.addr3_line4 emplr_addr_line4, pat_rl_con.contact3_res_town_code, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',2)) END ) emplr_town_desc, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',1)) END ) emplr_town_long_desc, pat_rl_con.contact3_res_area_code, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',2)) END ) emplr_area_desc, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',1)) END ) emplr_area_long_desc, pat_rl_con.contact3_region_code, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',2)) END ) emplr_region_desc, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',1))    END ) emplr_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal3_code,'"+locale+"',2)  emplr_postal_code, pat_rl_con.country3_code emplr_country_code, (CASE WHEN pat_rl_con.country3_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country3_code,'"+locale+"',1))            END ) emplr_country_name, pat_rl_con.off3_tel_no emplr_off_tel_no, pat_rl_con.res3_tel_no emplr_res_tel_no, pat_rl_con.off_fax_no off_fax_no,pat_oth_dtls.living_dependency living_dependency, pat_oth_dtls.living_arrangement living_arrangement, mr_get_desc.mr_blood_grp(pat_oth_dtls.blood_grp,'"+locale+"',2) blood_grp_desc, mr_get_desc.mr_rhesus_factor(pat_oth_dtls.rh_factor,'"+locale+"',2) rh_factor_desc, pat_oth_dtls.education_level education_level, (CASE WHEN pat_oth_dtls.education_level IS NOT NULL THEN (mp_get_desc.mp_education_level(pat_oth_dtls.education_level,'"+locale+"',2)) END ) educ_level_desc, pat_oth_dtls.regn_informant informant, pat_oth_dtls.regn_comments informant_remarks, pat_oth_dtls.general_remarks general_remarks, patient.suspend_yn suspend_yn ,patient.hijri_birth_date hijri_birth_date, patient.status_reason_code status_reason_code, (CASE WHEN patient.status_reason_code IS NOT NULL THEN (mp_get_desc.mp_pat_susp_reason(patient.status_reason_code,'"+locale+"',2)) END ) status_reason_desc, patient.status_remarks status_remarks, patient.active_yn active_yn, to_char(patient.last_contact_date,'dd/mm/yyyy') last_contact_date, patient.deceased_yn deceased_yn, to_char(patient.deceased_date,'dd/mm/yyyy') deceased_date, patient.death_status_remarks death_status_remarks, patient.primary_language_id primary_language_id, patient.language_id pat_language_id,(CASE WHEN patient.language_id IS NOT NULL THEN (mp_get_desc.mp_language(patient.language_id,'"+locale+"',1)) END ) language_name,  pat_oth_dtls.addl_field1 addl_field1, (CASE WHEN pat_oth_dtls.addl_field1 IS NOT NULL THEN (SELECT addl_field1_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field1_prompt, (CASE WHEN pat_oth_dtls.addl_field2 IS NOT NULL THEN (SELECT addl_field2_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field2_prompt, pat_oth_dtls.addl_field2 addl_field2, (CASE WHEN pat_oth_dtls.addl_field3 IS NOT NULL THEN (SELECT addl_field3_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field3_prompt, pat_oth_dtls.addl_field3 addl_field3, (CASE WHEN pat_oth_dtls.addl_field4 IS NOT NULL THEN (SELECT addl_field4_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field4_prompt, pat_oth_dtls.addl_field4 addl_field4, (CASE WHEN pat_oth_dtls.addl_field5 IS NOT NULL THEN (SELECT addl_field5_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field5_prompt, pat_oth_dtls.addl_field5 addl_field5, patient.added_by_id, (CASE WHEN patient.added_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.added_by_id,'"+locale+"',1)) END ) added_user_name, TO_CHAR (patient.added_date, 'DD/MM/YYYY HH24:MI') added_date, patient.added_at_ws_no, patient.added_facility_id, (CASE WHEN patient.added_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.added_facility_id, '"+locale+"', 1))  END ) added_facility_name, patient.modified_by_id, (CASE WHEN patient.modified_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.modified_by_id,'"+locale+"',1)) END ) modified_user_name, TO_CHAR (patient.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, patient.modified_at_ws_no, patient.modified_facility_id, (CASE WHEN patient.modified_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.modified_facility_id, '"+locale+"', 1))END ) modified_facility_name, patient.pat_dtls_unknown_yn, patient.inhouse_birth_yn, patient.data_source data_source, MP_GET_AGE_YMDH(patient.date_of_birth,patient.deceased_date) age,/*  CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),1)||'Y'|| CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),2)||'M'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),3)||'D'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),4)||'H' age,*/ patient.FAMILY_ORG_MEMBERSHIP MembershipType, ( case when patient.FAMILY_ORG_SUB_ID is not null then (select FAMILY_ORG_SUB_NAME from mp_family_org_sub_lang_vw where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID= patient.FAMILY_ORG_SUB_ID and language_id = '"+locale+"') end) Orgsubname, (case when patient.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_lang_vw where FAMILY_ORG_ID= patient.FAMILY_ORG_ID and language_id = '"+locale+"') end) Orgname, to_char(patient.PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') patexpirtydate, ");  
  // Tuesday, May 04, 2010  PE_EXE Venkat S 
  sql2.append("(CASE WHEN f.doc1_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc1_type, '"+locale+"', 2)) END) doc1_type_desc,doc1_num,TO_CHAR(doc1_exp_date, 'DD/MM/YYYY') doc1_exp_date, doc1_place_of_issue, TO_CHAR(doc1_iss_date, 'DD/MM/YYYY') doc1_iss_date,");
  sql2.append("(CASE WHEN f.doc2_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc2_type, '"+locale+"',2)) END) doc2_type_desc, doc2_num, TO_CHAR(doc2_exp_date, 'DD/MM/YYYY') doc2_exp_date, doc2_place_of_issue, TO_CHAR(doc2_iss_date, 'DD/MM/YYYY') doc2_iss_date,");
  sql2.append("(CASE WHEN f.doc3_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc3_type, '"+locale+"', 2)) END) doc3_type_desc, doc3_num, TO_CHAR(doc3_exp_date, 'DD/MM/YYYY') doc3_exp_date, doc3_place_of_issue,       TO_CHAR(doc3_iss_date, 'DD/MM/YYYY') doc3_iss_date,");
  sql2.append("(CASE WHEN f.doc4_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc4_type, '"+locale+"', 2) ) END) doc4_type_desc, doc4_num, TO_CHAR(doc4_exp_date, 'DD/MM/YYYY') doc4_exp_date, doc4_place_of_issue,       TO_CHAR(doc4_iss_date, 'DD/MM/YYYY') doc4_iss_date,f.DOC1_IMAGE,f.DOC2_IMAGE,f.DOC3_IMAGE,f.DOC4_IMAGE,");


  if(group_status.equals(""))
  {   
	  if(disp_dup_pat_dtls.equals("Duplicate"))
	  {
		    sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	  
	  }
	  else
	  {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
			sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");
	      
	  }
  }else if(!group_status.equals(""))
  {
	if(disp_dup_pat_dtls.equals("Duplicate") && group_status.equals("S") )
	{	 	
			 sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	
	
	}	
	else
	{
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
		  sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f  WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");	
	       
	}

  }
 

pstmt = con.prepareStatement(sql2.toString());
pstmt.setString(1, patient);
rs=pstmt.executeQuery();
if(rs != null) {
    if(rs.next()) 
	{
       /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
	    doc1 = rs.getBinaryStream("DOC1_IMAGE");
		doc2 = rs.getBinaryStream("DOC2_IMAGE");
		doc3 = rs.getBinaryStream("DOC3_IMAGE");
		doc4 = rs.getBinaryStream("DOC4_IMAGE");
	  /* end PMG2012-CRF-0006 [IN034693] */ 
		
	Patient_id=rs.getString("Patient_id");
	  //Added for MMS-QH-CRF-0145
	  
	  hijri_birth_date =rs.getString("hijri_birth_date"); 
	  if(hijri_birth_date==null)hijri_birth_date=""; 
	  
	  //Added for MMS-QH-CRF-0145
	  
		citizen_yn=rs.getString("CITIZEN_YN");
		legal_yn=rs.getString("LEGAL_YN");

		if (citizen_yn == null) citizen_yn="&nbsp; ";
		if (legal_yn == null) legal_yn="&nbsp; ";

		Patient_Name=rs.getString("Patient_Name");
        Pat_Ser_Grp_Code= rs.getString("pat_ser_grp_code");
        Pat_Ser_Grp_Desc  =rs.getString("pat_ser_grp_desc") ;
        if (Pat_Ser_Grp_Desc == null) Pat_Ser_Grp_Desc="&nbsp; ";
        National_Id_No  =rs.getString("national_id_no");
		National_Id_No = eXH.XHUtil.getNationalID(Patient_id);
		if(National_Id_No ==null)National_Id_No ="&nbsp; ";
        Pref_Facility_Id  =rs.getString("pref_facility_id");
        if(Pref_Facility_Id==null) Pref_Facility_Id="";
		if(!Pref_Facility_Id.equals(""))
		{
			if(!Pref_Facility_Id.equals(Facility_Id))
			{
				out.println("<script>alert(getMessage('PREF_FCY_NOT_LOG_FCY','MP'));</script>");
			}
		}
        Pref_Facility_Name =rs.getString("pref_facility_name");
        if(Pref_Facility_Name==null)Pref_Facility_Name="&nbsp; ";

        Alt_Id1_No    =rs.getString("alt_id1_no") ;
        if(Alt_Id1_No ==null){Alt_Id1_No ="&nbsp; ";}

        Alt_Id1_Exp_Date  =rs.getString("alt_id1_exp_date");
        //if(Alt_Id1_Exp_Date==null)Alt_Id1_Exp_Date="&nbsp; ";
		if(Alt_Id1_Exp_Date!=null){
			Alt_Id1_Exp_Date=DateUtils.convertDate(Alt_Id1_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id1_Exp_Date="&nbsp;";


        Alt_Id2_No   =rs.getString("alt_id2_no");
        if(Alt_Id2_No==null){Alt_Id2_No="&nbsp; ";}

        regn_facility_name = rs.getString("regn_facility_name");
        if(regn_facility_name == null)  regn_facility_name = "&nbsp";
        
        Alt_Id2_Exp_Date =rs.getString("alt_id2_exp_date");
      //  if(Alt_Id2_Exp_Date==null)Alt_Id2_Exp_Date="&nbsp; ";
	  if(Alt_Id2_Exp_Date!=null){
			Alt_Id2_Exp_Date=DateUtils.convertDate(Alt_Id2_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id2_Exp_Date="&nbsp;";

        Alt_Id3_No     =rs.getString("alt_id3_no");
        if(Alt_Id3_No ==null){Alt_Id3_No ="&nbsp; ";}

        Alt_Id3_Exp_Date  =rs.getString("alt_id3_exp_date");

		if(Alt_Id3_Exp_Date!=null){
			Alt_Id3_Exp_Date=DateUtils.convertDate(Alt_Id3_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id3_Exp_Date="&nbsp;";

        Alt_Id4_No     =rs.getString("alt_id4_no");
        if(Alt_Id4_No  ==null){Alt_Id4_No  ="&nbsp; ";}
		

        Alt_Id4_Exp_Date =rs.getString("alt_id4_exp_date");
    	if(Alt_Id4_Exp_Date!=null){
			Alt_Id4_Exp_Date=DateUtils.convertDate(Alt_Id4_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id4_Exp_Date="&nbsp;";
		
        Family_Link_No    =rs.getString("family_link_no");
        if(Family_Link_No ==null)Family_Link_No ="&nbsp; ";

        Relationship_To_Head =rs.getString("relationship_to_head");
        if(Relationship_To_Head ==null)Relationship_To_Head ="&nbsp; ";
        Relationship_Name  =rs.getString("relationship_name");
        if(Relationship_Name==null)Relationship_Name="&nbsp; ";

        Name_Prefix     =rs.getString("name_prefix");
        if(Name_Prefix ==null)Name_Prefix ="&nbsp; ";

        First_Name      =rs.getString("first_name");
        if(First_Name==null)First_Name="&nbsp; ";

        Second_Name    =rs.getString("second_name");

        if(Second_Name==null)Second_Name="&nbsp; ";

        Third_Name     =rs.getString("third_name");
        if(Third_Name ==null)Third_Name ="&nbsp; ";

        Family_Name    =rs.getString("family_name");
        if(Family_Name==null)Family_Name="&nbsp; ";

        Name_Suffix   =rs.getString("name_suffix");
        if(Name_Suffix ==null)Name_Suffix ="&nbsp; ";

        name_prefix_loc_lang   =rs.getString("name_prefix_loc_lang");
        if(name_prefix_loc_lang ==null)name_prefix_loc_lang ="&nbsp; ";

        first_name_loc_lang   =rs.getString("first_name_loc_lang");
        if(first_name_loc_lang ==null)first_name_loc_lang =" &nbsp;";

        second_name_loc_lang   =rs.getString("second_name_loc_lang");
        if(second_name_loc_lang ==null)second_name_loc_lang =" &nbsp;";

        third_name_loc_lang   =rs.getString("third_name_loc_lang");
        if(third_name_loc_lang ==null)third_name_loc_lang =" &nbsp;";

        family_name_loc_lang   =rs.getString("family_name_loc_lang");
       
		if(family_name_loc_lang ==null)family_name_loc_lang ="&nbsp; ";

        name_suffix_loc_lang   =rs.getString("name_suffix_loc_lang");
        if(name_suffix_loc_lang ==null)name_suffix_loc_lang =" &nbsp;";

        patient_name_loc_lang   =rs.getString("patient_name_loc_lang");
        if(patient_name_loc_lang ==null)patient_name_loc_lang =" &nbsp;";
        
        head_patient_name = rs.getString("head_patient_name");
        if(head_patient_name == null)   head_patient_name = "&nbsp;" ;

        mail_res_area_desc = rs.getString("mail_res_area_long_desc");
        if(mail_res_area_desc == null)   mail_res_area_desc = "&nbsp;" ;

        mail_res_town_desc = rs.getString("mail_res_town_long_desc");
        if(mail_res_town_desc == null)   mail_res_town_desc = "&nbsp;" ;

		race_long_desc = rs.getString("race_long_desc");
        if(race_long_desc == null)   race_long_desc = "&nbsp;" ;

		ethnic_long_desc = rs.getString("ethnic_long_desc");
	    if(ethnic_long_desc == null)   ethnic_long_desc = "&nbsp;" ;

		region_desc = rs.getString("region_long_desc");
        if(region_desc == null)   region_desc = "&nbsp;" ;
		mail_region_desc = rs.getString("mail_region_long_desc");
        if(mail_region_desc == null)   mail_region_desc = "&nbsp;" ;

        Sex          =rs.getString("sex");
        if(Sex==null)Sex="";
	
		blood_grp_desc = rs.getString("blood_grp_desc");
		if(blood_grp_desc==null)
			blood_grp_desc="&nbsp; ";
		
		rh_factor_desc = rs.getString("rh_factor_desc");
		if(rh_factor_desc==null)
			rh_factor_desc="&nbsp; ";


        Date_Of_Birth  =rs.getString("date_of_birth");
        if(Date_Of_Birth==null)
			Date_Of_Birth=""; 
		else 
		{
			Date_Of_Birth=Date_Of_Birth.substring(0,10);
			Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale); 
		}
	
		contact1_birth_date=rs.getString("contact1_birth_date");
        if(contact1_birth_date==null)contact1_birth_date="";
		else
		{	
		contact1_birth_date=contact1_birth_date.substring(0,10);
		contact1_birth_date=DateUtils.convertDate(contact1_birth_date,"DMY","en",locale); 
		}

		nkin_town_desc = rs.getString("nkin_town_long_desc");
        if(nkin_town_desc == null)   nkin_town_desc = "&nbsp;" ;

		fton_town_desc = rs.getString("fton_town_long_desc");
        if(fton_town_desc == null)   fton_town_desc = "&nbsp;" ;

		emplr_town_desc = rs.getString("emplr_town_long_desc");
        if(emplr_town_desc == null)   emplr_town_desc = "&nbsp;" ;  


		nkin_area_desc = rs.getString("nkin_area_long_desc");
        if(nkin_area_desc == null)   nkin_area_desc = "&nbsp;" ;

		fton_area_desc = rs.getString("fton_area_long_desc");
        if(fton_area_desc == null)   fton_area_desc = "&nbsp;" ;

		emplr_area_desc = rs.getString("emplr_area_long_desc");
        if(emplr_area_desc == null)   emplr_area_desc = "&nbsp;" ;  


		nkin_region_desc = rs.getString("nkin_region_long_desc");
        if(nkin_region_desc == null)   nkin_region_desc = "&nbsp;" ;

		fton_region_desc = rs.getString("fton_region_long_desc");
        if(fton_region_desc == null)   fton_region_desc = "&nbsp;" ;

		emplr_region_desc = rs.getString("emplr_region_long_desc");
        if(emplr_region_desc == null)   emplr_region_desc = "&nbsp;" ;  

		nkin_mob_tel_no = rs.getString("nkin_mob_tel_no");
        if(nkin_mob_tel_no == null)   nkin_mob_tel_no = "&nbsp;" ;

		fton_mob_tel_no = rs.getString("fton_mob_tel_no");
        if(fton_mob_tel_no == null)   fton_mob_tel_no = "&nbsp;" ;

		nkin_email_id = rs.getString("nkin_email_id");
        if(nkin_email_id == null)   nkin_email_id = "&nbsp;" ;

		fton_email_id = rs.getString("fton_email_id");
        if(fton_email_id == null)   fton_email_id = "&nbsp;" ;

		organization_name = rs.getString("organization_name");
        if(organization_name == null)   organization_name = "&nbsp;" ;		

		emplr_ocpn_class_desc = rs.getString("emplr_ocpn_class_desc");
        if(emplr_ocpn_class_desc == null)   emplr_ocpn_class_desc = "&nbsp;" ;		

		demo_oth_alt_id_desc = rs.getString("demo_oth_alt_id_desc");
        if(demo_oth_alt_id_desc == null)   demo_oth_alt_id_desc = "&nbsp;" ;		

		demo_oth_alt_id_no = rs.getString("demo_oth_alt_id_no");
        if(demo_oth_alt_id_no == null)   demo_oth_alt_id_no = "&nbsp;" ;	

		fton_alt_desc = rs.getString("fton_alt_desc");
        if(fton_alt_desc == null)   fton_alt_desc = "&nbsp;";		

		fton_alt_id_no = rs.getString("fton_alt_id_no");
        if(fton_alt_id_no == null)   fton_alt_id_no = "&nbsp;";	

		nkin_oth_alt_desc = rs.getString("nkin_oth_alt_desc");
        if(nkin_oth_alt_desc == null)   nkin_oth_alt_desc = "&nbsp;" ;	

		nkin_oth_alt_id_no = rs.getString("nkin_oth_alt_id_no");
        if(nkin_oth_alt_id_no == null)   nkin_oth_alt_id_no = "&nbsp;" ;	

		contact1_alt_id1_type	 = rs.getString("nkin_alt_id1_desc");
        if(contact1_alt_id1_type	 == null)   contact1_alt_id1_type	 = "" ;	

		contact1_alt_id1_no = rs.getString("contact1_alt_id1_no");
        if(contact1_alt_id1_no == null)   contact1_alt_id1_no = "" ;	

		contact1_alt_id2_type = rs.getString("nkin_alt_id2_desc");
        if(contact1_alt_id2_type == null)   contact1_alt_id2_type = "" ;	

		contact1_alt_id2_no = rs.getString("contact1_alt_id2_no");
        if(contact1_alt_id2_no == null)   contact1_alt_id2_no = "" ;	

		contact1_alt_id3_type = rs.getString("nkin_alt_id3_desc");
        if(contact1_alt_id3_type == null)   contact1_alt_id3_type = "" ;	

		contact1_alt_id3_no = rs.getString("contact1_alt_id3_no");
        if(contact1_alt_id3_no == null)   contact1_alt_id3_no = "" ;	

		contact1_alt_id4_type = rs.getString("nkin_alt_id4_desc");
        if(contact1_alt_id4_type == null)   contact1_alt_id4_type = "" ;	

		contact1_alt_id4_no = rs.getString("contact1_alt_id4_no");
        if(contact1_alt_id4_no == null)   contact1_alt_id4_no = "" ;

		contact1_nat_id_no = rs.getString("contact1_nat_id_no");
        if(contact1_nat_id_no == null)   contact1_nat_id_no = "&nbsp;" ;

		fton_nat_id_no = rs.getString("fton_nat_id_no");
        if(fton_nat_id_no == null)   fton_nat_id_no = "&nbsp;" ;

        Place_Of_Birth =rs.getString("place_of_birth");
        if(Place_Of_Birth==null)Place_Of_Birth="";

		birth_place_code = rs.getString("birth_place_code");
		if(birth_place_code==null)birth_place_code="";

		birth_place_desc = rs.getString("birth_place_desc");
		if(birth_place_desc==null) birth_place_desc="";

        Mar_Status_Code  =rs.getString("mar_status_code");
        if(Mar_Status_Code==null)Mar_Status_Code="";

        Mar_Status_Desc =rs.getString("mar_status_desc");
        if(Mar_Status_Desc==null)Mar_Status_Desc="";

        Alias_Name   =rs.getString("alias_name");
        if(Alias_Name ==null)Alias_Name ="";

        Relgn_Code   =rs.getString("relgn_code" );
        if(Relgn_Code==null)Relgn_Code="";

        Relgn_Desc   =rs.getString("relgn_desc");
        if(Relgn_Desc ==null)Relgn_Desc ="";

        Nationality_Code =rs.getString("nationality_code");
        if(Nationality_Code==null)Nationality_Code="";

     // LANGUAGE_ID  =rs.getString("language_id");
      //  if(LANGUAGE_ID ==null)LANGUAGE_ID =""; 

		Nationality_Desc  =rs.getString("nationality_desc");
        if(Nationality_Desc ==null)Nationality_Desc ="";


        Mother_Maiden_Name =rs.getString("mother_maiden_name");
        if(Mother_Maiden_Name==null)Mother_Maiden_Name="";

		language_name = rs.getString("language_name");
		if(language_name==null)language_name="";
		
		Pat_Cat_Code       =rs.getString("pat_cat_code");
        if(Pat_Cat_Code ==null)Pat_Cat_Code ="";

        Pat_Cat_Desc    =rs.getString("pat_cat_desc");
        if(Pat_Cat_Desc  ==null)Pat_Cat_Desc  ="";

        Ref_Source_Code  =rs.getString("ref_source_code");
        if(Ref_Source_Code==null)Ref_Source_Code="";

        Ref_Source_Desc  =rs.getString("ref_source_desc" );
        if(Ref_Source_Desc==null)Ref_Source_Desc="";

        Resi_Addr_Line1=rs.getString("resi_addr_line1");
        if(Resi_Addr_Line1==null)Resi_Addr_Line1="";

        Resi_Addr_Line2=rs.getString("resi_addr_line2");
        if( Resi_Addr_Line2==null) Resi_Addr_Line2="";

        Resi_Addr_Line3=rs.getString("resi_addr_line3");
        if(Resi_Addr_Line3==null)Resi_Addr_Line3="";

        Resi_Addr_Line4=rs.getString("resi_addr_line4");
        if(Resi_Addr_Line4==null)Resi_Addr_Line4="";

        Resi_Postal_Code=rs.getString("resi_postal_code");
        if( Resi_Postal_Code==null)Resi_Postal_Code="";

        Resi_Country_Name=rs.getString("resi_country_name");
        if(Resi_Country_Name==null)Resi_Country_Name="";

        Resi_Invalid1_Yn=rs.getString("resi_invalid1_yn");
        if(Resi_Invalid1_Yn==null)Resi_Invalid1_Yn="";

        Resi_Contact1_Name=rs.getString("resi_contact1_name");
        if(Resi_Contact1_Name==null)Resi_Contact1_Name="";

        Resi_Area_Desc=rs.getString("res_area_long_desc");
        if(Resi_Area_Desc==null)Resi_Area_Desc="";

        Resi_Town_Desc=rs.getString("res_town_long_desc");
        if(Resi_Town_Desc==null)Resi_Town_Desc="";

        Mail_Addr_Line1=rs.getString("mail_addr_line1");
        if(Mail_Addr_Line1==null)Mail_Addr_Line1="";

        Mail_Addr_Line2=rs.getString("mail_addr_line2");
        if(Mail_Addr_Line2==null)Mail_Addr_Line2="";

        Mail_Addr_Line3=rs.getString("mail_addr_line3");
        if(Mail_Addr_Line3==null)Mail_Addr_Line3="";

        Mail_Addr_Line4=rs.getString("mail_addr_line4");
        if(Mail_Addr_Line4==null)Mail_Addr_Line4="";

        Mail_Postal_Code=rs.getString("mail_postal_code");
        if(Mail_Postal_Code==null)Mail_Postal_Code="";

        Mail_Country_Name=rs.getString("mail_country_name");
        if(Mail_Country_Name==null)Mail_Country_Name="";

        Mail_Invalid1_Yn=rs.getString("mail_invalid1_yn");
        if(Mail_Invalid1_Yn==null)Mail_Invalid1_Yn="";
    
        Mail_Contact1_Name=rs.getString("mail_contact1_name");
        if(Mail_Contact1_Name==null)Mail_Contact1_Name="";

        Prn_Tel_No=rs.getString("prn_tel_no");
        if(Prn_Tel_No==null)Prn_Tel_No="";

        Orn_Tel_No=rs.getString("orn_tel_no");
        if(Orn_Tel_No==null)Orn_Tel_No="";

        Contact3_Mode=rs.getString("contact3_mode");
        if(Contact3_Mode==null)Contact3_Mode="";

        Contact4_Mode=rs.getString("contact4_mode");
        if(Contact4_Mode==null)Contact4_Mode="";


        Contact5_Mode=rs.getString("contact5_mode");
        if(Contact5_Mode==null)Contact5_Mode="";

        Contact3_No=rs.getString("contact3_no");
        if(Contact3_No==null)Contact3_No="";

        Contact4_No=rs.getString("contact4_no");
        if(Contact4_No==null)Contact4_No="";

        Contact5_No=rs.getString("contact5_no");
        if(Contact5_No==null)Contact5_No="";

		email_id = rs.getString("email_id");
		if(email_id==null) email_id="";
		
        Nkin_Contact_Relation_Desc=rs.getString("nkin_contact_relation_desc");
        if(Nkin_Contact_Relation_Desc==null)Nkin_Contact_Relation_Desc="";

        Nkin_Contact_Name=rs.getString("nkin_contact_name");
        if(Nkin_Contact_Name==null)Nkin_Contact_Name="";

        Nkin_Job_Title =rs.getString("nkin_job_title");
        if(Nkin_Job_Title==null)Nkin_Job_Title="";

        Nkin_Addr_Line1 =rs.getString("nkin_addr_line1");
        if(Nkin_Addr_Line1==null)Nkin_Addr_Line1="";

        Nkin_Addr_Line2=rs.getString("nkin_addr_line2");
        if(Nkin_Addr_Line2==null)Nkin_Addr_Line2="";

        Nkin_Addr_Line3=rs.getString("nkin_addr_line3");
        if(Nkin_Addr_Line3==null)Nkin_Addr_Line3="";

        Nkin_Addr_Line4=rs.getString("nkin_addr_line4");
        if(Nkin_Addr_Line4==null)Nkin_Addr_Line4="";

        Nkin_Postal_Code =rs.getString("nkin_postal_code");
        if(Nkin_Postal_Code==null)Nkin_Postal_Code="";

        Nkin_Country_Code=rs.getString("nkin_country_code");
        if(Nkin_Country_Code==null)Nkin_Country_Code="";

        Nkin_Country_Name=rs.getString("nkin_country_name");
        if(Nkin_Country_Name==null)Nkin_Country_Name="";

        Nkin_Res_Tel_No =rs.getString("nkin_res_tel_no");
        if(Nkin_Res_Tel_No==null)Nkin_Res_Tel_No="";

        Nkin_Off_Tel_No=rs.getString("nkin_off_tel_no");
        if(Nkin_Off_Tel_No==null)Nkin_Off_Tel_No="";

        Fton_Contact_Relation_Desc =rs.getString("fton_contact_relation_desc");
        if(Fton_Contact_Relation_Desc==null)Fton_Contact_Relation_Desc="";

        Fton_Contact_Name=rs.getString("fton_contact_name");
        if(Fton_Contact_Name==null)Fton_Contact_Name="";

        Fton_Job_Title =rs.getString("fton_job_title");
        if(Fton_Job_Title==null)Fton_Job_Title="";

        Fton_Addr_Line1=rs.getString("fton_addr_line1");
        if(Fton_Addr_Line1==null)Fton_Addr_Line1="";

        Fton_Addr_Line2 =rs.getString("fton_addr_line2");
        if(Fton_Addr_Line2==null)Fton_Addr_Line2="";

        Fton_Addr_Line3 =rs.getString("fton_addr_line3");
        if(Fton_Addr_Line3==null)Fton_Addr_Line3="";

        Fton_Addr_Line4  =rs.getString("fton_addr_line4");
        if(Fton_Addr_Line4==null)Fton_Addr_Line4="";

        Fton_Postal_Code =rs.getString("fton_postal_code");
        if(Fton_Postal_Code==null)Fton_Postal_Code="";

        Fton_Country_Code=rs.getString("fton_country_code");
        if(Fton_Country_Code==null)Fton_Country_Code="";

        Fton_Country_Name =rs.getString("fton_country_name");
        if(Fton_Country_Name==null)Fton_Country_Name="";

        Fton_Res_Tel_No =rs.getString("fton_res_tel_no");
        if(Fton_Res_Tel_No==null)Fton_Res_Tel_No="";

        Fton_Off_Tel_No =rs.getString("fton_off_tel_no");
        if(Fton_Off_Tel_No==null)Fton_Off_Tel_No="";

        Ocpn_Desc=rs.getString("occupation_desc");
        if(Ocpn_Desc==null)Ocpn_Desc="";

        Patient_Employee_Id=rs.getString("patient_employee_id");
        if(Patient_Employee_Id==null)Patient_Employee_Id="";

        Employment_Status=rs.getString("employment_status");
        if(Employment_Status==null)Employment_Status="";
		
	   if(Employment_Status.equals("FE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("PE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("SE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("UE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("FS"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeStudent.label","mp_labels"); 
		}
		else if(Employment_Status.equals("PS"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeStudent.label","mp_labels"); 
		}
		else if(Employment_Status.equals("UK"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); 
		}
		else if(Employment_Status.equals("NA"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels"); 
		}
				


        Emplr_Contact_Name=rs.getString("emplr_contact_name");
        if(Emplr_Contact_Name==null)Emplr_Contact_Name="";

        Emplr_Job_Title=rs.getString("emplr_job_title");
        if(Emplr_Job_Title==null)Emplr_Job_Title="";

        Emplr_Addr_Line1=rs.getString("emplr_addr_line1");
        if(Emplr_Addr_Line1==null)Emplr_Addr_Line1="";

        Emplr_Addr_Line2=rs.getString("emplr_addr_line2");
        if(Emplr_Addr_Line2==null)Emplr_Addr_Line2="";

        Emplr_Addr_Line3=rs.getString("emplr_addr_line3");
        if(Emplr_Addr_Line3==null)Emplr_Addr_Line3="";

        Emplr_Addr_Line4=rs.getString("emplr_addr_line4");
        if(Emplr_Addr_Line4==null)Emplr_Addr_Line4="";

        Emplr_Postal_Code=rs.getString("emplr_postal_code");
        if(Emplr_Postal_Code==null)Emplr_Postal_Code="";

        Emplr_Country_Name=rs.getString("emplr_country_name");
        if(Emplr_Country_Name==null)Emplr_Country_Name="";


        Emplr_Res_Tel_No=rs.getString("emplr_res_tel_no");
        if(Emplr_Res_Tel_No==null)Emplr_Res_Tel_No="";

        Emplr_Off_Tel_No=rs.getString("emplr_off_tel_no");
        if(Emplr_Off_Tel_No==null)Emplr_Off_Tel_No="";

        Off_Fax_No=rs.getString("off_fax_no");
        if(Off_Fax_No==null)Off_Fax_No="";


        Living_Dependency=rs.getString("living_dependency");
        if(Living_Dependency==null)Living_Dependency="";

		if(Living_Dependency.equals("D"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpouseDependent.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("M"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MedicalSupervisionReqd.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("S"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SmallChildren.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("WU"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.WalkUp.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("UN"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotKnown.label","common_labels"); 
		}

        Living_Arrangement=rs.getString("living_arrangement");
        if(Living_Arrangement==null)Living_Arrangement="";

		if(Living_Arrangement.equals("A"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alone.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("F"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.family.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("R"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.relative.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("U"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); 
		}
		else if(Living_Arrangement.equals("S"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.spouseonly.label","mp_labels"); 
		}

        Education_Level=rs.getString("educ_level_desc");
        if(Education_Level==null)Education_Level="";

        Informant=rs.getString("informant");
        if(Informant==null)Informant="";

        Informant_Remarks=rs.getString("informant_remarks");
        if(Informant_Remarks==null)Informant_Remarks="";

        General_Remarks=rs.getString("general_remarks");
        if(General_Remarks==null)General_Remarks="";

        Suspend_Yn = rs.getString("suspend_yn");
        if (Suspend_Yn==null) Suspend_Yn="";

        Status_Reason_Desc = rs.getString("status_reason_desc");
        if (Status_Reason_Desc==null) Status_Reason_Desc="";

        Status_Remarks = rs.getString("status_remarks");
        if (Status_Remarks==null) Status_Remarks="";


        Active_Yn = rs.getString("active_yn");
        if (Active_Yn==null) Active_Yn="";

        Last_Contact_Date = rs.getString("last_contact_date");
        if (Last_Contact_Date!=null)
		{
			Last_Contact_Date=DateUtils.convertDate(Last_Contact_Date,"DMY","en",locale); 
		}
		else
			Last_Contact_Date="";

        Deceased_Yn = rs.getString("deceased_yn");
        if (Deceased_Yn==null) Deceased_Yn="";

        Deceased_Date = rs.getString("deceased_date");

       // if (Deceased_Date==null) Deceased_Date="";
	    if (Deceased_Date!=null)
		{
			Deceased_Date=DateUtils.convertDate(Deceased_Date,"DMY","en",locale); 
		}
		else
			Deceased_Date="";

        Death_Status_Remarks = rs.getString("death_status_remarks");
        if(Death_Status_Remarks==null) Death_Status_Remarks="";
        
        cust_fields[0] =  cust_fields[0] + "`"+(rs.getString("addl_field1")==null?"&nbsp;":rs.getString("addl_field1")) ;
        cust_fields[1] =  cust_fields[1] +"`"+(rs.getString("addl_field2")==null?"&nbsp;":rs.getString("addl_field2")) ;
        cust_fields[2] =  cust_fields[2] +"`"+(rs.getString("addl_field3")==null?"&nbsp;":rs.getString("addl_field3")) ;
        cust_fields[3] =  cust_fields[3] +"`"+(rs.getString("addl_field4")==null?"&nbsp;":rs.getString("addl_field4")) ;
        cust_fields[4] =  cust_fields[4] +"`"+(rs.getString("addl_field5")==null?"&nbsp;":rs.getString("addl_field5")) ;

        added_by_id = rs.getString("added_by_id");
        added_user_name = rs.getString("added_user_name");
		if(added_user_name==null)added_user_name="&nbsp;";
        added_date = rs.getString("added_date");
		added_date=DateUtils.convertDate(added_date,"DMYHM","en",locale); 

        added_at_ws_no = rs.getString("added_at_ws_no");
        added_facility_id = rs.getString("added_facility_id");
        added_facility_name = rs.getString("ADDED_FACILITY_NAME");
        modified_by_id = rs.getString("modified_by_id");
        modified_user_name = rs.getString("modified_user_name");
		if(modified_user_name==null)modified_user_name="&nbsp;";
        modified_date = rs.getString("modified_date");
		modified_date=DateUtils.convertDate(modified_date,"DMYHM","en",locale); 

        modified_at_ws_no = rs.getString("modified_at_ws_no");
        modified_facility_id  = rs.getString("modified_facility_id");
        modified_facility_name  = rs.getString("modified_facility_name");
		data_source = rs.getString("data_source");
		if (data_source==null) data_source="";
		Age = rs.getString("age");
		if (Age==null) Age="";

		if(!Age.equals("")) {

			StringTokenizer st = new StringTokenizer(Age," ");

				while ( st.hasMoreTokens() ) {

							String date_elmnt = st.nextToken();						

							char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

							String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

							if(ymdh_char=='Y') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"Y ";								
							} else if (ymdh_char=='M') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"M ";								
							} else if (ymdh_char=='D') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"D ";								
							} else if (ymdh_char=='H') {
								//if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"H ";
							}
						}	
						
		}


		CONTACT3_MODE_DESC=rs.getString("CONTACT3_MODE_DESC");
        if(CONTACT3_MODE_DESC==null)CONTACT3_MODE_DESC="";
		
		CONTACT4_MODE_DESC=rs.getString("CONTACT4_MODE_DESC");
        if(CONTACT4_MODE_DESC==null)CONTACT4_MODE_DESC="";
		
		CONTACT5_MODE_DESC=rs.getString("CONTACT5_MODE_DESC");
        if(CONTACT5_MODE_DESC==null)CONTACT5_MODE_DESC="";
		MembershipType=rs.getString("MembershipType");
        if(MembershipType==null)MembershipType="";
		Orgsubname=rs.getString("Orgsubname");
        if(Orgsubname==null)Orgsubname="";
		Orgname=rs.getString("Orgname");
        if(Orgname==null)Orgname="";
		patexpirtydate=rs.getString("patexpirtydate");
        if(patexpirtydate!=null)
		{
			patexpirtydate=DateUtils.convertDate(patexpirtydate,"DMY","en",locale);
		}
		else
			patexpirtydate="";
		

// newly start Tuesday, May 04, 2010  PE_EXE Venkat S 


			file_cnt = rs.getInt("file_cnt");

			doc1_type_desc = rs.getString("doc1_type_desc")==null?"&nbsp;":rs.getString("doc1_type_desc");
			doc1_num = rs.getString("doc1_num")==null?"&nbsp;":rs.getString("doc1_num");
			doc1_place_of_issue = rs.getString("doc1_place_of_issue")==null?"&nbsp;":rs.getString("doc1_place_of_issue");

			doc2_type_desc = rs.getString("doc2_type_desc")==null?"&nbsp;":rs.getString("doc2_type_desc");
			doc2_num = rs.getString("doc2_num")==null?"&nbsp;":rs.getString("doc2_num");
			doc2_place_of_issue = rs.getString("doc2_place_of_issue")==null?"&nbsp;":rs.getString("doc2_place_of_issue");

			doc3_type_desc = rs.getString("doc3_type_desc")==null?"&nbsp;":rs.getString("doc3_type_desc");
			doc3_num = rs.getString("doc3_num")==null?"&nbsp;":rs.getString("doc3_num");
			doc3_place_of_issue = rs.getString("doc3_place_of_issue")==null?"&nbsp;":rs.getString("doc3_place_of_issue");

			doc4_type_desc = rs.getString("doc4_type_desc")==null?"&nbsp;":rs.getString("doc4_type_desc");
			doc4_num = rs.getString("doc4_num")==null?"&nbsp;":rs.getString("doc4_num");
			doc4_place_of_issue = rs.getString("doc4_place_of_issue")==null?"&nbsp;":rs.getString("doc4_place_of_issue");



			doc1_exp_date=rs.getString("DOC1_EXP_DATE");
				if(doc1_exp_date != null)
				{
				doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",localeName);
				}
				else
					doc1_exp_date="&nbsp;";
				
				doc1_iss_date=rs.getString("DOC1_ISS_DATE");
				if(doc1_iss_date != null)
				{
					doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",localeName);
				}
				else
					doc1_iss_date="&nbsp;";

				doc2_exp_date=rs.getString("DOC2_EXP_DATE");
				if(doc2_exp_date != null)
				{
					doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",localeName);
				}
				else
					doc2_exp_date="&nbsp;";
				doc2_iss_date=rs.getString("DOC2_ISS_DATE");
				if(doc2_iss_date != null)
				{
					doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",localeName);
				}
				else
					doc2_iss_date="&nbsp;";

				doc3_exp_date=rs.getString("DOC3_EXP_DATE");
				if(doc3_exp_date != null)
				{
					doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",localeName);
				}
				else
					doc3_exp_date="&nbsp;";

				doc3_iss_date=rs.getString("DOC3_ISS_DATE");
				if(doc3_iss_date != null)
				{
					doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",localeName);
				}
				else
					doc3_iss_date="&nbsp;";

				doc4_exp_date=rs.getString("DOC4_EXP_DATE");
				if(doc4_exp_date != null)
				{
					doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",localeName);
				}
				else
					doc4_exp_date="&nbsp;";

				doc4_iss_date=rs.getString("DOC4_ISS_DATE");
				if(doc4_iss_date != null)
				{
					doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",localeName);
				}
				else
					doc4_iss_date="&nbsp;";
		// end  PE_EXE 
    }
	else
	{
		//out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC'));</script>");
		//out.println("<script>parent.parent.frames[1].location.href ='../../eMP/jsp/blank.jsp?step_1=3';</script>");
		if(!function_id1.equals("VIEW_PAT_DTLS")){
		out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC','MP'));</script>");
		out.println("<script>window.close();</script>");
		}else {
           out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC','MP'));</script>");
		   out.println("<script>parent.parent.frames[1].location.href ='../../eMP/jsp/blank.jsp?step_1=3';</script>");
		}
	}
}
}catch(Exception e){
	
	e.printStackTrace();}

//added by Dheeraj on 15-7-02  - Begin
//this is to display the alert message if the file has not been created for the facility.

if (doc_or_file.equals("F")&&(create_file_yn.equals("Y")))
{
	//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
	
	
	if(file_cnt==0)
	{
	out.println("<script>alert(getMessage('FILE_NOT_FOR_FACILITY','MP'));</script>");
	}

/* Tuesday, May 04, 2010 PE_EXE venkat s StringBuffer  sblQry{ = new StringBuffer();
	out.println("----------");
	String slFile_No = "";
	sblQry.append("select file_no from mr_pat_file_index where facility_id = '"+ Facility_Id +"' and patient_id  = ?");

	pstmt = con.prepareStatement(sblQry.toString());
	pstmt.setString(1, patient);

	rs = pstmt.executeQuery();

		if((rs.next())){
			slFile_No = rs.getString("file_no");

		}else{
			out.println("<script>alert(getMessage('FILE_NOT_FOR_FACILITY','MP'));</script>");
		} */
}
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Pat_Ser_Grp_Desc ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Pref_Facility_Name));
            _bw.write(_wl_block14Bytes, _wl_block14);

    session.putValue( "patient_id", patient ) ;
	view_pat_photo_yn = "N"; 
    if (view_pat_photo_yn.equals("Y"))
    {
            _bw.write(_wl_block15Bytes, _wl_block15);
            {java.lang.String __page ="../../eCommon/jsp/photo_display.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(accept_national_id_no_yn.equals("Y")){
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block21Bytes, _wl_block21);
} else {
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
if(accept_oth_alt_id_yn.equals("Y"))
				{
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(demo_oth_alt_id_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(demo_oth_alt_id_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
			   else
			   {
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Alt_Id1_Type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Alt_Id1_No));
            _bw.write(_wl_block31Bytes, _wl_block31);

				if(alt_id1_exp_date_accept_yn.equals("Y"))
				{
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Alt_Id1_Exp_Date));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}else
				{
				
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
				
            _bw.write(_wl_block35Bytes, _wl_block35);

	if(Alt_Id2_Type != "") {
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Alt_Id2_Type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Alt_Id2_No));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(alt_id2_exp_date_accept_yn.equals("Y"))
			  { 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Alt_Id2_Exp_Date));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
	}
    
            _bw.write(_wl_block43Bytes, _wl_block43);

	if(Alt_Id3_Type != "") {
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Alt_Id3_Type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(Alt_Id3_No));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(alt_id3_exp_date_accept_yn.equals("Y"))
			 {  
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Alt_Id3_Exp_Date));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

		if(Alt_Id4_Type != "") 
		{
		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Alt_Id4_Type));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(Alt_Id4_No));
            _bw.write(_wl_block55Bytes, _wl_block55);
if(alt_id4_exp_date_accept_yn.equals("Y"))
					{  
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Alt_Id4_Exp_Date));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else{
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);


/*
	String family_org_id_accept_yn=(String)hash_mp_param.get("FAMILY_ORG_ID_ACCEPT_YN");
	String entitlement_by_pat_cat_yn=(String)hash_mp_param.get("entitlement_by_pat_cat_yn");
*/
	 
	 

            _bw.write(_wl_block61Bytes, _wl_block61);
if(family_org_id_accept_yn.equals("Y"))
		{
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(MembershipType.equals("1")){
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else if (MembershipType.equals("2")){
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else if(MembershipType.equals("3")){
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}else if(MembershipType.equals("4")){
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(Orgname));
            _bw.write(_wl_block70Bytes, _wl_block70);
if(!Orgname.equals("") && !Orgsubname.equals("")){ 
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            out.print( String.valueOf(Orgsubname));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
if(Family_No_Link_Yn.equals("Y"))
		 {
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Family_Link_No));
            _bw.write(_wl_block76Bytes, _wl_block76);
if(family_org_id_accept_yn.equals("Y"))
				{
            _bw.write(_wl_block77Bytes, _wl_block77);
}
				else 
				{
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(head_patient_name));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(Relationship_Name));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
		 else
		 {
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix_Prompt+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix_Prompt+"</td>");


            _bw.write(_wl_block86Bytes, _wl_block86);


if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix+"</td>");


if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix+"</td>");


            _bw.write(_wl_block87Bytes, _wl_block87);


try
{
	if(names_in_oth_lang_yn.equals("Y"))
	{

    
            _bw.write(_wl_block88Bytes, _wl_block88);

		 if(!language_direction.equals("R"))
		{
       
		 if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }

//start
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//3
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//2
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//1
		 if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");
       
        
            _bw.write(_wl_block89Bytes, _wl_block89);

          
			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+name_prefix_loc_lang+"</td>");        

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }

//start
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//3
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//1
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
			
			  if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data'  style=\"border-right-style: solid; border-right-color: white\">"+name_suffix_loc_lang+"</td>");

		}
		else if(language_direction.equals("R"))
		{

	
		if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");


	  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


			

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


		if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");
		
       
        
            _bw.write(_wl_block89Bytes, _wl_block89);

          
			if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_suffix_loc_lang+"</b></td>");

			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }


			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_prefix_loc_lang+"</b></td>"); 
			
			

		}
            
		}
}
catch(Exception e){out.println(e);
e.printStackTrace();}

            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
if(Sex.equals("M"))
			{  
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
}else if(Sex.equals("F")){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
}else if(Sex.equals("U")){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
}
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(blood_grp_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(rh_factor_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(age_value));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(Date_Of_Birth));
            _bw.write(_wl_block102Bytes, _wl_block102);
if(hijirisitespecifApplicable){

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(hijri_birth_date));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(Mar_Status_Desc));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

			if(!(Place_Of_Birth==null))	
			out.println(Place_Of_Birth);
			if(!(birth_place_code==null))
			out.println(birth_place_desc);	
			
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Pat_Cat_Desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
if(entitlement_by_pat_cat_yn.equals("Y")){
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
if(!patexpirtydate.equals("")){
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            out.print( String.valueOf(patexpirtydate));
            _bw.write(_wl_block114Bytes, _wl_block114);
}else {
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

					if(citizen_yn.equals("Y")) { 

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
 }
					else if(citizen_yn.equals("N")) { 

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
 } 
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

					if(legal_yn.equals("Y")){ 

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
 }
					else if(legal_yn.equals("N")){ 

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
 } 
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(Nationality_Desc));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(race_long_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(ethnic_long_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(Relgn_Desc));
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(language_name));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(Alias_Name));
            _bw.write(_wl_block132Bytes, _wl_block132);

		
	int order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {

		if(cust_fields[i].charAt(0) == 'D')
        {
            if (i==0)
			{
			   
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

			}
			if( order%2 == 0)
			{
				if ( i != 0 ) //out.println("<tr><td class='data' colspan='4' height=5>&nbsp</td></tr>");
				out.println("<tr>");
			}
			
		
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);
            out.println("<td class='label'>"+lab+"</td>") ;
			out.println("<td class='data'>"+val+"</td>");
            order++;
        }
    }
	if( order %2 != 0 && order!=0)
	{
	out.println("<td  colspan='2'></td></tr>");
	
	}
	

            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

    Addr_val = "" ;
    for(int i=0;i<contact_col_names.length;i++)
    {
            out.println("<tr>") ;
            out.println("<td class='label' width='24%' >"+contact_prompts[i]+"&nbsp;</td>") ;
            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = Resi_Addr_Line1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = Resi_Addr_Line2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = Resi_Addr_Line3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = Resi_Addr_Line4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = Resi_Area_Desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = Resi_Town_Desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = Resi_Postal_Code;
            out.println("<td   class='data' width='24%'>"+Addr_val+"</td>") ;

            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = Mail_Addr_Line1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = Mail_Addr_Line2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = Mail_Addr_Line3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = Mail_Addr_Line4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = mail_res_area_desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = mail_res_town_desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = mail_region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = Mail_Postal_Code;

        out.println("<td  class='data' width='24%'>"+Addr_val+"</td>") ;
        out.println("<td  class='data' width='25%'>&nbsp;</td>") ;
        out.println("</tr>") ;
		out.println("");
    }

            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(Resi_Country_Name));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(Mail_Country_Name));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

	if(Resi_Invalid1_Yn.equals("N"))
	{
	
            _bw.write(_wl_block142Bytes, _wl_block142);
 }
	else
	{
	
            _bw.write(_wl_block143Bytes, _wl_block143);
 }

    if(Mail_Invalid1_Yn.equals("N"))
     {

            _bw.write(_wl_block144Bytes, _wl_block144);
  }

  else
    {

            _bw.write(_wl_block145Bytes, _wl_block145);
 
    }

            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(Resi_Contact1_Name));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(Mail_Contact1_Name));
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

		  String sql_sel="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
		  pstmt1 = con.prepareStatement(sql_sel);
		  rs2 = pstmt1.executeQuery();
		  while (rs2.next()) {
			  if(rs2.getString("contact_mode").equals("PRN")) {
				  contactModeOne = rs2.getString("short_desc");
			  } else if(rs2.getString("contact_mode").equals("ORN")) {
				  contactModeTwo = rs2.getString("short_desc");
			  }
		  }
          if(pstmt1 != null) pstmt1.close();
		  if(rs2 != null) rs2.close();
		
	 
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(contactModeOne));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(Prn_Tel_No));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(contactModeTwo));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(Orn_Tel_No));
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(CONTACT3_MODE_DESC));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(Contact3_No));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(CONTACT4_MODE_DESC ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(Contact4_No));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(CONTACT5_MODE_DESC));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(Contact5_No ));
            _bw.write(_wl_block164Bytes, _wl_block164);

    order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'C')
        {
			if (i==0)
			{
			   
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);

			}

            if(order%2 == 0)        
                //out.println("<tr></tr><tr>");

            out.println("");
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<tr><td class=label >"+lab+"</td>") ;
            out.println("<td class='data' >"+val+"</td>");
			out.println("<td colspan=2 class='label'>&nbsp;</td></tr>");
			
        }
    }

            _bw.write(_wl_block167Bytes, _wl_block167);
 
 // if(bl_install_yn.equals("Y"))
    //{
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
//}
            _bw.write(_wl_block1Bytes, _wl_block1);

    Addr_val = "" ;
    related_Addr_val = "";
	String line4="";
	String postalcode="";
	String tempPro="";
	String tempProVal="";
	int tempProF=0;

    for(int i=0;i<contact_col_names.length;i++)
    {    
       
			tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val = nKin_Addr_val+"<td   class='data' >"+Nkin_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val= Addr_val+"<td   class='data' >"+Nkin_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td    class='data'>"+Nkin_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4 =line4+"<td   class='data'>"+Nkin_Addr_Line4+"&nbsp;</td>" ;				
            }

			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{   
				Nkin_Area_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Area_Code=Nkin_Area_Code+"<td   class='data'>"+nkin_area_desc+"&nbsp;</td>" ;
			}
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
            {   
				Nkin_Town_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Town_Code=Nkin_Town_Code+"<td   class='data'>"+nkin_town_desc+"&nbsp;</td>" ;
			}
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
            {   
				Nkin_Region_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Region_Code=Nkin_Region_Code+"<td   class='data'>"+nkin_region_desc+"&nbsp;</td>" ;
				
			}
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
              {   
				Nkin_Postal_Desc="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Postal_Desc=Nkin_Postal_Desc+"<td   class='data'>"+Nkin_Postal_Code+"&nbsp;</td>" ;
			}
                     
    }

            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(Nkin_Contact_Name));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nKin_Addr_val));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(Nkin_Contact_Relation_Desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(Addr_val));
            _bw.write(_wl_block176Bytes, _wl_block176);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(contact1_nat_id_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
} else {
            _bw.write(_wl_block178Bytes, _wl_block178);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(related_Addr_val));
            _bw.write(_wl_block179Bytes, _wl_block179);

	
		
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(Alt_Id1_Type));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(contact1_alt_id1_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(line4));
            _bw.write(_wl_block87Bytes, _wl_block87);
	 //Code added by Gomathi Shankar.
/* Friday, April 30, 2010 venkat s PE_EXE
	   try
	   {
	   stmt=con.createStatement();
	   rs1=stmt.executeQuery("SELECT ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE FROM MP_PARAM");
	   while(rs1.next())
		{
		   
		   aid2= rs1.getString(1);
		   if(aid2==null) aid2="";
		   aid3= rs1.getString(2);
		   if(aid3==null)aid3="";
		   aid4= rs1.getString(3);
		   if(aid4==null)aid4="";
		}
	   }catch(Exception e){out.println(e); e.printStackTrace();}
	   */

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(Alt_Id2_Type));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(contact1_alt_id2_no));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(Nkin_Town_Code));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(Alt_Id3_Type));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(contact1_alt_id3_no));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(Nkin_Area_Code));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(Alt_Id4_Type));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(contact1_alt_id4_no));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(Nkin_Region_Code));
            _bw.write(_wl_block184Bytes, _wl_block184);

 if(accept_oth_alt_id_yn.equals("Y"))
	{
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(nkin_oth_alt_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nkin_oth_alt_id_no));
            _bw.write(_wl_block185Bytes, _wl_block185);
}else{
            _bw.write(_wl_block186Bytes, _wl_block186);
}
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(Nkin_Postal_Desc));
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(contact1_birth_date));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(Nkin_Country_Name));
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(Nkin_Job_Title));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(Nkin_Res_Tel_No));
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(nkin_mob_tel_no));
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Nkin_Off_Tel_No));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(nkin_email_id));
            _bw.write(_wl_block196Bytes, _wl_block196);

    order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'N')
        {
			 if (i==0)
			{
			   
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
            if(order%2 == 0)        
                out.println("</tr><tr>");

			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td class=label '>"+lab+"&nbsp;</td>") ;
            out.println("<td class='data'>"+val+"</td>");
       }
    }
    out.println("</tr>") ;

            _bw.write(_wl_block199Bytes, _wl_block199);

    Addr_val = "" ;
    related_Addr_val = "";
	line4="";
	postalcode="";
	tempPro="";
	tempProVal="";
	tempProF=0;

    for(int i=0;i<contact_col_names.length;i++)
    {    
        
			tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val=nKin_Addr_val+"<td   class='data'>"+Fton_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val=Addr_val+"<td   class='data'>"+Fton_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td   class='data'>"+Fton_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4=line4+"<td   class='data' >"+Fton_Addr_Line4+"&nbsp;</td>" ;				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{   
				Nkin_Area_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Area_Code=Nkin_Area_Code+"<td   class='data'>"+fton_area_desc+"&nbsp;</td>" ;
			}
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
            {   
				Nkin_Town_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Town_Code=Nkin_Town_Code+"<td   class='data'>"+fton_town_desc+"&nbsp;</td>" ;
			}
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
            {   
				Nkin_Region_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Region_Code=Nkin_Region_Code+"<td   class='data'>"+fton_region_desc+"&nbsp;</td>" ;
				
			}
			else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
			{
		        postalcode="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				postalcode=postalcode+"<td   class='data' >"+Fton_Postal_Code+"&nbsp;</td>";				

            }
       }

            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(Fton_Contact_Name));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(nKin_Addr_val));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(Fton_Contact_Relation_Desc));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(Addr_val));
            _bw.write(_wl_block209Bytes, _wl_block209);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(fton_nat_id_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
} else {
            _bw.write(_wl_block211Bytes, _wl_block211);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(related_Addr_val));
            _bw.write(_wl_block212Bytes, _wl_block212);

			 if(accept_oth_alt_id_yn.equals("Y"))
			{
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(fton_alt_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fton_alt_id_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block214Bytes, _wl_block214);
}
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(line4));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(Fton_Job_Title));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(Nkin_Town_Code));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(Fton_Res_Tel_No));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(Nkin_Area_Code));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(fton_mob_tel_no));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(Nkin_Region_Code));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(Fton_Off_Tel_No));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(postalcode));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(fton_email_id));
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(Fton_Country_Name));
            _bw.write(_wl_block222Bytes, _wl_block222);

     order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'F')
        {
			 if (i==0)
			{
			   
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='6' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=7>&nbsp;</td>");

            _bw.write(_wl_block223Bytes, _wl_block223);

    Addr_val = "" ;
    related_Addr_val = "";
	line4="";
	postalcode="";
	tempPro="";
	tempProVal="";
	tempProF=0;
	String empr_region_code="";
	String empr_area_code="";
	String empr_town_code="";


    for(int i=0;i<contact_col_names.length;i++)
    {    
       		tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val=nKin_Addr_val+"<td   class='data' >"+Emplr_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val=Addr_val+"<td   class='data' >"+Emplr_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td   class='data' >"+Emplr_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4=line4+"<td   class='data' >"+Emplr_Addr_Line4+"&nbsp;</td>" ;				
            }
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
			{
		        empr_region_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_region_code=empr_region_code+"<td   class='data' >"+emplr_region_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
			{
		        empr_town_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_town_code=empr_town_code+"<td   class='data' >"+emplr_town_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{
		        empr_area_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_area_code=empr_area_code+"<td   class='data' >"+emplr_area_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
			{
		        postalcode="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				postalcode=postalcode+"<td   class='data' >"+Emplr_Postal_Code+"&nbsp;</td>";
            }
    }
	

            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(organization_name));
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(Patient_Employee_Id));
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Emplr_Contact_Name));
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(emplr_ocpn_class_desc));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(nKin_Addr_val));
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Ocpn_Desc));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(Addr_val));
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Employment_Status));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(related_Addr_val));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(line4));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(empr_town_code));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(empr_area_code));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(empr_region_code));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(postalcode));
            _bw.write(_wl_block243Bytes, _wl_block243);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Emplr_Country_Name));
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Emplr_Res_Tel_No));
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(Emplr_Off_Tel_No));
            _bw.write(_wl_block246Bytes, _wl_block246);

   order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'E')
        {
			if (i==0)
			{
			   
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='6' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=7>&nbsp;</td>");

            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

      
    	/* sql.setLength(0);
		sql.append("SELECT (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC1_TYPE AND LANGUAGE_ID = '"+locale+"') DOC1_TYPE_DESC, DOC1_NUM, TO_CHAR(DOC1_EXP_DATE,'DD/MM/YYYY') DOC1_EXP_DATE, DOC1_PLACE_OF_ISSUE, TO_CHAR(DOC1_ISS_DATE,'DD/MM/YYYY') DOC1_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC2_TYPE AND LANGUAGE_ID = '"+locale+"') DOC2_TYPE_DESC, DOC2_NUM, TO_CHAR(DOC2_EXP_DATE,'DD/MM/YYYY') DOC2_EXP_DATE, DOC2_PLACE_OF_ISSUE, TO_CHAR(DOC2_ISS_DATE,'DD/MM/YYYY') DOC2_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC3_TYPE AND LANGUAGE_ID = '"+locale+"') DOC3_TYPE_DESC,DOC3_NUM, TO_CHAR(DOC3_EXP_DATE,'DD/MM/YYYY') DOC3_EXP_DATE, DOC3_PLACE_OF_ISSUE, TO_CHAR(DOC3_ISS_DATE,'DD/MM/YYYY') DOC3_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC4_TYPE AND LANGUAGE_ID = '"+locale+"') DOC4_TYPE_DESC, DOC4_NUM, TO_CHAR(DOC4_EXP_DATE,'DD/MM/YYYY') DOC4_EXP_DATE, DOC4_PLACE_OF_ISSUE, TO_CHAR(DOC4_ISS_DATE,'DD/MM/YYYY') DOC4_ISS_DATE,  FROM MP_PAT_DOCUMENTS A WHERE PATIENT_ID = ?");
        
		   pstmt = con.prepareStatement(sql.toString());
		  pstmt.setString(1, patient);
         oth_rset = pstmt.executeQuery();
       if(oth_rset !=null)
           if(oth_rset.next())
           {
				 doc1_exp_date=oth_rset.getString("DOC1_EXP_DATE");
				if(doc1_exp_date != null)
				{
				doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",localeName);
				}
				else
					doc1_exp_date="&nbsp;";
				
				doc1_iss_date=oth_rset.getString("DOC1_ISS_DATE");
				if(doc1_iss_date != null)
				{
					doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",localeName);
				}
				else
					doc1_iss_date="&nbsp;";

				doc2_exp_date=oth_rset.getString("DOC2_EXP_DATE");
				if(doc2_exp_date != null)
				{
					doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",localeName);
				}
				else
					doc2_exp_date="&nbsp;";
				doc2_iss_date=oth_rset.getString("DOC2_ISS_DATE");
				if(doc2_iss_date != null)
				{
					doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",localeName);
				}
				else
					doc2_iss_date="&nbsp;";

				doc3_exp_date=oth_rset.getString("DOC3_EXP_DATE");
				if(doc3_exp_date != null)
				{
					doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",localeName);
				}
				else
					doc3_exp_date="&nbsp;";

				doc3_iss_date=oth_rset.getString("DOC3_ISS_DATE");
				if(doc3_iss_date != null)
				{
					doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",localeName);
				}
				else
					doc3_iss_date="&nbsp;";

				doc4_exp_date=oth_rset.getString("DOC4_EXP_DATE");
				if(doc4_exp_date != null)
				{
					doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",localeName);
				}
				else
					doc4_exp_date="&nbsp;";

				doc4_iss_date=oth_rset.getString("DOC4_ISS_DATE");
				if(doc4_iss_date != null)
				{
					doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",localeName);
				}
				else
					doc4_iss_date="&nbsp;";

			Tuesday, May 04, 2010 pe_exe Venkat s commented*/ 
				
    
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(doc1_type_desc));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(doc1_num));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(doc1_exp_date ));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(doc1_place_of_issue));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(doc1_iss_date));
            _bw.write(_wl_block260Bytes, _wl_block260);
 if(doc1!=null){
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block262Bytes, _wl_block262);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
}
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(doc2_type_desc));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(doc2_num));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(doc2_exp_date ));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(doc2_place_of_issue));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf( doc2_iss_date));
            _bw.write(_wl_block268Bytes, _wl_block268);
 if(doc2!=null){
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block269Bytes, _wl_block269);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
}
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(doc3_type_desc));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(doc3_num));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(doc3_exp_date));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(doc3_place_of_issue ));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(doc3_iss_date));
            _bw.write(_wl_block271Bytes, _wl_block271);
 if(doc3!=null){
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block272Bytes, _wl_block272);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
}
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(doc4_type_desc));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(doc4_num));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(doc4_exp_date));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(doc4_place_of_issue ));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(doc4_iss_date));
            _bw.write(_wl_block274Bytes, _wl_block274);
 if(doc4!=null){
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
}
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(Living_Dependency));
            _bw.write(_wl_block279Bytes, _wl_block279);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(Living_Arrangement));
            _bw.write(_wl_block281Bytes, _wl_block281);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(Education_Level));
            _bw.write(_wl_block282Bytes, _wl_block282);
 if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ 
            _bw.write(_wl_block283Bytes, _wl_block283);
 } 
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(Informant));
            _bw.write(_wl_block287Bytes, _wl_block287);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block288Bytes, _wl_block288);

				String str3="";
				int len1 = Informant_Remarks.length();

				if (len1 >85 )
				  str3=Informant_Remarks.substring(0,84)+" "+Informant_Remarks.substring(85,len1);
				else
				  str3=Informant_Remarks;
				if (len1 >169 )
				  str3=str3.substring(0,169)+" "+str3.substring(170,len1);
				
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str3));
            _bw.write(_wl_block289Bytes, _wl_block289);
 if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ 
            _bw.write(_wl_block283Bytes, _wl_block283);
 } 
            _bw.write(_wl_block2Bytes, _wl_block2);
 if(!(General_Remarks.equals("")))
{

String str1="";
int len = General_Remarks.length();
int i1=0;
int n_incre = 0;
int max = 0;

 /* This condition modified by venkateshS on 14/June/2013 against SKR-SCF-0799 [IN:040863] */
if (len > 100) 
{ 
    for ( i1=0; i1 <= (len/100);i1++) 
	{   
		if((i1+1)*100 < len)
			max = (i1+1)*100;
		 else
		  max = len;
		
        str1=str1+" "+General_Remarks.substring((i1*100),max);
		
        n_incre = 1;
    }}
else  {
 str1=General_Remarks;
 }

  /* end SKR-SCF-0799 [IN:040863] */
 


            _bw.write(_wl_block290Bytes, _wl_block290);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block292Bytes, _wl_block292);

}


if(Suspend_Yn.equals("Yes")){

String str1="";
int len = Status_Remarks.length();
int n=1;
String str2 ="";
int i1=0;

for(int i=0;i<len;i++) {
    str2 = str2 + Status_Remarks.substring(i,i+1);
    if( n == 70) {
        str1 = str1 + " " +  str2;
        str2="";
        n=1;
        i1=i;
    }
    else n++;
}
if(len>2)
str1= str1 + " " + Status_Remarks.substring(i1+1,len);



            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(Status_Reason_Desc ));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(str1 ));
            _bw.write(_wl_block296Bytes, _wl_block296);
 } 
            _bw.write(_wl_block2Bytes, _wl_block2);
 if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ 
            _bw.write(_wl_block283Bytes, _wl_block283);
 } 
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
 
			if(Active_Yn.equals("Y"))
			{
		
            _bw.write(_wl_block300Bytes, _wl_block300);

			}
			else if(Active_Yn.equals("N"))
			{
		
            _bw.write(_wl_block301Bytes, _wl_block301);
	
			}
		
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf( Last_Contact_Date));
            _bw.write(_wl_block304Bytes, _wl_block304);

if(Deceased_Yn.equals("Yes")){
String str1="";
int len =Death_Status_Remarks.length();

if (len >85 )
  str1=Death_Status_Remarks.substring(0,84)+" "+Death_Status_Remarks.substring(85,len);
else
  str1=Death_Status_Remarks;
if (len >169 )
  str1=str1.substring(0,169)+" "+str1.substring(170,len);

            _bw.write(_wl_block2Bytes, _wl_block2);
 if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ 
            _bw.write(_wl_block283Bytes, _wl_block283);
 } 
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(Deceased_Date));
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block309Bytes, _wl_block309);
 } 
            _bw.write(_wl_block310Bytes, _wl_block310);

     order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'O')
        {
			if (i==0)
			{
			   
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='5' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=5>&nbsp;</td>");

            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block313Bytes, _wl_block313);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block314Bytes, _wl_block314);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(added_user_name));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(modified_user_name));
            _bw.write(_wl_block316Bytes, _wl_block316);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(added_date));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(added_at_ws_no));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(modified_at_ws_no));
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(added_facility_name));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(modified_facility_name));
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
if(data_source.equals("")) {

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block322Bytes, _wl_block322);
}else {

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block322Bytes, _wl_block322);
}
            _bw.write(_wl_block323Bytes, _wl_block323);

	if(rs!=null) rs.close();
//	if(oth_rset!=null) oth_rset.close();
	if(rs_lang!=null) rs_lang.close();
	if(pstmt!=null) pstmt.close();
	sql.setLength(0);
	 sql2.setLength(0);
}catch(Exception e){out.println("Exception in main try"+e.getMessage()); e.printStackTrace();}
finally {
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(Patient_id));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(hijirisitespecifApplicable));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(hijri_birth_date));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(Date_Of_Birth));
            _bw.write(_wl_block328Bytes, _wl_block328);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PrefFacility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.identitydetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.headfamilydetails.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.organizationmember.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmemberfamily.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmembernonfamily.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.nonorganizationmember.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HeadPatientID.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RelationshiptoHeadofFamily.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.names.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.personaldetails.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RhFactor.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Hijri.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.legal.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.illegal.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.residenceaddress.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MailingAddress.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.valid.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contact.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.primaryresidenceno.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherRes.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.othermodes.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employerdetails.label", java.lang.String .class,"key"));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employeedetails.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orgName.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentid.label", java.lang.String .class,"key"));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactPersonName.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationofthePerson.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentno.label", java.lang.String .class,"key"));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PlaceOfIssue.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueDate.label", java.lang.String .class,"key"));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Document.label", java.lang.String .class,"key"));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentno.label", java.lang.String .class,"key"));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PlaceOfIssue.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueDate.label", java.lang.String .class,"key"));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Document.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Miscellaneous.label", java.lang.String .class,"key"));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dependency.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Arrangement.label", java.lang.String .class,"key"));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EducationLevel.label", java.lang.String .class,"key"));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegistrationSource.label", java.lang.String .class,"key"));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Informant.label", java.lang.String .class,"key"));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InformantRemarks.label", java.lang.String .class,"key"));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generalRemarks.label", java.lang.String .class,"key"));
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
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.suspstatusremarks.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ActiveStatus.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.lastcontact.label", java.lang.String .class,"key"));
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.expiration.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AddedDetails.label", java.lang.String .class,"key"));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.latestmodifieddetails.label", java.lang.String .class,"key"));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.username.label", java.lang.String .class,"key"));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.workstation.label", java.lang.String .class,"key"));
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
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegistrationSource.label", java.lang.String .class,"key"));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.manual.label", java.lang.String .class,"key"));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.repository.label", java.lang.String .class,"key"));
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
}
