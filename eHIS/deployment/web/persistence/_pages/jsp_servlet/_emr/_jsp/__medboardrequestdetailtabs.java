package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __medboardrequestdetailtabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardRequestDetailTabs.jsp", 1735058562065L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonCalendar.js\' language=\'JavaScript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/MedBoardReqTransaction.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eMR/js/MRPractitionerComponent.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eMR/js/MedBoardRequest.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eOA/js/oamessages.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\nfunction CheckNumberFormat(obj) \n{\n    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) \n\t{\n        return true;\n    }\n    else {\n        if ( obj.value.length > 0 ) {\n            alert(getMessage(\"NUM_ALLOWED\",\"SM\"));\n            obj.value= \"\";\n            obj.focus();\n            return false;\n        }\n    }\n}\n\n\nfunction populateRecptDate(obj, dateObj, dateImg)\n{\n\tif(document.forms[0].medrep_pay_int_mode.value == \"X\")\n\t{\n\t\tif(document.forms[0].call_function.value  == \"MEDICAL_BOARD_REQUEST\")\n\t\t{\n\t\t\tif(obj != \"\")\n\t\t\t{\n\t\t\t\t//dateObj.value = document.forms[0].sysdate.value;\n\t\t\t\tdateObj.value = convertDate(document.forms[0].sysdate.value,\'DMYHM\',\'en\',localeName);\n\t\t\t}\n\t\t\telse\n\t\t\t\tdateObj.value = \"\";\n\t\t}\n\t\telse if(document.forms[0].call_function.value  == \"MEDICAL_BOARD_STATUS\")\n\t\t{\n\t\t\tif(obj != \"\")\n\t\t\t{\n\t\t\t\tdateObj.disabled = false;\n\t\t\t\tdateImg.disabled = false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdateObj.value = \"\";\n\t\t\t\tdateObj.disabled = true;\n\t\t\t\tdateImg.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n}\n\n\nfunction ValidateRecptDateTime(from,to)\n{\n\t/*from = from.value;\n\tto   = to.value;\n\tvar a=  from.split(\" \");\n\tsplitdate=a[0];\n\tsplittime=a[1];\n\tvar splitdateA =splitdate.split(\"/\");\n\tvar splittimeA= splittime.split(\":\");\n\tvar from_date  =new Date(eval(splitdateA[2]), eval(splitdateA[1])-1, eval(splitdateA[0]), eval(splittimeA[0]), eval(splittimeA[1]));\n\n\tvar b=  to.split(\" \");\n\tsplitdate=b[0];\n\tsplittime=b[1];\n\tvar splitdateB =splitdate.split(\"/\");\n\tvar splittimeB= splittime.split(\":\");\n\tvar to_date  =new Date(eval(splitdateB[2]), eval(splitdateB[1])-1, eval(splitdateB[0]), eval(splittimeB[0]), eval(splittimeB[1]));\n\t*/\n\t//if(Date.parse(to_date) <= Date.parse(from_date))\n\tif(isAfter(from,to,\'DMYHM\',\'en\'))\n\t\treturn false;\n\telse\n\t\treturn true;\n}\n\nfunction recptDateValidations(obj, reqDate, sysDate)\n{\n\t//var result = \"Pass\";\n\t//var recptDate = obj.value;\n\t//var systemDate = sysDate.value;\n\tvar requestDate = reqDate.value;\n\n\t/*if(recptDate != \'\' )\n\t{\n\t\tif(!doDateTimeChk(obj))\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\tobj.focus();\n\t\t\tobj.value = \"\";\n\t\t\tresult = \"Fail\";\n\t\t\treturn ;\n\t\t}\n\t}*/\n\n\tif(!validDateObj(obj,\'DMYHM\',localeName))\n\t{\n\t\tobj.focus();\n\t\tobj.value = \"\";\n\t\t//result = \"Fail\";\n\t\treturn ;\n\t}\n\t//if(result == \"Pass\" && recptDate != \'\')\n\telse\n\t{\n\t\t\tvar greg_receiptDateTime = convertDate(obj.value,\'DMYHM\',localeName,\'en\');\n\t\t\t//if(ValidateRecptDateTime(sysDate,obj))\n\t\t\tif(isAfterNow(greg_receiptDateTime,\'DMYHM\',\'en\'))\n\t\t\t{\n\t\t\t\tvar error=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\t\t\terror= error.replace(\'$\',getLabel(\"eMR.ReceiptDateTime.label\",\"MR\"));\n\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.SystemDateTime.label\",\"Common\"));\n\t\t\t\talert(error);\n\t\t\t\tobj.value = \"\";\n\t\t\t\tobj.focus();\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t//else if(ValidateRecptDateTime(obj,reqDate))\n\t\t\telse if(isBefore(greg_receiptDateTime,requestDate,\'DMYHM\',\'en\'))\n\t\t\t{\n\t\t\t\tvar error=getMessage(\"MRDATE1_LT_DATE2\",\"MR\");\n\t\t\t\terror= error.replace(\'$\',getLabel(\"eMR.ReceiptDateTime.label\",\"MR\"));\n\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.Request.label\",\"Common\")+\' \'+getLabel(\"Common.datetime.label\",\"Common\"));\n\t\t\t\talert(error);\n\t\t\t\tobj.value = \"\";\n\t\t\t\tobj.focus();\n\t\t\t\treturn;\n\t\t\t}\n\t}\n}\n\n\n\nfunction CheckZeroVal(obj) \n{\n    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {\n        return true;\n    }\n    else {\n        if ( obj.value.length > 0 && obj.value==0) {\n            alert(getMessage(\"VALUE_SHOULD_BE_GR_ZERO\",\"Common\"));\n            obj.select();\n            obj.focus();\n            return false;\n        }\n    }\n}\n\n\nfunction enableOtherDetails(name, value)\n{\n\tmedrep_pay_int_mode = document.forms[0].medrep_pay_int_mode.value;\n\tif(medrep_pay_int_mode == \"X\")\n\t{\n\t\tif(name == \'charges_appllicable\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].amount.value = \"\";\n\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = false;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].amount.value = \"\";\n\t\t\t\tdocument.forms[0].amount.disabled = true;\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t\telse if(name == \'additional_charges\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\telse if(medrep_pay_int_mode == \"B\")\n\t{\n\t\tif(name == \'charges_appllicable\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].amount.value = \"\";\n\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\tdocument.getElementById(\"chargeImg3\").style.visibility = \"visible\";\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].amount.value = \"\";\n\t\t\t\tdocument.forms[0].amount.disabled = true;\n\t\t\t\tdocument.getElementById(\"chargeImg3\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t\telse if(name == \'additional_charges\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\tdocument.getElementById(\"addtlChargeImg3\").style.visibility = \"visible\";\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = true;\n\t\t\t\tdocument.getElementById(\"addtlChargeImg3\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\t\n\t}\n}\n\n</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<script>\n\n\n// Added by Sridhar on 7 AUG 2004\n// Function will check for empty values before calling up the common lookup func..\nfunction beforeGetAuthorised(target_id,target)\n{\n\tif(document.forms[0].Authorised_hid.value != document.forms[0].authorised_by.value)\n\t{\n\t\tif(document.forms[0].authorised_by.value != \"\")\n\t\t\t getAuthoriser(target_id,target);\n\t}\n}\n\nasync function getAuthoriser(target_id,target)\n{\n\tvar facility_id = document.forms[0].Facility_Id.value;\n\tvar locale = document.forms[0].locale.value;\n\tvar title=\"\";\n\t\n\tvar argumentArray=new Array(8);\n\ttitle = getLabel(\"Common.authorizedby.label\",\"Common\");\n\targumentArray[0]=\"select Appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where language_id = \'\"+locale+\"\' and eff_status like ? and appl_user_id like upper(nvl(?,appl_user_id)) and upper(appl_user_name) like upper(nvl(?,appl_user_name)) \";\n\n\targumentArray[1]=new Array(\"EFF_STATUS\");\n\targumentArray[2]=new Array(\"E\");\n\targumentArray[3]=new Array(STRING,STRING);\n\targumentArray[4]=\"2,3\";\n\targumentArray[5]=target.value;\n\targumentArray[6]=CODE_DESC_LINK;\n\targumentArray[7]=CODE_DESC;\n\tvar retVal=await CommonLookup(title,argumentArray);\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].Authorised_hid.value\t= arr[0];\n\t\tdocument.forms[0].authorised_by.value\t= arr[1];\n\t\tdocument.forms[0].authorised_by.focus();\n\t\tdocument.forms[0].Authorised_hid.value\t= document.forms[0].authorised_by.value;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Authorised_hid.value\t= \"\";\t\t\n\t\tdocument.forms[0].authorised_by.value\t= \"\";\n\t}\n}\n\nasync function MedicalBoardFormation()\n{\n\tvar req_type\t\t= \"MB\";\n\tvar revise_stat\t\t= \"\";\n\tvar req_status\t\t= \"3\";\n\tvar call_func\t\t= \"MEDICAL_BOARD_FORMATION\";\n\tvar req_id\t\t\t= document.forms[0].request_id.value;\n\tvar pat_id\t\t\t= document.forms[0].patientId.value;\n\tvar called_from\t\t= document.forms[0].called_from.value;\n\tvar med_board_type\t= document.forms[0].board_type.value;\n\tvar dialogHeight\t= \"80vh\";\t\n\tvar dialogWidth\t\t= \"80vw\";\t\t\n\tvar dialogTop\t\t= \"10\";\n\tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"1\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\t\n\tvar arguments\t= \"\" ;\n\n\tsretVal\t\t\t= await top.window.showModalDialog(\"../../eMR/jsp/MedBoardRequestFormation.jsp?revise_stat=\"+revise_stat+\"&call_function=\"+call_func+\"&request_id=\"+req_id+\"&PatientId=\"+pat_id+\"&called_from=\"+called_from+\"&med_board_type=\"+med_board_type+\"&req_status=\"+req_status,arguments,features);\n}\n\n\nasync function showDateDetails()\n{\n\tvar call_function\t= document.forms[0].call_function.value;\n\n\tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"3\" ;\n\tvar dialogTop\t\t= \"0vh\";\n\tvar dialogHeight\t= \"39vh\";\n\tvar dialogWidth\t\t= \"40vw\";\n\tvar status\t\t\t= \"no\";\n\tvar arguments\t\t= \"\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&call_function=\"+document.forms[0].call_function.value+\"&PrepareDate=\"+document.forms[0].prepareDate.value+\"&applCompletionDate=\"+document.forms[0].applCompletionDate.value+\"&RequestDate=\"+document.forms[0].RequestDate.value+\"&applSubmissionDate=\"+document.forms[0].applSubmissionDate.value+\"&ReceivedDate=\"+document.forms[0].ReceivedDate.value+\"&DeliveredDate=\"+document.forms[0].DeliveredDate.value,arguments,features);\n}\n\n\nasync function showChargeDetails()\n{\n\tvar call_function\t= document.forms[0].call_function.value;\n\n\tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"3\" ;\n\tvar dialogTop\t\t= \"0vh\";\n\tvar dialogHeight\t= \"39vh\";\n\tvar dialogWidth\t\t= \"40vw\";\n\tvar status\t\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&call_function=\"+document.forms[0].call_function.value+\"&charges_appl_yn=\"+document.forms[0].hdd_charges_appl_yn.value+\"&addl_charges_yn=\"+document.forms[0].hdd_addl_charges_yn.value+\"&receipt_no=\"+document.forms[0].hdd_receipt_no.value+\"&addl_receipt_no=\"+document.forms[0].hdd_addl_receipt_no.value+\"&amount=\"+document.forms[0].hdd_amount.value+\"&addl_amount=\"+document.forms[0].hdd_addl_amount.value+\"&receipt_date=\"+document.forms[0].hdd_receipt_date.value+\"&addl_receipt_date=\"+document.forms[0].hdd_addl_receipt_date.value,arguments,features);\n}\n\n</script>\n\n<!--Onload Added By Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n<body OnMouseDown=\'CodeArrest();\' onSelect = \"restrictMovement()\" onKeyDown =\'lockKey()\' onload = \'RequestorTypeValueForBoard()\'>\n<form name=\'MedBoardReqDetailTabsForm\' id=\'MedBoardReqDetailTabsForm\'  method=post >\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'2\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<tr>\n\t\t\t<td colspan=\'2\' class=\"white\">\n\t\t\t\t<a name=\"tab1\" tabindex=\'0\'></a>  \n\t\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Requestor Details\">\n\t\t\t\t\t\t<a onclick=\"tab_click(\'requestor_details\')\" class=\"tabClicked\" ><span class=\"tabSpanclicked\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span></a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t\t\t\t<a onclick=\"tab_click(\'other_details\')\" class=\"tabA\" ><span class=\"tabAspan\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span></a>\n\t\t\t\t\t</li>\n\t\t\t\t</ul>\n\t\t\t</td>\n\t\t\t<td colspan=\'2\' class=\"white\">&nbsp;</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr align=\"left\">\n\t\t<th class=\"columnheader\" align=\"left\" colspan=\"4\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<tr>\n\t\t<td  width=\"20%\"  class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td  width=\"20%\"  class=\'fields\' ><input type=text name=\"reg_no\" id=\"reg_no\" size=15 maxlength=15 readonly value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ></td>\n\t\t<td  width=\"15%\"  class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td  width=\"40%\" class=\'querydata\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t\n\t\t<td class=\'fields\'><select name=\"appl_type\" id=\"appl_type\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" -----\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<td class=\'fields\'>\n\t\t<!-- Below line is commented by Akhilesh because unnecessary function is calling -->\n\t\t<!--<input type=\"text\" id=\'applnDt\' name=\"appln_date\" id=\"appln_date\" maxlength=16 size=16 onblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\");CompareRegnDate(this,document.forms[0].sysdate);\' onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"> -->\n\n\t\t<input type=\"text\" id=\'applnDt\' name=\"appln_date\" id=\"appln_date\" maxlength=16 size=16 onblur=\'CompareRegnDate(this,document.forms[0].sysdate);\' onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><img id=\"ApplnImg\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].appln_date.focus();return showCalendar(\'applnDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:visible\"></img></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t<td class=\'fields\'><input type=text name=\"appl_name\" id=\"appl_name\" size=30 maxlength=80 ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ></td>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t<td class=\'fields\'><input type=text name=\"appl_refno\" id=\"appl_refno\" size=15 maxlength=15 ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t<td class=\'fields\'><select name=\"relationship_type\" id=\"relationship_type\" onchange=\"populateApplName(this.value);enDisRequestor(this.value);popApplAddress(this.value)\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >\n\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" -----</option>\n\t\t<option value=\'0\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t<option value=\'4\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t</select></td>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t<td class=\'fields\'><select name=\'relationship\' id=\'relationship\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\n\t\t<option value=\'\'>-----";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="-----</option>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"relationImg\" style=\"visibility:hidden\" ></img></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t<td class=\'fields\'><select name=\"req_type\" id=\"req_type\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" onchange=\"document.forms[0].requestor_desc.value=\'\';document.forms[0].Requestor_Code.value=\'\';EnDisRelation(this.value);\">\n\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" -----</option>\n\t\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t</select>\n\t\t</td> \n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<td class=\'fields\'><input type=text name=\"requestor_desc\" id=\"requestor_desc\" size=15 maxlength=15 onblur=\"beforeLookupSearch()\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" ><input type=button class=button name=\'search_Requestor\' id=\'search_Requestor\' value=\'?\' onclick=\"LookupSearch()\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="><input type=hidden name=\"Requestor_desc_hid\" id=\"Requestor_desc_hid\" value=\'\'><input type=hidden name=\"Requestor_Code\" id=\"Requestor_Code\" value=\"\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"requestorImg\" style=\"visibility:hidden\" ></img></td>\t\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td class=\'fields\'>\n\t\t<SELECT name=\"cons_letter\" id=\"cons_letter\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">\n\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t</SELECT>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t<td class=\'fields\'><input type=text name=\"for_attn\" id=\"for_attn\" size=25 maxlength=50 ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" ></td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t<td  class=\'fields\'><select name=\"board_type\" id=\"board_type\" onblur=\"tab_click(\'requestor_details\')\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ><option value=\'\' >----- ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" -----";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:visible\"></img>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<td class=\'fields\'><input type=text name=\"appl_no\" id=\"appl_no\" size=15 maxlength=15 ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'></td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t<tr>\t\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td class=\'button\'><input type=\"button\" name=\"Dates\" id=\"Dates\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" class=\'button\' onclick=\"showDateDetails();\" ></td>\n\t\t<td class=\'button\'><input type=\"button\" name=\"Charges\" id=\"Charges\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" class=\'button\' onclick=\"showChargeDetails();\" ></td>\n\t\t<td class=\'button\'><input type=\"button\" name=\"appl_addr\" id=\"appl_addr\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" class=\'button\' onclick=\"DisplayApplAddress(relationship_type.value);\" onblur=\"tab_click(\'requestor_details\')\" disabled></td>\n\t</tr>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t<tr>\t\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\'button\'><input type=\"button\" name=\"appl_addr\" id=\"appl_addr\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" class=\'button\' onclick=\"DisplayApplAddress(relationship_type.value);\" onblur=\"tab_click(\'requestor_details\')\" disabled></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<tr align=\"left\">\n\t\t\t<th class=\"columnheader\" colspan=\"4\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"20%\" class=\'label\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><select name=\"charges_appllicable\" id=\"charges_appllicable\" onchange=\"enableOtherDetails(this.name,this.value)\">\n\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</option>\n\t\t\t<option value=\'N\' selected>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg1\"></td>\n\t\t\t<td width=\"30%\" class=\'label\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><select name=\"additional_charges\" id=\"additional_charges\" onchange=\"enableOtherDetails(this.name,this.value)\">\n\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg1\" ></img></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" onblur=\"populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById(\\\"recp_dat_img\\\"));\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' style=\"visibility:hidden\" id=\"chargeImg2\" ></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=add_recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" onblur=\"populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById(\"add_recp_dat_img\"));\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg2\" ></img></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=amount size=15 maxlength=15  disabled value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" onBlur=\"CheckZeroVal(this);CheckNumberFormat(this);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg3\"></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=add_amount size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" onBlur=\"CheckZeroVal(this);CheckNumberFormat(this);\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg3\" ></img></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t<td class=\'fields\'><input type=text id=\'recpid\' name=recp_dat size=16 maxlength=16 onblur=\"recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)\" disabled value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" ><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"recp_dat_img\" onClick=\"document.forms[0].recp_dat.focus();return showCalendar(\'recpid\',null,\'hh:mm\');\" disabled/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg4\"></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t<td class=\'fields\'><input type=text id=\'addrecpid\' name=add_recp_dat size=16 maxlength=16 disabled value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" onblur=\"recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)\" ><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"add_recp_dat_img\" onClick=\"document.forms[0].add_recp_dat.focus();return showCalendar(\'addrecpid\',null,\'hh:mm\');\" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="/><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg4\" ></img></td>\n\t\t</tr>\n\t\t<script>\n\t\t\tdocument.forms[0].charges_appllicable.value = \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\tdocument.forms[0].additional_charges.value = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\n\t\t\tif(document.forms[0].charges_appllicable.value == \"Y\")\n\t\t\t{\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" == \"X\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\t\tdocument.forms[0].recp_no.disabled = false;\n\t\t\t\t\tdocument.forms[0].recp_dat.disabled = false;\n\t\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = false;\n\t\t\t\t}\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" == \"B\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\t}\n\t\t\t}\n\n\t\tif(document.forms[0].additional_charges.value == \"Y\")\n\t\t{\n\t\t\tif(\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" == \"X\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = false;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = false;\n\t\t\t}\n\t\t\telse if(\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" == \"B\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t}\n\t\t}\n\t\t</script>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t<tr>\n\t\t<th class=\"columnheader\" colspan=\"4\">&nbsp;</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" </td>\n\t\t\t<td class=\'fields\' width=\"25%\"><SELECT name=\"rep_type\" id=\"rep_type\" ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" >\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" -----</option>\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\'  id=\'ReportTypeImg\' align=\'center\'></img></td>\n\t\t\t<td width=\"30%\" class=\'label\' >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><input type=text name=\"dept_spl\" id=\"dept_spl\" size=15 maxlength=15 ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" onblur=\"BeforeGetSpecialtyValue(this, \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\" ><input type=hidden class=label name=\"Splcode\" id=\"Splcode\" ><input type=button class=button name=\'search_spl\' id=\'search_spl\' value=\'?\' onclick=\"getSpecialtyValue(dept_spl, \'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\" ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" ><img src=\'../../eCommon/images/mandatory.gif\' id=\'DeptImg\' align=\'center\'></img></td>\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t\t<td class=\'fields\' colspan=\"3\" ><textarea name=\'MedicalMembers\' rows=2 cols=\'60\' onblur= \"makeValidString(this);chklim(this,200)\" ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="  value=\"\" ></textarea></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"20%\" >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t<td colspan=\"3\" class=\'fields\'><textarea name=\'remarks\' rows=2 cols=\'60\' onblur=\"makeValidString(this);chklim(this,200);\"  >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</textarea></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t<td nowrap class=\'querydata\' >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="<input type=\'hidden\' name=\'appl_sub_dt\' id=\'appl_sub_dt\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"></td>\n\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n\t\t\t<td  class=\'fields\'><SELECT name=\"fwd_pract_desc\" id=\"fwd_pract_desc\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</select><img src=\'../../eCommon/images/mandatory.gif\'  id=\'fwd_practitionerImg\' align=\'center\'></img></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t<tr>\n\t\t\t<td  class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t\t<td  class=\'fields\' width=\"25%\"><select name=\"appl_status\" id=\"appl_status\" onchange=\"setDate(this.value)\">\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" -----</option>\n\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</option>\n\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'  id=\'appln_status_Img\' align=\'center\'></img></td><td id=\'appln_col1\' class=\'label\'  width=\"30%\"></td><td class=\'querydata\' id=\'appln_col2\' width=\"25%\"><input type=hidden id=\'applcompdat\' name=\"appl_comp_dat\" id=\"appl_comp_dat\" size=15 maxlength=15 value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t<!-- Below line is commented by Akhilesh because unnecessary function is calling -->\n\t\t\t<!--<input type=\"text\" id=\'collectDt\' name=\"collect_date\" id=\"collect_date\" maxlength=16 size=16 disabled onblur =\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\");CompareSysDate(this,document.forms[0].sysdate);\' value =\"\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\">-->\n\t\t\t<input type=\"text\" id=\'collectDt\' name=\"collect_date\" id=\"collect_date\" maxlength=16 size=16 disabled onblur =\'CompareSysDate(this,document.forms[0].sysdate);\' value =\"\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\">\n\t\t\t<img id=\'collect_img\' src=\"../../eCommon/images/CommonCalendar.gif\" disabled  onClick=\"document.forms[0].collect_date.focus();return showCalendar(\'collectDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"collectImg\" style=\"visibility:hidden\"></img></td>\t\t\n\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" ><input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t\t\t<td class=\'fields\' colspan=\"3\"><textarea name=\'reqd_docs\' rows=2 cols=\'60\' onblur=\"makeValidString(this);chklim(this,200);tab_click(\'other_details\');\"  >";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</textarea></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'button\'><input type=button class=\"button\" name=\"Formation_but\" id=\"Formation_but\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" onClick=\"MedicalBoardFormation()\"></td>\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t<tr>\n\t\t\t<td class=\"label\" width=\"20%\" >";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</td>\n\t\t\t<td class=\'fields\' width=\"25%\"><input type=\"text\" name=\"disp_col_date\" id=\"disp_col_date\" maxlength=16 size=16 value =\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" disabled ><img src=\"../../eCommon/images/CommonCalendar.gif\" disabled/></td>\n\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t<td class=label width=\"30%\">";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t\t<TD class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t<td class=label width=\"30%\">&nbsp;</td>\n\t\t\t<td class=label width=\"25%\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t\t\t\t<td class=querydata >";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="<input type=\'hidden\' name=\'disp_prep_pract_desc\' id=\'disp_prep_pract_desc\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" ></td>\n\t\t\t\t<td class=label >&nbsp;</td>\n\t\t\t\t<td class=label >&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t<!--Below line is commented by Akhilesh because unnecessary function is calling.-->\n\t\t\t\t<!--<input type=\"text\" id=\'prepareDt\' name=\"prepare_date\" id=\"prepare_date\" maxlength=16 size=16 onblur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\");CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);\' value =\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\">-->\n\t\t\t\t<input type=\"text\" id=\'prepareDt\' name=\"prepare_date\" id=\"prepare_date\" maxlength=16 size=16 onblur=\'CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);\' value =\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\">\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].prepare_date.focus();return showCalendar(\'prepareDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'  id=\'prepare_date_Img\' align=\'center\'></img></td>\n\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'prep_pract_desc\' id=\'prep_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforePrepGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" ><input type=\'hidden\' name=\'prep_practitioner_id\' id=\'prep_practitioner_id\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" ><input type=\'button\' name=\'prep_pract_id_search\' id=\'prep_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ><img src=\'../../eCommon/images/mandatory.gif\'  id=\'prep_pract_desc_Img\' align=\'center\'></img></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t\t\t\t<td class=\'QueryData\' >";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td>\n\t\t\t\t<td class=\'querydata\' >";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\n\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\"text\" id=\'ReceiveDt\' name=\"receive_date\" id=\"receive_date\" maxlength=16 size=16 onblur =\'chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);\' value =\"\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].receive_date.focus();return showCalendar(\'ReceiveDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'  id=\'receive_date_Img\' align=\'center\'></img></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t\t\t\t\t<TD class=\'querydata\' >";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</td>\n\t\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\"text\" id=\'deliveredDt\' name=\"delivered_date\" id=\"delivered_date\" maxlength=16 size=16 onblur =\'chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);\' value =\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].delivered_date.focus();return showCalendar(\'deliveredDt\',null,\'hh:mm\');\" id=\"del_img\"/><img src=\'../../eCommon/images/mandatory.gif\' id=\'delivered_date_Img\' align=\'center\'></img></td>\n\t\t\t\t\t<td class=label >&nbsp;</td>\n\t\t\t\t\t<td class=label >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" </td>\n\t\t\t\t<td class=queryData >";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t<td class=\"label\"  nowrap >";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t<td class=\'fields\'><select name=\"Despatch_mode\" id=\"Despatch_mode\" onchange=\"enableDisableObjs(this.value)\" onblur=\"tab_click(\'other_details\');\">\n\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" -----</option>\n\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</option>\n\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</option>\n\t\t\t\t</select>\n\t\t\t\t<script>document.forms[0].Despatch_mode.value = \"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\";</script>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td>\n\t\t\t\t<td class=\'fields\'><input disabled type=\"text\" id=\'postedDt\' name=\"posted_date\" id=\"posted_date\" maxlength=16 size=16 onblur=\'chkDateVal(this);\' onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].posted_date.focus();return showCalendar(\'postedDt\',null,\'hh:mm\');\" id=\'postImg\' disabled/></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'button\'><input class=button type=\"button\" name=\"address\" id=\"address\" value=\"Delivery/Dispatch Add\" disabled onclick=\"popAddress();\"></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'button\'><input class=button type=\"button\" name=\"address\" id=\"address\" value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' disabled onclick=\"popAddress();\"></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=\"file_no\" id=\"file_no\" size=\'20\' maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"  disabled onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur=\"tab_click(\'other_details\')\"></td>\n\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t<td class=\'fields\'><input type=text name=\"report_taken\" id=\"report_taken\" size=\'20\'   value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\"  maxlength=\"30\" disabled ></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=\"del_nric_no\" id=\"del_nric_no\" size=\"20\" maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"  onBlur=\"CheckNumberFormat(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' disabled ></td>\n\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\n\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="</td>\n\t\t\t<td  class=\'fields\'><select name=\"del_oth_alt_type\" id=\"del_oth_alt_type\" Disabled onchange=\'if(this.value!=\"\"){document.forms[0].del_oth_alt_id.value = \"\";document.forms[0].del_oth_alt_id.disabled=false;}else{document.forms[0].del_oth_alt_id.value = \"\";document.forms[0].del_oth_alt_id.disabled=true}\'> \n\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\t\t\t\t\t  \n\t\t\t<script>\n\t\t\t\tdocument.forms[0].del_oth_alt_type.value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\";\n\t\t\t</script>\n\t\t\t</select>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\t\n\t\t\t<td  class=\'fields\'><input type=text name=\"del_oth_alt_id\" id=\"del_oth_alt_id\" size=\'20\' maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" disabled onblur=\"tab_click(\'other_details\');validateSplchars(this)\" ></td>\t<td class=label >&nbsp;</td>\n\t\t\t<td class=label >&nbsp;</td>\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="  \n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\"text\" id=\'RevisedCollectdDt\' name=\"revised_collect_date\" id=\"revised_collect_date\" maxlength=16 size=16 onblur=\'chkDateVal(this);validateDate(this);\' value =\"\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].revised_collect_date.focus();return showCalendar(\'RevisedCollectdDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</td>\n\t\t\t\t<td class=\'fields\' ><input type=\"text\" name=\"authorised_by\" id=\"authorised_by\" maxlength=16 size=16 value=\"\" onBlur=\'beforeGetAuthorised(document.forms[0].Authorised_hid,this);\'><input type=button class=button name=\'search_Authorised\' id=\'search_Authorised\' value=\'?\' onclick=\"getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].authorised_by)\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t<input type=hidden name=\"Authorised_hid\" id=\"Authorised_hid\" value=\'\'>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\' class=\"white\">\n\t\t\t\t\t<a name=\"tab3\" id=\"tab3\" tabindex=\'0\' ></a>\n\t\t\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Requestor Details\">\n\t\t\t\t\t\t\t<a onclick=\"tab_click(\'requestor_details\')\" class=\"tabA\" ><span class=\"tabAspan\" >";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</span></a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t\t\t\t\t<a onclick=\"tab_click(\'other_details\')\" class=\"tabClicked\" ><span class=\"tabSpanclicked\" >";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</span></a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t</ul> \n\t\t\t\t</td>\n\t\t\t\t<td colspan=\'2\' class=\"white\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<th class=\"columnheader\" align=\"left\" colspan=\"4\" >";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</td>\n\t\t\t\t<td class=\'fields\' width=\"25%\"><select name=\"charges_appllicable\" id=\"charges_appllicable\"  ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" onchange=\"enableOtherDetails(this.name,this.value)\">\n\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</option>\n\t\t\t\t<option value=\'N\' selected>";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</option>\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg1\"></td>\n\t\t\t\t<td  class=\'label\' width=\"30%\">";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t\t\t<td class=\'fields\' width=\"25%\"><select name=\"additional_charges\" id=\"additional_charges\"  ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</option>\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg1\"></img></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" onblur=\"populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById(\"recp_dat_img\"));\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg2\"></td>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=add_recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" onblur=\"populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById(\"add_recp_dat_img\"));\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg2\"></img></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=amount size=15 maxlength=15  disabled value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" onBlur=\"CheckZeroVal(this);CheckNumberFormat(this);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg3\"></td>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text name=add_amount size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" onBlur=\"CheckZeroVal(this);CheckNumberFormat(this);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg3\"></img></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text id=\'recpid\' name=recp_dat size=16 maxlength=16 disabled value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" ><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"recp_dat_img\" onClick=\"document.forms[0].recp_dat.focus();return showCalendar(\'recpid\',null,\'hh:mm\');\"  disabled/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg4\"></td>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=text id=\'addrecpid\' name=add_recp_dat size=16 maxlength=16 disabled value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" ><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"add_recp_dat_img\" onClick=\"document.forms[0].add_recp_dat.focus();return showCalendar(\'addrecpid\',null,\'hh:mm\');\" ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg4\"></img></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"\">\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t\t<input type=\'hidden\' name=\'request_id\' id=\'request_id\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t\t<input type=\'hidden\' name=\'EncounterIDS\' id=\'EncounterIDS\' value=\"\">\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t\t<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n\t\t<input type=\'hidden\' name=\'request_date\' id=\'request_date\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n\t\t<input type=\'hidden\' name=\'hdd_Request_desc\' id=\'hdd_Request_desc\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_Medical_members\' id=\'hdd_Medical_members\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_Pract_name\' id=\'hdd_Pract_name\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_team_desc\' id=\'hdd_team_desc\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_CollectDate\' id=\'hdd_CollectDate\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_PrepareDate\' id=\'hdd_PrepareDate\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_RecieveDate\' id=\'hdd_RecieveDate\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_remarks\' id=\'hdd_remarks\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_requestor_code\' id=\'hdd_requestor_code\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_team_code\' id=\'hdd_team_code\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t<input type=\'hidden\' name=\'hdd_pract_code\' id=\'hdd_pract_code\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t\t<input type=\'hidden\' name=\'new_func_id\' id=\'new_func_id\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t\t<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t\t<input type=\'hidden\' name=\'old_revised_collect_date\' id=\'old_revised_collect_date\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"insert\"> <!-- used for address -->\n\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t<input type=\'hidden\' name=\'hid_revised_collect_date\' id=\'hid_revised_collect_date\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\n\t\t<!-- ADDRESS FIELDS FOR APPLICANT ... -->\n\t\t<input type=\'hidden\' name=\'appl_addr_line1\' id=\'appl_addr_line1\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_addr_line2\' id=\'appl_addr_line2\' value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_addr_line3\' id=\'appl_addr_line3\' value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_addr_line4\' id=\'appl_addr_line4\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_res_town_code\' id=\'appl_res_town_code\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_res_town_desc\' id=\'appl_res_town_desc\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_res_area_code\' id=\'appl_res_area_code\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_res_area_desc\' id=\'appl_res_area_desc\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_region_code\' id=\'appl_region_code\' value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_region_desc\' id=\'appl_region_desc\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_postal_code\' id=\'appl_postal_code\' value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_postal_desc\' id=\'appl_postal_desc\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_country_desc\' id=\'appl_country_desc\' value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" >\n\t\t<input type=\'hidden\' name=\'appl_country_code\' id=\'appl_country_code\' value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" >\n\n\t\t<!-- ADDRESS FIELDS FOR OTHERS ... -->\n\t\t<input type=\'hidden\' name=\'Oth_appl_addr_line1\' id=\'Oth_appl_addr_line1\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_addr_line2\' id=\'Oth_appl_addr_line2\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_addr_line3\' id=\'Oth_appl_addr_line3\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_addr_line4\' id=\'Oth_appl_addr_line4\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_res_town_desc\' id=\'Oth_appl_res_town_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_res_town_code\' id=\'Oth_appl_res_town_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_res_area_desc\' id=\'Oth_appl_res_area_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_res_area_code\' id=\'Oth_appl_res_area_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_region_desc\' id=\'Oth_appl_region_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_region_code\' id=\'Oth_appl_region_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_postal_desc\' id=\'Oth_appl_postal_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_postal_code\' id=\'Oth_appl_postal_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_country_desc\' id=\'Oth_appl_country_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'Oth_appl_country_code\' id=\'Oth_appl_country_code\' value=\"\">\n\n\t\t<!-- ADDRESS FIELDS FOR NKIN ...  -->\n\t\t<input type=\'hidden\' name=\'nkin_addr_line1\' id=\'nkin_addr_line1\' value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_addr_line2\' id=\'nkin_addr_line2\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_addr_line3\' id=\'nkin_addr_line3\' value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_addr_line4\' id=\'nkin_addr_line4\' value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_res_town_desc\' id=\'nkin_res_town_desc\' value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_res_town_code\' id=\'nkin_res_town_code\' value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_res_area_desc\' id=\'nkin_res_area_desc\' value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_res_area_code\' id=\'nkin_res_area_code\' value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_region_desc\' id=\'nkin_region_desc\' value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_region_code\' id=\'nkin_region_code\' value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n\t\t<input type=\'hidden\' name=\'nkin_postal_desc\' id=\'nkin_postal_desc\' value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\"> \n\t\t<input type=\'hidden\' name=\'nkin_postal_code\' id=\'nkin_postal_code\' value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\"> \n\t\t<input type=\'hidden\' name=\'nkin_country_desc\' id=\'nkin_country_desc\' value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\"> \n\t\t<input type=\'hidden\' name=\'nkin_country_code\' id=\'nkin_country_code\' value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"> \n\n\t\t<!-- ADDRESS FIELDS FOR FTON ...  -->\n\t\t<input type=\'hidden\' name=\'fton_addr_line1\' id=\'fton_addr_line1\' value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t\t<input type=\'hidden\' name=\'fton_addr_line2\' id=\'fton_addr_line2\' value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\n\t\t<input type=\'hidden\' name=\'fton_addr_line3\' id=\'fton_addr_line3\' value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\t\t<input type=\'hidden\' name=\'fton_addr_line4\' id=\'fton_addr_line4\' value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t<input type=\'hidden\' name=\'fton_res_town_desc\' id=\'fton_res_town_desc\' value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n\t\t<input type=\'hidden\' name=\'fton_res_town_code\' id=\'fton_res_town_code\' value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n\t\t<input type=\'hidden\' name=\'fton_res_area_desc\' id=\'fton_res_area_desc\' value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t\t<input type=\'hidden\' name=\'fton_res_area_code\' id=\'fton_res_area_code\' value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\n\t\t<input type=\'hidden\' name=\'fton_region_desc\' id=\'fton_region_desc\' value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t<input type=\'hidden\' name=\'fton_region_code\' id=\'fton_region_code\' value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\n\t\t<input type=\'hidden\' name=\'fton_postal_desc\' id=\'fton_postal_desc\' value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\"> \n\t\t<input type=\'hidden\' name=\'fton_postal_code\' id=\'fton_postal_code\' value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\"> \n\t\t<input type=\'hidden\' name=\'fton_country_desc\' id=\'fton_country_desc\' value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\"> \n\t\t<input type=\'hidden\' name=\'fton_country_code\' id=\'fton_country_code\' value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\"> \n\n\t\t<!-- ADDRESS FIELDS FOR EMPLR ...  -->\n\t\t<input type=\'hidden\' name=\'emplr_addr_line1\' id=\'emplr_addr_line1\' value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_addr_line2\' id=\'emplr_addr_line2\' value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_addr_line3\' id=\'emplr_addr_line3\' value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_addr_line4\' id=\'emplr_addr_line4\' value=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_res_town_desc\' id=\'emplr_res_town_desc\' value=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_res_town_code\' id=\'emplr_res_town_code\' value=\"";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_res_area_desc\' id=\'emplr_res_area_desc\' value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_res_area_code\' id=\'emplr_res_area_code\' value=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_region_desc\' id=\'emplr_region_desc\' value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_region_code\' id=\'emplr_region_code\' value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\">\n\t\t<input type=\'hidden\' name=\'emplr_postal_desc\' id=\'emplr_postal_desc\' value=\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\"> \n\t\t<input type=\'hidden\' name=\'emplr_postal_code\' id=\'emplr_postal_code\' value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\"> \n\t\t<input type=\'hidden\' name=\'emplr_country_desc\' id=\'emplr_country_desc\' value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\"> \n\t\t<input type=\'hidden\' name=\'emplr_country_code\' id=\'emplr_country_code\' value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\"> \n\n\t<!-- ADDRESS FIELDS FOR Requestor DELIVERY ... -->\n\t\t<input type=\'hidden\' name=\'requestor_addr_line1\' id=\'requestor_addr_line1\' value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_addr_line2\' id=\'requestor_addr_line2\' value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_addr_line3\' id=\'requestor_addr_line3\' value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_addr_line4\' id=\'requestor_addr_line4\' value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_res_town_desc\' id=\'requestor_res_town_desc\' value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_res_town_code\' id=\'requestor_res_town_code\' value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_res_area_desc\' id=\'requestor_res_area_desc\' value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_res_area_code\' id=\'requestor_res_area_code\' value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_region_desc\' id=\'requestor_region_desc\' value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_region_code\' id=\'requestor_region_code\' value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_postal_desc\' id=\'requestor_postal_desc\' value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_postal_code\' id=\'requestor_postal_code\' value=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_country_desc\' id=\'requestor_country_desc\' value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n\t\t<input type=\'hidden\' name=\'requestor_country_code\' id=\'requestor_country_code\' value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n\n\t\t<!-- ADDRESS FIELDS FOR OTHER DELIVERY ... -->\n\t\t<input type=\'hidden\' name=\'other_del_addr_line1\' id=\'other_del_addr_line1\' value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_addr_line2\' id=\'other_del_addr_line2\' value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_addr_line3\' id=\'other_del_addr_line3\' value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_addr_line4\' id=\'other_del_addr_line4\' value=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_res_town_desc\' id=\'other_del_res_town_desc\' value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_res_town_code\' id=\'other_del_res_town_code\' value=\"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_res_area_desc\' id=\'other_del_res_area_desc\' value=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_res_area_code\' id=\'other_del_res_area_code\' value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_region_desc\' id=\'other_del_region_desc\' value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_region_code\' id=\'other_del_region_code\' value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_postal_desc\' id=\'other_del_postal_desc\' value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_postal_code\' id=\'other_del_postal_code\' value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_country_desc\' id=\'other_del_country_desc\' value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t\t<input type=\'hidden\' name=\'other_del_country_code\' id=\'other_del_country_code\' value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\n\t\t<!-- ADDRESS FIELDS FOR PERSONAL DELIVERY ... -->\n\t\t<input type=\'hidden\' name=\'personal_del_addr_line1\' id=\'personal_del_addr_line1\' value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_addr_line2\' id=\'personal_del_addr_line2\' value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_addr_line3\' id=\'personal_del_addr_line3\' value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_addr_line4\' id=\'personal_del_addr_line4\' value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_res_town_desc\' id=\'personal_del_res_town_desc\' value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_res_town_code\' id=\'personal_del_res_town_code\' value=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_res_area_desc\' id=\'personal_del_res_area_desc\' value=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_res_area_code\' id=\'personal_del_res_area_code\' value=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_region_desc\' id=\'personal_del_region_desc\' value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_region_code\' id=\'personal_del_region_code\' value=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_postal_desc\' id=\'personal_del_postal_desc\' value=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_postal_code\' id=\'personal_del_postal_code\' value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_country_desc\' id=\'personal_del_country_desc\' value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t<input type=\'hidden\' name=\'personal_del_country_code\' id=\'personal_del_country_code\' value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n\n\n\t\t<input type=\'hidden\' name=\'med_board_type\' id=\'med_board_type\' value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\"> \n\n\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"patient_name_long\" id=\"patient_name_long\" value=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"patient_name_loc_lang_long\" id=\"patient_name_loc_lang_long\" value=\"\" >\t\n\t\t\t<input type=\"hidden\" name=\"name_prefix1\" id=\"name_prefix1\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"family_name\" id=\"family_name\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"first_name\" id=\"first_name\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"second_name\" id=\"second_name\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"third_name\" id=\"third_name\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"name_suffix1\" id=\"name_suffix1\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"name_prefix_oth_lang\" id=\"name_prefix_oth_lang\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"family_name_oth_lang\" id=\"family_name_oth_lang\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"first_name_oth_lang\" id=\"first_name_oth_lang\" value=\"\" > \t\n\t\t\t<input type=\"hidden\" name=\"second_name_oth_lang\" id=\"second_name_oth_lang\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"third_name_oth_lang\" id=\"third_name_oth_lang\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"name_suffix_oth_lang\" id=\"name_suffix_oth_lang\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"patient_name_local_lang\" id=\"patient_name_local_lang\" value=\"\" >\t\t\t\n\t\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"date_of_birth\" id=\"date_of_birth\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"Birth_place_code\" id=\"Birth_place_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"place_of_birth\" id=\"place_of_birth\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"birth_place\" id=\"birth_place\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"nationality_code1\" id=\"nationality_code1\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"nationality_desc\" id=\"nationality_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"national_id_no\" id=\"national_id_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id1_no\" id=\"alt_id1_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id2_no\" id=\"alt_id2_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id3_no\" id=\"alt_id3_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id4_no\" id=\"alt_id4_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id3_exp_date\" id=\"alt_id3_exp_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"alt_id4_exp_date\" id=\"alt_id4_exp_date\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"other_alt_type\" id=\"other_alt_type\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"other_alt_Id\" id=\"other_alt_Id\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"race_code\" id=\"race_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"ethnic_group\" id=\"ethnic_group\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"citizen_yn\" id=\"citizen_yn\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"citizen_yn[1]\" id=\"citizen_yn[1]\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"legal_yn\" id=\"legal_yn\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"legal_yn[1]\" id=\"legal_yn[1]\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"addr_line1\" id=\"addr_line1\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"addr_line2\" id=\"addr_line2\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"addr_line3\" id=\"addr_line3\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"addr_line4\" id=\"addr_line4\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"res_town_code\" id=\"res_town_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"res_town_desc\" id=\"res_town_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"res_area_code\" id=\"res_area_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"res_area_desc\" id=\"res_area_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"region_code\" id=\"region_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"region_desc\" id=\"region_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"postal_code\" id=\"postal_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"country_desc\" id=\"country_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"country_code\" id=\"country_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"contact1_name\" id=\"contact1_name\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"addr2_type\" id=\"addr2_type\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_addr_line1\" id=\"mail_addr_line1\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_addr_line2\" id=\"mail_addr_line2\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_addr_line3\" id=\"mail_addr_line3\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_addr_line4\" id=\"mail_addr_line4\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_res_town_code\" id=\"mail_res_town_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_res_town_desc\" id=\"mail_res_town_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_res_area_code\" id=\"mail_res_area_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_res_area_desc\" id=\"mail_res_area_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_postal_code\" id=\"mail_postal_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_region_code\" id=\"mail_region_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_region_desc\" id=\"mail_region_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_country_code\" id=\"mail_country_code\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"mail_country_desc\" id=\"mail_country_desc\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"contact2_name\" id=\"contact2_name\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"contact1_no\" id=\"contact1_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"contact2_no\" id=\"contact2_no\" value=\"\" >\n\t\t\t<input type=\"hidden\" name=\"email\" id=\"email\" value=\"\" >\n\t\t\t<!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_postal_desc\' id=\'alt_postal_desc\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\"\">\n\t\t\t<!--End-->\n\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t<input type=\'hidden\' name=\'isAddressLengthIncAppl\' id=\'isAddressLengthIncAppl\' value=\'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\'><!--Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2-->\n\t<input type=\"hidden\" name=\"Facility_Id\" id=\"Facility_Id\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\" >\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\" >\n\t<input type=\"hidden\" name=\"revise_stat\" id=\"revise_stat\" value=\"\" >\n\t<input type=\"hidden\" name=\"med_board_type\" id=\"med_board_type\" value=\"\" >\n\t<input type=\"hidden\" name=\"req_status\" id=\"req_status\" value=\"\" >\n\n\t<input type=\"hidden\" name=\"medrep_pay_int_mode\" id=\"medrep_pay_int_mode\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\" >\n\t<input type=\"hidden\" name=\"prepareDate\" id=\"prepareDate\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" >\n\t<input type=\"hidden\" name=\"applCompletionDate\" id=\"applCompletionDate\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\" >\n\t<input type=\"hidden\" name=\"RequestDate\" id=\"RequestDate\" value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" >\n\t<input type=\"hidden\" name=\"ReceivedDate\" id=\"ReceivedDate\" value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\" >\n\t<input type=\"hidden\" name=\"DeliveredDate\" id=\"DeliveredDate\" value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" >\n\t<input type=\"hidden\" name=\"applSubmissionDate\" id=\"applSubmissionDate\" value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\" >\n\t<input type=\"hidden\" name=\"hdd_charges_appl_yn\" id=\"hdd_charges_appl_yn\" value=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\" >\n\t<input type=\"hidden\" name=\"hdd_addl_charges_yn\" id=\"hdd_addl_charges_yn\" value=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\" >\n\t<input type=\"hidden\" name=\"hdd_receipt_no\" id=\"hdd_receipt_no\" value=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" >\n\t<input type=\"hidden\" name=\"hdd_addl_receipt_no\" id=\"hdd_addl_receipt_no\" value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\" >\n\t<input type=\"hidden\" name=\"hdd_amount\" id=\"hdd_amount\" value=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\" >\n\t<input type=\"hidden\" name=\"hdd_addl_amount\" id=\"hdd_addl_amount\" value=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\" >\n\t<input type=\"hidden\" name=\"hdd_receipt_date\" id=\"hdd_receipt_date\" value=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\" >\n\t<input type=\"hidden\" name=\"hdd_addl_receipt_date\" id=\"hdd_addl_receipt_date\" value=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\" >\n\n\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t<input type=\'hidden\' name=\'indicator_req\' id=\'indicator_req\' value=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n\n\t<!--Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707-->\n\n\t<input type=\'hidden\' name=\'self_contact_no1\' id=\'self_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'self_contact_no2\' id=\'self_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'self_appl_email_id\' id=\'self_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'nkin_contact_no1\' id=\'nkin_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'nkin_contact_no2\' id=\'nkin_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'nkin_appl_email_id\' id=\'nkin_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'fton_contact_no1\' id=\'fton_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'fton_contact_no2\' id=\'fton_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'fton_appl_email_id\' id=\'fton_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'emplr_contact_no1\' id=\'emplr_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'emplr_contact_no2\' id=\'emplr_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'emplr_appl_email_id\' id=\'emplr_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'other_contact_no1\' id=\'other_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'other_contact_no2\' id=\'other_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'other_appl_email_id\' id=\'other_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'requestor_contact_no1\' id=\'requestor_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'requestor_contact_no2\' id=\'requestor_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'requestor_appl_email_id\' id=\'requestor_appl_email_id\' value=\"\">\n\n\t<!--ML-MMOH-CRF-0707-->\n\n\t";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\n\t\t<script>\n\t\t\tdocument.forms[0].appln_date.value=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\";\n\t\t\tdocument.forms[0].appln_date.disabled=true;\n\t\t\tdocument.getElementById(\"ApplnImg\").disabled=true;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\n\t\t\t<script>\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\" == \"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\n\t\t\t\t<script>\n\t\t\t\tfor(var i=0; i<document.forms[0].length;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].elements(i).disabled = true;\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"del_img\").disabled = true;\t\n\t\t\t\tdocument.forms[0].appl_addr.disabled = false;\n\t\t\t\tdocument.forms[0].Dates.disabled = false;\n\t\t\t\tdocument.forms[0].Charges.disabled = false;\n\t\t\t\tif(document.forms[0].Despatch_mode.value != \'\')\n\t\t\t\t\tdocument.forms[0].address.disabled = false;\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\n\t\t<script>\n\t\t\tif(document.forms[0].rep_type)\n\t\t\t\t{\n\t\t\t\t\t//if(document.forms[0].rep_type.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].ReportTypeImg.style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].dept_spl)\n\t\t\t\t{\n\t\t\t\t\t//if(document.forms[0].dept_spl.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].DeptImg.style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].fwd_pract_desc)\n\t\t\t\t{\n\t\t\t\t\t//if(document.forms[0].fwd_pract_desc.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].fwd_practitionerImg.style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].appl_status)\n\t\t\t\t{\n\t\t\t\t\t//if(document.forms[0].appl_status.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].appln_status_Img.style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].collect_date)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//if(document.forms[0].collect_date.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].collectImg.style.visibility=\'hidden\';\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\tif(document.forms[0].prepare_date)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//if(document.forms[0].prepare_date.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].prepare_date_Img.style.visibility=\'hidden\';\n\t\t\t\t\t\n\t\t\t\t}\n\n\t\t\tif(document.forms[0].prep_pract_desc)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//if(document.forms[0].prep_pract_desc.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].prep_pract_desc_Img.style.visibility=\'hidden\';\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].receive_date)\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//if(document.forms[0].receive_date.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].receive_date_Img.style.visibility=\'hidden\';\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\tif(document.forms[0].delivered_date)\n\t\t\t\t{\n\t\t\t\t\t//if(document.forms[0].delivered_date.value==\'\')\n\t\t\t\t\t\tdocument.forms[0].delivered_date_Img.style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t\n\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n</table>\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

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
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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

