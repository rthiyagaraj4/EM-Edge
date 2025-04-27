package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.eslp.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recordpatientadverseeventsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEventsearch.jsp", 1740388239825L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<head>\n\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\' ></script>\n<!--   <script language=\'javascript\' src=\'../../eMR/js/eMRmessages.js\' ></script> -->\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n  <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n  <script language=\"javascript\" src=\"../../eMP/js/PatEncBanner.js\"></script>\n   <!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->\n  <script language=\'javascript\' src=\'../../eMR/js/AllergenLookup.js\'></script>\n\n  <script>\n function enable_Allergy(obj,allergen_code){\n\t document.forms[0].reaction_code.value=\" \";\n\t document.forms[0].reaction.value=\"\";\n\t document.forms[0].allergen_code.value=document.forms[0].allergen.value;\n\t document.forms[0].reaction_code.value=document.forms[0].reaction.value;\n\t\n\n  }\n  \n  function serach_Allergy(){\n\t   \t//parent.frames[1].document.forms[0].all.header_part.style.display=\"visible\";\n\t  \tvar eventType=document.getElementById(\"eventType\").value;\n\t  \tvar allergen=document.getElementById(\"allergen\").value;\n\t  \tvar status=document.getElementById(\"status\").value;\n\t  \tvar reaction=document.getElementById(\"reaction\").value;\n\t  \tvar PatientId=document.getElementById(\"PatientId\").value;\n\n\t  \tvar allergen_code=document.getElementById(\"allergen_code\").value;\n\t  \tvar reaction_code=document.getElementById(\"reaction_code\").value;\n\t   \n\t  \t/* if(eventType == \"\" )\n\t\t\t{\n\t\t\t\n\t   \t}*/\n\t  \t//search(eventType,allergen,status,reaction)\n\t  \tvar sPhInstalled_YN=document.getElementById(\"sPhInstalled_YN\").value; // Modified against TTM-SCF-0107 - Passing phInstalled Parameter\n\t  \tvar url=\"../../eMR/jsp/RecordPatientAdverseEvent4.jsp?modeResult=result&reac_code_val=\"+reaction_code+\"&eventType_val=\"+eventType+\"&allergen_val=\"+allergen_code+\"&status_val=\"+status+\"&PatientId=\"+PatientId+\"&allergen_desc=\"+allergen+\"&reaction_desc=\"+reaction+\"&norecord=noreords&sPhInstalled_YN=\"+sPhInstalled_YN;\n\t\tparent.resultpage1.location.href=url;\n  }\n\n  /*Modified by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/\n  function   search_result_blr(obj,target){\n\t  if(obj.value!=\"\"){\n\t\t\tvar facility_id = document.getElementById(\"facility_id\").value;\n\t\t\tvar isExtGenericAppl = document.getElementById(\"isExtGenericAppl\").value;\n\t\t\tvar eventType = document.getElementById(\"eventType\").value;\n\t\t\tvar sPhInstalled_YN = document.getElementById(\"sPhInstalled_YN\").value;\n\t\t\tvar xmlDoc=\"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr = \"<root><SEARCH facility_id=\\\"\"+facility_id+\"\\\" action=\'getDrugCnt\'/></root>\"\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"../../eMR/jsp/MRIntermediate.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText = xmlHttp.responseText\n\t\t\tvar drug_cnt = trimString(responseText);\n\n\t\t\tif(eventType ==\'DA\' && drug_cnt > 0 && sPhInstalled_YN == \"Y\" && isExtGenericAppl == \"true\")\n\t\t\t{\n\t\t\t\tcallAllergenSearch(obj,target);\n\t\t\t}else\n\t\t\t{\n\t\t\t\tsearch_result(obj,target);\n\t\t\t}\n\t  }\n  }\n\n  /*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/\n  function invokeAllergenLookup(obj,target)\n  {\n\tvar facility_id = document.getElementById(\"facility_id\").value;\n\tvar isExtGenericAppl = document.getElementById(\"isExtGenericAppl\").value;\n\tvar eventType = document.getElementById(\"eventType\").value;\n\tvar sPhInstalled_YN = document.getElementById(\"sPhInstalled_YN\").value;\n\tvar xmlDoc=\"\"\n\tvar xmlHttp = new XMLHttpRequest()\n\txmlStr = \"<root><SEARCH facility_id=\\\"\"+facility_id+\"\\\" action=\'getDrugCnt\'/></root>\"\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\txmlHttp.open(\"POST\",\"../../eMR/jsp/MRIntermediate.jsp\",false)\n\txmlHttp.send(xmlDoc)\n\tresponseText = xmlHttp.responseText\n\tvar drug_cnt = trimString(responseText);\n\n\tif(eventType ==\'DA\' && drug_cnt > 0 && sPhInstalled_YN == \"Y\" && isExtGenericAppl == \"true\")\n\t{\n\t\tcallAllergenSearch(obj,target);\n\t}else\n\t{\n\t\tsearch_result(obj,target);\n\t}\n  }\n\n  async function callAllergenSearch(obj,target){\n \t\tvar eventType = document.getElementById(\"eventType\").value\n\t\tvar retVal = new String();\n\t\tvar locale = document.getElementById(\"locale\").value;\n\t\tvar argumentArray  = new Array() ;\n\t\tvar dataNameArray  = new Array() ;\n\t\tvar dataValueArray = new Array() ;\n\t\tvar dataTypeArray  = new Array() ;\n\t\tvar target = \"\";\n\t\tvar sql = \"\";\n\n\t\t if((document.getElementById(\"eventType\").value!=null)&&(document.getElementById(\"eventType\").value!=\'\'))\n\t\t {\n\t\t\t\t\n\t\t\tvar sql = \"SELECT a.generic_id code, a.generic_name description, b.thirdparty_type thirdparty_type FROM ph_generic_name_lang_vw a, ph_generic_ext_prod_ref b WHERE a.generic_id = b.generic_id AND UPPER (a.generic_id) LIKE UPPER (?) AND UPPER (LTRIM (a.generic_name, \'*\')) LIKE UPPER (?) AND UPPER (b.thirdparty_type) LIKE UPPER (?) AND a.eff_status = \'E\' AND b.eff_status = \'E\' AND b.product_id = \'CIMS\' AND a.language_id = \'\"+locale+\"\'\";\n\t\t\t\t\n\t\t\targumentArray[0] = sql ;\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = document.getElementById(\"allergen\").value;\n\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t\n\t\t\tvar arr=new Array();\n\n\t\t\tretVal = await AllergenLookup(getLabel(\"eMR.ExtGenLinkLookup.label\",\"MR\"), argumentArray);\n\n\t\t\tif (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t\t{\n\t\t\t\tvar retVal=unescape(retVal);\n\t\t\t\tarr=retVal.split(\",\");\n\t\t\t\tdocument.getElementById(\"allergen\").value=arr[1];\n\t\t\t\tdocument.getElementById(\"allergen_code\").value=arr[0];\n\t\t\t\tdocument.getElementById(\"reaction\").disabled=false;\n\t\t\t\tdocument.getElementById(\"reaction_dec\").disabled=false;\n\t\t\t}else\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"allergen\").value=\"\";\n\t\t\t\tdocument.getElementById(\"allergen_code\").value=\"\";\n\t\t\t\tdocument.getElementById(\"reaction\").disabled=true;\n\t\t\t\tdocument.getElementById(\"reaction_dec\").disabled=true;\n\t\t\t}\n\t\t\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\t\t\tdocument.getElementById(\"reaction_code\").value=\"\";\n\t\t}\n  }\n  /*End GHL-CRF-0614.1*/\n\n async  function search_result(obj,target){\n \n\t\t\tvar eventType=document.getElementById(\"eventType\").value\n\t\t\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar locale= document.getElementById(\"locale\").value;\n\n\t\t var argumentArray  = new Array() ;\n\t\tvar dataNameArray  = new Array() ;\n\t\tvar dataValueArray = new Array() ;\n\t\tvar dataTypeArray  = new Array() ;\n\t\tvar target=\"\";\n\t\tvar sql=\"\";\n\n\t\t if((obj.name==\"drug_search\"||obj.name==\"allergen\")&&(document.getElementById(\"eventType\").value!=null)&&(document.getElementById(\"eventType\").value!=\'\'))\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(eventType ==\'DA\' )\n\t\t\t\t{\n\t\t\t\t \n\t\t\t\t// sql=\"select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW UNION select ALLERGEN_CODE code, LONG_DESC || \'**\' description  from  MR_ALLERGEN_LANG_VW  where  LANGUAGE_ID=\'\"+locale+\"\' and ADV_EVENT_TYPE_CODE=\'\"+eventType+\"\') where upper(code) like upper(?) and upper(ltrim(description,\'*\')) like upper(?) \";\n\t\t\t\t// sql=\"select code, description from (SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW UNION select ALLERGEN_CODE code, LONG_DESC || \'**\' description  from  MR_ALLERGEN_LANG_VW  where  LANGUAGE_ID=\'\"+locale+\"\') where upper(code) like upper(?) and upper(ltrim(description,\'*\')) like upper(?) \"; \n\t\t\t\t\t//sql = \"select GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW LANGUAGE_ID=\'\"+locale+\"\' and upper(GENERIC_ID) like upper(?) and upper(GENERIC_NAME) like upper(?)\";\n\t\t\t\t\t\n\t\t\t\t//Above SQL is changed to remove ** for against TTM-SCF-0107 - Start\n\t\t\t\tvar sPhInstalled_YN=document.getElementById(\"sPhInstalled_YN\").value;\n\t\t\t\tvar sql =\"\";\n\t\t\t\tif(sPhInstalled_YN == \"Y\")\n\t\t\t\t\tsql=\"SELECT GENERIC_ID code, GENERIC_NAME description FROM PH_GENERIC_NAME_LANG_VW WHERE upper(generic_id) like upper(?) AND upper(ltrim(generic_name,\'*\')) like upper(?) AND EFF_STATUS=\'E\' AND language_id = \'\"+locale+\"\'\";\n\t\t\t\telse\n\t\t\t\t\tsql = \"select ALLERGEN_CODE code, LONG_DESC description  from  MR_ALLERGEN_LANG_VW  where upper(ALLERGEN_CODE) like upper(?) AND upper(ltrim(LONG_DESC,\'*\')) like upper(?) AND LANGUAGE_ID=\'\"+locale+\"\'  AND EFF_STATUS=\'E\' \";\n\t\t\t\t//Modified against TTM-SCF-0107 - end\t\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\t//sql  = \"select ALLERGEN_CODE code ,LONG_DESC description  from  MR_ALLERGEN_lang_vw where language_id=\'\"+locale+\"\' and ADV_EVENT_TYPE_CODE = \'\"+eventType+\"\' AND upper(ALLERGEN_CODE) like upper(?) and upper(LONG_DESC) like upper(?)\";\n\t\t\t\t//sql  = \"select ALLERGEN_CODE code ,LONG_DESC description  from  MR_ALLERGEN_lang_vw where language_id=\'\"+locale+\"\'  AND upper(ALLERGEN_CODE) like upper(?) and upper(LONG_DESC) like upper(?)\";\n\n\t\t\t\tsql  = \"select b.ALLERGEN_CODE code ,b.LONG_DESC description  from  MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b, MR_ADV_EVENT_TYPE c where  c.ADV_EVENT_TYPE_CODE=\'\"+eventType+\"\' and b.language_id=\'\"+locale+\"\' and b.ADV_EVENT_TYPE_IND=a.ADV_EVENT_TYPE_IND  and c.ADV_EVENT_TYPE_CODE = b.ADV_EVENT_TYPE_CODE and upper(b.ALLERGEN_CODE) like upper(?) and upper(b.LONG_DESC) like upper(?)   Order by b.LONG_DESC \";\n\t\t\t\t}\n\t\t\t\t\n\n\t\t\targumentArray[0] = sql ;\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = document.getElementById(\"allergen\").value;\n\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\targumentArray[7] = CODE_DESC ;\n\t\t\t//alert(argumentArray[4]);\n\t\t\t//alert(argumentArray[5]);\n\t\t\tvar arr=new Array();\n\t\t\tif(eventType ==\'DA\' ){  \n\t\t\t retVal = await CommonLookup( getLabel(\"Common.GenericNameLookup.label\",\"Common\"), argumentArray );\n\t\t\t}\n\t\t\telse{\n\t\t\tretVal = await CommonLookup( getLabel(\"eMR.Allergen.label\",\"MR\"), argumentArray );\n\t\t\t}\n\t\tif (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\",\");\n\t\t\tdocument.getElementById(\"allergen\").value=arr[1];\n\t\t\tdocument.getElementById(\"allergen_code\").value=arr[0];\n\t\t\tdocument.getElementById(\"reaction\").disabled=false;\n\t\t\tdocument.getElementById(\"reaction_dec\").disabled=false;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\tdocument.getEl";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="ementById(\"allergen\").value=\"\";\n\t\t\tdocument.getElementById(\"allergen_code\").value=\"\";\n\t\t\tdocument.getElementById(\"reaction\").disabled=true;\n\t\t\tdocument.getElementById(\"reaction_dec\").disabled=true;\n\t\t}\n\t\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\t\tdocument.getElementById(\"reaction_code\").value=\"\";\n\t\t\n\t\t\t}\n\n\t\n\tif((obj.name==\"reaction_dec\"||obj.name==\"reaction\")&&(document.getElementById(\"allergen_code\").value!=null)&&(document.getElementById(\"allergen_code\").value!=\'\')&&(document.getElementById(\"allergen\").value!=null)&&(document.getElementById(\"allergen\").value!=\'\'))\n\t\t\t{\n\t\t\t\t\n\t\t\tvar allergen=document.getElementById(\"allergen_code\").value;\n\t\t\tsql=\"select distinct (a.REACTION_CODE) code,a.LONG_DESC description from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b  where a.REACTION_CODE=b.ADV_REAC_CODE and b.ALLERGEN_CODE=\'\"+allergen+\"\' and a.language_id=\'\"+locale+\"\' and a.eff_status=\'E\' and upper(a.REACTION_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?) \";\n\t\t\targumentArray[0] = sql ;\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = document.getElementById(\"reaction\").value;\n\t\t\targumentArray[6] = CODE_LINK ;\n\t\t\targumentArray[7] = CODE_DESC ; \n\t\t\tvar arr=new Array();\n\t\t\tretVal = await CommonLookup(getLabel(\"eMR.ReactionSearch.label\",\"mr\"), argumentArray );\n\t\tif (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\",\");\n\n\t\t\tdocument.getElementById(\"reaction\").value=arr[1];\n\t\t\tdocument.getElementById(\"reaction_code\").value=arr[0];\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\t\tdocument.getElementById(\"reaction_code\").value=\"\";\n\t\t}\n\t\t\n\t\t\t}\n\n\n  }\nfunction clear_serach_Allergy()\n{\n\tdocument.getElementById(\"eventType\").value=\"\";\n\tdocument.getElementById(\"allergen\").value=\"\";\n\tdocument.getElementById(\"status\").value=\"A\";\n\tdocument.getElementById(\"reaction\").value=\"\";\n\t//10/14/2008\n\tdocument.getElementById(\"allergen_code\").value=document.getElementById(\"allergen\").value;\n\tdocument.getElementById(\"reaction_code\").value=document.getElementById(\"reaction\").value;\n\t//10/14/2008\n\t//parent.frames[1].location.href = \'../../eCommon/html/blank.html\';\n\t//parent.frames[1].location.reload();\n\tif(parent.window[1].document.chk_val.max_record.value != \'0\')\n\t{\n\t\tvar url=\"../../eMR/jsp/RecordPatientAdverseEvent4.jsp?load=load\";\n\t\tparent.frames[1].location.href=url;\n\t\tclearAll()\n\t}\n\n}\nfunction clearAll(){\ndocument.getElementById(\"allergen\").disabled=true;\ndocument.getElementById(\"reaction\").disabled=true;\ndocument.getElementById(\"drug_search\").disabled=true;\ndocument.getElementById(\"reaction_dec\").disabled=true;\nserach_Allergy();\n\n}\nfunction populate_AR(obj){\n\tvar adv_evnt_code1=obj.value;\n\n\tif(adv_evnt_code1 !=\"\"){\n\t\t\n\t\tdocument.getElementById(\"allergen\").value=\"\";\n\t\t\n\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\tdocument.getElementById(\"allergen\").disabled=false;\n\t\tdocument.getElementById(\"reaction\").disabled=true;\n\t\tdocument.getElementById(\"drug_search\").disabled=false;\n\t\tdocument.getElementById(\"reaction_dec\").disabled=true;\n\t\tdocument.getElementById(\"status\").value=\"A\";\n\t\tdocument.getElementById(\"allergen_code\").value=document.getElementById(\"allergen\").value;\n\t\tdocument.getElementById(\"reaction_code\").value=document.getElementById(\"reaction\").value;\n\n\t}\n\telse{\n\t\t\n\t\tdocument.getElementById(\"allergen\").value=\"\";\n\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\tdocument.getElementById(\"allergen\").disabled=true;\n\t\tdocument.getElementById(\"reaction\").disabled=true;\n\t\tdocument.getElementById(\"drug_search\").disabled=true;\n\t\tdocument.getElementById(\"reaction_dec\").disabled=true;\n\t\tdocument.getElementById(\"status\").value=\"A\";\n\t\t\n\t}\n\t\n\n}\nfunction clear_reaction(obj){\n\t\n\tif(obj.value==\"\")\n\t\tdocument.getElementById(\"reaction_code\").value=\"\";\n}\nfunction clear_allergy(obj){\n\tif(obj.value==\"\"){\n\t\tdocument.getElementById(\"reaction\").value=\"\";\n\t\tdocument.getElementById(\"reaction\").disabled=true;\n\t\tdocument.getElementById(\"reaction_dec\").disabled=true;\n\t\tdocument.getElementById(\"reaction_code\").value=\"\";\n\t\tdocument.getElementById(\"allergen_code\").value=\"\";\n\n\t}\n}\n\n  </script>\n  \n\n</head>\n";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n\n  <body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n \n\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\" >\n\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </table>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<form name = \'record_patientAdverse\' >\n\t<input type=\'hidden\' name = \'sPhInstalled_YN\' id= \'sPhInstalled_YN\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'> <!-- against TTM-SCF-0107 -->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\" >\n\t\t<th align=\'left\' color=\'#000066\'  nowrap><b><font color = \'black\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></b></th> </table>\n\t\t <br>\n\t\t <table border=\"0\">\n\t\t <tr>\n\t\t <td  class=\'label\' width=\'250px\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t </td>\n\t\t <td  class=\'label\' width=\"3px\">\n\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t  </td>\n\t  <td width=\"3px\"><input type=\"radio\" id=\"Allergy_Yes\" name=\"AllergyYes\" id=\"AllergyYes\" onclick=\"checkAllergyYes(this);\"/></td>\n\t  \n\t  <!-- <td>&nbsp;</td> -->\n\t  <td  class=\'label\' width=\"3px\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t  </td>\n\t  <td width=\"50px\"><input type=\"radio\" id=\"Allergy_No\" name=\"AllergyNo\" id=\"AllergyNo\" checked onclick=\"checkAllergyNo(this);\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'adv_code\' ></img></td>\n\t  \n\t\t </tr></table>\n\t\t  <input type=\"hidden\" name=\"AllergyConfirmYN\" id=\"AllergyConfirmYN\" value=\"N\"/>\n\t\t  \n\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></b></th> </table>\n\t\t <br>\n\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t  \n\n\t<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t<th align=\'left\'  nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t</table>\n\n\n\t<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t<th align=\'left\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t</table>\n\n\n\t<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'10%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</td>\n\n\t\t\t<td class=\'fields\'  width=\'10%\' >\n\t\t\t<select name=\'eventType\' id=\'eventType\' onchange=\'populate_AR(this)\'>\n\t\t\t<option value=\'\'  align=center>-----------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="---------</option>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<input type=\'hidden\' name=\'event_type\' id=\'event_type\' value=\'\'>\n\t</td>\n\t\t\t\n\t\t\t<td   class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</td>\n\t\t\t<!-- onBlur=\'enable_Allergy(this,allergen_code)\' -->\n\t\t\t\n\t\t\t<td class=\'fields\' width=\'15%\'>\n\t\t\t<input type=\'text\' name=\'allergen\' id=\'allergen\' size=\'15\' maxlength=\'30\' disabled onBlur=\'search_result_blr(this,allergen);clear_allergy(this)\' ><input type=\'button\' class=\'BUTTON\' name=\'drug_search\' id=\'drug_search\' value=\'?\' class=\'button\'  onClick=\'invokeAllergenLookup(this,allergen)\' disabled><input type=\'hidden\' name=\'allergen_code\' id=\'allergen_code\' value=\'\'></td>\n\n\t\t\t\n\n\t\t\t\n\n\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </td>\n\n\t\t\t<td class=\'fields\' width=\"5%\">\n\t\t\t<SELECT name=\"status\" id=\"status\" value=\' \'>\n\t\t\t\n\t\t\t<option value=\'A\' selected>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t\t\t</SELECT><input type=\'hidden\' name=\'status_code\' id=\'status_code\' value=\'\'>\n\t\t\t</td>\n\n\t\t\t<td class=\'label\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\n\n\t\t\t <td class=\'fields\' width=\'15%\'>\n\t\t\t<input type=\'text\' name=\'reaction\' id=\'reaction\' disabled onBlur=\'search_result_blr(this,reaction);clear_reaction(this)\'  size=\'15\' maxlength=\'40\'><input type=\'button\' class=\'BUTTON\' name=\'reaction_dec\' id=\'reaction_dec\' value=\'?\' class=\'button\' onClick=\'search_result(this,reaction)\'  disabled><input type=\'hidden\' name=\'reaction_code\' id=\'reaction_code\' value=\'\'></td>\n\t\t\t\n\t\t</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'5%\' align=\'right\' \tid=\'allbuttons\'>\n\n\n <td class=\'white\' width=\'88%\'> <input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  class=\"BUTTON\" onclick=\'serach_Allergy()\'>\n\t  </td>\n\t  <td class=\'white\' width=\'2%\'>&nbsp;</td>\n\t  <td class=\'white\' width=\'10%\'>\n\t  <input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  class=\"BUTTON\" onclick=\'clear_serach_Allergy()\'></td>\n</tr>\n</table>\n\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value =\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value =\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\"hidden\" name=\"isExtGenericAppl\" id=\"isExtGenericAppl\" value =\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

	//String sel="";
	String Encounter_Id=request.getParameter("Encounter_Id");
	String sPhInstalled_YN = request.getParameter("sPhInstalled_YN"); //against TTM-SCF-0107
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String CA=request.getParameter("CA")==null?"":request.getParameter("CA");
	String allergy_conf_reqd_yn=request.getParameter("allergy_conf_reqd_yn")==null?"N":request.getParameter("allergy_conf_reqd_yn");
	Connection con = ConnectionManager.getConnection(request);
	 ResultSet rs = null;
	Statement stmt = null;
	String PatientId=" ";

	Boolean isExtGenericAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_THIRDPARTY_TYPE_APPL");//Added by Ashwini on 13-May-2020 for GHL-CRF-0614.1

	try{
		 PatientId=request.getParameter("PatientId");
		if(PatientId ==null) PatientId="";
		//out.println("<script>alert(\""+PatientId+"\");</script>");
		stmt=con.createStatement();

            _bw.write(_wl_block7Bytes, _wl_block7);

	if(!CA.equals("Y")){
		  
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Facility_Id"), weblogic.utils.StringUtils.valueOf(facility_id
                        )},{ weblogic.utils.StringUtils.valueOf("EncounterId"), weblogic.utils.StringUtils.valueOf(Encounter_Id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block10Bytes, _wl_block10);
}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sPhInstalled_YN));
            _bw.write(_wl_block12Bytes, _wl_block12);
/* Added for the CRF - RUT-CRF-0064 -- Begin*/
	if(allergy_conf_reqd_yn.equals("Y")){ 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}/*Added for the CRF - RUT-CRF-0064 -- End*/
	if(!CA.equals("Y")){
		  
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
	  
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

			
						String sql1="Select long_desc ,ADV_EVENT_TYPE_CODE  from MR_ADV_EVENT_TYPE_LANG_VW where language_id='"+locale+"' and EFF_STATUS='E'";
						rs=stmt.executeQuery(sql1);
						if(rs !=null)
							{
								while(rs.next())
								{
									String adv_event_code=rs.getString("ADV_EVENT_TYPE_CODE");
									String adv_event_code_desc=rs.getString("long_desc");
									out.println("<option value='"+adv_event_code+"'>"+adv_event_code_desc);
								}
							}
							
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	catch(Exception e)
		{
			//out.println("exp :" +e);
			e.printStackTrace();
		}
		finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

			
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(isExtGenericAppl));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AllergyConfirmation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PatientDrugAllergy.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdverseEvents.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdeverseEventsAllgSens.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergen.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InError.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Resolved.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reaction.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
