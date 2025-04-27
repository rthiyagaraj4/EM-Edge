package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __moregisterclaimantresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegisterClaimantResult.jsp", 1742813048332L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block3_0Bytes = _getBytes( _wl_block3_0 );

    private final static java.lang.String  _wl_block3_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block3_1Bytes = _getBytes( _wl_block3_1 );

    private final static java.lang.String  _wl_block3_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block3_2Bytes = _getBytes( _wl_block3_2 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<html>\n<head> \n\n\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t  <!--<script language=\'javascript\' src=\'../../eMO/js/MORegisterClaimant.js\'></script>-->\n\t  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n  \n</head>\n <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"ae_reg_attn_result_form\" id=\"ae_reg_attn_result_form\"    method=\"post\" target=\"messageFrame\" >\n\t\t\n\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\n\t\t\t//if(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"==\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")\n\t\t\tif(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\n\t\t\t\teval(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =").document.forms[0].RELATIONSHIP.options[";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="].selected=true;\t\t</script>\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\n<script>\n\t\t\n//parent.frames[3].document.forms[0].RELATIONSHIP.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\t\t\t\n//parent.frames[3].document.forms[0].RELATIONSHIP1.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\t\t\t\neval(";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =").document.forms[0].NAME.value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"\t\t     \neval(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =").document.forms[0].JOB_TITLE.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\t             \t \neval(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =").document.forms[0].COUNTRY_DESC.value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"\t            \t \neval(";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =").document.forms[0].TELEPHONE_OFF.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"\t\neval(";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =").document.forms[0].TELEPHONE_RES.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\t\t\t\t\t\t \neval(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =").document.forms[0].EMAIL_ID.value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\t       \t \neval(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =").document.forms[0].MOB_TEL_NO.value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\t         \t \neval(";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =").document.forms[0].NAT_ID_NO.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\t \t \neval(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =").document.forms[0].ZIP_CODE.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" \neval(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =").document.forms[0].COUNTRY_CODE.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"\t\nif(eval(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =").document.forms[0].region!=null)\n\teval(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =").document.forms[0].region.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"\nif(eval(";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =").document.forms[0].area!=null)\n\teval(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =").document.forms[0].area.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =").document.forms[0].town!=null)\n\teval(";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =").document.forms[0].town.value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =").document.forms[0].region1!=null)\n\teval(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =").document.forms[0].region1.value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =").document.forms[0].area1!=null)\n\teval(";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =").document.forms[0].area1.value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =").document.forms[0].town1!=null)\n\teval(";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =").document.forms[0].town1.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =").document.forms[0].COUNTRY_DESC!=null)\n\teval(";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"\n\nif(eval(";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =").document.forms[0].m_region_code!=null)\n\teval(";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =").document.forms[0].m_region_code.value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =").document.forms[0].m_area_code!=null)\n\teval(";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =").document.forms[0].m_area_code.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =").document.forms[0].m_town_code!=null)\n\teval(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =").document.forms[0].m_town_code.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =").document.forms[0].postal_code!=null)\n\teval(";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =").document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"\n\n\n\n</script>\t \n\t \n\t ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =").document.forms[0].";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =".value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\n\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\n\t \n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" \n\t\t\n\t\t <script>eval(";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =").document.getElementById(\'hed1\').innerHTML=\"Occupation Class\";\n\t\teval(";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =").document.getElementById(\'ocpnlab\').innerHTML=\"<b>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</b>\";\n\t\t </script>\n\t\t\n\t\t ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t <!-- <body OnMouseDown=\'CodeArrest()\' >\n     <form name=\"ae_reg_attn_result_form\" id=\"ae_reg_attn_result_form\"  action=\"../../servlet/eMO.MORegClaimServlet\"  method=\"post\" target=\"messageFrame\" >\n\t -->\n\n\n\t       ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<script>\n\t\t\t\n\t\t\t//if(\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\")\n\t\t     eval(";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t\n\t \n\t \n<script>\n\t\t\n//";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =".document.forms[0].RELATIONSHIP.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"\n//";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =".document.forms[0].RELATIONSHIP1.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"\n\neval(";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =").document.forms[0].ORGANIZATION_NAME.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =").document.forms[0].PATIENT_EMPLOYEE_ID.value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"\t \nif(eval(";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =").document.forms[0].ZIP_CODE!=null)\n\teval(";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" \n\nif(eval(";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"\n\n\n</script>\t \n\n\t \n\t \n\t ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t <input type=\"hidden\" name=\'addrl1\' id=\'addrl1\'  value =\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t <input type=\"hidden\" name=\'addrl2\' id=\'addrl2\'  value =\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t <input type=\"hidden\" name=\'addrl3\' id=\'addrl3\'  value =\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t <input type=\"hidden\" name=\'addrl4\' id=\'addrl4\'  value =\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t <input type=\"hidden\" name=\'pin\' id=\'pin\'  value =\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t <input type=\"hidden\" name=\'coucode\' id=\'coucode\'  value =\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n\t\n        ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t  \t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t        <script>\n\t\t\t\t\t\t\teval(";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\n\t\n\t<script>\neval(";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =").document.forms[0].NAME.value =\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"\t\n//";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =".document.forms[0].TELEPHONE_RES.value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"\t            \t \nif(eval(";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"\n\n\nif(eval(";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =").document.forms[0].m_region!=null)\n\teval(";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =").document.forms[0].m_region.value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =").document.forms[0].m_area!=null)\n\teval(";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =").document.forms[0].m_area.value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =").document.forms[0].m_town!=null)\n\teval(";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =").document.forms[0].m_town.value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =").document.forms[0].postal_code1!=null)\n\teval(";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =").document.forms[0].postal_code1.value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"\n\n</script>\t \n\n\t\n\t\n\n\t\t\n      \n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\n\t<input type=\"hidden\" name=\'j\' id=\'j\'  value =\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t</form>\n\t\t</body>\n\t\t<html>\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block3_0Bytes, _wl_block3_0);
            _bw.write(_wl_block3_1Bytes, _wl_block3_1);
            _bw.write(_wl_block3_2Bytes, _wl_block3_2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

   
	
    Connection conn					= null;
    java.sql.Statement stmt		    = null;
    java.sql.Statement stmt1		= null;
    java.sql.Statement stmt2		= null; 
    java.sql.Statement stmt3		= null;
    java.sql.Statement stmt6		= null;
    java.sql.Statement stmt42		= null;
    
    ResultSet rs					= null;
    ResultSet rs1					= null;
    ResultSet rs2					= null;
    ResultSet rs3					= null;
    ResultSet rs6					= null;
    ResultSet rs42					= null;
	int k=0;	
    try{

      String operation=request.getParameter("operation");
      if(operation==null || operation.equals("null")) operation="insert";
      conn = ConnectionManager.getConnection(request);	
	  String locale=(String)session.getAttribute("LOCALE"); 
	  Properties p		= (java.util.Properties) session.getValue("jdbc");





//String relationship=request.getParameter("RELATIONSHIP")==null?"":request.getParameter("RELATIONSHIP"); 
//String name=request.getParameter("NAME")==null?"":request.getParameter("NAME"); 
//String job_title=request.getParameter("JOB_TITLE")==null?"":request.getParameter("JOB_TITLE"); 
//String COUNTRY_CODE=request.getParameter("COUNTRY_CODE")==null?"":request.getParameter("COUNTRY_CODE"); 
//String TELEPHONE_OFF=request.getParameter("TELEPHONE_OFF")==null?"":request.getParameter("TELEPHONE_OFF"); 

//String TELEPHONE_RES=request.getParameter("TELEPHONE_RES")==null?"":request.getParameter("TELEPHONE_RES"); 

//String EMAIL_ID=request.getParameter("EMAIL_ID")==null?"":request.getParameter("EMAIL_ID"); 
//String MOB_TEL_NO=request.getParameter("MOB_TEL_NO")==null?"":request.getParameter("MOB_TEL_NO"); 
//String NAT_ID_NO=request.getParameter("NAT_ID_NO")==null?"":request.getParameter("NAT_ID_NO"); 
//String ORGANIZATION_NAME=request.getParameter("ORGANIZATION_NAME")==null?"":request.getParameter("ORGANIZATION_NAME"); 
//String PATIENT_EMPLOYEE_ID1=request.getParameter("PATIENT_EMPLOYEE_ID")==null?"":request.getParameter("PATIENT_EMPLOYEE_ID"); 





  //    String regno		              	 = ""; 
      String JOB1_TITLE              	 = "";	
      String ADDR2_LINE1             	 = "";
      String ADDR2_LINE2            	 =  ""; 
      String ADDR2_LINE3             	 = "" ;
      String ADDR2_LINE4			     =  "";
      String CONTACT1_NAME             	 = ""; 
      String CONTACT3_NAME             	 = ""; 
      String CONTACT1_RELATION           = ""; 
      String CONTACT3_RELATION           = ""; 
	  String CONTACT1_RES_AREA_CODE="";
	  String CONTACT1_REGION_CODE="";
	  String CONTACT1_RES_TOWN_CODE="";
	  String CONTACT1_REGION_CODE3="";
	  String CONTACT1_RES_AREA_CODE3="";
	  String CONTACT1_RES_TOWN_CODE3="";
	  String tel_no1="";
	  String otel_no1="";	
	  String restowncode="";
	  String ecou="";
	  String sq3="";
	  String ocpndesc="";
	  String ocpn_class_desc="";
	  String OCPN_CODE="";
	  String resareacode="";
	  String regioncode="";
      String CONTACT1_NAT_ID_NO          = ""; 
      String tel_no                 	 = ""; 
    //  String tel_no1                 	 = ""; 
      String otel_no                 	 = ""; 
      //String otel_no1                 	 = ""; 
      String email                  	 = ""; 
      String frommo						 = "";		
	  String frommo1					 = "";		
      String postal_code		         = "";  
	  String postal_code1		         = "";
	  String addrl1                      = "";
	  String addrl2                      = "";
	  String addrl3                      = "";
	  String addrl4                      = "";
	  String postalcode                  = "";
	  String orgn                        = "";	  
	  String countrycode                 = "";
 	  String country_code                = "";
	  String country_code1               = "";
	  //String disableVal                  = "";
	  //String disableReadOnly             = "";
	  String name1                       = "";
	  String name2                       = "";
	  //String ctype                       = "";
	  String pid                         = "";
	  //String dob                         = "";
	  //String dsbl                        = "";
	  //String db                          = "";
	  String mobile                      = "";
	 // String JOB3_TITLE                   ="";  
	  String PATIENT_EMPLOYEE_ID         = "";
	  String short_desc                  = "";
	  //String load3                       = "";
	  //String times                       = "";
      String[] contact_col_names	     = null ;
	  String[] contact_prompts			 = null ;
	  String[] contact_fields		     = null ;
       String bodypartframe="";
	   String postaldesc="";
	  //int tabIndex		                 = 1;

	 String kcou ="";

      name1			= checkForNull(request.getParameter("name1"));//claimant type
	  
      name2			= checkForNull(request.getParameter("ctype"));//claimant type
	  bodypartframe      =checkForNull(request.getParameter("bodypart"));//claimant type
      if(bodypartframe.equals("bodypart"))bodypartframe="parent.frames[3]";else 
	  if(bodypartframe.equals("cmgfrmreleasedeas"))bodypartframe="parent.frames[0]";else
	  bodypartframe="parent.frames[3]";
	  //name2			= checkForNull(request.getParameter("value1"));//claimant
      pid			= checkForNull(request.getParameter("pid"));//from moregisterclaimantsearch.jsp
      //regno			= checkForNull(request.getParameter("regno"));//from moregisterclaimantsearch.jsp
     
	  //load3			= checkForNull(request.getParameter("load3"));// ctype value from moregisterclaimantsearch.jsp
      //times			= checkForNull(request.getParameter("ti"));// count from moregisterclaimantsearch.jsp
	
		
		
 
/* End of Dummy Display*/

	 String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};

	 String[] address1_fld_names=	{"addr_line_1","addr_line_2","addr_line_3","addr_line_4","","","","postal_code"};


	 ArrayList contact_addr= fetchContactAddresses(conn,out,"parent.parent.messageFrame",p) ;
	 
	// String Site					= (String)contact_addr.get(0) ;
	 contact_col_names		        = (String[])contact_addr.get(1) ;
	
	 contact_prompts			    = (String[])contact_addr.get(2) ;
     contact_fields			        = (String[])contact_addr.get(3) ;
	 contact_addr				    = null;
     

	// String sqlRelation	 = " select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP "+
						//   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
					//	   " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";
String sql42="";

    sql42="SELECT  NATIONAL_ID_NO,to_char(DATE_OF_BIRTH,'mm/dd/yyyy') dob,ALT_ID1_NO from mp_patient where PATIENT_ID='"+pid+"'";
	
	stmt42 = conn.createStatement();
	rs42=stmt42.executeQuery(sql42);
	while((rs42!=null)&&(rs42.next()))
		{
		 //nid      = checkForNull(rs42.getString("NATIONAL_ID_NO"));
	     //dob      = checkForNull(rs42.getString("dob"));
		 //altid    = checkForNull(rs42.getString("ALT_ID1_NO"));
		}
	  if(rs42!=null) rs42.close();
	  if(stmt42!=null)stmt42.close();
	 	 
	
	if(name1.equals("K"))
	{
			
	 frommo = " select CONTACT1_RELATION, CONTACT1_NAME,JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,ADDR1_LINE3,ADDR1_LINE4,POSTAL1_CODE,COUNTRY1_CODE,OFF1_TEL_NO,RES1_TEL_NO,CONTACT1_EMAIL_ID,CONTACT1_MOB_TEL_NO,CONTACT1_NAT_ID_NO,MODIFIED_FACILITY_ID, CONTACT1_REGION_CODE,CONTACT1_RES_AREA_CODE, CONTACT1_RES_TOWN_CODE from mp_pat_rel_contacts where patient_id='"+pid+"'";
	
	
	     

	stmt = conn.createStatement();
	rs= stmt.executeQuery(frommo);
   		   if(rs!=null && rs.next())
			{
                CONTACT1_REGION_CODE =	checkForNull(rs.getString("CONTACT1_REGION_CODE"));
				CONTACT1_RES_AREA_CODE =checkForNull(rs.getString("CONTACT1_RES_AREA_CODE"));
				CONTACT1_RES_TOWN_CODE =checkForNull(rs.getString("CONTACT1_RES_TOWN_CODE"));

	    		CONTACT1_NAME			= checkForNull(rs.getString("CONTACT1_NAME"));           
				CONTACT1_RELATION		= checkForNull(rs.getString("CONTACT1_RELATION"));
     			addrl1					= checkForNull(rs.getString("ADDR1_LINE1"));
				addrl2					= checkForNull(rs.getString("ADDR1_LINE2"));
     		    addrl3					= checkForNull(rs.getString("ADDR1_LINE3"));
			    addrl4					= checkForNull(rs.getString("ADDR1_LINE4"));
				tel_no                  = checkForNull(rs.getString("RES1_TEL_NO"));
				otel_no                 = checkForNull(rs.getString("OFF1_TEL_NO"));
				mobile					= checkForNull(rs.getString("CONTACT1_MOB_TEL_NO"));
				email					= checkForNull(rs.getString("CONTACT1_EMAIL_ID"));
				postal_code             = checkForNull(rs.getString("POSTAL1_CODE"));
				country_code            = checkForNull(rs.getString("COUNTRY1_CODE"));
				JOB1_TITLE              = checkForNull(rs.getString("JOB1_TITLE"));
		 		CONTACT1_NAT_ID_NO      = checkForNull(rs.getString("CONTACT1_NAT_ID_NO"));
		 		

			 }if(rs!=null) rs.close();
			  if(stmt!=null)stmt.close();

      	

      sq3 = "select short_desc from mp_res_town_lang_vw  where LANGUAGE_ID='"+locale+"' and res_town_code = '"+CONTACT1_RES_TOWN_CODE+"'";
      stmt2= conn.createStatement();
	  rs2 = stmt2.executeQuery(sq3);
	  while(rs2!=null && rs2.next())
	  {
		restowncode=checkForNull(rs2.getString("short_desc"));
	  } 
	  if(rs2!=null) rs2.close();
	  if(stmt2!=null)stmt2.close();
		
   sq3 = "select short_desc from mp_res_area_lang_vw  where LANGUAGE_ID='"+locale+"' and res_area_code = '"+CONTACT1_RES_AREA_CODE+"'";
   stmt2= conn.createStatement();
   rs2 = stmt2.executeQuery(sq3);
		
  while(rs2!=null && rs2.next())
  {
	resareacode=checkForNull(rs2.getString("short_desc"));
  } 
  if(rs2!=null) rs2.close();
  if(stmt2!=null)stmt2.close();
  sq3 = "select short_desc from mp_region_lang_vw where LANGUAGE_ID='"+locale+"' and REGION_CODE = '"+CONTACT1_REGION_CODE+"'";
  stmt2= conn.createStatement();
  rs2 = stmt2.executeQuery(sq3);
  while(rs2!=null && rs2.next())
	{
		regioncode=checkForNull(rs2.getString("short_desc"));
  } 
  if(rs2!=null) rs2.close();
  if(stmt2!=null)stmt2.close();
	
  sq3 = "select short_name from mp_country_lang_vw  where  LANGUAGE_ID='"+locale+"' and country_code = '"+country_code+"'";
  stmt2= conn.createStatement();
  rs2 = stmt2.executeQuery(sq3);
  while(rs2!=null && rs2.next())
	{
		kcou=checkForNull(rs2.getString("short_name"));
	}
	if(rs2!=null) rs2.close();
	if(stmt2!=null)stmt2.close();
				
 String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postal_code};
 String str4 ="select RELATIONSHIP_CODE,short_desc from MP_RELATIONSHIP_lang_vw where LANGUAGE_ID='"+locale+"' and  eff_status='E' order by 2";
 String reln = "";
			
stmt6=conn.createStatement();
rs6 =  stmt6.executeQuery(str4);
int relval=1;

while(rs6.next())
	{
		String Query_Rel_code = rs6.getString("RELATIONSHIP_CODE");
	
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs6.getString("RELATIONSHIP_CODE")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CONTACT1_RELATION));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Query_Rel_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CONTACT1_RELATION));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(relval));
            _bw.write(_wl_block15Bytes, _wl_block15);
