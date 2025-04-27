package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __medicalrequestoraddress extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedicalRequestorAddress.jsp", 1733911478451L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block6_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block6_2Bytes = _getBytes( _wl_block6_2 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\n\t\n<!-- \t<script src=\'../js/Requestor.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n -->\n<script>\n\nasync function searchCountry(obj,target)\n{\n\tvar locale = document.forms[0].locale.value;\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=\"\";\t\t\t\t\n\tif(obj.name==\"contry_code\" || obj.name==\"r_country_desc\")\n\t{\n\t\tif(target.name==\"r_country_desc\")\n\t\t{\n\t\t\ttit=getLabel(\"Common.country.label\",\"Common\");\n\t\t\t\n\t\t\tsql=\"Select country_code code,long_name description from MP_COUNTRY_LANG_VW where language_id = \'\"+locale+\"\' and eff_status=\'E\' and upper(country_code) like upper(?) and upper(short_name) like upper(?) and eff_status = \'E\'\";\n\t\t}\n\t}\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\tretVal = await CommonLookup( tit, argumentArray );\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t\tif(target.name == \'r_country_desc\')\n\t\tdocument.forms[0].r_country_desc.value= arr[1];\n\t\tdocument.forms[0].r_country_code.value=arr[0];\n\t}\n\telse\n\t{\n\t\ttarget.value=\'\';\n\t}\n}\n\nfunction CloseME()\n{\n\tvar condition = \'\';\n\n\tif(document.forms[0].r_addr_line1)\n\t\tcondition += document.forms[0].r_addr_line1.value +\"~\";\n\telse\n\t\tcondition += \"\"+\"~\";\n\n\tif(document.forms[0].r_addr_line2)\n\t\tcondition += document.forms[0].r_addr_line2.value +\"~\";\n\telse\n\t\tcondition += \"\"+\"~\";\n\n\tif(document.forms[0].r_addr_line3)\n\t\tcondition += document.forms[0].r_addr_line3.value +\"~\";\n\telse\n\t\tcondition += \"\"+\"~\";\n\n\tif(document.forms[0].r_addr_line4)\n\t\tcondition += document.forms[0].r_addr_line4.value +\"~\";\n\telse\n\t\tcondition += \"\"+\"~\";\n\n\tif(document.forms[0].r_town_code)\n\t{\n\t\tcondition += document.forms[0].r_town_code.value +\"~\";\n\t\tcondition += document.forms[0].r_town.value +\"~\";\n\t}\n\telse\n\t{\n\t\tcondition += \"\"+\"~\";\n\t\tcondition += \"\"+\"~\";\n\t}\n\n\tif(document.forms[0].r_area_code)\n\t{\t\n\t\tcondition += document.forms[0].r_area_code.value +\"~\";\n\t\tcondition += document.forms[0].r_area.value +\"~\";\n\t}\n\telse\n\t{\n\t\tcondition += \"\"+\"~\";\n\t\tcondition += \"\"+\"~\";\n\t}\n\n\tif(document.forms[0].r_region_code)\n\t{\n\t\tcondition += document.forms[0].r_region_code.value +\"~\";\n\t\tcondition += document.forms[0].r_region.value +\"~\";\n\t}\n\telse\n\t{\n\t\tcondition += \"\"+\"~\";\n\t\tcondition += \"\"+\"~\";\n\t}\n\t\n\tif(document.forms[0].r_postal_code1)\n\t{\n\t\tcondition += document.forms[0].r_postal_code1.value +\"~\";\n\t\tcondition += document.forms[0].r_postal_code.value +\"~\";\n\t}\n\telse\n\t{\n\t\tcondition += \"\"+\"~\";\n\t\tcondition += \"\"+\"~\";\n\t}\n\n\t\tcondition += document.forms[0].r_country_desc.value +\"~\";\n\t\tcondition += document.forms[0].r_country_code.value +\"~\";\n\n\t\t/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/\n\t\tcondition += document.forms[0].r_contactno_1.value +\"~\";\n\t\tcondition += document.forms[0].r_contactno_2.value +\"~\";\n\t\tcondition += document.forms[0].r_emailid.value +\"~\";\n\t\t/*ML-MMOH-CRF-0707*/\n\n\twindow.returnValue=condition;\n\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");\n\tdialogTag.close();\n\t//window.close();\n}\n\n\n</script>\n</head>\n\n<body onKeyDown=\'lockKey()\'>\n<form name=\"address_form\" id=\"address_form\" >\n\t<table cellspacing=0 border=\'0\' cellpadding=2 align=\'center\' width=\'100%\'>\n \t\t<th  colspan=\'2\'>&nbsp;&nbsp;&nbsp;<th> \n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<tr>\n\t\t\t<td align=\'right\' class=\'label\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" &nbsp;</td>\n\t\t\t<td class=\'label\' width=\'50%\'>&nbsp;&nbsp;&nbsp;&nbsp;<input align=\'left\' type=\'text\' name=\'r_country_desc\' id=\'r_country_desc\' size=\'20\' maxlength=\'20\'  onblur=\'if(this.value !=\"\")searchCountry(contry_code,r_country_desc);\'  value=\'\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,r_country_desc)\'>\n\t\t\t<input type=\'hidden\' name=\'r_country_code\' id=\'r_country_code\' value=\'\'>\n\t\t   </td>\n\t\t</tr>\n\t\t\n\t\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t\t<tr>\n\t\t\t<td align=\'right\' class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n \t\t\t<td class=\'label\' width=\'50%\'>&nbsp;&nbsp;&nbsp;&nbsp;<input align=\'left\' type=\'text\' maxlength=\'20\' name=\'r_contactno_1\' id=\'r_contactno_1\' value=\'\' size=\'20\'> / <input align=\'left\' type=\'text\' maxlength=\'20\' name=\'r_contactno_2\' id=\'r_contactno_2\' value=\'\' size=\'20\'> \n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\'right\' class=\'label\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td class=\'label\' width=\'50%\'>&nbsp;&nbsp;&nbsp;&nbsp;<input align=\'left\' type=\'text\' maxlength=\'50\' name=\'r_emailid\' id=\'r_emailid\' value=\'\' size=\'40\'> \n\t\t\t</td>\n\t\t</tr>\n\t\t<!--End ML-MMOH-CRF-0707-->\n\t\t<tr>\n\t\t\t<td >&nbsp;&nbsp;</td><td align=\'right\'>&nbsp;&nbsp;<input type=\'button\' class =\'button\' onclick=\'CloseME()\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\'Close\' id=\'Close\'></td>\n\t\t</tr> \n\n\t\t<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\'>\n\t\t<input type=\'hidden\' name=\'town_code\' id=\'town_code\'>\n\t\t<input type=\'hidden\' name=\'region_code\' id=\'region_code\'>\n\t\t<input type=\'hidden\' name=\'area_code\' id=\'area_code\'>\n\t\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'r_postal_code\' id=\'r_postal_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\n\t\t<tr><td class=label colspan=\'4\' height=\'5%\'>&nbsp;</td></tr>\n\t\t<tr><td class=label colspan=\'4\' height=\'5%\'>&nbsp;</td></tr>\n\t\t<tr><td class=label colspan=\'4\' height=\'5%\'>&nbsp;</td></tr>\n\t\t<tr><td class=label colspan=\'4\' height=\'5%\'>&nbsp;</td></tr>\n\t\t<tr><td class=label colspan=\'4\' height=\'5%\'>&nbsp;</td></tr>\n\n\t</table>\n\t<script>\n\t\tif(document.forms[0].r_addr_line1)\n\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\n\t\tif(document.forms[0].r_addr_line2)\n\t\tdocument.forms[0].r_addr_line2.value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\n\t\tif(document.forms[0].r_addr_line3)\n\t\tdocument.forms[0].r_addr_line3.value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\n\t\tif(document.forms[0].r_addr_line4)\n\t\tdocument.forms[0].r_addr_line4.value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\n\t\tif(document.forms[0].r_town_code)\n\t\t{\n\t\t\tdocument.forms[0].r_town_code.value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\tdocument.forms[0].r_town.value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t}\n\n\t\tif(document.forms[0].r_area_code)\n\t\t{\n\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\tdocument.forms[0].r_area.value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t}\n\n\t\tif(document.forms[0].r_region_code)\n\t\t{\n\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\tdocument.forms[0].r_region.value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t}\n\n\t\tif(document.forms[0].r_postal_code1)\n\t\t{\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tdocument.forms[0].r_postal_code.value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t}\n\n\t</script>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t{\n\t\t\t\tdocument.forms[0].elements(i).disabled = false;\n\t\t\t}\n\n\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\n\t\t\tif(document.forms[0].r_addr_line2)\n\t\t\tdocument.forms[0].r_addr_line2.value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\n\t\t\tif(document.forms[0].r_addr_line3)\n\t\t\tdocument.forms[0].r_addr_line3.value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\n\t\t\tif(document.forms[0].r_addr_line4)\n\t\t\tdocument.forms[0].r_addr_line4.value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\n\t\t\tif(document.forms[0].r_town_code)\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_town_code.value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\tdocument.forms[0].r_town.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t}\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\tdocument.forms[0].r_area.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t}\n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\tdocument.forms[0].r_region.value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t}\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\tdocument.forms[0].r_postal_code.value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t}\n\t\t\tdocument.forms[0].r_country_desc.value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tdocument.forms[0].r_country_code.value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\n\t\t\t/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/\n\t\t\tdocument.forms[0].r_contactno_1.value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tdocument.forms[0].r_contactno_2.value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\tdocument.forms[0].r_emailid.value\t  = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t/*ML-MMOH-CRF-0707*/\n\n\t\t</script>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<script>\n\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t{\n\t\t\t\tdocument.forms[0].elements[i].disabled = false;\n\t\t\t}\n\t\t\tdocument.forms[0].Close.disabled = false;\n\n\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\t\t\tif(document.forms[0].r_town_code)\n\t\t\tdocument.forms[0].r_town_code.value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\n\t\t\tif(document.forms[0].r_region_code)\n\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\n\t\t\t\n\n\t\t\t/*if(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";*/\n\t\t\t\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\n\n\n\t\t\tdocument.forms[0].r_country_desc.value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<script>\n\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t{\n\t\t\t\tdocument.forms[0].elements[i].disabled = false;\n\t\t\t}\n\n\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\n\t\t\t/*if(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";*/\n\n\t\t\t\n\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\n\t\t\tdocument.forms[0].r_country_desc.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";*/\n\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t*/\n\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\n\t\t\t\n\t\t\t/*if(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\n\t\t\tdocument.forms[0].r_country_desc.value = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\n\t\t</script>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\n\t\t\t\n\t\t\t//other_del_postal_desc\n\t\t\t/*if(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<script>\n\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\tdocument.forms[0].r_addr_line1.value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n//\t\t\tdocument.forms[0].r_town.value = \"<disp_appl_res_town_code>\";\n\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\tdocument.forms[0].r_area_code.value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n//\t\t\tdocument.forms[0].r_area.value = \"<disp_appl_res_area_code>\";\n\n\t\t\tif(document.forms[0].r_region_code)\n\t\t\tdocument.forms[0].r_region_code.value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n//\t\t\tdocument.forms[0].r_region.value = \"<disp_appl_region_code>\";\n\n\t\t\t\n\n\t\t\t/*if(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\t\t\n//\t\t\tdocument.forms[0].r_postal_code.value = \"<disp_appl_postal_code>\";\n\t\t\n\t\t\tdocument.forms[0].r_country_desc.value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\n\t\t\t/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/\n\t\t\t\n\t\t\tdocument.forms[0].r_contactno_1.value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\n\t\t\tdocument.forms[0].r_contactno_2.value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\n\t\t\tdocument.forms[0].r_emailid.value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\n\t\t\t/*ML-MMOH-CRF-0707*/\n\n\t\t</script>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<script>\n\t\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].elements[i].disabled = true;\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].Close.disabled = false;\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\tdocument.forms[0].r_postal_code1.value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\n\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t{\n\t\t\t\tdocument.forms[0].elements[i].disabled = true;\n\t\t\t}\n\t\t\tdocument.forms[0].Close.disabled = false;\n\t\t</script>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

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
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            _bw.write(_wl_block6_2Bytes, _wl_block6_2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block0Bytes, _wl_block0);



	Connection con			= null;
	Properties prts			= (java.util.Properties) session.getValue("jdbc");
	String facilityId		= (String)session.getValue("facility_id");
	String locale			= (String)session.getAttribute("LOCALE");
	String RelationShipType = checkForNull(request.getParameter("RelationShipType"));	
	String Requestor_Type	= checkForNull(request.getParameter("requestor_Type"));	
	String call_function	= checkForNull(request.getParameter("call_function"));	
	String patient_id		= checkForNull(request.getParameter("patient_id"));	
	//'Oth_appl_postal_desc'String reln_type		= checkForNull(request.getParameter("reln_type"));	
	String request_id		= checkForNull(request.getParameter("request_id"));	
	String requestor_code	= checkForNull(request.getParameter("requestor_code"));	
	String indicator		= checkForNull(request.getParameter("requestor_Type"));	
	String mode				= checkForNull(request.getParameter("mode"));
	String disp_appl_addr_line1		= ""; 
	String disp_appl_addr_line2		= ""; 
	String disp_appl_addr_line3		= ""; 
	String disp_appl_addr_line4		= ""; 
	String disp_appl_res_town_desc	= ""; 
	String disp_appl_res_area_desc	= ""; 
	String disp_appl_region_desc	= ""; 
	String disp_appl_postal_code	= ""; 
	String disp_appl_postal_desc	= "";
	String disp_appl_country_desc	= ""; 
	
	

	//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
	String disp_contact_no1			= "";
	String disp_contact_no2			= "";
	String disp_appl_email_id		= "";

	Statement stmt = null;
	ResultSet rs = null;
	String Sql="";
	