/**
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
 			Function name				|		Function ID			| REQUEST_STATUS inserted...
 	Request For Medical Board			| MEDICAL_BOARD_REQUEST		|		1
	Status of Medical Board Request		| MEDICAL_BOARD_STATUS		|		2
	Forward Medical Board Request		| FORWARD_MEDICAL_BOARD		|		3
	Formation of Medical Board			| MEDICAL_BOARD_FORMATION	|		4
	Appointment for Med Board request	| MEDICAL_BOARD_APPT		|		5
	Intimate Appointment of Med Board	| MEDICAL_BOARD_INT_APPT	|		6
	Prepare Medical Report by Board		| PREPARE_MEDICAL_BOARD		|		7
	Receive Medical Report				| RECEIVE_MEDICAL_BOARD		|		8
	Deliver/Dispatch Medical Board		| DELIVER_MEDICAL_BOARD		|		9
	Revise Medical Board				| REVISE_MEDICAL_BOARD		| just update revise collect time...
*/

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
 
	
	String Facility_Id = (String) session.getValue("facility_id");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = (String)session.getAttribute("LOCALE");	

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement appl_typeStmt = null;
	ResultSet appl_typeRS = null;
	Statement oth_stmt = null;
	ResultSet oth_rset = null;
	Statement board_typeStmt = null;
	ResultSet board_typeRS = null;
	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2