relval++;}if(rs6!=null) rs6.close();
			 if(stmt6!=null) stmt6.close();
 		
		
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CONTACT1_RELATION));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(reln));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CONTACT1_NAME));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(JOB1_TITLE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(kcou));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(otel_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(email));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(mobile));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CONTACT1_NAT_ID_NO));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CONTACT1_REGION_CODE));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(CONTACT1_RES_AREA_CODE));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CONTACT1_RES_TOWN_CODE));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(kcou));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block62Bytes, _wl_block62);

		
		for(int i=0;i<contact_col_names.length;i++) 
		{
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
				out.println("<tr>");
				out.println("<td class='LABEL' align='RIGHT' nowrap>"+contact_prompts[i]+"</td>") ;		
				for(int j=0; j<address_col_names.length; j++)
				{
					
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block66Bytes, _wl_block66);
	}
						else
						{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block68Bytes, _wl_block68);
		}
						
					}
				}   
			}
		}
    
            _bw.write(_wl_block69Bytes, _wl_block69);

	
		}else	if(name1.equals("E"))
	{
		 frommo = " select CONTACT3_RELATION,CONTACT3_NAME,OCPN_CODE,JOB3_TITLE,ADDR3_LINE1,ADDR3_LINE2,ADDR3_LINE3,ADDR3_LINE4,POSTAL3_CODE,COUNTRY3_CODE,OFF3_TEL_NO,RES3_TEL_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,CONTACT3_REGION_CODE,CONTACT3_RES_AREA_CODE,CONTACT3_RES_TOWN_CODE from mp_pat_rel_contacts where patient_id='"+pid+"'";
		  
	
	    
		stmt = conn.createStatement();
		rs= stmt.executeQuery(frommo);
   		   if(rs!=null && rs.next())
			{
				CONTACT1_REGION_CODE3	    = checkForNull(rs.getString("CONTACT3_REGION_CODE")); 
		    	CONTACT1_RES_AREA_CODE3		= checkForNull(rs.getString("CONTACT3_RES_AREA_CODE"));
				CONTACT1_RES_TOWN_CODE3		= checkForNull(rs.getString("CONTACT3_RES_TOWN_CODE"));
				OCPN_CODE	                = checkForNull(rs.getString("OCPN_CODE"));
				CONTACT3_NAME			    = checkForNull(rs.getString("CONTACT3_NAME")); 
		    	CONTACT3_RELATION			= checkForNull(rs.getString("CONTACT3_RELATION"));
				ADDR2_LINE1					= checkForNull(rs.getString("ADDR3_LINE1"));
				ADDR2_LINE2					= checkForNull(rs.getString("ADDR3_LINE2"));
				ADDR2_LINE3					= checkForNull(rs.getString("ADDR3_LINE3"));
			    ADDR2_LINE4					= checkForNull(rs.getString("ADDR3_LINE4"));
				tel_no1						= checkForNull(rs.getString("RES3_TEL_NO"));
				otel_no1					= checkForNull(rs.getString("OFF3_TEL_NO"));
				postal_code1				= checkForNull(rs.getString("POSTAL3_CODE"));
				country_code1				= checkForNull(rs.getString("COUNTRY3_CODE"));
				//JOB3_TITLE					= checkForNull(rs.getString("JOB3_TITLE"));
				PATIENT_EMPLOYEE_ID			= checkForNull(rs.getString("PATIENT_EMPLOYEE_ID"));
				orgn						= checkForNull(rs.getString("ORGANIZATION_NAME"));
		 		
			 }if(rs!=null) rs.close();
			  if(stmt!=null) stmt.close();
		

            _bw.write(_wl_block70Bytes, _wl_block70);

		
		
		
		if(!OCPN_CODE.equals(""))
		 {sq3 ="select a.SHORT_DESC ocpn_desc,b.short_desc ocpn_class_desc from mp_occupation_lang_vw a,MP_OCCUPATION_CLASS_lang_vw b where a.LANGUAGE_ID='"+locale+"' AND  a.LANGUAGE_ID=b.LANGUAGE_ID and  a.OCPN_CODE='"+OCPN_CODE+"'and  a.OCPN_CLASS_CODE=b.OCPN_CLASS_CODE";
	   	stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
	   	while(rs2!=null && rs2.next())
		{   
			ocpndesc=checkForNull(rs2.getString("ocpn_desc"));
			ocpn_class_desc=checkForNull(rs2.getString("ocpn_class_desc"));
		}
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(ocpn_class_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
	
		sq3 = "select short_desc from mp_res_area_lang_vw  where LANGUAGE_ID='"+locale+"'  and res_area_code = '"+CONTACT1_RES_AREA_CODE3+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			resareacode=checkForNull(rs2.getString("short_desc"));
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
     sq3 = "select short_desc from mp_res_town_lang_vw  where  LANGUAGE_ID='"+locale+"'  and res_town_code = '"+CONTACT1_RES_TOWN_CODE3+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			restowncode=checkForNull(rs2.getString("short_desc"));
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
        
       sq3 = "select short_desc from mp_region_lang_vw where LANGUAGE_ID='"+locale+"' and REGION_CODE = '"+CONTACT1_REGION_CODE3+"'";
      
		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			regioncode=checkForNull(rs2.getString("short_desc"));
			
			
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
		 
		stmt3= conn.createStatement();
		String sq4 = "select short_name from mp_country_lang_vw where LANGUAGE_ID='"+locale+"' and country_code = '"+country_code1+"'";
		
		rs3 = stmt3.executeQuery(sq4);
		while(rs3!=null && rs3.next())
		{
		  ecou = checkForNull(rs3.getString("short_name"));
		}if(rs3!=null) rs3.close();
		 if(stmt3!=null) stmt3.close(); 
	
		
		String[] address_fld_values1=	{ADDR2_LINE1,ADDR2_LINE2,ADDR2_LINE3,ADDR2_LINE4,"","","",postal_code1};

            _bw.write(_wl_block75Bytes, _wl_block75);
			
			String str4 ="select RELATIONSHIP_CODE,short_desc from MP_RELATIONSHIP_lang_vw where LANGUAGE_ID='"+locale+"' and eff_status='E' order by 2";
			String reln = "";
			
			stmt6=conn.createStatement();
			rs6 =  stmt6.executeQuery(str4);
			int relval=1;
			while(rs6.next())
			{
				String Query_rel_code = rs6.getString("RELATIONSHIP_CODE");

				
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rs6.getString("RELATIONSHIP_CODE")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CONTACT3_RELATION));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Query_rel_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(CONTACT3_RELATION));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(relval));
            _bw.write(_wl_block15Bytes, _wl_block15);