try
{
	con = ConnectionManager.getConnection(request);
	try
	{
		if(!call_function.equals("") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			if(!patient_id.equals(""))
			{
				//Sql=" SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4, appl_area_short_desc, appl_country_long_desc, appl_postal_code,  appl_region_short_desc, appl_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and patient_id ='"+patient_id+"' and REQUEST_ID = '"+request_id+"' ";

				Sql= "SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4, mp_get_desc.MP_RES_AREA(APPL_AREA_CODE,'"+locale+"','1')appl_area_short_desc, mp_get_desc.MP_COUNTRY(APPL_COUNTRY_CODE,'"+locale+"','2')appl_country_long_desc, appl_postal_code, 				mp_get_desc.MP_POSTAL_CODE(appl_postal_code,'"+locale+"','2') appl_postal_desc, mp_get_desc.MP_REGION(appl_region_code,'"+locale+"','2')appl_region_short_desc, mp_get_desc.MP_RES_TOWN(appl_town_code,'"+locale+"','1')appl_town_short_desc, contact_no1, contact_no2, appl_email_id FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and patient_id ='"+patient_id+"' and REQUEST_ID = '"+request_id+"'"; 

				//Above query modified by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707

			}
			else
			{
				//Sql=" SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4,appl_area_short_desc,	appl_country_long_desc, appl_postal_code, appl_region_short_desc, appl_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";

				Sql= "SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4,				mp_get_desc.MP_RES_AREA(APPL_AREA_CODE,'"+locale+"','1')appl_area_short_desc,				mp_get_desc.MP_COUNTRY(APPL_COUNTRY_CODE,'"+locale+"','2')appl_country_long_desc, appl_postal_code,	mp_get_desc.MP_POSTAL_CODE(appl_postal_code,'"+locale+"','2') appl_postal_desc,			mp_get_desc.MP_REGION(appl_region_code,'"+locale+"','2')appl_region_short_desc,				mp_get_desc.MP_RES_TOWN(appl_town_code,'"+locale+"','1')appl_town_short_desc, contact_no1, contact_no2, appl_email_id FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";
				
				//Above query modified by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707



			}
			stmt	= con.createStatement();
			rs		= stmt.executeQuery(Sql);

			if(rs.next() && rs != null)
			{
				disp_appl_addr_line1	= checkForNull(rs.getString("appl_addr_line1"));
				disp_appl_addr_line2	= checkForNull(rs.getString("appl_addr_line2"));	
				disp_appl_addr_line3	= checkForNull(rs.getString("appl_addr_line3"));	
				disp_appl_addr_line4	= checkForNull(rs.getString("appl_addr_line4"));	
				disp_appl_res_town_desc	= checkForNull(rs.getString("appl_town_short_desc"));	
				disp_appl_res_area_desc	= checkForNull(rs.getString("appl_area_short_desc"));	
				disp_appl_region_desc	= checkForNull(rs.getString("appl_region_short_desc"));	
				disp_appl_postal_code	= checkForNull(rs.getString("appl_postal_code"));	
				disp_appl_postal_desc	= checkForNull(rs.getString("appl_postal_desc"));	
				disp_appl_country_desc	= checkForNull(rs.getString("appl_country_long_desc"));	

				//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
				disp_contact_no1		= checkForNull(rs.getString("contact_no1"));
				disp_contact_no2		= checkForNull(rs.getString("contact_no2"));
				disp_appl_email_id		= checkForNull(rs.getString("appl_email_id"));
			}

			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query : "+e);
		e.printStackTrace();
	}


String appl_addr_line1		= checkForNull(request.getParameter("appl_addr_line1"));
String appl_addr_line2		= checkForNull(request.getParameter("appl_addr_line2"));	
String appl_addr_line3		= checkForNull(request.getParameter("appl_addr_line3"));	
String appl_addr_line4		= checkForNull(request.getParameter("appl_addr_line4"));	
String appl_res_town_code	= checkForNull(request.getParameter("appl_res_town_code"));	
String appl_res_town_desc	= checkForNull(request.getParameter("appl_res_town_desc"));	
String appl_res_area_code	= checkForNull(request.getParameter("appl_res_area_code"));	
String appl_res_area_desc	= checkForNull(request.getParameter("appl_res_area_desc"));	
String appl_region_code		= checkForNull(request.getParameter("appl_region_code"));	
String appl_region_desc		= checkForNull(request.getParameter("appl_region_desc"));	
String appl_postal_code		= checkForNull(request.getParameter("appl_postal_code"));	

/*For others...*/
String  Oth_appl_addr_line1	= checkForNull(request.getParameter("Oth_appl_addr_line1"));
String  Oth_appl_addr_line2	= checkForNull(request.getParameter("Oth_appl_addr_line2"));
String  Oth_appl_addr_line3	= checkForNull(request.getParameter("Oth_appl_addr_line3"));
String  Oth_appl_addr_line4	= checkForNull(request.getParameter("Oth_appl_addr_line4"));
String  Oth_appl_res_town_desc	= checkForNull(request.getParameter("Oth_appl_res_town_desc"));
String  Oth_appl_res_town_code	= checkForNull(request.getParameter("Oth_appl_res_town_code"));
String  Oth_appl_res_area_desc	= checkForNull(request.getParameter("Oth_appl_res_area_desc"));
String  Oth_appl_res_area_code	= checkForNull(request.getParameter("Oth_appl_res_area_code"));
String  Oth_appl_region_desc = checkForNull(request.getParameter("Oth_appl_region_desc"));
String  Oth_appl_region_code = checkForNull(request.getParameter("Oth_appl_region_code"));
String  Oth_appl_postal_code = checkForNull(request.getParameter("Oth_appl_postal_code"));
String  Oth_appl_postal_desc = checkForNull(request.getParameter("Oth_appl_postal_desc"));
String  Oth_appl_country_desc = checkForNull(request.getParameter("Oth_appl_country_desc"));
String  Oth_appl_country_code = checkForNull(request.getParameter("Oth_appl_country_code"));

/*For Self...*/
String  self_addr_line1	= checkForNull(request.getParameter("appl_addr_line1"));
String  self_addr_line2	= checkForNull(request.getParameter("appl_addr_line2"));
String  self_addr_line3	= checkForNull(request.getParameter("appl_addr_line3"));
String  self_addr_line4	= checkForNull(request.getParameter("appl_addr_line4"));
String  self_res_town_desc	= checkForNull(request.getParameter("appl_res_town_desc"));
String  self_res_town_code	= checkForNull(request.getParameter("appl_res_town_code"));
String  self_res_area_desc	= checkForNull(request.getParameter("appl_res_area_desc"));
String  self_res_area_code	= checkForNull(request.getParameter("appl_res_area_code"));
String  self_region_desc = checkForNull(request.getParameter("appl_region_desc"));
String  self_region_code = checkForNull(request.getParameter("appl_region_code"));
String  self_postal_code = checkForNull(request.getParameter("appl_postal_code"));
String  self_postal_desc = checkForNull(request.getParameter("appl_postal_desc"));
String  self_country_desc = checkForNull(request.getParameter("appl_country_desc"));
String  self_country_code = checkForNull(request.getParameter("appl_country_code"));

/*For NKIN...*/
String  nkin_addr_line1	= checkForNull(request.getParameter("nkin_addr_line1"));
String  nkin_addr_line2	= checkForNull(request.getParameter("nkin_addr_line2"));
String  nkin_addr_line3	= checkForNull(request.getParameter("nkin_addr_line3"));
String  nkin_addr_line4	= checkForNull(request.getParameter("nkin_addr_line4"));
String  nkin_res_town_desc	= checkForNull(request.getParameter("nkin_res_town_desc"));
String  nkin_res_town_code	= checkForNull(request.getParameter("nkin_res_town_code"));
String  nkin_res_area_desc	= checkForNull(request.getParameter("nkin_res_area_desc"));
String  nkin_res_area_code	= checkForNull(request.getParameter("nkin_res_area_code"));
String  nkin_region_desc = checkForNull(request.getParameter("nkin_region_desc"));
String  nkin_region_code = checkForNull(request.getParameter("nkin_region_code"));
String  nkin_postal_code = checkForNull(request.getParameter("nkin_postal_code"));
String  nkin_postal_desc = checkForNull(request.getParameter("nkin_postal_desc"));
String  nkin_country_desc = checkForNull(request.getParameter("nkin_country_desc"));
String  nkin_country_code = checkForNull(request.getParameter("nkin_country_code"));

/*For FTON...*/
String  fton_addr_line1	= checkForNull(request.getParameter("fton_addr_line1"));
String  fton_addr_line2	= checkForNull(request.getParameter("fton_addr_line2"));
String  fton_addr_line3	= checkForNull(request.getParameter("fton_addr_line3"));
String  fton_addr_line4	= checkForNull(request.getParameter("fton_addr_line4"));
String  fton_res_town_desc	= checkForNull(request.getParameter("fton_res_town_desc"));
String  fton_res_town_code	= checkForNull(request.getParameter("fton_res_town_code"));
String  fton_res_area_desc	= checkForNull(request.getParameter("fton_res_area_desc"));
String  fton_res_area_code	= checkForNull(request.getParameter("fton_res_area_code"));
String  fton_region_desc = checkForNull(request.getParameter("fton_region_desc"));
String  fton_region_code = checkForNull(request.getParameter("fton_region_code"));
String  fton_postal_code = checkForNull(request.getParameter("fton_postal_code"));
String  fton_postal_desc = checkForNull(request.getParameter("fton_postal_desc"));
String  fton_country_desc = checkForNull(request.getParameter("fton_country_desc"));
String  fton_country_code = checkForNull(request.getParameter("fton_country_code"));

/*For EMPLR...*/
String  emplr_addr_line1	= checkForNull(request.getParameter("emplr_addr_line1"));
String  emplr_addr_line2	= checkForNull(request.getParameter("emplr_addr_line2"));
String  emplr_addr_line3	= checkForNull(request.getParameter("emplr_addr_line3"));
String  emplr_addr_line4	= checkForNull(request.getParameter("emplr_addr_line4"));
String  emplr_res_town_desc	= checkForNull(request.getParameter("emplr_res_town_desc"));
String  emplr_res_town_code	= checkForNull(request.getParameter("emplr_res_town_code"));
String  emplr_res_area_desc	= checkForNull(request.getParameter("emplr_res_area_desc"));
String  emplr_res_area_code	= checkForNull(request.getParameter("emplr_res_area_code"));
String  emplr_region_desc = checkForNull(request.getParameter("emplr_region_desc"));
String  emplr_region_code = checkForNull(request.getParameter("emplr_region_code"));
String  emplr_postal_code = checkForNull(request.getParameter("emplr_postal_code"));
String  emplr_postal_desc = checkForNull(request.getParameter("emplr_postal_desc"));
String  emplr_country_desc = checkForNull(request.getParameter("emplr_country_desc"));
String  emplr_country_code = checkForNull(request.getParameter("emplr_country_code"));

/*for personal Delivery address...*/
String personal_del_addr_line1		= checkForNull(request.getParameter("personal_del_addr_line1"));	
String personal_del_addr_line2		= checkForNull(request.getParameter("personal_del_addr_line2"));	
String personal_del_addr_line3		= checkForNull(request.getParameter("personal_del_addr_line3"));	
String personal_del_addr_line4		= checkForNull(request.getParameter("personal_del_addr_line4"));	
String personal_del_res_town_code	= checkForNull(request.getParameter("personal_del_res_town_code"));	
String personal_del_res_town_desc	= checkForNull(request.getParameter("personal_del_res_town_desc"));	
String personal_del_res_area_code	= checkForNull(request.getParameter("personal_del_res_area_code"));	
String personal_del_res_area_desc	= checkForNull(request.getParameter("personal_del_res_area_desc"));	
String personal_del_region_code		= checkForNull(request.getParameter("personal_del_region_code"));	
String personal_del_region_desc		= checkForNull(request.getParameter("personal_del_region_desc"));	
String personal_del_postal_code		= checkForNull(request.getParameter("personal_del_postal_code"));
String personal_del_postal_desc		= checkForNull(request.getParameter("personal_del_postal_desc"));
String personal_del_country_desc	= checkForNull(request.getParameter("personal_del_country_desc"));
String personal_del_country_code	= checkForNull(request.getParameter("personal_del_country_code"));

/*for other Delivery address...*/
String other_del_addr_line1			= checkForNull(request.getParameter("other_del_addr_line1"));	
String other_del_addr_line2			= checkForNull(request.getParameter("other_del_addr_line2"));	
String other_del_addr_line3			= checkForNull(request.getParameter("other_del_addr_line3"));	
String other_del_addr_line4			= checkForNull(request.getParameter("other_del_addr_line4"));	
String other_del_res_town_code		= checkForNull(request.getParameter("other_del_res_town_code"));	
String other_del_res_town_desc		= checkForNull(request.getParameter("other_del_res_town_desc"));	
String other_del_res_area_code		= checkForNull(request.getParameter("other_del_res_area_code"));	
String other_del_res_area_desc		= checkForNull(request.getParameter("other_del_res_area_desc"));	
String other_del_region_code		= checkForNull(request.getParameter("other_del_region_code"));	
String other_del_region_desc		= checkForNull(request.getParameter("other_del_region_desc"));	
String other_del_postal_code		= checkForNull(request.getParameter("other_del_postal_code"));
String other_del_postal_desc		= checkForNull(request.getParameter("other_del_postal_desc"));
String other_del_country_desc		= checkForNull(request.getParameter("other_del_country_desc"));
String other_del_country_code		= checkForNull(request.getParameter("other_del_country_code"));

/*For REQUESTOR...*/
String  requestor_addr_line1	= checkForNull(request.getParameter("requestor_addr_line1"));
String  requestor_addr_line2	= checkForNull(request.getParameter("requestor_addr_line2"));
String  requestor_addr_line3	= checkForNull(request.getParameter("requestor_addr_line3"));
String  requestor_addr_line4	= checkForNull(request.getParameter("requestor_addr_line4"));
String  requestor_res_town_desc	= checkForNull(request.getParameter("requestor_res_town_desc"));
String  requestor_res_town_code	= checkForNull(request.getParameter("requestor_res_town_code"));
String  requestor_res_area_desc	= checkForNull(request.getParameter("requestor_res_area_desc"));
String  requestor_res_area_code	= checkForNull(request.getParameter("requestor_res_area_code"));
String  requestor_region_desc = checkForNull(request.getParameter("requestor_region_desc"));
String  requestor_region_code = checkForNull(request.getParameter("requestor_region_code"));
String  requestor_postal_code = checkForNull(request.getParameter("requestor_postal_code"));
String  requestor_postal_desc = checkForNull(request.getParameter("requestor_postal_desc"));
String  requestor_country_desc = checkForNull(request.getParameter("requestor_country_desc"));
String  requestor_country_code = checkForNull(request.getParameter("requestor_country_code"));

/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

String  self_contact_no1	= checkForNull(request.getParameter("self_contact_no1"));
String  self_contact_no2	= checkForNull(request.getParameter("self_contact_no2"));
String  self_appl_email_id  = checkForNull(request.getParameter("self_appl_email_id"));

String  nkin_contact_no1	= checkForNull(request.getParameter("nkin_contact_no1"));
String  nkin_contact_no2	= checkForNull(request.getParameter("nkin_contact_no2"));
String  nkin_appl_email_id  = checkForNull(request.getParameter("nkin_appl_email_id"));

String  fton_contact_no1	= checkForNull(request.getParameter("fton_contact_no1"));
String  fton_contact_no2	= checkForNull(request.getParameter("fton_contact_no2"));
String  fton_appl_email_id  = checkForNull(request.getParameter("fton_appl_email_id"));

String  emplr_contact_no1	= checkForNull(request.getParameter("emplr_contact_no1"));
String  emplr_contact_no2	= checkForNull(request.getParameter("emplr_contact_no2"));
String  emplr_appl_email_id	= checkForNull(request.getParameter("emplr_appl_email_id"));

String  other_contact_no1	= checkForNull(request.getParameter("other_contact_no1"));
String  other_contact_no2	= checkForNull(request.getParameter("other_contact_no2"));
String  other_appl_email_id	= checkForNull(request.getParameter("other_appl_email_id"));

String  requestor_contact_no1	= checkForNull(request.getParameter("requestor_contact_no1"));
String  requestor_contact_no2	= checkForNull(request.getParameter("requestor_contact_no2"));
String  requestor_appl_email_id = checkForNull(request.getParameter("requestor_appl_email_id"));

/*ML-MMOH-CRF-0707*/

if((call_function.equals("MEDICAL_REPORT_REQUEST") && mode.equals("insert")) || (call_function.equals("MEDICAL_BOARD_REQUEST") && mode.equals("insert")))
{
	try
	{
		StringBuffer sqlBuff = new StringBuffer();
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
		/*sqlBuff.append(" SELECT addr_line1, addr_line2, addr_line3, addr_line4, town_code,town_short_desc, area_code, area_short_desc, region_code, region_short_desc, postal_code, postal_short_desc, country_code, country_name, contact1_no, contact2_no, email_id ");
		sqlBuff.append(" FROM MR_REQUESTOR_VW where facility_id = '"+facilityId+"' and INDICATOR = '"+indicator+"' and requestor_code = '"+requestor_code+"' ");
		*/

		sqlBuff.append(" SELECT addr_line1, addr_line2, addr_line3, addr_line4, town_code,"); sqlBuff.append("mp_get_desc.MP_RES_TOWN(Town_Code,'"+locale+"','1') town_short_desc,"); 
		sqlBuff.append("area_code, mp_get_desc.MP_RES_AREA(Area_Code,'"+locale+"','1') area_short_desc,");
		sqlBuff.append("region_code, mp_get_desc.MP_REGION(Region_Code,'"+locale+"','2') region_short_desc,");
		sqlBuff.append("postal_code, mp_get_desc.MP_POSTAL_CODE(Postal_Code,'"+locale+"','2') postal_short_desc,");
		sqlBuff.append("country_code, mp_get_desc.MP_COUNTRY(country_code,'"+locale+"','2') country_name,");
		sqlBuff.append("contact1_no, contact2_no, email_id FROM   MR_REQUESTOR_VW WHERE  facility_id = '"+facilityId+"' AND INDICATOR = '"+indicator+"' AND requestor_code = '"+requestor_code+"'");

		
		stmt= con.createStatement();
		rs	= stmt.executeQuery(sqlBuff.toString());

		if(rs.next() && rs != null)
		{
			requestor_addr_line1	= checkForNull(rs.getString("addr_line1"));
			requestor_addr_line2	= checkForNull(rs.getString("addr_line2"));
			requestor_addr_line3	= checkForNull(rs.getString("addr_line3"));
			requestor_addr_line4	= checkForNull(rs.getString("addr_line4"));
			requestor_res_town_desc	= checkForNull(rs.getString("town_short_desc"));
			requestor_res_town_code	= checkForNull(rs.getString("town_code"));
			requestor_res_area_desc	= checkForNull(rs.getString("area_short_desc"));
			requestor_res_area_code	= checkForNull(rs.getString("area_code"));
			requestor_region_desc	= checkForNull(rs.getString("region_short_desc"));
			requestor_region_code	= checkForNull(rs.getString("region_code"));
			requestor_postal_code	= checkForNull(rs.getString("postal_code"));
			requestor_postal_desc	= checkForNull(rs.getString("postal_short_desc"));
			requestor_country_desc	= checkForNull(rs.getString("country_name"));
			requestor_country_code	= checkForNull(rs.getString("country_code"));
			

			//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
			
			requestor_contact_no1	= checkForNull(rs.getString("contact1_no"));
			
			requestor_contact_no2	= checkForNull(rs.getString("contact2_no"));
			
			requestor_appl_email_id	= checkForNull(rs.getString("email_id"));
			
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in Query 3 : "+e);
		e.printStackTrace();
	}
}


String[] contact_col_names = null ;
String[] contact_prompts = null ;
String[] contact_fields = null ;
ArrayList contact_addr = fetchContactAddresses(con, out,"parent.messageFrame",prts) ;
contact_col_names = (String[])contact_addr.get(1) ;
contact_prompts   = (String[])contact_addr.get(2) ;
contact_fields    = (String[])contact_addr.get(3) ;
contact_addr = null;


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
  
		
			for(int i=0;i<contact_col_names.length; i++)
			{
				out.println("<tr>") ;                                    
				out.println("<td class='label' align='right' width='50%' nowrap>"+contact_prompts[i]+"&nbsp;&nbsp</td>") ;
				String val  = contact_fields[i] ;
				StringBuffer sb1 = new StringBuffer(val);

				StringBuffer fieldVal = new StringBuffer("");
				for(int z=0;z<val.length();z++)
				{
					String tempVal=sb1.substring(z,z+1);
					if(tempVal.equals("@"))
					{
						fieldVal.append("");
					}
					else
					{
						fieldVal.append(tempVal);
					}
				}

				val = fieldVal.toString();
				out.println("<td class='label' width='50%'>&nbsp;&nbsp;&nbsp;&nbsp;"+val+"</td>");
			}

		
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
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(appl_addr_line1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(appl_addr_line2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_addr_line3));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appl_addr_line4));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appl_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appl_res_town_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appl_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(appl_res_area_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(appl_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(appl_region_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(appl_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appl_postal_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
	
	if(!Requestor_Type.equals(""))
	{	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(requestor_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(requestor_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(requestor_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(requestor_addr_line4));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(requestor_res_town_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(requestor_res_town_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(requestor_res_area_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(requestor_res_area_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(requestor_region_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(requestor_region_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(requestor_postal_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(requestor_postal_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(requestor_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(requestor_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(requestor_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(requestor_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(requestor_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}	
	if(RelationShipType.equals("Self"))
	{	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(self_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(self_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(self_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(self_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(self_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(self_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(self_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(self_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(self_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(self_region_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(self_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(self_postal_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(self_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(self_postal_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(self_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(self_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(self_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(self_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(self_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else if(RelationShipType.equals("Others"))
	{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Oth_appl_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Oth_appl_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Oth_appl_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Oth_appl_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(Oth_appl_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Oth_appl_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Oth_appl_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Oth_appl_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Oth_appl_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Oth_appl_region_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Oth_appl_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Oth_appl_postal_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(Oth_appl_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Oth_appl_postal_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Oth_appl_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Oth_appl_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(other_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(other_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(other_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else if(RelationShipType.equals("FTON"))
	{ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(fton_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fton_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fton_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fton_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(fton_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fton_region_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fton_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(fton_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fton_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fton_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(fton_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fton_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else if(RelationShipType.equals("NKIN"))
	{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nkin_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nkin_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nkin_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nkin_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nkin_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nkin_region_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nkin_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nkin_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nkin_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nkin_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nkin_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nkin_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else if(RelationShipType.equals("EMPLR"))
	{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(emplr_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(emplr_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(emplr_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(emplr_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(emplr_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(emplr_region_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(emplr_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(emplr_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(emplr_country_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(emplr_contact_no1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(emplr_contact_no2));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(emplr_appl_email_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else if(RelationShipType.equals("PersonalDeliveryAddress"))
	{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(personal_del_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(personal_del_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(personal_del_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(personal_del_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(personal_del_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(personal_del_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(personal_del_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(personal_del_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(personal_del_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(personal_del_region_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(personal_del_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(personal_del_postal_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(personal_del_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(personal_del_postal_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(personal_del_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(personal_del_country_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
	}else if(RelationShipType.equals("OtherDeliveryAddress"))
	{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(other_del_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(other_del_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(other_del_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(other_del_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(other_del_res_town_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(other_del_res_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(other_del_res_area_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(other_del_res_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(other_del_region_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(other_del_region_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(other_del_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(other_del_postal_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(other_del_postal_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(other_del_postal_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(other_del_country_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(other_del_country_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
	}


//else if(!call_function.equals("") && !call_function.equals("MEDICAL_BOARD_REQUEST"))

	if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_BOARD_REQUEST") && !RelationShipType.equals("OtherDeliveryAddress") && !RelationShipType.equals("PersonalDeliveryAddress"))
	{	
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disp_appl_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disp_appl_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disp_appl_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disp_appl_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_appl_res_town_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disp_appl_res_area_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disp_appl_region_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disp_appl_postal_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disp_appl_postal_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disp_appl_country_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disp_contact_no1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(disp_contact_no2));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(disp_appl_email_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
//		if(!call_function.equals("DELIVER_MEDICAL_REPORT"))
	//	{	
            _bw.write(_wl_block72Bytes, _wl_block72);
//	}	
            _bw.write(_wl_block1Bytes, _wl_block1);
	}

	if((call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_REPORT_COMPLETED") ) && (RelationShipType.equals("OtherDeliveryAddress") || RelationShipType.equals("PersonalDeliveryAddress") ))
	{	
		
		//String DeliverSql=" SELECT posted_addr_line1, posted_addr_line2, posted_addr_line3, posted_addr_line4, posted_area_code, posted_area_short_desc, posted_country_code, posted_country_long_desc, posted_postal_code, posted_postal_short_desc, posted_region_code, posted_region_short_desc, posted_town_code, posted_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";

		String DeliverSql=" SELECT posted_addr_line1, posted_addr_line2, posted_addr_line3,posted_addr_line4, posted_area_code, MP_GET_DESC.MP_RES_AREA(POSTED_AREA_CODE,'"+locale+"','1') posted_area_short_desc,	posted_country_code,MP_GET_DESC.MP_COUNTRY(POSTED_COUNTRY_CODE,'"+locale+"','1') posted_country_long_desc,posted_postal_code, MP_GET_DESC.MP_POSTAL_CODE(POSTED_REGION_CODE,'"+locale+"','2')	posted_postal_short_desc, posted_region_code, MP_GET_DESC.MP_REGION(POSTED_REGION_CODE,'"+locale+"','2') posted_region_short_desc, posted_town_code, MP_GET_DESC.MP_RES_TOWN(POSTED_TOWN_CODE,'"+locale+"','1') posted_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";
		
	

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(DeliverSql);

		if(rs.next() && rs != null)
		{
			String posted_addr_line1	= checkForNull(rs.getString("posted_addr_line1"));
			String posted_addr_line2	= checkForNull(rs.getString("posted_addr_line2"));
			String posted_addr_line3	= checkForNull(rs.getString("posted_addr_line3"));
			String posted_addr_line4	= checkForNull(rs.getString("posted_addr_line4"));
			String posted_area_code		= checkForNull(rs.getString("posted_area_code"));
			String posted_area_short_desc	= checkForNull(rs.getString("posted_area_short_desc"));
			String posted_country_code	= checkForNull(rs.getString("posted_country_code"));
			String posted_country_long_desc	= checkForNull(rs.getString("posted_country_long_desc"));
			String posted_postal_code	= checkForNull(rs.getString("posted_postal_code"));
//			String posted_postal_short_desc	= checkForNull(rs.getString("posted_postal_short_desc"));
			String posted_region_code	= checkForNull(rs.getString("posted_region_code"));
			String posted_region_short_desc	= checkForNull(rs.getString("posted_region_short_desc"));
			String posted_town_code	= checkForNull(rs.getString("posted_town_code"));
			String posted_town_short_desc	= checkForNull(rs.getString("posted_town_short_desc"));
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(posted_addr_line1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(posted_addr_line2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(posted_addr_line3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(posted_addr_line4));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(posted_town_short_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(posted_town_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(posted_area_short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(posted_area_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(posted_region_short_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(posted_region_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(posted_postal_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(posted_postal_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(posted_country_long_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(posted_country_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
	}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
}	
            _bw.write(_wl_block1Bytes, _wl_block1);
	if(!Requestor_Type.equals(""))
	{	
		if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			
            _bw.write(_wl_block72Bytes, _wl_block72);
	}	
	}

}catch(Exception e)
{
	//out.println("Exception in MedicalRequestorAddress.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	if ( con != null ) ConnectionManager.returnConnection(con,request);
}
	
            _bw.write(_wl_block75Bytes, _wl_block75);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ContactNumber.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
}