try 
{
	con = ConnectionManager.getConnection(request);
	String called_from	= checkForNull(request.getParameter("called_from"));
	String call_function= checkForNull(request.getParameter("call_function"));
	isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2
	String disabledAttribute = "";
	if(call_function.equals("MEDICAL_BOARD_REQUEST") || call_function.equals("MEDICAL_BOARD_STATUS"))
		disabledAttribute = "";
	else
		disabledAttribute = "disabled";

	String disabled = "";
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		disabled = "";
	else
		disabled = "disabled";

	String dis		= "";
	if(call_function.equals("FORWARD_MEDICAL_BOARD"))
		dis = "";
	else
		dis = "disabled";

	String new_func_id		= checkForNull(request.getParameter("new_func_id"));
	
	String patientId		= checkForNull(request.getParameter("PatientId"));
	String request_id		= checkForNull(request.getParameter("request_id"));
	String patient_id		= "";
	String addr_line1		= "";
	String addr_line2		= "";
	String addr_line3		= "";
	String addr_line4		= "";
	String res_town_code	= "";
	String res_town_desc	= "";
	String res_area_code	= "";
	String res_area_desc	= "";
	String region_code		= "";
	String region_desc		= "";
	String postal_code		= "";
	String res_country_desc = "";
	String res_country_code = "";	
	/*ADDRESS for NKIN*/
	String nkin_addr_line1		= ""; 
	String nkin_addr_line2		= ""; 
	String nkin_addr_line3		= ""; 
	String nkin_addr_line4		= ""; 
	String nkin_res_town_desc	= ""; 
	String nkin_res_town_code	= ""; 
	String nkin_res_area_desc	= ""; 
	String nkin_res_area_code	= ""; 
	String nkin_region_desc		= ""; 
	String nkin_region_code		= ""; 
	String nkin_postal_code		= ""; 
	String nkin_country_desc	= ""; 
	String nkin_country_code	= ""; 
	/*ADDRESS for FTON*/
	String fton_addr_line1		= ""; 
	String fton_addr_line2		= ""; 
	String fton_addr_line3		= ""; 
	String fton_addr_line4		= ""; 
	String fton_res_town_desc	= ""; 
	String fton_res_town_code	= ""; 
	String fton_res_area_desc	= ""; 
	String fton_res_area_code	= ""; 
	String fton_region_desc		= ""; 
	String fton_region_code		= ""; 
	String fton_postal_code		= ""; 
	String fton_country_desc	= ""; 
	String fton_country_code	= ""; 
	/*ADDRESS for EMPLR*/
	String emplr_addr_line1		= ""; 
	String emplr_addr_line2		= ""; 
	String emplr_addr_line3		= ""; 
	String emplr_addr_line4		= ""; 
	String emplr_res_town_desc	= ""; 
	String emplr_res_town_code	= ""; 
	String emplr_res_area_desc	= ""; 
	String emplr_res_area_code	= ""; 
	String emplr_region_desc	= ""; 
	String emplr_region_code	= ""; 
	String emplr_postal_code	= ""; 
	String emplr_country_desc	= ""; 
	String emplr_country_code	= ""; 

	String SystemDate				= "";
	String accession_num			= "";
	String Request_desc				= "";
	String reqDate					= "";
	String reqDate_converted		= "";
	String appl_completion_date		= "";
	String remarks					= "";
	String RecdDate					= "";
	String RecdDate_converted		= "";
	String prepareDate				= "";
	String prepareDate_converted	= "";
	String team_desc				= "";
	String Pract_name				= "";
	String Medical_members			= "";
	String med_board_type_code		= "";
	String med_board_short_desc		= "";
	String CollectDate				= "";
	String CollectDate_Converted	= "";
	String team_code				= "";
	String pract_code				= "";
	String requestor_code			= "";
	String revised_collect_date		= "";
	String revised_collect_date_converted = "";
	String nat_id_prompt			= "";
	String accept_national_id_no_yn	= "";

	String relationship_code	= "";
	String relationship_desc	= "";
	String relationship_type	= ""; 
	String requestor_desc		= ""; 
	String appl_type_code		= ""; 
	String appl_type_desc		= ""; 
	String appl_no				= ""; 
	String applicant_name		= ""; 
	String application_date		= ""; 
	String cons_letter			= ""; 
	String application_ref_no	= ""; 
	String for_attn_of			= ""; 
	String report_type_code		= ""; 
	String specialty_code		= ""; 
	String indicator			= ""; 
	String required_docs		= ""; 
	String forwarded_pract_name = "";
	String requesting_pract_name= "";
	String forwarded_pract_id	= "";
	String requesting_pract_id  = "";
	String amount				= "";
	String receipt_no			= "";
	String receipt_date			= "";
	String receipt_date_converted = "";
	String addl_amount			= "";
	String addl_receipt_no		= "";
	String addl_receipt_date	= "";
	String addl_receipt_date_converted = "";
	String charges_appl_yn		= "";
	String addl_charges_yn		= "";
	String med_board_type		= "";
	String event_status			= "";
	String no_of_days			= "";
	String data					= "";
	String code					= "";
	String sel					= "";
	String ca_install_yn		= "";
	String delivered_date		= "";
	String delivered_date_converted = "";
	String applSubmissionDate	= "";
	String posted_date			= "";
	String posted_date_converted= "";
	String dispatch_mode		= "";
	String sec_file_no			= "";
	String report_taken_by		= "";
	String rtb_national_id_no	= "";
	String rtb_alt_id_type		= "";
	String rtb_alt_id__no		= "";
	String SystemDate_display	= "";

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	String requestor_type_desc	= "";

	StringBuffer sqlBuff=new StringBuffer();
	String medrep_pay_int_mode = "X";

	Statement stmt = null;
	PreparedStatement pstmt1		= null;
	stmt = con.createStatement();

	try
	{	
		try
		{	
			String mrParamSql = " select medrep_pay_int_mode, to_char(sysdate,'dd/mm/yyyy hh24:mi')SystemDate from MR_PARAMETER ";
			if (rs != null) rs.close();
			rs	=	stmt.executeQuery(mrParamSql);


			if (rs.next() && rs != null)
			{
				medrep_pay_int_mode = rs.getString("medrep_pay_int_mode");
				SystemDate			= rs.getString("SystemDate");
			}
			SystemDate_display = DateUtils.convertDate(SystemDate,"DMYHM","en",locale);
			if(medrep_pay_int_mode == null ) medrep_pay_int_mode = "X";
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}catch(Exception e) 
		{
			//out.println("Exception in MR_PARAMETER Query : "+e);
			e.printStackTrace();
		}

		String CAinstall = " select install_yn FROM SM_MODULE WHERE module_id = 'CA' ";
		pstmt = con.prepareStatement(CAinstall);
		rs	=	pstmt.executeQuery();

		if ((rs != null) && (rs.next()))
		{
			ca_install_yn = rs.getString("install_yn");
			if(ca_install_yn == null) ca_install_yn ="N";
		}

		if(rs	 != null)   rs.close();
		if(pstmt	 != null)   pstmt.close();

		if((!patientId.equals("")) && (call_function.equals("PREPARE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD")))
		{
			sqlBuff.append("select a.EVENT_STATUS,a.ACCESSION_NUM from CA_ENCNTR_NOTE a ");
			sqlBuff.append(" where a.patient_id=? and a.ACCESSION_NUM = ");
			sqlBuff.append(" (select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
			sqlBuff.append(" facility_id=? and patient_id = ? ");
			sqlBuff.append(" and REQUEST_ID =?) ");

			pstmt = con.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,patientId);
			pstmt.setString(2,Facility_Id);
			pstmt.setString(3,patientId);
			pstmt.setString(4,request_id);

			rs	=	pstmt.executeQuery();
			if (rs.next() && rs != null)
			{
				accession_num	= checkForNull(rs.getString("ACCESSION_NUM"));
				event_status	= checkForNull(rs.getString("EVENT_STATUS"));
			}

			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}

		if(!request_id.equals(""))
		{
						
			String MainSql=" SELECT Addl_Amount, Addl_Charges_yn, Addl_Receipt_No, Am_Get_desc.Am_practitioner(Forwarded_prAct_Id,'"+locale+"','1') Forwarded_prAct_Name, Am_Get_desc.Am_practitioner(RequestIng_prAct_Id,'"+locale+"','1') RequestIng_prAct_Name, Am_Get_desc.Am_speciality(Specialty_Code,'"+locale+"','1') Specialty_Short_desc, Am_Get_desc.Am_medical_team(Prepare_Team_Id,Prepare_Team_Id,'"+locale+"','1') Team_Short_desc, To_char(Addl_Receipt_Date,'dd/mm/yyyy hh24:mi') Addl_Receipt_Date, Amount, apPl_No, apPl_Type_Code, mr_Get_desc.MR_APPL_TYPE(APPL_TYPE_CODE,'"+locale+"','1') apPl_Type_Short_desc, Applicant_Name, Application_ref_No, Charges_apPl_yn, Consent_Letter_apPl, Dispatch_Mode, For_Attn_Of, Forwarded_prAct_Id, c.INDICATOR, (select long_desc from mr_requestor_type where REQUESTOR_TYPE_CODE = c.indicator) indicator_desc, mp_Get_desc.Mp_relationship(Relationship_Code,'"+locale+"','1') rel_Short_desc, Patient_Id,Prepare_prAct_Id, Prepare_Team_Id, Receipt_No, Relationship_Code, Relationship_Type, Remarks, Report_Taken_By, Report_Type_Code,   RequestIng_prAct_Id, a.RequestOr_Code, MR_GET_DESC.MR_REQUESTOR('"+Facility_Id+"',a.RequestOr_Code,'"+locale+"','2')requestor_short_desc, Required_Docs, rTb_alt_Id__No, rTb_alt_Id_Type, rTb_National_Id_No, sec_File_No, med_board_type_code,  MR_GET_DESC.MR_MEDICAL_BOARD_TYPE(a.MED_BOARD_TYPE_CODE,'"+locale+"','2') med_board_short_desc, To_char(apPl_Completion_Date,'dd/mm/yyyy hh24:mi') apPl_Completion_Date, To_char(apPl_Submitted_Date,'dd/mm/yyyy hh24:mi') apPlSubmissionDate, To_char(Application_Date,'dd/mm/yyyy hh24:MI') Application_Date, To_char(Collect_Date,'dd/mm/yyyy hh24:mi') Collect_Date, To_char(Delivered_Date,'dd/mm/yyyy hh24:mi') Delivered_Date, To_char(Posted_Date,'dd/mm/yyyy hh24:mi') Posted_Date, To_char(Prepared_Date,'dd/mm/yyyy hh24:mi') Prepared_Date, To_char(Receipt_Date,'dd/mm/yyyy hh24:mi') Receipt_Date, To_char(Received_Date,'dd/mm/yyyy hh24:mi') Received_Date, To_char(Request_Date,'dd/mm/yyyy hh24:mi') Request_Date,To_char(Revised_Collect_Date,'dd/mm/yyyy hh24:mi') Revised_Collect_Date, Trunc(Prepared_Date - apPl_Completion_Date) No_Of_Days FROM MR_REPORT_REQUEST_HDR a,  MR_REQUESTOR c WHERE a.facility_id = ? AND a.request_id = ? AND c.REQUESTOR_CODE (+) = a.REQUESTOR_CODE ";
			
			/*Query modified by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/ 

			pstmt= con.prepareStatement(MainSql);
			pstmt.setString(1,Facility_Id);
			pstmt.setString(2,request_id);
			rs	= pstmt.executeQuery();
			if (rs.next() && rs != null)
			{
				patient_id				= checkForNull(rs.getString("PATIENT_ID"));
				amount					= checkForNull(rs.getString("AMOUNT"));
				receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));

				receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
				if(!(receipt_date==null || receipt_date.equals("")))
					receipt_date_converted = DateUtils.convertDate(receipt_date,"DMYHM","en",locale);

				addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
				addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));

				addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
				if(!(addl_receipt_date==null || addl_receipt_date.equals("")))
				addl_receipt_date_converted = DateUtils.convertDate(addl_receipt_date,"DMYHM","en",locale);

				charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"));
				addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"));
				med_board_type			= checkForNull(rs.getString("MED_BOARD_TYPE_CODE"));
				Request_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));

				reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
				if(!(reqDate==null || reqDate.equals("")))
					reqDate_converted	= DateUtils.convertDate(reqDate,"DMYHM","en",locale);

				revised_collect_date	= checkForNull(rs.getString("REVISED_COLLECT_DATE"));
				if(!(revised_collect_date==null || revised_collect_date.equals("")))
				revised_collect_date_converted= DateUtils.convertDate(revised_collect_date,"DMYHM","en",locale);


				appl_completion_date	= checkForNull(rs.getString("appl_completion_date"));
				remarks					= checkForNull(rs.getString("REMARKS"));

				application_date		= checkForNull(rs.getString("application_date"));
				if(!(application_date==null || application_date.equals("")))
					application_date	= DateUtils.convertDate(application_date,"DMYHM","en",locale);

				
				RecdDate				= checkForNull(rs.getString("RECEIVED_DATE"));
				if(!(RecdDate==null || RecdDate.equals("")))
					RecdDate_converted	= DateUtils.convertDate(RecdDate,"DMYHM","en",locale);

				

				prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
				if(!(prepareDate==null || prepareDate.equals("")))
				prepareDate_converted	= DateUtils.convertDate(prepareDate,"DMYHM","en",locale);

				team_desc				= checkForNull(rs.getString("TEAM_SHORT_DESC"));
				med_board_type_code		= checkForNull(rs.getString("MED_BOARD_TYPE_CODE"));
				med_board_short_desc	= checkForNull(rs.getString("MED_BOARD_SHORT_DESC"));

				CollectDate				= checkForNull(rs.getString("COLLECT_DATE"));
				if(!(CollectDate==null || CollectDate.equals("")))
					CollectDate_Converted = DateUtils.convertDate(CollectDate,"DMYHM","en",locale);

				team_code				= checkForNull(rs.getString("PREPARE_TEAM_ID"));
				pract_code				= checkForNull(rs.getString("PREPARE_PRACT_ID"));
				requestor_code			= checkForNull(rs.getString("REQUESTOR_CODE"));
				relationship_type		= checkForNull(rs.getString("RELATIONSHIP_TYPE"));
				relationship_code		= checkForNull(rs.getString("RELATIONSHIP_CODE"));  
				relationship_desc		= checkForNull(rs.getString("REL_SHORT_DESC"));  
				requestor_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				appl_type_code			= checkForNull(rs.getString("APPL_TYPE_CODE"));
				appl_type_desc			= checkForNull(rs.getString("APPL_TYPE_SHORT_DESC"));
				appl_no					= checkForNull(rs.getString("APPL_NO"));
				applicant_name			= checkForNull(rs.getString("APPLICANT_NAME"));
				cons_letter				= checkForNull(rs.getString("CONSENT_LETTER_APPL"));
				application_ref_no		= checkForNull(rs.getString("APPLICATION_REF_NO"));
				for_attn_of				= checkForNull(rs.getString("FOR_ATTN_OF"));
				report_type_code		= checkForNull(rs.getString("REPORT_TYPE_CODE"));
				specialty_code			= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"));
				indicator				= checkForNull(rs.getString("indicator"));
				/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
				requestor_type_desc		= checkForNull(rs.getString("indicator_desc"));
				required_docs			= checkForNull(rs.getString("required_docs"));
				forwarded_pract_name	= checkForNull(rs.getString("FORWARDED_PRACT_NAME"));
				requesting_pract_name	= checkForNull(rs.getString("REQUESTING_PRACT_NAME"));
				forwarded_pract_id		= checkForNull(rs.getString("FORWARDED_PRACT_ID"));
				requesting_pract_id		= checkForNull(rs.getString("REQUESTING_PRACT_ID"));
				no_of_days				= checkForNull(rs.getString("no_of_days"));

				delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
				if(!(delivered_date==null || delivered_date.equals("")))
					delivered_date_converted = DateUtils.convertDate(delivered_date,"DMYHM","en",locale);
				
				applSubmissionDate		= checkForNull(rs.getString("applSubmissionDate"));

				posted_date				= checkForNull(rs.getString("POSTED_DATE"));
				if(!(posted_date==null || posted_date.equals("")))
					posted_date_converted = DateUtils.convertDate(posted_date,"DMYHM","en",locale);
			
				
				dispatch_mode			= checkForNull(rs.getString("DISPATCH_MODE"));
					
				sec_file_no				= checkForNull(rs.getString("SEC_FILE_NO"));
				report_taken_by			= checkForNull(rs.getString("REPORT_TAKEN_BY"));
				rtb_national_id_no		= checkForNull(rs.getString("RTB_NATIONAL_ID_NO"));
				rtb_alt_id_type			= checkForNull(rs.getString("RTB_ALT_ID_TYPE"));
				rtb_alt_id__no			= checkForNull(rs.getString("RTB_ALT_ID__NO"));
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 2 : "+e);
		e.printStackTrace();
	}



	try
	{
		
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
				
		//sqlBuff.append(" SELECT resi_addr_line1, resi_addr_line2, resi_addr_line3,resi_addr_line4, resi_postal_code, resi_country_code, mp_get_desc.MP_COUNTRY(resi_country_code,'"+locale+"','2') resi_Country_Name, res_area_code, mp_get_desc.MP_RES_AREA(res_area_code,'"+locale+"','2') res_Area_desc, res_town_code, mp_get_desc.MP_RES_TOWN(res_town_code,'"+locale+"','2') res_Town_desc, region_code, mp_get_desc.MP_REGION(region_code,'"+locale+"','1') Region_desc from MP_PAT_DTLS_VW WHERE patient_id = ? ");

		sqlBuff.append(" SELECT PAT_ADDR.PATIENT_ID , pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, pat_addr.postal1_code resi_postal_code, pat_addr.country1_code resi_country_code, mp_get_desc.MP_COUNTRY(pat_addr.country1_code,'"+locale+"','1') resi_Country_Name, patient.res_area_code res_area_code, mp_get_desc.MP_RES_AREA(patient.res_area_code,'"+locale+"','1') res_Area_desc, patient.res_town_code res_town_code, mp_get_desc.MP_RES_TOWN(patient.res_town_code,'"+locale+"','2') res_Town_desc, patient.region_code region_code, mp_get_desc.MP_REGION(patient.region_code,'"+locale+"','1') Region_desc from MP_PATIENT PATIENT, MP_PAT_ADDRESSES PAT_ADDR WHERE PATIENT.PATIENT_ID = PAT_ADDR.PATIENT_ID AND PATIENT.patient_id = ? ");

		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();

		pstmt= con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,patientId);
		rs	= pstmt.executeQuery();

		if(rs.next() && rs != null)
		{
			addr_line1	= checkForNull(rs.getString("resi_addr_line1"));
			addr_line2	= checkForNull(rs.getString("resi_addr_line2"));
			addr_line3	= checkForNull(rs.getString("resi_addr_line3"));
			addr_line4	= checkForNull(rs.getString("resi_addr_line4"));

			res_town_code	= checkForNull(rs.getString("res_town_code"));
			res_town_desc	= checkForNull(rs.getString("res_town_desc"));
			
			res_area_code	= checkForNull(rs.getString("res_area_code"));
			res_area_desc	= checkForNull(rs.getString("res_area_desc"));

			region_code		= checkForNull(rs.getString("region_code"));
			region_desc		= checkForNull(rs.getString("region_desc"));

			postal_code = checkForNull(rs.getString("resi_postal_code")); 
			
			res_country_desc = checkForNull(rs.getString("resi_country_name")); 
			res_country_code = checkForNull(rs.getString("resi_country_code")); 


		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in Query 5 : "+e);
		e.printStackTrace();
	}

	try
	{
		String contactSql=" SELECT nat_id_prompt, accept_national_id_no_yn, alt_id1_type, accept_oth_alt_id_yn FROM mp_param ";
		pstmt= con.prepareStatement(contactSql);
		rs	= pstmt.executeQuery();

		if(rs.next() && rs != null)
		{
			nat_id_prompt			= checkForNull(rs.getString("nat_id_prompt"));
			accept_national_id_no_yn= checkForNull(rs.getString("accept_national_id_no_yn"));
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 4 : "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block11Bytes, _wl_block11);
	
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	}	
            _bw.write(_wl_block2Bytes, _wl_block2);
	if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
	}	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block22Bytes, _wl_block22);
	}else{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reqDate_converted));
            _bw.write(_wl_block22Bytes, _wl_block22);
	}	
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			appl_typeStmt = con.createStatement();
			appl_typeRS = appl_typeStmt.executeQuery(" select appl_type_code, short_desc from MR_APPL_TYPE_LANG_VW where eff_status = 'E' and language_id='"+locale+"' order by short_desc ");

			if(appl_typeRS!=null)
			{
				sel="";
				while(appl_typeRS.next())
				{
					data = appl_typeRS.getString("SHORT_DESC");
					code = appl_typeRS.getString("APPL_TYPE_CODE");
					if(appl_type_code.equals(code))
						sel = "selected";
					else
						sel="";

					out.println("<option value='"+code+"' "+sel+">"+data+"</option>");
				}
			}	
			if(appl_typeRS != null)appl_typeRS.close();
			if(appl_typeStmt != null)appl_typeStmt.close();
		}
		else
		{
			if(!appl_type_code.equals(""))
				out.println("<option value='"+appl_type_code+"' selected>"+appl_type_desc+"</option>");
		}
	
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(application_ref_no));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
	
		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			if(relationship_type.equals(""))
			out.println("<script>document.getElementById('relationship_type').options[0].selected=true;</script>");
			else if(relationship_type.equals("0"))
			out.println("<script>document.getElementById('relationship_type').options[1].selected=true;</script>");	
			else if(relationship_type.equals("1"))
			out.println("<script>document.getElementById('relationship_type').options[2].selected=true;</script>");
			else if(relationship_type.equals("2"))
			out.println("<script>document.getElementById('relationship_type').options[3].selected=true;</script>");
			else if(relationship_type.equals("3"))
			out.println("<script>document.getElementById('relationship_type').options[4].selected=true;</script>");
			else if(relationship_type.equals("4"))
			out.println("<script>document.getElementById('relationship_type').options[5].selected=true;</script>");
		}	
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			String rel_sel ="";                                     
			String rel_data ="";                                     
			String rel_code ="";    
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			String rel_sql = " select relationship_code, short_desc from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and eff_status='E' order by short_desc ";

			pstmt = con.prepareStatement(rel_sql);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					rel_data = rs.getString("SHORT_DESC");
					rel_code = rs.getString("relationship_code");
					if(relationship_code.equals(rel_code))
					rel_sel = "selected";
					else
					rel_sel="";

					out.println("<option value='"+rel_code+"' "+rel_sel+">"+rel_data+"</option>");
				}
			}	
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
		}
		else
		{
			if(!relationship_code.equals(""))
				out.println("<option value='"+relationship_code+"' selected>"+relationship_desc+"</option>");
		}	
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
		
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(requestor_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			if(cons_letter.equals(""))
			out.println("<script>document.getElementById('cons_letter').options[0].selected=true;</script>");
			if(cons_letter.equals("0"))
			out.println("<script>document.getElementById('cons_letter').options[1].selected=true;</script>");
			else if(cons_letter.equals("1"))
			out.println("<script>document.getElementById('cons_letter').options[2].selected=true;</script>");
			else if(cons_letter.equals("2"))
			out.println("<script>document.getElementById('cons_letter').options[3].selected=true;</script>");
		}	
		if(call_function.equals("MEDICAL_BOARD_STATUS"))
			out.println("<script>document.getElementById('cons_letter').disabled=false;</script>");
	
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(for_attn_of));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{			
			String board_data = "";
			String board_code = "";
			String board_sel = "";
			board_typeStmt = con.createStatement();
			board_typeRS = board_typeStmt.executeQuery(" select med_board_type_code, short_desc from MR_MEDICAL_BOARD_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status = 'E' order by 2 ");
			if(board_typeRS != null)
			{
				sel="";
				while(board_typeRS.next())
				{
					board_data = board_typeRS.getString("short_desc");
					board_code = board_typeRS.getString("med_board_type_code");
					if(med_board_type_code.equals(board_code))
						board_sel = "selected" ;
					out.println("<option value='"+board_code+"' "+board_sel+">"+board_data+"</option>");
				}
			}	
			if(board_typeRS != null) board_typeRS.close();
			if(board_typeStmt != null) board_typeStmt.close();
		}
		else
		{	
			out.println("<option value='"+med_board_type_code+"' selected>"+med_board_short_desc+"</option>");
		}	
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(appl_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
	if(!call_function.equals("MEDICAL_BOARD_REQUEST") && !call_function.equals("MEDICAL_BOARD_STATUS"))
	{	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
	}else{	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
	}	
            _bw.write(_wl_block75Bytes, _wl_block75);
	if(call_function.equals("MEDICAL_BOARD_STATUS"))
	{	
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(receipt_date_converted));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(addl_receipt_date_converted));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(addl_charges_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block101Bytes, _wl_block101);
	}	
            _bw.write(_wl_block102Bytes, _wl_block102);

	if(!call_function.equals("MEDICAL_BOARD_STATUS") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

			if(ca_install_yn.equals("Y"))
			{	
			Statement stm = null;
			ResultSet rss = null;
			String repType_sel = "";
			try
			{
			String sqlrep = " select note_type, note_type_desc from CA_NOTE_TYPE_LANG_VW where note_group_id in (select note_group from CA_NOTE_GROUP where appl_task_id = 'PRE_MEDICAL_BOARD') and EFF_STATUS = 'E' and language_id ='"+locale+"' order by NOTE_TYPE_DESC ";
			stm = con.createStatement();
			rss = stm.executeQuery(sqlrep);
			if(rss!=null)
			{
			while(rss.next())
			{
			String repcode = rss.getString("NOTE_TYPE");
			String repdesc = rss.getString("NOTE_TYPE_DESC");

			if(report_type_code.equals(repcode))
			repType_sel = "selected";
			else
			repType_sel="";

			out.println("<option value='"+repcode+"' "+repType_sel+">"+repdesc+"</option>");
			}
			}
			}
			catch(Exception e)
			{
			//out.println("Exception in rep_type : "+e.toString());
			e.printStackTrace();
			}
			finally
			{
			if(rss!=null) rss.close();
			if(stm!=null) stm.close();
			}
			}
			
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block112Bytes, _wl_block112);
	if(new_func_id.equals("APP_FOR_MED_BOARD"))
		{	
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block115Bytes, _wl_block115);
	}	
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block118Bytes, _wl_block118);
	}

	if(call_function.equals("FORWARD_MEDICAL_BOARD"))
	{	
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

			if(rs !=null) rs.close();
			String pract_sel = "";
			try
			{
				String Pract_Sql = " select b.practitioner_name, a.practitioner_id FROM MR_MED_BOARD_MEMBER a, AM_PRACTITIONER_LANG_VW b WHERE a.facility_id =? AND a.practitioner_id = b.practitioner_id and a.request_id=? and b.language_id =?";
				//stmt = con.createStatement();
				pstmt1 = con.prepareStatement(Pract_Sql);
				pstmt1.setString(1,Facility_Id);
				pstmt1.setString(2,request_id);
				pstmt1.setString(3,locale);
				rs = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						String practcode = rs.getString("practitioner_id");
						String practdesc = rs.getString("practitioner_name");

						if(requesting_pract_id.equals(practcode))
							pract_sel = "selected";
						else
							pract_sel="";

						out.println("<option value='"+practcode+"' "+pract_sel+">"+practdesc+"</option>");
					}
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in Forwarded Pract : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
			}
			
            _bw.write(_wl_block124Bytes, _wl_block124);
	
		for(int j=0;j<10;j++)
		{
			out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
		}
	}	

	if(!call_function.equals("MEDICAL_BOARD_STATUS") && !call_function.equals("FORWARD_MEDICAL_BOARD") && !call_function.equals("PREPARE_MEDICAL_BOARD") && !call_function.equals("RECEIVE_MEDICAL_BOARD") && !call_function.equals("MEDICAL_BOARD_INT_APPT") && !call_function.equals("DELIVER_MEDICAL_BOARD") && !call_function.equals("MEDICAL_BOARD_COMPLETED") && !call_function.equals("REVISE_MEDICAL_BOARD") )
	{	
		for(int j=0;j<10;j++)
		{	
			out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
		}
	}		
            _bw.write(_wl_block125Bytes, _wl_block125);
	if(call_function.equals("MEDICAL_BOARD_STATUS"))
	{	
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block133Bytes, _wl_block133);
	if(!call_function.equals("MEDICAL_BOARD_STATUS"))
			{	
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(requesting_pract_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
	}else{	
            _bw.write(_wl_block138Bytes, _wl_block138);
	}	
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(required_docs));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FormationofMedicalBoard.label","mr_labels")));
            _bw.write(_wl_block142Bytes, _wl_block142);

			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label'colspan=4>&nbsp;</td></tr>");
			}
		}	

	/////////////////////////////// DISPLAY ONLY ////////////////////////
		if(call_function.equals("PREPARE_MEDICAL_BOARD") || 
		call_function.equals("RECEIVE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED") ||
		call_function.equals("REVISE_MEDICAL_BOARD") || call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(CollectDate_Converted));
            _bw.write(_wl_block145Bytes, _wl_block145);
	if(!revised_collect_date.equals(""))
			{	
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(revised_collect_date_converted));
            _bw.write(_wl_block148Bytes, _wl_block148);
	}else{	
            _bw.write(_wl_block149Bytes, _wl_block149);
	}	
            _bw.write(_wl_block150Bytes, _wl_block150);
	}
		
		if(call_function.equals("PREPARE_MEDICAL_BOARD"))
		{	
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(forwarded_pract_id));
            _bw.write(_wl_block161Bytes, _wl_block161);
	for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}
		else if(call_function.equals("RECEIVE_MEDICAL_BOARD")) 
		{	
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(prepareDate_converted));
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block168Bytes, _wl_block168);
	
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}	
		}else if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	
			if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(prepareDate_converted));
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(RecdDate_converted));
            _bw.write(_wl_block172Bytes, _wl_block172);
	}	
            _bw.write(_wl_block173Bytes, _wl_block173);
	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(delivered_date_converted));
            _bw.write(_wl_block175Bytes, _wl_block175);
	}	
            _bw.write(_wl_block125Bytes, _wl_block125);
	if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
		{	
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block177Bytes, _wl_block177);
	}	
            _bw.write(_wl_block178Bytes, _wl_block178);
	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
	}
			else
			{	
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
	}	
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dispatch_mode));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(posted_date_converted));
            _bw.write(_wl_block187Bytes, _wl_block187);
	
			
			if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
			
            _bw.write(_wl_block188Bytes, _wl_block188);
	
					
			}
			else
			{	
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Address.label","common_labels")));
            _bw.write(_wl_block190Bytes, _wl_block190);
	}	
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(sec_file_no));
            _bw.write(_wl_block193Bytes, _wl_block193);
	if(call_function.equals("DELIVER_MEDICAL_BOARD") || call_function.equals("MEDICAL_BOARD_COMPLETED"))
			{	
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
	}
			else
			{	
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
	}	
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(report_taken_by));
            _bw.write(_wl_block197Bytes, _wl_block197);
	if(accept_national_id_no_yn.equals("Y"))
		{	
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(rtb_national_id_no));
            _bw.write(_wl_block199Bytes, _wl_block199);
	}else{	
            _bw.write(_wl_block200Bytes, _wl_block200);
	}	
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

			String altIDsql = "select alt_id_type, short_desc from MP_ALTERNATE_ID_TYPE_LANG_VW where alt_id_type not in (select alt_id1_type from MP_PARAM union select nvl(alt_id2_type,1) from MP_PARAM union select nvl(alt_id3_type,2) from MP_PARAM union select nvl(alt_id4_type,3) from MP_PARAM ) and eff_status='E' and language_id ='"+locale+"' order by 2 ";

			oth_stmt = con.createStatement();
			oth_rset = oth_stmt.executeQuery(altIDsql);	
			if(oth_rset != null)
			{
				while (oth_rset.next())
				{
					out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
				}
			}

			if(oth_rset != null) oth_rset.close();
			if(oth_stmt != null) oth_stmt.close();
			
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(rtb_alt_id_type));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(rtb_alt_id__no));
            _bw.write(_wl_block206Bytes, _wl_block206);

			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}	 
		if(call_function.equals("REVISE_MEDICAL_BOARD"))
		{	
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		}	
            _bw.write(_wl_block125Bytes, _wl_block125);
	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(receipt_date_converted));
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(addl_receipt_date_converted));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block232Bytes, _wl_block232);
	}	
			for(int j=0;j<10;j++)
			{	
				out.println("<tr><td class='label' colspan=4>&nbsp;</td></tr>");
			}
		
		
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(Request_desc));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(Medical_members));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(Pract_name));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(team_desc));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(CollectDate));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(prepareDate));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(RecdDate));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(requestor_code));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(team_code));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(pract_code));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(new_func_id));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(revised_collect_date));
            _bw.write(_wl_block254Bytes, _wl_block254);
	if(!revised_collect_date.equals(""))
		{	
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(revised_collect_date));
            _bw.write(_wl_block256Bytes, _wl_block256);
	}	
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(nkin_res_town_desc));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(nkin_res_town_code));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(nkin_res_area_desc));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(nkin_res_area_code));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(nkin_region_desc));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(nkin_region_code));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(nkin_country_desc));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(nkin_country_code));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(fton_res_town_desc));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(fton_res_town_code));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(fton_res_area_desc));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(fton_res_area_code));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(fton_region_desc));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(fton_region_code));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(fton_country_desc));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(fton_country_code));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(emplr_res_town_desc));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(emplr_res_town_code));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(emplr_res_area_desc));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(emplr_res_area_code));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(emplr_region_desc));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(emplr_region_code));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(emplr_country_desc));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(emplr_country_code));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(med_board_type));
            _bw.write(_wl_block356Bytes, _wl_block356);

		if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
            _bw.write(_wl_block357Bytes, _wl_block357);
	}	
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(isAddressLengthIncAppl));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(prepareDate));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(appl_completion_date));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(RecdDate));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(delivered_date));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(applSubmissionDate));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(addl_charges_yn));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(receipt_date));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(addl_receipt_date));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block377Bytes, _wl_block377);

	if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
	{	
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(application_date));
            _bw.write(_wl_block379Bytes, _wl_block379);
	}	

		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			out.println("<script>document.forms[0].appl_addr.disabled=false;</script>");
		}

		if(call_function.equals("QUERY_DELAY_IN_MRR") )
		{
			out.println("<script>document.forms[0].search.disabled = true;</script>");
		}	
		
		if(!call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block381Bytes, _wl_block381);

		}

		if(call_function.equals("MEDICAL_BOARD_COMPLETED"))
		{	
            _bw.write(_wl_block382Bytes, _wl_block382);
	}

		if(call_function.equals("REVISE_MEDICAL_BOARD"))
	{
            _bw.write(_wl_block383Bytes, _wl_block383);
	}


	}catch(Exception e)
	{
		//out.println("err in try catch : "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block384Bytes, _wl_block384);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestorDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.regndatetime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationType.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.LetterDateTime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicantName.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referenceno.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RelationshipType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employer.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestorType.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requestor.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ConsentLetter.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.available.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notavailable.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notrequired.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Attentionto.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TypeofMedicalBoard.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationNo.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charges.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ChargesApplicable.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalCharges.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptno.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptno.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptdate.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptdate.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DepartmentSpecialty.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MedicalBoardMembers.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplnSubDate.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationStatus.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.complete.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.incomplete.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequiredDocuments.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedCollectDate.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportPreparedDate.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DaystoComplete.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveredDate.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliverMode.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.IntimationMode.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Personal.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DatePosted.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SectionFileNo.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportTakenBy.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.IntimatedTo.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedCollectDate.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestorDetails.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PaymentDetails.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ChargesApplicable.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalCharges.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptno.label", java.lang.String .class,"key"));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalReceiptNo.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalAmount.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptdate.label", java.lang.String .class,"key"));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalReceiptDate.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