relval++;}if(rs6!=null) rs6.close();
			 if(stmt6!=null) stmt6.close();
			
			
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(CONTACT3_RELATION));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(reln));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CONTACT3_NAME));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ocpndesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(country_code1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ecou));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(otel_no1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tel_no1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(orgn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(PATIENT_EMPLOYEE_ID));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CONTACT1_REGION_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(CONTACT1_RES_AREA_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CONTACT1_RES_TOWN_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
	
		for(int i=0;i<contact_col_names.length;i++) 
		{
			
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
			
				for(int j=0; j<address_col_names.length; j++)
				{

					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values1[j]));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
						else
						{
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values1[j]));
            _bw.write(_wl_block92Bytes, _wl_block92);
}
						
					}
				}   
			}
		}
		
   
		

      
   
	
	}else
	 
	
	{
		 
	 frommo1 = "select SHORT_DESC,ADD_LINE1,ADD_LINE2,ADD_LINE3,ADD_LINE4,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_DESC,COUNTRY_CODE,TEL_NO,EMAIL_ID ,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','2') RES_TOWN_DESC, RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','2') RES_AREA_DESC, REGION_CODE,MP_GET_DESC.MP_REGION(REGION_CODE,'"+locale+"','2') REGION_DESC from mo_claimant_type_vw where claimant_type_code='"+name2+"'";
	
	
	     

	stmt1 = conn.createStatement();
	rs1 = stmt1.executeQuery(frommo1);
		
   	   while( rs1!=null && rs1.next())
			{
			short_desc		 = checkForNull(rs1.getString("short_desc"));
		 	addrl1           = checkForNull(rs1.getString("ADD_LINE1"));
			addrl2           = checkForNull(rs1.getString("ADD_LINE2"));
			addrl3           = checkForNull(rs1.getString("ADD_LINE3"));
			addrl4           = checkForNull(rs1.getString("ADD_LINE4"));
			postalcode		 = checkForNull(rs1.getString("POSTAL_CODE"));
			postaldesc		 = checkForNull(rs1.getString("POSTAL_DESC"));
			countrycode		 = checkForNull(rs1.getString("COUNTRY_CODE"));
		    tel_no			 = checkForNull(rs1.getString("TEL_NO"));
	




		email			 = checkForNull(rs1.getString("email_id"));
			
			CONTACT1_RES_TOWN_CODE3    =checkForNull(rs1.getString("RES_TOWN_CODE"));
			restowncode                =checkForNull(rs1.getString("RES_TOWN_DESC"));
			CONTACT1_RES_AREA_CODE3    =checkForNull(rs1.getString("RES_AREA_CODE"));
			resareacode                =checkForNull(rs1.getString("RES_AREA_DESC"));
			CONTACT1_REGION_CODE3      =checkForNull(rs1.getString("REGION_CODE"));
			regioncode                 =checkForNull(rs1.getString("REGION_DESC"));
			} if(rs1!=null) rs1.close();
			  if(stmt1!=null) stmt1.close();
				
			 String []address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postalcode};
			
		
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(addrl1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(addrl2));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(addrl3));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(addrl4));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(postalcode));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(countrycode));
            _bw.write(_wl_block99Bytes, _wl_block99);

					
		
		for(int i=0;i<contact_col_names.length;i++) 
		{
		
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
				
				
				for(int j=0; j<address_col_names.length; j++)
				{
					
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block101Bytes, _wl_block101);
	}
						else
						{
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(address1_fld_names[j]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(address_fld_values[j]));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
						
					}
				}   
			}
		}
			 sq3 = "select short_name from mp_country_lang_vw  where LANGUAGE_ID='"+locale+"' and  country_code = '"+countrycode+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			kcou=checkForNull(rs2.getString("short_name"));
		}
		      if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
			
			
    
	
/*			short_desc		 = checkForNull(rs1.getString("short_desc"));
		 	addrl1           = checkForNull(rs1.getString("ADD_LINE1"));
			addrl2           = checkForNull(rs1.getString("ADD_LINE2"));
			addrl3           = checkForNull(rs1.getString("ADD_LINE3"));
			addrl4           = checkForNull(rs1.getString("ADD_LINE4"));
			postalcode		 = checkForNull(rs1.getString("POSTAL_CODE"));
			countrycode		 = checkForNull(rs1.getString("COUNTRY_CODE"));
		    tel_no			 = checkForNull(rs1.getString("TEL_NO"));
			email			 = checkForNull(rs1.getString("email_id"));*/

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(countrycode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(kcou));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(email));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CONTACT1_REGION_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(CONTACT1_RES_AREA_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CONTACT1_RES_TOWN_CODE3));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(regioncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resareacode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(restowncode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(CONTACT1_REGION_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(CONTACT1_RES_AREA_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(CONTACT1_RES_TOWN_CODE3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(postalcode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(bodypartframe));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(postaldesc));
            _bw.write(_wl_block118Bytes, _wl_block118);

		//}
	}
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(k));
            _bw.write(_wl_block120Bytes, _wl_block120);

	  if(rs != null) rs.close();
      if(stmt != null) stmt.close();
	  if(rs2!=null) rs2.close();
	  if(stmt2!=null)stmt2.close();
	  if(rs1!=null) rs1.close();
	  if(stmt1!=null) stmt1.close();
	  if(rs6!=null) rs6.close();
	  if(stmt6!=null) stmt6.close();
	  if(rs3!=null) rs3.close();
	  if(stmt3!=null) stmt3.close();
	  if(rs42!=null) rs42.close();
	  if(stmt42!=null)stmt42.close();
	 }
catch(Exception e) 
{
	out.println("Exception in File MORegisterClaimantResult"+e.toString());
	e.printStackTrace();
}
finally
{
  
   ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
